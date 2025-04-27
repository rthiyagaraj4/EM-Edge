package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCA.ChartComponentFormulaBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartcomponentbeanintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartComponentBeanIntermediate.jsp", 1709115651246L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>Bean JSP</title>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<BODY CLASS=\"MESSAGE\" onKeyDown=\"lockKey()\">\n\t<form name=\'tempformformula\' id=\'tempformformula\'>\n\n\t<p align=\"left\">\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t alert(getMessage(\"EXP_VALID\",\"CA\"));\t\n\t\t\t\t\t\t\t\t window.returnValue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t</script>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"EXP_VALID\",\"CA\"));\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"EXP_INVALID\",\"CA\"));\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</p>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t<script>\n\t\t\t\t\tparent.chartComponentListFrame.document.ChartComponentListForm.sum_req.value = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\tparent.chartComponentListFrame.document.ChartComponentListForm.change_trans.value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
		HashMap tabFormula = null;
		HashMap tabSummary = null;

		String sqlFormulaParser = "select distinct CA_GET_FORMULA_STRING(?) formula from CA_CHART_SECTION_COMP"; 

		String formulaString = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
		eCA.ChartComponentResultsetBean recordsBean = (eCA.ChartComponentResultsetBean)session.getAttribute("recordsBean");
		
		String calledFrom=request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		try
		{
			con = ConnectionManager.getConnection(request);
	
			if(!calledFrom.equals("addRow")&&!calledFrom.equals("Summary") && !calledFrom.equals("SummaryFromSecond") && !calledFrom.equals("default"))
			{
				String panel_desc_id_Content = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
				String detail=request.getParameter("formulaDefinition")==null?"":request.getParameter("formulaDefinition");

				try
				{
					pstmt = con.prepareStatement(sqlFormulaParser);
					pstmt.setString(1,detail);

					res = pstmt.executeQuery();

					while(res.next())
					{
						formulaString = res.getString("formula") == null ? "" : res.getString("formula");
					}

					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}

			eCA.ExpressionParser parser = new eCA.ExpressionParser();

			if(!formulaString.equals(""))
			{
				if(parser.checkForValidity(formulaString.replace('~',' ')))
				{
					if(calledFrom.equals("OK"))
					{
						
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(detail));
            _bw.write(_wl_block7Bytes, _wl_block7);

						
						if(formulaBean != null)
						{
							tabFormula = formulaBean.returnFormulaTab();
							if(tabFormula != null)
							{
								if(tabFormula.containsKey(panel_desc_id_Content)== true)
									tabFormula.remove(panel_desc_id_Content);
								tabFormula.put(panel_desc_id_Content,detail);
							}
						}
						
            _bw.write(_wl_block8Bytes, _wl_block8);

					}
					else if(calledFrom.equals("VALIDATE"))
					{
						
            _bw.write(_wl_block9Bytes, _wl_block9);

					}
				}
				else
				{
					
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
			}
			else
			{
				if(formulaBean != null)
				{
					tabFormula = formulaBean.returnFormulaTab();

					if(tabFormula != null)
					{
						if(tabFormula.containsKey(panel_desc_id_Content)== true)
							tabFormula.remove(panel_desc_id_Content);
					
						tabFormula.put(panel_desc_id_Content,detail);
					}
				}
			}
		
			parser = null;
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		
		if(calledFrom.equals("Summary"))
		{
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			String SummaryType = request.getParameter("SummaryType")==null?"":request.getParameter("SummaryType");
			String elementType = request.getParameter("element_type")==null?"":request.getParameter("element_type");

			String summaryColumn =  request.getParameter("SummaryColumn")==null?"":request.getParameter("SummaryColumn");
			String mandatory_yn=  request.getParameter("mandatory_yn")==null?"":request.getParameter("mandatory_yn");
			String default_yn=  request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
			String change_at_trans = request.getParameter("change_at_trans")==null?"":request.getParameter("change_at_trans");
			String sum_yn=  request.getParameter("sum_yn")==null?"":request.getParameter("sum_yn");
			String finalSummary = summaryColumn + ":" + SummaryType +":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans+":" +  elementType;	

			if(formulaBean != null)
			{
				tabSummary = formulaBean.getSummary();

				if(tabSummary != null)
				{
					if(tabSummary.containsKey(panel_desc_id)== true)
						tabSummary.remove(panel_desc_id);

					tabSummary.put(panel_desc_id,finalSummary);
				}
			}
		}

		if(calledFrom.equals("addRow"))
		{
			StringBuffer finalString  = new StringBuffer();
			String chart_id = request.getParameter("chart_id")==null?"":request.getParameter("chart_id");
			String summ_req_yn = "";
			String change_at_trans = "";
			PreparedStatement psSumDef = null;
			ResultSet resSumDef = null;

			try
			{
				String sqlSumDef = "select summary_req_yn, CONFIG_TYPE from ca_chart where chart_id = ?";
				psSumDef = con.prepareStatement(sqlSumDef);
				psSumDef.setString(1,chart_id);
				resSumDef = psSumDef.executeQuery();
				while(resSumDef.next())
				{
					summ_req_yn = resSumDef.getString(1);
					change_at_trans = resSumDef.getString(2);
				}
	
				if (resSumDef != null) resSumDef.close();
				if (psSumDef != null) psSumDef.close();
			}
			catch(Exception e)
			{
					//out.println("Exception in try-1 of ChartComponentBeanIntermediate.jsp"+e.toString());//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
			}
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(summ_req_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(change_at_trans));
            _bw.write(_wl_block14Bytes, _wl_block14);


			String retVal = request.getParameter("retVal")==null?"":request.getParameter("retVal");
			String retValFlag =""; 
			String tempString = "";

			if(!retVal.equals(""))
			{
				retValFlag=formulaBean.getretValString()==null ? "" :formulaBean.getretValString() ;
			
				if(retValFlag.equals(""))
					finalString.append(retVal);
				else
				{
					tempString  = retValFlag + "~"  + retVal;
					finalString.append(tempString);
				}

				formulaBean.setretValString(finalString.toString());
			}			
		}		

		if(calledFrom.equals("SummaryFromSecond"))
		{
			String elementType = request.getParameter("element_type")==null?"":request.getParameter("element_type");
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			String SummaryType = request.getParameter("SummaryType")==null?"":request.getParameter("SummaryType");
			String summaryColumn =  request.getParameter("SummaryColumn")==null?"":request.getParameter("SummaryColumn");
			String mandatory_yn=  request.getParameter("mandatory_yn")==null?"":request.getParameter("mandatory_yn");
			String default_yn=  request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
			String change_at_trans = request.getParameter("change_at_trans")==null?"":request.getParameter("change_at_trans");
			String sum_yn =  request.getParameter("sum_yn")==null?"N":request.getParameter("sum_yn");
			String finalSummary = summaryColumn + ":" + SummaryType +":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans+":" +  elementType;
			String recordValues = request.getParameter("recordValues")==null?"":request.getParameter("recordValues");

			if(formulaBean != null)
			{
				tabSummary = formulaBean.getSummary();
		
				if(tabSummary != null)
				{
					if(tabSummary.containsKey(panel_desc_id)== true)
						tabSummary.remove(panel_desc_id);

					tabSummary.put(panel_desc_id,finalSummary);					
					formulaBean.setSummary(tabSummary);
				}
			}		

			if(recordsBean != null)
			{
				HashMap tabRecords = recordsBean.getRecords();
		
				if(tabRecords != null)
				{
					if(tabRecords.containsKey(panel_desc_id)== true)
						tabRecords.remove(panel_desc_id);
					tabRecords.put(panel_desc_id,recordValues);
					recordsBean.addRecords(tabRecords);
				}
			}	
		}		

		if(calledFrom.equals("default"))
		{
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			StringTokenizer tokenPipe = null;
			StringTokenizer tokenTilde=null;
			String finalSummary = "";
			String discr_msr_id = "";
			String finalConcatenatedString = request.getParameter("finalString")==null?"":request.getParameter("finalString");
			
			if(!panel_desc_id.equals("") && ! finalConcatenatedString.equals(""))
			{
				tokenPipe = new 	StringTokenizer(panel_desc_id ,"||");
				tokenTilde = new 	StringTokenizer(finalConcatenatedString ,"~");
			
				while(tokenPipe.hasMoreTokens() && tokenTilde.hasMoreTokens())
				{
					discr_msr_id = tokenPipe.nextToken().trim();
					finalSummary = tokenTilde.nextToken().trim();
				
					if(formulaBean != null)
					{
						tabSummary = formulaBean.getSummary();
						
						if(tabSummary != null)
						{
							if(tabSummary.containsKey(discr_msr_id)== true)
								tabSummary.remove(discr_msr_id);

							tabSummary.put(discr_msr_id,finalSummary);
						}
					}	
				 }
			}
		}
	}
	catch(Exception excep)
	{
		
		excep.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
