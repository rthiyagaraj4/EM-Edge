<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  <%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>

<script src="../../eAM/js/Referral.js" language="JavaScript"></script>

 
<% 
request.setCharacterEncoding("UTF-8");	
	String referral_code = request.getParameter("referral_code");

	Connection conn=null;
	ResultSet rset=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	java.sql.Statement stmt=null;
	PreparedStatement pstmt = null;

	java.sql.Statement stmt1=null;
	java.sql.Statement stmt2=null;
	ResultSet rs_hel=null;
	ResultSet ref_rs=null;
	java.sql.Statement ref_stmt=null;
	java.sql.Statement stmt_hel=null;

	java.sql.Statement stmt4=null;
	java.sql.Statement stmt5=null;
	java.sql.Statement stmt6=null;
	
	
	conn = ConnectionManager.getConnection(request);
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String[] contact_col_names				= null ;
	String[] contact_prompts				= null ;
	String[] contact_fields					= null ;
	ArrayList contact_addr                  = null; 

	int tindex=0;
	
	Boolean increasedaddressLength=false; //Added for ML-MMOH-CRF-0860.2
	
	try{
		contact_addr = fetchContactAddresses(conn, out, "parent.messageFrame",p) ;
		
		//Below line added for ML-MMOH-CRF-0860.2
        increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		
		}catch(Exception e)
		{
			out.println("Exception in FetchContactAddress Function="+e);
			e.printStackTrace();
		}
		contact_col_names = (String[])contact_addr.get(1) ;
		contact_prompts   = (String[])contact_addr.get(2) ; 
		contact_fields    = (String[])contact_addr.get(3) ;
		contact_addr = null;
		

	%>
	<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eAM/js/Referral.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--<script>
    window.onload == function a(){
		alert("inside function");
		document.getElementById('ch').className='IPCAHIGHERLEVELCOLOR';
		document.getElementById('Character_tab').style.display='';
		document.getElementById('address_tab').style.display='none';
		document.getElementById('Character_tab').style.position='relative';
		document.referral_form.applicability1.style.visibility='visible';
        document.referral_form.associated_ref_facility.style.visibility='visible';
		document.referral_form.patient_no.style.visibility='visible';
		document.referral_form.applicability2.style.visibility='visible';
		document.referral_form.donor_prefix.style.visibility='visible';
		document.referral_form.donor_no.style.visibility='visible';
	}
