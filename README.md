# 🛫 Flying Java - Seat Booking Console App

A simple Java console application that simulates a **seat booking system**. Users can view seat availability, purchase tickets, and review payment records—all from the terminal. This project was created as part of the COSC005W module.

---

## 🎯 Features

- 💺 Dynamic seat layout (4 rows: economy and business class simulation)
- 💳 Ticket purchase based on seat location
- 📧 Email-based payment recording
- 🗺️ Visual seat map with real-time availability
- 🧾 Payment history view
- 🧪 Input validation for user-friendly experience

---

## 🧠 How It Works

Upon launching the app:
1. The user is greeted with a main menu.
2. Users can:
   - Buy a ticket
   - View the seating map
   - Display all previous payments
3. Seats are marked as:
   - `[O]` Available
   - `[X]` Occupied
   - `|` Aisle

Ticket pricing:
- Rows **1 & 4**: £50 (Economy)
- Rows **2 & 3**: £80 (Business)

---

## 🧱 Project Structure

src/
├── App.java          # Main application logic
├── Payment.java      # Payment object (stores email & amount)

> 🔧 Note: Make sure you have the `Payment` class implemented before running.

---

## 🚀 Getting Started

### Requirements
- Java JDK 8 or above
- IDE or terminal to compile and run

### Run the App
```bash
javac App.java Payment.java
java App

## 📸 Demo (Terminal)

+---------------------------------------------+
|                MAIN MENU                    |
+---------------------------------------------+
|  1) Buy a ticket                            |
|  2) Show seating area and available seats   |
|  3) Show all payments                       |
|  0) Quit                                    |
+---------------------------------------------+

## 📂 Example Output

Row 1(£50)  [O][O][O][O][O][O][O][O][O] | [O][O][O][O][O][O][O]
Row 2(£80)  [O][O][X][O][O][O][O][O][O] | [O][O][O][O][O][O][O][O][O][O][O][O]
