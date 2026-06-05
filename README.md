# Principios SOLID en Java

Este proyecto demuestra la aplicación de los principios SOLID mediante ejemplos prácticos en Java con Spring Boot.

## Principios Implementados

### S - Single Responsibility Principle (SRP)

#### Definición
"Una clase debe tener una única razón para cambiar."

El SRP establece que cada clase debe encargarse de una sola responsabilidad o tarea, lo que facilita el mantenimiento, la comprensión y la evolución del código.

#### Problema Identificado
La clase `UserManager` inicial violaba el SRP al tener múltiples responsabilidades:
- **Validación**: Verificar que el email y password sean válidos
- **Persistencia**: Guardar usuarios en la base de datos
- **Notificación**: Enviar emails de bienvenida

Esto generaba varias razones para cambiar la clase:
- Cambios en las reglas de validación
- Cambios en el mecanismo de persistencia
- Cambios en el sistema de notificaciones

#### Solución Implementada
Refactorizamos el código separando las responsabilidades en clases independientes:

**Antes (viola SRP):**
```
UserManager
├── Validación de email
├── Validación de password
├── Guardar en BD
└── Enviar email
```

**Después (cumple SRP):**
```
UserValidator      → Solo validación
UserRepository     → Solo persistencia
NotificationService → Solo notificaciones
UserService        → Orquestador que compone las anteriores
```

#### Beneficios Obtenidos
1. **Mayor cohesión**: Cada clase tiene un propósito claro y específico
2. **Menor acoplamiento**: Los cambios en una responsabilidad no afectan a las demás
3. **Mejor testabilidad**: Podemos probar cada clase de forma aislada
4. **Reutilización**: Las clases pueden usarse en otros contextos
5. **Mantenibilidad**: Es más fácil entender y modificar código con responsabilidades únicas

#### Reflexión
La aplicación del SRP nos permitió transformar una clase monolítica en un diseño modular donde cada componente tiene una responsabilidad bien definida. Esto no solo mejora la calidad del código, sino que también facilita la colaboración en equipo y la evolución del sistema a largo plazo.

La clave del SRP no es solo dividir código, sino identificar las "razones para cambiar" naturales del dominio y agruparlas coherentemente. En nuestro caso, la validación, la persistencia y las notificaciones son claramente responsabilidades distintas que pueden evolucionar de forma independiente.

---

### O - Open/Closed Principle (OCP)

#### Definición
"Las entidades de software (clases, módulos, funciones) deben estar abiertas para extensión, pero cerradas para modificación."

El OCP promueve sistemas flexibles que pueden adaptarse a cambios en requisitos sin modificar el código existente, minimizando errores en el comportamiento.

#### Problema Identificado
La clase `NotificationService` inicial violaba el OCP al usar una estructura condicional (if/else) para manejar diferentes tipos de notificaciones:

```java
if (type.equals("Email")) { ... }
else if (type.equals("SMS")) { ... }
else if (type.equals("Push")) { ... }
else { System.out.println("Invalid notification type!"); }
```

Cada vez que se agregaba un nuevo tipo de notificación (como Fax), era necesario **modificar** la clase existente, lo que:
- Introducía riesgo de bugs en código ya probado
- Violaba el principio de "cerrado para modificación"
- Requería recompilar y retestear toda la clase

#### Solución Implementada
Utilizamos polimorfismo mediante una interfaz `Notification` y clases concretas para cada tipo:

**Antes (viola OCP):**
```
NotificationService
├── if Email → lógica email
├── else if SMS → lógica SMS
├── else if Push → lógica push
└── else → error
```

**Después (cumple OCP):**
```
Notification (interfaz)
├── EmailNotification
├── SMSNotification
├── PushNotification
└── FaxNotification (nuevo, sin modificar existentes)

NotificationManager → Delega a cualquier Notification (polimorfismo)
```

#### Beneficios Obtenidos
1. **Extensibilidad**: Nuevos tipos de notificación se agregan creando nuevas clases, sin tocar código existente
2. **Estabilidad**: El código probado no se modifica, reduciendo bugs
3. **Polimorfismo**: `NotificationManager` funciona con cualquier implementación de `Notification`
4. **Principio DRY**: Cada tipo de notificación encapsula su propia lógica
5. **Testabilidad**: Cada implementación puede probarse independientemente

#### Reflexión
El OCP transforma la forma en que abordamos los cambios. En lugar de modificar código existente (arriesgado), extendemos el sistema creando nuevas clases (seguro). La clave está en diseñar abstracciones estables (como la interfaz `Notification`) que permitan la extensión sin modificación.

