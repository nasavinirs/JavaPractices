drop table if exists cargodetail;


CREATE TABLE `cargodetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `width` float NOT NULL,
  `height` float NOT NULL,
  `weight` float NOT NULL,PRIMARY KEY (`id`)
);

INSERT INTO `cargodetail` (`id`, `name`, `width`, `height`, `weight`) VALUES
(1, 'Dunnage', 12.02, 23.42, 133.74),
(2, 'Mechanical stresses', 15.22, 25.2, 222.12),
(3, 'Biotic activity', 12.22, 25.1, 165.12),
(4, 'Chilling damage', 11.2, 25.33, 187.45),
(5, 'Drying capacity of oils', 12, 24, 192),
(6, 'Pressing residues', 15.2, 19.22, 183.2),
(7, 'Wood species', 8.33, 29.59, 188);