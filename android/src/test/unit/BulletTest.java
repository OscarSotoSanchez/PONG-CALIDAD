package test.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.mygdx.pong.frameworkhelper.InputHandler;
import com.mygdx.pong.game.GamePong;
import com.mygdx.pong.gameloop.GameWorld;
import com.mygdx.pong.screens.GameScreen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BulletTest {

    private static int screenWidth = 1600;
    private static int screenHeight = 900;

    private GameWorld world;

    @Before
    public void setupTest() {
        Gdx gdxMock = Mockito.mock(Gdx.class);

        Graphics graphicsMock = Mockito.mock(Graphics.class);
        gdxMock.graphics = graphicsMock;
        Mockito.when(graphicsMock.getWidth()).thenReturn(screenWidth);
        Mockito.when(graphicsMock.getHeight()).thenReturn(screenHeight);

        InputHandler inputHandlerMock = Mockito.mock(InputHandler.class);
        Mockito.when(gdxMock.input.getInputProcessor()).thenReturn(inputHandlerMock);

        GamePong game = new GamePong();
        game.create();
        GameScreen screen = (GameScreen) game.getScreen();
        world = screen.getWorld();
        world.setVidas(5);
    }

    @Test
    public void testCounterWhenBulletFired() {
        int vidasIniciales = world.getVidas();
        world.restarVida();
        Assert.assertEquals(world.getVidas(), vidasIniciales - 1);
    }
}
