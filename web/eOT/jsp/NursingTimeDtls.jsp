<!DOCTYPE html>
<%@ page import ="eCommon.Common.CommonBean,webbeans.eCommon.ConnectionManager,java.sql.Connection" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 	
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	request.setCharacterEncoding("UTF-8");

	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));

	Connection con = null;
	
	//Added by Arthi for ML-MMOH-CRF-1936
	Boolean isTimeDtlsSurNurAppl = false;
	try{
		con = ConnectionManager.getConnection(request);
		isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");
	}catch(Exception e){
	 	System.err.println("Exception in Nursing Time Dtl->"+e);
 	}
 	finally {
	 	try{
	 		con.close();
	 	}
	 	catch(Exception e){
	 		System.err.println("Exception in Nursing Time Dtl->"+e);
	 	}
 	}
%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
<!-- commented above line for IN023984 on 9/29/2010 by AnithaJ & below line is added-->
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
<script language="javascript">
var code = new String();
function sendparams(index){
	  var rows = parent.parent.parent.ObjectCollect.time_rows[index];
	var speciality_code=rows.speciality_code
	var speciality_desc=rows.speciality_desc;
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	  
	  //preparation time
	  var preparation_time=rows.preparation_time;
	  var preparation_mts=rows.preparation_mts;
	 
	 //procedure start
	  var procedure_start_time=rows.procedure_start_time;
	  var procedure_start_date=rows.procedure_start_date;
	//procedure end
	  var procedure_end_time=rows.procedure_end_time;
	  var procedure_end_date=rows.procedure_end_date;
	  //anaesthesia start
	  var anaesthesia_start_time=rows.anaesthesia_start_time;
	  var anaesthesia_start_date=rows.anaesthesia_start_date;
	  //anaesthesia end
	  var anaesthesia_end_time=rows.anaesthesia_end_time;
	  var anaesthesia_end_date=rows.anaesthesia_end_date;
	
	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
	//Preparation start
	 var prep_start_time=rows.prep_start_time;
	 var prep_start_date=rows.prep_start_date;
	 //Preparation end
	 var prep_end_time=rows.prep_end_time;
	 var prep_end_date=rows.prep_end_date;
	}

	  //surgery start
	  var surgery_start_time=rows.surgery_start_time;
	  var surgery_start_date=rows.surgery_start_date;
	 //surgery end
	  var surgery_end_time=rows.surgery_end_time;
	  var surgery_end_date=rows.surgery_end_date;

	  var db_anaesthesia_end_time = rows.db_anaesthesia_end_time
	  var db_surgery_end_time = rows.db_surgery_end_time
	  var db_prep_end_time = rows.db_prep_end_time
	  var recId = rows.recId;
	  var mode = "U";

	  //Added by Arthi for ML-MMOH-CRF-1936
	  if(isTimeDtlsSurNurAppl=="true"){
		var str = speciality_code+'::'+speciality_desc+'::'+preparation_time+'::'+preparation_mts+'::'+procedure_start_time+'::'+procedure_start_date+'::'+procedure_end_time+'::'+procedure_end_date+'::'+anaesthesia_start_time+'::'+anaesthesia_start_date+'::'+anaesthesia_end_time+'::'+anaesthesia_end_date+'::'+prep_start_time+'::'+prep_start_date+'::'+prep_end_time+'::'+prep_end_date+'::'+surgery_start_time+'::'+surgery_start_date+'::'+surgery_end_time+'::'+surgery_end_date+'::'+recId+'::'+mode;
	  }else{
		var str = speciality_code+'::'+speciality_desc+'::'+preparation_time+'::'+preparation_mts+'::'+procedure_start_time+'::'+procedure_start_date+'::'+procedure_end_time+'::'+procedure_end_date+'::'+anaesthesia_start_time+'::'+anaesthesia_start_date+'::'+anaesthesia_end_time+'::'+anaesthesia_end_date+'::'+surgery_start_time+'::'+surgery_start_date+'::'+surgery_end_time+'::'+surgery_end_date+'::'+recId+'::'+mode;
	  }
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

function createTable(){   
  //var rows=parent.parent.ObjectCollect.instrument_rows;
  var rows=parent.parent.parent.ObjectCollect.time_rows;
  var tab_data="";
  var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
 
  tab_data="<table class='grid' border='1' cellpadding=3  cellspacing='0' width='100%' align='center'>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='Common.speciality.label' bundle='${common_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap> Prepartion Time(in mins)</td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.AnaesthesiaProcedureStartTime.Label' bundle='${ot_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.AnaesthesiaProcedureEndTime.Label' bundle='${ot_labels}'/></td>"; 
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.AnaesthesiaStartTime.Label' bundle='${ot_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.AnaesthesiaEndTime.Label' bundle='${ot_labels}'/></td>";

  //Added by Arthi for ML-MMOH-CRF-1936
  if(isTimeDtlsSurNurAppl=="true"){
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.Preparation.Label' bundle='${ot_labels}'/>&nbsp;<fmt:message key='Common.StartTime.label' bundle='${common_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.Preparation.Label' bundle='${ot_labels}'/>&nbsp;<fmt:message key='Common.EndTime.label' bundle='${common_labels}'/></td>";
 
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='Common.Surgery.label' bundle='${common_labels}'/>&nbsp;<fmt:message key='Common.StartTime.label' bundle='${common_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='Common.Surgery.label' bundle='${common_labels}'/>&nbsp;<fmt:message key='Common.EndTime.label' bundle='${common_labels}'/></td>";
  }else{
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.ProcedureStartTime.Label' bundle='${ot_labels}'/></td>";
  tab_data+="<td class='columnHeaderCenter' nowrap><fmt:message key='eOT.ProcedureEndTime.Label' bundle='${ot_labels}'/></td>"; 
  }
  var args='';
  if(rows!=null && rows.length>0){
	   for(var jj=0;jj<rows.length;jj++) {
		   if(rows[jj]!=null  && rows[jj].db_mode!='D'){
				args=jj;
				code+= rows[jj].speciality_code+",";
				 qryVal="gridData";
			       tab_data+="<tr>";
				   <% if( nursing_doc_comp_yn.equals("Y") ) { %> 
	  			   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].speciality_desc+"</td>";
					<%}else{%>
					tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams("+args+");\">"+rows[jj].speciality_desc+"</a></td>";
					<%}%>
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].preparation_mts+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_procedure_start_time+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_procedure_end_time+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_anaesthesia_start_time+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_anaesthesia_end_time+"</td>";
					
				   if(isTimeDtlsSurNurAppl=="true"){
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_prep_start_time+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_prep_end_time+"</td>";
				   }

				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_surgery_start_time+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].db_surgery_end_time+"</td>";
				   tab_data+="</tr>"; 
		}
	 }
	 tab_data+="</table>"; 
  if(code=="*ALL,"){
	sendparams(rows.length-1);
  }
  }
   

  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility='visible';
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='createTable();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='NursingTimeDtlsForm' id='NursingTimeDtlsForm' >

<input type='hidden' name='isTimeDtlsSurNurAppl' id='isTimeDtlsSurNurAppl' value="<%=isTimeDtlsSurNurAppl%>">

</form>
<div id='test'></div>
</body>
</html>

