@echo off

mkdir %userprofile%\.m2\repository\org\oracle
mkdir %userprofile%\.m2\repository\org\oracle\jdbc
mkdir %userprofile%\.m2\repository\org\oracle\jdbc\12.1.0.1

copy /-y ojdbc7-12.1.0.1.jar %userprofile%\.m2\repository\org\oracle\jdbc\12.1.0.1

pause