<!DOCTYPE html>
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
try
{
%>
<html>
<head>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale			= (String)session.getAttribute("LOCALE");
	String auth ="N";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/FieldFormatMethods.js'></Script>
	<script language="JavaScript" src="../../eBL/js/BillingInterimBillScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function funReasonId(clng_evnt)
	{	
		if(clng_evnt == 'B')
		{
			if( document.forms[0].Reason_code.value == '')
			{	
				//document.forms[0].cashcounter_code.value = '';
				//document.getElementById("cashcounter_desc").innerText= '';
				document.forms[0].Reason_code.value = '';
				return;
			}
		}
		if(clng_evnt == 'C')
		{			
		if( document.forms[0].Reason_code.value == '' )
			{	
		
				document.forms[0].Reason_code.value = '';
				//document.getElementById("cashcounter_desc").innerText= '';
				//document.forms[0].cashcounter_desc.value = '';
				
			}
	}
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;


		var title=getLabel("eBL.Reason.Label","BL");  //CHANGED ON V200113
		title=encodeURIComponent(title);
		var column_sizes = escape("70%,30%");               
		var cashcntrcode=getLabel("eBL.ReasonCode.Label","BL"); //CHANGED ON V200113
		cashcntrcode=encodeURIComponent(cashcntrcode);
		var desc=getLabel("Common.description.label","common");
		desc=encodeURIComponent(desc);
		var column_descriptions = desc+","+cashcntrcode; //CHANGED ON V200113
		var locale=document.forms[0].locale.value;

		var sql = escape("SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = 'IA' AND active_yn = 'Y' AND language_id='"+locale+"'");
	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+"&srch_by_clmn_index=2"+"&col_show_hide=YY"+"&called_for="+"CASH_COUNTER_LOGINTIME";
	
		retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
		var arr=new Array();

		if(retVal == null) retVal='';
		if (retVal != null || retVal!='')
		{
			var retVal=unescape(retVal);
			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("^~^");
				//Modified V201201-PalaniNarayanan/MOHE-CRF-50.2 US-O6
				//document.forms[0].Reason_desc.value = arr[0];
				document.forms[0].Reason_code.value = arr[1];
				
				//document.getElementById("cashcounter_desc").innerText= arr[1];
				//document.forms[0].login_time.value = '';q
				//document.forms[0].logout_time.value = '';
			}
			else
			{
				//document.forms[0].cashcounter_code.value = '';
				//document.getElementById("cashcounter_desc").innerText= '';
				document.forms[0].Reason_code.value = '';
			}
		}
	}	
	/*function authOnROff
	{
		document.getElementById("auth").value="Y";
	}*/
	</script>
	<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title> 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
	<form name='AuthForm' id='AuthForm'>
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return changeToUpper()'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	 <tr>
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='21' maxlength='64' autocomplete="off"><!--V230508-41626 --><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<!--
	<tr>
	<td width="50%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><textarea name='remarks' rows="2" cols="25" onKeyPress='checkMaxLimit(this,50)'></textarea><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	-->
		<tr>
				<td width="50%" class='label' ><fmt:message key="eBL.Reason.Label" bundle="${bl_labels}"/></td>
				<td width="50%" class='fields' >
					<!--
					<input type='text' name='cashcounter_code' id='cashcounter_code' size='15' maxlength='40' value='' onBlur="funCashCounter('B')">
					-->
					<input type='text' name='Reason_code' id='Reason_code' size='15' maxlength='40' value='' onBlur="funReasonId('B');" style="text-transform:uppercase"  >
					<!--
					<input type='text' name='Reason_desc' id='Reason_desc' size='10' maxlength='40' value=''onBlur="funReasonId('B')">	
					-->
					<!--
					removed manditory field on 17-01-21
					-->
					<input type='button' value='?' class='button' onClick="funReasonId('C')">
					
					<!--
					<b id='cashcounter_desc'></b>
					-->
				</td>
		</tr>
	<tr>
	<td width="50%"></td>
	<td width="50%">
	<!--
	below code chaged at end on 29/12/2020
	-->
	<input type='button' class='button' name='auth_ok' id='auth_ok' id='auth_ok' value="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>    " onClick ='return confirmPasswdchk(this);'><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>"  onClick='parent.window.close();'>
	</td>
	</tr>
	<tr>
	<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
	<td colspan=15>&nbsp;</td>
	</tr>
	<script>
	document.forms[0].user_id.focus();
	</script>
	</table>
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type= hidden name="auth" id="auth"  value='<%=auth%>'>
	</form>
	</center>
	</body>
	</html>
	<%
}
catch(Exception ee)
{
  System.err.println("Error in BillingRecordApprovalAuthorize.jsp: " +ee);
}
%>

