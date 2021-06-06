-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2021 a las 16:22:00
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `48h`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `nombre` varchar(100) NOT NULL,
  `nomCorto` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`nombre`, `nomCorto`) VALUES
('Amarillo', 'Ama'),
('Azul', 'Az'),
('Rojo', 'Rj');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas`
--

CREATE TABLE `estadisticas` (
  `id` int(11) NOT NULL,
  `golesTot` varchar(11) NOT NULL,
  `tirosPuerta` varchar(11) NOT NULL,
  `amarillas` varchar(11) NOT NULL,
  `rojas` varchar(11) NOT NULL,
  `azules` varchar(11) NOT NULL,
  `idPartido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estadisticas`
--

INSERT INTO `estadisticas` (`id`, `golesTot`, `tirosPuerta`, `amarillas`, `rojas`, `azules`, `idPartido`) VALUES
(1, '1-2', '13-13', '0-0', '0-0', '0-0', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalaciones`
--

CREATE TABLE `instalaciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `longitud` varchar(255) NOT NULL,
  `latitud` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `instalaciones`
--

INSERT INTO `instalaciones` (`id`, `nombre`, `direccion`, `capacidad`, `ciudad`, `longitud`, `latitud`) VALUES
(13, 'Pabellón José Moral', 'Av. Horcajo, 2', 5, 'Los Palacios y Villafranca', '-5.9232227', '37.1555529');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `integrante`
--

CREATE TABLE `integrante` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dorsal` int(11) NOT NULL,
  `nombreEquipo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `integrante`
--

INSERT INTO `integrante` (`dni`, `nombre`, `apellidos`, `dorsal`, `nombreEquipo`) VALUES
('47547326R', 'Manuel', 'Dominguez', 21, 'Azul'),
('47547327R', 'Fede', 'Gonzalez', 77, 'Rojo'),
('47547328R', 'Maria', 'Jimenez', 1, 'Amarillo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegan`
--

CREATE TABLE `juegan` (
  `id` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `idInstalacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `juegan`
--

INSERT INTO `juegan` (`id`, `idPartido`, `idInstalacion`) VALUES
(5, 1, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugados`
--

CREATE TABLE `jugados` (
  `id` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `idEquipo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

CREATE TABLE `partidos` (
  `Local` varchar(10) NOT NULL,
  `Visitante` varchar(10) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `resultado` varchar(10) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`Local`, `Visitante`, `idPartido`, `resultado`, `fecha`) VALUES
('Rojo', 'Azul', 1, '1-2', '2021-03-12 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nick` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nick`, `nombre`, `password`, `rol`) VALUES
('Fede', 'Fede', 'Fede1234', 'Cliente'),
('Manu', 'Manuel Jesus', 'Manu1234', 'Gerente'),
('Maria', 'Maria', 'Maria1234', 'Gerente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPartido` (`idPartido`);

--
-- Indices de la tabla `instalaciones`
--
ALTER TABLE `instalaciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `integrante`
--
ALTER TABLE `integrante`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `nombreEquipo` (`nombreEquipo`);

--
-- Indices de la tabla `juegan`
--
ALTER TABLE `juegan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPartido` (`idPartido`,`idInstalacion`),
  ADD KEY `idInstalacion` (`idInstalacion`);

--
-- Indices de la tabla `jugados`
--
ALTER TABLE `jugados`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPartido` (`idPartido`),
  ADD KEY `idEquipo` (`idEquipo`);

--
-- Indices de la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD PRIMARY KEY (`idPartido`),
  ADD KEY `idPartido` (`idPartido`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nick`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `instalaciones`
--
ALTER TABLE `instalaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `juegan`
--
ALTER TABLE `juegan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugados`
--
ALTER TABLE `jugados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `partidos`
--
ALTER TABLE `partidos`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD CONSTRAINT `estadisticas_ibfk_1` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `integrante`
--
ALTER TABLE `integrante`
  ADD CONSTRAINT `integrante_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `juegan`
--
ALTER TABLE `juegan`
  ADD CONSTRAINT `juegan_ibfk_2` FOREIGN KEY (`idInstalacion`) REFERENCES `instalaciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `juegan_ibfk_3` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugados`
--
ALTER TABLE `jugados`
  ADD CONSTRAINT `jugados_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jugados_ibfk_2` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
