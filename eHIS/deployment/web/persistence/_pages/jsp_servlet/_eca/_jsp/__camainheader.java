package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainHeader.jsp", 1709115547512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/CAMainMenuLookup.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\n\nfunction displaydatetime()\n{\n\t//var x = new Array(getLabel(\"Common.sun.label\",\'COMMON\'), getLabel(\"Common.mon.label\",\'COMMON\'),getLabel(\"Common.tue.label\",\'COMMON\'));\n\t//x = x.concat(getLabel(\"Common.wed.label\",\'COMMON\'),getLabel(\"Common.thu.label\",\'COMMON\'), getLabel(\"Common.fri.label\",\'COMMON\'));\n\t//x = x.concat(getLabel(\"Common.sat.label\",\'COMMON\'));\n\n\tvar date = new Date();\n\tvar hr = date.getHours(); if ( hr >= 0 && hr <= 9) hr=\'0\'+ hr ;\n\tvar min = date.getMinutes(); if ( min >= 0 && min <= 9) min=\'0\'+ min ;\n\t\n\t//var day = date.getDay();\n\t//var currdatetime = x[day]+\' \'+date.getDate()+\'/\'+((date.getMonth())+1)+\'/\'+date.getYear()+\' \'+hr+\':\'+min;\n\t\n\tvar date1 = date.getDate(); if ( date1 >= 0 && date1 <= 9) date1=\'0\'+ date1 ;\n\tvar month = date.getMonth()+1; if ( month >= 0 && month <= 9) month=\'0\'+ month ;\n\n\tvar currdatetime = date1+\'/\'+month+\'/\'+date.getYear()+\' \'+hr+\':\'+min\n\n\tif (document.getElementById(\"datetime\"))\n\t   document.getElementById(\"datetime\").innerText= currdatetime;\n}\nwindow.setInterval(\"displaydatetime()\", \"60000\");\n\nfunction MM_preloadImages() { \n  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\n    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\n    if (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\n}\n\nfunction MM_swapImgRestore() { \n  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;\n}\n\nfunction MM_findObj(n, d) { \n  var p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\n    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\n  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\n  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\n  if(!x && d.getElementById) x=d.getElementById(n); return x;\n}\n\nfunction MM_swapImage() {\n  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)\n   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}\n}\n\n</script>\n\n</head>\n<body class=\"HEADER\" onKeyDown=\"lockKey()\" onMouseDown=\"CodeArrest()\" onload=\"MM_preloadImages(\'../../eCA/images/MI_Switch2.gif\',\'../../eCA/images/MI_Logout2.gif\',\'../../eCA/images/MI_Close2.gif\')\">\n<form name=\'CAMainHeaderForm\' id=\'CAMainHeaderForm\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction closeFunction(childyn,wname,flag)\n{\n\ttop.content.messageFrame.document.write(\"<html><body onKeyDown=\'lockKey()\'><form name=\'openChartWrapperIntermediateForm\' id=\'openChartWrapperIntermediateForm\' method=\'post\' action=\'../../eCA/jsp/OpenChartWrapperIntermediate.jsp?queryStringForChart=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><input type=\'hidden\' name=\'patientID\' id=\'patientID\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><input type=\'hidden\' name=\'episodeID\' id=\'episodeID\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'><input type=\'hidden\' name=\'child_window\' id=\'child_window\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'><input type=\'hidden\' name=\'FromPatChart\' id=\'FromPatChart\' value=\'\'><input type=\'hidden\' name=\'FromCloseOrSwitch\' id=\'FromCloseOrSwitch\' value=\'Close\'><input type=\'hidden\' name=\'windName\' id=\'windName\' value=\'\"+wname+\"\'><input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'></form></body></html>\");\n\ttop.content.messageFrame.openChartWrapperIntermediateForm.submit();\n}\n\nfunction ShowPats(FromPatChart)\n{\n\ttop.content.messageFrame.document.write(\"<html><body onKeyDown=\'lockKey()\'><form name=\'openChartWrapperIntermediateForm\' id=\'openChartWrapperIntermediateForm\' method=\'post\' action=\'../../eCA/jsp/OpenChartWrapperIntermediate.jsp?queryStringForChart=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><input type=\'hidden\' name=\'FromPatChart\' id=\'FromPatChart\' value=\'\"+FromPatChart+\"\'><input type=\'hidden\' name=\'FromCloseOrSwitch\' id=\'FromCloseOrSwitch\' value=\'Switch\'><input type=\'hidden\' name=\'RelnYn\' id=\'RelnYn\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></form></body></html>\");\n\ttop.content.messageFrame.openChartWrapperIntermediateForm.submit();\n}\n\n</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<table width=\"100%\" border=\"1\" cellpadding=0 cellspacing=0>\n\t<tr>\n\t<td width=\'100%\' align=\"left\" class=\"HEADERTITLE\">\n\t&nbsp;<img src=\"../../eCommon/images/ielogo.gif\" height=\"10\" ></img> <font size=\"2\">eHospital Information System - Microsoft Internet Explorer </font>\n\t</td>\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>\n\t\t\tparent.workArea.rows = \"6%,*,0%\";\n\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<table width=\"100%\" cellpadding=0 cellspacing=0>\n<tr class=\"HEADER\">\n\t<td class=\"HEADER\" align=\"center\" valign=\"top\" width=\"5%\">\n\t\t<img src=\"../../eCommon/images/orgLogo.gif\" vspace=0 hspace=0>\n\t</td>\n\n\t<td class=\"HEADER\" align=\"left\" valign=\"top\" width=\"35%\">\n\t<b><font size=\"-1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</font></b>\n\t</td>\n\n\t<td class=\"HEADER\" align=\"left\" valign=\"top\" width=\"15%\">\n\t&nbsp;&nbsp;&nbsp;&nbsp;<b><font size=\"-1\">\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<!--</font>\n\t</b>\n\t</td>\n\n\t<td class=\"HEADER\" align=\"left\" valign=\"top\" width=\"15%\">\n\t<font size=\"-1\">\n\t<b> -->\n\n    <!-- added date/time -->\n\t<div id=\"datetime\" style=\"font-size: 80%; text-align: left; padding: 2px\" value=\"\"></div>\n\t<script>\n\tdisplaydatetime();\n\t</script>\n    <!-- end- added date/time -->\n\n\t\n\t</font></b>\n\t\n\t</td>\n\t\n\t<td class=\"HEADER\" align=\"right\" valign=\"top\" width=\"30%\">\n\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t<tr>\n\t<td class=\"HEADER\" align=\"right\">\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<img onclick=\"ShowPats()\" src=\'../../eCA/images/MI_Switch1.gif\' alt=\'Switch\' id=\'switch\' name=\'switch\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'switch\',\'\',\'../../eCA/images/MI_Switch2.gif\',1)\"></img>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<img src=\'../../eCA/images/MI_Switch1.gif\' onclick=\'getParentWindow()\' alt=\'Patient Chart\' id=\'pc\' name=\'pc\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'pc\',\'\',\'../../eCA/images/MI_Switch2.gif\',1)\"></img>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\n\t\t<img src=\'../../eCA/images/MI_Logout1.gif\'  onclick=\"logOff(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\" alt=\'Logout\' id=\'logout\' name=\'logout\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'logout\',\'\',\'../../eCA/images/MI_Logout2.gif\',1)\"></img>\n\t\t\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<img src=\'../../eCA/images/MI_Close1.gif\' onclick=\"closeFunction(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'Y\')\" alt=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'close\' name=\'close\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'close\',\'\',\'../../eCA/images/MI_Close2.gif\',1)\"></img>\n\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<img src=\'../../eCA/images/MI_Close1.gif\' onclick=\'hideLookupButton()\' alt=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'cc\' name=\'cc\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'cc\',\'\',\'../../eCA/images/MI_Close2.gif\',1)\"></img>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t&nbsp;&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n\t<td class=\"HEADER\" align=\"center\" valign=\"top\" width=\"5%\">\n\t\t<img src=\"../../eCommon/images/product_small.gif\" alt=\"IBA Health\">\n\t</td>\n</tr>\n</table>\n</form>\n</body>\n\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            eCA._ca_license_rights keyGen= null;{
                keyGen=(eCA._ca_license_rights)pageContext.getAttribute("keyGen");
                if(keyGen==null){
                    keyGen=new eCA._ca_license_rights();
                    pageContext.setAttribute("keyGen",keyGen);
                    _bw.write(_wl_block1Bytes, _wl_block1);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);

