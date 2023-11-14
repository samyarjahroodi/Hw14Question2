package repository;

import model.Person;

public interface PersonRepository<T extends Person> {
    void save(T t);

    void update(T t);

    void deleteById(long id);

    T loadAll(long id);


    boolean contains(int number);
}
