<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,org.json.simple.*"%>

<html>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 		<script language="JavaScript" src="../js/addModifyReferralPriority.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%	
	Connection con		= null;
	String locale		= (String)session.getAttribute("LOCALE");

	try
	{
		con	= ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		String priority_Code="", priority_Desc="";	
		JSONObject RefPriorityJson = new JSONObject();
		JSONArray refPriorityjsonArr = new JSONArray();
		RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con);
%>
</head>
<body onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();" >
<div align='center'>
	<form name='referral_priority' id='referral_priority' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table border='0' cellpadding='0' cellspacing='0' width='40%'>
			<tr><td colspan='4'>&nbsp;</td></tr>

		<tr>
    	     <td width='40%' align='center' class="querydata" nowrap><fmt:message key="eAM.RefPriorityCode.label" bundle="${am_labels}"/></td>
    		 <td width='40%' align='center' class="querydata" nowrap><fmt:message key="eAM.RefPriorityDesc.label" bundle="${am_labels}"/></td>
					
		<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	    </tr>

         <%
			  refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
			  for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
			  {

				JSONObject priorityListObj	= (JSONObject)refPriorityjsonArr.get(i);
				priority_Code		= checkForNull((String) priorityListObj.get("priority_Code"));
				priority_Desc		= checkForNull((String) priorityListObj.get("priority_Desc"));
           
		 %>

             <td width='40%' align='center' class="querydata" nowrap><%=priority_Code%></b></td>
             <input type=hidden name="priority_Code<%=i%>" id="priority_Code<%=i%>" value="<%=priority_Code%>">
						
			 <td width='40%' align='center' class="querydata" nowrap>
			 <input type='text' name='priority_Desc<%=i%>' id='priority_Desc<%=i%>' value='<%=priority_Desc%>' size='20' maxlength='15' onBlur="return CheckSplCharsValidation(this);" onkeypress="return CheckForSpecCharsValidation1(event);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>

        </tr>
		<%}%>
        </table>
	
	    <input type='hidden' name='refpriority_arr_size' id='refpriority_arr_size' value="<%=refPriorityjsonArr.size()%>">

</form></div>

</body>
<%
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>
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

