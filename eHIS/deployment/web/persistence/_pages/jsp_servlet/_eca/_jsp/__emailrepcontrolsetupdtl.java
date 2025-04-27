package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __emailrepcontrolsetupdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EmailRepControlSetupDtl.jsp", 1736157588901L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/EmailRepControlSetup.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onload=\'FocusFirstElement();\' onKeyDown=\"lockKey()\">\n<form name=\"EmailRepControlSetupDtlForm\" id=\"EmailRepControlSetupDtlForm\" action=\"../../servlet/eCA.EmailRepControlSetupServlet\" method=\"post\" target=\"messageFrame\">\n<table border=0 cellspacing=0 cellpadding=3 width=\'95%\' align=\'center\'>\n<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td><td class=\"fields\" colspan=\'3\'><input type=\"text\" name=\"subject_text\" id=\"subject_text\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" size=100 maxlength=100  onBlur=\"return makeValidString(this)\"></td>\n</tr>\n\n<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td><td class=\"fields\" >\n<select name=\'disclimer_id\' id=\'disclimer_id\' onchange=\"document.getElementById(\"discView\").style.display=\'inline\'\"><option value=\"\">-----";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="-------</option>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</select>&nbsp;\n\t<a href=\'javascript:disclaimerText()\' ID=\'discView\' style=\'display\' class=\"gridLink\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n</td>\n\n<td class=\'label\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n<td class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\"very_reqd_conf_result_yn\" id=\"very_reqd_conf_result_yn\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" checked ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onchange=\"chkObj(this)\"></td>\n\n</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<tr><td colspan=\'4\'>&nbsp;</td></tr>\n<tr>\n<td class=\'label\' >URL</td><td class=\"fields\" colspan=\'3\'><input type=\"text\" name=\"url_text\" id=\"url_text\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=100 maxlength=100 onKeyPress=\'return CheckForSpeChar(event);\'>&nbsp;<!-- <input type=\"button\" value=\"?\">&nbsp; --><img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</table>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<table border=0 cellspacing=0 cellpadding=3 width=\'95%\' align=\'center\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n\n<th colspan=2> &nbsp;</th>\n<th align=\'left\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n<th align=\'left\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n\n<tr>\n<td class=\'label\' colspan=\'2\' width=\'35%\' nowrap >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n<td class=\'fields\' width=\'16%\' nowrap><input type=\"checkbox\" name=\"email_to_pat_id_yn\" id=\"email_to_pat_id_yn\" id=\'AP\'\nvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onchange=\"chkObj(this)\" onClick=\'checkdefault(this)\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="></td>\n<td class=\'fields\' nowrap><select name=\'pat_body_text_ref\' id=\'pat_body_text_ref\' id=\'APD1\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onchange=\'\' onClick=\'Assigndefault(this)\'><option value=\"\">-----";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="-------</option>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</select></td>\n<td class=\'fields\'  nowrap><input type=\"checkbox\" name=\"very_reqd_pat_yn\" id=\"very_reqd_pat_yn\" id=\'APD\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onchange=\"chkObj(this)\" onClick=\'Assigndefault(this)\'></td>\n</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<input type=\'hidden\' name=\'email_to_pat_id_yn\' id=\'email_to_pat_id_yn\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t<tr><td colspan=\'5\'>&nbsp;</td></tr>\n\n\t<tr>\n\t<td class=\'label\' colspan=\'2\' width=\'35%\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t<!-- Bru-HIMS-CRF-024 Start.[IN030465] -->\n\t<!-- <td class=\'fields\' width=\'16%\' style=\"valign:middle;\" nowrap><input type=\"checkbox\" name=\"email_to_regd_id_yn\" id=\"email_to_regd_id_yn\" id=\'AR\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="></td> -->\n\t<td class=\'fields\' width=\'16%\' style=\"valign:middle;\" nowrap><input type=\"checkbox\" name=\"email_to_regd_id_yn\" id=\"email_to_regd_id_yn\" id=\'AR\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">&nbsp;&nbsp;\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<A id=\"ATRNF\" href=\"javascript:getRecipientsId();\" style=\"mouseover:hand;\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" style=\"display:none;\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="><U>Email Recipients</U></A>&nbsp;<img id=\"ATRNF1\"  src=\'../../eCommon/images/mandatory.gif\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" /> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t<!-- Bru-HIMS-CRF-024 End.[IN030465] -->\n\t<td class=\'fields\' nowrap><select name=\'regd_id_body_text_ref\' id=\'regd_id_body_text_ref\' id=\'ARD1\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onchange=\'\'><option value=\"\">-----";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</select></td>\n\t<td class=\'fields\' nowrap><input type=\"checkbox\" name=\"very_reqd_regd_id_yn\" id=\"very_reqd_regd_id_yn\" id=\'ARD\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" onchange=\"chkObj(this)\" onClick=\'Assigndefault(this)\'></td>\n\t</tr>\n\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t<input type=\'hidden\' name=\'email_to_regd_id_yn\' id=\'email_to_regd_id_yn\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n\n<tr>\n<td class=\'label\' colspan=\'2\' width=\'35%\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n<td class=\'fields\' width=\'16%\' nowrap><input type=\"checkbox\" name=\"email_to_any_id_yn\" id=\"email_to_any_id_yn\" id=\'AE\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\n<td class=\'fields\' nowrap><select name=\'any_id_body_text_ref\' id=\'any_id_body_text_ref\' id=\'AED1\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</select></td>\n<td class=\'fields\' nowrap><input type=\"checkbox\" name=\"very_reqd_any_id_yn\" id=\"very_reqd_any_id_yn\" id=\'AED\' ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<input type=\'hidden\' name=\'email_to_any_id_yn\' id=\'email_to_any_id_yn\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</table>\n<table border=0 cellspacing=0 cellpadding=3 width=\'95%\' align=\'center\'>\n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n\n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n</table>\n\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'report_id\' id=\'report_id\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\'hidden\' name=\'email_to_pat_id_yn1\' id=\'email_to_pat_id_yn1\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type=\'hidden\' name=\'email_to_regd_id_yn1\' id=\'email_to_regd_id_yn1\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\'email_to_any_id_yn1\' id=\'email_to_any_id_yn1\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=\'recipients_id\' id=\'recipients_id\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'> <!-- Bru-HIMS-CRF-024 [IN030465] -->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
 
