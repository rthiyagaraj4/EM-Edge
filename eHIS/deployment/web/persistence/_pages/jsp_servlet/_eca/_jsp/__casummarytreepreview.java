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

public final class __casummarytreepreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CASummaryTreePreview.jsp", 1736157587729L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>Summary Preview</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/CASummaryMenu.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t\n\t<script>\n\tvar obj;\n\tobj = new dTree(\'obj\');\n\tobj.add(\'Summary\',\'-1\',\'<font size=1 style=font-weight:bold style=color:#000000>Summary</font>\');\n\tobj.config.useStatusText=true;\t\n\t</script>\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n<TABLE width=\'100%\' border=\"0\" align=\'center\'>\n<TR>\n\t<TD align=\'right\' width=\'90%\'><img src=\'../../eCommon/images/close-all.gif\' onclick=\"changeTree(this)\" id=\'toggleTreeCollapse\' style=\'display\' alt = \'Collapse All\'></img>&nbsp;<img src=\'../../eCommon/images/expand-all.gif\' onclick=\"changeTree(this)\" id=\'toggleTreeExpand\' style=\'display\' alt = \'Expand All\'></img></TD>\n\t<TD align=\'right\' width=\'10%\'><img src=\'../../eCA/images/MI_CloseT1.gif\' onclick=\"window.close();\" width=\"24\" height=\"20\" style=\'display\' alt = \'Close\'></img></TD>\n\t\n</TR>\n</TABLE>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t<script>\t\t\n\tdocument.write(obj);\n\tobj.openAll();\t\n\t</script>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/*		Properties p	= (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");*/
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;		
		
//		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String)											session.getValue("practitioner_type");
	//	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" :											(String)request.getParameter("practitioner_id");
		String desktop_summary_id=(String)request.getParameter("desktop_summary_id") == null ? "" :											(String)request.getParameter("desktop_summary_id");
		String facility_id=(String) session.getValue("facility_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		String User_id	=	(String)session.getValue("login_user");		
		String responsibility_id		= (String)session.getValue("responsibility_id");
		ArrayList arrList = new ArrayList();
		PreparedStatement pstmtComp = null,pstmtcnt=null;
		ResultSet rsComp = null,rscount=null;	
	
		String summaryHdr="";		
		String summarySubHrd="";	
		String prevsummaryHdr="";
		String sourceSQL="";
		String tempStr1 = "";				
		String tempStr = "";		
		//String totCount="0";
		String executable_name="";
//		StringBuffer sql=null,sql1=null;	
	//	String target="";
		
	try
	{
		con=ConnectionManager.getConnection(request);
				//pstmtComp = con.prepareStatement("SELECT C.SUMMARY_COMP_DESC,									A.SUMMARY_COMP_ID,H.SUMMARY_COMP_DESC HEAD_ID, A.HDR_SUMMARY_COMP_ID,DS.SOURCE_SQL,C.EXECUTABLE_NAME FROM  SM_DESKTOP_SUM_DTL A, SM_DESKTOP_SUM_COMP C, SM_DESKTOP_SUM_COMP H,SM_DATA_SOURCE DS WHERE a.DESKTOP_SUMMARY_ID='"+desktop_summary_id+"' and C.SUMMARY_COMP_ID=A.SUMMARY_COMP_ID   AND H.SUMMARY_COMP_ID=A.HDR_SUMMARY_COMP_ID   AND DS.SOURCE_ID(+)=C.SUMMARY_DATA_SOURCE_ID ORDER BY HEAD_ID");//common-icn-0180
				pstmtComp = con.prepareStatement("SELECT C.SUMMARY_COMP_DESC,									A.SUMMARY_COMP_ID,H.SUMMARY_COMP_DESC HEAD_ID, A.HDR_SUMMARY_COMP_ID,DS.SOURCE_SQL,C.EXECUTABLE_NAME FROM  SM_DESKTOP_SUM_DTL A, SM_DESKTOP_SUM_COMP C, SM_DESKTOP_SUM_COMP H,SM_DATA_SOURCE DS WHERE a.DESKTOP_SUMMARY_ID=? and C.SUMMARY_COMP_ID=A.SUMMARY_COMP_ID   AND H.SUMMARY_COMP_ID=A.HDR_SUMMARY_COMP_ID   AND DS.SOURCE_ID(+)=C.SUMMARY_DATA_SOURCE_ID ORDER BY HEAD_ID");//common-icn-0180
				
				pstmtComp.setString(1, desktop_summary_id);//common-icn-0180
				rsComp = pstmtComp.executeQuery();					
				while(rsComp.next()){	
						//totCount = "0";
						arrList.clear();
						summarySubHrd=rsComp.getString("SUMMARY_COMP_DESC");	
						summaryHdr=rsComp.getString("HEAD_ID");	
						sourceSQL=rsComp.getString("SOURCE_SQL")==null?"":rsComp.getString("SOURCE_SQL");	
						executable_name=rsComp.getString("EXECUTABLE_NAME")==null?"":rsComp.getString("EXECUTABLE_NAME");						
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
														
							}	
							rscount = pstmtcnt.executeQuery();
							if (rscount.next())
							{
								//totCount = rscount.getString(1);
							}

								if(rscount != null)
									rscount.close();
								if(pstmtcnt != null)
									pstmtcnt.close();							
						}						
						out.println("<script>");	
						if(!prevsummaryHdr.equals(summaryHdr)) 
						{
							out.println("obj.add('"+summaryHdr+"','Summary','<font size=1 style=font-weight:bold style=color:#000000>"+summaryHdr+"</font>');");							
							prevsummaryHdr = summaryHdr;
						}					
							out.println("obj.add('"+summarySubHrd+"','"+summaryHdr+"','"+summarySubHrd+" ')");				
						out.println("</script>");	
							
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
			//out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
              e.printStackTrace();//COMMON-ICN-0181
		}
	}
	
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
