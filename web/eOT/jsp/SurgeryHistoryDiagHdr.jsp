<!DOCTYPE html>
<HTML>
<%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,oracle.jdbc.driver.*,webbeans.eCommon.*,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>



<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script language="javascript" src="../../eOT/js/OTMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</HEAD>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = "SurgeryHistoryPostOperDiagHdrForm">
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<%


	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String SQL="SELECT POST_OPER_DIAG FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? ";
	String post_oper_diag="";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		if(rst.next()){
			post_oper_diag=CommonBean.checkForNull(rst.getString(1));
		}
	}catch(Exception e){
 		 System.err.println("Err Msg in SurgeryHistoryUnusualOccur.jsp "+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/> </td>
	<td class='fields' width='25%'>
		<textarea name='diagnosis' rows='5' cols='80'  readOnly > <%=post_oper_diag%> </textarea>
	</td>
</tr>
<tr>
	<td colspan='2' class='CAGROUPHEADING'> <fmt:message key="Common.ProblemAssessment.label" bundle="${common_labels}"/> </td> 
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</HTML>

