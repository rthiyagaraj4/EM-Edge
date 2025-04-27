<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%> 
<html> 
<head>
<%
	 request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<style>
	textarea {
	  resize: none;
	}
</style>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function doClose()	
{   
	doSync(document.forms[0]);	
	//const dialogTag = parent.document.getElementById("dialog_tag"); 
	const diagElement = parent.document.getElementsByTagName('dialog');
	for (var i = 0; i < diagElement.length; i++) {
		for (var j = 0; j < diagElement[i].children.length; j++) {
			var element = diagElement[i].children[j];
			let dialogSrc = element.src;
			if (typeof dialogSrc !== 'undefined') {
				if (dialogSrc.includes('OrderCatlogInstructionsModalStandard.jsp')) {
				   diagElement[i].close(); 
				}
			}
		}
	}	
    //dialogTag.close(); 
	//window.close();
}

function checkMaxLimit(obj,maxSize)	
{
		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}

function closeWin()
{

}

function chkLength(Obj,len)
{
	if(Obj.value.length > parseInt(len))
	{
		alert('The number of characters cannot exceed '+len);
		Obj.focus();
	}

}

/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj){
	
	/* var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();	
	var xmlString = buildXml(frmObj);	
	xmlDoc.loadXML(xmlString);
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);  
	return xmlHttp.responseText  ;*/
	
	var xmlStr = buildXml(frmObj);
	
	var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
	
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eOR/jsp/OrderCatalogInstructionSync.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    
 	// Send the XML
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    // Handle the response
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText);  
	
	return responseText;
}
/****************this methos is called by the Sync jsp in retrun text******/
function syncStatus(flag)
{
//	alert(flag);	
	return flag ;
}
/***********************doSync****************************************/
function buildXml(frmObj){
	
   
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
	}

    xmlStr +=" /></root>";

	//alert(xmlStr);
	return xmlStr;

}


</script>



<title><fmt:message key="eOR.StandardInstruction.label" bundle="${or_labels}"/></title>

</head>


<body onload='' onUnload ='closeWin()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"
><!-- style='background-color:#E2E3F0;' -->
<form name='StdInstructions' id='StdInstructions'>

<%
try{
	
	/* Mandatory checks start */
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap recordStdIntruction =  bean.getInstructionStdByAge("IS") ;

	Object msgTxtObj = recordStdIntruction.get("pat_preps_or_instrns_txt_is");
	String msgTxt = "" ;

	if(msgTxtObj == null )
	msgTxt = "" ;
	else
	msgTxt = (String)msgTxtObj ;
//out.println(msgTxt);

%>

	<table width='100%' border='0' cellspacing='0' cellpadding='3'>


 
<tr>
	<td class="fields" width='100%' ><textarea name="pat_preps_or_instrns_txt_is" rows="10" cols="63" onkeypress="checkMaxLimit(this,1000);" onBlur="SPCheckMaxLen('Standard Instructions',this,1000);makeValidString(this);" ><%=msgTxt%></textarea></td>

</tr>
</table>
<table width='100%' border='0' cellspacing='0' cellpadding='3'>
<tr><td class="button" align="right"><input type='Button' class='Button' name='OK' id='OK' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'></td></tr>

<input type="hidden" name="instructionType" id="instructionType"  value="IS">
<input type="hidden" name="instrn_content_type" id="instrn_content_type"  value="T">
	
</table>
</form>

<%
		putObjectInBean(bean_id,bean,request); 
 
}catch(Exception e){
System.out.println(e.getMessage());
}%>

</body>
</html>

