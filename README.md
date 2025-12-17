A JavaFX-based Data Structure Visualizer designed to help learners understand core data structures through interactive visualizations and operations.

This project focuses on clarity, simplicity, and hands-on learning for Arrays, Stacks, Queues, and Linked Lists.

**Features**
Real-time Visualization: Watch how data moves and changes within structures.

Supported Structures:

Arrays: Dynamic visualization of indexing and sequential access.

Stacks: "Last-In, First-Out" (LIFO) operations (Push/Pop).

Queues: "First-In, First-Out" (FIFO) logic visualization.

Linked Lists: Visualizing nodes and pointer manipulations.

Modern UI: Built with JavaFX and styled with CSS for a clean, user-friendly experience.

Interactive Controls: Manually trigger operations to see step-by-step changes.

**Project Structure**

DSA-Learner-Application
│
├── src/
│   ├── application/
│   │   ├── Main.java
│   │   ├── Array.java
│   │   ├── Stack.java
│   │   ├── Queue.java
│   │   ├── LinkedList.java
│   │   ├── ArrayWindow.java
│   │   ├── StackWindow.java
│   │   ├── QueueWindow.java
│   │   └── LinkedListWindow.java
│   │   ├── QueueController.java
│   │   └── LinkedListController.java
│   │   └── ArrayController.java
│   │   └── StackController.java
│   │   └── icons
│
├── application.css
├── module-info.java
└── README.md

**Installation & Setup**
Prerequisites:

Java JDK 21 or higher installed.

JavaFX SDK Configurations in module file:

- javafx.controls.jar
- javafx.graphics.jar
- javafx.fxml.jar
- javafx.base.jar

**Code(module-info.java)**
```
module project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base; 
    requires java.desktop; 

    opens application to javafx.fxml; 
    exports application;
}
```

Clone the Repository:
```
git clone https://github.com/Siddharth3271/DsaLearner.git
```

**Further Enhancements**
- Tree and Graph Visualizations
- Detailed Notes for each data structure
