Task Tracker CLI (Java)
Task Tracker is a simple Command Line Interface (CLI) application built in Java to help you manage your to-do list. It allows you to create, update, delete, and track the status of your tasks directly through the console, using Java's Scanner for user input and Gson for JSON serialization.

📌 Features
- Add new tasks
- Update task descriptions
- Delete tasks
- Mark tasks as in progress or done
- List all tasks
- Filter tasks by status: todo, in-progress, done

🛠 Technologies Used
- Java (JDK 17 or later recommended)
- Gson – for JSON serialization/deserialization
- Scanner – for reading user input via console
- No external frameworks used (except Gson)

📂 Task Structure
Each task in the JSON file contains the following properties:

{
  "id": 1,
  "description": "Buy groceries",
  "status": "todo", // possible values: todo, in-progress, done
  "createdAt": "2025-06-04T12:00:00",
  "updatedAt": "2025-06-04T12:30:00"
}

💻 How to Use
▶️ Running the Application
Clone the repository:

git clone https://github.com/carloseduardo-alves/TaskTracker.git
cd TaskTracker
Open the project in Eclipse (or any IDE that supports Java)

Run the main class (e.g., TaskTracker.java)

Use the console to interact with the app, you'll see a menu like:
--- Task Tracker ---
1. Add Task
2. Update Task
3. Delete Task
4. Mark Task In Progress
5. Mark Task Done
6. List All Tasks
7. List Tasks by Status
0. Exit
Choose an option:
Input your option number and follow the prompts.

📁 JSON File
All tasks are saved in a file called tasks.json

The file is created automatically in the project root if it does not exist

🧪 Error Handling
Invalid IDs are handled gracefully

Input mismatches and missing data are caught with clear console messages

Prevents duplicate IDs and corrupted JSON

🧩 What I Learned
✔ Working with Java I/O and file handling
✔ Using Gson to serialize and deserialize complex objects
✔ Building a simple, interactive CLI using Scanner
✔ Implementing clean logic for task management
✔ Organizing a Java application with good coding practices

🚀 Future Improvements
Add task priorities and due dates

Sort tasks by creation or status

Use JavaFX or Swing for a GUI version

Add search functionality

Unit testing with JUnit

📄 License
This project is licensed under the MIT License.
