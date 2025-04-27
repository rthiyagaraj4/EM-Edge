<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> 
	<script language='javascript' src='../js/ICDCode.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<script>
	function chkForMax(Obj)
	{
		if(Obj.value.length>250)
			{
			alert(getMessage('CANT_XCEED_250_CHARS','MR'));
			Obj.focus();
			}
			
	
	}
	
	function clearform()
	{

		document.getElementById("ICDUpdate_form").reset();
	}
	function cancelme()
	{
		// window.parent.parent.returnValue='cancel';
		parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'cancel' ;
		parent.parent.document.getElementById("dialog_tag").close();
	}
	function saveme()
	{
		var sub="Y";
		var textAreaLen = document.querySelector('textarea').value.length ;
		if(textAreaLen > 250){
			alert(getMessage('CANT_XCEED_250_CHARS','MR'));
			return ;
		}
	  	document.ICDUpdate_form.submit();
	  	setTimeout(function() {
	  	    parent.parent.document.getElementById("dialog_tag").close();
	  	}, 1000);
		// parent.parent.document.getElementById("dialog_tag").close();
	}
	</script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
//	String Facility_Id = (String) session.getAttribute("facility_id");
//	String type = request.getParameter("type");
	String diag_srl_no = request.getParameter("diag_srl_no");
	String eff_status = request.getParameter("eff_status");
//	String code_ind = request.getParameter("code_ind");
	String record_type_desc="";
	String cause_indicator_desc="";
	String diag_code="";
	String short_desc="";
	String long_desc="";
	String subdivided="";
	String record_seq="";
	String category="";
	String gender_spec_ind_desc="";
	String list_ab_group="";
	String dclass="";
	String val="";
	String val1="";


	String major_diag_cat="";
	String hcfa_flag="";
	String hcfa_ck_flag="";
	String age_spec_ind="";
	String spec_edit_flag="";
	String hcfa_proc_flag="";
	String code_indicator="";
//	String code_ind_desc="";
	String sensitive_yn="";
	String result="";
	String notifiable_yn="";
	String diag_code_scheme="";

