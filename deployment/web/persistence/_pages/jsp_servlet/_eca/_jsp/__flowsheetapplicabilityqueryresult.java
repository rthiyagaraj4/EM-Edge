package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheetapplicabilityqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetApplicabilityQueryResult.jsp", 1725858986573L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- Added by Arvind @ 08-12-08 -->\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<br>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t<tr align = \'right\'>\n\t<td class=\'white\' width=\'95%\'></td> \n\t<td  align=\'right\' width=\'5%\' nowrap>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t<tr>\n\t\t<th class=\'columnHeadercenter\' align=\'left\' style=\"color: white;\" >\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</th>\n\t\t<th class=\'columnHeadercenter\' align=\'left\' style=\"color: white;\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</th>\n\t\t<th class=\'columnHeadercenter\' align=\'left\' style=\"color: white;\" >\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</th>\t\n\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t\t<td class=\'gridData\'> \n\t\t<a class=\'gridLink\' href=\"../../eCA/jsp/FlowSheetApplicabilityIntermediate.jsp?pat_class=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="+&mode=modify +&patientClassidnew=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="+&flow_sheet_id_mode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="+&speciality_code_mode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="+&practitioner_id_mode=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="+&patientClassId=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="+&spl=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="+&practr=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="+&lookup=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</a>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</table>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Properties p = (Properties)session.getValue("jdbc");
//String locale	= (String) p.getProperty("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	ResultSet rset = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	//String sqlQuery = "";
	//String sqlCount = "";
	//String mode = "modify";
	//String sql = " ";
	int maxRecord = 0;
	String classValue = "gridData";
	int rowCount = 0;
	int count = 0;
	//String summaryId = "";
	String lookup="";
	String patientClassId = "";
	String practitionerId  = "";
	String specialtyId = "";

	StringBuffer sql = new StringBuffer();
	StringBuffer sqlQuery = new StringBuffer();
	StringBuffer sqlCount = new StringBuffer();

	String whereClause = request.getParameter("whereClause");
	if(whereClause == null || whereClause.equals(""))
	whereClause = "";
	int start = 0;
	int end =  0;
	 String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String patientClass = request.getParameter("patclass");
	String specialty =  request.getParameter("speciality");
	String practitioner =  request.getParameter("pctr");
	lookup=  request.getParameter("lookup");
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	int i = 0;
	if(patientClass == null || patientClass.equals(""))
		patientClass = "";
	if(specialty == null || specialty.equals(""))
		specialty = "";
	if(practitioner == null || practitioner.equals(""))
		practitioner = "";
	if(lookup == null || lookup.equals(""))
		lookup = "";	
	if(whereClause.equals(""))
	{
		if(! patientClass.equals(""))
		{
			//sql = new StringBuffer();
			sql.append(" and A.PRACT_TYPE ='"+patientClass+"' ");
			count++;
		}
			if(! specialty.equals(""))
			{
				if(count > 0)
				{
							sql.append("  AND  Upper(A.SPECIALITY_CODE) like '"+specialty.toUpperCase()+"%' ");
				}
				else
				{
							//sql = new StringBuffer();
							sql.append(" and  upper(A.SPECIALITY_CODE) like '"+specialty.toUpperCase()+"%' ");
				}
			}
			if(!practitioner.equals(""))
			{
				if(count>0)
				{
					sql.append("  AND  upper(A.PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
				}
				else
				{
					//sql = new StringBuffer();
					sql.append(" and upper(A.PRACTITIONER_ID) like '"+practitioner.toUpperCase()+"%' ");
				}
			}
			if(!lookup.equals(""))
			{
				if(count>0)
				{
					sql.append("  AND  upper(A.FLOW_SHEET_ID) like '"+lookup.toUpperCase()+"%' ");
				}
				else
				{
					//sql = new StringBuffer();
					sql.append("  AND  upper(A.FLOW_SHEET_ID) like '"+lookup.toUpperCase()+"%' ");
				}
			}
		String orderByClause = "";
	String OrderBy [] = request.getParameterValues("orderbycolumns");
	sql.append(" order by ");
	if(OrderBy.length != 0)
	{
		if(OrderBy.length > 1 )
		{
			for(i = 0 ; i < OrderBy.length ; i++ )
			{
				if(orderByClause.equals(""))
				orderByClause = OrderBy[i] ;
				else
				orderByClause = orderByClause + "," + OrderBy[i];
			}
		}
		else
		{
				orderByClause = OrderBy[0];
		}
	}

	sql.append(orderByClause);
	}
	else
	{
		//sql = new StringBuffer();
		sql.append(whereClause);
	}

	 if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;
    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;


	try
	{
		con  = ConnectionManager.getConnection(request);		
		
		sqlQuery.append("SELECT A.PRACT_TYPE,NVL(nvl(B.DESC_USERDEF,B.DESC_SYSDEF),'All') PRACT_TYPE_DESC,A.PRACTITIONER_ID,NVL(C.PRACTITIONER_NAME,'All') PRACTITIONER_NAME,A.SPECIALITY_CODE,NVL(D.SHORT_DESC,'All') SPECIALITY_DESC,A.FLOW_SHEET_ID,NVL(E.SHORT_DESC,'All') FLOWSHEET_DESC FROM CA_FLOW_SHEET_APPLICABLITY A,AM_PRACT_TYPE B,AM_PRACTITIONER C,AM_SPECIALITY  D,CA_FLOW_SHEET E WHERE B.PRACT_TYPE(+)=A.PRACT_TYPE AND C.PRACTITIONER_ID(+)=A.PRACTITIONER_ID AND D.SPECIALITY_CODE(+)=A.SPECIALITY_CODE AND E.FLOW_SHEET_ID (+)=A.FLOW_SHEET_ID ");
//		sqlQuery.append("SELECT A.PRACT_TYPE,NVL(nvl(AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,?,'2'),AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,?,'1')),'All') PRACT_TYPE_DESC,A.PRACTITIONER_ID,NVL(C.PRACTITIONER_NAME,'All') AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'1')PRACTITIONER_NAME,A.SPECIALITY_CODE,NVL(AM_GET_dESC.AM_SPECIALITY(A.SPECIALITY_CODE,?,'2'),'All') SPECIALITY_DESC,A.FLOW_SHEET_ID,NVL(CA_GET_DESC.CA_FLOW_SHEET(A.FLOW_SHEET_ID,?,'2'),'All') FLOWSHEET_DESC FROM CA_FLOW_SHEET_APPLICABLITY A ");
		sqlQuery.append(sql.toString());

            _bw.write(_wl_block1Bytes, _wl_block1);
		sqlCount.append("SELECT  count(*) total FROM CA_FLOW_SHEET_APPLICABLITY A,AM_PRACT_TYPE B,AM_PRACTITIONER C,AM_SPECIALITY  D,CA_FLOW_SHEET E WHERE B.PRACT_TYPE(+)=A.PRACT_TYPE AND C.PRACTITIONER_ID(+)=A.PRACTITIONER_ID AND D.SPECIALITY_CODE(+)=A.SPECIALITY_CODE AND E.FLOW_SHEET_ID (+)=A.FLOW_SHEET_ID");
			sqlCount.append(sql.toString());
		stmt = con.prepareStatement(sqlCount.toString());
		rset = stmt.executeQuery();
		rset.next();
		maxRecord = rset.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		i=1;

            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		{
		
		out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetApplicabilityQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
	if ( !( (start+pageCnt) > maxRecord ) )
		{
	
		
		out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/FlowSheetApplicabilityQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereClause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

stmt1 = con.prepareStatement(sqlQuery.toString());
/*
stmt1.setString(1,locale);
stmt1.setString(2,locale);
stmt1.setString(3,locale);
stmt1.setString(4,locale);
stmt1.setString(5,locale);
*/
	rs = stmt1.executeQuery();
	String patientClassidnew="";
	String flow_sheet_id_mode="";
	String practitioner_id_mode="";
	String speciality_code_mode="";

    for( int j=1; j<start; i++,j++ )
      rs.next() ;
      while ( rs.next() && i<= end  ) 
	{
		classValue =((rowCount & 1) == 0) ? "gridData" : "gridData";
		lookup= rs.getString("FLOWSHEET_DESC");
		patientClassidnew=rs.getString("PRACT_TYPE");

		flow_sheet_id_mode=rs.getString("flow_sheet_id");
		practitioner_id_mode=rs.getString("practitioner_id");
		speciality_code_mode=rs.getString("speciality_code");
        
		patientClassId = rs.getString("PRACT_TYPE_DESC");
		
		practitionerId = rs.getString("PRACTITIONER_NAME");
		
		specialtyId =  rs.getString("SPECIALITY_DESC"); 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientClassId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientClassidnew));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(flow_sheet_id_mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(speciality_code_mode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_id_mode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientClassId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(specialtyId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(lookup));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block23Bytes, _wl_block23);

		out.println("<td class='"+classValue+"'>"+rs.getString(4)+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString(6)+"</td>");
		out.println("<td class='"+classValue+"'>"+rs.getString(8)+"</td>");
		out.println("</tr>");
		rowCount ++;
		i++;
	}

            _bw.write(_wl_block24Bytes, _wl_block24);
	if(rset != null) rset.close();
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	}
catch(Exception e)
{
	//out.println("Exception in FlowSheetApplicabilityQueryResult.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	
	if(con != null) ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FlowSheet.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
