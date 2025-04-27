package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __emailpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/EmailPreview.jsp", 1709119686000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t</link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrderEntrySearch.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<FORM METHOD=POST ACTION=\"\">\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" id=\"tableheader\" class=\"grid\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t</table>\n\t<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" id=\"tableresult\" class=\"grid\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</table>\n</FORM>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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


	private java.lang.StringBuffer buildEmailDetails(eOR.OrderEntryBean bean, ArrayList EmailDetails,String[] EmailDataDetails,PageContext pageContext,String dateString) throws Exception
	{
	 	String[] email_record					= null;	
		//String classValue				= "";
		StringBuffer sbEmail		= new StringBuffer();

		int count_display=1;
		for(int i=0; i<EmailDetails.size(); i++)
		{
				email_record = (String[])EmailDetails.get(i);
				if(email_record[0].equals(email_record[2]))
				{
					if(email_record[0].equals("PAT_DTL"))
					{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientDetails.label","common_labels")+"</font></b></td></tr>");
						
						}
						else if(email_record[0].equals("ENC_ID"))
						{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\"colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</font></b></td></tr>");
						
						}
						else if(email_record[0].equals("ORD_DTL"))
						{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderDetails.label","or_labels")+"</font></b></td></tr>");
						
						}
					}
					else
					{
						count_display++;
						if(count_display%2==0)
						sbEmail.append("</tr><tr>");
						if(email_record[0].equals("PAT_NAME"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[2],"")+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_AGE"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getAge(),"")+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_SEX"))
						{
							String sex=bean.checkForNull((String)bean.getSex(),"");
							if (sex.equalsIgnoreCase("M"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if(sex.equalsIgnoreCase("F"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sex.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+sex+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_ID"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getPatientId(),"")+"</td>");
						
						}
						else if(email_record[0].equals("PAT_NATIONAL_ID"))
						{
					
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[3],"")+"</B></td>");
						
						}
						else if(email_record[0].equals("ENC_SPLTY"))
						{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[0],"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ENC_LOCATION"))
							{
								String enc_location_type=bean.checkForNull((String)EmailDataDetails[5],"");
								if(enc_location_type.equalsIgnoreCase("C"))
								{								
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
								}
								else if(enc_location_type.equalsIgnoreCase("N"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								}else if(enc_location_type.equalsIgnoreCase("R"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
								}
								else if(enc_location_type.equalsIgnoreCase("D"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
								}
								String enc_location=enc_location_type+"/"+bean.checkForNull((String)EmailDataDetails[6],"");
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull(enc_location,"")+"</td>");
							
							}
							else if(email_record[0].equals("ENC_ATTEND_PRAC"))
							{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getAttendPractitionerName(),"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ENC_VISIT_DATE"))
							{
						
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)dateString,"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ORD_NO"))
							{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderNo.label","common_labels")+"</td><td class=\"label\" width=\"25%\">##ORDERID##</td>");
							
							}
							else if(email_record[0].equals("ORD_LOC"))
							{
								String location_type=bean.checkForNull((String)bean.getLocationType(),"");
								if(location_type.equalsIgnoreCase("C"))
								{								
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
								}
								else if(location_type.equalsIgnoreCase("N"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								}else if(location_type.equalsIgnoreCase("R"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
								}
								else if(location_type.equalsIgnoreCase("D"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
								}

									String ordering_location=location_type+"/"+bean.checkForNull((String)EmailDataDetails[7],"");
							
									sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+ordering_location+"</B></td>");
								
								}
								else if(email_record[0].equals("ORD_DATE"))
								{
							
									sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderDate.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)dateString,"")+"</B></td>");
								}
							}
							
					}
					
				email_record = null;
				
		return sbEmail;
	} // End of Method


	private java.lang.StringBuffer buildEmailDetailData(eOR.OrderEntryBean bean,  eOR.Common.OrderEntryRecordBean orderEntryRecordBean,HttpServletRequest request,PageContext pageContext) throws Exception
	{
	 	//String[] email_record					= null;	
		//String classValue				= "";
		StringBuffer sbEmail		= new StringBuffer();
		ArrayList	  arrSeqNo		= new ArrayList();
		HashMap instructionsMap		= new HashMap();
		Object prepins				= "IS";

		
		sbEmail.append("<tr><td width=\"20%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderCatalogs.label","or_labels")+"</td><td width=\"40%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientInstructions.label","common_labels")+"</td><td width=\"40%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+"</td></tr>");
		int total_rows          		= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
		for(int i=0;i<total_rows;i++)
		{
	        String catalog_code	= bean.checkForNull(request.getParameter("catalog_code"+i),"");
			String amend_line_comments=bean.checkForNull(request.getParameter("amend_line_comments"+i),"");
			String amend_line_preps=bean.checkForNull(request.getParameter("amend_line_preps"+i),"");
			String amend_line_pat_instrn=bean.checkForNull(request.getParameter("amend_line_pat_instrn"+i),"");
			String amend_line_dept_instrn=bean.checkForNull(request.getParameter("amend_line_dept_instrn"+i),"");
	        String pat_instrn_age_sex_yn	= bean.checkForNull(request.getParameter("pat_instrn_age_sex_yn"+i),"");
			String catalog_desc=bean.getEmailCatalogDesc(catalog_code);
			arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+catalog_code,catalog_code);
			String comment="";
			String pat_preps_instrn="";
			String pat_dep_instrn="";
			String pat_preps_instrns="";
			if(arrSeqNo!=null && arrSeqNo.size()>0)
			 {
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
				  		pat_preps_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
				  		pat_dep_instrn 			 =  bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
			  			pat_preps_instrn     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
			 }
			 if(comment.equals("")&&pat_preps_instrn.equals("")&&pat_dep_instrn.equals("")&&pat_preps_instrns.equals(""))
			{
					String sex_yn="";
					int age_in_days=0;
					//String pat_pat_preps_instrns="";
					//String EnableEmail="N";
					if(bean.checkForNull(pat_instrn_age_sex_yn,"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						pat_preps_instrn 		= bean.checkForNull(bean.getPrepsInstructions(catalog_code,age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
				    {
						//pat_preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 		= bean.getPreps(catalog_code);  // For Patient Preps. Insructions.
						pat_preps_instrn		= (String)instructionsMap.get(prepins);
				    }
						if(!(amend_line_comments.equals("")&&amend_line_preps.equals("")&&amend_line_pat_instrn.equals("")&&amend_line_dept_instrn.equals("")))
						{
							comment=amend_line_comments;
							pat_preps_instrn=amend_line_pat_instrn;
						}
			}
			
			 if(comment.equals("")&&pat_preps_instrn.equals(""))
			{
			}
			else
			{
					sbEmail.append("<tr><td width=\"20%\">"+catalog_desc+"</td><td width=\"38%\" id=\"patinst"+catalog_code+"\"><TEXTAREA  name=\"pattxtarea"+catalog_desc+"\" rows='5' cols=\"40\" readonly>"+pat_preps_instrn+"</textarea></td><td id=\"cmts"+catalog_code+"\" width=\"38%\"><TEXTAREA name=\"cmttxtarea"+catalog_desc+"\" rows=\"5\" cols=\"40\" readonly>"+comment+"</textarea></td></tr>");
				
			}
		}
		return sbEmail;
	}
	

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String report_id="EMPATINS";
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	ArrayList  EmailDetails=(ArrayList)bean.getEmailDetails(report_id);
	String[]  EmailDataDetails=bean.getEmailDataDetails(facility_id);
	//ArrayList	  arrSeqNo		= new ArrayList();
	//String[] email_record	   = null;
	

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	//HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	//String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,"");
	String dateString							= bean.getSysDate();
	//String physician_name				= bean.getPractitionerName();
	//String pract_id				 			= bean.getPractitionerId();
	//String priority								= bean.checkForNull(request.getParameter("priority"+0),"");
	//String comment 			 =  "";
	//String pat_preps_instrn="";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	StringBuffer sbEmail=new StringBuffer();
	sbEmail	= buildEmailDetails(bean, EmailDetails,EmailDataDetails,pageContext,dateString);
	if(sbEmail!=null)
	{	
		out.println(sbEmail.toString().replace("##ORDERID##",""));
	}
	
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	StringBuffer sbEmailData=new StringBuffer();
	sbEmailData	= buildEmailDetailData(bean, orderEntryRecordBean,request,pageContext);
	if(sbEmailData!=null)
	{		
			out.println(sbEmailData.toString());
	}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
}
