/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;


import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  ChiefComplaintSplty implements java.io.Serializable
{
	ArrayList updatelist=new ArrayList();
	ArrayList loadupdatesp=new ArrayList();
	ArrayList splist=null;	
	ArrayList associateddata=new ArrayList();

	//loading the values based on index
	public ArrayList loadSpclIndex(String index,HttpServletRequest requset,String complnt_code){
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList splist=new ArrayList();
	HashMap htRecord=null;
	String code;
	String sp_desc;
	String SQL_QUERY="";
	String associate_yn="";
	String status="";
	ArrayList ldata=loaddata(requset,complnt_code);
	if(index.equals("OTH")){
			SQL_QUERY = "SELECT SPECIALITY_CODE CODE, LONG_DESC FROM am_speciality  WHERE UPPER(LONG_DESC) NOT BETWEEN UPPER('A%') AND UPPER('_Z%') ORDER BY 2";
		}else{
			SQL_QUERY ="SELECT SPECIALITY_CODE CODE, LONG_DESC FROM am_speciality  WHERE  UPPER(LONG_DESC) like upper(?) ORDER BY 2" ;
		}
		try{
		connection = ConnectionManager.getConnection(requset);
		pstmt = connection.prepareStatement(SQL_QUERY.toString());
		if(!(index.equals("OTH"))){
			pstmt.setString(1,index+"%");
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
				code		=	rs.getString("code");
				sp_desc		=	rs.getString("long_desc");
				associate_yn="N";
				status		="N";
				if(sp_desc == null || sp_desc.equals("null"))sp_desc="";

				htRecord					=	new HashMap();

				htRecord.put("code"			,	code);
				htRecord.put("sp_desc"	,	sp_desc);

				htRecord.put("valid"		,	"N");
				for(int i=0;i<ldata.size();i++){
					if(code.equals(ldata.get(i))){
						associate_yn="Y";
						status		="disabled";
					}
				}
				for(int i=0;i<updatelist.size();i++){
						if(code.equals(updatelist.get(i))){
						associate_yn="Y";
					}
				}

				htRecord.put("associate_yn" ,   associate_yn);
				htRecord.put("status"		,	status);
				splist.add(htRecord);
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(connection != null) ConnectionManager.returnConnection(connection);
		}

		return splist;

	}

	public ArrayList loadAssociate(String complnt_code,HttpServletRequest requset){

	Connection connection = null ;
	PreparedStatement pstmt=null;
	ArrayList loadspclt=new ArrayList();
	//loadupdatesp	   =new ArrayList();
	
	ResultSet rs=null;
	String code;
	String sp_desc;
	HashMap htRecord=null;
	String SQL_QUERY="SELECT SPECIALITY_CODE code,am_get_desc.am_speciality(SPECIALITY_CODE,'en',1) SPECIALITY_DESC FROM CA_CHIEF_COMPLAINT_SPLTY where CA_CHIEF_COMPLAINT like upper(?) order by SPECIALITY_DESC";
		
		try{
		connection = ConnectionManager.getConnection(requset);
		pstmt = connection.prepareStatement(SQL_QUERY);
		pstmt.setString(1,complnt_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			code		=	rs.getString("code");
			sp_desc		=	rs.getString("SPECIALITY_DESC");
			if(sp_desc == null || sp_desc.equals("null"))sp_desc="";
			htRecord					=	new HashMap();
			htRecord.put("code"			,	code);
			htRecord.put("sp_desc"	,	sp_desc);
			htRecord.put("associate_yn"	,   "Y");
			htRecord.put("status"		,   "N");
			htRecord.put("valid"		,   "N");
			loadspclt.add(htRecord);
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	if(associateddata.size()>0){
			for(int i=0;i<associateddata.size();i++){
				HashMap ht=new HashMap();
				HashMap htRecord1=new HashMap();
				ht=(HashMap)associateddata.get(i);
				htRecord1.put("code",ht.get("code"));
				htRecord1.put("sp_desc",ht.get("spec_desc"));
				htRecord1.put("associate_yn"	,   "Y");
				htRecord1.put("status"	,   "N");
				htRecord1.put("valid"	,   "Y");
				loadspclt.add(htRecord1);

			}
		}

		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(connection != null) ConnectionManager.returnConnection(connection);
		}
		return loadspclt;
	}

	public ArrayList loaddata(HttpServletRequest requset,String complnt_code){
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String code;
	splist=new ArrayList();
	String SQL_QUERY="SELECT SPECIALITY_CODE code FROM CA_CHIEF_COMPLAINT_SPLTY WHERE UPPER(CA_CHIEF_COMPLAINT) like upper(?) ";
		
		try{
		connection = ConnectionManager.getConnection(requset);
		pstmt = connection.prepareStatement(SQL_QUERY);
		pstmt.setString(1,complnt_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			code		=	rs.getString("code");
			splist.add(code);			
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(connection != null) ConnectionManager.returnConnection(connection);
		}
		return splist;

	}
	public void updatespclity(String sp_code,String checkvalue,String spec_desc){
		if(checkvalue.equals("Y")){
			HashMap validmap=new HashMap();
			validmap.put("code",sp_code);
			validmap.put("spec_desc",spec_desc);
			updatelist.add(sp_code);
			associateddata.add(validmap);
		}else if(checkvalue.equals("N")){
			for(int i=0;i<updatelist.size();i++){
				if(updatelist.get(i).equals(sp_code))
					updatelist.remove(i);
			}
		}
	}
	public void clearList(){
		updatelist.clear();
	}

	public void clearLoadList(){
		loadupdatesp.clear();
	}
	public ArrayList getList(){
		return updatelist;
	}

	public void updateassociatelist(String sp_code,String checkvalue){
		if(checkvalue.equals("N")){
			loadupdatesp.add(sp_code);
		}
		else if(checkvalue.equals("Y")){
			for(int i=0;i<loadupdatesp.size();i++)
				if(sp_code.equals(loadupdatesp.get(i)))
					loadupdatesp.remove(i);
		}
 }

	public ArrayList getloadupdtsp(){
		return loadupdatesp;
	}
	public ArrayList getAssociateddata(){
		return associateddata;
	}
		public void clearAssociateddata(){
		associateddata.clear();
	}

}

