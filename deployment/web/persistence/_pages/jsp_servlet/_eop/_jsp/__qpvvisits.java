package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __qpvvisits extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/QPVvisits.jsp", 1720587471134L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script Language=\"JavaScript\" src=\'../js/QueryPatientVisits.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n   \n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    \n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n\t\t\t<body onLoad=\'callPline();\' onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n    <form name=\"visittab_form\" id=\"visittab_form\" >\n    <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n    <tr><td align=\'center\'>\n    <table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n  \n    <th class=\'columnheader\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n    <th class=\'columnheader\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t<th class=\'columnheader\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n    <th class=\'columnheader\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\n    <th class=\'columnheader\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\n\t<!--Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start-->\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<th class=\'columnheader\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th> \n\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n    </table>\n    </td></tr>\n    </table>\n\n<script>\nif(parent.parent.frames[0].document.forms[0].search_button)\nparent.parent.frames[0].document.forms[0].search_button.disabled=false;</script>\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");	
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


	String Facility_Id = (String) session.getValue("facility_id");
	String patid=request.getParameter("patid");
	String mrnno=request.getParameter("mrnno");

	String dtfrm=request.getParameter("dtfrm");
	String dtto=request.getParameter("dtto");
	String serv=request.getParameter("serv");
	String loc=request.getParameter("loc");
	String locale = (String) session.getValue("LOCALE");
	String pract=request.getParameter("pract");
	String episode_id=request.getParameter("episode_id");
	String fr_epi_id=request.getParameter("fr_epi_id");
	String to_epi_id=request.getParameter("to_epi_id");
	String service_code = request.getParameter("service_code");
	String episode_status = request.getParameter("episode_status");
	String user_id = request.getParameter("user_id");
	//String episode_no = request.getParameter("episode_no");
	String speciality_id = request.getParameter("speciality_id");
	String fld2_display = "";
	if(mrnno==null) mrnno="";
	if(dtfrm==null) dtfrm="";
	if(dtto==null) dtto="";
	if(serv==null) serv="";
	if(loc==null) loc="";
	if(pract==null) pract="";
	if(episode_id==null) episode_id="";
	if(fr_epi_id==null) fr_epi_id="";
	if(to_epi_id==null) to_epi_id="";
	if(service_code==null)	service_code = "";
	if(episode_status==null)	episode_status = "";

	String visit_type_ind = "";
	String encounter_id="";
	StringBuffer where_criteria =new StringBuffer();
	StringBuffer row = new StringBuffer();
	String and_yn = "";
	Connection conn = null ;
	Statement stmt=null;
	ResultSet rset=null;

	
