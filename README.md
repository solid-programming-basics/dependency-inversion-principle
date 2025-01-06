# Task 1: Refactoring Code to Comply with the Dependency Inversion Principle (DIP)

## Problem Statement

The goal of this task is to analyze and refactor the provided code that violates the **Dependency Inversion Principle (DIP)**. The current design tightly couples high-level modules (e.g., `OrdersService`) to low-level details (e.g., database access through JDBC), which makes the code rigid, fragile, and difficult to test.

## Requirements

1. **Identify DIP Violations**: Analyze the provided `OrdersService` class and identify where it directly depends on low-level implementation details like JDBC.
2. **Refactor The Code**: Introduce proper abstractions to decouple the high-level module (`OrderService`) from low-level details. This includes creating an interface for database access (e.g., `OrderRepository`) and providing an in-memory implementation.
3. **Use In-Memory Database**: Use an in-memory database (H2) to demonstrate how the decoupled design allows for seamless testing without relying on external systems.

## Constraints

- The `OrdersService` class API (method signatures) must remain unchanged.
- Refactor the code to align with clean code principles, ensuring high cohesion and low coupling.