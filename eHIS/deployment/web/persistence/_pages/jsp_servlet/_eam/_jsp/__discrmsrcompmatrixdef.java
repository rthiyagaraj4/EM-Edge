package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompmatrixdef extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompMatrixDef.jsp", 1732544310196L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/DiscrMsrComp.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction showMat(flag)\n{\n\tif(document.templateComponentRowColDefForm.matrix_cols.value == \"\" || document.templateComponentRowColDefForm.matrix_rows.value==\"\")\n\t{\n\t\terror = getMessage(\"AM0169\",\"AM\");\n        //messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n        parent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\treturn false;\n\t\t\n\t}else{\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\tvar matrix_max_columns_allowed = parseInt((document.templateComponentRowColDefForm.matrix_max_columns_allowed.value==\"\"?\"0\":document.templateComponentRowColDefForm.matrix_max_columns_allowed.value));\n\tvar error = \"\";\n\tvar matrix_cols =\t\tparseInt((document.templateComponentRowColDefForm.matrix_cols.value==\"\"?\"0\":document.templateComponentRowColDefForm.matrix_cols.value));\n\tvar matrix_rows = parseInt((document.templateComponentRowColDefForm.matrix_rows.value==\"\"?\"0\":document.templateComponentRowColDefForm.matrix_rows.value));\t\n\tvar matrix_starting_pos = parseInt(document.templateComponentRowColDefForm.matrix_starting_pos.value);\n\tif(matrix_starting_pos == \"\")\n\t\tdocument.templateComponentRowColDefForm.matrix_starting_pos.value = \"1\";\n\n\tvar matrixComponentDefinition = document.templateComponentRowColDefForm.matrixComponentDefinition.value;\n\tvar componentDefinition = \"\";\n\t//alert(\"matrixComponentDefinition....\"+matrixComponentDefinition);\n\t//if(matrixComponentDefinition != \"\")\n\t//\tcomponentDefinition = matrixComponentDefinition.split(\"$$$\")[4] + \"$$$\" + matrixComponentDefinition.split(\"$$$\")[5] + \"$$$\" + matrixComponentDefinition.split(\"$$$\")[6]+ \"$$$\" + matrixComponentDefinition.split(\"$$$\")[7]  + \"$$$\" + matrixComponentDefinition.split(\"$$$\")[8] ;\n\n/*alert(matrix_cols);\n\tif(matrix_cols == \"\" && matrix_rows == \"\")\n\t{alert(\"135\");\n\n\t\t//error = (\'APP-CA1050 Please enter all the mandatory fields.... \');\n\t\terror = getMessage(\"AM0169\",\"AM\");\n\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}else{\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t}*/\n\n\n\t/* if(matrix_cols == 0)\n\t{\n\t\t\n\t\terror = getMessage(\"AM0170\",\"AM\");\n\t\terror = error.replace(\"$\",\'Matrix Columns\');\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}else{\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\tif(matrix_rows == 0)\n\t{\n\t\t\n\t\terror = getMessage(\"AM0170\",\"AM\");\n\t\terror = error.replace(\"$\",\'Matrix Rows\');\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}\n    else{\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t}*/\n\n\t\n\tvar totalColspan = 0;\n\tvar mat_colSpan = \"\";\n\tfor(var i=0;i<parseInt(matrix_cols);i++)\n\t{\n\t\tvar matcolspan_value = parseInt(eval(\"document.templateComponentRowColDefForm.matrixColSpan\" + i + \".value\"));\n\t\tif(isNaN(matcolspan_value))\n\t\t{\n\t\t\t//alert(\'APP-AM1050 The colspan for columns position \' + (i+1) + \' has not been entered... \');\n\t\t\terr = getMessage(\"AM0145\",\"AM\");\n\t\t\terr = err.replace(\"$\",(i+1));\n\t\t\talert(err);\n\t\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\";\n\t\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\t\treturn false;\n\t\t}\n\t\ttotalColspan += parseInt(matcolspan_value);\n\t\n\t\tif(mat_colSpan == \"\")\n\t\t\tmat_colSpan += matcolspan_value;\n\t\telse\n\t\t\tmat_colSpan += \"~\" + matcolspan_value;\n\t}\n\tdocument.templateComponentRowColDefForm.matrix_colSpans.value = mat_colSpan;\n\t//alert((totalColspan + matrix_starting_pos - 1 )+ \">\" + (matrix_max_columns_allowed ));\n\tif((totalColspan + matrix_starting_pos - 1) > (matrix_max_columns_allowed ))\n\t{\n\t\t//alert(\'APP-AM1050 The total colspan should be less than or equal to \' + matrix_max_columns_allowed + \'.... \');\n\t\terr1=getMessage(\"AM0146\",\"AM\");\n\t\terr1 = err1.replace(\"$\",matrix_max_columns_allowed);\n\t\talert(err1);\n\n\t\treturn false;\n\t}\n\tvar action_url = \"../../eAM/jsp/DiscrMsrCompMatrixAddModify.jsp?mode=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&matrixID=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&matrixDesc=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&matrix_rows=\" + matrix_rows + \"&matrix_cols=\" + matrix_cols + \"&mat_colSpan=\" + mat_colSpan + \"&matrix_max_columns_allowed=\" + matrix_max_columns_allowed + \"&matrix_starting_pos=\" + matrix_starting_pos+ \"&flag=\" + flag;\t\n\t//if(flag != \'new\')\t\n\t\t//action_url += \"&componentDefinition=\" + escape(componentDefinition);\n\t\n\tparent.templateComponentMatrixAddModifyFrame.document.location.href =action_url;\n\tparent.templateComponentMatrixPreviewFrame.document.location.href = \"../../eCommon/html/blank.html\";\n}\n</SCRIPT>\n\n\n\n</HEAD>\n<BODY onKeyDown = \'lockKey()\' onload=\'myfocus()\'>\n<form name = \"templateComponentRowColDefForm\" id =\"templateComponentRowColDefForm\" >\n\t<table width=\"99%\" align=\"center\" border=\'0\' cellspacing=\'0\' cellpadding=\'1\'>\n\t\t<tr>\n\t\t\t<th colspan=\"5\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</th>\n\t\t</tr>\n\t\t<tr id=\"matrix_row_col_def\">\n\t\t\t<td  class=\'label\' width=\"17%\">\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t<!-- </td>\n\t\t\t<td   class=\'fields\' width=\"6%\"> -->\n\t\t\t\t<input type=\"text\" name=\"matrix_cols\" id=\"matrix_cols\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\"2\" maxlength=\"2\" onKeyPress=\'return ChkNumberInput(this,event,0)\' onblur = \"checkValue(this, ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =", \'Matrix Columns\');\" tabindex=\'1\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t<td  class=\'label\' width=\"15%\" id=\'tdid\'>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  \n\t\t\t<!-- </td>\n\t\t\t<td   class=\'fields\' width=\"6%\"> -->\n\t\t\t\t<input type=\"text\" name=\"matrix_rows\" id=\"matrix_rows\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=\"2\" maxlength=\"2\" onKeyPress=\'return ChkNumberInput(this,event,0)\' onblur=\"checkValRow(this);\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t<input type=\"hidden\" size=\"2\" name=\"matrix_starting_pos\" id=\"matrix_starting_pos\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<!--/tr-->\n\t\t<td>\n\t\t<table width=\"99%\" align=\"left\" border=\'0\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr id=\"matrix_colSpan_def\" style=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\t\t\t\t\n\t\t\t<td class=\'label\' id = \"matrix_colSpan_row_mat\" align=\'right\' width=\"30%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'fields\' width=\"70%\" id = \"matrix_colSpan_row_def\" align=\'left\'>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t<!-- </tr>\n\t\t<tr> -->\n\t\t\t<td colspan=\"2\" ><!-- colspan=\"6\" align=\'center\'> -->\n\t\t\t\t<input type=\"button\" name=\"showMatrix\" id=\"showMatrix\" size=\"50\" value=\"Show Matrix\" onclick=\"showMat(\'new\')\" class=\"button\" >\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"matrix_max_columns_allowed\" id=\"matrix_max_columns_allowed\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"matrixComponentDefinition\" id=\"matrixComponentDefinition\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"matrix_colSpans\" id=\"matrix_colSpans\" value=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script>\n\t\tshowMat();\t\t\n\t</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement stmt1=null;
	ResultSet rset1=null;
	String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
    StringBuffer paragraphDefinition=new StringBuffer();
    String matrix_cols	= "",	matrix_rows	=	"";
	String matrix_starting_pos	= "1",	matrix_colSpans	=	"";
	String matrixID = request.getParameter("matrixID")==null?"":request.getParameter("matrixID");
	String matrixDesc = request.getParameter("matrixDesc")==null?"":request.getParameter("matrixDesc");
	String matrix_max_columns_allowed = request.getParameter("matrix_max_columns_allowed")==null?"":request.getParameter("matrix_max_columns_allowed");
	String matrixComponentDefinition="";	//= request.getParameter("matrixComponentDefinition")==null?"":request.getParameter("matrixComponentDefinition");
	//String componentDefinition = "";
	//added by Shaiju

	if (!mode.equals("insert")){	
		
		try
			{
		con = ConnectionManager.getConnection(request);
		String sqlalpha = " SELECT DISCR_MSR_DEF FROM AM_DISCR_COMP_DEFINITION WHERE DISCR_MSR_ID = ? " ;
				stmt1= con.prepareStatement(sqlalpha);
				stmt1.setString(1,matrixID);
				rset1 = stmt1.executeQuery();
				while(rset1.next())
				{
					Clob clb = rset1.getClob(1);
				

					if(clb!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null) {
							paragraphDefinition.append(line);
						}
					}
				}

				
				if(rset1!=null) 	rset1.close();
				if(stmt1!=null) 	stmt1.close();
				
		matrixComponentDefinition =	paragraphDefinition.toString();
		
		}
		catch (Exception e)
		{
			out.println(e.toString());
			e.printStackTrace(System.err);
		}
		finally
			{
	
			if(con!=null)ConnectionManager.returnConnection(con,request);
			}
	// addition ends..

	StringTokenizer stk = null;
	if(!matrixComponentDefinition.equals(""))
	{
		stk = new StringTokenizer(matrixComponentDefinition, "$$$");
		//out.println(matrixComponentDefinition);
		matrix_cols			= stk.nextToken();
		matrix_rows			= stk.nextToken();
		matrix_starting_pos = stk.nextToken();
		matrix_colSpans		= stk.nextToken();

	}
}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(matrixID));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(matrixDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(matrix_cols));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(matrix_max_columns_allowed));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(matrix_rows));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(matrix_starting_pos));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(matrixComponentDefinition.equals("")?"display:none":""));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					if(!matrixComponentDefinition.equals(""))
					{
						StringTokenizer stk_temp = new StringTokenizer(matrix_colSpans, "~");
						int i = 0;
						while(stk_temp.hasMoreTokens())
						{
							out.println("<input type='text' size='1' maxlength='1' onKeyPress='return(ChkNumberInput(this,event,0))' name='matrixColSpan" + i++ + "' id='matrixColSpan" + i++ + "' value=\"" + stk_temp.nextToken() + "\" >");
						}
					}

				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(matrix_max_columns_allowed));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(matrixComponentDefinition));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);

if(!matrixComponentDefinition.equals(""))
{
            _bw.write(_wl_block23Bytes, _wl_block23);
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MatrixAttributes.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MatrixColumns.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MatrixRows.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MatrixColumnSpan.label", java.lang.String .class,"key"));
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
}
