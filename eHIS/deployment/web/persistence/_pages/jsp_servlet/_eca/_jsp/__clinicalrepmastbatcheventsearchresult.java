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

public final class __clinicalrepmastbatcheventsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalRepMastBatchEventSearchResult.jsp", 1709115756105L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- <modifeid by Archana  @08-12-2008> -->\n        \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/ClinicalRepMast.js\"></script>\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"ClinicalEventGroupBatchEventSearchResultForm\" id=\"ClinicalEventGroupBatchEventSearchResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"0\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</tr>\n\t <tr>\n\t <td  colspan = 4 width=\'100%\' align=\'right\'>\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n</td>\n</tr>\n</table>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\' name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n<tr>\n <td class=\'COLUMNHEADERCENTER\' style=\"font-size:10\" width=\"25%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n <td class=\'COLUMNHEADERCENTER\' style=\"font-size:10\" width=\"75%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<!--<th style=\"font-size:10\" align=center width=\"10%\">All<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></th> -->\n</tr>\n</table>\n</div>\n\n<table class=\'grid\' width=\"100%\" align=\'center\' name=\"resultTable2\" id=\"resultTable2\" id=\"resultTable2\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" width=\"25%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" width=\"60%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" width=\"15%\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"chkbox";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" onClick=\"Reassaignbatch(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'chk_value";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td>\n\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'ret_value";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="~";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="|";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> \n\t\t\t<input type=hidden name=\'code_res";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'code_res";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n</table>\n</form>\n</body>\n</script>\n</html>\n\n";
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
--------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Review Date	Reviewer	Description
--------------------------------------------------------------------------------------------------------
20/4/2015	IN055043		  Karthi								CA-Parameter Setup - Event Setup - System does not respond.
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	StringBuffer strsql1	= new StringBuffer(" ");
 	StringBuffer where		= new StringBuffer(" ");
 	StringBuffer countsql	= new StringBuffer(" ");
	StringBuffer strbuf		= new StringBuffer("");
    
    String histype		=	request.getParameter("histype")==null?"":request.getParameter("histype");
	String contr		=	request.getParameter("contr")==null?"":request.getParameter("contr");
	String searchby		=	request.getParameter("searchby")==null?"":request.getParameter("searchby");
	String criteria		=	request.getParameter("criteria")==null?"":request.getParameter("criteria");
	String text			=	request.getParameter("text")==null?"":request.getParameter("text");
	String from 		= 	request.getParameter("from");
	String to 			= 	request.getParameter("to");
	String whereclause	=	request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	String code			=	"";
	String description	=	""; 
			
	Connection con			=	null;
	PreparedStatement stmt	=	null;
	ResultSet rs			=	null;
	
	int start		=	0;
	int end			=	0;
	int i			=	1;
	int k			=	0;
	int maxRecord	=	0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	if(histype.equals("BLTF") && contr.equals("BT") )
	{
		strsql1.append("SELECT rowid row_id,PRODUCT_CODE EVENT_CODE,SHORT_DESC SHORT_DESC,LONG_DESC LONG_DESC ,nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.PRODUCT_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn  FROM BT_PRODUCT_MAST A  WHERE NVL(STATUS,'E') ='E' ");

		if(searchby.equals("C"))
		{	// added text to upper case for existing PRODUCT_CODE condition - 55043
			if(criteria.equals("S"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(PRODUCT_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	// added text to upper case for existing LONG_DESC condition - 55043
			if(criteria.equals("S"))
				strbuf.append(" and upper(LONG_DESC) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(LONG_DESC) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(LONG_DESC) like upper('%"+text+"%')");
		}

		countsql.append("SELECT count(*) total FROM BT_PRODUCT_MAST A WHERE NVL(STATUS,'E')='E' ");
		
   		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}

	if((histype.equals("CLNT") && contr.equals("CA"))||(histype.equals("LBIN") && contr.equals("CA")) ||      (histype.equals("TRET") && contr.equals("CA"))||(histype.equals("TRET") && contr.equals("CA")) || (histype.equals("RDIN") && contr.equals("CA"))||(histype.equals("SUNT") && contr.equals("CA")) || (histype.equals("PTCR") && contr.equals("CA")))
	{
		strsql1.append("SELECT rowid row_id,NOTE_TYPE EVENT_CODE, NOTE_TYPE_DESC SHORT_DESC, NOTE_TYPE_DESC LONG_DESC,	nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.NOTE_TYPE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM CA_NOTE_TYPE A WHERE EFF_STATUS ='E'");

		if(searchby.equals("C"))
		{	// added text to upper case for existing NOTE_TYPE_DESC condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(NOTE_TYPE) like upper('"+text+"%')");
		}
	    else if(searchby.equals("D"))
		{	// added text to upper case for existing NOTE_TYPE_DESC condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(NOTE_TYPE_DESC) like upper('%"+text+"%')");
		}

		countsql.append("SELECT count(*) total FROM CA_NOTE_TYPE A WHERE EFF_STATUS='E' ");

   		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
    }
	else if((histype.equals("PTCR") && contr.equals("OR")) || (histype.equals("TRET") && contr.equals("OR")) || (histype.equals("LBIN") && contr.equals("OR")) || (histype.equals("RDIN" ) && contr.equals("OR")) || (histype.equals("SUNT") && contr.equals("OR"))||(histype.equals("FDOC") && contr.equals("OR")))
	{
	 strsql1.append("SELECT rowid row_id,discr_msr_id EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.discr_msr_id AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM am_discr_msr A WHERE EFF_STATUS ='E' and result_type in ('Z','V','G')");
	 countsql.append("SELECT count(*) total from am_discr_msr A where eff_status = 'E' and result_type in ('Z','V','G') ");

	  if(searchby.equals("C"))
	  {	//added text to upper case for existing discr_msr_id condition - 55043
		 if(criteria.equals("S"))
		   strbuf.append(" and upper(discr_msr_id) like upper('"+text+"%')");
		 else if(criteria.equals("E"))
			 strbuf.append(" and upper(discr_msr_id) like upper('%"+text+"')");
		 else if(criteria.equals("C"))
			strbuf.append(" and upper(discr_msr_id) like upper('%"+text+"%')");
	  }
	  else if(searchby.equals("D"))
	  {	//added text to upper case for existing short_desc condition - 55043
		 if(criteria.equals("S"))
			strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
		 else if(criteria.equals("E"))
			strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
		 else if(criteria.equals("C"))
			strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
	   }
    
	   strsql1.append(strbuf.toString());
	   countsql.append(strbuf.toString());
	}
	else if((histype.equals("TRET") && contr.equals("MC")) || (histype.equals("RDIN") && contr.equals("MC")) || (histype.equals("SUNT") && contr.equals("MC")))
	{
     
		strsql1.append("SELECT rowid row_id,CPT_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.CPT_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM MR_CPT_CODE A WHERE EFF_STATUS ='E'");
		countsql.append("SELECT count(*) total from MR_CPT_CODE A where eff_status = 'E' ");

		 if(searchby.equals("C"))
		 {	//added text to upper case for existing CPT_CODE condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(CPT_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(CPT_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(CPT_CODE) like upper('%"+text+"%')");
		 }
		 else if(searchby.equals("D"))
		 {	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		 }
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if((histype.equals("TRET") && contr.equals("M9")) || (histype.equals("RDIN") && contr.equals("M9")) || (histype.equals("SUNT") && contr.equals("M9")))
	{
		 strsql1.append("SELECT rowid row_id,DIAG_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.DIAG_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM MR_ICD_CODE A WHERE EFF_STATUS ='E'");
		 countsql.append("SELECT count(*) total from MR_ICD_CODE A where eff_status = 'E' ");

		if(searchby.equals("C"))
		{	//added text to upper case for existing DIAG_CODE condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(DIAG_CODE) like upper('%"+text+"%')");
		}
	    else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}

		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("RDIN") && contr.equals("RD"))
	{	//added text to upper case for existing short_desc condition - 55043
		 strsql1.append("SELECT rowid row_id,EXAM_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.EXAM_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM rd_examination A WHERE nvl(status,'E')='E'");
		 countsql.append("SELECT count(*) total from rd_examination WHERE 1=1 ");

		 if(searchby.equals("C"))
		 {	//added text to upper case for existing EXAM_CODE condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(EXAM_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				strbuf.append(" and upper(EXAM_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				strbuf.append(" and upper(EXAM_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("SUNT") && contr.equals("OT"))
	{
		 strsql1.append("SELECT rowid row_id,OPER_CODE EVENT_CODE,replace(short_desc,'''','') short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.OPER_CODE AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM OT_OPER_MAST A WHERE nvl(STATUS,'E') ='E'");
		 countsql.append("SELECT count(*) total from OT_OPER_MAST a where nvl(STATUS,'E') = 'E' ");
  	     
		 if(searchby.equals("C"))
		 {	//added text to upper case for existing OPER_CODE condition - 55043
			 if(criteria.equals("S"))
				 strbuf.append(" and upper(OPER_CODE) like upper('"+text+"%')");
			 else if(criteria.equals("E"))
				 strbuf.append(" and upper(OPER_CODE) like upper('%"+text+"')");
			 else if(criteria.equals("C"))
				 strbuf.append(" and upper(OPER_CODE) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}
	else if(histype.equals("LBIN") && contr.equals("LB"))
	{
		strsql1.append("SELECT rowid row_id,test_code EVENT_CODE, short_desc, nvl( (SELECT 'Y' FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ? AND EVENT_CODE = A.test_code AND EVENT_CODE_TYPE=?) ,'N') exist_yn FROM rl_test_code A WHERE NVL(STATUS,'E') ='E' AND  group_test_yn = 'Y' ");
		countsql.append("SELECT count(*) total from rl_test_code A where group_test_yn = 'Y' and nvl(status,'E') = 'E' ");

		if(searchby.equals("C"))
		{	//added text to upper case for existing test_code condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(test_code) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(test_code) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(test_code) like upper('%"+text+"%')");
		}
		else if(searchby.equals("D"))
		{	//added text to upper case for existing short_desc condition - 55043
			 if(criteria.equals("S"))
				strbuf.append(" and upper(short_desc) like upper('"+text+"%')");
			else if(criteria.equals("E"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"')");
			else if(criteria.equals("C"))
				strbuf.append(" and upper(short_desc) like upper('%"+text+"%')");
		}
    
		strsql1.append(strbuf.toString());
		countsql.append(strbuf.toString());
	}

   	try
	{
		
		con =  ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(countsql.toString());
		rs = stmt.executeQuery();

		if(rs.next())
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));

		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
		    where.append(" order by 3");
			strsql1.append(where.toString()); 
	    }
	    else
			strsql1.append(whereclause);
	
		stmt = con.prepareStatement(strsql1.toString());
		
		int st=0;
		
        stmt.setString(++st,histype);
		stmt.setString(++st,contr);
		rs = stmt.executeQuery();
	 
            _bw.write(_wl_block8Bytes, _wl_block8);

	//out.println("<td width='90%' class='CAGROUP' align=center><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='90%' class='CAGROUP' ></td>");
 
            _bw.write(_wl_block9Bytes, _wl_block9);

	if ( !(start <= 1) )
	{
		
		out.println("<A class='gridLink' HREF='../../eCA/jsp/ClinicalRepMastBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	
	if ( !( (start+14) > maxRecord ) )
		{
		out.println("<A class='gridLink' HREF='../../eCA/jsp/ClinicalRepMastBatchEventSearchResult.jsp?histype="+histype+"&searchby="+searchby+"criteria="+criteria+"&contr="+contr+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 
	String classValue	=	"";
	String rowid		=	"";
	String beankey1		=	"";
//	String beankey2		=	"";
	String checkstatus	=	"";	
	String strExists	=	"N";
	String code1="";
	String description1="";
	
	int p				=	0; 

	if ( start != 1 )
	{
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
	}
	
	
	while(rs!=null && rs.next() && i<=end)
	{	
		 rowid			=	rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 code			=	rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 description	=	rs.getString("SHORT_DESC")==null?" ":rs.getString("SHORT_DESC");
		 strExists		=	rs.getString("exist_yn")==null?"N":rs.getString("exist_yn");

		 if ( i % 2 == 0 )
			classValue = "gridData" ;
		 else
			classValue = "gridData" ;
         
		 checkstatus = "";
		 for(int m=0;m<BatchBean.getSize();m+=2)
		 {

			//beankey=BatchBean.getObject(m).toString();
			beankey1=BatchBean.getObject(m+1).toString();
			//beankey2=BatchBean.getObject(m+2).toString();
			

			StringTokenizer valCodes = new StringTokenizer(beankey1,"|");

			while(valCodes.hasMoreTokens())
			{
					
				   code1=valCodes.nextToken();
				   
	               description1=valCodes.nextToken();

			
					
				if(code.equalsIgnoreCase(code1))
				{
				checkstatus="checked";
                p++; 
				break;
				}
			}
		 }
		 
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(description));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(k));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(description));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(code));
            _bw.write(_wl_block31Bytes, _wl_block31);

			i++;
			k++;
		}
		//IN055043 - Start
		if(i==1)
		{	
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')); location.href='../../eCommon/html/blank.html'</script>");
		}
		// End	
		/*
		if((p+1) == i || p == 14)
		{
		
			<script>document.forms[0].ctrlChkBox.checked = true</script> 
			<%
		}
			
		
		if(i == 1)
		{
   			
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script>
				<script>document.forms[0].ctrlChkBox.disabled = true</script> 
			<%
		}*/
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();		 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in ClinicalRepMastBatchEventSearchResult.jsp" + e);//COMMON-ICN-0181
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
}
