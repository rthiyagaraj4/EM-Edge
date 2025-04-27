<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
	<%
    request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//endss
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PhMessages.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/GenericNameByATC.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="frmGenericnameByATCQueryResult" id="frmGenericnameByATCQueryResult"  >
<%
	//Search Criteria's from Query Criteria page
	String eff_status	= request.getParameter( "eff_status" );
	String generic_name = request.getParameter( "generic_name");
	String drug_name	= request.getParameter( "drug_class");

	String from= request.getParameter("from");
	String to  = request.getParameter("to");

	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	String classvalue="";

	if (eff_status == null)
		eff_status ="";

	if (eff_status.equals("B"))
		eff_status="%";

	if(generic_name == null )
		generic_name="";

	if(drug_name == null)
		drug_name ="";

	if (generic_name.equals(""))
		generic_name="%";
	else
		generic_name += "%";

	if ( drug_name.equals(""))
		drug_name="%";

	/* Initialize Function specific start */
	GenericNameByATCBean bean = (GenericNameByATCBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	ArrayList result=(ArrayList)bean.getAllByGenericName(generic_name,drug_name,eff_status,from,to);
	if (result.size()>1){
%>

	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<br><br>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(0));
	%>
		</td></tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="ePH.QueryResultbyGenericName.label" bundle="${ph_labels}"/></th>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th width="75%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
		<th width="15%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></th>
		<th width="10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	<%
		//Retriving the records from result arraylist
		for(int recCount=1; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
	<%
			String columns[]=(String[] )result.get(recCount);
	%>
		<tr onClick="Modify(this)">
		<input type="hidden" name="generic_id" id="generic_id" value="<%= columns[0] %>">
		<td class="<%=classvalue%>"  >
		<a onmouseover="changeCursor(this);" style="color:blue;cursor:pointer" ><%= columns[1]	%></a>
		</td>
		<td class="<%=classvalue%>"  onclick="disableClick(event);">
		<%if(columns[2].equals("General")){%>
		 <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")%>
		<%}else{%>
		 <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+columns[2]+".label","ph_labels")%>
		 <%}%>
		</td>
		<% if(columns[3].equals("E")){
		%>
		<td class="<%=classvalue%>" onclick="disableClick(event);"><img src='../../eCommon/images/enabled.gif'><input type="hidden" value="E"></img>
		</td>
		<%}
		  else{
		%>
		<td class="<%=classvalue%>"  onclick="disableClick(event);"><img src='../../eCommon/images/disabled.gif'><input type="hidden" value="D"></img>
		</td>
		<%}%>
		</tr>
	<%}%>
		</table>
	<%}
	  else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	history.go(-1);</script>
	<%
	  }
	%>
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="eff_status" id="eff_status" value="">
	<input type="hidden" name="generic_name" id="generic_name" value="">
	<input type="hidden" name="drug_class" id="drug_class" value="">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

