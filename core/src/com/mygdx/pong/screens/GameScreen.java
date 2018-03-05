package com.mygdx.pong.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.pong.frameworkHelper.InputHandler;
import com.mygdx.pong.gameLoop.GameRenderer;
import com.mygdx.pong.gameLoop.GameWorld;

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

    }

    @Override
    public void show() {


    }

    @Override
    public void hide() {

        Gdx.app.log("GameScreen", "hide called");
        Stage stage = null;
        Skin skin = null;
    }

    @Override
    public void pause() {

        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {

        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
