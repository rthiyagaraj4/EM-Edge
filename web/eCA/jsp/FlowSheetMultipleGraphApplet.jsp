<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String minValue="100000000000.0";
	String values = request.getParameter("values")==null?"":request.getParameter("values");

	//StringTokenizer temp=new StringTokenizer(values,"`");
	//values +=values+",";

	String dates = request.getParameter("dates")==null?"":request.getParameter("dates");
	String totcols = request.getParameter("totcols")==null?"":request.getParameter("totcols");
	String unit = (request.getParameter("unitval")==null || request.getParameter("unitval").equals(""))?" ":request.getParameter("unitval");

	String event = request.getParameter("eventval")==null?" ":request.getParameter("eventval");
	
	String seriesCount=request.getParameter("seriescount")==null?"1":request.getParameter("seriescount");
	int i=0;
	
	//---------------------

	String linecolor[] = {"blue","red","green","yellow","grey","violet"};

	//---------------------


	//******setting the parameter for showing the multiple graphs in diffrent frames****//
	
	/*out.println(values);
	out.println(dates);
	out.println(unit);
	out.println(event);
	out.println(seriesCount);*/


	String vSpace="30";
	String gridyPos="370";
	String labelY="380";
	String xTitle="420";
	String yTitle="350";
	String heightChart="420";
	String fontSize="18";

	/*
	if(seriesCount.equals("3"))
	{
		vSpace  = "10";
		gridyPos= "140";
		labelY  = "150";
		xTitle  = "180";
		yTitle  = "160";
		colorVal=(int)Math.round(Math.random()*1000);
		colorVal1=(int)Math.round(Math.random()*1000);
		//colorVal= 100;
		//colorVal1= 75;
		heightChart="250";
		fontSize="12";
		//seriesCount="1";
	}
	else if(seriesCount.equals("2"))
	{
		vSpace  = "15";
		gridyPos= "180";
		labelY  = "190";
		xTitle  = "220";
		yTitle  = "200";
		colorVal=(int)Math.round(Math.random()*1000);
		colorVal1=(int)Math.round(Math.random()*1000);
		heightChart="250";
		fontSize="15";

		//seriesCount="1";
	}
	else if(seriesCount.equals("1"))
	{
		vSpace  = "30";
		gridyPos= "370";
		labelY  = "380";
		xTitle  = "420";
		yTitle  = "350";
		colorVal=(int)Math.round(Math.random()*1000);
		colorVal1=(int)Math.round(Math.random()*1000);
		heightChart="420";
		fontSize="18";

		
	}
	

	//***********************************************************************************
	*/
	//if(!(unit.equals(""))) unit =  "  /  "+unit;
	//t.println(totcols);
	i = Integer.parseInt(totcols);
	
	i=i+1;
	int width = (i*80)+150;

	if(width > 2000)
		width = 2000;
	if(width < 200)
		width = 200;
		
	int j =1;

	String datinhrs[] = new String[i];
	int k=1;
	String arr[] = new String[i];
	double max = 0.0;
	double min  = 100000000000.0;

	String rowScale      = "";
	String widthChart =""+width;
	

	%>
	<html>
		<head>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
		</head>
	<applet code="LineGraphApplet.class" codebase="../MediPainter/" archive="LineGraphapplet.jar" width="<%=widthChart%>" height="<%=heightChart%>">
 
	<!-- Start Up Parameters -->
	<PARAM name="LOADINGMESSAGE" value="Flow Sheet Graph Loading - Please Wait..."> <!-- Message to be displayed on Startup -->
	<PARAM name="STEXTCOLOR" value="0,0,100"> <!-- Message Text Color-->
	<PARAM name="STARTUPCOLOR" value="255,255,255"> <!-- Applet Background color -->
	<!-- Chart Switches -->

	<PARAM name="3D" value="false"> <!-- 3D mode On/Off -->
	<PARAM name="grid" value="true"> <!-- Grid On/Off -->
	<PARAM name="axis" value="true"> <!-- Axis On/Off -->
	<PARAM name="ylabels" value="true"> <!-- y Labels On/Off -->
	<PARAM name="outline" value="true"> <!-- Outline On/Off -->
	<PARAM name="legend" value="true"> <!-- Legend On/Off -->

	<!-- Chart Characteristics -->
	<PARAM name="nPoints" value="<%=totcols%>"> <!-- Max Number of Points per series-->
	<PARAM name="nRows" value="10"> <!-- Number of Rows for the grid -->
	<PARAM name="vSpace" value="<%=vSpace%>"> <!-- Vertical spacing, number of Pixels -->
	<PARAM name="nSeries" value="<%=seriesCount%>"> <!-- Number of Series -->
	<PARAM name="hSpace" value="50"> <!-- Horizontal spacing, Pixels-->
	<PARAM name="gridxpos" value="250"> <!-- X position to start grid -->
	<PARAM name="gridypos" value="<%=gridyPos%>"> <!-- Y position to start grid -->
	<PARAM name="gridstyle" value="2"> <!-- grid line style -->
	<PARAM name="depth3D" value="15"> <!-- Depth of 3D effect, number of Pixels -->
	<PARAM name="ndecplaces" value="2"> <!-- Number of Decimal places to display values -->
	<PARAM name="labelOrientation" value="5"> <!-- x axis label orientation -->
	<PARAM name="labelsY" value="<%=labelY%>"> <!-- Y position of x axis labels-->

	<PARAM name="linecolor" value="<%=linecolor%>"> <!-- for colors of our preference-->
	
	<!-- x axis Labels -->
	<%

		try
		{
			StringTokenizer st1 = new StringTokenizer(dates,",");
			String firstSet=st1.nextToken();
		
			StringTokenizer st2 = new StringTokenizer(firstSet,"`");
			String padding="";
			while(st2.hasMoreTokens())
			{
				if ( j % 2 == 0 )
					padding = "";
				else
					padding = "|-10" ;
				datinhrs[j]= st2.nextToken();

				%>
					<PARAM name="label<%=j%>" value="<%=datinhrs[j]%><%=padding%>">
				<%
				j++;
			}
	
		}
		catch(Exception e)
		{
				
				out.print("<script>alert('Exception1 @1"+e+"')</script>");
		}
		//out.println("<script>alert('"+firstSet+"')</script>");
			
	%>

	<!-- Additional font information -->
	<PARAM name="font14" value="Arial,N,10"> <!-- Y labels Font -->
	<PARAM name="font15" value="Arial,N,10"> <!-- X labels Font -->

	<!-- Additional color information -->
	<PARAM name="color14" value="170,170,170"> <!-- gridcolor -->
	<PARAM name="color15" value="0,0,255"> <!-- axiscolor -->
	<PARAM name="color16" value="0,100,170"> <!-- floorcolor -->
	<PARAM name="color17" value="0,0,0"> <!-- outline color -->
	<PARAM name="color18" value="50,50,50"> <!-- label color -->
	<PARAM name="color19" value="50,50,50"> <!-- Y color -->

	<!-- Legend Information -->
	<!-- <PARAM name="legendfont" value="Arial,N,10"> 
	<PARAM name="legendposition" value="345,15">
	

	<!-- Titles - Main, x and y -->
	<!-- <PARAM name="title" value="text,xpos,ypos,font-type,font-style,font-size,Rcolor,Gcolor,Bcolor"> -->
	<PARAM name="xtitle" value="Date/Time |250,<%=xTitle%>|TimesRoman,B,<%=fontSize%>|100,100,200">
	<% if (seriesCount.equals("1"))
	   {
		%>
			<PARAM name="ytitle" value="<%=event%>|180,<%=yTitle%>|TimesRoman,B,<%=fontSize%>|100,100,200">
	<% }
	   else%>
			<PARAM name="ytitle" value="Events|180,350|TimesRoman,B,18|100,100,200">



	<!-- Free Form Text -->
	<!--<PARAM name="textn" value="text,xpos,ypos,font-type,font-style,font-size,Rcolor,Gcolor,Bcolor"> -->
	<!-- <PARAM name="text1" value="Note :|80,15|Arial,N,10|100,100,200">
	
	<!-- Series Data -->


