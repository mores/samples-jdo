many_to_many_attributed
=======================
The prerequisite is that you need the DataNucleus Maven2 plugin installed.
You can download this plugin from the DataNucleus downloads area.

1. Set the database configuration in "src/main/resources/META-INF/persistence.xml"

2. Make sure you have the JDBC driver jar specified in the "pom.xml" file

3. Run the command: "mvn clean compile"
   This builds everything, and enhances the classes

4. Run the command: "mvn datanucleus:schema-create"
   This creates the schema

5. Run some persistence code. "mvn clean exec:java"

6. Run the command: "mvn datanucleus:schema-delete"
   This deletes the schema

