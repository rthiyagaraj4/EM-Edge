<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210310            12033       AMS-CRF-00249            Ram kumar S
 2			 V220908						TH-KW-CRF-0093 			Namrata Charate
 3			 V230315						MMS-DM-CRF-0209.5		Namrata Charate
 4			 V230707						AAKH-CRF-0142.1			Namrata Charate
*/ %>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<script>
/* Provide Input FormObject(POST requestXML) and JSP Page for that FormObject Processing  */
/* Add for GHL-CRF-0550 BY PALANI NARAYANAN  STARTS */
var submitParamsMain	= "";
async function dataForImage_ghl() {
	var frmObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	var strModuleId = document.forms[0].calling_module_id.value; 
	var strfunction_id =	 document.forms[0].function_id.value; 
	var billingGroup = "";
	if(parent.parent.parent.MainFrame1 != undefined && parent.parent.parent.MainFrame1 != "undefined" && parent.parent.parent.MainFrame1 != null && parent.parent.parent.MainFrame1 != "null") {
		billingGroup = parent.parent.parent.MainFrame1.PatFinMainForm.billing_group.value;
	}
	if(frmObj!="" && frmObj!=null && frmObj !=undefined )
	{
		var xmlString=formXMLStringMain_ghl(frmObj);	
		var patient_id1=frmObj.patient_id.value;//GHL-CRF-0550
		//GHL-CRF-0550.1
		var totalRecords=parent.frames[1].document.forms[0].total_records.value;
		if(totalRecords==0)
		{
			alert(getMessage("NO_RECORD_FOUND","common"));
			return false;
		}
		var checked_row=parent.frames[1].document.forms[0].checked_row.value;
		//GHL-CRF-0550.1
		if(checked_row=="")
		{
			alert(getMessage("ATLEAST_ONE_SELECTED","common"));
			return false;
		}
		
		var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);//GHL-CRF-0550.1
		var policy_no=encodeURIComponent(policy_no1.value);
		var temp_jsp="../../eBL/jsp/BLInsImageIntLoadValidation_GHL.jsp?patient_id=" +patient_id1+"&billingGroup="+billingGroup+"&calling_module_id="+strModuleId+"&checked_row="+checked_row+"&policy_no="+policy_no+"&total_records="+totalRecords;//GHL-CRF-0550.1
		var updation=formValidation_ghl(xmlString,temp_jsp);
	}
	var patient_id=frmObj.patient_id.value;
	var setlmt_ind=document.getElementById("setlmt_ind").value;
	var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?title=Upload Document&patient_id=" +patient_id+"&strfunction_id="+strfunction_id+"&strModuleId="+strModuleId+"&checked_row="+checked_row+"&totalRecords="+totalRecords+"&policy_no="+policy_no+"&settlement_ind="+setlmt_ind;//GHL-CRF-0550.1
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";
	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);
}
/* Add for GHL-CRF-0550 BY PALANI NARAYANAN  ENDS */

async function dataForImage() {
	var frmObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
		
	if(frmObj!="" && frmObj!=null && frmObj !=undefined )
	{
		var xmlString=formXMLStringMain(frmObj);		
		var temp_jsp="../../eBL/jsp/BLInsImageIntLoadValidation.jsp";
		var updation=formValidation(xmlString,temp_jsp);
	}
	//parent.parent.parent.frames[2].messageFrame.location.href="../../eCommon/jsp/error.jsp";
	var patient_id=frmObj.patient_id.value;
	var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?title=Upload Document&patient_id=" +patient_id;
	var dialogFeatures  = "dialogHeight:" + "400px" + "; dialogWidth:" + "700px" +" ; scroll=auto; ";
	var returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);
}

/* Add For GHL-CRF-0550  */
function formValidation_ghl(xmlStr,temp_jsp)
{
	//07-May-20 To make IE Compatibility Logics
	var xmlHttp;
	if (window.ActiveXObject)
	{
		//xmlHttp = new ActiveXObject('Microsoft.XMLHTTP')
		xmlHttp = new XMLHttpRequest();
	}
	else
	{
		xmlHttp = new XMLHttpRequest()
	}

	if(submitParamsMain!=""){
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.setRequestHeader("Content-length",submitParamsMain.length);
		xmlHttp.send(submitParamsMain);
		var responseText=xmlHttp.responseText;
	}
	return true;
	//07-May-20 To make IE Compatibility Logics
}

function formValidation(xmlStr,temp_jsp)
{	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	return true;
}	

function formXMLStringMain(frmObj)
{
	if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~";
				}
				val= val.substring(0,val.lastIndexOf('~'));
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
	}
	xmlStr +=" /></root>";	
	}
	return xmlStr;
}

/* Add For GHL-CRF-0550  */
function formXMLStringMain_ghl(frmObj) {	
	if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
	var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/						
					submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
					submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					/*xmlStr += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";*/
				 submitParamsMain	+= arrObj[i].name+"="+checkSpl(val)+"&";
				}
			}
		}
	}
		xmlStr += " /></root>";
	}
	return xmlStr;
}

function checkSpl( val ) {
    var result = "" ;
    var ch = "" ;

    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"");
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(var i=0; i<val.length; i++) {
        for(var j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    return result ;
}

</script>
<%
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	//ResultSet rs4				= null;
	ResultSet rs5				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	boolean siteSpecUploadDocAll = false;//GHL-CRF-0550
	boolean siteSpecAgeValidation=false;// Added against V210310
	String payerGrpBySetup =  request.getParameter("payerGrpBySetup");
	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
		//V210310 Starts 
		String siteSpecAgeVal ="";
		try
		{	
			siteSpecAgeValidation = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_GRP_VAL_FOR_BLNG_GRP");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in Non Ins Billing Grp site specific Age Validation "+e);
		}
		if(siteSpecAgeValidation){
			siteSpecAgeVal="Y";
		}
		else{
			siteSpecAgeVal="N";
		}
		System.err.println("siteSpecAgeVal Non Ins Billing Grp "+siteSpecAgeVal);
		//V210310 Ends
		String package_enabled_yn="N";//added for package Billing
		String nd_settlement_ind ="";
		String nd_adm_rec_flag ="", ins_auth_flag="";
		String mpolicy_type="" ;
		String mnon_insur_blng_grp="";
		String mcredit_auth_ref="", mcredit_auth_date="", mapp_days="",mapp_amount="",meff_frm_date="";	

		String facility_id = (String)httpSession.getValue("facility_id");
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";	
		String billing_group="";

		String cash_leg ="", credit_leg ="", sponsor_leg ="", ins_leg ="";

		String rtn_non_ins_blng_grp="";
		String non_ins_billing_group_desc="";
		String rtn_non_ins_ref_src_main_code = "";
		String rtn_non_ins_ref_src_main_desc = "";
		String ref_non_ins_src_main_lng_name = "";
		String rtn_non_ins_ref_src_sub_code = "";
		String rtn_non_ins_ref_src_sub_desc = "";
		String ref_non_ins_src_sub_lng_name = "";
		String queryString=(request.getQueryString());
		String p_patient_class=request.getParameter("patient_class");
		String episode_type="";

		//Added by prithivi on 11/12/2016 for MMS-qh-crf-0085 - bupa insurance interface
		String service_code=request.getParameter("service_code");
		String fin_class_flag_YN="N",autoFinChk="N",class_code="",class_blng_grp_id="";

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);

		cash_leg = (String) bl_labels.getString("eBL.CASH.label");
		if(cash_leg == null) cash_leg="";
		credit_leg = (String) bl_labels.getString("eBL.CREDIT.label");
		if(credit_leg == null) credit_leg="";
		sponsor_leg = (String) bl_labels.getString("eBL.SPONSOR.label");
		if(sponsor_leg == null) sponsor_leg="";
		ins_leg = (String) common_labels.getString("Common.Insurance.label");
		if(ins_leg == null) ins_leg="";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";	

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				billing_group=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp=((String)bl_data.get("non_ins_blng_grp")).trim();

				rtn_non_ins_ref_src_main_code = ((String)bl_data.get("non_ins_ref_src_main_code")).trim();
				if(rtn_non_ins_ref_src_main_code == null) rtn_non_ins_ref_src_main_code="";

				rtn_non_ins_ref_src_main_desc = ((String)bl_data.get("non_ins_ref_src_main_desc")).trim();
				if(rtn_non_ins_ref_src_main_desc == null) rtn_non_ins_ref_src_main_desc="";

				rtn_non_ins_ref_src_sub_code = ((String)bl_data.get("non_ins_ref_src_sub_code")).trim();
				if(rtn_non_ins_ref_src_sub_code == null) rtn_non_ins_ref_src_sub_code="";

				rtn_non_ins_ref_src_sub_desc = ((String)bl_data.get("non_ins_ref_src_sub_desc")).trim();
				if(rtn_non_ins_ref_src_sub_desc == null) rtn_non_ins_ref_src_sub_desc="";
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");		
		}
		
		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		String strdfltbgyn = "N";
		String srtencdfltbgyn="N";
		String bl_future_admn_YN="";

		String strBlngGrpAppYN= "Y";
		String strBlngGrpStatus="";
		String strCategory = "";
		String strBlngGrpCatgAppYN = "Y";		

		ins_auth_flag = request.getParameter("ins_auth_flag");
		if(ins_auth_flag==null) ins_auth_flag = "N";
		String clinic_code = request.getParameter("clinic_code");
		String visit_type_code = request.getParameter("visit_type_code");
		String strshowHideBlngClass = request.getParameter("show_hide_blng_class");

		//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
		String nursing_unit_code=request.getParameter("nursing_unit_code");

		String l_credit_doc_ref_desc = "";
		String l_credit_doc_ref_start_date = "";
		String l_credit_doc_ref_date =  "";
		String l_cust_code = "";
		String l_slmt_ind = "";
		String l_adm_rec_flag = "";

		String str_blng_grp_id = "";
		String str_short_desc = "";	
		String str_currency_code_for_bg = "",str_currency_desc_for_bg="";

		String patient_id = request.getParameter("patient_id");		
		if (patient_id == null ) patient_id = "";

		String strCitizenYn = "N";		
		String nationalityyn = "";

		strCitizenYn = request.getParameter("CitizenYn");
		if(strCitizenYn == null) strCitizenYn="N";

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";

		if ( strdfltbgyn == null) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null) srtencdfltbgyn="N";

		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}

		bl_future_admn_YN=request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";
		
		String sqlstr="select credit_doc_ref_desc, to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date, to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date, cust_code, settlement_ind, decode(non_ins_blng_grp_id,null,decode(settlement_ind,'X',1,0),2) adm_rec_flag from bl_patient_fin_dtls where patient_id = ? ";
		
		pstmt = con.prepareStatement(sqlstr);
		pstmt.setString(1,patient_id);
		rs5 = pstmt.executeQuery();
		if( rs5 != null ) 
		{
			while( rs5.next() )
			{  
				l_credit_doc_ref_desc =  rs5.getString("credit_doc_ref_desc");
				l_credit_doc_ref_start_date =  rs5.getString("credit_doc_ref_start_date");
				l_credit_doc_ref_date =  rs5.getString("credit_doc_ref_date");
				l_cust_code =  rs5.getString("cust_code");			
				l_slmt_ind = rs5.getString("settlement_ind");			
				l_adm_rec_flag = rs5.getString("adm_rec_flag");			
			}
		}
		if(rs5 != null ) rs5.close();
		pstmt.close();

		if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		if (l_credit_doc_ref_start_date == null) l_credit_doc_ref_start_date = "";
		if (l_credit_doc_ref_date == null) l_credit_doc_ref_date = "";
		if (l_cust_code == null) l_cust_code = "";
		if (l_slmt_ind == null) l_slmt_ind = "";
		if (l_adm_rec_flag == null) l_adm_rec_flag = "";	

		if (strshowHideBlngClass == null) strshowHideBlngClass = "";

		String strCreditDoc_YN="N";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");
		if(strModuleId==null || strModuleId.equals("")) strModuleId="";
		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";
		String strExtSettlType ="";
		String strSettlTypeOverride ="";		

		nationalityyn = request.getParameter("nationality_yn");		
		
	    if (nationalityyn == null) nationalityyn = "";	

		if (strModuleId.equals("MP"))
		{
			strCitizenYn = nationalityyn;
			strdfltbgyn = "Y";
		}

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if (str_function_id ==null)
		{
			str_function_id = "";		
		}	

		
		if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && str_function_id.equals("ADMISSION")))
		{	
			strdfltbgyn="Y";
		}

		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{

			String strTempFunId = request.getParameter("id_fun");
			if (strTempFunId== null)
			{
				strExtSettlType = request.getParameter("cash_set_type1");	
			}
			else if (strTempFunId.equals("1"))
			{
				strExtSettlType = request.getParameter("set_typ_from_frame1");	
			}
		
			if (strExtSettlType == null)
			{
				strExtSettlType = "";
			}
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
					if (strColumn.equals("cash_set_type1")) 
					{
						if (strOverride.equals("N"))
						{
							strSettlTypeOverride = "N";
						}
						else 
						{
							strSettlTypeOverride = "Y";
						}
					}
				}
			}
		catch(Exception excep)
			{
				excep.printStackTrace();
			}
		}

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

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mnon_insur_blng_grp = rtn_non_ins_blng_grp;
			if ( mnon_insur_blng_grp == null ) mnon_insur_blng_grp = "";

			clinic_code			= request.getParameter("clinic_code");
			if ( clinic_code == null ) clinic_code = "";

			//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
			nursing_unit_code			= request.getParameter("nursing_unit_code");
			if ( nursing_unit_code == null ) nursing_unit_code = "";

			visit_type_code		= request.getParameter("visit_type_code");
			if ( visit_type_code == null ) visit_type_code = "";
			
		}		

		if((mpolicy_type==null) || (mpolicy_type.equals("null")))
		mpolicy_type = java.net.URLEncoder.encode(mpolicy_type);
		

		if((mcredit_auth_ref==null) || (mcredit_auth_ref.equals("null"))) mcredit_auth_ref="";
		if((mcredit_auth_date==null) || (mcredit_auth_date.equals("null"))) mcredit_auth_date="";
		if((mapp_days==null) || (mapp_days.equals("null"))) mapp_days="";
		if((mapp_amount==null) || (mapp_amount.equals("null"))) mapp_amount="";
		if((meff_frm_date==null) || (meff_frm_date.equals("null"))) meff_frm_date="";
		if((clinic_code==null) || (clinic_code.equals("null"))) clinic_code="";
		if((visit_type_code==null) || (visit_type_code.equals("null"))) visit_type_code="";

		//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
		if((nursing_unit_code==null) || (nursing_unit_code.equals("null"))) nursing_unit_code="";

		String sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N') from bl_blng_grp where blng_grp_id = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,billing_group);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_settlement_ind = rs.getString("settlement_ind");
				nd_adm_rec_flag = rs.getString("adm_rec_flag");
				strCreditDoc_YN = rs.getString(3);
			}
		}
		if(rs != null ) rs.close();
		pstmt.close();

		if(nd_settlement_ind==null)nd_settlement_ind="";
		if(nd_adm_rec_flag==null)nd_adm_rec_flag="";	
		

		if (l_slmt_ind.equals(nd_settlement_ind) && (nd_adm_rec_flag.equals(l_adm_rec_flag) ||l_slmt_ind.equals("C")||l_slmt_ind.equals("R")))
		{
			if (l_credit_doc_ref_desc == null) l_credit_doc_ref_desc = "";
		}
		else
		{
			l_credit_doc_ref_desc = "";
			l_credit_doc_ref_start_date = "";
			l_credit_doc_ref_date = "";
			l_cust_code = "";
			l_slmt_ind = "";
			l_adm_rec_flag = "";		
		}			
