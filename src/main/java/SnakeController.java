public class SnakeController {
    void goLeft(SnakePosition snakePosition) {
        Integer headX = snakePosition.getHeadX() - Conf.STEP;
        if (headX < 0) {
            headX += 500;
        }
        snakePosition.setHeadX(headX);
    }

    void goRigth(SnakePosition snakePosition) {
        Integer headX = snakePosition.getHeadX() + Conf.STEP;
        if (headX > 500) {
            headX -= 500;
        }
        snakePosition.setHeadX(headX);
    }

    void goUp(SnakePosition snakePosition) {
        Integer headY = snakePosition.getHeadY() - Conf.STEP;
        if (headY < 0) {
            headY += 500;
        }
        snakePosition.setHeadY(headY);
    }

    void goDown(SnakePosition snakePosition) {
        Integer headY = snakePosition.getHeadY() + Conf.STEP;
        if (headY > 500) {
            headY = 500 - headY;
        }
        snakePosition.setHeadY(headY);
    }
}
