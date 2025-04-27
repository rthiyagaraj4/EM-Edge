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
import java.util.*;
import com.ehis.util.*;

public final class __blparaminspolydefn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLParamInsPolyDefn.jsp", 1737916257775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident        SCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V230210\t\t\tMMS-DM-CRF-0209.5\tNamrata Charate\n-----------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\'../../eBL/js/PkgParameter.js\'></script> \n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script type=\"text/javascript\">\n\tfunction assignValueToMainForm(obj1, obj2, obj3, obj4){\n\t\tvar mfdr_YN = document.getElementById(obj1);\n\t\tvar drugCat_YN = document.getElementById(obj2);\n\t\tvar diagCat_YN = document.getElementById(obj3);\n\t\tvar service_items_YN = document.getElementById(obj4); //V230210\n\t\t\n\t\t\n\t\tif(mfdr_YN.checked){\n\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].mul_fact_ded_rule_YN.value = \"Y\";\n\t\t\tif(drugCat_YN.checked)\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = \"Y\";\n\t\t\telse\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = \"N\";\n\t\t\t\n\t\t\tif(diagCat_YN.checked)\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = \"Y\";\n\t\t\telse\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = \"N\";\n\t\t\t\n\t\t\t//V230210\n\t\t\tif(service_items_YN.checked)\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = \"Y\";\n\t\t\telse\n\t\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = \"N\";\n\t\t}else{\n\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].mul_fact_ded_rule_YN.value = \"N\";\n\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = \"N\";\n\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = \"N\";\n\t\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = \"N\"; //V230210\n\t\t\t\n\t\t}\n\t\tparent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].is_mul_fact_ded_rule_mod.value = \"Y\";\n\t\t\n\t}\n\t\n\t\n\tfunction fnEnableDisableDrugDiagatServ(obj,dest1,dest2,dest3){\n\t\tvar destBox1 = document.getElementById(dest1);\n\t\tvar destBox2 = document.getElementById(dest2);\n\t\tvar destBox3 = document.getElementById(dest3);\n\t\t\n\t\tif(obj.checked){\n\t\t\tdestBox1.disabled = false;\n\t\t\tdestBox2.disabled = false;\n\t\t\tdestBox3.disabled = false;\n\t\t\t\n\t\t}\n\t\telse{\n\t\t\tdestBox1.checked = \'\';\n\t\t\tdestBox2.checked = \'\';\n\t\t\tdestBox3.checked = \'\';\n\t\t\tdestBox1.disabled = true;\n\t\t\tdestBox2.disabled = true;\n\t\t\tdestBox3.disabled = true;\n\t\t}\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onLoad=\"assignValueToMainForm(\'mul_fact_ded_rule_YN\',\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\')\">\n\t<form name=\'BLParamInsPolyDefn\' id=\'BLParamInsPolyDefn\' >\n\t<table>\n\t<tr>\n\t\t<td  class=\"label\" width=\"50%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\n\t<td  class=\'fields\' width=\"60%\">\n\t\t<input type=\"checkbox\" name=\"mul_fact_ded_rule_YN\" id=\"mul_fact_ded_rule_YN\" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" \n\t\tonClick=\"assignValueToMainForm(\'mul_fact_ded_rule_YN\',\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\');fnEnableDisableDrugDiagatServ(this,\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\');\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td style=\"padding-left:30px;\" class=\"label\" width=\"40%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\n\t\t\n\t<td  style=\"padding-left:30px;\" class=\'fields\' width=\"60%\">\n\t\t<input type=\"checkbox\" name=\"drug_cat_YN\" id=\"drug_cat_YN\"  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onClick=\"assignValueToMainForm(\'mul_fact_ded_rule_YN\',\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\');\" >\n\t</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td  style=\"padding-left:30px;\" class=\"label\" width=\"40%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t<td  style=\"padding-left:30px;\" class=\'fields\' width=\"60%\">\n\t\t<input type=\"checkbox\" name=\"diag_cat_YN\" id=\"diag_cat_YN\"  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onClick=\"assignValueToMainForm(\'mul_fact_ded_rule_YN\',\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\');\" >\n\t</td>\n\t\n\t</tr>\n\t<!-- V230210 -->\n\t<tr>\n\t\t<td  style=\"padding-left:30px;\" class=\"label\" width=\"40%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\t\n\t<td  style=\"padding-left:30px;\" class=\'fields\' width=\"60%\">\n\t\t<input type=\"checkbox\" name=\"service_items_YN\" id=\"service_items_YN\" id=\"service_items_YN\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onClick=\"assignValueToMainForm(\'mul_fact_ded_rule_YN\',\'drug_cat_YN\',\'diag_cat_YN\',\'service_items_YN\');\" >\n\t</td>\n\t\n\t</tr>\n\t\n</table>\n\n</form>\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	boolean isMFDRApplicableForSite = false; 
	String mul_fact_ded_rule_YN = "N";
	String drug_cat_YN = "N";
	String diag_cat_YN = "N";
	String service_items_YN = "N";  //V230210
	String disabled = "";
	try
	{	
		try
		{
			isMFDRApplicableForSite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_MULTI_FACT_DED_RULE");	
		}catch(Exception e){
			System.err.println("Exception while checking isMFDRApplicableForSite:" + isMFDRApplicableForSite);
			e.printStackTrace();
		}	
		mul_fact_ded_rule_YN = request.getParameter("mul_fact_ded_rule_YN");
		if(mul_fact_ded_rule_YN == null) mul_fact_ded_rule_YN = "N";
		drug_cat_YN = request.getParameter("drug_cat_YN");
		if(drug_cat_YN == null) drug_cat_YN = "N";
		diag_cat_YN = request.getParameter("diag_cat_YN");
		if(diag_cat_YN == null) diag_cat_YN = "N";
		System.err.println("mul_fact_ded_rule_YN:"+mul_fact_ded_rule_YN);
		service_items_YN = request.getParameter("service_items_YN");  //V230210
		if(service_items_YN == null) service_items_YN = "N";       //V230210               
		

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mul_fact_ded_rule_YN.equals("Y")?"checked ":""));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mul_fact_ded_rule_YN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(isMFDRApplicableForSite ? "" : "disabled" ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mul_fact_ded_rule_YN.equals("Y")? "":"disabled" ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_cat_YN.equals("Y")?"checked ":""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_cat_YN));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mul_fact_ded_rule_YN.equals("Y")? "":"disabled" ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(diag_cat_YN.equals("Y")?"checked ":""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(diag_cat_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mul_fact_ded_rule_YN.equals("Y")? "":"disabled" ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(service_items_YN.equals("Y")?"checked ":""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_items_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
	catch(Exception e)
	{
		System.out.println("Exception from BLParamInsPolyDefn.jsp :"+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MultiFactorDeductibleRule.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugCategory.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DiagnosisCategory.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServicesandItem.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
