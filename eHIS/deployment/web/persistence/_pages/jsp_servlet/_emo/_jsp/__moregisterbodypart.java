package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __moregisterbodypart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegisterBodyPart.jsp", 1734498945005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eMO/js/MORegisterBodyPart.js\' language=\'javascript\'></script> \n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\talert(getMessage(\"MO_PARAM_NOT_FOUND\",\"MO\"));\t      \t\t\t\n\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>   \n\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<!--<frameset rows=\'0,25,7%,*,33,0,0\' id=\"bp\" name=\"bp\" >-->\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!--<frameset rows=\'47,25,7%,*,20,0,0\' id=\"bp\" name=\"bp\">-->\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:9vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<iframe name=\'criteria\' id=\'criteria\' src=\'../../eMO/jsp/MORegisterBodyPartCriteria.jsp?function_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&functionid=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&mode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&registration_no=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&function_id1=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' scrolling=\'no\' frameborder=0 noresize style=\'height:4vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<iframe name=\'criteria\' id=\'criteria\' src=\'../../eCommon/html/blank.html\' scrolling=\'no\' frameborder=0 noresize style=\'height:3vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<iframe name=\'patientline\' id=\'patientline\' src=\'../../eCommon/html/blank.html\' scrolling=\'no\' frameborder=0 noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eCommon/html/blank.html\' scrolling=\'no\' frameborder=0 noresize style=\'height:69vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'  src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'yes\' style=\'height:9vh;width:100vw\'></iframe>\n\t  \t<iframe name=\'dummyframe\' id=\'dummyframe\'  src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'dummyframe1\' id=\'dummyframe1\'  src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n<!--</frameset>-->\n\n<form>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t<input type=\'hidden\' name=\'functionid\' id=\'functionid\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t</form>\n</html>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID");
	String registration_no=request.getParameter("registration_no")==null?"":request.getParameter("registration_no");
	String source = url + params ;
	String functionid=request.getParameter("functionid")==null?"":request.getParameter("functionid");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");	
	/*Below line added for this CRF ML-MMOH-CRF-0695*/
	String function_id1=request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
	
/*Below Code Added for this incident[33931] */		
String	facility_id =  (String) session.getValue( "facility_id" ) ;
Connection con		=	null;
Statement	st		=	null;
ResultSet	rs		=	null;
String interval="";           
    try 
		{ 			
			con	 =	(Connection)ConnectionManager.getConnection(request);			
			st	 =con.createStatement();
			rs=st.executeQuery("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id='"+facility_id+"'");
			if(rs.next())
			{
			interval=rs.getString("QUEUE_REFRESH_INTERVAL")==null?"0":rs.getString("QUEUE_REFRESH_INTERVAL");			   
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			}catch(Exception e)
	        {
	        e.printStackTrace();
	        }finally {
	           ConnectionManager.returnConnection(con,request);
             }

if(interval.equals("")){
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	if(mode.equals("viewdata")){
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(source));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(source));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
if(mode.equals("modify")||mode.equals("viewdata"))
	{
	  /*Below line modified for this CRF ML-MMOH-CRF-0695*/
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(function_id1));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else
	{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BodyParts.label", java.lang.String .class,"key"));
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
