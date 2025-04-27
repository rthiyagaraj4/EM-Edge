<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%
String queryString = request.getQueryString() == null ? "" : request.getQueryString();
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String progression_status=request.getParameter("progression_status")== null ? "" : request.getParameter("progression_status");
String splty_title_event_desc=request.getParameter("splty_title_event_desc") == null ? "" : request.getParameter("splty_title_event_desc");

String called_from=request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String progression_ref=request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");

/*
The below Query was changed by
Name   : DINESH T
Date   : 2010-05-03
INCNO  : 21026
Changes: Added an extra condition called_from = ? in the query and an extra setString statement for the same
*/
String SQL1="SELECT PROGRESSION_CYCLE_NO, PROGRESSION_STATUS FROM CA_PAT_PROGRESSION_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CALLED_FROM = ? ORDER  BY 1 desc ";

String selected = "";
//String cycle_no = "";

Connection con = null;
PreparedStatement pstmt1 = null;
ResultSet rs1 = null;

int progression_no=0;;


try{
con = ConnectionManager.getConnection(request);
}catch(Exception e){
	e.printStackTrace() ;
}

try
{
		pstmt1=con.prepareStatement(SQL1);
		pstmt1.setString(1,patient_id);
		pstmt1.setString(2,module_id);
		pstmt1.setString(3,called_from);
		rs1	 =pstmt1.executeQuery();
	if (rs1.next())
	{
		progression_no=Integer.parseInt(rs1.getString(1));
		progression_status=rs1.getString(2);
	}
	
	if(rs1!=null) 		rs1.close();
	if(pstmt1!=null) 	pstmt1.close();	

	if(called_from.equals("OH_TREATMENT"))
	{
		if(progression_ref.equals(""))
		{
			progression_no=0;
		}
		else
		{
			progression_no=1;
		}


	}


%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="callfunction()">
<FORM METHOD=POST ACTION="" name="tempmaternityMenu" id="tempmaternityMenu">
	<TABLE width='100%' align='center' border=0 cellspacing=0>

		<tr><td colspan='6'>&nbsp;</td></tr>
		<TR>	
			<TD class='label' colspan=''><fmt:message key="eCA.Progression.label" bundle="${ca_labels}"/>&nbsp;

<%

	int cycle_dummy_val=progression_no;
	if(progression_no>=0)
		{
		if(progression_no==0)
			cycle_dummy_val=cycle_dummy_val+1;	
%>
			<select name='progression_select' id='progression_select' onchange='loadeventselect(this)' style='width:79;FONT-SIZE:8pt'>
			
<%  
				
				while(cycle_dummy_val>0)
				{
					if(progression_no == cycle_dummy_val) selected = " selected ";
					else selected = "";
%>
					<option value='<%=cycle_dummy_val%>' <%=selected%>><%=cycle_dummy_val%></option>
<%
					cycle_dummy_val--;
				}
			if(!called_from.equals("OH_TREATMENT"))
			{
%>
			<option value='S' ><fmt:message key="eCA.ShowActive.label" bundle="${ca_labels}"/></option>
			<option value='C' ><fmt:message key="eCA.ShowClosed.label" bundle="${ca_labels}"/></option>
			<option value='A' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='' ><fmt:message key="eCA.AddNewP.label" bundle="${ca_labels}"/></option>
			</select>
<%
		}
		}
	
}
catch(Exception e)
{
	e.printStackTrace() ;
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>
</TD>
<td align='center'>
<%
//Below one commented if condition " if((progression_status.equals("O"))) " is removed  by Archana Dhal on 4/29/2010 for IN020883.
%><!--
&nbsp;<img src = '../../eCA/images/MCT_NewEvent.gif' id='newEventID' onclick="javascript:loadeventscycle('NewEvent')" TITLE='Click Here to Open New Progression '></img>-->
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

