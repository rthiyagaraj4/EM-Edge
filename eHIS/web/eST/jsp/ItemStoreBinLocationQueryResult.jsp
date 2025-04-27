<!DOCTYPE html>
<%@page import="java.util.*, eST.Common.*, eST.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ItemStoreBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String store_code = request.getParameter("store_code");
	String store_desc = request.getParameter("store_desc");
	String item_code = request.getParameter("item_code");
	String item_desc = request.getParameter("item_desc");
	String bin_location_code = request.getParameter("bin_location_code");
	String bin_location_desc = request.getParameter("bin_location_desc");
	//String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	HashMap sqlMap				=		new HashMap();
	HashMap funcMap				=		new HashMap();
	ArrayList displayFields		=		new ArrayList();
	ArrayList chkFields			=		new ArrayList();
	ArrayList result			=		new ArrayList();
	ArrayList records			=		new ArrayList();
	try{
		store_code = CommonBean.checkForNull(store_code)+"%";
		store_desc = CommonBean.checkForNull(store_desc)+"%";
		item_code = CommonBean.checkForNull(item_code)+"%";
		item_desc = CommonBean.checkForNull(item_desc)+"%";
		bin_location_code = CommonBean.checkForNull(bin_location_code)+"%";
		bin_location_desc = CommonBean.checkForNull(bin_location_desc)+"%";
	sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_BIN_LOCN_QUERY_RESULT"));
		displayFields.add("store_code");
		displayFields.add("store_desc");
		displayFields.add("item_code");
		displayFields.add("item_desc");
		displayFields.add("bin_location_code");
		displayFields.add("bin_location_desc");

		chkFields.add(store_code);
		chkFields.add(store_desc);
		chkFields.add(item_code);
		chkFields.add(item_desc);
		chkFields.add(bin_location_code);
		chkFields.add(bin_location_desc);
		chkFields.add(locale);

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align=center>
				<th><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eMM.BinLocationCode.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="eMM.BinDesciption.label" bundle="${mm_labels}"/></th>
				<%
						String stPrevItem="";
						for(int recCount=2; recCount<result.size(); recCount++) {
							//String link_columns = "1";
							records=(ArrayList) result.get(recCount);
							if (!stPrevItem.equals(records.get(3))) {
								%><tr><td class='ITEMSELECT'  colspan='8'><b><%=records.get(3)%></b></td></tr>
<%
							}
							if (recCount % 2 == 0)
								classvalue = "QRYEVEN";
							else
								classvalue = "QRYODD";
					%>
				<tr>
				<td class="<%=classvalue%>" nowrap><%=records.get(0)%></td>
				<td class="<%=classvalue%>" nowrap><%=records.get(1)%></td>
				<td class="<%=classvalue%>" nowrap><%=records.get(4)%></td>
				<td class="<%=classvalue%>" nowrap><%=records.get(5)%></td>
			</tr>
		<%stPrevItem=(String)records.get(3);
			}
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ItemStoreBinLocationQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
	}
%>
</body>
</html>

