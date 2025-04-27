<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ClinicalRepRelinkBean recordBean = (eCA.ClinicalRepRelinkBean)getObjectFromBean("recordBean","eCA.ClinicalRepRelinkBean",session);
	
	String sec_heading_code = request.getParameter("sec_heading_code") == null ? "" : request.getParameter("sec_heading_code");
	String sec_heading_desc = request.getParameter("sec_heading_desc") == null ? "" : request.getParameter("sec_heading_desc");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String chief_comp = request.getParameter("chief_comp") == null ? "" : request.getParameter("chief_comp");
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	//String firstPos = request.getParameter("firstPos") == null ? "" : request.getParameter("firstPos");
	//String secPos = request.getParameter("secPos") == null ? "" : request.getParameter("secPos");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	//out.println("<script>alert('"+called_from+"')</script>");
	
	if(called_from.equals("sectionsPage"))
	{
		
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		recordBean.removeRec(sec_heading_code);
		recordBean.removeElement(indexInt);
		putObjectInBean("recordBean",recordBean,session);
	}
	else if(called_from.equals("addPage"))
	{
		String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		//String beanval=sec_heading_desc + "~" + srlNo + "~" +chiefComp;
		
		if(recordBean.chkContainsKey(sec_heading_code))
		{
			recordBean.removeRec(sec_heading_code);
			recordBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +chiefComp);
			putObjectInBean("recordBean",recordBean,session);
		}
		
		

	}
	else if(called_from.equals("addSearch"))
	{
		out.println("<script>alert(2);</script>");
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!recordBean.chkContainsKey(sec_heading_code))
		{
			recordBean.addRecords(sec_heading_code,sec_heading_code + "~" + sec_heading_desc );
			recordBean.addToList(tempNum,sec_heading_code);
		}
		//recordBean.addFrameRecords(sec_heading_code,sec_heading_desc);
		putObjectInBean("recordBean",recordBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(recordBean.chkContainsKey(sec_heading_code))
		{
			recordBean.removeRec(sec_heading_code);
		}
		putObjectInBean("recordBean",recordBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		recordBean = new eCA.ClinicalRepRelinkBean();
		//recordBean.clearBean();
		//cleanBeanObject("recordBean",recordBean,request);
		putObjectInBean("recordBean",recordBean,session);
	%>
		<script>
			parent.addSectionsFrame.location.href = "../../eCommon/html/blank.html";
			parent.sectionsFrame.location.href = "../../eCommon/html/blank.html";
			parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = false;
		</script>
	<%
	}
	else if(called_from.equals("onBlurFunc"))
	{
		//out.println("<script>alert(4);</script>");
		recordBean.addRecords(sec_heading_code,sec_heading_desc + "~" + seq_num + "~" + chief_comp);
		putObjectInBean("recordBean",recordBean,session);
	}	
%>
<html>
	<head>
		<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body onKeyDown="lockKey()">
			<%
			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
    var hist_rec_type=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.hist_rec_type.value;
    var event_code=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.event_code.value;
    var contr_system=top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.options[top.content.master_pages.ClinicalRepMastSubFrame.ClinicalRepMastRelink_form.contr_system.selectedIndex].text;
				parent.sectionsFrame.location.href = '../../eCA/jsp/ClinicalRepConEventsSelected.jsp?mode=modify&flag_for_list=false';
				parent.addSectionsFrame.location.href = "../../eCA/jsp/ClinicalRepConEventsSearch.jsp?mode=modify&searchText=<%=seachText%>&hist_rec_type="+hist_rec_type+"&contr_system="+contr_system;
				//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			</script>
			<%
			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			%>
				<script>
				alert("116");
					parent.sectionsFrame.location.href = '../../eCA/jsp/ClinicalRepConEventsSelected.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
			}
				else if(called_from.equals("removeSearch"))
				{

			%>
				<script>
					parent.sectionsFrame.location.href = '../../eCA/jsp/ClinicalRepConEventsSelected.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
				}	
			%>
		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>


