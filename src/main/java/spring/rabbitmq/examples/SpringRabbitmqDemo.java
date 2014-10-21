package spring.rabbitmq.examples;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Queue;  
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRabbitmqDemo {

  private static final Log log = LogFactory.getLog(SpringRabbitmqDemo.class);

  public static void main(String[] args) throws Exception{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context.xml", SpringRabbitmqDemo.class);
		log.info("Rabbitmq Demo Application Running");
		context.registerShutdownHook();

		RabbitTemplate template = context.getBean(RabbitTemplate.class);
    		template.convertAndSend("Hello, world!");
    		Thread.sleep(1000);
    		context.destroy();
  }
}
