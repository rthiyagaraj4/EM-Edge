<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2013	 IN034512		Karthi L	A print Option existed next to Close Button in Clinical Event History.																	
17/09/2013	 IN043274		Karthi L  While printing a radiology resulted note from Clinical Event History>Flow sheet, it printed as empty 															
06/03/2014	 ICN060314		Ramesh G		 Error  Unclosed connection detected.
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/11/2015	IN057113		Karthi L							 				ML-MMOH-CRF-0335 - IN057113
12/17/2015  IN058156		Prathyusha					        			Once encounter is closed, there is no way for the user to check if the clinical notes in
                                                                            the event history has been forwarded or modified by another practitioner.  
05/02/2016	IN004500		Raja S												GHL-SCF-1000
10/03/2016  IN059532        Raja S											Alpha-Regression-CA - System displays internal server error in 																			    Clinical Event History.
--------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body  onKeyDown="lockKey()">
	<form name="flowsheet_text_toolbar" id="flowsheet_text_toolbar"> <!-- IN043274 -->
		<%  // added for IN034512 - Start
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String AccessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String histRecType = request.getParameter("Histrectype") == null ? "" : request.getParameter("Histrectype"); //IN058156 //IN059532 added null check
		String contrSysId = request.getParameter("Contrsysid") == null ? "" : request.getParameter("Contrsysid"); //IN058156  //IN059532 added null check
		String noteHeaderDesc = "";
		PreparedStatement pstmt1 =	null; 
		ResultSet rs1 =	null; 
		Connection con = null;
		String confidentialPinReq = "N"; //ML-MMOH-CRF-0335 - IN057113				
		try {
			con = ConnectionManager.getConnection(request);
			String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ib, ca_note_type ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note a WHERE a.accession_num = ?";		
			pstmt1 = con.prepareStatement(sqlQuery);

			pstmt1.setString(1,locale);
			pstmt1.setString(2,AccessionNum);		
		
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				noteHeaderDesc		=	rs1.getString("note_header_desc")==null?"":rs1.getString("note_header_desc") ;
			}
			//ML-MMOH-CRF-0335 - IN057113 - Start
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			String selectSql = "SELECT CONF_PIN_REQ_YN FROM CA_PARAM WHERE MODULE_ID = 'CA'";
			pstmt1 = con.prepareStatement(selectSql);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				confidentialPinReq = rs1.getString("CONF_PIN_REQ_YN");
			}
			//ML-MMOH-CRF-0335 - IN057113 - End
		}
		catch(Exception ee)
		{
			out.println(ee.toString());
			ee.printStackTrace();
		}
		finally {
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(con!=null)	con.close();	//added for ICN060314
		}
		%>
		<input type="hidden" name="accession_num" id="accession_num" value='<%=AccessionNum%>'> <!-- IN043274 -->
		<input type="hidden" name="l_conf_pin_req_yn" id="l_conf_pin_req_yn" value='<%=confidentialPinReq%>'><!-- ML-MMOH-CRF-0335 - IN057113 - Start  -->
		<table align='right'><tr>
			<%
			//IN058156 start
			if(histRecType.equals("CLNT")&&contrSysId.equals("CA")){  //IN059532
			%>			
			    <td align='right'><input type='button' class='button' value='<fmt:message key="eCA.AuditLink.label" bundle="${ca_labels}"/>' onclick="return showNotesAuditFlow('<%=AccessionNum%>')"  /></td>
			<%
			}
			//IN058156 end
			%>
			<!-- added below lines for IN034512 -->
			<% if(!noteHeaderDesc.equals("")) { %>
				<td align='right'><input type='button' class='button' value='Print' onclick='printData()'>
				<input type="hidden" name="sourceprint" id="sourceprint" value='CEH'></td>  <!-- added below lines for IN004500 -->
			<%
			}
			%>
			
			<td align='right'><input type='button' class='button' value='Close'  onClick=window.close()></td>
			
		</tr></table>
	</form>
	</body>
</html>

