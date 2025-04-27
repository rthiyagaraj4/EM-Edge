<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
15/07/2014				43320					Abdul Rabbani	                                       		AMRI-CRF-100019
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/ItemMovement.js"> </script>
		<script language="JavaScript" src="../../eST/js/PhyInvForSpecificItem.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name="FormPhyInvForSpecificItemAddedValue" id="FormPhyInvForSpecificItemAddedValue">
<%	
	java.util.HashMap defaultParameter = new HashMap();
	defaultParameter.put("item_codeF",request.getParameter("item_codeF"));
	defaultParameter.put("item_codeT",request.getParameter("item_codeT"));
	defaultParameter.put("store_code",request.getParameter("store_code")==null?request.getParameter("store_code_1"):request.getParameter("store_code"));
	defaultParameter.put("item_class_code",request.getParameter("item_class_code1")==null? "%":request.getParameter("item_class_code1")); //ADDED BY RABBANI #AMRI-CRF-100019(43320) ON 15-JULY-2014
System.err.println("item_class_codeitem_class_code" +request.getParameter("item_class_code1"));	
	String bean_id = "PhyInvForSpecificItemBean";
	String bean_name = "eST.PhyInvForSpecificItemBean";
	String store_code = "";
	ArrayList result = new ArrayList();
	HashMap showdataList = new HashMap();
	PhyInvForSpecificItemBean bean = (PhyInvForSpecificItemBean) getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);


	String temp_status = bean.checkForNull(request.getParameter("temp_disable"),"");
	String temp_id = bean.checkForNull(request.getParameter("temp_id"),"");
	if(temp_status.equals("create") && temp_id == ""){
		bean.clear_data();
		bean.clear();
		bean.setDefaultParameter(defaultParameter);
		bean.loadData_toHash();
	}else{
		if(temp_status.equals("query") && temp_id != ""){
			//when selecting the temp_phy_id from query criteria
			bean.clear_data();
			bean.clear();
			bean.setTemp_phy_id(temp_id);
			bean.loadData_toHash_temp();
			bean.loadData_toHash_temp_query();
		}else{
			//adding in query mode
			//bean.clear();
			bean.setDefaultParameter(defaultParameter);
			bean.loadData_toHash();
		}
	}

	result = bean.loadData();
	int total_rec = result.size();
	%>
	
	<div name='HeaderLabels' id='HeaderLabels' style='width:1013;overflow-x:no;overflow-y:no'>

	<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center >
	<%
	if (result.size() > 0)
	{
	%>
	<tr>
		<td class='COLUMNHEADERCENTER'  width="5%"  ><font size=1><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></td>
		<td class='COLUMNHEADERCENTER'  width="36%"  ><b><fmt:message key="Common.item.label" bundle="${common_labels}"/></b></font></td>
		<td class='COLUMNHEADERCENTER'  width="15%"  ><b><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></b></font></td>
		<td class='COLUMNHEADERCENTER'  width="15%"  ><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/></b></font></td>
	<tr>
	</table>
	</div>	
	<div name='RecordsDtl' id='RecordsDtl' style='width:1022;height:375;overflow-x:no;overflow-y: auto'>
	<%
	}
	else
	{
	%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		document.location.href="../../eCommon/html/blank.html";
		</script>
	<%
	}
	for(int i=0;i<result.size();i++)
	{
	showdataList = (HashMap)result.get(i);
	String className=(i%2==0)?"QRYEVEN":"QRYODD";

	String item_desc = bean.checkForNull((String)showdataList.get("ITEM_DESC"));
	String item_class_desc = bean.checkForNull((String)showdataList.get("ITEM_CLASS_DESC"));
	String store_desc = bean.checkForNull((String)showdataList.get("STORE_DESC"));
	store_code = bean.checkForNull((String)showdataList.get("STORE_CODE"));
	%>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center >
	<tr>
		<td class="<%=className%>"   width="5%"><font size=1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<INPUT TYPE="checkbox" name="chk_val_<%=i%>" id="chk_val_<%=i%>" checked ></font></td>
		<td  class="<%=className%>"  width="36%"><font size=1>&nbsp;&nbsp;<%=item_desc%></font></td>
		<td  class="<%=className%>"  width="15%"><font size=1>&nbsp;&nbsp;<%=item_class_desc%></font></td>
		<td  class="<%=className%>"  width="15%"><font size=1>&nbsp;&nbsp;<%=store_desc%></font></td>
	</tr>
	<%
	}
	%>
	</table>
	</div>
	
	<input type=hidden name="total_rec" id="total_rec"  value="<%=total_rec%>">
	<input type=hidden name="store_code" id="store_code"  value="<%=store_code%>">
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
<script>
	parent.f_adding_criteria.document.forms[0].store_code.value = parent.f_added_value.document.FormPhyInvForSpecificItemAddedValue.store_code.value;
	parent.f_adding_criteria.document.forms[0].store_code_1.value = parent.f_added_value.document.FormPhyInvForSpecificItemAddedValue.store_code.value;
</script>
</html>

