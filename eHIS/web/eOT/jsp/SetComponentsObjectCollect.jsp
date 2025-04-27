<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript">
	var rows = new Array();
	 
</script>
<script language="javascript"> 
function createXMLForInstrumentComponents(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
 // alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
 // alert("Length of the rows array==="+len);
  var table_name = "OT_INSTRUMENT_COMPONENTS";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		 if(rows[i].mode=="")
			 break;
		 else if(rows[i].mode=="I"){
		xmlString+="<INSTRUMENT_COMPONENTS"+i+" ";
		xmlString+="instr_code=\""+formObj.instr_code.value+"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="st_location=\""+encodeURIComponent(rows[i].st_location)+"\""+" ";		
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	    //alert("xmlString in insert=="+xmlString);
        }else if(rows[i].mode=="U"){
			xmlString+="<INSTRUMENT_COMPONENTS"+i+" ";
		xmlString+="instr_code=\""+formObj.instr_code.value+"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="st_location=\""+encodeURIComponent(rows[i].st_location)+"\""+" ";//MuthuN
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		 }
		 else{
			 xmlString+="<INSTRUMENT_COMPONENTS"+i+" ";
		xmlString+="instr_code=\""+formObj.instr_code.value+"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="st_location=\""+encodeURIComponent(rows[i].st_location)+"\""+" ";//MuthuN
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	    //alert("xmlString in delete=="+xmlString);
		 }
	 }
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

