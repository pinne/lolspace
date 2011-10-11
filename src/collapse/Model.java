package collapse;

/**
 * Model-View-Controller exempel: Modellen. En klass som lagrar ett värde som
 * alltid hålls inom gränserna MIN och MAX.
 */

class Model {
    private int x;
    private int y;
    private boolean alive;
    private int color;

    public Model(int min, int max) {
        x = min;
        y = max;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        // TODO Auto-generated method stub
        return 0;
    }
}