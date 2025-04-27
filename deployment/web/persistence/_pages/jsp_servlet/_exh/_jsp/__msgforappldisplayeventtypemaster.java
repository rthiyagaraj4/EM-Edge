package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __msgforappldisplayeventtypemaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MsgForApplDisplayEventTypeMaster.jsp", 1743587063046L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\t\t\t\t    \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<HEAD>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script>\t\t\t\t\t\t \n<script language=\"javascript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\t\t\t\t\t   \n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\t\t\t    \t\t \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\t\t\t\t   \n<script language=\"javascript\" src=\"../../eXH/js/MessagesForApplication.js\" ></script>\t\t\t\t    \n<script language=\"JavaScript\">\t\t\n\nfunction checkDisabled(obj,segment_type,event_type_code,whichelement,stnd_code)\t  \t\t\t\t    \n{ \n\n\tvar flag=true;\n\tdocument.getElementById(\"_field\"+whichelement).value=\"Y\";\n\tvar checkinuse=document.getElementById(segment_type+event_type_code+\"_inuse1\");\t\t\t\t    \n\t/*if(checkinuse.disabled==true)\n\t{\n\t\tif(checkinuse.checked==true)\t\t\t\t\t    \n\t\t{\n             if(obj.value==\'\')\n\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t alert(getMessage(\'XH0072\',\'XH\'));\n\t\t\t\t\tobj.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{ \n\t\t\t\t\tcheckText(obj,segment_type,event_type_code,whichelement); \n\t\t\t}\n\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t}\n\telse\n\t{\n\t\tcheckText(obj,segment_type,event_type_code,whichelement);\n\t}*/\n\nif(checkinuse.disabled==true)\n{\n\tif(checkinuse.checked==true)\n\t{\n\t\tif(obj.value==\'\')\n\t\t{\n\t\t alert(getMessage(\'XH0072\',\'XH\'));\n\t\t searchProfile(segment_type,event_type_code,whichelement,stnd_code);\n\t\t}\n\t\telse\n\t\t{\n           searchProfile(segment_type,event_type_code,whichelement,stnd_code);\n\t\t}\n\t}\n}\nelse\n{\n\tif(checkinuse.checked==true)\n\t{\n\t\tif(obj.value==\'\')\n\t\t{\n\t\t\tvar i=window.confirm(\"Do you want to Enable the segment?\");\n\t\t\tif(i==true)\n\t\t\t{\n\t\t\tflag=true;\n\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t     \n\t\t\telse\n\t\t\t{\n\t\t\t\n\t\t\tflag = false;\n\t\t\t \n\n\t\t\tparent.frames[1].document.getElementById(segment_type+event_type_code+\"_inuse1\").checked=false;\t\t\t\t\t\n\t\t\tdocument.getElementById(segment_type+event_type_code+\"_inuse\").value=\"N\";\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tflag = true;\n\t\t}\n\n\t}\n\telse\n\t{\n\tflag=false;\n\t}\n   \n\tif(flag)\n\t{\n\t\tsearchProfile(segment_type,event_type_code,whichelement,stnd_code);\n\t}\t\n }\n}\n   function checkrRepeatedYN(obj,whichelement)\n   { \n  \t    document.getElementById(\"_field\"+whichelement).value=\"Y\";\n\t\t if(obj.checked==true)\n\t\t{\n\t\t  obj.value=\"Y\";\n\t\t}\n\t\telse\n\t   {\n\t\t obj.value=\"N\";\n\t   }\n   }\n\n\n\nfunction checkText(obj,segment_type,event_type_code,whichelement)\n{\n\t\n \n\t/*document.getElementById(\"_field\"+whichelement).value=\"Y\";\n\tif(obj.value==\'\')\n\t{\n\t\t\n \n\t\tif(document.getElementById(segment_type+event_type_code+\"_inuse1\").checked==true)\n\t\t{\n         searchProfile(segment_type,event_type_code,whichelement);\n\t\t}\n\t\telse\n\t\t{\n \n\t\t}\n\t}\n\telse\n\t{\n      //searchProfile(segment_type,event_type_code,whichelement);\n\t}*/\n}\n//function validatecheckbox \nfunction validatecheckbox(obj,segment_type,event_type,whichelement,stnd_code)\t\t\t\t\t\t \n{ \n\n\tdocument.getElementById(\"_field\"+whichelement).value=\"Y\";\n\tvar name=obj.name;\n\tvar countpage=parseInt(document.forms[0].count_page.value);\n\tif(name.indexOf(\"_optional_yn1\")!=-1)\n\t{\n\t\tif(obj.checked==true)\n\t\t{\n\t\t\tobj.value=\"Y\";\n\t\t\tdocument.getElementById(segment_type+event_type+\"_optional_yn\").value=\"Y\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobj.value=\"N\";\n\t\t\tdocument.getElementById(segment_type+event_type+\"_optional_yn\").value=\"N\";\n\t\t\n\t\t}\n\t}\nelse\n\t{\n       if(obj.checked==true)\n\t\t{\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\tobj.value=\"Y\";\n\t\t  document.getElementById(segment_type+event_type+\"_profile_desc\").disabled=false;\n\t\t\t\t\tdocument.getElementById(segment_type+event_type+\"ProfileSearch\").disabled=false;\n\t\t\tdocument.getElementById(segment_type+event_type+\"_inuse\").value=\"Y\";\n\t\t\tif((document.getElementById(segment_type+event_type+\"_profile_id\").value==\'\') || (document.getElementById(segment_type+event_type+\"_profile_desc\").value==\'\'))\n\t\t\t{\n\t\t\t\t//alert(getMessage(\'XH0072\'));\n                  searchProfile(segment_type,event_type,whichelement,stnd_code);\n\t\t\t\t//document.getElementById(segment_type+event_type+\"_profile_desc\").focus();\n\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n            else\n\t\t\t{\n\n\t\t\t}\n\t\t\t\n\t\t\t//document.getElementById(countpage+\"_inuse\"+whichelement).value=\"Y\";\n          //  document.getElementById(countpage+\"_inuse1\"+whichelement).value=\"Y\";\n\t\t} \n\t\telse\n\t\t{\n\t\t\tobj.value=\"N\";\n\t\t\tdocument.getElementById(segment_type+event_type+\"_inuse\").value=\"N\";\n\t\t\t\t\t\t//document.getElementById(segment_type+event_type+\"_inuse1\").checked=false;\n\t\t\t//document.getElementById(countpage+\"_inuse\"+whichelement).value=\"N\";\n           // document.getElementById(countpage+\"_inuse1\"+whichelement).value=\"N\";\n\t\t}\n\n\t}\n \n\t\n}\n\nfunction funcheckBox(obj,cou)\n{\n\n\tif(obj.checked==true)\n\t\t{\n\t\tobj.value=\"Y\";\n\t\t}\n\t\telse\n\t{\n         obj.value=\"N\";\n\t}\n\n\tthis.document.forms[0].target =\'\';\n//\talert(parent.frames[2].name);\n//\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t//this.document.forms[0].action_type.value = typ;\n//\talert(this.document.forms[0].action_type.value);\n\tthis.document.forms[0].action = \'../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?&count_page=\'+cou+\'&action_type=A\';\n\tthis.document.forms[0].submit();\n}\n\n\n\n\nfunction funAction(typ,obj)\n{\n\t\t\t\t\t\tvar flag=false;\n\t\t\t\t\t\tvar cou=parseInt(document.forms[0].count_page.value); \n\t\t\t\t\t\tfor(var i=0;i<(cou-1);i++)\t\t\t   \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t if(document.getElementById(\"in_use\"+i))\n\t\t\t\t\t\t  \t {\n\t\t\t\t\t\t\t\tif(document.getElementById(\"in_use\"+i).checked==true)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t if(document.getElementById(\"profile\"+i).value==\'\'||document.getElementById(\"profile\"+i).value==null)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tflag=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\t\t\t\t\t\t \n\t\t\t\t\t\t\t  }\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t}\t\t\t\t\t\t   \n\n\n\t\t\t\tif(flag==true)\t\t  \n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'XH0072\',\'XH\'));\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\t\t\t\t\t\t\t\t\t  \n\t\t\t\t{\n\t\t\t\t\tthis.document.forms[0].target = \t\"\";\n\t\t\t\t\t//\talert(parent.frames[2].name);\n\t\t\t\t\t//\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t\tthis.document.forms[0].action_type.value = typ;\n\t\t\t\t\t//\talert(this.document.forms[0].action_type.value);\n\t\t\t\t\tthis.document.forms[0].action = \'../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?&count_page=\'+cou+\'&action_type=\'+typ;\n\t\t\t\t\tthis.document.forms[0].submit();\n\t\t\t\t\twindow.parent.parent.parent.frames[2].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t}\n}\n\n\n\n\n\n\nfunction funShowSgmntViewer(obj)\t\t\t\t\t\t  \n{\n\n\tvar Segment_id = obj.getAttribute(\'segment_type\');\n\t//\t\talert(\"Segment_id : \"+Segment_id);\n\tvar Segment_name = obj.getAttribute(\'segment_name\');\n\t//\t\talert(\"Segment_name : \"+Segment_name);\n\tvar stand_code = obj.getAttribute(\'standard_code\');\n\t//\talert(\"stand_code : \"+stand_code);\n\tvar appl_id = obj.getAttribute(\'appl_id\');\n\t//\t\talert(\"appl_id : \"+appl_id);\n\tvar appl_name = obj.getAttribute(\'appl_name\');\n\t//\t\talert(\"appl_name : \"+appl_name);\n\tvar Profile_id = obj.getAttribute(\'profile_id\');\n\t//\t\talert(\"Profile_id : \"+Profile_id);\n\t var fun_idapp\t= obj.getAttribute(\'fun_idapp\');\n\t var  com_mode= obj.getAttribute(\'com_mode\');\n\t var event_type=obj.getAttribute(\'event_type\');\n\tvar messageLabel\t\t= getLabel(\"eXH.SegmentViewer.Label\",\"xh\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t var linkset\t= new Array();\t\t\t\t    \n\t var viewMsgLink = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'showSegmentMessageViewer(\"\'+Segment_id+\'\",\"\'+Segment_name+\'\",\"\'+stand_code+\'\",\"\'+appl_id+\'\",\"\'+appl_name+\'\",\"\'+Profile_id+\'\");\'+\'\\\'\'+\'>\'+messageLabel+\'</a>\';\t\t\t\n\t linkset[0] =viewMsgLink;\n\t if(fun_idapp==\'SWTCHINB\')\n\t{\t\t\t\t\t\t\t\t\t\t  \n/*\t\t\t\t if(com_mode==\'O\')\n\t\t\t{ */\n\t\t\t  var outboundatamapping\t= getLabel(\"eXH.InboundDataMapping.Label\",\"xh\");   \n\t\t\t  var outboundLabel=outboundatamapping.replace(\"Inbound Data\",\"Outbound\");\n\t\t\t  var viewoutLink=\'<a href=\"#\" onClick=\'+\'\\\'\'+\'showOutboundDataMapping(\"\'+Segment_id+\'\",\"\'+Segment_name+\'\",\"\'+stand_code+\'\",\"\'+appl_id+\'\",\"\'+appl_name+\'\",\"\'+Profile_id+\'\");\'+\'\\\'\'+\'>\'+outboundLabel+\'</a>\';\n\t\t\t\t linkset[0]+=viewoutLink;\n/*\t\t\t}\n\t\t\telse\n\t\t\t{ */\n\t\t\t\t var inboundmapping\t= getLabel(\"eXH.InboundDataMapping.Label\",\"xh\");   \n\t\t\t\tvar inboundLabel= inboundmapping.replace(\"Data\",\"\"); \n\t\t\t    var viewinLink=\'<a href=\"#\" onClick=\'+\'\\\'\'+\'showInboudDataMapping(\"\'+Segment_id+\'\",\"\'+Segment_name+\'\",\"\'+stand_code+\'\",\"\'+appl_id+\'\",\"\'+appl_name+\'\",\"\'+Profile_id+\'\",\"\'+event_type+\'\");\'+\'\\\'\'+\'>\'+inboundLabel+\'</a>\';\n\t\t\t\t linkset[0]+=viewinLink;\n//\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t  \n\t\t\n\t}\n\n\t dispMenu(linkset);\n\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t \n}\nasync function showInboudDataMapping(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id,event_type)\n{\t\t\t    \n  var url =\t\t\t\t    \'../../eXH/jsp/MsgforApplInterfaceLibraryMain.jsp?Segment_id=\'+Segment_id+\'&Segment_name=\'+Segment_name+\'&Profile_id=\'+Profile_id+\'&stand_code=\'+stand_code+\'&appl_name=\'+appl_name+\'&appl_id=\'+appl_id+\'&function_type=F&access=NYYYY\'+\'&flag=SWITCHINBOUNDCONFIG&home_required_yn=N&event_type=\'+event_type;    \n\tvar arguments  =new Array();\n\t \t\t\t\t\t\t\t \t\t \t\t\t\t\t\t\t\t\t\t  \t   \n\tvar dialogHeight = \"75vh\";\t\t\t\t\t \t\t\t \t\t\t\t \t  \t \t\t\t \t\t\t\t  \n\tvar dialogWidth  = \"85vw\";\t\t\t\t \t\t\t\t    \n\tvar dialogTop    = \"230\";\n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tawait window.showModalDialog(url,arguments,features); \n}\nasync function showOutboundDataMapping(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id)\n{\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t   \t\t\t    \n\t     \t\t\t \t\t\t\t\t\t \n\tvar url =\t\t\t\t\t\t\t\t\t\t\t   \'../../eXH/jsp/MsgforElementSegmentconfiguraionMain.jsp?Segment_id=\'+Segment_id+\'&Segment_name=\'+Segment_name+\'&Profile_id=\'+Profile_id+\'&stand_code=\'+stand_code+\'&appl_name=\'+appl_name+\'&appl_id=\'+appl_id+\'&function_type=F&access=NYYYN\'+\'&fun_id=SWITCHCONFIG&home_required_yn=N\';    \n\tvar arguments  =new Array();\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t  \n\tvar dialogHeight = \"75vh\";\t\t\t\t\t\t\t\t\t\t\t\t\t\t      \t\t\t \t\t\t\t  \n\tvar dialogWidth  = \"85vw\";\t\t\t\t\t\t\t\t    \t\t\t \n\tvar dialogTop    = \"230\";\t\t\t\t\t\t\t\t   \n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tawait window.showModalDialog(url,arguments,features); \n\t  \n}\nasync function showSegmentMessageViewer(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id)\n{\n\n\tvar url = \'../../eXH/jsp/SegmentTypeMessageViewerMain.jsp?Segment_id=\'+Segment_id+\'&Segment_name=\'+Segment_name+\'&Profile_id=\'+Profile_id+\'&stand_code=\'+stand_code+\'&appl_name=\'+appl_name;\n\tvar arguments  =new Array();\n\t\n\tvar dialogHeight = \"75vh\";\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\tvar dialogWidth  = \"85vw\";\n\tvar dialogTop    = \"230\";\t\t\t\t\t  \n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; ";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tawait window.showModalDialog(url,arguments,features); \n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<BODY  leftmargin=0 topmargin=0  bgcolor=\'#F0F0F2\'onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\"ApplicationSegmentListForEventTypeForm\" id=\"ApplicationSegmentListForEventTypeForm\" target=\'messageFrame\' method=\'post\' action=\'\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'XH1016\',\'XH\'));\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t\t<input type=hidden name=\'event_type\' id=\'event_type\' id=\'event_type\' value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\t\t\t\talert(getMessage(\'XH1021\',\'XH\'));\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t\t<tr>\n\t\t\t<td colspan=\"8\" align=\"right\" class=\"CAGROUP\" > \n\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\',document.forms[0].count_page)\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</A>\n\t\t\t<A class=\'label\'  onClick=\"funAction(\'N\',document.forms[0].count_page)\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</A>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'17%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t <td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>   \n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t  \n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr>\n            ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t  \n\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' ><font color=green>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t   <td class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'   segment_type=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" \n\t\t\tsegment_name=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  standard_code=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  \n\t\t\tappl_id= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  appl_name= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  profile_id= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"\t  fun_idapp=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' com_mode=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'   event_type=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'\n\t\t\tonMouseDown=\'funShowSgmntViewer(this)\' >\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t<a href=\"#\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</a></td>    \n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n            <td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' align=left ><font color=green>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></td>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' align=left >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\t\t\t \n\t\t\t<td class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' align=left >\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t<input type=hidden   name=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  > \t \n\t\t\t\t\t<input type=text   name=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'   value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'  onBlur=\"checkDisabled(this,\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\" style=\"width:150\"> <input class=\"button\" type=\"button\"  name=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' value=\'?\'    onClick=\"searchProfile(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" >\n            </td>\t    \n\t\t\t<td class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' align=center >\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t<input type=checkbox\tname=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" onClick=\"validatecheckbox(this,\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\');\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' disabled>\n\t\t\t<input type=hidden name=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' ></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' align=center >\n\t\t\t<input type=checkbox name=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  onClick=\"checkrRepeatedYN(this,\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\" id=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' align=center ><input type=checkbox name=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'  onClick=\"validatecheckbox(this,\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'><input type=hidden name=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'  value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' ><input type=hidden name=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'  id=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\n\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t</td>\t\n\n\n\n\t\t\n\t\t\t\n\n\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t\n\t\t\t<!-- name=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="_in_use_yn\' -->\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\n<tr>\n ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\n\t<td colspan=8 class=label><img src=\'../../eXH/images/green_square.jpg\' width=40 height=15 >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td> \n\n   \n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="  \n\n ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\n</table>\n\n<input type=hidden name=appl_id id=appl_id value=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =">\n<input type=hidden name=stnd_code id=stnd_code value=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">\n<input type=hidden name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n<input type=\'hidden\' name=\'count_page\' id=\'count_page\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\t\t\t\t\t\t\t   \n<input type=\'hidden\' name=\'fun_idapp\' id=\'fun_idapp\' id=\'fun_idapp\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n  \n</form>\n\n</body>\n</html>\t\t\t\t\t\t\t\t\t\t\t\t\t \t  \n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
// String locale = ((String)session.getAttribute("LOCALE"));
 																	  

            _bw.write(_wl_block2Bytes, _wl_block2);
 															  
