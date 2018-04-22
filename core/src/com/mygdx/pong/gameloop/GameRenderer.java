package com.mygdx.pong.gameloop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;


    //EXPLICACION: Clase que se encarga de renderizar los objetos
    //METODOS
    public GameRenderer(GameWorld world, int screenWidth, int screenHeight) {
        myWorld = world;
        cam = new OrthographicCamera();

        //el batcher permite renderizar objetos separados de la renderizacion global
    }

    private void setupRenderer() {
        this.batcher = new SpriteBatch();
        this.batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }


    private void setupCamera(int screenWidth, int screenHeight) {
        cam.setToOrtho(true, screenWidth, screenHeight);
    }

    public GameRenderer(GameWorld myWorld, OrthographicCamera cam, ShapeRenderer shapeRenderer, SpriteBatch batcher) {
        this.myWorld = myWorld;
        this.cam = cam;
        this.shapeRenderer = shapeRenderer;
        this.batcher = batcher;
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // 2. We draw the Filled rectangle
        // Tells shapeRenderer to begin drawing filled shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Chooses RGB Color of 87, 109, 120 at full opacity
        shapeRenderer.setColor(Color.LIGHT_GRAY);


        // Draws the rectangle from myWorld (Using ShapeType.Filled)
        for (int i = 0; i <= myWorld.getPaddle().size() - 1; i++) {
            shapeRenderer.rect(myWorld.getPaddle().get(i).getX(), myWorld.getPaddle().get(i).getY(), myWorld.getPaddle().get(i).getWidth(), myWorld.getPaddle().get(i).getHeight());
            // Tells the shapeRenderer to finish rendering
        }
        batcher.begin();

        shapeRenderer.setColor(myWorld.getColors());
        if (!this.myWorld.getBall().isCube()) {
            shapeRenderer.circle(myWorld.getBall().getX(), myWorld.getBall().getY(), myWorld.getBall().getSize());
        } else {
            shapeRenderer.rect(myWorld.getBall().getX(), myWorld.getBall().getY(), myWorld.getBall().getSize() + 5F, myWorld.getBall().getSize() + 5F);
        }
        if (myWorld.getBullet() != null) {
            shapeRenderer.circle(myWorld.getBullet().getX(), myWorld.getBullet().getY(), myWorld.getBullet().getSize());
        }

        batcher.end();
        // We MUST do this every time.
        shapeRenderer.end();
    }
}


