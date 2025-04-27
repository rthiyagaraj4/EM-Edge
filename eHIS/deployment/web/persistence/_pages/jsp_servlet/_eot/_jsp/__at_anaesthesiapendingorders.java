package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;

public final class __at_anaesthesiapendingorders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_AnaesthesiaPendingOrders.jsp", 1722848790000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>                  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!-- Added against MMS-QH-CRF-0199-->\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"RecordAnesthesiaPatientDetailsForm\" id=\"RecordAnesthesiaPatientDetailsForm\" >\n<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t<tr>\n\t\t<th  class=\"columnHeader\" nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<th  class=\"columnHeader\" nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th><!-- FD-GHL-CRF-0357 -->\n\t\t<th  class=\"columnHeader\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th class=\"columnHeader\"  nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<tr>\n\t\t<td width=\'10%\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\'  onClick=\"displayToolTipPendingOrders(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"width=\'9%\'  onMouseOver=\'hideToolTip();\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></td> <!-- IN049942 -->\n\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'18%\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'3%\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<!-- Modified against MMS-QH-CRF-0199 -->\n\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' width=\'12%\' nowrap><img src=\'../../eOT/images/drugInfo.gif\'   OnMouseOver=\"Tip(reasonToolTip(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onMouseOut=\'UnTip();\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'8%\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</table>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
 public String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:""; 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	String locale = (String)session.getAttribute("LOCALE");	
	String facility_id=request.getParameter("facility_id");
	String patient_id1= checkForNull(request.getParameter("patient_id"));
	String patient_name1= checkForNull(request.getParameter("patient_name"));
	String surgery_date1=checkForNull(request.getParameter("surgery_date"));
	String surgery_date2=checkForNull(request.getParameter("surgery_date2"));//AAKH CRF-0069
	
	String surgeryDate=checkForNull(request.getParameter("surgeryDate")); //FD-GHL-CRF-0357
	String surgeryDate2=checkForNull(request.getParameter("surgeryDate2")); //AAKH CRF-0069	
	
	String surgeon_code1= checkForNull(request.getParameter("surgeon_code"));
	String speciality_code1= checkForNull(request.getParameter("speciality_code"));
	String patient_id="",patient_name="",sex="",surgery_date="",surgeon_code="",surgeon_name="",request_source_type="",source_id="",parent_source_id="",anathestist_code="",patient_class="",episode_id="",encounter_id="",speciality_desc="",order_catalog_desc="",classValue="",anesthesia_srl_no="",proc_module_id="",date_of_birth="";
	String bookingDate = "";
	String patientNameMenu = ""; //IN049942

	Connection connection		= null ;
	PreparedStatement pstmt		= null ;
	ResultSet resultSet			= null ;
	PreparedStatement pstmt1	= null ;
	ResultSet resultSet1		= null ;
	//FD-GHL-CRF-0357 start & 50529/50585
	StringBuffer sql_pending_orders = new StringBuffer();

	sql_pending_orders.append(" SELECT DECODE (b.booking_status,	");
    sql_pending_orders.append("	'9', DECODE ((SELECT contr_sys_id	"); //050585
	sql_pending_orders.append(" FROM or_order o	");
	sql_pending_orders.append(" WHERE o.order_id = a.source_order_id),	");
	sql_pending_orders.append(" 'OT', TO_CHAR (c.order_date_time, 'dd/mm/yyyy'),	");
	sql_pending_orders.append(" TO_CHAR (c.pref_surg_date, 'dd/mm/yyyy')),	");
    sql_pending_orders.append("	NVL (TO_CHAR (b.booking_date, 'dd/mm/yyyy'),	");
    sql_pending_orders.append("	TO_CHAR (c.pref_surg_date, 'dd/mm/yyyy'))) bookingdate,	");
    sql_pending_orders.append(" a.patient_id,	");
	sql_pending_orders.append(" a.patient_name patient_name1, a.sex,	");
	sql_pending_orders.append(" TO_CHAR (a.request_date, 'dd/mm/yyyy') request_date, "); // 050556 start
	sql_pending_orders.append(" NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code, ");
	sql_pending_orders.append(" (SELECT d.short_name ");
	sql_pending_orders.append(" FROM am_practitioner_lang_vw d ");
	sql_pending_orders.append(" WHERE d.practitioner_id(+) = NVL (b.team_doctor_code, c.performing_team_surgeon) ");
	sql_pending_orders.append(" AND d.language_id = ?) surgeon_name, ");
	sql_pending_orders.append(" a.status, a.request_source_type, a.order_id,");  // 050556 end
	sql_pending_orders.append(" a.source_order_id, a.anaesthetist_code, a.patient_class, a.episode_id,	");
	sql_pending_orders.append(" a.encounter_id, TO_CHAR (a.date_of_birth, 'DD/MM/YYYY') date_of_birth,	");
	//sql_pending_orders.append(" a.speciality_code, a.speciality_desc, a.order_catalog_desc,	");//Commented  against MMS-QH-CRF-0199
	sql_pending_orders.append(" a.speciality_code, a.speciality_desc,d.long_desc oper_desc,	");//Added  against MMS-QH-CRF-0199
	sql_pending_orders.append(" a.order_catalog_code	");
	//sql_pending_orders.append(" FROM at_pending_orders_vw a, ot_booking_hdr b, ot_pending_order c	");//Commented against MMS-QH-CRF-0199
	sql_pending_orders.append(" FROM at_pending_orders_vw a, ot_booking_hdr b, ot_pending_order c,OT_OPER_MAST_LANG_VW d");//Added  against MMS-QH-CRF-0199
	sql_pending_orders.append(" WHERE a.operating_facility_id = ?	");
	sql_pending_orders.append(" AND a.language_id = ?	");
	sql_pending_orders.append(" AND a.source_order_id = b.order_id(+)	");
	sql_pending_orders.append(" AND a.source_order_id = c.order_id	");
	sql_pending_orders.append(" AND a.ORDER_CATALOG_CODE = d.ORDER_CATALOG_CODE");//Added against MMS-QH-CRF-0199
	sql_pending_orders.append(" AND d.LANGUAGE_ID = ?");//Added against MMS-QH-CRF-0199
	sql_pending_orders.append(" AND NVL (b.booking_num, 'X') = NVL ((SELECT MAX (booking_num)");//50585
	sql_pending_orders.append("	FROM ot_booking_hdr WHERE order_id = a.source_order_id), 'X')");//50585
	if(patient_id1.intern() != "")
		sql_pending_orders.append(" AND a.PATIENT_ID = ? ");
	if(patient_name1.intern() != "")
		sql_pending_orders.append(" AND a.PATIENT_NAME LIKE ? ");
	if(surgeon_code1.intern() != "")
		sql_pending_orders.append(" AND NVL (b.team_doctor_code, c.performing_team_surgeon) = ? 	"); //051169
	if(speciality_code1.intern() != "")
		sql_pending_orders.append(" AND a.SPECIALITY_CODE = ? ");
	if(surgeryDate.intern() != "")
	{
		sql_pending_orders.append(" AND DECODE (b.booking_status, '9', DECODE ((SELECT contr_sys_id  "); //050585
		sql_pending_orders.append(" FROM or_order o  ");
		sql_pending_orders.append(" WHERE o.order_id = a.source_order_id),  ");
		sql_pending_orders.append(" 'OT', c.order_date_time,  ");
		sql_pending_orders.append(" c.pref_surg_date),  ");
		sql_pending_orders.append(" NVL (b.booking_date, c.pref_surg_date))  ");
		sql_pending_orders.append(" BETWEEN TO_DATE (? || ' 00:00', 'dd/mm/yyyy hh24:mi') AND TO_DATE (? || ' 23:59', 'dd/mm/yyyy hh24:mi') ");
	}
	if(surgery_date1.intern() != "")
		sql_pending_orders.append(" AND a.request_date BETWEEN TO_DATE(?||' 00:00','dd/mm/yyyy hh24:mi') AND TO_DATE(?||' 23:59','dd/mm/yyyy hh24:mi') ");

		//AAKH-CRF-0069		
		sql_pending_orders.append("	order by NVL (b.booking_date, c.pref_surg_date) desc,a.request_date,a.patient_id");
