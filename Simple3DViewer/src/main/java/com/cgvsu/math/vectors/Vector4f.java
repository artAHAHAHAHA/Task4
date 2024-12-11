package com.cgvsu.math.vectors;

public class Vector4f implements Vector<Vector4f> {
    private double x;
    private double y;
    private double z;
    private double w;
    public Vector4f(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4f(){

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

    public double getW(){
        return w;
    }

    @Override
    public boolean isEqual(Vector4f other) {
        return Math.abs(x - other.x) < EPS &&
                Math.abs(y - other.y) < EPS &&
                 Math.abs(z - other.z) < EPS &&
                  Math.abs(w-other.w) < EPS;
    }

    @Override
    public Vector4f add(Vector4f other) {
        return new Vector4f(this.x + other.x,
                this.y + other.y,
                this.z + other.z,
                this.w + other.w);
    }

    @Override
    public void subtract(Vector4f var1, Vector4f var2) {
        this.x = var1.x - var2.x;
        this.y = var1.y - var2.y;
        this.z = var1.z - var2.z;
        this.w = var1.w - var2.w;

    }

    @Override
    public void multiplyingVectorByScalar(double scalar) {
        this.x = Math.round(this.x * scalar * 10.0) / 10.0;
        this.y = Math.round(this.y * scalar * 10.0) / 10.0;
        this.z = Math.round(this.z * scalar * 10.0) / 10.0;
        this.w = Math.round(this.w * scalar * 10.0) / 10.0;
    }

    @Override
    public void dividingVectorByScalar(double scalar) {
        if(scalar == 0){
            throw new ArithmeticException("На 0 делить нельзя");
        }
        this.x = Math.round(this.x / scalar * 10.0) / 10.0;
        this.y = Math.round(this.y / scalar * 10.0) / 10.0;
        this.z = Math.round(this.z / scalar * 10.0) / 10.0;
        this.w = Math.round(this.w / scalar * 10.0) / 10.0;
    }

    @Override
    public double getLength() {
        double length = Math.sqrt(
                        Math.pow(this.x, 2) +
                        Math.pow(this.y, 2) +
                        Math.pow(this.z, 2) +
                        Math.pow(this.w, 2)
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
        this.w = (double) Math.round(this.w / length * 10) / 10;
    }

    @Override
    public double scalarMultiplication(Vector4f other) {
        return (this.x * other.x +
                this.y * other.y +
                this.z * other.z +
                this.w * other.w);
    }
    @Override
    public String toString() {
        return "Vector3f(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
