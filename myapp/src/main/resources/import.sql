INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('Cirujano', 'Marcos', '654874522', 'García');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('Geriatría', 'Jose', '654874592', 'Martínez');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('Hematología', 'Laura', '654874822', 'López');
INSERT INTO `medicos` (`especialidad`, `nombre`, `telefono`, `apellidos`) VALUES ('Infectología', 'Marta', '654874528', 'González');

INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle1', '1987-03-19', 'Hugo', '15421', '654774822', 'Cordoba', 'García');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle2', '1956-06-15', 'Martín', '16542', '654554822', 'Cordoba', 'Hernández');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle3', '1988-02-27', 'Mateo', '24152', '654822822', 'Sevilla', 'Sánchez');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle4', '1944-02-03', 'Daniel', '15232', '624274822', 'Cordoba', 'Pérez');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle5', '1936-06-17', 'Miguel', '12514', '654822822', 'Cordoba', 'Rodríguez');
INSERT INTO `pacientes` (`direccion`, `fecha`, `nombre`, `codigo_postal`, `telefono`, `provincia`, `apellidos`) VALUES ('Calle6', '1948-08-01', 'Marta', '14014', '654333322', 'Cordoba', 'Sánchez');

INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('1', '2022-02-02', '1', '1', '1');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('2', '2022-02-03', '1', '1', '2');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('3', '2022-02-07', '1', '1', '3');
INSERT INTO `ingresos` (`cama`, `fecha_ingreso`, `habitacion`, `medico_id`, `paciente_id`) VALUES ('1', '2022-02-01', '2', '2', '1');