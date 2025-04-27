package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpkgpricequeryresultjoblist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPkgPriceQueryResultJobList.jsp", 1742980845064L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n</HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n<script>\n\n$(document).ready(function () {\t\n\t//load TabA by default\t\n\t $(\"#tabADiv\").click(function(){\n\t\tvar radios = jQuery(\"input[type=\'radio\']\");\n\t\tvar strJobId =  radios.filter(\":checked\");\n\n\t\t$(\"#ProcessedDataDiv\").load(\"../../eBL/jsp/BLPkgPriceQueryResultError.jsp\",{jobId:strJobId.val(),type:\"withouterror\"});\n\t\t $(\"#tabADiv\").html(\"<a class=\'tabClicked\' id=\'ProcessedWithoutError\'><span class=\'tabSpanclicked\' id=\'ProcessedWithoutErrorspan\'>Processed Without Error</span></a>\");\n\t\t $(\"#tabBDiv\").html(\"<a class=\'tabA\' id=\'ProcessedWithError\' ><span class=\'tabAspan\' id=\'ProcessedWithErrorspan\'>Processed With Error</span></a>\"); \n\t  });\n\t \n\t $(\"#tabBDiv\").click(function(){\t\t\n\t\t var radios = jQuery(\"input[type=\'radio\']\");\n\t\t var strJobId =  radios.filter(\":checked\");\n\t\t\t\n\t\t $(\"#ProcessedDataDiv\").load(\"../../eBL/jsp/BLPkgPriceQueryResultError.jsp\",{jobId:strJobId.val(),type:\"witherror\"});\n\t\t $(\"#tabADiv\").html(\"<a class=\'tabA\' id=\'ProcessedWithoutError\'><span class=\'tabAspan\' id=\'ProcessedWithoutErrorspan\'>Processed Without Error</span></a>\");\n\t\t $(\"#tabBDiv\").html(\"<a class=\'tabClicked\' id=\'ProcessedWithError\' ><span class=\'tabSpanclicked\' id=\'ProcessedWithErrorspan\'>Processed With Error</span></a>\"); \n\t  });\t \n\t \n\t $(\"#resizeBtn\").click(function(){\n\t\t var defValue = $(this).attr(\'defValue\');\n\t\t if(defValue ==\'expand\'){\n\t\t\t$(\'#tableHeaderDiv\').hide();\n\t\t\t$(\'#BLPkgPriceQueryResultDiv\').hide();\n\t\t\t$(parent.BLPkgPriceQueryFrame.document).find(\'#BLPkgPriceQueryDiv\').hide();\n\t\t\t$(this).attr(\'src\',\'../../eOT/images/ShowLess.gif\');\n\t\t\t$(this).attr(\'defValue\',\'shrink\');\n\t\t }\n\t\t else if(defValue ==\'shrink\'){\n\t\t\t $(this).attr(\'defValue\',\'expand\');\n\t\t\t $(\'#tableHeaderDiv\').show();\n\t\t\t $(\'#BLPkgPriceQueryResultDiv\').show();\n\t\t\t $(parent.BLPkgPriceQueryFrame.document).find(\'#BLPkgPriceQueryDiv\').show();\n\t\t\t $(this).attr(\'src\',\'../../eOT/images/ShowMore.gif\');\n\t\t }\t\t\n\t });\t\n\t \n\t  $(\".radio\").click(function(){\t\t  \n\t\t\t var strJobId=$(this).val();\t\n\t\t     $(\"#ProcessedDataDiv\").load(\"../../eBL/jsp/BLPkgPriceQueryResultError.jsp\",{jobId:strJobId,type:\"withouterror\"});\n\t\t\t $(\"#tabADiv\").html(\"<a class=\'tabClicked\' id=\'ProcessedWithoutError\'><span class=\'tabSpanclicked\' id=\'ProcessedWithoutErrorspan\'>Processed Without Error</span></a>\");\n\t\t\t $(\"#tabBDiv\").html(\"<a class=\'tabA\' id=\'ProcessedWithError\' ><span class=\'tabAspan\' id=\'ProcessedWithErrorspan\'>Processed With Error</span></a>\"); \n\t\t  });\n});\n\nfunction resultOnLoad(){\t// This method is loaded by default\n\t$(\"#ProcessedDataDiv\").load(\"../../eBL/jsp/BLPkgPriceQueryResultError.jsp\",{jobId:$(\"#jobId0\").val(),type:\"withouterror\"});\n\t$(\"#tabADiv\").html(\"<a class=\'tabClicked\' id=\'ProcessedWithoutError\'><span class=\'tabSpanclicked\' id=\'ProcessedWithoutErrorspan\'>Processed Without Error</span></a>\");\n\t$(\"#tabBDiv\").html(\"<a class=\'tabA\' id=\'ProcessedWithError\' ><span class=\'tabAspan\' id=\'ProcessedWithErrorspan\'>Processed With Error</span></a>\");\t\n}\n\nfunction resultOnNoRecords(){\n\talert(\"No Records Found\");\n\t$(\"#tableHeaderDiv\").hide();\n}\n</script>\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n<form name=\'BLExtAccRcptTypeHeaderForm\' id=\'BLExtAccRcptTypeHeaderForm\' >\n<div id=\"tableHeaderDiv\">\n<table id=\"JobListTable\" width=\'100%\'>\t\t\t\n<th>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th> <!--23-09-2020-->\n</table>\t\n\t\t\n\t<table width=\"100%\">\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" <!--23-09-2020-->\n\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> <!--23-09-2020-->\n\t\t<td class=\'COLUMNHEADER\' width=\'*\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t<!--23-09-2020-->\n\t\t</tr>\n\t</table>\n</div>\n<div id=\"BLPkgPriceQueryResultDiv\" STYLE=\"width:100%; height:80; overflow: auto;\"> \n<table id=\"BLPkgPriceQueryResultTable\" name=\"BLPkgPriceQueryResultTable\" id=\"BLPkgPriceQueryResultTable\" cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' border=\'0\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<tr>\n\t<td class=\'fields\' width=\'10%\'><input class=\'radio\' type=\'radio\' name=\'select\' id=\'select\'  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="checked";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ></td>\n\t<td class=\'fields\' width=\'10%\'><input type=\'hidden\' size=\'5\' name=\'serialNo";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'serialNo";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'fields\' width=\'20%\'><input type=\'hidden\' size=\'25\' name=\'jobId";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'jobId";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t<td class=\'fields\' width=\'*\'><input type=\'hidden\' size=\'50\' name=\'jobStatus";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'jobStatus";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n</div>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n<br><table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\"center\">\n<tr width=\'100%\'>\n\t<td width=\"100%\" class=\"white\">\n\t\t<ul id=\'tablist\' class=\'tablist\'>\n\t\t\t<li class=\"tablistitem\">\n\t\t\t<div id=\'tabADiv\'></div>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" >\n\t\t\t<div id=\'tabBDiv\'></div>\n\t\t\t</li>\t\n\t\t\t<li>\n\t\t\t<div>\n\t\t\t\t<img id=\"resizeBtn\" alt=\"\" defValue=\"expand\" src=\"../../eOT/images/ShowMore.gif\" style=\"visibility: visible;\" ></a>\n\t\t\t</div>\n\t\t\t</li>\n\t\t</ul>\n\t</td>\t\n\t</tr>\n\t<tr><td><div id=\'ProcessedDataDiv\'></div></td></tr>\n</table>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

