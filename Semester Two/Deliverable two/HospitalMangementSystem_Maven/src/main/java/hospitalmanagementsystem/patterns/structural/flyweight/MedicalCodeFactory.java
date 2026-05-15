package hospitalmanagementsystem.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Purpose: Factory to manage and cache shared MedicalCode flyweight objects.
 * Owner: [MAGED]
 */
public class MedicalCodeFactory {
    private final Map<String, MedicalCode> codeCache = new HashMap<>();

    public MedicalCode getMedicalCode(String code, String name, String description) {
        if (!codeCache.containsKey(code)) {
            System.out.println("Creating new MedicalCode for: " + code);
            codeCache.put(code, new MedicalCode(code, name, description));
        } else {
            System.out.println("Reusing existing MedicalCode for: " + code);
        }
        return codeCache.get(code);
    }

    public int getCacheSize() {
        return codeCache.size();
    }
}
