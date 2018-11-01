package _00_config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ctbc.service.TestAopSample;

@Configuration
@ComponentScan(basePackages = { "com.ctbc.service.**" , "com.ctbc.aspect.**" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootConfig {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		TestAopSample qqq = context.getBean("testAopSample", TestAopSample.class);
//		qqq.testBefore();
//		qqq.testAfter();
//		qqq.testReturnValue();
//		qqq.testThrowException();
		qqq.testAround_useAnnotation();
		context.close();
	}
}
