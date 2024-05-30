package ntut.csie.sslab.kanban.workflow.adapter.out.repository;

import ntut.csie.sslab.ddd.usecase.AbstractRepository;
import ntut.csie.sslab.kanban.workflow.entity.Workflow1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Workflow1RepositoryInMemory implements AbstractRepository<Workflow1,String> {
    private final List<Workflow1> store = new ArrayList<>();

    public void save(Workflow1 workflow1){
        store.add(workflow1);

    }

    @Override
    public void deleteById(String s) {
        throw new RuntimeException("no implement");
    }

    public Optional<Workflow1> findById(String id){
        return store.stream().filter(w -> w.getId().equals(id)).findFirst();
    }
}
