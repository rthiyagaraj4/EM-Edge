<!DOCTYPE html>
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String patient_id			= request.getParameter("patient_id");
	
	String mrn					= request.getParameter("mrn");

	String encounter_id			= request.getParameter("encounter_id");

	String	facilityId 			= (String) session.getValue( "facility_id" ) ;

	
	String url1 = "../../eCommon/jsp/pline.jsp?" ;
	String sql_query	=request.getParameter("sql_query");	
	
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

    String valid_pat_id ="";
    String sql1="";
    
    String params1="";
    String source1="";
   
	int p_rec_cnt=0;

    boolean valid=true;
    String e_msg ="";
	String e_msg1 ="";
try
{
        con  =  ConnectionManager.getConnection(request); 
        if(!mrn.equals("")) 
        {
	   
	   sql1 =  "select patient_id from mr_pat_file_index where file_no='"+mrn.trim()+"' and facility_id=?";
       stmt = con.prepareStatement(sql1);
	   stmt.setString(1,facilityId);
	   rs = stmt.executeQuery();
	    if(rs != null) 
			{
                if(rs.next() && rs!=null)
                    patient_id=rs.getString("patient_id");
                else
                {
                	valid=false;
                	e_msg="AE_INVALID_MRN";
                 
				}

			}
        }
		if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		 if (!encounter_id.equals("")) 
        {
            
            sql1 =  "select patient_id from op_patient_queue where facility_id=? and encounter_id=? and patient_class = 'EM'";
			stmt = con.prepareStatement(sql1);
			stmt.setString(1,facilityId);
			stmt.setString(2,encounter_id);
            rs = stmt.executeQuery();

            if(rs != null) 
                if(rs.next())
			{
                    patient_id=rs.getString("patient_id");
					
			}
                else
                {

                	valid=false;
					e_msg="AE_INVALID_ENCOUNTER_ID";
                }
                   
         }
	    if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		 if( !patient_id.equals("") ) 
    {
         
          sql1 =  "select patient_id from mp_patient where patient_id=?";
		 stmt = con.prepareStatement(sql1);
		 stmt.setString(1,patient_id);
         rs = stmt.executeQuery();

         if(rs != null) 
         	if(rs.next())
		{
                    valid_pat_id=rs.getString("patient_id");
		
		}
        if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

         if(valid_pat_id==null || valid_pat_id.equals(""))
         {

		valid=false;
		e_msg1="INVALID_PATIENT";
    	 }
    }
	    if(valid)
    {
		params1="Patient_ID="+patient_id;
	    source1 = url1 + params1;
    
		sql1 = "select count(*) as total from op_patient_queue where facility_id=?"+sql_query+" and patient_class = 'EM'" ;
        stmt = con.prepareStatement(sql1);
	
		stmt.setString(1,facilityId);
		
		rs = stmt.executeQuery();
 

		if (rs.next())
		{
			p_rec_cnt = rs.getInt("total");
		}
	    if (rs != null)	rs.close();
		if ( stmt != null)	 stmt.close();

		if (p_rec_cnt==0)
		{
			valid=false;
		}
		else
		{
			valid=true;
		}

    }
    else
    {
	    if(e_msg!="")
		{
		out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg+"','AE'));	 parent.frames[1].document.forms[0].mrn.value = ''; parent.frames[1].document.forms[0].search.disabled = false;</script>");         
	    source1 = "../../eCommon/html/blank.html";
		}
		else
		{
		out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg1+"','MP'));	 parent.frames[1].document.forms[0].search.disabled = false;</script>");         
	    source1 = "../../eCommon/html/blank.html";
		
		}
    }
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
      
      if(con!=null) 
	  ConnectionManager.returnConnection(con,request);
}

%>
<!-- Added/Modified By Nanda 10/21/2002 -->
<%
	if (valid)
	{
%>

<iframe name='mainFrame' id='mainFrame' src='<%=source1%>' frameborder=0 scrolling='no' noresize  style='height:9vh;width:100vw'></iframe><iframe name='AEPatientHistoryResultFrame' id='AEPatientHistoryResultFrame' src="../../eAE/jsp/AEResultPatientHistory.jsp?sql_query=<%=sql_query%>&patient_id=<%=patient_id%>" frameborder=0 scrolling='auto' noresize style='height:91vh;width:100vw'></iframe>
 
<%
	}
	else
	{
%>
	
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[1].document.AEQueryPatientHistoryForm.search.disabled=false;
		</script>
<%
	}
%>
</html>

