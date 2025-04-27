package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewqrymsgdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewQryMsgDtl.jsp", 1743587185269L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<HEAD>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'></link>\n\n<link rel=\'StyleSheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<style>\n\tdiv {float: left}  \n\t.testSty\n\t{ width:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style> \n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script> \n<script language=\"JavaScript\">\n//****************************************************************************************\nfunction callSort(obj)\n{\n   var previousMode= this.document.forms[0].sortMode1.value ;\n   if(previousMode==\"A\") this.document.forms[0].sortMode.value=\"D\";\n   if(previousMode==\"D\") this.document.forms[0].sortMode.value=\"A\";\t\n   this.document.forms[0].orderbycolumns.value=obj;\n      parent.messageFrame.location.href = \"../../eCommon/html/blank.html\";\n //  parent.f_query_detail.location.href=\"../../eCommon/html/blank.html\";\n   this.document.forms[0].action=\'../../eXH/jsp/ViewQryMsgDtl.jsp\';\n\n   this.document.forms[0].target=\'\';\n   this.document.forms[0].submit();\n}\n//****************************************************************************************\nfunction funShow(obj)\n{\n  //  this.document.forms[0].QUERYTEXT.value = obj.getAttribute(\'QUERYTEXT\');\n\tthis.document.forms[0].STATUSTEXT.value = obj.getAttribute(\'STATUSTEXT\');\n\tthis.document.forms[0].QUERYID.value= obj.getAttribute(\'QUERYID\');\n\tthis.document.forms[0].Application_id.value= obj.getAttribute(\'Application_id\');\n    this.document.forms[0].Facility_id.value= obj.getAttribute(\'Facility_id\');\n    this.document.forms[0].event_type.value= obj.getAttribute(\'eventtype\');\n\tthis.document.forms[0].Protocollink_id.value= obj.getAttribute(\'protocollink\');\n\tthis.document.forms[0].qapplname.value=obj.getAttribute(\'Appliname\');\n\tthis.document.forms[0].qfacility.value=obj.getAttribute(\'faciname\');\n\tthis.document.forms[0].msg_id.value=obj.getAttribute(\'msg_id\');\n \tvar appl_msg=escape(obj.getAttribute(\'Application_Msg\'));\n\tthis.document.forms[0].position.value=obj.getAttribute(\'posi\');\n\n    var err_msg=escape(obj.getAttribute(\'error_msg\'));\nvar commExpAut\t= document.getElementById(\"commExpAut\").value;\nvar viewAuth=this.document.forms[0].viewAuth.value;\n\n    /*this.document.forms[0].qostatus.value;\n    this.document.forms[0].qmsg_id1.value;\n    this.document.forms[0].qmsg_id2.value;\n    this.document.forms[0].sortMode1.value;*/\n\tvar reviewLabel\t\t\t= \"Message Review\";\n//\tvar reprocessLabel\t\t= \"Reprocess query\"; \n //   var responseLabel       = \"Response\";\n    //var auditLabel       = \"Audit Log\";\n    var messageViewerLabel       = \"Message Viewer\";\n\n    var linkset\t= new Array();\n\tvar disabled = \"\"; \n//\tvar responseMsgLink = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'responce();\'+\'\\\'\'+\'>\'+responseLabel+\'</a>\';\t\t\n\t//var reprocessLink   = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'reprocessQuery();\'+\'\\\'\'+\'>\'+reprocessLabel+\'</a>\';\t\t\n\t\t\n\t//var auditLink      = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'goToAuditLog(\"\'+this.document.forms[0].Application_id.value+\'\",\"\'+this.document.forms[0].qapplname.value+\'\",\"\'+this.document.forms[0].Facility_id.value+\'\",\"\'+this.document.forms[0].qfacility.value+\'\",\"=\'+this.document.forms[0].QUERYID.value+\'\",\"\'+this.document.forms[0].event_type.value+\'\",\"\'+this.document.forms[0].event_type.value+\'\");\'+\'\\\'\'+\'>\'+auditLabel+\'</a>\';\t\t\t\t\n   \n\nif(commExpAut==\"true\" && viewAuth==\"true\")\n\t{\n\tvar reviewLink      = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'review(\"\'+appl_msg+\'\",\"\'+err_msg+\'\");\'+\'\\\'\'+\'>\'+reviewLabel+\'</a>\';\t \n\tvar messageLink      = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'goToView();\'+\'\\\'\'+\'>\'+messageViewerLabel+\'</a>\';\t\n     linkset[0] = reviewLink;\n\t linkset[0] +=messageLink;\n\t dispMenu(linkset);\n\t}\n\t\n\telse if (commExpAut==\"true\" && viewAuth==\"false\")\n\t{\n\n     var messageLink  = \'<a href=\"#\" disabled=\"disable\">\'+messageViewerLabel+\'</a>\';\n\t var reviewLink      = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'review(\"\'+appl_msg+\'\",\"\'+err_msg+\'\");\'+\'\\\'\'+\'>\'+reviewLabel+\'</a>\';\n\t\t   linkset[0] = reviewLink;\n \n linkset[0] +=messageLink;\ndispMenu(linkset);\n\t}\n\telse if(commExpAut==\"false\" && viewAuth==\"true\")\n\t{\n\t\t\n\t\t\tvar messageLink      = \'<a href=\"#\" onClick=\'+\'\\\'\'+\'goToView();\'+\'\\\'\'+\'>\'+messageViewerLabel+\'</a>\';\n\t\t\tvar reviewLink  = \'<a href=\"#\" disabled=\"disable\">\'+reviewLabel+\'</a>\';\n       linkset[0]=messageLink;\n       linkset[0] += reviewLink;\n dispMenu(linkset);\n\t}\n     else\n\t{\n          alert(getMessage(\"XH0075\"));\n\t}\n     \n    /*var audtiAut\t= document.getElementById(\"audtiAut\").value;\n\tvar rebuildAut\t= document.getElementById(\"rebuildAut\").value;\n\tvar replayAut\t= document.getElementById(\"replayAut\").value;\n\tvar commExpAut\t= document.getElementById(\"commExpAut\").value;\n\n\n\n\tvar act = \"../../eXH/jsp/ViewQryMsgFooter.jsp\";\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'f_query_detail\';\n\tthis.document.forms[0].submit();*/\n}\nasync function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)\n{\n\n\tvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialogTop    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\nvar arguments  =\"\";\n\n\tvar arguments  =new Array();\n\targuments[0]=\'L\';\n\targuments[1]=applicationId;\n\targuments[2]=applicationName;\n    arguments[3]=facilityId;\n\targuments[4]=facilityName;\n\targuments[5]=msgId;\n    arguments[6]=eventType;\n\targuments[7]=eventName;\n await window.showModalDialog(\"../../eXH/jsp/ViewMessageAuditLogMain.jsp?applicationId=\"+applicationId+\"&applicationName=\"+applicationName+\"&facilityName=\"+facilityName+\"&facilityId=\"+facilityId+\"&eventName=\"+eventName+\"&protocollinkid=\"+this.document.forms[0].Protocollink_id.value+\"&msgId=\"+msgId,arguments,features);  \n}\nasync function goToView()\n{\n\tvar arguments  =new Array();\n\tvar dialogHeight = \"250\";\n\tvar dialogWidth  = \"250\";\n\tvar dialogTop    = \"230\";\n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n    /*arguments[0]=document.forms[0].application_id.value;\n\targuments[1]=document.forms[0].Facility_id.value;\n\targuments[2]=document.forms[0].eventype.value;\n\targuments[3]=document.forms[0].protocollinkid.value;\n    arguments[4]=document.forms[0].msg_id.value;*/\n   var url=\"../../eXH/jsp/ViewSegmentsMain.jsp?application_id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&eventype=\"+this.document.forms[0].event_type.value+\"&protocollinkid=\"+this.document.forms[0].Protocollink_id.value+\"&msg_id=\"+this.document.forms[0].msg_id.value+\"&qryid=\"+this.document.forms[0].QUERYID.value+\"&qapplname=\"+this.document.forms[0].qapplname.value+\"&faciname=\"+this.document.forms[0].qfacility.value+\"&purge_status=\"+this.document.forms[0].purge_status.value;\n  /*  var url=\"../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&eventype=\"+this.document.forms[0].event_type.value+\"&protocollinkid=\"+this.document.forms[0].Protocollink_id.value+\"&msg_id=\"+this.document.forms[0].QUERYID.value;*/\n\n\n\n\tawait window.showModalDialog(url,arguments,features);  \n// window.open(url,null,\"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no\");\n\n \n\n}\n\nfunction editQuery1()\n{\t\n\n\tdocument.forms[0].action=\"../../eXH/jsp/ViewQryMsgHeader.jsp\";\n\n\tdocument.forms[0].editQuery.value=\'Y\';\n\tparent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\tthis.document.forms[0].target = \"f_query_header\";\n\tdocument.forms[0].submit();\n} \n\n\nasync function review(appl_msg,err_msg) \n{\n  \n\n\n\nvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialogTop    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\nvar arguments  =\"\";\n\n/*window.showModalDialog(\"../../eXH/jsp/ViewQryMsgFooter.jsp?application_id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&msg_id=\"+this.document.forms[0].QUERYID.value+\"&Even_type=\"+this.document.forms[0].event_type.value+\"&protocollinkid=\"+this.document.forms[0].Protocollink_id.value+\"&STATUSTEXT=\"+escape(this.document.forms[0].STATUSTEXT.value)+\"&application_Msg=\"+escape(appl_msg)+\"&Error_msg=\"+escape(err_msg),arguments,features);  */\nawait window.showModalDialog(\"../../eXH/jsp/ViewQryMsgFooterMasterMain.jsp?application_Id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&Msg_Id=\"+this.document.forms[0].msg_id.value+\"&qryid=\"+this.document.forms[0].QUERYID.value+\"&Even_type=\"+this.document.forms[0].event_type.value+\"&protocol_link_id=\"+this.document.forms[0].Protocollink_id.value+\"&STATUSTEXT=\"+escape(this.document.forms[0].STATUSTEXT.value)+\"&application_Msg=\"+escape(appl_msg)+\"&Error_msg=\"+escape(err_msg)+\"&qapplname=\"+this.document.forms[0].qapplname.value+\"&faciname=\"+this.document.forms[0].qfacility.value+\"&qmsg_dt1=\"+this.document.forms[0].qmsg_dt1.value+\"&qmsg_dt2=\"+this.document.forms[0].qmsg_dt2.value+\"&msg_status=\"+document.forms[0].msg_status.value+\"&purge_status=\"+this.document.forms[0].purge_status.value+\"&posi=\"+this.document.forms[0].position.value+\"&Query_Option=\"+this.document.forms[0].qostatus.value,arguments,features); \n/*window.showModalDialog(\"../../eXH/jsp/ViewQryMsgFooter.jsp?application_Id=\"+this.document.forms[0].Application_id.value+\"&Facility_Id=\"+this.document.forms[0].Facility_id.value+\"&Msg_Id=\"+this.document.forms[0].QUERYID.value+\"&Even_type=\"+this.document.forms[0].event_type.value+\"&protocol_link_id=\"+this.document.forms[0].Protocollink_id.value+\"&STATUSTEXT=\"+escape(this.document.forms[0].STATUSTEXT.value)+\"&application_Msg=\"+escape(appl_msg)+\"&Error_msg=\"+escape(err_msg)+\"&qapplname=\"+this.document.forms[0].qapplname.value+\"&faciname=\"+this.document.forms[0].qfacility.value+\"&qmsg_dt1=\"+this.docoment.forms[0].qmsg_dt1.value+\"&qmsg_dt2=\"+this.docoment.forms[0].qmsg_dt2.value+\"&msg_status=\"+document.forms[0].msg_status.value,arguments,features);*/\n\t//var act = \"../../eXH/jsp/ViewQryMsgFooter.jsp\"; \n\t//this.document.forms[0].action = act;\n//\tthis.document.forms[0].target=\'f_query_detail\';  \n\t//this.document.forms[0].submit(); \n} \nasync function responce() \n{\n \nvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialog";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="Top    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\nvar arguments  =\"\";\n\n\n\n\nvar url=\"../../eXH/jsp/ViewQryMeesageMenu.jsp?application_id=\"+document.forms[0].Application_id.value+\"&Facility_id=\"+document.forms[0].Facility_id.value+\"&msgId=\"+this.document.forms[0].QUERYID.value+\"&mode=\"+this.document.forms[0].sortMode1.value+\"&eventype=\"+document.forms[0].event_type.value+\"&protocollinkid=\"+document.forms[0].Protocollink_id.value+\"&applicationName=\"+this.document.forms[0].qapplname.value+\"&facilityname=\"+this.document.forms[0].qfacility.value+\"&Query_Option=\"+this.document.forms[0].qostatus.value+\"&Query_Status=\"+this.document.forms[0].qstatus.value; \n\nawait window.showModalDialog(\"../../eXH/jsp/ViewQryMeesageMenu.jsp?application_id=\"+document.forms[0].Application_id.value+\"&Facility_id=\"+document.forms[0].Facility_id.value+\"&msgId=\"+this.document.forms[0].QUERYID.value+\"&mode=\"+this.document.forms[0].sortMode1.value+\"&eventype=\"+document.forms[0].event_type.value+\"&protocollinkid=\"+document.forms[0].Protocollink_id.value+\"&applicationName=\"+this.document.forms[0].qapplname.value+\"&facilityname=\"+this.document.forms[0].qfacility.value+\"&Query_Option=\"+this.document.forms[0].qostatus.value+\"&Query_Status=\"+this.document.forms[0].qstatus.value,arguments,features);  \n} \nfunction goSearch()\n{\n\tparent.messageFrame.location.href =\'../../eCommon/jsp/error.jsp\';\n\t\tparent.f_query_detail.location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n\nvar fields = new Array (  document.forms[0].qostatus);\nvar names = new Array (\"Query Option\");\n\n\t\tif(!checkFieldsofMst( fields, names, parent.messageFrame,\'1\'))\n\t{\n\n\n\t}\n\telse\n\t{\n\n\nif(validDateCheck()&&(Checkcurrdate(this.document.forms[0].qmsg_id1))&&(Checkcurrdate(this.document.forms[0].qmsg_id2)))\n\t    {\n\n\t\t\tthis.document.forms[0].action=\'../../eXH/jsp/ViewQryMsgDtl.jsp\';\n\t\t\tthis.document.forms[0].target=\'f_query_add_mod\';\n\t\t\tthis.document.forms[0].action_type.value=\'S\';\n\t\t\tthis.document.forms[0].submit();\n\t\t} \n\t}\n\nparent.commontoolbarFrame.document.location.reload();\n}\n\nfunction reprocessQuery()\n{\n\tif(document.forms[0].qostatus.value==\'P\' )\n\t{\n\t\talert(\"Records Pending For Batch Processing cannot be selected\");\n\t}\n\telse\n\t{\n\t\tvar act =\"../../eXH/jsp/Viewqryreprocess.jsp\";\n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\'messageFrame\';\n\t\tthis.document.forms[0].submit();\n\t}\n}\n\n//******************************************************************************************\nfunction funSubmit()\n{\n\tvar act = \'../../eXH/jsp/ViewQryMsgDtl.jsp\';\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].sortMode.value=\"A\";\n\tthis.document.forms[0].target=\'\';\n\tthis.document.forms[0].submit(); \n}\n//******************************************************************************************\nfunction funAction(typ)\n{\n\tdocument.forms[0].action_type.value = typ;\n//\tparent.f_query_detail.location.href=\"../../eCommon/html/blank.html\";\n\tfunSubmit();\n}\n\n//******************************************************************************************\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY  leftmargin=0 topmargin=0  onKeyDown = \'lockKey()\' >\n\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"view_query_msgdtl_form\" id=\"view_query_msgdtl_form\">\n<input  type=\"hidden\" name=\"qapplname\" id=\"qapplname\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' />\n<input  type=\"hidden\" name=\"qfacility\" id=\"qfacility\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' />\n<input  type=\"hidden\" name=\"qstatus\"  id=\"qstatus\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' />\n<input  type=\"hidden\" name=\"qmsg_id1\" id=\"qmsg_id1\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' />\n<input  type=\"hidden\" name=\"qmsg_id2\" id=\"qmsg_id2\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' />\n<input  type=\"hidden\" name=\"qry_id1\" id=\"qry_id1\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' />\n<input  type=\"hidden\" name=\"qry_id2\" id=\"qry_id2\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' />\n<input  type=\"hidden\" name=\"msg_status\" id=\"msg_status\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' /> \n<input  type=\"hidden\" name=\"qostatus\"  id=\"qostatus\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' />\n<input  type=\"hidden\" name=\"qmsg_dt1\" id=\"qmsg_dt1\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' />\n<input  type=\"hidden\" name=\"qmsg_dt2\" id=\"qmsg_dt2\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' />\n<input type=\"hidden\" name=\"orderbycolumns\" id=\"orderbycolumns\" value=\'\'/>\n<input type=\"hidden\" name=\"sortMode\" id=\"sortMode\" id=\"sortMode2\"/>\n<input type=\'hidden\' name=\'viewAuth\'  id=\"viewAuth\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\"hidden\" name=\"sortMode1\"  id=\"sortMode1\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\n<input type=\"hidden\" name=\"purge_status\"  id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/>\n<input type=\"hidden\" name=\"msg_id\"  id=\"msg_id\" value=\"\"/>\n<input type=\"hidden\" name=\"Application_id\"  id=\"Application_id\" />\n<input type=\"hidden\" name=\"Facility_id\"  id=\"Facility_id\" />\n<input type=\"hidden\" name=\"action_type\" id=\"action_type\"  value=\'S\'/>\n<input type=\"hidden\" name=\"position\" id=\"position\" />\n\n<input type=\"hidden\" name=\"event_type\"  id=\"event_type\" />\n<input type=\"hidden\" name=\"Protocollink_id\"  id=\"Protocollink_id\" />\n<input type=\"hidden\" name=\"QUERYID\"  id=\"QUERYID\" value=\"\"/>\n<input type=\"hidden\" name=\"QUERYDATE\"  id=\"QUERYDATE\" value=\"\"/> \n<input type=\"hidden\" name=\"QUERYTYPE\"  id=\"QUERYTYPE\" value=\"\"/>\n<input type=\"hidden\" name=\"QUERYPRIORITY\"  id=\"QUERYPRIORITY\" value=\"\"/>\n<input type=\"hidden\" name=\"PROCESSID\"  id=\"PROCESSID\" value=\"\"/>\n<input type=\"hidden\" name=\"QUERYSTATUS\"  id=\"QUERYSTATUS\" value=\"\"/>\n<input type=\"hidden\" name=\"LASTPROCSTARTTIME\"  id=\"LASTPROCSTARTTIME\" value=\"\"/>\n<input type=\"hidden\" name=\"LASTPROCENDTIME\"  id=\"LASTPROCENDTIME\" value=\"\"/>\n<input type=\"hidden\" name=\"ADDEDBYID\"  id=\"ADDEDBYID\" value=\"\"/>\n<input type=\"hidden\" name=\"MODIFIEDBYID\"  id=\"MODIFIEDBYID\" value=\"\"/>\n<input type=\"hidden\" name=\"QUERYTEXT\"  id=\"QUERYTEXT\" value=\"\"/> \n<input type=\"hidden\" name=\"STATUSTEXT\" id=\"STATUSTEXT\" value=\"\"/>\n<input type=\'hidden\' name=\'commExpAut\'  id=\"commExpAut\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'sub_module\' id=\"sub_module\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n<script>\nalert(getMessage(\'XH1021\',\'XH\'));history.go(-1);\n\n\nparent.frames[1].location.href=\'../../eXH/jsp/ViewQryMsgHeader.jsp?\';\n</script>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n\n\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n<tr>\n<td align=\"left\" class=\"CAGROUP\" >\n\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"editQuery1();\" TITLE=\"Edit query criteria\">\n\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</A>\n\t\t</td>\n\n\t<td colspan=\"6\" align=\"right\" class=\"CAGROUP\">\n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\"><u>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</u></A>\n\t\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' ><u>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</u></A>\n\t</td>\n</tr> \n</table>  \n\n<div id=\"left_child\">\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1>\t\n<tr>\n<td class=\'COLUMNHEADER\'> \n<a name=\'QUERY_STATUS\' id=\'QUERY_STATUS\'  href=\"javascript:callSort(\'QUERY_STATUS\');\" >\n\t\t<font color=white>&nbsp; $ &nbsp;</font></td>\n\t\t<td class=\'COLUMNHEADER\'><a name=\'MESSAGE_STATUS\' id=\'MESSAGE_STATUS\' href=\"javascript:callSort(\'MESSAGE_STATUS\');\" >\n\t\t<font color=white>&nbsp; # &nbsp;</font> \n\t\t</td> \n\t\t<td class=\'COLUMNHEADER\'>  \n\t\t<a name=\'APPLICATION_ID\' id=\'APPLICATION_ID\' href=\"javascript:callSort(\'APPLICATION_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>\n\t\t</td> \n\t\t<td class=\'COLUMNHEADER\'><a name=\'QUERY_ID\' id=\'QUERY_ID\' href=\"javascript:callSort(\'QUERY_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font>\n\t\t</td> \n\t    <td class=\'COLUMNHEADER\'><a name=\'Facility_id\' id=\'Facility_id\' href=\"javascript:callSort(\'Facility_id\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>\n\t\t</td> \n        <td class=\'COLUMNHEADER\'><a name=\'QUERY_DATE\' id=\'QUERY_DATE\'  href=\"javascript:callSort(\'QUERY_DATE\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font>\n\t\t</td>\n\t\t <td class=\'COLUMNHEADER\' >\n\t\t<a name=\'EVENT_TYPE\' id=\'EVENT_TYPE\'  href=\"javascript:callSort(\'EVENT_TYPE\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>\n\t\t</td>\n         <td class=\'COLUMNHEADER\'>\n\t\t<a name=\'QUERY_TYPE\' id=\'QUERY_TYPE\' href=\"javascript:callSort(\'QUERY_TYPE\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font>\n\t\t</td>\n        \n\t\t\n\t\n\t\t\n        </tr> \n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<tr id=\"testID\" >\n<td ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" align=\"center\">&nbsp;<img src=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' height=10></td>\n<td ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" align=\"center\" nowrap>&nbsp;<img src=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" align=\"left\" nowrap><font SIZE=1>&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n<td ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" align=\"left\" onMouseDown=\'funShow(this)\' QUERYID=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' \n\t\t\t\tQUERYDATE=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' \n\t\t\t\tQUERYTYPE=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' \n\t\t\t\tQUERYPRIORITY=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' \n\t\t\t\tPROCESSID=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' \n\t\t\t\tQUERYSTATUS=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' \n\t\t\t\tLASTPROCSTARTTIME=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' \n\t\t\t\tLASTPROCENDTIME=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' \n\t\t\t\tADDEDBYID =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'\n\t\t\t\tMODIFIEDBYID =\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'\n\t\t\t\tSTATUSTEXT =\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\n\t\t\t\tApplication_id=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' \n\t\t\t\tFacility_id=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  eventtype=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' protocollink=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' Appliname=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' faciname=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' Application_Msg=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' error_msg=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' msg_id=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'\n\t\t\t    posi=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'  \n\t\t\t\tnowrap><font size=1 color=\"blue\">\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" \n</font>\n</b>\n</td>\n<!-- Falicity  -->\n<td ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</font></td>\n\n<!-- Query Date  -->\n<td ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" align=\"left\" nowrap>&nbsp;<font SIZE=1>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font></td>\n<!-- Event Type  -->\n<td ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" nowrap align=\"center\" nowrap>&nbsp;<font SIZE=1>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font></td>\n<!-- Type  -->\n<td ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</font></td>\n\n\n<!-- Query Text  -->\n\n\n\n\n</tr>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n</table> \n</div> \n<div id=\"right_child\" class=\"testSty\" scrolling=\'no\'>\n<table id=\"table2\" cellspacing=0 cellpadding=3 border=1 scrolling=\'no\'>\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'QUERY_PRIORITY\' id=\'QUERY_PRIORITY\'  href=\"javascript:callSort(\'QUERY_PRIORITY\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'PROCESS_ID\' id=\'PROCESS_ID\'  href=\"javascript:callSort(\'PROCESS_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'LAST_PROC_START_TIME\' id=\'LAST_PROC_START_TIME\'  href=\"javascript:callSort(\'LAST_PROC_START_TIME\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'LAST_PROC_END_TIME\' id=\'LAST_PROC_END_TIME\'  href=\"javascript:callSort(\'LAST_PROC_END_TIME\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'ADDED_BY_ID\' id=\'ADDED_BY_ID\'  href=\"javascript:callSort(\'ADDED_BY_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'MODIFIED_BY_ID\' id=\'MODIFIED_BY_ID\'  href=\"javascript:callSort(\'MODIFIED_BY_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</font>\n\t\t</td>\n   <!--     <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'QUERY_Text\' id=\'QUERY_Text\'  href=\"javascript:callSort(\'QUERY_Text\');\" >\n\t\t<font color=white>Query Text</font>\n\t\t</td>--->\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'STATUS_Text\' id=\'STATUS_Text\'  href=\"javascript:callSort(\'STATUS_Text\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'ADDED_DATE\' id=\'ADDED_DATE\'  href=\"javascript:callSort(\'A.ADDED_DATE\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</font>\n\t\t</td>\n        <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'MODIFIED_DATE\' id=\'MODIFIED_DATE\'  href=\"javascript:callSort(\'A.MODIFIED_DATE\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'ADDED_AT_WS_NO\' id=\'ADDED_AT_WS_NO\'  href=\"javascript:callSort(\'ADDED_AT_WS_NO\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</font>\n\t\t</td>\n        <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'ADDED_FACILITY_ID\' id=\'ADDED_FACILITY_ID\'  href=\"javascript:callSort(\'ADDED_FACILITY_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</font>\n\t\t</td>\n         <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'MODIFIED_AT_WS_NO\' id=\'MODIFIED_AT_WS_NO\'  href=\"javascript:callSort(\'MODIFIED_AT_WS_NO\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</font>\n\t\t</td>\n        <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'MODIFIED_FACILITY_ID\' id=\'MODIFIED_FACILITY_ID\' href=\"javascript:callSort(\'MODIFIED_FACILITY_ID\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</font>\n\t\t</td>\n               <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a name=\'ACCESSION_NUMBER\' id=\'ACCESSION_NUMBER\'  href=\"javascript:callSort(\'ACCESSION_NUMBER\');\" >\n\t\t<font color=white>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</font>\n\t\t</td>\n \t</tr>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\n<tr>\n<!-- Priority  -->\n<td ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</font></td>\n\n<!-- Process ID  -->\n<td ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</font></td>\n<td ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" nowrap align=\"left\">&nbsp;<font SIZE=1>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</font></td>\n<!-- Query Status  -->\n<td ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</font></td>\n\n<!-- Process Start Time  -->\n<td ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</font></td>\n\n<!-- Process End Time  -->\n<td ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</font></td>\n\n<!-- Added Id  -->\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\n<!-- Added Date  -->\n<td ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</font></td>\n\n<!-- Modified ID  -->\n<td ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</font></td>\n\n<!-- Modified Date  -->\n<td ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</font></td>\n\n<!-- Added WS No  -->\n<td ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</font></td>\n\n<!-- Added Faiclity ID  -->\n<td ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</font></td>\n\n<!-- Modified WS No  -->\n<td ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</font></td>\n\n<!-- Modified Facility ID  -->\n<td ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</font></td>\n\n\n\n<!-- Accession Number  -->\n<td ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</font></td>\n\n</tr>\n\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\n<SCRIPT>\n\tparent.messageFrame.location.href = \"../../eXH/jsp/ViewQueryEvents.jsp?commType=QueryProcess\";\n</SCRIPT>\n\n<input type=hidden name=\'editQuery\'  id=\'editQuery\' value=\'N\'> \n</table>\n</div>\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Properties p = (Properties) session.getValue("jdbc"); 
String loggedUser = p.getProperty("login_user"); 	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

