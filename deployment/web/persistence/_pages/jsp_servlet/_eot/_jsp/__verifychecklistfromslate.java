package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eOT.*;
import java.util.*;
import com.ehis.util.*;

public final class __verifychecklistfromslate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/VerifyCheckListFromSlate.jsp", 1709120416000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/VerifyCheckList.js\"></script>\n\n<script language=\'javascript\'>\nfunction funsubmitCheckInDtls_1(checklists){\n\tvar formObj = document.VerifyCheckListFromSlateForm;\t\n\tvar chk_params = formObj.params.value;\n\tvar no_of_verifications = formObj.no_of_verifications.value;\n\n\tvar checklist_stage = \"\";\n\tvar post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;\n\tvar post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;\n\tvar post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;\n\tvar post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;\n\n\tif(no_of_verifications > 0 && post_oper_user1_completed_yn==\"N\")\n\t\tchecklist_stage=\"C50\";\t\t\n\telse if(no_of_verifications > 1 && post_oper_user2_completed_yn==\"N\")\n\t\tchecklist_stage=\"C60\";\t\t\n\telse if(no_of_verifications > 2 && post_oper_user3_completed_yn==\"N\")\n\t\tchecklist_stage=\"C70\";\t\t\n\telse if(no_of_verifications > 3 && post_oper_user4_completed_yn==\"N\")\n\t\tchecklist_stage=\"C80\";\t\t\n\n\tvar order_id = formObj.order_id.value;\n\tvar checklist_arr = checklists.split(\"##\");\n\tvar verify_checklist_codes = \"&verify_checklist_code_1=\"+checklist_arr[0];\n\tvar count=1;\n\tfor(i=1;i<checklist_arr.length;i++){\n\t\tcount++;\t\t\t\t\n\t\t//verify_checklist_codes+=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i];\n\t\tverify_checklist_codes=verify_checklist_codes+\"&verify_checklist_code_\"+count+\"=\"+checklist_arr[i]; //Modified Against AAKH-SCF-0478\n\t}\n\tvar booking_or_oper_flag = \"B\";\n\tif(order_id!=null && order_id!=\"null\" && order_id!=\"\")\n\t\t\tbooking_or_oper_flag = \"ORD\";\n\n\tvar old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();\n\tvar old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();\n\tvar old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();\n\tvar old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();\n\n\tvar slate_user_id = (formObj.slate_user_id.value).toUpperCase();\n\tvar disable_checklist_fields = \"N\";\n\tvar access=\"NYNNY\";\n\tif(checklist_stage==\"C50\"){\n\t\tif(old_post_oper_user1_id!=null && old_post_oper_user1_id!=\"\" && old_post_oper_user1_id!=\"null\" && old_post_oper_user1_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNY\";\n\t\t\t}\n\t\t}\n\t}else if(checklist_stage==\"C60\"){\n\t\tif(old_post_oper_user2_id!=null && old_post_oper_user2_id!=\"\" && old_post_oper_user2_id!=\"null\" && old_post_oper_user2_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNY\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C70\"){\n\t\tif(old_post_oper_user3_id!=null && old_post_oper_user3_id!=\"\" && old_post_oper_user3_id!=\"null\" && old_post_oper_user3_id!=\"NULL\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNY\";\n\t\t\t}\n\t\t}\n\t}\n\tif(checklist_stage==\"C80\"){\n\t\tif(old_post_oper_user4_id!=null && old_post_oper_user4_id!=\"\" && old_post_oper_user4_id!=\"null\" && old_post_oper_user4_id!=\"null\"){\n\t\t\tif(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){\n\t\t\t\tdisable_checklist_fields = \"disabled\"\n\t\t\t\taccess=\"NNNNY\";\n\t\t\t}\n\t\t}\n\t}\n\n\tvar checklist_completed_yn = formObj.checklist_completed_yn.value;\n\tif(checklist_completed_yn==\"Y\"){\n\t\tdisable_checklist_fields = \"disabled\"\n\t\taccess=\"NNNNY\";\n\t}\n\tvar db_param_1=\"module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=\"+access+\"&home_required_yn=N\";\n\tvar verifychecklist = getLabel(\"eOT.VerifyCheckList.Label\",\"OT\");\n\tvar function_string = \"&function_id=OT_CHECK_LIST&function_name=\"+verifychecklist\n\tvar db_param = db_param_1 + function_string;\n\tvar url_desc = \"VerifyCheckListMain.jsp\";\n\t//Maheshwaran k added \'apply_flag\' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013\n\tvar url = url_desc+\"?\"+db_param+\"&called_from=OT_SLATE&patient_id=\"+formObj.patient_id.value+\"&slate_user_id=\"+slate_user_id+verify_checklist_codes+\"&checklist_codes_count=\"+count+\"&checklist_stage=\"+checklist_stage+\"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag=\"+booking_or_oper_flag+\"&no_of_verifications=\"+no_of_verifications+\"&user_id=\"+slate_user_id+\"&role_id_1=\"+formObj.role_id_1.value+\"&role_id_2=\"+formObj.role_id_2.value+\"&role_id_3=\"+formObj.role_id_3.value+\"&role_id_4=\"+formObj.role_id_4.value+\"&order_id=\"+order_id+\"&booking_num=\"+formObj.booking_num.value+\"&oper_num=\"+formObj.oper_num.value+\"&disable_checklist_fields=\"+disable_checklist_fields;\n//\talert(url);\n\tvar dialogHeight = \"94\" ;\n\tvar dialogWidth  = \"445\" ;\n\tvar dialogTop    = \"790\";\n\tvar dialogLeft   = \"100\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\"+dialogTop+ \"; status=no\" ;\n\tvar arguments    = \"\" ;\n\t//\tvar retVal \t   = window.showModalDialog(url, arguments, features);\n\twindow.name = \"test\";\n\tformObj.action = \"../../eOT/jsp/\"+url;\n\tformObj.method=\"POST\";\n\tformObj.target=\"test\";\n\tformObj.submit();\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body>\n<form name=\"VerifyCheckListFromSlateForm\" id=\"VerifyCheckListFromSlateForm\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\t\n\t<input type=\'hidden\' name=\'check_out_flag\' id=\'check_out_flag\' value=\'N\' >\t\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t<input type=\'hidden\' name=\"size\" id=\"size\" value=\'0\' >\n\t<input type=\'hidden\' name=\"size1\" id=\"size1\" value=\'0\' >\n\t<input type=\'hidden\' name=\"recovery_in_out_flag\" id=\"recovery_in_out_flag\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t<input type=\'hidden\' name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\t\n\n\t<input type=\'hidden\' name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t<input type=\'hidden\' name=\"no_of_verifications\" id=\"no_of_verifications\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\'hidden\' name=\"role_id_1\" id=\"role_id_1\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\'hidden\' name=\"role_id_2\" id=\"role_id_2\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\'hidden\' name=\"role_id_3\" id=\"role_id_3\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\'hidden\' name=\"role_id_4\" id=\"role_id_4\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\'hidden\' name=\"checklist_completed_yn\" id=\"checklist_completed_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\'hidden\' name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\n\t<input type=\'hidden\' name=\'post_oper_user1_completed_yn\' id=\'post_oper_user1_completed_yn\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user2_completed_yn\' id=\'post_oper_user2_completed_yn\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user3_completed_yn\' id=\'post_oper_user3_completed_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user4_completed_yn\' id=\'post_oper_user4_completed_yn\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n\t<input type=\'hidden\' name=\"old_post_oper_user1_id\" id=\"old_post_oper_user1_id\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user2_id\" id=\"old_post_oper_user2_id\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user3_id\" id=\"old_post_oper_user3_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user4_id\" id=\"old_post_oper_user4_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\n\t<input type=\'hidden\' name=\"check_for_check_list_compl\" id=\"check_for_check_list_compl\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\n</form>\n<script language=\"javascript\">\n\tfunsubmitCheckInDtls_1(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\");\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String recovery_in_out_flag =CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));

            _bw.write(_wl_block9Bytes, _wl_block9);

	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String booking_num		= CommonBean.checkForNull(request.getParameter("booking_num"));
	String order_id			= CommonBean.checkForNull(request.getParameter("order_id"),"");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String speciality_code	= CommonBean.checkForNull(request.getParameter("speciality_code"),"");
	String cur_date="";
	String cur_time="";	

	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id, request, bean_name );
	//bean.clear();
	String check_for_check_list_compl = "N";
	ArrayList timeList = bean.getSysDateTime();
	cur_date= (String) timeList.get(1);
	cur_time = (String) timeList.get(2);
	bean.loadDisposalDtls(oper_num);
	check_for_check_list_compl = bean.getCheckListReqdYNFlag("27");	
	
