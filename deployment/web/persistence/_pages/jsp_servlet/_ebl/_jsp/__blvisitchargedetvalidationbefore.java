package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blvisitchargedetvalidationbefore extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLVisitChargeDetValidationBefore.jsp", 1731402663536L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n<head>\n\n\n<script language=\'javascript\'>\n\nasync function hsptl_chrg()\n{\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\tvar episode_id=document.forms[0].episode_id.value;\n\tvar encounter_id=document.forms[0].encounter_id.value;\n\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\tvar acc_seq_no=document.forms[0].acc_seq_no.value;\n\n\tvar service_panel_ind=document.forms[0].serv_panel_ind.value;\n\tvar service_panel_code=document.forms[0].serv_panel_code.value;\n\n\tvar service_date=document.forms[0].service_date.value;\n\tvar query_string=document.forms[0].query_string.value;\n\n\tvar clinic_code=document.forms[0].clinic_code.value;\n\n\tvar order_catalog_code=\"\";\n\n\tvar retArray = new Array();\n\t\n\tvar include_label=encodeURIComponent(getLabel(\"Common.Include.label\",\"common\"));\n\tvar exclude_label=encodeURIComponent(getLabel(\"Common.Exclude.label\",\"common\"));\n\n\t// Added for Edge work: to extend the parent before opening the dialog so that child dialog can extend to its full height and width\n\tvar parentDialog = parent.parent.document.getElementById(\"dialog_tag\");\n\tvar originalHeight;\n\tvar originalWidth;\n\tif (parentDialog != null) {\n\t\toriginalHeight = parent.parent.document.getElementById(\"dialog_tag\").style.height;\n\t\toriginalWidth = parent.parent.document.getElementById(\"dialog_tag\").style.width;\n\t\t//parentDialog.style.height = \"80vh\";\n\t\t//parentDialog.style.width = \"100vh\";\n\t}\n\t\n\t\n\tvar dialogTop = \"0vh\";\n\tvar dialogHeight = \"80vh\" ;\n\tvar dialogWidth = \"90vw\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&column_sizes=\"+column_sizes+\"&column_descriptions=\"+column_descriptions+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&acct_seq_no=\"+acc_seq_no+\"&service_panel_code=\"+service_panel_code+\"&service_panel_ind=\"+service_panel_ind+\"&service_date=\"+service_date+\"&order_catalog_code=\"+order_catalog_code+\"&module_id=\"+calling_module_id+\"&include_label=\"+include_label+\"&exclude_label=\"+exclude_label+\"&clinic_code=\"+clinic_code;\n\n\t\n\tretArray= await parent.window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?\"+param,arguments,features);\n\t\n\t// Added for Edge Work: After the child dialog is closed, restore the original dimensions of the parent dialog\n\tif (parentDialog != null) {\n\t\tparentDialog.style.height = originalHeight;\n\t\tparentDialog.style.width = originalWidth;\n\t}\n\t\n\tvar str =unescape(retArray);\n\tvar arr = str.split(\",\");\n\tif(retArray!=null)\n\t{\n\t\tif(retArray[0]==\"Y\")\n\t\t{\n\t\t\tvar total_payable=arr[1];\n\t\t\tvar patient_payable=arr[2];\n\t\t\tvar quantity=arr[4];\n\t\t\tvar rate=arr[5];\n\n//\t\t\talert(\"total_payable:\"+total_payable);\n//\t\t\talert(\"patient_payable:\"+patient_payable);\n//\t\t\talert(\"quantity:\"+quantity);\n//\t\t\talert(\"rate:\"+rate);\n\t\t\t\n\t\t\tvar url=\"../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?hsptl_chrg_flag=Y&total_payable=\"+total_payable+\"&patient_payable=\"+patient_payable+\"&quantity=\"+quantity+\"&rate=\"+rate+\"&\"+query_string;\n//\t\t\talert(\"url:\"+url);\n\t\t\tparent.frames[1].location.href=url;\n\t\t}\n\t}\n\n}\n\nasync function prof_chrg()\n{\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\tvar episode_id=document.forms[0].episode_id.value;\n\tvar encounter_id=document.forms[0].encounter_id.value;\n\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\tvar acc_seq_no=document.forms[0].acc_seq_no.value;\n\t\n\tvar service_panel_ind=document.forms[0].serv_panel_ind.value;\n\tvar service_panel_code=document.forms[0].serv_panel_code.value;\n\n\tvar service_date=document.forms[0].service_date.value;\n\n\tvar clinic_code=document.forms[0].clinic_code.value;\n\tvar query_string=document.forms[0].query_string.value;\n\n\tvar order_catalog_code=\"\";\n\n\tvar retArray = new Array();\n\t\t\t\t\n\tvar include_label=encodeURIComponent(getLabel(\"Common.Include.label\",\"common\"));\n\tvar exclude_label=encodeURIComponent(getLabel(\"Common.Exclude.label\",\"common\"));\n\t\n\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"30\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&column_sizes=\"+column_sizes+\"&column_descriptions=\"+column_descriptions+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&acct_seq_no=\"+acc_seq_no+\"&service_panel_code=\"+service_panel_code+\"&service_panel_ind=\"+service_panel_ind+\"&service_date=\"+service_date+\"&order_catalog_code=\"+order_catalog_code+\"&module_id=\"+calling_module_id+\"&include_label=\"+include_label+\"&exclude_label=\"+exclude_label+\"&clinic_code=\"+clinic_code;\n\n\tretArray= await window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?\"+param,arguments,features);\n\tvar str =unescape(retArray);\n\tvar arr = str.split(\",\");\n\tif(retArray!=null)\n\t{\n\t\tif(arr[0]==\"Y\")\n\t\t{\n\t\t\tvar total_payable=arr[1];\n\t\t\tvar patient_payable=arr[2];\n\t\t\tvar quantity=arr[4];\n\t\t\tvar rate=arr[5];\n//\t\t\talert(\"total_payable:\"+total_payable);\n//\t\t\talert(\"patient_payable:\"+patient_payable);\n//\t\t\talert(\"quantity:\"+quantity);\n//\t\t\talert(\"rate:\"+rate);\n\n\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?prof_chrg_flag=Y&total_payable=\"+total_payable+\"&patient_payable=\"+patient_payable+\"&quantity=\"+quantity+\"&rate=\"+rate+\"&\"+query_string;\n\t\t}\n\t}\n\n}\n\nasync function addl_chrg()\n{\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar patient_id = document.forms[0].patient_id.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\tvar episode_id=document.forms[0].episode_id.value;\n\tvar encounter_id=document.forms[0].encounter_id.value;\n\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\tvar acc_seq_no=document.forms[0].acc_seq_no.value;\n\t\n\tvar service_panel_ind=document.forms[0].serv_panel_ind.value;\n\tvar service_panel_code=document.forms[0].serv_panel_code.value;\n\n\tvar service_date=document.forms[0].service_date.value;\n\n\tvar clinic_code=document.forms[0].clinic_code.value;\n\tvar query_string=document.forms[0].query_string.value;\n\n\tvar order_catalog_code=\"\";\n\n\tvar retArray = new Array();\n\t\t\t\t\n\tvar include_label=encodeURIComponent(getLabel(\"Common.Include.label\",\"common\"));\n\tvar exclude_label=encodeURIComponent(getLabel(\"Common.Exclude.label\",\"common\"));\n\t\n\n\tvar dialogTop = \"100\";\n\tvar dialogHeight = \"30\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.EDIT_ENTER_CHARGE_DETAILS.label\",\"BL\"));\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&column_sizes=\"+column_sizes+\"&column_descriptions=\"+column_descriptions+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&acct_seq_no=\"+acc_seq_no+\"&service_panel_code=\"+service_panel_code+\"&service_panel_ind=\"+service_panel_ind+\"&service_date=\"+service_date+\"&order_catalog_code=\"+order_catalog_code+\"&module_id=\"+calling_module_id+\"&include_label=\"+include_label+\"&exclude_label=\"+exclude_label+\"&clinic_code=\"+clinic_code;\n\n\tretArray= await window.showModalDialog(\"../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?\"+param,arguments,features);\n\tvar str =unescape(retArray);\n\tvar arr = str.split(\",\");\n\tif(retArray!=null)\n\t{\n\t\tif(retArray[0]==\"Y\")\n\t\t{\n\t\t\tvar total_payable=arr[1];\n\t\t\tvar patient_payable=arr[2];\n\t\t\tvar quantity=arr[4];\n\t\t\tvar rate=arr[5];\n//\t\t\talert(\"total_payable:\"+total_payable);\n//\t\t\talert(\"patient_payable:\"+patient_payable);\n//\t\t\talert(\"quantity:\"+quantity);\n//\t\t\talert(\"rate:\"+rate);\n\n\t\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?addl_chrg_flag=Y&total_payable=\"+total_payable+\"&patient_payable=\"+patient_payable+\"&quantity=\"+quantity+\"&rate=\"+rate+\"&\"+query_string;\n\t\t}\n\t}\n\n}\n\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\t\t\t\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\'hsptl_chrg()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body onLoad=\'prof_chrg()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body onLoad=\'addl_chrg()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\n<form >\n\t<input type=hidden name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\t\n\t <input type=hidden name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\n\t <input type=hidden name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\t\n\t <input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=hidden name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=hidden name=\'acc_seq_no\' id=\'acc_seq_no\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\n\n\t <input type=hidden name=\'serv_panel_ind\' id=\'serv_panel_ind\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t <input type=hidden name=\'serv_panel_code\' id=\'serv_panel_code\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\n\t<input type=hidden name=\'service_date\' id=\'service_date\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=hidden name=\'hsptl_chrg\' id=\'hsptl_chrg\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=hidden name=\'prof_chrg\' id=\'prof_chrg\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=hidden name=\'addl_chrg\' id=\'addl_chrg\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t\n\n\t<input type=hidden name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\n\t\n\n\n\n\t<input type=hidden name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<script>\n\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con				= null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	try{	
	request.setCharacterEncoding("UTF-8");

	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);

	String panel_str="";

	long encounter_id=0;
	int acc_seq_no=1;
	String strAccSeqNo="";

	String serv_panel_ind="";
	String serv_panel_code="";
	String service_date="";
	String call_after_reg="";

	String query_string="";

	query_string=request.getQueryString();

	HashMap pString = new HashMap();

	String episode_type=request.getParameter("episode_type");
	if(episode_type==null) episode_type="";
	String episode_id=request.getParameter("episode_id");
	if(episode_id==null) episode_id="";
	String patient_id=request.getParameter("patient_id");
	if(patient_id==null) patient_id="";
	String visit_id=request.getParameter("visit_id");
	if(visit_id==null) visit_id="";
	String calling_module_id=request.getParameter("calling_module_id");
	if(calling_module_id==null) calling_module_id="";
	String facility_id=(String)httpSession.getValue("facility_id");
	if(facility_id==null) facility_id="";

	call_after_reg=request.getParameter("call_after_reg");
	if(call_after_reg==null) call_after_reg="";
	
	String hsptl_chrg=request.getParameter("hsptl_chrg");
	if(hsptl_chrg==null) hsptl_chrg="";

	String prof_chrg=request.getParameter("prof_chrg");
	if(prof_chrg==null) prof_chrg="";

	String addl_chrg=request.getParameter("addl_chrg");
	if(addl_chrg==null) addl_chrg="";

	String hsptl_chrg_flag=request.getParameter("hsptl_chrg_flag");
	if(hsptl_chrg_flag==null) hsptl_chrg_flag="";

	String prof_chrg_flag=request.getParameter("prof_chrg_flag");
	if(prof_chrg_flag==null) prof_chrg_flag="";

	String addl_chrg_flag=request.getParameter("addl_chrg_flag");
	if(addl_chrg_flag==null) addl_chrg_flag="";

	String clinic_code=request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	if(hsptl_chrg.equals("Y"))
	{
//		System.out.println("Inside hsptl_chrg");
		String hosp_panel_str_YN=(String)session.getAttribute("hosp_panel_str_YN");
		if(hosp_panel_str_YN==null || hosp_panel_str_YN.equals("")) hosp_panel_str_YN="";
		if(hosp_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("hosp_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("hosp_panel_str");
		}
		
		serv_panel_ind=request.getParameter("hosp_serv_panel_ind");
		serv_panel_code=request.getParameter("hosp_serv_panel_code");
	}
	else if(prof_chrg.equals("Y"))
	{
//		System.out.println("Inside prof_chrg");
		String prof_panel_str_YN=(String)session.getAttribute("prof_panel_str_YN");
		if(prof_panel_str_YN==null || prof_panel_str_YN.equals("")) prof_panel_str_YN="";
		if(prof_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("prof_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("prof_panel_str");
		}
		
		serv_panel_ind=request.getParameter("med_serv_panel_ind");
		serv_panel_code=request.getParameter("med_serv_panel_code");
	}
	else if(addl_chrg.equals("Y"))
	{
//		System.out.println("Inside addl_chrg");
		String addl_panel_str_YN=(String)session.getAttribute("addl_panel_str_YN");
//		System.out.println("addl_panel_str_YN:"+addl_panel_str_YN);
		if(addl_panel_str_YN==null || addl_panel_str_YN.equals("")) addl_panel_str_YN="";
		if(addl_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("addl_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("addl_panel_str");
		}
		
		serv_panel_ind=request.getParameter("addl_serv_panel_ind");
		serv_panel_code=request.getParameter("addl_serv_panel_code");
	}
	else
	{
//		System.out.println("Inside else");
		panel_str="";
	}

	pString.put("panel_str",panel_str); 

	pString.put("episode_type",episode_type);
	pString.put("episode_id",episode_id);
	pString.put("patient_id",patient_id);
	pString.put("visit_id",visit_id);
//	System.out.println("Panel String in Visit Validation:"+panel_str);
	session.setAttribute("BlChargeRecord",(HashMap)pString);

	if(call_after_reg.equals("Y"))
	{
		try
		{
			String acc_seq_no_sql="select cur_acct_seq_no from bl_visit_fin_dtls where OPERATING_FACILITY_ID=? AND EPISODE_TYPE =? AND EPISODE_ID=? AND VISIT_ID =? AND PATIENT_ID  =?";

			/* stmt = con.createStatement();
			rs = stmt.executeQuery(acc_seq_no_sql) ; */
			pstmt = con.prepareStatement(acc_seq_no_sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, episode_type);
			pstmt.setString(3, episode_id);
			pstmt.setString(4, visit_id);
			pstmt.setString(5, patient_id);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					strAccSeqNo= rs.getString(1);
				}
			}

			if(rs != null) rs.close();
			pstmt.close();

			if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";

//			System.out.println("strAccSeqNo:"+strAccSeqNo);
		}
		catch(Exception e)
		{
			System.out.println("Exception in Acc Seq No:"+e);
		}
					
		acc_seq_no=Integer.parseInt(strAccSeqNo);
//		System.out.println("acc_seq_no:"+acc_seq_no);
	}

	try
	{
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				service_date = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in Sys Date :"+e);
	}




            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(hsptl_chrg.equals("Y"))
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	else if(prof_chrg.equals("Y"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else if(addl_chrg.equals("Y"))
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	else
	{

            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(acc_seq_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(serv_panel_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(serv_panel_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(service_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hsptl_chrg));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prof_chrg));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(addl_chrg));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	catch(Exception e)
	{
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