try
{
	
	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	boolean showCancelledVisits = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","INCLUDE_CANCELLED_VISITS");//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125
	
	StringBuffer sql =new StringBuffer();
	String FromDateTime = "";
	String ToDateTime = "";
	String extra_criteria = "";

		// patient_id 
		if (!patid.equals(""))
		{
			where_criteria.append( "patient_id = '"+patid+"'" );
			and_yn = " and ";
		}
		// MRN
		if (!mrnno.equals(""))
		{
			where_criteria.append( and_yn).append( " patient_id in(select patient_id from mr_pat_file_index  where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')");
			and_yn = " and ";
		}
		// Date From
		if (!dtfrm.equals(""))
		{
			where_criteria.append(and_yn).append("trunc(queue_date) >= to_date('"+dtfrm+"','dd/mm/yyyy')");
			and_yn = " and ";
		}
		// To
		if (!dtto.equals(""))
		{
			where_criteria.append( and_yn).append("trunc(queue_date) <= to_date('"+dtto+"','dd/mm/yyyy')");
			and_yn = " and ";
		}
		// Service
		if (!serv.equals(""))
		{
			where_criteria.append( and_yn).append( "service_code ='"+ serv +"'" );
			and_yn      = " and ";
		}
		if (!service_code.equals(""))
		{
			where_criteria .append( and_yn).append( "service_code ='"+ service_code +"'");
			and_yn      = " and ";
		}
		// Clinic
		if (!loc.equals(""))
		{
			//where_criteria .append( and_yn).append( "assign_care_locn_code ='"+loc+"'");
			where_criteria .append( and_yn).append( "locn_code ='"+loc+"'");
			and_yn      = " and ";
		}
		// Practitioner
		if (!pract.equals(""))
		{
			where_criteria .append(and_yn ).append( "practitioner_id='"+pract+"'");
			and_yn      = " and ";
		}
		if (episode_id != null && !episode_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id = '"+episode_id+"' ");
			and_yn      = " and ";
		}

		if (fr_epi_id != null && !fr_epi_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id >= '"+fr_epi_id+"' ");
			and_yn      = " and ";
		}

		if (to_epi_id != null && !to_epi_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id < '"+to_epi_id+"' ");
			and_yn      = " and ";
		}

		if(speciality_id != null && !speciality_id.equals(""))
		{
			where_criteria .append(and_yn).append( "speciality_code='"+speciality_id+"'");
			and_yn      = " and ";
		}

		if(user_id != null && !user_id.equals(""))
		{
			where_criteria .append(and_yn).append( "ADDED_BY_ID='"+user_id+"'");
			and_yn      = " and ";
		}
		

	if(!service_code.equals(""))
	{
	
	sql.append( "Select to_char(queue_date,'dd/mm/yyyy hh24:mi') from_date,queue_date visit_adm_date_time " );
	sql.append(" from op_patient_queue  " );
	sql.append(" where facility_id = '"+Facility_Id+"' and patient_class='OP' ");
	sql.append(" and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		

	if (fr_epi_id != null && !fr_epi_id.equals(""))
	{
		sql.append(" and episode_id >= '"+fr_epi_id+"' ");
	}

	if (to_epi_id != null && !to_epi_id.equals(""))
	{
		sql.append(" and episode_id < '"+to_epi_id+"' ");
	}

	sql.append(" order by queue_date " );
    rset = stmt.executeQuery(sql.toString());

	if(rset != null)
	{
		if(rset.next())
		{
			FromDateTime = rset.getString(1);
		}
	}
	if(FromDateTime == null)	FromDateTime = "";

	if(rset != null) rset.close();
	
	sql.setLength(0);

	sql.append( "Select to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date,queue_date visit_adm_date_time " );
	sql.append( " from op_patient_queue  " );
	sql.append(" where facility_id = '"+Facility_Id+"' and patient_class ='OP' ");
	sql.append( " and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
	
	if (fr_epi_id != null && !fr_epi_id.equals(""))
	{
		sql.append(" and episode_id >= "+fr_epi_id+" ");
	}

	if (to_epi_id != null && !to_epi_id.equals(""))
	{
		sql.append(" and episode_id < "+to_epi_id+" ");
	}
	sql.append(" order by queue_date desc");

	rset = stmt.executeQuery(sql.toString());
	if(rset != null)
	{
		if(rset.next())
		{
			ToDateTime = rset.getString(1);
		}
	}

	if(ToDateTime == null)	ToDateTime = "";

	if(rset != null) rset.close();

	sql.setLength(0);
	
	if(!FromDateTime.equals(""))
		extra_criteria = " and TO_DATE(TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') between to_date('"+FromDateTime+"','dd/mm/yyyy hh24:mi') and to_date(nvl('"+ToDateTime+"',to_char(sysdate,'dd/mm/yyyy hh24:mi')),'dd/mm/yyyy hh24:mi') and service_code = '"+service_code+"' ";
	}
 
    /*sql.setLength(0);   
	int maxRecord = 0;
	
    sql.append("select count(*) as total from Pr_Search_visit_vw ");
    sql.append( "where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);
	
	if (!episode_status.equals(""))
		sql.append( " and nvl(episode_status,'"+episode_status+"') = '"+episode_status+"'"); 
	
    rset = stmt.executeQuery(sql.toString());
	rset.next();
	maxRecord = rset.getInt("total");

	if(rset != null) rset.close();

	sql.setLength(0);
	
	if(maxRecord == 0)	
	{				
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}else
	{*/
	try
	{
	 sql.setLength(0);
	
	/*Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start*/
	if(showCancelledVisits){

		sql.append("SELECT   patient_id, TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') adm_date_time, patient_class,			  am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)service_short_desc, op_get_desc.OP_CLINIC(facility_id,LOCN_CODE, '"+locale+"',1)clinic_desc ,  op_get_desc.OP_VISIT_TYPE(facility_id,VISIT_TYPE_code,'"+locale+"',2)visit_type_desc,			  am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2) practitioner_name,		  am_get_desc.am_disposition_type(disposition_type,'"+locale+"',2)disposition_short_desc,  NVL(op_episode_visit_num,''),	 ENCOUNTER_ID, 'A' visit_type_ind,  queue_date,  CANCEL_REASON_CODE,am_get_desc.am_contact_reason(CANCEL_REASON_CODE,'"+locale+"',2)CANCEL_REASON_DESC,SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'en',1) user_name  FROM 	  op_patient_queue	WHERE facility_id = '"+Facility_Id+"' AND ").append(where_criteria).append(extra_criteria);
		 
	}/*End*/


	else{

		sql.append("SELECT   patient_id, TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') adm_date_time, patient_class,			  am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)service_short_desc, op_get_desc.OP_CLINIC(facility_id,LOCN_CODE, '"+locale+"',1)clinic_desc ,  op_get_desc.OP_VISIT_TYPE(facility_id,VISIT_TYPE_code,'"+locale+"',2)visit_type_desc,			  am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2) practitioner_name,		  am_get_desc.am_disposition_type(disposition_type,'"+locale+"',2)disposition_short_desc,  NVL(op_episode_visit_num,''),	 ENCOUNTER_ID, 'A' visit_type_ind,  queue_date,  CANCEL_REASON_CODE,am_get_desc.am_contact_reason(CANCEL_REASON_CODE,'"+locale+"',2)CANCEL_REASON_DESC,SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'en',1) user_name  FROM 	  op_patient_queue	WHERE QUEUE_STATUS!='99' and facility_id = '"+Facility_Id+"' AND ").append(where_criteria).append(extra_criteria);

	}

    /*sql.append("select patient_id, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') adm_date_time, ");
    sql.append("patient_class, service_short_desc, clinic_desc , visit_type_desc, practitioner_name, ");
    sql.append("disposition_short_desc, nvl(op_episode_visit_num,'') , ");
	sql.append(" ENCOUNTER_ID, level_of_care_ind visit_type_ind, visit_adm_date_time,CANCEL_REASON_CODE, CANCEL_REASON_DESC  ");
    sql.append( "from Pr_Search_visit_vw ");
    sql.append("where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);*/
	
	if (!episode_status.equals(""))
		sql.append( " and nvl(episode_status,'"+episode_status+"') = '"+episode_status+"'"); 

    sql.append( " order by queue_date desc");
	
	rset = stmt.executeQuery(sql.toString());
	
	
//	if(rset.next())
//	{
		// rset.previous();	

            _bw.write(_wl_block8Bytes, _wl_block8);


    String classValue = "";

    String fld1="";
    String fld2="";
    String fld3="";
    String fld4="";
    String fld5="";
    String fld6="";
    String fld7="";
    String fld8="";
    String fld9="";
	String cancelReasonCode="";//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125
	String user = "";

	

    int i = 0;
    //if(rset != null) 
	//{
		int count=0;
        while(rset.next())
        {if(count==0)
			{
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(showCancelledVisits){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}/*End*/
			}
			count++;
			if ( i%2 == 0 )
                classValue="QRYEVEN";
            else
                classValue="QRYODD";

            fld1=rset.getString(1); if(fld1 == null) fld1="";
            fld2=rset.getString(2); if(fld2 == null) fld2="";

			fld2_display=DateUtils.convertDate(fld2,"DMYHM","en",locale);

            fld3=rset.getString(3); if(fld3 == null) fld3="";
            fld4=rset.getString(4); if(fld4 == null) fld4="";
            fld5=rset.getString(5); if(fld5 == null) fld5="";
            fld6=rset.getString(6); if(fld6 == null) fld6="";
            fld7=rset.getString(7); if(fld7 == null) fld7="";
            fld8=rset.getString(8); if(fld8 == null) fld8="";
            fld9=rset.getString(9); if(fld9 == null) fld9="";
            encounter_id=rset.getString(10); if(encounter_id == null) encounter_id="";
            visit_type_ind=rset.getString(11); if(visit_type_ind == null) visit_type_ind="";
			
			cancelReasonCode=rset.getString("CANCEL_REASON_CODE"); if(cancelReasonCode == null) cancelReasonCode="";//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125

			String speciality_desc=rset.getString("SPECIALITY_DESC"); 
			if(speciality_desc == null) speciality_desc="";

			user=rset.getString("user_name");
			if(user == null)
				user="";
			
           
			row.append("<tr><td  class='" + classValue + "' nowrap>" + fld2_display + "</td>");
            row.append("<td  class='" + classValue + "' nowrap>" + fld4 + "</td>");
            row.append("<td  class='" + classValue + "' nowrap>" + fld5 + "</td>");

			row.append("<td  class='" + classValue + "' nowrap>" + speciality_desc + "</td>");

            row.append("<td  class='" + classValue + "' nowrap>" + fld6 + "</td>");
            if(fld7!="")
            {
                row.append("<td  class='" + classValue + "'>" + fld7 + "</td>");
            }
            else
            {
                row.append("<td  class='" + classValue + "'>&nbsp;</td>");
            }
            if(fld8!="")
            {
                row.append("<td  class='" + classValue + "' nowrap>" + fld8 + "</td>");
            }
            else
            {
                row.append("<td  class='" + classValue + "'>&nbsp;</td>");
            }
            row.append("<td  class='" + classValue + "' nowrap>" + fld9 + "</td>");

			row.append("<td  class='" + classValue + "' nowrap>" +user+ "</td>");
			
			/*Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start*/
			if(showCancelledVisits){
				if(cancelReasonCode!="")
				{
					row.append("<td  class='" + classValue + "' nowrap>" + "Y" + "</td>");
				}
				else
				{
					row.append("<td  class='" + classValue + "' nowrap>" + "N" + "</td>");
				}
			}/*End*/
	
			row.append("</tr>");

            out.print(row.toString());

			row.setLength(0);
            
            i++;
        }
    //}
	if(rset != null) rset.close();	
	/*}else*/
	if(count==0)
	{	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}
	}
	catch(Exception e){out.println("Exception@1 "+e.toString());}

   if(stmt != null) stmt.close();
   sql.setLength(0);
   row.setLength(0);
}
catch(Exception e){out.println("Exception@Main "+e.toString());}
finally
{
	try
	{
		if (rset != null ) rset.close();
		if( stmt != null) stmt.close();
	}catch(Exception e) {}
    if(conn!=null) ConnectionManager.returnConnection(conn,request);  
}
    
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disposition.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.VisitNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
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
}
