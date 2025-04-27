<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eFM.*" contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eFM/js/FMFileStorageLocation.js" ></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'> 
<%
	Connection conn			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rset			= null;

	String facility_id = (String) session.getValue("facility_id");
	String mode        = request.getParameter( "operation" );

	String sql							= "";
	String StLocnCode					= "";
	String StLocnShortDesc				= "";
	String StLocnLongDesc				= "";
	String MRLocnYN						= "";
	String PFileAreaYN					= "";
	String LocnIdentity					= "";
	String ReturnCriteria				= "";
	String p_file_holder_name			= "",p_file_holder_name_full = "";
	String NoOfDays						= "";
	String narrCode						= "";
	String make_readonly				= "";
	String code_readonly				= "";
	String make_disabled				= "";
	String medical_rec					= "";
	String locn_iden					= "";
	String chk_med_rec					= "";
	String chk_str_loc					= "";
	String p_holder_phone				= "";
	String dept_select					= "";
	String clinic_select				= "";
	String nunit_select					= "";
	String pract_select					= "";	
	String p_perm_radio_state			= "";
	//String p_mr_holder_state			= "";	
	String procedure_select				= "";
	String daycare_select				= "";
	String no_of_dh_to_return_ip		= "";
	String no_of_dh_to_return_op		= "";
	String no_of_dh_to_return_em		= "";
	String no_of_dh_to_return_dc		= "";
	String duration_type				= "";
	String MRSectionCode				= "";
	String MRSecCode					= ""; 
	String SName						= "";
	String single_or_multi_files_ind	= "";
	String mysql						= "";
	String mrsection_disable			= "";
	String maintain_doc_or_file			= "";
	String StLocnEffStatus				= "E";
	String chkEffStatus					= "checked";
	String stroge_locn					= "disabled";
	boolean isCurrentFsLocation = false;//Added for this CRF HSA-CRF-0306

	try
	{
	   isCurrentFsLocation = CommonBean.isSiteSpecific(conn,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306
		stmt = conn.createStatement();
		mysql = "SELECT single_or_multi_files_ind,maintain_doc_or_file from mp_param";
		rset  = stmt.executeQuery(mysql); 
		if(rset != null && rset.next())
		{
			single_or_multi_files_ind	= rset.getString("single_or_multi_files_ind");
			maintain_doc_or_file		= rset.getString("maintain_doc_or_file");
		}
		if(rset!=null)	rset.close();		

		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) maintain_doc_or_file ="";
		if(single_or_multi_files_ind == null || single_or_multi_files_ind.equals("null"))
			single_or_multi_files_ind ="";
		if(single_or_multi_files_ind.equals("S")) mrsection_disable = "disabled";

		if(mode.equals("modify"))
		{
			StLocnCode = request.getParameter("StorageLocnCode");
			sql = "Select a.*,b.appl_user_name From FM_STORAGE_LOCN a , sm_appl_user b where a.FACILITY_ID = '"+facility_id+"' and a.FS_LOCN_CODE = '"+StLocnCode+"' and a.holder_name = b.appl_user_id(+)";
			rset = stmt.executeQuery(sql);
			if(rset != null && rset.next())
			{
				StLocnShortDesc         = rset.getString("SHORT_DESC");
				StLocnLongDesc	        = rset.getString("LONG_DESC");
				MRLocnYN		        = rset.getString("MR_LOCN_YN");
				PFileAreaYN	            = rset.getString("PERMANENT_FILE_AREA_YN");
				LocnIdentity	        = rset.getString("LOCN_IDENTITY");
				ReturnCriteria	        = rset.getString("RETURN_CRITERIA");
				p_file_holder_name      = rset.getString("HOLDER_NAME");
		    	p_file_holder_name_full = rset.getString("appl_user_name");
				p_holder_phone          = rset.getString("HOLDER_PHONE_NO");
				NoOfDays		        = rset.getString("NO_OF_DAYS_TO_RETURN");
				narrCode		        = rset.getString("NARRATION_CODE");
				StLocnEffStatus         = rset.getString("EFF_STATUS");
				MRSectionCode           = rset.getString("MR_SECTION_CODE"); 
				no_of_dh_to_return_ip	=  rset.getString("no_of_dh_to_return_ip");
				no_of_dh_to_return_op	= rset.getString("no_of_dh_to_return_op");
				no_of_dh_to_return_em	=  rset.getString("no_of_dh_to_return_em");
				no_of_dh_to_return_dc	= rset.getString("no_of_dh_to_return_dc");
				duration_type			= rset.getString("duration_type");
				
				if(MRSectionCode == null || MRSectionCode.equals("")) MRSectionCode = "";
 				if(no_of_dh_to_return_ip == null) no_of_dh_to_return_ip = "";
				if(no_of_dh_to_return_op == null) no_of_dh_to_return_op = "";
				if(no_of_dh_to_return_em == null) no_of_dh_to_return_em = "";
				if(no_of_dh_to_return_dc == null) no_of_dh_to_return_dc = "";
				if(duration_type == null) duration_type = "";
				if(ReturnCriteria == null)ReturnCriteria = "";
				if(NoOfDays == null || NoOfDays.equals("null")) NoOfDays = "";

				if(MRLocnYN.equals("Y"))		 
				{
					//p_mr_holder_state = "disabled";
					chk_med_rec	= "checked";
					stroge_locn	= "";	
					locn_iden	= "disabled"; // added on 18/11/04
				}

	  		    if(PFileAreaYN.equals("Y"))	
				{
					chk_str_loc			= "checked";	
					//p_perm_radio_state	= "disabled";
			 	}

				if(p_file_holder_name == null) p_file_holder_name = "";
				if(p_file_holder_name_full == null)p_file_holder_name_full = "";
				if(p_holder_phone == null) p_holder_phone = "";

				if(LocnIdentity.equals("D")) dept_select = "selected";	
				else if(LocnIdentity.equals("C")) clinic_select = "selected";
				else if(LocnIdentity.equals("N")) nunit_select = "selected";
				else if(LocnIdentity.equals("T")) pract_select = "selected";
				else if(LocnIdentity.equals("E")) procedure_select = "selected";
				else if(LocnIdentity.equals("Y")) daycare_select = "selected";
			}

			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();

			if(StLocnEffStatus.equals("E")) chkEffStatus = "checked";
			else if(StLocnEffStatus.equals("D"))
			{
				chkEffStatus	= "unchecked";
				make_readonly	= "readonly"; 
				make_disabled	= "disabled";
				medical_rec		= "disabled";
				stroge_locn		= "disabled";
				locn_iden		= "disabled";
			}
			code_readonly = "readonly";
		}
		else
		{
			mode		= "insert";
			dept_select = "";
			ReturnCriteria="I";
		}
%>
	<form name='FileStorageLocn_form' id='FileStorageLocn_form' action='../../servlet/eFM.FMFileStorageLocnServlet' method='post' target='messageFrame'>
	<div>
	<table border='0' cellpadding='5' cellspacing='0' width='100%' align='center'>			
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='35%' class='FIELDS'><input type='text' name='stglocncode' id='stglocncode' size='8' maxlength='8' value='<%=StLocnCode%>' <%=code_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);' >&nbsp;
			<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td class='label' width='20%'></td>
			<td width='20%'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'><input type='text' name='stglongdesc' id='stglongdesc' size='30' maxlength='30' onBlur="makeValidString(this);" value="<%=StLocnLongDesc%>" <%=make_readonly%> ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		  	<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'><input type='text' name='stgshortdesc' id='stgshortdesc' size='15' maxlength='15' onBlur="makeValidString(this);" value="<%=StLocnShortDesc%>" <%=make_readonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'><select name='mr_section_code' id='mr_section_code' <%=mrsection_disable%>>
					<option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option> 
			<%
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select short_name, mr_section_code from mr_section where facility_id='"+facility_id+"' and eff_status = 'E' order by short_name");
			 while(rset != null && rset.next())
			 {
				SName	    = rset.getString("short_name");
				MRSecCode	= rset.getString("mr_section_code");
				if(MRSecCode.equals(MRSectionCode))
				{
					out.println("<option value='"+MRSecCode+"' selected>"+SName+"</option>");
				}
				else
				{
					out.println("<option value='"+MRSecCode+"'>"+SName+"</option>");
				}
     		 }

			 if(rset!=null)	rset.close();
			 if(stmt!=null)	stmt.close();

			%>
			</select>
		<%	if(single_or_multi_files_ind.equals("M")) { %>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<% } %>
			</td>
			<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>		
	         <td class='FIELDS'><input type='checkbox' name='effstatus' id='effstatus' value='<%=StLocnEffStatus%>' <%=chkEffStatus%> ></td>
		</tr>
    	<tr>
			 <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></td>
        </tr>
		<tr>
			<td  class='label' ><fmt:message key="eFM.BelongstoMRD.label" bundle="${fm_labels}"/></td>
			<td class='FIELDS'><input type='checkbox' name='mrlocation' id='mrlocation' value='<%=MRLocnYN%>' <%=chk_med_rec%> onClick='MRLocnClick(this);' <%=medical_rec%>></td>
       		<td class='label'  nowrap><fmt:message key="Common.Permanent.label" bundle="${common_labels}"/></td>
			<!--<td class='FIELDS'><input type='checkbox' name='permlocation' id='permlocation' value='<%=PFileAreaYN%>' <%=chk_str_loc%> <%=stroge_locn%>  onClick="valReturnCriteria(this)"></td>-->
		<td class='FIELDS'><input type='checkbox' name='permlocation' id='permlocation' value='<%=PFileAreaYN%>' <%=chk_str_loc%> <%=stroge_locn%>></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Identity.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'><select name='locnidentity' id='locnidentity' <%=locn_iden%>>
					<option value='' >---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option> 
					<option value='C' <%=clinic_select%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value='N' <%=nunit_select%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					<option value='E' <%=procedure_select%>><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
					<option value='Y' <%=daycare_select%>><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option> 
					<option value='T' <%=pract_select%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value='D' <%=dept_select%>><fmt:message key="Common.department.label" bundle="${common_labels}"/></option> 
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' ></td>
			<td >&nbsp;</td>
	     </tr>
		<tr>
			<td class='label' ><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></td>
			<td class='FIELDS'><input type='text' onBlur="searchUser(this,'<%=facility_id%>');" size='30' name='p_holder_name1' value="<%=p_file_holder_name_full%>" ><input type='hidden' size='30' maxlength='30' name='p_holder_name' id='p_holder_name' value="<%=p_file_holder_name%>" readonly><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchUser(p_holder_name1,'<%=facility_id%>')" >
			</td>
			<td class='label'></td>
			<td >&nbsp;</td>
	     </tr>
	     <tr>
			<td class='label' ><fmt:message key="eFM.HolderPhoneNo..label" bundle="${fm_labels}"/></td>
			<td class='FIELDS'><input type='text' name='p_holder_phone_no' id='p_holder_phone_no' size='20' maxlength='20' onKeyPress='return chkNumber(event);' onBlur="makeValidString(this);"  value="<%=p_holder_phone%>" <%=make_readonly%> ></td>
			<td class='label' ></td>
			<td >&nbsp;</td>			 
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eFM.Narration.label" bundle="${fm_labels}"/></td>
			<td class='FIELDS' ><select name='narrationcode' id='narrationcode' <%=make_disabled%>>
			<option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option> 
			<%
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select NARRATION_CODE,SHORT_DESC from FM_NARRATION where EFF_STATUS = 'E' order by 2");
			if(rset != null)
			{
			   while(rset.next())
			   {
					String desc	= rset.getString("SHORT_DESC");
					String ID	= rset.getString("NARRATION_CODE");
					if(ID.equals(narrCode))
						out.println("<option value='"+ID+"' selected>"+desc+"</option>");
					else
						out.println("<option value='"+ID+"'>"+desc+"</option>");
			   }
			}
			%>
			</select>
			</td>
			<td class='label' ></td>
			<td >&nbsp;</td>			
		</tr>
		<tr>
			<%if(maintain_doc_or_file.equals("F")){%>
			<td colspan='4' class='COLUMNHEADER'><fmt:message key="eFM.FileReturnDetails.label" bundle="${fm_labels}"/></td>
			<%}else if(maintain_doc_or_file.equals("D")){%>
			<td colspan='4' class='COLUMNHEADER'><fmt:message key="eFM.DocumentReturnDetails.label" bundle="${fm_labels}"/></td>
			<%}%>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td class='FIELDS'>
		<% if(ReturnCriteria.equals("D")) { %>
				<input type='radio' name='retcriteria' id='retcriteria' value='D' CHECKED onClick = 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> ><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/>
				<%if(maintain_doc_or_file.equals("F")){%>
				<input type='radio' name='retcriteria' id='retcriteria' value='I' onClick= 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> >&nbsp;<fmt:message key="eFM.FileIssueDate.label" bundle="${fm_labels}"/>
				<%}else if(maintain_doc_or_file.equals("D")){%>
				<input type='radio' name='retcriteria' id='retcriteria' value='I' onClick= 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> >&nbsp;<fmt:message key="eFM.DocIssueDate.label" bundle="${fm_labels}"/>
				<%}%>
		<%
				make_readonly="disabled";
			}
			else
			{
				%>
				<input type='radio' name='retcriteria' id='retcriteria' value='D' onClick = 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> ><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/>
				<%if(maintain_doc_or_file.equals("F")){%>
				<input type='radio' name='retcriteria' id='retcriteria' value='I' CHECKED onClick= 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> >&nbsp;<fmt:message key="eFM.FileIssueDate.label" bundle="${fm_labels}"/>
				<%}else if(maintain_doc_or_file.equals("D")){%>
				<input type='radio' name='retcriteria' id='retcriteria' value='I' CHECKED onClick= 'RadioOptions(this)' <%=make_disabled%> <%=p_perm_radio_state%> >&nbsp;<fmt:message key="eFM.DocIssueDate.label" bundle="${fm_labels}"/>
				<%}%>
		<%
			}
		%>
			</td>
			<td class='label'></td>
			<td >&nbsp;</td>		
		</tr>

		<tr>
			<td class='label'><fmt:message key="Common.DurationType.label" bundle="${common_labels}"/></td>
			<td class='FIELDS' >
		<%if(duration_type.equals("D")){%>
			<input type="radio" name="duration_type" id="duration_type" value="D" CHECKED onclick="javascript:showIdentity(this,'C');" <%=p_perm_radio_state%> ><fmt:message key="Common.days.label" bundle="${common_labels}"/> 
			<input type="radio" name="duration_type" id="duration_type" value="H" onclick="javascript:showIdentity(this,'C');" <%=p_perm_radio_state%> >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>	
		<%}else{%>
			<input type="radio" name="duration_type" id="duration_type" value="D" onclick="javascript:showIdentity(this,'C');" <%=p_perm_radio_state%> ><fmt:message key="Common.days.label" bundle="${common_labels}"/> 
			<input type="radio" name="duration_type" id="duration_type" value="H" CHECKED onclick="javascript:showIdentity(this,'C');" <%=p_perm_radio_state%> >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>		
		<%}%>
			</td>
			<td  class='label' ></td>
			<td  >&nbsp;</td>		
		</tr>
		<tr>
			<td class='label' >&nbsp;</td>
			<td >
				<TABLE width='100%' border='0' >
					<TR>
						<TD width='18%' class='LABELCENTER'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></TD>
						<!-- <TD width='5%' class='LABELCENTER'></TD> -->
						<TD width='18%' class='LABELCENTER'><fmt:message key="eMP.EM.label" bundle="${mp_labels}"/></TD>
						<!-- <TD width='12%' class='LABELCENTER'></TD> -->
						<TD width='18%' class='LABELCENTER'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></TD>
						<!-- <TD width='10%' class='LABELCENTER'></TD> -->
						<TD width='18%' class='LABELCENTER'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></TD>
						 <TD width='10%' class='LABELCENTER'></TD> 
					</TR>
				</TABLE>
			</td>

			<!-- <td class='label' >&nbsp;&nbsp;&nbsp&nbsp;&nbsp;OP &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			&nbsp;&nbsp;DC</td>-->
			<td class='label' ></td>
			<td >&nbsp;</td>		
		</tr>
		<tr>
