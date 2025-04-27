<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  		        Ramesh Goli											AAKH-CRF-0122.2
01/07/2020 	  IN073540		Chandrashekar											AAKH-CRF-0122.3
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
<script language='javascript' src='../../eCA/js/CACodersReview.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCA/js/SplChartRef.js' language='javascript'></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params = request.getQueryString() ;
	String locale				= (String)session.getAttribute("LOCALE");
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
    String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String dtFrom = request.getParameter("dtFrom")==null?"":request.getParameter("dtFrom");
	String dtTo = request.getParameter("dtTo")==null?"":request.getParameter("dtTo");
	
	//Newly Added fields from Search Criteria Page
	String encounterCode = request.getParameter("encounterCode")==null?"":request.getParameter("encounterCode");
	String clinicCode = request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
	String splCode = request.getParameter("splCode")==null?"":request.getParameter("splCode");
	String etFrom = request.getParameter("etFrom")==null?"":request.getParameter("etFrom");
	String etTo = request.getParameter("etTo")==null?"":request.getParameter("etTo");
	String attendingPractCode = request.getParameter("attendingPractCode")==null?"":request.getParameter("attendingPractCode");
	String episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
	String encodingstatusCode = request.getParameter("encodingstatusCode")==null?"":request.getParameter("encodingstatusCode");
	
	
	String billingGroupCode = request.getParameter("billingGroupCode")==null?"":request.getParameter("billingGroupCode");
	String customergroupCode = request.getParameter("customergroupCode")==null?"":request.getParameter("customergroupCode");
	String customerCode = request.getParameter("customerCode")==null?"":request.getParameter("customerCode");
	String policycode = request.getParameter("policycode")==null?"":request.getParameter("policycode");
	String dtEmpty = request.getParameter("dtEmpty")==null?"":request.getParameter("dtEmpty");
	String etEmpty = request.getParameter("etEmpty")==null?"":request.getParameter("etEmpty");
	
	String Clin_id=(String)session.getValue("ca_practitioner_id");
