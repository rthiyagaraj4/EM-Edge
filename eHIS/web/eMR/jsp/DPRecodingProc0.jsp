<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
 	Connection conn = ConnectionManager.getConnection(request);	

try
 {
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 
	 String loginUser		= (String) session.getValue( "login_user" );	
	 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	 String locale = (String)session.getAttribute("LOCALE"); 


	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	StringBuffer sql1 = new StringBuffer();
	String term_set = "";
	//String term_code = "";
	//String term_desc = "";
	String record_by = "";
	String record_date = "";
	String caused_death = "";
	String classValue = "";
	//String hd_patient_id = "";
	//String hd_term_set = "";
	//String hd_term_code = "";
	//String hd_term_desc = "";
	//String hd_coded_by = "";
	//String hd_coded_date = "";
	//String hd_causeDeath = "";
	//String hd_recodeStatus = "";
	String patient_id = "";
	//String orig_term_set = "";
	//String orig_term_code = "";
	
	String proc_code = "";
	String proc_desc = "";
	//String hd_proc_code_scheme = "";
	//String hd_proc_code = "";
	
	String laterality="";
	String remarks="";
	String stage_srl_no="";
	String show_eq_tmcd="";
	String show_remarks="";



	int i = 0;
	//int cnt1 = 0;
	int srl_no = 0;



 String EncounterId = request.getParameter("EncounterId");
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 //String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String temp_code = checkForNull(request.getParameter("temp_code"));
 String gender = checkForNull(request.getParameter("gender"));
 String age = checkForNull(request.getParameter("age"));
 String dob = checkForNull(request.getParameter("dob"));
 String spec_code = checkForNull(request.getParameter("spec_code"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 //String show_level = checkForNull(request.getParameter("show_level"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
// String drg_temp = checkForNull(request.getParameter("drg_temp"));
 String stage_no = request.getParameter("stage_no");
// String mode1 = checkForNull(request.getParameter("mode1"));
 //String temp_proc = checkForNull(request.getParameter("temp_proc"));
// String tot_cnt = checkForNull(request.getParameter("tot_cnt"));

String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
 int Stage_no = Integer.parseInt(stage_no);
 String recode_status = "";
 //String recodeStatus_disp = "";

//String  hide_header		="";
String  hide_dataTable	="";
String  hide_exp			="";
String New_EncounterId="";
String proc_type_filtr="";
if(allow_recode_proc_yn.equals("Y")){
	hide_dataTable="visible";
	New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
	/*Added On 7/7/2009*/
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr ="";
	}else if(allow_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr	=" AND CONTR_MOD_ID='OT' ";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr	=" AND nvl(CONTR_MOD_ID,'x')!=nvl('OT','x') ";
	}
}else{
	hide_dataTable="hidden";
	New_EncounterId="";
}
if(allow_recode_diag_yn.equals("Y")){
	hide_exp	=	"visible";
}else{
	hide_exp	=	"hidden";
}

 if(mode.equals(""))
	mode="N";




%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function expandProcedure()
		{
//			parent.RecodeScreen.rows="10%,80%,*";
			parent.RecodeScreen.rows="14%,85%,5%,0%";
			eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon").innerHTML="<a href='javascript:onclick=expandDiagnosis()'>+</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";

			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon").innerHTML="<a href='javascript:onclick=collapseProcedure()'>-</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";
				//all.diagTable.visibility);
			//diagTable
		}

		function collapseProcedure()
		{
//			parent.RecodeScreen.rows="40%,40%,*";
			parent.RecodeScreen.rows="48%,48%,4%,0%";
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon").innerHTML="<a href='javascript:onclick=expandProcedure()'>+</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";

		}


		function showDiag()
		{
			//if(mode.equals("Y"))
				//parent.frames[2].document.RecodeDiagnosisProcDetail.diagTable.visiblity='visible';

		}
		
		function expandRecode(i)
		{
			//alert("expandRecode "+i);
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.visibility='visible';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.display='inline';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=collapseRecode("+i+")'>-</a>";
		}

		function collapseRecode(i)
		{
			//alert("collapseRecode "+i);

			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.visibility='hidden';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.display='none';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=expandRecode("+i+")'>+</a>";
		}
	</script>
</head>
<body onKeyDown='lockKey()'>
	<form name="RecodeDiagnosisProcDetail" id="RecodeDiagnosisProcDetail" method='post'>
	<!--<form name="RecodeDiagnosisProcDetail" id="RecodeDiagnosisProcDetail">-->

	<table id='diagTable' style='visibility:visible;display:inline' border='1' cellpadding='1' cellspacing='0' width="100%"  valign='top' onLoad='showDiag();' style="visibility:<%=hide_dataTable%>">
	

		<tr><td colspan='13' class='PANELTOOLBAR' id="Proc_icon"><a href="javascript:onclick=expandProcedure()" style="visibility:<%=hide_exp%>">+</a>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td></tr>
		<tr>&nbsp;</tr>
		<tr>
			<th align='center'>&nbsp;</th>
			<th align='center' ><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
			<th align='center' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align='center' ><fmt:message key="Common.description.label" bundle="${common_labels}"/>
			<th align='center' ><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th><!-- Added On 7/8/2009 -->
			<th align='center' ><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ext.label" bundle="${common_labels}"/> </th><!-- Added On 7/8/2009 -->

<!-- 			<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th></th> Added On 7/2/2009-->			
			<th align='center' nowrap><fmt:message key="eMR.CodedBy.label" bundle="${mr_labels}"/></th>
			<th align='center' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
			<th align='center' ><fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>

		</tr>

		<%
	 		/*String New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
			if(allow_recode_proc_yn.equals("N")){
				New_EncounterId="";
			} Note: This Commented Code Was Implemented @ Line No:98*/ 
			String contr_mod_id="";
			String proc_type="";
			String  accession_num	="";// Added On 7/8/2009
			String  code_extn_yn	="";// Added On 7/8/2009
			String  code_extn_dtl	="";// Added On 7/8/2009
			String show_accesion="";// Added On 7/8/2009
			boolean show_cdxtn=false;// Added On 7/8/2009
			String  remark_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
			String  eqvi_code_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
			String  order_cat_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");
			String  latind_lbl="";;
			String  proc_srt_dt_time="";;
			String  proc_end_dt_time="";;



			if(mode.equals("Y")){
			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;


					sql1.append("select a.patient_id,a.proc_code_scheme, a.proc_code,mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,b.long_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name, decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') laterality_ind,to_char(a.proc_checkin_start_date_time,'dd/mm/yyyy hh24:mi')proc_checkin_start_date_time,to_char(a.proc_checkout_end_date_time,'dd/mm/yyyy hh24:mi')proc_checkout_end_date_time,to_char (a.proc_date, 'dd/mm/yyyy hh24:mi') recorded_date_time,decode(recode_status,'O','Review') recode_status,stage_srl_no,remarks,contr_mod_id,( SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct WHERE mct.TERM_SET_ID = a.proc_code_scheme AND mct.term_code = a.proc_code AND mct.CROSS_REF_TYPE = 'EQ')equiv_count,a.ACCESSION_NUM ,a.CODE_EXTN_YN,a.CODE_EXTN_DTL from mr_procedure_recoding_dtl a, mr_term_code b where a.facility_id='"+p_facility_id+"' and a.encounter_id = '"+New_EncounterId+"'  and a.recode_status='O' and stage_no='0' and status='A' and  a.proc_code_scheme=b.term_set_id and a.proc_code=b.term_code  "+proc_type_filtr+" order by contr_mod_id desc");
					pstmt = conn.prepareStatement(sql1.toString());
					rs = pstmt.executeQuery();	


				while(rs.next()){
					String long_desc			= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					int equivalent_term_code_cnt =0;
					patient_id = checkForNull(rs.getString("patient_id"));
					term_set = checkForNull(rs.getString("proc_code_scheme"));
					proc_code = checkForNull(rs.getString("proc_code"));
					proc_desc = checkForNull(rs.getString("short_desc"));
					recode_status = checkForNull(rs.getString("recode_status"));
					record_date = checkForNull(rs.getString("recorded_date_time"));
					record_date=DateUtils.convertDate(record_date,"DMYHM" ,"en",locale);

					record_by				= checkForNull(rs.getString("practitioner_name"));
					laterality					=checkForNull(rs.getString("laterality_ind"));
					remarks					=checkForNull(rs.getString("remarks"));
					stage_srl_no				=checkForNull(rs.getString("stage_srl_no"));
					contr_mod_id			=checkForNull(rs.getString("contr_mod_id"));
					proc_srt_dt_time		= checkForNull(rs.getString("proc_checkin_start_date_time"));
					proc_end_dt_time	= checkForNull(rs.getString("proc_checkout_end_date_time"));
					long_desc					= checkForNull(rs.getString("long_desc"));
					equivalent_term_code_cnt	= rs.getInt("equiv_count");
					accession_num						= checkForNull(rs.getString("ACCESSION_NUM"));
					code_extn_yn						= checkForNull(rs.getString("CODE_EXTN_YN"));
					code_extn_dtl						= checkForNull(rs.getString("CODE_EXTN_DTL"));
					if(recode_status.equals("Review")){
						recode_status	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//Review
					}
					if(laterality.equals("Left")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
					}else if(laterality.equals("Right")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
					}else if(laterality.equals("Both")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
					}else if(laterality.equals("NotApplicable")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					}					
					//int cnt_icd = 0;
					/*String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+proc_code+"' AND CROSS_REF_TYPE = 'EQ'";

					pstmt1 = conn.prepareStatement(sqlicd);
					rs1	 = pstmt1.executeQuery();	

					while(rs1.next()){
							equivalent_term_code_cnt=rs1.getInt("COUNT");
					}

						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();*/

					if(equivalent_term_code_cnt!=0){
						show_eq_tmcd="visible";
					}else{
						show_eq_tmcd="hidden";
					}
					if(!remarks.equals("")){
						show_remarks	="visible";
					}else{
						show_remarks	="hidden";
					}
					if(!(proc_desc.equals(long_desc))){
						display_long_desc ="inline";
						long_desc_params = proc_code+","+term_set;
					}

				
			String chk_status ="disabled";
			if(contr_mod_id.equals("OT") ){
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");;
			}else{
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
			}
		/*String sql_dtl_cols="Select ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL from MR_PROCEDURE_RECODING_DTL where   proc_code = '"+proc_code+"'  and  stage_srl_no ='"+stage_srl_no+"' and encounter_id='"+EncounterId+"' and facility_id='"+p_facility_id+"'";
		pstmt1 = conn.prepareStatement(sql_dtl_cols);
		rs1	 = pstmt1.executeQuery();	
		while(rs1.next()){
			accession_num	= checkForNull(rs1.getString("ACCESSION_NUM"));
			code_extn_yn	= checkForNull(rs1.getString("CODE_EXTN_YN"));
			code_extn_dtl	= checkForNull(rs1.getString("CODE_EXTN_DTL"));
		}
				if(pstmt1 != null) pstmt1.close();
				if(rs1 != null) rs1.close();*/

				if(!accession_num.equals("")){
					if(!contr_mod_id.equals("")){
						show_accesion	 ="visible";
					}else{
						show_accesion	 ="hidden";
					}
				}else{
					show_accesion	 ="hidden";
				}

				if(code_extn_yn.equals("N")){
					if(contr_mod_id.equals("OT")){
						show_cdxtn	= true;
					}else{
						code_extn_dtl	 ="";
						show_cdxtn		= false;
					}
				}else{
					code_extn_dtl	="";
				}

%>				
				<tr>
				
				<td class='<%=classValue%>'>
					<img src='../../eCommon/images/EqivDiag.gif '  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=term_set%>","<%=proc_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"><img src='../../eCommon/images/RecodeRemarks.gif '  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=term_set%>","<%=proc_code%>","<%=EncounterId%>","<%=stage_srl_no%>","Y","","")' alt="<%=remark_lbl%>"><img src='../../eCommon/images/order_catalog.gif'  style="cursor:pointer;visibility:<%=show_accesion%>"onclick='callDetails("AcessionNum","<%=term_set%>","<%=proc_code%>","<%=EncounterId%>","<%=stage_srl_no%>","","<%=accession_num%>","<%=contr_mod_id%>")' alt="<%=order_cat_lbl%>"/><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
				</td>	<!-- Equalent Term Code,Support Diag&Remarks Images  -->
				<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' disabled value='<%=i%>$<%=proc_code%>$<%=term_set%>$<%=srl_no%>$<%=recode_status%>~' onClick='selectProcedure(<%=i%>,this)' <%=chk_status%>></td>
				<td class='<%=classValue%>'><%=recode_status%></td>
				<td nowrap class='<%=classValue%>'><%=term_set%>&nbsp;/&nbsp;<%=proc_code%></td>
				<td class='<%=classValue%>'><%=proc_desc%></td>
				<td class='<%=classValue%>' ><%= proc_type%></td>
				<td class='<%=classValue%>' >&nbsp;<%=code_extn_dtl%></td>
				<td class='<%=classValue%>' nowrap><%=record_by%></td>
				<td nowrap class='<%=classValue%>' nowrap><%=record_date%></td>				
				<td class='<%=classValue%>'>&nbsp;<%=latind_lbl%></td>
				<td class='<%=classValue%>' nowrap>&nbsp;<%=proc_srt_dt_time%></td>
				<td class='<%=classValue%>' nowrap>&nbsp;<%=proc_end_dt_time%></td>
				<input type='hidden' name='hd_termset<%=i%>' id='hd_termset<%=i%>' value='<%=term_set%>'>

				</tr>
			<%
			}//While Loop Ends
		}//Mode Check Ends
			if(rs != null)rs.close();
			if(rs1 != null)rs1.close();
			if(pstmt  != null)pstmt.close();
			if(pstmt1  != null)pstmt1.close();
		%>

	</table>

	<input type='hidden' name='Stage_no' id='Stage_no' value='<%=Stage_no%>'>
	<input type='hidden' name='stage_no' id='stage_no' value='<%=Stage_no%>'>
	<input type='hidden' name='term_code' id='term_code' value='<%=proc_code%>'>
	<input type='hidden' name='diagprob_code' id='diagprob_code' value='<%=proc_code%>'>
	<input type='hidden' name='temp_code' id='temp_code' value='<%=temp_code%>'>
	<input type='hidden' name='sel_item' id='sel_item' value=''>
	<input type='hidden' name='dflt_termset' id='dflt_termset' value='<%=dflt_termset%>'>
	<input type='hidden' name='Pat_id' id='Pat_id' value='<%=patient_id%>'>
	<input type='hidden' name='gender' id='gender' value='<%=gender%>'>
	<input type='hidden' name='age' id='age' value='<%=age%>'>
	<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
	<input type='hidden' name='spec_code' id='spec_code' value='<%=spec_code%>'>
	<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
	<input type='hidden' name='EncounterId' id='EncounterId' value='<%=EncounterId%>'>
	<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=loginUser%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=p_facility_id%>'>
	<input type='hidden' name='fieldSeperator' id='fieldSeperator' value='|'>
	<input type='hidden' name='profileID' id='profileID' value='XB'>
<!-- 	<input type='hidden' name='caused_death' id='caused_death' value='<%=caused_death%>'>
 -->	<input type='hidden' name='code_set' id='code_set' value=''>
	<input type='hidden' name='diagprob_code' id='diagprob_code' value=''>
	<input type='hidden' name='diag_classfication' id='diag_classfication' value=''>
	<input type='hidden' name='accuracy' id='accuracy' value=''>
	<input type='hidden' name='severity' id='severity' value=''>
	<input type='hidden' name='priority' id='priority' value=''>
	<input type='hidden' name='onset_type' id='onset_type' value=''>
	<input type='hidden' name='onset_date' id='onset_date' value=''>
	<input type='hidden' name='status' id='status' value=''>
	<input type='hidden' name='status_date' id='status_date' value=''>
	<input type='hidden' name='applicable_side' id='applicable_side' value=''>
	<input type='hidden' name='remarks' id='remarks' value=''>
	<input type='hidden' name='occur_srl_no' id='occur_srl_no' value=''>
	<input type='hidden' name='recode_status' id='recode_status' value=''>
	<input type='hidden' name='orig_termset' id='orig_termset' value=''>
	<input type='hidden' name='orig_termcode' id='orig_termcode' value=''>
	<input type='hidden' name='checked_yn' id='checked_yn' value='N'>
	<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'>
	<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'>



	</form>
	<%
}catch(Exception e){
	e.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);

 }

	%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

