## API Demo Challange

#### Project Setup
1. Clone this project.
2. Setup the project in your IDE.
3. From command line run mvn clean install -U -DskipTests
5. Make sure you can run the DemoTest

#### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity


#### Excercise
1. Review the spec in the root directory, PizzaAPIReferenceDoc.  API endpoints for this excercise can be found here
   https://my-json-server.typicode.com/sa2225/demo/
2. In the Read me file, write up all of the test cases you think are necessary to test the endpoints defined in the provided spec.
3. Code up a few examples of 
  - order get call including response validation
  - order post call
4. When complete please check your code into a public git repo

#### Test Cases
Toppings
 TC1. Get all toppings by sending get request and verify the toppings with database 
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/toppings
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with Database
 
 
  TC1_1. Get specific toppings by sending get request with valid topping id and verify the toppings with database 
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/toppings/2
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with Database
 
  TC1_1.2. Get specific toppings by sending get request with invalid topping id 
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/toppings/22
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with error message " No Toppings with this id"
 
 TC2. Add new Topping using post Request with new topping id
 Step 1 : Send post request Post https://my-json-server.typicode.com/sa2225/demo/toppings with below payload 
 {
"id": 12
}
 Step2 : Verify that status code is 204.
 Step 3 : Verify Json response Schema
 Step 4 : Validate Json Response with Database 

 
TC3. Add new Topping using post Request with existing topping id
 Step 1 : Send post request Post https://my-json-server.typicode.com/sa2225/demo/toppings with below payload 
 {
"id": 1
}
 Step2 : Verify that status code is 405.
 Step 3 : Verify Json response description and it should display Duplicate Topping. 
 
 TC4 : Delete a valid Topping using delete Request
  Step 1 : Send delete request delete https://my-json-server.typicode.com/sa2225/demo/toppings/2 
 Step2 : Verify that status code is 204.
 Step 3 : Verify Json response should be blank.
 
  TC5 : Delete a invalid Topping using delete Request
  Step 1 : Send delete request delete https://my-json-server.typicode.com/sa2225/demo/toppings/4
 Step2 : Verify that status code is 500.
 
 
 Pizzas
 
 TC6: get all pizza's using get request
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/Pizzas
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with Database
 
  TC7: get specific pizza's using get request with valid pizza id
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/Pizzas/1
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with Database
 
 TC8: get specific pizza's using get request with invalid pizza id
 Step 1 : Send get request Get https://my-json-server.typicode.com/sa2225/demo/Pizzas/25
 Step2 : Verify that status code is 200.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with error message "There is no pizza with this id"
 
 
 Create Order for Pizza
 
 TC9 : Create a new Order using post request with valid payload
 
  Step 1 : Send post request post https://my-json-server.typicode.com/sa2225/demo/Orders with below json payload
  {
  "items": [
{
"pizza": "Medium 8 Slices - 2 toppings",
"toppings": [
"Mushrooms",
"Extra cheese"
]
}
]
}
 Step2 : Verify that status code is 204.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with order id is created or not
 
 
 TC10 : Create a new Order using post request with invalid toppings 
 
  Step 1 : Send post request post https://my-json-server.typicode.com/sa2225/demo/Orders with below json payload
  {
  "items": [
{
"pizza": "Medium 8 Slices - 2 toppings",
"toppings": [
"Mushroomsssd",
"Extra cheesesdfdf"
]
}
]
}
 Step2 : Verify that status code is 406.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with  error message "Incorrect number of toppings"
 
 
TC11 : Create a new Order using post request with invalid Pizza 
 
  Step 1 : Send post request post https://my-json-server.typicode.com/sa2225/demo/Orders with below json payload
  {
  "items": [
{
"pizza": "Medium 20 Slices - 2 toppings",
"toppings": [
"Mushrooms",
"Extra cheeses"
]
}
]
}
 Step2 : Verify that status code is 407.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with  error message "Invalid pizza"
 
 
 TC12 : Create a new Order using post request without Pizza name
 
  Step 1 : Send post request post https://my-json-server.typicode.com/sa2225/demo/Orders with below json payload
  {
  "items": [
{
"pizza": "",
"toppings": [
"Mushrooms",
"Extra cheeses"
]
}
]
}
 Step2 : Verify that status code is 408.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with  error message "Pizza not specified"
 
 
 
 
  TC13: Create a new Order using post request without toppings
 
  Step 1 : Send post request post https://my-json-server.typicode.com/sa2225/demo/Orders with below json payload
  {
  "items": [
{
"pizza": "Medium 8 Slices - 2 toppings",
"toppings": []
}
]
}
 Step2 : Verify that status code is 409.
 Step 3 : Verify Json Schema
 Step 4 : Validate Json Response with  error message "Toppings not specified"
 
 
 
 
 
 
 
 
 
 
 
 
 
