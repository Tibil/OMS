/**
 * 
 */
package com.userexit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yantra.yfs.japi.YFSEnvironment;
import com.yantra.yfs.japi.YFSUserExitException;
import com.yantra.yfs.japi.ue.YFSBeforeCreateOrderUE;

/**
 * YFSBeforeCreateOrderUEImpl:This class is used for changing the OrderNo before creating order with the prefix value based on the enterprisecode  using YFSBeforeCreateOrderUE
 * All rights reserved by tibil
 * @copyright Copyright 2014, TibilSolutions
 * @author Kavitha
 * @package com.userexit 
 */
public class YFSBeforeCreateOrderUEImpl implements YFSBeforeCreateOrderUE{

	/* (non-Javadoc)
	 * @see com.yantra.yfs.japi.ue.YFSBeforeCreateOrderUE#beforeCreateOrder(com.yantra.yfs.japi.YFSEnvironment, java.lang.String)
	 */
	@Override
	public String beforeCreateOrder(YFSEnvironment arg0, String arg1)
			throws YFSUserExitException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yantra.yfs.japi.ue.YFSBeforeCreateOrderUE#beforeCreateOrder(com.yantra.yfs.japi.YFSEnvironment, org.w3c.dom.Document)
	 */
	@Override
	public Document beforeCreateOrder(YFSEnvironment arg0, Document arg1)
			throws YFSUserExitException {
		// TODO Auto-generated method stub
        //get the root element of input xml
		Element inputCreateOrder = (Element) arg1.getDocumentElement();
		//getting the enterprise code attribute of the order element
		String enterpiseCode = inputCreateOrder.getAttribute("EnterpriseCode");
		//checking the Enterprise Code
		if(enterpiseCode != null && enterpiseCode.equals("Matrix")) {
			String strOrderNo = inputCreateOrder.getAttribute("OrderNo");
			//appending the value with the order number
			inputCreateOrder.setAttribute("OrderNo", "Mat".concat(strOrderNo));
		}
		if(enterpiseCode != null && enterpiseCode.equals("Matrix-B")) {
			String strOrderNo = inputCreateOrder.getAttribute("OrderNo");
			inputCreateOrder.setAttribute("OrderNo", "MatB".concat(strOrderNo));
		}
		if(enterpiseCode != null && enterpiseCode.equals("Matrix-R")) {
			String strOrderNo = inputCreateOrder.getAttribute("OrderNo");
			inputCreateOrder.setAttribute("OrderNo", "MatR".concat(strOrderNo));
		}


		return arg1;
	}

}
