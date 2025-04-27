package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifynursingunitbkglt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyNursingUnitBkgLt.jsp", 1718774792538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../js/NursingUnitBkgLt.js\' language=\'javascript\'></script>\n\n\n<script language=\"JavaScript\">\n       \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\'FocusFirstElement();first()\' onunload=\'last()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=NursingUnitBkgLt_form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    <table width=\'90%\' border=0 cellspacing=0 cellpadding=0 align=center>\n        \n        <th colspan=6>  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </th>\n    <tr>\n\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n        <th >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n    </tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    <tr>\n        <td align=left class=label>&nbsp;&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n        <td align=\'center\'><input type=\"text\" size=\'6\' maxlength=\'6\' id=\'M";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' name=\'M";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"   onKeyPress=\'return(ChkNumInput(this,event,2))\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onBlur=\"if(checkNum(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'))bookingLimitChk(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\" ></td>\n                                                                               \n        <td align=\'center\'><input type=\"text\" size=\'6\' maxlength=\'6\' id=\'F";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' name=\'F";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onKeyPress=\'return(ChkNumInput(this,event,2))\'  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\" ></td>\n                                                                               \n        <td align=\'center\'><input type=\'text\' size=\'6\' maxlength=\'6\' id=\'U";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' name=\'U";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onBlur=\"if(checkNum(this,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\"  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onKeyPress=\'return(ChkNumInput(this,event,2))\' ></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<td align=\'center\'><input type=\"text\" size=\'6\' maxlength=\'6\' name=\'M";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'M";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" ></td>\n        <td align=\'center\'><input type=\"text\" size=\'6\' maxlength=\'6\' name=\'F";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'F";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\" ></td>\n        <td align=\'center\'><input type=\'text\' size=\'6\' maxlength=\'6\' name=\'U";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'U";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n        <td align=\'center\'><input type=\'text\' name=\'T";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'T";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' size=\'6\' maxlength=\'6\'  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onKeyPress=\'return(ChkNumInput(this,event,2))\'  readOnly></td>\n\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n        <td align=center><input type=checkbox name=\'S";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'S";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=E ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" onclick=\'enableText(this);\'></td>\n\t\t <input type=\'hidden\' name=\'B";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'B";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\n    </tr>\n\t<!-- added on 27-11-2003 by dhanasekaran -->\n\t<tr>\n\t<td>\n\t<input type=\'hidden\' name=\'bedclassdesc\' id=\'bedclassdesc\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t</td>\n\t</tr>\n\n    ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n    </table>\n        <input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n        <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n        <input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n    </form>\n    ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);

//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
    Connection con                  =   null;
    Statement stmt                  =   null;
    PreparedStatement pstmt         =   null;
    ResultSet rset                  =   null;
	Statement stmt_gender			=   null;
	ResultSet rs_gender				=   null;

	String facility_id = (String)session.getAttribute("facility_id");
    String nursing_unit_code=request.getParameter("nursing_unit_code");
    
	String max_male_dly_booking_readOnly="";
	String max_female_dly_booking_readOnly="";
	String max_unknown_dly_booking_readOnly="";
	String max_total_dly_booking_readOnly="";

	int i=0;        

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    String fnval    = "insert";
    String bedclassdesc     = "";
    String bedclasscode     = "";

    String eff_status="";
    String eff_status_checked="";
    String eff_status_disabled="";

    int maxmaledlybooking       ;
    int maxunknowndlybooking        ;
    int maxfemaledlybooking ;
    int maxtotaldlybooking      ;

    String maxm = "";
    String maxf = "";
    String maxu = "";
    String maxt = "0";

    int start=1;
    int end=0;
    int records_to_show=12;
    int total_count=0;

    String from = request.getParameter("from");
    String to = request.getParameter("to");
    try{
            con  =  ConnectionManager.getConnection(request);
			// Gender Changes
			String gender="";
            StringBuffer sql_gender = new StringBuffer();
			sql_gender.append(" select gender from am_age_group where age_group_code=(select age_group_code from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"') ");	
			stmt_gender=con.createStatement();
			rs_gender=stmt_gender.executeQuery(sql_gender.toString());
			if(rs_gender!=null)
			{
				while(rs_gender.next())
				{
					gender=rs_gender.getString(1);
					if(gender==null) gender="";
				}
				if(rs_gender!=null) rs_gender.close();
				if(stmt_gender!=null) stmt_gender.close();
			}
	if(gender.equals("M"))
            {
                max_male_dly_booking_readOnly = "";
                max_female_dly_booking_readOnly = "readonly";
                max_unknown_dly_booking_readOnly = "readonly";
                max_total_dly_booking_readOnly = "readonly";
            }
	else if(gender.equals("F"))
            {
                max_male_dly_booking_readOnly = "readonly";
                max_female_dly_booking_readOnly = "";
                max_unknown_dly_booking_readOnly = "readonly";
                max_total_dly_booking_readOnly = "readonly";
             }
	else if(gender.equals("U"))
            {
                max_male_dly_booking_readOnly = "readonly";
                max_female_dly_booking_readOnly = "readonly";
                max_unknown_dly_booking_readOnly = "";
                max_total_dly_booking_readOnly = "readonly";
             }
            else 
            {
                  max_male_dly_booking_readOnly = "";
                    max_female_dly_booking_readOnly = "";
                    max_unknown_dly_booking_readOnly = "";
                    max_total_dly_booking_readOnly = "readonly";
             }

            stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
            if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" select bed_class_code, bed_class_short_desc short_desc,");
			sql.append(" max_male_dly_booking, max_female_dly_booking, ");
			sql.append(" max_unknown_dly_booking, max_total_dly_booking, 'Y' ");
			sql.append(" from ip_book_limit_by_nurs_ut_vw where facility_id='"+facility_id+"' ");
			sql.append(" and nursing_unit_code='"+nursing_unit_code+"' ");
			sql.append(" union ");
			sql.append(" select bed_class_code,short_desc,0,0,0,0,'N' from  ");
			sql.append(" ip_bed_class where eff_status='E' and bed_class_code not in ");
			sql.append(" (select bed_class_code from ip_book_limit_by_nurs_ut_vw  ");
			sql.append(" where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"') ");
			sql.append(" order by 2 ");
            rset=stmt.executeQuery(sql.toString());
            if(rset!=null)
            {
                while(rset.next())
                {
                    total_count++;
                }
				if(rset!=null) rset.close();
            }
        if ( from == null )
         {
                    start = 0 ;
         }
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;
/*
try
{
	out.println("<p><table align='right'><tr><td>");    
	if ( !(start <= 0) )
	{
		out.println("<A HREF='../jsp/addModifyNursingUnitBkgLt.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&nursing_unit_code="+nursing_unit_code+"'>Previous</A>");
	}
	if (!((start+records_to_show) >= total_count ) )
	{
		out.println("<A HREF='../jsp/addModifyNursingUnitBkgLt.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&nursing_unit_code="+nursing_unit_code+"'>Next</A>");   
	}
	out.println("</td><td class=BODYCOLORFILLED>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr></table></p>");
	out.println("<br><br>");

}catch(Exception e) 
{
	//out.println("EEE"+e);
	e.printStackTrace();
}
*/

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

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
            _bw.write(_wl_block11Bytes, _wl_block11);

            rset=stmt.executeQuery(sql.toString());

         if(start > 1)
                {
                    for(int k=0; k < start ;k++)
                        rset.next();
                }

            int z=0;
            int id=0;

                while(rset.next())// && ( z < records_to_show) )
                {
                    z++;
               
                    id=i+start;// Naming the elements in the loop
                    
                    bedclasscode                    = rset.getString("bed_class_code");
                    bedclassdesc                    = rset.getString("short_desc");
                    maxmaledlybooking       = rset.getInt("max_male_dly_booking");
                    maxfemaledlybooking = rset.getInt("max_female_dly_booking");
                    maxunknowndlybooking  =rset.getInt("max_unknown_dly_booking");
                    maxtotaldlybooking      = rset.getInt("max_total_dly_booking");

	//out.println("<script>alert(\"maxtotaldlybooking ="+maxtotaldlybooking+"\")</script>");

                    eff_status=rset.getString(7);
                    if(eff_status==null) eff_status="N";

                    if(eff_status.equals("Y")) 
                    {
                      eff_status_checked="checked";
                    }
                    else if(eff_status.equals("N")) 
                    {
                     eff_status_checked="";
                     eff_status_disabled="";
                    }
                    
                    if(maxmaledlybooking == 0)
                        maxm = "";
                    else
                        maxm = Integer.toString(maxmaledlybooking);

                    if(maxfemaledlybooking == 0)
                        maxf = "";
                    else
                        maxf = Integer.toString(maxfemaledlybooking);

                    if(maxtotaldlybooking == 0)
                        maxt = "";
                    else
                        maxt = Integer.toString(maxtotaldlybooking);
                  
                    if(maxunknowndlybooking == 0)
                        maxu = "";
                    else
                        maxu = Integer.toString(maxunknowndlybooking); 
                
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bedclassdesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

		 if(eff_status.equals("Y")) 					
		{
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(maxm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(max_male_dly_booking_readOnly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(maxf));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(max_female_dly_booking_readOnly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(maxu));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(max_unknown_dly_booking_readOnly));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		else
		{
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(maxm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(max_male_dly_booking_readOnly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(maxf));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(max_female_dly_booking_readOnly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(maxu));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(max_unknown_dly_booking_readOnly));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(maxt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(max_total_dly_booking_readOnly));
            _bw.write(_wl_block39Bytes, _wl_block39);

		if(maxt.equals("")){
		eff_status_checked="unchecked";
		eff_status_disabled="";

	}
		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(eff_status_checked));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(eff_status_disabled));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bedclassdesc));
            _bw.write(_wl_block48Bytes, _wl_block48);

            i++;
        }

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block52Bytes, _wl_block52);

    if(fnval == "modify")
        out.print("<script>getGender()</script>");
    
	    if(rset     != null)   rset.close();
		if(stmt_gender != null) stmt_gender.close();
		if(rs_gender  != null) rs_gender.close();        
        if(stmt   != null)   stmt.close();
        if(pstmt != null)   pstmt.close();

	}catch(Exception e){
        //out.print("Exception :"+e);
		e.printStackTrace();
    }
    finally 
	{
        ConnectionManager.returnConnection(con,request);
    }
     
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxDailyBookingLimit.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
