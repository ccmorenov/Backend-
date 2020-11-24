DROP TABLE IF EXISTS `heroku_1cd996d0bc8bc84`.`Role` ;

CREATE TABLE IF NOT EXISTS `heroku_1cd996d0bc8bc84`.`Role` (
  `id_role` INT NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;

DROP TABLE IF EXISTS `heroku_1cd996d0bc8bc84`.`User_role` ;

CREATE TABLE IF NOT EXISTS `heroku_1cd996d0bc8bc84`.`User_role` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_role`),
  INDEX `fk_User_has_Role_Role1_idx` (`id_role` ASC) VISIBLE,
  INDEX `fk_User_has_Role_User_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Role_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `heroku_1cd996d0bc8bc84`.`User` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `heroku_1cd996d0bc8bc84`.`Role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into heroku_1cd996d0bc8bc84.role values(1,"client");
insert into heroku_1cd996d0bc8bc84.role values(2,"admin");