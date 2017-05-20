-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2017 at 03:24 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booklending`
--
CREATE DATABASE IF NOT EXISTS `booklending` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `booklending`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `adminID` int(20) NOT NULL AUTO_INCREMENT,
  `surname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `middlename` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phoneno` varchar(11) NOT NULL,
  `address` varchar(250) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `control` varchar(15) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=MyISAM AUTO_INCREMENT=1003 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `surname`, `firstname`, `middlename`, `gender`, `phoneno`, `address`, `username`, `password`, `control`) VALUES
(1000, 'Etebong', 'Philip', 'I', 'Male', '08122088748', '73 Wellington Bassey Way Uyo', 'admin', 'admin', 'admin'),
(1001, 'Bassey', 'Edidiong', 'E.', 'Male', '09897868898', 'Uyo', 'edidiong', 'edidiong', 'user'),
(1002, 'Shegun', 'Emmanuel', 'J', 'Male', '09075678677', 'Uyo', 'shegun', 'shegun', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `bookcategory`
--

CREATE TABLE IF NOT EXISTS `bookcategory` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `categoryDescription` varchar(50) NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookcategory`
--

INSERT INTO `bookcategory` (`CategoryID`, `categoryDescription`) VALUES
(1, 'General'),
(2, 'Reference'),
(3, 'Magazines/Periodicals'),
(4, 'Student Projects'),
(5, 'Journals/Publications');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `accno` int(10) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(25) NOT NULL,
  `title` varchar(225) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `year` int(10) NOT NULL,
  `edition` varchar(20) NOT NULL,
  `category` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Available',
  PRIMARY KEY (`accno`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`accno`, `isbn`, `title`, `author`, `publisher`, `year`, `edition`, `category`, `status`) VALUES
(1, '0-9699900-1', 'The Book of Praise Pew Edition', 'The Presbyterian Church in Canada', 'Friesens, Canada', 2007, 'Pew Edition', 'Reference', 'Available'),
(2, '890-8997-67477', 'Java Made Easy for Beginners', 'Philip Akpan', 'African publisers', 2017, '1st', 'General', 'Available'),
(3, '123-3456-890-46', 'Economic Perspective in Nigeria', 'Mary High Great', 'University Press Ibadan', 2003, '2nd', 'General', 'Available'),
(4, '8790-09-3456-01', 'Modern Biology for Senior Secondary Schools', 'Mbong Udoffot Jnr', 'African Publishers uyo', 2002, '2nd', 'General', 'Borrowed'),
(5, 'M-234-788S-56', 'Introduction Computer Science Mathematical Approach', 'McDonald Kacthy', 'Preston Publishers USA', 2004, '2nd', 'Reference', 'Available'),
(6, '978-0-13-283031-7', 'Absolute Java', 'Walter Savitch', 'Pearson Publishers', 2013, '5th', 'Reference', 'Available'),
(7, '978-1-118-25852-1 (eMobi)', 'Beginning Programming with Java for Dummies', 'Barry Burd', 'John Wiley & Sons, Inc.', 2013, '3rd', 'General', 'Available'),
(8, '978-1-118-25852-1 (eMobi)', 'Beginning Programming with Java for Dummies', 'Barry Burd', 'John Wiley & Sons', 2013, '3rd', 'Reference', 'Available'),
(9, '8903-9000299', 'Ethics in Nigerian Economy', 'Man of God', 'Jenyson Publishers', 2003, '2nd', 'General', 'Available'),
(10, '123-899-7778-888', 'Java Essential Manual', 'Mary Hey', 'African Publishers', 2013, '1st', 'Reference', 'Available'),
(11, '123-7889-00911', 'Java Many methods', 'Philip Akpan', 'African Pub', 1990, '1', 'General', 'Available'),
(12, '56-0989-126-878', 'politics today', 'Lonwly', 'Esset Publishers', 2012, '2nd', 'Reference', 'Available'),
(13, '67-129-998-126-77', 'Mathematical Models', 'Philip AKpan', 'Ibadan press', 2012, '2nd', 'General', 'Available'),
(14, '628-77740-77', 'Idorenyin', 'Philip Akpan', 'Adrican Publishers', 2007, '1st', 'Reference', 'Available'),
(15, '34890-897S-99', 'File Processing', 'Theophilus Newton', 'Univerisity Press', 2012, '1st', 'General', 'Available'),
(16, '890-45-98-23', 'Newton Mathematics', 'Mc Tony Ben', 'African Publishers', 2015, '1st', 'General', 'Available'),
(28, '1239-9087-13', 'Cobol Application', 'Friday Akpan', 'African Publishers', 2015, '2nd', 'General', 'Available'),
(27, '679-90765-90875', 'Compiler Construction', 'Shegun', 'Edidiong', 2012, '3rd', 'General', 'Available'),
(19, '234-98889-348-126', 'Basic Mathematics for Secondary Schools', 'Mary Harnny, Mercy Akpabio, Udofot Mark', 'MacMillan Publishers', 2013, '2nd', 'General', 'Available'),
(20, '9081276-234', 'Food Sufficiency in Nigeria', 'Jones Anthony', 'Glory Mark', 2015, '4th', 'Reference', 'Available'),
(26, '80-9876-1235-14', 'Java my Pride!', 'Philip Akpan', 'African Publisers', 2014, '1st', 'General', 'Available'),
(22, '78934340232328', 'How to read for all exams', 'Ananymous', 'Victory Center', 2011, '1st', 'General', 'Available'),
(23, '87612898487884', 'Junior Secondary Mathematics', 'Mc Victory', 'African Publishers', 2007, '2nd', 'General', 'Available'),
(24, '123567-7899-45', 'Java in the Our contemporary society', 'IfiokAbasi', 'Africal Publishers', 2011, '1st', 'General', 'Available'),
(29, '2390-ti', 'Learning and Knowledge', 'Victor Mark', 'Cletus Publishers', 2013, '2', 'General', 'Available'),
(30, '8909-987767-898', 'Introduction to File Processing', 'Samuel Leo ', 'African Publishers', 2014, '2', 'General', 'Available'),
(31, '12-5670-98974', 'Service Manual', 'Mark', 'James Publisher', 2013, '2', 'General', 'Available'),
(32, '345-787878', 'James', 'Uduak', 'King', 2012, '3', 'General', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `CategoryID` int(5) NOT NULL AUTO_INCREMENT,
  `categoryDescription` varchar(50) NOT NULL,
  `borrowLimit` int(5) NOT NULL,
  `borrowdays` int(10) NOT NULL,
  PRIMARY KEY (`categoryDescription`),
  UNIQUE KEY `category` (`CategoryID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryID`, `categoryDescription`, `borrowLimit`, `borrowdays`) VALUES
(1, 'Student', 2, 7),
(2, 'Non Academic Staff', 2, 7),
(3, 'Academic Staff', 3, 14);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `deptdescription` varchar(40) NOT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`departmentid`, `deptdescription`) VALUES
(1, 'Computer Science'),
(2, 'Business Administration'),
(3, 'Mecahanical Engineering'),
(4, 'Statistics'),
(5, 'Agric Technology'),
(6, 'English Language'),
(7, 'Economics'),
(8, 'Electrical Engineering'),
(9, 'Civil Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `transactionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `accno` int(10) NOT NULL,
  `booktitle` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `dateborrowed` date DEFAULT NULL,
  `datedue` date DEFAULT NULL,
  `fine` double NOT NULL DEFAULT '0',
  `returneddate` date DEFAULT NULL,
  `remark` varchar(20) DEFAULT 'Not Returned',
  PRIMARY KEY (`transactionid`)
) ENGINE=MyISAM AUTO_INCREMENT=1003 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionid`, `userid`, `name`, `accno`, `booktitle`, `author`, `dateborrowed`, `datedue`, `fine`, `returneddate`, `remark`) VALUES
(1000, '1000', 'Akpan, Philip Ifreke', 2, 'Java Made Easy for Beginners', 'Philip Akpan', '2017-04-01', '2017-04-15', 0, '2017-04-18', 'Returned'),
(1001, '1002', 'Etim, Edem Udoh', 4, 'Modern Biology for Senior Secondary Schools', 'Mbong Udoffot Jnr', '2017-04-01', '2017-04-08', 0, NULL, 'Not Returned'),
(1002, '1002', 'Etim, Edem Udoh', 2, 'Java Made Easy for Beginners', 'Philip Akpan', '2017-04-02', '2017-04-09', 0, '2017-04-20', 'Returned');

-- --------------------------------------------------------

--
-- Table structure for table `transactionlog`
--

CREATE TABLE IF NOT EXISTS `transactionlog` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `transactionid` varchar(10) NOT NULL,
  `userid` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `accNo` int(10) NOT NULL,
  `booktitle` varchar(50) NOT NULL,
  `author` varchar(100) NOT NULL,
  `borrowdate` date NOT NULL,
  `datedue` date NOT NULL,
  `fine` double NOT NULL,
  `returneddate` date NOT NULL,
  `remarks` varchar(50) NOT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionlog`
