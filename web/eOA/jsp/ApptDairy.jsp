<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 		
29/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Reopened - added order_id in var params(functions callthis, rfresh, nextMonth, previousMonth, change_schedule > 								 
---------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>    
<html>
  
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
	<%! int TotNum=0;%>
	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String Practitioner_Id=request.getParameter("i_practitioner_id");
	String clinic_code=request.getParameter("i_clinic_code");
	String practitioner_id=request.getParameter("i_practitioner_id");
	if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
	String apptrefno=request.getParameter("i_appt_ref_no");
	String obook_appt_yn=request.getParameter("obook_appt_yn");
	if( obook_appt_yn == null || obook_appt_yn.equals("null") ) obook_appt_yn="";
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	String practitioner_name=(String)request.getParameter("practitioner_name");
	if(practitioner_name ==null) practitioner_name="";
	String clinic_name1=(String)request.getParameter("clinic_name");
	if(clinic_name1 ==null) clinic_name1="";
	String old_alcn_catg_code="";
	//String clinic_name="";
	//String new_practitioner_name="";
	//String new_practitioner_id="";
	String speciality_code="";
//	String service_desc="";
	String overbookedyn=request.getParameter("over_booked");
	String visit_type_ind=request.getParameter("visit_type_ind");
	String team_id=request.getParameter("i_team_id");

	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String order_id=request.getParameter("order_id");//--[IN027165]

	String visit_limit_rule=request.getParameter("visit_limit_rule");
	String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");

	String old_visit_type_ind1=request.getParameter("old_visit_type_ind1");
	String old_alcn_catg_code1=request.getParameter("old_alcn_catg_code1");
	String no_of_slots_value1=request.getParameter("no_of_slots_value1");
	String patient_id1=request.getParameter("patient_id1");
	String old_pract_id1=request.getParameter("old_pract_id1");	
	String old_clinic_code=request.getParameter("old_clinic_code")==null?"":request.getParameter("old_clinic_code");	
	int curr_month=Integer.parseInt(request.getParameter("curr_month"));
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn");

	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";

	String Forced=request.getParameter("Forced");


	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
	care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}

	String res_class_desc="";
	if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}else if(res_type.equals("B")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
	}


	String chk_flg="N";
	if(Practitioner_Id==null || Practitioner_Id.equals("null"))Practitioner_Id="";
	if(clinic_code==null)clinic_code="";
	if(team_id==null)team_id="";
	if(visit_type_ind==null)visit_type_ind="";
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	String locale=(String)session.getAttribute("LOCALE");
	%>

	<%!
	public String getCalendarString(Connection con,String arg)
			{
				
				Statement stmt=null;
				ResultSet rs=null;
				String RetString="";
				try
				{
					
					stmt=con.createStatement();
					rs=stmt.executeQuery("select get_calendar_string('"+arg+"') calstr from dual");
					if(rs.next())
					RetString=rs.getString("calstr");
					if(rs!=null)			rs.close();
					if(stmt!=null)		stmt.close();
				}
				catch(Exception e)
				{}
				finally
				{
					try
					{
						if(stmt!=null)		stmt.close();
						if(rs!=null)			rs.close();
						
					}
					catch(Exception e){}
				}

				return RetString;
			}
			
			%>

	<%!
			public String getCalanderStatusColor(String Facility_Id,String Clinic_Code, String Practitioner_Id, Connection con,String arg)
			{
				//Statement stmt=null;
				PreparedStatement pstmt = null;
				ResultSet rs=null;
				String RetString="";				
				String sql = "";				
				try
				{
		   			//below lined modified by Kamatchi S for security issue against COMMON-ICN-0165
					//stmt=con.createStatement();
					//rs=stmt.executeQuery("SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Practitioner_Id+"','"+arg+"') stss FROM DUAL");
					sql = " SELECT GET_CALENDAR_STATUS_COLOR (?,?,?,?) stss FROM DUAL";
					pstmt   = con.prepareStatement(sql);
					pstmt.setString(1, Facility_Id);
					pstmt.setString(2, Clinic_Code);
					pstmt.setString(3, Practitioner_Id);
					pstmt.setString(4, arg);
					//System.err.println("SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Practitioner_Id+"','"+arg+"') stss FROM DUAL");
					rs=pstmt.executeQuery();
					if(rs.next())
						RetString=rs.getString("stss");
						if(rs!=null)			rs.close();
						//if(stmt!=null)		stmt.close();
						if(pstmt!=null)		pstmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:";
				}
				
				return RetString;
			}
			
	%>

	<%!
		public String getYearMonth(String state, int TotNum)
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
			return arg;
		}
	%>