public String checkNull(String str){
	if(str==null || str.equals("")){
		str="";
	}
	return str;
}
		


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	
	String userId = checkNull(request.getParameter("userId"));
	String jobNo=checkNull(request.getParameter("jobId"));
	String date=checkNull(request.getParameter("date"));

	String finalQuery= "select distinct a.job_no,jobs.job,DECODE (NVL (jobs.failures, 0), 0, '', 'Failed') job_status,a.pgm_date pgm_date "+
 	" from bl_package_price_updtn_req a, dba_jobs jobs where jobs.job (+)= a.oracle_job_no and TO_CHAR(a.added_date, 'dd/mm/yyyy')='"+date+"' ";

	if(!userId.equals("")){
		finalQuery+= " AND a.ADDED_BY_ID='"+userId+"'";
	}
	if(!jobNo.equals("")){
		finalQuery+= "  AND  a.job_no='"+jobNo+"' ";
	}	
	finalQuery+=" and a.job_no is not null ";
		 	
	
	finalQuery+=" ORDER BY pgm_date desc,job_no desc  ";
	Connection con=null ;
	PreparedStatement pstmt=null ;
	ResultSet rs=null ;
	int index=0;
	String acc_entity_code="";
	try {
			con = ConnectionManager.getConnection(request);
			System.err.println("Final Query ->"+finalQuery);
			pstmt = con.prepareStatement(finalQuery);
			System.err.println("159,pstmt-->"+pstmt);
			rs = pstmt.executeQuery() ;
			System.err.println("161,rs-->"+rs);
			int count = 0;
			if( rs != null ) 
			{	System.err.println("164,rs-->"+rs);
				while( rs.next())
				{ 	
				System.err.println("167,rs-->"+rs);
				count++;
				String  jobId = checkNull(rs.getString("job_no"));
				System.err.println("170,jobId-->"+jobId);
				String job=checkNull(rs.getString("JOB"));
				System.err.println("173,job-->"+job);
				String  jobStatus = checkNull(rs.getString("Job_status"));
				System.err.println("174,jobStatus-->"+jobStatus);
				
				if(("".equals(job))){
					System.err.println("175,inside if condition");
					jobStatus="Completed";
				}
				else if(!("".equals(job)) && "".equals(jobStatus)){
					System.err.println("175,inside elsecondition");
					jobStatus="In Progress";
				}		
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(jobId));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(index==0){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(jobId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(jobId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(jobStatus));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(jobStatus));
            _bw.write(_wl_block25Bytes, _wl_block25);

	index++;
	System.err.println("176,printing the index value : "+index);
		
		}
	}
	if( rs != null ) rs.close();
	if(pstmt!=null) pstmt.close();
	System.err.println("177,after index----->>");	
	}catch (Exception e) {
		System.err.println("178,inside catch");
		e.printStackTrace();
		System.err.println("Exception from Auto Fill Search Criteria :"+e);
		con.rollback();
	}
	finally
		{	
			System.err.println("178,inside finally");
			ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
if(index>0){
	System.err.println("179,after index greater than zero");
	out.println("<script>resultOnLoad();</script>");	

            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
	System.err.println("180,inside else-->");
	out.println("<script>resultOnNoRecords();</script>");
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.JobList.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.JobId.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.JobStatus.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
