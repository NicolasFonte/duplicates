## Code build, run.

  - mvn clean install
  - mvn spring-boot:run
  
  
## Requirements
  1. Scheduled fetch
    Check ScheduledFetcher class. Use application.yml for configuring the seconds.
    Storing in a static string variable on DuplicatesCache
    
  2. HTTP / REST interface
    Check Duplicates Controller. It fetches from same Cache. 
    After run check API in http://localhost:8083
    
  3. Compression  
    DuplicatesCache class use a static utility RLEncoder which 
    encodes de 'data' variable using Run Length algorithm.

