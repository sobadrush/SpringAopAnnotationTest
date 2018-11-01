package com.ctbc.selfdefannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface InteceptedByAOP {
	
	// ref. https://cms.35g.tw/coding/java-enum-example/
	public enum Level { 
		
		INFO("info") , 
		WARN("warn") , 
		ERROR("error"); 
		
		private String val;
		
		private Level(String val) {
	        this.val = val;
	    }
		public String getValue() {
	        return this.val;
	    }
	};
	
	// 宣告註解成員
	public Level level() default Level.INFO;
	public String actionName();
	public boolean value() default false;
}
