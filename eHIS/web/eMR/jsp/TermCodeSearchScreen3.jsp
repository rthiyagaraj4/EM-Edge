<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*" %>

		<%
		
			Connection con=null; 
			PreparedStatement stmt=null;
			ResultSet rs		 	= null;
			String from_diag=request.getParameter("From_Diag");
			String to_diag=request.getParameter("To_Diag");
			String auth=request.getParameter("p_auth_yn");			
			String sql="";
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
					obj.cells(0).style.backgroundColor="#B2B6D7"
					prev	=obj.rowIndex
			}
			function loadOtherFrames(scheme,code,desc)
			{
				//parent.parent.frames[1].document.forms[0].elements(1).disabled=true
				parent.parent.frames[1].document.forms[0].elements(1).disabled=false;
				while(desc.indexOf(";")!=-1)
					desc=desc.replace(";" ,' ');
				parent.parent.frames[1].document.forms[0].elements(0).value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements(2).value=code;
				parent.parent.frames[1].document.f.diag_scheme.value=scheme;

			parent.frames[3].location.href='TermCodeSearchScreen4.jsp?p_auth_yn=<%=auth%>&Scheme='+scheme+'&Search_Code='+code+'&Sex=<%=sex%>&Dob=<%=dob%>';
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
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between '"+from_diag+"' and '"+to_diag+"' and nvl(sensitive_yn,'N')=decode('"+auth+"' ,'N' ,'N',nvl(sensitive_yn,'N'))order by diag_code";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between ? and ?  and (code_indicator in ('D','C') or code_indicator is null)  order by diag_code ";

				stmt=con.prepareStatement(sql);
				stmt.setString(1,from_diag);
				stmt.setString(2,to_diag);
				rs=stmt.executeQuery();
					
				if(rs!=null)
				{
					String s="";
					while(rs.next())
					{	
						s=rs.getString("long_desc");
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
			}
			catch(Exception e){/* out.print(e+sql); */e.printStackTrace(); }
			finally
			{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
		%>
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

