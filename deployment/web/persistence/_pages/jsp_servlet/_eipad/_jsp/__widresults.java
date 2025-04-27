package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __widresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/widResults.jsp", 1709118035083L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>jQuery Mobile Application</title> \n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n<link rel=\"stylesheet\" href=\"../css/iPadwidget.css\" />\n\n<script>\n\nfunction ShowCount()\n{\n\t//var dt = new Date();\n\t//alert(dt.getTime());\n\twindow.parent.showResultsCount(document.getElementById(\"hdnRowCount\").value) ;\n}\nfunction expandResults()\n{\n\t if(window.parent != null)\n\t {\n\t\t window.parent.expandResults();\n\t }\n}\n$(document).ready(function() {\n\t\n\t\n\t$(\"#tbPage1\").bind(\"swipeleft\", function() {\n\t\tif(window.parent != null)\n\t\t\twindow.parent.widgetsummaryswipeps();\n\t});\n\n\n});\n</script>\n<style>\n.tbWidgetContent\n{\n\theight : 100%;\n\twidth : 100%;\n\tborder : 0px;\n\t\n}\n\n</style>\n</head> \n<body onload = \"ShowCount()\" > \n<section id=\"pageWidgetContent\" data-role=\"page\" style =\"background-color:#ffffff\"> \n<form>\n<table class = \"tbWidgetContent\" cellpadding = \"0\" cellspacing = \"0\" onclick = \"expandResults()\" id = \"tbPage1\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t       <tr class=\"trWidgetRows";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t\t\t          <td style = \"width:7%\" align=\"center\" valign = \"center\"><img src=\"../images/Bullet Arrow.png\"></img></td>\n\t\t\t          <td style =\"width:93%\"  align =\"left\"> <div class = \"spanWidRows\" >";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" &nbsp; (";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =")</div></td>\n\t\t\t      </tr>\t      \n\t\t\t      \n\t\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t     ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n     \n\t\t\t      \n\t\t\t      \n\t\t\t      \n\t\t\t      \n\t\t\t    \n\t\t\t      \n\t\t\t    </table>\n\t\t\t<input type = \"hidden\" name = \"hdnRowCount\" id = \"hdnRowCount\"\tvalue = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />   \n\t</form>\t\t    \n </section>\n  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
objResultDetails = bean.getResults(oPatientContext);
nListSize =  objResultDetails.size();
if(nListSize > 0)
{
	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
	  {
		  oResults = objResultDetails.get(nLoopCount);
		  if(oResults != null && nRowCount < 7)
		  {
			  if( nRowCount == 1)
				{
					strRowCount = oResults.sCount;
				}
			  if(nRowCount == 7)
			  {
				  break;
			  } 
 
  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oResults.sResultDesc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oResults.sResultscount));
            _bw.write(_wl_block5Bytes, _wl_block5);

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
	  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( IPADConstants.NORECORDS_FOR_WIDGETS));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
}

  

  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strRowCount ));
            _bw.write(_wl_block9Bytes, _wl_block9);

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
