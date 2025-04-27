<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" 
contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
 	<script language="JavaScript" src="../js/OrderEntryToolTip.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	
	
	String bean_id	 = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
 	
	String patientId		= request.getParameter("patient_id");

	String encounter_id		= request.getParameter( "encounter_id" ) ;
	String facility_id		= request.getParameter( "facility_id" ) ;
	String consent_form_id	= request.getParameter( "consent_form_id" ) ;
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String link_ref_no		= request.getParameter("link_ref_no");
	String link_ref_det		= request.getParameter("link_ref_det")==null?"":request.getParameter("link_ref_det");
	String current_link		= request.getParameter("current_link")==null?"":request.getParameter("current_link");
	String curr_date		= request.getParameter("curr_date")==null?"":request.getParameter("curr_date");
	String total_query_records  = "0";
	

	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(link_ref_no == null) link_ref_no =""; else link_ref_no = link_ref_no.trim();


	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name, request) ;
	bean.setLanguageId(localeName);
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
 	
	String slClassValue = "";
	int i		 = 0;
	String[] record = null;

%>
<form name='link_existing_consent' id='link_existing_consent' action="../../eOR/jsp/LinkExistingConsent.jsp" method="post">

<table cellpadding=0 cellspacing=0 border=1 width="100%" class="grid">
<%


if(current_link.equals("")){
	ArrayList LinkDetail	= new ArrayList();
	LinkDetail				= bean.LinkExistingConsent(patientId,encounter_id,facility_id,consent_form_id, period_from,period_to,start,end) ;
	
	if(LinkDetail.size() == 0){
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%}
		
	for( int k=0 ; k< LinkDetail.size() ; k++ ) {
		/*if(i % 2 == 0)
			slClassValue = "QRYEVEN";
		else
			slClassValue = "QRYODD";*/
			slClassValue="gridData";
						
		record = (String[])LinkDetail.get(k);
		record[0] = record[0]==null?"":record[0];
		if(k==0){
			if(record[7] != null)
				total_query_records = bean.checkForNull((String)record[7],"0");
				//out.println("<script>alert('total_query_records="+total_query_records+"')</script>");
			%>
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from" value= "<%=start%>" /> 
			<jsp:param name ="to" value= "<%=end%>" />	
			<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
			<jsp:param name ="check_box_name" value= "chk" />					 
			<jsp:param name ="form_name" value= "link_existing_consent" />  
			</jsp:include>				
		<%}
			//visit_admn_date = (String)bean.getVisitAdmnDate(facility_id, record[8]) ; // Encounter_id is passed dynamically
	%>

		<tr>
			<td  width='10%' id='status<%=i%>' align='center' class='<%=slClassValue%>'><input type=radio name='chk<%=i%>' id='chk<%=i%>' onClick='chkSingleConsent("<%=record[0]%>","<%=record[1]%>","<%=record[2]%>","<%=i%>")' <%=link_ref_det.equals(record[1]+"~"+record[2]+"~")?"checked":""%>>
			</td>
			<td width='40%' class='<%=slClassValue%>'><font size=1><%=record[5]%></td> 
			<td width='30%' class='<%=slClassValue%>'><font size=1><%=record[6]%></td> 
			<td width='20%' class='<%=slClassValue%>'><font size=1><A HREF="javascript:showConsentReview('<%=record[3]%>','<%//=record[2]%>','<%=record[1]%>','<%=record[2]%>','<%=record[0]%>')" title='Recorded  Consent' style="COLOR:#CC3300;"><B><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></B></A></td><!--  data of ordered Catalogs -->
					
					

		</tr>
	<%
		i++;
	}
}else{
	
	String[] result = current_link.split("�");
    for (int x=0; x<result.length; x++){
		
		record = result[x].split("�");

		if(x==0){
			if(result != null)
				total_query_records = bean.checkForNull(String.valueOf(result.length),"0");
				//out.println("<script>alert('total_query_records="+total_query_records+"')</script>");
			%>
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from" value= "<%=start%>" /> 
			<jsp:param name ="to" value= "<%=end%>" />	
			<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
			<jsp:param name ="check_box_name" value= "chk" />					 
			<jsp:param name ="form_name" value= "link_existing_consent" />  
			</jsp:include>				
		<%}	

		/*if(i % 2 == 0)
			slClassValue = "QRYEVEN";
		else
			slClassValue = "QRYODD";*/
			slClassValue="gridData";
		%>
		<tr>
			<td  width='10%' align=center id='status<%=i%>' class='<%=slClassValue%>'><input type=radio name='chk<%=i%>' id='chk<%=i%>' onClick='chkSingleConsent("<%=record[0]%>","","","<%=i%>")' <%=link_ref_no.equals(record[0])?"checked":""%>></td>

			<td width='40%' class='<%=slClassValue%>'><font size=1><%=record[1]%></td> <!--  data of ordered AT -->
			<td width='30%' class='<%=slClassValue%>'><font size=1><%=curr_date%></td> <!--  data of ordered AT -->
			<td width='20%' class='<%=slClassValue%>'><font size=1><A HREF="javascript:showPreview('<%=Integer.parseInt(record[0])-1%>','<%=record[2]%>', '', '',true)" title='Consent from the Current Screen' style="COLOR:#009933;"><B><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></B></A></td><!--  data of ordered Catalogs -->
					

		</tr>
<%	i++;
	}

}
%>


</table>


<!-- Next, Prev --> 
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 

<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patientId%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="link_ref_no" id="link_ref_no" value="<%=link_ref_no%>">
<input type="hidden" name="link_ref_det" id="link_ref_det" value="<%=link_ref_det%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);	
%>

