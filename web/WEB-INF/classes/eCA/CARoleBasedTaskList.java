/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
26/10/2020	IN067210		SIVABAGYAM M	26/10/2020	RAMESH G	ML-MMOH-CRF-1144

--------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.*;//IN066806
//IN066304 starts
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
//IN066304 ends

import eCA.Common.CaAdapter;
public class CARoleBasedTaskList extends CaAdapter implements Serializable {
	
 private ArrayList<ArrayList<String>> taskList=new ArrayList<ArrayList<String>>();
private LinkedHashMap<String, ArrayList<ArrayList<String>>> map=new LinkedHashMap<String,ArrayList<ArrayList<String>>>();

	public LinkedHashMap<String, ArrayList<ArrayList<String>>> getMap() {
	return map;
}

public void setMap(LinkedHashMap<String, ArrayList<ArrayList<String>>> updatedMap) {
	this.map = updatedMap;
}

	public ArrayList<ArrayList<String>> getTaskList() {
	return taskList;
}

public void setTaskList(ArrayList<ArrayList<String>> taskList) {
	this.taskList = taskList;
}
	public void getSelectionList(Connection con,String facility_id,boolean isVitalSignDtls) throws SQLException
	{
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		PreparedStatement pStatment1 = null;
		ResultSet resultSet1 = null;
		ArrayList<ArrayList<String>> tasks1=new ArrayList<ArrayList<String>>();
		LinkedHashMap<String, ArrayList<ArrayList<String>>> updatemap=new LinkedHashMap<String,ArrayList<ArrayList<String>>>();
		
		int count=0;
	String countQuery=" select count(*) count from CA_ROLE_BASED_ACC_TASK_LIST where facility_id=?";
		pStatment1 = con.prepareStatement(countQuery.toString());
		pStatment1.setString(1, facility_id);
		resultSet1 = pStatment1.executeQuery();
		while(resultSet1.next()){
			count=Integer.parseInt(resultSet1.getString("count"));
		}
		if(resultSet1 != null) resultSet1.close();
		if(pStatment1 != null) pStatment1.close();
		try{
			 
			 if(count!=0){						
				 String paramQuery =  "SELECT a.PRACT_TYPE pract_type,b.DESC_SYSDEF pract_name,CA_TASK_LIST_MSPECI,CA_TASK_LIST_REGORD,CA_TASK_LIST_RESREP,CA_TASK_LIST_MEDADMN,CA_TASK_LIST_INT,CA_TASK_LIST_BLDCONS,CA_TASK_LIST_RECCONS,CA_TASK_LIST_VITAL,FACILITY_ID,ORDER_CATEGORY ORDER_CATEGORY FROM CA_ROLE_BASED_ACC_TASK_LIST a,am_pract_type b WHERE a.pract_type=b.pract_type and a.FACILITY_ID=? order by a.pract_type";
		      pStatment = con.prepareStatement(paramQuery.toString());
		       pStatment.setString(1, facility_id);
				resultSet = pStatment.executeQuery();
				while(resultSet.next())
				{
					ArrayList<String> task= new ArrayList<String>();
					//task.clear();	
					task.add(resultSet.getString("pract_type"));
					task.add(resultSet.getString("CA_TASK_LIST_MSPECI")==null?"Y":resultSet.getString("CA_TASK_LIST_MSPECI"));
					task.add(resultSet.getString("CA_TASK_LIST_REGORD")==null?"Y":resultSet.getString("CA_TASK_LIST_REGORD"));
					task.add(resultSet.getString("CA_TASK_LIST_RESREP")==null?"Y":resultSet.getString("CA_TASK_LIST_RESREP"));
					task.add(resultSet.getString("CA_TASK_LIST_MEDADMN")==null?"Y":resultSet.getString("CA_TASK_LIST_MEDADMN"));
					task.add(resultSet.getString("CA_TASK_LIST_INT")==null?"Y":resultSet.getString("CA_TASK_LIST_INT"));
					task.add(resultSet.getString("CA_TASK_LIST_BLDCONS")==null?"Y":resultSet.getString("CA_TASK_LIST_BLDCONS"));
					task.add(resultSet.getString("CA_TASK_LIST_RECCONS")==null?"Y":resultSet.getString("CA_TASK_LIST_RECCONS"));
					if(!isVitalSignDtls){
						task.add(resultSet.getString("CA_TASK_LIST_VITAL")==null?"N":resultSet.getString("CA_TASK_LIST_VITAL"));
					}else{
					task.add(resultSet.getString("CA_TASK_LIST_VITAL")==null?"Y":resultSet.getString("CA_TASK_LIST_VITAL"));
					}
					task.add(resultSet.getString("pract_name"));
					task.add(resultSet.getString("ORDER_CATEGORY")==null?"":resultSet.getString("ORDER_CATEGORY"));
					tasks1.add(task);
					
				}
			 }else{
					String PractQuery="select PRACT_TYPE pract_type,DESC_SYSDEF pract_name from am_pract_type order by pract_type";
				pStatment = con.prepareStatement(PractQuery.toString());
					resultSet = pStatment.executeQuery();
					while(resultSet.next())
					{
						ArrayList<String> task= new ArrayList<String>();
						task.add(resultSet.getString("pract_type"));
						task.add("Y");
						task.add("Y");
						task.add("Y");
						task.add("Y");
						task.add("Y");
						task.add("Y");
						task.add("Y");
						if(!isVitalSignDtls){
							task.add("N");
							}else{
								task.add("Y");
							}
						task.add(resultSet.getString("pract_name"));
						task.add("");
						tasks1.add(task);
						//index++;
					
					}
			 }
			 	updatemap.put(facility_id, tasks1);
				setTaskList(tasks1);
				setMap(updatemap);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}
		
	} 
	public LinkedHashMap<String,ArrayList<ArrayList<String>>> updateList(String chkYN,Integer index,Integer inner_index,String pract_id,String facility_id)
	{
		
		LinkedHashMap<String,ArrayList<ArrayList<String>>> updatingmap=getMap();
		ArrayList<String> temp2=new ArrayList<String>();
		ArrayList<ArrayList<String>> pract1=updatingmap.get(facility_id);
		for(int i=0;i<pract1.size();i++) {
			
			temp2=pract1.get(i);
			if(pract_id.equals(temp2.get(0)))
			{
				temp2.set(inner_index, chkYN);
				pract1.set(i,temp2);
				map.put(facility_id,pract1);
				setMap(map);
			}
		
	}
		return  map;
	}
	
}