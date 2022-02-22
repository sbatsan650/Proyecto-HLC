INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E1', 'Medico', '111111111', '1');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E2', 'Medico', '111111111', '2');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E3', 'Medico', '111111111', '3');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E4', 'Medico', '111111111', '4');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E5', 'Medico', '111111111', '5');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('E6', 'Medico', '111111111', '6');

INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle1', '2022-02-17', 'Nombre1', '12321', '111111111', 'Cordoba', 'Apellido1');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle2', '2022-02-17', 'Nombre2', '12321', '111111111', 'Cordoba', 'Apellido2');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle3', '2022-02-17', 'Nombre3', '12321', '111111111', 'Cordoba', 'Apellido3');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle4', '2022-02-17', 'Nombre4', '12321', '111111111', 'Cordoba', 'Apellido4');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle5', '2022-02-17', 'Nombre5', '12321', '111111111', 'Cordoba', 'Apellido5');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle6', '2022-02-17', 'Nombre6', '12321', '111111111', 'Cordoba', 'Apellido6');

INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('1', '2022-02-09', '1', '1', '1');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('2', '2022-02-09', '1', '1', '2');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('3', '2022-02-09', '1', '1', '3');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('1', '2022-02-09', '2', '2', '1');