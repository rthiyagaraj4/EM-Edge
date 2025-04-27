package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainhomepagemytasksnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainHomePageMyTasksNew.jsp", 1709115550090L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'styleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n</HEAD>\n<BODY  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script language=javascript src=\'../../eCA/js/CAMainMyTasks.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<!--<script language=javascript>\n\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n<form>\n<!--<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n<tr><td  colspan=\'5\' class=\'COMMONTOOLBARFUNCTION\' style=\'border:0\'><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></td></tr>\n</table>-->\n<table cellspacing=\'0\' cellpadding=3  border=1 width=100% align=\'left\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<TR>\n\t\t\t\t<TD class=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' nowrap>\n\t\t\t\t\t<b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' nowrap>&nbsp;&nbsp;&nbsp;\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<a  href=\'javascript:reviewWindow();\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")</a>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="(0)\t\t\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td></tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<a  href=\"javascript:reviewWindow(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")</a>\t\t\t\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="(0)\t\t\t\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<a class=\'gridLink\' href=\"javascript:reviewWindow(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >&nbsp;</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n<input type=\'hidden\' name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></input>\n</form>\n</body>\n</html>\n\n";
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;	
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
	String classValue = "WHITEROW";
	int i = 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
		String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		String ViewConfFlag = "X";
		String s1="";
		int count_abn = 0;
		int count_norm = 0;
		int count_crt = 0;
		int total = 0;
		String comp_id = "";
		String comp_desc = "";
		String group_desc = "";

		s1="Select GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,null) from dual";
		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,resp_id);
		rsComp = pstmtComp.executeQuery();
		if (rsComp.next())
			ViewConfFlag=rsComp.getString(1);	

		if(rsComp != null)		rsComp.close();
		if(pstmtComp != null)	pstmtComp.close();

		String sql="select sum(case when A.normalcy_ind in (c.HIGH_STR,c.LOW_STR,c.ABN_STR) then 1 else 0 end) Abnormal_count ,sum(case when A.normalcy_ind in (c.CRIT_STR,c.CRIT_HIGH_STR,c.CRIT_LOW_STR) then 1 else 0 end) critical_count,   count(*) tot_cnt from  ca_result_review_pend_log a, CR_CLIN_EVENT_PARAM c where A.pract_id =? and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and exists (select 1 from cr_encounter_detail where HIST_REC_TYPE  =a.HIST_REC_TYPE and CONTR_SYS_ID=a.CONTR_SYS_ID and ACCESSION_NUM=a.ACCESSION_NUM and CONTR_SYS_EVENT_CODE=a.EVENT_CODE and nvl(status,'#') != 'S' ";
		if ( ViewConfFlag.equals("X"))
			sql= sql+" and nvl(PROTECTION_IND,'#')!='Z' ";  	 
		sql= sql+" )  ";
			
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Clin_id);
		rset=pstmt.executeQuery();

		if(rset.next())
		{
			count_abn = rset.getInt(1);
			count_crt = rset.getInt(2);
			total = rset.getInt(3);
			count_norm = total - (count_abn + count_crt);
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		sql = "select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = 'RESLT_REVW' ";
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset.next())
			group_desc = rset.getString(1);
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		s1="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A where PRACT_TYPE =? AND PRACTITIONER_ID = ?  and COMP_ID in('RSLT_RV_AL','RSLT_RV_AN','RSLT_RV_CR','RSLT_RV_NR') ";

		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		
		rsComp = pstmtComp.executeQuery();
		
		while(rsComp.next())
		{
			i = i+1;
			if(i == 1)
			{
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
				i++;
			}
			comp_id = rsComp.getString("COMP_ID");
			comp_desc = rsComp.getString("COMP_DESC");
			if(comp_id.equals("RSLT_RV_AL"))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
				if (total != 0)
				{
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total));
            _bw.write(_wl_block16Bytes, _wl_block16);
 
				}
				else
				{ 
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
 
				}
	
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else if(comp_id.equals("RSLT_RV_AN"))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
				if (count_abn != 0)
				{
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count_abn));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
				}
				else
				{ 
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
				}
	
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else if(comp_id.equals("RSLT_RV_CR"))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
				if (count_crt != 0)
				{
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count_crt));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
				}
				else
				{ 
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
				}
	
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else if(comp_id.equals("RSLT_RV_NR"))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
				if (count_norm != 0)
				{
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count_norm));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
				}
				else
				{ 
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
				}
	
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
		}
		for(int j=i+1;j<=6;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in CAMainHomePageMyTasksNew.jsp: "+e.toString());//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getQueryString()));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResultsforReview.label", java.lang.String .class,"key"));
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
