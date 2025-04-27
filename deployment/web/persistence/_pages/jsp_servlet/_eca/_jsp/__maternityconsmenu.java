package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __maternityconsmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MaternityConsMenu.jsp", 1736157589807L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCA/js/MaternityMenuTree.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/MaternityConsTree.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCA/js/RecMaternityCons.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\tif(parent.maternityeventframe.document.getElementById(\"newEventID\") != null && parent.maternityeventframe.document.getElementById(\"newEventID\") !=  undefined)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \'C\') parent.maternityeventframe.document.getElementById(\"newEventID\").style.visibility = \'hidden\'; \n\t\telse if(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' != \'C\') parent.maternityeventframe.document.getElementById(\"newEventID\").style.visibility = \'visible\';\n\t}\n\t</script>\n\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"callfunction()\">\n<STYLE>\n\tTR {\n\t\tBACKGROUND-COLOR:white;\n\t}\n\tTD {\n\t\tBACKGROUND-COLOR:white;\t\t\n\t}\n\tA{\n\t\tFONT-SIZE:8 pt;\n\t}\n\n</Style>\n\n<FORM METHOD=POST ACTION=\"\" name=\"maternityMenu\" id=\"maternityMenu\">\n<script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\tvar obj";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\n\t\t\t\tobj";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" = new dTree(\'obj";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\n\t\t\t\tobj";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =".add(0,-1,\'\');\n\t\t\t\tobj";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =".config.useStatusText=true;\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'==\'OC\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//if((\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'==\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')||(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'!=\'MCE013\'))\n\t\t\t\t\t\t\t//\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif((\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' == \'C\' )|| (\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' == \'C\'))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' == \'Y\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".add(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'0\',\'<b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b>\',\'../../eCA/jsp/RecMaternityOutcomeForcedComplete.jsp?sectionType=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&cycle_no=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&splty_event_code=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&splty_task_code=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&OCmode=V&accessionNum=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</b>\',\'\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&OCmode=R\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t}//}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'==\'PR\')\n\t\t\t\t\t\t{ \n\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' == \'C\' || \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' == \'O\')\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' != \'C\')\n\t\t\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b>\',\'../../eCA/jsp/PatProcRecord.jsp?&accession_number=MC!";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="!";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="!&sectionType=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'==\'HM\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&&\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'==\'Y\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',\'\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t}\n\n\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\'\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\tobj";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =".add(\'MOTHER\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'<b>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</b>\',\'\',\'DOCUMENT\',\'\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =".add(\'MOTHERDOCUMENT\',\'MOTHER\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="(";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =")\',\'../../eCA/jsp/RecClinicalNotes.jsp?";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&appl_task_id=MC_CONSULT&contr_mod_accession_num=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="!M&modifyYN=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',\'Mother Folder\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =".add(\'MOTHERCHART\',\'MOTHER\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'../../eCA/jsp/ChartRecording.jsp?";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&contr_mod_accession_num=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'MOTHERCHART\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =".add(\'FOETUS\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</b>\',\'\',\'CHART\',\'\',\'\',\'\',\'\',\'R\');\t\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =".add(\'FOETUSDOCUMENT\',\'FOETUS\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="!F&modifyYN=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\',\'Foetus Folder\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\n\t\t\t\t\t// contr_mod_accession_num= module_id+\"!\"+patient_id+\"!\"+cycle_no+\"!\"+splt_event_code+\"!F\";\n\t\t\t\t\t obj";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =".add(\'FOETUSCHART\',\'FOETUS\',\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\',\'FOETUSCHART\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =".add(\'DELIV";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'../../eCA/jsp/RecMaternityConsView.jsp?sec_hdg_code=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&sectionType=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&birth_order=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&modeValue=VA\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\n\t\t\t\t\tobj";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =".add(\'NEWBORN";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\n\t\t\t\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',\'NEWBORN";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\',\'../../eMP/jsp/ViewBirthRegMain.jsp?Patient_ID=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\',\'../../eCommon/html/blank.html\',\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="?accessRights=NNNNN&Patient_ID=";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="&menu_id=MC&module_id=CA&function_id=NEWBORN_REG&function_name=Register Newborn&function_type=F&access=NNNNN&";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&called_from_mothercare=MC&calling_module_id=CA\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =".add(\'NEWBORNASS";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =".add(\'NEWBORNDOCUMENT";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\',\'NEWBORNASS";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\',\'Newborn Folder\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\n\t\t\t\t\t// contr_mod_accession_num= module_id+\"!\"+patient_id+\"!\"+cycle_no+\"!\"+splt_event_code+\"!F\";\n\t\t\t\t\t\t obj";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =".add(\'NEWBORNCHART";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\',\'NEWBORNCHART\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'\',\'Newborn Folder\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\n\t\t\t\t\t// contr_mod_accession_num= module_id+\"!\"+patient_id+\"!\"+cycle_no+\"!\"+splt_event_code+\"!F\";\n\t\t\t\t\t\t obj";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\',\'\',\'NEWBORNCHART\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="?sec_hdg_code=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&trns_datettime=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="&accessionNum=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="&modeValue=V\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="&sub_sec_hdg_code=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\',\'Delivery Record\',\'../../eCA/jsp/RecMaternityDeliveryRecordMain.jsp?";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&splt_event_status=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\',\'DELIV";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="&modeValue=V\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&modeValue=";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="&modeValue=V\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="&modeValue=V\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\',\'\',\'\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\nvar html=\"<TABLE width=\'95%\' align=\'center\' border=0 cellspacing=0>\";\nhtml=html+\"<TR>\";\nhtml=html+\"<TD background=\'../../eCA/images/MCT_FullStrip.gif\' style=\'height:32\' onclick=\\\"hideShowNodes(\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\')\\\">&nbsp;";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\";\n//here to add  //High Risk\nif((\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'==\'Y\') ||(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'==\'YES\'))\n{\n\thtml=html+\"<input type=\'image\' src=\'../../eCA/images/MCT_PreciousPregnancy.gif\'></input>\";\n}\nif((\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'==\'High Risk\') ||(\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'==\'HGRI\'))\nhtml=html+\" <img onClick =\'callview(\\\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\\\",\\\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\\\")\' src=\'../../eCA/images/MCT_HighRiskInd.gif\'></img>\";\n\nhtml=html+\"</TD>\";\nhtml=html+\"</TR></TABLE>\";\nparent.maternitytreeframe.document.write(html); //\ndocument.write(\"<TABLE width=\'95%\' height=\'75%\' align=\'center\' border=0 cellspacing=0><TR VALIGN=TOP><TD id=\'tdId";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' style=\'display;BACKGROUND-IMAGE:url(../../eCA/images/MCT_MenuBgImage.jpg)\'>\"+obj";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="+\"</td></tr></TABLE>\");\nobj";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =".openAll();\n\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\t\n</script>\t\n\t<input type=hidden name=\'req_event_code\' id=\'req_event_code\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t<input type=hidden name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t<input type=hidden name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t<input type=hidden name=\'noOfEvents\' id=\'noOfEvents\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t<input type=hidden name=\'sel_cycle_no\' id=\'sel_cycle_no\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\n\n</FORM>\n<script>\n\t//hideAllCycles();\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );


	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String splty_title_event_desc=request.getParameter("splty_title_event_desc") == null ? "" : request.getParameter("splty_title_event_desc");
	String sel_cycle_no=request.getParameter("sel_cycle_no") == null ? "0" : request.getParameter("sel_cycle_no");
	String cycle_status=request.getParameter("cycle_status");
	String boldText = "";
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String delivery_indicator = "";
	String transDateQryNew ="";
	String deli_rec_facility_id ="";

	int cycle_no=0;
	
	
	//Querires to fecth the data
	String event_SQL="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_STATUS,CA_GET_DESC.CA_SPLTY_EVENT(SPLTY_EVENT_CODE,?,'1')||decode(ADDITIONAL_EVENT_YN,'Y','#','') SPLTY_EVENT_DESC FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE  PATIENT_ID =? AND MODULE_ID=? AND CYCLE_NO=? ORDER BY ADDITIONAL_EVENT_YN,SPLTY_EVENT_START_DATE";
	
	String menuSql="SELECT A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,nvl(A.NUMB_OF_TRANS_ALLOWED,9999),A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE  SPLTY_EVENT_CODE=? AND MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL /*and (A.SPLTY_TASK_CODE!='MCT001' or not exists (select 1 from CA_PAT_SPLTY_EPISODE_TASK where PATIENT_ID=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? and A.SPLTY_TASK_CODE='MCT001' ))*/ ORDER BY ORDER_SEQ_NO";

	String actionSQL="SELECT A.ACTION_CODE,CASE WHEN A.SPLTY_TASK_TYPE='NT' THEN CA_GET_DESC.CA_NOTE_TYPE(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='CH' THEN CA_GET_DESC.CA_CHART(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE in ('TM' ,'TG')THEN CA_GET_DESC.CA_SECTION_HDG(A.ACTION_CODE,?,'1') END SPLTY_TASK_DESC FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A  WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND SPLTY_TASK_CODE =?";

	//String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE ";
	
	String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE ";

	String SQL1="SELECT CYCLE_NO, CYCLE_STATUS  FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 2 desc, 1 desc";

	String sqlCycleStatus = "SELECT CYCLE_STATUS FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CYCLE_NO = ?";

	String SQLSPlty="SELECT SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC FROM CA_SPLTY_EPISODE_CYCLE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=?";

	String SQLSNoteCnt="SELECT count(*) evnt_cnt FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM=? ";

	//String transDateQry ="select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE";

	String transDateQry ="select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =?  AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE";

	//String del_rec_qry=" select no_of_birth,(SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator,nvl(FINALIZE_YN,'N') FINALIZE_YN from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ?  and MOTHER_PATIENT_ID=? and CYCLE_NO = ?   ";
	
	String del_rec_qry=" select no_of_birth,(SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator,nvl(FINALIZE_YN,'N') FINALIZE_YN,FACILITY_ID from CA_SPL_DELIVERY_RECORD where  MOTHER_PATIENT_ID=? and CYCLE_NO = ?   ";

	//String del_rec_qryNew =" select 1 from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ?  and MOTHER_PATIENT_ID=? and CYCLE_NO = ? and ENCOUNTER_ID = ?  ";

	String del_rec_qryNew =" select 1 from CA_SPL_DELIVERY_RECORD where MOTHER_PATIENT_ID=? and CYCLE_NO = ? and ENCOUNTER_ID = ?  ";

	String newBornQry= " select s.PATIENT_ID,s.FINALIZED_YN  from MP_birth_register s where s.MOTHER_PATIENT_ID = ?  and s.BIRTH_ORDER= ? and MC_CYCLE_NO =? " ;	

	String splty_episode_desc=request.getParameter("splty_episode_desc") == null ? "" : request.getParameter("splty_episode_desc");
	String facility_id = (String) session.getValue("facility_id");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//main task variabl
	String splt_event_code="";
	String splt_event_status="";
	String splt_event_desc="";
	String splty_task_code="";
	String splty_task_desc="";
	String splty_task_type="";
	String extble_name="";
	String accessionNum="";
	int no_trans_allowed=0;
	String actn_code;
	String discr_msr_value1 ="";
	String discr_msr_value2 ="";
	String sec_hdg_code_temp ="";
	String sec_det_qry="";
	String sec_hdg_desc="";
	String sec_hdg_code="";
	String noOfBirth="1";
	String newBornid = "";
	String disp_str = "";
	String finalized_yn = "N";
	String newBornDetDisp = "";
	String delivDetDisp = "";
	String delivDetDisp1 = "";
	String del_finalize_yn = "N";
	int occurance = 1;
	int BLoop=1;	
	String sub_act_code=null;
	String sub_act_desc=null;
	String modifyYN = "Y";
	String evnt_cnt = "0";
	String contr_mod_accession_num = "0";
	int i=0;
	int k=0;
	int l=0;
	Boolean flag = true;
	Boolean delivFlag = false;
	Boolean stageComp = true;
	Boolean newBornFlag = false;
	Boolean delEncFlag = false;
	String allow_yn = "";
	String tool_tip = "";
	String modeValueNew = "";
	String dis_date = "";
	String dis_date1 = "";

	PreparedStatement pstmtsql = null;
	PreparedStatement pstmt_evnt = null;
	PreparedStatement pstmtRecOCDisp = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmtSQLSNoteCnt = null;
	PreparedStatement pstmtSect = null;
	PreparedStatement pstmtDelRec = null;
	PreparedStatement pstmtNewBorn = null;
	PreparedStatement pstmtTransDate = null;
	PreparedStatement pstmtDSQ = null;
	PreparedStatement pstmtSectNew = null;
	PreparedStatement pstmtDS = null;
	PreparedStatement pstmtDoccurance = null;
			
	
	CallableStatement cs = null;
	Connection con = null;
	ResultSet rssql = null;
	ResultSet rsMenu_Evnt = null;
	ResultSet resRecOCDisp = null;
	ResultSet rsSQLSNoteCnt = null;
	ResultSet rsSect = null;
	ResultSet rsDelv = null;
	ResultSet rsNewBorn = null;
	ResultSet rsTransDate = null;
	ResultSet rsDSQ = null;
	ResultSet rsDS = null;
	ResultSet rsSectNew = null;
	ResultSet rsDoccurance = null;
	ResultSet rs = null,rsMenu=null,rsDate=null;
	String req_event_code=request.getParameter("req_event_code")==null?"":request.getParameter("req_event_code");

	try{
		con = ConnectionManager.getConnection(request);
	

	try{
		pstmtRecOCDisp = con.prepareStatement("select ACCESSION_NUM,DTL_REC_PRESENT_YN from CA_PAT_SPLTY_EPISODE_TASK a where a.patient_id = ? and a.module_id = ? and a.cycle_no = ? and a.SPLTY_EVENT_CODE = ? ");

		pstmt1=con.prepareStatement(SQLSPlty);
		pstmt1.setString(1,module_id);
		pstmt1.setString(2,locale);
		rs	 =pstmt1.executeQuery();
		while(rs.next()){
		splty_episode_desc=rs.getString(1)==null?"Cycle":rs.getString(1);
		splty_title_event_desc=rs.getString(2)==null?"Event":rs.getString(2);
		}
		splty_episode_desc=splty_episode_desc==null?"Cycle":splty_episode_desc;
		splty_title_event_desc=splty_title_event_desc==null?"Event":splty_title_event_desc;
		if(rs!=null)
			rs.close();
		if(pstmt1!=null)
			pstmt1.close();

		if(pstmtRecOCDisp != null) pstmtRecOCDisp.close();
		if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
	}catch(Exception e){
		e.printStackTrace();
	}

	try{
	pstmtsql=con.prepareStatement(SQL1);
	pstmtsql.setString(1,patient_id);
	pstmtsql.setString(2,module_id);
	rssql	 =pstmtsql.executeQuery();
	rssql.next();
		cycle_no=Integer.parseInt(rssql.getString(1));
		cycle_status=rssql.getString(2);

	if(rssql!=null)
		rssql.close();
	if(pstmtsql!=null)
		pstmtsql.close();	
	
	pstmtsql = con.prepareStatement(sqlCycleStatus);
	pstmtsql.setString(1,patient_id);
	pstmtsql.setString(2,module_id);
	pstmtsql.setInt(3,Integer.parseInt(sel_cycle_no));
	rssql	 =pstmtsql.executeQuery();	
	if(rssql.next())
		cycle_status = rssql.getString("CYCLE_STATUS");

	if(rssql!=null)
		rssql.close();
	if(pstmtsql!=null)
		pstmtsql.close();	

	}catch(Exception e){
		e.printStackTrace();
	}

	if(!sel_cycle_no.equals("0")){
	cycle_no=Integer.parseInt(sel_cycle_no);
	}

	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cycle_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cycle_status));
            _bw.write(_wl_block11Bytes, _wl_block11);

	try{
			pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
			pstmt_evnt=con.prepareStatement(event_SQL);
			pstmt_evnt.setString(1,locale);
			pstmt_evnt.setString(2,patient_id);
			pstmt_evnt.setString(3,module_id);
			pstmt_evnt.setInt(4,cycle_no);
			rsMenu_Evnt=pstmt_evnt.executeQuery();
	
			while(rsMenu_Evnt.next())
			{
				splt_event_code=rsMenu_Evnt.getString("SPLTY_EVENT_CODE");
				splt_event_status=rsMenu_Evnt.getString("SPLTY_EVENT_STATUS");
				splt_event_desc=rsMenu_Evnt.getString("SPLTY_EVENT_DESC");
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
if (splt_event_status.equals("O"))
				{
				
            _bw.write(_wl_block18Bytes, _wl_block18);

				}else
				{
				
            _bw.write(_wl_block19Bytes, _wl_block19);
}
				try{
						String date="";
						String DetailPresentYN="N";
						pstmt=con.prepareStatement(menuSql);
						pstmt.setString(1,locale);
						pstmt.setString(2,splt_event_code);
						pstmt.setString(3,module_id);					
						rsMenu=pstmt.executeQuery();

						pstmtDelRec = con.prepareStatement(del_rec_qry);
						//pstmtDelRec.setString(1,facility_id);					
						pstmtDelRec.setString(1,patient_id);
						pstmtDelRec.setInt(2,cycle_no);					
						rsDelv = pstmtDelRec.executeQuery();
						while(rsDelv.next())
						{
							delivFlag = true;
							noOfBirth =  rsDelv.getString("NO_OF_BIRTH")==null?"1":rsDelv.getString("NO_OF_BIRTH");
							delivery_indicator =  rsDelv.getString("delivery_indicator")==null?"":rsDelv.getString("delivery_indicator");
							del_finalize_yn =  rsDelv.getString("FINALIZE_YN")==null?"":rsDelv.getString("FINALIZE_YN");
							deli_rec_facility_id =  rsDelv.getString("FACILITY_ID")==null?"":rsDelv.getString("FACILITY_ID");
							
						}
					
						if(rsDelv!=null) 		rsDelv.close();
						if(pstmtDelRec!=null)	pstmtDelRec.close();

						pstmtDelRec = con.prepareStatement(del_rec_qryNew);
						//pstmtDelRec.setString(1,facility_id);
						pstmtDelRec.setString(1,patient_id);
						pstmtDelRec.setInt(2,cycle_no);
						pstmtDelRec.setString(3,encounter_id);
						rsDelv = pstmtDelRec.executeQuery();
						
						while(rsDelv.next())
						{
							delEncFlag = true;
						}
					
						if(rsDelv!=null) 		rsDelv.close();
						if(pstmtDelRec!=null)	pstmtDelRec.close();
						
						if(!(splt_event_code.equals("MCE009") || splt_event_code.equals("MCE008")))
						{
							delEncFlag = true;
						}
					
					/*if(!(splt_event_code.equals("MCE013")))
					{
						noOfBirth = "1";
					} */
					
					//for(int BLoop=1;BLoop<=Integer.parseInt(noOfBirth);BLoop++){
					//rsMenu.beforeFirst();
					while(rsMenu.next()){
						splty_task_code=rsMenu.getString(1);
						splty_task_desc=rsMenu.getString(2);
						no_trans_allowed=Integer.parseInt(rsMenu.getString(4));
						if (no_trans_allowed==0)
							no_trans_allowed=100;
						splty_task_type=rsMenu.getString(5); 
						extble_name=rsMenu.getString(6); 
						actn_code=rsMenu.getString(7);


						//for(int BLoop=0;BLoop<2;BLoop++){
						
						if(splty_task_type.equals("OC"))
						{
							DetailPresentYN = "N";
							pstmtRecOCDisp = con.prepareStatement("select ACCESSION_NUM,DTL_REC_PRESENT_YN from CA_PAT_SPLTY_EPISODE_TASK a where a.patient_id = ? and a.module_id = ? and a.cycle_no = ? and a.SPLTY_EVENT_CODE = ? ");
							pstmtRecOCDisp.setString(1,patient_id);
							pstmtRecOCDisp.setString(2,module_id);
							pstmtRecOCDisp.setInt(3,cycle_no);
							pstmtRecOCDisp.setString(4,splt_event_code);
							resRecOCDisp = pstmtRecOCDisp.executeQuery();
							while(resRecOCDisp.next())
							{
								DetailPresentYN = resRecOCDisp.getString(2) == null ? "N" : resRecOCDisp.getString(2);
								accessionNum = resRecOCDisp.getString(1) == null ? "" : resRecOCDisp.getString(1);
							}

							if(pstmtRecOCDisp != null) pstmtRecOCDisp.close();
						}
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(BLoop));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Integer.parseInt(noOfBirth)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cycle_status));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(splt_event_status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(DetailPresentYN));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(delivery_indicator));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(delivery_indicator));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(splt_event_status));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(delivFlag));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(del_finalize_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);

					if(splty_task_type.equals("HD")){ 

					if(cycle_status.equals("C") || splt_event_status.equals("C")) modifyYN = "N";
					else modifyYN = "Y";
					if(!splt_event_code.equals("MCE013")){
					
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

					 contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!M";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}
					catch(Exception e1)
					{		
						e1.printStackTrace();
					}
					
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(evnt_cnt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block66Bytes, _wl_block66);

					/* contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{
						
						e2.printStackTrace();
					}*/
					
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
						if(splt_event_code.equals("MCE004") || splt_event_code.equals("MCE008")){//|| splt_event_code.equals("MCE013")){
							
							contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						 
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{		
						e2.printStackTrace();
					}
							
							
							
							
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(evnt_cnt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
					/*pstmt1=con.prepareStatement(hdquerySQL);
					pstmt1.setString(1,locale);
					pstmt1.setString(2,splt_event_code);
					pstmt1.setString(3,module_id);
					pstmt1.setString(4,splty_task_code);
					rs	  =pstmt1.executeQuery();
					while(rs.next()){
					sub_task_code=rs.getString(1);
					sub_task_desc=rs.getString(2);
					no_trans_allowed=Integer.parseInt(rs.getString(4));
					sub_task_type=rs.getString(5);
					sub_extble_name=rs.getString(6);
					sub_hd_tsk_code=rs.getString(8);
					*/
					
            _bw.write(_wl_block78Bytes, _wl_block78);

					/*if (!sub_task_type.equals("OC"))
					{
					pstmt2=con.prepareStatement(actionSQL);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,splt_event_code);
					pstmt2.setString(5,module_id);
					pstmt2.setString(6,sub_task_code);	
					rs2	  =pstmt2.executeQuery();
					while(rs2.next()){
					sub_act_code=rs2.getString(1);
					sub_act_desc=rs2.getString(2);
					*/
					
            _bw.write(_wl_block79Bytes, _wl_block79);

					
					/*
					try{
					pstmt3=con.prepareStatement(dateSQL);
					int trns_lim=0;
					pstmt3.setString(1,patient_id);
					pstmt3.setString(2,facility_id);
					pstmt3.setString(3,module_id);
					pstmt3.setInt(4,cycle_no);
					pstmt3.setString(5,splt_event_code);
					pstmt3.setString(6,sub_task_code);
					rsDate=pstmt3.executeQuery();
					while(rsDate.next()){
					trns_lim=trns_lim+1;
					
					*/
					
            _bw.write(_wl_block80Bytes, _wl_block80);

					/*
					}
					if(rsDate!=null)
						rsDate.close();
					if(pstmt3!=null)
						pstmt3.close();
					if(trns_lim<no_trans_allowed && (!cycle_status.equals("C") && !splt_event_status.equals("C"))){
					
					*/
					
            _bw.write(_wl_block78Bytes, _wl_block78);
 /*
						}
					}catch(Exception e){
					e.printStackTrace() ;
					} */
					
            _bw.write(_wl_block81Bytes, _wl_block81);

						/*}
					if(rs2!=null)
					rs2.close();
					if(pstmt2!=null)
					pstmt2.close();
					}
					}
					if(rs!=null)
					rs.close();
					if(pstmt1!=null)
					pstmt1.close();*/
				}else if (splty_task_type.equals ("HM"))
				{
				 if(delivFlag){
					//String newBornQry= " select s.PATIENT_ID,s.FINALIZED_YN  from MP_birth_register s where s.MOTHER_PATIENT_ID = ?  and s.BIRTH_ORDER= ? " ;
					pstmtNewBorn = con.prepareStatement(newBornQry);
					for(int BLoop1=1;BLoop1<=Integer.parseInt(noOfBirth);BLoop1++){


					contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!"+BLoop1+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						 
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
							
				if(Integer.parseInt(noOfBirth)>1)
				{
					if(BLoop1==1)
					{
						newBornDetDisp="1<sup>st</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp = "Record 1<sup>st</sup> Birth details ";
						delivDetDisp1 = " 1<sup>st</sup> Birth details ";

					}
					else if(BLoop1==2)
					{
						newBornDetDisp="2<sup>nd</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record 2<sup>nd</sup> Birth details ";
						delivDetDisp1 =" 2<sup>nd</sup> Birth details ";


					}
					else if(BLoop1==3)
					{
						newBornDetDisp="3<sup>rd</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record 3<sup>rd</sup> Birth details ";
						delivDetDisp1 ="3<sup>rd</sup> Birth details ";

					}
					else
					{
						newBornDetDisp=BLoop1+"<sup>th</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record "+BLoop1+"<sup>th</sup> Birth details ";
						delivDetDisp1 =BLoop1+"<sup>th</sup> Birth details ";
					}


				}
				else if(Integer.parseInt(noOfBirth)==1)
				{

						newBornDetDisp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp =	"Record Birth details ";
						delivDetDisp1 = "Birth details ";


				}
					if(splty_task_code.equals("MCT008")){
							//stageComp falg

							String sec_det_qryNew = " select CHILD_SEC_HDG_CODE from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = 'MC25' order by CHILD_SEQ_NUM " ;
						//	String transDateQryNew1 =" select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

							String transDateQryNew1 =" select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

							pstmtSectNew	= con.prepareStatement(sec_det_qryNew);
							pstmtDS	= con.prepareStatement(transDateQryNew1);

									rsSectNew = pstmtSectNew.executeQuery();

									while(rsSectNew.next())
									{
										sec_hdg_code =rsSectNew.getString("CHILD_SEC_HDG_CODE")==null?"":rsSectNew.getString("CHILD_SEC_HDG_CODE");
										
										if(sec_hdg_code.equals("MC05"))
										{
											continue;
										}
										
										pstmtDS.setString(1,patient_id);
										//pstmtDS.setString(2,facility_id);
										pstmtDS.setString(2,module_id);
										pstmtDS.setInt(3,cycle_no);
										//pstmt.setString(5,sub_act_code);
										pstmtDS.setString(4,sec_hdg_code);
										pstmtDS.setString(5,splt_event_code);
										//pstmt.setString(7,splty_task_code);
										pstmtDS.setInt(6,BLoop1);
										rsDS = pstmtDS.executeQuery();
										
										
										if(!rsDS.next())
										{
											stageComp = false;
											break;
										}
										if(rsDS!=null) rsDS.close();
							

									}
									
									if(rsDS!=null) rsDS.close();
									if(rsSectNew!=null) rsSectNew.close();
									if(pstmtSectNew!=null) pstmtSectNew.close();
									if(pstmtDS!=null) pstmtDS.close();
							

					}




				//
				//if(Integer.parseInt(noOfBirth)>1)
				//{
					if( delivery_indicator.equals("N") || delivery_indicator.equals("O")){
					if(!stageComp){
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(delivDetDisp));
            _bw.write(_wl_block83Bytes, _wl_block83);

					}
					else
					{
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(delivDetDisp1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block87Bytes, _wl_block87);


					}
					}
				//}


				
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(newBornDetDisp));
            _bw.write(_wl_block90Bytes, _wl_block90);

					
					
					//pstmtNewBorn = con.prepareStatement(newBornQry);
					pstmtNewBorn.setString(1,patient_id);
					pstmtNewBorn.setInt(2,BLoop1);	
					pstmtNewBorn.setInt(3,cycle_no);
					
					rsNewBorn = pstmtNewBorn.executeQuery();

					while(rsNewBorn.next())
					{
						newBornFlag = true;
						newBornid = rsNewBorn.getString("PATIENT_ID")==null? "" :	rsNewBorn.getString("PATIENT_ID") ;
						finalized_yn = rsNewBorn.getString("FINALIZED_YN")==null? "N" :	rsNewBorn.getString("FINALIZED_YN") ;
					}
					
					if (finalized_yn.equals("Y"))
					{
						disp_str= newBornid;
					}
					else
					{
						disp_str= newBornid+"(Not Finalized)";	
					}

					if(newBornFlag)
					{
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(newBornid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block93Bytes, _wl_block93);


					}
					else{

						if((occurance==1)&&splt_event_status.equals("O"))
						{

							//CallableStatement cs = null;
							cs = con.prepareCall("{call mp_validate_nb_mother(?,?,?)}");
							cs.setString(1,patient_id);
							cs.setString(2,splt_event_code);
							cs.registerOutParameter( 3,Types.VARCHAR ) ;
							cs.execute();
							allow_yn = cs.getString(3);
							if(allow_yn==null) allow_yn = "";

							
							
							if(allow_yn.equals("SUBSEQUENT_DELY"))
							{
								tool_tip = getMessage(locale,allow_yn,"MP");
												
								
				
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tool_tip));
            _bw.write(_wl_block96Bytes, _wl_block96);

							}
							else
							{		
								
								if (!deli_rec_facility_id.equals("") && deli_rec_facility_id.equals(facility_id))
								{														
				
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block100Bytes, _wl_block100);
			
								}else{ 
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")));
            _bw.write(_wl_block101Bytes, _wl_block101);
						}	
				}
						occurance++; 
					}
					else
					{
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")));
            _bw.write(_wl_block102Bytes, _wl_block102);

					}
					}
				 if(newBornFlag){
					
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(evnt_cnt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block109Bytes, _wl_block109);

					}
					else
						{
				
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(BLoop1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")));
            _bw.write(_wl_block111Bytes, _wl_block111);



						}
					newBornFlag=false;
					if(rsNewBorn != null) rsNewBorn.close();
					//if(pstmtNewBorn != null) pstmtNewBorn.close();
					}
					if(pstmtNewBorn != null) pstmtNewBorn.close();
				 }
				}
				else if (!splty_task_type.equals ("OC"))
				{
					pstmt2=con.prepareStatement(actionSQL);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,splt_event_code);
					pstmt2.setString(5,module_id);
					pstmt2.setString(6,splty_task_code);
					rs	  =pstmt2.executeQuery();
					while(rs.next()){
						sub_act_code=rs.getString(1);
						sub_act_desc=rs.getString(2);
						sec_hdg_code_temp=sub_act_code;

					try{
					pstmt3=con.prepareStatement(dateSQL);
					int trns_lim=0;
					pstmt3.setString(1,patient_id);
					//pstmt3.setString(2,facility_id);
					pstmt3.setString(2,module_id);
					pstmt3.setInt(3,cycle_no);
					pstmt3.setString(4,splt_event_code);
					pstmt3.setString(5,splty_task_code);
					rsDate=pstmt3.executeQuery();
					while(rsDate.next()){
					trns_lim=trns_lim+1;
					
            _bw.write(_wl_block81Bytes, _wl_block81);
}
					if(rsDate!=null)
						rsDate.close();
					if(pstmt3!=null)
						pstmt3.close();

					//this line commented by shaiju to enable the link after closing the event.
					//if(!splt_event_status.equals("C")){//  &&
					//if(trns_lim<no_trans_allowed && (!cycle_status.equals("C"))){//  &&!splt_event_status.equals("C"))){
					
						if(splty_task_type.equals ("TM"))
						{

							sec_det_qry= " select SEC_HDG_DESC short_desc from CA_SECTION_HDG where SEC_HDG_CODE = ? " ;
							pstmtSect =	con.prepareStatement(sec_det_qry);
							pstmtSect.setString(1,sub_act_code);
							rsSect = pstmtSect.executeQuery();
							k=0;
							while(rsSect.next())
							{	k++;
								flag =true;
								l=0;

								sec_hdg_desc =rsSect.getString("short_desc")==null?"":rsSect.getString("short_desc");


								pstmtTransDate =	con.prepareStatement(transDateQry);
								pstmtTransDate.setString(1,patient_id);
								//pstmtTransDate.setString(2,facility_id);
								pstmtTransDate.setString(2,module_id);
								pstmtTransDate.setInt(3,cycle_no);
								pstmtTransDate.setString(4,sub_act_code);
								pstmtTransDate.setString(5,sub_act_code);
								pstmtTransDate.setString(6,splt_event_code);
								pstmtTransDate.setString(7,splty_task_code);
								rsTransDate = pstmtTransDate.executeQuery();
								while(rsTransDate.next())
								{
									flag=false;l++;

									dis_date1 = rsTransDate.getString(1);
									if (!locale.equals("en") )
									{
										dis_date1 = com.ehis.util.DateUtils.convertDate(dis_date1,"DMYHM","en",locale);

									}

								
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block115Bytes, _wl_block115);

									

								}
								if(l<no_trans_allowed)
								{
								
									flag=true;

								}

								if(rsTransDate!=null) rsTransDate.close();
								if(pstmtTransDate!=null) pstmtTransDate.close();
								
								if(flag&&!splt_event_status.equals("C")){
							
								
							
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block118Bytes, _wl_block118);

							}
							}
							if(rsSect!=null) rsSect.close();
							if(pstmtSect!=null) pstmtSect.close();


						}
						else if(splty_task_type.equals ("TG"))
						{
							
							sec_det_qry= " select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? order by CHILD_SEQ_NUM " ;
							pstmtSect =	con.prepareStatement(sec_det_qry);
							pstmtSect.setString(1,sub_act_code);
							//rsSect = pstmtSect.executeQuery();
							k=0;
							
							if(splty_task_code.equals("MCT005"))
							{
								/*String del_rec_qry=" select NO_OF_BIRTH from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ? and ENCOUNTER_ID =? and MOTHER_PATIENT_ID=? ";

								pstmtDelRec = con.prepareStatement(del_rec_qry);
								pstmtDelRec.setString(1,facility_id);
								pstmtDelRec.setString(2,encounter_id);
								pstmtDelRec.setString(3,patient_id);
								rsDelv = pstmtDelRec.executeQuery();

								while(rsDelv.next())
								{
									delivFlag = true;
									noOfBirth =  rsDelv.getString("NO_OF_BIRTH")==null?"":rsDelv.getString("NO_OF_BIRTH");
								}*/
								if(!splt_event_status.equals("C")){
								
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block120Bytes, _wl_block120);

								}
								else
								{
								
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(splt_event_status));
            _bw.write(_wl_block122Bytes, _wl_block122);

								}


							}
							
							if (!splty_task_code.equals("MCT005")||((delivery_indicator.equals("N") || delivery_indicator.equals("O"))&&del_finalize_yn.equals("Y")))
							{	
								Boolean Dflag = true;
								Boolean Hflag = true;
								Boolean DOccurFlag = true;
								Boolean Doccurance = true;
								Boolean DSQflag = true;
								String tmpl_finalize_yn = "";

								//String delStageQry="select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = 'MC52' AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND FINALIZE_YN='Y'";

								String delStageQry="select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = 'MC52' AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND FINALIZE_YN='Y'";

							//	String DoccuranceQry = " select 1  from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

								String DoccuranceQry = " select 1  from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

								if(Integer.parseInt(noOfBirth)>=1){
								pstmtDoccurance =	con.prepareStatement(DoccuranceQry);
								
								pstmtDSQ =	con.prepareStatement(delStageQry); 
								pstmtDSQ.setString(1,patient_id);
								//pstmtDSQ.setString(2,facility_id);
								pstmtDSQ.setString(2,module_id);
								pstmtDSQ.setInt(3,cycle_no);
								pstmtDSQ.setString(4,splt_event_code);
								rsDSQ = pstmtDSQ.executeQuery();
								while(rsDSQ.next())
								{
									DSQflag=false;
								}
								}
								if(rsDSQ!=null) rsDSQ.close();
								if(pstmtDSQ!=null) pstmtDSQ.close();
							
							for(int DLoop=1;DLoop<=Integer.parseInt(noOfBirth);DLoop++){
								k=0;
								rsSect = pstmtSect.executeQuery();
							
							while(rsSect.next())
							{	
								flag = true;
								k++;

								sec_hdg_desc =rsSect.getString("CHILD_SEC_HDG_DESC")==null?"":rsSect.getString("CHILD_SEC_HDG_DESC");
								sec_hdg_code =rsSect.getString("CHILD_SEC_HDG_CODE")==null?"":rsSect.getString("CHILD_SEC_HDG_CODE");


								if((DLoop>1)&&(sec_hdg_code.equals("MC05")))
								{
									DSQflag = true;
									continue;
									
								}
								if((sec_hdg_code.equals("MC52")|| sec_hdg_code.equals("MC53"))&&Integer.parseInt(noOfBirth)>1){
								

								
								pstmtDoccurance.setString(1,patient_id);
								//pstmtDoccurance.setString(2,facility_id);
								pstmtDoccurance.setString(2,module_id);
								pstmtDoccurance.setInt(3,cycle_no);
								pstmtDoccurance.setString(4,sub_act_code);
								pstmtDoccurance.setString(5,sec_hdg_code);
								pstmtDoccurance.setString(6,splt_event_code);
								pstmtDoccurance.setString(7,splty_task_code);
								pstmtDoccurance.setInt(8,DLoop);
								rsDoccurance = pstmtDoccurance.executeQuery();
								if(!rsDoccurance.next())
								{
									
									Doccurance = false;
								}
								}
								if(rsDoccurance!=null) rsDoccurance.close();
												
												
								//transDateQryNew =" select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM,nvl(FINALIZE_YN,'N') FINALIZE_YN from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? ORDER BY TRANS_DATE ";
								transDateQryNew =" select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM,nvl(FINALIZE_YN,'N') FINALIZE_YN from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? ORDER BY TRANS_DATE ";
							
							   // for(int DLoop=1;DLoop<=Integer.parseInt(noOfBirth);DLoop++){
								
								//flag = true;
								/*if(!sec_hdg_code.equals("MC05"))
								{
								  flag = true;
								} */
								
								pstmtTransDate =	con.prepareStatement(transDateQryNew); 
								pstmtTransDate.setString(1,patient_id);
								//pstmtTransDate.setString(2,facility_id);
								pstmtTransDate.setString(2,module_id);
								pstmtTransDate.setInt(3,cycle_no);
								pstmtTransDate.setString(4,sub_act_code);
								pstmtTransDate.setString(5,sec_hdg_code);
								pstmtTransDate.setString(6,splt_event_code);
								pstmtTransDate.setString(7,splty_task_code);
								pstmtTransDate.setInt(8,DLoop);
								rsTransDate = pstmtTransDate.executeQuery();
								while(rsTransDate.next())
								{
									flag = false;
									tmpl_finalize_yn = rsTransDate.getString("FINALIZE_YN");

									dis_date = rsTransDate.getString(1);
									if (!locale.equals("en") )
									{
										dis_date = com.ehis.util.DateUtils.convertDate(dis_date,"DMYHM","en",locale);

									}
									
									/*if(tmpl_finalize_yn.equals("N"))
									{
										Doccurance = false;	
									}*/

									

									if((Integer.parseInt(noOfBirth)>=1)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))
									{
										Dflag = false;
									}

									if((Integer.parseInt(noOfBirth)>=1)&&(!Hflag)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))//&&(!Hflag)
									{
										
										Dflag = false;
										if(tmpl_finalize_yn.equals("Y"))
										{
									
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block125Bytes, _wl_block125);

										}
										else 
										{
											if((splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))&&delEncFlag)
											{
												modeValueNew ="T" ;
											}
											else
											{
												modeValueNew ="V";
											}
									
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(modeValueNew));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block128Bytes, _wl_block128);

										
										}
									}
									else
									{										

										if(tmpl_finalize_yn.equals("Y"))
										{
									
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block130Bytes, _wl_block130);

										}
										else if(DSQflag)
										{
											
											if(!splt_event_status.equals("C")){
											if((splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))&&(delEncFlag))
											{
												modeValueNew ="T" ;
											}
											else
											{
												modeValueNew ="V";
											}
											}
											else
											{
												modeValueNew ="V";
											}
										
									
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(modeValueNew));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block131Bytes, _wl_block131);



										}
										else
										{
									
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rsTransDate.getString(1)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rsTransDate.getString(2)));
            _bw.write(_wl_block133Bytes, _wl_block133);


										}
														 
									}
									Hflag = false;
								}
								if(rsTransDate!=null) rsTransDate.close();
							//}
							//	if(pstmtTransDate!=null) pstmtTransDate.close(); 

							
							if(flag){
							
								
								if(Dflag&&!splt_event_status.equals("C")){
									
									if((DOccurFlag)&&(DSQflag)&&(delEncFlag) ){
											
									if(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))
									{
										modeValueNew ="D" ;
									}
									else
									{
										modeValueNew ="";
									}
									
							
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(modeValueNew));
            _bw.write(_wl_block134Bytes, _wl_block134);

							}
							else
							{
								
							
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_task_code));
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);


							}
								if((Integer.parseInt(noOfBirth)>=1)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))
								{
									Dflag = false;
									Hflag = false;
									continue;
								}

							}

								
								if(!Dflag){
								
								if((DOccurFlag)&&(delEncFlag) && (!deli_rec_facility_id.equals("") &&  deli_rec_facility_id.equals(facility_id)) ){									
									if(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))
									{
										modeValueNew ="D" ;
									}
									else
									{
										modeValueNew ="";
									}

								
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(extble_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(modeValueNew));
            _bw.write(_wl_block120Bytes, _wl_block120);

								}
								else
								{
								
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(DLoop));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block137Bytes, _wl_block137);


								}
								/*

								}
								if(rsTransDate!=null) rsTransDate.close();
								if(pstmtTransDate!=null) pstmtTransDate.close();
								*/
								
								
								}
							}
							 
							//} //Dloop ends
								if(pstmtTransDate!=null) pstmtTransDate.close(); 
							} 
							if((!Doccurance)||(flag))
							{
								DOccurFlag =false;
							}
							
							//while loop ends
								if(rsSect!=null) rsSect.close();
							}
						}
							//if(rsSect!=null) rsSect.close();
							if(pstmtSect!=null) pstmtSect.close();
							if(pstmtDoccurance!=null) pstmtDoccurance.close();
						}
					
					
					
            _bw.write(_wl_block78Bytes, _wl_block78);
