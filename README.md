🪧In This Code , we are going to create a system for library management With hibernate and connect to postgres.
add first we create model😈

![Screenshot 2024-11-19 151326](https://github.com/user-attachments/assets/d59c180c-71b4-4ced-8bd4-beb1a88a1e85)



in this picture we have all model need 
enum class :: two of them are enum class in gender enum we have men and women only we need and in another enum class we hame two type 
of admin and user we create this enum class for login when users are enter username and password we use this class to divide them from acsess
BaseModel :: in BaseModel we have Variable id and create 
User :: User class are father and users and admin are extend this class in father we use all variable common child we use abstrac for this class to no entity table in database
admin :: this class are extend User as father an inherit all varaible this class are labrian we need
users :: this class are extend User as father an inherit all varaible this class are member we need

