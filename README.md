# Task Tracker CLI (Java)
Task Tracker is a simple Command Line Interface (CLI) application built in Java to help you manage your to-do list. It allows you to create, update, delete, and track the status of your tasks directly through the console, using Java's Scanner for user input and Gson for JSON serialization.

### Requirements
Before running this project, make sure you have the following tools installed:
- Java JDK 17+ – required to compile and run the application
- Git – to clone the repository (optional, can also download manually)
- An IDE that supports Java (e.g., Eclipse, IntelliJ IDEA, VSCode with Java Extension Pack)
- Internet connection to download the Gson library (if not already available)

### Technologies Used
- Java (JDK 17 or later recommended)
- Gson – for JSON serialization/deserialization
- Scanner – for reading user input via console
- No external frameworks used (except Gson)

### Features
- Add new tasks
- Update task descriptions
- Delete tasks
- Mark tasks as in progress or done
- List all tasks
- Filter tasks by status: todo, in-progress, done

### How to Install and Run
1. Clone the repository:
   ``` git clone https://github.com/carloseduardo-alves/TaskTracker.git ```
   ``` cd TaskTracker ```
2. Open the project in your IDE (e.g., Eclipse)
3. Add the Gson library:
    ``` gson-<2.13.1>.jar ```
- Right-click the project > Build Path > Configure Build Path
- Go to the Libraries tab > Add External JARs... > Select the downloaded Gson .jar file
4. Run the project:
- Locate the TaskTracker.java (or the main class)
- Right-click > Run As > Java Application
- Use the console to follow the menu and manage your tasks interactively

### Task Structure
Each task in the JSON file contains the following properties:

{
  "id": 1,
  "description": "Buy groceries",
  "status": "todo", // possible values: todo, in-progress, done
  "createdAt": "2025-06-04T12:00:00",
  "updatedAt": "2025-06-04T12:30:00"
}

### What I Learned
- Working with Java I/O and file handling
- Using Gson to serialize and deserialize complex objects
- Building a simple, interactive CLI using Scanner
- Implementing clean logic for task management
- Organizing a Java application with good coding practices

## License
This project is licensed under the MIT License.
