# Case Study for Target Engineering

### Barren Land Analysis
- Written using Java 10, but I believe most features are Java 8 compatible
- Compile and run the application
  ```
  cd landanalysis
  javac LandAnalysis.java
  java LandAnalysis
  ```
- Enter rectangles of barren land on prompt using the following format:
  * `{"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275
    547"}`
  * curly braces and commas are optional, but coordinates must be between double
    quotes and space seperated in (x1 y1 x2 y2) ordering
- Utilizes a BFS/Flood Fill/Forest Fire algorithm to detect fertile land
- Probably can be optimized

### myRetail API
- Not finished, decided to focus on other problem as I only
 needed to do one
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

