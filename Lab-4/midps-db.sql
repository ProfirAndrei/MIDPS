-- phpMyAdmin SQL Dump
-- version 4.2.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 21, 2016 at 05:52 PM
-- Server version: 5.5.44
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `midps-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
`id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `date` datetime NOT NULL,
  `img_1` varchar(255) NOT NULL,
  `img_2` varchar(255) NOT NULL,
  `img_3` varchar(255) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=77 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `title`, `brand`, `category`, `price`, `date`, `img_1`, `img_2`, `img_3`) VALUES
(1, 'Great Content', 'Speedy', 'jackets', '59', '2016-04-06 08:15:40', '/resources/item/1_1.png', '/resources/item/1_2.png', '/resources/item/1_3.png'),
(17, 'Lovely Flower', 'Flowerily', 'jackets', '99', '2016-04-02 08:42:23', '/resources/item/1_2.png', '/resources/item/1_1.png', '/resources/item/1_3.png'),
(18, 'Albert Ramos', 'Ramasity', 'jackets', '25', '2016-04-02 02:48:20', '/resources/item/1_3.png', '/resources/item/1_2.png', '/resources/item/1_1.png'),
(19, 'Miriam Clasic', 'Miriam', 'shirts', '79', '2016-04-02 18:04:21', '/resources/item/4_1.png', '/resources/item/4_2.png', '/resources/item/4_3.png'),
(20, 'Humbert Yolo', 'Nope', 'shirts', '149', '2016-04-11 03:30:43', '/resources/item/4_2.png', '/resources/item/4_1.png', '/resources/item/4_3.png'),
(21, 'Bringos', 'Love Clothes', 'shirts', '36', '2016-04-12 03:46:28', '/resources/item/4_3.png', '/resources/item/4_2.png', '/resources/item/4_1.png'),
(22, 'Big Ratty', 'Mousehold', 'shirts', '78', '2016-04-23 05:50:12', '/resources/item/5_1.png', '/resources/item/5_2.png', '/resources/item/5_3.png'),
(23, 'Wally Classics', 'UKU Brand', 'shirts', '179', '2016-04-02 06:48:20', '/resources/item/5_2.png', '/resources/item/5_1.png', '/resources/item/5_3.png'),
(24, 'Shiny Rhinos', 'Quackie', 'shirts', '99', '2016-04-23 07:55:46', '/resources/item/5_3.png', '/resources/item/5_2.png', '/resources/item/5_1.png'),
(25, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', '/resources/item/7_1.png', '/resources/item/7_2.png', '/resources/item/7_3.png'),
(26, 'Cow''s Neck', 'Meat Me', 'dresses', '89', '2016-04-02 00:21:00', '/resources/item/7_2.png', '/resources/item/7_1.png', '/resources/item/7_3.png'),
(27, 'Amy Bag', 'Cox Right', 'dresses', '187', '2016-04-04 03:49:27', '/resources/item/7_3.png', '/resources/item/7_2.png', '/resources/item/7_1.png'),
(28, 'Friendly Wear', 'Fixie', 'dresses', '49', '2016-04-27 06:32:23', '/resources/item/8_3.png', '/resources/item/8_2.png', '/resources/item/8_1.png'),
(29, 'Pasadena Star', 'Green Robe', 'dresses', '50', '2016-04-19 04:41:55', '/resources/item/9_3.png', '/resources/item/9_2.png', '/resources/item/9_1.png'),
(30, 'Big Barbara', 'Masty', 'dresses', '95', '2016-04-01 06:46:26', '/resources/item/9_1.png', '/resources/item/9_3.png', '/resources/item/9_2.png'),
(31, 'Big Franny Classics', 'XUXU', 'trousers', '129', '2016-04-13 06:40:26', '/resources/item/10_3.png', '/resources/item/10_2.png', '/resources/item/10_1.png'),
(32, 'Freecantic', 'Converse', 'trousers', '58', '2016-04-23 07:44:23', '/resources/item/10_1.png', '/resources/item/10_3.png', '/resources/item/10_2.png'),
(33, 'Freedom Ranger', 'FUSO', 'trousers', '99', '2016-04-25 04:43:23', '/resources/item/11_1.png', '/resources/item/11_3.png', '/resources/item/11_2.png'),
(34, 'Fury Something', 'Dress Any', 'trousers', '299', '2016-04-30 07:55:11', '/resources/item/11_3.png', '/resources/item/11_2.png', '/resources/item/11_1.png'),
(35, 'Loose Goose', 'Birdy', 'trousers', '185', '2016-04-21 03:34:46', '/resources/item/12_1.png', '/resources/item/12_3.png', '/resources/item/12_2.png'),
(36, 'Walter''s Best', 'Walter', 'trousers', '119', '2016-04-22 00:20:41', '/resources/item/12_2.png', '/resources/item/12_3.png', '/resources/item/12_1.png'),
(37, 'Frankie Walks', 'Frank Frankie', 'shoes', '299', '2016-04-11 04:39:27', '/resources/item/13_2.png', '/resources/item/13_3.png', '/resources/item/13_1.png'),
(38, 'Lone Rider', 'Sebastian Wax', 'shoes', '359', '2016-04-02 20:12:41', '/resources/item/14_2.png', '/resources/item/14_3.png', '/resources/item/14_1.png'),
(39, 'Solid Step', 'Walter Micky', 'shoes', '49', '2016-04-14 16:05:27', '/resources/item/15_2.png', '/resources/item/15_3.png', '/resources/item/15_1.png'),
(40, 'Classic Hunter', 'Hunt Hint', 'shoes', '99', '2016-04-26 00:25:05', '/resources/item/16_2.png', '/resources/item/16_3.png', '/resources/item/16_1.png'),
(41, 'Line Walk', 'Schuhbert', 'shoes', '119', '2016-04-05 22:52:43', '/resources/item/17_2.png', '/resources/item/17_3.png', '/resources/item/17_1.png'),
(47, 'Classic Ducks', 'Trollmade', 'jackets', '129', '2016-04-09 00:00:31', '/resources/item/2_2.png', '/resources/item/2_3.png', '/resources/item/2_1.png'),
(48, 'Frannystastics', 'Quest Deluxe', 'jackets', '99', '2016-04-02 00:00:28', '/resources/item/3_2.png', '/resources/item/3_3.png', '/resources/item/3_1.png'),
(49, 'Great Content', 'Speedy', 'jackets', '59', '2016-04-06 08:15:40', '/resources/item/1_1.png', '/resources/item/1_2.png', '/resources/item/1_3.png'),
(50, 'Lovely Flower', 'Flowerily', 'jackets', '99', '2016-04-02 08:42:23', '/resources/item/1_2.png', '/resources/item/1_1.png', '/resources/item/1_3.png'),
(51, 'Albert Ramos', 'Ramasity', 'jackets', '25', '2016-04-02 02:48:20', '/resources/item/1_3.png', '/resources/item/1_2.png', '/resources/item/1_1.png'),
(52, 'Miriam Clasic', 'Miriam', 'shirts', '79', '2016-04-02 18:04:21', '/resources/item/4_1.png', '/resources/item/4_2.png', '/resources/item/4_3.png'),
(53, 'Humbert Yolo', 'Nope', 'shirts', '149', '2016-04-11 03:30:43', '/resources/item/4_2.png', '/resources/item/4_1.png', '/resources/item/4_3.png'),
(54, 'Bringos', 'Love Clothes', 'shirts', '36', '2016-04-12 03:46:28', '/resources/item/4_3.png', '/resources/item/4_2.png', '/resources/item/4_1.png'),
(55, 'Big Ratty', 'Mousehold', 'shirts', '78', '2016-04-23 05:50:12', '/resources/item/5_1.png', '/resources/item/5_2.png', '/resources/item/5_3.png'),
(56, 'Wally Classics', 'UKU Brand', 'shirts', '179', '2016-04-02 06:48:20', '/resources/item/5_2.png', '/resources/item/5_1.png', '/resources/item/5_3.png'),
(57, 'Shiny Rhinos', 'Quackie', 'shirts', '99', '2016-04-23 07:55:46', '/resources/item/5_3.png', '/resources/item/5_2.png', '/resources/item/5_1.png'),
(58, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', '/resources/item/7_1.png', '/resources/item/7_2.png', '/resources/item/7_3.png'),
(59, 'Cow''s Neck', 'Meat Me', 'dresses', '89', '2016-04-02 00:21:00', '/resources/item/7_2.png', '/resources/item/7_1.png', '/resources/item/7_3.png'),
(60, 'Amy Bag', 'Cox Right', 'dresses', '187', '2016-04-04 03:49:27', '/resources/item/7_3.png', '/resources/item/7_2.png', '/resources/item/7_1.png'),
(61, 'Friendly Wear', 'Fixie', 'dresses', '49', '2016-04-27 06:32:23', '/resources/item/8_3.png', '/resources/item/8_2.png', '/resources/item/8_1.png'),
(62, 'Pasadena Star', 'Green Robe', 'dresses', '50', '2016-04-19 04:41:55', '/resources/item/9_3.png', '/resources/item/9_2.png', '/resources/item/9_1.png'),
(63, 'Big Barbara', 'Masty', 'dresses', '95', '2016-04-01 06:46:26', '/resources/item/9_1.png', '/resources/item/9_3.png', '/resources/item/9_2.png'),
(64, 'Big Franny Classics', 'XUXU', 'trousers', '129', '2016-04-13 06:40:26', '/resources/item/10_3.png', '/resources/item/10_2.png', '/resources/item/10_1.png'),
(65, 'Freecantic', 'Converse', 'trousers', '58', '2016-04-23 07:44:23', '/resources/item/10_1.png', '/resources/item/10_3.png', '/resources/item/10_2.png'),
(66, 'Freedom Ranger', 'FUSO', 'trousers', '99', '2016-04-25 04:43:23', '/resources/item/11_1.png', '/resources/item/11_3.png', '/resources/item/11_2.png'),
(67, 'Fury Something', 'Dress Any', 'trousers', '299', '2016-04-30 07:55:11', '/resources/item/11_3.png', '/resources/item/11_2.png', '/resources/item/11_1.png'),
(68, 'Loose Goose', 'Birdy', 'trousers', '185', '2016-04-21 03:34:46', '/resources/item/12_1.png', '/resources/item/12_3.png', '/resources/item/12_2.png'),
(69, 'Walter''s Best', 'Walter', 'trousers', '119', '2016-04-22 00:20:41', '/resources/item/12_2.png', '/resources/item/12_3.png', '/resources/item/12_1.png'),
(70, 'Frankie Walks', 'Frank Frankie', 'shoes', '299', '2016-04-11 04:39:27', '/resources/item/13_2.png', '/resources/item/13_3.png', '/resources/item/13_1.png'),
(71, 'Lone Rider', 'Sebastian Wax', 'shoes', '359', '2016-04-02 20:12:41', '/resources/item/14_2.png', '/resources/item/14_3.png', '/resources/item/14_1.png'),
(72, 'Solid Step', 'Walter Micky', 'shoes', '49', '2016-04-14 16:05:27', '/resources/item/15_2.png', '/resources/item/15_3.png', '/resources/item/15_1.png'),
(73, 'Classic Hunter', 'Hunt Hint', 'shoes', '99', '2016-04-26 00:25:05', '/resources/item/16_2.png', '/resources/item/16_3.png', '/resources/item/16_1.png'),
(74, 'Line Walk', 'Schuhbert', 'shoes', '119', '2016-04-05 22:52:43', '/resources/item/17_2.png', '/resources/item/17_3.png', '/resources/item/17_1.png'),
(75, 'Classic Ducks', 'Trollmade', 'jackets', '129', '2016-04-09 00:00:31', '/resources/item/2_2.png', '/resources/item/2_3.png', '/resources/item/2_1.png'),
(76, 'Frannystastics', 'Quest Deluxe', 'jackets', '99', '2016-04-02 00:00:28', '/resources/item/3_2.png', '/resources/item/3_3.png', '/resources/item/3_1.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=77;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
