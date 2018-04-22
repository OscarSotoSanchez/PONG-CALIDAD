package test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.mygdx.pong.game.GamePong;
import com.mygdx.pong.gameloop.GameWorld;
import com.mygdx.pong.screens.GameScreen;

import org.mockito.Mockito;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BallHitWallCucumber {
    GamePong game;
    GameScreen screen;
    GameWorld world;
    private static int screenWidth = 1600;
    private static int screenHeight = 900;

    @Given("^The ball is in motion$")
    public void theBallIsInMotion() {
        Gdx gdxMock = Mockito.mock(Gdx.class);

        Graphics graphicsMock = Mockito.mock(Graphics.class);
        gdxMock.graphics = graphicsMock;
        Mockito.when(graphicsMock.getWidth()).thenReturn(screenWidth);
        Mockito.when(graphicsMock.getHeight()).thenReturn(screenHeight);

        game = new GamePong();
        game.create();
        screen = (GameScreen) game.getScreen();
        world = screen.getWorld();
    }
    @When("^The ball touches one side of the screen")
    public void ballTouchesSide(){
        world.getBall();
    }
    @Then("^The ball should appear on the oposite side of the screen, with same angle")
    public void ballAppearOpositeSide(){

    }
}
