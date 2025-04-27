package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import com.ehis.util.*;

public final class __scheduleexistingvaccinations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ScheduleExistingVaccinations.jsp", 1741346344243L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="   <!-- 41654 -->\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../js/ScheduleForVacination.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- 41654 -->\n\t<style type=\"text/css\">\n\ta:link {\n\t\tCOLOR: #000066;\n\t\tFONT-WEIGHT: BOLD\n\t}\n\ta:visited {\n\t\tCOLOR: #000066;\n\t\tFONT-WEIGHT: BOLD\n\t}\n\ta:hover {\n\t\tCOLOR: #0000FF;\n\t\tFONT-WEIGHT: BOLD\n\t}\n\ta:active {\n\t\tCOLOR: #0000FF;\n\t\tFONT-WEIGHT: BOLD\n\t}\n</style>  \n   <head>\n   </head>\n   <body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\n   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<!-- <form> 41654-->\n\t<form name = \"scheduleExistingVacciForm\" action=\"../../servlet/eCA.ScheduleCategServlet\" method=\"post\" target=\"messageFrame\" >  <!-- 41654 -->\n\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\'>\n\t\t\t\t\t<table class=\'grid\' width=\'100%\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap colspan=\'2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td> </tr>\n\t\t\t\t<tr>\n\t\t\t\t<td  class=\'\' nowrap colspan=\'2\'>\n\t\t\t\t<select name=\'schedule_categ\' id=\'schedule_categ\' onchange=\'scheduleCodeChange(this)\' > \n\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\n\t\t\t\t</select><!-- Modified by Arvind --><input type=\'button\' name=\'goSchedule\' id=\'goSchedule\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' class=\'button\' onClick=\'getSchedulePopUp();\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t<!-- </table>  -->\n\t\t <tr><td colspan=\"2\">\n\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\' >\n\t\t\t<tr><td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<td></tr>\n\t\t\t<tr><td class=\'CAGROUP\' background=\'../../eCA/images/MCT_FullStrip.gif\' style=\'height:28\' ><a class=\'gridLink\' id=\"linkAll\" href=\'javascript:onClick=scheduleResult(\"ALL\",\"\",\"N\",\"linkAll\");\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a> <td></tr>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr><td class=\'CAGROUP\' background=\'../../eCA/images/MCT_FullStrip.gif\' style=\'height:28\' ><a class=\'gridLink\' id=\"linkVACCINE\" href=\'javascript:onClick=scheduleResult(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",\"N\",\"linkVACCINE\");\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t\t\t\n\t\t</table>\n\t </td></tr>\n\t</table> \n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' name=\'patient_id\' id=\'patient_id\'>\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' name=\'encounter_id\' id=\'encounter_id\'>\n<!-- <input type=\'hidden\' value=\'\' name=\'allow_multiple_yn\' id=\'allow_multiple_yn\'> 41654-->\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' name=\'allow_multiple_yn\' id=\'allow_multiple_yn\'> <!-- 41654 -->\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' name=\'vacc_categ_id\' id=\'vacc_categ_id\'>   <!-- 41654 -->\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' name=\'vac_sch_ref\' id=\'vac_sch_ref\'>   <!-- 41654 -->\n\n\t</form>\n  </body>\n\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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

/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
?             	100            ?           		created
08/10/2013    	IN035541       Chowminya G									Manage Immunization->System is displaying the Vaccine Category of Age specific 
27/11/2017		IN065683		Dinesh T									Vaccination Schedule getting automatically generated on opening patient chart in CA
24/04/2023		41652			Twinkle			24/04/2023		Ramesh		MMS-JU-CRF-0015.2																
08/09/2023		41654			Twinkle Shah			        Ramesh Goli  MMS-JU-CRF-0015.4															
--------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = session.getAttribute("facility_id")==null?"":(String) session.getAttribute("facility_id"); 	
//String query_string = request.getQueryString();


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	String patient_id ="";
	String encounter_id ="";
	String Schedule_query ="";
	String vacc_categ_id ="";
	String vacc_categ_desc ="";
	String vacc_categ_desc1 ="";
	String Existing_schedule_query ="";
//	String rowclass ="";
	String vac_sch_ref ="";
	String adhoc_yn ="";
	String allow_multiple_yn =""; //41654
	String sch_created_date =""; //41654
	DateFormat inputFormatter =null; //41654
	Date date =null;                  //41654
	DateFormat outputFormatter =null; //41654
	String sch_created_date1 =""; //41654
	
	String scheduled_user_id =""; //41654
	int edit_Validity_Date; //41654
	String age_specific_yn=""; //41654
	
	String sch_status ="";
	String imVaccPram  = "";
	String height  = "";
	String weight  = "";
	String BMI  = "";
	String height_on_date  = "";
	String weight_on_date  = "";	
	String weight_uom  = "";	
	String height_uom  = "";
