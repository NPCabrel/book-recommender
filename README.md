
# Book Recommendation System

A Java-based recommendation engine that suggests books based on co-occurrence in orders. This project demonstrates core Java skills, object-oriented design, and test-driven development (TDD).

## Features

- **Core Logic:** Recommends books frequently borrowed together.
- **Object-Oriented Design:** Clean separation of concerns with `Book`, `Order`, and `BookRecommender` classes.
- **Test-Driven Development:** Full test coverage with JUnit.
- **Build Automation:** Managed with Maven for easy dependency management.

## Technology Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **Version Control:** Git

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/YourUsername/book-recommender.git
    cd book-recommender
    ```

2.  **Compile and run the tests:**
    ```bash
    mvn test
    ```

3.  **Run the main application:**
    ```bash
    mvn compile exec:java -Dexec.mainClass="Main"
    ```