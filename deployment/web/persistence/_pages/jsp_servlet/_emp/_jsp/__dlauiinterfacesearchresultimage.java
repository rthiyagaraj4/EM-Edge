package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eMP.DLAInterfaceUtil;
import java.io.*;
import org.apache.commons.codec.binary.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __dlauiinterfacesearchresultimage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DlauiInterfaceSearchResultImage.jsp", 1742362516603L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/dlainterface.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n\tvar msg = getMessage(\"SQL_DB_CONN_FAIL\",\"MP\");\n\tparent.message_frame.location.href = \'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<HEAD>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onLoad=\"dispAttr()\">\n\n<form name=\"view_dla_interface_result_form1\" id=\"view_dla_interface_result_form1\" id=\"view_dla_interface_result_form1\" action=\"../../servlet/eMP.DLATransactionServlet\" method=\"post\">\n<div id=\"image_body\" name=\"image_body\" style=\"visibility:hidden\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table cellspacing=0 cellpadding=4 width=\'100%\' align=center>\n<tr>\n<td class=\'COLUMNHEADER\' width=\'30%\'>&nbsp;</td>\n<td class=\'COLUMNHEADER\' width=\'30%\'>&nbsp;</td>\n</tr>\n\n<!--\n<div id=\"space1\" style=\"display:block;\" height=\"100%\"width=\"100%\">\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n</div>\n<div id=\"image1\" style=\"display:none;\" width=\"100%\">\n<img id=\'imgid\' src=\'C:\\Documents and Settings\\ravindranatho\\My Documents\\My Pictures\\10tata.jpg\'></td>\n</div>\n-->\n\n\n\n<tr>\n<td>\n<!-- <applet code=\"ImageApplet.class\" codebase=\"../applet/\" archive=\"ImageApplet.jar\" height=\"180\" width=\"180\" >\n\t<param name=\"imageData\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n</applet>  -->\n <!--Commented and added the below code for SRR20056-SCF-5529 [IN:024247] by Suresh M on 09.12.2010-->\n <div id=\"pat_photo\" align = \'center\'>\n <script>\n\t document.getElementById(\'pat_photo\').innerHTML= \'<img id=\"patient_photo\" src = \"../../eMP/jsp/DLAPaintImage.jsp\" height=\"180\" width=\"180\" >\';\n</script>  \n<div> \n</td>\n<td>&nbsp;&nbsp;</td>\n<!-- <td><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR></td> -->\n</tr>\n<tr>\n<td>&nbsp;&nbsp;</td>\n<td>&nbsp;</td>\n</tr>\n</table>\n<table cellspacing=0 cellpadding=4 width=\'100%\' align=right>\n<tr>\n<td>&nbsp;&nbsp;</td>\n<td align=\"right\">\n<input class=\'BUTTON\' type=\"button\" name=image_accept id=\"image_accept\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\"getAccept()\">\n<input class=\'BUTTON\' type=\"submit\" name=Image id=\"image_close\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n</td>\n</tr>\n<tr>\n<td>&nbsp;&nbsp;</td>\n<td>&nbsp;</td>\n</tr>\n<tr>\n<td>&nbsp;&nbsp;</td>\n<td>&nbsp;</td>\n</tr>\n<tr>\n<td>&nbsp;&nbsp;</td>\n<td>&nbsp;</td>\n</tr>\n\n</table>\n\n<!--\n<input type=\'hidden\' name=\'national_id_name\' id=\'national_id_name\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'user_name\' id=\'user_name\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'serach_mode\' id=\'serach_mode\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'sur_name1\' id=\'sur_name1\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' id=\"image_path\" name=\'image_path\' id=\'image_path\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n-->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<SCRIPT>\n\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n</SCRIPT>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</div>\n<input type=\"hidden\" name=\"isFromOracleDB\" id=\"isFromOracleDB\" id=\"isFromOracleDB\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"nat_id\" id=\"nat_id\" id=\"nat_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"national_id\" id=\"national_id\" id=\"national_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" id=\"mode\" value=\"close\">\n<input type=\"hidden\" name=\"dla_image_yn\" id=\"dla_image_yn\" id=\"dla_image_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> \n\n</form>\n</body>\n\t";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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

