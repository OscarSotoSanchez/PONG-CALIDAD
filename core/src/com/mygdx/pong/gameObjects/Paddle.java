package com.mygdx.pong.GameObjects;

import com.badlogic.gdx.math.Vector2;


public class Paddle {
    private Vector2 position;
    private Vector2 velocity;
    private int width;
    private int height;
    private int screenHeight;


    //METODOS

    public Paddle(float x, float y, int width, int height, int screenHeight) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.screenHeight = screenHeight;

    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void update(float delta) {
        if ((this.position.y > 0)) {
            if (this.velocity.y < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        }

        if ((this.position.y + this.height < this.screenHeight)) {
            if (this.velocity.y > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        }
    }

    public void onRelease() {
        velocity.y = 0; //Cuado suelte el paddle, solo le pongo la velocidad Y a 0, porque solo se mueve verticalmente
    }

    public float getX() {
        return position.x;
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void collider() {

        this.velocity.x = -this.velocity.x;
        this.velocity.y = -this.velocity.y;
    }
}
