package com.mygdx.pong.GameLoop;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.pong.GameObjects.Ball;
import com.mygdx.pong.GameObjects.Paddle;
import com.mygdx.pong.Screens.GameOverScreen;
import com.mygdx.pong.Screens.GameScreen;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;


/**
 * Created by fonyc on 08/10/2017.
 */

public class GameWorld{
    //esta clase se encarga de refrescar los objetos del mundo
    private Paddle paddle1;
    private GameOverScreen gameOver;
    private List<Paddle> paddleList = new ArrayList<>();
    private Ball ball;
    private Paddle paddle;
    private TextField crono;
    private List<Color> ballColors;
    private Color colors = Color.GOLD;
    private int colorNumber = 0;
    private int vidas = 5;
    int screenWidth;
    int screenHeight;
    private int score;
    String yourScoreName;
    BitmapFont yourBitmapFontName;
    private Game game;
    private Ball bullet;
    boolean impacted = false;

    //metodos




    public GameWorld(int screenWidth,int screenHeight, Game game) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.game = game;



        this.ballColors = new ArrayList<>();
        this.addColors();

        paddle = new Paddle(10, (this.screenHeight/2) - 50 / 2 ,5 ,50, this.screenHeight, this.screenWidth);
        paddle1 = paddle;
        paddleList.add(paddle);
        ball = new Ball(screenWidth/2,screenHeight/2,6,this.screenHeight, this.screenWidth);
    }

    public void restart(int screenWidth,int screenHeight){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        paddleList = new ArrayList<>();
        paddle = new Paddle(10, (this.screenHeight/2) - 50 / 2 ,5 ,50, this.screenHeight, this.screenWidth);
        paddleList.add(paddle);
        ball = new Ball(screenWidth/2,screenHeight/2,6,this.screenHeight, this.screenWidth);
    }

    public void addColors(){

        this.ballColors.add(Color.CYAN);
        this.ballColors.add(Color.GREEN);
        this.ballColors.add(Color.MAGENTA);
        this.ballColors.add(Color.YELLOW);
        this.ballColors.add(Color.ORANGE);

    }

    public void addPaddle(){

        paddle = new Paddle(10, (this.screenHeight/2) - 50 / 2 ,5 ,50, this.screenHeight, this.screenWidth);

        paddleList.add(paddle);

    }

    public Color getColors() {
        return colors;
    }

    public void update(float delta) {

        //updates de paddle y bolas
        if(bullet != null && !bullet.isImpacted()){

            bullet = null;
            vidas--;}
        if(vidas <= 0 )
            exit( 0 );


        for (int i = 0; i <= paddleList.size() - 1; i++) {

            paddleList.get( i ).update( delta );
        }
        ball.update( delta );
        if(bullet != null)
        bullet.update( delta );

        List<Rectangle> rList = new ArrayList<>();
        Rectangle r1 = null;
        //creo poligonos de modo teorico para ver cuando colisionan
        for (int i = 0; i <= paddleList.size() - 1; i++) {


            r1 = new Rectangle( paddleList.get( i ).getX(), paddleList.get( i ).getY(), paddleList.get( i ).getWidth(), paddleList.get( i ).getHeight() );


            rList.add( r1 );
        }

        Circle c = new Circle( ball.getX(), ball.getY(), ball.getSize() );
        Circle bala = null;
        if(bullet != null)
         bala = new Circle( bullet.getX(),bullet.getY(), bullet.getSize() );



        /*intersector es de la libreria. Mira cuando colisiona c (que es copia de bola) y r1 (que es copia de paddle) y cuando
        colisionan, invoco el metodo collider, que esta hecho en bola, que le cambia la velocidad */


        if(Intersector.overlaps( c, r1)){
            ball.collider();
        }


            if (bullet != null && Intersector.overlaps( bala, c)) {



                if (colorNumber < 5) {
                    this.colors = ballColors.get( this.colorNumber );
                    this.colorNumber += 1;
                } else {

                    this.colors = Color.OLIVE;
                    this.colorNumber = 0;


                }
                    impacted = true;
                    game.dispose();
                    exit(0);









        }





    }

    public List<Paddle> getPaddle() {
        return paddleList;

    }


    public Ball getBall() {
        return ball;
    }


    public Paddle getPaddle1() {
        return paddle1;
    }

    public void setBullet(Ball b){
        this.bullet = b;
    }

    public Ball getBullet() {
        return bullet;
    }

    public void restarVida(){vidas --;}

}


