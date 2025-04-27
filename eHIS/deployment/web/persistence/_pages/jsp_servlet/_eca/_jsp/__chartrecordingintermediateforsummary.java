package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingintermediateforsummary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingIntermediateForSummary.jsp", 1709115672996L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n    <head>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n<body onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con = null;
PreparedStatement pstmt =null;
ResultSet rs= null;
try
{
	con = ConnectionManager.getConnection(request);
	String adm_date =request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	
	int daySummary=0;
	
	ArrayList tempArray = new ArrayList();
	if(request.getParameter("summaryText")==null || request.getParameter("summaryText").equals(""))
	daySummary=0;
	else
	daySummary=Integer.parseInt(request.getParameter("summaryText"));
		
	//String encounterId = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			
	String patientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				
	String chartId = request.getParameter("chartId")==null?"":request.getParameter("chartId");
					
	String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");

	String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
	String defaultYN = request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")==null?"":request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN");
			
	StringBuffer sqlDates = new StringBuffer();
	String tempString = "";
	int start =0;
	int end =0;
	int maxRecord = 0;
	int count=0;

	if(defaultYN.equals("Y"))
	{
			tempString = " CA_ENCNTR_CHART_DRAFT B ";
	}
	else
	{
			tempString = "  CA_CHART_SECTION_COMP B ";
	}
	String facilityId = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
	 sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy'),a.TEST_OBSERV_DT_TM,a.DISCR_MSR_RESULT_TYPE  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and   a.facility_id=? and a.patient_id=? and a.DISCR_MSR_RESULT_TYPE ='S'   ");
	 	if(fromDate.equals("") && toDate.equals(""))
		{
			sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
		}
		if(!fromDate.equals("") && !toDate.equals(""))
		{
				sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') ");
		}
		else
		{
			if(!fromDate.equals(""))
				sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
			if(!toDate.equals(""))
				sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
		}
		sqlDates.append(" order by 2 Desc");
		tempString = "";
		pstmt =	con.prepareStatement(sqlDates.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);  
		pstmt.setString(++count,chartId);		
		pstmt.setString(++count,facilityId);
		pstmt.setString(++count,patientId);
		if(fromDate.equals("") && toDate.equals(""))
				pstmt.setString(++count,adm_date);
			if(!fromDate.equals("") && !toDate.equals("")) 
				{
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
				}
				else
				{	
					 if(!fromDate.equals(""))
							pstmt.setString(++count,fromDate);
					 if(!toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,toDate);
					}
				}
			start = 1 ;
			end = daySummary;
			rs = pstmt.executeQuery();	
			tempString = "Summary for Dates Between : ";
			while(rs.next())
			{
				if(start ==1)
				{
					tempString = tempString + rs.getString(1);
				}
				if(start== end)
				{
					tempString = tempString +" - " + rs.getString(1);
				}
				if(start > end )  break;
				
				start++;
			}

	out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title='"+tempString+"'</script>");
	out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForFirst.value='"+tempString+"'</script>");
	
		end = start  + daySummary;
		rs.beforeFirst();
		tempString = "Summary for Dates Between : ";
		int i=1;
		for(i=1;i < start ;i++)
			rs.next();
		if(	rs.next())
		{
			tempString =tempString + rs.getString(1) +" - ";
		}
		i = start ;
		while(rs.next() && i <= end)
		{
			if(i == end )
			tempString = tempString + rs.getString(1);
			i++;
		}
	
out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForNext.value='"+tempString+"'</script>");
		rs.afterLast();
		while(rs.previous())
		{			
			if(start > end )  break;
			tempArray.add(rs.getString(1));
			start++;
		}
		tempString = "Summary for Dates Between : ";
		tempString = tempString + (String)tempArray.get((tempArray.size() -2)) + " - " + (String)tempArray.get(0);
out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title='"+tempString+"'</script>");
out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForLast.value='"+tempString+"'</script>");
			start = daySummary ;
			end = start + daySummary;
			rs.beforeFirst();
			tempString = "Summary for Dates Between : ";
			maxRecord=0;
			tempArray.clear();
			while(rs.next())
			{
				tempArray.add(rs.getString(1));
				maxRecord++;
			}

			end = maxRecord -  daySummary;
			start = end - daySummary;
		tempString = tempString + (String)tempArray.get(start) + " - " + (String)tempArray.get(end-1);

out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForPrev.value='"+tempString+"'</script>");
}
catch(Exception ee)
{
  //out.println("Exception from Chart Recording Intermediate from Summary JSP :"+ee.toString());//COMMON-ICN-0181
  ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs != null) rs.close();
	if(pstmt !=null)pstmt.close();
	if(con != null)ConnectionManager.returnConnection(con);
}

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
