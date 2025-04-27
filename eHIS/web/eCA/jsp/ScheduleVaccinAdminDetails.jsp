<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
29/11/2013		IN045200		Nijitha S	   ML-BRU-SCF-1154
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%> 
<html>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");	
	String userId=((String) session.getValue("login_user")).trim();
String query_string = request.getQueryString();
String vac_sch_ref ="";

String vacc_categ_id ="";
String status ="";
String patient_id ="";
String vaccine_id ="";
String vaccine_id1 ="";
String dose_no ="";
//String dose_no1 ="";
String short_desc ="";
String Vaccin_query ="";
String mode ="";
String batch_id ="";
String manufacturer ="";
String admin_site_id ="";
String outcome_code ="";
String schedule_date ="";
//String schedule_date1 ="";
String external_adm_yn ="";
String external_facility ="";
String administered_date ="";
String administered_by ="";
String CurrentDate ="";
String remarks ="";
String disbl ="";
String disbl_all ="";
String sel ="";
String Dob ="";
String site_id_new ="";
String site_id_desc ="";
String site_default_yn ="";
String SiteName_query ="";
String encounter_id ="";
String adhoc_yn ="";
String site_sel ="";
String dis_butt ="";
String user_name ="";
String chk_External_Adm ="";
String chk_Batch_Mandatory ="";
String chk_Ext_fact_Mandatory="";
String default_site_id="";
String def_site_qry = "";
String dis_out = "";
String err_marked_by = "";
String err_marked_date = "";
String dis_butt_alwd = "none";
String err_remarks = "";
String appl_task_id = "";
String dflt_privilege_status = "";
String resp_id = "";
String pract_reln_id = "";
String facility_id = "";
String mark_err_appl = "";
String vaccine_desc = "";
String noOfDoseSchedule = "";
String notAdministeredSel="display";//IN045200
/*
Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
*/
String doseNumberStyle = "display";

/*ends here.*/

	facility_id = (String)session.getValue("facility_id");
	resp_id = (String) session.getValue("responsibility_id");


