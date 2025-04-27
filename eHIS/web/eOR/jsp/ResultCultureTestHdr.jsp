<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
    <TITLE><fmt:message key="eOR.CultureTest.label" bundle="${or_labels}"/></TITLE>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085   
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onLoad='organismReqdClick();' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
	String index			= request.getParameter("index");
	String chart_result_type	= request.getParameter("chart_result_type");
	//System.out.println("chart_result_type"+chart_result_type);
	if (index == null) index = "0";
	if (chart_result_type == null) chart_result_type = "";
	//ResultEntryBean bean = (ResultEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	
    ArrayList headingDetails	= bean.getChartHeadingDetails(chart_result_type);
	String horizontalHeading	= "";
	String	templateText="";
	String display="";
	String verticalHeading		= "";
	//String tempstring="";
	//int	chart_no_columns		= 0;

	if (headingDetails != null &&headingDetails.size() > 0) {
		String [] headingRecord = (String[])headingDetails.get(0);
		verticalHeading			= bean.checkForNull(headingRecord[0]);
		horizontalHeading		= bean.checkForNull(headingRecord[1]);
		//chart_no_columns		= Integer.parseInt(bean.checkForNull(headingRecord[2],"0"));
		//System.out.println("verticalHeading"+verticalHeading);
		//System.out.println("horizontalHeading"+horizontalHeading);
	}

	HashMap parentMap 	=	bean.getCultureTestRecord();
	templateText = (String)bean.getResultData(index);
	 if (templateText==null||templateText.equals("null")||templateText=="")
	 {
		 templateText="";
	 }
//templateText="";
	//System.out.println("in hearer page parentMap"+templateText);
	//tempstring=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	if(!templateText.equals("")){
	if(templateText.startsWith("Remarks:"))
	{
display=templateText.substring(8,templateText.indexOf(verticalHeading));
	}
	}
	
	HashMap map			= new HashMap();

	if (parentMap != null && parentMap.containsKey(index))
		map = (HashMap)parentMap.get(index);

	String checkValue 	= (map.containsKey("antibiotic_organism_reqd_yn"))?(String)map.get("antibiotic_organism_reqd_yn"):"N";
	checkValue			= "Y";
	//out.println("index="+index+",checkValue="+checkValue+",parentMap.containsKey(index)="+parentMap.containsKey(index));
	//out.println((checkValue.equalsIgnoreCase("Y"))?"organismReqdClick(document.result_culture_test_hdr.antibiotic_organism_reqd_yn);":"");
%>
<Form name='result_culture_test_hdr' id='result_culture_test_hdr' >
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<TR>
			<%--<TD class='label'><%=verticalHeading%>\<%=horizontalHeading%> <fmt:message key="eOR.Reqd.label" bundle="${or_labels}"/></TD>
			<TD class='fields'><Input name='antibiotic_organism_reqd_yn' id='antibiotic_organism_reqd_yn' type='checkbox' value='<%=checkValue%>' <%=eHISFormatter.ChkBoxChecked("y", checkValue)%> onClick='organismReqdClick();'></TD>--%>
			<TD class='fields'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/><Input name='antibiotic_organism_reqd_yn' id='antibiotic_organism_reqd_yn' type='hidden' value='<%=checkValue%>'></TD>
			<TD class='fields'><Input name='remarks' id='remarks' type='text' value='<%=((map.containsKey("remarks"))?((((String)map.get("remarks")).equals(""))?display:(String)map.get("remarks")):"")%>' maxlength='30' size='30'></TD>
		</TR>
	</Table>
	<Input name='qry_string' id='qry_string' type='hidden' value='<%=request.getQueryString()%>'>
	<Input name='index' id='index' type='hidden' value='<%=index%>'>
	<Input name='chart_result_type' id='chart_result_type' type='hidden' value='<%=chart_result_type%>'>
	<Input name='vertical_heading' id='vertical_heading' type='hidden' value='<%=verticalHeading%>'>
	<Input name='horizontal_heading' id='horizontal_heading' type='hidden' value='<%=horizontalHeading%>'>
	<Input name='bean_id' id='bean_id' type='hidden' value='<%=bean_id%>'>
</Form>
<%--<Script>
<%=(checkValue.equalsIgnoreCase("Y"))?"organismReqdClick();":""%>
</Script>--%>

<%
	putObjectInBean(bean_id,bean,request);
%>
</BODY>
</HTML>

