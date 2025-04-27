package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __deathregister extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DeathRegister.jsp", 1709118895595L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t<frameset rows=\'*\'>\n\t\t\t<frame name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\t\t\tsrc=\"../../eMR/jsp/RecDiagnosis.jsp?CA=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&cause_of_death=Y&modal_yn=Y&Locn_Code=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Sex=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Dob=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&speciality_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&encounter_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&episode_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&practitioner_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&practitioner_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&patient_class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I\" frameborder=0 scrolling=\'no\'> \n\n<!-- <frame name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\t\t\tsrc=\'../../eMR/jsp/PaintDeathRegisterPatient.jsp?patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' frameborder=0 scrolling=\'no\'> \n -->\t\t\t\t<!-- <frame name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\'>  -->\n\t\t\t</frameset>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'DEATH_REG_NOT_APPL\',\'CA\'));\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\n\t\t\t\t</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale = (String)session.getAttribute("LOCALE"); 
   	    String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	    String isCalledFromCA = checkForNull(request.getParameter("CA")); 
		String patient_id= request.getParameter("patient_id");	
		String encounter_id= request.getParameter("episode_id");	//out.println("encounter_id"+encounter_id);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
	
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sql="select count(*) from mr_death_register_hdr where patient_id = '"+patient_id+"' and finalize_yn = 'N' ";
		int count =0;
		String patient_class = "";
		String encid = "";
		String sex = "";
		String practId = "";
		String pract_type = "";
		String specialty_code = "";
		String dob = "";
		String pat_curr_locn_code = "";
		try
			{
				con=ConnectionManager.getConnection(request);
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
		
				if(rs!=null)
				{
					rs.next();
					count=rs.getInt(1);
				}

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(count>0)
				{

					String sql2="select a.encounter_id, a.patient_id,decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code,  To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c,  AM_PRACTITIONER d, AM_PRACT_TYPE e where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id and a.facility_id = '"+p_facility_id+"' and a.facility_id =c.facility_id and d.practitioner_id = a.attend_practitioner_id and d.pract_type = e.pract_type and nvl(c.finalize_yn,'N')='N' and a.patient_id='"+patient_id+"'";
				
					pstmt=con.prepareStatement(sql2);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						encid = rs.getString("encounter_id");
						patient_class = rs.getString("patient_class");
						sex = rs.getString("sex");
						practId = rs.getString("attend_practitioner_id");
						pract_type = rs.getString("pract_type");
						specialty_code = rs.getString("specialty_code");
						dob = rs.getString("date_of_birth");
						pat_curr_locn_code = rs.getString("pat_curr_locn_code");
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();


	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(isCalledFromCA));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pat_curr_locn_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
				else
				{
					
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
			}catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
					
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
