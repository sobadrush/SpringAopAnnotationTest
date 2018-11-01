package com.ctbc.service;

import org.springframework.stereotype.Service;

import com.ctbc.selfdefannotation.InteceptedByAOP;
import com.ctbc.selfdefannotation.InteceptedByAOP.Level;

@Service
public class TestAopSample {

	public void testBefore() {
		System.out.println(" ==================================");
		System.out.println(" =========== testBefore() ===========");
		System.out.println(" ==================================");
	}

	public void testAfter() {
		System.out.println(" ==================================");
		System.out.println(" =========== testAfter() ===========");
		System.out.println(" ==================================");
	}

	public String testReturnValue() {
		System.out.println(" ==================================");
		System.out.println(" =========== testReturnValue() ===========");
		System.out.println(" ==================================");
		return "我是回傳值";
	}

	public void testThrowException() {
		System.out.println(" ============================================");
		System.out.println(" =========== testThrowException() ===========");
		System.out.println(" ============================================");
		throw new RuntimeException("我拋出錯誤囉~");
	}

	@InteceptedByAOP(actionName = "FuckYou", level = Level.INFO)
	public void testAround_useAnnotation() {
		System.out.println(" ==========================================================");
		System.out.println(" =============== testAround_useAnnotation() ===============");
		System.out.println(" ==========================================================");
	}

}
