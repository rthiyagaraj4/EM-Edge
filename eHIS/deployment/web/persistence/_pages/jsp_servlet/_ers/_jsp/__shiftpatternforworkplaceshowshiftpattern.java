package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __shiftpatternforworkplaceshowshiftpattern extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ShiftPatternForWorkplaceShowShiftPattern.jsp", 1709121654636L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../js/ShiftPatternForWorkplace.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t\t<form name=\'form_listShiftPattern\' id=\'form_listShiftPattern\' action=\'../../servlet/eRS.ShiftPatternForWorkplaceServlet\' method=\'POST\' target=\'messageFrame\'>\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\"90%\">\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<th align=\'center\' width=\'50\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<input type=\'checkbox\' name=selectall value=\"\" onclick=\'return click_selectall(form_name);\'></th>\n\t\t\t\t\t<th  align=\'left\' width=\'40%\'>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th align=\'left\' width=\'65\'>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</th>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<th>&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>-</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t</tr><tr ><td align=\'center\' class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" name=\'select_yn";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ></td>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'shift_pattern_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'shift_pattern_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'db_action";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td> \n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</tr></table>\n\t\t\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\'  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'form_name\' id=\'form_name\'  value=\'form_listShiftPattern\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t</form>\n\t\t\t</body>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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

