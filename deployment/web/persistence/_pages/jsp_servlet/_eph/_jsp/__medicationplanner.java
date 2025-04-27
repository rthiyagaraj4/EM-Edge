package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationplanner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationPlanner.jsp", 1709120955900L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<style type=\"text/css\">\n\t\tTEXTAREA{\n\t\t\t  COLOR:black;\n\t\t\t  background-color:#FFFFFF;\n\t\t\t  FONT-SIZE: 8pt;\n\t\t\t  Font-Family : verdana;\n\t\t\t  TEXT-ALIGN: LEFT;\n\t\t\t}\n\t\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form action=\"\" name=\"formMedicationPlanner\" id=\"formMedicationPlanner\" method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table cellpadding=\"0\" cellspacing=\"1\" width=\"99%\" align=\"center\" border=\"0\">\n\t\t<tr>\n\t\t<td>\n\t\t<table cellpadding=\"0\" cellspacing=\"1\" width=\"25%\" align=\"center\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" id=\"Hospname\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" id=\"facility_displocn\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" id=\"mediplan\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<label  class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</label>&nbsp;\n\t\t\t<select name=\"sel_Language\" id=\"sel_Language\" onChange=\'enablelocale(this.value)\'>\n\t\t\t\t<option value=\"\" selected>---";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="---</option>\n\t\t\t\t<option value=\"en\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</select>\n\t\t\n\t\t<div id=\"table_locale_eng\" style=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<br>\n\t\t<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"30%\">Patient ID : ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\"label\" width=\"50%\">Patient Name : ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td class=\"label\" width=\"20%\">Dispensing Date : ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t<thead>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Select</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >No.</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Drug Name</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Qty Issue&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >How To Take</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Morning</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Afternoon</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Evening</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Night</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Important Notes</th>\n\t\t\t</thead>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<tr>\n\t\t\t\t<td align=\"center\" width=\"3%\"><input type=\"checkbox\" name=\"chkdrug\" id=\"chkdrug\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onClick=\"selectDrug(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',this,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"/></td>\n\t\t\t\t<td  align=\"center\" width=\"2%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td align=\"left\" width=\"13%\" class=\"label\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;</td>\n\t\t\t\t<td align=\"center\" width=\"8%\" ><input type=\"text\" size=\"15\" name=\"txt_qty\" id=\"txt_qty\" maxlength=\"40\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onBlur=\"makeValidString(this)\"/>&nbsp;</td><!-- Changed hshtemp.get(\"qty_issue\") to qty_issue for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone) -->\n\t\t\t\t<td align=\"center\" width=\"19%\" class=\"label\"><textarea rows=\"3\" cols=\"40\" name=\"txt_howtotake\" maxlength=\"1500\" onKeyPress=\"return checkMaxLimit(this,1500);\" onChange=\"checkMaxLimit_textarea(this,1500,\'How To Take\');makeValidString(this)\" title=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</textarea></td>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_morning\" id=\"txt_morning\" maxlength=\"150\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_afternoon\" id=\"txt_afternoon\" maxlength=\"150\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_evening\" id=\"txt_evening\" maxlength=\"150\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_night\" id=\"txt_night\" maxlength=\"150\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_morning\" id=\"txt_morning\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_afternoon\" id=\"txt_afternoon\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_evening\" id=\"txt_evening\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_night\" id=\"txt_night\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<td align=\"center\" width=\"23%\"><textarea rows=\"3\" cols=\"40\" name=\"txt_imp_note\" maxlength=\"1500\" onKeyPress=\"return checkMaxLimit(this,1500);\" onChange=\"checkMaxLimit_textarea(this,1500,\'Imp Notes\');makeValidString(this)\" title=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</textarea></td>\n\t\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\"medplanid\" id=\"medplanid\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"pres_drug_code\" id=\"pres_drug_code\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"disp_drug_code\" id=\"disp_drug_code\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curr_disp_yn\" id=\"curr_disp_yn\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"merged_yn\" id=\"merged_yn\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"merged_med_plan_id\" id=\"merged_med_plan_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"disp_no\" id=\"disp_no\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"disp_srl_no\" id=\"disp_srl_no\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"drug_name\" id=\"drug_name\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"/>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\t\n\t\t</table>\n\t\t<br>\n\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"60%\" align=\"right\" border=\"1\">\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'10%\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</th>\n\t\t\t\t<td class=\'label\'width=\'10%\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</th>\n\t\t\t\t<td class=\'label\' width=\'10%\' style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t   <td class=\'label\'  style=\'TEXT-ALIGN:right;\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t   <td  class=\'label\'  style=\'TEXT-ALIGN:right;\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" : ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t</table>\n\t\t</table>\n\t\t</div>\n\t\t<div id=\"table_locale_loc\" style=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<br>\n\t\t<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"30%\">No.Pendaftaran : ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t<td class=\"label\" width=\"50%\">Nama Pesakit : ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t<td class=\"label\" width=\"20%\">Tarikh Pemberian : ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t<thead>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Memilih</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >No.</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Nama Ubat Awda</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Kuantiti Dibekalkan&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Cara Penggunaan</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Pagi</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Tengah Hari</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Petang</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Malam</th>\n\t\t\t\t<th class=\"COLUMNHEADER\" >Nota Penting</th>\n\t\t\t</thead>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onBlur=\"makeValidString(this)\"/></td><!-- Changed hshtemp.get(\"qty_issuelocal\") to qty_issuelocal for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone) -->\n\t\t\t\t<td align=\"center\" width=\"19%\" class=\"label\"><textarea rows=\"3\" cols=\"40\" name=\"txt_howtotake\" maxlength=\"1500\" onKeyPress=\"return checkMaxLimit(this,1500);\" onChange=\"checkMaxLimit_textarea(this,1500,\'How To Take\');makeValidString(this)\" title=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</textarea></td>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_morning\" id=\"txt_morning\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_afternoon\" id=\"txt_afternoon\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_evening\" id=\"txt_evening\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t\t<td align=\"center\" width=\"8%\"><input type=\"text\" size=\"15\" name=\"txt_night\" id=\"txt_night\" maxlength=\"150\" value=\"\" onBlur=\"makeValidString(this)\"/></td>\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t<td align=\"center\" width=\"23%\"><textarea rows=\"3\" cols=\"40\" name=\"txt_imp_note\" maxlength=\"1500\" onKeyPress=\"return checkMaxLimit(this,1500);\" onChange=\"checkMaxLimit_textarea(this,1500,\'Imp Notes\');makeValidString(this)\" title=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\t\n\t\t</table>\n\t\t<br>\n\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\">Jumlah Harga Ubat : ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t<br>\n\t\t<table  cellpadding=\"0\" cellspacing=\"0\" width=\"15%\" align=\"right\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<td><input type=\"button\" id=\"btnActive\" value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' class=\"button\" onClick=\"callActiveOrders_Plan(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\',\'\',\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\');\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<td style=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"tdMerge\"><input type=\"button\" id=\"btnMerge\" value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' class=\"button\" onClick=\"callMergeMedPlan(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\');\"/></td>\n\t\t\t\t<td style=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"tdMergeLocal\"><input type=\"button\" id=\"btnMergeLocal\" value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\');\"/></td><!-- // Added for [IN:051822] -->\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t<td><input type=\"button\" id=\"btnPrint\" value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' class=\"button\" onClick=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="recordMediPlan(\'Print\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="window.close()";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t<td><input type=\"button\" id=\"btnOk\" value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="recordMediPlan(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"/></td>\n\t\t\t\t<td><input type=\"button\" id=\"btnCancel\" value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' class=\"button\" onClick=\"doCancel()\"/></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"/>\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"/>\n\t\t<input type=\"hidden\" name=\"disp_loc_code\" id=\"disp_loc_code\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"/>\n\t\t<input type=\"hidden\" name=\"link\" id=\"link\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"/>\n\t\t<input type=\"hidden\" name=\"mergecount_primary\" id=\"mergecount_primary\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"/>\n\t\t<input type=\"hidden\" name=\"mergecount_local\" id=\"mergecount_local\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t<input type=\"hidden\" name=\"strname\" id=\"strname\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/>\n\t\t<input type=\"hidden\" name=\"strnamelocal\" id=\"strnamelocal\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/>\n\t\t<input type=\"hidden\" name=\"facility_disp\" id=\"facility_disp\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"/>\n\t\t<input type=\"hidden\" name=\"facility_displocal\" id=\"facility_displocal\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"/>\n\t</form>\n\t</body>\n\t<script type=\"text/javascript\">\n\tloadHeader(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\');\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n</html>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        Connection con = null; // Added for ML-BRU-CRF-0469 [IN:065426]
	try {
		String qty_issue = "";//added for ML-BRU-SCF-1521.1 [IN:055331]
		String qty_issuelocal = "";//added for ML-BRU-SCF-1521.1 [IN:055331]
		String qty_issue_prop="";//added for ML-BRU-SCF-1795
		String qty_issue_proplocal="";//added fot ML-BRU-SCF-1795
		Boolean mp_flag = false;//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String[] uom;//added for ML-BRU-SCF-1521.1 [IN:055331]
		String[] uom1;//ML-BRU-SCF-1781
		String[] uom_local;//added for ML-BRU-SCF-1521.1 [IN:055331]
		String tmpOrdId = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String dispNosOrder = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String tempDispNos = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
		String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
		String facility_id = (String) session.getValue("facility_id");
		String med_plan_check = CommonBean.checkForNull(request.getParameter("med_plan_check"));
		String mediplan_seq_no = CommonBean.checkForNull(request.getParameter("mediplan_seq_no"));
		String sel_lang = request.getParameter("sel_lang");
		String locale_eng = "display:none",locale_loc="display:none",langid="",called_from="";
		String sDefaultEnglish="selected",sDefaultLocLang="",localLang="",displayStyle="display:none",displayStyleLocal="display:none";
		ArrayList orderIdList = new ArrayList();//added for ML-BRU-SCF-1521.1 [IN:055331] 
		DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
		DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
		String medplan_bean_id="MedicationPlannerBean";
		String medplan_bean_name="ePH.MedicationPlannerBean";
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request); 
		medplan_bean.setObject(dispBean);
		medplan_bean.setObject(all_bean);
		medplan_bean.setLanguageId(locale);
		con = ConnectionManager.getConnection(request); // Added for ML-BRU-CRF-0469 [IN:065426] - Start
		boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); // Added for ML-BRU-CRF-0469 [IN:065426] - End
		
		if(med_plan_check.equals("Y")){
			 called_from = "printDialog";
			 if(((ArrayList)medplan_bean.getMediPlanSeqNo()).size()>0)
			 	mediplan_seq_no = (String)((ArrayList)medplan_bean.getMediPlanSeqNo()).get(0);
		}
		String  strarrKey[] = new String[4];
		String disp_stage = dispBean.getDispStage();
		ArrayList disp_nos = all_bean.getDispNos();//added for ML-BRU-SCF-1521.1 [IN:055331]
		String sysdate = dispBean.getTodaysDate();
		if(sysdate.equals(""))
			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
		String patient_class = dispBean.getPatientclass();
		ArrayList langIdName = all_bean.getDefLangForLabel(patient_class);
		if(sel_lang!=null){
			langid = sel_lang;
			if(sel_lang.equals("en")){
				langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
				locale_eng 			= "display:inline";
				sDefaultEnglish		=	"selected";
				sDefaultLocLang		=	"";
			}
			else{
				langIdName = all_bean.getLangNameAndId(sel_lang);
				locale_loc 			= "display:inline";
				sDefaultEnglish		=	"";
				sDefaultLocLang		=	"selected";
			}
		}
		else{
			if(langIdName==null || langIdName.size()==0 ){ 
				if(!locale.equals("en") ){
					langIdName = all_bean.getLangNameAndId(locale);
					locale_loc 	= "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
				else{
					langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
					locale_eng = "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
			}
			else { 
				if(((String)langIdName.get(0)).equals("en")){
					locale_eng = "display:inline";
					langid		= (String)langIdName.get(0);
					langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
				else{
					locale_loc 	= "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
			}
		}
		int count[] = {0,0,0,0,0};
		ArrayList<String> mediplan_report_query=medplan_bean.getMediplan_report_query();
		if(medplan_bean.getStrCalledFrom().equals("Report") && !mediplan_report_query.get(6).equals("D")){
				count[0]=0;
				count[1]=0;
				count[2]=Integer.parseInt(mediplan_report_query.get(1));
				count[3]=0;
				count[4]=Integer.parseInt(mediplan_report_query.get(1));
		}	
		else
			count = medplan_bean.getCountActiveDrugs(patient_id,medplan_bean.getStrCalledFrom());
		if(called_from.equals("printDialog"))//if else Added for [IN:051482]
			medplan_bean.setMediplanDetails(medplan_bean.getMedOrderIds(),patient_id);
		else if(!medplan_bean.isMedValuesChanged())
				medplan_bean.setMediplanDetails(medplan_bean.getMedOrderIds(),patient_id);
		if(medplan_bean.getStrCalledFrom().equals("Report"))
			medplan_bean.getTotalPrice_Report(mediplan_report_query.get(1),mediplan_report_query.get(0),mediplan_report_query.get(4),mediplan_report_query.get(5));
		LinkedHashMap hshDrugMap = medplan_bean.getMedPlan_DrugDetails();
		Set <String> hshKeys = new HashSet<String>();
		hshKeys = hshDrugMap.keySet();
		LinkedHashMap hshtemp = new LinkedHashMap();
		int i=0,totalrecords=0; 
		for(String key:hshKeys){//added for ML-BRU-SCF-1521.1 [IN:055331] Start
			strarrKey = key.split("_");
			orderIdList.add(strarrKey[0]);
		}
		if(disp_nos!=null){
			for(int q=0;q<disp_nos.size();q++){
				String ordId= all_bean.getOrderIdForDisp((String)disp_nos.get(q),disp_stage);
				for(int h=0;h<orderIdList.size();h++){
					if(((String)orderIdList.get(h)).equals(ordId)){
						tmpOrdId = ordId+"-"+disp_nos.get(q);
						orderIdList.set(h,tmpOrdId);
					}
				}
			}
		} //added for ML-BRU-SCF-1521.1 [IN:055331] End

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sDefaultEnglish));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

				if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
					localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(langIdName.get(0)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sDefaultLocLang));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(localLang));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale_eng));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dispBean.getPatient_name(patient_id,medplan_bean.getStrPrimaryLangID())));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block19Bytes, _wl_block19);
			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshtemp = (LinkedHashMap)hshDrugMap.get(key);
					uom = new String[2];//ML-BRU-SCF-1781
					strarrKey = key.split("_");
