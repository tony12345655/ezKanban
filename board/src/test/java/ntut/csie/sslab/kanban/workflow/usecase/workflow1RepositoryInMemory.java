package ntut.csie.sslab.kanban.workflow.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class workflow1RepositoryInMemory {
    private final List<Workflow1> store = new ArrayList<>();

    public void save(Workflow1 workflow1){
        store.add(workflow1);
    }

    public Optional<Workflow1> findById(String id){
        return store.stream().filter(w -> w.getId().equals(id)).findFirst();
    }
}
