CREATE TABLE employee (
                          id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL,
                          address VARCHAR(255),
                          PRIMARY KEY (id)
);

select * from employee e
INSERT INTO employee (name, address) VALUES
                                         ('Eve Turner', '321 Birch Ln'),
                                         ('Frank Green', '654 Cedar Blvd'),


    ALTER TABLE employee
ADD salary VARCHAR(255);

UPDATE employee
SET salary = CASE name
                 WHEN 'Eve Turner' THEN 700
                 WHEN 'Frank Green' THEN 750
                 WHEN 'Carol Lee' THEN 720
                 ELSE salary
    END
WHERE name IN ('Eve Turner', 'Frank Green', 'Carol Lee');

ALTER TABLE employee
    ADD year VARCHAR(255);

UPDATE employee
SET year = CASE name
               WHEN 'Eve Turner' THEN 2023
               WHEN 'Frank Green' THEN 2023
               WHEN 'Carol Lee' THEN 2024
               ELSE year
    END
WHERE name IN ('Eve Turner', 'Frank Green', 'Carol Lee');

select * from employee e

CREATE TABLE department (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            head VARCHAR(50) NOT NULL,
                            employee_id INT UNSIGNED,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);

select * from department d
INSERT INTO department ( name,head,employee_id ) VALUES
                                                     ('business', 'Karan',2),
                                                     ('IT', 'Mishika',1),
                                                     ('Operations', 'Vedu',3);

################### quesries to practise#############################################

#employee name and department head

SELECT e.name, d.head
FROM employee e
         JOIN department d ON e.id = d.employee_id
GROUP BY e.address, e.name, d.head;

#higest salary

select max(salary) from employee

#second highest salary

select max(salary) from employee
where salary < (select max(salary) from employee)


#Get the names of employees whose salary is greater than 720

select e.name from employee e
where salary > 720

#Retrieve the list of employees who joined in the year 2023.

select e.name from employee e
where year=2023

#names of employee having salary > 700

select e.name
FROM employee e
WHERE e.salary > 700
group By e.name;

