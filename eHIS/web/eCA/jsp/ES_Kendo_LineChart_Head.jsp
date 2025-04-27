<!DOCTYPE html>
<!--
Created By: D. Sethuraman
Created Date: 21/01/2013
Used for: This page will be included to draw the line chart using Kendo Line Chart component.
Called from: CA module to display the line chart for the vitals, investigation results when more than one observations or results are available.
This page requires Seven parameters 
1. divID: To be used as div ID for each line chart to be drawn.
2. yAxisMin: Integer value of Y-Axis minimum
3. yAxisMax: Integer Value of Y-Axis Maximum
4. xAxisdataType: String Data of X-Axis data type
5. yAxisdataType: String Data of Y-Axis data type
6. splitRange: String value contains the ranges (From, To and Color).
7. valuesRange: String value contains the ranges (xAxis and yAxis values).

Example: "../../eCA/jsp/ES_Kendo_LineChart_Head.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange;
-->

<%@page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String divID="";
	//int  yAxisMin=0, yAxisMax=0;
	double  yAxisMin=0.0, yAxisMax=0.0;
	String xAxisDataType="", yAxisDataType="";
	String splitRange ="", splitRange1 ="";
	String valuesRange ="";

	divID = request.getParameter("divID");	
	//yAxisMin = Integer.parseInt(request.getParameter("yAxisMin"));		
	//yAxisMax = Integer.parseInt(request.getParameter("yAxisMax"));
	yAxisMin = Double.parseDouble(request.getParameter("yAxisMin"));		
	yAxisMax = Double.parseDouble(request.getParameter("yAxisMax"));
	
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	splitRange = request.getParameter("splitRange");
	//splitRange = splitRange.replace('>', '#');
	valuesRange = request.getParameter("valuesRange");

	/*************************/
	String tbodyStr = "<tbody>";
	String trStr = "<tr class=\"breakTr\">";
	String ctrStr = "</tr>";
	String ctbodyStr = "</tbody>";
	String ctableStr = "</table>";

	//int tdRangeDiff = 0;
	double tdRangeDiff = 0.0;
	//int tdRangeTot = 0;
	double tdRangeTot = 0.0;
	double tdHeight = 0.0;
	//int tdRoundHeight = 0;
	double tdRoundHeight = 0.0;
	//int totHeight = 0;
	double totHeight = 0.0;

	//int rangeMin = 0, rangeMax = 0;
	double rangeMin = 0, rangeMax = 0;
	
	//int pValue=0;
	double pValue=0;

	StringBuffer htmlData = new StringBuffer();	
	
	splitRange1 = splitRange.replace('>', '#');
	
	String[][] lineRange = null;		
	String[] ranges = null;	
	String[] rangeArray = null;	
	String pageSource = "", iFrameTag = "";
	
	DecimalFormat decim = new DecimalFormat("#.00");

	
	if (splitRange1.length() > 0) 
	{
		rangeArray = splitRange1.split("@");	
		for (int x=0; x<rangeArray.length; x++)
		{			
			ranges = rangeArray[x].split("~");			
		}
		lineRange = new String[rangeArray.length][ranges.length];	
		
		for (int x=0; x<rangeArray.length; x++)
		{						
			ranges = rangeArray[x].split("~");			
			for (int y=0;y<ranges.length;y++){
				lineRange[x][y] =  ranges[y];				
			}			
		}
	}
%>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<table class="breakTableLC" align="left" border="0" cellpadding="0" cellspacing="0" width=450px height=250px>
	<tbody>
		<tr class="breakTrLC">
			<td style="text-align: left" valign="top">
				<%
				if (splitRange1.length() > 0) 
				{
					
					if (yAxisMax>=100)
					{
						htmlData.append("<div class=\"colorG100I\">");	
					}
					else if (yAxisMax<100)
					{
						if (yAxisMin>1 && (yAxisMin % 1) == 0) {
							htmlData.append("<div  class=\"colorL100I\">");
						}
						else if (yAxisMin>1) 
						{
							htmlData.append("<div  class=\"colorL100D\">");
						}
						else
						{
							htmlData.append("<div  class=\"colorL001I\">");
						}
					}	
					totHeight = yAxisMax - yAxisMin;
					htmlData.append("<table class=\"LineGTable\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  align=\"left\">");
					//htmlData.append("<table Height=\""+totHeight+"\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  align=\"left\">");
						htmlData.append(tbodyStr);	
							//rangeMin = Integer.parseInt(lineRange[0][0]);
							//rangeMax = Integer.parseInt(lineRange[lineRange.length-1][1]);
							
							
							rangeMin = Double.parseDouble(lineRange[0][0]);
							rangeMax = Double.parseDouble(lineRange[lineRange.length-1][1]);
							
							if (totHeight>tdRangeTot)
							{
								if (yAxisMax>rangeMax)
								{
									tdRangeDiff = yAxisMax - rangeMax;				
									tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));

									htmlData.append(trStr);	
									htmlData.append("<td style=\"border-left:5px solid transparent\"  height=\""+tdHeight+"%\">&nbsp;</td>"); 
									htmlData.append(ctrStr);
								}
							}
							
							for (int i=lineRange.length-1;i>=0;i--){
								tdRangeDiff = Double.parseDouble(lineRange[i][1]) - Double.parseDouble(lineRange[i][0]);
								tdRangeDiff = Double.parseDouble(decim.format(tdRangeDiff));
								totHeight = Double.parseDouble(decim.format(totHeight));
								tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));
								tdHeight = Double.parseDouble(decim.format(tdHeight));
								htmlData.append(trStr);	
								htmlData.append("<td style=\"border-left:5px solid "+lineRange[i][2]+"\"  height=\""+tdHeight+"%\" title=\""+lineRange[i][0]+ " - "+lineRange[i][1]+"\">&nbsp;</td>"); 
								htmlData.append(ctrStr);
							}
							if (totHeight>tdRangeTot)
							{
								if (yAxisMin<rangeMin)
								{
									tdRangeDiff = rangeMin - yAxisMin;
									tdHeight = Math.round(((tdRangeDiff/(double)totHeight) * 100));
									htmlData.append(trStr);	
									htmlData.append("<td style=\"border-left:5px solid transparent\"  height=\""+tdHeight+"%\">&nbsp;</td>"); 
									htmlData.append(ctrStr);
								}
							}
						htmlData.append(ctbodyStr);
					htmlData.append(ctableStr);	
					htmlData.append("</div>");
					
				}
				
					pageSource = "../../eCA/jsp/ES_Kendo_LineChart_Child.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange;

					iFrameTag = "<iframe frameborder=\"0\" id=\""+divID+"\" src=\""+pageSource+"\" width=\"100%\" height=\"250px\" scrolling=\"no\"></iframe>";
				%>
				<%=htmlData%>			
				<table  class="breakTable" valign="top" align="left" border="0" width=400px height=200px>
					<tbody>
						<tr class="breakTrLC">
							<td>
								<%=iFrameTag%>		
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>
<style>

	.LineGTable{
		height: 170px; 
	}

	.colorG100I {    	
			position:relative;		
			top: 22px;
			left:77px;
	}  
	.colorL100I {    	
			position:relative;		
			top: 22px;
			left:70px;
	}  	
	.colorL100D {    	
			position:relative;		
			top: 22px;
			left:74px;
	}  	
	.colorL001I {    	
			position:relative;		
			top: 22px;
			left:80px;
	}  
</style>
	

