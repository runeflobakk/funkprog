package no.bekk.javafaggruppe;

import static ch.lambdaj.Lambda.forEach;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.sumFrom;
import static no.bekk.javafaggruppe.LightState.BROKEN;
import static no.bekk.javafaggruppe.LightState.ON;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class FunctionalJavaTest {
    @Test
    public void turnOnAllLights() {
        List<Light> lights = new ArrayList<Light>();
        lights.add(new Light());
        lights.add(new Light());

        for (Light light : lights) {
            light.setState(ON);
        }

        forEach(lights).setState(ON);
    }


    @Test
    public void countAllTheLights() {
        Lamp lamp1 = new Lamp(new Light(), new Light(), new Light());
        Lamp lamp2 = new Lamp(new Light(), new Light(), new Light(), new Light());
        List<Lamp> lamps = listOf(lamp1, lamp2);

        int totalLigts = sumFrom(lamps).getLightAmount();

    }



    @Test
    public void whichLightsNeedToBeReplaced() {
        Lamp lamp = new Lamp(new Light().setState(BROKEN), new Light(), new Light());
        select(lamp.getLights(), having(on(Light.class).getState(), equalTo(BROKEN)));
    }




    private <T> List<T> listOf(T ... elements) {
        List<T> list = new ArrayList<T>();
        for (T t : elements) {
            list.add(t);
        }
        return list;

    }

}
