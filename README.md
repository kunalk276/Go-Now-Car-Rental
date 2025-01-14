# Go-Now-Car-Rental

## SCREENSHOT 
![Screenshot 2025-01-14 130447](https://github.com/user-attachments/assets/748b51fa-17be-4a3d-ad71-1bd3fbe5a45d)
![Screenshot 2025-01-14 130458](https://github.com/user-attachments/assets/64d3c442-e3d8-407d-9acb-cef34cdb3b53)
![Screenshot 2025-01-14 130506](https://github.com/user-attachments/assets/708615b9-13fc-47eb-bae6-c559bfb302a6)
![Screenshot 2025-01-14 130525](https://github.com/user-attachments/assets/4ccf8b5e-675a-422c-b278-bc563cf1a9f8)
![Screenshot 2025-01-14 130534](https://github.com/user-attachments/assets/8439c580-6d20-41b8-80f8-7b14fff16839)
![Screenshot 2025-01-14 130605](https://github.com/user-attachments/assets/7f8971af-c132-4d5b-b248-e713d915bbcc)
![Screenshot 2025-01-14 130624](https://github.com/user-attachments/assets/0f16edf1-f85f-4124-80d7-24005c28b0f4)
![Screenshot 2025-01-14 130642](https://github.com/user-attachments/assets/fe8d7df3-2cd0-42e4-ad5e-aa11e0a0417b)
![Screenshot 2025-01-14 130722](https://github.com/user-attachments/assets/3e6e75be-9697-48a3-8b14-964d8ae8600c)
![Screenshot 2025-01-14 130722](https://github.com/user-attachments/assets/532c7e62-aac5-4a35-88d8-4925cbba3177)
![Screenshot 2025-01-14 130822](https://github.com/user-attachments/assets/c2643d14-bcc9-4094-9347-31069bc4cf72)
![Screenshot 2025-01-14 130822](https://github.com/user-attachments/assets/a1052f3a-f3f0-49b5-b16a-bf713e94e385)
![Screenshot 2025-01-14 130816](https://github.com/user-attachments/assets/2e99a722-30dd-443c-8174-12b86137bb50)
![Screenshot 2025-01-14 130816](https://github.com/user-attachments/assets/58c73613-03ba-43ad-bf90-2e5c21f40229)
![Screenshot 2025-01-14 130822](https://github.com/user-attachments/assets/f76f02eb-f6c8-4130-b019-50279dbfdcef)
![Screenshot 2025-01-14 130840](https://github.com/user-attachments/assets/1c471838-2f15-4f86-86ab-f0b64ec68142)
![Screenshot 2025-01-14 130918](https://github.com/user-attachments/assets/cd5fff3e-fc8a-4163-a7d7-f59994b9fa85)



#### The tables included in the MySQL database are:
1. carregistration.
2. customer.
3. rental.
4. login.
5. returncar.  

#### The name of the database is **"rentcar"** and the description of tables is given below : 

##### 1. "carregistration" table includes :
    
| Field     | Type         | Null | Key | Default | Extra          |
|-----------|--------------|------|-----|---------|----------------|
| id        | int(10)      | NO   | PRI | NULL    | auto_increment |
| car_no    | varchar(255) | YES  |     | NULL    |                |
| make      | varchar(255) | YES  |     | NULL    |                |
| model     | varchar(255) | YES  |     | NULL    |                |
| available | varchar(255) | YES  |     | NULL    |                |

##### 2. "customer" table includes :

| Field   | Type         | Null | Key | Default | Extra          |
|---------|--------------|------|-----|---------|----------------|
| id      | int(10)      | NO   | PRI | NULL    | auto_increment |
| cust_id | varchar(255) | YES  |     | NULL    |                |
| name    | varchar(255) | YES  |     | NULL    |                |
| address | tinytext     | YES  |     | NULL    |                |
| mobile  | int(13)      | YES  |     | NULL    |                |

##### 3. "rental" table includes :

| Field   | Type         | Null | Key | Default | Extra          |
|---------|--------------|------|-----|---------|----------------|
| id      | int(10)      | NO   | PRI | NULL    | auto_increment |
| car_id  | varchar(255) | YES  |     | NULL    |                |
| cust_id | varchar(255) | YES  |     | NULL    |                |
| fee     | int(11)      | YES  |     | NULL    |                |
| date    | varchar(255) | YES  |     | NULL    |                |
| due     | varchar(255) | YES  |     | NULL    |                |

##### 4. "login" table includes :

| Field    | Type         | Null | Key | Default | Extra          |
|----------|--------------|------|-----|---------|----------------|
| login_id | int(11)      | NO   | PRI | NULL    | auto_increment |
| username | varchar(255) | YES  |     | NULL    |                |
| password | varchar(255) | YES  |     | NULL    |                |

##### 5. "returncar" table includes :

| Field       | Type         | Null | Key | Default | Extra          |
|-------------|--------------|------|-----|---------|----------------|
| id          | int(10)      | NO   | PRI | NULL    | auto_increment |
| carid       | varchar(255) | YES  |     | NULL    |                |
| custid      | varchar(255) | YES  |     | NULL    |                |
| return_date | varchar(255) | YES  |     | NULL    |                |
| elap        | int(11)      | YES  |     | NULL    |                |
| fine        | int(11)      | YES  |     | NULL    |                |
</li>


* This repository is open to contributions :smile:. Feel free to raise issues and contribute.
