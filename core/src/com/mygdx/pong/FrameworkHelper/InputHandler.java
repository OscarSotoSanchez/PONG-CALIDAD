package com.mygdx.pong.FrameworkHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.mygdx.pong.GameLoop.GameWorld;
import com.mygdx.pong.GameObjects.Ball;
import com.mygdx.pong.GameObjects.Paddle;


/**
 * Created by fonyc on 11/10/2017.
 */

public class InputHandler implements InputProcessor, GestureDetector.GestureListener {

    private List<Paddle> paddleList;
    private Paddle myPaddle;
    private int screenWidth;
    private int screenHeight;
    private GameWorld world;

    //metodos
    public InputHandler(GameWorld myWorld, Paddle myPaddle, int screenWidth, int screenHeight) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.myPaddle = myPaddle;
        this.world = myWorld;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (Gdx.input.isTouched(1)) {

            Ball b = new Ball((int) myPaddle.getX(), (int) myPaddle.getY(), 2, screenHeight, screenWidth);
            b.setBullet(true);
            b.setVelocity(new Vector2(1000, 0));
            world.setBullet(b);

        }


        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {


        if (!Gdx.input.isTouched(1) && button == 0) {
            this.myPaddle.setY(screenY);
            this.myPaddle.setX(screenX);
        }
        return true;

    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {


        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        return false;

    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        return true;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
