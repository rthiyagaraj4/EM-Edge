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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __viewnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/ViewNotes.jsp", 1709118033318L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadViewNotes.css\" />\n\n<script>\nfunction Loading()\n{\n\twindow.parent.hideLoading();\n\t document.getElementById(\"cmbCriteria\").value =  document.getElementById(\'hdnPeriod\').value;\n\t if(document.getElementById(\"hdnEncounterChk\").value == \"true\")\n     {\n\t\t document.getElementById(\"chkEncounter\").checked = true;\n\t\t// alert(\"hello\");\n\t }\n\t else\n\t{\n\t\t document.getElementById(\"chkEncounter\").checked = false;\n\t}\n\t \n\t  var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n\t\t\n\t    $(\"#notesContentFrame\").css(\'height\', dvheight);\n\t// document.getElementById(\"notesContentFrame\").style.height = document.getElementById(\"dvNotesMenu\").style.height ;\n}\nfunction changeOrientation(orient)\n{\n\t\t//alert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t//\tdocument.getElementById(\"dvNotesMenu\").style.min-height = \"492px\";\n\t    $(\"#dvNotesMenu\").css(\'min-height\',\'421px\');\n\t    \n\t    var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n\t\t//document.getElementById(\"notesContentFrame\").style.height = $(\"#dvNotesMenu\").height() ;\n\t\t//alert(document.getElementById(\"notesContentFrame\").style.height);\n\t\t//alert($(\"#dvNotesMenu\").height());\n\t    $(\"#notesContentFrame\").css(\'height\', dvheight);\n\t   }\n     else\n\t   {\n    \t //alert(document.getElementById(\"dvNotesMenu\").style.min-height);\n    \t// document.getElementById(\"dvNotesMenu\").style.min-height = \"748px\";\n    \t$(\"#dvNotesMenu\").css(\'min-height\',\'677px\');\n    \t var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n    \t $(\"#notesContentFrame\").css(\'height\', dvheight);\n    \t //document.getElementById(\"notesContentFrame\").style.height = $(\"#dvNotesMenu\").height() ;\n    \t //alert(document.getElementById(\"dvNotesMenu\").style.height);\n    \t //alert(document.getElementById(\"notesContentFrame\").style.height);\n\t   }\n \n}\nfunction loadWidgets()\n{\n\twindow.parent.showLoadingMsg();\n}\nfunction showNotesContent(notesdesc,accessnum)\n{\n\t//alert(\"hi\");\n\t//var url = \"jsp/ViewNotescontent.jsp?accession_num=\" + accessnum + \"&notesHeader=\" + notesdesc;\n\tvar newAccessionNum = escape(accessnum);\n\tvar url = \"ViewNotescontent.jsp?accession_num=\" + newAccessionNum + \"&notesHeader=\" + notesdesc;\n\t//var url = \"../eCA/jsp/ViewNotescontent.jsp?accession_num=\" + accessnum + \"&notesHeader=\" + notesdesc;\n\t//var url = \"../eCA/jsp/aa.html\";\n\t//alert(url);\n\tdocument.getElementById(\"notesContentFrame\").src = url;\n\twindow.parent.scrolTop();\n}\nfunction submitNotesContent(obj)\n{\n\t//hdnPostBack\n\tobj.style.border = \"3px solid #48d1d8\";\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tif(document.getElementById(\"chkEncounter\").checked)\n\t\t{\n\t\tdocument.getElementById(\"hdnEncounterChk\").value = \"true\";\n\t\t}\n\telse\n\t\t{\n\t\tdocument.getElementById(\"hdnEncounterChk\").value = \"false\";\n\t\t}\n\t\n\tdocument.getElementById(\"frmNotesContent\").submit();\n\t\n}\n</script>\n</head>\n\n<body onload = \"Loading()\" style = \"background-color : #ffffff\">\n<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n <form id = \"frmNotesContent\" >\n\n <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\" >\n   <div data-role = \"none\" class = \"dvViewNotes\">\n     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n       <tr style=\"width:100%;height:100%\">\n         <td style = \"width : 95%\" align = \"left\" valign = \"center\">\n            <span class = \"spanViewNotes\">View Notes</span>\n            \n         </td> \n         <td style=\"width:5%\" onclick = \"loadWidgets()\" align = \"center\" valign = \"middle\">\n            <img src = \"../images/Close.png\"></img>\n         </td>\n       </tr>\n     </table>\n   </div>\n   <div id = \"dvCriteria\" class = \"dvCriteria\">\n  \n      <table style=\"height:68px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\n\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t\t      <td align = \"left\" style=\"width:33%\"><span class = \"spanPeriod\">Period</span></td>\n\t\t\t\t      <td align = \"left\" style=\"width:67%\">   \n\t\t\t\t      </td>\n\t\t\t     </tr>\n\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:33%\">\n\t\t\t        <select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbCriteria\" name = \"cmbCriteria\"> \n\t\t\t         <option value = \"OD\">Last One Day</option> \n                      <option value = \"TD\">Last Three Days</option>  \n\t\t\t          <option value = \"OW\">Last One Week</option> \n\t\t\t          <option value = \"OM\">Last One Month</option> \n\t\t\t          <option value = \"OY\">Last One Year</option> \n\t\t\t\t\t</select> \n\t\t\t      </td>\n\t\t\t      <td align = \"left\" style=\"width:67%\" valign = \"middle\">\n\t\t\t      \n\t\t\t      \n\t\t\t       <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t         <tr style = \"width:100%;height:100%\">\n\t\t\t           <td style = \"width:50%;height:100%\" valign = \"middle\" align = \"center\">\n\t\t\t              <input type = \"checkbox\" data-role = \"none\"  class = \"chkEncounter\" checked = true id = \"chkEncounter\" name = \"chkEncounter\"/><span class = \"spEncounter\">Limit To Current Encounter</span>\n\t\t\t           </td>\n\t\t\t           <td style = \"width:50%;height:100%\" valign = \"middle\" align = \"left\">\n\t\t\t           &nbsp;  &nbsp;\n\t\t\t             <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Search\' class=\"btnType1\"  data-role = \"none\" onclick = \"submitNotesContent(this)\"/>\n\t\t\t           </td>\n\t\t\t         <tr>\n\t\t\t       </table>\n\t\t\t      </td>\n\t\t\t     \n\t\t\t       \n\t\t\t     </tr>\n\t\t\t     \n\t\t\t     \n\t\t\t     <tr style=\"height:3px;width:100%\">\n\t\t\t       <td>&nbsp;</td>\n\t\t\t     </tr>\n\t\t   </table>\n   </div>\n\n   <div id = \"dvNotesMenu\" class = \"dvNotesMenu\" data-role = \"none\">\n    \n          \n          ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n            \t  <table  style = \"width:100%;height:auto\" border = \"0\" cellspacing  = \"0\" cellpadding = \"0\" class = \"TbNotesMenu\">\n\t\t\t           <tr style = \"width:100%;height:10px\">\n\t\t\t            <td style = \"width:5%\"></td>\n\t\t\t            <td style = \"width:95%\" align = \"left\" valign = \"middle\"> </td>\n\t\t\t          </tr> \n            \t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t                         \n\t\t\t\t\t          <tr style = \"width:100%;height:20px\">\n\t\t\t\t\t            ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t            <td style = \"width:5%\"></td>\n\t\t\t\t\t            <td style = \"width:95%\" align = \"left\" valign = \"middle\"> <span class = \"spNotesMenu\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span></td>\n\t\t\t\t\t            ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t            <td style = \"width:5%;border-top : 1px solid #d2d0d0\"></td>\n\t\t\t\t\t            <td style = \"width:95%;border-top : 1px solid #d2d0d0\" align = \"left\" valign = \"middle\"> <span class = \"spNotesMenu\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t          </tr>\n\t\t\t          \n\t\t\t           \n\t\t\t          ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t            <tr style = \"width:100%;height:10px\">\n\t\t            <td colspan = \"2\" >\n\t\t              \n\t\t            </td>\n\t\t          </tr>\n\t\t          <tr style = \"width:100%;height:20px\">\n\t\t            <td colspan = \"2\" onclick = \"showNotesContent(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">\n\t\t              <span class = \"spNotesMenu1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t            </td>\n\t\t          </tr>\n\t\t          <tr style = \"width:100%;height:10px\">\n\t\t            <td colspan = \"2\" >\n\t\t              \n\t\t            </td>\n\t\t          </tr>\n\t\t          \n          ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n              </table>\n            ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n             \n           ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n       <!--     -->\n        \n   </div> \n   <div id = \"dvNotesContent\" class = \"dvNotesContent\">\n      ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n       ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n      ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n      <div style = \"height:auto;overflow:auto;padding:0px\" data-role = \"none\">\n     <iframe frameborder=\"0\" id=\"notesContentFrame\" src=\"\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\" ></iframe>\n     </div>\n   </div>\n</div>\n<input type =\"hidden\" name = \"hdnPostBack\" id = \"hdnPostBack\" />\n<input type =\"hidden\" name = \"hdnEncounterChk\" id = \"hdnEncounterChk\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n<input type = \"hidden\" name = \"hdnPeriod\" id = \"hdnPeriod\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\n\n</form> \n</section>  \n ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strNotesDesc = "";
//String strPeriod = "OW";
//String strEncounterChk = "true";
//String strPeriod = "OD";
String strTodate = "";
String strFromDate = "";
String strPostBack = "";
String strInterval = "";
int value = 1;
String strPatientId = "";
String strEncounterId = "";


PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;
String strRowCount = "";
if(session.getValue("facility_id") != null )
{
	oPatientContext.sFacilityId = (String)session.getValue("facility_id");
}
if(session.getValue("ca_practitioner_id") != null)
{
	oPatientContext.sClinicianId  = (String)session.getValue("ca_practitioner_id");
}
if(session.getValue("practitioner_type") != null )
{
	oPatientContext.sPracType = (String)session.getValue("practitioner_type");
}
if(session.getValue("PatientID") != null)
{
	oPatientContext.sPatientId = (String)session.getValue("PatientID");
}
if(session.getValue("EpisodeId") != null )
{
	oPatientContext.sEncounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("login_user") != null )
{
	oPatientContext.loggedInUser = (String)session.getValue("login_user");
}
if(session.getValue("responsibility_id") != null )
{
	oPatientContext.responsibilityID = (String)session.getValue("responsibility_id");
}
oPatientContext.sEncounterCheck = "true";
oPatientContext.sPeriod = "OD";
//strPatientId = "HE00001197";
//strEncounterId = "10094030";

oPatientContext.sTodate = DateUtils.getCurrentDate("DMY", "en");

strPostBack = request.getParameter("hdnPostBack");
if(strPostBack != null && strPostBack.equals("true"))
{
	if(request.getParameter("cmbCriteria") != null)
	{
		oPatientContext.sPeriod = request.getParameter("cmbCriteria");
	}
	oPatientContext.sEncounterCheck = request.getParameter("hdnEncounterChk");
}

