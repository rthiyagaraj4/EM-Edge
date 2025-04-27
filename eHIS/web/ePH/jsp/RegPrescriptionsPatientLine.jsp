<!DOCTYPE html>
 <%@page import="webbeans.eCommon.ConnectionManager,java.sql.Connection"%>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	  
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript"> //script added for Bru-HIMS-CRF-094 [IN:029959 
			function blinkImage(){
				var e;
				try{
					e = document.getElementById("payingPatient");
					if(e.style.display=='inline'){
						e.style.visibility = ( e.style.visibility == 'visible' )? 'hidden' : 'visible';
					}
				}
				catch(e){}
			}
			function blinkPatExp(){
				var e;
				try{
					e = document.getElementById("policy_exp");
					e.style.color = ( e.style.color == 'darkred' )? '#ff0000' : 'darkred';
				}
				catch(e){}
			}
			window.onload = function(){
				window.setInterval("blinkImage()",500);
				window.setInterval("blinkPatExp()",500);
			}

		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		
	<body onMouseDown="" onKeyDown="lockKey()"  topmargin="0">
		<form name="RegPrescriptionsPatientLine" id="RegPrescriptionsPatientLine" >
<%
			String bean_id				= "RegPrescriptionsBean" ;
			String bean_name			= "ePH.RegPrescriptionsBean";
			RegPrescriptionsBean bean	= (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;	
		   // bean.setLanguageId(locale);
			String patient_id			=  request.getParameter("patient_id");
			String disp_locn_code	    =  request.getParameter("disp_locn_code");
			bean.setPatientID(patient_id);
			String name					= request.getParameter("name");
			String age					= request.getParameter("age");
			
			String gender				= request.getParameter("gender");
			String nationality			= request.getParameter("nationality");	
			String called_from			= request.getParameter("called_from")==null?"":request.getParameter("called_from");	
			String function_id = request.getParameter( "function_id" );
			String primary_blng_grp = ""; 	// Added for GHL-CRF-0549 - Devindra - Start						
			Connection con			= null; 
			con = ConnectionManager.getConnection(request);
			boolean item_type_appl = false;
			try{
			  item_type_appl = CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP"); // Added for GHL-CRF-0549 - Devindra
		        }
		        catch(Exception e){
			  e.printStackTrace();
		        }
		        finally{
			  if(con != null)
				  ConnectionManager.returnConnection(con,request);		
		        } // Added for GHL-CRF-0549 - Devindra - End

			if (nationality==null || nationality.equals("null")){		
				nationality	=	"";
			}
			else{
				nationality = " , "+nationality;
			}
			String pndng_ord_count  = bean.getPendngOrderCnt(patient_id);
			String patient_class		= request.getParameter("patientclass");//code added for JD-CRF-0156[IN041737]
			String encounter_id			= request.getParameter("encounterid");//code added for JD-CRF-0156[IN041737]

%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="regprescriptionspatientlinetable">
				 <tr>
					 <td class="COLUMNHEADER" colspan='2'><%=patient_id%>,<b><%=name%></b>,<%=age%>,<%=gender%><%=nationality%><label id='payingPatient' style='font:12;color:red;display:none;'><b>&nbsp;&nbsp;&nbsp;[<fmt:message key="ePH.PayingPatient.label" bundle="${ph_labels}"/>]</b></label></td>	 <!--label  payingPatient added for Bru-HIMS-CRF-094 [IN:029959-->					
				</tr> 
				<tr>
				   <td width="84%">
<%
					if(Integer.parseInt(pndng_ord_count)>0){
%>
						<font style="font-size:13px;cursor:pointer;color:#ff0000;" id="pending_ordrs" onClick="showPendingOrders('<%=patient_id%>','<%=disp_locn_code%>')"><B><fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></b></font>
						<script>
						 XX1=new blinkText("XX1",'pending_ordrs',500,500,'darkred','#ff0000');
						</script>
<%
					}
					else{
%>
						<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showPendingOrders('<%=patient_id%>','<%=disp_locn_code%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></font>
<%
					}
%>
					<font style="font-size:9px;cursor:pointer" class="HYPERLINK" onClick="showDrugProfile('<%=patient_id%>','<%=disp_locn_code%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></font> <!--added for [IN:036157]-->
<%  
				if(bean.toDisplayFinancialDtl(disp_locn_code)){ //code added for JD-CRF-0156[IN041737]--Start
					ArrayList encounterId_details	 = bean.getEpisodeDetails(patient_id); 
					if(encounterId_details.size()>0){
						String 	latest_encounter_id		 = (String)encounterId_details.get(0);					
						String 	latest_episode_id		 = (String)encounterId_details.get(1);					
						String  latest_patient_class	 = (String)encounterId_details.get(2);					
						String visit_id="";
						if(latest_patient_class.equals("OP") &&  encounter_id.length()>4)
							visit_id = encounter_id.substring(encounter_id.length()-4, encounter_id.length());
						primary_blng_grp=bean.getPrimaryBillingGroup(latest_patient_class,latest_encounter_id,patient_id); // Added for GHL-CRF-0549 - Devindra
%>	     
						&nbsp;&nbsp;&nbsp;<img src="../../ePH/images/dollar.png" style="cursor:pointer" height="17" title="Current Encounter Financial Details" onClick="callFinancialDetailScreen('<%=patient_id%>','<%=latest_episode_id%>', '<%=visit_id%>');" >		 
						<% 
						if(item_type_appl){ // Added for GHL-CRF-0549 - Start - Devindra %>
					        <label id="primary_blng_grp" style='color:darkred;'><%=primary_blng_grp%></label> 
				                <%}  // Added for GHL-CRF-0549 - End - Devindra %>		 
<% 
						//if(!bean.getPolicyExp(latest_encounter_id,latest_patient_class,patient_id)){
%>						
							&nbsp;&nbsp<label id="policy_exp" style='visibility:hidden;color:darkred;'> <font style="font-size:9px;" ><fmt:message key="ePH.PolicyExpired.label" bundle="${ph_labels}"/></font> </label>
<%
						//}  
					}
				}//code added for JD-CRF-0156[IN041737]--End
%>  
				</td> 
<%
					if(called_from.equals("")){
%>
						<td class='label'  style="font-size:9px" width="16%"><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='select_all' id='select_all' checked onclick="setvalues(this)"></td>
<%
					}
%>
					<td class='label'></td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_name" id="patient_name" value="<%=name%>">
		</form>
	</body>
</html>

