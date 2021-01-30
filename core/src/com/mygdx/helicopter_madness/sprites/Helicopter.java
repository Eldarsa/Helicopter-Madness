package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.helicopter_madness.HelicopterMadness;

import java.util.Random;

public class Helicopter {
    public static final int VEL_X = 40;
    public static final int VEL_Y = 55;

    private Vector3 pos;
    private Vector3 vel;
    private Texture helicopter;
    private boolean flipX;
    public Rectangle bounds;

    private Random rand;

    public Helicopter(int posX, int posY){
        rand = new Random();

        pos = new Vector3(posX, posY, 0);
        vel = new Vector3(rand.nextInt(30) + 20, rand.nextInt(30) + 20, 0);
        helicopter = new Texture("attackhelicopter.PNG");
        flipX = true;
        bounds = new Rectangle(pos.x, pos.y, helicopter.getWidth(), helicopter.getHeight());
    }

    private void setVelAndPos(float velX, float velY, float dt){
        vel.set(velX, velY, 0);
        vel.scl(dt);
        pos.add(vel.x, vel.y, 0);
        vel.scl(1/dt);
    }

    public void update(float dt){
        updateVelAndPos(dt);
        checkFlipX();
        bounds.setPosition(pos.x, pos.y);
    }

    public void updateVelAndPos(float dt){
        if (pos.x <= 0){
            setVelAndPos(VEL_X, vel.y, dt);
        }
        else if (pos.x >= (HelicopterMadness.WIDTH - helicopter.getWidth())){
            setVelAndPos(-VEL_X, vel.y, dt);
        }
        else if (pos.x > 0 && pos.x < (HelicopterMadness.WIDTH - helicopter.getWidth())) {
            setVelAndPos(vel.x, vel.y, dt);
        }

        if (pos.y <= 0){
            setVelAndPos(vel.x, VEL_Y, dt);
        }
        else if (pos.y >= (HelicopterMadness.HEIGHT - helicopter.getHeight())){
            setVelAndPos(vel.x, -VEL_Y, dt);
        }
        else if (pos.y > 0 && pos.y < (HelicopterMadness.HEIGHT - helicopter.getHeight())) {
            setVelAndPos(vel.x, vel.y, dt);
        }
    }

    private void checkFlipX() {
        if (vel.x < 0) {flipX = false;}
        if (vel.x > 0) {flipX = true;}
    }

    public void collisionHorizontal(){
        vel.x = -vel.x;
    }

    public void collisionVertical(){
        vel.y = -vel.y;
    }

    public void detectCollision(Helicopter... helicopters){
        for (Helicopter h : helicopters) {
            if (h.bounds.overlaps(this.bounds)){
                h.vel.x = -h.vel.x;
                h.vel.y = -h.vel.y;
                this.vel.x = -this.vel.x;
                this.vel.y = -this.vel.y;
            }
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
