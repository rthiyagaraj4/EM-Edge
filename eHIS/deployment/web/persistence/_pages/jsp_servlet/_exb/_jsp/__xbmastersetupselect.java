package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import eXB.*;
import eXB.XBDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __xbmastersetupselect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/XBMasterSetUpSelect.jsp", 1709122252462L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<HTML> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eXB/js/XBMasterSetUp.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n \t\t\t  \n  \n<script>\n/*\tfunction chkVal(obj){\n\t\tif(obj.checked==true){\n//\t\t\talert(\"checked\");\n\t\t\tthis.document.forms[0].enabled_yn.value = \'Y\';\n\t\t}else{\n//\t\t\talert(\"Unchecked\");\n\t\t\tthis.document.forms[0].enabled_yn.value = \'N\';\n\t\t}\n\t}\t\t*/\t\t\t\t\t\t   \n</script>\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'  >\n<!-- onLoad=\'formLoad()\' -->\n<form name=\"Mastersetup_form\" id=\"Mastersetup_form\" target=\'messageFrame\' method=\'post\' action=\'../../servlet/eXB.MasterSetUpAddModifyServlet\'>\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<input type=\"hidden\" name=\"fun_id\" id=\"fun_id\" id=\"fun_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n<tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t<td width=\'20%\'></td>\n\t<td width=\'45%\'></td>\n\t<td width=\'20%\'></td>\n\t<td width=\'20%\'></td>\n</tr> \t\t\t\t\t\t\t\t\t\t\t\t \n\n<tr>\n\t<td class=label >Facility</td>\n\t<td align=left>\n\t\t<input type=\"hidden\" name=\"facility_Id\" id=\"facility_Id\"  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=text id=\"facility_Name\"  name =facility_Name size=35 maxlength=30 value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onBlur=\'searchFacility();\' title=\'Facility Type\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="> <input  type=\"button\"  name=faclityNameSearch value=\'?\'    onClick=\'searchFacility();\'>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t</td>\n\t<td> </td> <td> </td>\n</tr>\n\n<tr>\n\t<td class=label >Module Type</td>\n\t<td align=left>\n\t\t<input type=\"hidden\" name=\"module_Id\" id=\"module_Id\"  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=text id=\"module_Name\"  name =module_Name size=35 maxlength=30 value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onBlur=\'searchModuleType();\' title=\'Module Type\'> <input  type=\"button\"  name=moduleNameSearch value=\'?\'    onClick=\'searchModuleType();\'>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t</td>\n\t<td> </td> <td> </td>\n</tr>\n\n<tr>\n<td class=label >Payer Group</td>\n<td align=left>\n\t<input type=\"hidden\" name=\"payer_group_code\" id=\"payer_group_code\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=text id=\"payer_group_desc\"  name =payer_group_desc size=35  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onBlur=\'searchPayerGroup();\' title=\'Payer Group\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" > <input  type=\"button\"  name=payerGroupSearch value=\'?\'    onClick=\'searchPayerGroup();\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n\t<td> </td> <td> </td>\n</tr>\n\n<tr>\n<td class=\'label\' >Payer</td>\n<td align=left>\n\t<input type=\"hidden\" name=\"payer_code\" id=\"payer_code\"  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=text id=\"payer_desc\"  name =payer_desc size=35  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onBlur=\'searchPayer();\' title=\'Payer\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" > <input  type=\"button\"  name=payerSearch value=\'?\'    onClick=\'searchPayer();\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n  \t<td></td> <td></td> \n</tr> \t\t\n\n<tr>\n<td class=label >Policy</td>\n<td align=left>\n\t<input type=\"hidden\" name=\"policy_code\" id=\"policy_code\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=text id=\"policy_desc\"  name =policy_desc size=35  value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onBlur=\'searchPolicy();\' title=\'Policy Type\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" > <input  type=\"button\"  name=policySearch value=\'?\'    onClick=\'searchPolicy();\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n<td></td> <td></td>\n</tr> \n\n<tr>\n<td class=label >Episode Type</td>\n <td align=left>\n\t<select name=\"episode_type\" id=\"episode_type\"  style=\"width:100\"  title=\'Episode Type\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t  <option value=\'\'>-------";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="-------</option>\n      <option value=\'I\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n      <option value=\'O\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t</select> <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n  </td>  \n<td> </td><td> </td>\n</tr>\t\t\t\t\t\t\t\t\n\n<tr>\n\t<td class=label>Enabled</td>\n\t<td align=left><INPUT TYPE=\"checkbox\" name=\"enabled_yn\" id=\"enabled_yn\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" > </td> <!-- onClick=\'chkVal(this);\'  -->\n\t<td></td> <td></td> \n</tr>\n\n<tr>\n\t<td width=\'20%\'></td>\n\t<td width=\'45%\'></td>\n\t<td width=\'20%\'></td>\n\t<td width=\'20%\'></td>\n</tr>\n</table> \n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n<input type=hidden name=act_mode value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\n</form>\t\t\t\t\t\t\t\t\t  \n<script>\n\n</script>\n</BODY> \n</HTML> \t\t\t\t\t\t  \n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 //String locale = ((String)session.getAttribute("LOCALE"));
            _bw.write(_wl_block2Bytes, _wl_block2);
 

