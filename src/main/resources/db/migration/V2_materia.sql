CREATE TABLE materia (
    id SERIAL PRIMARY KEY,
    materia VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    docente VARCHAR(255) NOT NULL,
    aula VARCHAR(50),
);