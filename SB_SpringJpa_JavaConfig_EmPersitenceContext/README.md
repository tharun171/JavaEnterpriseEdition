


WORKING  

java config for   
hibernate configuartion  
datasource configuartion  
autowiring in java configuration  
Transaction management in java configuration  

used persistence context and entitymanager  


All Configuration done in java files not in Application.properties  

LOGS -->  
22:08:44.248 [main] INFO org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean -- Initialized JPA EntityManagerFactory for persistence unit 'default'  
get employee with id 1  
Hibernate: select ee1_0.empId,ee1_0.insertTime,ee1_0.name,ee1_0.role,ee1_0.salary from employee_data_1 ee1_0 where ee1_0.empId=?  
id 1   
EmployeeEntity [empId=1, name=ramesh, role=developer, insertTime=2024-05-08, salary=456123.2]  
inside dao impl  
Hibernate: select ee1_0.empId,ee1_0.insertTime,ee1_0.name,ee1_0.role,ee1_0.salary from employee_data_1 ee1_0  
22:08:44.608 [main] INFO com.example.demo.SbSpringJpaJavaConfigEmPersitenceContextApplication -- result ->{}[  
EmployeeEntity [empId=1, name=ramesh, role=developer, insertTime=2024-05-08, salary=456123.2],   
EmployeeEntity [empId=2, name=suresh, role=developer, insertTime=2024-05-08, salary=456123.2],   
EmployeeEntity [empId=3, name=luke, role=developer, insertTime=2024-05-08, salary=784565.2],   
EmployeeEntity [empId=4, name=Tharun, role=developer, insertTime=2024-07-13, salary=784565.2]]  
22:08:44.610 [main] INFO org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean -- Closing JPA EntityManagerFactory for    persistence unit 'default'  

