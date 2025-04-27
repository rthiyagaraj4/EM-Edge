<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			Connection con= null;
			PreparedStatement stmt=null;
			ResultSet rs	= null;
			String code=request.getParameter("Search_Code");
			String scheme=request.getParameter("Scheme");
			String auth=request.getParameter("p_auth_yn");	
			String cause_indicator=request.getParameter("cause_indicator");	
			StringBuffer sql = new StringBuffer();
		%>
		
		
	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t'>
	<%
			try
			{
				con= ConnectionManager.getConnection(request);
				sql.append("select diag_code_scheme,diag_code  || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code, diag_code||'-'||short_desc diag_desc from mr_icd_code where length(diag_code)=4 and diag_code like ? and diag_code_scheme=? and nvl(sensitive_yn,'N')=decode(?,'N','N',nvl(sensitive_yn,'N')) and   NVL(CAUSE_INDICATOR, '|') =NVL(?,  NVL(CAUSE_INDICATOR,'|')) ");
				
				if(scheme.equals("2"))
					sql.append(" AND RECORD_TYPE='D'");

				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,code+"%");
				stmt.setString(2,scheme);
				stmt.setString(3,auth);
				stmt.setString(4,cause_indicator);
				rs=stmt.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next())
					{	
						String s=rs.getString("diag_desc");
							if(s!=null)
								s=s.replace(' ', ';');
					
					%>
					<tr  onclick='change_row_color(this)'>
					<td>
						<a href=javascript:loadOtherFrames('<%=rs.getString("diag_code_scheme")%>','<%=rs.getString("diag_code")%>','<%=s%>') ><font size=1><%=rs.getString("diag_desc")%><a><br>
					</td>
					</tr>
			<%	}
				
				}
			
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception e){
				//out.print("Exception in CAAssThirdScreen.jsp"+e+sql.toString());//COMMON-ICN-0181
                                e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>
</html>