String sStyle =							 
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

int start=0;
int r=0;
ArrayList arrRow = null;
ArrayList arrCol = null;			 
String strPrevious = "";  
String strNext  = "";				  
HashMap resultsQry=null; 
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
Statement stmt1=null;		    
ResultSet rs1=null;
String selectall="N";
String classValue="";
String segment_type="";
String segment_name="";
String optional_yn="";
String in_use_yn="";
String status="";
String com_mode="";
int cou=0;
System.out.println(" MsgForApplDisplayEventTypeMaster cou : "+cou);						  
String event_type=request.getParameter("event_type");
String appl_id=request.getParameter("appl_id");
System.out.println("MsgForApplDisplayEventTypeMaster.jsp appl_id : "+appl_id);
String appl_name = request.getParameter("appl_name");
String standard_code = XHDBAdapter.checkNull(request.getParameter("standard_code"));   
String fun_idapp=XHDBAdapter.checkNull(request.getParameter("fun_idapp"));			   
System.out.println("fun_idapp MsgForApplDisplayEventTypeMaster.jsp :"+fun_idapp);
//	System.out.println("standard_code : "+standard_code);									   
//String action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));
//	System.out.println("action_type : "+action_type);
String profile_id = "";
String repeatable_yn="";
String profile_desc="";
String stnd_desc="";				    
// added on Jan 11 								  
String event_type_code = "";											   
String qrystnd_code = "";																				  
int singlecount=0;
boolean flag_rec_enbld = false;

            _bw.write(_wl_block10Bytes, _wl_block10);

	request.setAttribute("application_Id",appl_id);
	request.setAttribute("message_type",event_type);
	request.setAttribute("standard_code",standard_code);
	 try
	 {																    
		 if(con==null)
		  con = ConnectionManager.getConnection(request);
	 }
	 catch(Exception e)
	 {
		 System.out.println(" MsgForApplDisplayEventTypeMaster :"+e);
	 }

