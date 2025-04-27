<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035912		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be 												changed and more appealing. Keeping the display of information more clear 												 and visible.   								 
06/08/2013		IN036733		Nijitha			Bru-HIMS-CRF-328
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script> 
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCA/js/AssignCAMenu.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement stmt1 = null;
	ResultSet rs1 = null;

	String patclssql="";
	String short_desc="";
	String patient_class="";

	PreparedStatement stmt2 = null;
	ResultSet rs2 = null;

	StringBuffer spcltysql= new StringBuffer();
	String pract_type="";
	String pract_type_desc=""; 

	PreparedStatement stmt3= null;
	ResultSet rs3= null;
	
	StringBuffer menusql= new StringBuffer();
	String menu_id="";
	String short_desc1="";

	String mode="";
	
	String patient_class_name="";
	String patient_class2="";
	String speciality_name="";
	String pract_type_name="";
	String pract_name="";
	String pract_type1="";
	String practitioner_id="";
	
	String menu_id1="";
	String disl="";
	
	//[IN035912] Starts
	String legendSummary = "";
	String legendNavigation="";
	//[IN035912] Ends
	StringBuffer query_menuid = new StringBuffer();
	PreparedStatement stmt4= null;
	ResultSet rs4= null;
	String fac_id = "";//IN036733
	

