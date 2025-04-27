package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarytriagedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryTriageDetails.jsp", 1737607286403L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n25/02/2013\tIN035924\t  Karthi L\t \tCA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018) \n13/03/2013  IN038713\t Nijitha S\t\tCRF-CA- CHL-CRF-0018/04- Scope for Data to be displayed in Widget defined->Other facility->we get exception error\n13/03/2014\tIN044157\t Chowminya\t\t [AAKH CRF 0010.1]Five level Triage system AE requirement \t\n16/09/2014  IN050047 \tNijitha S\t\t The triage details does not populate correctly in Patient Secondary Triage History screen as per date/time selected from the patient chart.\n---------------------------------------------------------------------------------------------------------\nDate       \tEdit History      \tName        \tRev.Date\tRev.Name\tDescription\n---------------------------------------------------------------------------------------------------------\n28/06/2018\tIN065341\t\tPrakash C\t29/06/2018\tRamesh G \tMMS-DM-CRF-0115\n---------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<!--<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />-->\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n\t\n   \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\n\t\n\t//function TriageDetail(patient_id,encounter_id,visit_adm_date_time)\n\tasync function TriageDetail(patient_id,encounter_id,visit_adm_date_time,facility_id,called_from,clob_data,RepDb)//IN065341\n\t{\n\t    var retVal = \"\";\n\t\tvar function_id =\"query\";\n\t\t//var dialogHeight= \"36\" ;\n\t\t//var dialogWidth\t= \"48\" ;\n\t\t//var dialogTop =\"113\";\n\t\tvar dialogTop\t\t= \"\";\n\t\tvar dialogHeight\t= \"90vh\";\n\t\tvar dialogWidth\t\t= \"90vw\";\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t//var action_url\t\t=\t\"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&visit_adm_date_time=\"+visit_adm_date_time+\"&function_id=\"+function_id;\n\t\t//var action_url\t\t=\t\"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&rec_date_time=\"+visit_adm_date_time+\"&function_id=\"+function_id;//IN050047 modified the key name from visit_adm_date_time to rec_date_time\n\t\tvar action_url\t\t=\t\"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&rec_date_time=\"+visit_adm_date_time+\"&function_id=\"+function_id+\"&facility_id=\"+facility_id+\"&called_from=\"+called_from+\"&clob_data=\"+clob_data+\"&RepDb=\"+RepDb;\n\t\tretVal = await top.window.showModalDialog(action_url,arguments,features);\n\t}\n \n</script>\n<title>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</title>\n</head>\n<html>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<table width=\"100%\" class=\'grid\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<!--IN065341 starts-->\t\t\n\t\t\t\t<!--<TR><TD CLASS=\'classValue\' width=\'40%\'><a class=\'gridLink\' href=\"javascript:TriageDetail(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></TD>--><!--Passing recorded date/time-->\n\t\t\t\t<TR><TD CLASS=\'classValue\' width=\'40%\'><a class=\'gridLink\' href=\"javascript:TriageDetail(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></TD>\n\t\t\t<!--IN065341 ends-->\t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<TD CLASS=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'30%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TD>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<TD style=background-color:\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";FONT-SIZE:9pt; width=\'30%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</TD> \n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<TD CLASS=\'classValue\' width=\'30%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TD></TR>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\n\t\t</table>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    	/*String strFacilityId     =  (String)session.getValue("facility_id");
	if(strFacilityId == null) strFacilityId = "";
	String strEncounterId =  request.getParameter("episode_id");commented for IN065341*/
	//String strPatientId = request.getParameter("patient_id");

            _bw.write(_wl_block6Bytes, _wl_block6);

//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}

