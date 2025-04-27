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

public final class __generateworkscheduleresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/GenerateWorkScheduleResult.jsp", 1709121633137L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /**\n\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\t\n*\tModified By\t\t:\tSuresh.S\n*\tModified On\t\t:\t14 December 2004.\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/GenerateWorkSchedule.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<script>\n\t\t\tparent.frameGenWrkSchHdr.document.location.href=\"../../eCommon/html/blank.html\"\n\t\t\tparent.frameset_GenerateWorkSchedule.rows=\'100%,0%,0%\';\n\t\t\t</script>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'form_GenWrkSchResult\' id=\'form_GenWrkSchResult\' action=\'../../servlet/eRS.GenerateWorkScheduleServlet\' method=\'POST\' target=\'messageFrame\'> \n<table cellpadding=0 cellspacing=0 border=1 align=center width=\"100%\" id=\'\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<tr>\n\t\t\t\t<td  colspan=\'6\' align=left  valign=\'top\' class=\'CAGROUPHEADING\' width=\'20%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>&nbsp;<input type=\'hidden\' name=position_code";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></td>\n\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'20%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<input type=\'hidden\' name=staffID";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'30%\' name=staffname";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'11%\' name=\'\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<input type=\'hidden\' name=frm_dt";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n\t\t<input type=\'hidden\' name=to_dt";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<td  Align=\'center\' class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  width=\'8%\'>&nbsp;&nbsp;<input type=checkbox name=\'select";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'select";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  value=\'\'  onclick=\'invokeChk(this)\'></td>\n\t\t<input type=\'hidden\' name=staff_type";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=role_type";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<input type=\'hidden\' name=totalrecs value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=facility_id value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=wrkplace_code value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=frm_dt value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=to_dt value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=locn_type value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n</table>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</body>\t\n</form>\n</html>\n\n \n \n  \n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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

request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

     request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	ArrayList ResultData	= new ArrayList();

	String facility_id		= request.getParameter("facility_id");
	String locn_type		= request.getParameter("locn_type");
	String wrkplace_code	= request.getParameter("wrkplace_code");
	String role_type		= request.getParameter("role_type");
	String position_code	= request.getParameter("position_code");
	String staff_type		= request.getParameter("staff_type");
	String staff_id			= request.getParameter("staff_id");
	String frm_dt			= request.getParameter("frm_dt");
	String to_dt			= request.getParameter("to_dt");

