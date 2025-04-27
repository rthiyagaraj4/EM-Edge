package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmipautotrackouttoopdmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIPAutoTrackOutToOPDMain.jsp", 1733717171202L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIPAutoTrackOutToOPD.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onLoad=\"document.AutoTrackToOPD_Form.iss_locn_code.focus();\" onKeyDown = \'lockKey();\'>\n<form name=\'AutoTrackToOPD_Form\' id=\'AutoTrackToOPD_Form\' action=\'../../servlet/eFM.FMAutoTrackOutToIPWServlet\' method=\'post\' target=\'messageFrame\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<td colspan=\'4\' class=\'columnheader\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<select name=\'iss_locn_code\' id=\'iss_locn_code\' onBlur=\'refresh(this.value);\' tabindex=1>\n\t\t\t<option value=\'\'>------ ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="------</option> \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=text size=30 maxlength=60 name=\'issue_user_name\' id=\'issue_user_name\' readonly value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><input type=hidden size=40 maxlength=30 name=\'issue_user\' id=\'issue_user\' readonly value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'><input type=button name=searchcode value=\'?\' class=button tabindex=2 onClick=\"searchCode(issue_user,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',issue_user_name)\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'from_nursing_unit\' id=\'from_nursing_unit\' maxlength=\'4\' size=\'4\' value=\'\' tabindex=3 onBlur=\"ChangeUpperCase(this);if(this.value != \'\'){search(from_nursing_unit,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');}\" onKeyPress=\'return CheckForSpecChars(event)\' ><input type=\'button\' class=\'button\' name=\'nursing_unit1\' id=\'nursing_unit1\' value=\'?\' onClick=\"search(from_nursing_unit,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\">\n\t\t\t</td>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'to_nursing_unit\' id=\'to_nursing_unit\' maxlength=\'4\' size=\'4\' value=\'\' tabindex=4 onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\"ChangeUpperCase(this);if(this.value != \'\'){search(to_nursing_unit,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');}\" ><input type=\'button\' class=\'button\' name=\'nursing_unit2\' id=\'nursing_unit2\' value=\'?\' onClick=\"search(to_nursing_unit,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\">\n\t\t\t</td>\n       </tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' id=\'autoopddate\' name=\'preferred_date\' id=\'preferred_date\' maxlength=\'10\' size=\'10\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' tabindex=5 onBlur=\'if(validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\")){ValidateOPDDate(this,\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");}\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'autoopddate\');\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'print_card\' id=\'print_card\' value=\'N\' onClick=\"EnableDisableCheck(this)\" tabindex=6>\n\t\t\t</td>\n       </tr>\n\t\t<tr>\n\t\t<td class=\'button\' align=\"right\" colspan=\'4\'>\n\t\t<input type=\'button\' class=\'button\' name=\'trackout\' id=\'trackout\' value=\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  \' tabindex=7 onClick=\"TrackoutFiles();\">\n\t\t</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<table>\n<input type=\'hidden\' name=\'iss_locn_iden\' id=\'iss_locn_iden\' value=\'\'>\n<input type=\'hidden\' name=\'iss_locn_mryn\' id=\'iss_locn_mryn\' value=\'\'>\n\n<script>\n\tif(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" == 1)\n\t{\n\t\tparent.frames[1].document.forms[0].iss_locn_code.options(1).selected = true;\n\t}\n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity  = request.getParameter("userSecurity")==null?"N":request.getParameter("userSecurity");
		String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		Statement stmt=null;
		ResultSet rs=null;
		String sql = "";			

		String curr_date = "";		
		String syDate = "";	
		String attButtStatus = "";
		String issue_user_name="";
		String curr_date_old = "";		
		String syDate_old = "";	
		String value="";
		
		int x = 0;

	try
	{
		
		value =(String)session.getAttribute("issue_user_name");
		syDate_old =(String)session.getAttribute("syDate");
		curr_date_old =(String)session.getAttribute("curr_date");
		
		if(value==null || value.equals("null")) value="";
		if(syDate_old==null || syDate_old.equals("null")) syDate_old="";
		if(curr_date_old==null || curr_date_old.equals("null")) curr_date_old="";
	
		if(value.equals("") || syDate_old.equals("") || curr_date_old.equals(""))
		{
		stmt =conn.createStatement();			
		
		//rs = stmt.executeQuery("Select appl_user_name,to_char(SYSDATE+1,'DD/MM/YYYY') SYDATE,to_char(SYSDATE,'DD/MM/YYYY') curdate from sm_appl_user where appl_user_id = '"+user_id+"' ");

		
		rs = stmt.executeQuery("Select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = '"+user_id+"' AND LANGUAGE_ID='"+localeName+"'");
		if(rs.next())
		{
			issue_user_name = rs.getString(1);		
		}

		//syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		if(rs!=null)	rs.close();
		//if(stmt!=null) stmt.close(); 


		rs = stmt.executeQuery("Select to_char(sysdate+nvl(NO_DAYS_CHECK_BOOK_INQUIRY,0), 'dd/mm/YYYY') SYDATE, to_char(SYSDATE,'DD/MM/YYYY') curdate from fm_parameter where facility_id = '"+facility_id+"'");
		if(rs.next())
		{		
			syDate = rs.getString(1);
			curr_date = rs.getString(2);
		}

		syDate=DateUtils.convertDate(syDate,"DMY","en",localeName);
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		} else{

     syDate=syDate_old;
    curr_date=curr_date_old;
	issue_user_name	=value;
   }
	
	
	/*	if(userSecurity.equals("Y"))
		{		
			attButtStatus = "disabled";			

			if (access_all.equals("*ALL"))
			{
				sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y' order by 2";
			}
			else
			{
				sql=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' AND TRACK_OUT_TO_OPD = 'Y' AND PERMANENT_FILE_AREA_YN = 'Y' order by 2";
			}
		}
		else
		{
			sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y'  order by 2";
		}*/
		//sql=" Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_STORAGE_LOCN where FACILITY_ID = '"+facility_id+"'  and EFF_STATUS = 'E' and PERMANENT_FILE_AREA_YN = 'Y'  order by 2";
		sql = "SELECT"
			  +"  FS_LOCN_CODE"
			  +"  ,fm_Get_desc.Fm_storage_locn(FACILITY_ID,FS_LOCN_CODE,'"+localeName+"',2) SHORT_DESC"
			  +"  , LOCN_IDENTITY"
			  +"  , MR_LOCN_YN "
			  +"FROM"
			  +"  FM_STORAGE_LOCN "
			  +"WHERE FACILITY_ID = '"+facility_id+"' "
			  +"  AND EFF_STATUS = 'E' "
			 // +"  AND LANGUAGE_ID='"+localeName+"'"
			  +"  AND PERMANENT_FILE_AREA_YN = 'Y' "
			  +"ORDER BY 2";

		if(userSecurity.equals("Y"))
		{		
			attButtStatus = "disabled";			

			if (!access_all.equals("*ALL"))
			{
				//sql=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY, MR_LOCN_YN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' AND TRACK_OUT_TO_OPD = 'Y' AND PERMANENT_FILE_AREA_YN = 'Y' order by 2";
				/*sql = "SELECT"
						  +"  A.FS_LOCN_CODE"
						  +"  , ("
						  +"  CASE "
						  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
						  +"  THEN"
						  +"    '*ALL' "
						  +"  ELSE B.SHORT_DESC "
						  +"  END) FS_LOCN_SHORT_DESC"
						  +"  , A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"
						  +"  , FM_STORAGE_LOCN_LANG_VW B "
						  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
						  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
						  +"  AND A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";*/


						  sql = "SELECT"
						  +"  A.FS_LOCN_CODE,"
						  +"  DECODE"
						  +"  (a.fs_locn_code,"
						  +"   '*ALL', '*ALL',"
						  +"  fm_get_desc.fm_storage_locn(a.facility_id, "
						  +"   a.fs_locn_code, "
						  +" '"+localeName+"', "
						  +"  '2') ) fs_locn_short_desc, "
						  +"   A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"  FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"			
						  +"  WHERE A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";

			}
		}
	
		

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null)
			{
			   while(rs.next())
			   {
					x++;
					String ID	= rs.getString(1);
					String desc	= rs.getString(2);
				//	String Iden	= rs.getString(3);
				//	String mrlocn = rs.getString(4);

					out.println("<option value='"+ID+"'>"+desc+"</option>");
			   }
			   if(rs!=null)	rs.close();
			}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(issue_user_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(attButtStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(syDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_date));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackOut.label","fm_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);

	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{					
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(x));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.AutoTrackouttoIPW.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TrackedoutBy.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromNursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ToNursingUnit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.PrintTracerCard.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
