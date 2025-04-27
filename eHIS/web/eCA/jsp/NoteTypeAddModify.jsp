<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
11/11/2011   IN028710      Chowminya G    Incident No: IN028710 - <file upload issue for procedure notes> 
24/02/2012	 IN031116	  Ramesh G	  Report header is overlapping the hospital letter heads & deliverable.
06/02/2013	IN037675		Dinesh T		IN037675
04/03/2013	IN037676		Dinesh T		Signing the addendum is controlled by the note type parameter
14/08/2015	IN052376	Ramesh G	MMS-RY-CRF-0012 [IN:052376]
-----------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------
Date        Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------------------------------
26/08/2016   IN059489        Raja S									   Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
13/12/2022	37958			Ramesh Goli		ML-MMOH-CRF-1977
--------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/NoteType.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement pstmt=null,pstmt1=null;
ResultSet rs=null,rs1=null;
String chkstr="disabled";

String sql1="";
String sql="";
String dis1="";
String mode="";
String sel="";
String status="";
String note_group_id="";
String note_type="";
String note_type_desc="";
String event_class="";
String disclimer_code1="";
String inpatient_yn="";
String outpatient_yn="";
String serv_facl_spec_yn="";
String doc_link_note="";
String note_group_desc="";
String note_grp="";

String publish_level="";
String banner_ind="";
String ammendment_type="";


String event_type_caption="Note Type";
String event_date_caption="Date/Time";
String event_status_caption="Note Status";
String event_title_caption="Note Title";
String event_perf_by_caption="Performed By";
String event_auth_by_caption="Authorized By";

String enabled_checked="checked";
String confidential_yn="N";
String eff_status ="" ;
String confidential_checked ="unchecked";
String license_rights = "";
String dc_status = "";
String em_status = "";
String em_flag = "";
String dc_flag = "";
//String note_logo_id = "";
String report_header_code = "";
String note_header_code = "";
String footer_code = "";
String note_header_margin = "";//[IN031116]
String note_footer_margin = "";//[IN031116]
String hdfo_margin	="";//[IN031116]
String print = "";
String watermark_flg="N";  //IN059489
String watermark_checked=""; //IN059489

StringBuffer sb_created_notes = new StringBuffer();

//only used for MINI CA
String created_ip_notes="";
String created_op_notes="";
String created_tot_notes="";
String status_check="N";
String patient_specific_yn="";
String print_logo_header = "";
String print_checked = "checked";
String print_val = "Y";
String print_txt_logo_header =""; //[IN032210]
String print_txt_checked = "checked"; //[IN032210]
String print_txt_val = "Y";			//[IN032210]
String checkedConfirm = "";
String checkedDirectly = "";
String checkedNone = "checked";
//IN037675, starts
String fac_level = "";
String spec_level = "";

//----------

String allPracChecked = "";
String allSpecChecked = "";

String facPracChecked = "";
String facSpecChecked = "";

String promPracChecked = "";
String promSpecChecked = "";
//IN037675, ends

