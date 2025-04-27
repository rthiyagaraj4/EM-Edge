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

public final class __recentnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/RecentNotes.jsp", 1709118031130L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadRecentNotes.css\" />\n\n<script>\nfunction Loading()\n{\n\twindow.parent.hideLoading();\n\t \n}\nfunction changeOrientation(orient)\n{\n\t\t//alert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t\n\t    $(\"#dvNotesMenu\").css(\'min-height\',\'509px\');\n\t    \n\t    //var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n\t    \n\t   }\n     else\n\t   {\n\n    \t$(\"#dvNotesMenu\").css(\'min-height\',\'765px\');\n\t   }\n \n}\nfunction loadWidgets()\n{\n\twindow.parent.showCreateNotes();\n}\n\nfunction displayNotesContent(accessionNum,noteType)\n{\n\tvar newAccessionNum = escape(accessionNum);\n\twindow.parent.dispNotesContent(newAccessionNum,noteType);\n}\n</script>\n</head>\n\n<body onload = \"Loading()\" style = \"background-color : #ffffff\">\n<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n <form id = \"frmRecentNotes\" >\n\n <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\" >\n   <div data-role = \"none\" class = \"dvViewNotes\">\n     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n       <tr style=\"width:100%;height:100%\">\n         <td style = \"width : 95%\" align = \"left\" valign = \"center\">\n            <span class = \"spanViewNotes\">Recent Clinical Notes</span>\n            \n         </td> \n         <td style=\"width:5%\" onclick = \"loadWidgets()\" align = \"center\" valign = \"middle\">\n           <img src = \"../images/Close.png\"></img>\n         </td>\n       </tr>\n     </table>\n   </div>\n   \n\n   <div id = \"dvNotesMenu\" class = \"dvNotesMenu\" data-role = \"none\" >\n   \n       ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n         \t\t\t\t  <table class = \"tbRecentView\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\" onclick = \"displayNotesContent(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\',\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\')\">\n\t\t\t\t\t           <tr class = \"trRecentView";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t\t\t\t\t\t            <td style=\"width:60%\" align = \"left\" valign = \"center\">\n\t\t\t\t\t\t             <span class = \"srchLabel\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n\t\t\t\t\t\t           </td>\n\t\t\t\t\t\t           <td style=\"width:40%\" align = \"left\" valign = \"center\">\n\t\t\t\t\t\t             <span class = \"srchLabel\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n\t\t\t\t\t\t          </td>\n\t\t\t\t\t           </tr>\n\t\t\t\t          </table>\n         \t\t\t\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="       \n   </div> \n\n\n</div>\n\n\n\n</form> \n</section>  \n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "false";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";
CreateNotesRequest oCreateNotesReq = new CreateNotesRequest();
oCreateNotesReq.setRequest(request);


String normalInd = "";
String strPatientClass = "";
String strFilterBy = "P";
String strNoteType = "";


if(session.getValue("facility_id") != null )
{
	oCreateNotesReq.setFacilityId((String)session.getValue("facility_id"));
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
}
if(session.getValue("EpisodeId") != null )
{
	oCreateNotesReq.setEncounterId((String)session.getValue("EpisodeId"));
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
if(request.getParameter("hdnPostBack") != null)
{
	strPostBack = request.getParameter("hdnPostBack");
}
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("hdnPatientClass");
	strFilterBy = request.getParameter("hdnFilterBy");
	strNoteType = request.getParameter("hdnNoteType");
}
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);


            _bw.write(_wl_block1Bytes, _wl_block1);

       RecentClinicalNotesResponse oRecNoteResponse = null;
       List<RecentClinicalNotesHO> lstRecentClinicalNotes = null;
       RecentClinicalNotesHO oRecNotesHO = null;
       NotesDetail bean = new NotesDetail();
      
       int nLoopCount = 0;
       int nListSize = 0;
       int nCssCount = 1;  // To display alternate Row Color.
       try {
    	   oRecNoteResponse = bean.getRecentNotes(oCreateNotesReq);
           if(oRecNoteResponse != null && oRecNoteResponse.getLstRecentClinicalNotes() != null)
           {
        	   lstRecentClinicalNotes = oRecNoteResponse.getLstRecentClinicalNotes();
         	  if(lstRecentClinicalNotes != null)
         	  {
         		  nListSize = lstRecentClinicalNotes.size();
         	  }
         	  if(nListSize > 0)
         	  {
         		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
         		  {
         			 oRecNotesHO = lstRecentClinicalNotes.get(nLoopCount);
         			  if(oRecNotesHO != null)
         			  {
         				  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oRecNotesHO.getAccessionNum()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oRecNotesHO.getNoteType()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(nCssCount));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oRecNotesHO.getNoteTypeDesc() ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oRecNotesHO.getEventDateTime() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
         			  }
         			 if(nCssCount==1)
         			  {
         				   nCssCount = nCssCount +1;
         			  }
         			  else
         			  {
         				  nCssCount = nCssCount -1;
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
   
       
       
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
