<!DOCTYPE html>
<%--
	FileName	: HealthCareSettingTypeRestnsModify.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%!
	public boolean datecompare(java.util.Date dt) {
		java.util.Date systemdate=new java.util.Date();
		if(dt.before(systemdate)) return true;
		else return false;
	}
%>
<%
request.setCharacterEncoding("UTF-8");
String from_hcare_setting_type_code="";
String from_desc="";
String to_hcare_setting_type_code="";
String to_desc="";
String ip_referral_yn ="";
String op_referral_yn ="";
String f_hcare_setting_type_code = request.getParameter("from_hcare_setting_type_code");
String t_hcare_setting_type_code = request.getParameter("to_hcare_setting_type_code");

PreparedStatement pstmt=null;
ResultSet rset=null;
Connection conn = null;

%>

<%
try{


conn = ConnectionManager.getConnection(request);

String sql = "select from_hcare_setting_type_code,f.short_desc from_desc,to_hcare_setting_type_code,t.short_desc to_desc,ip_referral_yn,op_referral_yn from am_hcare_setting_type_rstrn r,am_hcare_setting_type f,am_hcare_setting_type t where r.from_hcare_setting_type_code = f.hcare_setting_type_code and r.to_hcare_setting_type_code = t.hcare_setting_type_code and from_hcare_setting_type_code='"+f_hcare_setting_type_code+"' and to_hcare_setting_type_code='"+t_hcare_setting_type_code+"'";

pstmt = conn.prepareStatement(sql);
rset = pstmt.executeQuery();

while(rset.next())
	{
		from_hcare_setting_type_code = rset.getString("from_hcare_setting_type_code");
		from_desc=rset.getString("from_desc");
		to_hcare_setting_type_code=rset.getString("to_hcare_setting_type_code");
		to_desc=rset.getString("to_desc");
		ip_referral_yn=rset.getString("ip_referral_yn");
		op_referral_yn=rset.getString("op_referral_yn");

	}
%>
	<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
 <form name='HlthCareSetgTypRestns_form' id='HlthCareSetgTypRestns_form' action='../../servlet/eAM.HlthCareSetgTypRestnsServlet' method='post' target='messageFrame'>
 <BR><BR><BR><BR><BR><BR><BR><BR><BR><div align='left'>
 <table border='0' cellpadding='0' cellspacing='0' width='65%' align='center'>
 <tr>
	 <td width='40%'>&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td></tr>
 <tr>
	 <td width='60%' class='label'><fmt:message key="eAM.FromHealthCareSettingType.label" bundle="${am_labels}"/></td>
	 <td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;
<input type='text' width='40%' name='from_short_desc' id='from_short_desc' value='<%=from_desc%>' size='15' readonly >
<input type='hidden' name='from_hcare_setting_type_code' id='from_hcare_setting_type_code' value='<%=from_hcare_setting_type_code%>' size='2' >

<img src='../../eCommon/images/mandatory.gif'></img>

	</td>
</tr>

	<tr>
		<td width='60%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'><fmt:message key="eAM.ToHealthCareSettingType.label" bundle="${am_labels}"/></td>
		<td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;
		<input type='text' width='40%' name='to_short_desc' id='to_short_desc' value='<%=to_desc%>' size='15' readonly >
		<input type='hidden' name='to_hcare_setting_type_code' id='to_hcare_setting_type_code' value='<%=to_hcare_setting_type_code %>' size='2' >

		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
	</tr>


<%
	out.println("<tr><td width='60%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td  width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.InpatientReferral.label","am_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='checkbox' name='ip_referral_yn' id='ip_referral_yn' value='Y'");
	if  ( ip_referral_yn.equals("Y") )
		out.println("checked >");
	else
		out.println(">");
	out.println("</td></tr>");

	out.println("<tr><td width='60%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td  width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OutpatientReferral.label","am_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='checkbox' name='op_referral_yn' id='op_referral_yn' value='Y'");
	if  ( op_referral_yn.equals("Y") )
		out.println("checked >");
	else
		out.println(">");
	out.println("</td></tr>");

	out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
//}
	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;

}
catch ( Exception e )
{
 out.println(e.toString());
}
finally{
  
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

