<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	Display the leave cancel details and cancel the leave of a staff
*	Created By		:	Krishna Kiran 
*	Created On		:	20 Aug 2009
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

<script language="javascript" src="../js/RecordStaffUnavailability.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
	
	String staff_id = (String)request.getParameter("staff_id")==null?"":(String)request.getParameter("staff_id");
	ArrayList cancelLeaveReasonList = new ArrayList();
	ArrayList cancelLeaveDateList = new ArrayList();
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String disabled = "disabled";
	int totalRows = 0;
	
	
	String getCancelReasonQryString = "SELECT REASON_CODE, REASON_DESC FROM RS_REASON_LANG_VW  WHERE ACTIVITY_TYPE_CODE = ? AND EFF_STATUS = ? AND LANGUAGE_ID = ? ORDER BY REASON_DESC";

	String getCancelLeaveDetailsQueryString ="SELECT TO_CHAR(LEAVE_DATE,'DD/MM/YYYY') CANCELDATE FROM RS_STAFF_UNAVAILABILITY_LOG WHERE LEAVE_DATE > sysdate AND STAFF_ID =? AND CANCEL_REASON_CODE IS NULL ORDER BY LEAVE_DATE";
	
	conn = ConnectionManager.getConnection(request);
	try {
		//to get the Staff Cancel Leave Reasons
		pstmt = conn.prepareStatement( getCancelReasonQryString);
		pstmt.setString(1,"CL");
		pstmt.setString(2,"E");
		pstmt.setString(3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			cancelLeaveReasonList.add( resultSet.getString("REASON_CODE")==null?"":resultSet.getString("REASON_CODE"));
			cancelLeaveReasonList.add( resultSet.getString("REASON_DESC")==null?"":resultSet.getString("REASON_DESC"));
		}
		//out.println(cancelLeaveReasonList);
		if(pstmt != null)
				pstmt.close() ;
			if(resultSet != null)
				resultSet.close();
        
		pstmt = conn.prepareStatement(getCancelLeaveDetailsQueryString);
		pstmt.setString(1,staff_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			cancelLeaveDateList.add( resultSet.getString("cancelDate")==null?"":resultSet.getString("cancelDate"));
		}
        //out.println(cancelLeaveDateList);
		
		//out.println( "addDesc(\"" + Staff_desc + "\",\"" + Position + "\") ; " ) ;			

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		try{
			if(pstmt != null)
				pstmt.close() ;
			if(resultSet != null)
				resultSet.close();
			if(conn != null) 
				conn.close();
			//ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp){
		out.println(exp.toString());
		}
	}

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name='form_RecordStaffUnavailabilityCancelLeaveDtls' id='form_RecordStaffUnavailabilityCancelLeaveDtls' action='../../servlet/eRS.RecordStaffUnavailabilityServlet' method='POST' target='messageFrame'>
<%
  if (cancelLeaveDateList.size()>0){
	  String classValue="";
	  totalRows = cancelLeaveDateList.size();
	 // out.println(totalRows);
  
%>

<table cellpadding="0" cellspacing="0" width="100%"  border=1 align="center"  >
	<TR>
		
		<TH width="50%" align='left'><fmt:message key="Common.date.label" bundle="${common_labels}"/></TH>
		<TH width="50%" align='left'><fmt:message key="eRS.ReasonForCancelLeave.label" bundle="${rs_labels}"/> </TH>
		<TH width="50%" align='left'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type=checkbox name="checkAll" id="checkAll" value="N" onClick ='setAllCancelLeavechecks(this,<%=totalRows %>)'>  </TH>
	</TR>
	<%	for ( int cnt=0; cnt<cancelLeaveDateList.size(); cnt++ ) {
		if(cnt%2 ==0)
			classValue="QRYEVEN";
		else
			classValue="QRYODD";%>
		<tr><TD CLASS="<%=classValue %>" align ='center'><%= cancelLeaveDateList.get(cnt)%>
		<input type= "hidden" name ="date_<%=cnt%>" value ="<%= cancelLeaveDateList.get(cnt)%>">
		</TD>
			<TD CLASS="<%=classValue %>" align='center'>
			  <select name='leaveReasonList_<%=cnt%>' id='leaveReasonList_<%=cnt%>' <%= disabled%>>
				<option value=''>--Select--</option>			
			<%
		     for(int i=0;i<cancelLeaveReasonList.size();i+=2){%>
			  	<option value='<%=cancelLeaveReasonList.get(i)%>'><%=cancelLeaveReasonList.get(i+1)%></option>
			<%
			}
	    	%>
		</select>				
			</TD>
			<TD CLASS="<%=classValue %>" ><input type="checkbox" name="checkCancelLeave_<%=cnt%>" id="checkCancelLeave_<%=cnt%>" onclick = 'setCancelLeaveCheck(this,<%=cnt%>)' value ="N" > 
			</TD></tr>
		
		<%}%>

	
</table>

<%}%>
<input type ='hidden' name ="totalRows" value ="<%=totalRows%>">
<input type ='hidden' name ="staff_id" value ="<%=staff_id%>">
<input type ='hidden' name ="to_date" value ="">
<input type ='hidden' name ="from_date" value ="">
<input type ='hidden' name ="reason" value ="">
<input type ='hidden' name ="role_type" value ="">
<input type ='hidden' name ="call_mode" value ="">
<input type ='hidden' name ="total_string" value ="">
</form>
</body>
</html>

