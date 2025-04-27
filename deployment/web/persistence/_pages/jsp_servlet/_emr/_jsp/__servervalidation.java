package jsp_servlet._emr._jsp;

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
import com.ehis.util.*;

public final class __servervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ServerValidation.jsp", 1722345129835L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
   Connection conn=null;
   Statement stmt=null;
   ResultSet rset=null;
   String locale=(String)session.getAttribute("LOCALE"); 

String param = request.getParameter("param");
if(param == null) param="";
String entered_date = request.getParameter("entered_date");
if(entered_date == null) entered_date="";
String calculateFlag = request.getParameter("calculateFlag");
if(calculateFlag == null) calculateFlag="";
String event_sdate =request.getParameter("event_sdate");
if(event_sdate == null) event_sdate="";



try
{
  conn=ConnectionManager.getConnection(request);
  
String sql="",dateValue="";

if(calculateFlag.equals("from"))
	sql="select to_char(sysdate-decode('"+param+"','D',"+entered_date+",'Y',"+entered_date+"*365,'M',(add_months(sysdate,"+entered_date+")-sysdate)),'dd/mm/yyyy') from_date from dual ";
else
	sql="select to_char(to_date('"+event_sdate+"','dd/mm/yyyy')+decode('"+param+"','D',"+entered_date+",'Y',"+entered_date+"*365,'M',(add_months(sysdate,"+entered_date+")-sysdate)),'dd/mm/yyyy') to_date from dual ";

//out.println("<script>alert(\""+sql+"\");</script>");

stmt = conn.createStatement();
rset = stmt.executeQuery(sql);
if(rset !=null)
	if(rset.next())
		dateValue= rset.getString(1);
	if(!(dateValue==null || dateValue.equals("")))
		dateValue = DateUtils.convertDate(dateValue,"DMY","en",locale);

out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onKeyDown = 'lockKey()'  CLASS='MESSAGE'><form name='nam1' id='nam1'>");
if(calculateFlag.equals("from"))
	{
	//	dateValue = "01"+dateValue.substring(2,dateValue.length());
		/*out.println("<script>parent.frames[1].document.frames[2].document.forms[0].event_sdate.value='"+dateValue+"'; parent.frames[1].document.frames[2].document.forms[0].event_sdate.focus() </script>");*/
		/*out.println("<script>"parent.query.document.addmodify.document.getElementById('event_sdate').value=+dateValue+;parent.query.document.addmodify.document.getElementById('event_sdate').focus() "</script>");*/
		out.println("<script>" +"parent.f_query_add_mod.addmodify.document.getElementById('event_sdate').value = '" + dateValue + "';" +"parent.f_query_add_mod.addmodify.document.getElementById('event_sdate').focus();" + "</script>");
	}
else	
	{
//	dateValue = "01"+dateValue.substring(2,dateValue.length());
	out.println("<script>parent.f_query_add_mod.addmodify.document.getElementById('event_edate').value='"+dateValue+"'; parent.f_query_add_mod.addmodify.document.getElementById('event_edate').focus() </script>");
	}
	

}catch(Exception e){
			e.toString();
	     }
	     finally{
			 try
			 {
		if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
			 }
			 catch(Exception e){
			
	     }

			ConnectionManager.returnConnection(conn,request);
	     }
					

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
