package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __issuegroupvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/IssueGroupValidate.jsp", 1728551706452L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alIssueGroupList= null;synchronized(session){
                alIssueGroupList=(java.util.ArrayList)pageContext.getAttribute("alIssueGroupList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alIssueGroupList==null){
                    alIssueGroupList=new java.util.ArrayList();
                    pageContext.setAttribute("alIssueGroupList",alIssueGroupList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	IssueGroupListBean bean			=		(IssueGroupListBean)getBeanObject( "issueGroupListBean",  "eSS.IssueGroupListBean" ,request) ; 
	IssueGroupBean bean1			=		(IssueGroupBean)getBeanObject( "issueGroupBean",  "eSS.IssueGroupBean" ,request) ;
	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
	hash							=		(Hashtable) hash.get ("SEARCH");
	String doc_type_code			=		request.getParameter("doc_type_code");
	//String doc_type_code_iss			=		request.getParameter("doc_type_code_iss");
	String doc_no					=		request.getParameter("doc_no");
	String validate					=		request.getParameter("validate");

	String tray_no					=		request.getParameter("tray_no");
	String group_code				=		request.getParameter("group_code");

	String req_doc_type_code		=		request.getParameter("req_doc_type_code");
	String patient_id				=		request.getParameter("patient_id");
	String req_doc_no				=		request.getParameter("req_doc_no");
	String index					=		request.getParameter("index");

	String patient_name				=		request.getParameter("patient_name");
	String issue_group_code			=		request.getParameter("issue_group_code");
	String issue_group_desc			=		request.getParameter("issue_group_desc");
	String bin_location_code		=		request.getParameter("bin_location_code");
	String expiry_date				=		request.getParameter("expiry_date");
    //added by Pankaj
	String receiving_store_code		=		request.getParameter("receiving_store_code");
	String req_group_code		=		request.getParameter("req_group_code");
	String auth_group_code		=		request.getParameter("auth_group_code");
	String req_group_desc		=		request.getParameter("req_group_desc");
	String auth_group_desc		=		request.getParameter("auth_group_desc");
	String mode					=		request.getParameter("mode");
	
	String index_val			=		request.getParameter("index_val");
	String fr_store_code		=		request.getParameter("fr_store_code");
	String search_type			= 		request.getParameter("search_type");

	String message					=		"";
	String flag						=		"";
	boolean	result					=		true;
	boolean Issue_Ack_Reqd			= false;

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		else if (validate.equals("PATIENT_NAME")){
			try{
				//out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
				out.println("setPatientName(\""+index_val+"\",\""+bean.getPatientName(patient_id)+"\");");
				//Added by Sakti sankar against ML-BRU-SCF-0834 inc#39667
				if(bean.getPatientName(patient_id).equals("") || bean.getPatientName(patient_id)== null ) {
					result = false;
					flag			=	"INVALID_PATIENT";
				}
				//Added ends 
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
		}
		else if (validate.equals("TRAY_DETAIL")){
			try{

				//Added by Sakti against BRU-HIMS-CRF-375 to check duplicate tray exist Onblur of tray_no field 
				int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
				
				for(int i=0;i<total_rec;i++){
					if (Integer.parseInt(index_val) == i) continue;
					if(hash.get("tray_no_"+Integer.parseInt(index_val)).equals((String)hash.get("tray_no_"+i)) && hash.get("issue_group_code_"+Integer.parseInt(index_val)).equals((String)hash.get("issue_group_code_"+i))  ){
						flag	=	"RECORD_ALREADY_EXISTS";
						result			=	false;
						//throw new Exception("RECORD_ALREADY_EXISTS");
					}
				}//Added ends

				ArrayList alParameters	=	new ArrayList(2);
				alParameters.add(new Long(tray_no));
				alParameters.add(group_code);
				HashMap hmRecord		=	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_SELECT_DETAIL_FOR_ISSUE"),alParameters);
				//out.println("setTrayDetail(\""+tray_no+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+hmRecord.get("EXPIRY_DATE")+"\",\""+hmRecord.get("ISSUE_COST")+"\");");
				//Comented by Sakti against BRU-HIMS-CRF-375
				out.println("setTrayDetail(\""+index_val+"\",\""+tray_no+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+hmRecord.get("EXPIRY_DATE")+"\",\""+hmRecord.get("ISSUE_COST")+"\");");
			}
			catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_TRAY_NO";
				result			=	false;
				out.println("setTrayDetail(\""+tray_no+"\",\"\",\"\",\"\");");
			}
		}
		else if (validate.equals("CLEAR_LIST")){
			//alIssueGroupList.clear();
		}

		/*else if (validate.equals("ADD_TO_LIST")){
			if(bean.isTrayInArrayList(alIssueGroupList, tray_no, issue_group_code, Integer.parseInt(index))){
				flag	=	"RECORD_ALREADY_EXISTS";
				throw new Exception("RECORD_ALREADY_EXISTS");
			}
           

			ArrayList alParametersCheck	=	new ArrayList(2);

            alParametersCheck.add(receiving_store_code);
			alParametersCheck.add(issue_group_code);

            HashMap hmResultCheck	=	null;
			hmResultCheck = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_STORE_CHECK"),alParametersCheck);

			String stCountRecord = (String)hmResultCheck.get("COUNT");

			if(!stCountRecord.equals("0"))
            {
			//HashMap	hmRecord	=	(HashMap) alIssueGroupList.get(Integer.parseInt(index));
            
			HashMap	hmRecord	=	new HashMap();

			hmRecord.put("patient_name",patient_name		);
			hmRecord.put("issue_group_code",issue_group_code	);
			hmRecord.put("issue_group_desc",issue_group_desc);
			hmRecord.put("req_group_desc",	req_group_desc	);
			hmRecord.put("auth_group_desc",	auth_group_desc	);
			hmRecord.put("bin_location_desc",bin_location_code);
			hmRecord.put("expiry_date",expiry_date		);
			hmRecord.put("patient_id",patient_id);
			hmRecord.put("tray_no",tray_no);
			hmRecord.put("auth_group_code",	auth_group_code	);
			hmRecord.put("req_group_code",	req_group_code	);
			hmRecord.put("issue_cost",""+(Double.parseDouble(bean.getSterilizationCost(issue_group_code))+Double.parseDouble(bean.getGroupCost(issue_group_code,"5"))));
			hmRecord.put("sterile_cost",bean.getSterilizationCost(issue_group_code));  
			hmRecord.put("packing_cost",bean.getGroupCost(issue_group_code,"4"));  
			hmRecord.put("consumables_cost",bean.getGroupCost(issue_group_code,"2"));
			hmRecord.put("non_consumables_cost",bean.getGroupCost(issue_group_code,"1"));
			if(index.equals("-1")){
				hmRecord.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alIssueGroupList.add(hmRecord);
			}
			else{
				hmRecord.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alIssueGroupList.set(Integer.parseInt(index),hmRecord);
			}
			}else {
			     	out.println("issueGroupStoreValidate();");
                    
			}
            
		}*/
		else if (validate.equals("ADD_TO_LIST")){
		
				
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			
			for(int i=0;i<total_rec;i++){
				
			//The below duplication check validation is validated now in onBlur of the tray_no field so commented here	
			
			/*if(bean.isTrayInArrayList(alIssueGroupList, (String)hash.get("tray_no_"+i), (String)hash.get("issue_group_code_"+i), i )){
				flag	=	"RECORD_ALREADY_EXISTS";
				throw new Exception("RECORD_ALREADY_EXISTS");
			}*/
           
			
			ArrayList alParametersCheck	=	new ArrayList(2);

            alParametersCheck.add((String)hash.get("to_store_code"));
			alParametersCheck.add((String)hash.get("issue_group_code_"+i));

            HashMap hmResultCheck	=	null;
			hmResultCheck = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_STORE_CHECK"),alParametersCheck);

			String stCountRecord = (String)hmResultCheck.get("COUNT");
			System.out.println("stCountRecord"+stCountRecord);

			if(!stCountRecord.equals("0"))
            {
			//HashMap	hmRecord	=	(HashMap) alIssueGroupList.get(Integer.parseInt(index));
            
			HashMap	hmRecord	=	new HashMap();

			hmRecord.put("patient_name",(String)hash.get("patient_name_"+i)		);
			hmRecord.put("issue_group_code",(String)hash.get("issue_group_code_"+i)	);
			hmRecord.put("issue_group_desc",(String)hash.get("issue_group_desc_"+i));
			hmRecord.put("req_group_desc",	(String)hash.get("req_group_desc_"+i)	);
			hmRecord.put("auth_group_desc",	(String)hash.get("auth_group_desc_"+i)	);
			hmRecord.put("bin_location_desc",(String)hash.get("bin_location_code_"+i));
			hmRecord.put("expiry_date",(String)hash.get("expiry_date_"+i)		);
			hmRecord.put("patient_id",(String)hash.get("patient_id_"+i));
			hmRecord.put("tray_no",(String)hash.get("tray_no_"+i));
			hmRecord.put("auth_group_code",	(String)hash.get("auth_group_code_"+i)	);
			hmRecord.put("req_group_code",	(String)hash.get("req_group_code_"+i)	);
			hmRecord.put("issue_cost",""+(Double.parseDouble(bean.getSterilizationCost((String)hash.get("issue_group_code_"+i)))+Double.parseDouble(bean.getGroupCost((String)hash.get("issue_group_code_"+i),"5"))));
			hmRecord.put("sterile_cost",bean.getSterilizationCost((String)hash.get("issue_group_code_"+i)));  
			hmRecord.put("packing_cost",bean.getGroupCost((String)hash.get("issue_group_code_"+i),"4"));  
			hmRecord.put("consumables_cost",bean.getGroupCost((String)hash.get("issue_group_code_"+i),"2"));
			hmRecord.put("non_consumables_cost",bean.getGroupCost((String)hash.get("issue_group_code_"+i),"1"));
			
				hmRecord.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alIssueGroupList.set(i,hmRecord);
			
			}else {
			     	out.println("issueGroupStoreValidate();");
                    
			}
			
		}
            
	}

		else if (validate.equals("SEARCH_REQUEST")){
			Issue_Ack_Reqd = bean1.getAckReqd();
			ArrayList alParameters	=	new ArrayList(5);
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(req_doc_type_code);
			alParameters.add(new Long(req_doc_no));
			alParameters.add(bean.getLoginById());
			alParameters.add(bean.getLoginById());
			HashMap hmResult	=	null;
			hmResult = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_REQUEST_HDR_COUNT_VALID"),alParameters);
			if(hmResult.get("TOTAL").toString().equals("0")){
				flag	=	"INVALID_REQ_DOC_NO";
				throw new Exception("INVALID_REQ_DOC_NO");
			}
			alParameters.remove(3);
			alParameters.remove(3);
			if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){
				if(!(Issue_Ack_Reqd)) {
					hmResult = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_REQUEST_DTL_COUNT_NOT_ISSUED"),alParameters);
				}else{
					hmResult = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_REQUEST_DTL_COUNT_NOT_ISSUED_FOR_ACK"),alParameters);
				}
					if(hmResult.get("TOTAL").toString().equals("0")){
						flag	=	"ALL_REQUEST_ISSUED";
						throw new Exception();
					}
			
			}
			hmResult = bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_REQUEST_HDR_SELECT_SINGLE_CANCEL"),alParameters);

			//To get Entered By User Name from User ID


			
			
				String strEnterdByName="";
				String strEnterdById=(String)hmResult.get("AUTHORIZED_BY_ID");
				String strLocale=(String) session.getValue( "LOCALE" ) ;
				Connection con=ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rset=null;
				rset = stmt.executeQuery("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+strLocale+"' and APPL_USER_ID='"+strEnterdById+"'") ;
			try{	
				if(rset !=null)	{
					if(rset.next()) {
						strEnterdByName = rset.getString("APPL_USER_NAME");
					}
				}
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}finally{
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
			//Added by suresh.r on 28/05/2015 against ML-BRU-SCF-1597 Beg
			strEnterdByName = strEnterdByName.replaceAll(" ","%20");
			strEnterdByName=java.net.URLEncoder.encode(strEnterdByName);
			strEnterdByName = strEnterdByName.replaceAll("%2520","%20");
			//Added by suresh.r on 28/05/2015 against ML-BRU-SCF-1597 end
			out.println("setIssueDetail('"+hmResult.get("REQ_ON_STORE_CODE")+"', '"+hmResult.get("REQ_BY_STORE_CODE")+"', '"+hmResult.get("AUTHORIZED_BY_ID")+"', '"+strEnterdByName+"')");

			if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){
				ArrayList alRecords = null;;
				if(!(Issue_Ack_Reqd)) {
					 alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_REQUEST_HDR_SELECT_FOR_ISSUE"),alParameters);
				}else{
					alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_REQUEST_HDR_SELECT_FOR_ISSUE_ACK"),alParameters);
				}
					for(int i=0; i<alRecords.size(); i++){
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					int left_qty		=	Integer.parseInt(hmRecord.get("LEFT_QTY").toString());
					for (int j=0; j<left_qty; j++){	
					HashMap hmListItems	=	new HashMap();
					hmListItems.put("issue_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("issue_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("req_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("req_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("auth_group_code",hmRecord.get("AUTH_GROUP_CODE"));
					hmListItems.put("auth_group_desc",hmRecord.get("AUTH_GROUP_DESC"));
					hmListItems.put("patient_name","");
					hmListItems.put("bin_location_desc","");
					hmListItems.put("expiry_date","");
					hmListItems.put("patient_id","");
					hmListItems.put("tray_no","");
					hmListItems.put("issue_cost","");
					hmListItems.put("sterile_cost","");  
					hmListItems.put("packing_cost","");  
					hmListItems.put("consumables_cost","");
					hmListItems.put("non_consumables_cost","");
					alIssueGroupList.add(hmListItems);		
				}
			}
		}else if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
			    alParameters	=	new ArrayList(3);
				 alParameters.add((String) session.getValue( "LOCALE" ) );
				alParameters.add(session.getAttribute("facility_id"));
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				//ArrayList alRecords = bean.fetchRecords("SELECT req_group_code, grp.short_desc req_group_desc, auth_group_code, agrp.short_desc auth_group_desc,tray_no,patient_id  FROM ss_issue_dtl , ss_group grp, ss_group agrp WHERE grp.group_code=req_group_code AND auth_group_code = agrp.group_code AND facility_id=? AND doc_type_code=? AND doc_no=?",alParameters);
				//Modified By Sakti against BRU-HIMS-CRF-375
				ArrayList alRecords = bean.fetchRecords("SELECT req_group_code, grp.short_desc req_group_desc, auth_group_code, agrp.short_desc auth_group_desc, dtl.tray_no, dtl.patient_id,TO_CHAR(dtl.expiry_date,'dd/mm/yyyy') expiry_date, ISSUE_COST,td.BIN_LOCATION_CODE,td.owner_store_code,(select short_desc from mm_bin_location_lang_vw vw where  vw.store_code = td.owner_store_code  and  vw.BIN_LOCATION_CODE =td.BIN_LOCATION_CODE and vw.language_id = ? ) short_desc,(select patient_name from mp_patient mp where mp.patient_id = dtl.patient_id )patient_name FROM ss_issue_dtl dtl, ss_group grp, ss_group agrp,ss_tray_dtls td WHERE grp.group_code = req_group_code AND auth_group_code = agrp.group_code and DTL.issue_group_code = TD.GROUP_CODE and dtl.tray_no = td.tray_no AND facility_id = ? AND doc_type_code = ? AND doc_no = ?",alParameters);

				for(int i=0; i<alRecords.size(); i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				//int left_qty		=	Integer.parseInt(hmRecord.get("LEFT_QTY").toString());
				
					/*HashMap hmListItems	=	new HashMap();
					hmListItems.put("issue_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("issue_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("req_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("req_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("auth_group_code",hmRecord.get("AUTH_GROUP_CODE"));
					hmListItems.put("auth_group_desc",hmRecord.get("AUTH_GROUP_DESC"));
					hmListItems.put("patient_name","");
					hmListItems.put("bin_location_desc","");
					hmListItems.put("expiry_date","");
					hmListItems.put("patient_id",hmRecord.get("PATIENT_ID"));
					hmListItems.put("tray_no",hmRecord.get("TRAY_NO"));
					hmListItems.put("issue_cost","");
					hmListItems.put("sterile_cost","");  
					hmListItems.put("packing_cost","");  
					hmListItems.put("consumables_cost","");
					hmListItems.put("non_consumables_cost","");
					alIssueGroupList.add(hmListItems);	*/
					
					HashMap hmListItems	=	new HashMap();
					hmListItems.put("issue_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("issue_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("req_group_code",hmRecord.get("REQ_GROUP_CODE"));
					hmListItems.put("req_group_desc",hmRecord.get("REQ_GROUP_DESC"));
					hmListItems.put("auth_group_code",hmRecord.get("AUTH_GROUP_CODE"));
					hmListItems.put("auth_group_desc",hmRecord.get("AUTH_GROUP_DESC"));
					hmListItems.put("patient_name",hmRecord.get("PATIENT_NAME"));
					hmListItems.put("bin_location_desc",hmRecord.get("SHORT_DESC"));
					hmListItems.put("expiry_date",hmRecord.get("EXPIRY_DATE"));
					hmListItems.put("patient_id",hmRecord.get("PATIENT_ID"));
					hmListItems.put("tray_no",hmRecord.get("TRAY_NO"));
					hmListItems.put("issue_cost",hmRecord.get("ISSUE_COST"));
					hmListItems.put("sterile_cost","");  
					hmListItems.put("packing_cost","");  
					hmListItems.put("consumables_cost","");
					hmListItems.put("non_consumables_cost","");
					alIssueGroupList.add(hmListItems);		
			}
		}
		}else if (validate.equals("POPULATE_AUTH_GROUP_CODE")){
			ArrayList alRecords	=	null;
			ArrayList alParameters	=	new ArrayList(2);
			alParameters.add(req_group_code);
			alParameters.add(req_group_code);
			alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_LIST"),alParameters);
			out.println(  "clearListItems(\"parent.frameIssueGroupDetail.document.formIssueGroupDetail.issue_group_code\");"  );
			if(alRecords==null) return;
			for (int i=0;i<alRecords.size();i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"parent.frameIssueGroupDetail.document.formIssueGroupDetail.issue_group_code\",\""+hmRecord.get("GROUP_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+req_group_code+"\");"  );

				out.println("setIssueDetailList('"+hmRecord.get("SHORT_DESC")+"', '"+hmRecord.get("SHORT_DESC")+"')");
			}
		}
		else if (validate.equals("TRAY_NO_VALIDATE")){ //Added by Rabbani for Validate Invalid Tray no on 14/12/2012
			try{
				ArrayList alParam	=	new ArrayList(2);
				alParam.add(group_code);
				alParam.add(new Long(tray_no));
			    String total = "0";
			   //HashMap ht	=	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_NOT_ISSUED"),alParam);
				 HashMap ht	=	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_VALIDATE_TRAY_NO"),alParam);
				       total = bean.checkForNull((String)ht.get("TOTAL"));
					   
				 if(total.equals("0")){
				 flag			=	"INVALID_TRAY_NO";
				 result			=	false;
				 }
			}
			catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_TRAY_NO";
				result			=	false;
			}
		}else if (validate.equals("REMOVE_TRAY_NO")){//Added by Sakti against BRU-HIMS-CRF-375
			
			int idx = Integer.parseInt(index_val);
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			boolean tray_exist	= false;
			String checked_yn = "";
			String curr_group_code = "";
			
			curr_group_code  = (String)hash.get("issue_group_code_"+idx);
						
			ArrayList alRecord = new ArrayList();
			HashMap record	= new HashMap();
			
			for(int i=0; i<total_rec; i++){				
				checked_yn = (String)hash.get("checkbox"+i);
				if(curr_group_code.equals((String)hash.get("issue_group_code_"+i)) && i!=idx && checked_yn.equals("N") ) {
					
					alRecord = bean1.getTrayNoArrayList(curr_group_code,fr_store_code);	
					
					out.println("clearListItems('document.formIssueGroupList.tray_no_"+i+"'); ");
					
					if(!((String)hash.get("tray_no_"+i)).equals(""))
						out.println(  "addListItem(\"document.formIssueGroupList.tray_no_"+i+"\",\""+(String)hash.get("tray_no_"+i)+"\",\""+(String)hash.get("tray_no_"+i)+"\",\""+(String)hash.get("tray_no_"+i)+"\");"  );
						
							for(int j=0;j<alRecord.size();j++){								
								record	=	(HashMap)alRecord.get(j);
								tray_exist = false;								
								for(int k=0;k<total_rec;k++){
									if(curr_group_code.equals((String)hash.get("issue_group_code_"+k)) && checked_yn.equals("N")  ) {
										if(((String)hash.get("tray_no_"+k)).equals((String)record.get("TRAY_NO"))){
											tray_exist  = true;
											break;
										}
									}
								}									
								if(!tray_exist)
									out.println(  "addListItem(\"document.formIssueGroupList.tray_no_"+i+"\",\""+(String)record.get("TRAY_NO")+"\",\""+(String)record.get("TRAY_NO")+"\",\""+(String)hash.get("tray_no_"+i)+"\");"  );								
							}					
			   }
			}	
		}else if (validate.equals("CHANGE_ISSUE_GROUP")){
			
			int idx = Integer.parseInt(index_val);
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			boolean tray_exist	= false;
			String checked_yn = "";
			String curr_group_code = "";
			
			curr_group_code  = (String)hash.get("issue_group_code_"+idx);
			
			ArrayList alRecord = new ArrayList();
			HashMap record	= new HashMap();
			
			for(int i=0; i<total_rec; i++){				
				checked_yn = (String)hash.get("checkbox"+i);
				if(curr_group_code.equals((String)hash.get("issue_group_code_"+i)) && checked_yn.equals("N")) {
					
					alRecord = bean1.getTrayNoArrayList(curr_group_code,fr_store_code);					
					out.println("clearListItems('document.formIssueGroupList.tray_no_"+i+"'); ");
					
					if(!((String)hash.get("tray_no_"+i)).equals(""))
						out.println(  "addListItem(\"document.formIssueGroupList.tray_no_"+i+"\",\""+(String)hash.get("tray_no_"+i)+"\",\""+(String)hash.get("tray_no_"+i)+"\",\""+(String)hash.get("tray_no_"+i)+"\");"  );
						
							for(int j=0;j<alRecord.size();j++){								
								record	=	(HashMap)alRecord.get(j);
								tray_exist = false;								
								for(int k=0;k<total_rec;k++){	
										if(curr_group_code.equals((String)hash.get("issue_group_code_"+k)) && checked_yn.equals("N")  ) {
											if(((String)hash.get("tray_no_"+k)).equals((String)record.get("TRAY_NO"))){
											tray_exist  = true;
											break;
										}
									} 
								}									
								if(!tray_exist)
									out.println(  "addListItem(\"document.formIssueGroupList.tray_no_"+i+"\",\""+(String)record.get("TRAY_NO")+"\",\""+(String)record.get("TRAY_NO")+"\",\""+(String)hash.get("tray_no_"+i)+"\");"  );								
							}					
			   }
			}	
		}else if (validate.equals("DTL_DATA_STORE")){
			ArrayList	alRecords	=	new ArrayList();
			HashMap	hmDtlRecord	=	new HashMap();
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			String checked_yn = "";
				       
			for(int i=0;i<total_rec;i++){ 
				checked_yn = (String)hash.get("checkbox"+i);
				hmDtlRecord.put("issue_group_code",(String)hash.get("issue_group_code_"+i));
				hmDtlRecord.put("issue_group_desc",(String)hash.get("issue_group_desc_"+i));
				hmDtlRecord.put("req_group_code",(String)hash.get("req_group_code_"+i));
				hmDtlRecord.put("req_group_desc",(String)hash.get("req_group_desc_"+i));
				hmDtlRecord.put("auth_group_code",(String)hash.get("auth_group_code_"+i));
				hmDtlRecord.put("auth_group_desc",(String)hash.get("auth_group_desc_"+i));
				hmDtlRecord.put("patient_name",(String)hash.get("patient_name_"+i));
				hmDtlRecord.put("bin_location_desc",(String)hash.get("bin_location_code_"+i));
				hmDtlRecord.put("expiry_date",(String)hash.get("expiry_date_"+i));
				hmDtlRecord.put("patient_id",(String)hash.get("patient_id_"+i));
				if(checked_yn.equals("Y")){
				hmDtlRecord.put("tray_no",(String)hash.get("tray_num_"+i));
				}else{
				hmDtlRecord.put("tray_no",(String)hash.get("tray_no_"+i));
				}
				hmDtlRecord.put("issue_cost",(String)hash.get("issue_cost_"+i));
				hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));
				
				
				bean1.setnewalGroupRecords((String)hash.get("group"+i));

				alRecords.add(hmDtlRecord);
				hmDtlRecord = new HashMap();
				
				bean1.setAlSelectedTrayDetails((String)hash.get("group"+i));
								
			}

			bean1.setSelectedList(alRecords);
		}else if (validate.equals("ADD_GROUPS_TO_LIST")){//Added by Sakti against BRU-HIMS-CRF-375
					try{
						bean1.selectedBatches(hash);
						
						//This is added by Sakti  if in group search window any one group is selected among all pages, need to add that group in list. If not, then below message shown
						ArrayList checkedrecord =  bean1.getAlSelectedTrayDetails();
						if(search_type.equals("search")){
							if(checkedrecord.size()<1){
								result			=	false;
							}else{
								result = true;
							}
						}//Added ends
					}catch(Exception exception){
						exception.printStackTrace();
						flag			=	"INVALID_GROUP_SELECTION";
						result			=	false;
					}
						
				}//Added ends
	}
	catch (Exception exception){
		out.println("clearIssueDetail();");
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
	putObjectInBean("issueGroupListBean",  bean,request);


            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
