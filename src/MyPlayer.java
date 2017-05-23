import javafx.scene.shape.Circle;

import static java.lang.Math.abs;

/**
 * Created by uzerr on 09.05.2017.
 */
public class MyPlayer implements Player {
    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map map) {
        this.map = map;
        ball = map.getBall();
        int x = (int) map.getBall().getCenterX();
        int y = (int) map.getBall().getCenterY();
        position = new Position(x, y);
    }

    @Override
    public void moveRight() {
        Boolean can = true;
        Boolean loop1 = false;

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.getMap()[i][j] == 0) {
                    continue;
                } else if (map.getMap()[i][j] == 1){
                    if(abs((j*50 + 15) - ball.getCenterX()) >= 50 || abs(ball.getCenterY() - (i*50 + 25)) >= 50) {
                        continue;
                    } else {
                        can = false;
                        loop1 = true;
                        break;
                    }
                }
            }
            if(loop1) {
                break;
            }
        }

        if(ball.getCenterX()<(map.getSize()*50)-ball.getRadius() - 10 && can)
        {
            ball.setCenterX(ball.getCenterX()+50); // moving the ball so that it won't go out of the game
        }
    }

    @Override
    public void moveLeft() {
        Boolean can = true; // can move
        Boolean loop1 = false; // in order to break the loop (there are 2 loops)

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.getMap()[i][j] == 0) {
                    continue;
                } else if (map.getMap()[i][j] == 1){
                    if(abs((j*50 + 35) - ball.getCenterX()) >= 50 || abs(ball.getCenterY() - (i*50 + 25)) >= 50) {
                        continue;
                    } else {
                        can = false; // cannot move
                        loop1 = true; // in order to break the loop
                        break;
                    }
                }
            }
            if(loop1) {
                break; // in order to break the loop
            }
        }
        if(ball.getCenterX()>(0+ball.getRadius()) + 10 && can){
            ball.setCenterX(ball.getCenterX() - 50);}

    }

    @Override
    public void moveUp() {
        Boolean can = true;
        Boolean loop1 = false;

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.getMap()[i][j] == 0) {
                    continue;
                } else if (map.getMap()[i][j] == 1){
                    if(abs((j*50 + 25) - ball.getCenterX()) >= 50 || abs(ball.getCenterY() - (i*50 + 35)) >= 50) {
                        continue;
                    } else {
                        can = false;
                        loop1 = true;
                        break;
                    }
                }
            }
            if(loop1) {
                break;
            }
        }

        if(ball.getCenterY()>(0+ball.getRadius()) + 10 && can){
            ball.setCenterY(ball.getCenterY() - 50);}
    }

    @Override
    public void moveDown() {
        Boolean can = true;
        Boolean loop1 = false;

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.getMap()[i][j] == 0) {
                    continue;
                } else if (map.getMap()[i][j] == 1){
                    if(abs((j*50 + 25) - ball.getCenterX()) >= 50 || abs(ball.getCenterY() - (i*50 + 15)) >= 50) {
                        continue;
                    } else {
                        can = false;
                        loop1 = true;
                        break;
                    }
                }
            }
            if(loop1) {
                break;
            }
        }
        if(ball.getCenterY()<(map.getSize()*50-ball.getRadius()) - 10 && can){
            ball.setCenterY(ball.getCenterY() + 50);}
    }

    @Override
    public Position getPosition() {
        return new Position((int) ball.getCenterX(), (int) ball.getCenterY());
    }

}
