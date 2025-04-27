package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCA.ChartComponentFormulaBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartcomponentlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartComponentList.jsp", 1733717123812L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script><!--IN066995-->\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ChartComponent.js\'></script>\t\t\n\t</head>\n\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<form name=\'ChartComponentListForm\' id=\'ChartComponentListForm\' action=\'\' method=\'post\'>\n\t\n\t<table width=\'100%\'  cellpadding=\'3\' cellspacing=0  align=\'center\'>\n\t\t<tr>\n\t\t\t<td colspan =\'11\' align=\'left\'><input type=\'button\' class = \'button\' name=\'btnAddPanel\' id=\'btnAddPanel\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onclick=\'addPanel(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\"sequenceNumber\")\'></td>\n\t\t</tr>\n\t</table>\t \n\t\t\n\t<table width=\'100%\' class=\'grid\' id=\'tabList\' >\n\t\t<tr>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"100px\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"100px\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"200px\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th class =\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"80px\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"190px\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"50px\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"60px\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp; <!-- <INPUT TYPE=\"checkbox\" name=\"chkMainMandatory\" id=\"chkMainMandatory\" onclick=\'perform(this)\'> --> </th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"100px\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\"60px\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</th>\n\t\t\t<th class =\'columnheader\' align=\"left\" width=\'0%\' Style=\'display:none\' >&nbsp;</th>\n\t\t</tr> \n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\t\tdocument.URL =\'../../eCommon/html/blank.html\'\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t<script>\n/*\n\t\t\tvar flag;\n\t\t\t\tvar total=0;\n\t\t\t\tif(eval(\"document.forms[0].sequenceGrp\") != null)\n\t\t\t\t{\n\t\t\t\t\tfor(var index = 0 ; index < parseInt(eval(\"document.forms[0].sequenceGrp.value\"));index++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar noOfRows = eval(\"document.forms[0].noOfRows\"+index)\n\t\t\t\t\t\ttotal = total + parseInt(noOfRows.value)\n\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\tif(total==0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.URL =\'../../eCommon/html/blank.html\'\n\t\t\t}\n\t\t\t*/\n\t\t\t/*else{\n\t\t\t\tvar counter = 0;\n\t\t\t\tfor(var index = 0 ; index < parseInt(document.forms[0].sequenceGrp.value);index++)\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tvar noofrows = eval(\"document.forms[0].noOfRows\"+index)\n\t\t\t\t\tfor(var indexJ = 0;indexJ<parseInt(noofrows.value);indexJ++){\n\t\t\t\t\t\tvar defChecked = eval(\"document.forms[0].mandatory_yn\"+index+indexJ)\n\t\t\t\t\t\tif(defChecked.checked == true){\n\t\t\t\t\t\t\tcounter++;\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(parseInt(counter) == parseInt(total)){\n\t\t\t\t\t//document.forms[0].chkMainMandatory.checked = true;\t\t\t\n\t\t\t\t}\n\t\t\t}*/\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<!-- <script>document.forms[0].chkMainDefault.disabled = true;</script>  -->\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t</table>\n\t<input type=\'hidden\' name=\'sum_req\' id=\'sum_req\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'change_trans\' id=\'change_trans\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<input type=\'hidden\' name=\'element_types\' id=\'element_types\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\'hidden\' name=\'enable_ele_type\' id=\'enable_ele_type\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n\n\t</form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
Date       		Edit History    Name        	 Rev.date           Rev.Name              Description                  
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	                                            created
26/06/2013    	IN039171		Dinesh	                                           System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
15/05/2018      IN066995             RamyaMaddena       15/05/2018          Ramesh.G      comitted & modified for ARYU-SCF-0070[IN066995]
-------------------------------------------------------------------------------------------------------------------------------------
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
            eCA.ChartComponentResultsetBean recordsBean= null;synchronized(session){
                recordsBean=(eCA.ChartComponentResultsetBean)pageContext.getAttribute("recordsBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordsBean==null){
                    recordsBean=new eCA.ChartComponentResultsetBean();
                    pageContext.setAttribute("recordsBean",recordsBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String operation = request.getParameter("operation")==null ? "" : request.getParameter("operation");
	String searchVal = request.getParameter("chartCompSearch")==null?"":request.getParameter("chartCompSearch");
	
	Connection con = null;

	PreparedStatement pstmtList = null;
	ResultSet resList = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	PreparedStatement psSumm = null;
	ResultSet rsSumm = null;
	PreparedStatement psChk = null;
	ResultSet resChk = null;	
	PreparedStatement pstmtTrans = null;
	ResultSet resTrans = null;
	PreparedStatement pstmtAssYN = null;
	ResultSet resAssYN = null;
	

	int i = 0;
	int j = 0;
	int k = 0;
	int noOfRows = 0;
	int ctr=0;
	int sequenceNumber = 0;

	String sqlAssYN = "";
	String sqlSumm = "";
	String summaryColumn = "";
	String readOnly="";
	String style="";
	String summaryType = "";
	String remove_value ="";
	String section_id = "";
	String section_desc = "";//not reqd for table
	String discr_msr_id = "";
	String discr_msr_desc = "";//not reqd for table
	String result_type = "";
	String order_srl_no = "";//discr_msr_disp_order
	String current_sec_desc = "";
	String sql = "";
	String sqlComp = "";
	String classvalue = "";
	String panel_desc_id = "";
	String discr_disp_order_seq = "";
	String finalString = "";
	String finalStringGrp = "";
	String recordValues = "";
	String sqlChk = "";
	String tempDispSeqNum = "";
	String finalSummaryValue="";
	String summarySelect="";
	String summaryColText="";
	String summaryColHidden="";
	String default_yn="";
	String summary_col = "";
	String disabled ="";
	String checked = "";
	String checkedSumm = "";
	String tempSum = "";
	String tempAvg = "";
	String tempMin = "";
	String tempMax = "";
	//String tempPct = "";
	String formula_def = "";
	String sum_yn = "N";
	String disChkSumm = "";
	String result_typeForDefn = "Def.";

	String summary_req_yn = "";
	String associate_score_yn = "";
	String change_at_trans = "";
	String sqlTrans = "";
	String enableSummYN = "";
	String enableDefault = "";
	String mandatory_yn = "";
	String checkedMandatory = "";
	
	StringTokenizer tokenPipe = null;
	StringTokenizer tokenTilde = null;
	
	HashMap tableForRecs =null;
	HashMap tabFormula =  null;
	HashMap tabSummary =  null;	
	
	String element_type = "##";
	String enableEleType = "";
	String def_select = "";
	StringBuffer elementTypes = new StringBuffer();
	StringBuffer elementTypes1 = null;


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartComponentAddPanel.label","ca_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(searchVal));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

		try{

			con = ConnectionManager.getConnection(request);
			try
				{
			PreparedStatement psmt = con.prepareStatement("SELECT ELEMENT_TYPE,ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE");
					ResultSet rset = psmt.executeQuery();
					String elementType = null,elementDesc = null;
					while(rset.next())
					{
						elementType = rset.getString("ELEMENT_TYPE");
						elementDesc = rset.getString("ELEMENT_TYPE_DESC");
						elementTypes.append("<option value='"+elementType+"' >"+elementDesc+"</option>");
					}	
					elementTypes1 = new StringBuffer(elementTypes.toString());
					if(rset!=null)
						rset.close();
					if(psmt!=null)
						psmt.close();
	
					String sqlEle = "select SPL_CHART_TYPE from CA_CHART WHERE CHART_ID = ?";
					psmt = con.prepareStatement(sqlEle);
					psmt.setString(1,searchVal);
					rset = psmt.executeQuery();
					String spl_chart_type = "";
					if(rset.next())
						spl_chart_type = rset.getString(1);
					if(rset!=null) rset.close();		
					if(psmt!=null) psmt.close();


					if(spl_chart_type == null)
						spl_chart_type = "";

					if(spl_chart_type.equals("") || spl_chart_type.equals("null"))
						enableEleType = " disabled ";
					else
						enableEleType = "";
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			
				if(operation.equals(""))
			{
            _bw.write(_wl_block23Bytes, _wl_block23);
            eCA.ChartComponentFormulaBean formulaBean= null;synchronized(session){
                formulaBean=(eCA.ChartComponentFormulaBean)pageContext.getAttribute("formulaBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(formulaBean==null){
                    formulaBean=new eCA.ChartComponentFormulaBean();
                    pageContext.setAttribute("formulaBean",formulaBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block23Bytes, _wl_block23);

			try
				{			
				out.println("<script>parent.frames[1].document.ChartComponentHeaderForm.remove_value.value='' </script>");

				tabFormula = new HashMap();
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 
			

				sqlTrans = "select summary_req_yn, /*DEFINE_MODIFIABLE_AT_TRN_YN*/ config_type from ca_chart where chart_id = ?";
				pstmtTrans = con.prepareStatement(sqlTrans);
				sqlComp = "select FORMULA_DEF,SUMMARY_TYPE,SUMMRY_COLUMN,DEFAULT_DISPLAY_YN,SUM_YN,MANDATORY_YN,ELEMENT_TYPE,DEFAULT_DISPLAY_YN from ca_chart_section_comp where chart_id = ? and panel_id = ?  and discr_msr_id = ?";
				
				ps =con.prepareStatement(sqlComp);

				int count= 0;
				sqlChk = "select count(*) total from  ca_chart_section_comp where CHART_ID=? and 	rownum=1";
				psChk = con.prepareStatement(sqlChk);
				psChk.setString(1,searchVal);	
				resChk = psChk.executeQuery();
				while(resChk.next()){
					count = Integer.parseInt(resChk.getString("total"));
				}

				if(resChk!=null) resChk.close();		
				if(psChk!=null) psChk.close();

				pstmtTrans.setString(1,searchVal);
				resTrans = pstmtTrans.executeQuery();
				while(resTrans.next())
				{
					summary_req_yn = resTrans.getString(1);
					change_at_trans = resTrans.getString(2) == null?"N":resTrans.getString(2);
				}
					
				if(resTrans!=null) resTrans.close();		
				if(pstmtTrans!=null) pstmtTrans.close();
				if(summary_req_yn.equals("Y") || summary_req_yn.equals("y")){
					enableSummYN = "";
				}
				else{
					enableSummYN = " disabled ";
				}

				if(count==1){
					sql = "SELECT A.PANEL_ID SECION_ID, SECTION.SHORT_DESC SECTION_DESC, a.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE, A.PANEL_DISP_ORDER_SEQ DISPLAY_ORDER_SEQ, a.DISCR_DISP_ORDER_SEQ ORDER_SRL_NO, a.SUM_YN,DISCR_MSR.ASSOCIATE_SCORE_YN FROM ca_chart_section_comp A, AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND    SECTION.DISCR_MSR_ID = A.PANEL_ID AND   DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.PANEL_DISP_ORDER_SEQ,a.dISCR_DISP_ORDER_SEQ  ";
				}
				else{
					sql = "SELECT A.PANEL_ID SECION_ID, SECTION.SHORT_DESC SECTION_DESC, B.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE,A.DISPLAY_ORDER_SEQ, B.ORDER_SRL_NO,DISCR_MSR.ASSOCIATE_SCORE_YN  FROM CA_CHART_SECTION A,AM_DISCR_MSR_BATTERY B,AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND  B.DISCR_MSR_BATTERY_ID = A.PANEL_ID AND   SECTION.DISCR_MSR_ID = A.PANEL_ID AND   DISCR_MSR.DISCR_MSR_ID=  B.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.DISPLAY_ORDER_SEQ, B.ORDER_SRL_NO";
				}
				sqlSumm = "select short_desc from am_discr_msr where discr_msr_id = ?";
				psSumm = con.prepareStatement(sqlSumm);
				pstmtList = con.prepareStatement(sql);
				pstmtList.setString(1,searchVal);
				resList = pstmtList.executeQuery();

				boolean bRecAvl = false;
				while(resList.next())
				{
					bRecAvl = true;
					current_sec_desc = resList.getString("SECTION_DESC");
					section_id = resList.getString("SECION_ID");
					discr_msr_id = resList.getString(3);
					discr_msr_desc = resList.getString("DISCR_MSR_DESC");
					if(!(current_sec_desc.equals(section_desc))){
						out.println("<tr width='100%' id ='trGrpHeader"+j+"'><td colspan='10' class='CAGROUPHEADING'>");
						out.println("<input type ='hidden' name='group"+j+"' id='group"+j+"' value='"+current_sec_desc+"'>");
						out.println("<input type ='hidden' name='groupId"+j+"' id='groupId"+j+"' value='"+section_id+"'>");
						out.println("<input type ='hidden' name='displaySeqNumber"+j+"' id='displaySeqNumber"+j+"' value='"+resList.getInt(6)+"'>");
						if(!section_desc.equals(""))
						{
							out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+noOfRows+"'>");
							k++;
						}
						out.println(" "+current_sec_desc+" ");			
						out.println("</td>");				
						out.println("<td colspan='1' ><input type='button' class='button'  name='addNew"+k+"' id='addNew"+k+"' onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")' value= "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")+"&nbsp;"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+"></td>");
						out.println("</tr>");	

						noOfRows = 0;
						k= j;

						out.println("<input type='hidden' name='finalString"+j+"' id='finalString"+j+"' value=''>");
						j++;
						

					}

					if(i%2 == 0){
						classvalue = "gridData";
					}
					else{
						classvalue = "gridData";
					}			
					order_srl_no = resList.getString(7);
					discr_msr_id = resList.getString(3);
					discr_msr_desc = resList.getString("DISCR_MSR_DESC");
					result_type = resList.getString(5);
					//out.println("result_type ="+result_type+"=");
					discr_disp_order_seq = resList.getString(6);
					associate_score_yn = resList.getString("ASSOCIATE_SCORE_YN")==null?"N":resList.getString("ASSOCIATE_SCORE_YN");

					panel_desc_id = searchVal+":"+section_id+":"+discr_msr_id;
					recordValues = result_type+"$"+order_srl_no+"$"+discr_disp_order_seq;					
					tableForRecs.put(panel_desc_id,recordValues);

					ps.setString(1,searchVal);
					ps.setString(2,section_id);
					ps.setString(3,discr_msr_id);
//					out.println("searchVal=> "+searchVal+" section_id=>"+section_id+" discr_msr_id=>"+discr_msr_id);
					rs = ps.executeQuery();

					while(rs.next())
					{
						ctr++;
					
						summaryColumn	= rs.getString(3) == null ? "" :  rs.getString(3);
						summaryType		= rs.getString(2) == null ? "" :  rs.getString(2);
						default_yn		= rs.getString(4) == null ? "N" :  rs.getString(4);
						sum_yn			= rs.getString(5) == null ? "N" :  rs.getString(5);
						mandatory_yn	= rs.getString(6) == null ? "N" :  rs.getString(6);
						element_type	= rs.getString(7) == null ? "##" :  rs.getString(7);
						def_select		= rs.getString(8) == null ? "N"	: rs.getString(8);
						//out.println("def_select => "+def_select);

						
						if(mandatory_yn.trim().equals("Y"))
							checkedMandatory =" checked ";
						else
							checkedMandatory="";	
						
						if(summaryColumn.equals(""))
							summaryColumn = "X";

						if(summaryType.equals(""))
							summaryType = "X";	
						
						finalSummaryValue = summaryColumn + ":" +summaryType + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;
						
						tabSummary.put(panel_desc_id,finalSummaryValue);

						if(!summaryColumn.equals("X"))
						{
							psSumm.setString(1,summaryColumn);
							rsSumm = psSumm.executeQuery();
							style = "disabled ";
							readOnly="readOnly";
						
							while(rsSumm.next())
							{
								summary_col = rsSumm.getString(1) == null?"":rsSumm.getString(1);
							}
						}
						else
						{
							summary_col = "";
							style = "disabled";
							readOnly= "readOnly";
						}
					}

					if(rs != null)rs.close();
					if(rsSumm != null)rsSumm.close();

					if(change_at_trans.equals("Y"))
					{
						if(default_yn.equals("Y") && mandatory_yn.equals("Y"))
						{
							checked = "checked";
							enableDefault = " disabled ";						
						}
						else
							enableDefault = "";
					}
					else{
						checked = " checked ";
						enableDefault = " disabled ";
					}
					
					
														
					if(ctr==0)
					{
						summaryColumn = "X";
						summaryType = "X";	
						default_yn = "Y";
						sum_yn = "N";
						mandatory_yn = "N";
						change_at_trans = "Y";
						element_type = "##";

						finalSummaryValue = summaryColumn + ":" +summaryType + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;

						tabSummary.put(panel_desc_id,finalSummaryValue);			
					}

					if(!change_at_trans.equals("N")){
						if(default_yn.equals("Y") && mandatory_yn.equals("Y")) 
						{
							checked="checked";
							enableDefault = " disabled ";
						}
						else 
							checked="";
					}
					else{
						checked="checked";
						enableDefault = " disabled ";
					}

					if(def_select.equals("Y"))
						checked="checked";

					if(sum_yn.equals("Y"))
					{
						if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
						{
							checkedSumm=" checked ";
							//IN066995 Start.
							//disChkSumm = "disabled";
							disChkSumm = "";
							//IN066995 End.
							readOnly= " readOnly ";
							//IN066995 Start.
							//style = " disabled ";
							style = "";
							//IN066995 End.
						}
						else
						{
							checkedSumm="";
							disChkSumm = "disabled";
							readOnly= " readOnly ";
							style = " disabled ";
						}
					}
					else{
					
						if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
						{
							checkedSumm="";
							disChkSumm = "";
							readOnly= " readOnly ";
							style = " disabled ";
							
						}
						else
						{
							checkedSumm="";
							disChkSumm = "disabled";
							readOnly= " readOnly ";
							style = " disabled ";
							
								
							
						}
					}					

					if(summaryColumn.equals("X"))
						summaryColumn= "";
					if(summaryType.trim().equals("SUM"))
					{
						tempSum="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						 tempAvg = "";
						 tempMin = "";
						 tempMax = "";
						 //tempPct = "";
					}
					else if(summaryType.trim().equals("AVERAGE"))
					{
						tempAvg="selected";
						//IN066995 Start.
				        //disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempMin = "";
						tempMax = "";
						//tempPct = "";
					}
					else if(summaryType.trim().equals("MAXIMUM"))
					{
						tempMax="selected";	
						//IN066995 Start.
                         //disabled ="disabled";						
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						// tempPct = "";
					}
					else if(summaryType.trim().equals("MINIMUM"))
					{
						tempMin="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMax = "";
						//tempPct = "";
					}
					else if(summaryType.trim().equals("PERCENTAGE"))
					{
						//tempPct="selected";
						//IN066995 Start.
						//disabled ="disabled";
						disabled ="";
						//IN066995 End.
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						tempMax = "";
					}
					else
					{
						tempSum = "";
						tempAvg = "";
						tempMin = "";
						tempMax = "";
						//tempPct = "";
						disabled ="disabled";
					}

                    
					if(result_type.equals("A")){
						rs = ps.executeQuery();
						while(rs.next())
						{
							formula_def = rs.getString(1) == null ? "" :  rs.getString(1);
							tabFormula.put(panel_desc_id,formula_def);
						}
						if(rs!=null)rs.close();
					}

					out.println("<tr id ='trRowId"+k+noOfRows+"'>");
					out.println("<td class='gridNumericData' >"+order_srl_no+"</td><td class='" + classvalue + "' >"+discr_msr_id+"</td><td class = '"+classvalue+"' >"+discr_msr_desc+"</td>");
					out.println("<td width='5%' class = '"+classvalue+"'>");
					if(result_type.equals("A")){
						out.println("<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' class='gridLink'>");
						out.println(result_typeForDefn+"</a><input type ='hidden' name='result_type"+k+noOfRows+"' id='result_type"+k+noOfRows+"' value='"+result_type+"'></td>");
					}
					else{
						out.println("<input type ='hidden' name='result_type"+k+noOfRows+"' id='result_type"+k+noOfRows+"' value='"+result_type+"'></td>");
					}
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+noOfRows+"' id='sum_yn"+k+noOfRows+"' value='N' '"+enableSummYN+"' onclick='enableSumm("+k+","+noOfRows+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'  "+checkedSumm+"  "+disChkSumm+" ></td>");
					
					
				//	out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+noOfRows+"' id='sum_yn"+k+noOfRows+"' value='N' '"+enableSummYN+"' onclick='enableSumm("+k+","+noOfRows+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'  "+checkedSumm+"  "+disChkSumm+" ></td>");
				/**
					modified by Dinesh T on 8/4/2010 at 9:46 AM for IN022998
					invoking new functions onblur and onclick events, since two different look ups were displayed on these two events.
				**/
					out.println("<td width='12%' class = '"+classvalue+"'>");
					//IN039171 starts
					//out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")'"+disChkSumm+"><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+")'></td>"); 
					//IN057490 starts
					//out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" /*onChange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' */ OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")'><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					out.println("<input type='text' name='summary_column"+k+noOfRows+"' id='summary_column"+k+noOfRows+"' SIZE='10' value='"+summary_col+"' "+readOnly+" OnBlur='onBlursummaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");chkDupSummValues(this,"+k+","+noOfRows+")' "+disChkSumm+" ><input type ='hidden' name='summaryColumnCode"+k+noOfRows+"' id='summaryColumnCode"+k+noOfRows+"' value='"+summaryColumn+"'><input type='button' class='button' name='btnSumm"+k+noOfRows+"' id='btnSumm"+k+noOfRows+"' value='?' "+style+" onclick='summaryDefnLookup(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].summaryColumnCode"+k+noOfRows+","+k+","+noOfRows+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					//IN057490 ends
					//IN039171 ends
					out.println("<td width='5%' class = '"+classvalue+"'>");
					out.println("<SELECT name='summaryType"+k+noOfRows+"' id='summaryType"+k+noOfRows+"' "+disabled+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");checkDiscrValue(document.forms[0].summary_column"+k+noOfRows+",this)'><option value='X'>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option><option value='SUM'  "+tempSum+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SUM.label","ca_labels")+"</option><option value='AVERAGE' "+tempAvg+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AVG.label","ca_labels")+"</option><option value='MAXIMUM' "+tempMax+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"</option><option value='MINIMUM' "+tempMin+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MIN.label","common_labels")+"						</option></SELECT></td>");
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+noOfRows+",this)' name='select_yn"+noOfRows+"' id='select_yn"+noOfRows+"'  value='Y' checked></td>");
					if(result_type.equals("A"))
					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' style='display:none' name='mandatory_yn"+k+noOfRows+"' id='mandatory_yn"+k+noOfRows+"' value='N'  '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+noOfRows+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					else
					{
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+noOfRows+"' id='mandatory_yn"+k+noOfRows+"' value='N'  '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+noOfRows+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					}
						out.println("<td class = '"+classvalue+"'> <SELECT name='elementType"+k+noOfRows+"' id='elementType"+k+noOfRows+"'"+enableEleType+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
					if(elementTypes.indexOf(element_type)!=-1)
					elementTypes.insert((elementTypes.indexOf(">",elementTypes.indexOf(element_type))),"selected");

					out.println(elementTypes.toString());
					out.println("</SELECT  ></td>");
					elementTypes = new StringBuffer(elementTypes1.toString());

					out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='default_yn"+k+noOfRows+"' id='default_yn"+k+noOfRows+"' value='Y' "+checked+" '"+enableDefault+"' onclick='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					out.println("<td  style='display:none' >"+discr_disp_order_seq+"<input type='hidden' name='panel_desc_msr_id"+k+noOfRows+"' id='panel_desc_msr_id"+k+noOfRows+"' value='"+panel_desc_id+"'></td>");
					out.println("<input type='hidden' name='rowValue"+k+noOfRows+"' id='rowValue"+k+noOfRows+"' value='"+k+"'>");
					

					out.println("</tr>");
					noOfRows++;		
					i++;	
					section_desc = current_sec_desc;
				}
				
					if(!bRecAvl)
					{
						
            _bw.write(_wl_block24Bytes, _wl_block24);

					}
				//end of while
					if(resList!=null) resList.close();
					if(pstmtList!=null) pstmtList.close();
				out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+noOfRows+"'>");
							
				recordsBean.addRecords(tableForRecs);
				formulaBean.addFormula(tabFormula);
				formulaBean.setSummary(tabSummary);
				//out.println("tabSummary from jsp =="+tabSummary+"==");
				out.println("<input type='hidden' name='sequenceGrp' id='sequenceGrp' value='"+j+"'>");
			}
			catch(Exception ee)
				{
					
					ee.printStackTrace();
				}
			}//end of if
			else
			{

				tempSum = "";
				tempAvg = "";
				tempMin = "";
				tempMax = "";
				
				//tempPct = "";
				try
				{
				ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
				if(formulaBean != null)
				{
					formulaBean.clearSummary();
				}
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 
				if(formulaBean != null)
				{
					tabFormula= formulaBean.returnFormulaTab();
				}
				
				sequenceNumber = (request.getParameter("sequenceGrp") == null ) ? 0 : Integer.parseInt(request.getParameter("sequenceGrp"));
				remove_value = request.getParameter("remove_value") == null  ? "" : request.getParameter("remove_value");

				sqlAssYN = "select ASSOCIATE_SCORE_YN from AM_DISCR_MSR where DISCR_MSR_ID = ?";
				
				if(!remove_value.equals(""))
				{
					recordsBean.setFinalString(remove_value);
				}
				//commented by jupitora on 13/6/2005
				//con = ConnectionManager.getConnection(request);
				

				k=0;
				for(j =0 ; j < sequenceNumber;j++)
				{
					finalStringGrp = request.getParameter("group"+j)==null ? "" : request.getParameter("group"+j);
					finalString = request.getParameter("finalString"+j)==null ? "" : request.getParameter("finalString"+j);

					//finalString=java.net.URLDecoder.decode(finalString);
					

					section_id = request.getParameter("groupId"+j)==null ? "" : request.getParameter("groupId"+j);
					tempDispSeqNum = request.getParameter("displaySeqNumber"+j)==null ? "0" : request.getParameter("displaySeqNumber"+j);
					k = k + 0;

					if(!(finalString.equals("") || finalStringGrp.equals("") ||  section_id.equals(""))){
					out.println("<tr width='100%' id ='trGrpHeader"+k+"'> <td colspan ='10' class='CAGROUPHEADING'>");
					out.println(finalStringGrp);
					out.println("<input type ='hidden' name='group"+k+"' id='group"+k+"' value='"+finalStringGrp+"'>");
					out.println("<input type ='hidden' name='groupId"+k+"' id='groupId"+k+"' value='"+section_id+"'>");
					out.println("<input type='hidden' name='finalString"+k+"' id='finalString"+k+"' value=''>");
					out.println("<input type ='hidden' name='displaySeqNumber"+k+"' id='displaySeqNumber"+k+"' value='"+tempDispSeqNum+"'>");
					out.println("</td>");
					//out.println("<td colspan='1' ><input type='button' class='button'  onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")'   name='addNew"+k+"' id='addNew"+k+"' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartComponentAddNew.label","ca_labels")+"'></td>");		
					out.println("<td colspan='1' ><input type='button' class='button'  name='addNew"+k+"' id='addNew"+k+"' onclick='addNewRow(\""+searchVal+"\",\""+section_id+"\",\""+k+"\")' value= "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")+"&nbsp;"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+"></td>");
					out.println("</tr>");	

						tokenTilde = new  StringTokenizer(finalString,"~");
						i=0;
						while(tokenTilde.hasMoreTokens())
						{
					
							classvalue = (i % 2 == 0) ? "gridData" : "gridData" ;
							tokenPipe =new StringTokenizer(tokenTilde.nextToken(),"||");
							order_srl_no = tokenPipe.nextToken();
//							out.println("order_srl_no = "+order_srl_no);
	
							discr_msr_id = tokenPipe.nextToken();
//							out.println("discr_msr_id = "+discr_msr_id);
							discr_msr_desc= tokenPipe.nextToken();
//							out.println("discr_msr_desc = "+discr_msr_desc);
							result_type = tokenPipe.nextToken();
									
							discr_disp_order_seq =  tokenPipe.nextToken();						 
//							out.println("discr_disp_order_seq = "+discr_disp_order_seq);
							summaryColText=tokenPipe.nextToken();
//							out.println("summaryColText = "+summaryColText);
							summaryColHidden=tokenPipe.nextToken();
//							out.println("summaryColHidden = "+summaryColHidden);
							summarySelect=tokenPipe.nextToken();
//							out.println("summarySelect = "+summarySelect);
							default_yn=tokenPipe.nextToken();
//							out.println("default_yn = "+default_yn);
							sum_yn = tokenPipe.nextToken();
//							out.println("sum_yn = "+sum_yn);
//							out.println("DEE3 sum_yn="+sum_yn+"=");
							mandatory_yn = tokenPipe.nextToken();
//							out.println("mandatory_yn = "+mandatory_yn);
							change_at_trans = tokenPipe.nextToken();
								try
							{
								element_type = tokenPipe.nextToken();
							}
							catch(Exception e)
							{
								e.printStackTrace() ;
							}

							finalSummaryValue = summaryColHidden + ":" +summarySelect + ":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans + ":" + element_type;
							panel_desc_id = searchVal.trim()+":"+section_id.trim()+":"+discr_msr_id.trim();
							recordValues = result_type.trim()+"$"+order_srl_no.trim()+"$"+discr_disp_order_seq.trim();	
							
							pstmtAssYN = con.prepareStatement(sqlAssYN);
							pstmtAssYN.clearParameters();
							pstmtAssYN.setString(1,discr_msr_id);
							resAssYN = pstmtAssYN.executeQuery();
						
							while(resAssYN.next())
							{
								associate_score_yn = resAssYN.getString(1)==null?"":resAssYN.getString(1);
							}
							
							
							if(resAssYN!=null)
								resAssYN.close();
							if(pstmtAssYN!=null)
								pstmtAssYN.close();

							if(default_yn.trim().equals("Y")) 
								checked="checked";
							else
								checked="";	

							//out.println("sum_yn from JSP ---"+sum_yn+"---");
							//out.println("DEE4 sum_yn="+sum_yn+"=");
							
							if(!sum_yn.trim().equals("X"))
							{
								if(sum_yn.trim().equals("Y")){
									if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N") || result_type.equals("A"))
									{
										checkedSumm=" checked ";
										//IN066995 Start.
										//disChkSumm = "disabled";
										disChkSumm = "";
										//IN066995 End.
									}
									else
									{
										checkedSumm="";
										disChkSumm = " disabled ";
									}
								}								
								else{
									if((result_type.equals("L") && associate_score_yn.equals("Y")) || result_type.equals("I") || result_type.equals("N")  || result_type.equals("A"))
									{
										checkedSumm="";	
										disChkSumm = "";
									}
									else
									{
										checkedSumm="";	
										disChkSumm = "disabled";
									}
								}

							if(mandatory_yn.trim().equals("Y")){
								checkedMandatory =" checked ";
								//disChkSumm = " disabled ";
							}								
							else{
								checkedMandatory="";	
							}							
							}
							else
							{
								checkedSumm="";	
								disChkSumm = " disabled ";
								
							}

							tableForRecs.put(panel_desc_id,recordValues);
							tabSummary.put(panel_desc_id,finalSummaryValue);
							if(summaryColText.equals("X"))
							{
								summaryColText = "";
								readOnly ="readOnly";
								//IN066995 Start.
								//style="disabled";
								style="";
								//IN066995 End.
							}
							 else if(summaryColHidden.equals("X"))
							{
								summaryColHidden = "";	
								style="";
							}
							else
							{
								readOnly ="readOnly";
								style="disabled";
							}

							if(result_type.equals("A")){
								if(tabFormula !=null)
								{	
									formula_def = (String)tabFormula.get(panel_desc_id)==null ? "" : (String)tabFormula.get(panel_desc_id);
								
									if(tabFormula.containsKey(formula_def))
									{
										tabFormula.remove(panel_desc_id);
									}
								}
								tabFormula.put(panel_desc_id,formula_def);								
						}

						out.println("<tr id='trRowId"+k+i+"'><td width='10%' class='gridNumericData'>"+order_srl_no+"</td>");
						out.println("<td  class='" + classvalue + "'  width='15%'>"+discr_msr_id+"</td>");
						out.println("<td  class='" + classvalue + "'  width='25%'>"+discr_msr_desc+"</td>");
						out.println("<td width='10%' class = '"+classvalue+"'>");
						if(result_type.equals("A")){
							out.println("<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' class='gridLink'> ");
							out.println("Def.</a><input type ='hidden' name='result_type"+k+i+"' id='result_type"+k+i+"' value='"+result_type+"'></td>");
						}
						else{
							out.println("<input type ='hidden' name='result_type"+k+i+"' id='result_type"+k+i+"' value='"+result_type+"'> </td>");
						}
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='sum_yn"+k+i+"' id='sum_yn"+k+i+"' value='N'  "+checkedSumm+"  "+disChkSumm+" onclick='enableSumm("+k+","+i+",this);clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
						out.println("<td width='5%' class = '"+classvalue+"'>");
						out.println("<input type='text' name='summary_column"+k+i+"' id='summary_column"+k+i+"' SIZE='10' value='"+summaryColText+"' "+readOnly+" onChange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'><input type ='hidden' name='summaryColumnCode"+k+i+"' id='summaryColumnCode"+k+i+"' value='"+summaryColHidden+"'><input type='button' class='button' name='btnSumm"+k+i+"' id='btnSumm"+k+i+"' value='?' "+style+" onclick='summaryDefn(\""+panel_desc_id+"\",document.forms[0].summary_column"+k+i+",document.forms[0].summaryColumnCode"+k+i+");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' ></td>");
						out.println("<td width='10%' class = '"+classvalue+"'>");
						if(summarySelect.trim().equals("SUM"))
						{
							tempSum="selected";
							 tempAvg = "";
							 tempMin = "";
							 tempMax = "";
							//tempPct = "";
							//IN066995 Start.
							 //disabled ="disabled";
							 disabled="";
							 //IN066995 End.
						}	
						else if(summarySelect.trim().equals("AVERAGE"))
						{
							tempAvg="selected";
							tempSum = "";
							tempMin = "";
							tempMax = "";
							//tempPct = "";
							//IN066995 Start.
						   //disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else if(summarySelect.trim().equals("MAXIMUM"))
						{
							tempMax="selected";
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							//tempPct = "";
                            //IN066995 Start.
							//disabled ="disabled";							
							disabled="";
							//IN066995 End.
						}	
						else if(summarySelect.trim().equals("MINIMUM"))
						{
							tempMin="selected";
							tempSum = "";
							tempAvg = "";
							tempMax = "";
							//tempPct = "";
							//IN066995 Start.
							//disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else if(summarySelect.trim().equals("PERCENTAGE"))
						{
							//tempPct="selected";
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							tempMax = ""; 
							//IN066995 Start.
							//disabled ="disabled";
							disabled="";
							//IN066995 End.
						}
						else
						{
							tempSum = "";
							tempAvg = "";
							tempMin = "";
							tempMax = "";
							//tempPct = "";
							disabled="disabled";
						}

						if(change_at_trans.equals("Y")){
							if(default_yn.trim().equals("Y") && mandatory_yn.equals("Y")){
								checked="checked";
								enableDefault = " disabled ";
							}	
							else{
								checked="";
								enableDefault = "";
							}
						}
						else{
							checked="checked";
							enableDefault = " disabled ";
						}

						out.println("<SELECT name='summaryType"+k+i+"' id='summaryType"+k+i+"' "+disabled+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");checkDiscrValue(document.forms[0].summary_column"+k+i+",this)'><option value='X'>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--</option><option value='SUM' "+tempSum+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SUM.label","ca_labels")+"</option><option value='AVERAGE' "+tempAvg+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AVG.label","ca_labels")+"</option><option value='MAXIMUM' "+tempMax+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Max.label","common_labels")+"</option><option value='MINIMUM' "+tempMin+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MIN.label","common_labels")+"</option></SELECT></td>");
						out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+i+",this)' name='select_yn"+i+"' id='select_yn"+i+"'  value='Y' checked></td>");
						out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+i+"' id='mandatory_yn"+k+i+"' value='N' '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+i+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");
					


						/*******COMMENTED BY Deepa on 9/21/2009 at 12:56 PM for IN014076 **********************/

						//out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' OnClick='removeRow("+k+","+i+",this)' name='select_yn"+i+"' id='select_yn"+i+"'  value='Y' checked></td>");
						//out.println("<td class='" + classvalue + "' ><INPUT TYPE='checkbox' name='mandatory_yn"+k+i+"' id='mandatory_yn"+k+i+"' value='N' '"+checkedMandatory+"' onclick='chkAndDisableDef(this,document.forms[0].default_yn"+k+i+",\""+change_at_trans+"\");clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")'></td>");

						/*******COMMENTED BY Deepa on 9/21/2009 at 12:56 PM for IN014076 **********************/				

						out.println("<td class = '"+classvalue+"'> <SELECT name='elementType"+k+i+"' id='elementType"+k+i+"'"+enableEleType+" onchange='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+noOfRows+",document.forms[0].summaryType"+k+noOfRows+",document.forms[0].summary_column"+k+noOfRows+",document.forms[0].default_yn"+k+noOfRows+",document.forms[0].sum_yn"+k+noOfRows+",document.forms[0].mandatory_yn"+k+noOfRows+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'><option value='##'>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");
						if(elementTypes.indexOf(element_type)!=-1)
						elementTypes.insert((elementTypes.indexOf(">",elementTypes.indexOf(element_type))),"selected");

						out.println(elementTypes.toString());
						out.println("</SELECT  ></td>");
						elementTypes = new StringBuffer(elementTypes1.toString());
					

						out.println("<td  class='" + classvalue + "' ><INPUT TYPE='checkbox' name='default_yn"+k+i+"' id='default_yn"+k+i+"' value='Y' "+checked+" '"+enableDefault+"' onclick='clickOK(\""+panel_desc_id+"\",document.forms[0].summaryColumnCode"+k+i+",document.forms[0].summaryType"+k+i+",document.forms[0].summary_column"+k+i+",document.forms[0].default_yn"+k+i+",document.forms[0].sum_yn"+k+i+",document.forms[0].mandatory_yn"+k+i+",\""+change_at_trans+"\",document.forms[0].elementType"+k+noOfRows+")' ></td>");
						out.println("<td  style='display:none' >"+discr_disp_order_seq+"<input type='hidden' name='panel_desc_msr_id"+k+i+"' id='panel_desc_msr_id"+k+i+"' value='"+panel_desc_id+"'></td>");
						out.println("<input type='hidden' name='rowValue"+k+i+"' id='rowValue"+k+i+"' value='"+k+"'>");
						out.println("</tr>");	
						i++;	
				 }
				out.println("<input type ='hidden' name='noOfRows"+k+"' id='noOfRows"+k+"' value='"+i+"'>");
				
				k++;
    			}
		  }

		   recordsBean.addRecords(tableForRecs);
		   formulaBean.addFormula(tabFormula);
		   formulaBean.setSummary(tabSummary);

		   out.println("<input type='hidden' name='sequenceGrp' id='sequenceGrp' value='"+k+"'>");
			}
			catch(Exception e)
			{
				out.println("Exception @ else block ChartComponentList.jsp"+e.toString());
				e.printStackTrace();
			}
		  
		}//end of else
		out.println("<input type='hidden' name='sequence' id='sequence' value='"+i+"'>");
		out.println("<input type='hidden' name='chartCompSearch' id='chartCompSearch' value='"+searchVal+"'>");
		out.println("<input type='hidden' name='operation' id='operation' value=''>");
		out.println("<input type='hidden' name='remove_value' id='remove_value' value=''>");

            _bw.write(_wl_block25Bytes, _wl_block25);

				if(change_at_trans.equals("N")){
				
            _bw.write(_wl_block26Bytes, _wl_block26);
	
				}	
	//	if(rsSumm!=null) rsSumm.close();
		if(psSumm!=null) psSumm.close();
		
		if(ps!=null)ps.close();
		if(resList!=null) resList.close();
		if(pstmtList!=null) pstmtList.close();
	
	}//end of try-1 
	catch(Exception e){
		//out.println("Exception in try-1 of ChartComponentList.jsp:"+e.toString());//common-icn-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	finally{
		
	
		if(con!=null) ConnectionManager.returnConnection(con,request);
		/*if (tableForRecs!=null)
			tableForRecs.clear();
		if (tabFormula!=null)
			tabFormula.clear();
		if (tabSummary!=null)
			tabSummary.clear();*/
	}

	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(summary_req_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(change_at_trans));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(elementTypes1.toString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enableEleType));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChartComponentList.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderSequenceNumber.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiscreteMeasureCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiscreteMeasure.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Formula.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SummaryRequired.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SummaryColumn.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SummaryType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Element.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }
}
