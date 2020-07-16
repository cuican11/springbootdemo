
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nick` varchar(32) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(125) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `salt` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email` varchar(125) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` tinyint(2) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

 create table Sys_User
 (
    id int primary key auto_increment,
    username varchar(32),
    password varchar(32)
 );

 ###角色表
 create table Sys_Role
 (
    id int primary key auto_increment,
    name varchar(32)
 );

 ###权限表
 create table Sys_Permission
 (
    id int primary key auto_increment,
    name varchar(32),
    description varchar(256),
    url varchar(256),
    pid int
 );

 ###用户角色表
 create table Sys_user_role
 (
    id int primary key auto_increment,
    sys_user_id int,
    sys_role_id int
 );

 ###角色权限表
 create table Sys_role_permission
 (
   id int primary key auto_increment,
   role_id int,
   permission_id int
 );

 insert into SYS_USER(id,username,password) values(1,'admin','admin');
 insert into SYS_USER(id,username,password) values(2,'abel','abel');

 insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
 insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

 insert into SYS_USER_ROLE(SYS_USER_ID,SYS_ROLE_ID) values(1,1);
 insert into SYS_USER_ROLE(SYS_USER_ID,SYS_ROLE_ID) values(2,2);

 BEGIN;
 INSERT INTO `Sys_permission` VALUES('1','ROLE_HOME','home','/',null),('2','ROLE_ADMIN','ABel','admin',null);
 COMMIT;

 BEGIN;
 INSERT INTO `Sys_role_permission` VALUES('1','1','1'),('2','1','2'),('3','2','1');
 COMMIT;