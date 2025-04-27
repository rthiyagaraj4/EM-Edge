package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eDS.Common.JSONObject;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __notificationeventdtlview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/NotificationEventDtlView.jsp", 1709122366725L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Created for ML-MMOH-CRF-0687 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eXH/js/NotificationEventSetup.js\" ></script>\n\n\n<script type=\"text/javascript\">\nvar CheckedElementId = \"\";\nfunction validatecheckbox(obj,ElementID, AppId) {\n\tCheckedElementId = QueryResult.document.getElementById(\"checkedEventsId\").value;\n\t\n\tvar checkedElementArray = new Array();\n\tcheckedElementArray = CheckedElementId.split(\',\');\n\t\t\n\tfor (var i = 0; i < checkedElementArray.length; i++) {\n\t\t\tvar appElementIdArray = new Array();\n\t\t\tappElementIdArray = checkedElementArray[i].split(\'$!^\');\n\t\t\tvar appId = appElementIdArray[0];\n\t\t\tvar elementId = appElementIdArray[1];\n\t\t\tif (obj.checked && ElementID == elementId && appId == AppId){\n\t\t\t\tcheckedElementArray[i] = appId+\"$!^\"+elementId+\"$!^Y\";\n\t\t\t} else if(ElementID == elementId && appId == AppId) {\n\t\t\t\tcheckedElementArray[i] = appId+\"$!^\"+elementId+\"$!^N\";\n\t\t\t}\n\t\t}\n\t\n\t//alert(\"CheckedElementId=\"+CheckedElementId);\n\tdocument.getElementById(\"checkedEventsId\").value = checkedElementArray;\n\t\n}\n\nfunction funAction(typ){\n\tthis.document.forms[0].target = \"\";\n//\talert(parent.parent.frames[3].name);\n\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\tthis.document.forms[0].action_type.value = typ;\n\tthis.document.forms[0].action = \'../../eXH/jsp/EventTypeMessageTypeDisplay.jsp\';\n\tthis.document.forms[0].submit();\n}\n</script>\n<html>\n<head>\n<!-- Heading Static - Scrolling -->\n<style>\n</style>\n<!-- Heading Static - Scrolling -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\' />\n</head>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\"\n\tscrolling=\"no\">\n\n\t<form name=\"QueryResult\" id=\"QueryResult\" method=\"post\" action=\'../../servlet/eXH.InvokeEGLapplication\' target=\"messageFrame\">\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t <table align=\'right\'>\n          <tr>\n          ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n            <td align=\'right\'>\n                <font class=\'HYPERLINK\' style=\'font-size:10pt;color:blue;cursor:pointer;font-weight:normal\'\n                    onclick=\'previous()\'>\n                    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n                </font>\n            </td>\n           ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  \n               <td align=\'right\' id=\'next\' style=\'visibility:hidden\'>\n         ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</tr>\n</table>\n\n\t\t\t</br></br>\n\t\t\n\t\t\t<table class=\'grid\' id=\'NotifyResultTbl\' border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t</tr>\n\t\t\t\n\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<tr>\n\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td nowrap><input type=checkbox id=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' name=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" onClick=\"validatecheckbox(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'></td>\n\t\t\t</tr> \n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\n</table>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<input type=\"hidden\" id=\"start\" name=\"start\" id=\"start\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\"hidden\" id=\"records_to_show\" name=\"records_to_show\" id=\"records_to_show\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\"hidden\" id=\"strApplicationID\"\t name=\"strApplicationID\" id=\"strApplicationID\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\"hidden\" id=\"checkedEventsId\" name=\"checkedEventsId\" id=\"checkedEventsId\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\"hidden\" id=\"end\" name=\"end\" id=\"end\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\"hidden\" id=\"callType\" name=\"callType\" id=\"callType\" value=\"NOTIFYEVENT\">\n\n\t\t</table>\n\t\t<br>\n\t</form>\n\n</body>\n<script>\nfunction clearCheckedData(){\n\tparent.label_query.document.getElementById(\"ElementAppId_param\").value=\"\";\n}\n</script>\n</html>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue
				: inputString);
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

	request.setCharacterEncoding("UTF-8");

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

	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties) httpSession.getValue("jdbc");

	String strloggeduser = (String) httpSession.getValue("login_user");
	String strclientip = "";
	strclientip = p.getProperty("client_ip_address");
	String facility_id = (String) session.getAttribute("facility_id");
	if (sStyle == null)
		sStyle = "IeStyle.css";

	String strApplicationID = checkForNull(request.getParameter("Application_ID"));

	String Element_Id = "";
	String In_Use_Yn = "";
	String APPLICATION_ID = "";	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	int maxRecord = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	int records_to_show = 16;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String checkedData="";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(locale 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block8Bytes, _wl_block8);

			try {
				String sql = "Select ELEMENT_ID, APPLICATION_ID, ELEMENT_VALUE, IN_USE_YN From XH_APPL_ELEMENT Where Application_Id = '"
						+ strApplicationID + "' Order By To_Number(ELE_POS)";

				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
				rst = pstmt.executeQuery();
				int total = 0;
				while (rst.next()) {
					total++;
				}
				maxRecord = total;

				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql.toString());
				rst = pstmt.executeQuery();
				if (from == null)
					start = 1;
				else
					start = Integer.parseInt(from);

				if (to == null)
					end = records_to_show;
				else
					end = Integer.parseInt(to);
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			if (start != 1)
					for (int j = 1; j < start; i++, j++)
						rst.next();
				String classValue = "";
				int cnt = 0;
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (!(start <= 1)) {
        
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.previous.label", "common_labels") ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            }
           
            _bw.write(_wl_block12Bytes, _wl_block12);

                out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onclick='next()'>"
                     + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.next.label", "common_labels")
                    + "</font>");
    
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

					  	while (i <= end && rst.next()) {
					  			if (cnt == 0) {
					  
            _bw.write(_wl_block8Bytes, _wl_block8);

							}
					  			Element_Id = checkForNull(rst.getString(1));
								In_Use_Yn = (checkForNull(rst.getString(4)).equals("Y"))?rst.getString(4):"N";
								APPLICATION_ID = checkForNull(rst.getString(2));
								String appElementId = APPLICATION_ID+"$!^"+Element_Id+"$!^"+In_Use_Yn;
								if(checkedData==""){
									checkedData=appElementId;
								} else {
									checkedData=checkedData+","+appElementId;
								}
									//System.err.println("checkedData====== "+checkedData);
						
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Element_Id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( "_field"+Element_Id ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Element_Id+"_inuse"));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(In_Use_Yn.equals("Y")?"checked":""));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Element_Id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(APPLICATION_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(In_Use_Yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block23Bytes, _wl_block23);

 		i++;
 				cnt++;
 			}

 			if (cnt == 0) {
 				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
 			}
 			boolean flag = false;

 			if (cnt < 16 || (!rst.next())) {
 	
            _bw.write(_wl_block24Bytes, _wl_block24);

		flag = true;
			} else {
	
            _bw.write(_wl_block25Bytes, _wl_block25);

		}
	
            _bw.write(_wl_block26Bytes, _wl_block26);

	if (pstmt != null)
			pstmt.close();
		if (rst != null)
			rst.close();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(records_to_show));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strApplicationID));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( checkedData));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(end));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.NotificationDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
