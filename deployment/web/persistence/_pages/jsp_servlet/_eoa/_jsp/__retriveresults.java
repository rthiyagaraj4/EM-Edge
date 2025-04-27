package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __retriveresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/RetriveResults.jsp", 1709119271287L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t<script>\n\tvar n=parent.frames[1].document.frames[0].document.forms[0].pract.options.length;\n\tfor(var i=0;i<n;i++)\n\t{\n\tparent.frames[1].document.frames[0].document.forms[0].pract.remove(\"pract\");\t\n\t}\n\tvar tp =\" -------Select------ \";\n\tvar opt=parent.frames[1].document.frames[0].document.createElement(\"OPTION\");\n\topt.text=tp;\n\topt.value=\"\";\n\tparent.frames[1].document.frames[0].document.forms[0].pract.add(opt);\t\n\t</script>\t        \n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n\t<script>\n\tvar n=parent.frames[1].document.frames[0].document.forms[0].pract.options.length;\n\tfor(var i=0;i<n;i++)\n\t{\n\tparent.frames[1].document.frames[0].document.forms[0].pract.remove(\"pract\");\t\n\t}\n\tvar tp =\" -------Select------ \";\n\tvar opt=parent.frames[1].document.frames[0].document.createElement(\"OPTION\");\n\topt.text=tp;\n\topt.value=\"\";\n\tparent.frames[1].document.frames[0].document.forms[0].pract.add(opt);\t\n\t</script>\t        \n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String clinic_type = request.getParameter("clinic_type");
if(clinic_type == null || clinic_type.equals("null") || clinic_type.equals("undefined")) clinic_type="";

String open_to_all_pract_yn=request.getParameter("open_to_all_pract_yn");
if(open_to_all_pract_yn == null || open_to_all_pract_yn.equals("") || open_to_all_pract_yn.equals("undefined")) open_to_all_pract_yn="";

String clinic_code=request.getParameter("clinic_code");
if(clinic_code == null || clinic_code.equals("") || clinic_code.equals("undefined")) clinic_code="";

String facilityid=(String)session.getValue("facility_id");
 Connection con = null;  
Statement stmt =null;
Statement stmt2 =null;
PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rs2=null;
try{
	
	 con = ConnectionManager.getConnection(request);  
	 stmt = con.createStatement();
	 stmt2 = con.createStatement();

	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
	+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
	out.println(a1);


String sql2="";
if(open_to_all_pract_yn.equals("Y"))
{
//sql2="select practitioner_name,practitioner_id from am_pract_for_facility_vw where eff_status='E' and OPERATING_FACILITY_ID='"+facilityid+"' order  by practitioner_name ";
sql2="select practitioner_name,practitioner_id from am_pract_for_facility_vw where eff_status='E' and OPERATING_FACILITY_ID=? order  by practitioner_name ";
}
else
if(open_to_all_pract_yn.equals("N"))
{
// sql2=" select practitioner_short_name,practitioner_id from op_pract_for_clinic_vw where FACILITY_ID='"+facilityid+"' and clinic_code='"+clinic_code+"' order by practitioner_short_name ";
 sql2=" select practitioner_short_name,practitioner_id from op_pract_for_clinic_vw where FACILITY_ID=? and clinic_code=? order by practitioner_short_name ";
}

else
{
sql2="";
}
String str1="";
String str2="";

if(! sql2.equals(""))
{
//rs2=stmt2.executeQuery(sql2);
pstmt = con.prepareStatement(sql2);
pstmt.setString(1,facilityid);
if(open_to_all_pract_yn.equals("N")){
pstmt.setString(2,clinic_code);
}
rs2 = pstmt.executeQuery();
if( rs2 != null ) 
{

            _bw.write(_wl_block2Bytes, _wl_block2);
	while( rs2.next() ) 
		{
			str1 = rs2.getString( "practitioner_name" ) ;
			str2 = rs2.getString( "practitioner_id" );
			out.println("<script>var element = parent.f_query_add_mod.document.frames[0].document.createElement('OPTION');element.text = '"+str1+"';element.value= '"+str2+"';parent.f_query_add_mod.document.frames[0].document.forms[0].pract.add(element);</script>");
		}
		
}	

else
{ 

            _bw.write(_wl_block3Bytes, _wl_block3);
 
} 

}
	if(rs !=null) rs.close();
	if(rs2 !=null) rs2.close();
	if(stmt2 !=null) stmt2.close();
	if(stmt !=null) stmt.close();


}catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
ConnectionManager.returnConnection(con,request);

}


            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
