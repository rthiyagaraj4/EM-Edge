package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __maintreatalert extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MainTreatAlert.jsp", 1737917142195L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n--------------------------------------------------------------------------------------\n1\t\t     V210730           16777\t      PMG2021-COMN-CRF-0076      Mohana Priya\n -->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<style>\n\nbody { font-family: sans-serif; }\n\n#id_confrmdiv\n{\n    display: none;\n    background-color: #eee;\n    border-radius: 5px;\n    border: 1px solid #aaa;\n    position: fixed;\n    width: 300px;\n    left: 50%;\n    margin-left: -150px;\n    padding: 6px 8px 8px;\n    box-sizing: border-box;\n    text-align: center;\n}\n\n#id_confrmdiv button {\n    background-color: #ccc;\n    display: inline-block;\n    border-radius: 3px;\n    border: 1px solid #aaa;\n    padding: 2px;\n    text-align: center;\n    width: 80px;\n    cursor: pointer;\n}\n\n#id_confrmdiv .button:hover\n{\n    background-color: #ddd;\n}\n\n#confirmBox .message\n{\n    text-align: left;\n    margin-bottom: 8px;\n}\n\n</style>\n <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' /> \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eBL/images/style.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n    function doSomething(val){\n\t\tif(val==\'1\'){\n\t\t\twindow.returnValue =true;\n\t\t}\n\t\telse{\n\t\t\twindow.returnValue =false;\n\t\t}\n\t\t\t//window.returnValue =true;\n\t\t\twindow.close();\n\t\t\t\n\t}\t\n\t\n\n/*\n        document.getElementById(\'id_confrmdiv\').style.display=\"block\"; //this is the replace of this line\n\n        document.getElementById(\'id_truebtn\').onclick = function(){\n           // Do your delete operation\n            alert(\'true\');\n        };\n        document.getElementById(\"id_falsebtn\").onclick = function(){\n             alert(\'false\');\n           return false;\n        };\n*/\n    \n</script>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<title></title>\n</head>\n\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onscroll=\'\' onload=\"\">\n\n<center>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"4\" class=\"BorderLight\">\n  <tr>\n\t<td colspan=\'2\' style=\"text-align: center;\">\n\t\t<font>Do you want to delete the record and recalculate</font>\n\t</td>\n  </tr>\n  <tr>\n</tr>\n  <tr>\n</tr>\n  <tr>\n\t<td class=\"label\"  style=\"text-align: right;\">\n\t\t<input type=\"button\" class=\'Button\' name=\"id_truebtn\" id=\"id_truebtn\" id=\"id_truebtn\"  style=\"text-align: center;\" value=\"Yes\" onClick=\"doSomething(1)\"  >\n\t</td> \n\t<td class=\"label\" style=\"text-align: left;\">\n\t\t<input type=\"button\" name=\"close_button\" id=\"close_button\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" class=\"button\"  onClick=\"doSomething(2);\" >\n\t</td>\n  </tr>\n\n  <!-- doSomething(2);\n  \n  <input type=\"button\" class=\'Button\' name=\"id_falsebtn\" id=\"id_falsebtn\" id=\"id_falsebtn\" style=\"text-align: center;\" value=\"No\" onClick=\"window.close();\"  >\n\t\t\n  <tr>\n\t<td class=\"label\" width=\"25%\">\n\t\t<div id=\"id_confrmdiv\">\n\t\t\t<input type=\"button\" class=\'Button\' name=\"id_truebtn\" id=\"id_truebtn\" id=\"id_truebtn\"  style=\"text-align: center;\" value=\"Yes\" onClick=\"doSomething()\"  >\n\t\t\t<input type=\"button\" class=\'Button\' name=\"id_falsebtn\" id=\"id_falsebtn\" id=\"id_falsebtn\" style=\"text-align: center;\" value=\"No\" onClick=\"doSomething()\"  >\n\t\t</div>\n\t</td> \n   </tr>\n  \n  \n    <tr>\n      <td class=\"pad4side Bg-yellow\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n        <tbody>\n          <tr>\n            <td width=\"4%\" rowspan=\"2\"><img src=\"icon1.png\" width=\"33\" height=\"41\" alt=\"\"/></td>\n            <td id=\'tdLin\' nowrap class=\"BOLD\">NARENDRA DAMODARDAS 67YRS 3M 14D 004113</td>\n          </tr>\n          <tr>\n            <td>National ID: 33EE  Alt ID: </td>\n          </tr>\n        </tbody>\n      </table></td>\n    </tr>  \n    <tr>\n      <td class=\"pad4side\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"4\">\n        <tr>\n          <td class=\"CAGROUPHEADING\">Package Details</td>\n        </tr>\n        </table>\n        </td>\n        </tr> \n -->\n        \n    </table>\n    </center>\n    </body>\n    </html>\n\n";
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

private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

		//String patientId="004113"; //004113
		String params = request.getQueryString();
	System.out.println("params ::::::::::::::: "+params);
	String patient=checkForNull(request.getParameter("patid"));
	
	System.out.println("patient ::::::::::::::: "+patient);
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")));
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
