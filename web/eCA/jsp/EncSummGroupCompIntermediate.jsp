<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/EncSummGroupComp.js"></script>
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
	String groupFlag = "", groupType = "", groupCode = "";	
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			
			groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");
			
			sql ="SELECT es_group_code code, es_group_desc description FROM cr_es_group_header where es_group_status='E' and es_group_flag = ? and es_group_type = ? and upper(es_group_desc) like upper(?) order by es_group_desc";
		
			groupCode = groupCode + "%";

			ps = con.prepareStatement(sql);		
			
			ps.setString(1,groupFlag);
			ps.setString(2,groupType);
			ps.setString(3,groupCode);
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
					out.println("parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code.value='"+rs.getString(2)+"' ");
					out.println("parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.flag.value='true' ");	
					out.println("parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1.value='"+rs.getString(1)+"' ");

				}
			}
			if(rs != null) rs.close();
			out.println("</script>");

			if(count == 0 || count > 1)
			{
				sql = "SELECT es_group_code code, es_group_desc description FROM cr_es_group_header where es_group_status='E' and es_group_flag = "+groupFlag+" "+ 
							" and upper(es_group_type) = upper('"+groupType+"') and upper(es_group_code) like upper(?) and upper(es_group_desc) like upper(?) ORDER BY  es_group_desc";
				%>
	<script>
		
		 retArray = callGroupCodeType1("<%=sql%>","Group/Sub-Group",parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1);
			if(retArray != null && retArray !="")	
			{
				    parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code.value = retArray[1];
					parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1.value = retArray[0];

					parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.flag.value = 'true'
			
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code.value = ''
				parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1.value = ''
				parent.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.flag.value = 'true'
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
		//out.println("Exception in Components for Group/Sub-group Intermediate Module "+ee.toString());//common-icn-0181
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

