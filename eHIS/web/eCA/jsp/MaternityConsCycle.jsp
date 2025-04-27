<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
String queryString = request.getQueryString() == null ? "" : request.getQueryString();
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String cycle_status=request.getParameter("cycle_status")== null ? "" : request.getParameter("cycle_status");
String splty_title_event_desc=request.getParameter("splty_title_event_desc") == null ? "" : request.getParameter("splty_title_event_desc");
String SQL1="SELECT CYCLE_NO, CYCLE_STATUS  FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 2 desc, 1 desc";
String selected = "";

Connection con = null;
PreparedStatement pstmt1 = null;
ResultSet rs1 = null;

int cycle_no=0;;


try{
con = ConnectionManager.getConnection(request);
}catch(Exception e){
	e.printStackTrace() ;
}

try{
pstmt1=con.prepareStatement(SQL1);
pstmt1.setString(1,patient_id);
pstmt1.setString(2,module_id);
rs1	 =pstmt1.executeQuery();
if (rs1.next())
{
	cycle_no=Integer.parseInt(rs1.getString(1));
	cycle_status=rs1.getString(2);
}
if(rs1!=null)
	rs1.close();
if(pstmt1!=null)
	pstmt1.close();	
%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="callfunction()">
<FORM METHOD=POST ACTION="" name="tempmaternityMenu" id="tempmaternityMenu">
<TABLE width='100%' align='center' border=0 cellspacing=0>
<!--<tr>
	<TD class='label'  WIDTH='100%' colspan='4'><b><a href='javascript:loadSpecialtyEventHistScreen("<%=module_id%>","<%=patient_id%>","<%=cycle_no%>")'>View Splty Event Hist</a></b></TD>
</tr> -->
<tr><td colspan='6'>&nbsp;</td></tr>
<TR>	
	<TD class='label' colspan=''><fmt:message key="eCA.Cycle.label" bundle="${ca_labels}"/>&nbsp;
<%
if(!(cycle_status.equals("O"))){
%>
<!-- <a href='javascript:loadeventscycle()'><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;</a> -->
<%}


	int cycle_dummy_val=cycle_no;
	if(cycle_no>=0){
		if(cycle_no==0)
			cycle_dummy_val=cycle_dummy_val+1;	
		%>
		<%//if(cycle_no>=4)
		{%>
			<select name='cycle_select' id='cycle_select' onchange='loadeventselect(this)' style='width:65;FONT-SIZE:8pt'>
			<%
			if(!(cycle_status.equals("O"))){
			%>
				<option value=''><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;</option>
			<%}%>
			<%while(cycle_dummy_val>0)
				{
					if(cycle_no == cycle_dummy_val) selected = " selected ";
					else selected = "";
				%>
				<option value='<%=cycle_dummy_val%>' <%=selected%>><%=cycle_dummy_val%></option><%cycle_dummy_val--;
			}%>
		</select><%}
	}
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>
</TD>
<td align='center'>
<%
if((cycle_status.equals("O"))){
%>
&nbsp;<img src = '../../eCA/images/MCT_NewEvent.gif' id='newEventID' onclick="javascript:loadeventscycle('NewEvent')" TITLE='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ClickHereToCreateaNewEvent.label","ca_labels")%>'></img>
<%
}
%>
<img src = '../../eCA/images/MCT_OBHome.gif' onclick="callHomePage()" TITLE='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MaternityHomePage.label","ca_labels")%>' style='display:none'></img>
</TD>
</TR>
<TR><TD colspan='6'>&nbsp;</TD></TR>
</TABLE>
<input type=hidden name='queryString' id='queryString' value='<%=queryString%>'>
<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type=hidden name='splty_title_event_desc' id='splty_title_event_desc' value='<%=splty_title_event_desc%>'>
</FORM>
</body>
</html>

