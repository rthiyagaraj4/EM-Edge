package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __orderentrycalendar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryCalendar.jsp", 1709119788000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t</link>\n \t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n \t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\"calendarForm\" id=\"calendarForm\" >\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table border=0 cellspacing=0 cellpadding=3 width=20% align=\'center\'>\n\t<br>\n\t<tr>\n\t\t<td class=\"white\" >&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"white\" width=\"10%\" ></td>\n\t\t<td class=\"white\" >\n\t\t\t<table cellspacing=0 cellpadding=3  width=\"25%\"  style=\"mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt\">\n\t\t\t\t<tr>\n\t\t\t\t    <td ><input type=\"button\" class=\"button\" value=\"<--\" name=\"prev\" id=\"prev\"  onClick=moveDirection(this,";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")></td>\n\t\t\t\t\t<td  class=\"COMMON_TOOLBAR\" width=\"10%\"><b><i>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</i></b></td>\n\t\t\t\t\t<td  ><input type=\"button\" class=\"button\" value=\"-->\" name=\"next\" onClick=moveDirection(this,";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\")></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"white\" width=\"5%\"></td>\n\t\t<td  class=\"white\">\n\t\t\t<table width=\"20%\"  cellpadding=3 align=\"center\" style=\"mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt\">\n\t\t\t<tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<th width=\"3%\" align=\"center\"><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t <tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<td class = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  width=\"3%\"><font size=1>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></font></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t  </tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</tr>\n\t\t</table>\n\t</td>\n\t</tr>\n</table>\n<br>\n\t<table border=\"0\" width=\"100%\" >\n\t\t<tr>\n\t\t\t<td width=\"7%\" align=\"left\" class=\"OAGREENSMALL\">&nbsp;</td>\n\t\t\t<td width=\"88%\" align=\"left\" class=\"OALABELSMALLWHITE\">&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"white\" colspan=\"2\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"white\" colspan=\"2\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"left\" class=\"OAREDSMALL\">&nbsp;</td>\n\t\t\t<td width=\"10%\"  class=\"OALABELSMALLWHITE\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"white\" colspan=\"2\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"white\" colspan=\"2\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"left\" class=\"OALABELSMALL\">&nbsp;</td>\n\t\t\t<td width=\"10%\"  class=\"OALABELSMALLWHITE\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t</tr>\n\t</table>\n\t<Input name=\'month_count\' id=\'month_count\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<Input name=\'year\' id=\'year\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<Input name=\'default_booking\' id=\'default_booking\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<Input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<Input name=\'active_bookings\' id=\'active_bookings\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<Input name=\'qry_string\' id=\'qry_string\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\n\t<script>\n\t\tloadDefaultDate(\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\")\n\t</script>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            eOR.OrderEntryCalendarBean beanCalendarObj= null;{
                beanCalendarObj=(eOR.OrderEntryCalendarBean)pageContext.getAttribute("beanCalendarObj");
                if(beanCalendarObj==null){
                    beanCalendarObj=new eOR.OrderEntryCalendarBean();
                    pageContext.setAttribute("beanCalendarObj",beanCalendarObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
      request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	beanCalendarObj.setLanguageId(localeName);


		int row						= 0;
		int rodup					= 1;
		int cols					= 7;
		int act						= 0;
		int total					= 0;
		int month_count				= 0;
		int active_bookings			= 0;
		String month_year_name		= "";
		String month				= "",  year					= "";
		String day					= "",  anchor				= "";
		String color_class			= "",  year_month 			= "";
		String calendar_string		= "",  color_string			= "";
		String current_date			= "",  booking_day			= "0";
		String default_booking		= "";
		String status				= request.getParameter("status");
		String state				= "current";
		if(request.getParameter("total")!=null)
			total					= Integer.parseInt(request.getParameter("total"));
		String patient_id					= request.getParameter("patient_id");
		String cliniccode			= request.getParameter("Clinic_Code");
		if( cliniccode == null ) cliniccode="";
		String performing_facility_id= request.getParameter("performing_facility_id");
		if( performing_facility_id == null ) performing_facility_id="";
		String practitioner_id		= request.getParameter("practitioner_id");
		if( practitioner_id == null ) practitioner_id="";
		if(status!=null && status.equals("NE"))
			state					= "next";
		else if(status!=null && status.equals("PR"))
			state					= "previous";
		if(0 >= total)
			state					= "current";
		StringTokenizer split_days	= null;
		StringTokenizer ColorVals	= null;
		String[] NumOfDays			= null;
		String colors[]				= null;
		String week[]				= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		String Color_Code[]			= {"S","Y","G","R","B"};
		String Color_Val[]			= {"","OAYellow","OAGreen","OARed","OABrown"};
		String months[]				= {"January&nbsp&nbsp&nbsp&nbsp&nbsp","February&nbsp&nbsp&nbsp","March&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","April&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","May&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","June&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","July&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","August&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp","September","October&nbsp&nbsp&nbsp&nbsp&nbsp","November&nbsp","December&nbsp"};

String ID="";
 			if(cliniccode==null)
				cliniccode		= ID;

			current_date		= beanCalendarObj.getSysDate();
			if(current_date!=null && !current_date.equals(""))
				current_date	= current_date.substring(0,2);
			else current_date	= "0";
			year_month			= beanCalendarObj.getYearMonth(state,total);
			calendar_string		= (String)beanCalendarObj.getCalendarString(year_month);
			color_string		= beanCalendarObj.getCalendarStatusColor(performing_facility_id, practitioner_id, year_month);
			if( color_string == null) color_string = "";
			year				= year_month.substring(0,4);
			month_count			= Integer.parseInt(year_month.substring(4,year_month.length()));
			month				= months[month_count-1];
			split_days			= new StringTokenizer(calendar_string,"|");
			NumOfDays			= new String[split_days.countTokens()];
			ColorVals			= new StringTokenizer(color_string,"|");
			colors				= new String[ColorVals.countTokens()];

			//active_bookings		= beanCalendarObj.getActiveBookings(patient_id); // will return an Integer

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]	= split_days.nextToken();

			for(int i=0;i<colors.length;i++)
			{
				colors[i]		= ColorVals.nextToken();
			}

			row					= NumOfDays.length/7;
			month_year_name		= month+","+year;
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(total));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(month_year_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(total));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
				for( int j=0;j<week.length;j++){	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(week[j]));
            _bw.write(_wl_block17Bytes, _wl_block17);
				} 
            _bw.write(_wl_block18Bytes, _wl_block18);
			for( int j=0;j<row;j++)
			{

            _bw.write(_wl_block19Bytes, _wl_block19);

				for(int k=0;k<cols;k++)
				{
					if(act<NumOfDays.length)
				  	{
				  		if(!NumOfDays[act].equals("0"))
				  		{
				  			day	=	NumOfDays[act];
			  				for(int i=0;i<Color_Code.length;i++)
			  				{
			  					if(Color_Code[i].equals(colors[act]))
			  						color_class = Color_Val[i];
			  				}
							booking_day = day;
			  			} // End of if !NumOfDays[act].equals("0")
			  			else
			  			{
			  				if(rodup==(NumOfDays.length/7) && NumOfDays[act].equals("0"))
			  				{
			  					day = "&nbsp"; booking_day = "0";
			  					break;
			  				}
			  				else
							{
								day = "&nbsp"; booking_day = "0";
							}
				  		} // End of else !NumOfDays[act].equals("0")
				  	}
					else
					{
						day			= "&nbsp";
						booking_day = "0";
					}
		  			act++;
					anchor = " ";
//String DispBk	= "Y";
		  			if(!(color_class==null || color_class.equals("") ) )
					{
						if( default_booking.equals("") && Integer.parseInt(booking_day) >= Integer.parseInt(current_date))
							default_booking = day;
						//active_bookings		= beanCalendarObj.getActiveBookings(performing_facility_id,practitioner_id,(day + "/" + month_count + "/" + year),patient_id); // will return an Integer
						active_bookings		= beanCalendarObj.getActiveBookings(performing_facility_id,practitioner_id,(day + "/" + month_count + "/" + year)); // will return an Integer
                        anchor =" <a class='gridLink' href=javascript:populateDate('"+month_count+"','"+year+"','"+day+"','"+patient_id+"','"+active_bookings+"') >";
					}
			  			//anchor =" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+month_count+"','"+year+"','"+day+"','"+DispBk+"')>";

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(color_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(anchor));
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);

				  		color_class = "";
				  	} // End of for k --> cols

            _bw.write(_wl_block23Bytes, _wl_block23);
				rodup++;
			} // End of for j --> row

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(month_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(year));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(default_booking));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(active_bookings));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(month_count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(year));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(default_booking));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(active_bookings));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.available.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Holiday.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notavailable.label", java.lang.String .class,"key"));
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
}
