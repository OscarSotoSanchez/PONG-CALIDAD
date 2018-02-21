package com.mygdx.pong.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Daniel on 02/11/2017.
 */

public class GameOverScreen implements Screen {

    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    private Game game;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private float screenWidth;
    private float screenHeight;


    public GameOverScreen(Game game) {
        this.game = game;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        create();
        render();


    }

    public void create() {
        font = new BitmapFont();
    }

    public void render() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true, screenWidth, screenHeight);


        //el batcher permite renderizar objetos separados de la renderizacion global
        this.batcher = new SpriteBatch();
        this.batcher.setProjectionMatrix(cam.combined);


        batcher.begin();
        //draw background, objects, etc.

        font.draw(batcher, "ENHORABUENA HAS GANADO!", 10, 10);
        batcher.end();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
