<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,com.ehis.util.*" %>
 <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eAM/js/Practitioner.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
			
		
	


     <%
		 request.setCharacterEncoding("UTF-8");	
      		Connection conn = null; 
			Statement stmt =  null; 
			PreparedStatement pstmtf=null;
	        ResultSet rs =  null; 
	        ResultSet rsf =  null; 
      		//String reference="parent.frames[1].document.frames[1].document.forms[1]";
      		String reference=request.getParameter("reference");
			String locale = (String)session.getAttribute("LOCALE");
 		if(reference == null) reference="";
      		try
		{
		conn = ConnectionManager.getConnection(request);	
      	String date_of_birth="";
		String process_id =request.getParameter("process_id");
		String max_patient_age ="";
		if(process_id == null) process_id="0";
		int process=Integer.parseInt(process_id);

		stmt = conn.createStatement();        
        String  DAYS,MONTHS,AGE;
		try{

			String sql_maxage="select max_patient_age from  mp_param_lang_vw mp_param  WHERE  module_id = 'MP' AND language_id = '"+locale+"'";
			pstmtf=conn.prepareStatement(sql_maxage);
			rsf=pstmtf.executeQuery();
			if(rsf.next())
			{
		  		max_patient_age=rsf.getString("max_patient_age");
			}
			if(pstmtf != null) pstmtf.close();
		      if(rsf != null) rsf.close();

		    }catch(Exception e) {
		     out.println("errors="+e);
		     }

if(process == 1)
{
        String DOB=request.getParameter("date_of_birth");
		if(DOB == null) DOB = date_of_birth;

        String sql = "select calculate_age('"+DOB+"',1) from dual";
        rs = stmt.executeQuery(sql);
       rs.next();
       int AGE1 = rs.getInt(1);
	   if(rs!=null)rs.close();
	   if(stmt!=null) 	stmt.close();
       sql = "select calculate_age('"+DOB+"',2) from dual";
		stmt = conn.createStatement();  
        rs = stmt.executeQuery(sql);
        rs.next();
     int  MONTHS1 = rs.getInt(1);

        if(rs!=null)rs.close();
		sql = "select calculate_age('"+DOB+"',3) from dual";
        rs = stmt.executeQuery(sql);
        rs.next();
      int  DAYS1= rs.getInt(1);
	  
        String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>"+reference+".b_age.value='"+AGE1+"';"+reference+".b_months.value='"+MONTHS1 +"';"+reference+".b_days.value='"+DAYS1+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>"; 
		out.println(htmlVal);


		%>
<script>
		var maxAge = parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.max_pa_age.value;
		var actAge =parent.f_query_add_mod.OtherStaff_sub.document.getElementById('b_age').value;
		var actMonth =parent.f_query_add_mod.OtherStaff_sub.document.getElementById('b_months').value;
		var actDay =parent.f_query_add_mod.OtherStaff_sub.document.getElementById('b_days').value; 
		if (maxAge != '')
		{
			if (parseInt(actAge) > parseInt(maxAge))
			{
				var msg= getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+ getLabel("Common.Years.label","common");
				alert(msg);
				parent.f_query_add_mod.OtherStaff_sub.document.getElementById('b_age').focus();
			}
		}
		
		
		
		
		
		
	
</script>

		<%
	   if(rs!=null)rs.close();
		if(stmt!=null) 	stmt.close();
}
else
if(process == 2)
{
      
        DAYS = request.getParameter("b_days");
        MONTHS = request.getParameter("b_months");
        AGE = request.getParameter("b_age");

        if ( DAYS.equals("") )
            DAYS = "null";
        if ( MONTHS.equals("") )
            MONTHS = "null";
        if ( AGE.equals("") )
            AGE = "null";

        String htmlVal="";
        String DOB="";
		String date_of_birth_display="";
        String sql = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
		stmt = conn.createStatement();  
        rs = stmt.executeQuery(sql);
		if(rs !=null && rs.next())
	{
        DOB = rs.getString(1);
		date_of_birth_display=DateUtils.convertDate(DOB,"DMY","en",locale);
	}

        if ( DOB == "" || DOB == null )
            DOB = "";
      if ( AGE.equals("null") && MONTHS.equals("null")  && DAYS.equals("null"))
	   {
		htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>eval("+reference+").date_of_birth.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value=''</body></html>";  
		} else
		{
		htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>eval("+reference+").date_of_birth.value='"+date_of_birth_display+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";  
		}

	    out.println(htmlVal);
        date_of_birth = DOB ;
        
      
  }	       	
  	       	
  	       	}catch(Exception e){}
  	       	
		finally{
			if (rs != null)   rs.close();
			if (stmt != null) stmt.close();
			ConnectionManager.returnConnection(conn,request);
		}%>

