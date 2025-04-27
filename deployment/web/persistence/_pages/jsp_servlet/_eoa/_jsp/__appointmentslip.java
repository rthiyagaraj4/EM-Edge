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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __appointmentslip extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AppointmentSlip.jsp", 1709119219381L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n \n\t\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n <table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'102%\' align=\'center\' >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\nwindow.close();</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'==\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'&&parent.frames[1].document.forms[0].select)parent.frames[1].document.forms[0].select.onclick();\n</script>\n</table>\n</body>\n</html> \n\n";
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con = null;
	    //Statement	stmt		=null;
		PreparedStatement pstmt=null;
		ResultSet	rs			=null;
		request.setCharacterEncoding("UTF-8");
		String group_id	= request.getParameter("group_id");
		String app_date	= request.getParameter("app_date");
		String prac_id	= request.getParameter("prac_id");
		String loc_type	= request.getParameter("loc_type");
		String loc_code	= request.getParameter("loc");
			
		String classValue="";
		String noof_appt="";
		String name	="";
		String pat_id	="";
		String app_no="";
		/*Below line added for this incident [44296]*/
		String fromTime	=request.getParameter("fromtime");if(fromTime==null) fromTime="";
		String toTime=request.getParameter("totime"); if(toTime==null) toTime="";
	//	String clinicType="";
	//	String clinicCode="";
		//String group_Name="";
		
		ecis.utils.OnlineReports onlineReports		=	null;
		ecis.utils.OnlineReport report2				=	null;
		String ReportOutput			=	"";	
		
		int i=0;int maxRecord=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
       con = ConnectionManager.getConnection(request);
	  // stmt=con.createStatement();
	   
	   	/*Below  query modified for this incident [44296]*/
	   
	    String query="SELECT patient_id,appt_ref_no,patient_name,CARE_LOCN_TYPE_IND,CLINIC_CODE FROM oa_appt where GROUP_ID='"+group_id+"' and practitioner_id='"+prac_id+"'  AND ( TRUNC (appt_date) = TRUNC (to_date('"+app_date+"','dd/mm/yyyy'))) AND TO_DATE (TO_CHAR (APPT_SLAB_FROM_TIME, 'hh24:mi'), 'hh24:mi') = TO_DATE ('"+fromTime+"', 'hh24:mi') AND TO_DATE (TO_CHAR (APPT_SLAB_TO_TIME, 'hh24:mi'), 'hh24:mi') = TO_DATE ('"+toTime+"', 'hh24:mi')  group by appt_ref_no,patient_id,patient_name,CARE_LOCN_TYPE_IND,CLINIC_CODE";
	  
	 
	  
	      pstmt = con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	  	   
	      //rs = stmt.executeQuery(query.toString());
	      rs = pstmt.executeQuery();
		  rs.last();
		  maxRecord = rs.getRow();
		  rs.beforeFirst(); 	   	
		while(rs.next()){			  
		        app_no=rs.getString("APPT_REF_NO");
				name=rs.getString("PATIENT_NAME");
				pat_id=rs.getString("PATIENT_ID");	
			//	clinicType=rs.getString("CARE_LOCN_TYPE_IND");	
			//	clinicCode=rs.getString("CLINIC_CODE");	
				
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport((String)session.getValue( "facility_id" ), "OA", "OARAPSL",rs.getString("CARE_LOCN_TYPE_IND"),rs.getString("CLINIC_CODE")) ;				
				report2.addParameter("p_appt_ref_no", rs.getString("APPT_REF_NO")) ;
				//report2.addParameter("p_locn_code", rs.getString("CARE_LOCN_TYPE_IND")) ;
				//report2.addParameter("p_locncode",rs.getString("CLINIC_CODE")) ;
				report2.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" )) ;
				report2.addParameter("p_language_id", locale) ;			
				onlineReports.add(report2) ;
				ReportOutput=onlineReports.execute(request, response );
					
			i++;			
		
	}//end of while
			
  

  if(i == 0)
{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
	if (rs != null) rs.close();
	//if (stmt != null) stmt.close();
	if (pstmt != null) pstmt.close();
}
catch(Exception e)
	{
	e.printStackTrace() ;
	//out.println("one L :" +e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
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
