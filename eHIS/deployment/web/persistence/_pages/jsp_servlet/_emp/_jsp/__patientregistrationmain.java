package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientregistrationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientRegistrationMain.jsp", 1736940535509L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n<!--Below line added for this CRF  GDOH-CRF-0029 [IN:048764]-->\n<Script language=\'JavaScript\' src=\'../../eCommon/js/DateUtils.js\' ></Script>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t</head>\n\t\t</html>\n\t";
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
            _bw.write(_wl_block5Bytes, _wl_block5);
   
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String params = request.getQueryString() ;
	String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String window_title = request.getParameter("title")==null?"":request.getParameter("title");

if(!window_title.equals(""))
{
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(window_title));
            _bw.write(_wl_block7Bytes, _wl_block7);

}		

		String inv_pat_search_in_reg_pat_yn="N";
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs= null;

try {

		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement(); 	

		String sql = "select INV_PAT_SEARCH_IN_REG_PAT_YN from mp_param where module_id='MP'";
		//stmt = conn.prepareStatement(sql);
		//pstmt.setString(1,localeName);
		rs = stmt.executeQuery(sql);

		if ( rs.next() )
		{
			inv_pat_search_in_reg_pat_yn = rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN");
			if (inv_pat_search_in_reg_pat_yn==null) inv_pat_search_in_reg_pat_yn = "N";
		}
	
		if (stmt!= null) stmt.close();
		if (rs!= null) rs.close();

	
		String appt_ref_no= request.getParameter("appt_ref_no");
        String booking_ref_no = request.getParameter("booking_ref_no") == null? "": request.getParameter("booking_ref_no");
        appt_ref_no = ((appt_ref_no == null)||(appt_ref_no.equalsIgnoreCase("null")))?"":appt_ref_no;
        String func_act = request.getParameter("func_act");      
        if (func_act == null) func_act="";
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
        String source = url + params ;

        String FirstName=request.getParameter("First_Name");if(FirstName==null)FirstName="";
        String SecondName=request.getParameter("Second_Name");if(SecondName==null)SecondName="";
        String ThirdName=request.getParameter("Third_Name");if(ThirdName==null)ThirdName="";
        String FamilyName=request.getParameter("Family_Name");if(FamilyName==null)FamilyName="";
			//FirstName= java.net.URLEncoder.encode(FirstName);
			//out.println("<script>alert('"+FirstName+"')</script>");
			
		
			FirstName=java.net.URLEncoder.encode(FirstName,"UTF-8");
			SecondName=java.net.URLEncoder.encode(SecondName,"UTF-8");
			ThirdName=java.net.URLEncoder.encode(ThirdName,"UTF-8");
			FamilyName=java.net.URLEncoder.encode(FamilyName,"UTF-8");
		

		String a_family_name_loc_lang		= request.getParameter("a_family_name_loc_lang");
		if(a_family_name_loc_lang==null)a_family_name_loc_lang="";
		String a_first_name_loc_lang		= request.getParameter("a_first_name_loc_lang");
		if(a_first_name_loc_lang==null)a_first_name_loc_lang="";
		String a_second_name_loc_lang		= request.getParameter("a_second_name_loc_lang");
		if(a_second_name_loc_lang==null)a_second_name_loc_lang="";
		String a_third_name_loc_lang		= request.getParameter("a_third_name_loc_lang");
		if(a_third_name_loc_lang==null)a_third_name_loc_lang="";
        
		
			a_family_name_loc_lang=java.net.URLEncoder.encode(a_family_name_loc_lang,"UTF-8");
			a_first_name_loc_lang=java.net.URLEncoder.encode(a_first_name_loc_lang,"UTF-8");
			a_second_name_loc_lang=java.net.URLEncoder.encode(a_second_name_loc_lang,"UTF-8");
			a_third_name_loc_lang=java.net.URLEncoder.encode(a_third_name_loc_lang,"UTF-8");
		
        String AltIdNo=request.getParameter("Alt_Id_No");if(AltIdNo==null)AltIdNo="";
        String AltId2No=request.getParameter("Alt_Id2_No");if(AltId2No==null)AltId2No="";
        String AltId3No=request.getParameter("Alt_Id3_No");if(AltId3No==null)AltId3No="";
        String AltId4No=request.getParameter("Alt_Id4_No");if(AltId4No==null)AltId4No="";
                
        String NationalIdNo=request.getParameter("National_Id_No");if(NationalIdNo==null)NationalIdNo="";
        String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
        String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
        String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
        String Area=request.getParameter("Area");if(Area==null)Area="";
        String FamilyNo=request.getParameter("Family_No");if(FamilyNo==null) FamilyNo="";
        String referral_id = request.getParameter("p_referral_id");if(referral_id==null) referral_id="";
        String q_booking_type = request.getParameter("q_booking_type");
		if(q_booking_type==null) q_booking_type="";
		String functionid = request.getParameter("function_id");
		if(functionid==null) functionid = "";
		String drfunctionid = request.getParameter("dr_function_id");
		if(drfunctionid==null) drfunctionid = "";
		//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
		String a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";

		if(func_act.equals("Visitreg") || !booking_ref_no.equals("") || func_act.equals("REF_SEARCH")||func_act.equals("DuplicateRegistration"))
        {
			//out.println("<html><head><title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisterPatient.label","mp_labels")+"</title><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><iframe id='commontoolbarFrame'  name='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:38%;width:100vw'></iframe> <iframe name='f_query_add_mod' src='../../eMP/jsp/PatRegLoad.jsp?First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&family_name_loc_lang="+a_family_name_loc_lang+"&first_name_loc_lang="+a_first_name_loc_lang+"&second_name_loc_lang="+a_second_name_loc_lang+"&third_name_loc_lang="+a_third_name_loc_lang+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&q_booking_type="+q_booking_type+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&referral_id="+referral_id+"&function_id="+functionid+"&dr_function_id="+drfunctionid+"' frameborder=0 style='height:100vh;width:100vw'></iframe><iframe id='messageFrame'  name='messageFrame'   src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:30%;width:100vw'></iframe></html> "); //commented 8-3-2012 for the incident IN031010
	//cmd by vijayan for testing		//out.println("<html><head><title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisterPatient.label","mp_labels")+"</title><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src=\"../../eCommon/js/showModalDialog.js\" language='JavaScript'></script></head><iframe id='commontoolbarFrame'  name='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:7vh;width:100vw'></iframe> <iframe id='f_query_add_mod' name='f_query_add_mod' src='../../eMP/jsp/PatRegLoad.jsp?First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&family_name_loc_lang="+a_family_name_loc_lang+"&first_name_loc_lang="+a_first_name_loc_lang+"&second_name_loc_lang="+a_second_name_loc_lang+"&third_name_loc_lang="+a_third_name_loc_lang+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&q_booking_type="+q_booking_type+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&referral_id="+referral_id+"&race_code="+a_race_code+"&function_id="+functionid+"&dr_function_id="+drfunctionid+"' frameborder=0 style='height:88vh;width:100vw'></iframe><iframe id='messageFrame'  name='messageFrame'   src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:5vh;width:100vw'></iframe></html> ");//Modified on 8-3-2012 for the incident IN031010
				//Above line modified for this incident [IN:038818]
			//added by vijayan for eMP testing
			out.println("<html><head><title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisterPatient.label","mp_labels")+"</title><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link><Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration3.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration2.js\"></Script><script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script></head><iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\"    src="+source+" scrolling=\"no\" noresize style=\"height:7vh;width:99vw\"></iframe> <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eMP/jsp/PatRegLoad.jsp?First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&family_name_loc_lang="+a_family_name_loc_lang+"&first_name_loc_lang="+a_first_name_loc_lang+"&second_name_loc_lang="+a_second_name_loc_lang+"&third_name_loc_lang="+a_third_name_loc_lang+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&q_booking_type="+q_booking_type+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&referral_id="+referral_id+"&race_code="+a_race_code+"&function_id="+functionid+"&dr_function_id="+drfunctionid+"\" frameborder=0 style=\"height:86vh;width:99vw\"></iframe><iframe name=\"messageFrame\" id=\"messageFrame\"   src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:5vh;width:99vw\"></iframe></html> ");//Modified on 8-3-2012 for the incident IN031010
        }
        else if ( (appt_ref_no == null || appt_ref_no.equals("")) && func_act.equals(""))
        {
         
			if(inv_pat_search_in_reg_pat_yn.equals("N"))
			{
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><iframe id='commontoolbarFrame'  name='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:38%;width:100vw'></iframe> <iframe id='f_query_add_mod'  name='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:100vh;width:100vw'></iframe><iframe id='messageFrame'  name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:40%;width:100vw'></iframe></html> ");//commented 8-3-2012 for the incident IN031010
				out.println("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link><Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration3.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration2.js\"></Script><script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script></head><iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\"    src="+source+" scrolling=\"no\" noresize style=\"height:7vh;width:100vw\"></iframe> <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eCommon/html/blank.html\" frameborder=0 style=\"height:85vh;width:100vw\"></iframe><iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:10vh;width:100vw\"></iframe></html> ");//Modified on 8-3-2012 for the incident IN031010
			//cmd by vijayan for testing//out.println("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link><Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration3.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration2.js\"></Script></head><iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\"   src="+source+" style='height:38vh;width:100vw' scrolling=\"no\" noresize> <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eCommon/html/blank.html\"style='height:7vh;width:100vw' scrolling=\"auto\"><iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" noresize style='height:40vh;width:100vw' scrolling=\"auto\"></html> ");
			}
			else if(inv_pat_search_in_reg_pat_yn.equals("Y"))
			{
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><iframe id='commontoolbarFrame'  name='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:38%;width:100vw'></iframe> <iframe id='f_query_add_mod'  name='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=9' frameborder=0 style='height:100vh;width:100vw'></iframe><iframe id='messageFrame'  name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:40%;width:100vw'></iframe></html> ");//commented 8-3-2012 for the incident IN031010
			out.println("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link><Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration3.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration2.js\"></Script><script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script></head><iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\"    src="+source+" scrolling=\"no\" noresize style=\"height:7vh;width:100vw\"></iframe> <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eMP/jsp/blank.jsp?step_1=9\" frameborder=0 scrolling=\"no\" style=\"height:85vh;width:100vw\"></iframe><iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:8vh;width:100vw\"></iframe></html> ");
			//cmd by vijayan for testing 	//out.println("<html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/"+sStyle+"\"></link><Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration3.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration1.js\"></Script><Script language=\"javascript\" src=\"../../eMP/js/PatientRegistration2.js\"></Script></head><iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" src="+source+" style='height:86vh;width:100vw' scrolling=\"no\" noresize></iframe> <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eMP/jsp/blank.jsp?step_1=9\" style='height:86vh;width:100vw'></iframe><iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" style='height:7vh;width:100vw' scrolling=\"auto\" noresize></iframe></html> ");
			}
        }
        else
        {   
			//cmd by vijayan for testing 	//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src=\"../../eCommon/js/showModalDialog.js\" language='javascript'></script></head><iframe id='commontoolbarFrame'  name='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:7vh;width:100vw'></iframe> <iframe id='f_query_add_mod'  name='f_query_add_mod' src='../../eMP/jsp/PatRegLoad.jsp?appt_ref_no="+appt_ref_no+"' frameborder=0 style='height:86vh;width:100vw'></iframe><iframe id='messageFrame' name='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:7vh;width:100vw'></iframe></html> ");//commented 8-3-2012 for the incident IN031010
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script><Script src='../../eCommon/js/common.js' language='JavaScript'></script><Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script><Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script><script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script></head><iframe name='commontoolbarFrame' id='commontoolbarFrame'    src="+source+" scrolling='no' noresize style='height:7vh;width:100vw'></iframe> <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/PatRegLoad.jsp?appt_ref_no=\"+appt_ref_no+\"' frameborder=0 scrolling=\"no\" style='height:85vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe></html> ");
		}
		
} catch(Exception e) {
	e.printStackTrace(); 	
} finally {
	if (stmt!= null) stmt.close();
	if (rs!= null) rs.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
