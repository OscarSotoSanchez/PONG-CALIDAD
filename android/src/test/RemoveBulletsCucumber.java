package test;

import com.mygdx.pong.game.GamePong;
import com.mygdx.pong.gameloop.GameWorld;
import com.mygdx.pong.screens.GameScreen;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RemoveBulletsCucumber {

    GamePong game;
    GameScreen screen;
    GameWorld world;

    @Given("^The match isn't finished")
    public void given() {
        game = new GamePong();
        game.create();
        screen = (GameScreen) game.getScreen();
        world = screen.getWorld();
    }

    @And("^The player has <x> shots remaining$")
    public void thePlayerHasXShotsRemaining(int remaining) throws Throwable {
        System.out.println(remaining);
        world.setVidas(remaining);
    }

    @When("^The player touch the screen with two fingers$")
    public void thePlayerTouchTheScreenWithTwoFingers() throws Throwable {
        world.shootBullet();
    }

    @Then("^The bullet counter is <y>$")
    public void theBulletCounterIsY(int val) throws Throwable {
        assertEquals(world.getVidas(), val);
    }

    @And("^A bullet appears on screen$")
    public void aBulletAppearsOnScreen() throws Throwable {
        assertNotNull(world.getBullet());
    }
}
