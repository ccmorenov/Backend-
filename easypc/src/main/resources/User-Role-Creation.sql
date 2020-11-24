DROP TABLE IF EXISTS `easypcunal`.`Role` ;

CREATE TABLE IF NOT EXISTS `easypcunal`.`Role` (
  `id_role` INT NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`))
;

DROP TABLE IF EXISTS `easypcunal`.`User_role` ;

CREATE TABLE IF NOT EXISTS `easypcunal`.`User_role` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_role`),
  INDEX `fk_User_has_Role_Role1_idx` (`id_role` ASC) VISIBLE,
  INDEX `fk_User_has_Role_User_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Role_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `easypcunal`.`User` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `easypcunal`.`Role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

insert into `easypcunal`.Role (id_role,role_name) values(1,"client");
insert into `easypcunal`.Role (id_role,role_name) values(2,"admin");