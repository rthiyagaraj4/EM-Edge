package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __searchicdcodequeryresultctl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SearchicdcodeQueryResultCtl.jsp", 1743671581491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- \t<script src=\'../../eMR/js/PatProblemSearch.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n\n<script>\nvar codeArr = new Array();\n\nfunction loadDefaultPage()\n{\n\tvar from = 0;\n\tvar to = 1;\n\tvar totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value - 1);\n\tif(totalIndex == 0)\n\t\ttotalIndex = 1;\n\tvar displstart = 1;\n\tparent.prevnextframe.document.forms[0].label_cap.value = displstart + \" of \" + totalIndex;\n\tparent.prevnextframe.document.forms[0].CurIndex.value = 0;\n\tpopulateData(from,to)\n}\n\nfunction populateData(from_code, to_code)\n{\n\tvar queryString\t= parent.prevnextframe.document.forms[0].queryString.value;\n\tvar from_val = codeArr[from_code];\n\t\n\tvar to_val = codeArr[to_code];\n\t\nparent.frames[2].location.href=\"SearchicdcodeQueryResult.jsp?\"+queryString+\"&from_code=\"+from_val+\"&to_code=\"+to_val;\n}\nfunction disabledDefaultPage(){\n\tparent.frames[2].location.href=\"SearchicdcodeQueryResult.jsp?&clearResultPage=y\";\n\n}\n\nfunction loadPrevNext(obj)\n{\n\tvar NxtBtn\t\t= parent.prevnextframe.document.forms[0].next;\n\tvar PrvBtn\t\t= parent.prevnextframe.document.forms[0].prev;\n\n\tvar curindex = eval(parent.prevnextframe.document.forms[0].CurIndex.value);\n\tvar totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value) -1;\n\n\tvar fromindex = 0;\n\tvar toindex = 0;\n\n\tvar displstart\t= 1;\n\tvar displend = totalIndex ; \n\n\tif(obj.name == \"next\")\n\t{\n\t\tif(curindex < totalIndex)\n\t\t{\n\t\t\tcurindex++;\n\t\t\tfromindex = curindex;\n\t\t\ttoindex = eval(curindex) + 1;\n\n\t\tif((curindex+1) == (totalIndex) ) \n\t\t\tNxtBtn.disabled = true;\n\t//\telse\n\t\t\tPrvBtn.disabled = false;\n\n\t\tdisplstart\t= eval(curindex) +1;\n\t\t}\n\t}\n\telse if(obj.name == \"prev\")\n\t{\n\t\tif(curindex > 0)\n\t\t{\n\n\t\t\ttoindex = curindex;\n\t\t\tfromindex = eval(curindex) - 1;\n\t\t\tcurindex--;\n\n\t\tif((curindex ) == 0 ) \n\t\t\t\tPrvBtn.disabled = true;\n//\t\telse\n\t\t\t\tNxtBtn.disabled = false;\n\n\t\t\t displstart\t= eval(curindex) + 1;\n\t\t}\n\t}\n\n\tparent.prevnextframe.document.forms[0].label_cap.value = displstart + \" of \" + displend;\n\tparent.prevnextframe.document.forms[0].CurIndex.value = curindex;\n\tpopulateData(fromindex,toindex);\n\t\n}\n\nasync function showLongDescription(a)\n{\n\tvar dialogHeight= \"20vh\" ;\n    var dialogWidth = \"23vw\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\tawait window.showModalDialog(\"../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n}\n\nfunction closewindow(Dcode)\n{\n\twindow.parent.parent.returnValue=Dcode;\n\twindow.parent.parent.close();\n}\nfunction scrollTitle(){\n   var y = parent.TermCodeSearchKWResultFrame.document.body.scrollTop;\n   //alert(y);\n   if(y == 0){\n\t\tparent.TermCodeSearchKWResultFrame.document.getElementById(\"divDataTitle\").style.position = \'static\';\n   }else{\n\t\tparent.TermCodeSearchKWResultFrame.document.getElementById(\"divDataTitle\").style.position = \'relative\';\n\t\tparent.TermCodeSearchKWResultFrame.document.getElementById(\"divDataTitle\").style.posTop  = y-2;\n   }\n\n}\n\nfunction alignWidth()\n{\n\tvar totalRows =  parent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTable\").rows.length;\n\tvar counter = totalRows-1;\n\tvar temp = parent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTitleTable\").rows[0].cells.length;\n\tfor(var i=0;i<temp;i++) \n\t{\n\t\tparent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTitleTable\").rows[0].cells[i].width=parent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTable\").rows[counter].cells[i].offsetWidth;\n\t}\n}\n</script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tcodeArr[\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"] = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t//alert(codeArr);\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<body  onScroll=\'scrollTitle()\' onKeyDown=\'lockKey()\'>\n\t\t\t\t<form name = \"SearchicdcodeQueryResultCtlForm\" >\n\t\t\t\t<table border=0 cellpadding=0 cellspacing=0 width=\"100%\" align=\'center\' id=\'tablePrevNext\' style=\'display:inline\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  width=\'85%\' align=\'right\' CLASS =LABEL>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td align=\'right\' width=\'5%\'><input type=\'button\' id=\'prev\' name=\'prev\' id=\'prev\' value=\'<\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" class=\'button\' onclick=\'loadPrevNext(this)\' align=\'right\'></td>\n\t\t\t\t\t\t<td align =\'center\' class = \'QRYEVEN\'><input type =\'label\' readonly class=\"LABEL\" name = \'label_cap\' size=\'15\' value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="></td>\n\t\t\t\t\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'next\' name=\'next\' id=\'next\' value=\'>\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" class=\'button\' onclick=\'loadPrevNext(this)\' ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type= \"hidden\" name= \"CurIndex\" value=\"0\">\n\t\t\t\t<input type= \"hidden\" name= \"totalIndex\" value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" - 1>\n\t\t\t\t<input type= \"hidden\" name= \"queryString\" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].prev.disabled = true;\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" <= 2)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].next.disabled = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" > 0)\n\t\t\t\t\t\t\tloadDefaultPage();\n\t\t\t\t\t</script>\n\t\t\t\t</form>\n\t\t\t\t</body>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\t\tdisabledDefaultPage();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale=checkForNull((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	request.setCharacterEncoding("UTF-8");
	StringBuffer sql= new StringBuffer();
	
	String disablePrev="";
	String disableNext="";
	String no_data = "";
	int indxKey = 0;
	String term_code = "";
	String term_set_id = "";
	String searchby=(request.getParameter("Search_By")==null)?"":request.getParameter("Search_By");
    String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
    String searchtext=(request.getParameter("Search_Text")==null)?"":request.getParameter("Search_Text");
	String sensitive_yn =(request.getParameter("sensitive_yn")==null)?"":request.getParameter("sensitive_yn");
	String notifiable_yn =(request.getParameter("notifiable_yn")==null)?"":request.getParameter("notifiable_yn");
	//modified on 15-07-08 for SCR 4827
	String title = request.getParameter("title")==null?"":request.getParameter("title");
	
	if(title.equals("ICD10 Code List"))
	{
		term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
	}
	else
		{
		term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
	}
	String code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
	String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
	term_set_id = term_set_id.trim();
	searchtext = searchtext.toUpperCase();
	Connection conn = null; 
	PreparedStatement stmt  = null;
	ResultSet rs = null;
	//int i = 0;
