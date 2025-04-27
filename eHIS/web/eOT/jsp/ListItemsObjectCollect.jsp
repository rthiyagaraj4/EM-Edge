<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<html>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language="javascript">
	var rows = new Array();
	 
</script>
<script language="javascript">
function createXMLForListItemsDtl(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
 // alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  var DEF_FLAG = "OFF";
  
  var len = rows.length;
 // alert("Length of the rows array==="+len);
  var table_name = "OT_CHECKLIST_LISTVALS_DTL";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		  //alert("mode in OT_CHECKLIST_DTL func=="+rows[i].mode);
		 if(rows[i].mode=="")
			 break;
		 else if(rows[i].mode=="I"){
		xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="list_id=\""+formObj.list_id.value+"\""+" ";
		xmlString+="item_description=\""+rows[i].item_description +"\""+" ";
		xmlString+="item_value=\""+rows[i].item_value+"\""+" ";
		xmlString+="default_value_yn=\""+rows[i].default_value_yn+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		 }else if(rows[i].mode=="U"){
			xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="list_id=\""+formObj.list_id.value+"\""+" ";
		xmlString+="item_description=\""+rows[i].item_description +"\""+" ";
		xmlString+="item_value=\""+rows[i].item_value+"\""+" ";
		xmlString+="default_value_yn=\""+rows[i].default_value_yn+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString in OT_CHECKLIST_DTL func=="+xmlString);
		}
		else {
			//alert("inside delete xml of dtl");
			xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="list_id=\""+formObj.list_id.value+"\""+" ";
		xmlString+="item_description=\""+rows[i].item_description +"\""+" ";
		xmlString+="item_value=\""+rows[i].item_value+"\""+" ";
		xmlString+="default_value_yn=\""+rows[i].default_value_yn+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString in OT_CHECKLIST_DTL delete func=="+xmlString);
		}
	 }
  }
 return xmlString;
}

function createXMLForListItemsHdr(){
	
  var rows=window.parent.parent.frames[1].frames[1].rows;
  
  var formObj =window.parent.parent.frames[1].frames[0];
  
  var frmObj=formObj.document.forms[0];
  var mode = frmObj.mode.value;
  
  var len = rows.length;
  
  var table_name = "OT_CHECKLIST_LISTVALS_HDR";
  var xmlString ="";
   
	  if(frmObj.list_id!=null){
		xmlString+="<CHECKLIST_LISTVALS_HDR"+" ";
		xmlString+="list_id=\""+frmObj.list_id.value+"\""+" ";
		xmlString+="description=\""+frmObj.description.value +"\""+" ";
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

