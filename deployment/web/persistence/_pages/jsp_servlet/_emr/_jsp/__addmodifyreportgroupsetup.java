package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyreportgroupsetup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/addModifyReportGroupSetup.jsp", 1742295403118L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n      <head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\"></link>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<Script Language=\"JavaScript\" src=\"..//js/MRMaster.js\"></script>\n<script> \nfunction callGroupType(obj,frm_fun){\n\tdocument.forms[0].grp_type_mand.style.visibility = \"hidden\";\n\tdocument.forms[0].group_type_new.options[0].selected = true;\n\tdocument.forms[0].group_type_new.disabled=true;\n\n\tvar master=document.forms[0].type.value;\n\tvar report_id=document.forms[0].Report_Id.value;\n\tvar level=document.forms[0].Group_type.value\n    \n\t/*if(master==\'SP\' && level==\'S\' && report_id==\'MRIPCSBD\')\n\t{\n\t\tdocument.forms[0].group_type_new.disabled=false;\n\t\tvar obj_type = document.forms[0].group_type_new;\n\t\t\n\t\t\tvar length  = obj_type.length;\n\t\t\tfor(i=0;i<length;i++) \n\t\t\t{\n\t\t\t\tobj_type.remove(1);\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Isolation\'; \n\t\t\t\topt_type.value=\'I\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Unclassified\'; \n\t\t\t\topt_type.value=\'U\';\n\t\t\t\tobj_type.add(opt_type)\n\t\n\t}*/\n\tif ((master==\'BD\' && report_id==\'MRIPCSBD\') || (master==\'BD\' && report_id==\'MRIPCSOBD\'))\n\t\t{ //Above line modified for this CRF PER-PD-209A\n\t\t    var obj_type = document.forms[0].group_type_new;\n\t\t\tvar length  = obj_type.length;\n\t\t\tfor(i=0;i<length;i++) \n\t\t\t{\n\t\t\t\tobj_type.remove(1);\n\t\t\t}\n\t\t\tdocument.forms[0].Group_type.value = \"M\";\n\t\t\tdocument.forms[0].Main_Group.value = \"\";\n\t\t\tdocument.forms[0].Main_Group_desc.value = \"\";\n\t\t\tdocument.forms[0].mand_gif1.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].mand_gif2.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].Group_type.disabled = true;\n\t\t\tdocument.forms[0].Main_Group.disabled = true;\n\t\t\tdocument.forms[0].group_type_new.disabled=true;\n\t}\n\telse if((master==\'SP\' && report_id==\'MRIPCSBD\' && frm_fun==\"master\") || (master==\'SP\' && report_id==\'MRIPCSOBD\' && frm_fun==\"master\")){ //modified for PER-PD-209A\n\t\t\tdocument.forms[0].Group_type.disabled=false;\n\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\n\t\t\tvar obj_type1 = document.forms[0].Group_type;\n\t\t\tvar length1  = obj_type1.length;\n\t\t\tfor(i=0;i<length1;i++) {\n\t\t\t\tobj_type1.remove(1);\n\t\t\t}\n\t\t\t\tvar opt= document.createElement(\'Option\');\n//\t\t\t\topt.text=\'Level2 Group\'; \n\t\t\t\topt.text=getLabel(\"eMR.level2group.label\",\"eMR\"); \n\t\t\t\topt.value=\'S\';\n\t\t\t\tdocument.forms[0].Group_type.add(opt);\n\t}else if(master==\'NS\'){\n\t\tdocument.forms[0].grp_type_mand.style.visibility = \"visible\";\n\t\tdocument.forms[0].group_type_new.disabled=false;\n\t\tvar obj_type = document.forms[0].group_type_new;\n\t\t\tvar length  = obj_type.length;\n\t\t\tfor(i=0;i<length;i++) {\n\t\t\t\tobj_type.remove(1);\n\t\t\t}\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n//\t\t\t\topt_type.text=\'First Visit\'; \n\t\t\t\topt_type.text=getLabel(\"Common.firstvisit.label\",\"Common\"); \n\t\t\t\topt_type.value=\'F\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n//\t\t\t\topt_type.text=\'Follow-up Visit\'; \n\t\t\t\topt_type.text=getLabel(\"Common.followup.label\",\"Common\")+\" \"+getLabel(\"Common.Visit.label\",\"Common\"); ; \n\t\t\t\topt_type.value=\'U\';\n\t\t\t\tobj_type.add(opt_type)\n\t\n\t}else if(master==\'BC\' && report_id==\'MRBPD207\' && frm_fun==\"master\"){\n\t\t\tdocument.forms[0].Group_type.disabled=false;\n\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\n\t\t\tvar obj_type1 = document.forms[0].Group_type;\n\t\t\tvar length1  = obj_type1.length;\n\t\t\tfor(i=0;i<length1;i++) {\n\t\t\t\tobj_type1.remove(1);\n\t\t\t}\n\n\t\t\t\tvar opt= document.createElement(\'Option\');\n//\t\t\t\topt.text=\'Level2 Group\'; \n\t\t\t\topt.text=getLabel(\"eMR.level2group.label\",\"eMR\"); \n\t\t\t\topt.value=\'S\';\n\t\t\t\tdocument.forms[0].Group_type.add(opt);\n\t}else if(master==\'SP\' && report_id==\'MRBPD207\' && frm_fun==\"master\"){\n\t\t\tdocument.forms[0].group_type_new.options[0].selected = true;\n\t\t\tdocument.forms[0].group_type_new.disabled=true;\n\n\t\t\tdocument.forms[0].Group_type.disabled=true;\n\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\n\t\t\tvar obj_type1 = document.forms[0].Group_type;\n\t\t\tvar length1  = obj_type1.length;\n\t\t\tfor(i=0;i<length1;i++) {\n\t\t\t\tobj_type1.remove(1);\n\t\t\t}\n\n\t\t\t\tvar opt= document.createElement(\'Option\');\n//\t\t\t\topt.text=\'Level2 Group\'; \n\t\t\t\topt.text=getLabel(\"eMR.level2group.label\",\"eMR\"); \n\t\t\t\topt.value=\'S\';\n\t\t\t\tdocument.forms[0].Group_type.add(opt);\n\t}else{\n\t\t    var obj_type = document.forms[0].group_type_new;\n\t\t\tvar length  = obj_type.length;\n\t\t\tfor(i=0;i<length;i++) {\n\t\t\t\tobj_type.remove(1);\n\t\t\t}\n\t\t\t document.forms[0].group_type_new.disabled=true;\n\t}\n\tif(frm_fun==\"GC\"){\n\t\tchkgrptype();\n\t}\n\n}\n\nfunction chkgrptype(){\n\t\tif(document.forms[0].type.value == \'BC\'){\n\t\t\tdocument.forms[0].grp_type_mand.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].group_type_new.disabled=false;\n\t\t\tdocument.forms[0].group_type_new.options[0].selected = true;\n\t\t\tvar obj_type_gt = document.forms[0].group_type_new;\n\t\t\tvar length_gt  = obj_type_gt.length;\n\t\t\tfor(i=0;i<length_gt;i++) {\n\t\t\t\tobj_type_gt.remove(1);\n\t\t\t}\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n//\t\t\t\topt_type.text=\'Elective\'; \n\t\t\t\topt_type.text=getLabel(\"Common.elective.label\",\"Common\");  \n\t\t\t\topt_type.value=\'E\';\n\t\t\t\tobj_type_gt.add(opt_type);\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n//\t\t\t\topt_type.text=\'Emergency\'; \n\t\t\t\topt_type.text=getLabel(\"Common.emergency.label\",\"Common\");  \n\t\t\t\topt_type.value=\'M\';\n\t\t\t\tobj_type_gt.add(opt_type);\n\t}\n\n}\n\nfunction chkforenter(){\n\tvar key = window.event.keyCode;// allows only numbers to be entered\n\t\tif((key==13)) {\n\t\t\t\treturn false;\n\t\t}\n\n}\nfunction chkLimit(obj){\n\tvar str=obj.value;\n\tvar report_id=document.forms[0].Report_Id.value;\n\t\n\tif(report_id==\"MRIPCSMB\" || report_id==\"MROPCSMB\" || report_id==\"MROPCSMS\" || report_id==\"MRBLABRG\" || report_id==\"MRBRADEX\" || report_id==\"MRBLABWL\" || report_id==\"MRBSS203\" || report_id==\"OPBMTMOR\" || report_id==\"IPBMRMOT\" || report_id==\"IPBEXCDT\" || report_id==\"MRBBAT3A\" || report_id==\"MRBBAT3B\" || report_id==\"MRBBAT3C\" || report_id==\"MRDCPROD\" || report_id==\"MRDCPROS\"){\n\t  \n\t\tif(eval(str.length) > 150){\n\t\t\terror=getMessage(\"GROUP_NAME_LENGTH\",\'MR\');\n\t\t\terror=error.replace(\'#\',\'150\');\n\t\talert(error);\n\t    obj.focus();\n\t    obj.select();\n   \t    }\n\t}\n\telse if (report_id==\"MRIPCSMH\")\n\t\t{\n\t\tif(eval(str.length) > 45){\n\t\t\terror=getMessage(\"GROUP_NAME_LENGTH\",\'MR\');\n\t\t\terror=error.replace(\'#\',\'45\');\n\t\t\talert(error);\n\t    obj.focus();\n\t    obj.select();\n\n\t    }\n\t\t}\n\telse{\n\t\t\n\t\tif(eval(str.length) > 40){\n\t\t\terror=getMessage(\"GROUP_NAME_LENGTH\",\'MR\');\n\t\t\terror=error.replace(\'#\',\'40\');\n\t\t\talert(error);\n\t    obj.focus();\n\t    obj.select();\n\n\t    }\n    }\n}\nfunction chkLimit_range(obj){\n\tvar str=obj.value;\n\t\n\tif(eval(str.length) > 200)\n\t{\n\t\terror=getMessage(\"RANGE_LENGTH\",\'MR\');\n\t\talert(error);\n\t obj.focus();\n\t obj.select();\n\t}\n\n}\n\nfunction chknumber1(obj)\n{\n\tif(eval(obj.value)==0 || eval(obj.value)< 0)\n\t{\n\t\tvar msg=getMessage(\"INVALID_SERIAL_NO\",\'MR\');\n\t\tobj.focus();\n\t\tparent.frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t}\n}\n/////////////////////////////\nasync function getMainGroupId()\n{\n\t\t\n\t\tvar target= document.forms[0].Main_Group_desc;\n\t\tvar main_group=document.forms[0].Main_Group.value;\n\t\tvar report_gr_id = document.forms[0].Report_Id.value;\n\t\tvar master=document.forms[0].type.value;\n\t\t\n\t\tdocument.forms[0].LEVEL3_CODE_INSERT.value=\'\';\n\t\tdocument.forms[0].LEVEL3_CODE1.value=\'\';\n\t\tdocument.forms[0].range.value=\'\';\n\t\tvar group_type=document.forms[0].group_type_new.value;\n\t\t\n\t\tif(report_gr_id==\'MRBPD207\' && group_type==\'\')\n\t\t{\n\t\t\talert(\'APP-MR001 Please select Group Type\');\n\t\t\treturn false;\n\t\t}\n\t\tvar retVal\t=  new String();\n\t\tvar dialogTop\t\t\t= \"10\";\n\t\tvar dialogHeight\t\t= \"400px\" ;\n\t\tvar dialogWidth\t\t\t= \"700px\" ;\n\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc=\"\";\n\t\tvar search_code=\"\";\n\t\tvar title=getLabel(\"Common.Level.label\",\"Common\")+\'2 \'+getLabel(\"Common.Group.label\",\"Common\");\n\t\tvar sql=\"\";\n\t\tif(report_gr_id==\'MRIPCSBD\' || report_gr_id==\'MRIPCSOBD\')\n\t    { //Above line modified for this CRF PER-PD-209A\n\t\t    title=getLabel(\"Common.Level.label\",\"Common\")+\'1 \'+getLabel(\"Common.Group.label\",\"Common\"); \n\t\t\tsql=\"select group_code, group_desc from mr_report_grouping where REPORT_ID = `\"+report_gr_id+\"` and group_category = `M` and MAST_TABLE_NAME_REFERENCE=`\"+master+\"`\";\n\t\t}\n\t\telse if(report_gr_id==\'MRBPD207\')\n\t\t{\n\t\t\tsql=\"select group_code, group_desc from mr_report_grouping where report_id = `MRBPD207` and group_category = `M` and group_type = `\" +group_type + \"`\";\n\t\t}\n\t\telse\n\t    {\n\t\t sql=\"select group_code, group_desc from mr_report_grouping where REPORT_ID = `\"+report_gr_id+\"` and group_category = `M`\"\n\t\t}\n\t\n\t\tsearch_code=\"group_code\";\n\t\tsearch_desc=\"group_desc\";\n\t   \n\t\t  retVal= await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+title+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t   \n\t    var arr=new Array();\n\t    if (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t    document.forms[0].Main_Group_desc.value=arr[0];\n\t\t\tdocument.forms[0].Main_Group.value=arr[1];\n\t\t\tdocument.forms[0].Main_Group_desc.focus();\n\t\t}\n\t  \n\t}\n\n//////////////////////////////\nasync function getSubGroupId()\n{\n\t\tvar target= document.forms[0].LEVEL3_CODE1;\n\t\tdocument.forms[0].range.value=\'\';\n\t\tvar main_group=document.forms[0].Main_Group.value;\n\t\tvar report_gr_id = document.forms[0].Report_Id.value;\n\t\tvar retVal\t=  new String();\n\t\tvar dialogTop\t\t\t= \"10\";\n\t\tvar dialogHeight\t\t= \"400px\" ;\n\t\tvar dialogWidth\t\t\t= \"700px\" ;\n\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc=\"\";\n\t\tvar search_code=\"\";\n//\t\tvar title=\"Level3 Group\";\n\t\tvar title=getLabel(\"Common.Level.label\",\"Common\")+\'3 \'+getLabel(\"Common.Group.label\",\"Common\");\n\t\t\n        var sql=\"select group_code, group_desc from mr_report_grouping where report_id =`\"+report_gr_id+\"` and subgroup_code =`\"+main_group+\"` and group_category = `S` \" ;\n\t\t\n\t\tsearch_code=\"group_code\";\n\t\tsearch_desc=\"group_desc\";\n\t\tretVal= await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+title+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t  \n\t    var arr=new Array();\n\t    if (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t    document.forms[0].LEVEL3_CODE1.value=arr[0];\n\t\t\tdocument.forms[0].LEVEL3_CODE_INSERT.value=arr[1];\n\t\t\tdo";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="cument.forms[0].LEVEL3_CODE1.focus();\n\t\t}\n\t}\nfunction allowPositiveNumber() \n{\n\t\tvar key = window.event.keyCode;// allows only numbers to be entered\n\t\tif((key<48 )||(key>58)) \n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n}\n\t</script>\n\t<script>\n\tfunction change() {\n\t if (ReportGroupFrm.print_desc.checked == true)\n\t\t{\n\t\tReportGroupFrm.print_desc.value=\"Y\";\n\t    ReportGroupFrm.prn_desc.value=\'Y\';\n\t\t}\n\t else{\n\t\tReportGroupFrm.print_desc.value=\"N\";\n\t    ReportGroupFrm.prn_desc.value=\'N\';\n\t    }\n\t}\n\n\tfunction populate_main_group(obj)\n\t{\n\t\tif(document.forms[0].Group_type.value == \"S\" || document.forms[0].Group_type.value == \"G\")       \n\t\t  {\n\t\t\t\n\t\t\tvar HTMLVal = \"\";\n\t\t\t\n\t\t\tvar calledFromFinction = \"PDPLReportGroup\";\n\t\t\tvar ReportID = document.forms[0].Report_Id.value;\n\t\t\tvar MainGroup = document.forms[0].MainGroup.value;\n\t\t\tvar obj1=document.forms[0].Main_Group;\n\t\t\tvar length1=obj1.length;\n\t\t\t\n\t\t\tvar i;\n\t\t\tfor(i=0;i<length1;i++) \n\t\t\tobj1.remove(1);\n\n\t\t\tdocument.forms[0].Main_Group.disabled = false;\n\t\t\tdocument.forms[0].mand_gif2.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].LEVEL3_CODE1.disabled = false;\n\t\t\tdocument.forms[0].mand_gif3.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].sub_group11.disabled = false;\n\t\t\tdocument.forms[0].sub_group11_level2.disabled = false;\n\t\t\tdocument.forms[0].Main_Group_desc.disabled = false;\n\t\t\tdocument.forms[0].mand_gif4.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].range.disabled = false;\n\t\t\t\t\t\t\n\t\t\tif(document.forms[0].Group_type.value == \"S\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(ReportID==\'MRIPCSBD\' || ReportID==\'MRIPCSOBD\'){ //Modified for PER-PD-209A\n\t\t\t\tvar obj_type = document.forms[0].group_type_new;\n\t\t\t\tvar length  = obj_type.length;\n\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t{\n\t\t\t\tobj_type.remove(1);\n\t\t\t\t}\n\t\t\t\t\t//document.forms[0].type.options[0].selected=true;\n\t\t\t\t}\n\t\t\t\tvar obj1=document.forms[0].group_type_new;\n\t\t\tvar length1=obj1.length;\n\t\t\t\n\t\t\tvar i;\n\t\t\tfor(i=0;i<length1;i++) \n\t\t\tobj1.remove(1);\n\t\t\t\tdocument.forms[0].LEVEL3_CODE1.disabled = true;\n\t\t\t\tdocument.forms[0].Main_Group_desc.disabled = false;\n\t\t\t\tdocument.forms[0].sub_group11_level2.disabled = false;\n\t\t\t\tdocument.forms[0].sub_group11.disabled = true;\n\t\t        document.forms[0].mand_gif3.style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].mand_gif4.style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].range.disabled = true;\n\t\t\t\tdocument.forms[0].group_type_new.disabled=true;\n\t\t\t\t\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar ReportID = document.forms[0].Report_Id.value;\n\t\t\tif(ReportID==\'MRIPCSBD\' || ReportID==\'MRIPCSOBD\'){ //Modified for this CRF PER-PD-209A\n\t\t\t\tvar obj_type = document.forms[0].group_type_new;\n\t\t\t\tvar length  = obj_type.length;\n\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t{\n\t\t\t\tobj_type.remove(1);\n\t\t\t\t}\n\n\t\t\t\t\t//document.forms[0].type.options[0].selected=true;\n\t\t\t\t}\n\t\t\tdocument.forms[0].Main_Group_desc.value = \"\";\n\t\t\tdocument.forms[0].Main_Group.value = \"\";\n\t\t\tdocument.forms[0].Main_Group_desc.disabled = true;\n\t\t\tdocument.forms[0].Main_Group_desc.disabled = true;\n\t\t\tdocument.forms[0].sub_group11_level2.disabled = true;\n\t\t\tdocument.forms[0].mand_gif2.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].LEVEL3_CODE1.disabled = true;\n\t\t\tdocument.forms[0].sub_group11.disabled = true;\n\t\t\tdocument.forms[0].mand_gif3.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].mand_gif4.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].range.disabled = true;\n\t\t\tdocument.forms[0].group_type_new.disabled=true;\n\t\t}\n\t}\n\n\tfunction changereport(obj)\n\t{\n\t\t\t\n\t\t\tdocument.forms[0].no_of_bes.value=\"\" ; /*Added by Rameswar for  ML-MMOH-SCF-0450*/\n\t\t\tdocument.forms[0].LEVEL3_CODE1.value=\'\';\n\t\t\tdocument.forms[0].LEVEL3_CODE_INSERT.value=\'\';\n\t\t\tdocument.forms[0].LEVEL3_CODE1.disabled = true;\n\t\t\tdocument.forms[0].sub_group11.disabled = true;\n\t\t\tdocument.forms[0].mand_gif3.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].range.disabled = true;\n\t\t\tdocument.forms[0].mand_gif4.style.visibility = \"hidden\";\n\t\t\tdocument.forms[0].type.value=\'\';\n\t\t\tdocument.forms[0].range.value=\'\';\n\t\t\tdocument.forms[0].Main_Group.value = \"\";\n\t\t\tdocument.forms[0].Main_Group_desc.value = \"\";\n\t\t\tdocument.forms[0].group_type_new.value = \"\";\n\t\t\tdocument.forms[0].group_type_new.disabled = true;\n\n\t\t\t\n\t\t\t\t\n\t\t   var obj_type = document.forms[0].type;\n\t\t\n\t\t\tvar length  = obj_type.length;\n\t\t\tfor(i=0;i<length;i++) \n\t\t\t{\n\t\t\t\tobj_type.remove(1);\n\t\t\t}\n\n\t\t\tvar length  = document.forms[0].Main_Group.length;\n\t\t\tfor(i=0;i<length;i++) \n\t\t\t{\n\t\t\t\tdocument.forms[0].Main_Group.remove(1);\n\t\t\t}\n\n\t\t\tif(obj.value==\'IPBMIPCS\')\n\t\t\t{\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\t\n\n\t\t\t}else if(obj.value==\'MRIPCSEG\' || obj.value==\'MRBRH212\' ||obj.value==\'MROPANPO\' || obj.value==\'MROPCSEG\'){\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t/*opt_type.text=\'Race Group\'; \n\t\t\t\topt_type.value=\'RC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;*/\n\t\t\t\topt_type.text=getLabel(\"eMP.RaceGroup.label\",\"MP\"); \n\t\t\t\topt_type.value=\'RC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\t\n\t\t\t}else if(obj.value==\'IPBMCSBU\' ){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\t\n\n\t\t\t\t//document.getElementById(\'no_of_beds\').style.visibility = \'visible\';\n\t\t\t\t//document.getElementById(\'no_of_beds\').innerHTML=\"<td align=\'right\' class=label>No of Beds</td><td colspan=\'3\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\"Text\" rows=\'2\' name=\'no_of_bes\' id=\'no_of_bes\' value=\"\" size=\"12\" maxlength=\'3\'></td>\";\n\t\t\t}else if(obj.value == \'MRBSS203\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Order Catalog\'; \n\t\t\t\topt_type.value=\'OC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t//opt_type.selected = true;\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t//opt_type.selected = true;\n\t\t\t\tif(obj.value!=\'MRBSS203\')\n\t\t\t\t\topt_type.selected = true;\t*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.ordercatalog.label\",\"Common\"); \n\t\t\t\topt_type.value=\'OC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t//opt_type.selected = true;\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t//opt_type.selected = true;\n\t\t\t\tif(obj.value!=\'MRBSS203\')\n\t\t\t\t\topt_type.selected = true;\t\n\t\t\t}else if(obj.value==\'MRIPCSMH\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Delivery Type\'; \n\t\t\t\topt_type.value=\'DT\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'ICD Code\'; \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)\t\t\t\t\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t//opt_type.selected = true;*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"eMP.DeliveryType.label\",\"MP\"); \n\t\t\t\topt_type.value=\'DT\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.ICDCode.label\",\"Common\"); \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"eMP.RaceGroup.label\",\"MP\"); \n\t\t\t\topt_type.value=\'RC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"eMR.DelAttndBy.label\",\"MR\"); \n\t\t\t\topt_type.value=\'DA\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t/*End ML-MMOH-CRF-1341*/\n\t\t\t\t//opt_type.selected = true;\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse if(obj.value==\'MROPCSAT\' ||obj.value==\'MROPRFLS\' || obj.value==\'MRBRH203\'){//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1\n\t\t\t\tif(obj.value==\'MROPRFLS\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Healthcare Setting Type\'; \n\t\t\t\topt_type.value=\'HC\';\n\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.HealthcareSettingType.label\",\"Common\"); \n\t\t\t\topt_type.value=\'HC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t}\n\t\t\t\tif(obj.value==\'MRIPCSBD\' || obj.value==\'MRIPCSOBD\'){ //Modified for this CRF PER-PD-209A\n\t\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Bed Type\'; \n\t\t\t\t\topt_type.value=\'BT\';\n\t\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.bedtype.label\",\"Common\"); \n\t\t\t\t\topt_type.value=\'BT\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t}\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tif(obj.value!=\'MROPRFLS\' && obj.value!=\'MRIPCSBD\' || obj.value!=\'MROPRFLS\' && obj.value!=\'MRIPCSOBD\')\n\t\t\t\t\topt_type.selected = true;\t //above if condtion modified for this PER-PD-209A\n\t\t\t}else if(obj.value==\'MRIPCSBD\' || obj.value==\'MRIPCSOBD\'){ //Modified for this PER-PD-209A\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\topt_type.value=\'SP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Bed Class\'; \n\t\t\t\topt_type.value=\'BD\';\n\t\t\t\tobj_type.add(opt_type)\t\t\t\t\n\t\t\t\t*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.BedClass.label\",\"Common\"); \n\t\t\t\topt_type.value=\'BD\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t}else if( (obj.value == \'MRBRADEX\') || (obj.value == \'MRBLABWL\') || (obj.value == \'MRBLABRG\')){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Order Catalog\'; \n\t\t\t\topt_type.value=\'OC\';\n\t\t\t\tobj_type.add(opt_typ";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="e)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.ordercatalog.label\",\"Common\"); \n\t\t\t\topt_type.value=\'OC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\t\n\t\t\t}\n            else if((obj.value==\'MROPCSMB\') || (obj.value==\'MRIPCSMB\') || (obj.value==\'MROPCSMS\') || (obj.value==\'OPBMTMOR\') || (obj.value==\'IPBMRMOT\') || (obj.value==\'IPBEXCDT\') || (obj.value==\'MRDCCSMB\') || (obj.value==\'MRDCPROD\') || (obj.value==\'MRDCPROS\')){  //Modified for this CRF PER-RH-0206\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Tabulation List\'; \n\t\t\t\topt_type.value=\'TL\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;*/\n\t\t\t\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"eMR.TabulationList.label\",\"MR\"); \n\t\t\t\topt_type.value=\'TL\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\topt_type.selected = true;\n\t\t\t\t//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349\n\t\t\t\t//MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532\n\t\t\t\tif(obj.value==\'MROPCSMS\' || obj.value==\'MRDCPROS\'){\n\t\t\t\t\tdocument.forms[0].range.disabled = false;\n\t\t\t\t    document.forms[0].mand_gif4.style.visibility = \"visible\";\n\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(obj.value==\'MRBRADEX\' || obj.value==\'MRBLABRG\' || obj.value==\'MRIPCSBD\' || obj.value==\'OPBMTMOR\' || obj.value==\'IPBMRMOT\' || obj.value==\'IPBEXCDT\' || obj.value==\'MRIPCSOBD\')\n\t\t\t{  //Above line modified for this PER-PD-209A\n\t\t\t\tdocument.forms[0].Group_type.disabled = false;\n\t\t\t\tdocument.forms[0].mand_gif1.style.visibility = \"visible\";\n\t\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\n\t\t\t\tobj_type=document.forms[0].Group_type\n\t\t\t\tvar length  = obj_type.length;\n\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t{\n\t\t\t\t\tobj_type.remove(1);\n\t\t\t\t}\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n//\t\t\t\topt_type.text=\'Level1 Group\'; \n\t\t\t\topt_type.text=getLabel(\"Common.Level.label\",\"Common\")+\'1 \'+getLabel(\"Common.Group.label\",\"Common\"); \n\t\t\t\topt_type.value=\'M\';\n//\t\t\t    opt_type.text=\'Level2 Group\'; \n\t\t\t    opt_type.text=getLabel(\"Common.Level.label\",\"Common\")+\'2 \'+getLabel(\"Common.Group.label\",\"Common\"); \n\t\t\t\topt_type.value=\'S\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t}else if((obj.value==\'MRIPCSMB\') || (obj.value==\'MRDCCSMB\') || (obj.value==\'MROPCSMB\')){ //Modified for this CRF PER-RH-0206 //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532\n\t\t\t\t\tdocument.forms[0].Group_type.disabled = false;\n\t\t\t\t    document.forms[0].mand_gif1.style.visibility = \"visible\";\n\t\t\t\t    document.forms[0].Group_type.options[0].selected = true;\n\t\t\t\t\tif(document.forms[0].Group_type.length <=2){\n\t\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\t\tobj_type=document.forms[0].Group_type\n//\t\t\t\t\t\topt_type.text=\'Level3 Group\'; \n\t\t\t\t\t\topt_type.text=getLabel(\"Common.Level.label\",\"Common\")+\'3 \'+getLabel(\"Common.Group.label\",\"Common\"); \n\t\t\t\t\t\topt_type.value=\'G\';\n\t\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\t}\n\t\t\t\t}else if(obj.value==\'MRBPD207\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Specialty\'; \n\t\t\t\t\topt_type.value=\'SP\';\n\t\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\t\topt_type.value=\'SP\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Billing Service Classification\'; \n\t\t\t\t\topt_type.value=\'BC\';*/\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.Billing.label\",\"Common\")+\" \"+getLabel(\"eBL.SERVICE_CLASSIFICATION.label\",\"BL\"); \n\t\t\t\t\topt_type.value=\'BC\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t}else if(obj.value==\'IPBMCREF\'){\n\t\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Nursing Unit\'; \n\t\t\t\t\topt_type.value=\'NU\';\n\t\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.nursingUnit.label\",\"Common\"); \n\t\t\t\t\topt_type.value=\'NU\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Clinic/Procedure Unit\'; \n\t\t\t\t\topt_type.value=\'CP\';\n\t\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.clinic.label\",\"Common\")+\"/\"+getLabel(\"Common.ProcedureUnit.label\",\"Common\"); \n\t\t\t\t\topt_type.value=\'CP\';\n\t\t\t\t\tobj_type.add(opt_type)\n\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=\'Healthcare Setting\'; \n\t\t\t\t\topt_type.value=\'HC\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\t\topt_type.text=getLabel(\"Common.speciality.label\",\"Common\"); \n\t\t\t\t\topt_type.value=\'SP\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\t\n\t\t\t\t\t/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/\n\t\t\t\t\tvar opt_type = document.createElement(\'Option\');\n\t\t\t\t\topt_type.text = getLabel(\"Common.Staff.label\",\"Common\")+\" \"+getLabel(\"Common.clinic.label\",\"Common\"); \n\t\t\t\t\topt_type.value = \'SC\';\n\t\t\t\t\tobj_type.add(opt_type)\n\t\t\t\t\t/*End ML-MMOH-CRF-1340*/\n\n\t\t\t}else if(obj.value==\'MRBBAT3A\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'ICD Code\'; \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.ICDCode.label\",\"Common\"); \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Name Suffix\'; \n\t\t\t\topt_type.value=\'NS\';\n\t\t\t\tobj_type.add(opt_type)\t\t\t\t\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Disposal\'; \n\t\t\t\topt_type.value=\'DP\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Healthcare Setting\'; \n\t\t\t\topt_type.value=\'HC\';\n\t\t\t\tobj_type.add(opt_type)\n\t\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\tdocument.forms[0].Group_type.disabled = true;\n\t\t\t}else if(obj.value==\'MRBBAT3B\' || obj.value==\'MRBBAT3C\'){\n\t\t\t\t/*var opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'ICD Code\'; \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)*/\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=getLabel(\"Common.ICDCode.label\",\"Common\"); \n\t\t\t\topt_type.value=\'IC\';\n\t\t\t\tobj_type.add(opt_type)\t\t\t\t\n\t\t\t\tvar opt_type= document.createElement(\'Option\');\n\t\t\t\topt_type.text=\'Healthcare Setting\'; \n\t\t\t\topt_type.value=\'HC\';\n\t\t\t\tobj_type.add(opt_type)\t\n\t\t\t\tdocument.forms[0].Group_type.options[0].selected = true;\tdocument.forms[0].Group_type.disabled = true;\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].Group_type.value = \"M\";\n\t\t\t\tdocument.forms[0].Main_Group.value = \"\";\n\t\t\t\tdocument.forms[0].Main_Group_desc.value = \"\";\n\t\t\t\tdocument.forms[0].mand_gif1.style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].mand_gif2.style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].Group_type.disabled = true;\n\t\t\t\tdocument.forms[0].Main_Group.disabled = true;\n\t\t\t}\n\t}\n\t/*This function was removed by Calling from the Onchange of Report Drop down List(i.e 5.x code). On 12/9/2009 for Incident:17000*/\n\tfunction ClearFunction(){\n\t\t\n\t\t \n\t\tif(document.forms[0].Report_Id.value!=\"IPBMCSBU\"){ \n\t\n\t\t\tdocument.getElementById(\"no_of_beds\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"no_of_beds_0\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"no_of_beds_1\").style.display = \"none\";\n\t\t}\n\t\tif(document.forms[0].Report_Id.value==\"IPBMIPCS\" ){ \n\t\t\n\t\t\tdocument.getElementById(\"no_of_beds\").style=\"display\";\n\t\t\t//document.getElementById(\"no_of_beds_1\").style.display = \"none\";\n\t\t}\n\t\tif(document.forms[0].Report_Id.value==\"IPBMCSBU\" ){ \n\t\t     document.getElementById(\"no_of_beds_0\").style=\"display\";\n\t\t\tdocument.getElementById(\"no_of_beds_1\").style=\"display\";\n\t\t} \n\t\t\n\t}\n\tfunction calllevel3()\n\t{\n\n\t\t\t\n\t\t\t\n\t\t if(document.forms[0].LEVEL3_CODE1!=null)\n\t\t {\n\t\t   document.forms[0].LEVEL3_CODE1.value=\'\';\n\t\t   document.forms[0].LEVEL3_CODE_INSERT.value=\'\';\n\t\t   \n\t\t }\n\t\t if(document.forms[0].Group_type.value == \"G\")\n\t\t {\n\t\t\tvar HTMLVal = \"\";\n\t\t\tvar calledFromFinction = \"PDPLReportGroup_level3\";\n\t\t\tvar ReportID = document.forms[0].Report_Id.value;\n\t\t\tvar MainGroup = document.forms[0].MainGroup.value;\n\t\t\tvar sub_group_code_l2=document.forms[0].Main_Group.value;\n\t\t\t\n\t\t\tdocument.forms[0].LEVEL3_CODE1.disabled = false;\n\t\t\tdocument.forms[0].sub_group11.disabled = false;\n\t\t\tdocument.forms[0].mand_gif3.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].mand_gif4.style.visibility = \"visible\";\n\t\t\tdocument.forms[0].range.disabled=false;\n\n\t\t}\n\n\t}\n\t/*This function was removed by Calling from the Onload of Body(i.e 5.x code). On 12/9/2009 for Incident:17000*/\n\tfunction loadDefaults()\n\t{ \n\t       \n\t\t\t\n        if(document.forms[0].Report_Id.value==\"\"){\n\t\t\tdocument.getElementById(\"no_of_beds\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"no_of_beds_0\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"no_of_beds_1\").style.display = \"none\";\n\t\t\t\n\t\t\t}\n\t\tif(document.forms[0].Report_Id.value !=\"\" && document.forms[0].Report_Id.value !=\"IPBMCSBU\"){\n\t\t    document.getElementById(\"no_of_beds_0\").style.display = \"none\";\n\t\t    document.getElementById(\"no_of_beds_1\").style.display = \"none\"\n\t\t\t}\n\t\t\t\n\t\tif(document.forms[0].Report_Id.value !=\"\"  && document.forms[0].Report_Id.value==\"IPBMCSBU\"){\n\t\t     \n\t\t\t  document.getElementById(\"no_of_beds\").style.display = \"none\";\n\t          document.getElementById(\"no_of_beds_0\").style.display = \"\";\n\t\t\t  document.getElementById(\"no_of_beds_1\").style.display = \"\";\n\t\t\n\t\t\n\t\t\t   }\n\t\t if(document.forms[0].Report_Id.value==\"MRBPD207\" && document.forms[0].type.value==\"BC\" && document.forms[0].group_type_new.value !=\"\"){   \n\t\t \tdocument.forms[0].grp_type_mand.style.visibility = \"visible\";\n\t\t }/*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467*/\n\t}\n\t\n\t\n\t\n\t\tfunction chkForNumeric(event){\n\t\t\tvar strCheck = \'0123456789 \';\n\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\t \n\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\t \n\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\treturn true ;\n\t\t\t }\n\t</script>\n    </head>\n\n\t<body OnMouseDown=\'CodeArrest()\' onload=\'change();FocusFirstElement();loadDefaults();\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n      \t<form name=\'ReportGroupFrm\' id=\'ReportGroupFrm\' action=\'../../servlet/eMR.ReportGroupMasterServlet\' method=\'post\' target=\'messageFrame\'>\n      \t<div align=\'left\'>      \n      \t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\t\t\t\n\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t<tr>\n\t\t\t<td colspan=\'1\' width=\"18%\">&nbsp;</td>\n\t\t\t<td colspan=\'1\' width=\"46%\">&nbsp;</td>\n\t\t\t<td colspan=\'1\' width=\"12%\">&nbsp;</td>\n\t\t\t<td colspan=\'1\' width=\"24%\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  align=\'right\' colspan=\'1\' class=label>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t    <td  colspan=\'3\'>\n\t\t\t\t       &nbsp;&nbsp;&nbsp;<select name=\"Report_Id\" id=\"Report_Id\" onchange=\"changereport(this);ClearFunction();\"> <!-- ClearFunction function is added by Rameswar for  ML-MMOH-SCF-0450 -->\n\t\t\t    <option value=\"\">--- ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ---</option>\n\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</select>\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t\t  </tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t  <tr>\n\t\t\t  <td align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n    \t\t    <td colspan=\'3\'>&nbsp;&nbsp;&nbsp;<select name=\'type\' id=\'type\' onchange=\"callGroupType(this,\'master\'),chkgrptype();\"><option value=\"\" selected>--- ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="   \n                  </SELECT>\n    \t \t\t  <img src=\'../../eMP/images/mandatory.gif\'>\n    \t\t      </td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t<!-- ragha -->\n\n\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr>\n\t\t\t\t<td   align=\'right\' class=label>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td  colspan=\'1\'>&nbsp;&nbsp;&nbsp;<select name=\"Group_type\" id=\"Group_type\" onchange=\'populate_main_group(this);callGroupType(this,\"GC\");\' disabled> \n\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t</select>\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" id=\'mand_gif1\' style=\"visibility:hidden\"></td>\n\t\t\t\t\t<td align=\'right\' class=label>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t   \t<td colspan=\'1\' align=\'left\'>&nbsp;&nbsp;&nbsp;<select name=\'group_type_new\' id=\'group_type_new\' disabled ><option value=\'\' selected>--- Select ---</option>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \t\n\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" id=\'grp_type_mand\' style=\"visibility:hidden\">\n\t\t\t\t\t</td>\n    \t</tr>\n\t\t\t\n\t\t\t  <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t<tr>\n      \t\t    <td align=\'right\'  colspan=\'1\' class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n      \t\t    <td  colspan=\'3\'>&nbsp;&nbsp;\n      \t\t    <input type=\'text\' name=\'group_code\' id=\'group_code\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" size=\'25\' maxlength=\'15\' onKeyPress=\"return CheckForSpecChars(event)\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n      \t\t    <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n     \t\t </tr>\n      \t\n\t\t\t  <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t \t\t\t\t\n      \t\n\t\t\t <tr>\n\t\t\t <td   align=\'right\' class=label>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n      \t\t    <td  colspan=\'3\'>&nbsp;&nbsp;\n      \t\t    <textarea rows=2  cols=50 name=\"group_name\" onkeyPress=\"checkMaxLimit(this,150);return chkforenter();\"   value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onBlur=\" makeValidString(this);";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="chkLimit(this);";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</textarea> \n      \t\t    <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t\t\t \n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t \t   <tr id=\"no_of_beds\"  >\n\t\t\t   <td align=\'right\' class=label>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t   \t<td colspan=\'3\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\"Text\" rows=\'2\' name=\'no_of_bes\' id=\'no_of_bes\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" size=\"12\" maxlength=\'3\'></td>\n\t\t\t </tr>\n\t\t\t \n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t \t   <tr id=\"no_of_beds_0\" style=\"\" >\n\t\t\t   <td align=\'right\' class=label>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t   \t<td colspan=\'3\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\"Text\" rows=\'2\' name=\'no_of_bes_0\' id=\'no_of_bes_0\'  onKeyPress=\'return chkForNumeric(event);\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\"12\" maxlength=\'3\'></td>\n\t\t\t </tr>\n\t\t\t   <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t   \n\t\t\t   <!--venkat-->\n\t\t\t   <tr id=\"no_of_beds_1\" style=\"\" >\n\t\t\t   <td align=\'right\' class=label>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t   \t<td colspan=\'3\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\"Text\" rows=\'2\' name=\'no_of_bes_1\' id=\'no_of_bes_1\' onKeyPress=\'return chkForNumeric(event);\'   value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\"12\" maxlength=\'3\'></td>\n\t\t\t </tr>\n\t\t\t   <!--venkat-->\n\t\t\t\t\t \t\t\t\t\n      \t\t<tr>\n\t\t\t\t\t<td   align=\'right\' class=label>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name=\"Main_Group_desc\" onkeyPress=\'checkMaxLimit(this,150)\' disabled onBlur=\"return makeValidString(this);\" >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</textarea><input type=\"button\" disabled name=\"sub_group11_level2\" id=\"sub_group11_level2\" value=\"?\" class=\"BUTTON\" onClick=\"getMainGroupId();\"> \n\t\t\t\t\t\t<input type=\'hidden\' name=\"Main_Group\" id=\"Main_Group\" disabled value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\'mand_gif2\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;\n\t\t\t\t\t\t<textarea rows=2  cols=50 name=\"Main_Group_desc\" disabled readonly value=\"\"></textarea><input type=\"button\" disabled name=\"sub_group11_level2\" id=\"sub_group11_level2\" value=\"?\" class=\"BUTTON\" onClick=\"getMainGroupId();\">\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif2\'><input type=\'hidden\' name=\"Main_Group\" id=\"Main_Group\" value=\"\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t</td>\n\t\t\t</tr>\n                  <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t\t<tr>\n\t\t\t\t<!-- Newly added on 25/08/2005 shyam-->\n\t\t\t\n\t\t\t\t<td   align=\'right\' class=label>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name=\"LEVEL3_CODE12\" onkeyPress=\'checkMaxLimit(this,150)\' disabled onBlur=\"return makeValidString(this);\" >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</textarea><input type=\"button\" disabled name=\"sub_group11\" id=\"sub_group11\" value=\"?\" class=\"BUTTON\" onClick=\"getSubGroupId();\"> \n\t\t\t\t<input type=\'hidden\' name=\"LEVEL3_CODE12\" id=\"LEVEL3_CODE12\" disabled value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n\n\t\t\t\t<input type=\'hidden\' name=\"LEVEL3_CODE_MODIFY\" id=\"LEVEL3_CODE_MODIFY\" value=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif3\'></td>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;\n\t\t\t\t<textarea rows=2  cols=50 name=\"LEVEL3_CODE1\" disabled readonly value=\"\"></textarea><input type=\"button\" disabled name=\"sub_group11\" id=\"sub_group11\" value=\"?\" class=\"BUTTON\" onClick=\"getSubGroupId();\">\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif3\'><input type=\'hidden\' name=\"LEVEL3_CODE_INSERT\" id=\"LEVEL3_CODE_INSERT\" value=\"\"></td>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\n\t\t</tr>\n\n<!-- ragha -->\n        <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t <td align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t <td colspan=\'3\' align=\'left\'>&nbsp;&nbsp;\n\t\t\t     ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t <textarea rows=2  cols=50 name=\"range\" onkeyPress=\'checkMaxLimit(this,200)\' disabled >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</textarea>\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif4\'>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<textarea rows=2  cols=50 name=\"range\" onkeyPress=\'checkMaxLimit(this,200)\' onblur=\"chkLimit_range(this);\" disabled></textarea>\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif4\'>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t</td>\n\t\t\t\t\n     \t\t    \n\t\t\t    \n      \t\t</tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t</tr>\n\t\t\t<tr>\n           \n\t\t\t\t<td  align=\'right\' class=label>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t<td  class=label align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' name=\'serial_no\' id=\'serial_no\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'  onBlur=\"chknumber1(this);\" onkeypress=\"return allowPositiveNumber()\"><img src=\'../../eCommon/images/mandatory.gif\'></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'checkbox\' name=\'print_desc\' id=\'print_desc\' value=\"\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="  onClick=\"change()\">&nbsp;&nbsp;&nbsp;<input type=\'hidden\' name=\'prn_desc\' id=\'prn_desc\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'></td>\n\t\t\t\t\n      \t\t</tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n      \t</table>\n      \t</div>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n      \t\t<tr>\n\t\t\t\t<td   align=\'right\' class=label>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;&nbsp;<textarea rows=2  cols=50 name=\"Main_Group_desc\" onkeyPress=\'checkMaxLimit(this,150)\' disabled onBlur=\"return makeValidString(this);\" >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</textarea><input type=\"button\" disabled name=\"sub_group11_level2\" id=\"sub_group11_level2\" value=\"?\" class=\"BUTTON\" onClick=\"getMainGroupId();\"> \n\t\t\t\t<input type=\'hidden\' name=\"Main_Group\" id=\"Main_Group\" disabled value=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="><img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\'mand_gif2\'></td>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<td  colspan=\'3\'>&nbsp;&nbsp;\n\t\t\t\t<textarea rows=2  cols=50 name=\"Main_Group_desc\" disabled readonly value=\"\"></textarea><input type=\"button\" disabled name=\"sub_group11_level2\" id=\"sub_group11_level2\" value=\"?\" class=\"BUTTON\" onClick=\"getMainGroupId();\"><img src=\"../../eCommon/images/mandatory.gif\" style=\"visibility:hidden\" id=\'mand_gif2\'><input type=\'hidden\' name=\"Main_Group\" id=\"Main_Group\" value=\"\"></td>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\n\t\t\t    </td>\n\t\t\t\t</tr>\n                  <tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t\t<tr>\n\t\t\t\t<!-- Newly added on 25/08/2005 shyam-->\n\t\t\t\n\t\t\t\t<td   align=\'right\' class=label>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\n\t\t</tr>\n\n<!-- ragha -->\n        <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t<tr>\n\t\t\t\t <td align=\'right\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t</td>\n\t\t\t\t\n     \t\t    \n\t\t\t    \n      \t\t</tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n\t\t\t<tr>\n           \n\t\t\t\t<td  align=\'right\' class=label>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t<td  colspan=\'2\' class=label align=\'left\'>&nbsp;&nbsp;&nbsp;\n\t\t\t\t<input type=\'text\' name=\'serial_no\' id=\'serial_no\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'></td>\n\n      \t\t</tr>\n\t\t\t <!-- <tr><td colspan=\'4\'>&nbsp;</td></tr> -->\n      \t</table>\n      \t</div>\n\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n        \t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n      ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\n      \t<input type=\'hidden\' name=\'Report_Id_hid\' id=\'Report_Id_hid\' value=\'\'>\n      \t<input type=\'hidden\' name=\'Group_type_hid\' id=\'Group_type_hid\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\n      \t<input type=\'hidden\' name=\'Main_Group_hid\' id=\'Main_Group_hid\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n      \t<input type=\'hidden\' name=\'type_hid\' id=\'type_hid\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\n\t\t<script>\n\t\t\tdocument.forms[0].Report_Id.disabled = true;\n\t\t\tdocument.forms[0].Group_type.disabled = true;\n\t\t\tdocument.forms[0].Main_Group.disabled = true;\n\t\t\tdocument.forms[0].type.disabled = true;\n\t\t</script>\n     ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<input type=\"hidden\" name=\"err_msg\" id=\"err_msg\" value=\'\'>\n\t\t<script>\n\t\t\tvar msg = getMessage(\'DUPLI_SRL_NO\',\'MR\');\n\t\t\tdocument.ReportGroupFrm.err_msg.value = msg;\n\t\t</script>\n\n      \t  <input type=\"hidden\" name=\"order_serial_no\" id=\"order_serial_no\" value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t  <input type=\"hidden\" name=\"newstatus\" id=\"newstatus\" value=\'N\'>\n\t\t  <input type=\'hidden\' name=\'MainGroup\' id=\'MainGroup\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n     \t</form>\n      \t</body>\n      \t</html>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
 /*loadDefaults function is added by Rameswar for  ML-MMOH-SCF-0450*/
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
   boolean status = false;
   String sql="";
   Connection conn=null;
   Statement stmt=null;
   PreparedStatement psmt=null;
   ResultSet rset=null;
   String code="";
   String name="";
   //String id="";
   String table_reference="";
   String report_desc_temp="";
   String reference="";
   String order_serial_no="";
   String print_desc_yn="";
   String check_attribute="";
   String group_category ="";
   String subgroup_code ="";
   String subgroup_desc ="";
   String codeTextAttribute="";
   String m_select="";
   String s_select="";
   String g_select="";
   String LEVEL3_CODE="";
   String LEVEL3_CODE_DESC="";
   String mode="";
   String level3_range="";
   String group_type_desc="";
   String group_type_desc_value="";
   String Report_Id="IPBMCSBU";/*IPBMCSBU is added by Rameswar for  ML-MMOH-SCF-0450*/
   String no_of_bes = "";
   String no_of_bes_1 = "";
   String no_of_bes_0 = "";


