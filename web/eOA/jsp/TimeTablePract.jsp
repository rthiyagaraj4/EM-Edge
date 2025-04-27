<!DOCTYPE html>

<!--
	Developed by 	:	R.Nanda Kumar
	Created on 	:	17/02/2001
	Module		:	OA
	Function	:	This function is used

 
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
request.setCharacterEncoding("UTF-8");
try{
con = ConnectionManager.getConnection(request);
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String p_clinic_code	= request.getParameter("cliniccode");
	String resource_type		= request.getParameter("resource_type");
	//System.out.println("p_clinic_code :"+p_clinic_code);
	//System.out.println("resource_type :"+resource_type);
	String resource_id		= request.getParameter("resource_id");
	String primary_resource_class="";
	StringBuffer sql1=new StringBuffer();
	//System.out.println("resource_id :"+resource_id);
    
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");

	stmt = con.createStatement() ;
	if(!(p_clinic_code.equals("*A"))){

		sql1.append("select clinic_type,ident_at_checkin,fi_visit_type_appl_yn,open_to_all_pract_yn,primary_resource_class from op_clinic where facility_id = '"+fac_id+"' and eff_status = 'E' and clinic_code = '"+p_clinic_code+"' order by short_desc ");

		rs  = stmt.executeQuery(sql1.toString()) ;

		sql1.setLength(0);

		rs.next() ;

		String p_fi_visit_type_appl_yn 	= rs.getString("fi_visit_type_appl_yn") ;
		String p_ident_at_checkin	= rs.getString("ident_at_checkin") ;
		String p_clinic_type		= rs.getString("clinic_type") ;
		String p_open_to_all_pract_yn	= rs.getString("open_to_all_pract_yn") ;
		primary_resource_class	= rs.getString("primary_resource_class") ;

		sql1.append("select short_desc from am_care_locn_type where locn_type = '"+p_clinic_type+"' " );

		if (rs!=null) rs.close();
		rs   = stmt.executeQuery(sql1.toString()) ;

		sql1.setLength(0);
		rs.next() ;

		//String p_clinic_type_desc	= rs.getString("short_desc") ;

		%>
		<script>			
		var opt = parent.frames[1].document.createElement('OPTION');
		var opt1 = parent.frames[1].document.createElement('OPTION');
		var opt = parent.frames[1].document.createElement('OPTION');
		var opt1 = parent.frames[1].document.createElement('OPTION');
		opt1.text = "*"+getLabel("Common.all.label","Common");
		opt1.value= '*A';
		parent.frames[1].document.forms[0].b_day.add(opt1);
		parent.frames[1].document.forms[0].l_ident_at_checkin.value 	="<%=p_ident_at_checkin%>" ;
		parent.frames[1].document.forms[0].l_fi_visit_type_appl_yn.value="<%=p_fi_visit_type_appl_yn%>" ;
		parent.frames[1].document.forms[0].l_open_to_all_pract_yn.value	="<%=p_open_to_all_pract_yn%>" ;
		</script>
		<%
		String str1 = "";
		String str2 = "";
		int counter=0;

		if (p_open_to_all_pract_yn.equalsIgnoreCase("Y")){

			if (rs!=null)rs.close();
			//if(primary_resource_class.equals("P") && !resource_type.equals("P")){
				sql1.append( "select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
				sql1=sql1.append("(select '1' from op_pract_for_clinic_vw where decode(a.day_no,'1',working_day_1," );
				sql1 =sql1.append("'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,") ;
				sql1 = sql1.append("'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and PRACTITIONER_ID='"+resource_id+"' ") ;
				sql1 = sql1.append("and eff_status='E') order by 2") ;
				stmt = con.createStatement() ;
				rs = stmt.executeQuery(sql1.toString()) ;
				//System.out.println("sql1.toString() AA:"+sql1.toString());
				sql1.setLength(0);
				if (rs != null)	{
					while (rs.next()){
					str1 = rs.getString( "day_of_week" ) ;
					str2 = rs.getString( "day_no" );

					if(str1.equals("Monday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("Tuesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("Wednesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("Thursday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("Friday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("Saturday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("Sunday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

					%>
					<script>
						var element = parent.frames[1].document.createElement('OPTION');
						element.text = "<%=str1%>";
						element.value= "<%=str2%>";
						parent.frames[1].document.forms[0].b_day.add(element);
						//parent.frames[1].document.forms[0].b_day.focus(); Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010
					</script>

					<%
					counter++;
				}
				if(counter>0)
					stmt.close();
				}
			//}
			if(counter==0){
				sql1.append("select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
				sql1 =sql1.append("(select '1' from op_clinic where " );
				sql1 =sql1.append("decode(a.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3, ");
				sql1 =sql1.append("'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' ");
				sql1 =sql1.append("and facility_id='"+fac_id+"' and clinic_code='"+p_clinic_code+"'and eff_status='E' ) order by 2 ");

				if (rs!=null) rs.close();
				//System.out.println("sql1.toString() 11:"+sql1.toString());
				rs = stmt.executeQuery(sql1.toString()) ;

				sql1.setLength(0);

				if (rs != null)	{
					while (rs.next()){
						str1 = rs.getString( "day_of_week" ) ;
						str2 = rs.getString( "day_no" );

						if(str1.equals("Monday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
									}else if(str1.equals("Tuesday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
									}else if(str1.equals("Wednesday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
									}else if(str1.equals("Thursday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
									}else if(str1.equals("Friday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
									}else if(str1.equals("Saturday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
									}else  if(str1.equals("Sunday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
									}

						%>
						<script>
							var element = parent.frames[1].document.createElement('OPTION');
							element.text = "<%=str1%>";
							element.value= "<%=str2%>";
							parent.frames[1].document.forms[0].b_day.add(element);
							//parent.frames[1].document.forms[0].b_day.focus(); Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010
						</script>

						<%
					}
					stmt.close();
				}
			}
    	}else{
			rs.close() ;

			sql1.append( "select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
			sql1=sql1.append("(select '1' from op_pract_for_clinic_vw where decode(a.day_no,'1',working_day_1," );
			sql1 =sql1.append("'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,") ;
			sql1 = sql1.append("'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and PRACTITIONER_ID='"+resource_id+"' ") ;
			sql1 = sql1.append("and eff_status='E') order by 2") ;
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql1.toString()) ;
			//System.out.println("sql1.toString() 22:"+sql1.toString());
			sql1.setLength(0);

			str1 = "" ;
			str2 = "" ;

			if (rs != null)	{
				while (rs.next()){
						str1 = rs.getString( "day_of_week" ) ;
					str2 = rs.getString( "day_no" );

					if(str1.equals("Monday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("Tuesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("Wednesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("Thursday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("Friday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("Saturday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("Sunday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

					%>
					<script>
						var element = parent.frames[1].document.createElement('OPTION');
							element.text = "<%=str1%>";
							element.value= "<%=str2%>";
							parent.frames[1].document.forms[0].b_day.add(element);
							//parent.frames[1].document.forms[0].b_day.focus();   Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010
					</script>

					<%
				}
		
			}

		}

		if(p_ident_at_checkin.equals("P")){%>
			<script>
			parent.frames[1].document.getElementById("imgpract").style.visibility = 'visible';
			//parent.frames[1].document.forms[0].b_day.disabled=true;
			</script>
		<%}else{%>
			<script>
			parent.frames[1].document.getElementById("imgpract").style.visibility = 'hidden';
			//parent.frames[1].document.forms[0].b_day.disabled=false;
			</script>
		<%}

	
	}else if(p_clinic_code.equals("*A")){%>
		<script>
			var opt = parent.frames[1].document.createElement('OPTION');
			parent.frames[1].document.forms[0].b_practitioner.add(opt);
			var opt = parent.frames[1].document.createElement('OPTION');
			parent.frames[1].document.forms[0].b_day.add(opt);
			var element = parent.frames[1].document.createElement('OPTION');
			var element1 = parent.frames[1].document.createElement('OPTION');
			element1.text = "*"+getLabel("Common.all.label","Common");
			element1.value= "*A";
			parent.frames[1].document.forms[0].b_day.add(element1);
		</script>
		<%

		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		stmt = con.createStatement() ;
		sql1.append("select a.practitioner_id,a.short_name from am_practitioner a, am_pract_for_facility  b where a.practitioner_id=b.practitioner_id  and b.facility_id ='"+fac_id+"' and a.eff_status='E' and b.eff_status = 'E' ");
		rs = stmt.executeQuery(sql1.toString()) ;
		sql1.setLength(0);
		String str1 = "";
		String str2 = "";

		if( rs != null ){
			while( rs.next() ){
				str1 = rs.getString( "short_name" ) ;
				str2 = rs.getString( "practitioner_id" );
				%>
				<script>
					var element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=str1%>";
					element.value= "<%=str2%>";
					parent.frames[1].document.forms[0].b_practitioner.add(element);
				</script>
				<%
			}
		}

		rs.close() ;
		sql1.append("select day_of_week,day_no from sm_day_of_week ") ;
		if (stmt!=null) stmt.close();
		stmt = con.createStatement() ;
		rs = stmt.executeQuery(sql1.toString()) ;
		sql1.setLength(0) ;
		str1 = "" ;
		str2 = "" ;

		if (rs != null){
			while (rs.next()){
				str1 = rs.getString( "day_of_week" ) ;
				str2 = rs.getString( "day_no" );

				if(str1.equals("MONDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("TUESDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("WEDNESDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("THURSDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("FRIDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("SATURDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("SUNDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

				%>
				<script>
					var element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=str1%>";
					element.value= "<%=str2%>";
					parent.frames[1].document.forms[0].b_day.add(element);
				</script>
				<%
			}
		}

	}
	%>  
	<script>
	dayObj=parent.frames[1].document.forms[0].b_day;
    parent.frames[1].document.forms[0].DaysForClinic.value='';
	var len=dayObj.options.length;
	for(i=2;i<len;i++) 
	parent.frames[1].document.forms[0].DaysForClinic.value+=dayObj.options[i].value+''+dayObj. options[i].text+'|'; 
	</script>

	<%
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