String signAddendumChecked = "checked";//IN037676
String signAddendumOth = "";//IN037676
String signAddendumValue = "Y";//IN037676
mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
note_type	=(request.getParameter("note_type")==null)?"":request.getParameter("note_type"); 
boolean isClinician=false;//IN067236



	try
	{
		//out.println("LICENCE KEY : "+(eCA._ca_license_rights.getKey()).equals("CACLDC"));
		//license_rights = ( (eCA._ca_license_rights.getKey()).equals("CACLDC") ) ? "FULL" : "BASIC";
		if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
		{
			license_rights= "FULL";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
		{
			license_rights= "BASIC";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
		{
			license_rights= "MINI";
		}
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			//sql ="select * from ca_note_type where note_type='"+ note_type + "'" ;//common-icn-0180
			sql ="select * from ca_note_type where note_type=?" ;//common-icn-0180
			
			stmt=con.prepareStatement(sql,   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, note_type);//common-icn-0180
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				note_group_id=(rs.getString("note_group_id")== null)? "":rs.getString("note_group_id"); 
				note_type=(rs.getString("note_type")== null)? "":rs.getString("note_type");             
				note_type_desc=(rs.getString("note_type_desc")== null)? "":rs.getString("note_type_desc");
				event_class=(rs.getString("event_class")== null)? "":rs.getString("event_class");
														  
				inpatient_yn=(rs.getString("inpatient_yn")== null)? "":rs.getString("inpatient_yn");
				outpatient_yn=(rs.getString("outpatient_yn")== null)? "":rs.getString("outpatient_yn");
				serv_facl_spec_yn=(rs.getString("serv_facl_spec_yn")== null)? "":rs.getString("serv_facl_spec_yn");

				doc_link_note=(rs.getString("DOC_LINKED_NOTE_YN")== null)? "":rs.getString("DOC_LINKED_NOTE_YN");
										  
				publish_level=(rs.getString("publish_level")== null)? "":rs.getString("publish_level");         
				banner_ind=(rs.getString("banner_ind")== null)? "":rs.getString("banner_ind");            
				ammendment_type=(rs.getString("ammendment_type")== null)? "":rs.getString("ammendment_type");
										  
				event_type_caption=(rs.getString("event_type_caption")== null)? "":rs.getString("event_type_caption");    
				event_date_caption=(rs.getString("event_date_caption")== null)? "":rs.getString("event_date_caption");    
				event_status_caption=(rs.getString("event_status_caption")== null)? "":rs.getString("event_status_caption");  
				event_title_caption=(rs.getString("event_title_caption")== null)? "":rs.getString("event_title_caption");   
				event_perf_by_caption=(rs.getString("event_perf_by_caption")== null)? "":rs.getString("event_perf_by_caption"); 
				event_auth_by_caption=(rs.getString("event_auth_by_caption")== null)? "":rs.getString("event_auth_by_caption"); 
				eff_status=(rs.getString("eff_status")== null)? "":rs.getString("eff_status"); 
				dc_status = rs.getString("daycare_YN") == null ? "" : rs.getString("daycare_YN");
				em_status= rs.getString("EMERGENCY_YN") == null ? "" : rs.getString("EMERGENCY_YN");
				patient_specific_yn= rs.getString("patient_specific_yn") == null ? "" : rs.getString("patient_specific_yn");
				disclimer_code1=(rs.getString("DISCLIMER_CODE")== null)? "":rs.getString("DISCLIMER_CODE");
				confidential_yn=(rs.getString("confidential_yn")== null)? "":rs.getString("confidential_yn"); 
//				note_logo_id=(rs.getString("note_logo_id")== null)? "":rs.getString("note_logo_id"); 
				report_header_code=(rs.getString("REPORT_HEADER_CODE")== null)? "":rs.getString("REPORT_HEADER_CODE");
				note_header_code=(rs.getString("NOTE_HEADER_CODE")== null)? "":rs.getString("NOTE_HEADER_CODE");
				footer_code=(rs.getString("FOOTER_CODE")== null)? "":rs.getString("FOOTER_CODE");
				print_logo_header=(rs.getString("PRINT_LOGO_HEADER_YN")== null)? "":rs.getString("PRINT_LOGO_HEADER_YN");
				print_txt_logo_header = (rs.getString("PRINT_TEXT_HDR_YN")== null)? "":rs.getString("PRINT_TEXT_HDR_YN");//[IN032210]
			    print=(rs.getString("PRINT_NOTES_ON_SIGN")== null)? "":rs.getString("PRINT_NOTES_ON_SIGN");	
				note_header_margin=(rs.getString("HDR_MARGIN_IN_INCH")== null)? "":rs.getString("HDR_MARGIN_IN_INCH");	//[IN031116]
				note_footer_margin=(rs.getString("FT_MARGIN_IN_INCH")== null)? "":rs.getString("FT_MARGIN_IN_INCH");	//[IN031116]
				//IN037675, starts
				fac_level = rs.getString("FWD_PRACT_IND")==null?"":rs.getString("FWD_PRACT_IND");
				spec_level = rs.getString("FWD_SPLTY_IND")==null?"":rs.getString("FWD_SPLTY_IND");
				//IN037675, ends
				signAddendumOth = rs.getString("SIGN_ADDENM_OTH_YN")==null?"":rs.getString("SIGN_ADDENM_OTH_YN");//IN037676
				//IN059489  starts
				watermark_flg	=(rs.getString("WATERMARK_YN")==null)?"":rs.getString("WATERMARK_YN");
				 	if(watermark_flg.equals("Y"))
						watermark_checked="checked";
				 	else
						watermark_checked="";
				//IN059489  ends
                if(print.equals("C"))
                  {
	                 checkedConfirm = " checked ";
	                 checkedDirectly = "";
                     checkedNone = "";
                  }
               else if(print.equals("D"))
                 {
	                checkedConfirm = "";
	                checkedDirectly = " checked ";
	                checkedNone = "";
                 }
              else if(print.equals("N"))
               {
	              checkedConfirm = "";
	              checkedDirectly = "";
	              checkedNone = "checked";
               }
				
				if(dc_status.equals("Y"))
				{
					dc_flag= "checked";
				}
				if(em_status.equals("Y"))
				{
					em_flag= "checked";
				}
				
				
				if(eff_status.equals("E"))
					enabled_checked="checked";
				else
				{
					enabled_checked="";
					dis1="disabled";
				}
				if(confidential_yn.equals("Y"))
				{
					confidential_checked="checked";
				}
				else
				{
					confidential_checked="N";
				
				}

				//IN037675, starts
				if(fac_level.equals("A"))
				{
					allPracChecked = "checked";
					facPracChecked = "";
					promPracChecked = "";
				}

				if(fac_level.equals("F"))
				{
					allPracChecked = "";
					facPracChecked = "checked";
					promPracChecked = "";
				}

				if(fac_level.equals("P"))
				{
					allPracChecked = "";
					facPracChecked = "";
					promPracChecked = "checked";
				}

				if(spec_level.equals("A"))
				{
					allSpecChecked = "checked";
					facSpecChecked = "";
					promSpecChecked = "";
				}


				if(spec_level.equals("F"))
				{
					allSpecChecked = "";
					facSpecChecked = "checked";
					promSpecChecked = "";
				}


				if(spec_level.equals("P"))
				{
					allSpecChecked = "";
					facSpecChecked = "";
					promSpecChecked = "checked";
				}
				//IN037676, starts
				if(signAddendumOth.equals("Y"))
				{
					signAddendumChecked = "checked";
					signAddendumValue = "Y";
				}
				else if(signAddendumOth.equals("N"))
				{
					signAddendumChecked = "";
					signAddendumValue = "N";
				}
				//IN037676, ends

			}
			if(rs!=null) { rs.close(); rs=null; }
			if(stmt!=null) { stmt.close(); stmt=null; }
		}
		else
		{
			allPracChecked = "checked";
			allSpecChecked = "checked";
		}
		//IN037675, ends

		if(license_rights.equals("BASIC"))
		{
			String sql_allowed_notes = "select distinct event_class from ca_note_type where event_class in ('REF$','NTF$')";
			 pstmt = con.prepareStatement(sql_allowed_notes);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sb_created_notes.append(rs.getString("event_class")+"|");
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			sql_allowed_notes="select count(*) total FROM CA_NOTE_TYPE where event_class in ('PHY$')";
			pstmt = con.prepareStatement(sql_allowed_notes);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				created_tot_notes=String.valueOf(rs.getInt(1));
			}
		}

		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(license_rights.equals("MINI"))
		{
			//String sql_allowed_notes = "select count(*) from ca_note_type where event_class in ('PHY$')";
			String sql_allowed_notes="select SUM(decode(INPATIENT_YN,'Y',1,0)) Ip_cnt,SUM(decode(OUTPATIENT_YN,'Y',1,0)) op_cnt,count(*) total FROM CA_NOTE_TYPE where event_class in ('PHY$')";
			 pstmt = con.prepareStatement(sql_allowed_notes);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				created_ip_notes=String.valueOf(rs.getInt(1));
				created_op_notes=String.valueOf(rs.getInt(2));
				sb_created_notes.append(rs.getInt(3));
			}
			// out.println("OP"+created_op_notes);
 			// out.println("IP"+created_ip_notes);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(!mode.equals("insert"))
	{
			stmt=con.prepareStatement("select note_group_desc,note_group FROM ca_note_group WHERE note_group=?");
			//stmt = con.prepareStatement("select short_desc FROM am_service where service_code = ? and eff_status='E' ");
			stmt.setString(1,note_group_id);
			rs=stmt.executeQuery();
			while(rs!=null && rs.next())
			{
				 note_group_desc = rs.getString(1); 
				 note_grp=rs.getString(2);
			}
 			

	}
	    if(rs!=null) rs.close();
		if(stmt!=null) stmt.close(); 
	}	
	catch(Exception e)
	{
		//out.println("Exception@1: "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	
%>

</script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();disclaimerView()' onKeyDown="lockKey()">
<form name="NoteType_form" id="NoteType_form" action="../../servlet/eCA.NoteTypeServlet" method="post" target="messageFrame">
<!-- <table border=0 cellspacing=0 cellpadding='3' width='75%' align=center> -->
<table border=0 cellspacing=0 cellpadding='3' width='99%' align=center>
<tr>
	<td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td colspan="2" class='fields' >
	<input type="text" name="note_type" id="note_type" value="<%=note_type%>" <%=status%> size=4 maxlength=4 onKeyPress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'>
	<%
	//IN052376 Start.
	if(mode.trim().equalsIgnoreCase("update")) {%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="" id="" value="Print Note Layout" class="BUTTON" onClick="openPrintNoteTemplate()" />
	<%}
	//IN052376 End.
	%>	
	</td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="note_type_desc" id="note_type_desc" value="<%=note_type_desc%>"   size=30 maxlength=30  <%=dis1%> onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
<td class=label ><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
<td class='fields' colspan="2"><input type='text' name='note_group_desc' id='note_group_desc' value="<%=note_group_desc%>" size="30"  <%=status%> 
OnBlur ='getNoteCode(this)' OnChange='resetValues();setValue()'><input type='button' name='note_desc_search' id='note_desc_search' value='?' class='button' OnClick='resetValues();getNoteCode(this)'<%=status%>><input type='hidden' name='note_group_id' id='note_group_id' value="<%=note_grp%>" >
<!--<td colspan="2" align=left>&nbsp;<select name='note_group_id' id='note_group_id' <%=status%> onchange='getNoteGroup(this)'>

<option value="">----------Select-----------</option>
	
	<%
	try
{
		isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
	String sqlpop = "select NOTE_GROUP,NOTE_GROUP_DESC from ca_note_group where EFF_STATUS = 'E' ";
	String note_group="";
	stmt= con.prepareStatement(sqlpop);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{
		note_group=rs.getString("NOTE_GROUP");
		
		if(note_group_id.equals(note_group))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
		out.println("<option value='"+note_group+"' "+sel+">"+rs.getString("NOTE_GROUP_DESC")+"</option>");

	}
	
	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();
}//try 

catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
   eg.printStackTrace();//COMMON-ICN-0181
}


