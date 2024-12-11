package com.cgvsu.math.vectors;

public class Vector3f implements Vector<Vector3f> {
    private double x;
    private double y;
    private double z;

    public Vector3f(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean isEqual(Vector3f other) {
        return Math.abs(x - other.x) < EPS &&
                Math.abs(y - other.y) < EPS &&
                 Math.abs(z - other.z) < EPS;
    }


    @Override
    public Vector3f add(Vector3f other) {
        return new Vector3f(this.x + other.x,
                            this.y + other.y,
                            this.z + other.z);
    }

    @Override
    public final void subtract(Vector3f var1, Vector3f var2) {
        this.x = var1.x - var2.x;
        this.y = var1.y - var2.y;
        this.z = var1.z - var2.z;
    }

    @Override
    public void multiplyingVectorByScalar(double scalar) {
        this.x = Math.round(this.x * scalar * 10.0) / 10.0;
        this.y = Math.round(this.y * scalar * 10.0) / 10.0;
        this.z = Math.round(this.z * scalar * 10.0) / 10.0;
    }

    @Override
    public void dividingVectorByScalar(double scalar) {
        if(scalar == 0){
            throw new ArithmeticException("На 0 делить нельзя");
        }
        this.x = Math.round(this.x / scalar * 10.0) / 10.0;
        this.y = Math.round(this.y / scalar * 10.0) / 10.0;
        this.z = Math.round(this.z / scalar * 10.0) / 10.0;
    }

    @Override
    public double getLength() {
        double length = Math.sqrt(
                        Math.pow(this.x, 2) +
                        Math.pow(this.y, 2) +
                        Math.pow(this.z, 2)
                        );
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
        this.z = (double) Math.round(this.z / length * 10) / 10;
    }

    @Override
    public double scalarMultiplication(Vector3f other) {
        return (this.x * other.x +
                this.y * other.y +
                this.z * other.z);
    }

    public final void cross(Vector3f var1, Vector3f var2) {
        double tempX = var1.getY() * var2.getZ() - var1.getZ() * var2.getY();
        double tempY = var1.getZ() * var2.getX() - var1.getX() * var2.getZ();
        this.z = var1.getX() * var2.getY() - var1.getY() * var2.getX();
        this.x = tempX;
        this.y = tempY;
    }


    @Override
    public String toString() {
        return "Vector3f(" + x + ", " + y + ", " + z + ")";
    }
}