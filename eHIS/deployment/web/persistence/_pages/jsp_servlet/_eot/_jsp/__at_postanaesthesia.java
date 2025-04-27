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
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eOT.ChkInOutRecoveryBean;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __at_postanaesthesia extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_PostAnaesthesia.jsp", 1709120158000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<title>\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</title>\n<form name=\"OTCheckinForm\" >\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/AT_PostAnaesthesia.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script>\n\n\n\tfunction reset(){\n\t\tvar formObj=parent.parent.frames[2].document.forms[0];\n\t\tvar postop_done_yn=document.forms[0].postop_done_yn.value;\n\t\tif(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){\n\t\t\tif(postop_done_yn!=\"Y\"){\n\t\t\t\tformObj.weight.value=\"\";\n\t\t\t\tformObj.height.value=\"\";\n\t\t\t\tformObj.bsa.value=\"\";\n\t\t\t\tformObj.bmi.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].finish_date.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].finish_time.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].rec_start_date.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].rec_start_time.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].rec_finish_date.value=\"\";\n\t\t\t\tparent.parent.frames[3].document.forms[0].rec_finish_time.value=\"\";\n\t\t\t\tif(parent.parent.frames[6].frames[1].name==\"untowards_evt_record_frame\"){\n\t\t\t\tparent.parent.frames[6].frames[1].document.forms[0].unusual_occur_desc.value=\"\";\n\t\t\t\t}else if(parent.parent.frames[6].frames[1].name=\"personal_record_frame\"){\n\t\t\t\t\tparent.parent.frames[6].frames[0].document.forms[0].pract_type.value=\"\";\n\t\t\t\t\tparent.parent.frames[6].frames[0].document.forms[0].practitioner_name.value=\"\";\t\t\t\n\t\t\t\t}\n\t\t\t\tif(parent.parent.frames[7].document.forms[0].checkAnaes.checked==true){\n\t\t\t\t\tparent.parent.frames[7].document.forms[0].checkAnaes.checked=false;\n\t\t\t\t}\n\t\t      }\n\t\t\t}\n\t\t}\n\t\t\n\t</script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<input type=\'hidden\' name=\'postop_done_yn\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<!-- <FRAMESET rows=\"30,22%,19%,4%,*,38,0,0\" border=\'0\'> -->\n\t<FRAMESET rows=\"4%,10%,20%,23%,4%,*,8%,8%,0,0\" border=\'0\'>\n    <frame name=\"commontoolbarFrame\" frameborder=\"0\" scrolling=\'no\' noresize=\"no\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t<frame name=\'OtPatientLineFrame\' SRC=\'../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' scrolling=\'no\' noresize>\n\t<frame name=\'AnaesthesiaHdrFrame\' SRC=\'../../eOT/jsp/AT_CommonAnaesthesiaHdr.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' scrolling=\'no\' noresize></frame>\n\t<FRAME NAME=\'AnaesthesiaDetailsFrame\' SRC=\'../../eCommon/html/blank.html\'  scrolling=\'no\' noresize=\'no\'>\n<FRAMESET ROWS = \"0%,*\" >\n\t<FRAME NAME=\'ObjectCollect\' SRC=\'../../eOT/jsp/AT_PostAnaesthesiaObjectCollect.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  scrolling=\'no\' \tnoresize=\'no\'></FRAME>\n\t<FRAME NAME=\'tab_frame\' SRC=\'../../eOT/jsp/AT_PostAnaesthesiaTab.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  scrolling=\'no\' \n\tnoresize=\'no\'></FRAME> \n</FRAMESET>\n\t<FRAME NAME=\'ResultFrame\' SRC=\'../../eCommon/html/blank.html?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t<frame name=\'post_anaes_doc_status_frame\' src=\"../../eOT/jsp/AT_PostAnaesDocStatus.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" frameborder=\"0\" noresize >\n\t<frame name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\"></frame>\n\t<frame name=\"dummy_frames\" src=\'../../eCommon/html/blank.html\' frameborder=\"0\" noresize scrolling=\"no\">\n\t<frame name=\"dummy_frame\" src=\'../../eCommon/html/blank.html\' frameborder=\"0\" noresize scrolling=\"no\">\n\n</FRAMESET>\n<body  onKeyDown = \'lockKey();\'>\n\n\t<input type=\'hidden\' name=\'params\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String facility_id  = (String) session.getValue("facility_id");
	String login_user = (String) session.getValue("login_user");
	String params = request.getQueryString();
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
	bean.clear();
	params = params+"&module_id=OT&function_id=11&function_name=Record Post Anaesthesia Details&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N&facility_id="+facility_id+"&anesthesia_flag=POST"+"&slate_user_id="+login_user;
	String anesthesia_srl_no		=request.getParameter("anesthesia_srl_no");
	String postop_done_yn="";
	String source_order_id = "";
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		  String sql_postop= "SELECT POSTOP_DONE_YN POSTOP_DONE_YN1,SOURCE_ORDER_ID FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
		  connection	= ConnectionManager.getConnection(request);
		  pstmt=connection.prepareStatement(sql_postop);
		  pstmt.setString(1,facility_id);
		  pstmt.setString(2,anesthesia_srl_no); 
		  rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			postop_done_yn=checkForNull(rs.getString("POSTOP_DONE_YN1"));
			source_order_id=checkForNull(rs.getString("SOURCE_ORDER_ID"));
		  }
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(postop_done_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}catch(Exception ee){
		System.err.println("Exception=="+ee);
	}
	finally{
		try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
             }catch(Exception es){es.printStackTrace();}
	}
	String source ="";
	if(postop_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(postop_done_yn.equals("N") || postop_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	params = params+"&postop_done_yn="+postop_done_yn+"&source_order_id="+source_order_id;

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(source));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(params));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordPostAnaesthesiaDetails.Label", java.lang.String .class,"key"));
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
}
