<!DOCTYPE html>
<%--
	FileName	: addModifySubServiceinFacility.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eAM/js/Subserviceinfacility.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String servicecode="";
	String facilityid="";
	String deptcode="";
	String subservicecode="";
	String eff_status="";
	String sourceid="";
	String globalfacilityId="";
	String globaluser="";
	String fnval="insert";
	String def="checked";

	ResultSet rset=null;
	ResultSet rset1=null;
	Statement stmt  = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	globalfacilityId  =  (String) session.getValue( "facility_id" ) ;
	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=globalfacilityId; 

	Properties p=(Properties)session.getValue("jdbc");
	globaluser = (String)p.getProperty("login_user");

	try
	{
	   conn = ConnectionManager.getConnection(request);
	   stmt  = conn.createStatement();
	   facilityid=request.getParameter("facility_id");
	   servicecode=request.getParameter("service_code");
	   deptcode=request.getParameter("dept_code");
	   subservicecode=request.getParameter("subservice_code");

       sourceid = request.getParameter("source");

	    if(facilityid!=null && servicecode!=null)
	    {
			%>
	    	<html>
				<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>					
				</head>
				<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	    		<%
				//rset=stmt.executeQuery("select * from am_facility_subsrvc where operating_facility_id='"+facilityid+"'and service_code='"+servicecode+"' and subservice_code='"+subservicecode+"' and DEPT_CODE=nvl('"+deptcode+"','')  order by upper(service_code) ");
				String sqlStmt ="select * from am_facility_subsrvc where operating_facility_id=? and service_code=? and subservice_code=? and DEPT_CODE=nvl(?,'')  order by upper(service_code) ";
				
				pstmt   = conn.prepareStatement(sqlStmt);
				pstmt.setString	(	1,	facilityid		);
				pstmt.setString	(	2,	servicecode		);
				pstmt.setString	(	3,	subservicecode		);
				pstmt.setString	(	4,	deptcode		);

				rset		 = pstmt.executeQuery();
		
				if(rset != null)
				{
				   fnval="modify";
				   rset.next();
				   servicecode = rset.getString("service_code");
				   subservicecode = rset.getString("subservice_code");
				   eff_status=rset.getString("eff_status");
				}
    	  }
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

%>
</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  onLoad="FocusFirstElement();" >
	<form name='subserviceinfacility_form' id='subserviceinfacility_form' action='../../servlet/eAM.SubserviceinfacilityServlet' method='post' target='messageFrame'>

	<div>
	<br><br><br><br><br><br><br><br>
	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
      <tr>
       	<td width=10%>&nbsp</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width=10%>&nbsp</td>
	 </tr>
	<%
	      if(sourceid.equals("Insert"))
	      {
	 %>
	 		<tr>
	 	      <td>&nbsp;</td>
		      <td  class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		      <td class='fields'><select name="facility_id" id="facility_id"  onChange='PopulateList()'>
		      <OPTION VALUE=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
	<%
		     rset1 = stmt.executeQuery( "select facility_id,facility_name from sm_facility_for_user_vw where appl_user_id ='"+globaluser+"' and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >=TRUNC(SYSDATE) order by facility_name ");

		    if( rset1 != null )
		    {
			 while( rset1.next() )
			 {
			     String faccode1 = rset1.getString( "facility_id" ) ;
			     String facdesc1 = rset1.getString( "facility_name" ) ;

				if ( faccode1.equals( facilityId ) )
				     out.println( "<option value=\"" + faccode1 + "\" SELECTED > "+ facdesc1);
				else
				     out.println( "<option value=\"" + faccode1 + "\" >" + facdesc1 ) ;
			 }
		   }
	%>
		    </select><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
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
		      <td   class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		      <td class='fields'><select name="service_code" id="service_code" onChange='PopulateServiceList()' >
		      <OPTION VALUE=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
	<%

		    if( rset1 != null )
		    {
			 while( rset1.next() )
			 {
			     String servicecode1 = rset1.getString( "service_code" ) ;
			     String servicedesc1 = rset1.getString( "service_short_desc" ) ;

				if (servicecode1.equals(servicecode))
				     out.println( "<option value=\""+servicecode1+ "\" SELECTED > "+ servicedesc1);
				else
				     out.println( "<option value=\""+servicecode1+ "\" >" + servicedesc1 ) ;
			 }
		  }
%>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
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
		      <td   class="label"><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
		      <td class='fields'><select name="subservice_code" id="subservice_code" >
		      <OPTION VALUE=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		    </select><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
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
		      <td   class="label"><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
		      <td class='fields'><select name="dept_code" id="dept_code" onChange='PopulateDeptList()'>
		      <OPTION VALUE=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		      </select><img src='../../eCommon/images/mandatory.gif'align='center'></img></td><td>&nbsp;</td>		    </tr>
		    <tr>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    </tr>
  
			<tr>
		      <td>&nbsp;</td>
		      <td  class="label"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		      <td class='fields'><select name="section_code" id="section_code" >
		      <OPTION VALUE=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		      </select></td>
			  <td>&nbsp;</td>
		    </tr>
		    <tr>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    	<td>&nbsp;</td>
		    </tr>
<%
	      }
	      else
	      {
	      fnval="modify";

%>
		<tr>
		<td>&nbsp;</td>
		<td   class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<%
			if(rset1!=null)rset1.close();
			if(pstmt!=null)pstmt.close();
			//rset1 = stmt.executeQuery("Select * from  am_facility_subsrvc_vw where operating_facility_id ='"+facilityid+"' and service_code='"+servicecode+"' 	and subservice_code='"+subservicecode+"' 	and dept_code='"+deptcode+"' ");
			
			String sqlStmt1 ="Select * from  am_facility_subsrvc_vw where operating_facility_id =? and service_code=? 	and subservice_code=? 	and dept_code=?  ";
				
				pstmt   = conn.prepareStatement(sqlStmt1);
				pstmt.setString	(	1,	facilityid		);
				pstmt.setString	(	2,	servicecode		);
				pstmt.setString	(	3,	subservicecode		);
				pstmt.setString	(	4,	deptcode		);
				rset1		 = pstmt.executeQuery();

             if(rset1.next())
			{
				 %>
			  	<td  align='left'>
					<input type='hidden' name='facility_id' id='facility_id' value=<%=rset1.getString("operating_facility_id")%> >
					<input type='text' name='facility_name' id='facility_name' value="<%=rset1.getString("facility_name")%>" size='70'maxlength='35' readonly>
					<img src='../../eCommon/images/mandatory.gif'></img>
					<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
				<%
					 }
				%>
        <tr>
	        <td>&nbsp;</td>
			<td   class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type='hidden' name='service_code' id='service_code' value='<%=servicecode%>' >
				<input type='text' name='service_short_desc' id='service_short_desc' value="<%=rset1.getString("service_short_desc")%>" size='15'maxlength='15' readonly>
				<img src='../../eCommon/images/mandatory.gif'></img>
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
			<td   class="label"><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='hidden' name='subservice_code' id='subservice_code' value='<%=rset1.getString("subservice_code")%>'>
				<input type='text' name='subservice_short_desc' id='subservice_short_desc' value="<%=rset1.getString("subservice_short_desc")%>" size='15' maxlength='15' readonly>
				<img src='../../eCommon/images/mandatory.gif'></img>
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
			<td  class="label"><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
			<td  class='fields' >
					<input type='hidden' name='dept_code' id='dept_code' value="<%=rset1.getString("dept_code")%>">
					<input type='text' name='dept_short_desc' id='dept_short_desc' value="<%=rset1.getString("dept_short_desc")%>" size='15'maxlength='15' readonly>
					<img src='../../eCommon/images/mandatory.gif'></img>
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
			<td   class="label"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		<%			
			String section_short_desc = rset1.getString("section_short_desc");
			if(section_short_desc == null) section_short_desc="";
		%>
			<td class='fields' >
			<input type='hidden' name='section_code' id='section_code' value="<%=rset1.getString("section_code")%>">
			<input type='text' name='section_short_desc' id='section_short_desc' value="<%=section_short_desc%>" size='15'maxlength='15' readonly>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

<%	}
%>
		<tr>
			<td>&nbsp;</td>
			<td   class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<%
				if(eff_status.equals("D"))
			  {
				   def="";
			  }

	%>
			 <input type='hidden' name='checked1' id='checked1'  value='<%=def%>'>
			 <td><input type='checkbox' name='eff_status' id='eff_status' value='E'  <%=def%>></td>
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
		<%
			if(fnval.equals("insert")) 
			{ 
			%>
			<script>PopulateList();</script>
		<% 
			}
			%>
		<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{  
		try
		{
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			if(rset1!=null) rset1.close();
		}
		catch(Exception e)
		{}
		ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

