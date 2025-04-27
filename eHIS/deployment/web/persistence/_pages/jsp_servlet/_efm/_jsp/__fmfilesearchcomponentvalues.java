package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __fmfilesearchcomponentvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileSearchComponentValues.jsp", 1733201415855L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>alert(\'Database Connection is not available\');\n\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\'; \n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eFM/js/FMFileSearchComponents.js\" language=\"JavaScript\"></Script>\n\t<!--<script language=\'javascript\' src=\'../../eFM/js/FMChFileRetDate.js\'></script>-->\n\t<SCRIPT>\n\t\tfunction getBarcodeValue(event, val, from)\n\t\t{ \t\t\n\t\t  \n\t\t\tif(event.keyCode == 13)\n\t\t\t{   \n\t\t\t\tif(from == \'file\')\n\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\tpopulateDynamicValues(val);\n\t\t\t\t\tdocument.forms[0].chk_flag.value = \"Y\";\n\t\t\t\t\tdocument.forms[0].chk_flag1.value = \"Y\";\n\t\t\t\t}\n\t\t\t\telse if(from == \'doc\')\n\t\t\t\t{\t\n\t\t\t\t\tgetPatientIDFileDetails();\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t}\n\t\t<!-- Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494 Changes:newly added Starts -->\n\t\tfunction moveOnMax(field)\n\t\t{  \n\t\t\tif(field.value.length>=field.maxLength)\n\t\t\t{  \tif(document.getElementById(\"fileNo\"))\n\t\t\t\tdocument.getElementById(\"fileNo\").focus();\n\t\t\t\tif(document.getElementById(\'FileType\'))\n\t\t\t\tdocument.getElementById(\'FileType\').focus();\n\t\t\t}\n\t\t}\n\t\t<!--Ends-->\n\t\tasync function patientSearch()\n\t\t{\t\n\t\t\tvar patient_id\t= await\tPatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n\t\t\t\n\t\t\tif(patient_id != null)\n\t\t\t{\n\t\t\t\tdocument.forms[0].";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =".value=patient_id;\n\t\t\t\tdocument.forms[0].";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".focus();\n\t\t\t\tgetPatientIDFileDetails();\n\t\t\t\t\t}\n\t\t}\n\t\t function getPatientIDFileDetails()\n\t\t{  \n\t\t\t//var document_folder_id\t=\teval(document.forms[0].";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =").value;\t\n\t\t\t/*if(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" == \"Y\")\n\t\t\t{\n\t\t\t\tvar document_type_id\t=\teval(document.forms[0].";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =").value;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar document_type_id\t= \'\';\n\t\t\t}*/\n\t\t\tvar param_patient_id = eval(document.forms[0].";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =").value;\t\t\n\t\t\tvar HTMLValue = \"<html><body onKeyDown = \'lockKey() \'  ><form name=\'Dummy_Form\' id=\'Dummy_Form\'   action=\'../../eFM/jsp/FMFileSearchComponent.jsp\' method=\'POST\'><input type=\'Hidden\' name=\'function_type\' id=\'function_type\' value = \'FileDetails\'><input type=\'Hidden\' name=\'patientid_name\' id=\'patientid_name\' value = \'\"+\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"+\"\'><input type=\'Hidden\' name=\'fileno_name\' id=\'fileno_name\' value = \'\"+\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"+\"\'><input type=\'Hidden\' name=\'filetype_name\' id=\'filetype_name\' value = \'\"+\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"+\"\'><input type=\'Hidden\' name=\'document_type_name\' id=\'document_type_name\' value = \'\"+\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"+\"\' ><input type=\'Hidden\' name=\'frame_name\' id=\'frame_name\' value = \'\"+\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"+\"\'><input type=\'Hidden\' name=\'form_name\' id=\'form_name\' value = \'\"+\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"+\"\'><input type=\'Hidden\' name=\'messageframe_name\' id=\'messageframe_name\' value = \'\"+\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"+\"\'><input type=\'Hidden\' name=\'volumeno_name\' id=\'volumeno_name\' value = \'\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"+\"\'><input type=\'Hidden\' name=\'volume_no_appl_yn\' id=\'volume_no_appl_yn\' value=\'\"+\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"+\"\'><input type=\'Hidden\' name=\'document_type_function\' id=\'document_type_function\' value=\'\"+\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"+\"\'><input type=\'Hidden\' name=\'document_folder_function\' id=\'document_folder_function\' value=\'\"+\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"+\"\'><input type=\'Hidden\' name=\'patline_yn\' id=\'patline_yn\' value = \'\"+\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"+\"\' ><input type=\'Hidden\' name=\'patline_ID\' id=\'patline_ID\' value = \'\"+\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"+\"\' ><input type=\'Hidden\' name=\'facilityID\' id=\'facilityID\' value = \'\"+\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"+\"\' ><input type=\'Hidden\' name=\'doctype_appl_yn\' id=\'doctype_appl_yn\' value = \'\"+\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"+\"\' ><input type=\'Hidden\' name=\'param_patient_id\' id=\'param_patient_id\' value = \'\"+param_patient_id+\"\' ><input type=\'Hidden\' name=\'fs_location\' id=\'fs_location\' value =\'\"+\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"+\"\' ><input type=\'Hidden\' name=\'function_name\' id=\'function_name\' value =\'\"+\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"+\"\' ><input type=\'Hidden\' name=\'file_mov_flag\' id=\'file_mov_flag\' value = \'\"+\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"+\"\' ></form></body></html>\";\n\t\t\teval(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =".document).write(HTMLValue);\n\t\t\teval(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =".document.Dummy_Form).submit();\n\t\t}\n\n\t\tfunction getDocTypeVolumeNo()\n\t\t{\n\t\t\tvar document_folder_id\t= eval(document.forms[0].";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =").value;\n\t\t\tvar HTMLValue = \"<html><body onKeyDown = \'lockKey()\'><form name=\'Dummy_Form\' id=\'Dummy_Form\' action=\'../../eFM/jsp/FMFileSearchComponent.jsp\' method=\'POST\'><input type=\'Hidden\' name=\'function_type\' id=\'function_type\' value = \'DocumentOnly\'><input type=\'Hidden\' name=\'patientid_name\' id=\'patientid_name\' value = \'\"+\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"+\"\'><input type=\'Hidden\' name=\'document_folder_id\' id=\'document_folder_id\' value = \'\"+document_folder_id+\"\'><input type=\'Hidden\' name=\'document_type_name\' id=\'document_type_name\' value = \'\"+\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"+\"\' ><input type=\'Hidden\' name=\'fs_location\' id=\'fs_location\' value =\'\"+\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =".document.Dummy_Form).submit();\n\t\t}\n\n\t\tasync function docFolderSearch(facility_id)\n\t\t{\n\t\t\tdocument.forms[0].";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =".value = \'\';\n\n\t\t\tvar target\t\t\t= eval(document.forms[0].";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =");\t\t\n\t\t\tvar retVal\t\t\t= new String();\n\t\t\tvar argumentArray\t= new Array();\n\t\t\tvar dataNameArray\t= new Array();\n\t\t\tvar dataValueArray\t= new Array();\n\t\t\tvar dataTypeArray\t= new Array();\t\t\t\n\t\t\tvar locn_in = document.forms[0].";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =".value;\t\t\t\n\n\t\t\tif(locn_in == \"\")\n\t\t\t{\n\t\t\tsql = \"SELECT  distinct a.doc_folder_id code, a.doc_folder_name description FROM fm_doc_folder a, fm_folder_in_fs_locn b WHERE upper(a.facility_id) like upper(?) and a.eff_status = \'E\' AND upper(a.doc_folder_id) like upper(?) AND upper(a.doc_folder_name) like upper(?) AND a.facility_id=b.facility_id AND a.doc_folder_id=b.doc_folder_id \"\n\t\t\t}else\n\t\t\t{\n\t\t\tsql = \"SELECT  distinct a.doc_folder_id code, a.doc_folder_name description FROM fm_doc_folder a, fm_folder_in_fs_locn b WHERE upper(a.facility_id) like upper(?) and a.eff_status = \'E\' AND upper(a.doc_folder_id) like upper(?) AND upper(a.doc_folder_name) like upper(?) AND a.facility_id=b.facility_id AND a.doc_folder_id=b.doc_folder_id AND b.FS_LOCN_CODE = \'\"+locn_in+\"\' \"\n\t\t\t}\t\t\t\n\n\t\t\tvar title=\"Document Folder\";\n\t\t\tdataNameArray[0]\t= \"facility_id\";\n\t\t\tdataValueArray[0]\t= facility_id;\n\t\t\tdataTypeArray[0]\t= STRING ;\n\t\t\t\n\t\t\targumentArray[0] = sql;\n\t\t\targumentArray[1] = dataNameArray;\n\t\t\targumentArray[2] = dataValueArray;\n\t\t\targumentArray[3] = dataTypeArray;\n\t\t\targumentArray[4] = \"2, 3\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = DESC_LINK;\n\t\t\targumentArray[7] = DESC_CODE;\n\t\t\t\n\t\t\tretVal = await CommonLookup(title, argumentArray);\n\t\t\t\n\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t{\n\t\t\t\tvar ret1\t=\tunescape(retVal);\n\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\teval(document.forms[0].";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =").value\t\t=\tarr[0];\n\t\t\t\teval(document.forms[0].";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =").value\t=\tarr[1];\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tgetDocTypeVolumeNo();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tgetPatientIDFileDetails();\n\t\t\t\t}\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\teval(document.forms[0].";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =").value\t\t=\t\"\";\n\t\t\t\teval(document.forms[0].";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =").value\t=\t\"\";\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar selectBox   =\n\t\t\t\t\teval(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =".document.";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =".";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =");\n\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t}\n\t\t\t} \n\t\t}\n\t\tfunction getPatIDVolume(objectValue)\n\t\t{\n\t\t\tif (objectValue != \"\")\n\t\t\t{\n\t\t\t\tvar file_type_appl_yn = eval(document.";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =".file_type_appl_yn).value;\n\t\t\t\tvar  patient_id = eval(document.";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =").value;\n\t\t\t\n\t\t\t\t\tvar HTMLValue = \"<html><body onKeyDown = \'lockKey()\'><form name=\'Dummy_Form\' id=\'Dummy_Form\' action=\'../../eFM/jsp/FMFileSearchComponent.jsp\' method=\'POST\'><input type=\'Hidden\' name=\'fileNo\' id=\'fileNo\' value = \'\"+objectValue+\"\'><input type=\'Hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value = \'\"+file_type_appl_yn+\"\'><input type=\'Hidden\' name=\'operation\' id=\'operation\' value = \'FILE_VOLUME\'><input type=\'Hidden\' name=\'frame_name\' id=\'frame_name\' value = \'\"+\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"+\"\'><input type=\'Hidden\' name=\'patientid_name\' id=\'patientid_name\' value = \'\"+\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"+\"\'><input type=\'Hidden\' name=\'file_no_function\' id=\'file_no_function\' value=\'\"+\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"+\"\'><input type=\'Hidden\' name=\'file_type_function\' id=\'file_type_function\' value=\'\"+\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"+\"\' ><input type=\'Hidden\' name=\'patientID\' id=\'patientID\' value =\'\"+patient_id+\"\'><input type=\'Hidden\' name=\'file_mov_flag\' id=\'file_mov_flag\' value = \'\"+\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"+\"\' ></form></body></html>\";\n\t\t\t\teval(";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =".document).write(HTMLValue);\n\t\t\t\tif(eval(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =".document.Dummy_Form))\n\t\t\t\teval(";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =".document.Dummy_Form).submit();\n\t\t\t\t\n\t\t\t}\n\t\t}\n\n\t\tfunction populateDocumentType(obj)\n\t\t{\n\t\t\tdocument.forms[0].";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =".value = \'\';\n\t\t\tvar facility = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\tif(obj.value!=\'\')\n\t\t\t{\n\t\t\t\tdocFolderSearch(facility);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" ==  \"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar frame_name1 = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\t\t\n\t\t\t\t\tif(frame_name1==\'parent\')\n\t\t\t\t\t{   \n\t\t\t\t\t\t//This is for call having one layer of frame\n\t\t\t\t\t\tvar selectBox   =\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =");\n\t\t\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\t\t\tselectBox.remove(0);\n\t\t\t\t\t\tvar selectOption\t=  eval(";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{   \n\t\t\t\t\t\t//This portion is for calls with two level of frames \n\t\t\t\t\t\tvar selectBox   =\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =").document.createElement(\"OPTION\");\t\t\n\t\t\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\t\t\tselectOption.text\t=\t\"-----\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----\";\n\t\t\t\t\t\tselectBox.add(selectOption);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tasync function callSearchScreen()\n\t\t{\n\t\t\tvar retVal = await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'VIEW\');\n\t\t\tif(retVal !=null)\n\t\t\t\tdocument.getElementById(\"patient_id\").value = retVal ;\n\t\t\tdocument.getElementById(\"patient_id\").focus();\n\t\t}\n\t</SCRIPT>\n</head>\n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n<table width=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="%\" border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<tr>\n\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t<td  class=\'fields\' width=\"25%\"><input type=\'text\' id=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' name=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'value=\'\' onKeyPress=\"getBarcodeValue(event,this.value, \'file\');return CheckForSpecChars(event)\" maxlength=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" size=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"  onBlur=\'ChangeUpperCase(this);clearval(this);";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'  onchange=\'Clearencou(this);\' onkeyup=\"moveOnMax(this);\"  /> <!--Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494  Changes:newly added onkeyup function -->\n\t\t<input type=\'button\' class=\'button\' name=\'pat_search\' id=\'pat_search\' value=\'?\' align=center onClick=\'patientSearch();\'>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t</td>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t<td class=\'label\' nowrap width=\"25%\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t<td class=\'fields\' id=\'FileNo\' width=\"25%\"><input type=\"text\" id=\"FileNum\"  name=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"  onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\"ChangeUpperCase(this);getPatIDVolume(this.value);";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" maxlength=\"20\" size=\"20\" /> <!--Newly added  by Name :Selvin M  Date :12 july 2011 INCIDENT NO: 27494  Changes:newly added id --> \n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<img id=\"ingflag\"  src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\t\n\t\t</td>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t<td class=\'fields\' id=\'FileType\' name=\'FileType\' width=\"25%\"><input type=\"text\"  name=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" onBlur=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' readonly>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<img  id=\"ingflag1\"  src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\t\n\t\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n<tr>\n\t<td class=\'label\'  >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t<td class=\'fields\' id=\'volno\' name=\'volno\'><select name=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onchange=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="-----</option>\n\t</select>\n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\n\t</td>\n\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n</table>\n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\n<input type=\"hidden\" name=\"patientid_name\" id=\"patientid_name\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\"hidden\" name=\"patient_id_function\" id=\"patient_id_function\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\"hidden\" name=\"patline_ID\" id=\"patline_ID\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\"hidden\" name=\"patient_id_max_length\" id=\"patient_id_max_length\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\"hidden\" name=\"patline_yn\" id=\"patline_yn\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\n<input type=\"hidden\" name=\"fileno_name\" id=\"fileno_name\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> \n<input type=\"hidden\" name=\"file_no_function\" id=\"file_no_function\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\n<input type=\"hidden\" name=\"filetype_name\" id=\"filetype_name\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\"hidden\" name=\"file_type_function\" id=\"file_type_function\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<input type=\"hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\"hidden\" name=\"patient_file_type\" id=\"patient_file_type\" value=\"\">\n<input type=\"hidden\" name=\"patient_file_type_desc\" id=\"patient_file_type_desc\" value=\"\">\n\n<input type=\"hidden\" name=\"frame_name\" id=\"frame_name\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n<input type=\"hidden\" name=\"frame_name1\" id=\"frame_name1\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\"hidden\" name=\"messageframe_name\" id=\"messageframe_name\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\n<input type=\"hidden\" name=\"volumeno_name\" id=\"volumeno_name\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<input type=\"hidden\" name=\"volume_no_appl_yn\" id=\"volume_no_appl_yn\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\n<input type=\"hidden\" name=\"form_name\" id=\"form_name\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n<input type=\"hidden\" name=\"facilityID\" id=\"facilityID\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\"hidden\" name=\"maintain_doc_or_file\" id=\"maintain_doc_or_file\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n<input type=\"hidden\" name=\"chk_flag\" id=\"chk_flag\" value=\"Y\">\n<input type=\"hidden\" name=\"chk_flag1\" id=\"chk_flag1\" value=\"N\">\n<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n<input type=\"hidden\" name=\"fs_location\" id=\"fs_location\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n<input type=\"hidden\" name=\"file_volume\" id=\"file_volume\" value=\"FILE_VOLUME\">\n<input type=\"hidden\" name=\"file_mov_flag\" id=\"file_mov_flag\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n<input type=\"hidden\" name=\"file_mandatory_yn\" id=\"file_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t<input type=\"Hidden\" name=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" value=\"\">\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
Connection connection			= null;
PreparedStatement preStatement	= null;
ResultSet	resultSet			= null;

int patient_id_max_length =	0;

String file_type_appl_yn	= "N";
String facilityID			= "";

String patientid_name          = "";
String frame_name              = "";
String frame_name1             = "";
String form_name                = "";
String messageframe_name   = "";
String fileno_name               = "";
String filetype_name             = "";
String volumeno_name          = "";
String volume_no_appl_yn      = "";
String table_width	               = "";
String table_align	               = "";
String patient_id_function       = "";
String file_no_function		   = "";
String file_type_function	       = "";
String volume_no_function	       = "";
String patline_yn			    = "N";
String patline_ID			    = "";
String volume_mandatory_yn	    = "";
String patientid_mandatory_yn	= "";
String file_mandatory_yn	    = "";
String external_facility	    = "";

String fileNoTypeMantatoryYN	= "Y";

// For Document Feature Starts - 28/8/2004 .
String maintain_doc_or_file		= "F";
String document_folder_id_name	= "";
String document_folder_desc_name= "";
String document_folder_function	= "";
String document_type_name		= "";
String document_type_function	= "";
String document_or_file_req		= "";
String doctype_appl_yn          = "";
String locn_code				= "";
String file_mov_flag			= "";
// For Document Feature End.

// Function Name
String function_name = "";
String fs_location="";

try
{
	connection = ConnectionManager.getConnection(request);
	if(connection == null)
	{
		
            _bw.write(_wl_block4Bytes, _wl_block4);

	}

	facilityID 			= checkForNull((String) session.getValue("facility_id"));
	frame_name			= checkForNull(request.getParameter("frame_name"), "parent.frames[3]");
	locn_code = checkForNull(request.getParameter("locn_code"));	
	frame_name1			= checkForNull(request.getParameter("frame_name1"),"parent");//To get the frame for two level of reference. This will be null if called with one frame level. "parent" is a constant assigned to invoke the references where frame_name1 is passed as null from the calling file. 	
	form_name			= checkForNull(request.getParameter("form_name"), "forms[0]");
	messageframe_name	= checkForNull(request.getParameter("messageframe_name"), "parent.messageFrame");
	patientid_name		= checkForNull(request.getParameter("patientid_name"), "patient_id");
	fileno_name			= checkForNull(request.getParameter("fileno_name"), "file_no");
	
	filetype_name		= checkForNull(request.getParameter("filetype_name"), "file_type_code");
	volumeno_name		= checkForNull(request.getParameter("volumeno_name"), "volume_no");
	volume_no_appl_yn	= checkForNull(request.getParameter("volume_no_appl_yn"), "Y");
	table_width			= checkForNull(request.getParameter("table_width"), "100");
	table_align			= checkForNull(request.getParameter("table_align"), "CENTER");
	patient_id_function	= checkForNull(request.getParameter("patient_id_function"));
	
	//patient_id_function="FM_REQUEST_FILES";
	file_no_function	= checkForNull(request.getParameter("file_no_function"));
	file_type_function	= checkForNull(request.getParameter("file_type_function"));
	volume_no_function	= checkForNull(request.getParameter("volume_no_function"));
	patline_yn			= checkForNull(request.getParameter("patline_yn"), "N");
	patline_ID			= checkForNull(request.getParameter("patline_ID"), "patLineID");
	volume_mandatory_yn	= checkForNull(request.getParameter("volume_mandatory_yn"), "N");
	file_mandatory_yn	= checkForNull(request.getParameter("file_mandatory_yn"), "Y");
	external_facility	= checkForNull(request.getParameter("external_facility"));
	patientid_mandatory_yn	= checkForNull(request.getParameter("patientid_mandatory_yn"), "Y");
	
	/*Added by Dharma on 22nd Jan 2018 against ML-MMOH-CRF-0997 [IN:066013] Start*/
	fileNoTypeMantatoryYN	= checkForNull(request.getParameter("fileNoTypeMantatoryYN"), "Y");
	if(("N").equals(fileNoTypeMantatoryYN)){
		file_mandatory_yn = "N";
	}
	/*Added by Dharma on 22nd Jan 2018 against ML-MMOH-CRF-0997 [IN:066013]End*/


	fs_location	= checkForNull(request.getParameter("cuurfslocn"));
	file_mov_flag = checkForNull(request.getParameter("file_mov_flag"));	

	
	//  For Document Feature - 28/8/2004 starts.

	document_folder_desc_name	= checkForNull(request.getParameter("document_folder_desc_name"), "doc_folder_desc");			
	document_folder_id_name		= checkForNull(request.getParameter("document_folder_id_name"), "doc_folder_id");			
	document_folder_function	= checkForNull(request.getParameter("document_folder_function"));		
	document_type_name			= checkForNull(request.getParameter("document_type_name"), "doc_type_id");			
	document_type_function		= checkForNull(request.getParameter("document_type_function"));		
	document_or_file_req		= checkForNull(request.getParameter("document_or_file_req"));	
	doctype_appl_yn				= checkForNull(request.getParameter("doctype_appl_yn"), "Y");

	//	For Document Feature - 28/8/2004  ends. 	
	
	// Function Name
	function_name	= checkForNull(request.getParameter("function_name"));


	// This External Facility will be used when the External Facility File is requested.
	if(!external_facility.equals("")) facilityID = external_facility;

	preStatement	=	connection.prepareStatement("SELECT patient_id_length, file_type_appl_yn, maintain_doc_or_file FROM mp_param ");
	resultSet		=	preStatement.executeQuery();
	if((resultSet != null) && (resultSet.next()))
	{
		patient_id_max_length	=	resultSet.getInt("patient_id_length");
		file_type_appl_yn		=	checkForNull(resultSet.getString("file_type_appl_yn"), "N");
		maintain_doc_or_file	=	checkForNull(resultSet.getString("maintain_doc_or_file"), "F");
	}
	if(!document_or_file_req.equals("")) maintain_doc_or_file = document_or_file_req;
	if(maintain_doc_or_file.equals("D"))  volume_no_appl_yn = "N";

	if(preStatement != null) preStatement = null;
	if(resultSet != null) resultSet = null;

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(document_folder_id_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(document_type_function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(document_folder_function));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patline_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patline_ID));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fs_location));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(document_folder_id_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(document_type_function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(document_folder_function));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patline_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patline_ID));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fs_location));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(document_folder_desc_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(document_folder_id_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(document_folder_desc_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(document_folder_id_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(document_folder_desc_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patline_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patline_ID));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(frame_name1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(frame_name1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(document_type_name));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(frame_name1));
            _bw.write(_wl_block67Bytes, _wl_block67);
 if(maintain_doc_or_file.equals("F")) { 
	
	
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(table_width));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(table_align));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_id_max_length+2));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(patient_id_function));
            _bw.write(_wl_block76Bytes, _wl_block76);
 if(patientid_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm") ) { 
            _bw.write(_wl_block77Bytes, _wl_block77);
 } 
            _bw.write(_wl_block78Bytes, _wl_block78);
 if(file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block83Bytes, _wl_block83);
 if(file_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm")) { 
            _bw.write(_wl_block84Bytes, _wl_block84);
 } 
            _bw.write(_wl_block85Bytes, _wl_block85);
 } else if(file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(file_mandatory_yn.equals("Y") && !form_name.equals("FMChngStrLocnCriteriaForm")) { 
            _bw.write(_wl_block89Bytes, _wl_block89);
 } 
            _bw.write(_wl_block90Bytes, _wl_block90);
 } if(volume_no_appl_yn.equals("Y")) { 
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(volume_no_function));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
 if(volume_mandatory_yn.equals("Y")) { 
            _bw.write(_wl_block96Bytes, _wl_block96);
 } 
            _bw.write(_wl_block97Bytes, _wl_block97);
 } 
            _bw.write(_wl_block98Bytes, _wl_block98);
 
	}
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close();
	
	ConnectionManager.returnConnection(connection,request);
}


            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(patientid_name));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(patient_id_function));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(patline_ID));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(patline_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(frame_name1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(messageframe_name));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(volume_no_appl_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(fs_location));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(file_mov_flag));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(file_mandatory_yn));
            _bw.write(_wl_block122Bytes, _wl_block122);

	if((file_type_appl_yn.equals("Y"))|| (maintain_doc_or_file.equals("D")))
	{

            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block124Bytes, _wl_block124);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fileno.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
