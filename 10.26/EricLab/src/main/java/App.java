
import com.dmb.model.Order;
import com.dmb.model.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class App {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Order";
        Query query = session.createQuery(hql);

        List<Order> results = query.getResultList();

        for (Order o : results) {
            System.out.println(o.getOrderNumber());
        }


        String hql2 = "FROM OrderDetail";
        Query query2 = session.createQuery(hql2);

        List<OrderDetail> results2 = query2.getResultList();

        for (OrderDetail o : results2) {
            System.out.println(o.getOrderNumber() + " " + o.getOrderLineNumber() );
        }

    }
}
