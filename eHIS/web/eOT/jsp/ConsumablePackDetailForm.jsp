<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script> -->
<script language="javascript">	
var code=new String();
var srl = new String();

function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var item_code=rows.item_code;
	var short_description=rows.short_description;
	var reqd_qty=rows.reqd_qty;
	var recId =rows.recId;
	var uom =rows.uom;

	//alert("uom--->"+uom);
	var mode="U";
	var str = item_code+"::"+short_description+"::"+reqd_qty+"::"+recId+"::"+mode+"::"+uom;
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);
}

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var args="";
	 tab_data="<table class='grid' border='1' cellpadding=4  cellspacing='0' width='100%'>"
	 tab_data+="<th class=ColumnHeader nowrap><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class=ColumnHeader nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class=ColumnHeader nowrap><fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></th>"
	 tab_data+="<th class=ColumnHeader nowrap><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>"
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   code+=rows[jj].item_code+",";
		  	if(jj%2==0) qryVal="gridData";
			   else
				 qryVal="gridData"; 
	     	     args=jj;
				   tab_data+="<tr><td class="+qryVal+">";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].item_code+"</a></td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].short_description+"</td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].reqd_qty+"</td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].uom+"</td>";
				   tab_data+="</tr>";
			  
		  }
	  }//end of for Loop
  }// end if 
  	
  tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  //window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
  
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="ConsumablePackDetailForm" id="ConsumablePackDetailForm" >
</form>
</body>
</html>

