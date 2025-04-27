<!DOCTYPE html>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>

<%


	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null ;
	request.setCharacterEncoding("UTF-8");	
	con = ConnectionManager.getConnection(request);

	int tindex=0;
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String[] contact_col_names				= null ;
	String[] contact_prompts				= null ;
	String[] contact_fields					= null ;
	ArrayList contact_addr                  = null; 
	
	Boolean increasedaddressLength=false; //Added for ML-MMOH-CRF-0860.2

try{
		contact_addr = fetchContactAddresses(con, out, "parent.messageFrame",p) ;
		
		//Below line added for ML-MMOH-CRF-0860.2
        increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		
		}catch(Exception e)
		{
			out.println("Exception in FetchContactAddress Function="+e);
			e.printStackTrace();
		}
		contact_col_names = (String[])contact_addr.get(1) ;
		contact_prompts   = (String[])contact_addr.get(2) ; 
		contact_fields    = (String[])contact_addr.get(3) ;
		contact_addr = null;


try{
	
%>

<html>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eAM/js/Referral.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
    window.onload = function a(){
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
</script>



</head>
<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
	<div id='titlebar'>
<form name="referral_form" id="referral_form" action="../../servlet/eAM.ReferralServlet" method="post" target="messageFrame">
<center>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
	<td class="BORDER" width="100%">
		<table border='0' cellpadding='0'cellspacing='0' width='100%'>
	   	<tr>
	   		<td width="15%"  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	   		<td width="25%" colspan="2" class="fields"><input type="text" name="referral_code" id="referral_code" size="6" maxlength="6"  onBlur="ChangeUpperCase(this)"onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'></img></td>
		</tr>
		<tr>
			<td width="30%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width="30%" colspan="2" class="fields"><input type="text" name="long_desc" id="long_desc" onBlur='makeValidString(this)' size="30" maxlength="30"><img src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
			<tr>
			<td width="25%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width="20%" class="fields"><input type="text"  onBlur='makeValidString(this)' name="short_desc" id="short_desc" size="30" maxlength="30"><img src='../../eCommon/images/mandatory.gif'></img></td>
		</tr>

		<tr>
		<td width="30%" class="label"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
		<td width="30%" colspan="2" class="fields"><input type="text" name="long_name" id="long_name" onBlur='makeValidString(this)' size="100" maxlength="100">
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</tr>
		<tr>
			<td width="35%" class="label"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
			<td width="65%" colspan="2" class="fields"><select name="healthcare_setting_type" id="healthcare_setting_type"><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
<%
try
	{
		stmt = con.createStatement();
	    rs = stmt.executeQuery( "Select hcare_setting_type_code,short_desc from am_hcare_setting_type where eff_status='E' order by short_desc ");
		if( rs != null )
		{
			while( rs.next() )
			{
				String hcare_setting_type_code= rs.getString( "hcare_setting_type_code" ) ;
				String short_desc= rs.getString( "short_desc" ) ;
				%>
				<OPTION VALUE='<%=hcare_setting_type_code%>' ><%=short_desc%>
				<%
			}
		}
    if(rs!=null) 	rs.close();
	if(stmt!=null) 	stmt.close();

	}
		catch ( Exception e ){
			//out.println(e);
			e.printStackTrace();
			}

		
%>			
			</select><img src='../../eCommon/images/mandatory.gif'></img></td>
		      </tr>
			  <tr>
			  <td width="40%" class="label"><fmt:message key="Common.OrganisationType.label" bundle="${common_labels}"/></td>
		      <td width="20%" colspan="2" class="fields"><select name="org_type" id="org_type">
			  <option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
			  <option value='G'><fmt:message key="Common.Government.label" bundle="${common_labels}"/> </option>
			  <option value='P'><fmt:message key="Common.Private.label" bundle="${common_labels}"/> </option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img> </td>
	   	 </tr>
		<tr>
			<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
   			<td width="60%" colspan="2" class="fields"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>

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

<table id='Character_tab' name='Character_tab' style="top:0;visibility:visible;" border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>

 <td class='columnheader' ALIGN='LEFT' colspan='6' style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralSourceat.label" bundle="${am_labels}"/></td></tr>
	 <tr>
<td WIDTH='10%' class="label"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></td>
<td WIDTH='5%'  class="fields"><input type="checkbox" name="source_use_at_regn_yn" id="source_use_at_regn_yn" value="N" onClick="change();" ></td>
<td WIDTH='5%'  class="label"><fmt:message key="Common.Visit.label" bundle="${common_labels}"/></td>
<td WIDTH='5%'  class="fields"><input type="checkbox" name="source_use_at_visit_yn" id="source_use_at_visit_yn" value="N" onClick="change();"></td>
<td WIDTH='10%' class="label"><fmt:message key="Common.admission.label" bundle="${common_labels}"/></td>
<td WIDTH='15%' class="fields"><input type="checkbox" name="source_use_at_adm_yn" id="source_use_at_adm_yn" value="N" onClick="change();"></td></tr>
<tr>
 <td class='columnheader'   colspan='6' style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralDestinationat.label" bundle="${am_labels}"/></td>
</tr>
<tr>
<td WIDTH='10%' class="label"><fmt:message key="eAM.VisitConclusion.label" bundle="${am_labels}"/></td>
<td WIDTH='5%'  class="fields"><input type="checkbox" name="dest_use_at_concl_yn" id="dest_use_at_concl_yn" value="N" onclick='change();'></td>
<td WIDTH='5%' class="label"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></td>
<td WIDTH='5%' class="fields"><input type="checkbox" name="dest_use_at_disch_yn" id="dest_use_at_disch_yn" value="N" onClick='change();'></td>
<td class="label" colspan='4'></td>
</tr>
<tr>
<td class='columnheader'  colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralSourcefordirectordering.label" bundle="${am_labels}"/></td>
	<tr>
		<td  width="25%" class="label"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<select name="applicability1" id="applicability1" onchange="chkOrders(this.value);">
			  <option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
			  <option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
			  <option value='E'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
			  <option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			  <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif' ></img></td>
			<td class="label" colspan='4'></td></tr>
        <tr>
		<td  width="25%" class="label" ><fmt:message key="eAM.AssociatedEnterpriseFacilityforReferral.label" bundle="${am_labels}"/></td>
		<td class="fields"><select name="associated_ref_facility" id="associated_ref_facility" disabled>
		<OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
			<%
			try
			{
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				stmt = con.createStatement();
				rs = stmt.executeQuery("select facility_id, facility_name from sm_facility_param order by facility_name");
				 if(rs!= null )
				 {
					while(rs.next())
					{
						String countrycodes = rs.getString( "facility_id") ;
						String shortnames = rs.getString( "facility_name") ;
			%>
						<OPTION VALUE='<%= countrycodes %>' ><%= shortnames %>
			<%

					}
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();


			}
			catch ( Exception e ){e.printStackTrace();}


			%>

			</select>			
	 <img src='../../eCommon/images/mandatory.gif'  id="pat_mand_img" style="visibility:hidden"></img>
				</td>
				<td class="label" colspan='4'></td>
		</tr>
	<tr>
		<td  width="33%" class="label"><fmt:message key="eAM.PatientPrefixforidentifyingSource.label" bundle="${am_labels}"/></td>
		<td  class="fields"><input type="text" onBlur='makeValidString(this);chkLen(this);' onKeyPress="return CheckForSpecChars(event)" name="pat_prefix" id="pat_prefix" size="2" maxlength="2" disabled><img src='../../eCommon/images/mandatory.gif' id="pat_prefix_img" style="visibility:hidden"></img></td>
		<td class="label" colspan='4'></td>
		</tr>
		<tr><td  width="33%" class="label"><fmt:message key="eAM.SeriesforExtPatNumbering.label" bundle="${am_labels}"/></td>
		<td class="fields"><select name="patient_no" id="patient_no" disabled>
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
			<%
			try
			{
				if(rs!=null) 	rs.close();
				if(stmt!=null) 	stmt.close();
				stmt = con.createStatement();
				rs = stmt.executeQuery( "SELECT pat_ser_grp_code, short_desc FROM mp_pat_ser_grp WHERE gen_pat_id_yn = 'Y' AND id_type = 'X' order by short_desc ");
				 if( rs != null )
				 {
					while(rs.next())
					{
						String patSerGrpCode = rs.getString( "pat_ser_grp_code" ) ;
						String shortDesc = rs.getString( "short_desc" ) ;
			%>
						<OPTION VALUE="<%=patSerGrpCode%>" ><%=shortDesc%>
			<%
					}
				}
				if(rs!=null) 	rs.close();
				if(stmt!=null) 	stmt.close();


			}
			catch ( Exception e ){e.printStackTrace();}
			%>
			</select><img src='../../eCommon/images/mandatory.gif' id="patient_no_img" style="visibility:hidden"></img></td>
			<td class="label" colspan='4'></td>
	</tr>
	</tr>
	<tr>
<td class='columnheader'  colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.AllowDirectordersfor.label" bundle="${am_labels}"/> : </td>
	   
		<tr>
			<td  WIDTH='10%' class="label"><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/></td>
			<td WIDTH='5%'  class="fields"><input type="checkbox" name="laboratory" id="laboratory" value="N" onClick="changeStatus(this);" disabled></td>
		<td  WIDTH='5%' class="label" nowrap><fmt:message key="Common.Radiology.label" bundle="${common_labels}"/></td>
		<td WIDTH='5%'  class="fields"><input type="checkbox" name="radiology" id="radiology" value="N" onClick="changeStatus(this);" disabled></td>
		<td WIDTH='10%' class="label"><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></td>
		<td WIDTH='15%'  class="fields"><input type="checkbox" name="pharmacy" id="pharmacy" value="N" onClick="changeStatus(this);" disabled></td>
	</tr>
</tr>
<tr>
<td class='columnheader' colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.UseasExternalReferralSourceforTissueCollection.label" bundle="${am_labels}"/></td>
	<tr>
		<td width="33%" class="label"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<select name="applicability2" id="applicability2" onchange="validateTC(this.value);">
			  <option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
			  <option value='T'><fmt:message key="eAM.TissueCollection.label" bundle="${am_labels}"/> </option>
			  <option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> </option>
			</select>
		</td>
		<td class="label" colspan='4'></td>
	</tr>
</tr>
<tr>

	<tr>
		<td  width="33%" class="label"><fmt:message key="eAM.DonorPrefixforidentifyingSource.label" bundle="${am_labels}"/></td>
		<td  class="fields"><input type="text" onBlur='makeValidString(this);chkLen(this);' name="donor_prefix" id="donor_prefix" size="2" maxlength="2" disabled onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif' id="donor_prefix_img" style="visibility:hidden"></img></td>
		<td class="label" colspan='4'></td>
		</tr>
		<tr><td width="33%" class="label"><fmt:message key="eAM.SeriesforDonorNumbering.label" bundle="${am_labels}"/></td>
		<td class="fields"><select name="donor_no" id="donor_no" disabled>
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
			<%
			try
			{
				if(rs!=null) 	rs.close();
				if(stmt!=null) 	stmt.close();
				stmt = con.createStatement();
				rs = stmt.executeQuery( " SELECT pat_ser_grp_code, short_desc FROM MP_PAT_SER_GRP WHERE gen_pat_id_yn = 'Y' AND id_type = 'R' order by short_desc ");
				 if( rs != null )
				 {
					while(rs.next())
					{
						String Donor_num = rs.getString( "pat_ser_grp_code" ) ;
						String Donor_Desc = rs.getString( "short_desc" ) ;
			%>
						<OPTION VALUE="<%=Donor_num%>" ><%=Donor_Desc%>
			<%
					}
				}
				if(rs!=null) 	rs.close();
				if(stmt!=null) 	stmt.close();


			}
			catch ( Exception e ){e.printStackTrace();}


			%>
			</select><img src='../../eCommon/images/mandatory.gif'  id="donor_no_img" style="visibility:hidden"></img></td>
			<td class="label" colspan='4'></td>
	</tr>
</table>
<table id='address_tab' style="POSITION:RELATIVE;TOP:-630;VISIBILITY:visible"border="0" cellpadding="0" cellspacing="0" width="100%">
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
		<tr>
			  
			  <td  width="20%" class="label"><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
		      <td width="20%" class="fields"><select name="add_country_code" id="add_country_code" >
	      		<OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%
  	    
try
	{
		stmt = con.createStatement();
	    rs = stmt.executeQuery( "Select country_code,short_name from mp_country where eff_status='E' order by short_name ");
	     if( rs != null )
	       {
	          while( rs.next() )
		    {
		    String countrycode = rs.getString( "country_code" ) ;
		    String shortname = rs.getString( "short_name" ) ;
%>

    		    <OPTION VALUE='<%= countrycode %>' ><%= shortname %>
<%
		    }
	       }
        if(rs!=null) 	rs.close();
    	if(stmt!=null) 	stmt.close();

	}
		catch ( Exception e ){e.printStackTrace();}
		if ( rs != null ) rs.close() ;
			if ( stmt != null ) stmt.close() ;

}catch ( Exception e ){e.printStackTrace();}

		finally{
       		
			ConnectionManager.returnConnection(con,request);
			}
%>
			</select></td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
			<td  width="10%" class="label"><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
			<td  width="50%" class="fields"><input type="text" onBlur='makeValidString(this)' name="tel_no" id="tel_no" size="18" maxlength="18"></td>
			 <td colspan='2'></td>
		</tr>
		<tr>
			<td  width="20%" class="label"><fmt:message key="Common.FaxNo.label" bundle="${common_labels}"/></td>
			<td  width="20%" class="fields"><input type="text" onBlur='makeValidString(this)' name="fax_no" id="fax_no" size="18" maxlength="18"></td>
			 <td colspan='2'></td>
		</tr>
		<tr>
			  <td width="10%" class="label"><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
      		  <td width="50%" class="fields"><input type="text" name="email_id" id="email_id" onBlur='makeValidString(this)' size="50" maxlength="50"></td>
      		  <td colspan='2'></td>
    	</tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td class='columnheader' colspan="6" style="background-color: black; color: white;"><fmt:message key="eAM.ContactPersonDetails.label" bundle="${am_labels}"/></td>
			<tr>
			<td width="20%" class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td width="20%" class="fields"><input type="text" onBlur='makeValidString(this)' name="contact_name" id="contact_name" size="18" maxlength="40"></td>
			<td width="15%" class="label"><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
			<td width="15%" class="fields"><input type="text" onBlur='makeValidString(this)' name="contact_title" id="contact_title" size="18" maxlength="40"></td>
			<td colspan='1'></td>
		</tr>
	</table>
	<br><br><br><br><br><br><br>
	</td>
  </tr>
</td></tr>
</table>
<input type="hidden" name="function1" id="function1" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>

<input type='hidden' name='m_town' id='m_town' value=''>
<input type='hidden' name='m_area' id='m_area' value=''>
<input type='hidden' name='m_region' id='m_region' value=''>
<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>

<INPUT TYPE="hidden" name="town_code" id="town_code">
<INPUT TYPE="hidden" name="area_code" id="area_code">
<INPUT TYPE="hidden" name="region_code" id="region_code">
<INPUT TYPE="hidden" name="postal_code" id="postal_code">


</form>
</center>
</div>
</body>
</html>

