<!DOCTYPE html>

<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
try{
    con=ConnectionManager.getConnection(request);    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	String callfunc=request.getParameter("call_func");

	String clinicmod="";
	String clinicdesc="";
	String unittype="";
	String unittypedesc="";
	
	String resclass="";
	String resclassdesc="";
	String cliniccode="";
	String restypecode="";
	String restype="";
	String restypedesc="";	
	String resunit="";
	String resunitdesc="";
	
	String practitionerid="";
	String practname="";
	String effstatus="E";
	
	String daysofweek = "";	
	
	
	String clinicworkingWeekApplday[] = new String[7];
	String clinicworkingweekappldesc[] = new String[7];
	
	
	String clinicworkingweek1day[] = new String[7];
	String clinicworkingweek2day[] = new String[7];
	String clinicworkingweek3day[]=  new String[7];
	String clinicworkingweek4day[] = new String[7];
	String clinicworkingweek5day[] = new String[7];

	String workingWeekApplday[] = new String[7];
	String workingweekappldesc[] = new String[7];
	
	
	String workingweek1day[] = new String[7];
	String workingweek2day[] = new String[7];
	String workingweek3day[]=  new String[7];
	String workingweek4day[] = new String[7];
	String workingweek5day[] = new String[7];

	String FI_VISIT_TYPE_APPL_YN ="";
    String FU_VISIT_TYPE_APPL_YN="";
    String RT_VISIT_TYPE_APPL_YN="";
    String SR_VISIT_TYPE_APPL_YN="";
    String CS_VISIT_TYPE_APPL_YN="";
    String EM_VISIT_TYPE_APPL_YN="";

	String emerchk="N";
	String firstchk="Y";
	String followchk="Y";
	String routinechk="Y";
	String serieschk="Y";
	String consultchk="Y";
	String chkval="";
	String disable="";
	String readonly="";
	String disable1="";
	String sel="";
	String sql="";  
	String fnval="";
	StringBuffer sql1= new StringBuffer();
	StringBuffer sqlmain = new StringBuffer();
    String facilityid=(String)session.getValue("facility_id");
   
    
	String care_locn_type_ind="";
	// used for whether it is Create/ Modify Mode   
	
%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOP/js/menuItemCheck.js" language="javascript"></script>
<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	if(callfunc.equals("Pract_for_clinic"))
	{
	%>
		<script language='javascript' src='../../eOP/js/PClinic.js'></script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<%
	}
	else if(callfunc.equals("Resource_unit"))
	{
	%>
		<script language='javascript' src='../../eOP/js/ResourceForUnit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	}
	%>
 <script>
 
 function restrictEnterKey(evnt)
 {
	if(evnt.keyCode == 13)
		return false;
 }

 </script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onKeyPress='return restrictEnterKey(event);'> 
<%

	for(int j=1;j<=7;j++)
	{
		workingWeekApplday[j-1]="W";
		
		workingweek1day[j-1]="N";
		workingweek2day[j-1]="N";
		workingweek3day[j-1]="N";
		workingweek4day[j-1]="N";
		workingweek5day[j-1]="N";
	}
	for(int j=1;j<=7;j++)
	{
		clinicworkingWeekApplday[j-1]="W";
		
		clinicworkingweek1day[j-1]="N";
		clinicworkingweek2day[j-1]="N";
		clinicworkingweek3day[j-1]="N";
		clinicworkingweek4day[j-1]="N";
		clinicworkingweek5day[j-1]="N";
	}
	if(callfunc.equals("Pract_for_clinic"))
	{
		clinicmod=(request.getParameter("clinic_code") == null)?"":request.getParameter("clinic_code");
		
		if(!clinicmod.equals(""))
		{
			fnval="modify";
			
			try{
				practitionerid=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");		
				try{
				
				sqlmain.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sqlmain.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sqlmain.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sqlmain.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sqlmain.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sqlmain.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sqlmain.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ");

					sqlmain.append(",FI_VISIT_TYPE_APPL_YN,FU_VISIT_TYPE_APPL_YN,RT_VISIT_TYPE_APPL_YN,SR_VISIT_TYPE_APPL_YN,CS_VISIT_TYPE_APPL_YN,EM_VISIT_TYPE_APPL_YN ");

					sqlmain.append(" from op_clinic where care_locn_type_ind = 'C' and clinic_code='"+clinicmod+"' and facility_id='"+facilityid+"'");

					pstmt=con.prepareStatement(sqlmain.toString());
				rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					for(int i=1;i<=7;i++)
					{
						clinicworkingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(clinicworkingWeekApplday[i-1].equals("W"))
							{
							clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						clinicworkingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						clinicworkingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						clinicworkingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						clinicworkingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						clinicworkingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
				
				 FI_VISIT_TYPE_APPL_YN = rs.getString("FI_VISIT_TYPE_APPL_YN");
				 FU_VISIT_TYPE_APPL_YN = rs.getString("FU_VISIT_TYPE_APPL_YN");
				 RT_VISIT_TYPE_APPL_YN = rs.getString("RT_VISIT_TYPE_APPL_YN");
				 SR_VISIT_TYPE_APPL_YN = rs.getString("SR_VISIT_TYPE_APPL_YN");
				 CS_VISIT_TYPE_APPL_YN = rs.getString("CS_VISIT_TYPE_APPL_YN");
			     EM_VISIT_TYPE_APPL_YN = rs.getString("EM_VISIT_TYPE_APPL_YN");
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sqlmain.setLength(0);

				}catch(Exception e)
				{
					e.printStackTrace();
				}

				/********/
				sql1.append("select a.clinic_code clinic_code ,c.short_desc clinic_desc,a.practitioner_id practitioner_id,b.practitioner_name practitioner_name,a.eff_status eff_status ");
				sql1.append(",a.working_week_appl_day_1 working_week_appl_day_1,a.working_week_appl_day_2 working_week_appl_day_2,a.working_week_appl_day_3 working_week_appl_day_3,a.working_week_appl_day_4 working_week_appl_day_4,a.working_week_appl_day_5 working_week_appl_day_5,a.working_week_appl_day_6 working_week_appl_day_6,a.working_week_appl_day_7 working_week_appl_day_7 ");				
				sql1.append(",a.working_week_1_day_1 working_week_1_day_1,a.working_week_1_day_2 working_week_1_day_2,a.working_week_1_day_3 working_week_1_day_3,a.working_week_1_day_4 working_week_1_day_4,a.working_week_1_day_5 working_week_1_day_5,a.working_week_1_day_6 working_week_1_day_6,a.working_week_1_day_7 working_week_1_day_7");
				sql1.append(",a.working_week_2_day_1 working_week_2_day_1,a.working_week_2_day_2 working_week_2_day_2,a.working_week_2_day_3 working_week_2_day_3,a.working_week_2_day_4 working_week_2_day_4,a.working_week_2_day_5 working_week_2_day_5,a.working_week_2_day_6 working_week_2_day_6,a.working_week_2_day_7 working_week_2_day_7");		
				sql1.append(",a.working_week_3_day_1 working_week_3_day_1,a.working_week_3_day_2 working_week_3_day_2,a.working_week_3_day_3 working_week_3_day_3,a.working_week_3_day_4 working_week_3_day_4,a.working_week_3_day_5 working_week_3_day_5,a.working_week_3_day_6 working_week_3_day_6,a.working_week_3_day_7 working_week_3_day_7");		
				sql1.append(",a.working_week_4_day_1 working_week_4_day_1,a.working_week_4_day_2 working_week_4_day_2,a.working_week_4_day_3 working_week_4_day_3,a.working_week_4_day_4 working_week_4_day_4,a.working_week_4_day_5 working_week_4_day_5,a.working_week_4_day_6 working_week_4_day_6,a.working_week_4_day_7 working_week_4_day_7");
				sql1.append(",a.working_week_5_day_1 working_week_5_day_1,a.working_week_5_day_2 working_week_5_day_2,a.working_week_5_day_3 working_week_5_day_3,a.working_week_5_day_4 working_week_5_day_4,a.working_week_5_day_5 working_week_5_day_5,a.working_week_5_day_6 working_week_5_day_6,a.working_week_5_day_7 working_week_5_day_7,");
				sql1.append("a.fi_visit_type_appl_yn fi_visit_type_appl_yn,a.fu_visit_type_appl_yn fu_visit_type_appl_yn,a.rt_visit_type_appl_yn rt_visit_type_appl_yn,a.sr_visit_type_appl_yn sr_visit_type_appl_yn,a.cs_visit_type_appl_yn cs_visit_type_appl_yn,a.em_visit_type_appl_yn em_visit_type_appl_yn ");
				sql1.append(" from op_pract_for_clinic a,am_practitioner b,op_clinic c where a.facility_id='"+facilityid+"' and a.clinic_code='"+clinicmod+"' and a.practitioner_id='"+practitionerid+"' and a.practitioner_id=b.practitioner_id and a.clinic_code = c.clinic_code");
				
				pstmt=con.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();
				
				if(rs != null && rs.next())
				{
					
					clinicdesc=(rs.getString("clinic_desc") == null)?"":rs.getString("clinic_desc");
					practname=(rs.getString("practitioner_name") == null) ?"":rs.getString("practitioner_name");
					effstatus=(rs.getString("eff_status") == null)?"D":rs.getString("eff_status");
					

					for(int i=1;i<=7;i++)
					{
						workingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(workingWeekApplday[i-1].equals("W"))
							{
							workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						workingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						workingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						workingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						workingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						workingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
					firstchk=(rs.getString("fi_visit_type_appl_yn") == null)?"N":rs.getString("fi_visit_type_appl_yn");
					followchk=(rs.getString("fu_visit_type_appl_yn") == null)?"N":rs.getString("fu_visit_type_appl_yn");
					routinechk=(rs.getString("rt_visit_type_appl_yn") == null)?"N":rs.getString("rt_visit_type_appl_yn");
					serieschk=(rs.getString("sr_visit_type_appl_yn") == null)?"N":rs.getString("sr_visit_type_appl_yn");
					consultchk=(rs.getString("cs_visit_type_appl_yn") == null)?"N":rs.getString("cs_visit_type_appl_yn");
					emerchk=(rs.getString("em_visit_type_appl_yn") == null)?"N":rs.getString("em_visit_type_appl_yn");
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sql1.setLength(0);

		}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			fnval="insert";
		}
	}
	else if(callfunc.equals("Resource_unit"))
	{
		
		unittype=(request.getParameter("unit_type") == null)?"":request.getParameter("unit_type");
		care_locn_type_ind=(request.getParameter("care_locn_type") == null)?"":request.getParameter("care_locn_type");

		resunit=(request.getParameter("resource_unit") == null)?"":request.getParameter("resource_unit");
		resunit=resunit.trim();
		resclass=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");
		practitionerid=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");
		

		if(!unittype.equals(""))
		{
			fnval="modify";
			try{

				try{
				
				sqlmain.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sqlmain.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sqlmain.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sqlmain.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sqlmain.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sqlmain.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sqlmain.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ");
					sqlmain.append(",FI_VISIT_TYPE_APPL_YN,FU_VISIT_TYPE_APPL_YN,RT_VISIT_TYPE_APPL_YN,SR_VISIT_TYPE_APPL_YN,CS_VISIT_TYPE_APPL_YN,EM_VISIT_TYPE_APPL_YN ");
					sqlmain.append(" from op_clinic where clinic_code='"+resunit+"' and facility_id='"+facilityid+"'");

					pstmt=con.prepareStatement(sqlmain.toString());
					rs=pstmt.executeQuery();
				if(rs != null && rs.next())
				{

					for(int i=1;i<=7;i++)
					{
						clinicworkingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
						
							if(clinicworkingWeekApplday[i-1].equals("W"))
							{
							clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								clinicworkingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
						
						clinicworkingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
						
						clinicworkingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
						clinicworkingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
						clinicworkingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
						clinicworkingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
					}	
				 FI_VISIT_TYPE_APPL_YN = rs.getString("FI_VISIT_TYPE_APPL_YN");
				 FU_VISIT_TYPE_APPL_YN = rs.getString("FU_VISIT_TYPE_APPL_YN");
				 RT_VISIT_TYPE_APPL_YN = rs.getString("RT_VISIT_TYPE_APPL_YN");
				 SR_VISIT_TYPE_APPL_YN = rs.getString("SR_VISIT_TYPE_APPL_YN");
				 CS_VISIT_TYPE_APPL_YN = rs.getString("CS_VISIT_TYPE_APPL_YN");
			     EM_VISIT_TYPE_APPL_YN = rs.getString("EM_VISIT_TYPE_APPL_YN");

				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sqlmain.setLength(0);

				}catch(Exception e)
				{
					e.printStackTrace();
				}

				sql1.append("select a.care_locn_type_ind care_locn_type_ind,decode(a.care_locn_type_ind,'C','Clinic','E','Exam/Procedure Unit','D','Daycare Unit') unit_type_desc,a.resource_class resource_class,decode(a.resource_class,'P','Practitioner','R','Room','E','Equipment','O','Other') res_class_desc,a.resource_type resource_type,a.clinic_code clinic_code ,a.practitioner_id practitioner_id,decode(a.resource_class, 'P', b.practitioner_name,'R', d.short_desc, 'E', e.long_desc, 'O', e.short_desc) practitioner_name,a.eff_status eff_status ,c.long_desc res_unit_desc " );
				sql1.append(",a.working_week_appl_day_1 working_week_appl_day_1,a.working_week_appl_day_2 working_week_appl_day_2,a.working_week_appl_day_3 working_week_appl_day_3,a.working_week_appl_day_4 working_week_appl_day_4,a.working_week_appl_day_5 working_week_appl_day_5,a.working_week_appl_day_6 working_week_appl_day_6,a.working_week_appl_day_7 working_week_appl_day_7 ");		
				sql1.append(",a.working_week_1_day_1 working_week_1_day_1,a.working_week_1_day_2 working_week_1_day_2,a.working_week_1_day_3 working_week_1_day_3,a.working_week_1_day_4 working_week_1_day_4,a.working_week_1_day_5 working_week_1_day_5,a.working_week_1_day_6 working_week_1_day_6,a.working_week_1_day_7 working_week_1_day_7");
				sql1.append(",a.working_week_2_day_1 working_week_2_day_1,a.working_week_2_day_2 working_week_2_day_2,a.working_week_2_day_3 working_week_2_day_3,a.working_week_2_day_4 working_week_2_day_4,a.working_week_2_day_5 working_week_2_day_5,a.working_week_2_day_6 working_week_2_day_6,a.working_week_2_day_7 working_week_2_day_7");		
				sql1.append(",a.working_week_3_day_1 working_week_3_day_1,a.working_week_3_day_2 working_week_3_day_2,a.working_week_3_day_3 working_week_3_day_3,a.working_week_3_day_4 working_week_3_day_4,a.working_week_3_day_5 working_week_3_day_5,a.working_week_3_day_6 working_week_3_day_6,a.working_week_3_day_7 working_week_3_day_7");		
				sql1.append(",a.working_week_4_day_1 working_week_4_day_1,a.working_week_4_day_2 working_week_4_day_2,a.working_week_4_day_3 working_week_4_day_3,a.working_week_4_day_4 working_week_4_day_4,a.working_week_4_day_5 working_week_4_day_5,a.working_week_4_day_6 working_week_4_day_6,a.working_week_4_day_7 working_week_4_day_7");
				sql1.append(",a.working_week_5_day_1 working_week_5_day_1,a.working_week_5_day_2 working_week_5_day_2,a.working_week_5_day_3 working_week_5_day_3,a.working_week_5_day_4 working_week_5_day_4,a.working_week_5_day_5 working_week_5_day_5,a.working_week_5_day_6 working_week_5_day_6,a.working_week_5_day_7 working_week_5_day_7,");
				sql1.append("a.fi_visit_type_appl_yn fi_visit_type_appl_yn,a.fu_visit_type_appl_yn fu_visit_type_appl_yn,a.rt_visit_type_appl_yn rt_visit_type_appl_yn,a.sr_visit_type_appl_yn sr_visit_type_appl_yn,a.cs_visit_type_appl_yn cs_visit_type_appl_yn,a.em_visit_type_appl_yn em_visit_type_appl_yn ");
				sql1.append(" from op_pract_for_clinic a,am_practitioner b, op_clinic c,am_facility_room d , am_resource e where a.facility_id='"+facilityid+"' and a.clinic_code='"+resunit+"' and a.care_locn_type_ind='"+care_locn_type_ind+"' and a.resource_class = '"+resclass+"' and a.practitioner_id='"+practitionerid+"' and a.practitioner_id=b.practitioner_id(+) and a.clinic_code = c.clinic_code and a.facility_id = e.facility_id(+) AND a.resource_class = e.resource_class (+) and a.practitioner_id=e.resource_id(+) and a.facility_id = d.operating_facility_id(+) AND a.practitioner_id = d.room_num(+)");
				
			
				pstmt=con.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{					
						care_locn_type_ind=(rs.getString("care_locn_type_ind")==null)?"":
							rs.getString("care_locn_type_ind");
						practname=(rs.getString("practitioner_name") == null) ?"":rs.getString("practitioner_name");

						unittypedesc=(rs.getString("unit_type_desc") == null) ?"":rs.getString("unit_type_desc");
						
						resclassdesc=(rs.getString("res_class_desc") == null) ?"":rs.getString("res_class_desc");

						restype=(rs.getString("resource_type") == null)?"":rs.getString("resource_type");

						resunitdesc=(rs.getString("res_unit_desc") == null)?"":rs.getString("res_unit_desc");

						effstatus=(rs.getString("eff_status") == null)?"D":rs.getString("eff_status");

						
						for(int i=1;i<=7;i++)
						{
							workingWeekApplday[i-1]=(rs.getString("working_week_appl_day_"+i) == null)?"N":rs.getString("working_week_appl_day_"+i);
							if(workingWeekApplday[i-1].equals("W"))
							{
							workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
							}
							else
							{
								workingweekappldesc[i-1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
							}
							
							workingweek1day[i-1]=(rs.getString("working_week_1_day_"+i) == null)?"N":rs.getString("working_week_1_day_"+i);
							workingweek2day[i-1]=(rs.getString("working_week_2_day_"+i) == null)?"N":rs.getString("working_week_2_day_"+i);
							workingweek3day[i-1]=(rs.getString("working_week_3_day_"+i) == null)?"N":rs.getString("working_week_3_day_"+i);
							workingweek4day[i-1]=(rs.getString("working_week_4_day_"+i) == null)?"N":rs.getString("working_week_4_day_"+i);
							workingweek5day[i-1]=(rs.getString("working_week_5_day_"+i) == null)?"N":rs.getString("working_week_5_day_"+i);
						}	
						firstchk=(rs.getString("fi_visit_type_appl_yn") == null)?"N":rs.getString("fi_visit_type_appl_yn");
						followchk=(rs.getString("fu_visit_type_appl_yn") == null)?"N":rs.getString("fu_visit_type_appl_yn");
						routinechk=(rs.getString("rt_visit_type_appl_yn") == null)?"N":rs.getString("rt_visit_type_appl_yn");
						serieschk=(rs.getString("sr_visit_type_appl_yn") == null)?"N":rs.getString("sr_visit_type_appl_yn");
						consultchk=(rs.getString("cs_visit_type_appl_yn") == null)?"N":rs.getString("cs_visit_type_appl_yn");
						emerchk=(rs.getString("em_visit_type_appl_yn") == null)?"N":rs.getString("em_visit_type_appl_yn");
					}
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

				sql1.setLength(0);

				if(effstatus.equals("D"))
				{
					if(resclass.equals("P"))
					{
						sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E'  and pract_type='"+restype+"' ";
					}
					else if(resclass.equals("R"))
					{
						sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' and locn_type='"+restype+"'";
					}
					else if(resclass.equals("E"))
					{
						sql="select resource_type,short_desc from am_resource_type where resource_class='E' and resource_type='"+restype+"' ";
					}
					else if(resclass.equals("O"))
					{
						sql="select resource_type,short_desc from am_resource_type where resource_class='O' and resource_type='"+restype+"' ";
					}
					if(!sql.equals(""))
					{
						try
						{
							pstmt=con.prepareStatement(sql);
							rs=pstmt.executeQuery();
							if(rs != null && rs.next())
							{
								restypedesc=(rs.getString(2) == null)?"":rs.getString(2);
							}

						 if(rs != null )rs.close();
						 if(pstmt != null ) pstmt.close();

						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}

			

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		else
		{
			fnval="insert";
		}
	}
	


%>
<form name="clinic_form" id="clinic_form" action="../../servlet/eOP.PractitionerClinicServlet" method="post" target="messageFrame">

<BR><BR><BR><BR>
 <!-- The following block is used to get the clinic names. based on the 
	   effectiveStatus and facilityID from the table OP_clinic.
	 
	   menuitemCheck(): This should be called in an onChange() Event.Based on the 
	   clinic selection- WorkingDays ,Enabled checkbox and Applicable VisitTypeIndicator
	   are either checked OR unchecked
--> 

<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<tr>
		<td>
	<%
	if(callfunc.equals("Pract_for_clinic"))
	{
	%>
			<table border="0" cellpadding="3" cellspacing="0" width="100%" > 
				<tr>
					<td width="5%" class="label" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
					<td width='10%' class='fields'>
					<%
						if(fnval.equals("modify") && effstatus.equals("D"))
						{
						%>
							<input type='text' name="clinic_desc" id="clinic_desc" value="<%=clinicdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
							<input type='hidden' name="clinic" id="clinic" value="<%=clinicmod%>">
						<%
						}
						else
						{
						if(fnval.equals("modify"))
							  disable="disabled";
                         else disable="";
						%>
						<select name='clinic' id='clinic' onChange='clearPractVals();GetValues(this)' <%=disable%>><!--onChange="menuItemCheck(this.value)"-->
							<option value='' selected>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
							<%
							
								try
								{        
									sql=" Select clinic_code,long_desc from op_clinic where eff_status='E' and open_to_all_pract_yn='N' and facility_id = '"+facilityid+"' and clinic_type='C' and CARE_LOCN_TYPE_IND = 'C' and PRIMARY_RESOURCE_CLASS = 'P' order by long_desc  ";
									pstmt=con.prepareStatement(sql);
									rs = pstmt.executeQuery();
									if( rs != null )
									{
										while( rs.next())
										{			
											cliniccode=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");	
											
											if(clinicmod.equals(cliniccode))
											{
												sel="selected";
											}
											else
											{
												sel="";
											}
											%>
												<option value='<%=cliniccode%>' <%=sel%>><%=(rs.getString("long_desc") == null)?"":rs.getString("long_desc") %>			   
											<%
										}
				   
									}
									if (pstmt != null) pstmt.close();
									if (rs != null) rs.close();
						
								}catch(Exception e)
								{
									e.printStackTrace();
								}
							%>
						</select><img src="../../eCommon/images/mandatory.gif"></img>
						<%
						}
						%>
					</td>
					<td width="15%" class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td width="20%" class='fields'>
						<%
						if(fnval.equals("modify") || effstatus.equals("D"))
						{
							disable="disabled";
							readonly="readonly";
						}
						else
						{
							disable="";
							readonly="";
						}
						%>
						<input type="text" name="pract_name" id="pract_name" maxlength="25" size="25" value='<%=practname%>' onBlur="onBlurCallPractitionerSearch(document.forms[0].preact_butt,pract_name);" <%=readonly%>><input type='button' name='preact_butt' id='preact_butt' value='?' class='button'  onClick="getPract(this,pract_name);" <%=disable%>><input type="hidden" name="practitioner" id="practitioner" value="<%=practitionerid%>"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
							
				</tr>
				<tr>
					<td width="5%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td width="10%" class='fields'>
							<%
							if(effstatus.equals("E"))
							{
								chkval="checked";
							}
							else
							{
								chkval="";
							}
							%>
						<input type='checkbox'  name='active' id='active' onClick='assignval(this)' value="<%=effstatus%>" <%=chkval%>>
					</td>
					<td colspan='2'>&nbsp;</td>
				</tr>				
			</table>
			<%
			}
			else if(callfunc.equals("Resource_unit"))
			{
				String unittypecode="";
				String unittypedesc1="";
			%>
				<table cellpadding='3' cellspacing=0 border=0 width='100%' align='center'>
							
						<tr>
						<td width='152pts' class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>	
						<td class='fields' width='33%'>
							<%
							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							%>
								<input type='text' name="unit_type_desc" id="unit_type_desc" value="<%=unittypedesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
								<input type='hidden' name="unit_type" id="unit_type" value="<%=unittype%>">

							<%
							}
							else
							{	
							%>
								<select name="unit_type" id="unit_type" onChange="GetValues(this);">
								<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;

								<%
								pstmt=con.prepareStatement("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										unittypecode=rs.getString("locn_type");
										unittypedesc1=rs.getString("short_desc");

										%>
											<option value='<%=unittypecode%>'><%=unittypedesc1%>
										<%
									}
								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								%>
											
								</select> <img src="../../eCommon/images/mandatory.gif"></img> 
							<%									
								if(fnval.equals("modify"))
								{
								%>
								<script>
									unittypemodify('<%=unittype%>');
								</script>
								<%
								}							
							}
							
							%>
							</td>
							<td class='label' width='156pts'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>	
							<td class='fields'>
							<%
							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							%>
								<input type='text' name="res_unit1" id="res_unit1" value="<%=resunitdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
								<input type='hidden' name="res_unit" id="res_unit" value="<%=resunit%>">

							<%
							}
							else
							{
								//ValidateResName(this);
								if(fnval.equals("modify"))
								{%>

								<input type='text' name="res_unit1" id="res_unit1" value="<%=resunitdesc%>" size='30' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
								<input type='hidden' name="res_unit" id="res_unit" value="<%=resunit%>">
								<!--
								<select name="res_unit" id="res_unit" disabled>
								<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
									bundle="${common_labels}"/> --------&nbsp;
								-->
								<%}else{%>
								<INPUT TYPE="text" name="res_unit1" id="res_unit1"  onBlur="onBlurgetLoc('<%=facilityid%>',document.getElementById('unit_type').value,document.getElementById('res_unit1'));ValidateResName(this);GetValues(document.getElementById('res_unit1'));"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=facilityid%>',document.getElementById('unit_type').value,document.getElementById('res_unit1'));ValidateResName(this);GetValues(document.getElementById('res_unit1'));" ><img src="../../eCommon/images/mandatory.gif"></img>
								<input type="hidden" name="res_unit" id="res_unit"> 	
								 
								<!--
								<select name="res_unit" id="res_unit" onChange='ValidateResName(this);GetValues(this);'>
								<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
								-->
								
						 	<%
								}					
							}
							%>
						</td>
						</tr>
					  	<tr>
						<td class='label' nowrap><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
						<td class='fields'>
							<%
							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							%>
								<input type='text' name="res_class_desc" id="res_class_desc" value="<%=resclassdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
								<input type='hidden' name="res_class" id="res_class" value="<%=resclass%>">								
							<%
							}
							else
							{
															
							%>
							<select name="res_class" id="res_class" onChange="ValidateResName(this);GetValues(this);" >
							<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
								bundle="${common_labels}"/> --------&nbsp;
							<%if(care_locn_type_ind.equals("D")&&fnval.equals("modify"))
								{%>
								<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
								<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
								<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>	
								<%}else{%>
							    <option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
								<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
								<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
								<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>		
								<%}%>
							</select><img src="../../eCommon/images/mandatory.gif"></img>
								<%
								if(fnval.equals("modify"))
								{
								%>
									<script>
									resclassmod('<%=resclass%>')
									</script>
								<%
								}
								
							%>	
							</select>
							<%
							}
							%>
						</td>
						<td class='label' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
						<td class='fields'>
						<%
							if(fnval.equals("modify") && effstatus.equals("D"))
							{
							%>
								<input type='text' name="res_type_desc" id="res_type_desc" value="<%=restypedesc%>" readonly>
								<input type='hidden' name="res_type" id="res_type" value="<%=restype%>">
							<%
							}
							else
							{
							%> 	<%if(fnval.equals("insert"))
									{%>
								<select name="res_type" id="res_type" onChange="clearpract(this)" >
								<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
							  <%}else{%>
							       <select name="res_type" id="res_type" onChange="clearpract(this)" disabled>
								<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
							     
							     <%	
							  try{
									if(fnval.equals("modify"))
									{
										if(resclass.equals("P"))
										{
											sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by desc_sysdef";
										}
										else if(resclass.equals("R"))
										{
											sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
										}
										else if(resclass.equals("E"))
										{
											sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
										}
										else if(resclass.equals("O"))
										{
											sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
										}

										if(!sql.equals(""))
										{
											pstmt=con.prepareStatement(sql);
											rs=pstmt.executeQuery();
											if(rs != null)
											{
												
												while(rs.next())
												{
													restypecode=( rs.getString(1)== null)?"": rs.getString(1);
													
														
													if(restypecode.equals(restype))
													{
														sel="selected";
													}
													else
													{
														sel="";
													}
													%>
														<option value='<%=restypecode%>' <%=sel%>><%=rs.getString(2)%>
														<%
														}
												}
											}
											if(pstmt != null) pstmt.close();
											if(rs != null) rs.close();

										}						
										
									
								}catch(Exception e)
								{
									e.printStackTrace();
								}
							
							  }%>
									</select>
								<%
								}
								%>
						</td>		
						</tr>	
						<tr>							
						<td class='label' nowrap><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
						<td class='fields' nowrap>	
							<%
							if(fnval.equals("modify") || effstatus.equals("D"))
							{
								disable="disabled";
								readonly="readonly";
								disable1="";
							}
							else if(!fnval.equals("modify"))
							{
								disable="disabled";
								//disable="";
								readonly="";
								disable1="disabled";
							}
							else
							{
								disable="";
								readonly="";
							}
							// <%=disable
							%>
							<input type="text" name="res_name" id="res_name" maxlength="25" size="25" value="<%=practname%>" onBlur="onblurres()" <%=readonly%> <%=disable%>><input type='button' name='reslookup_butt' id='reslookup_butt' value='?' class='button'  onCLick="resourcenamelookup()" <%=disable%>><img src='../../eCommon/images/mandatory.gif'></img>
							<input type="hidden" name="res_id" id="res_id" value="<%=practitionerid%>">				
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields'>
							<%
							if(effstatus.equals("E"))
							{
								chkval="checked";
							}
							else
							{
								chkval="";
							}
							%>
							<input type='checkbox'  name='active' id='active' onClick='assignval(this)' value="<%=effstatus%>" <%=chkval%>>
						</td>
					</tr>
					</table>
			<%
			}
			%>
		</td>
		</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
		<tr>
		<td>
			<!-- Added by Sen on 15/06/2004 for creating two tables representing the availability of 
			clinic and practitioner -->
			<table border=1 cellpadding=0 cellspacing=0 width='100%' >					
				<tr>
					<td width='50%' class='oaborder'>
						<table border='0' cellpadding='0' cellspacing='0' width='100%' >		
							<tr>
								<td class='label' width='10%'>&nbsp;
								</td>   
								<%
								try
								{
									pstmt=con.prepareStatement("select day_no,day_of_week from sm_day_of_week order by day_no");
									rs = pstmt.executeQuery();
									if(rs != null)
									{
										while(rs.next())
										{
											daysofweek = rs.getString("day_of_week").substring(0,3);
											%>
												<td class='labelleft' width='5%' style="color: #00008B;"><%=daysofweek%>
												</td>
											<%
										}
										
									}
									if(pstmt != null) pstmt.close();
									if( rs != null) rs.close();
								}catch(Exception e)
								{
									e.printStackTrace();
								}
								%>																
							</tr>
							<tr>
								<td colspan='8'>&nbsp;</td>
							</tr>
							<tr>
								<td class='label' nowrap><fmt:message key="Common.WeekAppl.label" bundle="${common_labels}"/></td>
								<%
								for(int j=1;j<=7;j++)
								{									
								%>
									<td class='QUERYDATA' id='week_appl_day_<%=j%>' ><fmt:message key="Common.specific.label" bundle="${common_labels}"/></td>
								<script>
									if('<%=clinicworkingWeekApplday[j-1]%>' == "W")
									{										
										eval(document.getElementById("week_appl_day_<%=j%>")).innerText=getLabel('Common.specific.label','Common');
									}
									else
									{
										eval(document.getElementById("week_appl_day_<%=j%>")).innerText=getLabel('Common.all.label','Common');
									}
										</script>
								<%
								}
								%>
							</tr>							
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 1</td>
							<%
							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek1day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
									
							%>
								<td width='5%'  class='fields'>									
									<input type='checkbox' name='working_week_1_day_<%=j%>' id='working_week_1_day_<%=j%>' value='<%=clinicworkingweek1day[j-1]%>' disabled <%=chkval%> >
								</td>
								
							<%
							}
							%>										
							</tr>	
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 2</td>
							<%
							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek2day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							%>
								<td width='5%' class='fields'>									
									<input type='checkbox' name='working_week_2_day_<%=j%>' id='working_week_2_day_<%=j%>' value='<%=clinicworkingweek2day[j-1]%>'  disabled <%=chkval%>>
								</td>
								
							<%
							}
							%>								
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 3</td>
							<%
							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek3day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							%>
								<td width='5%' class='fields'>										
									<input type='checkbox' name='working_week_3_day_<%=j%>' id='working_week_3_day_<%=j%>' value='<%=clinicworkingweek3day[j-1]%>'  disabled <%=chkval%>>
								</td>
								
							<%
							}
							%>				
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 4</td>
							<%
							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek4day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							%>
								<td width='5%' class='fields'>									
									<input type='checkbox' name='working_week_4_day_<%=j%>' id='working_week_4_day_<%=j%>' value='<%=clinicworkingweek4day[j-1]%>' disabled <%=chkval%>>
								</td>
								
							<%
							}
							%>															
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 5</td>
							<%
							for(int j=1;j<=7;j++)
							{
									chkval="";
									if(clinicworkingweek5day[j-1].equals("W"))
									{
										chkval="checked";
									}
									else
									{
										chkval="";
									}
							%>
								<td width='5%' class='fields'>								
									<input type='checkbox' name='working_week_5_day_<%=j%>' id='working_week_5_day_<%=j%>'  value='<%=clinicworkingweek5day[j-1]%>' disabled <%=chkval%>>
								</td>
								
							<%
							}
							%>										
								</td>								
							</tr>								
						</table>
					</td>
					<td width='50%' class='oaborder'>
						<table border='0' cellpadding='0' cellspacing='0' width='100%' >		
							<tr>
								<td class='label' width='10%' >&nbsp;
								</td>   
							<%
							try
							{
								pstmt=con.prepareStatement("select day_no,day_of_week from sm_day_of_week order by day_no");
								if (rs != null) rs.close();
								rs = pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{										
										daysofweek = rs.getString("day_of_week").substring(0,3);
										%>
											<td class='labelleft' width='5%' style="color: #00008B;"><%=daysofweek%>
											</td>
										<%
										
									}													
								}
								if(pstmt != null) pstmt.close();
								if( rs != null) rs.close();
							}catch(Exception e)
							{
								e.printStackTrace();
							}
							%>															
							</tr>
							<tr>
								<td colspan='8'>&nbsp;</td>
							</tr>
							<tr>
								<td width='1%' class='label' nowrap><fmt:message key="Common.WeekAppl.label" bundle="${common_labels}"/></td>
							<%
							
								
							for(int i=1;i<=7;i++)
							{
								
								

						

								

						if(fnval.equals("modify") && effstatus.equals("D"))
								{	%>
									<td width='1%' class='fields'>
										<input type='text' name="pract_week_appl_daydesc_<%=i%>" id="pract_week_appl_daydesc_<%=i%>" value="<%=workingweekappldesc[i-1]%>" size='4' maxlength='4' align='center' readonly>
										<input type='hidden' name="pract_week_appl_day_<%=i%>" id="pract_week_appl_day_<%=i%>" value="<%=workingWeekApplday[i-1]%>">
									</td>
							<%	}
								else
								{	%>
										<td width='1%' class='fields'>
											<select name="pract_week_appl_day_<%=i%>" id="pract_week_appl_day_<%=i%>" onChange='chekUnchek(this,"<%=i%>")' class='label' align='center'>
												<option value='W'  ><fmt:message key="Common.specific.label" bundle="${common_labels}"/> </option>
												<option value='A'  ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
											</select>									
										</td>
									<%
									if(fnval.equals("modify"))
									{
									%>
									<script>
									assignweekappl('<%=workingWeekApplday[i-1]%>','<%=clinicworkingWeekApplday[i-1]%>','<%=i%>')
									</script>
									<%
									}
								   					 
								}
								
							}
							%>
							</tr>
								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 1</td>
							<%
							
							
							for(int j=1;j<=7;j++)
							{
									chkval="";
									disable="";
									
									if(workingweek1day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek1day[j-1].equals("N"))
									{
										
										if(clinicworkingweek1day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
										
									}
									else
									{
										
										if((clinicworkingweek1day[j-1].equals("H")) && (workingweek1day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							
							%>
								<td width='5%' class='fields'>									
									<input type='checkbox' name='pract_working_week_1_day_<%=j%>' id='pract_working_week_1_day_<%=j%>' onClick='assigndays(this)' value='<%=workingweek1day[j-1]%>' <%=chkval%> <%=disable%>>									
								</td>
								<input type='hidden' name='pract_working_week_1_day_<%=j%>1' id='pract_working_week_1_day_<%=j%>1' value='<%=workingweek1day[j-1]%>' >
							<%
							}
							%>										
							</tr>	
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 2</td>
							<%
							for(int j=1;j<=7;j++)
							{		
									chkval="";
									disable="";
									if(workingweek2day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek2day[j-1].equals("N"))
									{
										if(clinicworkingweek2day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek2day[j-1].equals("H")) && (workingweek2day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							%>
								<td width='5%' class='fields'>									
									<input type='checkbox' name='pract_working_week_2_day_<%=j%>' id='pract_working_week_2_day_<%=j%>'   onClick='assigndays(this)' value='<%=workingweek2day[j-1]%>' <%=disable%> <%=chkval%>>
								</td>
								<input type='hidden' name='pract_working_week_2_day_<%=j%>1' id='pract_working_week_2_day_<%=j%>1' value='<%=workingweek2day[j-1]%>' >
							<%
							}
							%>																
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 3</td>
							<%
							for(int j=1;j<=7;j++)
							{	
									chkval="";
									disable="";
									
									if(workingweek3day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek3day[j-1].equals("N"))
									{
										if(clinicworkingweek3day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek3day[j-1].equals("H")) && (workingweek3day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							%>
								<td width='5%' class='fields'>										
									<input type='checkbox' name='pract_working_week_3_day_<%=j%>' id='pract_working_week_3_day_<%=j%>'   onClick='assigndays(this)' value='<%=workingweek3day[j-1]%>' <%=chkval%> <%=disable%>>
								</td>
								<input type='hidden' name='pract_working_week_3_day_<%=j%>1' id='pract_working_week_3_day_<%=j%>1' value='<%=workingweek3day[j-1]%>' >
							<%
							}
							%>													
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 4</td>
							<%
							for(int j=1;j<=7;j++)
							{	
									chkval="";
									disable="";
								if(workingweek4day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek4day[j-1].equals("N"))
									{
										if(clinicworkingweek4day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										

										if((clinicworkingweek4day[j-1].equals("H")) && (workingweek4day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
						%>
								<td width='5%' class='fields'>									
									<input type='checkbox' name='pract_working_week_4_day_<%=j%>' id='pract_working_week_4_day_<%=j%>' onClick='assigndays(this)' value='<%=workingweek4day[j-1]%>' <%=chkval%> <%=disable%>>
								</td>
								<input type='hidden' name='pract_working_week_4_day_<%=j%>1' id='pract_working_week_4_day_<%=j%>1' value='<%=workingweek4day[j-1]%>' >
							<%
							}
							%>															
							</tr>								
							<tr>
								<td class='label' nowrap><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 5</td>
							<%
							for(int j=1;j<=7;j++)
							{		
								chkval="";
									disable="";
									if(workingweek5day[j-1].equals("W"))
									{
										chkval="checked";
										disable="";
									}
									else if(workingweek5day[j-1].equals("N"))
									{
										if(clinicworkingweek5day[j-1].equals("N"))
										{
											chkval="";
										disable="disabled";
										}
										else
										{
										chkval="";
										disable="";
										}
									}
									else
									{
										if((clinicworkingweek5day[j-1].equals("H")) && (workingweek5day[j-1].equals("H")))
										{
										chkval="";
										disable="disabled";
										}
										else
										{
											chkval="";
											disable="";
										}
										
									}

									if(fnval.equals("modify") && effstatus.equals("D"))
									{
										disable="disabled";
									}
							%>
								<td width='5%' class='fields'>								
									<input type='checkbox' name='pract_working_week_5_day_<%=j%>' id='pract_working_week_5_day_<%=j%>'   onClick='assigndays(this)' value='<%=workingweek5day[j-1]%>' <%=chkval%> <%=disable%> >
								</td>
								<input type='hidden' name='pract_working_week_5_day_<%=j%>1' id='pract_working_week_5_day_<%=j%>1' value='<%=workingweek5day[j-1]%>' >
							<%
							}
							%>															
							</tr>								
						</table>
					</td>
				</tr>
			</table>
			<!-- Addition by sen ends-->
			<BR>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" >	
				<th class='columnheader' align='left'><fmt:message key="eOP.ApplicableVisitTypeIndicators.label" bundle="${op_labels}"/></th>
				<tr>
					<td class="Border">
						<table border="0" cellpadding="0" cellspacing="0" width="100%" >
							<tr>
								<td colspan='4'>&nbsp;</td>
							</tr>
							<tr>
								<td width='5%' class=label><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>
								<td width='5%' class='fields'>
									<%
											chkval="";
											disable="";
											if(emerchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(emerchk.equals("N"))
											{
												if(EM_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}

									%>
									<input type=checkbox name='emergency' id='emergency' value="<%=emerchk%>"  onClick='assignval(this)' <%=chkval%> <%=disable%>>
									<input type='hidden' name='emergency1' id='emergency1' value='<%=emerchk%>'>
								</td>
								<td width='5%' class=label><fmt:message key="Common.first.label" bundle="${common_labels}"/></td>
								<td width='5%' class='fields'>
									<%
											chkval="";
											disable="";
											if(firstchk.equals("Y"))
											{
												chkval="checked";
												
											}
											else if(firstchk.equals("N"))
											{
												if(FI_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}

									%>
									<input type=checkbox name='first' id='first' value="<%=firstchk%>" onClick='assignval(this)' <%=chkval%> <%=disable%>>
										<input type='hidden' name='first1' id='first1' value='<%=firstchk%>'>
								</td>
								<td width='5%' class=label nowrap><fmt:message key="Common.followup.label" bundle="${common_labels}"/></td>
								<td class='fields' width='5%'>
									<%
											chkval="";
											disable="";
										if(followchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(followchk.equals("N"))
											{
												if(FU_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
										%>
									<input type=checkbox name='follow' id='follow' value="<%=followchk%>" onClick='assignval(this)' <%=chkval%> <%=disable%>>
										<input type='hidden' name='follow1' id='follow1' value='<%=followchk%>'>
								</td>
							</tr>
							<tr>
								<td width='5%' class=label><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
								<td class='fields' width='5%'>
									<%
											chkval="";
											disable="";
											if(routinechk.equals("Y"))
											{
												chkval="checked";
											}
											else if(routinechk.equals("N"))
											{
												if(RT_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
									%>
									<input type=checkbox name='routine' id='routine' value="<%=routinechk%>" onClick='assignval(this)' <%=chkval%> <%=disable%>>
										<input type='hidden' name='routine1' id='routine1' value='<%=routinechk%>'>
								</td>
								<td width='5%' class=label><fmt:message key="Common.Series.label" bundle="${common_labels}"/></td>
								<td class='fields' width='5%'>
									<%
											chkval="";
											disable="";
											if(serieschk.equals("Y"))
											{
												chkval="checked";
											}
											else if(serieschk.equals("N"))
											{
												if(SR_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
										
									%>
									<input type=checkbox name='series' id='series' value="<%=serieschk%>" onClick='assignval(this)' <%=chkval%> <%=disable%>>
									<input type='hidden' name='series1' id='series1' value='<%=serieschk%>'>
								</td>
								<td width='5%' class=label><fmt:message key="Common.Consult.label" bundle="${common_labels}"/></td>
								<td class='fields' width='5%'>
									<%
											chkval="";
											disable="";
											if(consultchk.equals("Y"))
											{
												chkval="checked";
											}
											else if(consultchk.equals("N"))
											{
												if(CS_VISIT_TYPE_APPL_YN.equals("N"))
												{
												chkval="";
												disable="disabled";
												}else
												{
												chkval="";
												disable="";
												}
											}
											else
											{
												chkval="";
											}
											
											if(fnval.equals("modify") && effstatus.equals("D"))
											{
												disable="disabled";
											}
									%>
									<input type=checkbox name="consult" id="consult" value="<%=consultchk%>" onClick="assignval(this)" <%=chkval%> <%=disable%>>
										<input type="hidden" name="consult1" id="consult1" value="<%=consultchk%>">
								</td>
							</tr>
							<tr>
								<td colspan='6'>&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>				
			</table>
		</td>
	</tr>
</table>

	<input type="hidden" name="function" id="function" value="<%=fnval%>">
	<input type="hidden" name="function_name" id="function_name" value="<%=fnval%>">
	<input type="hidden" name="call_function" id="call_function" value="<%=callfunc%>">
	<input type="hidden" name="eff_date_from" id="eff_date_from" >
	<input type="hidden" name="eff_date_to" id="eff_date_to" >
	<input type = "hidden" name="fac_id" id="fac_id" value="<%=facilityid%>">
	<input type = "hidden" name="speciality_code" id="speciality_code" value=''>
	<input type = "hidden" name="rd_appl_yn" id="rd_appl_yn" value=''>


	<!-- Following fields represent images in the original file-->
	<input type="hidden" name="i1" id="i1" >
	<input type="hidden" name="i2" id="i2" >
	<input type="hidden" name="i3" id="i3" >
	<input type="hidden" name="i4" id="i4" >
	<input type="hidden" name="i5" id="i5" >
	<input type="hidden" name="i6" id="i6" >
	<input type="hidden" name="i7" id="i7" >
	</form>
	</body>
	</html>
	<%
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>