%>
<head>

<script>
	var totalRecords=0;
	var formObj="";
	var total_records="";
	var checked_row="";
	var blng_grp_code="";
	var payer_desc="";
	var cust_3="";
	var priority="";
	var policy_type_desc="";
	var policy_type_code="";
	var policy_no="";
	var policy_start_date="";
	var policy_exp_date="";
	var credit_auth_ref="";
	var credit_auth_date="";
	var credit_apprd_amt="";
	var credit_apprd_days="";
	var policy_eff_frm_date="";
	var policy_eff_to_date="";	
	var adj_rule_ind="";;
	var adj_perc_amt_ind="";
	var adj_perc_amt_value="";
	var pmnt_diff_adj_int="";
	var drg_pmnt_diff_adj_int="";
	var spl_srv_pmnt_diff_adj_int="";
	var restrict_check="";
	var valid_payer_YN="";
	var valid_policy_type_code_YN="";
	var payer_suspended_YN=""
	var policy_suspended_YN=""
	var cust_group_code="";
	var cust_group_name="";
	var policy_coverage_basis_ind="";
	var cust_valid_from_date = "";
	var cust_valid_to_date = "";

async function addPayer()
{
	/******************added for package billing************start*********/
	var calling_module_id = document.forms[0].calling_module_id.value;	
	var package_enabled_yn = document.forms[0].package_enabled_yn.value;	

	if(package_enabled_yn==null) package_enabled_yn="N";
	/******************added for package billing************end*********/
	var retVal			= new String();

	//var dialogTop			= "130";
//	var dialogHeight		= "22" ;
//	var dialogWidth			= "50" ;

	//var dialogHeight		= "25" ;
		/******************added for package billing************start*********/
	var moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);
	if(package_enabled_yn=="Y" && (calling_module_id=="OP" || calling_module_id=="IP" || moduleIdValidation == "Y"))	
		 dialogHeight		= "50" ;
	/******************added for package billing************end*********/
	//var dialogWidth			= "55" ;
	
	var dialogTop			= "0vh";
	var dialogHeight		= "95vh" ;
	var dialogWidth			= "88vw" ; 
	
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ADD_PAYER.label","BL");
	title=encodeURIComponent(title);

	//var calling_module_id = document.forms[0].calling_module_id.value;	
	var getString=document.forms[0].queryString.value;
	var p_patient_class=document.forms[0].p_patient_class.value;
	var billing_group=parent.parent.parent.frames[0].document.forms[0].billing_group.value;

	var encounter_date_time = parent.parent.parent.frames[0].document.forms[0].encounter_date_time.value;
	
	var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;
	var autoFinChk = document.forms[0].autoFinChk.value;
	var class_code = document.forms[0].class_code.value;
	
	formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	totalRecords =eval(formObj.total_records.value);

	var priority_arr=new Array();
	var ins_blng_grp_code_arr=new Array();
	var ins_blng_grp_desc_arr=new Array();

	for(var i=0;i<totalRecords;i++)
	{
		var priority1=eval("parent.frames[1].document.forms[0].priority"+i);
		var priority=priority1.value;
		var ins_blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
		var ins_blng_grp_code=ins_blng_grp_code1.value;
		var ins_blng_grp_desc1=eval("parent.frames[1].document.forms[0].billing_group_desc"+i);
		var ins_blng_grp_desc=ins_blng_grp_desc1.value;
		var cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+i);//Added against MMS-DM-CRF-0164.1_73081
		priority_arr[i]=priority;
		ins_blng_grp_code_arr[i]=ins_blng_grp_code;
		ins_blng_grp_desc_arr[i]=ins_blng_grp_desc;
	}

	var temp="";
	var temp1="";
	var blng_grp_count=0;
	var list_of_blng_grp_arr=new Array();
	var j=0;

	for(var i=0;i<totalRecords;i++)
	{
		temp=ins_blng_grp_code_arr[i];
		if((temp!="" && temp1=="") || (temp!=temp1))
		{
			blng_grp_count++;
			list_of_blng_grp_arr[j]=temp;
			j++;
		}
		temp1=temp;
	}

	var hs=new Hashtable();
	var sel_priority="";

	for(var i=0;i<list_of_blng_grp_arr.length;i++)
	{
		var sel_blng_grp=list_of_blng_grp_arr[i];
		sel_priority="";
		for(var j=0;j<totalRecords;j++)
		{
			if(sel_blng_grp==ins_blng_grp_code_arr[j])
			{
				var temp=priority_arr[j];
				sel_priority=sel_priority+temp+":";
				hs.put(sel_blng_grp,sel_priority);
			}
		}
	}

	var total_keys=hs.keys();
	var priorty_values="";
	var temp_arr=new Array();
	var max_priority_arr=new Array();
		
	for(var i=0;i<total_keys.length;i++)
	{
		priorty_values=hs.get(total_keys[i]);
		priorty_values=priorty_values.substring(0,priorty_values.length-1);
		temp_arr=priorty_values.split(':');
		var temp="";
		var temp1="";
		var max_priority="";
		var k=1;

		for(var j=0;j<temp_arr.length;j++)
		{
			if(parseInt(k) <= temp_arr.length)
			{
				if(parseInt(j)==0)
					temp=temp_arr[j];

				if(parseInt(temp_arr.length)==1)
					temp1=temp_arr[j];
				else
					temp1=temp_arr[k];

				if(temp1==null)
					temp1=temp;

				if(parseInt(temp) > parseInt(temp1))
					max_priority=temp;
				else
					max_priority=temp1;

				temp=max_priority;
				k++;
			}
		}
		max_priority_arr[i]=max_priority;
	}

	var min_priority_arr=new Array();
		
	for(var i=0;i<total_keys.length;i++)
	{
		priorty_values=hs.get(total_keys[i]);
		priorty_values=priorty_values.substring(0,priorty_values.length-1);
		temp_arr=priorty_values.split(':');
		var temp="";
		var temp1="";
		var min_priority="";
		var k=1;

		for(var j=0;j<temp_arr.length;j++)
		{
			if(parseInt(k) <= temp_arr.length)
			{
				if(parseInt(j)==0)
					temp=temp_arr[j];

				if(parseInt(temp_arr.length)==1)
					temp1=temp_arr[j];
				else
					temp1=temp_arr[k];

				if(temp1==null)
					temp1=temp;

				if(parseInt(temp) < parseInt(temp1))
					min_priority=temp;
				else
					min_priority=temp1;

				temp=min_priority;
				k++;
			}
		}
		min_priority_arr[i]=min_priority;
	}
	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	for(var j=0;j<totalRecords;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}

	var blng_grp_code_array="";
	var count = 0;
	for(var i=0;i<totalRecords;i++)
	{
		var billing_group_desc1=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
		if(billing_group_desc1.value == billing_group)
		{
			count++;
		}
		blng_grp_code_array=blng_grp_code_array+billing_group_desc1.value+"|";
	}

	if(count==0)
	{
		blng_grp_code_array=billing_group+"|"+blng_grp_code_array;
	}

    if(blng_grp_code_array==null || blng_grp_code_array=="") blng_grp_code_array=billing_group;

	parent.frames[1].document.forms[0].target = "InsValidationFrame";
	parent.frames[1].document.forms[0].action="../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add&locn=outside";
	parent.frames[1].document.forms[0].submit();
	parent.frames[1].document.forms[0].target = "";
    
	//Added by prithivi on 11/12/2016 for mms-qh-crf-0085 
	var service_code = document.forms[0].service_code.value;
	var clinic_code = document.forms[0].clinic_code.value;

	//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;

	var param ="&title="+title+"&action=add&locn=outside"+"&blng_grp_code_array="+blng_grp_code_array+"&patient_class="+p_patient_class+"&billing_group="+billing_group+"&calling_module_id="+calling_module_id+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&totalRecords="+totalRecords+"&total_keys="+total_keys+"&max_priority_arr="+max_priority_arr+"&min_priority_arr="+min_priority_arr+"&priority_arr="+priority_arr+"&encounter_date_time="+encounter_date_time+"&fin_class_flag_YN="+fin_class_flag_YN+"&autoFinChk="+autoFinChk+"&class_code="+class_code+"&patient_id="+document.add_modify_pat_fin_det_insbut.patient_id.value+"&package_enabled_yn="+package_enabled_yn+"&clinic_code="+clinic_code+"&nursing_unit_code="+nursing_unit_code;//changed for package billing
	
	retVal=await parent.parent.window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?"+param,arguments,features);

	var count=0;
	var classval="";
	var	billing_grp="";

	if(retVal!=null)
	{
		retVal=unescape(retVal);
		parent.frames[1].document.forms[0].retVal.value = retVal;	
		parent.frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?add_check=add&total_records="+totalRecords+"&"+getString;
		
		parent.frames[1].document.forms[0].submit();
	}
	else
	{
//		alert("closed");
	}
}

