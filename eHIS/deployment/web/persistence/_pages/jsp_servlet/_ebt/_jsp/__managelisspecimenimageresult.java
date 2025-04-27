package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimageresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageResult.jsp", 1709115156259L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<!-- <script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script> -->\n\t\t<script src=\"../../eBT/js/ManageLISSpecimenImage.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onscroll=\'staticTr()\'>\n\t\t<form name=\'LISImgResForm\' id=\'LISImgResForm\'>\t\t\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<P>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br><br>\n\t\t\t</p>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' align=\'center\'>\n\t\t\t\t<tr id=\'imageResTr\'>\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> \n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);

			//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String sStyle = "IeStyle.css";//Sanjay
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtPatName = null;
		PreparedStatement pstmtSourceDet = null;
		ResultSet res = null;
		ResultSet resPatName = null;
		ResultSet resSourceDet = null;	

		//String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String facilityId = "HS";//Sanjay
		String sectionCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
		String fromSpecNum = request.getParameter("fromSpecNum") == null ? "" : request.getParameter("fromSpecNum");
		String toSpecNum = request.getParameter("toSpecNum") == null ? "" : request.getParameter("toSpecNum");
		String fromSpecRegdDate = request.getParameter("fromSpecRegdDate") == null ? "" : request.getParameter("fromSpecRegdDate");
		fromSpecRegdDate = DateUtils.convertDate(fromSpecRegdDate,"DMYHM",locale,"en");
		String toSpecRegdDate = request.getParameter("toSpecRegdDate") == null ? "" : request.getParameter("toSpecRegdDate");
		toSpecRegdDate = DateUtils.convertDate(toSpecRegdDate,"DMYHM",locale,"en");
		String fromCatNum = request.getParameter("fromCatNum") == null ? "" : request.getParameter("fromCatNum");
		String frmCatYr = request.getParameter("frmCatYr") == null ? "" : request.getParameter("frmCatYr");
		String frmCatNoPart = request.getParameter("frmCatNoPart") == null ? "" : request.getParameter("frmCatNoPart");
		String toCatNum = request.getParameter("toCatNum") == null ? "" : request.getParameter("toCatNum");
		String toCatYr = request.getParameter("toCatYr") == null ? "" : request.getParameter("toCatYr");
		String toCatNoPart = request.getParameter("toCatNoPart") == null ? "" : request.getParameter("toCatNoPart");
		String priority = request.getParameter("priority") == null ? "" : request.getParameter("priority");
		String from = request.getParameter("from") ;
	    String to = request.getParameter("to") ;

		String specimenNum = "";
		String specRegdDate = "";
		String patId = "";
		String episodeType = "";
		String patName = "";
		String patSex = "";
		String sourceType = "";
		String sourceCode = "";
		String sourceDesc = "";
		String catNum = "";
		String classValue = "QRYEVEN";

		int count = 0;
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if (from == null)
			start = 1 ;
		else
			start = Integer.parseInt(from);

		if (to == null)
			end = 14 ;
		else
			end = Integer.parseInt(to) ;

		StringBuffer sqlRes = new StringBuffer("SELECT A.specimen_no, to_char(A.spec_regd_date_time,'dd/mm/yyyy hh24:mi') spec_regd_date_time, A.source_type, A.source_code, A.category_code,	A.category_year, A.category_number, A.section_code,	A.urgent_indicator, B.patient_id, B.episode_type, A.category_code || ' ' || A.category_year || ' ' || A.category_number category_no FROM RL_OUTSTANDING_WORK A, RL_REQUEST_HEADER B WHERE A.operating_facility_id = ? and a.section_code = ? ");

		if(!fromSpecNum.equals("") && !toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no >= ? and  a.specimen_no <= ? ");
		}
		else if(!fromSpecNum.equals("") && toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no >= ? ");
		}
		else if(fromSpecNum.equals("") && !toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no <= ? ");
		}

		if(!fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time >= to_date(?,'dd/mm/yyyy hh24:mi') and A.spec_regd_date_time <= to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		else if(!fromSpecRegdDate.equals("") && toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time >= to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		else if(fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time <= to_date(?,'dd/mm/yyyy hh24:mi') ");
		}

		if(!fromCatNum.equals("") && !toCatNum.equals(""))
		{
			sqlRes.append(" and A.category_code >= ? and  A.category_code <= ? ");
		}
		else if(!fromCatNum.equals("") && toCatNum.equals(""))
		{
			sqlRes.append(" and A.category_code >= ?  ");
		}
		else if(fromCatNum.equals("") && !toCatNum.equals(""))
		{
			sqlRes.append(" and  A.category_code <= ?  ");
		}

		if(!frmCatYr.equals("") && !toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year >= ?  and A.category_year <= ? ");
		}
		else if(!frmCatYr.equals("") && toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year >= ? ");
		}
		else if(frmCatYr.equals("") && !toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year <= ? ");
		}

		if(!frmCatNoPart.equals("") && !toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number >= ?  and A.category_number <= ? ");			
		}
		else if(!frmCatNoPart.equals("") && toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number >= ? ");
		}
		else if(frmCatNoPart.equals("") && !toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number <= ? ");
		}


		if(!priority.equals(""))
		{
			sqlRes.append(" and A.urgent_indicator = ? ");
		}

		sqlRes.append(" AND A.specimen_no = B.specimen_no AND A.operating_facility_id = B.operating_facility_id ORDER BY specimen_no ");
	
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sqlRes.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,sectionCode);

			if(!fromSpecNum.equals("") && !toSpecNum.equals(""))
			{
				pstmt.setString(++count,fromSpecNum);
				pstmt.setString(++count,toSpecNum);
			}
			else if(!fromSpecNum.equals("") && toSpecNum.equals(""))
			{
				pstmt.setString(++count,fromSpecNum);
			}
			else if(fromSpecNum.equals("") && !toSpecNum.equals(""))
			{
				pstmt.setString(++count,toSpecNum);
			}

			if(!fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,fromSpecRegdDate);
				pstmt.setString(++count,toSpecRegdDate);
			}
			else if(!fromSpecRegdDate.equals("") && toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,fromSpecRegdDate);
			}
			else if(fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,toSpecRegdDate);
			}

			if(!fromCatNum.equals("") && !toCatNum.equals(""))
			{
				pstmt.setString(++count,fromCatNum);
				pstmt.setString(++count,toCatNum);
			}
			else if(!fromCatNum.equals("") && toCatNum.equals(""))
			{
				pstmt.setString(++count,fromCatNum);
			}
			else if(fromCatNum.equals("") && !toCatNum.equals(""))
			{
				pstmt.setString(++count,toCatNum);
			}

			if(!frmCatYr.equals("") && !toCatYr.equals(""))
			{
				pstmt.setString(++count,frmCatYr);
				pstmt.setString(++count,toCatYr);
			}
			else if(!frmCatYr.equals("") && toCatYr.equals(""))
			{
				pstmt.setString(++count,frmCatYr);
			}
			else if(frmCatYr.equals("") && !toCatYr.equals(""))
			{
				pstmt.setString(++count,toCatYr);
			}

			if(!frmCatNoPart.equals("") && !toCatNoPart.equals(""))
			{
				pstmt.setString(++count,frmCatNoPart);
				pstmt.setString(++count,toCatNoPart);
			}
			else if(!frmCatNoPart.equals("") && toCatNoPart.equals(""))
			{
				pstmt.setString(++count,frmCatNoPart);
			}
			else if(frmCatNoPart.equals("") && !toCatNoPart.equals(""))
			{
				pstmt.setString(++count,toCatNoPart);
			}
	
			if(!priority.equals(""))
			{
				pstmt.setString(++count,priority);
			}

			res = pstmt.executeQuery();
			while(res.next())
			{
				maxRecord++;
			}
			if(maxRecord == 0)
			{
				//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			
				//out.println("<script>alert(s1);history.go(-1);</script>");				
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				//out.println("<script>alert("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"NO_RECORD_FOUND_FOR_CRITERIA", "Common")+");history.go(-1);</script>");
				//out.println("<script>alert(getMessage("+"NO_RECORD_FOUND_FOR_CRITERIA"+","+"common"+")"+");history.go(-1);</script>");
				//out.println("<script>alert('No Sanjay'));history.go(-1);</script>");
			}
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			if (!(start <= 1))
				out.println("<A HREF='../../eBT/jsp/ManageLISSpecimenImageResult.jsp?from="+(start-14)+"&to="+(end-14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eBT/jsp/ManageLISSpecimenImageResult.jsp?from="+(start+14)+"&to="+(end+14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			res.beforeFirst();

			if(start != 1)
				for(int j=1; j<start; i++,j++)
				  res.next() ;			
		    while(res.next() && i<=end)
			{
				
				episodeType = res.getString("episode_type") == null ? "" : res.getString("episode_type");
				patId = res.getString("patient_id") == null ? "" : res.getString("patient_id");
				sourceType = res.getString("source_type") == null ? "" : res.getString("source_type");
				sourceCode = res.getString("source_code") == null ? "" : res.getString("source_code");
				specimenNum = res.getString("specimen_no") == null ? "" : res.getString("specimen_no");
				specRegdDate = res.getString("spec_regd_date_time") == null ? "" : res.getString("spec_regd_date_time");
				catNum = res.getString("category_no") == null ? "" : res.getString("category_no");
				
				if(episodeType.equals("I") || episodeType.equals("O") || episodeType.equals("H"))
				{
					pstmtPatName = con.prepareStatement("SELECT short_name, sex, date_of_birth FROM MP_PATIENT_MAST WHERE patient_id = ?");
				}
				else
				{
					pstmtPatName = con.prepareStatement("SELECT short_name, sex, date_of_birth FROM RL_PATIENT_MAST WHERE patient_id = ?");
				}
				pstmtPatName.setString(1,patId);
				resPatName = pstmtPatName.executeQuery();

				while(resPatName.next())
				{
					patName = resPatName.getString("short_name") == null ? "" : resPatName.getString("short_name");
					patSex = resPatName.getString("sex") == null ? "" : resPatName.getString("sex");
				}

				if(resPatName != null) resPatName.close();
				if(pstmtPatName != null) pstmtPatName.close();

				if(sourceType.equals("W"))
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM IP_WARD WHERE facility_id = ? AND ward_code = ?");					
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM IP_NURSING_UNIT_LANG_VW WHERE facility_id = ? AND NURSING_UNIT_CODE = ? AND Language_id = ?");					
					pstmtSourceDet.setString(1,facilityId);
					pstmtSourceDet.setString(2,sourceCode);
					pstmtSourceDet.setString(3,locale);
				}
				else if(sourceType.equals("C"))
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM OP_CLINIC_HIS_VW WHERE facility_id = ? AND clinic_code = ? ");
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM OP_CLINIC_LANG_VW WHERE facility_id = ? AND clinic_code = ? AND Language_id = ?");
					pstmtSourceDet.setString(1,facilityId);
					pstmtSourceDet.setString(2,sourceCode);
					pstmtSourceDet.setString(3,locale);
				}
				else
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM RL_REFERRAL WHERE referral_code = ? ");
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM RL_REFERRAL_LANG_VW WHERE referral_code = ? AND Language_id  = ?");
					pstmtSourceDet.setString(1,sourceCode);
					pstmtSourceDet.setString(2,locale);
				}

				resSourceDet = pstmtSourceDet.executeQuery();				

				while(resSourceDet.next())
				{
					sourceDesc = resSourceDet.getString("short_desc") == null ? "" : resSourceDet.getString("short_desc");
				}

				if(resSourceDet != null) resSourceDet.close();
				if(pstmtSourceDet != null) pstmtSourceDet.close();

				if(i % 2 == 0) classValue = "QRYEVEN";
				else classValue = "QRYODD";
				
				out.println("<tr>");
				out.println("<td class = '"+classValue+"'><a href=\"javascript:specimenDetails('"+specimenNum+"')\" >"+specimenNum+"</a></td>");
				out.println("<td class = '"+classValue+"'>"+specRegdDate+"</td>");
				out.println("<td class = '"+classValue+"'>"+patId+"</td>");
				out.println("<td class = '"+classValue+"'>"+patName+"</td>");
				out.println("<td class = '"+classValue+"'>"+patSex+"</td>");
				out.println("<td class = '"+classValue+"'>"+sourceDesc+"</td>");
				out.println("<td class = '"+classValue+"'>"+catNum+"</td>");
				out.println("</tr>");
				i++;
			}//end of while

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}//end of try
		catch(Exception e)
		{
			//out.println("Exception in try of ManageLISSpecimenImageResult.jsp --"+e.toString());
			//System.out.println("Exception in try of ManageLISSpecimenImageResult.jsp --"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.SpecimenNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegnDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.source.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CategoryCode.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
