package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __viewchartrecordingtablepopulation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartRecordingTablePopulation.jsp", 1709116432791L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n24/10/2013    IN044496       Chowminya     In critical high value, system should be fill colour indicator of critical high value as per configuration.\t\n28/10/2013    IN044612       Chowminya     (reopen)In critical high value, system should be fill colour indicator of critical high value\n02/06/2014\t  IN037701\t\tChowminya\t\t\tSKR-CRF-0036\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\"javascript\" src=\"../../eCA/js/ViewChartRecording.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<style>\t\t\n\tTD.columnfirstHeader{\n\t    COLOR: white ;\n\t\tbackground-color:#83AAB4;\t\t\n\t\tpadding-left:3px;\n\t\tfont-family: Verdana;\n\t\tfont-size: 8pt;\n\t\tfont-weight:bold; \n\t\ttext-align:center;\n\t}\n\tTD.columnsecondHeader{\n\t   BACKGROUND-COLOR: #83AAB4;\n\t   COLOR: white ;\n\t   FONT-SIZE: 8pt; \n\t   text-align:left;\n\t}\t\n\tTD.columnData{\n\t   BACKGROUND-COLOR: white;\n\t   COLOR: black ;\n\t   FONT-SIZE: 8pt; \n\t   text-align:center;\n\t}\n\tTD.columnData1{\n\t   BACKGROUND-COLOR: #FF6666;\n\t   COLOR: black ;\n\t   FONT-SIZE: 8pt; \n\t   text-align:center;\n\t}\n\tTD.columnData2{\n\t   BACKGROUND-COLOR: #FFFF33;\n\t   COLOR: black ;\n\t   FONT-SIZE: 8pt; \n\t   text-align:center;\n\t}\n\t</style>\n</head>\n<body>\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"ViewChartListPopulation\" id=\"ViewChartListPopulation\">\t\n<TABLE cellpadding=\"0\"0cellspacing=\"0\" width=\"100%\">\n\t<tr style=\"height:10px;\" id=\"noDataRow\" style=\"display:none\"><td align=\"center\" valign=\"top\" >There is no Record found.</td></tr>\n\t<tr style=\"height:10px;\"><td valign=\"middle\">\n\t\t\t<table border=\"0\" bgcolor=\'white\' cellpadding=\"0\"  cellspacing=\"0\" width=\"100%\">\n\t\t\t\t<tr><td width=\"80%\">&nbsp;</td><td style=\"padding-right:5px;\" align=\"right\" width=\"10%\" id=\"pNavegator\">&nbsp;</td><td style=\"padding-left:5px;\" align=\"left\" width=\"10%\" id=\"nNavegator\">&nbsp;</td></tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\t\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<TABLE cellpadding=\"1\" bgcolor=\'#404040\' cellspacing=\"1\"  style=\'padding-top:2px;\' width=\"100%\">\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD rowspan=\'2\' class=\'columnfirstHeader\'  width=\'10%\'>&nbsp;</TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<TD colspan=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' class=\'columnfirstHeader\' align=\'center\' style=\'width:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="px;\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<TD class=\'columnsecondHeader\' align=\'center\' style=\'width:5px;\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'columnsecondHeader\'  nowrap=\'true\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TD>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t<TD align=\'center\' class=\'columnData\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TD>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<TD align=\'center\' class=\'columnData\' style=\'width:5px;\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<TD align=\'center\' class=\'columnData\' style=\'width:5px;\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<!-- IN037701 Start. -->\n\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\"CA_SPC\"==\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"){\n\t\t\t\t\t\t\t\t\tparent.chartRecordingFrameSet.rows=\"9%,*,4%\";\n\t\t\t\t\t\t\t\t\tparent.chartRecordingFrameSetInner.rows=\"73%,27%\";\n\t\t\t\t\t\t\t\t\tparent.document.getElementsByName(\"ChartRecordingGraphFrame\").scrolling=\"auto\";\n\t\t\t\t\t\t\t\t\tparent.document.getElementsByName(\"ChartRecordingListFrame\").scrolling=\"auto\";\n\t\t\t\t\t\t\t\t\tparent.parent.document.getElementById(\"FrameID12\").style.height=\"600px\";\n\t\t\t\t\t\t\t\t\tparent.parent.document.getElementById(\"RecID12\").style.height=\"600px\";\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"noDataRow\").style.display=\'\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t<!-- IN037701 End. -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<TABLE cellpadding=\"1\"  cellspacing=\"1\"  style=\'padding-top:2px;\' width=\"100%\">\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD    width=\'100%\'><font size=\"1\">\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t//IN037701 Start. \n\t\t\t\t\t\t\t\t//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\t\t\t\t\tif(\"CA_SPC\"==\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"){\n\t\t\t\t\t\t\t\t\tparent.chartRecordingFrameSet.rows=\"60%,*,4%\";\n\t\t\t\t\t\t\t\t\tparent.chartRecordingFrameSetInner.rows=\"10%,*\";\n\t\t\t\t\t\t\t\t\tparent.document.getElementsByName(\"ChartRecordingGraphFrame\").scrolling=\"no\";\n\t\t\t\t\t\t\t\t\tparent.document.getElementsByName(\"ChartRecordingListFrame\").scrolling=\"no\";\n\t\t\t\t\t\t\t\t\tparent.parent.document.getElementById(\"FrameID12\").style.height=\"100px\";\n\t\t\t\t\t\t\t\t\tparent.parent.document.getElementById(\"RecID12\").style.height=\"100px\";\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"noDataRow\").style.display=\'\';\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t// IN037701 End. \n\t\t\t\t\t\t\t\t</script>\t\t\t\t\t\t\n\t\t\t\t\t\t\t</font></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n\t\t\t</TABLE>\n\t\t</td>\n\t</tr>\n\t<input type=\"hidden\" name=\"tDisplayDays\" id=\"tDisplayDays\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t<input type=\"hidden\" name=\"tTotalRows\" id=\"tTotalRows\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t<input type=hidden name=\'chart_id\' id=\'chart_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=hidden name=\'toDateForExt\' id=\'toDateForExt\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t<input type=hidden name=\'fromDateForExt\' id=\'fromDateForExt\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n</table>\n</form>\n<script>\nvar disDays=parseInt(document.ViewChartListPopulation.tDisplayDays.value);\nvar totDays=parseInt(document.ViewChartListPopulation.tTotalRows.value);\nif(totDays>disDays){\n\tdocument.getElementById(\"nNavegator\").innerHTML=\"<A href=\\\"javascript:clickNextforList();\\\">Next</A>\";\n}else{\n\tdocument.getElementById(\"nNavegator\").innerHTML=\"&nbsp;\";\n}\nif(disDays>5){\n\tdocument.getElementById(\"pNavegator\").innerHTML=\"<A href=\\\"javascript:clickPreviousforList();\\\">Previous</A>\";\n}else{\n\tdocument.getElementById(\"pNavegator\").innerHTML=\"&nbsp;\";\n}\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
	String locale = (String) p.getProperty("LOCALE");
	String tchartId = (String)request.getParameter("Chart_Id");
	String tfromDate = (String)request.getParameter("FromDate");
	String ttoDate = (String)request.getParameter("ToDate");
	//String tencounterId = (String)request.getParameter("EncounterID");
	String tencounterId = request.getParameter("EncounterID")==null?"0":(String)request.getParameter("EncounterID");
	String tfacilityId = (String)request.getParameter("FacilityID");
	String tpatientId = (String)request.getParameter("PatientID");
	String tfromDate1 =	com.ehis.util.DateUtils.convertDate(tfromDate,"DMY", locale,"en");
	String ttoDate1	=	com.ehis.util.DateUtils.convertDate(ttoDate,"DMY", locale,"en");
String pageStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pageStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs,rs1= null;
		ArrayList dateArray = new ArrayList();
		ArrayList hoursArray = new ArrayList();
		int displayDays=0;
		int totDates=0;
		try{
				con = ConnectionManager.getConnection(request);	
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
				//query.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
				query.append("WHERE b.chart_id = ? ");//common-icn-0180
				query.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
				query.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
				query.append("AND a.discr_msr_id = d.discr_msr_id ");
				query.append("AND b.discr_msr_id = d.discr_msr_id "); 
				query.append("AND d.FORMAT_TYPE = 'T' ");
				//query.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
				query.append("AND a.facility_id = ? ");//common-icn-0180
				//query.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
				query.append("AND a.patient_id = ? ");//common-icn-0180
				//query.append("AND b.encounter_id = '"+tencounterId+"' ");
				if(!"0".equals(tencounterId)){
					//query.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180
					query.append("AND b.encounter_id = ? ");//common-icn-0180
				}
				//query.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+tfromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+ttoDate1+" 23:59', 'dd/mm/yyyy hh24:mi')   ");	//common-icn-0180														
				query.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')   ");//common-icn-0180															
				
				query.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
				ps = con.prepareStatement(query.toString());
				//common-icn-0180 starts
				ps.setString(1, tchartId);
				ps.setString(2, tfacilityId);
				ps.setString(3, tpatientId);
				ps.setString(4, tencounterId);
				ps.setString(5, tfromDate1);
				ps.setString(6, ttoDate1);
				//common-icn-0180 ends
				rs = ps.executeQuery();
				while(rs.next()){
					dateArray.add(rs.getString(1));
				}
				if(dateArray.size()>0){
				
					totDates=dateArray.size();
					displayDays = (String)request.getParameter("Display_Days")==null?0:Integer.parseInt((String)request.getParameter("Display_Days"));
					
					int dDate = displayDays;
					String dStartDate="";
					String dEndDate ="";
					int noOfDays = ((dateArray.size())-displayDays)>5?(displayDays+5):(dateArray.size());
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					
					for(;displayDays<noOfDays;displayDays++){
						int colSpan = 0;
						int colWidth = 0;
						String hValue=(String)dateArray.get(displayDays);
						if(dDate==displayDays){
							dStartDate=hValue;
						}
						if(displayDays==(noOfDays-1)){
							dEndDate=hValue;
						}
						StringBuffer query1 = new StringBuffer();
						query1.append("SELECT  count(DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi')) dt ");
						query1.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b, ca_view_chart_config d ");
						//query1.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
						query1.append("WHERE b.chart_id = ? ");//common-icn-0180
						query1.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
						query1.append("AND a.discr_msr_id = d.discr_msr_id ");
						query1.append("AND b.discr_msr_id = d.discr_msr_id ");
						query1.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
						query1.append("AND d.FORMAT_TYPE='T' ");
						//query1.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
						query1.append("AND a.facility_id = ? ");//common-icn-0180
						//query1.append("AND a.patient_id = '"+tpatientId+"' ");	//common-icn-0180
						query1.append("AND a.patient_id = ? "); //common-icn-0180	
						//query1.append("AND b.encounter_id = '"+tencounterId+"' ");
						if(!"0".equals(tencounterId)){
							//query1.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180    
							query1.append("AND b.encounter_id = ? ");  //common-icn-0180  
						}
						//query1.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+hValue+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+hValue+" 23:59', 'dd/mm/yyyy hh24:mi') "); //common-icn-0180
						query1.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");//common-icn-0180
						
						query1.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy hh24:mi') asc  ");
						ps = con.prepareStatement(query1.toString());
						//common-icn-0180 starts
						ps.setString(1, tchartId);
						ps.setString(2, tfacilityId);
						ps.setString(3, tpatientId);
						ps.setString(4, tencounterId);
						ps.setString(5, hValue);
						ps.setString(6, hValue);
						//common-icn-0180 ends
						rs = ps.executeQuery();
						if(rs.next())
							colSpan = rs.getInt(1);
						colWidth=colWidth * colSpan;
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(colSpan));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(colWidth));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(	com.ehis.util.DateUtils.convertDate(hValue,"DMY", "en",locale) ));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
					
            _bw.write(_wl_block13Bytes, _wl_block13);

					StringBuffer query2 = new StringBuffer();
					query2.append("SELECT  DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt ");
					query2.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b, ca_view_chart_config d ");
					//query2.append("WHERE b.chart_id = '"+tchartId+"'  ");//common-icn-0180
					query2.append("WHERE b.chart_id = ?  ");//common-icn-0180
					query2.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
					query2.append("AND a.discr_msr_id = d.discr_msr_id ");
					query2.append("AND b.discr_msr_id = d.discr_msr_id ");
					query2.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
					query2.append("AND d.FORMAT_TYPE='T' ");
					//query2.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
					query2.append("AND a.facility_id = ?");//common-icn-0180
					//query2.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
					query2.append("AND a.patient_id = ? ");//common-icn-0180
					//query2.append("AND b.encounter_id = '"+tencounterId+"' ");
					if(!"0".equals(tencounterId)){
							//query2.append("AND b.encounter_id = '"+tencounterId+"' ");    
							query2.append("AND b.encounter_id = ? ");//common-icn-0180    
						}
					//query2.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+dStartDate+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+dEndDate+" 23:59', 'dd/mm/yyyy hh24:mi') ");//common-icn-0180  
					query2.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");  //common-icn-0180
					
					query2.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy hh24:mi') asc  ");
					ps = con.prepareStatement(query2.toString());
					//common-icn-0180 starts
					ps.setString(1, tchartId);
					ps.setString(2, tfacilityId);
					ps.setString(3, tpatientId);
					ps.setString(4, tencounterId);
					ps.setString(5, dStartDate);
					ps.setString(6, dEndDate);
					//common-icn-0180 ends
					rs = ps.executeQuery();
					while(rs.next()){
						hoursArray.add(rs.getString(1));
					}
					DateFormat fHour = new SimpleDateFormat("HH:mm");
					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	
					
            _bw.write(_wl_block14Bytes, _wl_block14);

					for(int i=0;i<hoursArray.size();i++){
					java.util.Date dt=df.parse((String)hoursArray.get(i));
					String timeValue=fHour.format(dt);
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(timeValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);

					
					}
					
            _bw.write(_wl_block13Bytes, _wl_block13);

					
					ps = con.prepareStatement("SELECT CRIT_LOW_COLOR_CODE,LOW_COLOR_CODE,HIGH_COLOR_CODE,CRIT_HIGH_COLOR_CODE FROM CR_CLIN_EVENT_PARAM");
					rs = ps.executeQuery();
					String critcalLowColor = "style='width:5px;'";
					String lowColor = "style='width:5px;'";
					String NoramalColor = "style='background-color:#32CD32;width:5px;'";
					String highColor = "style='width:5px;'";
					String critcalHighColor = "style='width:5px;'";
					if(rs.next()){
						critcalLowColor = rs.getString(1)==null?"":"style='background-color:"+(String)rs.getString(1)+";width:5px;'";
						lowColor = rs.getString(2)==null?"":"style='background-color:"+(String)rs.getString(2)+";width:5px;'";
						highColor = rs.getString(3)==null?"":"style='background-color:"+(String)rs.getString(3)+";width:5px;'";
						critcalHighColor = rs.getString(4)==null?"":"style='background-color:"+(String)rs.getString(4)+";width:5px;'";
					}
					eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
					Hashtable tableData = new Hashtable();
					tableData = (Hashtable) bean.getTableData(tpatientId,tfacilityId,tencounterId,dStartDate+" 00:00",dEndDate+" 23:59",tchartId,"T");
					Enumeration en=tableData.keys();
					//while(en.hasMoreElements()){
					//	String compId=(String)en.nextElement();
						StringBuffer query5 = new StringBuffer();
						//query5.append("Select DISCR_MSR_ID FROM CA_VIEW_CHART_CONFIG WHERE CHART_ID='"+tchartId+"' AND FORMAT_TYPE='T' ORDER BY DISP_ORD_SEQ_NUM");
						//query5.append("Select CVCC.DISCR_MSR_ID,CVCC.DISP_ORD_SEQ_NUM,ADM.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE  CVCC.DISCR_MSR_ID=ADM.DISCR_MSR_ID AND CVCC.CHART_ID='"+tchartId+"' AND CVCC.FORMAT_TYPE='T' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");//common-icn-0180
						query5.append("Select CVCC.DISCR_MSR_ID,CVCC.DISP_ORD_SEQ_NUM,ADM.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE  CVCC.DISCR_MSR_ID=ADM.DISCR_MSR_ID AND CVCC.CHART_ID=? AND CVCC.FORMAT_TYPE='T' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");//common-icn-0180
						
						ps = con.prepareStatement(query5.toString());
						ps.setString(1, tchartId);//common-icn-0180
						rs1 = ps.executeQuery();
				while(rs1.next()){
						String compId=(String)rs1.getString(1);
						StringBuffer query4 = new StringBuffer();
						query4.append("SELECT ADM.SHORT_DESC,ADM.MIN_VALUE,ADMRRN.NUM_CRIT_LOW,ADMRRN.NUM_REF_LOW,ADMRRN.NUM_REF_HIGH,ADMRRN.NUM_CRIT_HIGH,ADM.MAX_VALUE FROM AM_DISCR_MSR ADM,AM_DISCR_MSR_REF_RNG_NUM ADMRRN WHERE  ADMRRN.DISCR_MSR_ID =ADM.DISCR_MSR_ID AND ADM.DISCR_MSR_ID IN ('");
						query4.append(compId);
						query4.append("')");
						ps = con.prepareStatement(query4.toString());				
						rs = ps.executeQuery();
						String compName="";
						Double minValue=0.00;
						Double critLowValue=0.00;
						Double lowValue=0.00;
						Double highValue=0.00;
						Double critHighValue=0.00;
						Double maxValue=0.00;
						if(rs.next()){
							compName=(rs.getString(1))==null?"":((String)rs.getString(1));
							minValue =(rs.getString(2))==null?0.00:Double.parseDouble(((String)rs.getString(2)));
							critLowValue =(rs.getString(3))==null?0.00:Double.parseDouble(((String)rs.getString(3)));
							lowValue  =(rs.getString(4))==null?0.00:Double.parseDouble(((String)rs.getString(4)));
							highValue  =(rs.getString(5))==null?0.00:Double.parseDouble(((String)rs.getString(5)));
							critHighValue  =(rs.getString(6))==null?0.00:Double.parseDouble(((String)rs.getString(6)));
							maxValue  =(rs.getString(7))==null?0.00:Double.parseDouble(((String)rs.getString(7)));
						}					
						Hashtable stable=(Hashtable)tableData.get(compId);
						if(stable!=null){
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(compName ));
            _bw.write(_wl_block18Bytes, _wl_block18);

						for(int j=0;j<hoursArray.size();j++){
							String tdata=((String)stable.get((String)hoursArray.get(j)))==null?"":"0".equals(((String)stable.get((String)hoursArray.get(j))))?"":((String)stable.get((String)hoursArray.get(j)));
							if (!"".equals(tdata)){
								Double dataValue=Double.parseDouble(tdata);							
								if(dataValue<=critLowValue)//(minValue<=dataValue && dataValue<=critLowValue) //removed second condition IN044496//IN044612
								{
									
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(critcalLowColor ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}else if(critLowValue<dataValue && dataValue<lowValue){
									
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(lowColor ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}else if(lowValue<=dataValue && dataValue<highValue){
									
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(NoramalColor ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}else if(highValue<=dataValue && dataValue<critHighValue){
									
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(highColor ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}else if(critHighValue<=dataValue)//(critHighValue<=dataValue && dataValue<=maxValue)removed second conditionIN04449IN044612
								{
									
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(critcalHighColor ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}else{
									
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}
							}else{
								
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tdata ));
            _bw.write(_wl_block24Bytes, _wl_block24);

							}
						}
						
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
					}
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}else{
					StringBuffer queryT = new StringBuffer();
				
					queryT.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
					//queryT.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
					queryT.append("WHERE b.chart_id = ? ");//common-icn-0180
					queryT.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
					queryT.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
					queryT.append("AND a.discr_msr_id = d.discr_msr_id ");
					queryT.append("AND b.discr_msr_id = d.discr_msr_id "); 
					queryT.append("AND d.FORMAT_TYPE = 'G' ");
					//queryT.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
					queryT.append("AND a.facility_id = ? ");//common-icn-0180
					//queryT.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
					queryT.append("AND a.patient_id = ? ");//common-icn-0180
					//query.append("AND b.encounter_id = '"+tencounterId+"' ");
					if(!"0".equals(tencounterId)){
						//queryT.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180
						queryT.append("AND b.encounter_id = ? ");//common-icn-0180
					}
					//queryT.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+tfromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+ttoDate1+" 23:59', 'dd/mm/yyyy hh24:mi')   ");//common-icn-0180															
					queryT.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')   ");	//common-icn-0180														
					
					queryT.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
					ps = con.prepareStatement(queryT.toString());
					//common-icn-0180 starts
					ps.setString(1, tchartId);
					ps.setString(2, tfacilityId);
					ps.setString(3, tpatientId);
					ps.setString(4, tencounterId);
					ps.setString(5, tfromDate1);
					ps.setString(6, ttoDate1);
					//common-icn-0180 ends
					rs = ps.executeQuery();
					if(rs.next()){
					}else{
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block29Bytes, _wl_block29);

					}
				}
		}catch(Exception ee)
		{
			//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}finally{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}	
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(displayDays ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totDates ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tchartId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tencounterId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tpatientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tfacilityId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ttoDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tfromDate));
            _bw.write(_wl_block38Bytes, _wl_block38);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