//[IN035950] Ends
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);

	String P_patient_id = request.getParameter("patient_id"); // moved for CHL-CRF-018 IN035924
	String qryTriageDates = "";  // moved for CHL-CRF-018 IN035924
	//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String encounter_id="";
	String strFacilityId     =  "";
	String strEncounterId = "";
	int no_of_days=0;
	String scope_disp="D";
	if(called_from.equals("CDR")){
		encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		strFacilityId=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		  strEncounterId =  request.getParameter("enc_id1");
	}else{//IN065341 ends
	   encounter_id = request.getParameter("encounter_id");//IN035924
	   strFacilityId     =  (String)session.getValue("facility_id");
	    strEncounterId =  request.getParameter("episode_id");
	}//IN065341
	
	// added below lines for CHL-CRF-018 IN035924 - START
	StringBuffer encListBuf = new StringBuffer();
	ArrayList encounterList = null;
	//IN065341 starts	
	if(!called_from.equals("CDR")){
		CAEncounterList oEncounterList = new CAEncounterList();
		HashMap encounterMap = oEncounterList.getPatEncounterList(P_patient_id, strFacilityId, content_ID);
		 scope_disp = (String)encounterMap.get("SCOPE_DISP");
		Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
		 no_of_days = no_of_days_before.intValue();
		encounterList = (ArrayList)encounterMap.get("ENC_LIST");
		
		if( no_of_days >= 1  &&  scope_disp.equalsIgnoreCase("P"))
		{
			Iterator iterator = encounterList.iterator();
			int index = 0;
			
			while(iterator.hasNext())
			{	
				index++;
				encListBuf.append("'");
				encListBuf.append(iterator.next());
				if(encounterList.size() >= index )
				{
					encListBuf.append("'");
				}
				if(encounterList.size() != index )
				{
					encListBuf.append(",");
				}
			}
		}
		else if(scope_disp.equalsIgnoreCase("P"))
		{
			encListBuf.append("'");
			encListBuf.append(encounter_id);
			encListBuf.append("'");
		}
		//IN038713 Starts
		if(encListBuf.equals("") || null==encListBuf || encounter_id==null || encounter_id.equals(""))
				encListBuf.append("''");
		//IN038713 Ends
		//CHL-CRF-018 IN035924 - END
	}//IN065341 ends
	//String qryTriageDates = "select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,(SELECT short_desc                      FROM ae_pat_priority                     WHERE priority_code = a.pat_priority) PATIENT_PRIORITY_DESC,(SELECT short_desc                         FROM ae_tmt_area_for_clinic                         WHERE facility_id =  a.facility_id                           AND clinic_code = a.clinic_code                           AND treatment_area_code = a.treatment_area_code)|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE";

	if(scope_disp.equalsIgnoreCase("D")) // condition added/modified for CHL-CRF-018 IN035924 - START
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; //IN050047 retreiving recorded datetime with seconds //IN044157
		qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID=?  order by a.RECORDED_DATE "; //IN065341
	}	
	else if(scope_disp.equalsIgnoreCase("P")) 
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; //IN050047 retreiving recorded datetime with seconds//IN044157
		if(called_from.equals("CDR")){	
			qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encounter_id+") order by a.RECORDED_DATE "; //IN065341
		}else{
			qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, ENCOUNTER_ID, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null)   location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID in ("+encListBuf+") order by a.RECORDED_DATE "; 
		}
	}
	else if(scope_disp.equalsIgnoreCase("C"))
	{
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE "; 
		//qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE"; //IN050047 retreiving recorded datetime with seconds//IN044157
		qryTriageDates="select to_char(a.RECORDED_DATE,'DD/MM/YYYY HH24:MI:SS')  recorded_date_time, PRIORITY_ZONE,AE_GET_DESC.AE_PAT_PRIORITY ##REPDB##(a.pat_priority,?,'2') PATIENT_PRIORITY_DESC,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.facility_id,a.clinic_code,a.treatment_area_code,?,'2')|| nvl2(a.bed_no,' / '||a.bed_no,null) location,ca_ae_get_priority_zone_color ##REPDB##(A.PRIORITY_ZONE,'en') ae_zone_color from ae_pat_emergency_detail ##REPDB## a where a.FACILITY_ID=? and a.ENCOUNTER_ID=? and RECORDED_DATE between (sysdate - ?) and sysdate order by a.RECORDED_DATE"; //IN065341
	} // condition added/modified for CHL-CRF-018 IN035924 - END

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rsTriage=null;
	//String P_patient_id = request.getParameter("patient_id"); // commented for CHL-CRF-018 IN035924
	String strRecDtTime = "";
	//String encounter_id = request.getParameter("encounter_id"); // commented and moved top for CHL-CRF-018 IN035924

	if (encounter_id==null) encounter_id="";
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	
	try{
		conn = ConnectionManager.getConnection(request);
		//IN044157 - Start
		String AEZone5 = "N";
		
		//IN065341 starts
		//PreparedStatement stmtAE = conn.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
		PreparedStatement stmtAE=null;
		ResultSet rsAE = null;
		String sql1="Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM ##REPDB## where OPERATING_FACILITY_ID=?";
		sql1=sql1.replaceAll("##REPDB##",RepDb);
		stmtAE = conn.prepareStatement(sql1);
		//IN065341 ends
		stmtAE.setString(1,strFacilityId);
		rsAE = stmtAE.executeQuery();
		while(rsAE.next()){
			AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
		}
		if(stmtAE!=null)stmtAE.close();
		if(rsAE!=null)rsAE.close();
		//IN044157 - End
		
		qryTriageDates=qryTriageDates.replaceAll("##REPDB##",RepDb);//IN065341
		pstmt = conn.prepareStatement(qryTriageDates);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,strFacilityId);
		
		if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C"))
		{ 
			//condition added for CHL-CRF-018 IN035924
			pstmt.setString(4,strEncounterId);
		}
		
		if(scope_disp.equalsIgnoreCase("C"))
		{ 
			// added for CHL-CRF-018 IN035924
			pstmt.setInt(5,no_of_days);	
		}	
		
		rsTriage = pstmt.executeQuery();
