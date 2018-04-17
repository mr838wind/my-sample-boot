/* <<schema>> */

/*Table structure for table tb_sample */



DROP TABLE IF EXISTS tb_sample;



CREATE TABLE tb_sample (
  id 	VARCHAR(200) NOT NULL COMMENT 'id',
  name 	VARCHAR(200)  NOT NULL COMMENT 'name',
  PRIMARY KEY (id)
);


/*Table structure for table tb_contents */



DROP TABLE IF EXISTS tb_contents;



CREATE TABLE tb_contents (
  seq INT NOT NULL AUTO_INCREMENT COMMENT 'seq',
  fk_sample_id 	VARCHAR(200) NOT NULL COMMENT 'fk_sample_id',
  some_contents 	VARCHAR(200)  NOT NULL COMMENT 'contents',
  PRIMARY KEY (seq)
);

