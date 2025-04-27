<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	//Added by Ashwini on 01-Jul-2021 for AAKH-CRF-0125.1
	async function ListVisitsNotAutoClosed(bl_install_yn,bl_interfaced_yn)
	{
		var dialogHeight ='30vh';
		var dialogWidth = '75vw';
		var arguments = '';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var dialogUrl = "../../eOP/jsp/ListVisitsNotAutoClosed.jsp?bl_install_yn="+bl_install_yn+"&bl_interfaced_yn="+bl_interfaced_yn;

		await window.showModalDialog(dialogUrl,arguments,features);
	}
	</script>

</head>
<body class='CONTENT' onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<%
	String locale = localeName;
	String  patient_class="";
	String  mds_mode="";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String zero="0";
	
	String  module_id=(request.getParameter("module_id")==null)?"":request.getParameter("module_id");

	String  bl_interfaced_yn = (request.getParameter("bl_interfaced_yn")==null)?"N": request.getParameter("bl_interfaced_yn");

	String  bl_install_yn = (request.getParameter("bl_install_yn")==null)?"N": request.getParameter("bl_install_yn");	
	
	StringBuffer sql = new StringBuffer();

	    if(module_id.equals("OP"))	
	      {
         patient_class="OP";
		  mds_mode="OC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		   }
		
		if(module_id.equals("AE"))	
	     {
          patient_class="EM";
		   mds_mode="EC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		   }
		
		Connection con=null; 
	 try 
	  {
		con=ConnectionManager.getConnection(request);
		Statement stmt=con.createStatement();
		Statement stmt1=con.createStatement();
		ResultSet rset= null;
		ResultSet rset1= null;

		Boolean isVisitsNotAutoClosedAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VISITS_NOT_AUTO_CLOSED");//Added by Ashwini on 01-Jul-2021 for AAKH-CRF-0125.1
		
		String curDate="";
		String facility_id="";
		facility_id=(String) session.getValue("facility_id");
        String   tot_unclos_Visits="";
    	String  tot_aut_close_visits="";
	    String   tot_man_close_visits="";
		
		try
		{
	
			rset=stmt.executeQuery("Select to_char(trunc(sysdate - nvl(visit_compl_days,0)),'DD/MM/YYYY') from op_param where OPERATING_FACILITY_ID='"+facility_id+"'");
         		  	
			if (rset!=null)
			{
				if (rset.next())
				{
					curDate=rset.getString(1);
				}
			}
			

			sql.append("select sum(1) total_unclosed_visits,");

			if( bl_install_yn.equals("Y") && bl_interfaced_yn.equals("Y") ) {
				sql.append("sum(decode(BLOPIN.VISIT_AUTO_CLOSE_YN(FACILITY_ID,ASSIGN_CARE_LOCN_CODE, VISIT_ADM_TYPE,ATTEND_PRACTITIONER_ID,ENCOUNTER_ID),'Y',1,0)) total_autoclose_visits,sum(decode(BLOPIN.VISIT_AUTO_CLOSE_YN(FACILITY_ID,ASSIGN_CARE_LOCN_CODE, VISIT_ADM_TYPE,ATTEND_PRACTITIONER_ID,ENCOUNTER_ID),'N',1,0)) total_manualclose_visits ");
			}
			else {
				sql.append("sum(decode('Y','Y',1,0)) total_autoclose_visits,sum(decode('Y','N',1,0)) total_manualclose_visits ");
			}
			//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			sql.append(" from pr_encounter a where facility_id='"+facility_id+"'and visit_status < '07' and patient_class='"+patient_class+"'and MR_MDS_RECORDED_YN(facility_id,encounter_id,patient_class,null,'"+mds_mode+"',null)='Y'  and trunc(visit_adm_date_time) < trunc((SYSDATE - (SELECT visit_compl_days from op_param where operating_facility_id=a.facility_id)))");
			rset1=stmt1.executeQuery(sql.toString());
		

			//rset1=stmt1.executeQuery("select sum(1) total_unclosed_visits, sum(decode(BLOPIN.VISIT_AUTO_CLOSE_YN(FACILITY_ID,ASSIGN_CARE_LOCN_CODE, VISIT_ADM_TYPE,ATTEND_PRACTITIONER_ID),'Y',1,0)) total_autoclose_visits,sum(decode(BLOPIN.VISIT_AUTO_CLOSE_YN(FACILITY_ID,ASSIGN_CARE_LOCN_CODE, VISIT_ADM_TYPE,ATTEND_PRACTITIONER_ID),'N',1,0)) total_manualclose_visits from pr_encounter a where facility_id='"+facility_id+"'and visit_status < '07' and patient_class='"+patient_class+"'and MR_MDS_RECORDED_YN(facility_id,encounter_id,patient_class,null)='Y'  and visit_adm_date_time < SYSDATE - (SELECT visit_compl_days from op_param where operating_facility_id=a.facility_id)");
												
			if (rset1!=null) 
			{
               if (rset1.next())
				{
               tot_unclos_Visits =rset1.getString("total_unclosed_visits");               
			   if(tot_unclos_Visits==null)  tot_unclos_Visits=zero;	  
			   tot_aut_close_visits=rset1.getString("total_autoclose_visits");
		       if(tot_aut_close_visits==null) tot_aut_close_visits=zero;
			   tot_man_close_visits= rset1.getString("total_manualclose_visits");
			   if(tot_man_close_visits==null) tot_man_close_visits=zero;
			  
				 
				}
			   }
	
		
		}catch(Exception e) {
			out.println(e.toString());
			e.printStackTrace();}
		finally
		{
			if (stmt != null) stmt.close();
			if (rset != null) rset.close();
		    if (stmt1 != null) stmt1.close();
			if (rset1 != null) rset1.close();
			}

		
		String curDate_display=DateUtils.convertDate(curDate,"DMY","en",locale);
	%>
		<center>
			<form name = 'Op_Cutoof_Date_Form'>
				<br><br>
				<table border=0 cellpadding=0 cellspacing=0 width='80%' align=center>
					<th  class='columnheader' align="left"><fmt:message key="eOP.CutoffDateforAutoCompleteVisits.label" bundle="${op_labels}"/></th>
		        </table>
				<table border=0 cellpadding=2 cellspacing=0 width='80%' align=center>
					<tr>
						<td class='label' width='30%' colspan='2'><fmt:message key="eOP.CutoffDate.label" bundle="${op_labels}"/></td>
						<td width='50%' class='fields' colspan='2'><input type='text' id='cutoffdate' name='CUTOFF_DATE' id='CUTOFF_DATE' READONLY value='<%=curDate_display%>' size=10 maxlength=10 onblur='validDateObj(this,"DMY",localeName);'></td>

						<!--Added by Ashwini on 01-Jul-2021 for AAKH-CRF-0125.1-->
						<%
						if(isVisitsNotAutoClosedAppl && module_id.equals("OP")){
						
						JSONArray VstLstJsonArr = new JSONArray();
						VstLstJsonArr = eOP.OPCommonBean.getListVisitsNotAutoClosed(con,bl_install_yn,bl_interfaced_yn,facility_id,locale);
						int cnt = 0;
						String mr_mds_remarks = "";

						for(int i = 0 ; i < VstLstJsonArr.size() ; i++) 
						{
							JSONObject json	= (JSONObject)VstLstJsonArr.get(i);
							mr_mds_remarks = (String) json.get("mr_mds_remarks");
							
							if(!mr_mds_remarks.equals("Y"))
							{
								cnt++;
							}
						}

						if(cnt > 0){%>
						<td class='label' width='30%' colspan='2'>
							<a href="javascript:ListVisitsNotAutoClosed('<%=bl_install_yn%>','<%=bl_interfaced_yn%>');" style="text-decoration:none;white-space:nowrap;" id="VisitsNotAutoClosed" name="VisitsNotAutoClosed"><b><fmt:message key="eOP.VisitsNotAutoClosed.label" bundle="${op_labels}"/></b></a>
						</td>
						<%}
						}%>
						<!--End AAKH-CRF-0125.1-->
					</tr>					
							<tr>
						<td class='label' width='30%' colspan='2'><fmt:message key="eOP.TotalUnclosedVisits.label" bundle="${op_labels}"/></td>
						<td width='50%' class='fields' colspan='2'><input type='text' id='TotUnclosVisits' name='Tot_Unclos_Visits' id='Tot_Unclos_Visits' READONLY value='<%=tot_unclos_Visits %>' size=10 maxlength=10 ></td>
					</tr>					
				   <tr>
						<td class='label' width='30%' colspan='2'><fmt:message key="eOP.TotalAutoCloseVisits.label" bundle="${op_labels}"/></td>
						<td width='50%' class='fields' colspan='2'><input type='text' id='TotAutClosVisits' name='Tot_AutClos_Visits' id='Tot_AutClos_Visits' READONLY value='<%=tot_aut_close_visits%>' size=10 maxlength=10 ></td>
					</tr>		
						<tr>
						<td class='label' width='30%' colspan='2'><fmt:message key="eOP.TotalManualVisits.label" bundle="${op_labels}"/></td>
						<td width='50%' class='fields' colspan='2'><input type='text' id='TotManuVisits' name='Tot_Manu_Visits' id='Tot_Manu_Visits' READONLY value='<%= tot_man_close_visits%>' size=10 maxlength=10> </td>
					</tr>		
						</table>
															
						<input type='hidden' name='CUTOFF_DATE1' id='CUTOFF_DATE1' value='<%=curDate%>'>
			
			</form>
		</center>
	</body>
	</html>
	<%
	}catch(Exception e){
				e.printStackTrace();
				}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}					
%>

