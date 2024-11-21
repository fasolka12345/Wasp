package ru.Wasp;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;

    private SpriteBatch batch;
    private Texture imgWasp;
    private Texture imgBackGround;
    private Texture imgTrump;

    private Wasp[] wasp = new Wasp[33];
    private Trump[] trump = new Trump[22];

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgWasp = new Texture("Wasp.png");
        imgBackGround = new Texture("bg.png");
        imgTrump = new Texture("Trump.png");

        for(int i = 0; i < wasp.length; i++) {
            wasp[i] = new Wasp(SCR_WIDTH/2, SCR_HEIGHT/2);
        }
        for(int i = 0; i < trump.length; i++) {
            trump[i] = new Trump(0, 0);
        }
    }

    @Override
    public void render() {
        //Касания
        if (Gdx.input.justTouched()) {
            float tx = Gdx.input.getX();
            float ty = Gdx.input.getY();
            for(int i = 0; i < wasp.length; i++) {
                if(wasp[i].hit(tx, ty)) System.out.println("wasp");
            }
            for (int i = 0; i < trump.length; i++) {
                if (trump[i].hit(tx, ty)) System.out.println("tramp");
            }
        }

        //События
        for (int i = 0; i < wasp.length; i++) {
            wasp[i].fly();
        }
        for (int i = 0; i < trump.length; i++) {
            trump[i].fly();
        }

        //Отрисовка
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for(int i = 0; i < wasp.length; i++) {
            batch.draw(imgWasp, wasp[i].x, wasp[i].y, wasp[i].width, wasp[i].height, 0, 0, 789, 575, wasp[i].flip(), false);
        }
        for (int i = 0; i < trump.length; i++) {
            batch.draw(imgTrump, trump[i].x, trump[i].y, trump[i].width, trump[i].height, 0, 0, 250, 200, trump[i].flip(), false);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
        imgWasp.dispose();
        imgTrump.dispose();
    }
}
