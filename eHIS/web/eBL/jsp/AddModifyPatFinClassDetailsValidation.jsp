<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
	Connection con = ConnectionManager.getConnection();
try
{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//	String  params		=  (String) session.getValue("params");
	HttpSession httpSession = request.getSession(false);
	String facilityId =  (String)httpSession.getValue("facility_id");
	if(facilityId == null) facilityId="";
	String locale			= (String)session.getAttribute("LOCALE");

	System.err.println("Inside the Class Validation Page");
	String called_for = request.getParameter("called_for") == null ? "" :  request.getParameter("called_for");
	String strModuleId = request.getParameter("strModuleId") == null ? "" :  request.getParameter("strModuleId");
	String siteSpec = request.getParameter("siteSpec") == null ? "" :  request.getParameter("siteSpec");
	
	System.err.println("siteSpec "+siteSpec);


	if(called_for.equals("def_blng_grp_id"))
	{
		String  sql = request.getParameter("sql") == null ? "" : request.getParameter("sql");
		sql = sql.replace('`','\'') ;

		String code  = "";
		String desc  = "";
		String codeField  = request.getParameter("codeField") == null ? "" :  request.getParameter("codeField");
		String descField  = request.getParameter("descField") == null ? "" :  request.getParameter("descField");
		String buttonField  = request.getParameter("buttonField") == null ? "" :  request.getParameter("buttonField");

		boolean flag = false;

		if(!sql.equals(""))
		{
			try
			{	
//				System.err.println("sql:"+sql);

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					code = rs.getString(1);
					desc = rs.getString(2);
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception from query:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
//			System.err.println("code:"+code);
//			System.err.println("desc:"+desc);

			if(flag)
			{ 
					/* if (!strModuleId.equals("OP"))
				{ 
 */%>
					<script>
						var val1 = "parent.frames[0].document.forms[0].<%=codeField%>";
						var val2 = "parent.frames[0].document.forms[0].<%=descField%>";
						var val3 = "parent.frames[0].document.forms[0].<%=buttonField%>";
						var val4 = "parent.frames[0].document.forms[0].<%=descField%>";
						var val5 = "parent.parent.frames[0].document.forms[0].<%=codeField%>";
						var val6 = "parent.parent.frames[0].document.forms[0].<%=descField%>";
						eval(val1).value= "<%=code%>";
						eval(val2).value= "<%=desc%>";
						eval(val5).value= "<%=code%>";
						eval(val6).value= "<%=desc%>";
						eval(val3).disabled = true;
						eval(val4).disabled = true;
					 </script>
<%
				//}
				System.err.println("Assigning to head fields");
			}
			else
			{
%>
					<script>
						var val1 = "parent.frames[0].document.forms[0].<%=codeField%>";
						var val2 = "parent.frames[0].document.forms[0].<%=descField%>";
						var val3 = "parent.frames[0].document.forms[0].<%=buttonField%>";
						var val4 = "parent.frames[0].document.forms[0].<%=descField%>";
						var val5 = "parent.parent.frames[0].document.forms[0].<%=codeField%>";
						var val6 = "parent.parent.frames[0].document.forms[0].<%=descField%>";
						eval(val1).value= "";
						eval(val2).value= "";
						eval(val5).value= "";
						eval(val6).value= "";
						eval(val3).disabled = false;
						eval(val4).disabled = false;
					</script>
<%
			}
		}
	}
	else if(called_for.equals("enc_level_def_IA_class_dtls"))
	{
		String curr_class_type = request.getParameter("class_type") == null ? "" : request.getParameter("class_type");
//		String curr_class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
		String billing_mode = request.getParameter("billing_mode") == null ? "" : request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String blng_grp_id = "", blng_grp_desc = "", slmt_ind="", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "";
		String dependent_inc_freq = "", tot_inc_asset = "", no_of_dependants = "", fam_mem_incl_YN="N";
		String valid_from = "", valid_to = "", last_date = "", annual_income="",family_asset="";
		String sql="";
		int assessmentMonths=0;
//		int temp_total_inc = 0;

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			/*HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			System.err.println("Financial Session value in validation:"+bl_data);
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				System.err.println("Session Values Found");
				blng_grp_id=((String)bl_data.get("blng_grp")).trim();
				if(blng_grp_id == null) blng_grp_id="";

				slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(slmt_ind == null) slmt_ind="";

				class_type=((String)bl_data.get("class_type")).trim();
				if(class_type == null) class_type="";

				class_code=((String)bl_data.get("class_code")).trim();
				if(class_code == null) class_code="";

				remarks=((String)bl_data.get("fin_remarks")).trim();
				if(remarks == null) remarks="";

				inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
				if(inc_asset_ind == null) inc_asset_ind="";

				ind_inc=((String)bl_data.get("ind_inc")).trim();
				if(ind_inc == null) ind_inc="";

				ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
				if(ind_inc_freq == null) ind_inc_freq="";

				spouse_inc=((String)bl_data.get("spouse_inc")).trim();
				if(spouse_inc == null) spouse_inc="";

				spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
				if(spouse_inc_freq == null) spouse_inc_freq="";

				dependent_inc=((String)bl_data.get("dependent_inc")).trim();
				if(dependent_inc == null) dependent_inc="";

				dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
				if(dependent_inc_freq == null) dependent_inc_freq="";

				no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if(no_of_dependants == null) no_of_dependants="";

				valid_from=((String)bl_data.get("valid_from")).trim();
				if(valid_from == null) valid_from="";

				valid_to=((String)bl_data.get("valid_to")).trim();
				if(valid_to == null) valid_to="";

				last_date=((String)bl_data.get("last_date")).trim();
				if(last_date == null) last_date="";

				social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
				if(social_pensioner_id == null) social_pensioner_id="";
			}
			else
			{*/
//				System.err.println("Session Values Not Found:"+patient_id);
				if(!patient_id.equals(""))
				{
					try
					{
						String sql_mp_level_class_dtls = "select BLNG_GRP_ID,SETTLEMENT_IND,CLASSIFICATION_TYPE,CLASSIFICATION_CODE,FINANCIAL_REMARKS,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,NUM_OF_DEPENDENTS,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY'),to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY'),SOCIAL_PENSIONER_ID,ANNUAL_FAMILY_INCOME,FAMILY_ASSETS_VALUE from bl_patient_fin_dtls where patient_id=?";
//						System.err.println("sql_mp_level_class_dtls:"+sql_mp_level_class_dtls);
						pstmt = con.prepareStatement(sql_mp_level_class_dtls);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							blng_grp_id=rs.getString(1);
							if(blng_grp_id == null) blng_grp_id="";

							slmt_ind=rs.getString(2);
							if(slmt_ind == null) slmt_ind="";

							class_type=rs.getString(3);
							if(class_type == null) class_type="";

							class_code=rs.getString(4);
							if(class_code == null) class_code="";

							remarks=rs.getString(5);
							if(remarks == null) remarks="";

							inc_asset_ind=rs.getString(6);
							if(inc_asset_ind == null) inc_asset_ind="";

							ind_inc=rs.getString(7);
							if(ind_inc == null) ind_inc="";

							ind_inc_freq=rs.getString(8);
							if(ind_inc_freq == null) ind_inc_freq="";

							spouse_inc=rs.getString(9);
							if(spouse_inc == null) spouse_inc="";

							spouse_inc_freq=rs.getString(10);
							if(spouse_inc_freq == null) spouse_inc_freq="";

							dependent_inc=rs.getString(11);
							if(dependent_inc == null) dependent_inc="";

							dependent_inc_freq=rs.getString(12);
							if(dependent_inc_freq == null) dependent_inc_freq="";

							no_of_dependants=rs.getString(13);
							if(no_of_dependants == null) no_of_dependants="";

							valid_from=rs.getString(14);
							if(valid_from == null) valid_from="";

							valid_to=rs.getString(15);
							if(valid_to == null) valid_to="";

							social_pensioner_id=rs.getString(16);
							if(social_pensioner_id == null) social_pensioner_id="";

							annual_income = rs.getString(17);
							if(annual_income == null) annual_income="";

							family_asset = rs.getString(18);
							if(family_asset == null) family_asset="";

							if(inc_asset_ind.equals("I"))
							{
								tot_inc_asset = annual_income;
							}
							else if(inc_asset_ind.equals("A"))
							{
								tot_inc_asset = family_asset;
							}
						}
					}
					catch(Exception e)
					{
						System.err.println("Exception from query:"+e );
					}
					finally
					{
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
					}

					try
					{
						String sql_assesement = "SELECT ASSESSMENT_MONTHS FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";
						
						pstmt = con.prepareStatement(sql_assesement);
						pstmt.setString(1,facilityId);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();

//						System.err.println("assessmentMonths:"+assessmentMonths);

						String sql_last_date = "SELECT to_char(add_months(to_date('"+valid_from+"','DD/MM/YYYY'),"+assessmentMonths+"),'dd/mm/yyyy') LAST_DATE FROM DUAL";

						pstmt = con.prepareStatement(sql_last_date);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							last_date = rs.getString("LAST_DATE");
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
//						System.err.println("last_date :"+last_date);

						if(last_date == null) last_date="";
					}
					catch(Exception e)
					{
						System.err.println("Exception from query:"+e );
					}
					finally
					{
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
					}
				}
	//		}
		}

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			if(!class_code.equals(""))
			{
				sql = "SELECT SHORT_DESC CLASSIFICATION_DESC,NVL(INCL_FAMILY_YN,'N') INCL_FAMILY_YN FROM BL_CLASSFCTN_CODE_LANG_VW WHERE CLASSIFICATION_CODE = ? AND LANGUAGE_ID = ?";
				try
				{
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,class_code);
					pstmt.setString(2,locale);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						class_desc = rs.getString("CLASSIFICATION_DESC");
						fam_mem_incl_YN = rs.getString("INCL_FAMILY_YN");
					}
				}
				catch(Exception e)
				{
					System.err.println("Exception from CLASSIFICATION_DESC:"+e );
				}
				finally
				{
					if (pstmt!=null) pstmt.close();
					if (rs!=null)	 rs.close();
				}
				if(class_desc == null) class_desc="";
