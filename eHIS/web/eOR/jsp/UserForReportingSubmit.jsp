<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- UserForReportingSubmit.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%!//int row_count=0;%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/UserForReportingOrderable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	/*function onSubmit(){
		var val =new Array();
		var catalog_code="";
	var formObj=parent.frameUserOrderable.document.formOrderableHeader.order_type_value.value;
	
	val[0]=parent.frameUserOrderable.document.formOrderableHeader.order_type_text.value;
	val[1]=parent.frameUserOrderable.document.formOrderableHeader.order_type_value.value;
		if(formObj=="" ||formObj=="*ALL"){
		val[1]=parent.frameUserOrderable.document.formOrderableHeader.order_type[parent.frameUserOrderable.document.formOrderableHeader.order_type.selectedIndex].value;
		}
	val[2]=parent.frameUserOrderable.document.formOrderableHeader.order_category_text.value;
	val[3]=parent.frameUserOrderable.document.formOrderableHeader.order_category.value;	
	var row_count=parent.frameUserOrderableResult.document.formUserForReportingResult.row_count.value;	
	var All= eval(parent.frameUserOrderableResult.document.formUserForReportingResult.all);
	if(All.checked==true){
		var all_value=parent.frameUserOrderableResult.document.formUserForReportingResult.all.value;
	}else
		all_value="";

	for(i=0;i<row_count;i++){
		var chk=eval('parent.frameUserOrderableResult.document.formUserForReportingResult.select_yn'+i);
		
			if(chk.checked==true){
			catalog_code+=","+eval('parent.frameUserOrderableResult.document.formUserForReportingResult.catalog_code'+i).value;
				
			}
		}
	if(all_value!=""){
			catalog_code+=","+all_value;
		}
	if(catalog_code.length>1){
	catalog_code = catalog_code.substring(1);
	}
	val[4]=catalog_code;
	latestUpdate();
			window.returnValue = val;
		window.close();
	}*/

</script>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="formUserForReportingSubmit" id="formUserForReportingSubmit">

<table border='0' cellpadding='3' cellspacing='0' width='100%' align=center>
<tr>
<td align='right' ><input type='button' name="Submit" id="Submit" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='onSubmit()' >
<input type='button' name="Close" id="Close" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='parent.parent.document.getElementById("dialog_tag").close()'>
</td>
	
</table>
</form>
</body>
</html>

