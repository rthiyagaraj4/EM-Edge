package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import eCA.*;
import eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;

public final class __consultationtaggingquery2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ConsultationTaggingQuery2.jsp", 1742180261824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  \t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script> \n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\' > </script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ConsultationTagging.js\'> </script>\t\n\t<script language=\"javascript\" src=\"../../eOR/js/OrCommonLookup.js\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\t\n</head>\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<body OnMouseDown=\'CodeArrest()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t \t<form name=\'consultationTagQuery2Frm\' id=\'consultationTagQuery2Frm\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.ConsultationTaggingServlet\'>\n<table cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\" align=\"center\">\n\t\t\t  \t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<br>\n<tr>\n<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'fields\'><input type=\"hidden\" name=\"splCode\" id=\"splCode\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><input type=\"text\" name=\"splName\" id=\"splName\"  nowrap size=\'16\' maxlength=\'20\' onblur=\'getSpecialtyCall(this);setTagPractitioner();\' OnChange=\'resetValues()\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><input type=\"button\" value=\"?\" class=\"button\" name=\'splSearch\' id=\'splSearch\' onblur=\'setTagPractitioner();\' onClick=\'getSpecialty1();\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td class=\'fields\'><input type=\'hidden\' name=\'practitionerId\' id=\'practitionerId\' value=\'\'><input type=\'text\' name=\'practitioner_desc\' id=\'practitioner_desc\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" nowrap size=16 maxlength=35 ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><input type=\'button\' name=\'practitioner_button\' id=\'practitioner_button\' class=\'button\' value=\'?\' onClick=\'show_practtioner_window(document.getElementById(\"practitioner_desc\"));\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n<img src=\"../../eCommon/images/mandatory.gif\"></td>\t\n</tr>\t\t\n<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\n<tr>\n\n<td class=\'LABEL\' width=\'16%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\n<td class=\'fields\'>\t<input type=\'text\' name=\'start_Date\' id=\'start_Date\' id=\'startDate\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' size=\'18\' maxlength=\'17\' OnBlur=\'CheckDateTimefrom(this,\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\' OnKeyPress=\'return CheckForNumsAndColon(event)\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'start_Date\');\">\n<img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'> \n</td>\n   \n \n<td class=\'LABEL\' width=\'16%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n<td class=\'fields\'><input type=\'text\' name=\'end_Date\' id=\'end_Date\' id=\'enddate\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' size=\'18\' maxlength=\'17\' OnBlur=\'CheckDateTimeTo(this,start_Date,\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\' OnKeyPress=\'return CheckForNumsAndColon(event)\' ><img type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'end_Date\');\"><img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'> \n</td>\n\n</tr>\n<tr>\n<td></td><td></td><td></td>\n<td align=\'right\' class=\'button\'>\n\t\t\t\t\t\n\t\t\t\t\t  <input type=\'button\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' class=\'button\' onClick=\'apply();\'>\n                      ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<input type=\'button\' name=\'delete\' id=\'delete\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' class=\'button\' onClick=\'deleteRecord();\'>\n\t\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                      <input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' class=\'button\' onClick=\'clearAll();\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t  <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t  <input type=\'hidden\' name=\'clinicianId\' id=\'clinicianId\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>  \n\t\t\t\t  <input type=\'hidden\' name=\'language_id\' id=\'language_id\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t  <input type=\'hidden\' name=\'specialty_code\' id=\'specialty_code\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>  \n\t\t\t\t  <input type=\'hidden\' name=\'visit_adm_date1\' id=\'visit_adm_date1\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t  <input type=\'hidden\' name=\'loginPract\' id=\'loginPract\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t  <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t  <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t  <input type=\"hidden\" name=\"prac_sql\" id=\"prac_sql\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n                  <input type=\"hidden\" name=\"prac_sql1\" id=\"prac_sql1\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n                  <input type=\'hidden\' name=\'mode1\' id=\'mode1\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n                  <input type=\'hidden\' name=\'tag_practitioner_id\' id=\'tag_practitioner_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'> \n                  <input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>  \n          \t\t  <input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n          \t\t\t  \n\t\t</form>\t\n\t\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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

/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

