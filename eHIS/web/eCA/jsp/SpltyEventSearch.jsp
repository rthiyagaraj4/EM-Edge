<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
	<head>
		<title><fmt:message key="eCA.SpecialtyEventOutcome.label" bundle="${ca_labels}"/></title>
		<%
			eCA.SectionForNoteTypeRecBean EventBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("EventBean","eCA.SectionForNoteTypeRecBean",session);
			
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			
			String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
			String endString =  request.getParameter("end") == null ? "5" : request.getParameter("end");
			String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));
			
			String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			String event_id =  request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
			String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
			String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");

			if(tempRowIds.indexOf("^") != -1)
			{
				for(int y=0;y<tempRowIds.length();y++)
					tempRowIds = tempRowIds.replace('^','+');
			}

			if(!tempRowIds.equals(""))
				tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);


			int start = Integer.parseInt(startString);
			int end = Integer.parseInt(endString);
			int tempCount = 0;
			int count = 0;
			int tempSeq = 0;
			//if(mode.equals("modify"))
			//	searchText = "";

			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/SpltyEventOutcome.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name = 'SpltyEventSearchForm'>
		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADER' colspan='2'><fmt:message key="eCA.AvailableOutcomes.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADER' colspan='1'>
				</tr>
				<tr id='trcoll'>
					<td class = 'label' ><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='searchText' id='searchText' value='<%=searchText%>'><img src="../../eCommon/images/mandatory.gif"></img></td>
					<td align=right><input type='button' name='searchBtn' id='searchBtn' class='button' value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='loadEvents()'></td>
				</tr>				
			</table>

			<br>
			<% if(!searchText.equals(""))
			{
				
				%>
			<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
				<tr align='right'>
					 <td class='white' width='95%'></td> 
					<td  align='right' width='5%'nowrap><a style='display:none' id='prevRecs' href="javascript:loadPrevNextRecs('prev')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;<a id='nextRecs' href="javascript:loadPrevNextRecs('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
			
			<table id='display_result' style='visibility:visible' cellpadding='3' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>

				<%
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String splty_event_code ="";
					String splty_event_desc ="";
					String classValue = "";
					String chkSelBox = "";
					String outcome_type = "";
					StringBuffer event_query = new StringBuffer();
					String rowID = "";

					//module_id ="OH" ;
								
					int cnt = 0;
					
					if(!mode.equals("modify"))
					{
						ArrayList keySectionForChk = EventBean.retrieveRecords();
						

					try
						{
							
							con = ConnectionManager.getConnection(request);
							
							event_query.append("SELECT rowId row_id,OUTCOME_CODE ,OUTCOME_DESC,OUTCOME_TYPE FROM    CA_SPLTY_OUTCOME WHERE MODULE_ID  = ?  AND upper(OUTCOME_DESC) like upper(?)"); 
							
							if(!tempRowIds.equals(""))
							{
								event_query.append(" and rowId in("+tempRowIds+") ");
							}
							
							
							pstmt=con.prepareStatement(event_query.toString());
							pstmt.setString(1,module_id);
							pstmt.setString(2,searchText+"%");
							
							rs				=	pstmt.executeQuery();
							
							while(rs.next())
							{
							
							rowID = rs.getString("row_id");
							splty_event_code = rs.getString("OUTCOME_CODE");
							splty_event_desc = rs.getString("OUTCOME_DESC");
							outcome_type = rs.getString("OUTCOME_TYPE");
														
							
							if(keySectionForChk != null)
								{
									for(int n=0;n<keySectionForChk.size();n++)
									{
										if(((String) keySectionForChk.get(n)).equals(splty_event_code))
										{
											chkSelBox = " checked ";
											tempSeq = n;											
											n = keySectionForChk.size();
										}
										else
											chkSelBox = "";										
									}
								}
							
						if(loadFirst.equals("Yes"))
								{
								%>
									<script>
										parent.parent.rowIDSectionForNoteType[<%=cnt%>] = '<%=rowID%>';
									</script>
								<%
								}
							
							if(cnt < 5)
								{
									if(cnt%2 == 0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";
								
									out.println("<tr>");
									out.println("<td class='"+classValue+"'> "+splty_event_desc+" </td>");
									out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' "+chkSelBox+" onclick=`loadEventPage(this,\""+splty_event_code+"\",\""+splty_event_desc+"\",\""+tempSeq+"\",\""+outcome_type+"\")`> </td>");
									out.println("</tr>");
															
								}
							  cnt++;
							  EventBean.addFrameRecords(splty_event_code,splty_event_desc);	
							  }
							  count = cnt;
						if(loadFirst.equals("Yes"))
							{
								tempCount = cnt;
							}
						else
							{
								tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
							}

						putObjectInBean("EventBean",EventBean,session);
						if(cnt == 0)
							{
								  %>
								  <script>
									document.getElementById("nextRecs").style.display = 'none';
									document.getElementById("prevRecs").style.display = 'none';
								</script>
								  <%
								  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
							}
						if(pstmt!=null)
								pstmt.close();
						if(rs!=null)
								rs.close();

						}
						catch(Exception e)
						{
							//out.println("Exception in try of spltyEventSearch.jsp"+e.toString());//COMMON-ICN-0181
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
						String keyValSec = "";
						String heading_desc = "";
						String chk_sel = "";
						String codeList = "";

						int k = 0;
						int i = 0;
						ArrayList list = EventBean.retrieveArrayList();
						
						try
						{
							ArrayList keys = EventBean.retrieveHashRecords();
							ArrayList keySection = EventBean.retrieveRecords();
							//out.println("keySection --"+keySection+"--");
							HashMap recValues = EventBean.getHashRecordValues();

							for(i=0; i<keys.size(); i++)
							{
								keyVal = (String)keys.get(i);
								heading_desc = (String)recValues.get(keyVal);

								for(int j=0; j<keySection.size(); j++)
								{
									keyValSec = (String)keySection.get(j);

									if(keyVal.equals(keyValSec))
									{
										chk_sel = " checked ";
										for(k=0;k<list.size();k++)
										{
											codeList = (String) list.get(k);
											if(codeList.equals(keyVal))
											{
												tempSeq = k;
												k = list.size();
											}
										}
										 j = keySection.size();
									}
									else
										chk_sel = "";
								}

								if(i < 5)
								{
									if(i%2 ==0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";
									out.println("<tr>");
									out.println("<td class='"+classValue+"' > "+splty_event_desc+" </td>");
									out.println("<td class='"+classValue+"' align='center'> <input type='checkbox'   "+chk_sel+" onclick=`loadEventPage(this,\""+keyVal+"\",\""+splty_event_desc+"\",\""+tempSeq+"\")`> </td>");
									out.println("</tr>");
								}
							}
							count = i;
						}
						catch(Exception e)
						{
							//out.println("Exception in try of SectionForNoteTypeSearchAddSections.jsp "+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
					}
	
			
			
			//}
					%>
					</table>
		
		<script>
			var tempVar = <%=tempCount%> / 5;
			if(<%=start%> == 0)
				document.getElementById("prevRecs").style.display = 'none';
			else
				document.getElementById("prevRecs").style.display = 'inline';
		
			if(<%=count%> < 5 || <%=countForNext%> == tempVar)
				document.getElementById("nextRecs").style.display = 'none';
			else
				document.getElementById("nextRecs").style.display = 'inline';
		</script>
		<%}%>
		<input type='hidden' name='from' id='from' value='<%=start%>'>
		<input type='hidden' name='to' id='to' value='<%=end%>'>
		<input type='hidden' name='totalCount' id='totalCount' value='<%=tempCount%>'>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
		<input type='hidden' name='countForNext' id='countForNext' value='<%=countForNext%>'>
		<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
				
		</form>

		<%
		if(!mode.equals("modify")&& flag.equals("0") && !flagTemp.equals("temp"))
		{
		%>
		<script>
			parent.spltyeventFrame.location.href = '../../eCA/jsp/SpltyEventOutcome.jsp?module_id=<%=module_id%>&event_id=<%=event_id%>';
		</script>
		<%
		}
		%>
	</body>
</html>