En nuestro ejemplo, agregar soporte para notificaciones por Fax requirió solo crear `FaxNotification` que implementa `Notification`. No tocamos `EmailNotification`, `SMSNotification`, `PushNotification`, ni `NotificationManager`. Esto demuestra que el sistema está "abierto para extensión" (podemos agregar Fax) pero "cerrado para modificación" (no cambiamos código existente).

El OCP es fundamental para construir sistemas mantenibles a largo plazo, especialmente en entornos donde los requisitos cambian frecuentemente.

---

### L - Liskov Substitution Principle (LSP)

#### Definición
"Las clases derivadas deben ser sustituibles por sus clases base sin alterar el comportamiento del programa."

El LSP asegura que el uso de una clase hija en lugar de su clase padre no rompa la lógica o cause errores inesperados.

#### Problema Identificado
La clase base `Animal` definía un método `walk()` que todas las subclases heredaban. Sin embargo, `Fish` no puede caminar, lo que generaba una excepción en tiempo de ejecución:

```java
class Fish extends Animal {
    @Override
    public void walk() {
        throw new UnsupportedOperationException("Fish can't walk.");
    }
}
```

Esto viola el LSP porque `Fish` no es sustituible por `Animal` sin alterar el comportamiento del programa. El contrato implícito de `Animal.walk()` no se cumple para todas las subclases.

#### Solución Implementada
Rediseñamos la jerarquía separando los comportamientos en interfaces independientes:

**Antes (viola LSP):**
```
Animal
├── makeSound()
└── walk()
    ├── Dog → funciona
    └── Fish → lanza excepción (rompe LSP)
```

**Después (cumple LSP):**
```
AnimalRefactored (abstracta)
└── makeSound()

Walkable (interfaz)
├── DogRefactored  → camina y nada
└── BirdRefactored → camina, no nada

Swimmable (interfaz)
├── DogRefactored  → camina y nada
└── FishRefactored → nada, no camina
```

#### Beneficios Obtenidos
1. **Sustituibilidad garantizada**: Cada subclase cumple completamente el contrato de su clase base o interfaz
2. **Sin excepciones en tiempo de ejecución**: No hay métodos que lancen `UnsupportedOperationException`
3. **Composición flexible**: Las clases implementan solo las interfaces que tienen sentido para ellas
4. **Polimorfismo seguro**: Los arrays de `Walkable` o `Swimmable` solo contienen animales que realmente pueden realizar esa acción
5. **Extensibilidad**: Nuevos animales pueden implementar las combinaciones de interfaces que necesiten

#### Reflexión
El LSP nos obliga a pensar cuidadosamente en los contratos de nuestras abstracciones. El problema fundamental no era técnico sino de diseño: habíamos asumido que "todos los animales caminan", lo cual es falso.

La solución no fue forzar a `Fish` a implementar `walk()` de alguna manera artificial, sino replantear la abstracción. En lugar de una jerarquía rígida, usamos interfaces de comportamiento (`Walkable`, `Swimmable`) que cada animal implementa según sus capacidades reales.

Este principio está estrechamente relacionado con el diseño por contrato: si una clase base establece un contrato (como `walk()`), todas las subclases deben cumplirlo. Si no pueden, la abstracción está mal diseñada.

El LSP es esencial para construir jerarquías de clases robustas donde el polimorfismo funcione de manera predecible y segura.

---

## Comandos de Ejecución y Pruebas

### Compilación
```bash
mvn clean compile
```

### Ejecutar Tests
```bash
mvn test
```

### Principio SRP (Single Responsibility Principle)

**Código inicial (viola SRP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.srp.Main"
```

**Código refactorizado (cumple SRP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.srp.MainRefactored"
```

### Principio OCP (Open/Closed Principle)

**Código inicial (viola OCP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.ocp.Main"
```
*Nota: Este código muestra "Invalid notification type!" para Fax porque no está soportado.*

**Código refactorizado (cumple OCP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.ocp.MainRefactored"
```
*Nota: Fax funciona correctamente sin haber modificado código existente.*

### Principio LSP (Liskov Substitution Principle)

**Código inicial (viola LSP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.lsp.Main"
```
*Nota: Este código lanza una excepción `UnsupportedOperationException` cuando se intenta que un pez camine.*

**Código refactorizado (cumple LSP):**
```bash
mvn compile exec:java "-Dexec.mainClass=edu.udla.calidad.srpsolidprinciples.lsp.MainRefactored"
```
*Nota: Todos los animales funcionan correctamente sin excepciones. Perro camina y nada, pez solo nada, pájaro solo camina.*

---

*Este documento se actualizará iterativamente conforme se implementen más principios SOLID.*
