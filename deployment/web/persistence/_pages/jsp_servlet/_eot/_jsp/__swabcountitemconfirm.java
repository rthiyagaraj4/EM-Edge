package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __swabcountitemconfirm extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabCountItemConfirm.jsp", 1709120394000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t\t<script src=\'../../eOT/js/SwabCount.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t</head>\n\t<body  onKeyDown=\"lockKey()\" onLoad=\"reviewedby()\">\n\t\t<form name=\"SwabCountItemConfirmForm\" id=\"SwabCountItemConfirmForm\" >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<table border=\'0\' cellpadding=\"3\"  cellspacing=\'0\' align=\'center\'  width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" name=\"first_cnt_cmpl_yn\" id=\"first_cnt_cmpl_yn\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" onClick=\"assignCheckboxValue(this)\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" name=\"add_during_op_cmpl_yn\" id=\"add_during_op_cmpl_yn\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onClick=\"assignCheckboxValue(this)\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" id=\"second_cnt_cmpl_yn\" name=\"second_cnt_cmpl_yn\" id=\"second_cnt_cmpl_yn\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" onClick=\"assignCheckboxValue(this);control(1,this);\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" id=\"add_aft_clcav_cmpl_yn\" name=\"add_aft_clcav_cmpl_yn\" id=\"add_aft_clcav_cmpl_yn\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onClick=\"assignCheckboxValue(this);control(2,this);\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"label\">\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<A NAME=\"scrollHere\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t</A>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" id=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" name=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" onClick=\"assignCheckboxValue(this);control(3,this);\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\"label\"> \n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t</A>\n\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onClick=\"assignCheckboxValue(this);control(4,this);\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"25%\" class=\"label\"> \n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<A NAME=\"scrollHere\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t</A>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t</td>\n<!--  Added Start Against PMG2017-MO-CRF-0001 [IN:063849]  -->\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<!-- Added End Against PMG2017-MO-CRF-0001 [IN:063849] -->\t\t \n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\" >\n\t\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" id=\"final_cnt_cmpl_yn\" name=\"final_cnt_cmpl_yn\" id=\"final_cnt_cmpl_yn\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" onClick=\"assignCheckboxValue(this);reviwedbyCheckBoxvalue(this);control(9,this);\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"25%\" align=\"top\" class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t\t<select name=\"reviewed_by\" id=\"reviewed_by\">\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<option value = \"\" selected>-----Select----</option>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" > ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </option>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" selected> ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t<input type=\"hidden\" name=\"cnt\" id=\"cnt\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<img id=\"img1\" src=\'../../eCommon/images/Blank1.gif\' ></td>\n\t\t\t<!-- Added Against below PMG2017-MO-CRF-0001 [IN:063849] -->\n\t\t\t<input type=\'hidden\' name=\'second_cnt_disabled\' id=\'second_cnt_disabled\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type=\'hidden\' name=\'second_cnt_checked\' id=\'second_cnt_checked\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type=\'hidden\' name=\'after_cavity_checked\' id=\'after_cavity_checked\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type=\'hidden\' name=\'after_cavity_disabled\' id=\'after_cavity_disabled\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=\'hidden\' name=\'final_cnt_disabled\' id=\'final_cnt_disabled\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type=\'hidden\' name=\'final_cnt_checked\' id=\'final_cnt_checked\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type=\'hidden\' name=\'third_cnt_cmpl_yn_chked\' id=\'third_cnt_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=\'hidden\' name=\'third_cnt_cmpl_yn_disabled\' id=\'third_cnt_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_3c_cmpl_yn_chked\' id=\'additions_after_3c_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_3c_cmpl_yn_disabled\' id=\'additions_after_3c_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t<input type=\'hidden\' name=\'fourth_cnt_cmpl_yn_chked\' id=\'fourth_cnt_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\'hidden\' name=\'fourth_cnt_cmpl_yn_disabled\' id=\'fourth_cnt_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_4c_cmpl_yn_chked\' id=\'additions_after_4c_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_4c_cmpl_yn_disabled\' id=\'additions_after_4c_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\'hidden\' name=\'fifth_cnt_cmpl_yn_chked\' id=\'fifth_cnt_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\'hidden\' name=\'fifth_cnt_cmpl_yn_disabled\' id=\'fifth_cnt_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_5c_cmpl_yn_chked\' id=\'additions_after_5c_cmpl_yn_chked\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\'hidden\' name=\'additions_after_5c_cmpl_yn_disabled\' id=\'additions_after_5c_cmpl_yn_disabled\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
		NOTE: Currently First Count is Not Used. The Initial Count is renamed as First Count and the First_Count is being removed completely. But at Database level, it is not changed. 
		First_Count(earlier known as Initial_Count) at frontend --> is Initial_Count at database level
	*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			Connection connection = null;
			PreparedStatement pstmt=null;
			ResultSet resultset =null;
			String add_during_op_cmpl_yn = "N";
			String first_cnt_cmpl_yn = "N";
			String second_cnt_cmpl_yn = "N";
			String add_aft_clcav_cmpl_yn = "N";
			String final_cnt_cmpl_yn = "N";
			String first_cnt_checked = "";
			String first_cnt_disabled = "";
			String qry_mode = "";
			String initial_disabled_surg = "";
			String second_cnt_checked = "";
			String second_cnt_disabled = "";
			String after_cavity_checked = "";
			String after_cavity_disabled	= "";
			String final_cnt_checked	= "";
			String final_cnt_disabled	= "";
			String during_op_checked	= "";
			String during_op_disabled	= "";
			String oper_num = "";
			String facility_id	= "";
			String swab_serial_number	= "";
			StringBuffer orderTypeQryBuffer = new StringBuffer();
			int allwdSwabCntsVal = 0;
			LinkedHashMap labelNameMap = new LinkedHashMap();
			LinkedHashMap dataMap = new LinkedHashMap();
			String[] getLabelNameMapKeyVal;
			String[] getDataMapKeyVal;

			String third_cnt_cmpl_yn = "N";
			String third_cnt_cmpl_yn_chked = "";
			String third_cnt_cmpl_yn_disabled = "";
			String additions_after_3c_cmpl_yn = "N";
			String additions_after_3c_cmpl_yn_chked = "";
			String additions_after_3c_cmpl_yn_disabled = "";

			String fourth_cnt_cmpl_yn = "N";
			String fourth_cnt_cmpl_yn_chked = "";
			String fourth_cnt_cmpl_yn_disabled = "";
			String additions_after_4c_cmpl_yn = "N";
			String additions_after_4c_cmpl_yn_chked = "";
			String additions_after_4c_cmpl_yn_disabled = "";

			String fifth_cnt_cmpl_yn = "N";
			String fifth_cnt_cmpl_yn_chked = "";
			String fifth_cnt_cmpl_yn_disabled = "";
			String additions_after_5c_cmpl_yn = "N";
			String additions_after_5c_cmpl_yn_chked = "";
			String additions_after_5c_cmpl_yn_disabled = "";

			String reviewed_by = "";
			String reviewed_by_name = "";
			
			String valForFinalChkBox = "";
			int j = 0;
			//Added below against PMG2017-MO-CRF-0001 [IN:063849]
			String swabcount = ""; 
			int swab_count = 0;
			int count= 0;
			
			try
			{
				facility_id	= (String) session.getValue("facility_id");
				connection = ConnectionManager.getConnection(request);
				/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
				String str_qry = "select NO_OF_SWAB_COUNT_REQD from ot_param_for_facility where operating_facility_id = '"+facility_id+"'";
				pstmt=connection.prepareStatement(str_qry);
				resultset = pstmt.executeQuery();
				if(resultset!= null && resultset.next())
				{
					swabcount = resultset.getString(1);
				}
				if(pstmt != null) pstmt.close();
				if(resultset!=null) resultset.close();
				/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
				labelNameMap.put(2, "eOT.SecondCountComp.Label~second_cnt_cmpl_yn~eOT.AddtSecondCountComp.Label~add_aft_clcav_cmpl_yn");
				labelNameMap.put(3, "eOT.ThirdCountComp.Label~third_cnt_cmpl_yn~eOT.AddtThirdCountComp.Label~addt_third_cnt_cmpl_yn");
				labelNameMap.put(4, "eOT.FourthCountComp.Label~fourth_cnt_cmpl_yn~eOT.AddtFourthCountComp.Label~addt_fourth_cnt_cmpl_yn");
				labelNameMap.put(5, "eOT.FifthCountComp.Label~fifth_cnt_cmpl_yn~eOT.AddtFifthCountComp.Label~addt_fifth_cnt_cmpl_yn");
				oper_num = checkForNull(request.getParameter("oper_num"));
				allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
				swab_count = Integer.parseInt(swabcount); // Added for PMG2017-MO-CRF-0001 [IN:063849]
				//System.err.println("98,=======swab_count=====SwabCountItemConfirm.jsp====="+swab_count);
				swab_serial_number = checkForNull(request.getParameter("swab_serial_number")) == "" ? "1" : checkForNull(request.getParameter("swab_serial_number"));
				if(allwdSwabCntsVal == 0)
					allwdSwabCntsVal = 3;
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();

				first_cnt_cmpl_yn = checkForNull(request.getParameter("first_cnt_cmpl_yn"));
				add_during_op_cmpl_yn = checkForNull(request.getParameter("add_during_op_cmpl_yn"));
				
				second_cnt_cmpl_yn = checkForNull(request.getParameter("second_cnt_cmpl_yn"));
				add_aft_clcav_cmpl_yn = checkForNull(request.getParameter("add_aft_clcav_cmpl_yn"));

				third_cnt_cmpl_yn = checkForNull(request.getParameter("third_cnt_cmpl_yn"));
				additions_after_3c_cmpl_yn = checkForNull(request.getParameter("additions_after_3c_cmpl_yn"));

				fourth_cnt_cmpl_yn = checkForNull(request.getParameter("fourth_cnt_cmpl_yn"));
				additions_after_4c_cmpl_yn = checkForNull(request.getParameter("additions_after_4c_cmpl_yn"));

				fifth_cnt_cmpl_yn = checkForNull(request.getParameter("fifth_cnt_cmpl_yn"));
				additions_after_5c_cmpl_yn = checkForNull(request.getParameter("additions_after_5c_cmpl_yn"));

				final_cnt_cmpl_yn = checkForNull(request.getParameter("final_cnt_cmpl_yn"));
				reviewed_by = checkForNull(request.getParameter("reviewedBy"));
				reviewed_by_name = checkForNull(request.getParameter("practitionerName"));
			
			/* Added Start Against PMG2017-MO-CRF-0001 [IN:063849] */
				
				if(first_cnt_cmpl_yn.equals("Y") && add_during_op_cmpl_yn.equals("Y"))
				{
					count++;
					//System.err.println("====1st===count============"+count);
				}if(second_cnt_cmpl_yn.equals("Y") && add_aft_clcav_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==2nd=====count============"+count);
				}
				if(third_cnt_cmpl_yn.equals("Y") && additions_after_3c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==3rd=====count============"+count);
				}
				if(fourth_cnt_cmpl_yn.equals("Y") && additions_after_4c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==4th=====count============"+count);
				}
				if(fifth_cnt_cmpl_yn.equals("Y") && additions_after_5c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("=5th======count============"+count);
				}
				//System.err.println("===final======count============"+count);
				/* Added End for PMG2017-MO-CRF-0001 [IN:063849] */
/* 				System.err.println("=======first_cnt_cmpl_yn============"+first_cnt_cmpl_yn);
				System.err.println("=======add_during_op_cmpl_yn============"+add_during_op_cmpl_yn);
				System.err.println("=======second_cnt_cmpl_yn============"+second_cnt_cmpl_yn);
				System.err.println("=======add_aft_clcav_cmpl_yn============"+add_aft_clcav_cmpl_yn);
				System.err.println("=======third_cnt_cmpl_yn============"+third_cnt_cmpl_yn);
				System.err.println("=======additions_after_3c_cmpl_yn============"+additions_after_3c_cmpl_yn);
				System.err.println("=======fourth_cnt_cmpl_yn============"+fourth_cnt_cmpl_yn);
				System.err.println("=======additions_after_4c_cmpl_yn============"+additions_after_4c_cmpl_yn);
				System.err.println("=======fifth_cnt_cmpl_yn============"+fifth_cnt_cmpl_yn);
				System.err.println("=======additions_after_5c_cmpl_yn============"+additions_after_5c_cmpl_yn); */
				//System.err.println("=======final_cnt_cmpl_yn============"+final_cnt_cmpl_yn);
			//	System.err.println("=======reviewed_by============"+reviewed_by);
			//	System.err.println("=======reviewed_by_name============"+reviewed_by_name);

				first_cnt_checked = first_cnt_cmpl_yn.equals("N") ? "" : "checked";
				first_cnt_disabled = first_cnt_cmpl_yn.equals("N") ? "" : "disabled";
				during_op_checked = add_during_op_cmpl_yn.equals("N") ? "" : "checked";
				during_op_disabled = first_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				if(add_during_op_cmpl_yn.equals("Y"))
				{
					during_op_checked = "checked";
					during_op_disabled = "disabled";
				}

				second_cnt_checked = second_cnt_cmpl_yn.equals("N") ? "" : "checked";
				second_cnt_disabled = add_during_op_cmpl_yn.equals("N") ? "disabled" : "";
				if(second_cnt_cmpl_yn.equals("Y"))
				{
					second_cnt_checked = "checked";
					second_cnt_disabled = "disabled";
				}
				after_cavity_checked = add_aft_clcav_cmpl_yn.equals("N") ? "" : "checked";
				after_cavity_disabled	= second_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				if(add_aft_clcav_cmpl_yn.equals("Y"))
				{
					after_cavity_checked = "checked";
					after_cavity_disabled = "disabled";
				}
				valForFinalChkBox = add_aft_clcav_cmpl_yn;
				dataMap.put(2, second_cnt_cmpl_yn + " ~ " + second_cnt_checked + " ~ " + second_cnt_disabled + " ~ " + add_aft_clcav_cmpl_yn + " ~ " + after_cavity_checked + " ~ " + after_cavity_disabled);

				if(allwdSwabCntsVal > 3)
				{
					third_cnt_cmpl_yn_chked = third_cnt_cmpl_yn.equals("N") ? "" : "checked";
					third_cnt_cmpl_yn_disabled	= add_aft_clcav_cmpl_yn.equals("N") ? "disabled" : "";
					if(third_cnt_cmpl_yn.equals("Y"))
					{
						third_cnt_cmpl_yn_chked = "checked";
						third_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_3c_cmpl_yn_chked = additions_after_3c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_3c_cmpl_yn_disabled	= third_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_3c_cmpl_yn.equals("Y"))
					{
						additions_after_3c_cmpl_yn_chked = "checked";
						additions_after_3c_cmpl_yn_disabled = "disabled";
					}
					if(final_cnt_cmpl_yn.equals("Y"))
					{	
						additions_after_3c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_3c_cmpl_yn;
					dataMap.put(3, third_cnt_cmpl_yn + " ~ " + third_cnt_cmpl_yn_chked + " ~ " + third_cnt_cmpl_yn_disabled + " ~ " + additions_after_3c_cmpl_yn + " ~ " + additions_after_3c_cmpl_yn_chked + " ~ " + additions_after_3c_cmpl_yn_disabled);
				}

				if(allwdSwabCntsVal > 4)
				{
					fourth_cnt_cmpl_yn_chked = fourth_cnt_cmpl_yn.equals("N") ? "" : "checked";
					fourth_cnt_cmpl_yn_disabled	= additions_after_3c_cmpl_yn.equals("N") ? "disabled" : "";
					if(fourth_cnt_cmpl_yn.equals("Y"))
					{
						fourth_cnt_cmpl_yn_chked = "checked";
						fourth_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_4c_cmpl_yn_chked = additions_after_4c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_4c_cmpl_yn_disabled	= fourth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_4c_cmpl_yn.equals("Y"))
					{
						additions_after_4c_cmpl_yn_chked = "checked";
						additions_after_4c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_4c_cmpl_yn;
					dataMap.put(4, fourth_cnt_cmpl_yn + " ~ " + fourth_cnt_cmpl_yn_chked + " ~ " + fourth_cnt_cmpl_yn_disabled + " ~ " + additions_after_4c_cmpl_yn + " ~ " + additions_after_4c_cmpl_yn_chked + " ~ " + additions_after_4c_cmpl_yn_disabled);
				}

				if(allwdSwabCntsVal > 5)
				{
					fifth_cnt_cmpl_yn_chked = fifth_cnt_cmpl_yn.equals("N") ? "" : "checked";
					fifth_cnt_cmpl_yn_disabled	= additions_after_4c_cmpl_yn.equals("N") ? "disabled" : "";
					if(fifth_cnt_cmpl_yn.equals("Y"))
					{
						fifth_cnt_cmpl_yn_chked = "checked";
						fifth_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_5c_cmpl_yn_chked = additions_after_5c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_5c_cmpl_yn_disabled	= fifth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_5c_cmpl_yn.equals("Y"))
					{
						additions_after_5c_cmpl_yn_chked = "checked";
						additions_after_5c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_5c_cmpl_yn;
					dataMap.put(5, fifth_cnt_cmpl_yn + " ~ " + fifth_cnt_cmpl_yn_chked + " ~ " + fifth_cnt_cmpl_yn_disabled + " ~ " + additions_after_5c_cmpl_yn + " ~ " + additions_after_5c_cmpl_yn_chked + " ~ " + additions_after_5c_cmpl_yn_disabled);
				}
				//System.err.println("275========valForFinalChkBox============"+valForFinalChkBox);
				final_cnt_checked = final_cnt_cmpl_yn.equals("N") ? "" : "checked";
				final_cnt_disabled = valForFinalChkBox.equals("N") ? "disabled" : "";
				if(final_cnt_cmpl_yn.equals("Y"))
				{
					final_cnt_checked="checked";
					final_cnt_disabled="disabled";
					//Added against start PMG2017-MO-CRF-0001 [IN:063849]
					first_cnt_cmpl_yn="disabled";
					during_op_disabled="disabled";
					second_cnt_disabled="disabled";
					after_cavity_disabled="disabled";
					third_cnt_cmpl_yn_disabled="disabled";
					additions_after_3c_cmpl_yn_disabled="disabled";
					fourth_cnt_cmpl_yn_disabled="disabled";
					additions_after_4c_cmpl_yn_disabled	="disabled";
					fifth_cnt_cmpl_yn_disabled="disabled";
					additions_after_5c_cmpl_yn_disabled="disabled";
					//Added against end PMG2017-MO-CRF-0001 [IN:063849]
				}

				qry_mode = checkForNull(request.getParameter("qry_mode"));
				if(qry_mode.equals("YES"))
					initial_disabled_surg = "disabled";
					

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(first_cnt_cmpl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(first_cnt_checked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(first_cnt_disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(add_during_op_cmpl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(during_op_checked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(during_op_disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block13Bytes, _wl_block13);

					if(allwdSwabCntsVal == 3)
					{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(second_cnt_cmpl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(second_cnt_checked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(second_cnt_disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(add_aft_clcav_cmpl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(after_cavity_checked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(after_cavity_disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block18Bytes, _wl_block18);

					}
					else if(allwdSwabCntsVal > 3)
					{
						for(int i=2; i<allwdSwabCntsVal; i++)
						{
							if(i < allwdSwabCntsVal - 1)
								j = i + 1;
							else
								j = 0;
							getLabelNameMapKeyVal = ((String) labelNameMap.get(i)).split("~");
							getDataMapKeyVal = ((String) dataMap.get(i)).split("~");

            _bw.write(_wl_block19Bytes, _wl_block19);

									if(qry_mode.trim().length() == 0 && j > 0 && ((String) dataMap.get(j)).split("~")[2].trim().length() == 0)
									{

            _bw.write(_wl_block20Bytes, _wl_block20);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
            int __result__tag4 = 0 ;

            if (__tag4 == null ){
                __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
            }
            __tag4.setPageContext(pageContext);
            __tag4.setParent(null);
            __tag4.setKey(getLabelNameMapKeyVal[0]
);
            __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag4;
            __result__tag4 = __tag4.doStartTag();

            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag4);
                return;
            }
            _activeTag=__tag4.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
            __tag4.release();
            _bw.write(_wl_block21Bytes, _wl_block21);

									}
									else
									{

            _bw.write(_wl_block22Bytes, _wl_block22);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setKey(getLabelNameMapKeyVal[0]
);
            __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block1Bytes, _wl_block1);

									}

            _bw.write(_wl_block23Bytes, _wl_block23);

									if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[2]="disabled";								
									}
								
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(getLabelNameMapKeyVal[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(getLabelNameMapKeyVal[1]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(getDataMapKeyVal[0]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(getDataMapKeyVal[1]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(getDataMapKeyVal[2]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block27Bytes, _wl_block27);

									if(qry_mode.trim().length() == 0 && j > 0 && ((String) dataMap.get(j)).split("~")[5].trim().length() == 0)
									{

            _bw.write(_wl_block20Bytes, _wl_block20);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
            int __result__tag6 = 0 ;

            if (__tag6 == null ){
                __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
            }
            __tag6.setPageContext(pageContext);
            __tag6.setParent(null);
            __tag6.setKey(getLabelNameMapKeyVal[2]
);
            __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag6;
            __result__tag6 = __tag6.doStartTag();

            if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag6);
                return;
            }
            _activeTag=__tag6.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
            __tag6.release();
            _bw.write(_wl_block28Bytes, _wl_block28);

									}
									else
									{

            _bw.write(_wl_block22Bytes, _wl_block22);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
            int __result__tag7 = 0 ;

            if (__tag7 == null ){
                __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
            }
            __tag7.setPageContext(pageContext);
            __tag7.setParent(null);
            __tag7.setKey(getLabelNameMapKeyVal[2]
);
            __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag7;
            __result__tag7 = __tag7.doStartTag();

            if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag7);
                return;
            }
            _activeTag=__tag7.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
            __tag7.release();
            _bw.write(_wl_block29Bytes, _wl_block29);

									}

            _bw.write(_wl_block1Bytes, _wl_block1);

								 	if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[5]="disabled";								
									}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(getLabelNameMapKeyVal[3]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(getLabelNameMapKeyVal[3]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(getDataMapKeyVal[3]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(getDataMapKeyVal[4]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(getDataMapKeyVal[5]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block30Bytes, _wl_block30);

						}
					}

            _bw.write(_wl_block31Bytes, _wl_block31);

							if(qry_mode.trim().length() == 0 && final_cnt_disabled.trim().length() == 0)
							{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

							}
							else
							{

            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

							}

            _bw.write(_wl_block35Bytes, _wl_block35);

		
		if(swab_count == 2 && count >= 1){
		
			final_cnt_disabled="";
		}
		else if(swab_count == 3 && count >= 2){
		
			final_cnt_disabled="";
		}
		else if(swab_count == 4 && count >= 3){
		
			final_cnt_disabled="";
		}else if(swab_count == 5 && count >= 4){
		
			final_cnt_disabled="";
		}else if(swab_count == 6 && count >= 5){
		
			final_cnt_disabled="";
		}
								
		if(final_cnt_cmpl_yn.equals("Y"))
		{
			second_cnt_disabled="disabled";
			third_cnt_cmpl_yn_disabled="disabled";
			final_cnt_checked="checked";
			final_cnt_disabled="disabled";
			additions_after_3c_cmpl_yn_disabled="disabled";
		}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(final_cnt_cmpl_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(final_cnt_checked));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(final_cnt_disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(initial_disabled_surg));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

								orderTypeQryBuffer.append("	SELECT a.practitioner_id, b.role_type, d.practitioner_name	");
								orderTypeQryBuffer.append("	FROM ot_post_oper_personnel a, ot_roles b, am_practitioner d	");
								orderTypeQryBuffer.append("	WHERE operating_facility_id = ?	");
								orderTypeQryBuffer.append("	AND oper_num = ?	");
								orderTypeQryBuffer.append("	AND a.role_id = b.role_id	");
								orderTypeQryBuffer.append("	AND a.practitioner_id = d.practitioner_id	");
								orderTypeQryBuffer.append("	AND a.practitioner_id = NVL (?, a.practitioner_id)	");
								orderTypeQryBuffer.append("	AND b.role_type = 'OS'	");
								if(resultset!=null) 
									resultset.close();
								if(pstmt!=null) 
									pstmt.close();
								int cnt = 0;
								pstmt = connection.prepareStatement(orderTypeQryBuffer.toString());
								pstmt.setString(1, facility_id);
								pstmt.setString(2, oper_num);
								pstmt.setString(3, reviewed_by);
								resultset = pstmt.executeQuery();				
								if(reviewed_by.equals(""))
								{

            _bw.write(_wl_block39Bytes, _wl_block39);

									while(resultset!=null && resultset.next())
									{
										cnt++;

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(resultset.getString(1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( resultset.getString(3)));
            _bw.write(_wl_block42Bytes, _wl_block42);

									}
								}
								else
								{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(reviewed_by));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(reviewed_by_name));
            _bw.write(_wl_block42Bytes, _wl_block42);

								}

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(second_cnt_disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(second_cnt_checked));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(after_cavity_checked));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(after_cavity_disabled));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(final_cnt_disabled));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(final_cnt_checked));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(third_cnt_cmpl_yn_chked));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(third_cnt_cmpl_yn_disabled));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(additions_after_3c_cmpl_yn_chked));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(additions_after_3c_cmpl_yn_disabled));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(fourth_cnt_cmpl_yn_chked));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(fourth_cnt_cmpl_yn_disabled));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(additions_after_4c_cmpl_yn_chked));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(additions_after_4c_cmpl_yn_disabled));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(fifth_cnt_cmpl_yn_chked));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(fifth_cnt_cmpl_yn_disabled));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(additions_after_5c_cmpl_yn_chked));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(additions_after_5c_cmpl_yn_disabled));
            _bw.write(_wl_block65Bytes, _wl_block65);

			}
			catch(Exception e)
			{
				System.err.println("280: Caught Exception in Swab Count Item Confirm"+e);
				e.printStackTrace();
			}
			finally
			{
				if(resultset!=null) 
					resultset.close();
				if(pstmt!=null) 
					pstmt.close();	
				try
				{
					ConnectionManager.returnConnection(connection,request);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}

            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InCountCompleted.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AdditionsDuringOPCompleted.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SecondCountCompleted.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AdditionsafterClcavityCompl.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FinalCountCompleted.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FinalCountCompleted.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReviewedBy.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