--

INSERT INTO `transactionlog` (`logId`, `transactionid`, `userid`, `username`, `accNo`, `booktitle`, `author`, `borrowdate`, `datedue`, `fine`, `returneddate`, `remarks`) VALUES
(1, '1000', 1000, 'Akpan, Philip Ifreke', 2, 'Java Made Easy for Beginners', 'Philip Akpan', '2017-04-01', '2017-04-15', 0, '2017-04-18', 'Returned'),
(2, '1002', 1002, 'Etim, Edem Udoh', 2, 'Java Made Easy for Beginners', 'Philip Akpan', '2017-04-02', '2017-04-09', 0, '2017-04-20', 'Returned');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(30) NOT NULL AUTO_INCREMENT,
  `UserIDCardNo` varchar(25) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `middlename` varchar(50) NOT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `address` varchar(250) NOT NULL,
  `department` varchar(60) NOT NULL,
  `phoneno` varchar(11) NOT NULL,
  `usercategory` varchar(20) DEFAULT NULL,
  `dateregistered` date DEFAULT NULL,
  `fine` int(10) NOT NULL DEFAULT '0',
  `totalbooksborrowed` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `UserIDCardNo` (`UserIDCardNo`)
) ENGINE=MyISAM AUTO_INCREMENT=1003 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `UserIDCardNo`, `surname`, `firstname`, `middlename`, `gender`, `address`, `department`, `phoneno`, `usercategory`, `dateregistered`, `fine`, `totalbooksborrowed`) VALUES
(1000, 'AKS/CAS/123/456', 'Akpan', 'Philip', 'Ifreke', 'Male', 'Ikot Mbonde Itam Itu', 'Computer Science', '08122088748', 'Academic Staff', '2016-09-07', 0, 1),
(1001, '15/ND/BAM/001', 'Etim', 'Edet', 'Umoh', 'Male', '78 Grace Street', 'Computer Science', '08976777677', 'Student', '2017-03-30', 0, 0),
(1002, '13/ND/CS/OO3', 'Etim', 'Edem', 'Udoh', 'Male', '78 Ekom Iman Uyo', 'Statistics', '80967566654', 'Student', '2013-04-01', 0, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
