CREATE TABLE estudiantes (
    id SERIAL PRIMARY KEY,
    nombre_estudiante VARCHAR(255) NOT NULL,
    apellido_estudiante VARCHAR(255) NOT NULL,
    materia VARCHAR(255) NOT NULL,
    docente VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
