<!DOCTYPE html>
<%--
	FileName	: addModifyBuildinginfacility.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/Buildinginfacility.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_name=request.getParameter("facility_name");
	if(facility_name == null) facility_name="";
	String operating_facility_id=request.getParameter("operating_facility_id");
	if(operating_facility_id == null) operating_facility_id="";
	Connection con = null;
	String rd1="";
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String bldngcode="";
	String longdes="";
	String shortdes="";
	String fnval="insert";
	String rd="";
	String en="";
	
	String chk="checked";
	String bgcode=request.getParameter("bldng_code");
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String fid=p.getProperty( "login_user" ) ;
	
	String facilityid = (String) session.getValue( "facility_id" ) ;

	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 

	try
	{
     con = ConnectionManager.getConnection(request);
	if(bgcode!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select * from am_bldng where bldng_code=? and operating_facility_id =?");
		pstmt.setString(1,bgcode);
		pstmt.setString(2,operating_facility_id);
		rset=pstmt.executeQuery();
		rset.next();
		bldngcode=rset.getString("bldng_code");
		longdes=rset.getString("long_desc");
		shortdes=rset.getString("short_desc");
		en=rset.getString("eff_status");
		if(fnval.equals("modify") && en.equals("D"))
			{
			chk="";
			rd="readonly";
			}
			else
			{
			chk="CHECKED";
			rd="";
			}

	}

%>
	</head>

	<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
		<form name='building_form' id='building_form' action='../../servlet/eAM.BuildinginfacilityServlet' method='post' target='messageFrame'>
				<BR><BR><BR><BR><BR><BR><BR><BR>

			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>

					<tr>
						<td width='10%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='10%'>&nbsp;</td>
					</tr>
					
					<tr>
						<td width='10%'>&nbsp;</td>
						<td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
						<td  class='fields'>&nbsp;&nbsp;
						<%
						if(fnval.equals("modify"))
						{
						out.println("<input type='text' readOnly name='facility_name' id='facility_name' value=\""+facility_name+"                            \" size='70'>");
						out.println("<input type='hidden' name='facility' id='facility' value='"+operating_facility_id+"'>");
						
						} else { 
						%>
						
						<select name='facility' id='facility'  >
						 <option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
    				       <%
    				    		String ID="",dat="";
    				    		if(rset!=null)rset.close();
								stmt=con.createStatement();
								String sql1 ="Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = ? and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ";
								pstmt   = con.prepareStatement(sql1);
							    pstmt.setString	(	1,	fid		);

							    rset		 = pstmt.executeQuery();
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("Operating_facility_id");
    				    			ID=rset.getString("facility_id");
    				    			if(ID.equals(facilityId))
    				    			  en="selected";
    				    			else
    				    			    en="";
    				    			out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");

    				    		   }
    				    		   }
    				    		   %>
    				    		   
						  </select>&nbsp;
						  <% } %> 
						  <img src='../../eCommon/images/mandatory.gif'align='center'>
					<td width='10%'>&nbsp;</td>
					</tr>

					<tr>
						<td width='10%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='10%'>&nbsp;</td>
					</tr>
					
    				<tr>
    					<td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><!--width='40%' -->
    				     <td  class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
    				     <%if(fnval.equals("modify"))
    				     { rd1="readonly";   }
    				     out.print("<input type='text'   onKeyPress='return CheckForSpecChars(event)'  name='bldng_code' id='bldng_code' SIZE='6' maxlength='6' "+ rd1+" onBlur=ChangeUpperCase(this);makeValidString(this)");
    				     %>
    				     value="<%=bldngcode%>" >
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

				    <tr>
					    <td>&nbsp;</td>
    				     <td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
    				     <td class='fields' >&nbsp;&nbsp;<!--width='60%'  colspan='2'-->
    				     <input type='text' name='long_desc' id='long_desc' SIZE='30' onBlur="makeValidString(this)"  maxlength='30' <%out.print(rd);%> value="<%=longdes%>">&nbsp<img src='../../eCommon/images/mandatory.gif'>
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
    				     <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
    				     <td class='fields' >&nbsp;&nbsp;<!--width='60%' colspan='2'-->
    				     <input type='text' name='short_desc' id='short_desc' <%out.print(rd);%> value="<%=shortdes%>" onBlur="makeValidString(this)"  SIZE='15' maxlength='15'>&nbsp<img src='../../eCommon/images/mandatory.gif'>
    				    </td>
    				    <td>&nbsp;</td>
				 </tr>

				 <tr>
				 		<td>&nbsp;</td>
				 		<td>&nbsp;</td>
				 		<td>&nbsp;</td>
				        <td>&nbsp;</td>
				</tr>
    				     <% }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
								  try
								  {
								  if(rset!=null)	rset.close();
								  if(stmt!=null)	stmt.close();
								  if(pstmt!=null)	pstmt.close();
								  }
								  catch(Exception e)
								  {}
    				    	
    				    	 ConnectionManager.returnConnection(con,request);
							  }%>

    				     </td>
    				</tr>

    				<tr>
    				<td>&nbsp;</td>
				    <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><!--width='40%' -->
				    <td class='fields' >&nbsp;<!--width='15%' colspan='2'-->
				    <input type='checkbox' name='eff_status' id='eff_status' value='E' <%out.print(chk);%>></td>
    				<td>&nbsp;</td>
    				</tr>


				<tr>
						<td>&nbsp;</td>
				 		<td>&nbsp;</td>
				 		<td>&nbsp;</td>
				        <td>&nbsp;</td>
				</tr>
  			</table>
		<!--/div-->
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>

		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>
</body>
</html>

