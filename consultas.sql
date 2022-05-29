SELECT * FROM Auth;
INSERT INTO Auth (email, password) values ("email", "password");

-- Person
SELECT * FROM Person;
INSERT INTO Person (dni,fullName,title,profileImg,bannerImg) values (1111111,"nombre","titulo","","");

-- Contact
SELECT * FROM Contact;
INSERT INTO Contact (email,phone,linkedin,address) values ("email","11111","linkedin","address");

-- About
SELECT * FROM About;
INSERT INTO About (paragraph) values ("Paragraph");


SELECT * FROM Section;
INSERT INTO Section (sectionTitle,visible) values ("About", true);
INSERT INTO Section (sectionTitle,visible) values ("Experience", true);
INSERT INTO Section (sectionTitle,visible) values ("Curso", true);
INSERT INTO Section (sectionTitle,visible) values ("Education", true);
INSERT INTO Section (sectionTitle,visible) values ("Hard Skills", true);
INSERT INTO Section (sectionTitle,visible) values ("Soft Skills", true);
INSERT INTO Section (sectionTitle,visible) values ("Projects", true);

