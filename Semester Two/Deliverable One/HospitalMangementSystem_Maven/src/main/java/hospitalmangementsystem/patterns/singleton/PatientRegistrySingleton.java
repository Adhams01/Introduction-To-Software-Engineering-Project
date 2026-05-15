package hospitalmangementsystem.patterns.singleton;

// [YASSIN] - Case #2: PatientRegistrySingleton
// This makes sure we only have ONE patient registry for the whole app
// It uses a cache (HashMap) so lookups are super fast O(1)

import hospitalmangementsystem.dao.PatientDAO;
import hospitalmangementsystem.domain.Patient;
import java.util.HashMap;
import java.util.Map;

public final class PatientRegistrySingleton {
    
    // [YASSIN] - The single instance (starts as null)
    private static volatile PatientRegistrySingleton instance;
    
    // [YASSIN] - Database access object for saving/loading patients
    private final PatientDAO patientDAO;
    
    // [YASSIN] - Cache: stores patients by nationalId for fast lookup
    private final Map<String, Patient> cache;
    
    // [YASSIN] - Private constructor - takes DAO to load/save patients
    private PatientRegistrySingleton(PatientDAO patientDAO) {
        if (patientDAO == null) {
            throw new IllegalArgumentException("patientDAO is required");
        }
        this.patientDAO = patientDAO;                     // Save DAO reference
        this.cache = new HashMap<>();                   // Empty cache at start
    }
    
    // [YASSIN] - Get instance with DAO (call this first time)
    public static PatientRegistrySingleton getInstance(PatientDAO patientDAO) {
        if (instance == null) {                          // First check (no lock)
            synchronized (PatientRegistrySingleton.class) { // Lock for thread safety
                if (instance == null) {                  // Second check (with lock)
                    instance = new PatientRegistrySingleton(patientDAO);
                }
            }
        }
        return instance;                                 // Return the one instance
    }
    
    // [YASSIN] - Get instance without DAO (use after first init)
    public static PatientRegistrySingleton getInstance() {
        PatientRegistrySingleton local = instance;
        if (local == null) {
            throw new IllegalStateException("Not initialized. Call getInstance(patientDAO) first.");
        }
        return local;
    }
    
    // [YASSIN] - Find patient by national ID (uses cache first, then DB)
    public Patient findByNationalId(String nationalId) {
        if (nationalId == null) return null;
        String key = nationalId.trim();
        if (key.isEmpty()) return null;
        
        // [YASSIN] - Check cache first (super fast O(1))
        Patient cached = cache.get(key);
        if (cached != null) return cached;               // Found in cache!
        
        // [YASSIN] - Not in cache? Load from database
        Patient found = patientDAO.findByNationalId(key);
        if (found != null) {
            cache.put(key, found);                        // Save to cache for next time
        }
        return found;
    }
    
    // [YASSIN] - Save or update patient (also updates cache)
    public boolean saveOrUpdate(Patient patient) {
        boolean ok = patientDAO.saveOrUpdate(patient);    // Save to database first
        if (ok && patient != null && patient.getNationalId() != null) {
            String key = patient.getNationalId().trim();
            if (!key.isEmpty()) {
                cache.put(key, patient);                  // Save to cache too
            }
        }
        return ok;
    }
    
    // [YASSIN] - Count total patients in database
    public int count() {
        return patientDAO.count();
    }
}
