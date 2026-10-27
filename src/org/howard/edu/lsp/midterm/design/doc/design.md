Class: Student
Responsibilities:
Know its student ID, name, and email
Validate its own data (for example, non-null email)

Collaborators: Registration

Class: Registration
Responsibilities:
Know which student is registered for which course and how many credit hours
Validate that credit hours are positive
Know its calculated tuition once set

Collaborators: Student, Course

Class: Course
Responsibilities:
Know its course code and credit hours

Collaborators: Registration

Class: TuitionCalculator
Responsibilities:
Calculate tuition from credit hours
Apply the heavy-load discount rule
Hold the rate, discount threshold, and discount percentage as named constants or configuration

Collaborators: Registration

Class: RegistrationRepository (interface), implemented by FileRegistrationRepository
Responsibilities:
Save a registration (the file version appends to registrations.txt)
Handle file closing and report failures to the caller

Collaborators: Registration

Class: NotificationService (interface), implemented by EmailNotificationService
Responsibilities:
Send a registration confirmation to a student

Collaborators: Student, Registration

Class: RegistrationLogger
Responsibilities:
Record that a registration was processed, with a timestamp

Collaborators: Registration

Class: RegistrationService
Responsibilities:
Coordinate the registration workflow: create the registration, request tuition, save, notify, log
Decide what happens if a step fails (for example, do not send confirmation if saving failed)
Contain no tuition, file, or email logic itself

Collaborators: Registration, TuitionCalculator, RegistrationRepository, NotificationService, RegistrationLogger