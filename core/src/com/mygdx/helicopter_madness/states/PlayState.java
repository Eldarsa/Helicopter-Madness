package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.sprites.Helicopter;

public class PlayState extends State{
    private Helicopter helicopter;
    private BitmapFont helicopterCoordinates;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(100, 100, 20, 25);
        helicopterCoordinates = new BitmapFont();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (Gdx.input.getY() < HelicopterMadness.HEIGHT / 3) {
                helicopter.moveDown();
            } else if (Gdx.input.getY() > (2.0 / 3.0 * HelicopterMadness.HEIGHT)) {
                helicopter.moveUp();
            } else if (Gdx.input.getX() < HelicopterMadness.WIDTH / 2) {
                helicopter.moveLeft();
            } else {
                helicopter.moveRight();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        helicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        helicopterCoordinates.draw(sb, String.format("x: %s\ny: %s", helicopter.getPos().x, helicopter.getPos().y), 10, HelicopterMadness.HEIGHT-10);
        sb.draw(helicopter.getTexture(), helicopter.getPos().x, helicopter.getPos().y, helicopter.getTexture().getWidth(), helicopter.getTexture().getHeight(), 0, 0, helicopter.getTexture().getWidth(), helicopter.getTexture().getHeight(), helicopter.isFlipX(), false);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }

}
