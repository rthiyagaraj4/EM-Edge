<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eOT/js/Hashtable.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript">
	var rows = new Array();
	var hash = new Hashtable()
	 
</script>
<script language="javascript">
function createXMLForOT_SPECIALITY_TIME_TABLE(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
 //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
 //alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  var concatedStr=formObj.oper_room_code.value;
  var arr=concatedStr.split("::");
  var oper_room_code=arr[0];
  //alert("oper_room_code in Object Collect=="+oper_room_code);
  var len = rows.length;
 //alert("Length of the rows array==="+len);
  var table_name = "OT_SPECIALITY_TIME_TABLE";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_SPECIALITY_TIME_TABLE function");
		xmlString+="<SPECIALITY_TIME_TABLE"+i+" ";
		xmlString+="operating_facility_id=\""+formObj.facility_id.value+"\""+" ";
		xmlString+="oper_room_code=\""+oper_room_code+"\""+" ";
		xmlString+="day_code=\""+rows[i].day_code +"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="start_time=\""+rows[i].start_time+"\""+" ";
		xmlString+="db_start_time=\""+rows[i].start_time+"\""+" ";
		xmlString+="end_time=\""+rows[i].end_time +"\""+" ";
		xmlString+="schedule_type=\""+rows[i].schedule_type+"\""+" ";
		xmlString+="first_week_yn=\""+rows[i].week1+"\""+" ";
		xmlString+="second_week_yn=\""+rows[i].week2+"\""+" ";
		xmlString+="third_week_yn=\""+rows[i].week3+"\""+" ";
		xmlString+="fourth_week_yn=\""+rows[i].week4+"\""+" ";
		xmlString+="fifth_week_yn=\""+rows[i].week5+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		}


	 }
 return xmlString;
}

/*function createXMLForSWAB_INSTR_TMPL_Hdr(){
	//alert("inside hdr func");
	
  var rows=window.parent.parent.frames[1].frames[1].rows;
  
  var formObj =window.parent.parent.frames[1].frames[0];
  
  var frmObj=formObj.document.forms[0];
  var mode = frmObj.mode.value;
  
  var len = rows.length;
  
  var table_name = "OT_SWAB_INSTR_TMPL_HDR";
  var xmlString ="";
   
	  if(frmObj.template!=null){
		  //alert("before xml of HDR");
		xmlString+="<SWAB_INSTR_TMPL_HDR "+" ";
		xmlString+="template_id=\""+frmObj.template.value+"\""+" ";
		xmlString+="description=\""+frmObj.description.value +"\""+" ";
		xmlString+="status=\""+frmObj.status.value +"\""+" ";
		xmlString+="mode=\""+mode.toUpperCase()+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("after xml of HDR");
	 }
 
 return xmlString;
}*/


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
</form>
</body>
</html>

