package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __practitionerqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/PractitionerQueryResult.jsp", 1710451248683L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<style>\n\t.container {\n\t\twidth:1330px;\n\t}\n\t.container table {\n\t\twidth: 1330px;\n\t\ttable-layout: fixed;\n\t}\n\t.inner_table_site { \n\t\twidth:100%;  \n\t\theight:450px;\n\t\toverflow-y: auto;\t\n\t} \t\n</style>\n\n<HTML>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n</head>\n<BODY OnMouseDown=\'CodeArrest()\' class=\'CONTENT\' onKeyDown = \'lockKey()\' >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<p>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t</p>\n<br><br>\n\t\t<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1184 Start-->\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t<td colspan=4 class=label height=5>\t\n\t\t\t<div class=\"container\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<!--End-->\n\t\t<table border=\"1\" width=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th width=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</<th>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<th width=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</<th>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\n\t\t<th width=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th width=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t<!--Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] -->\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<th width=\"\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<th width=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<!--End-->\n\t\t<th width=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n        <th width=\"\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\n\t\t</table>\n\t\t  <div class=\"inner_table_site\">\n\t\t  <table class=\"head\" width=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t <script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</td></tr>\n</table>\n</div>\n</div>\n</td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</td></tr>\n</table>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</center>\n\n<br><center>\n\n</center>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? "" : inputString );
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	String function_id="";
	function_id = request.getParameter("function_id");
	if ( (function_id == null || function_id.equals(""))) function_id="";
	//String sqlstr="";
	String sqlstr1="";
	Connection conn = null;
	java.sql.Statement stmt = null;
	ResultSet rs = null;
	
	//Below line added for this CRF ML-MMOH-CRF-0862
	 boolean isCernerpractitioner = false; 

	boolean isFPPPractApplicable = false;//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
	
	try{

	String sql = "where a.pract_type = b.pract_type";
	if ( (whereClause == null || whereClause.equals("")) )
	{

	String cd = request.getParameter("practitioner_id");
	String ccd = request.getParameter("pract_type");
	if(ccd.equals("All")) ccd ="";
	String practitionername = request.getParameter("practitioner_name");
	String enabled = request.getParameter("eff_status");
	String primary_speciality_code = request.getParameter("primary_speciality_code");
	String primary_speciality_desc = request.getParameter("primary_speciality_desc");
	String Employee_Id = request.getParameter("Employee_Id");
	String job_title = request.getParameter("POSITION_CODE");
	String empl_status = request.getParameter("empl_status");
	String all_facilities_yn = request.getParameter("all_facilities_yn");
	String reporting_facility_id = request.getParameter("reporting_facility_id");
	String NATIONAL_ID_NUM = request.getParameter("National_ID");
	String OTH_ALT_ID_NO = request.getParameter("OTHER_ALT_NO");
	String fppPractYn = checkForNull(request.getParameter("FPP_Pract"));//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

	if ( !(cd == null || cd.equals("")) )
		{
		cd=cd.toUpperCase();
		sql=sql+" and upper(a.practitioner_id) like upper('"+cd+"%')";

		}
	if ( !(ccd == null || ccd.equals("")) )
	{
		sql=sql+" and a.pract_type like  '"+ccd+"%'" ;

	}
	if ( !(job_title == null || job_title.equals("")) )
	{
			sql=sql+" and upper(a.POSITION_CODE)  like  upper('"+job_title+"%') " ;
	}

	if ( !(empl_status == null || empl_status.equals("")) )
	{
			sql=sql+" and upper(a.empl_status)  like  upper('"+empl_status+"%') " ;
	}

	if ( !(all_facilities_yn == null || all_facilities_yn.equals("")) )
	{
			sql=sql+" and upper(a.all_facilities_yn)  like  upper('"+all_facilities_yn+"%') " ;
	}

	if ( !(reporting_facility_id == null || reporting_facility_id.equals("")) )
	{
			sql=sql+" and upper(a.reporting_facility_id)  like  upper('"+reporting_facility_id+"%') " ;
	}

	if ( !(practitionername == null || practitionername.equals("")) )
	{

			sql=sql+" and upper(a.practitioner_name)  like  upper('"+practitionername+"%') " ;

	}
	
	if ( !(primary_speciality_code == null || primary_speciality_code.equals("")) )
	{

			sql=sql+" and c.SPECIALITY_CODE like  '"+primary_speciality_code.toUpperCase()+"%' and c.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE " ;

	}

	if ( !(primary_speciality_desc == null || primary_speciality_desc.equals("")) )
	{

			sql=sql+" and upper(c.long_desc)   like  upper('"+primary_speciality_desc+"%') " ;

	}

	if ( !(Employee_Id == null || Employee_Id.equals("")) )
	{

			sql=sql+" and upper(a.EMPLOYEE_ID)   like  upper('"+Employee_Id+"%') " ;

	}


	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
	          sql=sql+" and a.eff_status='E'";
	     }
	     if ( enabled.equals("D") )
	     {
	          sql=sql+" and a.eff_status='D'";
	     }
	     if ( enabled.equals("B") )
	     {
	     }
	}

	/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
	if (!(fppPractYn == null || fppPractYn.equals("")))
	{
	     if(fppPractYn.equals("Y"))
	          sql=sql+" and a.fpp_pract_yn='Y'";
	     else if(fppPractYn.equals("N"))
	          sql=sql+" and a.fpp_pract_yn='N'";
	}
	/*End*/
	
	/*Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/
		if ( !(NATIONAL_ID_NUM == null || NATIONAL_ID_NUM.equals("")) )
		{
		NATIONAL_ID_NUM=NATIONAL_ID_NUM.toUpperCase();
		sql=sql+" and upper(a.NATIONAL_ID_NUM) like upper('"+NATIONAL_ID_NUM+"%')";

		}

		if ( !(OTH_ALT_ID_NO == null || OTH_ALT_ID_NO.equals("")) )
		{
		OTH_ALT_ID_NO=OTH_ALT_ID_NO.toUpperCase();
		sql=sql+" and upper(a.OTH_ALT_ID_NO) like upper('"+OTH_ALT_ID_NO+"%')";

		}
	/*End for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql=sql+" and a.primary_speciality_code = c.speciality_code order by ";
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql=sql+ord[i];
		else
			sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF
	else
		sql = whereClause;

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	conn = ConnectionManager.getConnection(request);
	
	//Below line added for this CRF ML-MMOH-CRF-0862
    //String fullname_width="";
    String full_short_width="";	
	String migid_other_width="";
	String full_short_wordwrap="";	
	String migid_other_wordwrap="";
	String migid_practid="";
	String migid_practid_wordwrap="";
	
	String pract_id="";
	String pract_id_wordwrap="";
	String migration_pract_id="";
	String migration_pract_id_wordwrap="";
	String full_name="";
	String full_name_wordwrap="";
    String short_name="";
	String short_name_wordwrap="";
    String pract_type="";
	String pract_type_wordwrap="";
    String specialty_code="";
	String specialty_code_wordwrap="";
    String speciality_desc="";
	String speciality_desc_wordwrap="";
    String pract_enabled="";
	String pract_enabled_wordwrap="";
	
	String tab_width="100%";
	isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
	if(isCernerpractitioner){
	 /*tab_width="1296px";
	 full_short_width="192px";	
	 migid_other_width="144px";
	 full_short_wordwrap="word-wrap: break-word;width:190px";	
	 migid_other_wordwrap="word-wrap: break-word;width:144px";
     migid_practid="232px";
	 migid_practid_wordwrap="word-wrap: break-word;width:232px"; 
	 */
	 
	
	/*tab_width="1260px";
	 
	 pract_id="120px";
	 pract_id_wordwrap="word-wrap: break-word;width:120px";
	 migration_pract_id="200px";
	 migration_pract_id_wordwrap="word-wrap: break-word;width:200px";
	 full_name="150px";
	 full_name_wordwrap="word-wrap: break-word;width:150px";
    // short_name="260px";
	 //short_name_wordwrap="word-wrap: break-word;width:260px";
	 short_name="255px";
	 short_name_wordwrap="word-wrap: break-word;width:255px";
     pract_type="120px";
	 pract_type_wordwrap="word-wrap: break-word;width:120px";
     specialty_code="120px";
	 specialty_code_wordwrap="word-wrap: break-word;width:120px";
     speciality_desc="150px";
	 speciality_desc_wordwrap="word-wrap: break-word;width:150px";
     pract_enabled="120px";
	 pract_enabled_wordwrap="word-wrap: break-word;width:120px";*/
	 
	 //Above lines commented and below lines added on 9th July 2018 by Thamizh selvi against ML-MMOH-CRF-1184
	 pract_id_wordwrap="word-wrap: break-word;";
	 migration_pract_id="15%";
	 migration_pract_id_wordwrap="word-wrap: break-word;width:15%";
	 full_name_wordwrap="word-wrap: break-word;";
	 short_name_wordwrap="word-wrap: break-word;";
	 pract_type_wordwrap="word-wrap: break-word;";
	 specialty_code_wordwrap="word-wrap: break-word;";
	 speciality_desc_wordwrap="word-wrap: break-word;";
	 pract_enabled_wordwrap="word-wrap: break-word;";
	 //End
     
 	 
	}	
	//End ML-MMOH-CRF-0862

	int maxRecord = 0;

	isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
      
