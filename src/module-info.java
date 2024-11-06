/**
 * Module {@code se1.play} demonstrates Java project setup, sourcing the project
<<<<<<< HEAD
 * and project build in the <i>Software Engineering-I</i> course.
 * 
 * The module's main package {@link application} has a simple {@link Runtime}
 * that scans for classes that implement the {@link application.Runtime.Runnable}
 * interface, selects the class with highest {@link application.Runtime.Run}
 * priority, creates an instance of the class and invokes the
 * {@code run(properties, args)} - method to start the application.
 *  
=======
 * and the project build process for the <i>Software Engineering-I</i> course.
 * 
 * The module's main {@link application} package has a simple {@link Runtime} that
 * scans for classes that are assignable from interfaces such as from the
 * {@link application.Runtime.Runnable} interface. It selects the class with the
 * highest {@link application.Runtime.Bean} priority, creates an instance of that
 * class and invokes the {@code run(properties, args)} - method to start the
 * application.
 * 
>>>>>>> upstream/main
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */
module se1.play {
<<<<<<< HEAD
    opens application;
    exports application;                // export application package to enable Javadoc
    exports numbers;                    // export numbers package to enable Javadoc

    requires org.junit.jupiter.api;         // JUnit-5 module required for testing
    requires transitive org.slf4j;          // slf4j/log4j2 logging modules
=======
    opens application;     // open: package is accessible by JavaVM at runtime
    exports application;   // export: package is accessible to compile other modules

    requires org.junit.jupiter.api;     // JUnit-5 module for JUnit testing
    requires transitive org.slf4j;      // slf4j/log4j2 logging modules
>>>>>>> upstream/main
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
}