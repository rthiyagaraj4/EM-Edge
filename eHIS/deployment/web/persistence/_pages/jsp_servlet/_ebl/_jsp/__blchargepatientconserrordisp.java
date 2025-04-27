package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLChargePatientMessage;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang.StringUtils;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.net.URLDecoder;
import com.google.gson.JsonArray;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blchargepatientconserrordisp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientConsErrorDisp.jsp", 1737915760626L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="    \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Error / Warnings</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\n\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n$(document).ready(function(){\n\t$(\'#btnClose\').click(function(){\n\t\t/* window.returnValue = \'SUCCESS\';\n\t\twindow.close(); */\n\t\tlet dialogBody = parent.document.getElementById(\'dialog-body\');\n\t    dialogBody.contentWindow.returnValue = \'SUCCESS\';\n\t    \n\t    const dialogTag = parent.document.getElementById(\'dialog_tag\');    \n\t    dialogTag.close();   \n\t});\n});\n</script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<div style=\"position:absolute;top:0px;left:20px;width:600px;height:50px;overflow-x:hidden;overflow-y:auto; float: left;\">\n<table>\n<tr>\n\t<td style=\"width: 10%;\">\n\t&nbsp;\n\t</td>\n</tr>\n<tr>\n\t<td style=\"width: 90%;\">\n\t<input type=\'button\' id=\'btnClose\' name=\'btnClose\' id=\'btnClose\' value=\'Close\'>\t\n\t</td>\n</tr>\n</table>\n</div>\n\n<div style=\"position:absolute;top:70px;left:10px;width:600px;height:210px;overflow-x:hidden;overflow-y:auto; float: left;\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<table style=\"width: 95%;\" align=\"center\">\t\n\t<tr >\n\t\t<td class=\'COLUMNHEADER\' class=\'columnheader\' >Warning Messages</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' style=\"width: 70%\">\n\t\t\tBelow are the warnings for the selected services.\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<tr style=\"width: 70%\">\n\t\t<td class=\'LABEL\' >\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =") ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" / ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" : ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n<br/>\n<br/>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n<table style=\"width: 95%;\" align=\"center\">\t\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' class=\'columnheader\' >Error Messages</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' style=\"width: 70%\">\n\t\t\tBelow are the Error for the selected services, and it has been unselected.\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t<td class=\'LABEL\' style=\"width: 70%\" >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</table>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</div>\n<br/>\n\n\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

String beanId = "BLChargePatientMessage" ;
String beanName = "eBL.BLChargePatientMessage";
BLChargePatientMessage messageBean = (BLChargePatientMessage) getObjectFromBean(beanId, beanName, session);
if(messageBean == null){
	messageBean = new BLChargePatientMessage();
}
int sno = 1;
List<BLChargePatientMessage> warnList = messageBean.getWarningList();
List<BLChargePatientMessage> errorList = messageBean.getErrorList();

if(warnList == null){
	warnList = new ArrayList<BLChargePatientMessage>();
	
}
if(errorList == null){
	errorList = new ArrayList<BLChargePatientMessage>();
}
System.err.println(warnList);
System.err.println(errorList);

            _bw.write(_wl_block5Bytes, _wl_block5);

if(!warnList.isEmpty()){ 
            _bw.write(_wl_block6Bytes, _wl_block6);
		
	sno = 1;
	for(BLChargePatientMessage loopBean: warnList){		
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sno ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(loopBean.getTrxDoc() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(loopBean.getBlngServ() ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(loopBean.getCode() ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	sno++;
	} 
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!errorList.isEmpty()){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
	
	sno = 1;
		for(BLChargePatientMessage loopBean: errorList){		
		
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sno ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(loopBean.getTrxDoc() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(loopBean.getBlngServ() ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(loopBean.getCode() ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	sno++;
	} 
            _bw.write(_wl_block16Bytes, _wl_block16);
} 

messageBean.clearAll();

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
