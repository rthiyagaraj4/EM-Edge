package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientassessmentdiagnosis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PatientAssessmentDiagnosis.jsp", 1709116602621L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t<script src=\'../../eCP/js/PatientAssessment.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t</head>\n\t<body onmouseDown=\'CodeArrest();\'>\n\t\t<script>\n\t\t\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\t\t\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\t\t</script>\n\t\t<form name=\'patAssessDiagnosisForm\' id=\'patAssessDiagnosisForm\' action=\'\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t\t\t<table width=\'100%\' align=\'center\' border=1 cellpadding=1 cellspacing=1 id=\'selTable\'>\n\t\t\t\t<tr id=\'trId\'>\n\t\t\t\t\t<th colspan=\'2\' align=\'left\' style=\'BACKGROUND-COLOR:#ffc5b5;color:black\'><a href=\'javascript:\' onclick=\"showDesc(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'SystemDefined\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\">Diagnosis</a></th>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<table width=\'100%\' align=\'center\' border=1 cellpadding=1 cellspacing=1 id=\'selTable\'>\n\t\t\t\t<tr id=\'trId\'>\n\t\t\t\t\t<th colspan=\'2\' align=\'left\' style=\'BACKGROUND-COLOR:#ffc5b5;color:black\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'trId\'>\t\t\t\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<table width=\'100%\' align=\'center\' border=1 cellpadding=1 cellspacing=1 id=\'selTable\'>\t\t\t\t\n\t\t\t\t<tr id=\'trId\'>\t\t\t\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' name=\'chk_cnt\' id=\'chk_cnt\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'abnormal_categ\' id=\'abnormal_categ\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</html>\n\n";
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
            eCP.PatientAssessmentDiag diagBean= null;synchronized(session){
                diagBean=(eCP.PatientAssessmentDiag)pageContext.getAttribute("diagBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(diagBean==null){
                    diagBean=new eCP.PatientAssessmentDiag();
                    pageContext.setAttribute("diagBean",diagBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String status_flag = request.getParameter("status_flag") == null ? "" : request.getParameter("status_flag");
			String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			String assess_ref_no = request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
			String ss_dep_desc = request.getParameter("ss_dep_desc") == null ? "" : request.getParameter("ss_dep_desc");
			String flag_int = request.getParameter("flag_int") == null ? "0" : request.getParameter("flag_int");
			String facility_id = (String) session.getAttribute("facility_id");

			String assess_catg_code = "";
			String current_mapTermSetDesc_disp = "";
			String abnormalCateg = "";
			String keys_disp = "";
			String mapTermSetId_disp = "";
			String mapTermCode_disp = "";
			//String flag_ss_ua_disp = "";
			String mapDesc_disp = "";
			String mapTermSetDesc_disp = "";
			String mapDiagDesc_disp = "";
			//String term_code_id = "";
			String term_set_desc = "";
			String term_code_desc = "";
			String cur_term_set_desc = "";
			String classValue = "";
			String mapValue = "";
			String current_term_code = "";  
			String keys = "";
			String mapTermSetDesc = "";
			String mapDiagDesc = "";
			String occur_srl_no = "";
			String innerTextColor = "";
			String mapDesc = "";
			String mapTermSetId = "";
			String mapTermCode = "";
			String flag_ss_ua = "";
			String current_mapTermSetDesc  = "";
			String sqlDiagnosis_ss  = "";
			String term_set_id_ss  = "";
			String term_set_desc_ss  = "";
			String term_code_ss  = "";
			String term_desc_ss  = "";
			String keys_ss  = "";
			String values_ss  = "";

			StringTokenizer abnCategToken = null;
			int count = 0;
			int i = 0;
			int k = 0;
			int i_ss = 0;
			int k_ss = 0;

			ArrayList list = new ArrayList();
			ArrayList list_ss = new ArrayList();

			StringTokenizer termCodeToken = null;
			StringTokenizer termCodeToken_disp = null;
			StringTokenizer diagToken = null;
			StringTokenizer diagToken_disp = null;

			Connection con = null;
			ResultSet resDesc = null;
			ResultSet resDesc_ss = null;
			ResultSet resDiagnosis1 = null;
			PreparedStatement psDesc = null;
			PreparedStatement pstDiagnosis_ss = null;
			PreparedStatement pstDiagnosis1 = null;
			CallableStatement cs = null;
	try{		
			try
			{
				con = ConnectionManager.getConnection(request);
				cs = con.prepareCall("{call CP_GET_ASSESS_OUTPUT(?,?,?,?,?)}" );
							
				cs.setString(1,accession_num);
				cs.setString(2,facility_id);
				cs.setString(3,note_type);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.execute();				
				abnormalCateg = cs.getString(5) == null ? "" : cs.getString(5);			


				abnCategToken = new StringTokenizer(abnormalCateg,"~");
				while(abnCategToken.hasMoreTokens())
				{
					if(assess_catg_code.equals(""))
						assess_catg_code = assess_catg_code +("'" + assess_catg_code + abnCategToken.nextToken() + "'");
					else
						assess_catg_code = assess_catg_code +("'" + assess_catg_code + abnCategToken.nextToken() + "',");
				}
			}
			catch(Exception e)
			{
				System.err.println("@@@@@@@@@@Diag"+e.toString());
				e.printStackTrace(System.err);
			}

			if(mode.equals("modify") && !flag.equals("modAuth"))
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assess_ref_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ss_dep_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

			try
			{
				//con = ConnectionManager.getConnection(request);
				String sql_diag_desc = "SELECT distinct a.term_set_id, b.TERM_SET_DESC , a.term_code, c.short_desc  diag_desc FROM mr_term_set b ,mr_term_code c,CP_PAT_ASSESS_UA_TERM_CODE  a WHERE b.term_set_id = a.term_set_id AND c.term_set_id =a.term_set_id AND c.term_code=a.term_code AND (c.term_set_id ,c.term_code) IN (SELECT term_set_id ,term_code FROM cp_pat_assess_ua_term_code WHERE assess_ref_no=?) order by b.TERM_SET_DESC";
				psDesc = con.prepareStatement(sql_diag_desc);
				psDesc.setString(1,assess_ref_no);

				
				resDesc = psDesc.executeQuery();
				while(resDesc.next())
				{
					//term_code_id = resDesc.getString(3);
					term_set_desc = resDesc.getString(2);
					term_code_desc = resDesc.getString("diag_desc");
					
					if(count%2 == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";

					if(!(term_set_desc.equals(cur_term_set_desc)))
					{
						out.println("<tr>");
						out.println("<td class='CAGROUPHEADING' colspan='2'>");
						out.println(" "+term_set_desc+" ");
						out.println("</td>");
						out.println("</tr>");								
					}							
					out.println("<tr>");
					out.println("<td class="+classValue+" >");
					out.println(" "+term_code_desc+" ");
					out.println("</td>");
					out.println("</tr>");

					cur_term_set_desc = term_set_desc;
					count++;
				}

			}
			catch(Exception e)
			{
				System.out.println("Exception in try of PatientAssessmentShowDescMain.jsp"+e.toString());
			}
			finally
			{
				if(resDesc != null) resDesc = null;
				if(psDesc != null) psDesc = null;
//				if(con != null) ConnectionManager.returnConnection(con);
			}
			
            _bw.write(_wl_block12Bytes, _wl_block12);

		}//end of if mode modify and Authorized
			PreparedStatement pstDiagnosis		 = null;
			ResultSet resDiagnosis				 = null;
		if(mode.equals("modify") && flag.equals("modAuth"))
		{
			
			String term_code = request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
			String term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");

			pstDiagnosis = null;
			resDiagnosis = null;

			String current_term_set_desc = "";
			String mapKey = "";
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);


			try
			{			
				//con = ConnectionManager.getConnection(request);
				if(flag_int.equals("0"))
				{				
					try
					{	
						sqlDiagnosis_ss = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assess_catg_code.equals("")?"''":assess_catg_code)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";
						pstDiagnosis_ss = con.prepareStatement(sqlDiagnosis_ss);
						resDesc_ss = pstDiagnosis_ss.executeQuery();
						
						while(resDesc_ss.next())
						{
							term_set_id_ss = resDesc_ss.getString(1);
							term_set_desc_ss = resDesc_ss.getString(2);
							term_code_ss = resDesc_ss.getString(3);
							term_desc_ss = resDesc_ss.getString("diag_desc");
							keys_ss = term_set_id_ss + "$" +  term_code_ss + "$" + "SS";
							values_ss = term_set_desc_ss + "~" +  term_desc_ss + "~" + term_set_id_ss;
							diagBean.addDiagnosis(keys_ss, values_ss);						
						}
						resDesc_ss.close();
						pstDiagnosis_ss.close();

						i_ss = diagBean.getSize();
						list_ss = diagBean.getKeySet();
						for(k_ss=0;k_ss<i_ss;k_ss++)
						{
							keys_disp = (String) list_ss.get(k_ss);
							termCodeToken_disp = new StringTokenizer(keys_disp,"$");
							mapTermSetId_disp = termCodeToken_disp.nextToken();
							mapTermCode_disp = termCodeToken_disp.nextToken();
							//flag_ss_ua_disp = termCodeToken_disp.nextToken();

							mapDesc_disp = diagBean.getDiagRecords(keys_disp);
							diagToken_disp = new StringTokenizer(mapDesc_disp,"~");

							mapTermSetDesc_disp = diagToken_disp.nextToken();
							mapDiagDesc_disp = diagToken_disp.nextToken();

							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							innerTextColor = "marroon";

							if(!(mapTermSetDesc_disp.equals(current_mapTermSetDesc_disp)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc_disp+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId_disp+"\",\""+mapTermCode_disp+"\",\""+mapDiagDesc_disp+"\")'>");
							out.println(" "+mapDiagDesc_disp+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc_disp = mapTermSetDesc_disp;
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@@4 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
				else if(flag_int.equals("1"))
				{
					try
					{
						String sqlDiagnosis = "SELECT b.term_set_id, b.TERM_SET_DESC, c.term_code, c.short_desc  diag_desc FROM mr_term_set b, mr_term_code c WHERE b.term_set_id  = ? AND term_code = ? AND b.term_set_id = c.term_set_id";
						pstDiagnosis = con.prepareStatement(sqlDiagnosis);
						pstDiagnosis.setString(1,term_set_id);
						pstDiagnosis.setString(2,term_code);
						mapKey = term_set_id + "$" + term_code + "$" + "UA";
						resDiagnosis = pstDiagnosis.executeQuery();
						//out.println("<script>");
						while(resDiagnosis.next())
						{
							current_term_set_desc = resDiagnosis.getString(2);
							term_code_desc = resDiagnosis.getString("diag_desc");
							mapValue = current_term_set_desc + "~" + term_code_desc + "~" + term_set_id;

							if((diagBean.checkForDups(mapValue)))
							{
								ArrayList list_temp = new ArrayList();
								list_temp = diagBean.getKeySet();
								int list_size = list_temp.size();
								int temp = 0;
								StringTokenizer tempToken = null;
								String tempKeys = "";
								String tempTermCode = "";

								for(temp=0; temp<list_size;temp++)
								{
									tempKeys = (String) list_temp.get(temp);
									tempToken = new StringTokenizer(tempKeys,"$");
									tempTermCode = tempToken.nextToken();
									
									if(term_code.equals(tempTermCode)) 
									{
										current_term_code = "true";
										break;
									}
								}
								if(!current_term_code.equals("true"))
								{
									diagBean.addDiagnosis(mapKey,mapValue);
								}									
							}
							else
							{									
								diagBean.addDiagnosis(mapKey, mapValue);									
							}
						}//end of while

						resDiagnosis.close();
						pstDiagnosis.close();

						i = diagBean.getSize();
						list = diagBean.getKeySet();
						for(k=0;k<i;k++)
						{
							keys = (String) list.get(k);
							termCodeToken = new StringTokenizer(keys,"$");
							mapTermSetId = termCodeToken.nextToken();
							mapTermCode = termCodeToken.nextToken();
							flag_ss_ua = termCodeToken.nextToken();
							
							if(flag_ss_ua.equals("SS"))
							{
								innerTextColor = "marroon";
							}
							else
							{
								innerTextColor = "";
							}
							
							mapDesc = diagBean.getDiagRecords(keys);
							diagToken = new StringTokenizer(mapDesc,"~");

							mapTermSetDesc = diagToken.nextToken();
							mapDiagDesc = diagToken.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							if(!(mapTermSetDesc.equals(current_mapTermSetDesc)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId+"\",\""+mapTermCode+"\",\""+mapDiagDesc+"\")'>");
							out.println(" "+mapDiagDesc+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc = mapTermSetDesc;
						}//end of for
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@@6 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
			}//end of try
			catch(Exception e)
			{
				System.out.println("Exception in try-modify-flag-true of PatientAssessmentDiagnosis.jsp"+e.toString());
				e.printStackTrace(System.err);
			}
			
            _bw.write(_wl_block17Bytes, _wl_block17);

		}//end of modify NOT Authorized	
		
		if(!mode.equals("modify") && status_flag.equals("4"))
		{
			String term_code = request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
			String term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");

/*			PreparedStatement pstDiagnosis = null;
			ResultSet resDiagnosis = null;*/

			String current_term_set_desc = "";
			String mapKey = "";
			
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);


			try
			{
				//con = ConnectionManager.getConnection(request);
				if(flag_int.equals("0"))
				{					
					//out.println("here 2");
					try
					{
//						con = ConnectionManager.getConnection(request);

						sqlDiagnosis_ss = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assess_catg_code.equals("")?"''":assess_catg_code)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";
						pstDiagnosis_ss = con.prepareStatement(sqlDiagnosis_ss);
						resDesc_ss = pstDiagnosis_ss.executeQuery();

						while(resDesc_ss.next())
						{
							term_set_id_ss = resDesc_ss.getString(1);
							term_set_desc_ss = resDesc_ss.getString(2);
							term_code_ss = resDesc_ss.getString(3);
							term_desc_ss = resDesc_ss.getString("diag_desc");
							keys_ss = term_set_id_ss + "$" +  term_code_ss + "$" +"SS";
							values_ss = term_set_desc_ss + "~" +  term_desc_ss + "~" + term_set_id_ss;
							diagBean.addDiagnosis(keys_ss, values_ss);
						}

						resDesc_ss.close();
						pstDiagnosis_ss.close();

						i_ss = diagBean.getSize();
						list_ss = diagBean.getKeySet();

						for(k_ss=0;k_ss<i_ss;k_ss++)
						{
							keys_disp = (String) list_ss.get(k_ss);
							termCodeToken_disp = new StringTokenizer(keys_disp,"$");
							mapTermSetId_disp = termCodeToken_disp.nextToken();
							mapTermCode_disp = termCodeToken_disp.nextToken();
							//flag_ss_ua_disp = termCodeToken_disp.nextToken();

							mapDesc_disp = diagBean.getDiagRecords(keys_disp);
							diagToken_disp = new StringTokenizer(mapDesc_disp,"~");

							mapTermSetDesc_disp = diagToken_disp.nextToken();
							mapDiagDesc_disp = diagToken_disp.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							innerTextColor = "marroon";

							if(!(mapTermSetDesc_disp.equals(current_mapTermSetDesc_disp)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc_disp+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId_disp+"\",\""+mapTermCode_disp+"\",\""+mapDiagDesc_disp+"\")'>");
							out.println(" "+mapDiagDesc_disp+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc_disp = mapTermSetDesc_disp;
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@2 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
				else if(flag_int.equals("1"))
				{				
					try
					{
						//con = ConnectionManager.getConnection(request);
						String sqlDiagnosis = "SELECT b.term_set_id, b.TERM_SET_DESC, c.term_code, c.short_desc  diag_desc FROM mr_term_set b, mr_term_code c WHERE b.term_set_id  = ? AND term_code = ? AND b.term_set_id = c.term_set_id";

						pstDiagnosis = con.prepareStatement(sqlDiagnosis);
						pstDiagnosis.setString(1,term_set_id);
						pstDiagnosis.setString(2,term_code);
						mapKey = term_set_id + "$" + term_code + "$" + "UA";
						resDiagnosis = pstDiagnosis.executeQuery();

						//out.println("<script>");
						while(resDiagnosis.next())
						{
							current_term_set_desc = resDiagnosis.getString(2);
							term_code_desc = resDiagnosis.getString("diag_desc");
							mapValue = current_term_set_desc + "~" + term_code_desc + "~" + term_set_id;

							if((diagBean.checkForDups(mapValue)))
							{
								ArrayList list_temp = new ArrayList();
								list_temp = diagBean.getKeySet();
								int list_size = list_temp.size();
								int temp = 0;
								StringTokenizer tempToken = null;
								String tempKeys = "";
								String tempTermCode = "";

								for(temp=0; temp<list_size;temp++)
								{
									tempKeys = (String) list_temp.get(temp);
									tempToken = new StringTokenizer(tempKeys,"$");
									tempTermCode = tempToken.nextToken();
									
									if(term_code.equals(tempTermCode)) 
									{
										current_term_code = "true";
										break;
									}
								}
								if(!current_term_code.equals("true"))
								{
									diagBean.addDiagnosis(mapKey,mapValue);
								}									
							}
							else
							{									
								diagBean.addDiagnosis(mapKey, mapValue);									
							}
						}//end of while

						resDiagnosis.close();
						pstDiagnosis.close();

						i = diagBean.getSize();
						list = diagBean.getKeySet();
						for(k=0;k<i;k++)
						{
							keys = (String) list.get(k);
							termCodeToken = new StringTokenizer(keys,"$");
							mapTermSetId = termCodeToken.nextToken();
							mapTermCode = termCodeToken.nextToken();
							flag_ss_ua = termCodeToken.nextToken();

							if(flag_ss_ua.equals("SS"))
							{
								innerTextColor = "marroon";
							}
							else
							{
								innerTextColor = "";
							}
							
							mapDesc = diagBean.getDiagRecords(keys);
							diagToken = new StringTokenizer(mapDesc,"~");

							mapTermSetDesc = diagToken.nextToken();
							mapDiagDesc = diagToken.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							if(!(mapTermSetDesc.equals(current_mapTermSetDesc)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId+"\",\""+mapTermCode+"\",\""+mapDiagDesc+"\")'>");
							out.println(" "+mapDiagDesc+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc = mapTermSetDesc;
						}//end of for
					}
					catch(Exception e)
					{						
						System.out.println("Exception in try@@@@@@@@3 of PatientAssessmentDiagnosis.jsp"+e.toString());
					}
				}
			}//end of try
			catch(Exception e)
			{
				out.println("Exception in try of PatientAssessmentDiagnosis.jsp"+e.toString());
				e.printStackTrace(System.err);
			}
		}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);

	}
		catch(Exception ex)
		{
			out.println("Exception @ last try "+ex.toString());
		}
		finally
		{
			if(resDesc != null) resDesc.close();
			if(resDesc_ss != null) resDesc_ss.close();
			if(resDiagnosis1 != null) resDiagnosis1.close();
			if(psDesc != null) psDesc.close();
			if(pstDiagnosis_ss != null) pstDiagnosis_ss.close();
			if(pstDiagnosis1 != null) pstDiagnosis1.close();
			if(cs != null) cs.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.PatientAssessmentDiagnosis.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