</script>-->






	</head>
	<body onLoad = "FocusFirstElement(); tab_click('ch')" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

	<%
	try
	{
	
		stmt     =  conn.createStatement();
		stmt1    =  conn.createStatement();
		stmt2    =  conn.createStatement();
		stmt_hel = conn.createStatement();

		stmt4    =  conn.createStatement();
		stmt5    =  conn.createStatement();
		stmt6 = conn.createStatement();

 		 String selected_facility="";
	String postal_desc="";

		String Resi_Area_Desc="";
		String Resi_Region_Desc="";
		String Resi_Town_Desc="";
		
		//String sql="select * from am_referral where referral_code='"+referral_code+"'";
		//rset = stmt.executeQuery(sql);
		
		String sql="select * from am_referral where referral_code=?";
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	referral_code		);
		rset		 = pstmt.executeQuery();
		rset.next();
		String postalcode=rset.getString("add_postal_code");
		String countrycode=rset.getString("add_country_code");
		String organisationType = rset.getString("org_type");
		String organType = rset.getString("org_type");

	
		String Resi_Addr_Line1=rset.getString("add_ln1");
        if(Resi_Addr_Line1==null)Resi_Addr_Line1="";

        String Resi_Addr_Line2=rset.getString("add_ln2");
        if( Resi_Addr_Line2==null) Resi_Addr_Line2="";

        String Resi_Addr_Line3=rset.getString("add_ln3");
        if(Resi_Addr_Line3==null)Resi_Addr_Line3="";

        String Resi_Addr_Line4=rset.getString("add_ln4");
        if(Resi_Addr_Line4==null)Resi_Addr_Line4="";

        String Resi_Area_code=rset.getString("RES_AREA_CODE");
        if(Resi_Area_code==null)Resi_Area_code="";

        String Resi_Town_code=rset.getString("RES_TOWN_CODE");
        if(Resi_Town_code==null)Resi_Town_code="";

        String Resi_Region_code=rset.getString("REGION_CODE");
        if(Resi_Region_code==null)Resi_Region_code="";

		String long_name=checkForNull(rset.getString("long_name"));
        //if(long_name==null)long_name="";

		
		String  applicability_for_direct_ord	= checkForNull(rset.getString("applicability_for_direct_ord"));
		String  linked_facility_id				= checkForNull(rset.getString("linked_facility_id"));
		String  source_use_at_lb_ord_yn			= checkForNull(rset.getString("source_use_at_lb_ord_yn"));
		String  source_use_at_rd_ord_yn			= checkForNull(rset.getString("source_use_at_rd_ord_yn"));
		String  source_use_at_ph_ord_yn			= checkForNull(rset.getString("source_use_at_ph_ord_yn"));
		String  source_pat_prefix				= checkForNull(rset.getString("source_ext_pat_prefix"));
		String  ext_pat_ser_grp_code			= checkForNull(rset.getString("ext_pat_ser_grp_code"));
		String  contact_name					= checkForNull(rset.getString("contact_name"));
		String  contact_name_title				= checkForNull(rset.getString("contact_name_title"));
		String  applicability_for_tissue_coll	= checkForNull(rset.getString("applicability_for_tissue_coll"));
		String  source_donor_prefix				= checkForNull(rset.getString("source_donor_prefix"));
		String  donor_ser_grp_code				= checkForNull(rset.getString("donor_ser_grp_code"));


		postalcode = postalcode==null?"":postalcode;
		if (organisationType == null || organisationType.equals(null)) organisationType = "";
		else if( organisationType.equals("G")) organisationType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Government.label","common_labels");
		else if( organisationType.equals("P")) organisationType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Private.label","common_labels");
		else if( organisationType.equals("")) organisationType="";

		if (organType == null || organType.equals(null)) organType = "";




		String sql_t="SELECT SHORT_DESC FROM Mp_res_town  WHERE  RES_TOWN_CODE='"+Resi_Town_code+"'";

		
		rs1 = stmt4.executeQuery(sql_t);
		if(rs1 !=null && rs1.next())
			{
		Resi_Town_Desc=rs1.getString("SHORT_DESC");
        if(Resi_Town_Desc==null)Resi_Town_Desc="";
			}

		 if(rs1!=null) 	rs1.close();

		 String sql_r="SELECT SHORT_DESC FROM mp_region where  REGION_CODE='"+Resi_Region_code+"'";
	
		rs2= stmt5.executeQuery(sql_r);
		if(rs2 !=null && rs2.next())
			{
		Resi_Region_Desc=rs2.getString("SHORT_DESC");
        if(Resi_Region_Desc==null)Resi_Region_Desc="";
			}

		 if(rs2!=null) 	rs2.close();

		 String sql_a="SELECT SHORT_DESC FROM mp_res_area   WHERE RES_AREA_CODE ='"+Resi_Area_code+"'";
		 
		rs3 = stmt6.executeQuery(sql_a);
		if(rs3 !=null && rs3.next())
			{
		 Resi_Area_Desc=rs3.getString("SHORT_DESC");
        if(Resi_Area_Desc==null)Resi_Area_Desc="";
			}

		 if(rs3!=null) 	rs3.close();

	
		
		%>


<form name="referral_form" id="referral_form" action="../../servlet/eAM.ReferralServlet" method="post" target="messageFrame">
<center>

<%
	if(rset.getString("eff_status").equals("E"))
		out.println("<input type='hidden' name='chkstatus' id='chkstatus' value='E'>");
	else
		out.println("<input type='hidden' name='chkstatus' id='chkstatus' value='D'>");


String sql_postal="Select short_desc  from mp_postal_code where eff_status='E' and POSTAL_CODE='"+postalcode+"'";

 			rs = stmt1.executeQuery(sql_postal);
			if(rs !=null && rs.next())
			{
			postal_desc=rs.getString("short_desc");
			if(postal_desc ==null) postal_desc="";
			}

 			sql=" select facility_id,facility_name from sm_facility_param ";
 			rs = stmt1.executeQuery(sql);
