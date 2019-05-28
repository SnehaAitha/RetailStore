# RetailStore

1.) Download the zip file of the project from the link https://github.com/SnehaAitha/RetailStore.git
2.) Right click the project -> Run As -> Maven Build -> Enter Goal -> spring-boot:run  to run the project.
3.) The project starts on the default port 8080.
4.) Hit the API with the URL request (http://localhost:8080/api/bill/{id}) .
// id values in the mock repository are 1,2,3,4. 
Ex : http://localhost:8080/api/bill/1
5.) The API request return the final bill amount for a bill id/order id.
6.) The mock data has 4 Users with 4 Orders each wherein each order has 3 Products each.
7.) The bill amount is calculated as the sum of the individual products ordered.
8.) The final bill amount is calculated deducting the discounted amount from the actual bill amount(discount is calculated based on the rules given in the assessment).
9.) The mock data is entered in such a way that all the test cases can be covered i.e Bill id 1 belongs to user with user id 1 where he is the employee of the store,Bill id 2 belongs to User with user id 2 where he is the affiliate,Bill id 4 belongs to user with user id 4 where he is the customer over 2 years with the store.
10.) Dicount is ommitted for grocery products.
