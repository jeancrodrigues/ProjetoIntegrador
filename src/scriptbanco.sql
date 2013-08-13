delimiter $$

CREATE DATABASE `locadoraveiculos` DEFAULT CHARACTER SET utf8 $$

use `locadoraveiculos` $$

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `idpessoafisica` int(11) DEFAULT NULL,
  `senha` char(50) DEFAULT NULL,
  `usuario` char(50) DEFAULT NULL,
  PRIMARY KEY (`idfuncionario`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8$$

delimiter $$



CREATE TABLE `pessoafisica` (
  `idpessoafisica` int(11) NOT NULL AUTO_INCREMENT,
  `nome` char(50) DEFAULT NULL,
  `datanascimento` date DEFAULT NULL,
  `cpf` char(11) DEFAULT NULL,
  `rg` char(11) DEFAULT NULL,
  `telefone1` char(15) DEFAULT NULL,
  `telefone2` char(15) DEFAULT NULL,
  `idendereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpessoafisica`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `endereco` (
  `idendereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` char(60) DEFAULT NULL,
  `numero` char(15) DEFAULT NULL,
  `bairro` char(20) DEFAULT NULL,
  `cidade` char(20) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `complemento` char(20) DEFAULT NULL,
  `CEP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idendereco`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8$$

INSERT INTO `locadoraveiculos`.`pessoafisica`
(`idpessoafisica`,
`nome`,
`datanascimento`,
`cpf`,
`rg`,
`telefone1`,
`telefone2`,
`idendereco`)
VALUES
(
<{idpessoafisica: }>,
<{nome: }>,
<{datanascimento: }>,
<{cpf: }>,
<{rg: }>,
<{telefone1: }>,
<{telefone2: }>,
<{idendereco: }>
);
$$

delete from pessoafisica; $$

alter table pessoafisica auto_increment 1;


select * from endereco;

select * from pessoafisica
