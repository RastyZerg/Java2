package OOP;

//        3 Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
//        4 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
//        5 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    Sprite[] sprites = new Sprite[10];
    Background bground = new Background();

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        //        4 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
        //        5 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    addCircle(sprites, e.getX(), e.getY());
                }
                else if (e.getButton() == MouseEvent.BUTTON3) {
                    if(sprites.length > 0){
                        removeCircle(sprites);
                    }
                }
            }
        });
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    //        5 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
    private void removeCircle(Sprite[] sprites){
        int len = sprites.length;
        this.sprites = new Sprite[len - 1];
        for (int i = 0; i < len - 1; i++){
            this.sprites[i] = sprites[i];
        }
    }

    //        4 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
    private void addCircle(Sprite[] sprites, int x, int y){
        int len = sprites.length;
        this.sprites = new Sprite[len+1];
        for (int i = 0; i < len; i++){
            this.sprites[i] = sprites[i];
        }
        this.sprites[len] = new Ball();
        this.sprites[len].x = x;
        this.sprites[len].y = y;
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        //        3 Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
        bground.update(canvas, deltaTime);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
