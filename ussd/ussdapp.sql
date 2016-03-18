-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2015 at 03:33 AM
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

CREATE TABLE IF NOT EXISTS `citizens` (
`identity` int(11) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  `mydate` text,
  `mytime` time DEFAULT NULL,
  `why` varchar(22) DEFAULT NULL,
  `RGBinstitution` varchar(100) DEFAULT NULL,
  `mytext` varchar(250) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `citizens`
--

INSERT INTO `citizens` (`identity`, `location`, `mydate`, `mytime`, `why`, `RGBinstitution`, `mytext`) VALUES
(2, 'kigali 17:08 17/10/2015', '12/10/2015', '13:20:00', 'Poor services', 'LOWYERS', 'they dont care I dont know why'),
(3, 'kigali 13:50 12/10/2015', '12/10/2015', '13:20:00', 'Corruption', 'MINISTRIES', 'yahashwe agurisha imitungo ya reta');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citizens`
--
ALTER TABLE `citizens`
 ADD PRIMARY KEY (`identity`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citizens`
--
ALTER TABLE `citizens`
MODIFY `identity` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
