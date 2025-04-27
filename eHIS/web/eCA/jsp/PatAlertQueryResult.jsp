<!DOCTYPE html>

<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//out.println("<script>alert('"+request.getQueryString()+"');</script>");
	Connection conn= null; //(Connection) session.getValue("connection");
	PreparedStatement stmt		=null;
	PreparedStatement pstmt = null;
	ResultSet rs1 	= null;
	ResultSet rs		=null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String srl_no       = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	
	String call_from    =request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String ADV_EVENT_TYPE_IND    =request.getParameter("ADV_EVENT_TYPE_IND")==null?"":request.getParameter("ADV_EVENT_TYPE_IND");
	String ADV_EVENT_TYPE    =request.getParameter("ADV_EVENT_TYPE")==null?"":request.getParameter("ADV_EVENT_TYPE");
	String ALLERGEN_CODE    =request.getParameter("ALLERGEN_CODE")==null?"":request.getParameter("ALLERGEN_CODE");
	String ADV_EVENT_SRL_NO    =request.getParameter("ADV_EVENT_SRL_NO")==null?"":request.getParameter("ADV_EVENT_SRL_NO");
	String high_risk_code =request.getParameter("high_risk_code")==null?"":request.getParameter("high_risk_code");
	//String radio_par= request.getParameter("radio_par");
	String onset_date="";
	String onset_practitioner_name="";
	String onset_facility_name="";
	String onset_locn_desc="";
	String onset_recorded_date="";
	String close_date="";
	String close_practitioner_name="";
	String close_facility_name="";
	String close_locn_desc="";
	String close_recorded_date="";
	String onset_facility_id = "";
	String onset_encounter_id = "";
	String close_facility_id = "";
	String close_encounter_id = "";
	String onset_service = "";
	String close_service = "";
	String patient_id = request.getParameter("patient_id");
	String remarks ="";
	String remarks1="";
	String status="";
