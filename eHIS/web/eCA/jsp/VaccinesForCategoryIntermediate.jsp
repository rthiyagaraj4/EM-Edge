<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/VaccinesForCategory.js"></script>
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
	String description = "";
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("categoryCode") == null ? "" : request.getParameter("categoryCode");
		
			sql = "Select VACC_CATEG_ID code, SHORT_DESC description from CA_IM_VAC_CATEG where eff_status='E' and  upper(SHORT_DESC) like upper(?) order by 2";
	
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
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
					out.println("parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryDesc.value='"+rs.getString(2)+"' ");
					//out.println("parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.flag.value='true' ");	
					out.println("parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value='"+rs.getString(1)+"' ");

				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
			sql = "Select VACC_CATEG_ID code, SHORT_DESC description from CA_IM_VAC_CATEG where eff_status='E' and VACC_CATEG_ID like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";           
           
%>
	<script>
		 retArray = callFunction("<%=sql%>","Vaccine Category",parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryDesc)
			if(retArray != null && retArray !="")	
			{
					parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryDesc.value = retArray[1];
					parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value = retArray[0];
					//parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.flag.value = 'true'
					parent.VaccinesForCategoryMiddleFrame.location.href='../../eCommon/html/blank.html';	parent.VaccinesForCategorySearchFrame.location.href='../../eCommon/html/blank.html';
					parent.VaccinesForCategoryBottomFrame.location.href='../../eCommon/html/blank.html';
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryDesc.value = ''
				parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value = ''
				//parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.flag.value = 'true'
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				parent.VaccinesForCategoryMiddleFrame.location.href='../../eCommon/html/blank.html';	parent.VaccinesForCategorySearchFrame.location.href='../../eCommon/html/blank.html';
				parent.VaccinesForCategoryBottomFrame.location.href='../../eCommon/html/blank.html';
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		ee.printStackTrace() ;
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

