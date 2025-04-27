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

public final class __camainhomepagetree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainHomePageTree.jsp", 1709115553027L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<STYLE>\n.gridData1\n{\n\tbackground-color: #FFFFFF;\n\theight:18px;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;//Changed from 10px to 8pt for IN044106\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tvertical-align:middle;\n\tborder-bottom:0px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:none;//IN044106\n\tborder-color:#EEEEEE;\n//\tpadding-left:10px; //Commented for IN044106\n\t//padding-right:10px; //Commented for IN044106\n}\n.gridDataBlue1\n{\n\theight:18px;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #0000FF;\n\tfont-weight:normal;\n\ttext-align:left;\n\tvertical-align:middle;\n\tborder-bottom:0px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\t\n\tbackground-color: #FFFFFF;\t\n\tborder-style:none;\n\tborder-color:#EEEEEE;\n}\n</STYLE>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/CASummaryMenu.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t\t\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<title>Summary Preview</title>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n<TABLE width=\'100%\' border=\"0\" align=\'center\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<!--<tr><td align=\"left\" class=\'gridData1\'nowrap> IN037982\t-->\n\t\t\t\t\t\t\t\t<tr><td align=\"left\" class=\'gridData1\' title=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' nowrap>\n\t\t\t\t\t\t\t\t<!--<b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b> //IN035914-->\n\t\t\t\t\t\t\t\t<!--<b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b>-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<!--//IN035914,IN038450-->\n\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<!--<tr><td align=\"left\" class=\'gridData1\'nowrapnowrap>\tIN037982-->\n\t\t\t\t\t\t\t<tr><td align=\"left\" class=\'gridData1\' title=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' nowrap >\t\n\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="//IN035914-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<!--//IN035914-->\n\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--<tr><td align=\"left\" class=\'gridData1\' nowrap> IN037982-->\n\t\t\t\t\t\t\t<!-- <tr><td align=\"left\" class=\'gridData1\'   title=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' nowrap>IN066237-->\n\t\t\t\t\t\t\t<tr><td align=\"left\" class=\'gridData1\' id=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'  title=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' nowrap><!--IN066237-->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="(0)\t\n\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t<!--<tr><td class=\"gridData1\" nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="(";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")</td> </tr> IN037982-->\n\t\t\t\t\t\t\t\t\t<tr><td class=\"gridData1\" title=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =")</td> </tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--<tr><td class=\"gridData1\" nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<a href=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  onclick=\"loadTitleName(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')  \"target=\"workAreaFrame\" >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")</a></td> </tr> IN035914 -->\n\t\t\t\t\t\t\t   <!--   <tr><td class=\"gridData1\" nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<a  href=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\" title=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' target=\"workAreaFrame\" >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")</a></td> </tr>-- IN035914 -->\n\t\t\t\t\t\t\t\t<tr><td class=\"gridData1\" id=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =")</a>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCA/images/bellIcon.png\' alt=\'Patients Waiting for Virtual Consultation\'/>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t</td> </tr><!-- IN066237 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\n</TABLE>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
Date       	Edit History   Name       Description
-------------------------------------------------------------------------------------------------------------------------------------
?           100            ?          created
27/11/2012	IN035914	   Nijitha	  CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
									  more appealing. Keeping the display of information more clear and visible.
