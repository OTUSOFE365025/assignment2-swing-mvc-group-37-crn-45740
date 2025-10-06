<br>

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)

# Assignment 2 - SOFE3650 (Group 37)
This is the project home for Group 37's submission for Assignment 2 in the SOFE3650 F25 course.

## Work Distribution
| Student ID | Name | Completed Work                                                  |
|:----------:| ---- |-----------------------------------------------------------------|
| 100862425  | Lily Redpath | <ul><li>Swing MVC Explanation</li><li>CashRegisterMVC</li></ul> |
| 100924543  | Jonathan Leaper | PLEASE FILL IN                                                  |
| 100922080  | Vlad Stetca | PLEASE FILL IN                                                  |

## Repository Layout
The repository layout is set up as the following:
```text
Key:
<file/directory name> <(D)irectory/(F)ile> -> <description>
-------------------------------------------------------------
.github             -> GitHub configuration files
.idea (D)           -> IntelliJ Idea configuration folder
docs (D)            -> All raw documentation files required
CashRegisterMVC (D) -> All Java source files created for part 3 of the assignment
SwingMVC (D)        -> All Java source files provided for the Swing MVC example.
README.md (F)       -> The file you're currently reading!
```

## Swing Explanation

## Swing MVC Explanation
The normal MVC architecture involves three titular components:

- The Model, which acts as a data storage
- The View, which displays data from the Model
- The Controller, which manages the data in the Model

Under normal circumstances, the Model does not directly update the view, instead an Observer pattern is
typically used to manage the data connection between the View and the Model. The View will subscribe to any changes
that are made to the Model and will update its content accordingly.

The reason an Observer pattern is put between the View and Model components is to reduce component coupling. If the View
were to disappear, the rest of the application would still function. However, if there was a direct link between the
Model and View, if the View were to disappear, the rest of the application would break as the Model is directly relying
on the View to exist.

**In this repository, however, the example provided uses a different approach to MVC**. Instead of the View subscribing
to changes in the View and updating its contents accordingly, the Controller is used to manage the View's contents.
The View is a Java Swing application, and in the Controller class, any changes that are made via the View are updated in
the Model by the Controller, while simultaneously updating the View itself.

**TD;DR**: The flow of information in the normal MVC pattern is as follows:
```
View -> Controller -> Model -> [Observer Middleman] -> View
```
While in the Swing example provided in this repository under `SwingMVC`, the follow of information is as follows:
```
View -> Controller -> Model & View
```
