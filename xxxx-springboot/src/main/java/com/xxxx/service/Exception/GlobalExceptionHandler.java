package com.xxxx.service.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxxx.service.Domain.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
   
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req,MyException e) throws Exception{
		
		ErrorInfo<String> errorInfo=new ErrorInfo<>();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("show error infomations");
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;
	}
}