try
{
	conn = ConnectionManager.getConnection(request);

	/*
	
	if(searchby.equals("D")) 
	{
	//Maheshwaran added for the HSA-CRF-0234
	if(diagnosis_by_long_desc_yn.equals("Y"))
	sql.append(" upper(long_desc)  like upper(?)");
	else
	sql.append(" upper(short_desc)  like upper(?)");
	}
	else 
		sql.append(" term_code  like ");

	if(searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
	else if(searchcriteria.equals("E"))
		sql.append("'%"+searchtext+"'");
	else if(searchcriteria.equals("C"))
		sql.append("'%"+searchtext+"%'");

	*/


	if(searchby.equals("D")){ 
		if(diagnosis_by_long_desc_yn.equals("Y"))
		sql.append(" upper(long_desc)  like upper(?)");
		else
		sql.append(" upper(short_desc)  like upper(?)");
	}else{
		sql.append(" upper(term_code)  like upper(?)");	
	}
	//8/20/2009 Free Text Diagnosis
	sql.append(" AND FREE_TEXT_YN = 'N' ");


	if(sensitive_yn.equals("Y")) {
		sql.append(" and  SENSITIVE_YN = 'Y' ");
	}else if (sensitive_yn.equals("N")) {
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");
	}
	if(notifiable_yn.equals("Y")){
		sql.append(" and NOTIFIABLE_YN = 'Y'");
	}else if (notifiable_yn.equals("N")){
		sql.append(" and nvl(NOTIFIABLE_YN,'N') ='N'");
	}
	if(!code_indicator.equals(""))	{
		sql.append(" and  code_indicator = ?");
	}else{
		sql.append(" and ( code_indicator in ('C','D','E','A') or code_indicator is null ) ");	
	}
	sql.append("and language_id=?");// Language Id is added for IN023648 	
	//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");		
	sql.append(" )  where mod(order_rank,25)=1  or TERM_CODE = last_rank ");


	sql.append(" order by order_rank ");
			/*
				The following query was modified for IN023648.
				Modified On:10/5/2010.
			*/

	StringBuffer searchKW_sql = new StringBuffer("select TERM_CODE  from (select TERM_CODE,rank() over( order by TERM_CODE) order_rank ,max(TERM_CODE) over ( order by TERM_CODE desc) last_rank from  MR_D_"+term_set_id+"_LANG_VW where ");
	

	stmt = conn.prepareStatement(searchKW_sql.toString()+sql.toString());

	if(searchcriteria.equals("S")) {  
		stmt.setString(1,searchtext+"%");		
	} else if(searchcriteria.equals("E")) {
		stmt.setString(1,"%"+searchtext);		
	} else if(searchcriteria.equals("C")) {
		stmt.setString(1,"%"+searchtext+"%");		
	} 

	if(!code_indicator.equals("")){
		stmt.setString(2,code_indicator);
		stmt.setString(3,locale);		
	}else{
		stmt.setString(2,locale);
	}
			
		rs = stmt.executeQuery();
		indxKey = 0;
		while(rs.next())
		{
			term_code = rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
			//out.println("term_code :"+term_code);
			
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(indxKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block10Bytes, _wl_block10);


				indxKey++;
				//out.println("<script>alert(\""+indxKey+"\");</script>");
		}

	 /*Below line commented for this incident [IN:040385]*/			
	 /*if(indxKey == 0)
		{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>parent.frames[0].document.forms[0].Search.disabled = false</script>");
				out.println("<script>parent.frames[2].href='../../eCommon/html/blank.html' </script>");
				
		}*/
      //End this incident [IN:040385]	
	
	if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();
	if(indxKey == 0)
		no_data = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NoDataFound.label","mr_labels");
	//{"eMR.NoDataFound.label","No Data Found"}
//		no_data = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NoDataFound.label","mr_labels");


}catch(Exception e){
	e.printStackTrace();
}finally{
		if(conn!=null){
			ConnectionManager.returnConnection(conn,request);
		}
 }
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(indxKey!=0){
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_data));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indxKey));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indxKey));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(indxKey));
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DisplayResult.label", java.lang.String .class,"key"));
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
}
