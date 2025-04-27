<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
----------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
----------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page    import="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*,eBL.Common.*"	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			
		String loginUserId=	(String)session.getAttribute("login_user");
		//System.out.println("loginUserId"+loginUserId);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String loginUserDesc="";
		String sys_date="";
		try{
			con = ConnectionManager.getConnection(request);
			
			String userQuery=" select APPL_USER_NAME from sm_appl_user where appl_user_ID='"+loginUserId+"' ";
			pstmt = con.prepareStatement(userQuery);
			rs = pstmt.executeQuery() ;
			
			
			if( rs != null ) 
			{
				while( rs.next())
				{ 	
				loginUserDesc=rs.getString("APPL_USER_NAME");
				}
			}
			
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";			
			pstmt = con.prepareStatement(query_date);
			rs = pstmt.executeQuery();			
			
			if( rs != null ) 
			{
				while( rs.next())
				{ 	
					sys_date = rs.getString(1);
				}
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception from Auto Fill Search Criteria :"+e);
			con.rollback();
		}
		finally
			{	
			if(rs != null ) rs.close();
			if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con, request);
			}
%>
<html>
<head>
<link rel='stylesheet' type='text/css'	href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eBL/js/BLPkgPriceQuery.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>

$(document).ready(function () {	
	$("#execute").click(function(){		
		if($("#dateId").val()=='' || $("#dateId").val() == null){
			alert("Please enter process date");
			return false;
		}
		 $("#PkgPriceQueryJoblistDiv").load("../../eBL/jsp/BLPkgPriceQueryResultJobList.jsp",
			{
			 userId:	$("#userId").val(),
			 jobId:		$("#jobId").val(),
			 date:	$("#dateId").val()
			 });		     
	 });	
});
</script>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
<div id='BLPkgPriceQueryDiv' >
	<form name="frmBLPkgPriceQueryForm" id="frmBLPkgPriceQueryForm">
		<table id="QueryCriteriaTable" width='100%' >			
		<th><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}" /></th>
		</table><br><br>
		<table id="tableheader" border="0" width="100%" cellspacing='0'	cellpadding='2'>	
		<tr>
			<td width="15%" class='label'><fmt:message key="Common.userid.label" bundle="${common_labels}" /></td>
			<td width="30%" class='fields'><input type='text' size='10' name='userId' id='userId'  id='userId' onblur="if(this.value != ''){fetchCodeDescriptionForUser(1);} else{fnClearCode(userName);}" value='<%=loginUserId%>' >&nbsp;&nbsp;<input type='text' size='20'  id='userName' name='userName' id='userName' value='<%=loginUserDesc%>' onblur="if(this.value != ''){fetchCodeDescriptionForUser(2);} else{fnClearCode(userId);}"><input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='fetchCodeDescriptionForUser(2);'></td>
			<td width="15%" class='label'><fmt:message key="eBL.JobId.label" bundle="${bl_labels}" /></td> <!--22-09-2020-->
			<td width="*" class='fields'><input type='text' size='10' name='jobId' id='jobId' id='jobId'>&nbsp;&nbsp;<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='fetchJobId()'></td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="eBL.ProcessDate.label" bundle="${bl_labels}" /></td> <!--22-09-2020-->
			<td  class='fields'><input type='text' size='20' name='date' id='date' value=<%=sys_date %> id='dateId' onblur='dateOnBlur(date);'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date');" style="'cursor: hand'" ><img src='../../eCommon/images/mandatory.gif' title='Test'></td>
			<td  class='label'></td>
			<td  class='fields'></td>
		</tr>
		<tr>
			<td  class='label'></td>
			<td  class='fields'><br><input type='button' name='execute' id='execute' id='execute' value='&nbsp;<fmt:message key="Common.Execute.label" bundle="${common_labels}" /> &nbsp;' ></td>
			<td  class='fields'>			 
			</td>
		</tr>
	</table><br>
</div>
	<input type=hidden name="getUserQry" id="getUserQry"  value="select code,description from (select bl_user_id code, appl_user_name description from sm_appl_user, bl_user where bl_user_id = appl_user_id ) where upper(description) like upper(?) and upper(code) like upper(?)">
	<input type=hidden name="getJobIdQry" id="getJobIdQry"  value="">
	<div id='PkgPriceQueryJoblistDiv'></div>
	</form>
</body>
</html><!--added by Nandhini-->

