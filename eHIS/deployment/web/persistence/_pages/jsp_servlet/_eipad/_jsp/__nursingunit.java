package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.List;
import java.sql.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eIPAD.sfs.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __nursingunit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/NursingUnit.jsp", 1709118028896L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>Nursing Unit</title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n<style>\n  .bgClr{   \n              height : 30px;\n         \n      \n        background :   -moz-linear-gradient( #015555 , #2496ac ); \n        background :  -webkit-gradient(linear, left top, left bottom, from( #015555 ), to( \n\n#2496ac )); /* Saf4+, Chrome */\n        background : -webkit-linear-gradient( #015555 , #2496ac ); /* Chrome 10+, Saf5.1+ \n\n*/\n        border:1px solid red;\n        border-radius:5px;\n        -moz-border-radius:5px;\n       font-family: Gotham-Bold;\n\tfont-size: 12pt;\n       /* margin-left : 25px;*/\n  }\n  .tbIpContent2 tr:active{    \n   background-color:#a2d7d7; \n   } \n  \n</style>\n<script type=\"text/javascript\">\n/*\n $(document).bind(\"swipe\", function(event, data){\n\t//alert(\"helloo\")\n\tevent.preventDefault();\t\n });\n */\nfunction openPatient()\n {\n\t// alert(\"hi\");\n\t// window.parent.location =\"Appointment.html\";\n\t// $(\'#page12\').html(\"Loading.....\")\n\t // window.parent.slidee(\"true\");\n\t // window.location =\"Appointment.html\";\n\t //window.parent.location =\"Appointment.html\";\n\t\n\t//window.open(\"Appointment.html\");\n }\n function showCriteria()\n {\n\t// $(\'#divSrchCriteria\').slideToggle(\'fast\');\n\t//alert(\"searchcc\");\n\t// window.parent.test();\n\t// $(\"#page12\").dialog(\"close\");\n \n }\n function closeSrch(strCode,strDesc,objTr)\n {\n\t// alert(\"hi\");\n\tobjTr.style.border = \"3px solid #48d1d8\";\n\t window.parent.CloseSearchCriteria();\n }\n function srchclose(strCode,strDesc,objTr)\n {\n\t// alert(\"hii\");\n\t// $(this).css(\'background\' , \'#a2d7d7\');\n\t//alert($(this));\n\t//$(this).removeClass(\"trSrchRow2\");\n\t//$(this).addClass(\"trIpRowsTouch\");\n\t// alert($(this));\n\t// window.parent.test(strCode,strDesc);\n\t//alert(objTr);\n\t//alert(objTr.style.background-color);\n\t//objTr.style.border = \"3px solid\";\n\tobjTr.style.backgroundColor = \"#a2d7d7\";\n\t//var d = document.getElementById(\"tbSrchcontrol\");\n\twindow.parent.test(strCode,strDesc);\n\t//alert(objTr);\n }\n function dummyFn()\n {\n\t \n }\n function changerowColor(objTr)\n {\n\t// alert(\"hj\");\n\n\t objTr.style.backgroundColor = \"#a2d7d7\";\n }\n function move(e)\n {\n\t e.preventDefault(); \n }\n function show(objTr)\n {\n\t objTr.style.border = \"3px solid #48d1d8\";\n\t// alert(objTr.style.backgroundColor);\n\t//alert( $(this));\n\t// $(this).removeClass(\'btnType1\');               \n\t// $(this).addClass(\'bgClr\');\n     document.getElementById(\"hdnIsPostBack\").value = \"true\";\n\tdocument.getElementById(\"frmNursingUnit\").submit();\n }\n\t \n function LoadDefaultValues()\n {\n\t document.getElementById(\"txtSrchCriteria\").value =  document.getElementById(\"hdnSearchText\").value;\n\t document.getElementById(\"cmbCriteria\").value =  document.getElementById(\"hdnSearchcriteria\").value;\n\t if(document.getElementById(\"hdnRdCode\").value == \"true\")\n     {\n\t\t document.getElementById(\"rdCode\").checked = true;\n\t }\n\t else\n\t{\n\t\t document.getElementById(\"rdDesc\").checked = true;\n\t}\n\t \n }\n </script>\n   \n<body onload = \"LoadDefaultValues()\">\n  \n    <section id=\"specialityPage\" data-role=\"page\"  style=\"padding:0px\">  \n    <form id = \"frmNursingUnit\" method = \"post\" name = \"frmNursingUnit\" >\n     \n  <div id = \"divSrch\"  data-role =\"none\" class=\"dvApp\" >\n    <span class = \"spanDvsrch\">Nursing Unit</span> \n  \n  </div>\n  \n  \n  <div id=\"divspeciality\"   style = \"display:block;height:auto\" class = \"dvCriteria\">\n  <table style=\"height:75px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\" id = \"tbSrchcontrol\" >\n\n     <tr style=\"height:30px\">\n      <td align = \"left\" style=\"width:34%\"><span class = \"spSrchCriteria\">Search By</span></td>\n      <td align = \"left\" style=\"width:32%\"><span class = \"spSrchCriteria\">Search Criteria</span></td>\n      <td align = \"left\" style=\"width:32%\"><span class = \"spSrchCriteria\">Search Text</span></td>\n        <td align = \"left\" style=\"width:2%\"></td>\n \n     </tr>\n     \n     <tr style=\"height:35px\">\n      <td align = \"left\" style=\"width:34%\" valign = \"center\" nowrap = \"false\">\n       <table style=\"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n         <tr style=\"width:100%;height:100%\">\n\t         <td style=\"width :25%\" align = \"center\">\n\t\t     \t <input type = \"radio\" name=\"group1\" id=\"group1\"  id=\"rdCode\" data-role = \"none\" class = \"radioGroup\" value = \"code\" />\n\t\t     </td> \n\t\t     <td style=\"width :20%\">\n\t\t     \t <span class = \"spRadio\">Code</span>\n\t\t      </td>\n\t\t      <td style=\"width :25%\" align = \"center\">\n\t\t     \t <input type = \"radio\" name=\"group1\" id=\"group1\"  data-role = \"none\" class = \"radioGroup\" value = \"desc\" id = \"rdDesc\"/>\n\t\t      </td>\n\t\t      <td style=\"width :20%\">\n\t\t     \t <span class = \"spRadio\">Description</span>\n\t\t      </td>\n\t\t      <td style=\"width :10%\">\n\t\t     \t &nbsp;\n\t\t      </td>\n\t\t       \n\t     </tr> \n\t    </table>  \n      </td>\n      <td align = \"left\" style=\"width:32%\">\n        <select  class=\"cmbSrchCriteria\" data-role=\"none\" id=\"cmbCriteria\" name = \"cmbCriteria\"> \n            \n\t\t\t<option value = \"SW\">Starts With</option> \n\t\t\t<option value = \"CN\">Contains</option> \n\t\t\t<option value = \"EW\">Ends With</option> \n\t\t\t\n\n\t\t</select> \n      </td>\n      <td align = \"left\" style=\"width:32%\"><input type = textbox data-role = \"none\" class = \"tbPatCriteria\" name = \"txtSrchCriteria\" id = \"txtSrchCriteria\"/></td>\n     <td align = \"left\" style=\"width:2%\"></td>\n     </tr>\n     <tr style = \"height:10px;width:100%\">\n       <td >&nbsp;</td>\n     <tr>\n\n     \n   </table>\n   <div id = \"divSrchPanel\" style=\"height:auto\" class = \"dvSrchPanel\">\n\t\t\t      <table style=\"height:44px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t        <tr style=\"width:100%\">\n\t\t\t          <td style=\"width:75%\">&nbsp;</td>\n\t\t\t          <td style= \"width:25%\" nowrap = \"false\"> \n\t\t\t            <table style=\"width:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t             <tr style=\"width:100%\">\n\t\t\t             <td align = \"right\" valign =\"center\" >\n\t\t\t               <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Search\' class=\"btnType1\"  data-role = \"none\" onclick = \"show(this)\"/>\n\t\t\t             </td>\n\t\t\t             <td style=\"width:7%\"></td> \n\t\t\t             <td> \n\t\t\t               <input type =\"button\" name=\'clear_btn\' id=\'clear_btn\' value=\'Close\' class=\"btnType1\"  data-role = \"none\" onclick = \"closeSrch(\'\',\'\',this)\"/>\n\t\t\t             </td>  \n\t\t\t             </tr>\n\t\t\t            </table>\n\t\t\t          </td>\n\t\t\t       <!--   <td style=\"width:2%\">&nbsp;</td> --> \n\t\t\t        </tr>\n\t\t\t      </table>\n\t     </div>\n   \n   </div>\n   \n   \n   \t      \n   \n \n   <div id = \'divSrchcContent\'   class = \'dvSrchcontent\' >\n     <div  data-role =\"none\" class =\"dvApp\">\n\t  \n\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:30%\">\n\t\t\t    <td style = \"width:30%\" align =\"left\" >\n\t\t\t         <span class = \"spanDvsrch\">Code</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:70%\" align = \"left\" valign = \"center\">\n\t\t\t     \n\t\t\t     <span class = \"spanDvsrch\">Description</span>   \n\t\t\t    </td>\n\t\t\t    \n\t\t\t    \n\t\t\t  </tr>\n\t\t    </table>\t  \n\t  </div>\n   ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n     <table class = \"tbIpContent2\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\">\n      <tr class = \"trSrchRow";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"  onclick = \"srchclose(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\',\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',this)\">\n        <td style=\"width:30%\" align = \"left\" valign = \"center\">\n          <span class = \"srchLabel\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n        </td>\n        <td style=\"width:70%\" align = \"left\" valign = \"center\">\n            <span class = \"srchLabel\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n        </td>\n        \n      </tr>\n     </table>\n      ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n     \n  \n    </div>\n   <input type = \"hidden\" name = \"hdnIsPostBack\" id = \"hdnIsPostBack\" value = \"false\" />\n   <input type = \"hidden\" name = \"hdnSearchText\" id = \"hdnSearchText\"  value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n   <input type = \"hidden\" name = \"hdnSearchcriteria\" id = \"hdnSearchcriteria\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" />\n   <input type = \"hidden\" name = \"hdnRdCode\" id = \"hdnRdCode\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" />\n   <input type = \"hidden\" name = \"hdnRdDesc\" id = \"hdnRdDesc\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" />\n</form>\n </section>  \n       \n     \n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</body>  \n    \n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

