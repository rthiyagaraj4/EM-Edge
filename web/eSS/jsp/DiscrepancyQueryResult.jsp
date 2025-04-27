<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%-- JSP Page specific attributes start --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.lang.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>


<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		
<%
			request.setCharacterEncoding("UTF-8");
			String locale				=		(String)session.getAttribute("LOCALE");
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eSS/js/Discrepancy.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()">
<%
		String group_desc				=		"";
		String group_type				=		request.getParameter( "group_type" ) ;
		String group_code				=		request.getParameter( "group_code" ) ;
		
		String tray_no					=		request.getParameter( "tray_no" ) ;
		String owner_store_code			=		request.getParameter( "owner_store_code" ) ;
		String discrepancy				=		request.getParameter( "discrepancy" ) ;
		String entered_requestor		=		request.getParameter( "entered_requestor" ) ;
		
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;

	
try{
		String classvalue				=		"";
		String facility_id				=		"";
		facility_id						=		(String) session.getAttribute("facility_id");
		
		group_type						=		CommonBean.checkForNull( group_type,"%" );
		group_code						=		CommonBean.checkForNull( group_code,"%" );
		tray_no							=		CommonBean.checkForNull( tray_no,"%" );
		owner_store_code				=		CommonBean.checkForNull( owner_store_code,"%" );
		discrepancy						=		CommonBean.checkForNull( discrepancy,"%" );
		entered_requestor				=		CommonBean.checkForNull( entered_requestor,"%");

	
	//Common parameters.
		HashMap sqlMap					=		new HashMap();

	//include all the common parameters.
		sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_TRAY_DISCREPANCY_QUERY"));
		
		
	//Function Parameters
		HashMap funcMap					=		new HashMap();

	//The fields are going to be display
		ArrayList displayFields			=		new ArrayList();

		displayFields.add( "group_desc"	);
		displayFields.add( "item_code"	);
		displayFields.add( "item_desc" );
		displayFields.add( "discrepancy_desc" );
		displayFields.add( "remarks" );
		displayFields.add( "patient_id" );
		displayFields.add( "encounter_id" );
		displayFields.add( "billing_type" );
		displayFields.add( "org_doc_no" );
		displayFields.add( "charge_amt" );
		displayFields.add( "group_type" );
		displayFields.add( "tray_no" );
		displayFields.add( "entered_at_store_desc" );
		displayFields.add( "owner_stor_desc" );
		displayFields.add( "doc_type_desc" );
		displayFields.add( "discrepancy_qty" );
		displayFields.add( "discrepancy_type" );

	//The fields are going to be in where condition * should match with the query
		ArrayList chkFields				=		new ArrayList();

		chkFields.add( facility_id );
		chkFields.add( group_type );
		chkFields.add( group_code );
		chkFields.add( tray_no);
		chkFields.add( discrepancy);	
		chkFields.add( entered_requestor);	
		chkFields.add( owner_store_code);
		chkFields.add( locale);
		
	
	// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
		//out.println( result);
		if( (result.size()>0) && ( !( ((String) result.get(0)).equals("0")) )){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
		<%
			// For display the previous/next link
			 out.println(result.get(1));

		%>
			</td></tr>
			</table>

			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<th nowrap><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<!-- <th nowrap>Item</th> -->
			<th nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/> </th>
			<th nowrap><fmt:message key="eSS.DiscrepancyQty.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="eSS.BillingType.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="Common.amount.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="eSS.EnteredAt.label" bundle="${ss_labels}"/></th>
			<th nowrap><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></th>
		<%
			//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			group_desc = "";
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				records=(ArrayList) result.get( recCount );
				//out.println("Records"+(String)records.get(0));
				if( !group_desc.equals((String)records.get(0)) ) {
					group_desc = (String)records.get(0) ;
					out.println("<tr><td class='ITEMSELECT'  colspan='15'><b>"+group_desc+"</b></td></tr>");
				}

				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				
		%>
				<tr >
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(10),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(11),"&nbsp;")%></td>
					<!-- <td nowrap class="<%=classvalue%>"><%=records.get(1)%></td> -->
					<td nowrap class="<%=classvalue%>"><%=records.get(2)%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(15),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(16),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(14),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(8),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(9),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(12),"&nbsp;")%></td>
					<td nowrap class="<%=classvalue%>" ><%=CommonBean.checkForNull((String)records.get(13),"&nbsp;")%></td>
				</tr> 
		<%
			}
		%>
			</table>
		<%
			out.flush();
		} else{
		%>
			 <script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/DiscrepancyQueryResult.jsp", searched) );
	} catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
	%>
</body>
</html>

