package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;

/*Not really a box as that was the initial idea, but then I realized it was
* just unnecessarily time consuming. */

public class Infobox {

    private Vector3 textPos;
    private Vector3 heliPos;
    private float fontsize;
    private String text;

    public Infobox(int posX, int posY, float fontsize) {
        this.textPos = new Vector3(posX, posY, 0);
        this.heliPos = new Vector3(0,0,0);
        this.fontsize = fontsize;
        this.text = String.format("X: %.0f Y: %.0f", heliPos.x, heliPos.y);
    }


    public void update(Vector3 heliPos) {
        this.heliPos = heliPos;
        this.text = String.format("X: %.0f Y: %.0f", heliPos.x, heliPos.y);
    }

    public String getText() {
        return text;
    }

    public Vector3 getTextPos() {
        return textPos;
    }

    public float getFontsize() {
        return fontsize;
    }

}
