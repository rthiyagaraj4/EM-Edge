package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eAM.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;

public final class __schedulefrequencyaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ScheduleFrequencyAddModify.jsp", 1715054635960L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eAM/js/ScheduleFrquency.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n<body onLoad=\'delValue();\' onKeyDown = \'lockKey()\' OnMouseDown=\"CodeArrest();\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\"scheduleFreqencyAddMod\" id=\"scheduleFreqencyAddMod\" action=\"../../servlet/eAM.ScheduleFrequencyServlet\" method=\"post\" target=\"messageFrame\">\n\n<table border=\"0\" id=\"headerTab\" cellpadding=0 cellspacing=0 width=\"95%\" align=\"center\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t<tr>\n\t\n\t\t\t<td colspan=\"3\">&nbsp;</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"20%\" class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<td class=\"fields\" width=\"40%\" >\n\t\t\t\t\t\t<select name=\"freq_code\" id=\"freq_code\"  onChange=\"return parent.fillLegend(this)\">\n\t\t\t\t\t\t\t<option>------------------------------";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="-----------------------</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"label\" width=\"50%\" id=\"freqLegend\">&nbsp;</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<td class=\"fields\" width=\"40%\" >\n\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"freq_code_desc\" id=\"freq_code_desc\" readOnly value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=\'75%\'>&nbsp;\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\n\t\t\t\t\t\t<input type=\"hidden\" name=\"freq_code\" id=\"freq_code\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\n\t\t\t\t\t<td class=\"label\" width=\"50%\" id=\"freqLegend\">&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</tr>\n \n\t\t<tr>\n\t\t\t<td colspan=\"3\">&nbsp;</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</td>\n\t\t\t<td class=\"fields\" colspan=\"2\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<select name=\"admin_facility_id\" id=\"admin_facility_id\" >\n\t\t\t\t\t\t<option value=\'\'>------------------------------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="-----------------------</option>\n\t\t\t\t\t\t<option value=\'*A\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<INPUT TYPE=\"text\" name=\"admin_facility_desc\" id=\"admin_facility_desc\" readOnly value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" size=\"70\">\n\t\t\t\t\t<input type=\"hidden\" name=\"admin_facility_id\" id=\"admin_facility_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</td>\n\t\t</tr>\t\n\n\t\t<tr>\n\t\t\t<td colspan=\"3\" class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t</table>\n\n\n\n\t<table border=\"0\" id=\"timeTab\" cellpadding=0 cellspacing=0 width=\"95%\" align=\"center\" style=\"top-margin:0\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<tr><td id=\"timeLegend\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<tr><td id=\"timeLegend\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td></tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t</table>\n\n\n<input type=\"hidden\" name=\"chkvaltemp\" id=\"chkvaltemp\" value=\"\">\n\t\n<input type=\"hidden\" name=\"chkvaltemp1\" id=\"chkvaltemp1\" value=\"\">\n<input type=\"hidden\" name=\"chkval\" id=\"chkval\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"daysHtml\" id=\"daysHtml\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"repeat\" id=\"repeat\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"durationType\" id=\"durationType\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<!-- Added by Sangeetha on 6th Jul 2017 for ML-MMOH-CRF-0345.2 -->\n<input type=\"hidden\" name=\"monthdaysHtml\" id=\"monthdaysHtml\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"> \n<input type=\"hidden\" name=\"max_no_of_cycle\" id=\"max_no_of_cycle\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\n<input type=\"hidden\" name=\"start_time_round_p\" id=\"start_time_round_p\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"start_time_assign_p\" id=\"start_time_assign_p\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</form>\n</body>\n</html>\n\t\t\n\t\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

		private String decodeLocal(String objVal)
		{
			if(objVal.trim().equalsIgnoreCase(""))	    return	"";
			else if(objVal.trim().equalsIgnoreCase("N"))		return	"Next";
			else if(objVal.trim().equalsIgnoreCase("C"))     return	"Closest";
			else if(objVal.trim().equalsIgnoreCase("P"))     return	"Previous";
			else if(objVal.trim().equalsIgnoreCase("TM"))    return	"10th minute";
			else if(objVal.trim().equalsIgnoreCase("FM"))    return	"5th minute" ;
			else if(objVal.trim().equalsIgnoreCase("QH"))    return	"Quater Hour";
			else if(objVal.trim().equalsIgnoreCase("H"))     return	"Hourly" ;
			else if(objVal.trim().equalsIgnoreCase("M"))     return	"Minute" ;
			else
				return "";
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            eAM.ScheduleFrequency scheduleFrequency= null;synchronized(session){
                scheduleFrequency=(eAM.ScheduleFrequency)pageContext.getAttribute("scheduleFrequency",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(scheduleFrequency==null){
                    scheduleFrequency=new eAM.ScheduleFrequency();
                    pageContext.setAttribute("scheduleFrequency",scheduleFrequency,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

  request.setCharacterEncoding("UTF-8");	
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  HttpSession ss = request.getSession(false);
  scheduleFrequency.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String mode	   = request.getParameter("mode") ;
	
 	String daysHtml		="";
	
	String freq_code		=request.getParameter("freq_code");
	String freq_desc		=request.getParameter("freq_desc");
	String facility_id		=request.getParameter("facility_id");
	String facility_name	=request.getParameter("facility_name");
	String freqLegend	= "";
	String hrsHtml = "";
	String hrsHtmlInital = "";
	String hrsHtmlFinal = "";
	String  freqLegend_P		 = "";
	String  durationType_P		 = "";
	String  repeatValue_P	     = "";
	String  start_time_round_p	 = "";
	String  start_time_assign_p  = "";
	//Added by Sangeetha on 6th Jul 2017 for ML-MMOH-CRF-0345.2
	String max_no_of_cycle_p	 =""; 
	String monthdaysHtml		 = ""; 
	
	java.sql.Connection connection = null;
	
	scheduleFrequency.clear() ;
	
	if(mode.equals("2"))
		{                    //modify mode

 			 ArrayList  freqValues = null ;
			 freqValues = scheduleFrequency.getFreqValues(request);

			 freqLegend_P			= (String)freqValues.get(2);
			 freqLegend				= freqLegend_P;
			 durationType_P			= (String)freqValues.get(1);
			 repeatValue_P			= (String)freqValues.get(0);
			 start_time_round_p		= (String)freqValues.get(3);
			 start_time_assign_p	= (String)freqValues.get(4); 
			 max_no_of_cycle_p	    = (String)freqValues.get(5); //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2

			 connection				= ConnectionManager.getConnection(request);
			
			ArrayList repeatVals = scheduleFrequency.getRepeatValues(freq_code);

			hrsHtml = scheduleFrequency.formHtmlOptions(freq_code,facility_id,connection,start_time_round_p,start_time_assign_p,max_no_of_cycle_p);

	
			//Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
			if(max_no_of_cycle_p == ""){
			hrsHtmlInital =hrsHtmlInital+"<table border='0' width='100%' ><tr><th  colspan='12'  align='left' width='100%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.TimeRoundedto.label","am_labels")+":"+decodeLocal(start_time_assign_p)+ " "+decodeLocal(start_time_round_p) + "</th>";
			}else{
				hrsHtmlInital =hrsHtmlInital+"<table border='0' width='100%' ><tr><th  colspan='12'  align='left' width='100%'>&nbsp;</th>";
			}
			
			//Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
			if(max_no_of_cycle_p == ""){
			if((repeatVals.get(1)).equals("W") || (repeatVals.get(1)).equals("L"))
			{
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Repeat.label","am_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}
			}else{  //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
				String repeat_val = (String)repeatVals.get(0);
				if((repeatVals.get(1)).equals("D")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
				else if((repeatVals.get(1)).equals("W")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Week.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
				else if((repeatVals.get(1)).equals("L")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
			}
			hrsHtmlFinal = "</table></tr></table>";
			hrsHtml =hrsHtmlInital + hrsHtml + hrsHtmlFinal ;
            hrsHtml= hrsHtml.replaceAll("right", "");			

		}


            _bw.write(_wl_block10Bytes, _wl_block10);

	try 
	{ 
		int ii=1;

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			if (! mode.equals("2") ) //insert mode
				{

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)scheduleFrequency.getComboOptions("frequency")));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
			else
				{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(freqLegend));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			if (!mode.equals("2") ) //insert mode
				{

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)scheduleFrequency.getComboOptions("facility")));
            _bw.write(_wl_block25Bytes, _wl_block25);
				}
			else
			   {

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

				}

            _bw.write(_wl_block29Bytes, _wl_block29);

		if (!mode.equals("2") )  // insert mode
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
	 
			}
		else
			{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(hrsHtml));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(daysHtml));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(repeatValue_P));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(durationType_P));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(monthdaysHtml));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_no_of_cycle_p));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(start_time_round_p));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(start_time_assign_p));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block43Bytes, _wl_block43);

	}catch(Exception e)
	{	
		//out.println("Exception here");
		//out.println("Exception in ScheduleFrequencyAddModify" + e.getMessage());
		e.printStackTrace();
	}
	finally {
				 	 ConnectionManager.returnConnection(connection,request);
			}

            _bw.write(_wl_block44Bytes, _wl_block44);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
