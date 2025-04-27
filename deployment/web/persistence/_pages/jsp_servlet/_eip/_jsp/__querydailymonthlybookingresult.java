package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.net.*;

public final class __querydailymonthlybookingresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryDailyMonthlyBookingResult.jsp", 1719431168971L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n    <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		//PreparedStatement pstmt_count = null;
		//ResultSet rs_count =null;
		//int total_count=0;
		int maxRecord=0;
		int start=1;
		int end=0;
		int records_to_show=14;

		//StringBuffer sql_count = new StringBuffer();
		StringBuffer sqlSb = new StringBuffer();

		String facilityid		= (String)session.getAttribute("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");
		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
		StringBuffer whereClause= new StringBuffer("");
			whereClause.append(checkForNull(request.getParameter("whereclause")));

		String dailymonthly		= checkForNull(request.getParameter("daily_monthly"));
		String groupby			= checkForNull(request.getParameter("group_by"));
		String nursingunit		= checkForNull(request.getParameter("nursing_unit"));
		String bedclass			= checkForNull(request.getParameter("bed_class"));
		String medicalservicegrp= checkForNull(request.getParameter("medical_service_grp"));
		String fromdate			= checkForNull(request.getParameter("from_date"));
		if(!fromdate.equals(""))
				fromdate = DateUtils.convertDate(fromdate,"DMY",locale,"en"); 
		String todate			= checkForNull(request.getParameter("to_date"));
		if(!todate.equals(""))
				todate = DateUtils.convertDate(todate,"DMY",locale,"en"); 
		String frommonth		= checkForNull(request.getParameter("from_month"));
		if(!frommonth.equals(""))
				frommonth = DateUtils.convertDate(frommonth,"MY",locale,"en"); 
		String tomonth			= checkForNull(request.getParameter("to_month"));
		if(!tomonth.equals(""))
				tomonth = DateUtils.convertDate(tomonth,"MY",locale,"en"); 

		String prevcode = "";
		String prevdate = "";
		String prevBed = "";
		String className = "";
		
		int i = 0;

		if(!medicalservicegrp.equals(""))
			whereClause.append(" and a.med_ser_grp_code = '"+medicalservicegrp+"' ");
		if(!nursingunit.equals(""))
			whereClause.append(" and A.nursing_unit_code = '"+nursingunit+"' ");
		if(!bedclass.equals(""))
			if(groupby.equals("NU") && (dailymonthly.equals("D")))
				whereClause.append(" and b.bed_class_code = '"+bedclass+"' ");
			else	
				whereClause.append(" and A.bed_class_code = '"+bedclass+"' ");
		if(!fromdate.equals("") || !todate.equals(""))
			whereClause.append(" and trunc(a.preferred_date) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
		if(!frommonth.equals("") || !tomonth.equals(""))
			whereClause.append(" and to_date(to_char(a.preferred_date,'MM/rrrr'),'mm/rrrr') between to_date(nvl('"+frommonth+"','1/1111'),'mm/rrrr') and to_date(nvl('"+tomonth+"','9/9999'),'mm/rrrr') ");
	
            _bw.write(_wl_block4Bytes, _wl_block4);

			try
			{
				con =ConnectionManager.getConnection(request);
				//Added by Devang for Previous/Next logic
				if(groupby.equals("MS"))
				{
					if(dailymonthly.equals("D"))
					{
						/*if (sql_count.length() > 0)
							sql_count.delete(0, sql_count.length());

						sqlSb.append("select a.med_ser_grp_code code,IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(a.facility_id,a.med_ser_grp_code,'"+locale+"','2') short_desc, to_char(trunc(preferred_date),'dd/mm/rrrr') display_date ,max_no_of_dly_booking Maximum, count(decode(gender,'M','Male')) Male,  count (decode(gender,'F','Female')) Female, count(decode(gender,'U','Unknown')) Unknown,(count(decode(gender,'M','Male')) + count (decode(gender,'F','Female')) + count(decode(gender,'U','Unknown'))) Total, round((count(decode(gender,'M','Male')) +count (decode(gender,'F','Female')) + count(decode(gender,'U','Unknown')))  / decode(max_no_of_dly_booking,0, (count(decode(gender,'M','Male')) + count (decode(gender,'F','Female')) +  count(decode(gender,'U','Unknown')) ), max_no_of_dly_booking) *100,2 ) Percentage from ip_booking_list a where a.facility_id='"+facilityid+"' and group by a.med_ser_grp_code, IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(a.facility_id,a.med_ser_grp_code,'"+locale+"','2'), trunc(preferred_date),max_no_of_dly_booking  ORDER BY 1,2 desc ");*/

						if (sqlSb.length() > 0)
							sqlSb.delete(0, sqlSb.length());

						sqlSb.append("select a.med_ser_grp_code code,b.short_desc, to_char(trunc(a.preferred_date),'dd/mm/rrrr') display_date, b.max_no_of_dly_booking Maximum, count(decode(a.gender,'M','Male')) Male,  count(decode(gender,'F','Female')) Female, count(decode(a.gender,'U','Unknown')) Unknown,(count(decode(a.gender,'M','Male')) + count (decode(a.gender,'F','Female')) + count(decode(a.gender,'U','Unknown'))) Total, round((count(decode(a.gender,'M','Male')) + count(decode(a.gender,'F','Female')) + count(decode(a.gender,'U','Unknown')))  / decode(b.max_no_of_dly_booking,0, (count(decode(a.gender,'M','Male')) + count (decode(a.gender,'F','Female')) + count(decode(a.gender,'U','Unknown')) ), b.max_no_of_dly_booking) *100,2 ) Percentage from ip_booking_list a, ip_medical_service_grp_lang_vw b where  a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id and a.MED_SER_GRP_CODE = b.MED_SER_GRP_CODE  AND b.language_id = '"+locale+"' "+whereClause.toString()+" group by a.med_ser_grp_code, b.short_desc,trunc(a.preferred_date),b.max_no_of_dly_booking  ORDER BY 1,2 desc") ;

					}
					else
					{
						/*if (sql_count.length() > 0)
							sql_count.delete(0, sql_count.length());
						
						sqlSb.append("SELECT a.med_ser_grp_code code, IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(a.facility_id, a.med_ser_grp_code,'"+locale+"','2') short_desc, TO_CHAR (TRUNC (preferred_date), 'mm/rrrr') display_date, MAX_NO_OF_MTHLY_BOOKING maximum, COUNT (DECODE (gender, 'M', 'Male')) male, COUNT (DECODE (gender, 'F', 'Female')) female, COUNT (DECODE (gender, 'U', 'Unknown')) unknown,  (  COUNT (DECODE (gender, 'M', 'Male')) + COUNT (DECODE (gender, 'F', 'Female')) + COUNT (DECODE (gender, 'U', 'Unknown')) ) total, ROUND ((  COUNT (DECODE (gender, 'M', 'Male')) + COUNT (DECODE (gender, 'F', 'Female')) + COUNT (DECODE (gender, 'U', 'Unknown')) )  / DECODE (MAX_NO_OF_MTHLY_BOOKING, 0, (  COUNT (DECODE (gender, 'M', 'Male'))  + COUNT (DECODE (gender, 'F', 'Female')) + COUNT (DECODE (gender, 'U', 'Unknown')) ), MAX_NO_OF_MTHLY_BOOKING )* 100, 2 ) percentage  FROM ip_booking_list a, ip_medical_service_group b WHERE a.facility_id = '"+facilityid+"' GROUP BY a.med_ser_grp_code, IP_GET_DESC.IP_MEDICAL_SERVICE_GROUP(a.facility_id, a.med_ser_grp_code,'"+locale+"','2'), TRUNC (preferred_date), MAX_NO_OF_MTHLY_BOOKING ORDER BY 1, 2 DESC"); */

						if (sqlSb.length() > 0)
							sqlSb.delete(0, sqlSb.length());

						sqlSb.append("select a.med_ser_grp_code code,b.short_desc, to_char(trunc(a.preferred_date),'mm/rrrr') display_date, b.MAX_NO_OF_MTHLY_BOOKING Maximum,count(decode(a.gender,'M','Male')) Male,  count(decode(gender,'F','Female')) Female,count(decode(a.gender,'U','Unknown')) Unknown,(count(decode(a.gender,'M','Male')) + count (decode(a.gender,'F','Female')) + count(decode(a.gender,'U','Unknown'))) Total, round((count(decode(a.gender,'M','Male')) +count (decode(a.gender,'F','Female')) + count(decode(a.gender,'U','Unknown')))  / decode(b.MAX_NO_OF_MTHLY_BOOKING,0, (count(decode(a.gender,'M','Male')) + count (decode(a.gender,'F','Female')) +  count(decode(a.gender,'U','Unknown')) ), b.MAX_NO_OF_MTHLY_BOOKING ) *100,2 ) Percentage from ip_booking_list a, ip_medical_service_grp_lang_vw b where  a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id and a.MED_SER_GRP_CODE =  b.MED_SER_GRP_CODE  AND b.language_id = '"+locale+"' "+whereClause.toString()+" group by a.med_ser_grp_code, b.short_desc,trunc(a.preferred_date), b.MAX_NO_OF_MTHLY_BOOKING  ORDER BY 1,2 desc"); 
						
					}
				}
				else
				{
					if(dailymonthly.equals("D"))
					{
						/*if (sql_count.length() > 0)
							sql_count.delete(0, sql_count.length());

						sqlSb.append("SELECT nvl(b.nursing_unit_code,'NSpec') code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_code,'"+locale+"','2'), 'Not Specified') short_desc, B.bed_class_code, Nvl(IP_GET_DESC.IP_BED_CLASS (b.bed_class_code,'"+locale+"','2'),'Not Specified') BED_CLASS_SHORT_DESC,   to_char(trunc(b.preferred_date),'dd/mm/rrrr') Pref_Date, NVL(max_male_dly_booking,0) Max_M ,  COUNT(DECODE(gender,'M','Male')) Male, NVL(max_male_dly_booking,0) - COUNT(DECODE(gender,'M','Male')) Avl_M,  NVL(max_female_dly_booking,0) Max_F,   COUNT (DECODE(gender,'F','Female')) Female, NVL(max_female_dly_booking,0) - COUNT(DECODE(gender,'F','Male')) Avl_F, NVL(max_unknown_dly_booking,0) Max_UK,  COUNT(DECODE(gender,NULL,'Unknown')) Unknown, NVL(max_unknown_dly_booking,0) - COUNT(DECODE(gender,NULL,'Unknown')) Avl_UK, NVL(max_total_dly_booking,0) Max_T,  COUNT(DECODE(gender,'M','Male'))+ COUNT(DECODE(gender,'F','Female'))+COUNT(DECODE(gender,NULL,'Unknown')) Total,  NVL(max_total_dly_booking,0) - (COUNT(DECODE(gender,'M','Male'))+  COUNT(DECODE(gender,'F','Female'))+COUNT(DECODE(gender,NULL,'Unknown')))Avl_T FROM  ip_book_limit_by_nurs_ut A, ip_booking_list b WHERE b.facility_id='"+facilityid+"' AND A.facility_id(+)=b.facility_id  AND A.nursing_unit_code(+)=b.nursing_unit_code and A.bed_class_code(+)=b.bed_class_code GROUP BY trunc(b.preferred_date), b.nursing_unit_code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_code,'"+locale+"','2') ,'Not Specified'), b.bed_class_code, Nvl(IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,'"+locale+"','2'),'Not Specified'),  max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking, max_total_dly_booking order by 3,trunc(preferred_date) DESC ");*/
						if (sqlSb.length() > 0)
							sqlSb.delete(0, sqlSb.length());

						sqlSb.append("SELECT nvl(a.nursing_unit_code,'NSpec') code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+locale+"','2'),'Not Specified') short_desc, a.bed_class_code, Nvl(IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2'),'Not Specified') BED_CLASS_SHORT_DESC, to_char(trunc(a.preferred_date),'dd/mm/rrrr') Pref_Date,NVL(max_male_dly_booking,0) Max_M , COUNT(DECODE(gender,'M','Male')) Male,NVL(max_male_dly_booking,0) - COUNT(DECODE(gender,'M','Male')) Avl_M, NVL(max_female_dly_booking,0) Max_F,   COUNT (DECODE(gender,'F','Female')) Female,NVL(max_female_dly_booking,0) - COUNT(DECODE(gender,'F','Male')) Avl_F,NVL(max_unknown_dly_booking,0) Max_UK, COUNT(DECODE(gender,NULL,'Unknown')) Unknown, NVL(max_unknown_dly_booking,0) - COUNT(DECODE(gender,NULL,'Unknown')) Avl_UK, NVL(max_total_dly_booking,0) Max_T, COUNT(DECODE(gender,'M','Male'))+ COUNT(DECODE(gender,'F','Female'))+COUNT(DECODE(gender,NULL,'Unknown')) Total, NVL(max_total_dly_booking,0) - (COUNT(DECODE(gender,'M','Male'))+  COUNT(DECODE(gender,'F','Female'))+COUNT(DECODE(gender,NULL,'Unknown')))Avl_T FROM ip_booking_list a, 	ip_book_limit_by_nurs_ut b WHERE a.facility_id='"+facilityid+"' AND b.facility_id(+)=a.facility_id  AND b.nursing_unit_code(+)=a.nursing_unit_code and b.bed_class_code(+)=a.bed_class_code  "+whereClause.toString()+"  GROUP BY trunc(preferred_date),a.nursing_unit_code,Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.nursing_unit_code,'"+locale+"','2'),'Not Specified'), a.bed_class_code, Nvl(IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2'),'Not Specified'), max_male_dly_booking,max_female_dly_booking,max_unknown_dly_booking,max_total_dly_booking order by  3,trunc(preferred_date) desc ");
						

					}
					else
					{
						/*if (sql_count.length() > 0)
							sql_count.delete(0, sql_count.length());

						sqlSb.append("SELECT nvl(a.nursing_unit_code,'Not Specified') code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+locale+"','2'),'Not Specified') Short_desc, a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') BED_CLASS_SHORT_DESC, to_char(preferred_date,'mm/rrrr') display_date, COUNT(DECODE(gender,'M','Male')) Male, COUNT(DECODE(gender,'F','Female')) Female, COUNT(DECODE(gender,null,'Unknown')) Unknown, count(gender) Total FROM ip_booking_list A WHERE a.facility_id='"+facilityid+"'  GROUP BY to_char(preferred_date,'mm/rrrr'), a.nursing_unit_code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+locale+"','2') ,'Not Specified'), a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') ORDER BY TO_DATE(TO_CHAR(preferred_date, 'mm/rrrr'),'mm/rrrr') desc ");*/

						if (sqlSb.length() > 0)
							sqlSb.delete(0, sqlSb.length());

						sqlSb.append("SELECT nvl(a.nursing_unit_code,'Not Specified') code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+locale+"','2'),'Not Specified') Short_desc, a.bed_class_code,IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') BED_CLASS_SHORT_DESC,to_char(preferred_date,'mm/rrrr') display_date, COUNT(DECODE(gender,'M','Male')) Male,COUNT(DECODE(gender,'F','Female')) Female, COUNT(DECODE(gender,null,'Unknown')) Unknown, count(gender) Total FROM ip_booking_list A WHERE a.facility_id='"+facilityid+"'  "+whereClause.toString()+" GROUP BY to_char(preferred_date,'mm/rrrr'), a.nursing_unit_code, Nvl(IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+locale+"','2'),'Not Specified'), a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') ORDER BY TO_DATE(TO_CHAR(preferred_date, 'mm/rrrr'),'mm/rrrr') desc ");

					}
				}
				
				//out.println("sql is:"+sqlSb.toString());
				//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				stmt	=	con.createStatement();
				rs = stmt.executeQuery(sqlSb.toString());

				/*if ( (rs != null) )
				{
					rs.last();
					total_count = rs.getRow();
					rs.beforeFirst();
				}*/

				//if(rs_count!=null)rs_count.close();
							
				/*if(total_count==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
				else
				{*/	
				
				//stmt = con.createStatement();

				String thlegend = "";

				//added by Devang for Previous/Next
				if ( from == null )
                    start = 0 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;

				if(start > 1)
					{
						for(int k=0; k < start ;k++)
						rs.next();
					}
				int z=0;

			while((z < records_to_show) && rs.next()  )
			{

				if(maxRecord==0)
				{
				
					out.println("<p><table align='right'><tr>");
					if ( !(start <= 0) )
							out.println("<td id='prev'><A HREF='../jsp/QueryDailyMonthlyBookingResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&daily_monthly="+dailymonthly+"&group_by="+groupby+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
							" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

						//if ( !((start+records_to_show) >= total_count ) )
						   out.println("<td id='next' style='visibility:hidden'><A HREF='../jsp/QueryDailyMonthlyBookingResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&daily_monthly="+dailymonthly+"&group_by="+groupby+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
							" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					out.println("</tr></table></p>");
					out.println("<br><br>");
					out.println("<table  cellpadding=0 cellspacing=0 border=1 width='80%' align='center'>");
				}

				if(groupby.equals("MS"))
				{
					if(maxRecord==0)
					{
						if(dailymonthly.equals("D"))
						{
							thlegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels");
							out.println("<font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DailyBookingsByMedicalServiceGroup.label","ip_labels")+" :</b></font>");
							
						}
						else
						{
							thlegend = "Preferred  Month";
							out.println("<font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MonthlyBookingsByMedicalServiceGroup.label","ip_labels")+" :</b></font>");
							
						}
					
						out.println("<tr><th>"+thlegend+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+"</th><th nowrap>&nbsp;%"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels")+"&nbsp;"+"</th></tr>");
					}

					/*if(start > 1)
					{
						for(int k=0; k < start ;k++)
						rs.next();
					}
					int z=0;	*/	
					//while(rs.next() && (z < records_to_show))
					//{
						z++;
						if(i%2 == 0)
							className = "QRYEVEN";
						else
							className = "QRYODD";
						
						String currcode = checkForNull(rs.getString("code"));
						String maximum = checkForNull(rs.getString("Maximum"));

						if(maximum.equals("0") || maximum.equals(""))  maximum = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSpecified.label","ip_labels");

						if(!prevcode.equals(currcode))
						{
							out.println("<tr><th colspan=6 align='left'>"+checkForNull(rs.getString("Short_desc"))+"</th></tr>");
							out.println("<tr><td colspan=6 class=CAGROUPHEADING>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MaximumAllowed.label","ip_labels")+" : "+maximum+"</td></tr>");
						}

						String display_date_display = rs.getString("display_date");
								
						if(display_date_display == null)
							display_date_display = "";
						else
						{
								if(dailymonthly.equals("D"))
								{
									display_date_display = DateUtils.convertDate(display_date_display,"DMY","en",locale);
								}
								else
								{
									
									display_date_display = DateUtils.convertDate(display_date_display,"MY","en",locale);
								}
						}

						out.println("<tr><td class='"+className+"' >"+display_date_display+"</td>");
						out.println("<td class='"+className+"' align=right width='10%'>"+checkForNull(rs.getString("Male"))+"</td>");
						out.println("<td class='"+className+"' align=right width='10%'>"+checkForNull(rs.getString("Female"))+"</td>");
						out.println("<td class='"+className+"' align=right width='10%'>"+checkForNull(rs.getString("Unknown"))+"</td>");
						out.println("<td class='"+className+"' align=right width='10%'>"+checkForNull(rs.getString("Total"))+"</td>");
						out.println("<td class='"+className+"' align=right width='10%'>"+checkForNull(rs.getString("Percentage"))+"&nbsp;</td></tr>");
						prevcode = currcode;
						i++;
						maxRecord++;
					//}
					//if(rs!=null)rs.close();
					//if(stmt!=null)stmt.close();
					
				}
				else
				{
						if(dailymonthly.equals("D"))
						{
							if(maxRecord==0)
							{
								thlegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels");
								out.println("<font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DailyBookingsByNursingUnit.label","ip_labels")+" :</b></font>");
								out.println("<tr><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th><th colspan=3 width='10%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;"+"</th><th colspan=3 width='10%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"&nbsp;"+"</th><th colspan=3 width='10%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"&nbsp;"+"</th><th colspan=3 width='10%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+"</th></tr>");
								out.println("<tr><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.available.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.available.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.available.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels")+"&nbsp;"+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.available.label","common_labels")+"&nbsp;"+"</th></tr>");
							}
					
					/*if(start > 1)
					{
						for(int k=0; k < start ;k++)
						rs.next();
					}
					
					int z=0;*/		
					//while(rs.next() && (z < records_to_show))
					//{
						z++;
						if(i%2 == 0)
							className = "QRYEVEN";
						else
							className = "QRYODD";
						
						String currcode = checkForNull(rs.getString("code"));
						String currdate = checkForNull(rs.getString("Pref_Date"));
						String currBed = checkForNull(rs.getString("BED_CLASS_SHORT_DESC"));

						String currdate_display = "";
							if(currdate == null)
								currdate_display = "";
							else
								currdate_display = DateUtils.convertDate(currdate,"DMY","en",locale);

						//out.println("<script>alert(\""+currdate_display+"\");</script>");
						//out.println("<script>alert(\"prevdate:"+prevdate+"\");</script>");
						//out.println("<script>alert(\"currdate:"+currdate+"\");</script>");
				
											
						if(!prevcode.equals(currcode))
						{
							out.println("<th colspan=13 align='left'>"+checkForNull(rs.getString("Short_desc"))+"</th></tr>");
							out.println("<tr><td colspan=13 class=CAGROUPHEADING> "+currBed+"</td></tr>");
						}
						else if(!prevBed.equals(currBed))
						{
							out.println("<tr><td colspan=13 class=CAGROUPHEADING> "+currBed+"</td></tr>");
						}
						if(!prevdate.equals(currdate))
						{
							out.println("<tr><td class='"+className+"' align=left>"+currdate_display+"</td>");
						}
						else
							{
								out.println("<tr><td class='"+className+"' align=right>&nbsp;</td>");
							}

						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Max_M"))+"</td>");
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Male"))+"</td>");
						
						String Avl_M = rs.getString("Avl_M");
						if (Avl_M==null) Avl_M = "0";
						int avlM = Integer.parseInt(Avl_M);
						if (avlM < 0) avlM = 0;
						out.println("<td class='"+className+"' align=right>"+avlM+"</td>");
						
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Max_F"))+"</td>");
						
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Female"))+"</td>");
						
						String Avl_F = rs.getString("Avl_F");
						if (Avl_F==null) Avl_F = "0";
						int avlF = Integer.parseInt(Avl_F);
						if (avlF < 0) avlF = 0;

						out.println("<td class='"+className+"' align=right>"+avlF+"</td>");
						
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Max_UK"))+"</td>");
						
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Unknown"))+"</td>");
						
						String Avl_UK = rs.getString("Avl_UK");
						if (Avl_UK==null) Avl_UK = "0";
						int avlUK = Integer.parseInt(Avl_UK);
						if (avlUK < 0) avlUK = 0;

						out.println("<td class='"+className+"' align=right>"+avlUK+"</td>");
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Max_T"))+"</td>");
						
						out.println("<td class='"+className+"' align=right>"+checkForNull(rs.getString("Total"))+"</td>");
						
						String Avl_T = rs.getString("Avl_T");
						if (Avl_T==null) Avl_T = "0";
						int avlT = Integer.parseInt(Avl_T);
						if (avlT < 0) avlT = 0;

						out.println("<td class='"+className+"' align=right>"+avlT+"</td></tr>");
						prevcode = currcode;
						//prevdate = currdate;
						prevBed  = currBed;
						maxRecord++;
					//}
					//if(rs!=null)rs.close();
					//if(stmt!=null)stmt.close();

					
				}
				else
				{

						if(maxRecord==0)
						{
							out.println("<font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MonthlyBookingsByNursingUnit.label","ip_labels")+" :</b></font>");
							out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"&nbsp;"+"</th><th width='10%' align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+"</th></tr>");
						}

						/*if(start > 1)
						{
							for(int k=0; k < start ;k++)
							rs.next();
						}
						int z=0;	*/	
						//while(rs.next() && (z < records_to_show))
						//{
							z++;
							if(i%2 == 0)
								className = "QRYEVEN";
							else
								className = "QRYODD";
						
							String currcode = checkForNull(rs.getString("code"));
							String currdate = checkForNull(rs.getString("display_date"));
							String currdate_display = "";
							if(currdate == null)
								currdate_display = "";
							else
								{
									currdate_display = DateUtils.convertDate(currdate,"MY","en",locale);
									/*if(dailymonthly.equals("D"))
									{
										currdate_display = DateUtils.convertDate(currdate_display,"DMY","en",locale);
									}
									else
									{
										
										currdate_display = DateUtils.convertDate(currdate_display,"MY","en",locale);
									}*/
								}

							

							if(!prevdate.equals(currdate))
							{
								out.println("<tr><td colspan=6 class=CAGROUPHEADING>"+currdate_display+"</td></tr>");
								out.println("<tr><th colspan=6   	align='left'>"+checkForNull(rs.getString("Short_desc"))+"</th></tr>");
							}
							else if(!prevcode.equals(currcode))
							{
								out.println("<tr><th colspan=6 align='left'>"+checkForNull(rs.getString("Short_desc"))+"</th></tr>");
							}

							out.println("<td class='"+className+"'>"+(rs.getString("BED_CLASS_SHORT_DESC")==null?"&nbsp;":rs.getString("BED_CLASS_SHORT_DESC"))+"</td>");
							out.println("<td class='"+className+"'  width='10%'align=right>"+checkForNull(rs.getString("Male"))+"</td>");
							out.println("<td class='"+className+"'  width='10%' align=right>"+rs.getString("Female")+"</td>");
							out.println("<td class='"+className+"'  width='10%'align=right>"+checkForNull(rs.getString("Unknown"))+"</td>");
							out.println("<td class='"+className+"' width='10%' align=right>"+checkForNull(rs.getString("Total"))+"</td></tr>");
							prevcode = currcode;
							//prevdate = currdate;
							i++;
							maxRecord++;
						//}
						//if(rs!=null)rs.close();
						//if(stmt!=null)stmt.close();
				}
			}
			}
			out.println("</table>");
				//}
			
				
			if ( maxRecord < 14 || (!rs.next()) )
				{
					
            _bw.write(_wl_block5Bytes, _wl_block5);
 
				}
				else
				{
            _bw.write(_wl_block6Bytes, _wl_block6);

				}
			if(maxRecord==0)
			{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();		
		}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
		finally
		{
			if(con !=null) ConnectionManager.returnConnection(con,request);
			//added on 20-10-2003 by dhanasekaran
			out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
