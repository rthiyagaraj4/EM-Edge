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
import com.ehis.util.*;

public final class __chartsummarypersthemetransaction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryPersThemeTransaction.jsp", 1709115186325L ,"10.3.6.0","Asia/Calcutta")) return true;
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
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?       created
12/02/2013		CHL_CRF		Nijitha		CHL_CRF - File Added and Changes as part of Default and Personlised themes to be applied for All widgets								 
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String modifiedById= "";
String modifiedAtWorkstation="";
String client_ip_address= "";
HttpSession sess = request.getSession(false);
java.util.Properties p = (java.util.Properties) sess.getValue( "jdbc" ) ;
modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;  
client_ip_address = p.getProperty("client_ip_address");         
modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;        

String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
String contentID = request.getParameter("contentID");
if(contentID == null || contentID.equals("") || "undefined".equals(contentID)) contentID = "";
String summaryId = request.getParameter("summaryId");
if(summaryId == null || summaryId.equals("")) summaryId = "";
String patientClass = request.getParameter("patientClass");
if(patientClass == null || patientClass.equals("") || "undefined".equals(patientClass)) patientClass = "";
String speciality = request.getParameter("speciality");
if(speciality == null || speciality.equals("") || "undefined".equals(speciality)) speciality = "";
String practitioner = request.getParameter("practitioner");
if(practitioner == null || practitioner.equals("") || "undefined".equals(practitioner)) practitioner = "";
String persStyleSheet = request.getParameter("personalizeTheme");
if(persStyleSheet == null || persStyleSheet.equals("") ) persStyleSheet = "";
String applyToAllWidget = request.getParameter("applyToAllWidget");
if(applyToAllWidget == null || applyToAllWidget.equals("") ) applyToAllWidget = "";
String recordInserted = "";
String requestFor = request.getParameter("requestFor");
String count="";
int totalWidget = 0;
HashMap hashMap=null;
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs = null;
String style_sheet_id="";
String style_sheet_name="";
String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc,CSCN.CONTENT_ID  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
StringBuilder styleSheetIDQry = new StringBuilder();
styleSheetIDQry.append("select style_sheet_id from CA_WIDGET_STYLE_SHEET where style_sheet =?");
String styleSheetQuery = "SELECT STYLE_SHEET FROM CA_WIDGET_STYLE_SHEET WHERE CONTENT_ID=? AND STYLE_SHEET_ID=? ";

            _bw.write(_wl_block2Bytes, _wl_block2);
try

{
			con =ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(styleSheetIDQry.toString());
			pstmt.setString(1,persStyleSheet);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				style_sheet_id =rs.getString("style_sheet_id");
			}
			
			if(!"Y".equals(applyToAllWidget))
			{
				if(session.getAttribute("allStyles")!=null)
				{
					hashMap = (HashMap)session.getAttribute("allStyles");
					hashMap.put("PREFERRED_STYLE_WIDGET"+contentID, persStyleSheet);
					session.setAttribute("allStyles", hashMap);
					
				}
				else
				{
					hashMap = new HashMap();
					hashMap.put("PREFERRED_STYLE_WIDGET"+contentID, persStyleSheet);
					session.setAttribute("allStyles", hashMap);
					
				}
			}
			else
			{
				ArrayList positionsList = new ArrayList();
				pstmt = con.prepareStatement(strSql);
				pstmt.setString(1,summaryId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{	
					positionsList.add(rs.getString("CONTENT_ID")); //CONTENT_ID		
				}
					
					for (int i = 0; i < positionsList.size(); i++) 
					{
						pstmt = con.prepareStatement(styleSheetQuery);
						pstmt.setString(1,(String)positionsList.get(i));
						pstmt.setString(2,style_sheet_id);
						rs = pstmt.executeQuery();
						while(rs.next())
						{	
							style_sheet_name =	rs.getString("STYLE_SHEET");		
						}
						if(session.getAttribute("allStyles")!=null)
						{
							hashMap = (HashMap)session.getAttribute("allStyles");
							hashMap.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i), style_sheet_name);
							session.setAttribute("allStyles", hashMap);
							
						}
						else
						{
							hashMap = new HashMap();
							hashMap.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i), style_sheet_name);
							session.setAttribute("allStyles", hashMap);
							
						}
						
					}
			}
		
		pstmt.close();
		rs.close();
	
	}
	catch(Exception e)
	{
	//	out.println("Exception in ChartSummaryPersThemeTransaction.jsp: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	} 

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
