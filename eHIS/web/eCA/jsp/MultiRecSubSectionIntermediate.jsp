<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/MultiRecSubSection.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String section_code = "";
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			section_code = request.getParameter("section_code") == null ? "" : request.getParameter("section_code");
			sql = "Select sec_hdg_code code, sec_hdg_desc description,sec_hdr_meta_desc from ca_section_hdg where eff_status='E' AND content_type='S' and upper(sec_hdg_desc) like upper(?) order by (sec_hdg_desc) ";
			 
			section_code = section_code + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,section_code);
			rs = ps.executeQuery();
		while(rs.next())
			{
				count++;
			}

			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.HeaderFrame.document.HeaderForm.sectionCode.value='"+rs.getString(2)+"' ");
					out.println("parent.HeaderFrame.document.HeaderForm.flag.value='true' ");	out.println("parent.HeaderFrame.document.HeaderForm.section.value='"+rs.getString(1)+"' ");
					out.println("parent.DetailsFrame.location.href='../../eCA/jsp/MultiRecSubSectionFrameSet.jsp'");
					out.println("parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'");
					out.println("parent.HeaderFrame.document.HeaderForm.finalString.value=''");
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql = "SELECT sec_hdg_code code, sec_hdg_desc description, sec_hdr_meta_desc FROM ca_section_hdg  WHERE eff_status='E' AND content_type='S' and upper(sec_hdg_code) like upper(?) and  upper(sec_hdg_desc) like upper(?)   ORDER BY(sec_hdg_desc)";

%>
	<script>
		 retArray = callFunction("<%=sql%>","MainSection",parent.HeaderFrame.document.HeaderForm.sectionCode)
			if(retArray != null && retArray !="")	
			{
					 secRefresh("");
					parent.HeaderFrame.document.HeaderForm.sectionCode.value = retArray[1];
					parent.HeaderFrame.document.HeaderForm.section.value = retArray[0];
					parent.HeaderFrame.document.HeaderForm.flag.value = 'true';
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				secRefresh("");
				parent.HeaderFrame.document.HeaderForm.sectionCode.value = ''
				parent.HeaderFrame.document.HeaderForm.section.value = ''
				parent.HeaderFrame.document.HeaderForm.flag.value = 'true';
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Multi Rec Sub Section Intermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>		

