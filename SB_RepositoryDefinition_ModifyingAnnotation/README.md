


Spring Boot Project  



//@modifying - without these the DML(data manipulation) queries wont work  

////Custom Repository Creation  
@RepositoryDefinition(  
		domainClass = EmployeeEntity.class,  
		idClass = Integer.class)  
		

//Custom methods which are provided by Repository  
//Provided by jpa Repository with small modifications  


22:31:33.197 [main] INFO com.example.demo.SbRepositoryDefinitionModifyingAnnotationApplication -- result ->{}[EmployeeEntity(empId=1, name=tarun, role=developer, insertTime=2024-05-12, salary=7845658.2), EmployeeEntity(empId=2, name=tarun, role=developer, insertTime=2024-05-12, salary=7845658.2), EmployeeEntity(empId=3, name=revi, role=developer, insertTime=2024-05-12, salary=123456.6), EmployeeEntity(empId=4, name=lulu, role=developer, insertTime=2024-05-12, salary=654321.1), EmployeeEntity(empId=5, name=striff, role=tester, insertTime=2024-05-12, salary=456321.23), EmployeeEntity(empId=6, name=shahid, role=developer, insertTime=2024-05-12, salary=800000.9), EmployeeEntity(empId=7, name=ramesh, role=tester, insertTime=2024-05-12, salary=852147.9), EmployeeEntity(empId=8, name=akshatha, role=operations analyst, insertTime=2024-05-13, salary=99999.9), EmployeeEntity(empId=9, name=revesh, role=HR, insertTime=2024-05-13, salary=45623.23), EmployeeEntity(empId=1001, name=vijju, role=tester, insertTime=2024-05-11, salary=852147.9), EmployeeEntity(empId=1002, name=lulu, role=developer, insertTime=2024-07-14, salary=988458.2)]
inside - findAllMethod uses findAllHQL - from orm.xml
Hibernate: select ee1_0.empId,ee1_0.insertTime,ee1_0.name,ee1_0.role,ee1_0.salary from employee_data_1 ee1_0
EmployeeEntity(empId=1, name=tarun, role=developer, insertTime=2024-05-12, salary=7845658.2)
EmployeeEntity(empId=2, name=tarun, role=developer, insertTime=2024-05-12, salary=7845658.2)
EmployeeEntity(empId=3, name=revi, role=developer, insertTime=2024-05-12, salary=123456.6)
EmployeeEntity(empId=4, name=lulu, role=developer, insertTime=2024-05-12, salary=654321.1)
EmployeeEntity(empId=5, name=striff, role=tester, insertTime=2024-05-12, salary=456321.23)
EmployeeEntity(empId=6, name=shahid, role=developer, insertTime=2024-05-12, salary=800000.9)
EmployeeEntity(empId=7, name=ramesh, role=tester, insertTime=2024-05-12, salary=852147.9)
EmployeeEntity(empId=8, name=akshatha, role=operations analyst, insertTime=2024-05-13, salary=99999.9)
EmployeeEntity(empId=9, name=revesh, role=HR, insertTime=2024-05-13, salary=45623.23)
EmployeeEntity(empId=1001, name=vijju, role=tester, insertTime=2024-05-11, salary=852147.9)
EmployeeEntity(empId=1002, name=lulu, role=developer, insertTime=2024-07-14, salary=988458.2)
22:31:33.223 [main] INFO org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean -- Closing JPA EntityManagerFactory for persistence unit 'default'
