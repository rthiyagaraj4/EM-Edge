package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __paintnewbornmotherbabylink extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PaintNewbornMotherBabyLink.jsp", 1733139390588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<HEAD>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t<iframe src=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&accessRights=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=\"babylink1_frame\" noresize scrolling=\"no\" style=\'height:12vh;width:99vw\'></iframe>\n\t\t<iframe src=\"../../eMP/jsp/NewbornMotherBabyLink.jsp?mother_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" name=\"babylink2_frame\" scrolling=\"auto\" style=\'height:70vh;width:99vw\'></iframe>\n\t\t<iframe src=\"../../eMP/jsp/NewbornMotherBabyLinkTools.jsp?mother_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\"babylink3_frame\" scrolling=\"no\" style=\'height:10vh;width:99vw\'></iframe>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<iframe src=\"../../eMP/jsp/NewbornMotherBabyLink.jsp?mother_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"babylink2_frame\" scrolling=\"auto\" style=\'height:80vh;width:99vw\'></iframe>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<iframe src=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"babylink2_frame\" scrolling=\"auto\" style=\'height:70vh;width:99vw\'></iframe>\n\t\t<iframe src=\"../../eMP/jsp/NewbornMotherBabyLinkTools.jsp?close=Y&mother_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

    	//String locale			= (String)session.getAttribute("LOCALE");
	    //String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	    String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";

		//Added for CA
		String patient_id				= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		//
		String motherid				= request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		if(motherid==null)motherid="";
		if (motherid.equals("") && !patient_id.equals("")) motherid = patient_id;
		String function_id			=request.getParameter("function_id")==null?"": request.getParameter("function_id");
		if(function_id==null)function_id="";
		String encounterid						= "";
		Connection con = null;
		String Facility_Id = (String) session.getValue("facility_id"); 		
		PreparedStatement pstmt	= null;
		ResultSet rset		= null;
		String ip_install_yn = request.getParameter("ipInstallYn")==null?"N": request.getParameter("ipInstallYn");
		/*	Commented for PE on 29/02/2010 by Muthu
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP'");
			rset = pstmt.executeQuery();
			if (rset!=null && rset.next())
			{
				ip_install_yn = rset.getString(1);
				if (ip_install_yn==null) ip_install_yn = "";
			}
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
		}
		*/
		try{
			con = ConnectionManager.getConnection(request);
			if (ip_install_yn.equals("Y"))
			{
				String sql1 = "Select encounter_id from IP_OPEN_ENCOUNTER where	Patient_Id = '"+motherid+"' and facility_id = '"+Facility_Id+"'";
				pstmt			= con.prepareStatement(sql1);
				rset				= pstmt.executeQuery();
				if(rset!=null && rset.next())
				{
					encounterid			= rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				}
			}
			if (encounterid.equals(""))
			{
				encounterid = "Patient_ID="+motherid;
			}
			else
			{
				encounterid = "EncounterId="+encounterid;
			}
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rset != null) rset.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
if(function_id.equals("") && patient_id.equals(""))
{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block12Bytes, _wl_block12);

}
else
{
	if (!patient_id.equals(""))
	{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(motherid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
}
				
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MotherBabyLink.label", java.lang.String .class,"key"));
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
}
