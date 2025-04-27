<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/Hashtable.js"></Script>
<script language="javascript">	

function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var hash = new Hashtable();	
	hash = rows;
	var str = hash.get("agegrp_code")+"::"+hash.get("agegrp_desc")+"::"+hash.get("start_time")+"::"+hash.get("end_time")+"::"+hash.get("alert_type")+"::"+hash.get("recId")+"::U"
	alert(str);
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);
}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var tab_data="<table border='1' cellpadding=3 cellspacing='0' width='100%'>"
	 tab_data+='<td class=COLUMNHEADERCENTER ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>';
	 tab_data+='<td class=COLUMNHEADERCENTER><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></th>';
	 tab_data+='<td class=COLUMNHEADERCENTER><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></th>';
	 //if(rows!=null){
		for(var jj=0;jj<rows.length;jj++){
	     var hash = new Hashtable();	
	     hash = rows[jj];
	     if(hash.get("mode")!="D"){
		  qryVal=(jj%2==0)?"QRYEVEN":"QRYODD";
		  tab_data+="<tr><td class="+qryVal+">";
		  tab_data+="<a href=\"javascript:sendparams("+jj+");\">"+hash.get("agegrp_desc")+"</a></td>";
          tab_data+="<td class="+qryVal+">"+hash.get("start_time")+"</td>";
		  tab_data+="<td class="+qryVal+">"+hash.get("end_time")+"</td>";
		  tab_data+="</tr>";
	     }//end of if
	   hash = null;
	  }//end of for Loop
	 //}
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
<form name="SwabAndInstrumentsTemplateDetailForm" id="SwabAndInstrumentsTemplateDetailForm" >
</form>
</body>

