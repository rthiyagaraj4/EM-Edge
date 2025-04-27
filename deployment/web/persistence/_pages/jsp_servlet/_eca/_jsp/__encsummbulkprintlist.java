package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eCA.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encsummbulkprintlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummBulkPrintList.jsp", 1738424753980L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--[if IE 6]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if IE 7]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if gte IE 7]>  \n\t<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \n<![endif]-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html>\n<html>\n\t<head>\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" type=\"text/css\" />\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/EncSummBulkPrint.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t<script>\n\t\t\n\t\t\n\t\t//appends an \"active\" class to .popup and .popup-content when the \"Open\" button is clicked\n\t\t$(\".open\").on(\"click\", function() {\n\t\t  $(\".popup-overlay, .popup-content\").addClass(\"active\");\n\t\t});\n\n\t\t//removes the \"active\" class to .popup and .popup-content when the \"Close\" button is clicked \n\t\t$(\".close, .popup-overlay\").on(\"click\", function() {\n\t\t  $(\".popup-overlay, .popup-content\").removeClass(\"active\");\n\t\t});\n\n\t\twindow.addEventListener(\"click\", function(event) {\n\t\t\tif (event.target == modal) {\n\t\t\t\t$(\".popup-overlay, .popup-content\").removeClass(\"active\");\n\t\t\t  }\n\t\t});\n\t\t  \n\t\t\n\t\t</script>\n\t\t<style>\t\t\t\n\t\t\t#header-fixed {\n\t\t\t    position: fixed;\n\t\t\t    top: 0px; \n\t\t\t    display:none;\n\t\t\t    background-color:white;\n\t\t\t    clear:both;\n\t\t\t}\n\t\t\t\n\t\t\t.gridData\n\t\t\t{\n\t\t\t\tbackground-color: #FFFFFF;\n\t\t\t\theight:18px;\n\t\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\t\tfont-size: 8pt;\n\t\t\t\tcolor: #000000;\n\t\t\t\tfont-weight:normal;\n\t\t\t\ttext-align:left;\n\t\t\t\tpadding-left:10px;\n\t\t\t\tpadding-right:10px;\n\t\t\t\tvertical-align:middle;\n\t\t\t\tborder-bottom:1px;\n\t\t\t\tborder-top:0px;\n\t\t\t\tborder-left:0px;\n\t\t\t\tborder-right:0px;\n\t\t\t\tborder-style:solid;\n\t\t\t\tborder-color:#EEEEEE;\n\t\t\t}\n\n\t\t\thtml {\n\t\t\t  font-family: \"Helvetica Neue\", sans-serif;\n\t\t\t  width: 100%;\n\t\t\t  color: #666666;\n\t\t\t  text-align: center;\n\t\t\t}\n\n\t\t\t.popup-overlay {\n\t\t\t  /*Hides pop-up when there is no \"active\" class*/\n\t\t\t  visibility: hidden;\n\t\t\t  position: absolute;\n\t\t\t  background: #ffffff;\n\t\t\t  border: 3px solid #666666;\n\t\t\t  width: 50%;\n\t\t\t  height: 20%;\n\t\t\t  left: 25%;\n\t\t\t}\n\n\t\t\t.popup-overlay.active {\n\t\t\t  /*displays pop-up when \"active\" class is present*/\n\t\t\t  visibility: visible;\n\t\t\t  text-align: center;\n\t\t\t}\n\n\t\t\t.popup-content {\n\t\t\t  /*Hides pop-up content when there is no \"active\" class */\n\t\t\t  visibility: hidden;\n\t\t\t}\n\n\t\t\t.popup-content.active {\n\t\t\t  /*Shows pop-up content when \"active\" class is present */\n\t\t\t  visibility: visible;\n\t\t\t}\n\n\t\t\tbutton {\n\t\t\t  display: inline-block;\n\t\t\t  vertical-align: middle;\n\t\t\t  border-radius: 30px;\n\t\t\t  margin: .20rem;\n\t\t\t  font-size: 1rem;\n\t\t\t  color: #666666;\n\t\t\t  background: #ffffff;\n\t\t\t  border: 1px solid #666666;\n\t\t\t}\n\n\t\t\tbutton:hover {\n\t\t\t  border: 1px solid #666666;\n\t\t\t  background: #666666;\n\t\t\t  color: #ffffff;\n\t\t\t}\n\t\t\t\n\t\t</style>\n\t\t\n\t</head>\n\t<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name = \'encSummPopUpListForm\'>\n\t\t\t<!--Creates the popup body-->\n\t\t\t<div class=\"popup-overlay\">\n\t\t\t  <!--Creates the popup content-->\n\t\t\t  <div class=\"popup-content\">\n\t\t\t\t<p> <img id=\"img-prog\"  src=\"../../eCommon/images/processing-gif-transparent-3.gif\"></img></p>\n\t\t\t\t<!--popup\'s close button-->\n\t\t\t\t<!--<button class=\"close\">Close</button> -->\n\t\t\t  </div>\n\t\t\t</div>\n\n\t\t\t<table id=\"header-fixed\" class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'  align=\'center\'></table>\t\n\t\t\t<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'  align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' colspan=\'5\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t</table>\t\n\t\t\t<table id=\"table-1\" class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'  align=\'center\'>\n\t\t\t<thead>\n\t\t\t\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"10%\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"30%\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"10%\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"10%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"10%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"20%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"20%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" &nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'selectAllchk\' id=\'selectAllchk\' onclick=\"setEncounter(this);\"></td>\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t<tbody>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t\t\t\tparent.EncSummBulkListFrame.location.href = \'../../eCommon/html/blank.html\';\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td colspan=\'7\' class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" - ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\t\n\t\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td colspan=\'7\' class=\'CAGROUP\'> &nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr id =\'trRowId";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td style=\'display:none\'> <input type=\'hidden\' name =\'patientId";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id =\'patientId";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' > </td>\n\t\t\t\t\t\t\t\t<td style=\'display:none\'> <input type=\'hidden\' name =\'encounterId";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id =\'encounterId";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' > </td>\n\t\t\t\t\t\t\t\t<td class=\'gridData\'> &nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </td>\t\n\t\t\t\t\t\t\t\t<td class=\'gridData\'> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </td>\n\t\t\t\t\t\t\t\t<!-- \n\t\t\t\t\t\t\t\t<td class=\'gridData\'> <a href=\"javascript:viewEncounterSummary(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </a> </td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t <td class=\'gridData\'> <a href=\"javascript:checkForSummary(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </a> </td>\n\t\t\t\t\t\t\t\t<td class=\'gridData\'> ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" </td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\'gridData\'> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" </td>\n\t\t\t\t\t\t\t\t<td class=\'gridData\'> ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </td>\n\t\t\t\t\t\t\t\t<td class=\'gridData\'   align=\'center\'> \n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'secChk";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'secChk";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  onclick=\"setEncounterValue(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\">  \n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t</tbody>\n\t\t\t</table>\t\n\t\t\t<input type=\'hidden\' name=\'patientCount\' id=\'patientCount\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\t \n\t\t\t\n\t\t</form>\t\t\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );
	
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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
18/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
	
	request.setCharacterEncoding("UTF-8");		

            _bw.write(_wl_block5Bytes, _wl_block5);

			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			EncSummGroup summGrpDetails = new EncSummGroup();		
			
			int nListSize = 0;
					
			String specialtyCode = "", specialtyDesc = "", locnType = "", locnCode = "", locnDesc = "", practId = "";
			String  patientId = "", patientName = "", pracName = "", encounterId = "", searchDate = "", gender = "";	
			
			String prevSpecCode = "", prevLocnCode = "";
			
			specialtyCode = request.getParameter("specialtyCode") == null ? "" : request.getParameter("specialtyCode");
			locnType = request.getParameter("locnType") == null ? "" : request.getParameter("locnType");
			locnCode = request.getParameter("locnCode") == null ? "" : request.getParameter("locnCode");
			practId = request.getParameter("practId") == null ? "" : request.getParameter("practId");
			patientId = request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
			encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
			searchDate = request.getParameter("searchDate") == null ? "" : request.getParameter("searchDate");
			gender = request.getParameter("gender") == null ? "" : request.getParameter("gender");
			
				
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
										
					List<PatientEncounterBean> oPatientEncList = null;
					PatientEncounterBean sPatienEncBean = null;					
					
					try
					{
						oPatientEncList = new ArrayList<PatientEncounterBean>();
						sPatienEncBean = new PatientEncounterBean();
						
						sPatienEncBean.setRequest(request);
						sPatienEncBean.setsSpecialtyCode(specialtyCode);
						sPatienEncBean.setsCareLocnType(locnType);
						sPatienEncBean.setsCareLocnCode(locnCode);
						sPatienEncBean.setsPractID(practId);
						sPatienEncBean.setsPatientID(patientId);
						sPatienEncBean.setsEncounterID(encounterId);
						sPatienEncBean.setsVisitDateTime(searchDate);
						sPatienEncBean.setsGender(gender);
						
						oPatientEncList = summGrpDetails.getPatientEncounter(sPatienEncBean);		
						
						nListSize = oPatientEncList.size();	
						
						prevSpecCode = "";
						prevLocnCode = "";
						
						if (nListSize == 0)
						{
							
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
						
						for (int i=0;i<nListSize;i++){
							
							sPatienEncBean = oPatientEncList.get(i);
							
							specialtyCode = sPatienEncBean.getsSpecialtyCode();
							specialtyDesc = sPatienEncBean.getsSpecialtyDesc();
							locnType = sPatienEncBean.getsCareLocnType();
							locnCode = sPatienEncBean.getsCareLocnCode();
							locnDesc = sPatienEncBean.getsCareLocnDesc();
							practId = sPatienEncBean.getsPatientID();
							patientId = sPatienEncBean.getsPatientID();
							encounterId = sPatienEncBean.getsEncounterID();
							searchDate = sPatienEncBean.getsVisitDateTime();
							gender = sPatienEncBean.getsGender();
							pracName = sPatienEncBean.getsPractName();
							patientName = sPatienEncBean.getsPatientName();
							
							if (!specialtyCode.equalsIgnoreCase(prevSpecCode)){								
								
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(specialtyCode ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialtyDesc ));
            _bw.write(_wl_block19Bytes, _wl_block19);
								
							}
							
							if (!locnCode.equalsIgnoreCase(prevLocnCode)){								
								
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locnCode ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locnDesc ));
            _bw.write(_wl_block19Bytes, _wl_block19);
								
							}
							
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(searchDate ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(gender ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pracName ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block39Bytes, _wl_block39);
	
							prevSpecCode = specialtyCode;
							prevLocnCode = locnCode;
						}						

					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummPopUpList.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}				
			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nListSize));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllEncounters.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