boolean boolToggle =  true;	
String strTDClass = "";

Connection conn = null;
try
{ 
	 HashMap resultsQry=null; 
  String tableNameSuffix="";  
  String whereClause="";
  String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
  String qapplname=request.getParameter("qapplname"); 
  System.out.println("qapplname==>"+ qapplname);
  String qfacility=request.getParameter("qfacility");
  String qstatus=request.getParameter("qstatus"); 
  String qry_id1=XHDBAdapter.checkNull(request.getParameter("qry_id1"));
  String qry_id2=XHDBAdapter.checkNull(request.getParameter("qry_id2"));
  String  eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
  String qmsg_id1=XHDBAdapter.checkNull(request.getParameter("qmsg_id1"));
  String qmsg_id2=XHDBAdapter.checkNull(request.getParameter("qmsg_id2"));
  String orderbycolumns=XHDBAdapter.checkNull(request.getParameter("orderbycolumns")); 
  String mode=XHDBAdapter.checkNull(request.getParameter("sortMode"));
  String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
  String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
  String qmsg_dt1=XHDBAdapter.checkNull(request.getParameter("qmsg_dt1"));
	String qmsg_dt2=XHDBAdapter.checkNull(request.getParameter("qmsg_dt2"));  
String sub_module=XHDBAdapter.checkNull(request.getParameter("sub_module"));
 
 // String qry_id1= XHDBAdapter.checkNull(request.getParameter("qry_id1"));

String qry_id = "VIEWADMINQUERYPROCESS";

String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	try
	{
		conn = ConnectionManager.getConnection(request);
		authRS = conn.createStatement().executeQuery(authSql);
		if(authRS.next())
		{		
			String strAutRebuild = authRS.getString("rebuild_yn");
			String strAutReplay = authRS.getString("replay_yn");
			String strAutCommExp = authRS.getString("comm_exception_yn");
			String strXlsAuth = authRS.getString("write_to_excel");
			String strAudit = authRS.getString("audit_yn");
			String strView = authRS.getString("view_yn");
			
			if(strAutRebuild != null && strAutRebuild.equalsIgnoreCase("Y")) authToRebuild = true;	
			if(strAutReplay != null && strAutReplay.equalsIgnoreCase("Y")) authToReplay = true;	
			if(strAutCommExp != null && strAutCommExp.equalsIgnoreCase("Y")) authToVwCommErr = true;
			if(strXlsAuth != null && strXlsAuth.equalsIgnoreCase("Y")) xlsAuth = true;
			if(strAudit != null && strAudit.equalsIgnoreCase("Y")) authToAudit = true;
			if(strView != null && strView.equalsIgnoreCase("Y")) viewAuth = true;
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		if(authRS != null) authRS.close();
	} 
  whereClause =" WHERE  B.LANGUAGE_ID='"+locale+"' and  a.FACILITY_ID = d.facility_id AND A.APPLICATION_ID=B.APPLICATION_ID AND  A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND  A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID)   AND TO_DATE(A.QUERY_DATE) BETWEEN TO_DATE(NVL('"+qmsg_dt1+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') AND TO_DATE(NVL('"+qmsg_dt2+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') and A.PROTOCOL_LINK_ID=XP.PROTOCOL_LINK_ID(+) and c.EVENT_TYPE=A.EVENT_TYPE  ";  


  if((qry_id1 != null) && (!(qry_id1.equals(""))))			
	{
		whereClause =whereClause +"AND A.QUERY_ID BETWEEN"+ 	
							"  nvl('"+qry_id1+"',A.QUERY_ID) AND nvl('"+qry_id2+"',A.QUERY_ID)";
	} 
  
		//msg_id2
	if((qry_id1 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND A.QUERY_ID <"+ 	
								"  nvl('"+qry_id2+"',A.QUERY_ID)";
		}
	} 

	if((qry_id2 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" A.QUERY_ID BETWEEN"+ 	
							"  nvl('"+qry_id2+"',A.QUERY_ID)";
		}
	
	} 




    if((protocol_link_id != null) && (!(protocol_link_id.equals(""))))			
	{
		whereClause = whereClause + " AND A.protocol_link_id = nvl('"+protocol_link_id+"',A.protocol_link_id) ";
	}
	if((protocol_link_id != null) && (!protocol_link_id.equals("")) )
	{
		whereClause = whereClause + " A.protocol_link_id = nvl('"+protocol_link_id+"',A.protocol_link_id) ";
	}
    if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		whereClause =whereClause +"AND A.message_id BETWEEN"+ 	
							"  nvl('"+qmsg_id1+"',A.message_id) AND nvl('"+qmsg_id2+"',A.message_id)";
	} 

	

	//msg_id2
	if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND A.message_id <"+ 	
								"  nvl('"+qmsg_id2+"',A.message_id)";
		}
	} 

	if((qmsg_id2 != null) && (!(qmsg_id2.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" A.message_id BETWEEN"+ 	
							"  nvl('"+qmsg_id2+"',A.message_id)";
		}
	
	} 

	//msg_dt

 if((qstatus != null) && (!(qstatus.equals(""))))			
	{
		if(qstatus.equals("C"))
		{
			whereClause =whereClause +" AND A.QUERY_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS)  =NVL('"+qstatus+"',DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS)) ";
		}
	} 

 if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals("P"))
		{
			whereClause =whereClause +" AND A.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND A.MESSAGE_STATUS = NVL('"+msg_status+"',A.MESSAGE_STATUS)";
		}
	} 

