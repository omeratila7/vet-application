# SPRING BOOT VET MANAGEMENT SYSTEM

## Technology that used

| Technology                 | Description         |
|----------------------------|---------------------|
| Core Framework             | Spring Boot         |
| Security Framework         | Spring Security     |
| Persistent Layer Framework | Spring Data JPA     |
| Database                   | H2                  |
| Frontend                   | Bootstrap,Thymeleaf |

## How to run project
```shell
$ git clone https://github.com/omeratila7/vet-application.git
$ cd vet-application
$ mvn spring-boot:run
```

- Then got to **http://localhost:8080** with your browser.

![home page](./images/homepage.jpg)

This is our homepage if you want to use system you need to log in.

![login page](./images/loginpage.jpg)

This is login page. System comes with 2 account user:user and admin:admin
If you want to test just type admin at username and password.

![register page](./images/register.jpg)

If you want to create new account you can create it from register page.

![pet owners page](./images/pet-owners.jpg)

This is pet owners page. User can add new pet owners. If you want to update
and delete operations You need to log in as admin.

![403 page](./images/403.jpg)

If a user which don't have admin permissions tries to update or delete owner .
they will direct to 403 page

![pets page](./images/pets.jpg)

This is pets page.As pet owners' user can add new pets but cannot update or delete
without admin.

![new pet](./images/new-pet.jpg)

As you can see, to add a new pet to the system et least one pet owner should be in db.

![search by owner](./images/search-by-owner-name.jpg)

![search by pet name](./images/search-by-pet-name.jpg)

You can search pets from search pet tab by their name or owner's name.

Also, you can search by clicking owners name at pets or owners name. 

## Accessing data with H2 console

You can access H2 console with typing browser **http://localhost:8080/h2**

Fill the login form as follows and click on Connect:

* 	Saved Settings: **Generic H2 (Embedded)**
* 	Setting Name: **Generic H2 (Embedded)**
* 	Driver class: **org.h2.Driver**
* 	JDBC URL: **jdbc:h2:file:./database/testdb**
* 	User Name: **ryu**
* 	Password: **1597**

![h2 console login](./images/h2-console-login.jpg)

After you log in you can run SQL queries to do data operations.

![h2 console](./images/h2-console.jpg)

