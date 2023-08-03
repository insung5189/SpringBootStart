-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: sbb.cmdeab77miub.ap-northeast-2.rds.amazonaws.com    Database: qna
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1bs3s37kp8qthx9vwrphr0epu` (`author_id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`),
  CONSTRAINT `FK1bs3s37kp8qthx9vwrphr0epu` FOREIGN KEY (`author_id`) REFERENCES `site_user` (`id`),
  CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'흥부가 기가막혀','2023-05-17 10:04:12.697000',NULL,1,1),(2,'# 감사합니다','2023-05-17 10:10:32.740000',NULL,5,2),(3,'**3개월에 한번씩 가는 대서양 크루즈여행\r\n결코 남의 일이 아닙니다 여사님**','2023-05-17 14:44:07.501000',NULL,5,4),(4,'긴급신고는 112','2023-05-17 15:23:12.605000',NULL,5,5),(5,'간첩신고는 111','2023-05-17 15:23:18.007000',NULL,5,5),(6,'# 만원인데요 😒','2023-05-17 15:37:36.188000',NULL,5,7),(7,'사는놈이 알지 파는놈이 어떻게 안데유','2023-05-17 15:37:58.223000',NULL,5,7),(8,'냅둬유 돼지새끼나 맥이게','2023-05-17 15:38:09.198000',NULL,5,7),(9,'누구맘대로요','2023-05-17 16:20:48.024000',NULL,11,3),(10,'자네는 내일 학원오기 전에 내얼굴 먼저 보게될거란다🐷','2023-05-17 16:21:29.612000',NULL,5,8),(11,'@채롱이 맞짱뜨자','2023-05-17 16:26:50.084000',NULL,5,3),(12,'드..드리겠읍니다','2023-05-18 05:08:50.492000',NULL,5,9),(33,'저 좋아해요 당신을....✨','2023-05-18 18:46:07.345000','2023-05-18 18:47:18.811000',34,35),(34,'ㅇㅋ..','2023-05-18 18:46:13.104000',NULL,35,10),(35,'보안연결이 안되어있군요 s를 붙여주세요 https://','2023-05-18 18:46:29.191000',NULL,5,35),(36,'도메인도 만들어주세요','2023-05-18 18:47:16.988000',NULL,35,35),(38,'증명해보세요','2023-05-18 18:53:41.280000',NULL,36,34),(39,'넵','2023-05-18 19:02:38.206000',NULL,37,34),(40,'머지는 합병입니다','2023-05-18 20:27:01.621000',NULL,5,36),(41,'도메인은 시러시러 인성이는 소매가 좋아','2023-05-18 20:27:32.153000',NULL,5,35),(42,'내가 진짜 조만간 이메일인증 만든다','2023-05-18 20:27:56.291000',NULL,5,34),(43,'제가 진짜인데요 당신은 누구시죠','2023-05-18 20:52:30.869000',NULL,40,34),(44,'해킹당하셨네','2023-05-18 20:53:18.106000',NULL,40,35),(45,'저녁?\r\n나는 삼겹살 먹었는데\r\n키키루뺑뽕','2023-05-18 22:13:42.763000',NULL,5,37),(46,'내가 진짜야! ㅠㅠ','2023-05-18 22:25:10.666000',NULL,5,34),(65,'389일 남았당 전역할때까지 여기에 답변달아야짘ㅋㅋㅋ','2023-05-19 17:37:29.699000',NULL,41,37),(66,'이 서버 aws로 3개월짜리야..','2023-05-19 18:46:09.830000',NULL,5,37),(67,'뭔가 보여드리겠읍니다!','2023-05-19 18:47:13.996000',NULL,5,33),(68,'아 자동로그인 만들어줘 로그인하기 귀찮아~~~','2023-05-19 19:00:24.445000',NULL,41,37),(69,'api는 아직 멀었다...','2023-05-20 13:48:18.749000',NULL,5,37),(70,'# 꺅 😆\r\n# 날 가져요!!!','2023-05-24 20:36:44.391000',NULL,5,65),(71,'그건 쫌..','2023-05-24 20:38:09.464000',NULL,65,65),(72,'# **가져(진지)**','2023-05-25 18:53:22.490000','2023-05-25 18:53:38.260000',5,65),(73,'시간이 해결해줄거야','2023-05-28 02:27:00.227000',NULL,66,37),(74,'매미킴','2023-05-28 02:27:24.336000',NULL,66,35),(75,'랄랄라','2023-06-06 22:01:32.820000',NULL,5,73),(76,'라라라라','2023-06-06 22:01:57.510000',NULL,5,73),(77,'답변도 달리니?','2023-07-31 16:29:57.114000',NULL,5,73),(78,'asdfasdfsa','2023-08-03 01:37:16.261935',NULL,5,73),(79,'답변 등록하기111','2023-08-03 03:07:43.231769',NULL,5,35),(80,'혹시 지금 저 뚱뚱하다고 놀리시는건가요?','2023-08-03 10:28:22.874823',NULL,5,78),(81,'알러지 있다니까요','2023-08-03 10:29:08.809942',NULL,5,76),(82,'마크다운 못쓰세요?\r\n> [키키루뺑뽕 잘만되는걸?](https://www.qna.devh.me/)','2023-08-03 10:29:55.710840',NULL,5,77),(83,'잡상인 출입금지','2023-08-03 10:30:22.251827',NULL,5,75),(84,'앵커태그 쓰세요 배우신양반이 참...','2023-08-03 10:31:45.565440',NULL,5,77);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer_voter`
