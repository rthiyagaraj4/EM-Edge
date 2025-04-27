package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheetcompdetailresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetCompDetailResult.jsp", 1728455764329L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<!-- Added by Arvind @ 07-12-08 -->\n\t\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/FlowSheetCompDetail.js\'></script>\n\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\t\n\n<form name=\"FlowSheetCompDetailResultForm\" id=\"FlowSheetCompDetailResultForm\" action=\'../../servlet/eCA.FlowSheetCompDetailServlet\' method=\"post\" target=\"messageFrame\">\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr ><th colspan=2  class=\'columnHeader\' align=\'left\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th></tr>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\">\n<tr>\n<th class=\'columnHeadercenter\' nowrap width=\"26%\" style=\"font-size:10\" align=\'left\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n<th class=\'columnHeadercenter\' nowrap width=\"26%\" style=\"font-size:10\" align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n<th class=\'columnHeadercenter\' nowrap width=\"38%\" style=\"font-size:10\" align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n<th class=\'columnHeadercenter\' nowrap width=\"10%\" style=\"font-size:10\" align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n</tr>\n</table>\n</div>\n\n\n\n<div id=\"finalDiv1\">\n<table class=\"grid\" width=\"100%\">\n\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n              <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" width=\"26%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" width=\"38%\" colspan=2>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>   \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" width=\"10%\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"chkbox";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" checked  onClick=\"selText(this)\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><input type=hidden name=\'clear";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'clear";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t   \t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</td>\n</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n               <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" width=\"38%\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t</tr> \n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n</table>\n</div>\n\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<input type=\"hidden\" name=\"flow_sheet_id\" id=\"flow_sheet_id\" value=\"\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
--------------------------------------------------------------------------------------------------------------
Date		Edit History      Name       	Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           										created
07/03/2017	 IN063542		Raja S			10/03/2017		Ramesh G			GHL-CRF-0460
---------------------------------------------------------------------------------------------------------------
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
            webbeans.eCommon.RecordSet FlowSheetBean= null;synchronized(session){
                FlowSheetBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("FlowSheetBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FlowSheetBean==null){
                    FlowSheetBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("FlowSheetBean",FlowSheetBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String code="";
	String description="";
	//String rowid="";
	String beanvalins="";
	//String eventgrouptype="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";
	String key="";
	String histtype="";

	String eventcode="";
	String eventdesc="";
	String histrectype="";
	String event_code_type="";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

   try
   {
    con =  ConnectionManager.getConnection(request);
	String flow_sheet_id=request.getParameter("flow_sheet_id")==null?"":request.getParameter("flow_sheet_id");
	//String history_type_id=request.getParameter("history_type_id")==null?"":request.getParameter("history_type_id");
	//String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		
	String classValue="";
	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
	//String formet="";
					//out.println("return_format :" +return_format);
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");


	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	if(mode.equals("insert"))
    FlowSheetBean.clearAll();
	

	if(sel_all.equals("select"))
	{	
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	//String cat = "";
	int i=0;
   if(flag.equals("clear"))
	{
		
      
		FlowSheetBean.clearAll();
	}
	
	if(!removebean.equals("Y"))
	{
		
		if(ret_str!=null && ret_str!="")
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"@");
   
			while(strtCodes.hasMoreTokens())
			{
			   
				temp= (String) strtCodes.nextToken();
			   StringTokenizer tempCodes = new StringTokenizer(temp,"~");
 				while(tempCodes.hasMoreTokens())
				{
					key= tempCodes.nextToken();
					value=tempCodes.nextToken();

				 FlowSheetBean.putObject(key);
				 FlowSheetBean.putObject(value);
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<FlowSheetBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					key=FlowSheetBean.getObject(i-1).toString();
					disbean=FlowSheetBean.getObject(i).toString();
					
					StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
				   valCodes.nextToken();  
	               
 	              
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(histtype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(description));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(key));
            _bw.write(_wl_block23Bytes, _wl_block23);

				
				//	cat=formet+textbuffer.toString();
				//	cat=cat.replace('|' , ',');
                    //cat=cat.replace('|' , '');  
				}
				}
				
            _bw.write(_wl_block24Bytes, _wl_block24);

	}

				


            _bw.write(_wl_block25Bytes, _wl_block25);


	if(removebean.equals("Y"))
	{
	// String beankey="";
	// String code2="";
	  for(int l=0;l<FlowSheetBean.getSize();l+=2)
	   {
			key=FlowSheetBean.getObject(l).toString();  

           
			if(remval.equalsIgnoreCase(key))
			{
					FlowSheetBean.removeObject(l);
					FlowSheetBean.removeObject(l);
					break;
			}
		}

				/*ArrayList d=new ArrayList();
				d=FlowSheetBean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				w=0;
				for( i=1;i<FlowSheetBean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
				    if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;

					key=FlowSheetBean.getObject(i-1).toString();
					beanval=FlowSheetBean.getObject(i).toString();
					
					StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
				{
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
				   valCodes.nextToken();  
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(histtype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(description));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(key));
            _bw.write(_wl_block27Bytes, _wl_block27);

						//cat=formet+textbuffer.toString();
						//cat=cat.replace('|' , ',');
                       // cat=cat.replace('|' , ' ');  
					}
		
	}
}
if(mode.equals("insert"))
		{	

//Commented for IN063542 Starts
/*
			//int count=0;
			//String sqlupdate="select A.HIST_REC_TYPE, A.LONG_DESC HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE " ; 
			String sqlupdate="select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'1') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.LANGUAGE_ID = ? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE";
			pstmt=con.prepareStatement(sqlupdate,ResultSet.TYPE_SCROLL_INSENSITIVE,
											  ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,locale);
			pstmt.setString(2,flow_sheet_id);
			pstmt.setString(3,locale);
*/
//Commented for IN063542 Ends

// Added changes starts IN063542
			StringBuffer updateSqlBuffer = new StringBuffer();

			updateSqlBuffer.append("select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'1') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D ,CA_FLOW_SHEET_ITEM B WHERE B.FLOW_SHEET_ID=? AND  B.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.LANGUAGE_ID = ? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE AND D.EVENT_CODE=B.EVENT_CODE AND D.EVENT_CODE_TYPE=B.EVENT_CODE_TYPE");

			updateSqlBuffer.append( " UNION SELECT B.HIST_REC_TYPE, DECODE (C.ORDER_CATEGORY, 'LB', 'Laboratory', 'RD', 'Radiology', '')  HIST_REC_TYPE_DESC,b.Event_code,D.LONG_DESC EVENT_DESC,C.ORDER_CATEGORY EVENT_CODE_TYPE  FROM CA_FLOW_SHEET_ITEM b, OR_ORDER_CATALOG c ,OR_ORDER_CATALOG_LANG d WHERE b.flow_sheet_id = ? AND b.Event_code = c.contr_msr_panel_id and C.ORDER_CATALOG_CODE= d.order_catalog_code and D.language_id=? and C.ORDER_CATALOG_NATURE='P'");
			
			pstmt=con.prepareStatement(updateSqlBuffer.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			int j=1;
			pstmt.setString(j++,locale);
			pstmt.setString(j++,flow_sheet_id);
			pstmt.setString(j++,locale);
			pstmt.setString(j++,flow_sheet_id);
			pstmt.setString(j++,locale);
// IN063542 Added Changes ends 
			rs=pstmt.executeQuery();
			while( rs.next())
			{
		 eventcode=rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 eventdesc=rs.getString("EVENT_DESC")==null?" ":rs.getString("EVENT_DESC");
		 histrectype=rs.getString("HIST_REC_TYPE")==null?" ":rs.getString("HIST_REC_TYPE");
		 event_code_type=rs.getString("EVENT_CODE_TYPE")==null?" ":rs.getString("EVENT_CODE_TYPE");
              
               key = histrectype+eventcode+event_code_type;
			   beanvalins = histrectype+"|"+eventcode+"|"+eventdesc+"|"+event_code_type;

				FlowSheetBean.putObject(key);
				FlowSheetBean.putObject(beanvalins);
				
				
			}if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
		

		for(i=1;i<FlowSheetBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;
			
		
					key=FlowSheetBean.getObject(i-1).toString();

					beanvalins=FlowSheetBean.getObject(i).toString();

										
					StringTokenizer valCodes = new StringTokenizer(beanvalins,"|");
					if(valCodes.hasMoreTokens())
				{
					
				   histtype=valCodes.nextToken();  	
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
                   valCodes.nextToken(); 
 	              
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(histtype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(description));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(key));
            _bw.write(_wl_block30Bytes, _wl_block30);

				
				
				}   
				} 
				}  

   

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i-2));
            _bw.write(_wl_block32Bytes, _wl_block32);

   }
catch(Exception e)
			{
				//out.println("Exception in try :"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
	
			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
	
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelectedItems.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HistoryType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
