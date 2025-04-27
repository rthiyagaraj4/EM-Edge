package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __populateapptreferralcompresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PopulateApptReferralCompResult.jsp", 1742365893170L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:30 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PopulateApptReferralComp.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\'popAppRefCriteriaForm\' id=\'popAppRefCriteriaForm\' action=\'../../eMP/jsp/PopulateApptReferralCompResult.jsp\' method=\'past\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table  width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<A href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'pat_details\'>\n\t\t\t<tr>\n\t\t\t\t<th width=\'15%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t<th width=\'12%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t<th width=\'33%\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t<th width=\'8%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr>\n\t\t\t\t\t <td align=\'left\' class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'15%\'><a href=\"javascript:dispRefNum(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"><FONT SIZE=\"1\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</FONT></a></TD>\n\t\t\t\t\t <td align=\'left\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' width=\'12%\'><FONT SIZE=\"1\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</FONT></TD>\n\t\t\t\t\t <td align=\'left\' class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'33%\' nowrap><FONT SIZE=\"1\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'8%\'><FONT SIZE=\"1\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' width=\'20%\'><FONT SIZE=\"1\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</FONT></TD>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\tparent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tdocument.getElementById(\'pat_details\').style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'max_record\' id=\'max_record\' value=\'maxRecord\'>\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'refrlAappt\' id=\'refrlAappt\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'selectedLocation\' id=\'selectedLocation\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patName\' id=\'patName\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'genderValue\' id=\'genderValue\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'refNo\' id=\'refNo\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'periodFrom\' id=\'periodFrom\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'periodTo\' id=\'periodTo\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'hidden\' name=\'locationValue\' id=\'locationValue\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'RDinstall_yn\' id=\'RDinstall_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rst1				= null;
	request.setCharacterEncoding("UTF-8");
	String facility_id			= "";
	String refrlAappt			= "";
	String referenceNo			= "";
	String apptDate				= "";
	String patient_name			= "";
	String gender				= "";
	String dob					= "";
	String location				= "";
	String selectedLocation		= "";
	String patName				= "";
	String genderValue			= "";
	String refNo				= "";
	String periodFrom			= "";
	String periodTo				= "";
	String locationValue		= "";
	String RDinstall_yn			= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String other_alt_type		= "";
	String other_alt_Id			= "";
	String from					= "";
	String to					= "";
	String classValue			= "QRYEVEN";

	StringBuffer selectQuery = null;
	selectQuery = new StringBuffer();

	int count		= 0;
	int maxRecord	= 0;
    int start		= 0;
    int end			= 0;
    int i			= 1;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		facility_id = (String) session.getValue("facility_id");
		
		from	= request.getParameter("from");
		to		= request.getParameter("to");

		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
		if (to == null){ end = 14; } else { end = Integer.parseInt(to); }

		refrlAappt			= request.getParameter("refrlAappt");
		selectedLocation	= request.getParameter("selectedLocation");
		patName				= request.getParameter("patName");
		genderValue			= request.getParameter("genderValue");
		refNo				= request.getParameter("refNo");
		periodFrom			= request.getParameter("periodFrom");
		periodTo			= request.getParameter("periodTo");
		locationValue		= request.getParameter("locationValue");
		RDinstall_yn		= request.getParameter("RDinstall_yn");
		national_id_no		= request.getParameter("national_id_no");
		alt_id1_no			= request.getParameter("alt_id1_no");
		alt_id2_no			= request.getParameter("alt_id2_no");
		alt_id3_no			= request.getParameter("alt_id3_no");
		alt_id4_no			= request.getParameter("alt_id4_no");
		other_alt_type		= request.getParameter("other_alt_type");
		other_alt_Id		= request.getParameter("other_alt_Id");
	
		if(refrlAappt == null) refrlAappt = "";
		if(selectedLocation == null) selectedLocation = "";
		if(patName == null) patName = "";
		if(genderValue == null) genderValue = "";
		if(refNo == null) refNo = "";
		if(periodFrom == null) periodFrom = "";
		if(periodTo == null) periodTo = "";
		if(locationValue == null) locationValue = "";
		if(national_id_no == null) national_id_no = "";
		if(alt_id1_no == null) alt_id1_no = "";
		if(alt_id2_no == null) alt_id2_no = "";
		if(alt_id3_no == null) alt_id3_no = "";
		if(alt_id4_no == null) alt_id4_no = "";
		if(other_alt_type == null) other_alt_type = "";
		if(other_alt_Id == null) other_alt_Id = "";
		if(RDinstall_yn == null) RDinstall_yn = "N";
		
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			if(refrlAappt.equals("A"))
			{
				selectQuery.append(" SELECT a.appt_ref_no referenceNo, to_char(a.appt_date, 'dd/mm/yyyy')  apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (decode(a.care_locn_type_ind, 'C','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+"','E','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+"','D','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+"')|| '/' || b.long_desc) long_desc FROM oa_appt a, op_clinic_lang_vw b WHERE a.facility_id = '"+facility_id+"' and b.language_id='"+localeName+"' AND trunc(a.appt_date) >= trunc(sysdate) AND a.facility_id = b.facility_id AND a.clinic_code = b.clinic_code AND a.patient_id IS NULL AND a.appt_status = '1' ");

				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");
				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");

				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.gender = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.appt_ref_no = '"+refNo+"' ");
				} 
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" AND a.care_locn_type_ind = '"+selectedLocation+"' ");
				}
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.clinic_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) <= to_date('"+periodTo+"','dd/mm/yyyy') ");
				}
				
				selectQuery.append(" ORDER BY 2, 1");

			}
			else if(refrlAappt.equals("R"))
			{
				selectQuery.append(" SELECT a.appt_ref_num referenceNo, to_char(a.appt_date, 'dd/mm/yyyy')  apptDate, 	decode('"+localeName+"', 'en', a.short_name, nvl(a.SECOND_NAME_LOC_LANG, a.short_name)) patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, c.short_desc long_desc FROM rd_appt a, rd_clinic b, rd_wings c WHERE a.operating_facility_id = '"+facility_id+"' AND trunc(a.appt_date) >= trunc(sysdate) AND a.operating_facility_id = b.operating_facility_id AND a.clinic_code = b.clinic_code AND b.operating_facility_id = c.operating_facility_id AND b.wing_code = c.wing_code AND a.patient_id IS NULL AND a.appt_status = '1' ");
				
				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_num = '"+national_id_no+"' ");
				}

				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.short_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.short_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.sex = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.appt_ref_num = '"+refNo+"' ");
				} 
				if(!locationValue.equals(""))
				{
				//selectQuery.append(" AND a.wing_code = '"+locationValue+"' "); Modified By Venkat S against IN016973 (08.12.09)
					selectQuery.append(" AND c.wing_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				} 		

				selectQuery.append(" ORDER BY 2, 1");
			}
			else if(refrlAappt.equals("I"))
			{
				selectQuery.append(" SELECT a.bkg_lst_ref_no referenceNo, to_char(a.preferred_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, b.long_desc long_desc FROM ip_booking_list a, ip_nursing_unit b WHERE a.facility_id = '"+facility_id+"' AND trunc(a.preferred_date) >= trunc(sysdate) AND a.facility_id = b.facility_id (+) AND a.nursing_unit_code = b.nursing_unit_code(+) AND a.patient_id IS NULL AND a.booking_status = '1' ");
				
				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");
				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");
				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.gender = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.bkg_lst_ref_no = '"+refNo+"' ");
				} 
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.nursing_unit_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				}			

				selectQuery.append(" ORDER BY 2, 1");
			}
			else if(refrlAappt.equals("L"))
			{
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))  patient_name,a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyy') dob, b.long_desc long_desc FROM pr_referral_register a, ");
					if(selectedLocation.equals("N"))
					{
						selectQuery.append(" ip_nursing_unit b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.facility_id AND a.TO_LOCN_CODE = b.nursing_unit_code(+) AND a.patient_id IS NULL AND a.status = 'O' ");
					}
					if(selectedLocation.equals("C") || selectedLocation.equals("E") || selectedLocation.equals("Y") )
					{
						selectQuery.append(" op_clinic b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.facility_id AND a.to_locn_code = b.clinic_code AND a.patient_id IS NULL AND a.status = 'O' ");
					}
					if(selectedLocation.equals("W"))
					{
						selectQuery.append(" rd_wings b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.operating_facility_id AND a.to_locn_code = b.wing_code AND a.patient_id IS NULL AND a.status = 'O' ");
					}
				}
				else if(selectedLocation.equals(""))
				{
					if(RDinstall_yn.equals("N"))
					{
						selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (CASE WHEN to_locn_type = 'N' THEN (SELECT long_desc FROM ip_nursing_unit WHERE facility_id = a.to_facility_id AND nursing_unit_code = a.to_locn_code) ELSE (SELECT long_desc FROM op_clinic WHERE facility_id = a.to_facility_id AND clinic_code = a.to_locn_code) END ) long_desc FROM pr_referral_register a WHERE a.to_facility_id = '"+facility_id+"' AND a.patient_id IS NULL AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.status = 'O' ");
					}
					else if(RDinstall_yn.equals("Y"))
					{
						selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))  patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (CASE WHEN to_locn_type = 'N' THEN (SELECT long_desc FROM ip_nursing_unit WHERE facility_id = a.to_facility_id AND nursing_unit_code = a.to_locn_code) when to_locn_type = 'W' then (select short_Desc FROM rd_wings WHERE operating_facility_id = a.to_facility_id AND wing_code = a.to_locn_code) ELSE (SELECT long_desc FROM op_clinic WHERE facility_id = a.to_facility_id AND clinic_code = a.to_locn_code) END ) long_desc FROM pr_referral_register a WHERE a.to_facility_id = '"+facility_id+"' AND a.patient_id IS NULL AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date ) >= trunc(sysdate)) AND a.status = 'O' ");
					}
				}

				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");

				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");
				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.sex = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.referral_id = '"+refNo+"' ");
				}
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" AND a.to_locn_type = '"+selectedLocation+"' ");
				}
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.to_locn_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_treatment_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_treatment_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				}
				
				selectQuery.append(" ORDER BY 2, 1");
			}
			
			rst1 = stmt1.executeQuery(selectQuery.toString());
			rst1.last();
			maxRecord = rst1.getRow();
			rst1.beforeFirst();
			
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(!(start <= 1))
					{
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					if (!((start+14) >= maxRecord))
					{
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			if (start != 0)
			{
				for(int j=1; j<=start; i++,j++)
				{
					rst1.next() ;
				}
			}
			while(rst1.next() && i<=end)
			{	
				
				referenceNo		= rst1.getString("referenceNo");
				apptDate			= rst1.getString("apptDate");
				patient_name	= rst1.getString("patient_name");
				gender			= rst1.getString("patGender");
				dob				= rst1.getString("dob");
				location			= rst1.getString("long_desc");

				if(apptDate == null)
					apptDate ="";
				if(dob == null)
					dob ="";
				
				if(!gender.equals(""))
				{
				switch(gender.charAt(0))
							{
								case 'M' : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); break;
								case 'F' : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); break;
								default : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}
				}


				if(referenceNo == null) referenceNo = "";
				if (apptDate != "") 
				{
					apptDate= DateUtils.convertDate(apptDate,"DMY","en",localeName);
				}
				else
					apptDate = "&nbsp;";

				if (dob != "") 
				{
					dob= DateUtils.convertDate(dob,"DMY","en",localeName);
				}
				else
					dob = "&nbsp;";

				if(patient_name == null) patient_name = "&nbsp;";
				if(gender == null) gender = "&nbsp;";
				if(location == null) location = "&nbsp;";

				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(referenceNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(referenceNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(apptDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(location));
            _bw.write(_wl_block29Bytes, _wl_block29);

				if(classValue.equals("QRYEVEN")) classValue = "QRYODD";
				else classValue = "QRYEVEN";

				count++;
				i++;
			}
			if(count == 0)
			{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(end));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(start));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(selectedLocation));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(genderValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(refNo));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(periodFrom));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(periodTo));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locationValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(RDinstall_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);

		if(selectQuery != null && selectQuery.length() > 0)
		{
			selectQuery.delete(0,selectQuery.length());
		}
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e.getMessage());
	}
	finally
	{
		 if(con!=null) ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referenceno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
