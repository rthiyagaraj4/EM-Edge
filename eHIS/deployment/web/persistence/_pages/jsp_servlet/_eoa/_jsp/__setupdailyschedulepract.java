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

public final class __setupdailyschedulepract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SetupDailySchedulePract.jsp", 1709119277693L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html> \n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"> </link>\n\t -->\n\t ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\">\t</script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="<script>parent.frames[1].document.getElementById(\"day_no\").value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" </script>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<script>alert(getMessage(\'SCH_GR_TODAY\',\'OA\'));</script>\n\t\t\t<script>parent.frames[1].document.forms[0].clinic_date.value=\'\';</script>\n\t\t\t<script>parent.frames[1].document.forms[0].clinic_date.focus();</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<script>alert(getMessage(\'SCH_ALREADY_EXISTS\',\'OA\'));</script>\n\t\t\t\t\t<script>parent.frames[1].document.forms[0].clinic_date.value=\'\';</script>\n\t\t\t\t\t<script>parent.frames[1].document.forms[0].clinic_date.focus();</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			Connection conn=null;
			Statement stmtn = null;
			Statement stmt = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ResultSet rs3=null;
try
{			
	request.setCharacterEncoding("UTF-8");
			conn = ConnectionManager.getConnection(request);
			 stmtn = conn.createStatement();
			 stmt = conn.createStatement();
			String clinic_date= request.getParameter("clinic_date");
			if( clinic_date == null) clinic_date="";
			String Practitioner_id=request.getParameter("Practitioner_id");
			if( Practitioner_id == null) Practitioner_id="";
			String open_to_all_pract_yn= request.getParameter("open_to_all_pract_yn");
			if( open_to_all_pract_yn == null) open_to_all_pract_yn="";
			String clinic_code= request.getParameter("clinic_code");
			if( clinic_code == null) clinic_code="";
			String clinic_type= request.getParameter("clinic_type");
			if( clinic_type == null) clinic_type="";
			String param = request.getParameter("param");
			if( param == null) param="";
			String facilityid=(String)session.getValue("facility_id");
	
			if(param.equals("ForPract"))
			{

			}
		else if( param.equals("ForDate") && !clinic_date.equals(""))
			{	
				String wd1="";
			
				String sql4="select day_no , ROUND(to_date('"+clinic_date+"', 'dd/mm/yyyy') - trunc(sysdate))date_val from sm_day_of_week where ltrim(rtrim(day_of_week)) = ltrim(rtrim(to_char(to_date('"+clinic_date+"','DD/MM/YYYY'),'DAY')))";
				//rs3 = stmt.executeQuery(sql4);
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1,clinic_date);
				pstmt.setString(2,clinic_date);
				rs3 = pstmt.executeQuery();
				while(rs3.next())
				{
						wd1 = rs3.getString("date_val");
						
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs3.getString(1)));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			if(rs3 !=null) rs3.close();
			

		int check=Integer.parseInt(wd1);
		if(check < 0 )
		{
			
            _bw.write(_wl_block6Bytes, _wl_block6);
}
		else
		{
			//String sql1="Select '1' From oa_clinic_schedule where facility_id='"+facilityid +"' and  Clinic_code='"+clinic_code+"'  and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')  and Nvl(Practitioner_id,'X')= nvl( '"+Practitioner_id+"' ,'X') ";
			String sql1="Select '1' From oa_clinic_schedule where facility_id=? and  Clinic_code=? and clinic_date =to_date(?,'dd/mm/yyyy')  and Nvl(Practitioner_id,'X')= nvl(? ,'X') ";
		//	rs = stmtn.executeQuery(sql1);  
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			pstmt.setString(4,Practitioner_id);
			rs = pstmt.executeQuery();
			if( rs != null)
			{
				if( rs.next())
				{
            _bw.write(_wl_block7Bytes, _wl_block7);
}			
			}	
		}
	 }
 if(rs !=null) rs.close();
 if(rs3 !=null) rs3.close();
 if(stmt !=null) stmt.close();
 if(stmtn !=null) stmtn.close();
}
catch(Exception e){ 
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
