package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eXH.InterfaceUtil;
import eXH.XHDBAdapter;
import java.text.*;
import java.io.*;
import java.net.*;
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
        if (sci.isResourceStale("/exh/jsp/XHBarcodePrinting.jsp", 1709122417928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\t\n\t<head>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</head>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\n\t<script type=\"text/javascript\">\n\t\tvar docReadyCount = 0;\n\t\tvar divCount = 0;\t\n\t\t\n\t\tvar dialogTop\t\t=\t\"100\" ;\n\t\tvar dialogLeft\t\t=\t\"100\" ;\n\t\tvar dialogHeight\t=\t\"300\" ;\n\t\tvar dialogWidth\t\t=\t\"300\" ;\n\t\tvar status\t\t\t=\t\"no\";\n\t\tvar arguments\t\t=\t\"\" ;\n\t\tvar features\t\t=\t\"Height=\" + dialogHeight + \"; Width=\" + dialogWidth + \"; Top=\" + dialogTop + \"; Left=\" + dialogLeft + \";scroll=no; status:\" + status;\n\t\tvar PrintCommand = \'<object id=\"PrintCommandObject\" classid=\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\" width=\"0\" height=\"0\"></object>\';\t\n\n\t\t$(document).ready(function() {\n\t\t\t\n\t\t\tif (navigator.appName == \"Microsoft Internet Explorer\"){\t\t\t\n\t\t\t \t// attach and initialize print command ActiveX object\n\t\t\t\ttry{\t \t\t\n\t\t\t \t\tdocument.body.insertAdjacentHTML(\'afterbegin\', PrintCommand);\n\t\t\t\t}\n\t\t\t \tcatch(e){}\n\t\t\t}\t\n\t\t\t\t\n\t\t});\n\n\t\t$(window).load(function() \n\t\t{\t\t\n\t\t\t\tif(PrintCommandObject)\n\t\t\t\t{\n\t\t\t\t\ttry{\n\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t\talert(\"Printing Completed\");\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t\tcatch(e){\n\t\t\t\t\t\talert(e.message);\n\t\t\t\t\t\twindow.print();\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\twindow.print();\n\t\t\t\t\twindow.close();\n\t\t\t\t}\t\t\t\t\n\t\t});\n\t\t\n\t\tfunction pagePrint(){\n\t\t\twindow.print();\n\t\t\twindow.close();\n\t\t}\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<body>\t\n\t\t<form name=\"XHBarcodePrintForm\" id=\"XHBarcodePrintForm\">\n\n\t\t<pre>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</pre>\n\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
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
            _bw.write(_wl_block6Bytes, _wl_block6);

			StringBuffer htmlData = new StringBuffer();
			String printFlag="";
			String facilityId ="";
			
			String barcode_id = "", itemname = "", batchid = "", expdate = "", itemCode="",printQty="1";
			int printNo = 0;
			int itemLength = 30;
			String barcode_qty = "";

			String printData = "";
			String appId = "BARCOD";
			
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
			
			//&barcode=12345&itemname=barcodeitem2&batchid=123456&expdate=12/01/2017";
			barcode_id = XHDBAdapter.checkNull(request.getParameter("barcode_id"));
			itemname = XHDBAdapter.checkNull(request.getParameter("itemname"));
			System.out.println(" itemname Data before replace ::: "+itemname.length());
			System.out.println(" itemname ::: "+itemname);
			con = ConnectionManager.getConnection();
			HashMap hs = eCommon.Common.CommonBean.getSiteSpecificDetails(con, "XH","BARCODE_ITEMNAME_LENGTH");
			String lengthStr = (String)hs.get("value1");
			String dividingValue = (String)hs.get("value2");
			System.out.println(" itemname HashMap values::: "+hs);
			System.out.println(" itemname lengthStr::: "+lengthStr);
			System.out.println(" print qty dividingValue::: "+dividingValue);
			if(lengthStr!=null && lengthStr!="")
			{
			   itemLength = Integer.parseInt(lengthStr);
			}
			if(itemname!=null && itemname.length() > itemLength)
			{
				itemname = itemname.substring(0,itemLength);
			}
			System.out.println(" itemname after::: "+itemname);
            System.out.println(" itemname Data after replace ::: "+itemname.length());
			batchid = XHDBAdapter.checkNull(request.getParameter("batchid"));
			expdate = XHDBAdapter.checkNull(request.getParameter("expdate")); 
			itemCode = XHDBAdapter.checkNull(request.getParameter("item_code")); 
			printQty = XHDBAdapter.checkNull(request.getParameter("printQty"));
			System.out.println("printQty::: "+printQty);

			if(printQty=="" || printQty==null)
			{
               printQty="1";
			}
			else
			{
				if(dividingValue=="" || dividingValue == null )
				{
                     dividingValue = "4";
				}
				else if("0".equals(dividingValue))
				{
                     dividingValue = "1";
				}
				int printQtyIntMod = 0;
				int printQtyInt = Integer.parseInt(printQty);
				int dividingValueInt = Integer.parseInt(dividingValue);
				printQtyIntMod = (printQtyInt %  dividingValueInt );
				printQtyInt = (printQtyInt/dividingValueInt);
				System.out.println("printQtyInt after dividing::: "+printQtyInt);
				if(printQtyInt!=0)
				{
					if(printQtyIntMod!=0)
				   {
					   printQtyInt  = printQtyInt + 1;  // it will increase one row. If they give 10 nos, 3 rows will be printed. 12 labels.
				   }
                   printQty = String.valueOf(printQtyInt);
				}
				else
				{
					printQty = "1";
				}
				System.out.println("else-- printQty after::: "+printQty);
			}
            System.out.println(":::::Final printQty::: "+printQty);
			/*
				Read from table, CLOB Data.
				printData
			*/
			printData = InterfaceUtil.getBarcodeData(appId);
            System.out.println(" barcode_id ::: "+barcode_id);
			//System.out.println(" Print Data from Table ::: "+printData);  it will be printed in interfaceutil.java class
		
		if (printData.length() > 0){
		
			printData =  printData.replace("$barcode$", barcode_id); 
			printData =  printData.replace("$itemname$", itemname); 
			printData =  printData.replace("$batchid$", batchid); 
			printData =  printData.replace("$expdate$", expdate);
			printData =  printData.replace("$itemcode$", itemCode);
			printData =  printData.replace("$printqty$", printQty);
		}	

		System.out.println(" Print Data after replace ::: "+printData);
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(printData ));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
