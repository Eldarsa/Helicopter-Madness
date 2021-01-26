package com.mygdx.helicopter_madness.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helicopter_madness.HelicopterMadness;
import com.mygdx.helicopter_madness.sprites.Helicopter;
import com.mygdx.helicopter_madness.sprites.Infobox;

public class PlayState extends State{

    private Helicopter helicopter;
    private float helifrate = 0.1f; //seconds
    private Infobox infobox;
    BitmapFont font;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(100, 100, 20, 25, helifrate);
        infobox = new Infobox(20,HelicopterMadness.HEIGHT - 20, 1f);
        font = new BitmapFont();
        font.getData().setScale(infobox.getFontsize()); //Set fontsize
    }

    @Override
    protected void handleInput() {
        
    }

    @Override
    public void update(float dt) {
        handleInput();
        helicopter.update(dt);
        infobox.update(helicopter.getPos());
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter.getTexture(),
                helicopter.getPos().x,
                helicopter.getPos().y,
                helicopter.getTexture().getWidth(),
                helicopter.getTexture().getHeight(),
                0, 0,
                helicopter.getTexture().getWidth(),
                helicopter.getTexture().getHeight(),
                helicopter.isFlipX(), false);
        //sb.draw(helicopter.getTexture(), helicopter.getPos().x, helicopter.getPos().y, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, helicopter.isFlipX(), false)
        font.draw(sb, infobox.getText(),
                infobox.getTextPos().x,
                infobox.getTextPos().y);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }

}
