-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-04-2016 a las 20:14:04
-- Versión del servidor: 5.6.25
-- Versión de PHP: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `borersDB`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `routes`
--

CREATE TABLE IF NOT EXISTS `routes` (
  `route_id` int(11) NOT NULL,
  `route_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `routes`
--

INSERT INTO `routes` (`route_id`, `route_name`) VALUES
(1, 'green'),
(2, 'red'),
(3, 'orange'),
(4, 'blue');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `routes_stops`
--

CREATE TABLE IF NOT EXISTS `routes_stops` (
  `routes_stops_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `stop_id` int(11) NOT NULL,
  `stops_order` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `routes_stops`
--

INSERT INTO `routes_stops` (`routes_stops_id`, `route_id`, `stop_id`, `stops_order`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 1, 3, 3),
(4, 1, 4, 4),
(5, 1, 5, 5),
(6, 1, 6, 6),
(7, 1, 7, 7),
(8, 1, 8, 8),
(9, 2, 9, 1),
(10, 2, 10, 2),
(11, 2, 6, 3),
(12, 2, 11, 4),
(13, 3, 12, 1),
(14, 3, 7, 2),
(15, 3, 13, 3),
(16, 3, 14, 4),
(17, 4, 15, 1),
(18, 4, 4, 2),
(19, 4, 16, 3),
(20, 4, 14, 4),
(21, 4, 17, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stops`
--

CREATE TABLE IF NOT EXISTS `stops` (
  `stop_id` int(11) NOT NULL,
  `stop_name` varchar(50) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `stops`
--

INSERT INTO `stops` (`stop_id`, `stop_name`, `latitude`, `longitude`) VALUES
(1, 'A', 31.866646, -116.666684),
(2, 'B', 31.875252, -116.630167),
(3, 'C', 31.870994, -116.618264),
(4, 'Octava', 31.868895, -116.619421),
(5, 'E', 31.864587, -116.607408),
(6, 'Diamante', 31.8557, -116.605735),
(7, 'Estancia', 31.841834, -116.603),
(8, 'Paseo Playa', 31.825615, -116.599759),
(9, 'G', 31.861837, -116.624327),
(10, 'H', 31.856686, -116.605904),
(11, 'I', 31.859334, -116.580206),
(12, 'J', 31.842419, -116.599102),
(13, 'K', 31.84059, -116.610985),
(14, 'Lazaro', 31.84578, -116.612672),
(15, 'L', 31.873017, -116.617307),
(16, 'M', 31.860569, -116.623528),
(17, 'N', 31.848216, -116.591055);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `routes`
--
ALTER TABLE `routes`
  ADD PRIMARY KEY (`route_id`),
  ADD UNIQUE KEY `route_id` (`route_id`);

--
-- Indices de la tabla `routes_stops`
--
ALTER TABLE `routes_stops`
  ADD PRIMARY KEY (`routes_stops_id`),
  ADD UNIQUE KEY `routes_stops_id` (`routes_stops_id`);

--
-- Indices de la tabla `stops`
--
ALTER TABLE `stops`
  ADD PRIMARY KEY (`stop_id`),
  ADD UNIQUE KEY `stop_id` (`stop_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
