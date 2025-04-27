<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String pat_ser_grp_code = request.getParameter("pat_ser_grp_code");%>
<%
	PreparedStatement  pstmt=null;
	ResultSet rset=null;
	PreparedStatement  pstmt1=null;
	ResultSet rs1=null;
	PreparedStatement  pstmt2=null;
	ResultSet rs2=null;
	PreparedStatement dftstmt=null;
	ResultSet dftrslt =null;
	Connection con=null;
	
	String email_appl_yn1 = "";
	String email_chk = "";
	String default_chk = "";
	String default_yn1 = "";
    String pat_ser_grp_code1="";
    String short_desc="";
    String single_pat_num_yn="";
    String associated_pat_ser_grp_code="";
    String disable_fld="";
String mode="insert";
String family_no_link_yn="";
String year_ser_code="";
String disable_year_ser_code="";
String year_checked="";
int dflt_pat_ser_cnt=0;
try{
//	Connection con=(Connection) session.getValue( "connection" );

	
	con = ConnectionManager.getConnection(request);
	 dftstmt=con.prepareStatement("select count(*) from mp_pat_ser_grp where DEFAULT_YN='Y' and pat_ser_grp_code=? ");
	 dftstmt.setString(1, pat_ser_grp_code); // added by lakshmanan for security issue ID 174086822 on 08-08-2023
	dftrslt=dftstmt.executeQuery();
	int default_count=0;
	while(dftrslt.next()){
	default_count=dftrslt.getInt(1);
	}
	if (dftrslt != null)
	dftrslt.close();
	if(dftstmt != null)
	dftstmt.close();	
	dftstmt=con.prepareStatement("select count(*) from mp_pat_ser_grp where DEFAULT_YN='Y'");
	dftrslt=dftstmt.executeQuery();
	int default_count_all=0;
	while(dftrslt.next()){
	default_count_all=dftrslt.getInt(1);
	}	
	if (dftrslt != null)
	dftrslt.close();
	if(dftstmt != null)
	dftstmt.close();		
	String sql = "select pat_ser_grp_code, long_desc, short_desc, scheme_id, gen_pat_id_yn, prefix_reqd_yn, pat_no_ctrl, id_type,allow_family_no_yn,pat_name_in_loc_lang_reqd_yn,gen_pid_using_alt_id1_rule_yn,separator_value,separator_position,pid_use_alt_id1_or_sys_gen,email_appl_yn,associated_pat_ser_grp_code,YEAR_PREFIX_REQD_YN,default_yn  from mp_pat_ser_grp where pat_ser_grp_code=? ";
	
	pstmt1 = con.prepareStatement("SELECT COUNT (*) dflt_lang_appl_cnt  FROM sm_site_param a, sm_function_control b WHERE a.customer_id = b.site_id   AND module_id = 'MP'   AND functionality_id = 'AUTO_PAT_SERIES'");

	rs1=pstmt1.executeQuery();

	while(rs1.next())
	{
		dflt_pat_ser_cnt=rs1.getInt(1);
	}%>
	
	<%

	if (pstmt1 != null)
		pstmt1.close();
	if (rs1 != null)
		rs1.close();

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,pat_ser_grp_code); // added by lakshmanan for security issue ID 174091927 on 08-08-2023
	rset = pstmt.executeQuery();
	
	if(rset!=null && rset.next()) {
		mode="modify";
		associated_pat_ser_grp_code = rset.getString("associated_pat_ser_grp_code")==null?"":rset.getString("associated_pat_ser_grp_code");
		default_yn1=rset.getString("default_yn");		

		if(default_yn1.equals("Y") && default_count==1)
			default_chk = "checked ";
		else if(default_yn1.equals("N") && default_count==0 && default_count_all==0)
			default_chk = "unchecked ";
		else
			default_chk = "unchecked disabled";
		
		/*	if (default_count==0){
		default_chk="";
	}else{						
		default_chk="disabled";
	}
	*/
		/*year_ser_code=rset.getString("YEAR_PREFIX_REQD_YN");	 
		if (year_ser_code.equals("Y"))
		 {			
			year_ser_code="checked";						
		 }
		 else
		 {
			year_ser_code="";
		 }*/
	}	

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumbering.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
	function func(val)
	{
		if(val=="S")
			patientnumbering_form.site_or_facility.value="S";
		if(val=="F")
			patientnumbering_form.site_or_facility.value="F";

		//parent.fr_pat_num_com.location.href="/eCIS/mp/jsp/addPatientNumbercommon.jsp?numctrl="+val;

	}



	function change()
	{
		 if(patientnumbering_form.gen_pat_id_yn.value == 'Y')
		{
			if(patientnumbering_form.patCtrlVal1.value =="U")
			{
				patientnumbering_form.pat_no_ctrl.item(1).disabled = false;
				patientnumbering_form.pat_no_ctrl.item(1).checked = true;
				patientnumbering_form.pat_no_ctrl.item(0).disabled = true;
				patientnumbering_form.pat_no_ctrl.item(2).disabled= true;

			}
			if(patientnumbering_form.patCtrlVal1.value =="Z")
			{
				patientnumbering_form.pat_no_ctrl.item(0).disabled = false;
				patientnumbering_form.pat_no_ctrl.item(0).checked = true;
				patientnumbering_form.pat_no_ctrl.item(1).disabled = true;
				patientnumbering_form.pat_no_ctrl.item(2).disabled= true;

			}
			if(patientnumbering_form.patCtrlVal1.value =="C")
			{
				patientnumbering_form.pat_no_ctrl.item(1).disabled = false;
				//patientnumbering_form.pat_no_ctrl.item(1).checked = true;
				patientnumbering_form.pat_no_ctrl.item(0).disabled = false;
				patientnumbering_form.pat_no_ctrl.item(2).disabled= true;
			}
		}
	}

