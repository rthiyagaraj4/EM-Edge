package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aepatienttmtresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEPatientTMTResult.jsp", 1709113844991L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatientGI.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<center>\n<form name=\'AEPatientTMTResultForm\' id=\'AEPatientTMTResultForm\'>\n<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n</div>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\tparent.AEMPLegendFrame.location.href=\'../../eAE/jsp/AEMPLegend.jsp?five_level_triage_appl_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t</script>\n\n<p>\n\t<table align=\'right\'>\n\t<tr>\n\t<td>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</td>\n</tr>\n</table>\n<br>\n<br>\n</p>\n\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'tb1\'>\n<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n<th>&nbsp;&nbsp;&nbsp;</th>\n<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </th>\n<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t <tr id=\'one\'> \n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th colspan=3 align=\'left\'><font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<th colspan=4 align=\'right\'> \n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t </th>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t <th colspan=7 align=\'left\'><font size=1>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th> \n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t </tr> \n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t <tr id=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><font size=1>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' style=\"background-color:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">&nbsp;</td> <!--Modified for this CRF AAKH-CRF-0010 [IN:038535] -->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'\t\tonMouseover=\"onMMove(msg,event,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\" onMouseout=\"onMOut(msg,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\');\"><font size=1>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\'><font size=1>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t</tr> \n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<script>\n\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\tparent.frames[0].document.forms[0].refresh.disabled = false;\n\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.parent.frames[0].document.forms[0].reset.disabled=false;\n\t\t</script>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<script>\n\t\tdocument.getElementById(\"nextvalue\").innerHTML=\" \";\n\t</script>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n<script>\n\t\tparent.parent.frames[0].document.forms[0].reset.disabled=false;\n\t\tparent.frames[0].document.forms[0].refresh.disabled = false;\n</script>\n</table>\n\n<input type=\'hidden\' name=\'queue_date\' id=\'queue_date\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'> \n</form>\n</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
 
 
public StringBuffer getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code,int cutoff_prv_days) throws java.sql.SQLException
	{

        StringBuffer tmt_area_statistics = new StringBuffer();
		String query_statistics	= " SELECT SUM(DECODE(queue_status,'01',0,1)) tot_assigned, SUM(DECODE(queue_status,'04',1,0)) tot_under_tmt, SUM(DECODE(queue_status,'07',1,'09',1,0)) tot_consulted, SUM(CASE WHEN QUEUE_STATUS='02' AND CONS_SRVC_START_DATE_TIME IS NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) tot_await_tmt FROM op_patient_queue where facility_id = ? and (trunc(queue_date) between trunc(SYSDATE) -((1/(24*60*60))*3600*"+cutoff_prv_days+") and sysdate) and locn_type = ? and locn_code = ? and treatment_area_code = ? and patient_class = 'EM'"; 

		int tot_assigned	=	0;
		int tot_under_tmt	=	0;
		int tot_consulted	=	0;
		int tot_await_tmt	=	0;

		PreparedStatement pstmt	=	con.prepareStatement(query_statistics);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		pstmt.setString	(	4,	treatment_area_code);

		ResultSet rs =	pstmt.executeQuery();

		if(rs !=null && rs.next())
		{
			tot_assigned	=	rs.getInt("tot_assigned");
			tot_under_tmt	=	rs.getInt("tot_under_tmt");
			tot_consulted	=	rs.getInt("tot_consulted");
			tot_await_tmt	=	rs.getInt("tot_await_tmt");
		}
		tmt_area_statistics.append("( "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" : "+tot_assigned+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : "+tot_under_tmt+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : "+tot_consulted+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AwaitingTreatment.label","ae_labels")+" : "+tot_await_tmt+" )");
  
		if(rs!=null) rs.close();
		if(pstmt!=null)			pstmt.close();

		return tmt_area_statistics;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	StringBuffer query_patient_queue	=	new StringBuffer();
	String facility_id			=	"";
	String	clinic_code			=	"";
	String	practitioner_id		=	"",		practitioner_name		=	"";
	String	priority_indicator	=	"",		check_in_date_time		=	"";
	String clinic_desc="";
	String	patient_id			=	"",		patient_name			=	"";
	String	waiting_time		=	"";
	String	queue_status_desc	=	"",		classValue				=	"";
	String	treatment_area_code	=	"",		prv_treatment_area_code	=	"";
	String	treatment_area_desc	=	"",		triage_area				=	"";
	String	classValuePI		=	"";
	String	queue_date			=	"",		classValuePat			=	"";
	String	clinic_type			=	"";
	String	patient_gender		=	"",		brought_dead_yn			=	"";
	String	order_by_priority	=	"";
	StringBuffer whereClause    =   new StringBuffer();
    StringBuffer orderByClause	=	new StringBuffer();
	String locale				= (String)session.getAttribute("LOCALE");
	
	//Added for this AAKH-CRF-0010 [IN:038535]
	String prior_zone_bgcolor="";
	String priority_zone_all_codes="";
	String five_level_triage_appl_yn	= "N";
	String FIVE_LEVEL_TRIAGE_APPL_YN1="N";

	String	priority			=	"";		
	String	tblrow_id			=	"";
	String  priority_zone = "";
	String  from_date = "";
	String  to_date = "";
	int p_cutoff_hours_prv_day_visit = 0;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String from 				= request.getParameter("from") ;
	String to 					= request.getParameter("to") ;
	String whereCondition		= request.getParameter("whereCondition");
     if(whereCondition==null || whereCondition.equals("null"))  whereCondition= "";
 
	patient_id					=	(request.getParameter("patient_id")==null)	? "" : request.getParameter("patient_id");	

	String brought_dead = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.broughtdead.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels") ;

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy hh:mm" ) ;
    java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;

	int start = 0 ;
	int end = 0 ;
	int i=1; 
	int p_rec_cnt = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 12 ;
	else
		end = Integer.parseInt( to ) ;   

	
try
	{
		con				=	ConnectionManager.getConnection(request);
		facility_id		=	(String)session.getValue("facility_id");





	int		rowIndex				=	1,		columnIndex				=	0;
	
		from_date			=	(request.getParameter("patbytrmtroom_datefrom")==null) ? ""		             :request.getParameter("patbytrmtroom_datefrom");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 Start*/
		if(!from_date.equals("") && locale.equals("th"))
			from_date			= DateUtils.convertDate(from_date,"DMYHM","th","en");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 End*/

		to_date				=	(request.getParameter("patbytrmtroom_to")==null)? "" : request.getParameter("patbytrmtroom_to");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 Start*/
		if(!to_date.equals("") && locale.equals("th"))
			to_date			= DateUtils.convertDate(to_date,"DMYHM","th","en");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 End*/
		if (from_date.equals("")) from_date =d;
		if (to_date.equals("")) to_date = "01/01/1900 00:01";
		clinic_code			=	(request.getParameter("clinic_code")==null)			? "" : request.getParameter("clinic_code");
		clinic_type			=	(request.getParameter("clinic_type")==null)			? "" : request.getParameter("clinic_type");
		treatment_area_code	=	(request.getParameter("treatment_area_code")==null)	? "" : request.getParameter("treatment_area_code");
		practitioner_id		=	(request.getParameter("practitioner_id")==null)		? "" : request.getParameter("practitioner_id"); 
		priority			=	(request.getParameter("priority")==null)			? "" : request.getParameter("priority");
		patient_gender		=	(request.getParameter("patient_gender")==null)		? "" : request.getParameter("patient_gender");
		order_by_priority	=	(request.getParameter("order_by_priority")==null)	? "" : request.getParameter("order_by_priority");
		FIVE_LEVEL_TRIAGE_APPL_YN1	=	(request.getParameter("FIVE_LEVEL_TRIAGE_APPL_YN")==null)	? "" : request.getParameter("FIVE_LEVEL_TRIAGE_APPL_YN");
		
		/*Below line added for this AAKH-CRF-0010 [IN:038535]*/
		priority_zone_all_codes=(request.getParameter("priority_zone_all_codes")==null)	? "" : request.getParameter("priority_zone_all_codes");
	
		StringBuilder priority_zone_order	 = new StringBuilder();
	if(!priority_zone_all_codes.equals("")&&priority_zone_all_codes.length()>0){
	
			priority_zone_all_codes = priority_zone_all_codes.substring(0, priority_zone_all_codes.length());				
		    String[] priority_zone_split = priority_zone_all_codes.split(",");
			
		for (int  x= 0; x < priority_zone_split.length; x++) {
			priority_zone_order.append("'"+priority_zone_split[x]+"',"+(x+1));
			if (x!= priority_zone_split.length - 1) {
		    	priority_zone_order.append(",");
		    }
		}
		
	}//End AAKH-CRF-0010 [IN:038535]
		
		
		if(!(clinic_code.equals("")))			whereClause.append(" and locn_code = ? and locn_type = ? ");
		if(!(treatment_area_code.equals("")))	whereClause.append(" and treatment_area_code = ? ");
		if(!(practitioner_id.equals("")))		whereClause.append(" and practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause.append(" and a.patient_id = ? ");
	
		if(!priority.equals("")){
			/*if(priority.equals("B"))		whereClause.append(" and priority_zone = 'B' ");
			if(priority.equals("R"))		whereClause.append(" and priority_zone = 'R' ");
			if(priority.equals("Y"))		whereClause.append(" and priority_zone = 'Y' ");
			if(priority.equals("G"))		whereClause.append(" and priority_zone = 'G' ");
			if(priority.equals("W"))		whereClause.append(" and priority_zone = 'W' ");
			if(priority.equals("U"))		whereClause.append(" and priority_zone = 'U' ");*/
			whereClause.append(" and priority_zone = '"+priority+"' ");//Added By Shanmukh for MMS-DM-CRF-0147
		}
		if(!(patient_gender.equals("")))		whereClause.append(" and sex = ? ");
		//if(order_by_priority.equals("Y")) orderByClause.append(" priority_zone"); //Commented this line [IN:038535]
		
	query_patient_queue.append(" select c.five_level_triage_appl_yn,a.LOCN_TYPE,a.LOCN_CODE,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') LOCN_DESC, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') treatment_area_desc,(CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B','N', 'C','', 'A') FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END) triage_area , a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_name, a.PRIORITY_INDICATOR,  a.PRIORITY_ZONE,  to_char(a.queue_date,'dd/mm/yyyy hh24:mi') check_in_date_time,  a.patient_id, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, a.encounter_id,get_waiting_time (NVL(a.cons_srvc_start_date_time, SYSDATE),queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, a.queue_status,  NVL(queue_status,'Autoclosed') queue_status_desc, a.BROUGHT_DEAD_YN, c.cutoff_hours_prv_day_visit,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR from op_patient_queue a, mp_patient b,ae_param c where a.facility_id='"+facility_id+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id and a.facility_id = c.operating_facility_id AND a.queue_date BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY hh24:mi') AND TO_DATE('"+to_date+"','DD/MM/YYYY hh24:mi') ");
	/*Above query modified for this AAKH-CRF-0010 [IN:038535]*/
	
		query_patient_queue.append(whereClause.toString());
		if(FIVE_LEVEL_TRIAGE_APPL_YN1.equals("Y"))	{
			if((order_by_priority.equals("Y")&& priority.equals(""))||(order_by_priority.equals("Y")&&!priority.equals(""))||(order_by_priority.equals("")&&!priority.equals(""))){
				orderByClause.append(" order by DECODE(priority_zone,"+priority_zone_order.toString()+") asc,queue_date desc");
			}else{ 
				orderByClause.append(" order by triage_area,treatment_area_code,queue_date ");
			}
		}
		else{
			/*Modified By Dharma on 16th Dec 2014 against HSA-SCF-0050.1 [IN:052934] Start*/
			/*
			if(order_by_priority.equals("Y")) orderByClause.append(" ,priority_zone");
			query_patient_queue.append(" order by triage_area,treatment_area_code,queue_date ");*/
			if((order_by_priority.equals("Y")&& priority.equals(""))||(order_by_priority.equals("Y")&&!priority.equals(""))||(order_by_priority.equals("")&&!priority.equals(""))){
				orderByClause.append(" order by DECODE(priority_zone,"+priority_zone_order.toString()+") asc,queue_date desc");
			}else{ 
				orderByClause.append(" order by triage_area,treatment_area_code,queue_date ");
			}
			/*Modified By Dharma on 16th Dec 2014 against HSA-SCF-0050.1 [IN:052934] End*/
			
		}
		
		query_patient_queue.append(orderByClause.toString());
		pstmt		=	con.prepareStatement(query_patient_queue.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//pstmt.setString	(	1,	facility_id		);
		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);

		rs			=	pstmt.executeQuery();
	 
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");

		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);


	if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/AEPatientTMTResult.jsp?from="+(start-12)+"&to="+(end-12)+ "&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&FIVE_LEVEL_TRIAGE_APPL_YN="+FIVE_LEVEL_TRIAGE_APPL_YN1+"&treatment_area_code="+treatment_area_code+ "&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority_zone_all_codes="+priority_zone_all_codes+"&priority="+priority+"&patient_gender="+patient_gender+"&order_by_priority="+order_by_priority+"&patbytrmtroom_datefrom="+from_date+"&patbytrmtroom_to="+to_date+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/AEPatientTMTResult.jsp?from="+(start+12)+"&to="+(end+12)+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&FIVE_LEVEL_TRIAGE_APPL_YN="+FIVE_LEVEL_TRIAGE_APPL_YN1+"&treatment_area_code="+treatment_area_code+ "&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority_zone_all_codes="+priority_zone_all_codes+"&priority="+priority+"&patient_gender="+patient_gender+"&order_by_priority="+order_by_priority+"&patbytrmtroom_datefrom="+from_date+"&patbytrmtroom_to="+to_date+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}

			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
        
			clinic_code			=	(rs.getString("locn_code")==null)	?	""	: rs.getString("locn_code");
			clinic_type			=	(rs.getString("locn_type")==null)	?	""	: rs.getString("locn_type");	
            clinic_desc         =(rs.getString("LOCN_DESC")==null)	?	""	: rs.getString("LOCN_DESC");	
			
			treatment_area_code		=	(rs.getString("treatment_area_code")==null)	?	"&nbsp;"	: rs.getString("treatment_area_code");	
			treatment_area_desc		=	(rs.getString("treatment_area_desc")==null)	?	"&nbsp;"	: rs.getString("treatment_area_desc");	
			triage_area				=	(rs.getString("triage_area")==null)			?	"&nbsp;"	: rs.getString("triage_area");	

			practitioner_id			=	(rs.getString("practitioner_id")==null)		?	"&nbsp;"	: rs.getString("practitioner_id");
			practitioner_name		=	(rs.getString("practitioner_name")==null)	?	"&nbsp;"	: rs.getString("practitioner_name");
			priority_indicator		=	(rs.getString("priority_indicator")==null)	?	"&nbsp;"	: rs.getString("priority_indicator");
			check_in_date_time		=	(rs.getString("check_in_date_time")==null)	?	"&nbsp;"	: rs.getString("check_in_date_time");
			patient_id				=	(rs.getString("patient_id")==null)			?	"&nbsp;"	: rs.getString("patient_id");
			patient_name			=	(rs.getString("patient_name")==null)		?	"&nbsp;"	: rs.getString("patient_name");
			waiting_time			=	(rs.getString("waiting_time")==null)		?	"&nbsp;"	: rs.getString("waiting_time");
			queue_date				=	(rs.getString("queue_date1")==null)			?	"&nbsp;"	: rs.getString("queue_date1");	
			queue_status_desc		=	(rs.getString("queue_status_desc")==null)	?	"&nbsp;"	: rs.getString("queue_status_desc");	

			if(queue_status_desc.equals("00"))
		queue_status_desc="&nbsp;";
		if(queue_status_desc.equals("01"))			        queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
		if(queue_status_desc.equals("02"))                  queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
		if(queue_status_desc.equals("03"))						queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
		if(queue_status_desc.equals("04"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
		if(queue_status_desc.equals("07"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
		if(queue_status_desc.equals("09"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
		if(queue_status_desc.equals("99"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

			p_cutoff_hours_prv_day_visit = rs.getInt("CUTOFF_HOURS_PRV_DAY_VISIT");
			
	  prior_zone_bgcolor=(rs.getString("PRIORITY_ZONE_COLOR")==null)?"":rs.getString("PRIORITY_ZONE_COLOR"); //Added for this AAKH-CRF-0010 [IN:038535]
			
			priority_zone			=	(rs.getString("priority_zone")==null)		?	"&nbsp;"	: rs.getString("priority_zone");


            brought_dead_yn				=	(rs.getString("brought_dead_yn")==null)			?	"&nbsp;"	: rs.getString("brought_dead_yn");
			if(brought_dead_yn.equals("Y"))
				classValuePat		=	"AEBROUGHTDEAD";
			else
				classValuePat		=	classValue;  
			if	(priority_zone.equals("R"))		classValuePI	=	"RESUSCITATION";
			else if(priority_zone.equals("Y"))		classValuePI	=	"OAYELLOW";
			else if(priority_zone.equals("G"))		classValuePI	=	"URGENT";
			else if(priority_zone.equals("U"))		classValuePI	=	"EMERGENT";
			else classValuePI	=	classValue;
              String temp_area_code=clinic_code+"/"+ treatment_area_code;
			if(!(temp_area_code.equals(prv_treatment_area_code)))
			{	if(treatment_area_desc.equals("&nbsp;"))
					treatment_area_desc = "Unassigned";
				if(triage_area.equals("B"))
					treatment_area_desc = clinic_desc+"/"+treatment_area_desc;
				else 
					treatment_area_desc =clinic_desc+"/"+ treatment_area_desc; 
	
            _bw.write(_wl_block16Bytes, _wl_block16);

				if(!( treatment_area_desc.equals("Unassigned") ))
				{   
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
 
out.println(getStatistics(pageContext,con,facility_id,clinic_type,clinic_code,treatment_area_code,p_cutoff_hours_prv_day_visit));
	
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				else
				{ 		        
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( treatment_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}	
	
            _bw.write(_wl_block22Bytes, _wl_block22);

				prv_treatment_area_code	 =	 temp_area_code;
			
			} 
	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValuePI));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(prior_zone_bgcolor));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DateUtils.convertDate(check_in_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(brought_dead));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValuePat));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(waiting_time));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(queue_status_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

		i++;
		p_rec_cnt++;
		cnt++;
		}
	  
	 
	 if(cnt==0){

            _bw.write(_wl_block35Bytes, _wl_block35);

	  }
		 if(!rs.next()&&cnt!=0){
	endOfRes="0";
            _bw.write(_wl_block36Bytes, _wl_block36);
}

query_patient_queue.setLength(0);
whereClause.setLength(0);
orderByClause.setLength(0);

if(rs!=null)	rs.close();
if(pstmt!=null)	pstmt.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	out.println("<script>parent.frames[0].document.forms[0].refresh.disabled = false; </script>");
	    
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}



            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WaitTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
}
