<!DOCTYPE html>
<%@ page import ="ePO.Common.PoRepository, ePO.FacilityForPurchaseUnitBean, javax.servlet.ServletContext " contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../ePO/js/FacilityForPurchaseUnit.js' language='javascript'></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <body onLoad='FocusFirstElement();'>  

<form name='formFacilityForPurchaseUnitHeader' id='formFacilityForPurchaseUnitHeader' onMouseDown="CodeArrest()">
<%
 	String mode						=	"";
	String bean_id					=	"";
	String bean_name				=	"";		  
	String purchase_unit			=	"";	
	String pur_unit_id				=	"";
	
	bean_id							= "facilityForPurchaseUnitBean" ;
	bean_name						= "ePO.FacilityForPurchaseUnitBean" ;
	purchase_unit					= request.getParameter("purchase_unit");	
	pur_unit_id						= request.getParameter("pur_unit_id");
	
	FacilityForPurchaseUnitBean bean	   = (FacilityForPurchaseUnitBean)getBeanObject( bean_id, bean_name, request );
	try{

		ServletContext context = getServletConfig().getServletContext();
		mode						   = request.getParameter("mode");

		if ( mode == null || mode.equals("") ) 
			return ;
		if (!(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ; 
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
		
				
	   putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	int i=0;
%>

  <br>
  <table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
    <tr>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	</tr>
    <tr>
	  	<td align='right' class='label'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/>&nbsp;&nbsp;</td>
<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
	     <td align='left' class=label id=td5><input type="text" name="purchase_unit" id="purchase_unit" value="<%=purchase_unit%>" size=60 maxLength=60    align="centre" disabled><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(purchase_unit)" align="left" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="pur_unit_id" id="pur_unit_id" value="" size="15"></td>
		 <td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onclick="searchDetails()" disabled></input></td>
<%}else{%>
         <td align='left' class=label id=td5><input type="text" name="purchase_unit" id="purchase_unit" value="" size=60 maxLength=60  align="centre"><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(purchase_unit)" align="left">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="pur_unit_id" id="pur_unit_id" value="" size="15"></td>
		 <td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchDetails()" ></input></td>
<%}%>
		 <td>&nbsp;</td>
	</tr> 
	
	
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {%>
		<tr id="trhidden" STYLE=visibility:hidden></tr>
<%}%>		
	
	<tr>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	</tr>
</table>
<input type='hidden'	name="SelectYNStr" id="SelectYNStr"							value="">
<input type="hidden"	name="SQL_PO_PURCHASE_UNIT_LOOKUP" id="SQL_PO_PURCHASE_UNIT_LOOKUP"		value="<%=PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_LOOKUP")%>">
<input type='hidden'	name="mode" id="mode"									value="<%=mode%>">
<input type='hidden'	name="language_id" id="language_id"							value="<%=locale%>">
<input type='hidden'	name="pur_ut_id" id="pur_ut_id"							value="">
<input type="hidden" name="total_count_flag" id="total_count_flag" value="<%=i%>">
</form>
</body>
</html>





