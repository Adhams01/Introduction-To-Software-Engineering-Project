#!/bin/bash
# Git Branch Setup for Deliverable #1 (Creational Design Patterns)
# Run this in Git Bash at the repo root

echo "Navigating to repo root..."
cd "C:\Users\Adham Sobhy\Downloads\Introduction-To-Software-Engineering-Project\Introduction-To-Software-Engineering-Project"

echo "Creating and pushing 'develop' branch..."
git checkout -b develop
git push -u origin develop

echo "Creating and pushing 'feature/andrew-singleton-factory'..."
git checkout -b feature/andrew-singleton-factory
git push -u origin feature/andrew-singleton-factory

echo "Creating and pushing 'feature/adham-abstract-factory'..."
git checkout -b feature/adham-abstract-factory
git push -u origin feature/adham-abstract-factory

echo "Creating and pushing 'feature/yassin-qa-packaging'..."
git checkout -b feature/yassin-qa-packaging
git push -u origin feature/yassin-qa-packaging

echo "Switching back to 'main'..."
git checkout main

echo "Git branch setup complete."
