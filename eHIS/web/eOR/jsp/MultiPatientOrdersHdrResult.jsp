<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*

-------------------------------------------------------------------------------------------------------
Date       		Edit History   Name       Description
-------------------------------------------------------------------------------------------------------
?             	100         ?          	created
31/05/2023		44884		Krishna		MO-CRF-20183
-------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title>MultiPatientOrdersHdrResult</title>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/MultiPatientOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

 <%
 	
	String MultiPatientDate;
	String mode	   = request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = request.getParameter("bean_id") ;
	String bean_name = request.getParameter("bean_name");
	
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	
	String source_type		= request.getParameter("location_type");
	String source_code		= request.getParameter("locn");
	String locn_type		= request.getParameter("location_type");
	String locn_code		= request.getParameter("locn");
	String patientId		    = 	request.getParameter("patientId");
	String relationship_id		=	request.getParameter("relationship_id");
	String speciality_code		=	request.getParameter("speciality_code");
	String include_checkout_patients		=	request.getParameter("include_checkout_patients");

	

	if(mode == null || mode.equals("null")) mode =" "; else mode = mode.trim();
	if(function_id == null || function_id.equals("null")) function_id =" "; else function_id = function_id.trim();
	if(bean_id == null || bean_id.equals("null")) bean_id =" "; else bean_id = bean_id.trim();
	if(bean_name == null || bean_name.equals("null")) bean_name =" "; else bean_name = bean_name.trim();

	if(source_type == null || source_type.equals("null")) source_type =""; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =""; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(speciality_code == null || speciality_code.equals("null")) speciality_code =" "; else speciality_code = speciality_code.trim();
	if(relationship_id == null || relationship_id.equals("null")) relationship_id =" "; else relationship_id = relationship_id.trim();
	if(include_checkout_patients == null || include_checkout_patients.equals("null")) include_checkout_patients ="N"; else include_checkout_patients = include_checkout_patients.trim();


	//MultiPatientOrdersBean bean = (MultiPatientOrdersBean)mh.getBeanObject( bean_id, request , bean_name) ;
	MultiPatientOrdersBean bean = (MultiPatientOrdersBean)getBeanObject( bean_id, bean_name, request ) ;

	String slClassValue = "";
	//String classValue = "";
	//String chkvalue = "";
	 
	
	//int total = 0;
	bean.setLanguageId(localeName);

	ArrayList ResultData = new ArrayList();
	//ResultData = bean.getResultData(facility_id,source_type,source_code,patientId);
	//44884 Start.
	//ResultData = bean.getResultData(facility_id,source_code,source_type,patientId,speciality_code,include_checkout_patients);
	ResultData = bean.getResultData(facility_id,source_code,source_type,patientId,speciality_code,include_checkout_patients,practitioner_id);
	//44884 Ends.
 	if(ResultData.size() == 0)
	{
		//out.println("<script>alert('zero');</script>");
		{%><script>
		parent.frameMultiPatientOrdersHdrDtl.document.location.href="../../eCommon/html/blank.html"
		parent.frameMultiPatientOrdersTool.document.location.href="../../eCommon/html/blank.html"
		</script><%}					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html' </script>");
	}
	

 
 %>

 <form name='formMultiPatientOrdersHdrResult' id='formMultiPatientOrdersHdrResult' target='' action="../../eOR/jsp/MultiPatientOrdersFrameSet.jsp" method='POST'>
<table cellpadding=3 cellspacing=0 border=1 width="100%" class="grid">
		<%
		for( int i=0 ; i< ResultData.size() ; i++ ) 
		{
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				String slClassValueTmp = slClassValue;
				String[] record = (String[])ResultData.get(i);
 
%>

	 <tr> 
		<td  width='9%' class='<%=slClassValue%>'><input type="checkbox" name="chk<%=i%>" id="chk<%=i%>" value="Y"  <%if("S".equals(record[12]) || "F".equals(record[12]) ){%> disabled <%}%>></td>       <!--  disabled added against 44884 -->                        
				 <%
					slClassValue = slClassValueTmp;
				%> 
				<!--  data of Patient details -->
				<% 
					//System.out.println("==="+record[1]);

			if (record[1].indexOf(" ")!=-1)
			{

				StringTokenizer fieldTokenizer = new StringTokenizer(record[1]," ");
				record[1]="";
		
				while (fieldTokenizer.hasMoreTokens()) 
				{
					String tempToken = fieldTokenizer.nextToken();
		 
					if ((tempToken.indexOf('/'))==1)
					{
					  String tempstr=tempToken.substring(1);
					  if (tempToken.charAt(0)=='M')
						  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
					  else if(tempToken.charAt(0)=='F')
						  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
					}
					record[1]=record[1].concat(tempToken).concat(" ");
			  
				}
			}
		
		%>

				 <td width='53%' class='<%=slClassValue%>'><font size=1><%=record[1]%><%=record[2]%>
				

				 <input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=record[2]%>" > 
				 <input type="hidden" name="encounter_id<%=i%>" id="encounter_id<%=i%>" value="<%=record[3]%>" >	 
				<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=record[6]%>" >	
				<input type="hidden" name="age<%=i%>" id="age<%=i%>" value="<%=record[7]%>" >	 
				<input type="hidden" name="sex_details<%=i%>" id="sex_details<%=i%>" value="<%=record[8]%>" >	 
				<input type="hidden" name="date_of_birth<%=i%>" id="date_of_birth<%=i%>" value="<%=record[9]%>" >	 
				<input type="hidden" name="Visit_adm_dt<%=i%>" id="Visit_adm_dt<%=i%>" value="<%=record[4]%>" >	 
				<input type="hidden" name="relationship_id<%=i%>" id="relationship_id<%=i%>" value="<%=relationship_id%>" >	  
				<input type="hidden" name="episode_id<%=i%>" id="episode_id<%=i%>" value="<%=record[10]%>" >	  
				<input type="hidden" name="episode_visit_num<%=i%>" id="episode_visit_num<%=i%>" value="<%=record[11]%>" >	 	 
				<input type="hidden" name="practitionerRel<%=i%>" id="practitionerRel<%=i%>" value="<%=record[12]%>" > 	<!--  44884 --->



				<A class="gridLink" HREF="javascript:PassedOrders('<%=record[2]%>','<%=record[3]%>',
'<%=source_type%>','<%=source_code%>','<%=record[6]%>','<%=record[7]%>','<%=record[8]%>','<%=record[9]%>','<%=record[4]%>','<%=relationship_id%>')"><fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></A>

</td> 
<%
	if ( !localeName.equals("en") )
{ 
		MultiPatientDate 	=com.ehis.util.DateUtils.convertDate(record[4],"DMYHM","en",localeName);
}
else
{
	   MultiPatientDate=record[4];
}
%>
				<!--  data of Visit_adm_dt -->
				 <td width='18%' class='<%=slClassValue%>'><font size=1><%=MultiPatientDate%></td> 

				<!--  data of Practioner name -->
 				<td width='18%' class='<%=slClassValue%>'><font size=1><%=record[5]%></td>  

 </tr> 
	 <%}%>
</table> 

 <input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="recCount" id="recCount" value="<%=ResultData.size()%>" > 

 <input type="hidden" name="source_type" id="source_type" value="<%=source_type%>" >	
<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>" >	
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>" >
<input type="hidden" name="locn_type" id="locn_type" value="<%=locn_type%>" >
<input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>" >
<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>" >
<input type="hidden" name="include_checkout_patients" id="include_checkout_patients" value="<%=include_checkout_patients%>" >


</form>
</body>
</html>


<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>

