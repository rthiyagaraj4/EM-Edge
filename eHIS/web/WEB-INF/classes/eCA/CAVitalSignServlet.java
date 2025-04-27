/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/01/2019	IN069244		Ramya Maddena	25/01/2019		Ramesh Goli	   MMS-KH-CRF-0005.1
28/06/2020	IN072777		Ramesh G	01/07/2020	Ramesh Goli		AAKH-CRF-0097.2
31/05/2021  IN017999        Chandrashekar a                                AAKH-CRF-0132.1
19/10/2023    32779               Srinivasa N T                                 AAKH-CRF-0165
--------------------------------------------------------------------------------------------------------------------
*/package eCA ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang.StringUtils;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class CAVitalSignServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
			updateVitalSignRecord(request, response , out);
			
		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of CAVitalSignServlet.java"+e);//common-icn-0181
			e.printStackTrace();
		}
	}


	public void updateVitalSignRecord(HttpServletRequest request, HttpServletResponse response,PrintWriter out) throws SQLException, IOException
	{
		Connection con 	= null;
		String locale = "";
		PreparedStatement pstmt = null;	
		ResultSet rs=null;
		String error_value="";
		String errormsg="";
		
			try
			{
				con = ConnectionManager.getConnection(request); 	
				boolean isVitalSearchByBedNo = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VITAL_SEARCH_BY_BED");//Adding end for IN017999
							
				HttpSession session = request.getSession(false);
				java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
				locale = p.getProperty("LOCALE"); 
				String client_ip_address = p.getProperty("client_ip_address");
				
				String modifiedById = p.getProperty("login_user");
				String facilityId		= (String)session.getValue("facility_id");
				
				String Record = request.getParameter("Record")==null?"":request.getParameter("Record");
				String selectedChartDetails=""; //IN072777.
				String ackStatus="";
				if("Acknowledge".equals(Record)){
					ackStatus ="A";
					selectedChartDetails=request.getParameter("selectedChartDetails")==null?"":request.getParameter("selectedChartDetails"); //IN072777.
				}else if("Delete".equals(Record))
					ackStatus ="D";
				else
					ackStatus ="C";
					
				String encounterId	= request.getParameter("encounter_id")== null ? "" :request.getParameter("encounter_id");	
				String totalDiscrIds	= request.getParameter("totalDiscrIds")== null ? "" :request.getParameter("totalDiscrIds");
				String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
				String bed_no	    = request.getParameter("bed_no")== null ? "" :request.getParameter("bed_no");//Added for IN017999
				String patient_id	    = request.getParameter("patient_id")== null ? "" :request.getParameter("patient_id");//Added for IN017999
				String update_query ="";
				//IN072777 Start.				
				//String update_query = "UPDATE ca_encntr_discr_msr_tmp SET ack_status = ?, MODIFIED_BY_ID =?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE facility_id = ? AND encounter_id = ? AND discr_msr_id = ? AND test_observ_dt_tm = to_date(?,'DD/MM/YYYY HH24:MI:SS')";
				if(isVitalSearchByBedNo && !bed_no.equals("")){//Added if condition for IN017999
				   update_query = "UPDATE xh_encntr_discr_msr_tmp SET ack_status = ?,SELECTED_CHARTS=?, MODIFIED_BY_ID =?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE facility_id = ? AND bed_no = ? AND discr_msr_id = ? AND test_observ_dt_tm = to_date(?,'DD/MM/YYYY HH24:MI:SS')";
				//IN072777 End. //Table name changed from ca_encntr_discr_msr_tmp to xh_encntr_discr_msr_tmp for IN017999
				}else{
					update_query = "UPDATE xh_encntr_discr_msr_tmp SET ack_status = ?,SELECTED_CHARTS=?, MODIFIED_BY_ID =?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE facility_id = ? AND encounter_id = ? AND discr_msr_id = ? AND test_observ_dt_tm = to_date(?,'DD/MM/YYYY HH24:MI:SS')";//Table name changed from ca_encntr_discr_msr_tmp to xh_encntr_discr_msr_tmp for IN017999
				}
				pstmt = con.prepareStatement(update_query);
				String[] discrIds= totalDiscrIds.split(",");
				int totalRecords=0;			
				int [] result			= null;
				if(isVitalSearchByBedNo){//Added  for IN017999
					     updatePatientData(request,response);
					 }//Adding end for IN017999
                      //AAKH-CRF-0165--Start
				for(int i=0;i<discrIds.length;i++){
				
					String val = request.getParameter("MV"+discrIds[i]);
					String val2 = request.getParameter("CR"+discrIds[i]);
					String val3 = request.getParameter("C"+discrIds[i]);
					if("D".equals(graphMode) || "DT".equals(graphMode)){
						if("Y".equals(request.getParameter("C"+discrIds[i])== null ? "N" :request.getParameter("C"+discrIds[i]))){
							totalRecords++;
							String recordeDate = request.getParameter("CR"+discrIds[i]);
							pstmt.setString(1,ackStatus);
							pstmt.setString(2,selectedChartDetails);
							pstmt.setString(3,modifiedById);
							pstmt.setString(4,client_ip_address); 
							pstmt.setString(5,facilityId);
							pstmt.setString(6,facilityId);
						if(isVitalSearchByBedNo && !bed_no.equals(""))
							pstmt.setString(7,bed_no);
						else
							pstmt.setString(7,encounterId);
							pstmt.setString(8,val);
							pstmt.setString(9,recordeDate);
							pstmt.addBatch();
						}
					}else{
					int count = Integer.parseInt(request.getParameter("MV"+discrIds[i])== null ? "0" :request.getParameter("MV"+discrIds[i]));
					for(int j=0;j<count;j++){
						if("Y".equals(request.getParameter("C"+discrIds[i]+j)== null ? "N" :request.getParameter("C"+discrIds[i]+j))){
							totalRecords++;
							
							String recordeDate = request.getParameter("CR"+discrIds[i]+"_"+j);
							pstmt.setString(1,ackStatus);
							pstmt.setString(2,selectedChartDetails); //IN072777
							pstmt.setString(3,modifiedById);
							pstmt.setString(4,client_ip_address); 
							pstmt.setString(5,facilityId);
							pstmt.setString(6,facilityId);
						if(isVitalSearchByBedNo && !bed_no.equals(""))//Added if condition for IN017999
							pstmt.setString(7,bed_no);
						else
							pstmt.setString(7,encounterId);
							pstmt.setString(8,discrIds[i]);
							pstmt.setString(9,recordeDate);
							
							pstmt.addBatch();
							}
						}
					}
				}
				result = pstmt.executeBatch();
				//AAKH-CRF-0165--End
				if( totalRecords==0){
					errormsg = "Atleast Select Anyone Record To Proceed";
					out.println("<script language=\"javascript\">");
					out.println("alert('"+errormsg+"')");
					out.println("</script>");
				}
				else if(totalRecords==(result.length)){
					con.commit();
					error_value = "1";
					errormsg = "APP-SM0001 Operation Completed Successfully ....";
					out.println("<script language=\"javascript\">");
					out.println("alert('"+errormsg+"')");
					out.println("</script>");
					if(graphMode.equals("T") || graphMode.equals("DT") ){
					out.println("<script>top.content.workAreaFrame.TaskListRightFrame.TaskListRightResultFrame.VitalSignFrame.location.reload();");
					out.println("</script>");
					}
					else
					{
						out.println("<script>top.content.workAreaFrame.TaskListRightFrame.TaskListRightResultFrame.VitalSignDetals.location.reload();");
						out.println("</script>");
					}
				}else{
					con.rollback();
				}			
		}
		catch(Exception m){
			m.printStackTrace();		
		}
		finally
		{
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();
			if(con != null)	con.close();		
		}
	}