//		int counter = 0;
		String classValue = "";
		String priorityzone="";
		String prioritycolor = "";//IN044157
        String zonecolorclassvalue="";
        String tag="";
		int recordCount=0;//IN035950
		if(rsTriage != null)
		{
			while(rsTriage.next())
			{
				recordCount++;
				/*if(counter%2 == 0){
					classValue = "gridData";
				}else{
					classValue = "gridData";				
				}*/

				classValue = "gridData";
				priorityzone=rsTriage.getString("PRIORITY_ZONE")==null?"":rsTriage.getString("PRIORITY_ZONE");
				prioritycolor=rsTriage.getString("ae_zone_color")==null?"":rsTriage.getString("ae_zone_color");//IN044157
				strRecDtTime	= rsTriage.getString("recorded_date_time")==null?"":rsTriage.getString("recorded_date_time");

				//strRecDtTime	= com.ehis.util.DateUtils.convertDate(strRecDtTime,"DMYHM","en",locale);//IN050047
				
				if(scope_disp.equalsIgnoreCase("P")) // added for CHL-CRF-018
				{ 
					encounter_id = rsTriage.getString("ENCOUNTER_ID")==null?"":rsTriage.getString("ENCOUNTER_ID");
				}	
				//added if condition IN044157
				if(AEZone5.equals("N")){
					if(!priorityzone.equals(""))
					{
						if(priorityzone.equals("G"))
						{
							zonecolorclassvalue="NONCRITICAL"; 
							tag="<font size=1 color=white>";
						}
						else if(priorityzone.equals("R"))
						{
							zonecolorclassvalue="CRITICAL"; 
							tag="<font size=1 color=white>";
						}
						else if(priorityzone.equals("Y"))
						{
							zonecolorclassvalue="SEMICRITICAL";
							tag="<font size=1 color=black>";
						}
						else 
						zonecolorclassvalue=classValue;
					}
				}
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strRecDtTime));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strRecDtTime));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strRecDtTime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clob_data));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(RepDb));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strRecDtTime));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(AEZone5.equals("N")){
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(zonecolorclassvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(rsTriage.getString("PATIENT_PRIORITY_DESC")==null?"&nbsp;":rsTriage.getString("PATIENT_PRIORITY_DESC")));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}else{				
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(prioritycolor));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(rsTriage.getString("PATIENT_PRIORITY_DESC")==null?"&nbsp;":rsTriage.getString("PATIENT_PRIORITY_DESC")));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rsTriage.getString("location")==null?"&nbsp;":rsTriage.getString("location")));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
		}
		//IN035950  Starts
		if(recordCount==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
		//IN035950  Ends
		if(rsTriage != null)rsTriage.close();
		if(pstmt!=null)pstmt.close();


	}catch(Exception exec)
	{
		//out.println(exec.toString());//COMMON-ICN-0181
		exec.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
