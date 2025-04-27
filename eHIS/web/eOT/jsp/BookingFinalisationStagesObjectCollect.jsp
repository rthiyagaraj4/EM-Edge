<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript">
	var rows = new Array();
	 
</script>
<script language="javascript">
function createXMLForBOOKING_FIN_STAGES_Dtl(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  ////alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
 // //alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  
  var len = rows.length;
 //alert("Length of the rows array==="+len);
  var table_name = "OT_BOOKING_FIN_STAGES_DTL_LANG_VW";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		xmlString+="<BOOKING_FIN_STAGES_DTL"+i+" ";
		xmlString+="stage_code=\""+formObj.stage_code.value+"\""+" ";
		xmlString+="facility_id=\""+formObj.facility_id.value+"\""+" ";
		xmlString+="user_id=\""+rows[i].user_id+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString=="+xmlString);
				
	 }
	 
  }
 return xmlString;
}

function createXMLForBOOKING_FIN_STAGES_Hdr(){
	//alert("inside hdr func");
	
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var formObj =window.parent.parent.frames[1].frames[0];
  var frmObj=formObj.document.forms[0];
  var mode = frmObj.mode.value;
  var len = rows.length;
 // var table_name = "OT_BOOKING_FIN_STAGES"; Commented by Chinju Thai Convertion
  var table_name = "OT_BOOKING_FIN_STAGES_LANG_VW";
  var xmlString ="";
   
	  if(frmObj.stage_code!=null){
		 //alert("before xml of HDR");
		xmlString+="<BOOKING_FIN_STAGES_HDR "+" ";
		xmlString+="stage_code=\""+frmObj.stage_code.value+"\""+" ";
		xmlString+="pre_stage_description=\""+frmObj.pre_stage_description.value +"\""+" ";
		xmlString+="post_stage_description=\""+frmObj.post_stage_description.value +"\""+" ";
		xmlString+="srl_no=\""+frmObj.srl_no.value +"\""+" ";
		xmlString+="color_ind=\""+frmObj.color_ind.value +"\""+" ";
		xmlString+="text_color=\""+frmObj.text_color.value +"\""+" ";
		xmlString+="specific_indicator=\""+frmObj.specific_indicator.value +"\""+" ";
		xmlString+="position_code=\""+frmObj.position_code.value +"\""+" ";
		xmlString+="action_if_not_done=\""+frmObj.action_if_not_done.value +"\""+" ";
		xmlString+="pac_stage_yn=\""+frmObj.pac_stage_yn.value +"\""+" ";
		xmlString+="mode=\""+mode.toUpperCase()+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert(xmlString);
		//alert("after xml of HDR");
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

