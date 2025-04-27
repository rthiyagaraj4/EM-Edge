<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'> </script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active{ 
			COLOR: white; 
		}
	</style>
	
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=1;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
	
			if(val == 'EmailRepControlSetup'){
				parent.frames[1].location.href = '../../eCA/jsp/EmailRepControlSetupMain.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.EmailReportControlSetup.label","CA"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'EmailReportBodyText'){
				parent.frames[1].location.href = '../../eCA/jsp/EmailRepBodyTxtMain.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.EmailReportBodyText.label","CA"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'RegisteredEmailRecipient'){
				parent.frames[1].location.href = '../../eCA/jsp/RegEmailRecipient.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.RegisteredEmailRecipient.label","CA"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'UserPrivToVerifyEmail'){
				parent.frames[1].location.href = '../../eCA/jsp/UserPrvlgToVeryEmailMain.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.UserPrivToVerifyEmail.label","CA"))+'&function_type=F&access=NYNNN';
			}
			if(val == 'EMail'){
				parent.frames[1].location.href = '../../eCA/jsp/EMailTemp.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("eCA.Email.label","CA"))+'&function_type=F&access=YYYNN';
			}
		  
	}
	
	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals
		
		retVal	=await  window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.EmailingSetup.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EmailReportBodyText')"><fmt:message key="eCA.EmailReportBodyText.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EmailRepControlSetup')">
			<fmt:message key="eCA.EmailReportControlSetup.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RegisteredEmailRecipient')"><fmt:message key="eCA.RegisteredEmailRecipient.label" bundle="${ca_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UserPrivToVerifyEmail')"><fmt:message key="eCA.UserPrivToVerifyEmail.label" bundle="${ca_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EMail')"><fmt:message key="eCA.EMail.label" bundle="${ca_labels}"/></td>
		</tr> -->
				
		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
	</table>

	</body>
	</form>
</html>

