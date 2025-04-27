package jsp_servlet._eqa._jsp;

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

public final class __qaindicatorreferencenote extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorReferenceNote.jsp", 1742817544713L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/Common.js\" language=\"javascript\"> </script>\n<Script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></Script>\n</head>\n<Script src=\"../../eQA/js/QADirRecordOfClinIndicators.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body  OnMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\'>\n<form name=\"QAReferrenceNote\" id=\"QAReferrenceNote\" method=\"post\" >\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n  <tr>\n  \t<td width=\'15%\'>&nbsp;</td>\n  \t<td width=\'85%\'>&nbsp;</td>\n  </tr>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\tException Occured ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

String strQindDesc = "";
String strStandardDesc = "";
String strAreaOfConcern = "";
String QIND_DISCIPLINE_DESC1="";
//QIND_DISCIPLINE_DESC1=request.getParameter("QIND_DISCIPLINE_DESC")==null?"": request.getParameter("QIND_DISCIPLINE_DESC");

int count=0;

 String strClinicalIndicatorId,indicator; 
 int value;

 

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

 	strClinicalIndicatorId=request.getParameter("QIND_CLIND_ID");
	QIND_DISCIPLINE_DESC1=request.getParameter("QIND_DISCIPLINE_DESC")==null?"": request.getParameter("QIND_DISCIPLINE_DESC");
 
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer sqlBuff = new StringBuffer();
	StringBuffer sql1Buff = new StringBuffer();

	ArrayList htVect = new ArrayList();
	count=0;
    int prevalue=0;
 
    sqlBuff.append("select QIND_CLIND_ID QCLIND,QIND_CLIND_DESC QCLIDES, ");
	sqlBuff.append(" STANDARD_DESC   STDES,AREA_OF_CONCERN AOC ");
	sqlBuff.append(" from QA_QIND_CLIND where QIND_CLIND_ID= ? ");
	try
		{
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,strClinicalIndicatorId);
			rs=pstmt.executeQuery();

		while(rs.next())
		{	 
		 strQindDesc = rs.getString("QCLIDES")==null? "":rs.getString("QCLIDES");;
		 strStandardDesc =rs.getString("STDES")==null? "":rs.getString("STDES");
		 strAreaOfConcern = rs.getString("AOC")==null? "":rs.getString("AOC");
		}	
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();

	    out.println("<TITLE align='center'>"+strQindDesc+"</TITLE>");
	    
		htVect.add(count++,"<td class='label' align='left' nowrap><b>Program </b></td>"+"<td class='label' align='left'> <p>&nbsp;PATIENT CARE</p></td>");



		htVect.add(count++,"<td class='label' align='left' nowrap><b>Area of Concern:</b></td>"+"<td class='label' align='left' ><p> &nbsp;"+strAreaOfConcern+"</p></td>");
	
		 htVect.add(count++,"<td class='label' align='left'nowrap><b>Indicator:</b></td>"+"<td class='label' align='left'><p> &nbsp;"+strQindDesc+"</p></td>");
	
        sql1Buff.append("select  NVL(REF_NOTE_TEXT,' ') REF_NOT,SECTION_ID SID from ");
		sql1Buff.append("QA_QIND_CLIND_REF_NOTE  where QIND_CLIND_ID=? order by SECTION_ID ");

		pstmt=conn.prepareStatement(sql1Buff.toString());
		pstmt.setString(1,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
			while(rs.next())
			{
				value=Integer.parseInt(rs.getString("SID"));			
				if(value !=100)
				value=value/10;
				indicator = "";
				switch(value)
				{
					case 3:indicator ="Rationale:";					
					break;
					case 4:indicator ="Definition of Terms:"; break;
					case 5:indicator ="Inclusion Criteria:";break; 
					case 6:indicator ="Exclusion Criteria:"; break;
					case 8:indicator ="Numerator:"; break;
					case 9:indicator ="Denominator:"; break;
					case 100:indicator ="Comments / Review:";break;
				}
		if(value !=prevalue)
		indicator = "<td class='label'  align='left' nowrap><b>"+indicator+"</b></td>	 <td class='label' align='left'> <p > &nbsp;" + 		rs.getString("REF_NOT")+"</p></td>";
		else	 indicator = 
			"<td class='label'  > <b>&nbsp;</b></td>	 <td align='left' class='label'> <p > &nbsp;" + 		rs.getString("REF_NOT")+"</p></td>";	

				htVect.add(indicator);	
				count++;
				prevalue=value;
			}	
			
				indicator = "<td class='label' align='left' nowrap> <b>Standard: </b> </td> <td align='left'> <p class='label'>&nbsp; " + strStandardDesc+"</p></td>";
				htVect.add(count,indicator);
			
				rs.close();
		
		for(count=0;count<htVect.size();count++)
		{
			out.println("<tr>");
			out.println(""+htVect.get(count));
			out.println("</tr> ");
			out.println("<tr><td colspan=4>&nbsp</td></tr>");
		}
		out.println("</table>");
	    if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
	htVect.clear();
	}catch(Exception ee)
	{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(ee));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
	finally
	{
			ConnectionManager.returnConnection(conn,request);
	}
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
