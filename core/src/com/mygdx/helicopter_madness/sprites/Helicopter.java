package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Helicopter {

    private Vector3 pos;
    private Vector3 vel;
    private boolean flipX;

    private boolean collisionStatus;
    private boolean lastCollisionStatus;

    private Texture frame;
    private float framerate;
    private float statetime;
    private Animation<Texture> helicopter;
    private Texture[] keyframes = {
            new Texture("heli1.png"),
            new Texture("heli2.png"),
            new Texture("heli3.png"),
            new Texture("heli4.png")};

    private Rectangle boundingRectangle;

    private int width;
    private int height;

    public Helicopter(int posX, int posY, int velX, int velY){
        pos = new Vector3(posX, posY, 0);
        vel = new Vector3(velX, velY, 0);
        flipX = true;
        statetime = 0;
        framerate = 0.1f;

        helicopter = new Animation<Texture>(framerate, keyframes);
        helicopter.setPlayMode(Animation.PlayMode.LOOP);
        frame = helicopter.getKeyFrame(statetime);

        width = frame.getWidth();
        height = frame.getHeight();

        boundingRectangle = new Rectangle(posX, posY, width, height);
        collisionStatus = false;
        lastCollisionStatus = false;
    }

    private void setVelAndPos(float velX, float velY, float dt){
        vel.set(velX, velY, 0);
        vel.scl(dt);
        pos.add(vel.x, vel.y, 0);
        vel.scl(1/dt);
    }

    public void update(float dt){

        statetime +=dt;
        frame = helicopter.getKeyFrame(statetime);
        boundingRectangle.setPosition((float) pos.x, (float) pos.y);

        borderCollisionCheck(dt);

        boolean cs = collisionStatus;
        boolean lcs = lastCollisionStatus;

        if(lcs == true && cs == true){
            setVelAndPos(vel.x, vel.y, dt);
        }else if(lcs == true && cs == false) {
            setVelAndPos(vel.x, vel.y, dt);
        }else if(lcs == false && cs == true){
            setVelAndPos(-vel.x, -vel.y, dt);
        }else if(lcs == false && cs == false){
            setVelAndPos(vel.x, vel.y, dt);
        }
        lastCollisionStatus = collisionStatus;

        setDirection();
    }

    private void setDirection() {
        if(vel.x > 0){
            flipX = true;
        }else{
            flipX = false;
        }
    }


    private void borderCollisionCheck(float dt) {
        if (pos.x <= 0){
            setVelAndPos(20, vel.y, dt);
        }
        else if (pos.x >= (HelicopterMadness.WIDTH - frame.getWidth())){
            setVelAndPos(-20, vel.y, dt);
        }
        else if (pos.x > 0 && pos.x < (HelicopterMadness.WIDTH - frame.getWidth())) {
            setVelAndPos(vel.x, vel.y, dt);
        }

        if (pos.y <= 0){
            setVelAndPos(vel.x, 25, dt);
        }
        else if (pos.y >= (HelicopterMadness.HEIGHT - frame.getHeight())){
            setVelAndPos(vel.x, -25, dt);
        }
        else if (pos.y > 0 && pos.y < (HelicopterMadness.HEIGHT - frame.getHeight())) {
            setVelAndPos(vel.x, vel.y, dt);
        }
    }

    public Vector3 getPos() {
        return pos;
    }

    public Texture getTexture() {
        return frame;
    }

    public boolean isFlipX() {
        return flipX;
    }

    public void dispose() {
        frame.dispose();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    public void setCollisionStatus(boolean collisionStatus) {
        this.collisionStatus = collisionStatus;
    }
}
