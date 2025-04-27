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

public final class __addmodifytransferclinicschdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/addmodifyTransferClinicSchDetail.jsp", 1728625445253L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eOA/js/TransferClinicSch.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\' onload=\'clrval();\' >\n<form name=\'TCSchDetail_form\' id=\'TCSchDetail_form\' action=\'../../servlet/eOA.TransferClinicSchServlet\' method=\'post\' target=\'messageFrame\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n     \t\t\n\t\t   <table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'95%\'>\n\t\t   <td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t   <td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" / ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' align=middle>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t\t<a href=javascript:show_modwin(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\') alt=\'Appointment Details\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' align=middle>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><input type=\'checkbox\' name=\'sel_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'sel_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\'\' checked >\n\t\t\t<input type=\'hidden\' name=\'vals_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'vals_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="|";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' > <input type=\'hidden\' name=\'vals1_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'vals1_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t\t</td></tr>\n\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\n\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\'\' checked ></td></tr>\n\t\t<input type=\'hidden\' name=\'vals_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t\t<input type=\'hidden\' name=\'vals1_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'checkbox\' name=\'sel_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' value=\'\' checked > <input type=\'hidden\' name=\'vals_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\n\t\t\t</td></tr>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\n\t<script>parent.frames[1].document.forms[0].generaterep.disabled = false;</script>\n\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t<script>parent.frames[1].document.forms[0].generaterep.disabled = true;sch_exits();</script>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>parent.frames[1].document.forms[0].generaterep.disabled = true;no_sch();</script>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script>parent.frames[1].document.forms[0].generaterep.disabled = true;sch_exits1();</script>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<input type=\'hidden\' name=\'no_of_rec\' id=\'no_of_rec\'  value= \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n<input type=\'hidden\' name=\'final_vals\' id=\'final_vals\'  value= \'\' >\n<input type=\'hidden\' name=\'final_vals1\' id=\'final_vals1\'  value= \'\' >\n<input type=\'hidden\' name=\'sel_rec\' id=\'sel_rec\'  value= \'\' >\n<input type=\'hidden\' name=\'eff_from\' id=\'eff_from\'  value= \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n<input type=\'hidden\' name=\'eff_to\' id=\'eff_to\'  value= \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n<input type=\'hidden\' name=\'reason\' id=\'reason\'  value= \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n<input type=\'hidden\' name=\'date_day\' id=\'date_day\'  value= \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n<input type=\'hidden\' name=\'cur_day_no\' id=\'cur_day_no\'  value= \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n<input type=\'hidden\' name=\'trans_day_no\' id=\'trans_day_no\'  value= \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n<input type=\'hidden\' name=\'locncode\' id=\'locncode\'  value= \'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n<input type=\'hidden\' name=\'practid\' id=\'practid\'  value= \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >\n<input type=\'hidden\' name=\'fromday\' id=\'fromday\'  value= \'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >\t\t\n<input type=\'hidden\' name=\'P_To_Day_No\' id=\'P_To_Day_No\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'></input>\n<input type=\'hidden\' name=\'genrep\' id=\'genrep\'  value= \'\' >\n<input type=\'hidden\' name=\'primary_yn\' id=\'primary_yn\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\'noofappts\' id=\'noofappts\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"   value=\"OA\"></input>\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"   value=\"OAAFAPLST\"></input>\n<input type=\"hidden\" name=\"P_Facility_id\" id=\"P_Facility_id\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'></input>\n<input type=\"hidden\" name=\"noofappts\" id=\"noofappts\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'></input>\n<input type=\"hidden\" name=\"locnType\" id=\"locnType\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type=\"hidden\" name=\"resType\" id=\"resType\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\n<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n<input type=\'hidden\' name=\'other_remarks\' id=\'other_remarks\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
//	HashMap hash = new HashMap();

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String efffrom =request.getParameter("eff_from");
	String effto =request.getParameter("eff_to");
	String fromday =request.getParameter("from_day");
	String today =request.getParameter("to_day");
	String dateday = request.getParameter("date_day");
	String practid = request.getParameter("pract_id");
	String ref_val=request.getParameter("ref_val");
	String primary_yn = "";
   String locale=(String)session.getAttribute("LOCALE");

   efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	effto=DateUtils.convertDate(effto,"DMY",locale,"en");

	if(practid == null || practid =="")
		practid="";

	String locncode = request.getParameter("locn_code");
	String reason = request.getParameter("reason");
	String locnType=request.getParameter("locnType")==null?"":request.getParameter("locnType");
	String resType= request.getParameter("resType")==null?"":request.getParameter("resType");
	String transdate = "",transday = "",currdate = "",currday = "",noofappts = "",sql = "",sql1 = "",tday = "",curdayno="",transdayno = "",sql_1="",transday1="";
	int k=0;
	String classValue="",practname="",pract="",pract1="",care_locn_type_ind="",resource_class="",resource_class_desc="",sel_res_pos="",cntval="";
	String flag="F";
	String flag1="Y";
	String chk= "F";
	String chk1= "F";
	String currdate_disp="";
	String transdate_disp="";
	int dateval = 0;
	
	

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_remarks = request.getParameter("other_remarks")==null?"":request.getParameter("other_remarks");
	

            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con=null;