public String populateBodyText(Connection con,String module_id,String report_id,String default_populate) throws Exception{
	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	StringBuffer list=new StringBuffer();
	String body_text_ref="";
	String body_text_desc="";
	try {									
		stmt = con.prepareStatement("select distinct body_text_ref,body_text_desc body_text_desc from  SM_REPORT_MAIL_body  where module_id=? and report_id=? order by body_text_desc");
		stmt.setString(1,module_id);
		stmt.setString(2,report_id);
		rs = stmt.executeQuery();
		while( rs != null &&  rs.next())
		{
		   body_text_ref = rs.getString( "body_text_ref" ) ;
		   body_text_desc = rs.getString( "body_text_desc" ) ;
		   if(default_populate.equalsIgnoreCase(body_text_ref))
			{
				list.append("<option value='"+body_text_ref+"' selected>"+body_text_desc+"</option>");	
			}
			else
			{
				list.append("<option value='"+body_text_ref+"'>"+body_text_desc+"</option>");
			}
		}
		if( rs != null )  rs.close();
		if( stmt != null )  stmt.close();
									
	} catch(Exception e) {
		
		e.printStackTrace();
	}
	return list.toString();

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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
---------------------------------------------------------------------------------------------------------------
 */

            _bw.write(_wl_block1Bytes, _wl_block1);
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

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String mode="insert";
	String sql_disclimer_code="";
	String sql_disclimer_desc="";
	String sql="";
	String subject_text="";
	String disclimer_id="";
	String email_to_pat_id_yn="N";
	String pat_body_text_ref="";
	String very_reqd_pat_yn="N";
	String email_to_regd_id_yn="N";
	String regd_id_body_text_ref="";
	String very_reqd_regd_id_yn="N";
	String email_to_any_id_yn="N";
	String any_id_body_text_ref="";
	String very_reqd_any_id_yn="N";
	String very_reqd_conf_result_yn="N";
	String dispEmailAppRule="";

	String sys_appl_to_pat_id_yn="N";
	String sys_appl_to_regd_id_yn="N";
	String sys_appl_to_any_id_yn="N";
	String sys_appl_to_url_yn="N"; //Bru-HIMS-CRF-024 [IN030465]
	
	String very_reqd_pat_yn_enabled = "disabled";
	String pat_body_text_ref_enabled = "disabled";
	String very_reqd_regd_id_yn_enabled = "disabled";
	String regd_id_body_text_ref_enabled = "disabled";
	String very_reqd_any_id_yn_enabled = "disabled";
	String any_id_body_text_ref_enabled = "disabled";
	String email_to_pat_id_checked = "";
	String email_to_regd_id_checked = "";
	String email_to_any_id_yn_checked = "";
	
	String module_id=request.getParameter("module_id")==null?"":((String)request.getParameter("module_id"));
	String report_id=request.getParameter("report_id")==null?"":((String)request.getParameter("report_id"));
	String bodyTextVals_pat_text="";
	String bodyTextVals_reqd_regd="";
	String bodyTextVals_any_id="";
	String recipients_id =""; //Bru-HIMS-CRF-024 [IN030465]
	String url_text="";//Bru-HIMS-CRF-024 [IN030465]
	if(!module_id.equals("") && !report_id.equals("")){
	try
	{
		
		con =	ConnectionManager.getConnection(request);
		
		//sql ="select subject_text,disclimer_id,email_to_pat_id_yn,pat_body_text_ref,very_reqd_pat_yn,email_to_regd_id_yn,regd_id_body_text_ref,very_reqd_regd_id_yn,email_to_any_id_yn,any_id_body_text_ref,very_reqd_any_id_yn,very_reqd_conf_result_yn,sys_appl_to_pat_id_yn,sys_appl_to_regd_id_yn,sys_appl_to_any_id_yn from SM_REPORT_MAIL_INFO where module_id=? and report_id=?"; //Bru-HIMS-CRF-024 [IN030465]
		sql ="select subject_text,disclimer_id,email_to_pat_id_yn,pat_body_text_ref,very_reqd_pat_yn,email_to_regd_id_yn,regd_id_body_text_ref,very_reqd_regd_id_yn,email_to_any_id_yn,any_id_body_text_ref,very_reqd_any_id_yn,very_reqd_conf_result_yn,sys_appl_to_pat_id_yn,sys_appl_to_regd_id_yn,sys_appl_to_any_id_yn,recipients_id,url_text from SM_REPORT_MAIL_INFO where module_id=? and report_id=?"; //Bru-HIMS-CRF-024 [IN030465]
		stmt=con.prepareStatement(sql);
		stmt.setString(1,module_id);
		stmt.setString(2,report_id);
		rs = stmt.executeQuery();			 
		if(rs.next()){
			mode="update";
			subject_text=rs.getString("subject_text")==null?"N":rs.getString("subject_text");
			disclimer_id=rs.getString("disclimer_id")==null?"N":rs.getString("disclimer_id");
			email_to_pat_id_yn=rs.getString("email_to_pat_id_yn")==null?"N":rs.getString("email_to_pat_id_yn");
			pat_body_text_ref=rs.getString("pat_body_text_ref")==null?"":rs.getString("pat_body_text_ref");
			very_reqd_pat_yn=rs.getString("very_reqd_pat_yn")==null?"N":rs.getString("very_reqd_pat_yn");
			email_to_regd_id_yn=rs.getString("email_to_regd_id_yn")==null?"N":rs.getString("email_to_regd_id_yn");
			regd_id_body_text_ref=rs.getString("regd_id_body_text_ref")==null?"":rs.getString("regd_id_body_text_ref");
			very_reqd_regd_id_yn=rs.getString("very_reqd_regd_id_yn")==null?"N":rs.getString("very_reqd_regd_id_yn");
			email_to_any_id_yn=rs.getString("email_to_any_id_yn")==null?"N":rs.getString("email_to_any_id_yn");
			any_id_body_text_ref=rs.getString("any_id_body_text_ref")==null?"":rs.getString("any_id_body_text_ref");
			very_reqd_any_id_yn=rs.getString("very_reqd_any_id_yn")==null?"N":rs.getString("very_reqd_any_id_yn");
			very_reqd_conf_result_yn=rs.getString("very_reqd_conf_result_yn")==null?"N":rs.getString("very_reqd_conf_result_yn");
			sys_appl_to_pat_id_yn=rs.getString("sys_appl_to_pat_id_yn")==null?"N":rs.getString("sys_appl_to_pat_id_yn");
			sys_appl_to_regd_id_yn=rs.getString("sys_appl_to_regd_id_yn")==null?"N":rs.getString("sys_appl_to_regd_id_yn");
			sys_appl_to_any_id_yn=rs.getString("sys_appl_to_any_id_yn")==null?"N":rs.getString("sys_appl_to_any_id_yn");
			recipients_id = rs.getString("recipients_id")==null?"":(String)rs.getString("recipients_id"); //Bru-HIMS-CRF-024 [IN030465]
			url_text  = rs.getString("url_text")==null?"":(String)rs.getString("url_text"); //Bru-HIMS-CRF-024 [IN030465]
			if(email_to_pat_id_yn.equals("Y"))
				{
				 email_to_pat_id_checked="checked";
				 very_reqd_pat_yn_enabled="";
				 pat_body_text_ref_enabled="";
				}
			else
				email_to_pat_id_checked="";
			    //pat_body_text_ref="";

			if(email_to_regd_id_yn.equals("Y"))
				{
				 email_to_regd_id_checked="checked";
				 very_reqd_regd_id_yn_enabled="";
				 regd_id_body_text_ref_enabled="";
				}
			else
				email_to_regd_id_checked="";
			    //regd_id_body_text_ref="";

			if(email_to_any_id_yn.equals("Y"))
				{
				 email_to_any_id_yn_checked="checked";
				 very_reqd_any_id_yn_enabled="";
				 any_id_body_text_ref_enabled="";
				}
			else
				email_to_any_id_yn_checked="";
			    //any_id_body_text_ref="";
		}else{
			mode="insert";
			if(email_to_pat_id_yn.equals("Y"))
				{
				 email_to_pat_id_checked="checked";
				 very_reqd_pat_yn_enabled="";
				 pat_body_text_ref_enabled="";
				}
			else
				email_to_pat_id_checked="";
			    //pat_body_text_ref="";

			if(email_to_regd_id_yn.equals("Y"))
				{
				 email_to_regd_id_checked="checked";
				 very_reqd_regd_id_yn_enabled="";
				 regd_id_body_text_ref_enabled="";
				}
			else
		    	email_to_regd_id_checked="";
			    //regd_id_body_text_ref="";

			if(email_to_any_id_yn.equals("Y"))
				{
				 email_to_any_id_yn_checked="checked";
				 very_reqd_any_id_yn_enabled="";
				 any_id_body_text_ref_enabled="";
				}
			else
				email_to_any_id_yn_checked="";
			   //any_id_body_text_ref="";
		}
		//Bru-HIMS-CRF-024 Start.[IN030465]
		//IN044085 Start.
		//if(module_id.equals("CA") && report_id.equals("CANFREP")){
		if(module_id.equals("CA") && !report_id.equals("AHCLINREP")){
		//IN044085 End.
			sys_appl_to_pat_id_yn="N";
			sys_appl_to_any_id_yn="N";
			sys_appl_to_url_yn ="Y";
		}
		//Bru-HIMS-CRF-024 End.[IN030465]
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();	
		bodyTextVals_pat_text=populateBodyText(con,module_id,report_id,pat_body_text_ref);
		bodyTextVals_reqd_regd=populateBodyText(con,module_id,report_id,regd_id_body_text_ref);
		bodyTextVals_any_id=populateBodyText(con,module_id,report_id,any_id_body_text_ref);
		
	}catch(Exception e)
	{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
	}finally { 
	ConnectionManager.returnConnection(con,request);
	}

}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(subject_text));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

