<!--  
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
10/05/2024   54749        R. Gunasekar       Ramesh G    ML-CRF-20192
---------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<title>
	<fmt:message key="eST.Hold.label" bundle="${st_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>
<body>
<%  

String bean_id					=		"RequestStatusBean";
String bean_name				=		"eST.RequestStatusBean";
RequestStatusBean bean				=		(RequestStatusBean) getBeanObject(bean_id,bean_name,request);  

String facility_id				=		request.getParameter("facility_id")==null?"":request.getParameter( "facility_id" ) ;
String doc_type_code				=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
String doc_no				=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
String doc_srl_no				=		request.getParameter("doc_srl_no")==null?"":request.getParameter( "doc_srl_no" ) ;
String remarks_type				=		request.getParameter("remarks_type")==null?"":request.getParameter( "remarks_type" ) ;


ArrayList reqsStDtls = new ArrayList();
reqsStDtls.add(facility_id);
reqsStDtls.add(doc_type_code);
reqsStDtls.add(doc_no);
reqsStDtls.add(doc_srl_no);
reqsStDtls.add(remarks_type);


HashMap remarks=(HashMap)bean.getRemarksValue(reqsStDtls);
System.out.println("remarks------> line no 44: " + remarks);
String hold_remarks = bean.checkForNull((String)((HashMap)remarks.get("remarks")).get("HOLD_REMARKS"),"&nbsp;");





		
 %>
<br>
<style>
textarea {
    display: block;
    margin-left: 5px;
}
</style>
	<div>
	<table>
	<tr>
	<td><fmt:message key="eST.HoldRemarks.label" bundle="${st_labels}"/></td>
     <td><textarea  readonly id="curr_remarks" name="curr_remarks" rows="6" cols="36" maxlength="2000"><%=hold_remarks%></textarea></td>
	</tr>
	
	</table>
	       
	</div>
<br>
<div align='Right'>	
     
	<button type="button" onclick="javascript:window.close()"><fmt:message key="Common.close.label" bundle="${common_labels}"/></button>
	<br>
	<br>
</div>
<%
		putObjectInBean(bean_id,bean,request);
%>
</body>
</HTML>