<!--========================added 24-02-2003=====================-->

	<%
		try{
			StringTokenizer events = new StringTokenizer(event,",");
			StringTokenizer units  = new StringTokenizer(unit,",");
			int ii=1;
			int color=175;
			int color1=20;
			while(events.hasMoreTokens())
			{
				String eve=events.nextToken();
				String uni="/ "+units.nextToken();
				%>
				<PARAM name="series<%=ii%>"  value="<%=color%>,<%=color1%>,8|6|8|true|<%=eve%>  <%=uni%>">
		<% 
				color-=100;
				color1+=100;
				if(color>255)
					color-=75;
				ii++;
			}//end while
		}catch(Exception e)
		{
			out.println("Exception 3"+e);
		}
		%>
	
	




	<!-- Point Data -->
	<!-- <PARAM name="dataNseriesN" value="value|URL|Target Frame"> -->
	<%
	try
	{
		StringTokenizer seriesVal = new StringTokenizer(values,",");
		int jj=1;
		while(seriesVal.hasMoreTokens())
		{
			int position=0;
			String first=seriesVal.nextToken();
			StringTokenizer data=new StringTokenizer(first,"`");
			while(data.hasMoreTokens())
			{
				arr[k] = data.nextToken();
				//added later for position number
				StringTokenizer dataVal=new StringTokenizer(arr[k],"~");
				arr[k] = dataVal.nextToken();
				//if(arr[k].equals("!!!"))
					//arr[k]="";
				position =Integer.parseInt(dataVal.nextToken());
				//ends here
				if(Double.parseDouble(arr[k])<Double.parseDouble(minValue))
				{
					minValue=arr[k];
				}
				if(seriesCount.equals("1"))//when only one graph is there we will skip the date which doesnot have any record...so will not take care of the positions
				{
					
					%>
					<PARAM name="data<%=k%>series<%=jj%>" value="<%=arr[k]%>">
					<%

				}
				else
				{
					
					%>
					<PARAM name="data<%=position%>series<%=jj%>" value="<%=arr[k]%>">
					<%
				}
					if(Double.parseDouble(arr[k]) > max) max = Double.parseDouble(arr[k]);
					if(Double.parseDouble(arr[k]) < min) min = Double.parseDouble(arr[k]);
				k++;
				
			}
			k=1;
			jj++;
		//-* Find the max and min values*-//
//			double nRows = (max/10);
			double nRows = ((max+1-(Double.parseDouble(minValue)))/10);
			nRows		=  Math.ceil(nRows);	
			
			rowScale      = ""+nRows;
			//minValue=""+minValueForY;
		}	
	}
	catch(Exception e)
	{
		
		out.print("Exception2 "+e);
	}
	//converting the decimal value to the integer value for minimum y
	long tempLong=(long)Double.parseDouble(minValue);
	minValue=""+tempLong;
	%>

<!--========================ends here=======================================-->


	
	<PARAM name="chartScale" value="<%=rowScale%>">
	<PARAM name="chartStartY" value="<%=minValue%>"> <!-- Starting Y value -->
	</applet>
	<!-- <script>alert("<%=minValue%>");</script> -->
	<html>
<%

}
catch(Exception e1)
{
	out.println("main "+e1);
	e1.printStackTrace();
}
%>
	

