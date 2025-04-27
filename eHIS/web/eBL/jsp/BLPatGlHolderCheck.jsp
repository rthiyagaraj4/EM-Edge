<!DOCTYPE html>
  <%@ page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8"  %>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <%

	Connection con = null; ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null, rs1 = null;
	String patient_id ="";
	String billing_group = "";
	String calling_module_id = "";
	String customer_id="";
	String gl_holder_name = "", gl_rel = "", resp_pay = "",resp_pay_rel = "";
	String settlement_ind = "",	adm_rec_flag = "",no_of_dependants="", credit_doc_ref_reqd_yn="N";
	String cald_frm="";
	request.setCharacterEncoding("UTF-8");	

	try
  	{	
		con = ConnectionManager.getConnection(request);
//		System.err.println("From GL Check Query String:"+request.getQueryString());
		billing_group= request.getParameter("billing_group");
		if( billing_group == null) billing_group="";

		calling_module_id = request.getParameter("calling_module_id");
		if(calling_module_id == null) calling_module_id="";

		patient_id= request.getParameter("patient_id");
		if( patient_id == null) patient_id="";	

		cald_frm = request.getParameter("cald_frm");
		if( cald_frm == null) cald_frm="";	

		customer_id = request.getParameter("customer_id");
		if( customer_id == null) customer_id="";	

		String sql1 = "select gl_holder_name, pat_reln_with_gl_holder, resp_for_bill_payment,num_of_dependents,pat_reln_with_resp_pers from bl_patient_fin_dtls where patient_id = '"+patient_id+"'";

		pstmt = con.prepareStatement(sql1);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				gl_holder_name = rs.getString("gl_holder_name");
				gl_rel = rs.getString("pat_reln_with_gl_holder");			
				resp_pay = rs.getString("resp_for_bill_payment");
				no_of_dependants = rs.getString("num_of_dependents")==null?"":rs.getString("num_of_dependents");
				resp_pay_rel= rs.getString("pat_reln_with_resp_pers");
			}
		}
		if (rs != null)   rs.close();
		pstmt.close();		

		if ( gl_holder_name == null ) gl_holder_name = "";
		if ( gl_rel == null ) gl_rel = "";		
		if (resp_pay == null ) resp_pay = "";
		if (resp_pay_rel == null ) resp_pay_rel = "";


		String sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
//System.err.println("sql in gl check:"+sql);

		pstmt = con.prepareStatement(sql);
		rs1 = pstmt.executeQuery() ;
		if( rs1 != null ) 
		{
			while( rs1.next() )
			{  
				settlement_ind = rs1.getString("settlement_ind");
				adm_rec_flag = rs1.getString("adm_rec_flag");
				credit_doc_ref_reqd_yn = rs1.getString("credit_doc_ref_reqd_yn");
			}
		}
		if (rs1 != null)   rs1.close();
		pstmt.close();


		if ( settlement_ind == null ) settlement_ind = "";
		if ( adm_rec_flag == null ) adm_rec_flag = "";
		if(credit_doc_ref_reqd_yn == null) credit_doc_ref_reqd_yn="N";
//		System.err.println("settlement_ind in gl check:"+settlement_ind);
//		System.err.println("adm_rec_flag in gl check:"+adm_rec_flag);
//		System.err.println("credit_doc_ref_reqd_yn in gl check:"+credit_doc_ref_reqd_yn);

	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}


	%>

