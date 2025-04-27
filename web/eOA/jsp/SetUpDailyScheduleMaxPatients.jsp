<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.*" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 

<%
CallableStatement statement=null;
Connection con=null;
String p_total_time		= "" ;
String calling_from	= "";
String normal_yn	="";
String p_max_pat_cat="";
String p_start_time="";
String p_end_time="";
String p_time_per_patient="";
String p_time_per_slab	="";
String p_max_pat_per_slab ="";

try
{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	normal_yn		= request.getParameter("normal_yn") ;
	if(normal_yn ==null) normal_yn="";	
	if(!normal_yn.equals("Y"))  //If else condition Added by S.Sathish for IN020308 on Thursday, April 01, 2010
	{
		Map hash = (Map)obj.parseXMLString( request ) ;
		hash = (Map)hash.get("SEARCH") ;
		calling_from		=(String) hash.get("calling_from");
		if(calling_from == null || calling_from.equals("null")) calling_from="";		
		p_max_pat_cat		=(String) hash.get("maxpatcat");
		if(p_max_pat_cat == null) p_max_pat_cat="";		
		p_start_time		=(String) hash.get("starttime");
		if(p_start_time == null) p_start_time="";		
		p_end_time		=(String) hash.get("endtime");
		if(p_end_time == null) p_end_time="";		
		if(p_max_pat_cat.equals("1")){
					p_time_per_patient	= (String) hash.get("timeperpatient") ;
					if(p_time_per_patient == null) p_time_per_patient="";
		}else{
					p_time_per_slab	= (String) hash.get("timeperslab") ;
					if(p_time_per_slab == null) p_time_per_slab="";
					p_max_pat_per_slab	= (String) hash.get("maxpatperslab") ;
					if(p_max_pat_per_slab == null) p_max_pat_per_slab="";
				}
	}else{
		calling_from="";
	}


	if(calling_from.equals(""))
	{
		p_max_pat_cat		= request.getParameter("maxpatcat") ;
		if(p_max_pat_cat ==null) p_max_pat_cat="";
		p_start_time		= request.getParameter("starttime") ;
		if(p_start_time ==null) p_start_time="";
		p_end_time		= request.getParameter("endtime") ;
		if(p_end_time == null) p_end_time="";		
		if (p_max_pat_cat.equals("1"))
		{		
		
			p_time_per_patient	= request.getParameter("timeperpatient") ;
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
		var in_cl_sp_tm		= parent.frames[1].getMessage('INVALID_CLINIC_SPAN_TIME','OA');
		max_pat			= <%=p_max_patients%> ;
		total_time		= <%=p_total_time%> ;
		time_per_patient	= <%=p_time_per_pat%> ;
		if ( max_pat == 0 )
		{			
			parent.frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_patient) ;
		    parent.frames[1].document.forms[0].b_max_slots_per_day.value = parent.frames[1].document.forms[0].max_patients_per_day.value ;
			parent.frames[1].document.forms[0].l_max_pat_per_slot.value = parent.frames[1].document.forms[0].max_patients_per_day.value ;
			parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
		else
		{
			alert(in_cl_sp_tm);
			if(parent.frames[1].document.forms[0].function_mode.value!="modify")
				{
					parent.frames[1].document.forms[0].time_per_patient.focus();
				}
				else
				{
					parent.frames[1].document.forms[0].end_time.select();
					parent.frames[1].document.forms[0].end_time.focus();
				}
				parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
		}


		</script>

	<%
	if (statement!=null) statement.close();
	} //end type 1
	else
	{		
		p_time_per_slab		= request.getParameter("timeperslab") ;
		if(p_time_per_slab ==null) p_time_per_slab="";
		p_max_pat_per_slab	= request.getParameter("maxpatperslab") ;
		if(p_max_pat_per_slab ==null) p_max_pat_per_slab="";

		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";


		statement=null;
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement.setString( 1, p_start_time );
		statement.setString( 2,	p_end_time ) ;
		statement.setString( 3,	p_time_per_slab ) ;

		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;

		statement.execute() ;

		timeperslab	=	statement.getString(4) ;
		
		modslab	=	statement.getString(6) ;
		int m = Integer.parseInt(modslab);

		if (statement!=null) statement.close();		
		if(m == 0)
	{
		if(!(modslab == null)	)
		{
				statement=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );

				statement.setString( 1, timeperslab );
				statement.setString( 2,	p_max_pat_per_slab ) ;

				statement.registerOutParameter(3,Types.VARCHAR ) ;

				statement.execute() ;

				//p_max_pat_val	= statement.getString(3);
				
				if (statement!=null) statement.close();
			if ((!p_start_time.equals("")) && (!p_end_time.equals("")) && (!p_time_per_slab.equals("")))
			{

					statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

					statement.setString( 1,	p_start_time ) ;
					statement.setString( 2,	p_end_time ) ;
					statement.setString( 3,	p_time_per_slab );

					statement.registerOutParameter(4,Types.VARCHAR ) ;
					statement.registerOutParameter(5,Types.VARCHAR ) ;
					statement.registerOutParameter(6,Types.VARCHAR ) ;

					statement.execute() ;

					p_total_time	=	statement.getString(4) ;
					p_time_per_slab	=	statement.getString(5) ;
					p_no_of_slabs	=	statement.getString(6) ;

					%>
					<script>

					no_of_slabs		= <%=p_no_of_slabs%> ;
					total_time		= <%=p_total_time%> ;
					time_per_slab		= <%=p_time_per_slab%> ;		

					if ( no_of_slabs == 0 )
					{
						parent.frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_slab) * parent.frames[1].document.forms[0].max_patients_per_slab.value ;							//parent.frames[1].document.forms[0].max_other_visits.value=parent.frames[1].document.forms[0].max_patients_per_day.value;
						//parent.frames[1].document.forms[0].max_first_visit.value="0";
						
						parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';					
					}
					else
					{
						var stm_valid	     =  parent.frames[1].getMessage('SLAB_TIME_VALIDATION','OA') ;
						alert(stm_valid) ;
						parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
						parent.frames[1].document.forms[0].max_patients_per_day.focus();
					}

					</script>

					<%
			 }
	    }
	    else
		{
			%><script>
			parent.frames[1].document.forms[0].time_per_slab.value='';
			parent.frames[1].document.forms[0].max_patients_per_slab.value='';
			//alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';	
			parent.frames[1].document.forms[0].time_per_slab.focus();
			</script><%
		}


	}	else
		{
			%><script>
			parent.frames[1].document.forms[0].time_per_slab.value='';
			parent.frames[1].document.forms[0].max_patients_per_slab.value='';
			alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';	
			parent.frames[1].document.forms[0].time_per_slab.focus();
			</script><%
		}	
		
	}