try
{
	conn = ConnectionManager.getConnection(request);
	
		if (call_from.trim().equals("allergy"))
		{
			
		try
			{
				pstmt = conn.prepareStatement("select AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') short_desc from pr_encounter a where a.facility_id = ? and a.encounter_id = ? ");
	
				String StrSql="Select to_char(onset_date,'dd/mm/yyyy hh24:mi:ss') onset_date,NVL((SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=(SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_iD AND ROWNUM=1) AND LANGUAGE_ID=? ) , SM_GET_DESC.SM_APPL_USER(A.ADDED_BY_ID,?,'1') ) onset_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(ONSET_FACILITY_ID,?,'1') onset_facility_name,NVL(OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1') ) onset_locn_desc,to_char(a.ADDED_DATE,'dd/mm/yyyy') onset_recorded_date,to_char(RESOLVED_DATE,'dd/mm/yyyy') close_date,NVL((SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=(SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.MODIFIED_BY_iD AND ROWNUM=1) AND LANGUAGE_ID=? ) , SM_GET_DESC.SM_APPL_USER(A.MODIFIED_BY_ID,?,'1') ) close_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(A.MODIFIED_FACILITY_ID,?,'1')   close_facility_name,NULL close_locn_desc,to_char(RESOLVED_DATE,'dd/mm/yyyy') close_recorded_date,onset_facility_id, onset_encounter_id,NULL close_facility_id, null close_encounter_id, REMARKS ERROR_REMARK,status from pr_allergy_sensitivity a ,PR_ADVERSE_EVENT c where a.patient_id = ? and a.ADV_EVENT_TYPE_IND=? and a.ADV_EVENT_TYPE=? and a.ALLERGEN_CODE=? and a.ADV_EVENT_SRL_NO=? and a.PATIENT_ID= c.PATIENT_ID and a.ADV_EVENT_TYPE_IND =c.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE =c.ADV_EVENT_TYPE and a.ALLERGEN_CODE=c.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO =c.ADV_EVENT_SRL_NO ";
				
					
				stmt = conn.prepareStatement(StrSql);
				stmt.setString(1, locale);
				stmt.setString(2, locale);
				stmt.setString(3, locale);
				stmt.setString(4, locale);
				stmt.setString(5, locale);
				stmt.setString(6, locale);
				stmt.setString(7, locale);
				stmt.setString(8, locale);
				stmt.setString(9,patient_id.trim());
				stmt.setString(10,ADV_EVENT_TYPE_IND.trim());
				stmt.setString(11,ADV_EVENT_TYPE.trim());
				stmt.setString(12,ALLERGEN_CODE.trim());
				stmt.setString(13,ADV_EVENT_SRL_NO.trim());

				rs = stmt.executeQuery();
	
				while(rs.next()){
					onset_date=rs.getString("onset_date");
					onset_practitioner_name= rs.getString("onset_practitioner_name");


					onset_facility_name=rs.getString("onset_facility_name");


					onset_locn_desc=rs.getString("onset_locn_desc");


					onset_recorded_date=rs.getString("onset_recorded_date");


					close_date=rs.getString("close_date");
					close_practitioner_name=rs.getString("close_practitioner_name");
					close_facility_name=rs.getString("close_facility_name");
					close_locn_desc=rs.getString("close_locn_desc");
					close_recorded_date=rs.getString("close_recorded_date");

					onset_facility_id = rs.getString("onset_facility_id");
					onset_encounter_id = rs.getString("onset_encounter_id");
					close_facility_id = rs.getString("close_facility_id");
					close_encounter_id = rs.getString("close_encounter_id");
					remarks = rs.getString("ERROR_REMARK")==null?"":rs.getString("ERROR_REMARK");
					status=rs.getString("status");

					if(close_recorded_date == null)
					{
						close_practitioner_name = "&nbsp";
						close_facility_name = "&nbsp";
					}
				}
				if(rs!=null) rs.close();
				pstmt.setString(1,locale);
				pstmt.setString(2,onset_facility_id);
				pstmt.setString(3,onset_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  onset_service = rs1.getString(1);
				}
				if(rs1!=null) rs1.close();
				pstmt.setString(1,close_facility_id);
				pstmt.setString(2,close_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  close_service = rs1.getString(1);
				}
					
					if(rs1!=null) rs1.close();
					if(stmt!=null) stmt.close();
					if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
		{
				//out.println("Exception @ try"+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
		}
		finally 
		{
			//if(conn!=null)ConnectionManager.returnConnection(conn, request);
		}
		}
	
	   if (call_from.equals("high_risk"))
	   {
		try
			{
				//conn = ConnectionManager.getConnection(request);
				//Added newly
				pstmt = conn.prepareStatement("select AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') short_desc from pr_encounter a where a.facility_id = ? and a.encounter_id = ? ");

				String StrSql="SELECT TO_CHAR(ONSET_DATE,'DD/MM/YYYY')ONSET_DATE ,AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,?,'1')  ONSET_PRACTITIONER_NAME,SM_GET_DESC.SM_FACILITY_PARAM(ONSET_FACILITY_ID,?,'1')  ONSET_FACILITY_NAME,NVL(OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1')) ONSET_LOCN_DESC, TO_CHAR(ONSET_RECORDED_DATE,'DD/MM/YYYY')ONSET_RECORDED_DATE,TO_CHAR(CLOSE_DATE,'DD/MM/YYYY')CLOSE_DATE,AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,?,'1')   CLOSE_PRACTITIONER_NAME,SM_GET_DESC.SM_FACILITY_PARAM(CLOSE_FACILITY_ID,?,'1')   CLOSE_FACILITY_NAME,NVL(OP_GET_DESC.OP_CLINIC(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1')) CLOSE_LOCN_DESC,TO_CHAR(CLOSE_RECORDED_DATE,'DD/MM/YYYY')CLOSE_RECORDED_DATE,ONSET_FACILITY_ID, ONSET_ENCOUNTER_ID,CLOSE_FACILITY_ID, CLOSE_ENCOUNTER_ID, REMARKS FROM PR_HIGH_RISK_CONDITION WHERE PATIENT_ID = ? AND SRL_NO = ? AND HIGH_RISK_CODE=?";
				
				stmt = conn.prepareStatement(StrSql);
				stmt.setString(1, locale);
				stmt.setString(2, locale);
				stmt.setString(3, locale);
				stmt.setString(4, locale);
				stmt.setString(5, locale);
				stmt.setString(6, locale);
				stmt.setString(7, locale);
				stmt.setString(8, locale);
				stmt.setString(9, patient_id);
				stmt.setString(10, srl_no);
				stmt.setString(11, high_risk_code);
				rs = stmt.executeQuery();
				
				rs.next();
				onset_date=rs.getString("onset_date");
				onset_practitioner_name= rs.getString("onset_practitioner_name");
				onset_facility_name=rs.getString("onset_facility_name");
				onset_locn_desc=rs.getString("onset_locn_desc");
				onset_recorded_date=rs.getString("onset_recorded_date");
				close_date=rs.getString("close_date");
				close_practitioner_name=rs.getString("close_practitioner_name");
				close_facility_name=rs.getString("close_facility_name");
				close_locn_desc=rs.getString("close_locn_desc");
				close_recorded_date=rs.getString("close_recorded_date");

				onset_facility_id = rs.getString("onset_facility_id");
				onset_encounter_id = rs.getString("onset_encounter_id");
				close_facility_id = rs.getString("close_facility_id");
				close_encounter_id = rs.getString("close_encounter_id");
				remarks1 = rs.getString("remarks")==null?"":rs.getString("remarks");
					
				if(rs!=null) rs.close();
				pstmt.setString(1,locale);
				pstmt.setString(2,onset_facility_id);
				pstmt.setString(3,onset_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  onset_service = rs1.getString(1);
				}
				if(rs1!=null)rs1.close();
				pstmt.setString(1,locale);
				pstmt.setString(2,close_facility_id);
				pstmt.setString(3,close_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  close_service = rs1.getString(1);
				}

			if(rs1!=null) rs1.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
		
		}
		catch (Exception e)
		{
			//out.println("Exception @ try"+e.toString());//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally 
		{
		
		}
		}

		if (onset_date == null)
				onset_date="&nbsp";
		if	(onset_date== null)
				onset_date="&nbsp";
		if	(onset_practitioner_name== null)
				onset_practitioner_name ="&nbsp";
		if 	(onset_facility_name== null)
				onset_facility_name="&nbsp";
		if 	(onset_locn_desc== null)
				onset_locn_desc="&nbsp";
		if 	(onset_recorded_date== null)
				onset_recorded_date="&nbsp";
		if 	(close_date== null)
				close_date="&nbsp;";
		if 	(close_practitioner_name== null)
				close_practitioner_name="&nbsp";
		if 	(close_facility_name== null)
				close_facility_name="&nbsp";
		if	(close_locn_desc== null)
				close_locn_desc="&nbsp";
		if 	(close_recorded_date== null)
				close_recorded_date="&nbsp;";
		if(onset_service ==null)
			   onset_service="&nbsp;";
		if(close_service ==null)
			   close_service="&nbsp;";

		if(!onset_date.equals("&nbsp;"))
		{
			if (call_from.trim().equals("allergy"))
			{
				onset_date		= com.ehis.util.DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
			}
			else
			{
				onset_date		= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
			}
		}

		if(!onset_recorded_date.equals("&nbsp;"))
			onset_recorded_date	= com.ehis.util.DateUtils.convertDate(onset_recorded_date,"DMY","en",locale);		

		if(!close_date.equals("&nbsp;"))
			close_date			= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);

		if(!close_recorded_date.equals("&nbsp;"))
			close_recorded_date	= com.ehis.util.DateUtils.convertDate(close_recorded_date,"DMY","en",locale);
	

%>
<table align=left style="width:95vw;height:99vh" cellpadding='3' cellspacing='0'>
<tr>
	<td>
		<table border style="width:94vw" align=center cellpadding='3' cellspacing='0'>
		<td class='columnHeadercenter' style="background-color: #73a5ad; color: white;" colspan=2  height=12%><font size=1><fmt:message key="eCA.OnsetDetails.label" bundle="${ca_labels}"/></font></td>
		<tr>
			<td>
				<table align='center' style="width:92vw;height:50vh" cellpadding='3' cellspacing='0'>
				<tr>
					<td colspan=2>&nbsp</td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_date%></font></td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_practitioner_name%></font></td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_facility_name%></font></td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_locn_desc%></font></td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_service%></font></td>
				</tr>
				<tr>
					<td class="label"  width=40%><font size=1><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
					<td width=60%><font size=1><%=onset_recorded_date%></font></td>
				</tr>
				<tr>
					<td class="label"  width=20%><font size=1> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>

					<td width=20%><font size=1><%=remarks%></font><font size=1><%=remarks1%></font></td>

				</tr>
		</table>
		</td>
	</tr>
	</table>
	</td>
	</tr>
<tr>
	<td class=BODYCOLORFILLED>&nbsp</td>
</tr>
<tr>
<td>
	<table border style="width:94vw" align=center cellpadding='3' cellspacing='0'>
	<td class='columnheadercenter' colspan=2  height=19% style="background-color: #73a5ad; color: white;"><font size=1><fmt:message key="eCA.CloseDetails.label" bundle="${ca_labels}"/></font></td>
	<tr>
		<td>
			<table align=center style="width:92vw;height:19vh" cellpadding='3' cellspacing='0'>
		<tr>
		<tr>
			<td colspan=2></td>
		</tr>
		<!-- <tr>
			<td class="label"  width=40%><font size=1><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_date%></font></td>
		</tr> -->
		
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_practitioner_name%></font></td>
		</tr>
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_facility_name%></font></td>
		</tr>
		<%

		if (!(call_from.trim().equals("allergy")) && !(call_from.trim().equals(""))){%>
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_locn_desc%></font></td>
		</tr>
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_service%></font></td>
		</tr>
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="eCA.HighRiskResRecDate.label" bundle="${ca_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_recorded_date%></font></td>
		</tr>
		<%}
		else{%>
		<tr>
			<td class="label"  width=40%><font size=1><fmt:message key="eCA.AlrgyResRecDate.label" bundle="${ca_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_recorded_date%></font></td>
		</tr>
		<%}	%>

		<!-- <tr>
			<td class="label"  width=40%><font size=1><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/>&nbsp&nbsp</font></td>
			<td width=60%><font size=1><%=close_recorded_date%></font></td>
		</tr> -->

	</table>
	</td>
	</tr>
</table>
</td>
</tr>
<tr>
	<td class=BODYCOLORFILLED>&nbsp</td>
</tr>
<tr>
	<td class=BODYCOLORFILLED>&nbsp</td>
</tr>
<tr>
	<td class=BODYCOLORFILLED>&nbsp</td>
</tr>
</table>
	<%
}
	catch(Exception e)
	{
		//out.println("Exception @ PatAlertQueryResult.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
	if(conn!=null)ConnectionManager.returnConnection(conn, request);
	}
	%>
</body>
</html>