<%if(!duration_type.equals("") && duration_type.equals("D")  ){%>
<td class='label' ID="td1" style="display:none"><fmt:message key="eFM.NoofHourstoReturn.label" bundle="${fm_labels}"/> : </td>
<td class='label' ID="td2" ><fmt:message key="eFM.NoofDaystoReturn.label" bundle="${fm_labels}"/> :</td>
<%}else if(!duration_type.equals("") && duration_type.equals("H")  ){%>
	<td class='label'  ID="td1"><fmt:message key="eFM.NoofHourstoReturn.label" bundle="${fm_labels}"/> : </td>
	<td class='label'  ID="td2" style="display:none"><fmt:message key="eFM.NoofDaystoReturn.label" bundle="${fm_labels}"/> : </td>
<%}else{%>
		<td class='label'  ID="td1"><fmt:message key="eFM.NoofHourstoReturn.label" bundle="${fm_labels}"/> : </td>
		<td class='label'  ID="td2" style="display:none"><fmt:message key="eFM.NoofDaystoReturn.label" bundle="${fm_labels}"/> : </td>
<%}%>			
		<td class='FIELDS'><input type='text' name='noofdays_op' id='noofdays_op' size='3' maxlength='3' value='<%=no_of_dh_to_return_op%>'  <%=p_perm_radio_state%> onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNumber(this)" <%=make_disabled%>>
	    	 <b> / </b> 
			 <input type='text' name='noofdays_em' id='noofdays_em' size='3' maxlength='3' value='<%=no_of_dh_to_return_em%>'  <%=p_perm_radio_state%> onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNumber(this)" <%=make_disabled%>>
			 <b> / </b>
			 <input type='text' name='noofdays_ip' id='noofdays_ip' size='3' maxlength='3' value='<%=no_of_dh_to_return_ip%>'  <%=p_perm_radio_state%> onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNumber(this)" <%=make_disabled%>>
   			 <b> / </b>
			 <input type='text' name='noofdays_dc' id='noofdays_dc' size='3' maxlength='3' value='<%=no_of_dh_to_return_dc%>'  <%=p_perm_radio_state%> onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNumber(this)" <%=make_disabled%>>
		</td><input type='hidden' name='noofdays' id='noofdays' size='3' maxlength='3' value='<%=NoOfDays%>' <%//=make_readonly%> <%=p_perm_radio_state%> onKeyPress='return CheckForSpecChars(event)' onBlur="CheckNum(this)">
		<td class='label' ></td>
		<td class='label' ></td>
		</tr>
	</table>
<%
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
		<input type='hidden' name='operation' id='operation' value='<%=mode%>'>
		<input type='hidden' name='storagelocation' id='storagelocation' value=''>
		<input type='hidden' name='locationidentity' id='locationidentity' value=''>
		<input type='hidden' name='returncriteria' id='returncriteria' value='<%=ReturnCriteria%>'>
		<input type='hidden' name='narration' id='narration' value='<%=narrCode%>'>
		<input type='hidden' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='<%=single_or_multi_files_ind%>'>
		<input type='hidden' name='isCurrentFsLocation' id='isCurrentFsLocation' value='<%=isCurrentFsLocation%>'> <!--Added for this CRF HSA-CRF-0306.1 -->
	</form>
</body>
</html>

