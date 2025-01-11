DROP DATABASE IF EXISTS apiHoteles;
CREATE DATABASE apiHoteles;
USE apiHoteles;

    CREATE TABLE Hotel (
       idhotel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(100) NOT NULL,
       descripcion TEXT,
       categoria VARCHAR(50),
       piscina BOOLEAN DEFAULT FALSE,
       localidad VARCHAR(100)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;

    INSERT INTO Hotel (nombre, descripcion, categoria, piscina, localidad)
    VALUES
        ('Hotel Playa', 'Un hermoso hotel en la playa.', '5 estrellas', TRUE, 'Cancún'),
        ('Hotel Montaña', 'Un acogedor hotel en las montañas.', '4 estrellas', FALSE, 'Andorra'),
        ('Hotel Ciudad', 'Hotel en el centro de la ciudad.', '3 estrellas', FALSE, 'Madrid');

    CREATE TABLE Habitacion (
        idhabitacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        tamano INT NOT NULL,
        capacidad INT NOT NULL,
        precioPorNoche DECIMAL(10, 2) NOT NULL,
        incluyeDesayuno BOOLEAN DEFAULT FALSE,
        ocupada BOOLEAN DEFAULT FALSE,
        idhotel INT,
        FOREIGN KEY (idhotel) REFERENCES Hotel(idhotel)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;

    INSERT INTO Habitacion (tamano, capacidad, precioPorNoche, incluyeDesayuno, ocupada, idhotel)
    VALUES
        (25, 2, 100.00, TRUE, FALSE, 1),
        (20, 1, 80.00, FALSE, TRUE, 1),
        (30, 2, 120.00, TRUE, FALSE, 2),
        (15, 1, 60.00, FALSE, FALSE, 3),
        (40, 2, 150.00, TRUE, FALSE, 2);