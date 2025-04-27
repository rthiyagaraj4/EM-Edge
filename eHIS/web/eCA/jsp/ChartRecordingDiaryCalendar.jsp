<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCA/html/IeStyle.css"> 
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> -->

	<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='chartRecordingDiaryCalendarForm' id='chartRecordingDiaryCalendarForm'>
<table width='100%' cellspacing='0' cellpadding='3' border='1' bordercolor='#FFFFFF'>
<tr>
<!-- <td class='columnHeader'><fmt:message key="Common.sun.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.mon.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.tue.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.wed.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.thu.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.fri.label" bundle="${common_labels}"/></td>
<td class='columnHeader'><fmt:message key="Common.sat.label" bundle="${common_labels}"/></td> -->
<td width='2' class='columnHeader'>Sun</td>
<td width='2' class='columnHeader'>Mon</td>
<td width='2' class='columnHeader'>Tue</td>
<td width='2' class='columnHeader'>Wed</td>
<td width='2' class='columnHeader'>Thu</td>
<td width='2' class='columnHeader'>Fri</td>
<td width='2' class='columnHeader'>Sun</td>
</tr>
<%
	Connection con = null;
	ResultSet rs= null;
	PreparedStatement pstmt = null;
	StringBuffer sql = new StringBuffer();
	StringTokenizer tokenPipe = null;
	StringTokenizer tokenTilde = null;
	String sysdate = "";
	String facility_id  = session.getValue("facility_id")==null ? "" :(String)session.getValue("facility_id");
	
	String encounterId = request.getParameter("encounterId")==null ? "" :  request.getParameter("encounterId");

	String chart_id = request.getParameter("chartId")==null ? "" :  request.getParameter("chartId");

	String adm_date =  request.getParameter("adm_date")==null ? "" :  request.getParameter("adm_date");
	String date =  request.getParameter("currentDate")==null ? "" :  request.getParameter("currentDate");
	String prevDate = "";
	String fromDate=request.getParameter("fromDate")==null ? "" :  request.getParameter("fromDate");
	String toDate=request.getParameter("toDate")==null ? "" :  request.getParameter("toDate");
	StringTokenizer tokenDollar = null;
//String prevDate1="";
	String detailSelect = request.getParameter("detailSelect")==null?"":request.getParameter("detailSelect");

	try
	{
		con= ConnectionManager.getConnection(request);
		sql.append("select to_char(sysdate,'dd/mm/yyyy') current_date,CA_Get_Stay_Calendar_string(?,?,?,?,? ");
		if(fromDate.equals("") && toDate.equals(""))
		{
			sql.append( " ) from dual ");
		}
		else if(!(fromDate.equals("") && toDate.equals("")))
		{
				sql.append( ",?,?) from dual "); 
		}
		else 
		{
			if(!fromDate.equals(""))
			{
				sql.append( ",? "); 
			}
			if(!toDate.equals(""))
			{
				sql.append( ",? ");
			}
			sql.append( " ) from dual ");
		}


		pstmt= con.prepareStatement(sql.toString());	
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounterId);
		pstmt.setString(4,date);
		pstmt.setString(3,chart_id);
		pstmt.setString(5,detailSelect);
		if(!(fromDate.equals("") && toDate.equals("")))
		{
				//pstmt.setString(6,fromDate);
				pstmt.setString(6,toDate);
				pstmt.setString(7,fromDate);
		}
		if(!fromDate.equals(""))
		{
					//pstmt.setString(6,fromDate);
					pstmt.setString(7,fromDate);
		}
		if(!toDate.equals(""))
		{
					//pstmt.setString(6,toDate);
					pstmt.setString(6,toDate);
		}
		rs= pstmt.executeQuery();
		prevDate =date;
		while(rs.next())
		{
			date = rs.getString(2) == null ? "" :  rs.getString(2);
			sysdate= rs.getString(1) == null ? "" :  rs.getString(1);
		}
		int count =0;

		if(!date.equals(""))
		{
			
			if(date.indexOf("$") !=-1)
			{
				tokenDollar = new StringTokenizer(date,"$");
				//prevDate1 = tokenDollar.nextToken();
				tokenDollar.nextToken();
				date  = tokenDollar.nextToken();
			}
			if(date.indexOf("|") != -1)
			{
				tokenPipe = new StringTokenizer(date,"|");
				out.println("<tr>");
				String tempString = "";
				String toolTip = "";
				String checkUpDate = "";
				String classValue="";
				while(tokenPipe.hasMoreTokens())
					{
					count++;
					tempString = tokenPipe.nextToken();
					toolTip = "";
					checkUpDate = "";
					if(tempString.equals("0")) 
						tempString="&nbsp;";
					else if(tempString.indexOf("~") != -1)
					{
						tokenTilde = new StringTokenizer(tempString,"~");
						
							tempString = tokenTilde.nextToken(); 
							checkUpDate = tokenTilde.nextToken(); 
							if(tokenTilde.countTokens() != 0)
							toolTip =  tokenTilde.nextToken(); 
					}
					if(checkUpDate.equals(""))
					{
						if(count % 2 == 0)	
								classValue="QRYEVEN";
							else 
								classValue="QRYODD";
					}
					else
					{
							classValue="CAGREENSMALL";
					}
					if(checkUpDate.equals(""))	
					{					
						out.println("<td width='2' class='"+classValue+"' title='"+toolTip+"'>"+tempString+"</td>");
					}
					else
					{
						out.println("<td width='2' class='"+classValue+"' title='"+toolTip+"' OnClick='getDetailDate(\""+tempString+"\",\""+prevDate+"\")'>"+tempString+"</td>");
					}

					if(count==7)
					{
						out.println("</tr>");	
						//out.println("<tr>");
						count=0;
					}
				}
			}
		}
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();	

