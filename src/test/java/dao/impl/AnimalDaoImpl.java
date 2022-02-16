package dao.impl;

import dao.AnimalDao;
import entity.Animal;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AnimalDaoImpl implements AnimalDao {

    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }


    @Override
    public Animal add(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(animal);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return animal;
    }

    @Override
    public Animal update(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        animal.setAge(animal.getAge()+15);
        session.update(animal);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка. Транзакція по додаванню не відбулась");
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    @Override
    public boolean delete(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal delete = session.load(Animal.class, animal.getId());
        if (delete != null) {
            session.delete(delete);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Animal get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        try {
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Виникла помилка.Транзакція по отриманню елемента не відбулась");
            e.printStackTrace();
        }
        session.close();
        return animal;
    }
}