async function modifyPayer()
{
	
	formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	total_records=formObj.total_records.value;

	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;

	var encounter_date_time = parent.parent.parent.frames[0].document.forms[0].encounter_date_time.value;
	
	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}

	var priority_arr=new Array();
	var ins_blng_grp_code_arr=new Array();
	var ins_blng_grp_desc_arr=new Array();

	for(var i=0;i<total_records;i++)
	{
		var priority1=eval("parent.frames[1].document.forms[0].priority"+i);
		var priority=priority1.value;
		var ins_blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
		var ins_blng_grp_code=ins_blng_grp_code1.value;
		var ins_blng_grp_desc1=eval("parent.frames[1].document.forms[0].billing_group_desc"+i);
		var ins_blng_grp_desc=ins_blng_grp_desc1.value;
			
		priority_arr[i]=priority;
		ins_blng_grp_code_arr[i]=ins_blng_grp_code;
		ins_blng_grp_desc_arr[i]=ins_blng_grp_desc;
	}

	var temp="";
	var temp1="";
	var blng_grp_count=0;
	var list_of_blng_grp_arr=new Array();
	var j=0;

	for(var i=0;i<total_records;i++)
	{
		temp=ins_blng_grp_code_arr[i];
		if((temp!="" && temp1=="") || (temp!=temp1))
		{
			blng_grp_count++;
			list_of_blng_grp_arr[j]=temp;
			j++;
		}
		temp1=temp;
	}

	var hs=new Hashtable();
	var sel_priority="";

	for(var i=0;i<list_of_blng_grp_arr.length;i++)
	{
		var sel_blng_grp=list_of_blng_grp_arr[i];
		sel_priority="";
		for(var j=0;j<total_records;j++)
		{
			if(sel_blng_grp==ins_blng_grp_code_arr[j])
			{
				var temp=priority_arr[j];
				sel_priority=sel_priority+temp+":";
				hs.put(sel_blng_grp,sel_priority);
			}
		}
	}

	var total_keys=hs.keys();

	var priorty_values="";
	var temp_arr=new Array();
		
	var max_priority_arr=new Array();

	for(var i=0;i<total_keys.length;i++)
	{
		priorty_values=hs.get(total_keys[i]);
		priorty_values=priorty_values.substring(0,priorty_values.length-1);
		temp_arr=priorty_values.split(':');
		var temp="";
		var temp1="";
		var max_priority="";
		var k=1;

		for(var j=0;j<temp_arr.length;j++)
		{
			if(parseInt(k) <= temp_arr.length)
			{
				if(parseInt(j)==0)
					temp=temp_arr[j];

				if(parseInt(temp_arr.length)==1)
					temp1=temp_arr[j];
				else
					temp1=temp_arr[k];

				if(temp1==null)
					temp1=temp;

				if(parseInt(temp) > parseInt(temp1))
					max_priority=temp;
				else
					max_priority=temp1;

				temp=max_priority;
				k++;
			}
		}
		max_priority_arr[i]=max_priority;
	}

	var min_priority_arr=new Array();
		
	for(var i=0;i<total_keys.length;i++)
	{
		priorty_values=hs.get(total_keys[i]);
		priorty_values=priorty_values.substring(0,priorty_values.length-1);
		temp_arr=priorty_values.split(':');
		var temp="";
		var temp1="";
		var min_priority="";
		var k=1;

		for(var j=0;j<temp_arr.length;j++)
		{
			if(parseInt(k) <= temp_arr.length)
			{
				if(parseInt(j)==0)
					temp=temp_arr[j];

				if(parseInt(temp_arr.length)==1)
					temp1=temp_arr[j];
				else
					temp1=temp_arr[k];

				if(temp1==null)
					temp1=temp;

				if(parseInt(temp) < parseInt(temp1))
					min_priority=temp;
				else
					min_priority=temp1;

				temp=min_priority;
				k++;
			}
		}
		min_priority_arr[i]=min_priority;
	}

	var locale=document.forms[0].locale.value;

	checked_row=parent.frames[1].document.forms[0].checked_row.value;
	if(checked_row=="")
	{
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
		return false;
	}
	else
	{
		parent.frames[1].document.forms[0].target = "InsValidationFrame";
		parent.frames[1].document.forms[0].action="../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=modify&locn=outside&checked_row="+checked_row;
		parent.frames[1].document.forms[0].submit();

		parent.frames[1].document.forms[0].target = "";

		var blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+checked_row);
		blng_grp_code=encodeURIComponent(blng_grp_code1.value);

		var payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+checked_row);
		payer_desc=encodeURIComponent(payer_desc1.value);

		var cust_31=eval("parent.frames[1].document.forms[0].cust_3"+checked_row);
		cust_3=encodeURIComponent(cust_31.value);

		var priority1=eval("parent.frames[1].document.forms[0].priority"+checked_row);
		priority=priority1.value;

		var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+checked_row);
		policy_type_desc=encodeURIComponent(policy_type_desc1.value);

		var policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+checked_row);
		policy_type_code=encodeURIComponent(policy_type_code1.value);

		var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
		policy_no=encodeURIComponent(policy_no1.value);

		var policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+checked_row);
		policy_start_date=policy_start_date1.value;

		var policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+checked_row);
		policy_exp_date=policy_exp_date1.value;

		var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
		credit_auth_ref=encodeURIComponent(credit_auth_ref1.value);

		var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
		credit_auth_date=credit_auth_date1.value;

		var credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
		credit_apprd_amt=credit_apprd_amt1.value;

		var credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
		credit_apprd_days=credit_apprd_days1.value;

		var policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+checked_row);
		policy_eff_frm_date=policy_eff_frm_date1.value;

		var policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+checked_row);
		policy_eff_to_date=policy_eff_to_date1.value;		
		
		var site_spec=parent.frames[1].document.getElementById('siteSpec').value;
		
		var adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+checked_row);
		if(adj_rule_ind1!="")
			adj_rule_ind=encodeURIComponent(adj_rule_ind1.value);

		var adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+checked_row);
		if(adj_perc_amt_ind1 != "")
		adj_perc_amt_ind=encodeURIComponent(adj_perc_amt_ind1.value);

		var adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+checked_row);
		adj_perc_amt_value=encodeURIComponent(adj_perc_amt_value1.value);

		var pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+checked_row);
		pmnt_diff_adj_int=encodeURIComponent(pmnt_diff_adj_int1.value);

		var drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+checked_row);
		drg_pmnt_diff_adj_int=encodeURIComponent(drg_pmnt_diff_adj_int1.value);

		var spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+checked_row);
		spl_srv_pmnt_diff_adj_int=encodeURIComponent(spl_srv_pmnt_diff_adj_int1.value);

		var restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+checked_row);
		restrict_check=restrict_check1.value;

		var valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+checked_row);
		valid_payer_YN=valid_payer_YN1.value;

		var payer_suspended_YN1=eval("parent.frames[1].document.forms[0].payer_suspended_YN"+checked_row);
		payer_suspended_YN=payer_suspended_YN1.value;

		var valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+checked_row);
		valid_policy_type_code_YN=valid_policy_type_code_YN1.value;

		var policy_suspended_YN1=eval("parent.frames[1].document.forms[0].policy_suspended_YN"+checked_row);
		policy_suspended_YN=policy_suspended_YN1.value;

		var cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+checked_row);
		cust_group_code=encodeURIComponent(cust_group_code1.value);

		var cust_group_name1=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+checked_row);
		cust_group_name=encodeURIComponent(cust_group_name1.value);

		var cust_valid_from_date1=eval("parent.frames[1].document.forms[0].cust_valid_from_date"+checked_row);
		cust_valid_from_date=encodeURIComponent(cust_valid_from_date1.value);

		var cust_valid_to_date1=eval("parent.frames[1].document.forms[0].cust_valid_to_date"+checked_row);
		cust_valid_to_date=encodeURIComponent(cust_valid_to_date1.value);

		var rec_edited_YN=eval("parent.frames[1].document.forms[0].rec_edited_YN"+checked_row);
		rec_edited_YN=encodeURIComponent(rec_edited_YN.value);		

		if(!(locale=="en"))
		{
			if(!(policy_start_date=="" || policy_start_date==" "))
				policy_start_date=convertDate(policy_start_date,"DMY",locale,"en");
		
			if(!(policy_exp_date=="" || policy_exp_date==" "))
				policy_exp_date=convertDate(policy_exp_date,"DMY",locale,"en");

			if(!(credit_auth_date=="" || credit_auth_date==" "))
				credit_auth_date=convertDate(credit_auth_date,"DMY",locale,"en");

			if(!(policy_eff_frm_date=="" || policy_eff_frm_date==" "))
				policy_eff_frm_date=convertDate(policy_eff_frm_date,"DMY",locale,"en");

			if(!(policy_eff_to_date=="" || policy_eff_to_date==" "))
				policy_eff_to_date=convertDate(policy_eff_to_date,"DMY",locale,"en");
		}
		//Added By Vijay For MMS-QF-SCf-567
		
		if(site_spec=="true")
		{
			
		var orgPolEffToDate=parent.frames[1].document.getElementById('tmp_pol_eff_to'+checked_row).value;
			
		if(orgPolEffToDate==""||orgPolEffToDate==" "||orgPolEffToDate==null||orgPolEffToDate=="null")
			{
			alert(' Expiry date is not available in the Policy setup');
			return false;
			}
			}
		var policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+checked_row);
		policy_coverage_basis_ind=encodeURIComponent(policy_coverage_basis_ind1.value);

		var retVal			= new String();
		//var dialogTop			= "130";
		//var dialogHeight		= "25" ;
		/******************added for package billing************start*********/
		var calling_module_id = document.forms[0].calling_module_id.value;	
		var package_enabled_yn = document.forms[0].package_enabled_yn.value;	
		if(package_enabled_yn==null)  package_enabled_yn="N";
		
		var moduleIdValidation = checkModuleIdForPayerEligibility(calling_module_id);
		if(package_enabled_yn=="Y" && (calling_module_id=="OP" || calling_module_id=="IP" || moduleIdValidation == "Y"))
		 dialogHeight		= "50" ;
	/******************added for package billing************end*********/
		//var dialogWidth			= "55" ;
	
		var dialogTop			= "0vh";
		var dialogHeight		= "95vh" ;
		var dialogWidth			= "88vw" ; 
		
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title=getLabel("eBL.MODIFY_PAYER.label","BL");
		title=encodeURIComponent(title);	
		//var calling_module_id = document.forms[0].calling_module_id.value;	
		
		var getString = document.forms[0].queryString.value;
		var patient_id = document.forms[0].patient_id.value;
		var calling_module_id = document.forms[0].calling_module_id.value;
		var patient_class = document.forms[0].p_patient_class.value;
		var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;

		//Added by Prithivi for MMS-DM-CRF-0085
		var service_code = document.forms[0].service_code.value;
		var clinic_code = document.forms[0].clinic_code.value;

		//Added by Sethu for MMS-QH-CRF-0085 ON 18/11/2019
		var nursing_unit_code = document.forms[0].nursing_unit_code.value;

		var payerEligibilityParamSession=eval("parent.frames[1].document.forms[0].payerEligibilityParam"+checked_row);
		payerEligibilityParamSession=encodeURIComponent(payerEligibilityParamSession.value);
		var responseCodeSession=eval("parent.frames[1].document.forms[0].responseCode"+checked_row);
		responseCodeSession=encodeURIComponent(responseCodeSession.value);
		var responseCodeDescSes=eval("parent.frames[1].document.forms[0].responseCodeDesc"+checked_row);
		responseCodeDescSes=encodeURIComponent(responseCodeDescSes.value);
		var statuDescriptionSession=eval("parent.frames[1].document.forms[0].statuDescription"+checked_row);
		statuDescriptionSession=encodeURIComponent(statuDescriptionSession.value);
		var validityPeriodSession=eval("parent.frames[1].document.forms[0].validityPeriod"+checked_row);
		validityPeriodSession=encodeURIComponent(validityPeriodSession.value);
		var validityPeriodDescSes=eval("parent.frames[1].document.forms[0].validityPeriodDesc"+checked_row);
		validityPeriodDescSes=encodeURIComponent(validityPeriodDescSes.value);
		var eligibilityCodeSes=eval("parent.frames[1].document.forms[0].eligibilityCode"+checked_row);
		eligibilityCodeSes=encodeURIComponent(eligibilityCodeSes.value);
		var transactionIdSes=eval("parent.frames[1].document.forms[0].transactionId"+checked_row);
		transactionIdSes=encodeURIComponent(transactionIdSes.value);
		var responseDateTimeSes=eval("parent.frames[1].document.forms[0].responseDateTime"+checked_row);
		responseDateTimeSes=encodeURIComponent(responseDateTimeSes.value);
		var mcn_for_policy=eval("parent.frames[1].document.forms[0].mcn_for_policy"+checked_row);  //V220908
		if(mcn_for_policy != "")
		mcn_for_policy=encodeURIComponent(mcn_for_policy.value); //V220908
		var reg_ref_id=eval("parent.frames[1].document.forms[0].reg_ref_id"+checked_row);  //V230315
		reg_ref_id=encodeURIComponent(reg_ref_id.value); //V230315 
		
		var userId_for_priv=eval("parent.frames[1].document.forms[0].userId_for_priv"+checked_row);  //V230707
		userId_for_priv=encodeURIComponent(userId_for_priv.value); //V230707
		
		var reasonCode_for_priv=eval("parent.frames[1].document.forms[0].reasonCode_for_priv"+checked_row);  //V230707
		reasonCode_for_priv=encodeURIComponent(reasonCode_for_priv.value); //V230707
		
		var param = "title="+title+"&action=modify&locn=outside&blng_grp_code="+blng_grp_code+"&payer_desc="+payer_desc+"&cust_3="+cust_3+"&ins_cust_group_code="+cust_group_code+"&ins_cust_group_name="+cust_group_name+"&priority="+priority+"&policy_type_desc="+policy_type_desc+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&policy_start_date="+policy_start_date+"&policy_exp_date="+policy_exp_date+"&credit_auth_ref="+credit_auth_ref+"&credit_auth_date="+credit_auth_date+"&credit_apprd_amt="+credit_apprd_amt+"&credit_apprd_days="+credit_apprd_days+"&policy_eff_frm_date="+policy_eff_frm_date+"&policy_eff_to_date="+policy_eff_to_date+"&adj_rule_ind="+adj_rule_ind+"&adj_perc_amt_ind="+adj_perc_amt_ind+"&adj_perc_amt_value="+adj_perc_amt_value+"&pmnt_diff_adj_int="+pmnt_diff_adj_int+"&drg_pmnt_diff_adj_int="+drg_pmnt_diff_adj_int+"&spl_srv_pmnt_diff_adj_int="+spl_srv_pmnt_diff_adj_int+"&restrict_check="+restrict_check+"&valid_payer_YN="+valid_payer_YN+"&valid_policy_type_code_YN="+valid_policy_type_code_YN+"&policy_coverage_basis_ind="+policy_coverage_basis_ind+"&policy_coverage_basis_gbl_ind="+policy_coverage_basis_gbl_ind+"&totalRecords="+total_records+"&total_keys="+total_keys+"&max_priority_arr="+max_priority_arr+"&min_priority_arr="+min_priority_arr+"&priority_arr="+priority_arr+"&encounter_date_time="+encounter_date_time+"&cust_valid_from_date="+cust_valid_from_date+"&cust_valid_to_date="+cust_valid_to_date+"&checked_row="+checked_row+"&rec_edited_YN="+rec_edited_YN+"&package_enabled_yn="+package_enabled_yn+"&patient_id="+patient_id+"&calling_module_id="+calling_module_id+"&patient_class="+patient_class+"&fin_class_flag_YN="+fin_class_flag_YN+"&clinic_code="+clinic_code+"&payerElgParam="+payerEligibilityParamSession+"&respCdSes="+responseCodeSession+"&respCdDescSes="+responseCodeDescSes+"&statDes="+statuDescriptionSession+"&valPer="+validityPeriodSession+"&valPerDesc="+validityPeriodDescSes+"&elgCd="+eligibilityCodeSes+"&transId="+transactionIdSes+"&respDT="+responseDateTimeSes+"&nursing_unit_code="+nursing_unit_code+"&regRefId="+reg_ref_id+"&mcn_for_policy="+mcn_for_policy+"&userId_for_priv="+userId_for_priv+"&reasonCode_for_priv="+reasonCode_for_priv;    //changed for package billing- added 'package_enabled_yn'
		retVal=await parent.parent.window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsInsBodyEditFrame.jsp?"+param,arguments,features);
		
		formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
		total_records=formObj.total_records.value;
		for(var j=0;j<total_records;j++)
		{
			var temp=eval("formObj.selected_row"+j);
			temp.checked=false;
		}

		if(retVal!=null)
		{
		var arr=new Array();
		if(retVal == null) retVal='';

		if (retVal != null || retVal!="")
		{
			var retVal=unescape(retVal);
					  
			if(retVal != null && retVal.length>0)
			{
				formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
				arr=retVal.split("^~^");	
				if(arr[22]=="R")
				{
					if(arr[31]=="R")
					{
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="inline";
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="inline";

					}
					else if(arr[31]=="U")
					{
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="none";
						var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
						apprd_amt_leg_disp1.style.display="none";

						var credit_apprd_amt_chk=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
						credit_apprd_amt_chk.value="";
					}

					if(arr[32]=="R")
					{
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
						apprd_days_leg_disp1.style.display="inline";
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
						apprd_days_leg_disp1.style.display="inline";
					}
					else if(arr[32]=="U")
					{
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
						apprd_days_leg_disp1.style.display="none";
						var apprd_days_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
						apprd_days_leg_disp1.style.display="none";

						var credit_apprd_days_chk=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
						credit_apprd_days_chk.value="";
					}
				}
				else if(arr[22]=="U")
				{
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_leg_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_amt_val_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_leg_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";
					var apprd_amt_leg_disp1=eval(parent.frames[1].document.getElementById("apprd_days_val_disp"+checked_row));
					apprd_amt_leg_disp1.style.display="none";

					var credit_apprd_amt_chk=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
					credit_apprd_amt_chk.value="";
					var credit_apprd_days_chk=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
					credit_apprd_days_chk.value="";
				}

				setTimeout('',200);

				var blng_grp_desc1=eval("parent.frames[1].document.forms[0].billing_group_desc"+checked_row);
				blng_grp_desc1.value=decodeURIComponent(arr[0]);
				
				var blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+checked_row);
				blng_grp_code1.value=decodeURIComponent(arr[1]);
				
				var payer_desc1=eval("parent.frames[1].document.forms[0].payer_desc"+checked_row);
				payer_desc1.value=decodeURIComponent(arr[2]);
				
				var cust_31=eval("parent.frames[1].document.forms[0].cust_3"+checked_row);
				cust_31.value=decodeURIComponent(arr[3]);
				
				var priority1=eval("parent.frames[1].document.forms[0].priority"+checked_row);
				priority1.value=arr[4];
				
				var policy_type_desc1=eval("parent.frames[1].document.forms[0].policy_type_desc"+checked_row);
				policy_type_desc1.value=decodeURIComponent(arr[5]);
				
				var policy_type_code1=eval("parent.frames[1].document.forms[0].policy_type_code"+checked_row);
				policy_type_code1.value=decodeURIComponent(arr[6]);
				
				var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
				policy_no1.value=decodeURIComponent(arr[7]);
				
				var policy_start_date1=eval("parent.frames[1].document.forms[0].policy_start_date"+checked_row);
				var policy_start_date_conv=arr[8];
				if(policy_start_date_conv=="" || policy_start_date_conv==" ") policy_start_date_conv="";
				if(policy_start_date_conv!="")
				{
					policy_start_date_conv=convertDate(policy_start_date_conv,"DMY","en",locale);
				}
				policy_start_date1.value=policy_start_date_conv;
				
				var policy_exp_date1=eval("parent.frames[1].document.forms[0].policy_exp_date"+checked_row);
				var policy_exp_date_conv=arr[9];
				if(policy_exp_date_conv=="" || policy_exp_date_conv==" ") policy_exp_date_conv="";
				if(policy_exp_date_conv!="")
				{
					policy_exp_date_conv=convertDate(policy_exp_date_conv,"DMY","en",locale);
				}
				policy_exp_date1.value=policy_exp_date_conv;

				if(arr[33] == "Y")
				{
					var credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_val_disp"+checked_row));
					credit_auth_ref_val_disp1.style.display="inline";

					var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
					credit_auth_ref1.value=decodeURIComponent(arr[10]);

					if(credit_auth_ref1.value=="" || credit_auth_ref1.value==" ") credit_auth_ref1.value="";

					var credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_date_val_disp"+checked_row));
					credit_auth_date_val_disp1.style.display="inline";
					
					var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
					var credit_auth_date_conv=arr[11];

					if(credit_auth_date_conv=="" || credit_auth_date_conv==" ") credit_auth_date_conv="";
					if(credit_auth_date_conv!="")
					{
						credit_auth_date_conv=convertDate(credit_auth_date_conv,"DMY","en",locale);
					}
					credit_auth_date1.value=credit_auth_date_conv;
				}
				else
				{
					var credit_auth_ref_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_val_disp"+checked_row));
					credit_auth_ref_val_disp1.style.display="none";

					var credit_auth_ref1=eval("parent.frames[1].document.forms[0].credit_auth_ref"+checked_row);
					credit_auth_ref1.value= "";
					
					var credit_auth_date_val_disp1=eval(parent.frames[1].document.getElementById("credit_auth_date_val_disp"+checked_row));
					credit_auth_date_val_disp1.style.display="none";

					var credit_auth_date1=eval("parent.frames[1].document.forms[0].credit_auth_date"+checked_row);
					credit_auth_date1.value= "";
				}

				var cred_auth_req_yn1=eval("parent.frames[1].document.forms[0].cred_auth_req_yn"+checked_row);
				cred_auth_req_yn1.value=arr[33];

				var dflt_auth_ref_as_pol_no_yn1=eval("parent.frames[1].document.forms[0].dflt_auth_ref_as_pol_no_yn"+checked_row);
				dflt_auth_ref_as_pol_no_yn1.value=arr[34];
				
				var credit_apprd_amt1=eval("parent.frames[1].document.forms[0].credit_apprd_amt"+checked_row);
				var temp_credit_apprd_amt=arr[12];
				if(temp_credit_apprd_amt==" ") temp_credit_apprd_amt="";
				credit_apprd_amt1.value=temp_credit_apprd_amt;
				
				var credit_apprd_days1=eval("parent.frames[1].document.forms[0].credit_apprd_days"+checked_row);
				var temp_credit_apprd_days=arr[13];
				if(temp_credit_apprd_days==" ") temp_credit_apprd_days="";
				credit_apprd_days1.value=temp_credit_apprd_days;
				
				var policy_eff_frm_date1=eval("parent.frames[1].document.forms[0].policy_eff_frm_date"+checked_row);
				var policy_eff_frm_date_conv=arr[14];
				if(policy_eff_frm_date_conv=="" || policy_eff_frm_date_conv==" ") policy_eff_frm_date_conv="";
				if(policy_eff_frm_date_conv!="")
				{
					policy_eff_frm_date_conv=convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
				}
				policy_eff_frm_date1.value=policy_eff_frm_date_conv;
				
				var policy_eff_to_date1=eval("parent.frames[1].document.forms[0].policy_eff_to_date"+checked_row);
				var policy_eff_to_date_conv=arr[15];
				if(policy_eff_to_date_conv=="" || policy_eff_to_date_conv==" ") policy_eff_to_date_conv="";
				if(policy_eff_to_date_conv!="")
				{
					policy_eff_to_date_conv=convertDate(policy_eff_to_date_conv,"DMY","en",locale);
				}
				policy_eff_to_date1.value=policy_eff_to_date_conv;
				
				var adj_rule_ind1=eval("parent.frames[1].document.forms[0].adj_rule_ind"+checked_row);
				adj_rule_ind1.value=decodeURIComponent(arr[16]);
				
				var adj_perc_amt_ind1=eval("parent.frames[1].document.forms[0].adj_perc_amt_ind"+checked_row);
				adj_perc_amt_ind1.value=decodeURIComponent(arr[17]);
				
				var adj_perc_amt_value1=eval("parent.frames[1].document.forms[0].adj_perc_amt_value"+checked_row);
				adj_perc_amt_value1.value=decodeURIComponent(arr[18]);
				
				var pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].pmnt_diff_adj_int"+checked_row);
				pmnt_diff_adj_int1.value=decodeURIComponent(arr[19]);
				
				var drg_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].drg_pmnt_diff_adj_int"+checked_row);
				drg_pmnt_diff_adj_int1.value=decodeURIComponent(arr[20]);
				
				var spl_srv_pmnt_diff_adj_int1=eval("parent.frames[1].document.forms[0].spl_srv_pmnt_diff_adj_int"+checked_row);
				spl_srv_pmnt_diff_adj_int1.value=decodeURIComponent(arr[21]);

				var restrict_check1=eval("parent.frames[1].document.forms[0].restrict_check"+checked_row);
				restrict_check1.value=arr[22];

				var apprd_amt_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_amt_restrict_check"+checked_row);
				apprd_amt_restrict_check1.value=arr[31];

				var apprd_days_restrict_check1=eval("parent.frames[1].document.forms[0].apprd_days_restrict_check"+checked_row);
				apprd_days_restrict_check1.value=arr[32];

				var valid_payer_YN1=eval("parent.frames[1].document.forms[0].valid_payer_YN"+checked_row);
				valid_payer_YN1.value=arr[23];

				var valid_policy_type_code_YN1=eval("parent.frames[1].document.forms[0].valid_policy_type_code_YN"+checked_row);
				valid_policy_type_code_YN1.value=arr[24];

				var cust_group_code1=eval("parent.frames[1].document.forms[0].ins_cust_group_code"+checked_row);
				cust_group_code1.value=decodeURIComponent(arr[25]);

				var cust_group_name1=eval("parent.frames[1].document.forms[0].ins_cust_group_name"+checked_row);
				cust_group_name1.value=decodeURIComponent(arr[37]);				

				var policy_coverage_basis_ind1=eval("parent.frames[1].document.forms[0].policy_coverage_basis_ind"+checked_row);
				policy_coverage_basis_ind1.value=arr[26];

				var cust_valid_from_date1=eval("parent.frames[1].document.forms[0].cust_valid_from_date"+checked_row);
				cust_valid_from_date1.value=arr[35];

				var cust_valid_to_date1=eval("parent.frames[1].document.forms[0].cust_valid_to_date"+checked_row);
				cust_valid_to_date1.value=arr[36];

				var pol_validity_chk_date=eval("parent.frames[1].document.forms[0].pol_validity_chk_date"+checked_row);
				var pol_validity_chk_date_conv = arr[38];

				if(pol_validity_chk_date_conv=="" || pol_validity_chk_date_conv==" ") pol_validity_chk_date_conv="";

				if(pol_validity_chk_date_conv!="")
				{
					pol_validity_chk_date_conv=convertDate(pol_validity_chk_date_conv,"DMY","en",locale);
				}
				pol_validity_chk_date.value=pol_validity_chk_date_conv;

				if(total_records==1)
				{
					parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value=policy_coverage_basis_ind1.value;
				}

				parent.frames[1].policy_coverage_basis_ind();

				var rec_edited_YN=eval("parent.frames[1].document.forms[0].rec_edited_YN"+checked_row);
				rec_edited_YN.value = arr[39];
				
				var mcn_for_policy=eval("parent.frames[1].document.forms[0].mcn_for_policy"+checked_row);  //V220908
				mcn_for_policy.value=decodeURIComponent(arr[51]);  //V220908
				
				var reg_ref_id=eval("parent.frames[1].document.forms[0].reg_ref_id"+checked_row);  //V230315
				reg_ref_id.value=decodeURIComponent(arr[52]);  //V230315
				
				var userId_for_priv=eval("parent.frames[1].document.forms[0].userId_for_priv"+checked_row);  //V230707
				userId_for_priv.value=decodeURIComponent(arr[53]);  //V230707
				
				var reasonCode_for_priv=eval("parent.frames[1].document.forms[0].reasonCode_for_priv"+checked_row);  //V230707
				reasonCode_for_priv.value=decodeURIComponent(arr[54]);  //V230707
				
                //Added by prithivi on 03/01/2017 for mms-qh-crf-0085 -- bupa insurance interface
				var payerEligibilityParam=eval("parent.frames[1].document.forms[0].payerEligibilityParam"+checked_row);

				var responseCode=eval("parent.frames[1].document.forms[0].responseCode"+checked_row);
				var responseCodeDesc=eval("parent.frames[1].document.forms[0].responseCodeDesc"+checked_row);
				var statuDescription=eval("parent.frames[1].document.forms[0].statuDescription"+checked_row);
				var validityPeriod=eval("parent.frames[1].document.forms[0].validityPeriod"+checked_row);
				var validityPeriodDesc=eval("parent.frames[1].document.forms[0].validityPeriodDesc"+checked_row);
				var eligibilityCode=eval("parent.frames[1].document.forms[0].eligibilityCode"+checked_row);
				var transactionId=eval("parent.frames[1].document.forms[0].transactionId"+checked_row);
				var responseDateTime=eval("parent.frames[1].document.forms[0].responseDateTime"+checked_row);

				var arrLength = arr.length-15;  // over all arr length is 55  //V230707
								
				payerEligibilityParam.value = decodeURIComponent(arr[arrLength]);
				responseCode.value = decodeURIComponent(arr[arrLength+1]);
				responseCodeDesc.value = decodeURIComponent(arr[arrLength+2]);
				statuDescription.value = decodeURIComponent(arr[arrLength+3]);
				validityPeriod.value = decodeURIComponent(arr[arrLength+4]);
				validityPeriodDesc.value = decodeURIComponent(arr[arrLength+5]);
				eligibilityCode.value = decodeURIComponent(arr[arrLength+6]);
				transactionId.value = decodeURIComponent(arr[arrLength+7]);
				responseDateTime.value = decodeURIComponent(arr[arrLength+8]);				
			}
		}
		}
		else
		{
//			alert("closed");
		}
	}
	parent.frames[1].document.forms[0].checked_row.value="";
}