if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " AND A.EVENT_TYPE = NVL('"+eventtype+"',A.EVENT_TYPE)";
	} 

/*	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
		
	} */

	if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" A.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" A.MESSAGE_STATUS = NVL('"+msg_status+"',A.MESSAGE_STATUS)";
		}
	
	}
//       
String sort="";
String orderbycolumns1="";
if(orderbycolumns.equals("1"))
	{
	orderbycolumns1=" 1 ";
	}
	else
	{
		orderbycolumns1=orderbycolumns;
	}
	if(mode.equals("A"))
	{
		sort=" ASC ";
	}
	else
	{
		sort=" desc ";
	}
	whereClause=whereClause+" ORDER BY "+orderbycolumns1+sort; 



 if(purge_status != null && !purge_status.equals(""))
	{
	 if(purge_status.equals("purge"))
	 {
		tableNameSuffix =","+sub_module+"_PURGE_APPL_QRY_MSG_VW A";
	 }
	 else if(purge_status.equals("offline"))
	 {
		 	tableNameSuffix = ","+sub_module+"_OFFLINE_APPL_QRY_MSG_VW A";
	 }
	}
	else 
	{ 
		tableNameSuffix = ","+sub_module+"_APPLICATION_QRY_MSG_VW A";
	}
 
  /* request.setAttribute("tableName",tableNameSuffix); 
  String QueryOption=request.getParameter("qostatus");
  //System.out.println("QueryOption"+QueryOption);
  request.setAttribute(XHQueryRender.strQueryId,qry_id);
  request.setAttribute(XHQueryRender.whereClause,whereClause);
  request.setAttribute(XHQueryRender.col,"29"); 
  request.setAttribute(XHQueryRender.maxRec,"20");
  conn = ConnectionManager.getConnection(request);
  HashMap resultsQry = XHQueryRender.getResults(request,session,conn,QueryOption);

  ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
  ArrayList arrCol = null;
  boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
  boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
 String strPrevious =  "Previous";
  String strNext  = "Next"; */

  request.setAttribute("tableName",tableNameSuffix); 
