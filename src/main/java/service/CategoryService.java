package service;

import entity.Category;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by us8610 on 06.11.14.
 */
public class CategoryService {


    public Category getById (int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Category) session.get(Category.class, id);
    }


    public List<Category> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createQuery("from Category").list();
    }
}
