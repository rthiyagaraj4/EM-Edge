/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
?           100				?				created
05/12/2017	IN065683		Ramesh G								After create vaccine category as age specific, System 																			automatically add this vaccine category in manage 																				immunization for all patients.
07/09/2023	    41654			Twinkle Shah				           Ramesh Goli             MMS-JU-CRF-0015.4											
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCA.VaccineForCategoryBean;

public class ScheduleCategServlet extends javax.servlet.http.HttpServlet	
{

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{ 

		//HttpSession session = request.getSession(false);
		PrintWriter out = null;
		Connection con = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		//Hashtable tabdata = new Hashtable();
		//Properties p;
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		//start 41654
		String editMode=request.getParameter("editMode")==null?"":request.getParameter("editMode");
		if("editSchedule".equals(editMode))
		{
			updateVaccinCateg(request,response,con);
		}
		else
		{
			insertVaccinCateg(request,response,con);
		}
		//end 41654
	}

	public void insertVaccinCateg(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");

		ArrayList arraylist_vaccin = new ArrayList();
		ArrayList arraylist_dose = new ArrayList();
		ArrayList arraylist_date = new ArrayList();
		//ArrayList arraylist_select = new ArrayList();

		Boolean insFlag = false;
		String categ_hdr_query ="";
		String categ_dtl_query ="";
		String selected_itm  ="";
		String vaccin_name  ="";
		String dose_no  ="";
		String freq_duration_type  ="";
		String freq_duration  ="";
		
		String vac_sch_ref ="";
		String patient_id ="";
		String vacc_categ_id ="";
		String initiating_encounter_id ="";
		//String initiating_facility_id ="";
		String scheduled_user_id ="";
		String sch_created_date ="";
		String sch_created_date1 ="";
		String sch_closed_date ="";
		String sch_status ="";
		//Boolean insStat = false ;
		String sStyle =	 "";
		String cnt =	 "";
		//String val123 ="";
		int count =0;
		int nInsStat =0;
		int [] nInsStat1			= null;
		//IN065683 Start.
		String specificAge ="N";
		String specAgeYear = "0";
		String specAgeMonth = "0";
		String specAgeDay = "0";
		//IN065683 End.
		//String temp1 = "";
		//int temp2 =100;
	String outPut1 = "";
	String outPut2 = ""; 
	//String outPut3 = "</BODY></html>";

	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";

		//vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		vacc_categ_id = request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");
		initiating_encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		//initiating_facility_id = request.getParameter("facilityid")==null?"":request.getParameter("facilityid");
		scheduled_user_id = request.getParameter("creating_user")==null?"":request.getParameter("creating_user");
		sch_created_date = request.getParameter("start_date")==null?"":request.getParameter("start_date");
		sch_closed_date = request.getParameter("sch_closed_date")==null?"":request.getParameter("sch_closed_date");
		sch_status = request.getParameter("sch_status")==null?"":request.getParameter("sch_status");
		cnt = request.getParameter("count")==null?"":request.getParameter("count");
		specificAge= request.getParameter("specificAge")==null?"N":request.getParameter("specificAge");
		count =Integer.parseInt(cnt);
		for(int i=0;i<count; ++i)
		{
		selected_itm = request.getParameter("select"+i)==null?"N":request.getParameter("select"+i);
		vaccin_name = request.getParameter("Vaccine_Name"+i)==null?"":request.getParameter("Vaccine_Name"+i);
		dose_no = request.getParameter("dose_no"+i)==null?"N":request.getParameter("dose_no"+i);
		freq_duration = request.getParameter("freq_duration"+i)==null?"":request.getParameter("freq_duration"+i);
		freq_duration_type = request.getParameter("freq_duration_type"+i)==null?"":request.getParameter("freq_duration_type"+i);
		       		
		if(selected_itm.equals("Y"))
			{
				arraylist_vaccin.add(vaccin_name);
				arraylist_dose.add(dose_no);
				//com.ehis.util.DateUtils.convertDate(begin_date_time,"DMYHM",locale,"en");
				//plusDate(String currDate, String format, String locale, int value, String interval)
				
				if("N".equals(specificAge)){ //IN065683
					if(freq_duration_type.equals("D"))  // for Days
						freq_duration_type ="d";				
					else if (freq_duration_type.equals("H"))  // for Hour
						freq_duration_type ="h";
					else if (freq_duration_type.equals("M")) // for Minute
						freq_duration_type ="m";
					else if (freq_duration_type.equals("W"))  // for Week
						freq_duration_type ="w";				
					else if (freq_duration_type.equals("L"))   // for Month
						freq_duration_type ="M";				
					else if (freq_duration_type.equals("Y"))  // for Year
						freq_duration_type ="Y";
					
					sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date,"DMYHM",locale,Integer.parseInt(freq_duration),freq_duration_type);
				//IN065683 Start.	
				}else{
					specAgeYear = request.getParameter("specAgeYear"+i)==null?"0":request.getParameter("specAgeYear"+i);
					specAgeMonth = request.getParameter("specAgeMonth"+i)==null?"0":request.getParameter("specAgeMonth"+i);
					specAgeDay = request.getParameter("specAgeDay"+i)==null?"0":request.getParameter("specAgeDay"+i);
					//sch_created_date1 = sch_created_date;//Below were commented by Dinesh T
					sch_created_date1 = sch_created_date;//Below were Added by Dinesh T
					
					if(!"0".equals(specAgeYear))
						//sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date,"DMYHM",locale,Integer.parseInt(specAgeYear),"Y");//Below were commented by Dinesh T
						sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeYear),"Y");//Below were added by Dinesh T
					if(!"0".equals(specAgeMonth))
						//sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date,"DMYHM",locale,Integer.parseInt(specAgeMonth),"M");//Below were commented by Dinesh T
						sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeMonth),"M");//Below were added by Dinesh T
					if(!"0".equals(specAgeDay))
						//sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date,"DMYHM",locale,Integer.parseInt(specAgeDay),"d");//Below were commented by Dinesh T		
						sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeDay),"d");//Below were added by Dinesh T
				}
				//IN065683 End.

				//IN065683, starts
				//Below were added by Dinesh T as the dates were not going in english format in the db
				if("N".equals(specificAge) && !"en".equals(locale))
					sch_created_date1 = com.ehis.util.DateUtils.convertDate(sch_created_date1,"DMYHM",locale,"en");	
				//IN065683, ends

				arraylist_date.add(sch_created_date1);
			}
		}
		try
		{
			categ_hdr_query ="INSERT INTO CA_IM_PAT_VAC_SCH_HDR ( VAC_SCH_REF, PATIENT_ID, VACC_CATEG_ID, INITIATING_ENCOUNTER_ID, INITIATING_FACILITY_ID, SCHEDULED_USER_ID, SCH_CREATED_DATE, SCH_CLOSED_DATE, SCH_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( CA_IM_PAT_VAC_SCH_HDR_SEQ.NEXTVAL,?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,? )";

			pstmt=con.prepareStatement(categ_hdr_query); 
			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,vacc_categ_id);
			pstmt.setString(3,initiating_encounter_id);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,scheduled_user_id);
			pstmt.setString(6,sch_created_date);
			pstmt.setString(7,sch_closed_date);
			pstmt.setString(8,sch_status);
			pstmt.setString(9,loginuserid);
			pstmt.setString(10,client_ip_address);
			pstmt.setString(11,facilityid);
			pstmt.setString(12,loginuserid);
			pstmt.setString(13,client_ip_address);
			pstmt.setString(14,facilityid);
			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

			//pstmt=con.prepareStatement("select CA_IM_PAT_VAC_SCH_HDR_SEQ.CURRVAL from dual "); 
			//rs=pstmt.executeQuery();

			//while(rs.next())
			//{
			//val123 = rs.getString(1);
			//}
			//if(rs != null) rs.close();

			if(nInsStat>0)
			{

				if(pstmt != null) pstmt.close();

				//for the updation of detail table starts

						
				categ_dtl_query=" Insert into CA_IM_PAT_VAC_SCH_DTL( VAC_SCH_REF ,VACCINE_ID, DOSE_NO	, SCHEDULE_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OUTCOME_CODE) values( CA_IM_PAT_VAC_SCH_HDR_SEQ.CURRVAL,?,?,to_date(?,'DD/MM/YYYY HH24:MI'),?,sysdate,?,?, ?, sysdate, ?,?,'A') ";

				pstmt=con.prepareStatement(categ_dtl_query); 

				for (int j=0;j<arraylist_vaccin.size();++j)
				{
					pstmt.clearParameters();
					//pstmt.setString(1,val123);
					pstmt.setString(1,(String)arraylist_vaccin.get(j));
					pstmt.setInt(2,(Integer.parseInt((String)arraylist_dose.get(j))));
					//pstmt.setString(3,sch_created_date);
					pstmt.setString(3,(String)arraylist_date.get(j));
					pstmt.setString(4,loginuserid);
					pstmt.setString(5,client_ip_address);
					pstmt.setString(6,facilityid);
					pstmt.setString(7,loginuserid);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facilityid);
					pstmt.addBatch();
				}
				nInsStat1 = pstmt.executeBatch();		
				//detail table ends
				for(int k=0; k< nInsStat1.length;++k )
				{
					if(nInsStat1[k]<0  && nInsStat1[k] != -2)
					{
						insFlag = false;
						break;
					}
					else
					{ 
						insFlag = true;
					}
				}
			
				if(insFlag)
				{ 		
					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;
					String ref_qry ="select CA_IM_PAT_VAC_SCH_HDR_SEQ.CURRVAL  vac_sch_ref from dual";
					pstmt1=con.prepareStatement(ref_qry);
					rs=pstmt1.executeQuery();
					while(rs.next()){
					vac_sch_ref= rs.getString("vac_sch_ref");
					}
					if(rs != null) rs.close();
					if(pstmt1 != null) pstmt1.close();

					//out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut3);
					//out.println("<script>alert('"+errorMsg+"')</script>");
					//out.println("<script>parent.window.returnValue='"+nInsStat+"'</script>");
					//out.println("<script>parent.window.close()</script>");
				}
				else
				{
					//con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;
				}
			}
		
		if(pstmt != null) pstmt.close();
		outPut2 = "<script>parent.parent.onSuccess('"+vac_sch_ref+"');</script>"+"</BODY></html>";
				
		out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		
		//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8")+"&err_value="+error_value);
		}
		catch(Exception e )
		{
			out.println("Exception in insertVaccinCateg method of  ScheduleCategServlet ...So Record Not inserted  : "+e.toString());
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	//start 41654
	public void updateVaccinCateg(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		ArrayList arraylist_vaccin = new ArrayList();
		ArrayList arraylist_dose = new ArrayList();
		ArrayList arraylist_date = new ArrayList();
		Boolean insFlag = false;
		Boolean delFlag = false;
		String categ_del_query ="";
		String categ_dtl_query ="";
		String selected_itm  ="";
		String vaccin_name  ="";
		String dose_no  ="";
		String freq_duration_type  ="";
		String freq_duration  ="";
		String vac_sch_ref ="";
		String sch_created_date ="";
		String sch_created_date1 ="";
		String sStyle =	 "";
		String cnt =	 "";
		int count =0;
		int [] nInsStat1			= null;
		int [] nDelStat1			= null;
		String specificAge ="N";
		String specAgeYear = "0";
		String specAgeMonth = "0";
		String specAgeDay = "0";
		String existVaccine="N";
		String outPut1 = "";
		String outPut2 = ""; 
	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";
	
		vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
		sch_created_date = request.getParameter("start_date")==null?"":request.getParameter("start_date");
		cnt = request.getParameter("count")==null?"":request.getParameter("count");
		specificAge= request.getParameter("specificAge")==null?"N":request.getParameter("specificAge");
		count =Integer.parseInt(cnt);
		try{
				categ_dtl_query=" Insert into CA_IM_PAT_VAC_SCH_DTL( VAC_SCH_REF ,VACCINE_ID, DOSE_NO	, SCHEDULE_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OUTCOME_CODE) values( ?,?,?,to_date(?,'DD/MM/YYYY HH24:MI'),?,sysdate,?,?, ?, sysdate, ?,?,'A') ";
				categ_del_query="DELETE FROM CA_IM_PAT_VAC_SCH_DTL WHERE VAC_SCH_REF=? AND VACCINE_ID=? AND DOSE_NO=?";
				pstmt=con.prepareStatement(categ_dtl_query);
				pstmt1=con.prepareStatement(categ_del_query);
			for(int i=0;i<count; ++i)
			{
				existVaccine =request.getParameter("existVaccine"+i)==null?"N":request.getParameter("existVaccine"+i);			
				selected_itm = request.getParameter("select"+i)==null?"N":request.getParameter("select"+i);
				vaccin_name = request.getParameter("Vaccine_Name"+i)==null?"":request.getParameter("Vaccine_Name"+i);
				dose_no = request.getParameter("dose_no"+i)==null?"N":request.getParameter("dose_no"+i);
				if("Y".equals(existVaccine) && "N".equals(selected_itm))
				{
					pstmt1.clearParameters();
					pstmt1.setString(1,vac_sch_ref);
					pstmt1.setString(2,vaccin_name);
					pstmt1.setString(3,dose_no);
					pstmt1.addBatch();
				}
				else if("N".equals(existVaccine) && "Y".equals(selected_itm))
				{
					freq_duration = request.getParameter("freq_duration"+i)==null?"":request.getParameter("freq_duration"+i);
					freq_duration_type = request.getParameter("freq_duration_type"+i)==null?"":request.getParameter("freq_duration_type"+i);
					if("N".equals(specificAge)){
						if(freq_duration_type.equals("D"))  // for Days
							freq_duration_type ="d";				
						else if (freq_duration_type.equals("H"))  // for Hour
							freq_duration_type ="h";
						else if (freq_duration_type.equals("M")) // for Minute
							freq_duration_type ="m";
						else if (freq_duration_type.equals("W"))  // for Week
							freq_duration_type ="w";				
						else if (freq_duration_type.equals("L"))   // for Month
							freq_duration_type ="M";				
						else if (freq_duration_type.equals("Y"))  // for Year
							freq_duration_type ="Y";
						
						sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date,"DMYHM",locale,Integer.parseInt(freq_duration),freq_duration_type);	
					}
					else
					{
						specAgeYear = request.getParameter("specAgeYear"+i)==null?"0":request.getParameter("specAgeYear"+i);
						specAgeMonth = request.getParameter("specAgeMonth"+i)==null?"0":request.getParameter("specAgeMonth"+i);
						specAgeDay = request.getParameter("specAgeDay"+i)==null?"0":request.getParameter("specAgeDay"+i);
						sch_created_date1 = sch_created_date;
						
						if(!"0".equals(specAgeYear))
							sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeYear),"Y");//Below were added by Dinesh T
						if(!"0".equals(specAgeMonth))
							sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeMonth),"M");//Below were added by Dinesh T
						if(!"0".equals(specAgeDay))
							sch_created_date1 = com.ehis.util.DateUtils.plusDate(sch_created_date1,"DMYHM",locale,Integer.parseInt(specAgeDay),"d");//Below were added by Dinesh T
					}
					if("N".equals(specificAge) && !"en".equals(locale))
							sch_created_date1 = com.ehis.util.DateUtils.convertDate(sch_created_date1,"DMYHM",locale,"en");	
						
					pstmt.clearParameters();
					pstmt.setString(1,vac_sch_ref);
					pstmt.setString(2,vaccin_name);
					pstmt.setInt(3,(Integer.parseInt(dose_no)));
					pstmt.setString(4,sch_created_date1);
					pstmt.setString(5,loginuserid);
					pstmt.setString(6,client_ip_address);
					pstmt.setString(7,facilityid);
					pstmt.setString(8,loginuserid);
					pstmt.setString(9,client_ip_address);
					pstmt.setString(10,facilityid);
					pstmt.addBatch();
				}
			}
			nDelStat1 = pstmt1.executeBatch();
			nInsStat1 = pstmt.executeBatch();

			for(int k=0; k< nInsStat1.length;++k )
			{
				if(nInsStat1[k]<0  && nInsStat1[k] != -2)
				{
					insFlag = false;
					break;						
				}
				else
				{ 
					insFlag = true;
				}
			}	
			for(int k=0; k< nDelStat1.length;++k )
			{
				if(nDelStat1[k]<0  && nDelStat1[k] != -2)
				{
					delFlag = false;
					break;						
				}
				else
				{ 
					delFlag = true;
				}
			}	
			if(insFlag || delFlag)
			{ 		
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1" ;					
			}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"NO_CHANGES_TO_UPDATE","CA");
				error_value = "0" ;
			}
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
			outPut2 = "<script>parent.parent.onSuccess('"+vac_sch_ref+"');</script>"+"</BODY></html>";				
			out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
		catch(Exception e )
		{
			out.println("Exception in insertVaccinCateg method of  ScheduleCategServlet ...So Record Not inserted  : "+e.toString());			
			e.printStackTrace();			
			try{
				con.rollback();				
			}catch(Exception eee){				
				eee.printStackTrace();
			}
		}
		finally
		{					
			if(con != null) ConnectionManager.returnConnection(con);				
		}
	}
//end 41654
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }

}
