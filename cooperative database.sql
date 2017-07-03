-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2017 at 06:13 PM
-- Server version: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cooperative`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_no` varchar(50) NOT NULL,
  `account_type` varchar(50) NOT NULL,
  `identification_id_no` int(11) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `account_no`, `account_type`, `identification_id_no`, `added_date`, `status`) VALUES
(1, '6645-3345-2223-1233', 'Current', 1235, '2017-05-16 03:04:18', 1),
(10, '9923-8232-7382-3432', 'current', 2435, '2017-05-31 07:41:02', 1),
(11, '1243-2382-9292-8229', 'current', 9029, '2017-05-31 07:42:09', 1),
(12, '9999-5553-9993-0202', 'current', 3306, '2017-06-04 03:57:47', 1),
(13, '9282-9223-9222-9111', 'Fixed', 8080, '2017-06-13 21:30:34', 1),
(14, '0000-7282-8292-0191', 'current', 35, '2017-06-08 06:50:47', 1),
(15, '9839-8292-6665-0393', 'Fixed', 5954, '2017-06-13 21:30:53', 1),
(16, '4455-9988-0077-5509', 'current', 8890, '2017-06-08 06:58:01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `accountclosure`
--

CREATE TABLE IF NOT EXISTS `accountclosure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `closure_reason` text NOT NULL,
  `closure_date` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `balance`
--

CREATE TABLE IF NOT EXISTS `balance` (
  `balance_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `deposited_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`balance_id`),
  KEY `customer_id` (`customer_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=50 ;

--
-- Dumping data for table `balance`
--

INSERT INTO `balance` (`balance_id`, `customer_id`, `account_id`, `amount`, `deposited_date`) VALUES
(36, 4, 1, 4000, '2017-06-13 20:20:29'),
(37, 4, 1, 40000, '2017-07-26 20:20:41'),
(38, 4, 1, 6000, '2017-06-14 05:48:35'),
(39, 11, 10, 12000, '2017-06-14 05:51:35'),
(40, 12, 11, 20000, '2017-06-14 05:55:33'),
(41, 13, 12, 40000, '2017-06-14 05:56:14'),
(42, 14, 13, 50000, '2017-06-14 05:56:52'),
(43, 15, 14, 700000, '2017-06-14 05:58:00'),
(44, 16, 15, 80000, '2017-06-14 05:59:15'),
(45, 17, 16, 90000, '2017-06-14 05:59:48'),
(46, 4, 1, 2000, '2017-06-14 06:00:53'),
(47, 11, 10, 50000, '2017-06-14 06:14:17'),
(48, 11, 10, 10000, '2017-06-16 03:58:24'),
(49, 17, 16, 2000, '2017-07-17 11:01:05');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) NOT NULL,
  `address` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `contact_no` varchar(60) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_name`, `address`, `email`, `contact_no`, `gender`, `account_id`) VALUES
(4, 'Niru Maharjan', 'kirtipur', 'nmharjan10@gmail.com', '9849274555', 'F', 1),
(11, 'Suman Shrestha', 'kathmandu', 'suman@10gmail.com', '9841627272', 'male', 10),
(12, 'Sadip khatri', 'chobar', 'sadip33@gmail.com', '9842839223', 'male', 11),
(13, 'Pratikshya Giri', 'Manamaiju', 'Pratiskhyanora@gmail.com', '98412829244', 'female', 12),
(14, 'Ganga Bhandari', 'Tokha', 'Ganga10@gmail.com', '9841229322', 'female', 13),
(15, 'Mili Maharjan', 'kirtipur', 'mili10@gmail.com', '9843625262', 'female', 14),
(16, 'Avinash Ghimire', 'kapan', 'ghimireavinash@gmail.com', '98437282829', 'male', 15),
(17, 'Nilav Gimire', 'kapan', 'ghimirenilav@gmail.com', '9827281113', 'male', 16);

-- --------------------------------------------------------

--
-- Table structure for table `totalbalance`
--

CREATE TABLE IF NOT EXISTS `totalbalance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `totalbalance`
--

INSERT INTO `totalbalance` (`id`, `account_id`, `customer_id`, `amount`) VALUES
(1, 1, 4, 52000),
(2, 10, 11, 72000),
(3, 11, 12, 20000),
(4, 12, 13, 40000),
(5, 13, 14, 50000),
(6, 14, 15, 700000),
(7, 15, 16, 80000),
(8, 16, 17, 92000);

-- --------------------------------------------------------

--
-- Table structure for table `withdrawnbalancerecord`
--

CREATE TABLE IF NOT EXISTS `withdrawnbalancerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `withdrawn_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount_withdrawn` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `withdrawnbalancerecord`
--

INSERT INTO `withdrawnbalancerecord` (`id`, `account_id`, `customer_id`, `withdrawn_date`, `amount_withdrawn`) VALUES
(1, 1, 4, '2017-06-11 05:44:21', 1000);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accountclosure`
--
ALTER TABLE `accountclosure`
  ADD CONSTRAINT `accountclosure_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `accountclosure_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Constraints for table `balance`
--
ALTER TABLE `balance`
  ADD CONSTRAINT `balance_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `balance_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `totalbalance`
--
ALTER TABLE `totalbalance`
  ADD CONSTRAINT `totalbalance_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `totalbalance_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Constraints for table `withdrawnbalancerecord`
--
ALTER TABLE `withdrawnbalancerecord`
  ADD CONSTRAINT `withdrawnbalancerecord_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `withdrawnbalancerecord_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
