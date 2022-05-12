# Book Hub
## CLI UI Design
### Client menu
```
Book sharing app client-0.9
R: Register         L: Login        Q: Quit client
Enter your choice: L

Username: udayraj.bal@perennialsys.com
Password: **************

Connected to localhost:4040
Book sharing app server-1.3
```
### Dashboard
Server should send an object which clients should display as a dashboard 
```
Welcome Udayraj Bal
----------------------------------------------------------------
                             DASHBOARD                           
----------------------------------------------------------------
Waiting list notification:
----------------------------------------------------------------
"7 habits of successful people" is now available.
Call Megha (7890589456) to know how to collect the book.

Your Summary:
----------------------------------------------------------------
You shared: 5 books
Taken: 3 Available: 2

1 Overdue:
"Terrace Gardens-101" due on: 20-Apr-2022, borrower: Neesha O.

You borrowed: 2 books
1. "Python for kids" due on: 30-Apr-2022
2. "You don't know JavaScript" due on: 15-May-2022
----------------------------------------------------------------
```
### Main menu
List of options and choices should be sent from server and rendered by the clients as below:
```
================================================================
MENU
================================================================
A: Add a Book         D: Dashboard         O: Overdue reminder
R: Return a book      S: Search books      Q: Quit the app

```
#### Add a book
```
Enter your choice: A
Enter the book information (Fields marked with * are mandatory)
Title* : Be a Triangle
Authors* (comma separated names): Lilly Singh
ISBN:
Keywords (comma separated keywords): Life, peace, self-awareness, mindset
Description:
Book added, you have total 6 shared books
```
#### Overdue reminder
```
Enter your choice: O
This is an notification separate from the automatic notification sent by the application. Send? (Y/N) Y

Reminder sent to online user Neesha O. Send a buzz too? (y/n): n
```
#### Search and request a book
```
Enter your choice: S

A: By author      K: By keyword      T: By title
Enter search criteria: T

Enter title (at-least 3 characters): Microservices

4 found ... showing first 3 available books
#  Book title                           Owner
================================================================= 
1. Node microservices                   Amit
2. Microservices with Spring boot       Sumeet
3. Microservices design patterns        Vidya

1-3: Request the book       N: Next books (taken)       Q: Main menu
Enter your choice: 2
Request sent ...
Contact Sumeet (8756798790) to know how to collect the book.
```
#### Join a waiting list for a book
```
1-3: Request the book       N: Next books (taken)       Q: Main menu
Enter your choice: N

#  Book title                           Owner       Wait time
================================================================= 
1. Spring Microservices with Docker     Ganesh      9 days

1: Join the book's waiting list    Q: Main menu
Enter your choice: 1

Request added to the waiting list. You will get reminder over your email to collect the book once it is available.

```
### Log off
```
Enter your choice: Q

Logging off ...
You are now logged out off Book sharing server.

Book sharing app client-0.9
R: Register         L: Login        Q: Quit client
Enter your choice: Q

Bye Udayraj, happy reading ...
```