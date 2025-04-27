<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eSS.* " %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language="javascript" src="../../eSS/js/CancelCountSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest();'>
	<form name="formQueryResultHeader" id="formQueryResultHeader">
	<%
		String bean_id			= "cancelCountSheet";
		String bean_name		= "eSS.CancelCountSheetBean";

		String mode				= request.getParameter("mode");
		String function_id		= request.getParameter("function_id");
		String phy_inv_id		= request.getParameter("phy_inv_id");
		String group_code		= request.getParameter("group_code");
		String owner_store_code = request.getParameter("owner_store_code");
		String curr_store_code  = request.getParameter( "current_store_code");

		boolean searched		= (request.getParameter("searched") == null) ?false:true;
		String classvalue		= "";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			phy_inv_id			= CommonBean.checkForNull(phy_inv_id,"%");
			group_code			= CommonBean.checkForNull(group_code,"%");
			owner_store_code	= CommonBean.checkForNull(owner_store_code,"%");
			curr_store_code		= CommonBean.checkForNull(curr_store_code,"%");

			HashMap sqlMap		 = new HashMap();

			sqlMap.put("sqlData",eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_HDR_CANCEL_COUNT_QUERY_RESULT"));

			HashMap funcMap = new HashMap();
			ArrayList chkFields = new ArrayList();
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(phy_inv_id);
			chkFields.add(owner_store_code);
			chkFields.add(curr_store_code);
			//Cancel Request

			ArrayList displayFields = new ArrayList();
			displayFields.add("phy_inv_id");
			displayFields.add("owner_desc");
			displayFields.add("curr_desc");
			displayFields.add("group_desc");
			displayFields.add("store_code");
			displayFields.add("curr_store_code");
			displayFields.add("group_code");

			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="98%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="98%" align="center">
				<tr>
					<th width="200"><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></th>
					<th width="200"><fmt:message key="Common.current.label" bundle="${common_labels}"/></th>
					<th width="200"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th width="65"><input type="checkbox" name="check_all" id="check_all" onClick="checkAll();"><br><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			int idx = 0;
			int recCount=0;
			ArrayList records=new ArrayList();
			for(idx=0,recCount=2; recCount<result.size(); recCount++,idx++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr>
		<%
//			String link_columns = "1";
			records=(ArrayList) result.get( recCount );
				for(int colCount=1; colCount<4; colCount++){
		%>
					<td class="<%=classvalue%>"><%=records.get(colCount )%></td>
		<%
				}
		%>
			<td class="<%=classvalue%>" align="center"><input type="checkbox" name="count_<%=idx%>" id="count_<%=idx%>" value="<%=records.get(0)%>-<%=records.get(4)%>-<%=records.get(5)%>-<%=records.get(6)%>"></td>
			<input type="hidden" name="owner_store_code_<%=idx%>" id="owner_store_code_<%=idx%>" value="<%=records.get(4)%>">
			<input type="hidden" name="current_store_code_<%=idx%>" id="current_store_code_<%=idx%>" value="<%=records.get(5)%>">
			<input type="hidden" name="group_code_<%=idx%>" id="group_code_<%=idx%>" value="<%=records.get(6)%>">
		</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="facility_id" id="facility_id" value="<%=CommonBean.getLoginFacilityId()%>">
		<input type="hidden" name="phy_inv_id" id="phy_inv_id" value="<%=phy_inv_id%>">
		<input type="hidden" name="max_rows" id="max_rows" value="<%=idx%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
		<input type="hidden" name="hasNext" id="hasNext" value="<%=(((String)result.get(1)).trim()).length()%>">
		</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common'));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/CancelCountSheetQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

