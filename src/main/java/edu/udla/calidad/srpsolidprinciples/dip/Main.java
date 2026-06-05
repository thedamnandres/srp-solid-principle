package edu.udla.calidad.srpsolidprinciples.dip;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Código Inicial (Viola DIP) ===");

        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("\n--- Procesando pago con tarjeta de crédito ---");
        processor.makePayment(150.0);

        System.out.println("\nProblema: No se pueden agregar nuevos métodos de pago");
        System.out.println("sin modificar PaymentProcessor (dependencia directa)");
    }
}
