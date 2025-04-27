<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemption Details</title> 
</head>
<script language='javascript' src='../js/BillReceipt.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body>
<%

String user=request.getParameter("user");
String locale=request.getParameter("locale");
String exempt_amt=request.getParameter("exempt_amt");
String facility_id=request.getParameter("facility_id");
%>


<form name='ExemptForm' id='ExemptForm'>
<table border='0' cellpadding='3' cellspacing='2'  width='100%' scrolling='no'>
<tr>
<td width="15%"class="label" ><fmt:message key="eBL.Exempt Type.label" bundle="${bl_labels}"/></td>
<td width='30%' class='fields'>
<input type='text'  name="code" id="code" id='code' SIZE='13'  MAXLENGTH='13'	VALUE= '' onBlur="if(this.value != '' ){idCheck(code,desc,1);}">		
<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/></class>
<input type='text' name='desc' id='desc' id='desc' size='15' maxlength='15' value='' onBlur="codeCheck(code);" readonly><input type='button' class='button' name="code_but" id="code_but"   value='?' tabindex='0' onClick='idCheck(code,desc,1);'></td>


</tr>
<script>
function retModal(obj)
{
var assign_to=document.forms[0].assign_to.value;
var code=document.forms[0].code.value;


if(code==""){
	document.getElementById("code").focus();
	alert(getMessage('BL00948','BL'));
	return false;
	}

var retValue= new Array (assign_to,code);
window.returnValue=retValue;
	window.close();
	return;
}
function codeCheck(code){
	
	if(code.value==""){
		document.getElementById("code").focus();
		alert(getMessage('BL00948','BL'));
		return false;
		}
}

function idCheck(code,desc,codeDesc){
	var user='<%=user%>';
	var locale='<%=locale%>';
	var exempt_amt='<%=exempt_amt%>';
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title="Exemption Details";
	var query='';
	query = "select code,description  from (SELECT distinct a.action_reason_code code,a.action_reason_desc description FROM   bl_action_reason_lang_vw a, bl_action_reason_by_type b,BL_USERS_FOR_EXEMPTION c WHERE  a.action_reason_code  = b.action_reason_code and a.action_reason_code  = c.action_reason_code and c.appl_user_id = '"+user+"' AND    NVL(b.active_yn, 'N') = 'Y' AND    NVL(a.status, 'X')   <> 'S' AND    b.action_type = 'BE' and    a.language_id= '"+locale+"' )where upper(code) like upper(?)  and upper(description) like upper(?) ORDER BY 1";
	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	
	if(codeDesc == '1'){
		
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		
		argumentArray[4] = "2,1";
		argumentArray[5] = desc.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	} 
	var retVal =CommonLookup(title, argumentArray);
	if(retVal != null && retVal != "")
	{   	
		var code=retVal[0];	
	    var desc=retVal[1];	
	    document.getElementById("desc").value =desc;
		document.getElementById("code").value =code;
		
	}
	else{
		document.getElementById("desc").value ="";
		document.getElementById("code").value ="";
	}
	
	if(code!=""){
		
		$.ajax({			
			type:"POST",
			url:"../jsp/BillHdrAjax.jsp?calledFrom=assignTo",
			data:"&code="+code+"&exempt_amt="+exempt_amt,	
			dataType:"text",
			success: function(data){
				
				var dataArr = data.split(":::");
				 $('#assign_to').empty();
			
				
				for(var i =0 ; i< dataArr.length-1 ; i++) {
					
					var dataArr1 = dataArr[i].split("::");
					
					$("#assign_to").append('<option value='+dataArr1[0]+'>'+dataArr1[1]+'</option>');
				}
				
		},
		error: function(data){
			alert("Error"+data);
	     }
	});
		
		
	 }
	
	}
	

 </script>

<tr>
<td width="10%"class="label" ><fmt:message key="eBL.Assign To.label" bundle="${bl_labels}"/></td>
	<td width='20%' class='fields'><select id='assign_to' name='assign_to' id='assign_to'  style="width: 210px;" >	

</td>
</tr>
<td></td>
<tr></tr>
<td>


<input class='button' type="button" name='ok' id='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'  onclick='retModal(this);' >
</td>
</tr>

 
</table>

</form>


</body>
</html>

