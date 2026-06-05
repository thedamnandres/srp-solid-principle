package edu.udla.calidad.srpsolidprinciples.ocp;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
