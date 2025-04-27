package jsp_servlet._eop._jsp;

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
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class __opcancelcheckoutsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPCancelCheckoutSearchResult.jsp", 1709119445429L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n \n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n<script language=\'javascript\' src=\'../../eOP/js/OPCancelCheckout.js\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<BODY onLoad=\'\' onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"OPCancelChkoutResult\" id=\"OPCancelChkoutResult\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<br><br>\n</P>\n\n<table border=\"1\"  cellspacing=\'0\' cellpadding=\'0\' width=\"100%\">\n\t<tr>\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t    <th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</tr>\n\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<!--<a href=\"javascript:loadCancelChkout(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' );\">-->\n\t\t<a\n\t\thref=\'javascript:loadCancelChkout(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" );\'><!--Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646-->\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</table>\n\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'isPriorityZoneAppl\' id=\'isPriorityZoneAppl\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t<!--Added By Shanmukh for MMS-DM-CRF-0147-->\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE"); 
String loginUser = (String)session.getValue("login_user");
String facility_id1 = (String) session.getValue( "facility_id" ) ;

Connection con=null; 
Statement stmt=null;
ResultSet rset=null;  
int maxRecord=0;
int c=0;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Boolean isPriorityZoneAppl=false;  //Added By Shanmukh for MMS-DM-CRF-0147

	String facility_id=checkForNull(request.getParameter("facility_id"));
	String module_id=checkForNull(request.getParameter("module_id"));
	String speciality=checkForNull(request.getParameter("speciality"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String loc_type=checkForNull(request.getParameter("loc_type"));
	String oplocation=checkForNull(request.getParameter("oplocation"));
	String pract=checkForNull(request.getParameter("pract"));
	String gender=checkForNull(request.getParameter("gender"));
	//String chkoutFrom=checkForNull(request.getParameter("chkoutFrom"));
	//String chkoutTo=checkForNull(request.getParameter("chkoutTo"));

	/*if(module_id.equals("AE"))
	{*/
		String disaster=checkForNull(request.getParameter("disaster"));
		String caseoftrauma=checkForNull(request.getParameter("caseoftrauma"));
		String pat_class=checkForNull(request.getParameter("pat_class"));
		String oper_stn_id=checkForNull(request.getParameter("oper_stn_id"));
		//String loginUser=checkForNull(request.getParameter("loginUser"));
		
	//}

	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	
		//String oper_stn_id = "";

	 

	String from = request.getParameter( "from" );	
	String to = request.getParameter( "to" );
	String registered_in_mo_yn = "";
	
	Boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070

	
	int start = 0 ;
	 int end = 0 ;
	 int i=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 8;
	 else
		end = Integer.parseInt( to ) ;
	
	try
	{
		con =  ConnectionManager.getConnection(request); 
		
		 isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
		 isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070

            _bw.write(_wl_block9Bytes, _wl_block9);

	String class_val = "";
	StringBuffer sqlBuff=new StringBuffer();
	StringBuffer Where=new StringBuffer();
	String order_by = ""; 
	String gender_tab = "";
	String gender_st = "";

	//boolean isAfter = false;
	//String pat_class = "";

	if(module_id.equals("AE"))
		pat_class = "EM";
	else if(module_id.equals("OP"))
		pat_class = "OP";


	if(!speciality.equals(""))
		Where.append(" and a.SPECIALITY_CODE = '"+speciality+"' ");
	if(!patient_id.equals(""))
		Where.append(" and a.PATIENT_ID = '"+patient_id+"' ");
	if(!loc_type.equals(""))
		Where.append(" and a.LOCN_TYPE = '"+loc_type+"' ");
	if(!oplocation.equals(""))
		Where.append(" and a.LOCN_CODE = '"+oplocation+"' ");
	if(!pract.equals(""))
		Where.append(" and a.PRACTITIONER_ID = '"+pract+"' ");
	if(!gender.equals("A"))
	{
	if(!gender.equals(""))
		Where.append(" and b.Sex = '"+gender+"' ");
	}

	if(module_id.equals("AE"))
	{
	if(!disaster.equals(""))
		Where.append(" and a.DISASTER_YN = '"+disaster+"' ");
	if(!caseoftrauma.equals(""))
		Where.append(" and a.TRAUMA_YN = '"+caseoftrauma+"' ");
	}


	order_by = " order by a.patient_id, a.QUEUE_DATE desc";

	//Below line modified by Shanmukh for MMS-DM-CRF-0147
	sqlBuff.append("SELECT a.PATIENT_ID, am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2) disposition_short_desc, TO_CHAR(a.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_date,to_char(a.queue_date,'dd/mm/yyyy hh24:mi:ss') queue_date, a.SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE, '"+locale+"',2)  SPECIALITY_DESC,(DECODE('"+locale+"' ,'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name))) patient_name,b.Sex Gender,a.encounter_id, a.LOCN_CODE clinic_code,OP_GET_DESC.OP_CLINIC(a.facility_id,a.LOCN_CODE,'"+locale+"','1')  clinic_desc,a.LOCN_TYPE clinic_type, a.treatment_area_code treatment_area_code,  AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.facility_id, a.LOCN_CODE ,a.treatment_area_code,'"+locale+"','2') treatment_area_desc, a.PRACTITIONER_ID PRACTITIONER_ID,  AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID, '"+locale+"','1') practitioner_name ,TO_CHAR(a.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, TO_CHAR(a.CHECK_IN_DATE_TIME, 'dd/mm/yyyy hh24:mi') queue_date_time, a.queue_STATUS, a.TRAUMA_YN, a.DISASTER_YN, a.SERVICE_CODE, b.REGISTERED_IN_MO_YN,a.OP_EPISODE_VISIT_NUM, op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type, a.episode_id episode_id, am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name1, a.medical_yn medical_yn,a.surgical_yn surgical_yn, a.trauma_yn, a.oscc_yn, a.o_and_g_yn, a.non_emerg_yn, a.mech_injury_catg_code, a.mech_injury_subcatg_code, a.mlc_yn mlc_yn,a.pm_yn pm_yn, a.high_risk_yn high_risk_yn, TO_CHAR(b.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time,  a.LOCN_CODE, a.PRIORITY_ZONE, b.DECEASED_YN, a.VISIT_TYPE_IND,a.AE_BED_NO,(SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') FROM Bl_parameters Where  operating_facility_id = 'HS') ae_bed_charge,to_char(sysdate,'dd/mm/yyyy hh24:mi') cdate,(select eff_status from AE_PRIORITY_ZONE where priority_zone=a.priority_zone) priority_zone_status  FROM  op_patient_queue a, mp_patient b WHERE  a.facility_id = '"+facility_id1+"' AND  a.patient_id = b.patient_id AND queue_STATUS = '07' AND patient_class='"+pat_class+"' AND  trunc(a.DISCHARGE_DATE_TIME) = trunc(sysdate) AND (a.facility_id,a.LOCN_TYPE,a.LOCN_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facility_id1+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and CANCEL_CHECKOUT_YN = 'Y')");//Modified by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646


	sqlBuff.append(Where.toString());
	sqlBuff.append(order_by);

	if (rset != null) rset.close();
	if (stmt != null) stmt.close();		

	 
	
	stmt=con.createStatement();
    rset=stmt.executeQuery(sqlBuff.toString());

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rset.next() ;
	  }
	while (rset!=null && i<=end && rset.next())
    {
			
			if(maxRecord == 0)
			{


            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eOP/jsp/OPCancelCheckoutSearchResult.jsp?from="+(start-8)+"&to="+(end-8)+"&facility_id="+facility_id+"&speciality="+speciality+"&patient_id="+patient_id+"&loc_type="+loc_type+"&oplocation="+oplocation+"&pract="+pract+"&gender="+gender+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"&pat_class="+pat_class+"&oper_stn_id="+oper_stn_id+"&loginUser="+loginUser+"&module_id="+module_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			out.println("<A HREF='../../eOP/jsp/OPCancelCheckoutSearchResult.jsp?from="+(start+8)+"&to="+(end+8)+"&facility_id="+facility_id+"&speciality="+speciality+"&patient_id="+patient_id+"&loc_type="+loc_type+"&oplocation="+oplocation+"&pract="+pract+"&gender="+gender+"&disaster="+disaster+"&caseoftrauma="+caseoftrauma+"&pat_class="+pat_class+"&oper_stn_id="+oper_stn_id+"&loginUser="+loginUser+"&module_id="+module_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			if(module_id.equals("AE"))
			{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
		
            _bw.write(_wl_block17Bytes, _wl_block17);
		
	}			

            _bw.write(_wl_block18Bytes, _wl_block18);

			gender_tab=rset.getString("Gender");
		if(gender_tab.equals("M"))
			gender_st="Male";
		else if(gender_tab.equals("F"))
			gender_st="Female";
		else if(gender_tab.equals("U"))
			gender_st="Unknown";

			if (c % 2 == 0 )
			class_val = "QRYEVEN" ;
		else
			class_val = "QRYODD" ;

		String encounter_id=rset.getString("encounter_id");
		String pat_id=rset.getString("PATIENT_ID");
		String clinic_type=rset.getString("clinic_type");
		String location_id=rset.getString("clinic_code");
		String pract_id=rset.getString("PRACTITIONER_ID");
		String service_code = rset.getString("SERVICE_CODE");
		String queue_date	=rset.getString("QUEUE_DATE");			
		registered_in_mo_yn	=rset.getString("REGISTERED_IN_MO_YN");	// Tuesday, April 27, 2010 registered_in_mo_yn	

		String visit_type =rset.getString("visit_type")==null?"":rset.getString("visit_type"); 
//		String practitioner_name =  rset.getString("practitioner_name1")==null?"":rset.getString("practitioner_name1"); 
		String disposition =  rset.getString("disposition_short_desc")==null?"":rset.getString("disposition_short_desc"); 
		String medical_yn =  rset.getString("medical_yn")==null?"":rset.getString("medical_yn"); 
		String surgical_yn =  rset.getString("surgical_yn")==null?"":rset.getString("surgical_yn"); 
		String mlc_yn =  rset.getString("mlc_yn")==null?"":rset.getString("mlc_yn"); 
		String deceased_time =  rset.getString("deceased_time")==null?"":rset.getString("deceased_time");
		String discharge_date_time = rset.getString("discharge_date_time")==null?"":rset.getString("discharge_date_time");
		String discharge_date_time1 = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
		/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
		String traumaYn			=  checkForNull(rset.getString("trauma_yn"),"N"); 
		String osccYn			=  checkForNull(rset.getString("oscc_yn"),"N"); 
		String OandGYn			=  checkForNull(rset.getString("o_and_g_yn"),"N"); 
		String nonEmergYn		=  checkForNull(rset.getString("non_emerg_yn"),"N"); 
		String mechInjCode		=  checkForNull(rset.getString("mech_injury_catg_code"),""); 
		String mechInjSubCode	=  checkForNull(rset.getString("mech_injury_subcatg_code"),""); 
		/*End*/

		String visit_type_ind = rset.getString("visit_type_ind")==null?"":rset.getString("visit_type_ind");
		String p_visit_id = rset.getString("OP_EPISODE_VISIT_NUM")==null?"":rset.getString("OP_EPISODE_VISIT_NUM");
		String p_episode_id = rset.getString("episode_id")==null?"":rset.getString("episode_id");
		String treatment_area_code =  rset.getString("treatment_area_code")==null?"":rset.getString("treatment_area_code");
		String locn_code = rset.getString("locn_code")==null?"":rset.getString("locn_code");
		String priority_zone =  rset.getString("priority_zone")==null?"":rset.getString("priority_zone");
		String deceased_yn = rset.getString("deceased_yn")==null?"":rset.getString("deceased_yn");
		String ae_bed_no =  rset.getString("ae_bed_no")==null?"":rset.getString("ae_bed_no");
		String high_risk_yn = rset.getString("high_risk_yn")==null?"":rset.getString("high_risk_yn");
		String pm_yn = rset.getString("pm_yn")==null?"":rset.getString("pm_yn");
		String ae_bed_charge = rset.getString("ae_bed_charge")==null?"":rset.getString("ae_bed_charge");
		String cdate = rset.getString("cdate")==null?"":rset.getString("cdate");
	    String priority_zone_status = rset.getString("priority_zone_status")==null?"":rset.getString("priority_zone_status");//Added By Shanmukh for MMS-DM-CRF-0147
		String visit_date=rset.getString("visit_date");
		visit_date = DateUtils.convertDate(visit_date,"DMYHM","en",locale);
		
		
		 String img_temp="";
			if(isVIPimgpatfrontappl) // added by mujafar for ML-MMOH-CRF-1070
			{	
			
			String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,pat_id,facility_id);
			if(vip_pat_yn.equals("TRUE"))
			img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
			else
			img_temp = "";


			}
		
		

		out.println("<tr>");	
		out.println("<td class='"+class_val+"'><font size=1>" +disposition+"</td>");
		//out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("visit_date")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +visit_date+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +discharge_date_time1+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("PATIENT_ID")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +img_temp+""+rset.getString("patient_name")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +gender_st+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>");		
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(location_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(registered_in_mo_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(visit_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disposition));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(deceased_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_visit_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_episode_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ae_bed_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(high_risk_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pm_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ae_bed_charge));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(location_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(registered_in_mo_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(disposition).replace("+","%20")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(medical_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(surgical_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(deceased_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_visit_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_episode_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ae_bed_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(high_risk_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pm_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ae_bed_charge));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cdate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(traumaYn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(osccYn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(OandGYn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nonEmergYn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mechInjCode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mechInjSubCode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(priority_zone_status));
            _bw.write(_wl_block23Bytes, _wl_block23);

		out.println(encounter_id+"</a></td>");//Modified by Rameswar Against IN55430
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("clinic_desc")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("SPECIALITY_DESC")+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +rset.getString("practitioner_name")+"</td>");

		if(module_id.equals("AE"))
		{
			String disaster_st = "";
			String dis_status = "";
			String trauma_st = "";
			String trauma_status = "";

			disaster_st=rset.getString("DISASTER_YN");
		if(disaster_st.equals("Y"))
			dis_status="Yes";
		else
			dis_status="No";

		trauma_st=rset.getString("TRAUMA_YN");
		if(trauma_st.equals("Y"))
			trauma_status="Yes";
		else
			trauma_status="No";

		out.println("<td class='"+class_val+"'><font size=1>" +dis_status+"</td>");
		out.println("<td class='"+class_val+"'><font size=1>" +trauma_status+"</td>");
		
		}

		out.println("</tr>");
				
		c++;
		i++;
		maxRecord++;
	}
	if(maxRecord == 0)
		{
			 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>");
			 
		}

		if ( maxRecord < 8 || (!rset.next()) )
		{
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 
		}
		else
		{
            _bw.write(_wl_block25Bytes, _wl_block25);

		}

if(rset!=null)
	rset.close();	
if(stmt!=null)
	stmt.close();


            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(isPriorityZoneAppl));
            _bw.write(_wl_block28Bytes, _wl_block28);

}
catch(Exception e)
{	
	out.println("Exception="+e.toString());
	e.printStackTrace();
	
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DispType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CheckoutDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
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
}
