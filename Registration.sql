use in18;
CREATE TABLE Registration (
    ID INT AUTO_INCREMENT PRIMARY KEY,        
    Name VARCHAR(100) NOT NULL,               
    Email VARCHAR(255) UNIQUE NOT NULL,       
	Age INT CHECK (Age >= 18), 
    PhoneNumber VARCHAR(15),                 
    Address TEXT,                             
    RegisteredAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
