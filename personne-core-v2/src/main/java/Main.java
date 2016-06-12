import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.personne.service.PersonneService;

public class Main {
	
	 public static void main(String[] args) { 
		 
//		 System.setProperty("spring.profiles.active", "developpement");
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring.xml");
		 
		  //Enable a "live" profile
			
		 applicationContext.getBeanDefinitionNames();
	//	 
//		 PersonneService factory = (PersonneService) applicationContext.getBean("personneServiceImpl");
//		 factory.getAll();
	//	 
	//	 factory.add(new PersonneEntity());
		 
	}
	 
}