</script>
</head>


<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' OnLoad="FocusFirstElement()">
<form name="patientnumbering_form" id="patientnumbering_form" action="../../servlet/eMP.PatientNumberingServlet" method="post" target="messageFrame">
<%
		
		pstmt1 = con.prepareStatement("select EMAIL_APPL_YN from sm_installation");
		rs1= pstmt1.executeQuery();

		if(rs1.next())
		{
			email_appl_yn1=rs1.getString("EMAIL_APPL_YN");			
		}
		
		if(!associated_pat_ser_grp_code.equals("") || email_appl_yn1.equals("N"))
			email_chk = "disabled";
		else
			email_chk = "";		

		if ( pstmt1 != null ) pstmt1.close() ;
		if ( rs1 != null ) rs1.close() ;
		
		
		String familyNoLink="";
		String nameInOthLang="";
		String genPidUsingAid1RuleYn="";
		
			pstmt1 = con.prepareStatement("select family_no_link_yn,names_in_oth_lang_yn,gen_pid_using_aid1_rule_yn,single_patient_numbering_yn from mp_param");
			rs1= pstmt1.executeQuery();
			//rs=stmt.executeQuery("select * from mr_section");

			if (rs1.next())
			{
				familyNoLink=rs1.getString("family_no_link_yn");
				nameInOthLang=rs1.getString("names_in_oth_lang_yn");
				genPidUsingAid1RuleYn=rs1.getString("gen_pid_using_aid1_rule_yn");
				single_pat_num_yn=rs1.getString("single_patient_numbering_yn");
				//String patNoCtrl=rs.getString("MR_SECTION_CODE");
			}

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
				<BR><BR><BR><BR>
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
<center>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
   <tr>
	<td class="NONE" width="70%">
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>

		<tr>
				<td class="label"><fmt:message key="eMP.SeriesType.label" bundle="${mp_labels}"/><input type='hidden' name='function' id='function' value='modify'></td>
				
				<%
				out.println("<td class='fields'  width='60%' ><select name='id_type1' id='id_type1' disabled>");
				String id_type= rset.getString("id_type")==null?"":rset.getString("id_type");
					if (id_type.equals(""))
						{
						out.println("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</Option>");
						}
					else 
						if  ( id_type.equals("G") )
 						{
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
 						}
 					else
 						if(id_type.equals("N"))
 						{
 						out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
 						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}
 					else
 						if(id_type.equals("A"))
 						{

 						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}

 					else
 						if(id_type.equals("B"))
 						{

						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}

 					else
 						if(id_type.equals("E"))
 						{

						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}
					else	if(id_type.equals("U"))
 						{
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");						
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}
					else	if(id_type.equals("X"))
 						{
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");						
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						}
					else	if(id_type.equals("R"))
 						{
						out.println("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+"</Option>");				
						out.println("<option value='X'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+"</Option>");						
						out.println("<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+"</Option>");
						out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+"</Option>");
						out.println("<option value='B'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+"</Option>");
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+"</Option>");
 						out.println("<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+"</Option>");
				 		out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels")+"</Option>");
						}
						out.println("</select> </td>");
 						out.println("<input type='hidden' name='id_type' id='id_type'  value='"+id_type+"'>");
				%>
				</TR>	





			<tr>
				<td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<%
				out.println("<td class='fields'><input type='text' name='pat_ser_grp_code' id='pat_ser_grp_code' size='2' maxlength='3' value='"+rset.getString("pat_ser_grp_code")+"' readonly>");
				out.println("<img src='../images/mandatory.gif'></img></td>");
			%>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>

			<%
				out.println("<td class='fields'> <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this);' value=\""+rset.getString("long_desc")+"\">");
				out.println("<img src='../images/mandatory.gif'></img></td>");
			%>

			</tr>

			<tr>
				<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<%
				out.println("<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this);' value=\""+rset.getString("short_desc")+"\">");
				out.println("<img src='../images/mandatory.gif'></img></td>");
			%>
			</tr>			
			<tr><td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.PatientIDGenerationRule.label" bundle="${mp_labels}"/></tr>
			<tr>
		<td class='label' nowrap><fmt:message key="eMP.AssociatedNoSeries.label"  bundle="${mp_labels}"/></td>
					 <td class="fields">
				<select name='associ_num_series' id='associ_num_series' onChange='disablePrefix1(this)'  <%if(single_pat_num_yn.equals("N")){ %> disabled  <%}%> >
                                <option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				
		<% 	

				if(!associated_pat_ser_grp_code.equals(""))
					disable_fld = "disabled";
				else	
					disable_fld = "";

				String sql1="select pat_ser_grp_code,short_desc,scheme_id from mp_pat_ser_grp where ((gen_pat_id_yn='Y' and pat_no_ctrl in ('Z','U')) or GEN_PID_USING_ALT_ID1_RULE_YN='Y') and associated_pat_ser_grp_code is null order by short_desc" ;
				
				
				pstmt2 = con.prepareStatement(sql1);
				 
				rs2= pstmt2.executeQuery();
        	     while (rs2.next())           
		         {
					pat_ser_grp_code1=rs2.getString("pat_ser_grp_code");
					if(pat_ser_grp_code==null) pat_ser_grp_code="";
					short_desc=rs2.getString("short_desc");

		            if(short_desc==null) short_desc="";

					if(associated_pat_ser_grp_code.equals(pat_ser_grp_code1))
						out.println( "<option value='" +pat_ser_grp_code1+ "' selected>" +short_desc) ;
					else
						out.println( "<option value='" +pat_ser_grp_code1+ "' >" +short_desc) ;					
						
				 }
	%>
				   </select>
                        </td>
				</tr>
					
			  </tr>

			  <tr>
				<td class="label"><fmt:message    key="eMP.GeneratePatientID.label" bundle="${mp_labels}"/></td>
        		 <%
				 out.println("<td class='fields'><input type='checkbox'   name='gen_pat_id_yn' id='gen_pat_id_yn' value='Y'") ;
			     	String gen_pat_id_yn1= rset.getString("gen_pat_id_yn");

				  	if  ( gen_pat_id_yn1.equals("Y") )
						out.println("checked disabled>");
					else
						out.println("&nbsp; disabled>");
						out.println("</td>");

						out.println("<input type='hidden' name='gen_pat_id_yn1' id='gen_pat_id_yn1'  value='"+gen_pat_id_yn1+"'>");
				     %>
			
			
			         </tr>
			
			
			
			<tr>
				<td class="label"><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></td>

				<%

				String prefix_reqd_yn= rset.getString("prefix_reqd_yn");

				out.println("<td class='fields'><input type='checkbox' name='prefix_reqd_yn' id='prefix_reqd_yn' value='"+prefix_reqd_yn+"'") ;
				

					if  ( prefix_reqd_yn.equals("Y") )
						out.println("checked disabled>");
					else
						out.println(" disabled>");
						out.println("</td>");						

				%>
			</tr>

			<tr>
				
			

			<%
				String pat_no_ctrl2= rset.getString("pat_no_ctrl");

				if(pat_no_ctrl2.equals("Z"))
				{
			%>
					<input type="hidden" name="patCtrlVal1" id="patCtrlVal1"  value="Z">
					
						<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>

						<td width="75%" colspan='3'>
						<table>
						<tr>
						<td class='fields'><input type='Radio' name='pat_no_ctrl' id='pat_no_ctrl' value='Z' checked ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>
						
					
						<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U"   disabled ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/>
						

					
						
						<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="C" disabled ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.none.label" bundle="${common_labels}"/>
						</td>
						</tr>
						</table>
						</td>

			</tr>


			<%}%>

			<%
				if(pat_no_ctrl2.equals("U"))
				{
			%>
					<input type="hidden" name="patCtrlVal1" id="patCtrlVal1"  value="U">

				 
					<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>
					<td width="75%" colspan='3'>
						<table>
						<tr>
					<td class='fields'><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="Z"  onClick="func(this.value)" disabled><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>
					 

				 
					 
					 <input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U" checked onClick="func(this.value)" ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/>
					 

				 	 
					<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="C"  onClick="func(this.value)" disabled><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.none.label" bundle="${common_labels}"/>
					</td>
					</tr>
					</table>
					

				</tr>


			<%}%>


			<%
				if(pat_no_ctrl2.equals("N"))
				{
			%>

				<input type="hidden" name="patCtrlVal1" id="patCtrlVal1"  value="C">

				 
					<td class="label" width='25%'><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>
					<td width="75%" colspan='3'>
					<table>
					<tr>
					<td class='fields'><input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="Z"  disabled ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Site.label" bundle="${common_labels}"/>
				 
					 
					<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="U" disabled><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/>
					 
					 
					<input type="Radio" name="pat_no_ctrl" id="pat_no_ctrl" value="N" checked ><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.none.label" bundle="${common_labels}"/>
					</td>
					</tr>
					</table>
					</td>

				</tr>
			
			<% }%>
<tr>
			<td class='label' ><fmt:message key="eMP.CheckDigitScheme.label" bundle="${mp_labels}"/></td>
			 <%
						ArrayList chk_digit_code = new ArrayList();
						ArrayList chk_digit_val = new ArrayList();
						sql ="select * from mp_check_digit_scheme where scheme_id='VDG' and eff_status='E'";
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
                              <select name='pat_ser_chk_dig_scheme' id='pat_ser_chk_dig_scheme' onChange='disablePrefix(this)' disabled>
                                <option value=''>------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
                                <%
									String SchemeId =  checkForNull(rset.getString("scheme_id"));
                                    for(int i=0;i<chk_digit_code.size();i++)
                                    {
										 String sel = "" ;
                                        if(SchemeId.equals((String)chk_digit_code.get(i)))
                                          sel = "selected";
										out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
                                    }
                                %>
                            </select>
                        </td>

						<%
						if (dflt_pat_ser_cnt == 1)	{
							year_ser_code=rset.getString("YEAR_PREFIX_REQD_YN");	 
							PreparedStatement prefixstmt=con.prepareStatement("select count(*) from mp_pat_ser_grp where YEAR_PREFIX_REQD_YN='Y'");
							ResultSet prefixrslt=prefixstmt.executeQuery();
							int year_prefix_count=0;
							while(prefixrslt.next())
							{
								year_prefix_count=prefixrslt.getInt(1);
							}

							if (year_prefix_count==0)
							{
								disable_year_ser_code="";
							}
							else
							{						
								disable_year_ser_code="disabled";
							}
							if (year_ser_code.equals("Y"))
							{
								year_checked="checked";
							}
							%>
						<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.AutomaticPrefixUpdateforPatientSeries.label" bundle="${mp_labels}"/></td>
						<td width="60%" class="fields"><input type="checkbox" name="year_pat_ser" id="year_pat_ser" value='N' onclick="CallBDYearPrefixSeries();" <%=year_checked%> <%=disable_year_ser_code%> ></td><%}%>
			</tr>
			
			
			
			
			
			<%
				
					
				if(genPidUsingAid1RuleYn.equals("Y"))
				{
				
				%>

			<tr><td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.AltID1RuleforPatNo.label"
				bundle="${mp_labels}"/></td></tr>
			<tr>
				<td class="label" ><fmt:message key="eMP.GeneratePatientIDusingAlternateID1Rule.label"
				bundle="${mp_labels}"/></td>
				<%
				out.println("<td class='fields'><input type='checkbox' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn' value='Y'") ;
				String gen_pid_using_alt_id1_rule_yn= checkForNull(rset.getString("gen_pid_using_alt_id1_rule_yn"));

					if  ( gen_pid_using_alt_id1_rule_yn.equals("Y") )
						out.println("checked disabled>");
					else
						out.println("&nbsp; disabled>");
						out.println("</td>");

						out.println("<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn'  value='"+gen_pid_using_alt_id1_rule_yn+"'>");
				%>
			</tr>
			<tr>
				
				<td class="label"><fmt:message key="eMP.PatNumberingUsing.label"
				bundle="${mp_labels}"/></td>
				<%
				String pid_use_alt_id1_or_sys_gen= checkForNull(rset.getString("pid_use_alt_id1_or_sys_gen"));
				out.println("<input type='hidden' name='pid_use_alt_id1_or_sys_gen' id='pid_use_alt_id1_or_sys_gen'  value='"+pid_use_alt_id1_or_sys_gen+"'>");
				if(pid_use_alt_id1_or_sys_gen.equals("A"))
				{
			%>

				<td class="fields" >
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="A" checked ><fmt:message key="Common.AlternateID.label"
				bundle="${common_labels}"/>1&nbsp;&nbsp;&nbsp;
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="S" disabled><fmt:message key="eMP.SystemGenerated.label"
				bundle="${mp_labels}"/></td>

			<%
				}
				else if(pid_use_alt_id1_or_sys_gen.equals("S"))
				{	
			%>
			   <td class="fields" >
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="A" disabled><fmt:message key="Common.AlternateID.label"
				bundle="${common_labels}"/>1&nbsp;&nbsp;&nbsp;
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="S" checked><fmt:message key="eMP.SystemGenerated.label"
				bundle="${mp_labels}"/></td>


			<%
				}
				else
				{
			%>
			<td class="fields" >
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="A" disabled><fmt:message key="Common.AlternateID.label"
				bundle="${common_labels}"/>1&nbsp;&nbsp;&nbsp;
				<input type="Radio" name="pid_use_alt_id1_or_sys_gen" id="pid_use_alt_id1_or_sys_gen" value="S" disabled><fmt:message key="eMP.SystemGenerated.label"
				bundle="${mp_labels}"/></td>
			<%
				}
			%>

			</tr>
			<tr>

				<td class="label" ><b><fmt:message key="Common.relationship.label"
				bundle="${common_labels}"/><b></td>
			</tr>
			<tr>
			<td class="label"><fmt:message key="eMP.SeparatorValue.label"
				bundle="${mp_labels}"/></td>
							
				<td class='fields'>

				<%
					String separator_value=rset.getString("separator_value")==null?"":rset.getString("separator_value");
				
				if(!separator_value.equals(""))
				{
					out.println("<input type='text' name='separator_value' id='separator_value' size='4' maxlength='2' value='"+separator_value+"' disabled>");
					out.println("<img src='../images/mandatory.gif'></img>");
				}
				else
					out.println("<input type='text' name='separator_value' id='separator_value' size='4' maxlength='2' value='"+separator_value+"' disabled>");

				out.println("<input type='hidden' name='separator_value' id='separator_value'  value='"+separator_value+"'>");


				
			%>
			
			</td>
			</tr>
			<tr>
			<td class="label" nowrap><fmt:message key="eMP.SeparatorPosition.label"
				bundle="${mp_labels}"/></td>
				<td class='fields'>
				<select name='separator_position' id='separator_position' disabled>
                
				<%
				String temp="";
				String separator_position=rset.getString("separator_position")==null?"":rset.getString("separator_position");
				if(separator_position.equals("P"))
				{
					temp="Prefix";
				   out.println("<option value='"+temp+"' "+"selected>"+temp +"</option>");
				   out.println("</select><img src='../images/mandatory.gif'></img>");
				}
				else if(separator_position.equals("S"))
				{
					temp="Suffix";
					out.println("<option value='"+temp+"' "+"selected>"+temp +"</option>");
					out.println("</select><img src='../images/mandatory.gif'></img>");
				}
				else
				{
					 out.println("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</Option>");
					 
				}
				out.println("<input type='hidden' name='separator_position' id='separator_position'  value='"+separator_position+"'>");

				%>
				
				
			
				</td>
			
			</tr>
			<%
				}
			else
			{
				String gen_pid_using_alt_id1_rule_yn= checkForNull(rset.getString("gen_pid_using_alt_id1_rule_yn"));

				out.println("<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn'  value='"+gen_pid_using_alt_id1_rule_yn+"'>");

				String pid_use_alt_id1_or_sys_gen= checkForNull(rset.getString("pid_use_alt_id1_or_sys_gen"));
				out.println("<input type='hidden' name='pid_use_alt_id1_or_sys_gen' id='pid_use_alt_id1_or_sys_gen'  value='"+pid_use_alt_id1_or_sys_gen+"'>");

				String separator_value=rset.getString("separator_value")==null?"":rset.getString("separator_value");
				out.println("<input type='hidden' name='separator_value' id='separator_value'  value='"+separator_value+"'>");
				
				String separator_position=rset.getString("separator_position")==null?"":rset.getString("separator_position");
				out.println("<input type='hidden' name='separator_position' id='separator_position'  value='"+separator_position+"'>");
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


			<%
				out.println("<td class='fields'><input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='Y' ") ;
				 family_no_link_yn= rset.getString("allow_family_no_yn");

					if  (family_no_link_yn.equals("Y"))
						out.println("checked ");

					if(!associated_pat_ser_grp_code.equals("") || family_no_link_yn.equals("N")) {
						out.println("disabled ");
					}
								
					out.println("></td>");

						
						//out.println("<input type='hidden' name='family_no_link_yn' id='family_no_link_yn'  //value=''>");
			%>
			</tr>

			<%
			}
			else
			{
				%>
			<tr>
			<td class="label" nowrap><fmt:message key="eMP.ValidforHeadPatientID.label" bundle="${mp_labels}"/></td>


			<%
				out.println("<td class='fields'><input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='N' ");
				 family_no_link_yn= rset.getString("allow_family_no_yn");

					if(!associated_pat_ser_grp_code.equals("") || family_no_link_yn.equals("N")) {
						out.println("disabled ");
					}

					if(family_no_link_yn.equals("Y"))
						out.println("checked ");
					
					out.println("></td>");						
			%>
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
			<td class="label" nowrap><fmt:message key="eMP.PatientNameinLocLang.Required.label" bundle="${mp_labels}"/></td>
			<%
					String name_in_oth_lang_yn= rset.getString("pat_name_in_loc_lang_reqd_yn");

					out.println("<td class='fields'><input type='checkbox' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn'") ;		

					if(!associated_pat_ser_grp_code.equals("") || name_in_oth_lang_yn.equals("N")) {
						out.println("disabled");
					}

					if (name_in_oth_lang_yn.equals("Y"))
						out.println(" checked value='Y' >");
					else
						out.println(" value='N'>");					

					out.println("</td>");

						out.println("<input type='hidden' name='name_in_oth_lang_yn1' id='name_in_oth_lang_yn1'  value='"+name_in_oth_lang_yn+"'>");
						//out.println("<input type='hidden' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn'  //value=''>");


				%>
				</tr>
			
				<%
				}
				else
				{
			%>	
			<tr>
			<td class="label" nowrap><fmt:message key="eMP.PatientNameinLocLang.Required.label" bundle="${mp_labels}"/></td>
			<%
				String name_in_oth_lang_yn= rset.getString("pat_name_in_loc_lang_reqd_yn");

				out.println("<td class='fields'><input type='checkbox' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn' ") ;

				if(!associated_pat_ser_grp_code.equals("") || name_in_oth_lang_yn.equals("N")) {
					out.println("disabled");
				}				

				if(name_in_oth_lang_yn.equals("Y"))
					out.println(" checked value='Y'>");
				else
					out.println(" value='N'>");				

				out.println("</td>");

						//out.println("<input type='hidden' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn'  //value='"+name_in_oth_lang_yn+"'>");
						//out.println("<input type='hidden' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn'  //value=''>");


				%>
				</tr>
			
				<%

				}

			}
			%>
			<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.EmailNotification.label" bundle="${mp_labels}"/></td>
			<%
					String email_appl_yn2= rset.getString("email_appl_yn");

					out.println("<td class='fields'><input type='checkbox' name='email_appl_yn' id='email_appl_yn'");				
					
					if( email_appl_yn2.equals("Y"))
						out.println(" value='Y' checked "+email_chk+">");
					 else
						out.println(" value='N' unchecked "+email_chk+">");
     					out.println("</td>");
											
			%>

			</tr>
				<tr><td class="label" width="40%" nowrap><fmt:message key="eMP.DefaultCardReader.label" bundle="${mp_labels}"/></td>
		<td width="60%" class="fields"><input type="checkbox" name="default_yn" id="default_yn" onblur="enableDefault();" value="<%=default_yn1%>" <%=default_chk%> ></td></tr>
		</table>
	 </td>
    </tr>
</table>



<input type="hidden" name="site_or_facility" id="site_or_facility"  value="N">
<input type="hidden" name="function_name" id="function_name" value='<%=mode%>'>
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='genPidUsingAid1RuleYn1' id='genPidUsingAid1RuleYn1' 
value='<%=genPidUsingAid1RuleYn%>'>
<input type='hidden' name='prefix_reqd_yn1' id='prefix_reqd_yn1' 
value='<%=prefix_reqd_yn%>'>
<input type='hidden' name='email_appl_yn1' id='email_appl_yn1' 
value='<%=email_appl_yn2%>'>
<input type='hidden' name='family_no_link_yn1' id='family_no_link_yn1' 
value='<%=family_no_link_yn%>'>
<input type='hidden' name='associated_pat_ser_grp_code1' id='associated_pat_ser_grp_code1' 
value='<%=associated_pat_ser_grp_code%>'>
<input type="hidden" name="dflt_pat_ser_cnt" id="dflt_pat_ser_cnt" value="<%=dflt_pat_ser_cnt%>">

</form>
</center>

<%
}
catch ( Exception e )
{
	e.printStackTrace();
	// out.println(e.toString()); 
}
finally{
		if ( rset != null ) rset.close() ;
		if ( rs1!=null) rs1.close();
		if ( pstmt != null ) pstmt.close() ;
		if ( pstmt1 != null ) pstmt1.close() ;
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>

</body>
</html>

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

