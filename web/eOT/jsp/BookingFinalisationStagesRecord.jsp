<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = ((String)session.getAttribute("LOCALE"));
request.setCharacterEncoding("UTF-8");
 String imgUrl="";
if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/BookingFinalisationStages.js'></script>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script language="javascript" src="../../eOT/js/OTMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
String source=request.getParameter("source");
String facility_id=(String) session.getAttribute("facility_id");
String mode=request.getParameter("update_mode_yn");
String specific_ind=request.getParameter("specific_ind");
String user_id_disable="";
String disabled="";
if (mode.equals("modify"))
mode="U";
else 
mode="I";

if(specific_ind.equals("*ALL")){
		user_id_disable="disabled";
		disabled="disabled";
}else{
		user_id_disable="";
		disabled="";
}



String stage_code = checkForNull(request.getParameter("stage_code"));
String user_id="";
String user_name="";
String sql="";
int index=0;
int no_of_records=0;
sql="SELECT A.STAGE_CODE, A.FACILITY_ID, A.APPL_USER_ID, B.APPL_USER_NAME FROM OT_BOOKING_FIN_STAGES_DTL A, SM_APPL_USER B WHERE A.APPL_USER_ID = B.APPL_USER_ID AND A.STAGE_CODE =? ORDER BY 1";
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,stage_code);
	rs=stmt.executeQuery();

	
	while(rs.next())
	{
		index++;
		user_id=rs.getString(3);
		user_name=java.net.URLEncoder.encode(rs.getString(4));	
        
	   out.println("<script>loadDBRows('"+user_id+"','"+user_name+"','"+index+"','L');</script>");
	   //L mode means the record retreived from database

	}
	no_of_records=index;
	

	out.println("<script>refresh()</script>");
	//out.println("<script>assignRecID()</script>");*/
}catch(Exception e)
{
	System.err.println("Error in Booking Finalization Stages records.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){}
}
%>
<form name="BookingFinalisationStagesRecordForm" id="BookingFinalisationStagesRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>

<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="user_name" id="user_name" value=""  size='20' maxlength='30' onBlur="if(this.value!='')callUsercode(user_id,user_name);clearDesc()" >
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" <%=user_id_disable%> onClick='callUsercode(user_id,user_name);' >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label" width='25%'>
		<fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="user_id" id="user_id" value="" size='6' maxlength='6' readonly  >
	
	</td>
</tr>


<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>

<tr>
	<td></td>
	<td></td>
   <td></td>
    <td class='fields' >
	<input type='button' class='button' name='select' id='select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disabled%>  >
	<input type='button' class='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disabled%> ></td>
	
</tr>

</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='params' id='params' value='<%=request.getParameter("source")%>'>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='stage_code' id='stage_code' value="<%=stage_code%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='no_of_records' id='no_of_records' value="<%=no_of_records%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


