INSERT INTO catfish (pet_name, pet_desc, pet_gender, pet_age, pet_species, pet_status, pet_pic)
VALUES ("Marvin", "This chubby gubby is a friendly lad that loves to eat!", "Male", "2 years", "Gubby-Domestic ShortHair", "Adoptable", "image.png"); 

remember! The views didnt work because you were targetting wrong!
you had controller "/adopt" and method "/", which caused issues. When you changed to "/adopt" and "", the errors stopped occurring. Not sure if this is because path name correllates to view name?