# Sistema de Almacén - Arquitectura Hexagonal

Este es un proyecto Java que implementa una Arquitectura Hexagonal (Puertos y Adaptadores) para un sistema de gestión de inventario/almacén. El proyecto demuestra principios de arquitectura limpia con separación clara entre las capas de dominio, aplicación e infraestructura.

## Arquitectura

El proyecto sigue la Arquitectura Hexagonal con estas capas:

1. **Capa de Dominio** (`almacen.domain/`):
   - `Articulo.java`: Entidad de dominio central que representa un artículo/ítem
   - `ArticuloRepositoryPort.java`: Interfaz de puerto que define operaciones del repositorio

2. **Capa de Aplicación** (`almacen.application/`):
   - `ArticuloUseCase.java`: Puerto primario que define los casos de uso
   - `ArticuloUseCaseImpl.java`: Implementación de los casos de uso
   - `ArticuloDTO.java`: Objeto de Transferencia de Datos para presentación

3. **Capa de Infraestructura** (`almacen.infrastructure/`):
   - `ArticuloRepositoryAdapter.java`: Adaptador que implementa `ArticuloRepositoryPort` para PostgreSQL
   - `DB.java`: Utilidad de conexión a base de datos
   - `ListaArticulosPresenter.java`: Presentador para mostrar artículos
   - `db/migrations/`: Archivos de migración de base de datos usando un sistema simple de migraciones

4. **Punto de Entrada**:
   - `App.java`: Clase principal de la aplicación que conecta los componentes

## Base de Datos

- **Base de datos**: PostgreSQL ejecutándose en `localhost:5432`
- **Nombre de base de datos**: `ucb`
- **Credenciales**: `ucb`/`Tarija00`
- **Esquema**: Esquema `almacen` con tablas: `articulo`, `empleado`, `solicitud`, `detalle_solicitud`
- **Migraciones**: Ubicadas en `src/almacen/infrastructure/db/migrations/`
  - Configuración de migraciones: `dbconfig.yml`
  - Usa archivos de migración basados en timestamp (ej: `20260327101720-base.sql`)

## Dependencias

- **Controlador JDBC de PostgreSQL**: `postgresql-42.7.5.jar` (en directorio `lib/`)
- El proyecto parece ser un proyecto Java simple sin sistema de construcción Maven/Gradle

## Comandos de Desarrollo

Dado que este es un proyecto Java simple sin sistema de construcción:

1. **Compilar y Ejecutar**:
   ```bash
   javac -cp "lib/*:." src/App.java src/almacen/**/*.java
   java -cp "lib/*:src" App
   ```

2. **Migraciones de Base de Datos**:
   - Los archivos de migración están en `src/almacen/infrastructure/db/migrations/`
   - Cada migración tiene secciones `-- +migrate Up` y `-- +migrate Down`
   - Se requiere ejecución manual (no hay herramienta de migración configurada)

3. **Conexión a Base de Datos**:
   - Configurada en `DB.java` con credenciales hardcodeadas
   - URL de conexión: `jdbc:postgresql://localhost:5432/ucb`

## Patrones de Diseño Clave

1. **Arquitectura Hexagonal**: Separación clara de responsabilidades con puertos y adaptadores
2. **Inversión de Dependencias**: El dominio define interfaces, la infraestructura las implementa
3. **Patrón Repositorio**: `ArticuloRepositoryPort` abstrae el acceso a datos
4. **Patrón Caso de Uso**: `ArticuloUseCase` define servicios de aplicación
5. **Patrón DTO**: `ArticuloDTO` separa el dominio de la presentación

## Notas Importantes

- El proyecto es un ejemplo educativo de Arquitectura Hexagonal
- Las credenciales de base de datos están hardcodeadas en `DB.java` y `dbconfig.yml`
- No hay archivos de prueba ni framework de pruebas configurado
- No hay automatización de construcción (Maven/Gradle)
- Usa estructura de paquetes simple: `almacen.{domain,application,infrastructure}`

## Tareas Comunes de Desarrollo

Al agregar nuevas funcionalidades:
1. Agregar entidades/interfaces de dominio en `almacen.domain/`
2. Definir casos de uso en `almacen.application/`
3. Implementar adaptadores en `almacen.infrastructure/`
4. Actualizar `App.java` para conectar nuevos componentes
5. Agregar migraciones de base de datos si es necesario

Al modificar el esquema de base de datos:
1. Crear nuevo archivo de migración en `src/almacen/infrastructure/db/migrations/`
2. Seguir convención de nombres: `YYYYMMDDHHMMSS-descripcion.sql`
3. Incluir ambas secciones `-- +migrate Up` y `-- +migrate Down`
4. Aplicar migraciones manualmente a la base de datos
