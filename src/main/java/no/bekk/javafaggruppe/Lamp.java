package no.bekk.javafaggruppe;

import static ch.lambdaj.Lambda.forEach;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.selectFirst;
import static ch.lambdaj.Lambda.sumFrom;
import static java.util.Arrays.asList;
import static no.bekk.javafaggruppe.LightState.BROKEN;
import static no.bekk.javafaggruppe.LightState.OFF;
import static no.bekk.javafaggruppe.LightState.ON;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.List;


public class Lamp {

    private final LightMatcher whichIs = new LightMatcher();

    private final List<Light> lights = new ArrayList<Light>();

    public Lamp(Light ... lights) {
        this.lights.addAll(asList(lights));
    }

    public void turnOn() {
        forEach(select(lights, not(whichIs.broken))).setState(ON);
//        for (Light light : lights) {
//            if (!light.isCurrently(BROKEN)) {
//                light.setState(ON);
//            }
//        }
    }

    public void turnOff() {
        forEach(select(lights, not(whichIs.broken))).setState(OFF);
    }

    public List<Light> getLights() {
        return lights;
    }

    public int getAmountOfLights() {
        return lights.size();
    }

    public List<Light> getLightsWhichAre(LightState state) {
        return select(lights, whichIs.currently(state));

//        List<Light> lights = new ArrayList<Light>();
//        for (Light light : this.lights) {
//            if (light.isCurrently(state)) {
//                lights.add(light);
//            }
//        }
//        return lights;
    }

    public int getAmountOfLightsWhichAre(LightState state) {
        return select(lights, whichIs.currently(state)).size();
    }

    public int getPendingReplacementCosts() {
        return sumFrom(getLightsWhichAre(BROKEN)).getPrice();

//        int totalPrice = 0;
//        for (Light light : lights) {
//            totalPrice += light.getPrice();
//        }
//        return totalPrice;
    }

    public void replaceBrokenLightWith(Light newLight) {
        if (lights.remove(selectFirst(lights, whichIs.broken))) {
            lights.add(newLight);
        }
    }
}
