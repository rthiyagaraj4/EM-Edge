<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  eCA.SpecialityTasksForEventsBean taskBean = (eCA.SpecialityTasksForEventsBean)getObjectFromBean("taskBean","eCA.SpecialityTasksForEventsBean",session);
  
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			int cnt = 0;
//			String chk="";
//			String disable="disabled";
			int count=0;
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpecialityTasksForEvents.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="specialityTasksForEeventSelectForm" id="specialityTasksForEeventSelectForm"  method ='post' target='messageFrame' action='../../servlet/eCA.SpecialityTasksForEventsServlet'>
	<BR><BR>
<%
	  
	Connection con = null;
	//String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	try
	{   
			con = ConnectionManager.getConnection(request);
			String module = request.getParameter("module") == null ? "true" : request.getParameter("module");
			String code = request.getParameter("code") == null ? "" : request.getParameter("code");
			String event_id = request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			String no_of_trans = request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");
			 
			
%>
<table border='1' cellspacing='0' cellpadding='3' width='100%' align='center'>
	<tr id='trcoll'>
					<td class='columnHeader' colspan='4'><fmt:message key="eCA.AttachedTasks.label" bundle="${ca_labels}"/></td>					
	</tr>	
 <tr id='trcoll'>
	<td class="columnheader"><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/> </td>	
	<td class="columnheader"><fmt:message key="eCA.SpecialtyTaskDescription.label" bundle="${ca_labels}"/></td>	
	<td class="columnheader"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>	
 </tr>
	

	<%
					if(!mode.equals("modify"))
					{
						  
						PreparedStatement pstmtNoteSections = null;
						ResultSet resNoteSections = null;
						
						//String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

						String splty_task_code = "";
						String splty_task_desc = "";
						String note_seq_num = "";
//						String chief_complaint_sec_yn = "";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;
						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec = "select  b.SPLTY_TASK_DESC SPLTY_TASK_DESC, a.SPLTY_TASK_CODE  SPLTY_TASK_CODE ,a.ORDER_SEQ_NO  ORDER_SEQ_NO  from CA_SPLTY_TASKS_FOR_EVENTS a, ca_splty_tasks b  where  a.SPLTY_TASK_CODE=b.SPLTY_TASK_CODE  and  a.SPLTY_EVENT_CODE =?";
							pstmtNoteSections = con.prepareStatement(sqlNoteSec);

							pstmtNoteSections.setString(1,event_id);
							resNoteSections = pstmtNoteSections.executeQuery();

							while(resNoteSections.next())
							{
								
								splty_task_code = resNoteSections.getString("SPLTY_TASK_CODE");
								splty_task_desc = resNoteSections.getString("SPLTY_TASK_DESC");
								note_seq_num = resNoteSections.getString("ORDER_SEQ_NO");
								//out.println("splty_task_code ---->" +splty_task_code);
								//out.println("splty_task_desc ---->" +splty_task_desc);
								//out.println("note_seq_num ---->" +note_seq_num);

								
								if(cnt%2 == 0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";

								out.println("<tr id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+splty_task_code+"' name = 'splty_task_code"+cnt+"'> </td>");						
								//out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+cnt+"','"+srlNo+"')\"> "+srlNo+" </a></td>");
								out.println("<td class='"+classValue+"'> "+splty_task_desc+" </td>");
								out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
								
								//out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+splty_task_code+"\",\""+splty_task_desc+"\",\""+srlNo+"\",\""+cnt+"\")`> </td>");
								
								out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick=\"removeRecord(this,'"+splty_task_code+"','"+cnt+"')\"> </td>");
								out.println("</tr>");							
								//out.println("chief_complaint_sec_yn"+chief_complaint_sec_yn);
								mapValue = splty_task_desc + "~" + srlNo ;			
								taskBean.addRecords(splty_task_code,mapValue);
								taskBean.addToList(cnt,splty_task_code);
								cnt++;
								srlNo++;
							}
							
							out.println("<tr style='display:none' id='extraRow'><td align=\"center\" id='extraTD'><a href=\"javaScript:changeColor('"+cnt+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
							putObjectInBean("taskBean",taskBean,session);


							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();
						}
						catch(Exception e)
						{
							//out.println("Exception in try of SectionForNoteTypeSections.jsp"+e.toString());//COMMON-ICN-0181
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
//				String chief_complaint = "";
				String heading_seq_num = "";
				String heading_desc = "";
				StringTokenizer strCodeToken = null;
//				String chief_complaint_sect_yn="";
				//StringTokenizer strSeqToken = null;
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
//					String check="";
					if(!flag_for_list.equals("false"))
					{
						
						if(totalRows < positionTwo)
							positionTwo = positionTwo -1;
						else
							positionTwo = positionTwo;

						int k = 0;
						ArrayList list = taskBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								taskBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							taskBean.removeElement(positionOne);
						}
						else
						{
							taskBean.removeElement(positionOne+1);
						}
						putObjectInBean("taskBean",taskBean,session);
					}
					HashMap recValues = taskBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = taskBean.retrieveArrayList();
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
							
							

							/*if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
                            {
								//check="";
								
								disable="disabled";
							}
							else 
                            {
								//check="";
								disable="";
							}
							if(chief_complaint_sect_yn.equals("Y"))

							{
								if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
								{
							
							       check="";
								}
								else 
								{
								check="checked";
								count++;
										
								}
							}
							else
								check="";	  */
							

							if(heading_seq_num.equals(" "))
								heading_seq_num = "";
							else
								heading_seq_num = heading_seq_num;

							if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";
							out.println("<tr id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='splty_task_code"+i+"' id='splty_task_code"+i+"'> </td>");
							//out.println("<td style='display:none'> <input type='hidden' value='"+chief_complaint+"' name='chief_complaint_yn"+i+"' id='chief_complaint_yn"+i+"' </td>");
							out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+i+"','"+tempInt+"')\"> "+tempInt+" </a></td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
				//out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\")`> </td>");
							
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
				//	out.println("Exception in try of SectionForNoteTypeSections - mode : modify" +e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
			}

			%>
							<input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
							<input type ='hidden' name='event_id' id='event_id' value='<%=event_id%> '>
							<input type ='hidden' name='module' id='module' value='<%=module%> '>
							<input type ='hidden' name='code' id='code' value='<%=code%> '>
							<input type ='hidden' name='no_of_trans' id='no_of_trans' value='<%=no_of_trans%> '>
							<input type='hidden' name='conc_string' id='conc_string' value=''>
							<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
							<input type='hidden' name='firstPos' id='firstPos' value=''>
							<input type='hidden' name='secPos' id='secPos' value=''>
							<input type='hidden' name='flag' id='flag' value="true">
							<input type='hidden' name='count' id='count' value=<%=count%>>
</form>
</table>
				  
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
			//out.println(e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
			}
	}

%>
	</body>
</html>

