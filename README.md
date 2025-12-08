
<a href="https://ddshop-backend2.onrender.com/">🍰Dessert E-Commerce Backend</a>

This is the **backend service** for the Dessert E-Commerce application. It is built with **Spring Boot** and connected to a **PostgreSQL** database.  

---

## 🛠️ Tech Stack  

- **Spring Boot** – Backend framework.  
- **PostgreSQL** – Relational database.  
- **Maven** – Dependency management and build tool.  
- **JWT Authentication** – For securing endpoints and handling user sessions.  
- **Lombok** – To reduce boilerplate code in entities and DTOs.  

---

## 📂 Project Structure  

The project follows a layered architecture with the following packages:  

- **Controllers** – Handle incoming HTTP requests and return responses.  
- **Services** – Contain the business logic.  
- **Repositories** – Communicate with the PostgreSQL database.  
- **Entities** – Represent database models.  
- **DTOs & Mappers** – Used to transfer and convert data between layers.  
- **Security** – Includes JWT-based authentication and authorization.  

---

## 📡 API Endpoints  

Here are the main endpoints of the application :  

- **Authentication**  
  - `POST /api/auth/login` – Authenticate user and return JWT.  
  - `POST /api/auth/register` – Register a new user.   
...
---

