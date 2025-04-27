package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eOR.*;
import eOR.Common.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __oncologyregimenfluiddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenFluidDetail.jsp", 1709120987954L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../js/DrugNameCommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../js/OncologyRegimen.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- <body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\"oncologyRegimenFluidDetail\" id=\"oncologyRegimenFluidDetail\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\" style=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\n\t \n\t\n\t<th colspan=\"5\"><font style=\"font-size:9\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></th>\n\t<tr >\n\t\t<td width=\"30%\"  class=\"label\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;\n\t\t\t<input type=\"hidden\" name=\"fluid_code\" id=\"fluid_code\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<input type=\"text\" name=\"fluid_name\" id=\"fluid_name\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" size=\"30\" maxlength=\"40\" onBlur=\"checkValidDrug(\'F\', this.value,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" ><input type=\"button\" class=\"button\" name=\"fluid_search\" id=\"fluid_search\" VALUE=\"?\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  onClick=\"searchIVFluid(\'D\', fluid_name,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" border=\"0\"></img>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\"></img>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</td>\n        <td class=\"label\" width=\"10%\">\n\t\t\t<A HREF title=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onMouseOver=\"changeCursor(this);\" onClick=\"fluidRemarks();\" style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\'remarks\'>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</A>&nbsp;<img style=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"mandatory1\" src=\"../../eCommon/images/mandatory.gif\" ></img></td>\n\n\t\t<td width=\"20%\" class=\"label\" nowrap id=\"DfltVolume\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;\n\t\t\n\t\t\t<input type=\"hidden\" name=\"stock_uom_code\" id=\"stock_uom_code\" value=\"\">\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t\t<input type=\"text\" class=\"number\" name=\"stock_value\" id=\"stock_value\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" size=\"2\" maxlength=\"4\"  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\t<!-- disabled removed for MMS-KH-SCF-0060 -->\t\n\t\t\t<label  width=\'5%\'class=\'label\' id=\"stock_uom\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</label> \n\t\t\t\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\"2\" maxlength=\"4\" >\n\t\t\t<select name=\"stock_uom\" id=\"stock_uom\" > \n\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>\n\t\t\t</select>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" border=\"0\"></img>\n\t\t</td><!--ML-MMOH-CRF-1014 - start-->\n\t\t<td class=\"label\" width=\"30%\" id=\"MFR_YN\"> \n\t\t\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t<input type=\"checkbox\" name=\"MFR_YN_chk\" id=\"MFR_YN_chk\" onClick=\"assignMfrValueforOngo(this);\" value=\"\"  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" >\n\t\t\t<a href=\"#\"  title =\'Multiple Flow Rate\' onMouseOver=\"changeCursor(this);\" onClick=\"javascript:showMultipleFlowRate(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" id=\'ongomfrLink\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a>\n\n   ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<input type=\"checkbox\" name=\"MFR_YN_chk\" id=\"MFR_YN_chk\" onClick=\"assignMfrValueforOngo(this);\" value=\"\"  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\t\t<input type=\"checkbox\" name=\"MFR_YN_chk\" id=\"MFR_YN_chk\" onClick=\"\" value=\"\" >\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t   \n\t\t\t   \n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t      \t <img src=\"../../eCommon/images/enabled.gif\"  id=\'MFR_Indicator\'>\n\t\t\t\t\t \n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<img src=\"../../eCommon/images/disabled.gif\"  id=\'MFR_Indicator\'>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n             <br> <label class=\"label\" ><a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"  id=\'mfrRemarksLink\' style=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" title=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</label></a></br>   <!--ML-MMOH-CRF-1014 and title added for 1014- end-->\n\t\t</td>\n\t</tr>\n\t\n\t</table>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t<table cellpadding=\"1\" cellspacing=\"1\" width=\"100%\" align=\"center\" border=\"0\" >\t\n\t\t<tr height=\'40\'><td class=\"label\" colspan=\'5\' >&nbsp;&nbsp;&nbsp;</td></tr>    \n\t\t</table>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t<input type=\"hidden\" name=\"def_inf_prd\" id=\"def_inf_prd\"\t   value=\"\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"  value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t   value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t   value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t   value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"   value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\"value=\"\">\n\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\"\t   value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\"     value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"base_uom\" id=\"base_uom\"       value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\"      value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"fluid_remarks\" id=\"fluid_remarks\"  value=\"0\"\t>\n\t<input type=\"hidden\" name=\"params\" id=\"params\"         value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\t>\n\t<input type=\"hidden\" name=\"serialNum\" id=\"serialNum\"      value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\t\n\t<input type=\"hidden\" name=\"infuseovervalue\" id=\"infuseovervalue\"value=\"\"\t>\n\t<input type=\"hidden\" name=\"infuseoverdurntype\" id=\"infuseoverdurntype\" value=\"\">\t\t\n\t<input type=\"hidden\" name=\"stock_uom_val\" id=\"stock_uom_val\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"default_fluid_changed\" id=\"default_fluid_changed\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"default_fluid_name\" id=\"default_fluid_name\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n    <input type=\"hidden\" name=\"fluid_frame_display_yn\" id=\"fluid_frame_display_yn\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"mfr_remarks\" id=\"mfr_remarks\" value=\"\"><!--ML-MMOH-CRF-1014 -->\n\t<input type=\"hidden\" name=\"default_stock_val\" id=\"default_stock_val\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" ><!--ML-MMOH-CRF-1014 -->\n\n\t\n\t\n\t\n</form>\n</body>\n ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t<script>\n\t\t\t\tdefaultIVFluid(";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =");\n\t\t\t\tif(document.oncologyRegimenFluidDetail.MFR_YN_chk!=undefined){\n\t\t\t\t\tdocument.oncologyRegimenFluidDetail.MFR_YN_chk.disabled = true;\n\t\t\t\t\tif(document.oncologyRegimenFluidDetail.ongomfrLink)\n\t\t\t\t\tdocument.oncologyRegimenFluidDetail.ongomfrLink.disabled=true;\n\t\t\t\t}\n\n\t\t\t</script>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<script>\n\t\t\t\tif(document.oncologyRegimenFluidDetail.MFR_YN_chk!=undefined){\n\t\t\t\t\tdocument.oncologyRegimenFluidDetail.MFR_YN_chk.disabled = true;\n\t\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n<script>\n\t//alert(\"339\");\ngetDefaultMFRvalue(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\');\t\n\n</script>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t <script>\n\t\t\tvar infuseovervalue=document.oncologyRegimenFluidDetail.infuseovervalue.value;\n\t\t\tvar  infuseoverdurntype=document.oncologyRegimenFluidDetail.infuseoverdurntype.value;\n\t\t\tvar  stock_uom_val=document.oncologyRegimenFluidDetail.stock_uom_val.value;\t\n\t\t\t\n\t\tparent.oncology_admin.location.href=\"../jsp/OncologyRegimenAdminDetail.jsp?";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"+\"&serial_no=\"+\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'+\"&comp_freq_code=\"+\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'+\"&comp_durn_value=\"+\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'+\"&comp_durn_type=\"+\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'+\"&start_date=\"+\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'+\"&fluid_frame_display_yn=\"+\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'+\"&infuseovervalue=\"+infuseovervalue+\"&infuseoverdurntype=\"+infuseoverdurntype+\"&stock_uom_val=\"+stock_uom_val+\"&amend_serial_no=\"+\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'+\"&MAR_app_yn=\"+\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'+\"&mfr_yn_value=\"+\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\';//MFR added for CRF-1004\n\t\t  \n\t\t </script>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\n</html>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //String locale			= (String)session.getAttribute("LOCALE");
	   	String facility_id					= (String) session.getValue("facility_id");
 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("encounter_id");
	String patient_class			= request.getParameter("act_patient_class");
	String params					= request.getQueryString() ;
	String serialNum				= request.getParameter("serial_no") == null ? "":request.getParameter("serial_no");	
	String amend_serial_no          = request.getParameter("amend_serial_no") == null ? "":request.getParameter("amend_serial_no");
	String MAR_app_yn               = request.getParameter("MAR_app_yn") == null ? "":request.getParameter("MAR_app_yn");
	String fluid_frame_display_yn	= request.getParameter("fluid_frame_display_yn") == null ? "Y":request.getParameter("fluid_frame_display_yn");
	String start_date				= request.getParameter("start_date");
	
	String bean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name				= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
	//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	//String or_bean_name				= "eOR.OrderEntryBean";
