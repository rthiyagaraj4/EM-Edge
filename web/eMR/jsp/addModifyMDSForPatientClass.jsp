<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
	 	<script language="javascript" src="../js/MDSForPatientClass.js"></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	StringBuffer sql1 = new StringBuffer();
	String EFF_STATUS = "";
	String mds_code	= "";
	String term_id = "";
	String term_set_desc = "";
	String modify_mds_code = "";
	String mds_desc = "";
	String mode=checkForNull(request.getParameter("mode"));
	String sel="";
	String modify_applicable_to_ip_yn= "";
	String modify_mandatory_for_ip_yn = "";
	String modify_applicable_to_op_yn= "";
	String modify_mandatory_for_op_yn = "";
	String modify_applicable_to_em_yn= "";
	String modify_mandatory_for_em_yn = "";
	String modify_applicable_to_dc_yn= "";
	String modify_mandatory_for_dc_yn = "";
	String modify_app_for_ip_chk_unchk = "";
	String modify_app_for_op_chk_unchk = "";
	String modify_app_for_em_chk_unchk = "";
	String modify_app_for_dc_chk_unchk = "";
	String modify_ip_enable_flg = "";
	String modify_op_enable_flg = "";
	String modify_dc_enable_flg = "";
	String modify_em_enable_flg = "";
	String modify_ip_diag_enable_flg = "";
	String modify_op_diag_enable_flg = "";
	String modify_dc_diag_enable_flg = "";
	String modify_em_diag_enable_flg = "";
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	String ip_stage="";
	String op_stage="";
	String em_stage="";
	String dc_stage="";
	String ip_principal_diag_yn="";
	String op_principal_diag_yn="";
	String em_principal_diag_yn="";
	String dc_principal_diag_yn="";
	String order_category_code="";
	String order_category_desc="";
	String mds_sql="";
	String mds_sub_code = "";
	String mds_sub_desc = "";
	String patient_class="";
	//End
	String enb_flg_dc = "";
	String enb_flg_ip = "";
	String enb_flg_em = "";
	String enb_flg_op = "";
	
	Connection conn=null;
	Statement stmt=null;
    ResultSet rs=null;
	Statement stmt1=null;
    ResultSet rs1=null;
	PreparedStatement psmt=null;
	 try
	 {
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		modify_mds_code = request.getParameter("mds_code")==null?"":request.getParameter("mds_code");
		//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		//Start
		mds_sub_code = request.getParameter("mds_sub_code")==null?"":request.getParameter("mds_sub_code");
		mds_sub_desc = request.getParameter("mds_sub_desc")==null?"":request.getParameter("mds_sub_desc");
		patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		//End
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
		//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		if((modify_mds_code==null || modify_mds_code.equals(""))&&(mds_sub_code==null || mds_sub_code.equals("")))
		 {
			modify_mds_code="";
			mds_sub_code="";
		}
		else if(!(modify_mds_code.equals("") && mds_sub_code.equals("")))//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		 {
			sql1.append("select mds_code,term_set_id,applicable_to_ip_yn,mandatory_for_ip_yn,applicable_to_op_yn,mandatory_for_op_yn,applicable_to_em_yn,mandatory_for_em_yn,applicable_to_dc_yn,mandatory_for_dc_yn,ip_stage,op_stage,em_stage,dc_stage,ip_principal_diag_yn,op_principal_diag_yn,em_principal_diag_yn,dc_principal_diag_yn from mr_mds_for_patient_class where mds_code=? and term_set_id=?");
			
			psmt = conn.prepareStatement(sql1.toString());
			psmt.setString(1,modify_mds_code);
			psmt.setString(2,mds_sub_code);
			rs=psmt.executeQuery();
			while(rs!=null && rs.next())
			 {
				modify_applicable_to_ip_yn =rs.getString("applicable_to_ip_yn");
				modify_mandatory_for_ip_yn = rs.getString("mandatory_for_ip_yn");
				modify_applicable_to_op_yn =rs.getString("applicable_to_op_yn");
				modify_mandatory_for_op_yn = rs.getString("mandatory_for_op_yn");
				modify_applicable_to_em_yn =rs.getString("applicable_to_em_yn");
				modify_mandatory_for_em_yn = rs.getString("mandatory_for_em_yn");
				modify_applicable_to_dc_yn =rs.getString("applicable_to_dc_yn");
				modify_mandatory_for_dc_yn = rs.getString("mandatory_for_dc_yn");
				//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
				//Start
				 ip_stage=rs.getString("ip_stage");
				 if(ip_stage==null)ip_stage="ALL";
				 op_stage=rs.getString("op_stage");
				 if(op_stage==null)op_stage="OC";
				 em_stage=rs.getString("em_stage");
				 if(em_stage==null)em_stage="EC";
				 dc_stage=rs.getString("dc_stage");
				 if(dc_stage==null)dc_stage="ALL";
				 ip_principal_diag_yn=rs.getString("ip_principal_diag_yn");
				  op_principal_diag_yn=rs.getString("op_principal_diag_yn");
				 em_principal_diag_yn=rs.getString("em_principal_diag_yn");
				 dc_principal_diag_yn=rs.getString("dc_principal_diag_yn");
				//End 
				if(modify_applicable_to_ip_yn.equals("Y"))
				 {
					modify_app_for_ip_chk_unchk="checked";
					modify_ip_enable_flg = modify_mandatory_for_ip_yn.equals("Y")?"checked":"";
					modify_ip_diag_enable_flg=ip_principal_diag_yn.equals("Y")?"checked":"";
					enb_flg_ip = "";
				}
				else
				{
					modify_app_for_ip_chk_unchk="";
					modify_ip_enable_flg = "";
					modify_ip_diag_enable_flg="";
					enb_flg_ip = "disabled";
				}
				if(modify_applicable_to_op_yn.equals("Y"))
				 {
					modify_app_for_op_chk_unchk="checked";
					modify_op_enable_flg = modify_mandatory_for_op_yn.equals("Y")?"checked":"";
					modify_op_diag_enable_flg=op_principal_diag_yn.equals("Y")?"checked":"";
					enb_flg_op = "";
				}
				else
				{
					modify_app_for_op_chk_unchk="";
					modify_op_enable_flg = "";
					modify_op_diag_enable_flg="";
					enb_flg_op = "disabled";
				}
				if(modify_applicable_to_em_yn.equals("Y"))
				 {
					modify_app_for_em_chk_unchk="checked";
					modify_em_enable_flg = modify_mandatory_for_em_yn.equals("Y")?"checked":"";
					modify_em_diag_enable_flg=em_principal_diag_yn.equals("Y")?"checked":"";
					enb_flg_em = "";
				}
				else
				{
					modify_app_for_em_chk_unchk="";
					modify_em_enable_flg = "";
					modify_em_diag_enable_flg="";
					enb_flg_em = "disabled";
				}
				if(modify_applicable_to_dc_yn.equals("Y"))
				 {
					modify_app_for_dc_chk_unchk="checked";
					modify_dc_enable_flg = modify_mandatory_for_dc_yn.equals("Y")?"checked":"";
					modify_dc_diag_enable_flg=dc_principal_diag_yn.equals("Y")?"checked":"";
					enb_flg_dc = "";
				}
				else
				{
					modify_app_for_dc_chk_unchk="";
					modify_dc_enable_flg = "";
					modify_dc_diag_enable_flg="";
					enb_flg_dc = "disabled";
				}
				
			}
			
		}
		//Maheshwaran K added onload for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	 %>	<body OnMouseDown='CodeArrest()' onload='FocusFirstElementSub(); LoadDataSet("<%=mode%>","<%=patient_class%>");' onKeyDown = 'lockKey()'>
		<form name='MDSForPatientClass_form' id='MDSForPatientClass_form' action='../../servlet/eMR.MDSForPatClassServlet' method='post' target='messageFrame'><!---->
			<table border='0' cellpadding='' cellspacing='0' width='100%' align='center' id='MDSPatientClassId'>
			<BR>
      			<tr>
					<td class='label' align='right'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
					<td class="fields">
					<!--//Maheshwaran K modified LoadMinDataSubValues() for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
						<select name='mds_code' id='mds_code' <%if(mode.equals("modify")){%> disabled<%}%> onchange='LoadMinDataSubValues(this)'>
							<!--<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> -->
							<%
							
							if(mode.equals("insert"))
								{
								stmt = conn.createStatement();
								//rs = stmt.executeQuery("select mds_code,short_desc,eff_status from mr_mds order by short_desc");
								rs = stmt.executeQuery("select mds_code,short_desc,eff_status from mr_mds where eff_status = 'E' order by short_desc");

								if(rs != null)
								{
									while(rs.next())
									{		
									 mds_code = checkForNull(rs.getString("mds_code"));
									 mds_desc	= checkForNull(rs.getString("SHORT_DESC"));
									 EFF_STATUS = checkForNull(rs.getString("eff_status"));
									 //mds_code = mds_code+"$"+EFF_STATUS;
									if(mds_desc == null || mds_desc.equals("null")) mds_desc = "";
							
									out.println("<option value='"+mds_code+"'>"+mds_desc+"</option>");				
									}
								}
								}else
								{
									stmt = conn.createStatement();
									rs = stmt.executeQuery("select mds_code,short_desc,eff_status from mr_mds where eff_status = 'E'  order by short_desc");
									if(rs != null)
									{
									while(rs.next())
									{		
									 mds_code = checkForNull(rs.getString("mds_code"));
									 mds_desc	= checkForNull(rs.getString("SHORT_DESC"));
									 EFF_STATUS = checkForNull(rs.getString("eff_status"));
									 if(mds_code.equals(modify_mds_code))
										 sel="selected";
									 else
										sel="";									
									out.println("<option value='"+mds_code+"'" +sel+ ">"+mds_desc+"</option>");				
									}
									}
								}
							%>
								</select><img src='../../eCommon/images/mandatory.gif'></img>
								<input type = "hidden" name = "min_data" value = '<%=modify_mds_code%>'>							
						
					</td>
				</tr>
				<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
				<!--Start-->
				<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr id='chartid' style="display:none">
					<td class='label' align='right'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='text' name='chart_desc' id='chart_desc' value ='<%=mds_sub_desc%>' onBlur="SearchMDSLookup(this,document.forms[0].chart_desc_1);"><input type='button' name='chart_btn_id' id='chart_btn_id' value='?' class='button' onclick='GetValuesMDSLookup(document.forms[0].chart_desc,document.forms[0].chart_desc_1); ' <%if(mode.equals("modify")){%> disabled <%}%>><img src='../../eCommon/images/mandatory.gif'></img>
					<input name='chart_desc_1' id='chart_desc_1' type='hidden' value='<%=mds_sub_code%>'>
					</td>
				</tr>
				<tr id='noteid' style="display:none">
					<td class='label' align='right'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='text' name='note_type_desc' id='note_type_desc' value ='<%=mds_sub_desc%>' onBlur="SearchMDSLookup(this,document.forms[0].note_type_desc_1);"><input type='button' name='note_type_btn_id' id='note_type_btn_id' value='?' class='button' onclick='GetValuesMDSLookup(document.forms[0].note_type_desc,document.forms[0].note_type_desc_1); ' <%if(mode.equals("modify")){%>disabled<%}%>><img src='../../eCommon/images/mandatory.gif'></img>
					<input name='note_type_desc_1' id='note_type_desc_1' type='hidden' value='<%=mds_sub_code%>'>
					</td>
				</tr>
				</tr>
				<tr id='diagnosisid' style="display:none">
					<td class='label' align='right'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='text' name='term_id' id='term_id' value ='<%=mds_sub_desc%>' onBlur="SearchMDSLookup(this,document.forms[0].termset_code);"><input type='button' name='term_set_btn_id' id='term_set_btn_id' value='?' class='button' onclick='GetValuesMDSLookup(document.forms[0].term_id,document.forms[0].termset_code); ' <%if(mode.equals("modify")){%>disabled<%}%>><img src='../../eCommon/images/mandatory.gif'></img>
					<input type = "hidden" name = "termset_code" value = '<%=mds_sub_code%>'>
					</td>
					
				</tr>
				<tr id='orderid' style="display:none">
					<td class='label' align='right'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='text' name='order_category_id' id='order_category_id' value ='<%=mds_sub_desc%>' onBlur="SearchMDSLookup(this,document.forms[0].order_category_code);"><input type='button' name='order_cat_btn_id' id='order_cat_btn_id' value='?' class='button' onclick='GetValuesMDSLookup(document.forms[0].order_category_id,document.forms[0].order_category_code); ' <%if(mode.equals("modify")){%>disabled<%}%>><img src='../../eCommon/images/mandatory.gif'></img>
					<input type = "hidden" name = "order_category_code" value = '<%=mds_sub_code%>'>
					</td>
				</tr>
				<!--End-->
				</table>
				<br><br>
				<table border='0' cellpadding='2' cellspacing='1' width='100%' align='center'>
					<tr>
						<td class = "columnheader"><fmt:message key="Common.patientclass.label"bundle="${common_labels}"/></td>
						<td class = "columnheader"><fmt:message key="Common.Applicable.label"bundle="${common_labels}"/></td>
						<td class = "columnheader"><fmt:message key="Common.Mandatory.label"bundle="${common_labels}"/></td>
						<td class = "columnheader"><fmt:message key="Common.Stage.label"bundle="${common_labels}"/></td>
						<td class = "columnheader" id='principal_diag_id'><fmt:message key="eMR.principal.label"bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label"bundle="${common_labels}"/></td>
					</tr>
					<!--Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
					<!--Start-->
					<tr id="ip_tr_id">
						<td class = "fields"><fmt:message key="Common.inpatient.label"bundle="${common_labels}"/></td>
						<td class = "fields"><input type = "checkbox"  name = "chk_ip_app" onclick="chk_app_enable(this,document.forms[0].chk_ip_man);" value = '<%=modify_applicable_to_ip_yn%>'  <%=modify_app_for_ip_chk_unchk%> ></td>
						<td class = "fields"><input type = "checkbox" name = "chk_ip_man"  value = '<%=modify_mandatory_for_ip_yn%>' <%=modify_ip_enable_flg%> onclick="chk_enable(this);" 
						<%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_ip%> <%}%>  ></td>
						<td class = "fields"><select name='ip_stage' id='ip_stage' <%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_ip%> <%}%>  >
						<option value='ALL' <%if(ip_stage.equals("ALL")){%> selected<%}%>><fmt:message key="Common.Both.label"bundle="${common_labels}"/></option>
						<option value='DA' <%if(ip_stage.equals("DA")){%> selected<%}%>><fmt:message key="Common.DischargeAdvice.label"bundle="${common_labels}"/></option>
						<option value='DI' <%if(ip_stage.equals("DI")){%> selected<%}%>><fmt:message key="Common.Discharge.label"bundle="${common_labels}"/></option>
						</select></td> 						
						<td class = "fields" id='ip_prin_diag_id'><input name='ip_principal_diag_yn' id='ip_principal_diag_yn' type='checkbox' onclick='chkprindiag(document.forms[0].ip_principal_diag_yn,document.forms[0].ip_principal_diag_yn_hid)' <%if(mode.equals("insert")){%> disabled  <%} else { %> <%=modify_ip_diag_enable_flg%> <%  }%>></td>
					</tr>
					<tr id="op_tr_id">
						<td class = "fields"><fmt:message key="Common.Outpatient.label"bundle="${common_labels}"/></td>
						<td class = "fields"><input type = "checkbox" name = "chk_op_app" onclick="chk_app_enable(this,document.forms[0].chk_op_man);" value = '<%=modify_applicable_to_op_yn%>' <%=modify_app_for_op_chk_unchk%>></td>
						<td class = "fields"><input type = "checkbox" name = "chk_op_man" value = '<%=modify_mandatory_for_op_yn%>' <%=modify_op_enable_flg%> onclick="chk_enable(this);" <%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_op%> <%}%>></td>
						<td class = "fields"><select name='op_stage' id='op_stage' disabled  style="width:123px"><option value='OC'><fmt:message key="Common.OP.label"bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CheckOut.label"bundle="${common_labels}"/></option></select>
						</td>					
						<td class = "fields" id='op_prin_diag_id'><input name='op_principal_diag_yn' id='op_principal_diag_yn' type='checkbox' onclick='chkprindiag(document.forms[0].op_principal_diag_yn,document.forms[0].op_principal_diag_yn_hid)'  <%if(mode.equals("insert")){%> disabled  <%} else { %> <%=modify_op_diag_enable_flg%> <%  }%>></td>
					</tr>
					<tr id="em_tr_id">
						<td class = "fields"><fmt:message key="Common.emergency.label"bundle="${common_labels}"/></td>
						<td class = "fields"><input type = "checkbox"  name = "chk_em_app" onclick="chk_app_enable(this,document.forms[0].chk_em_man);" value = '<%=modify_applicable_to_em_yn%>' <%=modify_app_for_em_chk_unchk%>></td>
						<td class = "fields"><input type = "checkbox" name = "chk_em_man" value = '<%=modify_mandatory_for_em_yn%>' <%=modify_em_enable_flg%> onclick="chk_enable(this);" <%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_em%> <%}%>></td>
						<td class = "fields"><select name='em_stage' id='em_stage' disabled style="width:123px"><option value='EC'><fmt:message key="Common.AE.label"bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CheckOut.label"bundle="${common_labels}"/></option></select></td> 
						<td class = "fields" id='em_prin_diag_id'><input name='em_principal_diag_yn' id='em_principal_diag_yn' type='checkbox' onclick='chkprindiag(document.forms[0].em_principal_diag_yn,document.forms[0].em_principal_diag_yn_hid)' <%if(mode.equals("insert")){%> disabled  <%} else { %> <%=modify_em_diag_enable_flg%> <%  }%>></td>
					</tr>
					<tr id="dc_tr_id">
						<td class = "fields"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
						<td class = "fields"><input type = "checkbox"  name = "chk_dc_app" onclick="chk_app_enable(this,document.forms[0].chk_dc_man);" value = '<%=modify_applicable_to_dc_yn%>' <%=modify_app_for_dc_chk_unchk%>></td>
						<td class = "fields"><input type = "checkbox" name = "chk_dc_man" value = '<%=modify_mandatory_for_dc_yn%>' <%=modify_dc_enable_flg%> onclick="chk_enable(this);" <%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_dc%> <%}%>></td>
						<td class = "fields"><select name='dc_stage' id='dc_stage' <%if(mode.equals("insert")){%> disabled <%} else {%> <%=enb_flg_dc%> <%}%>  >
						<option value='ALL' <%if(dc_stage.equals("ALL")){%> selected<%}%>><fmt:message key="Common.Both.label"bundle="${common_labels}"/></option>
						<option value='DA' <%if(dc_stage.equals("DA")){%> selected<%}%>><fmt:message key="Common.DischargeAdvice.label"bundle="${common_labels}"/></option>
						<option value='DI' <%if(dc_stage.equals("DI")){%> selected<%}%>><fmt:message key="Common.Discharge.label"bundle="${common_labels}"/></option>
						</select></td> 
						<td class = "fields" id='dc_prin_diag_id'><input name='dc_principal_diag_yn' id='dc_principal_diag_yn' type='checkbox' onclick='chkprindiag(document.forms[0].dc_principal_diag_yn,document.forms[0].dc_principal_diag_yn_hid)' <%if(mode.equals("insert")){%> disabled  <%} else { %> <%=modify_dc_diag_enable_flg%> <%  }%>></td>
					</tr>
					<!--End-->
					
				</table>
				<input name='mode' id='mode' type='hidden' value='<%=mode%>'>
				<input name='chk_ip_app_hid' id='chk_ip_app_hid' type='hidden' value=''>
				<input name='chk_ip_man_hid' id='chk_ip_man_hid' type='hidden' value=''>
				<input name='chk_op_app_hid' id='chk_op_app_hid' type='hidden' value=''>
				<input name='chk_op_man_hid' id='chk_op_man_hid' type='hidden' value=''>
				<input name='chk_em_app_hid' id='chk_em_app_hid' type='hidden' value=''>
				<input name='chk_em_man_hid' id='chk_em_man_hid' type='hidden' value=''>
				<input name='chk_dc_app_hid' id='chk_dc_app_hid' type='hidden' value=''>
				<input name='chk_dc_man_hid' id='chk_dc_man_hid' type='hidden' value=''>
				<!--Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
				<!--Start-->
				<input name='mds_source_sql' id='mds_source_sql' type='hidden' value=''>
				<input name='ip_principal_diag_yn_hid' id='ip_principal_diag_yn_hid' type='hidden' value='N'>
				<input name='op_principal_diag_yn_hid' id='op_principal_diag_yn_hid' type='hidden' value='N'>
				<input name='em_principal_diag_yn_hid' id='em_principal_diag_yn_hid' type='hidden' value='N'>
				<input name='dc_principal_diag_yn_hid' id='dc_principal_diag_yn_hid' type='hidden' value='N'>
				
				<!--End-->
		</form>
	</body>
							
<% 
	if(rs!=null) rs.close();
			if(psmt!=null)psmt.close();
	}
	catch(Exception e)
	{
		e.toString();
	}
	finally
	{
		 try
			 {
				 if(stmt!=null)
	     		stmt.close();
	     		if(rs!=null)
	     		rs.close();
			 }
			 catch(Exception e){
			
	     }

			ConnectionManager.returnConnection(conn,request);
	}
%>
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

