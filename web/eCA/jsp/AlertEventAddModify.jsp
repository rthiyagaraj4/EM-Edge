<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../js/AlertEvent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
<%
Connection con=null;
try
{	
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rset=null;
	String mode="";
	String readOnly = "";
	String sql="";
	String sql1="";
	//String sql2="";
	String status="";
	String event_id="";
	String event_id1="";
	String event_desc="";
	String event_desc1="";
	String txtCategoryCode="";
	String category_desc="";
	String category_code="";
	String action_event="";
	String action_desc="";
	String document_name="";
	String document_desc="";
	String actionby_name="";
	String actionby_desc="";
	String triggering_name="";
	String triggering_desc="";
	String oneTime="oneTime";
	String continues="continues";
	String eff_status="E";

	String dispACTION_EVENT = "";
	String dispDOUMENT_REF = "";
	String dispACTION_BY = "";
	String dispACTION_FREQ = "";
	String dispACTION_GRACE_TIME = "";
	String dispACTION_GRACE_UNIT = "";
	String dispACTION_CONT_CNT = "";
	String dispACTION_CONT_TIME = "";
	String dispACTION_TRIGGER_BY = "";
	String dispEFF_STATUS = "";
	String dispACTION_CONT_UNIT = "";
	

	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	event_id=(request.getParameter("event_id")==null)?"":request.getParameter("event_id");
	try
	{
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			
			sql ="select * from CA_ALERT_EVENT where ALERT_EVENT_CODE=?" ;
			stmt=con.prepareStatement(sql);
			stmt.setString(1,event_id);
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 event_id		=(rs.getString("ALERT_EVENT_CODE")==null)?"":rs.getString("ALERT_EVENT_CODE");
				 event_desc		=(rs.getString("ALERT_EVENT_DESC")==null)?"":rs.getString("ALERT_EVENT_DESC");				
				 txtCategoryCode		=(rs.getString("ALERT_CATEG_CODE")==null)?"":rs.getString("ALERT_CATEG_CODE");	
				dispACTION_EVENT = rs.getString("ACTION_EVENT") == null ? "" : rs.getString("ACTION_EVENT");
				dispDOUMENT_REF = rs.getString("DOUMENT_REF") == null ? "" : rs.getString("DOUMENT_REF");
				dispACTION_BY = rs.getString("ACTION_BY") == null ? "" : rs.getString("ACTION_BY");
				dispACTION_FREQ = rs.getString("ACTION_FREQ") == null ? "" : rs.getString("ACTION_FREQ");
				dispACTION_GRACE_TIME  = rs.getString("ACTION_GRACE_TIME") == null ? "" : rs.getString("ACTION_GRACE_TIME");
				dispACTION_GRACE_UNIT = rs.getString("ACTION_GRACE_UNIT") == null ? "" : rs.getString("ACTION_GRACE_UNIT");
				dispACTION_CONT_CNT = rs.getString("ACTION_CONT_CNT") == null ? "" : rs.getString("ACTION_CONT_CNT");
				dispACTION_CONT_TIME  = rs.getString("ACTION_CONT_TIME") == null ? "" : rs.getString("ACTION_CONT_TIME");
				dispACTION_TRIGGER_BY  = rs.getString("ACTION_TRIGGER_BY") == null ? "" : rs.getString("ACTION_TRIGGER_BY");
				dispEFF_STATUS = rs.getString("EFF_STATUS") == null ? "" : rs.getString("EFF_STATUS");
				dispACTION_CONT_UNIT  = rs.getString("ACTION_CONT_UNIT") == null ? "" : rs.getString("ACTION_CONT_UNIT");				 
			}
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();
				
	}
	//else	if(mode.trim().equalsIgnoreCase("insert"))
		//enabled_checked1="checked";

}catch(Exception e)
{	
	e.printStackTrace();
}


%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="alertevent_form" id="alertevent_form" action="../../servlet/eCA.AlertEventServlet" method="post" target="messageFrame">

<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>
<tr>
<%
	if(mode.trim().equalsIgnoreCase("update")) 
	{status="disabled"; readOnly = "readonly";}
	
	if(mode.trim().equalsIgnoreCase("insert")){status="enabled";readOnly = "";}
	%>
	<td class=label ><fmt:message key="eCA.AlertEventCode.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="text" name="event_id" id="event_id" value="<%=event_id%>" <%=status%>
	 size=10 maxlength=10 onBlur='ChangeUpperCase(this)' onkeypress="return CheckForSpecChars(event)" ><img src='../../eCommon/images/mandatory.gif'></td>	
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.AlertEventDescription.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="text" name="event_desc" id="event_desc" value="<%=event_desc%>"  size=30 maxlength=30 onBlur = "return makeValidString(this)"  ><img src='../../eCommon/images/mandatory.gif'></td>	
</tr>