<html>
	<head>
	<script>	
	function slmtIndCheck(v_slmt_ind){		
		var module_id = parent.frames[0].document.forms[0].calling_module_id.value;
		var operation=parent.frames[0].document.forms[0].operation.value;
		var booleanSecurity =parent.frames[0].document.forms[0].boolean_security.value;
		var SiteSpecific=parent.frames[0].document.forms[0].SiteSpecific.value;
			
		//	if(v_slmt_ind == 'R')			
			if(v_slmt_ind == 'R' || (v_slmt_ind == 'X')){
			parent.frames[0].document.getElementById('sel_resp_for_pay_disp').style.display="none";
			}
		//	else if(v_slmt_ind == 'C' || (v_slmt_ind == 'X'))			
			else if(v_slmt_ind == 'C'){
			parent.frames[0].document.getElementById('sel_resp_for_pay_disp').style.display="inline";
			}	
	
			if(v_slmt_ind == 'R'){
			parent.frames[0].document.forms[0].resp_for_payment.disabled = true;
			/* Added V180914-Aravindh/GDOH-SCF-0292/Disabling Relationship/Starts */
			parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = true;
			parent.frames[0].document.forms[0].patrelbut.disabled = true;
			/* Added V180914-Aravindh/GDOH-SCF-0292/Disabling Relationship/Ends */
			}
			else{
				if(!(module_id== "MP" && operation== "Update" && booleanSecurity== "true"&& SiteSpecific== "Y")){
			parent.frames[0].document.forms[0].resp_for_payment.disabled = false;
			/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Starts */
			parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = false;
			parent.frames[0].document.forms[0].patrelbut.disabled = false;
			/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Ends */
			}	
			}	
		
	}
		 function glholdercheck()
		 {
			 var module_id = parent.frames[0].document.forms[0].calling_module_id.value;
				var operation=parent.frames[0].document.forms[0].operation.value;
				var booleanSecurity =parent.frames[0].document.forms[0].boolean_security.value;
				var SiteSpecific=parent.frames[0].document.forms[0].SiteSpecific.value;
				//Added on 26/10/2004 By BLR Team
				var billing_group = document.forms[0].billing_group.value;	
				var calling_module_id = document.forms[0].calling_module_id.value;
				//Addition ends for variables. Check for Billing group being non empty introduced.  
				var v_slmt_ind = document.forms[0].settlement_ind.value;
				var adm_rec_flag=document.forms[0].adm_rec_flag.value;
				var credit_doc_ref_reqd_yn = document.forms[0].credit_doc_ref_reqd_yn.value;
				var v_gl_yn = parent.frames[0].document.forms[0].third_party_gl_in_use_yn.value;

				var v_gl_holder_name = document.forms[0].gl_holder_name.value;
				var v_no_of_dependants = document.forms[0].no_of_dependants.value;

				var pat_reln_with_gl_holder = document.forms[0].gl_rel.value;
				var v_respay = document.forms[0].resp_pay.value;
				var v_respay_rel = document.forms[0].resp_pay_rel.value;
				var customer_id = document.forms[0].customer_id.value;

				parent.frames[0].document.forms[0].setlmt_ind.value = v_slmt_ind;
				parent.frames[0].document.forms[0].adm_rec_flag.value = adm_rec_flag;
				parent.frames[0].document.forms[0].credit_doc_ref_reqd_yn.value = credit_doc_ref_reqd_yn;

				if (v_gl_yn == "Y") {
				if (v_slmt_ind == "C" || (v_slmt_ind == "X" && adm_rec_flag == "2"))
				{
					parent.frames[0].document.forms[0].gl_holder_name.value = "";
//					parent.frames[0].document.forms[0].no_of_dependants.value = "";
					parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = "";
					
					parent.frames[0].document.forms[0].gl_holder_name.disabled=true;
					parent.frames[0].document.forms[0].no_of_dependants.disabled=true;
					
					parent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=true;
									
					parent.frames[0].document.forms[0].glrelbut.disabled=true;		
					if(calling_module_id != 'MP')
						parent.frames[0].document.forms[0].glbut.disabled=true;			
					if(!(module_id== "MP" && operation== "Update" && booleanSecurity== "true"&& SiteSpecific== "Y")){
					parent.frames[0].document.forms[0].resp_for_payment.disabled=false;
					/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Starts */
					parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = false;
					parent.frames[0].document.forms[0].patrelbut.disabled = false;
					/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Ends */
					}
					if (parent.frames[0].document.forms[0].resp_for_payment.value == null ||
						parent.frames[0].document.forms[0].resp_for_payment.value == "")
					{
						parent.frames[0].document.forms[0].resp_for_payment.value=v_respay;
					}

					parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=false;
					if (parent.frames[0].document.forms[0].pat_reln_with_resp_person.value == null ||
						parent.frames[0].document.forms[0].pat_reln_with_resp_person.value == "")
					{
						parent.frames[0].document.forms[0].pat_reln_with_resp_person.value=v_respay_rel;
					}

					if(parent.frames[0].document.forms[0].resp_for_payment.value == "")
					{
						parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = true;
						parent.frames[0].document.forms[0].patrelbut.disabled = true;
					}
					
				}
				else if(billing_group!='')
				{   
					parent.frames[0].document.forms[0].resp_for_payment.value = "";
					parent.frames[0].document.forms[0].resp_for_payment.disabled=true;			

					parent.frames[0].document.forms[0].pat_reln_with_resp_person.value = "";
					parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=true;			
					parent.frames[0].document.forms[0].patrelbut.disabled=true;			

					parent.frames[0].document.forms[0].gl_holder_name.disabled=false;
					parent.frames[0].document.forms[0].no_of_dependants.disabled=false;
					parent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=false;
					if(parent.frames[0].document.forms[0].gl_holder_name.value != "")
						parent.frames[0].document.forms[0].glrelbut.disabled=false;	
					else
						parent.frames[0].document.forms[0].glrelbut.disabled=true;	
					if(calling_module_id != 'MP')
						parent.frames[0].document.forms[0].glbut.disabled=false;	
					
					/*
					if ( parent.frames[0].document.forms[0].gl_holder_name.value == null ||
						parent.frames[0].document.forms[0].gl_holder_name.value == "" )
					{
						//parent.frames[0].document.forms[0].gl_holder_name.value = v_gl_holder_name;
					}
					*/

					//parent.frames[0].document.forms[0].gl_holder_name.value = "";		
					//parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = "";

					if ( parent.frames[0].document.forms[0].no_of_dependants.value == null ||
						parent.frames[0].document.forms[0].no_of_dependants.value == "" )
					{
						parent.frames[0].document.forms[0].no_of_dependants.value = v_no_of_dependants;
					}
					/*					
					if ( parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value == null ||
						parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value == "" )
					{
						//parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = pat_reln_with_gl_holder;
					}
					*/

				}
				else if(billing_group == '')
					{

					parent.frames[0].document.forms[0].resp_for_payment.value = "";
					parent.frames[0].document.forms[0].resp_for_payment.disabled=true;	

					parent.frames[0].document.forms[0].pat_reln_with_resp_person.value = "";
					parent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=true;	
					parent.frames[0].document.forms[0].patrelbut.disabled=true;			

					parent.frames[0].document.forms[0].gl_holder_name.disabled=false;
					parent.frames[0].document.forms[0].no_of_dependants.disabled=false;
					parent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=false;
					if(parent.frames[0].document.forms[0].gl_holder_name.value != "")
						parent.frames[0].document.forms[0].glrelbut.disabled=false;	
					else
						parent.frames[0].document.forms[0].glrelbut.disabled=true;	
					if(calling_module_id != 'MP')
						parent.frames[0].document.forms[0].glbut.disabled=false;			
					}
				}	
				
				if(document.forms[0].cald_frm.value == "change_bg"){
					parent.frames[0].callSettlements(document.forms[0].billing_group);
				}
				else{	
					if(customer_id=='GP'){
					slmtIndCheck(v_slmt_ind);
					}
					return 1;
				}				
				
				if(customer_id=='GP'){
				slmtIndCheck(v_slmt_ind);
				}
				}
			 
	</script>	
	<!--
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
		-->
			<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script> 