//}
					}catch(Exception e){
						e.printStackTrace();
					}
					}
					if(rs!=null)
					rs.close();
					if(pstmt2!=null)
					pstmt2.close();
				}



				}
				//if(!splt_event_code.equals("MCE013")){
				//break;
				//}
				//}//end of BLoop
				if(rsMenu!= null) rsMenu.close();
				if(resRecOCDisp!= null) resRecOCDisp.close();
				if(pstmt!=null) pstmt.close();
				if(pstmtRecOCDisp!=null) pstmtRecOCDisp.close();
				if(pstmtSQLSNoteCnt!=null) pstmtSQLSNoteCnt.close();

				String preciouspregQuery ="select RTRIM(RTRIM(DISCR_MSR_VALUE),','),ACCESSION_NUM  from CA_PAT_SPLTY_KEY_MSR where PATIENT_ID	=? and MODULE_ID =? and CYCLE_NO =? and EVENT_CODE=? and DISCR_MSR_ID =?" ;
				pstmt =con.prepareStatement(preciouspregQuery);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,module_id);
				pstmt.setInt(3,cycle_no);
				pstmt.setString(4,splt_event_code);
				pstmt.setString(5,"MC01PRECUSPREGN");

				rs = pstmt.executeQuery();

				   if(rs.next())
					{
						discr_msr_value1 = rs.getString(1);
						
					}
					else
					{
						discr_msr_value1="";
					}
					if(rs!=null)
					rs.close();
					//if(pstmt!=null)
					//pstmt.close();	 
					pstmt.setString(5,"MC03RISKASSESRE");	
					rs = pstmt.executeQuery();

					if (rs.next())
					{
						discr_msr_value2 = rs.getString(1);
						accessionNum	 = rs.getString(2);
						
					}
					else
					{
						discr_msr_value2="";
					}
					if(pstmt!=null)
					pstmt.close();
					
					if(rs!=null)
					rs.close();

				}//end of try
catch(Exception e)
{
	e.printStackTrace();
}

if(splt_event_status.equals("O"))
{
	boldText = "<b>"+splt_event_desc+"</b>";	
}
else
{
	boldText = splt_event_desc;
}


            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(boldText));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(discr_msr_value1));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(discr_msr_value1));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(discr_msr_value2));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(discr_msr_value2));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(sec_hdg_code_temp));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(splty_task_type));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(splt_event_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);

		i++;}
if(rsMenu_Evnt!=null)
	rsMenu_Evnt.close();
if(pstmt_evnt!=null)
	pstmt_evnt.close();

if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
}catch(Exception e){
		if(rsMenu!=null)
	rsMenu.close();
if(pstmt!=null)
	pstmt.close();
	e.printStackTrace();
}

finally
{
	try
	{
		if(rs!= null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}catch(Exception e){
		e.printStackTrace();
}finally
{
	try
	{		
		if(con!= null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(req_event_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(sel_cycle_no));
            _bw.write(_wl_block156Bytes, _wl_block156);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mother.label", java.lang.String .class,"key"));
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
}
