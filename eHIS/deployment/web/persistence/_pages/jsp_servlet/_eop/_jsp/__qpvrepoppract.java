package jsp_servlet._eop._jsp;

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
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __qpvrepoppract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/QPVrepopPract.jsp", 1709119468976L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    <script>\n    var n=parent.frames[1].document.frames[0].document.forms[0].oppract.options.length;\n    for(var i=0;i<n;i++)\n    {\n        parent.frames[1].document.frames[0].document.forms[0].oppract.remove(\"oppract\");    \n    }\n    var tp =\" --- \"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\" --- \";\n    var opt=parent.frames[1].document.frames[0].document.createElement(\"OPTION\");\n    opt.text=tp;\n    opt.value=\"\";\n    parent.frames[1].document.frames[0].document.forms[0].oppract.add(opt);\n    </script>           \n    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	Connection con  =  null;
	ResultSet rs = null;
	Statement stmt = null;
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

try{

	String Facility_Id=(String)session.getValue("facility_id");
    String cln_code=request.getParameter("cln_code");
    String pract_yn=request.getParameter("pract_yn");
    String pract_type=request.getParameter("pract_type");
    StringBuffer sql = new StringBuffer();
    String locale = (String) session.getValue("LOCALE");
	con  =  ConnectionManager.getConnection(request);
	stmt = con.createStatement();

    if(pract_type.equals("null")) pract_type="";
    if(cln_code.equals(""))
		{
       // sql.append("select practitioner_id,practitioner_name,pract_type from am_pract_for_facility_vw where operating_facility_id = '"+Facility_Id+"' and eff_status='E' order by 2");
		sql.append(" SELECT   a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name,		  pract_type	FROM 	  am_pract_for_facility a,am_practitioner b		WHERE 	  facility_id ='"+Facility_Id+"' AND a.practitioner_id=b.practitioner_id AND	 a.eff_status='E'			ORDER BY 2");
		
		}
	else 
        if(pract_yn.equals("Y"))
		{
            sql.append( "select b.practitioner_id,b.practitioner_name,b.pract_type from am_pract_for_facility a,am_practitioner b, op_clinic c ");
            sql.append( "where a.practitioner_id=b.practitioner_id and b.pract_type=c.pract_type(+) and c.clinic_code = '"+cln_code+"' ");
            sql.append( "and b.pract_type=nvl('"+pract_type+"',b.pract_type) and a.facility_id='"+Facility_Id+"' and a.eff_status='E' order by 2");
        }
        else {
            sql.append( "select b.practitioner_id,b.practitioner_name,b.pract_type from op_pract_for_clinic a,am_practitioner b ");
            sql.append("where a.clinic_code = '"+cln_code+"' ");
            sql.append("and b.pract_type=nvl('"+pract_type+"',b.pract_type) and ");
            sql.append("b.practitioner_id = a.practitioner_id and ");
            sql.append("a.facility_id='"+Facility_Id+"' and a.eff_status='E' order by 2");
           
        }
       
    rs = stmt.executeQuery(sql.toString());
    String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
    +"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>";
    out.println(a1);


            _bw.write(_wl_block6Bytes, _wl_block6);
  if(rs != null) {    
        while( rs.next() ) 
        {
            String str1 = rs.getString("practitioner_id") ;
            String str2 = rs.getString("practitioner_name");
            out.println("<script>var element = parent.frames[1].document.frames[0].document.createElement('OPTION');"+
                    "element.text = \""+str2+"\";"+ 
                    "element.value= \""+str1+"\";"+
                    "parent.frames[1].document.frames[0].document.forms[0].oppract .add(element);</script>");
        }
    }

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	
	sql.setLength(0);
        
}
catch(Exception e){
	out.println(e);
}
finally{
	try{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
	}catch(Exception e){}
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
