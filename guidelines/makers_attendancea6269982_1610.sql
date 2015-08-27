
-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 27, 2015 at 09:28 AM
-- Server version: 5.1.57
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `a6269982_1610`
--

-- --------------------------------------------------------

--
-- Table structure for table `apr_attendance`
--

CREATE TABLE `apr_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `Dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of april';

--
-- Dumping data for table `apr_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `Aug_attendance`
--

CREATE TABLE `Aug_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `status` varchar(2) COLLATE latin1_general_ci DEFAULT NULL,
  `Dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of august';

--
-- Dumping data for table `Aug_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `dec_attendance`
--

CREATE TABLE `dec_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of december';

--
-- Dumping data for table `dec_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `Emp_entries`
--

CREATE TABLE `Emp_entries` (
  `Name` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`Maker_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `Emp_entries`
--

INSERT INTO `Emp_entries` VALUES('ABHISHEK', 'E1002');
INSERT INTO `Emp_entries` VALUES('HARSHUL', 'E1001');
INSERT INTO `Emp_entries` VALUES('NITISH', 'E1003');
INSERT INTO `Emp_entries` VALUES('SIDHANT', 'E1005');
INSERT INTO `Emp_entries` VALUES('HARSH', 'E1007');
INSERT INTO `Emp_entries` VALUES('RISHI', 'E1008');
INSERT INTO `Emp_entries` VALUES('SHUBHAM', 'E1009');
INSERT INTO `Emp_entries` VALUES('SUDHANSHU', 'E1004');
INSERT INTO `Emp_entries` VALUES('PRANJAL_MODI', 'E1010');
INSERT INTO `Emp_entries` VALUES('FERDOSE', 'E1011');
INSERT INTO `Emp_entries` VALUES('UJJWAL', 'E1012');
INSERT INTO `Emp_entries` VALUES('VIVEK', 'E1013');

-- --------------------------------------------------------

--
-- Table structure for table `feb_attendance`
--

CREATE TABLE `feb_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of february';

--
-- Dumping data for table `feb_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `jan_attendance`
--

CREATE TABLE `jan_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of january';

--
-- Dumping data for table `jan_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `july_attendance`
--

CREATE TABLE `july_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `Dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of july';

--
-- Dumping data for table `july_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `june_attendance`
--

CREATE TABLE `june_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `Dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of june';

--
-- Dumping data for table `june_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `march_attendance`
--

CREATE TABLE `march_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `march_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `may_attendance`
--

CREATE TABLE `may_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `Dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of may';

--
-- Dumping data for table `may_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `nov_attendance`
--

CREATE TABLE `nov_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of november';

--
-- Dumping data for table `nov_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `oct_attendance`
--

CREATE TABLE `oct_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance for the month of october';

--
-- Dumping data for table `oct_attendance`
--


-- --------------------------------------------------------

--
-- Table structure for table `sept_attendance`
--

CREATE TABLE `sept_attendance` (
  `Name` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `Maker_id` varchar(10) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Status` varchar(1) COLLATE latin1_general_ci DEFAULT NULL,
  `dated` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='attendance in month of september';

--
-- Dumping data for table `sept_attendance`
--

