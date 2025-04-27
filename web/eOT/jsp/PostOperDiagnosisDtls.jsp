<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="eCommon.Common.CommonBean"  %>

<html>
<head>
<% 
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	//If calling from Surgeon History this flag is used
	String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode"));
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String remarks =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+",";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
<script language="javascript">
var code = new String();

function sendparams(index){
	var rows = parent.parent.ObjectCollect.diagnosis_rows[index];
	var mode = "U";
	var str = rows.icd_code+'::'+rows.icd_desc+'::'+rows.primary+'::'+rows.significant+'::'+rows.onset_date+'::'+rows.close_date+'::'+rows.remarks+'::'+rows.recId+'::'+mode;
	//alert(str);
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

function openDialogWindow(strVal,remarks){
  window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function createTable(){   
  var rows=parent.parent.ObjectCollect.diagnosis_rows;
  var db_flag=parent.parent.ObjectCollect.db_flag;
 // alert(rows.length);


  var tab_data="";
  tab_data="<table border='1' cellpadding=3  cellspacing='0' width='100%'>"
  tab_data+="<td align='center'>&nbsp;ICD&nbsp;</td>"
  tab_data+="<td align='center'>
  <fmt:message key="Common.primary.label" bundle="${common_labels}"/></td>"
  tab_data+="<td align='center'>
  <fmt:message key="Common.significant.label" bundle="${common_labels}"/></th>"
  tab_data+="<td class='columnheader' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>"
  tab_data+="<td	class='columnheader'><fmt:message key="eCA.CloseDate.label" bundle="${common_labels}"/></td>"
  tab_data+="<td  class='columnheader'>
  <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
  var args='';
  if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++) {
		   if(rows[jj]!=null  && rows[jj].db_mode!='D'){
				args=jj;
				code+= rows[jj].icd_code+",";
			    if(jj%2==0)
			     qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD";
				   tab_data+="<tr><td class="+qryVal+">";
				<%if( surgeon_doc_comp_yn.equals("Y") || qry_mode.equals("YES") ){%>				   
				   tab_data+=rows[jj].icd_desc+"</a></td>";
				 <%} else {%>
					   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].icd_desc+"</a></td>";
				<% } %>
					tab_data+="<td class="+qryVal+" align='center'>";
				   if(rows[jj].primary=='Y'){
				     tab_data+="<input type='checkbox' name=chkbox_pri_"+jj+" checked disabled></td>";
				   }else {
					 tab_data+="<input type='checkbox' name=chkbox_pri_"+jj+" disabled ></td>";
				   }

				   tab_data+="<td class="+qryVal+" align='center'>";
				   
				   if(rows[jj].significant=='Y'){
				     tab_data+="<input type='checkbox' name=chkbox_sig_"+jj+" checked disabled ></td>";
				   }else {
					 tab_data+="<input type='checkbox' name=chkbox_sig_"+jj+" disabled ></td>";
				   }

				   tab_data+="<td class="+qryVal+">"+rows[jj].onset_date+"</td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].close_date+"</td>";
				   tab_data+="<td class="+qryVal+">
				   <a href=\"javascript:openDialogWindow(remarks,'"+rows[jj].remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   tab_data+="</tr>"; 
				   if(db_flag=='ON')
						parent.parent.ObjectCollect.db_flag='OFF';


				  //alert(tab_data);		
	   }
	 }
  }
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility='visible';
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='createTable();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='InstrumentDtlsForm' id='InstrumentDtlsForm' >
</form>
<div id='test'></div>
</body>
</html>

