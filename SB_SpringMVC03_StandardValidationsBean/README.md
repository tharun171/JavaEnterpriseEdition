

Spring Boot project  

spring Mvc Project  
Standard validations from Bean using annotations  
Binding result - collects errors  

import org.hibernate.validator.constraints.Range;  
import org.springframework.format.annotation.DateTimeFormat;  
import org.springframework.stereotype.Component;  
import jakarta.validation.constraints.AssertTrue;  
import jakarta.validation.constraints.NotEmpty;  
import jakarta.validation.constraints.NotNull;  
import jakarta.validation.constraints.PastOrPresent;  
import jakarta.validation.constraints.Size;  

using jstl expression we show values in success page ${key.variable}  