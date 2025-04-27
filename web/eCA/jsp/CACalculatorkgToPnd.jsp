<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function round(number,X){
				X = (!X ? 2 : X);
				return Math.round(number*Math.pow(10,X))/Math.pow(10,X);
			}
	function Calculate()
	{
		var kilog = document.forms[0].kilo.value;
 		if (isNaN(kilog)) {
			alert(getMessage('INVALID_MAX_NUMBER','Common'));
		}

		else if ((kilog=='')) {
			//alert("Pls enter the values");
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}
		else if(kilog < 1)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel("eCA.Kilogram.label","CA") );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].kilo.select();
			}
		else {
				//Pounds = Kgs x 2.2
				var pnd = (parseInt(kilog))*2.2;
				document.forms[0].pound.value =round(pnd,2);
			}
	}
</script>

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='CerebralPP'>
<table width ='95%' height='40%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
		<tr><td class='COLUMNHEADER'>&nbsp;<fmt:message key="eCA.KilogramtoPounds.label" bundle="${ca_labels}"/></td><td  colspan=2  class='COLUMNHEADER'></td>
		<tr>
		<td class="label" colspan ='2' align ='right' width=50%><fmt:message key="eCA.Kilogram.label" bundle="${ca_labels}"/>&nbsp;</td>
		<td><input type='text' name ='kilo' size ='5' class="DATA" style="text-align: Right" maxLength ='5'> </td>
		</tr>
		<tr>
		<td align=center colspan=3><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:Calculate()' class="BUTTON" ></td>
		</tr>

		<tr>
		<td colspan ='2'class="data" align=right><fmt:message key="eCA.Pounds.label" bundle="${ca_labels}"/>&nbsp;</td><td><input type='text' name='pound' id='pound' size='5' class="DATA" style="text-align: Left"></td>
		</tr>

</table>

</form>
</BODY>
</HTML>

