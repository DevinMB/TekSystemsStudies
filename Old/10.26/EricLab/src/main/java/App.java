
import com.dmb.dao.OrderDAO;
import com.dmb.model.Order;
import com.dmb.model.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {


    public static void main(String[] args) {

        OrderDAO orderDAO = new OrderDAO();

        Order foundOrder = orderDAO.findByOrderNumber(10010);

        System.out.println(foundOrder.toString());

        foundOrder.setStatus("PENDING");

        orderDAO.save(foundOrder);

        Order changedOrder = orderDAO.findByOrderNumber(10010);

        System.out.printf(changedOrder.toString());



//
//        String hql2 = "FROM OrderDetail";
//        Query query2 = session.createQuery(hql2);
//
//        List<OrderDetail> results2 = query2.getResultList();
//
//        for (OrderDetail o : results2) {
//            System.out.println(o.getOrderNumber() + " " + o.getOrderLineNumber() );
//        }

    }
}
