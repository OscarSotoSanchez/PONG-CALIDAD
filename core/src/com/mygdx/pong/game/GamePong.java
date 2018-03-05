package com.mygdx.pong.game;

import com.badlogic.gdx.Game;
import com.mygdx.pong.screens.GameScreen;

import static java.lang.System.exit;

public class GamePong extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(this));

    }

    public void end() {

        exit(0);

    }

}
