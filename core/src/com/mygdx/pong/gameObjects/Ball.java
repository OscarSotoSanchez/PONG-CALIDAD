<<<<<<< HEAD:core/src/com/mygdx/pong/GameObjects/Ball.java
package com.mygdx.pong.GameObjects;

import com.badlogic.gdx.math.Vector2;


/**
 * Created by fonyc on 10/10/2017.
 */

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

        if ((this.position.y > 0)) {
            if (this.velocity.y < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            this.position.y = screenHeight;
            this.velocity.y = -this.velocity.y;

            position.add(velocity.cpy().scl(delta));
        }


        if ((this.position.x > 0)) {
            if (this.velocity.x < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            this.position.x = screenWidth;
            this.velocity.x = -this.velocity.x;

            position.add(velocity.cpy().scl(delta));
        }

        if ((this.position.y + this.size < this.screenHeight)) {
            if (this.velocity.y > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            if (!isBullet) {
                this.position.y = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            }

        }

        if ((this.position.x + this.size < this.screenWidth)) {
            if (this.velocity.x > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            if (!isBullet) {
                this.position.x = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            } else {
                impacted = false;
            }

        }
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
=======
package com.mygdx.pong.gameObjects;

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


       /* if((this.position.y > 0)) {
            if (this.velocity.y < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        }

        if((this.position.y+this.size < this.screenHeight)) {
            if (this.velocity.y > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        }  */


        if ((this.position.y > 0)) {
            if (this.velocity.y < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            this.position.y = screenHeight;
            this.velocity.y = -this.velocity.y;

            position.add(velocity.cpy().scl(delta));
        }


        if ((this.position.x > 0)) {
            if (this.velocity.x < 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            this.position.x = screenWidth;
            this.velocity.x = -this.velocity.x;

            position.add(velocity.cpy().scl(delta));
        }

        if ((this.position.y + this.size < this.screenHeight)) {
            if (this.velocity.y > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            if (!isBullet) {
                this.position.y = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            }

        }

        if ((this.position.x + this.size < this.screenWidth)) {
            if (this.velocity.x > 0) {
                position.add(velocity.cpy().scl(delta));
            }
        } else {
            if (!isBullet) {
                this.position.x = 0;
                this.isCube = !this.isCube;
                position.add(velocity.cpy().scl(delta));
            } else {
                impacted = false;
            }

        }
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
>>>>>>> 6b6d0d796ce074455251cb1bda542d14ed523be7:core/src/com/mygdx/pong/gameObjects/Ball.java
