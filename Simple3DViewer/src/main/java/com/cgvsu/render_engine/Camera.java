package com.cgvsu.render_engine;

import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.math.matrix.Matrix4f;

public class Camera {

    public Camera(
            final Vector3f position,
            final Vector3f target,
            final float fov,
            final float aspectRatio,
            final float nearPlane,
            final float farPlane) {
        this.position = position;
        this.target = target;
        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.nearPlane = nearPlane;
        this.farPlane = farPlane;
    }

    public void setPosition(final Vector3f position) {
        this.position = position;
    }

    public void setTarget(final Vector3f target) {
        this.target = target;
    }

    public void setAspectRatio(final float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getTarget() {
        return target;
    }

    public void movePosition(final Vector3f translation) {
        this.position = this.position.add(translation);
    }

    public void moveTarget(final Vector3f translation) {
        this.target = this.target.add(translation);
    }

    Matrix4f getViewMatrix() {
        return GraphicConveyor.lookAt(position, target);
    }

    Matrix4f getProjectionMatrix() {
        return GraphicConveyor.perspective(fov, aspectRatio, nearPlane, farPlane);
    }

    private Vector3f position;
    private Vector3f target;
    private float fov;
    private float aspectRatio;
    private float nearPlane;
    private float farPlane;

    public void rotate(double deltaX, double deltaY) {
        // Вращение камеры вокруг целевой точки (target)
        Vector3f direction = new Vector3f(position.getX(), position.getY(), position.getZ());
        direction.subtract(position, target); // Используем метод экземпляра для изменения текущего объекта
        double radius = direction.getLength();

        double theta = Math.atan2(position.getZ() - target.getZ(), position.getX() - target.getX());
        double phi = Math.acos((position.getY() - target.getY()) / radius);

        // Изменяем углы на основе движения мыши с уменьшенной чувствительностью
        theta += deltaX * 0.00001; // Поменяем знак для направления по горизонтали
        phi -= deltaY * 0.00001; // Поменяем знак для направления по вертикали

        // Ограничиваем углы, чтобы избежать полярного сингулярного положения камеры
        phi = Math.max(0.01, Math.min(Math.PI - 0.01, phi));

        // Пересчитываем положение камеры
        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.cos(phi);
        double z = radius * Math.sin(phi) * Math.sin(theta);

        position = new Vector3f(target.getX() + x, target.getY() + y, target.getZ() + z);
    }


    // Методы для увеличения и уменьшения зума
    public void zoomIn() {
        this.position = this.position.add(new Vector3f(0, 0, -100));
    } // Уменьшаем расстояние по оси Z

    public void zoomOut() {
        this.position = this.position.add(new Vector3f(0, 0, 100)); // Увеличиваем расстояние по оси Z
    }
}
