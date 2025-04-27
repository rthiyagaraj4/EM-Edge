<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF                              Developer Name
---------------------------------------------------------------------------------------------------------
1            V210223           	 14917  	BL-Common-Secondary Billing Group Window	Mohana Priya K
 -->
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ResultSet  rs2 = null ;
	ResultSet rset = null;

	try
	{
	con = ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	request.setCharacterEncoding("UTF-8");
	String locale=(String)session.getAttribute("LOCALE");
	String fin_class_flag_YN="N", autoFinChk="N", class_code="";

	String query_string=request.getQueryString();
	String primary_blng_grp= request.getParameter("primary_blng_grp");
	if(primary_blng_grp == null) primary_blng_grp="";
	fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
	if(fin_class_flag_YN == null) fin_class_flag_YN="N";

	autoFinChk = request.getParameter("autoFinChk");
	if(autoFinChk == null) autoFinChk="N";

	class_code = request.getParameter("class_code");
	if(class_code == null) class_code="N";
	/*Added for ML-MMOH-CRF-1433/starts*/
	boolean SrchByBlngGp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_MODIFY_FIN_DTL_BIL_GRP");
	/*Added for ML-MMOH-CRF-1433/ends*/
	/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
	boolean restrictBlngGrp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_BLNG_GRP_RESTRICT_FOR_USER");
	String login_user = (String) session.getAttribute("login_user");
	if(login_user == null) {
		login_user = "";
	}
	String fin_auth_user_id = (String) request.getParameter("fin_auth_user_id");
	if(fin_auth_user_id == null) {
		fin_auth_user_id = "";
	}
	/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */

/*
	if(autoFinChk.equals("Y"))
	{
		HashMap bl_data=(HashMap)session.getAttribute("financial_details");
		if(!(bl_data==null || bl_data.isEmpty()))
		{
			System.err.println("Inside Class Loop in bodyedit.jsp");
			class_code = ((String)bl_data.get("class_code")).trim();
		}
	}
*/		
%>
<script>
 async function blnggrplkup(clng_evnt)
	   {			
		var autoFinChk = document.forms[0].autoFinChk.value;
		var target			= document.forms[0].billing_group_desc;
		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{
				document.forms[0].billing_group_desc.value = "";
				document.forms[0].billing_group.value = "";
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				return;
			}
		}
		var billinggroup    = document.forms[0].billing_group.value;

		var retVal			= new String();

		/* var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ; */
		
		var dialogTop			= "10vh";
		var dialogHeight		= "80vh" ;
		var dialogWidth			= "70vw" ;
		var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql1				= "";
		var sql2				= "";		

		var title=getLabel("Common.BillingGroup.label","common");
		title=encodeURIComponent(title);
		var column_sizes = escape("10%,20%,50%,10%,5%,5%,5%,5%");           

		var code=getLabel("Common.code.label","common");
		code=encodeURIComponent(code);
		var desc=getLabel("Common.description.label","common");
		desc=encodeURIComponent(desc);
		var expnote=getLabel("eBL.EXPLANATORY_NOTE.label","BL");
		expnote=encodeURIComponent(expnote);

		var capt_ref_src_dtl=getLabel("eBL.CAPTURE_REF_SOURCE_DTL.label","BL");
		capt_ref_src_dtl=encodeURIComponent(capt_ref_src_dtl);
		var ref_source_main_mand_yn=getLabel("eBL.PRMY_REF_SRC_MAND.label","BL");
		ref_source_main_mand_yn=encodeURIComponent(ref_source_main_mand_yn);
		var ref_source_sub_mand_yn=getLabel("eBL.SEC_REF_SRC_MAND.label","BL");
		ref_source_sub_mand_yn=encodeURIComponent(ref_source_sub_mand_yn);
		var cust_curr_code=getLabel("eBL.CURR_CODE.label","BL");
		cust_curr_code=encodeURIComponent(cust_curr_code);
		var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
		curr_desc=encodeURIComponent(curr_desc);

		var column_descriptions = code+","+desc+","+expnote+','+capt_ref_src_dtl+","+ref_source_main_mand_yn+","+ref_source_sub_mand_yn+","+cust_curr_code+","+curr_desc;

		var message = '';

		var blnggrp			= document.forms[0].blnggrp.value; 		

		var ExtBillingGroup = document.forms[0].ext_billing_group.value;

		var strCitizenYn = document.forms[0].CitizenYn.value;

		var locale = document.forms[0].locale.value;

		var ref_src_code_YN="N";
		var pmry_ref_src_mand_YN="N";
		var sec_ref_src_mand_YN="N";
		
		if (autoFinChk == "Y")
		{
			var primary_blng_grp = document.forms[0].primary_blng_grp.value;
			primary_blng_grp = primary_blng_grp.substring(0,primary_blng_grp.indexOf("|"));
			var class_code = document.forms[0].class_code.value;
	
			sql1 = "select DISTINCT B.APPL_BLNG_GRP_ID BLG_GP,a.short_desc SHORT_DESC,replace(a.detail_desc,chr(10),'<br>') DTL_DESC,nvl(a.CAPTURE_REF_SOURCE_DTL_YN,'N') CAPTURE_REF_SOURCE_DTL_YN, nvl(a.REF_SOURCE_MAIN_MAND_YN,'N') REF_SOURCE_MAIN_MAND_YN, nvl(a.REF_SOURCE_SUB_MAND_YN,'N') REF_SOURCE_SUB_MAND_YN,a.CURRENCY_CODE,a.CURRENCY_DESC from BL_BLNG_GRP_LANG_VW A,BL_APPL_BG_BY_CLASSFCTN B where ( NVL(a.category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) and a.language_id='"+locale+"' AND a.SETTLEMENT_IND='X' AND a.ADM_REC_FLAG='2' AND A.BLNG_GRP_ID=B.APPL_BLNG_GRP_ID AND B.CLASSIFICATION_CODE = '"+class_code+"' AND B.APPL_BLNG_GRP_ID!='"+primary_blng_grp+"' AND";
		}
		else
	    {
			//Modified V20180709-Aravindh/GHL-CRF-0427/Alias name added for table in the below query
			sql1 = "select blng_grp_id BLG_GP,short_desc SHORT_DESC,replace(detail_desc,chr(10),'<br>') DTL_DESC,nvl(CAPTURE_REF_SOURCE_DTL_YN,'N')  CAPTURE_REF_SOURCE_DTL_YN, nvl(REF_SOURCE_MAIN_MAND_YN,'N') REF_SOURCE_MAIN_MAND_YN, nvl(REF_SOURCE_SUB_MAND_YN,'N') REF_SOURCE_SUB_MAND_YN,CURRENCY_CODE,CURRENCY_DESC from BL_BLNG_GRP_LANG_VW a where ( NVL(category,'UNRESTRICTED') IN ( DECODE('"+strCitizenYn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) and language_id='"+locale+"' AND SETTLEMENT_IND='X' AND ADM_REC_FLAG='2' AND";
	    }	
						
		if ( blnggrp == "1" ) 
		{
		sql2 = "  nvl(ref_yn,'N')='Y' and nvl(hcare_only_yn,'N') = 'N' and nvl(status,'X' )!='S' ";
		}

		if ( blnggrp == "2" ) 
		{
		sql2 = " nvl(ref_yn,'N')='Y' and nvl(ref_valid_for_regn_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(hcare_only_yn,'N') = 'N' " ;	
		}

		if ( blnggrp == "3" ) 
		{
		sql2 = " nvl(op_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N' ";
		}

		if ( blnggrp == "4" ) 
		{
		sql2 = "  nvl(ip_yn,'N')='Y' and nvl(status,'X' )!='S' and nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N'";   
		}

		if ( blnggrp == "5" ) 
		{
		sql2 = " nvl(status,'X' ) != 'S' and nvl(health_card_appl_yn,'N')= 'N' and nvl(hcare_only_yn,'N')='N'";
		}

		if (blnggrp == "6") 
		{
		sql2 = " nvl(status,'X' )!='S' and blng_grp_id = '" + ExtBillingGroup + "' ";
		}

		// EPI TYPE ENH

		if ( blnggrp == "7" ) 
		{
		sql2 = " nvl(ae_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N' ";
		}

		if ( blnggrp == "8" ) 
		{
		sql2 = " nvl(dy_yn,'N')='Y' and nvl(status,'X' )!='S' and  nvl(health_card_appl_yn,'N')='N' and nvl(hcare_only_yn,'N')='N' ";
		}
		
		/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
		var restrictBlngGrp	= document.forms[0].restrictBlngGrp.value;
		var SrchByBlngGp	= document.forms[0].SrchByBlngGp.value;
		var login_user	= document.forms[0].login_user.value;
		var fin_auth_user_id	= document.forms[0].fin_auth_user_id.value;
		if(restrictBlngGrp == true || restrictBlngGrp == "true") {
			sql2 = sql2 + " and blng_grp_id NOT in (select c.blng_grp_id from BL_BLNG_GRP_RES_BY_USER c";
			if(fin_auth_user_id != "") {
				sql2 += " where UPPER(c.user_id) = UPPER('"+fin_auth_user_id+"')";
			} else {
				sql2 += " where UPPER(c.user_id) = UPPER('"+login_user+"')";
			}
			sql2 += " and c.blng_grp_id=a.blng_grp_id and trunc(sysdate) between c.restrict_date_From and nvl(c.restrict_date_to, trunc(sysdate))) ";
		}
		/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
		
		sql = escape(sql1 + sql2);		
		
		var param ="";

		//var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNN";

		//Added for ML-MMOH-CRF-1433/starts
		if(SrchByBlngGp == true || SrchByBlngGp == "true") {
			param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYNNN";
		}else{
			//param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNN";
			param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNNNN"; //modified against V210223
		}
		//Added for ML-MMOH-CRF-1433/ends
		retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

		var arr=new Array();		

	    if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		 {
			
			  var retVal=unescape(retVal);
	 
			  if(retVal != null && retVal.length>0)
			  {
				   arr=retVal.split("^~^");				   

	   			   document.forms[0].billing_group_desc.value=arr[1];
				   //.substring(0,16);
				   document.forms[0].billing_group.value=arr[0];		
				   
				   ref_src_code_YN=arr[3];
					pmry_ref_src_mand_YN = arr[4];
					sec_ref_src_mand_YN = arr[5];

					document.forms[0].currency_code_for_bg.value=arr[6];
					document.forms[0].currency_desc_for_bg.value=arr[7];

				   /*if (billinggroup.length == 0 || 
					      (billinggroup.length > 0  && billinggroup != arr[0]))
						  */

				   document.forms[0].blnggrpappyn.value = "Y";
				   document.forms[0].BlngGrpStatus.value = "";
				   document.forms[0].blnggrpcatgappyn.value = "Y";			

				   funChangeBillingGroup(document.forms[0].billing_group);

				    if(ref_src_code_YN=="Y")
					{
						document.getElementById('ref_src_code_main_leg_disp').style.display="inline";
						document.getElementById('ref_src_code_main_val_disp').style.display="inline";
						document.forms[0].referral_source_main_code.value="";
						document.forms[0].referral_source_main_desc.value="";
						if(pmry_ref_src_mand_YN == "Y")
						{
							document.getElementById('ref_src_code_main_mand_disp').style.display="inline";
						}
						else
						{
							document.getElementById('ref_src_code_main_mand_disp').style.display="none";
						}

						document.getElementById('ref_src_code_sub_leg_disp').style.display="inline";
						document.getElementById('ref_src_code_sub_val_disp').style.display="inline";
						document.getElementById("referral_source_sub_code").value="";
						document.getElementById('referral_source_sub_desc').value="";
						if(sec_ref_src_mand_YN == "Y")
						{
							document.getElementById('ref_src_code_sub_mand_disp').style.display="inline";
						}
						else
						{
							document.getElementById('ref_src_code_sub_mand_disp').style.display="none";
						}

						document.forms[0].cap_ref_src_dtl_flag.value="Y";
						document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
						document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
					}
					else if(ref_src_code_YN=="N")
					{
						document.getElementById('ref_src_code_main_leg_disp').style.display="none";
						document.getElementById('ref_src_code_main_val_disp').style.display="none";
						document.forms[0].referral_source_main_code.value="";
						document.forms[0].referral_source_main_desc.value="";

						document.getElementById('ref_src_code_sub_leg_disp').style.display="none";
						document.getElementById('ref_src_code_sub_val_disp').style.display="none";
						document.getElementById('referral_source_sub_code').value="";
						document.getElementById('referral_source_sub_desc').value="";

						document.forms[0].cap_ref_src_dtl_flag.value="N";
						document.forms[0].referral_source_main_mand_YN.value=pmry_ref_src_mand_YN;
						document.forms[0].referral_source_sub_mand_YN.value=sec_ref_src_mand_YN;
					}
					curr_code();//currency code desc 
			  }
			  else
			  {
				  // funChangeBillingGroup(document.forms[0].billing_group);
				   target.focus();
			  }

		 }
	
}
function funChangeBillingGroup(obj)
		{
//				callglholdercheck(obj);				
//				funHealthCardValue(obj);
				callSettlements(obj);	
		}

