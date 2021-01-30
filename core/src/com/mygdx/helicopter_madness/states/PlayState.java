package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.sprites.Helicopter;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.lang.model.type.ArrayType;

import sun.security.util.ArrayUtil;

public class PlayState extends State{
    private Helicopter helicopter1;
    private Helicopter helicopter2;
    private Helicopter helicopter3;

    private Helicopter[] helicopters;
//    private Array<Helicopter> helicopters;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
//        helicopter1 = new Helicopter(100, 1, Helicopter.VEL_X, Helicopter.VEL_Y);
//        helicopter2 = new Helicopter(100, HelicopterMadness.HEIGHT/2, Helicopter.VEL_X, Helicopter.VEL_Y);
//        helicopter3 = new Helicopter(100, HelicopterMadness.HEIGHT-helicopter1.getTexture().getHeight()-1, Helicopter.VEL_X, Helicopter.VEL_Y);

        helicopter1 = new Helicopter(100, 1);
        helicopter2 = new Helicopter(100, HelicopterMadness.HEIGHT / 2);
        helicopter3 = new Helicopter(100, HelicopterMadness.HEIGHT - helicopter1.getTexture().getHeight() - 1);

//        helicopters = new Array<Helicopter>(3);
//        helicopters.addAll(helicopter1, helicopter2, helicopter3);
        helicopters = new Helicopter[] {helicopter1, helicopter2, helicopter3};
    }

    @Override
    protected void handleInput() {
        
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Helicopter h : helicopters) {
            h.update(dt);
            for (Helicopter h1: helicopters){
                if (h == h1){
                    continue;
                }
                h.detectCollision(h1);
            }
        }

//        for (int i = 0; i < helicopters.length; i++) {
//            helicopters[i].update(dt);
//            helicopters[i].detectCollision(Stream.concat(Arrays.stream(Arrays.copyOfRange(helicopters, 0, i)), Arrays.stream(Arrays.copyOfRange(helicopters, i, helicopters.length))).toArray());

//            int index = ArrayUtil.indexOf(helicopters, h);
//            Array.stream( helicopters ).filte( value -> value != h).toArray()
//            h.detectCollision(Array.stream( helicopters ).filte( value -> value != h).toArray());
//        }
//        helicopter1.update(dt);
//        helicopter2.update(dt);
//        helicopter3.update(dt);

//        helicopter1.detectCollision(Array<Helicopter> [helicopter2, helicopter3]);
//        helicopter2.detectCollision([helicopter2, helicopter3]);
//        helicopter3.detectCollision([helicopter2, helicopter3]);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        for (Helicopter h : helicopters) {
            sb.draw(h.getTexture(), h.getPos().x, h.getPos().y, h.getTexture().getWidth(), h.getTexture().getHeight(), 0, 0, h.getTexture().getWidth(), h.getTexture().getHeight(), h.isFlipX(), false);
        }
//        sb.draw(helicopter1.getTexture(), helicopter1.getPos().x, helicopter1.getPos().y, helicopter1.getTexture().getWidth(), helicopter1.getTexture().getHeight(), 0, 0, helicopter1.getTexture().getWidth(), helicopter1.getTexture().getHeight(), helicopter1.isFlipX(), false);
//        sb.draw(helicopter2.getTexture(), helicopter2.getPos().x, helicopter2.getPos().y, helicopter2.getTexture().getWidth(), helicopter2.getTexture().getHeight(), 0, 0, helicopter2.getTexture().getWidth(), helicopter2.getTexture().getHeight(), helicopter2.isFlipX(), false);
//        sb.draw(helicopter3.getTexture(), helicopter3.getPos().x, helicopter3.getPos().y, helicopter3.getTexture().getWidth(), helicopter3.getTexture().getHeight(), 0, 0, helicopter3.getTexture().getWidth(), helicopter3.getTexture().getHeight(), helicopter3.isFlipX(), false);
        sb.end();
    }

    @Override
    public void dispose() {
        for (Helicopter h : helicopters) {
            h.dispose();
        }
    }

}
