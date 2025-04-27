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
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;

public final class __schedulefrequencycombofill extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ScheduleFrequencyComboFill.jsp", 1709113920974L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script>alert(\"Exception thrown ...Chk in ScehduleferquencyComboFill.jsp\" + \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\");</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            eAM.ScheduleFrequency scheduleFrequencyTemp= null;{
                scheduleFrequencyTemp=(eAM.ScheduleFrequency)pageContext.getAttribute("scheduleFrequencyTemp");
                if(scheduleFrequencyTemp==null){
                    scheduleFrequencyTemp=new eAM.ScheduleFrequency();
                    pageContext.setAttribute("scheduleFrequencyTemp",scheduleFrequencyTemp);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);


	request.setCharacterEncoding("UTF-8");	
	HttpSession ss = request.getSession(false);
	scheduleFrequencyTemp.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
	ArrayList  freqValues = null ;

	try{
		 freqValues = scheduleFrequencyTemp.getFreqValues(request);
		}catch(Exception e){
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(e.getMessage()));
            _bw.write(_wl_block8Bytes, _wl_block8);
}

	String  freqLegend_P		 ="";
	String  durationType_P		 ="";
	String  repeatValue_P	     ="";
	String  start_time_round_p	 ="";
	String  start_time_assign_p  ="";
	String daysHtml = "";

	//Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	String max_no_of_cycle_p	 =""; 
	String monthdaysHtml				 ="";
	if(freqValues.size() != 0){
	  freqLegend_P		 = (String)freqValues.get(2); // FREQUENCY_LEGEND
	  durationType_P		 = (String)freqValues.get(1); // INTERVAL_DURN_TYPE
	  repeatValue_P	     = (String)freqValues.get(0); // REPEAT_VALUE
	  start_time_round_p	 = (String)freqValues.get(3); // START_TIME_ROUND
	  start_time_assign_p  = (String)freqValues.get(4); // START_TIME_ASSIGN
	  max_no_of_cycle_p	   = (String)freqValues.get(5); //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	}

	 if(durationType_P.equals("W"))
			{
						for(int j=1; j<=7;j++)
						{
							daysHtml =daysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
						}
			}
		else if(durationType_P.equals("L"))
			{
				for(int j=1; j<=30;j++)
				{
						daysHtml =daysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
				}
			}
		for(int j=1; j<=31;j++)
		{
				monthdaysHtml =monthdaysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
		}
		
	out.println("<script>parent.assignFrqeuncyGlobal(\"" + durationType_P + "\",\"" + repeatValue_P + "\",\""+freqLegend_P +  "\",\"" + start_time_round_p + "\",\"" + start_time_assign_p + "\",\"" + daysHtml + "\",\"" + max_no_of_cycle_p + "\",\"" + monthdaysHtml + "\" ) ;</script>");
	freqValues.clear();
		
	
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