//	OrderEntryBean ORbean			= (OrderEntryBean)mh.getBeanObject( or_bean_id, request, or_bean_name ) ;
	String amend_fluid_code				= "";
	String amend_fluid_name				= "";
	String amend_stock_value			= "";
	String amend_stock_uom				= "";
	String amend_infusion_period_value	= "";
	String amend_infusion_period_uom	= "";
	String drug_code					= "";
	String iv_fluid_yn					= "";
    String iv_ingredient_yn				= "visibility:visible";
	String visibility					= "visibility:visible";
	String deflt_fluid_form_code		= "";
	String deflt_fluid_route_code       = "";
	String deflt_fluid_pres_base_uom    = "";
	String comp_freq_code				= "";
	String comp_durn_value				= "";
	String comp_durn_type				= "";
	String amend_yn						= "";
	String defaultfluidchanged          ="N";
	String remarks_visible				="visibility:hidden";
	String default_fluid_name           ="";
	String amend_stock_uom_code         ="";
	String order_catalog_code           ="";
	String catalog_desc                 =""; 
	//int    count                        =0;
	String chngd_fluid_remarks          ="";
	String disable_existing             ="";
	String mfr_display                  ="visibility:hidden"; //ML-MMOH-CRF-1014 - start
	String mfr_img_display              = "visible"; 
	HashMap mfr_recs                    = null; 
	String mfr_checked                  = "";
	String mfr_yn_value					= "";
	String ocurrance_num				= "";
	String default_stock_val			= "";
