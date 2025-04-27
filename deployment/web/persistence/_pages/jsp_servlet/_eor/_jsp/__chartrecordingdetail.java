package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ChartRecordingDetail.jsp", 1709119652000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script>\n\t\tfunction getMessageFrame()\n\t\t{\n\t\t\tif(top.content!=null){\n\t\t\t\treturn top.content.messageFrame;\n\t\t\t}else{\n\t\t\t\treturn parent.parent.messageFrame;\n\t\t\t}\n\t\t}\n\t\tvar messageFrameReference = getMessageFrame();\n\t\tfunction removeObjectsFromSession(){\n\t\t//\tmessageFrameReference.location.href=\"../../eCA/jsp/ChartRecordingRemoveObjects.jsp\";\n\t\t}\n\t</script>\n\t<style>\n\tTH {\n        FONT-FAMILY: VERDANA ;\n\t\t\tFONT-SIZE: 7PT ;\n\t\t   \tCOLOR:WHITE;\n\t\t\tBACKGROUND-COLOR: #808080 ;\n\n   }\nA:active{\n\t\tcolor:white;\n\t}\n\tA:visited{\n\t\tcolor:white;\n\t}\n\tA:link {\n\t\tCOLOR:white;\n\t}\n\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollTitle()\' onunload=\"removeObjectsFromSession()\">\t\n\t<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<form name =\"ChartLayoutDetailForm\" action=\"../../servlet/eCA.ChartRecordingServlet\" method=post target=\"messageFrame\" >\n\n\t<table cellspacing=0 cellpadding=3 width=\'100%\' border=\"1\" id=\'titleTable\'>\n\t   <tr  id=\'divTitleTable\' border=\'0\'  height=\'0%\'>\n\t\t<td class=\'columnheader\'  height=\'0%\' border=\'0\' colspan=\'4\'></th>\n\t</tr>   \n\t<tr border=\'0\' id=\'divTitleTable1\'>\n\t\t<td class=\'columnHeadercenter\' border=\'0\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td class=\'columnHeadercenter\'   border=\'0\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<td class=\'columnHeadercenter\'  border=\'0\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td class=\'columnHeadercenter\'  border=\'0\'><a href=\"javascript:;\" onClick=\'openWinForGrouping()\'><img src=\'../../eCA/images/graph.gif\' border=\'0\'></img></a></td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</tr>\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tparent.ChartRecordingDetailFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\tparent.ChartRecordingToolBarFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t</table>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<input type=hidden name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=hidden name=\"sysTime\" id=\"sysTime\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=hidden name=\"sysdate\" id=\"sysdate\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=hidden name=\"highStr\" id=\"highStr\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=hidden name=\"lowStr\" id=\"lowStr\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=hidden name=\"cricHighStr\" id=\"cricHighStr\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=hidden name=\"cricLowStr\" id=\"cricLowStr\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=hidden name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=hidden name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=hidden name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=hidden name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=hidden name=\"chart_id\" id=\"chart_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=hidden name=\"Sex\" id=\"Sex\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=hidden name=\"Dob\" id=\"Dob\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=hidden name=\"summaryYN\" id=\"summaryYN\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<input type=hidden name=\"detailYN\" id=\"detailYN\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=hidden name=\"summaryText\" id=\"summaryText\" value=\'\'>\n\t<input type=hidden name=\"locale\" id=\"locale\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=hidden name=\"taskCode\" id=\"taskCode\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=hidden name=\"taskSrlNo\" id=\"taskSrlNo\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=hidden name=\"DEFINE_MODIFIABLE_AT_TRN_YN\" id=\"DEFINE_MODIFIABLE_AT_TRN_YN\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=hidden name=\"rec_time\" id=\"rec_time\" value=\"\">\n\t<input type=hidden name=\"selected_events_no\" id=\"selected_events_no\" value=\"\">\n\t<input type=hidden name=\"selected_events_desc\" id=\"selected_events_desc\" value=\"\">\n\t<input type=hidden name=\"selected_events_uom\" id=\"selected_events_uom\" value=\"\">\n\t<input type=hidden name=\"no_of_selections\" id=\"no_of_selections\" value=\"\">\n\t<input type=hidden name=\"dummyVariable\" id=\"dummyVariable\" value=\"\">\n\t<input type=hidden name=\"selected_growth_event\" id=\"selected_growth_event\" value=\"\">\n\t<input type=hidden name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=hidden name=\"detDate\" id=\"detDate\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=hidden name=\"qs\" id=\"qs\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=hidden name=\"noOfChkdBoxes\" id=\"noOfChkdBoxes\" value=\'0\'>\n\t<input type=hidden name=\"grpCount\" id=\"grpCount\" value=\'1\'> \n\t<input type=hidden name=\"grpDetails\" id=\"grpDetails\" value=\'\'>\n\t<input type=hidden name=\"sentFromGraph\" id=\"sentFromGraph\" value=\'\'>\n\t<input type=hidden name=\"flagGraph\" id=\"flagGraph\" value=\'N\'>\n\t<input type=hidden name=\"errorAuth\" id=\"errorAuth\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\n\t<input type=hidden name=\"splChartType\" id=\"splChartType\" value=\'\'>\n\t<input type=hidden name=\"Sex\" id=\"Sex\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=hidden name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<input type=hidden name=\"noOfGroups\" id=\"noOfGroups\" value=\'\'>\n\t<input type=hidden name=\'contr_mod_accession_num\' id=\'contr_mod_accession_num\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=hidden name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=hidden name=\"modifyYN\" id=\"modifyYN\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\n\t</form>\n</body>\n<script>alignUnitsAndDataforDetail();</script>\n<script>\n\t if(parent.ChartRecordingCriteriaFrame != null)\n\t {\n\t\t if(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' == \'Y\')\n\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value=document.forms[0].sysTime.value;\n\t\tdocument.ChartLayoutDetailForm.splChartType.value = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.splChartType.value\n\t }\n\n</script>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<script>\n\t\tvar qs = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&modifyYN=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\tparent.ChartRecordingListFrame.location.href = \'../../eCA/jsp/ChartRecordingListPopulation.jsp?\'+qs;\n\t</script>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>\n\t\t\tdisplayListForAE();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</html>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

