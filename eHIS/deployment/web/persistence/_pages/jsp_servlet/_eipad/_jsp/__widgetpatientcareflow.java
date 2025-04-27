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

public final class __widgetpatientcareflow extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/WidgetPatientCareFlow.jsp", 1709118034302L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>jQuery Mobile Application</title>\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/ipadAllergyContent.css\" />\n\n<script>\n\nfunction expandPatientCareflow()\n{\n\t\n\twindow.parent.expandwidget8();\n}\nfunction DisplayOrHideDetails(HeaderName,objImg)\n{\n\t\n\t\n\t var imgPath = objImg.src; \n\t if( imgPath.indexOf(\"Expanded\") != -1 )\n\t\t {\n\t\t objImg.src = \"../images/More group icon main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'none\');\n\t\t }\n\t else\n\t\t {\n\t\t objImg.src = \"../images/Expanded Group Icon Main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'block\');\n\t\t }\n\t var src = \"../images/Expanded group Icon.png\";\n\t// $(\"[data-image = \'\" + HeaderName + \"\']\").css(\'background\', \'url(\' + src + \')\'); \n\t$(\"[data-image = \'\" + HeaderName + \"\']\").attr(\"src\" , src);\n\t\n}\nfunction shownotes(histRecType,contrSysId,accessionNum,contrSysEventCode)\n{ \n\t\n\n\t\n\tvar newAccessionNum = escape(accessionNum);\n\t document.getElementById(\"patientcfsFrame1\").src = \"PatientCFSNotes.jsp?hist_rec_type=\" + histRecType + \"&contr_sys_id=\" + contrSysId + \"&accession_num=\" + newAccessionNum + \"&contr_sys_event_code=\" + contrSysEventCode;\n\t \n\t $.mobile.changePage(\"#patientcfsFrame\", \"pop\", false,false);\n\t \n}\nfunction closecfs()\n{\n\t $.mobile.changePage(\"mainPatientCFS\",\"pop\", true,false);\n\t\n\t}\nfunction changeOrientation(orient)\n{\n\t\t\n\tif(orient == \"landscape\")\n\t   {\n\t\t\n\t    $(\"#patientcfsFrame1\").css(\'min-height\',\'491px\');\n\t\n\t    document.getElementById(\"patientcfsFrame1\").contentWindow.changeOrientation(orient);\n\t   \n\t\t   \n\t   }\n     else\n\t   {\n    \t\n    \t$(\"#patientcfsFrame1\").css(\'min-height\',\'747px\');\n \n    \t document.getElementById(\"patientcfsFrame1\").contentWindow.changeOrientation(orient);\n    \n  \t   \n\t   }\n \n}\n</script>\n</head>\n<body>\n\n\t<section id=\"mainPatientCFS\" data-role=\"page\"\n\t\tstyle=\"background-color: white\">\n\n\t\t<div class=\"dvWidgetHeaderResults\">\n\t\t\t<table style=\"width: 100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td style=\"width: 95%\" valign=\"middle\"><span\n\t\t\t\t\t\tclass=\"spaDvHeaderResults\">Patient Care Flow Sheet</span></td>\n\n\t\t\t\t\t\n\t\t\t\t\t<td style=\"width: 5%\" align=\"center\" valign=\"middle\"\n\t\t\t\t\t\tonclick=\"expandPatientCareflow()\"><img\n\t\t\t\t\t\tsrc=\"../images/Collapse icon.png\"></img></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<table class = \"tbParent\"  border=\"0\"\n\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr class=\'trResultsHeader\'>\n\t\t\t\t<td style=\'width: 4%\' align=\"center\" valign=\"middle\"><img\n\t\t\t\t\tsrc=\"../images/More group icon main.png\"\n\t\t\t\t\tonclick=\"DisplayOrHideDetails(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' , this)\"></img></td>\n\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t\t<table style=\"width: 100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td style=\'width: 35%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</b></span></td>\n\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t<div data-role=\"none\" data-class=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\t\t\tstyle=\"display: none\">\n\n\n\t\t\t<table class = \"tbParent\" border=\"0\"\n\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\n\t\t\t\t<tr class=\"trpatientcfsSummary\">\n\t\t\t\t\t<td style=\'width: 4%;\' align=\"center\" valign=\"middle\">&nbsp;</td>\n\n\t\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t\t\t<table style=\"width: 100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td style=\'width: 35%\' align=\'left\'><span\n\t\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails1\"><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span></td>\n\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n     ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n     <div data-role = \"none\" data-class = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" style = \"display:none\" >\n      <table class = \"tbParent\" border=\"0\"\n\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\n\t\t\t\t<tr class=\"trpatientcfsSummary\">\n\t\t\t\t\t<td style=\'width: 10%;\' align=\"center\" valign=\"middle\">&nbsp;</td>\n\n\t\t\t\t\t<td style=\'width: 90%\' align=\'left\'>\n\t\t\t\t\t\t<table style=\"width: 100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails1\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span></td>\n\t\t\t\t\t\t\t\t\t<td style=\'width: 40%\' align=\'left\'>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n                                <span\n\t\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails1\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n                                ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t            &nbsp;<img src = \"../images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"> </img>\n\t\t\t         ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t               &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t          \n\t\t\t         ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t        \t        &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t        \t        \n\t\t\t           ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t        \t  &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\" style = \"margin-top : 7px\"> </img>\n\t\t\t        \t  \n\t\t\t      ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t          ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t\t        \t &nbsp;&nbsp;<span\n\t\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails1\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\t\t\n\t\t\t       </td>\n\t\t\t       <td style=\'width: 35%\' align=\'left\' valign = \"top\">\n\t\t\t       ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n                         <img src = \"../images/Grid Note icon.png\" style = \"margin-top : 2px;\" onclick = \"shownotes(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\">\n                         </img>\n                       ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t       </td>\n\t\t\t       \n\t\t\t\t\t\t\t\t\n \t</tr>\n\t\t\t\t\t\t</table>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n                              \n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t  \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t</section>\n\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n<section id=\"patientcfsFrame\" data-role = \"page\" style = \"background-color: #ffffff;padding:0px\">\n<div  style = \"height:auto;overflow:auto;padding:0px;background-color: #ffffff\" data-role = \"none\">\n     <iframe frameborder=\"0\" id=\"patientcfsFrame1\" src=\"\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\"  ></iframe>\n     </div>\n     </section>\n     \n</body>\n</html>\n\n\n\n\n\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

