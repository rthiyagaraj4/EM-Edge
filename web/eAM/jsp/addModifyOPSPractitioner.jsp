<!DOCTYPE html>

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/OPSPractitioner.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String facility="";
	String pract="";
	String en="";
	String fnval="insert";
	String id="";
	//String fname="";
	String prname="";
	//String ps="";
	//SimpleDateFormat formatter=null;
	String fid=(String)session.getValue("facility_id") ;
	String spcode="";
	String spname="";

	facility=request.getParameter("practitioner_id");
	pract=request.getParameter("speciality_id");
	try
	{
		con = ConnectionManager.getConnection(request);

	if(facility!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select am_practitioner.practitioner_name,am_pract_specialities.practitioner_id,am_pract_specialities.speciality_code,am_speciality.short_desc from am_practitioner,am_pract_for_facility, am_pract_specialities,am_speciality where am_pract_specialities.practitioner_id=am_pract_for_facility.practitioner_id and am_practitioner.practitioner_id=am_pract_for_facility.practitioner_id and am_speciality.speciality_code=am_pract_specialities.speciality_code and am_pract_specialities.facility_id=am_pract_for_facility.facility_id and am_pract_specialities.speciality_code=? and am_pract_specialities.practitioner_id=?");

		pstmt.setString(1,pract);
		pstmt.setString(2,facility);
		rset=pstmt.executeQuery();
		if(rset.next())
		{
		pract=rset.getString("Practitioner_id");
		prname=rset.getString("practitioner_name");
		spcode=rset.getString("speciality_code");
		spname=rset.getString("short_desc");

		}
 	}
%>
	</head>

	<body  OnMouseDown="CodeArrest()" onLoad="Focusing('pract')" onKeyDown = 'lockKey()'>
		<form name='facility_form' id='facility_form' action='../../servlet/eAM.OPSPServlet' method='post' target='messageFrame'>
			<div>
			<br><br><br><br><br><br><br><br><br><br><br><br>

			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
				<tr>
					<td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
				</tr>
    				<tr>
    				     <td>&nbsp;</td>
    				     <td   class='label'><!--width='40%'--><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
    				     <td cc><!-- width='60%' colspan='2'-->&nbsp;&nbsp;
    				     <%if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value='"+prname+"' readonly>");
    				     	out.println("<input type='hidden' name='pract1' id='pract1' value='"+pract+"'>");
    				     }
    				     else{%>
    				     <select name='pract' id='pract'>
    				     <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

    				       <%
     				    		if(rset!=null)rset.close();
						        if(pstmt!=null)pstmt.close();
						   
						        stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select am_practitioner.practitioner_name,am_practitioner.practitioner_id from am_pract_for_facility, am_practitioner where  am_practitioner.practitioner_id =am_pract_for_facility.practitioner_id and am_pract_for_facility.facility_id='"+fid+"' and (trunc(sysdate) between nvl(trunc(am_pract_for_facility.eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(am_pract_for_facility.eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and am_practitioner.eff_status='E'  order by am_practitioner.practitioner_name") ;
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("practitioner_name");
    				    			id=rset.getString("practitioner_id");
    				    				out.println("<option value='"+id+ "' "+en +">"+dat);
    				    		   }
    				    		}%>
    				    	 </select>
    				    	 <%out.print("");}%><img src='../../eCommon/images/mandatory.gif'></img>
    				   </td>
    				   <td>&nbsp;</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
				     <td>&nbsp;</td>
    				     <td  class='label'><!--width='40%'--><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    				     <td class='fields'><!--width='60%' colspan='2'-->&nbsp;&nbsp;

    				      <%if(fnval.equals("modify"))
				        {
				       		out.println("<input type='text' name='p' id='p' value='"+spname+"' readonly>");
				       		out.println("<input type='hidden' name='splty_code1' id='splty_code1' value='"+spcode+"'>");
				        }
    				     else{%>
    				   	<select name='splty_code' id='splty_code'>
    				   	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

    				    	<%
    				    	  if(rset!=null)rset.close();
							   if(stmt!=null)stmt.close();

							    stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select short_desc,speciality_code from am_speciality where eff_status='E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString("short_desc");
    				    		   id=rset.getString("speciality_code");
    				    		   if(id.equals(pract))
    				    		   	en="selected";
    				    		    else
    				    			en="";

    				    		 out.println("<option value='"+id+ "' "+en+">"+dat);

    				    		   }
    				    		}
    				    	 	out.print("</select>");
    				    	 	}
    				    	 }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
    				    	  if(rset!=null)	rset.close();
							  if(stmt!=null)	stmt.close();
    				    	  if(pstmt!=null)	pstmt.close();
    				    	  
    				    	  	ConnectionManager.returnConnection(con,request);

    				    	  }%>
    				    	 <img src='../../eCommon/images/mandatory.gif'>
    				     </td>
    				     <td>&nbsp;</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

  			</table>
		</div>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>
</body>
</html>

