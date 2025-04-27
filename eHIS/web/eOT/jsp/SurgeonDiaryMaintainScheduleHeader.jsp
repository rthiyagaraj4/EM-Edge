<!DOCTYPE html>


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>

<%

	String facility_id = (String)session.getValue("facility_id");
	//String user_id = (String)session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE"); 
	String surgery_date = 	"";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	}
	catch(Exception e){
		System.err.println("Err Msg SurgeonDiaryMaintainScheduleHeader.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>

<html>
<head><title></title>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript"src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript"type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/SurgeonDiaryMaintainSchedule.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='SurgeonDiaryMaintainScheduleHeader' id='SurgeonDiaryMaintainScheduleHeader' action="../../eOT/jsp/SurgeonDiaryMaintainAddModifySchedule.jsp" target="f_query_search_values">

<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>

<tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%' colspan='3'>
	    <input type='hidden' name='surgeon_code' id='surgeon_code'> 
		<input type='text' name='surgeon_desc' id='surgeon_desc' size='15'  onblur='if(this.value!="")searchSurgeon(surgeon_code,surgeon_desc); else surgeon_code.value="" ' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchSurgeon(surgeon_code,surgeon_desc);" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>


<tr> 
	 <td class='label' width='25%'>
		  <fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> 
	</td>
	 <td class='fields' width='25%'>
		  <input type='text' name='from_date' id='from_date' size='8' maxlength='10'  value='' onBlur="CheckDate(this);">
		  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');">
	 </td>
	 <td class='label' width='25%'>
	       <fmt:message key="Common.todate.label" bundle="${common_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='to_date' id='to_date' size='8' maxlength='10'  value='' onBlur="CheckDate(this);"> 
		  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('to_date');">
	 </td>
</tr>

<tr>
	<td width='25%' colspan=3></td><td width='25%' align='left'>
			<input type="button" class="button" name="search" id="search" value="Search" onClick="callsearch()">	
	</td>
</tr>

</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->

</center>
	<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'> 
	<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 
	<input type='hidden' name='to_date_hidden' id='to_date_hidden' value=""> 
	<input type='hidden' name='from_date_hidden' id='from_date_hidden' value=""> 
</form> 
</body>
</html>