System.out.println("---->"+patient_id+"<-------");
	ArrayList result =bean.getCoderReviwResult(patient_id,dtFrom,dtTo,Clin_id,encounterCode,clinicCode,splCode,attendingPractCode,episode_type,encodingstatusCode,etFrom,etTo,billingGroupCode,customergroupCode,customerCode,policycode,dtEmpty,etEmpty);
	
	String patient_details ="";
	String payer_details ="";
	String visit_status ="";
	String remarks ="";
	String patientId ="";
	String encounter_id ="";
	String patient_class ="";
	String enc_id   ="";
	String mode ="";
	String status ="";
	String assign_coder_id="";
	String assign_coder_desc="";
	int count =0;
	String classvalue="";
	

 		if( result.size()>0 ){

			               
%>
                     <form name='CoderReviewResult' id='CoderReviewResult'  action='../../servlet/eCA.CACoderFunctionServlet' method = 'post' target='messageFrame' >
		  <div id='coder_assign' >
			 <table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >
					  <tr>
                         
						<td   class='label' ><fmt:message key="eCA.Sno.label" bundle="${ca_labels}"/></td>
						<td  class='fields'><input type='text' name='from_srl_no' id='from_srl_no' value='' size='12' maxlength='3'  OnKeyPress='return allowNumber();' >
						<fmt:message key="Common.to.label" bundle="${common_labels}"/>
						<input type='text' name='to_srl_no' id='to_srl_no' value='' size='12' maxlength='3'  OnKeyPress='return allowNumber();' ></td>
						 <td class ='label'><fmt:message key="eCA.Coder.label" bundle="${ca_labels}"/></td>
						<td class ='fields'>
						<input type='text' name='coder_Desc' id='coder_Desc' value='' size='20' maxlength='20'onBlur="getCoders(this)"><input type='hidden'  name='coder_id' id='coder_id' value=''><input type='Button' name='CoderButton' id='CoderButton' class='button' value='?' onClick='getCoders(coder_Desc)'></td>
						<td class ='label' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class=button name='assign' id='assign'
		                value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.assigndiag.label","or_labels")%>" onClick="assignCoder()"></td>
             </tr>
     </table>
	 </div>

         <div id='coder_result' >
					
						<table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >
							<tr >
							    
								<th width ="5%" class='COLUMNHEADER'><fmt:message key="eCA.Sno.label" bundle="${ca_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
								<th width ="20%" class='COLUMNHEADER' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
								<th width ="20%" class='COLUMNHEADER'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
								<th width ="5%" class='COLUMNHEADER'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
								<th width ="20%" class='COLUMNHEADER'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="eCA.Coder.label" bundle="${ca_labels}"/></th>
								<th width ="5%" class='COLUMNHEADER'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
							</tr>
<%
							for(int recCount=0,j=1; recCount<result.size(); recCount+=10){
									patientId =(String)result.get(recCount);
									encounter_id =(String)result.get(recCount+1);
									patient_class =(String)result.get(recCount+2);
									patient_details =(String)result.get(recCount+3);
									payer_details =(String)result.get(recCount+4);
									visit_status =(String)result.get(recCount+5);
									remarks =(String)result.get(recCount+6);
									enc_id =(String)result.get(recCount+7)==null?"":(String)result.get(recCount+7);
									assign_coder_id =(String)result.get(recCount+8)==null?"":(String)result.get(recCount+8);
									assign_coder_desc=(String)result.get(recCount+9)==null?"":(String)result.get(recCount+9);
									
									if(enc_id.equals(""))
										mode ="I";
									else 
										mode ="U";
									
									if ( recCount % 2 == 0 )
										classvalue = "QRYODD" ;
									else
										classvalue = "QRYEVEN" ;
								
%>
								<tr>
								    
									<td class="gridData" name="srl_no_<%=count%>" ><%=j%></td>
									<td class="gridData" name="patient_id_<%=count%>" ><a href="javascript:callCoderFunction('<%=patientId%>','<%=encounter_id%>','<%=patient_class%>');"><%=patientId%></a></td>
									<td class="gridData" name="pat_details_<%=count%>"  ><%=patient_details%></td>
									<td class="gridData" name="payerr_detls_<%=count%>"  ><%=payer_details%>&nbsp;</td>
									<td class="gridData" name="visti_type_<%=count%>"  ><%=visit_status%></td>
									<td class="gridData" name="remarks_<%=count%>"  ><a href="javascript:showRemarks('<%=patientId%>','<%=encounter_id%>');"><%=remarks%></a></td>
									<td class ='fields'>
						             <input type='text' name='rl_coder_Desc_<%=count%>' id='rl_coder_Desc_<%=count%>' value='<%=assign_coder_desc%>' size='20' maxlength='20'onBlur="getCodersByLine(this,'<%=count%>')"><input type='hidden'  name='rl_coder_id_<%=count%>' id='rl_coder_id_<%=count%>' value='<%=assign_coder_id%>'><input type='Button' name='rl_CoderButton' id='rl_CoderButton' class='button' value='?' onClick="getCodersByLine(this,'<%=count%>')"></td>
									<td class='gridData' ><input type=checkbox  name='select_<%=count%>' id='select_<%=count%>' value='' onClick="chkSelect(this,'<%=count%>')" ></td>

									<input type="hidden" name="patient_id_<%=count%>" id="patient_id_<%=count%>" value=<%=patientId%>>		
						            <input type="hidden" name="encounter_id_<%=count%>" id="encounter_id_<%=count%>"  value=<%=encounter_id%>>
									<input type="hidden" name="mode_<%=count%>" id="mode_<%=count%>"  value=<%=mode%>>
									
									<input type="hidden" name="patient_class_<%=count%>" id="patient_class_<%=count%>"  value=<%=patient_class%>>

									
								 </tr>
 <%

									    
									  j++;
									  count++;      
							}
%>
					   <script>

				           parent.coderReviewButtonsFrame.location.href="../../eCA/jsp/CACoderReviewButtons.jsp?to_date=<%=dtTo%>&from_date=<%=dtFrom%>&patient_id=<%=patient_id%>";

			            </script>
<%
						}
						else{
%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<% 
						}
%>				
</table>
</div>
            
			<input type="hidden" name="patient_id" id="patient_id" value="">	
			<input type='hidden' name='encounter_id' id='encounter_id' value=''/>
			<input type='hidden' name='patient_class' id='patient_class' value=''/>
			<input type='hidden' name='speciality_code' id='speciality_code' value=''/>
			<input type='hidden' name='row_count' id='row_count' value='<%=count-1%>'/>
			<input type='hidden' name='called_from' id='called_from' value='CODER_ASSIGN'/>
			<input type='hidden' name ='locale' value ='<%=locale%>'>

			
			
</form>
<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>