PreparedStatement pstmt=null;
Statement stmt = null,stmt1 = null,stmt4 = null,stmt2 = null,stmt3 = null;
ResultSet rset = null,rset1 = null,rset2 = null,rset4 = null,rset5= null,rset6= null;


try{
	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	stmt2=con.createStatement();
	stmt3=con.createStatement();

if(dateday.equals("A"))
{
	flag1="Y";
}else
{
flag1="N";
}
	
	

	if(dateday.equals("A") && ref_val.equals(""))
	{

		/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
		//sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date('"+effto+"','dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+efffrom+"','dd/mm/yyyy') and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and  nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+effto+"','dd/mm/yyyy')) ";
		
		/*Below query modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
	//	sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date('"+effto+"','dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+efffrom+"','dd/mm/yyyy') and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and  nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X')) and CLINIC_DATE = to_date('"+effto+"','dd/mm/yyyy')) AND (eff_status != 'D' OR eff_status IS NULL)";
		sql1 = " SELECT to_char(CLINIC_DATE,'dd/mm/yyyy') CURRENT_DATE, initcap(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, care_locn_type_ind, resource_class, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, to_char(to_date(?,'dd/mm/yyyy'),'Day') d FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = ? and CLINIC_CODE = ? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X')) and CLINIC_DATE = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and resource_class=? AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ? and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and  nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X')) and CLINIC_DATE = to_date(?,'dd/mm/yyyy')) AND (eff_status != 'D' OR eff_status IS NULL)";
		
		//sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date('"+efffrom+"','dd/mm/yyyy')  " ;
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ? and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date(?,'dd/mm/yyyy')  " ;
		
		//sql_1 = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date('"+effto+"','dd/mm/yyyy')  " ;
		sql_1 = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ?  and CLINIC_CODE = ? and care_locn_type_ind= ? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and CLINIC_DATE  = to_date(?,'dd/mm/yyyy')  " ;

		//rset=stmt.executeQuery(sql1);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,effto);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,locncode);
		pstmt.setString(8,practid);
		pstmt.setString(9,efffrom);
		pstmt.setString(10,locnType);
		pstmt.setString(11,resType);
		pstmt.setString(12,facilityId);
		pstmt.setString(13,locncode);
		pstmt.setString(14,locnType);
		pstmt.setString(15,resType);
		pstmt.setString(16,practid);
		pstmt.setString(17,effto);
		rset = pstmt.executeQuery();
		if(rset.next())
		{
			flag = "T";
		}else
		{
			flag = "F";


			//rset5=stmt.executeQuery(sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,efffrom);
			rset5 = pstmt.executeQuery(); 
			if(rset5.next())
			{
				chk1= "T";
			}
			if(rset5 !=null) rset5.close();

			//rset6=stmt.executeQuery(sql_1);
			pstmt = con.prepareStatement(sql_1);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,effto);
			rset6 = pstmt.executeQuery(); 
			
			

			if(chk1=="T" && rset6.next())
			{
				chk= "T";
			}
			if(rset6 !=null) rset6.close();

		}

		if(rset !=null) rset.close();

	}else if(flag1.equals("N") && ref_val.equals("false")){
       
	    /* Below query was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		
		//sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and UPPER(RTRIM(TO_CHAR( CLINIC_DATE,'Day')))= RTRIM('"+fromday+"')  and CLINIC_DATE  between to_date('"+efffrom+"','dd/mm/yyyy')  and to_date('"+effto+"','dd/mm/yyyy') " ;
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = ?  and CLINIC_CODE = ? and care_locn_type_ind=? and resource_class=? and nvl(practitioner_id,'X')=nvl(?,nvl(practitioner_id,'X'))   and UPPER(RTRIM(TO_CHAR( CLINIC_DATE,'Day')))= RTRIM(?)  and CLINIC_DATE  between to_date(?,'dd/mm/yyyy')  and to_date(?,'dd/mm/yyyy') " ;


		//rset=stmt.executeQuery(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locnType);
			pstmt.setString(4,resType);
			pstmt.setString(5,practid);
			pstmt.setString(6,fromday);
			pstmt.setString(7,efffrom);
			pstmt.setString(8,effto);
			rset = pstmt.executeQuery(); 
		if(rset.next()){

		
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			//sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DAY')) TRANSFER_DAY,  NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND TO_DATE('"+effto+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+effto+"','DD/MM/YYYY'),'"+today+"')) ORDER BY CLINIC_DATE ";
		

			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
		sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE,'"+today+"'),'DAY')) TRANSFER_DAY,  NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND TO_DATE('"+effto+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+efffrom+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+effto+"','DD/MM/YYYY'),'"+today+"'))  AND (eff_status != 'D' OR eff_status IS NULL) ORDER BY CLINIC_DATE ";

		

			flag="T";
		}else{
			flag = "F";
		}


	}else if(flag1.equals("N") && ref_val.equals("true"))
	{

          /* Below query was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		  
		sql = " Select 1 from OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"'  and CLINIC_CODE = '"+locncode+"' and care_locn_type_ind='"+locnType+"' and resource_class='"+resType+"' and nvl(practitioner_id,'X')=nvl('"+practid+"',nvl(practitioner_id,'X'))   and RTRIM(TO_CHAR( CLINIC_DATE,'Day'))= RTRIM('"+fromday+"')  and CLINIC_DATE  between to_date('"+effto+"','dd/mm/yyyy')  and to_date('"+efffrom+"','dd/mm/yyyy') " ;
		

		rset=stmt.executeQuery(sql);

		if(rset.next()){
		
		
        /*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
		//sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DAY')) TRANSFER_DAY, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND TO_DATE('"+efffrom+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+efffrom+"','DD/MM/YYYY'),'"+today+"')) ORDER BY CLINIC_DATE";
		
		/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
		sql1 =  " SELECT TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') CURRENT_DATE,  INITCAP(TO_CHAR(CLINIC_DATE,'DAY')) CURRENT_DAY, (SELECT day_no FROM sm_day_of_week WHERE RTRIM(day_of_week) = RTRIM(TO_CHAR(clinic_date, 'DAY'))) CLINIC_DAY_NO,  decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_FULL_NAME, PRACTITIONER_ID, TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DD/MM/YYYY') TRANSFER_DATE, INITCAP(TO_CHAR(NEXT_DAY(CLINIC_DATE-'7','"+today+"'),'DAY')) TRANSFER_DAY, NVL(TOTAL_SLOTS_BOOKED,0)+NVL(TOTAL_SLOTS_OVERBOOKED,0) NO_OF_APPTS, CARE_LOCN_TYPE_IND, RESOURCE_CLASS, NVL(TOTAL_SLOTS_BOOKED-(NVL(TOTAL_FIRST_VISITS_BLOCKED,0)+NVL(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) TOTAL_SLOTS_BOOKED, PRIMARY_RESOURCE_YN, TO_CHAR(TO_DATE('"+effto+"','DD/MM/YYYY'),'DAY') D FROM OA_CLINIC_SCHEDULE_VW WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))= RTRIM(UPPER('"+fromday+"')) AND CLINIC_DATE  BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND TO_DATE('"+efffrom+"','DD/MM/YYYY') AND 'XX' NOT IN (SELECT 'XX' FROM OA_CLINIC_SCHEDULE WHERE FACILITY_ID = '"+facilityId+"' AND CLINIC_CODE = '"+locncode+"' AND CARE_LOCN_TYPE_IND='"+locnType+"' AND RESOURCE_CLASS='"+resType+"' AND  NVL(PRACTITIONER_ID,'X')=NVL('"+practid+"',NVL(PRACTITIONER_ID,'X')) AND RTRIM(TO_CHAR(CLINIC_DATE,'DAY'))=RTRIM(UPPER('"+today+"')) AND CLINIC_DATE BETWEEN TO_DATE('"+effto+"','DD/MM/YYYY') AND NEXT_DAY(TO_DATE('"+efffrom+"','DD/MM/YYYY'),'"+today+"')) AND (a.eff_status != 'D' OR a.eff_status IS NULL) ORDER BY CLINIC_DATE";

		flag="T";
		}else{
			flag = "F";
		}
	}
	if(rset !=null) rset.close();


	if(flag.equals("T")){
		stmt1=con.createStatement();
		stmt4=con.createStatement();
		rset1=stmt1.executeQuery(sql1);

		if(rset1.next() ){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

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
do{
			    tday = rset1.getString("d");
				currdate=rset1.getString("CURRENT_DATE");
				currdate_disp=DateUtils.convertDate(currdate,"DMY","en",locale);

				currday = rset1.getString("CURRENT_DAY");

				
				currday=currday.trim();
				if(currday.equalsIgnoreCase("Monday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(currday.equalsIgnoreCase("Tuesday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(currday.equalsIgnoreCase("Wednesday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(currday.equalsIgnoreCase("Thursday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(currday.equalsIgnoreCase("Friday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(currday.equalsIgnoreCase("Saturday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(currday.equalsIgnoreCase("Sunday"))
								{
									currday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

				curdayno = rset1.getString("CLINIC_DAY_NO");
				practname = rset1.getString("PRACTITIONER_FULL_NAME");
				pract = rset1.getString("PRACTITIONER_ID");
				care_locn_type_ind= rset1.getString("care_locn_type_ind");
				resource_class= rset1.getString("resource_class");
				if(resource_class.equals("P")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(resource_class.equals("R")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(resource_class.equals("O")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}else if(resource_class.equals("E")){
					resource_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}
				sel_res_pos = rset1.getString("PRIMARY_RESOURCE_YN");
				if(sel_res_pos==null || sel_res_pos.equals("null"))  sel_res_pos="";

				if(pract== null || pract.equals("null")) pract ="~";
				if(practname == null || practname.equals("null"))
				practname ="&nbsp;";
				noofappts = rset1.getString("total_slots_booked");
				if(noofappts==null) noofappts="0";
				primary_yn = rset1.getString("primary_resource_yn");

				if(dateday.equals("A")){
					transdate = effto;
					transday = tday;
				}else{
					transdate = rset1.getString("TRANSFER_DATE");
					transday = rset1.getString("TRANSFER_DAY");
				}

				transdate_disp=DateUtils.convertDate(transdate,"DMY","en",locale);

				transday=transday.trim();
		
			if(transday.equalsIgnoreCase("Monday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(transday.equalsIgnoreCase("Tuesday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(transday.equalsIgnoreCase("Wednesday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(transday.equalsIgnoreCase("Thursday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(transday.equalsIgnoreCase("Friday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(transday.equalsIgnoreCase("Saturday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(transday.equalsIgnoreCase("Sunday"))
								{
									transday1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


				String t_prct="";
				if (pract==null)  {
					pract1="";	
					t_prct="";
				}else{
					pract1 = pract;
					t_prct=pract1;
					if(pract1.equals("~"))
						t_prct="";
				}

				if(k==0){ // to exec only one on the loop
					//rset2=stmt2.executeQuery("select day_no from sm_day_of_week where rtrim(Initcap(day_of_week)) = rtrim('"+transday+"')");

//Add for PE on june 17'th june 2010
					String chkval1="select day_no,(select TO_DATE ('"+transdate+"', 'dd/mm/yyyy') - trunc(sysdate)  from dual)chkdate from sm_day_of_week where rtrim(Initcap(day_of_week)) = rtrim('"+transday+"')";

					

					rset2=stmt2.executeQuery(chkval1);
					//int dateval = 0;
					if(rset2.next()){
						
						transdayno = rset2.getString("day_no");
						
						dateval =rset2.getInt("chkdate");
						
					}
				}

				if(rset2 !=null)rset2.close();
				cntval="0";
				
				if ( k % 2==0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;

					//String chkval = " select TO_DATE ('"+transdate+"', 'dd/mm/yyyy') - trunc(sysdate) chkdate from dual";
					
							/*rset2 = stmt2.executeQuery(chkval1);
							int dateval = 0;
							if(rset2 !=null && rset2.next())
						   {
								dateval =rset2.getInt("chkdate");
								
							}
							
						if(rset2 !=null)rset2.close();	*/
						
				if(!(noofappts.equals("0")) && dateval >=0){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currdate_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currday));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(transdate_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(transday1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(resource_class_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(primary_yn.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(t_prct));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(currday.trim()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
}else if((noofappts.equals("0")) && dateval >=0){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currdate_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currday));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(transdate_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(transday1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(resource_class_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
	

				if(!(noofappts.equals("0")) && primary_yn.equals("Y") && dateval >=0){
						
					
					}
					
			
				if(rset4 !=null)rset4.close();

				
            _bw.write(_wl_block26Bytes, _wl_block26);
if(primary_yn.equals("N") && !(noofappts.equals("0")) && dateval >=0){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }else if(primary_yn.equals("N") && (noofappts.equals("0")) && dateval >=0){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block41Bytes, _wl_block41);
} else if(primary_yn.equals("Y") && !(noofappts.equals("0")) && dateval >=0 ) {
		
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block45Bytes, _wl_block45);


	} else if(primary_yn.equals("Y") && (noofappts.equals("0")) && dateval >=0) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transdate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
k++;
	
	}while(rset1.next());
						
			

            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
}	    
	}else{
		
		if(chk=="F"){
            _bw.write(_wl_block50Bytes, _wl_block50);

	}
		else{
            _bw.write(_wl_block51Bytes, _wl_block51);
 }
	}

	if(rset != null)rset.close();
	if(rset1 != null)rset1.close();
	if(rset2 != null)rset2.close();
	if(rset4 != null)rset4.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	if(stmt2 != null) stmt2.close();
	if(stmt3 != null) stmt3.close();
	if(stmt4 != null) stmt4.close();

}catch(Exception e){
	//out.print("her :" +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(efffrom));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(effto));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(dateday));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(curdayno));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(transdayno));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(fromday));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(today));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(resType));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(other_remarks));
            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.CurrentDay.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transferdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TransferDay.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NoOfAppts.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
