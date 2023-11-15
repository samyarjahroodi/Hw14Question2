package repository;

import model.Person;

public interface PersonRepository<T extends Person> {
    void save(T t);

    void update(long number, T t);

    void deleteById(long id);

    T loadAll(long code);

    boolean contains(long number);
}