<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'> </script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eOA/js/ApptDiary.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<SCRIPT>
         function callthis(obj,obj2)
{

	if(obj.value =="")
	{
		parent.frames[2].location.href='../../eCommon/html/blank.html'
		parent.frames[3].location.href='../../eCommon/html/blank.html'
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_id.value="";
		var param="../../eOA/jsp/ApptDairy.jsp?i_practitioner_id="+obj.value+"&i_clinic_code="+obj2.value+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&obook_appt_yn=<%=obook_appt_yn%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&status=P1&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&Forced=<%=Forced%>&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&old_visit_type_ind1=<%=old_visit_type_ind1%>&old_alcn_catg_code1=<%=old_alcn_catg_code1%>&no_of_slots_value1=<%=no_of_slots_value1%>&patient_id1=<%=patient_id1%>&old_pract_id1=<%=old_pract_id1%>&old_clinic_code=<%=old_clinic_code%>&curr_month=<%=curr_month%>&rd_appt_yn=<%=rd_appt_yn%>&order_id=<%=order_id%>&order_catalog_code="+document.forms[0].order_catalog_code.value; //--[IN027165]
				location.href=param
	}else
	{
	}
}
		function nextMonth(Totnum)
		{
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				parent.frames[3].location.href='../../eCommon/html/blank.html'

				Totnum=Totnum+1
				var param="../../eOA/jsp/ApptDairy.jsp?i_practitioner_id="+document.forms[0].practitioner_id.value+"&i_clinic_code="+document.forms[0].clinic_code.value+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&obook_appt_yn=<%=obook_appt_yn%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&status=P1&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&Forced=<%=Forced%>&TotNum="+Totnum+"&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&old_visit_type_ind1=<%=old_visit_type_ind1%>&old_alcn_catg_code1=<%=old_alcn_catg_code1%>&no_of_slots_value1=<%=no_of_slots_value1%>&patient_id1=<%=patient_id1%>&old_pract_id1=<%=old_pract_id1%>&old_clinic_code=<%=old_clinic_code%>&curr_month=<%=curr_month%>&rd_appt_yn=<%=rd_appt_yn%>&order_id=<%=order_id%>&order_catalog_code="+document.forms[0].order_catalog_code.value; //--[IN027165]
				self.location.href=param
		}

		function previousMonth(Totnum)
		{
			if(Totnum>0)
			{
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				parent.frames[3].location.href='../../eCommon/html/blank.html'

				Totnum=Totnum-1
				var param="../../eOA/jsp/ApptDairy.jsp?i_practitioner_id="+document.forms[0].practitioner_id.value+"&i_clinic_code="+document.forms[0].clinic_code.value+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&obook_appt_yn=<%=obook_appt_yn%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&Forced=<%=Forced%>&status=M1&TotNum="+Totnum+"&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&old_visit_type_ind1=<%=old_visit_type_ind1%>&old_alcn_catg_code1=<%=old_alcn_catg_code1%>&no_of_slots_value1=<%=no_of_slots_value1%>&patient_id1=<%=patient_id1%>&old_pract_id1=<%=old_pract_id1%>&old_clinic_code=<%=old_clinic_code%>&curr_month=<%=curr_month%>&rd_appt_yn=<%=rd_appt_yn%>&order_id=<%=order_id%>&order_catalog_code="+document.forms[0].order_catalog_code.value; //--[IN027165]
				self.location.href=param
			}
		}

		function rfresh(obj)
		{

				parent.frames[2].location.href='../../eCommon/html/blank.html'
				var param="../../eOA/jsp/ApptDairy.jsp?i_practitioner_id=<%=Practitioner_Id%>&clinic_type=<%=clinic_type%>&Forced=<%=Forced%>&res_type=<%=res_type%>&i_clinic_code="+obj.value+"&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&old_visit_type_ind1=<%=old_visit_type_ind1%>&old_alcn_catg_code1=<%=old_alcn_catg_code1%>&no_of_slots_value1=<%=no_of_slots_value1%>&patient_id1=<%=patient_id1%>&old_pract_id1=<%=old_pract_id1%>&old_clinic_code=<%=old_clinic_code%>&alcn_criteria=<%=alcn_criteria%>&curr_month=<%=curr_month%>&rd_appt_yn=<%=rd_appt_yn%>&order_id=<%=order_id%>&order_catalog_code="+document.forms[0].order_catalog_code.value;
	//--[IN027165]
				self.location.href=param
		}

