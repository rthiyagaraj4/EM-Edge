<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/DrugStockStatusByStore.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id					    =		"DrugStockStatusByStoreBean";
	String bean_name				    =		"eST.DrugStockStatusByStoreBean";
	DrugStockStatusByStoreBean bean		=		(DrugStockStatusByStoreBean) getBeanObject(bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	int i =0;
	
	try{  
	HashMap   hmrecords                 =   new HashMap();
	ArrayList alAtcClassification       =   new ArrayList();
	String   generic_id					=	request.getParameter( "generic_id")==null?"":request.getParameter( "generic_id" );
	         alAtcClassification             =   bean.getATCClassificationdesc(generic_id,locale);
	  %>
	  <body>
	  <form name="ATCDESC" id="ATCDESC">
			<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center" style = "border:1px solid black;">
 			    <tr>
				<th><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}" />  Chemical Main class </th>
				</tr>
	  <%
	    for( i=0;i<alAtcClassification.size();i++){
		hmrecords=(HashMap)alAtcClassification.get(i);
	 %>
        <tr id="tr_<%=i%>">
           <td class="label" nowrap  name="atc_desc<%=i%>" ><%=hmrecords.get("LEV4_DESC")%></td>			
         </tr>
    <%
	}
   }
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}
 %>
	<%
putObjectInBean(bean_id,bean,request);
 %>
</body>
</html>

