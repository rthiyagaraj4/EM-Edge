package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;

public final class __querycurrentlodgersresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryCurrentLodgersResult.jsp", 1742452632122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\tif (parseInt(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\')==0)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\t\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			Connection con				= null;
			Statement stmt				= null;
			//PreparedStatement pstmt		= null;
			//PreparedStatement pstmt_count = null;
			ResultSet rs				= null;
			//ResultSet rs_count			= null;
			//int total_count				= 0;
			StringBuffer sql			= new StringBuffer();
//			StringBuffer sql_count		= new StringBuffer();
			int start					= 1;
			int end						= 0;
			int records_to_show			= 14;
			
			String facilityid	= (String)session.getValue("facility_id");
			String from			= request.getParameter("from");
			String to			= request.getParameter("to");
			StringBuffer whereClause	= new StringBuffer();
			whereClause.append(checkForNull(request.getParameter("whereclause")));
			String lodgerrefno	= checkForNull(request.getParameter("lodger_ref_no"));
			String fromdate		= checkForNull(request.getParameter("from_date"));
			String todate		= checkForNull(request.getParameter("to_date"));
			String gender		= checkForNull(request.getParameter("gender"));
			String attachedpatient= checkForNull(request.getParameter("attached_patient"));
			String locale		= (String)session.getAttribute("LOCALE");
			

			String className = "";
			int p_max_rec_cnt = 0;
			int nextOfRes = 1;

			int i = 0;

			if(!lodgerrefno.equals(""))
				whereClause.append(" and upper(A.lodger_patient_id)=upper('"+lodgerrefno+"') ");
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(A.check_in_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				whereClause.append(" and A.lodger_gender = '"+gender+"' ");
			if(attachedpatient.equals("Y"))
				whereClause.append(" and A.attached_to_inpatient_yn = 'Y' ");
		
            _bw.write(_wl_block4Bytes, _wl_block4);

			try{
				con =ConnectionManager.getConnection(request);

				//Added by Devang for Previous/Next logic
				/*sql_count.append(" select count(*) ");
				sql_count.append(" FROM IP_LODGER_DETAIL A, ");
				sql_count.append(" IP_REASON_FOR_LODGER_STAY b,IP_NURSING_UNIT C  ");
				sql_count.append(" WHERE A.reason_for_stay_code=B.reason_for_stay_code(+)  ");
				sql_count.append(" AND C.nursing_unit_code(+) = A.nursing_unit_code ");
				sql_count.append(" AND C.facility_id(+) = A.facility_id ");
				sql_count.append(" "+whereClause.toString()+" ");
				sql_count.append(" AND A.facility_id= ? AND check_out_yn='N'  ");
				
				pstmt_count = con.prepareStatement(sql_count.toString());
				pstmt_count.setString(1,facilityid);
				rs_count = pstmt_count.executeQuery();
				
				if(rs_count.next())
				{
					total_count=rs_count.getInt(1);
				}*/
					
				/*sql.append(" SELECT nvl(lodger_patient_id,'&nbsp;') lodger_ref_no, to_char(check_in_date_time,'dd/mm/rrrr hh24:mi') check_in_date_time, ");
				sql.append(" nvl(B.short_desc,'&nbsp;') Reason,nvl(C.short_desc,'&nbsp;') nursing_unit, ");
				sql.append(" nvl(lodger_name,'&nbsp;') lodger_name, decode(lodger_gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') lodger_gender, Attached_to_inpatient_yn,check_in_date_time check_in_date_time1  ");
				sql.append(" FROM IP_LODGER_DETAIL A, ");
				sql.append(" IP_REASON_FOR_LODGER_STAY b,IP_NURSING_UNIT C  ");
				sql.append(" WHERE A.reason_for_stay_code=B.reason_for_stay_code(+)  ");
				sql.append(" AND C.nursing_unit_code(+) = A.nursing_unit_code ");
				sql.append(" AND C.facility_id(+) = A.facility_id ");
				sql.append(" "+whereClause.toString()+" ");
				sql.append(" AND A.facility_id= ? AND check_out_yn='N'  order by check_in_date_time1 ");*/

				sql.append("SELECT nvl(lodger_patient_id,' ') lodger_ref_no,to_char(check_in_date_time,'dd/mm/rrrr hh24:mi') check_in_date_time,	Nvl(IP_GET_DESC.IP_REASON_FOR_LODGER_STAY(A.reason_for_stay_code,'"+locale+"','2'),'' )	Reason,  Nvl(IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.nursing_unit_code,'"+locale+"','2'),'') nursing_unit, nvl(lodger_name,' ') lodger_name, lodger_gender lodger_gender, Attached_to_inpatient_yn, check_in_date_time check_in_date_time1 FROM IP_LODGER_DETAIL A WHERE A.facility_id= '"+facilityid+"' AND A.check_out_yn='N' "+whereClause.toString()+" order by A.check_in_date_time");		
				//out.println(sql.toString());

				/*pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,facilityid);
				rs = pstmt.executeQuery();*/

				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery(sql.toString());
				if ( (rs != null) )
					{
					   rs.last();
					   total_count = rs.getRow();
					   rs.beforeFirst();
					}*/

				stmt = con.createStatement();
				rs = stmt.executeQuery(sql.toString());
					
				//added by Devang for Previous/Next
				if ( from == null )
                    start = 0 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;

				if(start > 1)
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}
				int z=0;
				while( (z < records_to_show) && rs.next() )
				{
					if(p_max_rec_cnt == 0)
					{
						out.println("<p><table align='right'><tr><td>");
						if ( !(start <= 0) )
								out.println("<A HREF='../jsp/QueryCurrentLodgersResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
								" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

						if ( nextOfRes == 1 )
								out.println("<A id='nextval' HREF='../jsp/QueryCurrentLodgersResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
								+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");
						out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
						out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CheckInDateTime.label","ip_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerId.label","ip_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPerson.label","ip_labels")+"</th></tr>");
					}						
				//while(rs.next() && (z < records_to_show))
				//{
					z++;
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";

					String sex = rs.getString("lodger_gender");

					if(sex.equalsIgnoreCase("M"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					String check_in_date_display = rs.getString("check_in_date_time");
					if(check_in_date_display == null)
						check_in_date_display = "";
					else
						check_in_date_display = DateUtils.convertDate(check_in_date_display,"DMYHM","en",locale);

					out.println("<td nowrap class='"+className+"'>"+check_in_date_display+"</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("Reason")==null?"&nbsp;":rs.getString("Reason"))+"</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("nursing_unit")==null?"&nbsp;":rs.getString("nursing_unit"))+"</td>");

					out.println("<td class='"+className+"' nowrap>"+(rs.getString("lodger_ref_no")==null?"&nbsp;":rs.getString("lodger_ref_no"))+"</td>");
					//out.println("<td nowrap class='"+className+"'>"+rs.getString("lodger_ref_no")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("lodger_name")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+sex+"</td>");
					out.println("<td nowrap align=center class='"+className+"'>");
					if(rs.getString("attached_to_inpatient_yn").equals("Y"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/disabled.gif'></img>");
					out.println("</td></tr>");
					i++;
					p_max_rec_cnt++;					
				}
			
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_max_rec_cnt));
            _bw.write(_wl_block6Bytes, _wl_block6);

				out.println("</table>");

				if( !rs.next() && p_max_rec_cnt!=0 )
				{
					nextOfRes=0;
				
            _bw.write(_wl_block7Bytes, _wl_block7);

				}

				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (pstmt != null) pstmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();

			}catch(Exception e) {out.println(e.toString());}
			finally
			{
				ConnectionManager.returnConnection(con,request);
				//added on 20-10-2003 by dhanasekaran
				out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
