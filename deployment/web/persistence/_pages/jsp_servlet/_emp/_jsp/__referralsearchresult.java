package jsp_servlet._emp._jsp;

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
import java.net.*;
import webbeans.eCommon.*;

public final class __referralsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReferralSearchResult.jsp", 1742366753813L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eMP/js/ReferralSearch.js\' language=\'javascript\'></script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'> \n<form name=search_form id=search_form > \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\'referral_search_result\' id=\'referral_search_result\' method=\'post\' target=\'messageframe\' >\n\t\t<input type = \'hidden\' name = \'whereClause\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type = \'hidden\' name = \'p_select\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type = \'hidden\' name = \'p_calling_function\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type = \'hidden\' name = \'Unregpatbkgyn\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type = \'hidden\' name = \'p_reg_patient\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type = \'hidden\' name = \'calledFrom\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type = \'hidden\' name = \'p_search_speciality_code\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'OsVal\' id=\'OsVal\' value=\'\'></input>\n\t\t<input type=\'hidden\' name=\'old_referrals\' id=\'old_referrals\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<P>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n\n\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t</P>\n\t\t\t<table width=\'170%\' cellspacing=0 cellpadding=0 border=1>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t<th  nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<th  nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<th  nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\t\n\t\t\t<th  nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t<th  nowrap>&nbsp;</th>\n\t\t\t<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<input type=\'hidden\' name=\'ordercatlog\' id=\'ordercatlog\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'></input>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t</table>\n\n\t\t</form>\n\t\t<form name=\'printrep\' id=\'printrep\' method=\'post\' action=\'../../servlet/eOP.repReprintRefLetter\' target=\'messageFrame\'>\n\t\t<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'OPRFLETR\'></input>\n\t\t<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'OP\'></input>\n\t\t<input type= \'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'></input>\n\t\t<input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'\'></input>\n\t\t<input type=\'hidden\' name=\'p_referral_ids\' id=\'p_referral_ids\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'></input>\n\t\t<input type=\'hidden\' name=\'p_to_locn_type\' id=\'p_to_locn_type\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'></input>\n\t\t<input type=\'hidden\' name=\'p_to_locn_code\' id=\'p_to_locn_code\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'></input>\n\t\t\n\n\t\t</form>\n\t\t</body>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</html>\n\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con					 = null;
	Statement stmt					 = null;
	ResultSet rset					 = null ;
	StringBuffer  sql				 = new StringBuffer();
	String Unregpatbkgyn = "";
	try
	{
		con							 = ConnectionManager.getConnection(request);

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS");

		stmt						 = con.createStatement();
		String facilityId			 = (String)session.getValue("facility_id");	
		StringBuffer whereClauseBuild= new StringBuffer();
		String status				 =  request.getParameter("status");
		status						= (status == null)?"":status;
		String STATUS_DESC = "";
		  		
		String p_calling_function	 = request.getParameter("p_calling_function");		
		p_calling_function	 = (p_calling_function == null)?"":p_calling_function;	

		//Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
       //Ended by Suji Keerthi for NMC-JD-CRF-0130

/*	
		String ip_install_yn="";
	    PreparedStatement 	 ip_install_pstmt = con.prepareStatement("select install_yn from sm_module where module_id ='IP'");
        ResultSet ip_install_rs = ip_install_pstmt.executeQuery();
		if (ip_install_rs!=null && ip_install_rs.next())	  
		{
			ip_install_yn = ip_install_rs.getString("install_yn");
		}				
		if(ip_install_rs != null) ip_install_rs.close();
		if(ip_install_pstmt != null) ip_install_pstmt.close();
*/

		if(p_calling_function.equalsIgnoreCase("IP_BOOKING"))
		{ 
			String ipsql = "select UNREGISTERED_PATIENTS_BKG_YN from ip_param where facility_id = '"+facilityId+"' and 'Y' = (select install_yn from sm_module where module_id ='IP')";
			rset = stmt.executeQuery(ipsql);
			if(rset!=null && rset.next())
			{
				Unregpatbkgyn = rset.getString("UNREGISTERED_PATIENTS_BKG_YN");
				if(Unregpatbkgyn == null) Unregpatbkgyn="N";
			}
			if(rset != null) rset.close();
		}	
				
	    String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
		
		String calledFrom         = request.getParameter("calledFrom");
		if(calledFrom==null) calledFrom =""; 
		
        String function_id   =request.getParameter("ass_func_id");
		function_id	 = (function_id == null)?"":function_id;	
		String whereClause				 = request.getParameter("whereClause");
		if(whereClause==null) whereClause="";
                  
		String referral_ids="";
		StringBuffer displaydata = new StringBuffer();
		String p_mode					 = request.getParameter("p_mode");
		p_mode							 = (p_mode==null)?"":p_mode;
		String p_select					 = request.getParameter("p_select");
		p_select						 = (p_select==null)?"":p_select;
		
		String p_reg_patient			 = request.getParameter("p_reg_patient");
		p_reg_patient					 = (p_reg_patient==null)?"":p_reg_patient;
		String p_to_locn_type			 = request.getParameter("p_to_locn_type");
		p_to_locn_type					 = (p_to_locn_type==null)?"":p_to_locn_type;

		String p_to_locn_code			 = request.getParameter("p_to_locn_code");
		p_to_locn_code					 = (p_to_locn_code==null)?"":p_to_locn_code;


		String Nric_no		         = request.getParameter("nric_no");
		Nric_no		     = (Nric_no == null)?"":Nric_no;	
		String Pmi_no		         = request.getParameter("pmi_no");
		Pmi_no		     = (Pmi_no == null)?"":Pmi_no;	
		
		Pmi_no =java.net.URLDecoder.decode(Pmi_no);
		
		String Passport_no		     = request.getParameter("passport_no");
		Passport_no	     = (Passport_no == null)?"":Passport_no;
		Passport_no =java.net.URLDecoder.decode(Passport_no);
		String Other_Alt_Type	     = request.getParameter("other_alt_type");
		Other_Alt_Type   = (Other_Alt_Type == null)?"":Other_Alt_Type;
		String Other_Alt_Id		     = request.getParameter("other_alt_id");
		Other_Alt_Id     = (Other_Alt_Id == null)?"":Other_Alt_Id;	
		String license_no            = request.getParameter("license_no");
		license_no            = (license_no ==null)?"":license_no;
		license_no =java.net.URLDecoder.decode(license_no);
	 
	    String old_ic_no              = request.getParameter("old_ic_no");
		old_ic_no             = (old_ic_no ==null)?"":old_ic_no;
		old_ic_no =java.net.URLDecoder.decode(old_ic_no);

		String patient_id		         = request.getParameter("patient_id");
		patient_id		     = (patient_id == null)?"":patient_id;	
        String first_name		         = request.getParameter("first_name");
		first_name		     = (first_name == null)?"":first_name;	
		String local_lang = request.getParameter("local_lang");
		if(local_lang==null)
			local_lang="N";
        String second_name		         = request.getParameter("second_name");
		second_name		     = (second_name == null)?"":second_name;

        String third_name		         = request.getParameter("third_name");
		third_name		     = (third_name == null)?"":third_name;	


        String family_name		         = request.getParameter("family_name");
		family_name		     = (family_name == null)?"":family_name;	
        

 
        String old_referrals=request.getParameter("old_referrals");
        if(old_referrals==null)old_referrals="N";
		 
    	String name_prefix		         = request.getParameter("name_prefix");
	  	name_prefix		     = (name_prefix == null)?"":name_prefix;
	   
        
   		int cnt=0;
		
		StringBuffer temp=new StringBuffer();
    
		while(name_prefix.indexOf("'",cnt)!=-1)
		{	
			
			int a=name_prefix.indexOf("'",cnt);
			temp.setLength(0);
			temp.append(name_prefix);
			temp.replace(a,a+1,"''");
			name_prefix=temp.toString();
			cnt=(a+2);
		}
		
		temp.setLength(0);

		String name_suffix		         = request.getParameter("name_suffix");
		name_suffix		     = (name_suffix == null)?"":name_suffix;	

		String referral_id		         = request.getParameter("referral_id");
		referral_id		     = (referral_id == null)?"":referral_id;

			
		String referral_priority          ="";
		String prev_referral_priority          ="";
        String referral_date_from		 = request.getParameter("referral_date_from");
		referral_date_from	 = (referral_date_from == null)?"":referral_date_from;	
        String referral_date_to		     = request.getParameter("referral_date_to");
		referral_date_to	 = (referral_date_to == null)?"":referral_date_to;	
        String source_type		         = request.getParameter("source_type");
		source_type		     = (source_type == null)?"":source_type;	
  
		String source				     = request.getParameter("source");
		source				 = (source == null)?"":source;	
        String ref_from_loc_typ		     = request.getParameter("ref_from_loc_typ");
		ref_from_loc_typ     = (ref_from_loc_typ == null)?"":ref_from_loc_typ;	
		String ref_from_loc			     = request.getParameter("ref_from_loc");
		ref_from_loc		 = (ref_from_loc == null)?"":ref_from_loc;	
        String ref_from_pract			 =  request.getParameter("ref_from_pract");
		ref_from_pract		 = (ref_from_pract == null)?"":ref_from_pract;

		  String ref_from_ext_pract			 =  request.getParameter("ref_from_ext_pract");
		ref_from_ext_pract		 = (ref_from_ext_pract == null)?"":ref_from_ext_pract;

        String ref_to_loc_typ			 =  request.getParameter("ref_to_loc_typ");
		ref_to_loc_typ		 = (ref_to_loc_typ == null)?"":ref_to_loc_typ;
        String ref_to_loc				 =  request.getParameter("ref_to_loc");
		ref_to_loc			 = (ref_to_loc == null)?"":ref_to_loc;
		String from_speciality_code		=  request.getParameter("from_speciality_code");
		from_speciality_code		 = (from_speciality_code == null)?"":from_speciality_code;
	    String to_speciality_code		 =  request.getParameter("to_speciality_code");
		to_speciality_code			 = (to_speciality_code == null)?"":to_speciality_code;

		String p_search_speciality_code	 =  request.getParameter("p_search_speciality_code");
		p_search_speciality_code = (p_search_speciality_code == null)?"":p_search_speciality_code;

		String to_service_code		     =  request.getParameter("to_service_code");
		to_service_code			 = (to_service_code == null)?"":to_service_code;
		String from_service_code		  =  request.getParameter("from_service_code");
		from_service_code		 = (from_service_code == null)?"":from_service_code;

		String priority		             =  request.getParameter("priority");
		priority				= (priority == null)?"":priority;
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		String created_frm_date = request.getParameter("created_frm_date");
		created_frm_date = (created_frm_date == null)?"":created_frm_date;

		String created_to_date = request.getParameter("created_to_date");
		created_to_date = (created_to_date == null)?"":created_to_date;

		String pref_frm_date = request.getParameter("pref_frm_date");
		pref_frm_date = (pref_frm_date == null)?"":pref_frm_date;

		String pref_to_date = request.getParameter("pref_to_date");
		pref_to_date = (pref_to_date == null)?"":pref_to_date;
		
		String ref_to_pract				 =  request.getParameter("ref_to_pract");
		ref_to_pract			 = (ref_to_pract == null)?"":ref_to_pract;
       

		int	k = 0;
	

	if ((whereClause == null) ||(whereClause.equals(""))) 
	{
		whereClause               =""; 
		whereClauseBuild.setLength(0);

		if(!p_calling_function.equals("INDEPENDENT")) {
			whereClauseBuild.append(" where  TO_FACILITY_ID ='"+facilityId+"' ");
		} else {
			whereClauseBuild.append(" where  1 = 1 ");
		}

		if(old_referrals.equals("Y"))
			whereClauseBuild.append(" and trunc(PREFERRED_TREATMENT_DATE)<trunc(sysdate) ");
		else
			whereClauseBuild.append(" and ((trunc(PREFERRED_TREATMENT_DATE)>=trunc(sysdate)) OR (PREFERRED_TREATMENT_DATE is null)) ");

		if(!referral_id.equals(""))
			whereClauseBuild.append(" AND REFERRAL_ID = '"+referral_id+"' ");

		if(!patient_id.equals(""))		
			whereClauseBuild.append(" and PATIENT_ID = '"+patient_id+"' "); 

		if(!Nric_no.equals(""))
			whereClauseBuild.append(" and national_id_no = '"+Nric_no+"' ");   
		if(!Pmi_no.equals(""))
			whereClauseBuild.append(" and ALT_ID1_NO = '"+Pmi_no+"' ");  
		if(!Passport_no.equals(""))
			whereClauseBuild.append(" and ALT_ID2_NO = '"+Passport_no+"' ");
		if(!Other_Alt_Type.equals(""))
			whereClauseBuild.append(" and OTH_ALT_ID_TYPE = '"+Other_Alt_Type+"' ");
		if(!Other_Alt_Id.equals(""))
			whereClauseBuild.append(" and OTH_ALT_ID_NO = '"+Other_Alt_Id+"' ");
		if(!license_no.equals(""))
			whereClauseBuild.append(" and ALT_ID3_NO = '"+license_no+"' ");
		if(!old_ic_no.equals(""))
			whereClauseBuild.append(" and ALT_ID4_NO = '"+old_ic_no+"' ");
	
		if(!local_lang.equals("Y"))
		{
			if (!name_prefix.equals(""))				
				whereClauseBuild.append(" and NAME_PREFIX = '"+name_prefix+"' "); 	        
			if (!first_name.equals(""))			
				whereClauseBuild.append( " and Lower(FIRST_NAME) like Lower('"+first_name+"') "); 			
			if (!second_name.equals(""))			
				whereClauseBuild.append( " and Lower(SECOND_NAME) like Lower('"+second_name+"')"); 
			if (!third_name.equals(""))			 
				whereClauseBuild.append( " and Lower(THIRD_NAME) like Lower('"+third_name+"') ");            
		   	if (!family_name.equals(""))
				whereClauseBuild.append( " and Lower(FAMILY_NAME) like Lower('"+family_name+"' )"); 
			if (!name_suffix.equals(""))		
				whereClauseBuild.append(" and Lower(NAME_SUFFIX) like Lower('"+name_suffix+"') "); 
		}
		else
		{
			if (!name_prefix.equals(""))				
			  whereClauseBuild.append(" and NAME_PREFIX_LOC_LANG = '"+name_prefix+"' "); 
           	if (!first_name.equals(""))			
			  whereClauseBuild.append( " and Lower(FIRST_NAME_LOC_LANG) like Lower('"+first_name+"') ");           
			if (!second_name.equals(""))			
			  whereClauseBuild.append( " and Lower(SECOND_NAME_LOC_LANG) like Lower('"+second_name+"') ");            
		   	if (!third_name.equals(""))			
			  whereClauseBuild.append( " and Lower(THIRD_NAME_LOC_LANG) like Lower('"+third_name+"') ");            
		   	if (!family_name.equals(""))			
			  whereClauseBuild.append( " and Lower(FAMILY_NAME_LOC_LANG) like Lower('"+family_name+"') ");             
	    	if (!name_suffix.equals(""))		
			  whereClauseBuild.append(" and Lower(NAME_SUFFIX_LOC_LANG) like Lower('"+name_suffix+"') "); 
		}
		
		if(!source_type.equals("")) {
			if(source_type.equals("E")) {
				whereClauseBuild.append( " and (FROM_REF_TYPE = nvl('"+source_type+"',FROM_REF_TYPE) or FROM_REF_TYPE = 'L') "); 
			} else {
				whereClauseBuild.append(" and FROM_REF_TYPE = nvl('"+source_type+"',FROM_REF_TYPE) "); 
			}
		}
		if(!source.equals("")) 
		{
			if(!source_type.equals("") && source_type.equalsIgnoreCase("X"))
				whereClauseBuild.append( " and FROM_REF_CODE is not null and FROM_REF_CODE = '"+source+"' "); 
			else
				whereClauseBuild.append(" and FROM_FACILITY_ID is not null and FROM_FACILITY_ID = '"+source+"' "); 
		}

		if(!source_type.equals(""))
		{
			if(!ref_from_loc_typ.equals(""))
			{
				whereClauseBuild.append( " and (FROM_LOCN_TYPE='"+ref_from_loc_typ+"' )");
			}
			if(!ref_from_loc.equals(""))
			{
				if(!ref_from_loc_typ.equals("N"))
				{					
					whereClauseBuild.append(" and FROM_CLINIC_CODE = '"+ref_from_loc+"' "); 
				}
				else
				{				 
				  whereClauseBuild.append( " and FROM_NURS_UNIT_CODE = '"+ref_from_loc+"' ");
				}
			}
		}
		if (!(ref_from_pract.equals("")))			
			whereClauseBuild.append( " and FROM_PRACT_ID = '"+ref_from_pract+"' ");

	   if(source_type.equals("X")){
		 if (!(ref_from_ext_pract.equals("")))
			whereClauseBuild.append( " and UPPER(FROM_PRACT_NAME) like UPPER('%"+ref_from_ext_pract+"%')");
       }

		if (!(ref_to_pract.equals("")))			
			whereClauseBuild.append( " and TO_PRACT_ID = '"+ref_to_pract+"' "); 

		if(!ref_to_loc_typ.equals(""))
		{			
			whereClauseBuild.append( " and TO_LOCN_TYPE='"+ref_to_loc_typ+"' ");
			if(!ref_to_loc.equals(""))
			{
				if(!ref_to_loc_typ.equals("N"))
				{					
					whereClauseBuild.append( " and TO_CLINIC_CODE ='"+ref_to_loc+"' "); 
				}
				else
				{					
					whereClauseBuild.append( " and TO_NURS_UNIT_CODE = '"+ref_to_loc+"' ");
				}
			}
		}
		else
		{
			if(p_calling_function.equalsIgnoreCase("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT")) 
			{
				if(p_to_locn_type.equalsIgnoreCase("C"))
					whereClauseBuild.append(" and (TO_LOCN_TYPE ='C')");
				else if(p_to_locn_type.equalsIgnoreCase("E"))
					whereClauseBuild.append(" and (TO_LOCN_TYPE ='E')");
				else if(p_to_locn_type.equalsIgnoreCase("D"))
					whereClauseBuild.append( " and (TO_LOCN_TYPE ='Y')");
			}
			else if(p_calling_function.equalsIgnoreCase("OP_REG_VISIT")&&function_id.equalsIgnoreCase("VISIT_REGISTRATION"))
			{
			  whereClauseBuild.append( " and (TO_LOCN_TYPE IN ('E','C'))"); 	
			}			
			else if(p_calling_function.equalsIgnoreCase("IP_BOOKING") || p_calling_function.equalsIgnoreCase("IP_ADMIT") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS"))
			{
				whereClauseBuild.append(" and (TO_LOCN_TYPE = 'N' )"); 	
			}
			else if(p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") ||p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS")) 
			{
				whereClauseBuild.append( " and (TO_LOCN_TYPE ='C')");
			}
		}

		if(p_calling_function.equalsIgnoreCase("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OP_REG_VISIT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT") || p_calling_function.equalsIgnoreCase("IP_BOOKING") || p_calling_function.equalsIgnoreCase("IP_ADMIT") || p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS"))	
		{
			whereClauseBuild.append( " and STATUS = 'O' "); 
		}

	

		if(p_calling_function.equalsIgnoreCase("CHANGE_PAT_REFERRAL")){
			//whereClauseBuild.append( " and STATUS in ('C','O') and CLOSE_ENCOUNTER_ID is NULL ");  --- modified on 11 march 2014 to check reject status query. Jithesh
			whereClauseBuild.append( "  and CLOSE_ENCOUNTER_ID is NULL ");
		}

		if(!priority.equals(""))			
			whereClauseBuild.append( " and REFERRAL_PRIORITY  = '"+priority+"' ");
		
		/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
		if (!created_frm_date.equals("") && !created_to_date.equals(""))
		{
			whereClauseBuild.append(" and to_date(to_char(a.ADDED_DATE,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('");
			whereClauseBuild.append(created_frm_date);
			whereClauseBuild.append("','dd/mm/yyyy') and ");
			whereClauseBuild.append(" to_date('");
			whereClauseBuild.append(created_to_date);
			whereClauseBuild.append("','dd/mm/yyyy')");
		}

		if (!pref_frm_date.equals("") && !pref_to_date.equals(""))
		{
			whereClauseBuild.append(" and to_date(to_char(PREFERRED_TREATMENT_DATE,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('");
			whereClauseBuild.append(pref_frm_date);
			whereClauseBuild.append("','dd/mm/yyyy') and ");
			whereClauseBuild.append(" to_date('");
			whereClauseBuild.append(pref_to_date);
			whereClauseBuild.append("','dd/mm/yyyy')");
		}
		/*End MMS-DM-CRF-0187*/

		if(!p_calling_function.equalsIgnoreCase("IP_PENDING_REFERRAL_BOOKING"))
		{
			if(!status.equals(""))			
			whereClauseBuild.append( " and STATUS  = '"+status+"' ");
		}		

		if(p_calling_function.equalsIgnoreCase("IP_BOOKING"))
		{
			whereClauseBuild.append( " and REFERRED_FOR_IP= 'B' ");		
		}					
		else if(p_calling_function.equalsIgnoreCase("IP_ADMIT") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS"))
		{
			whereClauseBuild.append( " and REFERRED_FOR_IP='A' ");
		}

		

		if(!to_speciality_code.equals(""))
			whereClauseBuild.append( " and TO_SPECIALITY_CODE='"+to_speciality_code+"' ");
	
		if(!to_service_code.equals(""))			
			whereClauseBuild.append( " and TO_SERVICE_CODE= '"+to_service_code+"'");	
		    
		
		if(!from_speciality_code.equals(""))			
			whereClauseBuild.append( " and FROM_SPECIALITY_CODE = '"+from_speciality_code+"' ");

		if(!from_service_code.equals(""))			
			whereClauseBuild.append( " and FROM_SERVICE_CODE = '"+from_service_code+"'");
	
		


		}
		else
	    {
			whereClauseBuild.append(java.net.URLDecoder.decode(whereClause));
		}

		if(p_calling_function.equalsIgnoreCase("IP_PENDING_REFERRAL_BOOKING"))
		{		
			whereClauseBuild.append(" and status = 'O'   ");		
			whereClauseBuild.append(" and to_locn_type = 'N' ");		
			whereClauseBuild.append(" and referred_for_ip = 'B' ");		
		}
		else if(p_calling_function.equalsIgnoreCase("OA_PENDING_REFERRAL_BOOKING"))
		{	
			//whereClauseBuild.append(" and status = 'O' ");
			//Commented and added for SRR20056-SCF-6131 [IN:025305] by suresh M on 24.01.2010
			whereClauseBuild.append(" and status in('O','D') ");		
			whereClauseBuild.append(" and to_locn_type != 'N' ");		
		//	whereClauseBuild.append(" and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') ");		
		}
		

			sql.append(" select REFERRAL_PRIORITY, REFERRAL_ID, ORDER_CATALOG_CODE, status STATUS_DESC, REF_NOTES, to_char(REFERRAL_DATE,'dd/mm/yyyy') REFERRAL_DATE, to_char(PREFERRED_TREATMENT_DATE,'dd/mm/yyyy') PREFERRED_DATE, TO_SPECIALITY_CODE to_speciality_code, AM_GET_DESC.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+locale+"','2') to_speciality_desc, REFERRAL_DATE R_DATE, nvl(TO_LOCN_TYPE,'X') TO_LOCN_TYPE, nvl(to_locn_code,'') TO_CLINIC_CODE, nvl(to_locn_code,'') TO_NURS_UNIT_CODE, TO_LOCN_CODE, TO_PRACT_ID, TO_REF_CODE, PATIENT_ID, status, decode(FROM_REF_TYPE, 'X', AM_GET_DESC.AM_REFERRAL(FROM_REF_CODE,'"+locale+"',1), SM_GET_DESC.SM_FACILITY_PARAM(FROM_FACILITY_ID,'"+locale+"','1')) FROM_SOURCE_DESC, decode(FROM_REF_TYPE, 'E', decode(FROM_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(FROM_FACILITY_ID, FROM_LOCN_CODE, '"+locale+"','1'), OP_GET_DESC.OP_CLINIC(FROM_FACILITY_ID, FROM_LOCN_CODE,'"+locale+"','1')), 'X', FROM_LOCN_DESC) FROM_LOCN_DESC, decode(FROM_REF_TYPE,  'X', NVL(from_pract_name,am_get_desc.am_ext_practitioner (from_pract_id, '"+locale+"', '1')), am_get_desc.am_practitioner (from_pract_id, '"+locale+"', '1') ) FROM_PRACT_NAME, decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) ||','||decode(SEX,'M','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"','F','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"') PATIENT_DETAIL, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH,  decode(TO_REF_TYPE, 'E', SM_GET_DESC.SM_FACILITY_PARAM(TO_FACILITY_ID,'"+locale+"','1'), 'X', AM_GET_DESC.AM_REFERRAL(TO_REF_CODE,'"+locale+"','2')) TO_SOURCE_DESC, decode(TO_REF_TYPE, 'X', to_LOCN_DESC, 'L', decode(TO_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(TO_FACILITY_ID, to_locn_code,'"+locale+"','1'), OP_GET_DESC.OP_CLINIC(TO_FACILITY_ID,to_locn_code,'"+locale+"','1'))) TO_LOCN_DESC, decode(TO_REF_TYPE, 'E', AM_GET_DESC.AM_PRACTITIONER(TO_PRACT_ID,'"+locale+"','1'), 'X', TO_PRACT_NAME, 'L', am_get_desc.am_practitioner(to_pract_id, '"+locale+"', '2')) TO_PRACT_NAME,");
		
			sql.append("to_char(a.ADDED_DATE,'dd/mm/yyyy') ADDED_DATE from PR_REFERRAL_SEARCH_VW a");
	
			if(p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN"))
			{				
				sql.append(", op_clinic c");
				whereClauseBuild.append(" AND a.to_facility_id = c.facility_id(+) ");
				whereClauseBuild.append(" and a.to_locn_code = c.clinic_code(+)  ");		
				whereClauseBuild.append("  and (c.LEVEL_OF_CARE_IND = 'E' or a.to_locn_code is null) ");			
			}
			
			
		   sql.append( whereClauseBuild.toString());
		   //Below line modifed Query tuning for full table scan [IN:051268]
		   sql.append( " AND A.REFERRAL_ID BETWEEN NVL ('%%','%%')  AND NVL ('',A.REFERRAL_ID) AND A.REFERRAL_ID LIKE '%%' order by referral_priority, r_date desc, referral_id ");

		   
		 
			int start = 0 ;
			int end = 0 ;
			int i=1;
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
					end = 10 ;
				else
				end = Integer.parseInt( to ) ;		
				
			rset = stmt.executeQuery(sql.toString()); 	
			
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClauseBuild.toString())));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_select));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_reg_patient));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_search_speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(old_referrals));
            _bw.write(_wl_block16Bytes, _wl_block16);

	String classValue	= ""; 
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rset.next() ;
	String referral_id_sql	  = "";
	StringBuffer from_referral	  =new StringBuffer();
	from_referral.setLength(0);
			
	StringBuffer patient_id_sql     =new StringBuffer();
	patient_id_sql.setLength(0);

	Clob note =null;
	int cnt1=0;
	if(rset != null)
	{
		while( i<=end && rset.next())
		{
			if(cnt1==0)
			{
            _bw.write(_wl_block17Bytes, _wl_block17);


			if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='javaScript:callMethod1("+start+","+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");	

			
            _bw.write(_wl_block18Bytes, _wl_block18);


			out.println("<A HREF='javaScript:callMethod("+start+","+end+");' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block19Bytes, _wl_block19);

			if (!(p_calling_function.equalsIgnoreCase("CHANGE_PAT_REFERRAL")))
			{
		 	out.println("<th width='2%'>&nbsp;</th>");
			}/* Thursday, December 24, 2009 17559 */
			
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(!isImproveReferralProcessAppl){
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
		}

			if(i<=end) 
			{
			if(k % 2 == 0)
			classValue 		  = "QRYODD" ;
			else
			classValue 		  = "QRYEVEN" ;

			String preferred_date="";

			String to_referral	      = "";
			String to_referral1	      = "";
			String to_referral2	      = "";
			String to_referral3	      = "";

			String 	p_allowed_yn	  = "N";
			String  ref_notes         ="";
			referral_id_sql			  = rset.getString("REFERRAL_ID");
			referral_ids = referral_ids + referral_id_sql + ",";
			referral_priority         = rset.getString("REFERRAL_PRIORITY");
			ref_notes                 = rset.getString("REF_NOTES");
			patient_id_sql.setLength(0);
			from_referral.setLength(0);

			if (ref_notes==null)ref_notes="";
			if(  rset.getString("REF_NOTES")!=null && rset.getString("REF_NOTES") !="")
			ref_notes		 = rset.getString("REF_NOTES");
			note=rset.getClob("REF_NOTES");

			displaydata.setLength(0);

			preferred_date=rset.getString("PREFERRED_DATE");
			if (preferred_date!=null)
			preferred_date=DateUtils.convertDate(preferred_date,"DMY","en",localeName);
			else
			preferred_date="&nbsp;";
			java.io.BufferedReader r = null;
			if(note!=null)
			{
			r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) displaydata.append(line).append("\n");
			}
			if(note!=null)
			{
			r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) 	ref_notes =ref_notes + line+"\n";
			}

			if(rset.getString("FROM_SOURCE_DESC")!=null && rset.getString("FROM_SOURCE_DESC") !="")
			from_referral.append( rset.getString("FROM_SOURCE_DESC")).append("<br>");

			if(rset.getString("FROM_LOCN_DESC")!=null && rset.getString("FROM_LOCN_DESC") !="")
			from_referral.append(rset.getString("FROM_LOCN_DESC")).append("<br>"); 

			if(rset.getString("FROM_PRACT_NAME")!=null && rset.getString("FROM_PRACT_NAME") !="")
			from_referral.append(rset.getString("FROM_PRACT_NAME")); 

			if(rset.getString("PATIENT_ID")!=null && rset.getString("PATIENT_ID") !="")

			patient_id_sql.append(rset.getString("PATIENT_ID")).append(","); 
			if(rset.getString("PATIENT_DETAIL")!=null && rset.getString("PATIENT_DETAIL") !="")

			patient_id_sql.append(rset.getString("PATIENT_DETAIL")).append(",");
			if(rset.getString("DATE_OF_BIRTH")!=null && rset.getString("DATE_OF_BIRTH") !="")
			patient_id_sql.append(DateUtils.convertDate(rset.getString("DATE_OF_BIRTH"),"DMY","en",localeName)); 


			if(rset.getString("TO_LOCN_DESC")!=null && rset.getString("TO_LOCN_DESC") !="")
			to_referral1 = to_referral1 + rset.getString("TO_LOCN_DESC")+","; 
			else
			to_referral1="";
			if(rset.getString("to_speciality_desc")!=null && rset.getString("to_speciality_desc") !="")
			to_referral2 = to_referral2 + rset.getString("to_speciality_desc");
			else
			to_referral2="";
			if(rset.getString("TO_PRACT_NAME")!=null && rset.getString("TO_PRACT_NAME") !="")
			to_referral3=to_referral3 + ","+rset.getString("TO_PRACT_NAME"); 
			else
			to_referral3="";

			to_referral=to_referral1+to_referral2+to_referral3;

			if (to_referral==null||to_referral=="") to_referral="&nbsp;&nbsp;";

			if(!referral_priority.equalsIgnoreCase(prev_referral_priority)) {
			out.println("<tr>");
			out.println("<td colspan = 10 align = 'left' class='CAGROUPHEADING' nowrap><font size='1'>");
			 
			if(isReferralPriorityAppl){ 
                            	PreparedStatement prestmt			= null;      		
                   				ResultSet resultSet				= null;
                   				String ref_priority="";
                   				
                   				try 
                   				{				
                   				prestmt		= con.prepareStatement("SELECT PRIORITY_DESC FROM AM_REFERRAL_PRIORITY WHERE PRIORITY_CODE = (SELECT REFERRAL_PRIORITY FROM PR_REFERRAL_SEARCH_VW WHERE REFERRAL_ID = ?)");
                   				prestmt.setString(1,referral_id_sql);			
                   						
                   				resultSet	= prestmt.executeQuery() ;
                   				if (resultSet !=null && resultSet.next())
                   				{
                   					ref_priority = resultSet.getString("PRIORITY_DESC");
                   				}
								 
                   				}catch(Exception e){
                   					e.printStackTrace();
                   				}finally
                   				{
                   					if(resultSet!=null)resultSet.close();
                   					if(prestmt!=null)prestmt.close();
                   				}
								out.println("<tr>");
								out.println("<td colspan = 10 align = 'left' class='CAGROUPHEADING' nowrap><font size='1'>"+ref_priority+"");
								out.println("</td></tr>");
								
			}else{ 
			if((referral_priority.equalsIgnoreCase("E"))) 
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("U"))) 
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("R")))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("L")))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels"));
			out.println("</td></tr>");
			}
			}
			prev_referral_priority = referral_priority;
			out.println("<tr>");
			
			if (!(p_calling_function.equalsIgnoreCase("CHANGE_PAT_REFERRAL")))
			{
             
			out.println("<td class='"+classValue+"' nowrap><font size='1'>");
			out.println("<a 	href=\"javascript:viewReferral('"+rset.getString("REFERRAL_ID")+"') \">+");
			out.println("</a></td>");
			}

			STATUS_DESC=rset.getString("STATUS_DESC");
			if(!STATUS_DESC.equals(""))
			{
			switch (STATUS_DESC.charAt(0))
			{
			case  'C' :
			STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels") ;		
			break;
			case  'D' :
			STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
			break;
			case  'N' :
			STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			break;
			case  'O' :
			STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
			break;

			case  'X' :
			STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
			break;
			}
			}

			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+STATUS_DESC+"</td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"); 							

			if (p_calling_function.equalsIgnoreCase("CHANGE_PAT_REFERRAL")){ 
			out.println("<a 	href=\"javascript:sendtochangereferral('"+rset.getString("REFERRAL_ID")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+"</a>"); 
			}
			else if (p_calling_function.equalsIgnoreCase("REPRINT_REF_LETTER")){
			out.println("<a 	href=\"javascript:reprintreferral('"+rset.getString("REFERRAL_ID")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			
			}

			else
			{			
			if(!p_calling_function.equalsIgnoreCase("IP_PENDING_REFERRAL_BOOKING")&&!p_calling_function.equalsIgnoreCase("OA_PENDING_REFERRAL_BOOKING")&&(!(p_select.equalsIgnoreCase("YES")) || p_calling_function.equalsIgnoreCase("INDEPENDENT")  ))
			{
			out.println(rset.getString("REFERRAL_ID"));	
			
			}
			else
			{

			if(p_calling_function.equalsIgnoreCase("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT")) 
			p_allowed_yn = "Y";
			if(p_calling_function.equalsIgnoreCase("IP_BOOKING")) 
			p_allowed_yn = "Y";
			if(p_calling_function.equalsIgnoreCase("OP_REG_VISIT")) 
			p_allowed_yn = "Y";
			if(p_calling_function.equalsIgnoreCase("OP_REG_VISIT")) 
			p_allowed_yn = "Y";
			if(p_calling_function.equalsIgnoreCase("IP_ADMIT") || p_calling_function.equalsIgnoreCase("CHG_ADM_DTLS")) 
			p_allowed_yn = "Y";	
			if(p_calling_function.equalsIgnoreCase("AE_REGISTER_ATTN") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS")) 
			p_allowed_yn = "Y";											
			if(p_allowed_yn.equals("Y")&& old_referrals.equals("N"))
			{
			if(rset.getString("PATIENT_ID")==null || rset.getString("PATIENT_ID") =="")	 
			{
			if(p_reg_patient.equalsIgnoreCase("YES"))
			{    
			if(p_calling_function.equalsIgnoreCase("IP_BOOKING") && Unregpatbkgyn.equals("Y"))
			{
				
			out.println("<a 	href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+"</a>");
			}
			else
			{
			out.println("<a href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			}
			}
			else
			{
			if((p_calling_function.equalsIgnoreCase("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT")|| p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS")))
			{
			if (p_search_speciality_code.equals(rset.getString("TO_SPECIALITY_CODE"))) {
			out.println("<a 	href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			
			}
			else 	
			out.println(rset.getString("REFERRAL_ID"));
			}
			else
			{
				
            out.println("<a href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			}
			}
			}
			else
			{

			if((p_calling_function.equalsIgnoreCase("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT") || p_calling_function.equalsIgnoreCase("CHG_REG_DTLS") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS")))
			{
			if (p_search_speciality_code.equals(rset.getString("TO_SPECIALITY_CODE"))) 
			{
			out.println("<a 	href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			}
			else
			{
			out.println(rset.getString("REFERRAL_ID"));
			}
			}
			else
			{
             
			out.println("<a href=\"javascript:sendReferralId('"+rset.getString("REFERRAL_ID")+"','"+rset.getString("TO_LOCN_CODE")+"') \">");
			out.println(rset.getString("REFERRAL_ID")+" </a>");
			}
			}
			}
			else if(p_calling_function.equalsIgnoreCase("IP_PENDING_REFERRAL_BOOKING") || p_calling_function.equalsIgnoreCase("OA_PENDING_REFERRAL_BOOKING"))
			{				
				//Added some additional parameters by S.Sathish IN021901 on Friday, June 11, 2010 

			out.println("<a href=\"javascript:bookReferral('"+checkForNull(rset.getString("REFERRAL_ID"))+"','"+checkForNull(rset.getString("TO_LOCN_TYPE"))+"','"+checkForNull(rset.getString("TO_PRACT_ID"))+"','"+checkForNull(rset.getString("PATIENT_ID"))+"','"+checkForNull(rset.getString("TO_CLINIC_CODE"))+"','"+checkForNull(rset.getString("TO_LOCN_TYPE"))+"','"+checkForNull(rset.getString("to_speciality_code"))+"','"+checkForNull(rset.getString("TO_LOCN_CODE"))+"','"+checkForNull(rset.getString("TO_LOCN_DESC"))+"','"+checkForNull(rset.getString("TO_PRACT_NAME"))+"','"+checkForNull(rset.getString("PREFERRED_DATE"))+"') \">"); 			
			out.println(rset.getString("REFERRAL_ID")+" </a>"); 
			}
			else{

			out.println(rset.getString("REFERRAL_ID"));
			}
			}
			}


			if(from_referral.toString().equals("")) from_referral.append("&nbsp;");
			out.println("</td>");
			
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl){
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+DateUtils.convertDate(rset.getString("ADDED_DATE"),"DMY","en",localeName)+"</td>");
			}else{
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+DateUtils.convertDate(rset.getString("REFERRAL_DATE"),"DMY","en",localeName)+"</td>");
			}

			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+preferred_date+"</td>");

			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+patient_id_sql.toString()+"</td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+from_referral.toString()+"</td>");
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+to_referral+"</td>");

			out.println("<td class='"+classValue+"' nowrap>");
			out.println("<input type = 'hidden' name = 'id"+k+"' value = \""+displaydata.toString()+"\">");
			out.println("<a href=\"javascript:referral_notes('id"+k+"')\">");		
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+" </a></td>");
			//out.println("<td class='"+classValue+"' nowrap><font size='1'>"+rset.getString("ADDED_DATE")+"</td>");
			
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(!isImproveReferralProcessAppl){
			out.println("<td class='"+classValue+"' nowrap><font size='1'>"+DateUtils.convertDate(rset.getString("ADDED_DATE"),"DMY","en",localeName)+"</td>");
			}

			out.println("</tr>");	
			k++ ;	
			i++ ;	
			} 
			else
			{
			referral_id_sql			  = rset.getString("REFERRAL_ID");
			referral_ids=referral_id_sql+",";
			i++ ;	
			}	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rset.getString("ORDER_CATALOG_CODE")));
            _bw.write(_wl_block29Bytes, _wl_block29);
	cnt1++;
		}

		if (cnt1==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);parent.frames[0].document.forms[0].search.disabled = false;parent.frames[1].location.href ='../../eCommon/html/blank.html';</script>");
		}
		boolean flag = false;
		if ( cnt1 < 10 || (!rset.next()) ) {
		
            _bw.write(_wl_block30Bytes, _wl_block30);
 flag = true;
		} else {
            _bw.write(_wl_block31Bytes, _wl_block31);
}
		}

		if(rset != null) rset.close();
		if(stmt != null) stmt.close();

		sql.setLength(0);
		displaydata.setLength(0);
		from_referral.setLength(0);
		patient_id_sql.setLength(0);

		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(referral_ids));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

		whereClauseBuild.setLength(0);
		}
		catch(Exception e)
		{
		out.print(e.toString());
		e.printStackTrace();
		}
		finally
		{

		//out.println("<script>parent.frames[0].document.forms[0].search.disabled = false ;</script>");
		if(stmt!=null)	stmt.close();
		if(rset!=null)	rset.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreatedOn.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredOn.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CreatedOn.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
