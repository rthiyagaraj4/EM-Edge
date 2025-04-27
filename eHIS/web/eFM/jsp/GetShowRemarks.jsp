<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String RemarksValue = request.getParameter("RemarksValue");
	String func= request.getParameter("func");

	if(func == null || func.equals("null"))
	func="";
	if(RemarksValue == null || RemarksValue.equals("null"))
		RemarksValue = "";
  //  RemarksValue=java.net.URLDecoder.decode(RemarksValue);
	String RemarksType	= request.getParameter("RemarksType");
	//String p_disb_col	="";

	
/*	if (RemarksType.equals("R"))
	{
		p_disb_col	=	"readonly";
	  
	}
	else if (RemarksType.equals("IR") && !func.equals("issuefile"))
	{
		p_disb_col="readonly";
	
	} */

%>
<script>
function doInit()
{
	
	
	var val 	= window.dialogArguments;
	val 		= ""+val+"";

	var index 	= -1;
	if ((val != '')||("undefined" != val)||(val != null)||(val != "null"))
		index = val.indexOf("^^^");
	if (index != -1)
	{
		document.forms[0].comments.value = val.substring(0,index);
	
		index += "^^^".length;
		var bool = val.substring(index,val.length);
		
		if (bool.toUpperCase() == 'TRUE')
		{
			document.forms[0].comments.readonly = true;
		}
		//document.getElementById("comments").focus();
	}else{

		if ("undefined" == val || "null" == val)
			document.forms[0].comments.value = '';
		else 
			document.forms[0].comments.value = val;
			// comment for 22777 document.getElementById("Ok").focus();
		//document.getElementById("comments").focus();
		}
	
  
 
   }

function checklength(){
	if (document.forms[0].comments.value.length > 100) {
		//alert("APP-SM0045 - Remarks cannot exceed 100 characters");
		var rmarks=getMessage("REMARKS_MUST_BE_GREATER","common");
		rmarks=rmarks.replace('$',getLabel("Common.remarks.label","common"));
		rmarks=rmarks.replace('#',100);
		alert(rmarks);
		document.forms[0].comments.value = "";
		document.forms[0].comments.focus();
	}
}

function doClose(RemarksType)
{
	if (RemarksType=='I')
	{
		if (document.forms[0].comments.value.length > 100) {
			//alert("APP-SM0045 - Remarks cannot exceed 100 characters");
			var rmarks=getMessage("REMARKS_MUST_BE_GREATER","common");
			rmarks=rmarks.replace('$',getLabel("Common.remarks.label","common"));
			rmarks=rmarks.replace('#',100);
			alert(rmarks);
			document.forms[0].comments.value = "";
			document.forms[0].comments.focus();
		}
		else {
			window.returnValue = encodeURIComponent(document.forms[0].comments.value);
			window.close();
		}
	}
	else
	{
		parent.document.getElementById('dialog-body').contentWindow.returnValue = encodeURIComponent(document.forms[0].comments.value);
		parent.document.getElementById("dialog_tag").close(); 
	}
}

function checkMaxLimit(obj,maxSize,keycode)
{
	//alert(keycode)
	// code added for icn:19422 date:Wednesday, February 24, 2010 

		if (keycode == 96 || keycode == 126 ||  keycode == 39 ||
				keycode == 34 || obj.value.length >= maxSize) return false;
			else return true;
}

function checkMaxLimit1(obj,keycode)
{
	document.getElementById("Ok").focus();
//	document.getElementById("comments").disabled = true;
			return false;
	}

function closeWin()
{
	if(document.forms[0].comments.value.length > 0)
		window.returnValue = document.forms[0].comments.value;
	else
		window.returnValue ='';
		window.close();
}
</script>
<% //Below line modified for this CRF HSA-CRF-0306
	if (RemarksType.equals("R"))
	{
%>
    <title><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></title>
<%
	}else if(RemarksType.equals("CR")){%>
	<title><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></title>
<%  }else if (RemarksType.equals("IR") || RemarksType.equals("IRS")){
%>
    <title><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></title>
<%
	}else 
	if(RemarksType.equals("TR")){%>
<title><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	
	<%}else if(RemarksType.equals("RCR")){%>
<title><fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	
	<%}else if(RemarksType.equals("RTR")){%>
<title><fmt:message key="eFM.ReturnRemarks.label" bundle="${fm_labels}"/></title>
	
	<%}else if(RemarksType.equals("MOT")){%>
<title><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></title>
	<!-- Below lines added by Venkatesh.s against ML-MMOH-CRF-0393 -->
	<%}else if(RemarksType.equals("RQ")){%>
	<title><fmt:message key="Common.remarks.label" bundle="${fm_labels}"/></title> 
	<!--end ML-MMOH-CRF-0393 -->
	<%}else
	{%>
<title><fmt:message key="eFM.ReturnRemarks.label" bundle="${fm_labels}"/></title>
<%}%>

</head>
<body onload='doInit()' onKeyDown = 'lockKey()' onUnload ='closeWin()' style='background-color:#E2E3F0;'>
<form name="ShowRemarks" id="ShowRemarks">
<script>

</script>
<table width='100%' border='0' cellspacing='0' cellpadding='2' align=center>
	<tr>
		<td  class='label' width='10%'></td>
	</tr>
	<tr> <!--Below line modified for this CRF HSA-CRF-0306 -->
		<td  width='90%' class='label'>&nbsp;&nbsp; <%if(RemarksType.equals("R") || RemarksType.equals("RR") || RemarksType.equals("CR") || RemarksType.equals("TR") || RemarksType.equals("RCR") || RemarksType.equals("RTR") || RemarksType.equals("IRS") || RemarksType.equals("MOT")){%>
		<textarea name="comments" rows="5" cols="60" onkeypress="return checkMaxLimit(this,100, event.keyCode);" onBlur="makeValidString(this);checklength()" readonly <%=RemarksValue%>></textarea><%}
		else if (RemarksType.equals("IR") && !func.equals("issuefile")){%>
		<textarea name="comments" rows="5" cols="60"  readonly    onfocus="return checkMaxLimit1(this, event.keyCode)"  onkeypress="return checkMaxLimit(this,100, event.keyCode)"   onBlur="makeValidString(this);checklength()"  <%=RemarksValue%>  ></textarea><%} 
		else if(RemarksType.equals("RQ")){ System.err.println("right block==>ss"+RemarksValue);%>
		 <textarea name="comments" rows="5" cols="60" onkeypress="return checkMaxLimit(this,100, event.keyCode);" onBlur="makeValidString(this);checklength()" readonly  <%=RemarksValue%>></textarea> 
		<%}else{%>
		<!-- Below lines added by Venkatesh.s against ML-MMOH-CRF-0393 -->
		<textarea name="comments" rows="5" cols="60"   onkeypress="return checkMaxLimit(this,100, event.keyCode)"   onBlur="makeValidString(this);checklength()" ></textarea>
		<!--end ML-MMOH-CRF-0393 -->
		<%}%>
		</td>
	</tr>
<tr>
	<td class='LABELCENTER'><input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose("<%=RemarksType%>")'></td>
	</tr>
	</table>
	</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