function callSettlements(Obj)
{
	
	try
	{
		var obj1=document.forms[0].billing_group.value;
		var obj2 = document.forms[0].ins_auth_flag.value;
		var obj3 = document.forms[0].clinic_code.value;
		var obj4 = document.forms[0].visit_type_code.value;
		var obj5 = document.forms[0].show_hide_blng_class.value;
//		var obj6 = document.forms[0].bl_data_from_repos_yn.value;
		var obj7 = document.forms[0].items_disabled.value;
//		var obj8 = document.forms[0].calling_module_id.value;
		var obj9 = document.forms[0].ext_settl_type.value;	
		var obj10 = document.forms[0].patient_id.value;
		var query_string=document.forms[0].query_string.value;
	
		parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBodyFrame.jsp?billing_group='+obj1+'&ins_auth_flag='+obj2+'&clinic_code='+obj3+'&visit_type_code='+obj4+'&show_hide_blng_class='+obj5+'&items_disabled='+obj7+'&id_fun=1&set_typ_from_frame1='+obj9+'&patient_id='+obj10+'&'+query_string;


	}
	catch(e)
	{
	}

}
async function getBlngGrpSearch()
	{
		var billing_group=document.forms[0].billing_group.value;
		
		
		if(billing_group=="select") billing_group="";

		if(billing_group=="")
		{
			alert(getMessage("BL9301","BL"));
			return;
		}
		
		if((billing_group!=""))
		{
			var retVal;
			var dialogHeight= "15" ;
			var dialogWidth	= "43" ;
			var dialogTop = "205" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var url = "../../eBL/jsp/BLBillingGrpDet.jsp?billing_group=	"+billing_group;
			retVal =await window.showModalDialog(url,arguments,features);
		}
		
	}

