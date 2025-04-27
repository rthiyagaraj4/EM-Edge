package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __disasterregistrationpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/DisasterRegistrationPopulate.jsp", 1709113874209L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<html>\n<body class=\'MESSAGE\' onKeyDown = \'lockKey()\'> \n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n\t \n   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar oOption = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\t\toOption.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].visit_type.add(oOption);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].service_code.add(oOption);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t    parent.frames[1].frames[2].document.forms[0].AllowedDate.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].sysdate.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\t\t      \n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t</body>\n\t</html>\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		//String locale			= (String)session.getAttribute("LOCALE");

        String process = request.getParameter("process_id");
		if(process==null) process="";
		Connection con = null;
		java.sql.Statement st = null;
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		
		
		String loginfacility = (String) session.getValue("facility_id");
		String sql = "";
		String visit_type_code="";
		String visit_type_desc="";
        String service_code="";
		String service_desc="";
		StringBuffer sqlbuf=new StringBuffer();
    try
     {
		 con = ConnectionManager.getConnection(request);

		 if(process.equals("clinic_code"))
				{
					String location_code = request.getParameter("location_code");
						
					sql = "select a.visit_type_code, b.SHORT_DESC visit_type_short_desc  from  op_visit_type_for_clinic a, op_visit_type b where a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code and b.visit_type_ind='E'  and a.eff_status='E' and a.clinic_code= '"+location_code+"'  and a.facility_id='"+loginfacility+"'";
		            pstmt = con.prepareStatement(sql);
					                
					rs = pstmt.executeQuery();
					while (rs!=null && rs.next() )
					{

						visit_type_code=rs.getString("visit_type_code");
							visit_type_desc=rs.getString("visit_type_short_desc");
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_type_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block10Bytes, _wl_block10);

					}
			       	if(rs != null)		rs.close();
			        if(pstmt	  != null)		pstmt.close();

					sqlbuf.append("SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID='"+loginfacility +"' AND C.CLINIC_CODE = '"+location_code+"' AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID='"+loginfacility+"'  AND b.CLINIC_CODE='"+location_code+"' AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2");

					
                    st = con.createStatement();
					rs = st.executeQuery(sqlbuf.toString());
					while (rs!=null && rs.next() )
					{
						service_code=rs.getString(1);
							service_desc=rs.getString(2);
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

					}
				} 
				else if(process.equals("refresh_dates"))
				 {
					String AllowedDate = request.getParameter("AllowedDate");
					String sys_date = request.getParameter("sys_date");
				// Thursday, April 22, 2010 Venkats PE_EXE		
					/*	sql = "SELECT TO_CHAR (SYSDATE,'dd/mm/yyyy hh24:mi') SYS, TO_CHAR ((SYSDATE - (1 / (24 * 60 * 60)) * 3600 * max_hours_allow_insert ), 'dd/mm/yyyy hh24:mi' ) sys1  FROM ae_param where operating_facility_id='"+loginfacility+"'";

		            pstmt = con.prepareStatement(sql);
					            
					rs = pstmt.executeQuery();
					while (rs!=null && rs.next() )
					{

						     sys_date1=rs.getString("SYS");
							 AllowedDate1=rs.getString("sys1");

		                     sysdate2=DateUtils.convertDate(sys_date1,"DMYHM","en",locale);
		                     AllowedDate2=DateUtils.convertDate(AllowedDate1,"DMYHM","en",locale); */ 

						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(AllowedDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block14Bytes, _wl_block14);

	
				 }

	sqlbuf.setLength(0);

	if(rs != null)		rs.close();
	if(st	  != null)		st.close();
	
	}catch(Exception e){e.printStackTrace();}
    finally
    {
     if(con!=null)   
     ConnectionManager.returnConnection(con,request);
    }	

	
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
