public class Point<T> {

    private final T x;
    private final T y;
    private int direction;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
        this.direction = 0;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}