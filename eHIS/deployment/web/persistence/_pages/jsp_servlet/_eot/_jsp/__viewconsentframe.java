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
import java.util.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __viewconsentframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ViewConsentFrame.jsp", 1709120418000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="                             \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\t<style type=\'text/css\'>\n\t\tADDRESS{font-style: NORMAL;} \n \t</style>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<html>\n<body>\n<form name=\"ViewConsentDtlsForm\" id=\"ViewConsentDtlsForm\">\n<table cellpadding=3  cellspacing=\"0\" border=\"0\" width=\"100%\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<tr>\t<td  width=\"25%\" class=\"label\" colspan=\"2\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tvar msg =getMessage(\"APP-OT0089\",\"OT\");\n\t\t\t\talert(msg);\n\t\t\t\twindow.returnValue=\"\";\n\t\t\t\twindow.close();\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<tr>\n\t\t\t<td class=\'label\' align=\'center\' colspan=2>\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\'window.close();\'>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t</body>\n\t</html>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);

	boolean data_available_flag = false;
	String order_id = CommonBean.checkForNull(request.getParameter("order_id")); 


	String sql_order_line = "SELECT ORDER_LINE_NUM FROM OR_ORDER_LINE WHERE ORDER_ID = ? AND ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('93','95','96','97','99'))";

	String SQL1 = "SELECT A.FORM_ID,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',C.PRACTITIONER_ID) PRAC_NAME,TO_CHAR(A.TAKEN_DATE_TIME,'DD/MM/YYYY HH24:MI'),GIVEN_PERSON_NAME,FORM_CONTENT FROM OR_CONSENT_REF_HDR A, OR_CONSENT_REF_DTL B,AM_PRACTITIONER C  WHERE A.CONSENT_REF_ID=B.CONSENT_REF_ID AND B.ORDER_ID=? AND B.ORDER_LINE_NUM=? AND B.TYPE ='C' AND A.TAKEN_PRACT_ID = C.PRACTITIONER_ID(+) ORDER BY B.ORDER_LINE_NUM, B.CONSENT_REF_ID";


	String consent_content = "";
	String consent_taken_from="";
	String consent_prac_name = "";
	String consent_date_time="";
	String order_line_num="";
	String form_id ="";
	String prev_form_id ="";

	Clob clob_notes_content = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_1 = null;
	ResultSet rst = null;
	ResultSet rst_1 = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_order_line);
		pstmt.setString(1,order_id);
		rst = pstmt.executeQuery();
		pstmt_1 = con.prepareStatement(SQL1);
		while(rst.next()){
			order_line_num = rst.getString(1);
			pstmt_1.setString(1,locale);
			pstmt_1.setString(2,order_id);
			pstmt_1.setString(3,order_line_num);
			if(rst_1!=null) rst_1.close();
			rst_1 = pstmt_1.executeQuery();
			while(rst_1.next()){
				data_available_flag = true;
				form_id =  CommonBean.checkForNull(rst_1.getString(1));
				if(form_id.equals(prev_form_id) == false) 
				{

				consent_prac_name = CommonBean.checkForNull(rst_1.getString(2));
				consent_date_time = CommonBean.checkForNull(rst_1.getString(3));
				consent_taken_from = CommonBean.checkForNull(rst_1.getString(4));
				clob_notes_content	= rst_1.getClob("FORM_CONTENT");
				if(clob_notes_content!=null){
					consent_content = clob_notes_content.getSubString(1,(int)clob_notes_content.length());
				}						
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(consent_content));
            _bw.write(_wl_block9Bytes, _wl_block9);

				
			}
			prev_form_id = form_id;
			}
			if(rst_1!=null) rst_1.close();
		}
		if(rst_1!=null) rst_1.close();
		if(pstmt_1!=null) pstmt_1.close();
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(data_available_flag == false){
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}else
		{
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	}catch(Exception e){
		System.err.println("Err Msg in ViewConsentDtls.jsp"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(rst_1!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt_1!=null)pstmt.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}


            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
