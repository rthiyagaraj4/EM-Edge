package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eXH.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __scanandshareabhadetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ScanAndShareABHADetails.jsp", 1709122390741L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<meta charset=\"ISO-8859-1\">\n<title>ScanAndShare</title>\n<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\n\ttype=\"text/css\" />\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/jquery-1.7.2.min.js\"></script>\n<script type=\"text/javascript\">\nfunction onchangeflag(object){\n\tdocument.getElementById(\"flagVal\").value = object.value;\n}\n\nfunction search(){\n\tvar Name = document.getElementById(\"Name\");\n    var SMobileNo = document.getElementById(\"SearchMobileNo\");\n    var SearchMode = document.getElementById(\"searchMode\").value;\n    var UsedFlag = document.getElementById(\"flagVal\").value;\n    \n\tvar mobile=SMobileNo.value;\n\tvar name = Name.value;\n\t\n\t$(\"#abhaIdInfoTable\").html(\"\");\n\tdocument.getElementById(\"healthIdNumber\").value = \"\";\n\t\n    if((mobile!=null && mobile!=\"\")||(name!=null && name!=\"\" && name.length>=3)){\n\tvar response = callScanABHA(name,mobile,SearchMode,UsedFlag);\n\t//alert(\"response: \"+response);\n\tdocument.getElementById(\"OkBtn\").disabled=true;\n\t\n\tif(response!=\"\" && response!=\"[]\"){\n\t\tvar tableData = jQuery.parseJSON(response);\n\n\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"headerRow\"></tr>\');\n\t\tif(tableData.length>1){\n\t\t\t$(\"#headerRow\").append(\'<th></th>\');\n\t\t}else{\n\t\t\tdocument.getElementById(\"OkBtn\").disabled=false;\n\t\t}\n\t\t$.each(tableData[0], function(a, b) {\n\t\t\t$(\"#headerRow\").append(\'<th>\' + a + \'</th>\');\n\t\t});\n\n\t\t$.each(tableData, function(a, b) {\n\t\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"\' + a + \'\"></tr>\');\n\t\t\tvar dataRowId = \'#\' + a;\n\t\t\t$.each(b, function(c, d) {\n\t\t\t\tif(c==\'ABHA ID\' && tableData.length>1){\n\t\t\t\t\t$(dataRowId).append(\'<td><input id=\"abha\'+a+\'Id\" name=\"selectAbha\" id=\"selectAbha\" type=\"radio\" onclick=\"selectAbhaDtl(this)\" value=\"\'+d+\'\"></td>\');\n\t\t\t\t}\n\t\t\t});\n\t\t\t$.each(b, function(c, d) {\n\t\t\t\tif(c==\'ABHA ID\'){\n\t\t\t\t\tdocument.getElementById(\"healthIdNumber\").value = d;\n\t\t\t\t}\n\t\t\t\t$(dataRowId).append(\'<td>\' + d + \'</td>\');\n\t\t\t});\n\t\t});\n\t\t\n\t\tResponseMsg(\'green\',\'Scanned records are retrieved successfully.\');\n\t}else{\n\t\tResponseMsg(\'red\',\'Record not found.\');\n\t}\n    }else{\n    \tif(name!=null && name!=\"\" && name.length<3){\n    \t\tResponseMsg(\'red\',\'Enter a name with at least 3 characters.\');\n    \t}else{\n    \t\tResponseMsg(\'red\',\'Enter Name or MobileNumber details.\');\n    \t}\n    }\n}\n\nfunction selectAbhaDtl(data){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"healthIdNumber :\"+data.value);\n\t\n\tdocument.getElementById(\"healthIdNumber\").value = data.value;\n\t\n\tif(data.value!=null)\n\t\tdocument.getElementById(\"OkBtn\").disabled=false;\n}\n\nfunction ResponseMsg(color,resMsg){\n\t\t$(\"#footerResId\").html(\"\");\n\t\t$(\"#footerResId\").append(\'<p id=\"resMsg\" style=\"color: \'+color+\';\">\'+resMsg+\'</p>\');\n}\n \nfunction reset(){\n\tdocument.forms[0].reset();\n}\nfunction cancel(){\n\twindow.close();\n}\n\nfunction finish(option) {\n\tvar healthId = document.getElementById(\"healthIdNumber\").value;\n\twindow.returnValue=healthId;\n\twindow.close();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<style type=\"text/css\">\n.okBtn {\n\twidth: 60px;\n}\n\n.content {\n\tpadding: 10px;\n\tpadding-bottom: 35px;\n}\n\n#footer {\n\tposition: fixed;\n\tbottom: 0;\n\twidth: 98%;\n\ttext-align: right;\n\tpadding: 10px;\n\tbackground-color: white;\n}\n</style>\n</head>\n<body>\n\t<form>\n\t\t<div class=\"content\">\n\t\t\t<div id=\"searchDiv\" style=\"display: block;\">\n\t\t\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t<td align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t\t\t\t\t<td align=\"left\"><input type=\"text\" id=\"Name\" name=\"Name\" id=\"Name\"\n\t\t\t\t\t\t\tsize=20></td>\n\n\t\t\t\t\t\t<td align=\"left\"><select id=\"searchMode\" name=\"searchMode\" id=\"searchMode\">\n\t\t\t\t\t\t\t\t<option selected value=\"C\">Contains</option>\n\t\t\t\t\t\t\t\t<option value=\"S\">Starts with</option>\n\t\t\t\t\t\t\t\t<option value=\"E\">Ends with</option>\n\t\t\t\t\t\t</select></td>\n\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t<td align=\"left\"><input type=\"number\" id=\"SearchMobileNo\"\n\t\t\t\t\t\t\tname=\"SearchMobileNo\" id=\"SearchMobileNo\" size=20 maxlength=10></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<td align=\"left\"><select id=\"usedFlag\" name=\"usedFlag\" id=\"usedFlag\" onchange=\"onchangeflag(this);\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" selected >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t\t<td align=\"right\"><input id=\"searchBtn\" type=\"button\"\n\t\t\t\t\t\t\tclass=\"button\" value=\"Search\" onclick=\"search()\"></td>\n\n\t\t\t\t\t\t<td align=\"right\"><input id=\"resetBtn\" type=\"button\"\n\t\t\t\t\t\t\tclass=\"button\" value=\"Reset\" onclick=\"reset()\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t</br>\n\t\t\t<hr style=\"border-top: 1px solid #bbb\">\n\t\t\t</br>\n\t\t\t<div>\n\t\t\t\t<table id=\'abhaIdInfoTable\' border=1 cellspacing=0 cellpadding=3\n\t\t\t\t\talign=\"center\" width=\"95%\">\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"footer\">\n\t\t\t\t<div id=\"footerResId\"\n\t\t\t\t\tstyle=\"padding-left: 10px; float: left; text-align: left;\">\n\t\t\t\t\t<p id=\"resMsg\"></p>\n\t\t\t\t</div>\n\t\t\t\t<div id=\"btnFooter\" style=\"padding-right: 10px;\">\n\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"Cancel\"\n\t\t\t\t\t\tonclick=\"cancel()\"> <input id=\"OkBtn\" type=\"button\"\n\t\t\t\t\t\tclass=\"button okBtn\" value=\"OK\" onclick=\"finish()\" disabled>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t<input type=\"hidden\" id=\"isDebugYN\" name=\"isDebugYN\" id=\"isDebugYN\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" id=\"healthIdNumber\" name=\"healthIdNumber\" id=\"healthIdNumber\" value=\"\">\n\t\t\t<input type=\"hidden\" id=\"flagVal\" name=\"flagVal\" id=\"flagVal\" value=\"N\">\n\t</form>\n</body>\n.\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
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

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	boolean isDebugYN = false;
	
	try{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PROTOCOL_LINK WHERE PROTOCOL_LINK_ID = 'ABDMPL1'").equals("Y")) ? true : false;
		System.out.println("***Inside Scan ABHA ID - isDebugYN..."+isDebugYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Scan ABHA ID - Exception while checking isDebugYN Flag... "+e);
	}

	boolean isConsumedYN = false;
	
	try{
		isConsumedYN = (XHUtil.singleParamExeQry("SELECT NVL(DEFAULT_VALUE, 'N') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID ='ACONO5' AND ELEMENT_ID ='FLTRYN'").equals("Y")) ? true : false;
		System.out.println("***Inside Scan ABHA ID - isConsumedYN..."+isConsumedYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Scan ABHA ID - Exception while checking isConsumedYN Flag... "+e);
	}finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Scan ABHA ID - Conection closed");
	}
	
	boolean timerOn = true;
	String waitTime = "30";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

						if(isConsumedYN){
						
            _bw.write(_wl_block9Bytes, _wl_block9);

						try{
							String query = "SELECT LIST_SRL_NO, LIST_ELMT_VALUE, LIST_ELMT_LABEL FROM SM_LIST_ITEM WHERE MODULE_ID='XH' AND LIST_REF='XH_USED_FLAG_TYPE' ORDER BY LIST_SRL_NO";
							
							if(isDebugYN)
								System.out.println("***Inside Scan ABHA ID - Flag list query..."+query);
							
							conn = ConnectionManager.getConnection();
							stmt = conn.createStatement();
							rs = stmt.executeQuery(query);
							while (rs.next()) {
								
								if(isDebugYN)
									System.out.println("***Inside Scan ABHA ID - Flag list val..."+rs.getString("LIST_SRL_NO")+" "+rs.getString("LIST_ELMT_VALUE")+" "+rs.getString("LIST_ELMT_LABEL"));
							
								if(rs.getString("LIST_ELMT_VALUE").equals("N")){
							
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("LIST_ELMT_VALUE")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString("LIST_ELMT_LABEL")));
            _bw.write(_wl_block12Bytes, _wl_block12);

								} else{
							
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("LIST_ELMT_VALUE")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString("LIST_ELMT_LABEL")));
            _bw.write(_wl_block12Bytes, _wl_block12);
	
								}
							}
							
            _bw.write(_wl_block14Bytes, _wl_block14);

						} catch (Exception e){
							e.printStackTrace();
							System.out.println("***Inside Scan ABHA ID - Exception while getting Flag list... "+e);
						} finally {
							if (rs != null) rs.close();			
							if(stmt != null) stmt.close();
							ConnectionManager.returnConnection(conn, request);
						}
						}
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Name.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MobileNumber.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
