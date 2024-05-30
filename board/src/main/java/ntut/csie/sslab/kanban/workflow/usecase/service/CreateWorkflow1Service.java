package ntut.csie.sslab.kanban.workflow.usecase.service;

import ntut.csie.sslab.ddd.usecase.DomainEventBus;
import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.ddd.usecase.cqrs.ExitCode;
import ntut.csie.sslab.kanban.workflow.adapter.out.repository.Workflow1RepositoryInMemory;
import ntut.csie.sslab.kanban.workflow.entity.Workflow1;
import ntut.csie.sslab.kanban.workflow.usecase.port.in.create.CreateWorkflow1Input;
import ntut.csie.sslab.kanban.workflow.usecase.port.in.create.CreateWorkflow1UseCase;


public class CreateWorkflow1Service implements CreateWorkflow1UseCase {
    private final Workflow1RepositoryInMemory repository;
    private final DomainEventBus domainEventBus;

    public CreateWorkflow1Service(Workflow1RepositoryInMemory repository, DomainEventBus domainEventBus){
        this.repository = repository;
        this.domainEventBus = domainEventBus;
    }
    public CqrsOutput execute(CreateWorkflow1Input input){
        Workflow1 workflow1 = new Workflow1(input.id, input.name);
        repository.save(workflow1);
        domainEventBus.postAll(workflow1);
        return CqrsOutput.create().setId(workflow1.getId()).setExitCode(ExitCode.SUCCESS);
    }
}
