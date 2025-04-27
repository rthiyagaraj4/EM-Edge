package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyholidayresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/addmodifyHolidayResult.jsp", 1742298592373L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tSuman\n\tCreated on \t:\t19/04/2006\n\tModule\t\t:\tOA   \n-->\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eOA/js/Holiday.js\' language=\'javascript\'></SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'Holiday_result2_FORM\' id=\'Holiday_result2_FORM\' action=\'\' method=\'post\'  target=\'\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<table width=\'80%\' border=0 align=\'center\' >\n\t\t<tr>\n\t\t<td align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</td>\t\n\t </tr>\n\t\t</table>\n\n\n\t\t\t<div id=\'header\' style=\"visibility:visible;backgroundColor:white;overflow:scroll\">\n\t\t\t\t<table border=\"1\" width=\"80%\" bgColor=white align=\'center\' cellspacing=\'0\' cellpadding=\'0\' id=\'result_locn1\'>\n\t\t\t\t<th class=\'COLUMNHEADER\'  width=\'31%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t<th class=\'COLUMNHEADER\'  width=\'30%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t\t<th class=\'COLUMNHEADER\'  width=\'20%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t\t</table></div>\n\t\t\t\t<table border=\"1\" width=\"80%\" align=\'center\' bgColor=white cellspacing=\'0\' cellpadding=\'0\' id=\'result_locn2\'>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t<tr>\n\t     \t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" width=\'38%\'  nowrap align=\'left\' > ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;&nbsp;</td>\n\t\t\t\t<input type=\'hidden\' name=\'clinic_code1";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'clinic_code1";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  width=\'37%\' nowrap align=\'left\' > ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;</td>\n\t\t\t    <input type=\'hidden\' name=\'holiday_date";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'holiday_date";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" nowrap align=center>\n\t\t\t\t<input type=checkbox ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="   name=\'select_yn";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'18%\'\tOnclick=\"change_val1(this,";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =",\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \"><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'removeCode";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\"\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'Code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"><input type=\'hidden\' name=\'val";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'val";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><input type=\'hidden\' name=\'sch_exists";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'sch_exists";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\"\"></td>\n            </tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<!-- modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338] -->\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));//history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t</table>\n\t<input type=\'hidden\' name=\'holiday_date_from\' id=\'holiday_date_from\'  value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\'hidden\' name=\'holiday_date_to\' id=\'holiday_date_to\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t<input type=\'hidden\' name=\'reason_for_holiday\' id=\'reason_for_holiday\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insertlocntype\'>\n\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet holidayval= null;synchronized(session){
                holidayval=(webbeans.eCommon.RecordSet)pageContext.getAttribute("holidayval",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(holidayval==null){
                    holidayval=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("holidayval",holidayval,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
String locale			= (String)session.getAttribute("LOCALE");

Connection con =null;
Statement stmt=null;
ResultSet rSet=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
String holiday_date_from_greg="";
String holiday_date_to_greg="";
String facilityId = (String) session.getValue( "facility_id" ) ;
String holiday_date_from=request.getParameter("holiday_date_from")==null?"":request.getParameter("holiday_date_from");
String holiday_date_to=request.getParameter("holiday_date_to")==null?"":request.getParameter("holiday_date_to");
if(holiday_date_to =="") holiday_date_to=holiday_date_from;

holiday_date_from_greg=DateUtils.convertDate(holiday_date_from,"DMY",locale,"en");
holiday_date_to_greg=DateUtils.convertDate(holiday_date_to,"DMY",locale,"en");

String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
String reason_for_holiday=request.getParameter("reason_for_holiday")==null?"":request.getParameter("reason_for_holiday");
String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;


int start = 0 ;
int end = 0 ;
int maxrecord=0;
int s=0;
StringBuffer sql1 = new StringBuffer();
StringBuffer sql2 = new StringBuffer();
StringBuffer sql1_chk2 = new StringBuffer();
String sql_two="";
String clinic_desc="";
String holiday_date_to_create="";
String holiday_date_to_create_disp="";
String class_value	= "QRYEVEN";
String req_start    =   "", req_end     =   "";
String checkedOnes="";

req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
String removeCode		= "";
	

	String flagSelect = request.getParameter("flagSelect");
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;



try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

	if(location_type.equals("D")){
				sql1_chk2.append(" and a.clinic_type='Y' ");
			}else{
				sql1_chk2.append(" and a.clinic_type='"+location_type+"' ");
			}

		if(!clinic_code.equals("")){
				sql1_chk2.append(" and a.clinic_code='"+clinic_code+"'");
			}



		//sql1_chk2.append("order by holiday_date,a.long_desc ");
	
	
		if(flagSelect !=null)
		{
			
			holidayval.clearAll();
			
			
		}
		String checkedOnes1="";
		//String checkedOnes2="";

		if(from != null && to != null)
		{
			 int j=0;
			 
			 for( s=(Integer.parseInt(req_start)); s<=(Integer.parseInt(req_end)); s++)
			 {
				 
				 if(request.getParameter("select_yn"+(s)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(s));
					 checkedOnes1 = request.getParameter("val"+(s));
					
					
					 if(!(holidayval.containsObject(checkedOnes1)))
						 holidayval.putObject(checkedOnes1);
						 j++;
				 }
				
				removeCode = checkForNull(request.getParameter("removeCode"+(s)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(s));
					if((holidayval.containsObject(Code)))
					{
						int removeCodeIndex = holidayval.indexOfObject(Code);
							holidayval.removeObject(removeCodeIndex);
					}
				}
			 }

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+s+"'>");
		 }
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		sql1.append("select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date,b.holiday_date holiday_date1 from op_clinic_lang_vw a ,(select to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_date_to_greg+"','dd/mm/yyyy')-to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and  not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code AND holiday_date = b.holiday_date )");
		sql1.append(sql1_chk2);
		sql2.append("minus select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date,b.holiday_date holiday_date1 from op_clinic_lang_vw a ,(select to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_date_to_greg+"','dd/mm/yyyy')-to_date('"+holiday_date_from_greg+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and  not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code )");
		sql2.append(sql1_chk2);

			sql_two =(sql1.append(sql2.toString())).toString()+" ORDER BY 4,2";
			//out.println("sql_two ExHoliday ==>"+sql_two);
			rSet = stmt.executeQuery(sql_two);
	
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);

				s=1;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rSet.next() ;
				}

				String clinic_code1="";
				String chkAttribute="";
				String val2="";

			if(rSet !=null)
			{
				while ( s<=end && rSet.next() )
				{
					if(maxrecord==0)
					{
		
            _bw.write(_wl_block14Bytes, _wl_block14);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
	//	if ( !((start+10) > maxrecord ))
			{
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 }
			
					clinic_desc=rSet.getString("clinic_desc");
					clinic_code1=rSet.getString("clinic_code");
					holiday_date_to_create=rSet.getString("holiday_date");

					int sch_cnt = 0;
					String flag_val="";
					//String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_date = to_date('"+holiday_date_to_create+"','dd/mm/yyyy') and care_locn_type_ind='"+location_type+"' and clinic_code = '"+clinic_code1+"'";
					String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = ? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and clinic_code = ? ";
					pstmt=con.prepareStatement(sqlstr);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,holiday_date_to_create);
					pstmt.setString(3,location_type);
					pstmt.setString(4,clinic_code1);
					rs=pstmt.executeQuery();
					if (rs!=null && rs.next()){
						
						sch_cnt=rs.getInt("cnt");
						
					}
			if (sch_cnt >0) 
				{
				flag_val="S";
				}else
				{
				flag_val="N";
				}
					holiday_date_to_create_disp=DateUtils.convertDate(holiday_date_to_create,"DMY","en",locale);

					
					val2=clinic_code1+"|"+holiday_date_to_create+"|"+flag_val;

					if(holidayval.containsObject(val2))  
						chkAttribute = "CHECKED";
					else
						chkAttribute="";

					int recordIndex = holidayval.indexOfObject(val2);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED"))    
					holidayval.removeObject(recordIndex);	

					if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";	
					else
					class_value = "QRYEVEN";

					

					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(s));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(s));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(holiday_date_to_create_disp));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(s));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(s));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(holiday_date_to_create));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(holiday_date_to_create));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(s));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(s));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(flag_val));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(s));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(s));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(s));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(s));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(s));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(s));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(s));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(s));
            _bw.write(_wl_block50Bytes, _wl_block50);

					s++;
					maxrecord++;
				}//end of while
			}

	if(maxrecord == 0)
	{
            _bw.write(_wl_block51Bytes, _wl_block51);
}

	if ( maxrecord < 10 || (!rSet.next()) ) {
	
            _bw.write(_wl_block52Bytes, _wl_block52);
 
			} else {
            _bw.write(_wl_block53Bytes, _wl_block53);
}

	
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(holiday_date_from_greg));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(holiday_date_to_greg));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(reason_for_holiday));
            _bw.write(_wl_block59Bytes, _wl_block59);

	// modified by N Munisekhar on 19-April-2013 against ML-BRU-SCF-0802[IN:039338]
	   if(rs !=null) rs.close();
	   if(pstmt !=null) pstmt.close();
	   if(rSet !=null) rSet.close();
	   if(stmt !=null) stmt.close();
		

	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}finally
	{
		 ConnectionManager.returnConnection(con,request);
		session.setAttribute("holidayval", holidayval);

	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
