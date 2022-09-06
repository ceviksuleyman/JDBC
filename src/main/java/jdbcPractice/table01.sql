
CREATE TABLE ogrenciler (
	okul_no int PRIMARY KEY,
	ogrenci_ismi varchar(50),
	sinif varchar(10),
	cinsiyet char
);

INSERT INTO ogrenciler VALUES(100, 'Mustafa Bal', 9, 'E');
INSERT INTO ogrenciler VALUES(101, 'Derya Soylu', 9, 'K');
INSERT INTO ogrenciler VALUES(102, 'Enes Boz', 9, 'E');
INSERT INTO ogrenciler VALUES(103, 'Nil Naz', 9, 'K');
INSERT INTO ogrenciler VALUES(104, 'Ali Can', 9, 'E');
INSERT INTO ogrenciler VALUES(105, 'Yusuf Cengiz', 10, 'E');
INSERT INTO ogrenciler VALUES(106, 'Ahmet Aslan', 10, 'E');
INSERT INTO ogrenciler VALUES(107, 'Mehmet Aslan', 10, 'E');
INSERT INTO ogrenciler VALUES(108, 'Sena Yavuz', 10, 'K');
INSERT INTO ogrenciler VALUES(109, 'Zehra Amber', 10, 'K');
INSERT INTO ogrenciler VALUES(110, 'Fatma Nur', 11, 'K');
INSERT INTO ogrenciler VALUES(111, 'Mustafa Bay', 11, 'E');
INSERT INTO ogrenciler VALUES(112, 'Murat Kerem', 11, 'E');
INSERT INTO ogrenciler VALUES(113, 'Sinan Ay', 11, 'E');
INSERT INTO ogrenciler VALUES(114, 'Figen Bal', 11, 'K');
INSERT INTO ogrenciler VALUES(115, 'Serkan Bayram', 12, 'E');
INSERT INTO ogrenciler VALUES(116, 'Hakan Bacak', 12, 'E');
INSERT INTO ogrenciler VALUES(117, 'Zafer Yanak', 12, 'E');
INSERT INTO ogrenciler VALUES(118, 'Birol Kara', 12, 'E');
INSERT INTO ogrenciler VALUES(119, 'Ayten Tan', 12, 'K');
INSERT INTO ogrenciler VALUES(120, 'Mustafa Tan', 12, 'E');


SELECT * FROM ogrenciler
WHERE cinsiyet = 'E'