Connection con 		= null;
PreparedStatement pstmt 	= null;
ResultSet rs = null;
	String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
            _bw.write(_wl_block8Bytes, _wl_block8);

			  	 try{
			  	 	  	 	  	     String mode="";
			  	 	  	 	  	     String	option_id="";
			  	 	  	 	  	     String patient_id="";
			  	 	  	 	  		 String	facility_id				 =  (String) session.getValue( "facility_id" ) ;
			  	 	  	 			 patient_id				 =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			  	 	  	 			 String disableString="";
			  	 	  	 			 String	visit_adm_date =  request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			  	 	  	 			 String	encounter_id =  request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			  	 	  	 			 String clinicianId =(String)session.getValue("ca_practitioner_id");
			  	 	  	 			 option_id =  request.getParameter("option_id")==null?"":request.getParameter("option_id");
			  	 	  	 			 String	mode1 =  request.getParameter("mode1")==null?"":request.getParameter("mode1");
			  	 	  	 			 String spl_code="";
			  	 	  	 			 String spl_description="";
			  	 	  	 			 String getCurrentDate="";
			  	 	  	 			 String disable="";
			  	 	  	 			 String speciality_code="";
			  	 	  	 			 String tag_practitioner_id="";
			  	 	  	 			 String start_date="";
			  	 	  	 			 String end_date="";
			  	 	  	 			 String splCode="";
			  	 	  	 			 String spl_desc="";
			  	 	  	 			 String tag_pract_id="";
			  	 	  	 			 String tag_pract_desc="";
			  	 	  	 			 
			  	 	  	 		     start_date= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		  	 	  	 				 end_date = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

		  	 	  	 			        if("CONSULT_TAGGING".equals(option_id))
			  	 	  	 			    visit_adm_date = com.ehis.util.DateUtils.formatDate(visit_adm_date,"DMYHMS","DMYHM",locale);

                                        String spltCode = (request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"));
			
			  	 	  	                try{
			  	 	  	 		  	    String practSPLQry ="SELECT primary_speciality_code spl_code,SHORT_DESC spl_desc FROM am_practitioner d,am_speciality_lang_vw e  WHERE d.practitioner_id =? AND d.PRIMARY_SPECIALITY_CODE=e.SPECIALITY_CODE AND e.EFF_STATUS ='E' AND e.LANGUAGE_ID=?";
			  	 	  	 				con = ConnectionManager.getConnection(request);
			  	 	  	 		  	    pstmt = con.prepareStatement(practSPLQry);
			  	 	  	 				pstmt.setString(1,clinicianId);
			  	 	  	 				pstmt.setString(2,locale);
			  	 	  	 				rs = pstmt.executeQuery();

			  	 	  	 				if(rs.next())
			  	 	  	 				{
			  	 	  	 				splCode = rs.getString("spl_code")==null?"":rs.getString("spl_code");
			  	 	  	 			    spl_description	= rs.getString("spl_desc")==null?"":rs.getString("spl_desc");
			  	 	  	 				}
			  	 	  	 	} catch (Exception e) {
			  	 	  	 		e.printStackTrace();
			  	 	  	 	} finally {
			  	 	  	 		if (rs != null) rs.close();
			  	 	  	 		if (pstmt != null) pstmt.close();
			  	 	  	 	}

			  	 	  	if(mode1.equals("modify")){
			  	 	  	 disable = "Disabled";
			  	 	    option_id = request.getParameter("option_id") == null ? "": request.getParameter("option_id");
			  	 	  	patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			  	 		speciality_code = request.getParameter("speciality_code") == null ? "": request.getParameter("speciality_code");
			  	 		tag_practitioner_id = request.getParameter("tag_practitioner_id") == null ? "": request.getParameter("tag_practitioner_id");
			  	 		start_date = request.getParameter("start_date") == null ? "" : request.getParameter("start_date");
			  	 		end_date = request.getParameter("end_date") == null ? "" : request.getParameter("end_date");
			  	 		encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			  	 		visit_adm_date = request.getParameter("visit_adm_date") == null ? "" : request.getParameter("visit_adm_date");

			  	 		String comp_desc = "SELECT speciality_code,short_desc FROM am_speciality where speciality_code=?";

			  	 		pstmt = con.prepareStatement(comp_desc);
			  	 		pstmt.setString(1, speciality_code);
			  	 		rs = pstmt.executeQuery();
			  	 		while (rs.next()) {
			  	 			splCode = rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code");
			  	 			spl_description = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
			  	 		}
			  	 		if (pstmt != null)
			  	 			pstmt.close();
			  	 		if (rs != null)
			  	 			rs.close();
			  	 		String comp_desc1 = "SELECT practitioner_id, practitioner_name FROM am_practitioner  where practitioner_id=?";

			  	 		pstmt = con.prepareStatement(comp_desc1);
			  	 		pstmt.setString(1, tag_practitioner_id);
			  	 		rs = pstmt.executeQuery();
			  	 		while (rs.next()) {

			  	 			tag_pract_id = rs.getString("practitioner_id") == null ? "" : rs.getString("practitioner_id");
			  	 			tag_pract_desc = rs.getString("practitioner_name") == null ? "" : rs.getString("practitioner_name");
			  	 		}

			  	 		if (pstmt != null)
			  	 			pstmt.close();
			  	 		if (rs != null)
			  	 			rs.close();

			  	 	} else {
			  	 		mode = "insert";
			  	 	}
			  	 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(splCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(spl_description));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(mode1.equals("modify")){  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(mode1.equals("modify")){  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tag_pract_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(mode1.equals("modify")){  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
if(mode1.equals("modify")){  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 
					if("modify".equals(mode1))
					{
					
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(clinicianId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(spl_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(clinicianId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(CaRepository.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_ADMIN2")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(CaRepository.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN2")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tag_practitioner_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
			  	
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RelatedPatientHistoryCriteria.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TaggedPractitioner.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.StartDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EndDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
