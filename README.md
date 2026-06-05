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

*Este documento se actualizará iterativamente conforme se implementen más principios SOLID.*
