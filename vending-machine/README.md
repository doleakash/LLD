# Vending Machine - Low Level Design (LLD)

A Java implementation of a Vending Machine demonstrating object-oriented design principles and the State Design Pattern.

## Features

- Display available products
- Product selection
- Multiple coin insertion
- Purchase products
- Return change
- Refund transaction
- Inventory management
- Cash inventory management
- State-based machine behavior

---

## Design Principles

The implementation focuses on:

- Single Responsibility Principle (SRP)
- Encapsulation
- Composition over inheritance
- Separation of concerns
- State Design Pattern

---

## Core Entities

### VendingMachine
Coordinates the complete purchase workflow and delegates behavior to the current machine state.

### Inventory
Responsible for managing product stock.

Responsibilities:
- Add stock
- Check availability
- Decrement stock
- Get available products

### CashInventory
Maintains available cash denominations inside the machine.

Responsibilities:
- Add cash
- Remove cash
- Calculate and dispense change

### Transaction
Represents a user's purchase session.

Responsibilities:
- Selected product
- Inserted denominations
- Payment validation
- Change calculation
- Transaction status

### InventoryItem
Represents a product inside the vending machine.

---

## State Pattern

The vending machine behavior changes based on its current state.

```
IdleState
      │
      ▼
ItemSelectedState
      │
      ▼
ReadyToDispenseState
      │
      ▼
IdleState
```

### IdleState
- Select product ✅
- Insert money ❌
- Purchase ❌
- Refund ❌

### ItemSelectedState
- Insert money ✅
- Purchase ❌ (until sufficient payment)
- Refund ✅

### ReadyToDispenseState
- Insert more money ✅
- Purchase ✅
- Refund ✅

---

## Purchase Flow

```
Display Products
        │
        ▼
Select Product
        │
        ▼
Create Transaction
        │
        ▼
Insert Coins
        │
        ▼
Validate Payment
        │
        ▼
Update Inventory
        │
        ▼
Update Cash Inventory
        │
        ▼
Calculate Change
        │
        ▼
Dispense Product
        │
        ▼
Return Change
        │
        ▼
Reset Machine
```

---

## Design Patterns Used

- State Pattern
- Composition

---

## Learning Outcomes

This project helped practice:

- Entity identification
- Responsibility assignment
- Object collaboration
- Workflow orchestration
- State transitions
- Encapsulation
- Runtime polymorphism

---

## Future Improvements

- Support Card / UPI payments
- Admin mode for stock management
- Persistence layer
- Multi-slot inventory
- Product codes (A1, B2, C3)
- Thread safety
- REST API
- Unit tests

---

## Tech Stack

- Java
- OOP
- Collections Framework
- State Design Pattern