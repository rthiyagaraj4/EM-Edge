<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
17/10/2019	  IN071558		sivabagyam	 17/10/2019        Ramesh G       KDAH-SCF-0602
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*, webbeans.eCommon.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCA.CommonCollectionUtils,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_ManageConsOrders" ;
	String bean_name = "eOR.ManageConsultOrders";
	ManageConsultOrders ManageConsOrders = (ManageConsultOrders)getObjectFromBean(bean_id,bean_name,session);	
	ManageConsOrders.setLanguageId(localeName);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
  	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
 	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language='javascript' src='../../eOR/js/ManageConsultOrders.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	String mode = request.getParameter("mode")==null ? "1" : request.getParameter("mode");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String facility_id = (String)session.getValue("facility_id");
	String  sql_or_order_entry_speciality			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY");
	String from = request.getParameter("from")==null?"0":request.getParameter("from");
	String to = request.getParameter("to")==null?"10":request.getParameter("to");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//IN071558
	int start = 0;
	int end = 0;
	//int rowCount = 0;
	int maxRecord = 0;
	int cnt = 0;
	end = Integer.parseInt(to);
	start = Integer.parseInt(from);
	System.out.println("encounter_id ManageConsultOrdersDetail.jsp==>"+encounter_id);
	String error_msg = "";	
	List<String[]> Consultlst = null;	
	if(!encounter_id.equals(""))
	{
		try 
		{		
			//Consultlst = ManageConsOrders.loadConsultOrders(facility_id,encounter_id); //IN071558
			Consultlst = ManageConsOrders.loadConsultOrders(facility_id,encounter_id,patient_id); //IN071558
			maxRecord = Consultlst.size();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	else
	{
		error_msg ="ENCOUNTER_ID_CANNOT_BE_BLANK";
		out.println("<script>alert(getMessage('"+error_msg+"','OR'));</script>");			
		out.println("<script>if(top.content==null)window.close();</script>");
		out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");		
	}
	
	
	%>
<body>
<form name='ManageConsultOrderDtl' id='ManageConsultOrderDtl'>
<table border='0' class="grid" cellpadding='3' cellspacing='0' width="100%" align=''>
		<%
			//String slClassValue="gridData";
			String temp_billing_package_ref = "";
			try
			{ 		
				if(Consultlst != null && Consultlst.size() > 0)
				{
					for(int i = 0; i <Consultlst.size(); i++)
					{
						if(i < Consultlst.size())
						{
							++cnt;				
							String[] record = (String[])Consultlst.get(i);
							String BILLING_PACKAGE_REF = record[0]==null?"":record[0];
							String PACK_START_DATE = record[1]==null?"":record[1];
							String PACK_END_DATE = record[2]==null?"":record[2];
							String ORDER_ID = record[3]==null?"":record[3];
							String CATALOG_CODE = record[4]==null?"":record[4];
							String CATALOG_DESC = record[5]==null?"":record[5];
							String SPECILITY_CODE = record[6]==null?"":record[6];
							String SPECIALITY_DESC = record[7]==null?"":record[7];
							String PRACT_ID = record[8]==null?"":record[8];
							String PRACT_NAME = record[9]==null?"":record[9];
							String LOCATION_CODE = record[10]==null?"":record[10];
							String CLINIC_DESC = record[11]==null?"":record[11];
							String CONSULT_DATE_STR = record[12]==null?"":record[12];
							String ORDER_STATUS_DESC = record[13]==null?"":record[13];
							String CURRENT_STATUS = record[14]==null?"":record[14];
							String row_id = record[17]==null?"":record[17];
							String[] record1 = (String[])ManageConsOrders.getDataMapValues(row_id);
							//String changestatus = (String)record1[18];
							if(!temp_billing_package_ref.equalsIgnoreCase(BILLING_PACKAGE_REF))
							{
								temp_billing_package_ref = BILLING_PACKAGE_REF;
								%>
								<tr><td colspan="10" class="gridData"></td></tr>
								<tr><td colspan="10" class="gridData"></td></tr>
								<tr nowrap>
									<td class="gridData" nowrap><B><fmt:message key="eOR.PackageRef.label" bundle="${or_labels}"/>&nbsp;&nbsp;&nbsp;:</B>
										<b><%=BILLING_PACKAGE_REF%></b></td>
										<td class="gridData" nowrap><B><fmt:message key="eOR.ValidPeriod.label" bundle="${or_labels}"/></B></td>
									<td class="fields" nowrap><%=PACK_START_DATE%> - <%=PACK_END_DATE%></td>
								</tr>							
								<tr>
									<td class="columnheader" nowrap>
										<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
									</td>
									<td class="columnheader" nowrap>
										<fmt:message key="eOR.Description.label" bundle="${or_labels}"/>
									</td>
									<td class="columnheader" nowrap>
										<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
									</td>									
									<td class="columnheader" nowrap>
										<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
									</td>
									<td class="columnheader" nowrap>
										<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
									</td>
									<td class="columnheader" nowrap>
										<fmt:message key="eOR.ConsultDate.label" bundle="${or_labels}"/>
									</td>
									<td class="columnheader" nowrap>
										<fmt:message key="Common.status.label" bundle="${common_labels}"/>
									</td>
								</tr>
								<%
							}
							%>
							<tr>
								<td class="gridData" nowrap>
									<%=ORDER_ID%>
								</td>
								<td class="gridData" nowrap>
									<%=CATALOG_DESC%>
									<input type = "hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value ="<%=CATALOG_CODE%>">
								</td>
								<td class="gridData" nowrap>
									<%
									if(CURRENT_STATUS.equals("P"))
									{
									%>
										<input type="text" name="speciality<%=i%>" id="speciality<%=i%>" value="<%=SPECIALITY_DESC%>" onBlur='callSpecialityDesc(this,"<%=i%>")'><input type="button" class="button" name="sp_search" id="sp_search" value="?" onClick='callSpeciality(speciality<%=i%>,"<%=i%>")'>
									<%
									}
									else
									{
									%>
										<input type="hidden" name="speciality<%=i%>" id="speciality<%=i%>" value="<%=SPECIALITY_DESC%>">
									<%
										out.println(SPECIALITY_DESC);
									}
									%>	
									<input type="hidden" name="speciality_code<%=i%>" id="speciality_code<%=i%>" value='<%=SPECILITY_CODE%>'>
								</td>
								<td class="gridData" nowrap>
									<%
									if(CURRENT_STATUS.equals("P"))
									{
									%>
										<Input name='locn_desc<%=i%>' id='locn_desc<%=i%>' type='text' value='<%=CLINIC_DESC%>' size="15" onBlur="populateLocation(locn_desc<%=i%>,'<%=i%>');" ><input class='button' type=button name=search value='?'  class=button onClick="populateLocation(locn_desc<%=i%>,'<%=i%>')" size='15'>
									<%
									}
									else
									{
									%>
										<Input name='locn_desc<%=i%>' id='locn_desc<%=i%>' type='hidden' value='<%=CLINIC_DESC%>'>
									<%
										out.println(CLINIC_DESC);
									}
									%>
									<input type = "hidden" name="locn<%=i%>" id="locn<%=i%>" value ="<%=LOCATION_CODE%>">
								</td>
								<td class="gridData" nowrap>
									<%
									if(CURRENT_STATUS.equals("P"))
									{
									%>
										<input type='text' name='practitioner_desc<%=i%>' id='practitioner_desc<%=i%>' value='<%=PRACT_NAME%>' size=30 maxlength=40 onKeyPress='return CheckForNotChars(event)' ><input type='button' name='practitioner_button' id='practitioner_button' class='button'   value='?' onClick='show_practtioner_window(document.getElementById("practitioner_desc")<%=i%>,"<%=i%>")'>
									<%
									}
									else
									{
									%>
										<input type='hidden' name='practitioner_desc<%=i%>' id='practitioner_desc<%=i%>' value='<%=PRACT_NAME%>'>
									<%
										out.println(PRACT_NAME);
									}
									%>
									<input type = "hidden" name="practitioner_id<%=i%>" id="practitioner_id<%=i%>" value ="<%=PRACT_ID%>">
									<input type = "hidden" name="locn_practitioner_id<%=i%>" id="locn_practitioner_id<%=i%>" value ="<%=PRACT_ID%>">
								</td>
								
								<td class='fields' nowrap>
								<%
								if(CURRENT_STATUS.equals("P"))
								{
								%>
									<input type='text'  name='Consult_date<%=i%>' id='Consult_date<%=i%>'  value="<%=CONSULT_DATE_STR%>" maxlength="16" size="14" onblur="validateConsultDate(this,'<%=PACK_START_DATE%>','<%=PACK_END_DATE%>','<%=i%>')" onkeyPress='return CheckForNumsAndColon(event);return checkMaxLimit(this,16)'><img src="../../eCommon/images/CommonCalendar.gif"
									onclick="return showCalendar('Consult_date<%=i%>',null,'hh:mm');" style='cursor:pointer'>
								<%
								}
								else
							    {
								%>
									<input type='hidden'  name='Consult_date<%=i%>' id='Consult_date<%=i%>'  value="<%=CONSULT_DATE_STR%>">
								<%
									out.println(CONSULT_DATE_STR);
								}
								%>
								<input type='hidden'  name='temp_Consult_date<%=i%>' id='temp_Consult_date<%=i%>'  value="<%=CONSULT_DATE_STR%>">
								</td>
								<td class="gridData" nowrap>
									<%=ORDER_STATUS_DESC%>
								</td>
							</tr>
							<input type = "hidden" name="row_id<%=i%>" id="row_id<%=i%>" value ="<%=row_id%>">
							<%
							}				
						}
					}
					else
					{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");						
						out.println("<script>if(top.content==null)window.close();</script>");						
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					}				
			}catch(Exception e)
			{
				System.out.println("Exception in ManageConsultOrdersDetail.jsp---"+e.toString());
				e.printStackTrace(System.err);
			}
			
		%>
</table>
<input type="hidden" name="sql_or_order_entry_speciality" id="sql_or_order_entry_speciality" value="<%=sql_or_order_entry_speciality%>">
<input type="hidden" name="prac_sql1" id="prac_sql1" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN")%>"> 
<input type="hidden" name="prac_sql" id="prac_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_ADMIN")%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="from_disp" id="from_disp" value="<%=start%>">
<input type="hidden" name="to_disp" id="to_disp" value="<%=cnt%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="location_sql" id="location_sql" value="<%= OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
<input type="hidden" name="queryString" id="queryString" value="<%=request.getQueryString()%>">
<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
</form>
</body>
</html>

