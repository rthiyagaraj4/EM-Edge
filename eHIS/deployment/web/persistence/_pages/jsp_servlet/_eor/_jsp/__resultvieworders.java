package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eOR.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __resultvieworders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultViewOrders.jsp", 1709119998000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="<!--IN070692starts-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" <!--IN070692ends-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!--  IN070692 starts-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!--IN070692 ends  -->\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" - ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </title>\n<frameset name=\'ViewOrderResult\' rows=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><!--frameset changed --IN066453-->\n\t<!--IN064215 start-->\n\t<!--<frame name=\'ViewOrderTop\' id=\'ViewOrderTop\' src=\'ResultViewOrderTop.jsp?orderId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&order_line_num=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&cont_order_ind=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&ord_cat=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&pract_reln_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=0  noresize scrolling=\'auto\'>-->\n\t\n\t<frame name=\'ViewOrderTop\' id=\'ViewOrderTop\' src=\'ResultViewOrderTop.jsp?orderId=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&view_by=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&event_code=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&order_catalog_code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&fromFunction=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' frameborder=0  noresize scrolling=\'auto\'><!-- 35142 -->\n\t<!--IN064215 ends-->\n\t<Frame name=\'ViewOrderHeader\' id=\'ViewOrderHeader\' src=\'../../eCommon/html/blank.html\' FrameBorder=\'0\' scrolling=\'no\' noresize>\n\t<Frame name=\'ViewOrderDtl\' id=\'ViewOrderDtl\' src=\'../../eCommon/html/blank.html\' FrameBorder=\'0\' scrolling=\'auto\' noresize>\n\t<!-- <frame name=\'ViewOrderBtn\' id=\'ViewOrderBtn\' src=\'ResultViewOrderBtn.jsp?orderId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 scrolling=auto noresize>--><!--IN039857 included ord_cat -->\n\t<frame name=\'ViewOrderBtn\' id=\'ViewOrderBtn\' src=\'ResultViewOrderBtn.jsp?orderId=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&order_status=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&orderId=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' frameborder=0 scrolling=auto noresize><!-- IN061961 --><!-- order_status added for IN068986 --><!-- OREDR ID,EVENT_CODE ADDED FOR 7632 -->\n\t<frame name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=no noresize>\n</frameset>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
03/07/2013    IN039857		 Chowminya G    Print Button from result view page for LB order
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
18/07/2018		IN061961		sivabagyam M    	18/07/2018		Ramesh G		GHL-CRF-0433
05/11/2018		IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
11/06/2019    	        IN070692             sivabagyam	          11/06/2019          Ramesh G		SKR-SCF-1224
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
02/11/2022      35142           Krishna Pranay     03/11/2022      Ramesh G        TH-KW-CRF-0020.6
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String orderId = request.getParameter("orderId");
String task_type = request.getParameter("colval1");
String colval = request.getParameter("colval");
String patient_id = request.getParameter("patient_id");
String ord_cat = request.getParameter("ord_cat");
String order_line_num="";
String cont_order_ind=request.getParameter("cont_order_ind");
String pract_reln_id=request.getParameter("pract_reln_id") == null ? "" : request.getParameter("pract_reln_id");
String view_by = request.getParameter("view_by"); //IN064215
String event_code= request.getParameter("event_code");//IN061961
String order_catalog_code = request.getParameter("order_catalog_code");//IN061961
String order_status = request.getParameter("order_status"); //IN068986

String fromFunction=request.getParameter("fromFunction") == null ? "" : request.getParameter("fromFunction");//35142

boolean isSiteSpecific=false;//IN070692
//IN066453 start
String frame_details="26%,0%,*,8%,0%";
if("LB".equals(ord_cat))
	frame_details="30%,0%,*,8%,0%";
//IN066453 end

            _bw.write(_wl_block7Bytes, _wl_block7);

try
{	
	Connection con	=	null;
	con	= ConnectionManager.getConnection();
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","DISP_LB_ORDER_DTLS_INDIV_LVL");
	if(isSiteSpecific)
	{
		order_line_num= request.getParameter("order_line_num");
	}
}catch(Exception eee){
	out.println("Exception in ResultViewOrders.jsp : "+eee.toString());
	eee.printStackTrace();
}	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(task_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(colval));

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(frame_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fromFunction));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(event_code));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
