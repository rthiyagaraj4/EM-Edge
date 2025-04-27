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
<title>Additional Id Proof</title> 
</head>
<script language='javascript' src='../js/BillReceipt.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onload="idCheck();">
<%

String dflt_addl_id_type=request.getParameter("dflt_addl_id_type");
String addl_id_mand_for_payer_bill_yn=request.getParameter("addl_id_mand_for_payer_bill_yn");


%>

<center>
<form name='IdProofForm' id='IdProofForm'>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%' scrolling='no'>
<tr>
<td width="33%"class="label" ><fmt:message key="eBL.Alternative id.label" bundle="${bl_labels}"/></td>

<td width='40%' class='fields'>
<input type='text'  name="code" id="code" id='code' SIZE='8'  MAXLENGTH='4'	VALUE= '' onBlur="if(this.value != '' ){additionalId(desc,code,1);} else{ clearCode(desc);}">		
<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>
<input type='text' name='desc' id='desc' id='desc' size='18' maxlength='20' value='' onBlur="if(this.value != ''){additionalId(desc,code,2);} else {clearCode(code);}"><input type='button' class='button' name="code_but" id="code_but"   value='?' tabindex='0' onClick= "additionalId(desc,code,1);" onBlur=""></td>
<%
if("Y".equals(addl_id_mand_for_payer_bill_yn)){
	%>
<td width="2%"class="label" ><fmt:message key="eBL.Id.label" bundle="${bl_labels}"/></td>
<td width="25%" class="fields"><input type='text' name='id' id='id' id='id' size='15' maxlength='30' onBlur=""><img src='../../eCommon/images/mandatory.gif'></td>
<%}
else{%>
	<td width="5%"class="label" ><fmt:message key="eBL.Id.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='id' id='id' id='id' size='15' maxlength='30' onBlur=""></td>	
<%}%>
</tr>
<tr>

<td width="33%"class="label" ><fmt:message key="eBL.Patient Name.label" bundle="${bl_labels}"/></td>
<td colspan='3' class="fields"><input type='text' name='name' id='name' size='64' maxlength='100' ></td>

</tr>
<tr>
<td width="33%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<td colspan='3' class="fields"><textarea name='remarks' rows="2" cols="54" onKeyPress='checkMaxLimit(this,200)' scrolling='yes'></textarea></td>
</tr>
<tr>

<td>
<input class='button' type="button" name='continue' id='continue' id='continue' value='Continue' onclick='retModal(this);' >
</td>
</tr>
<script>
function idCheck(){
var dflt_addl_id_type='<%=dflt_addl_id_type%>';
if(dflt_addl_id_type== null || dflt_addl_id_type=="null"){
	dflt_addl_id_type="";
	
}

var dflt_addl_id_desc='';

if(dflt_addl_id_type !="" && dflt_addl_id_type != "null"){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var title="Additional Id Proof";
	
	var query='';
	
		
	query = "select description, code from (select  a.short_desc description,NVL (b.dflt_addl_id_type,'***')code FROM bl_parameters b,mp_alternate_id_type_lang_vw a WHERE operating_facility_id = 'QF' and a.alt_id_type=b.dflt_addl_id_type and a.language_id='en' UNION SELECT decode(ACCEPT_NATIONAL_ID_NO_YN,'Y',NAT_ID_PROMPT,'') description,'****' code FROM MP_PARAM )where upper(description) like upper(?) and upper(code) like upper(?)  ORDER BY 1";
	
	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   =dflt_addl_id_type;
	argumentArray[6]   = "1" ;
	argumentArray[7]   = "DESC_CODE" ;
	
	
	var retVal =CommonLookup(title, argumentArray);
	if(retVal != null && retVal != ""){   	
		dflt_addl_id_desc=retVal[1];	
	
		
	}


	document.getElementById("desc").value =dflt_addl_id_desc;
	document.getElementById("code").value =dflt_addl_id_type;
	
	
	}
}


function retModal(obj)
{
	var remarks=document.forms[0].remarks.value;
	var name=document.forms[0].name.value;
	var id=document.forms[0].id.value;
	var code=document.forms[0].code.value;

	var addl_id_mand_for_payer_bill_yn="<%=addl_id_mand_for_payer_bill_yn%>";
	if(addl_id_mand_for_payer_bill_yn=="Y"){
		if(id == null||id==""){
			document.getElementById("id").focus();
			alert(getMessage('BL00947','BL'));
			return false;
		}
	}
	if(code==""){
		document.getElementById("code").focus();
		alert(getMessage('BL00948','BL'));
		return false;
	}

	var retValue= new Array (name,id,code,remarks);
	window.returnValue=retValue;
	window.close(); 
	//return;

	/* var dialogTag = parent.document.getElementById("dialog_tag");    
	dialogTag.close();  */
}

function defCheck(){

var id=document.forms[0].id.value;
var addl_id_mand_for_payer_bill_yn="<%=addl_id_mand_for_payer_bill_yn%>";

if(addl_id_mand_for_payer_bill_yn=="Y"){

if(id == null||id==""){

document.getElementById("id").focus();
alert(getMessage('BL00947','BL'));
return false;
}
}

}
 </script>
 
</table>

</form>
</center>

</body>
</html>

