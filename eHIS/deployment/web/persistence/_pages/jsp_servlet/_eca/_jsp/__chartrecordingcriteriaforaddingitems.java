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

public final class __chartrecordingcriteriaforaddingitems extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingCriteriaForAddingItems.jsp", 1709115663074L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/ChartRecording.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\n<form name=\'chartRecordingCriteriaForm\' id=\'chartRecordingCriteriaForm\' method=\'post\' action =\'../../servlet/eCA.ChartRecordingCriteriaServlet\'>\n<table class=\'grid\' width=\'100%\' id=\'titleTable\' >\n<tr>\n<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nif(parent.chartRecordingBottomFrame != null)\nparent.chartRecordingBottomFrame.location.href=\'../../eCA/jsp/ChartRecordingToolBarForAddItems.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n</script>\n</form>\n</table>\n</body>\t\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

Connection con = null;

PreparedStatement psSql = null;
PreparedStatement psSelect = null;
PreparedStatement psSelectTrn = null;

ResultSet rsSql = null;
ResultSet rsSelect = null;	
ResultSet rsSelectTrn = null;	

try
{
	con = ConnectionManager.getConnection(request);

	int index=0;
	int count = 0;
	int recordCount = 0;
	int countTrn = 0;
	
	String facilityId =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	String chartId = request.getParameter("chartId")==null ? "" :request.getParameter("chartId") ;
	String encounterId = request.getParameter("encounterId")==null ? "" :request.getParameter("encounterId");
	String sqlCheck = "select count(*) from CA_ENCNTR_CHART_DRAFT where ENCOUNTER_ID=? and CHART_ID= ? AND FACILITY_ID = ?";
	
	psSelect = con.prepareStatement(sqlCheck);
	psSelect.setString(1,encounterId);
	psSelect.setString(2,chartId);
	psSelect.setString(3,facilityId);
	rsSelect = psSelect.executeQuery();

	while(rsSelect.next())
	{
		recordCount = rsSelect.getInt(1);
	}
	
	if(rsSelect != null)rsSelect.close();
	if(psSelect != null)psSelect.close();

	sqlCheck = "select count(*) from  CA_ENCNTR_DISCR_MSR where ENCOUNTER_ID=? and CHART_ID= ? and FACILITY_ID = ? and DISCR_MSR_ID=? ";
	
	psSelectTrn = con.prepareStatement(sqlCheck);
	psSelectTrn.setString(1,encounterId);
	psSelectTrn.setString(2,chartId);
	psSelectTrn.setString(3,facilityId);
	
	sqlCheck = "select count(*) from CA_ENCNTR_CHART_DRAFT where FACILITY_ID = ? AND ENCOUNTER_ID=? and CHART_ID= ?  and PANEL_ID=? and  DISCR_MSR_ID=?";
	psSelect = con.prepareStatement(sqlCheck);
	psSelect.setString(1,facilityId);
	psSelect.setString(2,encounterId);
	psSelect.setString(3,chartId);

	String sql = "SELECT A.PANEL_ID SECTION_ID, AM_GET_DESC.AM_DISCR_MSR(A.PANEL_ID,?,'2')  SECTION_DESC, a.DISCR_MSR_ID discr_msr_id, AM_GET_DESC.AM_DISCR_MSR(A.DISCR_MSR_ID,?,'2') DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE result_type, A.PANEL_DISP_ORDER_SEQ DISPLAY_ORDER_SEQ, a.DISCR_DISP_ORDER_SEQ ORDER_SRL_NO, a.DEFAULT_DISPLAY_YN,a.SUMMARY_TYPE, a.SUMMRY_COLUMN, a.SUM_YN,a.FORMULA_DEF formula_def,a.mandatory_yn FROM ca_chart_section_comp A, AM_DISCR_MSR DISCR_MSR WHERE A.CHART_ID=? AND  DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y'  ORDER BY A.PANEL_DISP_ORDER_SEQ,a.dISCR_DISP_ORDER_SEQ";
	String sectionId = "";
	String prevSectionId = "";
	String sectionDesc = "";
	String discrMsrId = "";
	String discrMsrDesc = "";
	String resultType = "";
	String displayOrderSeqNo = "";
	String orderSrlNo = "";
	String formulaDef = "";
	String defaultYN = "";
	String sumYN = "";
	String summaryColumn = "";
	String summaryType = "";
	String classValue ="";
	String mandatory_yn="";

	psSql = con.prepareStatement(sql);
	psSql.setString(1,locale);
	psSql.setString(2,locale);
	psSql.setString(3,chartId);

	rsSql = psSql.executeQuery();
	
	while(rsSql.next())
	{
		classValue = (index % 2) == 0 ? "gridData" : "gridData";
		sectionId = 	rsSql.getString("SECTION_ID") == null ? "" : rsSql.getString("SECTION_ID");
	
		if(!prevSectionId.equals(sectionId))
		{
			out.println("<tr>");		
			sectionDesc = rsSql.getString("SECTION_DESC") == null ? "" : rsSql.getString("SECTION_DESC");
			out.println("<td colspan='2' class='CAGROUPHEADING'>"+sectionDesc+"</td>");		
			out.println("</tr>");
			prevSectionId = sectionId;
		}
		
		out.println("<tr>");		
		out.println("<td class='"+classValue+"'>");		
		out.println("<input type='hidden' name='sectionId"+index+"' id='sectionId"+index+"' value='"+sectionId+"'>");
		discrMsrDesc =  rsSql.getString("DISCR_MSR_DESC") == null ? "" : rsSql.getString("DISCR_MSR_DESC");
		discrMsrId =  rsSql.getString("discr_msr_id") == null ? "" : rsSql.getString("discr_msr_id");
		psSelect.setString(4,sectionId);
		psSelect.setString(5,discrMsrId);
		rsSelect =psSelect.executeQuery();
		
		while(rsSelect.next())
		{
			count = rsSelect.getInt(1);
		}
		
		if(rsSelect != null)rsSelect.close();

		resultType=   rsSql.getString("result_type") == null ? "" : rsSql.getString("result_type");
		displayOrderSeqNo=   rsSql.getString("DISPLAY_ORDER_SEQ") == null ? "" : rsSql.getString("DISPLAY_ORDER_SEQ");
		orderSrlNo=   rsSql.getString("ORDER_SRL_NO") == null ? "" : rsSql.getString("ORDER_SRL_NO");
		formulaDef =  rsSql.getString("formula_def") == null ? "" : rsSql.getString("formula_def");
		sumYN =  rsSql.getString("SUM_YN") == null ? "N" : rsSql.getString("SUM_YN");

		if(sumYN.equals("") || sumYN.equals("null") || sumYN.equals("NULL")) 
			sumYN = "N";

		summaryColumn = rsSql.getString("SUMMRY_COLUMN") == null ? "N" : rsSql.getString("SUMMRY_COLUMN");
		summaryType =  rsSql.getString("SUMMARY_TYPE") == null ? "" : rsSql.getString("SUMMARY_TYPE");
		mandatory_yn =  rsSql.getString("mandatory_yn") == null ? "" : rsSql.getString("mandatory_yn");
		
		if(mandatory_yn.equals("null") || mandatory_yn.equals("") || mandatory_yn.equals("NULL"))
			mandatory_yn = "N";

		out.println("<input type='hidden' name='discrMsrId"+index+"' id='discrMsrId"+index+"' value='"+discrMsrId+"'>");
		out.println("<input type='hidden' name='resultType"+index+"' id='resultType"+index+"' value='"+resultType+"'>");
		out.println("<input type='hidden' name='displayOrderSeqNo"+index+"' id='displayOrderSeqNo"+index+"' value='"+displayOrderSeqNo+"'>");
		out.println("<input type='hidden' name='orderSrlNo"+index+"' id='orderSrlNo"+index+"' value='"+orderSrlNo+"'>");
		out.println("<input type='hidden' name='formulaDef"+index+"' id='formulaDef"+index+"' value='"+formulaDef+"'>");
		out.println("<input type='hidden' name='sumYN"+index+"' id='sumYN"+index+"' value='"+sumYN+"'>");
		out.println("<input type='hidden' name='summaryColumn"+index+"' id='summaryColumn"+index+"' value='"+summaryColumn+"'>");
		out.println("<input type='hidden' name='summaryType"+index+"' id='summaryType"+index+"' value='"+summaryType+"'>");
		out.println("<input type='hidden' name='mandatory_yn"+index+"' id='mandatory_yn"+index+"' value='"+mandatory_yn+"'>");
		
		out.println(discrMsrDesc);	
		
		if(mandatory_yn.equals("Y"))
			out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");

		out.println("</td>");	
		defaultYN =  rsSql.getString("DEFAULT_DISPLAY_YN") == null ? "" : rsSql.getString("DEFAULT_DISPLAY_YN");
		
		
		if(recordCount ==0)
		{	
			if(defaultYN.equals("Y"))
			{
				if(mandatory_yn.equals("Y"))
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked  disabled value='Y'></td>");
				else
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked   value='Y'></td>");
			}
			else
				out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' ></td>");
		}
		else
		{
			psSelectTrn.setString(4,discrMsrId);
			rsSelectTrn = psSelectTrn.executeQuery();

			while(rsSelectTrn.next())
			{
				countTrn = rsSelectTrn.getInt(1);
			}	
	
			
			if(count !=0)
			{
				if(countTrn !=0)
					out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked disabled></td>");
				else
				{
					if(mandatory_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked disabled></td>");
					else
						out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' checked ></td>");
				}
			}
			else
				out.println("<td class='"+classValue+"'><INPUT TYPE='checkbox' name='defaultYNCheck"+index+"' id='defaultYNCheck"+index+"' ></td>");
		}

		out.println("<input type='hidden' name='defaultYN"+index+"' id='defaultYN"+index+"' value=''>");
		out.println("</tr>");		
		index++;
	}
	
	if(psSelect != null)psSelect.close();
	if(rsSelectTrn != null)rsSelectTrn.close();
	if(psSelectTrn != null)psSelectTrn.close();
	if(rsSql != null)rsSql.close();
	if(psSql != null)psSql.close();

	out.println("<input type='hidden' name='index' id='index' value='"+index+"'>");
	out.println("<input type='hidden' name='chartId' id='chartId' value='"+chartId+"'>");
	out.println("<input type='hidden' name='encounterId' id='encounterId' value='"+encounterId+"'>");
	out.println("<input type='hidden' name='flagMsg' id='flagMsg' value=''>");

            _bw.write(_wl_block1Bytes, _wl_block1);

}
catch(Exception ee)
{
	//out.println("Exception from ChartRecordingCriteriaForAddingItems.jsp "+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null)ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Events.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
}
