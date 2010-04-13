package no.bekk.javafaggruppe;

import java.util.HashSet;
import java.util.Set;


public class Lamp {
    public final Set<Light> lights = new HashSet<Light>();
    public Lamp(Light ... lights) {
        for (Light light : lights) {
            this.lights.add(light);
        }
    }

    public int getLightAmount() {
        return lights.size();
    }

    public Set<Light> getLights() {
        return lights;
    }
}
