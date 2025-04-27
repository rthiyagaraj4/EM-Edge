package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails7 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails7.jsp", 1731677320529L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n <!-- The following changes are done for Internationalisation Process\nAdded by Manivel Natarajan on 10/Aug/2006\n-->\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t<script>\n\t\n\t</script>\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t\t<!--\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t\t\t-->\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!--The following changes are done for Internationalisation Process\nCommented by Manivel Natarajan on 10/Aug/2006 -->\n<!-- \t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n\n<!-- <FRAMESET ROWS=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" framespacing=0>-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<!-- This JSP is going to be modified for billing_mode = Modify  -->\n\t<!-- <FRAME SRC=\'AddModifyPatFinDetails3.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' name=\'frame21\' frameborder=0 scrolling=\'auto\' noresize> -->\n\t<iframe SRC=\'AddModifyPatFinDetails3.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' name=\'frame21\' id=\'frame21\'  frameborder=0 style=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" scrolling=\'auto\' noresize></iframe>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<!-- <FRAME SRC=\'AddModifyPatFinDetails8.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=0 name=\'frame22\' scrolling=\'no\' noresize>-->\n\t\t\t<iframe SRC=\'AddModifyPatFinDetails8.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0 name=\'frame22\' id=\'frame22\' style=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" scrolling=\'no\' noresize></iframe>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<!-- <FRAME SRC=\'../../eCommon/html/blank.html\' frameborder=0 name=\'frame22\' id=\'frame22\' scrolling=\'no\' noresize>-->\n\t\t<iframe SRC=\'../../eCommon/html/blank.html\' frameborder=0 name=\'frame22\' id=\'frame22\' style=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\n</FRAMESET>  \n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String frame_size = "" /*,extra_frame="N"*/ ;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String style_frame_21 = "", style_frame_22 = "";
    //The following changes are done for Internationalisation Process
    //Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
   try
   {
		//con = (Connection) session.getValue("connection" );
		con	=	ConnectionManager.getConnection(request);
		String non_ins_settlement_ind ="";
		String credit_doc_yn="";
		

		//unused variable, commented on 09/06/05
		//String non_ins_adm_flag ="";
		//String slmt_type_code="", cash_slmt_flag="";

//		System.out.println("Inside 7:"+(String)request.getParameter("billing_group"));
		String non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
		if( non_insur_blng_grp == null) non_insur_blng_grp="";
		

		String sql="select settlement_ind, adm_rec_flag,credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = ? ";
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "N";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		//out.println("sql :"+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, non_insur_blng_grp);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				non_ins_settlement_ind = rs.getString("settlement_ind");
				credit_doc_yn=rs.getString("credit_doc_ref_reqd_yn");
				//unused variable, commented on 09/06/05
				//non_ins_adm_flag = rs.getString("adm_rec_flag");

			}
		}
		if (rs != null)   rs.close();
		pstmt.close();
		if(!(non_ins_settlement_ind.equals("C")))
		{
			frame_size = "100%,0%";//frame_size = "97%,03%";
			style_frame_21 = "height:88vh;width:100%;";
			style_frame_22 = "height:0vh;width:100%;";

		}
		else if(non_ins_settlement_ind.equals("C"))
		{
			if(credit_doc_yn.equals("Y"))
			{
				frame_size = "85%,15%";	
				style_frame_21 = "height:88vh;width:100%;";
				style_frame_22 = "height:5vh;width:100%;";
			}
			else
			{
				frame_size = "50%,50%";//frame_size = "35%,65%";
				style_frame_21 = "height:45vh;width:100%;";
				style_frame_22 = "height:50vh;width:100%;";
			}
		}

	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(frame_size));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String billing_mode = request.getParameter("billing_mode");
	if(billing_mode==null) billing_mode = "Add";

	String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

	String rtn_non_ins_inst_ref="";

	String reset_blng_grp=request.getParameter("reset_blng_grp");
	if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
	if(reset_blng_grp.equals("YES")) 
	{
//		session.removeAttribute("financial_details");
		billing_mode="Add";
		operation="Insert";
	}

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			rtn_non_ins_inst_ref=((String)bl_data.get("non_ins_inst_ref")).trim();

		}

//	String cash_insmt_ref2 = request.getParameter("cash_insmt_ref2");
	String cash_insmt_ref2 = rtn_non_ins_inst_ref;
	if(cash_insmt_ref2==null) cash_insmt_ref2="";

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(style_frame_21));
            _bw.write(_wl_block15Bytes, _wl_block15);

	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
		if(!(cash_insmt_ref2.equals("")))
		{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(style_frame_22));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
		}

	}
	//else
	//{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(style_frame_22));
            _bw.write(_wl_block19Bytes, _wl_block19);

	//}

            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
}
