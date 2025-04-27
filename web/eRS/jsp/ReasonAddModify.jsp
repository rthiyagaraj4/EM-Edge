<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	14 Sept 2004
-->
<!-- ReasonAddModify.jsp-->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
%>


<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Reason.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 -->
</head>
<%
String mode	= request.getParameter("mode");
String operation_type="";
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<br><br><br><br><br><br><br><br><br>
<form name='form_ReasonAddModify' id='form_ReasonAddModify' target='messageFrame' method='post'  action='../../servlet/eRS.ReasonServlet' >
<%
		Vector Activity_list=new Vector();
		String sql="";
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt_reason_desc=null;
		ResultSet rs_reason_desc=null;

		PreparedStatement pstmt_activity=null;
		ResultSet rs_activity=null;
try{

//sql="select activity_type_code,activity_type_desc from rs_activity_type order by activity_type_desc";
sql="SELECT activity_type_code,activity_type_desc FROM rs_activity_type_lang_vw where language_id like ? ORDER BY activity_type_desc";

    pstmt_activity=conn.prepareStatement(sql);
    pstmt_activity.setString(1,locale);

	rs_activity=pstmt_activity.executeQuery();
	while(rs_activity.next()){

		Activity_list.add(rs_activity.getString("activity_type_code")==null?"":rs_activity.getString("activity_type_code"));
		Activity_list.add(rs_activity.getString("activity_type_desc")==null?"":rs_activity.getString("activity_type_desc"));
	}
	}catch(Exception e){
	e.printStackTrace();
	throw e;
}
finally{
	if(rs_activity!=null) rs_activity.close();
	if(pstmt_activity!=null) pstmt_activity.close();
}

if(mode.equalsIgnoreCase("1")){
		operation_type="insert";
	%>
	<table cellpadding=0 cellspacing=0 border=0 width="70%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='reason_code' id='reason_code' value='' size='5' maxlength='4' onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		</tr>
			<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Reason</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="reason_desc" id="reason_desc" value='' size='35' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		</tr>
			<tr><td colspan="5">&nbsp;</td></tr>	
		<tr>
			<!-- <td  width="20%"  align=right class="label">Applicable to</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;
					<select name='activity_type_code' id='activity_type_code'>
						<!-- <option value=''>------Select------</option> -->
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%for(int i=0;i<Activity_list.size();i+=2)
						{%>
						<option value='<%=Activity_list.get(i)%>'><%= (String)Activity_list.get(i+1)%> </option>
						<%}%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif">
				</td>
		</tr>
		</tr>
			<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<td  width="20%"  align='right' class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			
			<td width='60%' align='left'>&nbsp;&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
		</tr>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
	</table>
	<%}
		else
		{
			operation_type="modify";

    		String sql_reason_desc="";
			String reason_code=request.getParameter("reason_code");
			String reason_desc="";
			String selected="";
			String activity_type_code="";
			String eff_status="";
try
{
//sql_reason_desc="select reason_desc,eff_status,activity_type_code from rs_reason where reason_code=?";
sql_reason_desc="SELECT REASON_DESC,EFF_STATUS,ACTIVITY_TYPE_CODE FROM RS_REASON_LANG_VW WHERE REASON_CODE=? AND LANGUAGE_ID LIKE ?";
pstmt_reason_desc=conn.prepareStatement(sql_reason_desc);
pstmt_reason_desc.setString(1,reason_code);
pstmt_reason_desc.setString(2,locale);
rs_reason_desc=pstmt_reason_desc.executeQuery();
while(rs_reason_desc.next())
	{
		reason_desc=rs_reason_desc.getString("reason_desc")==null ? "":rs_reason_desc.getString("reason_desc");
		activity_type_code=rs_reason_desc.getString("activity_type_code")==null ? "":rs_reason_desc.getString("activity_type_code");
		eff_status=rs_reason_desc.getString("eff_status")==null ? "":rs_reason_desc.getString("eff_status");
	}
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(rs_reason_desc!=null) rs_reason_desc.close();
	if(pstmt_reason_desc!=null) pstmt_reason_desc.close();
	ConnectionManager.returnConnection(conn,request);

}
%>
	<table cellpadding=0 cellspacing=0 border=0 width="70%" align=center>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Reason Code</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name='reason_code' id='reason_code' value='<%=reason_code%>' size='5' maxlength='4' readonly onKeyPress="return CheckForSpecChars(event)" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		</tr>
			<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Reason</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="reason_desc" id="reason_desc" value='<%=reason_desc%>' size='35' maxlength='30'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}else{%>
			<td  width="60%"  align=left class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="reason_desc" id="reason_desc" value='<%=reason_desc%>' size='35' maxlength='30' readonly>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<%}%>
		</tr>
		</tr>
			<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<!-- <td  width="20%"  align=right class="label">Applicable To</td> -->
			<td  width="20%"  align=right class="label"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<%if(eff_status.equalsIgnoreCase("E"))
				{%>
					<select name="activity_type_code" id="activity_type_code">
					<!-- <option value=''>&nbsp; --- Select --- &nbsp;</option> -->
					<option value=''>&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
				<%
				for(int i=0;i<Activity_list.size();i+=2){
					if(activity_type_code.equals(Activity_list.get(i)))
						selected="selected";
					else
						selected="";
				%>
			<option value='<%=Activity_list.get(i)%>' <%=selected%>><%= (String)Activity_list.get(i+1)%> </option>
				<%
				}
				%>
				</select>
				<%}
				else
				{%>
					
				<select name="activity_type_code" id="activity_type_code" disabled>
					<!-- <option value=''>&nbsp; --- Select --- &nbsp;</option> -->
					<option value=''>&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;</option>
				<%
				for(int i=0;i<Activity_list.size();i+=2){
					if(activity_type_code.equals(Activity_list.get(i)))
						selected="selected";
					else
						selected="";
				%>
			<option value='<%=Activity_list.get(i)%>' <%=selected%>><%= (String)Activity_list.get(i+1)%> </option>
				<%
				}
				%>
				</select>
				</td>
		<%}%>
		<input type='hidden' name='activity_type_code1' id='activity_type_code1' value=<%=activity_type_code%>>
		</tr>
		</tr>
		<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			
			<td  width="20%"  align='right' class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<%if(eff_status.equals("E"))
			{%>
			<td  width="60%"  align='left' >&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick="onenable(this);"></td>
			<%}else{%>
			<td  width="60%"  align='left' class="label">&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" onclick="onenable(this);"></td>
			<%}%>
		</tr>
		<tr>
		<td colspan="5">&nbsp;</td>
		</tr>
	</table>
		<%}%>				
<input type='hidden' name='operation_type' id='operation_type' value='<%=operation_type%>'>	
</form>
</body>
</html>	