<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


			
	</head>

	<body onLoad='glholdercheck();' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
	<form name='GlHolderCheckForm' id='GlHolderCheckForm' method='post' action=''>		

		<input type="hidden" name="gl_holder_name" id="gl_holder_name"  value="<%=gl_holder_name%>"> </input>
		<input type="hidden" name="no_of_dependants" id="no_of_dependants"  value="<%=no_of_dependants%>"> </input>
		<input type="hidden" name="gl_rel" id="gl_rel"  value="<%=gl_rel%>"></input>
		<input type="hidden" name="resp_pay" id="resp_pay"  value="<%=resp_pay%>"></input>
		<input type="hidden" name="resp_pay_rel" id="resp_pay_rel"  value="<%=resp_pay_rel%>"></input>
		<input type="hidden" name="settlement_ind" id="settlement_ind"  value="<%=settlement_ind%>"></input>
		<input type="hidden" name="adm_rec_flag" id="adm_rec_flag"  value="<%=adm_rec_flag%>"></input>
		<input type="hidden" name="credit_doc_ref_reqd_yn" id="credit_doc_ref_reqd_yn"  value="<%=credit_doc_ref_reqd_yn%>"></input>		
		<input type="hidden" name="billing_group" id="billing_group"  value="<%=billing_group%>"></input>
		<input type="hidden" name="calling_module_id" id="calling_module_id"  value="<%=calling_module_id%>"></input>
		<input type="hidden" name="customer_id" id="customer_id"  value="<%=customer_id%>"></input>
		
		<input type="hidden" name="cald_frm" id="cald_frm"  value="<%=cald_frm%>"></input>	
	</form>
	</body>
</html>



