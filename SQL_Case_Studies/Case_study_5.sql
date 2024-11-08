-- Question5
-- Create an SQL table for AxisBank_customer and perform below activities:
-- 1.  Add the below mentioned attribute and add records for 20 customers: customer_id, customerName, credit_limit, applicable, cvv, expiry_date, kyc_status.
-- 2.  Write the query below: Get the all data for the customer which has KYC status verified?
-- 3.  Calculate the balance who is not done with KYC.
-- 4.  What is the top 5th balance customer of having the highest bank balance?
-- 5.  Calculate the number of customers whose credit card/debit card is going to expire within 3 months.
-- 6.  Retrieve the name of the customer who has lowest account balance amount


-- using axisdatabase database

use axisdatabase;

-- creating a table named Group5_Axis_Bank_customer

CREATE TABLE Group5_Group5_Axis_Bank_customer (
    Customer_id INT PRIMARY KEY,
    Customer_Name VARCHAR(50),
    Credit_limit DECIMAL(10, 2),
    Applicable varchar(20),
    CVV INT,
    Expiry_date DATE,
    Kyc_status VARCHAR(10),
	Balance DECIMAL(10, 2)
);

-- inserting data into Group5_Axis_Bank_customer table

INSERT INTO Group5_Axis_Bank_customer (customer_id, customer_Name, credit_limit, applicable, cvv, expiry_date, kyc_status, balance) VALUES
(1, 'Sourabh Desai', 50000.00, 'TRUE', 123, '2025-12-31', 'Verified', 15000.00),
(2, 'Anjana Krishna', 30000.00, 'TRUE', 456, '2024-08-15', 'Verified', 12000.00),
(3, 'Rutuja Jejurkar', 45000.00, 'TRUE', 789, '2026-01-20', 'Pending', 20000.00),
(4, 'Suyog Waghere', 20000.00, 'FALSE', 111, '2023-05-10', 'Verified', 4000.00),
(5, 'Madhuri Vuppala', 60000.00, 'TRUE', 222, '2025-10-01', 'Verified', 30000.00),
(6, 'Sandesh Desai', 35000.00, 'TRUE', 333, '2024-03-17', 'Pending', 25000.00),
(7, 'Shubham Patil', 40000.00, 'FALSE', 444, '2026-09-29', 'Verified', 10000.00),
(8, 'Vishal Singh', 25000.00, 'TRUE', 555, '2025-07-05', 'Verified', 15000.00),
(9, 'Vaibhavi Kale', 50000.00, 'TRUE', 666, '2024-11-30', 'Pending', 30000.00),
(10, 'Uday Kiran', 30000.00, 'FALSE', 777, '2023-12-25', 'Verified', 10000.00),
(11, 'Javed Md', 55000.00, 'TRUE', 888, '2025-05-15', 'Pending', 25000.00),
(12, 'Swapnil Duparte', 40000.00, 'TRUE', 999, '2026-04-20', 'Verified', 35000.00),
(13, 'Ram Patil', 30000.00, 'FALSE', 100, '2025-06-14', 'Verified', 5000.00),
(14, 'Annliya Santhosh', 42000.00, 'FALSE', 200, '2024-08-28', 'Verified', 18000.00),
(15, 'Rohit Jain', 35000.00, 'TRUE', 300, '2026-10-05', 'Pending', 15000.00),
(16, 'Sachin Chavan', 25000.00, 'TRUE', 400, '2025-01-19', 'Verified', 20000.00),
(17, 'Arsha Jose', 47000.00, 'TRUE', 500, '2024-07-23', 'Pending', 12000.00),
(18, 'Anto Varghese', 32000.00, 'FALSE', 600, '2023-06-30', 'Verified', 17000.00),
(19, 'Rachel Mani', 39000.00, 'TRUE', 700, '2025-09-12', 'Verified', 29000.00),
(20, 'Jenny Sebastian', 45000.00, 'FALSE', 800, '2024-12-18', 'Pending', 3000.00);


-- Displaying all the Data from Table 

SELECT * 
FROM Group5_Axis_Bank_customer;


-- Question no 1:- Get the all data for the customer which has KYC status verified?

select * 
from  Group5_Axis_Bank_customer 
where kyc_status ='verified';

-- Question no 2:- total count of this type of customer (Extra question)

select count(*) as Total_customers
from  Group5_Axis_Bank_customer
where kyc_status ='verified';

-- Question no 3:-  Calculate the balance who is not done with KYC.

select sum(balance) 
from  Group5_Axis_Bank_customer
where kyc_status ='pending';

-- question no 4:- What is the top 5th balance customer of having the highest bank balance?

SELECT * 
FROM Group5_Axis_Bank_customer
ORDER BY balance DESC
OFFSET 4 ROWS FETCH NEXT 1 ROW ONLY;


-- Question no 5:- Calculate the number of customers whose credit card/debit card is going to expire within 3 months.

SELECT COUNT(*) AS expiring_customers
FROM AxisBank_customer
WHERE expiry_date BETWEEN GETDATE() AND DATEADD(MONTH, 3, GETDATE()); 

-- Question no 6:- To get all the details of above customers. (Extra question)

SELECT *
FROM AxisBank_customer
WHERE expiry_date BETWEEN GETDATE() AND DATEADD(MONTH, 3, GETDATE()); 


-- Question no 7:- Retrieve the name of the customer who has lowest account balance amount

-- we have used inner query for sql server to get the actual result

SELECT customer_Name, balance
FROM Group5_Axis_Bank_customer
WHERE balance = (SELECT MIN(balance) FROM Group5_Axis_Bank_customer);