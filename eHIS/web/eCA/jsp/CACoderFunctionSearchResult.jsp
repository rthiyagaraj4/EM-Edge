<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  		        Ramesh Goli											    AAKH-CRF-0122.2
01/07/2020	IN073540		Chandrashekar											AAKH-CRF-0122.3
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");	
	String params = request.getQueryString() ;
	System.err.println("params@@@===="+params);
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
    String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String status = request.getParameter("status")==null?"":request.getParameter("status");
	String visit_list = request.getParameter("visit_list")==null?"":request.getParameter("visit_list");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String pract_name  ="";
	String classvalue			=	"";
	ArrayList result =bean.getCoderSearchResult(patient_class,patient_id,encounter_id,from_date,to_date,status,visit_list,Clin_id);
	System.err.println("coderRecords@@==="+result);
	String pat_id ="",enc_id="",pat_calss ="";
	

 		if( result.size()>0 ){
			out.println("<form name='CoderSearchResult' id='CoderSearchResult'  action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame' >");

			               
%>
                     
					
						<table id="coder_result" width='auto' class='grid' border="1" cellpadding="0" cellspacing="0" width="100%"  >
							<tr >
							    
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
								<th width ="30%" class='COLUMNHEADER'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
								<th width ="5%" class='COLUMNHEADER'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
								<th width ="30%" class='COLUMNHEADER'><fmt:message key="eCA.DoctorName.label" bundle="${ca_labels}"/></th>
								<th width ="30%" class='COLUMNHEADER'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="eCA.CodingStatus.label" bundle="${ca_labels}"/></th>
							</tr>
<%
							for(int recCount=0; recCount<result.size(); recCount+=10){
									pat_id =(String)result.get(recCount+2);
									enc_id=(String)result.get(recCount+1);
									pat_calss =(String)result.get(recCount+9);
									
									if ( recCount % 2 == 0 )
										classvalue = "QRYODD" ;
									else
										classvalue = "QRYEVEN" ;
								
%>
								<tr>
								    
									<td class="gridData" name="visit_date" nowrap><%=(String)result.get(recCount)%></td>
									<td class="gridData" name="enc_id" nowrap><%=(String)result.get(recCount+1)%></td>
									<td class="gridData" name="pat_id" nowrap ><a href="javascript:callCoderFunction('<%=pat_id%>','<%=enc_id%>','<%=pat_calss%>');"><%=(String)result.get(recCount+2)%></a></td>
									<td class="gridData" name="pat_name" nowrap ><%=(String)result.get(recCount+3)%>&nbsp;</td>
									<td class="gridData" name="gender" nowrap ><%=(String)result.get(recCount+4)%></td>
									<td class="gridData" name="pract_name" nowrap><%=(String)result.get(recCount+5)%></td>
									<td class="gridData" name="blgp_id" nowrap ><%=(String)result.get(recCount+6)%></td>
									<td class="gridData" name="coder_status" nowrap><%=(String)result.get(recCount+7)%></td>

									
								 </tr>
 <%
									    
							}
						}
						else{
%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<% 
						}
%>				
</table>
            
			<input type="hidden" name="patient_id" id="patient_id" value="">	
			<input type='hidden' name='encounter_id' id='encounter_id' value=''/>
			<input type='hidden' name='patient_class' id='patient_class' value=''/>
			<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='CODER_FUNCTION'/>

			
			
</form>
<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>