// Start of Verify CheckList logic

	String no_of_verifications = "1";
	int no_of_verifications_int = 1;
	String role_id_1		= "";
	String role_id_2		= "";
	String role_id_3		= "";
	String role_id_4		= "";
	ArrayList verify_checklist_arr = null;
	ArrayList user_info_arr = null;
	String old_checklist_user_id = "";
	String checklist_completed_yn = "N";
	String appt_ref_num = "";
	String verify_checklist_codes="";
	String appt_yn = "";
	String post_oper_user1_completed_yn = "N";
	String post_oper_user2_completed_yn = "N";
	String post_oper_user3_completed_yn = "N";
	String post_oper_user4_completed_yn = "N";

	String old_post_oper_user1_id	= "";
	String old_post_oper_user2_id	= "";
	String old_post_oper_user3_id	= "";
	String old_post_oper_user4_id	= "";

	// to compare the user who already entered the data with the current user
	verify_checklist_arr	= new ArrayList();
	user_info_arr			= new ArrayList();

	verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr.size()>0){
		verify_checklist_codes=(String)verify_checklist_arr.get(0);
		no_of_verifications = (String)verify_checklist_arr.get(1);
		no_of_verifications=no_of_verifications==null?"1":no_of_verifications;
		no_of_verifications=no_of_verifications.equalsIgnoreCase("null")?"1":no_of_verifications;
		no_of_verifications=no_of_verifications.equals("null")?"1":no_of_verifications;
		no_of_verifications_int = Integer.parseInt(no_of_verifications);
		role_id_1 = (String)verify_checklist_arr.get(2);
		role_id_2 = (String)verify_checklist_arr.get(3);
		role_id_3 = (String)verify_checklist_arr.get(4);
		role_id_4 = (String)verify_checklist_arr.get(5);
	}else{
		verify_checklist_codes="";
		no_of_verifications = "";
		no_of_verifications_int = 1;
		role_id_1 = "";
		role_id_2 = "";
		role_id_3 = "";
		role_id_4 = "";
	}
	user_info_arr = (ArrayList)bean.getUserInfo(booking_num,oper_num,"1",order_id);
	if(user_info_arr.size()>0){

		post_oper_user1_completed_yn = (String)user_info_arr.get(9);
		post_oper_user2_completed_yn = (String)user_info_arr.get(11);
		post_oper_user3_completed_yn = (String)user_info_arr.get(13);
		post_oper_user4_completed_yn = (String)user_info_arr.get(15);

		old_post_oper_user1_id		 = (String)user_info_arr.get(8);
		old_post_oper_user2_id		 = (String)user_info_arr.get(10);
		old_post_oper_user3_id		 = (String)user_info_arr.get(12);
		old_post_oper_user4_id		 = (String)user_info_arr.get(14);

		if(no_of_verifications_int==1){
			if(post_oper_user1_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==2){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==3){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==4){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y") && post_oper_user4_completed_yn.equals("Y"))
			checklist_completed_yn		 = "Y";
		}else
			checklist_completed_yn		 = "N";
	}else{
		old_post_oper_user1_id		 = "";
		old_post_oper_user2_id		 = "";
		old_post_oper_user3_id		 = "";
		checklist_completed_yn		 = "N";
	}
// till here

// End of Verify CheckList Logic

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(CommonBean.checkForNull(request.getParameter("facility_id"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(recovery_in_out_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(no_of_verifications));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(role_id_1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(role_id_2));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(role_id_3));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(role_id_4));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checklist_completed_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(post_oper_user1_completed_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(post_oper_user2_completed_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(post_oper_user3_completed_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(post_oper_user4_completed_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_post_oper_user1_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(old_post_oper_user2_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(old_post_oper_user3_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(old_post_oper_user4_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(check_for_check_list_compl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(verify_checklist_codes));
            _bw.write(_wl_block38Bytes, _wl_block38);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
