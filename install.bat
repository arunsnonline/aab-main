@echo off
del %TOMCAT_HOME%\webapps\adsandboards.war >nul 2>&1
rd /s /q %TOMCAT_HOME%\webapps\adsandboards >nul 2>&1
copy .\target\adsandboards.war %TOMCAT_HOME%\webapps\ >nul 2>&1
