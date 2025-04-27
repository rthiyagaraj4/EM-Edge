
<%
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29412     Dinesh T    AMS CRF
06/04/2015	  IN048704	  Nijitha S   HSA-CRF-0175 	
-----------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
05/10/2017	  IN063819		Krishna Gowtham	05/10/2017		Ramesh G			ML-MMOH-CRF-0805
23/10/2017	IN064342		Krishna Gowtham	23/10/2017		Ramesh G			GHL-CRF-0468.1
08/11/2017  IN065674		Krishna Gowtham	08/11/2017		Ramesh G			Patient List By Location Criteria Discharge 																				Date default loading issue
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
14/09/2020	IN074034		Ramesh Goli			14/09/2020		Ramesh G			GHL-CRF-0613.1						
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
14/07/2022  33870			Twinkle Shah    	21/07/2022		Ramesh G        	ML-MMOH-CRF-1763
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	// added by Arvind @ 27-11-08 

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
		//IN29412,starts
	
		//Connection connection 		= null;//CheckStyle Fix
		Connection con 		= null;//CheckStyle Fix
		//con = ConnectionManager.getConnection(request);//CheckStyle Fix
		Statement patIdLenStmt 	= null;
		ResultSet patIdLenRs = null;
		String patientLength="";
		PreparedStatement pstamt = null;//6451
		ResultSet rst=null;//6451
		
		String hideBedNoYN ="N"; //6451
		try
		{
			con = ConnectionManager.getConnection(request);//CheckStyle Fix
			patIdLenStmt = con.createStatement();
			patIdLenRs = patIdLenStmt.executeQuery(" SELECT PATIENT_ID_LENGTH FROM MP_PARAM ");
			//6451
			pstamt=con.prepareStatement("SELECT HIDE_BED_NO_LISTBYLOCA_YN FROM CA_PARAM");
			rst=pstamt.executeQuery();
			if(rst.next())
			{
				hideBedNoYN=rst.getString("HIDE_BED_NO_LISTBYLOCA_YN")==null ? "":rst.getString("HIDE_BED_NO_LISTBYLOCA_YN");
			}
			//6451
			while(patIdLenRs.next())
			{
				patientLength = patIdLenRs.getString("PATIENT_ID_LENGTH");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(patIdLenRs!=null)
					patIdLenRs.close();
				if(patIdLenStmt != null) 
					patIdLenStmt.close();
				if(pstamt!=null)//6451
					pstamt.close();
				if(rst!=null)//6451
					rst.close();
				//ConnectionManager.returnConnection(con);		//CheckStyle Fix
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		//IN29412,ends
%>
	
	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/PatListByLocation.js'></script> 
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>		
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		
	<%
			String toDate="";
			//Connection con = null;//CheckStyle Fix
		
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");
				String clinicianType="";
				String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
				String facilityId = (String) session.getValue("facility_id");
						if(facilityId == null) facilityId="";
				String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
				String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
				String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
				String locnType = request.getParameter("locationType")==null?"":request.getParameter("locationType"); //This value we r getting it from Home Page
				String default_sql = "";
				String login_user	= (String)session.getValue("login_user");
				String resp_id	= (String)session.getValue("responsibility_id");
				int Existance_Count = 0;
				StringBuffer default_query = new StringBuffer();
				PreparedStatement stmtsql = null;
				ResultSet rs = null;

				String sqlFilter = "";
				String column_id = "",value_type = "",	actual_value = "";
				String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
				String final_value = "";
				String field_desc = "";
				String ql_disbl = "";
				Boolean ql_flag = false;
				String ql_disbl_loc = "";
				HashMap map = new HashMap();
				String dispBedRow="display:none";//IN29412

				String date_ind = "", date_val = "", date_unit = "", date_ref = "";
				StringTokenizer strToken = null;
		String  practSpDefultLocYN="N"; //33870
				String locnHandle;
				if (Summary.equals("Summary"))
					locnHandle="parent";
				else
					locnHandle="top.content.workAreaFrame";
				
				//out.println("Summary="+Summary+"\n");
				//out.println(request.getQueryString());
				String selp = "";
				String seld = "";
				String vis_sel = "";
				String visitvalue = "S";
				String days_backward_visits = "";
				String days_backward_discharges = "";
				String days_backward_visits_pat_id = "";
				String days_backward_disch_pat_id = "";
				String fromvisitdate = "";
				String fromdischargedate = "";
				String establishrelnreqyn = "";
				String assign_confirm_referral_yn = "";//IN048704
				String tab_menu_yn ="";
				String strOPFlag ="N";
				String maxVisitDays = "";
				String maxDistDays = "";
				//IN063819 starts
				//RBU-KDAH-CRF-0001 Start.
				String bedSearchAllowed = "N";
				if(CommonBean.isSiteSpecific(con, "CA", "BED_NO_SEARCH_ALLOWED"))
					bedSearchAllowed = "Y";
				//RBU-KDAH-CRF-0001 End.
				Boolean past_visit_site = CommonBean.isSiteSpecific(con, "CA", "PAST_VISIT_DATE_RANGE");
				String past_visit_site_YN = "";
				Boolean bar_code_scan_site = CommonBean.isSiteSpecific(con, "AM", "BARCODE_SCANNING_APPLICABLE");//Added for IN072184
				boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
				String bar_code_scan_site_YN = "";
				//Adding start for IN072184
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
//Ading end for IN072184
				if(past_visit_site)
				{
					past_visit_site_YN = "Y";
				}
				else
				{
					past_visit_site_YN = "N";
				}
				/*
					 Added by Kishore kumar N on 08-07-2010
				*/
				/*String maxVisitDays ="2";
				String maxDistDays ="2";*/
				if(past_visit_site)
				{
					maxVisitDays	= "7";
					maxDistDays 	= "7";
				}
				else
				{
					maxVisitDays 	= "2";
					maxDistDays 	= "2";
				}
				//IN063819 Ends
				/* ends here.*/
				String pract_name = (String)session.getValue("practitioner_name");
				if (pract_name==null) pract_name="";
				String adm_prd_disp = "";

				if(locnType.equals("OP")||locnType.equals("EM"))
				{
				   adm_prd_disp = "display:none" ;
				}
				//con = ConnectionManager.getConnection(request);//CheckStyle Fix
				PreparedStatement pstmt = null;
				PreparedStatement stmtVt = null;
				ResultSet rset = null;
				ResultSet rsVt = null; 
				//IN064342 starts
				Boolean pre_dis_advc_prep_site = CommonBean.isSiteSpecific(con, "CA", "PRE_DIS_ADVC_PRE");
				String pre_dis_advc_prep_site_YN = "";
				if(pre_dis_advc_prep_site)
				{
					pre_dis_advc_prep_site_YN = "Y";
				}
				else
				{
					pre_dis_advc_prep_site_YN = "N";
				}
				//IN064342 ends

				if(ql_ref.equals("") && !default_yn.equals("N")&& locnType.equals(""))
				{

					default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'BY_LOCATION' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
					
					stmtsql = con.prepareStatement(default_sql);
				
					stmtsql.setString(1,login_user);
					stmtsql.setString(2,resp_id);
					stmtsql.setString(3,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}

					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					default_query.append("select A.QUICK_LINK_REF from ");
					if(Existance_Count>0)
						default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
					else
						default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
					default_query.append(" and OPTION_ID = 'BY_LOCATION' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y' ");
					
					stmtsql = con.prepareStatement(default_query.toString());
					if(Existance_Count>0)
						stmtsql.setString(1,login_user);
					else
						stmtsql.setString(1,resp_id);
					rs = stmtsql.executeQuery();

					if(rs.next())
					{
						ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
					}

					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();


				}
							
				if(!ql_ref.equals(""))
				{
					
					
					sqlFilter = "select a.COLUMN_ID, a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,ql_ref);
					rs = stmtsql.executeQuery();

					while(rs.next())
					{
						column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
						value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
						actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
						date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
						date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
						date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
						relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
						if(value_type.equals("A"))
							final_value = actual_value;
						else
						{
							if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
							{
								if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
								{
									final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
								}
								else
									final_value = "";
							}
							else
								final_value = relative_value;
						}

						map.put(column_id,final_value);

					}
					
					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();

				}

				String	patient_id_ql = "",unassigned_ql = "",return_from_invest_ql="",
						location_chk_ql="",checked_in_ql="",treat_invest_ql = "",
						patient_class_chk_ql = "",period_to_ql = "",period_from_ql = "",
						arrived_at_ns_ql = "",speciality_ql = "",cons_in_progress_ql = "",
						vs_recorded_ql = "",checked_out_ql = "",visit_type_ql = "",
						queue_status_ql = "",clinic_ql="",view_list_ql="",patient_class_ql="",
						attend_pract_ql = "",attend_pract_ql_desc = "",speciality_ql_desc = "" ,spl_code = "" , spl_desc = "" ,clinic_ql_desc = "",queueStatus_ql="" ,queueStatus1_ql="" ;
						


				if(!ql_ref.equals(""))
				{

					ql_flag = true ;

					field_desc = (String) map.get("PATIENT_ID") == null ? "" : (String) map.get("PATIENT_ID");
					if(!field_desc.equals("")){
						patient_id_ql = field_desc;
						
					}

					field_desc = (String) map.get("UNASSIGNED") == null ? "" : (String) map.get("UNASSIGNED");
					if(field_desc.equals("Y"))
						unassigned_ql = "checked";
					else if(field_desc.equals("N"))
						unassigned_ql = "";
					   
					field_desc = (String) map.get("RETURN_FROM_INVEST") == null ? "" : (String) map.get("RETURN_FROM_INVEST");
					if(field_desc.equals("Y"))
						return_from_invest_ql = "checked";
					else if(field_desc.equals("N"))
						return_from_invest_ql = "";
					
					if(!return_from_invest_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~06~" ;
							 queueStatus_ql = "06" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~06~" ;
							  queueStatus_ql = queueStatus_ql+",06" ;
						  }
							 
					  }



					field_desc = (String) map.get("LOCATION_CHK") == null ? "" : (String) map.get("LOCATION_CHK");
					if(field_desc.equals("Y"))
						location_chk_ql = "checked";
					else if(field_desc.equals("N"))
						location_chk_ql = "";

					field_desc = (String) map.get("CHECKED_IN") == null ? "" : (String) map.get("CHECKED_IN");
					if(field_desc.equals("Y"))
						checked_in_ql = "checked";
					else if(field_desc.equals("N"))
						checked_in_ql = "";

					if(!checked_in_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~01~" ;
							 queueStatus_ql = "01" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~01~" ;
							  queueStatus_ql = queueStatus_ql+",01" ;
						  }
							 
					  }

					field_desc = (String) map.get("TREAT_INVEST") == null ? "" : (String) map.get("TREAT_INVEST");
					if(field_desc.equals("Y"))
						treat_invest_ql = "checked";
					else if(field_desc.equals("N"))
						treat_invest_ql = "";

					if(!treat_invest_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~05~" ;
							 queueStatus_ql = "05" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~05~" ;
							  queueStatus_ql = queueStatus_ql+",05" ;
						  }
							 
					  }

					field_desc = (String) map.get("PATIENT_CLASS_CHK") == null ? "" : (String) map.get("PATIENT_CLASS_CHK");
					if(field_desc.equals("Y"))
						patient_class_chk_ql = "checked";
					else if(field_desc.equals("N"))
						patient_class_chk_ql = "";  

					 
					field_desc = (String) map.get("PERIOD_FROM") == null ? "" : (String) map.get("PERIOD_FROM");
					
					
					String currDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
					int noOfdays = 0;
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
						
						if(date_ind.equals("B"))
						period_from_ql = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
						period_from_ql = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);
									
					}


					field_desc = (String) map.get("PERIOD_TO") == null ? "" : (String) map.get("PERIOD_TO");
					
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
							
											
						if(date_ind.equals("B"))
						period_to_ql = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
						period_to_ql = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);
									
					}


					field_desc = (String) map.get("ARRIVED_AT_NS") == null ? "" : (String) map.get("ARRIVED_AT_NS");
					if(field_desc.equals("Y"))
						arrived_at_ns_ql = "checked";
					else if(field_desc.equals("N"))
						arrived_at_ns_ql = "";

					if(!arrived_at_ns_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~02~" ;
							 queueStatus_ql = "02" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~02~" ;
							  queueStatus_ql = queueStatus_ql+",02" ;
						  }
							 
					  }



					field_desc = (String) map.get("SPECIALITY") == null ? "" : (String) map.get("SPECIALITY");
					
					speciality_ql = field_desc;
			

				
					field_desc = (String) map.get("CONS_IN_PROGRESS") == null ? "" : (String) map.get("CONS_IN_PROGRESS");
					if(field_desc.equals("Y"))
						cons_in_progress_ql = "checked";
					else if(field_desc.equals("N"))
						cons_in_progress_ql = "";

					if(!cons_in_progress_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~04~" ;
							 queueStatus_ql = "04" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~04~" ;
							  queueStatus_ql = queueStatus_ql+",04" ;
						  }
							 
					  }

					field_desc = (String) map.get("VS_RECORDED") == null ? "" : (String) map.get("VS_RECORDED");
					if(field_desc.equals("Y"))
						vs_recorded_ql = "checked";
					else if(field_desc.equals("N"))
						vs_recorded_ql = "";
					
					if(!vs_recorded_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~03~" ;
							 queueStatus_ql = "03" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~03~" ;
							  queueStatus_ql = queueStatus_ql+",03" ;
						  }
							 
					  }

					field_desc = (String) map.get("CHECKED_OUT") == null ? "" : (String) map.get("CHECKED_OUT");
					if(field_desc.equals("Y"))
						checked_out_ql = "checked";
					else if(field_desc.equals("N"))
						checked_out_ql = "";

					if(!checked_out_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~07~" ;
							 queueStatus_ql = "07" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~07~" ;
							  queueStatus_ql = queueStatus_ql+",07" ;
						  }
					  }

					/*  VISIT_TYPE */
					field_desc = (String) map.get("VISIT_TYPE") == null ? "" : (String) map.get("VISIT_TYPE");
					if(!field_desc.equals("")){
						visit_type_ql = field_desc;
					}


					field_desc = (String) map.get("QUEUE_STATUS") == null ? "" : (String) map.get("QUEUE_STATUS");
					if(field_desc.equals("Y"))
						queue_status_ql = "checked";
					else if(field_desc.equals("N"))
						queue_status_ql = "";

					/* CLINIC 	*/
					field_desc = (String) map.get("CLINIC") == null ? "" : (String) map.get("CLINIC");
					
					if(!field_desc.equals("")){
						clinic_ql = field_desc;
					}
					

					field_desc = (String) map.get("VIEW_LIST") == null ? "" : (String) map.get("VIEW_LIST");
					if(!field_desc.equals("")){
						view_list_ql = field_desc;
						
					}

					field_desc = (String) map.get("PATIENT_CLASS") == null ? "" : (String) map.get("PATIENT_CLASS");
					if(!field_desc.equals("")){
						patient_class_ql = field_desc;
						
					}
					if(patient_class_ql.equals("IP")||patient_class_ql.equals("DC"))
					{
						ql_disbl ="disabled";
						adm_prd_disp ="";
						if("N".equals(hideBedNoYN))   //IN074034
						dispBedRow="display";//IN29412
						else
							dispBedRow="display:none";

					}
					else if(patient_class_ql.equals("OP")||patient_class_ql.equals("EM"))
					{
						ql_disbl ="";
						adm_prd_disp = "display:none";

					}

					/* ATTEND_PRACT */
					field_desc = (String) map.get("ATTEND_PRACT") == null ? "" : (String) map.get("ATTEND_PRACT");
					
					if(!field_desc.equals("")){
						attend_pract_ql = field_desc;
					}
											
						String practSPLQry ="Select PRIMARY_SPECIALITY_CODE  spl_code,AM_GET_DESC.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,'2') spl_desc from am_practitioner D where D.PRACTITIONER_ID = ? ";

						if(speciality_ql.equals("CURR_PRACT_SPLTY_CODE"))
						{

							pstmt = con.prepareStatement(practSPLQry);
							pstmt.setString(1,locale);
							pstmt.setString(2,ca_practitioner_id);
							rset = pstmt.executeQuery();
							
							if(rset.next())
							{
									spl_code			= rset.getString("spl_code")==null?"":rset.getString("spl_code");
									spl_desc			= rset.getString("spl_desc")==null?"":rset.getString("spl_desc");
							}

							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();
						}
		}else{  //33870 Start.
			String practdSPDefaultLocQry ="SELECT PRACT_LOC_DEFAULT_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID = ? ";
				
				pstmt = con.prepareStatement(practdSPDefaultLocQry);
				pstmt.setString(1,facilityId);
				rset = pstmt.executeQuery();
				
				if(rset.next())
				{
						practSpDefultLocYN			= rset.getString("PRACT_LOC_DEFAULT_YN")==null?"N":rset.getString("PRACT_LOC_DEFAULT_YN");
				}

				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			
			if("Y".equals(practSpDefultLocYN)){
				String practSPLQry ="Select PRIMARY_SPECIALITY_CODE  spl_code,AM_GET_DESC.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,'2') spl_desc from am_practitioner D where D.PRACTITIONER_ID = ? ";
				
				pstmt = con.prepareStatement(practSPLQry);
				pstmt.setString(1,locale);
				pstmt.setString(2,ca_practitioner_id);
				rset = pstmt.executeQuery();
				
				if(rset.next())
				{
						spl_code			= rset.getString("spl_code")==null?"":rset.getString("spl_code");
						spl_desc			= rset.getString("spl_desc")==null?"":rset.getString("spl_desc");
				}

				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				
			}
		}  //33870 End.
			
					if(!period_from_ql.equals("")&&!period_to_ql.equals(""))
					{
						if(!com.ehis.util.DateUtils.isBefore( period_from_ql, period_to_ql,  "DMY",locale))
						{
							period_from_ql ="";
							period_to_ql =  "";
						}
					}


				if(view_list_ql.equals("A"))
				{
					selp = "selected";
					visitvalue = "Z";
				}
				else if(view_list_ql.equals("S"))
				{
					seld = "selected";
				}
				else{
				
					if(clinicianType.equals("P")||ql_flag)
				{
					selp = "selected";
					visitvalue = "Z";
				}
				else
				{
					seld = "selected";
				}
				}

				try
				{			
							
				//String sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID  from ca_encntr_param ";
				//IN063819 Start
				//String sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";//IN048704
				String sql = "";
				if(past_visit_site){
					sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 7), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 7),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 7), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 7),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 7) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 7) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";
				}
				else{
					sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";
				}
				//IN063819 Ends
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,attend_pract_ql);
				pstmt.setString(2,locale);
				pstmt.setString(3,speciality_ql);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,locale);
				pstmt.setString(7,facilityId);
				pstmt.setString(8,locale);
				pstmt.setString(9,clinic_ql);
				pstmt.setString(10,ca_practitioner_id);
				pstmt.setString(11,facilityId);
				rset = pstmt.executeQuery();
				if(rset.next())
				{
						days_backward_visits_pat_id			= rset.getString("DAYS_BACKWARD_VISITS_PAT_ID")==null?"":rset.getString("DAYS_BACKWARD_VISITS_PAT_ID");
						//IN065674 Start
						//days_backward_disch_pat_id			= rset.getString("DAYS_BACKWARD_VISITS")==null?"":rset.getString("DAYS_BACKWARD_DISCH_PAT_ID");
						days_backward_disch_pat_id			= rset.getString("DAYS_BACKWARD_DISCH_PAT_ID")==null?"":rset.getString("DAYS_BACKWARD_DISCH_PAT_ID");
						//IN065674 Ends
						days_backward_visits			= rset.getString("DAYS_BACKWARD_VISITS")==null?"":rset.getString("DAYS_BACKWARD_VISITS");
						days_backward_discharges			= rset.getString("DAYS_BACKWARD_DISCHARGES")==null?"":rset.getString("DAYS_BACKWARD_DISCHARGES");
						fromvisitdate			= rset.getString("from_visit_date")==null?"":rset.getString("from_visit_date");
						fromdischargedate		= rset.getString("from_discharge_date")==null?"":rset.getString("from_discharge_date");
						establishrelnreqyn		= rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
						tab_menu_yn				=(rset.getString("tab_menu_yn")==null)?"":rset.getString("tab_menu_yn");
						attend_pract_ql_desc				=(rset.getString("performed_by_name")==null)?"":rset.getString("performed_by_name");
						speciality_ql_desc				=(rset.getString("spl_desc")==null)?"":rset.getString("spl_desc");
						clinic_ql_desc				=(rset.getString("clinic_ql_desc")==null)?"":rset.getString("clinic_ql_desc");
						assign_confirm_referral_yn =(rset.getString("ASSGN_CONF_REF_YN")==null)?"":rset.getString("ASSGN_CONF_REF_YN");//IN048704
						/*
							Added by Kishore kumar N on 08-07-2010
						*/
						//IN063819 Start
						/*maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"2":rset.getString("MAX_ALLOW_VISIT_DAYS");
						maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"2":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");*/
						if(past_visit_site)
						{
							maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"7":rset.getString("MAX_ALLOW_VISIT_DAYS");
							maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"7":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");
						}
						else
						{
							maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"2":rset.getString("MAX_ALLOW_VISIT_DAYS");
							maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"2":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");
						}
						//IN063819 Ends
						/*
							ends here.
						*/
				}
				if(speciality_ql.equals("CURR_PRACT_SPLTY_CODE"))
				{
					speciality_ql = spl_code;
					speciality_ql_desc = spl_desc;

				}else if(ql_ref.equals("")){  //33870 Start.
					if("Y".equals(practSpDefultLocYN)){
						speciality_ql = spl_code;
						speciality_ql_desc = spl_desc;
					}
				}  //33870 End.

				
				fromvisitdate		=	com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY","en",locale);
				fromdischargedate	=   com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY","en",locale);

				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();

				if (tab_menu_yn.equals("N"))
				{ 
					%>
					<script language=javascript>
					   // var rows="30%,*,8%";	
						//parent.myFrameSet.rows = rows;
								parent.document.getElementById("PatCriteriaFr").style.height="28vh";
								parent.document.getElementById("PatResultFr").style.height="60vh";
								parent.document.getElementById("colorRefframe").style.height="8vh";
					</script>
					<%
				}

				toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
	 %>
	
	</head>
	<body class='CONTENT' onLoad='defaultGroupBy();checkboxes();checkboxes1()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='PatCriteriaFrm' id='PatCriteriaFrm' onload="callmakeless()">
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding='0' cellspacing=0>
				<tr><td class ='columnheader' colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>
				<tr>
					<%	
						 String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class_lang_vw where LANGUAGE_ID=? and  patient_class in ('OP','IP','EM','DC') order by 2 ";
			  				

							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,locale);

							rset = pstmt.executeQuery();
					%>
						<%
										
										String display="";
							if(ql_flag && patient_class_ql.equals(""))
							{
								ql_disbl_loc = "selected";
							}
							else
							{
								ql_disbl_loc = "";

							}
						%>
					<td class='LABEL' colspan=1 width='25%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td width='25%'  class='fields'>
						<select name='locationType' id='locationType' onchange='locnTypeChange(this.value)' > 
						<option value='Z' <%=ql_disbl_loc%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			
							<% while (rset.next())
							{
											if(patient_class_ql.equals(rset.getString("PATIENT_CLASS")))
											{
												
												display=rset.getString("PATIENT_CLASS")+"    selected ";	
											}
											else
											{
												if(locnType.equals(rset.getString("PATIENT_CLASS"))&&!ql_flag)
												display=rset.getString("PATIENT_CLASS")+"    selected ";
											else
											{
												
												display=rset.getString("PATIENT_CLASS");
											
												if(display.equals("OP") && locnType.equals("") &&!ql_flag)
												{
													strOPFlag ="Y";
													display = display + "  selected";
													adm_prd_disp = "display:none" ;
												}
											}
											}

										out.println("<option value="+display+">"+rset.getString("SHORT_DESC")+"</option>");
							}	
							
							if(rset!=null)rset.close();
							if(pstmt != null)pstmt.close();

							if(strOPFlag.equals("Y"))
							{%>
								<script>
								var val = document.PatCriteriaFrm.locationType.value;
								setTimeout("locnTypeChange(val)",100);
							</script>
							<%}
							
							 %>
						</select>
					</td>

					
					
					<td class='LABEL'   id='locLed' width='25%'></td>
					
					<td  width='25%'  class='fields'>

						<!-- <select name='locationCode' id='locationCode' disabled id='locVal' onChange='changeLocnCode(this)'> 
							<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						</select> -->
						<%
							if(ql_ref.equals("")|| clinic_ql.equals(""))
							{
								clinic_ql = "*ALL";
							}
							else if(!ql_ref.equals("") && clinic_ql_desc.equals("")) //Added By Jyothi on 02/06/2010 to fix IN020967
								clinic_ql = "";
							
						%>
						<input type='text' name="locationDesc" id="locationDesc" disabled id='locVal' value="<%=clinic_ql_desc%>"  size='20' maxlength='20' 
						 onkeypress="" onBlur="getClinicCode1(this)"  />
						 <input type='button' class='button' value='?' id='src_butn'  name='search_ref'  onClick="getClinicCode()"/>
						<input type="hidden" name="locationCode" id="locationCode" value='<%=clinic_ql%>'/>


					</td>
					
					
					<%	if(!locnType.equals("")){ // this condition will be get fired when you are calling this page from Home Page%>
							<script language="JavaScript">
									
							</script>	
					<% }%>


					  <script language="JavaScript">						 
						document.getElementById('locLed').innerText='';//getLabel("Common.clinic.label","COMMON");
						document.getElementById('locVal').style.visibility='hidden';
						document.getElementById('src_butn').style.visibility='hidden';
						document.getElementById("locVal").disabled = false;
					</script> 
					</tr><tr>
					<td id=viewList class='LABEL' colspan=1 width ='25%'><fmt:message key="eCA.ViewList.label" bundle="${ca_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'  ><select name='viewList' id='viewList' onchange='enablePract(this)'>
								<option value='Z' <%=selp%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
								<option value='S' <%=seld%>><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
						</select>
					</td>
						 <%
					String PatIDLen  = "";
					String QIDLen	  = "";
					String QIDLegend = "";
					String nationID ="";
					String nationLen="";
		
					String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(a.alt_id1_type,?,'2') short_desc,a.NAT_ID_LENGTH,(select NAT_ID_PROMPT from  MP_PARAM_LANG where LANGUAGE_ID= ? ) NAT_ID_PROMPT from mp_param a" ;
					PreparedStatement stmtLen = con.prepareStatement(sqlLen);
					stmtLen.setString(1,locale);
					stmtLen.setString(2,locale);

					ResultSet rsetLen = null;
					rsetLen  = stmtLen.executeQuery();
					while(rsetLen.next())
					{
						PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
						nationID = (rsetLen.getString("NAT_ID_PROMPT")==null)?"0":rsetLen.getString("NAT_ID_PROMPT");
						nationLen =(rsetLen.getString("NAT_ID_LENGTH")==null)?"0":rsetLen.getString("NAT_ID_LENGTH");
					    QIDLen	   = (rsetLen.getString("ALT_ID1_LENGTH")==null)?"0":rsetLen.getString("ALT_ID1_LENGTH");
						QIDLegend  = (rsetLen.getString("short_desc")==null)?"0":rsetLen.getString("short_desc");
					}
					if(rsetLen !=null) rsetLen.close();
					if(stmtLen !=null)stmtLen.close();
				%>
					<td class='label'  width='25%' colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan=1> <input type='text'  name='patientId' id='patientId' value='' onkeydown ='barcodeScan(event,this)'
					onKeyPress='return CheckForSpecChars(event)'  onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type=button name=search id=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td><!-- onkeydown ='barcodeScan(event,this)' Added for IN072184 -->
					</tr>
					


					<tr>
					<td class='LABEL' colspan='1' width ='25%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'><input type='text'  name='pract' id='pract' value='<%=attend_pract_ql_desc%>'  onKeyPress='' onBlur='populatePract1(this)' size='20' maxlength='20'><input type='button' name='practSearch' id='practSearch' value='?' class='button' tabIndex="4" onClick="populatePract()"><input type="hidden" name="AttendPract" id="AttendPract" value='<%=attend_pract_ql%>'>
					</td>
					<td class='label' width='25%' colspan='1'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan='1'><input type='text'  name='specialty' id='specialty' value='<%=speciality_ql_desc%>'  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' tabIndex="4" onClick="getSpecialty()"><input type="hidden" name="specialty_code" id="specialty_code" value='<%=speciality_ql%>'></td>
					</tr>
			</table>
			<table  border='0' cellpadding='0' cellspacing=0 width='100%' style='display:none' id='moreCriteria' name='moreCriteria'  bordercolor=white>
					<tr >
					<td class='LABEL' width='25%' colspan=1><%=QIDLegend%></td>
					<td class='fields' width='25%'><input type='text' name='queueId' id='queueId' value=''  size='<%=QIDLen%>' maxlength='<%=QIDLen%>'onKeyPress='return CheckForSpecChars(event)' ></td>
									
					<td class='label'  width='25%' ><%=nationID%></td>
					<td class ='fields' width ='25%'  ><input class = 'fields' type='text' name='nationID' id='nationID' value=''   size='<%=nationLen%>' maxlength='<%=nationLen%>'onKeyPress='return CheckForSpecChars(event)' ></td>
					</tr>
					

					<tr>
					<td id=pa2 class='label' width='25%'><fmt:message key="eCA.PastVisits.label" bundle="${ca_labels}"/></td>
					<td class = 'fields'><input type="checkbox" name="past" id="past"  onClick="setVisitDate(this)"></td>
					<td id=frv2 class='label' width ='25%'>
						<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
						<td class ='fields' nowrap><input class = 'fields' id="from_date1"  type="text" name="from_date1" id="from_date1" size=10 maxlength=10 readOnly onBlur='validateDate(this,"V","DMY","<%=locale%>",from_date11);doDateCheckLoc(this,from_date11,"<%=toDate%>","DMY","<%=locale%>");' ><input type='image' src="../../eCommon/images/CommonCalendar.gif" name="cal_pv" id="cal_pv" onclick="return showCalendarValidate('from_date1');" >&nbsp;<B>-</B>&nbsp;
						<input class = 'fields' id="from_date11" type="text" name="from_date11" id="from_date11" size=10 maxlength=10 
						title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onBlur='doDateCheckLoc(from_date1,this,"<%=toDate%>","DMY","<%=locale%>");' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" name="cal_pv1" id="cal_pv1" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>'; onclick="return showCalendarValidate('from_date11');" >
						</td> 
				</tr>
						<script language=javascript>
								document.getElementById('cal_pv').disabled=true;
								document.getElementById('cal_pv1').disabled=true;
						</script>
				<tr>
						<td id=dis2  class='label'><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></td>
						<td class=fields><input type="checkbox" name="discharged" id="discharged" value='Y' onClick="setDischargeDate(this)"></td>
						<td id=frd2  class='label'>
							<fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
						<td id=frd22 class='fields' nowrap><input type="text" name="from_date2" id="from_date2" size=10 maxlength=10 readonly onBlur='validateDate(this,"D","DMY","<%=locale%>",from_date22);doDateCheckLoc(this,from_date22,"<%=toDate%>","DMY","<%=locale%>");' ><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_di" onclick="return showCalendarValidate('from_date2');">&nbsp;<B>-</B>&nbsp;
						
						<input type="text" name="from_date22" id="from_date22" size=10 maxlength=10 onBlur='doDateCheckLoc(from_date2,this,"<%=toDate%>","DMY","<%=locale%>");' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_di1"  onclick="return showCalendarValidate('from_date22');">
						</td>
				</tr>
						<script language=javascript>
								document.getElementById('cal_di').disabled=true;
								document.getElementById('cal_di1').disabled=true;
						</script>
				<tr id='wtl' style='<%=adm_prd_disp%>' >
					<td class='label'  width='25%' ><fmt:message key="eCA.AdmittedPeriod.label" bundle="${ca_labels}"/></td>
					<td  class='fields' colspan = '3' width='75%' >
				<input type="text" name="adm_fromdate"  size=10 maxlength=10  id='daysVal' value='<%=period_from_ql%>'  onBlur='CheckDate(this);doDateCheckLoc(this,adm_todate,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' id=adm_cal1  src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('adm_fromdate');">
					&nbsp;&nbsp;&nbsp;
					<input type="text" name="adm_todate" size=10 maxlength=10 id='daysVal1' value='<%=period_to_ql%>'  onBlur='CheckDate(this);doDateCheckLoc(adm_fromdate,this,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  id=adm_cal2 onclick="return  showCalendarValidate('adm_todate');">
					</td>
				</tr>
				<tr>
					<td colspan = 4>
					<table>
							<tr><td id=days >&nbsp;</td></tr>
							
					</table>
					</td>
				</tr>
				<tr>
					<td class='label' colspan='4'><b><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;&nbsp;<input type=checkbox name='QS' id='QS' onClick='checkAll(this)'  value='00' <%=ql_disbl%>></td> 
				</tr>
				<tr>
					<td  class=label width='25%'><fmt:message key="Common.CheckedIn.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='CI' id='CI'  value='01' onClick='appendStatus(this);'<%=checked_in_ql%> <%=ql_disbl%>></td>
					<td  class=label width='25%' ><fmt:message key="eCA.ArrivedatNS.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='AAN' id='AAN'  value='02' onClick='appendStatus(this);' <%=arrived_at_ns_ql%> <%=ql_disbl%>></td>
					<td  class=label width='25%' ><fmt:message key="eCA.VSRecorded.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='VS' id='VS'  value='03' onClick='appendStatus(this);'<%=vs_recorded_ql%> <%=ql_disbl%>></td>
					<td  class=label width='25%' ><fmt:message key="eCA.ConsInProgress.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='CIP' id='CIP'  value='04' onClick='appendStatus(this);'<%=cons_in_progress_ql%> <%=ql_disbl%>></td>
				</tr>
				<tr>
							<td  class=label width='25%' ><fmt:message key="Common.Treat/Invest.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='TI' id='TI'  value='05' onClick='appendStatus(this);' <%=treat_invest_ql%> <%=ql_disbl%> ></td>
							<td  class=label width='25%' ><fmt:message key="eCA.ReturnfromInvest.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='RFI' id='RFI'  value='06' onClick='appendStatus(this);'<%=return_from_invest_ql%> <%=ql_disbl%> ></td>
							<td  class=label width='25%' ><fmt:message key="Common.CheckedOut.label" bundle="${common_labels}"/>&nbsp;<input type=checkbox  name='CO' id='CO'  value='07' onClick='appendStatus(this);' <%=checked_out_ql%> <%=ql_disbl%> ></td>	
							<td >&nbsp;</td>
				</tr>
				<!--CRF changes starts-->
				<!--
				<tr>
					<td class='label' colspan='4'><b>Referral Patients</b>&nbsp;&nbsp;&nbsp;<input type=checkbox name='RP' id='RP' onClick='checkRPAll(this)'  value='N'></td> 
				</tr>
				<tr>
					<td  class=label width='25%'>On Visit Registration&nbsp;&nbsp;<input type=checkbox name='OVR' id='OVR'  value='N' onClick='checkRPField(this);' disabled ></td>
					<td  class=label width='25%' >On Consultation In Progress &nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='OCIP' id='OCIP'  value='N' onClick='checkRPField(this);' disabled ></td>
					<td  class=label width='25%' >Confirmed Bed Side Referral&nbsp;<input type=checkbox name='CBSR' id='CBSR'  value='N' onClick='checkRPField(this);' disabled ></td>
					<td  class=label width='25%' >Un Confirmed Bed Side Referral&nbsp;<input type=checkbox name='UCBSR' id='UCBSR'  value='N' onClick='checkRPField(this);' disabled></td>
				</tr>
				<tr>
					<td  class=label width='25%' >On Admission&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='OA' id='OA'  value='N' onClick='checkRPField(this);' disabled ></td>
					<td  class=label width='25%' >On Assign Practitioner&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='OAP' id='OAP'  value='N' onClick='checkRPField(this);' disabled ></td>
					<td  class=label width='25%' >&nbsp;</td>	
					<td class=label width='25%'  >&nbsp;</td>
				</tr>
         -->
				<!--CRF changes Ends-->
								
				</table>
				<table  border='0' cellpadding='0' cellspacing=0   width='100%' id='more1Criteria' >
				<tr>
					<td class=label width='25%'  ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					<td width='25%'  class='fields'>
							<select name='visitType' id='visitType' onchange='visitTypeChange(this.value)' > 
							<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<%

								String visit_qry = " select VISIT_TYPE_CODE, SHORT_DESC,VISIT_TYPE_IND from OP_VISIT_TYPE where FACILITY_ID = ? order by 2 " ;

								stmtVt = con.prepareStatement(visit_qry);
				
								stmtVt.setString(1,facilityId);
								
								rsVt = stmtVt.executeQuery();
								while(rsVt.next())
								{

								  if(visit_type_ql.equals(rsVt.getString("VISIT_TYPE_CODE")))
								  {
										vis_sel = "selected";
								  }
									else
								  {
										vis_sel = "";
								  }
									
									out.println("<option value="+rsVt.getString("VISIT_TYPE_CODE")+" "+vis_sel+" >"+rsVt.getString("SHORT_DESC")+"</option>");

								}

								if(rsVt!=null) rsVt.close();
								if(stmtVt!=null) stmtVt.close();
							
							%>

							</select>
					</td>
				<td  id='asOn' class='data' >&nbsp;</td>
				</tr>
				<tr id='bedRow' style='<%=dispBedRow%>'> <!--IN29412-->
				<td class='label'><fmt:message key="eCA.BedNo.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class='data'><input class='fields' type='text' name='bedNo' id='bedNo' id='bedNo' value='' maxlength='<%=patientLength%>' size='<%=patientLength%>'/></td>
				</tr><!--IN29412-->			
				
				<tr>
					<td class=label width ='25%' ><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class = 'fields' type='checkbox' name='unscheduled' id='unscheduled' value='Y' onClick='changeViewListValue(this)' <%=unassigned_ql%> <%=ql_disbl%>></input></td>	
					<td  class='label' colspan='1' width='25%'><b><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/><input type='checkbox' name='groupByEpisode' id='groupByEpisode' value='Y' checked <%=ql_disbl%> onclick='checkboxChk(this)' ></input>&nbsp;&nbsp;
					<fmt:message key="Common.Location.label" bundle="${common_labels}"/><input type='checkbox' name='groupByLocn' id='groupByLocn' value='Y' checked onclick='checkboxChk(this)'></input></td>
					<%if(isVirtualConsSDGSpec){%>
					<td   class=label width ='25%' ><fmt:message key="eCA.virtualConsultation.label" bundle="${ca_labels}"/></td>
					<td  class='data'  ><input type='checkbox' name='chkVirtualConsultation' id='chkVirtualConsultation' value='N'  onclick='checkVirtualCons(this)'></td>
					<%}else{%>
					<td  class='data' colspan=2 >&nbsp;</td>
					<%}%>
				</tr>

									
				<tr><td colspan='4'>&nbsp;</td></tr>	
					<tr><td colspan='2'>&nbsp;</td>
					<td align='right' colspan='2'> <!-- id='more2Criteria' -->
						<input type='button' class='button' name='search' id='search' id = 'searchID' onclick="strcon();disBtn(this);checkfields();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'></input> <!--ADDED CHECKFIELDS FUNCTION-->
						<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input>
						<input type="button" class='button' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")%>' name='more' onClick="makeVisible(this,'<%=tab_menu_yn%>');"></input>

					</td>
					
					
				</tr>			
				
				</table>
				<!-- added by arvind @ 27-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
				
			<input type="hidden" name='sortOrder' id='sortOrder' value='v'>
			<input type="hidden" name="from_visit_date" id="from_visit_date" value="<%=fromvisitdate%>">
			<input type="hidden" name="from_discharge_date" id="from_discharge_date" value="<%=fromdischargedate%>">
			<input type="hidden" name="establish_reln_req_yn" id="establish_reln_req_yn" value="<%=establishrelnreqyn%>">
			<input type="hidden" name="todaydate" id="todaydate" value="<%=toDate %>">
			<!-- Changes for Prevoius Next Functionality -->
			<input type="hidden" name="mode" id="mode" value="search">
			<!-- end of change-->
			<!-- added by ankur for saving the following values when sorting is done from fixed title bar -->
			<input type="hidden" name="order_by" id="order_by" value="">
			<input type="hidden" name="re_order" id="re_order" value="">
			<input type="hidden" name="anchor_id" id="anchor_id" value="">
			<input type="hidden" name="locn_type" id="locn_type" value="">
			<input type='hidden' name='queueStatus' id='queueStatus' value="<%=queueStatus_ql%>">
			<input type='hidden' name='queueStatus1' id='queueStatus1' value='<%=queueStatus1_ql%>'>
			<input type='hidden' name='frameProperty' id='frameProperty' value=''> 
			<input type='hidden' name='url' id='url' value=''> 
			<input type='hidden' value='<%=facilityId%>' name='facilityid' ></input>
			<input type='hidden' value='<%=ca_practitioner_id%>' name='ca_practitioner_id' ></input>
			<input type=hidden value='<%=locale%>' name='locale'>
			<input type=hidden value='<%=pract_name%>' name='pract_name'>
			<input type=hidden value='<%=Summary%>' name='Summary'>
			<input type=hidden value='<%=ql_ref%>' name='ql_ref'>
			<!--
			 Added by Kishore kumar N on 08-07-2010
			-->
			<input type=hidden value='<%=days_backward_disch_pat_id%>' name='days_backward_disch_pat_id'>	
			<input type=hidden value='<%=days_backward_visits_pat_id%>' name='days_backward_visits_pat_id'>	
			<input type=hidden value='<%=days_backward_visits%>' name='days_backward_visits'>	
			<input type=hidden value='<%=days_backward_discharges%>' name='days_backward_discharges'>	
			<input type=hidden value='<%=maxVisitDays%>' name='maxVisitDays'>	
			<input type=hidden value='<%=maxDistDays%>' name='maxDistDays'>	
			<input type=hidden value='<%=assign_confirm_referral_yn%>' name='assign_confirm_referral_yn'><!-- //IN048704 -->
			<!-- ends here. -->
			<input type=hidden name='past_visit_site_YN' id='past_visit_site_YN' value='<%=past_visit_site_YN%>'><!--IN063819-->
			<input type=hidden name='pre_dis_advc_prep_site_YN' id='pre_dis_advc_prep_site_YN' value='<%=pre_dis_advc_prep_site_YN%>'><!--IN064342-->
            <input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value='<%=bar_code_scan_site_YN%>'><!--Added for IN072184-->
            <input type='hidden' name='bar_code_scaned_YN' id='bar_code_scaned_YN' value=''><!--Added for IN072184-->
			<input type='hidden' name='hideBedNoYN' id='hideBedNoYN' value='<%=hideBedNoYN%>'/>
			<input type='hidden' name='bedSearchAllowed' id='bedSearchAllowed' value='<%=bedSearchAllowed%>'/>  <!-- RBU-KDAH-CRF-0001 -->
			<input type='hidden' id="virtualConsultation" name='virtualConsultation' id='virtualConsultation' value='N'/>  <!-- 51215 -->
		</form>
	<%	if(!locnType.equals("")){ // this condition will be get fired when you are calling this page from Home Page%>
			<script language="JavaScript">				
					var relnreqyn = '<%=establishrelnreqyn%>';
					var tab_menu_yn='<%=tab_menu_yn%>';
					var queueStatus=document.forms[0].queueStatus.value;

					var locTypefrmHomePage = '<%=locnType%>';					
					 locnTypeChange(locTypefrmHomePage);
					 var locnHandle = '<%=locnHandle%>';
					var locnRef=eval(locnHandle+".colorRefframe.location");					
					locnRef.href = '../jsp/CAPatColorReference.jsp?reln_req_yn='+relnreqyn+'&Summary=<%=Summary%>';
					
					locnRef = eval(locnHandle+".PatResultFr.location");
					locnRef.href = '../jsp/PatListByLocationResultMain.jsp?tab_menu_yn='+tab_menu_yn+'&locationType=<%=locnType%>&locationCode=*ALL&viewList=<%=visitvalue%>&groupByLocn=Y&groupByEpisode=Y&reln_req_yn='+relnreqyn+'&queueStatus=~01~,~02~,~03~,~04~,~05~,~06~&Summary=<%=Summary%>'+"&bedNo="+document.getElementById('bedNo').value+"&virtualConsultation_yn="+document.getElementById('virtualConsultation').value;//IN29412
				//	}
			</script>	
	<% }else{ %>
			<script language="JavaScript">
					var relnreqyn = '<%=establishrelnreqyn%>';
					var tab_menu_yn='<%=tab_menu_yn%>';
					var queueStatus=document.forms[0].queueStatus.value;
					parent.PatResultFr.location.href = '../../eCommon/html/blank.html';

					//top.content.workAreaFrame.PatResultFr.location.href = '../../eCommon/html/blank.html';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>
		<script>
			if(document.PatCriteriaFrm.viewList.value == 'S')
			{
				document.PatCriteriaFrm.pract.disabled = true;
				document.PatCriteriaFrm.practSearch.disabled = true;
				document.PatCriteriaFrm.AttendPract.value = '<%=ca_practitioner_id%>';
				document.PatCriteriaFrm.pract.value = '<%=pract_name%>';
			}

		</script>
		<% if(!ql_ref.equals("")){%>

		<script>
		
		if('<%=patient_class_ql%>'!=""){
			document.getElementById('locVal').style.visibility='visible';
			document.getElementById('src_butn').style.visibility='visible';
			document.forms[0].locationDesc.disabled = true;
			
		if('<%=patient_class_ql%>' == 'OP') 
		{
			document.getElementById('locLed').innerText=getLabel("Common.clinic.label","COMMON");
			document.forms[0].locationDesc.disabled = false;
		
		}else if('<%=patient_class_ql%>' == 'IP'){ 
			document.getElementById('locLed').innerText=getLabel("Common.nursingUnit.label","COMMON");
			document.getElementById("visitType").selectedIndex = 0;
			document.getElementById("visitType").disabled = true;
			document.forms[0].locationDesc.disabled = false;
		
		}else if ('<%=patient_class_ql%>'=='DC'){
			document.getElementById('locLed').innerText=getLabel("Common.DaycareUnit.label","COMMON");
			document.getElementById("visitType").selectedIndex = 0;
			document.getElementById("visitType").disabled = true;
			document.forms[0].locationDesc.disabled = false;
	
		}else if( '<%=patient_class_ql%>'=='EM'){
			document.getElementById('locLed').innerText=getLabel("Common.EmergencyUnits.label","COMMON");
			document.getElementById("visitType").selectedIndex = 0;
			document.getElementById("visitType").disabled = true;
			document.forms[0].locationDesc.disabled = false;
	
		}
		}
		else
		{
			document.getElementById("visitType").selectedIndex = 0;
			document.getElementById("visitType").disabled = true;
		}
		
		searchClick();

		</script>

		<%}%>
		
	</body>
</html>

<%
	map.clear();//Checkstyle fix
}
catch(Exception e)
{
	
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%> 


