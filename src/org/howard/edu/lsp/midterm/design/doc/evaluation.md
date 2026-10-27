CourseRegistration has a single method, registerStudent(), that does six unrelated jobs: it calculates tuition, applies a discount policy, prints output, writes to a file, sends email, and logs. 
The data fields are public and hold no behavior of their own. This causes several design problems.

1. The class does not capture one key abstraction.
    Riel’s heuristic is that a class should capture one and only one key abstraction. The class represents a registration, 
    but it also does billing (creditHours * 750.0), persistence (FileWriter), notification (the email line), and logging. 
    Because these concerns are in one method, a change to any one of them means editing and retesting the same code. 
    For example, changing the discount rule risks breaking file writing.

   2. It behaves like a god class.
   Riel warns against god classes, where one class controls all the work and other classes are just data holders. 
   Here registerStudent() performs every step of the process itself, and no other class takes part. 
   Riel recommends distributing intelligence across several collaborating classes, such as a tuition calculator, a registration repository, and a notifier. 
   This hurts extensibility: replacing the file with a database, or the print statement with real email, requires modifying this class instead of adding a new implementation.

3. All data is public.
   Riel’s heuristic is that a class’s data should be private, and that users should depend only on its public interface. 
   studentId, email, and creditHours are public, so any code can set creditHours to -5 or email to null with no validation. 
   A negative value would produce negative tuition, and a null email would break the notification step. 
   This is a correctness problem, and it also means any code that uses these fields directly would break if the internal representation changed.

4. Related data and behavior are not kept together, and unrelated behavior is not separated.
   Riel says to keep related data and behavior in one place and to spin off nonrelated information into another class.
   The tuition rule uses only creditHours, yet it sits in a registration method mixed with file and email code that uses different fields (studentId, email). 
   This is “noncommunicating behavior”: parts of the class that use separate subsets of the data and so belong in separate classes. 
   It also makes unit testing hard, because you can’t test the tuition calculation without triggering file I/O and console output.

Additional correctness risks:

Money is stored as a double, which can cause rounding errors.
The values 750.0, 12, and 0.90 are hard-coded in the method.
The catch block swallows the exception, so a failed save is only printed and the registration still appears successful.
The writer isn’t closed if write throws.

Conclusion: The class should be split into classes that each have one responsibility (registration data, tuition calculation, storage, notification), with private fields and a clear public interface. This would make the code easier to maintain, extend, and test