package service;

import model.Person;

public interface PersonService<T extends Person> {
    void save(T t);

    void update(T t);

    void delete();

    T loadAll();

    void contain();
}
