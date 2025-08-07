INSERT INTO servicio_hospital (id, descripcion, ubicacion, activo)
VALUES (2, 'Pediatría', 'Segundo piso', True);
INSERT INTO servicio_hospital (id, descripcion, ubicacion, activo)
VALUES (3, 'Cirugía', 'Tercer piso', True);
INSERT INTO servicio_hospital (id, descripcion, ubicacion, activo)
VALUES (4, 'Laboratorio', 'Planta baja', False);
INSERT INTO medicos (
        cedula,
        nombre,
        apellidos,
        genero,
        fecha_nacimiento,
        especialidad,
        servicio_hospital
    )
VALUES (
        123456789,
        'Gómez',
        'Juan',
        'M',
        '1985-06-15',
        'Cardiología',
        2
    );
SELECT *
from medicos;
SELECT m.cedula,
    m.nombre,
    m.apellidos,
    m.genero,
    m.fecha_nacimiento,
    m.especialidad,
    s.descripcion AS servicio_hospital
FROM medicos m
    JOIN servicio_hospital s ON m.servicio_hospital = s.id;
INSERT INTO medicos (
        cedula,
        nombre,
        apellidos,
        genero,
        fecha_nacimiento,
        especialidad,
        servicio_hospital
    )
VALUES (
        1243456798,
        'Keneth',
        'Vargas',
        'M',
        '2004-08-21',
        'Cirugía',
        3
    );