// This Function can be used to remove the selected payer directly
function removePayerNew()
{
	var checked_row=parent.frames[1].document.forms[0].checked_row.value;
	//164.1
	var priority_form = eval("parent.frames[1].document.add_modify_pat_fin_det_insmain.priority"+checked_row);
	var priority=priority_form.value;
	//164.1
	var locale=document.forms[0].locale.value;
	formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	total_records=formObj.total_records.value;

	var getString=document.forms[0].queryString.value;

	var prmy_blng_grp=parent.parent.parent.frames[0].document.forms[0].billing_group.value;
	var ins_blng_grp_code_arr=new Array();

	for(var i=0;i<total_records;i++)
	{
		var ins_blng_grp_code1=eval("parent.frames[1].document.forms[0].blng_grp_code"+i);
		var ins_blng_grp_code=ins_blng_grp_code1.value;
			
		ins_blng_grp_code_arr[i]=ins_blng_grp_code;
	}
	
	var count=0;

	for(var i=0;i<ins_blng_grp_code_arr.length;i++)
	{
		if(ins_blng_grp_code_arr[i]==prmy_blng_grp) count++;
	}

	if(count == 1)
	{
		for(var i=0;i<ins_blng_grp_code_arr.length;i++)
		{
			if(i == parseInt(checked_row))
			{
				if((ins_blng_grp_code_arr[i] == prmy_blng_grp))
				{
					count=1;
				}
				else
				{
					count=0;
				}
			}
		}
	}

	if(total_records==0)
	{
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	
	if(checked_row=="")
	{
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
	}
	else
	{
		if(confirm(getMessage("BL9760","BL"))) //BL9760
		{
			if(count==1) 
			{
				if(!confirm(getMessage("BL9828","BL")))
				{
					return false;
				}
			}

			totalRecords =eval(formObj.total_records.value);
			var policy_no1=eval("parent.frames[1].document.forms[0].policy_no"+checked_row);
			var policy_no=encodeURIComponent(policy_no1.value);

			//Added priority against MMS-DM-CRF-0164.1_73081
			parent.frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?remove_check=remove&"+getString+"&checked_row="+checked_row+"&total_records="+totalRecords+"&Mem_Priority="+priority+"&policy_no="+policy_no; //Added policy_no for GHL-CRF-0550.1

			parent.frames[1].document.forms[0].submit();
		}
		else
		{
			return false;			
		}
	}
	for(var j=0;j<total_records;j++)
	{
		var temp=eval("formObj.selected_row"+j);
		temp.checked=false;
	}
	parent.frames[1].document.forms[0].checked_row.value="";	
}


//V210310 Starts
function getAgeValidation()
{				
	var moduleId=document.forms[0].calling_module_id.value;
	var functionId=document.forms[0].function_id.value;
	var patientId=document.forms[0].patient_id.value;
	var facId=document.forms[0].facility_id.value			
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var temp_jsp="../../eBL/jsp/BLCommonAjax.jsp?functionMode=validateBillingGrp&ModuleId="+moduleId+"&FunctionId="+functionId+"&patientId="+patientId+"&facId="+facId;
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var receivedText = trimString(xmlHttp.responseText);
	var n1 = receivedText.indexOf("~");
	var res = receivedText.substr(n1+1);
	return res;
}
//V210310 Ends

async function noninsblnggrplkup(clng_evnt)
{		
	var target			= document.forms[0].non_ins_billing_group_desc;	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{
			document.forms[0].non_ins_billing_group_desc.value = "";
			document.forms[0].non_insur_blng_grp.value = "";
			parent.parent.frames[1].location.href='../../eCommon/html/blank.html';
			return;
		}
	}

	var billinggroup    = document.forms[0].non_insur_blng_grp.value;
	var retVal			= new String();	
	
	var dialogTop			= "0";
	var dialogHeight		= "70vh" ;
	var dialogWidth			= "50vw" ;
	//var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	

	var cash_leg=getLabel("eBL.CASH.label","BL");
	cash_leg=encodeURIComponent(cash_leg);
	var credit_leg=getLabel("eBL.CREDIT.label","BL");
	credit_leg=encodeURIComponent(credit_leg);
	var sponsor_leg=getLabel("eBL.SPONSOR.label","BL");
	sponsor_leg=encodeURIComponent(sponsor_leg);
	var ins_leg=getLabel("Common.Insurance.label","common");
	ins_leg=encodeURIComponent(ins_leg);

	var title=getLabel("eBL.NON_INS_BILLING_GROUP.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,20%,50%,10%,5%,5%,0%,0%");   

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

	var strCitizenYn = document.forms[0].CitizenYn.value;

	var strModuleId = document.forms[0].calling_module_id.value;

	var locale = document.forms[0].locale.value;

	var ref_src_code_YN="N";
	var pmry_ref_src_mand_YN="N";
	var sec_ref_src_mand_YN="N";
	var currency_code_for_bg = "";
	var currency_desc_for_bg = "";

	sql = "called_for=NONINSBGLKUP&locale="+locale+"&module_id="+strModuleId+"&citizen_yn="+strCitizenYn;

	/* Added V20180709-Aravindh/GHL-CRF-0427/new variable fin_auth_user_id */
	var fin_auth_user_id = parent.parent.parent.frames[0].document.forms[0].fin_auth_user_id.value;
	//V210310 Starts 
	var ageVal="~N";
	var ageSiteSpec= document.forms[0].siteSpecAgeVal.value;
	if(ageSiteSpec=="Y"){		
		var res1 =getAgeValidation();
		res1 = res1.split("~");
		if(res1[0]=="S"){
			ageVal= res1[1]+"~Y";
		}
	}
	//V210310 Ends
	/* Added V20180709-Aravindh/GHL-CRF-0427/One new parameter fin_auth_user_id in below param */
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYNNNNN&fin_auth_user_id="+fin_auth_user_id+"&ageVal="+ageVal;
	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	

	var arr=new Array();		

	if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			document.forms[0].non_ins_billing_group_desc.value=arr[1];
			document.forms[0].non_insur_blng_grp.value=arr[0];

			ref_src_code_YN=arr[3];
			pmry_ref_src_mand_YN = arr[4];
			sec_ref_src_mand_YN = arr[5];

			document.forms[0].currency_code_for_bg.value=arr[6];
			document.forms[0].currency_desc_for_bg.value=arr[7];

			document.forms[0].blnggrpappyn.value = "Y";
			document.forms[0].BlngGrpStatus.value = "";
			document.forms[0].blnggrpcatgappyn.value = "Y";

			callNonInsurance(document.forms[0].non_insur_blng_grp);

			if(ref_src_code_YN=="Y")
			{
				document.getElementById('non_ins_ref_src_code_main_leg_disp').style.display="inline";
				document.getElementById('non_ins_ref_src_code_main_val_disp').style.display="inline";
				document.forms[0].non_ins_ref_src_main_code.value="";
				document.forms[0].non_ins_ref_src_main_desc.value="";
				if(pmry_ref_src_mand_YN == "Y")
				{
					document.getElementById('non_ins_ref_src_code_main_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('non_ins_ref_src_code_main_mand_disp').style.display="none";
				}
				document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_pmy_ref_src_lng_name').alt="";

				document.getElementById('non_ins_ref_src_code_sub_leg_disp').style.display="inline";
				document.getElementById('non_ins_ref_src_code_sub_val_disp').style.display="inline";
				document.getElementById('non_ins_ref_src_sub_code').value="";
				document.getElementById('non_ins_ref_src_sub_desc').value="";
				if(sec_ref_src_mand_YN == "Y")
				{
					document.getElementById('non_ins_ref_src_code_sub_mand_disp').style.display="inline";
				}
				else
				{
					document.getElementById('non_ins_ref_src_code_sub_mand_disp').style.display="none";
				}
				document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_sec_ref_src_lng_name').alt="";

				document.forms[0].non_ins_ref_src_capture_YN.value="Y";
				document.forms[0].non_ins_ref_src_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].non_ins_ref_src_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			else if(ref_src_code_YN=="N")
			{
				document.getElementById('non_ins_ref_src_code_main_leg_disp').style.display="none";
				document.getElementById('non_ins_ref_src_code_main_val_disp').style.display="none";
				document.forms[0].non_ins_ref_src_main_code.value="";
				document.forms[0].non_ins_ref_src_main_desc.value="";
				document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_pmy_ref_src_lng_name').alt="";

				document.getElementById('non_ins_ref_src_code_sub_leg_disp').style.display="none";
				document.getElementById('non_ins_ref_src_code_sub_val_disp').style.display="none";
				document.getElementById('non_ins_ref_src_sub_code').value="";
				document.getElementById('non_ins_ref_src_sub_desc').value="";
				document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_sec_ref_src_lng_name').alt="";

				document.forms[0].non_ins_ref_src_capture_YN.value="N";
				document.forms[0].non_ins_ref_src_main_mand_YN.value=pmry_ref_src_mand_YN;
				document.forms[0].non_ins_ref_src_sub_mand_YN.value=sec_ref_src_mand_YN;
			}
			curr_code();
		}
		else
		{
			target.focus();
		}
	}
}

