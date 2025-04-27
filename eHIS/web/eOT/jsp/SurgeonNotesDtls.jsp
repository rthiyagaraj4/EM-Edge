<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<% //"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eOT.*" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,oracle.jdbc.driver.*,eCommon.Common.*,webbeans.eCommon.*,eOT.*" %>

<%@page   import="java.sql.*, java.util.*, java.io.*"%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<% 

	String surgeon_doc_comp_yn = "";
	//String tab = CommonBean.checkForNull(request.getParameter("tab"));
	surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
%>
	

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
	<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript">
var code=new String();
function sendparams(index){
	var rows = parent.parent.parent.ObjectCollect.notes_rows[index]; 
	var	speciality_code=rows.speciality_code;
	var	speciality_desc=rows.speciality_desc;
	/*var wound_code = rows.wound_code;
	var wound_desc = rows.wound_desc;
	var	recId = rows.recId;			   
	var mode = "U";
	var str =  speciality_code+"::"+speciality_desc+'::'+wound_code+'::'+wound_desc+'::'+recId+'::'+mode;
	//alert(str);
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);*/
}

function createTable(){    
  var rows = parent.parent.parent.ObjectCollect.notes_rows; 
  var obj=document.getElementById("test");
  var tab_data="";
  var queryVal="";
  var args="";
  tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%'>"
  tab_data+="<th align='center'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>"
  tab_data+="<th align='center'><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th>"
  if(rows!=null && rows.length>0 ){
	for(var jj=0;jj<rows.length;jj++){
	  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
	   args = jj;
	   code+=rows[jj].speciality_code+","; 
	   if(jj%2==0)
		 qryVal="QRYEVEN";
	   else
		 qryVal="QRYODD"; 
		<% if (surgeon_doc_comp_yn.equals("Y")){ %>
			tab_data+="<tr>"	;
			tab_data+="<td class="+qryVal+">"+rows[jj].speciality_desc+"</td>";
			tab_data+="<td class="+qryVal+"><a href=\"javascript:openDialogWindow('remarks','"+rows[jj].notes+"');\"><fmt:message key="Common.notes.label" bundle="${common_labels}"/></a></td>";
			tab_data+="</tr>"; 
		<% } else {%>
			tab_data+="<tr><td class="+qryVal+">";
			tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].speciality_desc+"</a></td>";
			tab_data+="<td class="+qryVal+"><a href=\"javascript:openDialogWindow('remarks','"+rows[jj].notes+"');\"><fmt:message key="Common.notes.label" bundle="${common_labels}"/></a></td>";
			tab_data+="</tr>"; 
		<% } %>

		}
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="WoundDtlsForm" id="WoundDtlsForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