//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
//	String locale = request.getParameter("LOCALE") == null ? "" : request.getParameter("LOCALE");

	String jdbc_user = (String) session.getValue( "login_user" ) ;
	String facility_name =(String) session.getValue( "facility_name" ) ;
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String child_window = request.getParameter("child_window")==null?"":request.getParameter("child_window");
	String episode_id = request.getParameter("episode_id");
 	String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
	String wname = patient_id+episode_id+visit_id;
	String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");
	String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();
	String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
	//out.println("<script>alert('lookupFileName"+lookupFileName+"');</script>");
	String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
//	String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
//	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	if(from_service_yn.equals(""))
		from_service_yn="N";

	String altText = "Close Chart";
	
//	StringBuffer detl_sql = new StringBuffer();
	boolean pat_sel = false ;
	if( patient_id!=null || episode_id != null )
		pat_sel = true;
	if(patient_id == null) patient_id="";
	if(episode_id == null) episode_id="";

//	String respid =session.getValue("responsibility_id")==null?"":(String) session.getValue("responsibility_id");
	
//	String facilityid = session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//relationcode = (String)session.getValue("relationship_id");
	
//	String relationcode = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	
		
	Connection con = null;
	PreparedStatement pstmt = null,stmt = null;
	ResultSet rs = null,rset = null;
	
	try
	{
		con = ConnectionManager.getConnection(request);

	
	String site = "" ;
	stmt = con.prepareStatement("SELECT SITE_NAME FROM SM_SITE_PARAM WHERE 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = '"+(String) session.getAttribute( "facility_id" )+"')");
	rset = stmt.executeQuery();
	if(rset != null)
	{
		if(rset.next())
		{
			site = "<br>"+rset.getString("SITE_NAME");
		}
	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryStringForChart));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queryStringForChart));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strRelnYn));
            _bw.write(_wl_block16Bytes, _wl_block16);

	if(patient_id.equals(""))
	{

            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	else
	{

            _bw.write(_wl_block18Bytes, _wl_block18);

	}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(site));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( jdbc_user ));
            _bw.write(_wl_block22Bytes, _wl_block22);
if((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC"))
		{	
			if(lookupFileName.equals("") && from_service_yn.equals("N")&& limit_function_id.equals("")){
            _bw.write(_wl_block23Bytes, _wl_block23);
	}
		}
            _bw.write(_wl_block24Bytes, _wl_block24);

			if(!lookupFileName.equals(""))
			{
            _bw.write(_wl_block25Bytes, _wl_block25);
	}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

		if(!child_window.equals("Y"))
		{
			altText = "Close";
		}
		if(lookupFileName.equals("")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(wname));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

			if(!lookupFileName.equals(""))
			{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}
		
            _bw.write(_wl_block34Bytes, _wl_block34);
	
	if(rs!= null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(rset!= null)	rset.close();	
	if(stmt != null)	stmt.close();
} 
	catch (Exception e)
	{
		//out.println("Exception in CAMainHeader.jsp"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(con != null) ConnectionManager.returnConnection(con, request);
	}
	

            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
