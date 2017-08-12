-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: our_music
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `artist` varchar(45) NOT NULL,
  `musicURL` varchar(150) NOT NULL,
  `imgURL` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'비도 오고 그래서 (Feat. 신용재)','헤이즈','https://youtu.be/afxLaQiLu-o','http://image.bugsm.co.kr/album/images/original/201049/20104917.jpg'),(2,'비가 오는 날엔','비스트','https://youtu.be/W44PYtzjrZE','http://image.bugsm.co.kr/album/images/1000/2828/282843.jpg'),(3,'Rain Drop','아이유','https://youtu.be/lfcaABzPqw8','http://image.bugsm.co.kr/album/images/original/2249/224970.jpg'),(4,'비가 온다','강승윤','https://youtu.be/nZ9r5_DEU5Q','http://image.bugsm.co.kr/album/images/original/3785/378590.jpg'),(5,'Rain','태연','https://youtu.be/eHir_vB1RUI','http://image.bugsm.co.kr/album/images/original/200203/20020336.jpg'),(6,'뚝뚝뚝','스탠딩 에그','https://youtu.be/QTVgoVGojO8','http://image.bugsm.co.kr/album/images/original/200389/20038938.jpg'),(7,'봄비','장범준','https://youtu.be/u0hEgrjqQro','http://image.bugsm.co.kr/album/images/1000/200268/20026817.jpg'),(8,'서쪽 하늘','이승철','https://youtu.be/0x5EMz9WBkw','http://image.bugsm.co.kr/album/images/1000/80140/8014074.jpg'),(9,'비가와','소유, 백현','https://youtu.be/1Q8J5nghxiM','http://image.bugsm.co.kr/album/images/1000/200818/20081846.jpg'),(10,'우산 (feat. 윤하)','에픽 하이','https://youtu.be/NIPtyAKxlRs','http://image.bugsm.co.kr/album/images/1000/4380/438059.jpg'),(11,'비와 당신','럼블피쉬','https://youtu.be/acdAWdnSKmE','http://image.bugsm.co.kr/album/images/original/1707/170783.jpg'),(12,'소나기','아이오아이','https://youtu.be/_AADHVsit4A','http://image.bugsm.co.kr/album/images/original/200778/20077876.jpg'),(13,'사랑은 봄비처럼… 이별은 겨울비 처럼…','임현정','https://youtu.be/PMJFfMWgyZI','http://image.bugsm.co.kr/album/images/original/306/30639.jpg'),(14,'장마','정인','https://youtu.be/_7E9cw1OiNw','http://image.bugsm.co.kr/album/images/original/2753/275309.jpg'),(15,'사랑은 비를 타고','씨엔블루','https://youtu.be/7OONXduDbdA','http://image.bugsm.co.kr/album/images/original/2719/271989.jpg'),(16,'여우비','이선희','https://youtu.be/5XaJzbl0Tyc','http://image.bugsm.co.kr/album/images/original/2333/233369.jpg'),(17,'젖고있어','빈지노','https://youtu.be/VOIWI9ek6wE','http://image.bugsm.co.kr/album/images/original/200382/20038207.jpg'),(18,'비가오네 (feat. 박수민)','긱스','https://youtu.be/YADLoltDru4','http://image.bugsm.co.kr/album/images/original/3672/367203.jpg'),(19,'비','폴킴','https://youtu.be/9jFZdu0zTEA','http://image.bugsm.co.kr/album/images/original/5707/570711.jpg'),(20,'사랑비','김태우','https://youtu.be/wNTr0ulXVX0','http://image.bugsm.co.kr/album/images/original/1973/197341.jpg'),(21,'FLY','긱스','https://youtu.be/XghiphByqE4','http://image.bugsm.co.kr/album/images/original/3776/377681.jpg'),(22,'달빛바다','아이유, 피에스타','https://youtu.be/HiIjdaSlFug','http://image.bugsm.co.kr/album/images/original/3364/336446.jpg'),(23,'WE LIKE 2 PARTY','빅뱅','https://youtu.be/oFmfi1vM7co','http://image.bugsm.co.kr/album/images/original/5075/507550.jpg'),(24,'미니마니모','타이니지','https://youtu.be/r-MXLmNnarQ','http://image.bugsm.co.kr/album/images/original/3552/355299.jpg'),(25,'바람과 함께 사라지다','임창정','https://youtu.be/4dMctDDgINw','http://image.bugsm.co.kr/album/images/original/47/4708.jpg'),(26,'Ice Cream Cake','레드벨벳','https://youtu.be/glXgSSOKlls','http://image.bugsm.co.kr/album/images/original/4900/490027.jpg'),(27,'한여름밤의 꿀','San E, 레이나','https://youtu.be/0pWz9xztrHE','http://image.bugsm.co.kr/album/images/original/4344/434489.jpg'),(28,'별빛달빛','시크릿','https://youtu.be/iTVfJ1j7o-A','http://image.bugsm.co.kr/album/images/original/2885/288566.jpg'),(29,'사랑과 전쟁','다비치','https://youtu.be/jXCnyc6L96k','http://image.bugsm.co.kr/album/images/original/1583/158301.jpg'),(30,'DOC와 춤을','DJ DOC','https://youtu.be/Z4R8BAF0vwo','http://image.bugsm.co.kr/album/images/original/32/3259.jpg'),(31,'I DONT CARE','2NE1','https://youtu.be/zdZya6yATn0','http://image.bugsm.co.kr/album/images/original/1901/190115.jpg'),(32,'화','매드클라운','https://youtu.be/hfEf6NFS81E','http://image.bugsm.co.kr/album/images/original/4766/476683.jpg'),(33,'까탈레나','오렌지캬라멜','https://youtu.be/Ahif51hqeA8','http://image.bugsm.co.kr/album/images/original/4185/418570.jpg'),(34,'아름다운 밤이야','비스트','https://youtu.be/ckIGhwQtd-c','http://image.bugsm.co.kr/album/images/original/3359/335936.jpg'),(35,'Bubble Pop!','현아','https://youtu.be/bw9CALKOvAI','http://image.bugsm.co.kr/album/images/original/2922/292253.jpg'),(36,'바다의 왕자','박명수','https://youtu.be/9VaMWn3NL0M','http://image.bugsm.co.kr/album/images/original/335/33549.jpg'),(37,'유리구슬','여자친구','https://youtu.be/IxnD5AViu6k','http://image.bugsm.co.kr/album/images/original/4778/477881.jpg'),(38,'씨스루','프라이머리','https://youtu.be/keWVwk_I8jM','http://image.bugsm.co.kr/album/images/original/3456/345641.jpg'),(39,'다쳐','나인뮤지스','https://youtu.be/sna6j078eOw','http://image.bugsm.co.kr/album/images/original/5148/514875.jpg'),(40,'오늘','오왠','https://www.youtube.com/watch?v=A_nlugkiL-o&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/200342/20034282.jpg'),(41,'Good Night','오왠','https://www.youtube.com/watch?v=gYvKLj5NkI8&index=2&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/5926/592611.jpg'),(42,'밤편지','아이유','https://www.youtube.com/watch?v=gYvKLj5NkI8&index=2&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/200890/20089092.jpg'),(43,' 블라블라(Prod.by 윤종신)','규현','https://www.youtube.com/watch?v=IlrNAGFz-wU&index=9&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/200657/20065752.jpg'),(44,'나를 좋아하지 않는 그대에게','박원 ','https://www.youtube.com/watch?v=sOw2TN0oD9s&index=11&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/200074/20007492.jpg'),(45,'떠나지마라','로이킴','https://www.youtube.com/watch?v=v52z3Aj_5kw&index=12&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/200115/20011503.jpg'),(46,'이별택시','김연우 ','https://www.youtube.com/watch?v=wxxb311BWRM&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q&index=25','http://image.bugsm.co.kr/album/images/original/335/33583.jpg'),(47,'바람이 분다','이소라','https://www.youtube.com/watch?v=mRWxGCDBRNY&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q&index=27','http://image.bugsm.co.kr/album/images/original/80034/8003459.jpg'),(48,'난 너를 사랑해','Mate','https://www.youtube.com/watch?v=kQgd3ay_ElQ&index=31&list=PL-2aeEJY7wBe0hA3e93eqNRHi2LfJ511q','http://image.bugsm.co.kr/album/images/original/1825/182522.jpg');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `no` int(11) NOT NULL,
  `tag` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'2'),(1,'5'),(2,'2'),(2,'6'),(3,'2'),(3,'6'),(4,'2'),(4,'5'),(5,'2'),(5,'6'),(6,'2'),(6,'5'),(6,'6'),(7,'2'),(7,'5'),(8,'2'),(8,'5'),(9,'2'),(9,'5'),(9,'6'),(10,'2'),(10,'5'),(11,'2'),(11,'5'),(12,'2'),(12,'6'),(13,'2'),(13,'6'),(14,'2'),(14,'6'),(15,'2'),(15,'5'),(16,'2'),(16,'6'),(17,'2'),(17,'5'),(18,'2'),(18,'5'),(19,'2'),(19,'5'),(20,'2'),(20,'5'),(21,'1'),(21,'6'),(22,'1'),(22,'5'),(23,'1'),(23,'6'),(24,'1'),(24,'5'),(25,'1'),(25,'6'),(26,'1'),(26,'5'),(27,'1'),(27,'5'),(27,'6'),(28,'1'),(28,'6'),(29,'1'),(29,'6'),(30,'1'),(30,'5'),(31,'1'),(31,'6'),(32,'1'),(32,'5'),(32,'6'),(33,'1'),(33,'6'),(34,'1'),(34,'5'),(35,'1'),(35,'6'),(36,'1'),(36,'5'),(37,'1'),(37,'6'),(38,'1'),(38,'5'),(39,'1'),(39,'5'),(40,'4'),(40,'5'),(40,'6'),(41,'4'),(41,'5'),(41,'6'),(42,'4'),(42,'6'),(43,'4'),(43,'5'),(44,'4'),(44,'5'),(45,'4'),(45,'5'),(46,'4'),(46,'5'),(46,'6'),(47,'4'),(47,'6'),(48,'4'),(48,'5'),(48,'6');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-13  1:29:08