request.setCharacterEncoding("UTF-8");

Boolean bRadioCode = true;
Boolean bRadioDesc = false;
String strPostBack = "";
String sfacility_id = "";
String sclinicianId = "";
String sPracId = "";
String sPractionerId = "";
String sSearchBy = "" ;
String sSearchCriteria = "" ;
String sSearchText = "";
String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";

SFSContext oSFSContext = new SFSContext();
oSFSContext.setRequest(request);



if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
{
	sfacility_id = (String)session.getValue("facility_id");
	oSFSContext.setSfacility_id(sfacility_id);
}

if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
{
	sclinicianId = (String)session.getValue("ca_practitioner_id");
	//oSFSContext.setSclinicianId(sclinicianId);
}
if(request.getParameter("sPractionerId") != null && request.getParameter("sPractionerId") != "")
{
	sPractionerId = (String)request.getParameter("sPractionerId");
	oSFSContext.setsPractionerId(sPractionerId);
}

if( sPractionerId!= null && !sPractionerId.equals("")  )
{
	sclinicianId = sPractionerId;
}
oSFSContext.setSclinicianId(sclinicianId);
strPostBack = request.getParameter("hdnIsPostBack");

if(request.getParameter("group1") != null && request.getParameter("group1") != "" )
{
	
	sSearchBy = (String)request.getParameter("group1");
	oSFSContext.setsSearchBy(sSearchBy);
	
	if(sSearchBy != null && sSearchBy.equals("desc")){
		bRadioDesc = true;
		bRadioCode = false;
	}
	
	
}
if(request.getParameter("cmbCriteria") != null && request.getParameter("cmbCriteria") != "" )
{
	sSearchCriteria = (String)request.getParameter("cmbCriteria");
	oSFSContext.setsSearchCriteria(sSearchCriteria);
}	
if(request.getParameter("txtSrchCriteria") != null && request.getParameter("txtSrchCriteria") != "" )
{
	sSearchText = (String)request.getParameter("txtSrchCriteria");
	oSFSContext.setsSearchText(sSearchText);
	}




            _bw.write(_wl_block1Bytes, _wl_block1);

   int nRowCount = 1;		       			    
   int nCssCount = 1;  // To display alternate Row Color.
   int nDummyRowcount = 1;
   int nLoopCount = 0;
   int nListSize = 0;
   SFSDetails bean = new SFSDetails();
   List<SFSUnit> objNursingUnitDetails = new ArrayList<SFSUnit>(); 
  
   try {
	   if(strPostBack != null && strPostBack.equals("true"))
	   {
		   oSFSContext.setType(SFSContext.NURSINGUNIT);
   objNursingUnitDetails = bean.getSFSUnit(oSFSContext); 
	   }
  
   nListSize =  objNursingUnitDetails.size();
   //out.println(nListSize);
   SFSUnit oNursingUnit = null;
   if(nListSize > 0)
   {
 	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount++)
 	  {
 		 oNursingUnit = objNursingUnitDetails.get(nLoopCount);
 		  if(oNursingUnit != null )
		  {
			
		  
	 
	  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oNursingUnit.getsCode()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oNursingUnit.getsDescription()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oNursingUnit.getsCode()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oNursingUnit.getsDescription()));
            _bw.write(_wl_block7Bytes, _wl_block7);

 		 
		  }
		  nRowCount = nRowCount + 1;
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
   else
   {
	   if(strPostBack != null && strPostBack.equals("true"))
	   {
	  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block9Bytes, _wl_block9);

	   }
   }
	  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sSearchText ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sSearchCriteria ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bRadioCode ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bRadioDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);

}catch ( Exception e ){
	//out.println(sqlStr.toString() + e);
	e.printStackTrace();
}
finally{

}
   
		

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
