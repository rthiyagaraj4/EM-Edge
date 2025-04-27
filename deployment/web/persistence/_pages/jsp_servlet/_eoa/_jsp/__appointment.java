package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __appointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/Appointment.jsp", 1734932525582L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n    ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n<Script src=\"../../eOA/js/Validate.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<head><title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<!-- <frameset id=\'AppointmentFrame\' rows=\'*,8%\' frameborder=0>\n\t\t\t\t<frameset cols=\'30%,*\'>\n\t\t\t\t<frame name=\'apptdairy\' src=\'../../eOA/jsp/CAOAApptDairy.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' noresize frameborder=0 scrolling=\'no\'>\n\t\t\t\t<frame name=\'dummy\' src=\'../../eCommon/html/blank.html\' noresize frameborder=0 scrolling=\'yes\'>\n\t\t\t\t</frameset>\n\t\t\t<frame name=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplay.jsp\' noresize frameborder=\'0\' scrolling=\'no\'>\t\t\t\t\n\t\t</frameset> -->\n\t\t<iframe name=\'apptdairy\' src=\'../../eOA/jsp/CAOAApptDairy.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' noresize frameborder=0 scrolling=\'no\' style=\"height:100vh;width:30vw\"></iframe>\n\t\t<iframe name=\'dummy\' src=\'../../eCommon/html/blank.html\' noresize frameborder=0 scrolling=\'yes\' style=\"height:100vh;width:70vw\"></iframe>\n\t\t<iframe name=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplay.jsp\' noresize frameborder=\'0\' scrolling=\'no\' style=\"height:8vh;width:100vw\"></iframe>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<iframe name=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?calling_mode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=\"0\" scrolling=no noresize style=\"height:4vh;width:100vw;border:\'5\'\"></iframe>\n\t\t<iframe name=\'querying\'src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id_temp=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&first_name_temp=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&second_name_temp=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&third_name_temp=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&family_name_temp=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&gender_temp=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&contact_no_temp=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&rd_appt_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' frameborder=\"0\" scrolling=no noresize style=\"height:29vh;width:99vw;border:\'5\'\"></iframe>\n\t\t<iframe name=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" noresize scrolling=no style=\"height:0vh;width:100vw;border:\'5\'\"></iframe>\n\t\t<iframe name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" noresize scrolling=auto style=\"height:60vh;width:99vw;border:\'5\'\"></iframe>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</head>\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		Statement stmt=null;
 		ResultSet rs=null;
		String ca_mode="";
		String s=request.getQueryString();
		String is_ca=request.getParameter("CA");
		if(is_ca!=null && is_ca.equals("Y")){
		ca_mode="ca_mode";
		}
		
		
		String facilityid=(String)session.getValue("facility_id");
		boolean practitioner_yn=false;
		int no_record=0;
		String practitioner_id=(String)session.getValue("ca_practitioner_id");
		String calling_mode=(String)session.getValue("calling_mode");
		
		try{
			con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();

		if(practitioner_id!=null && !(practitioner_id.equals(""))){
			String pract_str="select Count(*) from oa_clinic_time_table where facility_id ='"+facilityid+"' and PRACTITIONER_ID='"+practitioner_id+"' ";
			rs = stmt.executeQuery(pract_str);
			if(rs !=null)
			{
				while ( rs.next() )
					{
						no_record=rs.getInt(1);	
					}
			}

		}
		if(no_record!=0){
			practitioner_yn=true;
		}else{
		practitioner_yn=false;
		}
		String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
		String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
		String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
		String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
		String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
		String gender_temp		= checkForNull(request.getParameter("gender_temp"));
		String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
		String rd_appt_yn	= checkForNull(request.getParameter("rd_appt_yn"));
		/*System.out.println("patient_id_temp Appointment==>"+patient_id_temp);
		System.out.println("first_name_temp Appointment==>"+first_name_temp);
		System.out.println("second_name_temp Appointment==>"+second_name_temp);
		System.out.println("third_name_temp Appointment==>"+third_name_temp);
		System.out.println("family_name_temp Appointment==>"+family_name_temp);
		System.out.println("gender_temp Appointment==>"+gender_temp);
		System.out.println("contact_no_temp Appointment==>"+contact_no_temp);*/

	if(practitioner_yn && ca_mode.equals("ca_mode"))
	{
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(s));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(s));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(s));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(s));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gender_temp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);

	}
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
}
catch(Exception es)
{
	//out.println("Exception :"+es);
	es.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
