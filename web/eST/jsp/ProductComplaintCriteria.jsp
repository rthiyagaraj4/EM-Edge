<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src="../../eST/js/ProductComplaint.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		
		String bean_id							=		"SuspendOrReinstateBatchBean";
		String bean_name						=		"eST.SuspendOrReinstateBatchBean";
		//String disable							=		"";

		SuspendOrReinstateBatchBean bean		=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id, bean_name,request);  
		bean.setLanguageId(locale);
	%>

<body>
<form name="ProductComplaintCriteriaForm" id="ProductComplaintCriteriaForm" onreset='FocusFirstElement();' action="../../eST/jsp/ProductComplaintResult.jsp" method="post" target="frameProductComplaintResult">
	<div align="left">

	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>	 
		<tr>
			<td   class="label" nowrap>&nbsp;&nbsp;
			<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</td>
			<td   class=fields  nowrap>
			<input type='text' size='70'  maxlength='60' name='item_desc' id='item_desc'  value="">
			<input class='button' type='button' name='search_item' id='search_item' value='?' onClick="callItemSearchScreen(item_desc,item_code)" class="label">&nbsp;
			<img src='../../eCommon/images/mandatory.gif' align='center'>&nbsp;&nbsp;
			<span align='center' nowrap><b id="uom" align='center'>&nbsp;</b></span>
			</td>
			<td  class="label" id ="exp_id" nowrap>&nbsp;
			</td>
			<td  class="label" >
			<span id ="exp_data"></span>
			</td>
	 	 </tr>

		 <tr>
			<td   class="label" nowrap>&nbsp;&nbsp;
				<fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>
			</td>
			<td   class=fields  nowrap>
			<select name='manufacturer' id='manufacturer' >
				<option>&nbsp;&nbsp;&nbsp;&nbsp;--- --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---	---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</td>
			<td  class="label" nowrap>
				<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
			</td>
			<td  class=fields >
				<input  type=text  size=10 maxlength=10  name ="batch_id" onBlur="ChangeUpperCase(this);">
			</td>
	 	</tr>
		<tr>
		<td colspan=2 >&nbsp;</td>
		<td colspan=2 ><input type='submit' name='show_batches' id='show_batches' disabled value='<fmt:message key="eST.ShowBatches.label" bundle="${st_labels}"/>' class='Button' ></td>
		</tr>
	</table>

	</div>

	
	<input type='hidden' name='bean_id' id='bean_id'				value="<%=bean_id%>" >
	<input type='hidden' name='bean_name' id='bean_name'			value="<%=bean_name%>" >
	<input type='hidden' name='item_code' id='item_code'			value="" >
	<input type='hidden' name='uom_desc' id='uom_desc'			value="" >
</form>
	<%
	putObjectInBean(bean_id,bean,request);	 
	%>	
</body>
</html>

