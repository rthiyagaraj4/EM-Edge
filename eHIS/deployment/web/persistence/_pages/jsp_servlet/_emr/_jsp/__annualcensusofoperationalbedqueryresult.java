package jsp_servlet._emr._jsp;

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

public final class __annualcensusofoperationalbedqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AnnualCensusofoperationalBedQueryResult.jsp", 1722236154111L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<!-- <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script> -->\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<body onmousedown=\'CodeArrest()\' onkeydown = \'lockKey()\'  class=\'content\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t</td>\n\t\t</tr>\n\n\t\t\t\n\n\t\t</table>\n\t\t<br>\n\t\t</P>\n\t\t<table border=\"1\" width=\"140%\" cellspacing=\'0\' cellpadding=\'0\'>\t\t\n\t\t<th width=\"10%\">Census Year</th>\n\t\t<th width=\"20%\">Level1 Group</th>\n\t\t<th width=\"20%\">Level2 Group</th>\n\t\t<th width=\"20%\">Bed Class Group</th>\n\t\t<th width=\"20%\">Bed Class Group Description</th>\n\t\t<th width=\"5%\">Comm Bed Cnt</th>\n\t\t<th width=\"5%\">Male Bed Cnt</th>\n\t\t<th width=\"5%\">Female Bed Cnt</th>\n\t\t<th width=\"5%\">Child Bed Cnt</th>\n\t\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String whereClause = request.getParameter("whereclause");
	String sql="" ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if((whereClause == null || whereClause.equals("")))
	{
		
		sql="";		
		String census_date	= request.getParameter("p_census_date");
			if(census_date == null) census_date = "";
		String main_group	= request.getParameter("main_group");
			if(main_group == null) main_group = "";
		String sub_group	= request.getParameter("sub_group");
			if(sub_group == null) sub_group = "";
		String catalog_desc	= request.getParameter("bed_class_group");
			if(catalog_desc == null) catalog_desc = "";			
		
		//group_code	=	group_code.toUpperCase();
		//group_name	=	group_name.toUpperCase();
		//report_id	=	report_id.toUpperCase();
		//mast_table_name_reference	=	mast_table_name_reference.toUpperCase();
		
		if(!(census_date == null || census_date.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " to_char(A.census_year,'YYYY') = '"+census_date+"'";
		}
		if(!(main_group == null || main_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.GROUP_CODE) like upper('"+main_group+"%')";
		}

		if(!(sub_group == null || sub_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.SUB_GROUP_CODE) like upper('"+sub_group+"%')";
		}
		if(!(catalog_desc == null || catalog_desc.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.BED_CLASS_GROUP_CODE) like upper('"+catalog_desc+"%')";
		}
     
		String ord[]=new String[4];
		String concatvalues= request.getParameter("concatvalues");
		 java.util.StringTokenizer st = new StringTokenizer(concatvalues,"|");
		 int i2=0;
        while (st.hasMoreTokens())
		{
               ord[i2]=st.nextToken();i2++;
         }
		//String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";

			//out.println("sql--------"+sql);
			}
		}
	}
	else 
	{
		sql = whereClause;
	}
	int start = 0;
	int end = 0;
	int i=1;
	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);
	if (to == null)
	  	end = 14;
	else
		end = Integer.parseInt(to);
		Connection conn =null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try
	{
	    System.err.println("AnnualCensusofoperationalBedQueryResult.jsp sql===>"+sql);
		conn=ConnectionManager.getConnection(request);
		String CountSql=" SELECT COUNT(*) TOTAL FROM mr_annual_census_of_opr_bed A " + sql ;
		System.err.println("AnnualCensusofoperationalBedQueryResult.jsp CountSql===>"+CountSql); 
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		String FinalSql=" select  to_char(A.census_year,'YYYY') CENSUS_YEAR,(SELECT group_desc from mr_report_grouping where group_code = A.GROUP_CODE and report_id =  'MRIPCSOBD')GROUP_CODE,(SELECT group_desc from mr_report_grouping where group_code = A.SUB_GROUP_CODE and report_id =  'MRIPCSOBD')SUB_GROUP_CODE, A.BED_CLASS_GROUP_CODE,A.COMM_BED_CNT,A.MALE_BED_CNT,A.FEMALE_BED_CNT,A.CHILD_BED_CNT,(SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE and report_id =  'MRIPCSOBD')bed_desc from mr_annual_census_of_opr_bed A " + sql ;
         
        System.err.println("AnnualCensusofoperationalBedQueryResult.jsp FinalSql===>"+FinalSql); 		 
		
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		stmt = conn.createStatement();		
		rs = stmt.executeQuery(FinalSql);
		
            _bw.write(_wl_block4Bytes, _wl_block4);

				if ( !(start <= 1) )
					out.println("<A HREF='../../eMR/jsp/AnnualCensusofoperationalBedQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Previous</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/AnnualCensusofoperationalBedQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
				
            _bw.write(_wl_block5Bytes, _wl_block5);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
		String classValue="";
		while ( rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
			String CESUS_YEAR =checkForNull(rs.getString("census_year"));
			String GROUP_DESC =checkForNull(rs.getString("GROUP_CODE"));
			String SUB_GROUP_DESC =checkForNull(rs.getString("SUB_GROUP_CODE"));
			//if(SUB_GROUP_DESC.equals("null") || SUB_GROUP_DESC==null)
             //SUB_GROUP_DESC="";
			String MAST_DESC =checkForNull(rs.getString("BED_CLASS_GROUP_CODE"));
			String BED_CLASS_DESC=checkForNull(rs.getString("bed_desc"));
		//	float count_float =rs.getFloat("ORDER_BY_SRL_NO");
			int   ORDER_BY_SRL_NO_INT=rs.getInt("COMM_BED_CNT");
			int   MALE_BED_CNT=rs.getInt("MALE_BED_CNT");
			int   FEMALE_BED_CNT=rs.getInt("FEMALE_BED_CNT");
			int   CHILD_BED_CNT=rs.getInt("CHILD_BED_CNT");
			
				
			if(GROUP_DESC.equals(""))
				GROUP_DESC="&nbsp";
			if(SUB_GROUP_DESC.equals(""))
				SUB_GROUP_DESC="&nbsp";
			if(BED_CLASS_DESC.equals(""))
				BED_CLASS_DESC="&nbsp";
			
			
			
		
		//	if(MAST_TABLE_NAME_REFERENCE.equals("NS"))
		//	MAST_TABLE_NAME_REFERENCE="Name Suffix";


			out.println("<tr>");
			
		
			out.println("<td class='"+classValue+"' width='10%'> "+CESUS_YEAR+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+SUB_GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+MAST_DESC+" </td>");
			out.println("<td  class='"+classValue+"'  width='20%'> "+BED_CLASS_DESC+"</td>");			
			
			
			if(ORDER_BY_SRL_NO_INT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+ORDER_BY_SRL_NO_INT+"</td>");
			}
			if(MALE_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+MALE_BED_CNT+"</td>");
			}
			if(FEMALE_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+FEMALE_BED_CNT+"</td>");
			}
			if(CHILD_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+CHILD_BED_CNT+"</td>");
			}
			

			out.println("</tr>");
			i++;
		}
	}
	catch(Exception e)
	{ 
		//out.println("Error in result page : "+e.toString());
		e.printStackTrace();
	}
	finally   
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
