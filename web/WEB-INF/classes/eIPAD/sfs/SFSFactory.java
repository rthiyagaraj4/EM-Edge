/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.sfs;

import eIPAD.HealthObjects.SFSContext;
import eIPAD.sfs.impl.PractitionerSFSImpl;
import eIPAD.sfs.impl.SpecialitySFSImpl;
import eIPAD.sfs.impl.NursingUnitSFSImpl;
/**
 * This is a factory to return the SFS implementations
 * This is a singleton class
 * @author NavyaI
 *
 */
public class SFSFactory {

	/**
	 * static instance of this class
	 */
	private static SFSFactory s_instance = null;
	
	/**
	 * private constructor of the class
	 * Does nothing as of now
	 */
	private SFSFactory(){
		
	}
	
	/**
	 * This is the method to get an instance of this class
	 * All classes which need to use this class need
	 * to call this method
	 * @return
	 */
	public static SFSFactory getInstance(){
		if(s_instance == null){
			s_instance = new SFSFactory();
		}
		return s_instance;
	}
	
	/**
	 * This is the main public method in this class
	 * This method returns the SFS instace depending
	 * on the inputs to this method.
	 * TODO input for this method needs to be decided by Navya
	 * @return
	 */
	public SFS getSFSInstance(SFSContext oSFSContext){
		// the code will be a if else loop or a switch case block
		// where checks will be done and then the individual
		// implementations of the SFS will be instantiated
		SFS sfsInst = null;
		int type = oSFSContext.getType();
		switch(type)
		{
		case 5 : sfsInst = new SpecialitySFSImpl();
		break;
		case 4 : sfsInst = new PractitionerSFSImpl();
		break;
		case 6 : sfsInst = new NursingUnitSFSImpl();
		break;
		case SFSContext.SPECIALITY : sfsInst = new SpecialitySFSImpl();
		break;
		default : 
		break;
		
		}
		
		
		return sfsInst;
		
	}
	
}
