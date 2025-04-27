<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                        
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.*,webbeans.eCommon.ConnectionManager" %>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
				<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
				<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript">	
var role_id = new String();
function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows_for_personnel[index];
	var role_id=rows.role_id;
	var role_desc=rows.role_desc;
	var no_Of_Persons=rows.no_Of_Persons;
	var recId =rows.recId;
	var mode="U";
	//alert(mode);
	var str = role_id+"::"+role_desc+"::"+no_Of_Persons+"::"+recId+"::"+mode;
	//alert("string concatenated=="+str);
	var frmObj = window.parent.parent.frames[1].frames[3];
	//alert(window.parent.parent.frames[1].frames[3].name);//RecordFrame
	frmObj.splitString(str);

}

function createTable(){ 
	//alert("inside create table func");
	 var rows=window.parent.parent.frames[1].frames[1].rows_for_personnel;
	//alert(window.parent.parent.frames[1].frames[1].name);
	 var args="";
	 tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%'>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="eOT.RoleID.Label" bundle="${ot_labels}"/></th>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="eOT.NoOfPersons.Label" bundle="${ot_labels}"/></th>"
	 
	
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
			//alert("inside for");
		   role_id+=rows[jj].role_id+",";
		    if(jj%2==0) qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD"; 
	     	   args=jj;
			 
				   tab_data+="<tr><td class="+qryVal+" nowrap>";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].role_desc+"</a></td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].role_id+"</td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].no_Of_Persons+"</td>";
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
<form name="SurgicalAccessoriesPersonnelRequiredDetailForm" id="SurgicalAccessoriesPersonnelRequiredDetailForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

