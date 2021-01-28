package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.helicopter_madness.HelicopterMadness;

public class Helicopter {
    private static final int VELOCITY = 50;

    private Vector3 pos;
    private Vector3 vel;
    private Texture helicopter;
    private boolean flipX;
    private Rectangle bounds;

    public Helicopter(int posX, int posY, int velX, int velY){
        pos = new Vector3(posX, posY, 0);
        vel = new Vector3(velX, velY, 0);
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
        setVelAndPos(vel.x, vel.y, dt);
        bounds.setPosition(pos.x, pos.y);

        if (vel.x < 0) {flipX = false;}
        else if (vel.x > 0) {flipX = true;}

        if (collidesWithWall()){
            vel.x = -vel.x;
            vel.y = -vel.y;
        }
    }

    private boolean collidesWithWall() {
        return (pos.x < 0 || pos.x > (HelicopterMadness.WIDTH - helicopter.getWidth()) || pos.y < 0 || pos.y > (HelicopterMadness.HEIGHT - helicopter.getHeight()));
    }

    public void moveDown() {  // float dt
        vel.set(0, VELOCITY, 0);
    }

    public void moveUp() {
        vel.set(0, -VELOCITY, 0);
    }

    public void moveLeft() {
        vel.set(-VELOCITY, 0, 0);
    }

    public void moveRight() {
        vel.set(VELOCITY, 0, 0);
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
