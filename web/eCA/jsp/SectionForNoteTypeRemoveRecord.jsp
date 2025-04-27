<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SectionForNoteTypeRecBean noteBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("noteBean","eCA.SectionForNoteTypeRecBean",session);
	
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
	String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

	int indexof=noteBean.getIndexOfElement(sec_heading_code);	
	
	if(called_from.equals("sectionsPage"))	{
		
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		noteBean.removeRec(sec_heading_code);
		noteBean.removeElement(indexInt);
		putObjectInBean("noteBean",noteBean,session);
	}

	else if(called_from.equals("removeReco"))	{
		if(indexof !=-1){
		noteBean.removeRec(sec_heading_code);
		noteBean.removeElement(indexof);
		putObjectInBean("noteBean",noteBean,session);
		}
	}
	else if(called_from.equals("addPage"))
	{
		String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		
		if(chiefComp.equals("Y")){
			if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +"N"+ "~" +chiefComp);
			putObjectInBean("noteBean",noteBean,session);
		}
		}
		else{
		if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +chiefComp+ "~" +chiefComp);
			putObjectInBean("noteBean",noteBean,session);
		}
		}
		

	}
	else if(called_from.equals("addSearch"))
	{
		
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + numberOfRecs + "~" + chief_comp+"~" + chief_comp);
			noteBean.addToList(tempNum,sec_heading_code);
		}
		//noteBean.addFrameRecords(sec_heading_code,sec_heading_desc);
		putObjectInBean("noteBean",noteBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
		}
		putObjectInBean("noteBean",noteBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		noteBean = new eCA.SectionForNoteTypeRecBean();
		//noteBean.clearBean();
		//cleanBeanObject("noteBean",noteBean,request);
		putObjectInBean("noteBean",noteBean,session);
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
		noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + seq_num + "~" + chief_comp+ "~" + chief_comp);
		putObjectInBean("noteBean",noteBean,session);
	}	
%>
<html>
	<head>
		<script language='javascript' src='../../eCA/js/SectionForNoteType.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body onKeyDown='lockKey()'>
			<%
			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
				parent.sectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false';
			var seachText='<%=seachText%>';			
			if(seachText==""){
				parent.addSectionsFrame.location.href = "../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?mode=&searchText=<%=seachText%>&note_type=<%=note_type%>";	
			}
			else{
				parent.addSectionsFrame.location.reload();
			}
				</script>				
			
			<%
			}

			else if(called_from.equals("removeReco"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
				parent.sectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false';
			var seachText='<%=seachText%>';			
			if(seachText==""){
				parent.addSectionsFrame.location.href = "../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?mode=&searchText=<%=seachText%>&note_type=<%=note_type%>";	
			}
			else{
				//parent.addSectionsFrame.location.reload();
			}
				</script>				
			
			<%
			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			%>
				<script>
					parent.sectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
			}
				else if(called_from.equals("removeSearch"))
				{

			%>
				<script>
					parent.sectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
				}	
			%>
		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>