async function getNonInsBlngGrpSearch()
{
	var billing_group=document.forms[0].non_insur_blng_grp.value;		
	
	if(billing_group=="select") billing_group="";		

	if(billing_group == "")
	{
		alert(getMessage("BL9106","BL"));
		return;
	}
	
	if((billing_group!=""))
	{
		var retVal;
		var dialogHeight= "200px" ;
		var dialogWidth	= "300px" ;
		var dialogTop = "" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;

		var url = "../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=	"+billing_group;
		retVal = await window.showModalDialog(url,arguments,features);
	}		
}

async function showMultiBlngGrp()
{
	var policy_coverage_basis_gbl_ind=parent.frames[1].document.forms[0].policy_coverage_basis_gbl_ind.value;	
	
	var formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	var total_records=formObj.total_records.value;
	
	var priority_arr=new Array();

	for(var i=0;i<total_records;i++)
	{
		var priority1=eval("parent.frames[1].document.forms[0].priority"+i);
		var priority=priority1.value;
	
		priority_arr[i]=priority;
	}
	
	var max_priority="";
	var priortiy_var1="";
	var priortiy_var2="";
	var j=1;
	
	for(var i=0;i<priority_arr.length;i++)
	{
		if(parseInt(j) <= priority_arr.length)
		{
			if(parseInt(i)==0)
				priortiy_var1=priority_arr[i];

			if(parseInt(priority_arr.length)==1)
				priortiy_var2=priority_arr[i];
			else
				priortiy_var2=priority_arr[j];

			if(priortiy_var2==null)
				priortiy_var2=priortiy_var1;

			if(parseInt(priortiy_var1) > parseInt(priortiy_var2))
				max_priority=priortiy_var1;
			else
				max_priority=priortiy_var2;

			priortiy_var1=max_priority;
			j++;
		}
	}

	if(max_priority == "") max_priority="0";

	parent.frames[1].document.forms[0].target = "InsValidationFrame";
	parent.frames[1].document.forms[0].action="../../eBL/jsp/BLInsuranceValidations.jsp?called_from=ins_dtls_post&bean_id=BLPatRegChargesBean&action=add_more_bg";
	parent.frames[1].document.forms[0].submit();

	parent.frames[1].document.forms[0].target = "";

	var retVal			= new String();
/* 	var dialogTop			= "";
	var dialogHeight		= "30" ;
	var dialogWidth			= "60" ; */
	var dialogTop			= "";
	var dialogHeight		= "95vh" ;
	var dialogWidth			= "100vw" ; 
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
		
	var title=getLabel("eBL.ADD_MORE_SECONDARY_BILLING_GROUPS.label","BL");

	title=encodeURIComponent(title);
	var queryString=document.forms[0].queryString.value;
	formObj = parent.parent.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.document.add_modify_pat_fin_det_insmain;
	var total_records=formObj.total_records.value;
	var primary_blng_grp="";
	
	primary_blng_grp=parent.frames[1].document.forms[0].blng_grp_values.value;

	/* Added V20180709-Aravindh/GHL-CRF-0427/new variable fin_auth_user_id */
	var fin_auth_user_id = parent.parent.parent.frames[0].document.forms[0].fin_auth_user_id.value;

	/* Added V20180709-Aravindh/GHL-CRF-0427/One new parameter fin_auth_user_id in below param */
	var param = "title="+title+"&primary_blng_grp="+primary_blng_grp+"&policy_coverage_basis_gbl_ind_from_main="+policy_coverage_basis_gbl_ind+"&max_priority="+max_priority+"&"+queryString+"&fin_auth_user_id="+fin_auth_user_id;
	var showModalFrame = top.window.document.getElementById('dialog-body').contentWindow.frames[0];
	retVal= await showModalFrame.window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpMain.jsp?"+param,arguments,features);
	
	
	if(	retVal!=null)
	{
		var ret_val=retVal;
		if(ret_val=="accept")
		{	
			parent.frames[1].document.forms[0].action="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?accept_check="+ret_val+"&total_records="+total_records+"&"+queryString;

			parent.frames[1].document.forms[0].submit();
		}

	}
	else
	{
		//alert("closed");
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
				document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_pmy_ref_src_lng_name').alt="";
			}
			else if (called_frm == "S")
			{
				document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_sec_ref_src_lng_name').alt="";
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
	var dialogWidth			= "60" ;
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
			
			var non_ins_ref_src_lng_name = arr[3];

			if(called_frm == 'M')
			{
				document.forms[0].non_ins_ref_src_main_code.value=arr[0];
				document.forms[0].non_ins_ref_src_main_desc.value=arr[2];

				if(non_ins_ref_src_lng_name != "")
				{
					document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="visible";
					document.getElementById('non_ins_pmy_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="hidden";
				}
			}
			if(called_frm == 'S')
			{
				document.forms[0].non_ins_ref_src_sub_code.value=arr[0];
				document.forms[0].non_ins_ref_src_sub_desc.value=arr[2];

				if(non_ins_ref_src_lng_name != "")
				{
					document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="visible";
					document.getElementById('non_ins_sec_ref_src_lng_name').alt=arr[3];
				}
				else
				{
					document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="hidden";
				}
			}
		}	
		else
		{
			if(called_frm == 'M')
			{
				document.forms[0].non_ins_ref_src_main_code.value="";
				document.forms[0].non_ins_ref_src_main_desc.value="";

				document.getElementById('non_ins_pmy_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_pmy_ref_src_lng_name').alt="";
			}
			if(called_frm == 'S')
			{
				document.forms[0].non_ins_ref_src_sub_code.value="";
				document.forms[0].non_ins_ref_src_sub_desc.value="";

				document.getElementById('non_ins_sec_ref_src_lng_name').style.visibility="hidden";
				document.getElementById('non_ins_sec_ref_src_lng_name').alt="";
			}
		}
	}
	else
	{
		if(called_frm == 'M')
		{
			document.forms[0].non_ins_ref_src_main_code.value="";
			document.forms[0].non_ins_ref_src_main_desc.value="";
		}
		if(called_frm == 'S')
		{
			document.forms[0].non_ins_ref_src_sub_code.value="";
			document.forms[0].non_ins_ref_src_sub_desc.value="";
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

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src="../../eBL/js/Hashtable.js"></script>
	<script language='javascript' src='../../eXH/js/ExternalApplication.js'></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
		if(!("Y").equalsIgnoreCase(payerGrpBySetup))
		{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='disableAllElements();curr_code(); disable();' >
<%
	}
	else{
		%>	
		<body onLoad='curr_code();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<%
	}
	}
	else
	{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="curr_code();" >
<%
	}
%>

<form name='add_modify_pat_fin_det_insbut' id='add_modify_pat_fin_det_insbut'>
<table cellpadding=0 cellspacing=1 border=0 width="100%" align='center' border=1>
<tr>
	<td>
		<input align=left type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_SECONDARY_BILLING_GROUPS.label","bl_labels")%>" class="button" onClick="showMultiBlngGrp()" >
	</td>

	<td>
	
		<input align=right type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_MORE_PAYERS.label","bl_labels")%>" class="button" onClick="addPayer()" >
		<input align=right type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.MODIFY_PAYER.label","bl_labels")%>" class="button" onClick="modifyPayer()">
		<input align=right type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.REMOVE_PAYER.label","bl_labels")%>" class="button" onClick="removePayerNew()">
			
<%
	if(siteSpecUploadDocAll) {
%>
		<input align=right type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.UploadDocuments.label","bl_labels")%>" class="button" onClick="dataForImage_ghl()">
<%}	else{%>
		<input align=right type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.UploadImages.label","bl_labels")%>" class="button" onClick="dataForImage()">
<%}	%>
<!--	<a href="javascript:dataForImage();">image upload</a>-->
   </td>	
</tr>
</table>
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
<tr>
	<td width="25%" class='label'><a href="javascript:getNonInsBlngGrpSearch();"><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></a>&nbsp;&nbsp;<div id="bg_curr_desc_disp" style="display:inline"><Font color='red'><b id="bg_curr_desc"></b></font></div></td>	
	
	<%
		String str_package_yn = "";
		pstmt = con.prepareStatement( "select blng_grp_id, short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C', ? , 'C0', ? ,'C1', ? ,'C2', ? ,'R', ? ,'R0', ? ,'R1', ? ,'R2', ? ,'X1', ? ,'X2', ? )||')' SHORT_DESC ,DECODE(?,'MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category,NVL(PACKAGE_YN,'N') PACKAGE_YN from bl_blng_grp_lang_vw where language_id= ? and (( status is null and settlement_ind || adm_rec_flag != 'X2' and ((?='MP' and ref_yn = 'Y' and ref_valid_for_regn_yn = 'Y') or (?='AE' and ae_yn = 'Y') or (?='OP' and op_yn = 'Y') or (?='IP' and ip_yn = 'Y') or (?='DC' and dy_yn = 'Y')) and (NVL(category,'UNRESTRICTED') IN ( DECODE(?,'Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED'))) and (blng_grp_id = ? and NVL(?,'N') = 'Y')) order  by short_desc" ) ;
		
		pstmt.setString(1,cash_leg);
		pstmt.setString(2,cash_leg);
		pstmt.setString(3,cash_leg);
		pstmt.setString(4,cash_leg);
		pstmt.setString(5,credit_leg);
		pstmt.setString(6,credit_leg);
		pstmt.setString(7,credit_leg);
		pstmt.setString(8,credit_leg);
		pstmt.setString(9,sponsor_leg);
		pstmt.setString(10,ins_leg);
		pstmt.setString(11,strModuleId);
		pstmt.setString(12,locale);
		pstmt.setString(13,strModuleId);
		pstmt.setString(14,strModuleId);
		pstmt.setString(15,strModuleId);
		pstmt.setString(16,strModuleId);
		pstmt.setString(17,strModuleId);
		pstmt.setString(18,strCitizenYn);
		pstmt.setString(19,mnon_insur_blng_grp);
		pstmt.setString(20,strdfltbgyn);
		
		rs = pstmt.executeQuery();
		
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				String non_blng_grp_id = rs.getString( "blng_grp_id" ) ;
				String short_desc = rs.getString( "short_desc" ) ;
				str_package_yn = rs.getString( "PACKAGE_YN" ) ;

				if((mnon_insur_blng_grp.equals(non_blng_grp_id)) && ((strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP"))))||strModuleId.equals("MP")))
				{
						str_blng_grp_id = non_blng_grp_id;
						str_short_desc = short_desc;

						strBlngGrpAppYN = rs.getString("episode_type_app_yn");
						if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
						strBlngGrpAppYN = "N";	

						strBlngGrpStatus = rs.getString("status");
						if(strBlngGrpStatus == null ||strBlngGrpAppYN.equals("null")) 
						strBlngGrpStatus="";

						strCategory = rs.getString("category");
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
			}
		}
		if(rs != null ) rs.close();
		pstmt.close() ;
		
		/*Karthik adds his change - starts here*/
		boolean nonInsuranceBlngGroupformDB=false;
		String non_ins_blng_grp_id =null;
		if(str_blng_grp_id==null || str_blng_grp_id.equals("")) //non_blng_grp_id is also placed in same string, so checking whether non insurance Billing Group exists
		{
			pstmt = con.prepareStatement("select NON_INS_BLNG_GRP_ID, short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','Cash', 'C0','Cash','C1','Cash','C2','Cash','R', 'Credit','R0', 'Credit','R1', 'Credit','R2', 'Credit','X1', 'Sponsor','X2','Insurance')||')' SHORT_DESC ,DECODE('OP','MP',ref_yn,'AE',ae_yn,'OP',op_yn,'IP',ip_yn,'DC',dy_yn)episode_type_app_yn, status , category,NVL(PACKAGE_YN,'N') PACKAGE_YN from BL_BLNG_GRP where BLNG_GRP_ID= ? ");
			pstmt.setString(1,billing_group);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					non_ins_blng_grp_id = rs.getString( "NON_INS_BLNG_GRP_ID" ) ;
					String short_desc = rs.getString( "short_desc" ) ;
					str_package_yn = rs.getString( "PACKAGE_YN" ) ;
					
					non_ins_blng_grp_id = (non_ins_blng_grp_id==null?"":non_ins_blng_grp_id);

					if( ( (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ||strModuleId.equals("MP")) )
					{
							str_blng_grp_id = non_ins_blng_grp_id;
							str_short_desc = short_desc;

							strBlngGrpAppYN = rs.getString("episode_type_app_yn");
							if (strBlngGrpAppYN== null ||strBlngGrpAppYN.equals("null"))
							strBlngGrpAppYN = "N";	

							strBlngGrpStatus = rs.getString("status");
							if(strBlngGrpStatus == null ||strBlngGrpAppYN.equals("null")) 
							strBlngGrpStatus="";

							strCategory = rs.getString("category");
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
							nonInsuranceBlngGroupformDB=true;
					}					
				}
			}
		if(rs != null )   rs.close();
		if(pstmt != null) pstmt.close();
		}
		/*Karthik adds his change - ends here*/

		if( !("".equals(str_blng_grp_id)) )
		{
			String currency_desc_for_bg_qry="Select CURRENCY_CODE,CURRENCY_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"' and language_id='"+locale+"'";
			pstmt = con.prepareStatement( currency_desc_for_bg_qry );
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
		if(str_package_yn.equals("Y"))
		{
			str_blng_grp_id = "" ;
			str_short_desc = "" ;
%>
			<script>alert(getMessage("BL6372","BL"));</script>
<%
		}

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			String sql_non_ins="select short_DESC||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC from bl_blng_grp_lang_vw where BLNG_GRP_ID='"+str_blng_grp_id+"' and language_id='"+locale+"'";
			pstmt = con.prepareStatement(sql_non_ins);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					non_ins_billing_group_desc = rs.getString( "short_desc" ) ;
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
%>
	<td width="50%" class='fields'><input type='text' name="non_ins_billing_group_desc" id="non_ins_billing_group_desc" maxlength='40' size='40' tabindex='0' value="<%=non_ins_billing_group_desc%>" onBlur="return noninsblnggrplkup('B')"><input type='button' class='button' name="noninsblnggrpbut" id="noninsblnggrpbut" value='?'  onClick="return noninsblnggrplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>
	<input type= hidden name="non_insur_blng_grp" id="non_insur_blng_grp"  value="<%=str_blng_grp_id%>">
<%
		}
		else if(nonInsuranceBlngGroupformDB){ // Karthik added for Defaulting non insurance blng group - starts

		String sql_non_ins="select short_DESC||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' SHORT_DESC from bl_blng_grp_lang_vw where BLNG_GRP_ID='"+str_blng_grp_id+"' and language_id='"+locale+"'";
		pstmt = con.prepareStatement(sql_non_ins);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				non_ins_billing_group_desc = rs.getString( "short_desc" ) ;
			}
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
%>
<td width="50%" class='fields'><input type='text' name="non_ins_billing_group_desc" id="non_ins_billing_group_desc" maxlength='40' size='40' tabindex='0' value="<%=non_ins_billing_group_desc%>" onBlur="return noninsblnggrplkup('B')"><input type='button' class='button' name="noninsblnggrpbut" id="noninsblnggrpbut" value='?'  onClick="return noninsblnggrplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>
<input type= hidden name="non_insur_blng_grp" id="non_insur_blng_grp"  value="<%=str_blng_grp_id%>">
	<%
	} // Karthik added for Defaulting non insurance blng group - ends
	else
	{
	%>
	<td width="25%" class='fields'><input type='text' name="non_ins_billing_group_desc" id="non_ins_billing_group_desc" maxlength='40' size='40' tabindex='0' value='' onBlur="return noninsblnggrplkup('B')"><input type='button' class='button' name="noninsblnggrpbut" id="noninsblnggrpbut" value='?'  onClick="return noninsblnggrplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>
	<input type= hidden name="non_insur_blng_grp" id="non_insur_blng_grp"  value="<%=str_blng_grp_id%>">
	<%
	}
	%>
	<input type= "hidden" name="currency_code_for_bg" id="currency_code_for_bg"  value="<%=str_currency_code_for_bg%>">
	<input type= "hidden" name="currency_desc_for_bg" id="currency_desc_for_bg"  value="<%=str_currency_desc_for_bg%>">
	<td width="10%" ></td>
	<td width="10%" ></td>
</tr>

<%
	String non_ins_ref_src_capture_YN="N";
	String non_ins_ref_src_main_mand_YN="N";
	String non_ins_ref_src_sub_mand_YN="N";
	String non_ins_ref_src_code_disp="";
	String non_ins_ref_src_code_main_mand_disp ="";
	String non_ins_ref_src_code_sub_mand_disp = "";
	String non_ins_ref_src_code_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N'),nvl(REF_SOURCE_MAIN_MAND_YN,'N'),nvl(REF_SOURCE_SUB_MAND_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+rtn_non_ins_blng_grp+"'";
	
	try
	{
		pstmt = con.prepareStatement(non_ins_ref_src_code_qry);
		rs2 = pstmt.executeQuery();
		if( rs2 != null ) 
		{	
			while( rs2.next() )
			{  
				non_ins_ref_src_capture_YN = rs2.getString(1);
				non_ins_ref_src_main_mand_YN = rs2.getString(2);
				non_ins_ref_src_sub_mand_YN = rs2.getString(3);
			}
		}
		if (rs2 != null) rs2.close();
		pstmt.close();	
	}
	catch(Exception e)
	{
		System.err.println("Exception in ref_src_code_qry:"+e);
		e.printStackTrace();
	}
		
	if(non_ins_ref_src_capture_YN.equals("Y"))
	{
		non_ins_ref_src_code_disp="display:inline";
		if(non_ins_ref_src_main_mand_YN.equals("Y"))
		{
			non_ins_ref_src_code_main_mand_disp = "display:inline";
		}
		else
		{
			non_ins_ref_src_code_main_mand_disp = "display:none";
		}
		if(non_ins_ref_src_sub_mand_YN.equals("Y"))
		{
			non_ins_ref_src_code_sub_mand_disp = "display:inline";
		}
		else
		{
			non_ins_ref_src_code_sub_mand_disp = "display:none";
		}
	}
	else if(non_ins_ref_src_capture_YN.equals("N"))
	{
		non_ins_ref_src_code_disp="display:none";
		non_ins_ref_src_code_main_mand_disp = "display:none";
		non_ins_ref_src_code_sub_mand_disp = "display:none";
	}
	else
	{
		non_ins_ref_src_code_disp="display:none";
		non_ins_ref_src_code_main_mand_disp = "display:none";
		non_ins_ref_src_code_sub_mand_disp = "display:none";
	}

	if(!rtn_non_ins_ref_src_main_code.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,rtn_non_ins_ref_src_main_code);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_non_ins_src_main_lng_name = call.getString(1);				
		call.close();
		if ( ref_non_ins_src_main_lng_name == null ) ref_non_ins_src_main_lng_name = "";
	}
	else
	{
		ref_non_ins_src_main_lng_name="";
	}

	if(!rtn_non_ins_ref_src_sub_code.equals(""))
	{
		CallableStatement call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);

		call.setString(2,rtn_non_ins_ref_src_sub_code);
		call.setString(3,locale);
		call.setString(4,"3");

		call.execute();							
		ref_non_ins_src_sub_lng_name = call.getString(1);				
		call.close();
		if ( ref_non_ins_src_sub_lng_name == null ) ref_non_ins_src_sub_lng_name = "";
	}
	else
	{
		ref_non_ins_src_sub_lng_name="";
	}
