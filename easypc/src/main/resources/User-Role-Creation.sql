DROP TABLE IF EXISTS `woja38qpioj7dt3x`.`role` ;

CREATE TABLE IF NOT EXISTS `woja38qpioj7dt3x`.`role` (
  `id_role` INT NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`))
;

DROP TABLE IF EXISTS `woja38qpioj7dt3x`.`user_role` ;

CREATE TABLE IF NOT EXISTS `woja38qpioj7dt3x`.`user_role` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_role`),
  INDEX `fk_User_has_Role_Role1_idx` (`id_role` ASC) VISIBLE,
  INDEX `fk_User_has_Role_User_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Role_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `woja38qpioj7dt3x`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `woja38qpioj7dt3x`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

insert into `woja38qpioj7dt3x`.role (id_role,role_name) values(1,"client");
insert into `woja38qpioj7dt3x`.role (id_role,role_name) values(2,"admin");