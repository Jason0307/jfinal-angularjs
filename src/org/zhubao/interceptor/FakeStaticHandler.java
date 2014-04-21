package org.zhubao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class FakeStaticHandler extends Handler {
	  public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
	      System.out.println("====target: " + target + "====" );
		  int index = target.lastIndexOf(".do");
	    if (index != -1) {
	      target = target.substring(0, index);
	    }
	    nextHandler.handle(target, request, response, isHandled);
	  }
	}