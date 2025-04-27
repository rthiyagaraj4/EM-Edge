<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page    import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alPackingList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eSS/js/Packing.js"></script>	
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body onMouseDown="CodeArrest();" >
<%//alPackingList%>
<form name='formPackingList' id='formPackingList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<th><fmt:message key="eSS.Update.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.Tray.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.PackItem.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.PackQty.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.PackingDate.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.Hold.label" bundle="${ss_labels}"/></th>
		</tr>
<%
	PackingListBean bean		=		(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean",request ) ;  
	bean.setLanguageId(locale);
	
	String disabled				=		"";
	HashMap hmRecord			=		new HashMap();
	String className			=		"";
	int i;
	
	
	for	(i	=0;	i<alPackingList.size();i++){
		hmRecord				=		(HashMap)	alPackingList.get(i);
		
		bean.initialize(hmRecord);
		className				=		((i%2)==0)?"QRYODD":"QRYEVEN";
		
%>
	<tr>
		<td class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> checked></td>
		<td class="<%=className%>" ><a href="javascript:listModify(<%=i%>);"><%=bean.getGroup_desc()%></a></td>
		<td class="<%=className%>" ><%=bean.getTray_no()%></td>
		<td class="<%=className%>"><%=bean.checkForNull(bean.getPack_item_desc(),"")%><input type="hidden" name="packing_item_code_<%=i%>" id="packing_item_code_<%=i%>" value="<%=bean.checkForNull(bean.getPack_item_code(),"")%>"></td>
		<td class="<%=className%>" ><%=bean.checkForNull(bean.getPack_item_qty(),"")%><input type="hidden" name="packing_qty_<%=i%>" id="packing_qty_<%=i%>" value="<%=bean.checkForNull(bean.getPack_item_qty(),"")%>"></td>
		<% if((locale.equals("en"))){%>
 		<td class="<%=className%>" ><%=bean.checkForNull(bean.getPacking_date(),"")%></td>
		<% }else {%>
		<td class="<%=className%>" ><%=bean.checkForNull(com.ehis.util.DateUtils.convertDate(bean.getPacking_date(),"DMY","en",locale),"")%></td>
		<%}%>

		<td class="<%=className%>" >
		<%	if(hmRecord.get("hold_yn").equals("N")){%>
 		<%=bean.getImage(bean.getHold_yn())%>
		<%}else if(hmRecord.get("hold_yn").equals("Y")){%>
 		<%=bean.getImage("Y")%>
		<%}%>
			</td>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
</form>
<%
putObjectInBean("packingListBean",bean,request);
%>
</body>

</html>


