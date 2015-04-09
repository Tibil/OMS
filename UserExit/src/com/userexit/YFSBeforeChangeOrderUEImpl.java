/**
 * 
 */
package com.userexit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSBeforeChangeOrderUE;

/**
 * YFSBeforeChangeOrderUEImpl:This class is used for adding instructions using YFSBeforeChangeOrderUE
 * All rights reserved by tibil
 * @copyright Copyright 2014, TibilSolutions
 * @author Kavitha
 * @package com.userexit 
 * 
 */
public class YFSBeforeChangeOrderUEImpl implements YFSBeforeChangeOrderUE{

	/* (non-Javadoc)
	 * @see com.yantra.yfs.japi.ue.YFSBeforeChangeOrderUE#beforeChangeOrder(com.yantra.yfs.japi.YFSEnvironment, org.w3c.dom.Document)
	 */
	@Override
	public Document beforeChangeOrder(YFSEnvironment arg0, Document arg1)
			throws YFSUserExitException {
		// TODO Auto-generated method stub
		//getting the root element of the order
		Element inputCreateOrder = (Element) arg1.getDocumentElement();		
		//creating new element for instructions
		  Element eleInstructions = arg1.createElement("Instructions");
		//creating new element for instruction and setting the attribute for the element
		  Element eleInstruction = arg1.createElement("Instruction");
		  eleInstruction.setAttribute("Action", "ADD");
          //getting the enterprisecode attribute
		  String enterpiseCode = inputCreateOrder.getAttribute("EnterpriseCode");
		  //checking the enterprise code and setting instructions based on the enterprisecode
		  if (enterpiseCode != null && enterpiseCode.equals("Matrix")) {
		   eleInstruction.setAttribute("InstructionText",
		     "This order belongs to Matrix enterprise");
		  }
		  if (enterpiseCode != null && enterpiseCode.equals("Matrix-B")) {
		   eleInstruction.setAttribute("InstructionText",
		     "This order belongs to Matrix-B enterprise");
		  }
		  if (enterpiseCode != null && enterpiseCode.equals("Matrix-R")) {
		   eleInstruction.setAttribute("InstructionText",
		     "This order belongs to Matrix-R enterprise");
		  }

		  eleInstructions.appendChild(eleInstruction);
		  inputCreateOrder.appendChild(eleInstructions);

		 
		return arg1;
	}

}
