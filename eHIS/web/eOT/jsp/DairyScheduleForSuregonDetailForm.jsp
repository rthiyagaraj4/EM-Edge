<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
<HTML>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
	<script language='JavaScript' src='../../eOT/js/Hashtable.js'></script>
	<script language='JavaScript' src='../../eOT/js/DairyScheduleForSuregon.js'></script>
<script language="javascript">	
var surgeon_code=new String();
var speciality_code=new String();
var day=new String();
var allDaySurgnSplty=new String();

var enable="<img class='label' src='../../eCommon/images/enabled.gif'>";
	 var disabled="<img class='label' src='../../eCommon/images/disabled.gif'>";

	 var args="";
function sendparams(index){
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(index);
}
function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var wk = ""; 
	 // alert(window.parent.parent.frames[1].frames[1].name);
	 var args="";
	 tab_data='<table class=grid border=1 cellpadding=3 cellspacing=0 width=100%>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.day.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FirstWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.SecondWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.ThirdWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FourthWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FifthWeek.Label" bundle="${ot_labels}"/></th>'
	// alert(rows);
	 if(rows!=null){
	 for(var jj=0;jj<rows.length;jj++){
	     var hash = new Hashtable();	
	     hash = rows[jj];
		if(hash.get("mode")!="D"){
          surgeon_code+=hash.get("surgeon_code")+",";
          speciality_code+=hash.get("speciality_code")+",";
          day+=hash.get("day")+",";
		  allDaySurgnSplty+=(hash[day]==0)?hash.get("speciality_code")+hash.get("surgeon_code"):"";  
		  var weeks = hash.get("week");
		  qryVal=(jj%2==0)?"datagrid":"datagrid";
		  tab_data+="<tr><td class="+qryVal+">";
		  tab_data+="<a href=\"javascript:sendparams("+jj+");\" nowrap>"+hash.get("surgeon_desc")+"</a></td>";
          tab_data+="<td class="+qryVal+" nowrap>"+hash.get("speciality_desc")+"</td>";
          tab_data+="<td class="+qryVal+" nowrap>"+hash.get("day_desc")+"</td>";
          tab_data+="<td class="+qryVal+" nowrap>"+hash.get("start_time")+"</td>";
		  tab_data+="<td class="+qryVal+" nowrap>"+hash.get("end_time")+"</td>";
		   for(j=0 ;j<weeks.length;j++ ){
			   wk = (weeks.substring(j,j+1)=="Y")?enable:disabled
			  tab_data+="<td class="+qryVal+">"+wk+"</td>";  ;
		  }
		   tab_data+="</tr>";
	     }//end of if
	   hash = null;
	  }//end of for Loop
	 }
  	tab_data+="</table>";
//  alert("Dtl Form 75 : "+tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
 window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num'
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="DairyScheduleForSuregonDetailForm" id="DairyScheduleForSuregonDetailForm" >
</form>
</body>

