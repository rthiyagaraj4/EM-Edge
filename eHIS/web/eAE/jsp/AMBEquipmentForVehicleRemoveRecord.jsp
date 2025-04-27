<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*"%>
<%
	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);
	
	String sec_heading_code		= request.getParameter("sec_heading_code") == null ? "" : request.getParameter("sec_heading_code");
	String sec_heading_desc		= request.getParameter("sec_heading_desc") == null ? "" : request.getParameter("sec_heading_desc");
	String called_from			= request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText			= request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String strResource			= request.getParameter("restype") == null ? "" : request.getParameter("restype");
	String chief_comp			= request.getParameter("chief_comp") == null ? "" : request.getParameter("chief_comp");
	String seq_num				= request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	String noOfRows				= request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index				= request.getParameter("index") == null ? "0" : request.getParameter("index");
	
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

		if(resequBean.chkContainsKey(sec_heading_code))
		{
			resequBean.removeRec(sec_heading_code);
			resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +chiefComp+ "~" +chiefComp + "~"+strResource);
			putObjectInBean("resequBean",resequBean,session);
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

		if(!resequBean.chkContainsKey(sec_heading_code))
		{
			resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + numberOfRecs + "~" + chief_comp+"~" + chief_comp+ "~"+strResource);
			resequBean.addToList(tempNum,sec_heading_code);
		}

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
		resequBean = new eAE.AMBResEquVehicleBean();
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
		resequBean.addRecords(sec_heading_code,sec_heading_desc + "~" + seq_num + "~" + chief_comp+ "~" + chief_comp+"~"+strResource);
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
			%>
			<script>
				parent.sectionsFrame.location.href = '../../eAE/jsp/AMBEquipmentForVehicleAMB.jsp?mode=modify&flag_for_list=false';
				parent.addSectionsFrame.location.href = "../../eAE/jsp/AMBEquipmentForVehicleSearchAddSections.jsp?mode=&searchText=<%=seachText%>";
			</script>
			<%
			}
			else if(called_from.equals("addSearch"))
			{
			%>
				<script>
					parent.sectionsFrame.location.href = '../../eAE/jsp/AMBEquipmentForVehicleAMB.jsp?mode=modify&flag_for_list=false';
				</script>
			<%
			}
				else if(called_from.equals("removeSearch"))
				{

			%>
				<script>
					parent.sectionsFrame.location.href = '../../eCA/jsp/AMBEquipmentForVehicleAMB.jsp?mode=modify&flag_for_list=false';
				</script>
			<%
				}	
			%>
		<form name='remRecForm' id='remRecForm'>			
		</form>
	</body>
</html>

