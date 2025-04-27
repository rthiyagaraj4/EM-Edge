package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventgroupindtabaddelement extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventGroupIndTabAddElement.jsp", 1709115734433L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventGroup.js\'></script>\n\n<body OnMouseDown=\'CodeArrest()\' onLoad=\'\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'ClinicalEventGroupAddElementForm\' id=\'ClinicalEventGroupAddElementForm\'  >\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr><td class=\'CAGROUP \'align=center><b><font size=\'2\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td></tr> </table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr>\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr>\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr>\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<tr>\n   \n\t\t<td class=label align=\'right\' width=\'25%\' nowrap>Contr System</td>\n\t\t<td align=left>&nbsp;&nbsp;<select name=\'contr\' id=\'contr\'  onchange=\'\'>\n\t\t<option value=\"\">------------Select-------------</option>\n        </select>\n        </td>\n</tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n   \n\t\t<td class=label align=\'right\' width=\'25%\' nowrap>Contr System</td>\n\t\t<td align=left>&nbsp;&nbsp;<input type=\'text\' name=\"contr\" id=\"contr\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\'10\' maxlength=\'10\' onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n        \n\t\t</td>\n</tr> \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n\t<td   align=\'right\' class=\'label\' >Event Group</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\' name=\"groupcode\" id=\"groupcode\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=\'15\' maxlength=\'20\' onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><input type=\"button\" value=\"?\" class=\"button\" onClick=\"callGroup()\" name=\'search\' id=\'search\'>\n\t</td>\n\t</tr>\n<!-- \t\n\t<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr> -->\n<tr>\n\t<td  align=\'right\' class=\'label\'>Short Desc</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'shortdesc\' id=\'shortdesc\' size=\"15\" maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t</td>\n</tr>\n\n\n\t<tr >\n\t<td>&nbsp;</td>\n\t<td >&nbsp;&nbsp;\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=\'button\' name=\'add\' id=\'add\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' class=\'button\' onClick=\'addEventGroup()\'>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'Clear\' class=\'button\' onClick=\' clearFields()\' >\n\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'Delete\' class=\'button\' onClick=\' deleteRecord()\' >\n\t<br>\n\t<br>\n\t<br>\n\t<br>\n\t<br>\n\t\n\t</td>\n\t</tr>\n\t\t\n\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\n</tr>\n</table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n<input type=\'hidden\' name=\'code\' id=\'code\' value=\'frompanel\' >\n<input type=\'hidden\' name=\'disp_flag\' id=\'disp_flag\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n<input type=\'hidden\' name=\'clearvalue\' id=\'clearvalue\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n<input type=\'hidden\' name=\'delval\' id=\'delval\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<script>populateCntrSys(parent.criteria.document.EventIndTabCriteriaForm.histype)</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String mode="";
	String contr="";
	String groupcode="";
	String shortdesc="";
	String clearvalue="";
//	String mand_status="";
	String disp_status="";
	
	String value="Add";
	String title=" Add New Event Group";
	String serailno="";
	String flag="";
	String from="";

	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	serailno=(request.getParameter("srno")==null)?"":request.getParameter("srno");
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	//out.println("<script>alert('modechk"+mode+"')</script>");
	//out.println("<script>alert('flag"+flag+"')</script>");
	//out.println("<script>alert('flag"+flag+"')</script>");
	contr=(request.getParameter("contr")==null)?"":request.getParameter("contr");
	groupcode=(request.getParameter("groupcode")==null)?"":request.getParameter("groupcode");
	shortdesc=(request.getParameter("shortdesc")==null)?"":request.getParameter("shortdesc");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	from=(request.getParameter("from")==null)?"":request.getParameter("from");
    if(from.equals("criteria"))
	EventBean.clearAll();
		

		if(flag.equals("frompanel"))
		{
			
			 disp_status ="readonly";
			 value="Modify";
			 title="Modify Exisiting Event Group";
			 
		}
		else
		{
			value="Add";
			title="Add New Event Group";
		}
		


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);

if(!flag.equals("frompanel"))
{

            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(contr));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(groupcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disp_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disp_status));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(!flag.equals("frompanel")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(value));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clearvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(serailno));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(!flag.equals("frompanel")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
