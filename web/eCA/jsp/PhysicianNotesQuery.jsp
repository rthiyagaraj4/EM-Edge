<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src="../../eCommon/js/DateValidation.js"></script>
<script Language="JavaScript" src='../../eCA/js/PhysicianNote.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script language='javascript'   src='../../eCA/js/DateCheck.js' ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection con			=null;
PreparedStatement stmt			=null;
ResultSet rset			=null;
String patient_id		="";
String note_type		="";
String short_note_desc	="";
String clinician_id		="";
String clinician_name	="";
String splty_code		="";
String splty_desc		="";
String sql_notetype		="";
String today	=	"";
String p_event_class	=request.getParameter("p_event_class");
String episode_id		=request.getParameter("episode_id");
String visit_id			=request.getParameter("visit_id");
String episode_type		=request.getParameter("episode_type");
patient_id				=request.getParameter("patient_id");
String cur_episode		="";
String facilityid		= (String) session.getValue("facility_id");

if(episode_type !=null && episode_type.equals("O")) {
cur_episode="Current Visit Only";
}
else if(episode_type !=null && episode_type.equals("I")){
cur_episode="Current Admission Only";
}


try
	{
	con = ConnectionManager.getConnection(request);

%>


<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='physican_note' id='physican_note'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	
	<tr>
	<td class='label'  width='25%'><fmt:message key="eCA.NoteType.label" bundle="${ca_labels}"/></td>
	<td class='fields'  width='25%'>
	<select name='note_type' id='note_type'><option value=''>&nbsp; ----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
	<%
	//THIS IS FOR POPULATING  NOTE_TYPE
	stmt = null;
	rset = null;
	sql_notetype="Select note_type,note_type_desc from ca_note_type order by 2";
	stmt=con.prepareStatement(sql_notetype);
	rset=stmt.executeQuery();
	if(rset!=null)
		{
		while(rset.next())
			{
			note_type=rset.getString("note_type");
			short_note_desc =rset.getString("note_type_desc");
			out.println("<option value='"+note_type+"'>"+short_note_desc);

			}
		}
		if(rset!=null)rset.close();
		String 	sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
		today = rset.getString("today");
		}
%>
		</select>
	</td>
	<td class=label width='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%' nowrap><input type='text' size=10 maxlength='10' name='from_date' id='from_date' value='' onblur="CheckDate(this);CheckSystemDateLesser(this,'<%=today%>')"><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');"></td>&nbsp;-&nbsp;<input type='text' size=10 maxlength='10' name='to_date' id='to_date' value='' onblur="CheckDate(this);CheckSystemDateLesser(this,'<%=today%>')"><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');"></td>
	<!--<td class=label width = '' align="right" nowrap>Last&nbsp;&nbsp;</td>
	<td><input type='text' size=3 maxlength='3' name='last_notes' id='last_notes' value=''></td>
	<td class=label align="left" class='label' nowrap>Notes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>-->
	</tr>
<!--
	<tr>
		<td class=label colspan='10'>&nbsp;&nbsp;</td>
	</tr>
 -->
	<tr>
	<td class=label width="25%" ><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
	<td class='fields'" width="15%" >
	<select name='performed_by' id='performed_by'><option value=''>&nbsp; ----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
	<%
	//THIS IS FOR POPULATING  PERFORM BY
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
	sql_notetype="Select PRACTITIONER_ID clinician_id,PRACTITIONER_NAME clinician_short_name from am_pract_for_facility_vw where OPERATING_FACILITY_ID = ? order by 2";
	stmt=con.prepareStatement(sql_notetype);
	stmt.setString(1,facilityid);
	rset=stmt.executeQuery();
	if(rset!=null)
		{
		while(rset.next())
		{
			clinician_id=rset.getString("clinician_id");
			clinician_name =rset.getString("clinician_short_name");
			out.println("<option value='"+clinician_id+"'>"+clinician_name);

			}
		}
%>
		</select>
	</td>
	<td class=label width="25%" ><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
	<td class='fields' width="25%" ><select name='med_anc' id='med_anc'><option value=''>&nbsp; ----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
	<%
	//THIS IS FOR POPULATING  MED/ANC
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
	sql_notetype="Select service_code splty_code,short_desc from am_service  where eff_status ='E' order by 2";
	stmt=con.prepareStatement(sql_notetype);
	rset=stmt.executeQuery();
	if(rset!=null)
		{
		while(rset.next())
			{
			splty_code=rset.getString("splty_code");
			splty_desc =rset.getString("short_desc");
			out.println("<option value='"+splty_code+"'>"+splty_desc);

			}
		}
%>
		</select>
	</td>
	</tr>
	<!-- <tr>
		<td class=label colspan='10'>&nbsp;&nbsp;</td>
	</tr> -->
	<tr>
		<td class=label width='25%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'  ><select name='status' id='status'><option value=''>&nbsp; ----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
		<option value='3'><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></option>
		<option value='4'><fmt:message key="eCA.Authorized.label" bundle="${ca_labels}"/></option>
		<option value='5'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
		<option value='9'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	<%
		if(!(cur_episode.equals("")))
		{
	%>

		<td class=label width='25%' ><%=cur_episode%></td>
		<td class='fields' width='25%' ><input type='checkbox' value='Y' name='cur_epi' id='cur_epi' checked></input></td>
	<%
		}
		else
		{
	%>
		<td class=label  width='25%'>&nbsp;</td>
		<td class=label  width='25%'>&nbsp;</td>
	<%
		}
	%>
	</tr>
	<tr><td class=label  width='25%'>&nbsp;</td><td class=label  width='25%'>&nbsp;</td><td class=label  width='25%'>&nbsp;</td>
		<td  width = '25%'><input type="button" class='Button' name="searchresult_button" id="searchresult_button" title='search_result' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="search_result();">&nbsp;<input type="button" class='Button' name="clear_form" id="clear_form" title='clearing' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick='clear_result()'></td>
		
	</tr>
</table>
<input type=hidden value='<%=p_event_class%>' name='p_event_class' ></input>
<input type=hidden value='<%=patient_id%>' name='patient_id' ></input>
<input type=hidden value='<%=episode_type%>' name='episode_type' ></input>
<input type=hidden value='<%=episode_id%>' name='episode_id' ></input>
<input type=hidden value='<%=visit_id%>' name='visit_id' ></input>
</form>
</body>
<%

	if(rset !=null) rset.close();
	if(stmt !=null) stmt.close();		
}catch(Exception e)
{

//out.println("EXCEPTION"+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
	
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

