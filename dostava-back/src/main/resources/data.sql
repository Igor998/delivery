INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO `dostava`.`dostavljac` (`id`, `brojlk`, `ime_prezime`, `jmbg`) VALUES ('1', '1234567', 'Pera Peric', '8593729087634');
INSERT INTO `dostava`.`dostavljac` (`id`, `brojlk`, `ime_prezime`, `jmbg`) VALUES ('2', '6840238', 'Mita Mitic', '7059473655483');
INSERT INTO `dostava`.`dostavljac` (`id`, `brojlk`, `ime_prezime`, `jmbg`) VALUES ('3', '6749392', 'Ivan Ivanic', '7685674635635');
INSERT INTO `dostava`.`dostavljac` (`id`, `brojlk`, `ime_prezime`, `jmbg`) VALUES ('4', '9604934', 'Sima SImic', '9038575464646');

INSERT INTO `dostava`.`narudzba` (`id`, `broj_narudzbe`, `cena`, `datum_kreiranja`, `mesto_isporuke`, `opis`, `dostavljac_id`) VALUES ('1', '46574', '500', '2020-11-25', 'Vase Stajica 6, Novi Sad', 'Pizza', '1');
INSERT INTO `dostava`.`narudzba` (`id`, `broj_narudzbe`, `cena`, `datum_kreiranja`, `mesto_isporuke`, `opis`, `dostavljac_id`) VALUES ('2', '12345', '2200', '2020-11-30', 'Andje Rankovic 5, Novi Sad', 'Sushi', '2');
INSERT INTO `dostava`.`narudzba` (`id`, `broj_narudzbe`, `cena`, `datum_kreiranja`, `mesto_isporuke`, `opis`, `dostavljac_id`) VALUES ('3', '54321', '7500', '2020-12-02', 'Kraljevica Marka 44, Novi Sad', 'Suwlaki', '3');
INSERT INTO `dostava`.`narudzba` (`id`, `broj_narudzbe`, `cena`, `datum_kreiranja`, `mesto_isporuke`, `opis`, `dostavljac_id`) VALUES ('4', '97654', '3330', '2020-11-25', 'Sime Matavulja 17, Novi Sad', 'Burito', '4');

INSERT INTO `dostava`.`racun` (`id`, `broj_racuna`, `datum_kreiranja`, `ukupna_cena`, `narudzba_id`) VALUES ('1', '45673', '2020-11-25', '500', '1');
INSERT INTO `dostava`.`racun` (`id`, `broj_racuna`, `datum_kreiranja`, `ukupna_cena`, `narudzba_id`) VALUES ('2', '54565', '2020-11-25', '2200', '2');
INSERT INTO `dostava`.`racun` (`id`, `broj_racuna`, `datum_kreiranja`, `ukupna_cena`, `narudzba_id`) VALUES ('3', '89654', '2020-11-25', '7500', '3');
INSERT INTO `dostava`.`racun` (`id`, `broj_racuna`, `datum_kreiranja`, `ukupna_cena`, `narudzba_id`) VALUES ('4', '12891', '2020-11-25', '3330', '4');


--
--UPDATE `dostava`.`narudzba` SET `racun_id` = '1' WHERE (`id` = '1');
--UPDATE `dostava`.`narudzba` SET `racun_id` = '1' WHERE (`id` = '1');
--UPDATE `dostava`.`narudzba` SET `racun_id` = '1' WHERE (`id` = '1');
--UPDATE `dostava`.`narudzba` SET `racun_id` = '1' WHERE (`id` = '1');