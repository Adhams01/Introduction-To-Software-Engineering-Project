@echo off
setlocal

echo Compiling...
javac .\src\Main.java .\src\controller\*.java .\src\dao\*.java .\src\domain\*.java .\src\external\*.java .\src\ui\*.java
if errorlevel 1 (
  echo.
  echo Compile failed. Fix the errors above, then run again.
  pause
  exit /b 1
)

echo.
echo Running...
echo.
java -cp .\src Main

echo.
echo Program finished.
pause
