# Gas Station

![](https://www.snow.edu/pr/brand/images/signature.jpg)

## Software Design Principles (SE 3450)


###### Content from the course, including coursework and other misc. work. Work in this repository is in the Java programming language.

This is a group project that introduced us to using many different software design patterns and multi-threaded applications. It was also a first group project for us together using source control.

## Project Specifications:
(Specifications are given by Professor Heber Allen)

Gas Station has 3 tanks:

- Diesel

- Reg Unleaded

- Premium Unleaded

Gas Station sells 4 types of fuel:

- Diesel

- Reg Unleaded

- Premium Unleaded

- Mid Grade (50% Reg + 50% Premium)

Start with 2 threads, but get ready for up to 16 threads/pumps running at the same time. (*I am not sure if we got to 16 threads*)

RULES:

- Can't sell gas that you didn't have to pump

- Give up-to-the requested number of gallons for that fuel type

- suggested:  customer issues a getFuel(Diesel,25gallons) type of call

Phase 1:

- Use GOOD Patterns

- Start with 2 pumps

- Fuel Tanks get refilled, get emptied by pumps

- The store knows the amount of fuel in each tank

- Pumps need to select the correct type of gas (Pump Accuracy set to 0.1 gallons)

Phase 2:

- Event: if the tank is getting close to needing a refill

- Event: if the tank is empty

- Thread safe!  Make test cases to prove it


## Team Members:

- Ty Bayn: https://github.com/TyBayn

- Jackson Porter: https://github.com/jacksonporter

- Alex Thayn: https://github.com/alexthayn

