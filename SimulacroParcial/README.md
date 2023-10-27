# Requisitos
- Android Studio
- Usar la version 17 JVM (Java Virtual Machine)

# Instalación

Agregar en `main/res/values` una archivo xml `custom.xml` con el siguiente formato:
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    // api key
    <string name="api_key"></string>
    <string name="base_url"></string>
</resources>
```

Rellenar con los valores necesarios para conectarse a Ninja Api (Cars)