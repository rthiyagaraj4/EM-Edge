<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
09/01/13      100         Bmohankumar  created
-----------------------------------------------------------------------------------------------
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>


<HTML>   
 
<HEAD>  
</HEAD>    
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> 
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language="javascript" src="../../eCommon/js/common.js"></script> 
		<script language="javascript" src='../js/ReportCriteriaScript.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		<script>
		function run()  
		{
			

			var formsObj =  parent.frames[2].BillingReportCriteria.BillingReportCriteriaForm.document.forms[0];

			var p_episode_type =formsObj.p_episode_type.value;	 
			var p_fm_date	=formsObj.p_fm_date.value;	 
			var p_to_date =formsObj.p_to_date.value;
			
			var pat_id =   formsObj.patient_id.value;
			
			if(pat_id !='' && pat_id !='undefined')		
			formsObj.p_patient_id.value =   pat_id;
			else
				formsObj.p_patient_id.value =   '';

			formsObj.p_report_id.value =   formsObj.sum_yn.value;
			formsObj.pgm_id.value =   formsObj.sum_yn.value;
			
			
			
			var ep_id = formsObj.episode_id.value;
			
			
			if(p_episode_type == 'O' && ep_id !="")
			{	
			
			var e_id =  ep_id.substring(0,8);

			var v_id =  ep_id.substring(8,ep_id.length);			
				
			formsObj.p_episode_id.value =  e_id;
			formsObj.p_visit_id.value =    v_id;
			
			}
			

			
			if(p_episode_type==undefined || p_episode_type=='')
			{
				alert(getMessage("BL00028","BL"));
				return;
			}
			if(p_fm_date==undefined || p_fm_date=='')
			{
				alert(getMessage("BL00004","BL"));
				return;
			}
			if(p_to_date==undefined || p_to_date=='')
			{
				alert(getMessage("BL8560","BL"));
				return;
			}
			//Spl Char Issue
			var dummyDoc = parent.frames[2].messageFrame.document;
			var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+formsObj.p_patient_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_episode_type' id='p_episode_type' value='"+formsObj.p_episode_type.value+"'>";
				htmlVal += "<input type='hidden' name='p_episode_id' id='p_episode_id' value='"+formsObj.p_episode_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_visit_id' id='p_visit_id' value='"+formsObj.p_visit_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_language_Id' id='p_language_Id' value='"+formsObj.locale.value+"'>";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formsObj.facilityId.value+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formsObj.p_report_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formsObj.p_module_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_policy_type_code' id='p_policy_type_code' value='"+formsObj.p_policy_type_code.value+"'>";
				htmlVal += "<input type='hidden' name='p_payer_grp_code' id='p_payer_grp_code' value='"+formsObj.p_payer_grp_code.value+"'>";
				htmlVal += "<input type='hidden' name='p_cust_code' id='p_cust_code' value='"+formsObj.p_cust_code.value+"'>";
				htmlVal += "<input type='hidden' name='p_fm_date' id='p_fm_date' value='"+formsObj.p_fm_date.value+"'>";
				htmlVal += "<input type='hidden' name='p_to_date' id='p_to_date' value='"+formsObj.p_to_date.value+"'>";
				htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formsObj.pgm_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_physician_id' id='p_physician_id' value='"+formsObj.p_physician.value+"'>";
				htmlVal += "<input type='hidden' name='p_specialty_code' id='p_specialty_code' value='"+formsObj.p_specialty_code.value+"'>";

				htmlVal += "</form></body></html>";

			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.dummy_frm.submit();
			//Spl Char Issue
			//formsObj.submit();
						
		}
		</script>	
		
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;

%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
			 <iframe name='BillingReportCriteria' id='BillingReportCriteria' 	src='BillingReportCriteria.jsp' frameborder=0 scrolling='auto' noresize style='height:87vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe> 

	


</HTML>  

