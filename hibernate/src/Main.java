import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main{
	
	
	public static void main(String[]args){
		long id=1;
		SessionFactory fact= HibernateUtil.getSessionFactory();
		Session session= fact.openSession();
		org.hibernate.Transaction transaction=null;
		try {
			transaction= session.beginTransaction();
		   /* Employee e1= new Employee();
		    e1.setName("satish");
		    e1.setAddress("deoria");
		    session.save(e1); */
			/*Employee e2=(Employee)session.get(Employee.class, id);
			e2.setName("abc");
			e2.setAddress("lko");
			session.update(e2);*/
			Criteria crit=session.createCriteria(Employee.class);
			List<Employee>e=crit.list();
			for(Employee emp:e){
	System.out.println(emp.getId()+ " "+emp.getName()+" "+emp.getAddress());  
			}
		    transaction.commit();
		    System.out.println("successfully");
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}
}