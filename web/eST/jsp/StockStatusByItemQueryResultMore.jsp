<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StockStatusByItem.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%	
	String bean_id = "StockStatusByItemBean";
	String bean_name = "eST.StockStatusByItemBean";

	StockStatusByItemBean bean = (StockStatusByItemBean) getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	String sole_source = bean.checkForNull(bean.getSole_source());
	String special_item = bean.checkForNull(bean.getSpecial_item());
	String anal3_desc = bean.checkForNull(bean.getAnal3_desc());
	String item_remarks = bean.checkForNull(bean.getItem_remarks());
	String manufacturer_name =  bean.checkForNull(bean.getManufacturer_name());
	String anal1_desc = bean.checkForNull(bean.getAnal1_desc());
	String autoclaveable = bean.checkForNull(bean.getAutoclaveable());
	String anal2_desc = bean.checkForNull(bean.getAnal2_desc());
	String item_sp = bean.checkForNull(bean.getItem_specification());
	ArrayList arrParam=new ArrayList();
	arrParam.add(bean.checkForNull(bean.getItem_code()));
	arrParam.add(locale);
	HashMap hmRecord=bean.fetchRecord("SELECT short_name FROM ap_supplier_lang_vw WHERE supp_code = (SELECT curr_supp_code FROM mm_item WHERE item_code = ?) AND language_id = ?", arrParam);
	String 	supplier_name=bean.checkForNull((String)hmRecord.get("SHORT_NAME"));
	%>
<table cellpadding=0 cellspacing=0 width="100%" align="center">
	<tr>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
	<tr>		
	<td  class="label" align=left width=130 height=30><fmt:message key="eST.SoleSourceYN.label" bundle="${st_labels}"/></td>
	<td  class="level" align=left width=100>
		<%
		if(sole_source.equals("Y")) {
	%>
	<image src='../../eCommon/images/enabled.gif'>
	<%
	}
	else {
	%>
	<image src='../../eCommon/images/disabled.gif'>
	<%
	}
	%>
	</td>
		<td  class="label" align=left width=100><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		<td  class="label" align=left width=100><%=manufacturer_name%></td>
		<td  class="label" align=left width=100><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
		<td  class="label" align=left width=100><%=supplier_name%></td>
	</tr>
		<tr>
		<td  class="label" align=left width=130 height=30><fmt:message key="eST.SpecialItemYN.label" bundle="${st_labels}"/></td>
		<td  class="label" align=left width=100>
		<%
		if(special_item.equals("Y")) {
	%>
	<image src='../../eCommon/images/enabled.gif'>
	<%
	}
	else {
	%>
	<image src='../../eCommon/images/disabled.gif'>
	<%
	}
	%>
	</td>
		<td  class="label" align=left width=100><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
		<td  class="label" align=left width=100><%=anal1_desc%></td>
		<td  class="label" align=left width=100><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
		<td  class="label" align=left width=100><%=anal2_desc%></td>
	</tr>
		<tr>
		<td  class="label" align=left width=130 height=30><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>  3</td>
		<td  class="label" align=left width=100><%=anal3_desc%></td>
		<td  class="label" align=left width=100><fmt:message key="eST.SterilizableYN.label" bundle="${st_labels}"/></td>
		<td  class="label" align=left width=100>
		<%
		if(autoclaveable.equals("Y")) {
		%>
		<image src='../../eCommon/images/enabled.gif'>
		<%
		}
		else {
		%>
		<image src='../../eCommon/images/disabled.gif'>
		<%
		}
		%>
		</td>
		<td  class="label" align=left width=100></td>
		<td  class="label" align=left width=100></td>
	</tr>
		<tr>
		<td  class="label" align=left width=100 height=30><fmt:message key="eMM.ItemRemarks.label" bundle="${mm_labels}"/></td>
		<td  class="label" align=left width=100 colspan=5>
		<textarea rows=2 cols=80 readonly><%=item_remarks%></textarea></td>
		<!--<td  class="label" align=right width=100></td>
		<td  class="label" align=right width=100></td>
		<td  class="label" align=right width=100></td>
		<td  class="label" align=right width=100></td>-->
	</tr>
		<tr>
		<td  class="label" align=left width=130 height=100><fmt:message key="eST.ItemSpecifications.label" bundle="${st_labels}"/></td>
		<td  class="label" align=left width=100 colspan=5>
		<textarea rows=2 cols=80 readonly><%=item_sp%></textarea></td>
		<!--<td  class="label" align=right width=100></td>
		<td  class="label" align=right width=100></td>
		<td  class="label" align=right width=100></td>
		<td  class="label" align=left width=100></td>-->
	</tr>
	</tr>
<table>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