if(function_id.equals("PRACTITIONER"))
		{
	 sqlstr1="select a.practitioner_id, a.practitioner_name,a.short_name, a.pract_type, b.desc_sysdef,b.DESC_USERDEF, a.eff_date_from, a.eff_date_to, a.eff_status,a.EMPLOYEE_ID,c.SPECIALITY_CODE,c.long_desc, a.practitioner_long_id practitioner_long_id, a.fpp_pract_yn from am_practitioner a, am_pract_type b ,am_speciality c   "+ sql +"  ";//Modified by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
		} else
		{
			if(function_id.equals("EXT_PRACT"))
			{
				sqlstr1="select a.practitioner_id, a.practitioner_name,a.short_name, a.pract_type, b.desc_sysdef,b.DESC_USERDEF, a.eff_date_from, a.eff_date_to, a.eff_status,a.EMPLOYEE_ID,c.SPECIALITY_CODE,c.long_desc, a.practitioner_long_id practitioner_long_id, a.fpp_pract_yn  from am_ext_practitioner a, am_pract_type b ,am_speciality c   "+ sql +"  ";//Modified by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
			}
		}
        stmt = conn.createStatement();
	
		rs = stmt.executeQuery(sqlstr1); 

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
			  rs.next() ;

		while( i<=end && rs.next()  )
		{ 
		   boolean isSiteSpecific=eOP.QMSInterface.isSiteSpecific(conn,"AM","AM_PRACT_EMP"); //Added by N Munisekhar for MMS-QH-CRF-0104 [IN:039242]
			if(maxRecord==0)
			{

            _bw.write(_wl_block7Bytes, _wl_block7);

		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/PractitionerQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/PractitionerQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(isCernerpractitioner){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
 }
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(isCernerpractitioner){

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block13Bytes, _wl_block13);
if(isCernerpractitioner){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(migration_pract_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(full_name));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(short_name));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 if (isSiteSpecific){ 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(isFPPPractApplicable){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pract_enabled));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pract_enabled));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(function_id.equals("")){
			
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
		  //Below line added for this CRF ML-MMOH-CRF-0862
		  if(isCernerpractitioner){
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block28Bytes, _wl_block28);
 }//End this  CRF ML-MMOH-CRF-0862
		
		}
			
			  String classValue = "" ;
			  
			if ( i % 2 == 0 )
					classValue = "QRYEVENSCROLL" ;
				  else
					classValue = "QRYODDSCROLL" ;
				  

			out.println("<tr><td align='left' class='" + classValue + "' width ='"+pract_id+"' style='"+pract_id_wordwrap+"' >");
			String code = rs.getString(1);
			out.println("<a href='../../eAM/jsp/PractitionerMain.jsp?practitioner_id="+ code + "&mode12=update&function_id="+function_id+"'>");
				out.println(code+"</a></td><td class='" + classValue + "' width ='"+migration_pract_id+"' style='"+migration_pract_id_wordwrap+"'>");
            //Below line added for this CRF ML-MMOH-CRF-0862
            if(isCernerpractitioner){ 
              String cerner_pract_id = rs.getString("practitioner_long_id")==null?"&nbsp;":rs.getString("practitioner_long_id"); 			
			  out.println("<a href='../../eAM/jsp/PractitionerMain.jsp?practitioner_id="+ code + "&mode12=update&function_id="+function_id+"'>");
			  out.println(cerner_pract_id+"</a></td><td class='" + classValue + "' width ='"+full_name+"' style='"+full_name_wordwrap+"'>");
			}
            //End this CRF ML-MMOH-CRF-0862	
			
			out.println( rs.getString(2) );
			out.println("</td><td class='" + classValue + "' width ='"+short_name+"' style='"+short_name_wordwrap+"'>");
			out.println(rs.getString("short_name"));
			out.println("</td><td class='" + classValue + "' width ='"+pract_type+"' style='"+pract_type_wordwrap+"'>");
			out.println(rs.getString("DESC_USERDEF") );
			out.println("</td><td class='" + classValue + "' width ='"+specialty_code+"' style='"+specialty_code_wordwrap+"'>");
			out.println(rs.getString("SPECIALITY_CODE"));
			out.println("</td><td class='" + classValue + "' width ='"+speciality_desc+"' style='"+speciality_desc_wordwrap+"'>");
			out.println(rs.getString("long_desc"));
			//Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] 
            if (isSiteSpecific){ 
			out.println("</td><td class='" + classValue + "'><table border='1'><td></td></table>");
			out.println((rs.getString("EMPLOYEE_ID") == null)?"":rs.getString("EMPLOYEE_ID"));
			}
			/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
			if(isFPPPractApplicable){
				out.println("</td><td align='center' class='" + classValue + "' width ='"+pract_enabled+"' style='"+pract_enabled_wordwrap+"'>");
				if (rs.getString("fpp_pract_yn").equals("Y"))
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			}
			/*End*/
			out.println("</td><td align='center' class='" + classValue + "' width ='"+pract_enabled+"' style='"+pract_enabled_wordwrap+"'>");
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
			maxRecord++;
		} // end of while

		if(maxRecord == 0)
		{ 
            _bw.write(_wl_block29Bytes, _wl_block29);
 }

if ( maxRecord < 14 || (!rs.next()) ) {

            _bw.write(_wl_block30Bytes, _wl_block30);

		} else {
            _bw.write(_wl_block31Bytes, _wl_block31);
}

		 if (rs != null)   rs.close();
		 if (stmt != null) stmt.close();
	} // end of try
		catch(Exception e) {
			
			out.println(e.toString());
			e.printStackTrace();
			}

		finally {
		  if (stmt != null) stmt.close();
		  if (rs != null)   rs.close();
		  	ConnectionManager.returnConnection(conn,request);
		}

 //Below line added for this CRF ML-MMOH-CRF-0862
if(isCernerpractitioner){		
	
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CernerId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortname.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmployeeID.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FPP.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ExternalPractitioner.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
