<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.ChiefComplaintMaster.label" bundle="${ca_labels}"/></title>

<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../js/ChiefComplaintMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	PreparedStatement stmt1 = null;
	ResultSet rs1 = null;

	String SpecSql = "";
	String mode = "";
	String speciality_desc = "";
	

	String sql = "";
	String complaint_id ="";
	String complaint_desc ="";
	String complaint_text ="";
	String speciality_code1 ="";
	String eff_status ="";
	String enabled_checked = "";

	
	String disl = "";
	String id_disl = "";

	mode=request.getParameter("mode");
	
	if(mode=="insert" || mode.equals("insert") || mode == null) 
		{
			mode="insert";
			enabled_checked = "checked";
			
		}
		else
		{
			mode="modify";
		}	
	try
	{
		con	= ConnectionManager.getConnection();

			if(mode.equals("modify"))
			{
				id_disl = "readOnly";
				complaint_id = (request.getParameter("complaint_id")==null)?"":request.getParameter("complaint_id");
								
				sql = "select complaint_id,complaint_desc,complaint_text,speciality_code,eff_status  from ca_chief_complaint  where complaint_id = ?";
		
				stmt=con.prepareStatement(sql);
				stmt.setString(1,complaint_id);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
					
					while(rs.next())
					{

						complaint_desc = rs.getString("complaint_desc");
						if(complaint_desc==null || complaint_desc.equals("null"))
							complaint_desc="";
                       /*added by Archana on 3/10/2010 at 3:07 PM for IN019870*/
		                /*
			               If the description contain double quotes then it will replace with the string(&quot;).
		                */
                        complaint_desc = complaint_desc.replaceAll("\"","&quot;");

						complaint_text = rs.getString("complaint_text");
						if(complaint_text==null || complaint_text.equals("null"))
							complaint_text="";
					
						speciality_code1 = rs.getString("speciality_code");
						if(speciality_code1==null || speciality_code1.equals("null"))
							speciality_code1="";
			
						eff_status = rs.getString("eff_status");
						if(eff_status==null || eff_status.equals("null"))
							eff_status="";
						if(eff_status.equals("E"))
							enabled_checked="checked";
						else
						{
							enabled_checked="";
							
							disl = "readOnly";
						}
			

					}
					if(stmt!=null) stmt.close();
					if(rs!=null) rs.close();
				}


				if(!speciality_code1.equals(""))
				{
					SpecSql = "select  long_desc speciality_desc from am_speciality where speciality_code = ?";
					stmt1 = con.prepareStatement(SpecSql);
					stmt1.setString(1,speciality_code1);
				
					rs1 = stmt1.executeQuery();
				
					if(rs1.next())
					{
						speciality_desc = rs1.getString("speciality_desc");
						if(speciality_desc==null || speciality_desc.equals("null"))
							speciality_desc="";
					}

					if(stmt1!=null) stmt1.close();
					if(rs1!=null) rs1.close();
				}
			}
%>

</head>


<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">

<form name= 'ChiefComplaintMasterfrm' action="../../servlet/eCA.ChiefComplaintMasterServlet" method="post" target="messageFrame">

<table border=0 cellpadding=3 cellspacing=0 width='75%' align=center >
<br><br><br><br><br><br><br><br><br><br>
	
	<tr>
			<td class=label><fmt:message key="eCA.ComplaintID.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type='text' name='complaint_id' id='complaint_id' size='10' maxlength='6' onBlur='ChangeUpperCase(this)' onkeypress="return CheckForSpecChars(event)" value=<%=complaint_id%>  <%=id_disl%>><img src='../../eCommon/images/mandatory.gif'></td> 
	</tr>
	<tr>
			<td class=label><fmt:message key="eCA.ComplaintDescription.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type='text' name='complaint_desc' id='complaint_desc' size='50' maxlength='50'  OnKeyPress='return CheckForSpecialCharacter(this)' value="<%=complaint_desc%>" <%=disl%>><img src='../../eCommon/images/mandatory.gif'></td> 
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>	
		<td class='fields' colspan="2">
			  <input type='text' name='speciality_desc' id='speciality_desc' value="<%=speciality_desc%>" size="20" maxlength="20"  OnChange='resetValues();' onBlur='checkSpeciality(this);'><input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code1%>" size="4" maxlength="4" ><input type='button' name='specialty_desc_search' id='specialty_desc_search' value='?' class='button' onClick='resetValues();checkSpeciality(this);'>
		</td>
	</tr>
	<tr>
		<td class=label><fmt:message key="eCA.ComplaintText.label" bundle="${ca_labels}"/></td>
		<td class='fields'><textarea name='complaint_text' value="" rows=8 cols=43 value='' <%=disl%> onBlur="SPCheckMaxLen('Complaint Text',this,4000,'');return makeValidString(this);" onkeyPress='return checkMaxLimit(this,4000)'><%=complaint_text%></textarea><img src='../../eCommon/images/mandatory.gif'></td> 
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=enabled_checked%> <%=disl%>></td> 
	</tr>
</table>
<%
		
	}catch(Exception e)
			{
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
		          e.printStackTrace();//COMMON-ICN-0181
			}
	finally
			{
					
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>


<input type='hidden' name='mode' id='mode' value="<%=mode%>" ></input>
<input type='hidden' name='flag' id='flag' value="" ></input>
<input type='hidden' name='currentStatus' id='currentStatus' value="<%=eff_status%>" >


</form>
</body>

</html>

