package employeedb;



public class App {
	
public static void main(String[] args) throws Exception {
	
	HibernateUtil.configure();
    EmployeeHibernateApi api = new EmployeeHibernateApi();
    
    //Delete All employee
    api.DeleteAll();
    
    //Creating N employee
    for(int i = 0;i<5;i++) {
    	employeePojo p = new employeePojo();
    	p.setAge(i + 20);
    	p.setId(i);
    	p.setName("username" + i);
    	api.Insert(p);
    }
    
    //Print all employee
    api.printAll();
}

}
