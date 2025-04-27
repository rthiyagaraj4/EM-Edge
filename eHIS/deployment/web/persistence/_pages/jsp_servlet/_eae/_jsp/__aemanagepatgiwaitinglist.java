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

public final class __aemanagepatgiwaitinglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGIWaitingList.jsp", 1709113835944L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<html> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<BODY class=\'Message\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t  var opt\t\t=top.content.frames[1].frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\t  opt.text\t= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t  opt.value\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t  opt.selected = ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023\n\t\t\t\t\t  top.content.frames[1].frames[0].document.forms[0].bed_bay_type.add(opt);\t\t\t\t\n\t\t\t\t\t</script>\t  \n\t\t\t\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t            var opt\t\t=   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".document.createElement(\"OPTION\");\n\t\t\t     \topt.text\t= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t     \topt.value\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"==\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\") \n\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"==\"bays\")\n\t\t\t\t    {\n                       ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =".document.forms[0].treatment_area_code.add(opt);\n\t\t\t\t      ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =".openToAllPractForClnYN[";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="]=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\t\t\t\t     }\n\t\t\t        else{\n\t\t\t\t    parent.frames[1].document.forms[0].treatment_area_code.add(opt);\n\t\t\t\t\t}\n\t//parent.frames[1].frames[0].openToAllPractForClnYN[";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t</script>\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</body>    \n\t</html>\t \n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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

		Connection con		=  null;
		ResultSet rs 		= null;
		PreparedStatement pstmt = null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String locale			= (String)session.getAttribute("LOCALE");

        String	facilityId 	= (String) session.getValue( "facility_id" ) ;
		String clinic_code	= request.getParameter("clinic_code");
		clinic_code 		= (clinic_code == null)?"":clinic_code;
		String treatment    = request.getParameter("treatment_area_code");
		treatment 			= (treatment == null)?"":treatment;
		String practitioner = request.getParameter("practitioner_id");
		practitioner 		= (practitioner == null)?"":practitioner;
        String asstrntbays  = request.getParameter("asstrntbays");
		asstrntbays 		= (asstrntbays == null)?"":asstrntbays;
		String bayType      = request.getParameter("bayType");
		bayType 		    = (bayType == null)?"":bayType;
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		//Starts		
		String isAppearAsTabEnable      = request.getParameter("isAppearAsTabEnable");
		String bed_bay_type      = request.getParameter("bed_bay_type");
		bed_bay_type 		    = (bed_bay_type == null)?"":bed_bay_type;	
		String selected_prop="false";		
		//Ends
		String shortDes		= "";
	    String bedcode 		= "";
		String called_from_ca      = request.getParameter("called_from_ca");
		called_from_ca 		    = (called_from_ca == null)?"":called_from_ca;
		String frame_name="";

	
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	try{
	       con					= ConnectionManager.getConnection(request); 
	       String shortDesc		    = "";
	       String code 				= "";
		   int	  rowIndex			= 1;
		   String open_to_all_prac_for_clinic_yn="";

		   if (bayType.equals("Y")) {   
             if( (!clinic_code.equals("")) && (!treatment.equals("")) ) { 
			   StringBuffer sqlBuf1  = new StringBuffer();
			   
			   sqlBuf1.append(" SELECT DISTINCT BAY_TYPE_CODE, AE_GET_DESC.AE_BAY_TYPE(BAY_TYPE_CODE,'"+locale+"','2')  SHORT_DESC FROM AE_BED_FOR_TRMT_AREA WHERE FACILITY_ID = ?  and CLINIC_CODE=?  AND TREATMENT_AREA_CODE= ? and eff_status='E'  order by 2 ");

			   pstmt   = con.prepareStatement(sqlBuf1.toString());
			   pstmt.setString	(	1,	facilityId		);
			   pstmt.setString	(	2,	clinic_code		);
			   pstmt.setString	(	3,	treatment		);

			   rs		 = pstmt.executeQuery();
			  while(rs!=null && rs.next())
				 {	
					bedcode	   = rs.getString(1);
					shortDes  = rs.getString(2); 
					//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
					//Starts
					if(isAppearAsTabEnable.equals("true")) {
						if(bed_bay_type.equals(bedcode))
							{
							selected_prop ="true";							}
						else {
							selected_prop ="false";
							}	
						}
					//Ends					 
				 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(shortDes));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bedcode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(selected_prop));
            _bw.write(_wl_block8Bytes, _wl_block8);
	       
				 } //End of while		 
				 if(rs!=null) { rs.close(); rs = null; }   
				 if(pstmt!=null) { pstmt.close(); pstmt = null; }   
           }// End of If
	     }
		 else{	
			 if(called_from_ca.equals("Y")) {
				 frame_name = "top.content.frames[3].frames[1].frames[0]";
			 }
			 else{ 
				 frame_name = "top.content.frames[1].frames[0]";
			 }
		   StringBuffer sqlBuf  = new StringBuffer();
		   
		   sqlBuf.append("select TREATMENT_AREA_CODE, SHORT_DESC, open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and clinic_code= ?  and facility_id= ?   and eff_status='E'  order by 2");
		   pstmt   = con.prepareStatement(sqlBuf.toString());
		   pstmt.setString	(	1,	clinic_code		);
		   pstmt.setString	(	2,	facilityId		);

		   rs		 = pstmt.executeQuery();
	 	   while(rs!=null && rs.next())
			{		
				code	   = rs.getString("TREATMENT_AREA_CODE");
				shortDesc  = rs.getString("SHORT_DESC");
				open_to_all_prac_for_clinic_yn=rs.getString("open_to_all_prac_for_clinic_yn");
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(treatment));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(asstrntbays));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block20Bytes, _wl_block20);
	       
		rowIndex++;
		} //End of while		 
	    if(rs!=null) { rs.close(); rs = null; }   
	    if(pstmt!=null) { pstmt.close(); pstmt = null; }  
		 }
	   }catch(Exception e)
       { e.toString();   }
	   finally {
				   ConnectionManager.returnConnection(con,request);  
			    }
	
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
