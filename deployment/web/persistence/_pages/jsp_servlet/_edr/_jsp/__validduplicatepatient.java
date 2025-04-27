package jsp_servlet._edr._jsp;

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

public final class __validduplicatepatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/ValidDuplicatePatient.jsp", 1734172803939L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </title>\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t <script language=\'javascript\' src=\'../../eDR/js/IdentifyValidDuplicates.js\'></script>\n\t<Script language=\'javascript\' src=\"../../eCommon/js/common.js\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\talert(errortext);\n\t\twindow.close();\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>\n\t\tvar errortext = getMessage(\'DR_PARAM_NOT_AVAILABLE\',\'DR\');\n\t\talert(errortext);\n\t\twindow.close();\n\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n \t<script>\n\t\tvar errortext = getMessage(\'DR_PARAM_NOT_AVAILABLE\',\'DR\');\n\t\talert(errortext);\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS_ALL_FCY\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\twindow.close();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS_ALL_FCY\',\'DR\');\n\t\t\talert(errortext);\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\talert(errortext);\n\t\t\twindow.close();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\talert(errortext);\n\t\t\twindow.close();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'SEARCH_MERGE_JOB_EXISTS\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\tvar errortext = getMessage(\'NO_SEARCH_PROCESS\',\'DR\');\n\t\t\talert(errortext);\n\t\t\twindow.close();\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_SEARCH_PROCESS\',\'DR\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<script>\n\t\tvar errortext = getMessage(\'NO_SEARCH_PROCESS\',\'DR\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\n\t\t\t\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  scrolling=no noresize style=\'height:0vh;width:100vw\' frameborder=\"0\"></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eDR/jsp/IdentifyValidDuplicatesFrameset.jsp?modal=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  scrolling=\'NO\' style=\'height:85vh;width:100vw\' frameborder=\"0\"></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\'  noresize style=\'height:5vh;width:100vw\' frameborder=\"0\"></iframe>\n\t\t\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  scrolling=no noresize style=\'height:8vh;width:100vw\' frameborder=\"0\"></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eDR/jsp/IdentifyValidDuplicatesFrameset.jsp\'  scrolling=\'NO\' style=\'height:85vh;width:100vw\' frameborder=\"0\"></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\'  noresize style=\'height:7vh;width:100vw\' frameborder=\"0\"></iframe>\n\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params ;

	String str = "";
	String check_rights = "";

	boolean check_rights_flag = false;
	
	String modal=request.getParameter("modal");
	if(modal == null || modal.equals("null")) modal = "";
	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	Properties p	= (Properties) session.getValue("jdbc" ) ;
	
	String proc_status	= "";
	String effstatus	= "";	 
	
try
{
	con		= ConnectionManager.getConnection(request);
	stmt	= con.createStatement();
	
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");
	
	int p_count =0;
		
	str = "select eff_status,identify_privilege_level from dr_user_rights where appl_user_id='"+addedById+"' ";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		check_rights = rs.getString("identify_privilege_level");	
		effstatus    = rs.getString("eff_status");

		check_rights_flag	= true;
	} if(rs != null) rs.close();

	if (check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
	{
		if(modal != null && modal.equals("Y")){

            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	}
}
	str = "select count(*) total from dr_param ";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		p_count = rs.getInt("total");	
	
	} if(rs != null) rs.close();
	
	if (p_count == 0 )
	{

	if(modal.equals("Y")){

            _bw.write(_wl_block11Bytes, _wl_block11);

	}else{

            _bw.write(_wl_block12Bytes, _wl_block12);
	}
}

if(check_rights.equals("L") && check_rights_flag == true )
{
	
	str = "select search_facility_id,search_type from dr_process_ctl ";
	
	rs = stmt.executeQuery(str);
	
	String p_s_f_id = "X";
	String p_search_type = "X";
	while(rs.next())
	{
		p_s_f_id = rs.getString("search_facility_id");
		p_search_type = rs.getString("search_type");
	} if(rs != null) rs.close();
	
	if(!p_s_f_id.equals("X") || !p_search_type.equals("X"))
	{

	if(!(p_s_f_id.equals(facilityid)))
	{
		if(modal.equals("Y"))
		{
			
            _bw.write(_wl_block13Bytes, _wl_block13);

		}else{
		
            _bw.write(_wl_block14Bytes, _wl_block14);

	}	
}else{
	if(!p_search_type.equals("L"))
	{
		if(modal.equals("Y")){
		
            _bw.write(_wl_block15Bytes, _wl_block15);

	}else{
	
            _bw.write(_wl_block16Bytes, _wl_block16);

	}	
}
}
}
else
{
	if(modal.equals("Y"))
	{
		
            _bw.write(_wl_block17Bytes, _wl_block17);

	}else{
	
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
}
}	

	str = "select proc_status from dr_process_ctl " ;
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		proc_status = rs.getString("proc_status");
		
	} if(rs != null) rs.close();
	
	if(proc_status.equals("S0"))
	{
		if(!modal.equals("Y"))
		{
			
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
	}
	else if(proc_status.equals("S2") || proc_status.equals("CS") || proc_status.equals("AB") )
	{
		if(modal.equals("Y")){
		
            _bw.write(_wl_block20Bytes, _wl_block20);

	}else{

            _bw.write(_wl_block21Bytes, _wl_block21);

	}
}
	str = "select count(*) total from dr_process_ctl";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		p_count = rs.getInt("total");
		
	} if(rs != null) rs.close();
	
	if(p_count == 0)
	{
		if(!modal.equals("Y")){

            _bw.write(_wl_block22Bytes, _wl_block22);

	}
}

if(modal.equals("Y")){

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(source));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block25Bytes, _wl_block25);

}
else if(modal.equals("")){

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(source));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}if (rs != null) rs.close();
if (stmt != null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

			
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.IdentifyDuplicate.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