String payer_group_code = "";
String payer_group_desc = "";
String payer_code  = "";
String payer_desc   = "";
String policy_code  = "";
String policy_desc  = "";
String episode_type = "";
String enableYN  = "";
String facility_Id	= "";
String facility_Name = "";

String mode=XBDBAdapter.checkNull(request.getParameter("mode"));				
	System.out.println("XBMasterSetUpSelect.jsp mode :"+mode);
String fun_id=XBDBAdapter.checkNull((String)session.getAttribute("fun_id"));  

String module_Id = "";
String module_Name = "";

if(mode.equals("U"))
{
	module_Id=XBDBAdapter.checkNull(request.getParameter("module_Id"));
	module_Name=XBDBAdapter.checkNull(request.getParameter("module_Name"));
	payer_group_code=XBDBAdapter.checkNull(request.getParameter("payer_group_code"));
	payer_group_desc=XBDBAdapter.checkNull(request.getParameter("payer_group_desc"));
	payer_code=XBDBAdapter.checkNull(request.getParameter("payer_code"));
	payer_desc=XBDBAdapter.checkNull(request.getParameter("payer_desc"));
	policy_code=XBDBAdapter.checkNull(request.getParameter("policy_code"));
	policy_desc=XBDBAdapter.checkNull(request.getParameter("policy_desc"));
	episode_type=XBDBAdapter.checkNull(request.getParameter("episode_type"));
//	System.out.println("episode_type : "+episode_type);
	enableYN=XBDBAdapter.checkNull(request.getParameter("enabled_yn"));
	if(enableYN.equalsIgnoreCase("Y")){
		enableYN = "checked";
	}
	else{ 
		enableYN = "";
	}
	facility_Id=XBDBAdapter.checkNull(request.getParameter("facility_Id"));
		System.out.println("facility_Id : "+facility_Id);
	facility_Name=XBDBAdapter.checkNull(request.getParameter("facility_Name"));
		System.out.println("facility_Name : "+facility_Name);
}
if(mode.equals("I"))
{
	enableYN = "checked";
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;


            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fun_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(XBDBAdapter.checkNull(facility_Id)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(XBDBAdapter.checkNull(facility_Name)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(XBDBAdapter.checkNull(module_Id)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(XBDBAdapter.checkNull(module_Name)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(XBDBAdapter.checkNull(payer_group_code)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(XBDBAdapter.checkNull(payer_group_desc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(XBDBAdapter.checkNull(payer_code)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(XBDBAdapter.checkNull(payer_desc)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(XBDBAdapter.checkNull(policy_code)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(XBDBAdapter.checkNull(policy_desc)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(mode.equals("U")?"disabled":""));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(episode_type.equals("I")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(episode_type.equals("O")?"selected":""));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(enableYN));
            _bw.write(_wl_block32Bytes, _wl_block32);

		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatient.label", java.lang.String .class,"key"));
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
}
