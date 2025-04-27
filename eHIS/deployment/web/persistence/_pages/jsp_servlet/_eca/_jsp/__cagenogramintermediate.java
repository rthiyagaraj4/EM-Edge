package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cagenogramintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAGenogramIntermediate.jsp", 1741274549585L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
18/11/2013	IN044838		Ramesh G		Find that, it enables a section 'Family Member Relation Type' and displays 
											the previously selected member relation details for this index patient as well. 
--------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql			= "";
String locale 		= "";
try {
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale 	= (String) p.getProperty("LOCALE");
		
	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	String condition = hash.get("condition")==null?"":(String)hash.get("condition");
	String patient_id = hash.get("patient_id")==null?"":(String)hash.get("patient_id");
	String non_patient_id = hash.get("non_patient_id")==null?"":(String)hash.get("non_patient_id");
	String srlNo = hash.get("srlNo")==null?"":(String)hash.get("srlNo");
	
	if("GETPATIENTDTLS".equals(condition)){
		String condition1 = hash.get("condition1")==null?"":(String)hash.get("condition1"); 
		String condition2 = hash.get("condition2")==null?"":(String)hash.get("condition2");
		sql = "SELECT PATIENT_NAME, SEX, TO_CHAR (DATE_OF_BIRTH, 'DD/MM/YYYY') DATE_OF_BIRTH,DECEASED_YN,DECODE(DECEASED_YN,'N','',TO_CHAR (DECEASED_DATE, 'DD/MM/YYYY')) DECEASED_DATE,DEATH_STATUS_REMARKS DECEASED_REMARKS FROM MP_PAT_DTLS_VW WHERE PATIENT_ID =?"; 
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, patient_id);
		
		rs	= pstmt.executeQuery() ;
		StringBuffer sb = new StringBuffer();
		if(rs.next()){
			if("COUPLE".equals(condition1)){
				sb.append("document.getElementById('rec_patient_name').value=\""+(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"))+"\";");
				sb.append("document.getElementById('date_of_birth').value=\""+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"\";");
				sb.append("document.getElementById('gender').value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				sb.append("document.getElementById('deceasedDate').value=\""+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"\";");
				sb.append("document.getElementById('deceased_remarks').value=\""+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"\";");
				sb.append("document.getElementById('gender_hidden').value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				
				sb.append("document.getElementById('rec_patient_name').readOnly =true;");
				sb.append("document.getElementById('date_of_birth').readOnly =true;");
				sb.append("document.getElementById('dofimg').disabled =true;");
				sb.append("document.getElementById('gender').disabled = true;");
				sb.append("document.getElementById('deceasedDate').readOnly =true;");
				sb.append("document.getElementById('ddimg').disabled =true;");
				sb.append("document.getElementById('deceased_remarks').readOnly =true;");
			}else if("FA".equals(condition1)){
				String faGender =(rs.getString("SEX")==null?"":(String)rs.getString("SEX"));
				if("M".equals(faGender)){
					sb.append("document.getElementById('rec_patient_nameFa').value=\""+(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"))+"\";");
					sb.append("document.getElementById('date_of_birthFa').value=\""+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"\";");
					sb.append("document.getElementById('deceasedDateFa').value=\""+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"\";");
					sb.append("document.getElementById('deceased_remarksFa').value=\""+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"\";");
							
					sb.append("document.getElementById('rec_patient_nameFa').readOnly =true;");
					sb.append("document.getElementById('date_of_birthFa').readOnly =true;");
					sb.append("document.getElementById('dofimgFa').disabled =true;");
					sb.append("document.getElementById('deceasedDateFa').readOnly =true;");
					sb.append("document.getElementById('ddimgFa').disabled =true;");
					sb.append("document.getElementById('deceased_remarksFa').readOnly =true;");
				}else{
					sb.append("alert(\"Father\'s Gender should be Male.\");");
					if(!"".equals(patient_id) && patient_id!=null){
						sb.append("document.getElementById('rec_patient_idFa').select();");
					}
				}
			
			}else if("MO".equals(condition1)){
				String faGender =(rs.getString("SEX")==null?"":(String)rs.getString("SEX"));
				if("F".equals(faGender)){
					sb.append("document.getElementById('rec_patient_nameMo').value=\""+(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"))+"\";");
					sb.append("document.getElementById('date_of_birthMo').value=\""+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"\";");
					sb.append("document.getElementById('deceasedDateMo').value=\""+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"\";");
					sb.append("document.getElementById('deceased_remarksMo').value=\""+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"\";");
							
					sb.append("document.getElementById('rec_patient_nameMo').readOnly =true;");
					sb.append("document.getElementById('date_of_birthMo').readOnly =true;");
					sb.append("document.getElementById('dofimgMo').disabled =true;");
					sb.append("document.getElementById('deceasedDateMo').readOnly =true;");
					sb.append("document.getElementById('ddimgMo').disabled =true;");
					sb.append("document.getElementById('deceased_remarksMo').readOnly =true;");
				}else{
					sb.append("alert(\"Mother\'s Gender should be Female.\");");
					if(!"".equals(patient_id) && patient_id!=null){
						sb.append("document.getElementById('rec_patient_idMo').select();");
					}
				}
			}else if("CHILD".equals(condition1)){
			
				sb.append("document.getElementById('rec_patient_nameCh')"+condition2+".value=\""+(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"))+"\";");
				sb.append("document.getElementById('date_of_birthCh')"+condition2+".value=\""+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"\";");
				sb.append("document.getElementById('genderCh')"+condition2+".value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				sb.append("document.getElementById('deceasedDateCh')"+condition2+".value=\""+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"\";");
				sb.append("document.getElementById('deceased_remarksCh')"+condition2+".value=\""+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"\";");
				sb.append("document.getElementById('gender_hiddenCh')"+condition2+".value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				
				sb.append("document.getElementById('rec_patient_nameCh"+condition2+"').readOnly =true;");
				sb.append("document.getElementById('date_of_birthCh"+condition2+"').readOnly =true;");
				sb.append("document.getElementById('dofimgCh"+condition2+"').disabled =true;");
				sb.append("document.getElementById('genderCh')"+condition2+".disabled = true;");
				sb.append("document.getElementById('deceasedDateCh"+condition2+"').readOnly =true;");
				sb.append("document.getElementById('ddimgCh"+condition2+"').disabled =true;");
				sb.append("document.getElementById('deceased_remarksCh"+condition2+"').readOnly =true;");
			
			}else if("MODIFYDTLS".equals(condition1)){
			
				sb.append("document.getElementById('rec_patient_nameModify').value=\""+(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"))+"\";");
				sb.append("document.getElementById('date_of_birthModify').value=\""+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"\";");
				sb.append("document.getElementById('genderModify').value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				sb.append("document.getElementById('deceasedDateModify').value=\""+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"\";");
				sb.append("document.getElementById('deceased_remarksModify').value=\""+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"\";");
				sb.append("document.getElementById('gender_hiddenModify').value=\""+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"\";");
				
				sb.append("document.getElementById('rec_patient_nameModify').readOnly =true;");
				sb.append("document.getElementById('date_of_birthModify').readOnly =true;");
				sb.append("document.getElementById('dofimgModify').disabled =true;");
				sb.append("document.getElementById('genderModify').disabled = true;");
				sb.append("document.getElementById('deceasedDateModify').readOnly =true;");
				sb.append("document.getElementById('ddimgModify').disabled =true;");
				sb.append("document.getElementById('deceased_remarksModify').readOnly =true;");
			
			}
			
		}else{
			if("COUPLE".equals(condition1)){
				sb.append("document.getElementById('rec_patient_name').value='';");
				sb.append("document.getElementById('date_of_birth').value='';");
				sb.append("document.getElementById('gender').value='';");
				sb.append("document.getElementById('deceasedDate').value='';");
				sb.append("document.getElementById('deceased_remarks').value='';");
				sb.append("document.getElementById('gender_hidden').value='';");
				sb.append("document.getElementById('rec_patient_name').readOnly =false;");
				sb.append("document.getElementById('date_of_birth').readOnly =false;");
				sb.append("document.getElementById('dofimg').disabled =false;");
				sb.append("document.getElementById('gender').disabled = false;");
				sb.append("document.getElementById('deceasedDate').readOnly =false;");
				sb.append("document.getElementById('ddimg').disabled =false;");
				sb.append("document.getElementById('deceased_remarks').readOnly =false;");
				if(!"".equals(patient_id) && patient_id!=null){
					sb.append("document.getElementById('rec_patient_id').select();");
				}
				
			}else if("FA".equals(condition1)){
				sb.append("document.getElementById('rec_patient_nameFa').value='';");
				sb.append("document.getElementById('date_of_birthFa').value='';");
				sb.append("document.getElementById('deceasedDateFa').value='';");
				sb.append("document.getElementById('deceased_remarksFa').value='';");
						
				sb.append("document.getElementById('rec_patient_nameFa').readOnly =false;");
				sb.append("document.getElementById('date_of_birthFa').readOnly =false;");
				sb.append("document.getElementById('dofimgFa').disabled =false;");
				sb.append("document.getElementById('deceasedDateFa').readOnly =false;");
				sb.append("document.getElementById('ddimgFa').disabled =false;");
				sb.append("document.getElementById('deceased_remarksFa').readOnly =false;");
				if(!"".equals(patient_id) && patient_id!=null){
					sb.append("document.getElementById('rec_patient_idFa').select();");
				}
			}else if("MO".equals(condition1)){
				sb.append("document.getElementById('rec_patient_nameMo').value='';");
				sb.append("document.getElementById('date_of_birthMo').value='';");
				sb.append("document.getElementById('deceasedDateMo').value='';");
				sb.append("document.getElementById('deceased_remarksMo').value='';");
						
				sb.append("document.getElementById('rec_patient_nameMo').readOnly =false;");
				sb.append("document.getElementById('date_of_birthMo').readOnly =false;");
				sb.append("document.getElementById('dofimgMo').disabled =false;");
				sb.append("document.getElementById('deceasedDateMo').readOnly =false;");
				sb.append("document.getElementById('ddimgMo').disabled =false;");
				sb.append("document.getElementById('deceased_remarksMo').readOnly =false;");
				if(!"".equals(patient_id) && patient_id!=null){
					sb.append("document.getElementById('rec_patient_idMo').select();");
				}
			
			}else if("CHILD".equals(condition1)){
				sb.append("document.getElementById('rec_patient_nameCh')"+condition2+".value='';");
				sb.append("document.getElementById('date_of_birthCh')"+condition2+".value='';");
				sb.append("document.getElementById('genderCh')"+condition2+".value='';");
				sb.append("document.getElementById('deceasedDateCh')"+condition2+".value='';");
				sb.append("document.getElementById('deceased_remarksCh')"+condition2+".value='';");
				sb.append("document.getElementById('gender_hiddenCh')"+condition2+".value='';");
				
				sb.append("document.getElementById('rec_patient_nameCh"+condition2+"').readOnly =false;");
				sb.append("document.getElementById('date_of_birthCh"+condition2+"').readOnly =false;");
				sb.append("document.getElementById('dofimgCh"+condition2+"').disabled =false;");
				sb.append("document.getElementById('genderCh')"+condition2+".disabled = false;");
				sb.append("document.getElementById('deceasedDateCh"+condition2+"').readOnly =false;");
				sb.append("document.getElementById('ddimgCh"+condition2+"').disabled =false;");
				sb.append("document.getElementById('deceased_remarksCh"+condition2+"').readOnly =false;");
				if(!"".equals(patient_id) && patient_id!=null){
					sb.append("document.getElementById('rec_patient_idCh')"+condition2+".select();");
				}
			
			}else if("MODIFYDTLS".equals(condition1)){
			
				sb.append("document.getElementById('rec_patient_nameModify').value='';");
				sb.append("document.getElementById('date_of_birthModify').value='';");
				sb.append("document.getElementById('genderModify').value='';");
				sb.append("document.getElementById('deceasedDateModify').value='';");
				sb.append("document.getElementById('deceased_remarksModify').value='';");
				sb.append("document.getElementById('gender_hiddenModify').value='';");
				
				sb.append("document.getElementById('rec_patient_nameModify').readOnly =false;");
				sb.append("document.getElementById('date_of_birthModify').readOnly =false;");
				sb.append("document.getElementById('dofimgModify').disabled =false;");
				sb.append("document.getElementById('genderModify').disabled = false;");
				sb.append("document.getElementById('deceasedDateModify').readOnly =false;");
				sb.append("document.getElementById('ddimgModify').disabled =false;");
				sb.append("document.getElementById('deceased_remarksModify').readOnly =false;");
				if(!"".equals(patient_id) && patient_id!=null){
					sb.append("document.getElementById('rec_patient_idModify').select();");
				}
			
			}
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		out.println(sb.toString());
	}else if("GETNONPATIENTDTLS".equals(condition)){
		sql = "SELECT A.PATIENT_ID,A.NAME,A.SEX,TO_CHAR(A.DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,A.DECEASED_YN,TO_CHAR(A.DECEASED_DATE,'DD/MM/YYYY') DECEASED_DATE,A.DECEASED_REMARKS,B.FROM_GENOID,B.RELATION_TYPE_ID,B.RELATION_ID, TO_CHAR(B.REL_START_DATE,'DD/MM/YYYY') REL_START_DATE, B.SIBLNG_POS,B.LINE_SRL_NO FROM CA_GENOGRAM_ATTRIBUTE A LEFT JOIN CA_GENOGRAM_RELATION B ON A.GENO_ID = B.GENO_ID AND A.SRL_NO = B.SRL_NO AND A.NON_PATIENT_ID=B.TO_GENOID WHERE A.SRL_NO = ? AND A.NON_PATIENT_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, srlNo);
		pstmt.setString(2, non_patient_id);
		rs	= pstmt.executeQuery() ;
		StringBuffer sb = new StringBuffer(); 
		if(rs.next()){
			String patientID=rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID");
		
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('rec_patient_idModify').value='"+patientID+"';");
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('rec_patient_nameModify').value='"+(rs.getString("NAME")==null?"":(String)rs.getString("NAME"))+"';");
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('date_of_birthModify').value='"+(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"))+"';");
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('genderModify').value='"+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"';");
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('gender_hiddenModify').value='"+(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))+"';");
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('mode').value='MODIFY';");
			String deceaseYN = rs.getString("DECEASED_YN")==null?"":(String)rs.getString("DECEASED_YN");
			if("Y".equals(deceaseYN)){
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceasedDateModify').value='"+(rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE"))+"';");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceased_remarksModify').value='"+(rs.getString("DECEASED_REMARKS")==null?"":(String)rs.getString("DECEASED_REMARKS"))+"';");
			}else{                                                                    
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceasedDateModify').value='';");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceased_remarksModify').value='';");
			}
			if(!"".equals(patientID)){
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('rec_patient_nameModify').readOnly =true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('date_of_birthModify').readOnly =true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('dofimgModify').disabled =true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('genderModify').disabled = true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceasedDateModify').readOnly =true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('ddimgModify').disabled =true;");
				sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('deceased_remarksModify').readOnly =true;");
			}
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		
		sql = "SELECT A.RELATION_ID,TO_CHAR(A.REL_START_DATE,'DD/MM/YYYY') REL_START_DATE,(SELECT C.SRL_NO FROM CA_GENOGRAM_RELATION C WHERE C.TO_GENOID=A.FROM_GENOID AND ROWNUM=1) SRL_NO,A.FROM_GENOID,(SELECT B.NAME FROM CA_GENOGRAM_ATTRIBUTE B WHERE B.NON_PATIENT_ID=A.FROM_GENOID) NAME FROM CA_GENOGRAM_RELATION A WHERE TO_GENOID=? AND RELATION_TYPE_ID='COUPLE'";
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, non_patient_id);
		rs	= pstmt.executeQuery() ;
		StringBuffer sb1 = new StringBuffer();
		int i=0;
		while(rs.next()){
			if(i!=0)
				sb1.append("|");
			
			sb1.append((rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID"))).append("~");
			sb1.append((rs.getString("FROM_GENOID")==null?"":(String)rs.getString("FROM_GENOID"))).append("~");
			sb1.append((rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO"))).append("~");
			sb1.append((rs.getString("REL_START_DATE")==null?"":(String)rs.getString("REL_START_DATE"))).append("~");
			sb1.append((rs.getString("NAME")==null?"&nbsp;":(String)rs.getString("NAME")));
			i++;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		if(!"".equals(sb1.toString())){
			sb.append("assignRelationValueModify(\""+sb1.toString()+"\");");
		}else{
			sb.append("parent.genogramAddFamilyMemberFram.document.getElementById('modifyRelationFieldSet').style.display='none';");
		}
		out.println(sb.toString());
	}else if("GENONONPATIENTFAMILYDTLS".equals(condition)){
		sql = " SELECT A.GENO_ID,A.SRL_NO,A.PATIENT_ID,A.NON_PATIENT_ID,A.NAME,A.SEX,DECODE(A.SEX, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') SEX_DESC,A.DATE_OF_BIRTH,CA_GET_AGE(A.DATE_OF_BIRTH,SYSDATE,'YMD') AGE,A.DECEASED_YN,TO_CHAR(A.DECEASED_DATE,'DD/MM/YYYY') DECEASED_DATE,A.DECEASED_REMARKS,(SELECT RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_TYPE_ID=C.RELATION_TYPE_ID AND RELTN_ID=C.RELATION_ID) RELATION ,(SELECT NAME FROM CA_GENOGRAM_ATTRIBUTE D WHERE D.NON_PATIENT_ID=C.FROM_GENOID) RELATIONWITH FROM CA_GENOGRAM_ATTRIBUTE A INNER JOIN CA_GENOGRAM_ATTRIBUTE B ON A.GENO_ID = B.GENO_ID LEFT JOIN CA_GENOGRAM_RELATION C ON A.GENO_ID = C.GENO_ID AND B.GENO_ID=C.GENO_ID AND A.SRL_NO=C.SRL_NO AND A.NON_PATIENT_ID=C.TO_GENOID AND C.REL_REV_FLAG ='N' WHERE B.NON_PATIENT_ID=? ORDER BY A.SRL_NO";		
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, non_patient_id);
		rs	= pstmt.executeQuery() ;
		StringBuffer sb = new StringBuffer();
		int i=0;
		while(rs.next()){ 
			if(i!=0)
				sb.append("|");			
			sb.append((rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO"))).append("~");
			sb.append((rs.getString("PATIENT_ID")==null?"&nbsp;":(String)rs.getString("PATIENT_ID"))).append("~");
			sb.append((rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID"))).append("~");
			sb.append((rs.getString("NAME")==null?"":(String)rs.getString("NAME"))).append("~");			
			sb.append((rs.getString("SEX_DESC")==null?"":(String)rs.getString("SEX_DESC"))).append("~");
			sb.append((rs.getString("AGE")==null?"":(String)rs.getString("AGE"))).append("~");
			sb.append((rs.getString("DECEASED_DATE")==null?"&nbsp;":(String)rs.getString("DECEASED_DATE"))).append("~");
			sb.append((rs.getString("RELATION")==null?"&nbsp;":(String)rs.getString("RELATION"))).append("~");
			sb.append((rs.getString("RELATIONWITH")==null?"&nbsp;":(String)rs.getString("RELATIONWITH"))).append("~");
			sb.append((rs.getString("SEX")==null?"&nbsp;":(String)rs.getString("SEX"))).append("~");
			sb.append((rs.getString("GENO_ID")==null?"":(String)rs.getString("GENO_ID")));
			i++;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		out.println("getOldGenogramDetails('"+sb.toString()+"');");
	}else if("GETRELATIONCOMBOVALUES".equals(condition)){
		String relTypeId = hash.get("relTypeId")==null?"":(String)hash.get("relTypeId");
		sql = "SELECT RELTN_ID,RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_TYPE_ID=? AND EFF_STATUS='E'";
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, relTypeId);
		rs	= pstmt.executeQuery() ;
		StringBuffer sb = new StringBuffer();
		int i=0;
		while(rs.next()){
			if(i!=0)
				sb.append("|");
			
			sb.append((rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID"))).append("~");
			sb.append((rs.getString("RELTN_DESC")==null?"&nbsp;":(String)rs.getString("RELTN_DESC")));
			i++;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		out.println(sb.toString());
	
	}else if("NONPATIENTCOUPLEDTLS".equals(condition)){ 
		String geno_id = hash.get("geno_id")==null?"":(String)hash.get("geno_id");
		sql = "SELECT A.NON_PATIENT_ID,A.SRL_NO,A.NAME,A.SEX,(SELECT RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_ID=B.RELATION_ID) RELATION FROM CA_GENOGRAM_ATTRIBUTE A,CA_GENOGRAM_RELATION B WHERE A.GENO_ID=B.GENO_ID AND A.SRL_NO = B.SRL_NO AND B.RELATION_TYPE_ID='COUPLE' AND B.GENO_ID=? AND B.FROM_GENOID=?";
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, geno_id);
		pstmt.setString(2, non_patient_id);
		rs	= pstmt.executeQuery() ;
		StringBuffer sb = new StringBuffer();
		sb.append("");
		int i=0;
		while(rs.next()){
			if(i!=0)
				sb.append("|");			
			sb.append((rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID"))).append("~");
			sb.append((rs.getString("SEX")==null?"":(String)rs.getString("SEX"))).append("~");
			sb.append((rs.getString("NAME")==null?"":(String)rs.getString("NAME"))).append("~");			
			sb.append((rs.getString("RELATION")==null?"&nbsp;":(String)rs.getString("RELATION"))).append("~");
			sb.append((rs.getString("SRL_NO")==null?"&nbsp;":(String)rs.getString("SRL_NO")));
			i++;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		out.println(sb.toString());
	}else if("GETVALIDATIONESI".equals(condition)){ 
		String fromRelation = hash.get("fromRelation")==null?"":(String)hash.get("fromRelation");
		String toRelation = hash.get("toRelation")==null?"":(String)hash.get("toRelation");
		sql = "SELECT COUNT(*) RECCOUNT FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID IN ('EMOTION','SOCIAL','INTER') AND  FROM_GENOID=? AND TO_GENOID=?";
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, fromRelation);
		pstmt.setString(2, toRelation);
		rs	= pstmt.executeQuery() ;
		
		if(rs.next()){			
			out.println((rs.getString("RECCOUNT")==null?"0":(String)rs.getString("RECCOUNT")));
		}else{
			out.println("0");
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		
	}else if("GETVALIDATIONMH".equals(condition)){ 
		String fromRelation = hash.get("fromRelation")==null?"":(String)hash.get("fromRelation");
		String relationId = hash.get("relationId")==null?"":(String)hash.get("relationId");
		
		if("SU".equals(relationId)||"CA".equals(relationId)||"IR".equals(relationId)){
			sql = "SELECT NVL((SELECT  COUNT(*) FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='MH' AND RELATION_ID IN ('SU','CA','IR') AND FROM_GENOID=? ),'0') RECCOUNT FROM DUAL";
		}else{
			sql ="SELECT NVL((SELECT  COUNT(*) FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='MH' AND FROM_GENOID=? AND RELATION_ID =? ),'0') RECCOUNT FROM DUAL";
		}
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, fromRelation);
		if(!"SU".equals(relationId)&&!"CA".equals(relationId)&& !"IR".equals(relationId)){
			pstmt.setString(2, relationId);
		}
		rs	= pstmt.executeQuery() ;
		if(rs.next()){
			out.println((rs.getString("RECCOUNT")==null?"0":(String)rs.getString("RECCOUNT")));
		}else{
			out.println("0");
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		
	}
	
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
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
