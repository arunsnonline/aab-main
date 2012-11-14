SETUP-HOW-TO
-----------------------
1.Setup apache maven 2.2.1.Setup m2eclipse in eclipse for importing project to eclipse
2.Setup mysql and restore dump from adsboards_20121014.sql.For windows please set lower_case_table_names=2 in mysql configuration before starting mysql service
3.Go to project. Change jdbc.properties in src/main/resources
4.In command line move to project root folder adsandboards and type mvn clean package.
War will be generated in target folder .Copy adsandboards.war and put it in tomcat webapps
