package test;

import com.mygdx.pong.game.GamePong;
import com.mygdx.pong.gameloop.GameWorld;
import com.mygdx.pong.screens.GameScreen;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Hgmoa on 23/04/2018.
 */

public class ShootBulletCucumber {

    GamePong game;
    GameScreen screen;
    GameWorld world;

    @Given("The match isn't finished")
    public void matchIsntFinished() {
        game = new GamePong();
        game.create();
        screen = (GameScreen) game.getScreen();
        world = screen.getWorld();
    }

    @When("The player touch the screen with two fingers")
    public void playerShoots() {
        world.shootBullet();
    }

    @Then("^The paddle shots a bullet$")
    public void thePaddleShotsABullet() {
        assertNotNull(world.getBullet());
    }
}
