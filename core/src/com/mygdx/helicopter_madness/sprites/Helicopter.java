package com.mygdx.helicopter_madness.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Helicopter {

    private Vector3 pos;
    private Vector3 vel;
    private boolean flipX;
    private Texture frame;
    private float statetime;

    private Animation<Texture> helicopter;
    private Texture[] keyframes = {
            new Texture("heli1.png"),
            new Texture("heli2.png"),
            new Texture("heli3.png"),
            new Texture("heli4.png")};

    public Helicopter(int posX, int posY, int velX, int velY, float framerate){
        pos = new Vector3(posX, posY, 0);
        vel = new Vector3(velX, velY, 0);
        flipX = true;
        statetime = 0;

        helicopter = new Animation<Texture>(framerate, keyframes);
        helicopter.setPlayMode(Animation.PlayMode.LOOP);
        frame = helicopter.getKeyFrame(statetime);
    }

    private void setVelAndPos(float velX, float velY, float dt){
        vel.set(velX, velY, 0);
        vel.scl(dt);
        pos.add(vel.x, vel.y, 0);
        vel.scl(1/dt);
    }

    public void update(float dt){

        //Get animation texture here
        statetime +=dt;
        frame = helicopter.getKeyFrame(statetime);

        if (pos.x <= 0){
            setVelAndPos(20, vel.y, dt);
            flipX = true;
        }
        else if (pos.x >= (HelicopterMadness.WIDTH - frame.getWidth())){
            setVelAndPos(-20, vel.y, dt);
            flipX = false;
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

}
