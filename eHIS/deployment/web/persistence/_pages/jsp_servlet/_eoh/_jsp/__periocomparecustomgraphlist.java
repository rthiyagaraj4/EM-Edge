package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __periocomparecustomgraphlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioCompareCustomGraphList.jsp", 1742903461153L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"javascript\" src=\"../../eOH/js/PerioChart.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script>\n\nfunction loadGraph(){\n\t\tvar formObj = document.forms[0];\n\t\tvar comp_code=formObj.component_code.value;\n\t\tif(comp_code==\"\"){\n\t\t\talert(getMessage(\"APP-OH00064\",\'OH\'));\n\t\t\treturn false\n\t\t}else{\n\t\t\t\tvar comp_code_arr=comp_code.split(\"##\");\n\t\t\t\tvar patient_id=formObj.patient_id.value;\n\t\t\t\tvar chart_num1=formObj.chart_num1.value;\n\t\t\t\tvar chart_num2=formObj.chart_num2.value;\n\t\t\t\tvar chart_num3=formObj.chart_num3.value;\n\t\t\t\tvar chart_line_num1=formObj.chart_line_num1.value;\n\t\t\t\tvar chart_line_num2=formObj.chart_line_num2.value;\n\t\t\t\tvar chart_line_num3=formObj.chart_line_num3.value;\n\t\t\t\tvar chart_code=formObj.chart_code.value;\n\t\t\t\tvar val_type=formObj.val_type.value;\n\t\t\t\tvar perio_arch=formObj.perio_arch.value;\n\t\t\t\tvar tooth_numbering_system=formObj.tooth_numbering_system.value;\n\t\t\t\tvar permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;\n\t\t\t\tvar eval_type=formObj.eval_type.value;\n\t\t\t\tvar eval_chart_date1=formObj.eval_chart_date1.value;\n\t\t\t\tvar eval_chart_date2=formObj.eval_chart_date2.value;\n\t\t\t\tvar no_of_charts=formObj.no_of_charts.value;\n\t\t\t\tvar quadrant=formObj.quadrant.value;\n\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_num1=\"+chart_num1+\"&chart_num2=\"+chart_num2+\"&chart_num3=\"+chart_num3+\"&chart_line_num1=\"+chart_line_num1+\"&chart_line_num2=\"+chart_line_num2+\"&chart_line_num3=\"+chart_line_num3+\"&chart_code=\"+chart_code+\"&perio_arch=\"+perio_arch+\"&tooth_numbering_system=\"+tooth_numbering_system+\"&components=\"+comp_code_arr[0]+\"&val_type=\"+val_type+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&eval_chart_date1=\"+eval_chart_date1+\"&eval_chart_date2=\"+eval_chart_date2+\"&eval_type=\"+eval_type+\"&surfface_appl_yn=\"+comp_code_arr[1]+\"&no_of_charts=\"+no_of_charts+\"&quadrant=\"+quadrant;\n\t\t\t\tif(comp_code_arr[1]==\"N\"){\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eOH/jsp/PerioCompareBuccalGraph.jsp?\"+params;\n\t\t\t\t\tparent.frames[3].document.location.href=\"../../eOH/jsp/PerioCompareGraphBuccalTableView.jsp?\"+params;\n\t\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/html/blank.html?\"+params;\n\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/html/blank.html?\"+params;\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eOH/jsp/PerioCompareBuccalGraph.jsp?\"+params;\n\t\t\t\t\tparent.frames[3].document.location.href=\"../../eOH/jsp/PerioCompareGraphBuccalTableView.jsp?\"+params;\n\t\t\t\t\tparent.frames[4].document.location.href=\"../../eOH/jsp/PerioComparePalatalGraph.jsp?\"+params;\n\t\t\t\t\tparent.frames[5].document.location.href=\"../../eOH/jsp/PerioCompareGraphPalatalTableView.jsp?\"+params;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n</script>\n</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form id=\'comp\' name=\'perioCompareListForm\' id=\'perioCompareListForm\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' style=\"background-color:#F5BDFF\">\n<tr style=\"background-color:#F5BDFF\">\n\t<td class=label style=\"background-color:#F5BDFF\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td><select name=\"component_code\" id=\"component_code\"> \n\t<option value=\'\' selected>----------\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="--------</option>\n   \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t               <option value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n            ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n</td>\n<td><img  align=\'center\' src=\'../../eCA/images/graph.gif\' onclick=\'loadGraph()\' title=\'Show Graph\' value=\'\'>&nbsp;&nbsp; Custom View</td>\n<td>&nbsp;</td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\"hidden\" name=\"chart_num1\" id=\"chart_num1\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n<input type=\"hidden\" name=\"chart_num2\" id=\"chart_num2\"\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n<input type=\"hidden\" name=\"chart_num3\" id=\"chart_num3\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<input type=\"hidden\" name=\"chart_code\" id=\"chart_code\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n<input type=\"hidden\" name=\"quadrant\" id=\"quadrant\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n<input type=\"hidden\" name=\"chart_line_num1\" id=\"chart_line_num1\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n<input type=\"hidden\" name=\"chart_line_num2\" id=\"chart_line_num2\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n<input type=\"hidden\" name=\"chart_line_num3\" id=\"chart_line_num3\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n<input type=\"hidden\" name=\"eval_chart_date1\" id=\"eval_chart_date1\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n<input type=\"hidden\" name=\"eval_chart_date2\" id=\"eval_chart_date2\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n<input type=\"hidden\" name=\"perio_arch\" id=\"perio_arch\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n<input type=\"hidden\" name=\"val_type\" id=\"val_type\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n<input type=\"hidden\" name=\"eval_type\" id=\"eval_type\"\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n<input type=\"hidden\" name=\"no_of_charts\" id=\"no_of_charts\"\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\"\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n<input type=\"hidden\" name=\"permanent_deciduous_flag\" id=\"permanent_deciduous_flag\"\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);



		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = (String)session.getAttribute("LOCALE"); 
		String patient_id=checkForNull(request.getParameter("patient_id"));
		String chart_num=checkForNull(request.getParameter("chart_num1"));
		String chart_num2=checkForNull(request.getParameter("chart_num2"));
		String chart_num3=checkForNull(request.getParameter("chart_num3"));
		String chart_line_num="";
		String chart_line_num2="";
		String chart_line_num3="";
		String chart_code=checkForNull(request.getParameter("chart_code"));
		String val_type=checkForNull(request.getParameter("val_type"));
		String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
		String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
		String perio_arch=checkForNull(request.getParameter("perio_arch"));
		String eval_chart_date1=checkForNull(request.getParameter("eval_chart_date1"));
		String eval_chart_date2=checkForNull(request.getParameter("eval_chart_date2"));
		String eval_type=checkForNull(request.getParameter("eval_type"));
		String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
		String quadrant=checkForNull(request.getParameter("quadrant"));
		if(eval_type.equals("BB")){
			chart_line_num="1";
			chart_line_num2="1";
			chart_line_num3="1";
		}else{
			chart_line_num=checkForNull(request.getParameter("chart_line_num1"));	
			chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
			chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
		}
	
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	String comp_code="";
	String comp_desc="";
	String surface_appl_yn="";
try
      {
        con=ConnectionManager.getConnection(request);
		
		sql="SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERDONTAL_CHRT_COMP_LANG_VW B WHERE A.CHART_CODE	=? AND B.LANGUAGE_ID=? AND A.COMPONENT_CODE	=B.COMPONENT_CODE ORDER BY B.COMPONENT_SHORT_DESC_USER_DEF";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,locale);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        comp_code=rs.getString(1);
			        comp_desc=rs.getString(2);
			        surface_appl_yn=rs.getString(3);
					comp_code=comp_code+"##"+surface_appl_yn;
                    
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(comp_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
  }
	  }
	 }catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		out.println("exp"+e);
		}
}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(chart_num2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(chart_num3));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(chart_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(quadrant));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chart_line_num2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chart_line_num3));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(eval_chart_date1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(eval_chart_date2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(val_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eval_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(no_of_charts));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(permanent_deciduous_flag));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PerioCustomGraph.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
