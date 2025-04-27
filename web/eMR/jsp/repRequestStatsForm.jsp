<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Request Received Statitics
/// Developer		:	SRIDHAR R
/// Created On		:	29 JULY 2004
/// Function 		:   Used to create report for Received Request's..
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.*"  contentType="text/html;charset=UTF-8" %><!--oracle.jdbc.driver.*,-->
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null;
	String resp_id=(String) session.getValue("responsibility_id");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String user_id = (String) session.getValue("login_user");
try
{
	
	Statement stmt = null;
	PreparedStatement pstmt = null ;
	ResultSet rset=null;
	ResultSet rs=null;
	con  =  ConnectionManager.getConnection(request);

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script src='../../eMR/js/repRequestStats.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

 <%
				    String sys_date	 ="";
					
					String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
					pstmt = con.prepareStatement(sql1);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						sys_date = rs.getString(1);
					}
					if (rs!=null) rs.close();
					if (pstmt!=null)pstmt.close();
					
					
	%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="repRequestStatsForm" id="repRequestStatsForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="3" cellspacing="0"  align='center'>
<tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr>
	  <td width='25%' class="label"><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/></td>
      <td width='25%' class='fields' colspan='3'><select name="P_REQUESTOR_TYPE" id="P_REQUESTOR_TYPE" onchange="document.forms[0].P_REQUESTOR_DESC.value='';document.getElementById('Requestor_desc_hid').value='';document.getElementById('P_REQUESTOR_CODE').value='';">
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
			<%
				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			%>
    </select></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='3' ><input type=text name="P_REQUESTOR_DESC" id="P_REQUESTOR_DESC" size=15 maxlength=15 onblur="beforeGetRequestor(document.forms[0].Requestor_desc_hid,this);"><input type=button class=button name='search_Requestor' id='search_Requestor' value='?' onclick="Lookup(document.forms[0].Requestor_desc_hid,document.forms[0].P_REQUESTOR_DESC)"></td>
		<input type=hidden name="Requestor_desc_hid" id="Requestor_desc_hid" value=''>
		<input type=hidden name="P_REQUESTOR_CODE" id="P_REQUESTOR_CODE" value=''>
	</tr>
	
	<tr>
		<td class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text'  name='P_FM_DATE' id='P_FM_DATE' size='10' onBlur='validDateObj(this,"DMY",localeName); _GRDate2(this);' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_FM_DATE');focus();"/></td>
		<td class="label" width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' id='reqStatTo' name='P_TO_DATE' id='P_TO_DATE' size='10' onBlur='validDateObj(this,"DMY",localeName);_GRDate2(this);chkGrtrDate(document.forms[0].P_FM_DATE,document.forms[0].P_TO_DATE)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('reqStatTo');P_TO_DATE.focus();"/></td>
	</tr>
	<tr><td colspan=4 class='label'>&nbsp;</td></tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRREQREC">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%=sys_date%>">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	

</form>
</body>
</html>
<%
	}catch(Exception e) 
	{  
		//out.println("Exception : "+e);
		e.printStackTrace();
	}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

