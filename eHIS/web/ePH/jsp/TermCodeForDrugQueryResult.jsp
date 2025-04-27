<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.text.DecimalFormat, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 

<%-- Mandatory declarations end --%>


<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/TermCodeForDrug.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!-- <BODY>  -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	
	String bean_id	="TermCodeForDrug";
	String bean_name	="ePH.TermCodeForDrugBean";
	String classvalue			= "";
	String retVal0			= "";
	String retVal1			= "";
	String modeVal			= "";
	String eff_status,term_code,term_set_id,term_code_desc,term_set_desc;
		TermCodeForDrugBean bean = (TermCodeForDrugBean)getBeanObject(bean_id,bean_name ,request);
		
		String drug_code=request.getParameter("drug_code");
		String drug_desc=request.getParameter("drug_desc");
		
		//out.println("drug_desc-47-->" +drug_desc);
		
		
		
		 retVal0=request.getParameter("retVal[0]");
		 retVal1=request.getParameter("retVal[1]");
		
		  modeVal=request.getParameter("modeVal");
        if(retVal0==null&&retVal1==null&&modeVal==null)
		{
         retVal0="";
         retVal1="";
         modeVal="";
		}
		
		ArrayList TermResult=new ArrayList();
		HashMap TermMapResult=new HashMap();

		if(modeVal.equals("1"))
		{ 
			TermResult=bean.getTermResult(retVal0);
		}
		else
		{
   		TermResult=bean.getTermResult(drug_code);
		}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<form name="TermCodeQueryResultForm" id="TermCodeQueryResultForm">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<input type="hidden" name="drug_code" id="drug_code" value="">

<tr>
 <td class= "COLUMNHEADER" colspan="5"><fmt:message key="ePH.AssociatedTermCodes.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
        <td class= "COLUMNHEADER" ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>
		 </td>
        <td class= "COLUMNHEADER"><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/></td>
		<td class= "COLUMNHEADER" ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
		<td class= "COLUMNHEADER" ><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/> </td>
		<td class= "COLUMNHEADER">
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>

<%
int c_ind=0;
for(int i=0;i<TermResult.size();i++)
{
		c_ind++;
			if ( c_ind % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

                    TermMapResult  = (HashMap)TermResult.get(i);
					eff_status     = (String)TermMapResult.get("eff_status");
					term_code      = (String)TermMapResult.get("term_code");
					term_set_id    = (String)TermMapResult.get("term_set_id");
					term_code_desc = (String)TermMapResult.get("term_code_desc");
					term_set_desc  = (String)TermMapResult.get("term_set_desc");
				  ;
%>					
   <tr>
   <td class="<%=classvalue%>"><%=term_set_id%></td>
   <td class="<%=classvalue%>" ><%=term_set_desc%></td>
   <td class="<%=classvalue%>"><%=term_code%></td>
   <%
	//out.println("retVal1==116=>" +retVal1);
	//out.println("drug_desc==117=>" +drug_desc);%>
  <td class="<%=classvalue%>" onClick="defaultDrug('<%=term_code%>','<%=java.net.URLEncoder.encode(term_code_desc,"UTF-8")%>','<%=term_set_id%>','<%=term_set_desc%>','<%=eff_status%>','<%=CommonBean.checkForNull(drug_desc)%>','<%=CommonBean.checkForNull(drug_code)%>','<%=retVal0%>','<%=java.net.URLEncoder.encode(retVal1,"UTF-8")%>');"><font class="HYPERLINK" onmouseover="changeCursor(this);" size='1'><%=term_code_desc%>
  </font>
   </td> 
 	<td class="<%=classvalue%>">
	<%
		if(eff_status.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(eff_status.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}
	%>
	</td>
				
	
   </tr>
					
<%}
			

%>

<!-- Added hidden variables beanid,bean name for the incident number:23113 on Aug 5/2010 -->
<input type="hidden" name="bean_id" id="bean_id"	 value="<%= bean_id %>"> 
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>


