<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SpecialityTasksForEventsBean taskBean = (eCA.SpecialityTasksForEventsBean)getObjectFromBean("taskBean","eCA.SpecialityTasksForEventsBean",session);
	
	String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
	String splty_task_desc = request.getParameter("splty_task_desc") == null ? "" : request.getParameter("splty_task_desc");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	//out.println("<script>alert('"+splty_task_code+"')</script>");
	
	String module = request.getParameter("module") == null ? "true" : request.getParameter("module");
	String code = request.getParameter("code") == null ? "" : request.getParameter("code");
	String event_id = request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
	String no_of_trans = request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");


	if(called_from.equals("sectionsPage"))
	{
		  // out.println("<script>alert(10);</script>");
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		taskBean.removeRec(splty_task_code);
		taskBean.removeElement(indexInt);
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("addPage"))
	{		 // out.println("<script>alert(8);</script>");
		//String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		//String beanval=splty_task_desc + "~" + srlNo ;

		if(taskBean.chkContainsKey(splty_task_code))
		{
			taskBean.removeRec(splty_task_code);
			taskBean.addRecords(splty_task_code,splty_task_desc + "~" + srlNo );
			putObjectInBean("taskBean",taskBean,session);
		}
		
		

	}
	else if(called_from.equals("addSearch"))
	{
		//out.println("<script>alert(2);</script>");
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!taskBean.chkContainsKey(splty_task_code))
		{
			//out.println("<script>alert('"+tempNum+"');</script>");
			taskBean.addRecords(splty_task_code,splty_task_desc + "~" + numberOfRecs );
			taskBean.addToList(tempNum,splty_task_code);
		}
		//taskBean.addFrameRecords(splty_task_code,splty_task_desc);
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(taskBean.chkContainsKey(splty_task_code))
		{
			taskBean.removeRec(splty_task_code);
		}
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		taskBean = new eCA.SpecialityTasksForEventsBean();
		//taskBean.clearBean();
		//cleanBeanObject("taskBean",taskBean,request);
		putObjectInBean("taskBean",taskBean,session);
	%>
		<script>
			parent.addTasksFrame.location.href = "../../eCommon/html/blank.html";
			parent.tasksFrame.location.href = "../../eCommon/html/blank.html";
			parent.headerFrame.document.specialityTasksForEeventForm.search.disabled = false;
		</script>
	<%
	}
	else if(called_from.equals("onBlurFunc"))
	{
		//out.println("<script>alert(4);</script>");
		taskBean.addRecords(splty_task_code,splty_task_desc + "~" + seq_num );
		putObjectInBean("taskBean",taskBean,session);
	}	
%>
<html>
	<head>
		<script language='javascript' src='../../eCA/js/SpecialityTasksForEvents.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	</head>
	<body onKeyDown='lockKey()'>
			<%
			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
				parent.tasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?mode=modify&flag_for_list=false&module=<%=module%>&code=<%=code%>&event_id=<%=event_id%>&no_of_trans=<%=no_of_trans%>';
				parent.addTasksFrame.location.href = "../../eCA/jsp/SpecialityTasksForEventsSearchAddTasks.jsp?mode=&searchText=<%=seachText%>";
				//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			</script>
			<%
			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			%>
				<script>
					parent.tasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?mode=modify&flag_for_list=false&module=<%=module%>&code=<%=code%>&event_id=<%=event_id%>&no_of_trans=<%=no_of_trans%>';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
			}
				else if(called_from.equals("removeSearch"))
				{

			%>
				<script>
					parent.tasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?mode=modify&flag_for_list=false&module=<%=module%>&code=<%=code%>&event_id=<%=event_id%>&no_of_trans=<%=no_of_trans%>';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
				}	
			%>
		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>


