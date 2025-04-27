<!DOCTYPE html>
<%--
	FileName	: addModifyfloorinFacility.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/FloorinFacility.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <script>
  var sStyle='<%=sStyle%>';
 	function populateBuilding(Obj)
 	{  
		var n=document.getElementById('bldng_code').options.length;
		for(var i=0;i<n;i++)
		{
			document.getElementById('bldng_code').remove("bldng_code");
			
			var opt=document.createElement("OPTION");
			
					}

		
		if(Obj.value !='')
		{
				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAM/jsp/GetBuilding.jsp'> "+
						 " <input name='operating_facilityID' id='operating_facilityID' type='hidden' value='"+Obj.value+"'></form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.dum_form.submit();
		}
		else
		{
			var n=document.getElementById('bldng_code').options.length;
		for(var i=0;i<n;i++)
		{
			document.getElementById('bldng_code').remove("bldng_code");
			//var tp ="-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----";
			var opt=document.createElement("OPTION");
			
					}
		
		var tp ="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			var opt=document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			document.getElementById('bldng_code').add(opt);
		}

 	}
 
 </script>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	//	String facilityid=(String)session.getValue("facility_id");
		
		String facility_name=request.getParameter("facility_name");
			if(facility_name == null) facility_name="";
		String operating_facility_id=request.getParameter("operating_facility_id");
			
		String facility_id=(String)session.getValue("facility_id");
	
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	
	String floorcode="";
	String longdes="";
	String shortdes="";
	String en="";
	String fnval="insert";
	
	String stat="",stat1="";
	String chk="checked";
	String bldngdes="";
	ResultSet ret=null;
	String fac_id = request.getParameter("fac_id");
	String bldng=request.getParameter("bldng_code");
	String floor=request.getParameter("floor_code");
	Properties p=(Properties)session.getValue("jdbc");
	String userId=p.getProperty( "login_user" ) ;

	try
	{
     con = ConnectionManager.getConnection(request);

	if(floor!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("Select  A.short_desc, B.short_desc,B.long_desc,B.floor_code,B.bldng_code,B.EFF_STATUS  from am_bldng A,am_bldng_floor B where a.operating_facility_id = b.operating_facility_id and A.bldng_code=B.bldng_code and  a.operating_facility_id = ? and b.bldng_code=? and b.floor_code=? order by b.SHORT_DESC");
		pstmt.setString(1,fac_id);
		pstmt.setString(2,bldng);
		pstmt.setString(3,floor);
		rset=pstmt.executeQuery();
		rset.next();
		
		bldngdes=rset.getString(1);
		floorcode=rset.getString("floor_code");
		longdes=rset.getString("long_desc");
		shortdes=rset.getString(2);
		en=rset.getString("eff_status");

		if(fnval.equals("modify") && en.equals("D"))
			{chk="";stat1="READONLY";}
	}
	if(floor == null)
		floor="";
%>
	</head>

	<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
		<form name='floor_form' id='floor_form' action='../../servlet/eAM.FloorinFacilityServlet' method='post' target='messageFrame'>
			<div >
			<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			<BR>
			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>

			<tr>
				<td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
			     <td>&nbsp;</td>
			     <td width='10%'>&nbsp;</td>
      		</tr>
      		
					<tr>
						<td width='10%'>&nbsp;</td>
						<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
						<td  class='fields'>&nbsp;&nbsp;
						<%
						if(fnval.equals("modify"))
						{
						out.println("<input type='text' readOnly name='facility_name' id='facility_name' value=\""+facility_name+"\" size='70'>");
						out.println("<input type='hidden' name='facility' id='facility' value='"+operating_facility_id+"'>");

						} else { 
						%>

						<select name='facility' id='facility' onChange='populateBuilding(this)' >
						 <option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
				       <%
						String ID="";
						stmt=con.createStatement();
						rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+userId+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
						if(rset!=null)
						{
						   while(rset.next())
						   {
							dat=rset.getString("Operating_facility_id");
							ID=rset.getString("facility_id");
							if(ID.equals(facility_id))
							  en="selected";
							else
							    en="";
							out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");

						   }
						   }
						   %>

						  </select>&nbsp;
						  <% dat=""; } %> 
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
				 <td class='label'><fmt:message key="Common.building.label" bundle="${common_labels}"/></td><!--width='40%'-->
				 <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2' -->
				 
				 <%
					 if(fnval.equals("modify"))
				 {
					out.println("<input type='text' onBlur='makeValidString(this)' name='t' id='t' value=\""+bldngdes+"\" readonly>");
					out.println("<input type='hidden' name='bldng_code' id='bldng_code' value='"+bldng+"'>");
				 }
				 else{%>
				 <select name='bldng_code' id='bldng_code'>
				 <option >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						</select>
							<%
					}%>
				<img align='center'  src='../../eCommon/images/mandatory.gif'>
				</td>
				<td> &nbsp;</td>
			 </tr>

			<tr>
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
      		</tr>

    				<tr>
    					<td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.FloorCode.label" bundle="${common_labels}"/></td><!--width='40%' -->
    				     <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
    				     <%if(fnval.equals("modify"))
    				     { stat="readonly";   }
    				     out.print("<input type='text'  onKeyPress='return CheckForSpecChars(event)' name='floor_code' id='floor_code' SIZE='6' maxlength='6' value='"+floorcode+"' "+ stat+" onBlur=ChangeUpperCase(this)>");
    				     %>
    				    <img align='center'  src='../../eCommon/images/mandatory.gif'>
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
    				     <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
    				     <td class='fields' >&nbsp;&nbsp;<!--width='60%' colspan='2'-->
    				     <input type='text' onBlur='makeValidString(this)' name='long_desc' id='long_desc' SIZE='30' maxlength='30' value="<%=longdes%>" <%out.print(stat1);%>>&nbsp<img align='center'  src='../../eCommon/images/mandatory.gif'>
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
    				     <input type='text' name='short_desc' id='short_desc' onBlur='makeValidString(this)' value="<%=shortdes%>"  SIZE='15' maxlength='15' <%out.print(stat1);%>> <img align='center'  src='../../eCommon/images/mandatory.gif'>
	    				    </td>
						<td>&nbsp;</td>
				 </tr>

				    				     <% }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
								try
								{
    				    	  if(rset!=null)	rset.close();
    				    	  if(ret!=null)  ret.close();
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
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
    	</tr>

    				<tr>
    				 <td>&nbsp;</td>
				    <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><!-- width='40%' -->
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
		</div>
		<% if(fnval.equals("insert")) { %>
		<script>populateBuilding(document.forms[0].facility)</script>
		<% } %>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>

		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>
</body>
</html>

