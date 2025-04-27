package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainhomepageschedules extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainHomePageSchedules.jsp", 1741273854151L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<style>\n<!--\np.MsoNormal, li.MsoNormal, div.MsoNormal\n\t{mso-style-parent:\"\";\n\tmargin:0in;\n\tmargin-bottom:.0001pt;\n\tmso-pagination:widow-orphan;\n\tfont-size:12.0pt;\n\tfont-family:\"Times New Roman\";\n\tmso-fareast-font-family:\"Times New Roman\";}\n@page Section1\n\t{size:8.5in 11.0in;\n\tmargin:1.0in 1.25in 1.0in 1.25in;\n\tmso-header-margin:.5in;\n\tmso-footer-margin:.5in;\n\tmso-paper-source:0;}\ndiv.Section1\n\t{page:Section1;}\n-->\n</style>\n<style>\nTD.DISPDATE {\n  FONT-FACE: verdana ;\n  FONT-SIZE: 8pt ;\n  BACKGROUND-COLOR: #FED6B1;\n  COLOR:blue;\n}\nTD.DISPHOLIDAY {\n  FONT-FACE: verdana ;\n  FONT-SIZE: 8pt ;\n  BACKGROUND-COLOR: #CFCFCF;\n  COLOR:black;\n}\n</style>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n\t<SCRIPT>\n\n\t\tfunction fun(){}\n\t\t\n\t\tfunction callDisplayOAResultsblock(date)\n\t\t{\n         alert(getMessage(\"SCHEDULE_BLOCK\")+\" \" +date);\n\t\t}\n\t\tfunction nextMonth(Totnum)\n\t\t{\n\t\t\t\t//parent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tTotnum=Totnum+1\n\t\t\t\tvar param=\"../../eCA/jsp/CAMainHomePageSchedules.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&i_clinic_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&i_appt_ref_no=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&i_appt_date=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&alcn_criteria=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patient_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&tfr_appt_across_catg_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&status=P1&TotNum=\"+Totnum\n\t\t\t\tself.location.href=param\n\t\t\t\t\t//&callingMode=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t}\n\n\t\tfunction previousMonth(Totnum)\n\t\t{\n\t\t\tif(Totnum>0)\n\t\t\t{\n\t\t\t\t//parent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tTotnum=Totnum-1;\n\t\t\t\tvar param=\"../../eCA/jsp/CAmainHomePageSchedules.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&status=M1&TotNum=\"+Totnum\n\t\t\t\tself.location.href=param\n\t\t\t\t\t//&callingMode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t}\n\t\t}\n\n\t\tfunction rfresh(obj)\n\t\t{\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&i_clinic_code=\"+obj.value\n\t\t\t\tself.location.href=param\n\t\t\t\t\t//&callingMode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t}\n\n\t\tfunction change_schedule(obj){\n\t\t\n\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&i_clinic_code=\"+obj.value+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&over_booked=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&alcn_criteria=\"+document.forms[0].alcn_criteria.value;\n\t\tself.location.href=param\n\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t//&callingMode=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t}\n\n\n\t\tfunction callDisplayOAResultsForOp(clinic, mon, yr,dt)\n\t\t{\n\t\t\t\n\t\t\tif(mon.length==1)\n\t\t\t\t\tmon=\"0\"+mon\n\t\t\tif(dt.length==1)\n\t\t\t\t\tdt=\"0\"+dt\n\t\t\tvar dt=dt+\"/\"+mon+\"/\"+yr;\n\t\t\tvar i_appt_ref_no=document.forms[0].apptrefno.value;\n\t\t\tvar i_clinic_code=document.forms[0].clinic_code.value;\n\t\t\tvar i_practitioner_id=document.forms[0].practitioner_id.value;\n\t\t\tvar i_appt_date=document.forms[0].old_date.value;\n\t\t\tvar new_appt_date=dt;\n\t\t\tvar old_alcn_catg_code=document.forms[0].old_alcn_catg_code.value;\n\t\t\tvar alcn_criteria=document.forms[0].alcn_criteria.value;\n\t\t\t//alert(\'here  :\'+alcn_criteria);\n\t\t\tvar tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;\n\t\t\tvar over_booked=document.forms[0].over_booked.value;\n\t\t\t//alert(\"over_booked  :\"+over_booked);\n\t\t\t//alert(\"tfr_appt_across_catg_yn  :\"+tfr_appt_across_catg_yn);\n\t\t\tvar ca_mode=\'ca_mode\';\n\t\t\tvar ca_patient_id=document.forms[0].ca_patient_id.value;\n\t\t\tvar callingMode=document.forms[0].callingMode.value;\n\t\t\t\n\t\t\tvar param=\"../../eOA/jsp/SinglePractVw.jsp?tfr_appt_across_catg_yn=\"+tfr_appt_across_catg_yn+\"&old_alcn_catg_code=\"+old_alcn_catg_code+\"&alcn_criteria=\"+alcn_criteria+\"&i_appt_ref_no=\"+i_appt_ref_no+\"&clinic_code=\"+i_clinic_code+\"&practitioner_id=\"+i_practitioner_id+\"&over_booked=\"+over_booked+\"&callingMode=\"+callingMode+\"&old_date=\"+i_appt_date+\"&Date=\"+new_appt_date+\"&ca_patient_id=\"+ca_patient_id+\"&ca_mode=\"+ca_mode;\n\t\t\t//alert(parent.frames[1].name);\n\t\t\tparent.frames[1].location.href=param;\n\n\n\n\t\t}\n\t</SCRIPT>\n\t</head>\n\n\t<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n\t<b><font color=\'red\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></b>\n\n\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t<form>\n\n\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t\t</table>\n\t\t\t<!-- <table border=0 cellspacing=0 cellpadding=0 width=\'50%\'>\t\n\t\t\t<tr><td class=\'label\' colspan=\'2\'></td></tr><tr><td class=\'label\' colspan=\'2\'></td></tr><tr><td class=\'label\' colspan=\'2\'></td></tr><tr><td class=\'label\' colspan=\'2\'></td></tr>\n\t\t\t<tr><td class=\'white\'>&nbsp;</td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\n\n\t\t\t</table> -->\n\t\t\t<table  align=\'center\' border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t<tr><td class=\'white\' width=\'25%\'>\n\t\t\t<table  align=\'center\' border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t<tr >\n\t\t\t\t<td  width=\'50%\' class=\'white\' >\n\t\t\t\t<table cellspacing=0 cellpadding=0  width=\'100%\' style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt\' border=\'0\'>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"<---\" name=\'prev\' id=\'prev\'  onclick=previousMonth(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")></td>\n\t\t\t\t\t\t<td align=\'center\' class=\"DISPDATE\" width=\'140%\'><font size=3><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b></font></td>\n\t\t\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"--->\" name=\'next\' onclick=nextMonth(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =")></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'callingMode\' id=\'callingMode\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >\n\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >\n\t\t\t<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_alcn_catg_code\' id=\'old_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t\t\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\t\t\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\n\t\t\t</form>\n\t\t<tr>\n\t\t<table width=\'21%\'  align=\'center\' cellpadding=0  style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt \'>\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td class=\'columnHeader\'  width=\'3%\' align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t  <tr>\n\t\t\t\t  \t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t  \t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' align=\'center\' width=\'3%\'><font \tsize=2>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a></td>\n\t\t\t\t\t  \t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' align=\'center\' width=\'3%\'><font size=2>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></td>\n\t\t\t\t  \t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t  \t\t\t<td align=\'center\' width=\'3%\'><font size=2>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t  </tr>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t</tr>\n\n\t\t</table>\n\t\t</td><td class=\'white\' id=\'detail\' width=\'75%\'  rowspan=9 height=\'100%\'>\n\t\t\t<table  align=\'left\' border=1 cellspacing=0 cellpadding=0 width=\'100%\' height=\'100%\'>\n\t\t\t\t<tr><td class=\'QRYEVEN\' align=center><b>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</b></td></tr>\n\t\t\t\t<tr><td  class=\'QRYODD\' align=center><b>IP Bookings</b></td></tr>\n\t\t\t\t<tr><td  class=\'QRYEVEN\' align=center><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b></td></tr>\n\t\t\t</table>\n\t\t</td></tr></table>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
 int TotNum=0;

			public String getCalendarString(Connection con,String arg,HttpServletResponse res) throws java.io.IOException
			{
				
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				PrintWriter out = res.getWriter();
				try
				{
					
		   			
					sql="select get_calendar_string(?) from dual";
					stmt=con.prepareStatement(sql);
					stmt.setString(1,arg);
					rs=stmt.executeQuery();
					if(rs.next())
					RetString=rs.getString(1);
					//out.print(RetString);
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					
					//out.println("Execption in CAMainHomePageSchedules.jsp"+e.toString());//COMMON-ICN-0181
                                           e.printStackTrace();//COMMON-ICN-0181
				}
				

				return RetString;
			}
	

			public String getCalanderStatusColor(String Facility_Id, String Clinic_Code, String Practitioner_Id, Connection con,String arg)
			{
				PreparedStatement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				
				try
				{
		   			
					sql="SELECT GET_CALENDAR_STATUS_COLOR (?,?,?,?) FROM DUAL";
//		   			
					stmt=con.prepareStatement(sql);
					stmt.setString(1,Facility_Id);
					stmt.setString(2,Clinic_Code);
					stmt.setString(3,Practitioner_Id);
					stmt.setString(4,arg);
					rs=stmt.executeQuery();
					if(rs.next())
						RetString=rs.getString(1);
					
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
				}
				
				return RetString;
			}
	


		public String getYearMonth(String state,int TotNum)
		{
			Calendar cal=Calendar.getInstance();
			int current=cal.get(Calendar.MONTH);

			String arg="";
			String mont="";
			if(state.equals("previous"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);

				if(cal.get(Calendar.MONTH)>=current)
					state="current";
			}

			if(state.equals("current"))
			{
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(state.equals("next"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(mont.length()==1)
					mont=0+mont;
				arg=arg+mont;

			//if(back_diary !=null && back_diary.equals("back_diary"))
			//arg=lat_arg;
			return arg;
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);


	//String s=request.getQueryString();
	
	String ca_patient_id=request.getParameter("patient_id");
	
	if(ca_patient_id==null) ca_patient_id="";
	String Practitioner_Id=request.getParameter("i_practitioner_id");
	String clinic_code=request.getParameter("location_code");
	if (clinic_code==null)
	clinic_code=request.getParameter("i_clinic_code");
	String practitioner_id=(String)session.getValue("ca_practitioner_id");
	if(practitioner_id == null) practitioner_id = Practitioner_Id;
	if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
	String apptrefno=request.getParameter("i_appt_ref_no");
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	apptrefno = "";
	old_date = "";
//	fid = "";

	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
tfr_appt_across_catg_yn="";
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	alcn_criteria="";
	String old_alcn_catg_code="";
	String practitioner_name="";
	String overbookedyn=request.getParameter("over_booked");
	String callingMode = request.getParameter("callingMode");
	if(callingMode == null) callingMode="";
	overbookedyn ="Y";

	if(Practitioner_Id==null || Practitioner_Id.equals("null"))Practitioner_Id="";
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	
	

	
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			//Connection con=(Connection) session.getValue("connection");
			Connection con = ConnectionManager.getConnection();
			PreparedStatement stmt=null;
			
 			ResultSet rs=null;
			int coi=0;
			String week[]=new String[7];
			String day_type[]=new String[7];
			try{
			String sql_week="select substr(DAY_OF_WEEK,1,3),DAY_TYPE,DAY_NO from sm_day_of_week order by DAY_NO";
				stmt=con.prepareStatement(sql_week);
				rs=stmt.executeQuery();
					if(rs!=null){
					 while(rs.next())
					{
					  week[coi]=rs.getString(1);
					  day_type[coi]=rs.getString(2);
					  coi++;
					}
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception es){
			//out.println("Exec@4"+es);//COMMON-ICN-0181
                          es.printStackTrace();//COMMON-ICN-0181
			}
			String Color_Code[]={"S","Y","G","R","B","H"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			String cliniccode=request.getParameter("location_code");
			if (cliniccode==null)
			cliniccode=request.getParameter("i_clinic_code");

			String colorclass="";
			String status=request.getParameter("status");
			String state="current";
			
			if(status!=null)
			{
				if(status.equals("P1"))
					state="next";
				if(status.equals("M1"))
					state="previous";
			}
			
			
			
			try
			{
				
				if(request.getParameter("TotNum")!=null){
				TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}
				else{	
				int curr_month=0;
				String sql_date="select to_char(sysdate,'mm'),to_char(sysdate,'dd/mm/yyyy')from dual";
				stmt=con.prepareStatement(sql_date);
				rs=stmt.executeQuery();
					if(rs.next()){
					curr_month=rs.getInt(1);
					old_date=rs.getString(2);
					}
				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(old_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
						mon_date=mon;}
						count++;
				}
				int month_of_year=Integer.parseInt(mon_date);
				TotNum=month_of_year-curr_month;	

				}

				if(TotNum==0)
				{
				state="current";
				}
				else
				{
					if(TotNum > 0)
					{
					   state="next";
					}
				}

				
				
			}
			catch(Exception e)
			{
				//out.println("Exception");
			//	out.println("Exeception in CAMainHomePageSchedules.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181

			}
			
			
			//out.print(state);
			String arg=getYearMonth(state,TotNum);

			
			String CalString=(String)getCalendarString(con,arg,response);
			

			String ColorString=getCalanderStatusColor(fid,cliniccode,Practitioner_Id,con,arg);

			String yr=arg.substring(0,4);
			//int cal_yr=Integer.parseInt(yr);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			//int cal_mon=mon;
			//int cal_day=0;
			String month=months[mon-1];

			StringTokenizer splitdays=new StringTokenizer(CalString,"|");
			String[] NumOfDays=new String[splitdays.countTokens()];

			StringTokenizer ColVals=new StringTokenizer(ColorString,"|");
			String colors[]=new String[ColVals.countTokens()];

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]=splitdays.nextToken();
			for(int i=0;i<colors.length;i++)
				colors[i]=ColVals.nextToken();

				int ro=NumOfDays.length/7;
				int rodup=1;
				int ccols=7;
				String dat="";
				int act=0;
			
            _bw.write(_wl_block28Bytes, _wl_block28);

 			try
 			{	if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			
				String pract_str="select practitioner_name from am_practitioner where  practitioner_id= ? "; 
				stmt=con.prepareStatement(pract_str);
				stmt.setString(1,practitioner_id);
				rs = stmt.executeQuery();
				if(rs !=null){
					while ( rs.next() )
						{
							practitioner_name= rs.getString("practitioner_name");
						}
				}
							

				if(practitioner_name==null) practitioner_name="";			
			


            _bw.write(_wl_block29Bytes, _wl_block29);

				String my=month+","+yr;
				
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(my));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(old_alcn_catg_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
for( int j=0;j<week.length;j++){
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(week[j]));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
for( int j=0;j<ro;j++)
			{
			
			
            _bw.write(_wl_block47Bytes, _wl_block47);


				  	for(int k=0;k<ccols;k++)
				  	{
						if(day_type[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						if(act<NumOfDays.length)
				  		{
				  			if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
								//cal_day=Integer.parseInt(NumOfDays[act]);

				  				for(int i=0;i<Color_Code.length;i++)
				  				{
											
				  					if(Color_Code[i].equals(colors[act]))
				  						colorclass=Color_Val[i];					
								
				  				}
				  			}
				  			else
				  			{
				  				if(rodup==(NumOfDays.length/7) && 	NumOfDays[act].equals("0"))
				  				{
				  					
				  					dat="&nbsp";
				  					break;
				  				}
				  				else{
				  					dat="&nbsp";
									
								}

				  			}
				  		}
				  		else{
				  			dat="&nbsp";
						}
						
				  			String anch=" ";
							String title=dat+"/"+mon+"/"+yr;
				  			act++;
							//		out.println("<script language=javascript>alert('')</script>");
				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
										out.println("<script language=javascript></script>");
							if (colorclass.equals("OARed"))
							{
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";
									out.println("<script language=javascript>alert('1')</script>");
							}
							else
							{
								anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"') title='"+title+"'  >";
										out.println("<script language=javascript>alert('2')</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
							}
							}
				  
					if(allow_click)
					{
						if(colorclass.equals("OAHOLIDAY"))
						{
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
					else
						{
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
					}
					else
					{
					if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY"))
							{
							
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block52Bytes, _wl_block52);

							}
							else							
							{
							
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block52Bytes, _wl_block52);

						}
						}
						else
						{
							
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block52Bytes, _wl_block52);

				  		}
					}
					colorclass="";	  	
						
					
					}

				  	
            _bw.write(_wl_block54Bytes, _wl_block54);
rodup++;
			}
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
		if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			}
		catch(Exception e)
		{
			//out.println("ERROR@2"+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
						
					
		}
			
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MySchedules.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OPBookings.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OTBookings.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
