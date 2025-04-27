<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

%>
<HTML>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language="javascript">	
var speciality_code=new String();
var day_code=new String();
var day_desc=new String();
var start_time=new String();
var end_time = new String();
var allDaySplty=new String();
function sendparams(index){
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(index);

}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var enable="<img class='label' src='../../eCommon/images/enabled.gif'>";
	 var disabled="<img class='label' src='../../eCommon/images/disabled.gif'>";
	 var week1 = "";
	 var week2 = "";
	 var week3 = "";
	 var week4 = "";
	 var week5 = "";
	 var args="";
	 tab_data='<table border=1 class=grid cellpadding=3 cellspacing=0 width=100%>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.day.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FirstWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.SecondWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.ThirdWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FourthWeek.Label" bundle="${ot_labels}"/></th>'
	 tab_data+='<th class=columnHeaderCenter nowrap><fmt:message key="eOT.FifthWeek.Label" bundle="${ot_labels}"/></th>'
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   speciality_code+=rows[jj].speciality_code+",";
		   day_code+=rows[jj].day_code+",";
		   allDaySplty+=(rows[jj].day_code==0)?rows[jj].speciality_code:""; 
		   week1 = (rows[jj].week1=="Y")?enable:disabled;
		   week2=(rows[jj].week2=="Y")?enable:disabled;
		   week3=(rows[jj].week3=="Y")?enable:disabled;
		   week4=(rows[jj].week4=="Y")?enable:disabled;
   		   week5=(rows[jj].week5=="Y")?enable:disabled;
		   qryVal =(jj%2==0) ?"datagrid":"datagrid";
		   args=jj;
		   tab_data+="<tr><td class="+qryVal+">";
		   tab_data+="<a href=\"javascript:sendparams("+args+");\" nowrap>"+rows[jj].speciality_desc+"</a></td>";
		   if(rows[jj].day_desc=="All"){
		   tab_data+="<td class="+qryVal+">"+rows[jj].day_desc+" Days</td>";
		   }else{
		   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].day_desc+"</td>";	}
		   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].start_time+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].end_time+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+week1+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+week2+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+week3+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+week4+"</td>";
		   tab_data+="<td class="+qryVal+" nowrap>"+week5+"</td>";
		   tab_data+="</tr>";	
		 }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";
	document.getElementById("test").innerHTML = tab_data;
	document.getElementById("test").style.visibility="visible";
	window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=<%=checkForNull(request.getParameter("mesg"))%>'
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="BlockSlotsBySpecialityForm" id="BlockSlotsBySpecialityForm" >
</form>
</body>