//					uom1 = ((String)hshtemp.get("qty_issue")).split(" ");//added for ML-BRU-SCF-1521.1 [IN:055331] and changed uom to uom1 for ML-BRU-SCF-1781
					if(((String)hshtemp.get("qty_issue")).indexOf(" ")!=-1){//if condition added for ML-BRU-SCF-1781
						uom1 = ((String)hshtemp.get("qty_issue")).split(" ");
					
						if(uom1.length>1)
							uom[1] = uom1[1];
						else
							uom[1] = "";
					}
					else
						uom[1] ="";
					/*if(uom.length>1)//commented for ML-BRU-SCF-1781
						uom[1] = uom[1];
					else
						uom[1] = "";*/
					i++;totalrecords++;
					if(hshtemp.get("medicationplanner_flag")!=null)//added for ML-BRU-SCF-1521.1 [IN:055331] Start
						mp_flag = Boolean.parseBoolean((String)hshtemp.get("medicationplanner_flag"));
					if(mp_flag){
						qty_issue = (String)hshtemp.get("qty_issue");
						qty_issue_prop=qty_issue;//ADDED FOR ML-BRU-SCF-1795
					}
					else{
						   qty_issue = all_bean.getDrugQuantity(patient_id, strarrKey[0], strarrKey[1]);
						
						if(qty_issue==""||qty_issue==null || qty_issue.equals("0")){ // || qty_issue.equals("0") added for ML-BRU-SCF-1851
							int ordLen = strarrKey[0].length();
							for(int j=0;j<orderIdList.size();j++){
								tempDispNos  = (String)orderIdList.get(j);
								if(tempDispNos.length()!= strarrKey[0].length()){
									tempDispNos =tempDispNos.substring(0,ordLen);
									if(tempDispNos.equals(strarrKey[0])){
										dispNosOrder = ((String)orderIdList.get(j)).substring(ordLen+1,((String)orderIdList.get(j)).length());
										qty_issue = all_bean.getDispQuantity(dispNosOrder,strarrKey[0], strarrKey[1],disp_stage,"N","");//"N","" added for ML-BRU-SCF-1714
									}
								}
							}
						}
						if(qty_issue.equals("")){//added for ML-BRU-SCF-1795
							qty_issue="0.0";
						}
						qty_issue_prop=qty_issue;//ADDED FOR ML-BRU-SCF-1795
						qty_issue = qty_issue+" "+uom[1];
					}//added for ML-BRU-SCF-1521.1 [IN:055331] End

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)hshtemp.get("checked") ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)hshtemp.get("chkdrug")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strarrKey[0]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strarrKey[1]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strarrKey[2]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalrecords-1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)hshtemp.get("drug_name")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(qty_issue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)hshtemp.get("howtotake")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)hshtemp.get("howtotake")));
            _bw.write(_wl_block30Bytes, _wl_block30);

				if(!qty_issue_prop.equals("0.0") && !qty_issue_prop.equals("") && !qty_issue_prop.equals("0")  ){ //added for ml-bru-scf-1795
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)hshtemp.get("morning")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)hshtemp.get("afternoon")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)hshtemp.get("evening")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)hshtemp.get("night")));
            _bw.write(_wl_block35Bytes, _wl_block35);
} else { 
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)hshtemp.get("impnote")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)hshtemp.get("impnote")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("med_plan_id"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strarrKey[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strarrKey[1]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)hshtemp.get("pres_drug_code")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strarrKey[2]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)hshtemp.get("curr_disp_yn")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)hshtemp.get("merge_yn")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("merged_med_plan_id"))));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("disp_no"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("disp_srl_no"))));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strarrKey[3]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)hshtemp.get("drug_name")));
            _bw.write(_wl_block50Bytes, _wl_block50);
				}
			}

            _bw.write(_wl_block51Bytes, _wl_block51);
