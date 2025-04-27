<!DOCTYPE html>
<%@ page import ="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<style>
<!--
p.MsoNormal, li.MsoNormal, div.MsoNormal
	{mso-style-parent:"";
	margin:0in;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
@page Section1
	{size:8.5in 11.0in;
	margin:1.0in 1.25in 1.0in 1.25in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
-->
</style>
<style>
TD.DISPDATE {
  FONT-FACE: verdana ;
  FONT-SIZE: 8pt ;
  BACKGROUND-COLOR: #FED6B1;
  COLOR:blue;
}
TD.DISPHOLIDAY {
  FONT-FACE: verdana ;
  FONT-SIZE: 8pt ;
  BACKGROUND-COLOR: #CFCFCF;
  COLOR:black;
}
</style>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<%! int TotNum=0;%>
	<%

	//String s=request.getQueryString();
	
	String ca_patient_id=request.getParameter("patient_id");
	
	if(ca_patient_id==null) ca_patient_id="";
	String Practitioner_Id=request.getParameter("i_practitioner_id");
	String clinic_code=request.getParameter("location_code");
	if (clinic_code==null)
	clinic_code=request.getParameter("i_clinic_code");
	String practitioner_id=(String)session.getValue("ca_practitioner_id");
	if(practitioner_id == null) practitioner_id = Practitioner_Id;
	if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
	String apptrefno=request.getParameter("i_appt_ref_no");
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	apptrefno = "";
	old_date = "";
//	fid = "";

	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
tfr_appt_across_catg_yn="";
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	alcn_criteria="";
	String old_alcn_catg_code="";
	String practitioner_name="";
	String overbookedyn=request.getParameter("over_booked");
	String callingMode = request.getParameter("callingMode");
	if(callingMode == null) callingMode="";
	overbookedyn ="Y";

	if(Practitioner_Id==null || Practitioner_Id.equals("null"))Practitioner_Id="";
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	
	

	%>

	<%!
			public String getCalendarString(Connection con,String arg,HttpServletResponse res) throws java.io.IOException
			{
				
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				PrintWriter out = res.getWriter();
				try
				{
					
		   			
					sql="select get_calendar_string(?) from dual";
					stmt=con.prepareStatement(sql);
					stmt.setString(1,arg);
					rs=stmt.executeQuery();
					if(rs.next())
					RetString=rs.getString(1);
					//out.print(RetString);
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					
					//out.println("Execption in CAMainHomePageSchedules.jsp"+e.toString());//COMMON-ICN-0181
                                           e.printStackTrace();//COMMON-ICN-0181
				}
				

				return RetString;
			}
	%>

	<%!
			public String getCalanderStatusColor(String Facility_Id, String Clinic_Code, String Practitioner_Id, Connection con,String arg)
			{
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				
				try
				{
		   			
					sql="SELECT GET_CALENDAR_STATUS_COLOR (?,?,?,?) FROM DUAL";
//		   			
					stmt=con.prepareStatement(sql);
					stmt.setString(1,Facility_Id);
					stmt.setString(2,Clinic_Code);
					stmt.setString(3,Practitioner_Id);
					stmt.setString(4,arg);
					rs=stmt.executeQuery();
					if(rs.next())
						RetString=rs.getString(1);
					
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
				}
				
				return RetString;
			}
	%>

	<%!

		public String getYearMonth(String state,int TotNum)
		{
			Calendar cal=Calendar.getInstance();
			int current=cal.get(Calendar.MONTH);

			String arg="";
			String mont="";
			if(state.equals("previous"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);

				if(cal.get(Calendar.MONTH)>=current)
					state="current";
			}

			if(state.equals("current"))
			{
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(state.equals("next"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(mont.length()==1)
					mont=0+mont;
				arg=arg+mont;

			//if(back_diary !=null && back_diary.equals("back_diary"))
			//arg=lat_arg;
			return arg;
		}
	%>


	<SCRIPT>

		function fun(){}
		
		function callDisplayOAResultsblock(date)
		{
         alert(getMessage("SCHEDULE_BLOCK")+" " +date);
		}
		function nextMonth(Totnum)
		{
				//parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum+1
				var param="../../eCA/jsp/CAMainHomePageSchedules.jsp?i_practitioner_id=<%=Practitioner_Id%>&i_clinic_code=<%=clinic_code%>&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&status=P1&TotNum="+Totnum
				self.location.href=param
					//&callingMode=<%=callingMode%>
		}

		function previousMonth(Totnum)
		{
			if(Totnum>0)
			{
				//parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum-1;
				var param="../../eCA/jsp/CAmainHomePageSchedules.jsp?i_practitioner_id=<%=Practitioner_Id%>&i_clinic_code=<%=clinic_code%>&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&status=M1&TotNum="+Totnum
				self.location.href=param
					//&callingMode=<%=callingMode%>
			}
		}

		function rfresh(obj)
		{
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				var param="../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=<%=Practitioner_Id%>&patient_id=<%=ca_patient_id%>&i_clinic_code="+obj.value
				self.location.href=param
					//&callingMode=<%=callingMode%>
		}

		function change_schedule(obj){
		
		var param="../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=<%=practitioner_id%>&i_clinic_code="+obj.value+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&patient_id=<%=ca_patient_id%>&over_booked=<%=overbookedyn%>&alcn_criteria="+document.forms[0].alcn_criteria.value;
		self.location.href=param
		parent.frames[1].location.href='../../eCommon/html/blank.html'
		//&callingMode=<%=callingMode%>
		}


		function callDisplayOAResultsForOp(clinic, mon, yr,dt)
		{
			
			if(mon.length==1)
					mon="0"+mon
			if(dt.length==1)
					dt="0"+dt
			var dt=dt+"/"+mon+"/"+yr;
			var i_appt_ref_no=document.forms[0].apptrefno.value;
			var i_clinic_code=document.forms[0].clinic_code.value;
			var i_practitioner_id=document.forms[0].practitioner_id.value;
			var i_appt_date=document.forms[0].old_date.value;
			var new_appt_date=dt;
			var old_alcn_catg_code=document.forms[0].old_alcn_catg_code.value;
			var alcn_criteria=document.forms[0].alcn_criteria.value;
			//alert('here  :'+alcn_criteria);
			var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
			var over_booked=document.forms[0].over_booked.value;
			//alert("over_booked  :"+over_booked);
			//alert("tfr_appt_across_catg_yn  :"+tfr_appt_across_catg_yn);
			var ca_mode='ca_mode';
			var ca_patient_id=document.forms[0].ca_patient_id.value;
			var callingMode=document.forms[0].callingMode.value;
			
			var param="../../eOA/jsp/SinglePractVw.jsp?tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&old_alcn_catg_code="+old_alcn_catg_code+"&alcn_criteria="+alcn_criteria+"&i_appt_ref_no="+i_appt_ref_no+"&clinic_code="+i_clinic_code+"&practitioner_id="+i_practitioner_id+"&over_booked="+over_booked+"&callingMode="+callingMode+"&old_date="+i_appt_date+"&Date="+new_appt_date+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode;
			//alert(parent.frames[1].name);
			parent.frames[1].location.href=param;



		}
	</SCRIPT>
	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

	<b><font color='red'><fmt:message key="eCA.MySchedules.label" bundle="${ca_labels}"/></font></b>


		<%
			//Connection con=(Connection) session.getValue("connection");
			Connection con = ConnectionManager.getConnection();
			PreparedStatement stmt=null;
			
 			ResultSet rs=null;
			int coi=0;
			String week[]=new String[7];
			String day_type[]=new String[7];
			try{
			String sql_week="select substr(DAY_OF_WEEK,1,3),DAY_TYPE,DAY_NO from sm_day_of_week order by DAY_NO";
				stmt=con.prepareStatement(sql_week);
				rs=stmt.executeQuery();
					if(rs!=null){
					 while(rs.next())
					{
					  week[coi]=rs.getString(1);
					  day_type[coi]=rs.getString(2);
					  coi++;
					}
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception es){
			//out.println("Exec@4"+es);//COMMON-ICN-0181
                          es.printStackTrace();//COMMON-ICN-0181
			}
			String Color_Code[]={"S","Y","G","R","B","H"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			String cliniccode=request.getParameter("location_code");
			if (cliniccode==null)
			cliniccode=request.getParameter("i_clinic_code");

			String colorclass="";
			String status=request.getParameter("status");
			String state="current";
			
			if(status!=null)
			{
				if(status.equals("P1"))
					state="next";
				if(status.equals("M1"))
					state="previous";
			}
			
			
			
			try
			{
				
				if(request.getParameter("TotNum")!=null){
				TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}
				else{	
				int curr_month=0;
				String sql_date="select to_char(sysdate,'mm'),to_char(sysdate,'dd/mm/yyyy')from dual";
				stmt=con.prepareStatement(sql_date);
				rs=stmt.executeQuery();
					if(rs.next()){
					curr_month=rs.getInt(1);
					old_date=rs.getString(2);
					}
				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(old_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
						mon_date=mon;}
						count++;
				}
				int month_of_year=Integer.parseInt(mon_date);
				TotNum=month_of_year-curr_month;	

				}

				if(TotNum==0)
				{
				state="current";
				}
				else
				{
					if(TotNum > 0)
					{
					   state="next";
					}
				}

				
				
			}
			catch(Exception e)
			{
				//out.println("Exception");
			//	out.println("Exeception in CAMainHomePageSchedules.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181

			}
			
			
			//out.print(state);
			String arg=getYearMonth(state,TotNum);

			
			String CalString=(String)getCalendarString(con,arg,response);
			

			String ColorString=getCalanderStatusColor(fid,cliniccode,Practitioner_Id,con,arg);

			String yr=arg.substring(0,4);
			//int cal_yr=Integer.parseInt(yr);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			//int cal_mon=mon;
			//int cal_day=0;
			String month=months[mon-1];

			StringTokenizer splitdays=new StringTokenizer(CalString,"|");
			String[] NumOfDays=new String[splitdays.countTokens()];

			StringTokenizer ColVals=new StringTokenizer(ColorString,"|");
			String colors[]=new String[ColVals.countTokens()];

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]=splitdays.nextToken();
			for(int i=0;i<colors.length;i++)
				colors[i]=ColVals.nextToken();

				int ro=NumOfDays.length/7;
				int rodup=1;
				int ccols=7;
				String dat="";
				int act=0;
			%>

		<form>


			<%
 			try
 			{	if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			
				String pract_str="select practitioner_name from am_practitioner where  practitioner_id= ? "; 
				stmt=con.prepareStatement(pract_str);
				stmt.setString(1,practitioner_id);
				rs = stmt.executeQuery();
				if(rs !=null){
					while ( rs.next() )
						{
							practitioner_name= rs.getString("practitioner_name");
						}
				}
							

				if(practitioner_name==null) practitioner_name="";			
			

%>
			
			<%
				String my=month+","+yr;
				
			%>

			</table>
			<!-- <table border=0 cellspacing=0 cellpadding=0 width='50%'>	
			<tr><td class='label' colspan='2'></td></tr><tr><td class='label' colspan='2'></td></tr><tr><td class='label' colspan='2'></td></tr><tr><td class='label' colspan='2'></td></tr>
			<tr><td class='white'>&nbsp;</td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr>


			</table> -->
			<table  align='center' border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr><td class='white' width='25%'>
			<table  align='center' border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr >
				<td  width='50%' class='white' >
				<table cellspacing=0 cellpadding=0  width='100%' style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt' border='0'>
					
					<tr>
						<td align='center' width='10%'><input type='button' class='button' value="<---" name='prev' id='prev'  onclick=previousMonth(<%=TotNum%>)></td>
						<td align='center' class="DISPDATE" width='140%'><font size=3><b><%=my%></b></font></td>
						<td align='center' width='10%'><input type='button' class='button' value="--->" name='next' onclick=nextMonth(<%=TotNum%>)></td>
					</tr>
				</table>
				</td>
			</tr>
			<input type='hidden' name='callingMode' id='callingMode' value='<%=callingMode%>' >
			<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>' >
			<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>' >
			<input type='hidden' name='apptrefno' id='apptrefno' value='<%=apptrefno%>' >
			<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >
			<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
			<input type='hidden' name='old_alcn_catg_code' id='old_alcn_catg_code' value='<%=old_alcn_catg_code%>' >
			<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
			<input type='hidden' name='over_booked' id='over_booked' value='<%=overbookedyn%>' >
			<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>' >
			</form>
		<tr>
		<table width='21%'  align='center' cellpadding=0  style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt '>
		<tr>
			<%for( int j=0;j<week.length;j++){
				%>
				<td class='columnHeader'  width='3%' align='center' ><font size=1><%=week[j]%></td>	<%}%>
		</tr>
		<%for( int j=0;j<ro;j++)
			{
			
			%>
				  <tr>
				  	<%

				  	for(int k=0;k<ccols;k++)
				  	{
						if(day_type[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						if(act<NumOfDays.length)
				  		{
				  			if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
								//cal_day=Integer.parseInt(NumOfDays[act]);

				  				for(int i=0;i<Color_Code.length;i++)
				  				{
											
				  					if(Color_Code[i].equals(colors[act]))
				  						colorclass=Color_Val[i];					
								
				  				}
				  			}
				  			else
				  			{
				  				if(rodup==(NumOfDays.length/7) && 	NumOfDays[act].equals("0"))
				  				{
				  					
				  					dat="&nbsp";
				  					break;
				  				}
				  				else{
				  					dat="&nbsp";
									
								}

				  			}
				  		}
				  		else{
				  			dat="&nbsp";
						}
						
				  			String anch=" ";
							String title=dat+"/"+mon+"/"+yr;
				  			act++;
							//		out.println("<script language=javascript>alert('')</script>");
				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
										out.println("<script language=javascript></script>");
							if (colorclass.equals("OARed"))
							{
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";
									out.println("<script language=javascript>alert('1')</script>");
							}
							else
							{
								anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"') title='"+title+"'  >";
										out.println("<script language=javascript>alert('2')</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
							}
							}
				  
					if(allow_click)
					{
						if(colorclass.equals("OAHOLIDAY"))
						{
						%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font 	size=2><%=dat%></a></td>
					  	<%
						}
					else
						{
						%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
					  	<%
						}
					}
					else
					{
					if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY"))
							{
							%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=dat%></a></td>
				  			<%
							}
							else							
							{
							%>
				  			<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
				  			<%
						}
						}
						else
						{
							%>
				  			<td align='center' width='3%'><font size=2><%=dat%></a></td>
				  			<%
				  		}
					}
					colorclass="";	  	
						
					
					}

				  	%>
				  </tr>
		<%rodup++;
			}%>
		</tr>

		</table>
		</td><td class='white' id='detail' width='75%'  rowspan=9 height='100%'>
			<table  align='left' border=1 cellspacing=0 cellpadding=0 width='100%' height='100%'>
				<tr><td class='QRYEVEN' align=center><b><fmt:message key="eCA.OPBookings.label" bundle="${ca_labels}"/></b></td></tr>
				<tr><td  class='QRYODD' align=center><b>IP Bookings</b></td></tr>
				<tr><td  class='QRYEVEN' align=center><b><fmt:message key="eCA.OTBookings.label" bundle="${ca_labels}"/></b></td></tr>
			</table>
		</td></tr></table>
	<%		if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			}
		catch(Exception e)
		{
			//out.println("ERROR@2"+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
						
					
		}
			%>
	</body>
</html>

