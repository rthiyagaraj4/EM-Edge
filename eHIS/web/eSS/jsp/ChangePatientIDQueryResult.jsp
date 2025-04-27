<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale= (String)session.getAttribute("LOCALE");%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/ChangePatientID.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown='CodeArrest();'>

<%
	String doc_type_code		=		 request.getParameter("doc_type_code");
	String doc_no				=		 request.getParameter("doc_no");
	String group_type			=		 request.getParameter("group_type");
	String issue_group_code		=		 request.getParameter("issue_group_code");
	String tray_no				=		 request.getParameter("tray_no");
	String patient_id			=		 request.getParameter("patient_id");
	String store_code			=		 request.getParameter("store_code");//Bru-HIMS-CRF-360
	String patient_order		=		 request.getParameter("patient_order");//Bru-HIMS-CRF-360
	
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String classvalue			=		"";

	try{

		//Store_code			    =		CommonBean.checkForNull(Store_code,"%"		);//Bru-HIMS-CRF-360
		doc_type_code			=		CommonBean.checkForNull(doc_type_code,"%"		);
		doc_no					=		CommonBean.checkForNull(doc_no,"%"			);
		group_type				=		CommonBean.checkForNull(group_type,"%"		);
		issue_group_code		=		CommonBean.checkForNull(issue_group_code,	"%");
		tray_no					=		CommonBean.checkForNull(tray_no,"%"			);
		patient_id				=		CommonBean.checkForNull(patient_id,"%"		);
		
		HashMap sqlMap			=		new HashMap();
		HashMap funcMap			=		new HashMap();
	
		String sql = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ISSUE_DTL_QUERY_RESULT_CHANGE_PID");
		//Added by suresh.r on 09-10-2014 against Inc 52043 query tuning beg
		if(!doc_type_code.equals("%")){
			sql = sql+"AND i.doc_type_code ='"+doc_type_code+"' ";
		}
		if(!doc_no.equals("%")){
			sql = sql+"AND i.doc_no ='"+doc_no+"' ";
		}
		if(!group_type.equals("%")){
			sql = sql+"AND group_type ='"+group_type+"' ";
		}
		if(!issue_group_code.equals("%")){
			sql = sql+"AND issue_group_code ='"+issue_group_code+"' ";
		}
		if(!tray_no.equals("%")){
			sql = sql+"AND i.tray_no ='"+tray_no+"' ";
		}
		if(!patient_id.equals("%")){
			sql = sql+"AND i.patient_id ='"+patient_id+"' ";
		}
		//Added by suresh.r on 09-10-2014 against Inc 52043 query tuning end
		if(patient_order.equals("Y")){
			sql = sql+"AND i.patient_id IS NOT NULL";
		}else if(patient_order.equals("N")){
			sql = sql+"AND i.patient_id IS  NULL";
		}
		sqlMap.put("sqlData", sql );

		//The fields are going to be display

		ArrayList displayFields =		new ArrayList();

		displayFields.add("doc_type_desc");
		displayFields.add("doc_no");
		displayFields.add("REQ_DOC_NO");//Bru-HIMS-CRF-360
		//displayFields.add("PRE_DOC_NO");//Bru-HIMS-CRF-360
		displayFields.add("sterilize_doc_no");//Bru-HIMS-CRF-360
		displayFields.add("group_type");
		displayFields.add("issue_group_desc");
		displayFields.add("tray_no");
		displayFields.add("patient_id");
		displayFields.add("doc_type_code");
		displayFields.add("issue_group_code");
		displayFields.add("patient_name"); //Bru-HIMS-CRF-360

		//The fields are going to be in where condition * should match with the query

		ArrayList chkFields		=		new ArrayList();

		chkFields.add(locale); //Bru-HIMS-CRF-360
		chkFields.add((String)session.getAttribute("facility_id"));
		chkFields.add(store_code); //Bru-HIMS-CRF-360
		//Commented by suresh.r on 09-10-2014 against Inc 52043 query tuning
		/* chkFields.add(doc_type_code		);
		chkFields.add(doc_no			);
		chkFields.add(group_type		);
		chkFields.add(issue_group_code	);
		chkFields.add(tray_no			);
		chkFields.add(patient_id		); 
		Commented by suresh.r on 09-10-2014 against Inc 52043 query tuning end*/
		chkFields.add((String)session.getAttribute("login_user")); //Bru-HIMS-CRF-360
		chkFields.add(locale); //Bru-HIMS-CRF-360
		
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
				<th><fmt:message key="eSS.IssDocType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.IssDocNo.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.ReqDocNo.label" bundle="${ss_labels}"/></th>
				<!--<th><fmt:message key="eSS.PreDocNo.label" bundle="${ss_labels}"/></th>-->
				<th><fmt:message key="eSS.SterilizationDocNo.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<!-- //Bru-HIMS-CRF-360 -->
				<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
				 
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if((colCount==8)||(colCount==9)){
						%>
						<td class='NODISPLAY'><%=(String)records.get( colCount )%></td>	
						<%
						continue;
					}
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);" align="<%=((colCount==1)||(colCount==4))?"right":"left"%>"
						<%
						 //if gif has to be provided
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
						
						%></td>
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ChangePatientIDQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>
 