//int i=0;

	vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
	vacc_categ_id = request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");
	mode = request.getParameter("mode_new")==null?"":request.getParameter("mode_new");
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	adhoc_yn = request.getParameter("adhoc_yn")==null?"":request.getParameter("adhoc_yn");
	pract_reln_id = request.getParameter("relationship_id");
	appl_task_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
	vaccine_desc = request.getParameter("vaccine_desc")==null?"":request.getParameter("vaccine_desc");
	status = request.getParameter("status")==null?"":request.getParameter("status");
	
	//out.println("adhoc_yn ::"+adhoc_yn+":;");

	if(adhoc_yn.equals("Y"))
	{
		chk_Ext_fact_Mandatory = "display:none";
		/*
		    Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
		*/
		doseNumberStyle = "display:none";

		/*ends here.*/
	}

	Connection			con		= null;
	PreparedStatement	pstmt	= null,pstmt1	= null;
	ResultSet			rs		= null,rs1		= null;
	con = ConnectionManager.getConnection(request);
	
	CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	Dob = com.ehis.util.DateUtils.formatDate(Dob,"DMY" , "DMYHM", locale);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/ScheduleForVacination.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
  <head>
  </head>
  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
   <form name='adminDetailform' id='adminDetailform' method='post' target='messageFrame' action='../../servlet/eCA.ScheduleVaccinAdminServlet'>
   

   <%
	if(administered_by.equals(""))
	{
		administered_by =userId;
	}

   if(mode.equals("modify"))

	{
		disbl="readonly";	vaccine_id=request.getParameter("vaccine_id")==null?"":request.getParameter("vaccine_id");
		dose_no=request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
		//select Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,'CA','HS','HS','10014253','SD00000642') from CA_APPL_TASK a, ca_option c where a.OPTION_ID =c.OPTION_ID and  a.APPL_TASK_ID='CC_IMM_REC'
		

		try
		{
			/*
				Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
					(SELECT NO_OF_DOSE FROM CA_IM_VAC_FOR_CATEG WHERE VACCINE_ID=? AND VACC_CATEG_ID=?) NO_OF_DOSE  added to query
		    */

			String modify_query ="SELECT BATCH_ID,MANUFACTURER,ADMIN_SITE_ID,OUTCOME_CODE ,TO_CHAR(SCHEDULE_DATE,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE,EXTERNAL_ADM_YN ,EXTERNAL_FACILITY ,TO_CHAR(ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI')ADMINISTERED_DATE , ADMINISTERED_BY,REMARKS,ERR_MARKED_BY,TO_CHAR(ERR_MARKED_DATE,'DD/MM/YYYY HH24:MI') ERR_MARKED_DATE,ERR_REMARKS,GET_TASK_APPLICABILITY(?,?,?,?,?,?,?) MARK_ERR_APPL, (SELECT NO_OF_DOSE FROM CA_IM_VAC_FOR_CATEG WHERE VACCINE_ID=? AND VACC_CATEG_ID=?) NO_OF_DOSE FROM CA_IM_PAT_VAC_SCH_DTL WHERE VAC_SCH_REF =? AND VACCINE_ID=? AND DOSE_NO =? ";

			
			pstmt=con.prepareStatement(modify_query);
			
			//pstmt.setString(1,appl_task_id);
			pstmt.setString(1,"MARK_IMM_ERR");
			pstmt.setString(2,dflt_privilege_status);
			pstmt.setString(3,resp_id);
			pstmt.setString(4,pract_reln_id);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,encounter_id);
			pstmt.setString(7,patient_id);

			/*  Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 , */
			pstmt.setString(8, vaccine_id);
			pstmt.setString(9, vacc_categ_id);
			/*ends here .*/
			pstmt.setString(10,vac_sch_ref);
			pstmt.setString(11,vaccine_id);
			pstmt.setString(12,dose_no);

			/*out.println("<br>appl_task_id...."+appl_task_id+"....");
			out.println("<br>dflt_privilege_status...."+dflt_privilege_status+"....");
			out.println("<br>resp_id...."+resp_id+"....");
			out.println("<br>pract_reln_id...."+pract_reln_id+"....");
			out.println("<br>facility_id...."+facility_id+"....");
			out.println("<br>encounter_id...."+encounter_id+"....");
			out.println("<br>patient_id...."+patient_id+"....");
			out.println("<br>vac_sch_ref...."+vac_sch_ref+"....");
			out.println("<br>vaccine_id...."+vaccine_id+"....");
			out.println("<br>dose_no...."+dose_no+"....");*/


			rs= pstmt.executeQuery();
			while(rs.next())
			{
				batch_id =rs.getString("BATCH_ID")==null?"":rs.getString("BATCH_ID");
				manufacturer =rs.getString("MANUFACTURER")==null?"":rs.getString("MANUFACTURER");
				admin_site_id =rs.getString("ADMIN_SITE_ID")==null?"":rs.getString("ADMIN_SITE_ID");
				outcome_code =rs.getString("OUTCOME_CODE")==null?"":rs.getString("OUTCOME_CODE");
				schedule_date =rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE");
				external_adm_yn =rs.getString("EXTERNAL_ADM_YN")==null?"N":rs.getString("EXTERNAL_ADM_YN");
				external_facility =rs.getString("EXTERNAL_FACILITY")==null?"":rs.getString("EXTERNAL_FACILITY");
				administered_date =rs.getString("ADMINISTERED_DATE")==null?"":rs.getString("ADMINISTERED_DATE");
				administered_by =rs.getString("ADMINISTERED_BY")==null?"":rs.getString("ADMINISTERED_BY");
				remarks =rs.getString("REMARKS")==null?"":rs.getString("REMARKS");
				err_marked_by =rs.getString("ERR_MARKED_BY")==null?"":rs.getString("ERR_MARKED_BY");
				err_marked_date =rs.getString("ERR_MARKED_DATE")==null?"":rs.getString("ERR_MARKED_DATE");
				err_remarks =rs.getString("ERR_REMARKS")==null?"":rs.getString("ERR_REMARKS");
				mark_err_appl =rs.getString("mark_err_appl")==null?"":rs.getString("mark_err_appl");
				noOfDoseSchedule = rs.getString("NO_OF_DOSE")==null?"":rs.getString("NO_OF_DOSE");
		                //Two Date Convesion added by Archana Dhal on 12/8/2010 related to incident no IN025377.
				schedule_date = com.ehis.util.DateUtils.convertDate(schedule_date,"DMYHM","en",locale);
				administered_date = com.ehis.util.DateUtils.convertDate(administered_date,"DMYHM","en",locale);
				//out.println("mark_err_appl...."+mark_err_appl);

				//if(administered_date.equals(""))	//IN045200 Re -open
				if(administered_date.equals("") && !"N".equals(outcome_code))//IN045200 Re -open
				{
					administered_date =CurrentDate;
				}
				if(administered_by.equals(""))
				{
					administered_by =userId;
				}
				if (external_adm_yn.equals("Y")){
					chk_External_Adm ="checked";

					chk_Ext_fact_Mandatory = "display:visible";
					chk_Batch_Mandatory="display:none";
				}else{
					chk_External_Adm ="";
					chk_Ext_fact_Mandatory = "display:none";
					chk_Batch_Mandatory="display:visible";
				}
				
			
			}
			
			if(administered_by.equals(""))
			{
				administered_by =userId;
			}
			
			if(outcome_code.equals("N")||outcome_code.equals("E"))
			{
				dis_out ="disabled";

			}
			else
			{
				dis_out="";
			}
			if(outcome_code.equals("C") || outcome_code.equals("N")||outcome_code.equals("E"))
			{
				disbl_all ="readOnly";
				dis_butt ="disabled";
			}
			else
			{
				disbl_all ="";
				dis_butt ="";
			}
			if(outcome_code.equals("C")&&mark_err_appl.equals("A"))
			{
				dis_butt_alwd="inline";
			}
			else
			{
				dis_butt_alwd="none";
			}

				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				

		}
		catch (Exception ee)
		{
			
			ee.printStackTrace();
		}



	}
	try {
		String user_query ="SELECT APPL_USER_ID,APPL_USER_NAME FROM SM_APPL_USER WHERE EFF_STATUS ='E' AND APPL_USER_ID=? ORDER BY 2 ";

			pstmt1=con.prepareStatement(user_query);
			pstmt1.setString(1,administered_by);		
			rs1= pstmt1.executeQuery();

			while(rs1.next())
			{
				user_name =rs1.getString("APPL_USER_NAME")==null?"":rs1.getString("APPL_USER_NAME");
			}	
			
			
			if (rs1 != null) rs1.close();
			if (pstmt1 != null) pstmt1.close();
	}catch(Exception ee)
	{
		
		ee.printStackTrace();
	}
   
  // con = ConnectionManager.getConnection(request);
	//String vaccin_categ_query=" SELECT A.VACCINE_ID, A.DOSE_NO, A.FREQ_DURATION, A.FREQ_DURATION_TYPE, A.MANDATORY_YN, A.DEFUALT_OPTION, CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,'2') SHORT_DESC FROM CA_IM_VAC_SCH_FOR_CATEG A WHERE A.VACC_CATEG_ID =? Order by 7,2 ";
	
   
   %>
   <table cellpadding='0' cellspacing='0' border='0' style="height:70vh" width='100%' align='center'>

	<a name='AdministerDetails' style="top:0;visibility:visible;">

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td> 
		<% if(mode.equals("insert")){%>
		<td class='fields' width='25%'><select name='vaccine_name' id='vaccine_name' onchange="loadFields(this);">
		<option value= '' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			
					try
					{
						//Vaccin_query ="SELECT A.VACCINE_ID,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,'2') SHORT_DESC,A.DOSE_NO,to_char(SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE FROM CA_IM_PAT_VAC_SCH_DTL A WHERE A.VAC_SCH_REF =? Order by 2 " ;
						Vaccin_query ="select VACCINE_ID,SHORT_DESC from ca_im_vaccine_lang_vw where EFF_STATUS='E' AND ADHOC_YN='Y' AND LANGUAGE_ID=? ORDER BY 2 " ;

						pstmt=con.prepareStatement(Vaccin_query);
						pstmt.setString(1,locale);
				//		pstmt.setString(2,vac_sch_ref);
						rs= pstmt.executeQuery();
						while(rs.next())
						{
						
							vaccine_id1 =rs.getString("VACCINE_ID");
							short_desc =rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
							//dose_no1 =rs.getString("DOSE_NO")==null?"":rs.getString("DOSE_NO");
							//schedule_date1 =rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE");
						
							out.println("<option value="+vaccine_id1+">"+short_desc+"</option>");
							// out.println("<script language='javascript'>");
							//out.println("Vaccin_CodeArr["+i+"] ='"+vaccine_id+"'" );
							//out.println("Vaccin_doseArr["+i+"] ='"+dose_no1+"'" );
							//out.println("Vacc_sch_dateArr["+i+"] ='"+schedule_date1+"'" );
							//out.println("</script>");
							//i++;
						}

						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						//if(con!=null)ConnectionManager.returnConnection(con,request);


					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
				
				


		%>
		
		
		
		</select><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<% } 
		if ( mode.equals("modify")){ %>
		<td class='fields' width='25%'><input type='hidden' name='vaccine_name' id='vaccine_name' value='<%=vaccine_id%>' readonly><input type='text' name='vaccine_name1' id='vaccine_name1' value='<%=vaccine_desc%>' readonly></td>
		
		<%} %>
		<!--<%if(adhoc_yn.equals("N")){ %>		
		<td class='fields' width='25%' colspan ='2'><input type='hidden' name='dose_no' id='dose_no' value='<%=dose_no%>'></td>
		<%} else { %>

		<td class='fields' colspan ='2'>&nbsp;<input type='hidden' name='dose_no' id='dose_no' value='<%=dose_no%>'></td>
		<%}%> -->
		<input type='hidden' name='dose_no' id='dose_no' value='<%=dose_no%>'>
		<td class='label' width='25%' id='td_AdministeredBy'>
		<%if(!status.equals("L") && !external_adm_yn.equals("Y")){%>
		<fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/> 
		<%}else{%>
		<!--
			Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 , -->
		<fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/> 
		<%}%>
		</td>  
		<!--	ends here.		-->
		
	
		<td class='fields' width='25%'>
		<input type='text' name='administer_by_name' id='administer_by_name' value='<%if( mode.equals("modify")){%><%=user_name%><%} else if(mode.equals("insert")){%><%=user_name%><%}%>' <%=dis_butt%> onBlur ="getAdministerName(this,'<%=user_name%>');" maxlength='30'><input type='button' class='button' value='?' id='src_butn'  name='search_user' id='search_user' onClick="getAdminister()" <%=dis_butt%> ><img src='../../eCommon/images/mandatory.gif'>
		<input type='hidden' name='administer_by' id='administer_by' value='<%if( mode.equals("modify")){%><%=administered_by%><%} else if(mode.equals("insert")){ %> <%=userId%> <%}%>' ><input type=hidden value='<%=userId%>' name='administer_user_id'></td>

	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='batch_no' id='batch_no' maxlength="30" value='<%=batch_id%>' <%=disbl_all%>  >
		<img id = "chkBatchNoImg" src="../../eCommon/images/mandatory.gif" style="<%=chk_Batch_Mandatory%>">		
		</td>
		<td class='label' width='25%'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' nowrap><input type='text' name='manufacturer' id='manufacturer' maxlength="100" value='<%=manufacturer%>' <%=disbl_all%>  >
		<img id = "chkManuImg" src="../../eCommon/images/mandatory.gif" style="<%=chk_Batch_Mandatory%>">
		</td>
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'> <!--<input type='text' name='site_name' id='site_name' value='<%=admin_site_id%>' ></td> -->
		<select name='site_name' id='site_name' <%=dis_butt%> >
		<option value =''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
		
		try
		{

			def_site_qry="Select A.DEFAULT_SITE_ID from CA_IM_VAC_FOR_CATEG A where A.VACC_CATEG_ID = ? and a.VACCINE_ID = ?";
			pstmt=con.prepareStatement(def_site_qry);

			pstmt.setString(1,vacc_categ_id);
			if(mode.equals("modify"))
			{
				pstmt.setString(2,vaccine_id);
			}
			else if(mode.equals("insert"))
			{
				pstmt.setString(2,vaccine_id1);
			}
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				default_site_id = rs.getString("DEFAULT_SITE_ID")==null?"":rs.getString("DEFAULT_SITE_ID");
			}

			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();

			SiteName_query ="Select A.VACCINE_ID,A.SITE_ID,A.DEFAULT_YN,B.SHORT_DESC from CA_IM_SITE_FOR_VACCINE A,AM_ANATOMICAL_SITE B where A.VACCINE_ID = ? AND B.ANATOMICAL_SITE_CODE = A.SITE_ID order by 2 " ;
			pstmt=con.prepareStatement(SiteName_query);
			if(mode.equals("modify"))
			{
				pstmt.setString(1,vaccine_id);
			}
			else if(mode.equals("insert"))
			{
				pstmt.setString(1,vaccine_id1);
			}
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				site_id_new =rs.getString("SITE_ID")==null?"":rs.getString("SITE_ID");
				site_id_desc =rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
				site_default_yn = rs.getString("DEFAULT_YN")==null?"":rs.getString("DEFAULT_YN");
				
				//if(site_default_yn.equals("Y"))
				
			/*	if(admin_site_id.equals(""))
				{
					if(site_id_new.equals(default_site_id))
					{
						site_sel=" selected";
					}
					else
					{
						site_sel="";
					}
				}
				else 
				{
					if(site_id_new.equals(admin_site_id))
					{
						site_sel=" selected";
					}
					else
					{
						site_sel="";
					}


				} */
				
				
				if(outcome_code.equals("C")||outcome_code.equals("N"))
				{	
					
					if(site_id_new.equals(admin_site_id))
					{
						site_sel=" selected";	
					}
					else 
					{
						site_sel="";
					}
					
				}
				else
				{
				if(adhoc_yn.equals("Y"))
				{
					
					if(site_id_new.equals(admin_site_id))
					{
						site_sel=" selected";	
					}
					else if(site_default_yn.equals("Y"))
					{
						site_sel="selected";
					}
					else
					{
						site_sel="";

					}
				}
				else
				{
					if(site_id_new.equals(admin_site_id))
					{
						site_sel=" selected";	
					}
					else if(site_id_new.equals(default_site_id)) 
					{
						site_sel="selected";
					}
					else if(site_default_yn.equals("Y"))
					{
						site_sel="selected";
					}
					else
					{
						site_sel="";
					}
				}
				}

				out.println("<option value="+site_id_new+" "+site_sel+">"+site_id_desc+"</option>");



			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();

		}
		catch(Exception e)
		{
			
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		
		
		%>

		</select>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<select name='Outcome' id='Outcome' onchange="setOutcome(this)"; <%if(adhoc_yn.equals("Y")) out.println("disabled");%><%=dis_butt%>>
		<option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
		<% if((outcome_code.equals("C")) || (adhoc_yn.equals("Y"))) sel="selected" ; else sel="" ; %>
		<option value='C' <%=sel%> ><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
		<% 
		if(!outcome_code.equals("C")){
		if(outcome_code.equals("N")) sel="selected" ; else sel="" ; 
		//IN045200 Starts
		if("selected".equals(sel))
		{
			notAdministeredSel="display:none";
		}
		//IN045200 Ends
		%>
			<option value='N' <%=sel%> ><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></option>
		<%
		}
		if(outcome_code.equals("C")||outcome_code.equals("E")){ 
			if(outcome_code.equals("E")) sel="selected" ; else sel="" ; %>
		<option value='E' <%=sel%> ><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
		<%}%>

		</select>
		<img src='../../eCommon/images/mandatory.gif'>
		</td><input type=hidden value='<%=outcome_code%>' name='Outcome1' id='Outcome1'>
		<input type=hidden value='<%=outcome_code%>' name='Outcome_ext' id='Outcome_ext'>
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='Schedule_date' id='Schedule_date' value='<%if(mode.equals("modify")){%><%=schedule_date%><%}else if(mode.equals("insert")){%><%=CurrentDate%><%}%>' size=14 maxlength=16 onBlur='CheckDateTime(this,"ScheduleDate");' readonly>
		<!--
			Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
		<div id='doseNumberDiv' style='<%=doseNumberStyle%>'> &nbsp;&nbsp;&nbsp;<fmt:message key="eCA.DoseNumber.label" bundle="${ca_labels}"/>&nbsp;&nbsp; <%=dose_no%> &nbsp;of&nbsp; <%=noOfDoseSchedule%> </div> <!-- end here.--><!-- <input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('Schedule_date');" <%=disbl%> <%=dis_butt%> > --></td>
		<td class='label' width='25%'><fmt:message key="eCA.AdministerDate.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='administer_date' id='administer_date' value='<%if(mode.equals("modify")){%><%=administered_date.trim()%><%}else if(mode.equals("insert")){%><%=CurrentDate.trim()%><%}%>' size=15 maxlength=16 onBlur='CheckDateTime(this,"AdministerDate");' <%=disbl_all%> ><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('administer_date');" <%=dis_butt%> ><!--Commented forIN045200 <img src='../../eCommon/images/mandatory.gif'></td>-->
		<img id='administer_date_mand' style='<%=notAdministeredSel%>' src='../../eCommon/images/mandatory.gif'></td><!--Added for IN045200-->
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="eCA.ExternalAdminister.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'><input type='checkbox' name='ext_administer' id='ext_administer' value='<%=external_adm_yn%>' onclick="setExtAdminVal(this);" <%=disbl_all%> <%=dis_butt%> <%=chk_External_Adm%>></td>
		<td class='label' width='25%'><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/></td>
		<% if(locale.equalsIgnoreCase("th")) {	%>
		<td class='fields' width='25%' nowrap><input type='text' name='ext_facility' id='ext_facility' value='<%=external_facility%>'  maxlength="60" ReadOnly >
		<img id = "chkExtFclImg1" src="../../eCommon/images/mandatory.gif" style="<%=chk_Ext_fact_Mandatory%>"></td>
		<% } else { %>
		<td class='fields' width='25%' nowrap><input type='text' name='ext_facility' id='ext_facility' value='<%=external_facility%>' onkeypress="return SpecialCharRestriction(event)" maxlength="60" ReadOnly >
		<img id = "chkExtFclImg1" src="../../eCommon/images/mandatory.gif" style="<%=chk_Ext_fact_Mandatory%>"></td>
		<% } %>
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><textarea name='remark_text' id='remark_text1' value="" rows=2 cols=55 value='' onBlur="SPCheckMaxLen('Complaint Text',this,200,'')" onkeyPress='return checkMaxLimit(this,200)' <%=disbl_all%> ><%=remarks%></textarea><img id = "remarkMandImg" src="../../eCommon/images/mandatory.gif" style="display:none"></td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
		<!--<td class='fields' width='25%' align='top'>
		<input type='button' class='button' name='MarkError' id='MarkError' id = 'MarkError' style="display:<%=dis_butt_alwd%>" onclick="record_ErrorDet();" 	value='Mark Error'></input>
		<input type='button' class='button' name='record' id='record' id = 'record' <%=dis_butt%> onclick="record_adminDet();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'></input>
						<input type='button' class='button' name='clear' id='clear' onclick="clearAdminFields();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input></td>-->
	
	</tr>
	<% if(outcome_code.equals("E")){%>
	<tr>
		
		<td class='label' width='25%'><fmt:message key="eCA.MarkedInErrorBy.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%' disabled ><%=err_marked_by%></td>
		<td class='label' width='25%'><fmt:message key="eCA.MarkedErrorDate.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%' disabled ><%=err_marked_date%></td>
		
		<!--<td class='label' width='25%'><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<input type='text' name='administer_by_name' id='administer_by_name' value='<%if( mode.equals("modify")){%><%=user_name%><%} else if(mode.equals("insert")){%><%=user_name%><%}%>' <%=dis_butt%> onBlur ="getAdministerName(this);"><input type='button' class='button' value='?' id='src_butn'  name='search_user' id='search_user' onClick="getAdminister()" <%=dis_butt%> ><img src='../../eCommon/images/mandatory.gif'>
		<input type='hidden' name='administer_by' id='administer_by' value='<%if( mode.equals("modify")){%><%=administered_by%><%} else if(mode.equals("insert")){ %> <%=userId%> <%}%>' ><input type=hidden value='<%=userId%>' name='administer_user_id'></td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='fields' width='25%'>&nbsp;</td> -->

	</tr>
	<%}%>

	<tr>
	<% if(outcome_code.equals("E")){%>
	<td class='label' width='25%'><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><textarea name='remark_text' id='remark_text1' value="" rows=2 cols=55 value='' onBlur="SPCheckMaxLen('Complaint Text',this,200,'')" onkeyPress='return checkMaxLimit(this,200)' <%=disbl_all%> ><%=err_remarks%></textarea></td>
		<!--<td class='label' width='10%'>&nbsp;</td>-->
		<%}
		else
		{%>
		<td class='label' width='25%'></td>
		<td class='label' width='25%'></td>
			
		<%}
		 %>
		<td colspan=2 align='right'>
		<input type='button' class='button' name='MarkError' id='MarkError' style="display:<%=dis_butt_alwd%>" onclick="record_ErrorDet();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")%>'></input>
		<input type='button' class='button' name='record' id='record' <%=dis_butt%> onclick="record_adminDet();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'></input>
						<input type='button' class='button' name='clear' id='clear' <%=dis_butt%> onclick="clearAdminFields('<%=status%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input></td>

	</tr>

   </table>

	<!-- <br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br>

