package ru.Wasp;

import static ru.Wasp.Main.SCR_HEIGHT;
import static ru.Wasp.Main.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Wasp {
    float x;
    float y;
    float width = 200;
    float height = 200;
    float stepX = 5;
    float stepY = 3;

    Wasp(float x, float y) {
        this.x = x;
        this.y = y;
        width = height = MathUtils.random(50, 150);
        stepX = MathUtils.random(-5, 5);
        stepY = MathUtils.random(-5, 5);
    }

    void fly() {
        x += stepX;
        y += stepY;
        if (x > SCR_WIDTH - width|| x < 0) stepX = -stepX;
        if (y > SCR_HEIGHT - height|| y < 0) stepY = -stepY;
    }

    boolean flip(){
        return stepX < 0;
    }
}
