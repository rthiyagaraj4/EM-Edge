package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignchartsummpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignChartSummPreview.jsp", 1729687209263L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<style>\nTD.COLUMNHEADERCENTERNEW {\n\tbackground-color: #83AAB4;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: white;\n\tfont-weight:bold;\n\ttext-align:left;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:solid;\n\tborder-color:#EEEEEE;\t\n}\n</style>\n<!-- <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />-->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<TITLE>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- IN035950 Start-->\n<SCRIPT>\nasync function showThemes(contentID,summaryId,patientClass,practitioner,speciality,titleContent,styleSheetName)\n{\n\t\n\tvar dialogHeight\t= \"500px\" ;\n\tvar dialogWidth\t\t= \"900px\" ;\n\tvar status\t\t\t= \"no\";\n\tvar scroll\t\t\t= \"YES\";\n\tvar dialogTop\t\t= \"100\";\n\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\tvar queryString = \"contentID=\"+contentID+\"&summaryId=\"+summaryId+\"&patClass=\"+patientClass+\"&speciality=\"+speciality+\"&practitioner=\"+practitioner+\"&titleContent=\"+titleContent+\"&styleSheetName=\"+styleSheetName;\n\tvar retVal =await window.showModalDialog(\'ChartSummaryPersonalisedThemes.jsp?\'+queryString,arguments,features);\n\tdocument.location.reload();\n}\n</SCRIPT>\n\n<!-- IN035950 Ends-->\n</HEAD>\n<body onKeyDown=\"lockKey()\">\n<form name=\'assignChartSummaryPreview\' id=\'assignChartSummaryPreview\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table width=\'100%\' border=0 cellpadding =\'3\' align = \"center\" >\n<tr>\n<td height=\"10%\"  class=\'label\' colspan=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n</tr>\n</table>\n\n<table width=\'100%\' border=0 height=\'100%\' cellpadding =\'3\' align = \"center\" >\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</tr>\n</table>\n</form><!--Niji-->\n</BODY>\n</HTML>\n\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be 												changed and more appealing. Keeping the display of information more clear 												 and visible.   								 
15/04/2020		IN072852 		Durga Natarajan	For Theme change 
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
            _bw.write(_wl_block5Bytes, _wl_block5);
 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block1Bytes, _wl_block1);

//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null && !((String) session.getAttribute("PREFERRED_STYLE")).isEmpty()) 
                 ? (String) session.getAttribute("PREFERRED_STYLE") 
                 : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList positionsList = new ArrayList();
	int temp =0,tempRowId=0,totalRows = 0, tempExists = 0,totalCols=0;
	float widthPerCell=0,heightPerCell=0;
	String summaryId = request.getParameter("summaryId");
	String summaryDesc = request.getParameter("summaryDesc");
	if(summaryId == null || summaryId.equals("")) summaryId = "";
	if(summaryDesc == null || summaryDesc.equals("")) summaryDesc = "";
	//IN035950	Starts
	String patientClass = request.getParameter("patClass");
	String practitioner = request.getParameter("practitioner");
	String speciality =request.getParameter("speciality");
	String styleSheetName="";
	String content_id="";
	String called_from =request.getParameter("called_from");
//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT, SUMMARY_DESC summaryDesc,CSCN.CONTENT_ID  FROM CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_DETAIL CSD,CA_CHART_SUMM_CONTENT CSCN WHERE CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID AND CSH.SUMMARY_ID=? ORDER BY CSD.ROW_POS,CSD.COL_POS";
String stlyeSheetQry = "SELECT STYLE_SHEET,CONTENT_ID FROM CA_CHART_SUMM_STYLE_SHEET WHERE SUMMARY_ID=? AND PATIENT_CLASS=? AND SPECILITY_ID=? AND PRACTITIONER_ID=?";
int totalWidgets = 0;
String tempQuery = "INSERT INTO CA_WIDGET_STYLE1(CONTENT_ID, STYLE_SHEET) VALUES(?,?)";
String deleteQry = "DELETE FROM CA_WIDGET_STYLE1";
StringBuilder sblQry = new StringBuilder();
	sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM where MODULE_ID=? ");
