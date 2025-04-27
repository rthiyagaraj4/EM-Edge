package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __instrusagediscrepancyunitsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/InstrUsageDiscrepancyUnitsValidate.jsp", 1729319177671L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            java.util.ArrayList alTrayDiscrepancyList= null;synchronized(session){
                alTrayDiscrepancyList=(java.util.ArrayList)pageContext.getAttribute("alTrayDiscrepancyList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alTrayDiscrepancyList==null){
                    alTrayDiscrepancyList=new java.util.ArrayList();
                    pageContext.setAttribute("alTrayDiscrepancyList",alTrayDiscrepancyList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	
	
		String bean_id						= request.getParameter("bean_id");
		String bean_name					= request.getParameter("bean_name");
		String validate						= request.getParameter("validate");

		String group_code				    =	request.getParameter("group_code");
		String group_desc				    =	request.getParameter("group_desc");
		String store_code				    =	request.getParameter("store_code");
		String tray_no					    =	request.getParameter("tray_no");
		String patient_id				    =	request.getParameter("patient_id");
		String patient_name				    =	request.getParameter("patient_name");
		String encounter_id				    =	request.getParameter("encounter_id");
		String item_code				    =	request.getParameter("item_code");
		String item_desc					=	request.getParameter("item_desc");
		String remarks						=	request.getParameter("remarks");
		String discrepancy_qty				=	request.getParameter("discrepancy_qty");
		String discrepancy_type				=	request.getParameter("discrepancy_type");
		String write_off_reason_desc		=	request.getParameter("write_off_reason_desc");
		String write_off_reason_code		=	request.getParameter("write_off_reason_code");
		String index						=	request.getParameter("index");
		String message						=	"";
		String flag							=	"";
		boolean	result						=	false;

		
	
		if ((bean_id == null) || (bean_id.equals("")))
		return;
		InstrUsageDiscrepancyUnitsDetailBean bean = (InstrUsageDiscrepancyUnitsDetailBean) getBeanObject(bean_id, bean_name,request);
		Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
		try
		{
		  if (validate.equals("STORE_CODE"))
					{
					
							bean.setStore_code(store_code);
					
					}
		  else	
				if (validate.equals("GROUP_DESC"))
					{
						bean.setStore_code(request.getParameter("store_code"));
						bean.setGroup_code(group_code);
						bean.setGroup_desc(group_desc);
					
					}
		else 
				if (validate.equals("POPULATE_DISCREPANCY")){
			
						ArrayList alParameters=new ArrayList(3);
						alParameters.add( bean.getOwnerStoreCode(store_code,tray_no,group_code));
						alParameters.add(group_code);
						alParameters.add(tray_no);
				
				if(bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_VALID_FOR_TRD"),alParameters).get("TOTAL").toString().equals("0")){
						throw new Exception("INVALID_TRAY_NO");
								}

						ArrayList alParameters1=new ArrayList(3);
						alParameters1.add(group_code);
						alParameters1.add(bean.getLanguageId());

						ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParameters1);
						for (int i=0; i<alRecords.size(); i++){
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					
					out.println(  "addListItem(\"parent.frameInstrUsageDiscrepancyUnitsDetail.document.forms[0].item_code\",\""+hmRecord.get("ITEM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					}
				
					

				alParameters=new ArrayList(3);
				alParameters.add(group_code);
				alParameters.add(tray_no);

				alRecords	=	bean.fetchRecords("SELECT dtl.STORE_CODE,dtl.group_code,dtl.tray_no,dtl.PATIENT_ID,dtl.ENCOUNTER_ID,dtl.item_code,  dtl.write_off_reason_code, wr.short_desc write_off_reason_desc, mm.short_desc item_desc, dtl.remarks, dtl.discrepancy_qty, discrepancy_type, dtl.charge_amt, dtl.usage_ind, dtl.finalized_yn FROM ss_discrepancy_dtl dtl, ss_write_off_reason wr, mm_item mm WHERE dtl.group_code=? AND dtl.tray_no=? AND dtl.item_code=mm.item_code AND dtl.write_off_reason_code=wr.write_off_reason_code",alParameters);

					for (int i=0; i<alRecords.size(); i++){

					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					hmRecord.put("item_code",			hmRecord.get("ITEM_CODE")				);
					hmRecord.put("discrepancy_qty",	hmRecord.get("DISCREPANCY_QTY")		);
					hmRecord.put("discrepancy_type",	hmRecord.get("DISCREPANCY_TYPE")		);
					hmRecord.remove("ITEM_CODE"				);
					hmRecord.remove("DISCREPANCY_TYPE"				);
					hmRecord.remove("DISCREPANCY_QTY");
					alTrayDiscrepancyList.add(hmRecord);
			}
			
				out.println("disableHeader();");//added for KDAH-SCF-0329
				result	=	true; 
				if(result)
				out.println("refreshList('"+result+"'); ");	
				message	=	"Done"+validate;
			}
		else	
			if (validate.equals("SEARCH_PATIENT")){
			
					 patient_name =  bean.getPatientName(patient_id);
				
			
				if ((patient_name == null) || (patient_name.trim().length() <=0)) {
					out.println("invalidPatientName();");
					return;
				}
				
		}
	else	
			if (validate.equals("PATIENT_NAME")){
			
					
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
		
				try{
				String encounterId = "";
				ArrayList alEncounterList = bean.getEncounterArrayList(patient_id);
				for(int i=0; i< alEncounterList.size(); i++) {
					HashMap record	=	(HashMap)alEncounterList.get(i);
					String listRecord	=	(String)record.get("ENCOUNTER_ID");
					
					out.println(  "addListItem(\"document.forms[0].encounter_id\",\""+listRecord+"\",\""+listRecord+"\");"  );
					}
					
				
				encounterId = null;
				result			=	true;
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
			
									
	}
				
	
		else	if (validate.equals("ADD_TO_LIST")){
			
					HashMap hmListItems	=	new HashMap();
				if(bean.isItemAndDiscrepancyInArrayList(alTrayDiscrepancyList,group_code,tray_no,item_code,write_off_reason_code,Integer.parseInt(index))){
						throw new Exception("RECORD_ALREADY_EXISTS");
									
				}
				
				if(remarks.length()>200)
						throw new Exception("REMARKS_EXCEEDS_MAX_LIMIT");
				if(index.equals("-1")){
				hmListItems.put("item_code",			item_code				);
				hmListItems.put("item_desc",			item_desc				);
				hmListItems.put("write_off_reason_code",write_off_reason_code	);
				hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
				hmListItems.put("remarks",				remarks					);
				hmListItems.put("discrepancy_qty",		discrepancy_qty			);
				hmListItems.put("discrepancy_type",		discrepancy_type		);
				hmListItems.put("patient_id",			patient_id				);
				hmListItems.put("patient_name",			patient_name			);
				hmListItems.put("encounter_id",			encounter_id			);
				hmListItems.put("group_desc",			group_desc				);
				hmListItems.put("group_code",			group_code				);
				hmListItems.put("tray_no",				tray_no					);
				hmListItems.put("store_code",			store_code				);
				hmListItems.put("usage_ind","O");
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alTrayDiscrepancyList.add(hmListItems);
				result	=	true;
				bean.setEncounter_id(encounter_id);
				
		
				out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.value=\""+""+"\"");
				out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.disabled=\""+"true"+"\"");
		
				if(result)	{	
					    out.println("refreshList('"+result+"'); ");	
						}
			}
			else{
			hmListItems.put("mode",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
			hmListItems.put("usage_ind",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("usage_ind"));
			hmListItems.put("finalized_yn",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("finalized_yn"));
			hmListItems.put("item_code",			item_code				);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("remarks",				remarks					);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_type",		discrepancy_type		);
			hmListItems.put("patient_id",			patient_id				);
			hmListItems.put("patient_name",			patient_name			);
			hmListItems.put("encounter_id",			encounter_id			);
			hmListItems.put("group_code",			group_code				);
			hmListItems.put("group_desc",			group_desc				);
			hmListItems.put("tray_no",				tray_no					);
			hmListItems.put("store_code",			store_code				);
			alTrayDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			result	=	true;
			bean.setEncounter_id(encounter_id);
			
			out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.disabled=\""+"true"+"\"");
			if(result)	{	
							out.println("refreshList('"+result+"'); ");
				
			}
				message	=	"Done";
			
			}
		}
			
	else if (validate.equals("EDIT_DETAIL")){
		
		String key = (String) hash.get("selected_key");
		
			if (key == null || (key.trim().equals(""))) {
				return;
			}
			String[] detail = bean.getDetail(key);
			out.println("var arrayObject = new Array();");
			out.println("arrayObject[0] = '"+bean.checkForNull(detail[0])+"';");
			out.println("arrayObject[1] = '"+bean.checkForNull(detail[2])+"';");
			out.println("arrayObject[2] = '"+bean.checkForNull(detail[4])+"';");
			out.println("arrayObject[3] = '"+bean.checkForNull(detail[5])+"';");
			out.println("arrayObject[4] = '"+bean.checkForNull(detail[7])+"';");
			out.println("arrayObject[5] = '"+bean.checkForNull(detail[8])+"';");
			out.println("arrayObject[6] = '"+bean.checkForNull(detail[9])+"';");
			out.println("editDetail(arrayObject);");
		}
		
	
	
	}
	catch(Exception e)
	{
		
		result	=	false;
		message	=	e.getMessage();
		System.out.println("======message=========>"+message);
		
	}
	finally{
	
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
	putObjectInBean( bean_id,bean,request);

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
