package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qaanalyzepartialindsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAAnalyzePartialIndSearchResult.jsp", 1742817542616L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<base target=\"_self\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="   \n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eQA/js/QAAnalyzePartialIndicators.js\' language=\'javascript\'></script>\n<!-- <script src=\"../../eCommon/js/Common.js\" language=\"javascript\"> </script> -->\n<Script src=\"../../eQA/js/QAMessages.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey();\'>\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'QAAnalyzePartialIndSearchResult.jsp\' >\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t</tr>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t \n\t\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\n\n\t\t<input type=hidden name=\'rowVal\' id=\'rowVal\'  value=\'\'>\n\t\t<input type=hidden name=\'PATIENT_ID\' id=\'PATIENT_ID\'  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=hidden name=\'PATIENT_NAME\' id=\'PATIENT_NAME\'  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=hidden name=\'ENCOUNTER_ID\' id=\'ENCOUNTER_ID\'   value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=hidden name=\'FACILITY_ID\' id=\'FACILITY_ID\'   value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=hidden name=\'PATIENT_CLASS\' id=\'PATIENT_CLASS\'   value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<!-- <input type=hidden name=\'QIND_DISCIPLINE_ID\' id=\'QIND_DISCIPLINE_ID\' value=\'\'> -->\n\t\t<input type=hidden name=\'QUERY_PARAM\' id=\'QUERY_PARAM\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	    request.setCharacterEncoding("UTF-8");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int max_records = 15;		
				
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 12:Integer.parseInt(request.getParameter("max_records"));
			String sql= request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			//out.println("sql:" + sql);
			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;
				
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

				String strQueryParam = request.getQueryString();
				String row = "<tr style='background-color:;'>";
				String evn = " <td class='QRYEVEN'";
				String odd = " <td class='QRYODD'";
				String strHtmlData = "";
				String strClickEvent = " onClick='fun(this)' ";
				//String strEncounterId = "";
				String strFacilityId="";
				String strClindStatus="";
				String strDiagCode="";
				String strProcCode="";
				String SYS_USER_CREATED="";

				//String strStatus;
				int intStatus = 0;
				
				String strEncounterId ="";
				//String  ASSIGN_CARE_LOCN_CODE  ="";
				String  PATIENT_NAME ="";          
				String  SEX         ="";           
				String  PATIENT_ID     ="";        
				//String  PRACTITIONER_ID     =""; 
				
				String PATIENT_CLASS="";
				String strIndicator = "";
				String strIndicatorId = "";
				String VISIT_ADM_DATE_TIME ="";
				String strQindStatus = "";
				String subTag="";
				String strTagPlus="";
				String mainTag="";
				String strHandCursor = " style='cursor:pointer' ";

				int intTempStart = start;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
					
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");
				vectorHtmlData.add("<th width='1%'>St</th>");
			//	vectorHtmlData.add("<th width='1%'>An</th>");
				vectorHtmlData.add("<th width='12%' onmouseover='hidetooltip();' nowrap>Encounter Id</th>");
