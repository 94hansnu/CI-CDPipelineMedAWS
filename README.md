# CI/CD Pipeline with AWS
### Description
##### The Todo Spring Boot application integrates an automated build-test-deploy process using AWS and Github Action. This process allows for faster development cycles and a smooth deployment strategy for the application. The application has full CRUD functionality for creating, reading, updating and deleting (Create, Read, Update, Delete) Todo tasks.
    Github

All changes, including commits to the master branch and pull requests, are managed through GitHub. I leverage GitHub Actions to automate the CI/CD process. I have defined different workflows in my workflow.yml file to build and test the application.

I've defined a build job and a test job in the GitHub Actions workflow. These jobs run every time a commit is made to the master branch or a pull request is opened. The build job compiles the source code and creates an artifact executable. The test job runs all automated tests to ensure the quality of the code.

    AWS (Amazon Web Service)
AWS is used to automate my deployment process and to host my application in the cloud.

I use Elastic Beanstalk to automate the deployment process and manage the infrastructure of my application. Elastic Beanstalk allows me to easily deploy and scale my application without having to manage the underlying infrastructure. 

For the build step of my CI/CD process, I use AWS CodeBuild. CodeBuild allows me to create a custom build environment and execute build steps such as compiling, packaging, and creating executable artifacts.

I've set up a CodePipeline that monitors my GitHub repo for changes. When a new commit is detected, CodePipeline initiates a series of actions to build, test, and deploy my application.

### Prerequisites
##### Before you begin, ensure you have the following installed:
* Java 17
* Maven
* MongoDB Compass https://www.mongodb.com/products/tools/compass
* Postman https://www.postman.com/downloads/

### Installation 
1. Clone the repository https://github.com/94hansnu/CI-CDPipelineMedAWS
2. Build the project
3. The project is built automatically and includes all dependencies.
4. In case of failure, build the project manually by right-clicking on the project's root folder in the project tree and selecting "Rebuild"

### Database Configuration
To configure the database, make sure you have MongoDB Compass downloaded on your computer. Follow these steps:

1. Use My Application Configuration: If you want to use my credentials in application.properties, you can skip this step. Otherwise:


2. Create Your Own Cluster on MongoDB Atlas:
   * Visit MongoDB Atlas and log in to your account.
   * Create a new project if you don't already have one.
   * Go to "Clusters" and create a new cluster.
   * Once your cluster is created, click on "Connect" and select "compass" then "I have MongoDB Compass installed". 
   * Copy the URI string that appears. This is your connection string to the database.


3. Connect with MongoDB Compass:
    * Open MongoDB Compass on your computer.
    * Select "Connect to".
    * Paste the copied URI string from MongoDB Atlas (You need to replace the password to your password).
    * Click "Connect" to connect to the database.

### Run the Application
1. Run the application with maven
2. http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/ (This link is if you are using my database)
### API Endpoints
I have client (console) where you can run the different endpoints (CRUDs),


If you want to update or delete a Todo, you can use the console or in Postman and then view it in the browser or DB


To test the API with Postman, use the link to download postman.

##### Welcome Controller:
* Endpoint : ''
   * Method: 'GET'
   * Postman: http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/
      * Type: none
   * Description: Welcome Message

##### Todo Controller
* Endpoint : '/todos'
   * Method: 'POST'
   * Postman: http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/todos
      * Type: JSON
   * Description: Adding a todo
* Endpoint : '/todos'
   * Method: 'GET'
   * Postman:  http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/todos
      * Type: None
   * Description: Get all todos
* Endpoint : '/todos/{id}'
   * Method: 'GET'
   * Postman: http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/todos/{id}
      * Type: None
   * Description: Get todo by id
* Endpoint : '/todos/{id}'
   * Method: 'PUT'
   * Postman: http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/todos/{id}
      * Type: JSON
   * Description: Updated a todo by id
* Endpoint : '/todos/{id}'
   * Method: 'DELETE'
   * Postman: http://awstask-env.eba-pjwid6cd.eu-north-1.elasticbeanstalk.com/todos/{id}
      * Type: None
   * Description: Delete a todo by id





