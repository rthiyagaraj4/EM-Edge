<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script language="javascript">	

var user_code=new String();
var srl = new String();

function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var user_id=rows.user_id;
	var user_name=rows.user_name;
	var recId =rows.recId;
	var mode="U";
	var str = user_id+"::"+user_name+"::"+recId+"::"+mode;
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);

}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var args="";
	 var count=0;
	 tab_data="<table class='grid' border='1' cellpadding=3 cellspacing='0' width='100%'>"
	 tab_data+="<th class='columnHeaderCenter' nowrap><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeaderCenter' nowrap><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>"	
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   user_code+=rows[jj].user_id+",";
		  	if(jj%2==0) qryVal="gridData";
			   else
				 qryVal="gridData"; 
	     	      args=jj;
			 
				   tab_data+="<tr><td class="+qryVal+" nowrap>";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].user_name+"</a></td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].user_id+"</td>";
				   tab_data+="</tr>";
			  
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
 // window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
  
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="SwabAndInstrumentsTemplateDetailForm" id="SwabAndInstrumentsTemplateDetailForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

