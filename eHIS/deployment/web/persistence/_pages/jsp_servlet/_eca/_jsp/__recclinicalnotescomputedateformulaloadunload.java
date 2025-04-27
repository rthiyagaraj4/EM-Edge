package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.Hashtable;

public final class __recclinicalnotescomputedateformulaloadunload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesComputeDateFormulaLoadUnload.jsp", 1709115226351L ,"10.3.6.0","Asia/Calcutta")) return true;
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
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
11/04/2017  IN061905       	DineshT     25/4/2016		Ramesh G   		The Scoring functionality In Notes should work in the 																			similar manner as in Charts i.e on selection of 																				individual variable, the score gets automatically 																				calculated.
15/04/2017	IN063963		DineshT		25/4/2016		Ramesh G 		ML-MMOH-CRF-0557_UT2
08/05/2017	IN063962		Dinesh T									ML-MMOH-CRF-0557_UT1
--------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;

try
{
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString(request) ;

	hash = (Hashtable)hash.get("SEARCH") ;
	String locale = (String) p.getProperty("LOCALE");
	String firstComponent = (String)hash.get("firstComponent");
	String secondComponent = (String)hash.get("secondComponent");
	String formulaResultUnit = (String)hash.get("formulaResultUnit");
	String formula_result_type = (String)hash.get("formula_result_type");
	String formula_operator = (String)hash.get("formula_operator");
	String l_sys_date_time_in_en_yn = (String)hash.get("sysDateTimeInEnYN");//IN063962
	
	StringBuilder qry = new StringBuilder();
	String formulaResult = "";
	String temp_secondComponent ="";
	
	con = ConnectionManager.getConnection(request);

	if(!"".equals(firstComponent) && !"".equals(secondComponent))
	{
		if("N".equals(formula_result_type))
		{
			if("Years".equals(formulaResultUnit))
				qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))/12) FROM DUAL");
			else if ("Months".equals(formulaResultUnit))
				qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))) FROM DUAL");
			else if("Weeks".equals(formulaResultUnit))
				qry.append("SELECT  trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))/7) FROM DUAL");
			else if("Days".equals(formulaResultUnit))
				qry.append("SELECT trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI')) FROM DUAL");
			else if("Hours".equals(formulaResultUnit))
				qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*24) FROM DUAL");
			else if("Minutes".equals(formulaResultUnit))
				qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*1440) FROM DUAL");

			//temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");	
			String dateTime[] = secondComponent.split(" ");//IN063962
			if(dateTime.length==1){
				temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
			}else{
				temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMYHM", locale, "en");
			}

			stmt = con.prepareStatement(qry.toString());
			stmt.setString(1, firstComponent);
			stmt.setString(2, temp_secondComponent);
			rs = stmt.executeQuery();
			
			if(rs.next())
				formulaResult = rs.getString(1)==null?"": rs.getString(1);

			if(rs!=null) 
				rs.close();

			if(stmt!=null) 
				stmt.close();
		}
		else if("D".equals(formula_result_type))
		{
			String dateTime[] = firstComponent.split(" ");//IN063962

			if("Minutes".equals(formulaResultUnit) || "Hours".equals(formulaResultUnit) || "Days".equals(formulaResultUnit) || "Weeks".equals(formulaResultUnit))
			{
				qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");

				if("MINUS".equals(formula_operator))
					qry.append("-");
				else
					qry.append("+");

				qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY HH24:MI') from dual");
			}
			else
			{
				qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");

				if("MINUS".equals(formula_operator))
					qry.append("-");
				else
					qry.append("+");
				qry.append("? *(decode(?,'Years',12,1)) ),'DD/MM/YYYY HH24:MI') FROM DUAL");
			}

			stmt = con.prepareStatement(qry.toString());
			stmt.setString(1, firstComponent);
			stmt.setString(2, secondComponent);
			stmt.setString(3, formulaResultUnit);				
			rs = stmt.executeQuery();
			
			if(rs.next())
				formulaResult = rs.getString(1);

			if(rs!=null) 
				rs.close();

			if(stmt!=null) 
				stmt.close();
			
			//IN063962, starts
			/*int index = formulaResult.lastIndexOf("00:00");
			if(index != -1)
			{
				StringBuffer temp = new StringBuffer(formulaResult);
				formulaResult = temp.substring(0, 10);
			}*/
			if(dateTime.length == 1)
			{
				formulaResult = formulaResult.substring(0, 10);

				if("Y".equals(l_sys_date_time_in_en_yn))
					formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMY", "en",locale);
			}
			else
			{
				if("Y".equals(l_sys_date_time_in_en_yn))
					formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMYHM", "en",locale);
			}
			//IN063962, ends
		}

		//formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMY", "en",locale);
		out.println(formulaResult);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(rs!=null)
		rs.close();

	if(stmt!=null)
		stmt.close();

	if(con!=null)
		ConnectionManager.returnConnection(con,request);
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
