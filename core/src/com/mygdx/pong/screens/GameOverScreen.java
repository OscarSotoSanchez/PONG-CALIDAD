package com.mygdx.pong.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameOverScreen implements Screen {

    BitmapFont font;

    private float screenWidth;
    private float screenHeight;

    public GameOverScreen() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        create();
        render();
    }

    public void create() {
        font = new BitmapFont();
    }

    public void render() {
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(true, screenWidth, screenHeight);

        //el batcher permite renderizar objetos separados de la renderizacion global
        SpriteBatch batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        batcher.begin();
        //draw background, objects, etc.

        font.draw(batcher, "ENHORABUENA HAS GANADO!", 10, 10);
        batcher.end();
    }

    @Override
    public void show() {
        //Override but not used
    }

    @Override
    public void render(float delta) {
        //Override but not used
    }

    @Override
    public void resize(int width, int height) {
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
    public void hide() {
        //Override but not used
    }

    @Override
    public void dispose() {
        //Override but not used
    }
}
