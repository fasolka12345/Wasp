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
    Wasp[] wasp = new Wasp[33];

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("Wasp.png");
        for(int i = 0; i < wasp.length; i++) {
            wasp[i] = new Wasp(SCR_WIDTH/2, SCR_HEIGHT/2);
        }
    }

    @Override
    public void render() {
        for(int i = 0; i < wasp.length; i++) {
            wasp[i].fly();
        }
        ScreenUtils.clear(1f, 1f, 1f, 1f);
        batch.begin();
        for(int i = 0; i < wasp.length; i++) {
            batch.draw(image, wasp[i].x, wasp[i].y, wasp[i].width, wasp[i].height, 0, 0, 789, 575, wasp[i].flip(), false);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
