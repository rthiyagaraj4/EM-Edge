<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/FlowSheetCompDetail.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

	Connection con=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String flow_sheet_id = "";
	String flow_sheet_desc = "";


	try
	{
		con = ConnectionManager.getConnection();

%>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
     <form name='FlowSheetCompDetailfrm' id='FlowSheetCompDetailfrm' >

	 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
	
	
	<tr>

			<td class='label' ><fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/></td>
			<td class='fields'>

			<%

			String sql= "SELECT FLOW_SHEET_ID,LONG_DESC FLOW_SHEET_DESC FROM CA_FLOW_SHEET WHERE EFF_STATUS='E'";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			%>
			<select name="flow_sheet" id="flow_sheet" onchange='ShowList()'><option value="" selected >------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------------</option>
			
			<%

			while(rs.next())
			{
				
				flow_sheet_id = rs.getString(1);
				flow_sheet_desc = rs.getString(2);
				
				if(flow_sheet_id == null)
					flow_sheet_id = "";

				if(flow_sheet_desc == null)
					flow_sheet_desc = "";

				out.println("<option value='"+flow_sheet_id+"'>"+flow_sheet_desc+"</option>");
			}

	%>
		</select><img src='../../eCommon/images/mandatory.gif'></td></tr>

	
</table>
<!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->

<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
			catch(Exception e)
			{
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
	
			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>	

<!-- <input type='text' name='ListArry' id='ListArry' value=''></input>
 -->
</form>
</body>

</html>