try
{
	con	= ConnectionManager.getConnection();
	
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");

	if(mode=="insert" || mode.equals("insert")){
		mode="insert";
		disl="enabled";
		legendSummary="Summary";//IN035912
		legendNavigation="Navigation";//IN035912
	}
	else{
		
		mode="modify";
		
		patient_class_name=request.getParameter("patient_class_name");
		patient_class2=request.getParameter("patient_class1");
		speciality_name=request.getParameter("speciality_name");
		pract_type_name=request.getParameter("pract_type_name");
		pract_name=request.getParameter("pract_name");
		pract_type1=request.getParameter("pract_type");
		practitioner_id=request.getParameter("practitioner_id");
		fac_id=request.getParameter("facility_id");//IN036733
		if(practitioner_id == null)
			practitioner_id="*ALL";
		//IN036733 Starts
		if(fac_id == null || fac_id == " ")
			fac_id ="*A";
		//IN036733	Ends
		if(query_menuid.length() > 0) query_menuid.delete(0,query_menuid.length());

		query_menuid.append("select menu_id,(select short_desc from ");
		query_menuid.append("ca_menu_header where root_menu_yn='Y' and "); query_menuid.append("eff_status ='E' and MENU_ID = a.menu_id )");
//		query_menuid.append(" as menu_desc from ca_app_custom_menu ");//[IN035912]
		//query_menuid.append(" as menu_desc ,LEGEND_FOR_SUMMARY,LEGEND_FOR_NAVIGATION from ca_app_custom_menu ");//[IN035912]//Commented for IN036733
		query_menuid.append(" as menu_desc ,LEGEND_FOR_SUMMARY,LEGEND_FOR_NAVIGATION ,a.FACILITY_ID,g.facility_name from ca_app_custom_menu ");//[IN035912]//IN036733
		//query_menuid.append("a where PRACTITIONER_ID = ? and");
		query_menuid.append("a, sm_facility_param g where PRACTITIONER_ID = ? and");//IN036733
		query_menuid.append(" PATIENT_CLASS = ? and PRACT_TYPE =? ");
		query_menuid.append(" AND a.FACILITY_ID = ? ");//IN036733

		stmt4 = con.prepareStatement(query_menuid.toString());
		stmt4.setString(1,practitioner_id);
		stmt4.setString(2,patient_class2);
		stmt4.setString(3,pract_type1);
		stmt4.setString(4,fac_id);//IN036733
		rs4 = stmt4.executeQuery();
		
		rs4.next();
		menu_id1 = rs4.getString(1);
		//[IN035912] Starts
		legendSummary = rs4.getString("LEGEND_FOR_SUMMARY");
		legendNavigation = rs4.getString("LEGEND_FOR_NAVIGATION");
		fac_id = rs4.getString("FACILITY_ID");//IN036733
		if(legendSummary==null || legendSummary.equals("null"))
			legendSummary="Summary";
		if(legendNavigation==null || legendNavigation.equals("null"))
			legendNavigation="Navigation";
		//[IN035912] Ends
		//menu_desc = rs4.getString(2);
		disl="disabled";
		}
%>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="Assign_menu_form" id="Assign_menu_form" action="../../servlet/eCA.AssignCAMenuServlet" method="post" target="messageFrame">
<input type=hidden name=menu_checkUpdate value=<%=menu_id1%> >
<br><br><br><br><br><br><br><br><br>
<table border='0' cellspacing='0' cellpadding='3' width='70%'  align='center'>
	<!-- IN036733 Starts-->
	<%
	ResultSet rsFacility = null;
	String facilityName = "";
	String facilityID = "";
	PreparedStatement psFacility = null;
	psFacility = con.prepareStatement("SELECT FACILITY_ID,FACILITY_NAME FROM SM_FACILITY_PARAM WHERE STATUS='E'");
	//psFacility.setString(1, resp_id);
	rsFacility = psFacility.executeQuery();
	%>
	<tr>
	<TD class='label' align="left"><fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></TD> <!--IN043509-->
	<TD>
	<select name="facilityName" id="facilityName" <%=disl%>>
	<option value="*A" selected >-----------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------------</option>
	<%
	while(rsFacility.next())
	{
		facilityName = rsFacility.getString("FACILITY_NAME");
		facilityID = rsFacility.getString("FACILITY_ID");
		if(fac_id.equals(facilityID))
		{	
		out.println("<option value='"+facilityID+"' selected>"+facilityName+"</option>");
		}
		else
		{
			out.println("<option value='"+facilityID+"'>"+facilityName+"</option>");
		}
	}
	%>
	</select>
	</TD>
	</tr>
	<!-- IN036733 Ends-->
	<tr>	
		<td class='label' align="left" ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class='fields' > 
	<%
	
		patclssql= "SELECT short_desc,patient_class FROM am_patient_class order by short_desc";
		stmt1	= con.prepareStatement(patclssql);
		rs1 = stmt1.executeQuery();
	%>
		<select name='patient_class1' id='patient_class1' <%=disl%>>
		<option value="*A" selected >-----------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------------</option>
	<%
			while(rs1.next())
			{
				short_desc = rs1.getString("short_desc");
				patient_class = rs1.getString("patient_class");
				if(short_desc == null)
					short_desc="";
				if(patient_class == null)
					patient_class="";
				if(patient_class_name.equals(short_desc)){
					out.println("<option value='"+patient_class+"' selected>"+short_desc+"</option>");
				}
				else
				{
					out.println("<option value='"+patient_class+"'>"+short_desc+"</option>");
				}
			}
	
	%>
				
			</select>		
		</td>
	</tr>
		
	
	
	<input type="hidden" name="speciality_code1" id="speciality_code1"  value='<%=mode.equals("modify")?speciality_name:"ALL"%>'></input>
	<input type='hidden' name='speciality_code2' id='speciality_code2' value="*ALL"></input>

		
	<tr>	
		<td class=label align="left" ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
		<td class='fields' >
<%	if(spcltysql.length() > 0) spcltysql.delete(0,spcltysql.length());
	spcltysql.append("select PRACT_TYPE, ");
	spcltysql.append("nvl(DESC_USERDEF, DESC_SYSDEF) pract_type_desc ");
	spcltysql.append("from am_pract_type where  EFF_STATUS ='E' ");
	spcltysql.append("order by 2");
		stmt2	= con.prepareStatement(spcltysql.toString());
		rs2 = stmt2.executeQuery();
%>
			
		<select name='pract_type' id='pract_type' <%=disl%>><option value="*A" selected >------------<fmt:message key="Common.all.label" bundle="${common_labels}"/>-------------</option>	
	
<%
		while(rs2.next())
		{
			pract_type = rs2.getString("pract_type");
			pract_type_desc = rs2.getString("pract_type_desc");
			
			if(pract_type == null)
				pract_type="";
			if(pract_type_desc == null)
				pract_type_desc="";

			/* In the below if construct, description comparison is changed for the option values, updated by Dinesh T on 12/23/2010 for Incident 25303 */
			if(pract_type1.equals(pract_type))
			{
			out.println("<option value='"+pract_type+"' selected>"+pract_type_desc+"</option>");
			}
			else
			{
			out.println("<option value='"+pract_type+"' >"+pract_type_desc+"</option>");
			}
		}
	
%>
	
			</select>
		</td>
	</tr>
	
		
	<tr>
		<td class='label' align="left"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="practitioner_id2" id="practitioner_id2" value='<%=mode.equals("modify")?pract_name:com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels") %>' maxlength='20' size='20' <%=disl%> onBlur='getPractitioners(this)' OnChange='resetValues();setValue()'></input><input type='hidden' name='practitioner_id1' id='practitioner_id1' value=<%=mode.equals("modify")?practitioner_id:"*ALL"%>></input><input type='button' name='prac_desc_search' id='prac_desc_search' value='?' class='button' onClick='resetValues();getPractitioners(this)' <%=disl%>></input></td>
	</tr>
	
	
	
	<tr>	
		<td class='label' align="left"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>
		<td class='fields'>

<%	if(menusql.length() > 0) menusql.delete(0,menusql.length());
	menusql.append("select menu_id,short_desc from ca_menu_header ");
	menusql.append("where root_menu_yn='Y' and  eff_status ='E' ");
	menusql.append("order by short_desc");
	stmt3	= con.prepareStatement(menusql.toString());
	rs3 = stmt3.executeQuery();
		
%>
		<select name='menu_id1' id='menu_id1' OnBlur='getvalue();'>
		<option value=" " >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------</option>
<%
		while(rs3.next())
		{
			menu_id = rs3.getString("menu_id");
			short_desc1 = rs3.getString("short_desc");
			if(menu_id == null) menu_id="";
			if(short_desc1 == null) short_desc1="";
			if(menu_id.equals(menu_id1))	
			{
				out.println("<option value='"+menu_id+"' selected>"+short_desc1+"</option>");
			}else
			{
				out.println("<option value='"+menu_id+"'>"+short_desc1+"</option>");
			}
		}
	
%>

		</select><img src="../../eCommon/images/mandatory.gif" align=middle></img>
			
		</td>
		<td><input type='button' name="Preview" id="Preview" class='fields' value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' Onclick="showPreview()"></input></td><!--36733-->
	</tr>
	<!-- [IN035912] Starts-->
	<tr>
		<td class='label' align="left"><fmt:message key="eCA.LegendForSummary.label" bundle="${ca_labels}"/></td>
		<td class='fields'><input type=text name='summary' id='summary' onpaste='return CheckForSpecCharsWithCopyPaste(this)' size="20" maxlength="30" value="<%=legendSummary %>" onKeyPress="return CheckForSpecCharsWithSpaceBlur(event)"  onBlur="func_assign()">
		</td>
	</tr>
	<tr>
		<td class='label' align="left"><fmt:message key="eCA.LegendForNavigation.label" bundle="${ca_labels}"/></td>
		<td class='fields'><input type=text name='navigation' id='navigation'  onpaste='return CheckForSpecCharsWithCopyPaste(this)' size="20" maxlength="30" value="<%=legendNavigation%>" onKeyPress="return CheckForSpecCharsWithSpaceBlur(event)" onBlur="func_assign()">
		</td>
	</tr>
<!-- [IN035912] Ends-->
  </table> 
</center>
	<input type=hidden name=mode value=<%=mode%> ></input>
	<input type=hidden name='patient_class2' id='patient_class2' value=<%=patient_class2%> ></input>
	<input type=hidden name='pract_type1' id='pract_type1' value=<%=pract_type1%> ></input>
	<input type=hidden name='menu_id_hddn' id='menu_id_hddn' value='<%=menu_id1%>' ></input>
	<input type=hidden name='legendSummary' id='legendSummary' value='<%=legendSummary%>' ></input><!-- [IN035950]  -->
	<input type=hidden name='legendNavigation' id='legendNavigation' value='<%=legendNavigation%>' ></input><!-- [IN035950] Starts-->
	<input type=hidden name='facility_id' id='facility_id' value='<%=fac_id%>' ></input><!-- [IN035950] Starts-->
	<input type=hidden name='facilityName' id='facilityName' value='<%=fac_id%>' ></input><!-- [IN035950] Starts-->
<%	
		if(rs1!=null) rs1.close();
		if(rs2!=null) rs2.close();
		if(rs3!=null) rs3.close();
		if(rs4!=null) rs4.close();
		if(rsFacility!=null) rsFacility.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if(stmt3!=null) stmt3.close();
		if(stmt4!=null) stmt4.close();
		if(psFacility!=null) psFacility.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception in try of AssignCAMenu.jsp:"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	
	%>
 <input type='hidden' name='flag' id='flag' value='true'>

</form>
</body>
</html>