<%	
	if(mode.trim().equalsIgnoreCase("update"))
	{
	 sql1 ="SELECT  ALERT_CATEG_DESC FROM CA_ALERT_CATEG WHERE ALERT_CATEG_CODE=?";			
	  pstmt=con.prepareStatement(sql1);
	  pstmt.setString(1,txtCategoryCode);
	  rset = pstmt.executeQuery();
	 

	 if(rset.next())
	 {
		category_desc=(rset.getString("ALERT_CATEG_DESC")== null)? "":rset.getString("ALERT_CATEG_DESC");
		category_code=txtCategoryCode;
		
		if(category_desc.equals(""))
		{
			category_desc="";
			category_code="";
		}
	 }
  }
 %>
<tr>					
	<td class='label' width='18%'><fmt:message key="eCA.AlertCategoryCode.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='30%'> <input type="Text" name="txtCategoryCode" id="txtCategoryCode" value = "<%=category_desc%>" <%=status%>  size="25" OnKeyPress='return CheckForSpeChar(event)' Onblur='getCode(this)'><input type="hidden" name ="CategoryCode" value="<%=category_code%>"><input type='button' class='button' name='buttonCategory' id='buttonCategory' value='?' OnClick='populateCategoryLookup()'><img src='../../eCommon/images/mandatory.gif'></img></td>  
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.ActionEvent.label" bundle="${ca_labels}"/></td>
	 
	<%

			String sql2 ="SELECT KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AE' ORDER BY 2";
			
			pstmt = con.prepareStatement(sql2);
			rset = pstmt.executeQuery();

			%>
			<td><select name="action_event" id="action_event" ><option value=""  >------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------</option>
			
			<%

			while(rset.next())
			{			
				action_event=rset.getString(1) == null ? "" : rset.getString(1);
				action_desc=rset.getString(2) == null ? "" : rset.getString(2);
				
				if(dispACTION_EVENT.equals(action_event)) 
					out.println("<option value='"+action_event+"' selected>"+action_desc+"</option>");
				else
					out.println("<option value='"+action_event+"'>"+action_desc+"</option>");
			}

	%>
		</select></td></tr>
</tr>

<tr>
	<td class=label ><fmt:message key="eCA.DocumentName.label" bundle="${ca_labels}"/></td>
	 
	<%

			String sql3 ="SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE EFF_STATUS='E' ORDER BY 2 ";
			
			pstmt = con.prepareStatement(sql3);
			rset = pstmt.executeQuery();

			%>
			<td><select name="document_name" id="document_name" ><option value="" selected >------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------</option>
			
			<%

			while(rset.next())
			{
				
				document_name=rset.getString(1) == null ? "" : rset.getString(1);
				document_desc=rset.getString(2) == null ? "" : rset.getString(2);	

				if(dispDOUMENT_REF.equals(document_name))
					out.println("<option value='"+document_name+"' selected>"+document_desc+"</option>");
				else
					out.println("<option value='"+document_name+"'>"+document_desc+"</option>");
			}

	%>
		</select></td></tr>
		<tr>

	<tr>
	<td class=label ><fmt:message key="eCA.ActionBy.label" bundle="${ca_labels}"/></td>
	 
	<%

			String sql4 ="SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AB' ORDER BY 2  ";
			
			pstmt = con.prepareStatement(sql4);
			rset = pstmt.executeQuery();

			%>
			<td><select name="action_by" id="action_by" ><option value="" selected >------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------</option>
			
			<%

			while(rset.next())
			{
				actionby_name=rset.getString(1) == null ? "" : rset.getString(1);
				actionby_desc=rset.getString(2) == null ? "" : rset.getString(2);	

				if(dispACTION_BY.equals(actionby_name))
					out.println("<option value='"+actionby_name+"' selected>"+actionby_desc+"</option>");
				else
					out.println("<option value='"+actionby_name+"'>"+actionby_desc+"</option>");
			}

			String selFreqC = "";
			String selFreqO = "";
			String selGrH = "";
			String selGrD = "";
			String selGrW = "";
			String selGrY = "";
			String selConH = "";
			String selConD = "";
			String selConW = "";
			String selConY = "";
			String styleFreqC = "display:none";
			String styleFreqO = "display:none";

			if(dispACTION_FREQ.equals("C"))
			{
				selFreqC = "CHECKED";
				selFreqO = "";
				styleFreqC = "display:none";
				styleFreqO = "display";
			}
			else
			{
				selFreqC = "";
				selFreqO = "CHECKED";
				styleFreqC = "display";
				styleFreqO = "display:none";
			}

			if(dispACTION_GRACE_UNIT.equals("H"))
			{
				selGrH = "selected";
				selGrD = "";
				selGrW = "";
				selGrY = "";
			}
			else if(dispACTION_GRACE_UNIT.equals("D"))
			{
				selGrH = "";
				selGrD = "selected";
				selGrW = "";
				selGrY = "";
			}
			else if(dispACTION_GRACE_UNIT.equals("W"))
			{
				selGrH = "";
				selGrD = "";
				selGrW = "selected";
				selGrY = "";
			}
			else if(dispACTION_GRACE_UNIT.equals("Y"))
			{
				selGrH = "";
				selGrD = "";
				selGrW = "";
				selGrY = "selected";
			}

			if(dispACTION_CONT_UNIT.equals("H"))
			{
				selConH = "selected";
				selConD = "";
				selConW = "";
				selConY = "";
			}
			else if(dispACTION_CONT_UNIT.equals("D"))
			{
				selConH = "";
				selConD = "selected";
				selConW = "";
				selConY = "";
			}
			else if(dispACTION_CONT_UNIT.equals("W"))
			{
				selConH = "";
				selConD = "";
				selConW = "selected";
				selConY = "";
			}
			else if(dispACTION_CONT_UNIT.equals("Y"))
			{
				selConH = "";
				selConD = "";
				selConW = "";
				selConY = "selected";
			}




	%>
		</select></td></tr>
		<tr>

