package com.cgvsu.math.vectors;

public class Vector2f implements Vector<Vector2f> {
    private double x;
    private double y;

    public Vector2f(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean isEqual(Vector2f other) {
        return Math.abs(x - other.x) < EPS &&
                Math.abs(y - other.y) < EPS;
    }

    @Override
    public Vector2f add(Vector2f other) {
        return new Vector2f(this.x + other.x,
                            this.y + other.y);
    }

    @Override
    public final void subtract(Vector2f var1, Vector2f var2) {
        this.x = var1.x - var2.x;
        this.y = var1.y - var2.y;
    }


    @Override
    public void multiplyingVectorByScalar(double scalar) {
        this.x = Math.round(this.x * scalar * 10.0) / 10.0;
        this.y = Math.round(this.y * scalar * 10.0) / 10.0;
    }

    @Override
    public void dividingVectorByScalar(double scalar) {
        if(scalar == 0){
            throw new ArithmeticException("На 0 делить нельзя");
        }
        this.x = Math.round(this.x / scalar * 10.0) / 10.0;
        this.y = Math.round(this.y / scalar * 10.0) / 10.0;
    }

    @Override
    public double getLength() {
        double length = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        return Math.round(length * 10.0) / 10.0;
    }

    @Override
    public void normalize() {
        double length = getLength();
        if (length == 0) {
            throw new ArithmeticException("Длина равна 0, вектор нормализовать нельзя");
        }
        this.x = (double) Math.round(this.x / length * 10) / 10;
        this.y = (double) Math.round(this.y / length * 10) / 10;
    }

    @Override
    public double scalarMultiplication(Vector2f other) {
        return (this.x * other.x + this.y * other.y);
    }

    @Override
    public String toString() {
        return "Vector2f(" + x + ", " + y + ")";
    }
}
