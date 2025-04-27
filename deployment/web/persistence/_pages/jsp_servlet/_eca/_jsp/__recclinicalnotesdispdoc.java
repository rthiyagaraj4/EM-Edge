package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import eCA.*;
import eCA.RecClinicalNotesMultiFileUploadBean.NoteDoc;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotesdispdoc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesDispDoc.jsp", 1709115226478L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\n\t\t\t\t//alert(\"Unkown Error len = ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" , contentType = ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" , in = ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  --------------> add to msg\");\n\t\t\t\tparent.window.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
	
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
------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------
14/11/2016    IN061736     Raja S                                           BSP-SCF-0008
07/07/2018   IN066677       Ramesh Goli        10/07/2018        Ramesh G           ML-MMOH-CRF-1099
19/05/2020	IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
13/12/2022	37958			Ramesh Goli		13/12/2022		Ramesh G			ML-MMOH-CRF-1977
04/07/2023	34798			Twinkle 		04/07/2023		Ramesh G			MO-GN-5573

-------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	String fileName = request.getParameter("fileName")==null?"":request.getParameter("fileName");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String file_seq_no = request.getParameter("file_seq_no")==null?"":request.getParameter("file_seq_no");
	RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;
	InputStream in = fbean.getFileInputStream(fileName);
	long len = fbean.getFileSize(fileName);
	String contentType = fbean.getFileType(fileName);
	if((accession_num.equals("") && note_type.equals("")))
	{
		if(in != null && len != -1 && contentType != null)
			{
			response.setContentType(contentType);
			String[] objArray =contentType.split("\\/");
			//IN061736 starts
			if("image".equals(objArray[0])){
				byte[] by = new byte[(int)len]; 
				int index = in.read(by, 0, (int)len);  
	   		    response.reset();  
				response.setContentType(contentType);  
				response.getOutputStream().write(by, 0, (int)len);  
				response.getOutputStream().flush(); 
			}
			else{
			//IN061736 issue ends
			Buffout = new BufferedOutputStream( response.getOutputStream() );
			byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
			int index = in.read(by , 0 , (int)len);

			while(index != -1)
			{
				Buffout.write(by , 0, index);
				index = in.read ( by , 0 , (int)len );
			}
			Buffout.flush();
			}//Added for IN061736 
		}
		else
		{
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(len));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(contentType));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((in != null)));
            _bw.write(_wl_block7Bytes, _wl_block7);
}	
	}
	else
	{
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement psDataMigration = null; //IN066677
		ResultSet rs = null;
		ResultSet rsDataMigration = null; //IN066677
		String qryPathForMigrationNote = "";  //IN066677
		String migrationDataPathName = "";   //IN066677

		try
		{
			con = ConnectionManager.getConnection(request);
			// IN066677 Start.
			//String qryHistData = "select OBJTYPE, HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";
			//IN070345 Start.
			//String qryHistData = "select OBJTYPE, HIST_DATA,NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN,FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";//IN066677
			//37958 Start
			//String qryHistData = "select OBJTYPE, HIST_DATA, NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN, FILE_NAME, SHARED_FILE_PATH, SHARED_FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";//IN066677
			String qryHistData = "select OBJTYPE, HIST_DATA, NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN, FILE_NAME, SHARED_FILE_PATH, SHARED_FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? /*and CONTR_SYS_EVENT_CODE = ?*/ and FILE_SEQ_NO = ?";//IN066677
			
			//37958End.
			//IN070345 End.
			//IN066677 End.
			pst = con.prepareStatement(qryHistData);
			pst.setString(1, accession_num);
			////37958 Start.
			//pst.setString(2, note_type);
			//pst.setString(3, file_seq_no);
			pst.setString(2, file_seq_no);
			//37958 End.
			rs = pst.executeQuery();
 
			while(rs.next())
			{
			//IN061736 changes Starts
				String[] objArray =((String)rs.getString("OBJTYPE")).split("\\/");
				String dataMigrationYN = (String)rs.getString("DATA_MIGRATION_YN"); //IN066677
				String sharedFilePath = rs.getString("SHARED_FILE_PATH")==null?"":(String)rs.getString("SHARED_FILE_PATH"); //IN070345
				String sharedFileName = rs.getString("SHARED_FILE_NAME")==null?"":(String)rs.getString("SHARED_FILE_NAME"); //IN070345
			if("image".equals(objArray[0])){
				//IN070345 Start.
				InputStream readImg =null;
				long len1=0;
				if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){				
					File file =new File(sharedFilePath+"/"+sharedFileName);
					if(file.exists()){
						readImg = new FileInputStream(file);
						len1 = file.length();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						readImg = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len1 = errorMsg.length();
					}
				}else{
				//IN070345 End.
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");        	 
					len1 = hist_blob.length(); 					  
					readImg = hist_blob.getBinaryStream();  
				} //IN070345
				byte[] by = new byte[(int)len1]; 
				int index = readImg.read(by, 0, (int)len1);					
				response.reset();  
				response.setContentType(rs.getString("OBJTYPE"));  
				response.getOutputStream().write(by, 0, (int)len1);  
				response.getOutputStream().flush();  
			}
			else if("Y".equals(dataMigrationYN) && "application".equals(objArray[0]) && "msword".equals(objArray[1])){
				try{
					qryPathForMigrationNote = "SELECT PATH_FOR_MIGRATION_NOTES FROM CA_NOTE_PARAM";
					psDataMigration = con.prepareStatement(qryPathForMigrationNote);
					rsDataMigration = psDataMigration.executeQuery();
					if(rsDataMigration.next()) {	
						migrationDataPathName = (String)rsDataMigration.getString("PATH_FOR_MIGRATION_NOTES");
					}
					System.out.println("migrationDataPathName=>"+migrationDataPathName);
					fileName = (String)rs.getString("FILE_NAME");						
					String fileFullPath			=	migrationDataPathName+fileName;
					
					File file = null;			
					InputStream inpStrem = null;		
					
					file = new File(fileFullPath);								
					if(file.exists()){
						
						int  fileSize=(int)file.length();					
						inpStrem=new FileInputStream(file);
						byte[] byArray = new byte[(int)fileSize];
						response.reset();								
						response.setContentType((String)rs.getString("OBJTYPE"));
						while((fileSize=inpStrem.read(byArray))!= -1 )
						{
						response.getOutputStream().write(byArray,0,fileSize);
						}
						response.flushBuffer();
						inpStrem.close();					
					}
				}catch(Exception e){

					e.printStackTrace();
				}finally{
					if(rsDataMigration!=null)
						rsDataMigration.close();
					if(psDataMigration!=null)
						psDataMigration.close();
				}
				//IN066677 End
				
			}
			else{
			//IN061736 Changes Ends	
				//IN070345 Start.
				if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){				
					File file =new File(sharedFilePath+"/"+sharedFileName);
					if(file.exists()){
						in = new FileInputStream(file);
						len = file.length();
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);
						response.setContentType((String)rs.getString("OBJTYPE")); //34798
						while( index != -1) 
						{
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
						}
						Buffout.flush();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						in = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len = errorMsg.length();
						
						byte[] by = new byte[(int)len]; 
						int index = in.read(by, 0, (int)len);					
						response.reset();  
						response.setContentType("image/pjpeg");  
						response.getOutputStream().write(by, 0, (int)len);  
						response.getOutputStream().flush(); 
					}
				}else{
				//IN070345 End.
					response.setContentType(rs.getString("OBJTYPE"));
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");
					in = hist_blob.getBinaryStream();
					len = hist_blob.length();
					
					Buffout = new BufferedOutputStream( response.getOutputStream() );
					byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
					int index = in.read(by , 0 , (int)len);

					while( index != -1) 
					{
						Buffout.write(by , 0, index);
						index = in.read ( by , 0 , (int)len );
					}
					Buffout.flush();
				}//IN070345
				
			} //Added closing braces for IN061736 	
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
			ConnectionManager.returnConnection(con,request);
		}
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
