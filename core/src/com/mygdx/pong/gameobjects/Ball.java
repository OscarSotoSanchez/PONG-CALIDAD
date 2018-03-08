package com.mygdx.pong.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Ball {
    private Vector2 position;
    private Vector2 velocity;
    private int size;
    private int screenHeight;
    private int screenWidth;
    private boolean isCube = false;
    private boolean isBullet = false;
    private boolean impacted = true;


    //metodos
    public Ball(int x, int y, int size, int screenHeight, int screenWidth) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(110, 110);
        this.size = size;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    public boolean isCube() {
        return isCube;
    }

    public void setCube(boolean cube) {
        isCube = cube;
    }

    public float getX() {
        return position.x;
    }

    //setters de las coordenadas X e Y del vector position, necesarias para resetear posicion de la bola al salir del campo
    public void setX(int x) {
        this.position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    public int getSize() {
        return size;
    }

    public void update(float delta) {
        if(this.getX() >= this.screenWidth){
            this.setX((int)this.getX() - this.screenWidth);
        } else if(this.getX() <= 0){
            this.setX((int)this.getX() + this.screenWidth);

            if (!isBullet) {
                this.position.y = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            }
        }

        if(this.getY() >= this.screenHeight){
            this.setY((int)this.getY() - this.screenHeight);
        } else if(this.getY() <= 0){
            this.setY((int)this.getY() + this.screenHeight);

            if (!isBullet) {
                this.position.x = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            } else {
                impacted = false;
            }
        }

        position.add(velocity.cpy().scl(delta));
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public boolean isBullet() {
        return isBullet;
    }

    public void setBullet(boolean bullet) {
        isBullet = bullet;
    }

    public boolean isImpacted() {
        return impacted;
    }

    public void collider() {
        this.velocity.x = -this.velocity.x;
        this.velocity.y = -this.velocity.y;
    }
}

