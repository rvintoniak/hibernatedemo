import entity.Activity;
import entity.Category;
import org.hibernate.Session;
import service.CategoryService;
import util.HibernateUtil;

/**
 * Created by roman on 05.11.14.
 */
public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Category category = new Category();
        category.setName("Math");

        Activity activity = new Activity();
        activity.setCategory(category);
        activity.setName("first_act");

        Activity activity1 = new Activity();
        activity1.setCategory(category);
        activity1.setName("second_act");

        category.getActivities().add(activity);
        category.getActivities().add(activity1);

        session.save(category);

        session.getTransaction().commit();

        CategoryService categoryService = new CategoryService();
        for(Category c :categoryService.getAll()){
            for (Activity a : c.getActivities()){
                System.out.println(a.getName());
            }
        };

        System.out.println(categoryService.getById(3));

        HibernateUtil.shutdown();


    }
}
