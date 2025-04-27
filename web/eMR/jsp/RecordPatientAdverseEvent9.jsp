<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF- 0008 - IN:001472 %>
<head>
  <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
<!--   <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script> 
 <script language="javascript" src="../../eMP/js/PatEncBanner.js"></script>
</head>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <form name = 'submit_form'>
   <table cellpadding='0' border='0' cellspacing='0' width='100%' align='center'>
	 <!-- <tr><td class='white' width='88%'>&nbsp;&nbsp;
	  </td><td class='white' width='12%'>&nbsp;&nbsp;
	  </td></tr>	 
	  <tr> -->	 
	  <td class='white' width='88%'><input class=button type='button' name='markerror' id='markerror' value='<fmt:message key="Common.MarkError.label" bundle="${common_labels}"/>' onclick='mark_error();' style='visibility:hidden'> 
	  </td>
	  
	  <td class='white' width='6%' align='right'>
	  <input class=button type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick='record_values();'></td><td class='white' width='6%' align='left'><input class=button type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clear_page();" <%if(!"".equals(p_called_from_widget)){%>disabled<%}%>></td> <!-- CHL-CRF- 0008 - IN:001472 -->
	  </tr>
	</table>
 </form>
</body>

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
<!--
<script>
function mark_error()
{
	if(parent.frames[4].document.forms[0].tot_cnt)
	{
		var countvalue=parent.frames[4].document.forms[0].tot_cnt.value;
		//alert(countvalue);
		for (var i=0;i<=countvalue-1 ;i++ )
		{
			if(eval("parent.frames[4].document.forms[0].chkreact1"+i+".checked"))
			{
				alert('2')
			}
		}
	}
} 
</script>-->

