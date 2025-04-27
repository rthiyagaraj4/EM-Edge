package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpatglholdercheck extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPatGlHolderCheck.jsp", 1742752324088L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t<script>\t\n\tfunction slmtIndCheck(v_slmt_ind){\t\t\n\t\tvar module_id = parent.frames[0].document.forms[0].calling_module_id.value;\n\t\tvar operation=parent.frames[0].document.forms[0].operation.value;\n\t\tvar booleanSecurity =parent.frames[0].document.forms[0].boolean_security.value;\n\t\tvar SiteSpecific=parent.frames[0].document.forms[0].SiteSpecific.value;\n\t\t\t\n\t\t//\tif(v_slmt_ind == \'R\')\t\t\t\n\t\t\tif(v_slmt_ind == \'R\' || (v_slmt_ind == \'X\')){\n\t\t\tparent.frames[0].document.getElementById(\'sel_resp_for_pay_disp\').style.display=\"none\";\n\t\t\t}\n\t\t//\telse if(v_slmt_ind == \'C\' || (v_slmt_ind == \'X\'))\t\t\t\n\t\t\telse if(v_slmt_ind == \'C\'){\n\t\t\tparent.frames[0].document.getElementById(\'sel_resp_for_pay_disp\').style.display=\"inline\";\n\t\t\t}\t\n\t\n\t\t\tif(v_slmt_ind == \'R\'){\n\t\t\tparent.frames[0].document.forms[0].resp_for_payment.disabled = true;\n\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Disabling Relationship/Starts */\n\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = true;\n\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled = true;\n\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Disabling Relationship/Ends */\n\t\t\t}\n\t\t\telse{\n\t\t\t\tif(!(module_id== \"MP\" && operation== \"Update\" && booleanSecurity== \"true\"&& SiteSpecific== \"Y\")){\n\t\t\tparent.frames[0].document.forms[0].resp_for_payment.disabled = false;\n\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Starts */\n\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = false;\n\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled = false;\n\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Ends */\n\t\t\t}\t\n\t\t\t}\t\n\t\t\n\t}\n\t\t function glholdercheck()\n\t\t {\n\t\t\t var module_id = parent.frames[0].document.forms[0].calling_module_id.value;\n\t\t\t\tvar operation=parent.frames[0].document.forms[0].operation.value;\n\t\t\t\tvar booleanSecurity =parent.frames[0].document.forms[0].boolean_security.value;\n\t\t\t\tvar SiteSpecific=parent.frames[0].document.forms[0].SiteSpecific.value;\n\t\t\t\t//Added on 26/10/2004 By BLR Team\n\t\t\t\tvar billing_group = document.forms[0].billing_group.value;\t\n\t\t\t\tvar calling_module_id = document.forms[0].calling_module_id.value;\n\t\t\t\t//Addition ends for variables. Check for Billing group being non empty introduced.  \n\t\t\t\tvar v_slmt_ind = document.forms[0].settlement_ind.value;\n\t\t\t\tvar adm_rec_flag=document.forms[0].adm_rec_flag.value;\n\t\t\t\tvar credit_doc_ref_reqd_yn = document.forms[0].credit_doc_ref_reqd_yn.value;\n\t\t\t\tvar v_gl_yn = parent.frames[0].document.forms[0].third_party_gl_in_use_yn.value;\n\n\t\t\t\tvar v_gl_holder_name = document.forms[0].gl_holder_name.value;\n\t\t\t\tvar v_no_of_dependants = document.forms[0].no_of_dependants.value;\n\n\t\t\t\tvar pat_reln_with_gl_holder = document.forms[0].gl_rel.value;\n\t\t\t\tvar v_respay = document.forms[0].resp_pay.value;\n\t\t\t\tvar v_respay_rel = document.forms[0].resp_pay_rel.value;\n\t\t\t\tvar customer_id = document.forms[0].customer_id.value;\n\n\t\t\t\tparent.frames[0].document.forms[0].setlmt_ind.value = v_slmt_ind;\n\t\t\t\tparent.frames[0].document.forms[0].adm_rec_flag.value = adm_rec_flag;\n\t\t\t\tparent.frames[0].document.forms[0].credit_doc_ref_reqd_yn.value = credit_doc_ref_reqd_yn;\n\n\t\t\t\tif (v_gl_yn == \"Y\") {\n\t\t\t\tif (v_slmt_ind == \"C\" || (v_slmt_ind == \"X\" && adm_rec_flag == \"2\"))\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].gl_holder_name.value = \"\";\n//\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.value = \"\";\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = \"\";\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].gl_holder_name.disabled=true;\n\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.disabled=true;\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=true;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].glrelbut.disabled=true;\t\t\n\t\t\t\t\tif(calling_module_id != \'MP\')\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glbut.disabled=true;\t\t\t\n\t\t\t\t\tif(!(module_id== \"MP\" && operation== \"Update\" && booleanSecurity== \"true\"&& SiteSpecific== \"Y\")){\n\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.disabled=false;\n\t\t\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Starts */\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = false;\n\t\t\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled = false;\n\t\t\t\t\t/* Added V180914-Aravindh/GDOH-SCF-0292/Enabling Relationship/Ends */\n\t\t\t\t\t}\n\t\t\t\t\tif (parent.frames[0].document.forms[0].resp_for_payment.value == null ||\n\t\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.value == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.value=v_respay;\n\t\t\t\t\t}\n\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=false;\n\t\t\t\t\tif (parent.frames[0].document.forms[0].pat_reln_with_resp_person.value == null ||\n\t\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.value == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.value=v_respay_rel;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[0].document.forms[0].resp_for_payment.value == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled = true;\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(billing_group!=\'\')\n\t\t\t\t{   \n\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.value = \"\";\n\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.disabled=true;\t\t\t\n\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.value = \"\";\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=true;\t\t\t\n\t\t\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled=true;\t\t\t\n\n\t\t\t\t\tparent.frames[0].document.forms[0].gl_holder_name.disabled=false;\n\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.disabled=false;\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=false;\n\t\t\t\t\tif(parent.frames[0].document.forms[0].gl_holder_name.value != \"\")\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glrelbut.disabled=false;\t\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glrelbut.disabled=true;\t\n\t\t\t\t\tif(calling_module_id != \'MP\')\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glbut.disabled=false;\t\n\t\t\t\t\t\n\t\t\t\t\t/*\n\t\t\t\t\tif ( parent.frames[0].document.forms[0].gl_holder_name.value == null ||\n\t\t\t\t\t\tparent.frames[0].document.forms[0].gl_holder_name.value == \"\" )\n\t\t\t\t\t{\n\t\t\t\t\t\t//parent.frames[0].document.forms[0].gl_holder_name.value = v_gl_holder_name;\n\t\t\t\t\t}\n\t\t\t\t\t*/\n\n\t\t\t\t\t//parent.frames[0].document.forms[0].gl_holder_name.value = \"\";\t\t\n\t\t\t\t\t//parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = \"\";\n\n\t\t\t\t\tif ( parent.frames[0].document.forms[0].no_of_dependants.value == null ||\n\t\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.value == \"\" )\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.value = v_no_of_dependants;\n\t\t\t\t\t}\n\t\t\t\t\t/*\t\t\t\t\t\n\t\t\t\t\tif ( parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value == null ||\n\t\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_gl_holder.value == \"\" )\n\t\t\t\t\t{\n\t\t\t\t\t\t//parent.frames[0].document.forms[0].pat_reln_with_gl_holder.value = pat_reln_with_gl_holder;\n\t\t\t\t\t}\n\t\t\t\t\t*/\n\n\t\t\t\t}\n\t\t\t\telse if(billing_group == \'\')\n\t\t\t\t\t{\n\n\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.value = \"\";\n\t\t\t\t\tparent.frames[0].document.forms[0].resp_for_payment.disabled=true;\t\n\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.value = \"\";\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_resp_person.disabled=true;\t\n\t\t\t\t\tparent.frames[0].document.forms[0].patrelbut.disabled=true;\t\t\t\n\n\t\t\t\t\tparent.frames[0].document.forms[0].gl_holder_name.disabled=false;\n\t\t\t\t\tparent.frames[0].document.forms[0].no_of_dependants.disabled=false;\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_reln_with_gl_holder.disabled=false;\n\t\t\t\t\tif(parent.frames[0].document.forms[0].gl_holder_name.value != \"\")\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glrelbut.disabled=false;\t\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glrelbut.disabled=true;\t\n\t\t\t\t\tif(calling_module_id != \'MP\')\n\t\t\t\t\t\tparent.frames[0].document.forms[0].glbut.disabled=false;\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t\t\n\t\t\t\tif(document.forms[0].cald_frm.value == \"change_bg\"){\n\t\t\t\t\tparent.frames[0].callSettlements(document.forms[0].billing_group);\n\t\t\t\t}\n\t\t\t\telse{\t\n\t\t\t\t\tif(customer_id==\'GP\'){\n\t\t\t\t\tslmtIndCheck(v_slmt_ind);\n\t\t\t\t\t}\n\t\t\t\t\treturn 1;\n\t\t\t\t}\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(customer_id==\'GP\'){\n\t\t\t\tslmtIndCheck(v_slmt_ind);\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t \n\t</script>\t\n\t<!--\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t\t-->\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n<!--\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t\t\n\t</head>\n\n\t<body onLoad=\'glholdercheck();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\t<form name=\'GlHolderCheckForm\' id=\'GlHolderCheckForm\' method=\'post\' action=\'\'>\t\t\n\n\t\t<input type=\"hidden\" name=\"gl_holder_name\" id=\"gl_holder_name\"  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> </input>\n\t\t<input type=\"hidden\" name=\"no_of_dependants\" id=\"no_of_dependants\"  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> </input>\n\t\t<input type=\"hidden\" name=\"gl_rel\" id=\"gl_rel\"  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></input>\n\t\t<input type=\"hidden\" name=\"resp_pay\" id=\"resp_pay\"  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></input>\n\t\t<input type=\"hidden\" name=\"resp_pay_rel\" id=\"resp_pay_rel\"  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></input>\n\t\t<input type=\"hidden\" name=\"settlement_ind\" id=\"settlement_ind\"  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></input>\n\t\t<input type=\"hidden\" name=\"adm_rec_flag\" id=\"adm_rec_flag\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></input>\n\t\t<input type=\"hidden\" name=\"credit_doc_ref_reqd_yn\" id=\"credit_doc_ref_reqd_yn\"  value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\t\t\n\t\t<input type=\"hidden\" name=\"billing_group\" id=\"billing_group\"  value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></input>\n\t\t<input type=\"hidden\" name=\"calling_module_id\" id=\"calling_module_id\"  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></input>\n\t\t<input type=\"hidden\" name=\"customer_id\" id=\"customer_id\"  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></input>\n\t\t\n\t\t<input type=\"hidden\" name=\"cald_frm\" id=\"cald_frm\"  value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></input>\t\n\t</form>\n\t</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);


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


	
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(gl_holder_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gl_rel));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resp_pay));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(resp_pay_rel));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(settlement_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(adm_rec_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(credit_doc_ref_reqd_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cald_frm));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
