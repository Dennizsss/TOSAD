@echo off
copy /-y ojdbc7-12.1.0.1.jar %userprofile%\.m2\repository\jdbc-12.1.0.1.jar
cd %userprofile%\.m2\repository\
mkdir org\oracle
mkdir org\oracle\jdbc
mkdir org\oracle\jdbc\12.1.0.1

move /-y jdbc-12.1.0.1.jar org\oracle\jdbc\12.1.0.1\jdbc-12.1.0.1.jar

pause