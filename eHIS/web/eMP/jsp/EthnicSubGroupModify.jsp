<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</script>
		
	</head>
<% 
	String ETHNIC_GROUP_CODE = request.getParameter("ETHNIC_GROUP_CODE");
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	String eff_date_from="",eff_date_to="";
	try{
	conn = ConnectionManager.getConnection(request);
	String status = "" ;
	String ethnicgroupcode = "" ;
	StringBuffer sql = new StringBuffer("select a.ethnic_group_code,a.long_desc,a.short_desc,a.race_code race_code,b.long_desc race_long_desc,a.eff_date_from eff_date_from,a.eff_date_to eff_date_to,a.eff_status eff_status from mp_ethnic_group a, mp_race b where a.ethnic_group_code=? and a.race_code=b.race_code(+)");
	//sql.append(ETHNIC_GROUP_CODE);
	//sql.append("' and a.race_code=b.race_code(+)" );
	pstmt = conn.prepareStatement(sql.toString()); // Added by lakshmanan for security issue ID 174083902 on 05-09-2023
	pstmt.setString(1, ETHNIC_GROUP_CODE);
	rset = pstmt.executeQuery();
	if ( rset != null ) {
		if(rset.next()){
			if ( rset.getDate("eff_date_from") != null ){
				java.util.Date date = rset.getDate("eff_date_from");
				SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
				eff_date_from = formatter.format(date);				
				date = null;
				formatter = null;
			}
			if ( rset.getDate("eff_date_to") != null){
				java.util.Date date1 = rset.getDate("eff_date_to");
				SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
				eff_date_to = formatter.format(date1);
				date1 = null;
				formatter = null;
			}
			status = rset.getString("eff_status") ;
			ethnicgroupcode=rset.getString("race_code");
			if((ethnicgroupcode==null)||ethnicgroupcode.equals("null")){	
				ethnicgroupcode=" ";
			}
%>
<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>	
	<form name='ETHNIC_SUBGROUP_FORM' id='ETHNIC_SUBGROUP_FORM' action='../../servlet/eMP.EthnicSubGroupServlet' method='post' target='messageFrame'> 
	<div align='left'>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='text' size='10' maxlength='10' name='ETHNIC_GROUP_CODE' id='ETHNIC_GROUP_CODE' readonly value="<%=rset.getString("ethnic_group_code")%>">
					<img src='../images/mandatory.gif'></img>
					</td>
			</tr>
			<tr>
					<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td width='60%' class='fields' colspan='2'>
<%
		if ( status.equals( "E" ) )
			out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
		else
			out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' maxlength='30'  readonly value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
%>
		<img src='../images/mandatory.gif'></img></td></tr>

		<tr>
			<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='2'>
<%
		if ( status.equals( "E" ) )
			out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "SHORT_DESC" ) + "\">" );
		else
			out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' maxlength='15' readonly value=\""  + rset.getString( "SHORT_DESC" ) + "\">" );
%>
		<img src='../images/mandatory.gif'></img></td></tr>

			</td>
		</tr>
		<tr>
				<td width='40%' class='label'><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'>
<%
		if(status.equals("E")){
%>
		<select name='RACE_CODE' id='RACE_CODE'>
			<option>------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------------</option>
<%
			if(pstmt !=null ) pstmt.close();

			pstmt = conn.prepareStatement("select RACE_CODE, LONG_DESC from MP_RACE where EFF_STATUS='E' order by LONG_DESC ");

			rset1 = pstmt.executeQuery();
			if( rset1 != null ){
				String code="";
				String desc="";
				while( rset1.next() ){
					code = rset1.getString( "RACE_CODE" ) ;
					desc = rset1.getString( "LONG_DESC" ) ;
					if(ethnicgroupcode.equals(code)){
%>
			<option value="<%=code%>" selected><%=desc%></option>
<%
					}else{
%>
			<option value="<%=code%>"><%=desc%></option>
<%
					}
				}
			}
%>
 </select>
<%
		}else{
			String desc=rset.getString( "race_long_desc" )==null?"":rset.getString( "race_long_desc" );
			out.println( "<input type='text' name='RACE_LONG_DESC' id='RACE_LONG_DESC' size='30' maxlength='30' readonly value=\""+ desc+ "\">" );
			out.println( "<input type='hidden' name='RACE_CODE' id='RACE_CODE' size='10' maxlength='10' value=\""+ethnicgroupcode+ "\">" );
		}
%>
	<img src='../images/mandatory.gif'></img></td></tr>
<%

		if ( status.equals( "E" ) )
			out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='"+eff_date_from+"'>");
		else
			out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_from+"'>");
		if ( status.equals( "E" ) )
			out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
		else
			out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");
			out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='EFF_STATUS' id='EFF_STATUS' value='E'");
		if  ( status.equals("E") )
			out.println("checked >");
		else
			out.println(">");
%>
	</td></tr>
	<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>
</table>
</div>
<input type='hidden' name='mode' id='mode' value='modify'>
<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
<input type='hidden' name='function_name' id='function_name' value='modify'>
</form>
<%
		}
	}
	if ( rset != null ) rset.close() ;
	if ( rset1 != null ) rset1.close() ;
	if ( pstmt != null ) pstmt.close() ;
}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

