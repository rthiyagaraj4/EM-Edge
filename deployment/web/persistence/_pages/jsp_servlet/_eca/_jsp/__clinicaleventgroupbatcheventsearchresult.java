package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventgroupbatcheventsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventGroupBatchEventSearchResult.jsp", 1709115732918L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/ClinicalEventGroup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/messages.js\"></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n\n<form name=\"ClinicalEventGroupBatchEventSearchResultForm\" id=\"ClinicalEventGroupBatchEventSearchResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n</td>\n</tr>\n</table>\n\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n<tr>\n <th style=\"font-size:10\" align=center width=\"26%\">Code</th>\n <th style=\"font-size:10\" align=center width=\"64%\" colspan=2>Description</th>\n<th style=\"font-size:10\" align=center width=\"10%\">All<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></th> \n</tr>\n</table>\n</div>\n<table border=\"1\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  name=\"resultTable2\" id=\"resultTable2\" id=\"resultTable2\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n                <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" width=\"26%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" colspan=2 width=\"64%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" width=\"10%\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"chkbox";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onClick=\"Reassaignbatch(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'chk_value";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td>\n\t\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'ret_value";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="~";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="|";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'> \n\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<script>document.forms[0].ctrlChkBox.checked = true</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n        <script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));</script>\n\t\t<script>document.forms[0].ctrlChkBox.disabled = true</script> \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\n\t\t\t\n</table>\n\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet BatchBean= null;synchronized(session){
                BatchBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BatchBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BatchBean==null){
                    BatchBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BatchBean",BatchBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
 	StringBuffer countsql = new StringBuffer(" ");
    
		
    String histype=request.getParameter("histype")==null?"":request.getParameter("histype");
	String contr=request.getParameter("contr")==null?"":request.getParameter("contr");
	String searchby=request.getParameter("searchby")==null?"":request.getParameter("searchby");
	String criteria=request.getParameter("criteria")==null?"":request.getParameter("criteria");
	String text=request.getParameter("text")==null?"":request.getParameter("text");
	
	//out.println("<script>alert('searchby"+searchby+"')</script>");
	//out.println("<script>alert('criteria"+criteria+"')</script>");
	//out.println("<script>alert('text"+text+"')</script>");
		
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	String code="";
	String description=""; 
			
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		StringBuffer strbuf= new StringBuffer("");

    if(histype.equals("CLNT") && contr.equals("CA"))
	{
    strsql1.append("SELECT rowid row_id,NOTE_GROUP EVENT_GROUP_CODE, REPLACE(NOTE_GROUP_DESC,'''','') SHORT_DESC FROM CA_NOTE_GROUP A WHERE EFF_STATUS='E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.NOTE_GROUP AND EVENT_GROUP_TYPE=?)");



	 if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and NOTE_GROUP like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and NOTE_GROUP like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and NOTE_GROUP like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and NOTE_GROUP_DESC like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and NOTE_GROUP_DESC like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and NOTE_GROUP_DESC like '%"+text+"%'");
		}

	countsql.append("SELECT count(*) total FROM CA_NOTE_GROUP A WHERE EFF_STATUS='E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.NOTE_GROUP AND EVENT_GROUP_TYPE=?)");

   	strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());

	
    }
	else if((histype.equals("PTCR") && contr.equals("OR")) || (histype.equals("TRET") && contr.equals("OR")) || (histype.equals("LBIN") && contr.equals("OR")) || (histype.equals("RDIN" ) && contr.equals("OR")) || (histype.equals("SUNT") && contr.equals("OR")))
	{
     strsql1.append("SELECT rowid row_id,discr_msr_id EVENT_GROUP_CODE,replace(short_desc,'''','') short_desc from am_discr_msr  A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE=?)");

	 countsql.append("SELECT count(*) total from am_discr_msr A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE=?)");

	  if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and discr_msr_id like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and discr_msr_id like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and discr_msr_id like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
      		
	}
	else if(histype.equals("RDIN") && contr.equals("RD"))
	{
		 strsql1.append("SELECT rowid row_id,EXAM_CODE EVENT_GROUP_CODE,replace(short_desc,'''','') short_desc from rd_examination A where NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.EXAM_CODE AND EVENT_GROUP_TYPE=?)");

		 countsql.append("SELECT count(*) total from rd_examination a where NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.EXAM_CODE AND EVENT_GROUP_TYPE=?)");

		  if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and EXAM_CODE like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and EXAM_CODE like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and EXAM_CODE like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
		
	}
	else if(histype.equals("LBIN") && contr.equals("LB"))
	{
    
	strsql1.append("SELECT rowid row_id,test_code EVENT_GROUP_CODE, short_desc from rl_test_code a where group_test_yn = 'Y' and nvl(status,'E') = 'E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.TEST_CODE AND EVENT_GROUP_TYPE=?)");
    
	 countsql.append("SELECT count(*) total from rl_test_code A where group_test_yn = 'Y' and nvl(status,'E') = 'E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.TEST_CODE AND EVENT_GROUP_TYPE=?)");

	   if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and test_code like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and test_code like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and test_code like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and short_desc like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and short_desc like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and short_desc like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());

	
	}

   	try
	{
       con =  ConnectionManager.getConnection(request);

	   stmt = con.prepareStatement(countsql.toString());

	   int s=0;

		
        stmt.setString(++s,histype);
		stmt.setString(++s,contr);
		
				
    	rs = stmt.executeQuery();

		if(rs.next())
		{
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));
		}

		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
       
        
        where.append(" order by 3");
	    strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);

	    }

		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		
        stmt.setString(++st,histype);
		stmt.setString(++st,contr);
		
				
    	rs = stmt.executeQuery();
	    
	 
            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
		{
out.println("<td width='85%' class='CAGROUP' align=center><b><font size='2'>Search Result</b></td><td width='10%' align=right nowrap>");
out.println("<A HREF='../../eCA/jsp/ClinicalEventGroupBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>Previous</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' align=center><b><font size='2'>Search Result</b></td><td width='10%' align=right nowrap>");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/ClinicalEventGroupBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>Next</A>");
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	//out.println("<script>alert('start"+start+"')</script>");
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
      if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
	//out.println("<script>alert('rs.next()="+rs.next()+"')</script>");

		String classValue="";
		String rowid="";
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		
		 rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 code=rs.getString("EVENT_GROUP_CODE")==null?" ":rs.getString("EVENT_GROUP_CODE");
		 description=rs.getString("SHORT_DESC")==null?" ":rs.getString("SHORT_DESC");
		 
		
		 	 
		 if ( i % 2 == 0 )
		 classValue = "QRYODD" ;
		 else
		 classValue = "QRYEVEN" ;
	  	
	    
		 String beankey="";		
	 	 String checkstatus="";		
         
		for(int m=0;m<BatchBean.getSize();m+=2)
				{
					beankey=BatchBean.getObject(m).toString();
					
  					if(rowid.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
				
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(description));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(description));
            _bw.write(_wl_block26Bytes, _wl_block26);

				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					
            _bw.write(_wl_block27Bytes, _wl_block27);
}
		if(i == 1)
		{
   		
            _bw.write(_wl_block28Bytes, _wl_block28);
}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkFutureEventResult.jsp" + e);//common-icn-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
