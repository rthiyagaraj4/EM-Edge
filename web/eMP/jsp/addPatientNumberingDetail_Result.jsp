<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<%
	Connection con =null;

	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	Statement stmt = null;
	ResultSet rs=null;
	ResultSet reset=null;
try{
	String facility_name="";
	String short_name="";
	String facility_id="";
	String mr_section_code="";
	String upd_ind="";
	String chkboxAttribute="";
	String mr_sec_code1="";

	String pat_ser_grp_code=request.getParameter("pat_ser_grp_code");	

	int i=0;

	
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumberingDetail.js' language='javascript'>
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' >
<form name="patnumdetail_form_result" id="patnumdetail_form_result"  >


<table border="1" cellpadding="0" cellspacing="0" width="90%" align='center'>

<tr>
		<th class='columnheader' colspan='3' align="left"><div  id='head1'  class='myClass' nowrap ><fmt:message key="Common.Associate.label" bundle="${common_labels}"/>&nbsp;
		<fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></div></th>
		
</tr>
<!-- <tr>
		<td colspan='3'>&nbsp;</td>	
</tr> -->

   <tr>
		<th class='columnheader' ><div  id='head2'  class='myClass' align="left" nowrap ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></div></th>
		<th class='columnheader' ><div  id='head3'  class='myClass' nowrap ><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></div></th>
		<th class='columnheader' ><div  id='head4'  class='myClass' nowrap ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></div></th>
	</tr>
<%

/*//String sql="Select PAT_SER_GRP_CODE, PAT_SER_GRP_DESC, FACILITY_ID, FACILITY_NAME, MR_SECTION_CODE, MR_SECTION_NAME, upd_ind from ( Select PAT_SER_GRP_CODE, PAT_SER_GRP_DESC, FACILITY_ID, FACILITY_NAME, MR_SECTION_CODE, MR_SECTION_NAME, 'Y' upd_ind from  MR_SEC_FOR_PAT_SER_GRP_VW WHERE PAT_SER_GRP_CODE='"+pat_ser_grp_code+"' UNION Select A.PAT_SER_GRP_CODE, A.SHORT_DESC PAT_SER_GRP_DESC, B.FACILITY_ID, B.FACILITY_NAME, C.MR_SECTION_CODE, C.SHORT_NAME MR_SECTION_NAME, 'N' upd_ind from  MP_PAT_SER_GRP A, SM_FACILITY_PARAM B, MR_SECTION C WHERE A.PAT_SER_GRP_CODE='99' AND C.MR_SECTION_TYPE='C' AND B.FACILITY_ID=C.FACILITY_ID AND (A.PAT_SER_GRP_CODE, B.FACILITY_ID, C.MR_SECTION_CODE) not in (Select PAT_SER_GRP_CODE, FACILITY_ID, MR_SECTION_CODE FROM MR_SEC_FOR_PAT_SER_GRP)) order by  upper (FACILITY_NAME)";*/

String sql="Select PAT_SER_GRP_CODE, PAT_SER_GRP_DESC, FACILITY_ID, FACILITY_NAME, MR_SECTION_CODE, MR_SECTION_NAME, upd_ind from ( Select PAT_SER_GRP_CODE, PAT_SER_GRP_DESC, FACILITY_ID,  FACILITY_NAME, MR_SECTION_CODE, MR_SECTION_NAME, 'Y' upd_ind from    MR_SEC_FOR_PAT_SER_GRP_VW WHERE PAT_SER_GRP_CODE=? UNION Select A.PAT_SER_GRP_CODE,    A.SHORT_DESC PAT_SER_GRP_DESC, B.FACILITY_ID, B.FACILITY_NAME,   '' MR_SECTION_CODE, '' MR_SECTION_NAME, 'N' upd_ind from  MP_PAT_SER_GRP A,      SM_FACILITY_PARAM B WHERE A.PAT_SER_GRP_CODE=? AND B.STATUS='E'  AND (A.PAT_SER_GRP_CODE, B.FACILITY_ID) not in (Select PAT_SER_GRP_CODE, FACILITY_ID FROM MR_SEC_FOR_PAT_SER_GRP)) order by  upper (FACILITY_NAME)";


	con = ConnectionManager.getConnection(request);
	pstmt1 = con.prepareStatement(sql);
	pstmt1.setString(1,pat_ser_grp_code ); // Added by lakshmanan for security issue ID 174301668 on 23-08-2023
	pstmt1.setString(2,pat_ser_grp_code );  // Added by lakshmanan for security issue ID 174301668 on 23-08-2023
	rs = pstmt1.executeQuery();
	while(rs.next())
	{	
		facility_name=rs.getString("FACILITY_NAME")==null ? "":rs.getString("FACILITY_NAME");
		short_name=rs.getString("MR_SECTION_NAME")==null ? "":rs.getString("MR_SECTION_NAME");
		facility_id=rs.getString("FACILITY_ID")==null ? "":rs.getString("FACILITY_ID");
		mr_section_code=rs.getString("MR_SECTION_CODE")==null ? "":rs.getString("MR_SECTION_CODE");
		upd_ind=rs.getString("upd_ind")==null ? "":rs.getString("upd_ind");


		if(upd_ind.equals("Y"))
				chkboxAttribute ="CHECKED";
			else
				chkboxAttribute="";


	String classValue = "" ;
		if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<tr> <td class='" + classValue + "'>");
	%>
	<input type='hidden' name='facility<%=i%>' id='facility<%=i%>' value='<%=facility_id%>'>
	<%

	out.println(facility_name +"</td><td class='" + classValue + "'>");

	if(chkboxAttribute.equals(""))
		{
	%>
	<!-- <input type='hidden' name='mr_section<%=i%>' id='mr_section<%=i%>' value='<%=mr_section_code%>'> -->

		
	<select name='mr_section<%=i%>' id='mr_section<%=i%>' >

	<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				<%
				try{
					pstmt = con.prepareStatement("select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) and facility_id='"+facility_id+"' order by short_name ");
						reset=pstmt.executeQuery();
						if( reset != null )
						{
						   while( reset.next() )
							{
								String mr_sec_code = reset.getString( "mr_section_code" ) ;
								String shortdesc=reset.getString("short_name");
								
								%><OPTION VALUE='<%= mr_sec_code%>' ><%= shortdesc%></option>
								<%
							}
							
						}
													
						if (reset != null) reset.close();
						if (pstmt != null) pstmt.close();
					}catch(Exception e) { 
						//out.println(e.toString());
						e.printStackTrace(); // Added by lakshmanan for security issue ID 174142264 on 23-08-2023
						}
					
			%>
				</select>


		</td>

	<% }else
		{
	

			pstmt = con.prepareStatement("select mr_section_code from MR_SEC_FOR_PAT_SER_GRP where facility_id=? and PAT_SER_GRP_CODE=?");
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pat_ser_grp_code);
			reset=pstmt.executeQuery();
						if( reset != null )
						{
						   while( reset.next() )
							{
								 mr_sec_code1 = reset.getString( "mr_section_code" ) ;
																								
							}
							
						}
													
						if (reset != null) reset.close();
						if (pstmt != null) pstmt.close();
			%>

			<select name='mr_section<%=i%>' id='mr_section<%=i%>' onchange="clearchk(<%=i%>);">

	<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				<%
				try{
			pstmt = con.prepareStatement("select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) and facility_id='"+facility_id+"' order by short_name ");
					
						reset=pstmt.executeQuery();
						if( reset != null )
						{
						   while( reset.next() )
							{
								String mr_sec_code = reset.getString( "mr_section_code" ) ;
								String shortdesc=reset.getString("short_name");

																
								if ( mr_sec_code.equals( mr_sec_code1 ) )
						out.println( "<option selected value='" + mr_sec_code + "' >" + shortdesc );
					else
						out.println( "<option  value='" + mr_sec_code + "' >" + shortdesc );
						
							}
							
						}
													
						if (reset != null) reset.close();
						if (pstmt != null) pstmt.close();
					}catch(Exception e) { 
						//out.println(e.toString());
						e.printStackTrace(); // Added by lakshmanan for security issue ID 174142265 on 23-08-2023
						}

					%>

					</select>
		</td>
		<%
		}


	//out.println(short_name +"</td>");
	out.println("<td class='" + classValue + "'>");

	%>
	<input type=checkbox name="select<%=i%>" id="select<%=i%>" onclick="result_value(this,<%=i%>);" value="<%=facility_id%>$<%=i%>" <%=chkboxAttribute%> >
	<input type=hidden name="db_action<%=i%>" id="db_action<%=i%>" >

	<%	
	out.println("</td></tr>");
	i++;
	}


%>

</table>

</form>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
	try
	{
	if (stmt != null) stmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		//out.println(exp.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174201477 on 23-08-2023
	}
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

