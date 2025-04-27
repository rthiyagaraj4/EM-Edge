package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __staffrosterdatevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffRosterDateValidation.jsp", 1709121665089L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\t\nparent.frames[0].document.forms[0].to_date1.value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\nparent.frames[0].document.forms[0].getFlag.value=\'Y\';\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\tparent.frames[0].document.forms[0].from_date1.value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\nparent.frames[0].document.forms[0].new_todate.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\nparent.parent.frames[0].document.forms[0].getFlag.value=\'Y\';\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\tparent.frames[0].document.forms[0].d_next.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tparent.frames[0].document.forms[0].from_date_for_prev.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\n\tparent.frames[0].document.forms[0].new_todate.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\tparent.frames[0].document.forms[0].new_from_date_for_next.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t parent.frames[0].document.forms[0].d_prev.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
Connection con = null;
ResultSet rs1=null;
ResultSet rssql1=null;
PreparedStatement pstsql1 = null;
try
{
    con=ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String from_date=(String) hash.get("from_date");
	String steps=(String) hash.get("steps");
	String to_date=(String) hash.get("to_date");
	String from_date_for_prev="";
	if(from_date ==null) from_date="";
	if(to_date==null) to_date="";
	if(steps==null) steps="";
	String to_date_cal="";
	String next_fromdate="";

    if(steps.equals("1"))
	{
	String Date_sql="select decode(  sign( (to_date(?,'dd/mm/yyyy')+29 ) - to_date(?,'dd/mm/yyyy')),1,?,to_char(to_date(?,'dd/mm/yyyy') + 29,'dd/mm/yyyy')) todate from dual";
	
	pstsql1 = con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	pstsql1.setString(2,to_date);
	pstsql1.setString(3,to_date);
	pstsql1.setString(4,from_date);

	rssql1 = pstsql1.executeQuery();

	while(rssql1.next())
	{
		to_date_cal=rssql1.getString("todate");
	}

	if(pstsql1 != null)
		pstsql1.close();
	if(rssql1!= null)
		rssql1.close();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(to_date_cal));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')+1),'dd/mm/yyyy')from_date from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	rs1=pstsql1.executeQuery();
	if(rs1.next())
	next_fromdate=rs1.getString("from_date");
		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(next_fromdate));
            _bw.write(_wl_block6Bytes, _wl_block6);

}     
if(steps.equals("2"))
	{
	
	String Date_sql="select decode(  sign( (to_date(?,'dd/mm/yyyy')+29 ) - to_date(?,'dd/mm/yyyy')),1,?,to_char(to_date(?,'dd/mm/yyyy') + 29,'dd/mm/yyyy')) todate from dual";
	
	pstsql1 = con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	pstsql1.setString(2,to_date);
	pstsql1.setString(3,to_date);
	pstsql1.setString(4,from_date);
	rssql1 = pstsql1.executeQuery();
	while(rssql1.next()){
		to_date_cal=rssql1.getString("todate");		
	}
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(to_date_cal));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')+1),'dd/mm/yyyy')from_date,to_char(to_date(to_date(?,'dd/mm/yyyy')-1),'dd/mm/yyyy')from_date_for_prev from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	pstsql1.setString(2,from_date);
	rs1=pstsql1.executeQuery();
		next_fromdate=rs1.getString("from_date");
		from_date_for_prev=rs1.getString("from_date_for_prev");

		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();

	if(rs1.next())
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(next_fromdate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(from_date_for_prev));
            _bw.write(_wl_block11Bytes, _wl_block11);

}     
if(steps.equals("3"))
	{
	String Date_sql="select to_char(to_date(to_date(to_date(to_date(?,'dd/mm/yyyy')-1,'dd/mm/yyyy')-29,'dd/mm/yyyy')),'dd/mm/yyyy') todate from dual";
	pstsql1=con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	rssql1 = pstsql1.executeQuery();

	while(rssql1.next()){
		to_date_cal=rssql1.getString("todate");		
	}
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();


            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(to_date_cal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')-1),'dd/mm/yyyy')from_date from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	rs1=pstsql1.executeQuery();
	if(rs1.next())
	next_fromdate=rs1.getString("from_date");
		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(next_fromdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
}     
}catch( Exception e ){
out.println(e.toString());
}
finally
{
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();
		if(rs1 != null)
			rs1.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
