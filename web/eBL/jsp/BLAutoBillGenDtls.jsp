<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
23-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>

<%
    request.setCharacterEncoding("UTF-8");
	HttpSession httpSession = request.getSession(false);
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null; 
	ResultSet rs	=null;
	int total_records=0;
	String facilityId = "";
	String sessionId = "";
	String pgmDate = "";
	String patientId = "";
	String visitDate = "";
	String episodeType = "";
	String episodeNo = "";
	String visitCount = "";
	String location = "";
	String description = "";
	String payerUnbilledAmt = "";
	String patientUnbilledAmt = "";
 	String sql = "";
 	String loginUser = "";
 	String clientIp = "";
 	String jobId = "";
 	String sqlJobId = "";
 	String epiType = "";
 	String genJobId = "";
 	String visitFromDate = "";
 	String visitToDate = "";
 	String cust_group = "";
	String cust_group_code = "";
	String cust_name = "";
	String cust_name_code = "";
	String p_episodeType = "";
	String p_patientId = "";
	String status = "";
	int noofdecimal = 2;
 	try
	{
		con	=	ConnectionManager.getConnection(request);
		facilityId = checkForNull(request.getParameter("facilityId"));
		sessionId = checkForNull(request.getParameter("sessionId"));
		pgmDate = checkForNull(request.getParameter("pgmDate"));
		loginUser = checkForNull((String) session.getValue("login_user"));
		Properties p = (Properties)httpSession.getValue("jdbc");
		clientIp = p.getProperty("client_ip_address");
		visitFromDate = checkForNull(request.getParameter("visit_from_date"));
		visitToDate = checkForNull(request.getParameter("visit_to_date"));
		cust_group = checkForNull(request.getParameter("cust_group"));
		cust_group_code = checkForNull(request.getParameter("cust_group_code"));
		cust_name = checkForNull(request.getParameter("cust_name"));
		cust_name_code = checkForNull(request.getParameter("cust_name_code"));
		p_episodeType = checkForNull(request.getParameter("episode_type"));
		p_patientId = checkForNull(request.getParameter("patientId"));
		System.out.println("p_patientId: " + p_patientId);
		status = checkForNull(request.getParameter("status"));
		CurrencyFormat cf = new CurrencyFormat();
		
		pstmt = con.prepareStatement("select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		ResultSet rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}
		
		try {
			sqlJobId = "SELECT TO_CHAR (SYSDATE, 'DDMMYYYY')||'-'||(NVL(MAX(TO_NUMBER(SUBSTR(orajobid,(INSTR(orajobid,'-')+1)))),'00')+'01') AS VAL"
					+ " FROM bl_background_process"
					+ " WHERE SUBSTR (orajobid,1,8) = TO_CHAR (SYSDATE, 'DDMMYYYY')";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlJobId);
			while(rs.next()) {
			genJobId = rs.getString("VAL");
			}
			System.out.println("Job ID: " + genJobId);
		}catch(Exception e1) {
			e1.printStackTrace();
			System.out.println("Error in getting job id: " + e1);
		}
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language="javascript" src="../../eBL/js/BLAutoBillGen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	

		<style>
			thead td, thead td.locked	{
			background-color: navy;
			color: white;
			position:relative;}	
			thead td {
			top: expression(document.getElementById("tbl-container").scrollTop-2); 
			z-index: 20;}
			thead td.locked {z-index: 30;}
			td.locked,  th.locked{
			left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
			position: relative;
			z-index: 10;}
			td.locked,  th.locked{
			left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
			position: relative;
			z-index: 10;}
		</style>

<body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<form name='view_enctr_bill_det' id='view_enctr_bill_det' id='view_enctr_bill_det' method='post' action=''>
		<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 480px;   padding:3px; margin: 0px">
		<%
			try {
				sql = "SELECT   patient_id, visit_adm_date_time, epi_type, episode_id, visit_id, locn_code, locn_desc, SUM (payer_payable_amt) payer_payable_amt,"
				        + " SUM (patient_payable_amt) patient_payable_amt FROM (SELECT patient_id, to_char(visit_adm_date_time,'dd/MM/yyyy HH24:MI') visit_adm_date_time, DECODE (episode_type, 'O', 'Outpatient',"
				        + " 'E', 'Emergency', episode_type) epi_type, episode_id, visit_id, locn_code, locn_desc, CASE WHEN cust_code IS NOT NULL"
				        + " THEN NVL (upd_net_charge_amt, 0) ELSE 0 END payer_payable_amt, CASE WHEN cust_code IS NOT NULL THEN 0 ELSE NVL (upd_net_charge_amt, 0)"
				        + " END patient_payable_amt FROM bl_pat_autobil_folio_temp a WHERE operating_facility_id ='"+facilityId+"' AND session_id = '"+sessionId+"'"
				        + " and patient_id = nvl('"+p_patientId+"', patient_id) AND job_id = 'XXXXX') GROUP BY patient_id, visit_adm_date_time, epi_type, episode_id,"
				        + " visit_id, locn_code, locn_desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			
		%>
		<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
			<thead>
			<tr>			
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.EpisodeNo.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='9%'><fmt:message key="Common.Location.label"bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.Description.label"bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='14%'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/> <fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><input type='checkbox' id='chkall' name='chkall' id='chkall' onclick='checkAll();'></td>			
			</tr>
			</thead>
			<tbody id='tblbody'>
		<%
		int i = 1;
		if(rs != null) {
			while(rs.next()) {
				patientId = checkForNull(rs.getString("patient_id"));
				visitDate = checkForNull(rs.getString("visit_adm_date_time"));
				episodeType = checkForNull(rs.getString("epi_type"));
				episodeNo = checkForNull(rs.getString("episode_id"));
				visitCount = checkForNull(rs.getString("visit_id"));
				location = checkForNull(rs.getString("locn_code"));
				description = checkForNull(rs.getString("locn_desc"));
				payerUnbilledAmt = checkForNull(cf.formatCurrency(rs.getString("payer_payable_amt"),noofdecimal));
				patientUnbilledAmt = checkForNull(cf.formatCurrency(rs.getString("patient_payable_amt"),noofdecimal));
			
		%>
		
			<tr>
				<td class="fields"  width="10%" style="text-align:center"><%=patientId %></td>
				<input type='hidden' id="patientId<%=i %>" name="patientId<%=i %>" value='<%=patientId %>'>
				<td class="fields"  width='10%' style="text-align:center" nowrap><%=visitDate %></td>
				<input type='hidden' id="visitDate<%=i %>" name="visitDate<%=i %>" value='<%=visitDate %>'>
				<td class="fields"  width="10%" style="text-align:center"><%=episodeType %></td>
				<%
					if("Outpatient".equals(episodeType)) {
						epiType = "O";
					}else if("Emergency".equals(episodeType)) {
						epiType = "E";
					}
				%>
				<input type='hidden' id="episodeType<%=i %>" name="episodeType<%=i %>" value='<%=epiType %>'>
				<td class="fields"  width="12%" style="text-align:center"><%=episodeNo %></td>
				<input type='hidden' id="episodeNo<%=i %>" name="episodeNo<%=i %>" value='<%=episodeNo %>'>
				<td class="fields"  width="8%" style="text-align:center"><%=visitCount %></td>
				<input type='hidden' id="visit<%=i %>" name="visit<%=i %>" value='<%=visitCount %>'>				
				<td class="fields"  width="9%" style="text-align:center"><%=location %></td>
				<input type='hidden' id="location<%=i %>" name="location<%=i %>" value='<%=location %>'>
				<td class="fields"  width="12%" style="text-align:center"><%=description %></td>
				<input type='hidden' id="description<%=i %>" name="description<%=i %>" value='<%=description %>'>
				<td class="fields"  width="14%" style="text-align:right"><%=payerUnbilledAmt %></td>
				<input type='hidden' id="payerUnbilledAmt<%=i %>" name="payerUnbilledAmt<%=i %>" value='<%=payerUnbilledAmt %>'>
				<td class="fields"  width="15%" style="text-align:right"><%=patientUnbilledAmt %></td>
				<input type='hidden' id="patientUnbilledAmt<%=i %>" name="patientUnbilledAmt<%=i %>" value='<%=patientUnbilledAmt %>'>
				<td class="fields"  width="5%"  style="text-align:center"><input type='checkbox' id='chkbx<%=i %>' name='chkbx<%=i %>' onclick='chkindividualitem();checkUncheckVal(<%=i %>);'>
				</td>
			</tr>
			<%
			i++;
			total_records++;
			}
			System.out.println("total_records: "+ total_records);
		}
		%>
		<input type=hidden name='total_records' id='total_records' id='total_records' value='<%=total_records %>'>
		<input type=hidden name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>'>
		<input type=hidden name='sessionId' id='sessionId' id='sessionId' value='<%=sessionId %>'>
		<input type=hidden name='pgmDate' id='pgmDate' id='pgmDate' value='<%=pgmDate %>'>
		<input type=hidden name='loginUser' id='loginUser' id='loginUser' value='<%=loginUser %>'>
		<input type=hidden name='clientIp' id='clientIp' id='clientIp' value='<%=clientIp %>'>
		<input type=hidden name='jobId' id='jobId' id='jobId' value='<%=genJobId %>'>
		
		</tbody>
		</table>
		</div>
<%
			}catch(Exception ee) {
				ee.printStackTrace();
				System.out.println("Exception  in qry: " + ee);
			}

	}
	catch(Exception eee)
	{
		eee.printStackTrace();
		System.out.println("Exception main"+ eee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</form>
</body>
</HTML>