//Adding start for IN017999
	public void updatePatientData(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{

		Connection con 	= null;
		String locale = "";
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs=null;
		try
			{
				con = ConnectionManager.getConnection(request); 
							
				HttpSession session = request.getSession(false);
				java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
				locale = p.getProperty("LOCALE"); 
				String client_ip_address = p.getProperty("client_ip_address");
				
				String modifiedById = p.getProperty("login_user");
				String facilityId		= (String)session.getValue("facility_id");
				
				String Record = request.getParameter("Record")==null?"":request.getParameter("Record");
				
				String selectedChartDetails=""; //IN072777.
				
				
					
				String encounterId	= request.getParameter("encounter_id")== null ? "" :request.getParameter("encounter_id");	
				String totalDiscrIds	= request.getParameter("totalDiscrIds")== null ? "" :request.getParameter("totalDiscrIds");
				String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
				String bed_no	    = request.getParameter("bed_no")== null ? "" :request.getParameter("bed_no");//Added for IN017999
				String patient_id	    = request.getParameter("patient_id")== null ? "" :request.getParameter("patient_id");//Added for IN017999
				String update_patient_data ="";
				String patient_class ="";

				String sql ="SELECT PATIENT_CLASS FROM PR_ENCOUNTER WHERE FACILITY_ID =? AND PATIENT_ID =? AND ENCOUNTER_ID =?";
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setString(1,facilityId);
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,encounterId);
				rs = pstmt1.executeQuery();
				try
				{
					if(rs!=null && rs.next())
					{
						patient_class=rs.getString("PATIENT_CLASS");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				finally
				{
					if(rs!=null)rs.close();
					if(pstmt1!=null)pstmt1.close();
				}
				    
				if(!bed_no.equals("")){
				    update_patient_data ="UPDATE xh_encntr_discr_msr_tmp SET PATIENT_ID=?,ENCOUNTER_ID=?,PATIENT_CLASS =? WHERE facility_id = ? AND bed_no = ? AND discr_msr_id = ? AND test_observ_dt_tm = to_date(?,'DD/MM/YYYY HH24:MI:SS')";
				}else{
					update_patient_data ="UPDATE xh_encntr_discr_msr_tmp SET PATIENT_ID=?,ENCOUNTER_ID=?,PATIENT_CLASS =? WHERE facility_id = ? AND patient_id = ? AND discr_msr_id = ? AND test_observ_dt_tm = to_date(?,'DD/MM/YYYY HH24:MI:SS')";
				}

				System.err.println("patient_id==="+patient_id+"encounterId==="+encounterId+"patient_class=="+patient_class);
				pstmt = con.prepareStatement(update_patient_data);
				String[] discrIds= totalDiscrIds.split(",");
				int totalRecords=0;			
				int [] result			= null;
				for(int i=0;i<discrIds.length;i++){
					String val = request.getParameter("MV"+discrIds[i]);
					String val2 = request.getParameter("CR"+discrIds[i]);
					String val3 = request.getParameter("C"+discrIds[i]);
					if("D".equals(graphMode) || "DT".equals(graphMode)){
						if("Y".equals(request.getParameter("C"+discrIds[i])== null ? "N" :request.getParameter("C"+discrIds[i]))){
							totalRecords++;
							String recordeDate = request.getParameter("CR"+discrIds[i]);
							pstmt.setString(1,patient_id);
							pstmt.setString(2,encounterId);
							pstmt.setString(3,patient_class);
							pstmt.setString(4,facilityId);
						if(!bed_no.equals(""))
							pstmt.setString(5,bed_no);
						else
							pstmt.setString(5,patient_id);
							pstmt.setString(6,discrIds[i]);
							pstmt.setString(7,recordeDate);
							pstmt.addBatch();
						}
					}else{
				
					int count = Integer.parseInt(request.getParameter("MV"+discrIds[i])== null ? "0" :request.getParameter("MV"+discrIds[i]));
					for(int j=0;j<count;j++){
						if("Y".equals(request.getParameter("C"+discrIds[i]+j)== null ? "N" :request.getParameter("C"+discrIds[i]+j))){
							
							String recordeDate = request.getParameter("CR"+discrIds[i]+"_"+j);
							   
  
								pstmt.setString(1,patient_id);
								pstmt.setString(2,encounterId);
								pstmt.setString(3,patient_class);
								pstmt.setString(4,facilityId);
							if(!bed_no.equals(""))
								pstmt.setString(5,bed_no);
							else
								pstmt.setString(5,patient_id);
								pstmt.setString(6,discrIds[i]);
								pstmt.setString(7,recordeDate);

								pstmt.addBatch();

						   }
							
						}
						}
					}
				result = pstmt.executeBatch();

					con.commit();
							
		}catch(Exception m){
			m.printStackTrace();
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
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();
			if(con != null)	con.close();
		}

	}//Adding end for IN017999
}