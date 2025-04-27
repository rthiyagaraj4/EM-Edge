package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eCA.ChartRecording.*;
import javax.servlet.http.*;
import eCA.RecClinicalNotes.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __createnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/CreateNotes.jsp", 1709118025677L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n  \n<link rel=\"stylesheet\" href=\"../css/iPadCreateNotes.css\" />\n<script>\nfunction Loading()\n{\n\twindow.parent.hideLoading();\n\t var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n\t $(\"#notesContentFrame\").css(\'height\', dvheight);\n\t /*\n\t var RTEditor0 = document.getElementById(\"notesContentFrame\");\n\t \n\t var html = \"\";\n\t html +=\"<style type=\'text/css\'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>\";\n\t html +=\"<body onKeyDown=\'\' style=\\\"font:10pt arial\\\">\";\n\t    html +=\"</body>\";\n\t    RTEditor0.document.open();\n\t    RTEditor0.document.write(html);\n\t    RTEditor0.document.close();\n\t    RTEditor0.document.designMode = \"ON\";\n\t    RTEditor0.document.body.contentEditable = \"True\";\n\t    */\n\t var errorMsg = document.getElementById(\"errorMsg\").value;\n\t if(errorMsg != null && errorMsg != \"\" && errorMsg != \"null\")\n\t\t {\n\t\t   alert(errorMsg);\n\t\t }\n\tif(document.getElementById(\"hdnPostBack\").value == \"true\")\n\t\t{\n\t\t  document.getElementById(\"cmbFilterBy\").value = document.getElementById(\"hdnFilterBy\").value;\n\t\t//  document.getElementById(\"cmbNoteType\").value = document.getElementById(\"note_type\").value;\n\t\t}\n\t    var notetype = document.getElementById(\"note_type\").value;\n\t    var filterBy = document.getElementById(\"hdnFilterBy\").value;\n\t    if(filterBy != null && filterBy != \"\")\n\t    {\n\t    \tdocument.getElementById(\"cmbFilterBy\").value = filterBy;\n\t    }\n\t    if(notetype != null && notetype != \"\")\n\t    {\n\t    \t\n\t    \t\n\t    document.getElementById(\"cmbNoteType\").value = notetype\n        }\n\t    \n}\nfunction setNotesContent(txtnotesContent,dvNotesContent,oppMode)\n{\n\tvar txtContent = \"\";\n\tvar dvContent = \"\";\n\tvar notesContent = \"\";\n\t//alert(oppMode);\n\t//alert(txtnotesContent);\n\t//alert(dvNotesContent);\n\tdocument.getElementById(\"operation_mode\").value = oppMode;\n\t//var operationmode = document.getElementById(\"operation_mode\").value;\n\t\n\tif(txtnotesContent != null && txtnotesContent != \"\")\n\t{\n\t\ttxtContent = \"<ADDRESS>\" +txtnotesContent + \"</ADDRESS>\";\n\t}\n\tif(dvNotesContent != null )\n\t{\n\t\tdvContent = dvNotesContent;\n\t}\n\tif(oppMode == \"Record\")\n\t{\n\t\tnotesContent = txtContent;\n\t\t//notesContent = dvContent + txtContent;\n\t}\n\telse\n\t{\n\t\tnotesContent = dvContent + txtContent;\n\t}\n\t//notesContent = \"<ADDRESS>GOOD</ADDRESS>\";\n\tdocument.getElementById(\"note_content\").value = notesContent;\n\t\t\n    \n}\nfunction changeOrientation(orient)\n{\n\t//\talert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t     //document.getElementById(\"dvmain\").style.height = \"auto\";\n\t    // $(\"#dvmain\").css(\'min-height\',\'381px\');\n\t\t $(\"#dvNotesMenu\").css(\'min-height\',\'381px\');\n\t\t    \n\t\t    var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n\t\t\t//document.getElementById(\"notesContentFrame\").style.height = $(\"#dvNotesMenu\").height() ;\n\t\t\t//alert(document.getElementById(\"notesContentFrame\").style.height);\n\t\t\t//alert($(\"#dvNotesMenu\").height());\n\t\t    $(\"#notesContentFrame\").css(\'height\', dvheight);\n\t\t    document.getElementById(\"notesContentFrame\").contentWindow.changeOrientation(orient,dvheight);\n\t    \n\t   }\n     else\n\t   {\n\t   //  document.getElementById(\"dvmain\").style.height = \"auto\";\n\t    // $(\"#dvmain\").css(\'min-height\',\'765px\');\n    \t $(\"#dvNotesMenu\").css(\'min-height\',\'677px\');\n    \t var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n    \t $(\"#notesContentFrame\").css(\'height\', dvheight);\n    \t document.getElementById(\"notesContentFrame\").contentWindow.changeOrientation(orient,dvheight);\n\t   }\n \n}\nfunction LoadSection()\n{\n\tdocument.getElementById(\"hdnFilterBy\").value = document.getElementById(\"cmbFilterBy\").value;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"note_type\").value = document.getElementById(\"cmbNoteType\").value;\n\tdocument.getElementById(\"frmCreateNotes\").submit();\n}\nfunction LoadNoteType1(objCombo)\n{\n\t//alert(objCombo.value);\n\tvar xmlHttp = getHttpObject();\n\txmlHttp.onreadystatechange=function(){\n\t\t//alert(xmlHttp.readyState+\' \'+xmlHttp.status);\n\t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\tvar resText = xmlHttp.responseText;\n\t\t\t\n\t\t\tdocument.getElementById(\"cmbNoteType\").innerHTML= \'<option value = \"\">Select</option>\' + resText;\n\t\t}\n\t}\n\n\txmlHttp.open(\"POST\", \"NoteType.jsp\", true);\n\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t//var sendString = \"selectedperiod=\"+selectedPeriod+\"&patientclass=\"+selectedPatientClass+\"&encounter_id=\"+selectedEncounterId+\"&patientid=\"+patientId+\"&facility_id=\"+facilityId;\n\t//sendString += \"&episode_type=B\"+\"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=&normalcy=&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&view_by=E&graphorder=desc&show_mode=C&relationship_id=\";\n\tvar sendString = \"FilterBy=\" + objCombo.value;\n\txmlHttp.send(sendString);\n\t\n}\nfunction LoadNoteType(objCombo)\n{\n\tdocument.getElementById(\"hdnFilterBy\").value = objCombo.value;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"note_type\").value = \"\";\n\tdocument.getElementById(\"frmCreateNotes\").submit();\n}\nfunction getHttpObject(){\n\tvar xmlHttp;\n\tif (window.XMLHttpRequest) {\n\t\txmlHttp = new XMLHttpRequest();\n\t} else if (window.ActiveXObject) {\n\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t}\n\treturn xmlHttp;\n}\nfunction showRecentNotes(obj)\n{\n\tobj.style.border = \"3px solid #48d1d8\";\n\t window.parent.showRecNotes();\n}\nfunction showNotes(noteHeading,SecHdgCode,childSecHdgCode,accessnum)\n{\n\t//alert(SecHdgCode);\n\t//alert(childSecHdgCode);\n\tdocument.getElementById(\"SecHdgCode\").value = SecHdgCode;\n\tdocument.getElementById(\"childSecHdgCode\").value = childSecHdgCode;\n\tvar height = $(\"#dvNotesMenu\").height() + \"px\";\n\tvar url = \"?notesHeading=\" +noteHeading +\"&height=\" +height +\"&secCode=\" + SecHdgCode+\"&secChildCode=\" +childSecHdgCode+\"&accessnum=\" +accessnum ;\n\tdocument.getElementById(\"notesContentFrame\").src = \"NotesContent.jsp\" + url;\n}\nfunction loadWidgets()\n{\n\twindow.parent.showLoadingMsg();\n}\nfunction RecordNotes()\n{\n\t/*\n\tvar accessnum = document.getElementById(\"accession_num\").value;\n\tif(accessnum != null && accessnum != \"\")\n\t{\n\t\tdocument.getElementById(\"operation_mode\").value = \"UpdateRecord\";\t\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\"operation_mode\").value = \"Record\";\t\n\t}\n\t*/\n\tif(document.getElementById(\"notesContentFrame\") != null && document.getElementById(\"notesContentFrame\").contentWindow != null)\n\t{\n\t\t\n\t\tdocument.getElementById(\"notesContentFrame\").contentWindow.getNotescontent(); //to get and set the notes content\n\t\tdocument.getElementById(\"hdnRecord\").value = \"true\";\n\t\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\t\tdocument.getElementById(\"frmCreateNotes\").submit();\n\t}\n}\n</script>\n</head>\n\n<body onload = \"Loading()\">\n\t<section data-role = \"page\" style = \"padding:0px\">\n\t\t <form name = \"frmCreateNotes\" id = \"frmCreateNotes\" method = \"post\">\n\t\t\t <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\" >\n\t\t\t\t  <div data-role = \"none\" class = \"dvViewNotes\">\n\t\t\t\t     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t       <tr style=\"width:100%;height:100%\">\n\t\t\t\t         <td style = \"width : 95%\" align = \"left\" valign = \"center\">\n\t\t\t\t            <span class = \"spanCreateNotes\">Create Notes</span>\n\t\t\t\t         </td> \n\t\t\t\t          <td style=\"width:5%\" onclick = \"loadWidgets()\" align = \"center\" valign = \"middle\">\n\t\t\t\t           <img src = \"../images/Close.png\"></img>\n\t\t\t\t         </td>\n\t\t\t\t       </tr>\n\t\t\t\t     </table>\n\t\t\t\t  </div>\n\t\t\t\t  <div id = \"dvCriteria\" class = \"dvCriteria\">\n\t\t\t\t      <table style=\"height:68px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t\t\t\t\t\t      <td align = \"left\" style=\"width:34%\"><span class = \"spanFilterBy\">Filter By</span></td>\n\t\t\t\t\t\t\t\t      <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t\t\t\t             <span class = \"spanFilterBy\">Note Type</span>\n\t\t\t\t\t\t\t\t      </td>\n\t\t\t\t\t\t\t\t       <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t\t     </tr>\n\t\t\t\t\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t\t\t\t\t\t      <td align = \"left\" style=\"width:34%\">\n\t\t\t\t\t\t\t\t\t        <select  class=\"cmbFilterBy\" data-role=\"none\" id=\"cmbFilterBy\" name = \"cmbFilterBy\" onchange = \"LoadNoteType(this)\"> \n\t\t\t\t\t\t\t\t\t          <option value = \"P\">Practitioner</option> \n\t\t\t\t\t\t\t\t\t          <option value = \"S\">Speciality</option> \n\t\t\t\t\t\t\t\t\t          <option value = \"R\">Responsibility</option> \n\t\t\t\t\t\t\t\t            </select> \n\t\t\t\t\t\t\t\t      </td>\n\t\t\t\t\t\t\t      <td align = \"left\" style=\"width:33%\" valign = \"middle\">\n\t\t\t\t\t\t\t              <select  class=\"cmbFilterBy\" data-role=\"none\" id=\"cmbNoteType\" name = \"cmbNoteType\" onchange = \"LoadSection()\" > \n\t\t\t\t\t\t\t              <option value = \"\">Select</option>\n\t\t\t\t\t\t\t              ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t\t\t\t            \t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</option>\n\t\t\t\t\t\t\t\t\t            \t\t\t\t  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t           </select> \n\t\t\t\t\t\t\t      </td>\n\t\t\t\t\t\t\t        <td align = \"center\" style=\"width:33%\">\n\t\t\t\t\t\t\t         <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Recent Clinical Notes\' class=\"btnType1\"  data-role = \"none\"  onclick = \"showRecentNotes(this)\"/>\n\t\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t\t     </tr>\n\t\t\t\t\t\t\t     <tr style=\"height:3px;width:100%\">\n\t\t\t\t\t\t\t       <td>&nbsp;</td>\n\t\t\t\t\t\t\t     </tr>\n\t\t\t\t\t\t   </table>\n\t\t\t\t  </div>\n\t\t\t\t  <div id = \"dvNotesMenu\" class = \"dvNotesMenu\">\n\t\t\t\t      <table style = \"width:100%;height:auto\" border = \"0\" cellspacing  = \"0\" cellpadding = \"0\">\n\t\t\t\t        <tr class = \"trNotesViewMenu\">\n\t\t\t\t          <td class = \"tdNotesViewMenu\">\n\t\t\t\t               <span class = \"spanCreateNotesView\">Notes View</span>\n\t\t\t\t          </td>\n\t\t\t\t        </tr>\n\t\t\t\t         ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t            \t\t\t\t <tr class = \"trNotesMenu\">\n\t\t\t\t\t\t\t\t\t\t          <td class = \"tdNotesMenu\" onclick = \"showNotes(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\">\n\t\t\t\t\t\t\t\t\t\t               <span class = \"spCreateMenu\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n\t\t\t\t\t\t\t\t\t\t          </td>\n\t\t\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t            \t\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t            \t\t\t    \t<tr class = \"trNotesMenu\">\n\t\t\t\t\t\t\t\t\t\t          <td class = \"tdNotesMenu\" >\n\t\t\t\t\t\t\t\t\t\t               <span class = \"spDisabledMenu\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t\t\t\t\t\t\t          </td>\n\t\t\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t            \t\t\t    \t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t      </table>\n\t\t\t\t  </div> \n\t\t\t\t  <div id = \"dvNotesContent\" class = \"dvNotesContent\"  >\n\t\t\t\t        <iframe frameborder=\"0\" id=\"notesContentFrame\"  \n\t\t\t\t\t\t\t            width=\"100%\"    scrolling =\"yes\" style = \"display:block\"></iframe>          \n\t\t\t\t  </div>\n\t\t\t\t  <div id = \"dvSave\" class = \"dvSave\">\n\t\t\t\t\t     <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\" class = \"tbSave\">\n\t\t\t\t\t\t     <tr style = \"width:100%;height:100%\" >\n\t\t\t\t\t\t       <td>    \n\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t       <td style = \"width : 80%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t        \t<input type =\"button\" name=\'save_btn\' id=\'save_btn\' value=\'Save\' class=\"btnType1\"  data-role = \"none\" onclick = \"RecordNotes()\"/>\n\t\t\t\t\t\t       </td>\n\t\t\t\t\t\t     </tr>\n\t\t\t\t\t     </table>\n\t\t\t\t   </div>\n\t\t\t</div>\n\t\t\t<input type = \"hidden\" name = \"hdnPostBack\" id = \"hdnPostBack\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"hdnPatientClass\" id = \"hdnPatientClass\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnFilterBy\" id = \"hdnFilterBy\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnRecord\" id = \"hdnRecord\" />\n\t\t\t<input type = \"hidden\" name = \"operation_mode\" id = \"operation_mode\" value = \"\"/>\n\t\t\t<input type = \"hidden\" name = \"patient_class\" id = \"patient_class\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"note_type\" id = \"note_type\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"service_name\" id = \"service_name\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"service_code\" id = \"service_code\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"visit_adm_date\" id = \"visit_adm_date\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"encounter_id\" id = \"encounter_id\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"note_content\" id = \"note_content\"/>\n\t\t\t<input type = \"hidden\" name = \"accession_num\" id = \"accession_num\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />\n\t\t\t<input type = \"hidden\" name = \"SecHdgCode\" id = \"SecHdgCode\"/>\n\t\t\t<input type = \"hidden\" name = \"childSecHdgCode\" id = \"childSecHdgCode\"/>\n\t\t\t<input type = \"hidden\" name = \"patient_id\" id = \"patient_id\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"event_date_time\" id = \"event_date_time\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"errorMsg\" id = \"errorMsg\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t\n\t\t\n\t\t</form> \n\t</section>  \n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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


