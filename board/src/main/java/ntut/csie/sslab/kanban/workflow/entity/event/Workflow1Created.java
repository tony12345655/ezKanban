package ntut.csie.sslab.kanban.workflow.entity.event;

import ntut.csie.sslab.ddd.model.DomainEvent;
import ntut.csie.sslab.ddd.model.common.DateProvider;

import java.util.Date;

public class Workflow1Created extends DomainEvent {

    private final String workFlow1Id;
    private final String workFlowName;
    public Workflow1Created(String id, String name) {
        super(DateProvider.now());
        this.workFlow1Id = id;
        this.workFlowName = name;
    }
    public String workFlow1Id() {
        return workFlow1Id;
    }
    public String workFlowName() {
        return workFlowName;
    }
}