%>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" >
			    <tr>
					<td class="BORDER" width="100%">
		<table border='0' cellpadding='0'cellspacing='0' width='100%'>
	     	<tr>

	   			<td width='15%'  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width='25%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='text' name='referral_code' id='referral_code' value='<%=rset.getString("referral_code")%>' size='6' maxlength='6' readonly>&nbsp;
				<img src='../../eMP/images/mandatory.gif'></img></td>

			</tr>
	   		<tr>

				<td width='30%'  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='30%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='text'  onBlur='makeValidString(this)'  name='long_desc' id='long_desc' value="<%=rset.getString("long_desc")%>" size='30' maxlength='30' >&nbsp;
			<img src='../../eMP/images/mandatory.gif'></img></td>
			</tr>
			<tr>
				<td width='40%'  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' onBlur='makeValidString(this)'  value="<%=rset.getString("short_desc")%>" size='30' maxlength='30' >&nbsp;
			<img src='../../eMP/images/mandatory.gif'></img></td>

	   	  </tr>
		  <tr>
		<td width="40%" class="label"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
		<td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type="text" name="long_name" id="long_name" onBlur='makeValidString(this)' value="<%=long_name%>" size="100" maxlength="100">
		
		</tr>
		  <tr>
	   		   <td width="40%"  class="label"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
	   		   <td width="60%" colspan='2' class='fields'>&nbsp;&nbsp;<select name="healthcare_setting_type" id="healthcare_setting_type"><option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;</option>
<%
				String healthcare_setting_type=rset.getString("healthcare_setting_type");
				try
				{
					if(rs!=null)rs.close();
				    rs_hel = stmt_hel.executeQuery( "Select hcare_setting_type_code,short_desc from am_hcare_setting_type where eff_status='E' order by short_desc ");
				     if( rs_hel != null )
				     {
						 while( rs_hel.next() )
						 {
						    String hcare_setting_type_code= rs_hel.getString( "hcare_setting_type_code" ) ;
						    String short_desc= rs_hel.getString( "short_desc" ) ;
							if(hcare_setting_type_code.equals(healthcare_setting_type))
							{
%>   		
								<OPTION VALUE='<%= hcare_setting_type_code %>' selected>
								<%= short_desc%>
<%
							}
							else
							{
%>   		
								<OPTION VALUE='<%= hcare_setting_type_code %>'><%= short_desc %>
<%
							}
						  }
						}

				}
				catch ( Exception e ){e.printStackTrace();}
				finally
				{
				if(rs_hel!=null)rs_hel.close();
			}
%>
   		   </select>&nbsp;<img src='../../eMP/images/mandatory.gif'></img></td>
		   </tr>
<%
			if(organType.equals("G") || organType.equals("P")) 
			{
		
%>
<tr>
	   	 		<td  class='label' width='40%'><fmt:message key="Common.OrganisationType.label" bundle="${common_labels}"/></td>
					<td class='fields' width='60%' colspan='2'>&nbsp;&nbsp;<input type='text' size='15' maxlength='15' name='org_type1' id='org_type1' value='<%=organisationType%>' readonly><input type='hidden' size='6' maxlength='6' name='org_type' id='org_type' value='<%=organType%>' readonly>&nbsp;<img src='../../eMP/images/mandatory.gif'></img></td>
	   			</tr>
<%
			  }
			  else
			  {
%>
				<tr>
					<td width="40%"  class="label"><fmt:message key="Common.OrganisationType.label" bundle="${common_labels}"/></td>
				    <td width="60%" colspan="2" class='fields'>&nbsp;&nbsp;<select name="org_type" id="org_type">
					  <option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;</option>
					  <option value='G'><fmt:message key="Common.Government.label" bundle="${common_labels}"/> </option>
					  <option value='P'><fmt:message key="Common.Private.label" bundle="${common_labels}"/> </option></select>&nbsp;<img src='../../eMP/images/mandatory.gif'></img> </td>
	   			 </tr>
<%
			   }
%>
			  <tr>
			<%				
			out.println("<td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'");
			String eff_status = rset.getString("eff_status");
			if( eff_status.equals("E") ) out.println("checked ;&nbsp>");
			else out.println(">");
%>
	  		</td>
			</tr>
		<tr > <a  name='characteristicslink' id='characteristicslink' href="javascript:tab_click('ch')" alt='characteristics'>
			<td align='left' width=''nowrap class='IPCASELECTEDCOLOR' name='ch' onClick="tab_click('ch')" id='ch'>&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></a>			
			<a  name='addresslink' id='addresslink' href="javascript:tab_click('ad')" alt='address'>
			<td  nowrap  colspan="4" class='IPCAHIGHERLEVELCOLOR' name='ad' onclick ="tab_click('ad')" id='ad'> <fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></td></a>
			</tr>
	    </table>
	  </td>
	</tr>
