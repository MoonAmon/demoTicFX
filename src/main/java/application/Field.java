package application;

import javafx.scene.shape.Line;

public class Field {
    private final Line line1 = new Line(200, 0, 200, 600);
    private final Line line2 = new Line(400, 0, 400, 600);
    private final Line line3 = new Line(0, 200, 600, 200);
    private final Line line4 = new Line(0, 400, 600, 400);

    public void setStrokeWidth(double value) {
        this.line1.setStrokeWidth(value);
        this.line2.setStrokeWidth(value);
        this.line3.setStrokeWidth(value);
        this.line4.setStrokeWidth(value);
    }

    public Line getLine1() {
        return line1;
    }

    public Line getLine2() {
        return line2;
    }

    public Line getLine4() {
        return line4;
    }

    public Line getLine3() {
        return line3;
    }
}
