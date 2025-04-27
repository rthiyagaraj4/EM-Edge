<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
String oth_reac=request.getParameter("oth_reaction")==null?"":request.getParameter("oth_reaction");
if(oth_reac.equals("$")) oth_reac="";
//String oth_reaction="";
//String oth_reaction2="";
//StringBuffer oth_desc_final=new StringBuffer("");
//String oth_reac="";
%>
<head>
	  <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	  <script language="javascript" src="../../eCommon/js/common.js" ></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
	  <!-- <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
	  <script language='javascript' src='../../eCommon/js/common.js' ></script>
	  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
</head>
<%
try 
{
/*if(!react_val.equals(""))
	{
StringTokenizer token=new StringTokenizer(react_val,"*");
		while(token.hasMoreTokens())
		{
			oth_reaction=token.nextToken();
			oth_reaction2=token.nextToken();
			oth_desc_final.append(oth_reaction2);
		}

 //oth_reac=oth_desc_final.toString();
//if(oth_reac.equals("$")) oth_reac="";
	}*/

%>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	   <form name = 'submit_reac'>
			<table cellpadding='0' border='0' cellspacing='0' width='100%' align='right'>
				<tr>
				<td class='label' width='25%'><fmt:message key="eMR.OtherReactions.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='25%'><textarea name='other_reaction'  maxlength="100" rows='1' cols='28' value='' onkeyup="return checkMaxLength(this);" onkeypress="return CheckForSpecChars_spec(event);"></textarea></td>
					<td class='label' align='left' width='25%' colspan='2'>
					<input class=button type='button' name='Close' id='Close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='pass_results()'></td>
				</tr>
				<input type='hidden' name='old_other_reaction' id='old_other_reaction' value='<%=oth_reac%>'>
			</table>
<%

	if(!oth_reac.equals(""))
{ %>
<!--<script> document.forms[0].other_reaction.disabled=true; </script>-->
<%} %>
	   </form>
	</body>
</html>
<%}catch(Exception e)
{
						//out.println("exception hre :" +e);
						e.printStackTrace();
}%>
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

