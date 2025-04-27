<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" %>

		<%
			
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs	= null;
			//String fac_id   = (String) session.getValue( "facility_id" ) ;
			String scheme=request.getParameter("Scheme")==null?"":request.getParameter("Scheme");
			String code=request.getParameter("Search_Code")==null?"":request.getParameter("Search_Code");
		//String auth=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");			
			//String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");			
			String sql="";

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
	
	<body onKeyDown='lockKey()'>
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
				sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  ? and diag_code_scheme = ?  and (code_indicator in ('D','C') or code_indicator is null)  order by diag_code  ";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,code+"%");
				stmt.setString(2,scheme);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
					String s="";
					while(rs.next())
					{
					
						s=rs.getString("long_desc");
						if(s!=null)
							s = s.replace(' ', ';');
					%>
					<tr  onclick='change_row_color(this)'>
					<td>
						<a href=javascript:closewin('<%=rs.getString("diag_code")%>','<%=s%>') ><font size=1><%=rs.getString("d")%><a><br>
					</td>
					</tr>						
			<%	}
				}
			}
			catch(Exception e){/* out.println("in mail"+e); */ e.printStackTrace();}
			finally
			{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
		%>
		</table>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

