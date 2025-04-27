<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
 

<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eMP/js/FileType.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String facilityid="";
	String facilityname="";
	String filetypecode="";
	String filetypelongdesc="";
	String filetypeshortdesc="";
	String eff_status="";
	String sourceid="";
	
	String outpat_value		 = "N";
	String inpat_value		 = "N";
	String dcarepat_value	 = "N";
	String emrpat_value		 = "N";

	String op_checkattribute = "";
	String ip_checkattribute = "";
	String em_checkattribute = "";
	String dc_checkattribute = "";

	String s="";
	String cs="";
	//String vval="";
	String rdonly="";
	String fnval="insert";
	String def="checked";

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	
	

	try
	{	
	    conn = ConnectionManager.getConnection(request);
	    
	    facilityid=request.getParameter("facility_id");
		filetypecode=request.getParameter("file_type_code");
		facilityname=request.getParameter("facility_name");

	    sourceid = request.getParameter("source");

	    if(filetypecode!=null && facilityid!=null)
	    {
	    	
			String mysql = "SELECT ic.facility_id, ic.facility_name facility_name, isc.file_type_code, isc.long_desc	file_type_long_desc, isc.short_desc	 file_type_short_desc, isc.eff_status eff_status,isc.appl_to_op,isc.appl_to_ip,isc.appl_to_em,isc.appl_to_dc FROM  sm_facility_param ic, mr_file_type isc WHERE  isc.facility_id = ic.facility_id AND isc.file_type_code=? AND isc.facility_id=? " ;
			pstmt = conn.prepareStatement(mysql);
			pstmt.setString(1,filetypecode); // Added by lakshmanan for security issue ID 174115558 on 14-08-2023
			pstmt.setString(2,facilityid); // Added by lakshmanan for security issue ID 174115558 on 14-08-2023
	    	rset=pstmt.executeQuery();
			
	    	if(rset != null)
	    	{
	    	   rdonly="readonly";
	    	   fnval="modify";
			   rset.next();
			   facilityname			= rset.getString("FACILITY_NAME");
			   filetypecode			= rset.getString("FILE_TYPE_CODE");
			   filetypelongdesc		= rset.getString("FILE_TYPE_LONG_DESC");
			   filetypeshortdesc	= rset.getString("FILE_TYPE_SHORT_DESC");
			   eff_status				=rset.getString("eff_status");

			   outpat_value			= rset.getString("appl_to_op");
			   inpat_value			= rset.getString("appl_to_ip");
			   dcarepat_value		= rset.getString("appl_to_dc");
			   emrpat_value			= rset.getString("appl_to_em");

			   if(eff_status.equals("D"))
				{
					s="readonly";
					cs = "disabled";
				}

			   if(outpat_value == null || outpat_value.equals("null"))
				   outpat_value = "";
				if(inpat_value == null || inpat_value.equals("null"))
				   inpat_value = "";
				if(dcarepat_value == null || dcarepat_value.equals("null"))
				   dcarepat_value = "";
				if(emrpat_value == null || emrpat_value.equals("null"))
				   emrpat_value = "";

				if(outpat_value.equals("Y"))
					op_checkattribute = "checked";
				else
					op_checkattribute = "";

				if(inpat_value.equals("Y"))
					ip_checkattribute = "checked";
				else
					ip_checkattribute = "";

				if(dcarepat_value.equals("Y"))
					dc_checkattribute = "checked";
				else
					dc_checkattribute = "";

				if(emrpat_value.equals("Y"))
					em_checkattribute = "checked";
				else
					em_checkattribute = "";
    		}
   	    }
	
	
	if(filetypecode==null)
		filetypecode="";

%>
</head>

	<body   onLoad="FocusFirstElement();" OnMouseDown="CodeArrest()" onKeyDown='lockKey();'>
	<form name='filetype_form' id='filetype_form' action='../../servlet/eMP.FileTypeServlet' method='post' target='messageFrame'>

	<div>
	<br><br>
	<table border='0' cellpadding='3' cellspacing='0' width='80%' align='center'>
	<tr>
<%
	      if(sourceid.equals("Insert"))
	      {
%>
		      <td   class="label" width="40%" ><!--width="40%" --><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			  <td class="fields" width="60%"><!-- width="60%" colspan="2"--><select name="facility_id" id="facility_id" >
		  	  <OPTION VALUE=''>------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------
<%
  			//con = (Connection) session.getValue( "connection" );
       	      stmt1 = conn.createStatement();
		      rset1 = stmt1.executeQuery( "Select facility_id,facility_name from sm_facility_param where status='E' order by upper(facility_name)");
		try
			{
			    if( rset1 != null )
					{
				         while( rset1.next() )
							{
							     String categorycode1 = rset1.getString( "facility_id" ) ;
							     String categorydesc1 = rset1.getString( "facility_name" ) ;


								if ( categorycode1.equals( facilityid ) )
									out.println( "<option value='" + categorycode1 + "' SELECTED > "+ categorydesc1);
								else
					 		        out.println( "<option value='" + categorycode1 + "' >" + categorydesc1 ) ;
							}
					}
			}
		catch(Exception e)
			{
				out.println("here");
			}

	     }

	     else
	     {
%>
			<td  class="label" ><!--width="40%"--><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields"><!--width="60%" colspan="2"-->
<%
			out.println("<input type='hidden' name='facility_id' id='facility_id' value='" + facilityid + "' >") ;
			out.println("<input type='text' name='facility_name' id='facility_name' value=\"" + facilityname + "\" size='45' maxlength='35' readonly>") ;
	 	 }
%>
   			</select>
   				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
   			</td>
   			</tr>
			<tr>
				
   	   			<td   class='label' ><!--width='40%'--><fmt:message key="Common.filetype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
    			<td   class="fields"><!-- width='60%' colspan='2'-->
    	   		<input type='text' onKeyPress="return CheckForSpecChars(event)"  name='file_type_code' id='file_type_code' value='<%=filetypecode%>' size='2'maxlength='2' onBlur=ChangeUpperCase(this); <%=rdonly%> ><img src='../../eCommon/images/mandatory.gif'align='center'></img> </td>
	    	   	
			</tr>
			<tr>
	    		<td   class='label'><!-- width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      	     	<td   class="fields"><!--width='60%' colspan='2'-->
             	<input type='text' name='file_type_long_desc' id='file_type_long_desc' value="<%=filetypelongdesc%>" size='30' onBlur="makeValidString(this)" maxlength='30' style='{ font-size: ;}'  <%out.print(s);%>><img src='../../eCommon/images/mandatory.gif' align='center'></td>
		    </tr>
			<tr>
				<td  class='label' ><!--width='40%'--><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td  class="fields"><!--width='60%' colspan="2"-->
      			<input type='text' name='file_type_short_desc' id='file_type_short_desc' value="<%=filetypeshortdesc%>"  onBlur="makeValidString(this)"  size='15' maxlength='15' <%out.print(s);%>><img src='../../eCommon/images/mandatory.gif'align='center'></td>
			</tr>
			<tr>
				<td  class='label'> <!--width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	    <%
	    	if(eff_status.equals("D"))
			{
				   def="";
			}
	    %>
	   		<input type='hidden' name='checked1' id='checked1'  value='<%=def%>'>
	     	<td  class="fields"><!-- width='60%' colspan='2'--><input type='checkbox'  name='eff_status' id='eff_status' value='E'  <%=def%> onclick='chkEnabled(this)'></td>
  	    <%
  	    	s="";
  	    %>
		  	</tr>
			<TR><Td colspan='2' class='columnheader'><fmt:message key="Common.ApplicablePatientClasses.label" bundle="${common_labels}"/></Td></TR>
			<TR>
				<TD class='label'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></TD>
				<TD class="fields" ><INPUT type='checkbox' name='outpatient_chk' id='outpatient_chk' value='<%=outpat_value%>'  onclick='chkUnchk(this)' <%=op_checkattribute%>  <%out.print(cs);%>></TD>
			</TR>
			<TR>
				<TD class='label' ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></TD>
				<TD class="fields"  ><INPUT type='checkbox' name='inpatient_chk' id='inpatient_chk' value='<%=inpat_value%>'  onclick='chkUnchk(this)' <%=ip_checkattribute%>  <%out.print(cs);%>></TD>
			</TR>
			<TR>
				<TD class='label' ><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></TD>
				<TD class="fields" ><INPUT type='checkbox' 
				name='daycare_chk' id='daycare_chk' value='<%=dcarepat_value%>'  onclick='chkUnchk(this)' <%=dc_checkattribute%>  <%out.print(cs);%> ></TD>
			</TR>
			<TR>
				<TD class='label'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></TD>
				<TD class="fields"  ><INPUT type='checkbox' 
				name='emergency_chk' id='emergency_chk' value='<%=emrpat_value%>'  onclick='chkUnchk(this)' <%=em_checkattribute%>  <%out.print(cs);%>></TD>
			</TR>
		</table>
		</div>

			<input type='hidden' name='function' id='function' value='<%=fnval%>'>
			
			<!--<input type='hidden' name='eff_date_from' id='eff_date_from' >  <input type='hidden' name='eff_date_to' id='eff_date_to' > -->
			<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
<%
		if(rset!=null) rset.close();
		if(rset1!=null) rset1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
}catch(Exception e)
		{
				//out.println(e);
				//out.println("catching here!!");
				e.printStackTrace(); // Added by lakshmanan for security issue ID 174128621 on 14-08-2023
		}

	finally
	{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>		
</form>
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

