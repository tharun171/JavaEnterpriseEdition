

WORKING  

java config for   
hibernate configuartion  
datasource configuartion  
autowiring in java configuration  
Transaction management in java configuration  

did not use persistence context and entitymanager to save  
used Crudrepository to do operations, not entity manager  


Transaction Methods  
1)Readonly = true (doesnot allow manipulation of database, only retrieval)  
2)timout = 3 (3 seconds, after 3 seconds throws timout expired exception)  
transaction should take only 3 seconds after 3 seconds, throws Exception.  

![image](https://github.com/user-attachments/assets/c49581d9-6c31-46ec-9099-85c192b57eee)

![image](https://github.com/user-attachments/assets/f60d4441-dd76-4356-8965-9237fc730782)

