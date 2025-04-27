package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patsearchtabsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatSearchTabsFrame.jsp", 1732691591830L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t\t  \n\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>       \n\t\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t\t<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\n\t\t\n\t\t\t<Script src=\"../../eMP/js/json02.js\"></Script>\n\t\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t\t\t<script src=\"../../eMP/js/PatientSearch.js\" language=\"JavaScript\"></Script>\n            <Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n\n\n\t\t</head>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<body onKeyDown=\'lockKey()\' onload =\"ChangeTabs(\'AdvanceTab\')\" >\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<!-- <body onKeyDown=\'lockKey()\' onload =\"ChangeTabs(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" >-->\n\t\t\t<body onKeyDown=\'lockKey()\' onload =\"ChangeTabs(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" >\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<form name=\"Tabs_Form\" id=\"Tabs_Form\">\n\t\t\t\t\t <ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px; font-size: 0.7rem;\">\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Basic Search\">\n\t\t\t\t\t\t\t\t<a onclick=\"ChangeTabs(\'BasicTab\')\" class=\"tabclicked\" id=\'BasicTab\' >\n\t\t\t\t\t\t\t\t\t<span class=\"tabspanclicked\" id=\"BasicTabspan\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Advance Search\">\n\t\t\t\t\t<a onclick=\"ChangeTabs(\'AdvanceTab\')\" class=\"tabA\" id=\"AdvanceTab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"AdvanceTabspan\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n\t\t\t<script>prevTabObj=\'BasicTab\'</script>\n\t\t\t\t<input type=\"hidden\" name=\"jsp_name\" id=\"jsp_name\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t<input type=\"hidden\" name=\"window_styl\" id=\"window_styl\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t<input type=\"hidden\" name=\"close_yn\" id=\"close_yn\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t<input type=\"hidden\" name=\"win_top\" id=\"win_top\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t<input type=\"hidden\" name=\"win_width\" id=\"win_width\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t<input type=\"hidden\" name=\"win_height\" id=\"win_height\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t<input type=\"hidden\" name=\"act_yn\" id=\"act_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t<input type=\"hidden\" name=\"srr\" id=\"srr\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t<input type=\"hidden\" name=\"register_button_yn\" id=\"register_button_yn\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t<input type=\"hidden\" name=\"func_act\" id=\"func_act\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t<input type=\"hidden\" name=\"default_gender\" id=\"default_gender\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t<input type=\"hidden\" name=\"enable_gender_yn\" id=\"enable_gender_yn\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\"hidden\" name=\"dr_function_id\" id=\"dr_function_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t<input type=\"hidden\" name=\"func_idpassed\" id=\"func_idpassed\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\t\n\t<!--Added for this CRF HSA-CRF-0289-->\n\t<input type=\"hidden\" name=\"alterIdSearch\" id=\"alterIdSearch\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t<input type=\"hidden\" name=\"isAlternateId\" id=\"isAlternateId\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\t\n\t<input type=\"hidden\" name=\"alternate_no\" id=\"alternate_no\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\t\n\t<!-- Added by Ashwin K for AAKH-CRF-0150 -->\n\t<input type=\"hidden\" name=\"smart_contact_no\" id=\"smart_contact_no\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\t\t\n\t<!-- Ended by Ashwin K for AAKH-CRF-0150 -->\n\t<!--//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn-->\n\t<input type=\"hidden\" name=\"suspend_inactive_pat_yn\" id=\"suspend_inactive_pat_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\t\t\n\t<!-- Added by Sethu for EDGE Requirements -->\n\t<input type=\"hidden\" name=\"tab_id_clicked\" id=\"tab_id_clicked\">\t\t\n\t\t\t</form>\n\t\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
  
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
	String jsp_name						=request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");
	String window_styl					=request.getParameter("window_styl")==null?"":request.getParameter("window_styl");
	String close_yn							=request.getParameter("close_yn")==null?"":request.getParameter("close_yn");
	String win_height						=request.getParameter("win_height")==null?"":request.getParameter("win_height");
	String win_width						=request.getParameter("win_width")==null?"":request.getParameter("win_width");
	String win_top							=request.getParameter("win_top")==null?"":request.getParameter("win_top");
	String act_yn  							=request.getParameter("act_yn")==null?"":request.getParameter("act_yn"); 
	String srr									=request.getParameter("srr")==null?"":request.getParameter("srr");
	String register_button_yn			=request.getParameter("register_button_yn")==null?"":request.getParameter("register_button_yn");
	String func_act							=request.getParameter("func_act")==null?"":request.getParameter("func_act");
	String defaultgender				=request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String enablegenderyn			=request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
	String dr_function_id=request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
	String func_idpassed=request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
	// Added for IN0 by Suresh M on 20.12.2010
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");

	String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");//Added by Ashwin K for AAKH-CRF-0150
	//Maheshwaran K added for MMS-DM-CRF-0208.1 
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");
	
	
	//End HSA-CRF-0289
     String pat_search_tab ="";
	 Connection con			   = null;
     ResultSet rset			   = null ;
      PreparedStatement pstmt    = null;
	try
	{
	con					    = ConnectionManager.getConnection(request); 
    pstmt                   = con.prepareStatement("select  PAT_SEARCH_DFLT_TAB from mp_param");
    rset                    = pstmt.executeQuery();
	if(rset.next())
	 pat_search_tab=rset.getString("PAT_SEARCH_DFLT_TAB");
	 if(pat_search_tab.equals("B"))
	 pat_search_tab="BasicTab";
	  else
      pat_search_tab="AdvanceTab";
		   if(rset != null) rset.close();
		   if(pstmt != null) pstmt.close();
		   
	}catch(Exception e) 
	{
	e.printStackTrace();
	}
  if(con!=null) ConnectionManager.returnConnection(con,request);
		
 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block7Bytes, _wl_block7);

	    	if(session.getValue("sekure_ws_yn")!= null) {
				if(session.getValue("sekure_ws_yn").equals("Y")){
					out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
				}
			}
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(!patient_class.equals("")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_search_tab));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_search_tab));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(window_styl));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(close_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(act_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(srr));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(register_button_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultgender));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(enablegenderyn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dr_function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alternate_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(suspend_inactive_pat_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.basic.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.advanced.label", java.lang.String .class,"key"));
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
}
