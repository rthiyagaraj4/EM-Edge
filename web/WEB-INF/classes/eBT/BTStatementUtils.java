/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;

import java.util.Hashtable;

public class BTStatementUtils
{
 public static synchronized  void replace(StringBuffer strbuf,String strValue,String realValue)
 {
  int leng,pos;
 
do{
     pos=strbuf.toString().indexOf(strValue);
     if(pos>0)
	  {
 		 leng=strValue.length();
	     strbuf.replace(pos,pos+leng,""+realValue);
	  }
   }while(pos!=-1);
 }
 public static synchronized String checkNull(Hashtable table,String param)
 {
  String strReturn = "";

  strReturn = ""+table.get(param);
  if(strReturn.equals("null")) return "";
  return(strReturn);
 } 
}

