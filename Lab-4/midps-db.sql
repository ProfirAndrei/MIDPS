-- phpMyAdmin SQL Dump
-- version 4.2.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 04, 2016 at 12:41 AM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=67 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `title`, `brand`, `category`, `price`, `date`, `img_1`, `img_2`, `img_3`) VALUES
(1, 'Great Content', 'Speedy', 'jackets', '59', '2016-04-06 08:15:40', 'http://5.firepic.org/5/images/2016-04/02/vz8ukj9kqn0c.png', 'http://5.firepic.org/5/images/2016-04/02/3h69yl7czp5k.png', 'http://5.firepic.org/5/images/2016-04/02/2pb3npc9fatp.png'),
(17, 'Lovely Flower', 'Flowerily', 'jackets', '99', '2016-04-02 08:42:23', 'http://5.firepic.org/5/images/2016-04/02/in426tgr2jwr.png', 'http://5.firepic.org/5/images/2016-04/02/o0mke80z7p64.png', 'http://5.firepic.org/5/images/2016-04/02/wz6knbs16jvo.png'),
(18, 'Albert Ramos', 'Ramasity', 'jackets', '25', '2016-04-02 02:48:20', 'http://5.firepic.org/5/images/2016-04/02/o0mke80z7p64.png', 'http://5.firepic.org/5/images/2016-04/02/in426tgr2jwr.png', 'http://5.firepic.org/5/images/2016-04/02/wz6knbs16jvo.png'),
(19, 'Miriam Clasic', 'Miriam', 'shirts', '79', '2016-04-02 18:04:21', 'http://5.firepic.org/5/images/2016-04/02/qcfzyxdyao48.png', 'http://5.firepic.org/5/images/2016-04/02/ns49zwupr53t.png', 'http://5.firepic.org/5/images/2016-04/02/nsowd4dg036x.png'),
(20, 'Humbert Yolo', 'Nope', 'shirts', '149', '2016-04-11 03:30:43', 'http://5.firepic.org/5/images/2016-04/02/nsowd4dg036x.png', 'http://5.firepic.org/5/images/2016-04/02/qcfzyxdyao48.png', 'http://5.firepic.org/5/images/2016-04/02/ns49zwupr53t.png'),
(21, 'Bringos', 'Love Clothes', 'shirts', '36', '2016-04-12 03:46:28', 'http://5.firepic.org/5/images/2016-04/02/7txlmvz6ps4e.png', 'http://5.firepic.org/5/images/2016-04/02/eouwimgw6vj9.png', 'http://5.firepic.org/5/images/2016-04/02/pmfofabuzm8k.png'),
(22, 'Big Ratty', 'Mousehold', 'shirts', '78', '2016-04-23 05:50:12', 'http://5.firepic.org/5/images/2016-04/02/eouwimgw6vj9.png', 'http://5.firepic.org/5/images/2016-04/02/pmfofabuzm8k.png', 'http://5.firepic.org/5/images/2016-04/02/7txlmvz6ps4e.png'),
(23, 'Wally Classics', 'UKU Brand', 'shirts', '179', '2016-04-02 06:48:20', 'http://5.firepic.org/5/images/2016-04/02/c3zuw5zbomj2.png', 'http://5.firepic.org/5/images/2016-04/02/s7wefvtr18w2.png', 'http://5.firepic.org/5/images/2016-04/02/0ylybj0dcytn.png'),
(24, 'Shiny Rhinos', 'Quackie', 'shirts', '99', '2016-04-23 07:55:46', 'http://5.firepic.org/5/images/2016-04/02/s7wefvtr18w2.png', 'http://5.firepic.org/5/images/2016-04/02/0ylybj0dcytn.png', 'http://5.firepic.org/5/images/2016-04/02/c3zuw5zbomj2.png'),
(25, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', 'http://5.firepic.org/5/images/2016-04/02/z8z0yi7kmb7s.png', 'http://5.firepic.org/5/images/2016-04/02/w4fn45zs69r0.png', 'http://5.firepic.org/5/images/2016-04/02/agxzapw1pl9l.png'),
(26, 'Cow''s Neck', 'Meat Me', 'dresses', '89', '2016-04-02 00:21:00', 'http://5.firepic.org/5/images/2016-04/02/agxzapw1pl9l.png', 'http://5.firepic.org/5/images/2016-04/02/z8z0yi7kmb7s.png', 'http://5.firepic.org/5/images/2016-04/02/w4fn45zs69r0.png'),
(27, 'Amy Bag', 'Cox Right', 'dresses', '187', '2016-04-04 03:49:27', 'http://5.firepic.org/5/images/2016-04/02/wlmsh6fbs6in.png', 'http://5.firepic.org/5/images/2016-04/02/2g61hbo71pln.png', 'http://5.firepic.org/5/images/2016-04/02/f2zeclqp4yk9.png'),
(28, 'Friendly Wear', 'Fixie', 'dresses', '49', '2016-04-27 06:32:23', 'http://5.firepic.org/5/images/2016-04/02/f2zeclqp4yk9.png', 'http://5.firepic.org/5/images/2016-04/02/2g61hbo71pln.png', 'http://5.firepic.org/5/images/2016-04/02/wlmsh6fbs6in.png'),
(29, 'Pasadena Star', 'Green Robe', 'dresses', '50', '2016-04-19 04:41:55', 'http://5.firepic.org/5/images/2016-04/02/1mrvhz90751d.png', 'http://5.firepic.org/5/images/2016-04/02/6e0wul0zcy5f.png', 'http://5.firepic.org/5/images/2016-04/02/ljfoju95c3xk.png'),
(30, 'Big Barbara', 'Masty', 'dresses', '95', '2016-04-01 06:46:26', 'http://5.firepic.org/5/images/2016-04/02/6e0wul0zcy5f.png', 'http://5.firepic.org/5/images/2016-04/02/ljfoju95c3xk.png', 'http://5.firepic.org/5/images/2016-04/02/1mrvhz90751d.png'),
(31, 'Big Franny Classics', 'XUXU', 'trousers', '129', '2016-04-13 06:40:26', 'http://5.firepic.org/5/images/2016-04/02/crxw4aslr2l4.png', 'http://5.firepic.org/5/images/2016-04/02/eqe3she2mtb7.png', 'http://5.firepic.org/5/images/2016-04/02/s79ltjna7a47.png'),
(32, 'Freecantic', 'Converse', 'trousers', '58', '2016-04-23 07:44:23', 'http://5.firepic.org/5/images/2016-04/02/eqe3she2mtb7.png', 'http://5.firepic.org/5/images/2016-04/02/s79ltjna7a47.png', 'http://5.firepic.org/5/images/2016-04/02/crxw4aslr2l4.png'),
(33, 'Freedom Ranger', 'FUSO', 'trousers', '99', '2016-04-25 04:43:23', 'http://5.firepic.org/5/images/2016-04/02/smi0dt4ia8bs.png', 'http://5.firepic.org/5/images/2016-04/02/efkqzmnhims3.png', 'http://5.firepic.org/5/images/2016-04/02/v74s7xo0xodh.png'),
(34, 'Fury Something', 'Dress Any', 'trousers', '299', '2016-04-30 07:55:11', 'http://5.firepic.org/5/images/2016-04/02/v74s7xo0xodh.png', 'http://5.firepic.org/5/images/2016-04/02/efkqzmnhims3.png', 'http://5.firepic.org/5/images/2016-04/02/smi0dt4ia8bs.png'),
(35, 'Loose Goose', 'Birdy', 'trousers', '185', '2016-04-21 03:34:46', 'http://5.firepic.org/5/images/2016-04/02/hlhen1itbzin.png', 'http://5.firepic.org/5/images/2016-04/02/cqwo0p06ir26.png', 'http://5.firepic.org/5/images/2016-04/02/7g6u92k07y1f.png'),
(36, 'Walter''s Best', 'Walter', 'trousers', '119', '2016-04-22 00:20:41', 'http://5.firepic.org/5/images/2016-04/02/cqwo0p06ir26.png', 'http://5.firepic.org/5/images/2016-04/02/hlhen1itbzin.png', 'http://5.firepic.org/5/images/2016-04/02/7g6u92k07y1f.png'),
(37, 'Frankie Walks', 'Frank Frankie', 'shoes', '299', '2016-04-11 04:39:27', 'http://5.firepic.org/5/images/2016-04/02/li4f0dsylmgm.png', 'http://5.firepic.org/5/images/2016-04/02/yrm6t6sh25c6.png', 'http://5.firepic.org/5/images/2016-04/02/8np126ldeiei.png'),
(38, 'Lone Rider', 'Sebastian Wax', 'shoes', '359', '2016-04-02 20:12:41', 'http://5.firepic.org/5/images/2016-04/02/8np126ldeiei.png', 'http://5.firepic.org/5/images/2016-04/02/yrm6t6sh25c6.png', 'http://5.firepic.org/5/images/2016-04/02/li4f0dsylmgm.png'),
(39, 'Solid Step', 'Walter Micky', 'shoes', '49', '2016-04-14 16:05:27', 'http://5.firepic.org/5/images/2016-04/02/23ue973qjy0e.png', 'http://5.firepic.org/5/images/2016-04/02/gh7bj29xhzpd.png', 'http://5.firepic.org/5/images/2016-04/02/ashf2lose0wc.png'),
(40, 'Classic Hunter', 'Hunt Hint', 'shoes', '99', '2016-04-26 00:25:05', 'http://5.firepic.org/5/images/2016-04/02/gh7bj29xhzpd.png', 'http://5.firepic.org/5/images/2016-04/02/ashf2lose0wc.png', 'http://5.firepic.org/5/images/2016-04/02/23ue973qjy0e.png'),
(41, 'Line Walk', 'Schuhbert', 'shoes', '119', '2016-04-05 22:52:43', 'http://5.firepic.org/5/images/2016-04/02/7psfdsk1gl09.png', 'http://5.firepic.org/5/images/2016-04/02/kxfaciauqgl2.png', 'http://5.firepic.org/5/images/2016-04/02/v56ur9q7rwa7.png'),
(42, 'Stuppi', 'Silent Step', 'shoes', '79', '2016-04-22 00:56:52', 'http://5.firepic.org/5/images/2016-04/02/kxfaciauqgl2.png', 'http://5.firepic.org/5/images/2016-04/02/v56ur9q7rwa7.png', 'http://5.firepic.org/5/images/2016-04/02/7psfdsk1gl09.png'),
(43, 'Eleganties', 'Nora Spank', 'shoes', '199', '2016-04-12 04:00:53', 'http://5.firepic.org/5/images/2016-04/02/l1dxzb8nh9pq.png', 'http://5.firepic.org/5/images/2016-04/02/9a7fmx2gtlxs.png', 'http://5.firepic.org/5/images/2016-04/02/3uapval71otq.png'),
(44, 'Fox High Heels', 'Fix Fox', 'shoes', '89', '2016-04-13 00:00:58', 'http://5.firepic.org/5/images/2016-04/02/3uapval71otq.png', 'http://5.firepic.org/5/images/2016-04/02/l1dxzb8nh9pq.png', 'http://5.firepic.org/5/images/2016-04/02/9a7fmx2gtlxs.png'),
(45, 'Bone Walk', 'Lenny', 'shoes', '189', '2016-04-09 00:00:57', 'http://5.firepic.org/5/images/2016-04/02/qr4xpjdojauv.png', 'http://5.firepic.org/5/images/2016-04/02/yl3hxqzqaz6w.png', 'http://5.firepic.org/5/images/2016-04/02/1hsqwc8cu21a.png'),
(46, 'Rock Magic', 'Alfie Style', 'shoes', '60', '2016-04-03 00:00:55', 'http://5.firepic.org/5/images/2016-04/02/yl3hxqzqaz6w.png', 'http://5.firepic.org/5/images/2016-04/02/1hsqwc8cu21a.png', 'http://5.firepic.org/5/images/2016-04/02/qr4xpjdojauv.png'),
(47, 'Classic Ducks', 'Trollmade', 'jackets', '129', '2016-04-09 00:00:31', 'http://5.firepic.org/5/images/2016-04/02/sxcavqrj8a7p.png', 'http://5.firepic.org/5/images/2016-04/02/97veo2qbg3ql.png', 'http://5.firepic.org/5/images/2016-04/02/1f7ubrczudla.png'),
(48, 'Frannystastics', 'Quest Deluxe', 'jackets', '99', '2016-04-02 00:00:28', 'http://5.firepic.org/5/images/2016-04/02/1f7ubrczudla.png', 'http://5.firepic.org/5/images/2016-04/02/sxcavqrj8a7p.png', 'http://5.firepic.org/5/images/2016-04/02/97veo2qbg3ql.png'),
(49, 'Franny', 'Quest Deluxe', 'jackets', '99', '2016-04-02 00:00:28', 'http://5.firepic.org/5/images/2016-04/02/1f7ubrczudla.png', 'http://5.firepic.org/5/images/2016-04/02/sxcavqrj8a7p.png', 'http://5.firepic.org/5/images/2016-04/02/97veo2qbg3ql.png'),
(50, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', 'http://5.firepic.org/5/images/2016-04/02/z8z0yi7kmb7s.png', 'http://5.firepic.org/5/images/2016-04/02/w4fn45zs69r0.png', 'http://5.firepic.org/5/images/2016-04/02/agxzapw1pl9l.png'),
(51, 'Friendly Wear', 'Fixie', 'dresses', '49', '2016-04-27 06:32:23', 'http://5.firepic.org/5/images/2016-04/02/f2zeclqp4yk9.png', 'http://5.firepic.org/5/images/2016-04/02/2g61hbo71pln.png', 'http://5.firepic.org/5/images/2016-04/02/wlmsh6fbs6in.png'),
(52, 'Frankie Walks', 'Frank Frankie', 'shoes', '299', '2016-04-11 04:39:27', 'http://5.firepic.org/5/images/2016-04/02/li4f0dsylmgm.png', 'http://5.firepic.org/5/images/2016-04/02/yrm6t6sh25c6.png', 'http://5.firepic.org/5/images/2016-04/02/8np126ldeiei.png'),
(53, 'Eleganties', 'Nora Spank', 'shoes', '199', '2016-04-12 04:00:53', 'http://5.firepic.org/5/images/2016-04/02/l1dxzb8nh9pq.png', 'http://5.firepic.org/5/images/2016-04/02/9a7fmx2gtlxs.png', 'http://5.firepic.org/5/images/2016-04/02/3uapval71otq.png'),
(54, 'Lovely Flower', 'Flowerily', 'jackets', '99', '2016-04-02 08:42:23', 'http://5.firepic.org/5/images/2016-04/02/in426tgr2jwr.png', 'http://5.firepic.org/5/images/2016-04/02/o0mke80z7p64.png', 'http://5.firepic.org/5/images/2016-04/02/wz6knbs16jvo.png'),
(55, 'Great Content', 'Speedy', 'jackets', '59', '2016-04-06 08:15:40', 'http://5.firepic.org/5/images/2016-04/02/vz8ukj9kqn0c.png', 'http://5.firepic.org/5/images/2016-04/02/3h69yl7czp5k.png', 'http://5.firepic.org/5/images/2016-04/02/2pb3npc9fatp.png'),
(56, 'Miriam Clasic', 'Miriam', 'shirts', '79', '2016-04-02 18:04:21', 'http://5.firepic.org/5/images/2016-04/02/qcfzyxdyao48.png', 'http://5.firepic.org/5/images/2016-04/02/ns49zwupr53t.png', 'http://5.firepic.org/5/images/2016-04/02/nsowd4dg036x.png'),
(57, 'Big Ratty', 'Mousehold', 'shirts', '78', '2016-04-23 05:50:12', 'http://5.firepic.org/5/images/2016-04/02/eouwimgw6vj9.png', 'http://5.firepic.org/5/images/2016-04/02/pmfofabuzm8k.png', 'http://5.firepic.org/5/images/2016-04/02/7txlmvz6ps4e.png'),
(58, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', 'http://5.firepic.org/5/images/2016-04/02/z8z0yi7kmb7s.png', 'http://5.firepic.org/5/images/2016-04/02/w4fn45zs69r0.png', 'http://5.firepic.org/5/images/2016-04/02/agxzapw1pl9l.png'),
(59, 'Line Walk', 'Schuhbert', 'shoes', '119', '2016-04-05 22:52:43', 'http://5.firepic.org/5/images/2016-04/02/7psfdsk1gl09.png', 'http://5.firepic.org/5/images/2016-04/02/kxfaciauqgl2.png', 'http://5.firepic.org/5/images/2016-04/02/v56ur9q7rwa7.png'),
(60, 'Lone Rider', 'Sebastian Wax', 'shoes', '359', '2016-04-02 20:12:41', 'http://5.firepic.org/5/images/2016-04/02/8np126ldeiei.png', 'http://5.firepic.org/5/images/2016-04/02/yrm6t6sh25c6.png', 'http://5.firepic.org/5/images/2016-04/02/li4f0dsylmgm.png'),
(61, 'Rock Magic', 'Alfie Style', 'shoes', '60', '2016-04-03 00:00:55', 'http://5.firepic.org/5/images/2016-04/02/yl3hxqzqaz6w.png', 'http://5.firepic.org/5/images/2016-04/02/1hsqwc8cu21a.png', 'http://5.firepic.org/5/images/2016-04/02/qr4xpjdojauv.png'),
(62, 'Frannystastics', 'Quest Deluxe', 'jackets', '99', '2016-04-02 00:00:28', 'http://5.firepic.org/5/images/2016-04/02/1f7ubrczudla.png', 'http://5.firepic.org/5/images/2016-04/02/sxcavqrj8a7p.png', 'http://5.firepic.org/5/images/2016-04/02/97veo2qbg3ql.png'),
(63, 'Big Ratty', 'Mousehold', 'shirts', '78', '2016-04-23 05:50:12', 'http://5.firepic.org/5/images/2016-04/02/eouwimgw6vj9.png', 'http://5.firepic.org/5/images/2016-04/02/pmfofabuzm8k.png', 'http://5.firepic.org/5/images/2016-04/02/7txlmvz6ps4e.png'),
(64, 'Humbert Yolo', 'Nope', 'shirts', '149', '2016-04-11 03:30:43', 'http://5.firepic.org/5/images/2016-04/02/nsowd4dg036x.png', 'http://5.firepic.org/5/images/2016-04/02/qcfzyxdyao48.png', 'http://5.firepic.org/5/images/2016-04/02/ns49zwupr53t.png'),
(65, 'Miriam Clasic', 'Miriam', 'shirts', '79', '2016-04-02 18:04:21', 'http://5.firepic.org/5/images/2016-04/02/qcfzyxdyao48.png', 'http://5.firepic.org/5/images/2016-04/02/ns49zwupr53t.png', 'http://5.firepic.org/5/images/2016-04/02/nsowd4dg036x.png'),
(66, 'Andrew Skills', 'Skill Classic', 'dresses', '139', '2016-04-09 07:49:28', 'http://5.firepic.org/5/images/2016-04/02/z8z0yi7kmb7s.png', 'http://5.firepic.org/5/images/2016-04/02/w4fn45zs69r0.png', 'http://5.firepic.org/5/images/2016-04/02/agxzapw1pl9l.png');

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=67;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
