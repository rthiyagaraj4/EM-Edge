<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><body class='MESSAGE' onMouseDown='CodeArrest();' onKeyDown ='lockKey();'></body>");

%>
<%
try{
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	PreparedStatement pstmt1   		=	null;
	ResultSet rs1					=	null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");

	StringBuffer query_treatment_area	=	new StringBuffer();
	String facility_id				=	"";
	String	treatment_area_gender	=	"";
	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	clinic_code				=	"",		pop_mode				=	"";
	StringBuffer query_practitioner		= new StringBuffer();		
	String open_to_all_pract_yn	=	"";
	String	practitioner_id			=	"",		practitioner_name		=	"";
	String	frame_name				=	"";
	String  called_from_ca			=	"";
	int countBed=0;

	String	open_to_all_prac_for_clinic_yn	=	"";

	int		arrIndex				=	1;
	try
	{
		
		facility_id		=	(String)		session.getValue("facility_id");

		clinic_code		=	request.getParameter("clinic_code")==null ? "" : request.getParameter("clinic_code");
		pop_mode		=	request.getParameter("pop_mode")==null ? "" : request.getParameter("pop_mode");
		frame_name		=	request.getParameter("frame_name")==null ? "" : request.getParameter("frame_name");
		called_from_ca		=request.getParameter("ca")==null ? "" : request.getParameter("ca"); 
		con				=	ConnectionManager.getConnection(request);
        
		if((pop_mode.equals("TreatmentArea")))
		{
			query_treatment_area.append(" select treatment_area_code, short_desc treatment_area_desc,gender treatment_area_gender, open_to_all_prac_for_clinic_yn from AE_TMT_AREA_FOR_CLINIC_LANG_VW where language_id='"+locale+"'  and  facility_id = ? and CLINIC_CODE = ? and eff_status = 'E' order by 2  ");
			pstmt		=	con.prepareStatement(query_treatment_area.toString());

			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	clinic_code		);
				
			rs			=	pstmt.executeQuery();
           
			while(rs.next())
			{
				treatment_area_code				=	rs.getString("treatment_area_code");
				treatment_area_desc				=	rs.getString("treatment_area_desc");
				treatment_area_gender			=	rs.getString("treatment_area_gender");
				open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");

				if(treatment_area_gender==null)				treatment_area_gender			=	"";
				if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
				if (called_from_ca.equals("Y")){%>

			    <script language='javascript'>
				  var opt		=	parent.frames[2].document.forms[0].createElement('OPTION'); 
				opt.text	=	"<%=treatment_area_desc%>";
				opt.value	=	"<%=treatment_area_code%>";
				parent.frames[2].document.forms[0].treatmentGender[<%=arrIndex%>] = '<%=treatment_area_gender%>';
				parent.frames[2].document.forms[0].openToAllPractForClnYN[<%=arrIndex%>] = '<%=open_to_all_prac_for_clinic_yn %>';
				parent.frames[2].document.forms[0].document.forms[0].treatment_area_code.add(opt); 
			   </script>
			 <%}else{%>
			 <script language='javascript'>
				var opt		=	<%=frame_name%>.document.createElement('OPTION'); 
				opt.text	=	"<%=treatment_area_desc%>";
				opt.value	=	"<%=treatment_area_code%>";
				<%=frame_name%>.treatmentGender[<%=arrIndex%>] = '<%=treatment_area_gender%>';
				<%=frame_name%>.openToAllPractForClnYN[<%=arrIndex%>] = '<%=open_to_all_prac_for_clinic_yn %>';
				
				<%=frame_name%>.document.forms[0].treatment_area_code.add(opt); 
			</script>
			<%
				}
				arrIndex++;
			} // end of while
			if (called_from_ca.equals("Y")){%>
			<script>
            		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			</script>
			<%}else{%>
			<script>
				     parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			</script>
			<%}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
		
		if(pop_mode.equals("Practitioner") || pop_mode.equals("TreatmentArea") )
		{
			open_to_all_pract_yn			=	(request.getParameter("open_to_all_pract_yn")==null)	?	""	:	request.getParameter("open_to_all_pract_yn");
			treatment_area_code				=	(request.getParameter("treatment_area_code")==null)		?	""	:	request.getParameter("treatment_area_code");
			open_to_all_prac_for_clinic_yn	=	(request.getParameter("open_to_all_prac_for_clinic_yn")==null)	?	""	:	request.getParameter("open_to_all_prac_for_clinic_yn");

			if(open_to_all_pract_yn.equals("Y"))
			{
				if(open_to_all_prac_for_clinic_yn.equals("Y"))
				{
					query_practitioner.append(" Select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from am_pract_for_facility where facility_id = ? and eff_status = 'E' order by 2");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id		);
				}
				else if(treatment_area_code.equals(""))
				{
					query_practitioner.append(" select distinct practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')  practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and eff_status = 'E' order by 2 ");
                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	clinic_code		);
				}
				else
				{
					query_practitioner.append(" select practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')   practitioner_name from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and treatment_area_code = ? and eff_status = 'E' order by 2");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
					pstmt.setString (	3,	treatment_area_code	);
				}
			}
			else
			{
				if(open_to_all_prac_for_clinic_yn.equals("Y"))
				{
					query_practitioner.append(" Select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_name from op_pract_for_clinic where facility_id = ? and clinic_code = ? and em_visit_type_appl_yn ='Y' and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
				}
				else if(treatment_area_code.equals(""))
				{
					query_practitioner.append(" select distinct practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')  practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
				}
				else
				{
					query_practitioner.append(" select practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and treatment_area_code = ?  and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
					pstmt.setString (	3,	treatment_area_code	);
				}
			}
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				practitioner_id		=	rs.getString("practitioner_id");
				practitioner_name	=	rs.getString("practitioner_name");
			%>
			<script language='javascript'>

//				var opt		=	<%=frame_name%>.document.createElement('OPTION'); 
//				opt.text	=	"<%=practitioner_name%>";
//				opt.value	=	"<%=practitioner_id%>";
				//<%=frame_name%>.document.forms[0].practitioner_id.add(opt); 
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



			<%
			} // end of while
            if(rs!=null)rs.close();
		    if(pstmt!=null) pstmt.close();
			try{
				if(!treatment_area_code.equals(""))
				{
				    String sqlTreat    = "select GENDER, OPEN_TO_ALL_PRAC_FOR_CLINIC_YN from AE_TMT_AREA_FOR_CLINIC where FACILITY_ID='"+facility_id+"' and CLINIC_CODE='"+clinic_code+"' and TREATMENT_AREA_CODE ='"+treatment_area_code+"'";
					pstmt1   = con.prepareStatement(sqlTreat);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								open_to_all_prac_for_clinic_yn=rs1.getString("OPEN_TO_ALL_PRAC_FOR_CLINIC_YN");
								treatment_area_gender=rs1.getString("GENDER");
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
					%>
					<script>
                        <%=frame_name%>.document.forms[0].open_to_all_prac_for_clinic_yn.value='<%=open_to_all_prac_for_clinic_yn%>';
					</script><%
				 }
			    }
			catch (Exception e)	{}
			finally
		   {	if(pstmt1!=null)pstmt1.close();
		        if(rs1!=null)rs1.close();
 		   }
		  try{
               if(!treatment_area_code.equals(""))
				 {
				    String sqlBed    = "select count(*) from ae_bed_for_trmt_area where FACILITY_ID=?  and  clinic_code=? and  TREATMENT_AREA_CODE=? and EFF_STATUS='E'";
					pstmt1   = con.prepareStatement(sqlBed);
                    pstmt1.setString(1,facility_id);
					pstmt1.setString(2,clinic_code);
                    pstmt1.setString(3,treatment_area_code);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								countBed=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
				   }

			     }
			catch (Exception e)	{}
			finally
		   {	if(pstmt1!=null)pstmt1.close();
		        if(rs1!=null)rs1.close();
 		   }
	  if(!treatment_area_code.equals(""))
	  {
		if (countBed > 0)
		{%>
		<script>
				<%=frame_name%>.document.getElementById("bed_mand").style.visibility='visible';
		        <%=frame_name%>.document.forms[0].bed_count.value='Y';
				//<%=frame_name%>.document.forms[0].ok.disabled=true;
		</script>
		<%}	else { %>
		<script>
				<%=frame_name%>.document.getElementById("bed_mand").style.visibility='hidden';
		        <%=frame_name%>.document.forms[0].bed_count.value='N';
				<%=frame_name%>.document.forms[0].ok.disabled=false;
		</script>
		<%} 
		 }
		} // end of else if(pop_mode.equals("Practitioner"))
	   
	
	query_treatment_area.setLength(0);
    query_practitioner.setLength(0);

	if(rs!=null)rs.close();
	if(pstmt!=null) pstmt.close();
	}	// end of try
	catch(Exception e)
	{
		e.printStackTrace();
    }
	finally
	{
		
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</html>

