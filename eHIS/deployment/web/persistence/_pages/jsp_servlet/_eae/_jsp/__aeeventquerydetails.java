package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeeventquerydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEEventQueryDetails.jsp", 1709113832553L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--/**\n  @Author\t\t\t\t:\tArun Gandhi\n  @Created Date\t\t:\t27th November 2003\n  @Purpose\t\t\t\t:\tTo View The Event Dates\n  */ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<!--\n     @Get The FacilityID and Encounter Id From AEEventQueryMain.jsp\n-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\'     href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n // For AE Result Function, when clicking the dates\n function callDate(start_date_time,encounter_id)\n {\t\n\tparent.frames[2].location.href=\"../../eAE/jsp/ViewPatHistoryDetails.jsp?Patient_ID=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&FacilityId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&EncounterId=\"+encounter_id;\n }\n\n  // For Triage Result Function, when clicking the dates\n function callDate1(start_date_time,encounter_id)\n {\t\n\tparent.frames[2].location.href=\"../../eAE/jsp/AEEventTriageDetails.jsp?TriageStartDateTime=\'\"+start_date_time+\"\'&FacilityId=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&EncounterId=\"+encounter_id;\n }\n \n // For Primary Assessment Function, when clicking the dates\n function callDate2(start_date_time,encounter_id)\n {\t\n\tparent.frames[2].location.href=\"../../eAE/jsp/AEEventPrimaryAssessDetails.jsp?TriageStartDateTime=\"+start_date_time+\"&FacilityId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&EncounterId=\"+encounter_id;\n }\n\n // For Trauma Score Function, when clicking the dates\n function callDate3(start_date_time,encounter_id)\n {\t\n\tparent.frames[2].location.href=\"../../eAE/jsp/AEEventTraumaScoreDetails.jsp?TraumaDate=\"+start_date_time+\"&FacilityId=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&EncounterId=\"+encounter_id;\n }\n\n  // For Trauma Assessment Function, when clicking the dates\n function callDate4(start_date_time,encounter_id)\n {\t\n\tparent.frames[2].location.href=\"../../eAE/jsp/AEEventTraumaAssessDetails.jsp?TraumaDate=\"+start_date_time+\"&FacilityId=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&EncounterId=\"+encounter_id;\n }\n</script>\n</head>\n\n<!--\n\t@Queries To get the Dates Based on FacilityID,EncounterID\n-->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<!--\n\t@Get The Connection\n\t@Prepare The Statement and Execute The Queries\n\t@Declare the respective  Vector to store resultset values\n-->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<html>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr><b><a href=\"javascript:callDate(\'\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">A & E Details</a></b></tr>\n\t\t</table>\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr><th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th></tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<tr><td><a href=\"javascript:callDate1(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\"> ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></td></tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\n\t\t\t<tr><th>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr><td><a href=\"javascript:callDate2(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\n\t\t\t<tr><th>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<tr><td><a href=\"javascript:callDate3(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\n\t\t\t<tr><th>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr><td><a href=\"javascript:callDate4(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</table>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String strFacilityId     =  request.getParameter("Facility_Id");
	String strEncounterId =  request.getParameter("EncounterId");
	String strPatientId = request.getParameter("Patient_ID");

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block14Bytes, _wl_block14);

	String qryTriageDates = "SELECT TO_CHAR(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME FROM AE_PAT_TRIAGE WHERE FACILITY_ID= '"+strFacilityId+"' AND  encounter_id =  '"+strEncounterId+"' ORDER BY TRIAGE_START_DATE_TIME DESC";
	
	String qryPrimaryAssessmentDates = "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi') exam_date_time FROM AE_TRAUMA_PRIMARY_SURVEY WHERE FACILITY_ID= '"+strFacilityId+"' AND  encounter_id = '"+strEncounterId+"' ORDER BY exam_date_time DESC ";
	
	String qryTaumaScoreDates = "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi')exam_date_time FROM AE_PAT_GCS_SCORE WHERE FACILITY_ID='"+strFacilityId+"'  AND  encounter_id='"+strEncounterId+"' ORDER BY exam_date_time DESC";
	
	String qryTraumaAssessmentDates= "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi') exam_date_time FROM AE_TRAUMA_SECONDARY_SURVEY WHERE FACILITY_ID='"+strFacilityId+"' AND  encounter_id= '"+strEncounterId+"' ORDER BY exam_date_time DESC";

            _bw.write(_wl_block15Bytes, _wl_block15);

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rsTriage=null;
	ArrayList vecTriage = null;
	ResultSet rsPrimaryAssessment=null;
	ArrayList vecPrimaryAssessment = null;
	ResultSet rsTraumaScore=null;
	ArrayList vecTraumaScore = null;
	ResultSet rsTraumaAssessment=null;
	ArrayList vecTraumaAssessment = null;
	try{
		conn = webbeans.eCommon.ConnectionManager.getConnection(request);
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTriage
		*/
		pstmt = conn.prepareStatement(qryTriageDates);
		rsTriage = pstmt.executeQuery();
		if(rsTriage != null)
		{
			vecTriage = new ArrayList();
			while(rsTriage.next())
			{
				vecTriage.add(rsTriage.getString("TRIAGE_START_DATE_TIME"));
			}
		}
		if(rsTriage != null)rsTriage.close();
		if(pstmt!=null)pstmt.close();
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecPrimaryAssessment
		*/
		pstmt = conn.prepareStatement(qryPrimaryAssessmentDates);
		rsPrimaryAssessment = pstmt.executeQuery();
		if(rsPrimaryAssessment != null)
		{
			vecPrimaryAssessment = new ArrayList();
			while(rsPrimaryAssessment.next())
			{
				vecPrimaryAssessment.add(rsPrimaryAssessment.getString("exam_date_time"));
			}
		}
	    if(rsPrimaryAssessment != null)rsPrimaryAssessment.close();
		if(pstmt!=null)pstmt.close(); 
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTraumaScore
		*/
		pstmt = conn.prepareStatement(qryTaumaScoreDates);
		rsTraumaScore = pstmt.executeQuery();
		if(rsTraumaScore != null)
		{
			vecTraumaScore = new ArrayList();
			while(rsTraumaScore.next())
			{
				vecTraumaScore.add(rsTraumaScore.getString("exam_date_time"));
			}
		}
        if(rsTraumaScore != null)rsTraumaScore.close();
		if(pstmt!=null)pstmt.close(); 
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTraumaAssessment
		*/
		pstmt = conn.prepareStatement(qryTraumaAssessmentDates);
		rsTraumaAssessment = pstmt.executeQuery();
		if(rsTraumaAssessment != null)
		{
			vecTraumaAssessment =new ArrayList();
			while(rsTraumaAssessment.next())
			{
				vecTraumaAssessment.add(rsTraumaAssessment.getString("exam_date_time"));
			}
		}
        if(rsTraumaAssessment != null)rsTraumaAssessment.close();
		if(pstmt!=null)pstmt.close(); 
	}catch(Exception exec)
	{ 
		exec.printStackTrace();
	}
	finally
	{
		if(rsTriage != null)rsTriage.close();
		if(rsPrimaryAssessment != null)rsPrimaryAssessment.close();
		if(rsTraumaScore != null)rsTraumaScore.close();
		if(rsTraumaAssessment != null)rsTraumaAssessment.close();
		if(pstmt!=null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(vecTriage != null)
	{
		for(int i=0;i<vecTriage.size();i++)
		{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)vecTriage.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)vecTriage.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
        vecTriage.clear();
		vecTriage = null;
	}

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(vecPrimaryAssessment != null)
	{
		for(int i=0;i<vecPrimaryAssessment.size();i++)
		{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)vecPrimaryAssessment.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)vecPrimaryAssessment.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
			vecPrimaryAssessment.clear();
		vecPrimaryAssessment=null;
	}

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(vecTraumaScore != null)
	{
		for(int i=0;i<vecTraumaScore.size();i++)
		{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)vecTraumaScore.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)vecTraumaScore.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
			vecTraumaScore.clear();
		vecTraumaScore = null;
	}

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(vecTraumaAssessment != null)
	{
		int j= vecTraumaAssessment.size();
		for(int i=0;i<j;i++)
		{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)vecTraumaAssessment.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)vecTraumaAssessment.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
			vecTraumaAssessment.clear();
		vecTraumaAssessment = null;
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Triage.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PrimaryAssessment.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.TraumaScore.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.TraumaAssessment.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