//				vectorHtmlData.add("<th width='12%'>Location</th>");
				vectorHtmlData.add("<th width='25%' onmouseover='hidetooltip();'>Patient Name</th>");
				vectorHtmlData.add("<th width='1%'>Gender</th>");
				vectorHtmlData.add("<th width='10%'>Patient ID</th>");
				vectorHtmlData.add("<th width='25%' nowrap>Indicator</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Discharged Date</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Status</th>");
				//vectorHtmlData.add("<tr>");
			//	vectorHtmlData.add("<td>&nbsp;&nbsp;</td>");
			//	vectorHtmlData.add("<td colspan='4' class='label' align='left'><b class='label'>Encounter(Closed)</b><b style='background:brown'>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>");
			//	vectorHtmlData.add("<td colspan='4'>&nbsp;&nbsp;</td>");
				//vectorHtmlData.add("</tr>");
				

				while(rs.next())
				{

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					
				 strFacilityId=rs.getString("FACILITY_ID");
				 strEncounterId = rs.getString("ENCOUNTER_ID");
				 PATIENT_NAME=rs.getString("PATIENT_NAME");
				 SEX         =rs.getString("GENDER");
				 PATIENT_CLASS=rs.getString("PATIENT_CLASS");
				 PATIENT_ID     =rs.getString("PATIENT_ID");
				 strIndicatorId=rs.getString("QIND_CLIND_ID");
				 strIndicator = rs.getString("QIND_CLIND_Desc");
				 VISIT_ADM_DATE_TIME =rs.getString("ENCOUNTER_START_DATE");
				 strClindStatus=rs.getString("CLIND_ANALYSIS_STATUS");
				 strQindStatus=rs.getString("STATUS_DESC");
				 strDiagCode=rs.getString("INCL_DIAG_CODE");
				 strProcCode=rs.getString("INCL_PROC_CODE");
				 SYS_USER_CREATED=rs.getString("SYS_USER_CREATED");
				                
			//	 if(strQindStatus.equals("null")||strQindStatus.equals("")||strQindStatus=="")
			//	 strQindStatus="&nbsp;";
				  
				  if (intFetchedRecords%2 == 0)	
						strHtmlData =  evn ;
					
				  else	strHtmlData = odd;					

				  if(intStatus==2)		strTagPlus="<td class='Brown'";
				  else			strTagPlus=strHtmlData;

				// if(strQindStatus.equals("9")==true)
				//	      subTag="<td class='Green'";
				// else		 subTag=strHtmlData; 

			
			mainTag=strTagPlus+" ID='"+strEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' FACILITY_ID='"+strFacilityId+"' PATIENT_CLASS ='"+PATIENT_CLASS+ "' QIND_CLIND_Desc='"+strIndicator+"' QIND_CLIND_ID='"+strIndicatorId +"' CLIND_ANALYSIS_STATUS='"+strClindStatus+ "' INCL_DIAG_CODE='"+strDiagCode+"' INCL_PROC_CODE='"+strProcCode+ "' SYS_USER_CREATED='"+SYS_USER_CREATED+"'"+strHandCursor+strClickEvent+"><b class='label'>+</b></td>"+ subTag ;
			//out.println(strIndicatorId);
			
		//	out.println("<script>alert('"+ mainTag+ "')</script>");
			//mainTag=mainTag+tooltip1;
			mainTag=mainTag+strHtmlData+" onmouseover='hidetooltip();' ID='"+strEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' FACILITY_ID='"+strFacilityId+"' PATIENT_CLASS ='"+PATIENT_CLASS+ "' QIND_CLIND_Desc='"+strIndicator+"' QIND_CLIND_ID='"+strIndicatorId +"' CLIND_ANALYSIS_STATUS='"+strClindStatus+ "' INCL_DIAG_CODE='"+strDiagCode+"' INCL_PROC_CODE='"+strProcCode+ "' SYS_USER_CREATED='"+SYS_USER_CREATED+"'"+strHandCursor+strClickEvent+"> <b class='label'>"+ strEncounterId +"</b></td>"+ strHtmlData+" onmouseover='hidetooltip();'> <b class='label'>"+  PATIENT_NAME +"</b></td>"+ strHtmlData+"><b class='label'>"+  SEX         +"</b></td><b class='label'>"+ strHtmlData+"><b class='label'>"+  PATIENT_ID     +"</b></td>"+ strHtmlData+"><b class='label'>"+strIndicator+"</b></td>"+ strHtmlData+"><b class='label'>"+  VISIT_ADM_DATE_TIME +"</b></td>"+strHtmlData+"><b class='label'>"+strQindStatus +"</b></td>";			
					vectorHtmlData.add(mainTag);
					vectorHtmlData.add("</tr>");
					//vectorHtmlData.add(tooltip1);
//				out.println(mainTag);
					if (intFetchedRecords > max_records)
					{
						break;
					}
					
				} 
				 //if(rs!=null) rs.close();
				 // if(pstmt!=null)pstmt.close();
				vectorHtmlData.add("</table>");
				
				String tooltip1="<div style='position:absolute; width:10%; visibility:hidden;' id='tooltip' ><table id='tooltiptable1'  cellpadding=0 cellspacing=0 border='1'   class='BOX' width='10%' align='center'><TR><TD id='tooltipdata' ></TD></TR></TABLE></div>";
				vectorHtmlData.add(tooltip1);
			
			
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		if ((start>=1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
       if(intFetchedRecords==0)
	{
            _bw.write(_wl_block10Bytes, _wl_block10);
  vectorHtmlData.clear(); }
		if (intFetchedRecords > max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
				//System.out.println((String)vectorHtmlData.get(l));
			}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(PATIENT_ID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(PATIENT_NAME));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(PATIENT_CLASS));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strQueryParam));
            _bw.write(_wl_block22Bytes, _wl_block22);

		           if(rs!=null) rs.close();
				   if(pstmt!=null)pstmt.close();
				  vectorHtmlData.clear();
				}
		
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception in File QAAnalyzePartialIndSearchResult:"+e.toString());
		}
		finally
            {
	         ConnectionManager.returnConnection(conn, request);
            }

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
