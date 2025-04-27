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
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __blockapptallocationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BlockApptAllocationDetails.jsp", 1725425058890L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"JavaScript\">\n\t\t\tfunction validateSlots(obj,rownum)\n\t\t\t{\n\t\t\t\tif (!(obj.readOnly)){\n\t\t\t\tif(obj.value == \'\') obj.value=0;\n\n\t\t\t\tif(CheckNum(obj))\n\t\t\t\t{\n\t\t\t\t\tvar a = eval(\"document.getElementById(\'block_slot\')\"+rownum+\".value\");\n\t\t\t\t\tvar arr = a.split(\"`\");\n\t\t\t\t\ttotalslots = arr[0];\n\t\t\t\t\tif(eval(obj.value)>totalslots)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar error = getMessage(\'BLOCK_SLOTS_ARE_MORE\',\'OA\');\n\t\t\t\t\t\talert(error)\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n    function validateVisit(obj,max_value,total_booked,total_blocked)\n\t{\n\t\t\n\t\tif(parseInt(max_value)>0){\n\t\t\t\n\t\t\t\tif(parseInt(obj.value)>(parseInt(max_value)-(parseInt(total_booked)+parseInt(total_blocked)))){\n\t\t\t\t\n\t\t\t\t\n\t\t\t\talert(getMessage(\"BLOCK_VISITS_ARE_MORE\",\"OA\"));\n\t\t\t\tif(obj.readOnly){\n\t\t\t\t}else{\n\t\t\t\t\tobj.focus();\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"BlockApptAllocationDetails_form\" id=\"BlockApptAllocationDetails_form\">\n\t<table cellpadding=0 cellspacing=0 width=\"100%\" border=1>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<tr>\n\t\t\t<td colspan=5 class=DATA>\n\t\t\t\t<b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b>\n\t\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=slots_blocked>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</th>\n\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n               \n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\n\n\t\t\t\t\t\t\t\t\t<tr><td  class=\'QRYODD\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t\t\t<td   class=\'QRYODD\' align=\'center\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t\t\t<td   class=\'QRYODD\'><input type=hidden name=block_slot";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\t\t\t\t\t\t\t\t\t<input type=text ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" name=\'block_slot_text";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=0  maxlength=3 size=3 style=\'text-align:right\' onBlur=\'javascript:validateSlots(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");\' onKeyPress=\'return(ChkNumberInput(this,event,0));\'></td>\n\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan = 5>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<tr><td class=QRYODD>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t\t<td  class=QRYODD align=\'center\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t<td  class= QRYODD  align=\'center\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=QRYODD align=\'center\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t<td  class=QRYODD >\n\t\t\t\t\t\t\t\t<input type=text name=\'first_visit_text\' id=\'first_visit_text\' value=0  maxlength=3 size=3 style=\'text-align:right\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onBlur=\'javascript:validateVisit(this,";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =");\' onKeyPress=\'return(ChkNumberInput(this,event,0));\'></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<tr><td class=QRYEVEN>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t\t\t\t<td  class=QRYEVEN align=\'center\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=QRYEVEN align=\'center\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t\t\t<td  class=QRYEVEN >\n\t\t\t\t\t\t\t\t<input type=text name=\'other_visit_text\' id=\'other_visit_text\' value=0  maxlength=3 size=3 style=\'text-align:right\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="  onBlur=\'javascript:validateVisit(this,";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<input type=\'hidden\' name=\'total_slots_booked\' id=\'total_slots_booked\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=\'hidden\' name=\'max_patients_per_day\' id=\'max_patients_per_day\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'max_first_visits\' id=\'max_first_visits\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=\'hidden\' name=\'max_other_visits\' id=\'max_other_visits\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'total_first_visits_blocked\' id=\'total_first_visits_blocked\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'total_other_visits_blocked\' id=\'total_other_visits_blocked\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\n\n\t</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String facilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String visit_limit_rule = request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String slot_appt_ctrl = request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String locncode =request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String practitionerid = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
		String blockdate = request.getParameter("block_date")==null?"":request.getParameter("block_date");
		String alcncriteria = request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		
		String sql="";
		String alcncriteriadesc = "";
		 String max_first_visits = "";
                            String total_first_visits = "";
							String max_other_visits = "";
							String total_other_visits = "";
							String total_slots_booked="";
							String max_patients_per_day= "";

							String total_first_visits_blocked ="" ;
							String total_other_visits_blocked ="";

		if(alcncriteria.equals("NG"))
		{
			alcncriteriadesc = "Nationaligy Group";
		}
		String slotsblocked = request.getParameter("slots_blocked")==null?"&nbsp;":request.getParameter("slots_blocked");
				//	out.println("1");


		Connection con = null ;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		//String className = "";
		int i =0;
		String readOnly = "";
		String pat_or_slot_flag =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels");
		if (slot_appt_ctrl.equals("S"))
			pat_or_slot_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Slot.label","common_labels");


			//out.println("two");

            _bw.write(_wl_block7Bytes, _wl_block7);