--

DROP TABLE IF EXISTS `answer_voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_voter` (
  `answer_id` int(11) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`answer_id`,`voter_id`),
  KEY `FKl11k2qjfyl8hrvh5am4obsolt` (`voter_id`),
  CONSTRAINT `FKba6wmkj74k29bxm7877w4u6g5` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`),
  CONSTRAINT `FKl11k2qjfyl8hrvh5am4obsolt` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_voter`
--

LOCK TABLES `answer_voter` WRITE;
/*!40000 ALTER TABLE `answer_voter` DISABLE KEYS */;
INSERT INTO `answer_voter` VALUES (1,5),(4,7),(5,7),(6,5),(9,5),(33,35),(33,40),(35,36),(36,36),(40,5),(40,40),(41,40),(44,5),(68,5),(70,5),(75,5);
/*!40000 ALTER TABLE `answer_voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdqc83j2n6hemidegfkim17d3l` (`answer_id`),
  KEY `FKq5371rjlhewhghrvyo1yl1m5n` (`author_id`),
  KEY `FKde3rfu96lep00br5ov0mdieyt` (`parent_id`),
  CONSTRAINT `FKde3rfu96lep00br5ov0mdieyt` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `FKdqc83j2n6hemidegfkim17d3l` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`),
  CONSTRAINT `FKq5371rjlhewhghrvyo1yl1m5n` FOREIGN KEY (`author_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'ddd','2023-08-01 10:27:33.838336',NULL,75,5,NULL,NULL),(2,'두 번째 대댓글','2023-08-01 11:31:15.935658',NULL,NULL,NULL,NULL,NULL),(3,'두 번째 대댓글','2023-08-01 11:35:53.572002',NULL,NULL,NULL,NULL,NULL),(4,'두 번째 대댓글','2023-08-01 11:39:29.490083',NULL,NULL,NULL,NULL,NULL),(5,'두 번째 대댓글','2023-08-01 11:49:23.137320',NULL,NULL,NULL,NULL,NULL),(6,'두 번째 대댓글','2023-08-01 16:10:13.180665',NULL,NULL,NULL,NULL,NULL),(7,'두 번째 대댓글','2023-08-02 03:14:31.327215',NULL,NULL,NULL,NULL,NULL),(8,'하하하핳','2023-08-02 03:16:13.373499',NULL,75,5,NULL,NULL),(9,'하하하핳','2023-08-02 03:16:14.034039',NULL,75,5,NULL,NULL),(10,'두 번째 대댓글','2023-08-03 00:13:23.667116',NULL,NULL,NULL,NULL,NULL),(11,'asdf','2023-08-03 00:58:20.363028',NULL,73,5,NULL,NULL),(12,'zzzz','2023-08-03 01:03:25.220790',NULL,77,5,NULL,NULL),(13,'asdfasdffdsa','2023-08-03 01:06:36.134497',NULL,77,5,NULL,NULL),(14,'ㅁㄴㅇㄻㄴㅇㅎㅈㅅ곦ㅇㅁㄻㄴㄻㄴㅇㄹ','2023-08-03 01:11:24.920455',NULL,77,5,NULL,NULL),(15,'ㅇㅇ','2023-08-03 01:20:07.693492',NULL,75,5,NULL,NULL),(16,'ㅇㅇ','2023-08-03 01:20:16.257058',NULL,75,5,NULL,NULL),(17,'ㅇㅇ','2023-08-03 01:24:17.637110',NULL,75,5,NULL,NULL),(18,'ㅋㅋㅋ','2023-08-03 01:27:20.767183',NULL,75,5,NULL,NULL),(19,'ㅋㅋㅋ','2023-08-03 01:27:28.955599',NULL,76,5,NULL,NULL),(20,'해당 파이프라인 스크립트를 보면, docker rmi 명령이 이미지를 삭제하는데 실패한 것을 확인할 수 있습니다. 이 오류 메시지는 이미지를 삭제할 수 없는 이유로 인해 발생합니다. 그리고 오류 메시지에도 나와있듯이 해당 이미지가 현재 실행 중인 컨테이너에서 사용 중이기 때문에 삭제할 수 없다고 합니다.\r\n\r\n일반적으로 이미지를 삭제하려면 해당 이미지를 사용하고 있는 컨테이너를 먼저 중지하고 제거해야 합니다. 이러한 점을 고려하여 파이프라인 스크립트를 수정해 보겠습니다.','2023-08-03 01:28:12.571253',NULL,77,5,NULL,NULL),(21,'두 번째 대댓글','2023-08-03 01:56:55.856385',NULL,NULL,NULL,NULL,NULL),(22,'\r\n\r\n\r\n','2023-08-03 01:57:46.951745',NULL,78,5,NULL,NULL),(23,'두 번째 대댓글','2023-08-03 02:03:39.467687',NULL,NULL,NULL,NULL,NULL),(24,'두 번째 대댓글','2023-08-03 02:04:49.867885',NULL,NULL,NULL,NULL,NULL),(25,'두 번째 대댓글','2023-08-03 02:21:22.429069',NULL,NULL,NULL,NULL,NULL),(26,'두 번째 대댓글','2023-08-03 02:22:30.896346',NULL,NULL,NULL,NULL,NULL),(27,'두 번째 대댓글','2023-08-03 02:50:21.686256',NULL,NULL,NULL,NULL,NULL),(28,'두 번째 대댓글','2023-08-03 02:55:38.386108',NULL,NULL,NULL,NULL,NULL),(30,'31년동안 당신을 기다려왔다오','2023-08-03 03:05:05.455624',NULL,33,5,NULL,NULL),(31,'하하하','2023-08-03 09:10:04.771878',NULL,70,5,NULL,NULL),(32,'익명이 보장되는건 좋네요 ㅎ\r\n네','2023-08-03 10:30:02.295875',NULL,80,70,NULL,NULL),(33,'두 번째 대댓글','2023-08-03 10:42:47.895929',NULL,NULL,NULL,NULL,NULL),(34,'두 번째 대댓글','2023-08-03 11:11:05.785447',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_voter`
--

DROP TABLE IF EXISTS `comment_voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_voter` (
  `comment_id` int(11) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`comment_id`,`voter_id`),
  KEY `FK7bcfn4urlnxgsnqvoyywdyl3l` (`voter_id`),
  CONSTRAINT `FK2p1ox3rj9bh96i7ys6m2pujfg` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `FK7bcfn4urlnxgsnqvoyywdyl3l` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_voter`
--

LOCK TABLES `comment_voter` WRITE;
/*!40000 ALTER TABLE `comment_voter` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `subject` varchar(200) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `hit` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKol558tt304fpmksa6mgxrkyg3` (`author_id`),
  KEY `FK7jaqbm9p4prg7n91dd1uabrvj` (`category_id`),
  CONSTRAINT `FK7jaqbm9p4prg7n91dd1uabrvj` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKol558tt304fpmksa6mgxrkyg3` FOREIGN KEY (`author_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'* 안녕하십니까 홍두깨입니다 ','2023-05-17 10:02:41.026000','2023-05-17 10:04:05.583000','안녕하십니까 홍두깨입니다 ',1,NULL,NULL),(2,'# ┗|｀o′|┛','2023-05-17 10:06:38.941000',NULL,'인성님 짬뽕 맛있게 드세요',3,NULL,NULL),(3,'# ♥︎여러분 사랑해요♥︎','2023-05-17 10:11:17.941000',NULL,'관리자입니다',5,NULL,NULL),(4,'살면서 필요할까요?','2023-05-17 10:46:20.499000',NULL,'공부는 왜하는걸까요?',6,NULL,NULL),(5,'더보기를 빨리 말하면 떡볶이 \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n🌶️','2023-05-17 15:18:36.232000','2023-05-17 15:29:24.871000','고발합니다 커뮤니티 운영자의 실체를 보여... 더보기',7,NULL,NULL),(6,'아오','2023-05-17 15:26:56.984000',NULL,'아니 이거 등록시간 어케잡누 utc8',5,NULL,NULL),(7,'게보린','2023-05-17 15:32:55.696000',NULL,'수박이 한통에 5천원, 그럼 두통엔?',8,NULL,NULL),(8,'꿀 꿀 꿀 꿀 ?? 꿀 !! 꿀꿀?!?! 꿀꿀꿀 ㅋ 꿀꿀 ㅎ 🐷','2023-05-17 16:20:10.806000',NULL,'인성오빠 🐽',11,NULL,NULL),(9,'사줭. 술 사줭. 낚시대 사줭. 차 사줭. 집 사줭.','2023-05-18 04:26:44.413000',NULL,'행님',12,NULL,NULL),(10,'세상에서 제일잘나고 잘생긴 인간..\r\n인성에 머리까지.. 더할나위없이 완벼크하다 .☃︎\r\n나는 개천재','2023-05-18 06:25:53.668000',NULL,'나 황인성',14,NULL,NULL),(33,'여러분 오늘 황인성의 똥꼬쇼 하겠습니다.','2023-05-18 18:43:52.627000',NULL,'진짜입니다',34,NULL,NULL),(34,'가짜 황인성이 제 서버를 노리고 있어요\r\n개인정보 조심하세요','2023-05-18 18:45:23.520000',NULL,'여러분 해킹당했어요',34,NULL,NULL),(35,'그걸 왜 튀기죠','2023-05-18 18:45:56.737000',NULL,'매미튀김 좋아하시나요',35,NULL,NULL),(36,'무엇인가요','2023-05-18 19:08:57.087000',NULL,'머지는',36,NULL,NULL),(37,'390일 남았어용','2023-05-18 20:58:43.670000',NULL,'전역시켜주세용',41,NULL,NULL),(65,'나 오늘 상여금 받았어 내가 사줄겡(,,• ֊ •,,)♡','2023-05-24 17:05:00.447000',NULL,'혹시 실례가 안된다면 아이스크림 하나만 사줄실수 있으십니까?',65,NULL,NULL),(73,'들다 다니됩안 면시러이 서기여dd','2023-06-06 22:01:09.843000','2023-08-01 12:10:09.650784','여기서 이러시면 안됩니다 다들',5,NULL,NULL),(74,'허위 광고로 신고하겠읍니다','2023-08-03 10:13:34.068371',NULL,'여긴 뭐여',69,NULL,NULL),(75,'번개장터에서 3000~5000사이 거래하는듯!','2023-08-03 10:13:45.738256',NULL,'디아루가 뽑았어요!!',70,NULL,NULL),(76,'튀김입니다','2023-08-03 10:13:55.782430','2023-08-03 10:14:34.576337','매미는..................................................................................................................... 더보기',69,NULL,NULL),(77,'와 링크도 안 걸려...;;;;;;','2023-08-03 10:15:09.251151','2023-08-03 10:15:28.109101','여기로 오세요',69,NULL,NULL),(78,'뚠뚠','2023-08-03 10:16:18.506988',NULL,'매미는 뚠뚠 오늘도 뚠뚠 열심히 1 을하네 매미는 뚠뚠 오늘도 뚠뚠 열심히 1 을 하네',70,NULL,NULL),(79,'ㅈㄱㄴ','2023-08-03 10:46:34.199850',NULL,'댓글수에 대댓글도 포함되게 해주세요',70,NULL,NULL);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_voter`
--

DROP TABLE IF EXISTS `question_voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_voter` (
  `question_id` int(11) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`question_id`,`voter_id`),
  KEY `FK34r3f5alcto5kqkb271n680wj` (`voter_id`),
  CONSTRAINT `FK15y97p03ye4pku04x3nlvush2` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FK34r3f5alcto5kqkb271n680wj` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_voter`
--

LOCK TABLES `question_voter` WRITE;
/*!40000 ALTER TABLE `question_voter` DISABLE KEYS */;
INSERT INTO `question_voter` VALUES (1,5),(2,5),(4,5),(5,5),(6,5),(6,36),(7,5),(8,5),(9,5),(10,35),(34,36),(35,5),(35,36),(35,40),(36,5),(36,40),(37,5),(65,5),(73,5),(76,5),(77,5),(78,5);
/*!40000 ALTER TABLE `question_voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_user`
--

DROP TABLE IF EXISTS `site_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `last_login_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8vlkw482t3gpnebxcm03ywk9p` (`email`),
  UNIQUE KEY `UK_jerlw3g2urnh55wcrm2b5kqnj` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_user`
--

LOCK TABLES `site_user` WRITE;
/*!40000 ALTER TABLE `site_user` DISABLE KEYS */;
INSERT INTO `site_user` VALUES (1,'test@test','$2a$10$9bMX5w.YX5x7z42tymeple2raE0xoYuaJf5.82pYb3Mz2eLlPZt46','홍두깨',NULL,NULL),(3,'asdfsf@dffasdf.df','$2a$10$J/Ho6s1XvSkclYGlrFX./uIUFRnSv8xf6RqlznwBgTrtZi8FbK0p2','전세린',NULL,NULL),(4,'test@test1','$2a$10$OmRRH7UOpVW8i1I/FQmLfexMWEJ.RFww09kVnqfnWuU5U7Ua9TDfK','저팔계',NULL,NULL),(5,'123@123.com','$2a$10$n8wbMusAMkUCCvoC88y09..5vhuVgqu9aFL2p6UOXE5E0FIGW3giS','황인성',NULL,'2023-08-01 10:50:54.488465'),(6,'Hwle514@gmail.com','$2a$10$bYctDx3PF4oW1io3R.fX8eJwOu3tAw60ymhdMJzJS0rxC4o3uu9Pm','hwlee5104',NULL,NULL),(7,'suzzang5@naver.com','$2a$10$1k8VJ1bGRIP.xs9KYVcyYOoCj.nDzjdE/BrG2lac5S//4odDSj/NG','suzzang5',NULL,NULL),(8,'solrasi01@gmail.com','$2a$10$HGpgbPqZDvOeUjFKZ/ZOwONjRxHHIVaATwyCoZkxOrdxOjMKE8zxO','heeeee',NULL,NULL),(9,'thdcodud01@gmail.com','$2a$10$7detzGz9EmYMyv1kMmrh1eGYYSyGVDnZT6.i89MuQ1v7bNquLVyrW','송채영',NULL,NULL),(11,'thdcodud01@naver.com','$2a$10$d5tOesgL.u0DsoZSYOQAZOMQ9MGuIPXcNs9E87sgkBIVZlXs9n.HG','채롱이',NULL,NULL),(12,'ehdus1463@naver.com','$2a$10$luhc5ShzE1lwi58JY.GsMu57WNnNX6aqJJbCgohxx/vFD3cTiFG8a','Do\'s',NULL,NULL),(14,'d@d','$2a$10$gHUv.DgBuxXtIjYtrQZS/umzLf/YjRhjW1uJY22DR/ec0yRntKPlq','황인성.',NULL,NULL),(34,'dfadsfasdf@jdsfasjd.com','$2a$10$KNkX.weNhXJ9.vpi3g13bO.lSr9lGYBC6i9kSO3sKRbX6dUDuh.92','진짜황인성',NULL,NULL),(35,'HTTP404@HTTP404.HTTP404','$2a$10$wYxAgFiPkdRS1i9El.4aF.WX.i4MsMjJVeoc5lCU98LXZKVOzseyG','HTTP404',NULL,NULL),(36,'502BADGATEWAY@502BADGATEWAY.502BADGATEWAY','$2a$10$hdJywVLcgNdMhbA3kpe/uOr2hRH5DcWqAYqQE8EP0mkFnrePSgzha','502BADGATEWAY',NULL,NULL),(37,'a@a.a','$2a$10$d18smgPcX02yOLkDc1z43OKchjxoEPRT3iKHfQ3I2HWOK1DdF4pOq','신광식',NULL,NULL),(38,'pintor.dev@gmail.com','$2a$10$JMm0ZQ.i3xlwzxJB/5zE5.LMGf6O1hjSblBkjHzygIKCqehQZ8WBS','김호현',NULL,NULL),(40,'HTTP404@HTTP404.HTTP4041','$2a$10$9aJjywTNWAxZY4Zws4YmoecTG8t0SAusn2w9fJrk4bRjtAzLBKKIO','가짜황인성',NULL,NULL),(41,'dlswns5189@gmail.com','$2a$10$sSvxgO7b5oPalqWqN77QcuNrX/Cym/7v4XKaTQ74QCOD61p8uMOUS','jun007',NULL,NULL),(65,'qwert@naver.com','$2a$10$h2Kc2I8LUEp.7gz6O1OTQOveL3MmeAXcrcGRJgPbsnqDoLjC17Qiq','황인성(31남)',NULL,NULL),(66,'sasime737@naver.com','$2a$10$Bfn9XYKluy9sYBQpul7QXe5pVftRvFk9WR0BqLwdoUdRv98Nagll2','인성이 여친 미주',NULL,NULL),(68,'dbeuxhd@naver.com','$2a$10$iKnkpUzczQjapVPSLuZ3dO7QG94JZn2QXAo8uOGPQV8rTbx7TB9ti','인성이는 현주꺼',NULL,NULL),(69,'t@t.t','$2a$10$uXZnMHUN5euOgzZwFFc2/Ocl2kvNbuM9heCddYkUVtBndK2s15xdy','매미황',NULL,NULL),(70,'choosencome@naver.com','$2a$10$YkElwis1krvKYYoLiWrnZuTY.xN.FMucLucyUMdv7ZmB.h1uKzRqq','osoreee',NULL,NULL);
/*!40000 ALTER TABLE `site_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'qna'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-03 12:05:07
