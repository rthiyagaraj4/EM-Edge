/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

import webbeans.eCommon.*;

public class AmbulanceManagementServlet extends HttpServlet{

	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);

	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		
		Connection con			=	null;
		/*String from_date		= request.getParameter("from_date");
		String to_date			= request.getParameter("to_date");*/

		try	{

			HttpSession session 	=	request.getSession(false);
			Properties prop			=	(java.util.Properties)session.getValue("jdbc");
			String facility_id		=	(String)session.getValue("facility_id");
            String ws_no			=	prop.getProperty("client_ip_address");
            String user				=	(String)session.getValue("login_user");
			String locale			=  prop.getProperty("LOCALE");
			String doAction			= request.getParameter("doAction");
			if(doAction==null)doAction="";
			boolean flag			=	false;
			String msg				=	"",msg1="";
			HashMap hsData			=	new HashMap();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			//RequestDispatcher rd =request.getRequestDispatcher("../eAE/jsp/AmbulanceManagementSystem.jsp");

			con = ConnectionManager.getConnection(request);


			if(doAction.equals("RecordB")){

				String ambId		=	request.getParameter("selAmbId");
				String currLocn		=	request.getParameter("txtCurrLocB");
				String periodfrom	=	request.getParameter("txtprdFromB");
				String period		=	request.getParameter("txtPeriodB");
				String periodtype	=	request.getParameter("txtPeriodType");
				String remarks		=	request.getParameter("txtRemarksB");
				String underrepair	=	request.getParameter("underRepairB");

				if(periodtype==null) periodtype="@";
				else if(periodtype.equals("")) periodtype="@";
								
				hsData.put("AMB_VEHICLE_ID",ambId);
				hsData.put("AMB_LOCATION",currLocn);
				hsData.put("SUSPEND_MAINT_DATE",periodfrom);
				hsData.put("SUSPEND_MAINT_PRD_VALUE",period);
				hsData.put("SUSPEND_MAINT_PRD_TYPE",periodtype.substring(0,1));
				hsData.put("SUSPEND_MAINT_REASON",remarks);
				hsData.put("SUSPEND_MAINT_YN",underrepair);
				hsData.put("MODIFIED_BY_ID",user);
				hsData.put("MODIFIED_AT_WS_NO",ws_no);
				hsData.put("FACILITY_ID",facility_id);
				hsData.put("RECORD_TYPE","B");

				flag=updateMaintDet(hsData,con);
			} else if(doAction.equals("RecordM")){

				String ambId		=	request.getParameter("selAmbId");
				String currLocn		=	request.getParameter("txtCurrLocM");
				/*String periodfrom	=	request.getParameter("txtprdFromM");
				String period		=	request.getParameter("txtPeriodM");
				String periodtype	=	request.getParameter("txtPeriodTypeM");
				String remarks		=	request.getParameter("txtRemarksM");*/
				String reovkeRepair	=	request.getParameter("RevokeRepairM");
								
				hsData.put("AMB_VEHICLE_ID",ambId);
				hsData.put("AMB_LOCATION",currLocn);
				hsData.put("SUSPEND_MAINT_DATE",null);
				hsData.put("SUSPEND_MAINT_PRD_VALUE",null);
				hsData.put("SUSPEND_MAINT_PRD_TYPE",null);
				hsData.put("SUSPEND_MAINT_REASON",null);
				hsData.put("SUSPEND_MAINT_YN",reovkeRepair);
				hsData.put("MODIFIED_BY_ID",user);
				hsData.put("MODIFIED_AT_WS_NO",ws_no);
				hsData.put("FACILITY_ID",facility_id);
				hsData.put("RECORD_TYPE","M");

				flag=updateMaintDet(hsData,con);
			} else if(doAction.equals("RecordA")){
				
				String caseno		=	request.getParameter("selCaseno");
				String distCovrd	=	request.getParameter("txtDistCovrdA")==null?"":request.getParameter("txtDistCovrdA");
				String endTime		=	request.getParameter("txtEndTimeA");
				//String reachedDestn	=   request.getParameter("ReachDropLocnA");
				String ambId		=	request.getParameter("selAmbId");
				String currLocn		=	request.getParameter("txtCurrLocA");
				String endMeter		=   request.getParameter("txtEndMeterA");

				//if(reachedDestn==null) reachedDestn="N";
				
				hsData.put("AMB_CASE_NO",caseno);
				hsData.put("AMB_DIST_COVERED",distCovrd);
				hsData.put("AMB_CASE_END_DATE",endTime);
				hsData.put("FACILITY_ID",facility_id);
				//hsData.put("reachedDestn",reachedDestn);
				hsData.put("AMB_END_MILEAGE",endMeter);
				hsData.put("AMB_VEHICLE_ID",ambId);
				hsData.put("AMB_LOCATION",currLocn);
				hsData.put("MODIFIED_BY_ID",user);
				hsData.put("MODIFIED_AT_WS_NO",ws_no);
				hsData.put("FACILITY_ID",facility_id);
				
				flag=updateLocationDet(hsData,con);
			}
			else 
			if  (doAction.equals("InsertRequest") || doAction.equals("ModifyRequest") ){

			String amb_nature_call_code	= 	checkForNull(request.getParameter("amb_nature_call_code"));
			String amb_priority_ind		= 	(String)(checkForNull(request.getParameter("Priority"),"L"));
			amb_priority_ind=(!amb_priority_ind.equals(""))?amb_priority_ind.substring(0,1):"L";
			String pickup_from_hosp_yn	= 	checkForNull(request.getParameter("Pickup_Location"));
			String pickup_locn_code		= 	checkForNull(request.getParameter("pickup_locn_code"));
			String pickup_locn_desc		= 	checkForNull(request.getParameter("pickup_locn_desc"));
			String pickup_address		= 	checkForNull(request.getParameter("Pickup_Address"));
			//String immdtly				= 	checkForNull(request.getParameter("immdtly"));
			String amb_case_booked_date	= 	request.getParameter("Pickup_Time");
			String destn_to_hosp_yn		= 	checkForNull(request.getParameter("Dropping_Locn"));
			String destn_address		= 	checkForNull(request.getParameter("Drop_Address"));
			String destn_locn_code		= 	checkForNull(request.getParameter("destn_locn_code"));
			String destn_locn_desc		= 	checkForNull(request.getParameter("Dropping_Location"));
			String patient_id			= 	checkForNull(request.getParameter("Patient_Id"));
			String patient_name			= 	checkForNull(request.getParameter("Patient_Name"));
			String sex					= 	(String)(checkForNull(request.getParameter("Gender"),""));
			if(!sex.equals("")) sex=sex.substring(0,1);
			String age					= 	checkForNull(request.getParameter("Age"));
			String escort_type_code		= 	checkForNull(request.getParameter("escort_type_code"));	
			String amb_case_recorded_by	= 	checkForNull(request.getParameter("amb_case_recorded_by"));
			String amb_caller_name		= 	checkForNull(request.getParameter("Requester_Name"));
			String amb_caller_contact_no= 	checkForNull(request.getParameter("Contact"));
			String amb_caller_remarks	= 	checkForNull(request.getParameter("Requester_Remarks"));
			//String Ambulance			= 	checkForNull(request.getParameter("Ambulance"));
			String amb_vehicle_id		= 	checkForNull(request.getParameter("amb_vehicle_id"));
			//String Ambulance_Type		= 	checkForNull(request.getParameter("Ambulance_Type"));
			String amb_service_type		= 	checkForNull(request.getParameter("amb_service_type"));
			String amb_start_mileage	= 	checkForNull(request.getParameter("Start_Mileage"));
			String amb_end_mileage		= 	checkForNull(request.getParameter("End_Mileage"));
			String amb_uom				= 	checkForNull(request.getParameter("amb_uom"));
			String age_uom				= 	checkForNull(request.getParameter("age_uom"),"Y");
			if(age_uom.equals(""))  age_uom="Y";
			String amb_exp_dist_covered = 	checkForNull(request.getParameter("Expected_Distance"));
			String amb_dist_covered		= 	checkForNull(request.getParameter("Distance_Covered"));
			String amb_case_start_date	= 	checkForNull(request.getParameter("Actual_Pickup_Time"));
			String amb_case_end_date	= 	checkForNull(request.getParameter("Actual_Drop_Time"));
			String amb_disp_remarks		=	checkForNull(request.getParameter("Dispatch_Remarks"));
			String amb_started_yn		=	checkForNull(request.getParameter("amb_started_yn"),"N");
			String unknown_pat_dtl_yn	=	(patient_name.equals("Unknown") ? "Y" : "N");
			String amb_case_status		=	(amb_started_yn.equals("Y") ? "A" : "R");
			String rsrc_allocated		=	checkForNull(request.getParameter("rsrc_allocated"));
			//String Resource				=	checkForNull(request.getParameter("Resource"));
			String amb_map_location		=	checkForNull(request.getParameter("Google_Map"));
			String trip_status_code		=	checkForNull(request.getParameter("trip_status_code"));
			int[] ageArr				=	getDOB(age,age_uom);
			String amb_case_cancelled_by = user;
			String amb_case_cancelled_date= checkForNull(request.getParameter("Trip_Status_Time"));
			String amb_case_completed_by = user;
			String amb_case_completed_date = checkForNull(request.getParameter("Trip_Status_Time"));
			String ambTripSheetNo = checkForNull(request.getParameter("ambTripSheetNo"));

			if (amb_case_status.equals("A"))
			{	
				if (trip_status_code.equals("C"))
				{
					amb_case_status = "C";
					amb_case_cancelled_by="";
					amb_case_cancelled_date = null;
				}
				
			}
				if (trip_status_code.equals("X"))
				{
					amb_case_status = "X";
					amb_case_completed_by="";
					amb_case_completed_date = null;
				}
				
			
			String[] rescources = rsrc_allocated.split("`");
			/* If the Age field contains only number - append the UOM*/
			if (ageArr[3]==0)
			{
				age = age + age_uom;
			}
  
				String amb_prefix_ind = "";
				String amb_user_prefix = "";
				String start_case_no = "";
				String next_case_no = "";
				String end_case_no = "";
				String amb_mileage_uom = "";
				String amb_dflt_dys_behind = "";
				String amb_dflt_dys_ahead = "";
				String print_trip_sheet_yn = "";
				String print_trip_sheet_comp_yn = "";
				String amb_year_prefix = "";
				boolean yearFlag = false;
				String amb_case_no = "";

				String year = "";
				
				int updated = 0;
				PreparedStatement pstmt = null;
				PreparedStatement pstmtBatch1 = null;
				PreparedStatement pstmtBatch2 = null;
				ResultSet rset = null;


			if(doAction.equals("InsertRequest")) 
			{
				String sql_query="select amb_prefix_ind, amb_user_prefix, start_case_no, next_case_no, end_case_no, amb_mileage_uom, amb_dflt_dys_behind, amb_dflt_dys_ahead, print_trip_sheet_yn, print_trip_sheet_comp_yn,to_char(sysdate,'YYYY') year,amb_year_prefix from	ae_amb_param_for_facility where facility_id = ?";
				StringBuffer queryStr = new StringBuffer("");
				pstmt	= con.prepareStatement(sql_query);
				pstmt.setString(1, facility_id);
				rset = pstmt.executeQuery();
				if (rset.next())
				{
					amb_prefix_ind = checkForNull(rset.getString("amb_prefix_ind"));
					amb_user_prefix = checkForNull(rset.getString("amb_user_prefix"));
					start_case_no = checkForNull(rset.getString("start_case_no"));
					next_case_no = checkForNull(rset.getString("next_case_no"));
					end_case_no = checkForNull(rset.getString("end_case_no"));
					amb_mileage_uom = checkForNull(rset.getString("amb_mileage_uom"));
					amb_dflt_dys_behind = checkForNull(rset.getString("amb_dflt_dys_behind"));
					amb_dflt_dys_ahead = checkForNull(rset.getString("amb_dflt_dys_ahead"));
					print_trip_sheet_yn = checkForNull(rset.getString("print_trip_sheet_yn"),"N");
					print_trip_sheet_comp_yn = checkForNull(rset.getString("print_trip_sheet_comp_yn"),"N");
					amb_year_prefix = checkForNull(rset.getString("amb_year_prefix"),"");
					year = rset.getString("year");
				}
				pstmt = null; rset = null;
				if(!year.equals(amb_year_prefix)){
					amb_year_prefix = year;
					yearFlag = true;
				}
				
				switch (amb_prefix_ind.charAt(0))
				{
					case 'F' :  // Based on Facility Id
								amb_case_no = facility_id+lpad(next_case_no,18,'0');
								break;
					case 'A' :  // Based on Ambulance Id	
								pstmt= con.prepareStatement("select next_case_no from ae_amb_vehicle where amb_vehicle_id = ? and facility_id =?");
								pstmt.setString(1, amb_vehicle_id);
								pstmt.setString(2, facility_id);
								rset = pstmt.executeQuery();
								if (rset.next()){
									next_case_no = checkForNull(rset.getString("next_case_no"));									
								}
								//pstmt = null; rset = null;
								if(pstmt!=null)pstmt.close();
								if(rset!=null)rset.close();
								
								amb_case_no = amb_vehicle_id+lpad(next_case_no,10,'0');
								
								break;
					case 'Y' :  // Based on Year
								amb_case_no = amb_year_prefix+lpad(next_case_no,16,'0');
								break;
					case 'U' :	// User Defined
								amb_case_no = amb_user_prefix+lpad(next_case_no,18,'0');
								break;
				}

				
				/* Insert into AE_AMB_CASE_REQUEST*/
				 queryStr.append("insert into ae_amb_case_request (facility_id,amb_case_no,amb_case_booked_date,amb_vehicle_id,amb_case_start_date,amb_case_end_date,patient_id,patient_name,date_of_birth,age,sex,pickup_from_hosp_yn,pickup_address,pickup_locn_code,pickup_locn_desc,destn_address,destn_locn_code,destn_locn_desc,amb_caller_name,amb_caller_contact_no,amb_caller_remarks,amb_nature_call_code,amb_priority_ind,amb_case_status,amb_start_mileage,amb_end_mileage,amb_disp_remarks,amb_uom,amb_dist_covered,destn_to_hosp_yn,amb_exp_dist_covered,amb_map_location,amb_case_recorded_by,escort_type_code,amb_started_yn,amb_service_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,unknown_pat_dtl_yn) values (?,?,to_date(nvl(?,to_char(sysdate,'dd/mm/rrrr hh24:mi')),'dd/mm/rrrr hh24:mi'),?,to_date(?,'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,to_date(calculate_date_of_birth(?,?,?),'dd/mm/rrrr'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");

//time_of_birth=to_date(?,'dd/mm/rrrr hh24:mi')                  
                    pstmt = con.prepareStatement(queryStr.toString());
					
                    pstmt.setString(1,facility_id);
					pstmt.setString(2,amb_case_no);
					pstmt.setString(3,amb_case_booked_date);
					pstmt.setString(4,amb_vehicle_id);
					pstmt.setString(5,amb_case_start_date);
					pstmt.setString(6,amb_case_end_date);
					pstmt.setString(7,patient_id);
					pstmt.setString(8,patient_name);
					pstmt.setInt(9,ageArr[0]);
					pstmt.setInt(10,ageArr[1]);
					pstmt.setInt(11,ageArr[2]);
					pstmt.setString(12,age);
					pstmt.setString(13,sex);
					pstmt.setString(14,pickup_from_hosp_yn);
					pstmt.setString(15,pickup_address);
					pstmt.setString(16,pickup_locn_code);
					pstmt.setString(17,pickup_locn_desc);
					pstmt.setString(18,destn_address);
					pstmt.setString(19,destn_locn_code);
					pstmt.setString(20,destn_locn_desc);
					pstmt.setString(21,amb_caller_name);
					pstmt.setString(22,amb_caller_contact_no);
					pstmt.setString(23,amb_caller_remarks);
					pstmt.setString(24,amb_nature_call_code);
					pstmt.setString(25,amb_priority_ind);
					pstmt.setString(26,amb_case_status);
					pstmt.setString(27,amb_start_mileage);
					pstmt.setString(28,amb_end_mileage);
					pstmt.setString(29,amb_disp_remarks);
					pstmt.setString(30,amb_uom);
					pstmt.setString(31,amb_dist_covered);
					pstmt.setString(32,destn_to_hosp_yn);
					pstmt.setString(33,amb_exp_dist_covered);
					pstmt.setString(34,amb_map_location);
					pstmt.setString(35,amb_case_recorded_by);
					pstmt.setString(36,escort_type_code);
					pstmt.setString(37,amb_started_yn);
					pstmt.setString(38,amb_service_type);
					pstmt.setString(39,user);
					pstmt.setString(40,ws_no);
					pstmt.setString(41,facility_id);
					pstmt.setString(42,user);
					pstmt.setString(43,ws_no);
					pstmt.setString(44,facility_id);
					pstmt.setString(45,unknown_pat_dtl_yn);

                    int inserted = pstmt.executeUpdate();
					if (inserted > 0) flag=true; else flag=false;

					
					
					if ( flag == true )
					{
						if (amb_prefix_ind.charAt(0)=='A')
						{
							pstmt= con.prepareStatement("update ae_amb_vehicle set next_case_no = nvl(next_case_no,0)+1 where facility_id = ? and amb_vehicle_id = ?");
							pstmt.setString(1, facility_id);
							pstmt.setString(2, amb_vehicle_id);
						}
						else if((amb_prefix_ind.charAt(0)=='Y') && (yearFlag))
						{
							pstmt= con.prepareStatement("update	ae_amb_param_for_facility set next_case_no =1,start_case_no=1 ,amb_year_prefix = ? where facility_id = ?");
							pstmt.setString(1, amb_year_prefix);
							pstmt.setString(2, facility_id);
							
						}
						else 
						{
							pstmt= con.prepareStatement("update	ae_amb_param_for_facility set next_case_no  =  nvl(next_case_no,0)+1  where facility_id = ?");
							pstmt.setString(1, facility_id);
						}
						updated=pstmt.executeUpdate();
						con.commit();
						
						if (updated > 0) flag=true; else flag=false;
						pstmt = null; updated = 0;
						//Insert into ae_AMB_REQUEST_EQUIP


					}
	
					
					//If Actual Start Date is entered then   Insert into  ae_AMB_OPEN_REQUEST
					if ( amb_started_yn.equals("Y") && flag == true )
					{
						try
						{
						pstmt	= con.prepareStatement("insert into ae_amb_open_request (facility_id, amb_vehicle_id, amb_case_no, amb_case_booked_date, amb_case_start_date, amb_current_location, added_by_id, added_at_ws_no, added_facility_id, modified_by_id, modified_at_ws_no, modified_facility_id, remarks,added_date,modified_date) values (?,?,?,to_date(nvl(?,to_char(sysdate,'dd/mm/rrrr hh24:mi')),'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,?,sysdate,sysdate)");
						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, amb_vehicle_id);
						pstmt.setString(3, amb_case_no);
						pstmt.setString(4, amb_case_booked_date); 
						pstmt.setString(5, amb_case_start_date);//contact_disply_yn
						pstmt.setString(6, null);				//amb_current_location
						pstmt.setString(7, user);
						pstmt.setString(8, ws_no);
						pstmt.setString(9, facility_id);
						pstmt.setString(10, user);
						pstmt.setString(11, ws_no);
						pstmt.setString(12, facility_id);
						pstmt.setString(13, null);	//remarks

						updated=pstmt.executeUpdate();
						con.commit();
						if (updated > 0) flag=true; else flag=false;
						//pstmt = null; 
						if(pstmt!=null)pstmt.close();
						updated = 0;

						}
						catch (Exception e)
						{
							e.printStackTrace();
							System.out.println("Error Inserting ae_amb_open_request : "+e);
						}

					}

					
				/* End of InsertRequest*/
			}
			else 
 			if(doAction.equals("ModifyRequest"))
			{

				String updateSql = "update  ae_amb_case_request set amb_case_booked_date = to_date(nvl(?,to_char(sysdate,'dd/mm/rrrr hh24:mi')),'dd/mm/rrrr hh24:mi') , amb_vehicle_id = ? ,  amb_case_start_date = to_date(?,'dd/mm/rrrr hh24:mi') ,  amb_case_end_date = to_date(?,'dd/mm/rrrr hh24:mi') ,  patient_id = ? ,  patient_name = ? ,  date_of_birth = to_date(calculate_date_of_birth(?,?,?),'dd/mm/rrrr') ,  age = ? ,  sex = ? ,  pickup_from_hosp_yn = ? ,  pickup_address = ? ,  pickup_locn_code = ? ,  pickup_locn_desc = ? ,  destn_address = ? ,  destn_locn_code = ? ,  destn_locn_desc = ? ,  amb_caller_name = ? ,  amb_caller_contact_no = ? ,  amb_caller_remarks = ? ,  amb_nature_call_code = ? ,  amb_priority_ind = ? ,  amb_case_status = ? ,  amb_start_mileage = ? ,  amb_end_mileage = ? ,  amb_disp_remarks = ? ,  amb_uom = ? ,  amb_dist_covered = ? ,  destn_to_hosp_yn = ? ,  amb_exp_dist_covered = ? ,  amb_map_location = ? ,  amb_case_recorded_by = ? ,  escort_type_code = ? ,  amb_started_yn = ? ,  amb_service_type = ? ,  added_by_id = ? ,  added_date = sysdate ,  added_at_ws_no = ? ,  added_facility_id = ? ,  modified_by_id = ? ,  modified_date = sysdate ,  modified_at_ws_no = ? ,  modified_facility_id = ? ,  unknown_pat_dtl_yn = ?,  amb_case_cancelled_by = ?,  amb_case_cancelled_date =to_date(?,'dd/mm/rrrr hh24:mi'),  amb_case_completed_by = ?,  amb_case_completed_date = to_date(?,'dd/mm/rrrr hh24:mi') where facility_id=? and amb_case_No=?";

				
				
				if(!amb_dist_covered.equals("") && amb_case_status.equals("C")){

					hsData.put("AMB_CASE_NO",ambTripSheetNo);
					hsData.put("AMB_DIST_COVERED",amb_dist_covered);
					hsData.put("AMB_CASE_END_DATE",amb_case_end_date);
					hsData.put("FACILITY_ID",facility_id);
					//hsData.put("reachedDestn",reachedDestn);
					hsData.put("AMB_END_MILEAGE",amb_end_mileage);
					hsData.put("AMB_VEHICLE_ID",amb_vehicle_id);
					hsData.put("AMB_LOCATION",null);
					hsData.put("MODIFIED_BY_ID",user);
					hsData.put("MODIFIED_AT_WS_NO",ws_no);
					hsData.put("FACILITY_ID",facility_id);
				
					flag=updateLocationDet(hsData,con);

					}else{
				
				
					pstmt = con.prepareStatement(updateSql.toString());

					pstmt.setString(1,amb_case_booked_date);
					pstmt.setString(2,amb_vehicle_id);
					pstmt.setString(3,amb_case_start_date);
					pstmt.setString(4,amb_case_end_date);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,patient_name);
					pstmt.setInt(7,ageArr[0]);
					pstmt.setInt(8,ageArr[1]);
					pstmt.setInt(9,ageArr[2]);
					pstmt.setString(10,age);
					pstmt.setString(11,sex);
					pstmt.setString(12,pickup_from_hosp_yn);
					pstmt.setString(13,pickup_address);
					pstmt.setString(14,pickup_locn_code.trim());
					pstmt.setString(15,pickup_locn_desc);
					pstmt.setString(16,destn_address);
					pstmt.setString(17,destn_locn_code);
					pstmt.setString(18,destn_locn_desc);
					pstmt.setString(19,amb_caller_name);
					pstmt.setString(20,amb_caller_contact_no);
					pstmt.setString(21,amb_caller_remarks);
					pstmt.setString(22,amb_nature_call_code);
					pstmt.setString(23,amb_priority_ind);
					pstmt.setString(24,amb_case_status);
					pstmt.setString(25,amb_start_mileage);
					pstmt.setString(26,amb_end_mileage);
					pstmt.setString(27,amb_disp_remarks);
					pstmt.setString(28,amb_uom);
					pstmt.setString(29,amb_dist_covered);
					pstmt.setString(30,destn_to_hosp_yn);
					pstmt.setString(31,amb_exp_dist_covered);
					pstmt.setString(32,amb_map_location);
					pstmt.setString(33,amb_case_recorded_by);
					pstmt.setString(34,escort_type_code);
					pstmt.setString(35,amb_started_yn);
					pstmt.setString(36,amb_service_type);
					pstmt.setString(37,user);
					pstmt.setString(38,ws_no);
					pstmt.setString(39,facility_id);
					pstmt.setString(40,user);
					pstmt.setString(41,ws_no);
					pstmt.setString(42,facility_id);
					pstmt.setString(43,unknown_pat_dtl_yn);
					pstmt.setString(44,amb_case_cancelled_by); 
					pstmt.setString(45,amb_case_cancelled_date);
					pstmt.setString(46,amb_case_completed_by);
					pstmt.setString(47,amb_case_completed_date);

					pstmt.setString(48,facility_id);
					pstmt.setString(49,ambTripSheetNo);


                     updated = pstmt.executeUpdate();
					if (updated > 0) flag=true; else flag=false;



			pstmt = con.prepareStatement("update ae_AMB_OPEN_REQUEST set amb_case_no=? where facility_id=? and amb_vehicle_id=? and amb_case_no=?");
            pstmt.setString(1,ambTripSheetNo);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,amb_vehicle_id);
			pstmt.setString(4,ambTripSheetNo);
			int uCount = pstmt.executeUpdate();

			
			

			if (uCount==0 &&  amb_started_yn.equals("Y")){
				pstmt	= con.prepareStatement("insert into ae_amb_open_request (facility_id, amb_vehicle_id, amb_case_no, amb_case_booked_date, amb_case_start_date, amb_current_location, added_by_id, added_at_ws_no, added_facility_id, modified_by_id, modified_at_ws_no, modified_facility_id, remarks,added_date,modified_date) values (?,?,?,to_date(nvl(?,to_char(sysdate,'dd/mm/rrrr hh24:mi')),'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,?,sysdate,sysdate)");

						pstmt.setString(1, facility_id);
						pstmt.setString(2, amb_vehicle_id);
						pstmt.setString(3, ambTripSheetNo);
						pstmt.setString(4, amb_case_booked_date); 
						pstmt.setString(5, amb_case_start_date);//contact_disply_yn
						pstmt.setString(6, null);				//amb_current_location
						pstmt.setString(7, user);
						pstmt.setString(8, ws_no);
						pstmt.setString(9, facility_id);
						pstmt.setString(10, user);
						pstmt.setString(11, ws_no);
						pstmt.setString(12, facility_id);
						pstmt.setString(13, null);	//remarks
						updated=pstmt.executeUpdate();
						con.commit();
			}



					if ( flag == true )
					{
						pstmt = con.prepareStatement("delete from ae_amb_request_resource where amb_case_no=? and amb_vehicle_id=? and facility_id=?");
						pstmt.setString(1,ambTripSheetNo);
						pstmt.setString(2,amb_vehicle_id);
						pstmt.setString(3,facility_id);
						int deleted = pstmt.executeUpdate();
					//	if (deleted > 0) flag=true; else flag=false;

						pstmt = con.prepareStatement("delete from ae_amb_request_equip where amb_case_no=? and amb_vehicle_id=? and facility_id=?");
						pstmt.setString(1,ambTripSheetNo);
						pstmt.setString(2,amb_vehicle_id);
						pstmt.setString(3,facility_id);
						deleted = pstmt.executeUpdate();
						//if (deleted > 0) flag=true; else flag=false;
						con.commit();
						pstmt = null;
					}

					amb_case_no=ambTripSheetNo;
			}
			}

						
						

			if ( amb_started_yn.equals("Y") && !amb_case_status.equals("C") )
					{

						try
						{



					/*	pstmt	= con.prepareStatement("insert into ae_amb_open_request (facility_id, amb_vehicle_id, amb_case_no, amb_case_booked_date, amb_case_start_date, amb_current_location, added_by_id, added_at_ws_no, added_facility_id, modified_by_id, modified_at_ws_no, modified_facility_id, remarks,added_date,modified_date) values (?,?,?,to_date(nvl(?,to_char(sysdate,'dd/mm/rrrr hh24:mi')),'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,?,sysdate,sysdate)");
System.out.println("pstmt : "+facility_id+amb_vehicle_id+amb_case_no+amb_case_booked_date+amb_case_start_date+pickup_locn_desc);						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, amb_vehicle_id);
						pstmt.setString(3, amb_case_no);
						pstmt.setString(4, amb_case_booked_date); 
						pstmt.setString(5, amb_case_start_date);//contact_disply_yn
						pstmt.setString(6, pickup_locn_desc);				//amb_current_location
						pstmt.setString(7, user);
						pstmt.setString(8, ws_no);
						pstmt.setString(9, facility_id);
						pstmt.setString(10, user);
						pstmt.setString(11, ws_no);
						pstmt.setString(12, facility_id);
						pstmt.setString(13, null);	//remarks
System.out.println("set string : ");
						updated=pstmt.executeUpdate();
						con.commit();
						System.out.println("Inserted PH_AMB_OPEN_REQUEST : "+updated);
						if (updated > 0) flag=true; else flag=false;
						pstmt = null; updated = 0;


                         */




						pstmtBatch1	= con.prepareStatement("insert into ae_amb_request_resource (facility_id, amb_case_no, amb_vehicle_id, amb_resource_id, remarks,added_by_id, added_at_ws_no, added_facility_id, modified_by_id, modified_at_ws_no, modified_facility_id,added_date,modified_date,amb_resource_type) values (?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate,?)");
						pstmtBatch2	= con.prepareStatement("insert into ae_amb_request_equip (facility_id, amb_case_no, amb_vehicle_id, amb_equipment_code, remarks, added_by_id, added_at_ws_no, added_facility_id, modified_by_id, modified_at_ws_no, modified_facility_id,added_date,modified_date) values (?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)");
				
						//Insert into ae_AMB_REQUEST_RESOURCE
						int resCnt = rescources.length;
						int i=1; // 0th record is empty
						String[] arr = new String[]{"",""};
						boolean eqpExists = false;
						boolean rscExists = false;

						

						while (i<resCnt)
						{
							arr = rescources[i].split("~");
							if (!arr[1].equals("Q") )
							{
//facility_id, amb_case_no, amb_vehicle_id, amb_equipment_code, remarks
									pstmtBatch1.setString(1, facility_id);
									pstmtBatch1.setString(2, amb_case_no);
									pstmtBatch1.setString(3, amb_vehicle_id); //amb_resource_id
									pstmtBatch1.setString(4, arr[0]); //amb_resource_id
									pstmtBatch1.setString(5, null);	//remarks
									pstmtBatch1.setString(6, user);
									pstmtBatch1.setString(7, ws_no);
									pstmtBatch1.setString(8, facility_id);
									pstmtBatch1.setString(9, user);
									pstmtBatch1.setString(10, ws_no);
									pstmtBatch1.setString(11, facility_id);
									pstmtBatch1.setString(12, arr[1]); //amb_resource_type
									pstmtBatch1.addBatch();
									rscExists = true;

							}
							else 
							{ 
									pstmtBatch2.setString(1, facility_id);
									pstmtBatch2.setString(2, amb_case_no);
									pstmtBatch2.setString(3, amb_vehicle_id); //amb_equipment_code
									pstmtBatch2.setString(4, arr[0]); //amb_equipment_desc
									pstmtBatch2.setString(5, null); //remarks
									pstmtBatch2.setString(6, user);
									pstmtBatch2.setString(7, ws_no);
									pstmtBatch2.setString(8, facility_id);
									pstmtBatch2.setString(9, user);
									pstmtBatch2.setString(10, ws_no);
									pstmtBatch2.setString(11, facility_id);
									pstmtBatch2.addBatch();
									eqpExists = true;
	
							}
							++i;
						}
						
						int rowsIns = 0;
						if (rscExists)
						{
						  int[] countRcs = pstmtBatch1.executeBatch();
						  for (int j=0; j<countRcs.length; j++) 
								rowsIns += countRcs[j];
						  con.commit();
						
						}
					
						if (eqpExists)
						{
							int[]countEqp = pstmtBatch2.executeBatch();
							for (int j=0; i<countEqp.length; j++) 
								rowsIns += countEqp[j];
							con.commit();
						}
						
						pstmtBatch1.close();
						pstmtBatch2.close();
						}
						catch (Exception e)
						{
							e.printStackTrace();
							System.out.println("Error Updating resources : "+e);
						}
					}


			}
			 else if(doAction.equals("saveSetting")){
				String tblStng		=	request.getParameter("tblStng");
				String id			=	request.getParameter("txtId");
				String desc			=	request.getParameter("txtDesc");
				String defaultYn	=	request.getParameter("hidDefault");

			

				hsData.put("APPL_USER_ID",user);
				hsData.put("USER_DEF_PAGE_ID",id);
				hsData.put("USER_DEFN_PAGE_DESC",desc);
				hsData.put("DEFAULT_YN",defaultYn);
				hsData.put("USER_DEFN_MAIN_PAGE",tblStng);
				hsData.put("ADDED_AT_WS_NO",ws_no);
				hsData.put("ADDED_FACILITY_ID",facility_id);
				hsData.put("locale",locale);
				msg1=insertTableSetting(hsData,con);
				//out.println("Inserted Successfully.");
				//response.sendRedirect("../eAE/jsp/AmbulanceManagementSystem.jsp");
			}else if(doAction.equals("prevNext")){
				//System.out.println(request.getContextPath()+"/eAE/jsp/Dummy.jsp");
			//	RequestDispatcher rd =getServletContext().getRequestDispatcher("/eAE/jsp/Dummy.jsp");
			//	rd.forward(request,response);
				return;
			}
			 hsData.clear();
			 if(flag){
				 java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				 msg = ((String) message.get("message"));
				 message.clear();
				 //msg="APP-SM0001 Operation Completed Successfully.";

			 }else {
				msg="APP-PH0080 Error On Updation";
			}
			
			 // rd.forward(request,response); 
			if(doAction.equals("saveSetting"))
				out.println(msg1);
			else{					
				out.println(msg);
			//response.sendRedirect("../eAE/jsp/AmbulanceManagementSystem.jsp?from_date="+java.net.URLEncoder.encode(from_date,"UTF-8")+"&to_date="+java.net.URLEncoder.encode(to_date,"UTF-8")+"&err_msg="+java.net.URLEncoder.encode(msg,"UTF-8"));
			//return;
			}			
		}catch(Exception e){
	
			e.printStackTrace();
			System.out.println("Exception in AmbulanceManagementServlet.java="+e);
			//response.sendRedirect("../eAE/jsp/AmbulanceManagementSystem.jsp?from_date="+java.net.URLEncoder.encode(from_date,"UTF-8")+"&to_date="+java.net.URLEncoder.encode(to_date,"UTF-8")+"&err_msg="+e.toString());
			return; 
		}finally {
			try{
		
				if( con!=null ){
					ConnectionManager.returnConnection(con, request);
					con=null;
				}
	
			}catch(Exception e){
				e.printStackTrace();
			}
		}

}

	private boolean updateMaintDet(HashMap map,Connection con) throws Exception{
				
		PreparedStatement pstmt = null;
        int updated = 0;
		boolean flag=false;
        String query="",query1="";

		String suspendMaintYn=(String)map.get("SUSPEND_MAINT_YN");
		if(suspendMaintYn==null) suspendMaintYn="";
		String record_type=(String)map.get("RECORD_TYPE");

        try{			
			query="UPDATE AE_AMB_VEHICLE SET AMB_LOCATION = ?, SUSPEND_MAINT_YN	= ? , SUSPEND_MAINT_REASON	= ?, SUSPEND_MAINT_DATE = TO_DATE(?,'DD/MM/RRRR HH24:MI'),SUSPEND_MAINT_PRD_VALUE = ?, SUSPEND_MAINT_PRD_TYPE  = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO	=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID  = ? AND AMB_VEHICLE_ID	= ?";

			query1="UPDATE	AE_AMB_VEHICLE SET	AMB_LOCATION = ?,  MODIFIED_BY_ID=?, MODIFIED_DATE= SYSDATE, MODIFIED_AT_WS_NO =?,	MODIFIED_FACILITY_ID =? WHERE FACILITY_ID  = ? AND  AMB_VEHICLE_ID = ?";

			if(suspendMaintYn.equals("Y")){

				pstmt	= con.prepareStatement(query);

				pstmt.setString(1,	(String)map.get("AMB_LOCATION"));
				pstmt.setString(2,	record_type.equals("B")?"Y":"N");
				pstmt.setString(3,	(String)map.get("SUSPEND_MAINT_REASON"));
				pstmt.setString(4,	(String)map.get("SUSPEND_MAINT_DATE"));
				pstmt.setString(5,	(String)map.get("SUSPEND_MAINT_PRD_VALUE"));
				pstmt.setString(6,	(String)map.get("SUSPEND_MAINT_PRD_TYPE"));
				pstmt.setString(7,	(String)map.get("MODIFIED_BY_ID"));
				pstmt.setString(8,	(String)map.get("MODIFIED_AT_WS_NO"));
				pstmt.setString(9,	(String)map.get("FACILITY_ID"));
				pstmt.setString(10,	(String)map.get("FACILITY_ID"));
				pstmt.setString(11,	(String)map.get("AMB_VEHICLE_ID"));
			}else{
				pstmt	= con.prepareStatement(query1);

				pstmt.setString(1,	(String)map.get("AMB_LOCATION"));
				pstmt.setString(2,	(String)map.get("MODIFIED_BY_ID"));
				pstmt.setString(3,	(String)map.get("MODIFIED_AT_WS_NO"));
				pstmt.setString(4,	(String)map.get("FACILITY_ID"));
				pstmt.setString(5,	(String)map.get("FACILITY_ID"));
				pstmt.setString(6,	(String)map.get("AMB_VEHICLE_ID"));
			}
			
		    updated=pstmt.executeUpdate();
            con.commit();

			if (updated > 0) flag=true; else flag=false;

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally {
			try{
			if( pstmt!=null ) pstmt.close(); 
				pstmt=null;
			}catch(Exception e){
				e.printStackTrace();	
				throw e;
			}
		}
        return flag;
	}

	private boolean updateLocationDet(HashMap map,Connection con) throws Exception{
				
		PreparedStatement pstmt = null;
        int updated = 0;
		boolean flag=false;
        String query="",query1="",query2="";

		try{			
			query="UPDATE AE_AMB_CASE_REQUEST SET AMB_CASE_STATUS = 'C' , AMB_CASE_END_DATE = TO_DATE(?,'DD/MM/RRRR HH24:MI') ,AMB_DIST_COVERED  = ?,AMB_END_MILEAGE=? WHERE FACILITY_ID = ? AND AMB_CASE_NO = ?";
			query1="DELETE FROM AE_AMB_OPEN_REQUEST  WHERE FACILITY_ID = ? AND AMB_CASE_NO = ?";
			query2="UPDATE	AE_AMB_OPEN_REQUEST SET	AMB_CURRENT_LOCATION = ?,  MODIFIED_BY_ID=?, MODIFIED_DATE= SYSDATE, MODIFIED_AT_WS_NO =?,	MODIFIED_FACILITY_ID =? WHERE FACILITY_ID  = ? AND  AMB_VEHICLE_ID = ?";


				if(!((String) map.get("AMB_DIST_COVERED")).equals("")){
					
					pstmt	= con.prepareStatement(query);

					pstmt.setString(1,	(String)map.get("AMB_CASE_END_DATE"));
					pstmt.setString(2,	(String)map.get("AMB_DIST_COVERED"));
					pstmt.setString(3,	(String)map.get("AMB_END_MILEAGE"));
					pstmt.setString(4,	(String)map.get("FACILITY_ID"));
					pstmt.setString(5,	(String)map.get("AMB_CASE_NO"));
                    updated=pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
				
					pstmt	= con.prepareStatement(query1);
					pstmt.setString(1,	(String)map.get("FACILITY_ID"));
					pstmt.setString(2,	(String)map.get("AMB_CASE_NO"));
					updated=pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();

					pstmt	= con.prepareStatement("Update ae_amb_vehicle set amb_last_mileage=? where AMB_VEHICLE_ID=? and FACILITY_ID=?");
					pstmt.setString(1,	(String)map.get("AMB_END_MILEAGE"));
					pstmt.setString(2,	(String)map.get("AMB_VEHICLE_ID"));
					pstmt.setString(3,	(String)map.get("FACILITY_ID"));
					updated=pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
				}else{

				pstmt	= con.prepareStatement(query2);

				pstmt.setString(1,	(String)map.get("AMB_LOCATION"));
				pstmt.setString(2,	(String)map.get("MODIFIED_BY_ID"));
				pstmt.setString(3,	(String)map.get("MODIFIED_AT_WS_NO"));
				pstmt.setString(4,	(String)map.get("FACILITY_ID"));
				pstmt.setString(5,	(String)map.get("FACILITY_ID"));
				pstmt.setString(6,	(String)map.get("AMB_VEHICLE_ID"));
               
				updated=pstmt.executeUpdate();
				}
				con.commit();

				if (updated > 0) flag=true; else flag=false;

		}catch(SQLException se ){
			try{
				con.rollback(); 
			}catch(Exception e){
				e.printStackTrace();	
				throw e;
			}
			se.printStackTrace();
		}	
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally {
			try{
			if( pstmt!=null ) pstmt.close(); 
				pstmt=null;
			}catch(Exception e){
				e.printStackTrace();	
				throw e;
			}
		}
        return flag;
	}


	private String insertTableSetting(HashMap map,Connection con) throws Exception {
		PreparedStatement pstmt = null;
        int updated = 0;
		boolean flag=false;
        String query="",query1="";

		try{			
			query="insert into AE_AMB_USER_DEFN_PAGE (APPL_USER_ID,USER_DEFN_PAGE_ID,USER_DEFN_PAGE_DESC,DEFAULT_YN,USER_DEFN_MAIN_PAGE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			query1="UPDATE AE_AMB_USER_DEFN_PAGE SET DEFAULT_YN='N' WHERE APPL_USER_ID=? AND DEFAULT_YN='Y'";

			 if(((String)map.get("DEFAULT_YN")).equals("Y")){
				pstmt	= con.prepareStatement(query1);
				pstmt.setString(1,	(String)map.get("APPL_USER_ID"));
				updated=pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
			 }

				pstmt	= con.prepareStatement(query);

				pstmt.setString(1,	(String)map.get("APPL_USER_ID"));
				pstmt.setString(2,	(String)map.get("USER_DEF_PAGE_ID"));
				pstmt.setString(3,	(String)map.get("USER_DEFN_PAGE_DESC"));
				pstmt.setString(4,	(String)map.get("DEFAULT_YN"));
				pstmt.setString(5,	(String)map.get("USER_DEFN_MAIN_PAGE"));
				pstmt.setString(6,	(String)map.get("APPL_USER_ID"));
				pstmt.setString(7,	(String)map.get("ADDED_AT_WS_NO"));
				pstmt.setString(8,	(String)map.get("ADDED_FACILITY_ID"));
				pstmt.setString(9,	(String)map.get("APPL_USER_ID"));
				pstmt.setString(10,	(String)map.get("ADDED_AT_WS_NO"));
				pstmt.setString(11,	(String)map.get("ADDED_FACILITY_ID"));

				updated=pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();

				con.commit();

				if (updated > 0) flag=true; else flag=false;

		}catch(SQLException se ){
			try{
				con.rollback(); 
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			//System.out.println("error code"+se.getErrorCode());
			se.printStackTrace();

			if(se.getErrorCode()==1){
				 java.util.Hashtable message = MessageManager.getMessage((String)map.get("locale"), "RECORD_EXISTS", "SM");
				 String returnMsg = ((String) message.get("message"));
				 message.clear();
				//return "APP-AE0079 ID Already Exists";
				return returnMsg;
			}else{
				return "APP-AE0080 Error On Updation";
			}

		}	
		catch(Exception e){
			e.printStackTrace();
			return "APP-AE0080 Error On Updation";
		}
		finally {
			try{
			if( pstmt!=null ) pstmt.close(); 
				pstmt=null;
			}catch(Exception e){
				e.printStackTrace();	
				throw e;
			}
		}
		 java.util.Hashtable message1 = MessageManager.getMessage((String)map.get("locale"), "RECORD_INSERTED", "SM");
		 String returnMsg1 = ((String) message1.get("message"));
		 message1.clear();
        //return "APP-SM0071 Operation Completed Successfully......";
        return returnMsg1;
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
 
	private String lpad(String str,int noPads, char padChar ){
		String finalStr = "";
		int padLength = noPads-str.length();
		for (int i=0;i<padLength ;++i )
				finalStr = finalStr+padChar;
		return(finalStr+str);
	}

	 private int[] getDOB(String ageStr, String age_uom){
		 if(ageStr.equals("")){
			 int []age= new int[]{0,0,0,1};
			 return age;
		 }
		String str = ageStr.toUpperCase();
		age_uom= age_uom.toUpperCase();
		int ageNum;
		int []age= new int[]{0,0,0,0};

		

		try
		{
			ageNum = Integer.parseInt(str);
			if (age_uom.charAt(0)=='Y')
				age[0] = ageNum;
			else if (age_uom.charAt(0)=='M')
				age[1] = ageNum;
			else if (age_uom.charAt(0)=='D')
				age[2] = ageNum;
		}
		catch (NumberFormatException nfe)
		{
			
			nfe.printStackTrace();

			try{
			int y=-1,m=-1,d=-1; 
			if (str.indexOf('Y')!=-1)
			{
				y = str.indexOf('Y');
				age[0] = Integer.parseInt(str.substring(0,y));
			}
			if (str.indexOf('M')!=-1)
			{	
				m = str.indexOf('M');
				age[1] = Integer.parseInt(str.substring(y+1,m));
			}
			if (str.indexOf('D')!=-1)
			{
				d = str.indexOf('D');
				age[2] = Integer.parseInt(str.substring(m+1,d));
			}
			age[3] = 1;
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
		return(age);
	}


	/*private ArrayList fetchVals(Connection con,String sql_query,String[] qryVals)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		pstmt	= con.prepareStatement(sql_query);

		int cnt = qryVals.length();
		int i = 0;
		while (i < cnt)
		{
			String [] arr = qryVals[i].split("~");
			if (arr[1].equals("I"))
				pstmt.setInt(i, qryVals[i]);
			else if (arr[1].equals("S"))
				pstmt.setString(i, qryVals[i]);
			++i;
		}
		//pstmt.setString(1, facility_id);
		rset = pstmt.executeQuery();
		if (rset.next())
	}
*/
} 
