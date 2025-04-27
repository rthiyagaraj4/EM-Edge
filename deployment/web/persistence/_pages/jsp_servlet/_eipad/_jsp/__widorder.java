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

public final class __widorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/widOrder.jsp", 1709118034958L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title></title> \n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadwidget.css\" />\n\n<script>\n\nfunction ShowCount()\n{\n\twindow.parent.showPCFCount(document.getElementById(\"hdnRowCount\").value) ;\n}\nfunction expandpatientcareflowsheet()\n{\n\t if(window.parent != null)\n\t {\n\t\t window.parent.expandpatientcareflowsheet();\n\t }\n}\n$(document).ready(function() {\n\t\n\t\n\t$(\"#tbPage1\").bind(\"swipeleft\", function() {\n\t\tif(window.parent != null)\n\t\t\twindow.parent.widgetsummaryswipeps();\n\t});\n\n\n});\n</script>\n<style>\n.tbWidgetContent\n{\n\theight : 100%;\n\twidth : 100%;\n\tborder : 0px;\n\t\n}\n.trWidgetSummary\n{\n\theight : 38px;\n\t background : #48cbcb;\n\t\n}\n</style>\n</head> \n<body onload = \"ShowCount()\"> \n<section id=\"pageWidgetContent\" data-role=\"page\" style =\"background-color:white\"> \n<form>\n<table class = \"tbWidgetContent\" cellpadding = \"0\" cellspacing = \"0\" onclick = \"expandpatientcareflowsheet()\" id = \"tbPage1\">\n\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t       <tr class=\"trWidgetRows";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t\t\t          <td style = \"width:7%\" align=\"center\" valign = \"center\"><img src=\"../images/Bullet Arrow.png\" ></img></td>\n\t\t\t       <td style =\"width:93%\"  align =\"left\" valign = \"middle\"> <span class = \"spanWidRows\" >";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" - ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" </span>\n\t\t\t         ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t            &nbsp;<img src = \"../images/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"> </img>\n\t\t\t         ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t               &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t          \n\t\t\t         ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t        \t        &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\"  style = \"margin-top : 7px\"> </img>\n\t\t\t        \t        \n\t\t\t           ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t        \t  &nbsp;&nbsp;<img src = \"../images/NI_Normal.png\" style = \"margin-top : 7px\"> </img>\n\t\t\t        \t  \n\t\t\t      ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t         \n\t\t\t            ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t\t\t        \t &nbsp;&nbsp;<span class = \"spanWidRowsBold\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t       </td>\n\t\t\t      </tr>\n\t\t\t      \n\t\t\t      \n\t\t\t      \n\t\t\t      \n\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t     ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n \n\t \t    \t      \n\t\t\t    </table>\n\t\t<input type = \"hidden\" name = \"hdnRowCount\" id = \"hdnRowCount\"\tvalue = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\t \t   \n\t</form>\t\t    \n </section>\n  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

String descCellInd = "";
String resultNum = "";
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
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


eIPAD.PatientCFSDetails bean = new eIPAD.PatientCFSDetails();
List<PatientCFS> objPatientCFSDetails = new ArrayList<PatientCFS>(); 
int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
int nCssCount = 1;  // To display alternate Row Color.
int nDummyRowcount = 1;
int nListSize = 0;

int nLoopCount = 0;
PatientCFS oPatientCFS = null;
try {
objPatientCFSDetails = bean.getPatientCFS(oPatientContext);
nListSize =  objPatientCFSDetails.size();

if(nListSize > 0)
{

	 for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
	 {
		 oPatientCFS = objPatientCFSDetails.get(nLoopCount);
		  if(oPatientCFS != null && nRowCount < 7)
		  {
			  if( nRowCount == 1)
			  {
					strRowCount = oPatientCFS.getsCount();
			  }
			  if(nRowCount == 7)
			  {
				  break;
			  } 
	   
	     color_cell_indicator = oPatientCFS.getsNormalRangeSymbol();
	     descCellInd = oPatientCFS.getsDescCellIndicator();
	  
	   
	    normalLow = oPatientCFS.getsNormalLow();//rs.getString("NORMAL_LOW") == null ? "" : rs.getString("NORMAL_LOW");
		normalHigh = oPatientCFS.getsNormalHigh();//rs.getString("NORMAL_HIGH") == null ? "" : rs.getString("NORMAL_HIGH");
		resultNum = oPatientCFS.getsResultNum();//rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
 
  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oPatientCFS.getsDesc()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oPatientCFS.getsCareFlowDetail()));
            _bw.write(_wl_block5Bytes, _wl_block5);

			         if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
			         {
			         
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(color_cell_indicator));
            _bw.write(_wl_block7Bytes, _wl_block7);

			         }
			         else
			         {//1
			        	 if(!normalLow.equals("") && !normalHigh.equals(""))
			        	 {//2
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//3
			        			 if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)))
			        			 {//4
			         
            _bw.write(_wl_block8Bytes, _wl_block8);

			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//33
			        			 if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//333
			        			 if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
			        			 {//444
			        	  
            _bw.write(_wl_block10Bytes, _wl_block10);
 
			        			 }//e444
			        		 }//e333
			        	 }//e222
			       }//end 1
			         
            _bw.write(_wl_block11Bytes, _wl_block11);
 
			         if(!descCellInd.equals(""))
				{
			        	 
				
			        	 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oPatientCFS.getsDescCellIndicator()));
            _bw.write(_wl_block13Bytes, _wl_block13);

			         }
			         
            _bw.write(_wl_block14Bytes, _wl_block14);

		  }//if oPatientCFS != null
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
}//if nlistsize
else
{
	  
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( IPADConstants.NORECORDS_FOR_WIDGETS));
            _bw.write(_wl_block16Bytes, _wl_block16);
 
}

  

  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strRowCount ));
            _bw.write(_wl_block18Bytes, _wl_block18);

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