/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String mode	  = request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");
	String locn_type=request.getParameter( "locn_type" )==null?"":request.getParameter("locn_type");
	String workplace_code=request.getParameter( "workplace_code" )== null?"":request.getParameter("workplace_code");

	int week_count = Integer.parseInt((String)request.getParameter("week_count")==null?"0":(String)request.getParameter("week_count"));
	int totalDays=week_count*7, row_count=0;
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList ShiftPattern_Data		= new ArrayList();
	ArrayList Week_Days		=new ArrayList();
	String[] record				= null;
	String Shift_pattern_id="", classval="";

	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,1) ) day_of_week from sm_day_of_week order by day_no";
	//String sql_shift_pattern="select   a.locn_type, d.short_desc locn_desc, c.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'U' db_action, c.eff_status enabled from rs_shift_pattern_for_workplace c, rs_shift_pattern a, rs_shift_pattern_dtl b, am_care_locn_type d where c.facility_id =? and c.workplace_code = ? and a.facility_id = c.facility_id and a.shift_pattern_id = c.shift_pattern_id and b.facility_id = a.facility_id and b.shift_pattern_id = a.shift_pattern_id and d.locn_type = a.locn_type and b.week_no <= ? union all select   a.locn_type, c.short_desc locn_desc, a.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'I' db_action, 'E' enabled from rs_shift_pattern a,         rs_shift_pattern_dtl b, am_care_locn_type c where a.facility_id = ? and ((a.locn_type is null) or (a.locn_type = nvl((select locn_type from rs_workplace where workplace_code = ?),a.locn_type))) and a.eff_status = 'E' and b.facility_id = a.facility_id and b.week_no <= ? and b.shift_pattern_id = a.shift_pattern_id and (a.facility_id, a.shift_pattern_id) not in ( select facility_id, shift_pattern_id from rs_shift_pattern_for_workplace where facility_id = ? and workplace_code = ?) and c.locn_type(+) = a.locn_type order by locn_type, short_desc, week_no, day_no";
	String sql_shift_pattern="select   a.locn_type, d.short_desc locn_desc, c.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'U' db_action, c.eff_status enabled from rs_shift_pattern_for_workplace c, rs_shift_pattern_lang_vw a, rs_shift_pattern_dtl b, am_care_locn_type_lang_vw d where c.facility_id =? and c.workplace_code = ? and a.facility_id = c.facility_id and a.shift_pattern_id = c.shift_pattern_id and b.facility_id = a.facility_id and b.shift_pattern_id = a.shift_pattern_id and d.locn_type = a.locn_type and b.week_no <= ? and a.language_id = ? and d.language_id = a.language_id union all select   a.locn_type, c.short_desc locn_desc, a.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'I' db_action, 'E' enabled from rs_shift_pattern_lang_vw a,         rs_shift_pattern_dtl b, am_care_locn_type_lang_vw c where a.facility_id = ? and ((a.locn_type is null) or (a.locn_type = nvl((select locn_type from rs_workplace where workplace_code = ?),a.locn_type))) and a.eff_status = 'E' and b.facility_id = a.facility_id and b.week_no <= ? and b.shift_pattern_id = a.shift_pattern_id and (a.facility_id, a.shift_pattern_id) not in ( select facility_id, shift_pattern_id from rs_shift_pattern_for_workplace where facility_id = ? and workplace_code = ?) and a.language_id = ? and c.locn_type(+) = a.locn_type and c.language_id(+) = a.language_id  order by locn_type, short_desc, week_no, day_no";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the Shift Pattern Details
		pstmt = conn.prepareStatement( sql_shift_pattern);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,String.valueOf(week_count));
		pstmt.setString(4,locale);
		pstmt.setString(5,facility_id);
		pstmt.setString(6,workplace_code);
		pstmt.setString(7,String.valueOf(week_count));
		pstmt.setString(8,facility_id);
		pstmt.setString(9,workplace_code);
		pstmt.setString(10,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[10];				
			record[0] = resultSet.getString("locn_type")==null?"":resultSet.getString("locn_type");
			record[1] = resultSet.getString("locn_desc")==null?"":resultSet.getString("locn_desc");
			record[2] = resultSet.getString("shift_pattern_id")==null?"":resultSet.getString("shift_pattern_id");
			record[3] = resultSet.getString("short_desc")==null?"":resultSet.getString("short_desc");
			record[4] = resultSet.getString("week_no")==null?"":resultSet.getString("week_no");
			record[5] = resultSet.getString("day_no")==null?"":resultSet.getString("day_no");
			record[6] = resultSet.getString("shift_code")==null?"":resultSet.getString("shift_code");
			record[7] = resultSet.getString("shift_mnemonic")==null?"":resultSet.getString("shift_mnemonic");
			record[8] = resultSet.getString("db_action")==null?"":resultSet.getString("db_action");
			record[9] = resultSet.getString("enabled")==null?"":resultSet.getString("enabled");
			ShiftPattern_Data.add(record) ;
		}

		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		//to get the week days legend
		pstmt = conn.prepareStatement( sql_week_days);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("day_of_week");
			Week_Days.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		int totalRecords=ShiftPattern_Data.size();
		if( totalRecords== 0){
			//out.println("<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); location.href='../../eCommon/html/blank.html' </script>");
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					for(int i=0;i<week_count;i++){
						for(int j=0; j<Week_Days.size();j++){
							record=(String[])Week_Days.get(j);

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
					}
					int j=0,count=0,count1=0;
					String locn_type1="";
					for(int i=0; i<ShiftPattern_Data.size();i++){
						record=(String[])ShiftPattern_Data.get(i);
						if(!(Shift_pattern_id.equals(record[2]))){
							if(!(locn_type1.equalsIgnoreCase(record[1]))){
								locn_type=record[1];
								if(locn_type.equals("") )
									locn_type1="General";
								else 
									locn_type1=locn_type;
							}
							else
								locn_type1="";

							Shift_pattern_id=record[2];
							String select="";
							String enable=record[9]==null?"":record[9];
							if((record[8].equals("U"))&&(enable.equals("E")))
								select="checked";

							if((count1>0)&&(count1<totalDays)){
								while(count1<totalDays){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
									count1++;
								}
							}	
							count1=0;
							count=0;
							if(row_count %2 == 0)
								classval="QRYEVEN";
							else
								classval="QRYODD";
							row_count++;

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(select));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(j));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Shift_pattern_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j++));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block29Bytes, _wl_block29);

						}
						count=((Integer.parseInt(record[4])-1)*7+(Integer.parseInt(record[5])-1))-count1;
						if(count <0)
							count=count*(-1);
						for(int k=0; k<count;k++){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block32Bytes, _wl_block32);

						count1=((Integer.parseInt(record[4])-1)*7+(Integer.parseInt(record[5])));
						locn_type1=record[1];
					}
					if(count1>0){
						while(count1<totalDays){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);

							count1++;
						}
						count1=0;
					}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet != null)
			resultSet.close();
		pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Pattern.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
