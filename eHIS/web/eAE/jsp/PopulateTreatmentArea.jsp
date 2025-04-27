<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%>
	<%
		Connection con		=  null;
		
		ResultSet rs 		= null;
		ResultSet rs1 		= null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
        String	facilityId 	= (String) session.getValue( "facility_id" ) ;
		String clinic_code	= request.getParameter("clinic_code");
		clinic_code 		= (clinic_code == null)?"":clinic_code;
		String treatment    = request.getParameter("treatment_area_code");
		treatment 			= (treatment == null)?"":treatment;
		String practitioner = request.getParameter("practitioner_id");
		practitioner 		= (practitioner == null)?"":practitioner;
        String asstrntbays = request.getParameter("asstrntbays");
		asstrntbays 		= (asstrntbays == null)?"":asstrntbays;
      
	%>
	<html>
	<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<BODY class='Message' onKeyDown = 'lockKey()'>
	<%
	try{
			con					= ConnectionManager.getConnection(request);
	       
	       String sql		= "";
	       String shortDesc = "";
	       String code 		= "";
		   if(asstrntbays.equals("bays"))
		{
	           		sql		= "select TREATMENT_AREA_CODE, SHORT_DESC from AE_TMT_AREA_FOR_CLINIC where facility_id=? and clinic_code=? and eff_status='E' order by 2";
		}
		else
		{
				sql		= "select TREATMENT_AREA_CODE, SHORT_DESC from AE_TMT_AREA_FOR_CLINIC where facility_id=? and clinic_code=? and OPEN_TO_ALL_PRAC_FOR_CLINIC_YN = 'N' and eff_status='E' order by 2";
		}
					
           // For Practitioner
		   String sql1		= "select PRACTITIONER_ID, PRACTITIONER_SHORT_NAME  from OP_PRACT_FOR_CLINIC_VW where facility_id= ? and clinic_code= ? and eff_status  = 'E' order by 2";

					pstmt   = con.prepareStatement(sql);
					pstmt.setString(1,facilityId) ;
					pstmt.setString(2,clinic_code) ;
					rs		 = pstmt.executeQuery();
	 	while(rs!=null && rs.next())
			{		
				code	   = rs.getString(1);
				shortDesc  = rs.getString(2);
				
	%>
		<script>
	//    var opt		= top.content.frames[1].frames[1].document.createElement("OPTION");
	    var opt		= top.content.frames[1].document.createElement("OPTION");
			     	opt.text	= "<%=shortDesc%>";
			     	opt.value	= "<%=code%>";
					  if("<%=treatment%>"=="<%=code%>") 
						opt.selected = true;
					if("<%=asstrntbays%>"=="bays")
				{
			     	parent.frames[1].frames[0].document.forms[0].treatment_area_code.add(opt);
				}
			else
				{
				parent.frames[1].document.forms[0].treatment_area_code.add(opt);
				}
	  	</script>	
	<%	       } //End of while		 
				 		 if(rs!=null) { rs.close(); rs = null; }   
 				         if(pstmt!=null) { pstmt.close(); pstmt = null; }   

     // For Populating the Practitioners
					
					pstmt1 = con.prepareStatement(sql1);
					pstmt1.setString(1,facilityId) ;
					pstmt1.setString(2,clinic_code) ;

	 	while(rs1!=null && rs1.next())
			{		
				
	%>
	<%	       } //End of while		 
				 	
						 if(rs1!=null) { rs1.close(); rs1 = null; }   
 				         if(pstmt1!=null) { pstmt1.close(); pstmt1 = null; } if(rs!=null) { rs.close(); rs = null; }   
 				      	 if(pstmt!=null) { pstmt.close(); pstmt = null; }  
						 

	   }   catch(Exception e)
     	    		{e.printStackTrace();}
		   
			finally {
			       
					   if(con != null)	 
				       ConnectionManager.returnConnection(con,request);  
			          }
		           	%>

	</body>    
	</html>	