</table>

<br>
<%
   String  checking="";
	if(rset.getString("source_use_at_regn_yn").equals("Y"))
		{
		checking="checked";
		}
	   else
		{
		checking="";
		}
		if(rset.getString("source_use_at_visit_yn").equals("Y"))
		{
		checking="checked";
		}
	   else
		{
		checking="";
		}

	if(rset.getString("source_use_at_adm_yn").equals("Y"))
		{
		checking="checked";
		}
	   else
		{
		checking="";
		}


	%>
<table id='Character_tab' name='Character_tab' style="top:0;visibility:visible;" border="0" cellpadding="0" cellspacing="0" width="100%" >
<tr>
	<td class='columnheader'colspan='6' style="background-color: black; color: white;"> <fmt:message key="eAM.UseasExternalReferralSourceat.label" bundle="${am_labels}"/></td></tr>
	<tr>
	<td width='10%'  class='label'><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></td>
	<td width='5%'  class='fields'>&nbsp;<input type='checkbox' name='source_use_at_regn_yn' id='source_use_at_regn_yn' value='Y'<%=checking%> ></td>
	<td WIDTH='5%'  class="label"><fmt:message key="Common.Visit.label" bundle="${common_labels}"/></td>
	<td WIDTH='5%'  class="fields"><input type="checkbox" name="source_use_at_visit_yn" id="source_use_at_visit_yn" value="Y" <%=checking%>></td>
	<td WIDTH='10%' class="label"><fmt:message key="Common.admission.label" bundle="${common_labels}"/></td>
	<td WIDTH='15%' class="fields"><input type="checkbox" name="source_use_at_adm_yn" id="source_use_at_adm_yn" value="Y"<%=checking%>></td></tr>


	<tr> <td class='columnheader'  colspan='6' >
	<fmt:message key="eAM.UseasExternalReferralDestinationat.label" bundle="${am_labels}"/></td>
