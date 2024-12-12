# Database Setup

## 1. Create a Database

1.1 Open **pgAdmin**.  
1.2 Select your PostgreSQL server.  
1.3 Right-click on **Databases**.  
1.4 Create a new database (just provide a name, nothing else).

## 2. Connect the Database to IntelliJ

2.1 On the right panel, click on **Database**.  
2.2 Click on the **+** sign.  
2.3 Click **Data Source**.  
2.4 Select **PostgreSQL**.  
2.5 Input the username and password for your database (if you followed the steps from 'data & AI', the username is `postgres` and the password is `Student_1234`).  
2.6 Click **Test Connection**. If successful, click **OK**.

## 3. Select the Relevant Database

3.1 While having the **Database** panel open, click on the number next to your newly created PostgreSQL database (it should be named `postgres@localhost`) and select your database.  
3.2 Then, click on the numbers next to your database and select **All Schemas**.

## 4. Bind the Database Script to the Database

4.1 Right-click on `DatabaseScript.sql` and click **Modify Run Configuration**.  
4.2 Under **Target Data Source**, click the **+** icon and select the `public` schema of your database.  
4.3 Click **Apply** and then **OK**.

## 5. Modify the Connection String

5.1 Open the `DBConnect` interface located in the `managers` package.  
5.2 You will find the connection string inside:

```java
String connectionUrl = "jdbc:postgresql://localhost:5432/castleWallCopyPersonal?user=postgres&password=Student_1234";
```

5.3 Analyze the string:

- **jdbc**: The driver being used.
- **postgresql**: The type of database.
- **://localhost**: The location of the database. For now, it runs on the localhost (this may change later).
- **:5432**: The port the database listens to for traffic. (5432 is the default, but it may differ based on your configuration. To check in pgAdmin, right-click on the server you're using (likely named `PostgreSQL 17`), select **Properties**, then go to **Connection** and check the line named **Port**.)
- **castleWallCopyPersonal**: The name of the database. Replace this part with the name you gave your database.
- **user=postgres**: The database owner name. This may vary depending on how you set up the server.
- **password=Student_1234**: The database password. This may vary depending on your setup steps.

5.4 Change the connection string values as needed.

**Note:** Before doing this step, test if you can access the database through the connection string. If successful, you can skip Step 6.

## 6. Add a JDBC Driver Dependency (if necessary)

6.0 Download the JDBC driver from [https://jdbc.postgresql.org/download/](https://jdbc.postgresql.org/download/).  
6.1 In IntelliJ, click on **File** in the top left corner and select **Project Structure**.  
6.2 On the left panel, select **Modules**.  
6.3 On the right part of the window, select **Dependencies**.  
6.4 Click the **+** icon under **Module SDK**.  
6.5 Select **JARs or Directories**.  
6.6 A new window will open. Select the downloaded JDBC driver (the `.jar` file).

Now you have a running database, and every time you run `DatabaseScript.sql`, it will refresh itself to the state defined in the script.

# GitHub Management

## 1. Clone the Repository

1.1 Run:

```bash
git clone https://github.com/Pepeeeeeeeeee/CastleWall.git
```

This clones the project.

## 2. Create Branches

2.1 Initialize Git:

```bash
git init
```

2.2 Creates a new branch and switches to it:

```bash
git switch -c name_of_branch
```

2.3 Displays all available branches (both local and remote):

```bash
git branch -a
```

2.4 Push your branch to the repository and set it as a remote branch:

```bash
git push --set-upstream origin name_of_branch
```

## 3. Push Changes to the Repository

3.1 Add any newly created files:

```bash
git add .
```

3.2 Commit your changes with a message:

```bash
git commit -m "commit message"
```

(Examples of commit messages: "Added a class", "Fixed a bug", "Changed a method".)

3.3 Push your changes to the repository:

```bash
git push
```

## 4. Create Pull Requests

4.1 Pull requests are similar to merge requests in GitLab and work very similarly.  
4.2 **Do not merge your branch into the main branch by yourself.** Have at least one person review the code before merging.

## 5. Pull from the Repository

5.1 Pull the latest changes from the main branch:

```bash
git pull origin main
