<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script language="javascript">
	var rows = new Array();
	 
</script>
<script language="javascript">
function createXMLForChecklistDtl(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
 // alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
  //alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  
  var len = rows.length;
 // alert("Length of the rows array==="+len);
  var table_name = "OT_CHECKLIST_DTL";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		  //alert("mode in OT_CHECKLIST_DTL func=="+rows[i].mode);
		 if(rows[i].mode=="")
			 break;
		 else if(rows[i].mode=="I"){
		xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="checklist_code=\""+formObj.checklist_code.value+"\""+" ";
		xmlString+="checklist_item_code=\""+rows[i].checklist_item_code +"\""+" ";
		xmlString+="checklist_item_srl_no=\""+rows[i].checklist_item_srl_no+"\""+" ";
		 //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		//Start
		xmlString+="intra_operative_sel=\""+rows[i].intra_operative_sel_val+"\""+" ";
		//End
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString in OT_CHECKLIST_DTL func=="+xmlString);
		 }else if(rows[i].mode=="U"){
		xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="checklist_code=\""+formObj.checklist_code.value+"\""+" ";
		xmlString+="checklist_item_code=\""+rows[i].checklist_item_code +"\""+" ";
		xmlString+="checklist_item_srl_no=\""+rows[i].checklist_item_srl_no+"\""+" ";
		 //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		//Start
		xmlString+="intra_operative_sel=\""+rows[i].intra_operative_sel_val+"\""+" ";
		//End
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	    //alert("xmlString in OT_CHECKLIST_DTL func=="+xmlString);
		 }
		 else{
			//alert("inside delete xml of dtl");
			  xmlString+="<CHECKLIST_DTL"+i+" ";
		xmlString+="checklist_code=\""+formObj.checklist_code.value+"\""+" ";
		xmlString+="checklist_item_code=\""+rows[i].checklist_item_code +"\""+" ";		xmlString+="checklist_item_srl_no=\""+rows[i].checklist_item_srl_no+"\""+" ";		
		xmlString+="mode=\""+rows[i].mode+"\""+" ";		
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString in OT_CHECKLIST_DTL delete func=="+xmlString);
		 }
		 }
  }
  
 return xmlString;
}

function createXMLForChecklistHdr(){
	
  var rows=window.parent.parent.frames[1].frames[1].rows;
  
  var formObj =window.parent.parent.frames[1].frames[0];
  var frmObj=formObj.document.forms[0];
  var mode = frmObj.mode.value;
  
  var len = rows.length;
  
  var table_name = "OT_CHECKLIST_HDR";
  var xmlString ="";
   
	  if(frmObj.checklist_code!=null){
		xmlString+="<CHECKLIST_HDR"+" ";
		xmlString+="checklist_code=\""+frmObj.checklist_code.value+"\""+" ";
		xmlString+="description=\""+frmObj.description.value +"\""+" ";
		xmlString+="status=\""+frmObj.status.value+"\""+" ";
		xmlString+="mode=\""+mode.toUpperCase()+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
 
 return xmlString;
}


</script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
</form>
</body>
</html>

