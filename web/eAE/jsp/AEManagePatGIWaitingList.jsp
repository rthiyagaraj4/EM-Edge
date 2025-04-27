<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
	<%
		Connection con		=  null;
		ResultSet rs 		= null;
		PreparedStatement pstmt = null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String locale			= (String)session.getAttribute("LOCALE");

        String	facilityId 	= (String) session.getValue( "facility_id" ) ;
		String clinic_code	= request.getParameter("clinic_code");
		clinic_code 		= (clinic_code == null)?"":clinic_code;
		String treatment    = request.getParameter("treatment_area_code");
		treatment 			= (treatment == null)?"":treatment;
		String practitioner = request.getParameter("practitioner_id");
		practitioner 		= (practitioner == null)?"":practitioner;
        String asstrntbays  = request.getParameter("asstrntbays");
		asstrntbays 		= (asstrntbays == null)?"":asstrntbays;
		String bayType      = request.getParameter("bayType");
		bayType 		    = (bayType == null)?"":bayType;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		//Starts		
		String isAppearAsTabEnable      = request.getParameter("isAppearAsTabEnable");
		String bed_bay_type      = request.getParameter("bed_bay_type");
		bed_bay_type 		    = (bed_bay_type == null)?"":bed_bay_type;	
		String selected_prop="false";		
		//Ends
		String shortDes		= "";
	    String bedcode 		= "";
		String called_from_ca      = request.getParameter("called_from_ca");
		called_from_ca 		    = (called_from_ca == null)?"":called_from_ca;
		String frame_name="";

	%>
	<html> 
<%
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<BODY class='Message' onKeyDown = 'lockKey()'>
	<%
	try{
	       con					= ConnectionManager.getConnection(request); 
	       String shortDesc		    = "";
	       String code 				= "";
		   int	  rowIndex			= 1;
		   String open_to_all_prac_for_clinic_yn="";

		   if (bayType.equals("Y")) {   
             if( (!clinic_code.equals("")) && (!treatment.equals("")) ) { 
			   StringBuffer sqlBuf1  = new StringBuffer();
			   
			   sqlBuf1.append(" SELECT DISTINCT BAY_TYPE_CODE, AE_GET_DESC.AE_BAY_TYPE(BAY_TYPE_CODE,'"+locale+"','2')  SHORT_DESC FROM AE_BED_FOR_TRMT_AREA WHERE FACILITY_ID = ?  and CLINIC_CODE=?  AND TREATMENT_AREA_CODE= ? and eff_status='E'  order by 2 ");

			   pstmt   = con.prepareStatement(sqlBuf1.toString());
			   pstmt.setString	(	1,	facilityId		);
			   pstmt.setString	(	2,	clinic_code		);
			   pstmt.setString	(	3,	treatment		);

			   rs		 = pstmt.executeQuery();
			  while(rs!=null && rs.next())
				 {	
					bedcode	   = rs.getString(1);
					shortDes  = rs.getString(2); 
					//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
					//Starts
					if(isAppearAsTabEnable.equals("true")) {
						if(bed_bay_type.equals(bedcode))
							{
							selected_prop ="true";							}
						else {
							selected_prop ="false";
							}	
						}
					//Ends					 
				 %>
					<script>
					  var opt		=top.content.frames[1].frames[0].document.createElement("OPTION");
					  opt.text	= "<%=shortDes%>";
					  opt.value	= "<%=bedcode%>";
					  opt.selected = <%=selected_prop%>; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
					  top.content.frames[1].frames[0].document.forms[0].bed_bay_type.add(opt);				
					</script>	  
				  <%	       
				 } //End of while		 
				 if(rs!=null) { rs.close(); rs = null; }   
				 if(pstmt!=null) { pstmt.close(); pstmt = null; }   
           }// End of If
	     }
		 else{	
			 if(called_from_ca.equals("Y")) {
				 frame_name = "top.content.frames[3].frames[1].frames[0]";
			 }
			 else{ 
				 frame_name = "top.content.frames[1].frames[0]";
			 }
		   StringBuffer sqlBuf  = new StringBuffer();
		   
		   sqlBuf.append("select TREATMENT_AREA_CODE, SHORT_DESC, open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and clinic_code= ?  and facility_id= ?   and eff_status='E'  order by 2");
		   pstmt   = con.prepareStatement(sqlBuf.toString());
		   pstmt.setString	(	1,	clinic_code		);
		   pstmt.setString	(	2,	facilityId		);

		   rs		 = pstmt.executeQuery();
	 	   while(rs!=null && rs.next())
			{		
				code	   = rs.getString("TREATMENT_AREA_CODE");
				shortDesc  = rs.getString("SHORT_DESC");
				open_to_all_prac_for_clinic_yn=rs.getString("open_to_all_prac_for_clinic_yn");
	%>
		<script>
		            var opt		=   <%=frame_name%>.document.createElement("OPTION");
			     	opt.text	= "<%=shortDesc%>";
			     	opt.value	= "<%=code%>";
					  if("<%=treatment%>"=="<%=code%>") 
						opt.selected = true;
					if("<%=asstrntbays%>"=="bays")
				    {
                       <%=frame_name%>.document.forms[0].treatment_area_code.add(opt);
				      <%=frame_name%>.openToAllPractForClnYN[<%=rowIndex%>]='<%=open_to_all_prac_for_clinic_yn %>'
				     }
			        else{
				    parent.frames[1].document.forms[0].treatment_area_code.add(opt);
					}
	//parent.frames[1].frames[0].openToAllPractForClnYN[<%=rowIndex%>]='<%=open_to_all_prac_for_clinic_yn %>';
		</script>	
	<%	       
		rowIndex++;
		} //End of while		 
	    if(rs!=null) { rs.close(); rs = null; }   
	    if(pstmt!=null) { pstmt.close(); pstmt = null; }  
		 }
	   }catch(Exception e)
       { e.toString();   }
	   finally {
				   ConnectionManager.returnConnection(con,request);  
			    }
	%>
	</body>    
	</html>	 