20/08/2013	IN041295 	   Nijitha	  TTM-SCF-0002: Personalize Home Page? the screen display null
03/04/2015	IN054674 	   Nijitha	  AAKH-CRF-0063.1 : New menu option in CA->Desktop->Summary & Navigation
08/05/2018	IN066237	   Prakash C 	 MMS-DM-CRF-0123
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String SummaryPreviewPage=request.getParameter("SummaryPreviewPage") == null ? "" : request.getParameter("SummaryPreviewPage");			
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(SummaryPreviewPage.equals("SummaryPreviewPage")){			
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		Connection con = null;
		String desktopID = request.getParameter("desktopID") == null ? "" : request.getParameter("desktopID");	
		
		String facility_id=(String) session.getValue("facility_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		//---IN054674/Start----
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		//---IN054674/End------
		String User_id	=	(String)session.getValue("login_user");		
		String responsibility_id		= (String)session.getValue("responsibility_id");
		ArrayList arrList = new ArrayList();
		PreparedStatement pstmtComp = null,pstmtcnt=null,c4cStmt=null;
		ResultSet rsComp = null,rscount=null,rsC4c=null;		
		String summaryHdr="";		
		String summarySubHrd="";	
		String prevsummaryHdr="";
		String summary_comp_id="";
		String prefixspace="";
		String sourceSQL="";
		String tempStr1 = "";				
		String tempStr = "";		
		String totCount="0";
		String desktopFunctionID="";		
//		String strLink = "";
		String summarySubHrdbg ="";//IN035914
				
	try
	{
		con = ConnectionManager.getConnection(request);
		boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
		//pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,           c.summary_comp_desc summary_comp_desc,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY c.summary_comp_desc,           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");	
		//pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,    c.summary_comp_desc_user summary_comp_desc, NVL(C.SUMMARY_COMP_DESC_LEGEND,c.summary_comp_desc_user) summary_comp_desc_bg,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY c.summary_comp_desc_user,NVL(C.SUMMARY_COMP_DESC_LEGEND,c.summary_comp_desc_user),           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");//IN035914
		pstmtComp = con.prepareStatement("SELECT     MIN (LEVEL) level1,           LPAD ('&nbsp;', (MIN (LEVEL) - 1) * 12, '&nbsp;') prefixspace,    nvl(c.summary_comp_desc_user, c.summary_comp_desc) summary_comp_desc, NVL(C.SUMMARY_COMP_DESC_LEGEND,nvl(c.summary_comp_desc_user,c.summary_comp_desc)) summary_comp_desc_bg,           a.summary_comp_id || summary_comp_occ_num summary_comp_id,              a.hdr_summary_comp_id           || hdr_summary_comp_occ_num hdr_summary_comp_id,           ds.source_sql, c.executable_name, order_seq      FROM sm_desktop_sum_dtl a, sm_desktop_sum_comp c, sm_data_source ds     WHERE a.desktop_summary_id = ?      AND c.summary_comp_id(+) = a.summary_comp_id        AND ds.source_id(+) = c.summary_data_source_id  GROUP BY nvl(c.summary_comp_desc_user,c.summary_comp_desc), NVL(C.SUMMARY_COMP_DESC_LEGEND,nvl(c.summary_comp_desc_user,c.summary_comp_desc)),           a.summary_comp_id || summary_comp_occ_num,           a.hdr_summary_comp_id || hdr_summary_comp_occ_num,           ds.source_sql,           c.executable_name,           order_seq START WITH hdr_summary_comp_id = ? AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR a.summary_comp_id = a.hdr_summary_comp_id       AND a.summary_comp_occ_num = a.hdr_summary_comp_occ_num  ORDER BY order_seq ");//IN035914//IN041295 
				
				pstmtComp.setString(1,desktopID);
				pstmtComp.setString(2,desktopID);
				rsComp = pstmtComp.executeQuery();

				
				while(rsComp.next()){	
						totCount = "0";
						arrList.clear();
						summary_comp_id=rsComp.getString("summary_comp_id");
						if (prevsummaryHdr.equals(summary_comp_id))
							{
								continue;
							}
							else
							{
								prevsummaryHdr=summary_comp_id;
				
							}
						summaryHdr=rsComp.getString("LEVEL1");
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");	
						summarySubHrdbg=rsComp.getString("summary_comp_desc_bg");//IN035914
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						
						prefixspace=rsComp.getString("prefixspace")==null?"":rsComp.getString("prefixspace");	
						desktopFunctionID=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");						
						if (!sourceSQL.equals(""))
						{							
							tempStr = sourceSQL;
							for (int i=0;i<tempStr.length()-1 ;i++ )
							{
								if (tempStr.indexOf("&&") > 0)
								{
									tempStr1 = tempStr.substring(tempStr.indexOf("&&"),tempStr.indexOf("##")+2);				
									sourceSQL  = sourceSQL.replace(tempStr1,"?");
									arrList.add( tempStr1.substring(tempStr1.indexOf("&&")+2,tempStr1.indexOf("##")));										
								}
									
								if (tempStr.indexOf("##") > 0)
								{									
									tempStr = tempStr.substring(tempStr.indexOf("##")+2);									
								}									
							}	
							
							pstmtcnt = con.prepareStatement(sourceSQL);							
							for (int j = 0 ;j<arrList.size() ;j++ )
							{
								
								if (((String)arrList.get(j)).equals("LOGGED_IN_FACILITY"))
								{									
									pstmtcnt.setString(j+1,facility_id);	
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_PRACT"))
								{									
									pstmtcnt.setString(j+1,Clin_id);
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_RESP"))
								{									
									pstmtcnt.setString(j+1,responsibility_id);
								}else if (((String)arrList.get(j)).equals("LOGGED_IN_USERID"))
								{									
									pstmtcnt.setString(j+1,User_id);
								}
								//---IN054674/Start----
								else if (((String)arrList.get(j)).equals("LANGUAGE_ID"))
								{
									pstmtcnt.setString(j+1,locale);
								}
								//---IN054674/End------	
							}
							
							rscount = pstmtcnt.executeQuery();
							if (rscount.next())
							{
								totCount = rscount.getString(1);

								
								if (totCount==null)  totCount="0";
							}
							else 
								totCount="0";
								if(rscount != null)
									rscount.close();
								if(pstmtcnt != null)
									pstmtcnt.close();							
						}	
						if(summaryHdr.equals("1") && sourceSQL.equals(""))
						{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block15Bytes, _wl_block15);
	
						}
						else if (sourceSQL.equals(""))
						{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
						else if (totCount.equals("0"))
						{
						
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summary_comp_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
						else
						{
							if(SummaryPreviewPage.equals("SummaryPreviewPage")){
									totCount="0";
									
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(prefixspace));
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
						
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(desktopFunctionID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(desktopFunctionID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(summary_comp_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(prefixspace));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(desktopFunctionID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(summarySubHrd));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(summarySubHrdbg));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block39Bytes, _wl_block39);

								if(isVirtualConsSDGSpec && "Outpatients".equals(summarySubHrd)){
									int c4cRecCount=0;
									c4cStmt = con.prepareStatement("SELECT Count(*) TOTALRECOD FROM pr_encounter p WHERE p.facility_id =? AND p.attend_practitioner_id = ? AND ( (    'Y' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param) AND 'N' = blcommonproc.unbld_outst_amt_exists_yn (p.facility_id,p.patient_id,DECODE (p.patient_class,'OP', 'O','EM', 'E','IP', 'I','DC', 'D'),NULL,NULL,p.encounter_id,NULL) ) OR ('N' = (SELECT ca_rest_unbilled_patient FROM ca_cons_param)) )  AND p.visit_status IN ('01', '02', '03', '04', '05', '06') AND p.visit_adm_date_time BETWEEN TRUNC (SYSDATE) AND TRUNC (SYSDATE) + 1 AND p.patient_class = 'OP' AND OP_PATIENT_C4C_STATUS_DISPLAY(p.facility_id,p.patient_id,p.encounter_id,p.patient_class)='Y'");
									c4cStmt.setString(1,facility_id);
									c4cStmt.setString(2,Clin_id);
									rsC4c = c4cStmt.executeQuery();
									if (rsC4c.next())
									{
										c4cRecCount=rsC4c.getInt("TOTALRECOD");
									}	
									if(c4cRecCount>0){
								
            _bw.write(_wl_block40Bytes, _wl_block40);

									}
								}
								
            _bw.write(_wl_block41Bytes, _wl_block41);

							
								

							}
						
						
						}
            _bw.write(_wl_block42Bytes, _wl_block42);
				}									
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
		
	}
	finally
	{
		try
		{
			if(rsComp!= null) rsComp.close();
			if(pstmtComp!=null) pstmtComp.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
		//	out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
			
		}
	}
	
            _bw.write(_wl_block43Bytes, _wl_block43);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