//out.println("=================facility_id->"+facility_id+"wrkplace_code--"+wrkplace_code+"role_type--"+role_type+"staff_id---"+staff_id+"position_code--->"+position_code+"frm_dt--->"+frm_dt);

	String slClassValue		 ="";
	String Sql				 ="";
	String[] record			 =null;
	String chk_position_flag ="";

	if(facility_id == null || facility_id.equals("null")) facility_id =" "; else facility_id = facility_id.trim();
	if(locn_type == null || locn_type.equals("null")) locn_type =" "; else locn_type = locn_type.trim();
	if(wrkplace_code == null || wrkplace_code.equals("null")) wrkplace_code =" "; else wrkplace_code = wrkplace_code.trim();
	if(role_type == null || role_type.equals("null")) role_type =" "; else role_type = role_type.trim();
	if(frm_dt == null || frm_dt.equals("null")) frm_dt =" "; else frm_dt = frm_dt.trim();
	if(to_dt == null || to_dt.equals("null")) to_dt =" "; else to_dt = to_dt.trim();
	if(position_code == null || position_code.equals("null")) position_code =" "; else position_code = position_code.trim();
	if(staff_type == null || staff_type.equals("null")) staff_type =" "; else staff_type = staff_type.trim();
	if(staff_id == null || staff_id.equals("null")) staff_id =" "; else staff_id = staff_id.trim();

	try{
		
		Con=ConnectionManager.getConnection(request);

		//Sql="SELECT b.position_code position_code,c.position_desc position_desc,b.staff_type staff_type,a.role_type role_type,a.staff_id staff_id,b.staff_name staff_name, TO_CHAR(a.eff_date_from,'dd/mm/yyyy') eff_date_from,TO_CHAR(a.eff_date_to,'dd/mm/yyyy') eff_date_to FROM rs_staff_for_workplace a, am_staff_vw b , am_position c WHERE a.facility_id = ? AND a.workplace_code = ? AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?) AND (a.role_type,a.staff_id) IN (SELECT role_type,staff_id FROM rs_master_schedule WHERE facility_id = ? AND workplace_code = ? AND requirement_id IN (SELECT requirement_id FROM rs_workplace_requirement WHERE facility_id = ? AND workplace_code = ? AND ( ( requirement_type = 'C' and requirement_date_fm IS NULL AND requirement_date_to IS NULL) OR  (requirement_type = 'V' and requirement_date_to > SYSDATE))) AND (? IS NULL OR role_type = ?) AND (? IS NULL OR staff_id = ?) AND (? IS NULL OR position_code = ?))  AND ( a.eff_date_to is null or a.eff_date_to >= to_date(?,'dd/mm/yyyy') ) AND b.role_type = a.role_type AND b.staff_id = a.staff_id AND c.position_code = b.position_code ORDER BY c.position_desc,b.staff_name";
		
		Sql="SELECT b.position_code position_code,c.position_desc position_desc,b.staff_type staff_type,a.role_type role_type,a.staff_id staff_id,b.staff_name staff_name, TO_CHAR(a.eff_date_from,'dd/mm/yyyy') eff_date_from,TO_CHAR(a.eff_date_to,'dd/mm/yyyy') eff_date_to FROM rs_staff_for_workplace a, am_staff_vw b , am_position_lang_vw c WHERE a.facility_id = ? AND a.workplace_code = ? AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?) AND (a.role_type,a.staff_id) IN (SELECT role_type,staff_id FROM rs_master_schedule WHERE facility_id = ? AND workplace_code = ? AND requirement_id IN (SELECT requirement_id FROM rs_workplace_requirement WHERE facility_id = ? AND workplace_code = ? AND ( ( requirement_type = 'C' and requirement_date_fm IS NULL AND requirement_date_to IS NULL) OR  (requirement_type = 'V' and requirement_date_to > SYSDATE))) AND (? IS NULL OR role_type = ?) AND (? IS NULL OR staff_id = ?) AND (? IS NULL OR position_code = ?))  AND ( a.eff_date_to is null or a.eff_date_to >= to_date(?,'dd/mm/yyyy') ) AND b.role_type = a.role_type AND b.staff_id = a.staff_id AND c.position_code = b.position_code and b.language_id = ? and c.language_id = b.language_id ORDER BY c.position_desc,b.staff_name";
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,role_type);
		pstmt.setString(4,role_type);
		pstmt.setString(5,staff_id);
		pstmt.setString(6,staff_id);
		pstmt.setString(7,facility_id);
		pstmt.setString(8,wrkplace_code);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,wrkplace_code);
		pstmt.setString(11,role_type);
		pstmt.setString(12,role_type);
		pstmt.setString(13,staff_id);
		pstmt.setString(14,staff_id);
		pstmt.setString(15,position_code);
		pstmt.setString(16,position_code);
		pstmt.setString(17,frm_dt);
		pstmt.setString(18,locale);

		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[8];
			record[0]			=rslRst.getString("position_code");
			record[1]			=rslRst.getString("position_desc");
			record[2]			=rslRst.getString("staff_type");
			record[3]			=rslRst.getString("role_type");
			record[4]			=rslRst.getString("staff_id");
			record[5]			=rslRst.getString("staff_name");
			record[6]			=rslRst.getString("eff_date_from");
			record[7]			=rslRst.getString("eff_date_to");

			ResultData.add(record) ;
		}


		
		if(ResultData.size()<= 0){
			{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); location.href='../../eCommon/html/blank.html' </script>");		
		 }

            _bw.write(_wl_block9Bytes, _wl_block9);

	for( int i=0 ; i<ResultData.size(); i++ ) {
		if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}

		String[] record1 = (String[])ResultData.get(i);
		String posi_code = record1[0]==null?"":record1[0];
		String posi_desc = record1[1]==null?"":record1[1];
		String stafftype    = record1[2]==null?"":record1[2];
		String roletype     = record1[3]==null?"":record1[3];
		String staffid      = record1[4]==null?"":record1[4];
		String staffname    = record1[5]==null?"":record1[5];
		String eff_date_from = record1[6]==null?"":record1[6];
		String eff_date_to   = record1[7]==null?"":record1[7];

		posi_code = posi_code.trim();
		posi_desc = posi_desc.trim();
		stafftype = stafftype.trim();
		roletype = roletype.trim();
		staffid = staffid.trim();
		staffname = staffname.trim();
		eff_date_from = eff_date_from.trim();
		eff_date_to = eff_date_to.trim();

		if((chk_position_flag.equals("")) || !(chk_position_flag.equals(posi_desc))){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(posi_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

			chk_position_flag=posi_desc;
		}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(posi_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(staffid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(staffid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(staffname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(eff_date_from,"DMY","en",locale)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eff_date_from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(eff_date_to,"DMY","en",locale)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eff_date_to));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stafftype));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(roletype));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ResultData.size()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wrkplace_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block37Bytes, _wl_block37);

	}catch(Exception e){
			out.println("Exception in try of GenerateWrkSchedule.jsp : "+e);
	}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}

            _bw.write(_wl_block38Bytes, _wl_block38);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
