<!DOCTYPE html>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* " %>

<%
//	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			//alert(obj.name)
			if(obj.name=="durationtype")
			{
				tit="Duration Type"
				sql="select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE";
				search_code="DURN_TYPE";
				search_desc= "DURN_DESC";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
<script>
async function GeneralPractitionerSearch(obj,target)
{
			var retVal = 	new String();
			var dialogHeight= "30" ;
			var dialogWidth	= "50" ;
			var status = "no";
			var arguments	= "" ;
	
			//var sql="";
			//var search_code="";
			//var search_desc="";
			var tit="";
			
	//alert(obj.name)
	if(obj.name=="demo_button")
	{
		tit="General Practitioner Search "
//	sql="select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE";
//		search_code="DURN_TYPE";
//		search_desc= "DURN_DESC";
	}
			

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}
</script>
</HEAD>
<BODY onLoad="Focusing('demo_call_text')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repDurationTypeForm" id="repDurationTypeForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

<tr>
		<td width="100%" class="Border" align='center'>
		<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
		<tr>
			<td>&nbsp;</td>
			<Td>&nbsp;</td>
		</tr>
		<tr>
			<td align='right' width='30%' class="label"><fmt:message key="eAM.DemoCall.label" bundle="${am_labels}"/>&nbsp;</td>
			<td width='20%'  ><input type=text  name='demo_call_text' id='demo_call_text' size="16" maxlength="16" align="center"><input type='button' name='demo_button' id='demo_button' value='?' class='button' onclick='GeneralPractitionerSearch(this, demo_call_text)'>
			</td>
	   </tr>
		<tr>
			<td>&nbsp;</td>
			<Td>&nbsp;</td>
		</tr>
	
</table>
</form>
</BODY>
</HTML>

