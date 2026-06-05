package edu.udla.calidad.srpsolidprinciples.isp;

public class DisposableCamera implements Device {
    @Override
    public void turnOn() {
        System.out.println("Disposable camera is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Disposable camera is turning off.");
    }

    @Override
    public void charge() {
        throw new UnsupportedOperationException("Disposable cameras cannot be charged.");
    }
}
