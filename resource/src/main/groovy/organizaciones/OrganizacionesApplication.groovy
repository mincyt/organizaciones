package organizaciones

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext


@SpringBootApplication
class OrganizacionesApplication {
	
    static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run OrganizacionesApplication, args
        String[] beanNames = ctx.getBeanDefinitionNames()
        Arrays.sort(beanNames)
        for (String beanName : beanNames) {
            System.out.println(beanName)
        }

    }

}
