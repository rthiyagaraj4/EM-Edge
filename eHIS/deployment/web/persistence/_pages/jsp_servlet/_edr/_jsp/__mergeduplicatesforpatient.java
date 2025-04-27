package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __mergeduplicatesforpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergeDuplicatesForPatient.jsp", 1733808651262L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicatePatient.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\t\t\t\talert(errortext);\n\t\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\t\t\talert(errortext);\n\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS_ALL_FCY\',\'DR\');\n\t\t\t\t\t\talert(errortext);\n\t\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errortext = getMessage(\'NO_USER_RIGHTS_ALL_FCY\',\'DR\');\n\t\t\t\t\talert(errortext);\n\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'DR_PARAM_NOT_AVAILABLE\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'SEARCH_MERGE_JOB_EXISTS\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'CYCLE_IN_PROGRESS\',\'DR\');\n\t\t\t\talert(errortext);\n\t\t\t\t\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  scrolling=no noresize style=\'height:7vh;width:100vw\' frameBorder=\"0\"></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eDR/jsp/MergeDuplicatePatIdQuery.jsp\'  scrolling=\'no\' noresize style=\'height:4vh;width:100vw\' frameBorder=\"0\"></iframe>\n\t\t<iframe name=\'duplicate_searach_ctiteria\' id=\'duplicate_searach_ctiteria\' src=\'../../eCommon/html/blank.html\'  scrolling=\'auto\' noresize style=\'height:45vh;width:100vw\' frameBorder=\"0\"></iframe>\n\t\t<iframe name=\'duplicate_searach_result\' id=\'duplicate_searach_result\' src=\'../../eCommon/html/blank.html\' scrolling=\'auto\' noresize style=\'height:30vh;width:100vw\' frameBorder=\"0\"></iframe>\n\t\t<iframe name=\'duplicate_searach_image\' id=\'duplicate_searach_image\' src=\'../../eCommon/html/blank.html\' scrolling=\'no\' noresize style=\'height:5vh;width:100vw\' frameBorder=\"0\"></iframe>  \n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\'  noresize style=\'height:8vh;width:100vw\' frameBorder=\"0\"></iframe>\n\t\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;

	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;

	String str						= "";
	String check_rights				= "";
	String proc_status				= "";
	String effstatus				= "";	 
	String identify_privilege_level	= "";
	String search_privilege_level	= "";

	boolean check_rights_flag = false;

	Properties p	= (Properties) session.getValue("jdbc");
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String addedById	= p.getProperty("login_user");
		String facilityid 	= (String) session.getValue("facility_id");

		int p_count			= 0;
	
		str = "SELECT eff_status, search_privilege_level, merge_privilege_level, identify_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			check_rights				= rs.getString("merge_privilege_level");
			identify_privilege_level	= rs.getString("identify_privilege_level");
			search_privilege_level		= rs.getString("search_privilege_level");
			effstatus					= rs.getString("eff_status");

			check_rights_flag	= true;
		} if(rs != null) rs.close();

	   if(search_privilege_level != null && ((search_privilege_level .equals("L")) || (search_privilege_level .equals("A"))) )
		{
		   if(identify_privilege_level != null && ((identify_privilege_level.equals("L")) || (identify_privilege_level.equals("A"))) )
			{
				if(check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
				{
					
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
			}
			else 
			{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}
		else
		{
			
            _bw.write(_wl_block12Bytes, _wl_block12);

		}

		if(check_rights.equals("L") && check_rights_flag==true )
		{
			str = "SELECT search_facility_id, search_type FROM dr_process_ctl ";
			rs  = stmt.executeQuery(str);

			String p_s_f_id			= "X";
			String p_search_type	= "X";

			while(rs.next())
			{
				p_s_f_id		= rs.getString("search_facility_id");
				p_search_type	= rs.getString("search_type");
			} if(rs != null) rs.close();

			if(!p_s_f_id.equals("X") || !p_search_type.equals("X"))
			{
				if(!p_s_f_id.equals(facilityid) || !p_search_type.equals("L"))
				{
					
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
			}
			else
			{
				
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
		}

		str = "select count(*) total from dr_param ";
		rs  = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");	
		} if(rs != null) rs.close();

		if(p_count == 0)
		{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		
		str = "select proc_status  from dr_process_ctl  " ;
		rs	= stmt.executeQuery(str);
		while(rs.next())
		{
			proc_status = rs.getString("proc_status");
		} if(rs != null) rs.close();

		if(proc_status.equals("S0"))
		{
			
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
			
		if((!proc_status.equals("AB")) && (!proc_status.equals("CS")))
		{
			
            _bw.write(_wl_block17Bytes, _wl_block17);

		}

		str = "select count(*) total from dr_process_ctl";
		rs  = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");
		} 

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(source));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.DefaultSearchCriteria.label", java.lang.String .class,"key"));
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
