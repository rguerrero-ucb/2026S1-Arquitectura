-- +migrate Up
-- Insertar datos de prueba para empleados
INSERT INTO almacen.empleado (id, nombre) VALUES
(1, 'Juan Pérez'),
(2, 'María García'),
(3, 'Carlos López'),
(4, 'Ana Martínez')
ON CONFLICT (id) DO NOTHING;

-- +migrate Down
-- Eliminar los datos de prueba
DELETE FROM almacen.empleado WHERE id IN (1, 2, 3, 4);