</TR> 
<%
	out.println("<td width='10%'  class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitConclusion.label","am_labels")+"</td>");
	out.println("<td width='5%' class='fields'>&nbsp;<input type='checkbox' name='dest_use_at_concl_yn' id='dest_use_at_concl_yn' value='Y'" );

	if(rset.getString("dest_use_at_concl_yn").equals("Y"))
		out.println("checked >");
	else
	       	out.println(">");


	out.println("<td width='5%'   class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+"</td>");
	out.println("<td width='5%' class='fields'><input type='checkbox' name='dest_use_at_disch_yn' id='dest_use_at_disch_yn' value='Y'" );

   	if(rset.getString("dest_use_at_disch_yn").equals("Y"))
		out.println("checked >");
	else
	   	out.println(">");

    out.println("</td>");
%>
<td class="label" colspan='2'></td>
</tr>
</td></tr>
<tr>

<td class='columnheader' colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralSourcefordirectordering.label" bundle="${am_labels}"/></td>
	<tr>
		<td   class="label"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'>
			<select name="applicability1" id="applicability1" onchange="chkOrders(this.value);" >
			  <option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;</option>
			  <option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
			  <option value='E'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
			  <option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			  <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			</select>&nbsp;<img src='../../eMP/images/mandatory.gif' ></img>
		</td>
		<td>&nbsp;</td>	
		<td class="label" colspan='4'></td>
</tr>
		<script>document.forms[0].applicability1.value="<%=applicability_for_direct_ord%>";</script>
<input type='hidden'  value=""  name="applicabilty_value" id="applicabilty_value">

<tr>
		<td  width="25%" class="label" ><fmt:message key="eAM.AssociatedEnterpriseFacilityforReferral.label" bundle="${am_labels}"/></td>
		<td class='fields'><select name="associated_ref_facility" id="associated_ref_facility" >
		<option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
			<%
			try
			{
				String sel = "";
				ref_stmt = conn.createStatement();
				ref_rs = ref_stmt.executeQuery( " select facility_id, facility_name from sm_facility_param  order by facility_name ");
				 if( ref_rs != null )
				 {
					while(ref_rs.next())
					{
						String countrycodes = ref_rs.getString( "facility_id" ) ;
						String shortnames = ref_rs.getString( "facility_name" ) ;

						if(linked_facility_id.equals(countrycodes)){
							sel="selected";
                            selected_facility=countrycodes;
						}
						else
							sel="";

			%>
						<OPTION VALUE="<%=countrycodes%>" <%=sel%> ><%=shortnames%>
			<%
					}
				}
				if(ref_rs!=null) 	ref_rs.close();
				if(ref_stmt!=null) 	ref_stmt.close();
			}
			catch ( Exception e ){e.printStackTrace();}
			%>
			</select> <img src='../../eMP/images/mandatory.gif'  id="pat_mand_img" style="visibility:hidden"></img></td>
			<td>&nbsp;</td>
			<td class="label" colspan='4'></td>

		</tr>
<tr>
		<td  width="35%" class="label"><fmt:message key="eAM.PatientPrefixforidentifyingSource.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type="text" onBlur='makeValidString(this);chkLen(this);' onKeyPress="return CheckForSpecChars(event)" name="pat_prefix" id="pat_prefix" size="2" maxlength="2" value="<%=source_pat_prefix%>">&nbsp;<img src='../../eMP/images/mandatory.gif' id="pat_prefix_img" style="visibility:hidden"></img></td><td>&nbsp;</td>
		<td class="label" colspan='2'></td>
		<td class="label" colspan='4'></td></tr>
		</tr><td width="35%" class="label"><fmt:message key="eAM.SeriesforExtPatNumbering.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><select name="patient_no" id="patient_no" >
		<OPTION VALUE=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
			<%
			try
			{
				String sel2= "";
				if(ref_rs!=null) 	ref_rs = null;
				if(ref_stmt!=null) 	ref_stmt= null;
				ref_stmt = conn.createStatement();
				ref_rs = ref_stmt.executeQuery( " SELECT pat_ser_grp_code, short_desc FROM MP_PAT_SER_GRP WHERE gen_pat_id_yn = 'Y' AND id_type = 'X' order by short_desc ");
				 if( ref_rs != null )
				 {
					while(ref_rs.next())
					{
						String patSerGrpCode = ref_rs.getString( "pat_ser_grp_code" ) ;
						String shortDesc = ref_rs.getString( "short_desc" ) ;

						if(ext_pat_ser_grp_code.equals(patSerGrpCode))
							sel2="selected";
						else
							sel2="";
			%>
						<OPTION VALUE="<%=patSerGrpCode%>" <%=sel2%> ><%=shortDesc%>
			<%
					}
				}
				if(ref_rs!=null) 	ref_rs.close();
				if(ref_stmt!=null) 	ref_stmt.close();
			}
			catch ( Exception e ){e.printStackTrace();}
		%>
		</select>&nbsp;<img src='../../eMP/images/mandatory.gif' id="patient_no_img" style="visibility:hidden"></img></td>
			<td>&nbsp;</td>
			<td class="label" colspan='4'></td>
	</tr>

  <%	
	if(applicability_for_direct_ord.equals("E")||applicability_for_direct_ord.equals("N"))
	 {
	  out.println("<script>document.forms[0].associated_ref_facility.value='';document.forms[0].associated_ref_facility.disabled=true;</script>");
	 }	
  if(applicability_for_direct_ord.equals("R"))	
	 out.println("<script>document.forms[0].pat_mand_img.style.display='';</script>");
	%>

	
		<td class='columnheader'  colspan="6" nowrap><fmt:message key="eAM.AllowDirectordersfor.label" bundle="${am_labels}"/> :</td>
	<tr>
		<td  WIDTH='10%'class="label"><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  width='5%' class='fields'><input type="checkbox" name="laboratory" id="laboratory" value="N" onClick="changeStatus(this);" ></td>
		<td width='5%' class="label">&nbsp;&nbsp;<fmt:message key="Common.Radiology.label" bundle="${common_labels}"/></td>
		<td width='5%'class='fields'> &nbsp;&nbsp;<input type="checkbox" name="radiology" id="radiology" value="N" onClick="changeStatus(this);"></td>
		<td width='10%' class="label">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></td>
		<td  align="LEFT"WIDTH='15%'  class='fields'>&nbsp;&nbsp;<input type="checkbox" name="pharmacy" id="pharmacy" value="N" onClick="changeStatus(this);"></td>
	</tr>

<%		if(source_use_at_lb_ord_yn.equals("Y"))
		out.println("<script>document.forms[0].laboratory.checked=true;document.forms[0].laboratory.value='Y';</script>");
		else
		out.println("<script>document.forms[0].laboratory.checked=false;document.forms[0].laboratory.value='N';</script>");

		if(source_use_at_rd_ord_yn.equals("Y"))
		out.println("<script>document.forms[0].radiology.checked=true;document.forms[0].radiology.value='Y';</script>");
		else
		out.println("<script>document.forms[0].radiology.checked=false;document.forms[0].radiology.value='N';</script>");
	
		if(source_use_at_ph_ord_yn.equals("Y"))
		out.println("<script>document.forms[0].pharmacy.checked=true;document.forms[0].pharmacy.value='Y';</script>");
		else
		out.println("<script>document.forms[0].pharmacy.checked=false;document.forms[0].pharmacy.value='N';</script>");

%>

	
<%
if(applicability_for_direct_ord.equals("N"))
{
	out.println("<script>document.forms[0].laboratory.checked=false;document.forms[0].laboratory.value='N';document.forms[0].laboratory.disabled=true;</script>");
	out.println("<script>document.forms[0].radiology.checked=false;document.forms[0].radiology.value='N';document.forms[0].radiology.disabled=true;</script>");
	out.println("<script>document.forms[0].pharmacy.checked=false;document.forms[0].pharmacy.value='N';document.forms[0].pharmacy.disabled=true;</script>");
	out.println("<script>document.forms[0].pat_prefix.disabled=true;document.forms[0].pat_prefix.value='';</script>");
	out.println("<script>document.forms[0].patient_no.disabled=true;document.forms[0].patient_no.value='';</script>");
}
%>		

<td class='columnheader' colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralSourceforTissueCollection.label" bundle="${am_labels}"/></td>
	<tr>
		<td  width="35%"  class="label"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'>
			<select name="applicability2" id="applicability2" onchange="validateTC(this.value);">
			  <option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;</option>
			  <option value='T'><fmt:message key="eAM.TissueCollection.label" bundle="${am_labels}"/> </option>
			  <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> </option>
			</select>
		</td>
		<td>&nbsp;</td>
		<td class="label" colspan='4'></td>
	</tr>
<script>document.forms[0].applicability2.value="<%=applicability_for_tissue_coll%>";</script>

	<tr>
		<td  width="35%"  class="label"><fmt:message key="eAM.DonorPrefixforidentifyingSource.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type="text" onBlur='makeValidString(this);chkLen(this);' name="donor_prefix" id="donor_prefix" size="2" maxlength="2" onKeyPress="return CheckForSpecChars(event)" value="<%=source_donor_prefix%>" >&nbsp;<img src='../../eMP/images/mandatory.gif' id="donor_prefix_img" style="visibility:hidden"></img></td><td class="label" colspan='4'></td></tr>
		
		<tr><td width="35%"class="label"><fmt:message key="eAM.SeriesforDonorNumbering.label" bundle="${am_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><select name="donor_no" id="donor_no" >
			<option value=''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
			<%
			try
			{
				String sel3 = "";
				if(ref_rs!=null) 	ref_rs = null;
				if(ref_stmt!=null) 	ref_stmt= null;
				ref_stmt = conn.createStatement();
				ref_rs = ref_stmt.executeQuery( "SELECT pat_ser_grp_code, short_desc FROM MP_PAT_SER_GRP WHERE gen_pat_id_yn = 'Y' AND id_type = 'R' order by short_desc ");
				 if( ref_rs != null )
				 {
					while(ref_rs.next())
					{
						String Donor_num = ref_rs.getString( "pat_ser_grp_code" ) ;
						String Donor_Desc = ref_rs.getString( "short_desc" ) ;
						
						if(donor_ser_grp_code.equals(Donor_num))
							sel3="selected";
						else
							sel3="";
			%>
						<OPTION VALUE="<%=Donor_num%>" <%=sel3%> ><%=Donor_Desc%>
			<%
					}
				}
				if(ref_rs!=null) 	ref_rs.close();
				if(ref_stmt!=null) 	ref_stmt.close();
			}
			catch ( Exception e ){e.printStackTrace();}
			%>
			</select>&nbsp;<img src='../../eMP/images/mandatory.gif' id="donor_no_img" style="visibility:hidden"></img></td>
			<td class="label" colspan='4'></td> 
	</tr>
<%
if(applicability_for_tissue_coll.equals("N") || applicability_for_tissue_coll.equals(""))
{
	out.println("<script>document.forms[0].donor_prefix.disabled=true;document.forms[0].donor_prefix.value='';</script>");
	out.println("<script>document.forms[0].donor_no.disabled=true;document.forms[0].donor_no.value='';</script>");
}

%>

</table>
<table id='address_tab' name='address_tab' style="POSITION:RELATIVE;TOP:-630;VISIBILITY:VISIBLE"border="0" cellpadding="0" cellspacing="0" width="100%">
 <tr>
	<td class="border" width="100%">
	   <table border='0' cellpadding='0'cellspacing='0' width='100%' >
		<td class='columnheader'  colspan="6" style="background-color: black; color: white;"><fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/> </td>
	<%
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "add_ln1" ;
																				     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "add_ln2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "add_ln3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "add_ln4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "m_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
                                     }
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
										
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal2.append(++tindex);
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
									
						/*Below line added for ML-MMOH-CRF-0860.2*/
						if(increasedaddressLength){
							if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
								out.println("<td class='fields' ><input type='text' name='add_ln1' id='add_ln1' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
								out.println("<td class='fields' ><input type='text' name='add_ln2' id='add_ln2' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
								out.println("<td class='fields' ><input type='text' name='add_ln3' id='add_ln3' maxlength='30' size='25' value='' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
							}else{									
                                out.println("<td class='fields'>"+val) ;									
						        out.println("</td>");
						    }
						}else{                                
								out.println("<td class='fields'>"+val) ;									
						        out.println("</td>");
					    }			
						//End ML-MMOH-CRF-0860.2			
									
						   out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            }

	

		       %>  


		<td class="label"><fmt:message key="Common.country.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'> <select name="add_country_code" id="add_country_code" >
<%
	    rs = stmt2.executeQuery(  "Select country_code,short_name from mp_country where eff_status='E' and ( trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >= trunc(sysdate) ) or ( trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null ) or ( trunc(eff_date_to) >= trunc(sysdate) and trunc(eff_date_from) is null) or ( eff_date_from is null and eff_date_to is null)order by short_name ");

	      if ( countrycode==null)
			out.println( "<option selected  value=''>&nbsp;----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----&nbsp;" );

			if( rs != null )
			{
				while( rs.next() )
				{
					String cntcode = rs.getString( "country_code" ) ;
					String cntname = rs.getString( "short_name" ) ;

					if ( cntcode.equals( countrycode ) )
						out.println( "<option selected value='" + cntcode + "' >" + cntname );
					else
						out.println( "<option value='" + cntcode + "' >" + cntname) ;
				}
			}

%>

			</select></td>
			<td>&nbsp</td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
			
			<td  class="label"><fmt:message key="Common.telno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<%
				String v_tel_no = "";
				v_tel_no = rset.getString("tel_no");
				if(v_tel_no == null || v_tel_no.equals("null")) v_tel_no = "";
					%>
				<td class='fields'>
						<input type='text' onBlur='makeValidString(this)' name='tel_no' id='tel_no' size='18' maxlength='18' value='<%=v_tel_no%>' ></td>
		
		</tr>
			<%
				out.println("<tr> <td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FaxNo.label","common_labels")+"&nbsp;&nbsp;</td>");

				out.println("<td><input type='text' name='fax_no' id='fax_no' size='18' onBlur='makeValidString(this)'  maxlength='18'value=\"");
				if(rset.getString("fax_no")==null)
					out.println("");
				else
					out.println(rset.getString("fax_no"));

				out.println("\"></td>");
			%>
			
		</tr>
		<tr>
			
			<td  class="label">E-Mail&nbsp;&nbsp;</td>
			<%
				out.println("<td class='fields'><input type='text' onBlur='makeValidString(this)'  name='email_id' id='email_id' size='50' maxlength='50' value=\"");
				if(rset.getString("email_id")==null)
					out.println("");
				else
					out.println(rset.getString("email_id"));

				out.println("\"</td>");			
			%>
			<td>&nbsp</td>