//  System.out.println("QueryOption"+QueryOption);
  String QueryOption=request.getParameter("qostatus");
   if(QueryOption.equals("P"))
  {
		qry_id = "VIEWADMINQUERYPROCESS";
  }
  else if(QueryOption.equals("A"))
  {
		qry_id = "VIEWADMINQUERYINITIATE";
  }
  else
  {
       qry_id = "VIEWADMINQUERYPROCESS";  
  }
  request.setAttribute("qry_id",qry_id);  
  request.setAttribute("whereClause",whereClause);
 request.setAttribute("maxRec","20");  
  //request.setAttribute(XHViewQueryControllerElementBean.maxRec,1);   
  XHViewQueryControllerElementBean	xhBean =
  XHViewQueryControllerElementBean.getBean(XHViewQueryControllerElementBean.strBeanName,request,session);
  xhBean.action(request,conn);
  resultsQry = xhBean.getResultSet();  
  System.out.println("resultsQry "+resultsQry);

	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	  ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
  if (boolPrevious == true) 
  {
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
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
 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qapplname));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(qfacility));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qstatus));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qmsg_id1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qmsg_id2));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(qry_id1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(qry_id2));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(QueryOption));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(qmsg_dt1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qmsg_dt2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(viewAuth));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(authToVwCommErr));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block24Bytes, _wl_block24);

