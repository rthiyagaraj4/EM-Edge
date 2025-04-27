package jsp_servlet._emp._jsp._25032024;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __patientreghead extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/emp/jsp/25032024/PatientRegHead.jsp", 1712729845958L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<Script>\n\t\t\n    function CheckForSpecChars(event)\n\t{\n      var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*\';\n      var whichCode = (window.Event) ? event.which : event.keyCode;\n      key = String.fromCharCode(whichCode);  // Get key value from key code\n      if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t  if( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\t  return true ;\n   }\n\t\t\n\t</Script>\n\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<form name=\'regdPatHeadForm\' id=\'regdPatHeadForm\'>\n<table name=\'patient_table\' id=\'patient_table\' width=\'100%\' border=\'0\' cellspacing=\'0\'>\n<!--Width is change to 50% from 100% by Rameswar on 18/04/2016 for HSA-CRf-0299-->\n<tr></tr>\n<tr></tr>\n<tr></tr>\n\t  <tr>\n        <td class=\'label\' nowrap><fmt:message key=\"eMP.PopulateFrom.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></td>\n\t\t<td class=\'fields\' colspan=\'4\'><SELECT name=\'refrlAappt\' id=\'refrlAappt\' onChange=\'enbDsbRefIDVal(this);\' ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="><option>---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>---</option>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</SELECT>&nbsp;&nbsp;\n\t\t\n\t\t<input type=\'text\'  maxlength=\"20\" name=\'refIDValue\' id=\'refIDValue\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  onBlur=\"chkrefIDValue(this);\" onkeypress=\"return CheckForSpecChars(event);\" disabled><input type=\'button\' class=\'button\' name=\'refIDValueButton\' id=\'refIDValueButton\' value=\'?\' onClick=\'PopAppRefDetails();\' disabled><img id=\"phimg\" src=\'../../eCommon/images/mandatory.gif\' style=\"Visibility : \'Hidden\';\"></td>\n\t</tr>\n\t<tr>\n     \t<td class=\'label\' nowrap><fmt:message key=\"Common.patientId.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/></td>\n\t\t<td class=\'fields\' nowrap colspan=\'2\'><input class=\'upper\' name=\'patient_id\' id=\'patient_id\' size=\'18\' maxlength=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onFocus=\'loadPatSeriesManual();\' onblur=\'ChangeUpperCase(this);checkPatientId()\' readonly  disabled onKeyPress=\'return CheckForSpecChars(event)\'><!-- <img src=\'../../eCommon/images/mandatory.gif\'></img>-->\n \t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'text\'   name=\'patient_name\' id=\'patient_name\' size=\'50\' maxlength=\'90\' readonly value=\'\'></td> \n\t\t<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->\n        ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td class=\'fields\' >&nbsp;&nbsp;</td>\t\n    </tr>\n\t</table>\n<!-- Code for Painting Tabs -->\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\'<fmt:message key=\"eMP.demographicdetails.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\'>\n\t\t\t\t<a onclick=\"invokeTab(\'demogrp_tab\')\" class=\"tabClicked\" id=\"demogrp_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"demogrp_tabspan\"><fmt:message key=\"eMP.demographicdetails.label\" bundle=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'<fmt:message key=\"Common.contactmode.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/> & <fmt:message key=\"Common.AddressDetails.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\'>\n\t\t\t\t<a onclick=\"invokeTab(\'cmodeaddr_tab\')\" class=\"tabA\" id=\"cmodeaddr_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"cmodeaddr_tabspan\"><fmt:message key=\"eMP.ContactAddresses.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\'<fmt:message key=\"eMP.relatedcontacts.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/> <fmt:message key=\"Common.details.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\'>\n\t\t\t\t<a onclick=\"invokeTab(\'rlcnts_tab\')\" class=\"tabA\" id=\"rlcnts_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"rlcnts_tabspan\"><fmt:message key=\"eMP.relatedcontacts.label\" bundle=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t<li class=\"tablistitem\" title=\'<fmt:message key=\"Common.documents.label\" bundle=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/> & <fmt:message key=\"Common.others.label\" bundle=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\'>\n\t\t\t\t<a onclick=\"invokeTab(\'pat_docs_tab\')\" class=\"tabA\" id=\"pat_docs_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"pat_docs_tabspan\"><fmt:message key=\"Common.documents.label\" bundle=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<li class=\"tablistitem\" title=\'<fmt:message key=\"Common.financialdetails.label\" bundle=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\'>\n\t\t\t\t<a onclick=\"invokeTab(\'findtl_tab\')\" class=\"tabA\" id=\"findtl_tab\" id=\"findtl_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\"><fmt:message key=\"Common.financialdetails.label\" bundle=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t</ul>\n<!--End Of code for Painting Tabs -->\n<!-- The below line is required to change the select state of Demograph tab initially selected -->\n\t<script>prevTabObj=\'demogrp_tab\'</script>\n </td></tr>\n</table>\n\t\t\t\n<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'bl_oper_yn\' id=\'bl_oper_yn\' value=\"%=bl_install_yn%>\">\n<input type=\'hidden\' name=\'calledFromModule\' id=\'calledFromModule\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'acpt_appt_rfrl_in_reg_pat_yn\' id=\'acpt_appt_rfrl_in_reg_pat_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'IPinstall_yn\' id=\'IPinstall_yn\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'OPinstall_yn\' id=\'OPinstall_yn\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\'hidden\' name=\'OAinstall_yn\' id=\'OAinstall_yn\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'RDinstall_yn\' id=\'RDinstall_yn\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'toDayDate\' id=\'toDayDate\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\'hidden\' name=\'PatIdflag\' id=\'PatIdflag\'>\n\n<script>\n\tif(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'!=\'\'&&\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"==\"Y\"){\n\t\t//chkrefIDValue(document.getElementById(\"refIDValue\"));\n\t\tsetTimeout(\"chkrefIDValue(\'\"+document.getElementById(\"refIDValue\")+\"\')\",1500);\n\t\t}\n</script>\n\t\n</form>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale					= (String)session.getAttribute("LOCALE");
	String disableAtttribute			= "";
	String refIDDefaultValue			= "";
	String language_direction="";
	int count=0;		
	String drfunctionid = request.getParameter("dr_function_id");
	if(drfunctionid == null) drfunctionid = "";	
	String calledFromModule = request.getParameter("calledFromModule");
	String appt_ref_no = request.getParameter("appt_ref_no");
	String booking_ref_no = request.getParameter("booking_ref_no");
	String referral_id = request.getParameter("referral_id");
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn")==null?"N":request.getParameter("pat_name_as_multipart_yn");
	String acpt_appt_rfrl_in_reg_pat_yn = request.getParameter("acpt_appt_rfrl_in_reg_pat_yn")==null?"N":request.getParameter("acpt_appt_rfrl_in_reg_pat_yn");
	String names_in_oth_lang_yn=request.getParameter("names_in_oth_lang_yn")==null?"N":request.getParameter("names_in_oth_lang_yn");
	String cntlang	= request.getParameter("cntlang")==null?"0":request.getParameter("cntlang");
	String toDayDate		= request.getParameter("toDayDate")==null?"":request.getParameter("toDayDate");
	String patient_id_length		= request.getParameter("patient_id_length")==null?"":request.getParameter("patient_id_length");		
	String OAinstall_yn		= checkForNull( request.getParameter("oainstall_yn") );
	String RDinstall_yn		= checkForNull( request.getParameter("rdinstall_yn") );
	String OPinstall_yn		= checkForNull( request.getParameter("opinstall_yn") );
	String IPinstall_yn		= checkForNull( request.getParameter("ipinstall_yn") );
	if(calledFromModule == null || calledFromModule.equals("null")) calledFromModule="";
	if(appt_ref_no == null || appt_ref_no.equals("null")) appt_ref_no="";
	if(booking_ref_no == null || booking_ref_no.equals("null")) booking_ref_no="";
	if(referral_id == null || referral_id.equals("null")) referral_id="";	
	if(!appt_ref_no.equals("")) refIDDefaultValue = appt_ref_no;
	else if(!booking_ref_no.equals("")) refIDDefaultValue = booking_ref_no;
	else if(!referral_id.equals("")) refIDDefaultValue = referral_id;
	else refIDDefaultValue = "";	
	if(!refIDDefaultValue.equals("")) disableAtttribute = "disabled"; 
	else disableAtttribute = ""; 
	 Connection con = ConnectionManager.getConnection(request);//Added By dharma
