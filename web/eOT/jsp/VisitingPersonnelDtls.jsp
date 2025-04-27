<!DOCTYPE html>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:set var="prefix" value="${'/eCommon/html/'}" /> 
<c:set var="sep" value="${'?'}" /> 
<c:set var="style" value="${prefix}${sessionScope.PREFERRED_STYLE}" /> 

<% 
	//	String tab = CommonBean.checkForNull(request.getParameter("tab"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"),"N"); 
%>
	

<html>
<head>
<link rel='StyleSheet' type='text/css'  href='<c:url value="${style}" />' />
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
	<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript">

var code=new String();
var VisitingPersonnel_value=getLabel("eOT.VisitingPersonnel.Label","OT");
function sendparams(index){
	var rows = parent.parent.parent.ObjectCollect.visit_pers_rows[index]; 
	var	speciality_code=rows.speciality_code;
	var	speciality_desc=rows.speciality_desc;
	//var wound_code = rows.wound_code;
	var visit_desc = rows.visit_desc;
	var	recId = rows.recId;	

	var mode = "U";
	var str =  speciality_code+"::"+speciality_desc+'::'+visit_desc+'::'+recId+'::'+mode;
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}
function openDialog_visit(strVal,index)
{
	var rows = parent.parent.parent.ObjectCollect.visit_pers_rows[index]; 
		var visit_desc = rows.visit_desc;
	   var remarks = encodeURIComponent(visit_desc); window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
 function createTable(){    
  var rows = parent.parent.parent.ObjectCollect.visit_pers_rows; 
  var VisitingPersonnel_value=getLabel("eOT.VisitingPersonnel.Label","OT");
  var obj=document.getElementById("test");
  var tab_data="";
  var queryVal="";
  var args="";
  tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%'>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/></td>"
  if(rows!=null && rows.length>0 ){
	for(var jj=0;jj<rows.length;jj++){
	  if(rows[jj]!=null && rows[jj].db_mode!='D'){
	   args = jj;
	   code+=rows[jj].speciality_code+","; 
	   if(jj%2==0)
		 qryVal="gridData";
	   else
		 qryVal="gridData";
		<% if (surgeon_doc_comp_yn.equals("Y")){ %>
			tab_data+="<tr>"	;
			tab_data+="<td nowrap class="+qryVal+">"+rows[jj].speciality_desc+"</td>";
			//tab_data+="<td class="+qryVal+"><a href=\"javascript:openDialogWindow(VisitingPersonnel_value,'"+rows[jj].visit_desc+"');\"><fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/></a></td>";
			tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialog_visit('"+VisitingPersonnel_value+"',"+args+");\">"+rows[jj].visit_desc+"</a></td>";
			tab_data+="</tr>"; 
		<% } else {%>
			tab_data+="<tr><td nowrap class="+qryVal+">";
			tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+rows[jj].speciality_desc+"</a></td>";
			//tab_data+="<td class="+qryVal+"><a href=\"javascript:openDialogWindow(VisitingPersonnel_value,'"+rows[jj].visit_desc+"');\"><fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/></a></td>";
			tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialog_visit('"+VisitingPersonnel_value+"',"+args+");\">"+rows[jj].visit_desc+"</a></td>";
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

