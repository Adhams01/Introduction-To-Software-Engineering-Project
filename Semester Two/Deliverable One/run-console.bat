@echo off
chcp 65001 >nul
title Hospital Management System - Deliverable 1
echo ========================================
echo Hospital Management System
echo Deliverable #1: Creational Patterns
echo ========================================
echo.
echo Starting Console Application...
echo.

"C:\Program Files\Java\jdk-23\bin\java.exe" -cp "%~dp0HospitalMangementSystem_Maven\target\classes;" hospitalmangementsystem.HospitalMangementSystem

if errorlevel 1 (
    echo.
    echo ========================================
    echo ERROR: Could not run application
    echo Make sure you have built the project first:
    echo Right-click project in NetBeans -^> Clean and Build
    echo ========================================
    pause
)

echo.
echo Application finished.
pause
