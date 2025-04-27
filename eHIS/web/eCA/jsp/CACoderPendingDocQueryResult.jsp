<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  				Ramesh Goli											AAKH-CRF-0122.2
01/07/2020 	  IN073540		Chandrashekar										AAKH-CRF-0122.3
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
<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
    String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String function_id = request.getParameter("function_id")==null?"DQ":request.getParameter("function_id");
	System.err.println();
	String locale				= (String)session.getAttribute("LOCALE");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	System.err.println("Clin_id@@==="+Clin_id);
	StringTokenizer st = null; 
	StringTokenizer pat_details = null; 
	String pat_id="",enc_id="",pat_name="",age="",gen_details="",patientId="",encounter_id="",patient_class="",remarks="";
	String patChartCalledFrm="";
	int count=0;
	if(function_id.equals("SQ"))
	patChartCalledFrm ="CODER_FUNCTION";


	ArrayList result =bean.getPendingQueryResult(patient_id,from_date,to_date,function_id,locale,Clin_id);
	System.err.println("result@@@==="+result);
	if( result.size()>0 ){
			//out.println("<form name='pendingQueryResult' id='pendingQueryResult'  action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame' >");
%>
    <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
     <form name='pendingQueryResult' id='pendingQueryResult' action='../../servlet/eCA.CACoderFunctionServlet' method="post" target="messageFrame">
  
			<table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >

			<tr>
			            <th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
						<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></th>
					    <th width ="20%" class='COLUMNHEADER'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
						<th width ="30%" class='COLUMNHEADER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
						<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
						<th width ="5%" class='COLUMNHEADER'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>   
			</tr>
<%
                     for(int recCount=0; recCount<result.size(); recCount+=8){
				         
				        
						   patientId= (String)result.get(recCount+4);
						   encounter_id = (String)result.get(recCount+5);
						   remarks =(String)result.get(recCount+3);
						   patient_class =(String)result.get(recCount+6);
						System.err.println("patientId======"+patientId+"encounter_id=="+encounter_id);
%>  
               <tr>
                        <td class="gridData" name="dis_pract_id_<%=count%>" nowrap><%=(String)result.get(recCount)%></td>
						<td class="gridData" name="dis_date_<%=count%>" nowrap><%=(String)result.get(recCount+1)%></td>
						<td class="gridData" name="pat_name_<%=count%>" nowrap ><a href="javascript:callpatientchart('<%=patChartCalledFrm%>','<%=patientId%>','<%=encounter_id%>','<%=patient_class%>');"><%=(String)result.get(recCount+7)%></a></td>
						<td class="gridData" name="pat_details_<%=count%>" nowrap ><%=(String)result.get(recCount+2)%>&nbsp;</td>
						<td class="gridData" name="remarks_<%=count%>" nowrap ><a href="javascript:showRemarks('<%=patientId%>','<%=encounter_id%>');"><%=(String)result.get(recCount+3)%></a></td>
						<td class='gridData' ><input type=checkbox  name='select_<%=count%>' id='select_<%=count%>' value='' onClick="chkSelect('<%=count%>')" ></td>

						<input type="hidden" name="patient_id_<%=count%>" id="patient_id_<%=count%>" value=<%=patientId%>>		
						<input type="hidden" name="encounter_id_<%=count%>" id="encounter_id_<%=count%>"  value=<%=encounter_id%>>
              </tr>

								
<%
				 count++;      
			}
%>
				<script>

				parent.queryDocsButtons.location.href="../../eCA/jsp/CACoderPendingDocQueryButtons.jsp?";

			   </script>
			
<%			
	 }else{
%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<% 
						}
%>			
           
            
 </table>
            <input type='hidden' name='patient_id' id='patient_id' value=''>	
			<input type='hidden' name='encounter_id' id='encounter_id' value=''>
			<input type='hidden' name='patient_class' id='patient_class' value=''/>
			<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='<%=patChartCalledFrm%>'>
			<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
			<input type='hidden' name='called_from' id='called_from' value="PENDING_QUERY">
			<input type='hidden' name='row_count' id='row_count' value='<%=count-1%>'>	
 </form>
 <%
putObjectInBean(bean_id,bean,request); 
%>
</body>
 </html>


