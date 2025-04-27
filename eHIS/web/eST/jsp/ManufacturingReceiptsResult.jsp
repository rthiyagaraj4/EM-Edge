<!--<!DOCTYPE html>-->
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//java.util.HashMap defaultParameter = null;
	String bean_id = "ManufacturingReceiptsBean";
	String bean_name = "eST.ManufacturingReceiptsBean";
	String classvalue="";
	 
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
		
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	bean.setLanguageId(locale);
	//ArrayList dataList=new ArrayList();
	ArrayList recordSet=new ArrayList();
	
	recordSet=bean.getDataList();
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	HashMap hmRecord=new HashMap();
	%>
	<body onMouseDown="CodeArrest()">
	<form name='ManufacturingResultForm' id='ManufacturingResultForm' method='post' >
		<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1' align=center>
			<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
	<%
	
	int i=0;
	for	(i	=0;	i<recordSet.size();i++){
		hmRecord	=(HashMap)	recordSet.get(i);
		classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";

%>
		<tr>
			<td class="<%=classvalue%>"><input type="checkbox" name="del_<%=i%>" id="del_<%=i%>" value="" ></td>
			<td class="<%=classvalue%>"    nowrap><a href="javascript:modifyData(<%=i%>);"><font size=1><%=(String)hmRecord.get("CHILD_ITEM_CODE")%></a></font></td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><font size=1><%=(String)hmRecord.get("SHORT_DESC")%></font></td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_DESC"),"&nbsp;")%></font></td>
			<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><font size=1><%=(String)hmRecord.get("COMPONENT_QTY")%></font></td>
		</tr>
	<%
	}
	%>
	</table>
	<input type=hidden name="totalRecords" id="totalRecords"  value="<%=recordSet.size()%>">
	</form>
	</center>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
	</html>

