/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOH.Common.OHAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class MTLinkBean extends OHAdapter implements Serializable{
	//public static HandleCompBean handleBean=null;
	
	 String ch=null;
	 HashMap checkedRow = null;
	 HashMap checkedMap = null;
	 ArrayList checkedArray = null;
     HashMap charCheckMap=new HashMap();
     HashMap charCheckTempMap=new HashMap();
	
	
	public HashMap getCheckedRow() {
	if(checkedRow==null)
		checkedRow=new HashMap();
		return checkedRow;
	}


	public void setCheckedRow(String ch,String taskCode,String taskDesc,String seqNo,String select_value) {
		if(checkedRow==null)
		  checkedRow=new HashMap();
	
		checkedRow.put(ch, taskCode);
		setCheckedMap(taskCode,taskDesc,seqNo,select_value);
		
		
	}

	public HashMap getCheckedMap() {
		
		if(checkedMap==null)
		checkedMap=new HashMap();
		return checkedMap;
	}

	public void setCheckedMap(String taskCode,String taskDesc,String seqNo,String select_value) {
		if(checkedMap==null)
		 checkedMap=new HashMap();

		if(checkedArray==null){
		    checkedArray=new ArrayList();
			}

		if(checkedArray.contains(taskCode))
	    {
		int ind=checkedArray.indexOf(taskCode) ;		
		//String  seq=(String)checkedMap.get(taskCode);
		
		checkedArray.remove(taskCode);
		checkedArray.remove(taskDesc);
		checkedArray.remove(ind);  
		}
	   
		checkedMap.put(taskCode, seqNo);		
		checkedArray.add(taskCode);
		checkedArray.add(taskDesc);
		checkedArray.add(seqNo);
	}
   public void removeCheckedRow(String taskCode,String taskDesc,String seqNo,String select_value)
	{
	   checkedMap.remove(taskCode);
	  if(checkedArray.contains(taskCode))
	   {
	   int ind=checkedArray.indexOf(taskCode) ;
	   checkedArray.remove(ind);//removing the taskCode using index
	   checkedArray.remove(ind);//removing the taskDesc using index after removing taskCode index is equal to taskDesc
	   checkedArray.remove(ind);
	   }//removing the seqNo using index after removing taskDesc index is equal to seqNo
	   //checkedArray.remove(select_value);
	}
	public ArrayList getCheckedArray() {
	if(checkedArray==null)
		checkedArray=new ArrayList();
		return checkedArray;
	}
	
   public void clear(){
		checkedRow		= null;
		checkedMap	= null;
		checkedArray	= null;
	}
   public String chkDuplicate()
	{
	 Collection cl=checkedMap.values();
     String flag="";
	 Object chkArray []=null;
	 chkArray=cl.toArray();
	 for(int i=0;i<chkArray.length;i++)
		{
          for(int j=0;j<chkArray.length;j++)
		  {
            if(chkArray[i].toString().equals(chkArray[j].toString()) && i!=j)
			{ 
			
			 flag=chkArray[i].toString();
			 break;
			}
		  }
		}
		return flag;
     
	}
}
