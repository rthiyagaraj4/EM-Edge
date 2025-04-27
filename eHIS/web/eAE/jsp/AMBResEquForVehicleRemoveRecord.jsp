<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page language="java" import ="java.net.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String sec_heading_code = request.getParameter("sec_heading_code") == null ? "" : request.getParameter("sec_heading_code");
	String sec_heading_desc =request.getParameter("sec_heading_desc") == null ? "" : request.getParameter("sec_heading_desc");
	sec_heading_desc= URLDecoder.decode(sec_heading_desc,"UTF-8");
	System.err.println("sec_heading_desc--9->"+sec_heading_desc);
	sec_heading_desc=sec_heading_desc.replace("$$$","'");
	System.err.println("sec_heading_desc--11->"+sec_heading_desc);
	sec_heading_desc=sec_heading_desc.replace("~","$$$");
	System.err.println("sec_heading_desc--13->"+sec_heading_desc);
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String strResource	=	request.getParameter("restype") == null ? "" : request.getParameter("restype");
	String strPosition	=	request.getParameter("posDesc") == null ? "" : request.getParameter("posDesc");

	String chief_comp = request.getParameter("chief_comp") == null ? "" : request.getParameter("chief_comp");
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	//String firstPos = request.getParameter("firstPos") == null ? "" : request.getParameter("firstPos");
	//String secPos = request.getParameter("secPos") == null ? "" : request.getParameter("secPos");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	String start = request.getParameter("start") == null ? "0" : request.getParameter("start");
	String end = request.getParameter("end") == null ? "9" : request.getParameter("end");
	try
	{
	if(called_from.equals("sectionsPage"))
	{
		
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
			
		}
		resequBean.removeRec(sec_heading_code);
		resequBean.removeElement(indexInt);
		putObjectInBean("resequBean",resequBean,session);
	}
	else if(called_from.equals("addPage"))
	{
		String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		//String beanval=sec_heading_desc + "~" + srlNo + "~" +chiefComp;
		//System.out.println("Bean Value"+beanval);
		if(resequBean.chkContainsKey(sec_heading_code))
		{
			resequBean.removeRec(sec_heading_code);
			resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +chiefComp+ "~" +chiefComp + "~"+strResource+"~"+strPosition);
			putObjectInBean("resequBean",resequBean,session);
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

		if(!resequBean.chkContainsKey(sec_heading_code))
		{
			resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + numberOfRecs + "~" + chief_comp+"~" + chief_comp+ "~"+strResource+"~"+strPosition);
			resequBean.addToList(tempNum,sec_heading_code);
		}
		//resequBean.addFrameRecords(sec_heading_code,sec_heading_desc);
		putObjectInBean("resequBean",resequBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(resequBean.chkContainsKey(sec_heading_code))
		{
			resequBean.removeRec(sec_heading_code);
		}
		putObjectInBean("resequBean",resequBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		resequBean = new eAE.AMBResEquVehicleBean();
		//resequBean.clearBean();
		//cleanBeanObject("resequBean",resequBean,request);
		putObjectInBean("resequBean",resequBean,session);
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
		resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + seq_num + "~" + chief_comp+ "~" + chief_comp+"~"+strResource+"~"+strPosition);
		putObjectInBean("resequBean",resequBean,session);
	}
	}
	catch(Exception e1)
	{
		e1.printStackTrace(System.err);
	}
%>
<html>
	<head>
		<script language='javascript' src='../../eAE/js/AMBResEquForVehicle.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body>
			<%
			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			%>
			<script>
				parent.sectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleAMB.jsp?mode=modify&flag_for_list=false';
				parent.addSectionsFrame.location.href = "../../eAE/jsp/AMBResEquForVehicleSearchAddSections.jsp?mode=&searchText=<%=seachText%>&start=<%=start%>&end=<%=end%>";
				//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			</script>
			<%
			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			%>
				<script>
					parent.sectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleAMB.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
			}
				else if(called_from.equals("removeSearch"))
				{

			%>
				<script>
					parent.sectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleAMB.jsp?mode=modify&flag_for_list=false';
					//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				</script>
			<%
				}	
			%>
		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>