//	String recflg="N";
	//Statement stmt1=null;
	PreparedStatement stmt1 = null;
	ResultSet rset1=null;
	StringBuffer sql1 = new StringBuffer("");
	Connection conn1 =null;
	try{
		conn1= ConnectionManager.getConnection(request);
		if(conn1 == null) out.println("Critical Error");
		//stmt1 = conn1.createStatement();
		
		sql1.append("select diag_srl_no,record_type_desc,cause_indicator_desc,diag_code,short_desc,code_indicator,code_indicator_desc,");
		sql1.append("long_desc,subdivided,record_seq,category,gender_spec_ind_desc,list_ab_group,class,");
		sql1.append( "major_diag_cat,hcfa_flag,hcfa_ck_flag,age_spec_ind_desc,spec_edit_flag,hcfa_proc_flag,sensitive_yn,notifiable_yn,diag_code_scheme from mr_icd_code_vw where diag_srl_no =? ");
		//sql1 += ",nvl(diag_code_scheme,'') ";
	//	sql1 += "diag_code_scheme  from mr_icd_code_vw where diag_srl_no = "+diag_srl_no;
		stmt1 = conn1.prepareStatement(sql1.toString());
		stmt1.setString(1,diag_srl_no);
		rset1 = stmt1.executeQuery();
			
			//out.println("<script>alert(\""+sql1.toString()+"\");</script>");

	if(rset1 != null) {
		if(rset1.next()) {
//			recflg="Y";
			record_type_desc=rset1.getString("record_type_desc");
			cause_indicator_desc=rset1.getString("cause_indicator_desc");
			diag_code=rset1.getString("diag_code");
			short_desc=rset1.getString("short_desc");
			long_desc=rset1.getString("long_desc");
			subdivided=rset1.getString("subdivided");
			record_seq=rset1.getString("record_seq");
			category=rset1.getString("category");
			gender_spec_ind_desc=rset1.getString("gender_spec_ind_desc");	
			list_ab_group=rset1.getString("list_ab_group");
			dclass=rset1.getString("class");
			major_diag_cat=rset1.getString("major_diag_cat");
			hcfa_flag=rset1.getString("hcfa_flag");
			hcfa_ck_flag=rset1.getString("hcfa_ck_flag");
			age_spec_ind=rset1.getString("age_spec_ind_desc");
			spec_edit_flag=rset1.getString("spec_edit_flag");
			hcfa_proc_flag=rset1.getString("hcfa_proc_flag");
			sensitive_yn=rset1.getString("sensitive_yn");
			notifiable_yn=rset1.getString("notifiable_yn");
			diag_code_scheme=rset1.getString("diag_code_scheme");
			if(diag_code_scheme == null || diag_code_scheme.equals("null")) diag_code_scheme="0";
			code_indicator=rset1.getString("code_indicator");
			if((code_indicator==null) || (code_indicator.equals(""))	|| (code_indicator.equals("null")))
				 code_indicator="";   
//			code_ind_desc=rset1.getString("code_indicator_desc");
			if(record_type_desc == null || record_type_desc.equals("null")) record_type_desc="";
			if(cause_indicator_desc == null || cause_indicator_desc.equals("null")) cause_indicator_desc="";
			if(diag_code == null || diag_code.equals("null")) diag_code="";
			if(short_desc == null || short_desc.equals("null")) short_desc="";
			if(long_desc == null || long_desc.equals("null")) long_desc="";
			if(subdivided == null || subdivided.equals("null")) subdivided="";
			if(record_seq == null || record_seq.equals("null")) record_seq="";
			if(category == null || category.equals("null")) category="";
			if(gender_spec_ind_desc == null || gender_spec_ind_desc.equals("null")) gender_spec_ind_desc="";
			if(list_ab_group == null || list_ab_group.equals("null")) list_ab_group="";
			if(dclass == null || dclass.equals("null")) dclass="";
			if(major_diag_cat == null || major_diag_cat.equals("null")) major_diag_cat="";
			if(hcfa_flag == null || hcfa_flag.equals("null")) hcfa_flag="";
			if(hcfa_ck_flag == null || hcfa_ck_flag.equals("null")) hcfa_ck_flag="";
			if(age_spec_ind == null || age_spec_ind.equals("null")) age_spec_ind="Others";
			if(spec_edit_flag == null || spec_edit_flag.equals("null")) spec_edit_flag="";
			if(hcfa_proc_flag == null || hcfa_proc_flag.equals("null")) hcfa_proc_flag="";
			//if(tab_list_no == null || tab_list_no.equals("null")) tab_list_no="";
			//if(tab_list == null || tab_list.equals("null")) tab_list="";
			if(sensitive_yn == null || sensitive_yn.equals("null")) sensitive_yn="";
			if(notifiable_yn == null || notifiable_yn.equals("null")) notifiable_yn="";
			
		}
	}
String MRParamDiagCols[]={"","ICD10","ICD9-CM","CPT4","ICD9-CM"};
String diag_desc=MRParamDiagCols[Integer.parseInt(diag_code_scheme)];
%>
<body onload='FocusFirstElement()' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<form name='ICDUpdate_form' id='ICDUpdate_form' method='post' action='../../servlet/eMR.ICDCodeServlet' target='dummyFrame'>
	<div align='center'>
		<table width='100%' border=0 cellpadding=1 cellspacing=0 height='100%'>
			<tr>
				<th colspan='4' align='left'><fmt:message key="Common.scheme.label" bundle="${common_labels}"/> : <%=diag_desc%></th>
			</tr>
			<tr>
				<td class='label' align=right> <fmt:message key="eMR.TypeDO.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td nowrap class='QUERYDATA'> <input type='hidden' name=type_do size=10 maxlength=10 value="<%=record_type_desc%>" readonly><%=record_type_desc%></td>
				<td class='label' align=right> <fmt:message key="Common.CauseIndicator.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td> <input type='hidden' name=cause_indi size=30 maxlength=30 value="<%=cause_indicator_desc%>" readonly><%=cause_indicator_desc%></td>
			</tr>
			
				<tr>
				<td class='label' align=right> <fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA'> <input type='hidden' name=diag_code size=15 maxlength=15 value="<%=diag_code%>" readonly><%=diag_code%> </td>
				<td class='label' align=right> <fmt:message key="Common.TITLE.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA'> <input type='hidden' name=title size=30 maxlength=75 value="<%=short_desc%>" readonly> <%=short_desc%>&nbsp;&nbsp;</td>
			</tr>
			
				<tr>
				<td class='label' align=right nowrap> <fmt:message key="eMR.Subdivided.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA'> <input type='hidden' name=subdivided size=1 maxlength=1 value="<%=subdivided%>" readonly><%=subdivided%>  (@ - subdivided)</td>
				<td class='label' align=right> <fmt:message key="eMR.RecordSequence.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA'> <input type='hidden' name=rec_seq size=1 maxlength=1 value="<%=record_seq%>" readonly><%=record_seq%> </td>
				

				</tr>
			<tr>
				<td class='label' align=right nowrap> <fmt:message key="eMR.CodeCategory.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA'> <input type='hidden' name=code_cat size=1 maxlength=1 value="<%=category%>" readonly><%=category%> </td>
				<!-- <td></td>
				<td></td> -->
				<td class='label' align=right nowrap><fmt:message key="eMR.CodeType.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td align=left><select name='ctype' id='ctype'>
					<%
					
					if(record_type_desc.equalsIgnoreCase("Disease"))
					{
					record_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Disease.label","mr_labels");
					result = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
					val="O";
					val1 = "D";
					}
					else if(record_type_desc.equalsIgnoreCase("Procedure"))
					{
					record_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
					result = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Disease.label","mr_labels");
					val = "D";
					val1 = "O";
					}
					else if(record_type_desc.equals(""))
					{
					record_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Disease.label","mr_labels");
					result = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
					val = "O";
					val1 = "D";
					}
					%>
				<option value='<%=val1%>'> <%=record_type_desc%></option>
				<option value='<%=val%>'> <%=result%> </option>
					</select>
				</tr>
	
			<tr>
				<td class='label' align=right> <fmt:message key="eMR.GenderSpecific.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td align=left><select name='gender_spec' id='gender_spec'>
			<%		
					if(gender_spec_ind_desc.equals("") || 	gender_spec_ind_desc.equals("Common") )
						out.println("<option value='' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Common.label","mr_labels")+"</option>");
					else
						out.println("<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Common.label","mr_labels")+"</option>");

					if(gender_spec_ind_desc.equals("Male"))
						out.println("<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</option>");
					else
						out.println("<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</option>");

					if(gender_spec_ind_desc.equals("Female"))
						out.println("<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</option>");
					else
						out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</option>");
					%>

				<td class='label' align=right> <fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align='left'><select name='code_ind' id='code_ind'><option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%
				if(code_indicator.equals("D"))
				{
				%>
				<option value='D' selected><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E'><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A'><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C'><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
				<%}%>
				<%
				if(code_indicator.equals("E"))
				{
				%>
				<option value='D' ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E' selected><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A'><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C'><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
				<%}%>
				<%
				if(code_indicator.equals("A"))
				{
				%>
				<option value='D' ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E'><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A' selected><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C'><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
				<%}%>
				<%
				if(code_indicator.equals("C"))
				{
				%>
				<option value='D' ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E'><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A'><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C' selected><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
				<%}%>

				<%if(code_indicator.equals(""))
				{
				%>
				<option value='D' ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E'><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A'><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C' ><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>
				<%}%>

				</select>
				</td>
				<tr>
				<td class='label' align=right nowrap><fmt:message key="eMR.AgeSpecific.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td align=left> <select name='age_spec' id='age_spec'>
				<%
					if(age_spec_ind.equals("Adult"))
						out.println("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Adult.label","common_labels")+"</option>");
					else
						out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Adult.label","common_labels")+"</option>");

					if(age_spec_ind.equals("Common"))
						out.println("<option value='C' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Common.label","mr_labels")+"</option>");
					else
						out.println("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Common.label","mr_labels")+"</option>");	
								
					if(age_spec_ind.equals("Maternity"))
						out.println("<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Maternity.label","mr_labels")+"</option>");
					else
						out.println("<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Maternity.label","mr_labels")+"</option>");
					
					if(age_spec_ind.equals("Newborn"))
						out.println("<option value='N' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBorn.label","mp_labels")+"</option>");
					else
						out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBorn.label","mp_labels")+"</option>");

					if(age_spec_ind.equals("Others"))
						out.println("<option value='O' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
					else
						out.println("<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");


					if(age_spec_ind.equals("Pediatric"))
						out.println("<option value='P' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Pediatric.label","mr_labels")+"</option>");
					else
						out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Pediatric.label","mr_labels")+"</option>");

				%>
				</select>  </td>
				<td class='label' align=right nowrap> <fmt:message key="eMR.ListGroup.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td> <input type='hidden' name=list_grp size=3 maxlength=3 value="<%=list_ab_group%>" readonly> <%=list_ab_group%></td>
			<tr>
				
				<td class='label' align=right> <fmt:message key="eMR.ProcedureClass.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td> <input type='hidden' name=proc_class size=3 maxlength=3 value="<%=dclass%>" readonly><%=dclass%> </td>
				<td class='label' align=right> <fmt:message key="eMR.MajorDiagCat.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td> <input type='hidden' name=mjr_diag_cat size=2 maxlength=2 value="<%=major_diag_cat%>" readonly><%=major_diag_cat%> </td>
			</tr>
			<tr>
				<td class='label' align=right><fmt:message key="eMR.ComplicnComorb.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td nowrap class='QUERYDATA'> <input type='hidden' name=comp_com size=1 maxlength=1 value="<%=hcfa_flag%>" readonly><%=hcfa_flag%> &nbsp;HCFA Flag</td>
				<td class='label' align=right> <fmt:message key="eMR.ComorbCheck.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td nowrap class='QUERYDATA'> <input type='hidden' name=com_chk size=1 maxlength=1 value="<%=hcfa_ck_flag%>" readonly> <%=hcfa_ck_flag%>&nbsp;HCFA Check</td>
			</tr>
			<tr>
				<td class='label' align=right> <fmt:message key="eMR.SpecialEditFlag.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td class='QUERYDATA' nowrap> <input type='hidden' name=spl_edt_flg value="<%=spec_edit_flag%>" readonly> <%=spec_edit_flag%>&nbsp;Medicare/DRG Edit Ind.</td>
				<td class='label' align=right nowrap><fmt:message key="eMR.OprtgRoomProc.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td nowrap class='QUERYDATA'> <input type='hidden' name=oprtg_rm_proc size=1 maxlength=1 value="<%=hcfa_proc_flag%>" readonly><%=hcfa_proc_flag%> &nbsp; HCFA Flag </td>
			</tr>
			<tr>
				<td class='label' align=right> <fmt:message key="eMR.LongTitle.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
				<td colspan=3> <textarea style='resize:none;' rows=5 cols=70 name=long_title  onBlur='makeValidString(this)'><%=long_desc%></textarea>&nbsp; </td>
			</tr>
			<tr>
				<td class='label' align=left colspan='4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				<%
				if(sensitive_yn.equals("Y")) {%>
					<input type='checkbox' name='sensitive' id='sensitive' size=1 maxlength=1 value='Y' CHECKED onclick='ChgVal(this)' >
				<%} else {%>
					<input type='checkbox' name='sensitive' id='sensitive' size=1 maxlength=1 value='N' onclick='ChgVal(this)'>
				<%}%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				<%
				if(notifiable_yn.equals("Y")) {%>
					<input type='checkbox' name='notifiable' id='notifiable' size=1 maxlength=1 value='Y' CHECKED onclick='ChgVal(this)'></td>
				<%} else {%>
					<input type='checkbox' name='notifiable' id='notifiable' size=1 maxlength=1 value='N' onclick='ChgVal(this)'> </td>
				<%}%>
			</tr>
			<tr>
				<td> &nbsp; </td>
				<td> &nbsp; </td>
				<td> &nbsp; </td>
				<td class='button'><input type="button" class=button name="Applyb" id="Applyb" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%> " onclick="saveme()">
				<input type="button" class=button name="Resetb" id="Resetb" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onclick="clearform();"><input type="button" class=button name="Cancelb" id="Cancelb" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="cancelme()" onBlur="long_title.focus();"> &nbsp; </td>
			</tr>
			<tr>
				<td> &nbsp; </td>
				<td> &nbsp; </td>
				<td> &nbsp; </td>
				<td> &nbsp; </td>
			</tr>

		</table>
	</div>
	<input type='hidden' name='diag_srl_no' id='diag_srl_no' value="<%=diag_srl_no%>">
	<input type='hidden' name='diag_desc' id='diag_desc' value="<%=diag_desc%>">
	<input type='hidden' name='eff_status' id='eff_status' value="<%=eff_status%>">
	</form>
</body>
</html>
<%
}
	catch(Exception e){/* out.println(e); */e.printStackTrace();}
	finally
	{
		if(rset1 != null) rset1.close();
		if(stmt1 != null)stmt1.close();
		ConnectionManager.returnConnection(conn1,request);
	}

%>

