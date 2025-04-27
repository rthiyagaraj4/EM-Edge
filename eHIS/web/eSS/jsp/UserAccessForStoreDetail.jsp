<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap, eSS.Common.SsRepository, eCommon.Common.OptionValues,eSS.Common.*, eSS.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
	<title><fmt:message key="eSS.UserAccessforStoreListing.label" bundle="${ss_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eSS/js/UserAccessForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();">
<center>
	<form method=post name="UserAccessForStoreListForm" id="UserAccessForStoreListForm" action="">
	<%
	Properties		jdbc_props			=	null;
	String mode							=	"";
	String bean_id						=	"";
	String bean_name					=	"";

	String	store_code					=	"",		store_desc		=	"";
	String	classValue					=	"",		user_id			=	"";
	String	pre_allowed_yn				=	"",		req_allowed_yn	=	"";
	String	iss_allowed_yn				=	"",		rtg_allowed_yn	=	"";
	String	rti_allowed_yn				=	"",		trd_allowed_yn	=	"";
	String	adj_allowed_yn				=	"",		var_allowed_yn	=	"";
	String	rof_allowed_yn				=	"",		checkbox_yn		=	"";
	String  check_box_name				=   "",		Status			=	"N";
	String	pre_allowed_yn_r			=	"",		iss_ack_allowed_yn	=	"";
	String	req_allowed_yn_r			=	"",		iss_conf_allowed_yn	=	"";
	String	iss_allowed_yn_r			=	"",		ret_ack_allowed_yn	=	"";
	String	rtg_allowed_yn_r			=	"",		ret_conf_allowed_yn	=	"";
	String	rti_allowed_yn_r			=	"";
	String	trd_allowed_yn_r			=	"";
	String	adj_allowed_yn_r			=	"";
	String	var_allowed_yn_r			=   "";
	String	rof_allowed_yn_r			=	"";

	String	iss_ack_allowed_yn_r			=	"";
	String	iss_conf_allowed_yn_r			=	"";
	String	ret_ack_allowed_yn_r			=	"";
	String	ret_conf_allowed_yn_r			=	"";

	String rql_allowed_yn	=	"";
	String isl_allowed_yn	=	"";
	String rtl_allowed_yn	=	"";

	String	rql_allowed_yn_r			=	"";
	String	isl_allowed_yn_r			=	"";
	String	rtl_allowed_yn_r			=	"";
	
	String  isl_ack_allowed_yn	=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	String  isl_conf_allowed_yn	=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	String  rtl_ack_allowed_yn	=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	
	String	isl_ack_allowed_yn_r			=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	String	isl_conf_allowed_yn_r			=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	String	rtl_ack_allowed_yn_r			=	""; //Added by Sakti against BRU-HIMS-CRF-225.1
	
	String disabled = "";
	String checked = "";
	String rtl_disabled = "";
	String rtl_checked = "";

	String rqv_allowed_yn 			= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	String rqv_ack_allowed_yn  		= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015 
	String rtv_allowed_yn 			= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	String rqv_allowed_yn_r 		= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	String rqv_ack_allowed_yn_r		= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015 
	String rtv_allowed_yn_r			= 	"";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015


	boolean searched					=	false;
	int     i							=	0;
	int		recCount					=	0;
	/* Mandatory checks start */
	try{
	mode								=	request.getParameter( "mode" ) ;
	bean_id								=	"userAccessForStoreBean" ;
	bean_name							=	"eSS.UserAccessForStoreBean";
	if ( mode == null || mode.equals("") ) 
		return ;
	/* Mandatory checks end */

	
	/* Initialize Function specific start */
	UserAccessForStoreBean bean			=	(UserAccessForStoreBean)getBeanObject( bean_id, bean_name,request) ;  
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	user_id								=	CommonAdapter.checkForNull( request.getParameter("user_id") );
	jdbc_props							=	(Properties) session.getAttribute("jdbc");
	searched							=	(request.getParameter("searched") == null) ?false:true;

	putObjectInBean(bean_id,bean,request);

	HashMap sqlMap						=	new HashMap();
	sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_USER_FOR_STORE_STORE_LIST"));
	HashMap funcMap						=	new HashMap();

	//The fields are going to be display
	ArrayList displayFields				=	new ArrayList();

	displayFields.add("short_desc");
	displayFields.add("pre_allowed_yn");
	displayFields.add("req_allowed_yn");
	displayFields.add("iss_allowed_yn");
	displayFields.add("rtg_allowed_yn");
	displayFields.add("rti_allowed_yn");
	displayFields.add("trd_allowed_yn");
	displayFields.add("adj_allowed_yn");
	displayFields.add("var_allowed_yn"); 
	displayFields.add("rof_allowed_yn");
	displayFields.add("checkbox_yn");
	displayFields.add("store_code");

	displayFields.add("iss_acknowledge_yn");
	displayFields.add("iss_confirm_yn");
	displayFields.add("ret_acknowledge_yn");
	displayFields.add("ret_confirm_yn");

	displayFields.add("RQL_ALLOWED_YN");
	displayFields.add("ISL_ALLOWED_YN");
	displayFields.add("RTL_ALLOWED_YN");

	displayFields.add("rqv_allowed_yn"); //Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	displayFields.add("rqv_acknowledge_yn");//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	displayFields.add("rtv_allowed_yn");//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	
	displayFields.add("isl_acknowledge_yn"); //Added by Sakti against BRU-HIMS-CRF-225.1
	displayFields.add("isl_confirm_yn"); //Added by Sakti against BRU-HIMS-CRF-225.1
	displayFields.add("rtl_acknowledge_yn"); //Added by Sakti against BRU-HIMS-CRF-225.1
  //The fields are going to be in where condition * should match with the query
	ArrayList chkFields					=	new ArrayList();
	chkFields.add(user_id);

 // Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	ArrayList result					=	(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,10);

	

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding="0" cellspacing="0" width="95%" align="center">
			<tr>
				<td width="80%" class="white"></td>
				<td width="20%" class="white"><%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="115%" align="center">
			<tr>
				<th align="center"  width="100"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.Prepare.label" bundle="${ss_labels}"/><br><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="Common.Request.label" bundle="${common_labels}"/><br><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
				<%if(bean.getAckReqdForIssueGroup()) {%>
				<th align="center"  width="10%" nowrap ><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/><br><br><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%}else {%>
				<th align="center"  width="10" ><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/>
				<%} if(bean.getAckReqdForReturnGroup()) {%>
				<th align="center"  width="10%" nowrap ><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/><br><br><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%}else {%>
				<th align="center"  width="10" ><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/>
				<%}%>
				
				<th align="center"  width="10"><fmt:message key="eSS.RequestForLoan.label" bundle="${ss_labels}"/></th>
				<!-- 
				<th align="center"  width="10"><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></th> -->
				<!-- Added for CRF 225.1-->
				<%if(bean.getAckReqdForLoanIssueGroup()) {%>
				<th align="center"  width="10%" nowrap ><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/><br><br><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%}else {%>
				<th align="center"  width="10" ><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/>
				<%} if(bean.getAckReqdForLoanReturnGroup()) {%>
				<th align="center"  width="10%" ><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/><br><br><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/></br></th>
				<%}else {%>
				<th align="center"  width="10" ><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/>
				<%}%>
				<!-- Added ends-->
				<th align="center"  width="10%" nowrap ><fmt:message key="eSS.VendorLoan.label" bundle="${ss_labels}"/><br><br><fmt:message key="Common.Request.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.Return.label" bundle="${ss_labels}"/></br></th><!--Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015-->
				<th align="center"  width="10"><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/><br><fmt:message key="eSS.Instruments.label" bundle="${ss_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.Tray.label" bundle="${ss_labels}"/><br><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.Write.label" bundle="${ss_labels}"/><br><fmt:message key="eSS.off.label" bundle="${ss_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.Physical.label" bundle="${ss_labels}"/><br><fmt:message key="eSS.Variance.label" bundle="${ss_labels}"/></th>
				<th align="center"  width="10"><fmt:message key="eSS.SterilizationRequestProcessing.label" bundle="${ss_labels}"/></th>
			</tr>				   
			<%
				ArrayList records			=		new ArrayList();
				for(recCount=2,i=0; recCount<result.size(); recCount++,i++) {
				Status						=		"N";		
					if ( recCount % 2 == 0 )
						classValue			=		"QRYEVEN" ;
					else
						classValue			=		"QRYODD" ;

			%>																		
			<tr>
			<%
				records						=		(ArrayList) result.get( recCount );
			//System.out.println("records"+records);
				store_code					=		(String)records.get(11);
				store_desc					=		(String)records.get(0);
				pre_allowed_yn				=		(String)records.get(1);
				req_allowed_yn				=		(String)records.get(2);
				iss_allowed_yn				=		(String)records.get(3);
				rtg_allowed_yn				=		(String)records.get(4);
				rti_allowed_yn				=		(String)records.get(5);
				trd_allowed_yn				=		(String)records.get(6);
				adj_allowed_yn				=		(String)records.get(7);
				var_allowed_yn				=		(String)records.get(8);
				rof_allowed_yn				=		(String)records.get(9);
				checkbox_yn					=		(String)records.get(10);
				iss_ack_allowed_yn			=		(String)records.get(12);
				iss_conf_allowed_yn			=		(String)records.get(13);
				ret_ack_allowed_yn			=		(String)records.get(14);
				ret_conf_allowed_yn			=		(String)records.get(15);
				rql_allowed_yn				=		(String)records.get(16);
				isl_allowed_yn				=		(String)records.get(17);
				rtl_allowed_yn				=		(String)records.get(18);
				
				rqv_allowed_yn				=		(String)records.get(19);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn			=		(String)records.get(20);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn				=		(String)records.get(21);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015

				isl_ack_allowed_yn			=		(String)records.get(22); //Added by Sakti against BRU-HIMS-CRF-225.1
				isl_conf_allowed_yn			=		(String)records.get(23); //Added by Sakti against BRU-HIMS-CRF-225.1
				rtl_ack_allowed_yn			=		(String)records.get(24); //Added by Sakti against BRU-HIMS-CRF-225.1
				
				pre_allowed_yn_r			=		pre_allowed_yn.substring(1,2);
				req_allowed_yn_r			=		req_allowed_yn.substring(1,2);
				iss_allowed_yn_r			=		iss_allowed_yn.substring(1,2);
				rtg_allowed_yn_r			=		rtg_allowed_yn.substring(1,2);
				rti_allowed_yn_r			=		rti_allowed_yn.substring(1,2);
				trd_allowed_yn_r			=		trd_allowed_yn.substring(1,2);
				adj_allowed_yn_r			=		adj_allowed_yn.substring(1,2);
				var_allowed_yn_r			=		var_allowed_yn.substring(1,2);
				rof_allowed_yn_r			=		rof_allowed_yn.substring(1,2);
				iss_ack_allowed_yn_r		=		iss_ack_allowed_yn.substring(1,2);
				iss_conf_allowed_yn_r		=		iss_conf_allowed_yn.substring(1,2);
				ret_ack_allowed_yn_r		=		ret_ack_allowed_yn.substring(1,2);
				ret_conf_allowed_yn_r		=		ret_conf_allowed_yn.substring(1,2);
				rql_allowed_yn_r			=		rql_allowed_yn.substring(1,2);
				isl_allowed_yn_r			=		isl_allowed_yn.substring(1,2);
				rtl_allowed_yn_r			=		rtl_allowed_yn.substring(1,2);

				rqv_allowed_yn_r			=		rqv_allowed_yn.substring(1,2);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn_r		=		rqv_ack_allowed_yn.substring(1,2);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn_r			=		rtv_allowed_yn.substring(1,2);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
						
				isl_ack_allowed_yn_r		=		isl_ack_allowed_yn.substring(1,2);
				isl_conf_allowed_yn_r		=		isl_conf_allowed_yn.substring(1,2);
				rtl_ack_allowed_yn_r		=		rtl_ack_allowed_yn.substring(1,2);
			%>
			 <script>
				var arrayObject				=		new Array();
				arrayObject[0]				=		"<%=pre_allowed_yn.substring(1,2)%>";
				arrayObject[1]				=		"<%=req_allowed_yn.substring(1,2)%>";
				arrayObject[2]				=		"<%=iss_allowed_yn.substring(1,2)%>";
				arrayObject[3]				=		"<%=rtg_allowed_yn.substring(1,2)%>";
				arrayObject[4]				=		"<%=rti_allowed_yn.substring(1,2)%>";
				arrayObject[5]				=		"<%=trd_allowed_yn.substring(1,2)%>";
				arrayObject[6]				=		"<%=adj_allowed_yn.substring(1,2)%>";
				arrayObject[7]				=		"<%=var_allowed_yn.substring(1,2)%>";
				arrayObject[8]				=		"<%=rof_allowed_yn.substring(1,2)%>";

				arrayObject[9]				=		"<%=iss_ack_allowed_yn.substring(1,2)%>";
				arrayObject[10]				=		"<%=iss_conf_allowed_yn.substring(1,2)%>";
				arrayObject[11]				=		"<%=ret_ack_allowed_yn.substring(1,2)%>";
				arrayObject[12]				=		"<%=ret_conf_allowed_yn.substring(1,2)%>";

				arrayObject[13]				=		"<%=rql_allowed_yn.substring(1,2)%>";
				arrayObject[14]				=		"<%=isl_allowed_yn.substring(1,2)%>";
				arrayObject[15]				=		"<%=rtl_allowed_yn.substring(1,2)%>";
				
				arrayObject[16]				=		"<%=rqv_allowed_yn.substring(1,2)%>";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				arrayObject[17]				=		"<%=rqv_ack_allowed_yn.substring(1,2)%>";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				arrayObject[18]				=		"<%=rtv_allowed_yn.substring(1,2)%>";//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015

				arrayObject[19]				=		"<%=isl_ack_allowed_yn.substring(1,2)%>";
				arrayObject[20]				=		"<%=isl_conf_allowed_yn.substring(1,2)%>";
				arrayObject[21]				=		"<%=rtl_ack_allowed_yn.substring(1,2)%>";
				
				checkArray[<%=i%>]			=		arrayObject;
				//alert(arrayObject);
			 </script>
			<%
				 
				if(bean.isInlist(store_code)==null){
				pre_allowed_yn				=		pre_allowed_yn.substring(0,1);
				req_allowed_yn				=		req_allowed_yn.substring(0,1);
				iss_allowed_yn				=		iss_allowed_yn.substring(0,1);
				rtg_allowed_yn				=		rtg_allowed_yn.substring(0,1);
				rti_allowed_yn				=		rti_allowed_yn.substring(0,1);
				trd_allowed_yn				=		trd_allowed_yn.substring(0,1);
				adj_allowed_yn				=		adj_allowed_yn.substring(0,1);
				var_allowed_yn				=		var_allowed_yn.substring(0,1);
				rof_allowed_yn				=		rof_allowed_yn.substring(0,1);

				iss_ack_allowed_yn				=		iss_ack_allowed_yn.substring(0,1);
				iss_conf_allowed_yn				=		iss_conf_allowed_yn.substring(0,1);
				ret_ack_allowed_yn				=		ret_ack_allowed_yn.substring(0,1);
				ret_conf_allowed_yn				=		ret_conf_allowed_yn.substring(0,1);

				rql_allowed_yn					=		rql_allowed_yn.substring(0,1);
				isl_allowed_yn					=		isl_allowed_yn.substring(0,1);
				rtl_allowed_yn					=		rtl_allowed_yn.substring(0,1);
				
				rqv_allowed_yn				=		rqv_allowed_yn.substring(0,1);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn			=		rqv_ack_allowed_yn.substring(0,1);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn				=		rtv_allowed_yn.substring(0,1);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015

				isl_ack_allowed_yn				=		isl_ack_allowed_yn.substring(0,1);
				isl_conf_allowed_yn				=		isl_conf_allowed_yn.substring(0,1);
				rtl_ack_allowed_yn				=		rtl_ack_allowed_yn.substring(0,1);
		
				}
				else{
					
				if ((bean.isInlist(store_code)).size()==30)
				{
					
				ArrayList	arrInsList		=		bean.isInlist(store_code);
				pre_allowed_yn				=		(String)arrInsList.get(2);
				req_allowed_yn				=		(String)arrInsList.get(3);
				iss_allowed_yn				=		(String)arrInsList.get(4);
				rtg_allowed_yn				=		(String)arrInsList.get(5);
				rti_allowed_yn				=		(String)arrInsList.get(6);
				trd_allowed_yn				=		(String)arrInsList.get(7);
				adj_allowed_yn				=		(String)arrInsList.get(8);
				var_allowed_yn				=		(String)arrInsList.get(9);
				rof_allowed_yn				=		(String)arrInsList.get(10);

				iss_ack_allowed_yn				=		(String)arrInsList.get(11);
				iss_conf_allowed_yn				=		(String)arrInsList.get(12);
				ret_ack_allowed_yn				=		(String)arrInsList.get(13);
				ret_conf_allowed_yn				=		(String)arrInsList.get(14);

				rql_allowed_yn					=		(String)arrInsList.get(15);
				isl_allowed_yn					=		(String)arrInsList.get(16);
				rtl_allowed_yn					=		(String)arrInsList.get(17);
				
				rqv_allowed_yn					=		(String)arrInsList.get(18);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn				=		(String)arrInsList.get(19);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn					=		(String)arrInsList.get(20);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				
				isl_ack_allowed_yn				=		(String)arrInsList.get(21);
				isl_conf_allowed_yn				=		(String)arrInsList.get(22);
				rtl_ack_allowed_yn				=		(String)arrInsList.get(23);


				Status						=		"Y";			
				}
				else{
				ArrayList	arrUpdList		=		bean.isInlist(store_code);
				
				pre_allowed_yn				=		(String)arrUpdList.get(0);
				req_allowed_yn				=		(String)arrUpdList.get(1);
				iss_allowed_yn				=		(String)arrUpdList.get(2);
				rtg_allowed_yn				=		(String)arrUpdList.get(3);
				rti_allowed_yn				=		(String)arrUpdList.get(4);
				trd_allowed_yn				=		(String)arrUpdList.get(5);
				adj_allowed_yn				=		(String)arrUpdList.get(6);
				var_allowed_yn				=		(String)arrUpdList.get(7);
				rof_allowed_yn				=		(String)arrUpdList.get(8);

				iss_ack_allowed_yn				=		(String)arrUpdList.get(9);
				iss_conf_allowed_yn				=		(String)arrUpdList.get(10);
				ret_ack_allowed_yn				=		(String)arrUpdList.get(11);
				ret_conf_allowed_yn				=		(String)arrUpdList.get(12);

				rql_allowed_yn					=		(String)arrUpdList.get(13);
				isl_allowed_yn					=		(String)arrUpdList.get(14);
				rtl_allowed_yn					=		(String)arrUpdList.get(15);
				
				rqv_allowed_yn					=		(String)arrUpdList.get(16);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn				=		(String)arrUpdList.get(17);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn					=		(String)arrUpdList.get(18);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	
				isl_ack_allowed_yn				=		(String)arrUpdList.get(19);
				isl_conf_allowed_yn				=		(String)arrUpdList.get(20);
				rtl_ack_allowed_yn				=		(String)arrUpdList.get(21);

				}
				}

				pre_allowed_yn				=		getCheckBoxProperty(pre_allowed_yn, "pre_allowed_yn_"+i, checkbox_yn ,pre_allowed_yn_r); 
			 	req_allowed_yn				=		getCheckBoxProperty(req_allowed_yn, "req_allowed_yn_"+i, checkbox_yn ,req_allowed_yn_r); 
				iss_allowed_yn				=		getCheckBoxProperty(iss_allowed_yn, "iss_allowed_yn_"+i, checkbox_yn ,iss_allowed_yn_r); 
				rtg_allowed_yn				=		getCheckBoxProperty(rtg_allowed_yn, "rtg_allowed_yn_"+i, checkbox_yn ,rtg_allowed_yn_r); 
				rti_allowed_yn				=		getCheckBoxProperty(rti_allowed_yn, "rti_allowed_yn_"+i, checkbox_yn ,rti_allowed_yn_r); 
				trd_allowed_yn				=		getCheckBoxProperty(trd_allowed_yn, "trd_allowed_yn_"+i, checkbox_yn ,trd_allowed_yn_r); 
				adj_allowed_yn				=		getCheckBoxProperty(adj_allowed_yn, "adj_allowed_yn_"+i, checkbox_yn ,adj_allowed_yn_r); 
				var_allowed_yn				=		getCheckBoxProperty(var_allowed_yn, "var_allowed_yn_"+i, checkbox_yn ,var_allowed_yn_r); 
				rof_allowed_yn				=		getCheckBoxProperty(rof_allowed_yn, "rof_allowed_yn_"+i, checkbox_yn ,rof_allowed_yn_r);
				rql_allowed_yn				=		getCheckBoxProperty(rql_allowed_yn, "rql_allowed_yn_"+i, checkbox_yn ,rql_allowed_yn_r);
				isl_allowed_yn				=		getCheckBoxProperty(isl_allowed_yn, "isl_allowed_yn_"+i, checkbox_yn ,isl_allowed_yn_r);
				rtl_allowed_yn				=		getCheckBoxProperty(rtl_allowed_yn, "rtl_allowed_yn_"+i, checkbox_yn ,rtl_allowed_yn_r);

				rqv_allowed_yn				=		getCheckBoxProperty(rqv_allowed_yn, "rqv_allowed_yn_"+i, checkbox_yn ,rqv_allowed_yn_r);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rqv_ack_allowed_yn			=		getCheckBoxProperty(rqv_ack_allowed_yn, "rqv_ack_allowed_yn_"+i, checkbox_yn ,rqv_ack_allowed_yn_r);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				rtv_allowed_yn				=		getCheckBoxProperty(rtv_allowed_yn, "rtv_allowed_yn_"+i, checkbox_yn ,rtv_allowed_yn_r);//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015

				if(checkbox_yn.equals("Y")||!isl_allowed_yn_r.equals("Y")) {
					if(isl_allowed_yn==null || isl_allowed_yn.equals("") || isl_allowed_yn.equals("N")) {
						disabled = "disabled";
					}else{
						disabled = "disabled";
						checked = "";
					}
				}else{
					disabled = "";
					checked = "";
				}
				
				if(checkbox_yn.equals("Y")||!rtl_allowed_yn_r.equals("Y")) {
					if(rtl_allowed_yn==null || rtl_allowed_yn.equals("") || rtl_allowed_yn.equals("N")) {
						rtl_disabled = "disabled";
					}else{
						rtl_disabled = "disabled";
						rtl_checked = "";
					}
				}else{
					rtl_disabled = "";
					rtl_checked = "";
				}
				

		//iss_ack_allowed_yn			=		getCheckBoxProperty(iss_ack_allowed_yn, "iss_ack_allowed_yn_"+i, checkbox_yn ,iss_ack_allowed_yn_r);
		//iss_conf_allowed_yn			=		getCheckBoxProperty(iss_conf_allowed_yn, "iss_conf_allowed_yn_"+i, checkbox_yn ,iss_conf_allowed_yn_r);
		//ret_ack_allowed_yn			=		getCheckBoxProperty(ret_ack_allowed_yn, "ret_ack_allowed_yn_"+i, checkbox_yn ,ret_ack_allowed_yn_r);
		//ret_conf_allowed_yn			=		getCheckBoxProperty(ret_conf_allowed_yn, "ret_conf_allowed_yn_"+i, checkbox_yn ,ret_conf_allowed_yn_r); 


				check_box_name		=		"check_"+i;
			%>
				<input type="hidden" name=<%="store_id_"+i%> value="<%=store_code%>">

			<%
				if(checkbox_yn.equals("Y")) {
			%>
				<td class="<%=classValue%>"> <%=store_desc%></td>
						<td class="<%=classValue%>" > <input type="checkbox" name=<%=check_box_name%> value="Y" onClick="doDisable(this.checked,'<%=i%>','<%=bean.getAckReqdForLoanIssueGroup()%>','<%=bean.getAckReqdForLoanReturnGroup()%>')"> </td>			
			<%
					}
					else {
						
			%>
				<td class="<%=classValue%>"><font class="DATAHIGHLIGHT"><%=store_desc%></font></td>
						<input type="hidden" name=<%=check_box_name%> value="U">
						<td class="<%=classValue%>" >&nbsp;</td>
			<%
				
					}
			%>
				<td class="<%=classValue%>" align="CENTER"><%=pre_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=req_allowed_yn%></td>
				<%if(bean.getAckReqdForIssueGroup()) {%>
				<td class="<%=classValue%>" align="CENTER"><%=iss_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="iss_ack_allowed_yn_<%=i%>" id="iss_ack_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(iss_ack_allowed_yn))%> onclick="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="iss_conf_allowed_yn_<%=i%>" id="iss_conf_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(iss_conf_allowed_yn))%> onclick=""></td>
				<%}else {%>
				<td class="<%=classValue%>" align="CENTER"><%=iss_allowed_yn%>
				<%} if(bean.getAckReqdForReturnGroup()) {%>
				<td class="<%=classValue%>" align="CENTER"><%=rtg_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="ret_ack_allowed_yn_<%=i%>" id="ret_ack_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(ret_ack_allowed_yn))%> onclick="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="ret_conf_allowed_yn_<%=i%>" id="ret_conf_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(ret_conf_allowed_yn))%> onclick=""></td>
				<%}else {%>
				<td class="<%=classValue%>" align="CENTER"><%=rtg_allowed_yn%>
				<%}%> 
				<td class="<%=classValue%>" align="CENTER"><%=rql_allowed_yn%></td>
				<!--
				<td class="<%=classValue%>" align="CENTER"><%=isl_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=rtl_allowed_yn%></td> -->

				<%if(bean.getAckReqdForLoanIssueGroup()) {%>
				<td class="<%=classValue%>" onClick="" align="CENTER"><%=isl_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  name="isl_ack_allowed_yn_<%=i%>" id="isl_ack_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(isl_ack_allowed_yn))%> <%=disabled%> <%=checked%> onclick="" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" <%=disabled%> <%=checked%> name="isl_conf_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(isl_conf_allowed_yn))%> onclick=""></td>
				<%}else {%>
				<td class="<%=classValue%>" align="CENTER"><%=isl_allowed_yn%>
				<%} if(bean.getAckReqdForLoanReturnGroup()) {%>
				<td class="<%=classValue%>" align="CENTER"><%=rtl_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  name="rtl_ack_allowed_yn_<%=i%>" id="rtl_ack_allowed_yn_<%=i%>" value="Y"  <%=bean.checkForNull(bean.getChecked(rtl_ack_allowed_yn))%> <%=rtl_disabled%> <%=rtl_checked%> onclick=""></td>
				<%}else {%>
				<td class="<%=classValue%>" align="CENTER"><%=rtl_allowed_yn%>
				<%}%>

				<td class="<%=classValue%>" onClick="" align="CENTER"><%=rqv_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rqv_ack_allowed_yn%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rtv_allowed_yn%></td> <!--Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015-->
				<td class="<%=classValue%>" align="CENTER"><%=rti_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=trd_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=adj_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=var_allowed_yn%></td>
				<td class="<%=classValue%>" align="CENTER"><%=rof_allowed_yn%></td>
				
					
				<%
				if(Status.equals("Y")) {
					
			%>
				<script>doEnableForCheck(<%=i%>)</script>
			<%
					}
				}
 			%>
				</tr>
			<%
				out.flush();
				}
				else{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					history.go(-1);
				</script>
			  <%}%>
				</table>
					<input type="hidden" name="user_id" id="user_id"			value="<%=user_id%>"> 
					<input type="hidden" name="arr_size" id="arr_size"		value="<%=i%>">
					<input type="hidden" name="mode" id="mode"			value="<%=eCommon.Common.CommonRepository.getCommonKeyValue(mode)%>">
					<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
					<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
															
					
				</form>
			<%
				
			}
			catch(Exception e){
				e.printStackTrace();
			}


			   %>

