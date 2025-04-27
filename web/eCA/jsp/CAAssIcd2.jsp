<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			Connection con= null;
			String chapter_code=request.getParameter("chapter_code");
			String auth=request.getParameter("p_auth_yn");
			String scheme=request.getParameter("p_diag_code");
			String cause_indicator=request.getParameter("cause_indicator");
			String sql="";
			String optsql="";
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


		<script>
		var chapter='';
		var prev=0
		function  change_row_color(obj)
		{
				document.getElementById("t").rows(prev).cells(1).style.backgroundColor=obj.bgColor
				obj.cells(1).style.backgroundColor="#d3d3d3"
				prev	=obj.rowIndex
		}

			function loadOptions(chapter1)
			{
				parent.frames[1].location.href='../../eCommon/html/blank.html'
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				parent.frames[3].location.href='../../eCommon/html/blank.html'

				var code='<%=chapter_code%>'

				if(code=="null" ||code==null || code!=chapter1)
					chapter='&chapter_code='+chapter1
				else
					chapter='';
				self.location.href='../../eCA/jsp/CAAssIcd2.jsp?p_diag_code=<%=scheme%>&p_auth_yn=<%=auth%>&cause_indicator=<%=cause_indicator%>'+chapter
			}


			function scrl()
			{
				document.getElementById("scrollname").scrollIntoView()
			}

			function loadOtherFr(from, to)
			{
				parent.frames[1].location.href='../../eCA/jsp/CAAssSecondScreen.jsp?p_diag_code=<%=scheme%>&p_auth_yn=<%=auth%>&from_diag_code='+from+'&to_diag_code='+to+'&cause_indicator=<%=cause_indicator%>'
			}
		</script>
	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 >
		<%
			try
			{
				con= ConnectionManager.getConnection(request);
				PreparedStatement stmt 	= null;
				PreparedStatement optstmt=null;
				ResultSet rs	= null;
				ResultSet optrs	= null;
				
				sql= " select '+' expand, chapter_code, long_desc, to_char(null) from_diag_code, to_char(null) to_diag_code from mr_icd9_chapter ";

				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
					{
				%>

				<tr>
				<td>
					<%
					String exp="+";
						if(rs.getString("chapter_code").equals(chapter_code) )
							exp="-";
					%>
						<a href=javascript:loadOptions('<%=rs.getString("chapter_code")%>') ><font size=1><%=exp%></a>
				</td>
	
				<td><font size=1>&nbsp;<%=rs.getString("long_desc")%></font>
						<%
							if(rs.getString("chapter_code").equals(chapter_code) )
							{
								optsql=" select to_char(null) expand, a.chapter_code,lpad('',5)|| a.long_desc long_desc, from_diag_code, to_diag_code from  mr_icd9_subchapter  a, mr_icd9_chapter b where a.chapter_code=? and a.chapter_code=b.chapter_code  order by 1,2, 3";

								optstmt=con.prepareStatement(optsql);
								optstmt.setString(1,chapter_code);
								optrs=optstmt.executeQuery();

								if(optrs!=null)
								{
								%>
								<a id='scrollname' name='scrollname'></a>
								<%
									while(optrs.next())
									{
									%>
										<tr  onclick='change_row_color(this)'>
											<td>&nbsp</td>
											<td><a href=javascript:loadOtherFr('<%=optrs.getString("from_diag_code")%>','<%=optrs.getString("to_diag_code")%>')><font size=1>&nbsp;&nbsp;&nbsp;<%=optrs.getString("long_desc")%></a>
												</td>
										</tr>
									<%
									}
								}
								%>
						<script>scrl();</script>
								<%

				if(optrs!=null) optrs.close();
				if(optstmt!=null) optstmt.close();
						}
						%>
					</td>
				</tr>
					<%
					}
				}
			
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				
			
			}
			catch(Exception e){
				//out.print("Exception in CAAssIcd2.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				
					if(con!=null) ConnectionManager.returnConnection(con,request);
					}
		%>
		</table>

	</body>
<html>

