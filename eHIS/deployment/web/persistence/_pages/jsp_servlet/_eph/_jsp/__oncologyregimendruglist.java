package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __oncologyregimendruglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenDrugList.jsp", 1709120987250L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t\t<head>\n\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t\t<script language=\"javascript\" src=\"../js/OncologyRegimen.js\"></script>\n\t\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t</head>\n\n\t\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t\t<form name=\"oncologyRegimenDrugList\" id=\"oncologyRegimenDrugList\">\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"external_dosage_override_reason";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" id=\"external_dosage_override_reason";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"      value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"external_duplicate_override_reason";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"   value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_interaction_override_reason";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"external_interaction_override_reason";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_contra_override_reason";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"external_contra_override_reason";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"external_alergy_override_reason";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"external_alergy_override_reason";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t<TR TITLE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"64%\" onClick=\"defaultDrug(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\"  onMouseOver=\"changeCursor(this); changeCol(this);\" onMouseOut=\"realCol(this,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\"><FONT CLASS=\"HYPERLINK\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</FONT>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t  \n\t\t\t\t\t\t<IMG onMouseOver=\"changeCursor(this)\" \n\t\t\t\t\t\tSTYLE=\"filter:Chroma(Color=#FFFFFF)\" SRC=\"../../ePH/images/info.gif\" HEIGHT=\"20\" WIDTH=\"20\" onClick=\"loadDrugInfo(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\">\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size=\"1\" color=\"BLUE\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td width=\"6%\" CLASS=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"   >&nbsp;\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\' height =15 width =15 title=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ></img><br>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="          \n\t\t\t\t\t\t&nbsp;&nbsp;<img  id=\"ADR_img\" src=\'../../ePH/images/ADR.gif\' height =15 width =15 title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ></img>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="    \n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<TD CLASS=\"SHIFTTOTAL\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" id=\"ext_ddb_override_indc";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  onclick=\"viewMedicationAlert(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'PRESPAD\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"><img name=\"ext_ddb_override_img";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" src=\'../../ePH/images/exceed1.gif\' style=\"visibility:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =";\" ></img>&nbsp;</TD>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"6%\" id=\"ext_ddb_override_indc";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\">\n\t\t\t\t\t\t\t<img name=\"ext_ddb_override_img";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"                src=\'../../ePH/images/exceed1.gif\' style=\"visibility:hidden;\" ></img>\n\t\t\t\t\t\t\t&nbsp;</TD>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t<TD CLASS=\"ALLERGY\" COLSPAN=\"\" NOWRAP WIDTH=\"10%\" TITLE=\"Allergy Drug\" id=\"tdallergy";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"\tonClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\');\" onMouseOver=\"changeCursor(this);\">&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</TD>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" COLSPAN=\"\" NOWRAP WIDTH=\"10%\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<TD CLASS=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" WIDTH=\"10%\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<td class=\"CURRENTRX\" colspan=\"\" nowrap width=\"10%\" title=\"Duplicate Medication\" id=\"tdduplicate";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"         onMouseOver=\"changeCursor(this);\" onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">\t\t\t&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" colspan=\"\" nowrap width=\"15%\">&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t</TR>\t\t  \n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<TD CLASS=\"DOSELIMIT\" COLSPAN=\"\" NOWRAP WIDTH=\"10%\" TITLE=\"Exceed Dosage Limit\" \n\t\t\t\t\t\t\tid=\"tddose";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"\n\t\t\t\t\t\t\tonMouseOver=\"changeCursor(this);\" onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');\">&nbsp;";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp;</TD><!-- Modified for IN:070451 -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" colspan=\"\" nowrap width=\"10%\">&nbsp;</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="        \n\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"external_db_dose_check_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"external_db_dose_check_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"ext_med_alerts_fired_for_dup_check_yn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"ext_med_alerts_fired_for_inte_check_yn";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"ext_med_alerts_fired_for_contra_check_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"ext_med_alerts_fired_for_allergy_check_yn";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"start_date\" id=\"start_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"drug_db_interface_yn\" id=\"drug_db_interface_yn\"   value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\t\t\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"comp_freq_code\" id=\"comp_freq_code\"\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"comp_durn_value\" id=\"comp_durn_value\"\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"comp_durn_type\" id=\"comp_durn_type\"\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"fluid_frame_display_yn\" id=\"fluid_frame_display_yn\"   value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"serialNum\" id=\"serialNum\"\t\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"\t>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\t value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\t>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</form>\n\t\t\t</body>\n\t\t</html>\n\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\t\n\t\t\t\t<script>    \t\n\t\t\t\t\tdefaultDrug(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\');    \n\t\t\t\t</script> \n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
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
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
23/07/2019	IN070451		Manickavasagam J			       						ML-MMOH-CRF-1408
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
-------------------------------------------------------------------------------------------------------------------------------
*/

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patient_id					= request.getParameter("patient_id");
	String encounter_id					= request.getParameter("encounter_id");
	String start_date					= request.getParameter("start_date");
	String adr_count					= request.getParameter("adr_count");
    String order_type_flag		        = request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	HashMap Existingrecord;
	String amend_srl_no                 ="";
	String catalog_code                 ="";
	String bean_id						= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name					= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean			= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList drugList					= bean.getDrugDetails();
	String fluid_frame_display_yn		= "N";
	String tmp_srl_no					=null;
	String tmp_comp_freq_code			=null;
	String tmp_comp_durn_value			=null;
	String tmp_comp_durn_type			=null;
	String tmp_fluid_frame_display_yn	=null;
	String tmp_count                    =null;
	String classValue					="";
	int    count                        =0;
	String flag							="N";
	String existing_order_id            ="";
	int    size                         =0;
	String dosage_unit                  ="";
	String amend_dup_drug				="";
	String adr_display_yn				="N";
	String fluid_adr_display_yn			="N";

	String facility_id					= (String)session.getValue("facility_id");
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
	
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
    String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);
	param_bean.clear();

	String or_bean_name			= "eOR.OrderEntryBean";
	String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

	ArrayList ExistingCYTORecords = new ArrayList();
	ArrayList ex_prod_ids =new ArrayList();
	ArrayList drugDesc	  =new ArrayList();
	if (drugList!=null && drugList.size() > 0) {	
		
		String perform_external_database_checks_yn	=	"";	
		String loading_ext_prod_id					=	"";
		String drug_db_interact_check_flag			= "N";
		String drug_db_duptherapy_flag				= "N";
		String drug_db_contraind_check_flag			= "N";
		String drug_db_dosage_check_flag			= "N";
		String drug_db_allergy_flag					= "N";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String pract_name	= (String)orbean.getPractitionerName();
		String extVisble	= "visible";
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

            _bw.write(_wl_block6Bytes, _wl_block6);

	 try{

			String drug_code	= "";
			if(order_type_flag.equals("Existing") ){   				 
				ExistingCYTORecords = bean.getExistingCYTORecords();								

				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails!=null && drugDetails.size() > 0){
						drug_code				= (String)drugDetails.get("DRUG_CODE");
						if(ExistingCYTORecords !=null && ExistingCYTORecords.size()>0){
							for(int j=0;j<ExistingCYTORecords.size();j++){
								Existingrecord = (HashMap)ExistingCYTORecords.get(j);
								if(Existingrecord.get("ORDER_CATALOG_CODE").equals(drug_code)){

									drugDetails.put("CURRENT_RX",Existingrecord.get("CURRENT_RX"));
									drugDetails.put("ALLERGY_YN",Existingrecord.get("ALLERGY_YN"));

								  if(drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON").equals("")){
									drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
								 }
									
								 if(drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON").equals("")){
										drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
								 }
								 if(drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").equals("")){ //added for IN26007 --24/01/2011-- priya
										drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
										
										
								 }
							drugDetails.put("DOSAGE_LIMIT_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
							drugDetails.put("ALLERGY_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							drugDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));

							break;
								}
							}
						}
					}
				}
			}
			for(int i=0;i<drugList.size();i++) {
				drug_db_interact_check_flag			= "N";
				drug_db_duptherapy_flag				= "N";
				drug_db_contraind_check_flag		= "N";
				drug_db_dosage_check_flag			= "N";
				drug_db_allergy_flag					= "N";
				HashMap drugDetails = (HashMap)drugList.get(i);

				if (drugDetails!=null && drugDetails.size() > 0){

					String srl_no					= (String)drugDetails.get("SRL_NO");
					String drug_desc				= (String)drugDetails.get("DRUG_DESC");
						   drug_code				= (String)drugDetails.get("DRUG_CODE");
					String generic_id				= (String)drugDetails.get("GENERIC_ID");
					String generic_name				= (String)drugDetails.get("GENERIC_NAME");
					String allergy_yn				= (String)drugDetails.get("ALLERGY_YN");
					String qty_value				= (String)drugDetails.get("QTY_VALUE");
					String or_qty_desc				= (String)drugDetails.get("OR_QTY_DESC");
					String limit_ind				= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					String mono_graph				= (String)drugDetails.get("MONO_GRAPH");
					String daily_dose				= (String)drugDetails.get("DAILY_DOSE");
					String unit_dose				= (String)drugDetails.get("UNIT_DOSE");
					String min_daily_dose			= (String)drugDetails.get("MIN_DAILY_DOSE");
					String min_unit_dose			= (String)drugDetails.get("MIN_UNIT_DOSE");
					String dosage_std				= (String)drugDetails.get("DOSAGE_STD");
					//Added for IN:070451 START
					String max_daily_ceeling_dose			= (String)drugDetails.get("max_daily_ceeling_dose");
					String min_daily_ceeling_dose			= (String)drugDetails.get("min_daily_ceeling_dose");
					String max_unit_ceeling_dose			= (String)drugDetails.get("max_unit_ceeling_dose");
					String min_unit_ceeling_dose			= (String)drugDetails.get("min_unit_ceeling_dose");
					//Added for IN:070451 END
					String current_rx				= (String)drugDetails.get("CURRENT_RX");

					String allergy_override			= (String)drugDetails.get("ALLERGY_OVERRIDE");
					String dose_override			= (String)drugDetails.get("DOSE_OVERRIDE");
					String currentrx_override		= (String)drugDetails.get("CURRENTRX_OVERRIDE");
					String ext_prod_id				= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
					String comp_freq_code			= (String)drugDetails.get("comp_freq_code");
						   if(comp_freq_code == null){comp_freq_code = (String)drugDetails.get("FREQ_CODE");}
					String comp_durn_value			= (String)drugDetails.get("comp_durn_value");
						   if(comp_durn_value == null){comp_durn_value = (String)drugDetails.get("DURN_VALUE");}
					String comp_durn_type			= (String)drugDetails.get("comp_durn_type");
						   if(comp_durn_type == null){comp_durn_type = (String)drugDetails.get("DURN_TYPE");}
					String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name")==null? "" :(String)drugDetails.get("amend_fluid_name");
					String dose_unit_desc = ""; //ML-MMOH-CRF-1408 - start
					String dose_unit_desc1 = "";//Added for IN:070451
					String dosage_uom			= drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
 						if(!dosage_uom.equals("")){ 
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
						   dose_unit_desc1 =dose_unit_desc;//Added for IN:070451
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
	 						 dose_unit_desc1 =dose_unit_desc;//Added for IN:070451
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
	 						} 
 						}
					//ML-MMOH-CRF-1408 - End
					String amend_fluid_code			= (String)drugDetails.get("amend_fluid_code")==null? "" :(String)drugDetails.get("amend_fluid_code");
					String iv_ingredient_yn			= (String)drugDetails.get("IV_INGREDIENT_YN")==null? "" :(String)drugDetails.get("IV_INGREDIENT_YN");
					String iv_fluid_yn				= (String)drugDetails.get("IV_FLUID_YN")==null? "" :(String)drugDetails.get("IV_FLUID_YN");
					String amend_yn				    = (String)drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
					String startdate				= (String)drugDetails.get("START_DATE_TIME")==null?"":(String)drugDetails.get("START_DATE_TIME");// Added for ML-BRU-SCF-0811 [IN:039394]
					String enddate				    = (String)drugDetails.get("END_DATE_TIME")==null?"":(String)drugDetails.get("END_DATE_TIME");// Added for ML-BRU-SCF-0811 [IN:039394]
					String startdate_mims           = (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE"); // Added for 69759
					String enddate_mims             = (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE"); // Added for 69759
					HashMap record_flag				=null;
					HashMap fluids					=null;
					HashMap Existingrecord1			=null;			
					existing_order_id				= "";         
					
					perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
					loading_ext_prod_id				 = ext_prod_id;


					external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
/*==================================================================================================================*/
				   //added for IN26007 --24/01/2011-- priya
					if(!(drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").equals("")) && !(ext_prod_id.equals("")) && drug_db_dosecheck_yn.equals("Y") ){ 
								drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","Y");
					}
/*==================================================================================================================*/

					drug_db_dosage_check_flag              = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
					external_duplicate_override_reason		=  drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON") == null? 
					"" :drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON").toString();

					external_interaction_override_reason	= drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")== null?
					"" :drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON").toString();;
					
					external_contra_override_reason		= drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON") == null ? "":drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON").toString();
					
					external_alergy_override_reason		= drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON").toString();

					if(Integer.parseInt(adr_count)>0){
						int  drug_adr_count = bean.getADRCount(patient_id,drug_code); 
						if(drug_adr_count>0){
							adr_display_yn="Y";
						}
						else{
							adr_display_yn="N";
						}
					}
					if(order_type_flag.equals("Existing") ){   				 
						 amend_fluid_name		    = "";

						 size                       = ExistingCYTORecords.size();
						 record_flag                = (HashMap) ExistingCYTORecords.get(size-2);
						 fluids                     = (HashMap) ExistingCYTORecords.get(size-1);			
						 Existingrecord				= (HashMap) ExistingCYTORecords.get(count);				
						 catalog_code			    = (String)Existingrecord.get("ORDER_CATALOG_CODE");
						 iv_fluid_yn			    = (String)Existingrecord.get("IV_FLUID_YN")==null?"":(String)Existingrecord.get("IV_FLUID_YN");
						 iv_ingredient_yn			= (String)Existingrecord.get("IV_INGREDIENT_YN")==null?"":(String)Existingrecord.get("IV_INGREDIENT_YN");
						 amend_dup_drug				= java.net.URLDecoder.decode((String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON"));	
						 if( !amend_dup_drug.equals("")){
							// current_rx="Y";
						 }
						 else{
							// current_rx="N";
						 }

						 if( Existingrecord.containsKey("AMEND_SRL_NO")){
							amend_srl_no=(String) Existingrecord.get("AMEND_SRL_NO");
						 }
						 existing_order_id          = (String)Existingrecord.get("ORDER_ID"); 

						 if(record_flag.containsKey(existing_order_id)) {
							count=count+1;
							Existingrecord1			= (HashMap) ExistingCYTORecords.get(count);
							amend_fluid_name		= (String)Existingrecord1.get("CATALOG_DESC");
							existing_order_id       ="";					
						 }
						 else{
							 amend_fluid_name		 =  "";
						 }    
							
						 if(fluids.containsKey(catalog_code)){
							flag="Y";
						 }
						 else{
							srl_no = amend_srl_no;
							flag="N";
						 }
						 count=count+1;

						external_dosage_override_reason		= (String) Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
						if(external_duplicate_override_reason.equals(""))
							{
								external_duplicate_override_reason		= (String) Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							}	
						external_interaction_override_reason	= (String) Existingrecord.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");

						
						if(!external_interaction_override_reason.equals("")){
							drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",external_interaction_override_reason);
						}

						external_contra_override_reason		= (String) Existingrecord.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
						if(external_alergy_override_reason.equals("")){
								external_alergy_override_reason		= (String) Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
						}
						/*	if(!((String) Existingrecord.get("ALLERGY_OVERRIDE_REASON")).equals("")){
								external_alergy_override_reason = (String) Existingrecord.get("ALLERGY_OVERRIDE_REASON");
							}
							if(!((String) Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON")).equals("")){
								external_duplicate_override_reason = (String) Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							}*/
						}
						
						if(iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){
							fluid_frame_display_yn		= "Y";
						}
						else{
							fluid_frame_display_yn		= "N";
						}
						
						//if(!flag.equals("Y")){
							if(amend_yn.equals("N")){
								if(tmp_srl_no==null){
									tmp_srl_no				    =	srl_no;
									tmp_comp_freq_code			=	comp_freq_code;
									tmp_comp_durn_value			=   comp_durn_value;
									tmp_comp_durn_type			=   comp_durn_type;
									tmp_fluid_frame_display_yn  =   fluid_frame_display_yn;
									tmp_count                   =   amend_srl_no;
								}
							   classValue = "SELECTEDRUGS";
							}
							else{
							   classValue =	"AMENDEDDRUGS";
							}
					//}
				//code for drug interaction check
				  HashMap drug_Interactions				= null;
				  String dup_drug_det					= "";
	//&& !mode.equals("amend")

				  if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
						ex_prod_ids =new ArrayList();
								/*ex_prod_ids.add(ext_prod_id);
								drugDesc.add(drug_desc);
							beanex.storeDrugIds(patient_id,"",ex_prod_ids,drugDesc);//Store Drug ids
							beanex.removeSelectedDrugonAmend(ext_prod_id);*/
						for(int m=0;m<drugList.size();m++){
							HashMap drugDetails1				=(HashMap) drugList.get(m);
							String ext_drug_code				=(String) drugDetails1.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails1.get("EXTERNAL_PRODUCT_ID");
							if(!ex_prod_ids.contains(ext_drug_code)){
								if(!ext_drug_code.equals("")){
									if(!(order_type_flag.equals("Existing") && loading_ext_prod_id.equals(ext_drug_code))){ //if condition added for not use removeSelectedDrugonAmend -FDB Tuning
										ex_prod_ids.add(ext_drug_code);
										drugDesc.add((String)drugDetails1.get("DRUG_DESC"));
									}
								}
							}
						}
						/* //commented for FDB Tuning -start
						if(ex_prod_ids.size()>0)
							beanex.storeDrugIds(patient_id,"",ex_prod_ids,drugDesc);//Store Drug ids
						if(order_type_flag.equals("Existing") ){
							beanex.removeSelectedDrugonAmend(ext_prod_id);
						}
							 

						if(drug_db_interact_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
								drug_Interactions		= beanex.getInteractions();//get Interactions
								if(drug_Interactions.size()>0){							
								   drug_db_interact_check_flag="Y";
								}
							}
						}
						if(drug_db_duptherapy_yn.equals("Y")){ 
							if(ext_prod_id!=null&& !ext_prod_id.equals("")){

								dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result

								if(!dup_drug_det.equals("")&&dup_drug_det!=null){
									drug_db_duptherapy_flag = "Y";
									current_rx			    = "N";
								}
							}
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								ex_prod_ids =new ArrayList();
								ex_prod_ids.add(loading_ext_prod_id);
								boolean flag1 = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
								  HashMap contra_indications =(HashMap)beanex.getContraIndications();
								  if(contra_indications.containsKey(ext_prod_id)){
									 drug_db_contraind_check_flag="Y";
								  }					  
							}
						} 

						if(drug_db_allergy_check_yn.equals("Y")){

							ex_prod_ids =new ArrayList();
							ex_prod_ids.add(ext_prod_id);

							beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result

							HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();

							if(drug_alergies.containsKey(ext_prod_id)){
								drug_db_allergy_flag	= "Y";
								allergy_yn			= "N";
							}	
						}
						*/ //Commented for FDBTuning -End
						if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
							String storeIDs = "N";
							if(ex_prod_ids.size()>0 )
								storeIDs = "Y";
								
							HashMap tempDetails= null;
							ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
							HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", ex_prod_ids,drugDesc, null, storeIDs, startdate_mims, enddate_mims); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean // startdate,enddate chnaged to startdate_mims,enddate_mims for 69759  
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);

							drug_db_allergy_flag="N";
							drug_db_interact_check_flag="N";
							drug_db_duptherapy_flag="N";
							drug_db_contraind_check_flag="N";
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
							if(drug_db_allergy_check_yn.equals("Y")){

							   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
								   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
								   if(allergy_alert!=null && !allergy_alert.equals(""))
										drug_db_allergy_flag="Y";
										allergy_yn			= "N";
							   } 
							   else {  
									tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
									if(tempDetails!=null && tempDetails.size()>0){
										 drug_db_allergy_flag="Y";
										allergy_yn			= "N";
									}
								} 
							}

							if(drug_db_interact_check_yn.equals("Y")){
								tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
								if(tempDetails!=null && tempDetails.size()>0){
									 drug_db_interact_check_flag="Y";
								}
							}

							if(drug_db_duptherapy_yn.equals("Y")){ 
							   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
							   if(dup_drug_det!=null && !dup_drug_det.equals(""))
									drug_db_duptherapy_flag="Y";
							}
							if(drug_db_contraind_check_yn.equals("Y")){
								if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // adding start for IN066787- Performance
							          tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

						        if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
							           drug_db_contraind_check_flag="Y";
						         }
								}else{//Adding end for IN066787- Performance
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
							}
						 }
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

						/*if(drug_db_allergy_flag.equals("Y")){
							if(!external_alergy_override_reason.equals("")){
							
							}
						}*/

					}
					else{
						drug_db_product_id = "";
					}

					drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);

					String allergy_override_gif		= "";
					String overdose_override_gif	= "";
					String currrx_override_gif		= "";
					String tooltip					= drug_desc+"/"+generic_name+" - "+qty_value+" "+or_qty_desc+"-"+amend_fluid_name;
					String dispDesc					= "";
					if(drug_desc!=null && drug_desc.length()>16) {
						dispDesc=drug_desc.substring(0,16)+"...";
					}
					else {
						dispDesc=drug_desc;
					}

					if(amend_fluid_name.length()>16) {
						amend_fluid_name=amend_fluid_name.substring(0,16)+"...";
					}
					else {
						amend_fluid_name=amend_fluid_name;
					}
					if(allergy_override!=null && allergy_override.equals("N")) {
						allergy_override_gif="<IMG id=allergy"+(i+1)+" SRC='../images/exceed1.gif' style=1visibility:visible'></IMG>";
					}
					else {
						allergy_override_gif="&nbsp;";
					}

					if(dose_override!=null && dose_override.equals("N")) {
						overdose_override_gif="<IMG id=dose"+(i+1)+" SRC='../images/exceed1.gif'></IMG>";
					}
					else {
						overdose_override_gif="&nbsp;";
					}

					if(currentrx_override!=null && currentrx_override.equals("N")) {
						currrx_override_gif="<IMG id=duplicate"+(i+1)+" SRC='../images/exceed1.gif' style=1visibility:visible'></IMG>";
					}
					else {
						currrx_override_gif="&nbsp;";
					}
					if(order_type_flag.equals("Existing") ){ 
						overdose_override_gif="&nbsp;";
						//currrx_override_gif="&nbsp;";
						//allergy_override_gif="&nbsp;";
					}	
					if(!external_duplicate_override_reason.equals("")){
						currrx_override_gif="&nbsp;";
					}
					
					if(!external_alergy_override_reason.equals("")){
						allergy_override_gif="&nbsp;";
					}

					ArrayList doseValues		= (ArrayList)bean.getDoseValues(drug_code,patient_id);

					if(doseValues!=null){			
						dosage_unit				= (String)doseValues.get(1);	 		
					}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(external_dosage_override_reason));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(external_duplicate_override_reason));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(external_interaction_override_reason));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(external_contra_override_reason));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(external_alergy_override_reason));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(comp_freq_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(comp_durn_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(comp_durn_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fluid_frame_display_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dispDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);

					if (!ext_prod_id.equals("")  && drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block28Bytes, _wl_block28);
		
					}
					if(amend_fluid_name!=null && !amend_fluid_name.equals(""))	{  
						if(Integer.parseInt(adr_count)>0 && !amend_fluid_code.equals("")){
							int  fluid_adr_count = bean.getADRCount(patient_id,amend_fluid_code); 

							if(fluid_adr_count>0){
								fluid_adr_display_yn="Y";
							}
							else{
								fluid_adr_display_yn="N";
							}
						}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(amend_fluid_name));
            _bw.write(_wl_block1Bytes, _wl_block1);
		
					}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);

					if(adr_display_yn.equals("Y")){

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

					}
					if(fluid_adr_display_yn.equals("Y")){

            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

					}
					fluid_adr_display_yn="N";
					adr_display_yn="N";

            _bw.write(_wl_block36Bytes, _wl_block36);
	   
					if(perform_external_database_checks_yn.equals("Y") && limit_ind.equals("N")){
						limit_ind = "Y";
						drugDetails.put("LIMIT_IND",limit_ind);
					}else if(perform_external_database_checks_yn.equals("N") && limit_ind.equals("N")){
						limit_ind = "N";
						drugDetails.put("LIMIT_IND",limit_ind);
					}
					if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dosage_check_flag=="Y")&&(external_dosage_override_reason==""))||((drug_db_allergy_flag=="Y")&&(external_alergy_override_reason==""))){
						extVisble = "visible";
					}
					else{
						extVisble = "hidden";

					}
