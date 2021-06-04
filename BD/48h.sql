-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2021 a las 20:09:59
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
('Amarillo', 'Am'),
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
(5, '1-2', '13-13', '0-0', '0-0', '0-0', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalaciones`
--

CREATE TABLE `instalaciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `capacidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `instalaciones`
--

INSERT INTO `instalaciones` (`id`, `nombre`, `direccion`, `capacidad`) VALUES
(1, 'Pabellon 1', 'Calle Falsa 16', 12),
(6, 'Pabellon 2', 'Direccion Pabellon 2', 100);

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegan`
--

CREATE TABLE `juegan` (
  `idPartido` int(11) NOT NULL,
  `idInstalacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `juegan`
--

INSERT INTO `juegan` (`idPartido`, `idInstalacion`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugados`
--

CREATE TABLE `jugados` (
  `id` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `idEquipo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugados`
--

INSERT INTO `jugados` (`id`, `idPartido`, `idEquipo`) VALUES
(1, 1, 'Azul'),
(2, 1, 'Rojo');

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
('Azul', 'Rojo', 1, '3-2', '2021-06-02 13:08:08');

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
('Fede', 'Federico', 'Fede1234', 'Cliente'),
('Manu', 'Manuel Jesus', 'Manu1234', 'Gerente'),
('Mari', 'Maria', 'Maria1234', 'Cliente'),
('Pepe', 'Jose', 'Pepe1234', 'Cliente');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `instalaciones`
--
ALTER TABLE `instalaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `jugados`
--
ALTER TABLE `jugados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `partidos`
--
ALTER TABLE `partidos`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
