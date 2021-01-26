package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State{
    private Texture helicopter;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        helicopter = new Texture("attackhelicopter.PNG");
    }

    @Override
    protected void handleInput() {
        
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter, 50, 50);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }

}
