

Spring Boot project  

1)CrudRepository  
2)JpaRepostiry  
3)Paging and sorting repository  

EmployeeDao extends CrudRepository  

Database configuration done in application.properties

Get All Employees  
http://localhost:9090/emp/controller/getAll  
Get Employee By Id  
http://localhost:9090/emp/controller/get/1  
add Employee  
http://localhost:9090/emp/controller/add  
update Employee  
http://localhost:9090/emp/controller/updateEmp  
delete Employee  
http://localhost:9090/emp/controller/delete/3  
Get Employee By Range Salary  
http://localhost:9090/emp/controller/getEmpSalary/50001.0-200000  
Get Employees by user input for format  
http://localhost:9090/emp/controller/get/format/json
