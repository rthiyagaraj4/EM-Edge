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
import eCA.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __relatedpatienthistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RelatedPatientHistResult.jsp", 1709116244527L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="<!-- 32902 -->\n\n\n<HTML><head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n</head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RelatedPatientHist.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- 32902 -->\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t  \t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\n\t\t</script>\n\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!--<p>-->\n<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n<tr>\n<td width=\'90%\' class=\'white\' ></td>\n<td width=\'10%\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<!--</p> \n<br><br> -->\n<table  width=\"100%\" class=\'grid\'>\n<td class=\'columnheader\' width=\'3%\' nowrap>&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<td class=\'columnheader\' width=\'10%\'  nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<td class=\'columnheader\' width=\'20%\'  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<td class=\'columnheader\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n<td class=\'columnheader\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\n\n<td class=\'columnheader\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td class=\'columnheader\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<td class=\'columnheader\' width=\'10%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\n<td class=\'columnheader\' width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t <input type=\'hidden\' id=\'patid";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' name=\'patid";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t \t <input type=\'hidden\' id=\'accessRightsViewPatient\' name=\'accessRightsViewPatient\' id=\'accessRightsViewPatient\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\t \n\t \t <input type=\'hidden\' id=\'restPatientYN";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' name=\'restPatientYN";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\t \n\t \t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</td></tr>\n</table>\n\t \n<br><center>\n</center>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n<form name=\"chartForm\" id=\"chartForm\" action=\"OpenChartWrapper.jsp\">\n\t <input type=\"hidden\" name=\'insert_op\' id=\'insert_op\' value= \'N\'>\n\t <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value= \'\'>\n\t <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value= \'\'>\n\t <input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value= \'\'>\n\t <input type=\'hidden\' name=\'called_function_id\' id=\'called_function_id\' value= \'REL_PAT_TREAT\'> \n</form>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

04/05/2015  IN053425		NijithaS										ML-BRU-SCF-1544  
09/06/2015  IN055539		NijithaS										System displays wrong records when status is Alive.
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

----------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

