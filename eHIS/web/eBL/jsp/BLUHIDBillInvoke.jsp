<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
12-03-2019     100           	Gayathri       AMRI-CRF-0357.1  
---------------------------------------------------------------------------------------------------------------
-->

<%@page  import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<HTML>


<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript"src="../../eXH/js/ExternalApplication.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%


 String module_id="MP";//request.getParameter("module_id");
String function_id=request.getParameter("function_id");
String function_type=request.getParameter("function_type");
String func_act=request.getParameter("func_act");
String patient_id=request.getParameter("patient_id");
String str_pat_ser_code=request.getParameter("str_pat_ser_code");
String calledfrmUHID="Y";

%>

<script>



	$(document).ready(function () {
		validate();
	});
	

 	function validate()
	{

		var patient_id='<%=patient_id%>';
 		var function_id='<%=function_id%>';
 		var function_type='<%=function_type%>';
 		var func_act='<%=func_act%>';
 		var module_id='<%=module_id%>';
		var pat_ser_code='<%=str_pat_ser_code%>';
		var calledfrmUHID1='<%=calledfrmUHID%>';
 	
 		$.ajax({		
 			type:"POST",
 			url:"../../servlet/eBL.BLUHIDBillInvokeServlet?patient_id="+patient_id+"&str_pat_ser_code="+pat_ser_code+"&episode_type=R"+"&module_id="+module_id+"&function_id="+function_id,
 			success: function(data){
 				
 				
 				var retVal = trimString(data).split("::");
 				var errorFlag=retVal[0];

 				
 				if(errorFlag=='N'){
 				var str_bill_gen_later=retVal[1];
 				var bill_gen_later=retVal[2];
 				var str_blng_grp=retVal[3];
 				var called_frm=retVal[4];
 				var bill_doc_type=retVal[7];
 				var bill_doc_number=retVal[8];
 				var retValue = "";
 				var dialogHeight = "40";
 				var dialogWidth = "70";
 				var dialogTop = "100";
 				var center = "1";
 				var status = "no";
 				var column_sizes = escape("");
 				var column_descriptions = "";
 				var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
 				var arguments = "";
				var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=" + bill_doc_type + "&bill_doc_num=" + bill_doc_number + "&blng_grp=" + str_blng_grp + "&module_id="+module_id+"&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions+"&patient_id="+patient_id+"&call_disc_function_yn="+str_bill_gen_later+"&episode_type=R"+"&called_frmUHID=Y";
 				retValue = window.showModalDialog(url, arguments, features);
 				while(retValue==undefined){
 		retValue = window.showModalDialog(url, arguments, features);
 				}


 				}

 		else 
 		{

 		var error_txt=retVal[2];
 		var msg_id=retVal[1];

 		if(msg_id!='' && msg_id !='null')
 			
 			{
 				alert(getMessage(msg_id,"BL"));
 			
 			}

 		else if (error_txt !='' && error_txt !='null'){
 			
 			alert(error_txt);
 		}
 		}

 			},
 			error: function(data){	
 		    }
 		});




	} 
</script>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
</BODY>
</HTML>

