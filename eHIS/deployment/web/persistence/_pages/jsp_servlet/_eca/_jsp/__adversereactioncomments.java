package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;

public final class __adversereactioncomments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AdverseReactionComments.jsp", 1742180248370L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History\t\tName        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n16/04/2024\t  32074\t   Ranjith P R\t\t17/04/2024\t\tRAMESH G\t\tML-MMOH-CRF-1912.1\n9/08/2024\t  64856    HARIHARAN K\t    9/08/2024\t\t\t\t        ML-MMOH-SCF-2920\n---------------------------------------------------------------------------------------------------------\n-->\n<!-- 32074 starts -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head> \n<style>\n\tTD.CAGREEN\n\t{\n\t\tFONT-SIZE: 10PT ;\n\t\tBACKGROUND-COLOR: #99CC00;\n\t\tBORDER-STYLE: SOLID;\n\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n\t}\n\tTD.TD_BROWN\n\t{\n\t\tBACKGROUND-COLOR: BROWN;  \n\t\tCOLOR = WHITE;\n\t\tFONT-SIZE: 10pt ;\n\t\tBORDER-STYLE: SOLID;\n\t\tborder-left-color: #B2B6D7;\n\t\tborder-right-color: #B2B6D7;\n\t\tborder-top-color: #E2E3F0;\n\t\tborder-bottom-color: #E2E3F0;\n\t\theight:18;\t\n\t}\n\tPRE\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/*IN043895 Start.*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\tFont-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";\n\t\t\t/*IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\n\t\t}\n\t<!-- IN042466 Start. -->\n\tDIV\n\t\t{\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\twidth\t: 1000px;\n\t\t\n\t\t}\n\tADDRESS\n\t\t{\n\t\t\t/*IN049424 Start.*/\n\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/  /*IN043895*/\n\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t/* IN049424 End.*/\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\t/*width\t: 1000px;*/ <!-- IN059735 -->\n\t\t}\n\t<!-- IN042466 End. --> \n</style>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>      \n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>Blood Transfusion - Adverse Reaction Details</title>\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\n\n\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\'\n\t\talign=center scrolling=\'no\'>\n       \n\t\t<tr>\n\t\t\t<td>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n\t\t\t\n\n\t\t</tr>\n\n\t</table>\n\n\n</body>\n\n</html>\n<!-- 32074 ends -->\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	  request.setCharacterEncoding("UTF-8");
	  String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Properties p;
session 		= request.getSession(false);
p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale 	= (String) p.getProperty("LOCALE");
String transfusion_remarks = "";
String patient_id	=request.getParameter("patient_id");
String unit_no	=request.getParameter("unit_no");
String specimen_num	=request.getParameter("specimen_num");
String product_code	=request.getParameter("product_code");
String encounter_id =request.getParameter("encounter_id1");//ML-MMOH-SCF-2920

String his_rec_type = "BLTF";
String bean_id = "ChartSummaryCriticalLabAlertDetailsBean";
String bean_name = "eCA.ChartSummaryCriticalLabAlertDetailsBean";
ChartSummaryCriticalLabAlertDetailsBean bean = (ChartSummaryCriticalLabAlertDetailsBean)getBeanObject(bean_id,bean_name,request) ; 
ArrayList searchData = new ArrayList();		
searchData = bean.getAdverseTransfusionDetails(p,locale,patient_id,unit_no,specimen_num,product_code,his_rec_type,encounter_id);//ML-MMOH-SCF-2920


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(searchData.get(0)));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
