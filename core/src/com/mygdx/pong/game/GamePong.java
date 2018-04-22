package com.mygdx.pong.game;

import com.badlogic.gdx.Game;
import com.mygdx.pong.gameloop.GameRenderer;
import com.mygdx.pong.gameloop.GameWorld;
import com.mygdx.pong.screens.GameScreen;

import static java.lang.System.exit;

public class GamePong extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }

    public void mockCreate(GameWorld world, GameRenderer renderer) {
        setScreen(new GameScreen(world, renderer));
    }

    public void end() {
        exit(0);
    }

}
