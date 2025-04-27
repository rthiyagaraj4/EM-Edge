<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	07 Feb 2005
--%>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
Connection con = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	con = ConnectionManager.getConnection(request);
	//stmt = con.createStatement(); //common-icn-0180
	String assess_note = request.getParameter("assess_note");
	String assess_catg_code = "";
	String long_desc = "";
	//String sql = "select assess_catg_code, long_desc from cp_assess_catg_lang_vw where assess_catg_code in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id ='"+assess_note+"') and language_id='"+locale+"' order by long_desc"; //common-icn-0180
	String sql = "select assess_catg_code, long_desc from cp_assess_catg_lang_vw where assess_catg_code in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id =?) and language_id=? order by long_desc"; //common-icn-0180
	 //common-icn-0180 starts
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, assess_note);
	pstmt.setString(2, locale);
	//rs = stmt.executeQuery(sql); //common-icn-0180
	rs = pstmt.executeQuery();
	 //common-icn-0180 ends
	if(rs!=null)
	{
		%>
		<script>
			var select	=	parent.parent.f_query_add_mod.assess_crit_score_header.document.assess_crit_score_header.assess_catg;
			var length	=	Math.abs(select.length); 
			for (i=0;i<length;i++)
				select.remove(0);

			var option	=	parent.parent.f_query_add_mod.assess_crit_score_header.document.createElement("OPTION");
			option.text = "------ "+getLabel("Common.defaultSelect.label","Common")+"------";
			option.value = "";	
			select.add(option);
		</script>
		<%
		while(rs.next())
		{
			assess_catg_code = rs.getString("assess_catg_code");
			long_desc = rs.getString("long_desc");
			if ((assess_catg_code==null) || (assess_catg_code.equals("null")))
			assess_catg_code = "";
			if ((long_desc==null) || (long_desc.equals("null")))
			long_desc =	"";
		%>
		<script>
			var option	=	parent.parent.f_query_add_mod.assess_crit_score_header.document.createElement("OPTION");
			option.value = "<%=assess_catg_code%>";
			option.text	= "<%=long_desc%>";
			select.add(option);
		</script>
		<%
		} 
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();//common-icn-0180
	}
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

