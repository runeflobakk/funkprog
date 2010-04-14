package no.bekk.javafaggruppe;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static no.bekk.javafaggruppe.LightState.BROKEN;
import static no.bekk.javafaggruppe.LightState.OFF;
import static no.bekk.javafaggruppe.LightState.ON;

import org.junit.Before;
import org.junit.Test;


public class LampTest {

    private Light light1;
    private Light light2;
    private Lamp lamp;

    @Before
    public void setup() {
        light1 = new Light(10);
        light2 = new Light(15);
        lamp = new Lamp(light1, light2);
    }

    @Test
    public void aNewLampWithOnlyBrandNewLightsShouldHaveNoBrokenLights() {
        assertEquals(0, lamp.getAmountOfLightsWhichAre(BROKEN));
    }

    @Test
    public void aNewLampWithOnlyNewLightsShouldHaveAllLightsTurnedOff() {
        assertEquals(2, lamp.getAmountOfLightsWhichAre(OFF));
    }


    @Test
    public void turningOnALampShouldTurnOnAllItsLights() {
        lamp.turnOn();
        assertTrue(light1.isCurrently(ON));
        assertTrue(light2.isCurrently(ON));
    }

    @Test
    public void turningOnALampShouldNotTurnOnABrokenLights() {
        light1.setState(BROKEN);
        lamp.turnOn();
        assertTrue(light1.isCurrently(BROKEN));
        assertTrue(light2.isCurrently(ON));
    }

    @Test
    public void turningOffALampShouldNotSetABrokenLightToOff() {
        lamp.turnOn();
        light1.setState(BROKEN);
        lamp.turnOff();
        assertTrue(light1.isCurrently(BROKEN));
        assertTrue(light2.isCurrently(OFF));
    }

    @Test
    public void shouldAddUpThePriceOfAllBrokenLights() {
        light1.setState(BROKEN);
        light2.setState(BROKEN);
        assertEquals(25, lamp.getPendingReplacementCosts());
    }


    @Test
    public void shouldBeAbleToReplaceABrokenLight() {
        light2.setState(BROKEN);
        assertEquals(1, lamp.getAmountOfLightsWhichAre(BROKEN));

        Light newLight = new Light(15);
        lamp.replaceBrokenLightWith(newLight);
        assertEquals(2, lamp.getLightAmount());
        assertEquals(0, lamp.getAmountOfLightsWhichAre(BROKEN));
    }



}
