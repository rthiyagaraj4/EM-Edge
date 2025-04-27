<!DOCTYPE html>
<%
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN061892			Prakash C			31/10/2017		Ramesh G		ML-MMOH-CRF-0544
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 /* Mandatory checks start */
		String bean_id = "Or_SpecimenOrder" ;
		String bean_name = "eOR.SpecimenOrder";
	/* Mandatory checks end */
		SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name , request ) ;
		bean.setLanguageId(localeName);
		String mode	   = "1";
		request.setCharacterEncoding("UTF-8");
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/SpecimenNotRegistered.js.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> 
</head>

<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="specimen_not_registered" id="specimen_not_registered" method="post" target="messageFrame"> 
	<%
			String temp_ord_cat="";
			int rowCount=0;
			int maxRecordsDisp=10;
			int	startIndex =	0,	endIndex =	0;
			
			String	lower_limit				=	"";	
			String	upper_limit				=	"";
			lower_limit		=	(request.getParameter("lower_limit")==null)	?	"0"					:	request.getParameter("lower_limit");
			upper_limit		=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
			startIndex		=	Integer.parseInt(lower_limit);
			endIndex		=	Integer.parseInt(upper_limit);
			
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String time_alert=request.getParameter("time_alert")==null?"":request.getParameter("time_alert");
			String priority =request.getParameter("priority")==null?"":request.getParameter("priority");
			String specimen =request.getParameter("specimen_no")==null?"":request.getParameter("specimen_no");
			String status =request.getParameter("status")==null?"":request.getParameter("status");
			String practitioner_type =request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
			String practitioner_id=request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");

			ArrayList searchData=new ArrayList();
			searchData=(ArrayList)bean.getSpecimenNotRegisteredDetails(patient_id,order_id,time_alert,priority,specimen,practitioner_type,status,practitioner_id);	
			int totalRecordCount=searchData.size();
			
		if(totalRecordCount!=0){
	%>
			<table cellpadding='3'  class='grid' cellspacing=0 border='1' width="100%" height="" id="tableresult" >
				<tr> 
				<td class="columnheader" width='52%' style="text-align:center">
						<fmt:message key="eOR.PatientOrderDetail.label" bundle="${or_labels}"/>
					
					<td class="columnheader" width='12%' style="text-align:center">
						<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='12%' style="text-align:center">
						<fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='12%' style="text-align:center">
						<fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/>
					</td>
							<td class="columnheader" width='12%' style="text-align:center">
						<fmt:message key="eOR.SpeciDateTime.label" bundle="${common_labels}"/>
					</td>
				</tr>
	
			<%
			if( totalRecordCount>maxRecordsDisp){	
			%>
				
					<tr><td  colspan='6'  align='right' >

				<%
				if(startIndex>=maxRecordsDisp){  
				%>	
					<a class='gridLink'  href="../../eOR/jsp/SpecimenNotRegisteredSearchResult.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&patientId=<%=patient_id%>&order_id=<%=order_id%>&time_alert=<%=time_alert%>&priority=<%=priority%>&specimen_no=<%=specimen%>&status=<%=status%>&practitioner_type=<%=practitioner_type%>&practitioner_id=<%=practitioner_id%>"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;	
				<%
				}
				if(totalRecordCount>endIndex)
				{
				%>
					<a class='gridLink'  href="../../eOR/jsp/SpecimenNotRegisteredSearchResult.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&patientId=<%=patient_id%>&order_id=<%=order_id%>&time_alert=<%=time_alert%>&priority=<%=priority%>&specimen_no=<%=specimen%>&status=<%=status%>&practitioner_type=<%=practitioner_type%>&practitioner_id=<%=practitioner_id%>"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>			
				<%
				}
				%>
				</td></tr>
				<%
				}else{%>
				<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td></tr>
				
		<%}%>
		
		<%
		for(int i=startIndex;i<searchData.size();i++){
			ArrayList specimen_result=(ArrayList)searchData.get(i);
		
			String patient_details=specimen_result.get(4)+","+specimen_result.get(5)+"/"+specimen_result.get(6)+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+specimen_result.get(7)+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+specimen_result.get(8)+","+specimen_result.get(9)+",";

			String	start_date_time = (String)specimen_result.get(2);
			String	speci_date_time = (String)specimen_result.get(3);
			if ( !localeName.equals("en") )
			{		
				start_date_time = com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName);				
				speci_date_time = com.ehis.util.DateUtils.convertDate(speci_date_time,"DMYHM","en",localeName); 
			}
			String 	loc_dlts=((String)specimen_result.get(9));

			if(!(temp_ord_cat.equals(loc_dlts)))
				{
					temp_ord_cat = loc_dlts;
		%>
				<tr>
					<td class='columnheader' colspan='6' > <font size=1><%=loc_dlts%></font></td>
				</tr>
		<%
				}
				String catalogNames="";
				catalogNames=(String)specimen_result.get(1);
				if((catalogNames).indexOf("!~!")!=-1)
				{
					catalogNames = (catalogNames).replace("!~!",",");
				}
				out.println("<tr><td class='gridData' width='52%'><font size=1>"+ patient_details+"</td>");
				out.println("<td class='gridData' width='12%'><font size=1>"+ specimen_result.get(0)+"</td>");
				out.println("<td class='gridData' width='12%'><font size=1>"+ catalogNames +"</td>");
				out.println("<td class='gridData' width='12%'><font size=1>"+ start_date_time +"</td>");
				out.println("<td class='gridData' width='12%'><font size=1>"+ speci_date_time +"</td></tr>");
				rowCount++;
						
				if(rowCount>=maxRecordsDisp)   
					break;
			
			}
		}
		else
		{%>
			<Script language=javascript>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%	
		}
	%>
		</table>
	</form>
</body>
</html>

