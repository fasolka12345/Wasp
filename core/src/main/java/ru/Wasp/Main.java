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
    Wasp Wasp;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("Wasp.png");
        Wasp = new Wasp();
    }

    @Override
    public void render() {
        Wasp.fly();
        ScreenUtils.clear(1f, 1f, 1f, 1f);
        batch.begin();
        batch.draw(image, Wasp.x, Wasp.y, Wasp.width, Wasp.height);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
