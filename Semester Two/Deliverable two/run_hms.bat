@echo off
REM =========================================
REM Hospital Management System - Deliverable #2
REM Run Script (No NetBeans Required)
REM =========================================

echo.
echo === Hospital Management System - Deliverable #2 ===
echo === Structural Design Patterns Demo ===
echo.

REM Navigate to project directory
cd /d "C:\Users\Adham Sobhy\Downloads\Introduction-To-Software-Engineering-Project\Software-Design-&-Development-Project\Deliverable two\HospitalMangementSystem_Maven"

REM Set Maven path (using NetBeans bundled Maven)
set "MAVEN_HOME=C:\Users\Adham Sobhy\Downloads\netbeans-28-bin\netbeans\java\maven"
set "PATH=%MAVEN_HOME%\bin;%PATH%"

REM Check if Java is available
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERROR] Java not found in PATH.
    echo Please install Java JDK 17 or higher.
    echo.
    pause
    exit /b 1
)

echo [INFO] Java version:
java -version
echo.
echo [INFO] Maven: Using NetBeans bundled Maven
echo.

REM Clean and compile
echo [INFO] Building project with Maven...
echo.
"%MAVEN_HOME%\bin\mvn.cmd" clean compile

echo.
if %errorlevel% neq 0 (
    echo [ERROR] Build failed with error code %errorlevel%
    echo.
    pause
    exit /b 1
)

echo.
echo [SUCCESS] Build completed successfully!
echo.
echo [INFO] Starting Hospital Management System...
echo.

REM Run the application using Maven exec plugin
"%MAVEN_HOME%\bin\mvn.cmd" exec:java -Dexec.mainClass="hospitalmanagementsystem.HospitalMangementSystem" -q

echo.
echo [INFO] Application closed.
echo.
pause
