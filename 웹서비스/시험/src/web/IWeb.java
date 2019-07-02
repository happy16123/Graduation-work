package web;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace="http://web.class.inje.ac.kr")
@SOAPBinding(style=Style.RPC)
public interface IWeb {
	@WebMethod int insertData(Row data);
	
	@WebMethod ArrayList<Row> selectData(String price);
 
}
