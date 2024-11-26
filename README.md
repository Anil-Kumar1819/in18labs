# in18labs
User Registration & CRUD Operations
  * First we have to create a table in the mysql database with name as Registration.
  * In that table we have create fields like Name, Email, Age, Phone and Address.
  * After that we can open any IDE(Eclipse, STS, Intellij) to write backend code to perform CRUD operations.
  * Now create a java class name Registration and add mysql driver to it as referenced libraries.
  * Now we have to create 4 Methods like CreateRegistraion, ReadRegistration, UpdateRegistration and DeleteRegistration.
        1. CreateRegistraion -  This method is used to register the user. we can pass Name, Email, Age, Phone and Address as input parameters.
        2. ReadRegistration  -  It will return all the records present in the table.
        3. UpdateRegistration - If you want any update then You can update your details by calling this method and passing updated information along with Id.
        4. DeleteRegistration - If you want to delete the record from table then call this method and pass Id as input.
  * whenever your running the application it will ask to select the operation like 1.CreateRegistraion, 2.ReadRegistration, 3.UpdateRegistration and 4.DeleteRegistration
  * Now you have to select one operation and give the appropriate parameters. then it will execute automatically if there is any exception occurs the it will give the exception message.
        
