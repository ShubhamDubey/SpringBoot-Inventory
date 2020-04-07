# SpringBoot

# SpringBootDemo for NIIT

## Controller
  
     1. HelloWorldController 
  


# SpringUdemyDemo for Practice

## Controller

	1. Home Controller
	
	
# SpringBoot-Inventory

In this project we learn the Spring with JPA and DB Connections.'

## Steps
 
	1. Maintain the directory Structure
 		
  * create   java  folder from /src/main [if not exist]
      
  * create   packages  in java for model,controller,service,repository
 * create  static in /src/main/resources/
 * create  css,js,images in /src/main/resources/static
     
   * create views in /src/main/webapp/WEB-INF
 	
 	2. Changes in Application.Properties
> for mapping the Views 	
* spring.mvc.view.prefix=/views/

>> after View Mapping which kind of files View Carry
* spring.mvc.view.suffix=.jsp

> for mapping the Resources like CSS,IMAGES,JS
* spring.mvc.static-path-pattern=/resources/static/**
* spring.resources.add-mappings=true

> Now Mapping with DataBase 
* spring.jpa.hibernate.ddl-auto=none

>> Database URL
* spring.datasource.url=jdbc:mysql://localhost:3306/crm

>> DataBase UserName
* spring.datasource.username=root

>> DataBase UserName
* spring.datasource.password=root

* logging.level.root=WARN


>## Testing

>>### Annotations

>>> Mockito with Junit

>>> #### 1. Mock

>>>> **Mock** is used for **dummy Object/clone Object**

>>> ### 2. Spy

>>>> Spy is used for **Real Object**


 
