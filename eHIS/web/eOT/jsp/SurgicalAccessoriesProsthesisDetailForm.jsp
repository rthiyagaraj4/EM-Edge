<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                               
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
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript">	
var prosthesis_code=new String();
function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows_for_prosthesis[index];
	var prosthesis_code=rows.prosthesis_code;
	var prosthesis_desc=rows.prosthesis_desc;
	var no_Of_Units=rows.no_Of_Units;
	var recId =rows.recId;
	var mode="U";
	var str = prosthesis_code+"::"+prosthesis_desc+"::"+no_Of_Units+"::"+recId+"::"+mode;
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);

}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows_for_prosthesis;
	//alert(window.parent.parent.frames[1].frames[1].name);
	 var args="";
	 tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%'>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></th>"
	 
	
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		    prosthesis_code+=rows[jj].prosthesis_code+",";
		   	if(jj%2==0) qryVal="gridData";
			   else
				 qryVal="gridData"; 
	     	   args=jj;
			 
				   tab_data+="<tr><td class="+qryVal+" nowrap>";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].prosthesis_desc+"</a></td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].prosthesis_code+"</td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].no_Of_Units+"</td>";
				   tab_data+="</tr>";
			  
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
 
  window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
  
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="SurgicalAccessoriesProsthesisDetailForm" id="SurgicalAccessoriesProsthesisDetailForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

