<!DOCTYPE html>
<!-- 
	Query Criteria Result for Entitlement Plan
	Created		: 2/10/2006 11:08 AM
	Modified		: 5/12/2006 11:07 AM  -- For "select" option in Applicable to
	Created By	: Vinod Babu MV
-->

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eMP/js/EntitlementPlan.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String patient_category  =  checkForNull(request.getParameter("patient_category"),"");
	String entitlement_by	 =  checkForNull(request.getParameter("entitlement_by"),"");
	String facility				 =  checkForNull(request.getParameter("facility"),"");
	String location_type		 =  checkForNull(request.getParameter("location_type"),"");
	String patient_class		 =  checkForNull(request.getParameter("patient_class"),"");
	//String ip_install_yn		 =  checkForNull(request.getParameter("ip_install_yn"),"N");
	//String op_install_yn		 =  checkForNull(request.getParameter("op_install_yn"),"N");
	String appl_entitle_desc = "";
	if (entitlement_by.equals("1"))
		   appl_entitle_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	else
	if (entitlement_by.equals("2"))
	{
		if (location_type.equals("C"))
				appl_entitle_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
		else
		if (location_type.equals("E"))
				appl_entitle_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		else
		if (location_type.equals("N"))
				appl_entitle_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); 
		else
		if (location_type.equals("Y"))
				appl_entitle_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels"); 
			//	appl_entitle_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels"); "Daycare Unit";
	}
	else
	if (entitlement_by.equals("3"))
		   appl_entitle_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");

	java.sql.Statement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	try
	{
	 con = ConnectionManager.getConnection(request);
	 String entitlement_criteria_code = "";
	// String entitlement_patient_class = "";
	 ArrayList codes = new ArrayList();
	 StringBuffer selSql = new StringBuffer("select  pat_cat_code,entitlement_criteria_code,entitlement_patient_class,entitlement_facility_id,entitlement_care_locn_ind  from mp_entitlement_criteria where pat_cat_code='"+patient_category+"' and entitlement_criteria='"+entitlement_by+"'");
	 if ( entitlement_by.equals("2") )
	 {
			   selSql.append(" and entitlement_facility_id='"+facility+"' and entitlement_care_locn_ind='"+location_type+"'");
	 }
	 else
	 if ( entitlement_by.equals("1") )
	 {
			   selSql.append(" and entitlement_patient_class='"+patient_class+"'");
	 }
	 stmt = con.createStatement();
	 rs = stmt.executeQuery(selSql.toString());
	 while ( (rs.next()) && (rs!=null))
	 {
		entitlement_criteria_code = checkForNull(rs.getString("entitlement_criteria_code"),"");
		codes.add(entitlement_criteria_code);
	 }
	 if ( rs != null ) rs.close();
	 if ( stmt != null ) stmt.close();
%>
<body onload='' onscroll='Scrollheader()' onKeyDown='lockKey()'>
<form name='entitlement_plan_result_form' id='entitlement_plan_result_form' method="post" action="../../servlet/eMP.EntitlementPlanServlet" target="messageFrame" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<div id="first_table" style="visibility:visible;backgroundColor:black;overflow:scroll">
<table name='ent_appl_tab' id='ent_appl_tab'  border=0 cellpadding=0 cellspacing=0 width='100%'>
		<tr><td class='COLUMNHEADER' colspan=3>&nbsp;<fmt:message key="eMP.EntitlementApplicability.label" bundle="${mp_labels}"/></td></tr>
<tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr>
		<tr>
			<td class='label' align='right' width='27%'>&nbsp;<fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='label' id='ent_by_desc' align='right' nowrap width='5%'><%=appl_entitle_desc%>&nbsp;</td>
			<td class='label'>&nbsp;&nbsp;
				<select name='appl_to_all' id='appl_to_all' onChange='chkAll(this)'>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value='Y' <%if (codes.contains("*ALL")){%>selected<%}%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
				<option value='N'><fmt:message key="Common.specific.label" bundle="${common_labels}"/></option>
				</select>
				<img  id='appl_to_all_img'  src='../images/mandatory.gif' > </img>
			</td>
		</tr>
<tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr><tr><td colspan='3'></td></tr>
</table>
</div>
<table id='result_tab1' width='100%' border=1 cellpadding=0 cellspacing=0 style='visibility:hidden'>
<%
	String classLabel = "";
	String check = "";
	//String check_all = "";
	String chk_val = "";
	int i=1;
	if (entitlement_by.equals("1"))
	{
%>
<tr>
	<td class='COLUMNHEADER' align='center' ><div  id='head1' class='myClass'><fmt:message key="eMP.SpecialityDesc.label" bundle="${mp_labels}"/></div></td>
	<td class='COLUMNHEADER' align='center' width='15%'><div  id='head2' class='myClass'><fmt:message key="Common.Include.label" bundle="${common_labels}"/><div></td>
</tr>
<tr>
	<td class='COLUMNHEADER' align='center' ></td>
	<td class='COLUMNHEADER' align='center' width='15%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='checkbox' value='N' name='selectAll' id='selectAll' onClick='selectAllFunc(this)'></td>
</tr>
<%
			String speciality_code ="";
			String short_desc ="";
			//String patient_class_desc ="";
			String sql = "";
			if (patient_class.equals("*ALL"))
			{
				sql = "select short_desc, speciality_code from am_speciality where eff_status='E' order by short_desc";
			}
			else
			{
				sql = "select a.short_desc, speciality_code from am_speciality a, am_patient_class b where eff_status='E' and patient_class != 'XT' and patient_class='"+patient_class+"' order by a.short_desc";
			}
			i = 0;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				if (i%2==0)
					classLabel = "QRYEVEN";
				else
					classLabel = "QRYODD";
				speciality_code = rs.getString("speciality_code");
				short_desc = rs.getString("short_desc");
				out.println("<tr>");
				out.println("<td class='"+classLabel+"' align='left'>"+short_desc+"<input type='hidden' name='splty_"+i+"' id='splty_"+i+"' value='"+speciality_code+"'></td>");
				if  (codes.contains(speciality_code))
				{
						check = "checked";
						chk_val = "Y";
				}
				else
				{
						check = "";
						chk_val = "N";
				}
				out.println("<td class='"+classLabel+"' align='center'><input type='checkbox' "+check+" name='Incl_sp_"+i+"' id='Incl_sp_"+i+"'value='"+chk_val+"' onClick='chkInclude(this)' ></td>");
				out.println("</tr>");
				++i;
			}
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}  /*End of if (entitlement_by=='1')*/
		else
		if (entitlement_by.equals("2"))
		{
			String location_desc = "";
			if (location_type.equals("C"))
					location_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			else
			if (location_type.equals("E"))
					location_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			else
			if (location_type.equals("N"))
					location_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			else
			if (location_type.equals("Y"))
					location_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		%>
		<tr>
		<%
			out.println("<td class='COLUMNHEADER' align='center'> <div  id='head1' class='myClass'> "+location_desc+" Description &nbsp;</div></td>");
		%>
			<td class='COLUMNHEADER' align='center' width='15%'> <div  id='head2' class='myClass'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class='COLUMNHEADER' align='center' ></td>
			<td class='COLUMNHEADER' align='center' width='15%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='checkbox' value='N' name='selectAll' id='selectAll' onClick='selectAllFunc(this)'></td>
		</tr>
		<%
			String short_desc ="";
			String clinic_code ="";
			classLabel="";
			i = 0;
			String sql ="";
			if ( (location_type.equals("C")) || (location_type.equals("E"))|| (location_type.equals("Y")))
			{
				 sql = "select clinic_code, long_desc short_desc from op_clinic where	eff_status='E' and clinic_type='"+location_type+"' and facility_id='"+facility+"' order by short_desc";
			}
			else
			if (location_type.equals("N")) 				
			{
				sql = "select nursing_unit_code, long_desc short_desc from ip_nursing_unit where	eff_status='E' and locn_type='"+location_type+"' and facility_id='"+facility+"' order by short_desc";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				if (i%2==0)
					classLabel = "QRYEVEN";
				else
					classLabel = "QRYODD";
				short_desc = rs.getString("short_desc");
				if ( (location_type.equals("C")) || (location_type.equals("E"))|| (location_type.equals("Y")))
				{
					clinic_code = rs.getString("clinic_code");
				}
				else
				if (location_type.equals("N")) 
				{
					clinic_code = rs.getString("nursing_unit_code");
				}
				out.println("<tr>");
				out.println("<td class='"+classLabel+"'  align='left'>"+short_desc+"<input type='hidden' name='lcn_"+i+"' id='lcn_"+i+"' value='"+clinic_code+"'>");
				if ( codes.contains(clinic_code) )
				{
						check = "checked";
						chk_val = "Y";
				}
				else
				{
						check = "";
						chk_val = "N";
				}
				out.println("<td class='"+classLabel+"' align='center'><input type='checkbox' "+check+" name='Incl_lc_"+i+"' id='Incl_lc_"+i+"'value='"+chk_val+"' onClick='chkInclude(this)' ></td>");
				out.println("</tr>");
				++i;
			}
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}  /*End of if (entitlement_by=='2')*/
		else
		if (entitlement_by.equals("3"))
		{
		%>
		<tr>
			<td class='COLUMNHEADER' align='center' > <div  id='head1' class='myClass'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></div></td>
			<td class='COLUMNHEADER' align='center' width='15%'><div  id='head2' class='myClass'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></div></td>
		</tr>
		<tr>
			<td class='COLUMNHEADER' align='center' ></td>
			<td class='COLUMNHEADER' align='center' width='15%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='checkbox' value='N' name='selectAll' id='selectAll' onClick='selectAllFunc(this)'></td>
		</tr>

		<tr>

		<%
			String short_desc ="";
			String bed_class_code ="";
			classLabel="";
			i = 0;
			stmt = con.createStatement();
			rs = stmt.executeQuery("select bed_class_code, short_desc from ip_bed_class  where eff_status='E' order by  short_desc");
			while(rs.next())
			{
				if (i%2==0)
					classLabel = "QRYEVEN";
				else
					classLabel = "QRYODD";
				short_desc = rs.getString("short_desc");
				bed_class_code = rs.getString("bed_class_code");
				out.println("<tr>");
				out.println("<td class='"+classLabel+"'  align='left'>"+short_desc+"<input type='hidden' name='bclass_"+i+"' id='bclass_"+i+"' value='"+bed_class_code+"'>");
				if ( codes.contains(bed_class_code) )
				{
						check = "checked";
						chk_val = "Y";
				}
				else
				{
						check = "";
						chk_val = "N";
				}
				out.println("<td class='"+classLabel+"' align='center'><input type='checkbox' "+check+" name='Incl_bclass_"+i+"' id='Incl_bclass_"+i+"'value='"+chk_val+"' onClick='chkInclude(this)' ></td>");
				out.println("</tr>");
				++i;
			}
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}  /*End of if (entitlement_by=='3')*/
		%>
</table>
<input type='hidden' name='pat_cat_code' id='pat_cat_code' value='<%=patient_category%>'>
<input type='hidden' name='entitlement_criteria' id='entitlement_criteria' value='<%=entitlement_by%>'>
<input type='hidden' name='entitlement_facility_id' id='entitlement_facility_id' value='<%=facility%>'>
<input type='hidden' name='entitlement_care_locn_ind' id='entitlement_care_locn_ind' value='<%=location_type%>'>
<input type='hidden' name='entitlement_patient_class' id='entitlement_patient_class' value='<%=patient_class%>'>
<input type='hidden' name='pat_class_val' id='pat_class_val' value='<%=patient_class%>'>
<input type='hidden' name='totalCount' id='totalCount' value='<%=i%>'>
</form>
</body>
<%
	out.println("<script>chkDBForAll();</script>");
	}
	catch(Exception e)
	{
		e.printStackTrace(System.out);
	}
	finally
	{
		if ( stmt != null ) stmt.close();
		if ( rs != null ) rs.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : 

inputString);
	}
%>