<tr>
<td class=label ><fmt:message key="eCA.ActionFrequency.label" bundle="${ca_labels}"/></td>
	<td class='fields' >								   
	    <INPUT name="byselect" id="byselect"  TYPE="radio" VALUE="O" <%=selFreqO%> onClick="hideShowRowPeriod()"><fmt:message key="eCA.Onetime.label" bundle="${ca_labels}"/>  
		<INPUT name="byselect" id="byselect"  TYPE="radio" VALUE="C" <%=selFreqC%> onClick="hideShowRowPeriod()" > <fmt:message key="eOR.Continuous.label" bundle="${or_labels}"/>
	</td>		
	</tr>
	<tr>
	<td class=label ><fmt:message key="eCA.ActionPeriod.label" bundle="${ca_labels}"/></td>
	<td class='label' id="with_in" style='<%=styleFreqC%>'><fmt:message key="Common.within.label" bundle="${common_labels}"/> <input type="text" name="action_within" id="action_within" size=2 maxlength=2 onkeypress="return CheckForNums(event)" value='<%=dispACTION_GRACE_TIME%>'>
	<select name="within" id="within">
	<option value='H' <%=selGrH%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
	 <option value='D' <%=selGrD%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
	<option value='M' <%=selGrW%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
	<option value='Y' <%=selGrY%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
</select>
<td class = 'label' id="in_every" style='<%=styleFreqO%>'><input type="text" name="action_inevery1" id="action_inevery1" size=2 maxlength=2 value='<%=dispACTION_CONT_CNT%>' onkeypress="return CheckForNums(event)"> <fmt:message key="eCA.inEvery.label" bundle="${ca_labels}"/> <input type="text" name="action_inevery2" id="action_inevery2" size=2 maxlength=2 value='<%=dispACTION_CONT_TIME%>' onkeypress="return CheckForNums(event)">
	<select name="inevery" id="inevery">
	<option value='H' <%=selConH%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
	 <option value='D' <%=selConD%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
	<option value='M' <%=selConW%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
	<option value='Y' <%=selConY%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
</select>
</td>
</tr>

<tr>
	<td class=label ><fmt:message key="eCA.TriggeringTime.label" bundle="${ca_labels}"/></td>
	 
	<%

			String sql5 ="SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='TT' ORDER BY 2  ";
			
			pstmt = con.prepareStatement(sql5);
			rset = pstmt.executeQuery();

			%>
			<td><select name="triggering_time" id="triggering_time" ><option value="" selected >------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------</option>
			
			<%

			while(rset.next())
			{
				
				triggering_name=rset.getString(1) == null ? "" : rset.getString(1);
				triggering_desc=rset.getString(2) == null ? "" : rset.getString(2);	

				if(dispACTION_TRIGGER_BY.equals(triggering_name))
					out.println("<option value='"+triggering_name+"' selected>"+triggering_desc+"</option>");
				else
					out.println("<option value='"+triggering_name+"'>"+triggering_desc+"</option>");
			}

			String enbEff = "";

			if(dispEFF_STATUS.equals("E"))  enbEff = "checked";
			else enbEff = "";

	%>
		</select></td></tr>
		<tr>
			<td  class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td  class='fields'><INPUT TYPE="checkbox" name="enabled" id="enabled" <%=enbEff%> value='<%=eff_status%>'></td>
		</tr>

</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="event_id1" id="event_id1" value="<%=event_id1%>">
<input type=hidden name="event_desc1" id="event_desc1" value="<%=event_desc1%>">
<input type=hidden name="eff_status" id="eff_status" value="">
</form>
</body>
</html>
<%
}
catch(Exception e)
{	
e.printStackTrace();
}
finally
{
    
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT LANGUAGE="JavaScript">
//parent.commontoolbarFrame.document.getElementById("apply").disabled = false;
</SCRIPT>

