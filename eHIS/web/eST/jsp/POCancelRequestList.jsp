<!DOCTYPE html>
 <%@ page import="eST.POCancelRequestBean, eST.POCancelRequestDetailBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
<%
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/POCancelRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></title>
	</head>
	<%
		String bean_id				=			"poCancelRequestBean";
		String bean_name			=			"eST.POCancelRequestBean";
		String mode					=			request.getParameter("mode");
		String function_id			=			request.getParameter("function_id");
		String className			=			"";
		POCancelRequestBean bean	=			(POCancelRequestBean) getBeanObject(bean_id,bean_name,request);  
		String doc_type_code		=			request.getParameter("doc_type_code");
		String doc_no				=			request.getParameter("doc_no");

		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		

		bean.loadData(doc_type_code, doc_no);
		bean.setLanguageId(locale);
		java.util.ArrayList alItems =		bean.getAlItems();
		int i=0;
	/**
	* @Name - krishna
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function
	*/

	int no_of_decimals						=			bean.getNoOfDecimals();
	int no_of_decimals_temp					=			bean.getNoOfDecimals();
	%>
	<body >
		<form name='formPOCancelRequestList' id='formPOCancelRequestList'>
			<br>
			<div name='HeaderLabels' id='HeaderLabels' style='width:630;height:180;overflow-y:auto'>

			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' align=center>
 			<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
				<th width="75%" style="WORD-BREAK:BREAK-ALL;">Item</th>
				<th><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.IssQty.label" bundle="${st_labels}"/></th>
			</tr>
			<%
				if (alItems != null && (alItems.size()>0)) {
					int totalSize = alItems.size();
					POCancelRequestDetailBean detailBean;
					for (i=0;	i<totalSize;	i++){
						detailBean = (POCancelRequestDetailBean) alItems.get(i);
						if (detailBean != null) {
						className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
	/**
	* @Name - krishna
	* @Date - 21/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function .
	*/
					if(bean.getAllowDecimalsYN((String)detailBean.getItem_code()).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals					=			no_of_decimals_temp;
					}
				%>
				<tr>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" ><%=detailBean.getItem_desc()%></td>
					 <!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Req Qty and Issue Qty .				
					-->
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getRequired_qty(),"0"),no_of_decimals)%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getIssued_qty(),"0"),no_of_decimals)%>&nbsp;</td>
				</tr>
				<%
					}
				}
			}
			%>
			</table>
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

