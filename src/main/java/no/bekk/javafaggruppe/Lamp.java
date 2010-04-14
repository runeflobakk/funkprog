package no.bekk.javafaggruppe;

import static no.bekk.javafaggruppe.LightState.BROKEN;
import static no.bekk.javafaggruppe.LightState.OFF;
import static no.bekk.javafaggruppe.LightState.ON;

import java.util.ArrayList;
import java.util.List;


public class Lamp {

    private final List<Light> lights = new ArrayList<Light>();

    public Lamp(Light ... lights) {
        for (Light light : lights) {
            this.lights.add(light);
        }
    }

    public void turnOn() {
        for (Light light : lights) {
            if (!light.isCurrently(BROKEN)) {
                light.setState(ON);
            }
        }
    }

    public void turnOff() {
        for (Light light : lights) {
            if (!light.isCurrently(BROKEN)) {
                light.setState(OFF);
            }
        }
    }


    public int getLightAmount() {
        return lights.size();
    }

    public List<Light> getLights() {
        return lights;
    }

    public List<Light> getLightsWhichAre(LightState state) {
        List<Light> lights = new ArrayList<Light>();
        for (Light light : this.lights) {
            if (light.isCurrently(state)) {
                lights.add(light);
            }
        }
        return lights;
    }

    public int getAmountOfLightsWhichAre(LightState state) {
        int amount = 0;
        for (Light light : lights) {
            if (light.isCurrently(state)) {
                amount++;
            }
        }
        return amount;
    }

    public int getPendingReplacementCosts() {
        int totalPrice = 0;
        for (Light light : getLightsWhichAre(BROKEN)) {
            totalPrice += light.getPrice();
        }
        return totalPrice;
    }

    public void replaceBrokenLightWith(Light newLight) {
        for (Light light : lights) {
            if (light.isCurrently(BROKEN)) {
                lights.remove(light);
                lights.add(newLight);
            }
        }
    }

}