<td class="label" colspan='2'></td>			
		</tr>
 		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class='columnheader' colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.ContactPersonDetails.label" bundle="${am_labels}"/></td>
			</tr>
			<tr>
				
				<td width="22%"  class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class='fields'><input type="text" onBlur='makeValidString(this)' value="<%=contact_name%>" name="contact_name" size="18" maxlength="40"></td>
				<td   class="label"><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
				<td class='fields'><input type="text" onBlur='makeValidString(this)' value="<%=contact_name_title%>" name="contact_title" size="18" maxlength="40"></td>
				  
			</tr>
					<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

		</table>
	</td>
	</tr>
	<tr><td class="EMPTY">&nbsp;&nbsp;</td></tr>
					<tr></tr>
		
</table>





	<input type='hidden' name='function1' id='function1' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from'>
		<input type='hidden' name='eff_date_to' id='eff_date_to'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='app_change' id='app_change' value=<%=applicability_for_direct_ord%>>
		<input type='hidden' name='ref_change' id='ref_change' value=<%=selected_facility%>>
		<input type='hidden' name='change_val' id='change_val' value=''>

		<input type='hidden' name='m_town' id='m_town' value=''>
		<input type='hidden' name='m_area' id='m_area' value=''>
		<input type='hidden' name='m_region' id='m_region' value=''>
		<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>

		<INPUT TYPE="hidden" name="town_code" id="town_code">
		<INPUT TYPE="hidden" name="area_code" id="area_code">
		<INPUT TYPE="hidden" name="region_code" id="region_code">
		<INPUT TYPE="hidden" name="postal_code" id="postal_code">
		
