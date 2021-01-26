package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.helicopter_madness.HelicopterMadness;

public class Helicopter {
    private Vector3 pos;
    private Vector3 vel;
    private Texture helicopter;
    private boolean flipX;

    public Helicopter(int posX, int posY, int velX, int velY){
        pos = new Vector3(posX, posY, 0);
        vel = new Vector3(velX, velY, 0);
        helicopter = new Texture("attackhelicopter.PNG");
        flipX = true;
    }

    private void setVelAndPos(float velX, float velY, float dt){
        vel.set(velX, velY, 0);
        vel.scl(dt);
        pos.add(vel.x, vel.y, 0);
        vel.scl(1/dt);
    }

    public void update(float dt){
        if (pos.x <= 0){
            setVelAndPos(20, vel.y, dt);
            flipX = true;
        }
        else if (pos.x >= (HelicopterMadness.WIDTH - helicopter.getWidth())){
            setVelAndPos(-20, vel.y, dt);
            flipX = false;
        }
        else if (pos.x > 0 && pos.x < (HelicopterMadness.WIDTH - helicopter.getWidth())) {
            setVelAndPos(vel.x, vel.y, dt);
        }

        if (pos.y <= 0){
            setVelAndPos(vel.x, 25, dt);
        }
        else if (pos.y >= (HelicopterMadness.HEIGHT - helicopter.getHeight())){
            setVelAndPos(vel.x, -25, dt);
        }
        else if (pos.y > 0 && pos.y < (HelicopterMadness.HEIGHT - helicopter.getHeight())) {
            setVelAndPos(vel.x, vel.y, dt);
        }
    }

    public Vector3 getPos() {
        return pos;
    }

    public Texture getTexture() {
        return helicopter;
    }

    public boolean isFlipX() {
        return flipX;
    }

    public void dispose() {
        helicopter.dispose();
    }
}
