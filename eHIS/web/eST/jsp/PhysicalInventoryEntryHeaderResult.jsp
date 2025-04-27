<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.lang.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>

		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body>
	<form>
	<%
		String phy_inv_id = request.getParameter("phy_inv_id");
		String store_code = request.getParameter("store_code");
		String item_code = request.getParameter( "item_code");
		String language_id = request.getParameter( "language_id");

		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			phy_inv_id = CommonBean.checkForNull(phy_inv_id);
			store_code = CommonBean.checkForNull(store_code);
			item_code = CommonBean.checkForNull(item_code);

			sqlMap.put("sqlData",eST.Common.StRepository.getStKeyValue("SQL_ST_PHYSICAL_INVENTORY_ENTRY_PHY_ID_SELECT_HDR"));

			chkFields.add(phy_inv_id);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(language_id);
			
			displayFields.add("phy_inv_id");
			displayFields.add("store_desc");
			displayFields.add("item_desc");
			displayFields.add("store_code");
			displayFields.add("item_code");
			
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
			%>
			<table cellpadding=0 cellspacing=0 width="99%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align=center>
				<tr>
					<th width="170"><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></th>
					<th width="175"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
					<th width="175"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
		for(int recCount=2,idx=0; recCount<result.size(); recCount++,idx++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>

			<tr onClick="Modify(this,<%=idx%>);" >

		<%
		String link_columns = "1";
		records=(ArrayList) result.get( recCount );
		for(int colCount=0; colCount<3; colCount++)
			{
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
			{
			%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" >
			<font class='HYPERLINK'>
			&nbsp;&nbsp;&nbsp;<%=(String)records.get( colCount )%></font></td>
			<%
			}else{
			%>
			<td class="<%=classvalue%>" onclick="disableClick(event);">
			<%=records.get(colCount)%></td>
			<%
			}
			}
		%>
			
			<input type="hidden" name="store_desc_<%=idx%>" id="store_desc_<%=idx%>" value="<%=records.get(1)%>">
			<input type="hidden"  name="item_desc_<%=idx%>" id="item_desc_<%=idx%>" value="<%=records.get(2)%>">
			<input type="hidden" name="store_code_<%=idx%>" id="store_code_<%=idx%>" value="<%=records.get(3)%>">
			<input type="hidden"  name="item_code_<%=idx%>" id="item_code_<%=idx%>" value="<%=records.get(4)%>">
				</tr>
		<%
			}
		%>
		</table>
		</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/PhysicalInventoryEntryHeaderResult.jsp", searched) );
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

