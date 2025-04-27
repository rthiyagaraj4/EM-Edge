<!DOCTYPE html>

<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SpecialityTasksForEventsBean taskBean = (eCA.SpecialityTasksForEventsBean)getObjectFromBean("taskBean","eCA.SpecialityTasksForEventsBean",session);
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedSectionsForType.label" bundle="${ca_labels}"/></title>
		<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
			String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
//			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
			String endString =  request.getParameter("end") == null ? "5" : request.getParameter("end");
			String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");

			String module = request.getParameter("module") == null ? "true" : request.getParameter("module");
			String code = request.getParameter("code") == null ? "" : request.getParameter("code");
			String event_id = request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			String no_of_trans = request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");
		  

			int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));

			if(tempRowIds.indexOf("^") != -1)
			{
				for(int y=0;y<tempRowIds.length();y++)
					tempRowIds = tempRowIds.replace('^','+');
			}

			if(!tempRowIds.equals(""))
				tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);

			int start = Integer.parseInt(startString);
			int end = Integer.parseInt(endString);

			int tempSeq = 0;
			int count = 0;
			int tempCount = 0;

			if(mode.equals("modify"))
				searchText = "";
		%> 

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/SpecialityTasksForEvents.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='scrollTitle()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'spltyTaskForEventSearchForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADER' colspan='2'><fmt:message key="eCA.AvailableTasks.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADER' colspan='1'>
				</tr>
				<tr id='trcoll'>
					<td class = 'label' ><fmt:message key="eCA.SpecialtyTaskStartsWith.label" bundle="${ca_labels}"/></td>
					<td class='fields'><input type='text' name='searchText' id='searchText' value='<%=searchText%>'><img src="../../eCommon/images/mandatory.gif"></img></td>
					<td align=right><input type='button' name='searchBtn' id='searchBtn' class='button' value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='loadtasks()'></td>
				</tr>				
			</table>
			<br>
			<% if(!searchText.equals(""))
			{
				%>
			<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
				<tr align='right'>
					 <td class='white' width='95%'></td> 
					<td  class='white' align='right' width='5%' nowrap><a style='visibility:hidden' id='prevRecs' href="javascript:loadPrevNextRecs('prev')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;<a id='nextRecs' href="javascript:loadPrevNextRecs('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
			
			<table id='display_result' style='visibility:visible' cellpadding='3' cellspacing='0' border='1' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
				<%
					Connection con = null;
					PreparedStatement pstmtNoteSections = null;
					ResultSet resNoteSections = null;
					PreparedStatement pstmtChk = null;
					ResultSet resChk = null;

					String splty_task_code = "";
					String splty_task_desc = "";
//					String content_type = "";
//					String chief_comp = "";
					StringBuffer sqlNoteSec = new StringBuffer();
					String classValue = "";
//					String exist_yn = "";
					String chkSelBox = "";
					String rowID = "";

					int cnt = 0;

					if(!mode.equals("modify"))
					{
						ArrayList keySectionForChk = taskBean.retrieveRecords();
						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec.append("select  rowId row_id,SPLTY_TASK_CODE, SPLTY_TASK_DESC from ca_splty_tasks");
							if(!searchText.equals(""))
							  {
								sqlNoteSec.append(" where upper(SPLTY_TASK_DESC) like upper(?)");
							  }
							sqlNoteSec.append(" ORDER BY SPLTY_TASK_DESC ");
							pstmtNoteSections = con.prepareStatement(sqlNoteSec.toString());
							if(!searchText.equals(""))
							{
								pstmtNoteSections.setString(1,searchText+"%");
							}
							resNoteSections = pstmtNoteSections.executeQuery();
							while(resNoteSections.next())
							{
								rowID = resNoteSections.getString("row_id");
								splty_task_code = resNoteSections.getString("SPLTY_TASK_CODE");
								splty_task_desc = resNoteSections.getString("SPLTY_TASK_DESC");
								if(keySectionForChk != null)
								{
									for(int n=0;n<keySectionForChk.size();n++)
									{
										if(((String) keySectionForChk.get(n)).equals(splty_task_code))
										{
											chkSelBox = " checked ";
											tempSeq = n;											
											n = keySectionForChk.size();
										}
										else
										{
											chkSelBox = "";
											 tempSeq=keySectionForChk.size();
										}
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
									out.println("<td class='"+classValue+"'> "+splty_task_desc+" </td>");
									out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' "+chkSelBox+" onclick=`loadTasksPage(this,\""+splty_task_code+"\",\""+splty_task_desc+"\",\""+tempSeq+"\")`> </td>");
									out.println("</tr>");
								}

								cnt++;

								taskBean.addFrameRecords(splty_task_code,splty_task_desc);						
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
							putObjectInBean("taskBean",taskBean,session);
							if(cnt == 0)
							{
								%>
								<script>
									document.getElementById("nextRecs").style.visibility = 'hidden';
									document.getElementById("prevRecs").style.visibility = 'hidden';
								</script>
								<%
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
							}
							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();

							if(pstmtChk != null) pstmtChk.close();
							if(resChk != null) resChk.close();
						}
						catch(Exception e)
						{
							//out.println("Exception in try of SectionForNoteTypeSearchAddSections.jsp"+e.toString());//COMMON-ICN-0181
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
						ArrayList list = taskBean.retrieveArrayList();
						try
						{
							ArrayList keys = taskBean.retrieveHashRecords();
							ArrayList keySection = taskBean.retrieveRecords();
							//out.println("keySection --"+keySection+"--");
							HashMap recValues = taskBean.getHashRecordValues();
						   
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
									out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
									out.println("<td class='"+classValue+"' align='center'> <input type='checkbox'   "+chk_sel+" onclick=`loadTasksPage(this,\""+keyVal+"\",\""+heading_desc+"\",\""+tempSeq+"\")`> </td>");
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
				%>
			</table>

			<script>
			var tempVar = <%=tempCount%> / 5;
			if(<%=start%> == 0)
				document.getElementById("prevRecs").style.visibility = 'hidden';
			else
				document.getElementById("prevRecs").style.visibility = 'visible';
		
			if(<%=count%> < 5 || <%=countForNext%> == tempVar)
				document.getElementById("nextRecs").style.visibility = 'hidden';
			else
				document.getElementById("nextRecs").style.visibility = 'visible';
		</script>
			<%}%>
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='searchTextHidden' id='searchTextHidden' value='<%=searchText%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
			<input type ='hidden' name='event_id' id='event_id' value='<%=event_id%> '>
			<input type ='hidden' name='module' id='module' value='<%=module%> '>
			<input type ='hidden' name='code' id='code' value='<%=code%> '>
			<input type ='hidden' name='no_of_trans' id='no_of_trans' value='<%=no_of_trans%> '>
			<input type='hidden' name='totalCount' id='totalCount' value='<%=tempCount%>'>
			<input type='hidden' name='countForNext' id='countForNext' value='<%=countForNext%>'>
		</form>
		<%
		if(!mode.equals("modify") && flag.equals("0") && !flagTemp.equals("temp"))
		{
		%>
		<script>
			//parent.tasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?module=<%=module%>&code=<%=code%>&no_of_trans=<%=no_of_trans%>&event_id=<%=event_id%>';
		</script>
		<%
		}
		%>
		
	</body>
</html>

