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

public final class __clinicalstudiespatientlisthistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalStudiesPatientListHistResult.jsp", 1736959795158L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History\tName        \tDescription\n--------------------------------------------------------------------------------------------------------------\n?             \t100            \t?           \tcreated\n02/01/2013\t\tIN037059\t\tRamesh G\t\tClinical Studies Patient List-> For the Practitioner even after the Access is given in \n\t\t\t\t\t\t\t\t\t\t\t\t?Access Rights for Research Studies? no Records are displayed\n03/01/2013\t\tIN037111\t\tRamesh G\t\tClinical Studies Patient List  ->When we Click on Patient ID Hyperlink the Practitioner Desktop opens instead of Patient Chart\n--------------------------------------------------------------------------------------------------------------- \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML><head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n</head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/ClinicalStudiesPatientListHist.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'90%\' class=\'white\' ></td>\n\t\t\t\t\t<td width=\'10%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t<table  width=\"100%\" class=\'grid\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>Recorded Practitioner</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>Active Diagnosis</td>\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t</tr>\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t</table>\t \n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<form name=\"chartForm\" id=\"chartForm\" action=\"OpenChartWrapper.jsp\">\n\t <input type=\"hidden\" name=\'insert_op\' id=\'insert_op\' value= \'N\'>\n\t <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value= \'\'>\n\t <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value= \'\'>\n\t <input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value= \'\'>\n\t <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value= \'\'>  <!-- IN037111 -->\n\t <input type=\'hidden\' name=\'called_function_id\' id=\'called_function_id\' value= \'REL_PAT_TREAT\'> \n</form>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


