<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript">
	var rows = new Array();
	 
</script>
<script language="javascript">
function createXMLForOT_PACKAGE_Dtl(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var masterFrame=window.parent.parent.frames[1].frames[0];
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
  var table_name = "OT_PACKAGE_DTL";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		 if(rows[i].mode=="")
			 break;
		 else if(rows[i].mode=="I"){
			xmlString+="<PACKAGE_DTL"+i+" ";
			xmlString+="package_code=\""+formObj.package_code.value+"\""+" ";
			xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
			xmlString+="reqd_qty=\""+rows[i].reqd_qty+"\""+" ";
			xmlString+="mode=\""+rows[i].mode+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";
		 }else if(rows[i].mode=="U"){
			xmlString+="<PACKAGE_DTL"+i+" ";
			xmlString+="package_code=\""+formObj.package_code.value+"\""+" ";
			xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
			xmlString+="reqd_qty=\""+rows[i].reqd_qty+"\""+" ";
			xmlString+="mode=\""+rows[i].mode+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";
		}
		else
		  {
			xmlString+="<PACKAGE_DTL"+i+" ";
			xmlString+="package_code=\""+formObj.package_code.value+"\""+" ";
			xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
			xmlString+="reqd_qty=\""+rows[i].reqd_qty+"\""+" ";
			xmlString+="mode=\""+rows[i].mode+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";
		}
	 }
  }
 return xmlString;
}

function createXMLForOT_PACKAGE_Hdr(){
	var rows=window.parent.parent.frames[1].frames[1].rows;
	var formObj =window.parent.parent.frames[1].frames[0];
    var frmObj=formObj.document.forms[0];
	var mode = frmObj.mode.value;
	var len = rows.length;
    var table_name = "OT_PACKAGE_HDR";
	var xmlString ="";
	  if(frmObj.package_code!=null){
		xmlString+="<PACKAGE_HDR "+" ";
		xmlString+="package_code=\""+frmObj.package_code.value+"\""+" ";
		xmlString+="long_description=\""+frmObj.long_description.value +"\""+" ";
		xmlString+="short_description=\""+frmObj.short_description.value +"\""+" ";
		xmlString+="status=\""+frmObj.status.value +"\""+" ";
		//CRF-268 Consumable pack - Rajesh V
		xmlString+="ss_code=\""+frmObj.ss_group_code.value +"\""+" ";
		//CRF-268 Consumable pack - Rajesh V
		xmlString+="mode=\""+mode.toUpperCase()+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
 
 return xmlString;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

