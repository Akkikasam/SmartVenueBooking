Smart Venue & Workspace Booking System - Documentation
1. README.md
Project Overview
The Smart Venue & Workspace Booking System is a Core Java console-based application that allows users to search, book, cancel, and manage different types of venues such as Function Halls, Workspaces, and To-Let properties.

It simulates a booking platform similar to Flipkart/Swiggy but for spaces. This project demonstrates the use of OOP principles, Java collections, file handling, and design patterns like Factory and Singleton.
Features
•	Search venues by location / type / name.
•	 Book and cancel bookings.
•	 Prevents double booking (custom exception handled).
•	 Saves and loads bookings from files for persistence.
•	 Implements OOP concepts (Abstraction, Inheritance, Encapsulation, Polymorphism).
•	 Implements Design Patterns: Factory Pattern, Singleton Pattern.
•	 Overrides important Object class methods (toString, equals, hashCode).
Project Structure

src/
 └── com.bookingapp/
      ├── main/
      │    └── Application.java
      ├── model/
      │    ├── Venue.java
      │    ├── FunctionHall.java
      │    ├── Workspace.java
      │    ├── ToLet.java
      │    ├── Booking.java
      │    └── User.java
      ├── factory/
      │    └── VenueFactory.java
      ├── manager/
      │    └── BookingManager.java
      ├── interfaces/
      │    ├── Bookable.java
      │    └── Searchable.java
      └── exceptions/
           ├── VenueNotFoundException.java
           └── AlreadyBookedException.java

Setup & Run
Linux/macOS:
cd src
javac com/bookingapp/**/**/*.java com/bookingapp/**/*.java
java com.bookingapp.main.Application
Windows (CMD/PowerShell if glob doesn’t work):
javac com\bookingapp\interfaces\*.java com\bookingapp\exceptions\*.java com\bookingapp\model\*.java com\bookingapp\factory\*.java com\bookingapp\manager\*.java com\bookingapp\main\Application.java
java com.bookingapp.main.Application
Sample Output

[INFO] Venues in Hyderabad:
   1. Grand Palace | Function Hall | ₹50,000/day | Capacity: 500

[BOOKING SUCCESS]
   Booking ID: BK101
   Venue: Grand Palace
   Date: 15-09-2025
   Final Price: ₹50,000

[ERROR] AlreadyBookedException: Grand Palace is already booked for 15-09-2025.

[CANCEL SUCCESS] Booking BK101 cancelled successfully.

2. Technical Report
OOP Concepts Applied
•	Abstraction – Venue (abstract class) with abstract method calculateFinalPrice().
•	 Inheritance – FunctionHall, Workspace, ToLet extend Venue.
•	 Encapsulation – Private fields + getters/setters in Booking, User, Venue.
•	 Polymorphism – calculateFinalPrice() overridden in subclasses.
•	 Interfaces – Bookable, Searchable implemented in Venue and User.
•	 Design Patterns – Factory (VenueFactory), Singleton (BookingManager).
•	 Exception Handling – VenueNotFoundException, AlreadyBookedException.
•	 File Handling – Save/load bookings in bookings.txt.
•	 Object Overrides – toString(), equals(), hashCode().
UML (Text Representation)

<<interface>> Bookable
 + book(date)
 + cancelBooking(date)

<<interface>> Searchable
 + search(keyword)

<<abstract>> Venue
 - id:int
 - name:String
 - location:String
 - price:double
 - capacity:int
 + calculateFinalPrice():double
 + toString(), equals(), hashCode()

        /       |       \
FunctionHall  Workspace  ToLet

VenueFactory
 + createVenue(...): Venue

Booking
 - bookingId:String
 - venue:Venue
 - user:User
 - date:String

User (implements Searchable)
 - id:int
 - name:String
 - email:String
 + search(keyword)
 + bookVenue()

BookingManager (Singleton)
 - bookings: List<Booking>
 + addBooking()
 + cancelBooking()
 + saveToFile()
 + loadFromFile()

Exceptions:
 - VenueNotFoundException
 - AlreadyBookedException

Pseudocode (High-Level)

INTERFACE Bookable:
   METHOD book(date)
   METHOD cancelBooking(date)

INTERFACE Searchable:
   METHOD search(keyword)

ABSTRACT CLASS Venue implements Bookable
   FIELDS: id, name, location, price, capacity
   ABSTRACT METHOD calculateFinalPrice()

CLASS FunctionHall extends Venue
   METHOD calculateFinalPrice() -> seasonal pricing

CLASS Workspace extends Venue
   METHOD calculateFinalPrice() -> per-hour

CLASS ToLet extends Venue
   METHOD calculateFinalPrice() -> per-month

CLASS VenueFactory
   METHOD createVenue(type, details) -> Venue

CLASS Booking
   FIELDS: bookingId, venue, user, date

CLASS User implements Searchable
   FIELDS: id, name, email
   METHOD search(keyword)
   METHOD bookVenue(venue, date)

CLASS BookingManager (Singleton)
   FIELD: bookings List<Booking>
   METHODS: addBooking(), cancelBooking(), saveToFile(), loadFromFile()

EXCEPTIONS:
   VenueNotFoundException
   AlreadyBookedException

I/O Explanation

Input:
- Search venues by location (e.g., Hyderabad).
- Book a venue for a specific date.
- Try double booking the same venue.
- Cancel booking.

Output:
- Displays search results.
- Shows booking confirmation with ID and price.
- Throws AlreadyBookedException on duplicate booking.
- Displays cancellation success message.
