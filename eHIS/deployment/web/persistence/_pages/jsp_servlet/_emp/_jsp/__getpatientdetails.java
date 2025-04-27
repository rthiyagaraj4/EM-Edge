package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getpatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/getPatientDetails.jsp", 1742387387285L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 3:02 PM --> \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t\t\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t</head>\n\n<body class=\'message\' onKeyDown=\'lockKey();\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con				= null;
    PreparedStatement pstmt		= null;
    java.sql.Statement stmt3	= null;
    java.sql.Statement stmt4	= null;
    ResultSet rset				= null;
    ResultSet rset2				= null;
	ResultSet rset3				= null;
	ResultSet rset4				= null;

    String value1 = request.getParameter("field1") == null ? "" : request.getParameter("field1");
	String value2 = request.getParameter("field2") == null ? "" : request.getParameter("field2");

	String sql					= "";
	String sex					= "";
	String fathername			= "";
	String fathername_loc_lang	= "";    
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String first_name			= "";
	String second_name			= "";
	String third_name			= "";
	String family_name			= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang = "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String date_of_birth		= "";
	String nationality			= "";
	String religion				= "";
	String occupation			= "";
	String education			= "";
	String residence			= "";
	String relationship			= "";
	String inhouse_birth_yn		= "";
	String hj_date				= "";

    try
    {
		con = ConnectionManager.getConnection(request);

		if(value1.equals("father_patient_id"))
        {
			String frames_list = "";
			frames_list = "parent.frames[1].frames[2].";

			sql ="SELECT decode('"+localeName+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX, patient_name_loc_lang, alt_id1_no, alt_id2_no, alt_id3_no, first_name, second_name, third_name, family_name, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, mp_country.long_desc nationality, relgn_code, education_level, ocpn_code FROM mp_patient pat, mp_pat_oth_dtls oth_dtls, mp_pat_rel_contacts rel, mp_country where pat.PATIENT_ID = ? AND pat.patient_id = oth_dtls.patient_id AND pat.patient_id = rel.patient_id(+) AND pat.nationality_code = mp_country.country_code(+)";
                
            if(pstmt != null) pstmt.close();
            pstmt = con.prepareStatement(sql);
                
            pstmt.setString(1,value2);
            rset = pstmt.executeQuery();
                
            boolean flag=true;

            if(rset.next())
            {                    
				if(rset.getString(2).equals("M"))
                {
					fathername				= rset.getString(1);
					fathername_loc_lang		= rset.getString("patient_name_loc_lang");  
					alt_id1_no				= rset.getString("alt_id1_no");
					alt_id2_no				= rset.getString("alt_id2_no");
					alt_id3_no				= rset.getString("alt_id3_no");
					first_name				= rset.getString("first_name");
					second_name				= rset.getString("second_name");
					third_name				= rset.getString("third_name");
					family_name				= rset.getString("family_name");
					first_name_loc_lang		= rset.getString("first_name_loc_lang");
					second_name_loc_lang	= rset.getString("second_name_loc_lang");
					third_name_loc_lang		= rset.getString("third_name_loc_lang");
					family_name_loc_lang	= rset.getString("family_name_loc_lang");
					date_of_birth			= rset.getString("date_of_birth");
					religion				= rset.getString("relgn_code");
					occupation				= rset.getString ("ocpn_code");
					education				= rset.getString("education_level");
					

					if(first_name == null) first_name = "";
					if(second_name == null) second_name = "";
					if(third_name == null) third_name = "";
					if(family_name == null) family_name = "";
					if(first_name_loc_lang == null) first_name_loc_lang = "";
					if(second_name_loc_lang == null) second_name_loc_lang = "";
					if(third_name_loc_lang == null) third_name_loc_lang = "";
					if(family_name_loc_lang == null) family_name_loc_lang = "";
					if(alt_id1_no == null) alt_id1_no = "";
					if(alt_id2_no == null) alt_id2_no = "";
					if (alt_id3_no == null) alt_id3_no = "";
					if(fathername_loc_lang == null) fathername_loc_lang = "";
					if(religion == null) religion = "";
					if (occupation == null) occupation = "";
					if (education == null) education = "";
					nationality = rset.getString("nationality");
					if(nationality == null) nationality = "";
	
					fathername = fathername_loc_lang + "  "+fathername;
					out.println("<script>						"+frames_list+"document.forms[0].father_patient_name.value=\""+fathername+"\";	"+frames_list+"document.forms[0].father_patient_name_loc_lang.value=\""+fathername_loc_lang+"\";						"+frames_list+"document.getElementById('fathername').innerHTML=\"<b>  "+fathername+"\";		"+frames_list+"document.forms[0].fath_qid_no.value=\""+alt_id1_no+"\";			"+frames_list+"document.forms[0].fath_hmc_no.value=\""+alt_id2_no+"\";			"+frames_list+"document.forms[0].fath_name1.value=\""+first_name+"\";		"+frames_list+"document.forms[0].fath_name2.value=\""+second_name+"\";	"+frames_list+"document.forms[0].fath_name3.value=\""+third_name+"\";		"+frames_list+"document.forms[0].fath_name6.value=\""+family_name+"\";	"+frames_list+"document.forms[0].fath_name_oth_lang1.value=\""+first_name_loc_lang+"\";		"+frames_list+"document.forms[0].fath_name_oth_lang2.value=\""+second_name_loc_lang+"\";								"+frames_list+"document.forms[0].fath_name_oth_lang3.value=\""+third_name_loc_lang+"\";								"+frames_list+"document.forms[0].fath_name_oth_lang4.value=\""+family_name_loc_lang+"\";										"+frames_list+"document.forms[0].fath_date_of_birth.value='"+date_of_birth+"';	"+frames_list+"document.forms[0].fath_nationality.value='"+nationality+"';		"+frames_list+"document.forms[0].fath_religion.value='"+religion+"';		"+frames_list+"document.forms[0].fath_occupation.value='"+occupation+"';		"+frames_list+"document.forms[0].fath_education.value='"+education+"';			"+frames_list+"document.forms[0].fath_qid_no.readOnly=true;						"+frames_list+"document.forms[0].fath_hmc_no.readOnly=true;						"+frames_list+"document.forms[0].fath_date_of_birth.readOnly=true; ");
					out.println("</script>");						
				}                    
				else
                {
					flag = false;
					out.println("<script>alert(getMessage('GENDER_MISMATCH','MP'));						"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';			"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();						</script>");
				}
			}
            else
            {
				flag = false;
                out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP'));					"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';	"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();</script>");
			}
            if(flag)
            {
				String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
					
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1,value2) ;
					
				rset2 = pstmt.executeQuery();
				String dob = "";
				while(rset2.next())
				{
					dob= rset2.getString(1);
				}

				String sql3=" select NB_FATHER_MIN_AGE from mp_param ";
					
				stmt3 = con.createStatement();
				rset3 = stmt3.executeQuery(sql3);
				int father_min_age=0;
				while(rset3.next())
				{
					father_min_age=rset3.getInt(1);
				}
				int pat_age=0;
				String sql4="select calculate_age('"+dob+"',1) from dual ";
				stmt4 = con.createStatement();
				rset4 = stmt4.executeQuery(sql4);
				while(rset4.next())
				{
					pat_age=rset4.getInt(1);
				}
				if(pat_age < father_min_age)
				{
					out.println("<script>alert(getMessage('FATHER_AGE_PARAM','MP'));	"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';			"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();						</script>");
				}
			}                
		}            
		else if (value1.equals("not_patient_id"))
		{
			String frames_list = "";
			frames_list = "parent.frames[1].frames[2].";
			sql ="select decode('"+localeName+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX, patient_name_loc_lang, alt_id1_no, alt_id2_no, alt_id3_no, first_name, second_name, third_name, family_name, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,  pat.nationality_code nationality, relgn_code, education_level, ocpn_code, relationship_to_head, res_area_code, inhouse_birth_yn  from mp_patient pat, mp_pat_oth_dtls oth_dtls, mp_pat_rel_contacts rel, mp_country  where pat.PATIENT_ID=? and pat.patient_id = oth_dtls.patient_id and pat.patient_id = rel.patient_id(+) and pat.nationality_code = mp_country.country_code(+)";
               
			if(pstmt != null) pstmt.close();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,value2);
            rset = pstmt.executeQuery();
                
            boolean flag=true;

            if(rset.next())
            {                    
				inhouse_birth_yn = rset.getString("inhouse_birth_yn");
				if(inhouse_birth_yn==null) inhouse_birth_yn = "";
				if(inhouse_birth_yn.equals("N"))
				{
					fathername = rset.getString(1);
					sex = rset.getString("sex");
					fathername_loc_lang = rset.getString("patient_name_loc_lang");  
					if(fathername_loc_lang == null) fathername_loc_lang = "";

					alt_id1_no = rset.getString("alt_id1_no");
					alt_id2_no = rset.getString("alt_id2_no");
					alt_id3_no = rset.getString("alt_id3_no");

					if(alt_id1_no == null) alt_id1_no = "";
					if(alt_id2_no == null) alt_id2_no = "";
					if(alt_id3_no == null) alt_id3_no = "";
						
					first_name = rset.getString("first_name");
					second_name = rset.getString("second_name");
					third_name = rset.getString("third_name");
					family_name = rset.getString("family_name");
					first_name_loc_lang = rset.getString("first_name_loc_lang");
					second_name_loc_lang = rset.getString("second_name_loc_lang");
					third_name_loc_lang = rset.getString("third_name_loc_lang");
					family_name_loc_lang = rset.getString("family_name_loc_lang");
					if (first_name == null) first_name = "";
					if (second_name == null) second_name = "";
					if (third_name == null) third_name = "";
					if (family_name == null) family_name = "";
					if (first_name_loc_lang == null) first_name_loc_lang = "";
					if (second_name_loc_lang == null) second_name_loc_lang = "";
					if (third_name_loc_lang == null) third_name_loc_lang = "";
					if (family_name_loc_lang == null) family_name_loc_lang = "";
					date_of_birth = rset.getString("date_of_birth");

					nationality = rset.getString("nationality");
					if (nationality==null || nationality.equals("null")) nationality="";
					religion = rset.getString("relgn_code");
					if (religion == null) religion = "";
					occupation = rset.getString ("ocpn_code");
					if (occupation == null) occupation = "";
					education = rset.getString("education_level");
					if (education == null) education = "";
					relationship = rset.getString("relationship_to_head");
					if (relationship == null) relationship = "";
					residence = rset.getString("res_area_code");
					if (residence == null) residence = "";

					out.println("<script>						"+frames_list+"document.forms[0].not_patient_name.value=\""+fathername+"\";	"+frames_list+"document.forms[0].not_patient_name_loc_lang.value=\""+fathername_loc_lang+"\";            												"+frames_list+"document.forms[0].not_qid_no.value=\""+alt_id1_no+"\";			"+frames_list+"document.forms[0].not_date_of_birth.value='"+date_of_birth+"';	"+frames_list+"document.forms[0].not_nationality.value='"+nationality+"';		"+frames_list+"document.forms[0].not_nationality_val.value='"+nationality+"';	"+frames_list+"document.forms[0].not_religion.value='"+religion+"';		"+frames_list+"document.forms[0].not_occupation.value='"+occupation+"';		"+frames_list+"document.forms[0].not_gender.value='"+sex+"';				"+frames_list+"document.forms[0].not_gender_val.value='"+sex+"';					"+frames_list+"document.forms[0].not_relationship.value='"+relationship+"';		"+frames_list+"document.forms[0].not_res_area.value='"+residence+"';		"+frames_list+"document.forms[0].not_qid_no.readOnly = true; "+frames_list+"document.forms[0].not_date_of_birth.readOnly = true; "+frames_list+"document.forms[0].not_nationality.disabled = true; "+frames_list+"document.forms[0].not_gender.disabled = true; "+frames_list+"document.forms[0].not_relationship.disabled = true; "+frames_list+"document.forms[0].not_res_area.disabled = true;");												
					out.println("</script>");
				}
				else
				{
					out.println("<script>alert(getMessage('NOT_PATID_INVALID','MP')); "+frames_list+"document.forms[0].not_patient_id.value='';					"+frames_list+"document.forms[0].not_patient_id.focus();					"+frames_list+"document.forms[0].not_patient_name.value='';				"+frames_list+"document.forms[0].not_patient_name_loc_lang.value='';</script>");
				}
			}
            else
            {
				flag = false;                    out.println("<script>alert(getMessage('NOT_PATID_INVALID','MP')); "+frames_list+"document.forms[0].not_patient_id.value='';					"+frames_list+"document.forms[0].not_patient_id.focus();					"+frames_list+"document.forms[0].not_patient_name.value='';					"+frames_list+"document.forms[0].not_patient_name_loc_lang.value='';</script>");
			}                            				
		}
		else if(value1.equals("gr_date_of_birth"))
		{
			String frames_list = "";
			String day_of_week = "";
			frames_list = "parent.frames[1].frames[2].";
			sql = "select hij_date(?),InitCap(to_char(to_date(?,'dd/mm/yyyy'),'day')) day_of_week from dual";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, value2);
			pstmt.setString(2, value2);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				hj_date = rset.getString(1);
				day_of_week = rset.getString(2);
			}
			out.println("<script>"+frames_list+"document.forms[0].hj_date_of_birth.value='"+hj_date+"'</script>");				
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>"+frames_list+"document.getElementById('day_of_week').innerHTML=\"<b>&nbsp;&nbsp;"+day_of_week+"\"</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></body></html>");
		}
		if(rset != null) rset.close();
		if(rset2 != null) rset2.close();
		if(pstmt != null) pstmt.close();		
		if(rset3 != null) rset3.close();
		if(stmt3 != null) stmt3.close();
		if(rset4 != null) rset4.close();
		if(stmt4 != null) stmt4.close();
    }
	catch(Exception e)
	{
		out.println(e.toString());
	}
    finally
    {        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }


            _bw.write(_wl_block7Bytes, _wl_block7);
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
