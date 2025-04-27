<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import="eST.GRNHistoryBean,java.util.*,java.lang.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script>  
		<script language="javascript" src="../../eST/js/StMessages.js"></script>-->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
	<%
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
	try{
		/**
			* @Name - Priya
			* @Date - 22/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id = "GRNHistoryBean";
		String bean_name = "eST.GRNHistoryBean";
		GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		int no_of_decimals=bean.getNoOfDecimals();

		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("ST_SQL_REPL_GRN_RTV_DTLS"));

		displayFields.add("rtv_doc_type_code");	                     
		displayFields.add("rtv_doc_no");	                         
		displayFields.add("rtv_doc_srl_no");                    
		displayFields.add("repl_grn_qty");	                 
		displayFields.add("rtv_item_qty");	                 
	
		chkFields.add( item_code);
		chkFields.add( doc_type_code);
		chkFields.add( doc_no);

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3)){
		%>
		<table cellpadding=0 cellspacing=0 width="99%" align="center">
		
			
			</table>
		
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" id='tb1'>
					<th><fmt:message key="eST.DocType/No.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.DocSrlNo.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ReplRTVQuantity.label" bundle="${st_labels}"/></th>
			<%
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					String className = (i % 2 == 0)?"QRYEVEN":"QRYODD";
					data = (ArrayList)result.get(i);
				%>
				<tr>
			<td class = "<%=className%>"align="Left">&nbsp;<%=CommonBean.checkForNull((String)data.get(0))%>/<%=CommonBean.checkForNull((String)data.get(1))%>&nbsp;</td>
			<td class = "<%=className%>"align="Left">&nbsp;<%=CommonBean.checkForNull((String)data.get(2))%>&nbsp;</td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Repl RTV Qty.				
					-->
			<td class = "<%=className%>" style="TEXT-ALIGN:right" ><%=bean.setNumber(bean.checkForNull((String)data.get(3),"0"),no_of_decimals)%>&nbsp;</td>
				</tr>
			<%
				}
			%>
			</table>
				</form>
		<%	
	}
	out.println(CommonBean.setForm (request ,"../../eST/jsp/GRNHistoryReplFrameList.jsp", searched));
	}
				catch(Exception e) {
					e.printStackTrace();
				}
%>
		</body>
</html>

