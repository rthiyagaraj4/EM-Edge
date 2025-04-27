<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SectionForNoteTypeRecBean EventBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("EventBean","eCA.SectionForNoteTypeRecBean",session);

	String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
	String sec_heading_desc = request.getParameter("splty_event_desc") == null ? "" : request.getParameter("splty_event_desc");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	String outcome_type = request.getParameter("outcome_type") == null ? "" : request.getParameter("outcome_type");
	String close_episode_yn = request.getParameter("close_episode_yn") == null ? "N" : request.getParameter("close_episode_yn");

	if(called_from.equals("addSearch"))
	{
		//out.println("<script>alert(2);</script>");
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!EventBean.chkContainsKey(splty_event_code))
		{
			EventBean.addRecords(splty_event_code,sec_heading_desc + "~" + numberOfRecs+"~"+outcome_type+"~"+close_episode_yn);
			EventBean.addToList(tempNum,splty_event_code);
		}
		//noteBean.addFrameRecords(sec_heading_code,sec_heading_desc);
		putObjectInBean("EventBean",EventBean,session);
	}
	else if(called_from.equals("sectionsPage"))
	{
		
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		EventBean.removeRec(splty_event_code);
		EventBean.removeElement(indexInt);
		putObjectInBean("EventBean",EventBean,session);



	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		EventBean = new eCA.SectionForNoteTypeRecBean();
		//noteBean.clearBean();
		//cleanBeanObject("noteBean",noteBean,request);
		putObjectInBean("EventBean",EventBean,session);
	%>
		<script>
			parent.spltyEventsSearchFrame.location.href = "../../eCommon/html/blank.html";
			parent.spltyeventFrame.location.href = "../../eCommon/html/blank.html";
			//parent.eventSearchFrame.document.secForNoteTypeValuesForm.search.disabled = false;
		</script> 
    <%
	}
	%>
	<html>
	<head>
		<script language='javascript' src='../../eCA/js/SpltyEventOutcome.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body onKeyDown='lockKey()'>
	<%
	if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			%>
				<script>
					parent.spltyeventFrame.location.href = '../../eCA/jsp/SpltyEventOutcome.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
			}
			
	else if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
				parent.spltyeventFrame.location.href = '../../eCA/jsp/SpltyEventOutcome.jsp?mode=modify&flag_for_list=false';
				parent.spltyEventsSearchFrame.location.href = "../../eCA/jsp/SpltyEventSearch.jsp?mode=&searchText=<%=seachText%>";
				//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			</script>
			<% 
			}
			%>

		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>