try
{

    String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");
  	String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");              
	count = Integer.parseInt(cntlang)	;
	
		if ( count==1 ) {
			 language_direction = "R" ;
		} else {
			 language_direction = "L" ;
		}


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String SelectedValue				= "";	
	StringBuffer OptionBuffer = null;
	OptionBuffer = new StringBuffer();	
	OptionBuffer.append("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientInformation.label","mp_labels")+"</option>");


		if(acpt_appt_rfrl_in_reg_pat_yn.equals("Y")) 	{
		
			if(OAinstall_yn.equals("Y")) {
				
				/*Added By Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982]Start*/
		
			/*	if(!booking_ref_no.equals("") && appt_ref_no.equals("")){
					HashMap ResultParamHashMap = new HashMap();
					HashMap sqlColumns = new HashMap();
					sqlColumns.put("APPT_REF_NO","S");
					String whereClause	= "where APPT_REF_NO='"+booking_ref_no+"'";
					ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"OA_APPT",con);
					String apptNo				 = (String) (ResultParamHashMap.get("APPT_REF_NO")==null?"":ResultParamHashMap.get("APPT_REF_NO"));
				
					if(!apptNo.equals("")){
						appt_ref_no		= booking_ref_no;
						booking_ref_no	= "";
					}
				}*/
				/*Added By Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982]End*/

				if(!appt_ref_no.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='A' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ApptSch.label","mp_labels")+"</option>");
			}	
			if(RDinstall_yn.equals("Y")) {
				OptionBuffer.append("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RdAppts.label","mp_labels")+"</option>");
			}
			if(OPinstall_yn.equals("Y")) {
				if(!referral_id.equals("") && SelectedValue.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='L' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+"</option>");
			}	
			if(IPinstall_yn.equals("Y")) 	{
				if(!booking_ref_no.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='I' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IpBooking.label","mp_labels")+"</option>");
			}
	}
	
	 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(disableAtttribute));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(OptionBuffer.toString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(refIDDefaultValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block12Bytes, _wl_block12);
		
		if(names_in_oth_lang_yn.equals("Y"))
			{
				out.println("<td class='fields' ><input type='text'  name='patient_name_loc_lang' id='patient_name_loc_lang' size='50' maxlength='90' readonly onBlur='makeValidString(this);'");

				if(language_direction.equals("R"))
				{
				out.println("dir='RTL'" ) ;
				}
				
				out.println(" ></td>" ) ;
			}
			else{
			out.println("<td class='fields' >&nbsp;&nbsp;</td>");
			}
		
        
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(calledFromModule));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(IPinstall_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(OPinstall_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(OAinstall_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(RDinstall_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDayDate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(refIDDefaultValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
	if(OptionBuffer != null && OptionBuffer.length() > 0)
	{
		OptionBuffer.delete(0,OptionBuffer.length());
	}
}catch(Exception e)
{
    out.println("Exception in main try"+e.getMessage());
}finally
{
	 if(con!=null) ConnectionManager.returnConnection(con,request);//Added By dharma
}

            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
