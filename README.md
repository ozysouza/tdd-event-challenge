# Spring Boot TDD Challenge - City API

This project is a hands-on coding challenge to **implement a RESTful API** for managing cities using a **test-driven development (TDD)** approach. All the integration tests are already provided, and the goal is to make them pass by implementing the necessary layers (repository, service, controller).

---

## ✅ Objective

Implement the following city operations:

- `GET /cities` → Retrieve a list of cities sorted by name
- `POST /cities` → Insert a new city
- `DELETE /cities/{id}` → Delete a city by ID (with validation)

- `UPDATE /events` → Update an Event
---

## 🔍 Predefined Tests

Tests are located in `CityControllerIT.java` and `EventControllerIT.java`:

| Test Method | Description |
|-------------|-------------|
| `findAllShouldReturnAllResourcesSortedByName()` | Ensures `GET /cities` returns a sorted list |
| `insertShouldInsertResource()` | Verifies successful insertion of a new city |
| `deleteShouldReturnNoContentWhenIndependentId()` | Deletes a city not referenced by other entities |
| `deleteShouldReturnNotFoundWhenNonExistingId()` | Handles deletion of non-existent city |
| `deleteShouldReturnBadRequestWhenDependentId()` | Handles deletion of a city with foreign key constraints |
| `updateShouldUpdateResourceWhenIdExists()` | Verifies successful update of an event |
| `updateShouldReturnNotFoundWhenIdDoesNotExist()` | Handles update of non-existent event |


---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- JUnit 5
- MockMvc
- Jackson
- Maven

---