//IN035950	Ends

            _bw.write(_wl_block9Bytes, _wl_block9);

	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strSql);
		pstmt.setString(1,summaryId);
		rs = pstmt.executeQuery();
		while(rs.next()){
			summaryDesc= rs.getString("summaryDesc");
			totalRows = rs.getInt(1); //NO_OF_ROWS
			totalCols = rs.getInt(2);//NO_OF_COLS
			positionsList.add(rs.getString(3)); //ROW_POS
			positionsList.add(rs.getString(4)); //COL_POS
			positionsList.add(rs.getString(5)); //ROW_SPAN
			positionsList.add(rs.getString(6)); //COL_SPAN
			positionsList.add(rs.getString(7)); //TITLE_CONTENT
			positionsList.add("../../eCommon/html/blank.html"); //CONTENT_EXEC_NAME 	
			positionsList.add(rs.getString("CONTENT_ID")); //CONTENT_ID		
			totalWidgets++;//IN035950
		}
		if(totalRows ==0){
			out.flush();
			return;
		}
		widthPerCell = 100/totalCols;
		heightPerCell = 100/totalRows;
		tempExists = 0;

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(totalCols));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(summaryDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

		//IN035950 Starts
		HashMap styleMapDB=new HashMap();
		String styleSheetDB ="";
		HashMap sessionStyleMap = new HashMap();
		String styleSheetSession = "";
		String themeIcon="";
		String widgetThemeIconIndicator="";
		String widgetThemeIndicator="";
		String widgetIconIndicator="";
			
				try
				{
				pstmt = con.prepareStatement(sblQry.toString());
				pstmt.setString(1,"CA");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					widgetThemeIconIndicator = rs.getString("WIDGET_THEME_ICON_YN");
					widgetThemeIndicator = rs.getString("WIDGET_THEME_YN");
					widgetIconIndicator = rs.getString("WIDGET_ICON_YN");
				}
				
				pstmt = con.prepareStatement(stlyeSheetQry);
				pstmt.setString(1,summaryId);
				pstmt.setString(2,patientClass);
				pstmt.setString(3,speciality);
				pstmt.setString(4,practitioner);
				rs = pstmt.executeQuery();
				
				sessionStyleMap =	(HashMap) session.getAttribute("allStyles");
				while(rs.next())
				{
					styleMapDB.put("PREFERRED_STYLE_WIDGET"+rs.getString("CONTENT_ID"),rs.getString("STYLE_SHEET"));
				}	
					if(null!= sessionStyleMap && !sessionStyleMap.isEmpty())
					{
						for(int i=0;i<positionsList.size();i+=7)//IN035950 Starts
						{
							
							if(!styleMapDB.containsKey("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6)))
							{
								styleSheetSession=	(String)sessionStyleMap.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));
								
								if(null!=styleSheetSession && !"".equals(styleSheetSession))
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);
								}
								/*else
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i),sStyle);
								}*/
							}
							else
							{
								//styleSheetDB = (String)styleMapDB.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));//commented for IN072852 
								styleSheetSession=	(String)sessionStyleMap.get("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6));
								/*if(null!=styleSheetDB && styleSheetDB.equals(styleSheetSession))
								{
								System.out.println("AssignChartSummPreview.jsp:Line153:styleSheetSession"+styleSheetSession);
								styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetDB);
								}
								else if(null!=styleSheetDB && null!=styleSheetSession && !styleSheetDB.equals(styleSheetSession))
								{
									styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);
								}*///commented for IN072852 
								styleMapDB.put("PREFERRED_STYLE_WIDGET"+(String)positionsList.get(i+6),styleSheetSession);//IN072852 
							}
						}
						
					}
					
					/*if(null!=styleSheetDB && !"".equals(styleSheetDB) && null!=styleSheetSession && !"".equals(styleSheetSession) && !styleSheetDB.equals(styleSheetSession))
					{
						styleMapDB.put("PREFERRED_STYLE_WIDGET"+rs.getString("CONTENT_ID"),styleSheetSession);
					}*/
					session.setAttribute("allStyles",styleMapDB);
					
					System.out.println("AssignChartSummPreview.jsp:Line137:"+session.getAttribute("allStyles"));
				
				}
				catch(Exception e)
				{
					//out.println("Error while getting the data Table--Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
				//IN035950 Ends
		for(int k=1;k<=totalRows;k++)
		{
			//for(int i=0;i<positionsList.size();i+=6)//IN035950
			for(int i=0;i<positionsList.size();i+=7)//IN035950
			{
				temp = Integer.parseInt((String)positionsList.get(i));
				
				if(k == temp)
				{
					tempExists++;
					
					if(tempRowId == 0)
						{
							out.println("<tr>");
							tempRowId = temp;// writes for first row
						}
						else
						{
							if(tempRowId != temp)
							{
								out.println("</tr><tr>");
							}
							tempRowId = temp;					
						}
					
						//IN035950 Starts
						content_id = (String)positionsList.get(i+6);
						HashMap styleMap = null;
						if(session.getAttribute("allStyles")!=null )
						{
							styleMap = (HashMap)session.getAttribute("allStyles");
							styleSheetName = (String) styleMap.get("PREFERRED_STYLE_WIDGET"+content_id);
						}
						
						if(!"null".equals(styleSheetName) && null!=styleSheetName && styleSheetName!="" && !"undefined".equals(styleSheetName) && "Y".equals(widgetThemeIconIndicator) && "Y".equals(widgetThemeIndicator))
						{
						out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
						}
						else
						{
						content_id="";
						out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' />");
						styleSheetName=sStyle;
						}
						
						//IN035950 Ends
						//out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' align = 'center'><tr><td class='columnheader'>"+positionsList.get(i+4)+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90%'  ></iframe></td>");//IN035950
						if("Y".equals(widgetThemeIconIndicator) && "Y".equals(widgetThemeIndicator)){
						themeIcon = "<a  href='javascript:showThemes(\""+positionsList.get(i+6)+"\",\""+summaryId+"\",\""+patientClass+"\",\""+practitioner+"\",\""+speciality+"\",\""+positionsList.get(i+4)+"\",\""+styleSheetName+"\");' title='Personalize Themes' style='text-decoration:underline;color=ffffff;text-align=right'><img  src='../../eCA/images/WidgetSettings.png' align='right'/></a>";
						}
						if(!sStyle.equals(styleSheetName))
						{
						out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' cellspacing='0' border='0' align = 'center'><tr><td class='COLUMNHEADERCENTERNEW"+content_id+"' nowrap>"+positionsList.get(i+4)+"</td><td class='COLUMNHEADERCENTERNEW"+content_id+"' nowrap>"+themeIcon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90vh'  ></iframe></td>");
						}
						else
						{
						out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' cellpadding ='3' cellspacing='0' border='0' align = 'center'><tr><td class='COLUMNHEADERCENTERNEW' nowrap>"+positionsList.get(i+4)+"</td><td class='COLUMNHEADERCENTERNEW' nowrap>"+themeIcon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='90vh'  ></iframe></td>");
						}
						
						out.println("<input type=hidden name='widgetName"+positionsList.get(i+6)+"' id='widgetName"+positionsList.get(i+6)+"' value=''>");//IN035950
						
				}
			styleSheetName="";//IN035950
			
			content_id="";//IN035950
		
			}
			if(tempExists == 0){
				out.println("<tr></tr>");
			}
			tempExists=0;
		}

}catch(Exception e){
	//out.println("Error while getting the display Table--Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}

finally{
	try{
		positionsList.clear();
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
		//out.println("Exception in AssignChartSummPreview.jsp: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		
	}
}

            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientChartSummaryTemplatePreview.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChartSummaryTemplatePreviewof.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
