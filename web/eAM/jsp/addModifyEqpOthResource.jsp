<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eAM/js/EquipmentOtherResource.js"  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function change() 
{ 
	if (EquipmentOtherResource_form.eff_status.checked == true)
		EquipmentOtherResource_form.eff_status.value="E";
    else
    	EquipmentOtherResource_form.eff_status.value="D";
}

function assignValue(obj) 
{ 
	if (obj.checked == true)
		EquipmentOtherResource_form.rd_appl_yn.value="Y";
    else
    	EquipmentOtherResource_form.rd_appl_yn.value="N";
}
function verifyMax(obj)
{
			
	if(obj.value.length > 300)
			{
				//alert("Resource Narration cannot exceed 300 characters");
				alert(getMessage("AM0162","AM"));
				obj.focus();
				obj.select();
			}
			else 
			makeValidString(obj);
}
</script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");

	Connection conn = ConnectionManager.getConnection(request);
	String mode = request.getParameter( "operation" );

	String faciId= request.getParameter("facId");
	String rsrce_class = request.getParameter("resource_class");
	String rsrceType = request.getParameter("resource_type");
		
	String resource_type_desc = request.getParameter("resource_type_desc");
	
	String rsrceId = request.getParameter("resource_id");
	
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String sql = "";

	String facId = "";
	String resource_class  = "";
	String resourceType = "";
	String resourceId = "";
	String rd_appl_yn = "N";
	String radApplChk  = "";
	String radApplDis  = "";
	String longDesc	 = "";
	String shortDesc	 = "";
	String reactEffStatus = "E";
	String chkEffStatus  = "checked";
	String bldngId = ""; 
	String florId = "";
	String personName = "";
	String telephoneNum = "";
	String resourceNarration = "";

	String rscrid_readonly="";
	String make_readonly = "";

	String fid="";
	String fname="";
	String bldngid="";
	String bldngname="";
	String flrid="";
	String flrname="";
	String sel="";
	String risOaIntegrate="N";
	
	try
	{
		stmt = conn.createStatement();
		String risOaSql="select 'Y' ris_oa_integrate from sm_function_control where functionality_id = 'RD_OA_INTEGRATE'";
	rs = stmt.executeQuery(risOaSql);
	if(rs!=null){		
		if(rs.next()){
			risOaIntegrate=rs.getString("ris_oa_integrate")==null?"N":rs.getString("ris_oa_integrate");				
		}
	}
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
		if(!(faciId==null && rsrce_class==null && rsrceType==null && rsrceId==null))
		{
			if(rsrce_class.equals("Equipment")) rsrce_class="E";
				else rsrce_class="O";

			sql = "Select * From am_resource where FACILITY_ID =?  AND RESOURCE_ID=? ";
			
			pstmt   = conn.prepareStatement(sql);
			pstmt.setString	(	1,	faciId		);
			pstmt.setString	(	2,	rsrceId		);
			rs		 = pstmt.executeQuery();
		
			if(rs.next())
			{
				facId = rs.getString("FACILITY_ID");
				resource_class	= rs.getString("RESOURCE_CLASS");	
				resourceType	= rs.getString("RESOURCE_TYPE");
				resourceId = rs.getString("RESOURCE_ID");
				rd_appl_yn=rs.getString("rd_appl_yn")==null?"N":rs.getString("rd_appl_yn");
				longDesc	= rs.getString("LONG_DESC");
				shortDesc	= rs.getString("SHORT_DESC");
				reactEffStatus	= rs.getString("EFF_STATUS");
				bldngId = rs.getString("BLDNG_CODE");

				florId = rs.getString("FLOOR_CODE");
				personName = rs.getString("CONTACT_PERSON");
				telephoneNum = rs.getString("CONTACT_TEL_NO");
				resourceNarration = rs.getString("RESOURCE_NARRATION");
			
			}			
			if(facId == null || facId.equals("null"))
				facId = "";
			if(resource_class == null || resource_class.equals("null"))
				resource_class = "";
			if(resource_class.equals("E")) resource_class="Equipment";
				else resource_class="Other";
			if(resourceType == null || resourceType.equals("null"))
				resourceType = "";
			if(resourceId == null || resourceId.equals("null"))
				resourceId = "";
			if(longDesc == null || longDesc.equals("null"))
				longDesc = "";
			if(shortDesc == null || shortDesc.equals("null"))
				shortDesc = "";
			if(reactEffStatus == null || reactEffStatus.equals("null"))
				reactEffStatus = "";
			
			if (reactEffStatus.equals("E"))
				chkEffStatus = "checked";
			else if (reactEffStatus.equals("D"))
			{
				chkEffStatus = "unchecked";
				make_readonly = "readonly"; 
			}
			if (rd_appl_yn.equals("Y")){
				radApplChk = "checked";
				radApplDis = "disabled";
			}else{
				radApplChk = "";
				radApplDis = "";
			}
			if(resource_class.equals("O")){
				radApplDis = "disabled";
			}

			if(bldngId == null || bldngId.equals("null"))
				bldngId = "";
			if(florId == null || florId.equals("null"))
				florId = "";
			if(personName == null || personName.equals("null"))
				personName = "";
			if(telephoneNum == null || telephoneNum.equals("null"))
				telephoneNum = "";
			if(resourceNarration == null || resourceNarration.equals("null"))
				resourceNarration = "";
        
			rscrid_readonly="readonly";
			mode = "modify";
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();

		}else		
		{
			resource_class  = "";
			resourceType = "";
			resourceId = "";
			longDesc	 = "";
			shortDesc	 = "";
			reactEffStatus = "E";
			chkEffStatus  = "checked";
			bldngId = ""; 
			florId = "";
			personName = "";
			telephoneNum = "";
			resourceNarration = "";

			mode = "insert";
		
		}

%>

<script>
var sStyle="<%=sStyle%>"
function fetchVals(form,current)
{ 
			func="<%=mode%>";					
			var name=current.name;
			var value=current.value;

			if(name=="facId")
			{
				if(func=="insert")
				{
					removeitems(form.bldng);
					removeitems(form.flor);

				}
			}
			if(name=="bldng")
			{   
				removeitems(form.flor);
			}
			if(name=="resource_class")
			{	
				removeitems(form.resource_type);
			}
			if(form.resource_class.value == "O"){
				
				if(document.getElementById("rd_appl_yn").checked)
					document.getElementById("rd_appl_yn").checked = false;
				document.getElementById("rd_appl_yn").disabled = true;
			}else{
				
				document.getElementById("rd_appl_yn").disabled = false;
			}
			if((func=="modify") &&(name=="bldng"))
			{ 
		
			document.getElementById("rd_appl_yn").disabled = true;
			}
			

			var facId=form.facId.value
			var resource_class=form.resource_class.value
			var bldng = form.bldng.value
			var HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY onKeyDown = 'lockKey()' CLASS='MESSAGE'>";
			HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/EquipmentOtherResourcePopulate.jsp'>";
			HTMLVal = HTMLVal +"<input name='name' id='name' type='hidden' value= '"+name + " '><input name='value' id='value' type='hidden' value='"+value + "'>";
			HTMLVal = HTMLVal +"<input name='facId' id='facId' type='hidden' value='"+facId + "'>";
			HTMLVal = HTMLVal +"<input name='resource_class' id='resource_class' type='hidden' value='"+resource_class+ "'>";
			HTMLVal = HTMLVal +"<input name='bldng' id='bldng' type='hidden' value='"+bldng+ "'>";
			HTMLVal = HTMLVal +"<input name='function' id='function' type='hidden' value='"+func+"'>";	
			HTMLVal = HTMLVal +"</form></BODY></HTML>";
			parent.messageFrame.document.write(HTMLVal);					
			parent.messageFrame.document.form1.submit();
			
}

/* 
	This function is used to remove the items occurred more than once
    in combo/select box.Simply it avoid repitations.
 */
function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}

}			