private String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}

private String checkForNull(String inputString, String defaultValue)
{
	return (inputString==null)	?	defaultValue	:	inputString;
}
private List<String> recordRecClinicalNotes(HttpServletRequest request) 
{
	HttpSession				session	=	null;
	java.util.Properties	p		=	null;

	Connection				con			=	null;

	webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = null;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	List<String> oTransResultList = new ArrayList<String>();

	HashMap htRecClinicalNotes					=	new java.util.HashMap();
	String		clinician_id					=	"",		clinician_name				=	"";
	String		facility_id						=	"",		accession_num				=	"";
	String		patient_id						=	"",		episode_type				=	"";
	String		encounter_id					=	"",		patient_class				=	"";
	String		event_type_caption				=	"",		note_type					=	"";
	String		service_code					=	"",		event_class					=	"";
	String		note_type_security_level		=	"",		event_date_caption			=	"";
	String		event_date_time					=	"",		event_perf_by_caption		=	"";
	String		performed_by_id					=	"",		event_title_caption			=	"";
	String		event_title_desc				=	"",		note_content				=	"";
	String		event_auth_by_caption			=	"",		authorized_by_id			=	"";
	String		authorized_date_time			=	"",		event_status_caption		=	"";
	String		event_status					=	"",		login_user_id				=	"";
	String		encntr_date						=	"",		amendment_type				=	"";
	String		forwarded_clinician_id			=	"",		resp_name					=	"";
	String		serv_facl_spec_yn				=	"",		privilege_type				=	"";
	String		note_type_desc					=	"",		operation_mode				=	"";
	String		login_at_ws_no					=	"",		action_comment				=	"";
	String		function_id						=	"",		resp_id						=	"";
	String		window_close					=	"";
	String		contr_mod_accession_num			=	"";
	String		doc_linked_note_yn				=	"";
	String		strInsertFlag					=	"N";
	String		locale							=	"";
	//shaiju
	String		forward_mode				= "";
	String		module_id					= "";
	String		appl_task_id				= "";
	String		selection_type				= "";
	HashMap     multiHash					= null;
	String     called_from					= "";
	String 		record_mode					= "";	//[IN033677]
	String		srl_no						= "";   //[IN033677]

	String print_notes_yn = "";
	String error_msg = "";

	int count = 0;
	try
    {
		session							=	request.getSession(false);
		

		clinicalNotesSectionBean=(webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

		p							=	(Properties)	session.getValue("jdbc") ;
		locale						=	(String)		p.getProperty("LOCALE");

		login_user_id				=	(String)		session.getValue("login_user");
		facility_id					=	(String)		session.getValue("facility_id");
		resp_name					=	(String)		session.getValue("resp_name");
		clinician_id				=	(String)		session.getValue("ca_practitioner_id");
		clinician_name				=	(String)		session.getValue("practitioner_name");
		resp_id						=	(String)		session.getValue("responsibility_id");

		login_at_ws_no				=	checkForNull( p.getProperty("client_ip_address"));
		operation_mode				=	checkForNull( request.getParameter("operation_mode")		);
		accession_num				=	checkForNull( request.getParameter("accession_num")			);
		amendment_type				=	checkForNull( request.getParameter("amendment_type")		);

		forwarded_clinician_id		=	checkForNull( request.getParameter("forwarded_clinician_id"));
		action_comment				=	checkForNull( request.getParameter("action_comment")		);
		action_comment				=   java.net.URLDecoder.decode(action_comment);
		//performed_by_id				=	checkForNull( request.getParameter("performed_by_id")		);
		performed_by_id =  clinician_id;

		privilege_type				=	checkForNull( request.getParameter("privilege_type")		);

		function_id					=	checkForNull( request.getParameter("function_id")			);

		String field_ref			=	checkForNull( request.getParameter("Field_Ref")	);
		window_close				=	checkForNull( request.getParameter("window_close")			);
		contr_mod_accession_num		=	checkForNull( request.getParameter("contr_mod_accession_num")	);
		doc_linked_note_yn			=	checkForNull( request.getParameter("doc_linked_note_yn"),"N");

		//Shaiju
		forward_mode			=	checkForNull( request.getParameter("forward_mode"));
		//Shaiju

		module_id				=	checkForNull( request.getParameter("module_id"));

		appl_task_id			=	checkForNull( request.getParameter("appl_task_id"));

		called_from			=	checkForNull( request.getParameter("called_from"));

		record_mode					=	checkForNull( request.getParameter("record_mode")		);   //[IN033677]
		srl_no						=	checkForNull( request.getParameter("srl_no")			);   //[IN033677]
				
		if( operation_mode.equals("Record") || operation_mode.equals("Sign") || operation_mode.equals("ModifySection") || operation_mode.equals("UpdateRecord") ||  operation_mode.equals("ModifyAddendum") || operation_mode.equals("SignOnModify") )
		{
			serv_facl_spec_yn			=	checkForNull( request.getParameter("serv_facl_spec_yn")			);
			note_type_desc				=	checkForNull( request.getParameter("note_type_desc")			);
			patient_id					=	checkForNull( request.getParameter("patient_id")				);
			episode_type				=	checkForNull( request.getParameter("episode_type"),"I"				);
			encounter_id				=	checkForNull( request.getParameter("encounter_id")				);
			patient_class				=	checkForNull( request.getParameter("patient_class")				);
			event_type_caption			=	checkForNull( request.getParameter("event_type_caption"),"Note Type"		);
			note_type					=	checkForNull( request.getParameter("note_type")					);
			service_code				=	checkForNull( request.getParameter("service_code")				);
			event_class					=	checkForNull( request.getParameter("event_class"),"CLI$"				);
			note_type_security_level	=	checkForNull( request.getParameter("note_type_security_level")	);
			event_date_caption			=	checkForNull( request.getParameter("event_date_caption"	),"Date/Time"		);
			event_date_time				=	checkForNull( request.getParameter("event_date_time")			);
			event_perf_by_caption		=	checkForNull( request.getParameter("event_perf_by_caption")		);
			event_title_caption			=	checkForNull( request.getParameter("event_title_caption")		);
			event_title_desc			=	checkForNull( request.getParameter("event_title_desc")			);
			note_content				=	checkForNull( request.getParameter("note_content")				);
			event_auth_by_caption		=	checkForNull( request.getParameter("event_auth_by_caption")		);
			authorized_by_id			=	checkForNull( request.getParameter("authorized_by_id")			);

			authorized_date_time		=	checkForNull( request.getParameter("authorized_date_time")		);
			event_status_caption		=	checkForNull( request.getParameter("event_status_caption")		);
			event_status				=	checkForNull( request.getParameter("event_status"),"1"			);

			if (event_status.equals(""))
				event_status="j";

			event_date_time				=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
			encntr_date					=	checkForNull( request.getParameter("visit_adm_date")			);

			appl_task_id			=	checkForNull( request.getParameter("appl_task_id"),"CLINICAL_NOTES");
			selection_type			=	checkForNull( request.getParameter("selection_type"));

			//shaiju st
			manageEmailBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
             
			//list = manageEmailBean.returnSortList();
			multiHash = manageEmailBean.returnHashMap();
		}
			htRecClinicalNotes.put ( "operation_mode",			operation_mode				);
			htRecClinicalNotes.put ( "clinician_id",			clinician_id				);
			htRecClinicalNotes.put ( "clinician_name",			clinician_name				);
			htRecClinicalNotes.put ( "resp_name",				resp_name					);
			htRecClinicalNotes.put ( "responsibility_id",		resp_id						);
			htRecClinicalNotes.put ( "facility_id",				facility_id					);
			htRecClinicalNotes.put ( "login_user_id",			login_user_id				);
			htRecClinicalNotes.put ( "login_at_ws_no",			login_at_ws_no				);
			htRecClinicalNotes.put ( "accession_num",			accession_num				);
			htRecClinicalNotes.put ( "amendment_type",			amendment_type				);
			htRecClinicalNotes.put ( "performed_by_id",			performed_by_id				);
			htRecClinicalNotes.put ( "forwarded_clinician_id",	forwarded_clinician_id		);
			htRecClinicalNotes.put ( "action_comment",			action_comment				);
			htRecClinicalNotes.put ( "privilege_type",			privilege_type				);
			htRecClinicalNotes.put ( "serv_facl_spec_yn",		serv_facl_spec_yn			);
			htRecClinicalNotes.put ( "note_type_desc",			note_type_desc				);
			htRecClinicalNotes.put ( "patient_id",				patient_id					);
			htRecClinicalNotes.put ( "episode_type",			episode_type				);
			htRecClinicalNotes.put ( "encounter_id",			encounter_id				);
			htRecClinicalNotes.put ( "patient_class",			patient_class				);
			htRecClinicalNotes.put ( "event_type_caption",		event_type_caption			);
			htRecClinicalNotes.put ( "note_type",				note_type					);
			htRecClinicalNotes.put ( "service_code",			service_code				);
			htRecClinicalNotes.put ( "event_class",				event_class					);
			htRecClinicalNotes.put ( "security_level",			note_type_security_level	);
			htRecClinicalNotes.put ( "event_date_caption",		event_date_caption			);
			htRecClinicalNotes.put ( "event_date_time",			event_date_time				);
			htRecClinicalNotes.put ( "event_perf_by_caption",	event_perf_by_caption		);
			htRecClinicalNotes.put ( "event_title_caption",		event_title_caption			);
			htRecClinicalNotes.put ( "event_title_desc",		event_title_desc			);
			htRecClinicalNotes.put ( "note_content",			note_content				);
			htRecClinicalNotes.put ( "event_auth_by_caption",	event_auth_by_caption		);
			htRecClinicalNotes.put ( "authorized_by_id",		authorized_by_id			);
			htRecClinicalNotes.put ( "authorized_date_time",	authorized_date_time		);
			htRecClinicalNotes.put ( "event_status_caption",	event_status_caption		);
			htRecClinicalNotes.put ( "event_status",			event_status				);
			htRecClinicalNotes.put ( "encntr_date",				encntr_date					);
			htRecClinicalNotes.put ( "contr_mod_accession_num",	contr_mod_accession_num		);
			htRecClinicalNotes.put ( "doc_linked_note_yn",		doc_linked_note_yn			);
			htRecClinicalNotes.put ( "LOCALE",					locale						);
			htRecClinicalNotes.put ( "forward_mode",			forward_mode				);
			htRecClinicalNotes.put ( "appl_task_id",			appl_task_id				);
			htRecClinicalNotes.put ( "selection_type",			selection_type				);
			htRecClinicalNotes.put ( "multiHash",				multiHash						);
			htRecClinicalNotes.put ( "function_id",				function_id						);
			htRecClinicalNotes.put ( "record_mode",				record_mode					);  
			htRecClinicalNotes.put ( "srl_no",					srl_no					);  
					
			java.util.HashMap results = null;
			boolean inserted = false;
		//	String error_msg = "";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecClinicalNotes", RecClinicalNotesHome.class, local_ejbs);

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			String contextUrl = HttpUtils.getRequestURL(request).toString();
			//contextUrl = contextUrl.substring(0,contextUrl.indexOf("servlet/"));
			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
			converter.setXSLFileContextReference(contextUrl);
			
			if(operation_mode.equals("Sign") || operation_mode.equals("SignOnModify") )
			{

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = htRecClinicalNotes;
				argArray[2] = clinicalNotesSectionBean;
				argArray[3] = converter;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = htRecClinicalNotes.getClass();
				paramArray[2] = clinicalNotesSectionBean.getClass();
				paramArray[3] = converter.getClass();

				results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
			}
			else if( operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") )
			{
				Object argArray[] = new Object[5];
				argArray[0] = p;
				argArray[1] = htRecClinicalNotes;
				argArray[2] = clinicalNotesSectionBean;
				argArray[3] = converter;
				argArray[4] = strInsertFlag;

				Class [] paramArray = new Class[5];
				paramArray[0] = p.getClass();
				paramArray[1] = htRecClinicalNotes.getClass();
				paramArray[2] = clinicalNotesSectionBean.getClass();
				paramArray[3] = converter.getClass();
				paramArray[4] = strInsertFlag.getClass();
				results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
			}
					
			error_msg		= "";
			inserted		=	( ((Boolean) results.get( "status" )).booleanValue() );
			accession_num	=	(String)	results.get("accession_num");
		//	accessNum = accession_num;
			error_msg		=	(String)	results.get("error") ;
			print_notes_yn		=	(String)	results.get("print_notes_yn") ;

			results.clear();		
		
			oTransResultList.add(accession_num);
			//oTransResultList.add(error_msg);

    }
	catch(Exception e)
	{
	
		e.printStackTrace(System.err);
		//out.println("Exception in recClinical Notes" +e.toString());
		error_msg = e.toString();
		
	}
	finally
	{
		oTransResultList.add(error_msg);
	}
	return oTransResultList;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
request.setCharacterEncoding("UTF-8");
webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
String locale = "en";
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "false";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";

List<String> oTransResultList = null;
CreateNotesRequest oCreateNotesReq = new CreateNotesRequest();
oCreateNotesReq.setRequest(request);

String normalInd = "";
String strPatientClass = "";
String strFilterBy = "P";
String strNoteType = "";
String accessNum = "";
String service_name	=	"";
String service_code	=	"";
String discharge_date_time		=	"";
String attending_practitioner	=	"";
String visit_adm_date	=	"";
String strCurrentDatetime = DateUtils.getCurrentDate("DMYHM", locale);
String notes_section_content = "";
String strErrorMsg = "";

int nTanlstCnt =0;
if(session.getValue("facility_id") != null )
{
	oCreateNotesReq.setFacilityId((String)session.getValue("facility_id"));
	facility_id = oCreateNotesReq.getFacilityId();
}
if(session.getValue("ca_practitioner_id") != null)
{
	oCreateNotesReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("practitioner_type") != null )
{
	oCreateNotesReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("PatientID") != null)
{
	oCreateNotesReq.setPatientId((String)session.getValue("PatientID"));
	strPatientId = oCreateNotesReq.getPatientId();
}
if(session.getValue("EpisodeId") != null )
{
	oCreateNotesReq.setEncounterId((String)session.getValue("EpisodeId"));
	strEncounterId = oCreateNotesReq.getEncounterId();
}

if(session.getValue("responsibility_id") != null)
{
	oCreateNotesReq.setRespId((String)session.getValue("responsibility_id"));
}
oCreateNotesReq.setApplTaskID("CLINICAL_NOTES");
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
	
}
if(request.getParameter("fromfunc") != null)
{
	if(request.getParameter("accessionNum") != null)
	{
		accessNum = request.getParameter("accessionNum");
	}
	
	if(request.getParameter("note_type") != null)
	{
		strNoteType = request.getParameter("note_type");
	}

}
if(request.getParameter("hdnPostBack") != null)
{
	strPostBack = request.getParameter("hdnPostBack");
}
if(request.getParameter("hdnFilterBy") != null)
{
strFilterBy = request.getParameter("hdnFilterBy");
}
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("patient_class");
	
	strNoteType = request.getParameter("note_type");
	if(request.getParameter("hdnRecord") != null && request.getParameter("hdnRecord").equals("true") )
	{
		String strNotescontent = request.getParameter("note_content");
		String SecHdgCode = request.getParameter("SecHdgCode");
		String childSecHdgCode = request.getParameter("childSecHdgCode");
		String strKey = "";
		strKey = strPatientId + "~" + strEncounterId;
		sectionBean.removePatientSection(strKey);	
		sectionBean.startPatientSection(strKey);	
		//putObjectInBean("sectionBean",sectionBean,session);
		//sectionBean.setSectionValues(SecHdgCode,childSecHdgCode,"F",doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,result_link_type, image_edited_yn,edited_yn, section_content, image_content,output_form_exists_yn);
		sectionBean.setSectionValues(SecHdgCode,childSecHdgCode,"F","","N","N","Y","","N","N", "", "","");
		if(strNotescontent != null && !strNotescontent.equals("") && SecHdgCode != null && !SecHdgCode.equals("") && childSecHdgCode != null && !childSecHdgCode.equals(""))
		{
			boolean bSeccontent = false;
			bSeccontent = sectionBean.setSectionContent ( SecHdgCode,childSecHdgCode,strNotescontent);
			putObjectInBean("sectionBean",sectionBean,session);
			//webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = null;
			//clinicalNotesSectionBean=(webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
			/*
			if(clinicalNotesSectionBean != null)
			{
				notes_section_content	=	(java.lang.String) clinicalNotesSectionBean.getSectionContent ( SecHdgCode,childSecHdgCode );
				String test = "";
			}
		   */
		}
		//PrintWriter out1;
		//out1 = response.getWriter();
		//oTransResultList = recordRecClinicalNotes(request,out1);
		oTransResultList = recordRecClinicalNotes(request);
		if(oTransResultList != null)
		{
			nTanlstCnt = oTransResultList.size();
			int nCnt = 0;
			for(nCnt =0 ; nCnt < nTanlstCnt ; nCnt ++)
			{
				if(nCnt == 0)
				{
					accessNum =  oTransResultList.get(nCnt);
					//break;
				}
				if(nCnt == 1)
				{
					strErrorMsg = oTransResultList.get(nCnt);
				}
			}
		}
		
		
	}
}
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);