out.println("<BODY  class='CONTENT' onLoad=\"parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';\" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	StringBuffer sql = new StringBuffer();
	StringBuffer sql1 = new StringBuffer();
	StringBuffer sql2 = new StringBuffer();
	String sqlbuild="";
	String orderby="";
   
	String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	String	patientId 	= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	
	String from 					= request.getParameter("from") ;
	String to 						= request.getParameter("to") ;

	String view			= (request.getParameter("view")==null)?"":request.getParameter("view");
    String spl			= (request.getParameter("spl")==null)?"":request.getParameter("spl");
	String rest			= (request.getParameter("rest")==null)?"":request.getParameter("rest");
	String from_date	= (request.getParameter("from_date")==null)?"":request.getParameter("from_date");
	String to_date		= (request.getParameter("to_date")==null)?"":request.getParameter("to_date");
	
	from_date			=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	
	String diag1		= request.getParameter("diag");
	String diagnew1  = "";
	if (!diag1.equals("")) 
		diagnew1  =diag1.substring(0,diag1.indexOf("-"));
	
	String diag2		= request.getParameter("diag2");
		if (diag2==null)  diag2="";
	String diagnew2  = "";
	
	if (!diag2.equals(""))  
		diagnew2=diag2.substring(0,diag2.indexOf("-"));

	String diag3		= request.getParameter("diag3");
	if (diag3==null)  diag3="";
	
	String diagnew3  = "";
	
	if (!diag3.equals(""))  
	diagnew3=diag3.substring(0,diag3.indexOf("-"));
	String b_year		= request.getParameter("b_year")==null?"":request.getParameter("b_year");
	String b_months     = request.getParameter("b_months")==null?"":request.getParameter("b_months");
	String b_days		= request.getParameter("b_days")==null?"":request.getParameter("b_days");
	String b_year2		= request.getParameter("b_year2")==null?"":request.getParameter("b_year2");
	String b_months2    = request.getParameter("b_months2")==null?"":request.getParameter("b_months2");
	String b_days2      = request.getParameter("b_days2")==null?"":request.getParameter("b_days2");
 	String sex		    = request.getParameter("sex")==null?"": request.getParameter("sex");
 	String status		= request.getParameter("status")==null?"":request.getParameter("status");
 	String group		= request.getParameter("group")==null?"":request.getParameter("group");
 	String term_set_id		= request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String resePatcategory	=  request.getParameter("resePatcategory")==null?"":request.getParameter("resePatcategory");
	String reseCategoryFact =  request.getParameter("reseCategoryFact")==null?"":request.getParameter("reseCategoryFact");
	String fr_age="",to_age="";
	sql1.append(" SELECT COUNT(*) as total ");
	
	sql2.append("SELECT A.PATIENT_ID, b.PATIENT_NAME , C.PRACTITIONER_NAME,D.RESEARCH_CATEG_DESC,E.RESEARCH_CATEG_FACT_DESC,A.REMARKS,B.CURR_PATIENT_CLASS,TO_CHAR (A.ADDED_DATE, 'dd/mm/yyyy hh24:mi:ss') ADDED_DATE,");
	sql2.append("(SELECT COUNT(*) FROM MR_TERM_CODE_LANG_VW MTC,PR_DIAGNOSIS PD WHERE MTC.TERM_CODE=PD.TERM_CODE AND PD.PATIENT_ID=A.PATIENT_ID ");
	if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
		sql2.append("AND MTC.TERM_CODE IN(");
		int i=0;
		if (!diagnew1.equals("")){
			sql2.append("'"+diagnew1+"'");
			i++;
		}  
		if (!diagnew2.equals("")){
			if(i>0)
				sql2.append(",");
			sql2.append("'"+diagnew2+"'");
			i++;
	    }
		if (!diagnew3.equals("")){
		 if(i>0)
				sql2.append(",");
			sql2.append("'"+diagnew3+"'");
			i++;
		}		
		sql2.append(")");	
	}
	if(!term_set_id.equals("")){
	sql2.append("AND MTC.TERM_SET_ID='"+term_set_id+"'");
	}
	sql2.append(" AND MTC.LANGUAGE_ID='"+locale+"')ACTIVDIAG");
	
	String whereClause				= request.getParameter("whereclause");
			 
	if ( (whereClause == null || whereClause.equals("")) )
	{	
		sql.append("  FROM CA_RESEARCH_PATIENT_DETAIL A,MP_PATIENT B,AM_PRACTITIONER C,CA_RESEARCH_CATEGORY D,CA_RESEARCH_CATEGORY_FACT E,SM_APPL_USER F WHERE ");
		sql.append(" A.PATIENT_ID=B.PATIENT_ID");
		sql.append(" AND A.ADDED_BY_ID=F.APPL_USER_ID");
		sql.append(" AND F.FUNC_ROLE_ID=C.PRACTITIONER_ID");
		sql.append(" AND A.RESEARCH_CATEG_ID=D.RESEARCH_CATEG_ID");
		sql.append(" AND A.RESEARCH_CATEG_FACT_ID=E.RESEARCH_CATEG_FACT_ID (+)");
		if("S".equals(view)){
			sql.append("AND A.ADDED_BY_ID='"+practitioner_id+"' ");
		}
		sql.append(" AND A.ADDED_FACILITY_ID='"+rest+"' ");
		sql.append(" AND A.ADDED_DATE >= TO_DATE ('"+from_date+"', 'dd/mm/yyyy') ");
		// IN037059 Start.
		//sql.append(" AND A.ADDED_DATE <= TO_DATE ('"+to_date+"', 'dd/mm/yyyy') ");
		sql.append(" AND A.ADDED_DATE <= TO_DATE ('"+to_date+"', 'dd/mm/yyyy')+.99 ");
		//IN037059 End.
		sql.append(" AND A.RESEARCH_CATEG_ID ='"+resePatcategory+"'");
		sql.append(" AND A.RESEARCH_CATEG_FACT_ID='"+reseCategoryFact+"'");
		if(!spl.equals("")){
		sql.append(" AND A.PATIENT_ID IN (select distinct PATIENT_ID from pr_encounter where  SPECIALTY_CODE = '"+spl+"')");
		}
		if(!sex.equals("")){
			sql.append(" AND b.sex = '"+sex+"'");
		}
		if("O".equals(status)){
			sql.append(" AND A.CLOSE_DATE IS NULL");
		}else if("C".equals(status)){
			sql.append(" AND A.CLOSE_DATE IS NOT NULL");
		}
		if(!term_set_id.equals("")|| !diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
			sql.append(" AND A.PATIENT_ID IN (SELECT DISTINCT PATIENT_ID FROM PR_DIAGNOSIS WHERE ");
			int j=0;
			if(!term_set_id.equals("")){
				j++;
				sql.append(" TERM_SET_ID='"+term_set_id+"'");
			}
			if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
					if(j==0){
						sql.append(" TERM_CODE IN (");
					}else{
						sql.append(" AND TERM_CODE IN (");
					}
					int i=0;
					if (!diagnew1.equals("")){
						sql.append("'"+diagnew1+"'");
						i++;
					}  
					if (!diagnew2.equals("")){
						if(i>0)
							sql.append(",");
						sql.append("'"+diagnew2+"'");
						i++;
					}
					if (!diagnew3.equals("")){
					 if(i>0)
							sql.append(",");
						sql.append("'"+diagnew3+"'");
						i++;
					}		
					sql.append(")");	
			}
			sql.append(")");
		}
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals(""))){  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			sql.append(" AND SYSDATE- B.DATE_OF_BIRTH>"+fr_age+" ");
		}
		
		if ((!b_year2.equals("")) ||(!b_months2.equals(""))||(!b_days2.equals("")))
		{  
			if (b_year2.equals(""))
			  b_year2="0";
			else
			   b_year2="("+b_year2+"+1)";
			if (b_months2.equals(""))
			  b_months2="0";
			else
			   b_months2="("+b_months2+"+1)";
			if	(b_days2.equals(""))
			  b_days2="0";
			else
			   b_days2="("+b_days2+"+1)";
			to_age="("+b_year2+"*365+"+b_months2+"*30+"+b_days2+")";
			 
			 sql.append(" AND SYSDATE- B.DATE_OF_BIRTH<="+to_age+" " );
		}
		if("3".equals(group)){
			sql.append(" ORDER BY UPPER(PRACTITIONER_NAME) ASC");
		}else if("4".equals(group)){
			sql.append(" ORDER BY UPPER(RESEARCH_CATEG_DESC) ASC");
		}
		sqlbuild = sql.toString();
	}else
		sqlbuild=whereClause;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 7 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try
	{
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql1.toString()+sqlbuild);
		rs = pstmt.executeQuery();

		while(rs!=null && rs.next()){
		  maxRecord = rs.getInt("total");
        }
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	  
		if (maxRecord== 0)
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else			
		{   
			
			pstmt = con.prepareStatement(sql2.toString()+sqlbuild);		  
			rs = pstmt.executeQuery();
		
            _bw.write(_wl_block9Bytes, _wl_block9);

						if ( !(start <= 1) )
							out.println("<A HREF='../../eCA/jsp/ClinicalStudiesPatientListHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&term_set_id="+term_set_id+"&diag3="+diag3+"&group="+group+"&patient_id="+patientId+"&from="+(start-7)+"&to="+(end-7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

						if ( !( (start+7) > maxRecord ) ){
							out.println("<A HREF='../../eCA/jsp/ClinicalStudiesPatientListHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&diag3="+diag3+"&term_set_id="+term_set_id+"&group="+group+"&patient_id="+patientId+"&from="+(start+7)+"&to="+(end+7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						}
				
					
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){ rs.next() ; }

			while ( rs!=null && rs.next() && i<=end ){
				String patid = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				String patname = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");			
				String practName = (rs.getString("PRACTITIONER_NAME")==null)?"":rs.getString("PRACTITIONER_NAME");
				String reseCateDesc = (rs.getString("RESEARCH_CATEG_DESC")==null)?"":rs.getString("RESEARCH_CATEG_DESC");
				String reseCateFactDesc = (rs.getString("RESEARCH_CATEG_FACT_DESC")==null)?"":rs.getString("RESEARCH_CATEG_FACT_DESC");			
				int activeDiag = 0;
					activeDiag =rs.getInt("ACTIVDIAG");
				String details = (rs.getString("REMARKS")==null)?"":rs.getString("REMARKS");
				String addedDate = rs.getString("ADDED_DATE");
				String eid = ""; //(rs.getString("EID")==null)?"":rs.getString("EID");
				 String patclass= rs.getString("CURR_PATIENT_CLASS")==null?"":rs.getString("CURR_PATIENT_CLASS");
				
				out.println("<tr><td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:openHistory('"+patid+"','"+patclass+"' )\" class='gridLink'>"+patid+"</a></td>");
				out.println("<td nowrap align=left  class='gridLink'>"+patname+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+practName+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+reseCateDesc+"</td>");
				out.println("<td nowrap align=left  class='gridLink'>"+reseCateFactDesc+"</td>");
				if(activeDiag>0)
					out.println("<td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:showActiveDignosisDetails('"+patid+"','"+rest+"','"+locale+"','"+term_set_id+"','"+diagnew1+"','"+diagnew2+"','"+diagnew3+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");
				else
					out.println("<td nowrap align=left  class='gridLink'>&nbsp;</td>");
				if(!"".equals(details))
					out.println("<td nowrap align=left  class='gridLink'><font size=2><a href=\"javascript:showDetails('"+patid+"','"+rest+"','"+resePatcategory+"','"+reseCategoryFact+"','"+addedDate+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");
				else
					out.println("<td nowrap align=left  class='gridLink'>&nbsp;</td>");
				out.println("</tr>");
				i++;
			}
		}
		 
            _bw.write(_wl_block16Bytes, _wl_block16);


	}catch(Exception e){
		e.printStackTrace();
		e.toString();
		//out.println(e.toString());//COMMON-ICN-0181
	}
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResearchCategory.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResearchCategoryFactor.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
