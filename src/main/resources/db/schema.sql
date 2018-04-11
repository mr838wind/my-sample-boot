/* <<schema>> */

/*Table structure for table tb_sample */



DROP TABLE IF EXISTS tb_sample;



CREATE TABLE tb_sample (
  id 	varchar(200) NOT NULL COMMENT 'id',
  name 	varchar(200)  NOT NULL COMMENT 'name',
  PRIMARY KEY (id)
);