%>

</select>--><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E"  <%=enabled_checked%>></td>
</tr>
<%if(license_rights.equals("MINI")){%>
<tr>
	<td class=label ><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><%if (inpatient_yn.equalsIgnoreCase("Y")) {sel="checked";status_check="I";} else {sel="";}%>&nbsp;&nbsp;&nbsp;IP&nbsp;<input type="checkbox" name="inpatient_yn" id="inpatient_yn" value="" <%=sel%> <%=dis1%>>
	&nbsp;&nbsp;
	<%if (outpatient_yn.equalsIgnoreCase("Y")) {sel="checked";status_check="O";} else {sel="";}%>OP&nbsp;<input type="checkbox" name="outpatient_yn" id="outpatient_yn" value="" <%=sel%> <%=dis1%>><input style='visibility:hidden' type="checkbox" name="serv_facl_spec_yn" id="serv_facl_spec_yn" value="N" >&nbsp;&nbsp;
	</td>
</tr>
<tr style='visibility:hidden'>
		<td class=label ><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
		<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
		<td colspan="2" class='fields'><select name='event_class' id='event_class' onchange='' <%=status%>>
			<option value="PHY$" selected><fmt:message key="eAE.Physician.label" bundle="${ae_labels}"/></option>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr style='visibility:hidden'>
		<td class=label ><fmt:message key="eCA.PublishLevel.label" bundle="${ca_labels}"/></td>
		<td colspan="2" class='fields'><select name='publish_level' id='publish_level' <%=dis1%>>
			<option value="4" selected><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
		</select>
		
</tr>
<tr style='visibility:hidden'>
		<td class=label ><fmt:message key="eCA.AmendmentType.label" bundle="${ca_labels}"/></td>
		<td colspan="2" class='fields'><select name='ammendment_type' id='ammendment_type' <%=dis1%>>
			<option value="A" selected><fmt:message key="eCA.CreateNewAddendum.label" bundle="${ca_labels}"/></option>
			</select>
		
</tr>
<%}else{%>

<tr>
		<td class=label ><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
		<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
		<td colspan="2" class='fields'><select name='event_class' id='event_class' onchange='' <%=status%>>
			<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>

			<%
				if( license_rights.equals("FULL") )	
				{
					if (event_class.equals("CLI$")) sel="selected"; else sel="";
			%>
					<!-- <option value="CLI$"  <%=sel%>><fmt:message key="Common.Clinician.label" bundle="${common_labels}"/></option>--><!--IN067236-->
					<option value="CLI$" <%=sel%>><%if (isClinician){%> <fmt:message key="eCA.Therapist.label" bundle="${ca_labels}"/><%}else{%><fmt:message key="Common.Clinician.label" bundle="${common_labels}"/><%}%></option><!--IN067236-->
			<%}
					if( license_rights.equals("FULL") )	
					{
				%>
					<%if (event_class.equals("NUR$")) sel="selected"; else sel="";%>
					<option value="NUR$"  <%=sel%>><fmt:message key="Common.Nursing.label" bundle="${common_labels}"/></option>
				<%
					}
				%>
				<%if (event_class.equals("PHY$")) {sel="selected";} else {sel="";}%>
				<option value="PHY$"  <%=sel%>><fmt:message key="eAE.Physician.label" bundle="${ae_labels}"/></option>
				</select>			
		<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><%if (inpatient_yn.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>&nbsp;IP&nbsp;<input type="checkbox" name="inpatient_yn" id="inpatient_yn" value="" <%=sel%> <%=dis1%>>
	&nbsp;&nbsp;
	<%if (outpatient_yn.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>OP&nbsp;<input type="checkbox" name="outpatient_yn" id="outpatient_yn" value="" <%=sel%> <%=dis1%>>&nbsp;&nbsp;
	<%if (serv_facl_spec_yn.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>DC&nbsp;<INPUT TYPE="checkbox" name="DC" id="DC" value ="" <%=dc_flag%> <%=dis1%>>&nbsp;&nbsp;EM&nbsp;<INPUT TYPE="checkbox" name="EM" id="EM" value=""  <%=em_flag%> <%=dis1%>>
	<%if (patient_specific_yn.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>
	&nbsp;&nbsp;XT&nbsp;<INPUT TYPE="checkbox" name="patient" id="patient" value=""  <%=sel%> <%=dis1%>> </tr>
	<tr><%if (serv_facl_spec_yn.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>
	<td colspan="1" class=label ><fmt:message key="eCA.ServiceFacilitySpecific.label" bundle="${ca_labels}"/> </td>
	<td class='fields'>	<input type="checkbox" name="serv_facl_spec_yn" id="serv_facl_spec_yn" value="" <%=sel%> <%=dis1%>  >
	</td>
		<td  colspan="1">
		</tr>
<%



int count1 =0;
try
{


if(!note_group_id.equals("")){
sql1="select count(*)  from ca_note_group where NOTE_GROUP =? and APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER','RESULT_REPORTING','OT_NOTES')";//--[IN028710]   //37958  Added OT_NOTES


pstmt1= con.prepareStatement(sql1);
pstmt1.setString(1,note_group_id);
rs1 = pstmt1.executeQuery(); 
	if(rs1.next())
	{
		count1 =rs1.getInt(1);
	}
	if (rs1!= null) rs1.close();
	if (pstmt1!= null) pstmt1.close();

if(count1>0)
	{
	    chkstr="";
	}
	else
		chkstr="disabled";

}
}
catch(Exception e)
{
	e.printStackTrace() ;
}

	
%>



<%if (doc_link_note.equalsIgnoreCase("Y")) {sel="checked";} else {sel="";}%>
	<%if(!license_rights.equals("BASIC")){%>
	<tr>
	<td  colspan="1" class=label ><fmt:message key="eCA.DocumentLinkedNote.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="checkbox" name="doc_link_note" id="doc_link_note" value=""<%=sel%> <%=chkstr%> onclick='chkDocLink(this)' ></td>
		<td colspan = "1" class=label></td>
	<%}else{%>
		<td colspan = "2" class=label></td>
	<%}%>
	</tr>

<%	if(mode.trim().equalsIgnoreCase("update"))
	{
		if(print_logo_header.equalsIgnoreCase("Y"))
		{
			print_checked = "checked";
			print_val = "Y";
		}
		else
		{
			print_checked = "";
			print_val = "N";
		}
		if(print_txt_logo_header.equalsIgnoreCase("Y"))  //[IN032210] Start
		{
			print_txt_checked = "checked";
			print_txt_val = "Y";
		}
		else
		{
			print_txt_checked = "";
			print_txt_val = "N";
		}  //[IN032210] End
	}
%>
	<tr>
		<td class=label><fmt:message key="eCA.PrintLogoHeader.label" bundle="${ca_labels}"/></td>
		<!-- <td class='fields' colspan="2"><input type="checkbox" name="print_logo_header" id="print_logo_header" value="<%=print_val%>" <%=print_checked%> onclick='chkPrintHeader(this)'></td>-->
		<td class='fields' colspan="2">
			<TABLE border=0 cellspacing=0 cellpadding='3' width='100%'>
				<TR>
					<TD><input type="checkbox" name="print_logo_header" id="print_logo_header" value="<%=print_val%>" <%=print_checked%> onclick='chkPrintHeader(this)'></TD>
					<td class=label id="txtLogoHeader" style = "display:none">
						<fmt:message key="eCA.PrintTextLogoHeader.label" bundle="${ca_labels}"/>&nbsp;&nbsp;
						<input type="checkbox" name="print_txtlogo_header" id="print_txtlogo_header" value="<%=print_txt_val%>" <%=print_txt_checked%> onclick='chkPrintTxtHeader(this)'>
					</td>
				</TR>
			</TABLE>
		</td>
	</tr>
    <tr>
	    <td class=label ><fmt:message key="eCA.PrintNotesOnSign.label" bundle="${ca_labels}"/></td>
		<td class='fields' colspan="2">
		<input type='radio' name='print' id='print' value='C' <%=checkedConfirm%>><fmt:message key="eCA.PrintOnConfirm.label" bundle="${ca_labels}"/> 
		<input type='radio' name='print' id='print' value='D' <%=checkedDirectly%>><fmt:message key="eCA.PrintDirectly.label" bundle="${ca_labels}"/> 
		<input type='radio' name='print' id='print' value='N' <%=checkedNone%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>
		</td>
     </tr>

<tr>&nbsp;&nbsp;&nbsp;
		<td class=label ><fmt:message key="eCA.PublishLevel.label" bundle="${ca_labels}"/></td>
		<td class='fields' colspan="2"><select name='publish_level' id='publish_level' <%=dis1%>>
			<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
			<%if (publish_level.trim().equalsIgnoreCase("3")) {sel="selected";} else {sel="";}%>
			<option value="3" <%=sel%>><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></option>
			<%if (publish_level.equalsIgnoreCase("4")) {sel="selected";} else {sel="";}%>
			<option value="4" <%=sel%>><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
			</select>
		<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<!--<tr>
		<td class=label align=right>Banner&nbsp;&nbsp;</td>
		<td align=left><select name='banner_ind' id='banner_ind' <%=dis1%>>
			<option value="">------Select------</option>
			<%if (banner_ind.trim().equalsIgnoreCase("0")) {sel="selected";} else {sel="";}%>
			<option value="0" <%=sel%>>Banner is not visible</option>
			<%if (banner_ind.trim().equalsIgnoreCase("1")) {sel="selected";} else {sel="";}%>
			<option value="1" <%=sel%>>Banner is visible</option>
			</select>
		&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>-->

<tr> 
		<td class=label ><fmt:message key="eCA.AmendmentType.label" bundle="${ca_labels}"/></td>
		<td class='fields' colspan="2"><select name='ammendment_type' id='ammendment_type' <%=dis1%>>
			<option value="">------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------</option>
			<%if (ammendment_type.trim().equalsIgnoreCase("S")) {sel="selected";} else {sel="";}%>
			<option value="S" <%=sel%>><fmt:message key="eCA.AmendOriginalSection.label" bundle="${ca_labels}"/></option>
			<%if (ammendment_type.trim().equalsIgnoreCase("A")) {sel="selected";} else {sel="";}%>
			<option value="A" <%=sel%> ><fmt:message key="eCA.CreateNewAddendum.label" bundle="${ca_labels}"/></option>
			<%if (ammendment_type.trim().equalsIgnoreCase("N")){sel="selected";} else {sel="";}%> 
			<option value="N" <%=sel%> ><fmt:message key="eCA.NotAllowed.label" bundle="${ca_labels}"/></option>

			<%//}%>
			</select>
		<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eCA.ReportHeader.label" bundle="${ca_labels}"/></td>
<td class='fields' ><select name="report_header_desc" id="report_header_desc" onchange='getHeaderView(this)'>
<!-- <option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option> -->
<option value="">----------*<fmt:message key="Common.none.label" bundle="${common_labels}"/>*-----------</option>

<%
	try
	{
		String sqlpop2 = "select SEC_HDG_CODE,SEC_HDG_DESC from CA_SECTION_HDG Where template_type = 'R' and Eff_status = 'E' ";
		String sec_header_code="";
		String sec_header_desc="";
		String select="";
		stmt= con.prepareStatement(sqlpop2);
		rs = stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			sec_header_code = rs.getString("SEC_HDG_CODE") == null ? "" : rs.getString("SEC_HDG_CODE");
			sec_header_desc = rs.getString("SEC_HDG_DESC") == null ? "" : rs.getString("SEC_HDG_DESC");
			
			if(report_header_code.equals(sec_header_code))
				select="selected";
			else if(sec_header_code.equals("V$RH") && !mode.equals("update")) select="selected";
			else
				select="";		
			out.println("<option value='"+sec_header_code+"' "+select+">"+sec_header_desc+"</option>"); 
		}
	
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();
	}//try 
	catch(Exception eg)
	{
	  //out.println("Exception in Report Header="+eg.toString());//common-icn-0181
	  eg.printStackTrace();//COMMON-ICN-0181
	}
 
%>
</td>
<td  align ='left'>
<a class="gridLink" href='javascript:showText1("report")' ID='report' style='visibility:hidden' ><fmt:message key="Common.view.label" bundle="${common_labels}"/></a>
</td>

</tr>
<tr><td colspan=3 ></td></tr>

<tr>
<td class=label ><fmt:message key="eCA.NoteHeader.label" bundle="${ca_labels}"/></td>
<td class='fields' ><select name="note_header_desc" id="note_header_desc" onchange='getHeaderView(this)'>
<!--<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option> -->
<option value="">----------*<fmt:message key="Common.none.label" bundle="${common_labels}"/>*-----------</option> 


<%
  try
  {
	String sqlpop3 = "select SEC_HDG_CODE,SEC_HDG_DESC from CA_SECTION_HDG Where template_type = 'H' and Eff_status = 'E'";
    String sec_header_code="";
    String sec_header_desc="";
	String select="";
	stmt= con.prepareStatement(sqlpop3);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{
		sec_header_code = rs.getString("SEC_HDG_CODE") == null ? "" : rs.getString("SEC_HDG_CODE");
		sec_header_desc = rs.getString("SEC_HDG_DESC") == null ? "" : rs.getString("SEC_HDG_DESC");
		if(note_header_code.equals(sec_header_code)){
			select="selected";
		}
		else if(sec_header_code.equals("V$NH") && !mode.equals("update")) select="selected";
		else
			select="";
		out.println("<option value='"+sec_header_code+"' "+select+">"+sec_header_desc+"</option>");		
	}
	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();

 }//try	
catch(Exception eg)
{
  // out.println("Exception in Note Header="+eg.toString());//COMMON-ICN-0181
	eg.printStackTrace();//COMMON-ICN-0181
} 
%>
</td>
<td  align ='left'>
<a class="gridLink" href='javascript:showText1("note")' ID='note' style='visibility:hidden' ><fmt:message key="Common.view.label" bundle="${common_labels}"/></a>
</td>
</tr>
<tr><td colspan=3 ></td></tr>

<tr>
<td class=label ><fmt:message key="eCA.NoteFooter.label" bundle="${ca_labels}"/></td>
<td class='fields' ><select name="footer_header_desc" id="footer_header_desc" onchange='getHeaderView(this)'>
<!-- <option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option> -->
<option value="">----------*<fmt:message key="Common.none.label" bundle="${common_labels}"/>*-----------</option>

<%
  try
  {
	 String sqlpop4 = "select SEC_HDG_CODE,SEC_HDG_DESC from CA_SECTION_HDG Where template_type = 'F' and Eff_status = 'E'";
    String sec_header_code="";
    String sec_header_desc="";
	String select="";
	stmt= con.prepareStatement(sqlpop4);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{
		sec_header_code = rs.getString("SEC_HDG_CODE") == null ? "" : rs.getString("SEC_HDG_CODE");
		sec_header_desc = rs.getString("SEC_HDG_DESC") == null ? "" : rs.getString("SEC_HDG_DESC");
		if(footer_code.equals(sec_header_code)){
			select="selected";
		}
		else if(sec_header_code.equals("V$RF") && !mode.equals("update")) select="selected";
		else
			select="";
		
		out.println("<option value='"+sec_header_code+"' "+select+">"+sec_header_desc+"</option>");		
	}

	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();

 }//try	
catch(Exception eg)
{
   //out.println("Exception in Footer="+eg.toString());//COMMON-ICN-0181
   eg.printStackTrace();//COMMON-ICN-0181
   
} 
%>
</td>
<td  align ='left'>
<a class="gridLink" href='javascript:showText1("footer")' ID='footer' style='visibility:hidden' ><fmt:message key="Common.view.label" bundle="${common_labels}"/></a>
</td>
</tr>
<tr><td colspan=3 ></td></tr>



<tr>
<td class=label ><fmt:message key="eCA.Disclaimer.label" bundle="${ca_labels}"/></td>
<td class='fields' ><select name="disclaimer_desc" id="disclaimer_desc"  onchange='getDisclaimertext(this)'>
<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	
	<%
	try
	{
		String sqlpop = "select DISCLIMER_CODE,DISCLIMER_DESC from CA_DISCLIMER_TEXT where eff_status = 'E'";
		String disclimer_code="";
		stmt= con.prepareStatement(sqlpop);
		rs = stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			disclimer_code=rs.getString("DISCLIMER_CODE");
			if(disclimer_code1.equals(disclimer_code))
			{
				sel="selected";
			}	
			else
			{
				sel="";
			}			
			out.println("<option value='"+disclimer_code+"' "+sel+">"+rs.getString("DISCLIMER_DESC")+"</option>");
		}		
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();
	}//try
	catch(Exception eg)
	{
	 //  out.println("Exception in Disclaimer="+eg.toString());//COMMON-ICN-0181
		eg.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (con!= null) ConnectionManager.returnConnection(con,request);
	} 
%>
</td>
<td  align ='left'>
<a class="gridLink" href='javascript:showText()' ID='disclaimer' style='visibility:hidden' ><fmt:message key="Common.view.label" bundle="${common_labels}"/></a>
</td>
</tr>
<!--[IN031116]  Start-->
<tr id="hdr_margin">
	<td class=label ><fmt:message key="eCA.NoteHeaderMargin.label" bundle="${ca_labels}"/></td>	
	<td colspan="2" class='fields' ><input type="text" name="header_margin_note" id="header_margin_note" value="<%=note_header_margin%>" 
	size=5 maxlength=5   onblur="validateMargin(this,'Margin range should be between 0 & 6')"></td>
</tr>
<tr id="foot_margin">
	<td class=label ><fmt:message key="eCA.NoteFooterMargin.label" bundle="${ca_labels}"/></td>	
	<td colspan="2" class='fields' ><input type="text" name="footer_margin_note" id="footer_margin_note" value="<%=note_footer_margin%>" 
	size=5 maxlength=5  onblur="validateMargin(this,'Margin range should be between 0 & 6')"></td>
</tr>

<!-- [IN031116] End-->
<tr><td colspan=3 ></td></tr>
  
    <tr>
	<td class=label><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="confidential_yn" id="confidential_yn" value="N" <%=confidential_checked%> onclick='OnConfChange(this)'></td>
</tr>
<!--IN059489 starts -->
<tr><td colspan=3 ></td></tr>
  
    <tr>
	<td class=label><fmt:message key="eCA.watermark.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="water_mark" id="water_mark"  value =<%=watermark_flg%> <%=watermark_checked%> onclick ="checkForModeMark(this)"></td>
</tr>
<!--IN059489 Ends -->
<!--IN037676, starts-->
<tr>
	<td colspan=3 ></td>
</tr>  
<tr>
<!--Addendum Sign for others-->
	<td class=label><fmt:message key="eCA.SignAddendumOthers.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="sign_addendum_yn" id="sign_addendum_yn" value="<%=signAddendumValue%>" <%=signAddendumChecked%> onclick='signAddendumOnClick(this)'></td>
</tr>
<!--IN037676, ends-->
<tr>
<!--IN037675, starts-->
<td class='label'>
Rules for Forwarding Notes
</td>
<td>
<table border = '1'>
<tr align="left">
<th class='columnheader'>
Practitioner Level
</th>
<th class='columnheader'>
Speciality Level
</th>
</tr>
<tr>
<td class='fields'>
<input type='radio' name ='pracLevelChk' value = 'A' <%=allPracChecked%>/> All Facilities
</td>
<td class='fields'>
<input type='radio' name ='specLevelChk' value = 'A' <%=allSpecChecked%>/> All Facilities
</td>
</tr>
<tr>
<td class='fields'>
<input type='radio' name ='pracLevelChk' value = 'F' <%=facPracChecked%>/> Facility Specific
</td>
<td class='fields'>
<input type='radio' name ='specLevelChk' value = 'F' <%=facSpecChecked%>/> Facility Specific
</td>
</tr>
<tr>
<tr>
<td class='fields'>
<input type='radio' name ='pracLevelChk' value = 'P' <%=promPracChecked%>/> Prompt for facility while forwarding&nbsp;&nbsp;
</td>
<td class='fields'>
<input type='radio' name ='specLevelChk' value = 'P' <%=promSpecChecked%>/> Prompt for facility while forwarding&nbsp;&nbsp;
</td>
</tr>
</table>
</td>
</tr>
<tr>
<!--IN037675, ends-->
	<th class='columnheader' colspan=3 align='left'><fmt:message key="eCA.EventCaptions.label" bundle="${ca_labels}"/></th>
</tr>

<tr>
	<td class=label  ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="2"><input type="text" name="event_type_caption" id="event_type_caption" value="<%=event_type_caption%>" size='30' maxlength='30' onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td class='fields'colspan="2"><input type="text" name="event_date_caption" id="event_date_caption" value="<%=event_date_caption%>" size='20' maxlength='20'  onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="2"><input type="text" name="event_status_caption" id="event_status_caption" value="<%=event_status_caption%>" size='20' maxlength='20' onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>


<tr>
	<td class=label ><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="2"><input type="text" name="event_title_caption" id="event_title_caption" value="<%=event_title_caption%>" size='20' maxlength='20' onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>


<tr>
	<td class=label ><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="2"><input type="text" name="event_perf_by_caption" id="event_perf_by_caption" value="<%=event_perf_by_caption%>" size='20' maxlength='20'  onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan="2"><input type="text" name="event_auth_by_caption" id="event_auth_by_caption" value="<%=event_auth_by_caption%>" size='20' maxLength='20'  onBlur="makeValidString(this)" onKeyPress="return CheckForSpecCharsNoCaps(event)" <%=dis1%>></td>
</tr>
<%}//end if else part for if(license_rights.equals("MINI"))%>
</table>
<% if(mode.equals("update") && eff_status.equals("D") ){%>

<script>
document.forms[0].disclaimer_desc.disabled=true;
//document.getElementById("disclaimer").style.visibility = 'hidden';
</script>
	<%}%>
<input type=hidden name="mode" id="mode"              value="<%=mode%>">
<input type=hidden name="license_rights" id="license_rights"   value="<%=license_rights%>">
<input type=hidden name="created_notes" id="created_notes"   value="<%=sb_created_notes.toString()%>">
<!--only used for MINI CA-->
<input type=hidden name="created_ip_notes" id="created_ip_notes"   value="<%=created_ip_notes%>">
<input type=hidden name="created_op_notes" id="created_op_notes"   value="<%=created_op_notes%>">
<input type=hidden name="created_tot_notes" id="created_tot_notes"  value="<%=created_tot_notes%>">
<input type=hidden name="status_check" id="status_check"        value="<%=status_check%>">

<!--ends Here-->
<input type=hidden name="note_groupid_update" id="note_groupid_update"   value="<%=note_group_id%>">
<input type=hidden name="note_type_update" id="note_type_update"   value="<%=note_type%>">
<input type=hidden name="event_class_update" id="event_class_update" value="<%=event_class%>">
<input type=hidden name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked%>">
<input type=hidden name='banner_ind' id='banner_ind' value=''>
<input type=hidden name='eff_status1' id='eff_status1' value=<%=eff_status%>>
<input type=hidden name='conf_yn' id='conf_yn' value=<%=confidential_yn%>>
<input type='hidden' name='flag' id='flag' value='true'>
<!-- [IN031116] Start ---> 
<%
try{
	con =	ConnectionManager.getConnection(request);
	sql ="select HDR_FT_MARGIN_IN_NOTE_YN from ca_note_param" ;
	stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = stmt.executeQuery();
			 
	if(rs.next()){
		hdfo_margin=(rs.getString("HDR_FT_MARGIN_IN_NOTE_YN")== null)? "":rs.getString("HDR_FT_MARGIN_IN_NOTE_YN"); 
	}
	if(stmt!=null) { stmt.close(); stmt=null; }
	if(rs!=null) { rs.close(); rs=null; }
	if(con!=null) { con.close(); con=null; }		
}catch(Exception e)
{
	//out.println("Exception@1: "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
	if(stmt!=null) { stmt.close(); stmt=null; }
	if(rs!=null) { rs.close(); rs=null; }
	if(con!=null) { con.close(); con=null; }
}
//System.out.println("note_header_margin----->"+note_header_margin);
//System.out.println("note_footer_margin----->"+note_footer_margin);
//System.out.println("hdfo_margin----->"+hdfo_margin);
%>
<input type='hidden' name='hdfo_margin_flag' id='hdfo_margin_flag' value='<%=hdfo_margin%>'>
<script>
var hdfoflag=document.forms[0].hdfo_margin_flag.value;
if(hdfoflag=='Y'){
document.getElementById('hdr_margin').style.display='';
document.getElementById('foot_margin').style.display='';
}else{
document.getElementById('hdr_margin').style.display='none';
document.getElementById('foot_margin').style.display='none';
}

function validateMargin(fld,mess){
	var str=fld.value;
	if(str!=''){
		var cStr=Math.round(str*100)/100;
		var val=parseFloat(cStr);		
		if(val>=0.00 && val<=6.00){	
			fld.value=val;
		}else{
			alert(mess);
			fld.select();	
		}
	}
}
//[IN032210] Start
if(document.forms[0].print_logo_header.checked){
	document.getElementById('txtLogoHeader').style.display='';
}else{
	document.getElementById('txtLogoHeader').style.display='none';
}
//[IN032210] End
</script>
<!-- [IN031116] End -->
</form>
</body>
</html>

