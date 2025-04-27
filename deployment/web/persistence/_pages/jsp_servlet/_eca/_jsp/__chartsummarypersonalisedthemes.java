package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarypersonalisedthemes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryPersonalisedThemes.jsp", 1732528752502L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n \n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<TITLE>Personalize Themes</TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction setPersonalizedTheme(widgetStyleSheetName,contentID,id,totalStyleSheet)\n{\ndocument.getElementsByName(\"image\").className=\'\';\n\nfor(var i=1;i<=totalStyleSheet;i++)\n{\nvar className = document.getElementById(\"image\"+i).className;\nif(className !=\"\")\n document.getElementById(\"image\"+i).className = \'\';\n}\n\ndocument.getElementById(\"image\"+id).className=\'borderOnSelection\';\n\ndocument.getElementsByName(\"personalizeTheme\").value = widgetStyleSheetName;\n\n}\n\nfunction applytToAll(){\n\n\tvar contentID = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tvar summaryId = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\tvar patientClass = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\tvar practitioner = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\tvar speciality = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\tvar old = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\tvar personalizeTheme = document.getElementsByName(\"personalizeTheme\").value;\n\t\n\t\n\tvar xmlDoc  = \"\"; // new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlStr =\"<root><SEARCH \" ;\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\", \"ChartSummaryPersThemeTransaction.jsp?summaryId=\"+summaryId+\"&practitioner=\"+practitioner+\"&patientClass=\"+patientClass+\"&speciality=\"+speciality+\"&personalizeTheme=\"+personalizeTheme+\'&applyToAllWidget=Y\',false ) ;\n\t\n\txmlHttp.send( xmlDoc ) ;\n\tresponseText = xmlHttp.responseText ;\n    //window.close();\n\t  const dialogTag = parent.document.getElementById(\'dialog_tag\');    \n\t  dialogTag.close();   \n\t\n}\n\nfunction applyTheme(flag){\n\t//alert(\"flag\");\n\tvar contentID = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\tvar applyToAllWidget=\"N\";\n\tvar personalizeTheme = document.getElementsByName(\"personalizeTheme\").value;\n\tif(personalizeTheme==null)\n\tpersonalizeTheme = old;\n\tif(\"D\"==flag)\n\tpersonalizeTheme=null;\n\tif(\"DY\"==flag)\n\t{\n\tpersonalizeTheme=null;\n\tapplyToAllWidget=\"Y\"\n\t}\n\t\n\tvar xmlDoc  =\"\"; // new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlStr =\"<root><SEARCH \" ;\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\", \"ChartSummaryPersThemeTransaction.jsp?contentID=\"+contentID+\"&summaryId=\"+summaryId+\"&practitioner=\"+practitioner+\"&patientClass=\"+patientClass+\"&speciality=\"+speciality+\"&personalizeTheme=\"+personalizeTheme+\"&applyToAllWidget=\"+applyToAllWidget,false ) ;\n\t\n\txmlHttp.send( xmlDoc ) ;\n\tresponseText = xmlHttp.responseText ;\n\t//alert(\'132 in ChartSummaryPersonalisedThemes.jsp\');\n\t// window.close();\n\t// const dialogTag =document.getElementById(\"chartSummPersTheme\");    \n    // dialogTag.close();  \n\t// let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    // dialogBody.contentWindow.returnValue = retVal;\n    const dialogTag = parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); \n\n}\n</script>\n\n    <style type=\"text/css\">\n\t.DIVA{\n\tmargin:5px;\n\twidth:145px;\n\theight:auto;\n\tbackground-color:#ffffff;\n\tborder:1px solid #cdcdcd;\n\tpadding:1px;\n\tcursor:pointer;\n\t}\n\t.DIVB{\n\twidth:auto;\n\theight:auto;\n\tbackground-color:#ffffff;\n\tborder:2px solid #f6f6f6;\n\tpadding-top:2px;\n\tpadding-left:2px;\n\tpadding-right:2px;\n\tpadding-bottom:0px;\n\t}\n\t.DIVB:hover\n\t{\n\tborder:2px solid #3b4247;}\n\t.borderOnSelection{\n\tbackground-repeat: repeat-x;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 9pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:5px;\n\tpadding-right:0px;\n\tvertical-align:top;\n\tborder-left:2px;\n\tborder-right:2px;\n\tborder-top:2px;\n\tborder-bottom:2px;\n\tborder-color:red;\n\tborder-style:solid;\n\tmargin:10;\n\tborder-collapse: collapse;\n}\n\t</style>\n</HEAD>\n\n<BODY onKeyDown = \'lockKey()\' >\n<form name=\'chartSummPersTheme\' id=\'chartSummPersTheme\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<!--\t<table  border=0 align =\'right\'>\n\t<tr>\n\t<input type=\'button\' name=\'Apply Default Theme\' id=\'Apply Default Theme\' value =\'Default Theme\'  onClick=\'applyTheme(\"D\")\'/>\n\t</tr>\n\t</table>\n\t <table  border=0 align =\'right\'>\n\t\t<tr>\n\t\t<input type=\'button\' name=\'Apply Theme\' id=\'Apply Theme\' value =\'Apply Theme\'  onClick=\'applyTheme()\'/>\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<table  border=0 align =\'right\'>\n\t\t<tr>\n\t\t<input type=\'button\' name=\'ApplyToAllWidgets\' id=\'ApplyToAllWidgets\' value =\'Apply Theme To All Widgets\'  onClick=\'applytToAll()\'/>\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<table  border=0 align =\'right\'>\n\t\t<tr>\n\t\t<input type=\'button\' name=\'DefaultToAllWidgets\' id=\'DefaultToAllWidgets\' value =\'Default Theme To All Widgets\'  onClick=\'applyTheme(\"DY\")\'/>\n\t\t\n\t\t</tr>\n\t\t</table> --> \n\t\t<div style=\"text-align: right;\">\n    <input type=\'button\' name=\'DefaultToAllWidgets\' id=\'DefaultToAllWidgets\' value=\'Default Theme To All Widgets\' onClick=\'applyTheme(\"DY\")\'/>\n    <input type=\'button\' name=\'ApplyToAllWidgets\' id=\'ApplyToAllWidgets\' value=\'Apply Theme To All Widgets\' onClick=\'applytToAll()\'/>\n    <input type=\'button\' name=\'Apply Theme\' id=\'Apply Theme\' value=\'Apply Theme\' onClick=\'applyTheme()\'/>\n\t<input type=\'button\' name=\'Apply Default Theme\' id=\'ApplyDefaultTheme\' value=\'Default Theme\' onClick=\'applyTheme(\"D\")\'/>\n</div>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n\n\t\t<input type=hidden name=\'personalizeTheme\' id=\'personalizeTheme\' value=\"\">\n\t\t<input type=hidden name=\'contentID\' id=\'contentID\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=hidden name=\'patientClass\' id=\'patientClass\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=hidden name=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=hidden name=\'practitioner\' id=\'practitioner\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\n</form>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       created
12/02/2013		CHL_CRF		Nijitha		CHL_CRF - File Added and Changes as part of Default and Personlised themes to be applied for All widgets		
26/03/2013	   IN038959		Nijitha		REGRESSION-CRF-CA- CHL-CRF- 0008 /12- Chart Summary->Some icons in the Widget are not displayed								 
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);



Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
StringBuilder personaliseThemeQuery = new StringBuilder();
StringBuilder totalStyleSheetQuery = new StringBuilder();
//ArrayList positionsList = new ArrayList();	//Checkstyle 4.0 Beta 6
//int temp =0,tempRowId=0,totalRows = 0, tempExists = 0,totalCols=0;	//Checkstyle 4.0 Beta 6
//float widthPerCell=0,heightPerCell=0;	//Checkstyle 4.0 Beta 6
String contentID = request.getParameter("contentID");
String summaryId = request.getParameter("summaryId");
String patientClass = request.getParameter("patClass");
String practitioner = request.getParameter("practitioner");
String speciality =request.getParameter("speciality");
//String titleContent =request.getParameter("titleContent");	//Checkstyle 4.0 Beta 6
//String totalCount =request.getParameter("totalCount");	//Checkstyle 4.0 Beta 6

