

# Maven Plugin for extracting VBA scripts from an Excel file

Bsp: Excel file my_excel.xlsm:

```text
|
\---src
    \---main
        \---resources
            |   my_excel.xlsm
```            

Usage: 
```xml

    <build>

        <plugins>

            <plugin>
                <groupId>de.example.excel</groupId>
                <artifactId>macro-extractor-maven-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
                <executions>
                    <execution>
                        <configuration>
                            <sourceFilePath>${project.basedir}/src/main/resources/my_excel.xlsm</sourceFilePath>
                            <targetDirPath>${project.basedir}/src/main/resources/my_excel_macros/</targetDirPath>
                        </configuration>
                        <goals>
                            <goal>extract-vba</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>

    </build>
```

```text
mvn install
```   

=> 

```text
|
\---src
    \---main
        \---resources
            |   my_excel.xlsm
            |
            \---my_excel_macros
                    DieseArbeitsmappe.vba
                    Tabelle1.vba
```
