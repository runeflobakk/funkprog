package no.bekk.javafaggruppe;

import static no.bekk.javafaggruppe.LightState.OFF;

public class Light {

    private final int price;

    private LightState state;

    public Light(int price) {
        this.price = price;
        this.state = OFF;
    }

    public int getPrice() {
        return price;
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public boolean isCurrently(LightState state) {
        return this.state == state;
    }

}
