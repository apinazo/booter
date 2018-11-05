package es.apinazo.booter.business.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Person {@link org.springframework.data.repository.Repository} with CRUD operations and.
 * <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example">
 * queries by example</a>.
 *
 * {@link QueryByExampleExecutor} enables queries by example using {@link org.springframework.data.domain.Example}
 * and {@link org.springframework.data.domain.ExampleMatcher}.
 *
 * {@link PagingAndSortingRepository} allows paging and sorting capabilities to all CRUD methods.
 */
public interface PersonRepository extends
    JpaRepository<Person, Integer>,
    QueryByExampleExecutor<Person>,
    PagingAndSortingRepository<Person, Integer> {

    /**
     * Finds the single person having the given Personal ID.
     *
     * @param personalId Personal ID of the {@link Person}.
     * @return The {@link Person}.
     */
    Person findByPersonalId(String personalId);

}