//out.println("@518 >>>>>> perform_external_database_checks_yn = "+perform_external_database_checks_yn+" >>> ext_prod_id = "+ext_prod_id+" >>> extVisble = "+extVisble+">>> drug_db_dosage_check_flag = "+drug_db_dosage_check_flag );
					if(perform_external_database_checks_yn.equals("Y") && !ext_prod_id.equals("")){
						if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(extVisble));
            _bw.write(_wl_block42Bytes, _wl_block42);

						}
						else{	  


            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_dosage_override_reason)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_duplicate_override_reason)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_interaction_override_reason)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_contra_override_reason)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(external_alergy_override_reason)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_dosecheck_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block46Bytes, _wl_block46);

						}	  
//									if((drug_db_allergy_flag.equals("N"))&&(allergy_yn!=null && allergy_yn.equals("Y"))) {

						if((drug_db_allergy_check_yn.equals("N"))&&(allergy_yn!=null && allergy_yn.equals("Y"))) {

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
						else {
							drugDetails.put("ALLERGY_YN","N");

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

						}

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);

						if((drug_db_duptherapy_yn.equals("N"))&&((!drug_db_duptherapy_yn.equals("Y")) && (current_rx!=null && current_rx.equals("Y")))) {

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);

						} else {
							drugDetails.put("CURRENT_RX","N");

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
									
						}

            _bw.write(_wl_block59Bytes, _wl_block59);

					}
					else{

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
				
						if(allergy_yn!=null && allergy_yn.equals("Y")) {

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allergy_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
						else {

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);

						}

						if(limit_ind!=null && limit_ind.equals("N")) {

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(mono_graph)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(max_daily_ceeling_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_daily_ceeling_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(max_unit_ceeling_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(min_unit_ceeling_dose));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(overdose_override_gif));
            _bw.write(_wl_block63Bytes, _wl_block63);

						}
						else {

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);

						}
						if(current_rx!=null && current_rx.equals("Y")) {

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(currrx_override_gif));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
						else {

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);

						}

            _bw.write(_wl_block65Bytes, _wl_block65);

					}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_dosage_check_flag));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);

				}

			}

            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( drug_db_interface_yn ));
            _bw.write(_wl_block81Bytes, _wl_block81);

					if(tmp_srl_no!=null && flag.equals("N")){ 

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tmp_comp_freq_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tmp_comp_durn_value));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tmp_comp_durn_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(tmp_fluid_frame_display_yn ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(tmp_count));
            _bw.write(_wl_block88Bytes, _wl_block88);

					}

            _bw.write(_wl_block89Bytes, _wl_block89);

		//if(tmp_srl_no!=null&& flag.equals("N")){ 
			if(tmp_srl_no!=null){ 

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(tmp_srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmp_comp_freq_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmp_comp_durn_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmp_comp_durn_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmp_fluid_frame_display_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tmp_count));
            _bw.write(_wl_block91Bytes, _wl_block91);

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}

	putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
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
}
