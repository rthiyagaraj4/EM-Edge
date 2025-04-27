package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __concludeepisoderesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ConcludeEpisodeResult.jsp", 1724243385478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script> \n\t<script language=\"javascript\" src=\"../../eOP/js/ConcludeEpisode.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n</head>\n<body onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\"conclude_episode_result\" id=\"conclude_episode_result\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t\t<p>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t</p>\n\t\t\t<table width=\"100%\" border=\'1\' cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<th class=\'columnheader\' style=\"background-color: color: white;\" >&nbsp;</th>\n\t\t\t<th class=\'columnheader\' style=\"background-color: color: white;\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th class=\'columnheader\' style=\"background-color: color: white;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\n\t\t\t\t\t\t<tr><td colspan=\'8\' class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" / ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t\t<tr><td colspan=\'8\' class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<tr><td colspan=\'8\' class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td></tr>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t\t\t<tr><td colspan=\'8\'class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" Y </td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<script >\n\tif (document.getElementById(\"next\"))\n\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t</script>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<script >\n\tif (document.getElementById(\"next\"))\n\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
 	String classValue = "";
	String practname = "";
	String clinic_code = "";
	String clinic_desc = "";
	String service_code = "";
	String service_desc = "";
	String whereClause = "";
	//String endOfRes="1";
	String gender = "";
	String locale=(String)session.getAttribute("LOCALE");
	whereClause = request.getParameter("whereclause");	
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String visDtTm = "";
	String visDtTm_display = "";

	String patient_menu = "";
	String start_date = "";
	String sydate = "";

	if(whereClause == null || whereClause.equals("null")) whereClause="";
	
	if ((whereClause == null || whereClause.equals("")))
	{		
		whereClause = request.getParameter("where_clause");
	}
	int start = 0 ;
    int end = 0 ;
	int i = 1;
    

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from );

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;
	
	String facility_id = (String) session.getValue("facility_id"); 

	//int maxRecord = 0;
	try
	{
		con = ConnectionManager.getConnection(request);

        // The sql query results Episode id, patient id, patient name, age, last visit date time, Practitioner name and displays the results in the result screen   ---  Srijagadeesh. 		

		//String sql = "SELECT a.CLINIC_CODE, c.short_desc CLINIC_DESC, a.SERVICE_CODE, f.short_desc SERVICE_DESC, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME, CALCULATE_AGE(TO_CHAR(b.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, b.SEX GENDER, a.LAST_ENCOUNTER_ID, TO_CHAR(a.LAST_VISIT_DATE,'DD/MM/YYYY HH24:MI') LAST_VISIT_DATE_TIME, e.practitioner_id ATTEND_PRACTITIONER_ID, decode(e.practitioner_id,'*ALL','*ALL',am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME FROM OP_EPISODE_FOR_SERVICE A, MP_PATIENT B, op_patient_queue E, op_clinic_lang_vw c, am_service_lang_vw f WHERE A.EPISODE_STATUS = '01' AND A.PATIENT_ID = B.PATIENT_ID AND A.OPERATING_FACILITY_ID = E.FACILITY_ID AND A.LAST_ENCOUNTER_ID = E.ENCOUNTER_ID "+whereClause+" AND A.LAST_VISIT_FU_REQD_YN='N' AND (E.queue_status IN ('07','08') OR e.queue_status = '99') AND a.operating_facility_id = c.facility_id AND a.clinic_code = c.clinic_code AND c.language_id = '"+locale+"' AND a.service_code = f.service_code AND f.language_id = '"+locale+"' GROUP BY a.CLINIC_CODE, c.short_desc, a.SERVICE_CODE, f.short_desc, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)), b.DATE_OF_BIRTH, b.SEX, a.LAST_ENCOUNTER_ID, a.LAST_VISIT_DATE, e.PRACTITIONER_ID  ORDER BY CLINIC_DESC, SERVICE_DESC,TO_DATE(LAST_VISIT_DATE_TIME,'DD/MM/YYYY HH24:MI')";

		String sql = "SELECT a.CLINIC_CODE, op_get_desc.op_clinic('"+facility_id+"',a.CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, get_patient_line(a.patient_id,'"+locale+"') patient_menu , a.SERVICE_CODE, am_get_desc.AM_SERVICE(a.SERVICE_CODE,'"+locale+"',2) SERVICE_DESC, a.EPISODE_ID, b.PATIENT_ID, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME, CALCULATE_AGE(TO_CHAR(b.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, b.SEX GENDER, a.LAST_ENCOUNTER_ID, TO_CHAR(a.start_date_time,'dd/mm/yyyy hh24:mi') start_date, TO_CHAR(a.LAST_VISIT_DATE,'DD/MM/YYYY HH24:MI') LAST_VISIT_DATE_TIME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate, e.practitioner_id ATTEND_PRACTITIONER_ID, decode(e.practitioner_id,'*ALL','*ALL', am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"','1')) PRACTITIONER_NAME FROM OP_EPISODE_FOR_SERVICE A, MP_PATIENT B, op_patient_queue E WHERE A.EPISODE_STATUS = '01' AND A.PATIENT_ID = B.PATIENT_ID AND A.OPERATING_FACILITY_ID = E.FACILITY_ID AND A.LAST_ENCOUNTER_ID = E.ENCOUNTER_ID "+whereClause+" AND A.LAST_VISIT_FU_REQD_YN='N' AND (E.queue_status IN ('07','08') OR e.queue_status = '99') ORDER BY CLINIC_DESC, SERVICE_DESC, TO_DATE(LAST_VISIT_DATE_TIME,'DD/MM/YYYY HH24:MI')";
		
	//	System.out.println("sql in conclude----->"+sql);
		
		pstmt = con.prepareStatement(sql);		
		rs = pstmt.executeQuery();	

		if ( start != 1 )
		     for( int k=1; k<start; i++,k++ )				
			     rs.next() ;		
		
		int cnt = 0;

		while( i <= end && rs.next() )
		{ //rs.previous();
		  if (cnt==0)
			{
            _bw.write(_wl_block8Bytes, _wl_block8);

				if ( !(start <= 1) )
					out.println("<td align ='right'><A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");				
			
            _bw.write(_wl_block9Bytes, _wl_block9);

				
				out.println("<A  HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 }
			
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				clinic_desc	= rs.getString("CLINIC_DESC");
				service_desc = rs.getString("SERVICE_DESC");

				if(i == 1)
					{
						clinic_code	= rs.getString("CLINIC_CODE");
						service_code = rs.getString("SERVICE_CODE");
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}else
					{
						if(!clinic_code.equals(rs.getString("CLINIC_CODE")) && !service_code.equals(rs.getString("SERVICE_CODE")))
						{
							clinic_code = rs.getString("CLINIC_CODE");
							service_code = rs.getString("SERVICE_CODE");
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}else if(!service_code.equals(rs.getString("SERVICE_CODE")))
						 {
								service_code = rs.getString("SERVICE_CODE");
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

								}else if(!clinic_code.equals(rs.getString("CLINIC_CODE")))
							 {
								clinic_code = rs.getString("CLINIC_CODE");
					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

							 }
						}				    

					practname = rs.getString("PRACTITIONER_NAME");
					if(practname == null || practname.equals("null")) practname = "&nbsp;";

					patient_menu = rs.getString("patient_menu") == null?"":rs.getString("patient_menu");
					start_date = rs.getString("start_date") == null?"":rs.getString("start_date");
					sydate = rs.getString("sydate") == null?"":rs.getString("sydate"); 		
					
					

					out.println("<tr><td class='"+classValue+"' ><a href='javascript:showpPrevEncounters(\""+rs.getString("EPISODE_ID")+"\")'>&nbsp;+&nbsp;</a></td>");
					out.println("<td class='"+classValue+"' nowrap><a href=\"javascript:conclude('"+rs.getString("EPISODE_ID")+"','"+rs.getString("PATIENT_ID")+"','"+patient_menu+"','"+practname+"','"+clinic_desc+"','"+service_desc+"','"+start_date+"','"+sydate+"')\">"+rs.getString("EPISODE_ID")+"</a></td>");
					visDtTm = rs.getString("LAST_VISIT_DATE_TIME");
					visDtTm_display = DateUtils.convertDate(visDtTm,"DMYHM","en",locale); 

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visDtTm_display));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("PATIENT_NAME")));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
					   gender = rs.getString("GENDER"); 
					   if(gender.equals("M")) 
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					   else if(gender.equals("F"))
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					   else if(gender.equals("U"))
						  gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");	
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("AGE")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block26Bytes, _wl_block26);
		
					i++;
					cnt++;
		} //end while
			//}

   //rs.previous();  

if (cnt==0)
{	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
}	

if ( cnt < 14 || (!rs.next()) ) {

            _bw.write(_wl_block27Bytes, _wl_block27);
 
		} else {
            _bw.write(_wl_block28Bytes, _wl_block28);
}
	
}catch(Exception e)
{ 
	e.printStackTrace();
}
	finally
	{
		try{
		out.println("<script>parent.frames[1].document.forms[0].search.disabled = false ;</script>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
}
