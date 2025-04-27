<!DOCTYPE html>
<%@page import="eCA.*,java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head><title></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;	
	String locale = (String) p.getProperty("LOCALE");

	//String queryString = (String)session.getValue( "IPQueryString" ) ;
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/CAPractForConsultation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 

	</STYLE>

	
</head>
<body onMouseDown='CodeArrest();' onKeyDown='lockKey();'>
<%
	
	String bean_id = "capractconsultorderbean" ;
	String bean_name = "eCA.CAConsultationBean";
	String mode = "1";
	//String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	
	/* Mandatory checks end */
	/* Initialize Function specific start */
	CAConsultationBean bean = (CAConsultationBean)getObjectFromBean( bean_id,  bean_name, session ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setResourceType("P");
	bean.setLocale(locale);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();  
	//boolean clearDBbean		=  bean.clearDBRec();
	/* Initialize Function specific end */
%>
<form name="formPractForConsultOrderHdr" id="formPractForConsultOrderHdr">
<table border='0' cellspacing='8' cellpadding='3' width='100%' height='100%' align='center'>
<tr>
	<td class='label'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class='fields'>	
	<select name='group_by' id='group_by' onChange='return fnDisplaySelectedRow(this);'>		
		<option value="O"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></option>	
		<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>			
	</select>		
	</td>
</tr>
<tr >
	<td class='label' style = "display" id = 'catalog_row'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class='label' style = "display:none" id = 'pract_row'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<input type='hidden' name='order_catalog' id='order_catalog' value="">
	<input type='text' name='order_catalog_desc' id='order_catalog_desc' value="" onblur="javascript:checkText(this)"><input type='button' class="button" name="order_catalog_butoon" id="order_catalog_butoon" value="?" onclick="javascript:fnLookupByGroup();" ><img src="../../eCommon/images/mandatory.gif" >	
	</td>
</tr>
<tr>
		<td width='25%' class='label' id='ordercatalogRow' style='display:none'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td width='75%' class='fields' id='ordercatalogValue' style='display:none''>
			<input type='hidden' name='order_catalog_code' id='order_catalog_code' value=''>
			<input type='text' name='order_catalog_value' id='order_catalog_value' value='' onblur="javascript:checkTexts(this);"><input type='button' class='button' name='service_butoons' id='service_butoons' value='?' onclick='javascript:lookupByGroups();'><img src='../../eCommon/images/mandatory.gif' >	
		</td>
</tr>
<tr id='selectTable'><td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr>
	<td colspan='2' id='linkId' >
	<jsp:include page="CACommonAlphaLink.jsp" flush="true"/>
	</td>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,session);
 
%>


