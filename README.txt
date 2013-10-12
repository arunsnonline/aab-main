ADS & BOARDS
------------
This platform helps users in searching hoarding/billboards across locations.Primary search is based on locations.Advanced searching
offers features search on adboard attributes like type of boards,dimension,price range,availability etc.Other planned features include searching based on maps,
displaying routes which are traffic dense and boards with good visibality in those routes.Detiled display of boards involve displaying
1. Details of board
2. Photos of hoarding
3. Locations on map
4. 360 degree view from hoarding perspective

There is an admin page(http://localhost:8080/adsandboards/admin) for hoarding owners for loading billboard data.
Each owners can login into their respective accounts and input details on their boards,upload photos,mark locations on map and preview the final outcome

TECHNOLOGY-STACK
----------------
JQuery,JQuery UI
Spring MVC,
Spring Core,
Hibernate

SETUP-HOW-TO
------------
1.Setup apache maven 2.2.1.Setup m2eclipse in eclipse for importing project to eclipse
2.Setup mysql and restore dump from dbscripts/demodata.sql.For windows please set lower_case_table_names=2 in mysql configuration before starting mysql service
3.Create a db and restore the demodata.sql into your local db
4.Go to project. Change jdbc.properties in src/main/resources
5.In command line move to project root folder adsandboards and type mvn clean package.
War will be generated in target folder .Copy adsandboards.war and put it in tomcat webapps.Point your browser to http://localhost:8080/adsandboards