function change_schedule(obj,obj1){ 
     var res_type=document.forms[0].res_type.value;           
	  /*Below Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238] */		
		var param="../../eOA/jsp/ApptDairy.jsp?i_practitioner_id="+obj.value+"&i_clinic_code="+document.forms[0].clinic_code.value+"&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&obook_appt_yn=<%=obook_appt_yn%>&i_team_id=<%=team_id%>&over_booked=<%=overbookedyn%>&Forced=<%=Forced%>&clinic_type=<%=clinic_type%>&res_type="+document.forms[0].res_type.value+"&alcn_criteria="+document.forms[0].alcn_criteria.value+"&visit_limit_rule=<%=visit_limit_rule%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&old_visit_type_ind1=<%=old_visit_type_ind1%>&old_alcn_catg_code1=<%=old_alcn_catg_code1%>&no_of_slots_value1=<%=no_of_slots_value1%>&patient_id1=<%=patient_id1%>&old_pract_id1=<%=old_pract_id1%>&old_clinic_code=<%=old_clinic_code%>&practitioner_name="+obj1.value+"&curr_month=<%=curr_month%>&rd_appt_yn=<%=rd_appt_yn%>&order_id=<%=order_id%>&order_catalog_code="+document.forms[0].order_catalog_code.value;  //--[IN027165]
		self.location.href=param	
        /*Below If Condition Added for this SCF ML-BRU-SCF-0240 [IN:033238] */		
		if(document.forms[0].practitioner_name1.value && document.forms[0].practitioner_name1.value!=obj1.value){	
		parent.frames[2].location.href='../../eCommon/html/blank.html'
		parent.frames[3].location.href='../../eCommon/html/blank.html'		
		}
}


	</SCRIPT>
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

		<%
			Connection con = null;
			//Statement stmt=null;//modified by Kamatchi S for security issue against COMMON-ICN-0165
			PreparedStatement pstmt = null;
	
 			ResultSet rs=null;
			int coi=0;
			String week[]=new String[7];
			String day_type1[]=new String[7];
			String day_type2[]=new String[7];
			String day_type3[]=new String[7];
			String day_type4[]=new String[7];
			String day_type5[]=new String[7];
			if(rs !=null) rs.close();
			try{

				con = ConnectionManager.getConnection(request);
				//stmt=con.createStatement();//modified by Kamatchi S for security issue against COMMON-ICN-0165
			String sql_week="select substr(DAY_OF_WEEK,1,3) dw ,DAY_TYPE dt ,DAY_NO dn,DAY_TYPE_WEEK_1,DAY_TYPE_WEEK_2,DAY_TYPE_WEEK_3,DAY_TYPE_WEEK_4,DAY_TYPE_WEEK_5 from sm_day_of_week order by DAY_NO";
				//rs=stmt.executeQuery(sql_week);//modified by Kamatchi S for security issue against COMMON-ICN-0165
				pstmt   = con.prepareStatement(sql_week);
				rs=pstmt.executeQuery();
					if(rs!=null){
					 while(rs.next()){
					  week[coi]=rs.getString("dw");
					  day_type1[coi]=rs.getString("DAY_TYPE_WEEK_1");
					  day_type2[coi]=rs.getString("DAY_TYPE_WEEK_2");
					  day_type3[coi]=rs.getString("DAY_TYPE_WEEK_3");
					  day_type4[coi]=rs.getString("DAY_TYPE_WEEK_4");
					  day_type5[coi]=rs.getString("DAY_TYPE_WEEK_5");
					  coi++;
					}
					}
						if(rs!=null)			rs.close();
			}
			catch(Exception es){
			}
			if(rs !=null) rs.close();
			// Modified against JD-CRF-0177 : added LightGreen and DarkGreen classes
			String Color_Code[]={"S","Y","G","R","B","H","L","D"}; 
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARED","OAHOLIDAY","OALIGHTGREEN","OADARKGREEN"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
			String cliniccode=request.getParameter("i_clinic_code");
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
				}else{	

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
				if (TotNum<0)
					TotNum =month_of_year;
				}
				if(TotNum==0)
					state="current";
				else
				{
					if(TotNum > 0)
					   state="next";
				}
	if(rs !=null) rs.close();
			}
			catch(Exception e){
			//out.println(e);
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
			}
			if(rs !=null) rs.close();
			String arg=getYearMonth(state,TotNum);
			String CalString=(String)getCalendarString(con,arg);
			String ColorString=getCalanderStatusColor(fid,cliniccode,Practitioner_Id,con,arg);
			String yr=arg.substring(0,4);
			String yr_display=DateUtils.convertDate(yr,"YY","en",locale);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			String month=months[mon-1];
			String month_display="";
			if(month.equals("January"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.January.label","common_labels");
				}else if(month.equals("February"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.February.label","common_labels");
				}else if(month.equals("March"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.March.label","common_labels");
				}else if(month.equals("April"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.April.label","common_labels");
				}else if(month.equals("May"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.May.label","common_labels");
				}else if(month.equals("June"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.June.label","common_labels");
				}else if(month.equals("July"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.July.label","common_labels");
				}else if(month.equals("August"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.August.label","common_labels");
				}else if(month.equals("September"))
				{
				month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.September.label","common_labels");
				}else if(month.equals("October"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.October.label","common_labels");
				}else if(month.equals("November"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.November.label","common_labels");
				}else if(month.equals("December"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.December.label","common_labels");
				}

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
		<input type='hidden' name='help_function_id' id='help_function_id' value='RESCHEDULE_APPOINTMENT'>
	<table border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			
	<tr>
			<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<%
					try
					{
						
						String open_to_all_pract_yn="";
						String sql1 = "";
						//Below lines modified by Kamatchi S for security issue against COMMON-ICN-0165
						//rs = stmt.executeQuery("Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id='"+fid+"' AND a.clinic_code='"+clinic_code+"' and language_id = '"+locale+"' ");
						sql1 = "Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id=? AND a.clinic_code=? and language_id =? " ;
						pstmt   = con.prepareStatement(sql1);
						pstmt.setString(1, fid);
						pstmt.setString(2, clinic_code);
						pstmt.setString(3, locale);
						
						//System.err.println("454 ==> Select a.open_to_all_pract_yn, a.long_desc,speciality_code from op_clinic_lang_vw a Where a.facility_id='"+fid+"' AND a.clinic_code='"+clinic_code+"' and language_id = '"+locale+"'");
						rs=pstmt.executeQuery();
						if(rs !=null){
							while ( rs.next() )
								{
									open_to_all_pract_yn= rs.getString("open_to_all_pract_yn");
									clinic_name1= rs.getString("long_desc");	
									speciality_code=rs.getString("speciality_code");
								}
								}
								if(rs !=null) rs.close();

							if(clinic_name1==null) clinic_name1="";
							if(rs !=null) rs.close();
							if(pstmt !=null) pstmt.close();
	%>
					
					<%
						String my=month_display+","+yr_display;

						//String disp_clinc_pract=clinic_name;
					%>
					




<td class='fields'><b><%=care_locn_ind_desc%></b></td></tr>

<tr><td class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<!--onBlur method If Condition Added for this SCF ML-BRU-SCF-0240 [IN:033238] */	 -->
<td class='fields'><input type='text' name='b_loc_val' id='b_loc_val' size='25' maxlength='25' value='<%=clinic_name1%>' onBlur='ena_loc_lookup(this);'><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup(this);" class='button' ></td>
</tr>
 			<% 
		
									
						String resourceSQL ="";
						//Added by Kamatchi S for security issue against COMMON-ICN-0165
						if(res_type.equals("P")){
							//resourceSQL= "SELECT practitioner_name,practitioner_id FROM am_practitioner_lang_vw WHERE practitioner_id='"+practitioner_id+"' AND language_id='"+locale+"'";
							resourceSQL= "SELECT practitioner_name,practitioner_id FROM am_practitioner_lang_vw WHERE practitioner_id=? AND language_id=? ";
						}else if(res_type.equals("R")){
							//resourceSQL="select room_num practitioner_id, short_desc practitioner_name from am_facility_room_lang_vw where operating_facility_id ='"+fid+"' and language_id = '"+locale+"' and room_num='"+practitioner_id+"' order by short_desc ";
							resourceSQL="select room_num practitioner_id, short_desc practitioner_name from am_facility_room_lang_vw where operating_facility_id =? and language_id = ? and room_num= ? order by short_desc ";
						}else if(res_type.equals("E") || res_type.equals("O")){
							//resourceSQL="Select resource_id practitioner_id, short_desc practitioner_name from am_resource_lang_vw where facility_id = '"+fid+"' and Resource_Class ='"+res_type+"' and language_id = '"+locale+"'  and RESOURCE_ID ='"+practitioner_id+"'";
							resourceSQL="Select resource_id practitioner_id, short_desc practitioner_name from am_resource_lang_vw where facility_id = ? and Resource_Class = ? and language_id = ?  and RESOURCE_ID = ? ";
						}
						pstmt   = con.prepareStatement(resourceSQL);
						if(res_type.equals("P")){
						 pstmt.setString(1, practitioner_id);
						 pstmt.setString(2, locale);
						}else if(res_type.equals("R")){
						 pstmt.setString(1, fid);
						 pstmt.setString(2, locale);
						 pstmt.setString(3, practitioner_id);
						}else if(res_type.equals("E") || res_type.equals("O")){
						 pstmt.setString(1, fid);
						 pstmt.setString(2, res_type);
						 pstmt.setString(3, locale);
						 pstmt.setString(4, practitioner_id);
						}
						rs=pstmt.executeQuery();
						//rs = stmt.executeQuery(resourceSQL);
						if(rs !=null){
							if ( rs.next() )
								{
									
									practitioner_name= rs.getString("practitioner_name");	
									if(practitioner_name==null) practitioner_name="";
								}
								}
								if(rs !=null) rs.close();
								if(pstmt !=null) pstmt.close();
							if(practitioner_name==null) practitioner_name="";
							if(rs !=null) rs.close();
%>
	<tr id='resource_part'><jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "appt_dairy" />
					<jsp:param name ="res_type" value= "<%=res_type%>" />
					<jsp:param name ="clinic_type" value= "<%=clinic_type%>" />
					<jsp:param name ="open_to_all_pract_yn" value="<%=open_to_all_pract_yn%>" />
					<jsp:param name ="clinic_code" value= "<%=clinic_code%>" />
					<jsp:param name ="pract_value" value= "<%=practitioner_name%>" />
					</jsp:include>
<%chk_flg="Y"; %>

			<tr><td class='label' colspan='2'></td></tr><tr><td class='label' colspan='2'></td></tr>
			<tr><td class='label' colspan='2'></td></tr><tr><td class='label' colspan='2'></td></tr>
			<tr><td class='white' colspan='2'>&nbsp;</td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr><td class='white'></td></tr>


</table>
			
<table  align='center' border=0 cellspacing=0 cellpadding=0 width='98%'>
			
	<tr >
				<td  width='98%' class='white' >
				<%if(chk_flg.equals("Y")){%>
				
<table cellspacing=0 cellpadding=0  width='98%' style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt' border='0'>
					
	<tr>
				<td align='center' width='10%'><input type='button' class='button' value="<---" name='prev' id='prev'  onclick=previousMonth(<%=TotNum%>)></td>
				
				<td align='center' class="DISPDATE" width='140%'><font size=3><b><%=my%></b></font></td>
				
				<td align='center' width='10%'><input type='button' class='button' value="--->" name='next' onclick=nextMonth(<%=TotNum%>)></td>
	</tr>
</table>
						<%}%>
				</td>
	</tr>
			<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>' >
			<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>' >
			<input type='hidden' name='apptrefno' id='apptrefno' value='<%=apptrefno%>' >
			<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >
			<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
			<input type='hidden' name='old_alcn_catg_code' id='old_alcn_catg_code' value='<%=old_alcn_catg_code%>' >
			<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
			<input type='hidden' name='over_booked' id='over_booked' value='<%=overbookedyn%>' >
			<input type='hidden' name='obook_appt_yn' id='obook_appt_yn' value='<%=obook_appt_yn%>' >
			<%/*Below hidden field changed for this[IN:034988]*/%>
			<input type='hidden' name='practitioner_name1' id='practitioner_name1' value="<%=practitioner_name%>" >
			<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
			<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
			<input type='hidden' name='Forced' id='Forced' value='<%=Forced%>' >
			<input type='hidden' name='team_id' id='team_id' value='' >
			<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>' >
			<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>' >
			<input type='hidden' name='old_visit_type_ind1' id='old_visit_type_ind1' value='<%=old_visit_type_ind1%>' >
			<input type='hidden' name='old_alcn_catg_code1' id='old_alcn_catg_code1' value='<%=old_alcn_catg_code1%>' >
			<input type='hidden' name='no_of_slots_value1' id='no_of_slots_value1' value='<%=no_of_slots_value1%>' >
			<input type='hidden' name='patient_id1' id='patient_id1' value='<%=patient_id1%>' >
			<input type='hidden' name='old_pract_id1' id='old_pract_id1' value='<%=old_pract_id1%>' >
			<input type='hidden' name='old_clinic_code' id='old_clinic_code' value='<%=old_clinic_code%>' >
			<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>' >
			<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>' >
			<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>' >
			<input type='hidden' name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>' >
			<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>' >
			</form>
		<%if(chk_flg.equals("Y")){%>
	<tr>
		
<table width='96%'  align='center' cellpadding=0  style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt '>
	<tr>
				<%for( int j=0;j<week.length;j++){
					String week1[]=new String[7];
						if(week[j].equals("SUN"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
		}else if(week[j].equals("MON"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
		}else if(week[j].equals("TUE"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
		}else if(week[j].equals("WED"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
		}else if(week[j].equals("THU"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
		}else if(week[j].equals("FRI"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
		}else if(week[j].equals("SAT"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
		}%>
			<th width='3%' align='center' ><font size=1><%=week1[j]%></th>	<%}%>
		
	</tr>
			<%for( int j=0;j<ro;j++)
				{
				
				%>
	<tr>
				  	<%

				  	for(int k=0;k<ccols;k++)
				  	{
						
						if(k==1)
							{
						if(day_type1[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						}

						if(k==2)
						{
						if(day_type2[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==3)
							{
						if(day_type3[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==4)
							{
						if(day_type4[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==5)
							{
						if(day_type5[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

						if(act<NumOfDays.length)
				  		{
							if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
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

				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
                            if (colorclass.equals("OARED"))
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";

							else
							anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"','"+colorclass+"') title='"+title+"'  >";
                     
							}
					if(allow_click){							 
						if(colorclass.equals("OAHOLIDAY")){
							%>
				<td class='<%=colorclass%>' align='center' width='3%'><font 	size=2><%=dat%></a></td>
							<%
							}
						else{
							%>
				<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
							<%
						}
					}
					else{
						if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY")){
							%>
				<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=dat%></a></td>
				  			<%
							}
							else{
							%>
				<td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=anch%><%=dat%></a></td>
				  			<%
							}
						}
						else{
							%>
				<td  align='center' width='3%'><font size=2><%=dat%></a></td>
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
<script>

	var resc_type=document.forms[0].res_type.value;
	document.getElementById("resourceType1").value=resc_type;

</script>
</table>
		<%}%>
	<%
			
		if(rs!=null)			rs.close();
		//if(stmt!=null)		stmt.close();
		if(pstmt!=null)		pstmt.close();
	}catch(Exception e){
			//out.println("ERROR@2"+e);
			e.printStackTrace();
			}finally
				{
					if(con!=null)	ConnectionManager.returnConnection(con,request);
						
				}
			%>
	</body>
</html>

