package com.boomxika.annotationAndAop;

public class BaseServiceImpl implements BaseService{
	@MyLog(title = "BaseService")
	public void justDoIt() {
		System.out.println("就是干！");
	}
}
