package jsp_servlet._eae._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __populatetreatmentarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/PopulateTreatmentArea.jsp", 1709113879459L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<html>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<BODY class=\'Message\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\n\t//    var opt\t\t= top.content.frames[1].frames[1].document.createElement(\"OPTION\");\n\t    var opt\t\t= top.content.frames[1].document.createElement(\"OPTION\");\n\t\t\t     \topt.text\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t     \topt.value\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"==\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\") \n\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"==\"bays\")\n\t\t\t\t{\n\t\t\t     \tparent.frames[1].frames[0].document.forms[0].treatment_area_code.add(opt);\n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].treatment_area_code.add(opt);\n\t\t\t\t}\n\t  \t</script>\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t</body>    \n\t</html>\t\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block2Bytes, _wl_block2);

		Connection con		=  null;
		
		ResultSet rs 		= null;
		ResultSet rs1 		= null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
        String	facilityId 	= (String) session.getValue( "facility_id" ) ;
		String clinic_code	= request.getParameter("clinic_code");
		clinic_code 		= (clinic_code == null)?"":clinic_code;
		String treatment    = request.getParameter("treatment_area_code");
		treatment 			= (treatment == null)?"":treatment;
		String practitioner = request.getParameter("practitioner_id");
		practitioner 		= (practitioner == null)?"":practitioner;
        String asstrntbays = request.getParameter("asstrntbays");
		asstrntbays 		= (asstrntbays == null)?"":asstrntbays;
      
	
            _bw.write(_wl_block3Bytes, _wl_block3);
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	try{
			con					= ConnectionManager.getConnection(request);
	       
	       String sql		= "";
	       String shortDesc = "";
	       String code 		= "";
		   if(asstrntbays.equals("bays"))
		{
	           		sql		= "select TREATMENT_AREA_CODE, SHORT_DESC from AE_TMT_AREA_FOR_CLINIC where facility_id=? and clinic_code=? and eff_status='E' order by 2";
		}
		else
		{
				sql		= "select TREATMENT_AREA_CODE, SHORT_DESC from AE_TMT_AREA_FOR_CLINIC where facility_id=? and clinic_code=? and OPEN_TO_ALL_PRAC_FOR_CLINIC_YN = 'N' and eff_status='E' order by 2";
		}
					
           // For Practitioner
		   String sql1		= "select PRACTITIONER_ID, PRACTITIONER_SHORT_NAME  from OP_PRACT_FOR_CLINIC_VW where facility_id= ? and clinic_code= ? and eff_status  = 'E' order by 2";

					pstmt   = con.prepareStatement(sql);
					pstmt.setString(1,facilityId) ;
					pstmt.setString(2,clinic_code) ;
					rs		 = pstmt.executeQuery();
	 	while(rs!=null && rs.next())
			{		
				code	   = rs.getString(1);
				shortDesc  = rs.getString(2);
				
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(treatment));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(asstrntbays));
            _bw.write(_wl_block11Bytes, _wl_block11);
	       } //End of while		 
				 		 if(rs!=null) { rs.close(); rs = null; }   
 				         if(pstmt!=null) { pstmt.close(); pstmt = null; }   

     // For Populating the Practitioners
					
					pstmt1 = con.prepareStatement(sql1);
					pstmt1.setString(1,facilityId) ;
					pstmt1.setString(2,clinic_code) ;

	 	while(rs1!=null && rs1.next())
			{		
				
	
            _bw.write(_wl_block2Bytes, _wl_block2);
	       } //End of while		 
				 	
						 if(rs1!=null) { rs1.close(); rs1 = null; }   
 				         if(pstmt1!=null) { pstmt1.close(); pstmt1 = null; } if(rs!=null) { rs.close(); rs = null; }   
 				      	 if(pstmt!=null) { pstmt.close(); pstmt = null; }  
						 

	   }   catch(Exception e)
     	    		{e.printStackTrace();}
		   
			finally {
			       
					   if(con != null)	 
				       ConnectionManager.returnConnection(con,request);  
			          }
		           	
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
