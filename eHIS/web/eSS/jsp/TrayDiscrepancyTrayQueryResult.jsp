<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale			= (String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/TrayDiscrepancy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()">
<%
	String group_code			=	 request.getParameter("group_code");
	String tray_no				=	 request.getParameter("tray_no");
	String owner_store_code		=	 "";
	String current_store_code	=	 request.getParameter("store_code");
	String bin_location_code	=	 request.getParameter("bin_location_code");
	String expiry_date			=	 request.getParameter("expiry_date");


	boolean searched			=	(request.getParameter("searched") == null) ?false:true;
	String classvalue			=	"";

	try{

		group_code										=	 CommonBean.checkForNull(group_code		,"%"	);
		tray_no											=	 CommonBean.checkForNull(tray_no			,"%"	);
		owner_store_code								=	 CommonBean.checkForNull(owner_store_code	,"%"	);
		bin_location_code								=	 CommonBean.checkForNull(bin_location_code ,"%"	);
		expiry_date										=	 CommonBean.checkForNull(expiry_date		,"%"	);
		//InstrUsageDiscrepancyUnitsDetailBean bean		=	 (InstrUsageDiscrepancyUnitsDetailBean) getBeanObject( "InstrUsageDiscrepancyUnitsDetailBean",   "eSS.InstrUsageDiscrepancyUnitsDetailBean",request); 
		//owner_store_code								=	 bean.getOwnerStoreCode(current_store_code,tray_no,group_code);
				current_store_code = CommonBean.checkForNull(current_store_code		,"%"	);
		owner_store_code								=	 CommonBean.checkForNull(owner_store_code		,"%"	);
		HashMap sqlMap			=	 new HashMap();
		//sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_QUERY_RESULT_FOR_TRD") );

if (!(current_store_code.length() >0 && current_store_code.equalsIgnoreCase("%"))){
		sqlMap.put("sqlData", "SELECT td.tray_no, td.group_code, td.bin_location_code, TO_CHAR(td.expiry_date,'dd/mm/yyyy') expiry_date, sg.short_desc group_desc, ms.short_desc owner_store_desc, mb.short_desc bin_location_desc FROM ss_tray_dtls td, ss_group sg, mm_store ms,mm_bin_location mb WHERE nvl(td.curr_store_code,td.owner_store_code) LIKE UPPER(?) and td.group_code LIKE UPPER(?) AND TO_CHAR(td.tray_no) like (?) AND td.bin_location_code LIKE UPPER(?) AND nvl(TO_CHAR(td.expiry_date,'dd/mm/yyyy'),'%') like ? AND  status NOT IN ('R','W') AND td.phy_inv_id IS NULL AND td.group_code=sg.group_code AND td.owner_store_code=ms.store_code AND td.owner_store_code=mb.store_code AND td.bin_location_code=mb.bin_location_code");	
}else{
		sqlMap.put("sqlData","SELECT td.tray_no, td.group_code, td.bin_location_code, TO_CHAR(td.expiry_date,'dd/mm/yyyy') expiry_date, sg.short_desc group_desc, ms.short_desc owner_store_desc, mb.short_desc bin_location_desc FROM ss_tray_dtls td, ss_group sg, mm_store ms,mm_bin_location mb WHERE td.curr_store_code is null AND td.owner_store_code LIKE UPPER(?) AND td.group_code LIKE UPPER(?) AND TO_CHAR(td.tray_no) like ? AND td.bin_location_code LIKE UPPER(?) AND nvl(TO_CHAR(td.expiry_date,'dd/mm/yyyy'),'%') like ? AND  status NOT IN ('R','W') AND td.phy_inv_id IS NULL AND td.group_code=sg.group_code AND td.owner_store_code=ms.store_code AND td.owner_store_code=mb.store_code AND td.bin_location_code=mb.bin_location_code");	
}

		HashMap funcMap			=	 new HashMap();

		//The fields are going to be display
		ArrayList displayFields =	new ArrayList();

		displayFields.add("tray_no");
		displayFields.add("group_desc");
		displayFields.add("owner_store_desc");
		displayFields.add("bin_location_desc");
		displayFields.add("expiry_date");


		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		
		if (!(current_store_code.length() >0 && current_store_code.equalsIgnoreCase("%"))){
			chkFields.add(current_store_code	);
		}else{
			chkFields.add(current_store_code	);
		}

		chkFields.add(group_code		);
		chkFields.add(tray_no			);		
		chkFields.add(bin_location_code	);
		chkFields.add(expiry_date		);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="returnTrayNo(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				String doc_date_disp = (String)records.get(4);
				if(doc_date_disp==null)doc_date_disp="";
				 if(!(locale.equals("en")))
				{
					 doc_date_disp=com.ehis.util.DateUtils.convertDate(doc_date_disp,"DMY","en",locale);
					 if(doc_date_disp==null)doc_date_disp="";
					 
				}
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" align="right" ><font class='HYPERLINK'><%=(String)records.get( 0 )%></font></td>
						<td class="<%=classvalue%>" align="left" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(1),"&nbsp;")%></td>
						<td class="<%=classvalue%>" align="left" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
						<td class="<%=classvalue%>" align="left" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
						<td class="<%=classvalue%>" align="center" onclick="disableClick(event);" ><%=CommonBean.checkForNull(doc_date_disp,"&nbsp;")%></td>
		
								
		<%
						}
					}
		%>
			</tr>
		<%
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
				self.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/TrayDiscrepancyTrayQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

