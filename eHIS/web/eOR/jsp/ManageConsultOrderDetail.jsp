<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*, webbeans.eCommon.*,eCA.CommonCollectionUtils,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
	ManageConsultOrders ConsultOrdersBean = (ManageConsultOrders)getObjectFromBean(bean_id,bean_name,session);	
	ConsultOrdersBean.setLanguageId(localeName);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language='javascript' src='../../eOR/js/OROrderEntryRepGrp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	//String sql="";
	//String ordertypes="";
	//String ordertypecode="";
	//String order_category=request.getParameter("order_category")==null?"RX":request.getParameter("order_category");
	//String cust_rep_grp_code=request.getParameter("cust_rep_grp_code")==null?"1":request.getParameter("cust_rep_grp_code");
	//String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
	String from	 = ConsultOrdersBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = ConsultOrdersBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String facility_id = (String)session.getValue("facility_id");
	//int rowCount = 0;
	//int maxRecord = 0;
	String error_msg = "";	
	end = Integer.parseInt(to);
	start = Integer.parseInt(from);	
	//CommonCollectionUtils<String, String> orderTypeMap = null;
	List<String[]> Consultlst = null;	
	try 
	{		
		Consultlst = ConsultOrdersBean.loadConsultOrders(facility_id,encounter_id,""); 

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	%>
<body>
<form name='OROrderentryreportgrp1' id='OROrderentryreportgrp1'>
<table cellpadding='0' cellspacing='0' border='0' width='50%' align='center'>
	<tr>
	 <td class='white' width='100%'></td> 
	<td class='label' width='16%' align='right' nowrap>
		</td>
	</tr>
</table>	
<table border='0' class="grid" cellpadding='3' cellspacing='0' width="50%" align='center'>
	<tr>
		<td class='COLUMNHEADER'  width="30%" height="20" nowrap>
			<fmt:message key="eOR.ApplicableOrderType.label" bundle="${or_labels}"/>
		</td>
		<td class='COLUMNHEADER'>
			<fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> 
		</td>
	</tr>	
		<%
			//String slClassValue="gridData";
			String temp_billing_package_ref = "";
			try{ 		
					if(Consultlst != null && Consultlst.size() > 0)
					{
						for( int k=0 ; k< Consultlst.size() ; k++ ) 
						{
							String[] record = (String[])Consultlst.get(k);
							String BILLING_PACKAGE_REF = record[0]==null?"":record[0];
							//String PACK_START_DATE = record[1]==null?"":record[1];
							//String PACK_END_DATE = record[2]==null?"":record[2];
							String ORDER_ID = record[3]==null?"":record[3];
							String CATATLOG_CODE = record[4]==null?"":record[4];
							String CATALOG_DESC = record[5]==null?"":record[5];
							String SPECILITY_CODE = record[6]==null?"":record[6];
							String SPECIALITY_DESC = record[7]==null?"":record[7];
							String PRACITIONER_ID = record[8]==null?"":record[8];
							String PRACT_NAME = record[9]==null?"":record[9];
							String LOCATION_CODE = record[10]==null?"":record[10];
							String CLINIC_DESC = record[11]==null?"":record[11];
							String CONSULT_DATE_STR = record[12]==null?"":record[12];
							//String ORDER_STATUS_DESC = record[13]==null?"":record[13];
							String CURRENT_STATUS = record[14]==null?"":record[14];
							if(!temp_billing_package_ref.equalsIgnoreCase(BILLING_PACKAGE_REF))
							{
								temp_billing_package_ref = BILLING_PACKAGE_REF;
								%>
								<tr>
									<td class="gridHeader">Package Ref</td>
										<td><%=BILLING_PACKAGE_REF%></td>
										<td class="gridHeader">Valid Period</td>
									<td></td>
								</tr>							
								<tr>
									<td class="gridHeader">
										Order ID
									</td>
									<td class="gridHeader">
										Description
									</td>
									<td class="gridHeader">
										Speciality
									</td>
									<td class="gridHeader">
										Practitioner
									</td>
									<td class="gridHeader">
										Location
									</td>
									<td class="gridHeader">
										Consult Date
									</td>
									<td class="gridHeader">
										Status
									</td>
								</tr>
								<%
							}
							%>
							<tr>
								<td class="gridData">
									<%=ORDER_ID%>
								</td>
								<td class="gridData">
									<%=CATALOG_DESC%>
									<input type = "hidden" name="catalog_code<%=k%>" id="catalog_code<%=k%>" value ="<%=CATATLOG_CODE%>">
								</td>
								<td class="gridData">
									<%=SPECIALITY_DESC%>
									<input type = "hidden" name="SPECILITY_CODE<%=k%>" id="SPECILITY_CODE<%=k%>" value ="<%=SPECILITY_CODE%>">
								</td>
								<td class="gridData">								
									<%=PRACT_NAME%>
									<input type = "hidden" name="PRACITIONER_ID<%=k%>" id="PRACITIONER_ID<%=k%>" value ="<%=PRACITIONER_ID%>">
								</td>
								<td class="gridData">
									<%=CLINIC_DESC%>									
									<input type = "hidden" name="LOCATION_CODE<%=k%>" id="LOCATION_CODE<%=k%>" value ="<%=LOCATION_CODE%>">
								</td>
								<td class="gridData">
									<%=CONSULT_DATE_STR%>
								</td>
								<td class="gridData">
									<%=CURRENT_STATUS%>
								</td>
							</tr>
							<%
						}							
					}
					else
					{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");						
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					}
					
			}catch(Exception e)
			{
				System.out.println("Exception in OROrderEntryRepGrpDetail.jsp---"+e.toString());
				e.printStackTrace(System.err);
			}
			
		%>
</table>
<!-- Next, Prev --> 
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 
</form>
</body>
</html>

	


	




