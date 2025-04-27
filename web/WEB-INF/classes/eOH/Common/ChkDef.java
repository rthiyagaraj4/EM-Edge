/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH.Common ;
public class ChkDef  implements java.io.Serializable
{ 
	private ChkDef(){}
	public  static  boolean  checkObject(Object obj){ return (obj==null) ? false : true ;}
	 public	 static  int      defaultInt(String i){return (i==null) ? 0 : Integer.parseInt(i);}  
     public	 static  long     defaultLong(String lg){return (lg==null) ? 0 :Long.parseLong(lg);}
	 public	 static  String   defaultString(String str){return (str==null)? "":str.trim();}
	 public	 static  char	  defaultChar(String ch){return (ch==null) ? ' ':ch.charAt(0);}
	 public	 static  double   defaultDouble(String db){return (db==null) ?0.0 : Double.parseDouble(db);}
	 public	 static  float	  defaultFloat(String fl){return (fl==null) ? 0.0f:Float.parseFloat(fl);}
}
