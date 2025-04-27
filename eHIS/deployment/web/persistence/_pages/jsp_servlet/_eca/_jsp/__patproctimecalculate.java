package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __patproctimecalculate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProcTimeCalculate.jsp", 1709116021763L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
?			100				?           ?			?				created
30/07/2015	IN037505		Karthi L	?			?				[SRR20056-SCF-9373 ] - IN037471	After select Start Date/time and Duration, System doesn?t calculate and 																					display Ending date/time.							
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	
	Connection con =null;
	ResultSet rs=null;
	PreparedStatement  stmt=null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String startdate = request.getParameter("startdate")==null?"":request.getParameter("startdate");
		String enddate	 = request.getParameter("enddate")==null?"":request.getParameter("enddate");
		String hours	 = request.getParameter("hours")==null?"00":request.getParameter("hours");
		String minutes	 = request.getParameter("minutes")==null?"00":request.getParameter("minutes");
		String flag		 = request.getParameter("flag")==null?"":request.getParameter("flag");
		String modal_yn	 = request.getParameter("modal")==null?"N":request.getParameter("modal");
		String p_called_from_widget	 = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF  [IN035950]
		String l_locale	 = request.getParameter("p_locale")==null?"":request.getParameter("p_locale"); //added p_locale for SRR20056-SCF-9395 [IN037505]
		String newDate = "";
		String sql = "";
		String hrs = "";
		String min = "";
		String a1con = "";
		float minu = 0;
		int finalMinutes = 0;
		String finalMinStr = "";
		//added p_locale for SRR20056-SCF-9395 [IN037505] - Start
		if(!"en".equals(l_locale))
		{
			startdate = com.ehis.util.DateUtils.convertDate(startdate,"DMYHM",l_locale,"en");
			enddate = com.ehis.util.DateUtils.convertDate(enddate,"DMYHM",l_locale,"en");
		}
		//added p_locale for SRR20056-SCF-9395 [IN037505] - End
		if (flag.equals("Hrs") || flag.equals("Min"))
		{
			sql = "select to_char(to_date(?,'dd/mm/yyyy hh24:mi')+(0"+hours+"/24)+(0"+minutes+"/1440),'dd/mm/yyyy hh24:mi') from dual";

			stmt = con.prepareStatement(sql);
			stmt.setString(1,startdate);
			
			rs = stmt.executeQuery();
			while(rs.next())
			{
				newDate = rs.getString(1) == null ? "" : rs.getString(1);
			}
			//added p_locale for SRR20056-SCF-9395 [IN037505] - Start
			if(!"en".equals(l_locale))
			{
				newDate = com.ehis.util.DateUtils.convertDate(newDate,"DMYHM","en",l_locale);
			}
			//added p_locale for SRR20056-SCF-9395 [IN037505] - End
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
			if(modal_yn.equals("Y"))
			{
				a1con = "parent.frame2.document.forms[0].enddate.value=''; parent.frame2.document.forms[0].enddate.value='"+newDate+"';parent.frame2.document.forms[0].enddate.focus();";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(!"".equals(p_called_from_widget)){
					a1con = "parent.frame2.document.forms[0].enddate.value=''; parent.frame2.document.forms[0].enddate.value='"+newDate+"';parent.frame2.document.forms[0].enddate.focus();";
				}else{
				//CHL-CRF End. [IN035950]
					a1con = "top.content.workAreaFrame.frame2.document.forms[0].enddate.value=''; top.content.workAreaFrame.frame2.document.forms[0].enddate.value='"+newDate+"';top.content.workAreaFrame.frame2.document.forms[0].enddate.focus();";
				}//CHL-CRF  [IN035950]
			}
			out.println(a1con);
	    }
		else if (flag.equals("enddate") || flag.equals("date"))
		{
			sql="select round((to_date(?,'dd/mm/yyyy hh24:mi')-to_date(?,'dd/mm/yyyy hh24:mi'))*24,2) datemin from dual";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,enddate);
			stmt.setString(2,startdate);

			rs = stmt.executeQuery();
			while(rs.next())
			{
				newDate = rs.getString(1) == null ? "" : rs.getString(1);
			}

			StringTokenizer str = new StringTokenizer(newDate,".");
			int i = newDate.indexOf(".");
			if (i != -1)
			{
				 if(i != 0)
				 {
					 hrs = str.nextToken();
					 min = str.nextToken();
				 }
				 else
				 {
					min = str.nextToken();
				 }
				 min = "."+min;
				 minu = Float.parseFloat(min);

				 minu = (minu*60);
				 finalMinutes = Math.round(minu);
				 if (finalMinutes < 10)
					finalMinStr = "0" + finalMinutes;
				 else
					finalMinStr = "" + finalMinutes;
			}
			else
			{
				hrs = newDate;
				finalMinStr = "0";
			}

			if(hrs.equals("")) hrs = "0";

			int hrsindex = hrs.indexOf("-");
			if(hrsindex != -1)
			{
				hrs = "";
				finalMinStr = "";
			}
			if(modal_yn.equals("Y"))
			{
				a1con = "parent.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	parent.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(!"".equals(p_called_from_widget)){
					a1con = "parent.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	parent.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
				}else{
				//CHL-CRF End. [IN035950]				
					a1con = "top.content.workAreaFrame.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	top.content.workAreaFrame.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
				}//CHL-CRF  [IN035950]
			}
			out.println(a1con);
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

	}
	catch(Exception e)
	{
		//out.println("Exception in patproctime : "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
