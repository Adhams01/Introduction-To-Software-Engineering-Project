/**
 * HMS Web GUI — calls same REST APIs as Postman (Deliverable 5 bonus).
 */
(function () {
    const toastEl = document.getElementById("toast");
    let toastTimer;

    function showToast(message, isError) {
        toastEl.textContent = message;
        toastEl.className = "toast visible " + (isError ? "err" : "ok");
        clearTimeout(toastTimer);
        toastTimer = setTimeout(() => {
            toastEl.classList.remove("visible");
        }, 4500);
    }

    async function api(method, path, body) {
        const opts = { method, headers: {} };
        if (body !== undefined) {
            opts.headers["Content-Type"] = "application/json";
            opts.body = JSON.stringify(body);
        }
        const res = await fetch(path, opts);
        const text = await res.text();
        let data = null;
        if (text) {
            try {
                data = JSON.parse(text);
            } catch {
                data = text;
            }
        }
        if (!res.ok) {
            const msg =
                data && typeof data === "object"
                    ? data.message || data.error || JSON.stringify(data)
                    : res.status + " " + res.statusText;
            const err = new Error(msg);
            err.status = res.status;
            err.body = data;
            throw err;
        }
        return { status: res.status, data };
    }

    function switchPanel(name) {
        document.querySelectorAll(".panel").forEach((p) => p.classList.remove("active"));
        document.querySelectorAll(".tab").forEach((t) => t.classList.remove("active"));
        const panel = document.getElementById("panel-" + name);
        if (panel) panel.classList.add("active");
        const tab = document.querySelector('.tab[data-panel="' + name + '"]');
        if (tab) tab.classList.add("active");
    }

    document.querySelectorAll(".tab").forEach((btn) => {
        btn.addEventListener("click", () => switchPanel(btn.dataset.panel));
    });

    async function updateStats() {
        const [p, d, a] = await Promise.all([
            api("GET", "/api/patients"),
            api("GET", "/api/doctors"),
            api("GET", "/api/appointments"),
        ]);
        document.getElementById("stat-patients").textContent = Array.isArray(p.data)
            ? p.data.length
            : "0";
        document.getElementById("stat-doctors").textContent = Array.isArray(d.data)
            ? d.data.length
            : "0";
        document.getElementById("stat-appointments").textContent = Array.isArray(a.data)
            ? a.data.length
            : "0";
    }

    document.getElementById("btn-refresh-dashboard").addEventListener("click", async () => {
        try {
            await updateStats();
            showToast("Dashboard refreshed", false);
        } catch (e) {
            showToast("Dashboard: " + e.message, true);
        }
    });

    function escapeHtml(s) {
        if (!s) return "";
        return String(s)
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;");
    }

    function rowPatient(p) {
        return (
            "<tr><td>" +
            p.id +
            "</td><td>" +
            escapeHtml(p.name) +
            "</td><td>" +
            escapeHtml(p.email) +
            "</td><td>" +
            escapeHtml(p.phone || "") +
            "</td><td>" +
            escapeHtml(p.gender || "—") +
            "</td></tr>"
        );
    }

    async function loadPatients() {
        const { data } = await api("GET", "/api/patients");
        const tb = document.getElementById("tbody-patients");
        tb.innerHTML = (data || []).map(rowPatient).join("") || "<tr><td colspan='5'>No patients</td></tr>";
    }

    document.getElementById("btn-reload-patients").addEventListener("click", () => {
        loadPatients().then(() => showToast("Patients loaded", false)).catch((e) => showToast(e.message, true));
    });

    document.getElementById("form-patient").addEventListener("submit", async (ev) => {
        ev.preventDefault();
        const f = ev.target;
        const body = {
            name: f.name.value.trim(),
            email: f.email.value.trim(),
            phone: f.phone.value.trim(),
        };
        const bd = f.birthDate.value.trim();
        const g = f.gender.value;
        if (bd) body.birthDate = bd;
        if (g) body.gender = g;
        try {
            await api("POST", "/api/patients", body);
            f.reset();
            await loadPatients();
            await updateStats();
            showToast("Patient created", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("btn-update-patient").addEventListener("click", async () => {
        const f = document.getElementById("form-patient-mutate");
        const id = f.id.value;
        const body = {};
        if (f.name.value.trim()) body.name = f.name.value.trim();
        if (f.email.value.trim()) body.email = f.email.value.trim();
        if (f.phone.value.trim()) body.phone = f.phone.value.trim();
        if (f.birthDate.value.trim()) body.birthDate = f.birthDate.value.trim();
        if (f.gender.value) body.gender = f.gender.value;
        if (Object.keys(body).length === 0) {
            showToast("Fill at least one field to update", true);
            return;
        }
        try {
            await api("PUT", "/api/patients/" + id, body);
            await loadPatients();
            await updateStats();
            showToast("Patient " + id + " updated", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("btn-delete-patient").addEventListener("click", async () => {
        const id = document.getElementById("form-patient-mutate").id.value;
        if (!confirm("Delete patient " + id + "?")) return;
        try {
            await api("DELETE", "/api/patients/" + id);
            await loadPatients();
            await updateStats();
            showToast("Patient deleted", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    function rowDoctor(d) {
        return (
            "<tr><td>" +
            d.id +
            "</td><td>" +
            escapeHtml(d.name) +
            "</td><td>" +
            escapeHtml(d.specialty) +
            "</td><td>" +
            escapeHtml(d.email) +
            "</td><td>" +
            (d.available ? "Yes" : "No") +
            "</td></tr>"
        );
    }

    async function loadDoctors() {
        const { data } = await api("GET", "/api/doctors");
        const tb = document.getElementById("tbody-doctors");
        tb.innerHTML = (data || []).map(rowDoctor).join("") || "<tr><td colspan='5'>No doctors</td></tr>";
    }

    document.getElementById("btn-reload-doctors").addEventListener("click", () => {
        loadDoctors().then(() => showToast("Doctors loaded", false)).catch((e) => showToast(e.message, true));
    });

    document.getElementById("form-doctor").addEventListener("submit", async (ev) => {
        ev.preventDefault();
        const f = ev.target;
        const body = {
            name: f.name.value.trim(),
            email: f.email.value.trim(),
            phone: f.phone.value.trim(),
            specialty: f.specialty.value.trim(),
            available: f.available.checked,
        };
        try {
            await api("POST", "/api/doctors", body);
            f.reset();
            f.available.checked = true;
            await loadDoctors();
            await updateStats();
            showToast("Doctor created", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("btn-delete-doctor").addEventListener("click", async () => {
        const id = document.getElementById("form-doctor-delete").id.value;
        if (!confirm("Delete doctor " + id + "?")) return;
        try {
            await api("DELETE", "/api/doctors/" + id);
            await loadDoctors();
            await updateStats();
            showToast("Doctor deleted", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    function rowAppointment(x) {
        return (
            "<tr><td>" +
            x.id +
            "</td><td>" +
            x.patientId +
            "</td><td>" +
            x.doctorId +
            "</td><td>" +
            escapeHtml(x.date) +
            "</td><td>" +
            escapeHtml(x.timeSlot) +
            "</td><td>" +
            escapeHtml(x.status || "") +
            "</td></tr>"
        );
    }

    async function loadAppointments() {
        const { data } = await api("GET", "/api/appointments");
        const tb = document.getElementById("tbody-appointments");
        tb.innerHTML =
            (data || []).map(rowAppointment).join("") ||
            "<tr><td colspan='6'>No appointments</td></tr>";
    }

    document.getElementById("btn-reload-appointments").addEventListener("click", () => {
        loadAppointments()
            .then(() => showToast("Appointments loaded", false))
            .catch((e) => showToast(e.message, true));
    });

    document.getElementById("form-appointment").addEventListener("submit", async (ev) => {
        ev.preventDefault();
        const f = ev.target;
        const body = {
            patientId: Number(f.patientId.value),
            doctorId: Number(f.doctorId.value),
            date: f.date.value.trim(),
            timeSlot: f.timeSlot.value.trim(),
        };
        const r = f.reason.value.trim();
        if (r) body.reason = r;
        try {
            await api("POST", "/api/appointments", body);
            f.reset();
            await loadAppointments();
            await updateStats();
            showToast("Appointment created", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("btn-update-appointment").addEventListener("click", async () => {
        const f = document.getElementById("form-appointment-mutate");
        const id = f.id.value;
        const body = {
            patientId: Number(f.patientId.value),
            doctorId: Number(f.doctorId.value),
            date: f.date.value.trim(),
            timeSlot: f.timeSlot.value.trim(),
        };
        const r = f.reason.value.trim();
        if (r) body.reason = r;
        try {
            await api("PUT", "/api/appointments/" + id, body);
            await loadAppointments();
            await updateStats();
            showToast("Appointment " + id + " updated", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("btn-delete-appointment").addEventListener("click", async () => {
        const id = document.getElementById("form-appointment-mutate").id.value;
        if (!confirm("Delete appointment " + id + "?")) return;
        try {
            await api("DELETE", "/api/appointments/" + id);
            await loadAppointments();
            await updateStats();
            showToast("Appointment deleted", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    document.getElementById("form-composite").addEventListener("submit", async (ev) => {
        ev.preventDefault();
        const f = ev.target;
        const body = {
            patientId: Number(f.patientId.value),
            doctorId: Number(f.doctorId.value),
            date: f.date.value.trim(),
            timeSlot: f.timeSlot.value.trim(),
        };
        const r = f.reason.value.trim();
        if (r) body.reason = r;
        try {
            const res = await api("POST", "/api/composite/book-appointment", body);
            const wrap = document.getElementById("composite-result-wrap");
            const pre = document.getElementById("composite-result");
            pre.textContent = JSON.stringify(res.data, null, 2);
            wrap.hidden = false;
            await loadAppointments();
            await updateStats();
            showToast("Composite booking succeeded (201)", false);
        } catch (e) {
            showToast(e.message, true);
        }
    });

    Promise.all([loadPatients(), loadDoctors(), loadAppointments(), updateStats()]).catch((e) =>
        showToast("Initial load: " + e.message, true)
    );
})();
