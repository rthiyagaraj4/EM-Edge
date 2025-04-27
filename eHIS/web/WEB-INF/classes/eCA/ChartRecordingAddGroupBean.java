/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1				
16/08/2019	IN069564		Ramesh Goli		CA-Common-Record Charts
------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eCA.Common.CaAdapter;//IN070610
import webbeans.eCommon.ConnectionManager;

public class  ChartRecordingAddGroupBean extends CaAdapter implements java.io.Serializable
{
	public CaAdapter adapter = new CaAdapter();//IN070610
	HashMap records = new HashMap();
	HashMap listsForGroup = new HashMap();
	ArrayList listCode1 = new ArrayList();
	ArrayList listCode2 = new ArrayList();
	ArrayList listCode3 = new ArrayList();
	public ChartRecordingAddGroupBean(){
		ArrayList<String> functionId=new ArrayList();
		functionId.add("VIEWGRAPH_FOR_PANEL");
		adapter.setSiteSpecific(functionId,"CA");
	}
	public HashMap getRecords() {
		return records;
	}

	public void setRecords(HashMap records) {
		this.records = records;
	}
	ArrayList listCode4 = new ArrayList();

	public void addRecords(String key, String value)
	{
		records.put(key,value);
		setRecords(records);
		

	}//end of addRecords

	public ArrayList retrieveRecords()
	{
		ArrayList keys = new ArrayList();
		Set mapKeySet = (Set)records.keySet();
		Iterator mapIter = mapKeySet.iterator();		
		while(mapIter.hasNext())
		{
			keys.add((String)mapIter.next());
		}

		return keys;
	}//end of retrieveRecords

	public HashMap getHashValues()
	{
		return records;
	}//end of getHashValues

	//Added BY Jyothi on 12/03/2010 to fix 18685
	public String getRecords(String key)
	{
		String value = (String)records.get(key);
		return value;
	}//end of getRecords

	public void removeRecord(String recKey)
	{
		records.remove(recKey);

	}//end of removeRecord

	public void clearBean()
	{
		records.clear();
	}

	public void addToArrayList1(int index, String code)
	{
		listCode1.add(index,code);
	}

	public ArrayList codeFromArrayList1()
	{
		return listCode1;
	}

	public void addToArrayList2(int index, String code)
	{
		listCode2.add(index,code);
	}

	public ArrayList codeFromArrayList2()
	{
		return listCode2;
	}

	public void addToArrayList3(int index, String code)
	{
		listCode3.add(index,code);
	}

	public ArrayList codeFromArrayList3()
	{
		return listCode3;
	}

	public void addToArrayList4(int index, String code)
	{
		listCode4.add(index,code);
	}

	public ArrayList codeFromArrayList4()
	{
		return listCode4;
	}

