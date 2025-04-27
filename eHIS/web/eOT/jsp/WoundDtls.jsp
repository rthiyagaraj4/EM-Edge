<!DOCTYPE html>
<%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eOT.*"
%>

<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"%>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<% 
	String surgeon_doc_comp_yn = "";
//	String tab = CommonBean.checkForNull(request.getParameter("tab"));
	surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
%>
	

<html>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
<!-- 	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>-->
<script language="javascript">
var code=new String();
function sendparams(index){
	var rows = parent.parent.parent.ObjectCollect.wound_rows[index]; 
	var	speciality_code=rows.speciality_code;
	var	speciality_desc=rows.speciality_desc;
	var wound_code = rows.wound_code;
	var wound_desc = rows.wound_desc;
	var	recId = rows.recId;			   
	var mode = "U";
	var str =  speciality_code+"::"+speciality_desc+'::'+wound_code+'::'+wound_desc+'::'+recId+'::'+mode;
	//alert(str);
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

function createTable(){    
  var rows = parent.parent.parent.ObjectCollect.wound_rows; 
  var obj=document.getElementById("test");
  var woundType_title=getLabel("eOT.WoundType.Label","OT");
  var tab_data="";
  var queryVal="";
  var args="";
  tab_data="<table border='1' cellpadding=3  cellspacing='0' width='100%'>"
  tab_data+="<td class='columnHeaderCenter' width='30%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter' width='70%'><fmt:message key="eOT.WoundType.Label" bundle="${ot_labels}"/></td>"
  if(rows!=null && rows.length>0 ){
	for(var jj=0;jj<rows.length;jj++){
	  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
	   args = jj;
	   code+=rows[jj].speciality_code+","; 
	   if(jj%2==0)
		 qryVal="gridData";
	   else
		 qryVal="gridData"; 
		<% if (surgeon_doc_comp_yn.equals("Y")){ %>
			tab_data+="<tr>"	;
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].speciality_desc+"</td>";
			tab_data+="<td nowrap class="+qryVal+"><a href=\"javascript:openDialog123('"+woundType_title+"','"+rows[jj].wound_desc+"');\">"+rows[jj].wound_desc+"</a></td>";
			tab_data+="</tr>"; 
		<% } else {%>
			tab_data+="<tr><td nowrap class="+qryVal+">";
			tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+rows[jj].speciality_desc+"</a></td>";
			tab_data+="<td class="+qryVal+"><a class='gridLink' href=\"javascript:openDialog123('"+woundType_title+"','"+rows[jj].wound_desc+"');\">"+rows[jj].wound_desc+"</a></td>";
			tab_data+="</tr>"; 
		<% } %>

		}
	  }//end of for Loop
	  if(code=="*ALL,"){
			sendparams(rows.length-1);
	   }
  }// end if 
  	
	tab_data+="</table>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}

</script>
</head>
<body onLoad="createTable();">
<div id="test"></div>
<form name="WoundDtlsForm" id="WoundDtlsForm" >
</form>
</body>

