package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import java.text.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __xhbarcodeprinting extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/XHBarcodePrinting.jsp", 1741272820416L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--[if IE 6]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if IE 7]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if gte IE 7]>  \n\t<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \n<![endif]-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\t\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\t\t\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n\t<script>\n\t\tvar docReadyCount = 0;\n\t\tvar divCount = 0;\n\t\t\n\t\tfunction printPage(){\n\t\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" == \"1\")\n\t\t\t{\t\n\t\t\t\t\n\t\t\t\tdocReadyCount = docReadyCount + 1;\t\n\t\t\t\tif (docReadyCount == divCount) \n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\t\t\n\t\t\t\t\t\ttry{\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t\t\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\t \n\t\t\n\t\t$(document).ready(function() {\n\t\t\t\n\t\t\tdivCount = document.getElementById(\"divCount\").value;\t\n\t\t\t\n\t\t\tif (navigator.appName == \"Microsoft Internet Explorer\"){\t\t\t\n\t\t\t \t// attach and initialize print command ActiveX object\n\t\t\t\ttry{\n\t\t\t \t\tvar PrintCommand = \'<object id=\"PrintCommandObject\" classid=\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\" width=\"0\" height=\"0\"></object>\';\t\t \t\t\n\t\t\t \t\tdocument.body.insertAdjacentHTML(\'afterbegin\', PrintCommand);\n\t\t\t\t}\n\t\t\t \tcatch(e){}\n\t\t\t}\t\n\t\t\t\t\n\t\t});\n\t\t\n\t\t$(window).load(function() \n\t\t{\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" == \"1\")\n\t\t\t{\t\n\t\t\t\tif (divCount == 0)\n\t\t\t\t{\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\n\t\t\t\t\t\ttry{\t\t\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t \t\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\t\n\t\tfunction pagePrint(){\n\t\t\twindow.print();\t\n\t\t}\n\t</script>\n\t<body>\t\t\n\t\t<form name=\"XHBarcodePrintForm\" id=\"XHBarcodePrintForm\">\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	StringBuffer htmlData = new StringBuffer();
	
	String barcode = "", itemname = "", batchid = "", expdate = "";
	int printNo = 0;

	String printData = "";
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	String notesHtmlData = "";
	String strHtmlData = "";	
	
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	
	barcode = request.getParameter("barcode")==null?"":request.getParameter("barcode");
	itemname = request.getParameter("itemname")==null?"":request.getParameter("itemname");
	batchid = request.getParameter("batchid")==null?"":request.getParameter("batchid");
	expdate = request.getParameter("expdate")==null?"":request.getParameter("expdate");
	
	/*
		Read from table, CLOB Data.
		printData
	*/
		System.out.println(" Print Data from Table ::: "+printData);
		
		if (printData.length() > 0){
		
			printData =  printData.replace("$barcode$", barcode); 
			printData =  printData.replace("$itemname$", itemname); 
			printData =  printData.replace("$batchid$", batchid); 
			printData =  printData.replace("$expdate$", expdate); 		
		
		}	

		System.out.println(" Print Data after replace ::: "+printData);
		
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( printData));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
