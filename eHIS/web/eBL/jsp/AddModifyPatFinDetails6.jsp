<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , eBL.*,java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
  <%
	String frame_size = "" ;
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	ResultSet rs = null, rs1 = null,rs2 = null,rs3 = null;;
	String sql="";
	String patient_id = request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";	
//	String gl_holder_name = "", gl_rel = "", doc_start_date= "";
	String strdfltbgyn= "";
	String srtencdfltbgyn="";
	String bl_future_admn_YN="";
	String strModuleId = "";
	String strFunctionId = "";
	String nd_settlement_ind ="";
	String nd_adm_rec_flag ="";
	String nd_credit_doc_yn = "";
	String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";

	try
  	{
		String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= null;
		try
		{
			bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		}
		catch(Exception e)
		{
			System.err.println("Error while assigning PkgApprovalBean values:"+e);
			e.printStackTrace();
		}

		String billing_group= "";
		String bmode = request.getParameter("billing_mode");
		if(bmode==null) bmode = "";
		String oper = request.getParameter("operation");
		if(oper==null) oper = "Insert";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		String rtn_non_ins_cust_code="";
		String rtn_non_ins_slmt_type_code="";
		String rtn_inst_ref="";
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			bmode="Add";
			oper="Insert";
			bean.clearBean();
		}

		if((bmode.equals("Modify")) || (oper.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
			billing_group=((String)bl_data.get("blng_grp")).trim();
			rtn_inst_ref=((String)bl_data.get("inst_ref")).trim();
			rtn_non_ins_slmt_type_code=((String)bl_data.get("non_ins_slmt_type_code")).trim();
			rtn_non_ins_cust_code=((String)bl_data.get("non_ins_cust_code")).trim();
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
		}

		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";
	
/* Commented for PE and the values are passed from the Main.JSP
		String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg from bl_mp_param ";
		pstmt = con.prepareStatement(sql0);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
			}
		}
		if(rs2 != null) rs2.close();
		pstmt.close();		

		if ( strdfltbgyn == null || strdfltbgyn.equals("")) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null || srtencdfltbgyn.equals("")) srtencdfltbgyn="N";
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}
		
		if (billing_group == null || billing_group.equals("")) strdfltbgyn = "N";

		bl_future_admn_YN=request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";
/* Commented for PE as the variables are not used anymore
		String sql1 = "select gl_holder_name, pat_reln_with_gl_holder, to_char(credit_doc_ref_start_date,'dd/mm/yyyy') doc_start_date from bl_patient_fin_dtls where patient_id = '"+patient_id+"'";

		pstmt = con.prepareStatement(sql1);
		rs1 = pstmt.executeQuery() ;
		if( rs1 != null ) 
		{
			while( rs1.next() )
			{  
				gl_holder_name = rs1.getString("gl_holder_name");
				gl_rel = rs1.getString("pat_reln_with_gl_holder");
				doc_start_date = rs1.getString("doc_start_date");
				
			}
		}
		if(rs1 != null) rs1.close();
		pstmt.close();		

		if ( gl_holder_name == null ) gl_holder_name = "";
		if ( gl_rel == null ) gl_rel = "";
		if ( doc_start_date == null ) doc_start_date = "";
*/
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");

		strModuleId = request.getParameter("calling_module_id");

		strFunctionId = request.getParameter("calling_function_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "N";
		}
	
		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if (strFunctionId ==null)
		{
			strFunctionId = "";		
		}	

		nd_settlement_ind = request.getParameter("setlmt_ind");
		if(nd_settlement_ind == null) nd_settlement_ind = "";

		nd_adm_rec_flag = request.getParameter("adm_rec_flag");
		if(nd_adm_rec_flag == null) nd_adm_rec_flag = "";

		nd_credit_doc_yn = request.getParameter("credit_doc_ref_reqd_yn");
		if(nd_credit_doc_yn == null) nd_credit_doc_yn = "";

		String package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";

/*		
		if((bmode.equals("Modify")) || (oper.equals("Update")))
		{
		sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_settlement_ind = rs.getString("settlement_ind");
				nd_adm_rec_flag = rs.getString("adm_rec_flag");
				nd_credit_doc_yn = rs.getString("credit_doc_ref_reqd_yn");
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
*/
		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{
			frame_size = "74%,26%";
		}
		else  if(nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0")) 
		{
			if(nd_credit_doc_yn.equals("Y") && package_enabled_yn.equals("Y"))
				frame_size = "22%,78%";
			else if(nd_credit_doc_yn.equals("N") && package_enabled_yn.equals("Y"))
				frame_size = "15%,85%";
			else if(nd_credit_doc_yn.equals("Y") && package_enabled_yn.equals("N"))
				frame_size = "22%,78%";
			else
				frame_size = "11%,88%";
		}
		else
		{
			frame_size = "80%,20%";
		}
%>

<head>
	<title><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></title>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
</head>
	
<%
	String billing_mode = request.getParameter("billing_mode");
	if(billing_mode==null) billing_mode = "";
	String operation = request.getParameter("operation");
	if(operation==null) operation = "Insert";
	boolean boolSecurity = false;	
	boolean boolPatientFoundMP = false;

//	String cust_4 = request.getParameter("cust_4");
	String cust_4 = rtn_non_ins_cust_code;
//	String cash_set_type2 = request.getParameter("cash_set_type2");
	String cash_set_type2 = rtn_non_ins_slmt_type_code;
//	String cash_insmt_ref1 = request.getParameter("cash_insmt_ref1");
	String cash_insmt_ref1 = rtn_inst_ref;

	if(cust_4 == null) cust_4="";
	if(cash_set_type2 == null) cash_set_type2="";
	if(cash_insmt_ref1 == null) cash_insmt_ref1="";
	
/*	String ins_auth_flag = request.getParameter("ins_auth_flag");
	if(ins_auth_flag==null) ins_auth_flag = "N";
	String clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code = "";
	String visit_type_code = request.getParameter("visit_type_code");
	
	if(visit_type_code==null) visit_type_code = "";
*/

	if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
	{
		strdfltbgyn="Y";
	}
	
	if(strdfltbgyn.equals("N"))
	{
		operation="Insert";	
	}
   if ( (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ||strModuleId.equals("MP") || operation.equals("Insert"))
   {
		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{		
%>
		<iframe SRC="../../eBL/jsp/AddModifyPatFinDetailsInsMain.jsp?<%=request.getQueryString()%>" frameborder=0 name='InsuranceFrame' id='InsuranceFrame' style='height:70vh;width:100vw' noresize scrolling='auto' onload='disable();' ></iframe>
<%
		}
		else
		{
%>
		<iframe SRC="../../eBL/jsp/AddModifyPatFinDetails2.jsp?<%=request.getQueryString()%>" style='height:70vh;width:100vw' name='Frame61' id='Frame61 frameborder=0 scrolling='no' noresize></iframe>
<%
		}
   }

   if((billing_mode.equals("Modify")) || (operation.equals("Update")))
   {

		if( ((!(cust_4.equals("")) || !(cash_set_type2.equals(""))) && autoFinChk.equals("N")) || autoFinChk.equals("Y") )
		{
%>
			<iframe SRC='../../eCommon/html/blank.html' frameborder=0 name='Frame62' id='Frame62' scrolling='no' style='height:30vh;width:100vw' noresize></iframe>
<!--
			<FRAME SRC="AddModifyPatFinDetails7.jsp?<%=request.getQueryString()%>" frameborder=0 name='Frame62' scrolling='YES' noresize>
-->
<%	
		}
		if(!(cash_insmt_ref1.equals("")))
		{
%>
			<iframe SRC='../../eCommon/html/blank.html' frameborder=0 name='Frame62' id='Frame62' style='height:30vh;width:100vw' scrolling='auto' noresize></iframe>
<!--
			<FRAME SRC="AddModifyPatFinDetails4.jsp?<%=request.getQueryString()%>" frameborder=0 name='Frame62' scrolling='no' noresize>
-->
<%
		}
	}
%>
	<iframe SRC='../../eCommon/html/blank.html' frameborder=0 name='Frame62' id='Frame62' style='height:30vh;width:100vw' scrolling='auto' noresize></iframe>
  
<input type=hidden name="boolean_security" id="boolean_security" value='<%=boolSecurity%>'>

<%

}
	catch(Exception e)
	{

		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
	}
%>


</html>



