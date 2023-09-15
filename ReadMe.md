The login page at https://account.bbc.com/signin
Once logged in, that the "change your postcode" function works inside your account settings page

2 Test cases, first one comes with positive and negative
However we would not be able to create a negative test case for the second one

I tried to use as much as classes and little tools, however, as there are only 2 test cases, this is all I can show.

I would be happy to explain this little framework in the interview.

question: Please also record a few comments on any architectural decisions you would make if this would develop into a full test of the BBC website.

Answer: Cross-Browser testing: BBC is widely used in entire world and everybody uses a different broweser that's why I have added more than 1 driver in the Driver class.

Parallel testing: BBC is a huge website with lot's of functions, we are talking about at least 350 test cases, definetly would need a paralle testing, with selenium-grid

Test data: I would definetly use TestNG, data provider for all of the users in the databases, just to keep up with all users if their account is working or not, also to check.

Performance testing: I would definetly record test cases in chrome then put them onto Jmeter, as performance testing is very important.

Kind regards