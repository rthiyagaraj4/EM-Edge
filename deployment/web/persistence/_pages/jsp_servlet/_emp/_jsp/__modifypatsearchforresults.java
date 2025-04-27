package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __modifypatsearchforresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/modifyPatSearchForResults.jsp", 1709118629854L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'> </script>\n<script src=\'../js/PatSearchForResult.js\' language=\'javascript\'></script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<html><head>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head><body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<SCRIPT>\nvar i=0;\nfunction clk()\n{\n\tif (patient_form.fld_nm.value !=\'Pat_Photo\')\n\t{\n\t\tif (patient_form.select1.checked == false)\n\t\t{\n\t\t\tpatient_form.order1.disabled=true;\n\t\t\tpatient_form.order1.value =\"\";\n\t\t}\n\t\telse if (patient_form.select1.checked == true)\n\t\t{\n\t\t\tpatient_form.order1.disabled=false;\n\t\t}\n\t}\n\telse\n\t\tpatient_form.order1.value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n/*\tvar prop=\"\";\n\t//var prop=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t//if(!patient_form.select1.checked)\n\t//\tpatient_form.order1.value=\"\"\n\n\ti++;\n\tvar newval=patient_form.long_desc.value\n\tvar oldval=patient_form.long_desc1.value\n\n\tvar onval=patient_form.order1.value\n\tvar ooval=patient_form.order2.value\n\n\tif(prop==\"readonly\" && patient_form.select1.checked)\n\t\tpatient_form.order1.value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\telse\n\t{\n\t\tif(i>1 && oldval!=newval)\n\t\t{\n\t\t\tpatient_form.long_desc.value=patient_form.long_desc1.value\n\t\t}\n\t\tif(i>1 && ooval!=onval)\n\t\t{\n\t\t\tpatient_form.order1.value=patient_form.order2.value\n\t\t\tif(!patient_form.select1.checked)\n\t\t\tpatient_form.order1.value=\"\"\n\t\t}\n\t}*/\n}\n\nfunction chkk(comp)\n{\n/*\t//var prop=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\tvar prop=\"\";\n\tif(!patient_form.select1.checked)\n\t{\n\t\tcomp.blur();patient_form.order1.value=\"\"\n\t}\n\telse\n\t\tif(prop==\"readonly\")\n\t\t\tpatient_form.order1.value=\'18\';\n*/\n}\n</SCRIPT>\n\n</head>\n\n<body onKeyDown=\'lockKey()\'>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onLoad=\"Focusing(\'fld_nm\');\">\n\t\t<form name=\'patient_form\' id=\'patient_form\' action=\'../../servlet/eMP.PatSearchForResultsServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\t\t<div align=\'center\'>\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t<td width=\'20%\'>&nbsp;</td>\n\t\t\t</tr>\n\n    \t\t\t\t<tr>\n    \t\t\t\t     <td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n    \t\t\t\t     <td width=\'60%\' class=\'fields\' colspan=\'2\'>\n    \t\t\t\t     <input type=\'text\' name=\'fld_nm\' id=\'fld_nm\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=\'30\'maxlength=\'30\' readonly >&nbsp;<img src=\'../images/mandatory.gif\'></img> </td>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t    <td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t    <!--td width=\'60%\' align=\'left\' colspan=\'2\'>&nbsp;&nbsp;</td-->\n\t\t\t\t    <td>&nbsp;</td>\n  \t\t\t\t  </tr>\n   \t\t\t\t<tr>\n    \t\t\t\t     <td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n      \t\t\t\t     <td width=\'60%\'class=\'fields\' colspan=\'2\'>\n                                     <input type=\'text\' name=\'long_desc\' id=\'long_desc\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=\'30\' onFocus=\'chkk(this)\' maxlength=\'30\' style=\'{ font-size: ;}\'  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >&nbsp;<img src=\'../images/mandatory.gif\' ></td>\n                                     <input type=\'hidden\' name=\'long_desc1\' id=\'long_desc1\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" size=\'30\' maxlength=\'30\' style=\'{ font-size: ;}\'  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n\t\t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t    </tr>\n    \t\t\t\t<tr>\n      \t\t\t\t     <td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t     <td width=\'60%\' class=\'fields\'  colspan=\"2\">\n\t\t\t\t\t ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n      \t\t\t\t     <input type=\'text\' name=\'order1\' id=\'order1\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\'2\' maxlength=\'2\' onkeypress=\"return allowValidNumber(this,event,2, 0);\" onFocus=\'chkk(this)\' onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">&nbsp;</td>\n      \t\t\t\t     <input type=\'hidden\' name=\'order2\' id=\'order2\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\'2\' maxlength=\'2\'>\n      \t\t\t\t     <input type=\'hidden\' name=\'order3\' id=\'order3\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  >\n\t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\n\t\t\t</table>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\t\t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\' >\n\t\t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' >\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'1\'>\n\t\t<input type=\'hidden\' name=\'stop\' id=\'stop\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String code="";
	String longdesc="";
	String order="";
	String eff_status="";
	String s="",s1="",d1="";
	String rdonly="";

	PreparedStatement pstmt=null;
	ResultSet rset=null;

	PreparedStatement pstmt1 = null;
	ResultSet rset1 = null;

	int maxVal = 0;
	Connection conn =null;
	try
	{
	    code=request.getParameter("field_name");
	    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	    //Connection conn = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
	    pstmt = conn.prepareStatement("select field_name,field_desc,field_order,field_select from mp_pat_search_result where field_name=? ");
	    pstmt.setString(1, code);
		pstmt1 = conn.prepareStatement("select count(*) from mp_pat_search_result");
	    rset=pstmt.executeQuery();
		rset1 = pstmt1.executeQuery();
		if (rset1.next()){
			maxVal = rset1.getInt(1);
		}
	    if(rset != null)
	    	{
		   rset.next();
		   code = rset.getString("field_name");
		   longdesc = rset.getString("field_desc");
		   order =rset.getString("field_order");
		   eff_status=rset.getString("field_select");

		   if(code.equalsIgnoreCase("pat_photo"))
			{
		   		rdonly="readonly";
			}
		   if(order==null)
		   	order="";
		 }
	}
	catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174210669 on 30-08-2023
	}
	finally
	{
		if(pstmt !=null) pstmt.close();
		if(rset !=null)	rset.close();

		if(pstmt1 !=null) pstmt1.close();
		if(rset1 !=null)	rset1.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(maxVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((maxVal)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				    s="";
				    out.println("<td width='60%' class='fields'  colspan='2'><input type='checkbox' name='select1' id='select1' value='Y' ");
				    if(eff_status.equals("Y"))
				    	{s1="checked";}
				    else
				    	{/*s="readonly";*/}
				 	out.println(s1+" value='Y' onclick='clk()'>&nbsp</td>");
				    
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
out.print(s);
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
out.print(s);
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

					    if(eff_status.equals("N"))
							{d1="disabled";}
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order));
            _bw.write(_wl_block25Bytes, _wl_block25);
out.print(s);
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(d1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((maxVal)));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldName.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldTitle.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
}
