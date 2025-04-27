
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.binary.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.XMLStringParser;

/**
 * Servlet implementation class CATabInsuranceServlet
 */
public class CATabInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	String sql = "";
	String result = "";
	PreparedStatement pstmt1 = null;
	private static final AtomicInteger count = new AtomicInteger(0);
	int id;
	int resultCount;
    public CATabInsuranceServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XMLStringParser obj	=null;
		obj=new XMLStringParser();
		Map hash = (Map)obj.parseXMLString( request ) ;
		hash = (Map)hash.get("SEARCH") ;
		out = response.getWriter();
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String p_report_id = (String)hash.get("p_report_id");
		String facility_id = (String)hash.get("facility_id");
		String added_by_id = (String)hash.get("added_by_id");
		String added_at_ws_no = (String)hash.get("added_at_ws_no");
		oracle.sql.BLOB myBlob = null;

		result = (String)hash.get("result");
		try {
			con = ConnectionManager.getConnection();
				String countSql = "select COUNT (*) COUNT from CA_PAT_INSU_SIGNATURE where patient_id = ? and encounter_id = ? and report_id = ?";
				pstmt = con.prepareStatement(countSql);
				pstmt.setString(1, patient_id);
				pstmt.setString(2, encounter_id);
				pstmt.setString(3, p_report_id);
				rs	=	pstmt.executeQuery();
				if(rs.next()){
					resultCount=Integer.parseInt(rs.getString("COUNT"));	
				}
				if(rs !=null) rs.close();//15950
				if(pstmt != null);//15950
				pstmt.close();//15950
				if(resultCount>0){
				String sql = "update CA_PAT_INSU_SIGNATURE SET SIGNATURE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,SIGNATURE_BLOB=?  WHERE patient_id = ? and encounter_id = ? and report_id = ?";	
				pstmt = con.prepareStatement(sql);
				pstmt.setCharacterStream(1, new StringReader(result), result.length());
				pstmt.setString(2, added_by_id);//MODIFIED_BY_ID 
				pstmt.setString(3, added_at_ws_no);//MODIFIED_AT_WS_NO  
				pstmt.setString(4, facility_id);//MODIFIED_FACILITY_ID  
				myBlob = oracle.sql.BLOB.createTemporary(con, false,oracle.sql.BLOB.DURATION_SESSION);
				byte[] decodedString = Base64.decodeBase64(new String(result).getBytes("UTF-8"));
				myBlob.putBytes(1, decodedString);
				pstmt.setBlob(5, myBlob);
				pstmt.setString(6, patient_id);
				pstmt.setString(7, encounter_id);
				pstmt.setString(8, p_report_id);
				pstmt.addBatch();
				pstmt.executeBatch();
				if(pstmt != null)//Common-ICN-0092  
				pstmt.close();//Common-ICN-0092  
				}
				else{
					String sql = "insert into CA_PAT_INSU_SIGNATURE values(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, patient_id);//1
					pstmt.setString(2, encounter_id);//2
					pstmt.setString(3, p_report_id);//3
					pstmt.setCharacterStream(4, new StringReader(result), result.length());//4
					pstmt.setString(5, added_by_id);//5 added by id
					pstmt.setString(6, added_at_ws_no);//7 added_by_ws_no
					pstmt.setString(7, facility_id);//8 facility id
					pstmt.setString(8, added_by_id);//9 added by id
					pstmt.setString(9, added_at_ws_no);//11 added_by_ws_no
					pstmt.setString(10, facility_id);//12 facility id
					myBlob = oracle.sql.BLOB.createTemporary(con, false,oracle.sql.BLOB.DURATION_SESSION);
					byte[] decodedString = Base64.decodeBase64(new String(result).getBytes("UTF-8"));
					myBlob.putBytes(1, decodedString);
					pstmt.setBlob(11, myBlob);
					pstmt.addBatch();
					pstmt.executeBatch();
					if(pstmt != null)//Common-ICN-0092  
					pstmt.close();//Common-ICN-0092  
					
				}
				int row  = 1;
				if(row > 0) {
				System.out.println("Image inserted");
				con.commit();
				out.println("viewImage('"+patient_id+"','"+encounter_id+"','"+p_report_id+"')");
			}else {
				System.out.println("Not Inserted");
				con.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in saving Signature: " + e);
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null) {
				ConnectionManager.returnConnection(con, request);
			}
		}
	}
	
}
