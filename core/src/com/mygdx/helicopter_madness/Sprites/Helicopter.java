package com.mygdx.helicopter_madness.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Helicopter {

    private Vector3 position;
    private Vector3 velocity;

    private Texture helicopter;

    public Helicopter(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        helicopter = new Texture("attackHelicopter.png");
    }

    public void update(float dt) {
        //velocity.add(0, 0, 0);
        velocity.scl(dt); //To scale velocity
        position.add(velocity.x,velocity.y, 0);
        velocity.scl(1/dt); //To unscale velocity
        System.out.println(position);
    }


    public Vector3 getPosition() {
        return position;
    }

    public Texture getHelicopter() {
        return helicopter;
    }
}
