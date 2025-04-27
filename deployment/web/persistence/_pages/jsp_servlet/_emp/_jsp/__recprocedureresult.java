package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class __recprocedureresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RecProcedureResult.jsp", 1742538467315L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\r\nCRF Reference No     :  NMC-JD-CRF-102.18\r\nDetected Release  No      :  MARCH 2024 Release \r\nFile prepared by          :  SANTHOSH KUMAR N\r\nFile prepared date        :  13-03-2024\r\nPurpose of the Change   :  As a PAS user I should be able to record external referrals as well as display \"Nphies orders\" lookup field to select Nphies orders a multi-selection of orders and thus the selected orders will be displayed in referral screen. \r\nScript Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All Sites    \r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n<html>\r\n<head>\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\r\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\r\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\r\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\r\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\r\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n<script src=\"../js/RecordProcedure.js\" language=\"javascript\"></script>\r\n</head>\r\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\r\n<form name=\"RecProcedureResult\" id=\"RecProcedureResult\">\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t  <table align=\'right\'>\r\n\t\t<tr>\r\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\r\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\r\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t</table>\r\n\t\t\t<BR><BR>\r\n\t\t\t\r\n\t\t<table class=\'grid\' id=\'PatResultTbl\' border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\r\n\t\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\r\n\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\r\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\t\t<tr>\r\n\t\t\t\t<td nowrap style=\'word-wrap: break-word; width: 550px;\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\r\n\t\t\t\t<!-- <td nowrap style=\'word-wrap: break-word; width: 200px;\'></td> -->\r\n\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\r\n\t\t\t\t<td nowrap><input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\'chk";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onclick=\"bulkOrder(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',this)\"> \r\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script >\r\n\t\tif (document.getElementById(\'next\'))\r\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\r\n\t\t</script>\r\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t<script >\r\n\t\tif (document.getElementById(\'next\'))\r\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\r\n\t\t</script>\r\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\r\n</td></tr>\r\n</table>\r\n\r\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n<input style=\"float: right;\" type=\"button\" class=\"button\"\r\n\t\t\tname=\"okBtn\" id=\"okBtn\" value=\'ok\' onClick=\"submitCode()\">\r\n\r\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\r\n\t\r\n<input type=\"hidden\" id=\"start\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\r\n<input type=\"hidden\" id=\"records_to_show\" name=\"records_to_show\" id=\"records_to_show\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\r\n<input type=\"hidden\" id=\"end\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\r\n<input type=\"hidden\" id=\"searchText\" name=\"searchText\" id=\"searchText\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\r\n<input type=\"hidden\" id=\"searchCriteria\" name=\"searchCriteria\" id=\"searchCriteria\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\r\n<input type=\"hidden\" id=\"radioval\" name=\"radioval\" id=\"radioval\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\r\n<input type=\"hidden\" id=\"selectedCodeDtl\" name=\"selectedCodeDtl\" id=\"selectedCodeDtl\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\r\n\r\n\r\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\r\n\r\n</form>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\r\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = checkForNull((String) session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Statement stmt = null;
	ResultSet rs = null;
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");
	
	String searchText=request.getParameter("searchText");
	String searchCriteria=request.getParameter("searchCriteria");
	String radioval=request.getParameter("radioval");
	String selectedCodeDtl=request.getParameter("selectedCodeDtl");
	
	String[] checkedNPHCode=null;
	if(selectedCodeDtl!=null){
		checkedNPHCode = selectedCodeDtl.split("~");
	}
	
	String NPMType = "";
	String NPHCode = "";
	String longDesc = "";
	String shortDesc = "";
	String effStatus = "";
	String checked="";
	String quantity="";
	
	int maxRecord=0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int records_to_show=10;
	String from = request.getParameter("from");
	String to = request.getParameter("to");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try {
		StringBuffer sql			= new StringBuffer();
		sql.append("SELECT NPH_TYPE, NPH_CODE, LONG_DESC, SHORT_DESC from MR_NPH_CODE where EFF_STATUS='E' ");
		
		if(!checkForNull(searchText).equals("")){
			if(radioval.equals("C")){
				if(searchCriteria.equals("S")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('"+searchText+"%')");	
				} else if(searchCriteria.equals("E")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('%"+searchText+"')");	
				} else if(searchCriteria.equals("C")){
					sql.append("and UPPER (NPH_CODE) like UPPER ('%"+searchText+"%')");	
				}
				
			}else if(radioval.equals("D")){
				if(searchCriteria.equals("S")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('"+searchText+"%')");	
				} else if(searchCriteria.equals("E")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('%"+searchText+"')");	
				} else if(searchCriteria.equals("C")){
					sql.append("and UPPER (LONG_DESC) like UPPER ('%"+searchText+"%')");	
				}
			}
		}
		
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql.toString());
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
				
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
		//con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql.toString());
		rst = pstmt.executeQuery();
		if ( from == null )
		start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = records_to_show ;
		else
			end = Integer.parseInt( to ) ;	
		
		
            _bw.write(_wl_block9Bytes, _wl_block9);

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rst.next() ;
	  	  String classValue = "" ;
		  int cnt=0;
		  
            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( !(start <= 1) )
			out.println("<td align ='right'><font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font></td>");

		
            _bw.write(_wl_block11Bytes, _wl_block11);

			out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				
		while (i<=end  && rst.next()) {
				if(cnt==0)
		{		
			
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
			NPMType = checkForNull(rst.getString(1));
			NPHCode = checkForNull(rst.getString(2));
			longDesc = checkForNull(rst.getString(3));
			shortDesc = checkForNull(rst.getString(4));
			checked="";
			quantity="1";
			if(checkedNPHCode!=null){
				for (int j = 0; j < checkedNPHCode.length; j++) {
					if(checkedNPHCode[j].contains("*")){
						String[] nphCodeQuantity = checkedNPHCode[j].split("\\*");
						if(nphCodeQuantity[0].equals(NPHCode)){
							checked="checked";
							quantity=nphCodeQuantity[2];
							break;
						}
					} else {
						if(checkedNPHCode[j].equals(NPHCode)){
							checked="checked";
							break;
						}
					}
				}
			}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(longDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(NPHCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(NPHCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(NPHCode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(NPHCode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(longDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block23Bytes, _wl_block23);

				i++;
	cnt++;
	}

 		if (cnt==0){	
 				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));"+
 				"parent.RecProcedure_result.location.href = '../../eCommon/html/blank.html';</script>");
 			}
 			boolean flag = false;

 			if (cnt < 10 || (!rst.next())) {
 	
            _bw.write(_wl_block24Bytes, _wl_block24);
 flag = true;
			} else {
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
 
if (cnt > 0){ 
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(start));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(records_to_show));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(end));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(searchText));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(selectedCodeDtl));
            _bw.write(_wl_block35Bytes, _wl_block35);

		if (pstmt != null)
			pstmt.close();
		if (rst != null)
			rst.close();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nphiesDesc.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nphiescode.label", java.lang.String .class,"key"));
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
