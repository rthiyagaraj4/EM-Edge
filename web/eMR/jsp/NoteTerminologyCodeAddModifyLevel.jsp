<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/NoteTerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
	//String readOnly = "" ;
	//String checked = "checked" ;
	
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id") ;


	String sql_level = "select  '1' code1 ,LEVEL_1_DESC   descr  ,LEVEL_1_CODE_LENGTH  LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_1_DESC is not null  and eff_status = 'E' union  select  '2' code2 ,LEVEL_2_DESC descr  ,LEVEL_2_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_2_DESC is not null  and eff_status = 'E' union select  '3' code ,LEVEL_3_DESC descr  ,LEVEL_3_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_3_DESC is not null  and eff_status = 'E' union select  '4' code3 ,LEVEL_4_DESC descr ,LEVEL_4_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_4_DESC is not null  and eff_status = 'E' union select  '5' code3 ,LEVEL_5_DESC descr  ,LEVEL_5_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_5_DESC is not null  and eff_status = 'E' union select  '6' code  ,LEVEL_6_DESC descr ,LEVEL_6_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_6_DESC is not null  and eff_status = 'E' union select  '7' code ,LEVEL_7_DESC descr  ,LEVEL_7_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_7_DESC is not null  and eff_status = 'E' union select  '8' code ,LEVEL_8_DESC descr  ,LEVEL_8_CODE_LENGTH LENGTH from mr_term_set  where   term_Set_id =(?) and LEVEL_8_DESC is not null  and eff_status = 'E' union select  '9' code ,LEVEL_9_DESC descr  ,LEVEL_9_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_9_DESC is not null  and eff_status = 'E' union select  '10' code ,LEVEL_10_DESC descr  ,LEVEL_10_CODE_LENGTH LENGTH from mr_term_Set where term_Set_id =(?) and LEVEL_10_DESC is not null  and eff_status = 'E'  order by 1";

	Connection con = null;
	PreparedStatement pstmt_term=null;
	ResultSet rs_level = null;
	
	con = ConnectionManager.getConnection(request);
	//pstmt_dept = con.prepareStatement(sql_dept);
	//pstmt_serv = con.prepareStatement(sql_serv);
	pstmt_term = con.prepareStatement(sql_level);
	pstmt_term.setString(1,term_set_id);
	pstmt_term.setString(2,term_set_id);
	pstmt_term.setString(3,term_set_id);
	pstmt_term.setString(4,term_set_id);
	pstmt_term.setString(5,term_set_id);
	pstmt_term.setString(6,term_set_id);
	pstmt_term.setString(7,term_set_id);
	pstmt_term.setString(8,term_set_id);
	pstmt_term.setString(9,term_set_id);
	pstmt_term.setString(10,term_set_id);
	
	rs_level = pstmt_term.executeQuery();

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {

//		String ord_cat			= request.getParameter("ord_cat");
//		String ord_cat_desc		= request.getParameter("ord_cat_desc");
//		String order_type		= request.getParameter("order_type");
//		String ord_typ_code		= request.getParameter("ord_typ_code_val");

	}
%>

<form name='terminology_level' id='terminology_level' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr><tr>
	<%
	int i=0;
	while(rs_level.next()){
		if(i % 2 == 0 && i!=0){%>
			</tr><tr>
		<%}
		
	%>
	
		<td width=""  align=right class="label"><%=rs_level.getString(2)%>&nbsp;</td>
		<input type=hidden name='level_code<%=i%>' id='level_code<%=i%>' value='<%=rs_level.getString(1)%>'>
		<td>
			<input type=text name='level_desc<%=i%>' id='level_desc<%=i%>' size='20' maxlength='' onKeyPress='' value='' onblur=''>&nbsp;<input type=button class=button value="?" onclick="levelLookup(level_desc<%=i%>,<%=i%>)">&nbsp;<%if(i == 0){%><img src="../../eCommon/images/mandatory.gif"><%}%>
			<input type=hidden name='lvl_code<%=i%>' id='lvl_code<%=i%>' value='<%=rs_level.getString(1)%>'>
			
		</td>
				
	
	<%
	i++;
	}
	if (rs_level != null) rs_level.close();
	if (pstmt_term != null) pstmt_term.close();

	if(i % 2 != 0)
	{ %>
			<td colspan="2">&nbsp;<td>
	  <%
	}
	try
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		out.println("Exception "+e.toString());
	}

	%></tr>

	<tr>
		<td colspan="4" class='button'>&nbsp;<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onclick="insertValues()"></td>
	</tr>
	
	<tr>
		<td colspan="4">
		<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center id=''>
		<tr>
			<th colspan="4"><fmt:message key="eMR.TerminologyCodeAssociated.label" bundle="${mr_labels}"/></th>
		</tr>
		<tr>
			<th ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
		<!-- <tr>
			<td colspan='4'>
			<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center id='term_associated'>
			</table>
			</td>
		</tr> -->
		</table>
		
		
		</td>	
	</tr>
				   
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="function_id" id="function_id" value="">
<input type="hidden" name="seq" id="seq" value="">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=i%>">
<input type="hidden" name="sql_dept" id="sql_dept" value="select dept_code code,long_desc descr from am_dept where upper(dept_Code) like '%' and upper(long_Desc) like '%' and eff_Status = 'E' order by 2">
<input type="hidden" name="sql_service" id="sql_service" value="Select service_code code,long_desc description from am_service where upper(service_Code) like (?) and upper(long_Desc) like (?) and eff_Status = 'E' order by 2">
<input type="hidden" name="sql_level" id="sql_level" value="select TERM_SET_ID code,TERM_SET_DESC description from mr_term_set where PROC_SPEC_YN = 'Y' and eff_Status = 'E' and upper(TERM_SET_ID) like upper(?) and upper(TERM_SET_DESC) like upper(?) order by 2">

</form>

</body>
</html>

