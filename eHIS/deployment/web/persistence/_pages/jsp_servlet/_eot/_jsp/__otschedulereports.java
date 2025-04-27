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
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __otschedulereports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTScheduleReports.jsp", 1709120296000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n          \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script src=\"../../eOT/js/OTReportsLkupSQL.js\" ></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\'>\n<tr> \n\t<td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t  <input type=\'text\' name=\'param1\' id=\'param1\' size=\'14\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onBlur=\"isValidDateTime(this);\" maxlength=\'16\'>  \n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param1\',\'DD/MM/YYYY HH24:MI\');\">\n\t\t  <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t\t\n\t  <td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t <td class=\'fields\' width=\'25%\'>\n\t\t  <input type=\'text\' name=\'param2\' id=\'param2\' size=\'14\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onBlur=\"isValidDateTime(this);\" maxlength=\'16\'> \n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param2\',\'DD/MM/YYYY HH24:MI\');\">\n\t\t  <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'param4\' id=\'param4\' >\n\t\t<input type=\'hidden\' name=\'param3\' id=\'param3\'> \n\t\t<input type=\'text\' name=\'param3_desc\' id=\'param3_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' param1 = \'param3\'  param2 = \'param4\' key =\'OPER_ROOM\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param3.value=\'\',param4.value=\'\' \" > \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'OperRoomLookUp\' id=\'OperRoomLookUp\' onClick=\"callCommonLookup(param3_desc);\" >\n\t</td>\n   \n \n\t<td class=\'label\' width=\'25%\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</td>\n    <td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'param6\' id=\'param6\' >\n\t\t<input type=\'hidden\' name=\'param5\' id=\'param5\'> \n\t\t<input type=\'text\' name=\'param5_desc\' id=\'param5_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' param1 = \'param5\'  param2 = \'param6\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param5.value=\'\',param6.value=\'\' \" > \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookup(param5_desc);\" >\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTRETEST\">\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTRETEST\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\t\n\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" disabled>\n    <input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param2##";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" disabled>\n\n\t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Operation Date\" disabled>\n    <input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled>\n\t\n\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param3##Code\" disabled>\n    <input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param4\" disabled>\n    <input type=\"hidden\" name=\"qry_sql\" id=\"qry_sql\" value=\"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' AND OPERATING_FACILITY_ID =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\" >\n\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param3#param4#param5#param6#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromBookingDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToBookingDate.Label","ot_labels");
	String theatre_code= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Theatre.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("DATE_TIME"),"DMYHM","en",locale);
		}

			if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(theatre_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block16Bytes, _wl_block16);

}
	catch(Exception e){
		System.err.println("Err Msg OTScheduleReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }


            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fromoperationdate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tooperationdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromBookingDate.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToBookingDate.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
}
