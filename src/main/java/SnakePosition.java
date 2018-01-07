public class SnakePosition {
    private Integer headX=0;
    private Integer headY=0;
    private Integer size=1;

    public Direction getActualDirection() {
        return actualDirection;
    }

    public void setActualDirection(Direction actualDirection) {
        this.actualDirection = actualDirection;
    }

    private Direction actualDirection = Direction.RIGHT;

    public Integer getHeadX() {
        return headX;
    }

    public void setHeadX(Integer headX) {
        this.headX = headX;
    }

    public Integer getHeadY() {
        return headY;
    }

    public void setHeadY(Integer headY) {
        this.headY = headY;
    }

    public Integer getSize() {
        return size;
    }

    public void incrementSize() {
        this.size++;
    }
}