//oracle.jdbc.driver.*,
	request.setCharacterEncoding("UTF-8");
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
	//IN053425 Starts
	String diagnew1 = "";
	if (!diag1.equals("")) 
	    diagnew1  = diag1.substring(0,diag1.indexOf("-"));
	//IN053425 Ends
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
	String otherDiagYN		= request.getParameter("otherdiag")==null?"N":request.getParameter("otherdiag");//IN053425
	//32902 start
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=bean1.getAccessRightsViewPatient(practitioner_id,facilityId);	
	 //32902 end


	String fr_age="",to_age="";
	String whereClause				= request.getParameter("whereclause");
			 
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(view.equals("S"))
			sqlbuild=sqlbuild+" and exists(select 1 from ca_encntr_pract_reln where FACILITY_ID=a.onset_facility_id and ENCOUNTER_ID=a.onset_encounter_id and PRACTITIONER_ID='"+practitioner_id+"')";

	    if( !(spl == null || spl.equals("")) )
			sqlbuild=sqlbuild+" and c.SPECIALTY_CODE='"+spl+"' ";
	
		if(rest.equals("F") || rest.equals("E"))
			sqlbuild=sqlbuild+" and c.facility_id='"+facilityId+"' ";

		if( !(from_date == null || from_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME>=to_date('"+from_date+"' ,'dd/mm/yyyy')";
	
		if( !(to_date == null || to_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME<=to_date('"+to_date+"' ,'dd/mm/yyyy')+.99 ";

		if(!(sex == null || sex.equals("")))
			sqlbuild=sqlbuild+" and b.sex='"+sex+"'";

		if(status.equals("D"))
			sqlbuild=sqlbuild+" and EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='Y' AND  disp_type=C.DISPOSITION_TYPE) ";
		else if(status.equals("A"))//IN055539
			sqlbuild=sqlbuild+" and (C.DISPOSITION_TYPE is null or EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='N' AND  disp_type= nvl(C.DISPOSITION_TYPE,'xxx'))) ";
    
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals("")))
		{  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth>"+fr_age+" ";
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
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth<="+to_age+" ";
		}
	}
	else
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
	  
   //   out.println("<script>alert('Quest')</script>");
//     out.println("<script>alert('"+group+"')</script>");

	  sql.append("SELECT COUNT(*) as total FROM PR_DIAGNOSIS A,MP_PATIENT B,PR_ENCOUNTER C WHERE B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID  AND TERM_SET_ID=?  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') ) */ and a.TERM_CODE in ('"+diagnew1+"' ");
		
	  if (!diagnew2.equals(""))
		  sql.append(",'"+diagnew2+"'");
	  
	  if (!diagnew3.equals(""))
		  sql.append(",'"+diagnew3+"'");
	  //IN053425 Starts
	  if(otherDiagYN.equals("Y"))
		  sql.append(",'*OTH'");
	  //IN053425 Ends
	 
	  sql.append(") ");

	  if (!patientId.equals("")){
		  //sql.append(" and a.patient_id!='"+patientId+"' ");//common-icn-0180
		  sql.append(" and a.patient_id!= ? ");//common-icn-0180
	  }	  
	  sql.append(sqlbuild);

	  sql.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,b.patient_id,c.facility_id)");//32902

	  int pstmtcount =1;//common-icn-0180
	  pstmt = con.prepareStatement(sql.toString());
	  
	  //pstmt.setString(1,term_set_id);//common-icn-0180
	  //pstmt.setString(2,practitioner_id);//32902//common-icn-0180
	  //common-icn-0180 starts
	  pstmt.setString(pstmtcount++,term_set_id);
	  if (!patientId.equals("")){
	  pstmt.setString(pstmtcount++,patientId);
	  }
	  pstmt.setString(pstmtcount++,practitioner_id);
	//common-icn-0180 ends

      rs = pstmt.executeQuery();

	 while(rs!=null && rs.next())
		{
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
 
    if(group.equals("1"))
    orderby=orderby+" ORDER BY 1";
	else if(group.equals("4"))
    orderby=orderby+" ORDER BY 4";
	else if(group.equals("8"))
    orderby=orderby+" ORDER BY 8";
	else
    orderby=orderby+" ORDER BY 1";  
     StringBuffer sqlnew	= new StringBuffer();
		
	// sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode('"+locale+"','en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID='"+locale+"') PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"') 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"' )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID='"+locale+"') PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID='"+locale+"' ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902
           //sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode('"+locale+"','en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID='"+locale+"') PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"') 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID='"+locale+"' )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID='"+locale+"') PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID='"+locale+"' ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility,b.restrict_reinstate_yn FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902
           sqlnew.append("SELECT distinct D.SHORT_DESC DIAG_DESC  ,A.TERM_CODE DIAG_CODE  ,A.PATIENT_ID  ,replace(decode(?,'en',PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''','')  PATIENT_NAME ,c.patient_class ,(SELECT SHORT_DESC  FROM AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS=C.PATIENT_CLASS 	AND LANGUAGE_ID= ?) PATIENT_CLASS_DESC  ,CASE WHEN PATIENT_CLASS IN ('EM','OP') then 	(SELECT SHORT_DESC FROM OP_CLINIC_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID   	 AND   CLINIC_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID= ?) 	WHEN PATIENT_CLASS IN ('IP','DC') then 	(SELECT SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW 	 WHERE FACILITY_ID=C.FACILITY_ID 	 AND   NURSING_UNIT_CODE=C.ASSIGN_CARE_LOCN_CODE 	AND LANGUAGE_ID= ? )   END LOCN_DESC  ,(SELECT SHORT_NAME FROM AM_PRACTITIONER_LANG_VW    WHERE PRACTITIONER_ID=C.ATTEND_PRACTITIONER_ID AND LANGUAGE_ID= ?) PRACT_NAME  ,(SELECT SHORT_DESC||DECODE(DECEASED_YN,'Y','/(Deceased)') FROM AM_DISPOSITION_TYPE_LANG_VW    WHERE DISP_TYPE=C.DISPOSITION_TYPE   AND LANGUAGE_ID= ? ) DISPOSITION_TYPE_DESC  ,(SELECT COUNT(*) FROM pr_diagnosis_ENC_DTL    WHERE PATIENT_ID=A.PATIENT_ID    AND TERM_SET_ID =A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO) ENC_COUNT,C.ENCOUNTER_ID EID,C.FACILITY_ID FID,A.OCCUR_SRL_NO SRLNO,c.facility_id Facility,b.restrict_reinstate_yn FROM  PR_DIAGNOSIS A ,MP_PATIENT B ,PR_ENCOUNTER C ,MR_TERM_CODE D WHERE     B.PATIENT_ID=A.PATIENT_ID AND C.FACILITY_ID=A.ONSET_FACILITY_ID AND C.ENCOUNTER_ID=A.ONSET_ENCOUNTER_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE  /*and (c.visit_status In ('09','08','07') or adt_status in ('07','08','09') )*/ AND A.TERM_SET_ID=? and a.TERM_CODE in ('"+diagnew1+"' ");//32902

	  if (!diagnew2.equals(""))
		  sqlnew.append(",'"+diagnew2+"'");
	  
	  if (!diagnew3.equals(""))
		  sqlnew.append(",'"+diagnew3+"'");
	  //IN053425 Starts	 
	  if(otherDiagYN.equals("Y"))
		  sqlnew.append(",'*OTH'");
	  //IN053425 Ends
	  sqlnew.append(") ");
	  if (!patientId.equals("")){
		  //sqlnew.append(" and a.patient_id!='"+patientId+"' ");//common-icn-0180
		  sqlnew.append(" and a.patient_id!= ? ");//common-icn-0180
	  
	  }
	  sqlnew.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,b.patient_id,c.facility_id)");//32902

	  sqlnew.append(sqlbuild+orderby);
      
      int pstmtcount1 = 1;//common-icn-0180
      pstmt = con.prepareStatement(sqlnew.toString());
	 // pstmt.setString(1,term_set_id);//common-icn-0180
	 // pstmt.setString(2,practitioner_id);//32902//common-icn-0180

	  //common-icn-0180 starts
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,locale);
	  pstmt.setString(pstmtcount1++,term_set_id);
	  if (!patientId.equals("")){
	  pstmt.setString(pstmtcount1++,patientId);
	  }
	  pstmt.setString(pstmtcount1++,practitioner_id);
	  
	//common-icn-0180 ends
	  
	  rs = pstmt.executeQuery();
     


            _bw.write(_wl_block9Bytes, _wl_block9);