//FD-GHL-CRF-0357 end & 50529/50585
	int i=0;
	int index = 0; //FD-GHL-CRF-0357
	try{
			connection = ConnectionManager.getConnection(request);
			//FD-GHL-CRF-0357 start
			pstmt = connection.prepareStatement(sql_pending_orders.toString());
			pstmt.setString(++index, locale);
			pstmt.setString(++index, facility_id);
			pstmt.setString(++index, locale);
			pstmt.setString(++index, locale);//Added against MMS-QH-CRF-0199
			if(patient_id1.intern() != "")
				pstmt.setString(++index, patient_id1);
			if(patient_name1.intern() != "")
				pstmt.setString(++index, patient_name1);
			if(surgeon_code1.intern() != "")
				pstmt.setString(++index, surgeon_code1);
			if(speciality_code1.intern() != "")
				pstmt.setString(++index, speciality_code1);
				//AAKH CRF-0069 START
			if(surgeryDate.intern() != "")
			{
				pstmt.setString(++index, surgeryDate);
			
				if(surgeryDate2.intern() != ""){
					pstmt.setString(++index, surgeryDate2);
				}
				else
				{
				pstmt.setString(++index, "31/12/9999");
				}
			}
			if(surgery_date1.intern() != "")
			{
				pstmt.setString(++index, surgery_date1);
				if(surgery_date2.intern() != ""){
					pstmt.setString(++index, surgery_date2);
				}
				else
				{
				pstmt.setString(++index, "31/12/9999");
				}
			}
			//AAKH CRF-0069 END
			//FD-GHL-CRF-0357 end
/*
			if(pstmt_params.size()>0)
			{
				int size = pstmt_params.size();
				for(int j=0;j<size;j++){
					pstmt.setString(j+1,""+pstmt_params.get(j));
				}
			}
*/
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				i++;
				patient_id = checkForNull(resultSet.getString("PATIENT_ID"));
				patient_name = checkForNull(resultSet.getString("PATIENT_NAME1"));
				sex = checkForNull(resultSet.getString("SEX"));
				surgery_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("REQUEST_DATE"),"DMY","en",locale);
				surgeon_code = checkForNull(resultSet.getString("SURGEON_CODE"));
				surgeon_name = checkForNull(resultSet.getString("SURGEON_NAME"));
				request_source_type = checkForNull(resultSet.getString("REQUEST_SOURCE_TYPE"));
				source_id = checkForNull(resultSet.getString("ORDER_ID"));
				parent_source_id = checkForNull(resultSet.getString("SOURCE_ORDER_ID"));
				anathestist_code = checkForNull(resultSet.getString("ANAESTHETIST_CODE"));
				patient_class = checkForNull(resultSet.getString("PATIENT_CLASS"));
				episode_id = checkForNull(resultSet.getString("EPISODE_ID"));
				encounter_id = checkForNull(resultSet.getString("ENCOUNTER_ID"));
				date_of_birth = com.ehis.util.DateUtils.convertDate(resultSet.getString("DATE_OF_BIRTH"),"DMY","en",locale);
				speciality_desc = checkForNull(resultSet.getString("SPECIALITY_DESC"));
				//order_catalog_desc = checkForNull(resultSet.getString("ORDER_CATALOG_DESC"));//Commented Against MMS-QH-CRF-0199
				order_catalog_desc = checkForNull(resultSet.getString("oper_desc"));//Commented Against MMS-QH-CRF-0199
				bookingDate = checkForNull(resultSet.getString("bookingDate")); //FD-GHL-CRF-0357

		classValue = (i%2==0)?"gridData":"gridData"; 
		// By DIlip
		ResultSet rs=null;
		String sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1         FROM MP_PATIENT  WHERE PATIENT_ID =? "; //Changed against 50529/50585
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			rs=pstmt.executeQuery();
			if(rs.next())
			patient_name=checkForNull(rs.getString("SHORT_NAME1"));
			rs.close();
			pstmt.close();
	  // End by Dilip
	  	patientNameMenu = patient_name.replace("'",""); //IN049942

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientNameMenu));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(anesthesia_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(proc_module_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request_source_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(source_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(parent_source_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(anathestist_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(surgeon_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(parent_source_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bookingDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(surgeon_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	if(i==0)
		out.println("<script>callNoRecord();</script>");
	}catch ( Exception e ){
			  e.printStackTrace() ;
	}finally {
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(resultSet1!=null) resultSet1.close();
				if(pstmt1!=null) pstmt1.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SurgeryDate.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaOrderedDate.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
