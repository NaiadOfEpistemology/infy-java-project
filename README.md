# **SmartEwaste – Full Stack Project**

A **rough first version** full-stack **E-Waste Collection & Management System** built using:

- **Spring Boot (Backend)**
- **React + Vite (Frontend)**
- **MySQL Database**
- **JWT Authentication**

This README explains **exactly how to run the project**, step-by-step.

---

# **Project Structure**
```bash
SmartEwasteProject/
backend/
src/
pom.xml
application.properties
frontend/
src/
package.json
vite.config.js
```

---

# **How to Clone the Repository**

Open your terminal and run :

```sh
git clone https://github.com/NaiadOfEpistemology/infy-java-project.git
cd SmartEwasteProject
```
You will now see :
```sh
backend/
frontend/
```

---

# **Tech Stack**

## **Backend - Spring Boot**

- Java 17+
- Spring Boot 3+
- Spring Security + JWT
- Spring Data JPA
- MySQL
- Maven

## **Frontend - React**

- React + Vite
- Axios
- React Router DOM

---

# **Required Tools**

Check if these are installed before running the project :

**Java 17+**
```bash
java -version
```

**Maven**
```bash
mvn -version
```

**Node.js + npm**
```bash
node -v
npm -v
```

**MySQL**
```bash
mysql -u root -p
```

---

# **MySQL Setup**

Open MySQL:
```bash
mysql -u root -p
```

Create the database:
```bash
CREATE DATABASE ewaste;
```
Spring Boot will automatically create tables on first run.

---

# **Backend Setup (Spring Boot)**

Go to the backend folder:
```bash
cd backend
```

Open ``` src/main/resources/application.properties ``` and update:

spring.application.name=smartEwaste
spring.datasource.url=jdbc:mysql://localhost:3306/ewaste
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD **//very important**

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

Run the backend
./mvnw spring-boot:run (for Mac)
mvn spring-boot:run (for Windows)


When you see:
```bash
Tomcat started on port 8080
```
Backend is running successfully.

---

# **Testing APIs Using Postman**

## **Register User**

**POST**
```bash
http://localhost:8080/api/auth/register
```
Right below that, you will find a few options : 
Body -> choose 'raw' -> choose 'JSON'
In the text box, type : 
{
  "fullName": "Name",
  "email": "name@example.com",
  "password": "4321"
}


Expected response : **200 OK**

## **Login User**

**POST**
```bash
http://localhost:8080/api/auth/login
```
Right below that, you will find a few options : 
Body -> choose 'raw' -> choose 'JSON'
In the text box, type : 
{
  "email": "name@example.com",
  "password": "4321"
}
Expected response : JWT Token as response.

---

# **Frontend Setup**

Go to the frontend folder:
```bash
cd frontend
```
Install dependencies:
```bash
npm install
```
Start the frontend:
```bash
npm run dev
```
Vite will show : http://localhost:5173. Open this in your browser.

Inspect console if you are not redirected to the dashboard page after logging in.

---

# **How Frontend Connects to Backend**

Frontend uses Axios to call : http://localhost:8080/api/auth/login

Ensure the backend is running before using the frontend login page.