</script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement();">


	<form name='EquipmentOtherResource_form' id='EquipmentOtherResource_form' action='../../servlet/eAM.EquipmentOtherResourceServlet' method='post' target='messageFrame'>
		<div>
		
			<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
				<tr><td colspan='2' height=5></td></tr>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<%
							if(mode.equals("modify")){ 
						%>	
							<!-- This part of code is executed if it is called in update mode -->

							<input type="text" name='facId' id='facId' size='70' maxlength='35' value='<%=facId%>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
						<%
							}else{
							try
							{	
						%>
								<!-- This part of code is executed if it is called in insert mode -->
						 		<select name='facId' id='facId' onchange="fetchVals(this.form,this);" >  
								<option value='' > ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
									
						<%
                             if(rs!=null)rs.close();
						     if(stmt!=null) stmt.close();
						
						       sql = "select facility_name,facility_id from sm_facility_param order by facility_name";
							
								stmt = conn.createStatement();
								rs=stmt.executeQuery(sql);
								while(rs.next())
								{
									fid=rs.getString("facility_id");
									fname=rs.getString("facility_name");
									%>
										<option value='<%=fid%>' ><%=fname%>	
									<%
								}
						%>
								</option>
								</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>	
						<%
								if(rs!=null) rs.close();
								if(stmt!=null)	stmt.close();
								
							}catch(Exception e)
								{
									//out.println(e);
								}		
						}%>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<%
							if(mode.equals("modify")){ 
						%>	

							<input type="text" name='resource_class' id='resource_class' size='10' maxlength='10' value='<%=resource_class%>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
						<%
						}else{
						%>

				 		<select name='resource_class' id='resource_class' value='' onchange="fetchVals(this.form,this);">  
							<option value=""> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
							<option value="E"><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
							<option value="O"><fmt:message key="Common.other.label" bundle="${common_labels}"/>
							</option>
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
						<%}%>
						
					   </td>
					</tr>
				  
					<tr><td colspan='2'></td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<%
							if(mode.equals("modify")){ 
						%>	
							<!-- This part of code is executed if it is called in update mode -->

							<input type="text" name='resource_type' id='resource_type' size='20' maxlength='20' value='<%=resource_type_desc%>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
								<input type='hidden'  name='resource_type1' id='resource_type1' value='<%=resourceType%>'>
						<%
						}else{
							
						%>
								<!-- This part of code is executed if it is called in insert mode -->

						 		<select name='resource_type' id='resource_type' >  
								<option value=""> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
								</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						<%}%>		   
					</tr>
					<tr><td colspan='2'></td></tr>
					<tr>
					    <td class='label' width='30%'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
					    <input type='text' name='resource_id' id='resource_id' size='15' maxlength='15' value='<%=resourceId%>' <%=rscrid_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);' >&nbsp;
						<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'></td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur="makeValidString(this);" value="<%=longDesc%>" <%=make_readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'></td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortDesc%>" <%=make_readonly%> onBlur="makeValidString(this);" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'></td></tr>	
					<%if(risOaIntegrate.equals("Y")){%>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.ApplicableToRadiology.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='checkbox' name='rd_appl_yn' id='rd_appl_yn' value='<%=rd_appl_yn%>' <%=radApplChk%> <%=radApplDis%> onClick="assignValue(this)" disabled></td>
					</tr>
					<%}else{%>
								<input type="hidden" name="rd_appl_yn" id="rd_appl_yn" value="<%=rd_appl_yn%>">
						<%}%>
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='checkbox' name='eff_status' id='eff_status' value='<%=reactEffStatus%>' <%=chkEffStatus%> onClick="change()"></td>
					</tr>
					<tr><td colspan='2' height=5></td></tr>		
					<tr>
							<td  align='left' class ='CAGROUPHEADING' colspan='4'><b><fmt:message key="Common.LocationDetails.label" bundle="${common_labels}"/></b></td>
					</tr>

					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<%
								if(mode.equals("modify")){
								try
								{
									sql = "Select bldng_code,short_desc from am_bldng where operating_facility_id='"+facId+"' and eff_status='E' order by short_desc";
						
									stmt = conn.createStatement();
									rs=stmt.executeQuery(sql);									

									if (reactEffStatus.equals("D"))
									{
										while(rs.next())
										{
											bldngid = rs.getString("bldng_code");
											bldngname = rs.getString("short_desc");		
											
											if((bldngId.equals(bldngid))) break;
												else bldngname="";
										}
											
										out.println("<input type='textbox' size='' maxlength='' value='"+bldngname+"' readonly>");	
%>
										<input type="hidden" name="bldng" id="bldng" value="<%=bldngid%>">
<%
									}else{
										if(rs!=null)
										{
							%>		
											<select name='bldng' id='bldng' onchange='fetchVals(this.form,this);' >
											<option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
							<%		
											while(rs.next())
											{
												
												bldngid = rs.getString("bldng_code");
												bldngname = rs.getString("short_desc");	
												
												if(bldngId.equals(bldngid))
												{
													sel = "selected";
												
												}
												else
												{
													sel="";
													
												}
										
												out.println("<option value='"+bldngid+"' "+ sel   +">"+bldngname+"</option>");
											}
										  }
										}
									}catch(Exception e)
										{
										//	out.println(e);
										}
										finally
							            {
							            if(rs!=null)rs.close();
										if(stmt!=null)stmt.close();
										}
								}//modify ends
								else{
							%>
										<select name='bldng' id='bldng' onchange="fetchVals(this.form,this);" >  
										<option value="" >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
							<%}%>	
							</select></td>
					</tr>
					<tr><td colspan='2'></td></tr>	
					<tr>
						<td class='label' width='30%'><fmt:message key="Common.floor.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<%
							if(mode.equals("modify")) 		
							{
							try
							{
								sql = "Select floor_code,short_desc from am_bldng_floor where operating_facility_id='"+facId+"' and bldng_code='"+bldngId+"' and eff_status='E' order by short_desc";
				
								stmt = conn.createStatement();
								rs=stmt.executeQuery(sql);									
				
								if (reactEffStatus.equals("D"))
								{
									while(rs.next())
									{
										flrid = rs.getString("floor_code");
										flrname = rs.getString("short_desc");						
										if(florId.equals(flrid)) break;
											else flrname="";
									}
										
									out.println("<input type='textbox' size='' maxlength='' value='"+flrname+"' readonly>");	
%>
										<input type="hidden" name="flor" id="flor" value="<%=flrid%>">
<%

								}else{

									if(rs!=null)
									{
						%>
										<select name='flor' id='flor' >  
										<option value="" >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<%
										while(rs.next())
										{
											flrid = rs.getString("floor_code");
											flrname = rs.getString("short_desc");						
											if(florId.equals(flrid))
												sel = "selected";
											else
												sel = "";
									
											out.println("<option value='"+flrid+"' "+sel+">"+flrname+"</option>");
										}
									 }
								  }
								}catch(Exception e)
									{
										//out.println(e);
									}
							}else{
						%>		
									<select name='flor' id='flor' >  
									<option value="" >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<%}%>
						</select></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
							<td  align='left' class ='CAGROUPHEADING' colspan='4'><b><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></b></td>
					</tr>
					<tr><td colspan='2' height=5></td></tr>
					<tr>
						<td class='label' width='30%'><fmt:message key="eAM.PersonName.label" bundle="${am_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='person_name' id='person_name' size='30' maxlength='30' onBlur="makeValidString(this);" value="<%=personName%>" <%=make_readonly%>></td>
					</tr>
					<tr><td colspan='2'></td></tr>
					<tr>
						<td  class='label' width='30%'><fmt:message key="eAM.TelephoneNumber.label" bundle="${am_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='telephone_no' id='telephone_no' size='18' maxlength='18' onBlur="makeValidString(this);" value="<%=telephoneNum%>" <%=make_readonly%>></td>
					</tr>
					<tr><td colspan='2'></td></tr>
					<tr>
							
						<td  class='label' width='30%'><fmt:message key="eAM.ResourceNarration.label" bundle="${am_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						
						<TextArea  name='resource_narration' rows='5' cols='40' onBlur="verifyMax(this);" onClick="verifyMax(this);" <%=make_readonly%>
						><%=resourceNarration%></TextArea></td>
					</tr>
					<tr><td colspan='2' height=5></td></tr>
			</table>
		</div>

<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn,request);
	}
%>

		<input type='hidden' name='function' id='function' value='<%=mode%>'>
	</form>
</body>
</html>

