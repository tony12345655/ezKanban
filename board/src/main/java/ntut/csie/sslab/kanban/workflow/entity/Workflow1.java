package ntut.csie.sslab.kanban.workflow.entity;

import ntut.csie.sslab.ddd.model.AggregateRoot;
import ntut.csie.sslab.kanban.workflow.entity.event.Workflow1Created;

public class Workflow1 extends AggregateRoot<String> {
    private final String id;
    private final String name;

    public Workflow1(String id, String name) {
        super(id);
        this.id = id;
        this.name = name;
        addDomainEvent(new Workflow1Created(id, name));
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
