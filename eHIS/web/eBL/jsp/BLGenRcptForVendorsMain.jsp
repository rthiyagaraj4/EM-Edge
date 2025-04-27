<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
28-JAN-2019      100           	Aravindh.H          Created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eBL.*,com.ehis.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eBL/js/BLGenRcptForVendorsScript.js'></script>

<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	System.out.println("Aravindh->BLGenRcptForVendorsMain.jsp: " + source);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	CallableStatement cstmt = null;
	
	String practoCashCounterCode = "", practoUser = "", practoSlmtType = "", cashCtrCode = "", cashierShift = "", errorCode = "";
	try {
		con = ConnectionManager.getConnection(request);
		boolean siteSpecCashCtrChk = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_VLDT_CSH_CTR_CHK");
		boolean flagDefChk = true;
		String facilityId = (String) session.getAttribute("facility_id");
		String locale = (String) session.getAttribute("LOCALE");
		Properties p = (Properties) session.getValue( "jdbc" ) ;
		String clientIpAddress	= p.getProperty("client_ip_address");
		if(siteSpecCashCtrChk) {
			
			String sql = "SELECT def_practo_cash_ctr_code, def_practo_user, def_practo_slmt_type FROM bl_parameters WHERE operating_facility_id = '"+facilityId+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				practoCashCounterCode = nulltoStr(rst.getString("def_practo_cash_ctr_code"));
				practoUser = nulltoStr(rst.getString("def_practo_user"));
				practoSlmtType = nulltoStr(rst.getString("def_practo_slmt_type"));
			}
			
			if("".equals(practoCashCounterCode)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Cash Counter');alert(msg);</script>");
			} else if("".equals(practoUser)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Cash Counter User');alert(msg);</script>");
			} else if("".equals(practoSlmtType)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Settlement Type');alert(msg);</script>");
			}
			
			if(flagDefChk) {
				cstmt = con.prepareCall("{ call bl_user_check_for_cash_counter(?,?,?,?,?,?,?) }");
				cstmt.setString(1, facilityId);
				cstmt.setString(2, "R");
				cstmt.setString(3, practoUser);
				cstmt.setString(4, clientIpAddress);
				cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
				
				cstmt.execute();
				
				cashCtrCode = nulltoStr(cstmt.getString(5));
				cashierShift = nulltoStr(cstmt.getString(6));
				errorCode = nulltoStr(cstmt.getString(7));
				
				if(!"".equals(errorCode)) {
					flagDefChk = false;
					Hashtable messageHashtable=new Hashtable();
					messageHashtable = MessageManager.getMessage(locale, errorCode, "BL");
					String msg= (String)messageHashtable.get("message");
					out.println("<script>alert('"+msg+"');</script>");
				}
			}
			System.out.println("Printing line in main.jsp");
		}
%>
		<% if(flagDefChk) { %>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='genRcptForVendorsSrch' id='genRcptForVendorsSrch' id='genRcptForVendorsSrch' src='../../eBL/jsp/BLGenRcptForVendorsSearch.jsp' frameborder=0 noresize scrolling='no' style='height:30vh;width:100vw'></iframe>
			<iframe name="genRcptForVendorsRslt" id="genRcptForVendorsRslt" id='genRcptForVendorsRslt' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:52vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
		<%} %>			
<body>
</body>
<%
	} catch(Exception e) {
			System.err.println("Error in BLGenRcptForVendorsMain: "+e);
			e.printStackTrace();
	}
%>

<%!
private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
}
%>
</html>