if(arrRow.size()==0)
{

            _bw.write(_wl_block25Bytes, _wl_block25);
 } else { 
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);
  if (boolToggle == true)
  {
	strTDClass = "class='QRYEVEN'";
	boolToggle =  false;
  }
  else
  {
	strTDClass = "class='QRYODD'";
	boolToggle =  true;
  }
	String sstatusColor="";
	String statusColor="";
	String status =((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);	 
	status=status.trim();
	if(status.equals("S"))  statusColor="../../eXH/images/green_square.jpg" ;
	else if(status.equals("R"))  statusColor="../../eXH/images/black_square.jpg" ;
	else if(status.equals("E"))  statusColor="../../eXH/images/red_square.jpg" ;
	else  statusColor="../../eXH/images/yello_square.jpg" ;

	String mstatus =((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(27);	
	mstatus=mstatus.trim();
	if(mstatus.equals("S"))  sstatusColor="../../eXH/images/green_square.jpg" ;
	else if(mstatus.equals("E"))  sstatusColor="../../eXH/images/red_square.jpg" ;
	else sstatusColor="../../eXH/images/yello_square.jpg"; 

//System.out.println(""+arrCol.get(29));


            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(statusColor));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sstatusColor));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(4)+""));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(arrCol.get(5)+""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(7)+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)arrCol.get(12))+""));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(arrCol.get(0)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(arrCol.get(2)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)arrCol.get(19)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf((String)arrCol.get(22)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((String)arrCol.get(23)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)arrCol.get(24)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)arrCol.get(25)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((String)arrCol.get(26)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)arrCol.get(28)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(arrCol.get(29)+""));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(2))));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(3))));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(19))));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(4))));
            _bw.write(_wl_block70Bytes, _wl_block70);

}

            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