function refsrclkup(ref_code,ref_desc,called_frm,clng_evnt)
{
	if(clng_evnt == 'B')
	{
		if( ref_desc.value == "")
		{	
			ref_code.value = "";
			ref_desc.value = "";
			if(called_frm == "M")
			{
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";
			}
			else if (called_frm == "S")
			{
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt="";
			}
			return;
		}
	}
	var episode_type=document.forms[0].episode_type.value;
	var locale=document.forms[0].locale.value;
	var billing_group=document.forms[0].billing_group.value;

	var retVal			= new String();		
	var dialogTop			= "130";
	var dialogHeight		= "32" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";		
		
	var title=getLabel("Common.referralsource.label","common");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,20%,20%,30%,10%");               

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var short_desc=getLabel("Common.shortdescription.label","common");
	short_desc=encodeURIComponent(short_desc);
	var long_desc=getLabel("Common.longdescription.label","common");
	long_desc=encodeURIComponent(long_desc);
	var long_name=getLabel("Common.longname.label","common");
	long_name=encodeURIComponent(long_name);
	var org_type=getLabel("Common.OrganisationType.label","common");
	org_type=encodeURIComponent(org_type);
	var column_descriptions = code+","+short_desc+","+long_desc+","+long_name+","+org_type;

	var gov_leg = getLabel("eBL.GOVT_REFERRAL.label","BL");
	gov_leg=encodeURIComponent(gov_leg);

	var pvt_leg = getLabel("eBL.PVT_REFERRAL.label","BL");
	pvt_leg=encodeURIComponent(pvt_leg);

	var message = '';
		
	if (billing_group.length == 0) return;

	var sql="called_for=REFSRCLKUP&locale="+locale+"&episode_type="+episode_type;

/*
	var sql="Select REFERRAL_CODE REFERRAL_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC,LONG_NAME LONG_NAME,decode(ORG_TYPE,'G','"+gov_leg+"','P','"+pvt_leg+"') ORG_TYPE from AM_REFERRAL_LANG_VW where (('"+episode_type+"' = 'R' and SOURCE_USE_AT_REGN_YN='Y') or ('"+episode_type+"' in ('O','E') and SOURCE_USE_AT_VISIT_YN ='Y') or ('"+episode_type+"' in ('I','D') and SOURCE_USE_AT_ADM_YN ='Y')) and language_id = '"+locale+"' and nvl(eff_status,'E')='E'";

	sql = escape(sql);					

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(ref_desc.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYY";
*/

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(ref_desc.value)+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	

	var arr=new Array();					
		
	if(retVal == null) retVal='';	
	
	if (retVal != null || retVal != "")
	{	
		var retVal=unescape(retVal);				

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			ref_code.value=arr[0];
			ref_desc.value=arr[1];
			var ref_src_lng_name = arr[3];

			if(called_frm == "M")
			{
				if(ref_src_lng_name != "")
				{
					document.getElementById('pmy_ref_src_lng_name').style.visibility="visible";
					document.getElementById('pmy_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				}
			}
			else if (called_frm == "S")
			{
				if(ref_src_lng_name != "")
				{
					document.getElementById('sec_ref_src_lng_name').style.visibility="visible";
					document.getElementById('sec_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				}
			}
		}	
		else
		{
			ref_code.value="";
			ref_desc.value="";
			if(called_frm == "M")
			{
				document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('pmy_ref_src_lng_name').alt="";
			}
			else if (called_frm == "S")
			{
				document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('sec_ref_src_lng_name').alt=arr[3];
			}
		}
	}
	else
	{
		ref_code.value="";
		ref_desc.value="";
		if(called_frm == "M")
		{
			document.getElementById('pmy_ref_src_lng_name').style.visibility="hidden";
			document.getElementById('pmy_ref_src_lng_name').alt="";
		}
		else if (called_frm == "S")
		{
			document.getElementById('sec_ref_src_lng_name').style.visibility="hidden";
			document.getElementById('sec_ref_src_lng_name').alt=arr[3];
		}
	}
}

function curr_code()
{
	var currency_desc_for_bg = document.forms[0].currency_desc_for_bg.value;

	if(currency_desc_for_bg != "")
	{
		document.getElementById('bg_curr_desc_disp').style.display="inline";
		document.getElementById('bg_curr_desc').innerText=currency_desc_for_bg;
	}
	else
	{
		document.getElementById('bg_curr_desc_disp').style.display="none";
		document.getElementById('bg_curr_desc').innerText="";

	}
}
</script>
<html>	
<head>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>

<%
	String facility_id  =  ""; 

	//String strQuery = " ";

//	String strBlngClass ="";
//	String strBillType ="";
//	String mbilling_class="",memployer_code="",package_flag="";
//	String pkg_bill_type = "",	pkg_bill_no = "";

	String mbilling_group="";
	String ins_auth_flag="",upd_pat_flag="";

	String clinic_code ="",visit_type_code="",show_hide_blng_class="";
//Unused Var's
/*
	String display="N",display_mode="";
	String strEpisodeType = ""; //request.getParameter("episode_type");  
	String strSpecialSchemeBlngGrpDesc="";
*/
	String billing_group="";
	String strExtSettlType = "";
	String nationalityyn = "";
	String strdfltbgyn = "N";
	String srtencdfltbgyn="N";
	String strSplSchemeBlngGrpPresent = "0";
	String strblnggrp ="0";
	String strBlngGrpAppYN= "Y";
	String strRepositoryYN="";
	String strBlngGrpCatgAppYN = "Y";
	String strBlngGrpStatus="";
	String strCategory = "";
	String care_locn_type_ind="";
	String priority="";
	String strCitizenYn = "N";
	String strBillGrpId = "";
	String strBillingQuery ="";
	String strExtBillingGroup = "";
	String strArrayHealthCard_YN="";
	String strArrayBillingApp_YN="";	
	String strSpecialSchemeBlngGrp="";	
	
	String strModuleId = "";
	String alt_id1_exp_date = "";
	String strBillingOverride = "Y";
	String strItemsDisabled = "";
	boolean boolChangeBillQry = false;
	String str_slmt_type_code="";

	String p_patient_class  ="",episode_type="";

//	billing_group=request.getParameter("billing_group");
	if(billing_group==null) billing_group="";

	ins_auth_flag = request.getParameter("ins_auth_flag");
	if(ins_auth_flag==null) ins_auth_flag = "N";
	
	upd_pat_flag=request.getParameter("upd_pat_flag");
	if(upd_pat_flag==null) upd_pat_flag = "N";

	visit_type_code = request.getParameter("visit_type_code");
	if(visit_type_code==null) visit_type_code="";

	strRepositoryYN=request.getParameter("bl_data_from_repos_yn");
	if(strRepositoryYN==null) strRepositoryYN="";

	show_hide_blng_class=request.getParameter("show_hide_blng_class");
	if(show_hide_blng_class==null) show_hide_blng_class="SHOW";
	
	nationalityyn = request.getParameter("nationality_yn");		
	if (nationalityyn == null) nationalityyn = "";	
	
	strModuleId = request.getParameter("calling_module_id");
	if(strModuleId==null) strModuleId="";

	p_patient_class = request.getParameter("patient_class");
	if(p_patient_class == null) p_patient_class="";

	if(p_patient_class ==null || (p_patient_class.equals("")))
	{
		if(strModuleId.equals("MP")) p_patient_class="XT";
		else if(strModuleId.equals("EM")) p_patient_class="EM";
		else if(strModuleId.equals("OP")) p_patient_class="OP";
		else if(strModuleId.equals("IP")) p_patient_class="IP";
		else if(strModuleId.equals("DC")) p_patient_class="DC";
	}

	if(strModuleId.equals("MP")) episode_type="R";
	else if(strModuleId.equals("AE")) episode_type="E";
	else if(strModuleId.equals("OP")) episode_type="O";
	else if(strModuleId.equals("IP")) episode_type="I";
	else if(strModuleId.equals("DC")) episode_type="D";
	
	facility_id = (String)httpSession.getValue("facility_id");	
	if(facility_id==null) facility_id="";

	care_locn_type_ind = 	request.getParameter("care_locn_type_ind");
	if( care_locn_type_ind==null || care_locn_type_ind.equals("")) 	care_locn_type_ind ="";

	clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	priority=request.getParameter("priority");
	if(priority==null)	priority ="";

	String patient_id = request.getParameter("patient_id");
	if(patient_id==null) patient_id="";

	strItemsDisabled=request.getParameter("items_disabled");
	if(strItemsDisabled==null) strItemsDisabled="";

	strdfltbgyn = request.getParameter("dfltbgyn");
	if ( strdfltbgyn == null) strdfltbgyn = "N";

	srtencdfltbgyn = request.getParameter("encdfltbgyn");
	if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

	String str_blng_grp_id = "";
	String str_short_desc = "";	

	String str_currency_code_for_bg = "",str_currency_desc_for_bg="";

	boolean boolPatientFoundMP = false;
	boolean boolSecurity = false;	

	if (strRepositoryYN.equals("Y"))
	{
		strExtBillingGroup=billing_group;
		strExtSettlType = str_slmt_type_code;
		try
		{
			StringTokenizer strTokenizer = new StringTokenizer(strItemsDisabled,"|");
			String strTotData = "";
			
			int intIdx = 0;
			String strColumn="";
			String strOverride ="N";
			while(strTokenizer.hasMoreElements())
			{	
				strTotData = strTokenizer.nextToken();
					
				intIdx = strTotData.indexOf("-");
				strColumn = strTotData.substring(0,intIdx);
				strOverride = strTotData.substring(intIdx+1);

				
				if (strColumn.equals("billing_group")) 
				{
					if (strOverride.equals("N"))
					{
						strBillingOverride = "N";
					}
					else 
					{
						strBillingOverride = "Y";
					}
				}
			}
		}
		catch(Exception excep)
		{
			//out.println("Exception 3::"+excep);
			excep.printStackTrace();
		}
	}

	if (strExtBillingGroup == null) strExtBillingGroup = "";
	if (strExtSettlType == null) strExtSettlType="";

	mbilling_group=billing_group;
/* Commented and moved down for PE Changes
	try
	{
		pstmt = con.prepareStatement("select to_char(alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date from mp_patient where patient_id = ?");
		pstmt.setString(1, patient_id);
		rs = pstmt.executeQuery();
		if (rs.next())
		{
			alt_id1_exp_date = rs.getString("alt_id1_exp_date");
			if (alt_id1_exp_date == null) alt_id1_exp_date = "";
			boolPatientFoundMP = true;
		}
		if(rs != null) rs.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception in 1:"+e);
		e.printStackTrace();
	}
*/
	if(!patient_id.equals(""))
	{
		try
		{
			String sqlCiti = "select citizen_yn,to_char(alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date from mp_patient where patient_id = ? ";
			pstmt = con.prepareStatement(sqlCiti);
			pstmt.setString(1,patient_id);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					strCitizenYn = rs2.getString("citizen_yn");
					alt_id1_exp_date = rs.getString("alt_id1_exp_date");
					boolPatientFoundMP = true;
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close();	
			if (alt_id1_exp_date == null) alt_id1_exp_date = "";
			if(strCitizenYn == null) strCitizenYn="N";
		}
		catch(Exception e)
		{
			System.out.println("Exception1:"+e);
			e.printStackTrace();
		}
	}
/* Commented as these variables are available as IN Parameters
	try
	{
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
	}
	
	catch(Exception e)
	{
		System.out.println("Exception2:"+e);
		e.printStackTrace();
	}
	if ( strdfltbgyn == null) strdfltbgyn = "N";
	if ( srtencdfltbgyn == null) srtencdfltbgyn="N";
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

	if (strModuleId.equals("MP"))
	{
		strCitizenYn = nationalityyn;
		strdfltbgyn = "Y";
	}

if (strModuleId.equals("MP") && (boolPatientFoundMP == true))	
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" REF_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
							"  (((NVL(REF_YN,'N')='Y' AND NVL(HCARE_ONLY_YN,'N') = 'N' AND "+
							" nvl(status,'X' )!='S') "+
							" OR BLNG_GRP_ID = ? )) and language_id=? order by 2";

	   strblnggrp = "1";
		
	}

	if (strModuleId.equals("MP") && (boolPatientFoundMP == false))
	{
		strBillingQuery =" SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" REF_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
						" WHERE "+
						" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+	
						" (((NVL(REF_YN,'N')='Y' AND NVL(REF_VALID_FOR_REGN_YN,'N')='Y' AND "+
						" nvl(status,'X' )!='S')  AND NVL(HCARE_ONLY_YN,'N') = 'N'  "+
						" OR BLNG_GRP_ID = ? )) and language_id=? order by 2";	

		strblnggrp = "2";
		
	}

	//if (strModuleId.equals("OP")||strModuleId.equals("AE"))

	if (strModuleId.equals("OP"))
	{

		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" OP_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE "+
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(OP_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
							" OR ( BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' )))  and language_id=? order by 2";
		strblnggrp = "3";
	
	 
	}
	

	//if (strModuleId.equals("IP") || strModuleId.equals("DC"))

	if (strModuleId.equals("IP"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" IP_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " + 
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
								" ((NVL(IP_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
							" OR (BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ) )) and language_id=? order by 2";
		strblnggrp = "4";

	}

	if (strBillingQuery.equals("")) 
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ( nvl(status,'X' )!='S'    AND ( NVL(HEALTH_CARD_APPL_YN,'N')= 'N' AND NVL(HCARE_ONLY_YN,'N')='N')  "+ 
							" OR BLNG_GRP_ID = ? ))) and language_id=? order by 2";
		
		strblnggrp = "5";


		

	}

	if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals("")))
	{
		boolChangeBillQry =true;
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+
						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						"  REF_YN , status , category  FROM BL_BLNG_GRP_LANG_VW WHERE "+
							" ( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) AND "+
							" (( nvl(status,'X' )!='S' "+ 
							" AND BLNG_GRP_ID = ? )) and language_id=?";
		strblnggrp = "6";
		
	}


	if (strModuleId.equals("AE"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
							" AE_YN , status , category "+
							" FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " +
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(AE_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N')) "+
							" OR ( BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ))) and language_id=? order by 2";
		strblnggrp = "7";
	 
	}

	if (strModuleId.equals("DC"))
	{
		strBillingQuery = "SELECT BLNG_GRP_ID,short_desc, "+						"	NVL(DECODE(NVL(HCARE_ONLY_YN,'N'),'Y','R','N',NVL(DECODE(NVL(HEALTH_CARD_APPL_YN,'N'),'Y','C','N'),'N')),'N') DCODED, "+
						" DY_YN , status , category FROM BL_BLNG_GRP_LANG_VW "+
							" WHERE " + 
							" ((( NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','OTHERS'), 'UNRESTRICTED')) AND "+
							" ((NVL(DY_YN,'N')='Y' AND "+
							" NVL(STATUS,'X' )!='S') AND ( NVL(HEALTH_CARD_APPL_YN,'N')='N' AND NVL(HCARE_ONLY_YN,'N')='N'))  "+
							" OR (BLNG_GRP_ID = ? AND NVL(?,'N') = 'Y' ))) and language_id=? order by 2";
		strblnggrp = "8";

	}

	if (
		((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) ||
		((strModuleId.equals("IP") || strModuleId.equals("DC") || strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true))
	   )
	{
		boolSecurity = true;
	}
%> 

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='curr_code();'>
<form name='' id='' method='post'   scrolling=no >
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<tr>

<%
	try
	{	
		String query="select BL_eBLCOMMON.BL_GET_ENCNTR_DEFAULT_BG(?,?,?,?,?) from dual";		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,care_locn_type_ind);
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,priority);
		pstmt.setString(5,strCitizenYn);
		rset = pstmt.executeQuery();

		if(rset!=null && rset.next())
		 {
			strBillGrpId = rset.getString(1); 
		 }
				
		if ( strBillGrpId == null ) strBillGrpId = "";
		if(rset != null) rset.close();
			pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Exception2:"+e);
		e.printStackTrace();			
	}		

	pstmt = con.prepareStatement( strBillingQuery ) ;
	
	if(strModuleId.equals("MP") || strBillingQuery.equals("")){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,mbilling_group);
		pstmt.setString(3,locale);
	}
	if(strModuleId.equals("OP") || strModuleId.equals("IP") || strModuleId.equals("AE") || strModuleId.equals("DC")){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,mbilling_group);
		pstmt.setString(3,strdfltbgyn);
		pstmt.setString(4,locale);
	}
	if (strRepositoryYN.equals("Y") && strBillingOverride.equals("N") && strModuleId.equals("MP") &&  (boolPatientFoundMP ==false) &&(!strExtBillingGroup.equals(""))){
		pstmt.setString(1,strCitizenYn);
		pstmt.setString(2,strExtBillingGroup);
		pstmt.setString(3,locale);
	}
		
	rs = pstmt.executeQuery();

	if( rs != null )
	{
		String blng_grp_id = strExtBillingGroup;
		String short_desc = strExtBillingGroup;		
		boolean boolRecordFound = false;
		while( rs.next() ) 
		{
			blng_grp_id = rs.getString( "blng_grp_id" ) ;
			short_desc = rs.getString( "short_desc" ) ;			

			if(blng_grp_id.equals(strBillGrpId))
			{
				 str_blng_grp_id = rs.getString( "blng_grp_id" ) ;
				 str_short_desc = rs.getString( "short_desc" ) ;
			}
		
			strArrayHealthCard_YN = strArrayHealthCard_YN + (blng_grp_id+"-"+rs.getString(3)+"|");	
			strArrayBillingApp_YN = strArrayBillingApp_YN + rs.getString(4)+"|";	

			if (strSpecialSchemeBlngGrp.equals(blng_grp_id))
				strSplSchemeBlngGrpPresent = "1"; 

			if (mbilling_group.equals(blng_grp_id))		
			{
				strBlngGrpAppYN = rs.getString(4);
				strBlngGrpStatus = rs.getString("status");
				strCategory = rs.getString("category");

				if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
					strBlngGrpAppYN = "N";		
				if(strBlngGrpStatus == null ||strBlngGrpStatus.equals("null")) 
					strBlngGrpStatus="";
				if(strCategory == null ||strBlngGrpAppYN.equals("null") || strCategory.equals("")) 
					strCategory="UNRESTRICTED";		
				
				if (strCitizenYn.equals("Y"))
				{
					if (strCategory.equals("UNRESTRICTED") || strCategory.equals("NATIONALS"))
					{
						strBlngGrpCatgAppYN = "Y";
					}
					else
					{
						strBlngGrpCatgAppYN = "N";
					}
				}
				else
				{
					if (strCategory.equals("UNRESTRICTED") || strCategory.equals("OTHERS"))
					{
						strBlngGrpCatgAppYN = "Y";
					}
					else
					{
						strBlngGrpCatgAppYN = "N";
					}
				}
			}

			if (boolChangeBillQry == false)
			{
				if((mbilling_group.equals(blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
				{
					str_blng_grp_id = blng_grp_id;
					str_short_desc = short_desc;
				}
				else
				{																

				}
			}
			else
			{
				str_blng_grp_id = blng_grp_id;
				str_short_desc = short_desc;
			}
			boolRecordFound = true;
		}
		if ((boolRecordFound == false) && (boolChangeBillQry == true))
		{
			str_blng_grp_id = blng_grp_id;
			str_short_desc = short_desc;
		}			
			
	}

	if(str_blng_grp_id==null || str_blng_grp_id=="") str_blng_grp_id="";

	if(!str_blng_grp_id.equals(""))
	{
		String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
//		System.out.println("currency_desc_for_bg_qry:"+currency_desc_for_bg_qry);
		pstmt = con.prepareStatement( currency_desc_for_bg_qry ) ;
		rs = pstmt.executeQuery();

		if( rs != null )
		{
			while( rs.next() ) 
			{
				str_currency_code_for_bg = rs.getString(1);
				str_currency_desc_for_bg = rs.getString(2);
			}
			if(str_currency_code_for_bg == null) str_currency_code_for_bg="";
			if(str_currency_desc_for_bg == null) str_currency_desc_for_bg="";

			if (rs != null) rs.close();
				pstmt.close();	
		}	
	}
//	System.out.println("str_currency_code_for_bg:"+str_currency_code_for_bg);
//	System.out.println("str_currency_desc_for_bg:"+str_currency_desc_for_bg);


	if (strSplSchemeBlngGrpPresent==null||strSplSchemeBlngGrpPresent.equals("null"))		
		strSplSchemeBlngGrpPresent="0";		
	if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
		strBlngGrpAppYN = "N";		
	if(rs != null) rs.close();
	pstmt.close();		
%>
<td width="25%" class="label"><a href="javascript:getBlngGrpSearch();"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="bg_curr_desc_disp" style="display:inline"><Font color='red'><b id="bg_curr_desc"></b></font></div></td>
<td class='fields' width="75%" nowrap colspan=3><input type='text' name="billing_group_desc" id="billing_group_desc" maxlength='40' size='40' tabindex='0' value="<%=str_short_desc%>"  onBlur="return blnggrplkup('B')"><input type='button' class='button' name="blnggrpbut" id="blnggrpbut" value='?' onClick="return blnggrplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%
	String referral_source_capture_YN="N";
	String referral_source_main_mand_YN="N";
	String referral_source_sub_mand_YN="N";
	String ref_src_code_disp="";
	String ref_src_code_main_mand_disp ="";
	String ref_src_code_sub_mand_disp = "";
	String ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+str_blng_grp_id+"'";
//	System.out.println("ref_src_code_qry Secondary Ins Head File:"+ref_src_code_qry);
	
	try
	{
		pstmt = con.prepareStatement(ref_src_code_qry);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				referral_source_capture_YN = rs2.getString(1);
				referral_source_main_mand_YN = rs2.getString(2);
				referral_source_sub_mand_YN = rs2.getString(3);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Exception in ref_src_code_qry:"+e);
		e.printStackTrace();
	}
		
	if(referral_source_capture_YN.equals("Y"))
	{
		ref_src_code_disp="display:inline";
		if(referral_source_main_mand_YN.equals("Y"))
		{
			ref_src_code_main_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_main_mand_disp = "display:none";
		}
		if(referral_source_sub_mand_YN.equals("Y"))
		{
			ref_src_code_sub_mand_disp = "display:inline";
		}
		else
		{
			ref_src_code_sub_mand_disp = "display:none";
		}
	}
	else if(referral_source_capture_YN.equals("N"))
	{
		ref_src_code_disp="display:none";
		ref_src_code_main_mand_disp = "display:none";
		ref_src_code_sub_mand_disp = "display:none";
	}
	else
	{
		ref_src_code_disp="display:none";
	}
//	System.out.println("ref_src_code_disp:"+ref_src_code_disp);
//	System.out.println("referral_source_main_mand_YN:"+referral_source_main_mand_YN);
//	System.out.println("referral_source_sub_mand_YN:"+referral_source_sub_mand_YN);
%>
	<input type= "hidden" name="currency_code_for_bg" id="currency_code_for_bg"  value="<%=str_currency_code_for_bg%>">
	<input type= "hidden" name="currency_desc_for_bg" id="currency_desc_for_bg"  value="<%=str_currency_desc_for_bg%>">
<input type='hidden' name='cap_ref_src_dtl_flag' id='cap_ref_src_dtl_flag' value='<%=referral_source_capture_YN%>'>
<input type='hidden' name='referral_source_main_mand_YN' id='referral_source_main_mand_YN' value='<%=referral_source_main_mand_YN%>'>
<input type='hidden' name='referral_source_sub_mand_YN' id='referral_source_sub_mand_YN' value='<%=referral_source_sub_mand_YN%>'>
<tr>
	
	<td width="25%" class="Label">
		<div id='ref_src_code_main_leg_disp' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>

	<td width="25%" class="fields">
		<div id='ref_src_code_main_val_disp' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_main_desc" id="referral_source_main_desc" maxlength='50' size='25' tabindex='0'  value="" onBlur="return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,'M','B')">
			<input type='button' class='button' name="refsrcmainbut" id="refsrcmainbut" value='?' onClick="return refsrclkup(document.forms[0].referral_source_main_code,document.forms[0].referral_source_main_desc,'M','C')" tabindex='0'>
			<div id='ref_src_code_main_mand_disp' style='<%=ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
			<img src='../../eCommon/images/more.gif' name="pmy_ref_src_lng_name" id="pmy_ref_src_lng_name" align='center' style="visibility:hidden">
		</div>
	</td>
	
	<td width="25%" class="Label">
		<div id='ref_src_code_sub_leg_disp' style='<%=ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>
	
	<td width="25%" class="fields">
		<div id='ref_src_code_sub_val_disp' style='<%=ref_src_code_disp%>'>
			<input type='text' name="referral_source_sub_desc" id="referral_source_sub_desc" maxlength='50' size='25' tabindex='0'  value="" onBlur="return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,'S','B')">
			<input type='button' class='button' name="refsrcsubbut" id="refsrcsubbut" value='?' onClick="return refsrclkup(document.forms[0].referral_source_sub_code,document.forms[0].referral_source_sub_desc,'S','C')" tabindex='0'>
			<div id='ref_src_code_sub_mand_disp' style='<%=ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
			<img src='../../eCommon/images/more.gif' name="sec_ref_src_lng_name" id="sec_ref_src_lng_name" align='center' style="visibility:hidden">
		</div>
	</td>
	
</tr>

<input type='hidden' name='referral_source_main_code' id='referral_source_main_code' value="">
<input type='hidden' name='referral_source_sub_code' id='referral_source_sub_code' value="">

</table>
<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type='hidden' name='blnggrp' id='blnggrp' 	value="<%=strblnggrp%>">
<input type='hidden' name="ext_billing_group" id="ext_billing_group" value="<%=strExtBillingGroup%>">	
<input type='hidden' name='CitizenYn' id='CitizenYn' value='<%=strCitizenYn%>'>
<input type='hidden' name='blnggrpappyn' id='blnggrpappyn' value='<%=strBlngGrpAppYN%>'>		
<input type='hidden' name='blnggrpcatgappyn' id='blnggrpcatgappyn' value='<%=strBlngGrpCatgAppYN%>'>
<input type='hidden' name='BlngGrpStatus' id='BlngGrpStatus' value='<%=strBlngGrpStatus%>'>	
<input type='hidden' name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>
<input type='hidden' name='query_string' id='query_string' value="<%=query_string%>">	
<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value='<%=ins_auth_flag%>'>
<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
<input type='hidden' name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>
<input type='hidden' name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>
<input type='hidden' name="patient_class" id="patient_class" value="<%=p_patient_class%>">
<input type='hidden' name="episode_type" id="episode_type" value="<%=episode_type%>">

<input type='hidden' name="ext_settl_type" id="ext_settl_type" value='<%=strExtSettlType%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='show_hide_blng_class' id='show_hide_blng_class' value='<%=show_hide_blng_class%>'>
<input type='hidden' name="billing_group" id="billing_group"  value="<%=str_blng_grp_id%>">
<input type='hidden' name="primary_blng_grp" id="primary_blng_grp"  value="<%=primary_blng_grp%>">

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
<!--Added for ML-MMOH-CRF-1433-->
<input type='hidden' name='SrchByBlngGp' id='SrchByBlngGp' value='<%=SrchByBlngGp%>'>
<!-- Added V20180709-Aravindh/GHL-CRF-0427/Starts -->
<input type='hidden' name='restrictBlngGrp' id='restrictBlngGrp' value='<%=restrictBlngGrp%>'>
<input type='hidden' name='login_user' id='login_user' value='<%=login_user%>'>
<input type='hidden' name='fin_auth_user_id' id='fin_auth_user_id' value='<%=fin_auth_user_id%>'>
<!-- Added V20180709-Aravindh/GHL-CRF-0427/Ends -->
<%
	}
	
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
	
</form>
</body>
</html>

