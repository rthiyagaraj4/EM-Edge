<!DOCTYPE html>
<%@ page import = "java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script language='JavaScript'
src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	var arrValues = new Array();
	var valuesToGraph = new Array();
	var datesToGraph = new Array();
	var eventsToGraph = new Array();
	var totalColsToGraph = new Array();
	var unitsToGraph = new Array();
	function getMessageFrame()
	{
		if(top.content!=null){
			return top.content.messageFrame;
		}else{
			return parent.parent.parent.messageFrame;
		}
	}
	var messageFrameReference = getMessageFrame();

</script>
</HEAD>
<%
	ArrayList arrayIndex = null;
	ArrayList arrayIndexValues = null;
	ArrayList tempArrayIndexValues = null;
	ArrayList tempArrayGraphIndex = null;
	try
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String totalCols = request.getParameter("totCols") == null ? "0" : request.getParameter("totCols");
		int totCols = Integer.parseInt(totalCols);
		//String eventKeys = request.getParameter("eventKeys");
		String resultUOM = request.getParameter("resultUOM");
		for(int u=0;u<resultUOM.length();u++)
		{
			resultUOM = resultUOM.replace('#',' ');
		}
		if(resultUOM.equals("^")) resultUOM = resultUOM + " ";//when none of the events have units
		String eventDesc = request.getParameter("eventDesc");
		for(int v=0;v<eventDesc.length();v++)
		{
			eventDesc = eventDesc.replace('?',' ');
		}
	


		String dateNumvals = request.getParameter("dateNumvals");
		String hiddenColumns = request.getParameter("hiddenColumns");

		//String prevEventDate = "";
		StringTokenizer strtEventKeys = new StringTokenizer(eventDesc,"^");
		StringTokenizer strtUOM = new StringTokenizer(resultUOM,"^");
		StringTokenizer strTokDateNums = new StringTokenizer(dateNumvals,"^%^");

		StringTokenizer strTokHiddenCols = new StringTokenizer(hiddenColumns,"!!");
		StringTokenizer strTokTDVals = null;
		StringTokenizer strTokDatesNums = null;
		int numberOfGraphs = strtEventKeys.countTokens();
		arrayIndex = new ArrayList();
		arrayIndexValues = new ArrayList();
		tempArrayIndexValues = new ArrayList();
		StringBuffer datesToGraph = new StringBuffer();
		StringBuffer valuesToGraph = new StringBuffer();
		String eventsToGraph ="";
		String graphRowValues ="";
		String graphTDValues ="";
		String graphDates ="";
		String graphResNumbers ="";
		int totalColsToGraph=0;
		String unitToGraph="";
		int j=0;
		int in = 0;
		int tempIntGraf = 0;
		int intForDateIndex = 0;

		strtEventKeys = new StringTokenizer(eventDesc,"^");
		strtUOM = new StringTokenizer(resultUOM,"^");
		while(strTokDateNums.hasMoreTokens())
		{	
			valuesToGraph.setLength(0);
			eventsToGraph = strtEventKeys.nextToken();
			unitToGraph = strtUOM.nextToken();
			graphRowValues = strTokDateNums.nextToken();
			strTokTDVals = new StringTokenizer(graphRowValues,">");
			j = 0;
			arrayIndexValues = new ArrayList();
			while(strTokTDVals.hasMoreTokens())
			{	
				intForDateIndex = 0;
				graphTDValues = strTokTDVals.nextToken();
				strTokDatesNums = new StringTokenizer(graphTDValues,"~");
				in = 0;
				while(strTokDatesNums.hasMoreTokens())
				{
					if(in % 2 == 0)
					{
						graphDates = strTokDatesNums.nextToken();
						if(!graphDates.equals(" "))
						{
							if(!(arrayIndex.contains(graphDates)))
							{
								arrayIndex.add(graphDates);
							}
						}
					}
					else
					{
						graphResNumbers = strTokDatesNums.nextToken();
						if(!(graphResNumbers.equals(" ")))
						{
							arrayIndexValues.add(graphDates+"`"+graphResNumbers);
							tempIntGraf++;
						}
					}
					in++;
				}
			}
			tempArrayIndexValues.add(arrayIndexValues);

		%>
		<script>
			eventsToGraph[eventsToGraph.length] = "<%=eventsToGraph%>";
			totalColsToGraph[totalColsToGraph.length] = "<%=totalColsToGraph%>";
			unitsToGraph[unitsToGraph.length] = "<%=unitToGraph%>";
		</script>
		<%
				}

			tempArrayGraphIndex = new ArrayList();
			ArrayList newTempArrayList = new ArrayList();
			String tempHiddenCols = "";
			int i = 0;

			while(strTokHiddenCols.hasMoreTokens())
			{
				tempHiddenCols = (strTokHiddenCols.nextToken()).trim();
				//if(!(tempHiddenCols.equals("+")))
				{
					tempArrayGraphIndex.add(i,tempHiddenCols);
					i++;
				}
			}

			String tempArrayValue = "";
			int arrayIndexNum = 0;

			for(int r=0;r<tempArrayGraphIndex.size();r++)
			{
				tempArrayValue = (String)tempArrayGraphIndex.get(r);
				if(arrayIndex.contains(tempArrayValue))
				{	
					newTempArrayList.add(arrayIndexNum,tempArrayValue);
					arrayIndexNum++;
				}
			}

			ArrayList tempList = new ArrayList();
			String tempString = "";
			String tempStringDates = "";
			String tempStringDatesForGraf = "";
			String tempStringValuesForGraf = "";
			StringTokenizer tempTokenizer = null;

			for(int t=0;t<newTempArrayList.size();t++)
			{
				datesToGraph.append((String) newTempArrayList.get(t)+"`");
			}

			for(int t=0;t<numberOfGraphs;t++)
			{
				valuesToGraph.setLength(0);
				tempList = (ArrayList) tempArrayIndexValues.get(t);
				for(int y=0;y<tempList.size();y++)
				{
					tempString = (String) tempList.get(y);
					tempTokenizer = new StringTokenizer(tempString,"`");
					tempStringDatesForGraf = tempTokenizer.nextToken();
					
					for(int x=0;x<newTempArrayList.size();x++)
					{
						tempStringDates = (String) newTempArrayList.get(x);
						if(tempStringDates.equals(tempStringDatesForGraf))
						{
							tempStringValuesForGraf = tempTokenizer.nextToken();
							valuesToGraph.append(tempStringValuesForGraf+"~"+(x+1)+"`");
							break;
						}
					}				
				}
				%>
				<script>
					valuesToGraph[valuesToGraph.length] = "<%=valuesToGraph.toString()%>";
				</script>					
				<%

			%>
			<script>
				datesToGraph[datesToGraph.length] = "<%=datesToGraph.toString()%>";
			</script>
			<%
			}

		%>
	<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<script>
		var totalCols =parseInt("<%=totCols%>") -  parseInt(totalColsToGraph);
		arrValues[0] = valuesToGraph;
		//alert("arrValues[0] :"+arrValues[0])
		arrValues[1] = datesToGraph;
		//arrValues[2] = totalColsToGraph;
		//arrValues[2] = totalCols;
		arrValues[2] = "<%=newTempArrayList.size()%>";
		arrValues[3] = eventsToGraph;
		arrValues[4] = unitsToGraph;
		arrValues[5] = "<%=numberOfGraphs%>";

		alert("arrValues[0] :"+arrValues[0]);
		alert("arrValues[1] :"+arrValues[1]);
		alert("arrValues[2] :"+arrValues[2]);
		alert("arrValues[3] :"+arrValues[3]);
		alert("arrValues[4] :"+arrValues[4]);
		alert("arrValues[5] :"+arrValues[5]);

		var dialogHeight= "35" ;//"29"
		var dialogWidth	= "50" ;//"42"
		var dialogTop	= "10";
		var dialogLeft	= "40";//"85"
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";
		var url = "../jsp/FlowSheetMultipleGraphFrame.jsp";
		//var url = "../jsp/ChartRecordingGraphFrame.jsp";
		if(top.content != null){
			messageFrameReference.location.href='../../eCommon/jsp/error.jsp';
		}else{
			messageFrameReference.location.href='../../eCommon/jsp/error.jsp';
		}
		retVal = window.showModalDialog(url,arrValues,features);
	</script>
	</BODY>
	</HTML>
<%}
	catch(Exception e)
	{
		out.println("Exception :"+e);
		e.printStackTrace();
	//out.println("<script>alert('Exception : "+e.toString();+"')</script>");	
	}
	finally
	{
	}
%>

