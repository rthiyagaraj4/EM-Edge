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

public final class __widgetresultdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/widgetResultDetail.jsp", 1709118034818L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/ipadAllergyContent.css\" />\n\n<script>\nvar bHeaderImage = false;\nvar bChildDetails = true;\nfunction DisplayOrHideDetails(HeaderName,objImg)\n{\n\t\n\t\n\t var imgPath = objImg.src; \n\t if( imgPath.indexOf(\"Expanded\") != -1 )\n\t\t {\n\t\t objImg.src = \"../images/More group icon main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'none\');\n\t\t }\n\t else\n\t\t {\n\t\t objImg.src = \"../images/Expanded Group Icon Main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'block\');\n\t\t }\n\t var src = \"../images/Expanded group Icon.png\";\n\t// $(\"[data-image = \'\" + HeaderName + \"\']\").css(\'background\', \'url(\' + src + \')\'); \n\t$(\"[data-image = \'\" + HeaderName + \"\']\").attr(\"src\" , src);\n\t\n}\nfunction HideChildRows(evendate,objChildImg)\n{\n\t\n\t var imgPath = objChildImg.src; //encodeURIComponent(\"images/Expanded group Icon.png\");\n\t// alert(imgPath);\n\t if( imgPath.indexOf(\"Expanded\") != -1 )\n\t\t {\n\t\t   objChildImg.src = \"../images/More Group Icon.png\";\n\t\t   $(\"[data-childrows = \'\" + evendate + \"\']\").css(\'display\',\'none\');\n\t\t }\n\t else\n\t\t {\n\t\t objChildImg.src = \"../images/Expanded group Icon.png\";\n\t\t $(\"[data-childrows = \'\" + evendate + \"\']\").css(\'display\',\'block\');\n\t\t }\n}\nfunction shownotes(histRecType,contrSysId,accessionNum,contrSysEventCode)\n{ \n\t\n\n\t\n\tvar newAccessionNum = escape(accessionNum);\n\t document.getElementById(\"notesContentFrame1\").src = \"ResultDetailsNotes.jsp?hist_rec_type=\" + histRecType + \"&contr_sys_id=\" + contrSysId + \"&accession_num=\" + newAccessionNum + \"&contr_sys_event_code=\" + contrSysEventCode;\n\t \n\t $.mobile.changePage(\"#notesContentFrame\", \"pop\", false,false);\n\t \n}\nfunction closenotes()\n{\n\t $.mobile.changePage(\"mainresults\",\"pop\", true,false);\n\t\n\t}\nfunction changeOrientation(orient)\n{\n\t\t\n\tif(orient == \"landscape\")\n\t   {\n\t\t\n\t    $(\"#notesContentFrame1\").css(\'min-height\',\'491px\');\n\t\n\t    document.getElementById(\"notesContentFrame1\").contentWindow.changeOrientation(orient);\n\t   \n\t\t   \n\t   }\n     else\n\t   {\n    \t\n    \t$(\"#notesContentFrame1\").css(\'min-height\',\'747px\');\n \n    \t document.getElementById(\"notesContentFrame1\").contentWindow.changeOrientation(orient);\n    \n  \t   \n\t   }\n \n}\nfunction refreshResultsExpandedview1()\n{\n\twindow.parent.refreshResultsExpandedview();\n\t\n\t}\nfunction expandwidget3()\n{\n\t\n\twindow.parent.expandwidget2();\n}\n</script>\n</head> \n<body> \n\n<section id = \"mainresults\" data-role=\"page\" style = \"background-color: #ffffff;padding:0px\"> \n\n\t\t\t\t\t  <div class=\"dvWidgetHeaderResults\" >\n\t\t\t\t\t\t  <table style=\"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t  <tr style=\"width:100%\">\n\t\t\t\t\t\t\t\t  <td  style=\"width:90%\" valign = \"middle\" >\n\t\t\t\t\t\t\t\t  <span class=\"spaDvHeaderResults\">Results</span>\n\t\t\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\t      <td  style=\"width:5%\" align = \"center\" valign = \"middle\" onclick = \"refreshResultsExpandedview1()\">\n\t\t\t\t\t\t\t         <img src = \"../images/Refresh1.PNG\"></img>\n\t\t\t\t\t\t\t      </td>\n\t\t\t\t\t\t\t       <td  style=\"width:5%\" align = \"center\" valign = \"middle\" onclick = \"expandwidget3()\">\n\t\t\t\t\t\t\t         <img src = \"../images/Collapse icon.png\"></img>\n\t\t\t\t\t\t\t      </td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t  </table>\n\t\t\t\t\t  </div>\n\t\t\t\t\t\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n  \n  ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n   <table style = \"width:100%;border: 1px solid #afb0b0 \" border = \"0\" cellspacing = \"0\" cellpadding = \"0\" >\n      <tr class = \'trResultsHeader\'  >\n         <td style = \'width:5%\' align = \"center\" valign = \"middle\">\n           <img src = \"../images/More group icon main.png\" onclick = \"DisplayOrHideDetails(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' , this)\"></img>\n         </td>\n          <td style = \'width:95%\' align = \'left\' >\n              <span class = \'spWidHeaderResluts\'><b>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</b></span>\n              \n          </td>\n      </tr>\n     </table> \n     ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n     \n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  \n    <div data-class = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" style = \"display:none;padding:0px\" data-role = \"none\">\n    \n    <table style = \"width:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n     <tr class = \"trResultDate\" >\n        <td style = \'width:5%;height:100%\'> </td>\n        <td style = \'width:95%;height:100%\'>\n           <table style= \'width:100%;height:100%\' border = \"0\" cellspacing = \'0\' cellpadding = \'0\' class = \"tbResultDate\">\n              <tr style = \'width:100%;height:100%\'>\n                <td style = \'width:4%\' align = \"center\" valign = \"middle\"> \n                  <img src = \"../images/Expanded group Icon.png\" style = \"margin-top: 3px\" onclick = \"HideChildRows(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' , this)\" data-image = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></img>\n                </td>\n                <td style = \'width:96%\' valign = \"center\"><span class = \"spaResultsDate\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span> \n               \n                </td>\n              </tr>\n           </table>\n        </td>\n     </tr>\n     </table> \n   </div> \n     ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  \n      <div data-role = \"none\" data-class = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style = \"display:none\" data-childrows = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n      <table style = \"width:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n     <tr class = \"trResultDetails\" >\n      \n        <td style = \'width:5%\'> </td>\n        <td style = \'width:95%\'>\n          \n           <table style= \'width:100%;height:100%\' border = \"0\" cellspacing = \'0\' cellpadding = \'0\' class = \"tbResultDetails\">\n              <tr style = \'width:100%;height:100%\'>\n                <td style = \'width:4%\'> </td>\n                <td style = \'width:96%\' valign = \"center\">\n                   <table style = \'width:100%;height:100%\' border = \'0\' cellspacing = \'0\' cellpadding = \'0\'>\n                      <tr style = \'width:100%;height:100%\'>\n                       \n                       <td style = \'width:96%\'> \n                           <table style = \'width:100%\' border = \'0\' cellspacing = \'0\' cellpadding = \'0\'>\n                             <tr style = \'height : 25px\'>\n                               <td style = \'width:50%\' valign = \'center\' > \n                               <span class = \'spanResultDetails\'> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </span>\n                               </td>\n                               <td style = \'width:25%\' valign = \'center\' > \n                                  <span class = \'spanResultDetails\'> Time : ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </span> </td>\n                                    \n                                     <td style = \'width:25%\' valign = \'center\' >\n                                     <span class = \'spanResultDetails\'> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </span> \n                                  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t            &nbsp;<img src = \"../images/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> </img>\n\t\t\t         ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t               &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t          \n\t\t\t         ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t        \t        &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t        \t        \n\t\t\t           ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t        \t  &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\" style = \"margin-top : 7px\"> </img>\n\t\t\t        \t  \n\t\t\t      ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t          ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t        \t &nbsp;<span\n\t\t\t\t\t\t\t\t\tclass=\"spanResultDetails\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\n                               </td>\n                               \n                               \n                             </tr>\n                             <tr style = \'height : 20px\'>\n                               <td colspan = \'3\' valign = \'center\' > \n                                  <span class = \'spanResultDetails\'> Reported By : ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </span>\n                               </td>\n                              </tr>\n                              \n                              <tr style = \'height : 20px\'>\n                               <td colspan = \'3\' valign = \'center\' > \n                                  <span class = \'spanResultDetails\'> Patient Class : ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</span>\n                               </td>\n                              </tr>    \n                               \n                         \n                            \n                           </table>\n                       </td>\n                       <td style =  \'width:4%\' align = \"left\" valign = \"top\">\n                      ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n                         <img src = \"../images/Grid Note icon.png\" style = \"margin-top : 2px;\" onclick = \"shownotes(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">\n                         </img>\n                       ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                       </td> \n                           \n                      </tr>\n                   </table>\n                 </td>\n              </tr>\n           </table>\n        </td> \n        \n     </tr>\n     </table>\n     </div>\n  \t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t  \n\t\t   ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t       \n\n</section>\n\n ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<section id=\"notesContentFrame\" data-role = \"page\" style = \"background-color: #ffffff;padding:0px\">\n<div  style = \"height:auto;overflow:auto;padding:0px;background-color: #ffffff\" data-role = \"none\">\n     <iframe frameborder=\"0\" id=\"notesContentFrame1\" src=\"\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\"  ></iframe>\n     </div>\n     </section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
String strPracType = "";
String strRecType = "";
String strRecDate = "";
double resultNum = 0;
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
String hist_data = "";
String descCellInd = "";

PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;

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


            _bw.write(_wl_block1Bytes, _wl_block1);
  
 
 eIPAD.ResultDetails bean = new eIPAD.ResultDetails();
 List<Results> objResultDetails = new ArrayList<Results>(); 
 int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
 int nCssCount = 1;  // To display alternate Row Color.
 int nDummyRowcount = 1;
 int nListSize = 0;

 int nLoopCount = 0;
 Results oResults = null;
 
 try {
	
	 objResultDetails = bean.getResultDetails(oPatientContext);
	 nListSize =  objResultDetails.size();

	 if(nListSize > 0)
	 {
		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
		  {
			  
			  oResults = objResultDetails.get(nLoopCount);
			  if(oResults != null )
			  {

				  color_cell_indicator = oResults.sNormalRangeSymbol;
				  normalLow = oResults.sNormalLow;
				  normalHigh = oResults.sNormalHigh;
				  resultNum = oResults.sResultNum;
				  hist_data = oResults.sHistData;
				  descCellInd = oResults.sDescCellIndicator;
  
            _bw.write(_wl_block2Bytes, _wl_block2);
if(!strRecType.equals(oResults.sHistRecTypeDesc)) 
  {
  
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( oResults.sHistRecTypeDesc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( oResults.sHistRecTypeDesc));
            _bw.write(_wl_block5Bytes, _wl_block5);

   }
     
            _bw.write(_wl_block6Bytes, _wl_block6);

   if(!strRecDate.equals(oResults.sEventDateTime )) 
   {
   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( oResults.sHistRecTypeDesc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oResults.sEventDateTime ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( oResults.sHistRecTypeDesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oResults.sEventDateTime ));
            _bw.write(_wl_block11Bytes, _wl_block11);

   }
     
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( oResults.sHistRecTypeDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oResults.sEventDateTime ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oResults.sEventDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oResults.sEventTime  ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oResults.sCareFlowDetail));
            _bw.write(_wl_block17Bytes, _wl_block17);

			         if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
			         {
			         
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(color_cell_indicator));
            _bw.write(_wl_block19Bytes, _wl_block19);

			         }
			         else
			         {//1
			        	 if(!normalLow.equals("") && !normalHigh.equals(""))
			        	 {//2
			        		 if(resultNum>0)
			        		 {//3
			        			 if((resultNum >= Float.parseFloat(normalLow)) && (resultNum <= Float.parseFloat(normalHigh)))
			        			 {//4
			         
            _bw.write(_wl_block20Bytes, _wl_block20);

			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(resultNum>0)
			        		 {//33
			        			 if(resultNum >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 
            _bw.write(_wl_block21Bytes, _wl_block21);
 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(resultNum>0)
			        		 {//333
			        			 if(resultNum <= Float.parseFloat(normalHigh))
			        			 {//444
			        	  
            _bw.write(_wl_block22Bytes, _wl_block22);
 
			        			 }//e444
			        		 }//e333
			        	 }//e222
			       }//end 1
			         
            _bw.write(_wl_block23Bytes, _wl_block23);
 
			         if(!descCellInd.equals(""))
				{
			        	 
				
			        	 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oResults.sDescCellIndicator));
            _bw.write(_wl_block25Bytes, _wl_block25);

			         }
			         
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oResults.sReportedBy ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oResults.sPatientClass ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 if(hist_data != null  && !hist_data.trim().equals(""))
                      {
                      
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( oResults.sHistRecType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( oResults.sContrSysId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( oResults.sAccession_num));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( oResults.sContrSysEventCode));
            _bw.write(_wl_block31Bytes, _wl_block31);

			         }
			         
            _bw.write(_wl_block32Bytes, _wl_block32);

  	strRecType = oResults.sHistRecTypeDesc;
  	strRecDate = oResults.sEventDateTime; 
			  }//if oresults! = null
  	 nRowCount = nRowCount + 1;
	  if(nCssCount==1)
	  {
		   nCssCount = nCssCount +1;
	  }
	  else
	  {
		  nCssCount = nCssCount -1;
	  }	  
		 
         }//for
	 }//if listsize
	 else
	 {
		 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
	 }
  
            _bw.write(_wl_block35Bytes, _wl_block35);

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}

            _bw.write(_wl_block36Bytes, _wl_block36);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
