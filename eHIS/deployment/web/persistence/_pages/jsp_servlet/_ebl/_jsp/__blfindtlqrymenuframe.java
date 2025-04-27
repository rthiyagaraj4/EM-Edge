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
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlqrymenuframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlQryMenuFrame.jsp", 1709114512057L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script>\n/*\n function funEpiTypeChk()\n {\n\t var episodetype=document.forms[0].episodetype.value;\n\t if(episodetype==\'R\')\n\t {\n\t\t document.forms[0].episodeid.disabled=true;\n\t\t document.forms[0].visitid.disabled=true;\n\t }\n\t else if{episodetype==\'O\' || episodetype==\'E\')\n\t {\n\t\t document.forms[0].episodeid.disabled=false;\n\t\t document.forms[0].visitid.disabled=false;\n\t }\n\t else if(episodetype==\'I\' || episodetype==\'D\')\n\t {\n\t\t document.forms[0].visitid.disabled=true;\n\t }\n\t else\n\t {\n\t }\n}\n\nfunction funEpiTypeOE()\n{\n\tvar episodetype = document.forms[0].episodetype.value;\n\tvar episodeid = document.forms[0].episodeid.value;\n\tvar visitid = document.forms[0].visitid.value;\n\t\n\tif((episodetype==\'E\' || episodetype==\'O\') && episodeid==\"\")\n\t{\n\t\talert(\'Episode id should not be blank\');\n\t\tdocument.forms[0].episodeid.focus();\n\t\t\n\t}\n}\nfunction funEpi()\n{\n\tvar episodetype = document.forms[0].episodetype.value;\n\tvar episodeid = document.forms[0].episodeid.value;\n\tvar visitid = document.forms[0].visitid.value;\n\t\n\tif((episodetype==\'E\' || episodetype==\'O\') && visitid==\'\')\n\t{\t\t\n\t\talert(\'Visit id should not be blank\');\n\t\tdocument.forms[0].visitid.focus();\n\t}\n}\n*/\nfunction funmand()\n{\n\tvar episodetype = document.forms[0].episodetype.value;\n\tvar patientid= document.forms[0].patientid.value;\n\tif(episodetype==\"\" && patid==\"\")\n\t{\n\t\t//alert(\"Episode type and Patient id should not be blank\")\n\t}\n}\n\nfunction funQry()\n{\n\tvar retVal = \tnew String();\n\tvar episode1;\n\tvar episodetype = document.forms[0].episodetype.value;\n\tvar episodeid = document.forms[0].episodeid.value;\n\tif(episodeid==\"\") episodetype=\"R\";\n\tvar visitid = document.forms[0].visitid.value;\n\tvar patientid= document.forms[0].patientid.value;\n\n\tvar episode1 =\"\";\n\n\tif(episodetype==\"D\")\n\t{\n\t\tepisode1=getLabel(\"Common.daycare.label\",\"common\");\n\t}\n\telse if(episodetype==\"I\")\n\t{\n\t\tepisode1=getLabel(\"Common.inpatient.label\",\"common\");\n\t}\n\telse if(episodetype==\"E\")\n\t{\n\t\tepisode1=getLabel(\"Common.emergency.label\",\"common\");\n\t}\n\telse if(episodetype==\"O\")\n\t{\n\t\tepisode1=getLabel(\"Common.Outpatient.label\",\"common\");\n\t}\n\telse if(episodetype==\"R\")\n\t{\n\t\tepisode1=getLabel(\"Common.external.label\",\"common\");\n\t}\n\n\tvar title=getLabel(\"eBL.PAT_ENCOUNTER_FIN_DTLS.label\",\"BL\");\n\tparent.frames[2].location.href=\"../../eBL/jsp/BLFinDtlsQryBanner.jsp?title=\"+title+\"&episodetype=\"+episodetype+\"&\"+\"episodeid=\"+episodeid+\"&\"+\"visitid=\"+visitid+\"&\"+\"patientid=\"+patientid+\"&\"+\"episode1=\"+episode1;\n}\n\nfunction displayToolTip(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt)\n{\n\tbuildTable(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt);\n\tresizeWindow();\n}\n\nfunction buildTable(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt)\n{\n\n\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=3 cellspacing=0 border=\'1\'   class=\'columnHeader\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'20%\'>Deposit Adjust</td>\";\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'20%\'>Discount Amount</td>\";\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'20%\'>Exempt Amount</td>\"\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'20%\'>Adjust Amount</td>\";\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'20%\'>Write-off Amt Rounded</td>\"\n\n\ttab_dat     += \"<tr>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+dep_adjust+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+disc_amt+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+exmpt_amt+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+adj_amt+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+write_off_amt+\"</td>\";\n\ttab_dat     += \"</tr> \";\n\ttab_dat     += \"</table> \";\n\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n}\n\nfunction resizeWindow()\n{\n\tbodwidth = parent.frames[0].document.body.offsetWidth;\n\tbodheight = parent.frames[0].document.body.offsetHeight;\n\n\tvar x =event.x;\n\tvar y =event.y;\n\n\tx = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\ty = y + (document.getElementById(\"tooltiplayer\").offsetHeight);\n\n\tif(x<bodwidth)\n\t{\n\t\tx =event.x;\n\t}\n\telse\n\t{\n\t\tx = x - (document.getElementById(\"tooltiplayer\").offsetWidth*2);\n\t}\n\n\tif(y<bodheight)\n\t{\n\t\t y =event.y;\n\t}\n\telse\n\t{\n\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2);\n\t}\n\n\ty+=document.body.scrollTop;\n\tx+=document.body.scrollLeft;\n\n\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x;\n\tdocument.getElementById(\"tooltiplayer\").style.posTop = y;\n\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n}\n\nfunction hideToolTip()\t\n{\n\t  document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n}\n\n</script>\n\n\n\n\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form >\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\n\t\t<tr>\n\t\t<td width=\'25%\'  class=\'label\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td>\n\t\t<td  width=\'25%\' class=\'fields\'>\n\t\t   <select name=\'episodetype\' id=\'episodetype\' onchange=\'\'>\n\t\t   <option value=\'\'>-------------------";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="-------------------</option>\n\t\t   <option value=\'E\'>Emergency</option>\n\t\t   <option value=\'O\'>OutPatient</option>\n\t\t   <option value=\'I\'>Inpatient</option>\n\t\t   <option value=\'D\'>Daycare</option>\n\t\t   <option value=\'R\'>External</option>\n\t\t   </select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t   <td width=\'25%\'   class=\'label\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t <td  width=\'25%\'  class=\"fields\"><input type=\'text\' name=\'patientid\' id=\'patientid\' size=\'20\' maxlength=\'30\' value=\'\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t   \n\t\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'episodeid\' id=\'episodeid\' size=\'8\' maxlength=\'30\'style=\'text-align:right\'  value=\'\' onBlur=\'\'></td>\n\t\t<td width=\'25%\' class=\'label\'> <b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b> </td>\n\t\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'visitid\' id=\'visitid\' size=\'4\' maxlength=\'30\' style=\'text-align:right\'  value=\'\' onBlur=\'\'></td>\n\t</tr>\t\n\t\t<tr>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\n\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\' onclick=\'funQry()\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ></td>\n\t\t</tr>\n\t\n\t<tr>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\'></td>\n\t\t<td width=\'25%\' align=\'right\'><a href=\'#\' onMouseOver=\'displayToolTip(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =",";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' onMouseOut=\'hideToolTip()\'> >>> </a></td>\n\t</tr>\n\n\t\n\t</table>\n\t\t<input type=\'hidden\' name=\'cashcounter_array\' id=\'cashcounter_array\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=\'hidden\' name=\'temp_logout_time\' id=\'temp_logout_time\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:relative; width:75%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=3 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	//String strCashCounterCode = "";
	String strCashCounterArray = "";
	String strLogoutTime  = "";
	
	//Connection con = null;
	//PreparedStatement pstmt = null ;
	//ResultSet rs = null;
	//String sql="";
	//Statement stmt	= null;

	String dep_adjust="1000.50";
	String disc_amt="200.75";
	String exmpt_amt="50.90";
	String adj_amt="10.91";
	String write_off_amt="5.50";

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");

	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}



            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
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
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.query.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dep_adjust));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disc_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(exmpt_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adj_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(write_off_amt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strCashCounterArray));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strLogoutTime));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FIN_DTLS_QRY.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
}
