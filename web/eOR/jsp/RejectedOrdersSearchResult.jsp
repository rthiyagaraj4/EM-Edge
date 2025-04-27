<!DOCTYPE html>
<%
/*
	
	----------------------------------------------------------------------------------------------------------------
	 Date       Edit History   	Name       			Rev.Date   	Rev.By    				Description
	----------------------------------------------------------------------------------------------------------------
	10/01/2018  IN061893		Kamalakannan G  	10/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	19/01/2018  IN066361		Kamalakannan G  	17/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	-----------------------------------------------------------------------------------------------------------------
	
*/%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
	int chkcnt = 0;
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id = "Or_RejectOrders" ;
	String bean_name = "eOR.RejectOrder";
	RejectOrder bean = (RejectOrder)getBeanObject( bean_id, bean_name , request ) ;
	bean.setLanguageId(localeName);
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript"
	src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eOR/js/RejectedOrders.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/jquery.js' language='javascript'></script>
</head>
<body onscroll='processScroll()' onMouseDown="CodeArrest()"
	onKeyDown="lockKey()">
	<form name="rejected_order_result" id="rejected_order_result" action="../../eOR/jsp/RejectedOrdersSearchResult.jsp" method="post">
		<%
			
			int count=0;
			String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
			String to	 = bean.checkForNull(request.getParameter( "to" ),"10") ;
			String limitTo = "10";
			int startIndex	 = Integer.parseInt(from);
			int endIndex		 = Integer.parseInt(to);
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMYHM","en",locale); 
			String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMYHM","en",locale);
			String ordcat = request.getParameter("ordcat")==null?"":request.getParameter("ordcat");
			String practitioner_type = (String)session.getValue("practitioner_type");
			String login_user = (String)session.getValue("login_user");
			String ca_practitioner_id = request.getParameter("ca_practitioner_id")==null?"":request.getParameter("ca_practitioner_id");
			String facility_id = (String)session.getValue("facility_id");
			String currentDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			 HashMap userData = new HashMap();
			userData = (HashMap)session.getAttribute("userData");
			String host = (String) (userData.get("host")==null?"":userData.get("host"));
			String status = bean.checkForNull(request.getParameter("status"),"RJ");
			ArrayList searchData=new ArrayList();
			searchData=bean.getRejectedOrderResult(patient_id,date_from,date_to,ordcat,ca_practitioner_id,practitioner_type,status,startIndex,endIndex);
			String totalRecordCount="0";
			if(searchData.size() == 0)
			{
		%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
					parent.resultframe.location.href = "../../eCommon/html/blank.html";
					parent.rejectOrdersButtonFrame.location.href = "../../eCommon/html/blank.html";
				</script>

		<%	}
		%>
		<table class='grid' cellspacing=0 border='1' width="100%" height=""
			id="tableresult">
			<tr>
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="eOR.PatientOrderDetail.label"
						bundle="${or_labels}" />
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="Common.OrderID.label" bundle="${common_labels}" />
				<%if(ordcat.equals("LB")) {%>	
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="eOR.SpecimenNo.label" bundle="${or_labels}" />
				<%}else {%>	
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="eCA.AccessionNum.label" bundle="${ca_labels}" />
				<%}%>
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="Common.ordercatalog.label"
						bundle="${common_labels}" />
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="eOR.RejectedRemarks.label"
						bundle="${or_labels}" />
				<td class="columnheader" width='' nowrap style="text-align: center">
					<fmt:message key="eOR.RejectedDateTime.label"
						bundle="${or_labels}" />
				<td class=columnheader width='' nowrap id='select_td'><a
					class="gridLink" id='hdr'><font color='white'> <fmt:message
								key="Common.defaultSelect.label" bundle="${common_labels}" /></a> <input type=checkbox name='check_all' id='check_all'
					title='Select/Unselect action will affect records available in current page only'
					onClick='clickAll(this);' ></td><!-- IN66361 tooltip added-->
			</tr>
			<%
		for(int i=0;i<searchData.size();i++){
			ArrayList<String> specimen_result = new ArrayList();
			 specimen_result=(ArrayList<String>)searchData.get(i);
			if(i==0){
					if(specimen_result.size() == 22)
					totalRecordCount = bean.checkForNull((String)specimen_result.get(21),"0");
				%>
				<%
					if((Integer.parseInt(totalRecordCount)>0) || (startIndex>1))
					{
				%>
						<tr  align="right">
							<td colspan="8">
								<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
								<jsp:param name ="from" value= "<%=startIndex%>" /> 
								<jsp:param name ="to" value= "<%=endIndex%>" />	
								<jsp:param name ="total_size" value= "<%=totalRecordCount%>" />   
								<jsp:param name ="check_box_name" value= "select" />					 
								<jsp:param name ="form_name" value= "rejected_order_result" /> 
								<jsp:param name ="limitTo" value= "<%=limitTo%>" />	 
								</jsp:include>
							</td>
						</tr>
				
				    <%
					}
				}
			String patient_details=specimen_result.get(9)+","+specimen_result.get(8)+"/"+specimen_result.get(7)+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+specimen_result.get(2)+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+specimen_result.get(3)+",";
			String OrderLineNumber =  specimen_result.get(18);
			String	reject_date_time = specimen_result.get(13);
			String Order_practitioner_id = specimen_result.get(17);
			String attending_practitioner_id = specimen_result.get(16);
				 if ( !localeName.equals("en") )
				{		
					 reject_date_time = com.ehis.util.DateUtils.convertDate(specimen_result.get(13),"DMYHM","en",localeName);				
				} 
					out.println("<tr> <td class='gridData' name='patient_det"+count+ "' width='' wrap><font size=1>"+ patient_details+"</td>");//pat_details
					out.println("<td class='gridData' id='order_id"+count+ "' width='' nowrap><font size=1>"+ specimen_result.get(1)+"</td>");//order_id
					out.println("<td class='gridData' name='spec_no"+count+ "' width='' nowrap><font size=1>"+ specimen_result.get(5) +"</td>");//accession_number
					out.println("<td class='gridData' name='order_cat"+count+ "' width='' wrap><font size=1>"+specimen_result.get(4) +"</td>");//catalog_desc
					out.println("<td id='remarks"+count+"' name='remarks"+count+ "' class='gridData' width='' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' name='search"+count+"' id='search"+count+"' value='?' onclick='Remarks("+count+")'></td>");//remarks
					out.println("<td class='gridData' name='rej_date_time"+count+ "' width='' nowrap><font size=1>"+reject_date_time+"</td>");//rej date/time

					if(Order_practitioner_id.equals(ca_practitioner_id)||attending_practitioner_id.equals(ca_practitioner_id))
					{
						chkcnt++;
						out.println("<td width='' nowrap class='gridData'><font size=1><input type='checkbox' name='select"+count+"' id='select"+count+"' value='N' onClick='clickLine(this,"+count+")'></font></td></tr>");
					
					}
				 	else
					out.println("<td width='' nowrap class='gridData'><font size=1><input type='hidden' name='select"+count+"' id='select"+count+"' value='N'></font></td></tr>");	
					
					out.println("<input type='hidden' name='remarks"+count+ "' id='remarks"+count+ "' value='"+specimen_result.get(12)+"'>"); // remarks
					out.println("<input type='hidden' name='order_id"+count+ "' id='order_id"+count+ "' value='"+specimen_result.get(1)+"'>");//orderid
					out.println("<input type='hidden' name='rej_pract_name"+count+ "' id='rej_pract_name"+count+ "' value='"+specimen_result.get(14)+"'>");//reject_id
					out.println("<input type='hidden' name='reject_date_time"+count+ "' id='reject_date_time"+count+ "' value='"+reject_date_time+"'>");//reject_date_time
					out.println("<input type='hidden' name='OrderLineNumber"+count+ "' id='OrderLineNumber"+count+ "' value='"+OrderLineNumber+"'>");//OrderLineNumber
					count++;
				}
	%>
			<input type='hidden' name='from' id='from' value='<%=startIndex%>'>
			<input type='hidden' name='to' id='to' value='<%=endIndex%>'>
			<input type='hidden' name='total_recs' id='total_recs' value='<%=count%>'><!-- IN66361 next previous alert-->
			<input type='hidden' name='login_user' id='login_user' value='<%=login_user%>'>
			<input type='hidden' name='host' id='host' value='<%=host%>'>
			<input type='hidden' name='curr_sys_date' id='curr_sys_date' value='<%=currentDate%>'>
			<input type='hidden' name='date_from' id='date_from' value='<%=date_from%>'>
			<input type='hidden' name='date_to' id='date_to' value='<%=date_to%>'>
			<input type='hidden' name='mode' id='mode' value='1'>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			<input type='hidden' name='count' id='count' value='<%=count%>'>
			<input type="hidden" name="ordcat" id="ordcat" value="<%=ordcat%>">
			<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=ca_practitioner_id%>">
		</table>
	</form>
	<script type="text/javascript">
	if (parseInt('<%=chkcnt%>') == 0)
	document.getElementById("check_all").disabled = true;
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</body>
</html>