try{
		boolean boolToggle =  true;	
//		String strTDClass = "";
	//	String qry_id = "MSGFORAPPLEVNTWSGMNT";
	//	con=ConnectionManager.getConnection();
		//String sql1="";
		String sql="";
		
        sql=" SELECT SEGMENT_TYPE FROM  XH_EVENT_TYPE_SEGMENT  WHERE EVENT_TYPE=NVL('"+event_type+"',EVENT_TYPE) "; 
		System.out.println("sql : "+sql);	 
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
        rs.last(); 
		if(rs.getRow()==0) 								    
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else {

			rs.close();
			stmt.close(); 
		 // ORDER BY 11 "; B.SEGMENT_TYPE NOT IN 	 			  
			request.setAttribute("application_Id",appl_id);
			request.setAttribute("message_type",event_type);
            request.setAttribute("standard_code",standard_code);
        //  request.setAttribute(XHMsgForApplicationElementControllerBean.element_desc,element_desc); 
	        //con = ConnectionManager.getConnection(request);
			XHMsgForEventwiseElementControllerBean	xhBean = XHMsgForEventwiseElementControllerBean.getBean(XHMsgForEventwiseElementControllerBean.strBeanName,request,session);
			xhBean.action(request,con);				  
			resultsQry = xhBean.getResultSet();
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 		   
		    start=Integer.parseInt(XHDBAdapter.checkNullZero((String)resultsQry.get("start")));   
              
  //          System.out.println("start 223 :"+start+"end :"+end);							  
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{ 
				strPrevious =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			}
			else								   
			{
				strPrevious = " ";					 						    
			}
			if (boolNext== true)											    
			{ 
				strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels"); 
			}
			else
			{
				strNext  = " ";							 
			}

		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block13Bytes, _wl_block13);

//			System.out.println("arrRow.size() : "+arrRow.size());
		if(arrRow.size()==0)
		{
            _bw.write(_wl_block14Bytes, _wl_block14);
}
		else											    
		{
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
  
//            System.out.println("arrRow.size() :"+arrRow.size());
	    selectall=XHDBAdapter.checkNull((String)resultsQry.get("selectall")); 
//			  System.out.println("selectall :"+selectall);
		if(selectall.equals("Y"))
		{
			if(optional_yn.equals("N"))										   
			{

			}
			else														    
			{
				in_use_yn="Y";
			}
		}
		for (int j=0; j<arrRow.size();j++)
		{
			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				classValue = "QRYEVEN" ;
				boolToggle =  false;
			}
			else
			{
				classValue = "QRYODD" ;
				boolToggle =  true;
			}
			
		    cou=Integer.parseInt((String)arrCol.get(13));
			singlecount=Integer.parseInt((String)arrCol.get(14));
			segment_type=(String)arrCol.get(0);
			segment_name=(String)arrCol.get(1);
			optional_yn=(String)arrCol.get(2); 
			in_use_yn=(String)arrCol.get(3);
			profile_id = XHDBAdapter.checkNull((String)arrCol.get(5));
			profile_desc=XHDBAdapter.checkNull((String)arrCol.get(6));
			stnd_desc=XHDBAdapter.checkNull((String)arrCol.get(7));
			event_type_code=XHDBAdapter.checkNull((String)arrCol.get(8));
			qrystnd_code =XHDBAdapter.checkNull((String)arrCol.get(9));	    
			status = XHDBAdapter.checkNull((String)arrCol.get(11));
			com_mode = XHDBAdapter.checkNull((String)arrCol.get(15));
			repeatable_yn = XHDBAdapter.checkNull((String)arrCol.get(16));
//			System.out.println(" MsgForApplDisplayEventTypeMaster.jsp status :"+status);
			
            _bw.write(_wl_block25Bytes, _wl_block25);
									   
				if(segment_type.equals("ALL"))
			{
			}
			else
			{

			
            _bw.write(_wl_block26Bytes, _wl_block26);
 if (status.equals("G")){ 
				flag_rec_enbld = true; 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }else {
				
				if(profile_id.equals("")||	profile_id==null)
				{ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
}				   
				  else
				{
				 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(segment_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(qrystnd_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(appl_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(appl_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(profile_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fun_idapp));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com_mode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block44Bytes, _wl_block44);

				}												 
			}							    			 					    
			 if (status.equals("G")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(segment_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
} else {
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(segment_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(qrystnd_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(segment_type+event_type_code+"_profile_id"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_profile_id"));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(XHDBAdapter.checkNull(profile_id)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf("profile"+singlecount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(segment_type+event_type_code+"_profile_desc"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_profile_desc"));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(XHDBAdapter.checkNull(profile_desc)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(singlecount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qrystnd_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(segment_type+event_type_code+"ProfileSearch"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"ProfileSearch"));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(singlecount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qrystnd_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(segment_type+event_type_code+"_optional_yn1"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_optional_yn1"));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(optional_yn.equals("Y")?"checked":""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(singlecount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(optional_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(segment_type+event_type_code+"_optional_yn"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_optional_yn"));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(optional_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(segment_type+event_type_code+"_repeat"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_repeat"));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(repeatable_yn.equals("Y")?"checked":""));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(repeatable_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(singlecount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf("repeat"+singlecount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(segment_type+event_type_code+"_inuse1"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_inuse1"));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(optional_yn.equals("N")?"disabled  ":""));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(in_use_yn.equals("Y")?"checked":""));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(in_use_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(event_type_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(singlecount));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(qrystnd_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf("in_use"+singlecount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(segment_type+event_type_code+"_inuse"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_inuse"));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(in_use_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(segment_type+event_type_code+"_field"));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(segment_type+event_type_code+"_field"));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf("_field"+singlecount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((String)arrCol.get(12)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            _bw.write(_wl_block82Bytes, _wl_block82);
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block84Bytes, _wl_block84);
												  							 
			}													    
//				i++;
r++;
cou++;
		} // end of for
		} // end of else 
	} // end of else - If records found in XH_EVENT_TYPE_SEGMENT
}catch(Exception exp)
    {
  	    System.out.println("MsgForApplDisplayEventTypeMaster.jsp : "+exp.toString());
	   exp.printStackTrace(System.err);
    }
finally
{       
		try
		{
			if(stmt1!=null)stmt1.close();
			if(rs1!=null)rs1.close();														  
			ConnectionManager.returnConnection(con);	 
		}
		catch(Exception exp)
		{       
		   exp.printStackTrace(System.err);
		}		
}
														    

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(r));
            _bw.write(_wl_block86Bytes, _wl_block86);
 if (flag_rec_enbld == true)
 { 
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

 } else
 {	
            _bw.write(_wl_block89Bytes, _wl_block89);

 }		
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appl_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(standard_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(status));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cou));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(fun_idapp));
            _bw.write(_wl_block95Bytes, _wl_block95);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SegmentType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SegmentType.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Standardcode.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Profile.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Optional.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Repeatable.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Recently.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