if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/RelatedPatientHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&term_set_id="+term_set_id+"&diag3="+diag3+"&otherdiag="+otherDiagYN+"&group="+group+"&patient_id="+patientId+"&from="+(start-7)+"&to="+(end-7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");//IN053425 added otherDiagYN

  if ( !( (start+7) > maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RelatedPatientHistResult.jsp?diag="+diag1+"&diag2="+diag2+"&diag3="+diag3+"&otherdiag="+otherDiagYN+"&term_set_id="+term_set_id+"&group="+group+"&patient_id="+patientId+"&from="+(start+7)+"&to="+(end+7)+"&whereclause="+URLEncoder.encode(sqlbuild)+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");//IN053425 added otherDiagYN
	}
	

            _bw.write(_wl_block10Bytes, _wl_block10);

	if(!(group.equals("1")))
	 {

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 }
            _bw.write(_wl_block2Bytes, _wl_block2);

	if(!(group.equals("4")))
	 {

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(!(group.equals("8")))
	 {

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
// String classValue = "" ;
 String prev="";
 String prevpat="";
 String prevdtype="";
 //String cur="";

 while ( rs!=null && rs.next() && i<=end )
 {
	 	 
	/* if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;*/

     String diagdesc = (rs.getString("DIAG_DESC")==null)?"":rs.getString("DIAG_DESC");
	 String diagcode = (rs.getString("DIAG_CODE")==null)?"":rs.getString("DIAG_CODE");
	 String patid = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
	 String patname = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");
	 String distype = (rs.getString("DISPOSITION_TYPE_DESC")==null)?"&nbsp;":rs.getString("DISPOSITION_TYPE_DESC");
	 String enccount = (rs.getString("ENC_COUNT")==null)?"":rs.getString("ENC_COUNT");
	// String fid = (rs.getString("FID")==null)?"":rs.getString("FID");
	 String eid = (rs.getString("EID")==null)?"":rs.getString("EID");
	 String srlno = (rs.getString("SRLNO")==null)?"":rs.getString("SRLNO");
	 String faci = (rs.getString("Facility")==null)?"":rs.getString("Facility");
	 String patclass_desc= rs.getString("PATIENT_CLASS_DESC")==null?"":rs.getString("PATIENT_CLASS_DESC");
	 String patclass= rs.getString("patient_class")==null?"":rs.getString("patient_class");
	 String restPatientYN= rs.getString("restrict_reinstate_yn")==null?"":rs.getString("restrict_reinstate_yn");//kp

     
    if(!(diagcode.equals(prev)))
	 {
	if((group.equals("1")))
	 {
	out.println("<tr><td nowrap  class='CAHIGHERLEVELCOLOR' align=left colspan='8' ><font  size=2>"+diagcode+"/");
    out.println(diagdesc+"</font></td></tr>"); 
	 }
	 }

	 if(!(patid.equals(prevpat)))
	 {
	if((group.equals("4")))
	 {
	out.println("<tr><td nowrap align=left colspan='2' class='gridLink'><font size=2><a href=\"javascript:openHistory('"+eid+"','"+patclass+"' )\" class='gridLink'>"+patid+"</a></td>");
    out.println("<td class='' colspan='6'>"+patname+"</font></td></tr>"); 
	 }
	 }
  //  out.println("<script>alert('distype"+distype+"');</script>");
//	out.println("<script>alert('prevdtype"+prevdtype+"');</script>");
//	out.println("<script>alert('group"+group+"');</script>");
	 if(!(distype.equals(prevdtype)))
	 {
	if((group.equals("8")))
	 {
	out.println("<tr><td nowrap align=left colspan='9' class='CAHIGHERLEVELCOLOR'><font  size=2>"+distype+"</td></font></tr>");
    
	 }
	 }
   
	 
    if(Integer.parseInt(enccount) > 1)
	 {
    out.println("<tr><td nowrap class='gridData'><a href=\"javascript:showEncounterDeatils('"+patid+"','"+srlno+"','"+diagcode+"', '"+term_set_id+"')\" class='gridLink'>&nbsp;&nbsp;+&nbsp;&nbsp;</a>");
	 }
	 else
	 {
	 out.println("<tr><td nowrap class='gridData'>&nbsp;");
	 }
	out.println("</td><td nowrap class='gridData'>");
	
	
	
	/*out.println("<a href='../../eCA/jsp/x.jsp?clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"' target='f_query_add_mod' >"); */

	
	
	
	if(!(group.equals("1")))
	 {
	out.println(diagcode+"</td><td nowrap class='gridData'>");
    out.println(diagdesc+"</td><td nowrap class='gridData'>"); 
	 }

	
	if(!(group.equals("4")))
	 {
	//out.println("<a href=\"javascript:openHistory('"+eid+"','"+patclass+"')\" class='gridLink'>"+patid+"</a></td><td  class='gridData'> ");//32902
      out.println("<a href=\"javascript:openHistory('"+eid+"','"+patclass+"','"+i+"')\" class='gridLink'>"+patid+"</a></td><td  class='gridData'> ");//32902
	out.println(patname+"</td><td  class='gridData'>");
	 }
	
	
	out.println(patclass_desc+"</td><td  class='gridData'>");

	String location = rs.getString("LOCN_DESC")==null?"":rs.getString("LOCN_DESC");
	out.println(location+"</td><td  class='gridData'>");

	String practname = rs.getString("PRACT_NAME")==null?"":rs.getString("PRACT_NAME");
	out.println(practname+"</td><td  class='gridData'>");

	if(!(group.equals("8")))
	 {
	out.println(distype+"</td><td align='center' class='gridData'>");
	 }

	
	out.println("<a href=\"javascript:populateChart('"+faci+"','"+eid+"','"+patid+"')\" class='gridLink'><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td>");

	//out.println("<a href='javascript:' onClick='populate(\""+fid+"\");'><img src='../../eCA/images/flow_text.gif' ></a></td>");
    
	

prev=diagcode;	
prevpat=patid;
prevdtype=distype;
      //32902
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patid));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(restPatientYN));
            _bw.write(_wl_block28Bytes, _wl_block28);

      //32902

i++;
 }//endwhile 
		}
 
            _bw.write(_wl_block29Bytes, _wl_block29);


 }catch(Exception e)
     {
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

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DisplayType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