if(oPatientContext.sTodate != null && !oPatientContext.sTodate.equals(""))
{
	if(oPatientContext.sPeriod.equals("OW") )
	{
		strInterval = "w";
	}
	if(oPatientContext.sPeriod.equals("OM") )
	{
		strInterval = "M";
	}
	if(oPatientContext.sPeriod.equals("OY") )
	{
		strInterval = "Y";
	}
	if(oPatientContext.sPeriod.equals("OD") )
	{
		strInterval = "d";
	}
	if(oPatientContext.sPeriod.equals("TD") )
	{
		strInterval = "d";
		value = 3;
	}
	oPatientContext.sFromDate = DateUtils.minusDate(oPatientContext.sTodate, "DMY", "en", value, strInterval);
}












            _bw.write(_wl_block1Bytes, _wl_block1);

          NotesDetail bean = new NotesDetail();
          List<Notes> objNotesDetails = new ArrayList<Notes>(); 
          int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
          int nCssCount = 1;  // To display alternate Row Color.
          int nDummyRowcount = 1;
          int nListSize = 0;

          int nLoopCount = 0;
          Notes oNotes = null;
          try {
        	   objNotesDetails = bean.getNotes(oPatientContext);
        	   if(objNotesDetails != null)
        	      nListSize =  objNotesDetails.size();
        	  
        	 if(nListSize > 0)
            {
            	
            _bw.write(_wl_block2Bytes, _wl_block2);
 
        		 for(nLoopCount = 0 ; nLoopCount < nListSize; nLoopCount ++)
            	{
        			 oNotes = objNotesDetails.get(nLoopCount);	
            		if(oNotes != null)
            		{
	            		if(strNotesDesc != null && !strNotesDesc.equals(oNotes.sNoteTypeDesc))
	            		{
	            		
	                     
            _bw.write(_wl_block3Bytes, _wl_block3);

					              if(strNotesDesc.equals(""))
					            		  {
					            
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( oNotes.sNoteTypeDesc));
            _bw.write(_wl_block5Bytes, _wl_block5);

					            		  }
					              else
					              {
					            
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( oNotes.sNoteTypeDesc));
            _bw.write(_wl_block5Bytes, _wl_block5);

					              }
					            
            _bw.write(_wl_block7Bytes, _wl_block7);

	            		}
			          
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( oNotes.sNoteTypeDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( oNotes.sAccessNum));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( oNotes.sEventDateTime));
            _bw.write(_wl_block11Bytes, _wl_block11);

           strNotesDesc = oNotes.sNoteTypeDesc;
            		}
            	} //for
            
            _bw.write(_wl_block12Bytes, _wl_block12);
 	
            } //end if
            else
            {
          
            _bw.write(_wl_block13Bytes, _wl_block13);

            }
           
            _bw.write(_wl_block14Bytes, _wl_block14);

      if(nListSize == 0)
      {
      
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block16Bytes, _wl_block16);

      }
      
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( oPatientContext.sEncounterCheck));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oPatientContext.sPeriod));
            _bw.write(_wl_block19Bytes, _wl_block19);

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}

            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
