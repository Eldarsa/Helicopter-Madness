package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.sprites.Helicopter;
import java.util.Random;

public class PlayState extends State{

    private Helicopter[] helicopters;
    private int amount;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        amount = 5;
        generateHelicopters(amount, 10, 50);
    }

    @Override
    protected void handleInput() {
        
    }

    @Override
    public void update(float dt) {
        handleInput();

        //Update helicopter objects

        updateHelicopters(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        for(Helicopter heli: helicopters){
            sb.draw(heli.getTexture(),
                    heli.getPos().x,
                    heli.getPos().y,
                    heli.getTexture().getWidth(),
                    heli.getTexture().getHeight(),
                    0, 0,
                    heli.getTexture().getWidth(),
                    heli.getTexture().getHeight(),
                    heli.isFlipX(), false);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        for(Helicopter helicopter: helicopters){
            helicopter.dispose();
        }
    }

    private void generateHelicopters(int amount, int minInitVel, int maxInitVel) {

        helicopters = new Helicopter[amount]; //Create array with 'amount' helicopters

        Helicopter ignoreHeli = new Helicopter(0,0,0,0);
        int width = ignoreHeli.getWidth();
        int height = ignoreHeli.getHeight();
        ignoreHeli.dispose();

        int imWidth = HelicopterMadness.WIDTH;
        int imHeight = HelicopterMadness.HEIGHT;
        int widthInterval = (int) imWidth / amount;
        int heightInterval = (int) imHeight / amount;

        int velX;
        int velY;
        Random rand = new Random();

        for (int i = 0; i < amount; i++) {

            velX = rand.nextInt(maxInitVel - minInitVel) + minInitVel;
            velY = rand.nextInt(maxInitVel - minInitVel) + minInitVel;

            helicopters[i] = new Helicopter(
                    i*widthInterval,
                    i*heightInterval,
                    velX,
                    velY);
        }
    } //End generateHelicopters();

    private void updateHelicopters(float dt) {

        //Set collisionStatus
        for(int i = 0; i < helicopters.length; i++) {
            for(int j = 0; j < helicopters.length; j++) {
                if(j == i) {
                    continue;
                }else{
                    if(helicopters[i].getBoundingRectangle().overlaps(
                            helicopters[j].getBoundingRectangle())) {
                        helicopters[i].setCollisionStatus(true);
                        break;
                    }else{
                        helicopters[i].setCollisionStatus(false);
                    }
                }
            }
        }

        for(Helicopter heli: helicopters){
            heli.update(dt);
        }
    } //End updateHelicopters();

}
