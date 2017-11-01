drop table if exists role;


create table role(`id` int(11) NOT NULL AUTO_INCREMENT,
			  `name` varchar(50) NOT NULL,
			  `description` varchar(150) NOT NULL,primary key(id));

INSERT INTO `role` (`id`, `name`, `description`) VALUES
(1, 'Software developer', 'Software developer. Becoming a software developer, also known as a computer programmer.'),
(2, 'Administrator', 'This Office Administrator job description template is optimized for posting on online job.'),
(3, 'Systems analyst', 'Systems analysts investigate and analyse business problems.'),
(4, 'Business analyst', 'Business analysts are true midfielders.'),
(5, 'Technical support', 'These are the professional troubleshooters of the IT world.'),
(6, 'Network engineer', 'Network engineering is one of the more technically demanding IT jobs.');


drop table if exists user;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mobile number` varchar(20) NOT NULL,
  `role` varchar(50) NOT NULL, PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `name`, `username`, `password`, `mobile number`, `role`) VALUES
(1, 'Jeremy', 'jere233', 'jere@233', '+1 716-652-4872', 'Network engineer'),
(2, 'David', 'david365', 'david@365', '+1 716-824-1572', 'Administrator'),
(3, 'Michael Buble', 'micbub222', 'micbub@222', '+1 480-926-0345', 'Technical support'),
(4, 'Drake', 'drake8456', 'drake@8456', '+1 952-883-2121', 'Network engineer'),
(5, 'Janet Jackson', 'jajack784', 'jajack@784', '+1 406-656-0808', 'Business analyst'),
(6, 'Phil Collins', 'pcollin', 'p@collin', '+1 812-473-9244', 'Systems analyst'),
(7, 'James Blunt', 'jablu1221', 'jablu@1221', '+1 562-945-7738', 'Software developer'),
(8, 'Liam Gallagher', 'liga789', 'liga@789', '+1 800-922-6250', 'Business analyst'),
(9, 'George Ezra', 'geez159', 'geez@159', '+1 812-473-9244', 'Systems analyst');
