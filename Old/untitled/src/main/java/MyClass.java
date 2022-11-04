class MyClass {

    public int add(int a, int b) {
        return a + b;
    }


//    public Customer findByCustomerId(Integer id) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//        String hql = "FROM Customer c where c.id = :custId";
//        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
//        query.setParameter("custId", id);
//        Customer result = query.getSingleResult();
//
//        t.commit();
//        factory.close();
//        session.close();
//        return result;
//    }
}


//
//    Query A - Select e.* from employees e, customers c where e.employeeNumber = c.salesRepEmployeeNumber and c.customerNumber = 112;
//
//
//        Query B - Select e from Employee e, Customer c where e.employeeNumber = c.salesRep.employeeNumber and c.id = :custNum";
//
