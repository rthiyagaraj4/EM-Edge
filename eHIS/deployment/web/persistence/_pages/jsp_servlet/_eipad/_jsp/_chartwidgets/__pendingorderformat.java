package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.List;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.pendingorders.response.PendingOrderFormatResponse;
import java.util.ArrayList;
import eCommon.Common.CommonBean;

public final class __pendingorderformat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/PendingOrderFormat.jsp", 1709118020162L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n<div style=\"width:100%;\" data-role = \"none\">\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<table cellpadding=3 cellspacing=0 border=0 align=center width=\'100%\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<td  width=\'25%\'>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<td width=\'25%\' colspan=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" ><TEXTAREA NAME=\'\' ROWS=\'3\' COLS=\'30\' readOnly>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TEXTAREA></td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<td  style=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  width=\'25%\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td  width=\'25%\' colspan=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><input type=checkbox value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="></td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td width=\'25%\' style=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</B></td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</tr>\n</table>\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<div class=\"WidgetVwErrContainer\">\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t</div>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\n</div>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

PendingOrderFormatResponse orderFormatResp = (PendingOrderFormatResponse)request.getAttribute("POFormatResponse");
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(orderFormatResp!=null){
	errorList = orderFormatResp.getErrorsList();
}


            _bw.write(_wl_block3Bytes, _wl_block3);

	String lineId = request.getParameter("LineNum")==null?"":request.getParameter("LineNum");
		if(orderFormatResp.isSuccessResponse()&&!orderFormatResp.isEmptyDataResponse()){
			List<String[]> order_format_dtl = orderFormatResp.getOrderFormatDtl();
			if(order_format_dtl!=null){
				
            _bw.write(_wl_block4Bytes, _wl_block4);
 

	int j=0;
	String disabled = " disabled ";
	String checked = "";
	String colspan = "0";
	String order_format_field_values="";
	int transplant_exists = 0;
	String transplant_checked = "";
	String display_transplant = "";

	for(int i=0; i<order_format_dtl.size(); i++)
	{
		if(i%2 == 0)
		{
			out.println("<tr>");
			j++;
		}

		String record[] = (String[])order_format_dtl.get(i);
		record[0]=CommonBean.checkForNull(record[0],"");
		record[1]=CommonBean.checkForNull(record[1],"");
		record[2]=CommonBean.checkForNull(record[2],"");
		record[3]=CommonBean.checkForNull(record[3],"");
		record[4]=CommonBean.checkForNull(record[4],"");

		if(record[0].equals("E"))
		{ 			
			record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en","en");				
		}
		else if(record[0].equals("D"))
        {
			record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en","en");				
		}

		if(lineId.equals("")) 
		{
			order_format_field_values = CommonBean.checkForNull(record[2],"")+" "+CommonBean.checkForNull(record[4],"");
		}
		else
		{
			record[5]=CommonBean.checkForNull(record[5],"");
			record[6]=CommonBean.checkForNull(record[6],"");
			record[7]=CommonBean.checkForNull(record[7],"");
			order_format_field_values = CommonBean.checkForNull(record[2],"")+" "+CommonBean.checkForNull(record[7],"");
		}
	
		if(lineId.equals("")) 
		{
			if(record[5].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[5].equals("DONOR_BLOOD_GROUP")||record[5].equals("DONOR_RHESUS")||record[5].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:inline";
				}
			}
			else
			{
				display_transplant="display:inline";
			}
		}
		else
		{
			if(record[4].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[4].equals("DONOR_BLOOD_GROUP")||record[4].equals("DONOR_RHESUS")||record[4].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:inline";
				}
			}
			else
			{
				display_transplant="display:inline";
			}
		}
		if(record[0].equals("A"))
		{  

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block6Bytes, _wl_block6);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
	
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(((record[2] == null) ? "" : record[2])));
            _bw.write(_wl_block9Bytes, _wl_block9);

							

			}else if(record[0].equals("C"))
			{
 				if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
					checked = "";
				else checked = "checked";


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block6Bytes, _wl_block6);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			else 
			{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block6Bytes, _wl_block6);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_format_field_values));
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
					
			}
	
            _bw.write(_wl_block23Bytes, _wl_block23);
} else{
	
            _bw.write(_wl_block24Bytes, _wl_block24);

		for(int k=0;k<errorList.size();k++){
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block26Bytes, _wl_block26);
} 
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
