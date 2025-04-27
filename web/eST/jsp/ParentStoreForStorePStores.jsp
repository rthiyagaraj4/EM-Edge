<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <%
		request.setCharacterEncoding("UTF-8");
		String locale			=			(String)session.getAttribute("LOCALE");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/ParentStoreForStore.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
    <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body onMouseDown="CodeArrest()">
<%
	String store_code					=	request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String mode							=	request.getParameter("mode");
	String classvalue = "";
	String parent_chk = "";
	int i		= 0;
	int count	= 0;

	String bean_id						=	"ParentStoreForStoreBean";
	String bean_name					=	"eST.ParentStoreForStoreBean";
	ParentStoreForStoreBean bean		=	(ParentStoreForStoreBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	ArrayList alStores = new ArrayList();
	alStores = (ArrayList)bean.getParentStores(store_code);
	bean.alhmData.clear();
	bean.loadExistingParentStores(store_code);
%>
<form name="formParentStoreDetail" id="formParentStoreDetail" onreset="FocusFirstElement()">
<div name='HeaderLabels' id='HeaderLabels' style='width:1010;overflow-x:no;overflow-y:no'>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" height="5%" align="center">
		<th width="70%"><fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/></th>
		<th width="30%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</table>
		</div >
<div name='RecordsDtl' id='RecordsDtl' style='width:1022;height:305;overflow-x:auto;overflow-y: auto'>

<%
		HashMap hmResult = null;
		for(i=0;i<alStores.size();i++){
			hmResult = (HashMap)alStores.get(i);
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			if(bean.alhmData.containsKey((String)hmResult.get("STORE_CODE"))){
				parent_chk = "checked";
				count++;
			}
			else
				parent_chk = "";
%>
	<table border="1" cellpadding="0" cellspacing="0" width="100%" height="5%" align="center">
			<tr id="tr_<%=i%>">
				<%if(parent_chk.equals("checked")){%>
					<td class="<%=classvalue%>" onclick='dispItemClass(chk_<%=i%>,"<%=(String)hmResult.get("STORE_CODE")%>","<%=(String)hmResult.get("SHORT_DESC")%>","<%=i%>");'><label id = 'td_<%=i%>' style="cursor:pointer;color:blue"><font class="<%=classvalue%>"><%=bean.checkForNull((String)hmResult.get("SHORT_DESC"))%></font></label></td>
				<%}else{%>
				<td class="<%=classvalue%>"><label id = 'td_<%=i%>' onclick="dispItemClass(chk_<%=i%>,'<%=(String)hmResult.get("STORE_CODE")%>','<%=(String)hmResult.get("SHORT_DESC")%>','<%=i%>');"><font class="<%=classvalue%>" ><%=bean.checkForNull((String)hmResult.get("SHORT_DESC"))%></font></label></td>
				<%}%>
				<td class="<%=classvalue%>" width="30%"><input type="checkbox" name='chk_<%=i%>' id='chk_<%=i%>' value = "Y" <%=parent_chk%> onclick="dispItemClass(this,'<%=(String)hmResult.get("STORE_CODE")%>','<%=(String)hmResult.get("SHORT_DESC")%>','<%=i%>','xyz')"></td>
				<input type="hidden" name="parent_store_code_'<%=i%>'" id="parent_store_code_'<%=i%>'" value='<%=(String)hmResult.get("STORE_CODE")%>'>
			</tr>
<%
		}
%>
</table>
		</div >

	<input type="hidden" name="total_boxes" id="total_boxes" value="<%=i%>">
	<input type="hidden" name="count" id="count"		value="<%=count%>">
	<input type="hidden" name="prev_parent_store" id="prev_parent_store" value="">
	<input type="hidden" name="bean_id" id="bean_id" 	value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" 	value="<%=bean_name%>">
	<input type="hidden" name="mode" id="mode" 		value="<%=mode%>">
	</table>
</body>
<% 
   putObjectInBean(bean_id,bean,request);
%>
</html>

