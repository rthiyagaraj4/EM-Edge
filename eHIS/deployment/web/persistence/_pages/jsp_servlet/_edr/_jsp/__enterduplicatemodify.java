package jsp_servlet._edr._jsp;

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
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __enterduplicatemodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/EnterDuplicateModify.jsp", 1742292037871L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eDR/js/EnterDuplicatesPatientID.js\'></script>\n<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n<!-- <script language=\"javascript\" src=\"../../eDR/js/DRrowcolor.js\" ></script> -->\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\'add_form\' id=\'add_form\'  action=\'../../servlet/eDR.EnterDuplicatesServlet\' method=\'post\' target=\'messageFrame\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t <script>\n\t\t\t alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n  <script>\nparent.location.href=\'../../eCommon/html/blank.html\'\n</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table border=0 width=\'100%\' cellspacing=0  id=\'tb1\'>\n\t\t<tr>\n\t\t\t<td class=label width=\'80%\'></td>\n\t\t\t<td class=label width=\'20%\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'columnheader\'> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t</tr>\n\n\n </table>\n\t<table border=0 width=\'100%\' cellspacing=0  id=\'tb2\' >\n\t\n\t\t<tr>\n\t\t\t<td class=label width=\'100%\' colspan=3><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n\t\t</table>\n\n\t<table border=0 width=\'100%\' cellspacing=0  id=\'tb1\' >\n\t\t<tr>\n\t\t\t<td class=label width=\'5%\'></td>\n\t\t\t<td class=label width=\'75%\' ></td>\n\t\t\t<td class=label width=\'20%\'></td>\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<tr id=\'_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t\t\t\t<td class=\'label\' valign=top>\n\t\t\t\t\t\t\t<a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")\'>+</a></td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\'othlanglabel\' >\n\t\t\t\t\t\t\t<a name=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' href=\'javascript:callGroupDetails(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\")\' id=\'_a";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t\t\t\t\t\t\t\t</a><br>\n\t\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </font><input type=hidden name=record id=record value=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'label\' valign=top class=\'label\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=hidden name=count id=count value=\'\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<input type=hidden name=patient_id";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" value=\'\'>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t\t\t</table>\n\t\t\n\t\t\n\t\t<input type=hidden name=p_patcount id=p_patcount value=\'\'>\n\t\t<input type=hidden name=p_pat_count id=p_pat_count value=\'\'>\n\t\t<input type=hidden name=delete_string id=delete_string value=\'\'>\n\t    <input type=hidden name=p_string_value id=p_string_value value=\'\'>\n\t\t<input type=hidden name=function_name id=function_name value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=hidden name=mode id=mode value=\'insert\'>\n\t\t<input type=hidden name=dupgroupid id=dupgroupid value=\'\'>\n\t    \t\t\n\t\t\t\n\t\t\t</form>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	java.sql.Statement	stmt		=null;
	ResultSet	rs			=null;
	StringBuffer str1 = null;
try
{
	str1=new StringBuffer();
	con = ConnectionManager.getConnection(request);
	stmt					=con.createStatement();
	//String str				="";
	String p_patient_id		="";
	int p_pat_count			= 0;
	String p_patient_line	="";
	int p_dup_group_id	    = 0; 
	//int p_pat_rec_cnt		= 0;
	int p_no_of_groups		= 0;
	//int p_no_of_records		= 0;
	 String locale=(String)session.getAttribute("LOCALE");  
	String valid			="";
	demography d=new demography();

	///String sql	= "";
	String sql1 = "";
	//String strsql1	= "";
	//String p_order_by = "";
	
	String p_function_name = request.getParameter("function_name");
	String patient_id		=request.getParameter("patient_id");
	patient_id=patient_id.toUpperCase();
	if(patient_id==null) patient_id="";
	if(patient_id.equals("")) patient_id="";
	int x					= 0;
	int time_count			= 0;
	
	int i=1;



            _bw.write(_wl_block8Bytes, _wl_block8);

	//str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
    /* str  = "select order_by_for_process_cycle from dr_process_ctl " ;

	rs	 = stmt.executeQuery(str);

	if (rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		}*/
	
	sql1 = "select count(1) total_groups from dr_dup_group_vw2 where dup_indicator='V' and system_gen_yn='N' AND group_status = 'I' and patient_id not in (select patient_id from DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')";
	if(!patient_id.equals(""))
		{		
			sql1=sql1+"and UPPER(patient_id)='"+patient_id+"'";
		}
	
	rs = stmt.executeQuery(sql1);

	while (rs.next())
	{
		p_no_of_groups = rs.getInt("total_groups");
		
	}if(rs!=null) rs.close();

if (p_no_of_groups==0){ 
	 
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	}
else{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_no_of_groups));
            _bw.write(_wl_block14Bytes, _wl_block14);

	/*str1.append("select dup_group_id,patient_id,pat_count,mp_patient_added_date ");
	str1.append("from dr_dup_group_vw2 where dup_indicator='V' and system_gen_yn='N'and patient_id not in (select patient_id from DR_MERGED_PATIENT_DTLS)"); 
	if(!patient_id.equals("") )
		{
		
	str1.append("and UPPER(patient_id)='"+patient_id+"'");
	}*/
	
	//str1.append("SELECT  b.dup_group_id, patient_id,  pat_count,  mp_patient_added_date FROM  DR_DUP_GROUP_HDR A, DR_DUP_GROUP_DTLS B WHERE  A.DUP_GROUP_ID = B.DUP_GROUP_ID AND dup_indicator='V' AND system_gen_yn='N' AND  patient_id NOT IN (SELECT patient_id FROM DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')");

// Commented the above code and added the below code for SRR20056-SCF-5281 [IN:023889] by Suresh M on 21.09.2010
	str1.append("SELECT  b.dup_group_id, patient_id,  pat_count,  mp_patient_added_date FROM  DR_DUP_GROUP_HDR A, DR_DUP_GROUP_DTLS B WHERE  A.DUP_GROUP_ID = B.DUP_GROUP_ID AND dup_indicator='V' AND system_gen_yn='N' AND a.group_status = 'I' AND  patient_id NOT IN (SELECT patient_id FROM DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')");


	
	if(!patient_id.equals("") )
		{
			str1.append("AND UPPER(patient_id)='"+patient_id+"'");
		}


	rs  =stmt.executeQuery(str1.toString());

	if (rs != null)
	{
						while ( rs.next())
						{
							x= x + 1;
							time_count++;
							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_dup_group_id  = rs.getInt("dup_group_id");
							p_patient_line		=	d.name_age_sex(session ,p_patient_id,con,locale);

							//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:MM:SS");

						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_function_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block25Bytes, _wl_block25);

						i++;
					}
				}
			}
			for(int j=1;j<=p_pat_count ;j++){
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j% id=patient_id<%=j));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_function_name));
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.MainPatientID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NoofGroups.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
