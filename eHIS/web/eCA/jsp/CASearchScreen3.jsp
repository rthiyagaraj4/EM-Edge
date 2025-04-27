<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*" %>

		<%
			Connection con=null; 
			PreparedStatement stmt=null;
			ResultSet rs		 	= null;
			//String fac_id    	= (String) session.getValue( "facility_id" ) ;
			String from_diag=request.getParameter("From_Diag");
			String to_diag=request.getParameter("To_Diag");
			String auth=request.getParameter("p_auth_yn");			
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
			String sql="";

			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			//out.println("<script>alert('" + p_code_indicator + "')</script>"); 
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

			parent.frames[3].location.href='CASearchScreen4.jsp?p_auth_yn=<%=auth%>&Scheme='+scheme+'&Search_Code='+code + '&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
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
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between '"+from_diag+"' and '"+to_diag+"' and nvl(sensitive_yn,'N')=decode('"+auth+"' ,'N' ,'N',nvl(sensitive_yn,'N'))order by diag_code";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between ? and ? ";
				if(p_code_indicator.equals(""))
					sql=sql+" and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ";
				else
					//sql=sql+" and code_indicator = '"+p_code_indicator+"'";//common-icn-0180
				    sql=sql+" and code_indicator = ?";//common-icn-0180

				sql=sql+" order by diag_code ";

				stmt=con.prepareStatement(sql);
				stmt.setString(1,from_diag);
				stmt.setString(2,to_diag);
				//common-icn-0180 starts
				if(!p_code_indicator.equals("")){
				stmt.setString(3,p_code_indicator);
				}
				//common-icn-0180 ends
				//out.println("<script>alert('" +from_diag + "  " + to_diag + " "+auth+"')</script>");
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
				if (s.equals(""))
					{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'))</script>");
				    }
				}
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();

			}
			catch(Exception e){
				//out.print(e+sql);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
				
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>
</html>

