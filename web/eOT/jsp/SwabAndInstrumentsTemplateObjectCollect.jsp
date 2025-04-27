<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script language="javascript">
	var rows = new Array();
</script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript">
function createXMLForSWAB_INSTR_TMPL_Dtl(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  ////alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
  var masterFrame=window.parent.parent.frames[1].frames[0];
 // //alert(window.parent.parent.frames[1].frames[0].name);//masterframe
  var formObj=masterFrame.document.forms[0];
  
  var len = rows.length;
 // //alert("Length of the rows array==="+len);
  var table_name = "OT_SWAB_INSTR_TMPL_DTL";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		 // //alert("mode in SWAB_INSTR_TMPL_DTL func=="+rows[i].mode);
		 if(rows[i].mode=="")
			 break;
		 else if(rows[i].mode=="I"){
			//alert("before xml of DTL");
		xmlString+="<SWAB_INSTR_TMPL_DTL"+i+" ";
		xmlString+="template_id=\""+formObj.template.value+"\""+" ";
		xmlString+="srl_no=\""+rows[i].srl_no +"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="initial_count=\""+(rows[i].initial_count).replace("&nbsp;","")+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		 }else if(rows[i].mode=="U"){
			xmlString+="<SWAB_INSTR_TMPL_DTL"+i+" ";
		xmlString+="template_id=\""+formObj.template_id.value+"\""+" ";
		xmlString+="srl_no=\""+rows[i].srl_no +"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="initial_count=\""+(rows[i].initial_count).replace("&nbsp;","")+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("after xml of DTL");
		}
		else
		  {
			//alert("inside delete xml of dtl");
			xmlString+="<SWAB_INSTR_TMPL_DTL"+i+" ";
		xmlString+="template_id=\""+formObj.template_id.value+"\""+" ";
		xmlString+="srl_no=\""+rows[i].srl_no +"\""+" ";
		xmlString+="item_code=\""+rows[i].item_code+"\""+" ";
		xmlString+="initial_count=\""+(rows[i].initial_count).replace("&nbsp;","")+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString in delete of dtl==="+xmlString);
		//alert("after delete xml of DTL");
		}
	 }
  }
  //alert(xmlString);
 return xmlString;
}

function createXMLForSWAB_INSTR_TMPL_Hdr(){
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

