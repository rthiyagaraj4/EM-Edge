<!DOCTYPE html>


<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.*, eCommon.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
Connection con=null;
try
{
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement dftstmt=null;
	ResultSet rs =null;
	ResultSet rs1 =null;
	ResultSet rs2 =null;
	ResultSet dftrslt =null;
	String patNoCtrl="";
	String accept_national_id_no_yn = "N";
	int recCnt =0;
	String email_appl_yn1 = "";
	String email_chk = "";
	String default_chk = "";
	String default_yn1 = "";
    String single_pat_num_yn="";
    String pat_ser_grp_code="";
    String short_desc="";
	String rut_pat_ser_code="";
	String disable_year_ser_code="";
	int dflt_pat_ser_cnt=0;
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumbering.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad="Focusing('id_type');">
<form name="patientnumbering_form" id="patientnumbering_form" action="../../servlet/eMP.PatientNumberingServlet" method="post" target="messageFrame">
<center>

<%
	try{
		dftstmt=con.prepareStatement("select count(*) from mp_pat_ser_grp where DEFAULT_YN='Y'");
		dftrslt=dftstmt.executeQuery();
		int default_count=0;
			while(dftrslt.next()){
				default_count=dftrslt.getInt(1);
			}
			if (default_count==0){
				default_chk="";
			}else{						
				default_chk="disabled";
			}
			if (dftrslt != null)
			dftrslt.close();
			if(dftstmt != null)
			dftstmt.close();				
		pstmt1 = con.prepareStatement("select EMAIL_APPL_YN from sm_installation");
		rs1= pstmt1.executeQuery();

		if(rs1.next())
		{
			email_appl_yn1=rs1.getString("EMAIL_APPL_YN");			
		}

		pstmt1=con.prepareStatement("SELECT COUNT (*) dflt_pat_ser_cnt  FROM sm_site_param a, sm_function_control b WHERE a.customer_id = b.site_id   AND module_id = 'MP'   AND functionality_id = 'AUTO_PAT_SERIES'");
		rs1=pstmt1.executeQuery();
		while(rs1.next())
		{
			dflt_pat_ser_cnt=rs1.getInt(1);	
		}
		
		if (rs1 != null)
			rs1.close();
		if(pstmt1 != null)
			pstmt1.close();
		
		if(email_appl_yn1.equals("Y"))
			email_chk = "enabled";
		else
			email_chk = "unchecked disabled";

		pstmt = con.prepareStatement("select accept_national_id_no_yn, patient_no_ctrl, family_no_link_yn,names_in_oth_lang_yn,gen_pid_using_aid1_rule_yn,single_patient_numbering_yn from mp_param");
		rs= pstmt.executeQuery();



	if (!rs.next())
	{
		recCnt = 0; 
%>
			<script language='javascript'>
			var err=getMessage("NO_RECORDS_FOUND","FM");
			parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err;
			</script>
			
<%	}
	else
	{
		recCnt = 1;
		String familyNoLink="";
		String nameInOthLang="";
		String genPidUsingAid1RuleYn="";


		
		familyNoLink=rs.getString("family_no_link_yn");
		nameInOthLang=rs.getString("names_in_oth_lang_yn");
		genPidUsingAid1RuleYn=rs.getString("gen_pid_using_aid1_rule_yn");


		patNoCtrl = rs.getString("patient_no_ctrl");
		accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
        single_pat_num_yn=rs.getString("single_patient_numbering_yn");
    
		int count=0;

		if(familyNoLink !=null)
		{
			if(familyNoLink.equals("N"))
			{
				count++;
			}
		}
		if(nameInOthLang !=null)
		{
			if(nameInOthLang.equals("N"))
			{
				count++;

			}
		}
		if(count==0)
		{
%>
			<BR>
<%	
		}

		if(count==2)
		{

%>
			<BR><BR><BR>
<%	
		}
		if(count==1)
		{

%>
			<BR><BR>
<%	
		}

%>
<BR>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
   <tr>
	<td class="NONE" width="70%">
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
			<tr>
			<td class="label" ><fmt:message key="eMP.SeriesType.label" bundle="${mp_labels}"/></td>
			<td class="fields"><select name="id_type" id="id_type">
 				<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
				<option value="A"><fmt:message key="eMP.AlternateIDSeries.label" bundle="${mp_labels}"/>
				<option value="B"><fmt:message key="eMP.NewBornSeries.label" bundle="${mp_labels}"/>
				<option value="E"><fmt:message key="eMP.EmergencySeries.label" bundle="${mp_labels}"/>
				<option value="G"><fmt:message key="eMP.GeneralSeries.label" bundle="${mp_labels}"/>
				<option value="U"><fmt:message key="eMP.UnrestrictedSeries.label" bundle="${mp_labels}"/>
				<option value="X"><fmt:message key="eMP.ExternalSourceSeries.label" bundle="${mp_labels}"/>
				<option value='R'><fmt:message key="eMP.ExternalPatientDonorSeries.label" bundle="${mp_labels}"/>
				<!-- <option value='N'><fmt:message key="eMP.BDYearPrefix.label" bundle="${mp_labels}"/> -->



				<% if (accept_national_id_no_yn.equals("Y"))
				{%>
				<option value="N"><fmt:message key="eMP.NationalIDSeries.label" bundle="${mp_labels}"/>
				<%}%>
				</select><img src='../images/mandatory.gif'></img></td>
			<tr>
			<%
			//Added by Sangeetha for ML-MMOH-CRF-0732 
			Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");
			%>

			<tr>
				<td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="pat_ser_grp_code" id="pat_ser_grp_code" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %> onBlur="ChangeUpperCase(this);CodeLen(this)"  onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img></td>
			</tr> <!--Modified maxLength by Sangeetha for ML-MMOH-CRF-0732 --> 

			<tr>
				<td class="label" nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan='1'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur="makeValidString(this);"><img src='../images/mandatory.gif'></img></td>
			</tr>
			<tr>			
				<td class="label" nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur="makeValidString(this);"><img src='../images/mandatory.gif'></img></td>
			</tr>
			
			<tr><td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.PatientIDGenerationRule.label" bundle="${mp_labels}"/></tr>
			<tr>
		<td class='label' nowrap><fmt:message key="eMP.AssociatedNoSeries.label"  bundle="${mp_labels}"/></td>
					 <td class="fields">
				<select name='associ_num_series' id='associ_num_series' onChange='disablePrefix1(this)'  <%if(single_pat_num_yn.equals("N")){ %> disabled  <%}%>  >
                                <option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				
		<% 	
				String sql1="select pat_ser_grp_code,short_desc,scheme_id from mp_pat_ser_grp where (((gen_pat_id_yn='Y' and pat_no_ctrl in ('Z','U')) or GEN_PID_USING_ALT_ID1_RULE_YN='Y')) and associated_pat_ser_grp_code is null order by short_desc" ;
				
				pstmt2 = con.prepareStatement(sql1);
				 
				rs2= pstmt2.executeQuery();
        	     while (rs2.next())           
		         {
	              pat_ser_grp_code=rs2.getString("pat_ser_grp_code");
	               if(pat_ser_grp_code==null) pat_ser_grp_code="";
				   short_desc=rs2.getString("short_desc");
		             if(short_desc==null) short_desc="";
					 out.println( "<option value='" +pat_ser_grp_code+ "' >" +short_desc) ;
						 
					 }
	%>
				   </select>
                        </td>
				</tr>
		


			<tr>
				<td class="label" width='25%'><fmt:message key="eMP.GeneratePatientID.label" bundle="${mp_labels}"/></td>
					

				<td class="fields" width='75%'><input type="checkbox" name="gen_pat_id_yn" id="gen_pat_id_yn" value="" checked   onClick="change();change1(this);"></td>
				
				
				
			</tr>
			
						
			<tr>
				<td class="label" width="25%"><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></td>

				

				<td class="fields" ><input type="checkbox" name="prefix_reqd_yn" id="prefix_reqd_yn" value="Y"  checked></td>

			</tr>

				
			
			
			<%
				try{		
						if (recCnt!=0)
						{

						if(genPidUsingAid1RuleYn.equals("Y"))
						{
							%>
							<tr>
							<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>							
							<input type="hidden" name="patCtrlVal" id="patCtrlVal"  value="N">						
							
							<td class="fields"><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="Z"  onClick="func(this.value)" disabled><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>								
							<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U"  onClick="func(this.value)" disabled> <fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/>					
							 <input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="N"  onClick="func(this.value)" checked><fmt:message key="Common.none.label" bundle="${common_labels}"/></td>		
						<%							
						}
						else
						{
						if(patNoCtrl.equals("Z") )
						{
			%>
			<tr>
				<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>
				
				<input type="hidden" name="patCtrlVal" id="patCtrlVal"  value="Z">
			
				<td width="75%" colspan='3'>
				<table>
				<tr>
				<%
				out.println("<td class='fields' ><input type='Radio' name='pat_no_ctrl' id='pat_no_ctrl' value='Z' checked onClick='func(this.value)'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Site.label","common_labels"));
				%>
			
				
				<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U"  onClick="func(this.value)" disabled ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="N" onClick="func(this.value)" disabled ><fmt:message key="Common.none.label" bundle="${common_labels}"/></td>
				</tr>
						
				
				
				</table>
				</td>

			</tr>


				<%}%>


			<%
				if(patNoCtrl.equals("U"))
				{
			%>
				<tr>
				<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>

				<input type="hidden" name="patCtrlVal" id="patCtrlVal"  value="U">

				
					<td width="75%" colspan='3'>
						<table>
							<tr> 				
								<td class="fields"><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="Z"  onClick="func(this.value)" disabled><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>			
								<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U" checked onClick="func(this.value)" ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="N"  onClick="func(this.value)" disabled><fmt:message key="Common.none.label" bundle="${common_labels}"/></td>
							</tr>
						</table>
					</td>
				</tr>


				<%}%>


			<%
			if(patNoCtrl.equals("C"))
			{
			%>

				<tr>
					<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>

						<input type="hidden" name="patCtrlVal" id="patCtrlVal"  value="C">

					<td width="75%" colspan='3'>
						<table>
							<tr>
								<td class="fields" width="60%">
									<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="Z"  checked onClick="func(this.value)" ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>
									<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U" onClick="func(this.value)"> <fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/>	
									<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="N"  onClick="func(this.value)" disabled><fmt:message key="Common.none.label" bundle="${common_labels}"/>
								</td> 
							</tr>
						</table>
					</td>
				</tr>


			<%}
			}
			}
			else
			{
				
			%>
			<script language='javascript'>
			var err=getMessage("NO_RECORDS_FOUND","FM");
			 var err_val=0;	parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err+'&err_value='+err_val;
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<tr>
				<td class="label" width="40%"><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>
				<td class="fields" width="60%"><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value=""  disabled>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>

			</tr>
			<tr>
				<td class="label" width="40%"> </td>
				<td class="fields" width="60%"><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="" disabled>&nbsp;<fmt:message key="Common.none.label" bundle="${common_labels}"/></td>

			</tr>
			<tr>
				<td class="label" width="40%"> </td>
				<td class="fields" width="60%"><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="" disabled>&nbsp;<fmt:message key="Common.none.label" bundle="${common_labels}"/></td>

			</tr>




			<%

			}

			%>
			</tr>

			<tr>
			<td class='label' nowrap><fmt:message key="eMP.CheckDigitScheme.label" bundle="${mp_labels}"/></td>

			 <%
						ArrayList chk_digit_code = new ArrayList();
						ArrayList chk_digit_val = new ArrayList();
						String sql ="select * from mp_check_digit_scheme where scheme_id='VDG' and eff_status='E'";
						Statement stmt11 = con.createStatement() ;
						ResultSet rset11 = stmt11.executeQuery(sql) ;
						if(rset11 != null)
						{
							while(rset11.next())
							{
								chk_digit_code .add(rset11.getString("SCHEME_ID")) ;
								chk_digit_val  .add(rset11.getString("SCHEME_NAME")) ;
							}
						}
                %>
                        <td class="fields">
                              <select name='pat_ser_chk_dig_scheme' id='pat_ser_chk_dig_scheme' onChange='disablePrefix(this)'>
                                <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
                                <%
                                    for(int i=0;i<chk_digit_code.size();i++)
                                    {
										out.println( "<option value='"+chk_digit_code.get(i)+"' >"+chk_digit_val.get(i)+"</option>" ) ;
                                    }
                                %>
                            </select>
                        </td>
						<%
				if (dflt_pat_ser_cnt == 1){
						PreparedStatement prefixstmt=con.prepareStatement("select count(*) from mp_pat_ser_grp where YEAR_PREFIX_REQD_YN='Y'");
						ResultSet prefixrslt=prefixstmt.executeQuery();
						int year_prefix_count=0;
						while(prefixrslt.next()){
							year_prefix_count=prefixrslt.getInt(1);
						}
						if (year_prefix_count==0){
							disable_year_ser_code="";
						}else{						
							disable_year_ser_code="disabled";
						}
									%>
						<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.AutomaticPrefixUpdateforPatientSeries.label" bundle="${mp_labels}"/></td>
						<td width="60%" class="fields"><input type="checkbox" name="year_pat_ser" id="year_pat_ser" value='N' onclick="CallBDYearPrefixSeries();" <%=disable_year_ser_code%>></td>
		<%}
			%>
				<!-- <input type="hidden" name="year_pat_ser" id="year_pat_ser" value=""> -->
			</tr>	
			<%
	}catch(Exception e) { 
		e.printStackTrace();
		//out.println(e.toString());
		}
	%>

		
	
	
	<%
					
				if(genPidUsingAid1RuleYn.equals("Y"))
				{
				  
				%>

				<tr><td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.AltID1RuleforPatNo.label"
				bundle="${mp_labels}"/></td></tr>

				<tr>
				<td class="label" ><fmt:message key="eMP.GeneratePatientIDusingAlternateID1Rule.label"
				bundle="${mp_labels}"/></td>
				
				<td class="fields" ><input type="checkbox" name="gen_pid_using_alt_id1_rule_yn" id="gen_pid_using_alt_id1_rule_yn" value="Y"   onClick="change2();SepAltid();" checked></td>
				
				</tr>
				<tr>
				
				<td class="label"><fmt:message key="eMP.PatNumberingUsing.label"
				bundle="${mp_labels}"/></td>
				<td class="fields">
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="A" checked onClick='chkNumCtl(this);'><fmt:message key="Common.AlternateID.label"
				bundle="${common_labels}"/>1&nbsp;&nbsp;&nbsp;
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="S" onClick='chkNumCtl(this);'><fmt:message key="eMP.SystemGenerated.label"
				bundle="${mp_labels}"/></td>		
				</tr>
				
				<tr>

				<td class="label" ><b><fmt:message key="Common.relationship.label"
				bundle="${common_labels}"/><b></td>
				</tr>
				<tr>
				<td class="label" width='25%'><fmt:message key="eMP.SeparatorValue.label"
				bundle="${mp_labels}"/></td>
				<td class="fields" width='75%'><input type='text' onKeyPress="return CheckForSpecChars1(event);" name='separator_value' id='separator_value' onBlur="ChangeUpperCase(this);makeValidString(this);" size='2' maxlength='1' value='' >
				<img src='../images/mandatory.gif' id='s1'></img></td>
				
				</tr>
				<tr>
				<td class="label" nowrap><fmt:message key="eMP.SeparatorPosition.label"
				bundle="${mp_labels}"/></td>
							
				<td class="fields">
				<select name='separator_position' id='separator_position'>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value="P"><fmt:message key="eMP.prefix.label"
				bundle="${mp_labels}"/>
				<option value="S"><fmt:message key="eMP.Suffix.label"
				bundle="${mp_labels}"/>
				</select>
				<img src='../images/mandatory.gif' id='s2'></img>
				</td>
				</tr>
				
				<%
				  }
				else
				{
				%>
				<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn' value='N'>
				<input type='hidden' name='pid_use_alt_id1_or_sys_gen' id='pid_use_alt_id1_or_sys_gen' >
				<input type='hidden' name='separator_value' id='separator_value' >
				<input type='hidden' name='separator_position' id='separator_position' >
	

				<%
				}
				%>
		<tr><td class="COLUMNHEADER" colspan='4'><fmt:message key="Common.other.label" bundle="${common_labels}"/></td></tr>
			
				

	<%
		
		if(familyNoLink !=null)
		{
			if(familyNoLink.equals("Y"))
			{
		%>
			<tr>
				<td class="label" nowrap><fmt:message key="eMP.ValidforHeadPatientID.label" bundle="${mp_labels}"/></td>
				<td  class="fields"><input type="checkbox" name="family_no_link_yn" id="family_no_link_yn" value="Y" ></td>
			</tr>
		<%
			}
		else
			{
			%>
				<tr>
				<td class="label" nowrap><fmt:message key="eMP.ValidforHeadPatientID.label" bundle="${mp_labels}"/></td>
				<td class="fields"><input type="checkbox" name="family_no_link_yn" id="family_no_link_yn" value="N" disabled></td>
			</tr>
			<%
			}
		}
		if(nameInOthLang !=null)
		{
			if(nameInOthLang.equals("Y"))
			{
		%>	
			<tr>
				<td class="label" width="40%" nowrap><fmt:message key="eMP.PatientNameinLocLang.Required.label" bundle="${mp_labels}"/></td>
				<td width="60%" class="fields"><input type="checkbox" name="name_in_oth_lang_yn" id="name_in_oth_lang_yn" value="Y" ></td>
			</tr>
		<%
			}
			else
			{
			%>	
			<tr>
				<td class="label" width="40%" nowrap><fmt:message key="eMP.PatientNameinLocLang.Required.label" bundle="${mp_labels}"/></td>
				<td width="60%" class="fields"><input type="checkbox" name="name_in_oth_lang_yn" id="name_in_oth_lang_yn" value="N" disabled ></td>
			</tr>
			<%
			
			}
		}
		%>
		<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.EmailNotification.label" bundle="${mp_labels}"/></td>
		<td width="60%" class="fields"><input type="checkbox" name="email_appl_yn" id="email_appl_yn" onblur="enaEmail();" value="" <%=email_chk%> ></td>


		</tr>
		<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.DefaultCardReader.label" bundle="${mp_labels}"/></td>
			<td width="60%" class="fields"><input type="checkbox" name="default_yn" id="default_yn" onblur="enableDefault();" value="N"  <%=default_chk%>></td></tr>
		</table>
	 </td>
    </tr>
</table>





<input type="hidden" name="site_or_facility" id="site_or_facility" >
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='genPidUsingAid1RuleYn1' id='genPidUsingAid1RuleYn1' value='<%=genPidUsingAid1RuleYn%>'>
<input type='hidden' name='patNoCtrl' id='patNoCtrl' value='<%=patNoCtrl%>'>
<input type="hidden" name="dflt_pat_ser_cnt" id="dflt_pat_ser_cnt" value="<%=dflt_pat_ser_cnt%>">

</form>
</center>
</body>
</html>
<%

	}
	}catch(Exception e) { 
		e.printStackTrace();
		//out.println(e.toString());
		}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (rs1 != null) rs1.close();
		if (pstmt1 != null) pstmt1.close();
	}
}catch(Exception e) { 
	e.printStackTrace();
	//out.println(e.toString());
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

