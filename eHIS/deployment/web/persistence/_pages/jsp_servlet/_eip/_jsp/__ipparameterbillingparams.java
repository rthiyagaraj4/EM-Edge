package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __ipparameterbillingparams extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPParameterBillingParams.jsp", 1742387872517L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../js/IPParam.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\n\tvar errorFlag\t=\tfalse;\n\tvar errorSource\t=\t\"\";\n\t function changesetfield()\n\t {\n\t\tif(document.ipparam_form.bl_interfaced_yn.checked==false)\n\t\t {\n\n\t\t\tdocument.ipparam_form.setup_bl_dtls_in_ip_yn.checked=false\n\t\t\tdocument.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=true;\n\t\t }\n\t\t else\n\t\t document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=false;\n\t }\n\n\tfunction InterfacetoBL()\n\t{\n\t\tif(document.ipparam_form.bl_interfaced_yn.checked==true &&  document.ipparam_form.setup_bl_dtls_in_ip_yn.checked==true)\n\t\t{\n\t\t\tdocument.getElementById(\'blpar\').style.visibility=\'visible\';\n\t\t\tdocument.getElementById(\'blparam\').style.visibility=\'visible\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\'blpar\').style.visibility=\'hidden\';\n\t\t\tdocument.getElementById(\'blparam\').style.visibility=\'hidden\';\n\t\t}\n\t}\n\n\n\tfunction selfClose()\n\t{\n\t\tvar ret_bl_interfaced_yn = \"N\";\n\t\t\n\t\tvar ret_setup_bl_dtls_in_ip_yn = \"N\";\n\n\t\tvar ret_outst_amt_limit    = \tdocument.ipparam_form.outst_amt_limit.value\n\t\t\tif(ret_outst_amt_limit == \"\")\n\t\t\t{\n\t\t\t\tret_outst_amt_limit = \"-\";\n\t\t\t}\n\t\tvar ret_policy_expiry_warning_period =  document.ipparam_form.policy_expiry_warning_period.value\n\t\t\tif(ret_policy_expiry_warning_period == \"\")\n\t\t\t{\n\t\t\t\tret_policy_expiry_warning_period=\"-\";\n\t\t\t}\n\n\t\tvar ret_credit_auth_reqd_yn =document.ipparam_form.credit_auth_reqd_yn.value\n\t\t\tif(!(document.ipparam_form.credit_auth_reqd_yn.checked))\n\t\t\t{\n\t\t\t\tret_credit_auth_reqd_yn = \"N\";\n\t\t\t}\n\t\tif(document.ipparam_form.bl_interfaced_yn.checked)\n\t\t{\n\t\t\tret_bl_interfaced_yn = \"Y\";\n\t\t\tif(document.ipparam_form.setup_bl_dtls_in_ip_yn.checked)\n\t\t\t{\n\t\t\t\tret_setup_bl_dtls_in_ip_yn = \"Y\";\n\t\t\t}\n\t\t}\n\t\t\n\t\tparent.window.returnValue = ret_bl_interfaced_yn+\"@\"+ret_setup_bl_dtls_in_ip_yn+\"@\"+ret_outst_amt_limit+\"@\"+ret_policy_expiry_warning_period+\"@\"+ret_credit_auth_reqd_yn\n\n\t\tparent.window.close();\n\t\treturn 1;\n\t}\n</script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<title>Billing Parameters</title>\n<body  onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n<form name=\'ipparam_form\' id=\'ipparam_form\'  method=\"post\"  target=\"messageFrame\">\t\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'99%\' border=\'0\'>\n\n\t<tr>\n\t<th colspan=\'4\' align=\'left\'>Billing Parameters</th>\n\t<tr>\n\t\t<td nowrap class=\'label\' align=\'right\' width =\'45%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td nowrap class=\'label\' align=\'left\' width =\'5%\'>&nbsp;<input type=\'checkbox\' size=\'1\' maxlength=\'1\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" onclick=\"InterfacetoBL();changesetfield()\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" tabIndex =\'0\'>\n\t\t</td>\n\t\t<td nowrap class=\'label\' align=\'right\' width =\'45%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td nowrap class=\'label\' align=\'left\' width =\'7%\'>&nbsp;<input type=\'checkbox\' size=\'1\' maxlength=\'1\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" onclick=\"InterfacetoBL()\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" tabIndex =\'0\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t</td>\n\t</tr>\n\t<tr id=\'blpar\' style=visibility:hidden;>\n\t\t<td nowrap class=\'label\' align=\'right\' width =\'43%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td nowrap  class=\'label\' align=\'right\' width =\'7%\'>&nbsp;<input type=\'text\' size=\'5\' maxlength=\'5\' name=\'outst_amt_limit\' id=\'outst_amt_limit\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onKeyPress=\'return(ChkNumberInput(this,event,2))\'>\n\t\t</td>\n\t\t<td nowrap class=\'label\' align=\'right\' width =\'43%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td nowrap class=\'label\' align=\'left\' width =\'4%\'>&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'policy_expiry_warning_period\' id=\'policy_expiry_warning_period\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' >&nbsp;Days\n\t\t</td>\n\t</tr>\n\t<tr id=\'blparam\' style=visibility:hidden;>\n\t\t<td nowrap class=\'label\' align=\'right\' colspan=\'3\' nowrap >When Outstanding Amount exceeds limit,Credit Authorization Required</td><td nowrap class=\'label\' align=\'left\'>&nbsp;<input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'credit_auth_reqd_yn\' id=\'credit_auth_reqd_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">\n\t\t</td>\t\t\n\t</tr>\n<tr>\n\t\t<td >&nbsp;</td>\n\t\t<td colspan=3 align=right><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  onclick=\"javascript:return selfClose();\"></td>\t\t\n\t\t</tr>\n\t<script>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</script>\t\t\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t</table>\n\t</form>\t\n\t</body>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</html>\n\n\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8"); 
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rset		= null;
	String facility_id	= (String)session.getAttribute("facility_id");

	try
	{
	con= ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	String chk_booking_limit_by="";

	String bl_interfaced_yn="";
	String setup_bl_dtls_in_ip_yn="";
	String outst_amt_limit="";
	String policy_expiry_warning_period="";
	String credit_auth_reqd_yn="";
	String bl_fields="";
	String bl_set="disabled";
	String bkg_grace_period ="";

	String sql="select * from ip_param where facility_id='"+facility_id+"' ";	
	rset = stmt.executeQuery(sql);	
	if(rset!=null )
	{
		if(rset.next())
		{
			chk_booking_limit_by=rset.getString("chk_booking_limit_by");
			if(chk_booking_limit_by == null) chk_booking_limit_by = "";
			
			bl_interfaced_yn=rset.getString("bl_interfaced_yn");
			if(bl_interfaced_yn == null)
	
			bl_interfaced_yn = "N";
			bl_interfaced_yn = bl_interfaced_yn.equals("Y") ?"checked" :"" ;
	
			bkg_grace_period = rset.getString("bkg_grace_period");
			if(bkg_grace_period == null ) bkg_grace_period ="";

			setup_bl_dtls_in_ip_yn=rset.getString("setup_bl_dtls_in_ip_yn");
			if(setup_bl_dtls_in_ip_yn == null) setup_bl_dtls_in_ip_yn = "N";
			setup_bl_dtls_in_ip_yn = setup_bl_dtls_in_ip_yn.equals("Y") ?"checked" :"" ;
		
			

			}
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
		}	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bl_fields));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bl_fields));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bl_set));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outst_amt_limit));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(policy_expiry_warning_period));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(credit_auth_reqd_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(bl_interfaced_yn.equals("checked") && setup_bl_dtls_in_ip_yn.equals("checked"))
			{
				out.println("document.getElementById('blpar').style.visibility='visible';		document.getElementById('blparam').style.visibility='visible';");
			}
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 out.println("<script> if(document.ipparam_form.bl_interfaced_yn.checked==true)	{document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=false; \n }		else { document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=true;\n }		</script>"); 
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{
		if(stmt	!= null) stmt.close();
		if(rset		!= null)rset.close();
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InterfacetoBillingModule.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SetupBillingDtls.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OutstandingamountLimit.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InsuranceExpiryWarning.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
