<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
24-JAN-2018      100           	Aravindh.H          Created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eBL.*,com.ehis.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String reportId="BLRPSAD";
		String locale = (String)session.getAttribute("LOCALE");
		String facilityId = (String)session.getAttribute("facility_id");
		if (facilityId==null) facilityId = "";
		String	strLoggedUser	=  (String) session.getValue("login_user");	
		if (strLoggedUser==null) strLoggedUser = "";

		System.out.println("facilityId:"+facilityId+" strLoggedUser:"+strLoggedUser);

		String params = request.getQueryString();
		if(params==null || params.equals("")) params="";
		
		Connection con = null;
	    PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="";
		int pat_id_len = 0;
		
		try
		{
			con = ConnectionManager.getConnection(request);

			 sql ="select patient_id_length from mp_param";

			 pstmt = con.prepareStatement(sql);
		     rs = pstmt.executeQuery();

			 if (rs != null && rs.next() )
		     {
				pat_id_len = rs.getInt("patient_id_length") ;
		     }
		} catch(Exception e) {
			pat_id_len = 15;//Setting Default Value if exception occured
			out.println(e.toString());
			e.printStackTrace();
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eBL/js/BLPatientWiseSplAgencyDepositTrans.js'></script>
		<script type="text/javascript">
			$(document).ready(function() {
				document.forms[0].fromPatID.focus();
			});
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
		<form name="check" id="check" id="check">
			<table width="90%" align="center" cellpadding=6 cellspacing=0 >
				<tr style="padding-bottom: 10px;">
					<td width="10%" nowrap class='label'  style="text-align: left;" > 
					   <fmt:message key="eBL.Patient_Id_From.label" bundle="${bl_labels}"/>
					</td>
					<td width="20%" nowrap class='fields' style="text-align: left;">
						<input type='text' name='fromPatID' id='fromPatID'  id='fromPatID' value='' maxlength='<%=pat_id_len%>' size='25' onBlur="ChangeUpperCase(this);callPatValidation(this);">&nbsp;
						<input type='button' class='button' value='?' name='fromPatIDSrch' id='fromPatIDSrch' id='fromPatIDSrch' onClick="getPatID(fromPatID)"><img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td width="10%" nowrap class='label'  style="text-align: left;" > 
					   <fmt:message key="eBL.Patient_Id_To.label" bundle="${bl_labels}"/>
					</td>
					<td width="20%" nowrap class='label' style="text-align: left;">
						<input type='text' name='toPatID' id='toPatID'  id='toPatID' value='' maxlength='<%=pat_id_len%>' size='25' onBlur="ChangeUpperCase(this);callPatValidation(this);">&nbsp;
						<input type='button' class='button' value='?' name='toPatIDSrch' id='toPatIDSrch' id='toPatIDSrch' onClick="getPatID(toPatID)">
					</td>
					<td width="20%" nowrap class='label' style="text-align: left;">
						<input type='button' class='button' value='Export to Excel' name='exportToExcelButton' id='exportToExcelButton' id='exportToExcelButton' onClick="downloadExcel()">
					</td>
				</tr>
			</table>
			<input type="hidden" name="locale" id="locale" 		id="locale" 	 value="<%=locale %>">
			<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId %>">
			<input type="hidden" name="report_id" id="report_id" 	id="report_id" 	 value="<%=reportId %>">
			<input type="hidden" name="userid" id="userid" 	    id="userid" 	 value="<%=strLoggedUser %>">
	</body>	
</html>

