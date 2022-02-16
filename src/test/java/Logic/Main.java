package Logic;

import dao.AnimalDao;
import dao.impl.AnimalDaoImpl;
import entity.Animal;
import lombok.Data;

@Data
public class Main {
    private static AnimalDao animalDao = new AnimalDaoImpl();

    public static void main(String[] args) {

        Animal animal = Animal.builder().
                id(10).
                age(15).
                name("monster").
                tail(true).
                build();

        animalDao.add(animal);

        System.out.println(animalDao.get(5));
        animal.setAge(85);
        animalDao.update(animal);
        System.out.println(animalDao.get(10));
        animalDao.delete(animal);
    }
}