try {
								
	con = ConnectionManager.getConnection(request);
	sql="select distinct disclimer_code,disclimer_desc from  ca_disclimer_text  where eff_status='E' and applicable_to_rep_yn ='Y' order by disclimer_desc";
	stmt = con.prepareStatement(sql);
	rs = stmt.executeQuery();
	while( rs != null &&  rs.next())
	{
		sql_disclimer_code = rs.getString( "disclimer_code" ) ;
		sql_disclimer_desc = rs.getString( "disclimer_desc" ) ;
		if(disclimer_id.equals(sql_disclimer_code)){
			out.println("<option selected value='"+sql_disclimer_code+"'>"+sql_disclimer_desc+"</option>");
		}else{
			out.println("<option value='"+sql_disclimer_code+"'>"+sql_disclimer_desc+"</option>");
		}
		
	}
	if( rs != null )  rs.close();
	if( stmt != null )  stmt.close();
								
} catch(Exception e) {
	
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(very_reqd_conf_result_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(very_reqd_conf_result_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);

if(sys_appl_to_url_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(url_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

if(sys_appl_to_pat_id_yn.equals("N") && sys_appl_to_regd_id_yn.equals("N") && sys_appl_to_any_id_yn.equals("N")){
dispEmailAppRule="style='display:none;'";
}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dispEmailAppRule));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(sys_appl_to_pat_id_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(email_to_pat_id_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(email_to_pat_id_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pat_body_text_ref_enabled));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bodyTextVals_pat_text));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(very_reqd_pat_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(very_reqd_pat_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(very_reqd_pat_yn_enabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(email_to_pat_id_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);

}
if(sys_appl_to_regd_id_yn.equals("Y")){
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(email_to_regd_id_checked));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(email_to_regd_id_checked));
            _bw.write(_wl_block41Bytes, _wl_block41);

	//IN044085 Start
	//if(module_id.equals("CA") && report_id.equals("CANFREP")){
	if(module_id.equals("CA") && !report_id.equals("AHCLINREP")){
	//IN044085 End.
	
            _bw.write(_wl_block42Bytes, _wl_block42);
if(email_to_regd_id_checked.equals("")){
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(email_to_regd_id_checked.equals("")){
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(regd_id_body_text_ref_enabled));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bodyTextVals_reqd_regd));
            _bw.write(_wl_block48Bytes, _wl_block48);
if(very_reqd_regd_id_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(very_reqd_regd_id_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(very_reqd_regd_id_yn_enabled));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{ 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);

}
if(sys_appl_to_any_id_yn.equals("Y")){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(email_to_any_id_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(email_to_any_id_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(email_to_any_id_yn_checked));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(any_id_body_text_ref_enabled));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bodyTextVals_any_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(very_reqd_any_id_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(very_reqd_any_id_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(very_reqd_any_id_yn_enabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(email_to_any_id_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(email_to_pat_id_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(email_to_any_id_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recipients_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Subject.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Disclaimer.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VerificationRequiredForConfidentialResult.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EmailIdControl.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BodyText.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VerificationRequired.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ApplicabletoPatient.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ApplicableToRegisteredUsers.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ApplicableToAdhocEmailID.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