%>
<script>
var fromDate = "<%=fromDate%>";
var toDate = "<%=toDate%>";
var currentDate = "<%=prevDate%>";

if(fromDate == "" && toDate == "")
{
			var adm_date = "<%=adm_date%>".split(" ");
			var currentDate = "<%=prevDate%>";
			var admArray = adm_date[0].split("/");
			var currArray = 	currentDate.split("/");
			if(currArray[2] == admArray[2])	
				{
					if(currArray[1] == admArray[1])	
						{
						parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true
							
						}
						else
						{
						parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
					}
				}
		var sysdate = "<%=sysdate%>".split("/");

		if(currArray[2] == sysdate[2])
		{
			if(currArray[1] == sysdate[1])	
						{
						parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
							
						}
						else
						{
						parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
						}
		}
		else if(parseInt(currArray[2]) < parseInt(sysdate[2]))
			{
		parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false

			}
		else if(parseInt(currArray[2]) > parseInt( admArray[2]))
		{
		parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
		}


}
if(!fromDate == "" && !toDate == "")
{

	var fromArray = "<%=fromDate%>".split(" ");
	var toArray =  "<%=toDate%>".split(" ");
	var currArray = "<%=prevDate%>".split("/");
	var toDateArray = toArray[0].split("/");
	var fromDateArray = fromArray[0].split("/");
	if(fromDateArray[2] == currArray[2] )
	{
		if(currArray[1] == fromDateArray[1] )
		{
			
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true

		}
		else
		{

			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
		}

	}
if(toDateArray[2] == currArray[2] )
	{
		
		if(currArray[1] == toDateArray[1] )
		{
		parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
		}
		else
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
		}

	}
	if(parseInt(toDateArray[2]) > parseInt(currArray[2]))
	{
		
	parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
	}
	if(parseInt(fromDateArray[2]) < parseInt(currArray[2]))
	{
		
	parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false

	}

}
else
{
	if(!fromDate == "")
	{
		var sysdate = "<%=sysdate%>".split("/");
		var fromArray = "<%=fromDate%>".split(" ");
		var fromDateArray = fromArray[0].split("/");
		var currArray = "<%=prevDate%>".split("/");
		if(currArray[2] == fromDateArray[2])
		{
			if(fromDateArray[1] == currArray[1] )
			{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true
			}
			else
			{
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
			}
		}
		if(fromDateArray[2] > sysdate[2]) 
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true
		}
		if(currArray[2] == sysdate[2])
		{
			if(currArray[1] == sysdate[1])
			{
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
			}
			else
			{
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
			}
		}
		if(currArray[2]  < sysdate[2])
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
		}
		if(currArray[2]  > fromDateArray[2])
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
		}
		if(currArray[2]  < fromDateArray[2])
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
		}


	}
	if(!toDate == "")
	{
		var adm_date = "<%=adm_date%>".split(" ");
		var admArray = adm_date[0].split("/");
		var toArray = "<%=toDate%>".split(" ");
		var toDateArray = toArray[0].split("/");
		var currArray = "<%=prevDate%>".split("/");
		var sysdate = "<%=sysdate%>".split("/");
		if(parseInt(toDateArray[2]) <= parseInt(sysdate[2]))
		{
			//parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
			//parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true
		}
		if(currArray[2] == admArray[2])
		{
			if(currArray[1] == admArray[1])
			{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true
			}
			else 
			{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
			}
		}
		if(currArray[2] == toDateArray[2])
		{
				if(currArray[1] == toDateArray[1])
				{
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true
				}
				else 
				{
					parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
				}
		}
		if(currArray[2] < toDateArray[2])
		{
				parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false
		}
	if(currArray[2] > admArray[2])
		{
			parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false
		}


	}
}

</script>
<%
}
catch(Exception ee)
{
	//out.println("Error fromChartRecordingDiaryBottom jsp :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</table>
</form>
</body>
</html>