Connection con = null;
PreparedStatement		ptPatLine			= null;
ResultSet				stPatLine			= null;

String strDetailsQry	= "select  to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,1)  attending_practitioner,service_code from    pr_encounter a where   facility_id = ? and     encounter_id = ?";
try
{
	con				=	ConnectionManager.getConnection(request);
	if(con != null)
	{
		ptPatLine	=	con.prepareStatement(strDetailsQry);
	   if( ptPatLine != null)
	   {
			ptPatLine.setString	(	1,	locale	);
			ptPatLine.setString	(	2,	locale	);
			ptPatLine.setString	(	3,	locale	);
			ptPatLine.setString	(	4,	facility_id	);
			ptPatLine.setString	(	5,	strEncounterId);
		
			stPatLine		=	ptPatLine.executeQuery();
		
			if(stPatLine != null && stPatLine.next())
			{
				service_name				=	stPatLine.getString("service_name");
				service_code				=	stPatLine.getString("service_code");
				discharge_date_time				=	stPatLine.getString("DISCHARGE_DATE_TIME");
				attending_practitioner		=	stPatLine.getString("attending_practitioner");
				//speciality_name		=	stPatLine.getString("speciality_name");
				visit_adm_date		=	stPatLine.getString("visit_adm_date");
			}
	   }
	   if (stPatLine !=null) stPatLine.close();
		if (ptPatLine!=null) ptPatLine.close();
	    if (con !=null) ConnectionManager.returnConnection(con,request);
	}
}
catch(Exception e){
	e.printStackTrace();
	
}
finally{
    if (stPatLine !=null) stPatLine.close();
	if (ptPatLine!=null) ptPatLine.close();
    if (con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
							              NoteTypeResponse oNoteTypeResponse = null;
							              List<NoteTypeHO> oNoteTypeList = null;
							              NoteTypeHO oNoteTypeHO = null;
							              NotesDetail bean = new NotesDetail();
							              int nLoopCount = 0;
							              int nListSize = 0;
							              try {
								            	  oNoteTypeResponse = bean.getNoteType(oCreateNotesReq);
									              if(oNoteTypeResponse != null && oNoteTypeResponse.getLstNoteType() != null)
									              {
									            	  oNoteTypeList = oNoteTypeResponse.getLstNoteType();
									            	  if(oNoteTypeList != null)
									            	  {
									            		  nListSize = oNoteTypeList.size();
									            	  }
									            	  if(nListSize > 0)
									            	  {
									            		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
									            		  {
									            			  oNoteTypeHO = oNoteTypeList.get(nLoopCount);
									            			  if(oNoteTypeHO != null)
									            			  {
									            				  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oNoteTypeHO.getNoteType()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oNoteTypeHO.getNoteTypeDesc()));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
									            			  }
									            		  }
									            	  }
									              }
							               }
							              catch ( Exception e ){
												out.println("Exception " + e);
												//out.println(sqlStr.toString());
												e.printStackTrace();
											}
							              
            _bw.write(_wl_block5Bytes, _wl_block5);

				         if((strPostBack != null && strPostBack.equals("true") && strNoteType != null && !strNoteType.equals("")) || (strNoteType != null && !strNoteType.equals("") && accessNum != null && !accessNum.equals("")))
				         {
				        	 NoteSectionResponse oNoteSectionResponse = null;
				             List<NoteSectionHO> oNoteSecList = null;
				             NoteSectionHO oNoteSecHO = null;
				             NotesDetail oNoteDetail = new NotesDetail();
				            
				             int nLoopCount1 = 0;
				             int nListSize1 = 0;
				             try {
				            	 oNoteSectionResponse = oNoteDetail.getNoteSection(oCreateNotesReq);
				            	 if(oNoteSectionResponse != null && oNoteSectionResponse.getLstNoteSection() != null)
				            	 {
				            		 oNoteSecList = oNoteSectionResponse.getLstNoteSection();
				            	 }
				            	 if( oNoteSecList != null)
				            	 {
				            		 nListSize1 = oNoteSecList.size();
				            	 }
				            	 if(nListSize1 > 0)
				            	 {
				            		 for(nLoopCount1 = 0 ; nLoopCount1 < nListSize1;nLoopCount1++)
				           		 	 {
				            			 oNoteSecHO =  oNoteSecList.get(nLoopCount1);
				            			 if(oNoteSecHO != null)
				            			 {
				            				 String secDesc = oNoteSecHO.getSecHdgDesc();
				            				 if(!oNoteSecHO.getChildSecHdgDesc().equals(""))
				            				 {
				            					 secDesc = oNoteSecHO.getChildSecHdgDesc();
				            				 }
				            			    if(oNoteSecHO.getSecContentType() != null && oNoteSecHO.getSecContentType().equals("F"))	
				            			    {
				            				 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(secDesc ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oNoteSecHO.getSecHdgCode()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oNoteSecHO.getChildSecHdgCode()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(accessNum));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(secDesc ));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
				            			    }
				            			    else
				            			    {
				            			    	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(secDesc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
				            			    }
				            			 }
				           		  	 }
				           		  }
				             }
				             catch ( Exception e ){
									out.println("Exception " + e);
									e.printStackTrace();
								}
				         }
				         
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strPostBack ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strFilterBy));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strNoteType));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(service_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(accessNum));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strCurrentDatetime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strErrorMsg));
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