<a name='allergies' style="top:-750;visibility:hidden;"></a> -->
<%
/*	try {	
	String reaction_query ="select REACTION_CODE,SHORT_DESC from  am_reaction_lang_vw where EFF_STATUS='E' AND ADVERSE_REACTION_YN ='Y' and language_id=? ORDER BY 2 ";
		con = ConnectionManager.getConnection(request);
		pstmt2=con.prepareStatement(reaction_query);
		pstmt2.setString(1,locale);	*/
%>
<!-- <table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='label' width='25%'><fmt:message key="eCA.Vaccine.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='vaccine_name1' id='vaccine_name1' value='<%=vaccine_id%>' readOnly >   </td>
		<td class='label' width='25%' colspan="2"><input type='hidden' name='dose_no' id='dose_no' value='<%=dose_no%>'></td>		
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="eCA.ReactionDate.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='reaction_Date' id='reaction_Date' value='' size=14 maxlength=16 ><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('reaction_Date');" onBlur='CheckDateTime(this,"ReactionDate");' ></td>
		
		<td class='label' width='25%'><fmt:message key="eCA.ReactionCode.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'>
		<select name='reaction_code' id='reaction_code'>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%		
			/*	rs2= pstmt2.executeQuery();
				while(rs2.next()){*/ %>
					<option value=''  ></option>
			<%//	}			
			%>	
		</select>		
		</td>
	</tr>
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><textarea name='allergy_remark' value="" rows=4 cols=70 value='' onBlur="SPCheckMaxLen('Complaint Text',this,4000,'')" onkeyPress='return checkMaxLimit(this,4000)'></textarea></td>
	</tr>
	<tr>
	<td class='label' width='25%'><fmt:message key="eCA.Treatment.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan='3'><textarea name='allergy_treat' value="" rows=4 cols=70 value='' onBlur="SPCheckMaxLen('Complaint Text',this,4000,'')" onkeyPress='return checkMaxLimit(this,4000)'></textarea></td>
	</tr>
	<tr>
		<td class='label' colspan='3'>&nbsp;</td>
		<td class='fields' width='25%' align='right'><input type='button' class='button' name='record' id='record' id = 'record' onclick="record_adminDet();" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'></input>
						<input type='button' class='button' name='clear' id='clear' onclick="" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input></td>
	</tr>


    </table> -->

   <%   
	/*	if(rs2 != null) rs2.close();
		if(pstmt2 != null) pstmt2.close();
   }catch(Exception e){
		
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
		*/
	%>
   <input type=hidden value='<%=locale%>' name='locale' id='locale'>   
   <input type=hidden value='<%=vac_sch_ref%>' name='vac_sch_ref' id='vac_sch_ref'>
   <input type=hidden value='<%=mode%>' name='mode' id='mode'>
   <input type=hidden value='<%=patient_id%>' name='patient_id' id='vacc_categ_id'>
   <input type=hidden value='<%=vacc_categ_id%>' name='vacc_categ_id' id='vacc_categ_id'>
   <input type=hidden value='<%=Dob%>' name='Dob' id='Dob'>
   <input type=hidden value='<%=encounter_id%>' name='encounter_id' id='encounter_id'>
   <input type=hidden value='<%=userId%>' name='creating_user' id='creating_user'>
   <input type=hidden value='N' name='allergy_YN' id='allergy_YN'>
   <input type=hidden value='<%=adhoc_yn%>' name='adhoc_yn' id='adhoc_yn'>
   <input type=hidden value='' name='interval' id='interval'>
   <input type=hidden value='' name='prev_check_days' id='prev_check_days'>
   <input type=hidden value='' name='dupl_check_action' id='dupl_check_action'>
   <input type=hidden value='<%=query_string%>' name='query_string' id='query_string'>
   <input type=hidden value='' name='error_remarks' id='error_remarks'>
   </form>
  
		<%
			if(status.equals("L"))
			{
		%>
			 <SCRIPT LANGUAGE="JavaScript">				
				var chkObj = document.getElementById("ext_administer");
				if(chkObj)
				{
					chkObj.checked = true;
					chkObj.value = "Y";
					chkObj.disabled = true;
					setExtAdminVal(chkObj);
				}				
			</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}%>
   
 </body>
</html>

