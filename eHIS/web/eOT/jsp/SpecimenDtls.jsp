<!DOCTYPE html>
<%@page import="eOT.*, eOT.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String  nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
String recovery_in_out_flag = CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));%>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/RecordNursing.js'></script>
<script language="javascript">
var code=new String();

function sendparams(index){
	var rows = parent.parent.ObjectCollect.specimen_rows[index]; 
	var specimen_dtls=rows.specimen_dtls;
	var dept_code=rows.dept_code;
	var dept_desc=rows.dept_desc;
	var quantity=rows.quantity;
	var recId =rows.recId;			   
	var mode="U"
	var str = specimen_dtls+"::"+dept_code+"::"+dept_desc+"::"+quantity+"::"+recId+"::"+mode;
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

function createTable(){    
  var rows = parent.parent.ObjectCollect.specimen_rows; 
  //var obj=document.getElementById("test");
  var args="";
  tab_data="<table border='1' cellpadding=3 cellspacing='0' width='100%' align='center'>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="eOT.SpecimenNoDtl.Label" bundle="${ot_labels}"/></th>";
  tab_data+="<th class='columnHeaderCenter'> <fmt:message key="Common.department.label" bundle="${common_labels}"/></th>";
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>";

//alert(rows.length);
//  if(rows!='undefined' && rows!=''&& rows.length > 0 )

if(rows!=null)
	  {

	  for(var jj=0;jj<rows.length;jj++){
		//if(rows[jj]!=null && rows[jj]!='undefined' && //rows[jj].db_mode!="D")
		if( rows[jj]!=null&&rows[jj].db_mode!="D")	
		{
		    code+=rows[jj].specimen_dtls+rows[jj].dept_code+","; 
		   if(jj%2==0) qryVal="gridData";
			   else
				 qryVal="gridData"; 
	     	   args=jj;
			  <%  if( nursing_doc_comp_yn.equals("Y") && !recovery_in_out_flag.equals("CHECK_OUT_RECO") ){ %>
			   //Added decodeURIComponent for IN024246 on 10/7/2010 by AnithaJ
			   tab_data+="<tr>";   
			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].specimen_dtls)+"</td>";
			   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].dept_desc+"</td>";
			   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
			   tab_data+="</tr>"; 
			   <%} else {%>
				   tab_data+="<tr><td nowrap class="+qryVal+">";
		   		   //Added decodeURIComponent for IN024246 on 10/7/2010 by AnithaJ
				   tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+decodeURIComponent(rows[jj].specimen_dtls)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].dept_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
				   tab_data+="</tr>";
			   <%}%>
			   //alert(tab_data);
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}

/*function openDialogWindow(strVal,remarks){
  window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 140px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="SpecimenDetailForm" id="SpecimenDetailForm" >
</form>
</body></html>

