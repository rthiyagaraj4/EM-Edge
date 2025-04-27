package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCA.ChartComponentFormulaBean;
import eCA.ChartComponentResultsetBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartcomponentintermediateaddpanel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/chartComponentIntermediateAddPanel.jsp", 1709115655106L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ChartComponent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onKeyDown=\"lockKey()\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tdisplayDiscrMsrForPanel(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			String chart_id = request.getParameter("chart_id") == null?"":request.getParameter("chart_id");		
			String panel_id = request.getParameter("panel_id") == null?"":request.getParameter("panel_id");
			String display_order_seq = request.getParameter("display_order_seq") == null?"":request.getParameter("display_order_seq");
			//String seqGrpVal = request.getParameter("seqGrpVal") == null?"":request.getParameter("seqGrpVal");
			StringBuffer  finalString = new StringBuffer();
			String order_serial_no = "";
			String discr_msr_desc = "";
			String discr_msr_id = "";
			String result_type = "";
			String summary_yn = "";
			String summary_column = "";
			String summary_type = "";
			String default_yn = "";			
			String sqlAddDiscrMsr = "";
			String associate_score_yn = "";
			//String disc_disp_order_seq = "";
			String sqlChartComp = "";
			String formulaDefn = "";
			//String formulaDefnForDisp = "";
			String sqlSumm = "";
			//String sum_col = "";
			//String tempSum = "";
			//String tempAvg = "";
			//String tempMin = "";
			//String tempMax = "";
			//String	 tempPct = "";
			//String disabled ="";
			//String readOnly = "";
			//String disChkSumm = "";
			//String checked = "";
			//String checkedSumm = "";
			//String style = "";
			//String finalSummaryValue = "";
			StringBuffer finalSummaryValue = new StringBuffer();
			String panel_desc_id = "";
			String recordValues = "";
			String mandatory_yn = "";

			String summary_req_yn = "";
			String change_at_trans = "";
			String sqlTrans = "";
			String element_type = "##";
			
			HashMap tabFormula = null;
			HashMap tableForRecs = null;
			HashMap tabSummary = null;

			int counter = 0;
			int i = 0;

			Connection con = null;
			PreparedStatement psAddDiscrMsr = null;
			PreparedStatement psChartComp = null;
			PreparedStatement psSumm = null;
			ResultSet rsAddDiscrMsr = null;
			ResultSet rsChartComp = null;
			ResultSet rsSumm = null;
			PreparedStatement psTrans = null;
			ResultSet resTrans = null;

			try{

				tabFormula = new HashMap();
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 

				con = ConnectionManager.getConnection(request);

				ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
				ChartComponentResultsetBean recordsBean  = (ChartComponentResultsetBean)session.getAttribute("recordsBean");

				tableForRecs = recordsBean.getRecords();
				tabSummary = formulaBean.getSummary();
			
				sqlChartComp = "select FORMULA_DEF,SUMMARY_TYPE,SUMMRY_COLUMN,DEFAULT_DISPLAY_YN,SUM_YN,MANDATORY_YN,ELEMENT_TYPE from ca_chart_section_comp where chart_id = ? and panel_id = ?  and discr_msr_id = ?";
				psChartComp =con.prepareStatement(sqlChartComp);

				sqlTrans = " select summary_req_yn, config_type from ca_chart where chart_id = ?"; 
				psTrans = con.prepareStatement(sqlTrans);
				psTrans.setString(1,chart_id);
				resTrans = psTrans.executeQuery();
				while(resTrans.next()){
					summary_req_yn = resTrans.getString(1);
					change_at_trans = resTrans.getString(2) == null ? "N" : resTrans.getString(2);					
				}
				if(resTrans!=null) resTrans.close();
				

				sqlAddDiscrMsr = "select A.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE, A.ORDER_SRL_NO,DISCR_MSR.ASSOCIATE_SCORE_YN from AM_DISCR_MSR_BATTERY A, AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.DISCR_MSR_BATTERY_ID = ? AND   SECTION.DISCR_MSR_ID = A.DISCR_MSR_BATTERY_ID and DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.ORDER_SRL_NO ";
				
				psAddDiscrMsr = con.prepareStatement(sqlAddDiscrMsr);
				//psAddDiscrMsr.setString(1,chart_id);
				psAddDiscrMsr.setString(1,panel_id);
				
				rsAddDiscrMsr = psAddDiscrMsr.executeQuery();
				
				while(rsAddDiscrMsr.next()){					
					i++;
					
					order_serial_no = rsAddDiscrMsr.getString("ORDER_SRL_NO") == null?"":rsAddDiscrMsr.getString("ORDER_SRL_NO");


					discr_msr_desc = rsAddDiscrMsr.getString("DISCR_MSR_DESC") == null?"":rsAddDiscrMsr.getString("DISCR_MSR_DESC");
					discr_msr_id = rsAddDiscrMsr.getString(1) == null?"":rsAddDiscrMsr.getString(1);
					result_type = rsAddDiscrMsr.getString(3) == null?"":rsAddDiscrMsr.getString(3);
					associate_score_yn = rsAddDiscrMsr.getString("ASSOCIATE_SCORE_YN") == null?"N":rsAddDiscrMsr.getString("ASSOCIATE_SCORE_YN");

					//disc_disp_order_seq = rsAddDiscrMsr.getString("DISPLAY_ORDER_SEQ") == null?"":rsAddDiscrMsr.getString("DISPLAY_ORDER_SEQ") ;
				
					panel_desc_id = chart_id + ":" + panel_id + ":" + discr_msr_id;
					recordValues = result_type+"$"+order_serial_no+"$"+display_order_seq;

					tableForRecs.put(panel_desc_id,recordValues);
					//recordsBean.addRecords(tableForRecs);

					sqlSumm = "select short_desc from am_discr_msr where discr_msr_id = ?";
					psSumm = con.prepareStatement(sqlSumm);

					psChartComp.setString(1,chart_id);
					psChartComp.setString(2,panel_id);
					psChartComp.setString(3,discr_msr_id);
					rsChartComp = psChartComp.executeQuery();


					while(rsChartComp.next()){
						counter++;
										
						summary_type = rsChartComp.getString(2) ==null?"":rsChartComp.getString(2);
						summary_column = rsChartComp.getString(3) ==null?"":rsChartComp.getString(3);
						default_yn = rsChartComp.getString(4) ==null? "N":rsChartComp.getString(4);
						summary_yn = rsChartComp.getString(5) == null? "N":rsChartComp.getString(5) ;
						mandatory_yn = rsChartComp.getString(6) == null? "N":rsChartComp.getString(6) ;
						element_type = rsChartComp.getString(7) == null? "##":rsChartComp.getString(7) ;


						if(summary_column.equals(""))
							summary_column = "X";
						if(summary_type.equals(""))
							summary_type = "X";	
						finalSummaryValue.append(summary_column + ":" +summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans+ ":" + element_type);
						tabSummary.put(panel_desc_id,finalSummaryValue.toString());
						//formulaBean.setSummary(tabSummary);

						if(!summary_column.equals("X")){
							psSumm.setString(1,summary_column);
							rsSumm = psSumm.executeQuery();
							//style = " disabled ";
							//readOnly=" readOnly ";
							while(rsSumm.next()){
								//sum_col = rsSumm.getString(1) == null?"":rsSumm.getString(1);
							}

                          if(rsSumm!=null) rsSumm.close(); 
                          if(psSumm!=null) psSumm.close();

						}
						else{
							//sum_col = "";
							//style = " disabled ";
							//readOnly= " readOnly ";
						}


					}
					if(counter==0){
						summary_column = "X";
						summary_type = "X";	
						default_yn = "Y";
						summary_yn = "N";
						mandatory_yn = "N";
						element_type = "##";

						//finalSummaryValue = summary_column + ":" +summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans;
						finalSummaryValue = new StringBuffer();
						finalSummaryValue.append(summary_column + ":" + summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans+ ":" + element_type);

						tabSummary.put(panel_desc_id,finalSummaryValue.toString());
						//formulaBean.setSummary(tabSummary);
					}

				/*	if(default_yn.equals("Y")) 
						//checked="checked";
					else 
						//checked="";
				*/

					if(summary_yn.equals("Y")){
						//checkedSumm=" checked ";
						//disChkSumm = " disabled ";
						//readOnly= " readOnly ";
						//style = " disabled ";
					}
					else{
						//checkedSumm="";
						//disChkSumm = "";
						//readOnly= " readOnly ";
						//style = " disabled ";
					}					

					if(summary_column.equals("X"))
						summary_column= "";
					if(summary_type.trim().equals("SUM"))
					{
						//tempSum="selected";
						//disabled ="disabled";
						// tempAvg = "";
						// tempMin = "";
						 //tempMax = "";
						 //tempPct = "";
					}
					else if(summary_type.trim().equals("AVERAGE"))
					{
						//tempAvg="selected";
						//disabled ="disabled";
						//tempSum = "";
						//tempMin = "";
						//tempMax = "";
						//tempPct = "";
					}
					else if(summary_type.trim().equals("MAXIMUM"))
					{
						//tempMax="selected";						
						//disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						// tempPct = "";
					}
					else if(summary_type.trim().equals("MINIMUM"))
					{
						//tempMin="selected";disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMax = "";
						//tempPct = "";
					}
					else if(summary_type.trim().equals("PERCENTAGE"))
					{
						//tempPct="selected";disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						//tempMax = "";
					}
					else
					{
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						//tempMax = "";
						//tempPct = "";
						//disabled ="disabled";
					}
					if(result_type.equals("A")){

						if(rsChartComp !=null) rsChartComp.close();
						rsChartComp = psChartComp.executeQuery();
						while(rsChartComp.next())
						{
							formulaDefn = rsChartComp.getString(1) == null ? "" : rsChartComp.getString(1);
							tabFormula.put(panel_desc_id,formulaDefn);
						}
						if(rsChartComp !=null) rsChartComp.close();
					}
					if(finalString.toString().equals("")){
						finalString.append(discr_msr_desc+ "||" + discr_msr_id +"||"+ order_serial_no + "||" + result_type+"||"+associate_score_yn);
					}
					else
					{
						finalString.append( "~" +discr_msr_desc+ "||" + discr_msr_id +"||"+ order_serial_no + "||" + result_type+"||"+associate_score_yn);
					}


				recordsBean.addRecords(tableForRecs);
				formulaBean.addFormula(tabFormula);
				formulaBean.setSummary(tabSummary);

				}				
				if(finalString.toString().length() != 0){
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(panel_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(finalString.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(summary_req_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(change_at_trans));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mandatory_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(associate_score_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
				
				}
			
			}//end of try-1
			catch(Exception e){
				//out.println("Exception in try-1 of chartComponentIntermediateAddPanel.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				/*tableForRecs.clear();
				tabFormula.clear();
				tabSummary.clear();*/

			if(rsAddDiscrMsr!=null) rsAddDiscrMsr.close();
			
			
			if(resTrans!=null) resTrans.close();
			if(psAddDiscrMsr!=null) psAddDiscrMsr.close();
			if(psChartComp!=null) psChartComp.close();
			
			if(psTrans!=null) psTrans.close();
			

				if(con!=null) ConnectionManager.returnConnection(con,request);
			}

            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChartComponentAddPanel.label", java.lang.String .class,"key"));
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