//String summaryDesc = request.getParameter("summaryDesc");//Checkstyle 4.0 Beta 6
String styleSheetNameOld = request.getParameter("styleSheetName");
//personaliseThemeQuery.append("select SRL_NO,STYLE_SHEET,STYLE_SHEET_NAME,STYLE_SHEET_IMAGE from CA_WIDGET_STYLE_SHEET where content_id = ?");
//personaliseThemeQuery.append("SELECT WSH.STYLE_SHEET_ID,CSCN.CONTENT_ID,WSH.STYLE_SHEET,WSH.STYLE_SHEET_NAME,WSH.STYLE_SHEET_IMAGE FROM CA_CHART_SUMM_CONTENT CSCN,CA_WIDGET_STYLE_SHEET WSH WHERE WSH.content_id = cscn.content_id AND WSH.content_id = ?");
personaliseThemeQuery.append("SELECT WSH.STYLE_SHEET_ID,CSCN.CONTENT_ID,WSH.STYLE_SHEET,WSH.STYLE_SHEET_NAME,WSH.STYLE_SHEET_IMAGE FROM CA_CHART_SUMM_CONTENT CSCN,CA_WIDGET_STYLE_SHEET WSH WHERE WSH.content_id = cscn.content_id AND WSH.content_id = ? ORDER BY WSH.STYLE_SHEET_ID ASC");
totalStyleSheetQuery.append("select count(STYLE_SHEET_ID) as style from ca_widget_style_sheet where content_id = ?");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(contentID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(summaryId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(styleSheetNameOld));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contentID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(summaryId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(styleSheetNameOld));
            _bw.write(_wl_block16Bytes, _wl_block16);

try{
	int totalStyleSheet = 0;
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(totalStyleSheetQuery.toString());
	pstmt.setString(1,contentID);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		totalStyleSheet = rs.getInt("style");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	
	pstmt = con.prepareStatement(personaliseThemeQuery.toString());
	//pstmt.setString(1,summaryId);
	pstmt.setString(1,contentID);
	rs = pstmt.executeQuery();
	
	String content_id = "";
	String styleSheetName ="";
	String styleSheetId = "";
	String themesDisplay = "";
	String className ="";
	int a = 0;
	
	while(rs.next()){
			
			content_id = rs.getString("CONTENT_ID");
			styleSheetName=rs.getString("STYLE_SHEET");
			styleSheetId =	rs.getString("STYLE_SHEET_ID");
			themesDisplay = "<div class='DIVA'><div class='DIVB'><a href='javascript:setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\",\""+rs.getString("STYLE_SHEET_ID")+"\",\""+totalStyleSheet+"\")' title='Themes' selected>"+"<img  src='../../eCA/images/"+rs.getString("STYLE_SHEET_IMAGE")+"' />"+"</div></div></a>";
			//	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
			//out.println("<a href='javascript:setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\");' title='Themes'>");
			
			if(null!=styleSheetNameOld && null!=styleSheetName && !"".equals(styleSheetName) && !"".equals(styleSheetNameOld) && styleSheetName.equals(styleSheetNameOld))
			{
				className = "borderOnSelection";
			}
	//	out.println("<img  src='../../eCA/images/"+rs.getString("STYLE_SHEET_IMAGE")+"' onClick='setPersonalizedTheme(\""+rs.getString("STYLE_SHEET")+"\",\""+rs.getString("CONTENT_ID")+"\");'/>");
			//out.println("<table width='100%'><tr><td class='COLUMNHEADERCENTERNEW"+styleSheetId+"'>"+themesDisplay+"</td></tr></table>");
			if(a==0)
			{
				out.println("<table width='70%' cellspacing='7' cellpadding='7'>");
			}
			if(a==0 || a== 5 || a== 10 || a== 15 || a==20)
			{
				out.println("<tr>");
			}	
			out.println("<td id='image"+styleSheetId+"' name='image' class='"+className+"'>"+themesDisplay+"</td>");
			
			if(a==4 || a== 9 || a==14 || a==19)
			{
				out.println("</tr>");
			}		
			//if(a==17)	//IN038959
			if(a==18)	//IN038959
				out.println("</table>");
			//out.println("<table width='100%'><tr><td class='COLUMNHEADERCENTERNEW"+styleSheetId+"'>"+themesDisplay+"</td></tr></table>");
			className="";
			a++;
	}
            _bw.write(_wl_block17Bytes, _wl_block17);

		
		
}catch(Exception e){
	out.println("Error while getting the display Table--Exception in ChartSummaryPersonalisedThemes.jsp: ");
	e.printStackTrace();
}
finally{
	try{
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
		out.println("Exception in ChartSummaryPersonalThemes.jsp: ");
		e.printStackTrace();
	}
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(contentID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
