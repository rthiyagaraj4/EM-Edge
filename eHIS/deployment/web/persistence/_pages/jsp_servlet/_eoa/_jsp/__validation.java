package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __validation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/Validation.jsp", 1709119283021L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t<script>\n\t\t\tvar n=parent.querying.document.getElementById(\"practitioner\").options.length;\n\t\t\tfor(var i=0;i<n;i++){\n\t\t\t\tparent.querying.document.getElementById(\"practitioner\").remove(\"pract\");\t\n\t\t\t}\n\t\t\tvar tp =\" -------Select------ \";\n\t\t\tvar opt=parent.querying.document.createElement(\"OPTION\");\n\t\t\topt.text=tp;\n\t\t\topt.value=\"\";\n\t\t\tparent.querying.document.getElementById(\"practitioner\").add(opt);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\ttp = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\n\t\t\t\topt=parent.querying.document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value = \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\';\n\t\t\t\tparent.querying.document.getElementById(\"practitioner\").add(opt);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>alert(getMessage(\'SCH_GR_TODAY\',\'OA\'););\"\n\t\t+\"parent.frames[1].document.frames[1].document.forms[0].prefdate.value=\'\"+from_date+\"\' </script></head><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'></body></html>\";\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
Statement stmt = null;
ResultSet rs=null;
ResultSet rs1=null;
PreparedStatement pstmt=null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
 stmt = con.createStatement();
	String Pract_Type_Code = request.getParameter("Pract_Type_Code");
	if (Pract_Type_Code!=null){
			String facilityid=(String)session.getValue("facility_id");
		    String sql1 = "Select practitioner_name,practitioner_id from am_pract_for_facility_vw Where operating_facility_id=? and pract_type=? and  Eff_status='E' order by practitioner_name" ;
			//rs = stmt.executeQuery("Select practitioner_name,practitioner_id from am_pract_for_facility_vw Where operating_facility_id='"+facilityid+"' and pract_type='"+Pract_Type_Code+"' and  Eff_status='E' order by practitioner_name");
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,Pract_Type_Code);
			rs = pstmt.executeQuery(); 

		
            _bw.write(_wl_block2Bytes, _wl_block2);

			while (rs.next()){
			
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(rs.getString("practitioner_name")));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs.getString("practitioner_id")));
            _bw.write(_wl_block5Bytes, _wl_block5);

			}
		

	}else{

	String to_date = request.getParameter("to_date");
	String from_date=request.getParameter("from_date");
	from_date = from_date;
	
			String wd1="";
			if(rs !=null)rs.close();
			//String sql="select ROUND(to_date('"+to_date+"', 'dd/mm/yyyy') - TRUNC(SYSDATE)) dtval FROM DUAL";
			String sql="select ROUND(to_date(?, 'dd/mm/yyyy') - TRUNC(SYSDATE)) dtval FROM DUAL";
			rs = stmt.executeQuery(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,to_date);
			rs = pstmt.executeQuery(); 
			while(rs.next()){
			wd1 = rs.getString("dtval");
			}
			
		
		
	int check=Integer.parseInt(wd1);
	if(check < 0 ){
		String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link>";
            _bw.write(_wl_block6Bytes, _wl_block6);
out.println(a1);
		}
		else
		{
		String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
		+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
		out.println(a1);	
		}
	}	

	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(stmt !=null) stmt.close();


}catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
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
