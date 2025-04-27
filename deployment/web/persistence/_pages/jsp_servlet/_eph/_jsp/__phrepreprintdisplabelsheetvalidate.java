package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __phrepreprintdisplabelsheetvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PhRepRePrintDispLabelSheetValidate.jsp", 1721304637365L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	RePrintDispLabelSheetBean beanObj	= (RePrintDispLabelSheetBean)getBeanObject(bean_id, bean_name, request);
	beanObj.setLanguageId(locale);
	try {
		String facility_id			= (String) hash.get( "facility_id" );
		String disp_locn_code		= (String) hash.get( "disp_locn_code" );
		String validate             = request.getParameter("validate")==null?"":request.getParameter("validate"); 
		if(validate.equals("populateDispNo")) {			
			String patient_id		= (String) hash.get( "p_patient_id" )==null?"":(String) hash.get( "p_patient_id" );
			String disp_date		= (String) hash.get( "p_disp_date" )==null?"":(String) hash.get( "p_disp_date" );
			String stage			= (String) hash.get( "stage" )==null?"":(String) hash.get( "stage" );
			String patient_class		= (String) hash.get( "patient_class" )==null?"":(String) hash.get( "patient_class" );
			String report_type		= (String) hash.get( "report_type" )==null?"":(String) hash.get( "report_type" ); //added for GHL-CRF-0627
			ArrayList disp_nos	=	null;
			disp_nos	=	beanObj.getDispNos(stage, patient_id,disp_date,patient_class,report_type);//p_source_type,p_source_code);//added for GHL-CRF-0627
			
			System.err.println("disp_nos===>" + disp_nos);
			out.println("clearDispNos()");
			//SKR-SCF-1278 - start
			StringBuffer dispNo = new StringBuffer();
			String fm_disp_no		= "";
			String to_disp_no		= "";
			if(disp_nos.size()!=0) {
				fm_disp_no	=	(String)disp_nos.get(0);
				to_disp_no	=	(String)disp_nos.get(disp_nos.size()-2);
			}
			for(int i=0;i<disp_nos.size();i=i+2){
								
					if(i==0){
						 
						dispNo.append((String)disp_nos.get(0));
						if(disp_nos.size()>2) //1 to 2 changed for SKR-SCF-1278.1
							dispNo.append(",");
					}else{
						if(i==(disp_nos.size()-2)){
							dispNo.append((String)disp_nos.get(i));
							
						}else{
							dispNo.append((String)disp_nos.get(i));
							dispNo.append(",");
							
						}
					}
			}
			out.println("setDispNos('"+dispNo.toString()+"')");  
			//SKR-SCF-1278 - end			

			for(int k=0; k<disp_nos.size(); k=k+2) {
				out.println("loadDispNos('"+(String)disp_nos.get(k)+"','"+(String)disp_nos.get(k+1)+"')");
			}
		}
		else if( validate.equals("patientsearch" ) ){
			String patient_id					= (String) hash.get("patient_id");
			ArrayList patientdetails	= beanObj.getPatientDetails(patient_id);
			if(patientdetails.size()==0){
				out.println("chkpatID('N');") ;
			}
			else{
				out.println("chkpatID('Y');") ;
			}
		}
		else if( validate.equals("UPDATESELECTION" ) ){
			String disp_no					= (String) hash.get("disp_no");
			String dicp_srl_no					= (String) hash.get("dicp_srl_no");
			String select_yn					= (String) hash.get("select_yn");
			ArrayList alDrugDispList	= beanObj.getDrugDispList();
			for(int i=0;i<alDrugDispList.size();i+=5){//Increase the Size from 3 To 5 for Bru-HIMS-CRF-417[IN045565]
				if(disp_no.equals((String)alDrugDispList.get(i)) && dicp_srl_no.equals((String)alDrugDispList.get(i+1))){
					alDrugDispList.set(i+2, select_yn);
					break;
				}
			}
			beanObj.setDrugDispList(alDrugDispList);
		}
		else if(validate != null && validate.equals("UPDATESELECTIONALL" ) ){
			String selectAll_yn					= (String) hash.get("selectAll_yn");
			ArrayList alDrugDispList	= beanObj.getDrugDispList();
			for(int i=0;i<alDrugDispList.size();i+=5){//Increase the Size from 3 To 5 for Bru-HIMS-CRF-417[IN045565]
				alDrugDispList.set(i+2, selectAll_yn);
			}
			beanObj.setDrugDispList(alDrugDispList);
		}		
		else if(validate.equals("UPDATEPRINTSEQ" ) ){
			String called_from					= (String) hash.get("called_from");
			ArrayList alDrugDispList	= beanObj.getDrugDispList();
			boolean checkSeleted = false, blRecUpdated =false;
			for(int i=0;i<alDrugDispList.size();i+=5){//Increase the Size from 3 To 5 for Bru-HIMS-CRF-417[IN045565]
				if(((String)alDrugDispList.get(i+2)).equals("Y")){
					checkSeleted = true;
					break;
				}
			}
			if(!checkSeleted){
				out.println("alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));") ;
			}
			else{
				String stage					= (String) hash.get("stage");
				//String prntSeqNo= beanObj.updatePrintSeqNo(stage);Commented for Bru-HIMS-CRF-0417[IN045565]
				//Added for Bru-HIMS-CRF-0417[IN045565]-Start
				HashMap<String, ArrayList> grp_nof_copies_seq_no=new HashMap<String, ArrayList>();
				ArrayList tmpList = null;
				String NofCopies="", prntSeqNo="";
				for(int i=0;i<alDrugDispList.size();i+=5){
					if(called_from.equals("P")) // if condition & else block Added for ML-BRU-SCF-1414 [IN:050645] 
						NofCopies=(String)alDrugDispList.get(i+4);
					else
						NofCopies = "1";
					if(((String)alDrugDispList.get(i+2)).equals("Y")){
						if(!grp_nof_copies_seq_no.containsKey(NofCopies))
							tmpList = new ArrayList();
						else
							tmpList = grp_nof_copies_seq_no.get(NofCopies);
						tmpList.add((String)alDrugDispList.get(i)); //disp_no
						tmpList.add((String)alDrugDispList.get(i+1)); //disp_srl_no
						tmpList.add((String)alDrugDispList.get(i+2)); //checked_yn
						tmpList.add((String)alDrugDispList.get(i+3));//patient_id
						grp_nof_copies_seq_no.put(NofCopies,tmpList);
					}
				}
				beanObj.clearSeq_no_no_of_copies();// Added for SKR-SCF-1041[IN051887] 
				blRecUpdated = beanObj.updatePrintSeqNo(stage, called_from, grp_nof_copies_seq_no); //moved out form below loop for ML-BRU-SCF-1414 [IN:050645] 
				if(blRecUpdated){
					if(called_from.equals("P")){
						//String patient_id  	    =(String)hash.get("patient_id");//code added for HSA-SCF-0038[IN050015]
						//String disp_no  		=(String)hash.get("disp_no");//code added for HSA-SCF-0038[IN050015]
						/*for(String no_of_copies:grp_nof_copies_seq_no.keySet()){ //commented  for ML-BRU-SCF-1414 [IN:050645] 
							prntSeqNo = beanObj.updatePrintSeqNo(stage, called_from, grp_nof_copies_seq_no.get(no_of_copies));
							beanObj.setSeq_no_no_of_copies(prntSeqNo,Integer.parseInt(no_of_copies));// Added for SKR-SCF-1041[IN051887]
						}*/
						out.println("assignResult('Y') ");
					}
					else{
						//prntSeqNo= beanObj.updatePrintSeqNo(stage, called_from, null); //Commented for ML-BRU-SCF-1414 [IN:050645] 
						HashMap<String, ArrayList> hmSeq_no_no_of_copies= beanObj.getSeq_no_no_of_copies(); //Added for ML-BRU-SCF-1414 [IN:050645] 
						for(String printSeqNo:hmSeq_no_no_of_copies.keySet()){ //Added for ML-BRU-SCF-1414 [IN:050645] 
							out.println("setprntSeqNo('"+printSeqNo+"','"+called_from+"');");
							break; //Added for ML-BRU-SCF-1414 [IN:050645] 
						} 
					}
				}
				else
					out.println("setprntSeqNo('','"+called_from+"');");
			}
		}
		else if(validate.equals("PRINTREP")){// Added for SKR-SCF-1041[IN051887]
			int no_of_copies=0;
			ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;//Added for Bru-HIMS-CRF-0417[IN045565]-Start
			ecis.utils.OnlineReport report				=	null;
			String ReportOutput	= "";
			String patient_class = (String)hash.get("p_pat_class");//SKR-SCF-1734
			String p_disp_date = (String)hash.get("p_disp_date");//SKR-SCF-1483
			String report_type		= hash.get("report_type")==null?"":(String)hash.get("report_type"); //Added for ML-BRU-SCF-1414 [IN:050645] 
			String p_report_id		= (String)hash.get("p_report_id");
			String p_user_name		= (String)hash.get("p_user_name");
			String p_facility_id	= (String)hash.get("p_facility_id");
			String p_language_id   =(String)hash.get("p_language_id");
			String patient_id  	    =(String)hash.get("p_patient_id");//code added for HSA-SCF-0038[IN050015]
			String disp_stage  	    =(String)hash.get("stage");///SKR-scf-1734
			//String disp_no  		=(String)hash.get("disp_no");//code added for HSA-SCF-0038[IN050015]
			HashMap<String, ArrayList> seq_no_no_of_copies= beanObj.getSeq_no_no_of_copies();
			ArrayList alDispList = null;
			if(report_type.equals("L")){ //Dispense Label // if condition and else block Added for ML-BRU-SCF-1414 [IN:050645] 
				for(String printSeqNo:seq_no_no_of_copies.keySet()){
					alDispList = (ArrayList)seq_no_no_of_copies.get(printSeqNo);
					no_of_copies = (Integer)alDispList.get(0);
					for(int j=0;j<no_of_copies;j++){
						for(int k=0;k<alDispList.size();k+=4){ //Added for ML-BRU-SCF-1414 [IN:050645] 
							report	= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
							report.addParameter("p_report_id",p_report_id) ;
							report.addParameter("p_offline_print_seq_no",printSeqNo); 
							report.addParameter("p_user_name",p_user_name) ;
							report.addParameter("p_facility_id",p_facility_id) ;
							report.addParameter("p_module_id", "PH") ;
							report.addParameter("p_language_id", p_language_id) ;
							report.addParameter("p_patient_id",(String)alDispList.get(k+3)) ;//code added for HSA-SCF-0038[IN050015]
							//report.addParameter("p_disp_no",disp_no) ;//code added for HSA-SCF-0038[IN050015]
							report.addParameter("p_disp_no",(String)alDispList.get(k+1)); //Added for ML-BRU-SCF-1414 [IN:050645] 
							report.addParameter("p_srl_no", (String)alDispList.get(k+2)) ; //Added for ML-BRU-SCF-1414 [IN:050645] 
							report.addParameter("p_disp_date", p_disp_date) ;//SKR-SCF-1483

							onlineReports.add( report) ;
						}
					}//Added for Bru-HIMS-CRF-0417[IN045565]-End
				}
			}
			else{//Dispense Sheet//SKR-scf-1734---start
				for(String printSeqNo:seq_no_no_of_copies.keySet()){
					StringBuffer dispNo = new StringBuffer(); 
					
				  alDispList = (ArrayList)seq_no_no_of_copies.get(printSeqNo);
				  			  
					report	= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
					report.addParameter("p_disp_date", p_disp_date);
					
					report.addParameter("p_pat_class", patient_class);
					
					report.addParameter("p_report_id",p_report_id) ;
					
					report.addParameter("p_offline_print_seq_no",printSeqNo);
					
					report.addParameter("p_user_name",p_user_name) ;
					
					report.addParameter("p_facility_id",p_facility_id) ;
										
					report.addParameter("p_module_id", "PH") ;
					
					report.addParameter("p_language_id", p_language_id) ;
										
					report.addParameter("p_patient_id",patient_id) ;				
					
					for(int i=0;i<alDispList.size();i+=4){
							
						if(i==0){
							
							dispNo.append((String)alDispList.get(1));
							
							if(alDispList.size()>1) 
								
							System.err.println("dispNo---1--"+dispNo);
						}else{
							if(i==(alDispList.size()-1)){
								dispNo.append((String)alDispList.get(i+1));
								System.err.println("dispNo----1-"+dispNo);
								
							}else{
								dispNo.append(",");
							
								dispNo.append((String)alDispList.get(i+1));
								
								System.err.println("dispNo---2--"+dispNo);
							}
							//SKR-scf-1734---ends----/
							
								/*for(String printSeqNo:seq_no_no_of_copies.keySet()){
								report	= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
								report.addParameter("p_report_id",p_report_id) ;
								report.addParameter("p_offline_print_seq_no",printSeqNo); 
								report.addParameter("p_user_name",p_user_name) ;
								report.addParameter("p_facility_id",p_facility_id) ;
								report.addParameter("p_module_id", "PH") ;
								report.addParameter("p_language_id", p_language_id) ;
								report.addParameter("p_patient_id",patient_id) ;

					//ArrayList disp_tmp_no=beanObj.getDispNoAgainstPrintSeqNo(printSeqNo); //added for SKR-SCF-1314 - start
					ArrayList disp_tmp_no=beanObj.getDispNoAgainstPrintSeqNo(printSeqNo,disp_stage); //added for SKR-SCF-1314 - start //SKR-scf-1734
 
					StringBuffer dispNo = new StringBuffer(); 
					for(int i=0;i<disp_tmp_no.size();i++){
									
						if(i==0){
							 
							dispNo.append((String)disp_tmp_no.get(0));
							if(disp_tmp_no.size()>1)  
								dispNo.append(",");
						}else{
							if(i==(disp_tmp_no.size()-1)){
								dispNo.append((String)disp_tmp_no.get(i));
								
							}else{
								dispNo.append((String)disp_tmp_no.get(i));
								dispNo.append(",");
										}*/
								
							
						}
					}
					
					report.addParameter("P2MULDISP",dispNo.toString()) ;//added for SKR-SCF-1314 - end
					onlineReports.add( report) ;
				}
			}
			ReportOutput = onlineReports.execute( request, response );
		}
		else if(validate.equals("UPDATEPRINTCOPIES")){//Added for Bru-HIMS-CRF-417[IN045565]
			String nofCopies					= (String) hash.get("nofCopies");
			String curr_disp_no					= (String) hash.get("curr_disp_no");
			String disp_srl_no					= (String) hash.get("disp_srl_no");
			ArrayList alDrugDispList			= beanObj.getDrugDispList();
			for(int i=0;i<alDrugDispList.size();i+=5){
				if(curr_disp_no.equals((String)alDrugDispList.get(i)) && disp_srl_no.equals((String)alDrugDispList.get(i+1))){
					alDrugDispList.set(i+4,nofCopies);
					break;
				}
			}
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
