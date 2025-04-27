


<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
try
{	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String p_clinic_code	=(String) hash.get("cliniccode") ;
	String p_pract_code	= (String)hash.get("practcode") ;
	String p_day_no		= (String)hash.get("dayno") ;
	StringBuffer sql=new StringBuffer();
	String resourceClass=(String)hash.get("resourceClass");
	stmt = con.createStatement() ;
	String srcElement=(String)hash.get("from");
	String start_time=(String)hash.get("start_time");
	String end_time=(String)hash.get("end_time");
	String mode=(String)hash.get("mode");
	String rule_appl_yn = (String)hash.get("rule_appl_yn");
	int otheClinicTimeTableCount =0;	
%>

	
<% 
	if (!srcElement.equals("b_pract_name") && !srcElement.equals("pract_butt") && srcElement.equals("apply"))
	{
		sql  =sql.append( "select count(*) as total from oa_clinic_time_table where facility_id = '"+fac_id+"' and RESOURCE_CLASS='"+resourceClass+"'") ;
		if ((!p_day_no.equals("*A"))){
			sql =sql.append(" and day_no = '"+p_day_no+"' ");
		}		
		if(mode.equals("insert")){
			if(p_pract_code.equals("")){
				sql=sql.append(" AND  clinic_code = '"+p_clinic_code+"' AND practitioner_id is null ");
			}else{// code changed so that overlapped timetable will be created
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"'");							
			}/*else if(rule_appl_yn.equals("Y")){
				sql=sql.append(" AND ((clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"') OR (practitioner_id = '"+p_pract_code+"' AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR ('"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))");
				if ((!p_day_no.equals("*A"))){
					sql =sql.append(" and day_no = '"+p_day_no+"' ");
				}	
				sql=sql.append("))");				
				String othClinicTimeTableSQL = "select count(*) count from oa_clinic_time_table where facility_id = '"+fac_id+"' AND resource_class = '"+resourceClass+"' AND practitioner_id = '"+p_pract_code+"' AND (   (   TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR (   '"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND CLINIC_CODE !='"+p_clinic_code+"'";
				if(rs!=null)rs.close();
				rs = stmt.executeQuery(othClinicTimeTableSQL) ;
				if(rs!=null && rs.next()){
					otheClinicTimeTableCount =rs.getInt("count") ;
				}
			}else if(rule_appl_yn.equals("N")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"'");							
			}*/
			//sql=sql.append(" AND ( (TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR clinic_code = '"+p_clinic_code+"')");
		}else if(mode.equals("modify")){
			if(p_pract_code.equals("")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id is null ");
			}else{// code changed so that overlapped timetable will be created
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id = '"+p_pract_code+"'");
			}/*else if(rule_appl_yn.equals("Y")){
				sql=sql.append(" AND practitioner_id = '"+p_pract_code+"' AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR ('"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) ");
			}else if(rule_appl_yn.equals("N")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id = '"+p_pract_code+"'");
			}*/
			//sql=sql.append(" AND ( (TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') AND clinic_code != '"+p_clinic_code+"')");
		}
		//sql = sql.append(" and nvl(practitioner_id,'X') = nvl('"+p_pract_code+"','X') " );
			//System.out.println("p_day_no ==>"+p_day_no);
		if(rs!=null)rs.close();
		rs = stmt.executeQuery(sql.toString()) ;
		sql.setLength(0);
		rs.next();
		int cnt = rs.getInt("total") ;
		rs.close() ;
	
	if ( (mode.equals("insert") && cnt >0) ||(mode.equals("modify") && cnt >1))
	{
		if ((!p_day_no.equals("*A")))
		{%>
			var err_message = getMessage('TIME_TABLE_ALREAY_EXIST','OA') ;
			alert(err_message) ;
			//frames[1].document.forms[0].b_day.value='';
			toSubmit=false;
			frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		<%}else if(rule_appl_yn.equals("Y") && otheClinicTimeTableCount > 1){%>
			var err_message = getMessage('TIME_TABLE_ALREAY_EXIST','OA') ;
			alert(err_message) ;
			//frames[1].document.forms[0].b_day.value='';
			toSubmit=false;
			frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;		
		<%}else{%>
			var err_message = getMessage('TIME_TABLE_ALREAY_EXST_FOR_DAY','OA') ;
			var p=confirm(err_message);
			if (!p){ 
				toSubmit=false;
				frames[1].document.forms[0].b_day.value='';
			}
			frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		<%}
	}else
	{
		sql  = sql.append("select to_char(break_start_time,'HH24:MI') br_start_time, to_char(break_end_time,'HH24:MI') br_end_time from oa_clinic_break ") ;
		sql = sql.append("where facility_id = '"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and day_no = '"+p_day_no+"' and " );
		sql = sql.append("nvl(practitioner_id,'X') = nvl('"+p_pract_code+"','X') ") ;
	}
}

    if (!p_pract_code.equals("") && (srcElement.equals("b_pract_name") || srcElement.equals("pract_butt")))
{
	 %>dayObj=document.forms[0].b_day;
      opt=document.createElement('OPTION');
	  opt.value='';
	  opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	  opt1=document.createElement('OPTION');
	  opt1.value='*A';
	  opt1.text="*"+getLabel("Common.all.label","Common");
	  while(dayObj.options.length > 0) dayObj.remove(dayObj.options[0]);
	  dayObj.add(opt);
      dayObj.add(opt1);

	 <% String sql1="select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists (select '1' from op_pract_for_clinic where decode(a.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code ='"+p_clinic_code+"' and practitioner_id='"+p_pract_code+"' and resource_class='"+resourceClass+"' and eff_status='E') order by 2";
      
	rs=stmt.executeQuery(sql1);
	String dayOfWeek="";
	String dayNumber="";
	while(rs.next() && rs!=null)
		{
			dayOfWeek=rs.getString("day_of_week");
			dayNumber=rs.getString("day_no");
			
			if(dayOfWeek.equals("Monday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dayOfWeek.equals("Tuesday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dayOfWeek.equals("Wednesday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dayOfWeek.equals("Thursday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dayOfWeek.equals("Friday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dayOfWeek.equals("Saturday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dayOfWeek.equals("Sunday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}	


			%>opt=document.createElement('OPTION');
			 
			opt.value='<%=dayNumber%>';
			opt.text='<%=dayOfWeek%>';
			frames[1].document.forms[0].b_day.add(opt);
	 <%}%>
		
		 dayObj=document.forms[0].b_day;
		if (dayObj.options.length == 2)
		 {
			 dayObj.remove(dayObj.options[0]);
			 dayObj.remove(dayObj.options[1]);
			 opt=document.createElement('OPTION');
			 opt.value='';
			 opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
			 dayObj.add(opt);
		  }
 <%}
 	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	hash.clear();
}catch( Exception e )
{
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