//ML-MMOH-CRF-1014 - end
//added for MMS-KH-SCF-0060 start
      String disabled="diabled";
      boolean enableFluidText				=bean.isSiteSpecific("PH", "ENABLE_FLUID_TEXT");//ADDED FOR MMS-KH-SCF-0060
    		  if(enableFluidText){
    			  disabled=""; 
    		  }
    		//added for MMS-KH-SCF-0060 end
	if(!serialNum.equals(""))
	{
		int srlNo						= 0;
		srlNo							= Integer.parseInt(serialNum);
		ArrayList drugList				= bean.getDrugDetails();
		if(drugList!=null)
		{
			HashMap drugDetails				= (HashMap)drugList.get(srlNo-1);
			
			drug_code						= (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
			iv_fluid_yn						= (String)drugDetails.get("IV_FLUID_YN")==null?"":(String)drugDetails.get("IV_FLUID_YN");
			iv_ingredient_yn				= (String)drugDetails.get("IV_INGREDIENT_YN")==null?"":(String)drugDetails.get("IV_INGREDIENT_YN");
			amend_fluid_code				= (String)drugDetails.get("amend_fluid_code")==null?"":(String)drugDetails.get("amend_fluid_code");
			amend_fluid_name				= (String)drugDetails.get("amend_fluid_name")==null?"":(String)drugDetails.get("amend_fluid_name");
			amend_stock_value				= (String)drugDetails.get("amend_stock_value")==null?"":(String)drugDetails.get("amend_stock_value");
			bean.setdrugCode(drug_code);//ML-MMOH-CRF-1014
			ocurrance_num			        = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");//ML-MMOH-CRF-1014		
			

			default_stock_val = (String)drugDetails.get("default_stock_val")==null?"":(String)drugDetails.get("default_stock_val");

			if(default_stock_val.equals(""))
			default_stock_val = amend_stock_value;
			
			amend_infusion_period_value		= (String)drugDetails.get("amend_infusion_period_value")==null?"":(String)drugDetails.get("amend_infusion_period_value");
			amend_infusion_period_uom		= (String)drugDetails.get("amend_infusion_period_uom")==null?"":(String)drugDetails.get("amend_infusion_period_uom");
			amend_stock_uom					= (String)drugDetails.get("amend_stock_uom")==null?"":(String)drugDetails.get("amend_stock_uom");

            amend_yn	    = (String)drugDetails.get("AMEND_YN"); 

			if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))||(iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y"))||(iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))
	        {
				  visibility="visibility:hidden";
				  //flag      ="hide";
				 
	    	}
			else{
				if(amend_yn.equals("N")){
				  amend_fluid_code		= (String)drugDetails.get("DEFLT_FLUID_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_CODE");
				  amend_fluid_name		= (String)drugDetails.get("DEFLT_FLUID_DESC")==null?"":(String)drugDetails.get("DEFLT_FLUID_DESC");
				  default_fluid_name=amend_fluid_name;
				  deflt_fluid_form_code	= (String)drugDetails.get("DEFLT_FLUID_FORM_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_FORM_CODE");
				  deflt_fluid_route_code= (String)drugDetails.get("DEFLT_FLUID_ROUTE_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_ROUTE_CODE");
				  deflt_fluid_pres_base_uom	= (String)drugDetails.get("DEFLT_FLUID_PRES_BASE_UOM")==null?"":(String)drugDetails.get("DEFLT_FLUID_PRES_BASE_UOM");
				}
				else if(amend_yn.equals("Y")){
                   defaultfluidchanged = (String)drugDetails.get("DefaultFluidchanged");
				   default_fluid_name		= (String)drugDetails.get("DEFLT_FLUID_DESC");
				   amend_stock_uom_code				= (String)drugDetails.get("amend_stock_uom_code");
				 }
			}
			if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))){
				fluid_frame_display_yn="N";
			}

			comp_freq_code		= (String)drugDetails.get("comp_freq_code");
			comp_durn_value	= (String)drugDetails.get("comp_durn_value");
			comp_durn_type		= (String)drugDetails.get("comp_durn_type");
			if(defaultfluidchanged.equals("Y")){
				remarks_visible="visibility:visible";
			}
		}		 
	}

	/*======================amend==========================================*/
		String order_id				= "";

		HashMap Existingrecord;
		String order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
       	String amend_search_yn		= "";
		if(order_type_flag.equals("Existing")) {
			amend_search_yn	= "DISABLED";
		}       
    if(fluid_frame_display_yn.equals("Y")){
		if(order_type_flag.equals("Existing")) {
		//	order_id=request.getParameter("order_id"); 		  
			ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();
			if(!amend_serial_no.equals("")){
				int srlNo					= 0;
				   
					srlNo					= Integer.parseInt(amend_serial_no)+1;
			
			//	if( srlNo <=(getExistingCYTORecords.size()-3)){
					if(!amend_serial_no.equals("")){         
						Existingrecord	        = (HashMap) getExistingCYTORecords.get(srlNo);
						iv_fluid_yn			    = (String)Existingrecord.get("IV_FLUID_YN");
						iv_ingredient_yn		= (String)Existingrecord.get("IV_INGREDIENT_YN");  
						amend_stock_value		= (String)Existingrecord.get("QTY_VALUE");
						amend_stock_uom			= (String)Existingrecord.get("QTY_UNIT");		  
						order_catalog_code      = (String)Existingrecord.get("ORDER_CATALOG_CODE");
						catalog_desc		    = (String)Existingrecord.get("CATALOG_DESC");
						chngd_fluid_remarks     = (String)Existingrecord.get("CHNGD_FLUID_REMARKS");
						order_id				= (String)Existingrecord.get("ORDER_ID");//ML-MMOH-CRF-1014 - start

						if(amend_yn.equals("N")){
							ArrayList getExsitorder =  bean.getExistingOncoIVRecords(order_id); 
						}
					    
						mfr_recs                = new HashMap();
						mfr_recs                = bean.getMFRRecs();
						if(mfr_recs != null && mfr_recs.size() > 0){
						      mfr_display       ="visibility:visible";
							  mfr_img_display   = "";
							  mfr_checked       ="checked";
							  //System.err.println("OncologyRegimenFluidDetail.jsp-----------mfr_recs----------271---->"+mfr_recs);
							  bean.setMFRRecs(mfr_recs);
						} // End//ML-MMOH-CRF-1014 - end

						if((iv_fluid_yn.equals("Y")&& iv_ingredient_yn.equals("N"))){				 
							amend_fluid_name=catalog_desc;
							amend_fluid_code=order_catalog_code;
						}
						else{
							amend_fluid_name="";
						}
					//	count++;
						if(!chngd_fluid_remarks.equals("")){
							remarks_visible="visibility:visible";
							bean.setDefaultFluidremarks(chngd_fluid_remarks);
						 
						}
						disable_existing="disabled";
					}
				//}
			}
		 }
	 }

	if(amend_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start
          mfr_recs               = bean.getMFRRecs();
			if(mfr_recs != null && mfr_recs.size() > 0){
				mfr_display          = "visibility:visible";
				mfr_img_display      = ""; 
				  mfr_checked       ="checked";
			}
        }//ML-MMOH-CRF-1014 - end




