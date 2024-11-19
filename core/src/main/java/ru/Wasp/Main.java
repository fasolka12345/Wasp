package ru.Wasp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;
    private SpriteBatch batch;
    private Texture image;
    Wasp Wasp, Wasp1, Wasp2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("Wasp.png");
        Wasp = new Wasp(0, 0);
        Wasp1 = new Wasp(500, 200);
        Wasp2 = new Wasp(100, 300);
    }

    @Override
    public void render() {
        Wasp.fly();
        Wasp1.fly();
        Wasp2.fly();
        ScreenUtils.clear(1f, 1f, 1f, 1f);
        batch.begin();
        batch.draw(image, Wasp.x, Wasp.y, Wasp.width, Wasp.height, 0, 0, 789, 575 , Wasp.flip(), false);
        batch.draw(image, Wasp1.x, Wasp1.y, Wasp1.width, Wasp1.height, 0, 0, 789, 575 , Wasp1.flip(), false);
        batch.draw(image, Wasp2.x, Wasp2.y, Wasp2.width, Wasp2.height, 0, 0, 789, 575 , Wasp2.flip(), false);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
