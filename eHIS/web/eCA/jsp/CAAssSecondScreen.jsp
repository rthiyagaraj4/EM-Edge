<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		<%
			Connection con= null;
			
			//String fac_id    	= (String) session.getValue( "facility_id" ) ;
			String scheme=request.getParameter("Search_Scheme");
			String cause_indicator=request.getParameter("cause_indicator");
			
			if(scheme==null)
				scheme="2";
			String from_code=request.getParameter("from_diag_code");
			String to_code=request.getParameter("to_diag_code");
			String auth=request.getParameter("p_auth_yn");
			StringBuffer sql = new StringBuffer() ;
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows(prev).cells(0).style.backgroundColor=obj.bgColor
					obj.cells(0).style.backgroundColor="#B2B6D7"
					prev	=obj.rowIndex
			}
			function loadOtherFrames(diag_code,scheme,desc)
			{
				parent.parent.frames[1].document.forms[0].elements(1).disabled=false
				while(desc.indexOf(";")!=-1)
					desc=desc.replace(";" ,' ')
				parent.parent.frames[1].document.forms[0].elements(0).value=desc
				parent.parent.frames[1].document.forms[0].elements(2).value=diag_code
				
				parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[2].location.href='../../eCA/jsp/CAAssThirdScreen.jsp?p_auth_yn=<%=auth%>&Search_Code='+diag_code+'&Scheme='+scheme+'&cause_indicator=<%=cause_indicator%>'
			}
		</script>
	
<html>
	<head>	
	</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t' id='t'>
		<%
			try
			{
				con= ConnectionManager.getConnection(request);
				PreparedStatement stmt=null;
				ResultSet rs		 	= null;
				sql.append(	"  select diag_code || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between ? and ? and diag_code_scheme=? and nvl(sensitive_yn,'N')=decode(?,'N','N',nvl(sensitive_yn,'N')) AND NVL(CAUSE_INDICATOR, '|') =NVL(?,NVL(CAUSE_INDICATOR,'|')) ");

				if(scheme.equals("2"))
					sql.append(" AND RECORD_TYPE='D'");

				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,from_code);
				stmt.setString(2,to_code);
				stmt.setString(3,scheme);
				stmt.setString(4,auth);
				stmt.setString(5,cause_indicator);
				rs=stmt.executeQuery();

				if(rs!=null)
				{
					while(rs.next())
					{	
						String s=rs.getString("diag_desc");
						if(s!=null)
							s=s.replace(' ', ';');
				%>
					<tr onclick='change_row_color(this)'>
					<td>
						<a href=javascript:loadOtherFrames('<%=rs.getString("diag_code")%>','<%=rs.getString("diag_code_scheme")%>','<%=s%>') ><font size=1><%=rs.getString("diag_desc")%>><a><br>
					</td>
					</tr>
			<%	}

				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception e){
				//out.println("Exception in CAAssSecondScreen.jsp"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>
</html>

