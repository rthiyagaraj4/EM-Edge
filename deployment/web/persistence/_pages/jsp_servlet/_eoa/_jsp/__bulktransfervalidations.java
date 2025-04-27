package jsp_servlet._eoa._jsp;

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
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __bulktransfervalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BulkTransferValidations.jsp", 1709119228022L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n</head>\n<body class=\'MESSAGE\' onKeyDown = \'lockKey();\'>\t\t\t\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eOA/js/BulkTransferAppointment.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\talert(getMessage(\"ELAPSED_APPOINTMENTS_EXISTS\",\"OA\"));\n\t\t\tparent.frames[2].frames[1].moveforward(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\t\t\t\n\t\t\tparent.frames[2].frames[1].moveforward(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</body>\n\t</html>\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String locale =((String)session.getAttribute("LOCALE"));
 request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String clinic_code = request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
	String clinic_date = request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	Connection con = null;	
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String loginfacility = (String) session.getValue("facility_id");	
	String sql="";
	//String start_time="";
	//String end_time="";	
	//boolean proceed=false;
	//String datechecksql="";
	String result="";
	try
	{
		con = ConnectionManager.getConnection(request);
		
	//	sql="SELECT CASE WHEN to_date(to_char(clinic_date, 'DD/MM/YYYY ') || to_char(start_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')> SYSDATE THEN 'true' WHEN NOT EXISTS (SELECT 1 FROM oa_appt WHERE facility_id = a.facility_id AND clinic_code = a.clinic_code AND practitioner_id = a.practitioner_id AND appt_date = a.clinic_date AND to_date(to_char(appt_date, 'DD/MM/YYYY ')|| to_char(appt_slab_from_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < SYSDATE )THEN 'true' ELSE 'false' END AS RESULT FROM oa_clinic_schedule a WHERE facility_id = '"+loginfacility+"' AND clinic_code ='"+clinic_code+"' AND clinic_date = TO_DATE ('"+clinic_date+"','dd/mm/yyyy') AND practitioner_id = '"+practitioner_id+"'";
		sql="SELECT CASE WHEN to_date(to_char(clinic_date, 'DD/MM/YYYY ') || to_char(start_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')> SYSDATE THEN 'true' WHEN NOT EXISTS (SELECT 1 FROM oa_appt WHERE facility_id = a.facility_id AND clinic_code = a.clinic_code AND practitioner_id = a.practitioner_id AND appt_date = a.clinic_date AND to_date(to_char(appt_date, 'DD/MM/YYYY ')|| to_char(appt_slab_from_time,'HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') < SYSDATE )THEN 'true' ELSE 'false' END AS RESULT FROM oa_clinic_schedule a WHERE facility_id = ? AND clinic_code =? AND clinic_date = TO_DATE (?,'dd/mm/yyyy') AND practitioner_id = ?";

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,loginfacility);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,clinic_date);
		pstmt.setString(4,practitioner_id);
		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{
				result=rs.getString("RESULT");				
			}			
		}	
		if(rs != null) rs.close();			
		if(pstmt != null) pstmt.close();
		if(result.equals("false")){
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(result));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(result));
            _bw.write(_wl_block9Bytes, _wl_block9);
}		

	}catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
		finally
		{
			try{
					if(rs != null)		rs.close();			
					if(pstmt != null) pstmt.close();			
			}catch(Exception ee){}
			if(con != null) ConnectionManager.returnConnection(con,request);
		}	
			
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
