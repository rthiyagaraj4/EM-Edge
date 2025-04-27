<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	19/04/2006
	Module		:	OA   
-->

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="holidayval" scope="session" class="webbeans.eCommon.RecordSet" /> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper " %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/Holiday.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
String locale			= (String)session.getAttribute("LOCALE");

Connection con =null;
Statement stmt=null;
ResultSet rSet=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
String holiday_date_from_greg="";
String holiday_date_to_greg="";
String facilityId = (String) session.getValue( "facility_id" ) ;
String holiday_date_from=request.getParameter("holiday_date_from")==null?"":request.getParameter("holiday_date_from");
String holiday_date_to=request.getParameter("holiday_date_to")==null?"":request.getParameter("holiday_date_to");
if(holiday_date_to =="") holiday_date_to=holiday_date_from;

holiday_date_from_greg=DateUtils.convertDate(holiday_date_from,"DMY",locale,"en");
holiday_date_to_greg=DateUtils.convertDate(holiday_date_to,"DMY",locale,"en");

String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
String reason_for_holiday=request.getParameter("reason_for_holiday")==null?"":request.getParameter("reason_for_holiday");
String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;


int start = 0 ;
int end = 0 ;
int maxrecord=0;
int s=0;
StringBuffer sql1 = new StringBuffer();
StringBuffer sql2 = new StringBuffer();
StringBuffer sql1_chk2 = new StringBuffer();
String sql_two="";
String clinic_desc="";
String holiday_date_to_create="";
String holiday_date_to_create_disp="";
String class_value	= "QRYEVEN";
String req_start    =   "", req_end     =   "";
String checkedOnes="";

req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
String removeCode		= "";
	

	String flagSelect = request.getParameter("flagSelect");
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;



