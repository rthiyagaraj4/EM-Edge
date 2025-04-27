<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
 	<script language='JavaScript' src='../../eCommon/js/common.js'></script>  
 <script language="javascript">	

var item_value=new String();
var item_description = new String();
var default_value_yn=new String();
var dftLstItem = new String();

function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var formObj =parent.RecordFrame.document.forms[0];
	formObj.item_description.value=rows.item_description;
	formObj.item_value.value=rows.item_value;
	formObj.default_value_yn.checked=(rows.default_value_yn=="Y")?true:false;
	formObj.recId.value =rows.recId;
	formObj.mode.value="U";
	formObj.item_value.disabled=true;	
}
  
function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 //alert(window.parent.parent.frames[1].frames[1].name);
	 var args="";
	 tab_data="<table border='1' cellpadding=3 cellspacing='0' width='100%'>"
	 tab_data+="<th class='columnHeaderCenter' align='left'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeaderCenter' align='left'><fmt:message key="Common.ItemValue.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeaderCenter' align='left'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>"
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   item_value+=rows[jj].item_value+",";
		   item_description+=rows[jj].item_description+",";
		   default_value_yn+=rows[jj].default_value_yn+",";
		   if(dftLstItem==""  && rows[jj].default_value_yn=="Y" ){
				dftLstItem =	rows[jj].item_value
		   }
		   qryVal = 	(jj%2==0)?"QRYEVEN":"QRYODD"; 
		   args=jj;
		   tab_data+="<tr><td class="+qryVal+">";
		   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].item_description+"</a></td>";
		   tab_data+="<td class="+qryVal+">"+rows[jj].item_value+"</td>";
		   tab_data+="<td class="+qryVal+">"+rows[jj].default_value_yn+"</td>";
		   tab_data+="</tr>";
		}
	  }//end of for Loop
    	
	tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  //window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
 }
</script>
</head>
<body onLoad="createTable();"  onmousedown="CodeArrest();">
<div id="test"></div> 
<form name="ListItemsDetailForm" id="ListItemsDetailForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

