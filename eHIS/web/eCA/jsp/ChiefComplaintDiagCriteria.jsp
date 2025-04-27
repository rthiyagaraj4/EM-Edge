<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

// added by Arvind @  07-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end
%>
	
    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintDiag.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try
	{	
		String ComplSql = "";
		String complaint_id = "";
		String complaint_desc = "";
		con	= ConnectionManager.getConnection();
		
%>
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
     <form name=ChiefComplaintDiagCriteriafrm>
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
	<tr>
		<td class='label'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<%
			ComplSql = "select complaint_id,complaint_desc from ca_chief_complaint where eff_status = 'E' order by complaint_desc ";

			stmt = con.prepareStatement(ComplSql);
			rs = stmt.executeQuery();
		%>
		<select name="complaint_id" id="complaint_id" onChange="blankScreen()">
		 <option value="" selected>------------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------</option>

		<%
		while(rs.next())
		{
			complaint_id = rs.getString("complaint_id");
			complaint_desc = rs.getString("complaint_desc");
			
			if(complaint_id == null )
				complaint_id = "";
			if(complaint_desc == null)
				complaint_desc = "";

			out.println("<option value='"+complaint_id+"'>"+complaint_desc+"</option>");
		}

%>
		</select><img src='../../eCommon/images/mandatory.gif'></td>		
		<td colspan=2></td>
		
		<td> <input type='button' name='search' id='search' class='Button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="populate()"> </input></td>
		</tr>
	</table>
	<!-- added by arvind @ 07-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->

	
<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e){
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
	}finally	{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}	
%>	

</form>
</body>

</html>