if(displayGrossAmtYn){ // if else condition Added for ML-BRU-CRF-0469 [IN:065426], below 3 total labels Added for same ML-BRU-CRF-0469  - Start 
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_amount()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(medplan_bean.getstrTotal_charge_amount()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_charge_amount()));
            _bw.write(_wl_block58Bytes, _wl_block58);
} else{  
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_charge_amount()));
            _bw.write(_wl_block61Bytes, _wl_block61);
}  // if else condition Added ML-BRU-CRF-0469 [IN:065426] - End
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale_loc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dispBean.getPatient_name(patient_id,medplan_bean.getStrLocalLangID())));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block66Bytes, _wl_block66);
				hshDrugMap = medplan_bean.getMedPlan_Local_DrugDetails();
				hshKeys = hshDrugMap.keySet();
				if(hshKeys!=null && hshKeys.size()>0){
				i=0;
				for(String key:hshKeys){
					hshtemp = (LinkedHashMap)hshDrugMap.get(key);
					uom_local = new String[2];
					strarrKey = key.split("_");
					//uom_local = ((String)hshtemp.get("qty_issue")).split(" ");
					if(((String)hshtemp.get("qty_issuelocal")).indexOf(" ")!=-1){//if condition added for ML-BRU-SCF-1781 modifed for ml-BRU-scf-1885
				
						uom1 = ((String)hshtemp.get("qty_issuelocal")).split(" ");//modifed for ml-BRU-scf-1885
						
						if(uom1.length>1){
							uom_local[1] = uom1[1];
						}
						else{
							uom_local[1] = "";
						}
					}else{
							uom_local[1] = "";
					}

					/*if(uom_local.length>1)//added for ML-BRU-SCF-1521.1 [IN:055331]
						uom_local[1] = uom_local[1];
					else
						uom_local[1] = ""; */
					i++;totalrecords++;
					if(hshtemp.get("medicationplanner_flag")!=null) //added for ML-BRU-SCF-1521.1 [IN:055331] Start
						mp_flag = Boolean.parseBoolean((String)hshtemp.get("medicationplanner_flag"));
					if(mp_flag){
						qty_issuelocal = (String)hshtemp.get("qty_issuelocal");
						qty_issue_proplocal=qty_issuelocal;//ADDED FOR ML-BRU-SCF-1795
					}
					else{
						    qty_issuelocal = all_bean.getDrugQuantity(patient_id, strarrKey[0], strarrKey[1]);
						   
						if(qty_issuelocal==""||qty_issuelocal==null || qty_issuelocal.equals("0")){ // || qty_issuelocal.equals("0") Added for ML-BRU-SCF-1851
							int ordLen = strarrKey[0].length();
							for(int j=0;j<orderIdList.size();j++){
								tempDispNos  = (String)orderIdList.get(j);
								if(tempDispNos.length()!= strarrKey[0].length()){
									tempDispNos =tempDispNos.substring(0,ordLen);
									if(tempDispNos.equals(strarrKey[0])){
										dispNosOrder = ((String)orderIdList.get(j)).substring(ordLen+1,((String)orderIdList.get(j)).length());
										qty_issuelocal = all_bean.getDispQuantity(dispNosOrder,strarrKey[0], strarrKey[1],disp_stage,"N","");//"N","" added for ML-BRU-SCF-1714
									}
								}
							}
						}
						if(qty_issuelocal.equals("")){//added for ML-BRU-SCF-1795
							qty_issuelocal="0.0";
						}
						qty_issue_proplocal=qty_issuelocal;//ADDED FOR ML-BRU-SCF-1795
							qty_issuelocal = qty_issuelocal+" "+uom_local[1];
					} //added for ML-BRU-SCF-1521.1 [IN:055331] End

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)hshtemp.get("checked") ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)hshtemp.get("chkdrug")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strarrKey[0]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strarrKey[1]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strarrKey[2]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalrecords-1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)hshtemp.get("drug_name_local")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(qty_issuelocal));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((String)hshtemp.get("howtotakelocal")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)hshtemp.get("howtotakelocal")));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(!qty_issue_proplocal.equals("0.0") && !qty_issue_proplocal.equals("") &&  !qty_issue_proplocal.equals("0") ){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)hshtemp.get("morninglocal")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)hshtemp.get("afternoonlocal")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)hshtemp.get("eveninglocal")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)hshtemp.get("nightlocal")));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{ 
            _bw.write(_wl_block69Bytes, _wl_block69);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf((String)hshtemp.get("impnotelocal")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)hshtemp.get("impnotelocal")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("med_plan_id"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strarrKey[0]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strarrKey[1]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)hshtemp.get("pres_drug_code")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strarrKey[2]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)hshtemp.get("curr_disp_yn")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)hshtemp.get("merge_yn")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("merged_med_plan_id"))));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("disp_no"))));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)hshtemp.get("disp_srl_no"))));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strarrKey[3]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)hshtemp.get("drug_name_local")));
            _bw.write(_wl_block50Bytes, _wl_block50);
				}
			}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_charge_amount()));
            _bw.write(_wl_block72Bytes, _wl_block72);
 if(count[0]>0 && totalrecords>0){ 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(med_plan_check));
            _bw.write(_wl_block76Bytes, _wl_block76);
 } 
				if(count[1]>0 && totalrecords>0 && langid.equals(medplan_bean.getStrPrimaryLangID()))
					displayStyle = "display:inline";
				else if(count[3]>0 && totalrecords>0 && langid.equals(medplan_bean.getStrLocalLangID()))
					displayStyleLocal = "display:inline";
				
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(displayStyle));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count[2]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(med_plan_check));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(displayStyleLocal));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count[4]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(med_plan_check));
            _bw.write(_wl_block82Bytes, _wl_block82);
 if(med_plan_check.equals("Y")){ 
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
if(totalrecords>0){
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mediplan_seq_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
 } 
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
if(totalrecords>0){
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mediplan_seq_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dispBean.getDispLocnCode()));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(langid));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count[1]));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count[3]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(medplan_bean.getStrSiteName()));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(medplan_bean.getStrSiteNameLocal()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(medplan_bean.getStrFacility_DispLoc()));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(medplan_bean.getStrFacility_DispLocLocal()));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(langid));
            _bw.write(_wl_block104Bytes, _wl_block104);
  putObjectInBean(medplan_bean_id,medplan_bean,request);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
           finally{ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
        	   if(con != null){
        	    ConnectionManager.returnConnection(con,request);
        	   }
           }  // Added for ML-BRU-CRF-0469 [IN:065426] - End
		
            _bw.write(_wl_block105Bytes, _wl_block105);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SelectLanguage.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.English.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Price.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MergeMedicationPlan.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MergeMedicationPlan.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }
}
