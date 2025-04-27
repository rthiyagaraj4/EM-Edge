package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public final class __datepopulation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DatePopulation.jsp", 1709119232053L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html><head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n</head>\n<body class=\'message\'  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].prefdate.value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].prefdate1.value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].prefenddate.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].prefenddate1.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\n\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\ttop.content.workAreaFrame.frames[1].document.forms[0].prefdate.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\ttop.content.workAreaFrame.frames[1].document.forms[0].prefdate1.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\ttop.content.workAreaFrame.frames[1].document.forms[0].prefenddate.value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\ttop.content.workAreaFrame.frames[1].document.forms[0].prefenddate1.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\n\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

Connection con = null;
Statement stmt = null;
ResultSet rs=null;
String prefstartdate="";
String prefenddate="";
String prefstartdate_disp="";
String prefenddate_disp="";

try{
	request.setCharacterEncoding("UTF-8");	

	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
	 String locale=(String)session.getAttribute("LOCALE");
	String param = request.getParameter("param");
	String no= request.getParameter("no");
	String frmCA=request.getParameter("frmCa");

	stmt = con.createStatement();
	String sql_date="select to_char(sysdate+decode('"+param+"','D',"+no+",'W',"+no+"*7,'M',(add_months(sysdate,"+no+")-sysdate)),'dd/mm/yyyy') from_date,to_char(add_months(sysdate+	(decode('"+param+"','D',"+no+",'W',"+no+"*7,'M',(add_months(sysdate,"+no+")-sysdate))),1),'dd/mm/yyyy')  to_date from dual ";
	rs = stmt.executeQuery(sql_date); 
	while (rs!=null && rs.next()){
		 prefstartdate=rs.getString("from_date");
		 prefenddate=rs.getString("to_date");
	}

prefstartdate_disp=DateUtils.convertDate(prefstartdate,"DMY","en",locale);
prefenddate_disp=DateUtils.convertDate(prefenddate,"DMY","en",locale);


	// If condtion added by Jithesh on 18-Nov-03 to handle from  CA -->

		if(frmCA.equals("N")){
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(prefstartdate));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(prefstartdate_disp));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(prefenddate));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(prefenddate_disp));
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prefstartdate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(prefstartdate_disp));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(prefenddate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(prefenddate_disp));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(stmt !=null) stmt.close();
}catch( Exception e ){
out.println(e.toString());
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