try
{
	conn=ConnectionManager.getConnection(request);
	code=request.getParameter("GROUP_CODE")==null?"":request.getParameter("GROUP_CODE");
	 String rep_id=request.getParameter("REPORT_ID")==null?"":request.getParameter("REPORT_ID");

	 String table_ref=request.getParameter("MAST_TABLE_NAME_REFERENCE")==null?"":request.getParameter("MAST_TABLE_NAME_REFERENCE");
	 mode=request.getParameter("mode");
	 if(mode==null || mode.equals("null"))
	{
		 mode="";
	}

	if(code==null || code.equals(""))
	{
		code="";
		name="";
        //id="";
        table_reference="";
		status=true;
		codeTextAttribute="";

	}
		else if(!code.equals(""))
		{
			try{
			//stmt = conn.createStatement();
            if(table_ref.equals("Delivery Type"))
				table_ref="DT";
				if(table_ref.equals("HealthCare Setting Type"))
				table_ref="HC";
				if(table_ref.equals("Race Group"))
				table_ref="RC";
				if(table_ref.equals("Specialty"))
				table_ref="SP";
				if(table_ref.equals("Order Catalog"))
				table_ref="OC";
				if(table_ref.equals("Tabulation List"))
				table_ref="TL";
				if(table_ref.equals("Bed Type"))
				table_ref="BT";
				if(table_ref.equals("ICD Code"))
				table_ref="IC";
				if(table_ref.equals("Nursing Unit"))
				table_ref="NU";
				if(table_ref.equals("Clinic"))
				table_ref="CL";
				if(table_ref.equals("Clinic/Procedure Unit"))
				table_ref="CP";
				if(table_ref.equals("Bed Class"))
				table_ref="BD";
				if(table_ref.equals("Disposal"))
				table_ref="DP";
				if(table_ref.equals("Name Suffix"))
				table_ref="NS";
				//Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
				if(table_ref.equals("Staff Clinic"))
				table_ref="SC";
				//Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
				if(table_ref.equals("Delivery Attended By"))
				table_ref="DA";


			sql = "select a.GROUP_TYPE,a.GROUP_CODE,a.LEVEL3_RANGE,a.GROUP_DESC,a.LEVEL3_CODE, a.report_id,a.mast_table_name_reference,a.ORDER_BY_SRL_NO,a.subgroup_code, (CASE WHEN a.subgroup_code IS NOT NULL THEN (SELECT group_desc FROM mr_report_grouping WHERE group_code = a.subgroup_code AND report_id = a.report_id AND mast_table_name_reference = a.mast_table_name_reference) END) sub_group_desc,(CASE WHEN a.LEVEL3_CODE IS NOT NULL THEN (SELECT group_desc FROM mr_report_grouping WHERE group_code = a.LEVEL3_CODE AND report_id = a.report_id AND mast_table_name_reference = a.mast_table_name_reference) END) level_code_desc,a.group_category,a.PRINT_DESC_YN, b.REPORT_DESC, a.no_of_beds_for_splty, no_of_oper_beds_for_splty,no_of_ofcl_beds_for_splty  from MR_REPORT_GROUPING a,sm_report b where a.report_id=b.report_id and GROUP_CODE=? and a.REPORT_ID=? and MAST_TABLE_NAME_REFERENCE=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,code);
			psmt.setString(2,rep_id);
			psmt.setString(3,table_ref);
			rset = psmt.executeQuery();
			while(rset.next())
			 {
				code	=rset.getString("GROUP_CODE");
				name	=rset.getString("GROUP_DESC");
				group_category =rset.getString("GROUP_CATEGORY")==null?"":rset.getString("GROUP_CATEGORY");
				subgroup_code =rset.getString("SUBGROUP_CODE")==null?"":rset.getString("SUBGROUP_CODE");
				subgroup_desc =rset.getString("sub_group_desc")==null?"":rset.getString("sub_group_desc");
				LEVEL3_CODE =rset.getString("LEVEL3_CODE")==null?"":rset.getString("LEVEL3_CODE");
				LEVEL3_CODE_DESC =rset.getString("level_code_desc")==null?"":rset.getString("level_code_desc");
				level3_range =rset.getString("LEVEL3_RANGE")==null?"":rset.getString("LEVEL3_RANGE");
				group_type_desc =rset.getString("GROUP_TYPE")==null?"":rset.getString("GROUP_TYPE");
				no_of_bes = rset.getString("no_of_beds_for_splty")==null?"":rset.getString("no_of_beds_for_splty");
				no_of_bes_1 = rset.getString("no_of_oper_beds_for_splty")==null?"":rset.getString("no_of_oper_beds_for_splty");
				no_of_bes_0 = rset.getString("no_of_ofcl_beds_for_splty")==null?"":rset.getString("no_of_ofcl_beds_for_splty");

				table_reference	=rset.getString("MAST_TABLE_NAME_REFERENCE");
				if(table_reference.equals("DT"))
				reference="Delivery Type";
				if(table_reference.equals("NU"))
				reference="Nursing Unit";
				if(table_reference.equals("CL"))
				reference="Clinic";
				if(table_reference.equals("CP"))
				reference="Clinic/Procedure Unit";
				if(table_reference.equals("HC"))
				reference="HealthCare Setting Type";
				if(table_reference.equals("RC"))
				reference="Race Group";
				if(table_reference.equals("SP"))
				reference="Specialty";
				if(table_reference.equals("OC"))
				reference="Order Catalog";
				if(table_reference.equals("TL"))
				reference="Tabulation List";
				if(table_reference.equals("BT"))
				reference="Bed Type";
				if(table_reference.equals("IC"))
				reference="ICD Code";
				if(table_reference.equals("BC"))
				reference="Billing Service Classification";
				if(table_reference.equals("BD"))
				reference="Bed Class";
				if(table_reference.equals("DP"))
				reference="Disposal";
				if(table_reference.equals("NS"))
				reference="Name Suffix";
				//Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
				if(table_reference.equals("SC"))
				reference="Staff Clinic";
				//Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
				if(table_reference.equals("DA"))
				reference="Delivery Attended By";
					


				report_desc_temp =rset.getString("REPORT_DESC");
				order_serial_no	=rset.getString("ORDER_BY_SRL_NO");
                print_desc_yn	=rset.getString("PRINT_DESC_YN");
                 /*Below else condition modified for PER-PD-209A*/
				 if(group_type_desc.equals("I"))
					 group_type_desc_value="Isolation";
                 else if(group_type_desc.equals("U") && rep_id.equals("MRIPCSBD") || group_type_desc.equals("U") && rep_id.equals("MRIPCSOBD"))
					 group_type_desc_value="Unclassified";
				 else if(group_type_desc.equals("E"))
					 group_type_desc_value="Elective";
                 else if(group_type_desc.equals("M"))
					 group_type_desc_value="Emergency";
				 else if(group_type_desc.equals("U") && table_reference.equals("NS"))
					 group_type_desc_value="Follow-up Visit";
				  else if(group_type_desc.equals("F"))
					 group_type_desc_value="First Visit";
 
 				if (print_desc_yn.equals("Y"))
                  check_attribute="CHECKED";
				else
					check_attribute="";
			 }

		   	 if(rset!=null)    	rset.close();
			 if(stmt!=null)    	stmt.close();
			 if(psmt!=null)    	psmt.close();
		}
		 catch(Exception e){
			//out.println("Exception @ addModifyReportGroupSetup here"+e.toString());
			e.printStackTrace();
	     }
	     
		status=false;
		codeTextAttribute="READONLY";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		         String report_id="";
				 String report_desc ="";
				 //Below line modified for this CRF PRE-RH-0206 and PER-PD-209A
				 // Commented by Krishnan on 09/12/2009
				 sql ="Select report_id,REPORT_desc from sm_report where (module_id ='MR' or module_id ='IP' or module_id ='OP')And report_id IN('MROPRFLS','MROPCSAT','MRBRADEX','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','MRBLABWL', 'MRBLABRG','MROPCSMB','MRIPCSMB','MROPCSMS','IPBMCSBU','MRBSS203','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF','IPBMIPCS','MRBBAT3A','MRBBAT3B','MRBBAT3C','MRBRH212','MRDCCSMB','MRIPCSOBD','MRDCPROD','MRDCPROS','MRBRH203') order by report_desc";//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
				 //sql ="Select report_id,REPORT_desc from sm_report where (module_id ='MR' or module_id ='IP' or module_id ='OP')And report_id IN('MROPRFLS','MROPCSAT','MRBRADEX','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','MRBLABWL', 'MRBLABRG','MROPCSMB','MRIPCSMB','MROPCSMS','MRBSS203','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF') order by report_desc";
             	 stmt = conn.createStatement();
				 rset = stmt.executeQuery(sql);
				 if(rset!=null )
				 {
					while(rset.next())
					{
						report_desc = rset.getString("report_desc");
						report_id=rset.getString("report_id");
						if(report_desc.equals(report_desc_temp))
							out.print("<option value='"+report_id+"' selected>"+report_desc+"</option>");
						else
							out.print("<option value='"+report_id+"'>"+report_desc+"</option>");
					}
				
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
		  
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 if((reference!=null)&&(!reference.equals(""))&&(table_reference!=null)&&(!table_reference.equals("")))
					  out.print("<option value='"+table_reference+"' selected>"+reference+"</option>");
				
            _bw.write(_wl_block14Bytes, _wl_block14);

			 String mand_gif2_visible="hidden";
			if( !group_category.equals("") && group_category != null )
			 {
				  if(group_category.equals("S"))
				  {
					  s_select = "selected";
					  mand_gif2_visible = "visible";
				  }
				  else if(group_category.equals("M"))
				  {
					  m_select = "selected";
				  }
				  else if(group_category.equals("G"))
				  {
					  g_select = "selected";
				  }
			 }
		 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(m_select));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s_select));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(g_select));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 if((group_type_desc_value!=null)&&(!group_type_desc_value.equals(""))&&(group_type_desc!=null)&&(!group_type_desc.equals("")))
					  out.print("<option value='"+group_type_desc+"' selected>"+group_type_desc_value+"</option>");
				
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(name));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(!rep_id.equals("")){
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(name));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
//				out.println("Report_Id====>" +Report_Id);
      	       if((Report_Id.equals("IPBMCSBU") || Report_Id.equals("IPBMIPCS")) && (!Report_Id.equals("")))
	           {
				
	         
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(no_of_bes));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(no_of_bes_0));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_of_bes_1));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
 if(mode.equals("modify")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(subgroup_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(subgroup_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mand_gif2_visible));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
 if(mode.equals("modify")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(LEVEL3_CODE_DESC));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(LEVEL3_CODE_DESC));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(LEVEL3_CODE));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(mode.equals("modify")){
				 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(level3_range));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else {
				 
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(order_serial_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(print_desc_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);

			   }else if(Report_Id.equals("")){
				
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
 if(mode.equals("modify")){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(subgroup_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(subgroup_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(mand_gif2_visible));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
 if(mode.equals("modify")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(LEVEL3_CODE_DESC));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(LEVEL3_CODE_DESC));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(LEVEL3_CODE));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(mode.equals("modify")){
				 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(level3_range));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else {
				 
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order_serial_no));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(print_desc_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
if(status){
            _bw.write(_wl_block74Bytes, _wl_block74);
}else{
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(group_category));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(subgroup_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(table_reference));
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(order_serial_no));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(subgroup_code));
            _bw.write(_wl_block81Bytes, _wl_block81);

}catch(Exception e){
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Master.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.GroupCategory.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level1group.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level2group.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level3group.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupType.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupCode.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupName.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.noofbeds.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.noofficalbeds.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.noofopertnalbeds.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level1group.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level2group.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.printgroupname.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level1group.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.level2group.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.printgroupname.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }
}
