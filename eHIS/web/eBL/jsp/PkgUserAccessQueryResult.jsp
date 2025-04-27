<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/PkgUserAccess.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var user_id			= obj.cells[0].innerText;
		var user_grp_id	= obj.cells[2].innerText;
		document.location.href="../../eBL/jsp/PkgUserAccessAddModify.jsp?mode=modify&user_id="+user_id+"&user_grp_id="+user_grp_id;
	}
	</script>
</head> 
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	request.setCharacterEncoding("UTF-8");
    String user_id  = request.getParameter("user_id");
    String user_name  = request.getParameter("user_name");
	String user_grp_id  = request.getParameter("user_grp_id");
	String user_grp_name  = request.getParameter("user_grp_name");
	String package_creation   = request.getParameter("package_creation");
	String package_approval   = request.getParameter("package_approval");
	String package_transfer   = request.getParameter("package_transfer");
	String package_discount   = request.getParameter("package_discount");
	String package_refund   = request.getParameter("package_refund");
	String package_cancel   = request.getParameter("package_cancel");
	String package_adhoc_refund   = request.getParameter("package_adhoc_refund");
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");

	if(user_id != null){user_id = user_id.trim();}
	if(user_name == null){user_name = "";}else{user_name = user_name.trim();}
	if(user_grp_id == null){user_grp_id = "";}else{user_grp_id = user_grp_id.trim();}
	if(user_grp_name == null){user_grp_name = "";}else{user_grp_name = user_grp_name.trim();}
	if(package_creation == null){package_creation = "";}else{package_creation = package_creation.trim();}
	if(package_approval == null){package_approval = "";}else{package_approval = package_approval.trim();}
	if(package_transfer == null){package_transfer = "";}else{package_transfer = package_transfer.trim();}
	if(package_discount == null){package_discount = "";}else{package_discount = package_discount.trim();}
	if(package_refund == null){package_refund = "";}else{package_refund = package_refund.trim();}
	if(package_cancel == null){package_cancel = "";}else{package_cancel = package_cancel.trim();}
	if(package_adhoc_refund == null){package_adhoc_refund = "";}else{package_adhoc_refund = package_adhoc_refund.trim();}

	boolean searched = request.getParameter( "searched" ) == null ? false : true;

	try{
		String classvalue			= "";

		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", "select b.bl_user_id user_id, a.appl_user_name user_name, b.user_group_id user_grp_id, c.short_desc user_grp_name,b.package_creation package_creation,b.package_approval package_approval,b.package_transfer package_transfer,b.package_discount package_discount,b.package_refund package_refund,b.package_cancel  package_cancel,b.package_adhoc_refund  package_adhoc_refund from sm_appl_user_lang_vw a, bl_user b, bl_user_group_lang_vw c where a.appl_user_id=b.bl_user_id and b.user_group_id=c.user_group_id and  b.operating_facility_id=? and a.language_id=? and c.language_id=?  and upper(b.bl_user_id) like upper(?) and upper(a.appl_user_name) like upper(?) and upper( b.user_group_id ) like upper(?) and upper (c.short_desc ) like upper(?) and upper (NVL(b.package_creation,'N')) like upper(?) and upper (NVL(b.package_approval,'N')  ) like upper(?) and upper (NVL(b.package_transfer,'N') ) like upper(?) and upper (NVL(b.package_discount,'N') ) like upper(?) and upper (NVL(b.package_refund,'N')  ) like upper(?) and upper (NVL(b.package_cancel,'N') ) like upper(?)  and upper (NVL(b.package_adhoc_refund,'N')  ) like upper(?) ");

		//Function Parameters
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "user_id" );
		displayFields.add( "user_name" );
		displayFields.add( "user_grp_id" );
		displayFields.add( "user_grp_name" );
		displayFields.add( "package_creation" );
		displayFields.add( "package_approval" );
		displayFields.add( "package_transfer" );
		displayFields.add( "package_discount" );
		displayFields.add( "package_refund" );
		displayFields.add( "package_cancel" );
		displayFields.add( "package_adhoc_refund" );

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( facility_id);
		chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add( user_id + "%");
		chkFields.add( user_name + "%");
		chkFields.add( user_grp_id + "%");
		chkFields.add( user_grp_name + "%");
		chkFields.add( package_creation );
		chkFields.add( package_approval );
		chkFields.add( package_transfer );
		chkFields.add( package_discount);
		chkFields.add( package_refund );
		chkFields.add( package_cancel);
		chkFields.add( package_adhoc_refund);
		//Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table class='grid' width="100%">
		<th class='columnheader'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.userGroupId.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.userGroupName.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageCreation.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.packageApproval.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageTransfer.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageRefund.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageCancel.label" bundle="${bl_labels}"/></th>
		<th class='columnheader'><fmt:message key="eBL.PackageAdhocRefund.label" bundle="${bl_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="Modify(this);" >
	<%
		String link_columns = "1";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><a class='gridLink' href='#'><%=(String)records.get(colCount)==null ? "N" :(String)records.get(colCount)%> </a></td>
	<%
		}else{
	%>
		<td class="<%=classvalue%>"  onclick="disableClick(event);">
		<%
		out.println((String)records.get(colCount)==null ? "N" :(String)records.get(colCount));
		%>	
		</td>
	<%
			}
		}
	%>
		</tr>
	<%}%>
		</table>
			<%out.flush();
		}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);
			</script>
		<%}out.println(CommonBean.setForm(request ,"../../eBL/jsp/PkgUserAccessQueryResult.jsp", searched));
	}
	catch(Exception e) {
		System.out.print("Exception @ PkgUserAccessQueryResult.jsp :"+e.toString());
		e.printStackTrace();
	}
	%>
</body>
</html>