String resultNum = "";
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
String streventdate = "";
String streventgroupdesc = "";
String streventclass = "";
String textExist = "";
String strEventGroupDesc = "";
String strEventClass = "";
String descCellInd = "";

	PatientContext oPatientContext = new PatientContext();
	oPatientContext.request = request;

	if (session.getValue("facility_id") != null) {
		oPatientContext.sFacilityId = (String) session
				.getValue("facility_id");
	}
	if (session.getValue("ca_practitioner_id") != null) {
		oPatientContext.sClinicianId = (String) session
				.getValue("ca_practitioner_id");
	}
	if (session.getValue("practitioner_type") != null) {
		oPatientContext.sPracType = (String) session
				.getValue("practitioner_type");
	}
	if (session.getValue("PatientID") != null) {
		oPatientContext.sPatientId = (String) session
				.getValue("PatientID");
	}
	if (session.getValue("EpisodeId") != null) {
		oPatientContext.sEncounterId = (String) session
				.getValue("EpisodeId");
	}
	

            _bw.write(_wl_block1Bytes, _wl_block1);

		eIPAD.PatientCFSDetails bean = new eIPAD.PatientCFSDetails();
		List<PatientCFS> objPatientCFSDetails = new ArrayList<PatientCFS>(); 
		int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
		int nCssCount = 1;  // To display alternate Row Color.
		int nDummyRowcount = 1;
		int nListSize = 0;

		int nLoopCount = 0;
		PatientCFS oPatientCFS = null;
		try {
		objPatientCFSDetails = bean.getPatientCFSDetails(oPatientContext);
		nListSize =  objPatientCFSDetails.size();

		if(nListSize > 0)
		{

			 for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
			 {
				 oPatientCFS = objPatientCFSDetails.get(nLoopCount);
				  if(oPatientCFS != null )
				  {
					    color_cell_indicator = oPatientCFS.getsNormalRangeSymbol();
                        normalLow = oPatientCFS.getsNormalLow();
						normalHigh = oPatientCFS.getsNormalHigh();
						resultNum = oPatientCFS.getsResultNum();
						textExist = oPatientCFS.getsTextExist();
						descCellInd = oPatientCFS.getsDescCellIndicator();
						String EventGroupDesc = oPatientCFS.getsEventDate() + oPatientCFS.getsEventClass() + oPatientCFS.getsEventGroupDesc();
						String EventClass = oPatientCFS.getsEventDate() + oPatientCFS.getsEventClass() ; 
						streventgroupdesc = oPatientCFS.getsEventGroupDesc();
						streventclass = oPatientCFS.getsEventClass();
						
				
            _bw.write(_wl_block2Bytes, _wl_block2);

			if (!streventdate.equals(oPatientCFS.getsEventDate()) ) {
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oPatientCFS.getsEventDate()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oPatientCFS.getsEventDate()));
            _bw.write(_wl_block5Bytes, _wl_block5);

			}
		
            _bw.write(_wl_block6Bytes, _wl_block6);

   if(!strEventClass.equals(EventClass) && !streventclass.equals(""))
   {
   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oPatientCFS.getsEventDate()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oPatientCFS.getsEventClass()));
            _bw.write(_wl_block9Bytes, _wl_block9);

   }
     
            _bw.write(_wl_block10Bytes, _wl_block10);

     
   if(!strEventGroupDesc.equals(EventGroupDesc) && !streventgroupdesc.equals("") ) 
   {
   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oPatientCFS.getsEventDate()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oPatientCFS.getsEventGroupDesc()));
            _bw.write(_wl_block9Bytes, _wl_block9);

   }
     
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( oPatientCFS.getsEventDate()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oPatientCFS.getsDesc()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oPatientCFS.getsCareFlowDetail()));
            _bw.write(_wl_block14Bytes, _wl_block14);

			         if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
			         {
			         
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(color_cell_indicator));
            _bw.write(_wl_block16Bytes, _wl_block16);

			         }
			         else
			         {//1
			        	 if(!normalLow.equals("") && !normalHigh.equals(""))
			        	 {//2
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//3
			        			 if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)))
			        			 {//4
			         
            _bw.write(_wl_block17Bytes, _wl_block17);

			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//33
			        			 if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 
            _bw.write(_wl_block18Bytes, _wl_block18);
 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//333
			        			 if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
			        			 {//444
			        	  
            _bw.write(_wl_block19Bytes, _wl_block19);
 
			        			 }//e444
			        		 }//e333
			        	 }//e222
			       }//end 1
			         
            _bw.write(_wl_block20Bytes, _wl_block20);
 
			         if(!descCellInd.equals(""))
				{
			        	 
				
			        	 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oPatientCFS.getsDescCellIndicator()));
            _bw.write(_wl_block22Bytes, _wl_block22);

			         }
			         
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(textExist != null  && !textExist.trim().equals(""))
                      {
                      
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( oPatientCFS.getsHistRecType()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( oPatientCFS.getsContrSysID()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( oPatientCFS.getsAccessionNum()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( oPatientCFS.getsContrSysEventCode()));
            _bw.write(_wl_block26Bytes, _wl_block26);

			         }
			         
            _bw.write(_wl_block27Bytes, _wl_block27);

		streventdate = oPatientCFS.getsEventDate();
		/*streventclass = oPatientCFS.getsEventClass();*/
		/*streventgroupdesc = oPatientCFS.getsEventGroupDesc();*/
		strEventGroupDesc = EventGroupDesc;
		strEventClass = EventClass;
		
						}
						nRowCount = nRowCount + 1;
						if (nCssCount == 1) {
							nCssCount = nCssCount + 1;
						} else {
							nCssCount = nCssCount - 1;
						}

					}//for
				}//if listsize
				else
				 {
					 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
				 }
		
		
            _bw.write(_wl_block30Bytes, _wl_block30);

		} catch (Exception e) {
			out.println("Exception " + e);
			//out.println(sqlStr.toString());
			e.printStackTrace();
		} finally {

		}
	
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
