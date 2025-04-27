<!DOCTYPE html>

<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SectionForNoteTypeRecBean EventBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("EventBean","eCA.SectionForNoteTypeRecBean",session);
%>
<html>
	<head>
		<title>AttachedEventsForType</title>
		<%
			String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String mode		= request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			String event_id	=  request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			int count=0;
			String classValue = "";
			int cnt = 0;
			String disable = "disabled";
			String chk = "";
			String outcome_type = "";
			String close_episode_yn = "";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/SpltyEventOutcome.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'spltyeventForm' action='../../servlet/eCA.SpltyEventOutcomeServlet' method='post' target='messageFrame'>
			<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='4'><fmt:message key="eCA.AttachedOutcomes.label" bundle="${ca_labels}"/></td>					
				</tr>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.CloseEpisode.label" bundle="${ca_labels}"/></td>					
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>

		 <%
			 if(!mode.equals("modify"))
				{
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null; 
							
					String outcome_code = "";
					String outcome_desc = "";
										
					String mapValue = "";
					int srlNo = 1;

				 try
					{
					con = ConnectionManager.getConnection(request);
					String event_query =" SELECT  A.OUTCOME_CODE ,B.OUTCOME_DESC ,OUTCOME_TYPE,CLOSE_EPISODE_YN FROM    CA_SPLTY_EVENT_OUTCOME A,CA_SPLTY_OUTCOME B WHERE A.MODULE_ID =? AND A.SPLTY_EVENT_CODE =? AND A.MODULE_ID = B.MODULE_ID AND     A.OUTCOME_CODE =B.OUTCOME_CODE ";

					pstmt =con.prepareStatement(event_query);
					pstmt.setString(1,module_id);
					pstmt.setString(2,event_id);
					rs = pstmt.executeQuery();

					while(rs.next())
						{
						
						outcome_code = rs.getString("OUTCOME_CODE");
						outcome_desc = rs.getString("OUTCOME_DESC");
						outcome_type = rs.getString("OUTCOME_TYPE");
						close_episode_yn = rs.getString("CLOSE_EPISODE_YN");
						
						
						if(cnt%2 == 0)
							classValue = "QRYEVEN";
						else
							classValue = "QRYODD";
							
						if(outcome_type.equals("O"))

							disable="";
						else
							disable="disabled";

						if(close_episode_yn.equals("Y"))
							chk ="checked";
						else
							chk =""; 
						
						out.println("<tr><td class='"+classValue+"' align='center'>"+outcome_desc+"</td>");
						out.println("<td style='display:none'> <input type = 'hidden' value = '"+outcome_code+"' name = 'outcome_code"+cnt+"'> </td>");	
						out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='close_episode"+cnt+"' id='close_episode"+cnt+"'"+disable+" onclick=\"setValueCE(this) \" "+chk+"  value='"+close_episode_yn+"' 	> </td>");
						out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='evntChk"+cnt+"' id='evntChk"+cnt+"' checked onclick=\"removeRecord(this,'"+outcome_code+"','"+cnt+"') \"> </td>");
						out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");		
						out.println("</tr>");
										
						
						mapValue = outcome_desc + "~" + srlNo+"~"+outcome_type+"~"+close_episode_yn ;			
						EventBean.addRecords(outcome_code,mapValue);
						EventBean.addToList(cnt,outcome_code);
										
						
						cnt++;
						srlNo++;
												
						}

						putObjectInBean("EventBean",EventBean,session);

						if(pstmt!=null)
							pstmt.close();
						if(rs!=null)
							pstmt.close();
						
					}
					catch(Exception e)
					{
					
						//out.println("Exception in try of spltyEventOutcome.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					
					}
					finally
					{
					
						if(con != null) ConnectionManager.returnConnection(con,request);
					}

				}

			 else if(mode.equals("modify"))
				{
				
				String keyVal = "";
				String mapVal = "";
				String heading_seq_num = "";
				String heading_desc = "";
				StringTokenizer strCodeToken = null;
				
				int i=0;
				int tempInt = i +1;

				int positionOne = Integer.parseInt(firstPosition);
				positionOne = positionOne - 1;
				int positionTwo = Integer.parseInt(secondPosition);				
				positionTwo = positionTwo - 1;
				int totalRows = Integer.parseInt(noOfRows);
				String codeList = "";
				

				try
				{	
					
					if(!flag_for_list.equals("false"))
					{
						
						if(totalRows < positionTwo)
							positionTwo = positionTwo -1;
						else
							positionTwo = positionTwo;

						int k = 0;
							ArrayList list = EventBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								EventBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							EventBean.removeElement(positionOne);
						}
						else
						{
							EventBean.removeElement(positionOne+1);
						}
						putObjectInBean("EventBean",EventBean,session);
					}
					
					
					HashMap recValues = EventBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = EventBean.retrieveArrayList();
					for(i=0; i<indexList.size(); i++)
					{
						tempInt = i +1;
						keyVal = (String)indexList.get(i);
						mapVal = (String)recValues.get(keyVal);
						
						strCodeToken = new StringTokenizer(mapVal,"~");
						while(strCodeToken.hasMoreTokens())
						{
							heading_desc = strCodeToken.nextToken();
							heading_seq_num = strCodeToken.nextToken();
							outcome_type = strCodeToken.nextToken();
							close_episode_yn = strCodeToken.nextToken();


							if(outcome_type.equals("O"))

								disable="";
							else
								disable="disabled";

							if(close_episode_yn.equals("Y"))
								chk ="checked";
							else
								chk =""; 
														
							if(heading_seq_num.equals(" "))
								heading_seq_num = "";
							//else
								//heading_seq_num = heading_seq_num;

							if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";
							
							out.println("<tr id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='outcome_code"+i+"' id='outcome_code"+i+"'> </td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
							out.println("<td class='"+classValue+"' align='center' > <input type= 'checkbox' name='close_episode"+i+"' id='close_episode"+i+"'"+disable+" onclick=\"setValueCE(this) \""+chk+" value='"+close_episode_yn+"'> </td>");
							out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' checked onclick=\"removeRecord(this,'"+keyVal+"','"+i+"')\"> </td>");
							out.println("</tr>");							
						}
					}
					tempInt++;
					out.println("<tr style='display:none' id='extraRow'><td align=\"center\"><a href=\"javaScript:changeColor('"+i+"','"+tempInt+"')\">"+tempInt+"</td><td></td><td></td></tr>");
					cnt = indexList.size();
				}
				catch(Exception e)
				{
					//out.println("Exception in try of SpltyEventOutcome.jsp - mode : modify" +e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
			}

		 %>

			</table>
			<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
			<input type='hidden' name='firstPos' id='firstPos' value=''>
			<input type='hidden' name='secPos' id='secPos' value=''>
			<input type='hidden' name='flag' id='flag' value="true">
			<input type='hidden' name='count' id='count' value=<%=count%>>
			<input type='hidden' name='module_id' id='module_id' value=<%=module_id%>>
			<input type='hidden' name='event_id' id='event_id' value=<%=event_id%>>
</form>
</body>
</html>

