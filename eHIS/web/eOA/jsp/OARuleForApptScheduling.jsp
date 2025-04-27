<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>        
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<%
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con=null;
		String rule_desc="";
		String no_weeks_for_rule="";
		String all_day_yn="Y";
		String all_day="selected";
		String currentday="";
		String record_exists="N";
		try{
			con=ConnectionManager.getConnection(request);
			Statement stmt=null;
			ResultSet rset=null;
			stmt=con.createStatement();
			String sql="select DESCRIPTION, NO_WEEKS_FOR_RULE, ALL_DAY_YN from oa_rule_appt_schedule";
			rset=stmt.executeQuery(sql);
			if(rset!=null && rset.next()){
				rule_desc=rset.getString("DESCRIPTION")==null?"":rset.getString("DESCRIPTION");
				no_weeks_for_rule=rset.getString("NO_WEEKS_FOR_RULE")==null?"":rset.getString("NO_WEEKS_FOR_RULE");
				all_day_yn=rset.getString("ALL_DAY_YN")==null?"":rset.getString("ALL_DAY_YN");
				record_exists="Y";
			}
			if(all_day_yn.equals("Y")){
				all_day="selected";
				currentday="";
			}else{
				all_day="";
				currentday="selected";
			}
	%>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eOA/js/OARuleForApptScheduling.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  OnMouseDown='CodeArrest();' onKeyDown ='lockKey()'>
		<form name='rule_based_appt_scheduling' id='rule_based_appt_scheduling' action='../../servlet/eOA.RuleForApptSchedulingServlet' method='post' target='messageFrame'>
			<table width='50%' cellpadding='0' cellspacing='0' border='0' align='center'>
				<tr><td class = 'label'><fmt:message key="eOA.RuleDescription.label" bundle="${oa_labels}"/></td><td class = 'fields'><input type='text' maxlength='20' size='20'/ name='rule_desc' id='rule_desc' value="<%=rule_desc%>"></td></tr>
				<tr><td class = 'label'><fmt:message key="eOA.NoofWeekstobeconsidrd.label" bundle="${oa_labels}"/></td><td class = 'fields'><input type='text' maxlength='2' size='2' onblur='CheckNum(this)' name='no_weeks_for_rule' id='no_weeks_for_rule' value="<%=no_weeks_for_rule%>"></td></tr>
				<tr><td class = 'label'><fmt:message key="eOA.Consider.label" bundle="${oa_labels}"/></td><td class = 'fields'><select name ="all_day_yn"><option value = 'Y' <%=all_day%>>All Days</option><option value = 'N' <%=currentday%>>Current Day</option></td></tr>
			</table>
			<input type ='hidden' name = "record_exists" value="<%=record_exists%>">
		</form>
	</body>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}%>
</html>

