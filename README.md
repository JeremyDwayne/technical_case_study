Case Study for Target Engineering

1. myRetail API
  - First time using Java Spring, my implementation of the API is rather poor.
  - To see a better example of my ability to work with API's see the project
    [OTN_Dashboard](https://github.com/JeremyDwayne/OTN_Dashboard) which
    utilizes a rails 5.1 API backend which serves its Angular 5 frontend.
  - Start up the mongodb daemon with mongod --dbpath ./myRetail/data/db
  - Here is an example POST curl to create a product. You can also do GET, PUT,
    PATCH, DELETE commands on these objects.
  ```
  curl -i -X POST -H "Content-Type:application/json" -d "{ \"value\" : \"25.00\", \"currencyCode\" : \"USD\", \"name\" : \"Harry Potter\" }" http://localhost:8080/products/
  ```

2. Barren Land Analysis
  - After closer inspection, I realized I should be using a breadth first search
    to calculate connected fertile land. My implementation is very inefficient and
    simply calculates the total fertile land not individually sectioned land.
  - Also, I re-read the instructions and noticed I only needed to do one of
    these assignments, and decided to put this one on pause to work on the
    myRetail API further.
