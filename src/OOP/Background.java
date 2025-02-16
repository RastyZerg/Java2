//        3 Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
package OOP;

import java.awt.*;

public class Background {
    private float HUE = 0;
    private static final float SATURATION = 1;
    private static final float BRIGHTNESS = 1;

    Background(){
    }

    void update(GameCanvas canvas, float deltaTime){
        HUE += (deltaTime * 10);
        canvas.setBackground(Color.getHSBColor((HUE % 360) / 360 , SATURATION, BRIGHTNESS));
    }
}
