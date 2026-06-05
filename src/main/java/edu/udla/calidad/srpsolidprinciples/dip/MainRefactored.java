package edu.udla.calidad.srpsolidprinciples.dip;

public class MainRefactored {
    public static void main(String[] args) {
        System.out.println("=== Código Refactorizado (Cumple DIP) ===");

        System.out.println("\n--- Procesando pagos con diferentes métodos ---");

        PaymentMethod creditCard = new CreditCardPaymentRefactored();
        PaymentProcessorRefactored processor1 = new PaymentProcessorRefactored(creditCard);
        processor1.makePayment(150.0);

        PaymentMethod paypal = new PayPalPayment();
        PaymentProcessorRefactored processor2 = new PaymentProcessorRefactored(paypal);
        processor2.makePayment(200.0);

        PaymentMethod crypto = new CryptoPayment();
        PaymentProcessorRefactored processor3 = new PaymentProcessorRefactored(crypto);
        processor3.makePayment(300.0);

        System.out.println("\nVentaja: PaymentProcessor depende de la abstracción PaymentMethod");
        System.out.println("Se pueden agregar nuevos métodos de pago sin modificar el código existente");
    }
}
