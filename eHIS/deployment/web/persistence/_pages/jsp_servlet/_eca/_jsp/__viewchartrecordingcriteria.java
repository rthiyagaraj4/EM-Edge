package jsp_servlet._eca._jsp;

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

public final class __viewchartrecordingcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartRecordingCriteria.jsp", 1736157593713L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/ViewChartRecording.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" OnLoad=\'defaultValue()\'>\n<form name =\"ChartLayoutCriteriaForm\"  >\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\"  width=\"100%\"  >\n\t\t<tr>\n\t\t\t<td colspan=\'2\'  width=\'100%\'>\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tbId\' width=\"100%\" valign=\'bottom\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'10%\' class=\'label\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t<td width=\'20%\' class=\'fields\'  nowrap >\n\t\t\t\t\t\t\t<select name=\'chart_id\' id=\'chart_id\' onchange=\'loadChart(this);\'>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\"\">-----------";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="-----------</option>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=label colspan=\"2\" width=\'17%\' nowrap>\n\t\t\t\t\t\t\t<INPUT TYPE=\"checkbox\" name=\"def_Chart_Check\" id=\"def_Chart_Check\" onClick=\"setDefaultChart(this)\">&nbsp;Default Chart\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\' width=\'7%\' nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap >\n\t\t\t\t\t\t\t<input type=\'textbox\' id=\'fromDate\' name=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' size=\'14\' maxlength=\'16\' onblur=\"ValidateDateTimeOfPeriod(this,toDate)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'fromDate\')\"></img>-<input type=\'textbox\' id=\'toDate\' name=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' size=\'14\' maxlength=\'16\' onblur=\"ValidateDateTimeOfPeriod(fromDate,this)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'toDate\')\"></img><img SRC=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'21%\' align=\'right\' nowrap >\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'button\' name=\'Search\' id=\'Search\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' class=button onclick=\"SearchChart(\'jsp\')\">\n\t\t\t\t\t\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' class=button onclick=\"resetCriteria();\">\n\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<img src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'100%\' height=\'15\'/> \n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<input type=hidden name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=hidden name=\'adm_date\' id=\'adm_date\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=hidden name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\n<input type=hidden name=\'p_called_from\' id=\'p_called_from\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> <!--   IN037701 -->\n<input type=hidden name=\'derChartId\' id=\'derChartId\' value =\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/>\n<script>\nvar fDate = document.forms[0].fromDate.value;\nvar tDate = document.forms[0].toDate.value;\n\nif(fDate==\"\")\n\tdocument.forms[0].toDate.value = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\nif (tDate==\"\")\n\tdocument.forms[0].fromDate.value=minusDate(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\"DMY\",\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'4\',\"d\");\n\n</script>\n\n<script>\nvar def_chart_id = document.forms[0].derChartId.value;\nif(def_chart_id!=\"\"){\n\tdocument.forms[0].chart_id.value=trimString(def_chart_id);\n\tdocument.forms[0].def_Chart_Check.checked = true ;\n\tSearchChart(\'jsp\');\n}else{\n\tdocument.forms[0].chart_id.value=trimString(def_chart_id);\n\tdocument.forms[0].def_Chart_Check.checked = false ;\n}\n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Chowminya												SKR-CRF-0036
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

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

	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
	String function_from= request.getParameter("function_from") == null ? "" : request.getParameter("function_from");
	String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

	String textReadOnly = "";
	String imageDisabled = "";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String chartRef= request.getParameter("chartRef")==null?"":request.getParameter("chartRef");
	String chtId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String facility_id = session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
	String sysdate = "";
	String encounterId = request.getParameter("encounter_id")==null ? "0" : request.getParameter("encounter_id");
	String module_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");

	String practitioner_id = session.getValue("ca_practitioner_id")==null ? "" : (String)session.getValue("ca_practitioner_id");
	
	String admDtChk = "";
	if(!adm_date.equals(""))
		admDtChk = "Y";
	else
		admDtChk = "N";

	if(encounterId.equals("")) encounterId = "0";

	String fromDateForExt = "";
	String toDateForExt = "";
	String displayMandatory = " style = display:none";

	if(encounterId.equals("0"))
		displayMandatory = " style = display";
	else
		displayMandatory = " style = display:none";


            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String imgUrl="";
		if(sStyle.equals("IeStyle.css")){
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

									Connection con = null;
									PreparedStatement pstmt =null;
									ResultSet rs= null;
									String systime ="";
									String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
									String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
									String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
									String pract_type =(String) session.getValue("practitioner_type")==null ? "" : (String) session.getValue("practitioner_type");
									String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
									String respId = (String)	session.getValue("responsibility_id")==null ? "" :(String)	session.getValue("responsibility_id") ;
									//String relnId = (String)session.getValue("relationship_id")==null ? "" :(String)	session.getValue("relationship_id") ;
									String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id") ;
									String sqlAuth = "";
									String errorAuth = "";
									String chart_Default="";
									try{
										con = ConnectionManager.getConnection(request);											
										pstmt = con.prepareStatement("SELECT DISTINCT CC.CHART_ID,CC.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC , CA_CHART CC WHERE CC.CHART_ID=CVCC.CHART_ID   ORDER BY 2");
										rs = pstmt.executeQuery();										
										String chartId = "";
										String chartDesc = "";										
										while(rs.next()){											
											chartId = rs.getString(1);
											chartDesc = rs.getString(2);											
											
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chart_Default));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chartDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

										
										}

										if (pstmt!=null) pstmt.close();
										if( rs!=null) rs.close();

										
									}catch(Exception e){
										//out.println(e.toString());//COMMON-ICN-0181
										e.printStackTrace();//COMMON-ICN-0181
									}finally{
										if(con!=null)
											ConnectionManager.returnConnection(con,request);
									}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDateForExt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(toDateForExt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
String def_chart_id = "";
	try{
		con = ConnectionManager.getConnection(request);											
		pstmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitioner_id+"'");
		rs = pstmt.executeQuery();			
		if(rs.next()){											
			def_chart_id = rs.getString(1);	
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();		
	}catch(Exception e){
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(def_chart_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sysdate ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sysdate ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Chart.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
