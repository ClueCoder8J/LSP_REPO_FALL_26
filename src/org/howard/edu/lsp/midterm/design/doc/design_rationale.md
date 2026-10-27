The Part 2 design already isolates storage and notification behind interfaces (RegistrationRepository and NotificationService), 
so both changes are handled by adding new implementations. 
RegistrationService and TuitionCalculator do not change. 
The one new problem is deciding which implementation to use, and I would give that responsibility to a new class.