try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

	if(location_type.equals("D")){
				sql1_chk2.append(" and a.clinic_type='Y' ");
			}else{
				sql1_chk2.append(" and a.clinic_type='"+location_type+"' ");
			}

		if(!clinic_code.equals("")){
				sql1_chk2.append(" and a.clinic_code='"+clinic_code+"'");
			}



		//sql1_chk2.append("order by holiday_date,a.long_desc ");
	
	
		if(flagSelect !=null)
		{
			
			holidayval.clearAll();
			
			
		}
		String checkedOnes1="";
		//String checkedOnes2="";

		if(from != null && to != null)
		{
			 int j=0;
			 
			 for( s=(Integer.parseInt(req_start)); s<=(Integer.parseInt(req_end)); s++)
			 {
				 
				 if(request.getParameter("select_yn"+(s)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(s));
					 checkedOnes1 = request.getParameter("val"+(s));
					
					
					 if(!(holidayval.containsObject(checkedOnes1)))
						 holidayval.putObject(checkedOnes1);
						 j++;
				 }
				
				removeCode = checkForNull(request.getParameter("removeCode"+(s)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(s));
					if((holidayval.containsObject(Code)))
					{
						int removeCodeIndex = holidayval.indexOfObject(Code);
							holidayval.removeObject(removeCodeIndex);
					}
				}
			 }

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+s+"'>");
		 }
		%><body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='Holiday_result2_FORM' id='Holiday_result2_FORM' action='' method='post'  target=''>
		<%
		sql1.append("select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date,b.holiday_date holiday_date1 from op_clinic_lang_vw a ,(select to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_date_to_greg+"','dd/mm/yyyy')-to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and  not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code AND holiday_date = b.holiday_date )");
		sql1.append(sql1_chk2);
		sql2.append("minus select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date,b.holiday_date holiday_date1 from op_clinic_lang_vw a ,(select to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_date_to_greg+"','dd/mm/yyyy')-to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and  not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code )");
		sql2.append(sql1_chk2);

			sql_two =(sql1.append(sql2.toString())).toString()+" ORDER BY 4,2";
			//out.println("sql_two ExHoliday ==>"+sql_two);
			rSet = stmt.executeQuery(sql_two);
	
					%>
				<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
						<input type=hidden name='start' id='start' value='<%=start%>'>
						<input type=hidden name='end' id='end' value='<%=end%>'>

		<%
				s=1;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rSet.next() ;
				}

				String clinic_code1="";
				String chkAttribute="";
				String val2="";

			if(rSet !=null)
			{
				while ( s<=end && rSet.next() )
				{
					if(maxrecord==0)
					{
		%>

	<table width='80%' border=0 align='center' >
		<tr>
		<td align='right' class='NONURGENT'>
		<%
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
	//	if ( !((start+10) > maxrecord ))
			{
	%>
		<a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
	</td>	
	 </tr>
		</table>


			<div id='header' style="visibility:visible;backgroundColor:white;overflow:scroll">
				<table border="1" width="80%" bgColor=white align='center' cellspacing='0' cellpadding='0' id='result_locn1'>
				<th class='COLUMNHEADER'  width='31%'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th class='COLUMNHEADER'  width='30%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th class='COLUMNHEADER'  width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</table></div>
				<table border="1" width="80%" align='center' bgColor=white cellspacing='0' cellpadding='0' id='result_locn2'>
		<% }
			
					clinic_desc=rSet.getString("clinic_desc");
					clinic_code1=rSet.getString("clinic_code");
					holiday_date_to_create=rSet.getString("holiday_date");

					int sch_cnt = 0;
					String flag_val="";
					//String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_date = to_date('"+holiday_date_to_create+"','dd/mm/yyyy') and care_locn_type_ind='"+location_type+"' and clinic_code = '"+clinic_code1+"'";
					String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = ? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and clinic_code = ? ";
					pstmt=con.prepareStatement(sqlstr);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,holiday_date_to_create);
					pstmt.setString(3,location_type);
					pstmt.setString(4,clinic_code1);
					rs=pstmt.executeQuery();
					if (rs!=null && rs.next()){
						
						sch_cnt=rs.getInt("cnt");
						
					}
			if (sch_cnt >0) 
				{
				flag_val="S";
				}else
				{
				flag_val="N";
				}
					holiday_date_to_create_disp=DateUtils.convertDate(holiday_date_to_create,"DMY","en",locale);

					
					val2=clinic_code1+"|"+holiday_date_to_create+"|"+flag_val;

					if(holidayval.containsObject(val2))  
						chkAttribute = "CHECKED";
					else
						chkAttribute="";

					int recordIndex = holidayval.indexOfObject(val2);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED"))    
					holidayval.removeObject(recordIndex);	

					if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";	
					else
					class_value = "QRYEVEN";

					

					%>

			<tr>
	     	<td class="<%=class_value%>" width='38%'  nowrap align='left' > <%=clinic_desc%>&nbsp;&nbsp;</td>
				<input type='hidden' name='clinic_code1<%=s%>' id='clinic_code1<%=s%>' <%=clinic_code1%> value="<%=clinic_code1%>">
			<td class="<%=class_value%>"  width='37%' nowrap align='left' > <%=holiday_date_to_create_disp%>&nbsp;&nbsp;</td>
			    <input type='hidden' name='holiday_date<%=s%>' id='holiday_date<%=s%>' <%=holiday_date_to_create%> value="<%=holiday_date_to_create%>">
			<td class="<%=class_value%>" nowrap align=center>
				<input type=checkbox <%=chkAttribute%>   name='select_yn<%=s%>' width='18%'	Onclick="change_val1(this,<%=s%>,'<%=flag_val%>')"  value="<%=val2%> "><input type='hidden' name='removeCode<%=s%>' id='removeCode<%=s%>' value=""><input type='hidden' name='Code<%=s%>' id='Code<%=s%>' value="<%=val2%>"><input type='hidden' name='val<%=s%>' id='val<%=s%>' <%=val2%> value="<%=val2%>"><input type='hidden' name='sch_exists<%=s%>' id='sch_exists<%=s%>' value=""></td>
            </tr>
					<%
					s++;
					maxrecord++;
				}//end of while
			}

	if(maxrecord == 0)
	{%>
	<!-- modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] -->
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//history.go(-1);</script>
	<%}

	if ( maxrecord < 10 || (!rSet.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

	%>
	</table>
	<input type='hidden' name='holiday_date_from' id='holiday_date_from'  value='<%=holiday_date_from_greg%>'>
	<input type='hidden' name='holiday_date_to' id='holiday_date_to' value='<%=holiday_date_to_greg%>'>
	<input type='hidden' name='location_type' id='location_type' value='<%=location_type%>'>

	<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
	<input type='hidden' name='reason_for_holiday' id='reason_for_holiday' value="<%=reason_for_holiday%>">
	<input type='hidden' name='function_name' id='function_name' value='insertlocntype'>

	<%
	// modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338]
	   if(rs !=null) rs.close();
	   if(pstmt !=null) pstmt.close();
	   if(rSet !=null) rSet.close();
	   if(stmt !=null) stmt.close();
		

	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}finally
	{
		 ConnectionManager.returnConnection(con,request);
		session.setAttribute("holidayval", holidayval);

	}
%>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