//				System.err.println("class_desc in validation:"+class_desc);
//				System.err.println("fam_mem_incl_YN in validation:"+fam_mem_incl_YN);
			}
			if(!blng_grp_id.equals(""))
			{
				sql = "SELECT SHORT_DESC BILLING_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID=? AND LANGUAGE_ID = ?";
				try
				{
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,blng_grp_id);
					pstmt.setString(2,locale);
					rs = pstmt.executeQuery();
					if(rs.next())
						blng_grp_desc = rs.getString("BILLING_DESC");
				}
				catch(Exception e)
				{
					System.err.println("Exception from BILLING_DESC:"+e );
				}
				finally
				{
					if (pstmt!=null) pstmt.close();
					if (rs!=null)	 rs.close();
				}
				if(blng_grp_desc == null) blng_grp_desc="";
//				System.err.println("blng_grp_desc:"+blng_grp_desc);
			}
		}

		if(class_type.equals("IA") && curr_class_type.equals("IA"))
		{
			System.err.println("Inside IA");
			if (!strModuleId.equals("MP"))
			{ 
%>
				<script>
					var val1 = "parent.frames[0].document.forms[0].class_code";
					var val2 = "parent.frames[0].document.forms[0].class_desc";
					var val3 = "parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val4 = "parent.frames[0].document.forms[0].remarks";
					var val5 = "parent.frames[0].document.forms[0].inc_asset_ind";
					var val6 = "parent.frames[0].document.forms[0].ind_inc";
					var val7 = "parent.frames[0].document.forms[0].ind_inc_freq";
					var val8 = "parent.frames[0].document.forms[0].spouse_inc";
					var val9 = "parent.frames[0].document.forms[0].spouse_inc_freq";
					var val10 = "parent.frames[0].document.forms[0].dependent_inc";
					var val11 = "parent.frames[0].document.forms[0].dependent_inc_freq";
					var val12 = "parent.frames[0].document.forms[0].tot_inc_asset";
					var val13 = "parent.frames[0].document.forms[0].no_of_dependants";
					var val14 = "parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val15 = "parent.frames[0].document.forms[0].valid_from";
					var val16 = "parent.frames[0].document.forms[0].valid_to";
					var val17 = "parent.frames[0].document.forms[0].last_date";
					var val18 = "parent.frames[0].document.forms[0].social_pensioner_id";
					var val19 = "parent.frames[0].document.forms[0].blng_grp_id";
					var val20 = "parent.frames[0].document.forms[0].blng_grp_desc";

					var val21 = "parent.parent.frames[0].document.forms[0].class_code";
					var val22 = "parent.parent.frames[0].document.forms[0].class_desc";
					var val23 = "parent.parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val24 = "parent.parent.frames[0].document.forms[0].remarks";
					var val25 = "parent.parent.frames[0].document.forms[0].inc_asset_ind";
					var val26 = "parent.parent.frames[0].document.forms[0].ind_inc";
					var val27 = "parent.parent.frames[0].document.forms[0].ind_inc_freq";
					var val28 = "parent.parent.frames[0].document.forms[0].spouse_inc";
					var val29 = "parent.parent.frames[0].document.forms[0].spouse_inc_freq";
					var val30 = "parent.parent.frames[0].document.forms[0].dependent_inc";
					var val31 = "parent.parent.frames[0].document.forms[0].dependent_inc_freq";
					var val32 = "parent.parent.frames[0].document.forms[0].tot_inc_asset";
					var val33 = "parent.parent.frames[0].document.forms[0].no_of_dependants";
					var val34 = "parent.parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val35 = "parent.parent.frames[0].document.forms[0].valid_from";
					var val36 = "parent.parent.frames[0].document.forms[0].valid_to";
					var val37 = "parent.parent.frames[0].document.forms[0].last_date";
					var val38 = "parent.parent.frames[0].document.forms[0].social_pensioner_id";
					var val39 = "parent.parent.frames[0].document.forms[0].blng_grp_id";
					var val40 = "parent.parent.frames[0].document.forms[0].blng_grp_desc";

					var val41 = "parent.frames[0].document.forms[0].class_code_btn";
					var val42 = "parent.frames[0].document.forms[0].blng_grp_btn";
					
					var val43 = "parent.frames[0].document.forms[0].tot_inc_asset";
					var val44 = "parent.parent.frames[0].document.forms[0].tot_inc_asset";

					eval(val1).value= "<%=class_code%>";
					eval(val2).value= "<%=class_desc%>";
					if("<%=slmt_ind%>" == "C")
						eval(val3).value='Y';
//					eval(val4).value= "<%=remarks%>";
					eval(val5).value= "<%=inc_asset_ind%>";
					eval(val6).value= "<%=ind_inc%>";
					eval(val7).value= "<%=ind_inc_freq%>";
					eval(val8).value= "<%=spouse_inc%>";
					eval(val9).value= "<%=spouse_inc_freq%>";
					eval(val10).value= "<%=dependent_inc%>";
					eval(val11).value= "<%=dependent_inc_freq%>";
					eval(val12).value= "<%=tot_inc_asset%>";
					eval(val13).value= "<%=no_of_dependants%>";
					eval(val14).value= "<%=fam_mem_incl_YN%>";
					eval(val15).value= "<%=valid_from%>";
					eval(val16).value= "<%=valid_to%>";
					eval(val17).value= "<%=last_date%>";
					eval(val18).value= "<%=social_pensioner_id%>";
					eval(val19).value= "<%=blng_grp_id%>";
					eval(val20).value= "<%=blng_grp_desc%>";

					eval(val21).value= "<%=class_code%>";
					eval(val22).value= "<%=class_desc%>";
					if("<%=slmt_ind%>" == "C")
						eval(val23).value= "Y";
//					eval(val24).value= "<%=remarks%>";
					eval(val25).value= "<%=inc_asset_ind%>";
					eval(val26).value= "<%=ind_inc%>";
					eval(val27).value= "<%=ind_inc_freq%>";
					eval(val28).value= "<%=spouse_inc%>";
					eval(val29).value= "<%=spouse_inc_freq%>";
					eval(val30).value= "<%=dependent_inc%>";
					eval(val31).value= "<%=dependent_inc_freq%>";
					eval(val32).value= "<%=tot_inc_asset%>";
					eval(val33).value= "<%=no_of_dependants%>";
					eval(val34).value= "<%=fam_mem_incl_YN%>";
					eval(val35).value= "<%=valid_from%>";
					eval(val36).value= "<%=valid_to%>";
					eval(val37).value= "<%=last_date%>";
					eval(val38).value= "<%=social_pensioner_id%>";
					eval(val39).value= "<%=blng_grp_id%>";
					eval(val40).value= "<%=blng_grp_desc%>";
//Commented V170512-Gayathri/GDOH-SCF-0277/Start
				/*	eval(val2).disabled = true;
					eval(val3).disabled = true;
//					eval(val4).disabled = false;
					eval(val5).disabled = true;
					eval(val6).disabled = true;
					eval(val7).disabled = true;
					eval(val8).disabled = true;
					eval(val9).disabled = true;
					eval(val10).disabled = true;
					eval(val11).disabled = true;
					eval(val12).disabled = true;
					eval(val13).disabled = true;
					eval(val15).disabled = true;*/
//					eval(val16).disabled = true;
				//	eval(val18).disabled = false;
					eval(val20).disabled = true;
				/*	eval(val41).disabled = true;
					eval(val42).disabled = true;*/
					//Commented V170512-Gayathri/GDOH-SCF-0277/End
					parent.frames[0].calcTotalInc();

				 </script>
<%
			}
		}
		else
		{
			System.err.println("Inside non IA");
			if (!strModuleId.equals("MP"))
			{
				if(siteSpec.equals("true")){
					if(!(strModuleId.equals("OP")||strModuleId.equals("AE"))){
%>
				<script>
					var val1 = "parent.frames[0].document.forms[0].class_code";
					var val2 = "parent.frames[0].document.forms[0].class_desc";
					var val3 = "parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val4 = "parent.frames[0].document.forms[0].remarks";
					var val5 = "parent.frames[0].document.forms[0].inc_asset_ind";
					var val6 = "parent.frames[0].document.forms[0].ind_inc";
					var val7 = "parent.frames[0].document.forms[0].ind_inc_freq";
					var val8 = "parent.frames[0].document.forms[0].spouse_inc";
					var val9 = "parent.frames[0].document.forms[0].spouse_inc_freq";
					var val10 = "parent.frames[0].document.forms[0].dependent_inc";
					var val11 = "parent.frames[0].document.forms[0].dependent_inc_freq";
					var val12 = "parent.frames[0].document.forms[0].tot_inc_asset";
					var val13 = "parent.frames[0].document.forms[0].no_of_dependants";
					var val14 = "parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val15 = "parent.frames[0].document.forms[0].valid_from";
					var val16 = "parent.frames[0].document.forms[0].valid_to";
					var val17 = "parent.frames[0].document.forms[0].last_date";
					var val18 = "parent.frames[0].document.forms[0].social_pensioner_id";
					var val19 = "parent.frames[0].document.forms[0].blng_grp_id";
					var val20 = "parent.frames[0].document.forms[0].blng_grp_desc";

					var val21 = "parent.parent.frames[0].document.forms[0].class_code";
					var val22 = "parent.parent.frames[0].document.forms[0].class_desc";
					var val23 = "parent.parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val24 = "parent.parent.frames[0].document.forms[0].remarks";
					var val25 = "parent.parent.frames[0].document.forms[0].inc_asset_ind";
					var val26 = "parent.parent.frames[0].document.forms[0].ind_inc";
					var val27 = "parent.parent.frames[0].document.forms[0].ind_inc_freq";
					var val28 = "parent.parent.frames[0].document.forms[0].spouse_inc";
					var val29 = "parent.parent.frames[0].document.forms[0].spouse_inc_freq";
					var val30 = "parent.parent.frames[0].document.forms[0].dependent_inc";
					var val31 = "parent.parent.frames[0].document.forms[0].dependent_inc_freq";
					var val32 = "parent.parent.frames[0].document.forms[0].tot_inc_asset";
					var val33 = "parent.parent.frames[0].document.forms[0].no_of_dependants";
					var val34 = "parent.parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val35 = "parent.parent.frames[0].document.forms[0].valid_from";
					var val36 = "parent.parent.frames[0].document.forms[0].valid_to";
					var val37 = "parent.parent.frames[0].document.forms[0].last_date";
					var val38 = "parent.parent.frames[0].document.forms[0].social_pensioner_id";
					var val39 = "parent.parent.frames[0].document.forms[0].blng_grp_id";
					var val40 = "parent.parent.frames[0].document.forms[0].blng_grp_desc";

					var val41 = "parent.frames[0].document.forms[0].class_code_btn";
					var val42 = "parent.frames[0].document.forms[0].blng_grp_btn";

					eval(val1).value= "";
					eval(val2).value= "";
					eval(val3).value="N";
//					eval(val4).value= "";
					eval(val5).value= "";
					eval(val6).value= "";
					eval(val7).value= "";
					eval(val8).value= "";
					eval(val9).value= "";
					eval(val10).value= "";
					eval(val11).value= "";
					eval(val12).value= "";
					eval(val13).value= "";
					eval(val14).value= "";
	//				eval(val15).value= "<%=valid_from%>";
	//				eval(val16).value= "<%=valid_to%>";
	//				eval(val17).value= "<%=last_date%>";
					eval(val18).value= "";
					eval(val19).value= "";
					eval(val20).value= "";

					eval(val21).value= "";
					eval(val22).value= "";
					eval(val23).value= "";
//					eval(val24).value= "";
					eval(val25).value= "";
					eval(val26).value= "";
					eval(val27).value= "";
					eval(val28).value= "";
					eval(val29).value= "";
					eval(val30).value= "";
					eval(val31).value= "";
					eval(val32).value= "";
					eval(val33).value= "";
					eval(val34).value= "";
	//				eval(val35).value= "<%=valid_from%>";
	//				eval(val36).value= "<%=valid_to%>";
	//				eval(val37).value= "<%=last_date%>";
					eval(val38).value= "";
					eval(val39).value= "";
					eval(val40).value= "";

					eval(val2).disabled = false;
					eval(val3).disabled = false;
//					eval(val4).disabled = false;
					eval(val5).disabled = false;
					eval(val6).disabled = false;
					eval(val7).disabled = false;
					eval(val8).disabled = false;
					eval(val9).disabled = false;
					eval(val10).disabled = false;
					eval(val11).disabled = false;
					eval(val12).disabled = false;
					eval(val13).disabled = false;
					eval(val15).disabled = false;
//					eval(val16).disabled = true;
					eval(val18).disabled = false;
					eval(val20).disabled = false;

					eval(val41).disabled = false;
					eval(val42).disabled = false;

				</script>
<%
				 }
				}
				else{
					%>
									<script>
					var val1 = "parent.frames[0].document.forms[0].class_code";
					var val2 = "parent.frames[0].document.forms[0].class_desc";
					var val3 = "parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val4 = "parent.frames[0].document.forms[0].remarks";
					var val5 = "parent.frames[0].document.forms[0].inc_asset_ind";
					var val6 = "parent.frames[0].document.forms[0].ind_inc";
					var val7 = "parent.frames[0].document.forms[0].ind_inc_freq";
					var val8 = "parent.frames[0].document.forms[0].spouse_inc";
					var val9 = "parent.frames[0].document.forms[0].spouse_inc_freq";
					var val10 = "parent.frames[0].document.forms[0].dependent_inc";
					var val11 = "parent.frames[0].document.forms[0].dependent_inc_freq";
					var val12 = "parent.frames[0].document.forms[0].tot_inc_asset";
					var val13 = "parent.frames[0].document.forms[0].no_of_dependants";
					var val14 = "parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val15 = "parent.frames[0].document.forms[0].valid_from";
					var val16 = "parent.frames[0].document.forms[0].valid_to";
					var val17 = "parent.frames[0].document.forms[0].last_date";
					var val18 = "parent.frames[0].document.forms[0].social_pensioner_id";
					var val19 = "parent.frames[0].document.forms[0].blng_grp_id";
					var val20 = "parent.frames[0].document.forms[0].blng_grp_desc";

					var val21 = "parent.parent.frames[0].document.forms[0].class_code";
					var val22 = "parent.parent.frames[0].document.forms[0].class_desc";
					var val23 = "parent.parent.frames[0].document.forms[0].cash_pay_pat_YN";
//					var val24 = "parent.parent.frames[0].document.forms[0].remarks";
					var val25 = "parent.parent.frames[0].document.forms[0].inc_asset_ind";
					var val26 = "parent.parent.frames[0].document.forms[0].ind_inc";
					var val27 = "parent.parent.frames[0].document.forms[0].ind_inc_freq";
					var val28 = "parent.parent.frames[0].document.forms[0].spouse_inc";
					var val29 = "parent.parent.frames[0].document.forms[0].spouse_inc_freq";
					var val30 = "parent.parent.frames[0].document.forms[0].dependent_inc";
					var val31 = "parent.parent.frames[0].document.forms[0].dependent_inc_freq";
					var val32 = "parent.parent.frames[0].document.forms[0].tot_inc_asset";
					var val33 = "parent.parent.frames[0].document.forms[0].no_of_dependants";
					var val34 = "parent.parent.frames[0].document.forms[0].fam_mem_incl_YN";
					var val35 = "parent.parent.frames[0].document.forms[0].valid_from";
					var val36 = "parent.parent.frames[0].document.forms[0].valid_to";
					var val37 = "parent.parent.frames[0].document.forms[0].last_date";
					var val38 = "parent.parent.frames[0].document.forms[0].social_pensioner_id";
					var val39 = "parent.parent.frames[0].document.forms[0].blng_grp_id";
					var val40 = "parent.parent.frames[0].document.forms[0].blng_grp_desc";

					var val41 = "parent.frames[0].document.forms[0].class_code_btn";
					var val42 = "parent.frames[0].document.forms[0].blng_grp_btn";

					eval(val1).value= "";
					eval(val2).value= "";
					eval(val3).value="N";
//					eval(val4).value= "";
					eval(val5).value= "";
					eval(val6).value= "";
					eval(val7).value= "";
					eval(val8).value= "";
					eval(val9).value= "";
					eval(val10).value= "";
					eval(val11).value= "";
					eval(val12).value= "";
					eval(val13).value= "";
					eval(val14).value= "";
	//				eval(val15).value= "<%=valid_from%>";
	//				eval(val16).value= "<%=valid_to%>";
	//				eval(val17).value= "<%=last_date%>";
					eval(val18).value= "";
					eval(val19).value= "";
					eval(val20).value= "";

					eval(val21).value= "";
					eval(val22).value= "";
					eval(val23).value= "";
//					eval(val24).value= "";
					eval(val25).value= "";
					eval(val26).value= "";
					eval(val27).value= "";
					eval(val28).value= "";
					eval(val29).value= "";
					eval(val30).value= "";
					eval(val31).value= "";
					eval(val32).value= "";
					eval(val33).value= "";
					eval(val34).value= "";
	//				eval(val35).value= "<%=valid_from%>";
	//				eval(val36).value= "<%=valid_to%>";
	//				eval(val37).value= "<%=last_date%>";
					eval(val38).value= "";
					eval(val39).value= "";
					eval(val40).value= "";

					eval(val2).disabled = false;
					eval(val3).disabled = false;
//					eval(val4).disabled = false;
					eval(val5).disabled = false;
					eval(val6).disabled = false;
					eval(val7).disabled = false;
					eval(val8).disabled = false;
					eval(val9).disabled = false;
					eval(val10).disabled = false;
					eval(val11).disabled = false;
					eval(val12).disabled = false;
					eval(val13).disabled = false;
					eval(val15).disabled = false;
//					eval(val16).disabled = true;
					eval(val18).disabled = false;
					eval(val20).disabled = false;

					eval(val41).disabled = false;
					eval(val42).disabled = false;

				</script>
				<% 
				}
			}
		}
	}
}
catch(Exception e)
{
	System.err.println("Main Exception in class validation:"+e);
	out.println(e);
}
finally
{
	ConnectionManager.returnConnection(con, request);
}
%>
</head>
</html>

