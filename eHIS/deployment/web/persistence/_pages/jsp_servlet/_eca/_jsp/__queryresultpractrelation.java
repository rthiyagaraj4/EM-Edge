package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __queryresultpractrelation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QueryResultPractRelation.jsp", 1720000738754L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<HTML>\n<head>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t\n\t\n\t\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t<td class=\'white\' width=\'88%\'></td>\n<td align=\'right\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<table width=\"100%\" class=\'grid\' >\n<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<!-- <th width=\'10%\'>Enabled</th> -->\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n</tr>\n</table>\n</center>\n\n<br><center>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	Connection conn=null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset = null;

    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
    String relation_id  = request.getParameter("pract_reln_id");
    String relation_name = request.getParameter("pract_reln_name");
    String ip_attend = request.getParameter("ip_attend_phys_yn");
	String ip_admit = request.getParameter("ip_admit_phys_yn");
	String op_attend = request.getParameter("op_attend_phys_yn");
	String ae_attend = request.getParameter("ae_attend_phys_yn");
	String dc_attend = request.getParameter("dc_attend_phys_yn");
	String referal_reln = request.getParameter("referal_reln_yn");
	String attend_nurse = request.getParameter("attend_nurse_reln_yn");
	String ip_default = request.getParameter("dflt_ip_attend_phys_yn");
	String ip_admit_default = request.getParameter("dflt_ip_admit_phys_yn");
	String op_default = request.getParameter("dflt_op_attend_phys_yn");
	String ae_default = request.getParameter("dflt_ae_attend_phys_yn");
	String dc_default = request.getParameter("dflt_dc_attend_phys_yn");
	String referral_deflt = request.getParameter("dflt_referal_reln_yn");
	String nm_default = request.getParameter("dflt_attend_nurse_reln_yn");
	//Modified by Archana @10-12-2008
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;
	//if(sql.length() > 0) sql.delete(0,sql.length());
	if ( !(relation_id == null || relation_id.equals("")) )
        {
		if(sql.length() > 0) sql.delete(0,sql.length());
	        sql.append(" where upper(PRACT_RELN_ID ) like upper('"+relation_id +"%')");
			cnt++;
        }

        if ( !(relation_name == null || relation_name.equals("")) )
        {
			if(cnt>0)
			{
				sql.append(" and upper(PRACT_RELN_NAME) like upper('"+relation_name+"%')");
			}
			else
			{
				sql.append(" where upper(PRACT_RELN_NAME) like upper('"+relation_name+"%')");
				cnt=1;
			}

        }

	 if ( !(ip_attend == null || ip_attend.equals("")) )
    {
         if( ip_attend.equals("Y") )
         {
			if(cnt>0)
			 {
				//out.println("cnt in if"+cnt);
			   sql.append(" and ip_attend_phys_yn='Y'");
			 }
			else
			 {
				//out.println("cnt in else"+cnt);
				sql.append(" where  ip_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_attend.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and ip_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  ip_attend_phys_yn='N'");
				cnt = 1;
			 }

         }

         if ( ip_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ip_admit == null || ip_admit.equals("")) )
    {
         if( ip_admit.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and ip_admit_phys_yn='Y'");
			else
			 {
				sql.append(" where  ip_admit_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_admit.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and ip_admit_phys_yn='N'");
			else
			 {
				sql.append(" where  ip_admit_phys_yn='N'");
				cnt = 1;
			 }
         }

         if ( ip_admit.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
    
	if ( !(op_attend == null || op_attend.equals("")) )
    {
         if( op_attend.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and op_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  op_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( op_attend.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and op_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  op_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( op_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

		if ( !(ae_attend == null || ae_attend.equals("")) )
    {
         if( ae_attend.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and ae_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  ae_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ae_attend.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and ae_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  ae_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ae_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(dc_attend == null || dc_attend.equals("")) )
    {
         if( dc_attend.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dc_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dc_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( dc_attend.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dc_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dc_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( dc_attend.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
	
	if ( !(referal_reln == null || referal_reln.equals("")) )
    {
         if( referal_reln.equals("Y") )
         {
			if(cnt>0)
			  sql.append(" and referal_reln_yn='Y'");
			else
			 {
				sql.append(" where  referal_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( referal_reln.equals("N") )
         {
			if(cnt>0)
			   sql.append(" and referal_reln_yn='N'");
			else
			 {
				sql.append(" where  referal_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( referal_reln.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
	
	if ( !(attend_nurse == null || attend_nurse.equals("")) )
    {
         if( attend_nurse.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and attend_nurse_reln_yn='Y'");
			else
			 {
				sql.append(" where  attend_nurse_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( attend_nurse.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and attend_nurse_reln_yn='N'");
			else
			 {
				sql.append(" where  attend_nurse_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( attend_nurse.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ip_default == null || ip_default.equals("")) )
    {
         if( ip_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ip_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ip_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ip_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ip_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ip_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

    if ( !(ip_admit_default == null || ip_admit_default.equals("")) )
    {
         if( ip_admit_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ip_admit_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ip_admit_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ip_admit_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ip_admit_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ip_admit_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ip_admit_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

    if ( !(op_default == null || op_default.equals("")) )
    {
         if( op_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_op_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_op_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( op_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_op_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_op_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( op_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(ae_default == null || ae_default.equals("")) )
    {
         if( ae_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_ae_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_ae_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( ae_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_ae_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_ae_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( ae_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(dc_default == null || dc_default.equals("")) )
    {
         if( dc_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_dc_attend_phys_yn='Y'");
			else
			 {
				sql.append(" where  dflt_dc_attend_phys_yn='Y'");
				cnt = 1;
			 }

         }
         if ( dc_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_dc_attend_phys_yn='N'");
			else
			 {
				sql.append(" where  dflt_dc_attend_phys_yn='N'");
				cnt = 1;
			 }


         }

         if ( dc_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(referral_deflt == null || referral_deflt.equals("")) )
    {
         if( referral_deflt.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_referal_reln_yn='Y'");
			else
			 {
				sql.append(" where  dflt_referal_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( referral_deflt.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_referal_reln_yn='N'");
			else
			 {
				sql.append(" where  dflt_referal_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( referral_deflt.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }

	if ( !(nm_default == null || nm_default.equals("")) )
    {
         if( nm_default.equals("Y") )
         {
			if(cnt>0)
			   sql.append(" and dflt_attend_nurse_reln_yn='Y'");
			else
			 {
				sql.append(" where  dflt_attend_nurse_reln_yn='Y'");
				cnt = 1;
			 }

         }
         if ( nm_default.equals("N") )
         {
			if(cnt>0)
			  sql.append(" and dflt_attend_nurse_reln_yn='N'");
			else
			 {
				sql.append(" where  dflt_attend_nurse_reln_yn='N'");
				cnt = 1;
			 }


         }

         if ( nm_default.equals("B") )
         {
//               sql = sql; //nothing is added to get both E and D
         }
    }
	//appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
       sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
           sql.append(ord[i]);
        else
			{
            sql.append(ord[i]);
			sql.append(",");
			}
        }
    }

    } //end of where clause IF
    else
            sql.append(whereClause);




    int start = 0 ;
    int end = 0 ;
    int i=1;

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
	conn  =  ConnectionManager.getConnection(request);
	int maxRecord = 0;


StringBuffer strsql= new StringBuffer();
if(strsql.length() > 0) strsql.delete(0,strsql.length());
strsql.append("select count(*) as total from ca_pract_reln");
strsql.append(sql);
//out.println(sql);
StringBuffer strsql1= new StringBuffer();
if(strsql1.length() > 0) strsql1.delete(0,strsql1.length());
strsql1.append("select PRACT_RELN_ID,PRACT_RELN_NAME, LIFETIME_OR_ENCNTR, EFF_STATUS FROM  ca_pract_reln ");
strsql1.append(sql);
//out.println(strsql1);
stmt = conn.prepareStatement(strsql.toString());
ResultSet rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");


if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}

stmt1=conn.prepareStatement(strsql1.toString());
rset = stmt1.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultPractRelation.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/QueryResultPractRelation.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= "gridData";
      while ( rset.next() && i<=end  )
{
/*    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;*/
    out.println("<tr class='grid' ><td  class='" + classValue + "'>");

    relation_id = rset.getString(1);
    relation_name=rset.getString(2);
    String nature= rset.getString(3);
	if(nature.equals("E")) nature="Encounter Specific";
	else if(nature.equals("L")) nature="LifeTime";

	out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+"' target='f_query_add_mod' >");
        out.println(relation_id+"</a></td><td class='" + classValue + "'>");
 //   out.println("<a href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+" target='f_query_add_mod' >");
    out.println( rset.getString(2) );
    out.println("</td>");
//    out.println("</td><td class='" + classValue + "'>");
   // out.println("<a href='../../eCA/jsp/AddModifyPractRelation.jsp?relation_id="+ relation_id + "&relation_name="+relation_name+"&nature="+nature+" target='f_query_add_mod' >");
    /*out.println(nature );
    out.println("</td><td class='" + classValue + "' align='center'>");
    if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
*/
	i++;
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(rset!=null) rset.close();
		if(stmt1!=null)	stmt1.close();
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
     e.printStackTrace();//COMMON-ICN-0181
}
finally
{
if(conn!=null)ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RelationshipID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RelationshipName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
