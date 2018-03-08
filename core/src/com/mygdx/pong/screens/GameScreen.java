package com.mygdx.pong.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.pong.frameworkhelper.InputHandler;
import com.mygdx.pong.gameloop.GameRenderer;
import com.mygdx.pong.gameloop.GameWorld;


public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;

    private Game game;

    public GameScreen(Game game) {
        this.game = game;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        world = new GameWorld((int) screenWidth, (int) screenHeight, game);
        renderer = new GameRenderer(world, (int) screenWidth, (int) screenHeight);
        Gdx.input.setInputProcessor(new InputHandler(world, world.getPaddle1(), (int) screenWidth, (int) screenHeight));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        //Override but not used
    }

    @Override
    public void show() {
        //Override but not used
    }

    @Override
    public void hide() {
        //Override but not used
    }

    @Override
    public void pause() {
        //Override but not used
    }

    @Override
    public void resume() {
        //Override but not used
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
