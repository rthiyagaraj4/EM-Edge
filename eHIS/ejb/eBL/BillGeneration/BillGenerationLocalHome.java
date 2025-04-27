package eBL.BillGeneration;


import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.response.BillGenerationResponse;


public interface BillGenerationLocalHome extends EJBLocalHome{

	public BillGenerationLocal create() throws CreateException;
}
