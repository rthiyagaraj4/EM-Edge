<!DOCTYPE html>

<%@page  import ="eCommon.Common.*" %>
<%@page   import="java.sql.*, java.util.*, java.io.*" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<% 

	String surgeon_doc_comp_yn = "",nursing_doc_comp_yn = "";
	String tab = CommonBean.checkForNull(request.getParameter("tab"));
	if(tab.equals("record_surgeon")){
		 surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	}else if(tab.equals("record_nursing")){
		 nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	}
%>
    

<html>
<head>
<title> <%= request.getParameter("title")%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/SwabCount.js'></script>
<script language="javascript">
var code=new String();

function sendparams(index){
	var rows = parent.parent.RecordFrame.personnelrows1[index]; 
	var	speciality_code=rows.speciality_code;
	var	speciality_desc=rows.speciality_desc;
	var	role_id=rows.role_id;
	var	role_desc=rows.role_id+"##"+rows.role_type;
	var	practitioner_id=rows.practitioner_id;
	var	practitioner_name=rows.practitioner_name;
	var	recId = rows.recId;			   
	var role_type=rows.role_type;
	var mode = "U";
	var str =  speciality_code+"::"+speciality_desc+'::'+role_id+'::'+role_desc+'::'+practitioner_id+'::'+practitioner_name+'::'+recId+'::'+role_type+'::'+mode;
	var frmObj = parent.parent.RecordFrame.RecordFrame;
	frmObj.splitString(str);
}

function createTable(){    
  var rows = parent.parent.RecordFrame.personnelrows1; 
  var obj=document.getElementById("test");
  var tab_data="";
  var speciality_desc="";
  var speciality_code="";
  var role_id = "";
  var role_desc = "";
  var practitioner_id="";
  var practitioner_name = "";
  var queryVal="";
  var recId="";
  var args="";
  tab_data="<table border='1' cellpadding=3  cellspacing='0' width='100%' align='center'>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter'> <fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>"
  if(rows!=null && rows.length>0 ){
	for(var jj=0;jj<rows.length;jj++){
	  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
	   speciality_code=rows[jj].speciality_code;
	   speciality_desc=rows[jj].speciality_desc;
	   role_id=rows[jj].role_id;
	   role_desc= rows[jj].role_id+"::"+rows[jj].role_type;
	   role_type = rows[jj].role_type;
	   practitioner_id=rows[jj].practitioner_id;
	   practitioner_name=rows[jj].practitioner_name;
	   recId = rows[jj].recId;			   
	   args = jj;
	   code+=speciality_code+role_id+practitioner_id+","; 
	   if(jj%2==0)
		 qryVal="gridData";
	   else
		 qryVal="gridData"; 
			  // alert(args);
		 <% if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y") ){ %>
			tab_data+="<tr>"	;
			tab_data+="<td nowrap class="+qryVal+">"+speciality_desc+"</td>";
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].role_desc+"</td>";
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].practitioner_name+"</td>";
			tab_data+="</tr>"; 
		<% } else {%>
			tab_data+="<tr><td class="+qryVal+">";
			tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+speciality_desc+"</a></td>";
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].role_desc+"</td>";
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].practitioner_name+"</td>";
			tab_data+="</tr>"; 
		<% } %>

		 //alert(tab_data);
		}
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="PersonnelDetailForm" id="PersonnelDetailForm" >

</form>
</body>

