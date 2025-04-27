<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" %>

		<%

			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs	= null;
			//String fac_id   = (String) session.getValue( "facility_id" ) ;
			String scheme=request.getParameter("Scheme")==null?"":request.getParameter("Scheme");
			String code=request.getParameter("Search_Code")==null?"":request.getParameter("Search_Code");
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
		//String auth=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");			
			//String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");			

			//out.println(" called_from"+called_from);
			String sql="";
			//String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			//String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			//out.println("<script>alert('" + p_code_indicator+ "')</script>");
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
					obj.cells(0).style.backgroundColor="#B2B6D7"
					prev	=obj.rowIndex
			}
			function closewin(code,desc)
			{
				parent.parent.frames[1].document.forms[0].elements(1).disabled=false;
				while(desc.indexOf(";")!=-1)
					desc=desc.replace(";" ,' ');
				parent.parent.frames[1].document.forms[0].elements(0).value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements(2).value=code;

			
			}
		</script>
	</head>
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t'>
		<%
			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  '" +code+"%' and diag_code_scheme = '"+scheme+"' and nvl(sensitive_yn,'N') =decode('"+auth+"','N','N',nvl(sensitive_yn,'N'))  order by diag_code ";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/				
				sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  ? and diag_code_scheme = ?  ";
				if(p_code_indicator.equals(""))
					sql=sql+" and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ";
				else{
					//sql=sql+" and code_indicator = '"+p_code_indicator+"'"; //common-icn-0180
				    sql=sql+" and code_indicator = ?"; //common-icn-0180
				}

				sql=sql+" order by diag_code ";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,code+"%");
				stmt.setString(2,scheme);
				//common-icn-0180 starts
				if(!p_code_indicator.equals("")){
				stmt.setString(3,p_code_indicator);
				}
				//common-icn-0180 ends
				//out.println("<script>alert('" + p_code_indicator +"')</script>");
				rs=stmt.executeQuery();
				String s="";
				if(rs!=null)
				{
					
					while(rs.next())
					{
					
						s=rs.getString("long_desc");
						if(s!=null)
							s = s.replace(' ', ';');
					%>
					<tr  onclick='change_row_color(this)'>
					<td>
						<a href=javascript:closewin('<%=rs.getString("diag_code")%>','<%=java.net.URLEncoder.encode(s)%>') ><font size=1><%=rs.getString("d")%><a><br>
					</td>
					</tr>						
			<%	}

					if (s.equals(""))
					{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'))</script>");
				    }
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){
				//out.println("in mail"+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>
		</table>
	</body>
</html>