//	String vacc_link_days  = "";
	String link_vacc_categ_id  = "";
	
	//41654 start
	String currentDate ="";
	currentDate	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
    //41654 end
	int k=0;

	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
	String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
	
	String login_user = (String)session.getValue("login_user");  ///41654
	
	eCA.ScheduleForVaccination schBean = new eCA.ScheduleForVaccination();
	Map<String,List<String>> bmiMap = schBean.getBMI(patient_id,facility_id);
	
	 if(bmiMap != null && bmiMap.size() > 0)
	 {
		 List<String> bmiList =	bmiMap.get("HEIGHT");
		 height  = bmiList.get(0);
		 height_uom  = bmiList.get(1);
		 height_on_date  = bmiList.get(2);
		 bmiList =	bmiMap.get("WEIGHT");		
		 weight  = bmiList.get(0);
		 weight_uom  = bmiList.get(1);
		 weight_on_date  = bmiList.get(2);
		 
		 if(!height.equals("") && !weight.equals("")) {
			BMI=String.valueOf(Double.parseDouble(weight)/((Double.parseDouble(height)/100)*(Double.parseDouble(height)/100)));
			int index	=	BMI.indexOf(".");
			
			if(BMI.length()>=(index+3) ) {
				BMI	=(BMI.substring(0,index+3));
			}
		 } 				
	 }
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!height.equals("")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(height_uom));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height_on_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!weight.equals("")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(weight_uom));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(weight_on_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(BMI));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

					try
					{
						con = ConnectionManager.getConnection(request);
						String imPramSql = "SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC FROM CA_IM_PAT_VAC_SCH_HDR A WHERE A.VACC_CATEG_ID IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM) AND PATIENT_ID=?  ";
						pstmt = con.prepareStatement(imPramSql);
						pstmt.setString(1, locale);
						pstmt.setString(2, patient_id);
						rs= pstmt.executeQuery();
						
						if(rs .next())
						{
							imVaccPram = rs.getString("VACC_CATEG_DESC")==null?"":rs.getString("VACC_CATEG_DESC");
							vac_sch_ref = rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");							
							link_vacc_categ_id = rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");
						}
						

						if(rs != null)
							rs.close();
						if(pstmt != null)
							pstmt.close();
							
						//IN057762 Start.
						//Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and a.AGE_SPECIFIC_YN = 'N'  and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.adhoc_yn = 'Y') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;//IN065683
						//41652 Start.
						//Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE) AND NVL(IA.GENDER,?)=? )) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.ALLOW_MULTIPLE_YN = 'N') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;//IN065683
						Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and 'Y' = CA_IM_VAC_CATEGORY_YN (a.age_specific_yn ,a.age_group_code ,? ,?) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.ALLOW_MULTIPLE_YN = 'N') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;
						//41652 End.
						//IN057762 End.
						
						pstmt=con.prepareStatement(Schedule_query);
						pstmt.setString(1,locale);
						pstmt.setString(2,dob);
						pstmt.setString(3,sex);
						//pstmt.setString(4,sex); //41652
						//pstmt.setString(5,patient_id); //41652
						pstmt.setString(4,patient_id); //41652
						rs= pstmt.executeQuery();
						while(rs.next())
						{						
							vacc_categ_id =rs.getString("VACC_CATEG_ID");
							vacc_categ_desc =rs.getString("SHORT_DESC");
							adhoc_yn =rs.getString("ADHOC_YN");
							if(adhoc_yn.equals("Y"))
								vacc_categ_desc = vacc_categ_desc+"#";

							out.println("<option value="+vacc_categ_id+"~"+adhoc_yn+">"+vacc_categ_desc+"</option>");
						}
						adhoc_yn = "";
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						//if(con!=null)ConnectionManager.returnConnection(con,request);


					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
					
				
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
if(!imVaccPram.equals("")) {
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(vac_sch_ref));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(link_vacc_categ_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(imVaccPram));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
   
			try
			{
				//Existing_schedule_query=" SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC,ADHOC_YN ADHOC_YN,sch_created_date,SCH_STATUS  FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B   WHERE A. PATIENT_ID = ? AND B.VACC_CATEG_ID=A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID=A.VACC_CATEG_ID ) UNION ALL SELECT NULL, VACC_CATEG_ID,SHORT_DESC  VACC_CATEG_DESC,ADHOC_YN ,null,null FROM CA_IM_VAC_CATEG_LANG_VW IA WHERE ia.AGE_SPECIFIC_YN = 'Y' AND EFF_STATUS='E' AND LANGUAGE_ID=? AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR WHERE VACC_CATEG_ID=IA.VACC_CATEG_ID AND PATIENT_ID= ? ) AND EXISTS (SELECT 1 FROM CA_IM_VAC_SCH_FOR_CATEG WHERE vacc_categ_id = ia.vacc_categ_id )   ORDER BY ADHOC_YN, SCH_CREATED_DATE desc,3 "; //Commentted [IN035541]
				//Existing_schedule_query=" SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC,ADHOC_YN ADHOC_YN,sch_created_date,SCH_STATUS  FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B   WHERE A. PATIENT_ID = ? AND B.VACC_CATEG_ID=A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID=A.VACC_CATEG_ID )  ORDER BY SCH_CREATED_DATE desc,3 "; //[IN035541  //41654
				Existing_schedule_query="SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID, ?, 2) VACC_CATEG_DESC, ADHOC_YN ADHOC_YN, SCH_CREATED_DATE, SCH_STATUS, B.ALLOW_MULTIPLE_YN ALLOW_MULTIPLE_YN, A.SCHEDULED_USER_ID SCHEDULED_USER_ID,B.AGE_SPECIFIC_YN AGE_SPECIFIC_YN FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B WHERE A.PATIENT_ID = ? AND B.VACC_CATEG_ID = A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID = A.VACC_CATEG_ID) ORDER BY SCH_CREATED_DATE DESC, 3"; //41654
                				
				pstmt=con.prepareStatement(Existing_schedule_query);
				pstmt.setString(1,locale);
				pstmt.setString(2,patient_id);
				//pstmt.setString(3,locale); //[IN035541]
				//pstmt.setString(4,patient_id);//[IN035541]
				
				rs= pstmt.executeQuery();

				while(rs.next())
				{
					
					vac_sch_ref =rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");
					vacc_categ_id =rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");
					vacc_categ_desc1 =rs.getString("VACC_CATEG_DESC");
					sch_status =rs.getString("SCH_STATUS")==null?"C":rs.getString("SCH_STATUS");

					adhoc_yn =rs.getString("ADHOC_YN")==null?"N":rs.getString("ADHOC_YN");
					allow_multiple_yn =rs.getString("ALLOW_MULTIPLE_YN")==null?"N":rs.getString("ALLOW_MULTIPLE_YN"); //41654
					sch_created_date =rs.getString("SCH_CREATED_DATE")==null?"":rs.getString("SCH_CREATED_DATE"); //41654
					scheduled_user_id =rs.getString("SCHEDULED_USER_ID")==null?"N":rs.getString("SCHEDULED_USER_ID"); //41654
					age_specific_yn =rs.getString("AGE_SPECIFIC_YN")==null?"N":rs.getString("AGE_SPECIFIC_YN"); //41654
					
					//start 41654
                    inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    date = inputFormatter.parse(sch_created_date);
                    outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    sch_created_date1 = outputFormatter.format(date); // Output : 01/20/2012
                    edit_Validity_Date= com.ehis.util.DateUtils.hoursBetween(sch_created_date1,currentDate,"DMYHM",locale);
                    //41654 end
					
					if (adhoc_yn.equals("Y") )
							vacc_categ_desc1=vacc_categ_desc1+"#";
					
					if (sch_status.equals("A"))
					{
					      //out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' ><b>"+vacc_categ_desc1+"</b></a> <td></tr>");   //41654
				           
					      //start 41654
					          out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' ><b>"+vacc_categ_desc1+"</b></a>");
					
					          if(edit_Validity_Date < 48 && login_user.equals(scheduled_user_id) && adhoc_yn.equals("N") && age_specific_yn.equals("N"))
					           {
					            out.println("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink'><img style='cursor:pointer;' name='editSchedule' onClick='getSchedulePopUpEdit(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' alt='Edit Schedule' src='../../eCA/images/undo_05.png'></a>");
					           }
					            out.println("<td></tr>"); 
					       //end 41654
					}
                    else
				          out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");'>"+vacc_categ_desc1+"</a> <td></tr>");
					
				k++;
				}

				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);

			
			}
			catch(Exception e)
			{
			
				
				e.printStackTrace();
			
			}

			
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allow_multiple_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(vacc_categ_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(vac_sch_ref));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ason.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ason.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.create.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ExistingSchedules.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
