-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2015 at 03:51 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ussdapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `citizens`
--


-- --------------------------------------------------------

--
-- Table structure for table `comments_given`
--

CREATE TABLE IF NOT EXISTS `comments_given` (
`Id` int(11) NOT NULL,
  `Organization` varchar(30) NOT NULL,
  `Comments_giv` varchar(250) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments_given`
--

INSERT INTO `comments_given` (`Id`, `Organization`, `Comments_giv`) VALUES
(1, 'NGO Registration', 'urubyiruko rushiriye mubiyobyabwenge');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `rgbstaff` (
`user_id` int(11) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_pass` varchar(230) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `rgbstaff` (`user_id`, `user_name`, `user_email`, `user_pass`) VALUES
(1, 'muhizia', 'muhizia4@gmail.com', '$2y$10$op7IrG/FwUvL/1Ltxrg89uZoiDAM3Qw9HoueFhVZtMit1m2DtE1Zq');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citizens`
--

--
-- Indexes for table `comments_given`
--
ALTER TABLE `comments_given`
 ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `rgbstaff`
 ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citizens`
--

--
-- AUTO_INCREMENT for table `comments_given`
--
ALTER TABLE `comments_given`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `rgbstaff`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