if(statement !=null) statement.close();
}else{ //Else condition Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here
		

		if (p_max_pat_cat.equals("1"))
		{
			
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
		var in_cl_sp_tm		= getMessage('INVALID_CLINIC_SPAN_TIME','OA');
		max_pat			= <%=p_max_patients%> ;
		total_time		= <%=p_total_time%> ;
		time_per_patient	= <%=p_time_per_pat%> ;
		if ( max_pat == 0 )
		{
			frames[1].document.forms[0].result.value="0";
			frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_patient) ;
		    frames[1].document.forms[0].b_max_slots_per_day.value = frames[1].document.forms[0].max_patients_per_day.value ;
			frames[1].document.forms[0].l_max_pat_per_slot.value = frames[1].document.forms[0].max_patients_per_day.value ;
		}
		else
		{
			alert(in_cl_sp_tm);
			frames[1].document.forms[0].result.value="1";
			
		}


		<%
			if (statement!=null) statement.close();

		}
		else{			
		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";
		


		statement=null;
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement.setString( 1, p_start_time );
		statement.setString( 2,	p_end_time ) ;
		statement.setString( 3,	p_time_per_slab ) ;

		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;

		statement.execute() ;

		timeperslab	=	statement.getString(4) ;
		
		modslab	=	statement.getString(6) ;
		int m = Integer.parseInt(modslab);

		if (statement!=null) statement.close();
		if(m == 0)
		{
		if(!(modslab == null)	)
		{
				statement=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );

				statement.setString( 1, timeperslab );
				statement.setString( 2,	p_max_pat_per_slab ) ;

				statement.registerOutParameter(3,Types.VARCHAR ) ;

				statement.execute() ;

				//p_max_pat_val	= statement.getString(3);
				
				if (statement!=null) statement.close();
			if ((!p_start_time.equals("")) && (!p_end_time.equals("")) && (!p_time_per_slab.equals("")))
			{

					statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

					statement.setString( 1,	p_start_time ) ;
					statement.setString( 2,	p_end_time ) ;
					statement.setString( 3,	p_time_per_slab );

					statement.registerOutParameter(4,Types.VARCHAR ) ;
					statement.registerOutParameter(5,Types.VARCHAR ) ;
					statement.registerOutParameter(6,Types.VARCHAR ) ;

					statement.execute() ;

					p_total_time	=	statement.getString(4) ;
					p_time_per_slab	=	statement.getString(5) ;
					p_no_of_slabs	=	statement.getString(6) ;

					%>
					

					no_of_slabs		= <%=p_no_of_slabs%> ;
					total_time		= <%=p_total_time%> ;
					time_per_slab		= <%=p_time_per_slab%> ;

					if ( no_of_slabs == 0 ){
						frames[1].document.forms[0].result.value="0";
						frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_slab) * frames[1].document.forms[0].max_patients_per_slab.value ;	
						//frames[1].document.forms[0].max_other_visits.value=frames[1].document.forms[0].max_patients_per_day.value;
						//frames[1].document.forms[0].max_first_visit.value="0";
					}else{
						frames[1].document.forms[0].result.value="1";
						var stm_valid	     = getMessage('SLAB_TIME_VALIDATION','OA') ;
						alert(stm_valid) ;						
					}
			<%}
	    }else{
			%>
			parent.frames[1].document.forms[0].time_per_slab.value='';
			parent.frames[1].document.forms[0].max_patients_per_slab.value='';
			//alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			parent.frames[1].document.forms[0].time_per_slab.focus();
			<%
		}
	}else{
			%>			
			alert('APPOA0041 Location time span should be a multiple of Time per Patient/Slab');
			frames[1].document.forms[0].result.value="1";
			<%
		}	

		}

}//Ends here

if(statement !=null) statement.close();
}
catch(Exception e ){
//out.println(e.toString());
e.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
	
	}
%>


