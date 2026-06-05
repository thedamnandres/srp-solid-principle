package edu.udla.calidad.srpsolidprinciples.isp;

public class DisposableCameraRefactored implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Disposable camera is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Disposable camera is turning off.");
    }
}