if (slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(slotsblocked));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(slotsblocked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcncriteriadesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_or_slot_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_or_slot_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			
			try
			 {
				con= ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				
            _bw.write(_wl_block17Bytes, _wl_block17);

					if(alcncriteria.equals("NG"))
					{
				//sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				
					}
					else if(alcncriteria.equals("BG"))
					{
					//sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
					sql = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
						}
					else if(alcncriteria.equals("PC"))
					{
						//sql  = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
						sql  = "select a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
					}
					try
					 {
					  if((!alcncriteria.equals("")) ){
							//rs = stmt.executeQuery(sql);
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locncode);
							pstmt.setString(3,blockdate);
							pstmt.setString(4,practitionerid);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while(rs.next())
								{
									
									if(rs.getInt("final_slots") == 0 )
										readOnly = "readonly";
									else
										readOnly = "";

									String code = rs.getString("alcn_catg_code")==null?"":rs.getString("alcn_catg_code");
									String desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
									if(code.equals("*O")) desc = "Others";
									String passvalue = rs.getInt("final_slots")+"`"+alcncriteria+"`"+code+"`"+"$"+"`";
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getInt("max_patients")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((rs.getInt("total_booked_patients")-rs.getInt("total_blocked_slots"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getInt("total_blocked_slots")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(passvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
		i++;
						}
					}
				}
			 }
			 catch (Exception e){
					//out.println("EROOR"+e);
					 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally	{
					
				}
                out.println("<input type='hidden' value='"+i+"' name='total_count' id='total_count'>");
                out.println("<input type='hidden' value='"+slot_appt_ctrl+"' name='slot_appt_ctrl' id='slot_appt_ctrl'>");
			

				if ( visit_limit_rule.equals("E")||visit_limit_rule.equals("M")){



					//added by viswanath;;;
/*sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|')";
						//Added by Kiruthiga on 07/11/2005
						if(rs!=null) rs.close();
						//End

					rs = stmt.executeQuery(sql);
					if(rs !=null){
					out.println("<th align = left colspan = 5>Visit Type</th>");
						while(rs.next()){

                           max_first_visits = rs.getString("max_first_visits");
							 total_slots_booked=rs.getString("total_slots_booked");
							 max_patients_per_day= rs.getString("max_patients_per_day");
                             total_first_visits = rs.getString("total_first_visits");
							max_other_visits = rs.getString("max_other_visits");
							total_other_visits = rs.getString("total_other_visits");
							if (max_first_visits==null) max_first_visits= "0";
							if (total_first_visits==null) total_first_visits= "0";
							if (max_other_visits==null) max_other_visits= "0";
							if (total_other_visits==null) total_other_visits= "0";
							 total_first_visits_blocked = rs.getString("total_first_visit_blocked");
							total_other_visits_blocked = rs.getString("total_other_visits_blocked");
							String first_read_only="";
							String other_read_only="";*/
					//ended by viswanath;;;;
				   
			//out.println("2");

						//sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+blockdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|')";
						sql = "select max_first_visits,nvl(total_slots_booked,0) total_slots_booked ,nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_first_visit,0) total_first_visits,max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits,nvl(total_first_visits_blocked,0) total_first_visit_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked from oa_clinic_schedule where facility_id=? and clinic_code=? and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl(?,'|')";
						

					//rs = stmt.executeQuery(sql);

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,blockdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
					{

					
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

						while(rs.next())
						{

                            max_first_visits = rs.getString("max_first_visits");
                            total_first_visits = rs.getString("total_first_visits");
							 max_other_visits = rs.getString("max_other_visits");
							 total_other_visits = rs.getString("total_other_visits");
							 total_slots_booked=rs.getString("total_slots_booked");
							 max_patients_per_day= rs.getString("max_patients_per_day");
							if (max_first_visits==null) max_first_visits= "0";
							if (total_first_visits==null) total_first_visits= "0";
							if (max_other_visits==null) max_other_visits= "0";
							if (total_other_visits==null) total_other_visits= "0";
							if (total_slots_booked==null) total_slots_booked= "0";
							if (max_patients_per_day==null) max_patients_per_day= "0";
							 total_first_visits_blocked = rs.getString("total_first_visit_blocked");
							 total_other_visits_blocked = rs.getString("total_other_visits_blocked");
							String first_read_only="";
							String other_read_only="";
							if (Integer.parseInt(max_first_visits)>0){
								if (max_first_visits.equals(total_first_visits))
								 first_read_only = "readOnly";
							}
							if (Integer.parseInt(max_other_visits)>0){
								if (max_other_visits.equals(total_other_visits))
								  other_read_only = "readOnly";
							}

		//	out.println("5");

								
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(total_first_visits));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(total_first_visits_blocked));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(first_read_only));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(total_first_visits));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(total_first_visits_blocked));
            _bw.write(_wl_block35Bytes, _wl_block35);

								
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(total_other_visits));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(total_other_visits_blocked));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(other_read_only));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(total_other_visits));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(total_other_visits_blocked));
            _bw.write(_wl_block35Bytes, _wl_block35);

						}
					}
				}
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
				}catch (Exception e){
					//out.println("EROOR@238"+e);
					e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally	{
					if(stmt !=null) stmt.close();
					if(rs !=null) rs.close();
					ConnectionManager.returnConnection(con,request);
				}
			
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(total_slots_booked));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(max_patients_per_day));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(total_first_visits));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(total_other_visits));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Slotstobeblocked.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Max.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SlotsBlocked.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BlockSlots.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firstvisit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.othervisit.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
