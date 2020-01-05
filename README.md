# tennisleague
Tennis league website for amateur players in Wroclaw area. 

The Web App has been deployed to Heroku cloud and is available for viewing and testing under the following url: https://wroclawskaligatenisowa.herokuapp.com
Please familiarize yourself with the app functionalities and proposed testing plan prior to entering the website.

## Introduction

The idea for the Tennis League project is to allow amateur players from Wroclaw play friendly, competitive tennis.
 
Singles players will be divided by the administrator into several groups (depending on the number of candidates). 
Once it's done, they will have to arrange matches between them and attempt to play against each other within 7 weeks time.
All results have to be reported through the website. The main page will contain an overall ranking.

Main focus has been put on building backend functionalities, however a bit of time was spent on frontend as well to make it more interesting for a potential user.

## Technologies

**Backend:** Java, Spring, Hibernate

**Frontend:** HTML, CSS, Bootstrap, Bulma, JavaScript

## Current Status

In progress. Approximately 80% of work has been done to date (5th January 2020).
The app has been deployed to heroku cloud on the 5th of January 2020.

**Project completion timeline**

Planned for completion by the end of January 2020.

## Plans of the future

## Scope of functionalities

The main page (index.html) allows a potential user to:
* Read a description of the league: Click "O LIDZE" ("ABOUT THE LEAGUE") **NOT YET AVAILABLE**, 
* Check the ranking of a current round: Click "WYNIKI" ("RESULTS") - it shows groups with singles players ordered by number of points (ascending). It also contains the list of matches in each group, which have been played to date.
* Find out more about the rules of the league: Click "ZASADY" ("RULES") **NOT YET AVAILABLE**,
* Enter a registration page: Click "REJESTRACJA" ("REGISTRATION"),
* Enter a login page: Click "ZALOGUJ" ("LOG IN"").

If a user wants to join a league, he/she has to register by filling the form with following information: username, email, password (and retype) + accept terms and conditions (not yet available).

There are two user roles used in the app: USER and ADMIN. The former is a tennis player willing to play in the league, the latter is a person responsible for the league management.
The rights of each user role are set out below.

**User**

The user after logging in is automatically redirected to the main page (index.html). The user account can be accessed now by clicking "MOJE KONTO" ("MY ACCOUNT") in the top right corner.

The user can see his/her matches (due and already played), ranking of the group he/she is playing in and all matches in the group that have been played to date.
Once the match has been played the result has to be reported (only by one of the players), by clicking "DODAJ WYNIK" ("REPORT RESULT"). Once the result has been reported, the button will be disabled.

On the left side there is a panel with the following functionalities:
* "UZUPEŁNIJ PROFIL" - user has to provide additional information (first name, last name, telephone number, ntrp level) before joining the round. After doing that, the button changes to "EDYTUJ PROFIL" ("EDIT PROFILE"),
* "ZAPIS DO RUNDY: Name of the round" - user can join the upcoming round (the registration closes 2 days prior to start date),
* "WYCOFAJ SIE Z RUNDY" - user can withdraw from the round during its duration by clicking that button,
* "USUN KONTO" - user can delete his/her account if he/she doesn't wish to play in the league anymore **NOT YET AVAILABLE**,
* "ZGŁOS PROBLEM" - user can contact administrator with issues such as bugs on the website, problems iwth other player etc.,