</table>
<%			out.println(CommonBean.setForm ( request ,"../../eSS/jsp/UserAccessForStoreDetail.jsp", searched) );
  %>
</center>
</body>
</html>

<%!
	public String getCheckBoxProperty(String inputString, String check_name, String checkbox_yn,String right_yn)
	{
		if(checkbox_yn.equals("Y")||!right_yn.equals("Y"))
		{

			//System.out.println("inputString"+inputString);
			return (inputString==null || inputString.equals("") || inputString.equals("N"))	?	" <input type=\"checkbox\" name=\""+check_name+"\" id=\""+check_name+"\" value=\"Y\" disabled=\"y\" > "	:	" <input type=\"checkbox\" name=\""+check_name+"\" id=\""+check_name+"\" value=\"Y\" CHECKED disabled=\"y\" > ";
		}
		else
		{
			return (inputString==null || inputString.equals("") || inputString.equals("N"))	?	" <input type=\"checkbox\" name=\""+check_name+"\" id=\""+check_name+"\" value=\"Y\"  > "	:	" <input type=\"checkbox\" name=\""+check_name+"\" id=\""+check_name+"\" value=\"Y\" CHECKED> ";
		}
	}

	public void updateBean(HttpServletRequest request)
	{
	}


%>
</body>
</html>
 

