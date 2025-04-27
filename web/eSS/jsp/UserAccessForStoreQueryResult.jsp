<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/UserAcessForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" >
<%
	String user_id        = request.getParameter("user_id");
	String appl_user_name = request.getParameter("appl_user_name");
	String store_code     = request.getParameter("store_code");
	String long_desc      = request.getParameter("long_desc");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	String bean_id="";
	String bean_name="";
	

	try{

		bean_id								=	"userAccessForStoreBean" ;
		bean_name							=	"eSS.UserAccessForStoreBean";
		UserAccessForStoreBean bean			=	(UserAccessForStoreBean)getBeanObject( bean_id, bean_name,request) ;

		user_id        	= CommonBean.checkForNull(user_id        )+"%";
		appl_user_name 	= CommonBean.checkForNull(appl_user_name )+"%";
		store_code     	= CommonBean.checkForNull(store_code     )+"%";
		long_desc     	= CommonBean.checkForNull(long_desc      )+"%";

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_USER_ACCESS_FOR_STORE_QUERY_RESULT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

			displayFields.add("user_id");
			displayFields.add("appl_user_name");
			displayFields.add("store_code");
			displayFields.add("long_desc");
			displayFields.add("pre_allowed_yn");
			displayFields.add("req_allowed_yn");
			displayFields.add("iss_allowed_yn");
			if(bean.getAckReqdForIssueGroup()){
			displayFields.add("iss_acknowledge_yn");
			displayFields.add("iss_confirm_yn");
			}
			displayFields.add("rtg_allowed_yn");

			if(bean.getAckReqdForReturnGroup()) {
			displayFields.add("ret_acknowledge_yn");
			displayFields.add("ret_confirm_yn");//Added by Sakti against PMG2014-CRF-0008
			}
			displayFields.add("rql_allowed_yn");
			displayFields.add("isl_allowed_yn");
			if(bean.getAckReqdForLoanIssueGroup()){
			displayFields.add("isl_acknowledge_yn");
			displayFields.add("isl_confirm_yn");
			}
			displayFields.add("rtl_allowed_yn");
			if(bean.getAckReqdForLoanReturnGroup()) {
			displayFields.add("rtl_acknowledge_yn");
			}

			displayFields.add("rqv_allowed_yn");//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
			displayFields.add("rqv_acknowledge_yn");//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
			displayFields.add("rtv_allowed_yn");//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
			
			displayFields.add("rti_allowed_yn");
			displayFields.add("trd_allowed_yn");
			displayFields.add("adj_allowed_yn");
			displayFields.add("var_allowed_yn"); 
			displayFields.add("rof_allowed_yn");


		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(store_code);
		chkFields.add(long_desc);
		chkFields.add(user_id);
		chkFields.add(appl_user_name);
		chkFields.add(locale);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0  align="center">
			<tr>
				<td width="80%" class="white" nowrap>&nbsp;</td>
				<td width="20%" class="white" nowrap>&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0"  align="center">
			<tr>
				<th align="center" width="10"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
				<th align="center" width="100"><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
				<th align="center" width="10"><fmt:message key="eSS.StoreCode.label" bundle="${ss_labels}"/></th>
				<th align="center" width="100"><fmt:message key="eSS.StoreDescription.label" bundle="${ss_labels}"/></th>
				<th align="center" width="10"><fmt:message key="eSS.PrepareGroup.label" bundle="${ss_labels}"/></th>
				<th align="center" width="10"><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></th>
				<%if(bean.getAckReqdForIssueGroup()){%>
				<th nowrap align="center" width="50%" colspan=3><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/><br>__________________________________<br><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%} else{%>
				<th  align="center" width="100" ><fmt:message key="eSS.IssueGroup.label"bundle="${ss_labels}"/></th>
				<%} if(bean.getAckReqdForReturnGroup()){%>
				<th  nowrap align="center" width="50%" colspan=3><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/><br>__________________________________<br><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%}else{%>
				<th   align="center" width="100" ><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/></th>
				<%}%>
				<th align="center" width="10"><fmt:message key="eSS.RequestForLoan.label" bundle="${ss_labels}"/></th>
				<!--
				<th align="center" width="10"><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/>	</th>
				<th align="center" width="10"><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></th> -->
				<%if(bean.getAckReqdForLoanIssueGroup()){%>
				<th nowrap align="center" width="50%" colspan=3><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/><br>__________________________________<br><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<fmt:message key="eSS.ConfirmAck.label" bundle="${ss_labels}"/></br></th>
				<%} else{%>
				<th  align="center" width="100" ><fmt:message key="eSS.IssueAgainstLoan.label"bundle="${ss_labels}"/></th>
				<%} if(bean.getAckReqdForLoanReturnGroup()){%>
				<th  nowrap align="center" width="50%" colspan=2><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/><br>_____________________<br><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/></br></th>
				<%}else{%>
				<th   align="center" width="100" ><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></th>
				<%}%>
<!--Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015-->
				<th nowrap align="center" width="50%" colspan=3><fmt:message key="eSS.VendorLoan.label" bundle="${ss_labels}"/><br>__________________________________<br><fmt:message key="Common.Request.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eSS.Return.label" bundle="${ss_labels}"/></br></th><!--Added ends -->
				<th align="center" width="10"><fmt:message key="eSS.ReturnInstruments.label" bundle="${ss_labels}"/>	</th>
				<th align="center" width="10"><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></th>
				<th align="center" width="10"><fmt:message key="eSS.WriteOff.label" bundle="${ss_labels}"/></th>
				<th align="center" width="10"><fmt:message key="eSS.PhysicalVariance.label" bundle="${ss_labels}"/>	</th>
				<th align="center" width="10">Sterilization Request Processing</th>
				</tr>
			<!--<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<th><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eST.Confirm.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eSS.Return.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eST.Confirm.label" bundle="${st_labels}"/></th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr> -->
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="parent.Modify(this);" >
		<%

				String link_columns = "3";
				records=(ArrayList) result.get( recCount );

				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
						

						

		<%
					}else{
		%>
						<td class="<%=classvalue%>" nowrap onclick="disableClick(event);"
						<%
						 //if gif has to be provided onmouseover="changeCursor(this);" ><font class='HYPERLINK' </font>
							if(colCount >= 4) {
								out.println(" align=\'center\' >");
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
							}
						
						%>

						</td>
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
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/UserAccessForStoreQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>
 

