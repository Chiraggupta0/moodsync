# MoodSync (Production Ready)

## Features
- JWT Authentication
- Spring Boot + MySQL (RDS ready)
- React Frontend
- Deployable on AWS EC2

## AWS Steps
1. Launch EC2 (Ubuntu)
2. Open ports: 22, 8080, 3000
3. Install:
   sudo apt update
   sudo apt install openjdk-17-jdk mysql-server nodejs npm -y

4. Run backend:
   cd backend
   mvn clean package
   java -jar target/backend-1.0.jar

5. Run frontend:
   cd frontend
   npm install
   npm start

## Important
- Replace YOUR_EC2_IP in frontend
- Replace DB with RDS endpoint
# moodsync
