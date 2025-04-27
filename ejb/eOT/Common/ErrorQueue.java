/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common;

import java.util.HashMap;
import java.util.Map;

public class ErrorQueue { 
 
	private static ThreadLocalQueue queue = new ThreadLocalQueue();
	
	private static class ThreadLocalQueue extends ThreadLocal {
	    public Object initialValue() {
			return new HashMap<String,String>();
	    }
   }

	public static Map getErrorQueue() {
	 return (Map) queue.get();
	}

	public static void remove() {
		queue.remove();
	 }

	public static void set(Object obj){
	  queue.set(obj);
	}
  
	public static String getErrorMsg() {
		return (String) getErrorQueue().get("err_text");
    }
  
    public static String getFname() {
	 return  (String) getErrorQueue().get("fname");
   }
  
    public static String getErrorLevel() {
		 return  (String) getErrorQueue().get("err_level");
   }
  
   public static String getErrorID() {
		 return (String) getErrorQueue().get("sys_mesg_id");
  }
  
}
