CREATE TABLE TB_BANDA (
  id           INTEGER AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(50) NOT NULL,
  estilo     VARCHAR(20) NOT NULL,
);

CREATE TABLE TB_CIDADE (
  id      INTEGER AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(50) NOT NULL,
  banda_id INTEGER,
  FOREIGN KEY (banda_id) REFERENCES TB_BANDA (id)
);