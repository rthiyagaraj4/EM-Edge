<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.PatEncDetails.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
    <head>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        <script>
            function switchWindow(winname)
            {
                window.returnValue = winname;
                window.close()				
            }
			function patClick(enc_id,pat_class)
			{	
				document.ShowPatCriteriaFrm.encounter_id.value = enc_id;
				document.ShowPatCriteriaFrm.patient_class.value=  pat_class;
				document.ShowPatCriteriaFrm.submit();
				window.close()
			}
        </script>
		<style>
			TD.SWITCHOPTIONS
			{
				color:white;
				FONT-SIZE: 10pt ;
				background-color:#637BBD ;
				FONT-FAMILY: VERDANA ;
			}
		</style>
    </head>
	<BODY  class='CONTENT'  >
	<form name='ShowPatCriteriaFrm' id='ShowPatCriteriaFrm' action='OpenChartWrapper.jsp' method = 'post' target='messageFrame'>
	<table border=1 cellpadding=0 cellspacing=0 width='100%' height="100%" align=center valign=top BORDERCOLOR=BLACK>
			<tr><td valign=TOP>
				<table border=0 cellpadding=0 cellspacing=1 width='100%' align=center valign=top >
<%
		String patientName = request.getParameter("patientName") == null ? "" : request.getParameter("patientName");
		String patientId = request.getParameter("patientID") == null ? "" : request.getParameter("patientID");
		String Age =request.getParameter("Age") == null ? "" : request.getParameter("Age");
		String Gender =request.getParameter("Gender") == null ? "" : request.getParameter("Gender");
		String loginPractitionerID = request.getParameter("pracID") == null ? "" : request.getParameter("pracID");
		
		PreparedStatement stmtsql = null;
		ResultSet rs = null;
		Connection con = null;
		String encounter_id="";
		String visit_adm_dt="";
		String pat_class="";
		int count=0;

		String patListSql="select A.ENCOUNTER_ID,TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date,a.patient_class from pr_encounter a,mp_patient b,ca_encntr_param  c where a.patient_id=? and a.patient_id=b.patient_id and b.SUSPEND_YN !='Y' AND a.ATTEND_PRACTITIONER_ID=? AND (       (    a.patient_class IN ('IP', 'DC') and a.adt_status between '01' and '07' )   OR (    a.patient_class IN  ('OP', 'EM') and a.visit_status in ('01','02','03','04','05','06','09'))) AND ( NOT EXISTS(SELECT  1 FROM MO_MORTUARY_REGN WHERE PATIENT_ID=a.patient_id and BODY_PART_OBTAINED_FROM is null)) Order by visit_adm_date_time desc";
		try
		{
			con = ConnectionManager.getConnection(request);

			stmtsql=con.prepareStatement(patListSql);
			stmtsql.setString(1,patientId);
			stmtsql.setString(2,loginPractitionerID);
			rs=stmtsql.executeQuery();
			if(rs!=null)
				out.println("<tr><td class='SWITCHOPTIONS' >Patient Name:"+patientName+", Patient ID:"+patientId+", Age: "+Age+" ,Gender : "+Gender+" </td></tr>");
			while(rs!=null && rs.next()){
				encounter_id=rs.getString("ENCOUNTER_ID")==null?"0":rs.getString("ENCOUNTER_ID");
				pat_class=rs.getString("patient_class")==null?"0":rs.getString("patient_class");
				visit_adm_dt=com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale);
				out.println("<tr><td class='SWITCHOPTIONS' onclick=\"javascript:patClick('"+encounter_id+"','"+pat_class+"');\" >Encounter id :"+encounter_id+" Visit Adm Date: "+visit_adm_dt+"</td></tr>");
				count++;
			}
		}catch(Exception e)
		{
			e.printStackTrace();

		}finally
		{
			if(rs != null) rs.close();
			if(stmtsql != null) stmtsql.close();
			if(con != null) con.close();
		}
%>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientId%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="insert_op" id="insert_op" value="N">
        <input type="hidden" name="patient_class" id="patient_class" value="">
</form>
</body>
</html>

