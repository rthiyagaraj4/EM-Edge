
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
 <%
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
    <script language='javascript' src='../../eCommon/js/common.js'></script> 
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		"ManufacturingReceiptsBean";
	String bean_name						=		"eST.ManufacturingReceiptsBean";
	String classvalue						=		"";

	ManufacturingReceiptsBean bean			=		(ManufacturingReceiptsBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
//	String index							=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode								=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	String seq_no							=		request.getParameter( "seq_no" )==null?"":  request.getParameter( "seq_no" );
	ArrayList recordSet						=		new ArrayList();
	recordSet								=		bean.getDataList();

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
			<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.MFGUOM.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
	<%

	int i=0;int j=0;
	for	(i	=0;	i<recordSet.size();i++){
			hmRecord	=		(HashMap)	recordSet.get(i);
			classvalue	=		((j%2)==0)?"QRYODD":"QRYEVEN";
			
		String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)hmRecord.get("CHILD_ITEM_CODE")),"N");
	    String no_deci =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
          no_deci ="0";
		//if(((String)hmRecord.get("MFG_REQUEST_NO")).equals(seq_no)){
	%>
		<tr>
			<td class="<%=classvalue%>"><input type="checkbox" <%=((String)hmRecord.get("SELECTED")).equals("Y")?"checked":""%> name="del_<%=j%>" value="" ></td>
			<td class="<%=classvalue%>"    nowrap><a href="javascript:modifyChildData('<%=i%>','<%=seq_no%>');"><font size=1><%=(String)hmRecord.get("CHILD_ITEM_CODE")%></a></font></td>
			<td class="NODISPLAY" ><input type=hidden name ="itemcode_<%=j%>" value='<%=(String)hmRecord.get("CHILD_ITEM_CODE")%>'></td>
			<td class="<%=classvalue%>"   style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=(String)hmRecord.get("SHORT_DESC")%></td>
			<td class="<%=classvalue%>"    nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_DESC"),"&nbsp;")%></font></td>
			<td class="<%=classvalue%>"    nowrap  style="TEXT-ALIGN:right"><font size=1><%=bean.setNumber((String)hmRecord.get("COMPONENT_QTY"),Integer.parseInt(no_deci))%></font>&nbsp;</td>
		</tr>
	<%
			j++;
		//}
	}
	%>
	</table>
	<input type=hidden name="totalRecords" id="totalRecords"				value="<%=j%>">
	<input type='hidden' name='extemp_item_seq' id='extemp_item_seq'			value="<%=bean.seq_no%>" >
	<input type='hidden' name='mode' id='mode'					value="<%=mode%>" >
	<input type='hidden' name='preptype' id='preptype' >
	<input type='hidden' name='prepmode' id='prepmode' >
	</form>
	</center>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
	</html>

