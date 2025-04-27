<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PendingAppointmentbean"/>  
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	bean.setLanguageId(localeName);
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsignOrders" ;
	String bean_name = "eOR.ConsignOrders";
	//String disabled = "" ;
	/* Mandatory checks end */


//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String frmSum		= request.getParameter("frmSum");

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(frmSum == null || frmSum.equals("null")) frmSum =""; else frmSum = frmSum.trim();
 	Properties properties	= (Properties) session.getValue( "jdbc" );
	String filter		= request.getParameter("filter")==null?"":request.getParameter("filter");
	//ConsignOrders bean = (ConsignOrders)getBeanObject( bean_id, bean_name , request  ) ;
//out.println("source_type"+source_type);

	String slClassValue = "";
	int total = 0;


	ArrayList PriorityData = bean.getStatusByPriority(properties, source_type,source_code,practitioner_id,resp_id,facility_id,patientId, period_from, period_to,filter) ;
	ArrayList CategoryData = bean.getStatusByCategory(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,filter) ;

	//out.println(bean.chk);
	//out.println(CategoryData.size());
	 //target='messageFrame'
%>
<form name='authorise_order_priority' id='authorise_order_priority' action="../../eOR/jsp/PendingAppointmentBottomLeft.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" class="grid">
	<tr>
		<td class=' COLUMNHEADER'><fmt:message key="eOR.StatusByPriority.label" bundle="${or_labels}"/></td>
	</tr>

		<%
			for( int i=0 ; i< PriorityData.size() ; i++ ) {
				String[] record = (String[])PriorityData.get(i);

               int len=record[0].length();
				String subrec=record[0].substring(1,len);
				//String retval=new String();
				

				
				if(record[0].charAt(0)=='R'){
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					
				}
					else if(record[0].charAt(0)=='U')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					

				}
					else if(record[0].charAt(0)=='S')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels").concat(subrec);
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				}
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				total += Integer.parseInt(record[1]);

				
		%>

			<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink' href='PendingAppointmentBottomRight.jsp?priority=<%=record[3]%>&priority_desc=<%=record[2]%>&total_recs=<%=record[1]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&frmSum=<%=frmSum%>' target='CosignOrdersBottomRight'><%=record[0]%></a></font></td></tr>
					

		<%
			}
		%>
		<%if(total !=0){%>
			<tr><td class='cagroup' >
			<a class='gridLink' href='PendingAppointmentBottomRight.jsp?order_by=P&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&frmSum=<%=frmSum%>' target='CosignOrdersBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a>

			</td></tr>
		<%}%>

	<tr>
		<td class='COLUMNHEADER'><fmt:message key="eOR.StatusByCategory.label" bundle="${or_labels}"/></td>
	</tr>
		<%
		
		total = 0;
		for( int i=0 ; i< CategoryData.size() ; i++ ) {
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				String[] record = (String[])CategoryData.get(i);
				total += Integer.parseInt(record[2]);

				//out.println("record"+record[0]);

		%>
			
				
				<tr><td class='<%=slClassValue%>'><font size=1><a class='gridLink'  href='PendingAppointmentBottomRight.jsp?ord_cat=<%=record[1]%>&ord_cat_desc=<%=record[3]%>&total_recs=<%=record[2]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&frmSum=<%=frmSum%>' target='CosignOrdersBottomRight'><%=record[0]%></a></font></td></tr>

		<%
			}
		%>
						<tr><td class='cagroup' ><%if(total !=0){%><a class='gridLink' href='PendingAppointmentBottomRight.jsp?order_by=O&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&frmSum=<%=frmSum%>' target='CosignOrdersBottomRight'><%}%><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a></font></td></tr>
</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

