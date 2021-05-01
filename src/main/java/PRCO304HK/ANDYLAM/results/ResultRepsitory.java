package PRCO304HK.ANDYLAM.results;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepsitory extends CrudRepository<Result, Integer> {

    public List<Result> findByContestId(int id);
}
