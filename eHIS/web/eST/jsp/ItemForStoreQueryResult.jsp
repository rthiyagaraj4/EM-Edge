
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172
---------------------------------------------------------------------------------------------------------
*/  
%>
<%@page import="java.util.*, eST.Common.*, eST.* " %>
<%@page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ItemForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()">
<%
	String store_code			=		request.getParameter("store_code");
	String store_desc			=		request.getParameter("store_desc");
	String item_code			=		request.getParameter("item_code");
	String item_desc			=		request.getParameter("item_desc");
	String store_type_code		=		request.getParameter("store_type_code");
	String stock_item_yn		=		request.getParameter("stock_item_yn");
	String item_class_code		=		request.getParameter("item_class_code");
	String eff_status			=		request.getParameter("eff_status");
	String temp_store			=		"";
	//String orderBy[]			=		request.getParameterValues("orderbycolumns");
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String classvalue			=		"";
	HashMap sqlMap				=		new HashMap();
	HashMap funcMap				=		new HashMap();
	ArrayList displayFields		=		new ArrayList();
	ArrayList chkFields			=		new ArrayList();
	ArrayList result			=		new ArrayList();
	ArrayList records			=		new ArrayList();
	try{
		store_code				=		CommonBean.checkForNull(store_code)+"%";
		store_desc				=		CommonBean.checkForNull(store_desc)+"%";
		item_code				=		CommonBean.checkForNull(item_code)+"%";
		item_desc				=		CommonBean.checkForNull(item_desc)+"%";
		store_type_code			=		CommonBean.checkForNull(store_type_code);
		stock_item_yn			=		CommonBean.checkForNull(stock_item_yn);
		item_class_code			=		CommonBean.checkForNull(item_class_code)+"%";
		eff_status				=		CommonBean.checkForNull(eff_status);
		

//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_QUERY_RESULT"));
// Changed for the Performence Issue Rams
	//	sqlMap.put("sqlData", "SELECT   a.store_code,          (SELECT long_desc             FROM mm_store_lang_vw            WHERE store_code = a.store_code AND language_id = ?) store_desc,          a.item_code,          (SELECT short_desc             FROM mm_item_lang_vw            WHERE item_code = a.item_code AND language_id =?) item_desc,          stock_item_yn, min_stk_qty, max_stk_qty, reorder_level,          c.gen_uom_code stock_uom, a.eff_status eff_status,          a.reorder_qty reorder_qty     FROM st_item_store a, mm_store b, mm_item c, st_store d    WHERE a.store_code = b.store_code      AND a.item_code = c.item_code      AND b.facility_id = ?      AND d.store_code LIKE UPPER (?)      AND UPPER (b.long_desc) LIKE UPPER (?)      AND a.item_code LIKE UPPER (?)      AND UPPER (c.short_desc) LIKE UPPER (?)      AND d.store_type_flag LIKE (?)      AND a.store_code = d.store_code      AND a.stock_item_yn LIKE (?)      AND c.item_class_code LIKE (?)      AND a.eff_status LIKE NVL (?, '%')      AND b.eff_status = c.eff_status      AND c.eff_status = 'E'");Modified for GHL-CRF-0456
			sqlMap.put("sqlData", "SELECT   a.store_code,          (SELECT long_desc             FROM mm_store_lang_vw            WHERE store_code = a.store_code AND language_id = ?) store_desc,          a.item_code,          (SELECT short_desc             FROM mm_item_lang_vw            WHERE item_code = a.item_code AND language_id =?) item_desc,          stock_item_yn, min_stk_qty, max_stk_qty, reorder_level,          c.gen_uom_code stock_uom, a.eff_status eff_status,          a.reorder_qty reorder_qty  , a.sales_allowed_yn sales_allowed_yn, A.CONSUMPTION_ALLOWED_YN CONSUMPTION_ALLOWED_YN,NO_OF_DAYS   FROM st_item_store a, mm_store b, mm_item c, st_store d    WHERE a.store_code = b.store_code      AND a.item_code = c.item_code      AND b.facility_id = ?      AND d.store_code LIKE UPPER (?)      AND UPPER (b.long_desc) LIKE UPPER (?)      AND a.item_code LIKE UPPER (?)      AND UPPER (c.short_desc) LIKE UPPER (?)      AND d.store_type_flag LIKE (?)      AND a.store_code = d.store_code      AND a.stock_item_yn LIKE (?)      AND c.item_class_code LIKE (?)      AND a.eff_status LIKE NVL (?, '%')      AND b.eff_status = c.eff_status      AND c.eff_status = 'E'");//MO-CRF-20172
		
		displayFields.add("store_code");
		displayFields.add("store_desc");
		displayFields.add("item_code");
		displayFields.add("item_desc");
		displayFields.add("stock_item_yn");
		displayFields.add("min_stk_qty");
		displayFields.add("max_stk_qty");
		displayFields.add("reorder_level");
		displayFields.add("stock_uom");
		displayFields.add("eff_status");
		displayFields.add("reorder_qty");
		displayFields.add("sales_allowed_yn");//Added for GHL-CRF-0456 
		displayFields.add("CONSUMPTION_ALLOWED_YN");//Added for GHL-CRF-0456 
		displayFields.add("NO_OF_DAYS");//MO-CRF-20172  

		chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(CommonBean.getLoginFacilityId());
		chkFields.add(store_code);
		chkFields.add(store_desc);
		chkFields.add(item_code);
		chkFields.add(item_desc);
		chkFields.add(store_type_code);
		chkFields.add(stock_item_yn);
		chkFields.add(item_class_code);
		chkFields.add(eff_status);

	
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
				<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ROQty.label" bundle="${st_labels}"/></th>
				<!--Added for GHL-CRF-0456 starts-->
				<th><fmt:message key="eST.Sales/PatientIssues.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.InternalConsumption.label" bundle="${st_labels}"/></th>
				<!--Added for GHL-CRF-0456 ends-->
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<!-- MO-CRF-20172 -->
				<th><fmt:message key="eST.NoOfDaysFromPrevReq.label" bundle="${common_labels}"/></th>  
				<%
						for(int recCount=2; recCount<result.size(); recCount++) {
							classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
						//	String link_columns = "1";
							records=(ArrayList) result.get(recCount);
							if( !temp_store.equals((String)records.get(1))) {
								temp_store = (String)records.get(1) ;
								out.println("<tr><td class='ITEMSELECT'  colspan='11'><b>"+temp_store+"</b></td></tr>");//MODIFIED Colspan to 11 for MO-CRF-20172 
							}
				%>
				<tr onClick="Modify(this);" >
				<td class="NODISPLAY"><%=records.get(0)%></td>
				<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer';" ><font class='HYPERLINK'><%=records.get(2)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(((String)records.get(4)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
				%>
				</td>
				<!--
					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Min Stock, Max Stock, RO Level,RO Qty .
										
					-->
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" ><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" ><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" ><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" ><%=CommonBean.checkForNull((String)records.get(10),"&nbsp;")%>&nbsp;</td>
				<!--Added for GHL-CRF-0456 starts-->
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(CommonBean.checkForNull((String)records.get(11)).equals("N"))
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
				%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(CommonBean.checkForNull((String)records.get(12)).equals("N"))
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
				%>
				</td>
				<!--Added for GHL-CRF-0456 ends-->
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(((String)records.get(9)).equals("E"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
				%>
				</td>
				
				<!-- MO-CRF-20172 start-->
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" ><%=CommonBean.checkForNull((String)records.get(13),"&nbsp;")%>&nbsp;</td>
				<!-- MO-CRF-20172 ends -->
							</tr>
		<%}%>
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
		<%}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ItemForStoreQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
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