String locale = ((String)session.getAttribute("LOCALE"));
String nat_id = "";
boolean recordExists = true;
String exception = (String)session.getAttribute("exception");
String dla_image_yn = "N";
if(exception != null)
{

            _bw.write(_wl_block6Bytes, _wl_block6);
}
	else
	{

            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String user_name=request.getParameter("user_name"); if(user_name==null) user_name="";
	String pass_word=request.getParameter("pass_word"); if(pass_word==null) pass_word="";
	String serach_mode=request.getParameter("search_by"); if(serach_mode==null) serach_mode="";

	String national_id_name=request.getParameter("national_id_name"); if(national_id_name==null) national_id_name="";
	String first_name=request.getParameter("first_name"); if(first_name==null) first_name="";
	String sur_name=request.getParameter("sur_name"); if(sur_name==null) sur_name="";
	String img = request.getParameter("img");
		
	String national_id = (String)request.getParameter("national_id");	
	String encoded = "";
	boolean isFromOracleDB = Boolean.valueOf(request.getParameter("isFromOracleDB"));



	String function_id = (String)session.getAttribute("dla_function_id");

	String sqlserver_query = "SELECT img_autodisp FROM patient WHERE req_comp_name = ? AND pid='"+national_id+"'";
	

	Connection con = null;
	PreparedStatement stmt = null;
	Statement stmt1 = null;	
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;

	InputStream imgStream = null;
//	FileOutputStream outFile = null;

//	OutputStream o = response.getOutputStream();

	byte[] buff	  = null;
	
//	session.removeAttribute("dla_image_yn");
	try
	{
		session.removeAttribute("dla_image");
		if(!isFromOracleDB)
		{
			String today_datetime1 = (String)session.getAttribute("today_datetime");	
			String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");

			con = DLAInterfaceUtil.getConnection("DLAP");
			if(con != null)
			{
				stmt = con.prepareStatement(sqlserver_query);
				stmt.setString(1,dla_machine_name1+"/"+today_datetime1);
				rs = stmt.executeQuery();

				if(rs.next())
				{					
					recordExists = false;
					imgStream = rs.getBinaryStream("img_autodisp");
				}
				
				if(imgStream != null)
				{			
					Blob pat_photo_blob = rs.getBlob("img_autodisp");
					session.setAttribute("pat_photo_blob",pat_photo_blob);
					buff = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());					
				}
			
				if(buff != null)
				{
					encoded = new String((new Base64()).encode(buff));	
					session.setAttribute("dla_image",encoded);				
					dla_image_yn = "Y";
				}		
			}
			else
			{
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);					
				String errorString = labels.getString("SQL_DB_CONN_FAIL");
				
				String forward = "<script>parent.message_frame.location.href = '../eCommon/jsp/MstCodeError.jsp?err_num="+errorString+"'</script>";
				out.print(forward);
			}
		}
		else
		{
			con = ConnectionManager.getConnection();				
			stmt1 = con.createStatement();								
			rs1 = stmt1.executeQuery("SELECT NAT_ID_PROMPT FROM MP_PARAM_LANG_VW WHERE MODULE_ID='MP' AND LANGUAGE_ID='"+locale+"'");
			if(rs1.next())
			{
				nat_id = rs1.getString("NAT_ID_PROMPT");
			}		
		
			String new_req = (String)session.getAttribute("new_req");

			// Updating the purge status in case of duplicate citizen ID
			if(new_req != null && new_req.equalsIgnoreCase("Y"))
			{												 
				String today_datetime = (String)session.getAttribute("today_datetime");
				String req_search = (String)session.getAttribute("req_search");
				String dla_machine_name = (String)session.getAttribute("dla_machine_name");

				DLAInterfaceUtil.updatePurgeStatus(today_datetime,dla_machine_name,req_search);
				session.removeAttribute("new_req");
			}
		} 	
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs != null) rs.close(); 
			if(rs1 != null) rs1.close();			
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();			
			if(isFromOracleDB) ConnectionManager.returnConnection(con);
			else con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}	
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(!recordExists){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encoded));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(national_id_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pass_word));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(serach_mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sur_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(img));
            _bw.write(_wl_block19Bytes, _wl_block19);

}else if(!isFromOracleDB){

            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(isFromOracleDB));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nat_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dla_image_yn));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
