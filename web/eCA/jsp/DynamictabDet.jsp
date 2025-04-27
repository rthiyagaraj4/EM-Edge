<!DOCTYPE html>
<%@page language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			%>
			<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			
			
			
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCA/js/ChartHistoryTemplate.js"></script>  
			<script language="javascript" src="../../eCommon/js/common.js"></script>

		
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'onLoad="setValue();">
		<%
			Connection			        con			=	null;
			PreparedStatement 	pstmt		=	null;
			ResultSet						rs	 			=	null;

			String disable="";
			String    classvalue="";
			String tblrow_id="";
			String contentdesc = "";
			String rows = request.getParameter("rows")==null?"0":request.getParameter("rows"); 
			String cols = request.getParameter("cols")==null?"0":request.getParameter("cols"); 
			String summaryid = request.getParameter("summaryid")== null?"":request.getParameter("summaryid"); 
			String summarydesc = request.getParameter("summarydesc")== null?"":request.getParameter("summarydesc");
			String enadis=request.getParameter("enadis")==null?"":request.getParameter("enadis");
			String blurMode=request.getParameter("blurMode")==null?"":request.getParameter("blurMode");
			String dis=request.getParameter("dis")==null?"":request.getParameter("dis");
			int rows_int = Integer.parseInt(rows);
			int cols_int	= Integer.parseInt(cols);
			int total_no = rows_int * cols_int;
			String row_pos="",col_pos="",col_span="",row_span="";
			String row_arr[] = new String[total_no];
			String col_arr[] = new String[total_no];
			String row_span_arr[] = new String[total_no];
			String col_span_arr[] = new String[total_no];
			String content_id_arr[]   =  new String[total_no];



			for(int i=0;i<total_no;i++){
					row_arr[i] = "";
					col_arr[i] = "";
					row_span_arr[i] = "";
					col_span_arr[i] = "";
					content_id_arr[i] = "";
			}

			int fm_disp=0,to_disp=0;
			to_disp = total_no-1;
		
		%>


		<form name ='DetailForm' action="../../servlet/eCA.ChartHistoryTemplateServlet" target="messageFrame" method=post >

			<%if (dis.equals("T") && !(blurMode.equals("T"))){ %>
					<table width="100%" class='grid' align="center">
						<td class='columnheader' width="1%"><fmt:message key="Common.RowPosition.label" bundle="${common_labels}"/> </td> <td  class='columnheader' width='1%'><fmt:message key="Common.ColumnPosition.label" bundle="${common_labels}"/></td> <td  class='columnheader' width="1%"><fmt:message key="eCA.Row.label" bundle="${ca_labels}"/><br><fmt:message key="eCA.Span.label" bundle="${ca_labels}"/> </td> <td class='columnheader' width="1%"><fmt:message key="Common.ColumnSpan.label" bundle="${common_labels}"/></td><td  class='columnheader' width='100%'><fmt:message key="eCA.ContentDescription.label" bundle="${ca_labels}"/></td><td class=columnheader><a href='javascript:clearRowVal()' title='Click here to clear the Checked Rows'><font color=pink>[<fmt:message key="Common.clear.label" bundle="${common_labels}"/>]</font></a></td>


			<%}%> 

			<%
				try
				{
						con = ConnectionManager.getConnection(request);

						String sql1="select  NO_OF_ROWS, NO_OF_COLS, SUMMARY_ID, SUMMARY_DESC, eff_status from CA_CHART_SUMM_header where summary_id=?";
						PreparedStatement  pstmt1=con.prepareStatement(sql1);
						pstmt1.setString(1,summaryid);
						ResultSet rs1=	pstmt1.executeQuery();
						if (rs1.next())
						{ 
								if (blurMode.equals("T"))
								{ 
				%> 
					<script language=javascript>
					parent.frames[0].location.href="../../eCA/jsp/DynamictabHrd.jsp?rows=<%=rs1.getInt("NO_OF_ROWS")%>&cols=<%=rs1.getInt("NO_OF_COLS")%>&summaryid=<%=rs1.getString("SUMMARY_ID")%>&summarydesc=<%=rs1.getString("SUMMARY_DESC")%>&enadis=<%=rs1.getString("eff_status")%>&updatemode=Y";
							</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%			}
							String a=rs1.getString("eff_status");
							if(a.equals("D"))
							{
								disable="DISABLED"; 
							} 
						}
						if(rs1!=null) rs1.close();
						if(pstmt1!=null) pstmt1.close();

						String sql = "select a.COL_POS,a.ROW_POS,a.COL_SPAN,a.ROW_SPAN,b.CONTENT_SYSDEF_DESC,b.CONTENT_ID from CA_CHART_SUMM_DETAIL a, CA_CHART_SUMM_CONTENT b where a.CONTENT_ID = b.CONTENT_ID and a.SUMMARY_ID = ?";
						pstmt	=	con.prepareStatement(sql);
						pstmt.setString	(1,summaryid);
						rs		=	pstmt.executeQuery();	 
						int count = 0;
						String updateflag="";

		
						for(int i=0;i<total_no;i++)
						{
								if(rs.next())	{
									updateflag="Y";
									count++;
									
									row_pos = rs.getString("row_pos");
									col_pos = rs.getString("col_pos");
									row_span = rs.getString("row_span");
									col_span = rs.getString("col_span");
									contentdesc = rs.getString("CONTENT_ID");	
									row_arr[i] = row_pos;
									col_arr[i] = col_pos;
									row_span_arr[i] = row_span;
									col_span_arr[i] = col_span;
									content_id_arr[i] =  contentdesc;
								}
						}

						for(int i=fm_disp; i<=to_disp; i++){
								classvalue = "gridData";//(( i%2) == 0) ? "QRYODD" : "QRYEVEN";
								tblrow_id	=	"tblrow_id"+i;
				%>

					<tr id='<%=tblrow_id%>'>
							
							<td class='<%=classvalue%>'  width='25%'> <input type="text" name="row_pos<%=i%>" id="row_pos<%=i%>" size="6" maxlength="2" onKeyPress='return acceptValidNum(this,event,6,0);' onBlur='chkSelectRow(this);'  value='<%=row_arr[i]%>' <%=disable%> ></td> 
		
							<td class='<%=classvalue%>'  width='25%'> <input type="text" name="col_pos<%=i%>" id="col_pos<%=i%>"size="6" maxlength="2" onKeyPress='return acceptValidNum(this,event,6,0);'    onBlur='chkSelectCol(this);'  value='<%=col_arr[i]%>'  <%=disable%> ></td> 

							<td class='<%=classvalue%>'  width='25%'> <input type="text" name="row_span<%=i%>" id="row_span<%=i%>" size="6" maxlength="2" onKeyPress='return acceptValidNum(this,event,6,0);' onBlur='chkSelectRow(this);' value='<%=row_span_arr[i]%>'  <%=disable%> ></td> 

							<td class='<%=classvalue%>'  width='25%'> <input type="text" name="col_span<%=i%>" id="col_span<%=i%>" size="6" maxlength="2" onKeyPress='return acceptValidNum(this,event,6,0);' onBlur='chkSelectCol(this);' value='<%=col_span_arr[i]%>'  <%=disable%> ></td> 

							<td class='<%=classvalue%>'  width='40%'>  <select name="cont_id<%=i%>" id="cont_id<%=i%>"  <%=disable%> >
					
								<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
								<%
										PreparedStatement stmt2=null;
										ResultSet rs2=null;
										String cont_id = "",cont_exec = "";


										try
										{
											String sqlsingle = "select CONTENT_ID,CONTENT_SYSDEF_DESC from CA_CHART_SUMM_CONTENT ";
											stmt2=con.prepareStatement(sqlsingle);
											rs2=stmt2.executeQuery();
											if(rs2!=null){
												while(rs2.next())
												{
													cont_id=rs2.getString(1);
													cont_exec=rs2.getString(2);
													if(cont_id.equals(content_id_arr[i]))
													{ %>
															<option value=<%=cont_id%> selected><%=cont_exec%></option>
													<%}else
													{  %>
															<option value=<%=cont_id%>><%=cont_exec%></option>
													<%}
												}
											}
											if(rs2!=null) rs2.close();
											if(stmt2!=null) stmt2.close();
										}
										catch(Exception e)
										{
											//	out.println(e);//COMMON-ICN-0181
											e.printStackTrace();//COMMON-ICN-0181
										}
										
								%>
								</select></td>

								<td class='<%=classvalue%>' width='15%'> <input type="checkbox" name="check<%=i%>" id="check<%=i%>" ></td> 

								</tr>
					<%}	%>
								<input type=hidden name=maxr value='<%=rows%>'>  
								<input type=hidden name=maxc value='<%=cols%>'> 
								<input type=hidden name=summaryid value='<%=summaryid%>'>  
								<input type=hidden name=summarydesc value='<%=summarydesc%>'> 
								<input type=hidden name=updateflag value='<%=updateflag%>'>
								<input type=hidden name=enadis value='<%=enadis%>'>
						<%
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();		
							}
							catch(Exception e)
							{
										//out.println("Exception@2: "+e);//common-icn-0181
							                        e.printStackTrace();//COMMON-ICN-0181
							}
							finally
							{
										
										if(con!=null) ConnectionManager.returnConnection(con,request);
							} %>
			</table>
		</form>
	</body>
</html>

