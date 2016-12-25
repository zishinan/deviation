package com.jz.deviation.common;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jz.deviation.common.exception.ErrorException;
import com.jz.deviation.common.exception.WarnningException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = Logger.getLogger(RestExceptionHandler.class);
	@ExceptionHandler(value={Exception.class})
	public final ResponseEntity<?> handleLogicException(Exception ex,WebRequest request){
		HttpHeaders headers = new HttpHeaders();
		ErrorResponse errorResponse = new ErrorResponse();
		if(ex instanceof WarnningException){
			logger.info("校验失败：========",ex);
			errorResponse.setCode(1);
			errorResponse.setMessage(ex.getMessage());
		}else if(ex instanceof ErrorException){
			errorResponse.setCode(-1);
			errorResponse.setMessage(ex.getMessage());
			logger.error("参数错误：=======",ex);
		}else {
			logger.error("程序出错了:=======", ex);
			errorResponse.setCode(-1);
			errorResponse.setMessage("服务器程序错误");
		}
		return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.OK, request);
	}
}
