<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String mesg = checkForNull(request.getParameter("mesg"));
	String status = checkForNull(request.getParameter("status"));
	String mode = checkForNull(request.getParameter("update_mode_yn"));
%>

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

var code=new String();
var srl = new String();

function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var item_code=rows.item_code;
	var srl_no=rows.srl_no;
	var description=rows.description;
	if(rows.initial_count=="&nbsp;")
	   rows.initial_count='';
	var initial_count=rows.initial_count;
	var recId =rows.recId;
	var mode="U";
	var str = item_code+"::"+srl_no+"::"+description+"::"+initial_count+"::"+recId+"::"+mode;
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);

}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var args="";
	 tab_data="<table border='1' cellpadding='0' cellspacing='0' width='100%'>";
	 tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>";
	 tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>";
	 tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>";
	 tab_data+="<th class='columnHeaderCenter'><fmt:message key="eOT.InitialCount.Label" bundle="${ot_labels}"/></th>";
	
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   srl+=rows[jj].srl_no+","; 
		   code+=rows[jj].item_code+",";
		   if(rows[jj].initial_count=='' || rows[jj].initial_count==null)
			   rows[jj].initial_count="&nbsp;";
			if(jj%2==0) qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD"; 
	     	   args=jj;
			    tab_data+="<tr><td class="+qryVal+">";
				<% if(mode.equals("modify") && status.equals("D") ){ %>
				   tab_data+=rows[jj].srl_no+"</td>";
				 <%}else{%>
					   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].srl_no+"</a></td>";
				  <%}%>
				  tab_data+="<td class="+qryVal+">"+rows[jj].description+"</td>";
				  tab_data+="<td class="+qryVal+">"+rows[jj].item_code+"</td>";
				  tab_data+="<td class="+qryVal+">"+rows[jj].initial_count+"</td>";
				  tab_data+="</tr>";
			  
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=<%=mesg%>';
  
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="SwabAndInstrumentsTemplateDetailForm" id="SwabAndInstrumentsTemplateDetailForm" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>
<script>createTable();</script>

