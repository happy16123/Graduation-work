package transfer;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace="http://test.class.inje.ac.kr")
@SOAPBinding(style=Style.RPC)
public interface IDataTransfer {
	@WebMethod void putData(ArrayList<Person> list);

	@WebMethod public ArrayList<Person> getData();

	@WebMethod void updateData(String name, String age, String address);

	@WebMethod void deleteData(String name);

	@WebMethod void getDataObject(Person person);
}
