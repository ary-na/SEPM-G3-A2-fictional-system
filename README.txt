
    Cinco-system

    ---------------------------------------------------------------------------
    Software Engineering Project Management - Group 3 - Assignment 2 repository
    ---------------------------------------------------------------------------

    ----------
    How to Run
    ----------

    ** Java 17.0.2 or later Required **

    Method 1: Compile java files and run the program from CLI.

    Method 2: Import the project to Eclipse and run the program from the IDE.

	    2.1. To import an existing project to Eclipse, click on "File" > "Import"
	    2.2. Eclipse brings the import wizard window
	    2.3. Click on "General" > "Existing Project into Workspace"
	    2.4. Import project window will appear
	    2.5. Click the "browse" button and find the project
	    2.6. Click on "open" to add the project to the project import window
	    2.7. From the Projects window, select the project and click "finish"
	    2.8. Eclipse will import the project
	        2.8.1. To run the application, navigate to "main" > "java" > "com" > "sepmg3fs" > "main"
	        2.8.2. Click on the green play/run button

	-------------------------
	Main User Interface Guide
	-------------------------

	1. Main User Interface

            -----------------------------------------------------------------
            Welcome to Cinco System

            [1] Login
            [2] Create account
            [3] Reset Password
            [4] Exit

            Select an option:
            -----------------------------------------------------------------

        1.1. To log in, enter the number "1" and press enter/return on your keyboard
        1.2. To create an account, enter the number "2" and press enter/return on your keyboard
        1.3. To reset an existing account's password, enter the number "3" and press enter/return on your keyboard
        1.4. To exit the program, enter the number "4" and press enter/return on your keyboard

    2. Login User Interface

            -----------------------------------------------------------------
            Select an option: 1
            Enter your email address: example@example.com
            Enter your password: Test1234567890123456
            -----------------------------------------------------------------

        2.1. Enter your email address and press enter/return on your keyboard
        2.2. Enter your password and press enter/return on your keyboard
        2.3. If the entered credentials are correct, you will log in to the application otherwise, the following error message will display to the console:

            -----------------------------------------------------------------
            Incorrect username or email address, please try again (Attempt 1 of 3)
            Enter your email address:
            -----------------------------------------------------------------

        2.4. You will have three attempts to log in before the app navigates back to the main menu
        2.5. Existing Account details in the system:
            2.5.1. Staff (for testing purposes only)
                2.5.1.1. Email: aa - Password: aa
                2.5.1.2. Email: bb - Password: bb
            2.5.2. Technicians
                2.5.2.1. Level 1
                    2.5.2.1.1. Email: harry.styles@cinco.com - Password: Harry12345678
                    2.5.2.1.2. Email: niall.horan@cinco.com - Password: Niall09876543
                    2.5.2.1.3. Email: liam.payne@cinco.com - Password: Liam09871234
                2.5.2.2. Level 2
                    2.5.2.2.1. Email: louis.tomlinson@cinco.com - Password: Louis44554455
                    2.5.2.2.2. Email: zayn.malik@cinco.com - Password: Zayn11221122
            2.5.3. Admin
                2.5.3.1. Email: admin - Password: admin

    3. Create Account User Interface

            -----------------------------------------------------------------
            Select an option: 2
            Enter your email address: example@example.com
            Enter your full name: test
            Enter your phone number: 0412345678
            Enter a password: Test1234567890123456

            Account created! You may now log in.
            -----------------------------------------------------------------

        3.1. Enter your email address and press enter/return on your keyboard
            3.1.1. If the entered email already exists in the system, the following error message will display to the console:

            -----------------------------------------------------------------
            Select an option: 2
            Enter your email address: example@example.com

            ** error ** Email address already exists, try again!
            -----------------------------------------------------------------

        3.2. Enter your full name and press enter/return on your keyboard
        3.3. Enter your phone number and press enter/return on your keyboard
            3.3.1. Phone number must be 10 digits, entering an invalid phone number will display the following error message to the console:

            -----------------------------------------------------------------
            Enter your phone number: 123

            ** error ** Phone number must be 10 digits, try again!
            -----------------------------------------------------------------

        3.4. Enter a password and press enter/return on your keyboard
            3.4.1. Password must contain a mix of uppercase and lowercase alphanumeric characters of minimum length 20, entering an invalid password will display the following error message to the console:

            -----------------------------------------------------------------
            Enter a password: sdf

            ** error ** Password must contain a mix of uppercase and lowercase alphanumeric characters of minimum length 20, try again!
            -----------------------------------------------------------------

    4. Reset Password User Interface

            -----------------------------------------------------------------
            Select an option: 3
            Please enter all details pertinent to your account to verify your identity (Case Sensitive).
            Enter your Email Address: example@example.com
            Enter a password: Test123456789012Test
            -----------------------------------------------------------------

        4.1. Enter your email address and press enter/return on your keyboard
            4.1.1. If email does not exist, the following error message will display to the console:

            -----------------------------------------------------------------
            Enter your Email Address: abc

            ** error ** The email address does not match, try again!
            -----------------------------------------------------------------

        4.2. Enter a new password and press enter/return on your keyboard to change your password
            4.2.1. Password must be valid, entering an invalid password will display the following error message to the console:

            -----------------------------------------------------------------
            Enter a password: sdfgsd

            ** error ** Password must contain a mix of uppercase and lowercase alphanumeric characters of min length 20, try again!
            -----------------------------------------------------------------

    5. Exit User Interface

            -----------------------------------------------------------------
            Select an option: 4
            Program ending!
            -----------------------------------------------------------------

	--------------------------
	Staff User Interface Guide
	--------------------------

	1. Staff User Interface

	        -----------------------------------------------------------------
	        ***************************Your Open Tickets**************************************

            Welcome to Cinco System

            [1] Create ticket
            [2] Logout

            Select an option:
	        -----------------------------------------------------------------

	    1.1. The user interface displays the open tickets for the account
	    1.2. To create a new ticket, enter the number "1" and press enter/return on your keyboard
	    1.3. To log out, enter the number "2" and press enter/return on your keyboard

	2. Create Ticket User Interface

	        -----------------------------------------------------------------
	        Select an option: 1
            Please enter your IT issue: Test
            Please enter your issue severity (low, medium or high): Low
            Ticket Created
            ***************************Your Open Tickets**************************************
            1 Description: Test Severity: LOW Status: OPEN Technician Asigned: Harry Styles
            ---------------------------------------------------------------------------------
	        -----------------------------------------------------------------

	    2.1. Enter your IT issue and press enter/return on your keyboard
	    2.2. Enter your IT issue severity and press enter/return on your keyboard
	        2.2.1. Severity must be low, medium or high case-insensitive, otherwise the following error message will display to the console:

	        -----------------------------------------------------------------
	        Please enter your issue severity (low, medium or high): test

            ** error ** Invalid severity, please type: low, medium or high
	        -----------------------------------------------------------------

	3. Log out User Interface

	        -----------------------------------------------------------------
	        Select an option: 2
            Program logged-out!
	        -----------------------------------------------------------------

	-------------------------------
	Technician User Interface Guide
	-------------------------------

    1. Technician User Interface

            -----------------------------------------------------------------
            Welcome to Cinco System

            [1] View All Tickets
            [2] Logout

            Select an option:
            -----------------------------------------------------------------

        1.1. To view all tickets, enter the number "1" and press enter/return on your keyboard
        1.2. To log out, enter the number "2" and press enter/return on your keyboard

    2. View All Tickets User Interface

            -----------------------------------------------------------------
            Select an option: 1
            [1] Staff Full Name: aa Description: sdf Severity: LOW Status: OPEN Technician Asigned: Louis Tomlinson
            [2] Staff Full Name: aa Description: sd Severity: HIGH Status: OPEN Technician Asigned: Harry Styles
            [3] Staff Full Name: aa Description: sdf Severity: LOW Status: OPEN Technician Asigned: Niall Horan
            [4] Staff Full Name: aa Description: dfg Severity: LOW Status: OPEN Technician Asigned: Liam Payne
            Type ticket ID or exit:
            -----------------------------------------------------------------

        2.1. To select a ticket, enter the ticket ID (e.g. 1)

    3. Ticket Menu User Interface

            -----------------------------------------------------------------
            What would you like to do with this ticket

            [1] Change Severity
            [2] Change Status
            [3] Back to last Menu

            Select an option:
            -----------------------------------------------------------------

        3.1. To change the severity of a ticket, enter the number "1" and press enter/return on your keyboard
        3.2. To change the status of a ticket, enter the number "2" and press enter/return on your keyboard
        3.2. To go back to the previous menu, enter the number "3" and press enter/return on your keyboard

    4. Change Severity Menu User Interface

            -----------------------------------------------------------------
            Please select the new severity level for the chosen ticket

            [1] Low
            [2] Medium
            [3] High

            Select an option:
            -----------------------------------------------------------------

        4.1. To select the severity of low, enter the number "1" and press enter/return on your keyboard
        4.2. To select the severity of medium, enter the number "2" and press enter/return on your keyboard
        4.3. To select the severity of high, enter the number "3" and press enter/return on your keyboard
        4.4. Changing the severity will display the following confirmation message to the console:

            -----------------------------------------------------------------
            Select an option: 2
            Severity changed on ticket 2 to the severity of: MEDIUM
            -----------------------------------------------------------------

    5. Change Status Menu User Interface

            -----------------------------------------------------------------
            Please select the new status for the chosen ticket

            [1] Open
            [2] Closed and Resolved
            [3] Closed and Unresolved
            [4] Archived

            Select an option:
            -----------------------------------------------------------------

        5.1. To open a ticket enter the number "1" and press enter/return on your keyboard
        5.2. To close a resolved ticket, enter the number "2" and press enter/return on your keyboard
        5.3. To close an unresolved ticket, enter the number "3" and press enter/return on your keyboard
        5.4. To force archive a ticket, enter the number "4" and press enter/return on your keyboard
            5.4.1. Archiving a ticket will happen automatically after a ticket is closed
            5.4.2. The archiving option is present for testing purposes only.
        5.5. Changing the status will display the following confirmation message to the console:

            -----------------------------------------------------------------
            Select an option: 2
            Status changed on ticket 1 to the status of: CLOSED_AND_RESOLVED
            -----------------------------------------------------------------

    6. Log out User Interface

            -----------------------------------------------------------------
            Select an option: 2
            Program logged-out!
            -----------------------------------------------------------------

    --------------------------
    Admin User Interface Guide
    --------------------------

    1. Admin User Interface

            -----------------------------------------------------------------
            Welcome to Cinco System

            [1] Produce Report
            [2] Logout

            Select an option:
            -----------------------------------------------------------------

        1.1. To produce a report enter the number "1" and press enter/return on your keyboard
        1.1. To log out, enter the number "2" and press enter/return on your keyboard

    2. Produce Report User Interface

            -----------------------------------------------------------------
            Select an option: 1
            Please enter start date of your report (dd/mm/yyyy): 20/10/2022
            Please enter end date of your report (dd/mm/yyyy): 22/10/2022
            Report of : 2 days

            Report

            [1] Submitted By: aa Description: Test Severity: LOW Status: OPEN Technicians who have been assigned ticket null, Niall Horan
            [2] Submitted By: aa Description: Test2 Severity: HIGH Status: OPEN Technicians who have been assigned ticket null, Niall Horan, Louis Tomlinson
            [3] Submitted By: bb Description: Test3 Severity: HIGH Status: OPEN Technicians who have been assigned ticket null, Niall Horan, Louis Tomlinson, Zayn Malik
            [4] Submitted By: bb Description: Test4 Severity: MEDIUM Status: OPEN Technicians who have been assigned ticket null, Niall Horan, Louis Tomlinson, Zayn Malik, Niall Horan
            Total tickets submitted: 4
            Total open tickets: 4
            Total closed tickets 0
            -----------------------------------------------------------------

    3. Log out User Interface

            -----------------------------------------------------------------
            Select an option: 2
            Program logged-out!
            -----------------------------------------------------------------