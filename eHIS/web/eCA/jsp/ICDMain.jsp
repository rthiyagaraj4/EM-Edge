<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
async function show_window()
{
	var s = 
	'1';
	scheme_desc= 'ICD10'; 
	var Encounter_Id= '10060885';
	var  p_auth_yn="N";

	var age = '27';
	var sex = 'Male';
	var dob = '';
	var retVal =    new String();
		var dialogHeight= "27.22" ;
		var dialogWidth = "44" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		var cause_ind='';
		
		// cause_ind=document.forms[0].cause_ind.value
		
		//retVal = window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob+"&mode=DiagSearch",arguments,features);
		retVal =await  window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&mode=DiagSearch",arguments,features);
		alert(retVal)
		if (!(retVal == null))
		{
			var retdata;
			
			 retdata=retVal.split("/") ;
			retVal1=retdata[0];
			retVal2= retdata[1];
			
			document.forms[0].code.value=retVal1;
			document.forms[0].desc.value=retVal2;
		}
			
	}


</script>

<form name='ICD_form' id='ICD_form'>
<table border=0 cellpadding='3' cellspacing='0' width="90%">
<tr>
<td><fmt:message key="Common.ICD.label" bundle="${common_labels}"/> &nbsp; <input type='button' class='button' name='click' id='click' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Clickheretoview.label","ca_labels")%>' onClick='show_window()'>
</td></tr>

<tr><td><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;<input type=text name= 'code' value=''></td></tr>
<tr><td><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;<input type=text name= 'desc' value=''></td></tr>
</table>

</form>
</body>
</html>

