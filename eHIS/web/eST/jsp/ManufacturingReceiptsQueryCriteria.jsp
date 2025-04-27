<!DOCTYPE html>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="obj1" scope="page" class="eST.ManufacturingRequestBean"/>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script language='javascript' src="../../eST/js/ManufacturingReceipts.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//java.util.HashMap defaultParameter = null;
	String bean_id = "ManufacturingReceiptsBean";
	String bean_name = "eST.ManufacturingReceiptsBean";
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setTrntype("MFG");
	String mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	String  select1 = "";
	String  select2  = "";
	String disable_direct	=	""; 
    String  disable_req	    =	"";
    String dflt_mfg_mode =request.getParameter("dflt_mfg_mode")==null?"R":request.getParameter("dflt_mfg_mode");

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
		bean.setLanguageId(locale);
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
		
	if(dflt_mfg_mode.equals("D")){
		select1 			= "checked";
		//Added by Rabbani for avoid doubleclick on radio button on 12-APR-2013
	    disable_direct		=	"disabled"; 
        disable_req			=	""; 
	}else{
		select2 			= "checked";
		disable_direct		=	""; 
     	disable_req			=	"disabled"; 
	}

	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	//if(homepage.equals("Y"))
		//bean.setStore_code(store_code);
	%>
<body onMouseDown="CodeArrest()">
<form name="manufacturing_form" id="manufacturing_form" >
<div >
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
 <!--Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts -->
<tr>
		<td align="right" class="label"  colspan="4"><fmt:message key="eST.DirectManufacturing.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="dflt_id" id = "dflt_id" value="D" <%=select1%>  <%=disable_direct%> onclick = "loadresultpage(this,<%=mode%>);">
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ByRequest.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="dflt_id1"  id = "dflt_id1" value="R"  <%=select2%> <%=disable_req%> onclick= "loadresultpage(this,<%=mode%>);">
	  </td> 
	</tr>
	<!-- ends -->
<tr>
	<td colspan=5>&nbsp;</td>
</tr> 

<tr>
	<td   class="label" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;<select name='store_code' id='store_code' ><%=bean.getRequestStoreQuery()%></select></td>
	<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.initDoc_type_codeList()%></select></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" size="10" maxlength="8"  name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
	<td >&nbsp;</td>
	<td  class='fields'>&nbsp;<input type=button name='select' id='select'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='Button'  onClick="loadHdrData(store_code,doc_type_code,doc_no,<%=mode%>);"></td>
</tr>
</table>
</div>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='checkBoxVals' id='checkBoxVals' >
<input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
<input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>" >
<input type='hidden' name='item_code' id='item_code' value="<%=bean.getItem_code()%>" >
<input type='hidden' name='patient_name' id='patient_name' value="<%=bean.getPatient_name()%>" >
<input type='hidden' name='process_loss_percent' id='process_loss_percent'  >
<input type='hidden' name='unit_cost' id='unit_cost'  >
<input type='hidden' name='bin_location_code' id='bin_location_code'  >
<input type='hidden' name='baseqty' id='baseqty'  >
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

