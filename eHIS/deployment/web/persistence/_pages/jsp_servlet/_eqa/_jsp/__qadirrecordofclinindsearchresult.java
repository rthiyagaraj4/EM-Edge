package jsp_servlet._eqa._jsp;

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

public final class __qadirrecordofclinindsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QADirRecordOfClinIndSearchResult.jsp", 1742817543398L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n<title> ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</title>\n<base target=\"_self\">\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="   \n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eQA/js/QADirRecordOfClinIndicators.js\' language=\'javascript\'></script>\n<Script Language=\'JavaScript\' src=\'../../eCommon/js/messages.js\'></Script>\n<Script src=\"../../eQA/js/QAMessages.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'QADirRecordOfClinIndSearchResult.jsp\' >\n\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t</tr>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t \n\t\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

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
			max_records = (request.getParameter("max_records")== null) ?8 :Integer.parseInt(request.getParameter("max_records"));
			//out.println("=============="+max_records);
			String sql= request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;

			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

			
				String row = "<tr style='background-color:;'>";
				String evn = " <td class='QRYEVEN'";
				String odd = " <td class='QRYODD'";
				String strHtmlData = "";
				String strClickEvent = " onClick='fun(this)' ";
				String strFacilityIdEncounterId = "";
				String strFacilityId="";
				String strStatus;
				int intStatus = 0;
				String strQindStatus = "";
				String strEncounterId ="";
				String  ASSIGN_CARE_LOCN_CODE  ="";
				String  PATIENT_NAME ="";          
				String  SEX         ="";           
				String  PATIENT_ID     ="";        
				String  PRACTITIONER_ID     =""; 
				String  VISIT_ADM_DATE_TIME ="";
				String PATIENT_CLASS="";
				String subTag="";
				String strTagPlus="";
				String mainTag="";
				String strHandCursor = " style='cursor:pointer' ";

				int intTempStart = start;
							
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");
				vectorHtmlData.add("<th width='1%'>St</th>");
				//vectorHtmlData.add("<th width='1%'>An</th>");
				vectorHtmlData.add("<th width='12%' nowrap>Encounter Id</th>");
				vectorHtmlData.add("<th width='12%'>Location</th>");
				vectorHtmlData.add("<th width='40%'>Patient Name</th>");
				vectorHtmlData.add("<th width='1%'>Gender</th>");
				vectorHtmlData.add("<th width='10%'>Patient ID</th>");
				vectorHtmlData.add("<th width='10%' nowrap>Practitioner ID</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Admit Visit Date</th>");
				vectorHtmlData.add("<tr>");
				vectorHtmlData.add("<td>&nbsp;&nbsp;</td>");
				vectorHtmlData.add("<td colspan='4' class='label' align='left'><b class='label'>Encounter(Closed)</b><b style='background:brown'>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>");
				vectorHtmlData.add("<td colspan='4'>&nbsp;&nbsp;</td>");
				vectorHtmlData.add("</tr>");
				

				while(rs.next())
				{

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					

				 strFacilityIdEncounterId = rs.getString("FAC_ENC_ID");
				 strFacilityId=rs.getString("FACID");
				 strStatus=rs.getString("ENC_STATUS"); 			
				 if(strStatus.equalsIgnoreCase("null")==false)
				 intStatus = Integer.parseInt(strStatus);
				 strQindStatus = rs.getString("QIND_ANALYSIS_STATUS");
                 strQindStatus = strQindStatus.trim();
				 if(strQindStatus.equals("null")||strQindStatus.equals("")||strQindStatus=="")
				 strQindStatus="&nbsp;";


				  strEncounterId =rs.getString("ENCOUNTER_ID");
				  ASSIGN_CARE_LOCN_CODE  =rs.getString("ASS_LOCN");
				  PATIENT_NAME =rs.getString("PATIENT_NAME");          
				  SEX         =rs.getString("GENDER");           
				  PATIENT_ID     =rs.getString("PATIENT_ID");        
				  PRACTITIONER_ID     =rs.getString("PRACTITIONER_ID"); 
				
				   PRACTITIONER_ID = PRACTITIONER_ID.trim();
				 if(PRACTITIONER_ID.equals("")||PRACTITIONER_ID=="")
				 PRACTITIONER_ID="&nbsp;";
					
				  VISIT_ADM_DATE_TIME =rs.getString("DATE_TIME");
				  PATIENT_CLASS=rs.getString("PATIENT_CLASS");

				  if (intFetchedRecords%2 == 0)	
						strHtmlData =  evn ;
					
				  else	strHtmlData = odd;					

				  if(intStatus==2)		strTagPlus="<td class='Brown'";
				  else			strTagPlus=strHtmlData;

				 if(strQindStatus.equals("9")==true)
					      subTag="<td class='Green'";
				 else		 subTag=strHtmlData;

		//	mainTag=strTagPlus+" ID='"+strFacilityIdEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' FACILITY_ID='"+strFacilityId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' PATIENT_CLASS='"+PATIENT_CLASS +"'"+strHandCursor+strClickEvent+">	<b class='label'>+</b>		</td>"+ subTag+" >"+ strQindStatus +"</td>";
			mainTag=strTagPlus+" ID='"+strFacilityIdEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' FACILITY_ID='"+strFacilityId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' PATIENT_CLASS='"+PATIENT_CLASS +"'"+strHandCursor+strClickEvent+">	<b class='label'>+</b>		</td>";

					
			mainTag=mainTag+strHtmlData+"> <b class='label'>"+ strEncounterId +"</b></td>"+ strHtmlData+"><b class='label'>"+  ASSIGN_CARE_LOCN_CODE  +"</b></td>"+ strHtmlData+"> <b class='label'>"+  PATIENT_NAME +"</b></td>"+ strHtmlData+"><b class='label'>"+  SEX         +"</b></td><b class='label'>"+ strHtmlData+"><b class='label'>"+  PATIENT_ID     +"</b></td>"+ strHtmlData+"><b class='label'>"+PRACTITIONER_ID+"</b></td>"+ strHtmlData+"><b class='label'>"+  VISIT_ADM_DATE_TIME +"</b></td>";			
					vectorHtmlData.add(mainTag);
					vectorHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				} if(rs!=null) rs.close();
				  if(pstmt!=null)pstmt.close();
				vectorHtmlData.add("</table>");
				
			
			
		
            _bw.write(_wl_block5Bytes, _wl_block5);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		} if(intFetchedRecords==0)
	       {
            _bw.write(_wl_block6Bytes, _wl_block6);
  vectorHtmlData.clear(); }

		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block7Bytes, _wl_block7);

			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block12Bytes, _wl_block12);

		           if(rs!=null) rs.close();
				   if(pstmt!=null)pstmt.close();
				   vectorHtmlData.clear();}
		
		catch(Exception e)
		{
			out.println("Exception in File QADirRecordOfClinIndSearchResult"+e.toString());
		}
		finally
            {
	         ConnectionManager.returnConnection(conn, request);
            }

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
