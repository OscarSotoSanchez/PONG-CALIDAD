package com.mygdx.pong.Game;

import com.badlogic.gdx.Game;
import com.mygdx.pong.Screens.GameScreen;

import static java.lang.System.exit;

/**
 * Created by fonyc on 08/10/2017.
 */

public class GamePong extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(this));

    }

    public void end() {

        exit(0);

    }

}
