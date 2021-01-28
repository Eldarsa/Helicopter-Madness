package com.mygdx.helicopter_madness;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.helicopter_madness.sprites.Helicopter;

public class MyInputProcessor implements InputProcessor {


    public boolean keyDown (int keycode) {
        return false;
    }

    public boolean keyUp (int keycode) {
        return false;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        if (y < HelicopterMadness.HEIGHT / 3) {

        }

        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}