package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __populateeventclass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PopulateEventClass.jsp", 1736338566681L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
			Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

	PreparedStatement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
	try
	{

		con	=	ConnectionManager.getConnection(request);
	
		String event_class="",short_desc="";
		String query_event_class="";
		String hist_type	= 	request.getParameter("hist_type");
		String event_called=request.getParameter("event_called")==null?"":request.getParameter("event_called");	
		String event_class_defaulted=request.getParameter("event_class_defaulted")==null?"":request.getParameter("event_class_defaulted");
		

		if(hist_type==null) hist_type="";
		hist_type=hist_type.trim();

		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<script language='javascript'>");
				
//		stmt = con.createStatement();
		/*if(hist_type.equals("CLNT"))
		{
			query_event_class = "select EVENT_CLASS, SHORT_DESC from ca_event_class where event_class in ('PHY$', 'NUR$', 'CLI$', 'REF$')";
		}
		else if(hist_type.equals("SUNT"))
		{
			query_event_class = "select EVENT_CLASS, SHORT_DESC from ca_event_class where event_class in ('PROC')";
		}

		else
		{
			query_event_class = "select  service_code event_class, short_desc from AM_SERVICE order by short_desc";
		}*/
		
//		query_event_class = "select EVENT_CLASS, long_desc SHORT_DESC from cr_event_class where hist_rec_type='"+hist_type+"' order by long_desc ";
//		rs = stmt.executeQuery(query_event_class);

		query_event_class = "select EVENT_CLASS, long_desc, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by long_desc ";
		stmt = con.prepareStatement(query_event_class);
		stmt.setString(1,hist_type);
		stmt.setString(2,locale);
		rs = stmt.executeQuery();

		out.println("var event_class	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		out.println("if(top.content!=null&& top.document.getElementById('dialog-body') == null){");
		out.println("var opt=top.content.workAreaFrame.criteria_f1.document.createElement('OPTION'); ");
		out.println("}else{");
		if(!event_called.equals(""))
		{
			out.println("var opt=parent.criteria_f0.criteria_f1.document.createElement('OPTION'); ");
		}
		else
		{
			out.println("var opt=top.parent.frames[1].criteria_f1.document.createElement('OPTION'); ");
		}
		out.println("}");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	event_class; ");
		out.println("if(top.content!=null&& top.document.getElementById('dialog-body') == null){");
		out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.add(opt); ");
		out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		out.println("}else{");		
		//out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		//out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		if(!event_called.equals("")){
		out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.add(opt); ");
		out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		}
		else{

			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");

		}
		
		out.println("}");
		
		
		while(rs.next())
		{
			
			event_class	=	rs.getString("event_class");
			short_desc	=	rs.getString("short_desc");

			out.println("var event_class	=\""+event_class+"\";");
			out.println("var short_desc	=\""+short_desc+"\";");
			out.println("if(top.content!=null && top.document.getElementById('dialog-body') == null){");
			out.println("var opt = top.content.workAreaFrame.criteria_f1.document.createElement('OPTION'); ");
			out.println("}else{");
			if(!event_called.equals(""))
				out.println("var opt = parent.criteria_f0.criteria_f1.document.createElement('OPTION'); ");
			else
				out.println("var opt = top.parent.frames[1].criteria_f1.document.createElement('OPTION'); ");
			out.println("}");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	event_class; ");
			if(event_class_defaulted.equals(event_class))
				out.println("opt.selected='selected'");

			out.println("if(top.content!=null && top.document.getElementById('dialog-body') == null){");
			out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("}else{");
			if(!event_called.equals(""))
			out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.add(opt); ");
			else
			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("}");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
	
	
	if(rs!=null) rs.close();
	if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'>");
	//	out.println("Exception@1 : "+e);
               	e.printStackTrace();//COMMON-ICN-0181
		out.println("</body></html>");
	}
	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
