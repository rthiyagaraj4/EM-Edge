<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			webbeans.eCommon.RecordSet SpltyMasterCode = (webbeans.eCommon.RecordSet)getObjectFromBean("SpltyMasterCode","webbeans.eCommon.RecordSet",session);
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />		
		<script language="JavaScript" src ="../../eCA/js/SpltyMasterCode.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name='SpltyMasterCodeDtlForm' id='SpltyMasterCodeDtlForm' method ='post' target='messageFrame' action='../../servlet/eCA.SpltyMasterCodeServlet'>
	<%
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
		String mast_type_ref = request.getParameter("mast_type_ref") == null ? "" : request.getParameter("mast_type_ref");
		String callFrom = request.getParameter("callFrom") == null ? "" : request.getParameter("callFrom");
		String clearvalue = request.getParameter("clearvalue") == null ? "" : request.getParameter("clearvalue");
		
		String sql = "";
		int count = 0, i = 0, j=0;
		String classValue = "";
		try
		{   
			con = ConnectionManager.getConnection(request);
			String splty_mst_code = "";
			String short_desc = "";
			String long_desc = "",	eff_status = "";

			if(callFrom.equals("header"))
			{
				SpltyMasterCode.clearAll();

				sql = "select splty_mst_code,short_desc,long_desc,eff_status from CA_SPLTY_MAST_CODE_VAL where mast_type_ref=? ";
				ps = con.prepareStatement(sql);
				ps.setString(1,mast_type_ref);
				rs = ps.executeQuery();
				while(rs.next())
				{
					splty_mst_code = rs.getString("splty_mst_code") == null ? "" : rs.getString("splty_mst_code");
					short_desc = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
					long_desc = rs.getString("long_desc") == null ? "" : rs.getString("long_desc");
					eff_status = rs.getString("eff_status") == null ? "" : rs.getString("eff_status");
					
					if(!(SpltyMasterCode.containsObject(splty_mst_code)))
					{	
						SpltyMasterCode.putObject(splty_mst_code);
						SpltyMasterCode.putObject(short_desc);
						SpltyMasterCode.putObject(long_desc);
						SpltyMasterCode.putObject(eff_status);
					}
				}
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			else if(callFrom.equals("addModify"))
			{
				splty_mst_code = request.getParameter("code") == null ? "" : request.getParameter("code");
				short_desc = request.getParameter("shortDesc") == null ? "" : request.getParameter("shortDesc");
				long_desc = request.getParameter("longDesc") == null ? "" : request.getParameter("longDesc");
				eff_status = request.getParameter("eff_status") == null ? "E" : request.getParameter("eff_status");
				if(mode.equals("insert"))
				{
					if(!(SpltyMasterCode.containsObject(splty_mst_code)))
					{	
						SpltyMasterCode.putObject(splty_mst_code);
						SpltyMasterCode.putObject(short_desc);
						SpltyMasterCode.putObject(long_desc);
						SpltyMasterCode.putObject(eff_status);
					}
					else
					{
						out.println("<script>alert(getMessage('CODE_ALREADY_EXISTS','Common'));</script>");
					}
				}
				else if(mode.equals("update"))
				{
					i = Integer.parseInt(clearvalue);
					int index = SpltyMasterCode.indexOfObject(splty_mst_code);
					
					if(index == i || index == -1)
					{
						SpltyMasterCode.setObject(i,splty_mst_code);
						SpltyMasterCode.setObject(i+1,short_desc);
						SpltyMasterCode.setObject(i+2,long_desc);
						SpltyMasterCode.setObject(i+3,eff_status);
					}
					else
					{
						out.println("<script>alert(getMessage('CODE_ALREADY_EXISTS','Common'));</script>");
					}
				}
			}
	%>
	<table class='grid' width='100%' >
		
		<tr>
		<th width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='40%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
			
	<%
		ArrayList a= new ArrayList();
		a= SpltyMasterCode.getRecordSetHandle();	
		count = a.size();
		String code = "", shortDesc = "";
		String longDesc = "", effStatus = "";
		for(int k=0;k<count;k++)
		{
			if ( j % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;
			
			code = a.get(k).toString();
			shortDesc = a.get(k+1).toString();
			longDesc = a.get(k+2).toString();
			effStatus = a.get(k+3).toString();
			 

	%>
		<tr>
			<td class='<%=classValue%>'><a href="javascript:loadPage('<%=j%>','<%=k%>')" class='gridLink'><%=code%></a><input type=hidden name='code<%=j%>' id='code<%=j%>' value='<%=code%>'></td>
			<td class='<%=classValue%>'><%=shortDesc%></td>
			<%	out.println("<td class='" + classValue + "' >");	
					if (effStatus.equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					 else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>"); 
					  out.println("</td>");
					 %>
			<input type=hidden name='shortDesc<%=j%>' id='shortDesc<%=j%>' value='<%=shortDesc%>'>
			<input type=hidden name='longDesc<%=j%>' id='longDesc<%=j%>' value='<%=longDesc%>'>
			<input type=hidden name='effStatus<%=j%>' id='effStatus<%=j%>' value='<%=effStatus%>'>
			
		</tr>
	<%
			k+=3;
			j++;
		}
	%>
			
		</table>
	<%
		}
		catch(Exception ee)
		{
			
			ee.printStackTrace();
		}
		finally
		{
			try{
				if(con != null) 
				{	
					ConnectionManager.returnConnection(con);
					con.close();
				 }
			}
			catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
				}
		}
	%>
	<input type=hidden name='mast_type_ref' id='mast_type_ref' value='<%=mast_type_ref%>'>
	<input type=hidden name='total' id='total' value='<%=j%>'>
	</form>
	</body>
</html>