private String checkForNull(String strParam)
{
		String str ="";
		if(strParam!=null && strParam.length() >0)
		str = strParam;
		return str;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCA.GenerateChartLayoutBean generateChart= null;{
                generateChart=(eCA.GenerateChartLayoutBean)pageContext.getAttribute("generateChart");
                if(generateChart==null){
                    generateChart=new eCA.GenerateChartLayoutBean();
                    pageContext.setAttribute("generateChart",generateChart);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");
		String module_id = request.getParameter("module_id") == null ? "" :  request.getParameter("module_id");
		String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");
		//modifyYN="N";

		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

		String errorAuth = request.getParameter("errorAuth") == null ? "" :  request.getParameter("errorAuth");
		String Sex = request.getParameter("Sex") == null ? "" :  request.getParameter("Sex");
		String facility_id = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");

		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;

		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		if(encounter_id.equals("")) encounter_id = "0";

		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" : request.getParameter("contr_mod_accession_num");
		
		String highStr = "",lowStr="",abnStr="",cricStr="",cricHighStr="",cricLowStr="";
		String sysTime = "";
		String count = "";

		abnStr=abnStr;
		cricStr=cricStr;
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(modifyYN.equals("Y"))
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		generateChart.setChartId("");
		StringBuffer displayString = generateChart.getChartLayout(request,locale);
		count = generateChart.getIndex();
		
		if(!(displayString.toString()).equals("")){
			out.println(displayString.toString());
			
		}else
		{
			//out.println("<script>parent.ChartRecordingToolBarFrame.document.F.record.disabled = true;</script>");
	
            _bw.write(_wl_block14Bytes, _wl_block14);
		
		}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
	
	{
        if(function_from.equals("") || (function_from.equals("CP") && module_id.equals("OR")))
        {
			try
			{
				sysTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			}
			catch(Exception e)
			{
				out.println("Exception in ChartRecordingDetail.jsp --- "+e.toString());
			}
        }
		else if(function_from.equals("SECONDARY_TRIAGE"))
		{
            sysTime = checkForNull(request.getParameter("defaultDate"));
			//sysTime = com.ehis.util.DateUtils.convertDate(sysTime,"DMYHM","en",locale);
			
		}
        else
        {
            sysTime = checkForNull(request.getParameter("p_start_date_time"));
			
			if (sysTime.equals(""))
			{
					sysTime	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			}
			/*else 
			{
				sysTime = com.ehis.util.DateUtils.convertDate(sysTime,"DMYHM","en",locale);
			} */
        }

	    try
        {
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");		
        rs = pstmt.executeQuery();
        while(rs.next())
        {
            highStr =checkForNull( rs.getString("HIGH_STR"));

            lowStr =checkForNull( rs.getString("LOW_STR"));

            cricHighStr =checkForNull( rs.getString("CRIT_HIGH_STR"));

            cricLowStr =checkForNull( rs.getString("CRIT_LOW_STR"));
        }
        if(rs != null)rs.close();
        if(pstmt != null)pstmt.close();
        }
        catch(Exception ee)
        {
			out.println("Exception in ChartRecordingDetail.jsp"+ee.toString());
			ee.printStackTrace(System.err);
        }


		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
	}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sysTime));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getParameter("sysdate")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(highStr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(lowStr));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cricHighStr));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cricLowStr));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getParameter("episode_id")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getParameter("patient_class")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getParameter("chartId")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getParameter("Sex")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getParameter("Dob")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(request.getParameter("summaryYN")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request.getParameter("detailYN")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getParameter("taskCode")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getParameter("task_srl_no")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sysTime));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block46Bytes, _wl_block46);

if(!function_from.equals("SECONDARY_TRIAGE"))
{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block49Bytes, _wl_block49);

}
else
{
	
            _bw.write(_wl_block50Bytes, _wl_block50);

}

            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
}
