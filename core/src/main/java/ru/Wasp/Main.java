package ru.Wasp;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Vector3 touch;

    private Texture imgWasp;
    private Texture imgBackGround;
    private Texture imgTrump;

    private Wasp[] wasp = new Wasp[33];
    private Trump[] trump = new Trump[22];

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

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
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            for (Wasp w: wasp) {
                if(w.hit(touch.x, touch.y)) {
                    w.leave();
                }
            }
            for (Trump t: trump) {
                if(t.hit(touch.x, touch.y)) {
                    t.leave();
                }
            }
        }

        //События
        for (Wasp w: wasp) {
            w.fly();
        }
        for (Trump t: trump) {
            t.fly();
        }

        //Отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for(Wasp w: wasp) {
            batch.draw(imgWasp, w.x, w.y, w.width, w.height, 0, 0, 789, 575, w.flip(), w.isLeave);
        }
        for (Trump t: trump) {
            batch.draw(imgTrump, t.x, t.y, t.width/2, t.height/2, t.width, t.height, 1, 1, t.rotation, 0, 0, 250, 200, t.flip(), t.isLeave);
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

