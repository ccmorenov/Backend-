DROP TABLE IF EXISTS `heroku_6971bea41b8b7f7`.`Role` ;

CREATE TABLE IF NOT EXISTS `heroku_6971bea41b8b7f7`.`Role` (
  `id_role` INT NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`))
;

DROP TABLE IF EXISTS `heroku_6971bea41b8b7f7`.`User_role` ;

CREATE TABLE IF NOT EXISTS `heroku_6971bea41b8b7f7`.`User_role` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_role`),
  INDEX `fk_User_has_Role_Role1_idx` (`id_role` ASC) VISIBLE,
  INDEX `fk_User_has_Role_User_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Role_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `heroku_6971bea41b8b7f7`.`User` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `heroku_6971bea41b8b7f7`.`Role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

insert into `heroku_6971bea41b8b7f7`.Role (id_role,role_name) values(1,"client");
insert into `heroku_6971bea41b8b7f7`.Role (id_role,role_name) values(2,"admin");