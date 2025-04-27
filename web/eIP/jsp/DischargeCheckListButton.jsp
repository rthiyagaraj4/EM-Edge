<!DOCTYPE html>
<%@ page import ="java.sql.*,com.ehis.util.*,com.ehis.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
String disable_print= request.getParameter("disable_print")==null?"":request.getParameter("disable_print");
String locale			= (String)session.getAttribute("LOCALE");
String login_user = (String)session.getValue("login_user");

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<Script src="../../eIP/js/DischargeCheckList.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>

	function callSubmit()
	{
		 //Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049 
		var from =  parent.frames[1].document.forms[0].cert_from_date;
		var to =  parent.frames[1].document.forms[0].cert_to_date;
		
		//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
		var cert_num =  parent.frames[1].document.forms[0].cert_num;
		var isautopopdurationapplyn = parent.frames[1].document.forms[0].isAutoPopDurationApplyn.value;	
	
		parent.DischargeCheckList_frame1.setData_main();
		if(document.forms[0].infomPass.value == "N")
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common'); 
			error     = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			alert(error); 
		}
	     else if ((from.value == '' || to.value == '') && isautopopdurationapplyn == 'true')
		 {
			 //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
			 if (!cert_num.value == '')
			 {
			 var error = getMessage('CAN_NOT_BE_BLANK','Common').replace('$',getLabel("Common.fromdate.label","Common"));
			 var error1 = getMessage('CAN_NOT_BE_BLANK','Common').replace('$',getLabel("Common.todate.label","Common"));
			 var finalError = "";
			 
			 if(from.value == '' && to.value == '')
			 {
				 finalError = error+"\n"+error1;
			 }
			 else if(from.value == '')
			 {
				 finalError = error;
			 }
			 else
			 {
				 finalError = error1;
			 }
			 alert(finalError);
			 }else
			 {
				 parent.DischargeCheckList_frame1.document.forms[0].submit();
			 }
		 }
		else
		{
			parent.DischargeCheckList_frame1.document.forms[0].submit();
		}
	}

setInterval("datefun()",500);
	function datefun()
	{
		var dttm = getCurrentDate('DMYHM' ,'<%=locale%>');	
		document.forms[0].date_time_txt.value=dttm;
	
	}
	function close_window(){
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}


</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='DischargeCheckListButton' id='DischargeCheckListButton' method="post" target="messageFrame">
			<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
			<tr>
				<td class='label' id='user_label' width='25%'>&nbsp;<fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>&nbsp;<input type='text' name='user_txt' id='user_txt' size='15' maxlength='30' value="<%=login_user%>" disabled></td>
				<td class='label' id='date_time_label' width='25%'>&nbsp;<fmt:message key="Common.on.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='date_time_txt' id='date_time_txt' id='datetimetxt' size='16' maxlength='16' value="" disabled></td>
			</tr>
			<tr>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >
		<%
			if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
			{	%>
				<input class='button' type='button' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick='callSubmit();'>
		<%	}
			else
			{	
				 if(!disable_print.equals("Disabled"))
				 {		
			%>
				<input class='button' type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onclick='callPrint();'>
			<%		}
				}
			%>
				<input class='button' type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='close_window();'>&nbsp;&nbsp;</td>
			</tr>
		<input type=hidden name="infomPass" id="infomPass" value="Y" >
		</table>
	</form>
	<script>

		if(document.forms[0].date_time_txt)
		{
			if(parent.DischargeCheckList_frame1.document.forms[0])
			{
				if(parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt)
				{
					if(parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt.value!='')
					{
						document.forms[0].date_time_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt.value;
					}
				}
			}
		}
		if(document.forms[0].user_txt)
		{
			if(parent.DischargeCheckList_frame1.document.forms[0])
			{
				if(parent.DischargeCheckList_frame1.document.forms[0].h_user_txt)
				{
					if(parent.DischargeCheckList_frame1.document.forms[0].h_user_txt.value!='')
					{
						document.forms[0].user_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_user_txt.value;
					}
				}
			}
		}
	</script>
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