	public boolean chkContainsKey(String key)
	{
		if(records.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void addToHashMap(String key, ArrayList list)
	{
		listsForGroup.put(key,list);
	}

	public ArrayList returnLists(String key)
	{
		return (ArrayList) listsForGroup.get(key);
	}
	//IN058139 Start.
	public String getMinandMaxValues(ArrayList groupSet){	 //IN059226 String return type
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String disMsrMinValue = " ";
		String disMsrMaxValue = " ";
		String strQuery = "";
		StringBuffer sb = new StringBuffer();
		int count =0;
		
		try{
			
			for(int i=0; i< groupSet.size(); i++) {
				sb.append("'"+groupSet.get(i)+"'");
				if(i!=((groupSet.size())-1))
					sb.append(",");			
			}
			con = ConnectionManager.getConnection();
			strQuery= "SELECT Count(*) COUNT FROM AM_DISCR_MSR WHERE DISCR_MSR_ID IN ("+sb.toString()+") AND (NVL(MIN_VALUE,0) = 0 OR NVL(MAX_VALUE,0) = 0)";
			pstmt = con.prepareStatement(strQuery);
			
			rs = pstmt.executeQuery();
			if(rs.next())
				count= rs.getInt("COUNT");
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			
			if(count==0){
				strQuery = "SELECT MIN(MIN_VALUE) MIN_VALUE,MAX(MAX_VALUE) MAX_VALUE FROM AM_DISCR_MSR WHERE DISCR_MSR_ID IN ("+sb.toString()+")";
				
				pstmt = con.prepareStatement(strQuery);
				rs = pstmt.executeQuery();

				while (rs.next())
				{
					disMsrMinValue= rs.getString("MIN_VALUE")==null?" ":(String)rs.getString("MIN_VALUE");
					disMsrMaxValue= rs.getString("MAX_VALUE")==null?" ":(String)rs.getString("MAX_VALUE");
				}				

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}
		return disMsrMinValue+"|"+disMsrMaxValue+"|";  //IN059226
	}
	public String getMinMaxValues(String disMsrId){ //IN059226 String return type
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String disMsrMinValue = " ";
		String disMsrMaxValue = " ";
		String strQuery = "";
			
		try{

			
			con = ConnectionManager.getConnection();			
			strQuery = "SELECT MIN_VALUE,MAX_VALUE FROM AM_DISCR_MSR WHERE DISCR_MSR_ID =? ";
				
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,disMsrId);
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				disMsrMinValue= rs.getString("MIN_VALUE")==null?" ":(String)rs.getString("MIN_VALUE");
				disMsrMaxValue= rs.getString("MAX_VALUE")==null?" ":(String)rs.getString("MAX_VALUE");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}
		return disMsrMinValue+"|"+disMsrMaxValue+"|";	 //IN059226	
	}
	public String closeSQLObj(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{

				if(objectType.equalsIgnoreCase("ResultSet"))
				{
					ResultSet rs = (ResultSet)object;
					rs.close();
				}
				else if(objectType.equalsIgnoreCase("PreparedStatement"))
				{
					PreparedStatement pst = (PreparedStatement)object;
					pst.close();
				}
				else if(objectType.equalsIgnoreCase("Connection"))
				{
					Connection con = (Connection) object;
					con.close();
				}
			}
			catch(Exception se)
			{
				return se.toString();
			}
		}
		return "Object Closed.";
	}
	//IN058139 End.
	//IN069564 Start.
	public void reArrangeGroups(){
		System.out.println("I am in ChartRecordingAddGroupBean.java -->reArrangeGroups Function. ");
		ArrayList list = retrieveRecords();
		HashMap map = getHashValues();
		String keyForMap = "";
		String valueFromMap = "";
		String discrMsrDesc = "";
		String chkdUnchked = "";
		String datesValues = "";
		String units = "";
		String groupNo = "";
		StringTokenizer strToken = null;
		LinkedHashSet<String> selGroupList = new LinkedHashSet<String>();
		for(int i=0;i<list.size();i++){
			keyForMap = (String) list.get(i);
			valueFromMap = (String) map.get(keyForMap);
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			chkdUnchked = strToken.nextToken();			
			datesValues = strToken.nextToken();
			units = strToken.nextToken();
			groupNo = strToken.nextToken();  			
			selGroupList.add(groupNo);				
		}
		int selGroupCount = selGroupList.size();
		for(int i=0;i<list.size();i++){
			keyForMap = (String) list.get(i);
			valueFromMap = (String) map.get(keyForMap);
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			chkdUnchked = strToken.nextToken();			
			datesValues = strToken.nextToken();
			units = strToken.nextToken();
			groupNo = strToken.nextToken();  			
			if(selGroupCount==2){
				if(!"Group 1".equals(groupNo) ){
					addRecords(keyForMap,discrMsrDesc + "~" + chkdUnchked + "~" + datesValues + "~" + units+ " ~" + "Group 2");					
				}
			}else if (selGroupCount==3){
				if(!"Group 1".equals(groupNo) && !"Group 2".equals(groupNo) ){
					addRecords(keyForMap,discrMsrDesc + "~" + chkdUnchked + "~" + datesValues + "~" + units+ " ~" + "Group 3");					
				}
			}					
		}
		System.out.println("I am out ChartRecordingAddGroupBean.java -->reArrangeGroups Function. ");
	}
	//IN069564 End.
}//ens of class
