<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
	String  called_from			=	request.getParameter("called_from");
	String  relevantencounterid	=	request.getParameter("relevantencounter");
	String  admindate			=	"";
	String  fromtime			=	request.getParameter("fromtime");
	String  totime				=	request.getParameter("totime");
	String  helddiscontinued	=	request.getParameter("helddiscontinued");
	String  facilityid			=	request.getParameter("facilityid");
	String	mode				=	request.getParameter("mode");
	String admindate1			=	"";

	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";

	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name,request);
	HashMap scheduleDetails		=	new HashMap();



	HashMap sch_dates			=	bean.loadSchDates(relevantencounterid);
	ArrayList records			=	new ArrayList();
	String tab_title				=	"";
%>


<body onKeyDown="lockKey()"  onKeyDown = 'lockKey()'  >
<form name="AdminChart" id="AdminChart">
<%
if(called_from.equals("PAST")) {
	 records		=	(ArrayList) sch_dates.get("past_records");
	 tab_title			=	"Past Dosage Detail";
} else if(called_from.equals("FUTURE")) {
	 records		=	(ArrayList) sch_dates.get("future_records");
	 tab_title			=	"Future Dosage Detail";
}



%>
<%
for(int n=0; n<records.size(); n++) { 

	admindate	=	(String)records.get(n);

	String dflt_sch_date	=	admindate;
if (totime.equals(""))
	{
		admindate1=admindate+" 23:00";
	}
else
	{
		admindate1=admindate+" "+totime;
	}

if (fromtime.equals(""))
	{
		admindate=admindate+" 00:00";
	}
else
	{
		admindate=admindate+" "+fromtime;
	}

	if (helddiscontinued.equals("1"))
	{
	scheduleDetails=bean.populateScheduleDetails(facilityid,relevantencounterid,admindate,admindate1,"Y");

	}
	else
	{
	
	scheduleDetails=bean.populateScheduleDetails(facilityid,relevantencounterid,admindate,admindate1,"N");
	}

	
		String col_count=(String)scheduleDetails.get("COL_COUNT");
		int total_col=Integer.parseInt(col_count);
		String col_timings=(String)scheduleDetails.get("COL_TIMINGS");
		String sch_detail=(String)scheduleDetails.get("SCH_DETAILS");
		//String date_details=(String)scheduleDetails.get("DATE_DETAILS");
	
	%>




<table cellpadding="0" cellspacing="0"  border="0"  width="100%">
<% if(n==0) { %>
<th align="left"><%=tab_title%></th>
<%}%>
<tr>
	<td align="left" colspan="10" class="CURRTEXT"><font  style="font-weight:bold;color:black" size=1><fmt:message key="ePH.AdministrationDetailfor.label" bundle="${ph_labels}"/> <%=dflt_sch_date%></font></th>
</tr>
</table>
<table cellpadding="0" cellspacing="0"  border="1"   id="drugTable" name="drugTable" id="drugTable" width="100%">
<% if(n==0) { %>
	<th align="center"  class="HEADERTITLE" width="350"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
	<th align="center" class="HEADERTITLE" width="2"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>	
	<!---->
	<th align="center" class="HEADERTITLE" colspan="<%=total_col%>"><fmt:message key="ePH.Timings/Dosage.label" bundle="${ph_labels}"/></th>
<%	}	%>


				<tr>
				<td class='EMPTY' width="300" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td class='EMPTY'  width="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<%
		StringTokenizer time_token = new StringTokenizer(col_timings, "|");
		int time_counter=time_token.countTokens();
		String sch_time[]=new String[time_counter];
			int time_track=0;
			while (time_token.hasMoreTokens())
			{
			sch_time[time_track]=time_token.nextToken();
			time_track++;
			}
		for(int i=0;i<time_counter;i++){
	%>

		<td   align="center" width="60" class='TIMING' ><b><%=sch_time[i]%></b></td>
	<%	
	}//end of for-time-counter

%>
	</tr>
<%
	String classvalue,title;
	StringTokenizer schedule_dose_details = new StringTokenizer(sch_detail, "$$");
	int count=0;
	while (schedule_dose_details.hasMoreTokens())
	{
	String detail=(String)schedule_dose_details.nextToken();
	if ( count++ % 2 == 0 ){
					classvalue = "QRYEVEN" ;
			}else{
					classvalue = "QRYODD" ;
					}
	%>
		<tr>
	<%
	StringTokenizer dose_details = new StringTokenizer(detail, "~");
	String held	=	(String)dose_details.nextToken();
	String discontinued	=	(String)dose_details.nextToken();
	String order_id		=	(String)dose_details.nextToken();
	String drug_code	=	(String)dose_details.nextToken();
	String drug_name	=	(String)dose_details.nextToken();
	String schdatetime	=	(String)dose_details.nextToken();
	String qty_details	=	(String)dose_details.nextToken();
	String uom			=	(String)dose_details.nextToken();
	
		if ( held.equals("Y") )
		{
%>
		<td nowrap class='<%=classvalue%>'><font size='1'>
	 <%=drug_name%>&nbsp;<img src="../../ePH/images/stop.gif" title="Held Order!!!" ></font></td>
			<%
	}
		else
		{
		if (discontinued.equals("Y") )
		{
			%>
		<td nowrap class='<%=classvalue%>'><font size='1'><%=drug_name%>
			<img src="../../ePH/images/stop.gif" title="Discontinued Order!!!" >	
			</font></td>
				<%
		}
		else
			{
			%>
				<td nowrap class='<%=classvalue%>'><font size='1'><%=drug_name%></font></td>
				<%
			}

		}
		%>
		<td  class='<%=classvalue%>'><font size='1'><%=uom%></font></td>

	<%

		
			StringTokenizer qty_token = new StringTokenizer(qty_details, "|");
			int qty_counter=(qty_token.countTokens()/7);
			String date_qty[]=new String[qty_counter];
			String time_qty[]=new String[qty_counter];
			String sch_qty[]=new String[qty_counter];
			String sch_link[]=new String[qty_counter];
			String admin_recorded[]=new String[qty_counter];
			String systimegreater[]=new String[qty_counter];
			String altdrug1[]=new String[qty_counter];
			int qty_track=0;
			while (qty_token.hasMoreTokens())
			{
			altdrug1[qty_track]=qty_token.nextToken();
			date_qty[qty_track]=qty_token.nextToken();
			time_qty[qty_track]=qty_token.nextToken();
			sch_qty[qty_track]= qty_token.nextToken();
			sch_link[qty_track]=qty_token.nextToken();
			admin_recorded[qty_track]=qty_token.nextToken();
			systimegreater[qty_track]=qty_token.nextToken();
			qty_track++;
			}
				for(int i=0;i<qty_counter;i++){
				title				="Time - "+time_qty[i]+" -- "+drug_name+" "+sch_qty[i]+" "+uom;
				//This link denotes whether medication was administered or not
				if(sch_link[i].equals("Y")){
				//ADMINISTERED IS TRUE
							if(sch_qty[i].equals("0")){
						//direct administration has been carried out
						%>
							<td   align='center' class='<%=classvalue%>'  style="font-size:8pt;cursor:pointer;background-color:white;border-right:15px solid #00FF00;color:blue" title="<%=title%>" onClick="callAdminDetails('<%=relevantencounterid%>','<%=drug_code%>','<%=order_id%>','<%=date_qty[i]%>','<%=facilityid%>','Y',this,0)" >&nbsp;&nbsp;</td>
		<%				
						}
					else if (altdrug1[i].equals("0")) 
					{
						//alternate drug has been administered and so
								%>
						<td align='center' lass='<%=classvalue%>' style="cursor:pointer;background-color:white;border-right:15px solid #CC99CC; color:blue" onClick="callAdminDetails('<%=relevantencounterid%>',					'<%=drug_code%>','<%=order_id%>','<%=date_qty[i]%>','<%=facilityid%>','Y',this,1)" >
						<font align='center' size='1'  title='<%=title%>'><%=sch_qty[i]%></font></td>
						<%
					}
					else
					{
								%>
										<td  align='center' class='<%=classvalue%>' style="background-color:white;cursor:pointer;border-right:15px solid green;color:blue" onClick="callAdminDetails('<%=relevantencounterid%>',					'<%=drug_code%>','<%=order_id%>','<%=date_qty[i]%>','<%=facilityid%>','Y',this,1)" >
						<font align='center' size='1'  title='<%=title%>'><%=sch_qty[i]%></font></td>
						<%
					}
					
							
				}else{
						//ADMINISTERED IS FALSE		
						
						if(sch_qty[i].equals("M")){
							sch_qty[i]="&nbsp;";
						}
					if(admin_recorded[i].equals("N")&&(systimegreater[i].indexOf("Y")!=-1 )  ){
												//admin not recorded 
						%>
					<td   align='center' class='<%=classvalue%>' style="
						 background-color:white; border-right:15px solid black;color:black" ><font size='1'  title='<%=title%>'><%=sch_qty[i]%></font></td>
					<%
															
					}
					else if(admin_recorded[i].equals("N")&& (systimegreater[i].indexOf("N")!=-1 ) )
					{
						//admin not recorded 
					%>
					<td  align='center' class='<%=classvalue%>' style=" background-color:white;border-right:15px solid SILVER;color:black;" ><font size='1'  title='<%=title%>'><%=sch_qty[i]%></font></td>

					<%
					}
					else if(admin_recorded[i].equals("Y"))
					{
							//admin recorded  but administration not carried out
					%>
									<td  align='center' class='<%=classvalue%>' style="background-color:white;color:blue;border-right:15px solid red;cursor:pointer" onClick="callAdminDetails('<%=relevantencounterid%>','<%=drug_code%>','<%=order_id%>','<%=schdatetime%>','<%=facilityid%>','N',this,1)" ><font size='1'  title='<%=title%>'><%=sch_qty[i]%></font></td>
					<%
					}
					else
					{
						%>
									<td   align='center' class="<%=classvalue%>" style="background-color:white;"> 
									<font size='1'  title='<%=title%>'><%=sch_qty[i]%>
						</font></td>
					<%
					}

			
				}
		
	}
	%>
		</tr>


<%
	}



	%>
	</TABLE>
	</SPAN>
<%	
		}
%>
<input type="hidden" name="admindate" id="admindate" value="">	
<input type="hidden" name="fromtime" id="fromtime" value="<%=fromtime%>">
<input type="hidden" name="totime" id="totime" value="<%=totime%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
<input type="hidden" name="helddiscontinued" id="helddiscontinued" value="<%=helddiscontinued%>">
<input type="hidden" name="relevantencounter" id="relevantencounter" value="<%=relevantencounterid%>">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

