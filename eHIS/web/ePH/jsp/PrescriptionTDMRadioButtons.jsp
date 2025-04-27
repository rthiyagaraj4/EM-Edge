<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML> 
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PrescriptionTDM.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
 <%

  String bean_id = "@PrescriptionTDMBean" ;
  String bean_name = "ePH.PrescriptionTDMBean";

  PrescriptionTDMBean bean= (PrescriptionTDMBean)getBeanObject( bean_id, bean_name,request) ;
  bean.setLanguageId(locale);

  ArrayList GenericNames = bean.getGenericNames();

  ArrayList FormNames = bean.getFormDesc();
  
  
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");	
		String location_code	= request.getParameter("location_code");	
		String location_type	= request.getParameter("location_type");	
		String pract_id			= request.getParameter("pract_id");			
		String patient_class	= request.getParameter("patient_class");
 %>
<FORM name="formTDMRadioButton" id="formTDMRadioButton">
	<table cellpadding=0 cellspacing=0 width="100%"  border="0">
	<tr>
		<td align="left" class="label"><input type="radio" name="load_table" id="load_table" value="D" 
		onclick= "enable(this);loadresultpage(this)" checked ><fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		<input type="radio" name="load_table" id="load_table" value="P" onclick="enable(this);" ><fmt:message key="ePH.RandomToxicology.label" bundle="${ph_labels}"/> &nbsp;&nbsp;
		</td>
		

		<td  align="left" class = label ID='Gen'   nowrap>
		<fmt:message key="Common.generic.label" bundle="${common_labels}"/> <select name="Generic" id="Generic" width="30"   >
			
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%			if(GenericNames!=null)	{
				for(int i=0;i<GenericNames.size();i++)
				{
					String[] record = ((String[])GenericNames.get(i));					
		%>
					<option value=<%=record[0]%>> <%=record[1]%>
		<%				}
			} %> 

		</select > </td> 
		
		<td align="left"  class = label ID='Form1'  nowrap>
		<fmt:message key="ePH.Form.label" bundle="${ph_labels}"/> <select name="From" id="From" width="15" ><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<%			if(FormNames!=null)	{
				for(int i=0;i<FormNames.size();i++)
				{
					String[] record = ((String[])FormNames.get(i));					
		%>
					<option value=<%=record[0]%>> <%=record[1]%>
		<%				}
			} %> 
		
		</select> </td>

		<td align="left" >
		<input type="button" name="Go" id="Go" value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' class="button"  align="right"  onclick="loadresultpage(document.formTDMRadioButton.load_table)" >
		</td>
		
    </tr>
    <input type="hidden" name="patient_id" id="patient_id"		value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>">
	<input type="hidden" name="location_code" id="location_code"	value="<%=location_code%>">
	<input type="hidden" name="location_type" id="location_type"	value="<%=location_type%>">
	<input type="hidden" name="pract_id" id="pract_id"		value="<%=pract_id%>">
	<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>">
	<input type="hidden" name="flag" id="flag"	value="D">
   

	<script>	
	   parent.f_tdm_radio_button.document.formTDMRadioButton.load_table[1].click();
       loadresultpage(document.formTDMRadioButton.load_table);
   </script>
	</table>  
	
</FORM>
<script>
document.forms[0].Generic.focus();</script>
<% putObjectInBean(bean_id,bean,request); %>


</body>


</HTML>

