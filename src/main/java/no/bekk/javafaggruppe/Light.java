package no.bekk.javafaggruppe;

import static no.bekk.javafaggruppe.LightState.OFF;

public class Light {
    private LightState state = OFF;

    public Light setState(LightState state) {
        this.state = state;
        return this;
    }

    public LightState getState() {
        return state;
    }


}
