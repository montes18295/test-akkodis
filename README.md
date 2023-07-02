# Akkodis TEST

Prueba técnica para akkodis.

## Requisitos previos

Asegúrate de tener instalado lo siguiente:

- Java JDK (versión 20.0.1)
- Maven (versión 3.8.1)

## Estructura del proyecto

###  Carpetas
Sigue una estructura de arquitectura hexagonal.

```
├── main
│   ├── java
│   │   └── org.akkodis.test
│   │       ├── application
│   │       │   └── ...
│   │       ├── domain
│   │       │   └── ...
│   │       └── infrastructure
│   │           └── ...
│   └── resources
│       ├── database 
│       └── messages
└── test
    ├── java
    │   └── org.akkodis.test
    │       ├── application 
    │       │   └── ...
    │       └── domain
    │           └── ...
    └── resources
        └── database
```

En el paquete de application se encontrará la exposición de datos de la aplciación y relacionados. (dto, control de errores para respuesta etc).

En la paquetería domain se encontrará toda la lógica de negocio y relacionados, sin dependencia de librerías ni framework alguno para el correcto desarrollo DDD.

En infrastructure se encuentra la configuración de la aplicación (al ser configuraciones propias del framework, de esta manera no añadimos dependencias del framework a la capa de dominio).
También se encuentra la implementación de las distintas "conexiones" a las fuentes de datos, en este caso una base de datos H2.