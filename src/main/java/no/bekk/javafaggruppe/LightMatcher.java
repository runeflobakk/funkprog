package no.bekk.javafaggruppe;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static no.bekk.javafaggruppe.LightState.BROKEN;
import static no.bekk.javafaggruppe.LightState.OFF;
import static no.bekk.javafaggruppe.LightState.ON;

import org.hamcrest.Matcher;

public class LightMatcher {

    public Matcher<Light> broken = having(on(Light.class).isCurrently(BROKEN));
    public Matcher<Light> turnedOn = having(on(Light.class).isCurrently(ON));
    public Matcher<Light> turnedOff = having(on(Light.class).isCurrently(OFF));

}
