
package eBL;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import webbeans.eCommon.ConnectionManager;
import eBL.Common.BLHelper;
import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;

/**
 * 
 * Fetch data from tables for Modify screen 
 */
public class BLCreditCardBean extends BlAdapter implements Serializable
{
	
	//JSP label Names
	public static final String COMPANY_CODE = "companyCode";
	public static final String COMPANY_NAME = "companyName";
	public static final String BRANCH_NAME = "branchName";
	
	//Common labels 
	public static final String NEW_ROW = "newRow";
	
	
	
	private String companyCode;
	private String companyName;
	private String branchName;
	private String newRow;



	public void clearBean()
	{
		
	}

	
	public BLCreditCardBean fetchCreditCardDetails(String companyCode) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		
		BLCreditCardBean creditBean = new BLCreditCardBean();
		try
		{

			String sql = "SELECT CREDIT_CO_CODE, CREDIT_CO_NAME, BRANCH_NAME FROM BL_CREDIT_COMPANY WHERE CREDIT_CO_CODE = ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, companyCode);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				creditBean.setCompanyCode(rs.getString(1));
				creditBean.setCompanyName(rs.getString(2));
				creditBean.setBranchName(rs.getString(3));
			}
		}	
		catch(Exception e)
		{
			System.out.println("Exception from fetchCreditCardDetails()= :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		
		
		return creditBean;
	}


	public String getCompanyCode() {
		return BLHelper.checkForNull(companyCode);
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getCompanyName() {
		return BLHelper.checkForNull(companyName);
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getBranchName() {
		return BLHelper.checkForNull(branchName);
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getNewRow() {
		if("".equals(getCompanyCode()))
		{
			return "Y";
		}
		return "N";
	}


	public void setNewRow(String newRow) {
		this.newRow = newRow;
	}

}