<script>

	
    if("<%=Resi_Addr_Line1%>" != '' && document.getElementById('add_ln1') != null)
		document.getElementById('add_ln1').value="<%=Resi_Addr_Line1%>"

	if("<%=Resi_Addr_Line2%>" != '' && document.getElementById('add_ln2') != null)
		document.getElementById('add_ln2').value="<%=Resi_Addr_Line2%>"

	if("<%=Resi_Addr_Line3%>" != '' && document.getElementById('add_ln3') != null)
		document.getElementById('add_ln3').value="<%=Resi_Addr_Line3%>"

	if("<%=Resi_Addr_Line4%>" != '' && document.getElementById('add_ln4') != null)
		document.getElementById('add_ln4').value="<%=Resi_Addr_Line4%>"

	if("<%=Resi_Town_Desc%>" != '' && document.getElementById('m_town_code') != null)
		document.getElementById('m_town_code').value="<%=Resi_Town_Desc%>"

	if("<%=Resi_Region_Desc%>" != '' && document.getElementById('m_region_code') != null)
		document.getElementById('m_region_code').value="<%=Resi_Region_Desc%>"

	if("<%=Resi_Area_Desc%>" != '' && document.getElementById('m_area_code') != null)
		document.getElementById('m_area_code').value="<%=Resi_Area_Desc%>"

	if("<%=postal_desc%>" != '' && document.getElementById('m_postal_code1') != null)
		document.getElementById('m_postal_code1').value="<%=postal_desc%>"


	if("<%=Resi_Town_code%>" != '' && document.getElementById('m_town') != null)
		document.getElementById('m_town').value="<%=Resi_Town_code%>"

	if("<%=Resi_Area_code%>" != '' && document.getElementById('m_area') != null)
		document.getElementById('m_area').value="<%=Resi_Area_code%>"

	if("<%=Resi_Region_code%>" != '' && document.getElementById('m_region') != null)
		document.getElementById('m_region').value="<%=Resi_Region_code%>"
	
	if("<%=postalcode%>" != '' && document.getElementById("m_postal_code") != null)
		document.getElementById("m_postal_code").value="<%=postalcode%>"
	

	
	
		
</script>

		</form>
<%
// CODE FOR HANDLING DISABLED FIELDS 

	if(rset.getString("eff_status").equals("D"))
	{	%>
		<script>
			for(k=0;k<document.forms[0].elements.length;k++)
				document.forms[0].elements[k].disabled = true;

			document.forms[0].eff_status.disabled = false;
			document.forms[0].eff_status.focus();
		</script>
	<%	
	}




		if ( rset != null ) rset.close() ;
		if ( rs != null ) rs.close() ;
		
		if ( stmt != null ) stmt.close() ;
		if ( pstmt != null ) pstmt.close() ;
		if ( stmt1 != null ) stmt.close() ;
		if ( stmt2 != null ) stmt.close() ;
		if ( rs_hel != null ) rs_hel.close() ;
		if ( stmt_hel != null ) stmt_hel.close() ;

}
catch(Exception e)
{
	//out.println("HERE"+e);
	e.printStackTrace();
}

finally
{
	ConnectionManager.returnConnection(conn,request);
}	
%>
</center>

<%!
     public static String checkForNull(String inputString)
	 {
		 return((inputString==null)? "": inputString);
	 }
%>

</body>
</html>

