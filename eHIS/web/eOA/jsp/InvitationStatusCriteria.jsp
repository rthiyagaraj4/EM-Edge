<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	14/04/2005
	Module		:	OA
	Function	:	Invite WaitList
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,java.io.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>

	<%! int TotNum=0;%>
	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ca_patient_id=request.getParameter("patient_id");
	if(ca_patient_id==null) ca_patient_id="";

	String clinic_code=request.getParameter("location_code");
	String prd="";
	String locale			= (String)session.getAttribute("LOCALE");


	if (clinic_code==null)
	clinic_code=request.getParameter("i_clinic_code");
	prd=request.getParameter("prd");
	if(prd==null)prd="";
	

	if (clinic_code==null) clinic_code="";


	String practitioner_id="";
	String callingMode="N";
	callingMode=request.getParameter("callingMode");
	String ref_md=request.getParameter("ref");
	if(ref_md==null) ref_md="F";
	if(callingMode==null || callingMode.equals("") || callingMode.equals("null")){
		callingMode="N";
	}
	if(callingMode.equals("OP"))
	{
		practitioner_id=request.getParameter("i_practitioner_id");
	}else{
		practitioner_id=(String)session.getValue("ca_practitioner_id");
	}
	
	boolean no_sch_flag=false;


	String i_Clinic_code_sel=clinic_code;
	if(i_Clinic_code_sel==null || i_Clinic_code_sel.equals("") || i_Clinic_code_sel.equals("null")){
		i_Clinic_code_sel="N";
	}
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("resource_class");
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	
	
	
	String apptrefno=request.getParameter("i_appt_ref_no");
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	
//	String practitioner_name="";
	String overbookedyn=request.getParameter("over_booked");
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	boolean referesh_flag=true;


	%>

	<%!
			public String getCalendarString(Connection con,String arg)
			{
				
				Statement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				try
				{
					stmt=con.createStatement();

		   			sql="select get_calendar_string('"+arg+"') calen_val from dual";
					rs=stmt.executeQuery(sql);
					if(rs.next())
					RetString=rs.getString("calen_val");
					if(rs !=null) rs.close();
					if(stmt !=null)stmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql one:"+sql;
					e.printStackTrace();
				}
				return RetString;
			}
	%>

	<%!
			public String getCalanderStatusColor(String Facility_Id, String Clinic_Code, Connection con,String arg)
			{
				Statement stmt=null,stmt2=null;
				ResultSet rs=null;
				CallableStatement statement2 =null;

				
				
				String str_start="",sql="",RetString="",month="",year="";
				int lag=0;
				java.util.ArrayList arrlst=new java.util.ArrayList();
								try
				{
					sql="select substr(TO_CHAR(TO_DATE('"+arg+"','YYYYMM'),'DAY'),1,3) strt ,substr(TO_CHAR(TO_DATE('"+arg+"','YYYYMM'),'MM'),1,3) month,substr(TO_CHAR(TO_DATE('"+arg+"','YYYYMM'),'YYYY'),1,4) YEAR FROM DUAL";
					stmt=con.createStatement();
					stmt2=con.createStatement();
					rs=stmt2.executeQuery(sql);
					if(rs!=null && rs.next()){
						str_start=rs.getString("strt");
						month=rs.getString("month");
						year=rs.getString("YEAR");
					}
					if(rs !=null)rs.close();
					String day_of_week="";
					String sql_two="select DAY_NO,DAY_OF_WEEK from sm_day_of_week where day_no='1' order by day_no";
					rs=stmt2.executeQuery(sql_two);
					if(rs!=null && rs.next()){
						day_of_week=rs.getString("DAY_OF_WEEK");
					}
					if(str_start.equals("MON")){
						lag=0;
					}else if(str_start.equals("TUE")){
						lag=1;
					}else if(str_start.equals("WED")){
						lag=2;
					}else if(str_start.equals("THU")){
						lag=3;
					}else if(str_start.equals("FRI")){
						lag=4;
					}else if(str_start.equals("SAT")){
						lag=5;
					}else if(str_start.equals("SUN")){
						lag=6;
					}
					if(rs !=null) rs.close();
					if(stmt !=null) stmt.close();
					if(stmt2 !=null)stmt2.close();
					String date1=month+"/"+year;
					String date_type="M";
					try	
					{
				//String fid=(String)session.getValue("facility_id");
			//	String clinic_code=request.getParameter("location_code");
//String fid="";
					


					statement2=con.prepareCall("{call GET_WORKING_DAY_WAIT_LIST(?,?,?,?,?,?,?)}");
					statement2.setString( 1,	date1 ) ;
					statement2.setString( 2,	date1  ) ;
					statement2.setString( 3,	date_type  ) ;
					statement2.setString( 4,	Clinic_Code);
					statement2.setString( 5,	 Facility_Id);

					statement2.registerOutParameter(6,	Types.VARCHAR ) ;
					statement2.registerOutParameter(7,	Types.VARCHAR ) ;
					statement2.execute() ;
					String out1= statement2.getString( 6);
					String val="";
					StringTokenizer token1=new StringTokenizer(out1,"*");
					int counter=token1.countTokens();
					while (token1.hasMoreTokens())
					{
						val=token1.nextToken();
						arrlst.add(val);
					}
					String blank_val="";
					
					if(day_of_week.equals("SUNDAY"))
							{
							if(lag==0)
							{
								blank_val="X|";
							}else if(lag==1)
							{
								blank_val="X|X|";
							}else if(lag==2)
							{
								blank_val="X|X|X|";
							}else if(lag==3)
							{
								blank_val="X|X|X|X|";
							}else if(lag==4)
							{
								blank_val="X|X|X|X|X|";
							}else if(lag==5)
							{
								blank_val="X|X|X|X|X|X|";
							}else if(lag==6)
							{
								blank_val="";
							}
							}else if(day_of_week.equals("MONDAY"))
							{
								if(lag==0)
							{
								blank_val="";
							}else if(lag==1)
							{
								blank_val="X|";
							}else if(lag==2)
							{
								blank_val="X|X|";
							}else if(lag==3)
							{
								blank_val="X|X|X|";
							}else if(lag==4)
							{
								blank_val="X|X|X|X|";
							}else if(lag==5)
							{
								blank_val="X|X|X|X|X|";
							}else if(lag==6)
							{
								blank_val="X|X|X|X|X|X|";
							}
							}else if(day_of_week.equals("SATURDAY"))
							{
								{
								if(lag==0)
							{
								blank_val="X|X|";
							}else if(lag==1)
							{
								blank_val="X|X|X|";
							}else if(lag==2)
							{
								blank_val="X|X|X|X|";
							}else if(lag==3)
							{
								blank_val="X|X|X|X|X|";
							}else if(lag==4)
							{
								blank_val="X|X|X|X|X|X|";
							}else if(lag==5)
							{
								blank_val="";
							}else if(lag==6)
							{
								blank_val="X|";
							}
							}
							}

						if(arrlst.size()>0){
						for(int i=0;i<=0;i++)	
						{
						
							
							if(lag==0)
							{
								if(counter <=28)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
							}else if(counter >28 && counter<=29)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
							}else if(counter >29 && counter<=30)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|";
							}else if(counter >30 )
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|"+arrlst.get(30)+"|";
								}
							}if(lag==1)
							{
								if(counter <=28)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
							}else if(counter >28 && counter<=29)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
							}else if(counter >29 && counter<=30)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|";
							}else if(counter >30 )
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|"+arrlst.get(30)+"|";
								}
							}else if(lag==2)
							{
							if(counter <=28)
								{	RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
								}else if(counter >28 && counter<=29)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
								}else if(counter >29 && counter<=30)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|";
								}else if(counter >30)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|"+arrlst.get(i+30)+"|";
								}
								
							}else if(lag==3)
							{
							
							if(counter <=28)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
							}else if(counter >28 && counter<=29)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
							}else if(counter >29 && counter<=30)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|";
							}else if(counter >30  && counter<=31)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|"+arrlst.get(30)+"|";
							}
							
							}else if(lag==4)
							{
							
							if(counter <=28)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
							}else if(counter >28 && counter<=29)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
							}else if(counter >29 && counter<=30)
							{
							RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|";
							}else if(counter >30 )
							{
						RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(29)+"|"+arrlst.get(30)+"|";
							}
							
							}else if(lag==5)
							{
								if(counter <=28)
								{	RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
								
								}else if(counter >28 && counter<=29)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
									
								}else if(counter >29 && counter<=30)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|";
									
								}else if(counter >30)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|"+arrlst.get(i+30)+"|";
									
								}
							}else if(lag==6)
							{
								
								if(counter <=28)
								{
								RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|";
								
								}else if(counter >28 && counter<=29) 
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|";
								}else if(counter >29 && counter<=30) 
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|";
								}else if(counter >30)
								{
									RetString=RetString+blank_val+arrlst.get(i)+"|"+arrlst.get(i+1)+"|"+arrlst.get(i+2)+"|"+arrlst.get(i+3)+"|"+arrlst.get(i+4)+"|"+arrlst.get(i+5)+"|"+arrlst.get(i+6)+"|"+arrlst.get(i+7)+"|"+arrlst.get(i+8)+"|"+arrlst.get(i+9)+"|"+arrlst.get(i+10)+"|"+arrlst.get(i+11)+"|"+arrlst.get(i+12)+"|"+arrlst.get(i+13)+"|"+arrlst.get(i+14)+"|"+arrlst.get(i+15)+"|"+arrlst.get(i+16)+"|"+arrlst.get(i+17)+"|"+arrlst.get(i+18)+"|"+arrlst.get(i+19)+"|"+arrlst.get(i+20)+"|"+arrlst.get(i+21)+"|"+arrlst.get(i+22)+"|"+arrlst.get(i+23)+"|"+arrlst.get(i+24)+"|"+arrlst.get(i+25)+"|"+arrlst.get(i+26)+"|"+arrlst.get(i+27)+"|"+arrlst.get(i+28)+"|"+arrlst.get(i+29)+"|"+arrlst.get(i+30);
								}
							}
						
							
						}

					}
					
					arrlst.clear();
					}catch(Exception e)
					{
						//out.println("one"+e.toString());
						e.printStackTrace();
					}
					
					
							
				if(statement2 !=null) statement2.close();

			}
			catch(Exception e)
			{
					//out.println(""+e.toString());
					e.printStackTrace();
				//RetString=e.toString()+"<br>sql:"+sql;
			}
				return RetString;
				
			}
	%>


	<%!
			public java.util.HashMap getDaywiseCount(String Facility_Id,Connection con,String arg)
			{
				Statement stmt=null;
				ResultSet rs=null;

				String yr=arg.substring(0,4);
				String mon=arg.substring(4)+"/"+yr;
				java.util.HashMap hsmp=new java.util.HashMap();
				
				try
				{
					stmt=con.createStatement();
					String sql="select count(wait_list_no) cntr,to_char(INVITED_DATE_TIME,'dd') dt from pr_wait_list where facility_id='"+Facility_Id+"' and wait_list_status='I' and to_date(to_char( invited_date_time,'mm/yyyy'),'mm/yyyy')=to_date('"+mon+"','mm/yyyy') group by invited_date_time order by invited_date_time";
					rs=stmt.executeQuery(sql);
					if(rs!=null){
						while (rs.next()){
							hsmp.put(rs.getString("dt"),rs.getString("cntr"));
						}
					}
					if(rs !=null) rs.close();
					if(stmt !=null)stmt.close();
				}
				catch(Exception e)
				{
					hsmp.put("Error" , e);
					e.printStackTrace();
				}
				return hsmp;
				
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


	<SCRIPT>
		function populate(obj){
			var pract_id=document.forms[0].practitioner_id.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH clinic_type=\""+obj.value+"\" pract_id=\""+pract_id+"\" steps='CA' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
		}


		function callDisplayOAResultsblock(date)
		{
         alert(getMessage("SCHEDULE_BLOCK","OA")+" " +date);
		}
		function nextMonth(Totnum)
		{
				parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum+1
				
				var param="../../eOA/jsp/InvitationStatusCriteria.jsp?i_practitioner_id=<%=practitioner_id%>&i_clinic_code=<%=clinic_code%>&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&res_type=<%=res_type%>&status=P1&TotNum="+Totnum+"&callingMode=<%=callingMode%>&ref=T&prd=<%=prd%>";
				
					self.location.href=param
				


		}

		function previousMonth(Totnum)
		{
			
			if(Totnum>0)
			{
				parent.frames[1].location.href='../../eCommon/html/blank.html'
				Totnum=Totnum-1;
				

				var param="../../eOA/jsp/InvitationStatusCriteria.jsp?i_practitioner_id=<%=practitioner_id%>&i_clinic_code=<%=clinic_code%>&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&alcn_criteria=<%=alcn_criteria%>&patient_id=<%=ca_patient_id%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&res_type=<%=res_type%>&status=M1&TotNum="+Totnum+"&callingMode=<%=callingMode%>&ref=T&prd=<%=prd%>";

				self.location.href=param
				


			}
		}

			
		function callDisplayOAResultsForOp(clinic, mon, yr,dt,prd)
		{
			parent.frames[1].location.href="../../eOA/jsp/InvitationStatusHeader.jsp?mon="+mon+"&yr="+yr+"&dt="+dt+"&prd="+prd;
			parent.frames[2].location.href="../../eOA/jsp/InvitationStatusQueryResult.jsp?mon="+mon+"&yr="+yr+"&dt="+dt+"&prd="+prd;



		}





		function rfresh(obj)
		{
				
				parent.frames[2].location.href='../../eCommon/html/blank.html'
				
				var param="../../eOA/jsp/InvitationStatusCriteria.jsp?i_practitioner_id=<%=practitioner_id%>&patient_id=<%=ca_patient_id%>&res_type=<%=res_type%>&i_clinic_code="+obj.value+"&callingMode=<%=callingMode%>&ref=T";

				self.location.href=param
		}

		function change_schedule(){
			
		var param="../../eOA/jsp/InvitationStatusCriteria.jsp?i_practitioner_id=<%=practitioner_id%>&i_appt_ref_no=<%=apptrefno%>&i_appt_date=<%=old_date%>&tfr_appt_across_catg_yn=<%=tfr_appt_across_catg_yn%>&patient_id=<%=ca_patient_id%>&over_booked=<%=overbookedyn%>&res_type=<%=res_type%>&alcn_criteria="+document.forms[0].alcn_criteria.value+"&callingMode=<%=callingMode%>&ref=T";
		self.location.href=param
		//parent.frames[1].location.href='../../eCommon/html/blank.html'
		}


		
	</SCRIPT>
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<%
			
			Connection con = null;
			Statement stmt=null;
			Statement stmt1=null;
			
 			ResultSet rs=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			int coi=0;
			String week[]=new String[7];
			String day_type[]=new String[7];
			String day_type1[]=new String[7];
			String day_type2[]=new String[7];
			String day_type3[]=new String[7];
			String day_type4[]=new String[7];
			String day_type5[]=new String[7];
		
			try{

	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
			stmt1 =con.createStatement();
			

			if(rs2 !=null) rs2.close();
			String sql_week="select substr(DAY_OF_WEEK,1,3) day_of_week,DAY_TYPE,DAY_NO,DAY_TYPE_WEEK_1,DAY_TYPE_WEEK_2,DAY_TYPE_WEEK_3,DAY_TYPE_WEEK_4,DAY_TYPE_WEEK_5 from sm_day_of_week order by DAY_NO";
				rs=stmt.executeQuery(sql_week);
					if(rs!=null){
					 while(rs.next()){
					  week[coi]=rs.getString("day_of_week");
					  day_type[coi]=rs.getString("DAY_TYPE");
					  day_type1[coi]=rs.getString("DAY_TYPE_WEEK_1");
					  day_type2[coi]=rs.getString("DAY_TYPE_WEEK_2");
					  day_type3[coi]=rs.getString("DAY_TYPE_WEEK_3");
					  day_type4[coi]=rs.getString("DAY_TYPE_WEEK_4");
					  day_type5[coi]=rs.getString("DAY_TYPE_WEEK_5");
					  coi++;
					  
					}
					}

				if(rs !=null) rs.close();

			}
			catch(Exception es){
				//out.println("Exec@4" +es);
				es.printStackTrace();

			}
			String Color_Code[]={"H","W"};
			String Color_Val[]={"OAHOLIDAY","OAGREEN"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			String cliniccode=request.getParameter("location_code");
			if (cliniccode==null)
			cliniccode=request.getParameter("i_clinic_code");

			String colorclass="";
			String status=request.getParameter("status");
			String recall_date=request.getParameter("recall_date");
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
				
				if(rs !=null) rs.close();
				if(request.getParameter("TotNum")!=null){
				TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}
				else{	

				int curr_month=0;
				String curr_month1 = request.getParameter("curr_month");
				old_date = request.getParameter("old_date");				
				curr_month = Integer.parseInt(curr_month1);				 
				if(recall_date ==null) recall_date=old_date;
				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(recall_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
							mon_date=mon;
						}
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
			catch(Exception e){
				//out.println("Exec@1"+e);
				e.printStackTrace();

			}
			
			
			String arg=getYearMonth(state,TotNum);

			String CalString=(String)getCalendarString(con,arg);


			String ColorString=getCalanderStatusColor(fid,clinic_code,con,arg);
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

			java.util.HashMap dywisecnt=getDaywiseCount(fid,con,arg);
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
			<table border=0 cellspacing=0 cellpadding=0 width='50%'>
			<tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr><tr><td class='white'></td></tr>
			<tr>
			
			<%
 			try
 			{
				if(rs !=null) rs.close();
			
			/*
				rs=stmt.executeQuery("select nvl(FORCECLOSE_PERIOD,0) prd from oa_param");	
				if (rs!=null &&rs.next()){
				prd=rs.getString("prd");
				}
				if(rs !=null) rs.close();
					if(rs !=null) rs.close();
			*/
						
			
		
%>
			
			<%
				String my=month_display+","+yr_display;

			%>
			
			



</table>
			<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
<table  align='CENTER' border=0 cellspacing=0 cellpadding=0 width='50%' border='0' style="width:100px">
			
				<td  width='52%' class='white' >
<table cellspacing=0 cellpadding=0  width='65%' style='mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt' border='0'>
					
				<tr>
						<td align='center' class='fields'  width='10%'><input type='button' class='button' value="<---" name='prev' id='prev'  onclick=previousMonth(<%=TotNum%>)></td>
						<td align='center' class="DISPDATE" width='140%'><font size=3><b><%=my%></b></font></td>
						<td align='center' width='10%'><input type='button' class='button' value="--->" name='next' onclick=nextMonth(<%=TotNum%>)></td>
				</tr>
</table>
				
		
<table width='65%'  align='left' cellpadding=0  style='mso-cellspacing:2.0pt;margin-left:1.8pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt ' border='0'>
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
		}
						%>
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
							if (colorclass.equals("OARed"))
							{
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";
							}else
								{
								
							anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"','"+prd+"') >";
								}
							}


					if(allow_click){
						
						if(colorclass.equals("OAHOLIDAY"))
						{
						%>
				 <td class='<%=colorclass%>' align='center' width='3%'><font 	size=2><%=dat%></a></td>
					  	<%
						}
					else
						{
						String dt1="";
						if(dat.length()==1){
						dt1="0"+dat;
						}else{
							dt1=dat;
						}
						String ttip=(String) dywisecnt.get(dt1);
						if(ttip==null) ttip="0";
						
						%>
				  <td class='<%=colorclass%>' align='center' width='3%' title='No Of Invitations=<%=ttip%>'><font size=2>
							<%if(ttip.equals("0")){%>
								<%=dat%>
							<%}else{%>
								<%=anch%><%=dat%></a>
							<%}%>
							
						
				  </td>
					  	<%
						}
					}else{
						

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
				  <td class='<%=colorclass%>' align='center' width='3%'><font size=2><%=dat%></a></td>
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
		<%
		if(no_sch_flag){%>
			<script>alert(getMessage("SCH_NOT_AVAILABLE","OA"));
			location.href="../../eCommon/html/blank.html";
			</script>
		<%}else{
			if (referesh_flag){%>

			<script>
			
			</script>
			<%
			}else{
				if(ref_md.equals("F")){%>
					<script>
					obj=document.forms[0].new_pract
					var len=obj.options.length;
					var i=0;
					opt=document.createElement('OPTION');

					opt.value='';
					opt.text='  ---Select---  ';
					obj.add(opt);
					document.forms[0].new_pract.value='';
					</script>
			<%}	
			}
		}
			if(rs !=null)		rs.close();
			if(rs1 !=null)      rs1.close();
			if(rs2 !=null)      rs2.close();
			if(rs !=null)		rs.close();
			if(stmt !=null)		stmt.close();
			if(stmt !=null)		stmt.close();
			if(stmt1 !=null)    stmt1.close();
			if(stmt !=null)		stmt.close();
			
}catch(Exception e)
{
	//out.println("ERROR@2" +e);
	e.printStackTrace();
}finally
{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
			%>
			</form>
	</body>
</html>

