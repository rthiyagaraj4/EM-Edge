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
import org.json.simple.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __multiselectionapptreschedulingresult2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MultiSelectionApptReschedulingResult2.jsp", 1742299223639L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->\r\n<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n<html>\r\n<head>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\r\n<script language=\"javascript\" src=\"../../eOA/js/MultiSelectionApptRescheduling.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> </script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n<script language=\'JavaScript\' src=\'../../eCommon/js/showModalDialog.js\' ></script>\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\r\n</head>\r\n\r\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\r\n\r\n<form name=\"MultiSelectionApptReschResult2Form\" id=\"MultiSelectionApptReschResult2Form\">\r\n\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n<table border=\"2\" width=\"40%\" cellspacing=\'0\' cellpadding=\'0\' id=\'VstCnt\'>\r\n<tr>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap>&nbsp;</td>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap>\r\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t<b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b>\r\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n</td>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></td>\r\n</tr>\r\n<tr>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap>\r\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</b></td>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</b></td>\r\n</tr>\r\n<tr>\r\n<td class=\'label\' align=\'middle\' width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</b></td>\r\n</tr>\r\n</table>\r\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\r\n\r\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results2\'>\r\n\r\n<tr>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head1\' class=\'myClass\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\'  ><div  id=\'head2\' width=\'12%\' class=\'myClass\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head3\'  class=\'myClass\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\'  ><div  id=\'head4\' width=\'12%\' class=\'myClass\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div></th>\r\n</tr>\r\n\r\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t<tr>\r\n\r\n\t\t<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\r\n\r\n\t\t<!--<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>-->\r\n\r\n\t\t<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\r\n\r\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t\t<td width=\'23%\' nowrap class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\r\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t<td width=\'23%\' class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">&nbsp;</td>\r\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\r\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t\t<td width=\'13%\' nowrap class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\r\n\t\t<td width=\'13%\' class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n\r\n\t\t<input type=\'hidden\' name=\'from_srl_no_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'from_srl_no_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\r\n\t\t<input type=\'hidden\' name=\'to_srl_no_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'to_srl_no_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\r\n\t\t<input type=\'hidden\' name=\'trf_from_time_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'trf_from_time_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\r\n\t\t<input type=\'hidden\' name=\'trf_to_time_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'trf_to_time_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\r\n\t\t<input type=\'hidden\' name=\'selected_appt_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'selected_appt_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\r\n\t\t<input type=\'hidden\' name=\'no_of_slots_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'no_of_slots_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\r\n\r\n\t</tr>\r\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\r\n\t\t\t<input type=\'hidden\' name=\'time_table_type\' id=\'time_table_type\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'selected_appt_cnt\' id=\'selected_appt_cnt\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'fac_id\' id=\'fac_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'from_locn\' id=\'from_locn\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'from_resc\' id=\'from_resc\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'to_locn\' id=\'to_locn\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'to_resc\' id=\'to_resc\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'to_res_class\' id=\'to_res_class\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'reason_code_revision\' id=\'reason_code_revision\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'curr_user_id\' id=\'curr_user_id\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'workstation_id\' id=\'workstation_id\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'available_total_slots\' id=\'available_total_slots\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'available_first_visit_slots\' id=\'available_first_visit_slots\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'available_other_visit_slots\' id=\'available_other_visit_slots\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'total_to_srl_no\' id=\'total_to_srl_no\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\r\n\t\t</table>\r\n\r\n</form>\r\n\r\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\r\n\r\n</body>\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static JSONArray getToSchedule(Connection con, String fac_id,
			String locn_type, String to_locn, String to_res_class,
			String to_resc, String to_date) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray ArrJSONSch = new JSONArray();

		try {

			StringBuffer sql_label = new StringBuffer();

			sql_label
					.append("SELECT a.srl_no, TO_CHAR (a.slot_slab_start_time, 'hh24:mi') AS slot_slab_start_time, TO_CHAR (a.slot_slab_end_time, 'hh24:mi') AS slot_slab_end_time FROM oa_clinic_schedule_slot_slab a WHERE a.facility_id = ? AND a.care_locn_type_ind = ? AND a.clinic_code = ? AND a.resource_class = ? AND a.clinic_date = TO_DATE (?, 'dd/mm/yyyy')  AND a.pri_appt_ref_no is null AND ext_slot_yn is null AND schedule_status is null AND ");

			if (to_resc.equals("")) {
				sql_label.append("a.practitioner_id is null");
			} else {
				sql_label.append("a.practitioner_id = ?");
			}

			pstmt = con.prepareStatement(sql_label.toString());

			pstmt.setString(1, fac_id);
			pstmt.setString(2, locn_type);
			pstmt.setString(3, to_locn);
			pstmt.setString(4, to_res_class);
			pstmt.setString(5, to_date);

			if (!to_resc.equals("")) {
				pstmt.setString(6, to_resc);
			}

			rs = pstmt.executeQuery();

			while (rs != null && rs.next()) {

				JSONObject jsonObjSch = new JSONObject();

				String srl_no = rs.getString("srl_no") == null ? "" : rs
						.getString("srl_no");
				String slot_slab_start_time = rs
						.getString("slot_slab_start_time") == null ? "" : rs
						.getString("slot_slab_start_time");
				String slot_slab_end_time = rs.getString("slot_slab_end_time") == null ? ""
						: rs.getString("slot_slab_end_time");

				jsonObjSch.put("srl_no", srl_no);
				jsonObjSch.put("slot_slab_start_time", slot_slab_start_time);
				jsonObjSch.put("slot_slab_end_time", slot_slab_end_time);

				ArrJSONSch.add(jsonObjSch);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getToSchedule - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return ArrJSONSch;
	}

	public static JSONObject getApptDtls(Connection con, String locale,
			String fac_id, String selected_appt) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String patient_id = "";
		String patient_name = "";
		String gender = "";
		String visit_type_desc = "";
		String reason_for_contact = "";
		String no_of_slots = "";

		JSONObject jsonObj = new JSONObject();

		try {
			String sql = "SELECT patient_id, NVL (patient_name_loc_lang, patient_name) AS patient_name, DECODE (gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown' ) AS gender, (SELECT short_desc visit_type FROM op_visit_type_lang_vw WHERE visit_type_code = appt_type_code AND ROWNUM = 1) AS visit_type_desc, am_get_desc.am_contact_reason (contact_reason_code, ?, 1 ) AS reason_for_contact, NVL (no_of_slots, 0) no_of_slots FROM oa_appt WHERE appt_ref_no = ? AND facility_id = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, locale);
			pstmt.setString(2, selected_appt);
			pstmt.setString(3, fac_id);

			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {
				patient_id = rs.getString("patient_id") == null ? "" : rs
						.getString("patient_id");
				patient_name = rs.getString("patient_name") == null ? "" : rs
						.getString("patient_name");
				gender = rs.getString("gender") == null ? "" : rs
						.getString("gender");
				visit_type_desc = rs.getString("visit_type_desc") == null ? ""
						: rs.getString("visit_type_desc");
				reason_for_contact = rs.getString("reason_for_contact") == null ? ""
						: rs.getString("reason_for_contact");
				no_of_slots = rs.getString("no_of_slots") == null ? "" : rs
						.getString("no_of_slots");
			}

			jsonObj.put("patient_id", patient_id);
			jsonObj.put("patient_name", patient_name);
			jsonObj.put("gender", gender);
			jsonObj.put("visit_type_desc", visit_type_desc);
			jsonObj.put("reason_for_contact", reason_for_contact);
			jsonObj.put("no_of_slots", no_of_slots);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getApptDtls - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getSlotsCount(Connection con, String fac_id,
			String locn_type, String to_locn, String to_res_class,
			String to_resc, String to_date) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String time_table_type = "";
		String slot_appt_ctrl = "";
		String max_slots_per_day = "";
		String max_patients_per_day = "";
		String max_first_visits = "";
		String max_other_visits = "";
		String total_slots_booked = "";
		String total_first_visit = "";
		String total_other_visits = "";
		String total_first_visits_blocked = "";
		String total_other_visits_blocked = "";

		JSONObject jsonObj = new JSONObject();

		try {
			StringBuffer sql_label = new StringBuffer();

			sql_label
					.append("SELECT time_table_type, b.slot_appt_ctrl, NVL (max_slots_per_day, 0) max_slots_per_day, max_patients_per_day, NVL (max_first_visits, 0) AS max_first_visits, NVL (max_other_visits, 0) AS max_other_visits, NVL (total_slots_booked, 0) AS total_slots_booked, NVL (total_first_visit, 0 ) AS total_first_visit, NVL (total_follow_up, 0) + NVL (total_routine, 0) + NVL (total_series, 0) + NVL (total_consult, 0) + NVL (total_emergency, 0) total_other_visits, NVL (total_first_visits_blocked, 0) total_first_visits_blocked, NVL (total_other_visits_blocked, 0) total_other_visits_blocked FROM oa_clinic_schedule, oa_param b WHERE facility_id = ? AND care_locn_type_ind = ? AND clinic_code = ? AND resource_class = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND ");

			if (to_resc.equals("")) {
				sql_label.append("practitioner_id is null");
			} else {
				sql_label.append("practitioner_id = ?");
			}

			pstmt = con.prepareStatement(sql_label.toString());

			pstmt.setString(1, fac_id);
			pstmt.setString(2, locn_type);
			pstmt.setString(3, to_locn);
			pstmt.setString(4, to_res_class);
			pstmt.setString(5, to_date);

			if (!to_resc.equals("")) {
				pstmt.setString(6, to_resc);
			}

			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {
				time_table_type = rs.getString("time_table_type") == null ? ""
						: rs.getString("time_table_type");
				slot_appt_ctrl = rs.getString("slot_appt_ctrl") == null ? ""
						: rs.getString("slot_appt_ctrl");
				max_slots_per_day = rs.getString("max_slots_per_day") == null ? ""
						: rs.getString("max_slots_per_day");
				max_patients_per_day = rs.getString("max_patients_per_day") == null ? ""
						: rs.getString("max_patients_per_day");
				max_first_visits = rs.getString("max_first_visits") == null ? ""
						: rs.getString("max_first_visits");
				max_other_visits = rs.getString("max_other_visits") == null ? ""
						: rs.getString("max_other_visits");
				total_slots_booked = rs.getString("total_slots_booked") == null ? ""
						: rs.getString("total_slots_booked");
				total_first_visit = rs.getString("total_first_visit") == null ? ""
						: rs.getString("total_first_visit");
				total_other_visits = rs.getString("total_other_visits") == null ? ""
						: rs.getString("total_other_visits");
				total_first_visits_blocked = rs
						.getString("total_first_visits_blocked") == null ? ""
						: rs.getString("total_first_visits_blocked");
				total_other_visits_blocked = rs
						.getString("total_other_visits_blocked") == null ? ""
						: rs.getString("total_other_visits_blocked");
			}

			jsonObj.put("time_table_type", time_table_type);
			jsonObj.put("slot_appt_ctrl", slot_appt_ctrl);
			jsonObj.put("max_slots_per_day", max_slots_per_day);
			jsonObj.put("max_patients_per_day", max_patients_per_day);
			jsonObj.put("max_first_visits", max_first_visits);
			jsonObj.put("max_other_visits", max_other_visits);
			jsonObj.put("total_slots_booked", total_slots_booked);
			jsonObj.put("total_first_visit", total_first_visit);
			jsonObj.put("total_other_visits", total_other_visits);
			jsonObj.put("total_first_visits_blocked",
					total_first_visits_blocked);
			jsonObj.put("total_other_visits_blocked",
					total_other_visits_blocked);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getSlotsCount - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con = null;

	int init = 0;
	int selected_appt_cnt = 0;
	String classValue = "OAQRYEVEN";
	String workstation_id = "";
	String srl_no = "";
	String slot_slab_start_time = "";
	String slot_slab_end_time = "";
	String patient_id = "";
	String patient_name = "";
	String gender = "";
	String visit_type_desc = "";
	String reason_for_contact = "";
	String no_of_slots = "";
	String selected_appt = "";
	String from_srl_no = "";
	String total_to_srl_no = "";
	String available_total_slots = "";
	String available_first_visit_slots = "";
	String available_other_visit_slots = "";

	try {
		con = ConnectionManager.getConnection(request);

		String locale = (String) session.getAttribute("LOCALE");
		String fac_id = (String) session.getValue("facility_id");
		String curr_user_id = (String) session.getValue("login_user");

		JSONObject userJson = new JSONObject();
		JSONArray userListArr = new JSONArray();
		userJson = eSM.SMCommonBean.getUserSessionDetails(con,
				curr_user_id);
		userListArr = (JSONArray) userJson.get("userListArr");

		for (int j = 0; j < userListArr.size(); j++) {
			JSONObject jsonDtls = (JSONObject) userListArr.get(j);
			workstation_id = (String) jsonDtls.get("WORKSTATION");
		}
		if (workstation_id == null)
			workstation_id = "";
		if (workstation_id == "")
			workstation_id = "DFLTWSNO";

		String locn_type = request.getParameter("locn_type");
		if (locn_type == null)
			locn_type = "";

		String from_speciality = request
				.getParameter("from_speciality");
		if (from_speciality == null)
			from_speciality = "";

		String from_locn = request.getParameter("from_locn");
		if (from_locn == null)
			from_locn = "";

		String from_resc = request.getParameter("from_resc");
		if (from_resc == null)
			from_resc = "";

		String from_date = request.getParameter("from_date");
		if (from_date == null)
			from_date = "";

		String from_res_class = request.getParameter("from_res_class");
		if (from_res_class == null)
			from_res_class = "";

		String to_speciality = request.getParameter("to_speciality");
		if (to_speciality == null)
			to_speciality = "";

		String to_locn = request.getParameter("to_locn");
		if (to_locn == null)
			to_locn = "";

		String to_resc = request.getParameter("to_resc");
		if (to_resc == null)
			to_resc = "";

		String to_date = request.getParameter("to_date");
		if (to_date == null)
			to_date = "";

		String to_res_class = request.getParameter("to_res_class");
		if (to_res_class == null)
			to_res_class = "";

		String reason_code_revision = request
				.getParameter("reason_code_revision");
		if (reason_code_revision == null)
			reason_code_revision = "";

		String visit_limit_rule = request
				.getParameter("visit_limit_rule");
		if (visit_limit_rule == null)
			visit_limit_rule = "N";

		String from_selected_appt = request
				.getParameter("from_selected_appt");
		if (from_selected_appt == null)
			from_selected_appt = "";

		String selected_appt_arr[] = from_selected_appt.split("\\$");

		String from_serial_no = request.getParameter("from_serial_no");
		if (from_serial_no == null)
			from_serial_no = "";

		String from_serial_no_arr[] = from_serial_no.split("\\$");

		JSONObject CntjsonObj = getSlotsCount(con, fac_id, locn_type,
				to_locn, to_res_class, to_resc, to_date);

		String time_table_type = (String) CntjsonObj
				.get("time_table_type");
		String slot_appt_ctrl = (String) CntjsonObj
				.get("slot_appt_ctrl");
		String max_slots_per_day = (String) CntjsonObj
				.get("max_slots_per_day");
		String max_patients_per_day = (String) CntjsonObj
				.get("max_patients_per_day");
		String max_first_visits = (String) CntjsonObj
				.get("max_first_visits");
		String max_other_visits = (String) CntjsonObj
				.get("max_other_visits");
		String total_slots_booked = (String) CntjsonObj
				.get("total_slots_booked");
		String total_first_visit = (String) CntjsonObj
				.get("total_first_visit");
		String total_other_visits = (String) CntjsonObj
				.get("total_other_visits");
		String total_first_visits_blocked = (String) CntjsonObj
				.get("total_first_visits_blocked");
		String total_other_visits_blocked = (String) CntjsonObj
				.get("total_other_visits_blocked");

		if (time_table_type.equals("1") && slot_appt_ctrl.equals("P")) {
			total_slots_booked = String.valueOf(Integer
					.parseInt(total_first_visit)
					+ Integer.parseInt(total_other_visits)
					+ Integer.parseInt(total_first_visits_blocked)
					+ Integer.parseInt(total_other_visits_blocked));
		}

		total_first_visit = String.valueOf(Integer
				.parseInt(total_first_visit)
				+ Integer.parseInt(total_first_visits_blocked));
		total_other_visits = String.valueOf(Integer
				.parseInt(total_other_visits)
				+ Integer.parseInt(total_other_visits_blocked));

		if (time_table_type.equals("1") && slot_appt_ctrl.equals("S")) {
			available_total_slots = String.valueOf(Integer
					.parseInt(max_slots_per_day)
					- Integer.parseInt(total_slots_booked));
		} else {
			available_total_slots = String.valueOf(Integer
					.parseInt(max_patients_per_day)
					- Integer.parseInt(total_slots_booked));
		}

		available_first_visit_slots = String.valueOf(Integer
				.parseInt(max_first_visits)
				- Integer.parseInt(total_first_visit));
		available_other_visit_slots = String.valueOf(Integer
				.parseInt(max_other_visits)
				- Integer.parseInt(total_other_visits));

            _bw.write(_wl_block9Bytes, _wl_block9);

	if (!visit_limit_rule.equals("N")) {

            _bw.write(_wl_block10Bytes, _wl_block10);

		if (time_table_type.equals("1")
						&& slot_appt_ctrl.equals("S")) {
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		} else {
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		if (time_table_type.equals("1")
						&& slot_appt_ctrl.equals("S")) {
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(max_slots_per_day));
            _bw.write(_wl_block12Bytes, _wl_block12);

		} else {
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(max_patients_per_day));
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(max_first_visits));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(max_other_visits));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(total_slots_booked));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(total_first_visit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(total_other_visits));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

	JSONArray ArrJSONSch = new JSONArray();
		ArrJSONSch = getToSchedule(con, fac_id, locn_type, to_locn,
				to_res_class, to_resc, to_date);

		for (int i = 0; i < ArrJSONSch.size(); i++) {
			JSONObject jsonObjSch = (JSONObject) ArrJSONSch.get(i);

			srl_no = (String) jsonObjSch.get("srl_no");
			total_to_srl_no += srl_no + "$";
			slot_slab_start_time = (String) jsonObjSch
					.get("slot_slab_start_time");
			slot_slab_end_time = (String) jsonObjSch
					.get("slot_slab_end_time");

			if (!from_selected_appt.equals("")
					&& selected_appt_arr.length > init) {
				selected_appt = selected_appt_arr[i];
				from_srl_no = from_serial_no_arr[i];
				selected_appt_cnt++;
			} else {
				selected_appt = "";
				from_srl_no = "";
			}

			if (!selected_appt.equals("")) {
				JSONObject jsonObj = getApptDtls(con, locale, fac_id,
						selected_appt);

				patient_id = (String) jsonObj.get("patient_id");

				if (patient_id.equals("")) {
					patient_id = "";
				} else {
					patient_id = patient_id + ", ";
				}

				patient_name = (String) jsonObj.get("patient_name");
				gender = (String) jsonObj.get("gender");
				visit_type_desc = (String) jsonObj
						.get("visit_type_desc");
				reason_for_contact = (String) jsonObj
						.get("reason_for_contact");
				no_of_slots = (String) jsonObj.get("no_of_slots");
			} else {
				patient_id = "";
				patient_name = "";
				gender = "";
				visit_type_desc = "";
				reason_for_contact = "";
				no_of_slots = "";
			}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slot_slab_start_time));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(slot_slab_start_time));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(slot_slab_end_time));
            _bw.write(_wl_block31Bytes, _wl_block31);

			if (!patient_name.equals("")) {
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block34Bytes, _wl_block34);

			} else {
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
		
            _bw.write(_wl_block37Bytes, _wl_block37);

			if (!visit_type_desc.equals("")) {
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(visit_type_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

			} else {
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
		
            _bw.write(_wl_block37Bytes, _wl_block37);

			if (!reason_for_contact.equals("")) {
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reason_for_contact));
            _bw.write(_wl_block34Bytes, _wl_block34);

			} else {
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(from_srl_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(init));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(init));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slot_slab_start_time));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(init));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slot_slab_end_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(init));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(selected_appt));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(init));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(init));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block53Bytes, _wl_block53);

	init++;
		}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(selected_appt_cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_locn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(from_resc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(to_locn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(to_resc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(to_res_class));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(reason_code_revision));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(curr_user_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(workstation_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(available_total_slots));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(available_first_visit_slots));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(available_other_visit_slots));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(total_to_srl_no));
            _bw.write(_wl_block71Bytes, _wl_block71);

	} catch (Exception es) {
		es.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block72Bytes, _wl_block72);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Slot.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firstvisit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.othervisit.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
