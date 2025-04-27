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
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __aeservervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEServerValidation.jsp", 1709113863053L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<html>\n<body class=\'message\' onKeyDown = \'lockKey()\'>         \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t  <script>\n\n\t\t\t\t//\t  parent.frames[3].document.getElementById(\"tab1\").scrollIntoView();\n\t\t\t\t\t  parent.frames[3].document.forms[0].referal_id.value=\"\";\n\t\t\t\t\t  parent.frames[3].document.forms[0].referal_id.select();\n\t\t\t\t\t  parent.frames[3].document.forms[0].referal_id.focus();\n                      parent.frames[4].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\n\t\t\t\t\t  </script>\n                      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t  <script>\n\t\t\t\t\t\t      parent.frames[3].document.forms[0].submit(); \n\t\t\t\t\t\t  </script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</html> \n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
     
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			 = (String)session.getValue("facility_id");

		String postalcode_link_yn="";      //sarita

        Connection con = null;
		String pr_id = checkForNull(request.getParameter("process_id"));
		String rev_flag = checkForNull(request.getParameter("rev_flag"));
		ResultSet rs=null;
		PreparedStatement stmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement stmt2=null;
		ResultSet rs2=null;

        int process = Integer.parseInt(pr_id);
       
	   String revisVisitFlag = checkForNull(request.getParameter("revisVisitFlag"));
	   String referal_id = checkForNull(request.getParameter("referal_id"));
	   String patient_id = checkForNull(request.getParameter("patient_id"));
	   String params       = "module_id=AE&function_id=AE_REVISE_VISIT&function_name=Revise%20Attendance%20Details&function_type=F&menu_id=AE_TRANSACTIONS&access=NYYNN";
	   String submitFlag   = checkForNull(request.getParameter("submitFlag"));
	   String beginHtml			 = "<html><script>";
	   String endHtml			     = "</script></html>";
       try
	    {
		  con = ConnectionManager.getConnection(request);
		  try
	       {
		   if(revisVisitFlag!=null)
			{
			  if(revisVisitFlag.equals("Y"))
				{
		           session.putValue("queryString",params);
				   StringBuffer PRRef = new StringBuffer();
                   PRRef.append("select 1 from PR_REFERRAL_REGISTER where ");
				   PRRef.append(" REFERRAL_ID= ?  and PATIENT_ID= ? AND TO_FACILITY_ID =? ");
				   PRRef.append("AND (TO_LOCN_CODE IS NULL OR (TO_LOCN_CODE IS NOT NULL AND 'E'= (SELECT LEVEL_OF_CARE_IND FROM OP_CLINIC WHERE FACILITY_ID=TO_FACILITY_ID AND CLINIC_CODE=TO_LOCN_CODE) )) ");
				   // Wednesday, July 14, 2010 (venkat s) 22644
                   pstmt1  = con.prepareStatement(PRRef.toString());
				   pstmt1.setString(1, referal_id);
				   pstmt1.setString(2, patient_id);
				   pstmt1.setString(3, facility_id);
				   rs = pstmt1.executeQuery();
					  if(!rs.next()) 
					  {
                       out.println(beginHtml+"alert(getMessage('INVALID_REF_ID','OP'));"+endHtml);
					  
            _bw.write(_wl_block8Bytes, _wl_block8);

					   }
					  else if (submitFlag.equals("Y")){
						  
            _bw.write(_wl_block9Bytes, _wl_block9);

					  }
					  if(rs!=null)rs.close();
					  if(pstmt1!=null)pstmt1.close();
					  if((PRRef != null) && (PRRef.length() > 0))
						{
							PRRef.delete(0,PRRef.length());
						}
				}
			}
		} catch(Exception e) {e.printStackTrace();}

		if(rev_flag.equals("Y"))
		{
        try
        {

// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
    if(process == 7)
    {
        String postal_code = request.getParameter("postal_code");
		if(postal_code == null) postal_code = "";
		String res_area_code = request.getParameter("res_area_code");
		if(res_area_code==null) res_area_code ="";
		String region_code = request.getParameter("region_code");
		if(region_code==null) region_code ="";
		
		String res_town_code = request.getParameter("res_town_code");
		if (res_town_code==null) res_town_code ="";

		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
		
		String sql = "";
		
		if(mode.equals("first_postal_code"))
		{
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code"))
		{
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_ma_postal_code"))
		{
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_contact_ma_area_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
			fieldName5 = "nkma_town";
		}
		else if(mode.equals("fst_no_ma_pos_cod"))
		{
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_to_no_ma_area_code";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
			fieldName5 = "contact2_res_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
		}
		else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_town_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
		}
		else if(mode.equals("fst_to_no_ma_town_code")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		}
		else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
		 //Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_area_code")){
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_town";
		}
		else if(mode.equals("fst_to_no_ma_area_code")){
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_town";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
		}
		else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
        else if(mode.equals("n_contac_region_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_contact_ma_town_code";
			fieldName2 = "n_ma_postal_code";
			fieldName3 = "nkma_area";
			fieldName4 = "nkma_town";
		}
		else if(mode.equals("fst_to_no_ma_reg_cod")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_to_no_ma_town_code";
			fieldName2 = "fst_no_ma_pos_cod";
			fieldName3 = "contact2_res_area";
			fieldName4 = "contact2_res_town";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
		}
		//Added by kumar on 14/03/2003 for Defaulting area, town, region based on selection.	

		stmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
		 rs = stmt.executeQuery();

		if (rs.next())
		{
				postalcode_link_yn = rs.getString("POSTAL_CODE_LINK_YN");
				
		}
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close(); 

		if(postalcode_link_yn.equals("Y"))
		{ 

        if (!postal_code.equals(""))
		{
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where a.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName+" !=null) parent.frames[3].document.forms[0]."+fieldName+".value=\""+town_code+"\";");
				out.println("parent.frames[3].document.forms[0]."+fieldName5+".value=\""+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"\";</script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
					out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName1+" != null) parent.frames[3].document.forms[0]."+fieldName1+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
					out.println("if (parent.frames[3].document.forms[0]."+fieldName2+" !=null) parent.frames[3].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 	out.println("parent.frames[3].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 	out.println("parent.frames[3].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!res_town_code.equals(""))
		{
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
			     out.println("<script>if(parent.frames[3].document.forms[0]."+fieldName+" != null) parent.frames[3].document.forms[0]."+fieldName+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				 
				 out.println("if (parent.frames[3].document.forms[0]."+fieldName2+" !=null) parent.frames[3].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 out.println("parent.frames[3].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 out.println("parent.frames[3].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}	
			out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName1+" !=null) {parent.frames[3].document.forms[0]."+fieldName1+".value=''}</script>");

			//sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";
			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";
			stmt2 = con.prepareStatement(sql);
			rs2 = stmt2.executeQuery();
			if(rs2.next())
			{
				out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName1+" !=null) {parent.frames[3].document.forms[0]."+fieldName1+".value = \""+(rs2.getString("postal_code")==null ? "" : rs2.getString("postal_code"))+"\"}</script>");

				out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName1+"1 !=null) {parent.frames[3].document.forms[0]."+fieldName1+"1.value = \""+(rs2.getString("short_desc")==null ? "" : rs2.getString("short_desc"))+"\"}</script>");
				
			}
			/*
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("<script>if(parent.frames[3].document.forms[0]."+fieldName1+"1)parent.frames[3].document.forms[0]."+fieldName1+"1.focus();</script>");
			}
			else
			{
			out.println("<script>if(parent.frames[3].document.forms[0]."+fieldName1+")parent.frames[3].document.forms[0]."+fieldName1+".focus();</script>");
			}
			*/
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
		}
		if(!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				out.println("<script>if (parent.frames[3].document.forms[0]."+fieldName1+" !=null) parent.frames[3].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[3].document.forms[0]."+fieldName2+" !=null) parent.frames[3].document.forms[0]."+fieldName2+".value=\""+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"\";</script>");
				out.println("<script> parent.frames[3].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}
			else
			{
				out.println("<script> if(parent.frames[3].document.forms[0]."+fieldName+") parent.frames[3].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[3].document.forms[0]."+fieldName1+") parent.frames[3].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[3].document.forms[0]."+fieldName2+" ) parent.frames[3].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[3].document.forms[0]."+fieldName3+".value='';");
				out.println("parent.frames[3].document.forms[0]."+fieldName4+".value='';</script>");
			}
			/*
			out.println("<script>if(parent.frames[3].document.forms[0]."+fieldName1+"1)");
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("parent.frames[3].document.forms[0]."+fieldName1+"1.focus();</script>");
			}
			else
			{
			out.println("parent.frames[3].document.forms[0]."+fieldName1+".focus();</script>");
			}
			*/

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}
		}
		else{
           out.println("<script> if(parent.frames[3].document.forms[0]."+fieldName+") parent.frames[3].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[3].document.forms[0]."+fieldName1+") parent.frames[3].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[3].document.forms[0]."+fieldName2+" ) parent.frames[3].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[3].document.forms[0]."+fieldName3+".value='';");
				out.println("parent.frames[3].document.forms[0]."+fieldName4+".value='';</script>");
	}
		if(!region_code.equals(""))
		{
			out.println("<script> if(parent.frames[3] != null) { "); 
			out.println("if(parent.frames[3].document.forms[0] != null) { "); out.println("if(parent.frames[3].document.forms[0]."+fieldName+" )"); out.println("parent.frames[3].document.forms[0]."+fieldName+".value='';");
			out.println("if(parent.frames[3].document.forms[0]."+fieldName2+") parent.frames[3].document.forms[0]."+fieldName2+".value='';");
			out.println("if (parent.frames[3].document.forms[0]."+fieldName1+") parent.frames[3].document.forms[0]."+fieldName1+".value='';");
			out.println("parent.frames[3].document.forms[0]."+fieldName3+".value='';");
			out.println("parent.frames[3].document.forms[0]."+fieldName4+".value='';");

			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code"))
			{
			out.println("if(parent.frames[3].document.forms[0]."+fieldName2+"1)    parent.frames[3].document.forms[0]."+fieldName2+"1.focus(); } } </script>");
			}
				else
			{
				out.println("parent.frames[3].document.forms[0]."+fieldName2+".focus(); } } </script>");
			}
			*/
		}
   }

 }
    catch(Exception e){e.printStackTrace();}
		}
		else
		{
		try
        {
        // FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
    if(process == 7)
    {
        String postal_code = request.getParameter("postal_code");
		if(postal_code == null) postal_code = "";
		String res_area_code = request.getParameter("res_area_code");
		if(res_area_code==null) res_area_code ="";
		String region_code = request.getParameter("region_code");
		if(region_code==null) region_code ="";
		
		String res_town_code = request.getParameter("res_town_code");
		if (res_town_code==null) res_town_code ="";

		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
		
		String sql = "";
		
		if(mode.equals("first_postal_code"))
		{
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code"))
		{
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_ma_postal_code"))
		{
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_contact_ma_area_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
			fieldName5 = "nkma_town";
		}
		else if(mode.equals("fst_no_ma_pos_cod"))
		{
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_to_no_ma_area_code";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
			fieldName5 = "contact2_res_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
		}
		else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_town_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
		}
		else if(mode.equals("fst_to_no_ma_town_code")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		}
		else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_area_code")){
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_town";
		}
		else if(mode.equals("fst_to_no_ma_area_code")){
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_town";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
		}
		else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
        else if(mode.equals("n_contac_region_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_contact_ma_town_code";
			fieldName2 = "n_ma_postal_code";
			fieldName3 = "nkma_area";
			fieldName4 = "nkma_town";
			
		}
		else if(mode.equals("fst_to_no_ma_reg_cod")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_to_no_ma_town_code";
			fieldName2 = "fst_no_ma_pos_cod";
			fieldName3 = "contact2_res_area";
			fieldName4 = "contact2_res_town";
			
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
		}
		//Added by kumar on 14/03/2003 for Defaulting area, town, region based on selection.	

		stmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
		 rs = stmt.executeQuery();

		if (rs.next())
		{
				postalcode_link_yn = rs.getString("POSTAL_CODE_LINK_YN");
				
		}
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close(); 

		if(postalcode_link_yn.equals("Y"))
		{ 

        if (!postal_code.equals(""))
		{
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where a.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName+" !=null) parent.frames[1].frames[2].document.forms[0]."+fieldName+".value=\""+town_code+"\";");
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName5+".value=\""+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"\";</script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
					out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+" != null) parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
					out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName2+" !=null) parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 	out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 	out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!res_town_code.equals(""))
		{
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
			     out.println("<script>if(parent.frames[1].frames[2].document.forms[0]."+fieldName+" != null) parent.frames[1].frames[2].document.forms[0]."+fieldName+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				 
				 out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName2+" !=null) parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}	
			out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+" !=null) {parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value=''}</script>");

			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";
			stmt2 = con.prepareStatement(sql);
			rs2 = stmt2.executeQuery();
			if(rs2.next())
			{
				out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+" !=null) {parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value = \""+(rs2.getString("postal_code")==null ? "" : rs2.getString("postal_code"))+"\"}</script>");

				out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1 !=null) {parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1.value = \""+(rs2.getString("short_desc")==null ? "" : rs2.getString("short_desc"))+"\"}</script>");		
			}
			/*
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{			out.println("<script>if(parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1)parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1.focus();</script>");
			}
			else
			{ 			out.println("<script>if(parent.frames[1].frames[2].document.forms[0]."+fieldName1+")parent.frames[1].frames[2].document.forms[0]."+fieldName1+".focus();</script>");
			}
			*/
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
		}

		if(!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				out.println("<script>if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+" !=null) parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName2+" !=null) parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value=\""+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"\";</script>");
				out.println("<script> parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";</script>");
			}
			else
			{
				out.println("<script> if(parent.frames[1].frames[2].document.forms[0]."+fieldName+") parent.frames[1].frames[2].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+") parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName2+" ) parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value='';");
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName4+".value='';</script>");
			}

			/*
			out.println("<script>if(parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1)");
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName1+"1.focus();</script>");
			}
			else
			{
			out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName1+".focus();</script>");
			}
			*/

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}
		}
		else{
				out.println("<script> if(parent.frames[1].frames[2].document.forms[0]."+fieldName+") parent.frames[1].frames[2].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+") parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName2+" ) parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value='';");
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName4+".value='';</script>");
		}

		if(!region_code.equals(""))
		{
			out.println("<script> if(parent.frames[1].frames[2] != null) { "); 
			out.println("if(parent.frames[1].frames[2].document.forms[0] != null) { "); out.println("if(parent.frames[1].frames[2].document.forms[0]."+fieldName+" )"); out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName+".value='';");
			out.println("if(parent.frames[1].frames[2].document.forms[0]."+fieldName2+") parent.frames[1].frames[2].document.forms[0]."+fieldName2+".value='';");
			out.println("if (parent.frames[1].frames[2].document.forms[0]."+fieldName1+") parent.frames[1].frames[2].document.forms[0]."+fieldName1+".value='';");
			out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName3+".value='';");
			out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName4+".value='';");
			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code"))
			{
			out.println("if(parent.frames[1].frames[2].document.forms[0]."+fieldName2+"1) parent.frames[1].frames[2].document.forms[0]."+fieldName2+"1.focus(); } } </script>");
			}
			else
			{
				out.println("parent.frames[1].frames[2].document.forms[0]."+fieldName2+".focus(); } } </script>");
			}
			*/
		}
    }
 }
    catch(Exception e){e.printStackTrace();}
   }
	}
    catch(Exception e){e.printStackTrace();}
	finally
    {
        ConnectionManager.returnConnection(con,request);
    }


            _bw.write(_wl_block10Bytes, _wl_block10);
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
