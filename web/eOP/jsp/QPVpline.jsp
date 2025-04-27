<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
    String url1 = "../../eCommon/jsp/pline.jsp?" ;
    String url2 = "../../eOP/jsp/QPVimgtabs.jsp?" ;
    String blnk = request.getParameter("blnk") ;
    String facid = (String) session.getValue("facility_id");
    String patid=request.getParameter("patid");
    String mrnno=request.getParameter("mrnno");
    String enctid=request.getParameter("enctid");
    String dtfrm=request.getParameter("dtfrm");
    String dtto=request.getParameter("dtto");
    String serv=request.getParameter("serv");
    String loc=request.getParameter("loc");
    String pract=request.getParameter("pract");
	String episode_id=request.getParameter("episode_id");
    String valid_pat_id ="";
	PreparedStatement pstmt=null;
    ResultSet rset1=null;
    String sql1="";
    
    String openEpisode = request.getParameter("openEpisode");
    if(openEpisode == null) openEpisode="";
    
    String params1=""; 
    String source1="";
    String params2="";  
    String source2="";
    boolean valid=true;
    String e_msg ="";
    Connection conn1  = null;
	
try
{
	conn1  =  ConnectionManager.getConnection(request);

    if( patid.equals("") ) 
    {
        if(!mrnno.equals("")) 
        {
	   
	   sql1 =  "select patient_id from mr_pat_file_index where file_no=? and facility_id=? ";
	   
	   pstmt=conn1.prepareStatement(sql1);
		pstmt.setString(1,mrnno);
		pstmt.setString(2,facid);
		rset1=pstmt.executeQuery();

		   if(rset1 != null)
			{
                if(rset1.next())
				{
                    patid=rset1.getString("patient_id");
                }
				else
                {
                	valid=false;
                	e_msg="M";
                }
			 }

				if(pstmt != null) pstmt.close();
				if(rset1 != null) rset1.close();
		}
        else if (!enctid.equals("")) 
        {
            sql1 =  "select patient_id from pr_encounter where facility_id=? and encounter_id=? ";

			pstmt=conn1.prepareStatement(sql1);
			pstmt.setString(1,facid);
			pstmt.setString(2,enctid);
            rset1 = pstmt.executeQuery();

            if(rset1 != null) 
			{
                if(rset1.next())
				{
                    patid=rset1.getString("patient_id");
				}
                else
                {
                	valid=false;
                	e_msg="E";
                }
			}

				if(pstmt != null) pstmt.close();
				if(rset1 != null) rset1.close();
		 }
    }
    else
    {
         sql1 =  "select patient_id from mp_patient where patient_id=? ";

		 pstmt=conn1.prepareStatement(sql1);
		 pstmt.setString(1,patid);
         rset1 = pstmt.executeQuery();

		 if(rset1 != null) 
		{
         	if(rset1.next())
			{
              valid_pat_id=rset1.getString("patient_id");
			}
            if(valid_pat_id==null || valid_pat_id.equals(""))
			{
				valid=false;
				e_msg="P";
			}
		}
		 if(rset1 != null) rset1.close();
    }
    if(valid)
    {
		 params1="Patient_ID="+patid;
	     source1 = url1 + params1;
		 params2="blnk="+blnk+"&patid="+patid+"&mrnno="+mrnno+"&enctid="+enctid+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract+"&openEpisode="+openEpisode+"&episode_id="+episode_id;  
	     source2 = url2 + params2;
    }
    else
    {
	    out.print("<script>parent.frames[1].location.href='../../eCommon/html/blank.html'; ");
		if (e_msg.equals("P"))
		out.println("alert(getMessage('INVALID_PATIENT','MP'));");
		else if (e_msg.equals("M"))
		out.println("alert(getMessage('INVALID_MRN','OP'));");		
		out.print("</script>");         
	    source1 = "../../eCommon/html/blank.html";
	    source2 = "../../eCommon/html/blank.html";  
    }
  if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception:"+e);
}
finally
{
	 try{
      if(rset1 != null)	rset1.close();
      if(pstmt != null) pstmt.close();
	 }catch(Exception e){}
      if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}
%>

<iframe name='pline' id='pline' src=<%=source1%> frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
    <iframe name='tabs' id='tabs'  src=<%=source2%> frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>


</html>

