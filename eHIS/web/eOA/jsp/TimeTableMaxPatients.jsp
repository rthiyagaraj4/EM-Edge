<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*, java.util.*,webbeans.eCommon.*" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 	

<%

		Connection con = null;
		CallableStatement statement=null;
		CallableStatement statement1=null;
		CallableStatement statement2=null;
		CallableStatement statement3=null;
		String p_total_time		= "" ;
		

try
{	
	request.setCharacterEncoding("UTF-8");
con = ConnectionManager.getConnection(request);
Map hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
String calling_from		=(String) hash.get("calling_from");
if(calling_from == null) calling_from="";
if(calling_from.equals(""))//Added by S.Sathish for IN020308 on Thursday, April 01, 2010
{
	String p_max_pat_cat		= request.getParameter("maxpatcat") ;
	if(p_max_pat_cat ==null) p_max_pat_cat="";
	String p_start_time		= request.getParameter("starttime") ;
	if(p_start_time ==null) p_start_time="";
	String p_end_time		= request.getParameter("endtime") ;
	if(p_end_time == null) p_end_time="";	
	if (p_max_pat_cat.equals("1"))
	{

		String p_time_per_patient	= request.getParameter("timeperpatient") ;
		if(p_time_per_patient == null) p_time_per_patient="";
		String p_max_patients		= "" ;
		String p_time_per_pat		= "" ;		
		
		
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );
		statement.setString( 1,	p_start_time ) ;
		statement.setString( 2,	p_end_time ) ;
		statement.setString( 3,	p_time_per_patient );
		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;
		statement.execute() ;

		p_total_time	=	statement.getString(4) ;
		p_time_per_pat	=	statement.getString(5) ;
		p_max_patients	=	statement.getString(6) ;

		%>
		<script>
			
		var in_cl_sp_tm		= getMessage('INVALID_CLINIC_SPAN_TIME','OA');
		max_pat			= <%=p_max_patients%> ;
		total_time		= <%=p_total_time%> ;
		time_per_patient	= <%=p_time_per_pat%> ;

		if ( max_pat == 0 )
		{
			parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value = (total_time / time_per_patient) ;
			parent.frames[1].frames[0].document.forms[0].l_max_pat_per_day.value = parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value ;
		    parent.frames[1].frames[0].document.forms[0].b_max_slots_per_day.value = parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value ;
		    parent.frames[1].frames[0].document.forms[0].l_max_pat_per_slot.value = parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value ;
		}else{   
			alert(in_cl_sp_tm);
			if (parent.frames[1].frames[0].document.forms[0].fmode.value=='modify'){
				parent.frames[1].frames[0].document.forms[0].b_end_time.value='';
				parent.frames[1].frames[0].document.forms[0].b_end_time.focus();
			}else{
				parent.frames[1].frames[0].document.forms[0].b_time_per_patient.value='';
				parent.frames[1].frames[0].document.forms[0].b_time_per_patient.focus();
			}
		}
		</script>

		<%
	}else
	{ //end type 1
	
		String p_time_per_slab		= request.getParameter("timeperslab") ;
		if(p_time_per_slab ==null) p_time_per_slab="";
		String p_max_pat_per_slab	= request.getParameter("maxpatperslab") ;
		if(p_max_pat_per_slab ==null) p_max_pat_per_slab="";
		//String p_max_pat_val		= "";
		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";		
		

		statement1=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement1.setString( 1, p_start_time );
		statement1.setString( 2,	p_end_time ) ;
		statement1.setString( 3,	p_time_per_slab ) ;

		statement1.registerOutParameter(4,Types.VARCHAR ) ;
		statement1.registerOutParameter(5,Types.VARCHAR ) ;
		statement1.registerOutParameter(6,Types.VARCHAR ) ;

		statement1.execute() ;

		timeperslab	=	statement1.getString(4) ;
		modslab	=	statement1.getString(6) ;
		int m = Integer.parseInt(modslab);

		if(m == 0)
		{
			statement2=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );
			statement2.setString( 1, timeperslab );
			statement2.setString( 2,	p_max_pat_per_slab ) ;

			statement2.registerOutParameter(3,Types.VARCHAR ) ;
			statement2.execute() ;
			//p_max_pat_val	= statement2.getString(3);

	
			if ((!p_start_time.equals("")) && (!p_end_time.equals("")) && (!p_time_per_slab.equals("")))
			{

				statement3=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

				statement3.setString( 1,	p_start_time ) ;
				statement3.setString( 2,	p_end_time ) ;
				statement3.setString( 3,	p_time_per_slab );

				statement3.registerOutParameter(4,Types.VARCHAR ) ;
				statement3.registerOutParameter(5,Types.VARCHAR ) ;
				statement3.registerOutParameter(6,Types.VARCHAR ) ;

				statement3.execute() ;

				p_total_time	=	statement3.getString(4) ;
				p_time_per_slab	=	statement3.getString(5) ;
				p_no_of_slabs	=	statement3.getString(6) ;

				%>
				<script>

				no_of_slabs		= <%=p_no_of_slabs%> ;
				total_time		= <%=p_total_time%> ;
				time_per_slab		= <%=p_time_per_slab%> ;

				if ( no_of_slabs == 0 )
				{
					parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value = (total_time / time_per_slab) * parent.frames[1].frames[0].document.forms[0].b_max_patients_per_slab.value ;
					parent.frames[1].frames[0].document.forms[0].l_max_pat_per_day.value = parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.value ;
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
				}else{
					var sb_tm_valid	     = getMessage('SLAB_TIME_VALIDATION','OA') ;
					alert(sb_tm_valid) ;
					parent.frames[1].frames[0].document.forms[0].b_max_patients_per_day.focus();
					
				}

				</script>
		<%}
	}else{
			%><script>
			if (parent.frames[1].frames[0].document.forms[0].fmode.value=='insert'){
				
				parent.frames[1].frames[0].document.forms[0].b_time_per_slab.value='';
				
				parent.frames[1].frames[0].document.forms[0].b_time_per_slab.focus();
			}else if(parent.frames[1].frames[0].document.forms[0].fmode.value=='modify'){
				parent.frames[1].frames[0].document.forms[0].b_end_time.value='';
				
				parent.frames[1].frames[0].document.forms[0].b_end_time.focus();
			}
			parent.frames[1].frames[0].document.forms[0].b_max_patients_per_slab.value='';
			alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
			parent.frames[1].frames[0].document.forms[0].b_time_per_slab.focus();
			</script>
		<%
		}
	} // end else
	}
	else
	{//Else condition Added by S.Sathish for IN020308 on Thursday, April 01, 2010
		String maxpatcat		=(String) hash.get("maxpatcat");
		if(maxpatcat == null) maxpatcat="";		
		String starttime		=(String) hash.get("starttime");
		if(starttime == null) starttime="";		
		String endtime		=(String) hash.get("endtime");
		if(endtime == null) endtime="";		
		

		if (maxpatcat.equals("1"))
		{

		String timeperpatient		=(String) hash.get("timeperpatient");
		if(timeperpatient == null) timeperpatient="";		
		String p_max_patients		= "" ;
		String p_time_per_pat		= "" ;		
		
		
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );
		statement.setString( 1,	starttime ) ;
		statement.setString( 2,	endtime ) ;
		statement.setString( 3,	timeperpatient );
		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;
		statement.execute() ;

		p_total_time	=	statement.getString(4) ;
		p_time_per_pat	=	statement.getString(5) ;
		p_max_patients	=	statement.getString(6) ;

		%>		
			
		var in_cl_sp_tm		= getMessage("INVALID_CLINIC_SPAN_TIME","OA");
		max_pat			= <%=p_max_patients%> ;
		total_time		= <%=p_total_time%> ;
		time_per_patient	= <%=p_time_per_pat%> ;

		if ( max_pat == 0 )
		{
			frames[1].document.forms[0].result.value="0";
			frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_patient) ;
		    frames[1].document.forms[0].b_max_slots_per_day.value = frames[1].document.forms[0].max_patients_per_day.value ;
			frames[1].document.forms[0].l_max_pat_per_slot.value = frames[1].document.forms[0].max_patients_per_day.value ;
		}else{  
			frames[1].document.forms[0].result.value="1";
			alert(in_cl_sp_tm);			
			
		}
		

		<%
	}
		else
	{ 	
		String p_time_per_slab		=(String) hash.get("timeperslab") ;
		if(p_time_per_slab ==null) p_time_per_slab="";		
		String p_max_pat_per_slab	= (String) hash.get("maxpatperslab") ;
		if(p_max_pat_per_slab ==null) p_max_pat_per_slab="";			
		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";	
		

		statement1=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement1.setString( 1, starttime );
		statement1.setString( 2,	endtime ) ;
		statement1.setString( 3,	p_time_per_slab ) ;

		statement1.registerOutParameter(4,Types.VARCHAR ) ;
		statement1.registerOutParameter(5,Types.VARCHAR ) ;
		statement1.registerOutParameter(6,Types.VARCHAR ) ;

		statement1.execute() ;

		timeperslab	=	statement1.getString(4) ;
		modslab	=	statement1.getString(6) ;
		int m = Integer.parseInt(modslab);
		if(m == 0)
		{
			statement2=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );
			statement2.setString( 1, timeperslab );
			statement2.setString( 2,	p_max_pat_per_slab ) ;

			statement2.registerOutParameter(3,Types.VARCHAR ) ;
			statement2.execute() ;
			//p_max_pat_val	= statement2.getString(3);

	
			if ((!starttime.equals("")) && (!endtime.equals("")) && (!p_time_per_slab.equals("")))
			{

				statement3=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

				statement3.setString( 1,	starttime ) ;
				statement3.setString( 2,	endtime ) ;
				statement3.setString( 3,	p_time_per_slab );

				statement3.registerOutParameter(4,Types.VARCHAR ) ;
				statement3.registerOutParameter(5,Types.VARCHAR ) ;
				statement3.registerOutParameter(6,Types.VARCHAR ) ;

				statement3.execute() ;

				p_total_time	=	statement3.getString(4) ;
				p_time_per_slab	=	statement3.getString(5) ;
				p_no_of_slabs	=	statement3.getString(6) ;

				%>
				

				no_of_slabs		= <%=p_no_of_slabs%> ;
				total_time		= <%=p_total_time%> ;
				time_per_slab		= <%=p_time_per_slab%> ;

				if ( no_of_slabs == 0 ){
					frames[1].document.forms[0].result.value="0";
					frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_slab) * frames[1].document.forms[0].max_patients_per_slab.value ;
					frames[1].document.forms[0].max_other_visits.value=frames[1].document.forms[0].max_patients_per_day.value;
					frames[1].document.forms[0].max_first_visit.value="0";
				}else{
					frames[1].document.forms[0].result.value="1";
					var sb_tm_valid	     = getMessage('SLAB_TIME_VALIDATION','OA') ;
					alert(sb_tm_valid) ;					
				}

				
		<%}
	}else{
			%>		
			alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			frames[1].document.forms[0].result.value="1";
			
		<%
		}
	}
		
	}

	if(statement !=null) statement.close();
	if(statement1 !=null) statement1.close();
	if(statement2 !=null) statement2.close();
	if(statement3 !=null) statement3.close();
}
catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>