%>
<input type='hidden' name='non_ins_ref_src_capture_YN' id='non_ins_ref_src_capture_YN' value='<%=non_ins_ref_src_capture_YN%>'>
<input type='hidden' name='non_ins_ref_src_main_mand_YN' id='non_ins_ref_src_main_mand_YN' value='<%=non_ins_ref_src_main_mand_YN%>'>
<input type='hidden' name='non_ins_ref_src_sub_mand_YN' id='non_ins_ref_src_sub_mand_YN' value='<%=non_ins_ref_src_sub_mand_YN%>'>
<tr>
	
	<td width="25%" class="Label">
		<div id='non_ins_ref_src_code_main_leg_disp' style='<%=non_ins_ref_src_code_disp%>'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>

	<td width="25%" class="fields">
		<div id='non_ins_ref_src_code_main_val_disp' style='<%=non_ins_ref_src_code_disp%>'>
		<input type='text' name="non_ins_ref_src_main_desc" id="non_ins_ref_src_main_desc" maxlength='50' size='25' tabindex='0'  value="<%=rtn_non_ins_ref_src_main_desc%>" onBlur="return refsrclkup(document.forms[0].non_ins_ref_src_main_code,document.forms[0].non_ins_ref_src_main_desc,'M','B')" >
		<input type='button' class='button' name="refsrcmainbut" id="refsrcmainbut" value='?' onClick="return refsrclkup(document.forms[0].non_ins_ref_src_main_code,document.forms[0].non_ins_ref_src_main_desc,'M','C')" tabindex='0'>
		<div id='non_ins_ref_src_code_main_mand_disp' style='<%=non_ins_ref_src_code_main_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
	<%
		if(ref_non_ins_src_main_lng_name.equals(""))
		{
	%>
		<img src='../../eCommon/images/more.gif' name="non_ins_pmy_ref_src_lng_name" id="non_ins_pmy_ref_src_lng_name" align='center' style="visibility:hidden">
	<%
		}
		else
		{
	%>
		<img src='../../eCommon/images/more.gif' name="non_ins_pmy_ref_src_lng_name" id="non_ins_pmy_ref_src_lng_name" align='center' style="visibility:inline" alt="<%=ref_non_ins_src_main_lng_name%>">
	<%
		}
	%>						
		</div>
	</td>
	
	<td width="25%" class="Label">
		<div id='non_ins_ref_src_code_sub_leg_disp' style='<%=non_ins_ref_src_code_disp%>'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/>
		</div>
	</td>
	
	<td width="25%" class="fields">
	<div id='non_ins_ref_src_code_sub_val_disp' style='<%=non_ins_ref_src_code_disp%>'>
		<input type='text' name="non_ins_ref_src_sub_desc" id="non_ins_ref_src_sub_desc" maxlength='50' size='25' tabindex='0'  value="<%=rtn_non_ins_ref_src_sub_desc%>" onBlur="return refsrclkup(document.forms[0].non_ins_ref_src_sub_code,document.forms[0].non_ins_ref_src_sub_desc,'S','B')">
		<input type='button' class='button' name="refsrcsubbut" id="refsrcsubbut" value='?' onClick="return refsrclkup(document.forms[0].non_ins_ref_src_sub_code,document.forms[0].non_ins_ref_src_sub_desc,'S','C')" tabindex='0'>
		<div id='non_ins_ref_src_code_sub_mand_disp' style='<%=non_ins_ref_src_code_sub_mand_disp%>'><img src='../../eCommon/images/mandatory.gif'></div>
	<%
		if(ref_non_ins_src_sub_lng_name.equals(""))
		{
	%>
		<img src='../../eCommon/images/more.gif' name="non_ins_sec_ref_src_lng_name" id="non_ins_sec_ref_src_lng_name" align='center' style="visibility:hidden">
	<%
		}
		else
		{
	%>
		<img src='../../eCommon/images/more.gif' name="non_ins_sec_ref_src_lng_name" id="non_ins_sec_ref_src_lng_name" align='center' style="visibility:inline" alt="<%=ref_non_ins_src_sub_lng_name%>">
	<%
		}
	%>				
		</div>
	</td>
