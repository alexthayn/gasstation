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

Patterns we used:
-Command pattern: We used the command pattern in our design to encapsulate all the information needed to pump gas from a tank. We had a getDieselCommand, getPremiumCommand, and a getUnleadedCommand. By using these commands it allowed us to encapsulate the get fuel functions so our actual pump didn’t need to know about the inner workings which made the pumps loosely coupled with the fuel tanks

-Singleton pattern: We used the singleton pattern for each type of tank we created. This made sure we were only ever accessing one tank object and that the get fuel commands were only ever pulling fuel out of one single tank that was shared between all pumps at the gas station.

Patterns we considered using: 

-Observer pattern: We considered using the observer pattern. We wanted to set each tank up as a publisher and have the store be a subscriber that receives notifications when the tank is low. We decided to go with a simpler method (printing a message when the tank was low) that didn’t complicate our code as much.

-Strategy pattern: We also considered using the strategy, but we couldn’t come up with an acceptable use for it. We felt this pattern would unnecessarily complicate our code and was unneeded in our implementation. 

-Decorator pattern: We only considered using this for a second as we went through the list of possible patterns to use. We thought about decorating our gas pumps but then concluded this was a dumb idea and abandoned it.


## Team Members:

- Ty Bayn: https://github.com/TyBayn

- Jackson Porter: https://github.com/jacksonporter

- Alex Thayn: https://github.com/alexthayn

