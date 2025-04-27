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

public final class __chartrecordingcontrols extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingControls.jsp", 1738290510547L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ChartRecording.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t</head>\n\t<body onKeyDown=\"lockKey()\">\n\t<form name=\'chartRecordingControlsForm\' id=\'chartRecordingControlsForm\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="] = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>dtArr[";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type = \'hidden\'  name = \'idx_value\'\t\tvalue = ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" - 1>\n\t\t\t<input type = \'hidden\'  name = \'cur_idx_value\'\tvalue = \"0\">\n\t\t\t<input type = \'hidden\'  name = \'sort_by\'\tvalue = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' name=\'encounter_id\'>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' name=\'chartId\'>\n\t\n\t\t\t\n\t\t\t<table cellpadding=0 cellspacing=\'0\' border=\'1\' width=\'100%\' height=\'100%\'>\n\t\t\t<tr><td>\n\t\t\t<table cellpadding=0 cellspacing=\'0\' border=0 width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\n\t\t\t<td width=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=\'right\'><input class=\'button\' type=\'button\' name=\'print\' id=\'print\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onclick=\'PrintData()\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td align=\'right\'><input type=\'button\' id=\'errorBtn\' name=\'showErrors\' id=\'showErrors\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onclick=\'showErrosOnClick()\'  class=\'button\'>&nbsp;&nbsp;</td> \n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<td>\n\t\t\t<table cellpadding=0 cellspacing=\'0\' border=\'1\' width=\'100%\'>\n\t\t\t\t<tr id=\'buttonVisible\' style=\'visibility:visible\' align=\'right\'>\n\t\t\t\t\t\n\t\t\t\t\t<td  width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridSPreviousNOR16.gif\' id=\'first\' onclick=\'loadPrevNextTen(this)\' disabled /><img src=\'../../eCommon/images/iGridPreviousNOR16.gif\' id=\'prevTenRecs\' onclick=\'loadPrevNextTen(this)\' disabled /></td>\n\t\t\t\t\t<td  id=\'labelCaption\' class=\'Pagination\'>&nbsp;</td>\n\t\t\t\t\t<td  width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridNextNOR16.gif\' id=\'nextTenRecs\' onclick=\'loadPrevNextTen(this)\' /><img src=\'../../eCommon/images/iGridSNextNOR16.gif\' id=\'last\' onclick=\'loadPrevNextTen(this)\' /></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td></tr></table>\n\t\t\t</td></tr></table>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<script> \n\nfunction defaultPage()\n{\n\tif(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' == \'Y\' || \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' == \'Y\')\n\t{\n\t\tvar idx_value\t= document.forms[0].idx_value.value;\n\t\tvar sort_by = document.forms[0].sort_by.value;\n\t\tvar cur_idx_value = document.forms[0].cur_idx_value.value;\n\n\t\tvar fromDateTime =\"\";\n\t\tvar toDateTime =\"\";\n\t\tvar displend = \"\";\n\t\tvar displstart = 1;\n\n\t\tif(idx_value > 0)\n\t\t{\n\t\t\tfromDateTime\t= dtArr[0];\n\t\t\ttoDateTime\t\t= dtArr[0];\n\n\t\t\tif (idx_value >= 1)\n\t\t\t{\n\t\t\t\tif(sort_by == \"A\")\n\t\t\t\t\ttoDateTime = dtArr[1];\n\t\t\t\telse \n\t\t\t\t\tfromDateTime\t= dtArr[1];\n\n\t\t\t\tdisplend = eval(idx_value) ;\n\t\t\t}\n\t\t\telse\n\t\t\t\tdisplend = 1;\n\n\t\t\tdocument.forms[0].cur_idx_value.value = 0;\n\t\t\tdocument.getElementById(\"labelCaption\").innerText = \"Page \"+ displstart + \" of \" + displend;\n\n\t\t\tif(idx_value == 1)\n\t\t\t{\n\t\t\t\tdocument.forms[0].nextTenRecs.disabled = true;\n\t\t\t\tdocument.forms[0].prevTenRecs.disabled = true;\n\t\t\t\tdocument.forms[0].first.disabled = true;\n\t\t\t\tdocument.forms[0].last.disabled = true;\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].nextTenRecs.disabled = true;\n\t\t\tdocument.forms[0].prevTenRecs.disabled = true;\n\t\t\tdocument.forms[0].first.disabled = true;\n\t\t\tdocument.forms[0].last.disabled = true;\n\t\t}\n\t}\n}\n\ndefaultPage();\n</script>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date				Edit History     Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/04/2014		IN047647.1		Chowminya												Reopen Thai Login screen, Page of chart details disappear and unable to click in next page button
24/08/2015		IN057123		Karthi														In Thai screen Date 29/02/2559 when we open Chart screen, the system displays Script Error Message.
22/06/2020		IN073163 		SIVABAGYAM													EM version 12.12.1_CA_Record Chart_System does not display page number and select page button.Occurred in Log in Thai, English working fine.

---------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		int nKey = 0;
		Connection con = null;
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
		String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
		String width = "";
		try{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null; 

		String encounterId		=	request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
		if(module_id.equals("MC"))
			width = "25%";
		else
			width = "50%";
		if(encounterId.equals("")) encounterId = "0";

		String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String errorAuth	=  request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
		String sort_by		= request.getParameter("sort_by")==null?"D":request.getParameter("sort_by");
		String contr_mod_accession_num	= request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");
		String adm_date		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
		String facilityId = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
		String patientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String chartId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
		String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
		//converstion is done IN047647.1
		if(!locale.equals("en")){//IN073163 STARTS
			fromDate =	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en"); //- commented for SRR20056-SCF-9434- IN057123 [IN037552]
			toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM",  locale,"en"); //- commented for SRR20056-SCF-9434-IN057123 [IN037552]
		}//IN073163 ENDS

		String defaultYN = request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")==null?"":request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN");
		
		if(summaryYN.equals("N") && detailYN.equals("N"))
		{
			out.println("<script>");	
			out.println("parent.ChartRecordingControlsFrame.location.href='../../eCommon/html/blank.html'</script>");
	
		}
		else
		{

		pstmt = con.prepareStatement("select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') from pr_encounter where facility_id = ? and encounter_id = ? ");
		pstmt.setString(1,facilityId);
		pstmt.setString(2,encounterId);
		rs  = pstmt.executeQuery();
		if(rs.next())
		{
			adm_date = rs.getString(1) == null ? "" :  rs.getString(1);
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		int daySummary = 0;
	
		if(function_from.equals("SECONDARY_TRIAGE"))
			daySummary = 1;

		int count = 0;
		StringBuffer sqlDates = new StringBuffer();
		String tempString = "";
		if(defaultYN.equals("Y"))
		{
			tempString = " CA_ENCNTR_CHART_DRAFT B ";
		}
		else
		{
			tempString = "  CA_CHART_SECTION_COMP B ";
		}
		
		if(detailYN.equals("Y"))
		{
			sqlDates.append("SELECT  distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,'N' DISCR_MSR_RESULT_TYPE  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
			
			if(defaultYN.equals("Y"))
			{
				sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
			}

			sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and a.facility_id=? and a.patient_id=?  and a.DISCR_MSR_RESULT_TYPE in('C','D','E','N','A','I','L','F','H','T') ");
			
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi')+0.00068287 ");
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");	
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		}
	
		if(detailYN.equals("Y") && summaryYN.equals("Y"))
		   sqlDates.append(" UNION ALL");

		if(summaryYN.equals("Y"))
		{
			//sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,a.DISCR_MSR_RESULT_TYPE from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
			sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,a.DISCR_MSR_RESULT_TYPE from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");

			if(defaultYN.equals("Y"))
			{
				sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
			}

			sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and a.facility_id=? and a.patient_id=? and a.DISCR_MSR_RESULT_TYPE IN ('S','S1','S2','S3')   ");
		 			
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");		
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi')+0.00068287");
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");		
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		}
	 
		if(sort_by.equals("D"))
		{
			//sqlDates.append(" order by 2 Desc");
			sqlDates.append(" order by 2 Desc, 3 ASC");
		}
		else
		{
			sqlDates.append(" order by 2");
		}

		pstmt =	con.prepareStatement(sqlDates.toString());

		if(detailYN.equals("Y"))
		{
			pstmt.setString(++count,chartId);		
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);
			
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					
						pstmt.setString(++count,adm_date);
					
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					
				}
				else
				{	
					
						 if(!fromDate.equals(""))
						{
							 pstmt.setString(++count,fromDate);
						}
						 if(!toDate.equals(""))
						{
							pstmt.setString(++count,adm_date);
							pstmt.setString(++count,toDate);
						}
					
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
					pstmt.setString(++count,contr_mod_accession_num);
			}
		 }
		 
		 if(summaryYN.equals("Y"))
		 {
			pstmt.setString(++count,chartId);		
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);

				if(fromDate.equals("") && toDate.equals(""))
				{
					pstmt.setString(++count,adm_date);
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					pstmt.setString(++count,fromDate);
					pstmt.setString(++count,toDate);
				}
				else
				{	
					if(!fromDate.equals(""))
					{
						 pstmt.setString(++count,fromDate);
					}
					 if(!toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,toDate);
					}
				}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				pstmt.setString(++count,contr_mod_accession_num);
			}
		}

		rs = pstmt.executeQuery();	
		
		int nCtr = 0;
		String strDateRecd = "";

		while (rs.next())
		{
			strDateRecd = rs.getString(1);
			strDateRecd =	com.ehis.util.DateUtils.convertDate(strDateRecd,"DMYHM", "en",locale); //IN047647.1

			if (nCtr == 0 || nCtr == 10)
			{
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block11Bytes, _wl_block11);

				nKey++;
				nCtr =0;

			}
			
			nCtr++;
		}

		if(nCtr >= 1)
		{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(width));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(errorAuth.equals("A")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ErrorDetails.label","ca_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChartRecordingControls.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