</tr>
	<input type='hidden' name='non_ins_ref_src_main_code' id='non_ins_ref_src_main_code' value="<%=rtn_non_ins_ref_src_main_code%>">
	<input type='hidden' name='non_ins_ref_src_sub_code' id='non_ins_ref_src_sub_code' value="<%=rtn_non_ins_ref_src_sub_code%>">
	</table>

	<input type='hidden' name='setlmt_ind' id='setlmt_ind' id='setlmt_ind' value='<%=nd_settlement_ind%>'>	
	<input type='hidden' name='ins_auth_flag' id='ins_auth_flag' value='<%=ins_auth_flag%>'>
	<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
	<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>">
	<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value='<%=strCreditDoc_YN%>'>
	<input type='hidden' name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
	<input type='hidden' name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
	<input type='hidden' name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	
	<input type='hidden' name="function_id" id="function_id" value="<%=str_function_id%>">	
	<input type='hidden' name="operation_fun" id="operation_fun" value='<%=operation%>'>	
	<input type='hidden' name="operation_mode" id="operation_mode" value='<%=billing_mode%>'>	
	<input type='hidden' name='CitizenYn' id='CitizenYn' value='<%=strCitizenYn%>'>
	<input type='hidden' name='blnggrpappyn' id='blnggrpappyn' value='<%=strBlngGrpAppYN%>'>		
	<input type='hidden' name='blnggrpcatgappyn' id='blnggrpcatgappyn' value='<%=strBlngGrpCatgAppYN%>'>
	<input type='hidden' name='BlngGrpStatus' id='BlngGrpStatus' value='<%=strBlngGrpStatus%>'>
	<input type='hidden' name='mpolicy_type' id='mpolicy_type' value="<%=mpolicy_type%>">
	<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>
	<input type='hidden' name="queryString" id="queryString"  value="<%=queryString%>">
	<input type='hidden' name="billing_group" id="billing_group"  value="<%=billing_group%>">
	<input type='hidden' name="p_patient_class" id="p_patient_class"  value='<%=p_patient_class%>'>
	<input type='hidden' name="facility_id" id="facility_id"  value='<%=facility_id%>'>
	<input type='hidden' name="episode_type" id="episode_type"  value='<%=episode_type%>'>

	<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
	<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
	<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type='hidden' name='package_enabled_yn' id='package_enabled_yn' value='<%=package_enabled_yn%>'>
	<!-- //Added by prithivi on 11/12/2016 for mms-qh-crf-0085-bupa insurance -->
	<input type='hidden' name='service_code' id='service_code' value='<%=service_code%>' >
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>' >
	<input type='hidden' name='siteSpecAgeVal' id='siteSpecAgeVal' id='siteSpecAgeVal' value="<%=siteSpecAgeVal%>"><!-- Added Against V210310-->
<%if(nonInsuranceBlngGroupformDB && !(non_ins_blng_grp_id==null) && non_ins_blng_grp_id.length() >0 ){  // Karthik added for Defaulting non insurance blng group %>
<script>noninsblnggrplkup('C');</script>
<%} %>
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{ 
		out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		if(stmt != null)  stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

