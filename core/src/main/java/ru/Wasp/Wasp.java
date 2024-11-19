package ru.Wasp;

import static ru.Wasp.Main.SCR_HEIGHT;
import static ru.Wasp.Main.SCR_WIDTH;

public class Wasp {
    float x;
    float y;
    float width = 200;
    float height = 200;
    float stepX = 5;
    float stepY = 3;

    Wasp(float x1, float y) {
        x = x1;
        this.y = y;
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
