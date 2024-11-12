CREATE TABLE IF NOT EXISTS tareas (
                                      id SERIAL PRIMARY KEY,
                                      nombre_tarea VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    fecha_entrega TIMESTAMP NOT NULL,
    estado BOOLEAN NOT NULL
    );