for (int j=0; j<arrRow.size();j++)
{
  arrCol = (ArrayList)arrRow.get(j);

  if(j%2==0)
	{
		strTDClass = "class='QRYEVEN'";
	boolToggle =  false;
	
	}
	else
	{ 
		strTDClass = "class='QRYODD'";
	boolToggle =  true;

	}




            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(5))));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(6))));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(8))));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(9))));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(10))));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(11))));
            _bw.write(_wl_block93Bytes, _wl_block93);
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(12))));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(13))));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(14))));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(15))));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(16))));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(17))));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(18))));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(20))));
            _bw.write(_wl_block102Bytes, _wl_block102);

}
}

if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear();
}
catch(Exception e1)
{
	System.out.println("Error in calling getconnection method of dooperate method of ViewQryMsgDtl.jsp:"+e1.toString());
	e1.printStackTrace(System.err);
		
}
finally
{
	ConnectionManager.returnConnection(conn);
}

            _bw.write(_wl_block103Bytes, _wl_block103);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EditQuery.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.QueryID.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.QueryDate.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcessID.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ProcessStartTime.Label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ProcessEndTime.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedID.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedID.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.StatusText.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedDate.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedDate.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedWSNo.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedFacility.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedWSNo.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedFacilityID.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AccessionNumber.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