/*====================================================================*/ 
	

            _bw.write(_wl_block9Bytes, _wl_block9);

	if(!visibility.equals("visibility:hidden")){
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(visibility));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(amend_fluid_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

			amend_fluid_name=amend_fluid_name.replaceAll(" ","%20");
			amend_fluid_name=java.net.URLEncoder.encode(amend_fluid_name,"UTF-8");//added for REGRATION ISSUE
			amend_fluid_name=amend_fluid_name.replaceAll("%2520","%20");
			
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(amend_fluid_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_existing));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_existing));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(amend_search_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
			if(amend_fluid_code != null && !amend_fluid_code.equals("")){

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(amend_fluid_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
}			else{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_fluid_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(remarks_visible));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(remarks_visible));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

	if (bean.checkForStock()) {
//out.println("asdgajsdh----->  "+amend_stock_value+"  <---");
		

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(amend_stock_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(amend_stock_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);

	}
	else {

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(amend_stock_value));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

	}

            _bw.write(_wl_block37Bytes, _wl_block37);

			boolean site_spec_mfr				= bean.isSiteSpecific("OR", "OR_ORDER_SET");//ML-MMOH-CRF-1014
			if(site_spec_mfr){
			if(!order_type_flag.equals("Existing") ){

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mfr_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(amend_fluid_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
		}else{
			if(mfr_img_display.equals("")){ 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mfr_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(amend_fluid_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
			}else{

            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
		}
			}
			}
System.err.println("mfr_img_display==269s=>"+mfr_img_display);
		 if(mfr_img_display.equals("")) 
			 mfr_yn_value ="Y";
		 else
			 mfr_yn_value ="N";


		System.err.println("mfr_yn_value==274=d>"+mfr_yn_value);
			   if(mfr_img_display.equals("")){
            _bw.write(_wl_block48Bytes, _wl_block48);
					}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
					     } 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

		}
	else{

            _bw.write(_wl_block55Bytes, _wl_block55);

	}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( patient_class ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(deflt_fluid_form_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(deflt_fluid_route_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(deflt_fluid_pres_base_uom));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(params));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(amend_stock_uom_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(defaultfluidchanged));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(default_fluid_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(fluid_frame_display_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(default_stock_val));
            _bw.write(_wl_block72Bytes, _wl_block72);
 
	if(fluid_frame_display_yn.equals("Y")){
		if(amend_yn.equals("N")){

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_type_flag.equals("Existing")));
            _bw.write(_wl_block74Bytes, _wl_block74);

		}else{//ML-MMOH-CRF-1014
			if(amend_yn.equals("Y") && mfr_yn_value.equals("N")){

            _bw.write(_wl_block75Bytes, _wl_block75);
			}
			}
	}

	if(mfr_yn_value.equals("Y") && !amend_yn.equals("Y")&& order_type_flag.equals("Existing")){ // ML-MMOH-CRF-1014-start

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ocurrance_num));
            _bw.write(_wl_block77Bytes, _wl_block77);
}//ML-MMOH-CRF-1014 - end

   if(!serialNum.equals("")){

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(params));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(comp_freq_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(comp_durn_value));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(comp_durn_type));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(fluid_frame_display_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(amend_serial_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(MAR_app_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(mfr_yn_value));
            _bw.write(_wl_block88Bytes, _wl_block88);

	 }

            _bw.write(_wl_block89Bytes, _wl_block89);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FluidDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DfltFldaltrd.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
